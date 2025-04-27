<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.Calendar"%>
<%@page import="portalrefimpl.schedule.createappointment.response.PractitionerModel"%>
<%@page import="portalrefimpl.schedule.createappointment.response.PractitionerResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerServiceInvoker"%>
<%@page import="java.util.Locale"%>
<%@page import="portalrefimpl.schedule.createappointment.CreateAppointmentConstants"%>
<%@page import="portalrefimpl.schedule.createappointment.request.PractitionerRequest"%>
<%@page import="portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTime"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.schedule.ScheduleHelper"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeRequest"%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page import="java.util.Date"%>
<%@page import="portalrefimpl.schedule.apptrequestdetails.response.DetailsResponse"%>
<%@page import="portalrefimpl.schedule.apptrequestdetails.svc.DetailsServiceInvoker"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.schedule.apptrequestdetails.request.DetailsRequest"%>
<%@page import="portalrefimpl.schedule.ScheduleConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Patient Portal - Reschedule Appointment</title>

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

<script>
 $(document).ready(function() {
         var today = new Date();
      // create DatePicker from input HTML element
         $("#preferredDateFromPage").kendoDatePicker({
        	    format: "dd/MM/yyyy"
         });
 });
 
 function showPractitionerSchedule(practitionerId,practitionerName){
	 // this function submits the form to show the practitioner schedule
	 // information in a pop up window
	/*  var patientIdComp = document.getElementById("hdnPatientId");
	 if(patientIdComp){
		 patientIdComp.value = practitionerId;
	 } */
	 var datePickerComp = document.getElementById("preferredDateFromPage");
	 var dateTimePicker = $("#preferredDateFromPage").data("kendoDatePicker");
	 var preferredApptDate;
	 //var fromDate = dateTimePicker.value();
	 //var calendar = $("#ApptPreferredDate").data("kendoCalendar");
	 if(datePickerComp){
		 if(dateTimePicker){
			 preferredApptDate = dateTimePicker.value();
		 }else{
			 preferredApptDate = datePickerComp.value;
		 }
	 }
	 //preferredApptDate = dateTimePicker.value();
	 var dateValue = ""+preferredApptDate.getDate()+"/"+(preferredApptDate.getMonth()+1)+"/"+preferredApptDate.getFullYear();
	 
	 var hiddenSpecialityComp = document.getElementById("hdnSpecialtyId");
	 var selectedSpeciality="";
	 if(hiddenSpecialityComp){
		 selectedSpeciality = hiddenSpecialityComp.value;
	 }
	 /* var selectedSpeciality = $("#Speciality").find('option:selected').val(); */
	 var hiddenSpecialityDescComp = document.getElementById("hdnSpecialtyDesc");
	 var selectedSpecialityDesc = "";
	 if(hiddenSpecialityDescComp){
		 selectedSpecialityDesc = hiddenSpecialityDescComp.value;
	 }
	 /* var selectedSpecialityDesc = $("#Speciality").find('option:selected').text(); */
	 var facilityComp = document.getElementById("hdnFacilityId");
	 var selectedFacilityId = "";
	 if(facilityComp){
		 selectedFacilityId = facilityComp.value;
	 }
	 
	 var facilityDescComp = document.getElementById("hdnFacilityDesc");
	 var selectedFacilityDesc = "";
	 if(facilityDescComp){
		 selectedFacilityDesc = facilityDescComp.value;
	 }
	 
	 /* var selectedFacility = $("#Facility").find('option:selected').val();
	 var selectedFacilityDesc = $("#Facility").find('option:selected').text(); */
	 
	 // selected from time
	 var selectedFromTime = $("#fromTimeInPage").find('option:selected').val();
	 selectedFromTime = trimText(selectedFromTime);
	 if(selectedFromTime.length == 0){
		 var originalFromTimeComp = document.getElementById("fromTimeInPage");
		 if(originalFromTimeComp){
			 selectedFromTime = originalFromTimeComp.value;
		 }
	 }
	 
	 // selected to time
	 var selectedToTime = $("#toTimeInPage").find('option:selected').val();
	 selectedToTime = trimText(selectedToTime);
	 if(selectedToTime.length == 0){
		 var originalToTimeComp = document.getElementById("toTimeInPage");
		 if(originalToTimeComp){
			 selectedToTime = originalToTimeComp.value;
		 }
	 }
	 
	 // escape
	 selectedFacilityDesc = escape(selectedFacilityDesc);
	 selectedSpecialityDesc = escape(selectedSpecialityDesc);
	 practitionerName = escape(practitionerName);
	 
	 var popupUrl = "./PractitionerScheduleServlet?";
	 popupUrl += "ApptPreferredDate="+dateValue;
	 popupUrl +="&FacilityId="+selectedFacilityId;
	 popupUrl +="&FacilityDesc="+selectedFacilityDesc;
	 popupUrl +="&SpecialityId="+selectedSpeciality;
	 popupUrl +="&SpecialityDesc="+selectedSpecialityDesc;
	 popupUrl +="&ApptPreferredFromTime="+selectedFromTime;
	 popupUrl +="&ApptPreferredToTime="+selectedToTime;
	 popupUrl +="&PractitionerId="+practitionerId;
	 popupUrl +="&PractitionerName="+practitionerName;
	 	 
	  // load the div with URL
	    $('#practScheduleDiv').load(popupUrl);
	    
		if (document.getElementById('practScheduleContainerDiv').style.visibility == 'hidden') {
	       document.getElementById('practScheduleContainerDiv').style.visibility = '';
	       $("#practScheduleContainerDiv").hide();
	    }
	    if (document.getElementById('practScheduleDiv').style.visibility == 'hidden') {
	       document.getElementById('practScheduleDiv').style.visibility = '';
	       $("#practScheduleDiv").hide();
	    }
		
		$("#practScheduleContainerDiv").fadeIn(200, "linear", function () { $("#practScheduleDiv").show(300, "swing"); });
	 
	 
	 
	/*  var winLeft = (screen.width - 795)/2;
	 var winTop = (screen.height - 495)/2;
	 var popupWindow = window.open(popupUrl,'PractitionerSchedule','height=290,width=620,top='+winTop+',left='+winLeft+',resizable=no,scrollbars=yes,toolbar=no,menubar=no,location=no,directories=no,addressbar=no,status=no,titlebar=no');
	 return false; */
	 
	 
	 /* var formElement = document.getElementById("bookappointmentform");
	 $("#bookappointmentform").attr("action","./PractitionerScheduleServlet");
	 $("#bookappointmentform").submit(); */
	 
 }
 
 function closePractitionerSchedulePopup(){
	// this function will close the practitioner schedule popup dialog
	$("#practScheduleDiv").hide('300', "swing", function () { $("#practScheduleContainerDiv").fadeOut("200"); });
 }
 
 function showMorePractitioner(){
	 // this function will show more practitioners
	 
	 // first get the different counts needed
	 // the counts are - 1. total practitioners 2. current count of displayed practitioners
	 // 3. practitioner bucket count
	 
	 // 1. total practitioners
	 var totalPractCountComp = document.getElementById("totalPractitionerCount");
	 var totalPractCountStr = "";
	 var totalPractCount = 0;
	 if(totalPractCountComp){
		 totalPractCountStr = totalPractCountComp.value;
		 totalPractCount = parseInt(totalPractCountStr);
	 }
	 // 2. current count of displayed practitioners
	 var currPractCountComp = document.getElementById("currentPractitionerCount");
	 var currPractCountStr = "";
	 var currPractCount = 0;
	 if(currPractCountComp){
		 currPractCountStr = currPractCountComp.value;
		 currPractCount = parseInt(currPractCountStr);
	 }
	 // 3. practitioner bucket count
	 var practDisplayBucketComp = document.getElementById("practitionerDisplayBucket");
	 var practDisplayBucketStr = "";
	 var practDisplayBucket = 0;
	 if(practDisplayBucketComp){
		 practDisplayBucketStr = practDisplayBucketComp.value;
		 practDisplayBucket = parseInt(practDisplayBucketStr);
	 }
	 
	 // this var stores the practitioners to be shown now
	 var practToBeDisplayedCount = currPractCount + practDisplayBucket;
	 if(totalPractCount < (currPractCount + practDisplayBucket)){
		 practToBeDisplayedCount = totalPractCount; 
	 }
	 var practitionerComp;
	 // iterate and display the practitioner
	 for(count=(currPractCount+1);count<=practToBeDisplayedCount;count++){
		 practitionerComp = document.getElementById("Practitioner"+count);
		 if(practitionerComp){
			 practitionerComp.style.display = "block";
		 }
	 }
	 
	 // now check and hide the click for more component
	 if(practToBeDisplayedCount == totalPractCount){
		 var clickMoreComp = document.getElementById("ClickMore");
		 if(clickMoreComp){
			 clickMoreComp.style.display = "none";
		 }
	 }
	 
	 
	 // finally set the current practitioner count to the latest practitioner
	 // shown
	 if(currPractCountComp){
		 currPractCountComp.value = practToBeDisplayedCount;
	 }
	 
 }
 
 function handleKeyDownInSearchField(e){
	 // this function handles enter button press after specifying text
	 // in the search doctor field
	 var x = e || window.event;
	 var key = (x.keyCode || x.which);
	 if(key == 13 || key == 3){
	  	searchPractitioner();
	 }
 }
 
 function searchPractitioner(){
	 // this function lets a user search for practitioners in the page
	 // get the search text first
	 var searchTextComp = document.getElementById("searchtextbox");
	 var searchText = "";
	 if(searchTextComp){
		 searchText = searchTextComp.value;
		 searchText = searchText.toUpperCase();
		 // below code is for trimming the search text
		 // this code is done to support any browser
		 // that is why in built js functions are not used
		 var l=0; var r=searchText.length -1;
		 while(l < searchText.length && searchText[l] == ' '){
			  l++;
		 }
			
		 while(r > l && searchText[r] == ' '){
			r-=1;
		 }
		 searchText = searchText.substring(l, r+1);
	 }
	 // get the total practitioner count
	 // this is needed for iterating through the practitioner
	 // components and then match the name with the search text
	 var totalPractitionerCountComp = document.getElementById("totalPractitionerCount");
	 var totalPractitionerCount = 0;
	 try{
		 totalPractitionerCount = parseInt(totalPractitionerCountComp.value);	 
	 }catch(e){
		 totalPractitionerCount = 0;
	 }
	 
	 // code to check if the search text is empty text
	 // if so, we need to show all the practitioner components
	 if(searchText == ''){
		 for(count=1;count<=totalPractitionerCount;count++){
			 practitionerIdComp = document.getElementById("Practitioner"+count);
			 if(practitionerIdComp){
				 practitionerIdComp.style.display = "block";
			 }
		 }
		 return;
	 }
	 
	 // now iterate through the practitioner components
	 var practitionerNameComp;
	 var practitionerName;
	 for(count=1;count<=totalPractitionerCount;count++){
		 practitionerNameComp = document.getElementById("PractitionerName"+count);
		 practitionerIdComp = document.getElementById("Practitioner"+count);
		 if(practitionerNameComp && practitionerIdComp){
			 practitionerName = practitionerNameComp.value;
			 practitionerName = practitionerName.toUpperCase();
			 
			 textIndex = practitionerName.indexOf(searchText);
			 if(textIndex != 0){
				 practitionerIdComp.style.display = "none";
			 }else{
				 practitionerIdComp.style.display = "block";
			 }
		 }
	 }
 }
 
 function getPractitionerList(){
	 // this function gets the practitioner list again
	 // when user clicks on search on the left panel
	 
	 // first validate the user inputs and if validation fails
	 // show the error message and do not submit the page
	 
	 // stores the validation message
	 var validationMessage = "";
	 
	 // first validate the fields in the GUI
	 var datePickerComp = document.getElementById("preferredDateFromPage");
	 var datePicker = $("#preferredDateFromPage").data("kendoDatePicker");
	 var preferredApptDate;
	 // get the preferred date from the date picker component or
	 // the generalized element
	 if(datePickerComp){
		 if(datePicker){
			 preferredApptDate = datePicker.value();
		 }else{
			 preferredApptDate = new Date(datePickerComp.value);
		 }
	 }
     //preferredApptDate = datePicker.value();
     if(isNaN(preferredApptDate)){
    	 validationMessage = "Preferred date "+preferredApptDate+" is not valid. \n";
     }
     
    var currentDate = new Date();
     
	 // time validation
	var selectedFromTimeComp = document.getElementById("fromTimeInPage");
	var selectedFromTimeIndex;
	var selectedFromTime = "";
	if(selectedFromTimeComp){
		selectedFromTimeIndex = selectedFromTimeComp.selectedIndex;
		selectedFromTime = selectedFromTimeComp.value;
	}
	
	var selectedToTimeIndex;
	var selectedToTimeComp = document.getElementById("toTimeInPage");
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
	
	//alert(selectedFromTime+' || '+selectedToTime);
	
	var delimiter = ":";
	var dotIndex = selectedFromTime.indexOf(delimiter);
	var hrsStr = "";
	var hrs = 0;
	var minsStr = "";
	var mins = 0;
	if(dotIndex > 0){
		hrsStr = selectedFromTime.substring(0,dotIndex);
		minsStr = selectedFromTime.substring(dotIndex+1,selectedFromTime.length);
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
	if(!(isNaN(preferredApptDate))){
		//alert(hrs+ ' || '+mins);
		preferredApptDate.setHours(hrs);
		preferredApptDate.setMinutes(mins);
		preferredApptDate.setSeconds(0);
		
		// validate the appointment start time with current date only
		// when the start time is selected properly by user
		if((preferredApptDate < currentDate) && !selectedTimeIsInvalid){
			validationMessage += "Appointment start time cannot be less than current time. \n";
		}
	}
	
	// validate the appointment start time with appointment end time only
	// when the start time and end time is selected properly by user	
	if((selectedFromTimeIndex > selectedToTimeIndex) && !selectedTimeIsInvalid){
		validationMessage += "Appointment start time cannot be greater than or equal to end time. \n";
	}
	
	// speciality and facility validation
	// first speciality
	var hiddenSpecialityComp = document.getElementById("hdnSpecialtyId");
	var selectedSpeciality="";
	if(hiddenSpecialityComp){
		selectedSpeciality = hiddenSpecialityComp.value;
		selectedSpeciality = trimText(selectedSpeciality);
	}
	if(selectedSpeciality.length == 0){
		validationMessage += "Selected specialty is invalid. \n";
	}
	
	// validate selected facility
	var selectedFacility = "";
	var facilityComp = document.getElementById("hdnFacilityId");
	if(facilityComp){
		selectedFacility = facilityComp.value;
		selectedFacility = trimText(selectedFacility);
	}
	
	if(selectedFacility.length == 0){
		validationMessage += "Selected facility is invalid. \n";
	}
	
	if(validationMessage.length > 0){
		alert(validationMessage);
		return;
	}
	
	// need to set the values of hdnSelectedSpeciality,hdnSelectedSpecialityDesc
	//hdnPreferredDate - it is enough to set the hdnpreferreddate with value
	// hdnselectedspeciality and hdnselectedspecialitydesc is already set
	// with values
	//var dateTimePicker = $("#ApptPreferredDate").data("kendoDatePicker");
	//var preferredApptDate = dateTimePicker.value();
	
	// need to set value to hidden elements for the preferred date
	// and the preferred from and to time
	var dateValue = ""+preferredApptDate.getDate()+"/"+(preferredApptDate.getMonth()+1)+"/"+preferredApptDate.getFullYear();
	// preferred date
	var hdnPreferredDateComp = document.getElementById("preferredDateFromPage");
	if(hdnPreferredDateComp){
		hdnPreferredDateComp.value = dateValue;
	}
	
	// preferred from time
	var hdnPreferredFromTimeComp = document.getElementById("fromTimeInPage");
	if(hdnPreferredFromTimeComp){
		hdnPreferredFromTimeComp.value = selectedFromTime;
	}
	
	// preferred to time
	var hdnPreferredToTimeComp = document.getElementById("toTimeInPage");
	if(hdnPreferredToTimeComp){
		hdnPreferredToTimeComp.value = selectedToTime;
	}
	
	var hdnApptReqRefNumber = document.getElementById("referenceNumber");
	var apptNumber="";
	if(hdnApptReqRefNumber) {
		apptNumber = hdnApptReqRefNumber.value;
	}
	
	var rescheduleApptReqURL = "./ApptRequestDetailsServlet";
 	//rescheduleApptReqURL += "?referenceNumber="+apptNumber;
	 // finally all validations have passed - submit the form
	var formElement = document.getElementById("RescheduleMainForm");
	 if(formElement){
		 formElement.action = rescheduleApptReqURL;
		 formElement.submit();
	 }
 }
 
 function showPractitionerScheduleStatus(practitionerId,clinicCode,practitionerName){
	// this function transfers the control to the practitioner schedule
	// and time slot page
	
	 // this function will set the page's form url and submit it
	 var practitionerIdComp = document.getElementById("selectedPractitionerIdInPage");
	 if(practitionerIdComp){
		 practitionerIdComp.value = practitionerId;
	 }
	 
	 var clinicCodeComp = document.getElementById("hdnClinicCode");
	 if(clinicCodeComp){
		 clinicCodeComp.value = clinicCode;
	 }
	 
	 var practitionerNameComp = document.getElementById("selectedPractitionerNameInPage");
	 if(practitionerNameComp){
		 practitionerNameComp.value = practitionerName;
	 }
	 
	 
	 var formElement = document.getElementById("RescheduleMainForm");
	 if(formElement){
		 formElement.action = "./ScheduleStatusAndTimeslotServlet";
		 formElement.submit();
	 }
 }
 
 
 function trimText(textVal){
	 // this function trims a text
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
 
 
</script>

<style scoped>
 .practSchedulePopupContainerStyle {
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
	
	.practSchedulePopupContentStyle{
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
      width: 620px;
      height: 290px; 
	}
 
 </style>

</head>
<body>

<%
	String patientId = "";
patientId = (String) session
		.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
//patientId = request.getParameter("patientId");
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
//patientName = request.getParameter("patientName");
if (patientName == null) {
	patientName = "";
}

// appointment reference number
String appointmentReqRefNumber = request.getParameter
		(RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY);
if(appointmentReqRefNumber == null){
	appointmentReqRefNumber = "";
}

// preferred date from the GUI
String preferredDateFromPage = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM);

// preferred from time from the GUI
String preferredFromTimePage = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_FROM_TIME_PARAM);
// preferred to time from the GUI
String preferredToTimePage = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM);

