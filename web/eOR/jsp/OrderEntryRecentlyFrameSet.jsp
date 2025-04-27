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
	<head><title><fmt:message key="eOR.OrderEntryResultMain.label" bundle="${or_labels}"/></title>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 	</head>
		<iframe name="criteriaMainSearchFrame" id="criteriaMainSearchFrame" src= "../../eOR/jsp/OrderEntryRecentlyAccessedSearchCriteria.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="no" style="height:12vh;width:100vw"></iframe>
			<iframe name="criteriaDetailResultsFrame" id="criteriaDetailResultsFrame" src= "../../eOR/jsp/OrderEntryRecentlyAccessedList.jsp?<%=request.getQueryString()%>" framespacing="0" noresize frameborder="0"  scrolling="auto" style="height:88vh;width:100vw"></iframe>
		
 </html>

 

