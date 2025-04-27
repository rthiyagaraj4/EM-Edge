<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
13/12/2012    IN036700    Vijayakumar k    In CA - Note Recording, when user click on Link Doc (LAB/RD/PH etc )Period To is system date and Period From is 14 days back
---------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
31/03/2017	IN061907	Krishna Gowtham J									ML-MMOH-CRF-0559
03/10/2017  IN061908	Krishna Gowtham	J	04/10/2017		Ramesh G		ML-MMOH-CRF-0560
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		/** added by kishore kumar n on 10/12/2008  */
		String imgUrl="";
		if(sStyle.equals("IeStyle.css"))
		 {
				imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
		 }
		 /** ends here*/
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"> -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkAlrg.js'></script> 
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
</script>
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='RecClinicalLinkAlrgCriteriaForm' id='RecClinicalLinkAlrgCriteriaForm'>
<%
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;

	String	query_title		=	"";
	String	short_desc		=	"";
	String	to_date_time		=	"";
	String  patient_id="";
	String  encounter_id="";
	String  result_linked_rec_type="";
	String  return_format="";
	String  dft_date="";
	String  sec_hdg_code="";
	String  event_type_code="";
	String  event_type_desc="";
	String event_qry ="select a.ADV_EVENT_TYPE_CODE,a.LONG_DESC from mr_adv_event_type a where a.EFF_STATUS ='E' order by LONG_DESC ";
	String dispResLinkHYMLYN="";//IN061907


	
	patient_id				=(request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	encounter_id			=(request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
	return_format			=(request.getParameter("return_format")==null)?"":request.getParameter("return_format");
	result_linked_rec_type	=(request.getParameter("result_linked_rec_type")==null)?"":request.getParameter("result_linked_rec_type");
	sec_hdg_code	=(request.getParameter("sec_hdg_code")==null)?"":request.getParameter("sec_hdg_code");
	dispResLinkHYMLYN = (request.getParameter("dispResLinkHYMLYN")==null)?"":request.getParameter("dispResLinkHYMLYN");//IN061907
	
	try
	{
		con				=	ConnectionManager.getConnection(request);

		to_date_time		=	com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		//IN036700 starts
		//dft_date			=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,7,"d");
		dft_date			=	com.ehis.util.DateUtils.minusDate(to_date_time,"DMYHM",locale,14,"d");
		//IN036700 ends

		query_title	="SELECT CR_GET_DESC.CR_HIST_REC_TYPE(?,?,'2') SHORT_DESC FROM DUAL";
	
		pstmt			=	con.prepareStatement(query_title);
		pstmt.setString(1,result_linked_rec_type);	
		pstmt.setString(2,locale);

		rs				=	pstmt.executeQuery();

		if(rs.next())
			short_desc	=	rs.getString("SHORT_DESC");

		if(rs!=null){rs.close();rs=null;}
		if(pstmt!=null){pstmt.close();pstmt=null;}
%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" >
<tr>
	<td class='columnheader'  colspan=4><b><%=short_desc%></b></td>
</tr>	

<tr>
		<td  width='25%' class="LABEL" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'><input type='text'  name='from_date_time' id='from_date_time' value="<%=dft_date%>" size='14' maxLength='16'  onBlur='checkPeriodFromTo(this,to_date_time,"<%=to_date_time%>","DMYHM","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');"></td>
		<td width='25%' class="LABEL" ><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'><input type='text'  name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16'  onBlur='checkPeriodFromTo(from_date_time,this,"<%=to_date_time%>","DMYHM","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');"></td>
</tr>
<tr>		
		<td  width='25%' class="label" ><input type="radio" name="status" id="status" value='AT' onClick="" checked ><fmt:message key="Common.active.label" bundle="${common_labels}"/></td> <td><input type="radio" name="status" id="status"  onClick="" value='Al'><fmt:message key="Common.all.label" bundle="${common_labels}"/> </td>
		<td  class="label" width="25%"><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></td> 
		<td  width='25%' class='fields'><select name="allergy_type" id="allergy_type" >
						<option value=""> &nbsp;&nbsp;--- --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--- ---&nbsp;&nbsp; </option>
					<%
						
						pstmt			=	con.prepareStatement(event_qry);
						rs				=	pstmt.executeQuery();
						while(rs.next())
						{
							event_type_code = rs.getString("ADV_EVENT_TYPE_CODE")==null?"":rs.getString("ADV_EVENT_TYPE_CODE");
							event_type_desc = rs.getString("LONG_DESC")==null?"":rs.getString("LONG_DESC");

							out.println("<option value='"+event_type_code+"'>"+event_type_desc+"</option>");

						}

						if(rs != null)
						{
							rs.close();
						}

						if(pstmt != null)
						{
							pstmt.close();
						}

					%>

					<!--	 <option value="D"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/> </option>
						<option value="F"><fmt:message key="Common.Food.label" bundle="${common_labels}"/> </option>
						<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/> </option>
						<option value="I"><fmt:message key="Common.Inhalant.label" bundle="${common_labels}"/></option>
						<option value="T"><fmt:message key="Common.Topical.label" bundle="${common_labels}"/></option>  -->
				
						</select></td>		
</tr>
<tr>					
				<%
				
				}
				catch(Exception e)
			{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
                          e.printStackTrace();//COMMON-ICN-0181
			}
					
					
					finally 
					{
						if(rs != null)
						{
							rs.close();
						}
						if(pstmt != null)
						{
							pstmt.close();
						}
		
						ConnectionManager.returnConnection(con,request);
					}
					
					%>

					<!--	<td class=label colspan=4 align='left' >
        
        </td> -->
		<!-- <td class="LABEL" align="RIGHT" nowrap colspan="4">Search Criteria</td>
		<td>&nbsp;<select name="search_criteria" id="search_criteria" >
		<option value='S'>Starts with</option>
		<option value='C'>Contains</option>
		<option value='E'>Ends with</option></td> -->
		
		<td class="LABEL" width='25%'  ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'><select name="order_by1" id="order_by1" >
		<option value='O'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></option>
		<option value='A' selected ><fmt:message key="Common.AllergyType.label" bundle="${common_labels}"/></option></select>
		<select name="order_by2" id="order_by2" >
		<option value='AS'><fmt:message key="Common.ascending.label" bundle="${common_labels}"/></option>
		<option value='DE'><fmt:message key="Common.descending.label" bundle="${common_labels}"/></option></select></td>
		<td width='25%' colspan="2"></td>
</tr>
<tr>		
						
    <!-- <td width='80%' colspan=2>&nbsp;</td> -->
	<td width='25%' colspan="3"></td>
	<td width='25%'align='right'> 
	<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="showSearchLinkResult()">&nbsp;&nbsp;<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='BUTTON' onClick="clearClick()"></td>
	
	</tr>
	</table>
	<!-- added by kishore kumar n on 10/12/2008  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->			
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="result_linked_rec_type" id="result_linked_rec_type" value="<%=result_linked_rec_type%>">
<input type="hidden" name="sec_hdg_code" id="sec_hdg_code" value="<%=sec_hdg_code%>">
<input type="hidden" name="return_format" id="return_format" value="<%=return_format%>">
<input type="hidden" name="dispResLinkHYMLYN" id="dispResLinkHYMLYN" value="<%=dispResLinkHYMLYN%>"><!--IN061907-->
<!--IN061908 Start-->
<script>
	showSearchLinkResult();
</script>
<!--IN061908 End-->
</form>
</center>
</body>
</html>

