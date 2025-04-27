<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.schedule.viewappointment.svc.AppointmentDetailsServiceInvoker"%>
<%@page import="portalrefimpl.facility.facilityforpatient.svc.FacilityListServiceInvoker"%>
<%@page import="portalrefimpl.homepage.response.HospitalDetailsResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTime"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeResponse"%>
<%@page import="portalrefimpl.schedule.ScheduleHelper"%>
<%@page import="portalrefimpl.schedule.ScheduleConstants"%>
<%@page import="portalrefimpl.schedule.createappointment.AppointmentTimeRequest"%>
<%@page import="portalrefimpl.common.model.Facility"%>
<%@page import="portalrefimpl.facility.facilityforpatient.response.FacilityListResponse"%>
<%@page import="portalrefimpl.facility.facilityforpatient.request.FacilityListRequest"%>
<%@page import="portalrefimpl.schedule.createappointment.response.SpecialityModel"%>
<%@page import="portalrefimpl.schedule.createappointment.response.SpecialityResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.svc.serviceinvoker.SpecialityServiceInvoker"%>
<%@page import="portalrefimpl.schedule.createappointment.request.SpecialityRequest"%>
<%@page import="portalrefimpl.schedule.createappointment.CreateAppointmentConstants"%>
<%@page import="portalrefimpl.result.ResultConstants"%>
<%@page import="portalrefimpl.common.CommonConstants"%>
<%@page import="portalrefimpl.result.viewtestresult.response.TestDetails"%>
<%@page import="portalrefimpl.schedule.viewappointment.response.AppointmentDetails"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.result.viewtestresult.svc.TestDetailsServiceInvoker"%>
<%@page import="portalrefimpl.result.viewtestresult.response.TestDetailsResponse"%>
<%@page import="portalrefimpl.result.viewtestresult.request.TestDetailsRequest"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse"%>
<%@page import="portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest"%>
<%@page import="portalrefimpl.homepage.response.PatientDetailsResponse"%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page import="java.util.Date"%>
<%@page import="portalrefimpl.homepage.svc.HospitalDetailsServiceInvoker"%>
<%@page import="portalrefimpl.homepage.request.HospitalDetailsRequest"%>
<%@page import="portalrefimpl.common.response.BaseResponse"%>
<%@page import="portalrefimpl.common.serviceinvoker.ServiceInvoker"%>
<%@page import="portalrefimpl.homepage.svc.PatientDetailsServiceInvoker"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.homepage.request.PatientDetailsRequest"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Patient Portal - Home :::</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../css/style_ie.css" type="text/css"/>
<link href="../css/examples-offline.css" rel="stylesheet">
<link href="../css/kendo.common.min.css" rel="stylesheet">
<link href="../css/kendo.default.min.css" rel="stylesheet">

<script src="../js/jquery.min.js"></script>
<script src="../js/kendo.web.min.js"></script>
<script src="../js/console.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<style scoped>
    #special-days {
        height: 190px;
        width: 300px;
        margin: 2px auto;
        /*padding: 2px 0 2px 2px;*/
    }

    #ApptPreferredDate {
        border-radius: 1px 1px 1px 1px;
        border-style: solid;
        border-width: 1px;
    }

    .k-header {
        border-radius: 3px 3px 0 0;
    }

    #ApptPreferredDate .k-content {
        height: 142px;
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

</style>

<style>

.menu li a:hover:before {content:url(../images/LeftMenubg.PNG);
	height:80px;
	width:auto;
	top:63px;
	left:-13px;
	position:relative;
}

.menu li a:hover:after{
	content:url(../images/RightMenubg.PNG);
	height:80px;
	width:auto;
	top:35px;
	right:-13px;
	position:relative;
}

.menuselect:after{
	content:url(../images/RightMenubg.PNG);
	height:80px;
	width:auto;
	top:35px;
	right:-13px;
	position:relative;

}
.menuselect:before {content:url(../images/LeftMenubg.PNG);
	height:80px;
	width:auto;
	top:65px;
	left:-13px;
	position:relative;

}

