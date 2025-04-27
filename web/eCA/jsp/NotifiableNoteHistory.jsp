<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
12/05/2015	IN053733		Ramesh G		When a notifiable recorded against a notifiable diagnosis is marked in error, 
											the notification to be de-linked from the parent diagnosis								 
---------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
<head>
	<title>Recording Clinical Notes Search Result</title>
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesFileUpload.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
<center>
<form name='NotifiableNoteForm' id='NotifiableNoteForm' action="" method="" target="">
<input type="hidden" name="tempAccession_Num" id="tempAccession_Num" value=""/>
</form>
</center>
</body>
</html>

