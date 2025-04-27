<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.common.ResourceBundleHelper"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTime"%>
<%@page import="portalrefimpl.schedule.ScheduleHelper"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeRequest"%>
<%@page import="java.text.DateFormat"%>
<%@page import="portalrefimpl.common.CommonConstants"%>
<%@page import="portalrefimpl.common.serviceinvoker.ServiceInvoker"%>
<%@page import="portalrefimpl.common.response.BaseResponse"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormatSymbols"%>
<%@page import="java.text.ParseException"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.schedule.upcomingappointments.request.UpcomingAppointmentsRequest"%>
<%@page import="portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentsResponse"%>
<%@page import="portalrefimpl.schedule.upcomingappointments.response.UpcomingAppointmentDetails"%>
<%@page import="portalrefimpl.schedule.upcomingappointments.svc.UpcomingAppointmentsServiceInvoker"%>
<%@page import="portalrefimpl.schedule.ScheduleConstants"%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page import="portalrefimpl.schedule.createappointment.CreateAppointmentConstants"%>
<%@page import="portalrefimpl.facility.facilityforpatient.request.FacilityListRequest"%>
<%@page import="portalrefimpl.facility.facilityforpatient.response.FacilityListResponse"%>
<%@page import="portalrefimpl.common.model.Facility"%>
<%@page import="portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker"%>
<%@page import="portalrefimpl.schedule.createappointment.request.SpecialityRequest"%>
<%@page import="portalrefimpl.schedule.createappointment.response.SpecialityResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.response.SpecialityModel"%>
<%@page import="portalrefimpl.schedule.createappointment.svc.serviceinvoker.SpecialityServiceInvoker"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Patient Portal - Appointments :::</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../../css/style_ie.css" type="text/css"/>

<link href="../../css/examples-offline.css" rel="stylesheet">
<link href="../../css/kendo.common.min.css" rel="stylesheet">
<link href="../../css/kendo.default.min.css" rel="stylesheet">

<script src="../../js/jquery.min.js"></script>
<script src="../../js/kendo.web.min.js"></script>
<script src="../../js/console.js"></script>
<script src="../../js/date.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<style>
    #special-days {
        height: 185px;
        width: 300px;
        margin: 2px auto;
        /*padding: 2px 0 2px 2px;*/
    }

    #ApptPreferredDate {
        border-radius: 3px 3px 3px 3px;
        border-style: solid;
        border-width: 1px;
    }

    .k-header {
        border-radius: 3px 3px 0 0;
    }

    #ApptPreferredDate .k-content {
        height: 137px;
        width:262px;
    }

     .normal {
        /* background: transparent url(../../content/web/calendar/exhibition.png) no-repeat 0 50%; */
        background-color : transparent;
        display: inline-block;
        width: 100%;
        height: 10px;
        vertical-align: middle;
        margin-right: 3px;
    }

.menu li a:before {
	content:url(../../images/patch.PNG);
	height:80px;
	width:auto;
	top:63px;
	left:-13px;
	position:relative;
}
.menu li a:after {content:url(../../images/patch.PNG);
	height:80px;
	width:auto;
	top:35px;
	right:-13px;
	position:relative;

}
.menu li a:hover:before {content:url(../../images/LeftMenubg.PNG);
	height:80px;
	width:auto;
	top:63px;
	left:-13px;
	position:relative;
}

.menu li a:hover:after{
	content:url(../../images/RightMenubg.PNG);
	height:80px;
	width:auto;
	top:35px;
	right:-13px;
	position:relative;
}

.menuselect:after{
	content:url(../../images/RightMenubg.PNG);
	height:80px;
	width:auto;
	top:35px;
	right:-13px;
	position:relative;

}
.menuselect:before {content:url(../../images/LeftMenubg.PNG);
	height:80px;
	width:auto;
	top:65px;
	left:-13px;
	position:relative;

}

.confirmpopupContainerStyle {
      background-color: white;
      opacity: 90%;
      filter:alpha(opacity=90);
      background-color: rgba(255,255,255,0.90); 
      width: 100%;
      min-height: 100%;
      overflow: hidden;
      float: absolute;
      position: fixed;
      top: 0;
      left: 0;
      color: white;
      
      /* z-index: -1;
      opacity:0%; */
	}
	
	.confirmpopupContentStyle{
	  background-color: white;
      color: black;
      
      padding: 2px;
      display:block;
      position: absolute;
      top: 30%;
      left: 30%;
      /* width : 0px;
      height : 0px;
      z-index: -1; */
      width: 582px;
      height: 245px; 
	}

.cancelResultPopupContainerStyle {
      background-color: white;
      opacity: 90%;
      filter:alpha(opacity=90);
      background-color: rgba(255,255,255,0.90); 
      width: 100%;
      min-height: 100%;
      overflow: hidden;
      float: absolute;
      position: fixed;
      top: 0;
      left: 0;
      color: white;
      
      /* z-index: -1;
      opacity:0%; */
	}
	
	.cancelResultPopupContentStyle{
	  background-color: white;
      color: black;
      
      padding: 2px;
      display:block;
      position: absolute;
      top: 30%;
      left: 30%;
      /* width : 0px;
      height : 0px;
      z-index: -1; */
      width: 582px;
      height: 245px; 
	}

