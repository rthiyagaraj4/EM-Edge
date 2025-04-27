<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ConsentOrders.jsp -->
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
22/03/2012    IN29559       DineshT      Record consent criteria in TaskList function
---------------------------------------------------------------------------------------------------------------
--> 

<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ConsentOrder.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<head>
<title><fmt:message key="eOR.ConsentOrder.label" bundle="${or_labels}"/></title>
<script>function_id = "<%=request.getParameter("function_id")%>";</script>
</head>
<!--IN29559,starts-->
<%
	String calledFrom = request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");

	if(calledFrom.equals("TASK_LIST"))
	{
	%>
	<iframe name='ConsentOrderTop' id='ConsentOrderTop'	src="ConsentOrdersTop.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
		<iframe name='ConsentOrderBottom' id='ConsentOrderBottom' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe>
	
	<%
	}
	else
	{
	%>
	<!--IN29559.ends-->
	<iframe name='ConsentOrderTop' id='ConsentOrderTop'	src="ConsentOrdersTop.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling='no' noresize style='height:12vh;width:100vw'></iframe>
		<iframe name='ConsentOrderBottom' id='ConsentOrderBottom' src="../../eCommon/html/blank.html" frameborder=0 scrolling='no' noresize style='height:86vh;width:100vw'></iframe>
	
	<!--IN29559,starts-->
	<%
	}
%>
<!--IN29559,ends-->
</html>

