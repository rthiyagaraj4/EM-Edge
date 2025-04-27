<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<html>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String finalString = request.getParameter("finalString")==null?"":request.getParameter("finalString");
%>
		<title><fmt:message key="Common.PerformingLocation.label" bundle="${common_labels}"/></title>
		<iframe name='list_top' id='list_top' src="UserForReportingFrameTop.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:45vh;width:100vw'></iframe>
			<iframe name='list_bottom' id='list_bottom' 	src="UserForReportingFrameBottom.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling=no style='height:55vh;width:100vw'></iframe>
</html>

