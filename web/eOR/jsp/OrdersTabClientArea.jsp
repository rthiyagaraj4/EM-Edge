<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
	
<%
    request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode = request.getParameter("mode");
	String function_id = request.getParameter("function_id");
%>
<html>
<head>
</head>
	<script language="JavaScript" src="../../eOR/js/OrdersTab.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
	<!--
	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<frameset rows="0%,8%,5.5%,*" frameSpacing="0">
		<frame name="topframe" src="../../eCommon/html/blank.html" frameborder='no' scrolling='no' noresize>
		<frame name="patientClassFrame" src="OrdersTabPatientClass.jsp?patient_class= &mode=<%=mode%>&function_id=<%=function_id%>" frameborder='no' scrolling='no' noresize>
		<frame name="practitionerFrame" src="OrdersTabPractitioner.jsp?
		patient_class= &practitioner_id= " frameborder='no' scrolling='no' noresize>
		<!-- <frame name="placeOrderFrame" src="OrdersTabPlaceOrder.jsp" frameborder='no' scrolling='no' noresize> -->
		<frame name="placeOrderFrame" src="OrdersTabPlaceOrderModify.jsp?patient_class=*A &mode=<%=mode%>&func_id=*A&practitioner_id=*A" frameborder='no' scrolling='no' noresize> 
		
<!--	</frameset>-->
 
</html>

