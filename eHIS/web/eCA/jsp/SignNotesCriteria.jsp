<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------------------
?           100         	?										created
15/09/2015  IN057492		VijayakumarK	16/09/2015	Dinesh T	PMG2015-CRF-AAKH-CA-0001
--------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.SignNotes.label" bundle="${ca_labels}"/></title>
	
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			/** added by kishore kumar n on 27/11/2009  */
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/

				
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCA/js/SignNotes.js'></script>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con  = null;
	PreparedStatement stmtLen = null,pstmt = null;
	ResultSet rsetLen= null, rs = null;
	String PatIDLen ="";
	try
	{
		//new 
		String sqlLen ="Select PATIENT_ID_LENGTH from mp_param";
		//new
		con = ConnectionManager.getConnection(request);
		stmtLen = con.prepareStatement(sqlLen);
		rsetLen	= stmtLen.executeQuery();
		while(rsetLen.next())
			{
			PatIDLen   = (rsetLen.getString("PATIENT_ID_LENGTH")==null)?"0":rsetLen.getString("PATIENT_ID_LENGTH");
			}
		if(rsetLen !=null) rsetLen.close();
		if(stmtLen !=null)stmtLen.close();
		
		String 	clinicianid	=	(String)	session.getValue("ca_practitioner_id");
		Properties p = (Properties)session.getValue("jdbc");
		String locale				= (String) p.getProperty("LOCALE");
		String toDate = "";
		String frDate = "";
		toDate	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		frDate	= com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,1,"M");
		String p_called_func =request.getParameter("p_called_func")==null?"":request.getParameter("p_called_func"); //IN057492
%>
<form name="SignNotesCriteria_form" id="SignNotesCriteria_form">
<body onload='parent.SignNotesCriteriaFrame.document.getElementById("search").disabled=false;' onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<table  border="0" width="100%" cellspacing='0' cellpadding='3' align='center'>
<tr>
	<td class ='label' width='25%' ><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
	<td class ='fields' width='25%'>
	<input type='text' name='requestedBy_Desc' id='requestedBy_Desc' value='' size='20' maxlength='20'onBlur="getPractCode(this)"><input type='hidden'  name='requested_by' id='requested_by' value='ALL'><input type='Button' name='practCodeButton' id='practCodeButton' class='button' value='?' onClick='showPractWindow()'></td>
	<td  width='25%' class='label' 	><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td width='25%' class='fields'> <input type='text' width='25%' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='checkDuplicate(this)' size='<%=PatIDLen%>' maxlength='<%=PatIDLen%>' ><input type='button' name='patSearch' id='patSearch' class='button' value='?' tabIndex="4" onClick="callPatientSearch()"></td>
	</tr>
	<tr>
	
	<td class='label' width ='25%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type='textbox' name='fromDt' id='fromDt' value='<%=frDate%>' size=10 maxlength=10 onblur='checkFromToDate("F",this,toDt,"<%=toDate%>","DMY","<%=locale%>")'></input><button id="common_calendar" type="button" style="background: none; border: none; padding: 0; margin: 0; display: inline-block;" onclick="return showCalendarValidate('fromDt')"><img src="../../eCommon/images/CommonCalendar.gif" alt="Calendar Icon" style="width: 100%; height: auto; display: block;"></button>&nbsp;<input type='textbox' id='toDt' name='toDt' id='toDt' value='<%=toDate%>' size=10 maxlength=10 onblur='checkFromToDate("T",this,fromDt,"<%=toDate%>","DMY","<%=locale%>")'></input>
	<button id="common_calendar" type="button" style="background: none; border: none; padding: 0; margin: 0; display: inline-block;" onclick="return showCalendarValidate('toDt')"><img src="../../eCommon/images/CommonCalendar.gif" alt="Calendar Icon" style="width: 100%; height: auto; display: block;"></button><img src='../../eCommon/images/mandatory.gif'></img>	</input>
	</td>
	<td width='25%' >&nbsp;</td>
	<td width='25%' align='right'><input type="button" class=button name='search' id='search'  value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchForDetails()"><input type="button" class=button name='clear' id='clear'
		value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick="SignNotesClear()"></td>
	
</tr>
</table>
<!-- added by kishore kumar n on 27/11/2009  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
<input type="hidden" name="note_type_code" id="note_type_code" value="">	
<input type="hidden" name="ca_practitioner_id" id="ca_practitioner_id" value="<%=clinicianid%>">	
<input type="hidden" name="locale" id="locale" value="<%=locale%>">	
<input type="hidden" name="p_called_func" id="p_called_func" value="<%=p_called_func%>">	<!--IN057492-->
</body>
</form>
<%
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
catch (Exception e)	
{
	//out.println(e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
	finally    
	{
         if(con!=null)
			 ConnectionManager.returnConnection(con,request);
    }
%>
</html>

