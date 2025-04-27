<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String called_from = request.getParameter("called_from");//IN067246
%>

<html>
<head><title><fmt:message key="eOR.OrderEntryPreview.label" bundle="${or_labels}"/></title>
	<script language="JavaScript" src="../../eOR/js/OrderEntryGlobal.js"></script>	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%if(!"OP_VISIT_REG".equals(called_from)){ %>
	<iframe name="criteriaMainFrame" id="criteriaMainFrame"	  src= "../../eOR/jsp/OrderEntryRapidPreviewHeader.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="yes" style="height:28vh;width:98vw"></iframe>
		<iframe name="placeOrderDetailFrame" id="placeOrderDetailFrame"	  src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="yes" style="height:52vh;width:98vw"></iframe>
		<iframe name="criteriaDetailFrame" id="criteriaDetailFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style="height:14vh;width:98vw"></iframe>
	
<%}else{ %>
	<iframe name="criteriaMainFrame" id="criteriaMainFrame"	  src= "../../eOR/jsp/OrderEntryRapidPreviewHeader.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="yes" style="height:28vh;width:98vw"></iframe>
		<iframe name="orderTabsFrame" id="orderTabsFrame"	  src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style="height:4vh;width:100vw"></iframe>
		<iframe name="placeOrderDetailFrame" id="placeOrderDetailFrame"	  src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="yes" style="height:52vh;width:100vw"></iframe>
		<iframe name="criteriaDetailFrame" id="criteriaDetailFrame" src= "../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="no" style="height:14vh;width:98vw"></iframe>
	
<%} %>
</html>