// selected practitioner from the GUI
String practitionerFromPage = "";//request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM);
String practitionerIdFromPage = "";//request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM);

// get the appointment request details by executing the service
DetailsRequest detailsRequest = new DetailsRequest();
detailsRequest.setPatientId(patientId);
detailsRequest.setApptRequestReferenceNumber(appointmentReqRefNumber);
detailsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

DetailsServiceInvoker serviceInvoker = new DetailsServiceInvoker();
serviceInvoker.registerService(detailsRequest);
DetailsResponse detailsResponse = (DetailsResponse)serviceInvoker.getDataThroughWebService(detailsRequest);
boolean detailsResponseResult = detailsResponse.isSuccessful();
String errorMessage = detailsResponse.getErrorMessage();

String facilityId = "";
String facilityDesc = "";
// stores the preferred date value which will be
// filled from the response object
String preferredDateStr = "";
// stores the appointment requests preferred time
String apptPreferredFromTime = null;
String specialty = "";
String specialtyId = "";
// stores the preferred date which will be obtained from response object
Date preferredDateObj = null;
Date preferredFromTimeObj = null;
Date preferredToTimeObj = null;
// stores the preferred date in display format
String preferredDateDisplayStr = "";
// stores the from time in dd/mm/yyy HH:mi format
String preferredFromTimeStr = "";
//stores the from time in HH:mi format
String preferredFromTimeDisplayStr = "";
//stores the to time in dd/mm/yyy HH:mi format
String preferredToTimeStr = "";
//stores the to time in HH:mi format
String preferredToTimeDisplayStr = "";