</style>

 <script>
     $(document).ready(function() {
         var today = new Date();

         // create DatePicker from input HTML element
         $("#fromDateText").kendoDatePicker({
        	    format: "dd/MM/yyyy"
         });
         $("#toDateText").kendoDatePicker({
        	    format: "dd/MM/yyyy"
         });
         
         $("#ApptPreferredDate").kendoCalendar({
             value: today,
             footer: "Today - #=kendo.toString(data, 'd') #"
         });
     });
     
     function showMoreResults(){

    		// get the component which stores the current number
    		// of records shown in the page
    		var currentResultCounterComp = document.getElementById("resultCounter");
    		var currentResultCounter;
    		if(currentResultCounterComp){
    			currentResultCounter = currentResultCounterComp.value;
    		}
    		// get the int value
    		var currentResultCounterInt = parseInt(currentResultCounter);
    		// get the component which stores the overall number
    		// of records shown in the page
    		var resultCountComp = document.getElementById("resultCount");
    		var resultCount;
    		if(resultCountComp){
    			resultCount = resultCountComp.value;
    		}
    		var resultCountInt = parseInt(resultCount);
    		
    		// get the component which stores the number of records to be shown
    		// every time user clicks on "click more" button
    		var recordViewCountComp = document.getElementById("UpcomingAppointmentsRowCount")
    		var recordViewCount;
    		if(recordViewCountComp){
    			recordViewCount = recordViewCountComp.value;
    		}
    		var recordViewCountInt = parseInt(recordViewCount);
    		
    		// the logic now is to show records further from the current
    		// number of records shown till the next set of records	
    		var iterationEndValue = resultCountInt;
    		if((currentResultCounterInt + recordViewCountInt) < resultCountInt){
    			iterationEndValue = currentResultCounterInt + recordViewCountInt;
    		}
    		    		
    		var resultElement;
    		for(var itrCnt=(currentResultCounterInt + 1);itrCnt<=iterationEndValue;itrCnt++){
    			resultElement = document.getElementById("result"+itrCnt);
    			if(resultElement){
    				resultElement.style.display = 'block';
    			}
    		}
    		
    		// this code will disable the "click more" button since there are
    		// no more records to be shown
    		if(iterationEndValue == resultCountInt){
    			var moreResultDivComp = document.getElementById("moreResultDiv");
    			if(moreResultDivComp){
    				moreResultDivComp.style.display = "none";
    			}
    		}
    		
    		currentResultCounterComp.value = ""+iterationEndValue;
     }
     
     
     function searchResults(){
    	 var formElement = document.getElementById("searchForm");
    	 document.getElementById("hdnPostBack").value = "true";
    	 document.getElementById("hdnFacilityId").value = document.getElementById("facilityIdText").value;
    	 document.getElementById("hdnFromDate").value = document.getElementById("fromDateText").value;
    	 document.getElementById("hdnToDate").value = document.getElementById("toDateText").value;
		
    	 var fromDateText = document.getElementById("fromDateText").value;
    	 var toDateText = document.getElementById("toDateText").value;

    	 var dateTimePicker = $("#fromDateText").data("kendoDatePicker");
    	 var fromDate = dateTimePicker.value();
    	 var dateTimePicker = $("#toDateText").data("kendoDatePicker");
    	 var toDate = dateTimePicker.value();
    	 
    	 var today = new Date();
		 
    	 if((fromDateText == "" && toDateText!= "")||(toDateText == "" && fromDateText!= "")){
    		 alert("Both From and To date should be present")
    	 }
    	 else if(fromDateText!="" && toDateText!=""){
				if(fromDate == null){
    		 	alert("From date value is invalid");
		    	 }
		    	 else if(toDate == null){
		    		 alert("To date value is invalid");
		    	 }
		    	 else if(!fromDate > today){
		    		 alert("From date cannot be before today");
		    	 }
		    	 else if(fromDate > toDate){
		    		 alert("From date cannot be after to date");
		    	 }
		    	 else {
		    		 formElement.submit();
		    	 }
    	 }
    	 else{
    		 formElement.submit();
    	 }
    	 
    	 
     }
     
     function showAppointment(){
    	 // this function allows the user to move from the home page
    	 // to the book appointment screen
    	 
    	 // first call the validation function
    	 var isValid = validateForm();
    	 if(!isValid){
    		 return;
    	 }
    	 
    	 // get the calendar object and the preferred date
    	 var calendar = $("#ApptPreferredDate").data("kendoCalendar");
    	 var preferredApptDate = calendar.value();
    	 
    	 var dateValue = ""+preferredApptDate.getDate()+"/"+(preferredApptDate.getMonth()+1)+"/"+preferredApptDate.getFullYear();
    	 // hidden var which will stored the preferred date
    	 var preferredDateHdnElement = document.getElementById("hdnPreferredDate");
    	 if(preferredDateHdnElement){
    		 preferredDateHdnElement.value = dateValue;
    	 }
    	 
    	 var specialtyCombo = document.getElementById("Speciality");
    	 if(specialtyCombo){
    		 //specialtyCombo.inner
    		 //alert($("#Speciality").find('option:selected').text()+ '  '+$("#Speciality").find('option:selected').val());
    		 var hiddenSpecialtyComp = document.getElementById("hdnSelectedSpecialtyDesc");
    		 if(hiddenSpecialtyComp){
    			 hiddenSpecialtyComp.value = $("#Speciality").find('option:selected').text();
    		 }
    	 }
    	 
    	 var facilityCombo = document.getElementById("Facility");
    	 if(facilityCombo){
    		 var hiddenFacilityComp = document.getElementById("hdnSelectedFacilityDesc");
    		 if(hiddenFacilityComp){
    			 hiddenFacilityComp.value = $("#Facility").find('option:selected').text();
    		 }
    	 }
    	 
    	 
    	 // get the form element, set the action and submit the form
    	 var formElement = document.getElementById("searchForm");
    	 if(formElement){
    		 formElement.action = "./SpecialityServlet";
    		 formElement.submit();
    	 }
     }
     
     function validateForm(){
    	 var validationMessage = "";
    	 
    	 // first validate the fields in the GUI
    	 var calendar = $("#ApptPreferredDate").data("kendoCalendar");
         var preferredApptDate = calendar.value();
         if(isNaN(preferredApptDate)){
        	 validationMessage = "Preferred date "+preferredApptDate+" is not valid. \n";
         }
         
        var currentDate = new Date();
         
    	 // time validation
    	var selectedFromTimeComp = document.getElementById("ApptPreferredFromTime");
    	var selectedFromTimeIndex;
    	var selectedFromTime = "";
    	if(selectedFromTimeComp){
    		selectedFromTimeIndex = selectedFromTimeComp.selectedIndex;
    		selectedFromTime = selectedFromTimeComp.value;
    		selectedFromTime = trimText(selectedFromTime);
    	}
    	
    	var selectedToTimeIndex;
    	var selectedToTimeComp = document.getElementById("ApptPreferredToTime");
    	var selectedToTime = "";
    	if(selectedToTimeComp){
    		selectedToTimeIndex = selectedToTimeComp.selectedIndex;
    		selectedToTime = selectedToTimeComp.value;
    		selectedToTime = trimText(selectedToTime);
    	}
    	
    	var selectedTimeIsInvalid = false;
    	if(selectedFromTime.length == 0 && selectedToTime.length == 0){
    		validationMessage += "Appointment start and end time is not specified. \n";
    		selectedTimeIsInvalid = true;
    	}else if(selectedFromTime.length == 0){
    		validationMessage += "Appointment start time is not specified. \n";
    		selectedTimeIsInvalid = true;
    	}else if(selectedToTime.length == 0){
    		validationMessage += "Appointment end time is not specified. \n";
    		selectedTimeIsInvalid = true;
    	}else if(selectedFromTime == selectedToTime){
    		validationMessage += "Appointment start and end time cannot be same. \n";
    		selectedTimeIsInvalid = true;
    	}
    	
    	var delimiter = ":";
    	var delimiterIndex = selectedFromTime.indexOf(delimiter);
    	var hrsStr = "";
    	var hrs = 0;
    	var minsStr = "";
    	var mins = 0;
    	if(delimiterIndex > 0){
    		hrsStr = selectedFromTime.substring(0,delimiterIndex);
    		minsStr = selectedFromTime.substring(delimiterIndex+1,selectedFromTime.length);
    		try{
    			hrs = parseInt(hrsStr);	
    		}catch(e){
    			hrs = 0;
    		}
    		try{
    			mins = parseInt(minsStr);
    		}catch(e){
    			mins = 0;
    		}
    	}
    	// set the hours, minutes and the seconds
    	// seconds will be set to 0 now
    	preferredApptDate.setHours(hrs);
    	preferredApptDate.setMinutes(mins);
    	preferredApptDate.setSeconds(0);
    	
    	// validate the appointment start time with current date only
    	// when the start time is selected properly by user
    	if((preferredApptDate < currentDate) && !selectedTimeIsInvalid){
    		validationMessage += "Appointment start time cannot be less than current time. \n";
    	}
    	
    	// validate the appointment start time with appointment end time only
    	// when the start time and end time is selected properly by user	
    	if((selectedFromTimeIndex > selectedToTimeIndex) && !selectedTimeIsInvalid){
    		validationMessage += "Appointment start time cannot be greater than or equal to end time. \n";
    	}
    	
    	// speciality and facility validation
    	// first speciality
    	var hiddenSpecialityComp = document.getElementById("Speciality");
    	var selectedSpeciality="";
    	if(hiddenSpecialityComp){
    		selectedSpeciality = hiddenSpecialityComp.value;
    		selectedSpeciality = trimText(selectedSpeciality);
    	}
    	if(selectedSpeciality.length == 0){
    		validationMessage += "Speciality is not selected. \n";
    	}
    	
    	// validate selected facility
    	var selectedFacility = "";
    	var facilityComp = document.getElementById("Facility");
    	if(facilityComp){
    		selectedFacility = facilityComp.value;
    		selectedFacility = trimText(selectedFacility);
    	}
    	
    	if(selectedFacility.length == 0){
    		validationMessage += "Facility is not selected. \n";
    	}
    	
    	if(validationMessage.length > 0){
    		alert(validationMessage);
    		return false;
    	}
    	 
    	return true;
     }

     function trimText(textVal){
    	 var l=0; var r=textVal.length -1;
    	 while(l < textVal.length && textVal[l] == ' '){
    		  l++;
    	 }
    		
    	 while(r > l && textVal[r] == ' '){
    		r-=1;
    	 }
    	 textVal = textVal.substring(l, r+1);
    	 
    	 return textVal;
     }
     
     function rescheduleAppointment(apptNumber){
    	// this function starts the reschedule appointment flow
     	// by submitting the form to get the appointment request details
     	var rescheduleApptReqURL = "./ApptRequestDetailsServlet";
     	rescheduleApptReqURL += "?referenceNumber="+apptNumber;
     	// get the form element, set the action and submit the form
 	   	var formElement = document.getElementById("searchForm");
 	   	if(formElement){
 	   		formElement.action = rescheduleApptReqURL;
 	   		formElement.submit();
 	   	}
     }
     
     function confirmCancelAppointment(appointmentNumber,appointmentStatus,specialty,facilityId,practitionerName,appointmentDate,apptStartTime,apptEndTime){
    	 // this function will show an confirmation popup before an
    	 // appointment is cancelled
    	 //alert(appointmentNumber+"|||"+appointmentStatus+"|||"+specialty+"|||"+facilityId+"|||"+practitionerName+"|||"+appointmentDate+"|||"+apptStartTime+"|||"+apptEndTime);
    	 var apptNumber = escape(appointmentNumber);
    	 var apptStatus = escape(appointmentStatus);
    	 var spl = escape(specialty);
    	 var fac = escape(facilityId);
    	 var prac = escape(practitionerName);
    	 var apptDate = escape(appointmentDate);
    	 var startTime = escape(apptStartTime);
    	 var endTime = escape(apptEndTime);
    	 var confirmPopupURL = "./CancelAppConfirm.jsp?appointmentNumber="+apptNumber+"&status="+apptStatus+"&specialty="+spl+"&facilityId="+fac+"&practitionerName="+prac+"&appointmentDate="+apptDate+"&startTime="+startTime+"&endTime="+endTime;
    	 //alert(confirmPopupURL);
    	 $('#confirmCancelPopupDiv').load(confirmPopupURL);
 	    
 		if (document.getElementById('confirmCancelPopupContainerDiv').style.visibility == 'hidden') {
 	       document.getElementById('confirmCancelPopupContainerDiv').style.visibility = '';
 	       $("#confirmCancelPopupContainerDiv").hide();
 	    }
 	    if (document.getElementById('confirmCancelPopupDiv').style.visibility == 'hidden') {
 	       document.getElementById('confirmCancelPopupDiv').style.visibility = '';
 	       $("#confirmCancelPopupDiv").hide();
 	    }
 		
 		$("#confirmCancelPopupContainerDiv").fadeIn(300, "linear", function () { $("#confirmCancelPopupDiv").show(400, "swing"); });
    	 
     }
     
    function closeConfirmCancelAppointmentPopup(){
  	   // this function will close the confirm cancel appointment popup dialog
  		$("#confirmCancelPopupDiv").hide('300', "swing", function () { $("#confirmCancelPopupContainerDiv").fadeOut("200"); });
  	}
    
    function cancelAppointmentMain(appointmentNumber,appointmentStatus,facilityId,selectedReasonCode){
    	// this function cancels an appointment
    	$("#confirmCancelPopupDiv").hide('200', "swing", function () { $("#confirmCancelPopupContainerDiv").fadeOut("100"); });
    	
    	var cancelApptResultURL = "./CancelAppointmentServlet?";
    	cancelApptResultURL += "appointmentNumber="+appointmentNumber+"&appointmentStatus="+appointmentStatus+"&FacilityId="+facilityId+"&cancelReasonCode="+selectedReasonCode;
    	
    	$("#cancelApptResultPopupDiv").load(cancelApptResultURL);
    	if (document.getElementById('cancelApptResultPopupContainerDiv').style.visibility == 'hidden') {
  	       document.getElementById('cancelApptResultPopupContainerDiv').style.visibility = '';
  	       $("#cancelApptResultPopupContainerDiv").hide();
  	    }
  	    if (document.getElementById('cancelApptResultPopupDiv').style.visibility == 'hidden') {
  	       document.getElementById('cancelApptResultPopupDiv').style.visibility = '';
  	       $("#cancelApptResultPopupDiv").hide();
  	    }
  		
  		$("#cancelApptResultPopupContainerDiv").fadeIn(200, "linear", function () { $("#cancelApptResultPopupDiv").show(300, "swing"); });
    	
    }
    
    function closeCancelAppointmentResultPage(){
    	// this function closes the cancel appointment result popup
    	$("#cancelApptResultPopupDiv").hide('300', "swing", function () { $("#cancelApptResultPopupContainerDiv").fadeOut("200"); });
    	 // get the form element, set the action and submit the form
	   	 var formElement = document.getElementById("searchForm");
	   	 if(formElement){
	   		 formElement.submit();
	   	 }
    }
     
 </script>
