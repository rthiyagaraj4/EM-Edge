<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

<iframe name="pendingOrdersScheduleSearch" id="pendingOrdersScheduleSearch"   src="../../eOR/jsp/PendingOrdersScheduleSearch.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="no" noresize style="height:30vh;width:100vw"></iframe> 
	<iframe name="pendingOrdersScheduleHeader" id="pendingOrdersScheduleHeader"   src="../../eCommon/html/blank.html" frameborder="none" border="none" scrolling="auto" noresize style="height:8vh;width:100vw"></iframe> 
 	<iframe name="pendingOrdersScheduleResult" id="pendingOrdersScheduleResult"   src="../../eCommon/html/blank.html" frameborder="none" border="none" scrolling="auto" noresize style="height:66vh;width:100vw"></iframe> 