</style>

 <script>
     $(document).ready(function() {
         var today = new Date();

         $("#ApptPreferredDate").kendoCalendar({
             value: today,
             footer: "Today - #=kendo.toString(data, 'd') #",
             format: "dd/MM/yyyy" 
         });
     });
     
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
    	 var formElement = document.getElementById("bookappointmentform");
    	 if(formElement){
    		 formElement.action = "./schedule/SpecialityServlet";
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
     
     
 </script>


</head>
<body>

<%
	String useWebService = "";
	useWebService = (String) session
			.getAttribute(PortalConstants.USEWEBSERVICE_SESSION_KEY);
	/* useWebService = request.getParameter("useWebService");
	if (useWebService == null || useWebService.trim().equals("")) {
		useWebService = (String) getServletConfig().getServletContext()
				.getAttribute("useWebService");
		if (useWebService == null || useWebService.trim().equals("")) {
			useWebService = "N";
		}
	} */

	String patientId = "";
	patientId = (String) session
			.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
	/* patientId = request.getParameter("patientId");
	if (patientId == null) {
		patientId = (String) getServletConfig().getServletContext()
				.getAttribute("patientId");
		if (patientId == null) {
			patientId = "";
		}
	} */

	//HomePageSvcImpl homePageSvcImpl = new HomePageSvcImpl();
	PatientDetailsRequest patientDetailsRequest = new PatientDetailsRequest();
	patientDetailsRequest.setPatientId(patientId);
	patientDetailsRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

	//homePageSvcImpl.registerService(patientDetailsRequest);

	ServiceInvoker patientDetailsServiceInvoker = new PatientDetailsServiceInvoker();
	patientDetailsServiceInvoker.registerService(patientDetailsRequest);
	PatientDetailsResponse patientDetailsResponse = (PatientDetailsResponse) patientDetailsServiceInvoker
			.getDataThroughWebService(patientDetailsRequest);

	String patientName = null;
	String nationalId = null;
	// inspect the patient details response for success and then set data
	if(patientDetailsResponse.isSuccessful()){
		patientName = patientDetailsResponse.getPatientDisplayName();
		nationalId = patientDetailsResponse.getNationalId();
		if(nationalId == null){
			nationalId = "";
		}
		
		// store the patient name in the session
		session.setAttribute(PortalConstants.PATIENTNAME_SESSION_KEY,
				patientName);
	}
	
	HospitalDetailsRequest hospitalDetailsRequest = new HospitalDetailsRequest();
	hospitalDetailsRequest.setPatientId(patientId);
	hospitalDetailsRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	//hospitalDetailsRequest.setFacilityId("HS");
	HospitalDetailsResponse hospitalDetailsResponse = null;
	//hospitalDetailsResponse = homePageSvcImpl.getHospitalDetails(hospitalDetailsRequest);
	/* ServiceInvoker hospitalDetailsServiceInvoker = new HospitalDetailsServiceInvoker();
	BaseResponse hospitalResponse = hospitalDetailsServiceInvoker
			.getDataThroughWebService(hospitalDetailsRequest);  */

	AppointmentDetailsRequest appointmentDetailsRequest = new AppointmentDetailsRequest();
	appointmentDetailsRequest.setPatientId(patientId);
	appointmentDetailsRequest.setRecordCount(CommonConstants.HOMEPAGE_APPOINTMENTLIST_RECORDCOUNT);
	appointmentDetailsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	// initialize the service impl and register it
	/* AppointmentSvcImpl appointSvc = new AppointmentSvcImpl(); */
	/* appointSvc.registerService(appointmentDetailsRequest); */
	// appointments response object
	AppointmentDetailsResponse appointmentDetailsResponse = null;
	AppointmentDetailsServiceInvoker apptDetailsServiceInvoker = new AppointmentDetailsServiceInvoker();

	if ("N".equalsIgnoreCase(useWebService)) {
		/* appointmentDetailsResponse = appointSvc
				.getAppointmentDetails(appointmentDetailsRequest); */
		appointmentDetailsResponse = apptDetailsServiceInvoker.
								getDataThroughService(appointmentDetailsRequest);
	} else if ("Y".equalsIgnoreCase(useWebService)) {
		// need to call the service as a web service
		/* appointmentDetailsResponse = AppointmentDetailsHelper
				.getAppointmentDetail(appointmentDetailsRequest); */
		apptDetailsServiceInvoker.registerService(appointmentDetailsRequest);		
		appointmentDetailsResponse = (AppointmentDetailsResponse)apptDetailsServiceInvoker.
				getDataThroughWebService(appointmentDetailsRequest);		
	}
	
	String originalURL = request.getRequestURL().toString();
	
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
   	//facilityListRequest.setRecordCount(10);

   	/* FacilityListSvcImpl facilityListSvcImpl = new FacilityListSvcImpl(); */
   	FacilityListServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
   	/* facilityListSvcImpl.registerService(facilityListRequest); */
   	
   	/* ServiceInvoker facilityListServiceInvoker = new FacilityListServiceInvoker();
   	FacilityListResponse facilityListResponse = (FacilityListResponse) facilityListServiceInvoker
   			.getDataThroughWebService(facilityListRequest); */
   	/* FacilityListResponse facilityListResponse = (FacilityListResponse) facilityListSvcImpl.getFacilityList(facilityListRequest); */
   	
   	FacilityListResponse facilityListResponse = facilityListServiceInvoker.
   							getDataThroughService(facilityListRequest);
	
	
%>

<div id="wrapper"  style="background-color: #ffffff;">
<div class="fixedheader">	
<header id="header">
    	<div id="headerinfo">
        	<div class="row">
        		<div id="headervisitinfo">
                	Welcome back! Your last visit was on Wed, Dec 5, 2012 12:47:08 PM 
                </div>    
               <div id="headerloginas">
                	 Welcome, <%=patientName%>, ID:<%=patientId %>
               </div>
               <div id="headerlogout">
					<div><a href="../servlet/LogoutServlet"  class="logout">
                    Logout</a></div>
              </div>
          </div>
    </div>
</header>
   
    <!-- #header-->
   
    <!-- #logo And Menu -->

<div id="logomenu">
	<div class="row">
    	<div id="logo">
        <img src="../images/logo.png"> 
        </div>
        
        <div id="Menubox">
			<ul class="menu">
				<li><a href="./Contact.jsp"><div class="menuicons"><img src="../images/Contact.png"/></div>Contact</a></li>
                <li><a href="./result/DetailedResult.jsp"><div class="menuicons"><img src="../images/Results.png"/></div>My Results</a></li>
                <li><a href="./schedule/UpcomingAppointments.jsp"><div class="menuicons"><img src="../images/Appointment.png"/></div>My Appointments</a></li>
                <li class="menuselect"><div class="menuicons"><img src="../images/Home.png"/></div>Home</li>
            </ul>
        </div>
        
    </div>
</div>
</div>
   <!-- #logo And Menu -->
   
<div class="line"></div>

	<div id="content"  style="background-color: #ffffff;">
     <!-- #Patient Banner-->
		<div id="PatientBanner">
        	<div class="row">
            	<div id="Patientphoto">
           	    <img src="../images/sPatientProfile.png"> 
                </div>
                <div id="PatientProfile">
                	<%
                	// there is a need to check for patient details
                	// and then set the data
                	if(patientDetailsResponse.isSuccessful()){
                	%>
                	<p> <span class="contentfont">Welcome,</span>
                    <span class="contencap"><%=patientName%></span></p>
					<p> <span class="contenbold">Patient  ID :</span>
                    <span class="contentfont"><%=patientId%>, </span>
                     <span class="contenbold">NRIC :</span>
                    <span class="contentfont"><%=nationalId%></span></p>
                    <%
                	}else{
                		String errorMsg = patientDetailsResponse.getErrorMessage();
                	
                    %>
                    <p> <span class="loginerror"><%=errorMsg %></span></p>
                    <%
                	}
                    %>
                </div>
            </div> 
            
            
        </div>  
        
       <!-- #Patient Banner-->
	   <!-- #Content Area-->
     	<div id="contentbg" style="height:5px;">
     	</div>
	 <div id="contentArea" style="background-color: #ffffff;">
      
      <div id="contentArearow">
       	<div class="cellindex searchindex">
       		<form id="bookappointmentform" method="POST">
       		<div id="BooknewAppsearchindex">
				<div class="BookAppTitlehomepg">
					Book an appointment
				</div>
       			<div class="bookcontent">
       				<div id="Apptime">
       					
			           <!-- calendar component -->
			           <div id="special-days">
			               <div id="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY%>"
			               name="<%=CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY%>" 
			               style="width: 262px;"></div>
			           </div>
			           <!-- preferred time component -->
            			<div class="ApptitleReschedule"  style="margin-bottom:2px;">Preferred time</div>
						<select class="textboxtimeReschedule" id="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>"
						name="<%=CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY%>" 
						style="width: 110px;">
							<option value="">Select time</option>
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
						<span >to</span>
						<select class="textboxtimeReschedule" id="<%=CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY%>"
						name="<%=CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY%>" 
						style="width: 110px;">
							<option value="">Select time</option>
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
						<select class="textbox" id="<%=CreateAppointmentConstants.SPECIALITY_PARAMETER_KEY%>" 
						name="<%=CreateAppointmentConstants.SPECIALITY_PARAMETER_KEY%>" style="width: 125px;margin-right: 5px;">
							<option value="">---All---</option>
							
							<%
							// code to show the specialities 
							if(sresponse.isSuccessful()){
								List<SpecialityModel> specialityList = sresponse.getSpecialityList();
								String specialityCode;
								String specialityDesc;
								if (specialityList != null) {
									for (SpecialityModel s : specialityList) {
										specialityCode = s.getSpecialityCode();
										specialityDesc = s.getShortDesc();
										String selected = "";
									
							%>
							<option value="<%=specialityCode%>"><%=specialityDesc%></option>
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
						  	List<Facility> facilityList = null;
						  	if (facilityListResponse.isSuccessful()) {
						  		facilityList = facilityListResponse.getFacilityList();
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
					<span><a href="#" onclick="showAppointment()" class="PPbtn">Book an appointment</a></span>
				</div>
			</div>
			</form>
		</div>
        
        <div class="cellindex appindex">
			<div class="tableindex">
				<div class="row">
					<div class="cellindex dividerindex">
					</div>
					<div class="cellindex Appdivs">
						<div id="UpcomingAppindex">
							<div class="appTitlehomepg">            Upcoming appointments            </div>
							<div id="HomepageBox"  style="height:249px">
							
							<%
        	        		String errorMessage = null;//errorInfo.getErrorMessage();
        	        		if (!appointmentDetailsResponse.isSuccessful()) {
        	        			errorMessage = appointmentDetailsResponse.getErrorMessage();	
        	        	%>
        	 			<!-- <span style="margin-left: 50px; color:#ff0000;font-size:14pt;-webkit-transform: rotate(-30deg); -moz-transform: rotate(-30deg);z-index: 2;position: absolute;top:360px;"> -->
        	 			<p>
        	 			<span style="margin-left: 50px; color:#ff0000;font-size:12pt;">
			             <%
			             	out.println(errorMessage);
			             %>
             			 </span>
             			 </p>
						 <%
              				} else {
			              		List<AppointmentDetails> appointmentDetailsList = appointmentDetailsResponse
			              				.getAppointmentDetailsList();
			              		String apptYearAndMonth = "";
			              		int apptDateInt = 0;
			              		String apptDay = "";
			              		String practitioner = "";
			              		String speciality = "";
			              		String apptStartTime = "";
			              		String apptEndTime = "";
			              		
			              		int counter = 0;
			              		String dateStyle = "StripDate";
			              		String practStyle = "AppointmentNewDoctor";
			              		String specialityStyle = "AppointmentnewSPL";
			              		String contentStyle = "contenbold";
			              		for(AppointmentDetails appointmentDetails : appointmentDetailsList){
			              			apptYearAndMonth = appointmentDetails.getAppointmentMonthAndYear();
			              			apptDateInt = appointmentDetails.getAppointmentDateAsInt();
			              			apptDay = appointmentDetails.getAppointmentDay();
			              			practitioner = appointmentDetails.getPractitioner();
			              			speciality = appointmentDetails.getApptSpeciality();
			              			apptStartTime = appointmentDetails.getApptStartTimeAsString();
			              			apptEndTime = appointmentDetails.getApptEndTimeAsString();
							%>
								<!-- Stripbox starts here-->
								<div id="stripbox">
									<div id="row">
									<!-- Stripicon-->
										<div id="StripSpaceA">
											<div id="StripIcon">
												<div id="StripIconHeader">
													<%=apptYearAndMonth %>
												</div>
												<div id="<%=dateStyle%>">
													<%=apptDateInt %>
												</div>
												<div id="Stripday">
													<%=apptDay %>
												</div>
											</div>
										</div>
										<!-- Stripcontent-->
										<div id="StripSpaceB">
											<p><span class="<%=practStyle%>"><%=practitioner %></span></p>
											<p><span class="<%=specialityStyle%>"><%=speciality %></span></p>
											<p><span class="<%=contentStyle%>"><%=apptStartTime %> - <%=apptEndTime %></span></p> 
										</div>
									</div>
								</div>
								<!-- Stripbox ends here-->   
							<%
									if(counter == 0){
										dateStyle = "StripDatenormal";
										practStyle = "AppointmentNewDoctorNormal";
										specialityStyle = "AppointmentnewSPLNormal";
										contentStyle = "contentnormal";
									}
									counter++;
							
				              		}// end of for loop
				            	} // end of else loop
				            %>    
								
							</div>
							<%
							String btnStyle="PPbtn hmepgbtn";
							%>
							
							<div class="centeralign">
								<span><a href="./schedule/UpcomingAppointments.jsp"  class="<%=btnStyle%>" style="margin-top:36px;">Show all appointments</a></span>
							</div>
							
						</div>
					</div>
					<div class="cellindex dividerindex">
						<!-- page divider -->
						<div id="dividercell"></div>
						<!-- page divider -->
					</div>
					
					 <%
                         	TestDetailsRequest testDetailsRequest = new TestDetailsRequest();
                         	testDetailsRequest.setPatientId(patientId);
              				testDetailsRequest.setRecordCount(CommonConstants.HOMEPAGE_TESTRESULTLIST_RECORDCOUNT);
							testDetailsRequest.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
                         	/* TestDetailsSvcImpl testDetailSvc = new TestDetailsSvcImpl(); */
                         	/* testDetailSvc.registerService(testDetailsRequest); */
							TestDetailsServiceInvoker testDetailsServiceInvoker = new TestDetailsServiceInvoker();
                         	TestDetailsResponse testDetailsResponse = null;

                         	if ("N".equalsIgnoreCase(useWebService)) {
                         		/* testDetailsResponse = testDetailSvc
                         				.getTestDetails(testDetailsRequest); */
                         		testDetailsResponse = testDetailsServiceInvoker.
                         					getDataThroughService(testDetailsRequest);		
                         	} else if ("Y".equalsIgnoreCase(useWebService)) {
                         		testDetailsServiceInvoker.registerService(testDetailsRequest);
                         		// need to call the service as a web service
                         		testDetailsResponse = (TestDetailsResponse) testDetailsServiceInvoker
                         				.getDataThroughWebService(testDetailsRequest);
                         	}
                         %> 
					
					
					<div class="cellindex Appdivs"  >
						<div id="UpcomingAppindex">
							<div class="appTitlehomepg">            Recently published results            </div>
							<div id="HomepageBox" style="height:249px">
							
							<%
        	        		if (!testDetailsResponse.isSuccessful()) {
        	        			errorMessage = testDetailsResponse.getErrorMessage();	
			        	     %>
			           		 <!-- <span style="margin-left: 50px; color:#ff0000;font-size:14pt;-webkit-transform: rotate(-30deg); -moz-transform: rotate(-30deg);z-index: 2;position: absolute;top:360px;"> -->
			           		 <p>
			           		 <span style="margin-left: 50px; color:#ff0000;font-size:12pt;">
			                <%
			                	out.println(errorMessage);
			                %>
			                 </span>
			                 </p>
			                 <%
			                 } else {
		                 		List<TestDetails> testDetailsList = testDetailsResponse.getTestDetailsList();
		                		String order = "";
		                		String orderNumber = "";
		                		String practName = "";
		                		String orderDateString = "";
		                		String imageStyle = "";
		                		
		                		int counter = 0;
		                		String orderCatalogueStyle = "AppointmentNewDoctor";
		                		String practStyle = "AppointmentnewSPL";
		                		String contentStyle = "contenbold";
			                 	String testResultType = "";
			                 	// iterate through the test details and show it
		                		for(TestDetails testDetails : testDetailsList){
		                			order = testDetails.getOrder();
		                			orderNumber = testDetails.getOrderNo();
		                			practName = testDetails.getPractName();
		                			orderDateString = testDetails.getOrderDateString();
		                			
		                			imageStyle = "radiology.png";
			                 			testResultType = testDetails.getResultType();
			                 			if ((ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_MEDIUM_KEY
			                 					.equalsIgnoreCase(testResultType))
			                 					|| (ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_ALT_MEDIUM_KEY
			                 							.equalsIgnoreCase(testResultType))) {
			                 				imageStyle = "lab.png";
			                 			}
			                 %>
								<!-- Stripbox-->
								<div id="stripbox">
									<div class="row">
									<!-- Stripicon-->
										<div id="StripSpaceA">
											<div id="Resulticon">
												<img src="../images/<%=imageStyle%>"/>
											</div>
								
										</div>
										<!-- Stripcontent-->
										<div id="StripSpaceB">
											<p><span class="<%=orderCatalogueStyle%>"><%=order %></span></p>
											<p><span class="<%=practStyle%>"><%=practName %></span></p>
											<p><span class="<%=contentStyle%>"><%=orderDateString %></span>
											<!--  <span class="contenbold">Nov 10, 2012 at 11:26pm</span>--> 
												<img class="printPDF" src="../images/PDF.png" width="16" height="16"> 
												<img class="printPDF"src="../images/print.png" width="16" height="16">
											</p>
										</div>
							
									</div>
								</div>
								<!-- Stripbox-->  
				 				 <%
				 				 		if(counter == 0){
				 				 			orderCatalogueStyle = "AppointmentNewDoctorNormal";
				 				 			practStyle = "AppointmentnewSPLNormal";
				 				 			contentStyle = "contentnormal";
				 				 		}
				 				 		counter++;
				 				 
							    		} // end of for loop
					                 } // end of else loop
					             %>
				 				
				 				
							</div>
							
							<%
							 btnStyle = "PPbtn hmepgbtn";
							%>
							
							<div class="centeralign">
								<span><a href="./result/DetailedResult.jsp"  class="<%=btnStyle%>" style="margin-top:36px;">Show all results</a></span>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		
		</div>
	</div> 
	</div>
			
		
       <!-- #Content Area-->
        
	</div>
	
	
    <!-- #content-->

	<div class="Footerbgindex">
		
	
		<div id="footeradd" >
			<p class="FooterTitle"> Get in Touch! </p>
			<div class="FooterContent">
				<p class="Footeradd"> Envato Marketplace, Melbourne St, Sydney</p>
			
			</div>
			
        </div>
		<div id="poweredby">
			<p class="poweredby">Powered by <img src="../images/csc.png" width="25" height="14"></p>
        </div>
		
	
	</div>
	
</div>
<!-- #wrapper -->



</body>
</html>

