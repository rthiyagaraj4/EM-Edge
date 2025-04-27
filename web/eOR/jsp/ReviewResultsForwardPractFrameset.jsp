<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
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
<iframe name='ReviewResultsForwardPractSearch' id='ReviewResultsForwardPractSearch' src='ReviewResultsForwardPractSearch.jsp?<%=request.getQueryString()%>' frameborder=0  scrolling=no noresize style='height:12vh;width:97vw'></iframe>
	<iframe name='ReviewResultsForwardPractHeader' id='ReviewResultsForwardPractHeader' src='ReviewResultsForwardPractHeader.jsp' frameborder=0 noresize style='height:5vh;width:97vw'></iframe>
	<iframe name='ReviewResultsForwardPract' id='ReviewResultsForwardPract' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:71vh;width:97vw'></iframe>
	<iframe name='ReviewResultsForwardPractBtn' id='ReviewResultsForwardPractBtn' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='height:6vh;width:97vw'></iframe>

</html>