// if the execution result of appointment request details service
// is ok - then get the details
if(detailsResponseResult){
	facilityId = detailsResponse.getFacilityId();
	facilityDesc = detailsResponse.getFacilityName();
	
	specialty = detailsResponse.getSpecialityName();
	specialtyId = detailsResponse.getSpecialityCode();
	preferredDateObj = detailsResponse.getPreferredDate();
	preferredDateStr = PortalHelper.getDateAsString(preferredDateObj,
			RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT);
	
	// we have got the details - so get data from it
	// first get the preferred date
	preferredDateDisplayStr = PortalHelper.getDateAsString(preferredDateObj,
			RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT2);
	// get the preferred from time from response
	preferredFromTimeStr = detailsResponse.getPreferredFromTime();
	preferredFromTimeObj = PortalHelper.getDateFromString(preferredFromTimeStr, 
				RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT);
	/* preferredFromTimeStr = PortalHelper.getDateAsString(preferredFromTimeObj,
			RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT); */
	preferredFromTimeDisplayStr = PortalHelper.getDateAsString(preferredFromTimeObj,
			RescheduleRequestConstants.APPTREQ_DETAILS_TIME_FORMAT);
	
	// get the to time and populate the vars
	preferredToTimeStr = detailsResponse.getPreferredToTime();
	preferredToTimeObj = PortalHelper.getDateFromString(preferredToTimeStr, 
			RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT);
	/* preferredToTimeStr = PortalHelper.getDateAsString(preferredToTimeObj,
			RescheduleRequestConstants.APPTREQ_DETAILS_DATE_TIME_FORMAT); */
	preferredToTimeDisplayStr = PortalHelper.getDateAsString(preferredToTimeObj,
			RescheduleRequestConstants.APPTREQ_DETAILS_TIME_FORMAT);
	
	// practitioner name
	practitionerFromPage = detailsResponse.getResourceName();
	practitionerIdFromPage = detailsResponse.getResourceId();
	
	// this var should be set with an initial value of the preferred date + 1 day
	// on subsequent invocation, this var will store the user selected date
	if(preferredDateFromPage == null || preferredDateFromPage.trim().equals("")){
		if(preferredDateObj != null){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(preferredDateObj);
			calendar.add(Calendar.DATE, 1);
			preferredDateObj = calendar.getTime();
			preferredDateFromPage = PortalHelper.getDateAsString(preferredDateObj,
					RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT);
		}else{
			preferredDateFromPage = preferredDateStr;	
		}
	}
	
}