</head>

<body>
	<%
		String useWebService = "";
		useWebService = (String) session.getAttribute(PortalConstants.USEWEBSERVICE_SESSION_KEY);

		String patientId = "";
		patientId = (String) session.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
		if (patientId == null) {
			patientId = (String) getServletConfig().getServletContext()
					.getAttribute("patientId");
			if (patientId == null) {
				patientId = "";
			}
		}
		
		String patientName = "";
		patientName = (String) session
				.getAttribute(PortalConstants.PATIENTNAME_SESSION_KEY);
		if (patientName == null) {
			patientName = "";
		}
		
		String facilityIdParameter = request.getParameter("facilityIdText");
		String fromDateParameter = request.getParameter("fromDateText");
		String toDateParameter = request.getParameter("toDateText");
		
		String facilityIdPostBack = "";
		String fromDatePostBack = "";
		String toDatePostBack = "";
		String postBack = "";
		
		String resultCountString = request
				.getParameter("resultCount");
		if (resultCountString == null) {
			resultCountString = "0";
		}
		int resultCount = 0;
		try {
			resultCount = Integer.parseInt(resultCountString);
		} catch (Exception ex) {
			resultCount = 0;
		}

		final int TOTALRECORD_COUNT = 4;
		// read the result counter
		String resultCounterString = request
				.getParameter("resultCounter");
		String tempResultCountString = PortalHelper.getConfigPropertyValue(
				"UpcomingAppointmentsRowCount", true);
		if (resultCounterString == null) {
			resultCounterString = tempResultCountString;
		}
		int currentResultCounter = PortalHelper.getIntegerValue(
				tempResultCountString, TOTALRECORD_COUNT);
		int resultCounter = PortalHelper.getIntegerValue(
				tempResultCountString, TOTALRECORD_COUNT);
		
		//Invoking upcoming appointments service
		/* UpcomingAppointmentsSvcImpl svcImpl = new UpcomingAppointmentsSvcImpl(); */
		UpcomingAppointmentsRequest urequest = new UpcomingAppointmentsRequest();
		urequest.setPatientId(patientId);
		urequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		if(facilityIdParameter!=null && !facilityIdParameter.trim().equals(""))
			urequest.setFacilityId(facilityIdParameter);
		if(fromDateParameter!=null && !fromDateParameter.equals(""))
			urequest.setFromDate(fromDateParameter);
		if(toDateParameter!=null && !toDateParameter.equals(""))
			urequest.setToDate(toDateParameter);
		/* svcImpl.registerService(urequest); */
		UpcomingAppointmentsServiceInvoker upcomingAppointmentsServiceInvoker = new UpcomingAppointmentsServiceInvoker();
		upcomingAppointmentsServiceInvoker.registerService(urequest);
		UpcomingAppointmentsResponse upcomingresponse = (UpcomingAppointmentsResponse) upcomingAppointmentsServiceInvoker
				.getDataThroughWebService(urequest);
		
		//Invoking Facility service to polpulate the facility dropdown
		/* FacilityListSvcImpl fsvcImpl = new FacilityListSvcImpl(); */
		FacilityListRequest frequest = new FacilityListRequest();
		frequest.setPatientId(patientId);
		frequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
				
		FacilityListServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
		/* FacilityListResponse fresponse = fsvcImpl.getFacilityList(frequest); */		
		FacilityListResponse fresponse = facilityListServiceInvoker.getDataThroughService(frequest);
		
		
		//Invoking Speciality service to polpulate the speciality dropdown
		/* SpecialitySvcImpl ssvcImpl = new SpecialitySvcImpl(); */
		SpecialityRequest srequest = new SpecialityRequest();
		srequest.setPatientId(patientId);
		srequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
		/* ssvcImpl.registerService(srequest); */
		SpecialityServiceInvoker specialityServiceInvoker = new SpecialityServiceInvoker();
		specialityServiceInvoker.registerService(srequest);
		SpecialityResponse sresponse = (SpecialityResponse) specialityServiceInvoker
				.getDataThroughWebService(srequest);
		
		if(request.getParameter("hdnPostBack") != null){
			postBack = request.getParameter("hdnPostBack");
			if(postBack.equals("true")){
				facilityIdPostBack = request.getParameter("hdnFacilityId");
				fromDatePostBack = request.getParameter("hdnFromDate");
				toDatePostBack = request.getParameter("hdnToDate");
			}

		} 
		

	%>


	<div id="wrapper" style="background-color: #ffffff;">
		<div class="fixedheader">
			<header id="header">
				<div id="headerinfo">
					<div class="row">
						<div id="headervisitinfo">Welcome back! Your last visit was
							on Wed, Dec 5, 2012 12:47:08 PM</div>
						<div id="headerloginas">
							<strong>Welcome, <%=patientName%>, ID:<%=patientId%></strong>
						</div>
						<div id="headerlogout">
							<div>
								<a href="../../servlet/LogoutServlet" class="logout"> Logout</a>
							</div>
						</div>
					</div>
				</div>
			</header>

			<!-- #header-->

			<!-- #logo And Menu -->

			<div id="logomenu">
				<div class="row">
			    	<div id="logo">
						<img src="../../images/logo.png"> 
			        </div>
			        <div id="Menubox">
						<ul class="menu">
			                <li><a href="../Contact.jsp"><div class="menuicons"><img src="../../images/Contact.png"/></div>Contact</a></li>
			                <li><a href="../result/DetailedResult.jsp"><div class="menuicons"><img src="../../images/Results.png"/></div>My Results</a></li>
			                <li class="menuselect"><div class="menuicons"><img src="../../images/Appointment.png"/></div>My Appointments</a></li>
			                <li><a href="../PortalHome.jsp"><div class="menuicons"><img src="../../images/Home.png"/></div>Home</a></li>
			            </ul>
			        </div>
			    </div>
			</div>
		</div>
		<!-- #logo And Menu -->

		<div class="line"></div>

		<form id="searchForm" name="searchForm" id="searchForm" method="POST" >

		<div id="content" style="background-color: #ffffff;padding-bottom: 1px;">

			<!-- #Patient Banner-->

			<!-- #Patient Banner-->
			<!-- #Content Area-->
			<div id="contentbg"></div>
			<div id="contentArea" style="min-height:460px;height:505px;max-height: 505px;overflow:none;">

				<div id="contentArearow" style="min-height:460px;height:505px;max-height: 505px;">

					<div class="cellindex searchindex">
						<div id="BooknewAppsearchindex">
							<div class="BookAppTitlehomepg">Book an appointment</div>
							<div class="bookcontent">
								<div id="Apptime">
									<div id="special-days">
			               				<!-- <div id="calendar" style="width: 262px;"></div> -->
			               				<div id="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY%>"
			               					name="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY%>" 
			              					 style="width: 262px;">
			              				</div>
			          	 			</div>
									<div class="ApptitleReschedule">Preferred time</div>
									<select class="textboxtimeindex" id="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>"
										name="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>" style="width: 110px;">
										<option>Select time</option>
										<%
											AppointmentTimeRequest apptTimeRequest = new AppointmentTimeRequest(
													ScheduleConstants.BOOKAPPT_START_TIME_IDENTIFIER);
											AppointmentTimeResponse apptTimeResponse = ScheduleHelper.
													getAppointmentTimeResponse(apptTimeRequest);
											// there is no need to worry for errors as of now since
											// the data returned is going to be valid and that too not from db
											List<AppointmentTime> apptTimeList = apptTimeResponse
													.getAppointmentTimeList();
											String apptDisplayValue = null;
											String apptDataValue = null;
											
											// iterate through the list and show the time
											for (AppointmentTime apptTime : apptTimeList) {
												apptDisplayValue = apptTime.getAppointmentTime();
												apptDataValue = apptTime.getAppointmentDataValue();
											%>
											<option value="<%=apptDataValue %>"><%=apptDisplayValue %></option>
											<%
												}
											%>
									</select> 
									<span>to</span> 
									<select class="textboxtimeindex"  id="<%=CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY%>"
										name="<%=CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY%>" 
										style="width: 110px;">
										<option>Select time</option>
										<%
										apptTimeRequest = new AppointmentTimeRequest(
												ScheduleConstants.BOOKAPPT_TO_TIME_IDENTIFIER);
										apptTimeResponse = ScheduleHelper.
												getAppointmentTimeResponse(apptTimeRequest);
										apptTimeList = apptTimeResponse
												.getAppointmentTimeList();
										// iterate through the list and show the time
										for (AppointmentTime apptTime : apptTimeList) {
											apptDisplayValue = apptTime.getAppointmentTime();
											apptDataValue = apptTime.getAppointmentDataValue();
										%>
										<option value="<%=apptDataValue %>"><%=apptDisplayValue %></option>
										<%
											}
										%>
									</select>
									<div></div>
									<span class="ApptitleReschedule" style="margin-right: 75px;">Speciality</span>
									<span class="ApptitleReschedule">Facility</span>
									<!--  just for giving line -->
									<div></div>
									<!-- <div class="ApptitleReschedule">Speciality</div> -->
									<select class="textbox" id="<%=CreateAppointmentConstants.SPECIALITY_PARAMETER_KEY%>" 
										name="<%=CreateAppointmentConstants.SPECIALITY_PARAMETER_KEY%>" style="width: 125px;margin-right: 5px;">
										<option value="">---All---</option>
											<%
												List<SpecialityModel> specialityList = null;
												String specialityCode;
												String specialityDesc;
												// check if the specialities were retrieved successfully
												// if so, then show the specialities
												if(sresponse.isSuccessful()){
													specialityList = sresponse.getSpecialityList();
													if (specialityList != null) {
														for (SpecialityModel s : specialityList) {
															specialityCode = s.getSpecialityCode();
															specialityDesc = s.getShortDesc();
															String selected = "";
														/* if (facilityId.equals(facilityIdPostBack))
															selected = "selected"; */
											%>
											<option value="<%=specialityCode%>" <%=selected%>><%=specialityDesc%></option>
											<%
														}
													}
												}
											%>

										</select>
										
										<!-- facility comp  -->
				       				   <select class="textbox" id="<%=CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY %>" name="<%=CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY %>" style="width: 125px;">
				       				   	<option value="" selected="selected">----All----</option>
				       				   	<%
				       				 		/* ErrorInfo facilityListErrorInfo = fresponse
							  								.getErrorInfo(); */
										  	List<Facility> facilityList = null;
										  	/* if (ErrorInfo.SUCCESS_CODE == facilityListErrorInfo.getErrorCode()) { */
										  	if (fresponse.isSuccessful()) {	
										  		facilityList = fresponse.getFacilityList();
										  		for (Facility facility : facilityList) {
										  %>			
										  	<option value="<%=facility.getFacilityId()%>"><%=facility.getFacilityName()%></option>		
									  	<%
										  		}
										  	}
				       				   	%>
				       				   	
				       				   </select> 
										<input type="hidden" id="hdnPreferredDate" name="hdnPreferredDate" id="hdnPreferredDate" value="">
										<input type="hidden" id="hdnSelectedSpecialtyDesc" name="hdnSelectedSpecialtyDesc" id="hdnSelectedSpecialtyDesc" value="">
										<input type="hidden" id="hdnSelectedFacilityDesc" name="hdnSelectedFacilityDesc" id="hdnSelectedFacilityDesc" value="">
								</div>

							</div>
							<div class="centeralign">
								<span><a href="#" onclick="showAppointment()"  class="PPbtn">Book an appointment</a></span>
							</div>

						</div>
					</div>
					<!-- page divider -->
					<div class="cellindex appindex">
						<div class="tableindex">
							<div class="row">
								<div class="cellindex dividerindex"></div>
								<div class="cellindex uppcomingwidth">
									<div id="UpcomingAppExpand">
										<div class="AppoinmentExpandTitle">
											<div class="titleSelected">Upcoming appointments</div>
											<div>
												<a href="PastAppoinments.html">Past appointments</a>
											</div>

										</div>


										<!-- content from result.html given here -->
										<div id="innercontentExpanded" style="min-height: 450px;max-height: 450px;">
											<div class="row">
												<div class="cell">
													<div class="resulttableExpanded">
														<!-- SEARCH ------->

														<div class="innerrow">

															<div id="searcharea">
																<span><a href="#" class="btn" onclick="searchResults()">Search</a></span> 
																<select class="CombotextboxdateUP" name="facilityIdText" id="facilityIdText" id="facilityIdText">
																	<option value="">----Select Facility----</option>
																	<%
																		//ErrorInfo errorInfo = upcomingresponse.getErrorInfo();
																		//int errorCode = errorInfo.getErrorCode(); 
																		String errorMessage = null;//errorInfo.getErrorMessage();
																		
																		String facilityId = null;
																		String facilityName = null;
																		facilityList = null;
																		/* if(ErrorInfo.SUCCESS_CODE == errorCode){ */
																		// check the upcoming appointment response's success state
																		if(upcomingresponse.isSuccessful()){	
																			facilityList = upcomingresponse.getUpcomingAppointmentsFacilityList();
																			
																			if(facilityList!=null){
			              														for(Facility f: facilityList){
																					facilityId = f.getFacilityId();
																					facilityName = f.getFacilityName();
																					String selected = "";
																					if(facilityId.equals(facilityIdPostBack))
																						selected = "selected";
																	%>
																	<option value="<%=facilityId %>"  <%=selected %>><%=facilityName %></option>
																	<%		
																				}
	              															}
																		 }
	              													%>
																</select> 													
																 <span>From</span>     
																<input id="fromDateText" name="fromDateText" id="fromDateText" value="<%=fromDatePostBack%>" style="width:160px;" />
																<span>To</span>
												         		<input id="toDateText" name="toDateText" id="toDateText" value="<%=toDatePostBack%>" style="width:160px;"/>
															</div>
														</div>
														<% 
																
																String StripDate ="StripDate";
																String Stripday = "Stripday";
																String AppointmentNewDoctor = "AppointmentNewDoctor";
																String contenbold = "contenbold";
																int showInitialConstant = 4;
																int totalResultsCount = 0;
																String divMoreResultsVisibleStyle = "display:none";
																//int showInitialConstant = ScheduleConstants.UPCOMINGAPPOINTMENTS_RESULTS_SHOW_COUNT;
																errorMessage = upcomingresponse.getErrorMessage(); 
																if(!upcomingresponse.isSuccessful()) { 
																	// this indicates failure in the complete operation
																%>
																<div style="min-height: 25px;width:100%;border: 1px solid #CDCDCD;">
																	<span class="loginerror" style="padding-left: 10px;margin-top: 5px;"><%=errorMessage%></span>
																</div>
																<%
              													} else {
              														// showing information message
              														// part operation has failed - either appointments
              														// or appointment requests were not retrieved
              														if(errorMessage != null && !errorMessage.trim().equals("")){
              													%>
              														<div style="min-height: 20px;width:100%;border: 1px solid #CDCDCD;padding-top: 5px;">
              															<span style="padding-left: 10px;color: #000000;font-size: 12px;"><%=errorMessage %></span>
              														</div>
              													<%	
              														}else{
              															// showing a generic message that both appointments
              															// and appointment requests have been retrieved
              															errorMessage = ResourceBundleHelper.getMessageFromBundle
              																	(ScheduleConstants.UPCOMING_APPOINTMENT_BUNDLE_CLASS,
              																	ScheduleConstants.UPCOMING_APPOINTMENT_RETRIEVE_SUCCESS_DISPLAYMESSAGE_KEY);
              															if(errorMessage == null || errorMessage.trim().equals("")){
              																errorMessage = "Showing appointments and appointment requests.";
              															}
              													%>
           															<div style="min-height: 20px;width:100%;border: 1px solid #CDCDCD;padding-top: 5px;">
              															<span style="padding-left: 10px;color: #000000;font-size: 12px;"><%=errorMessage %></span>
              														</div>
              													<%
              														}
              													%>
              											<div class="innerrow">
															<div id="Resultarea">	
              													<%	
              														List<UpcomingAppointmentDetails> upcomingAppointmentDetails = upcomingresponse.getUpcomingAppointmentsList();
              														totalResultsCount = upcomingAppointmentDetails.size();
              														int counter = 1;
              														resultCount = upcomingAppointmentDetails.size();
              														String divResultsVisibleStyle = "display:block";
              														// var to store the appointment status for display purpose
              														String appointmentStatusForDisplay = null;
              														String appointmentStatus = null;
              														final String EM_APPOINTMENT_KEY = "Appointment";
              														final String APP_REQ_KEY = "Request";
              														final String APP_REQ_IDENTIFIER = "Appointment Request";
              														// var to store the style class for the reschedule appointment button
              														String rescheduleButtonStyle = null;
              														// constant to store the status for appointments booked in EM
              														final String EM_APPOINTMENT_STATUS = "1";
              														for(UpcomingAppointmentDetails d: upcomingAppointmentDetails){
              															String practitioner = d.getPractitionerName();
              															String speciality = d.getApptSpeciality();
              															String facility = d.getFacilityName();
              															String location = d.getLocationName();
              															String apptNum = d.getAppointmentNumber();
              															String startTime = d.getAppointmentStartTime();
              															String endTime = d.getAppointmentEndTime();
              															String apptDate = d.getAppointmentDate();
              															SimpleDateFormat df_full = new SimpleDateFormat("dd/MM/yyyy");
              															SimpleDateFormat df_month = new SimpleDateFormat("MMM");
              															SimpleDateFormat df_year = new SimpleDateFormat("yyyy");
              															SimpleDateFormat df_date = new SimpleDateFormat("dd");
              															SimpleDateFormat df_day = new SimpleDateFormat("EEEE");
              															Date appt_date = df_full.parse(apptDate);
              															String appt_month = df_month.format(appt_date);
              															String appt_year = df_year.format(appt_date);
              															String appt_date_num = df_date.format(appt_date);
              															String appt_weekday = df_day.format(appt_date);
              															// reset the reschedule button style
              															rescheduleButtonStyle = "UpcomingAppbtn";
              															
              															appointmentStatusForDisplay = d.getAppointmentStatus();
              															if(EM_APPOINTMENT_STATUS.equals(appointmentStatusForDisplay)){
              																appointmentStatusForDisplay = "Open";
              																rescheduleButtonStyle = "disabled";
              																appointmentStatus = EM_APPOINTMENT_KEY;
              															}else if(APP_REQ_IDENTIFIER.equals(appointmentStatusForDisplay)){
              																appointmentStatus = APP_REQ_KEY;
              															}
              															
              															if(counter>0){
			              													StripDate ="StripDatenormal";
																			Stripday = "Stripdaynormal";
																			AppointmentNewDoctor = "AppointmentNewDoctorNormal";
																			contenbold = "contentnormal";
              															}
              															
              															if(counter > currentResultCounter){
              																divResultsVisibleStyle = "display:none";
              															}

              															if(totalResultsCount>showInitialConstant){
              																divMoreResultsVisibleStyle = "display:table-row";
              															}
              																
              															%>
              														<div id="result<%=counter%>" style="<%=divResultsVisibleStyle%>"> 
              															<!--  Result Box01 -->
																	<div id="stripbox">
																		<div class="row">
																			<!-- Stripicon-->
																			<div id="StripSpaceA">
																				<div id="StripIcon">
																					<div id="StripIconHeader"><%=appt_month %> - <%= appt_year %></div>
																					<div id="<%=StripDate %>"><%=appt_date_num %></div>
																					<div id="<%=Stripday%>"><%=appt_weekday %></div>
																				</div>
																			</div>
																			<!-- Stripcontent-->
																			<div id="StripSpaceB" style="width:60%;">
																				<p>
																					<span class="<%=AppointmentNewDoctor%>"><%=practitioner %></span><span
																						class="<%=AppointmentNewDoctor%>"> - <%=speciality %></span>
																				</p>
																				<p>
																					<span class="<%=contenbold%>"><%=facility%>,</span><span
																						class="<%=contenbold%>"> <%=location %></span>
																				</p>
																				<p>
																					<span class="<%=contenbold%>">APP No:<%=apptNum %>,</span> <span
																						class="<%=contenbold%>"><%=startTime %> - <%=endTime %></span>
																						<img
																						class="printPDF" src="../../images/PDF.png"> <img
																						class="printPDF" src="../../images/print.png">
																				</p>
																			</div>
																			<div id="StripSpaceC">
																				<span>Status : <%=appointmentStatusForDisplay %></span>
																			</div>
																			<div id="StripSpaceD">
																				<span>
																					<a href="#" onclick="rescheduleAppointment('<%=apptNum %>')"
																					class="<%=rescheduleButtonStyle%>">Reschedule</a>
																				</span>
																			</div>
																			<div id="StripSpaceD">
																				<span><a href="#" onclick="confirmCancelAppointment('<%=apptNum %>','<%=appointmentStatus %>','<%=speciality %>','<%=d.getFacilityId() %>','<%=practitioner %>','<%=apptDate %>','<%=startTime %>','<%=endTime %>')"
																					class="UpcomingAppbtn">Cancel</a></span>
																			</div>

																		</div>
																	</div> <!--  Result Box01 -->
																	</div>
              															
		              												<% 
		              												counter++;	
		              												} 
		              												%>
              													
                  													
        															</div>
        														</div>
        														<!--  Result Box01 -->
        															<%
          															if (resultCount > resultCounter) {
          														    %>

        															<div class="innerrow" id="moreResultDiv" >
        														   		 <div id="MoreResult">
        														         <!-- 	Click for more -->
        														         	<span>
        														         		<a onclick="showMoreResults()" class="moreresultsbtn" >Click for more 
   		 																		</a>
   		 																	</span>
        														         </div>
        															</div>
       															<%
       																}
       															}
       															%>
              													

		

													</div>
												</div>
											</div>


											<!-- #Content Area       **********************************************        -->

										</div>
										<!-- content from result.html given here -->


									</div>
								</div>
							</div>
						</div>


						<!-- page divider -->


					</div>
				</div>
			</div>
		
			<!--  div for the popup -->
			<div id="confirmCancelPopupContainerDiv" name="confirmCancelPopupContainerDiv" class="confirmpopupContainerStyle" style="visibility:hidden;">
				<div id="confirmCancelPopupDiv" name="confirmCancelPopupDiv" class="confirmpopupContentStyle" style="visibility:hidden;">
				</div>
			</div>
			<div id="cancelApptResultPopupContainerDiv" name="cancelApptResultPopupContainerDiv" class="cancelResultPopupContainerStyle" style="visibility:hidden;">
				<div id="cancelApptResultPopupDiv" name="cancelApptResultPopupDiv" class="cancelResultPopupContentStyle" style="visibility:hidden;">
				</div>
			</div>

		</div>
		<input type="hidden" id="totalResultsCount" name="totalResultsCount" id="totalResultsCount" value="<%=totalResultsCount%>"/>
		<input type="hidden" id="showInitialConstant" name="showInitialConstant" id="showInitialConstant" value="<%=showInitialConstant%>"/>
		<input type="hidden" id="currentShowing" name="currentShowing" id="currentShowing" value="<%=showInitialConstant%>"/>
		<input type="hidden" id="hdnFacilityId" name="hdnFacilityId" id="hdnFacilityId" value="<%=facilityIdParameter%>"/>
		<input type="hidden" id="hdnFromDate" name="hdnFromDate" id="hdnFromDate" value="<%=fromDateParameter%>"/>
		<input type="hidden" id="hdnToDate" name="hdnToDate" id="hdnToDate" value="<%=toDateParameter%>"/>
		<input type="hidden" id="hdnPostBack" name="hdnPostBack" id="hdnPostBack" value="false"/>
		<input type="hidden" id="UpcomingAppointmentsRowCount" name="UpcomingAppointmentsRowCount" id="UpcomingAppointmentsRowCount" value="<%=resultCounter%>"/>
		<input type="hidden" id="resultCount" name="resultCount" id="resultCount" value="<%=resultCount%>"/>
		<input type="hidden" id="resultCounter" name="resultCounter" id="resultCounter" value="<%=currentResultCounter%>"/>
		</form>
		<!-- #Content Area-->


		<!-- #content-->
	<div class="Footerbg" style="height: 20px;margin-top:5px;">
		
	

		<div id="poweredby">
			<p class="poweredby">Powered by <img src="../../images/csc.png" width="25" height="14"></p>
        </div>
		
	
	</div>
	</div>

	<!-- #wrapper -->


	<!-- #footer -->
	<!-- <div id="footeradd">
<p class="FooterTitle"> Get in Touch! </p>
<p class="Footeradd"> Envato Marketplace, Melbourne St, Sydney. TF - 123456, (+00) 0123-456-798, Contact@icarehospital.com, www.icarehospital.com </p>

</div>-->
</body>
</html>

