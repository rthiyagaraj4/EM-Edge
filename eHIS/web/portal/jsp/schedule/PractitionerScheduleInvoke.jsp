<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.schedule.createappointment.CreateAppointmentConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
$(document).ready(function() {
	alert("in function ");
	submitPage();
	//alert($("#ApptPreferredDate").val());
	//$("#practitionerScheduleForm").attr("action","./PractitionerScheduleServlet");
	//$("#practitionerScheduleForm").submit();
});

function submitPage(){
	alert("in submit function ");
	var formComp = document.getElementById("practitionerScheduleForm");
	if(formComp){
		alert("form is initialized");
		formComp.action = "./PractitionerScheduleServlet";
		formComp.submit();
	}
	//alert($("#ApptPreferredDate").val());
}

</script>
</head>
<body onload="submitPage()">
<%
	String preferredDateStr = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY);
	if (preferredDateStr == null) {
		preferredDateStr = "";
	}

	String preferredFromTime = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY);
	if (preferredFromTime == null) {
		preferredFromTime = "";
	}

	String preferredToTime = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY);
	if (preferredToTime == null) {
		preferredToTime = "";
	}

	String selectedFacilityId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY);
	if(selectedFacilityId == null){
		selectedFacilityId = "";
	}
	
	String selectedFacilityDesc = request.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY);
	if(selectedFacilityDesc == null){
		selectedFacilityDesc = "";
	}
	
	String selectedSpecialityId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY);
	if(selectedSpecialityId == null){
		selectedSpecialityId = "";
	}
	
	String selectedSpecialityDesc = request.getParameter(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY);
	if(selectedSpecialityDesc == null){
		selectedSpecialityDesc = "";
	}
	
	String practitionerId = request.getParameter(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERID_PARAMETER_KEY);
	if(practitionerId == null){
		practitionerId = "";
	}
	
	String practitionerName = request.getParameter(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERNAME_PARAMETER_KEY);
	if(practitionerName == null){
		practitionerName = "";
	}
%>
<form id="practitionerScheduleForm" method="POST">

<input type="hidden" name="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY %>" id="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY %>" id="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY %>" value="<%=preferredDateStr%>">
<input type="hidden" name="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>" value="<%=preferredFromTime%>">
<input type="hidden" name="<%=CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY%>" value="<%=preferredToTime%>">
<input type="hidden" name="<%=CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY%>" value="<%=selectedFacilityId%>">
<input type="hidden" name="<%=CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY%>" value="<%=selectedFacilityDesc%>">
<input type="hidden" name="<%=CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY%>" value="<%=selectedSpecialityId%>">
<input type="hidden" name="<%=CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY%>" value="<%=selectedSpecialityDesc%>">
<input type="hidden" name="<%=CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERID_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERID_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERID_PARAMETER_KEY%>" value="<%=practitionerId%>">
<input type="hidden" name="<%=CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERNAME_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERNAME_PARAMETER_KEY%>" id="<%=CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERNAME_PARAMETER_KEY%>" value="<%=practitionerName%>">

</form>


</body>
</html>

