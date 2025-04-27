<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
22/04/2016	IN059255			Karthi L							 			ML-MMOH-CRF-0329.1
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<title><fmt:message key="Common.ForwardtoPractitioner.label" bundle="${common_labels}"/></title>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<iframe name='ReviewResultsForwardPractSearch' id='ReviewResultsForwardPractSearch' src='CAReviewResultsForwardPractSearch.jsp?<%=request.getQueryString()%>' frameborder=0  scrolling=no noresize style='height:12%;width:100vw'></iframe>
	<iframe name='ReviewResultsForwardPractHeader' id='ReviewResultsForwardPractHeader' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:5%;width:100vw'></iframe>
	<iframe name='ReviewResultsForwardPract' id='ReviewResultsForwardPract' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:*%;width:100vw'></iframe>
	<iframe name='ReviewResultsForwardPractBtn' id='ReviewResultsForwardPractBtn' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='height:6%;width:100vw'></iframe>

</html>

