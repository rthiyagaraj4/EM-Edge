<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<HTML>
<Head><title><fmt:message key="eOR.CopyOrders.label" bundle="${or_labels}"/></title>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</Head>
<iframe name='CopyOrdersSearch' id='CopyOrdersSearch' src='CopyOrdersSearch.jsp?<%=request.getQueryString()%>' frameborder=0  scrolling=no noresize style='height:30vh;width:99vw'></iframe>
	<iframe name='CopyOrdersHdr' id='CopyOrdersHdr' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no noresize style='height:5vh;width:99vw'></iframe>
	<iframe name='CopyOrdersResults' id='CopyOrdersResults' src='../../eCommon/html/blank.html' frameborder=0 scrolling=yes noresize style='height:30vh;width:99vw'></iframe>
	<iframe name='CopyOrdersResultsBottom' id='CopyOrdersResultsBottom' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto style='height:24vh;width:99vw'></iframe>
	<iframe name='CopyOrdersBtn' id='CopyOrdersBtn' src='../../eCommon/html/blank.html' frameborder=0 scrolling=no style='height:5vh;width:99vw'></iframe>
</HTML>