//there is also a need to set the selected from time obtained from the page
// with a value if user has not selected it
/* if(preferredFromTimePage == null || preferredFromTimePage.trim().equals("")){
	preferredFromTimePage = preferredFromTimeDisplayStr;
}

// there is also a need to set the selected to time obtained from the page
// with a value if user has not selected it
if(preferredToTimePage == null || preferredToTimePage.trim().equals("")){
	preferredToTimePage = preferredToTimeDisplayStr;
} */

%>
<div id="wrapper">
<div class="fixedheader">	
<header id="header">
    <div id="headerinfo">
        <div class="row">
			<div id="headervisitinfo">
                	Welcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM 
            </div>    
            <div id="headerloginas">
                	 <strong>Welcome, <%=patientName %>, ID:<%=patientId %></strong>
            </div>
            <div id="headerlogout">
				<div><a href="../../servlet/LogoutServlet"  class="logout">
                    Logout</a>
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
                <li class="menuselect"><div class="menuicons"><img src="../../images/Appointment.png"/></div>My Appointments</li>
                <li><a href="../PortalHome.jsp"><div class="menuicons"><img src="../../images/Home.png"/></div>Home</a></li>
            </ul>
        </div>
    </div>
</div>
</div>
   <!-- #logo And Menu -->
   
