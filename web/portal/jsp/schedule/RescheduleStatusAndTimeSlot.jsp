<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.contactreason.common.model.ContactReasonModel"%>
<%@page import="portalrefimpl.contactreason.rescheduleapptrequest.response.ContactReasonResponse"%>
<%@page import="portalrefimpl.contactreason.rescheduleapptrequest.svc.ContactReasonServiceInvoker"%>
<%@page import="portalrefimpl.contactreason.rescheduleapptrequest.request.ContactReasonRequest"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTime"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeResponse"%>
<%@page import="portalrefimpl.schedule.ScheduleConstants"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeRequest"%>
<%@page import="portalrefimpl.schedule.createappointment.response.TimeSlot"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.schedule.createappointment.response.PractitionerTimeSlotResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerTimeSlotServiceInvoker"%>
<%@page import="java.util.Locale"%>
<%@page import="portalrefimpl.schedule.createappointment.request.PractitionerTimeSlotRequest"%>
<%@page import="portalrefimpl.schedule.createappointment.CreateAppointmentConstants"%>
<%@page import="portalrefimpl.schedule.ScheduleHelper"%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page import="java.util.Date"%>
<%@page import="portalrefimpl.schedule.apptrequestdetails.response.DetailsResponse"%>
<%@page import="portalrefimpl.schedule.apptrequestdetails.svc.DetailsServiceInvoker"%>
<%@page import="portalrefimpl.schedule.apptrequestdetails.request.DetailsRequest"%>
<%@page import="portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Patient Portal - Reschedule Appointment Request</title>

<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../../css/style.css" type="text/css" />
<link rel="stylesheet" href="../../css/style_ie.css" type="text/css" />
<link href="../../css/examples-offline.css" rel="stylesheet">
<link href="../../css/kendo.common.min.css" rel="stylesheet">
<link href="../../css/kendo.default.min.css" rel="stylesheet">

