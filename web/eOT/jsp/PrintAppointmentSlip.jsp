<!DOCTYPE html>
<!-- Page created for RePrint Appointment Slips - IN34756 - Rajesh V 30/10/2012 & 37677 By MuthuN-->
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8"); %>	
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<title><fmt:message key="Common.internalreport.label" bundle="${common_labels}"/></title>
</head>
<%String Patient_ID = request.getParameter("Patient_ID");
String params = "Patient_Id="+Patient_ID;
String param = request.getQueryString();
%>

	
		<iframe name='pline' id='pline' src='../../eCommon/jsp/pline.jsp?<%=params %>' scrolling='no' noresize  style="height:15vh;width:100vw">
		</iframe>
		<iframe name='main' id='main'    src='../../eOT/jsp/PrintAppointmentSlipMain.jsp?<%=param %>' scrolling='no' noresize  style="height:20vh;width:100vw">
		</iframe>
		<iframe name='button' id='button'    src='../../eOT/jsp/PrintAppointmentSlipButton.jsp?<%=param %>' scrolling='no' noresize  style="height:65vh;width:100vw">
		</iframe>
	
<body>
</body>
</html>

