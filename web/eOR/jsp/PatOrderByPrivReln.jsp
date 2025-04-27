<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
25/09/2012		IN030279		Ramesh G		Bru-HIMS-CRF-160 	
04/12/2012		IN036393		Ramesh G 		MO Transactions->Manage Deceased/Body Part ->Specimen->Place Order->The Web Page title is displayed blank.							 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
 
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
	<title><fmt:message key="Common.PlaceOrder.label" bundle="${common_labels}"/></title>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	
</head>
<iframe name='framePatOrderByPrivRelnSearch' id='framePatOrderByPrivRelnSearch' src="../../eOR/jsp/PatOrderByPrivRelnSearch.jsp?<%=request.getQueryString()%>" frameborder='0' noresize scrolling='no' style="height:32vh;width:100vw"></iframe>	<!-- IN030279 End.-->
<!-- 	<iframe name="framePatOrderByPrHeaderDtl" id="framePatOrderByPrHeaderDtl" src="../../eCommon/html/blank.html"frameborder='0' noresize scrolling='no'></iframe>
 -->	
 	<iframe name='framePatOrderByPrResult' id='framePatOrderByPrResult' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='auto' style="height:58vh;width:100vw"></iframe>
	<iframe name='framePatOrderByPrColor' id='framePatOrderByPrColor' src="../../eCommon/html/blank.html" frameborder='0' noresize scrolling='no' style="height:8vh;width:100vw" ></iframe>

</html>

