<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.contactreason.common.model.ContactReasonModel"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.contactreason.cancelappointment.response.ContactReasonForCancelApptResponse"%>
<%@page import="portalrefimpl.contactreason.cancelappointment.svc.ContactReasonForCancelApptServiceInvoker"%>
<%@page import="java.util.Locale"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.schedule.common.request.AppointmentType"%>
<%@page import="portalrefimpl.contactreason.cancelappointment.request.ContactReasonForCancelApptRequest"%>
<%@page import="portalrefimpl.schedule.ScheduleConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Confirm cancel appointment :::</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../../css/style_ie.css" type="text/css"/>
<script src="../../js/jquery.min.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function cancelAppointment(appointmentNumber,appointmentStatus,facilityId){
	var cancelReasonComp = document.getElementById("cancelAppReason");
	if(cancelReasonComp){
		var selectedReasonCode = cancelReasonComp.value;
		if(selectedReasonCode.length == 0){
			alert('Please select cancellation reason');
			return false;
		}
		cancelAppointmentMain(appointmentNumber,appointmentStatus,facilityId,selectedReasonCode);
	}
	
}


</script>

</head>
<body>

<%
String appointmentNumber = request.getParameter("appointmentNumber");
String appointmentStatus = request.getParameter("status");
String specialty = request.getParameter("specialty");
String facilityId = request.getParameter("facilityId");
String practitionerName = request.getParameter("practitionerName");
String appointmentDate = request.getParameter("appointmentDate");
String startTime = request.getParameter("startTime");
String endTime = request.getParameter("endTime");

// there is a need to get the reasons for cancel appointment
ContactReasonForCancelApptRequest contactReasonRequest = new ContactReasonForCancelApptRequest();
if(ScheduleConstants.CANCELAPPT_APPT_REQUEST_TYPE_IDENTIFIER.equals(appointmentStatus)){
	contactReasonRequest.setAppointmentType(AppointmentType.Appointment_Request);
}else if(ScheduleConstants.CANCELAPPT_APPT_IDENTIFIER.equals(appointmentStatus)){
	contactReasonRequest.setAppointmentType(AppointmentType.Appointment);
}

String patientId = "";
patientId = (String) session.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
if (patientId == null) {
	patientId = (String) getServletConfig().getServletContext()
			.getAttribute("patientId");
	if (patientId == null) {
		patientId = "";
	}
}

contactReasonRequest.setPatientId(patientId);
contactReasonRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
contactReasonRequest.setLocale(Locale.getDefault().getLanguage());

/* ContactReasonForCancelApptSvcImpl svcImpl = new ContactReasonForCancelApptSvcImpl();
svcImpl.registerService(contactReasonRequest); */

ContactReasonForCancelApptServiceInvoker serviceInvoker = new ContactReasonForCancelApptServiceInvoker();
serviceInvoker.registerService(contactReasonRequest);
ContactReasonForCancelApptResponse contactReasonResponse = (ContactReasonForCancelApptResponse) serviceInvoker.getDataThroughWebService(contactReasonRequest);

/* ErrorInfo errorInfo = contactReasonResponse.getErrorInfo();
int errorCode = errorInfo.getErrorCode();
 */
String errorMessage = null;//errorInfo.getErrorMessage();
%>


<div id="popwrapperbooked">
	<div id="popheader">
		<div class="row">
				<div id="poptitle">Confirmation
		        </div>
		        <div id="close" onclick="closeConfirmCancelAppointmentPopup()">x
		        </div>
		</div>
	</div>

	<div id="popmsgboxbooked">
		<%
			if(!contactReasonResponse.isSuccessful()){
				errorMessage = contactReasonResponse.getErrorMessage();
		%>
		<div style="min-height: 25px;">
			<span class="loginerror" style="padding-left: 10px;margin-top: 5px;"><%=errorMessage %>
			</span>
		</div>
		<%
			}
		%>
		<div id="resultholder">
			<div class="row">
		        <div id="resultcell">
					<div class="bookedDetails" >
						<div class="bookedcontent" >
						<span class="contenbold"><%=practitionerName %>,</span><span class="contentnormal"> <%=specialty %></span><br/>
						<div class="popupoverflow">
							<div class="floatleft">
								<span  class="contentnormalpopup" >Appointment No</span><span class="contentnormalpopup">Appointment Date and Time</span>
							</div>
							<div class="floatleft">
								<span class="contentnormal">:&nbsp;</span><span class="contenbold"><%=appointmentNumber %></span><br>
								<span class="contentnormal">:&nbsp;</span><span class="contenbold"><%=appointmentDate %>, <%=startTime %> - <%=endTime %></span><br/>
								<!-- <span class="contentnormal">:&nbsp;</span><span class="contenbold">27 Jan 2013, 10:00 - 10.30</span><br/> -->
							</div>
						</div>
						
						</div>
					</div>
					<div class="CancelpopupFields">
						<div class="bookedcontent">
							<div class="popupoverflow">
								<div class="floatleft">
									<span  class="contentnormalCancelpopup" >Reason</span>
								</div>
								<div class="floatleft">
									<select class="Combotimesearchcancelpopup" id="cancelAppReason" name="cancelAppReason" id="cancelAppReason">
										<option value="">---- Select ----</option>
										<%
										List<ContactReasonModel> contactReasonModelList = null;
										if(contactReasonResponse.isSuccessful()){
											contactReasonModelList = contactReasonResponse.getContactReasonList();			
											if(!contactReasonModelList.isEmpty()){
												for(ContactReasonModel contactReason : contactReasonModelList){
														
										%>
										<option value="<%=contactReason.getCode() %>"><%=contactReason.getDescription() %></option>
										<%
												}
											}
										}
										%>
										
									</select>
								</div>
							</div>
						</div>
					</div>
					<span class="contentnormal">Click </span><span class="contenbold">"Ok"</span><span class="contentnormal"> to confirm details</span><br>
					<%
					String okButtonStyle = "popbtncenter";
					if(!contactReasonResponse.isSuccessful()){
						okButtonStyle = "cancelApptConfirmOkDisabled";
					}
					%>
		        	<span><a href="#"  onclick="cancelAppointment('<%=appointmentNumber %>','<%=appointmentStatus %>','<%=facilityId %>')" class="<%=okButtonStyle%>">Ok</a></span> 
					<span><a href="#"  onclick="closeConfirmCancelAppointmentPopup()" class="popbtncenter">Cancel</a></span><br>
								
		        </div>
		    </div>
		</div>
	
	</div>
</div>
<!-- #wrapper -->

</body>
</html>

