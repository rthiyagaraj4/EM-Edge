<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--TerminologySetForPractionerTypeHeader.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*  File Name		:	PractTypeForAssessmentNoteHeader.jsp
*	Purpose 			:	
*	Created By		:	Suubulakshmy. K
*	Created On		:	30 Dec 2004-->
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../js/PractTypeForAssessmentNote.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>function_id = "<%=request.getParameter("function_id")%>";	</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='formSearch' id='formSearch'>
	<table width='100%' cellpadding='0' cellspacing='0' border='0' align='center'>
	<tr><td colspan='2'>&nbsp;</td></tr>
	<tr>
	<td width='20%' class='label' align='right'><fmt:message key="eCP.AssessmentNote.label" bundle="${cp_labels}"/></td>
		<td width='80%' class='label' align='left'>&nbsp;&nbsp&nbsp;<input type='text' size='32' maxlength='30' name='assess_note_desc' id='assess_note_desc' value='' Onblur="searchAssessNote(assess_note_desc);"><input class='button' type=button name="practTyplookup_button" id="practTyplookup_button" value="?" Onclick="searchAssessNote(assess_note_desc);">&nbsp;<img src="../../eCommon/images/mandatory.gif">
		<input type='hidden' name='assess_note_id' id='assess_note_id' value=''></td>
	</tr>
	<tr><td>&nbsp;</td>
			<td align='right'><input type='button' class='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick='searchPractType()'></tr>
	</table>
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
</form>
</body>
</html>