<div class="line"></div>

	<form id="RescheduleMainForm" method="POST">
	<div id="content"  style="background-color: #ffffff;">
	
     <!-- #Patient Banner-->
		  
       <!-- #Patient Banner-->
	   <!-- #Content Area-->
     	<div id="contentbg">
		</div>
			<div id="contentArea">
			
				<div id="contentArearow">
				<div id="booknewbreadcrumb"><span class="contenbold"><a href="./UpcomingAppointments.jsp" class="backpage" >My Appointments</a></span> <span class="contenbold" id="arrow">></span> <span class="contenbold">Reschedule Appointment</span></div>
				<div class="row" >
						<div class="cellindex searchindex" >
						<div id="BooknewAppsearch">
							
							<div class="BookAppTitle">
								<a class="rectitle">  Modify Search </a>
							</div>
							<div class="SearchPanelReschedule">
                                     
                                <div class="searchfields">
                                <!--  code to check and show the data -->
                                	<%
                                		if(!detailsResponseResult){
                                	%>
                                	<span class="loginerror"><%=errorMessage %></span>
                                	<%
                                		}else{
                                	%>
									<div class="Apptitle">Specialty</div>
									<span><%=specialty %></span>
									<%
                                		}
									
									%>
								</div>
                            
								<div class="searchfields">
									<div class="Apptitle">Preferred date</div>
									<!-- <input class="textboxdatesearch" type="text" placeholder="30 Jan 2013"/> -->
									<input id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM%>" name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM%>" value="<%=preferredDateFromPage%>" style="width:180px;" />
								</div>
                                
								<div class="searchfieldsSpeciality  ">
									<div class="Apptitle ">Preferred time</div>
									<select class="Combotimesearch" id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_FROM_TIME_PARAM%>"
											name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_FROM_TIME_PARAM%>">
										<option value="">Select time</option>
										<%
										// now get the different times
										AppointmentTimeRequest apptFromTimeRequest = new AppointmentTimeRequest(
												ScheduleConstants.BOOKAPPT_START_TIME_IDENTIFIER);
										AppointmentTimeResponse apptFromTimeResponse = ScheduleHelper
												.getAppointmentTimeResponse(apptFromTimeRequest);
										
										// there is no need to worry for errors as of now since
										// the data returned is going to be valid and that too not from db
										List<AppointmentTime> apptStartTimeList = apptFromTimeResponse
												.getAppointmentTimeList();
										String apptTimeValue = null;
										String apptDataValue = null;
										String selected = "";
										// iterate through the list and show the time
										for (AppointmentTime apptTime : apptStartTimeList) {
											selected = "";
											apptTimeValue = apptTime.getAppointmentTime();
											apptDataValue = apptTime.getAppointmentDataValue();
											if(apptDataValue.equals(preferredFromTimePage)){
												selected = "selected";
											}
										%>
										<option value="<%=apptDataValue%>" <%=selected%>><%=apptTimeValue%></option>
										<%
											}
										%>
									</select>
									<span id="spacing"></span>
									<span >to</span>
									<select class="Combotimesearch" id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM%>"
											name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM%>">
										<option value="">Select time</option>
										<%
										selected = "";
										// now get the different times
										AppointmentTimeRequest apptToTimeRequest = new AppointmentTimeRequest(
												ScheduleConstants.BOOKAPPT_TO_TIME_IDENTIFIER);
										AppointmentTimeResponse apptToTimeResponse = ScheduleHelper
												.getAppointmentTimeResponse(apptToTimeRequest);
										// there is no need to worry for errors as of now since
										// the data returned is going to be valid and that too not from db
										List<AppointmentTime> apptToTimeList = apptToTimeResponse
												.getAppointmentTimeList();
										// iterate through the list and show the time
										for (AppointmentTime apptTime : apptToTimeList) {
											selected = "";
											apptTimeValue = apptTime.getAppointmentTime();
											apptDataValue = apptTime.getAppointmentDataValue();
											if(apptDataValue.equals(preferredToTimePage)){
												selected = "selected";
											}
										%>
										<option value="<%=apptDataValue%>" <%=selected%>><%=apptTimeValue%></option>
										<%
											}
										%> 
									</select>
								</div>
								
								<span class="btn marginalign" onclick="getPractitionerList()">Search</span>
							</div>
							
						</div>
						</div>
						<div class="tablebooknewapp" style="min-height: 450px;"> 
							<div class="row">
								<div class="celldivider">
								</div>
								<div class="cellindex bookingcell">
									<div id="BooknewAppDoctor">
										<div class="currentDetails" >
											<div class="title">
											<%
												// code to check if the response
												// is a failure - then show the 
												// error message
												if(!detailsResponseResult){
											%>
												<span class="loginerror"><%=errorMessage %></span>
											<%
												}else{
													// success case - so show details
											%>	
												<span class="contenbold marginalign">Reschedule Appointment</span>
												<span>Existing Appointment No: </span>
												<span><%=appointmentReqRefNumber %></span>
												<span>&nbsp;&nbsp;Date & time  </span>
												<span>:</span>
												<span><%=preferredDateDisplayStr %>, </span>
												<span><%=preferredFromTimeDisplayStr %> - <%=preferredToTimeDisplayStr %></span>
												<span>&nbsp;&nbsp;Doctor name: </span>
												<span><%=practitionerFromPage %></span>
											<%
												}
											%>	
											</div>
										</div>
										
										<%
											int totalPractitionerCount = 0;
										
											// code to check the appointment from and to times
											// if even one of it is null or empty
											// show a message accordingly
											if((preferredFromTimePage == null || preferredFromTimePage.trim().equals(""))
												|| (preferredToTimePage == null || preferredToTimePage.trim().equals(""))){
												String infoMessage = "Please select preferred time for the appointment request.";
										%>
										
										<div id="DoctorStrip">
											<div>
												<span class="contenbold"><%=infoMessage %>
												</span>
											</div>
										</div>
										<%
											}else{

												// code to show the user selected
												// date and time
												// var to store the user specified
												// preferred date - used for display purpose
												String userSelectedPreferredDate = null;
												if(preferredDateFromPage != null && !preferredDateFromPage.trim().equals("")){
													// the preferred date from page var stores value
													// in the format "dd/MM/yyyy" but we have to display
													// in the format "dd mmm yyyy" - hence the below conversion
													Date dateFromPage = PortalHelper.getDateFromString
															(preferredDateFromPage, 
																RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT);
													if(dateFromPage != null){
														userSelectedPreferredDate = PortalHelper.getDateAsString
															(dateFromPage, 
																RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT2);
													}
												}else{
													preferredDateFromPage = preferredDateStr;
													userSelectedPreferredDate = preferredDateStr;
												}
												
												// execute the practitioner service to get the 
												// practitioner data
												PractitionerRequest practitionerRequest = new PractitionerRequest();
												practitionerRequest.setPatientId(patientId);
												practitionerRequest
														.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
												// specialty related data is set here
												practitionerRequest.setSpecialityCode(specialtyId);
												practitionerRequest.setSpecialityDesc(specialty);
												// facility related data is set here
												practitionerRequest.setFacilityId(facilityId);
												practitionerRequest.setFacilityDesc(facilityDesc);
												
												practitionerRequest
												.setOperationStandardId(CreateAppointmentConstants.PRACTITIONER_SERVICE_OPRSTN_DEFAULT_VALUE);
												practitionerRequest
														.setResourceClass(CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);
												practitionerRequest.setLocale(Locale.getDefault().getLanguage());
												
												// need to set the preferred date, from time and to time
												// variable preferredDateFromPage holds the value of the preferred date
												// in the format "dd/MM/yyyy" - this is fine so set it to the request
												practitionerRequest.setPreferredDateAsString(preferredDateFromPage);
											
												// vars preferredFromTimePage and preferredToTimePage will
												// contain the value of from time and to time - set it to the request
												practitionerRequest.setPreferredStartTime(preferredFromTimePage);
												practitionerRequest.setPreferredEndTime(preferredToTimePage);
												
												PractitionerServiceInvoker practitionerServiceInvoker = new PractitionerServiceInvoker();
												practitionerServiceInvoker.registerService(practitionerRequest);
												PractitionerResponse practitionerResponse = (PractitionerResponse) practitionerServiceInvoker
														.getDataThroughWebService(practitionerRequest);
												
												int practitionerCount = 0;
												List<PractitionerModel> practModelList = null;
												if(practitionerResponse.isSuccessful()){
													practModelList = practitionerResponse.getPractitionerModelList();
													practitionerCount = practModelList != null? practModelList.size():0; 
												}
											
										%>
										<div id="BookingAppsearchresult"  >
											<div class="title">
													<span>Results for</span>
													<span class="contenbold">" </span>
													<span class="contenbold"><%=userSelectedPreferredDate %>, </span>
													<span class="contenbold">&nbsp;<%=preferredFromTimePage %> to <%=preferredToTimePage %>,&nbsp;  </span>
													<span class="contenbold"><%=specialty %></span>
													<span class="contenbold">" </span>
													<span class="floatright"><%=practitionerCount %> doctor (s)</span>
											</div>
											<div>
												<span class="contentnormal ">&nbsp;&nbsp;Search for doctor:</span><input class="textboxtimeSpeciality " id="searchtextbox" type="text" placeholder="Search" onkeydown="handleKeyDownInSearchField()"><img id="specialitySearch" onclick="searchPractitioner()" src="../../images/Search.png"/></input>
											</div>
										</div>
							
										<!--Doctor app here-->
										<div id="DoctorStrip">
										
										<%
											

											// this int denotes the practitioner count used
											// for displaying/hiding the practitioner
											int practitionerIndex = 1;
											String practitionerDisplayStyle = "display : block";
											final String PRACTITIONERID_PREFIX = "Practitioner";
											// constant to denote the prefix used for storing
											// the practitioner name in a hidden field
											// the hidden field is needed for search practitioner
											final String PRACTITIONERNAME_PREFIX = "PractitionerName";
											String practitionerIdString = null;
											String practitionerNameString = null;
											String practitionerErrorMessage = null;
											// code to check for the success or error of getting the practitioner list
											/* if (ErrorInfo.SUCCESS_CODE != practitionerErrorCode) { */
											if (!practitionerResponse.isSuccessful()) {	
												practitionerErrorMessage = practitionerResponse.getErrorMessage();	
											
										%>
											<span class="loginerror">
								       <%
								       		out.println(practitionerErrorMessage);
								       %>
										</span>
										<%
											} else {
												// once code comes here we can safely assume that
												// there are practitioners 
												// assign the practitioner count variable
												totalPractitionerCount = practModelList.size();
												// this is where all the pracititioners will be displayed
												for (PractitionerModel practModel : practModelList) {
													if (practitionerIndex > CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT) {
														practitionerDisplayStyle = "display : none";
													}
													practitionerIdString = PRACTITIONERID_PREFIX
															+ practitionerIndex;

													practitionerNameString = PRACTITIONERNAME_PREFIX
															+ practitionerIndex;
													%>
												<!--strip here-->
												<div id="<%=practitionerIdString%>" class="DoctorApp" style="<%=practitionerDisplayStyle%>;height:110px;">
													<div class="DoctorDetailStrip" style="height:102px;">
														<div class="DoctorInnerstrip" style="height:100px;">
														<div class="ImageSchedule"><img class="doctorIcon" src="../../images/doctor.png"/><a class="ViewSchedulefont " href="#" onclick="showPractitionerSchedule('<%=practModel.getPractitionerId()%>','<%=practModel.getPractitionerName()%>')">View schedule</a></div>
														<div class="DocDetails" style="height:60px;"><span class="contenbold"><%=practModel.getPractitionerName()%></span><br/>
															<span class="contentnormal"><%=specialty%></span><br/>
															<span class="contentnormal"><%=facilityDesc%></span>
														</div>
														<div>
															<span id="spacing" class="btn"><a href="#" onclick="showPractitionerScheduleStatus('<%=practModel.getPractitionerId()%>','<%=practModel.getClinicCode()%>','<%=practModel.getPractitionerName()%>')" class="rectitle"> Select</a></span>
														</div>
														</div>
													</div>
													
													<!--  code to set the practitioner name in a hidden field -->
													<input type="hidden" id="<%=practitionerNameString%>" name="<%=practitionerNameString%>" value="<%=practModel.getPractitionerName()%>" >												
												</div>
											<!--strip here-->	
													
													
											<%	
													practitionerIndex++;
													}
												}
											%>
										</div>
										<!--Doctor app here-->
										<%
											String clickMoreDisplayStyle = "display : none";
											// check if there are more than 6 practitioners
											// then only "click for more" should be shown in the GUI
											if (totalPractitionerCount > CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT) {
												clickMoreDisplayStyle = "display : block";
											}
										%>
										<div id="BookingAppClickmore" id="ClickMore" style="<%=clickMoreDisplayStyle%>">
											<span class="MoreResult">Click for more</span>
										</div>
										
										<%
											}
										%>
									</div>
								</div>
							</div>
						</div>
						
					</div>
				</div> 
			</div>
			
		</div>
       <!-- #Content Area-->
       	<!-- values obtained from service are stored in the below hidden elements -->
       	<!-- specialty id, specialty description, facility id, facility desc, -->
       	<!-- appointment reference number -->
       	<input type="hidden" id="<%=RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY %>" name="<%=RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY %>" value="<%=appointmentReqRefNumber %>">
       	<input type="hidden" id="hdnSpecialtyId" name="hdnSpecialtyId" id="hdnSpecialtyId" value="<%=specialtyId %>">
       	<input type="hidden" id="hdnSpecialtyDesc" name="hdnSpecialtyDesc" id="hdnSpecialtyDesc" value="<%=specialty %>">
       	<input type="hidden" id="hdnFacilityId" name="hdnFacilityId" id="hdnFacilityId" value="<%=facilityId %>">
       	<input type="hidden" id="hdnFacilityDesc" name="hdnFacilityDesc" id="hdnFacilityDesc" value="<%=facilityDesc %>">
       
       	<!-- values selected from the page are stored in the below hidden elements -->
       	<input type="hidden" id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM %>" name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM %>" value="<%=practitionerIdFromPage%>">
       	<input type="hidden" id ="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM %>" name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM %>" value="<%=practitionerFromPage %>">
       	<input type="hidden" id="hdnClinicCode" name="hdnClinicCode" id="hdnClinicCode" value="">
       	<!-- for show more practitioners -->
       	<!--  the hidden vars used for display/hide of practitioner components -->
		<input type="hidden" id="totalPractitionerCount" name="totalPractitionerCount" id="totalPractitionerCount" value="<%=totalPractitionerCount%>">
		<input type="hidden" id="currentPractitionerCount" name="currentPractitionerCount" id="currentPractitionerCount" value="<%=CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT%>">
		<input type="hidden" id="practitionerDisplayBucket" name="practitionerDisplayBucket" id="practitionerDisplayBucket" value="<%=CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT%>">
       
       </form> 
	
    <!-- #content-->

<div id="practScheduleContainerDiv" class="practSchedulePopupContainerStyle" style="visibility:hidden;">
	<div id="practScheduleDiv" class="practSchedulePopupContentStyle" style="visibility:hidden;">
	</div>
</div>    
    
<div class="Footerbg"  style="margin-top:0px;">
	
	<div id="poweredby">
			<p class="poweredby">Powered by <img src="../../images/csc.png" width="25" height="14"></p>
    </div>
</div>
</div>
<!-- #wrapper -->


</body>
</html>

