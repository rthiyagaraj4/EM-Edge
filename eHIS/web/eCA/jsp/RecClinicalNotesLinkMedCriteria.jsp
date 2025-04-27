<!DOCTYPE html>
<%
/*
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
11/12/2012   IN036700    Vijayakumar k    In CA - Note Recording, when user click on Link Doc (LAB/RD/PH etc )Period To is system date and Period From is 14 days back
-----------------------------------------------------------------------------------------------
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
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkMed.js'></script> 
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='RecClinicalLinkMedCriteriaForm' id='RecClinicalLinkMedCriteriaForm'>

<%
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;

	String	query_title		="";
	String	short_desc12		="";
	String	to_date_time		=	"";
	String patient_id="";
	String encounter_id="";
	String  result_linked_rec_type="";
	String  sec_hdg_code="";
	String query_class="";
	String patient_class="";
	String short_desc="";
	String dft_date="";
	String return_format="";
	String query_order="";
	String orderstatuscode="";
	String longdesc="";
	String dispResLinkHYMLYN="";//IN061907
	
	
	patient_id=(request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	encounter_id=(request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
	return_format=(request.getParameter("return_format")==null)?"":request.getParameter("return_format");
	result_linked_rec_type=(request.getParameter("result_linked_rec_type")==null)?"":request.getParameter("result_linked_rec_type");
	dispResLinkHYMLYN = (request.getParameter("dispResLinkHYMLYN")==null)?"":request.getParameter("dispResLinkHYMLYN");//IN061907

	sec_hdg_code=(request.getParameter("sec_hdg_code")==null)?"":request.getParameter("sec_hdg_code");
	
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
			short_desc12	=	rs.getString("SHORT_DESC");

		if(rs!=null){rs.close();rs=null;}
		if(pstmt!=null){pstmt.close();pstmt=null;}
%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
<tr>
	<td class='columnheader' colspan=4 ><b><%=short_desc12%></b></td>
</tr>	

<tr>
		<td class="label" width='25%'><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td class="fields"  width='25%'><input type='text'  name='from_date_time' id='from_date_time' value="<%=dft_date%>" size='14' maxLength='16'  onBlur='chkDateTime(this,"DMYHM","<%=locale%>"); return checkPeriodFromTo(this,to_date_time,"DMYHM","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date_time');"></td>
		<td class="label"  width='25%' ><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%' ><input type='text'  name='to_date_time' id='to_date_time' value="<%=to_date_time%>" size='14' maxLength='16'   onBlur='chkDateTime(this,"DMYHM","<%=locale%>"); return checkPeriodFromTo(from_date_time,this,"DMYHM","<%=locale%>");'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date_time');"></td>
</tr><tr>		
		<td class="label"  width='25%' ><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></td>
		<td class="fields" width='25%'><input type="radio" name="order" id="order" value="S" checked><fmt:message key="Common.self.label" bundle="${common_labels}"/> </td>
	    <td class="fields" width='25%'><input type="radio" name="order" id="order" value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></td>
		<td width='25%'>&nbsp;</td>
		</tr>
       <% // query_order = "select  ORDER_STATUS_CODE, LONG_DESC FROM OR_ORDER_STATUS_CODE where ORDER_STATUS_TYPE in ('03','05','10','25','30','36','56','58','45','50','93','99') ORDER BY 1";
		  query_order = "select  ORDER_STATUS_CODE, LONG_DESC FROM 	OR_ORDER_STATUS_CODE_LANG_VW where 	ORDER_STATUS_TYPE in ('03','05','10','25','30','35','36','56','58','45','50','93','99')  and language_id = ?	ORDER BY 1";
	   %>
				<tr>
				
				<td class="label" width='25%' ><fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/></td>
				<td class="fields"  width='25%'><select name="ord_status" id="ord_status">
				<option value="A"> <fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
					
                <%
                  pstmt =	con.prepareStatement(query_order);
				  pstmt.setString(1,locale);
 				  rs		=	pstmt.executeQuery();

				while(rs.next())
					{
						orderstatuscode	=	rs.getString("ORDER_STATUS_CODE");
						longdesc	=	rs.getString("LONG_DESC");
					%>
					<option value="<%=orderstatuscode%>"><%=longdesc%></option>
					<%
					}
					
					
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				%> 
				</select>
				</td>		
				<td class="label" width='25%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
				<td class="fields"  width='25%'  ><select name="patient_class" id="patient_class">
						<!-- <option value="IP">Inpatient&nbsp;&nbsp;&nbsp;&nbsp;</option> 
						<option value="OP">Outpatient&nbsp;&nbsp;&nbsp;&nbsp;</option> 
						<option value="B" selected>Both</option> --> 
						<option value="A"> <fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
					<%
					
					//query_class	=	" select PATIENT_CLASS,short_DESC FROM am_patient_class order  by 2 ";
					query_class	=	"select PATIENT_CLASS,short_DESC FROM 	am_patient_class_lang_Vw where language_id = ? 	order  by 2";

					pstmt			=	con.prepareStatement(query_class);
					pstmt.setString(1,locale);
					rs				=	pstmt.executeQuery();

				while(rs.next())
					{
						patient_class	=	rs.getString("PATIENT_CLASS");
						short_desc	=	rs.getString("short_DESC");
					%>
					<option value="<%=patient_class%>"><%=short_desc%></option>
					<%
					}
					if(rs!=null){rs.close();rs=null;}
					if(pstmt!=null){pstmt.close();pstmt=null;}
					}
						catch(Exception e)
					{

						//out.println("Exception@1: "+e);//COMMON-ICN-0181
                                                     e.printStackTrace();//COMMON-ICN-0181
					}
					finally 
					{
						
						if(con!=null)
						ConnectionManager.returnConnection(con,request);
					}
		
		
		%>
					
					</select>
				</td>
				
				</tr><tr>
				<td  class='label' width='25%' ><fmt:message key="eCA.LimittoCurrentEncounter.label" bundle="${ca_labels}"/>
	&nbsp<input type='checkbox'  name='current_encounter' id='current_encounter' checked value="Y"> </td>
	             
				<td class="LABEL" width='25%'>&nbsp;</td>
	            <td class="LABEL" width='25%' >&nbsp;</td>
				<td width='25%' align='right'>
	<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="showSearchLinkResult()">
	<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='BUTTON' onClick="clearClick()"></td>
	
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
<input type="hidden" name="return_format" id="return_format" value="<%=return_format%>">
<input type="hidden" name="sec_hdg_code" id="sec_hdg_code" value="<%=sec_hdg_code%>">
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

