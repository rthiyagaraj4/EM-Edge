<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head><title><fmt:message key="eOR.ExternalOrders.label" bundle="${or_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
</head>
<frameset rows="100%">
	<frame name='frameConsentNotes' id='frameConsentNotes' src="../../eOR/jsp/ConsentNotes.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='auto'>
	</frame>
</frameset>
</html>

