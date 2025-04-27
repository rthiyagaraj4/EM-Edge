<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
31/03/2017	IN061907	Krishna Gowtham J							ML-MMOH-CRF-0559
03/10/2017  IN061908	Krishna Gowtham	J	04/10/2017		Ramesh G		ML-MMOH-CRF-0560
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	EventBean.clearAll();
%>
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
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/DateCheck.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkFutureEvent.js'></script> 
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='RecClinicalLinkFutureEventCriteriaForm' id='RecClinicalLinkFutureEventCriteriaForm'>

<%
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;
	

	String	query_sys_date		=	"";
	String	query_title		="";
	String	short_desc12		="";
	String	to_date_time		=	"";
	String patient_id="";
	String encounter_id="";
	String result_linked_rec_type="";
	String  sec_hdg_code="";
	
	String dft_date="";
	String return_format="";
	String dispResLinkHYMLYN="";//IN061907

	
	
	patient_id=(request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	encounter_id=(request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
	return_format=(request.getParameter("return_format")==null)?"":request.getParameter("return_format");

	result_linked_rec_type=(request.getParameter("result_linked_rec_type")==null)?"":request.getParameter("result_linked_rec_type");
	sec_hdg_code=(request.getParameter("sec_hdg_code")==null)?"":request.getParameter("sec_hdg_code");
	dispResLinkHYMLYN = (request.getParameter("dispResLinkHYMLYN")==null)?"":request.getParameter("dispResLinkHYMLYN");//IN061907
	
	//out.println("<script>alert('encounter_id"+encounter_id+"')</script>");
	/*String function_id		=	(request.getParameter("function_id")==null)?"":request.getParameter("function_id");*/
	
	try
	{
		

		con				=	ConnectionManager.getConnection(request);

		query_sys_date	=	" select to_char(sysdate-7,'dd/mm/yyyy hh24:mi') dft_date 										 ,to_char(sysdate,'dd/mm/yyyy hh24:mi') from_date_time, "+
							" to_char(sysdate,'dd/mm/yyyy hh24:mi') to_date_time from dual ";

		pstmt			=	con.prepareStatement(query_sys_date);

		rs				=	pstmt.executeQuery();

		if(rs.next())
		{
			
			to_date_time	=	rs.getString("to_date_time");
			dft_date	=	rs.getString("dft_date");
		}
		if(rs!=null){rs.close();rs=null;}
		if(pstmt!=null){pstmt.close();pstmt=null;}
	
	    //query_title	="SELECT SHORT_DESC FROM CR_HIST_REC_TYPE WHERE HIST_REC_TYPE  =?";
		query_title	="SELECT CR_GET_DESC.CR_HIST_REC_TYPE(?,?,'2') SHORT_DESC FROM DUAL";
		pstmt			=	con.prepareStatement(query_title);
		pstmt.setString(1,result_linked_rec_type);
		pstmt.setString(2,locale);
		rs			=	pstmt.executeQuery();

		if(rs.next())
		{
			
			short_desc12	=	rs.getString("SHORT_DESC");
			
		}
		if(rs!=null){rs.close();rs=null;}
		if(pstmt!=null){pstmt.close();pstmt=null;}
	
	
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
<tr>
	<td class='columnheader'  colspan=7><b><%=short_desc12%></b></td>
</tr>	

<tr>
	    <td class="label" width='25%' ><fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/></td>
		<td class='fields' width='25%' ><select name="result_cat" id="result_cat" onchange="resCatChange(this)">
		<option value="APPT" selected><fmt:message key="eCA.FutureAppointments.label" bundle="${ca_labels}"/></option>
	    <option value="ORDR"><fmt:message key="Common.FutureOrders.label" bundle="${common_labels}"/></option> 
		<option value="REFR"><fmt:message key="eCA.FutureReferrals.label" bundle="${ca_labels}"/></option> 
		
		</select>
	    </td>

        <td class="label" width='25%' ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><select name="nature" id="nature">
		<option value="S"><fmt:message key="Common.self.label" bundle="${common_labels}"/>&nbsp;</option> 
		<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</option> 
		</select>
	    </td>
</tr>

<tr>
		<td   class="LABEL"  width='25%' id='dateNormal' style='display' ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td   class="LABEL"  width='25%' id='datePrefer' style='display:none' ><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td   class='fields' width='25%'><input type="text" name='txtFromDate' id='txtFromDate' value='' size=9 onBlur="checkDateWithCurrentDate1(this);"><input type='image'  src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('txtFromDate');" >
		</td>
		
		<td  class="LABEL"  width='25%' id='dateToNormal' style='display' ><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td  class="LABEL"  width='25%' id='dateToPrefer' style='display:none' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' ><input type="text" name="txtToDate" id="txtToDate" onBlur="checkDateWithCurrentDate1(this);" size=9><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('txtToDate');" ></td>

      <!--  <td   class='label' align='left'  nowrap></td>
        <td class='label' align='left' colspan=2 nowrap></td> -->
</tr>
<tr id='rfrdDate'  style='display:none'>

		<td   class="LABEL"  width='25%' ><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td   class='fields' width='25%'><input type="text" name='rfrdFromDate' id='rfrdFromDate' value='' size=9 onBlur="checkDateWithCurrentDate2(this);"><input type='image'  src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('rfrdFromDate');" >
		</td>
		
		<td  class="LABEL"  width='25%' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' ><input type="text" name="rfrdToDate" id="rfrdToDate" onBlur="checkDateWithCurrentDate2(this);" size=9><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('rfrdToDate');" ></td>
     
</tr>


<!--
<tr>
		<td   class="LABEL"  width='25%' id='dateNormal' style='display' ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td   class="LABEL"  width='25%' id='dateRefferal' style='display:none' ><fmt:message key="Common.ReferredDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td   class='fields' width='25%'><input type="text" name='txtFromDate' id='txtFromDate' value='' size=9 onBlur="checkDateWithCurrentDate1(this);"><input type='image'  src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('txtFromDate');" >
		</td>
		
		<td  class="LABEL"  width='25%' id='dateToNormal' style='display' ><fmt:message key="Common.periodto.label" bundle="${common_labels}"/></td>
		<td  class="LABEL"  width='25%' id='dateToRefferal' style='display:none' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' ><input type="text" name="txtToDate" id="txtToDate" onBlur="checkDateWithCurrentDate1(this);" size=9><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('txtToDate');" ></td>

      
</tr>
<tr id='prfdDate'  style='display:none'>

		<td   class="LABEL"  width='25%' ><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td   class='fields' width='25%'><input type="text" name='prfdFromDate' id='prfdFromDate' value='' size=9 onBlur="checkDateWithCurrentDate2(this);"><input type='image'  src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('prfdFromDate');" >
		</td>
		
		<td  class="LABEL"  width='25%' ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' ><input type="text" name="prfdToDate" id="prfdToDate" onBlur="checkDateWithCurrentDate2(this);" size=9><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('prfdToDate');" ></td>
     
</tr>
-->

<tr>
<td   class="label"  width='25%' ><fmt:message key="Common.DisplayOrder.label" bundle="${common_labels}"/></td>
<td   class="fields"  width='25%' >
<input type="radio" name="order" id="order" value="A" checked><fmt:message key="Common.ascending.label" bundle="${common_labels}"/>
<input type="radio" name="order" id="order" value="D"><fmt:message key="Common.descending.label" bundle="${common_labels}"/>
</td><td width='25%'></td>
<td  width='25%' align='right'> 
<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='BUTTON' onClick="showSearch()">
<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='BUTTON' onClick="clearClick()"></td>
</tr>
</table>
	<!-- added by kishore kumar n on 10/12/2008  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
<%
}
catch(Exception e)
{
//out.println("Exception@1: "+e);//common-icn-0181
e.printStackTrace();//COMMON-ICN-0181
}
finally 
{
if(con!=null)
ConnectionManager.returnConnection(con,request);
}
%>		
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
<input type="hidden" name="result_linked_rec_type" id="result_linked_rec_type" value="<%=result_linked_rec_type%>">
<input type="hidden" name="return_format" id="return_format" value="<%=return_format%>">
<input type="hidden" name="locale" id="locale" value="<%=locale%>">
<input type="hidden" name="sec_hdg_code" id="sec_hdg_code" value="<%=sec_hdg_code%>">
<input type="hidden" name="dispResLinkHYMLYN" id="dispResLinkHYMLYN" value="<%=dispResLinkHYMLYN%>"><!--IN061907-->
<!--IN061908 Start-->
<script>
	showSearch();
</script>
<!--IN061908 End-->
</form>
</body>
</html>

