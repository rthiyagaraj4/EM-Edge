<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker"%>
<%@page import="portalrefimpl.schedule.createappointment.response.TimeSlot"%>
<%@page import="java.util.Date"%>
<%@page import="portalrefimpl.schedule.createappointment.response.PractitionerTimeSlotResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerTimeSlotServiceInvoker"%>
<%@page import="java.util.Locale"%>
<%@page import="portalrefimpl.schedule.createappointment.request.PractitionerTimeSlotRequest"%>
<%@page import="portalrefimpl.common.model.Facility"%>
<%@page import="portalrefimpl.facility.facilityforpatient.response.FacilityListResponse"%>
<%@page import="portalrefimpl.facility.facilityforpatient.request.FacilityListRequest"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTime"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.schedule.ScheduleHelper"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeResponse"%>
<%@page import="portalrefimpl.schedule.ScheduleConstants"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeRequest"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.schedule.createappointment.CreateAppointmentConstants"%>
<%@page import="portalrefimpl.schedule.createappointment.response.SpecialityModel"%>
<%@page import="portalrefimpl.schedule.createappointment.response.SpecialityResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.svc.serviceinvoker.SpecialityServiceInvoker"%>
<%@page import="portalrefimpl.schedule.createappointment.request.SpecialityRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


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
    
    .bookapptContainerStyle {
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
	
	.bookapptpopupContentStyle{
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

 <script>
     $(document).ready(function() {
         var today = new Date();
         
         // create DatePicker from input HTML element
         $("#ApptPreferredDate").kendoDatePicker({
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
     			var dataObj = ((JSON && JSON.parse(responseText)) );
     			// || ($.parseJSON(responseText)));
     			var objLength = dataObj.length; 
     			var errorMessage;
     			var scheduleDate;
     			var scheduleStatus;
     			//alert('response text='+responseText+'||| objLength='+objLength);
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
     			
     			// now bind the function for on change
     			//var calendarObj = $("#PreferredDateInTimeSlot").data("kendoCalendar");
     			//calendarObj.bind("change",onCalendarValueChange);
     		}
     	}
     	xmlHttp.open("POST", "./PractitionerScheduleStatusServlet", true);
     	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
     	// form the 
     	var parameters = getPractitionerScheduleStatusParameters();
     	xmlHttp.send(parameters); 
     });
     
     function getHttpObject(){
    		var xmlHttp;
    		if (window.XMLHttpRequest) {
    			xmlHttp = new XMLHttpRequest();
    		} else if (window.ActiveXObject) {
    			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
    		}
    		return xmlHttp;
    }
     
    function onCalendarValueChange(){
		var calendarObj = $("#PreferredDateInTimeSlot").data("kendoCalendar");
		//var preferredDateInTimeSlotComp = document.getElementById("hdnPreferredDateInTimeSlotFrame");
		if(calendarObj){
			//alert('on calendar value change  '+calendarObj.value());	
		}else{
			//alert('calendar obj is not valid');
		}
    } 
     
    function getPractitionerScheduleStatusParameters(){
    	var parameters = "";
    	// speciality
    	var hdnSpecialityCode = document.getElementById("hdnSelectedSpeciality");
    	var specialityCode="";
    	if(hdnSpecialityCode){
    		specialityCode = hdnSpecialityCode.value;
    	}
    	parameters +="hdnSelectedSpeciality="+specialityCode;
    	parameters +="&";
    	
    	// facility
    	var hdnFacility = document.getElementById("Facility");
    	var facility="";
    	if(hdnFacility){
    		facility = hdnFacility.value;
    	}
    	parameters +="Facility="+facility;
    	parameters +="&";
    	
    	// preferred date
    	//var preferredDateComp = document.getElementById("hdnPreferredDate");
    	var preferredDateComp = document.getElementById("hdnPreferredDateInTimeSlotFrame");
    	var preferredDate="";
    	if(preferredDateComp){
    		preferredDate = preferredDateComp.value;
    	}
    	parameters +="hdnPreferredDate="+preferredDate;
    	parameters +="&";
    	
    	// preferred from time
    	var preferredFromTimeComp = document.getElementById("ApptPreferredFromTime");
    	var preferredFromTime="";
    	if(preferredFromTimeComp){
    		preferredFromTime = preferredFromTimeComp.value;
    	}
    	parameters +="ApptPreferredFromTime="+preferredFromTime;
    	parameters +="&";
    	
    	// preferred to time
    	var preferredToTimeComp = document.getElementById("ApptPreferredToTime");
    	var preferredToTime="";
    	if(preferredToTimeComp){
    		preferredToTime = preferredToTimeComp.value;
    	}
    	parameters +="ApptPreferredToTime="+preferredToTime;
    	parameters +="&";
    	
    	// practitioner id
    	var practitionerIdComp = document.getElementById("hdnPractitionerId");
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
    			//preferredDate = preferredDateObj.toString('MM/dd/yyyy');
    			//alert(preferredDate);
    			//alert('calendar is valid '+preferredDate);
    		}else{
    			preferredDate = preferredDateInTimeSlot.value;
    			//alert('calendar is invalid '+preferredDate);
    			alert('Cannot proceed to get timeslot for selected date '+hdnPreferredDateInTimeSlot.value+'. System error');
    			return false;
    		}
    		//alert(preferredDate);
    		hdnPreferredDateInTimeSlot.value = preferredDate;
    	}
    	
    	var formElement = document.getElementById("timeslotform");
    	if(formElement){
    		formElement.action = "./PractitionerTimeSlotServlet";
    		formElement.submit();
    	}
    }
    
   function selectSpeciality(spanElement,specialityCodeId,specialityDescId){
   	 // this function sets the background color of a selected specialty
   	 // this function also sets the hidden speciality elements with
   	 // the value of the selected speciality and the speciality description
   	 
   	 spanElement.style.backgroundColor="#C1D994";
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

   function getPractitionerList(){
	   // this function is invoked when user clicks on search button
	   // in this page
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
		var formElement = document.getElementById("timeslotform");
		 if(formElement){
			 formElement.action = "../schedule/SpecialityServlet";
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
   
   function confirmAppointmentRequest(){
	   // this function shows the confirmation dialog
	   // to the user before proceeding to book an appointment request
	   
	   // first validate if any time slot is selected
		// preferred time slot
	   var selectedTimeSlotComp = document.getElementById("hdnSelectedTimeSlot");
	   var selectedTimeSlot = "";
	   if(selectedTimeSlotComp){
		   selectedTimeSlot = selectedTimeSlotComp.value;
		   if(selectedTimeSlot.length == 0){
			   alert('Time slot is not selected for the appointment request');
			   return false;
		   }
	   }
	   
	   // need to get the practitioner name, selected specialty
	   // appointment date and time
	   var practNameComp = document.getElementById("hdnPractitionerName");
	   var practName = "";
	   if(practNameComp){
		   practName = practNameComp.value;
		   practName = escape(practName);
	   }
	   
	   var selectedSpecialtyComp = document.getElementById("hdnSelectedSpecialtyDesc");
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
		
		$("#requestConfirmContainerDiv").fadeIn(300, "linear", function () { $("#requestConfirmDiv").show(400, "swing"); }); 
		
		
		
		/* $('#requestConfirmContainerDiv').animate({zIndex:2},'fast');
		$('#requestConfirmContainerDiv').animate({opacity:0.70},'fast');
		$('#requestConfirmDiv').animate({zIndex:10},'fast');
		$('#requestConfirmDiv').animate({width:"582px"},'slow');
		$('#requestConfirmDiv').animate({height:"245px"},'fast'); */
		
   }
   
   function closeConfirmAppointmentPopup(){
	   // this function will close the confirm popup dialog
		$("#requestConfirmDiv").hide('300', "swing", function () { $("#requestConfirmContainerDiv").fadeOut("200"); });
	   
		/* $('#requestConfirmDiv').animate({zIndex:-1},'fast');
		$('#requestConfirmDiv').animate({width:"0px"},'fast');
		$('#requestConfirmDiv').animate({height:"0px"},'fast');
		$('#requestConfirmContainerDiv').animate({zIndex:-2},'fast');
		$('#requestConfirmContainerDiv').animate({opacity:0},'fast'); */
		//reinitializeCalendar();
		var formElement = document.getElementById("timeslotform");
    	if(formElement){
    		formElement.action = "./PractitionerTimeSlotServlet";
    		formElement.submit();
    	}
	}
   
  
   function bookAppointment(){
	   // this function will book an appointment request based
	   // on the configuration done already in the page
	   
	   // first hide the confirmation dialog
	   $("#requestConfirmDiv").hide('200', "swing", function () { $("#requestConfirmContainerDiv").fadeOut("100"); });
	   
	   // This function will book the appointment for the user
	   var serializeStr = $("#timeslotform").serialize();
	   //alert(serializeStr);
	   var bookAppointmentURL = "./BookAppointmentServlet?"+serializeStr;
	   $('#bookapptContentDiv').load(bookAppointmentURL);
	   
	   if (document.getElementById('bookapptRequestContainerDiv').style.visibility == 'hidden') {
	       document.getElementById('bookapptRequestContainerDiv').style.visibility = '';
	       $("#bookapptRequestContainerDiv").hide();
	    }
	    if (document.getElementById('bookapptContentDiv').style.visibility == 'hidden') {
	       document.getElementById('bookapptContentDiv').style.visibility = '';
	       $("#bookapptContentDiv").hide();
	    }
		
		$("#bookapptRequestContainerDiv").fadeIn(200, "linear", function () { $("#bookapptContentDiv").show(300, "swing"); });
   }
   
   function cancelAppointment(){
	   // this function will cancel the appointment booking
	   $("#requestConfirmDiv").hide('300', "swing", function () { $("#requestConfirmContainerDiv").fadeOut("200"); });
	   
	   /* $('#requestConfirmDiv').animate({zIndex:-1},'fast');
		$('#requestConfirmDiv').animate({width:"0px"},'fast');
		$('#requestConfirmDiv').animate({height:"0px"},'fast');
		$('#requestConfirmContainerDiv').animate({zIndex:-2},'fast');
		$('#requestConfirmContainerDiv').animate({opacity:0},'fast'); */
	   //reinitializeCalendar();
	   var formElement = document.getElementById("timeslotform");
	   	if(formElement){
	   		formElement.action = "./PractitionerTimeSlotServlet";
	   		formElement.submit();
	   	}
   }
   
   function postBookAppointment(errorCodeStr){
	   // this function will hide the popup which is shown after the
	   // book appointment operation is performed
	   // this function will also forward the request to a suitable page
	   
	   // first hide the popup
	   $("#bookapptContentDiv").hide('200', "swing", function () { $("#bookapptRequestContainerDiv").fadeOut("100"); });
	   
	   var actionURL = '';
	   
	   // this is for successful appointment booking
	   if(errorCodeStr == '2'){
		  actionURL = "./UpcomingAppointments.jsp" ;
	   }else if(errorCodeStr == '1'){
		   actionURL = './SpecialityServlet';
	   }
	   
	   var formElement = document.getElementById("timeslotform");
	   if(formElement){
		   formElement.action = actionURL;
		   formElement.submit();
	   }
   }
   
   function getDateObject(scheduleDate){
	   // this function returns a date object for the string in the format dd/MM/yyyy
	   var dateIndex = scheduleDate.indexOf("/");
		var dateStr = scheduleDate.substring(0,dateIndex);
		var dateVal = getIntValue(dateStr,0);
		
		var monthIndex = scheduleDate.indexOf("/",dateIndex+1);
		var monthStr = scheduleDate.substring(dateIndex+1,monthIndex);
		var monthVal = getIntValue(monthStr,0);
		
		var yearStr = scheduleDate.substring(monthIndex+1,scheduleDate.length);
		var yearVal = getIntValue(yearStr,0);
		// initialize the preferred date
		var preferredDate = new Date(yearVal,monthVal-1,dateVal);
		return preferredDate;
   }
   
   function reinitializeCalendar(){
	   $("#PreferredDateInTimeSlot").kendoCalendar({
	        value: new Date(),
 	        footer: " #=kendo.toString(data, 'd') #",
            format: "dd/MM/yyyy" 
        });
   }
   
   function performOperation(){
	   // this function performs the main operation in this page
	   bookAppointment();
   }
   
   function cancelOperation(){
	// this function cancels the main operation in this page
	   cancelAppointment();
   }
   
   function postOperation(errorCodeStr){
	// this function performs some more actions post
	// the main operation
	   postBookAppointment(errorCodeStr);
   }
   
 </script>    

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

	// read the input parameters
	String selectedSpecialityCode = request
			.getParameter("hdnSelectedSpeciality");
	if (selectedSpecialityCode == null) {
		selectedSpecialityCode = "";
	}

	String facilityId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITY_PARAMETER_KEY);
	if (facilityId == null) {
		facilityId = "";
	}

	// this is the preferred date from the left hand side search panel
	String preferredDateStr = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY);
	if (preferredDateStr == null) {
		preferredDateStr = request.getParameter("hdnPreferredDate");
		if (preferredDateStr == null) {
			preferredDateStr = "";
		}
	}
	
	// this is the preferred date given in the time slot frame
	String preferredDateInTimeSlotFrame = request.getParameter("hdnPreferredDateInTimeSlotFrame");
	if(preferredDateInTimeSlotFrame == null || preferredDateInTimeSlotFrame.trim().equals("")){
		preferredDateInTimeSlotFrame = preferredDateStr;
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

	String practitionerId = request.getParameter("hdnPractitionerId");
	if (practitionerId == null) {
		practitionerId = "";
	}

	String clinicCode = request.getParameter("hdnClinicCode");
	if (clinicCode == null) {
		clinicCode = "";
	}

	String practitionerName = request
			.getParameter("hdnPractitionerName");
	if (practitionerName == null) {
		practitionerName = "";
	}

	String selectedSpecialityDescription = request
			.getParameter("hdnSelectedSpecialtyDesc");
	if (selectedSpecialityDescription == null) {
		selectedSpecialityDescription = "";
	}

	String timeslotFromTime = request
			.getParameter(CreateAppointmentConstants.TIMESLOT_PREFERREDFROMTIME_PARAMETER_KEY);
	if (timeslotFromTime == null || timeslotFromTime.trim().equals("")) {
		timeslotFromTime = preferredFromTime;
	}

	String timeslotToTime = request
			.getParameter(CreateAppointmentConstants.TIMESLOT_PREFERREDTOTIME_PARAMETER_KEY);
	if (timeslotToTime == null || timeslotToTime.trim().equals("")) {
		timeslotToTime = preferredToTime;
	}
	
	// there are two time selections in the GUI page
	// the time selection in the time slot section overrides the time selection
	// in the left hand side panel - override the time selection here
	if(!timeslotFromTime.equalsIgnoreCase(preferredFromTime)){
		preferredFromTime = timeslotFromTime;
	}
	if(!timeslotToTime.equalsIgnoreCase(preferredToTime)){
		preferredToTime = timeslotToTime;
	}
	
	// selected facility description is also read now
	// used for GUI
	String selectedFacilityDescription = request.getParameter("hdnSelectedFacilityDesc");
	if(selectedFacilityDescription == null){
		selectedFacilityDescription = "";
	}

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
%>

<div id="wrapper" style="background-color: #ffffff;">
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
	<div id="content" style="padding-bottom: 15px;">
     <!-- #Patient Banner-->
       <!-- #Patient Banner-->
	   <!-- #Content Area-->
     	<div id="contentbg">
		</div>
			<div id="contentArea">
			
				<div id="contentArearow">
				<div id="booknewbreadcrumb"><span class="contenbold"><a href="./UpcomingAppointments.jsp" class="backpage">My appointments</a></span> <span class="contenbold" id="arrow">></span> <span class="contenbold">Book new appointment request</span></div>
				<form id="timeslotform" name="timeslotform" id="timeslotform" method="POST"> 
				<div class="row">
					<div class="cellindex searchindex" >
						<div id="BooknewAppsearch">
							<div class="BookAppTitle"  >
								<a class="rectitle" href="BooknewAppoinmentRecentSearch.html">Recent doctor</a>
							</div>
							<div class="BookAppTitle">
								<a class="rectitle"> Modify search</a>
							</div>
							<div id="SearchPanel" style="height:330px;">
								<div class="searchfields">
									<div class="Apptitle">Preferred date</div>
									<!-- <input class="textboxdatesearch" type="text" placeholder="Date"/> -->
									<input id="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY%>" name="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY%>" value="<%=preferredDateStr%>" style="width:180px;" />
								</div>
								<div class="searchfields">
									<div class="Apptitle ">Preferred time</div>
									<select class="Combotimesearch" id="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>"
											name="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>">
									 <%
									 	// check for empty alone is fine
									 	if (preferredFromTime.trim().equals("")) {
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
											/* if (preferredFromTime.equalsIgnoreCase(apptTimeValue)) {
												selected = "selected";
											} */
											if (preferredFromTime.equalsIgnoreCase(apptDataValue)) {
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
									 	if (preferredToTime.trim().equals("")) {
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
										// iterate through the list and show the time
										for (AppointmentTime apptTime : apptToTimeList) {
											selected = "";
											apptTimeValue = apptTime.getAppointmentTime();
											apptDataValue = apptTime.getAppointmentDataValue();
											/* if (preferredToTime.equalsIgnoreCase(apptTimeValue)) {
												selected = "selected";
											} */
											if (preferredToTime.equalsIgnoreCase(apptDataValue)) {
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
			       				   		// get the facility list as a normal java service
			       				   		// this is done only to improve performance
			       				   		FacilityListRequest facilityListRequest = new FacilityListRequest();
			       				   		facilityListRequest
			       				   				.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

			       				   		/* FacilityListSvcImpl facilityListSvcImpl = new FacilityListSvcImpl();
			       				   		FacilityListResponse facilityListResponse = facilityListSvcImpl
			       				   				.getFacilityList(facilityListRequest); */
										FacilityListServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
										FacilityListResponse facilityListResponse = facilityListServiceInvoker.getDataThroughService(facilityListRequest);
			       				   		
			       				   		/* ErrorInfo facilityListErrorInfo = facilityListResponse
			       				   				.getErrorInfo(); */
			       				   		List<Facility> facilityList = null;
			       				   		/* if (ErrorInfo.SUCCESS_CODE == facilityListErrorInfo.getErrorCode()) { */
			       				   		if (facilityListResponse.isSuccessful()) {	
			       				   			facilityList = facilityListResponse.getFacilityList();
			       				   			for (Facility facility : facilityList) {
			       				   				if (facilityId.equalsIgnoreCase(facility.getFacilityId())) {
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
										<input class="textboxtimeSpeciality" type="text"  id="specialitySearchText" name="specialitySearchText" id="specialitySearchText" placeholder="Search"><img id="specialitySearch" src="../../images/Search.png" onclick="searchSpeciality()"/></input>
										<div class="specialityDiv" style="height:80px;">
											<%
												int specialityIndex = 1;
												String specialityCodeVal = "SpecialityCode" + specialityIndex;
												String specialityId = "Speciality" + specialityIndex;
												String selectedStyle = "options";
												String spanDisplayStyle = "display:block";
												// this is for empty speciality
												if (selectedSpecialityCode.trim().equals("")) {
											%>
											<span class="options selectedopt" id="<%=specialityId%>" name="<%=specialityId%>" style="<%=spanDisplayStyle%>;padding-left:10px;padding-top:5px;padding-right:10px;padding-bottom:5px;" onclick="selectSpeciality(this,'<%=specialityCodeVal%>')">Not Known</span>
											<input type="hidden" id="<%=specialityCodeVal%>" name="<%=specialityCodeVal%>" value="">
											<%
												} else {
											%>
											<span class="options" id="<%=specialityId%>" name="<%=specialityId%>" style="<%=spanDisplayStyle%>;padding-left:10px;padding-top:5px;padding-right:10px;padding-bottom:5px;" onclick="selectSpeciality(this,'<%=specialityCodeVal%>')">Not Known</span>
											<input type="hidden" id="<%=specialityCodeVal%>" name="<%=specialityCodeVal%>" value="">
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
															// check if the selected speciality
															// equals any of the specialities
															// obtained from the service
															if (selectedSpecialityCode.equals(specialityCode)) {
																selectedStyle = "options selectedopt";
															}
	
															specialityIndex++;
															specialityId = "Speciality" + specialityIndex;
															specialityCodeVal = "SpecialityCode" + specialityIndex;
											%>
											<span class="<%=selectedStyle%>"  id="<%=specialityId%>" name="<%=specialityId%>" style="<%=spanDisplayStyle%>;padding-left:10px;padding-top:5px;padding-right:10px;padding-bottom:5px;" onclick="selectSpeciality(this,'<%=specialityCodeVal%>')"><%=specialityDescription%></span>
											<input type="hidden" id="<%=specialityCodeVal%>" name="<%=specialityCodeVal%>" value="<%=specialityCode%>">
											<%
														}
													}
												}
											%>
									</div>
								</div>
							</div>
							<span class="btn marginalign" onclick="getPractitionerList()">Search</span>
						</div>
					</div>
					</div>
						<div class="tablebooknewapp"> 
							<div class="row">
								<div class="celldivider">
								</div>
								<div class="cellindex bookingcell">
									<div id="BooknewAppDoctor">
										<div class="SelectionViewboonnew" style="background-image:url('../../images/Book.PNG');height:508px;width:1000px;">
											
											<div id="SelectLeftPanelbooknew" style="height:483px;width:47.4%;">
												<div class="DoctorAppRescheduletime" style="width:380px;">
													<div class="DoctorDetailStripTimeReschedule"  style="width:372px;">
														<div class="DoctorInnerstrip">
															<div class="ImageSchedule"><img class="doctorIcon" src="../../images/doctor.png"/></div>
															<div class="DocDetailsTime" style="width:270px;"><span class="contenbold"><%=practitionerName%></span><br/>
																<span class="contentnormal"><%=selectedSpecialityDescription%></span><br/>
																<span class="contentnormal"><%=selectedFacilityDescription %></span>
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
												
												<div class="bookcontent" >
													<div id="Apptime">
														<div class="calender ">
														<!-- <img src="../../images/calendar2013.PNG"/> -->
															<div id="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_TIMESLOT_PARAMETER_KEY%>"
			               										name="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_TIMESLOT_PARAMETER_KEY%>" 
			               										style="width: 262px;">
			               									</div>
														</div>
														<div class="availability"><div id="available"></div>Available</div>
														<div class="availability"><div id="full"></div>Full</div>
														<div class="availability"><div id="leave"></div>Leave</div>
														
														<div class="ApptitleReschedule contenbold" >Preferred time</div>
														<select class="textboxtimeindex"  
															id="<%=CreateAppointmentConstants.TIMESLOT_PREFERREDFROMTIME_PARAMETER_KEY%>" 
															name="<%=CreateAppointmentConstants.TIMESLOT_PREFERREDFROMTIME_PARAMETER_KEY%>" >
															<%
																if (apptStartTimeList == null || apptStartTimeList.isEmpty()) {
																	apptFromTimeResponse = ScheduleHelper
																			.getAppointmentTimeResponse(apptFromTimeRequest);
																	apptStartTimeList = apptFromTimeResponse
																			.getAppointmentTimeList();
																}

																if (timeslotFromTime.trim().equals("")) {
															%>
																<option value="" selected="selected">Select time</option>
															 <%
															 	} else {
															 %>
																<option value="">Select time</option>
															<%
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
																	/* if (timeslotFromTime.equalsIgnoreCase(apptTimeValue)) {
																		selected = "selected";
																	} */
																	if (timeslotFromTime.equalsIgnoreCase(apptDataValue)) {
																		selected = "selected";
																	}
															%>
															<option value="<%=apptDataValue%>" <%=selected%>><%=apptTimeValue%></option>
															<%
																}
															%>
														</select>
														<span >to</span>
														<select class="textboxtimeindex" 
															id="<%=CreateAppointmentConstants.TIMESLOT_PREFERREDTOTIME_PARAMETER_KEY%>" 
															name="<%=CreateAppointmentConstants.TIMESLOT_PREFERREDTOTIME_PARAMETER_KEY%>" >
														<%
															if (apptToTimeList == null || apptToTimeList.isEmpty()) {
																apptToTimeResponse = ScheduleHelper
																		.getAppointmentTimeResponse(apptFromTimeRequest);
																apptToTimeList = apptToTimeResponse.getAppointmentTimeList();
															}

															if (timeslotToTime.trim().equals("")) {
														%>
															<option value="" selected="selected">Select time</option>
														 <%
														 	} else {
														 %>
															<option value="">Select time</option>
														<%
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
																if (timeslotToTime.equalsIgnoreCase(apptDataValue)) {
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
															String preferredDateDisplayStr = ScheduleHelper
																	.getPreferredDateInDisplayFormat(
																			preferredDateInTimeSlotFrame,
																			CreateAppointmentConstants.PRACTITIONERSTATUS_DATEFORMAT,
																			CreateAppointmentConstants.PRACTITIONERTIMESLOT_DATE_DISPLAY_FORMAT);
															out.println(preferredDateDisplayStr);
														%>
														</div>
														
													</div>
													
													<div class="centeralign ReschedulebtnBottom">
														<span><a href="#" onclick="checkTimeSlot()" class="PPbtn">Check time slot</a></span>
													</div>
												</div>
											</div>
											
											
											<div id="SelectRightPanelbooknew" style="height:483px;">
												<%
													// code to get the time slot information
													// initialize the request first
													PractitionerTimeSlotRequest timeSlotRequest = new PractitionerTimeSlotRequest();
													timeSlotRequest.setFacilityId(facilityId);
													timeSlotRequest.setPractitionerId(practitionerId);
													timeSlotRequest.setClinicCode(clinicCode);
													timeSlotRequest.setClinicType(CreateAppointmentConstants.PRACTITIONERSCHEDULESTATUS_DEFAULT_CLINICTYPE);
													timeSlotRequest.setResourceType(CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);
													timeSlotRequest.setLocale(Locale.getDefault().getLanguage());
													timeSlotRequest.setPreferredDate(preferredDateInTimeSlotFrame);
													timeSlotRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
													
													/* PractitionerTimeSlotSvcImpl timeSlotSvcImpl = new PractitionerTimeSlotSvcImpl();
													timeSlotSvcImpl.registerService(timeSlotRequest); */
													
													PractitionerTimeSlotServiceInvoker timeSlotServiceInvoker = new PractitionerTimeSlotServiceInvoker();
													timeSlotServiceInvoker.registerService(timeSlotRequest);
													PractitionerTimeSlotResponse timeSlotResponse = (PractitionerTimeSlotResponse)timeSlotServiceInvoker.getDataThroughWebService(timeSlotRequest);
													
													/* ErrorInfo timeSlotErrorInfo = timeSlotResponse.getErrorInfo(); */
													String errorMessage = null;
													/* if(ErrorInfo.SUCCESS_CODE != timeSlotErrorInfo.getErrorCode()){ */
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
												<div id="Selected">Selected date and time: <%=preferredDateDisplayStr%>, <span id="selectedtimespan"><%=ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotFromTime) %> - <%=ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotToTime) %></span></div>
												<div class="centeralign ReschedulebtnBottom">
													<span><a class="disabled" style="float:center;">Book an appointment</a></span>
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
												<div id="Selected">Selected date and time: <%=preferredDateDisplayStr%>, <span id="selectedtimespan"><%=ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotFromTime) %> - <%=ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotToTime) %></span></div>
												<div class="centeralign ReschedulebtnBottom">
													<span><a class="disabled" style="float:center;">Book an appointment</a></span>
												</div>		
												<%		
														}else{
															// morning time slots are placed at 0th index
														List<TimeSlot> morningTimeSlots = morningAndEveningTimeSlots.get(0);
														List<TimeSlot> eveningTimeSlots = morningAndEveningTimeSlots.get(1);
														
														String updatedPreferredFromTime = ScheduleHelper.
																getApptSelectedTimeInDisplayFormat(timeslotFromTime);
														String updatedPreferredToTime = ScheduleHelper.
																getApptSelectedTimeInDisplayFormat(timeslotToTime);
														
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
												
												<div id="preferredtime"><div id="prefer"></div>Preferred time</div>
												<div id="Selected">Selected date and time: <%=preferredDateDisplayStr%>, <span id="selectedtimespan"><%=ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotFromTime) %> - <%=ScheduleHelper.getApptSelectedTimeInDisplayFormat(timeslotToTime) %></span></div>
												<div class="centeralign ReschedulebtnBottom">
													<span><a onclick="confirmAppointmentRequest()"  class="PPbtn">Book an appointment request</a></span>
												</div>
												
												<%
														}
													}
												%>
												
											</div><!-- end of right panel -->
										</div>
									</div>
								</div>
							</div>
						</div>
						
				</div>
						
				<!-- div to show the confirmation popup -->
				<div id="requestConfirmContainerDiv" class="confirmpopupContainerStyle" style="visibility:hidden;">
					<div id="requestConfirmDiv" class="confirmpopupContentStyle" style="visibility:hidden;">
					</div>
				</div>
				
				<!--  div to perform the book appointment request and then show result popup -->
				<div id="bookapptRequestContainerDiv" class="bookapptContainerStyle" style="visibility:hidden;">
					<div id="bookapptContentDiv" class="bookapptpopupContentStyle" style="visibility:hidden;">
					</div>
				</div>			
						
						<!-- put the hidden elements here -->
					<input type="hidden" id="hdnSpecialityIndex" name="hdnSpecialityIndex" id="hdnSpecialityIndex" value="<%=specialityIndex%>">	
				 	<input type="hidden" id="hdnSelectedSpeciality" name="hdnSelectedSpeciality" id="hdnSelectedSpeciality" value="<%=selectedSpecialityCode%>">
					<input type="hidden" id="hdnFacilityId" name="hdnFacilityId" id="hdnFacilityId" value="<%=facilityId%>">
					<input type="hidden" id="hdnPreferredDate" name="hdnPreferredDate" id="hdnPreferredDate" value="<%=preferredDateStr%>">
					<%-- <input type="hidden" id="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>" name="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>" value="<%=preferredFromTime%>">
					<input type="hidden" id="<%=CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY%>" name="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>" value="<%=preferredToTime%>"> --%>
					<input type="hidden" id="hdnPractitionerId" name="hdnPractitionerId" id="hdnPractitionerId" value="<%=practitionerId%>">
					<input type="hidden" id="hdnClinicCode" name="hdnClinicCode" id="hdnClinicCode" value="<%=clinicCode%>">
					<input type="hidden" id="hdnSelectedSpecialtyDesc" name="hdnSelectedSpecialtyDesc" id="hdnSelectedSpecialtyDesc" value="<%=selectedSpecialityDescription%>">
					<input type="hidden" id="hdnSelectedFacilityDesc" name="hdnSelectedFacilityDesc" id="hdnSelectedFacilityDesc" value="<%=selectedFacilityDescription%>">
					<input type="hidden" id="hdnSelectedTimeSlot" name="hdnSelectedTimeSlot" id="hdnSelectedTimeSlot" value="">
					<input type="hidden" id="hdnPractitionerName" name="hdnPractitionerName" id="hdnPractitionerName" value="<%=practitionerName%>">
					<input type="hidden" id="hdnPreferredDateInTimeSlotFrame" name="hdnPreferredDateInTimeSlotFrame" id="hdnPreferredDateInTimeSlotFrame" value="<%=preferredDateInTimeSlotFrame%>">
					<input type="hidden" id="hdnSelectedTimeSlotDivId" name="hdnSelectedTimeSlotDivId" id="hdnSelectedTimeSlotDivId" value="">
			 	</form> 
						
				</div> 
			</div>
			
		</div>
       <!-- #Content Area-->
        
	
    <!-- #content-->
	<div class="clear"></div>
	<div class="Footerbg" style="margin-top:5px;">
	
	<div id="poweredby">
			<p class="poweredby">Powered by <img src="../../images/csc.png" width="25" height="14"></p>
        </div>
</div>
</div>
</div>
<!-- #wrapper -->


</body>
</html>

