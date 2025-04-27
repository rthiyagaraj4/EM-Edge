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
%>

<html>
<head><title><fmt:message key="eOR.OrderEntryTickSheet.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
</head>
	<iframe name="tickSheetFrame" id="tickSheetFrame" src= "../../eOR/jsp/OrderEntryTickSheets.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no" style="height:20vh;width:100vw"></iframe>
		<iframe name="sectionFrame" id="sectionFrame" src="../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="auto" style="height:20vh;width:100vw"></iframe>
		<iframe name="tickSheetItemFrame" id="tickSheetItemFrame" src="../../eCommon/html/blank.html" framespacing="0" noresize frameborder="0"  scrolling="auto" style="height:60vh;width:100vw"></iframe>
	
</html>

