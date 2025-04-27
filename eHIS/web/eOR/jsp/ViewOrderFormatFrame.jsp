<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------
	?			?				?			?				?					?
06/08/2014  IN049419		Ramesh G										An Audit Trail for Additional Information Amendment of Order	 
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ %>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId" ) ;

String lineId = request.getParameter("lineId")==null?"":request.getParameter("lineId" ) ;
String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
String orderFormatAuditTrailYN = request.getParameter("orderFormatAuditTrailYN")==null?"":request.getParameter("orderFormatAuditTrailYN"); //IN049419
if(lineId == null){
%>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<title><fmt:message key="eOR.OrderFormat.label" bundle="${or_labels}"/></title>
<%}else{%>
<title><fmt:message key="eOR.OrderLineFormat.label" bundle="${or_labels}"/></title>
<%}%>
<!--<frameset rows='*%,7%'>-->
	<iframe name='ViewHeaderCommentTop' id='ViewHeaderCommentTop' src='ViewOrderFormat.jsp?orderId=<%=orderId%>&lineId=<%=lineId%>&called_from=<%=called_from%>' frameborder=0  scrolling='auto' noresize style='height:90vh;width:99vw'></iframe>
	<!-- IN049419 Start. -->
	<!--  <frame name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewOrderBtn.jsp' frameborder=0 scrolling='no' noresize> -->
	<iframe name='ViewHeaderCommentDetail' id='ViewHeaderCommentDetail' src='ViewOrderBtn.jsp?orderId=<%=orderId%>&lineId=<%=lineId%>&orderFormatAuditTrailYN=<%=orderFormatAuditTrailYN %>' frameborder=0 scrolling='no' noresize style='height:7vh;width:99vw'></iframe>
	<!-- IN049419 End. -->
<!--  --></frameset>-->

