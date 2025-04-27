<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- 
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Jerome
*	Created On		:	21/01/2005
* --%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCP.GeneratePlanPreview.label" bundle="${cp_labels}"/> </title>

<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/GCPGenerateCarePlan.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<!-- <script>function_id = "<%=request.getParameter("function_id")%>";</script> -->

</head>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<!-- <frameset cols='20%,*' id='previewParentFrame'> -->
<frameset cols='0%,*' id='previewParentFrame'>
	<!-- <frame name='GeneratePlanPreviewleft'	src='../../eOR/jsp/GCPGeneratePlanPreviewTree.jsp?<%=request.getQueryString()%>'  frameborder=0 scrolling='auto' noresize> -->
	<frame name='previewFrame'	src='../../eCP/jsp/GCPGeneratePlanPreviewTree.jsp?<%=request.getQueryString()%>'  frameborder=0 scrolling='auto' noresize>

	<frameset rows='*,6%'>
		<frame name='GeneratePlanPreviewRight' src='../../eCP/jsp/GCPGeneratePlanPreviewDtl.jsp?<%=request.getQueryString()%>'  frameborder=0 scrolling='auto' >
		<!-- <frame name='GeneratePlanPreviewRight' src='../../eCommon/html/blank.html'  frameborder=0 scrolling='auto' noresize> -->

		
		<frame name='GeneratePlanPreviewBtn' src='../../eCP/jsp/GCPGeneratePlanPreviewBtn.jsp?<%=request.getQueryString()%>'  frameborder=0 scrolling='no' noresize>
		
	</frameset>
	
</frameset>


</html>
