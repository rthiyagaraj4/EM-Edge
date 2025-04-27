<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>

<html>
<head>
	<script language="JavaScript" src="../js/OrdersTab.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script>-->
	<script language="JavaScript" src="../js/OrCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%@ page session="false" %>
<%
  request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode = request.getParameter("mode");
	String patient_class = request.getParameter("patient_class");
	String practitioner_id = request.getParameter("practitioner_id");
	String patient_class_desc = request.getParameter("patient_class_desc");
	String practitioner_name = request.getParameter("practitioner_name");
	String func_id = request.getParameter("func_id");
	String func_name = request.getParameter("func_name");
	String wholeString = mode + "$" + patient_class + "$" + practitioner_id + "$" + patient_class_desc+ "$"+practitioner_name+"$"+func_id+"$"+func_name;
%>
</head>
<iframe name="topframe" id="topframe" src="../../eCommon/html/blank.html" frameborder='no' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
<iframe name="patientClassFrame" id="patientClassFrame" 
src="OrdersTabPatientClass.jsp?patient_class=<%= patient_class %>&patient_class_desc=<%= patient_class_desc %>&func_id=<%=func_id%>" frameborder='no' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name="practitionerFrame" id="practitionerFrame" src="OrdersTabPractitioner.jsp?patient_class=<%= patient_class %>&practitioner_id=<%= practitioner_id%>&practitioner_name=<%=practitioner_name%>" frameborder='no' scrolling='no' noresize style='height:6vh;width:100vw'></iframe>
<iframe name="placeOrderFrame" id="placeOrderFrame" src="OrdersTabPlaceOrderModify.jsp?patient_class=
<%= patient_class %>&practitioner_id=<%= practitioner_id %>&mode=<%= mode%>&func_id=<%=func_id%>" frameborder='no' scrolling='no' noresize style='height:86vh;width:100vw'></iframe>

<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="frmAddModify" id="frmAddModify">
<input type=hidden name="wholeString" id="wholeString" value='<%= wholeString %>'>
<input type=hidden name="mode" id="mode" value='<%= mode %>'>
</form>
</body>
</html>

