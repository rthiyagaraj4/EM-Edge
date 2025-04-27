<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.Locale"%>
<%@page import="portalrefimpl.facility.facilityforpatient.response.FacilityListResponse"%>
<%@page import="portalrefimpl.facility.facilityforpatient.request.FacilityListRequest"%>
<%@page import="portalrefimpl.common.model.Facility"%>
<%@page import="portalrefimpl.schedule.createappointment.response.PractitionerModel"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.schedule.createappointment.response.PractitionerResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerServiceInvoker"%>
<%@page import="portalrefimpl.schedule.createappointment.request.PractitionerRequest"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTime"%>
<%@page import="portalrefimpl.schedule.ScheduleConstants"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeRequest"%>
<%@page import="portalrefimpl.schedule.ScheduleHelper"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.schedule.createappointment.response.SpecialityModel"%>
<%@page import="portalrefimpl.schedule.createappointment.response.SpecialityResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.svc.serviceinvoker.SpecialityServiceInvoker"%>
<%@page import="portalrefimpl.schedule.createappointment.request.SpecialityRequest"%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page import="java.util.Date"%>
<%@page import="portalrefimpl.schedule.createappointment.CreateAppointmentConstants"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Patient Portal - Book Appointment :::</title>

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
         $("#ApptPreferredDate").kendoDatePicker({
        	    format: "dd/MM/yyyy"
         });
 });
 
 function searchSpeciality(){
	 // this function performs the search when user clicks on search
	 // after specifying the speciality
	 
	 // first get the text entered by user
	 var searchTextComp = document.getElementById("specialitySearchText");
	 var searchText="";
	 if(searchTextComp){
		 searchText = searchTextComp.value;
		 // convert to upper case - this will be useful
		// for string comparision		 
		 searchText = searchText.toUpperCase();
	 }
	 
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
	  
	  // get the number of specialities shown in the GUI
	 var specialityIndexCountComp = document.getElementById("hdnSpecialityIndex");
	 var specialityIndexCountStr;
	 var specialityIndexCount = 0;
	 if(specialityIndexCountComp){
		 specialityIndexCountStr = specialityIndexCountComp.value;
		 specialityIndexCount = parseInt(specialityIndexCountStr);
	 }
	 //alert(specialityIndexCount);
	 
	 var specialityIdComp;
	 var specialityText;
	 var textIndex=-1;
	  
	  // check if the search text is empty - if so
	  // bring back all the hidden elements 
	 if(searchText == ''){
		 for(count=2;count<=specialityIndexCount;count++){
			 specialityIdComp = document.getElementById("Speciality"+count);
			 if(specialityIdComp){
				 specialityIdComp.style.display = "block";
			 }
		 }
		 return;
	 }
	
	 // loop through the speciality components
	 // and hide them if their value does not match the text entered
	 for(count=2;count<=specialityIndexCount;count++){
		 specialityIdComp = document.getElementById("Speciality"+count);
		 if(specialityIdComp){
			 specialityText = specialityIdComp.innerHTML;
			 // convert the text to upper case - usefull for
			 // case insensitive string comparision
			 specialityText = specialityText.toUpperCase();
			 textIndex = specialityText.indexOf(searchText);
			 if(textIndex != 0){
				 specialityIdComp.style.display = "none";
			 }else{
				 specialityIdComp.style.display = "block";
			 }
		 }
	 }
	 
 }
 
 function selectSpeciality(spanElement,specialityCodeId,specialityDescId){
	 // this function sets the background color of a selected specialty
	 // this function also sets the hidden speciality elements with
	 // the value of the selected speciality and the speciality description
	 if(spanElement){
		 spanElement.style.backgroundColor="#C1D994";
		 //alert(spanElement.id);
	 }
	 
	 var hdnSpecialtySpanElementId = document.getElementById("hdnSelectedSpecialitySpanElementId");
	 if(hdnSpecialtySpanElementId){
		 //alert(hdnSpecialtySpanElementId.value);
		 var selectedSpanElementId = document.getElementById(hdnSpecialtySpanElementId.value);
		 if(selectedSpanElementId){
			 //selectedSpanElementId.style.backgroundColor="#FFFFFF";
			 selectedSpanElementId.className = "options";
		 }
		 hdnSpecialtySpanElementId.value = spanElement.id;
	 }
	 
	 // set the selected speciality in the hidden element
	 var specialityCodeElement = document.getElementById(specialityCodeId);
	 var selectedSpecialityComp = document.getElementById("hdnSelectedSpeciality");
	 if(specialityCodeElement && selectedSpecialityComp){
		 selectedSpecialityComp.value = specialityCodeElement.value;
	 }
	 
	 // set the selected speciality's description in the hidden element
	 var specialityDescElement = document.getElementById(specialityDescId);
	 var selectedSpecialityDescComp = document.getElementById("hdnSelectedSpecialtyDesc");
	 if(specialityDescElement && selectedSpecialityDescComp){
		 selectedSpecialityDescComp.value = specialityDescElement.value;
	 }
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
 
 function showPractitionerSchedule(practitionerId,practitionerName){
	 // this function submits the form to show the practitioner schedule
	 // information in a pop up window
	/*  var patientIdComp = document.getElementById("hdnPatientId");
	 if(patientIdComp){
		 patientIdComp.value = practitionerId;
	 } */
	 var datePickerComp = document.getElementById("ApptPreferredDate");
	 var dateTimePicker = $("#ApptPreferredDate").data("kendoDatePicker");
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
	 
	 var hiddenSpecialityComp = document.getElementById("hdnSelectedSpeciality");
	 var selectedSpeciality="";
	 if(hiddenSpecialityComp){
		 selectedSpeciality = hiddenSpecialityComp.value;
	 }
	 /* var selectedSpeciality = $("#Speciality").find('option:selected').val(); */
	 var hiddenSpecialityDescComp = document.getElementById("hdnSelectedSpecialtyDesc");
	 var selectedSpecialityDesc = "";
	 if(hiddenSpecialityDescComp){
		 selectedSpecialityDesc = hiddenSpecialityDescComp.value;
	 }
	 /* var selectedSpecialityDesc = $("#Speciality").find('option:selected').text(); */
	 
	 var selectedFacility = $("#Facility").find('option:selected').val();
	 var selectedFacilityDesc = $("#Facility").find('option:selected').text();
	 
	 var selectedFromTime = $("#ApptPreferredFromTime").find('option:selected').val();
	 var selectedToTime = $("#ApptPreferredToTime").find('option:selected').val();
	 
	 // escape
	 selectedFacilityDesc = escape(selectedFacilityDesc);
	 selectedSpecialityDesc = escape(selectedSpecialityDesc);
	 practitionerName = escape(practitionerName);
	 
	 var popupUrl = "./PractitionerScheduleServlet?";
	 popupUrl += "ApptPreferredDate="+dateValue;
	 popupUrl +="&FacilityId="+selectedFacility;
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
	 var validationMessage = "";
	 
	 // first validate the fields in the GUI
	 var datePickerComp = document.getElementById("ApptPreferredDate");
	 var datePicker = $("#ApptPreferredDate").data("kendoDatePicker");
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
	var selectedFromTimeComp = document.getElementById("ApptPreferredFromTime");
	var selectedFromTimeIndex;
	var selectedFromTime = "";
	if(selectedFromTimeComp){
		selectedFromTimeIndex = selectedFromTimeComp.selectedIndex;
		selectedFromTime = selectedFromTimeComp.value;
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
	var hiddenSpecialityComp = document.getElementById("hdnSelectedSpeciality");
	var selectedSpeciality="";
	if(hiddenSpecialityComp){
		selectedSpeciality = hiddenSpecialityComp.value;
		selectedSpeciality = trimText(selectedSpeciality);
	}
	if(selectedSpeciality.length == 0){
		validationMessage += "Selected speciality is invalid. \n";
	}
	
	// validate selected facility
	var selectedFacility = "";
	var facilityComp = document.getElementById("Facility");
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
	var dateValue = ""+preferredApptDate.getDate()+"/"+(preferredApptDate.getMonth()+1)+"/"+preferredApptDate.getFullYear();
	var hdnPreferredDateComp = document.getElementById("hdnPreferredDate");
	if(hdnPreferredDateComp){
		hdnPreferredDateComp.value = dateValue;
	}
	
	 // finally all validations have passed - submit the form
	var formElement = document.getElementById("bookappointmentform");
	 if(formElement){
		 formElement.action = "../schedule/SpecialityServlet";
		 formElement.submit();
	 }
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
 
 function showPractitionerScheduleStatus(practitionerId,clinicCode,practitionerName){
	 // this function shows the practitioner schedule and time slot
	 // page
	 // this function will set the page's form url and submit it
	 var practitionerIdComp = document.getElementById("hdnPractitionerId");
	 if(practitionerIdComp){
		 practitionerIdComp.value = practitionerId;
	 }
	 
	 var clinicCodeComp = document.getElementById("hdnClinicCode");
	 if(clinicCodeComp){
		 clinicCodeComp.value = clinicCode;
	 }
	 
	 var practitionerNameComp = document.getElementById("hdnPractitionerName");
	 if(practitionerNameComp){
		 practitionerNameComp.value = practitionerName;
	 }
	 
	 
	 var formElement = document.getElementById("bookappointmentform");
	 if(formElement){
		 formElement.action = "./PractitionerTimeSlotServlet";
		 formElement.submit();
	 }
	 
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

	String selectedFacility = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY);
	if (selectedFacility == null) {
		selectedFacility = "";
	}

	// get the speciality from the request
	String speciality = request
			.getParameter(CreateAppointmentConstants.SPECIALITY_PARAMETER_KEY);
	if (speciality == null || speciality.trim().equals("")) {
		speciality = request.getParameter("hdnSelectedSpeciality");
		if (speciality == null) {
			speciality = "";
		}
	}

	// get the selected speciality description
	String specialityDesc = request
			.getParameter("hdnSelectedSpecialtyDesc");
	if (specialityDesc == null) {
		specialityDesc = "";
	}

	// get the selected facility description as well
	String selectedFacilityDesc = request
			.getParameter("hdnSelectedFacilityDesc");
	if (selectedFacilityDesc == null) {
		selectedFacilityDesc = "";
	}

	String apptPreferredDate = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY);
	if (apptPreferredDate == null) {
		apptPreferredDate = "";
	}

	String apptPreferredFromTime = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY);
	if (apptPreferredFromTime == null) {
		apptPreferredFromTime = "";
	}

	String apptPreferredToTime = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY);
	if (apptPreferredToTime == null) {
		apptPreferredToTime = "";
	}

	String preferredDateStr = request.getParameter("hdnPreferredDate");
	if (preferredDateStr == null) {
		preferredDateStr = apptPreferredDate;
	}
	Date preferredDate = PortalHelper.getDateFromString(
			preferredDateStr, "dd/MM/yyyy");

	// this string will contain the selected speciality's description
	// the speciality's code only will get passed to this page
	// but we need the description for the GUI
	//String selectedSpecialityDesc = null;

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

	// get the facility list as a normal java service
	// this is done only to improve performance
	FacilityListRequest facilityListRequest = new FacilityListRequest();
	facilityListRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

	FacilityListServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
	FacilityListResponse facilityListResponse = facilityListServiceInvoker.
										getDataThroughService(facilityListRequest);
	
	/* FacilityListSvcImpl facilityListSvcImpl = new FacilityListSvcImpl();
	FacilityListResponse facilityListResponse = facilityListSvcImpl
			.getFacilityList(facilityListRequest); */
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
                	 <strong>Welcome, <%=patientName%>, ID:<%=patientId%></strong>
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
	<div id="content"  style="background-color: #ffffff;padding-bottom: 22px;">
     <!-- #Patient Banner-->
       <!-- #Patient Banner-->
	   <!-- #Content Area-->
     	<div id="contentbg">
		</div>
			<div id="contentArea" style="background-color: #ffffff;">
				<div id="contentArearow" > 
						<div id="booknewbreadcrumb"><span class="contenbold"><a href="UpcomingAppoinments.html" class="backpage">My appointments</a></span> <span class="contenbold" id="arrow">></span> <span class="contenbold">Book new appointment</span></div>
					<div class="row">
						<div class="cellindex searchindex" >
						<form id="bookappointmentform" method="POST">
						<div id="BooknewAppsearch" >
							<div class="BookAppTitle"  >
								<a class="rectitle" href="BooknewAppoinmentRecentSearch.html">Recent doctor</a>
							</div>
							<div class="BookAppTitle">
								<a class="rectitle">  Search doctor</a>
							</div>
							<div id="SearchPanel" style="height:330px;">
								<div class="searchfields">
									<div class="Apptitle">Preferred date</div>
									<!-- <input class="textboxdatesearch" type="text" placeholder="16 Dec 2012"/> -->
									<input id="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY%>" name="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY%>" value="<%=preferredDateStr%>" style="width:180px;" />
								</div>
								<div class="searchfields">
									<div class="Apptitle ">Preferred time</div>
									<select class="Combotimesearch" id="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>"
											name="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>">
									    <%
									    	// check for empty alone is fine
									    	if (apptPreferredFromTime.trim().equals("")) {
									    %>
									    	<option value="" selected="selected">Select time</option>
									    <%
									    	} else {
									    %>
											<option value="">Select time</option>
										<%
											}

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
											// used for storing the selected style
											String selected = "";
											// iterate through the list and show the time
											for (AppointmentTime apptTime : apptStartTimeList) {
												selected = "";
												apptTimeValue = apptTime.getAppointmentTime();
												apptDataValue = apptTime.getAppointmentDataValue();
												/* if (apptPreferredFromTime.equalsIgnoreCase(apptTimeValue)) {
													selected = "selected";
												} */
												if (apptPreferredFromTime.equalsIgnoreCase(apptDataValue)) {
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
									<select class="Combotimesearch" id="<%=CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY%>"
											name="<%=CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY%>">
										 <%
										 	// check for empty alone is fine
										 	if (apptPreferredToTime.trim().equals("")) {
										 %>
									    	<option value="" selected="selected">Select time</option>
									    <%
									    	} else {
									    %>
											<option value="">Select time</option>
										<%
											}

											// now get the different times
											AppointmentTimeRequest apptToTimeRequest = new AppointmentTimeRequest(
													ScheduleConstants.BOOKAPPT_TO_TIME_IDENTIFIER);
											AppointmentTimeResponse apptToTimeResponse = ScheduleHelper
													.getAppointmentTimeResponse(apptToTimeRequest);
											// there is no need to worry for errors as of now since
											// the data returned is going to be valid and that too not from db
											List<AppointmentTime> apptToTimeList = apptToTimeResponse
													.getAppointmentTimeList();
											apptTimeValue = null;
											// iterate through the list and show the time
											for (AppointmentTime apptTime : apptToTimeList) {
												selected = "";
												apptTimeValue = apptTime.getAppointmentTime();
												apptDataValue = apptTime.getAppointmentDataValue();
												/* if (apptPreferredToTime.equalsIgnoreCase(apptTimeValue)) {
													selected = "selected";
												} */
												if (apptPreferredToTime.equalsIgnoreCase(apptDataValue)) {
													selected = "selected";
												}
										%>	
										<option value="<%=apptDataValue%>" <%=selected%>><%=apptTimeValue%></option>
										<%
											}
										%> 
									</select>
								</div>
								
								<!-- facility is introduced here -->
								<div class="searchfields">
								<div class="Apptitle">Facility</div>
								 <select class="textbox" id="<%=CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY%>" name="<%=CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY%>" style="width: 175px;">
			       				   	<option value="" selected="selected">----All----</option>
			       				   	<%
			       				   		/* ErrorInfo facilityListErrorInfo = facilityListResponse
			       				   				.getErrorInfo(); */
			       				   		List<Facility> facilityList = null;
			       				   		/* if (ErrorInfo.SUCCESS_CODE == facilityListErrorInfo.getErrorCode()) { */
			       				   		if (facilityListResponse.isSuccessful()) {	
			       				   			facilityList = facilityListResponse.getFacilityList();
			       				   			for (Facility facility : facilityList) {
			       				   				if (selectedFacility.equalsIgnoreCase(facility
			       				   						.getFacilityId())) {
			       				   	%>			
									  	<option value="<%=facility.getFacilityId()%>" selected="selected"><%=facility.getFacilityName()%></option>
									  	<%
									  		} else {
									  	%>
									  	<option value="<%=facility.getFacilityId()%>"><%=facility.getFacilityName()%></option>		
								  		<%
										  			}
										  		}
											}
										 %>
			       				  </select> 
								</div>
								
								<div class="searchfieldsSpeciality">
									<div class="Apptitle">Speciality</div>
									<div id="DetailedSearch"  style="height:107px;">
										<input class="textboxtimeSpeciality" type="text" id="specialitySearchText" name="specialitySearchText" id="specialitySearchText" placeholder="Search"><img id="specialitySearch" src="../../images/Search.png" onclick="searchSpeciality()"/></input>
										<div class="specialityDiv" style="height:80px;">
											<%
												int specialityIndex = 1;
												String specialityCodeVal = "SpecialityCode" + specialityIndex;
												String specialityId = "Speciality" + specialityIndex;
												String selectedStyle = "options";
												String spanDisplayStyle = "display:block";
												String specialityDescId = "SpecialityDesc" + specialityIndex;
												String selectedSpanElementId = null;
												// this is for empty speciality
												if (speciality.trim().equals("")) {
													selectedSpanElementId = specialityId;
											%>
											<span class="options selectedopt" id="<%=specialityId%>" name="<%=specialityId%>" style="<%=spanDisplayStyle%>;padding-left:10px;padding-top:5px;padding-right:10px;padding-bottom:5px;" onclick="selectSpeciality(this,'<%=specialityCodeVal%>','<%=specialityDescId%>')">Not Known</span>
											<input type="hidden" id="<%=specialityCodeVal%>" name="<%=specialityCodeVal%>" value="">
											<input type="hidden" id="<%=specialityDescId%>" name="<%=specialityDescId%>" value="">
											<%
												} else {
											%>
											<span class="options" id="<%=specialityId%>" name="<%=specialityId%>" style="<%=spanDisplayStyle%>;padding-left:10px;padding-top:5px;padding-right:10px;padding-bottom:5px;" onclick="selectSpeciality(this,'<%=specialityCodeVal%>','<%=specialityDescId%>')">Not Known</span>
											<input type="hidden" id="<%=specialityCodeVal%>" name="<%=specialityCodeVal%>" value="">
											<input type="hidden" id="<%=specialityDescId%>" name="<%=specialityDescId%>" value="">
											<%
												}

												// code to show the specialities 
												List<SpecialityModel> specialityList = null;
												String specialityCode;
												String specialityDescription;
												// iterate through the speciality list	
												// and show it in the UI
												if(sresponse.isSuccessful()){
													specialityList = sresponse
															.getSpecialityList();
													if (specialityList != null) {
														for (SpecialityModel s : specialityList) {
	
															selectedStyle = "options";
															specialityCode = s.getSpecialityCode();
															specialityDescription = s.getShortDesc();
															
	
															specialityIndex++;
															specialityId = "Speciality" + specialityIndex;
															specialityCodeVal = "SpecialityCode" + specialityIndex;
															specialityDescId = "SpecialityDesc" + specialityIndex;
															
															// check if the selected speciality
															// equals any of the specialities
															// obtained from the service
															if (speciality.equals(specialityCode)) {
																selectedStyle = "options selectedopt";
																// set the selected speciality description
																// this will be used
																//selectedSpecialityDesc = specialityDescription;
																selectedSpanElementId = specialityId;
															}
											%>
											<span class="<%=selectedStyle%>"  id="<%=specialityId%>" name="<%=specialityId%>" style="<%=spanDisplayStyle%>;padding-left:10px;padding-top:5px;padding-right:10px;padding-bottom:5px;" onclick="selectSpeciality(this,'<%=specialityCodeVal%>','<%=specialityDescId%>')"><%=specialityDescription%></span>
											<input type="hidden" id="<%=specialityCodeVal%>" name="<%=specialityCodeVal%>" value="<%=specialityCode%>">
											<input type="hidden" id="<%=specialityDescId%>" name="<%=specialityDescId%>" value="<%=specialityDescription%>">
											<%
														}
													}
												}
											%>
											<!-- hidden element to store the number of speciality indices found from data -->
											<input type="hidden" id="hdnSpecialityIndex" name="hdnSpecialityIndex" id="hdnSpecialityIndex" value="<%=specialityIndex%>">
											<input type="hidden" id="hdnSelectedSpeciality" name="hdnSelectedSpeciality" id="hdnSelectedSpeciality" value="<%=speciality%>">
											<input type="hidden" id="hdnSelectedSpecialtyDesc" name="hdnSelectedSpecialtyDesc" id="hdnSelectedSpecialtyDesc" value="<%=specialityDesc%>">
											<input type="hidden" id="hdnPreferredDate" name="hdnPreferredDate" id="hdnPreferredDate" value="<%=preferredDateStr%>">
											<input type="hidden" id="hdnPractitionerId" name="hdnPractitionerId" id="hdnPractitionerId" value="">
											<input type="hidden" id="hdnClinicCode" name="hdnClinicCode" id="hdnClinicCode" value="">
											<input type="hidden" id="hdnPractitionerName" name="hdnPractitionerName" id="hdnPractitionerName" value="">
											<input type="hidden" id="hdnSelectedFacilityDesc" name="hdnSelectedFacilityDesc" id="hdnSelectedFacilityDesc" value="<%=selectedFacilityDesc%>">
											<input type="hidden" id="hdnSelectedSpecialitySpanElementId" name="hdnSelectedSpecialitySpanElementId" id="hdnSelectedSpecialitySpanElementId" value="<%=selectedSpanElementId%>">
										</div>
									</div>
								</div>
								<span class="btn marginalign" onclick="getPractitionerList()">Search</span>
							</div>
							
						</div>
						
						</form>
						
						</div>
						
						<%
							// code to get the selected date in required display format
							String selectedDateDisplayValue = preferredDateStr;
							if (preferredDate != null) {
								selectedDateDisplayValue = PortalHelper.getDateAsString(
										preferredDate,
										ScheduleConstants.BOOKAPPT_DATE_DISPLAY_FORMAT);
							}

							// code to get the list of practitioners goes here
							PractitionerRequest practitionerRequest = new PractitionerRequest();
							practitionerRequest.setPatientId(patientId);
							practitionerRequest
									.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
							practitionerRequest.setSpecialityCode(speciality);
							// need to set other request parameters as well
							// facility id
							practitionerRequest.setFacilityId(selectedFacility);
							// preferred date
							practitionerRequest.setPreferredDateAsString(preferredDateStr);
							practitionerRequest.setPreferredStartTime(apptPreferredFromTime);
							practitionerRequest.setPreferredEndTime(apptPreferredToTime);
							practitionerRequest.setLocale(Locale.getDefault().getLanguage());
							practitionerRequest
									.setOperationStandardId(CreateAppointmentConstants.PRACTITIONER_SERVICE_OPRSTN_DEFAULT_VALUE);
							practitionerRequest
									.setResourceClass(CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);
							practitionerRequest.setSpecialityDesc(specialityDesc);
							practitionerRequest.setFacilityDesc(selectedFacilityDesc);

							// initialize the practitioner service and register it
							/* PractitionerSvcImpl practitionerSvcImpl = new PractitionerSvcImpl();
							practitionerSvcImpl.registerService(practitionerRequest); */
							// initialize the service invoker and get the response object
							PractitionerServiceInvoker practitionerServiceInvoker = new PractitionerServiceInvoker();
							practitionerServiceInvoker.registerService(practitionerRequest);
							PractitionerResponse practitionerResponse = (PractitionerResponse) practitionerServiceInvoker
									.getDataThroughWebService(practitionerRequest);
							// get the error info object and inspect it for success or failure
							/* ErrorInfo practitionerErrorInfo = practitionerResponse
									.getErrorInfo(); */
							//int practitionerErrorCode = practitionerErrorInfo.getErrorCode();
							String practitionerErrorMessage = null;//practitionerResponse.getErrorMessage();
							/* practitionerErrorInfo
									.getErrorMessage(); */
							// get the number of doctors
							int noOfDoctors = 0;
							List<PractitionerModel> practitionerModelList = practitionerResponse
									.getPractitionerModelList();
							if (practitionerModelList != null) {
								noOfDoctors = practitionerModelList.size();
							}

							// stores the from time and to time in display format
							// it is needed for display purpose only
							String selectedFromTimeDisplayVal = ScheduleHelper
									.getApptSelectedTimeInDisplayFormat(apptPreferredFromTime);
							String selectedToTimeDisplayVal = ScheduleHelper
									.getApptSelectedTimeInDisplayFormat(apptPreferredToTime);
						%>
						
						
						<div class="tablebooknewapp" style="min-height: 455px;"> 
							<div class="row">
								<div class="celldivider">
								</div>
								<div class="cellindex bookingcell">
								<div id="BooknewAppDoctor">
										<div id="BookingAppsearchresult" >
											<div class="title">
													<span>Results for</span>
													<span class="contenbold">" </span>
													<span class="contenbold"><%=selectedDateDisplayValue%>, </span>
													<span class="contenbold">&nbsp;<%=selectedFromTimeDisplayVal%> to <%=selectedToTimeDisplayVal%>,&nbsp;</span>
													<span class="contenbold"><%=specialityDesc%></span>
													<span class="contenbold">" </span>
													<span class="floatright"><%=noOfDoctors%> doctor (s)</span>
											</div>
											<div>
											<span class="contentnormal ">&nbsp;&nbsp;Search for doctor:</span><input class="textboxtimeSpeciality " id="searchtextbox" type="text" placeholder="Search" onkeydown="handleKeyDownInSearchField()"><img id="specialitySearch" onclick="searchPractitioner()" src="../../images/Search.png"/></input>
												
											</div>
										</div>
										
										<!--Doctor app here-->
										<div id="DoctorStrip">
										
										<%
											int totalPractitionerCount = 0;

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
												totalPractitionerCount = practitionerModelList.size();
												// this is where all the pracititioners will be displayed
												for (PractitionerModel practModel : practitionerModelList) {
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
														<span class="contentnormal"><%=specialityDesc%></span><br/>
														<span class="contentnormal"><%=selectedFacilityDesc%></span>
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
										
										<!--  the hidden vars used for display/hide of practitioner components -->
										<input type="hidden" id="totalPractitionerCount" name="totalPractitionerCount" id="totalPractitionerCount" value="<%=totalPractitionerCount%>">
										<input type="hidden" id="currentPractitionerCount" name="currentPractitionerCount" id="currentPractitionerCount" value="<%=CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT%>">
										<input type="hidden" id="practitionerDisplayBucket" name="practitionerDisplayBucket" id="practitionerDisplayBucket" value="<%=CreateAppointmentConstants.PRACTITIONER_DISPLAY_RECORD_COUNT%>">
										
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
										<div class="BookingAppClickmore" id="ClickMore" style="<%=clickMoreDisplayStyle%>">
											<span class="MoreResult" onclick="showMorePractitioner()">Click for more</span>
										</div>
										
									</div>
								</div>
								
								
									
							</div>
						</div>
					</div>
				</div> 
			</div>
			
		</div>
       <!-- #Content Area-->
    <!-- #content-->
    
<div id="practScheduleContainerDiv" class="practSchedulePopupContainerStyle" style="visibility:hidden;">
	<div id="practScheduleDiv" class="practSchedulePopupContentStyle" style="visibility:hidden;">
	</div>
</div>    
    
<div class="Footerbg" style="margin-top:0px;">
	<div id="poweredby">
			<p class="poweredby">Powered by <img src="../../images/csc.png" width="25" height="14" style="vertical-align:middle;"></p>
    </div>
</div>
</div>

</body>
</html>

