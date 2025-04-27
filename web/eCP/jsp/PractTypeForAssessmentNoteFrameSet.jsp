<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--TerminologySetForPractionerTypeFrameSet.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 			:	
*	Created By		:	Suubulakshmy. K
*	Created On		:	30 Dec 2004-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
<%@ page session="false" contentType="text/html;charset=UTF-8"%>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script>function_id = "<%=request.getParameter("function_id")%>";	</script>
	<script language="javascript" src="../js/PractTypeForAssessmentNote.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<!--//This file is saved on 18/10/2005.-->
<iframe name='frameSearch' id='frameSearch' src='../jsp/PractTypeForAssessmentNoteHeader.jsp' frameborder=0 scrolling='no' style='height:35vh;width:99vw'></iframe>
<iframe name='frameResult' id='frameResult'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:55vh;width:99vw'></iframe>
	<iframe name='Dummy' id='Dummy' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' noresize style='height:0vh;width:99vw'></iframe>

</html>

