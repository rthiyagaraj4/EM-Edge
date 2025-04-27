<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name        		Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
20/01/2016	  	IN057193			Karthi L											Flag For Discharge Summary Not Done								
12/07/2017		IN061885			Raja S				13/07/2017		Ramesh G		ML-MMOH-CRF-0537
----------------------------------------------------------------------------------------------------------------------------------------------------------
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
<!-- 	<script language='javascript' src='../../eCA/js/SignNotes.js'></script> -->
	<script language='javascript' src='../../eCA/js/PendDiscSummNotes.js'></script>
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
		String viewBy =request.getParameter("viewBy")==null?"":request.getParameter("viewBy");//Added for IN061885
%>
<form name="PendDiscSummCriteria_form" id="PendDiscSummCriteria_form">
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
<table  border="0" width="100%" cellspacing='0' cellpadding='3' align='center'>
<tr>
	<td  width='25%' class='label' 	><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td width='25%' class='fields'> <input type='text' width='25%' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' onBlur='checkDuplicate(this)' size='<%=PatIDLen%>' maxlength='<%=PatIDLen%>' ><input type='button' name='patSearch' id='patSearch' class='button' value='?' tabIndex="4" onClick="callPatientSearch()"></td>
	
	<td class='label' width ='25%'><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'><input type='textbox' id='fromDt' name='fromDt' id='fromDt' value='<%=frDate%>' size=10 maxlength=10 onblur='checkFromToDate("F",this,toDt,"<%=toDate%>","DMY","<%=locale%>")'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('fromDt')">&nbsp;<input type='textbox' id='toDt' name='toDt' id='toDt' value='<%=toDate%>' size=10 maxlength=10 onblur='checkFromToDate("T",this,fromDt,"<%=toDate%>","DMY","<%=locale%>")'></input><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('toDt')"><img src='../../eCommon/images/mandatory.gif'></img>	</input>
	</td>
	<tr>
	<td></td> <td></td>
	<td width='25%' >&nbsp;</td>
	<td width='25%' align='right'><input type="button" class=button name='search' id='search'  value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchForDetails()"><input type="button" class=button name='clear' id='clear'
		value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" onClick="PendDiscSummNotesClear()"></td>
	
</tr>
</table>
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<input type="hidden" name="note_type_code" id="note_type_code" value="">	
<input type="hidden" name="ca_practitioner_id" id="ca_practitioner_id" value="<%=clinicianid%>">	
<input type="hidden" name="locale" id="locale" value="<%=locale%>">	
<input type="hidden" name="viewBy" id="viewBy" value="<%=viewBy%>">	<!--Added for IN061885-->
</body>
</form>
<%
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
catch (Exception e)	
{
	//out.println(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
	finally    
	{
         if(con!=null)
			 ConnectionManager.returnConnection(con,request);
    }
%>
</html>

