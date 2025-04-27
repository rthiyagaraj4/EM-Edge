<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
<head>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
    <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/NewProcedure.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>
<%
String Patient_Id		= checkForNull(request.getParameter("patient_id"));
String patient_class	= checkForNull(request.getParameter("patient_class"));
String Encounter_Id		= checkForNull(request.getParameter("encounter_id"));
%>
 <body onKeyDown='lockKey()'>
		<form name='' id='' >
		<table border=0 cellspacing=0 cellpadding=3 width="100%" align=center>
		<tr>
			
			
			<td align='right'><input type='button' class='button' name='notes_btn' id='notes_btn' value='Notes' onclick="callClinicalNotes('','<%=Patient_Id%>','<%=patient_class%>','<%=Encounter_Id%>','')">
			<input type='button' class='button' name='record' id='record' value='Record' onclick='Record()' disabled>
			<input type='Button' class="button" name='clear' id='clear' value=' Clear '  onclick='clearform()'>
			<input type='button' class='button' name='cancel' id='cancel' value='Cancel' onclick='Cancel()'></td>
			
		</tr>
	</table>	
	<input type="hidden" name = "as_evidenced_by" value = "">
	<input type="hidden" name = "as_evidenced_by1" value = "">
	<input type="hidden" name = "patient_id" value = "">
	<input type='hidden' name='accession_num' id='accession_num' value=''>
	</form>
	</body>
</html>
		

