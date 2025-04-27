<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String orderId = request.getParameter("orderId");
String called_from = request.getParameter("called_from");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<title><fmt:message key="eOR.OrderLineFormat.label" bundle="${or_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<iframe name="ViewHeaderCommentTop" id="ViewHeaderCommentTop" src="ResultEntryViewOrderFormat.jsp?orderId=<%=orderId%>&called_from=<%=called_from%>" frameborder=0  noresize style="height:85vh;width:100vw"></iframe>
	<iframe name="ViewHeaderCommentDetail" id="ViewHeaderCommentDetail" src="ViewOrderBtn.jsp" frameborder=0 noresize style="height:15vh;width:100vw"></iframe>


