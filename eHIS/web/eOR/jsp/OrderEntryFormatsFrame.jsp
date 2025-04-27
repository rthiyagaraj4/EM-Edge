
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
//	String level = request.getParameter("level")==null?"":request.getParameter("level");
//	String ord_cat = request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");
//	String finalString = request.getParameter("finalString")==null?"":request.getParameter("finalString");

	
%>
		<title><fmt:message key="eOR.FormatItem.label" bundle="${or_labels}"/></title>
		<iframe name='list_top' id='list_top' src="OrderEntryFormatTop.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:26vh;width:99vw'></iframe>
		<iframe name='list_bottom' id='list_bottom' 	src="OrderEntryFormatBottom.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling=no noresize style='height:43vh;width:99vw'></iframe>
			<!-- <iframe name='list_depend' id='list_depend' 	src="OrderEntryFormatDependency.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling=auto>  -->
		<iframe name='list_depend' id='list_depend' src="../../eCommon/html/blank.html" frameborder=0 scrolling=auto noresize style='height:30vh;width:99vw'></iframe> 
		 
</html>

