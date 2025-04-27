
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<html>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String from = request.getParameter("from")==null?"":request.getParameter("from");
//	String finalString = request.getParameter("finalString")==null?"":request.getParameter("finalString");
	
		if(from.equals("L")){
%>
		<title><fmt:message key="Common.List.label" bundle="${common_labels}"/></title>
	<%}else if(from.equals("R")){%>
	<title><fmt:message key="eOR.RadioGroup.label" bundle="${or_labels}"/></title>
	<%}%>
		<iframe name='list_top' id='list_top' src="OrderEntryFormatItemListTop.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='auto' noresize style='height:60vh;width:99vw'></iframe>
	    <iframe name='list_bottom' id='list_bottom' 	src="OrderEntryFormatItemListBottom.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling=no style='height:40vh;width:99vw'></iframe>
</html>