<script src="../../js/jquery.min.js"></script>
<script src="../../js/kendo.web.min.js"></script>
<script src="../../js/console.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
 $(document).ready(function() {
         var today = new Date();
      // create DatePicker from input HTML element
         $("#preferredDateFromPage").kendoDatePicker({
        	    format: "dd/MM/yyyy"
         });
      	
         var preferredDate;
         var monthDates = [];
         
         // this is where the code to get the practitioner schedule
         // should be called
         var xmlHttp = getHttpObject();
     	xmlHttp.onreadystatechange=function(){
     		if(xmlHttp.readyState==4 && xmlHttp.status==200){
     			var responseText = xmlHttp.responseText;
     			var dataObj = ((JSON && JSON.parse(responseText)));
     			var objLength = dataObj.length;
     			var errorMessage;
     			var scheduleDate;
     			var scheduleStatus;
     			
     			for(count=0;count<objLength;count++){
     				errorMessage = dataObj[count].errorMessage;
     				errorMessage = trimText(errorMessage);
     				scheduleDate = dataObj[count].scheduleDate;
     				scheduleDate = trimText(scheduleDate);
     				scheduleStatus = dataObj[count].scheduleStatus;
     				scheduleStatus = trimText(scheduleStatus);
     				
     				//alert(errorMessage+"||"+scheduleDate+"||"+scheduleStatus);
     				// this is the error scenario
     				// show the error message in the GUI
     				if(errorMessage.length > 0){
     					var errorMessageSpanComp = document.getElementById("errorMessageSpan");
     					var errorMessageDivComp = document.getElementById("errorMessageDiv");
     					if(errorMessageSpanComp && errorMessageDivComp){
     						errorMessageSpanComp.innerHTML = errorMessage;
     						errorMessageDivComp.style.display = "block";
     					}else{
     						// just a safe handling - somehow user should
     						// get to know that an error has occurred
     						alert("errorMessage="+errorMessage);
     					}
     					continue;
     				}
     				
     				// this is for initializing the preferred date which is nothing
     				// but the date starting from which user would view the schedule
     				// for example if user has selected preferred date as 28/03/2013
     				// then user would view the schedule starting from 28/03/2013
     				// and ending at one month from the starting date
     				if(count == 0){
     					// the date value will be in the format "dd/MM/yyyy"
     					// hence there is no need to have safe checks
     					var dateIndex = scheduleDate.indexOf("/");
     					var dateStr = scheduleDate.substring(0,dateIndex);
     					var dateVal = getIntValue(dateStr,0);
     					
     					var monthIndex = scheduleDate.indexOf("/",dateIndex+1);
     					var monthStr = scheduleDate.substring(dateIndex+1,monthIndex);
     					var monthVal = getIntValue(monthStr,0);
     					
     					var yearStr = scheduleDate.substring(monthIndex+1,scheduleDate.length);
     					var yearVal = getIntValue(yearStr,0);
     					// initialize the preferred date
     					preferredDate = new Date(yearVal,monthVal-1,dateVal);
     				}
     				monthDates[+new Date(preferredDate.getFullYear(),preferredDate.getMonth(),(preferredDate.getDate()+count))] = scheduleStatus;
     				
     			}
     			
     			//check if the obj length is more than 1 - this indicates
     			// that schedule informationn is present
     			if(objLength > 1){
     				$("#PreferredDateInTimeSlot").kendoCalendar({
        	             value: preferredDate,
        	             dates: monthDates,
        	             month:{
        	               content:'# if (typeof data.dates[+data.date] === "string") { #' +
        	                       '<div style="max-height:30px;">' +
        	                       '#= data.value #' +
        	                       //'<br>'+
        	                       '<span class="#= data.dates[+data.date] #">' +
        	                       '</span>' +
        	                       '</div>' +
        	                       '# } else { #' +
        	                       '#= data.value #' +
        	                       '# } #'
        	             },
        	             footer: " #=kendo.toString(data, 'd') #",
        	             format: "dd/MM/yyyy" 
        	         });
     			}else{
     				// schedule status is not available for the 
     				// selected practitioner and the selected date
     				// but still the calendar should be shown
     				var hdnPreferredDateElem = document.getElementById('hdnPreferredDate');
     				if(hdnPreferredDateElem){
     					preferredDate = hdnPreferredDateElem.value;
     				}
     				$("#PreferredDateInTimeSlot").kendoCalendar({
       	             value: preferredDate,
	       	          footer: " #=kendo.toString(data, 'd') #",
	 	             format: "dd/MM/yyyy" 
	 	         });
     			}
     			
     		}
     	}
     	// call the servlet to get the schedule status
     	xmlHttp.open("POST", "./PractitionerScheduleStatusServlet", true);
     	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
     	// form the 
     	var parameters = getPractitionerScheduleStatusParameters();
     	xmlHttp.send(parameters); 
      
 });
 
 function getPractitionerScheduleStatusParameters(){
	 // this function gets the URL parameters needed for calling the schedule status
	 // servlet
 	var parameters = "";
 	// speciality
 	var hdnSpecialityCode = document.getElementById("hdnSpecialtyId");
 	var specialityCode="";
 	if(hdnSpecialityCode){
 		specialityCode = hdnSpecialityCode.value;
 	}
 	parameters +="hdnSelectedSpeciality="+specialityCode;
 	parameters +="&";
 	
 	// facility
 	var hdnFacility = document.getElementById("hdnFacilityId");
 	var facility="";
 	if(hdnFacility){
 		facility = hdnFacility.value;
 	}
 	parameters +="Facility="+facility;
 	parameters +="&";
 	
 	// preferred date
 	//var preferredDateComp = document.getElementById("hdnPreferredDate");
 	var preferredDateComp = document.getElementById("hdnPreferredDateInTimeSlotFrame");//timeslotSelectedDate");
 	var preferredDate="";
 	if(preferredDateComp){
 		preferredDate = preferredDateComp.value;
 	}
 	parameters +="hdnPreferredDate="+preferredDate;
 	parameters +="&";
 	
 	// preferred from time
 	var preferredFromTimeComp = document.getElementById("timeslotSelectedFromTime");
 	var preferredFromTime="";
 	if(preferredFromTimeComp){
 		preferredFromTime = preferredFromTimeComp.value;
 	}
 	parameters +="ApptPreferredFromTime="+preferredFromTime;
 	parameters +="&";
 	
 	// preferred to time
 	var preferredToTimeComp = document.getElementById("timeslotSelectedToTime");
 	var preferredToTime="";
 	if(preferredToTimeComp){
 		preferredToTime = preferredToTimeComp.value;
 	}
 	parameters +="ApptPreferredToTime="+preferredToTime;
 	parameters +="&";
 	
 	// practitioner id
 	var practitionerIdComp = document.getElementById("selectedPractitionerIdInPage");
 	var practitionerId="";
 	if(practitionerIdComp){
 		practitionerId = practitionerIdComp.value;
 	}
 	parameters +="hdnPractitionerId="+practitionerId;
 	parameters +="&";
 	
 	// clinic code
 	var clinicCodeComp = document.getElementById("hdnClinicCode");
 	var clinicCode = "";
 	if(clinicCodeComp){
 		clinicCode = clinicCodeComp.value;
 	}
 	parameters += "hdnClinicCode="+clinicCode;
 	
 	return parameters;
 }
 
 function getPractitionerList(){
   // this function is invoked when user clicks on search button
   // in the left hand side page
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
		   //alert('date picker value='+preferredApptDate);
	   }else{
		   var dateValue = datePickerComp.value;
		   preferredApptDate = getDateObject(dateValue);
		   //preferredApptDate = new Date(dateValue);
		   //alert('date comp value='+dateValue+' '+(typeof dateValue)+' '+preferredApptDate);
		   //alert(Date.parse(dateValue));
	   }
   }
     
    if(isNaN(preferredApptDate)){
 	   validationMessage = "Preferred date is not valid. \n";
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
	}
		
	var dotIndex = selectedFromTime.indexOf(".");
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
		validationMessage += "Speciality is invalid. \n";
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
		
	// finally show the validation message
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
	var formElement = document.getElementById("rescheduleTimeslotForm");
	 if(formElement){
		 formElement.action = "./ApptRequestDetailsServlet";
		 formElement.submit();
	 }
  }
 
 function checkTimeSlot(){
 	// this function is invoked when check time slot button
 	// is clicked by the user
 	// this function merely submits the form in this page
 	var preferredDateInTimeSlot = document.getElementById("PreferredDateInTimeSlot");
 	var hdnPreferredDateInTimeSlot = document.getElementById("hdnPreferredDateInTimeSlotFrame");
 	var preferredDateCalendar = $("#PreferredDateInTimeSlot").data("kendoCalendar");
 	if(preferredDateInTimeSlot && hdnPreferredDateInTimeSlot){
 		var preferredDate;
 		var preferredDateObj;
 		if(preferredDateCalendar){
 			preferredDate = preferredDateCalendar.value();
 			//alert(preferredDate);
 			preferredDateObj = new Date(preferredDate);
 			if(preferredDateObj){
 				preferredDate = ""+preferredDateObj.getDate()+"/"+(preferredDateObj.getMonth()+1)+"/"+preferredDateObj.getFullYear();
 			}
 		}else{
 			preferredDate = preferredDateInTimeSlot.value;
 			alert('Cannot proceed to get timeslot for selected date '+hdnPreferredDateInTimeSlot.value+'. System error');
 			return false;
 		}
 		//alert(preferredDate);
 		hdnPreferredDateInTimeSlot.value = preferredDate;
 	}
 	
 	var formElement = document.getElementById("rescheduleTimeslotForm");
 	if(formElement){
 		formElement.action = "./ScheduleStatusAndTimeslotServlet";
 		formElement.submit();
 	}
 }
 
 function selectTimeSlot(timeSlotElement,divId){
	   // this function sets the selected time slot element's style
	   // also sets the selected time slot value to a hidden variable
	   // also modifies the text of the selected time slot label shown in GUI
	   // this function is modified to pass the divid of the selected time slot
	   var previousSelectedDivId;
	   var hdnSelectedTimeSlotDivElement = document.getElementById("hdnSelectedTimeSlotDivId");
	   if(hdnSelectedTimeSlotDivElement){
		   previousSelectedDivId = hdnSelectedTimeSlotDivElement.value;
		   var previousSelectedDiv = document.getElementById(previousSelectedDivId);
		   if(previousSelectedDiv){
			   var styleClassName = previousSelectedDiv.className;
			   if('timeselectionnormal evenrow' == styleClassName){
				   previousSelectedDiv.style.background =  "#F2F2F2";
			   }else if('timeselectionnormal oddrow' == styleClassName){
				   previousSelectedDiv.style.background =  "#EBEBEB";
			   }else if('timeselectionpreferred' == styleClassName){
				   previousSelectedDiv.style.background =  "#FCFAC8";
			   }
		   }
		   // finally set the currently selected time slot's div id
		   // as the value of the hidden element
		   hdnSelectedTimeSlotDivElement.value = divId;
	   }
	   timeSlotElement.style.background = "#73A30A";
	   // sets the selected time slot value to a hidden variable
	   var selectedTimeSlot = timeSlotElement.innerHTML;
	   selectedTimeSlot = trimText(selectedTimeSlot);
	   // now set the background color of the currently selected time slot
	   var hdnSelectedTimeSlotElement = document.getElementById('hdnSelectedTimeSlot');
	   if(hdnSelectedTimeSlotElement){
		   hdnSelectedTimeSlotElement.value = selectedTimeSlot;
	   }
	   //modifies the text of the selected time slot label shown in GUI
	   var selectedSpan = document.getElementById('selectedtimespan');
	   if(selectedSpan){
		   selectedSpan.innerHTML = selectedTimeSlot;
	   }
 }
 
 function confirmRescheduleRequest(){
   // this function shows the confirmation dialog
   // to the user before proceeding to reschedule an appointment request
   
   // validate if time slot and reason for reschedule is selected
   // first validate if any time slot is selected
	// preferred time slot
   var validationMessage = "";
   var selectedTimeSlotComp = document.getElementById("hdnSelectedTimeSlot");
   var selectedTimeSlot = "";
   if(selectedTimeSlotComp){
	   selectedTimeSlot = selectedTimeSlotComp.value;
	   if(selectedTimeSlot.length == 0){
		   validationMessage += 'Time slot is not selected for the appointment request. \n';
		   //alert('Time slot is not selected for the appointment request');
		   //return false;
	   }
   }
   
   var reasonCodeCombo = document.getElementById("rescheduleReasonCode");
   var reasonCode='';
   if(reasonCodeCombo){
	   reasonCode = reasonCodeCombo.value;
   }
   
   if(reasonCode.length == 0){
	   validationMessage += "Reason for reschedule is not selected.\n";
   }
   
   if(validationMessage.length > 0){
	   alert(validationMessage);
	   return false;
   }
   
  // need to get the practitioner name, selected specialty
   // appointment date and time
   var practNameComp = document.getElementById("selectedPractitionerNameInPage");
   var practName = "";
   if(practNameComp){
	   practName = practNameComp.value;
	   practName = escape(practName);
   }
   
   var selectedSpecialtyComp = document.getElementById("hdnSpecialtyDesc");
   var selectedSpecailty = "";
   if(selectedSpecialtyComp){
	   selectedSpecialty = selectedSpecialtyComp.value;
	   selectedSpecialty = escape(selectedSpecialty);
   }
   
   // preferred date
   var datePickerComp = document.getElementById("PreferredDateInTimeSlot");
   var dateTimePicker = $("#PreferredDateInTimeSlot").data("kendoCalendar");
   var preferredApptDate;
   if(datePickerComp){
	   if(dateTimePicker){
		   preferredApptDate = dateTimePicker.value();
	   }else{
		   preferredApptDate = new Date(datePickerComp.value);
	   }
   }
   //var preferredApptDate = dateTimePicker.value();
   var dateValue = ""+preferredApptDate.getDate()+"/"+(preferredApptDate.getMonth()+1)+"/"+preferredApptDate.getFullYear();
   // escape sequence for the selected time slot
   selectedTimeSlot = escape(selectedTimeSlot);
   
   var confirmPopupURL = "./ConfirmBookRequest.jsp?practitionerName="+practName;
   confirmPopupURL += "&specialty="+selectedSpecialty;
   confirmPopupURL += "&preferredDate="+dateValue;
   confirmPopupURL += "&selectedTimeSlot="+selectedTimeSlot;
   
   // load the div with URL
    $('#requestConfirmDiv').load(confirmPopupURL);
    
	if (document.getElementById('requestConfirmContainerDiv').style.visibility == 'hidden') {
       document.getElementById('requestConfirmContainerDiv').style.visibility = '';
       $("#requestConfirmContainerDiv").hide();
    }
    if (document.getElementById('requestConfirmDiv').style.visibility == 'hidden') {
       document.getElementById('requestConfirmDiv').style.visibility = '';
       $("#requestConfirmDiv").hide();
    }
	
	$("#requestConfirmContainerDiv").fadeIn(200, "linear", function () { $("#requestConfirmDiv").show(300, "swing"); });
	   
 }
 
 function closeConfirmRescheduleApptReqPopup(){
   // this function will close the confirm popup dialog
   // also submits this page
   // submit is done as a work around for an issue
	$("#requestConfirmDiv").hide('300', "swing", function () { $("#requestConfirmContainerDiv").fadeOut("200"); });
   
	var formElement = document.getElementById("rescheduleTimeslotForm");
   	if(formElement){
   		formElement.action = "./ScheduleStatusAndTimeslotServlet";
   		formElement.submit();
   	}
 }
 
 function rescheduleApptRequest(){
	 // this function will reschedule the appointment request based
	 // on the configuration done already in the page
	 // first hide the confirmation dialog
     $("#requestConfirmDiv").hide('200', "swing", function () { $("#requestConfirmContainerDiv").fadeOut("100"); });
	 
	// This function will book the appointment for the user
	var serializeStr = $("#rescheduleTimeslotForm").serialize();
	var bookAppointmentURL = "./RescheduleApptReqServlet?"+serializeStr;
    $('#rescheduleApptContentDiv').load(bookAppointmentURL);
	   
   if (document.getElementById('rescheduleApptRequestContainerDiv').style.visibility == 'hidden') {
       document.getElementById('rescheduleApptRequestContainerDiv').style.visibility = '';
       $("#rescheduleApptRequestContainerDiv").hide();
    }
    if (document.getElementById('rescheduleApptContentDiv').style.visibility == 'hidden') {
       document.getElementById('rescheduleApptContentDiv').style.visibility = '';
       $("#rescheduleApptContentDiv").hide();
    }
		
	$("#rescheduleApptRequestContainerDiv").fadeIn(200, "linear", function () { $("#rescheduleApptContentDiv").show(300, "swing"); });
	 
 }
 
 function postRescheduleApptRequest(errorCodeStr){
	// this function will hide the popup which is shown after the
   // reschedule appointment operation is performed
   // this function will also forward the request to a suitable page
   
   // first hide the popup
   $("#rescheduleApptContentDiv").hide('200', "swing", function () { $("#rescheduleApptRequestContainerDiv").fadeOut("100"); });
   var actionURL = '';
   
   // this is for successful reschedule appt request
   if(errorCodeStr == '2'){
	  actionURL = "./UpcomingAppointments.jsp" ;
   }else if(errorCodeStr == '1'){
	   actionURL = './ApptRequestDetailsServlet';
	   var refNumberComp = document.getElementById("referenceNumber");
	   var refNumber='';
	   if(refNumberComp){
		   refNumber = refNumberComp.value;
		   actionURL += "?referenceNumber="+refNumber;
	   }
   }
   
   var formElement = document.getElementById("rescheduleTimeslotForm");
   if(formElement){
	   formElement.action = actionURL;
	   formElement.submit();
   }
 }
 
 function performOperation(){
	// this function performs the main operation in this page
	rescheduleApptRequest();
 }
 
 function cancelOperation(){
	// this function cancels the main operation in this page
	closeConfirmRescheduleApptReqPopup();
 }
 
 function postOperation(errorCodeStr){
	// this function performs some more actions post
	// the main operation
	postRescheduleApptRequest(errorCodeStr);
 }
 
 function getHttpObject(){
	 // this function gets the XMLHttpRequest object for use in Ajax calls
	var xmlHttp;
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlHttp;
}
 
 function trimText(textVal){
	 // this function trims a given text
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
 
 function getIntValue(stringValue,defaultValue){
 	// this function converts the string value to an integer value
 	var intVal = defaultValue;
 	try{
 		intVal = parseInt(stringValue);	
 	}catch(e){
 		intVal = defaultValue;
 	}
 	return intVal;
 }
 
 
 </script>
<style scoped>
    #special-days {
        height: 202px;
        width: 300px;
        margin: 2px auto;
        /*padding: 2px 0 2px 2px;*/
    }

    #PreferredDateInTimeSlot {
        border-radius: 1px 1px 1px 1px;
        border-style: solid;
        border-width: 1px;
    }

    .k-header {
        border-radius: 3px 3px 0 0;
    }

    #PreferredDateInTimeSlot .k-content {
        height: 152px;
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
    
    .FREE {
    	background-color : #38A1E9;
    	display: inline-block;
        width: 100%;
        height: 8px;
        vertical-align: middle;
        
    }
    
     .LEAVE {
    	background-color : #E8AF1A;
    	display: inline-block;
        width: 100%;
        height: 8px;
        vertical-align: middle;
        
    }
    
    .BLOCKED {
    	background-color : #DE3A29;
    	display: inline-block;
        width: 100%;
        height: 8px;
        vertical-align: middle;
    }
    
    .timeslottd{
    	height:100%;
    	margin-left: 2px;
    	width:50%;
    	min-width:50%;
    	border-right:1px solid #AFAFAF;
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
    
    .rescheduleApptContainerStyle {
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
	}
	
	.rescheduleApptpopupContentStyle{
	  background-color: white;
      color: black;
      /* border: 1px solid gray; */
      padding: 2px;
      display:block;
      position: absolute;
      top: 30%;
      left: 30%;
      width: 582px;
      height: 242px;
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

		// selected practitioner from the GUI - it is passed on by RescheduleMain.jsp
		// to this page
		String selectedPractitionerId = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM);
		String selectedPractitionerName = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM);
		String selectedClinicCode = request.getParameter(RescheduleRequestConstants.HIDDEN_CLINIC_CODE_PARAM);
		//String practitionerFromPage = request.getParameter(RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM);
		
		// the selected date and times from the time slot panel in the page
		String timeslotSelectedDate = request.getParameter(RescheduleRequestConstants.HIDDEN_PREFERRED_DATE_TIMESLOT_PARAM);

		String timeslotSelectedFromTime = request.getParameter(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM);
		String timeslotSelectedToTime = request.getParameter(RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM);
		

		// get the appointment request details by executing the service
		DetailsRequest detailsRequest = new DetailsRequest();
		detailsRequest.setPatientId(patientId);
		detailsRequest.setApptRequestReferenceNumber(appointmentReqRefNumber);
		detailsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

		DetailsServiceInvoker serviceInvoker = new DetailsServiceInvoker();
		serviceInvoker.registerService(detailsRequest);
		DetailsResponse detailsResponse = (DetailsResponse)serviceInvoker.getDataThroughService(detailsRequest);
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
		// stores the practitioner name
		String practitionerName = "";
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
			practitionerName = detailsResponse.getResourceName();
			
			
		}
		
		// if the preferred date obtained from the page is null - then set it
		// to the preferred date obtained from the appointment request details service
		if(preferredDateFromPage == null || preferredDateFromPage.trim().equals("")){
			preferredDateFromPage = preferredDateStr;
		}

		//there is also a need to set the selected from time obtained from the page
		// with a value if user has not selected it
		if(preferredFromTimePage == null || preferredFromTimePage.trim().equals("")){
			preferredFromTimePage = preferredFromTimeDisplayStr;
		}

		// there is also a need to set the selected to time obtained from the page
		// with a value if user has not selected it
		if(preferredToTimePage == null || preferredToTimePage.trim().equals("")){
			preferredToTimePage = preferredToTimeDisplayStr;
		}
		
		// finally initialize the time slot date and times if it is not having value
		if(timeslotSelectedDate == null || timeslotSelectedDate.trim().equals("")){
			timeslotSelectedDate = preferredDateFromPage;	
		}
		
		if(timeslotSelectedFromTime == null || timeslotSelectedFromTime.trim().equals("")){
			timeslotSelectedFromTime = preferredFromTimePage;
		}
		
		if(timeslotSelectedToTime == null || timeslotSelectedToTime.trim().equals("")){
			timeslotSelectedToTime = preferredToTimePage;
		}
		
		
	%>

	<div id="wrapper"  style="background-color: #ffffff;">
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
							<li><a href="../Contact.jsp"><div class="menuicons">
										<img src="../../images/Contact.png" />
									</div>Contact</a></li>
							<li><a href="../result/DetailedResult.jsp"><div
										class="menuicons">
										<img src="../../images/Results.png" />
									</div>My Results</a></li>
							<li class="menuselect"><div class="menuicons">
									<img src="../../images/Appointment.png" />
								</div>My Appointments</li>
							<li><a href="../PortalHome.jsp"><div class="menuicons">
										<img src="../../images/Home.png" />
									</div>Home</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- #logo And Menu -->

		<div class="line"></div>
		<div id="content" style="height:auto;overflow:auto;">
			<form id="rescheduleTimeslotForm" name="rescheduleTimeslotForm" id="rescheduleTimeslotForm" method="POST">
			<!-- #Patient Banner-->

			<!-- #Patient Banner-->
			<!-- #Content Area-->
			<div id="contentbg"></div>
			<div id="contentArea">

				<div id="contentArearow">
					<div id="booknewbreadcrumb">
						<span class="contenbold">
							<a href="./UpcomingAppointments.jsp" class="backpage">My Appointments</a>
						</span> 
						<span class="contenbold" id="arrow">></span> 
						<span class="contenbold">Reschedule	Appointment Request</span>
					</div>
					<div class="row">
						<div class="cellindex searchindex">
							<div id="BooknewAppsearch">

								<div class="BookAppTitle">
									<a class="rectitle"> Modify Search </a>
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
										<input id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM%>" 
											name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM%>" value="<%=preferredDateFromPage%>" style="width:180px;" />
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
										<span>to</span> 
										<select class="Combotimesearch"  id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM%>"
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
						<div class="tablebooknewapp">
							<div class="row">
								<div class="celldivider"></div>
								<div class="cellindex bookingcell">
									<div id="BooknewAppDoctor" style="overflow: auto;">
										<div class="SelectionView" style="background-image:url('../../images/Book.PNG');height:510px;width:1000px;">

											<div id="SelectLeftPanel" style="height:500px;width:47.4%;">

												<div class="currentDetailsRS" style="width:380px;">
													<div class="title">
														<div class="contenbold">Current Appointment details</div>
														<span>Appointment No:</span><span> <%=appointmentReqRefNumber %></span>
														<div>
															<span>Date & time: </span> <span><%=preferredDateDisplayStr %>, </span> 
															<span><%=preferredFromTimeDisplayStr %>	- <%=preferredToTimeDisplayStr %></span>
														</div>
													</div>
												</div>

												<div class="DoctorAppRescheduletime"  style="width:380px;">
													<div class="DoctorDetailStripTimeReschedule" style="width:372px;">
														<div class="DoctorInnerstrip">
															<div class="SearchImage">
																<img class="SearchdoctorIcon" src="../../images/doctor.png" />
															</div>
															<div class="DocDetailsTime" style="width:270px;">
																<span class="contenbold"><%=selectedPractitionerName %></span><br />
																<span class="contentnormal"><%=specialty %></span><br /> <span
																	class="contentnormal"><%=facilityDesc %></span>
															</div>

														</div>
													</div>
												</div>
												<!--  this div is only for containing an error message
												      if the practitioner schedule status cannot be obtained
												 -->
												<div id="errorMessageDiv" name="errorMessageDiv" style="display:none;margin-left:auto;margin-right:auto;min-height: 30px;width:380px;border: 1px solid #CDCDCD;">
													<span id="errorMessageSpan" name="errorMessageSpan" class="loginerror" style="padding-left: 10px;"></span>
												</div>
	
												<div class="bookcontent">
													<div class="ApptimeReschedule">
														<div class="calender">
															<!-- <img src="../../images/calendar2013.PNG" /> -->
															<div id="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_TIMESLOT_PARAMETER_KEY%>"
			               										name="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_TIMESLOT_PARAMETER_KEY%>" 
			               										style="width: 262px;">
			               									</div>
															
														</div>
														<div class="availability">
															<div id="available"></div>
															Available
														</div>
														<div class="availability">
															<div id="full"></div>
															Full
														</div>
														<div class="availability">
															<div id="leave"></div>
															Leave
														</div>


														<div class="ApptitleReschedule contenbold">Preferred
															time</div>
														<select class="textboxtimeindex" id="<%=RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM%>" 
															name="<%=RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM%>" >
															<option value="">Select time</option>
															<%
																if (apptStartTimeList == null || apptStartTimeList.isEmpty()) {
																	apptFromTimeResponse = ScheduleHelper
																			.getAppointmentTimeResponse(apptFromTimeRequest);
																	apptStartTimeList = apptFromTimeResponse
																			.getAppointmentTimeList();
																}
																selected = "";
																// this var is reset and will be used to
																// store the appointment display value
																apptTimeValue = null;
																// this is for storing the appointment data value
																// appointment data value is being used only
																// for calculating the time slot information
																apptDataValue = null;
																// iterate through the list and show the time
																for (AppointmentTime apptTime : apptStartTimeList) {
																	selected = "";
																	apptTimeValue = apptTime.getAppointmentTime();
																	apptDataValue = apptTime.getAppointmentDataValue();
																	
																	if (timeslotSelectedFromTime.equalsIgnoreCase(apptDataValue)) {
																		selected = "selected";
																	}
																	
																	%>
																	<option value="<%=apptDataValue%>" <%=selected%>><%=apptTimeValue%></option>
																<%
																	}
																%>
														</select> 
														<span>to</span> 
														<select class="textboxtimeindex" id="<%=RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM%>" 
															name="<%=RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM%>" >
															<option value="">Select time</option>
															<%
															if (apptToTimeList == null || apptToTimeList.isEmpty()) {
																apptToTimeResponse = ScheduleHelper
																		.getAppointmentTimeResponse(apptFromTimeRequest);
																apptToTimeList = apptToTimeResponse.getAppointmentTimeList();
															}
															selected = "";
															// reset the vars used to store the appointment times
															apptTimeValue = null;
															apptDataValue = null;
															// iterate through the list and show the time
															for (AppointmentTime apptTime : apptToTimeList) {
																selected = "";
																apptTimeValue = apptTime.getAppointmentTime();
																apptDataValue = apptTime.getAppointmentDataValue();
																/* if (timeslotToTime.equalsIgnoreCase(apptTimeValue)) {
																	selected = "selected";
																} */
																if (timeslotSelectedToTime.equalsIgnoreCase(apptDataValue)) {
																	selected = "selected";
																}
															%>
															
															<option value="<%=apptDataValue%>" <%=selected%>><%=apptTimeValue%></option>
														<%
															}
														%>
														</select>
														<div id="SelectedDate">Selected date: 
														<%
															String selectedDateDisplayStr = ScheduleHelper
																	.getPreferredDateInDisplayFormat(
																			timeslotSelectedDate,
																			CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT,
																			CreateAppointmentConstants.PRACTITIONERTIMESLOT_DATE_DISPLAY_FORMAT);
															out.println(selectedDateDisplayStr);
														%>
														</div>

													</div>

												</div>


												<div class="centeralign ReschedulebtnBottom">
													<span><a href="#" class="PPbtn" onclick="checkTimeSlot()">Check time slot</a></span>
												</div>

											</div>



											<div id="SelectRightPanel" style="height:500px;">
												<%
													// code to get the time slot information
													// initialize the request first
													PractitionerTimeSlotRequest timeSlotRequest = new PractitionerTimeSlotRequest();
													timeSlotRequest.setFacilityId(facilityId);
													timeSlotRequest.setPractitionerId(selectedPractitionerId);
													timeSlotRequest.setClinicCode(selectedClinicCode);
													timeSlotRequest.setClinicType(CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_DEFAULT_CLINICTYPE);
													timeSlotRequest.setResourceType(CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);
													timeSlotRequest.setLocale(Locale.getDefault().getLanguage());
													timeSlotRequest.setPreferredDate(timeslotSelectedDate);
													timeSlotRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
													
													// call the time slot web service through its service invoker
													PractitionerTimeSlotServiceInvoker timeSlotServiceInvoker = new PractitionerTimeSlotServiceInvoker();
													timeSlotServiceInvoker.registerService(timeSlotRequest);
													PractitionerTimeSlotResponse timeSlotResponse = (PractitionerTimeSlotResponse)timeSlotServiceInvoker.getDataThroughWebService(timeSlotRequest);
													
													errorMessage = null;
													if(!timeSlotResponse.isSuccessful()){	
														errorMessage = timeSlotResponse.getErrorMessage();
												%>	
												<div id="timesloterrordiv" name="timesloterrordiv" style="margin-left:auto;margin-right:auto;min-height: 25px;width:445px;border: 1px solid #CDCDCD;padding-top: 5px;">
													<span class="loginerror" style="padding-left: 10px;">
														<%=errorMessage %>
													</span>
												</div>
												<div style="width:99%;margin:10px;min-height: 300px;">
													<table width="98%" cellpadding="0" cellspacing="0" style="border:1px solid #cdcdcd;min-height: 290px;">
														<th style="height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;border-right:1px solid #AFAFAF;">AM</th>
														<th style="height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;">PM</th>
														<tr style="border-right:1px solid #AFAFAF;">
															<td style="border-right:1px solid #AFAFAF;">
															</td>
															<td>
															</td>
														</tr>
													</table>
												</div>
												<div id="preferredtime"><div id="prefer"></div>Preferred time</div>
												<div id="Selected">Selected date and time: <%=selectedDateDisplayStr%>, <span id="selectedtimespan"><%=timeslotSelectedFromTime %> - <%=timeslotSelectedToTime %></span></div>
												<div class="centeralign ReschedulebtnBottom">
													<span><a class="disabled" style="float:center;">Reschedule appointment</a></span>
												</div>
												<%
													}else{
														List<List<TimeSlot>> morningAndEveningTimeSlots = timeSlotResponse.getMorningAndEveningTimeSlots();
														// no need to check for null - it will be only empty at worst
														if(morningAndEveningTimeSlots.isEmpty()){
												%>
												<div id="timesloterrordiv" name="timesloterrordiv" style="margin-left:auto;margin-right:auto;min-height: 25px;width:445px;border: 1px solid #CDCDCD;padding-top: 5px;">
													<span class="loginerror">Could not get time slot information.
													</span>
												</div>	
												<div style="width:99%;margin:10px;min-height: 300px;">
													<table width="98%" cellpadding="0" cellspacing="0" style="border:1px solid #cdcdcd;min-height: 290px;">
														<th style="height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;border-right:1px solid #AFAFAF;">AM</th>
														<th style="height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;">PM</th>
														<tr style="border-right:1px solid #AFAFAF;">
															<td style="border-right:1px solid #AFAFAF;">
															</td>
															<td>
															</td>
														</tr>
													</table>
												</div>
												<div id="preferredtime"><div id="prefer"></div>Preferred time</div>
												<div id="Selected">Selected date and time: <%=selectedDateDisplayStr%>, <span id="selectedtimespan"><%=timeslotSelectedFromTime %> - <%=timeslotSelectedToTime %></span></div>
												<div class="centeralign ReschedulebtnBottom">
													<span><a class="disabled" style="float:center;">Reschedule appointment</a></span>
												</div>
												
												<%		
													// successfully got the time slot information
													// so show it
														}else{
															// morning time slots are placed at 0th index
															List<TimeSlot> morningTimeSlots = morningAndEveningTimeSlots.get(0);
															List<TimeSlot> eveningTimeSlots = morningAndEveningTimeSlots.get(1);
															
															String updatedPreferredFromTime = ScheduleHelper.
																	getApptSelectedTimeInDisplayFormat(timeslotSelectedFromTime);
															String updatedPreferredToTime = ScheduleHelper.
																	getApptSelectedTimeInDisplayFormat(timeslotSelectedToTime);
															
															// local vars for use in display
															final int COMP_IN_COLUMN = 7;
															final int NUMBER_OF_COLUMN = 3;
															int columnCounter = 0;
															int compCounter = 0;
															TimeSlot timeSlot = null;
															final String TIMESLOT_ODDCOLUMN_STYLE = "timeselectionnormal oddrow";
															final String TIMESLOT_EVENCOLUMN_STYLE = "timeselectionnormal evenrow";
															final String TIMESLOT_PREFERRED_STYLE = "timeselectionpreferred";
															// this is for the div id
															final String TIMESLOT_DIV_ID = "timeslotDiv";
															String timeSlotDivId = null;
															int divCounter = 0;
															String timeSlotStyle = null;
															boolean timeSlotInPreferredTime = false;
												%>
												<div style="width:99%;margin:10px;">
													<table width="98%" cellpadding="0" cellspacing="0" style="border:1px solid #cdcdcd;">
														<th style="height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;border-right:1px solid #AFAFAF;">AM</th>
														<th style="height:25px;background-color: #E9E9E9;border-bottom:1px solid #ffffff;">PM</th>
														<tr style="border-right:1px solid #AFAFAF;">
															<td class="timeslottd" valign="top">
															<!--  for morning records -->
															<%
																if(!morningTimeSlots.isEmpty()){
															%>
																<table cellpadding="0" cellspacing="0">
																  <tr>
															<%			
																	int morningTimeSlotCount = morningTimeSlots.size();
																	 
																	while(columnCounter < NUMBER_OF_COLUMN){
																		
															%>
																	<td height="100%" valign="top">
																	<table height="100%"  cellpadding="0" cellspacing="0">
																<%
																		for(int count=0;count<COMP_IN_COLUMN;count++){
																			timeSlotStyle = TIMESLOT_ODDCOLUMN_STYLE;
																			if((columnCounter % 2) == 0){
																				timeSlotStyle = TIMESLOT_EVENCOLUMN_STYLE;	
																			}
																			if(compCounter == morningTimeSlotCount){
																				break;		
																			}
																			// this is for setting the div id
																			divCounter ++;
																			timeSlotDivId = TIMESLOT_DIV_ID + divCounter;
																			timeSlot = morningTimeSlots.get(compCounter);
																			timeSlotInPreferredTime = timeSlot.
																				isTimeSlotInPreferredTimeRange(updatedPreferredFromTime, updatedPreferredToTime);
																			if(timeSlotInPreferredTime){
																				timeSlotStyle = TIMESLOT_PREFERRED_STYLE;
																			}
																%>
																		<tr>
																			<td>
																				<div id="<%=timeSlotDivId %>" class="<%=timeSlotStyle%>" onclick="selectTimeSlot(this,'<%=timeSlotDivId %>')"><%out.print(timeSlot.getStartTime()+" - "+timeSlot.getEndTime());compCounter++;%></div>
																			</td>
																		</tr>	
																<%					
																		}
																		
																		// need to check this once more 
																		if(compCounter == morningTimeSlotCount){
																	%>
																		</table>
																		</td>
																	<%	
																			break;
																		}
																		//compCounter++;
																		columnCounter++;
																	%>
																		</table>
																		</td>
																	<%	
																	}
																	%>
																	</tr>
																</table>	
																<%	
																}
															%>
															</td>
															
															<td height="100%" style="margin-left: 2px;"  valign="top"  width="50%" style="min-width:50%;border-right:1px solid #AFAFAF;">
															<!--  for evening records -->
															<%
																columnCounter = 0;
																compCounter = 0;
																timeSlotStyle = null;
																if(!eveningTimeSlots.isEmpty()){
															%>
																<table cellpadding="0" cellspacing="0">
																	<tr>
															<%		
																	int eveningTimeSlotCount = eveningTimeSlots.size();
																	while(columnCounter < NUMBER_OF_COLUMN){
															%>
																	<td height="100%" valign="top">
																	<table cellpadding="0" cellspacing="0">
																<%
																		for(int count=0;count<COMP_IN_COLUMN;count++){
																			timeSlotStyle = TIMESLOT_ODDCOLUMN_STYLE;
																			if((columnCounter % 2) == 0){
																				timeSlotStyle = TIMESLOT_EVENCOLUMN_STYLE;	
																			}
																			if(compCounter == eveningTimeSlotCount){
																				break;		
																			}
																			// this is for setting the div id
																			divCounter ++;
																			timeSlotDivId = TIMESLOT_DIV_ID + divCounter;
																			timeSlot = eveningTimeSlots.get(compCounter);
																			timeSlotInPreferredTime = timeSlot.
																				isTimeSlotInPreferredTimeRange(updatedPreferredFromTime, updatedPreferredToTime);
																			if(timeSlotInPreferredTime){
																				timeSlotStyle = TIMESLOT_PREFERRED_STYLE;
																			}
																%>
																		<tr>
																			<td>
																				<div id="<%=timeSlotDivId %>" class="<%=timeSlotStyle%>" onclick="selectTimeSlot(this,'<%=timeSlotDivId %>')"><%compCounter++;out.print(timeSlot.getStartTime()+" - "+timeSlot.getEndTime());%></div>
																			</td>
																		</tr>	
																<%					
																		}
																		
																		// need to check this once more 
																		if(compCounter == eveningTimeSlotCount){
																	%>
																		</table>
																		</td>
																	<%	
																			break;
																		}
																		//compCounter++;
																		columnCounter++;
																	%>
																		</table>
																		</td>
																	<%		
																	}
																	%>
																	</tr>
																</table>	
																<%	
																}
															%>
															</td>
															
														</tr>														
													</table>
												
												</div>
												
															

												<div id="preferredtime">
													<div id="prefer"></div>
													Preferred time
												</div>
												<div id="Selected">Selected date and time: <%=selectedDateDisplayStr %>,  <span id="selectedtimespan"><%=timeslotSelectedFromTime %> - <%=timeslotSelectedToTime %></span></div>
												<div class="reasondiv">
												<%
												
												// code to get the contact reasons
												ContactReasonRequest contactReasonRequest = new ContactReasonRequest();
												contactReasonRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
												contactReasonRequest.setLocale(Locale.getDefault().getLanguage());
												
												ContactReasonServiceInvoker contactClient = new ContactReasonServiceInvoker();
												contactClient.registerService(contactReasonRequest);
												
												ContactReasonResponse contactReasonResponse = (ContactReasonResponse)
															contactClient.getDataThroughWebService(contactReasonRequest);
												
												%>
													<span>Reason for reschedule</span> 
													<select	class="reasonCombo" id="<%=RescheduleRequestConstants.RESCHEDULE_REASON_CODE_PARAM%>" name="<%=RescheduleRequestConstants.RESCHEDULE_REASON_CODE_PARAM%>">
														<option value="">---Select----</option>
														<%
															List<ContactReasonModel> contactReasonModelList = null;
															if(contactReasonResponse.isSuccessful()){
																contactReasonModelList = contactReasonResponse.getContactReasonList();
																for(ContactReasonModel contactReasonModel : contactReasonModelList){
														%>
														<option value="<%=contactReasonModel.getCode() %>"><%=contactReasonModel.getDescription() %></option>
														<%
																}
															}
														%>
													</select>
												</div>

												<div class="centeralign ReschedulebtnBottom">
													<span><a href="#" class="PPbtn" onclick="confirmRescheduleRequest()">Reschedule appointment</a></span>
												</div>

												<%
														}
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
			</div>
			
			<!--  hidden components to store data  -->
			<!--  preferred date obtained from the var timeslotpreferreddate - stores the date selected in the right panel -->
			<input type="hidden" id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM %>" name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PREFERRED_DATE_PAGE_PARAM %>" value="<%=timeslotSelectedDate%>">
			<!--  preferred date from the left panel -->
			<input type="hidden" id="hdnPreferredDate" name="hdnPreferredDate" id="hdnPreferredDate" value="<%=preferredDateFromPage %>">
			<!--  selected from and to times from the left panel -->
			<input type="hidden" id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_FROM_TIME_PARAM %>" name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_FROM_TIME_PARAM %>" value="<%=preferredFromTimePage %>">
			<input type="hidden" id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM %>" name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_TO_TIME_PARAM %>" value="<%=preferredToTimePage %>">
			
			<!-- selected date from the time slot (right) panel -->
			<!-- selected from and to time from the time slot (right) panel -->
			<input type="hidden" id="<%=RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM %>" name="<%=RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDFROMTIME_PARAM %>" value="<%=timeslotSelectedFromTime %>">
			<input type="hidden" id="<%=RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM %>" name="<%=RescheduleRequestConstants.RESCHEDULE_TIMESLOT_SELECTEDTOTIME_PARAM %>" value="<%=timeslotSelectedToTime %>">
			<input type="hidden" id="<%=RescheduleRequestConstants.HIDDEN_PREFERRED_DATE_TIMESLOT_PARAM %>" name="<%=RescheduleRequestConstants.HIDDEN_PREFERRED_DATE_TIMESLOT_PARAM %>" value="<%=timeslotSelectedDate%>">
			
			
			<!-- facility id and description -->
			<input type="hidden" id="<%=RescheduleRequestConstants.HIDDEN_FACILITY_ID_PARAM %>" name="<%=RescheduleRequestConstants.HIDDEN_FACILITY_ID_PARAM %>" value="<%=facilityId %>">
       		<input type="hidden" id="hdnFacilityDesc" name="hdnFacilityDesc" id="hdnFacilityDesc" value="<%=facilityDesc %>">
       		<!-- specialty id and description -->
       		<input type="hidden" id="<%=RescheduleRequestConstants.HIDDEN_SPECIALTY_ID_PARAM %>" name="<%=RescheduleRequestConstants.HIDDEN_SPECIALTY_ID_PARAM %>" value="<%=specialtyId %>">
       		<input type="hidden" id="<%=RescheduleRequestConstants.HIDDEN_SPECIALTY_DESC_PARAM %>" name="<%=RescheduleRequestConstants.HIDDEN_SPECIALTY_DESC_PARAM %>" value="<%=specialty %>">
			
			<!-- other data like practitioner id, practitioner name and clinic code -->
			<input type="hidden" id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM %>" name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERID_PARAM %>" value="<%=selectedPractitionerId%>">
	       	<input type="hidden" id="<%=RescheduleRequestConstants.HIDDEN_CLINIC_CODE_PARAM%>" name="<%=RescheduleRequestConstants.HIDDEN_CLINIC_CODE_PARAM%>" value="<%=selectedClinicCode%>">
			<input type="hidden" id="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM %>" name="<%=RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM %>" value="<%=selectedPractitionerName%>">
			<input type="hidden" id="<%=RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY %>" name="<%=RescheduleRequestConstants.GET_APPTREQUESTDETAILS_REFNUMBER_PARAM_KEY %>" value="<%=appointmentReqRefNumber %>">
			<input type="hidden" id="hdnSelectedTimeSlotDivId" name="hdnSelectedTimeSlotDivId" id="hdnSelectedTimeSlotDivId" value="">
			<input type="hidden" id="<%=RescheduleRequestConstants.SELECTED_TIMESLOT_PARAM %>" name="<%=RescheduleRequestConstants.SELECTED_TIMESLOT_PARAM %>" value="">
		</form>
	</div>
	<!-- div to show the reschedule confirmation popup -->
	<div id="requestConfirmContainerDiv" class="confirmpopupContainerStyle" style="visibility:hidden;">
		<div id="requestConfirmDiv" class="confirmpopupContentStyle" style="visibility:hidden;">
		</div>
	</div>
				
	<!--  div to perform the reschedule appointment request and then show result popup -->
	<div id="rescheduleApptRequestContainerDiv" class="rescheduleApptContainerStyle" style="visibility:hidden;">
		<div id="rescheduleApptContentDiv" class="rescheduleApptpopupContentStyle" style="visibility:hidden;">
		</div>
	</div>
	
	
	<!-- #content-->
	<div class="clear"></div>
	<div class="Footerbg" style="margin-top: 2px;">
		<div id="poweredby">
			<p class="poweredby">
				Powered by <img src="../../images/csc.png" width="25" height="14">
			</p>
		</div>
	</div>

 </div>

</body>
</html>

