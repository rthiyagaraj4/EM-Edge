<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.result.ResultConstants"%>
<%@page import="portalrefimpl.common.CommonConstants"%>
<%@page import="portalrefimpl.result.viewtestresult.response.TestDetails"%>
<%@page import="portalrefimpl.schedule.viewappointment.response.AppointmentDetails"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.result.viewtestresult.svc.TestDetailsServiceInvoker"%>
<%@page import="portalrefimpl.result.viewtestresult.response.TestDetailsResponse"%>
<%@page import="portalrefimpl.result.viewtestresult.svc.TestDetailsSvcImpl"%>
<%@page import="portalrefimpl.result.viewtestresult.request.TestDetailsRequest"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.schedule.viewappointment.svc.AppointmentDetailsHelper"%>
<%@page import="portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse"%>
<%@page import="portalrefimpl.schedule.viewappointment.svc.AppointmentSvcImpl"%>
<%@page import="portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest"%>
<%@page import="portalrefimpl.homepage.response.PatientDetailsResponse"%>
<%@page import="portalrefimpl.result.detailedresult.svc.DetailedResultsSvcImpl"%>
<%@page import="portalrefimpl.result.detailedresult.response.DetailedResultsResponse"%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page import="java.util.Date"%>
<%@page import="portalrefimpl.result.detailedresult.request.DetailedResultsRequest"%>
<%@page import="portalrefimpl.result.detailedresult.svc.DetailedResultsServiceInvoker"%>
<%@page import="portalrefimpl.homepage.svc.HospitalDetailsServiceInvoker"%>
<%@page import="portalrefimpl.homepage.request.HospitalDetailsRequest"%>
<%@page import="portalrefimpl.common.response.BaseResponse"%>
<%@page import="portalrefimpl.common.serviceinvoker.ServiceInvoker"%>
<%@page import="portalrefimpl.homepage.svc.PatientDetailsServiceInvoker"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="portalrefimpl.homepage.request.PatientDetailsRequest"%>
<%@page import="portalrefimpl.homepage.svc.HomePageSvcImpl"%>
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
        height: 300px;
        width: 300px;
        margin: 10px auto;
        padding: 12px 0 12px 11px;
    }

    #calendar {
        border-radius: 3px 3px 3px 3px;
        border-style: solid;
        border-width: 1px;
    }

    .k-header {
        border-radius: 3px 3px 0 0;
    }

    #calendar .k-content {
        height: 208px;
        width:260px;
    }

    .exhibition {
        /* background: transparent url(../../content/web/calendar/exhibition.png) no-repeat 0 50%; */
        background-color : green;
        display: inline-block;
        width: 100%;
        height: 10px;
        vertical-align: middle;
        margin-right: 3px;
    }

    .party {
       /*  background: transparent url(../../content/web/calendar/party.png) no-repeat 0 50%; */
       background-color : blue;
        display: inline-block;
        width: 100%;
        height: 10px;
        vertical-align: middle;
        margin-right: 3px;
    }

    .cocktail {
        /* background: transparent url(../../content/web/calendar/cocktail.png) no-repeat 0 50%; */
        background-color : red;
        display: inline-block;
        width: 100%;
        height: 10px;
        vertical-align: middle;
        margin-right: 3px;
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

 <script>
     $(document).ready(function() {
         var today = new Date();

         $("#calendar").kendoCalendar({
             value: today,
             footer: "Today - #=kendo.toString(data, 'd') #"
         });
     });
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

	HomePageSvcImpl homePageSvcImpl = new HomePageSvcImpl();
	PatientDetailsRequest patientDetailsRequest = new PatientDetailsRequest();
	patientDetailsRequest.setPatientId(patientId);
	patientDetailsRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

	homePageSvcImpl.registerService(patientDetailsRequest);

	ServiceInvoker patientDetailsServiceInvoker = new PatientDetailsServiceInvoker();
	PatientDetailsResponse patientDetailsResponse = (PatientDetailsResponse) patientDetailsServiceInvoker
			.getDataThroughWebService(patientDetailsRequest);

	String patientName = patientDetailsResponse.getPatientDisplayName();
	String nationalId = patientDetailsResponse.getNationalId();
	if(nationalId == null){
		nationalId = "";
	}

	// store the patient name in the session
	session.setAttribute(PortalConstants.PATIENTNAME_SESSION_KEY,
			patientName);

	/* HospitalDetailsRequest hospitalDetailsRequest = new HospitalDetailsRequest();
	hospitalDetailsRequest.setPatientId(patientId);
	hospitalDetailsRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	hospitalDetailsRequest.setFacilityId("HS");
	ServiceInvoker hospitalDetailsServiceInvoker = new HospitalDetailsServiceInvoker();
	BaseResponse hospitalResponse = hospitalDetailsServiceInvoker
			.getDataThroughWebService(hospitalDetailsRequest); */

	AppointmentDetailsRequest appointmentDetailsRequest = new AppointmentDetailsRequest();
	appointmentDetailsRequest.setPatientId(patientId);
	appointmentDetailsRequest.setRecordCount(CommonConstants.HOMEPAGE_APPOINTMENTLIST_RECORDCOUNT);

	AppointmentSvcImpl appointSvc = new AppointmentSvcImpl();
	appointSvc.registerService(appointmentDetailsRequest);

	AppointmentDetailsResponse appointmentDetailsResponse = null;

	if ("N".equalsIgnoreCase(useWebService)) {
		appointmentDetailsResponse = appointSvc
				.getAppointmentDetails(appointmentDetailsRequest);
	} else if ("Y".equalsIgnoreCase(useWebService)) {
		// need to call the service as a web service
		appointmentDetailsResponse = AppointmentDetailsHelper
				.getAppointmentDetail(appointmentDetailsRequest);
	}
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
                	 Welcome, <%=patientName%>,
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
                  <li><a href="#">Contact</a></li>
                  <li><a href="#">Faq's</a></li>
                  <li><a href="#">Settings</a></li>
                  <li><a href="#">About Us</a></li>
                  <li><a href="./result/DetailedResult.jsp">My Results</a></li>
                  <li><a href="#">My Appointments</a></li>
                  <li class="menuselect">Home</li>
            </ul>
        </div>
        
    </div>
</div>
</div>
   <!-- #logo And Menu -->
   
<div class="line"></div>


	<div id="content">
     <!-- #Patient Banner-->
		<div id="PatientBanner">
        	<div class="row">
            	<div id="Patientphoto">
           	    <img src="../images/PatientProfile.png"> 
                </div>
                <div id="PatientProfile">
                	<p> <span class="contentfont">Welcome,</span>
                    <span class="contencap"><%=patientName%></span></p>
					<p> <span class="contenbold">Patient  ID :</span>
                    <span class="contentfont"><%=patientId%>, </span>
                     <span class="contenbold">NRIC :</span>
                    <span class="contentfont"><%=nationalId%></span></p>
                </div>
            </div> 
            
            
        </div>  
        
       <!-- #Patient Banner-->
	   <!-- #Content Area-->
     	<div id="contentbg">
     	</div>
	 <div id="contentArea">
      
      <div id="contentArearow">
       	<div class="cellindex searchindex">
       		<div id="BooknewAppsearchindex">
				<div class="BookAppTitlehomepg">
					Book an appointment
				</div>
       			<div class="bookcontent">
       				<div id="Apptime">
			           <div id="special-days">
			               <div id="calendar" style="width: 260px;"></div>
			           </div>
            			<div class="ApptitleReschedule">Preferred time</div>
						<select class="textboxtimeReschedule"  >
							<option>Select time</option>
							<option>10.30</option>
							<option>11.30</option>
							<option>1.30</option>
							<option>2.30</option>
							<option>3.30</option>
							<option>4.30</option>
							<option>5.30</option>
							<option>6.30</option>
							<option>7.30</option>
							<option>8.30</option>
						</select>
						<span >to</span>
						<select class="textboxtimeReschedule" >
							<option>Select time</option>
							<option>10.30</option>
							<option>11.30</option>
							<option>1.30</option>
							<option>2.30</option>
							<option>3.30</option>
							<option>4.30</option>
							<option>5.30</option>
							<option>6.30</option>
							<option>7.30</option>
							<option>8.30</option>
						</select>
						<div class="ApptitleReschedule">Speciality</div>
						<select class="textbox"  >
							<option>---All---</option>
							<option>Cardiology</option>
							<option>Dermatology</option>
							<option>Endocrinology</option>
							<option>Gastrology</option>
							<option>General medicine</option>
							<option>Gastrology</option>
							<option>Endocrinology</option>
							<option>Gynaecology</option>
							<option>Neurology</option>
							<option>Orthopedics</option>
						</select>
					</div>
				</div>
				<div class="centeralign">
					<span><a href="#"  class="PPbtn">Book an appointment</a></span>
				</div>
			</div>
		</div>
        
        <div id="divider"></div>
        
        <div id="UpcomingApp">
        	<div class="Title">            upcoming appointments            </div>
        	<div id="HomepageBox">
        	<%
        	        		ErrorInfo errorInfo = appointmentDetailsResponse.getErrorInfo();
        	        		int errorCode = errorInfo.getErrorCode();
        	        		String errorMessage = errorInfo.getErrorMessage();
        	        		if (ErrorInfo.SUCCESS_CODE != errorCode) {
        	        	%>
        	 <span style="margin-left:5px; margin-top:50px;color:#ff0000;font-size:12px;font-weight:bold;">
             <%
             	out.println(errorMessage);
             %>
              </span>
              <%
              	} else {
              	%>
              	
              	<%	
              		List<AppointmentDetails> appointmentDetailsList = appointmentDetailsResponse
              				.getAppointmentDetailsList();
              		String apptYearAndMonth = "";
              		int apptDateInt = 0;
              		String apptDay = "";
              		String practitioner = "";
              		String speciality = "";
              		String apptStartTime = "";
              		String apptEndTime = "";
              		for(AppointmentDetails appointmentDetails : appointmentDetailsList){
              			apptYearAndMonth = appointmentDetails.getAppointmentMonthAndYear();
              			apptDateInt = appointmentDetails.getAppointmentDateAsInt();
              			apptDay = appointmentDetails.getAppointmentDay();
              			practitioner = appointmentDetails.getPractitioner();
              			speciality = appointmentDetails.getApptSpeciality();
              			apptStartTime = appointmentDetails.getApptStartTimeAsString();
              			apptEndTime = appointmentDetails.getApptEndTimeAsString();
              %>
                
                      <!-- Stripbox-->
                    <div id="stripbox">
                        <div class="row">
                             <!-- Stripicon-->
                            <div id="StripSpaceA">
                                <div id="StripIcon">
                                    <div id="StripIconHeader">
                                        <%=apptYearAndMonth %>
                                    </div>
                                    <div id="StripDate">
                                    <%=apptDateInt %>
                                    </div>
                                     <div id="Stripday">
                                    <%=apptDay %>
                                    </div>
                                </div>
                            </div>
                             <!-- Stripcontent-->
                            <div id="StripSpaceB">
                                <p><span class="AppointmentNewDoctor"><%=practitioner %></span><span class="AppointmentnewSPL">- <%=speciality %></span><p>
                                <p class="contenbold"><%=apptStartTime %> - <%=apptEndTime %></p>
                                
                                
                            </div>
                            
                        </div>
                    </div>
                  <!-- Stripbox-->   
                  
               <%
              		}// end of for loop
               %>       
                
            <%
            	} // end of else loop
            %>    
           </div>     
            <div>
            <span><a href="#"  class="PPbtn">Show All</a></span>
         	</div>
         </div>
                 
       	<div id="divider"></div>
                
         <%
                         	TestDetailsRequest testDetailsRequest = new TestDetailsRequest();
                         	testDetailsRequest.setPatientId(patientId);
              				testDetailsRequest.setRecordCount(CommonConstants.HOMEPAGE_TESTRESULTLIST_RECORDCOUNT);
		
                         	TestDetailsSvcImpl testDetailSvc = new TestDetailsSvcImpl();
                         	testDetailSvc.registerService(testDetailsRequest);

                         	TestDetailsResponse testDetailsResponse = null;

                         	if ("N".equalsIgnoreCase(useWebService)) {
                         		testDetailsResponse = testDetailSvc
                         				.getTestDetails(testDetailsRequest);
                         	} else if ("Y".equalsIgnoreCase(useWebService)) {
                         		ServiceInvoker testDetailsServiceInvoker = new TestDetailsServiceInvoker();
                         		// need to call the service as a web service
                         		testDetailsResponse = (TestDetailsResponse) testDetailsServiceInvoker
                         				.getDataThroughWebService(testDetailsRequest);
                         	}
                         %>       
        <div id="Recentresult">
        	<div class="Title">            recent results            </div>
        	<div id="HomepageBox">
        	<%
        	        		ErrorInfo testDetailsErrorInfo = testDetailsResponse.getErrorInfo();
        	        		errorCode = testDetailsErrorInfo.getErrorCode();
        	        		errorMessage = testDetailsErrorInfo.getErrorMessage();
        	        		if (ErrorInfo.SUCCESS_CODE != errorCode) {
        	        	%>
           	 <span class="loginerror">
                <%
                	out.println(errorMessage);
                %>
                 </span>
                 <%
                 	} else {
                 %>
        	
	
    		<%
    		List<TestDetails> testDetailsList = testDetailsResponse.getTestDetailsList();
    		String order = "";
    		String orderNumber = "";
    		String practName = "";
    		String orderDateString = "";
    		String imageStyle = "";
    		for(TestDetails testDetails : testDetailsList){
    			order = testDetails.getOrder();
    			orderNumber = testDetails.getOrderNo();
    			practName = testDetails.getPractName();
    			orderDateString = testDetails.getOrderDateString();
    			
    			imageStyle = "Resultrio";
    			if(ResultConstants.DETAILEDRESULTS_ORDERCATEGORY_LAB_MEDIUM_KEY.equalsIgnoreCase(testDetails.getResultType())){
    				imageStyle = "Resultlab";
    			}
    		%>    	
            <!-- Stripbox-->
                <div id="stripbox">
                	<div class="row">
                    	 <!-- Stripicon-->
                        <div id="StripSpaceA">
                            <div id="<%=imageStyle%>">
                           		
                            </div>
                        </div>
                         <!-- Stripcontent-->
                      <div id="StripSpaceB">
                    		<p><span class="AppointmentNewDoctor"><%=order %></span><span class="contenbold"> by <%=practName %></span><p>
                            <p> <span class="contentfont">Order No  : <%=orderNumber %>, </span>  <img src="../images/PDF.png" width="16" height="16"> <img src="../images/print.png" width="16" height="16"></p>
                            <p> <span class="ResultDate"><%=orderDateString %></span></p>
                            
                      </div>
                        
                    </div>
                </div>
              <!-- Stripbox-->  
            <%
    		} // end of for loop
            %>
            <%
                     } // end of else loop
             %>
            </div>
         <div>
         <span><a href="./result/DetailedResult.jsp"  class="PPbtn">Show All</a></span>
         </div>
        </div>
            
        
       </div> 
       </div>
       </div>
       <!-- #Content Area-->
        
	</div>
    <!-- #content-->
<div class="Footerbg">
<div class="row">
		<div id="footeradd">
        <p class="FooterTitle"> Get in Touch! </p>
<p class="Footeradd"> Envato Marketplace, Melbourne St, Sydney. TF - 123456, (+00) 0123-456-798, Contact@icarehospital.com, www.icarehospital.com </p>
        
        </div>

        <div id="poweredby">
        <p class="poweredby">Powered by <img src="../images/csc.png" width="25" height="14"></p>
        </div>
</div>
</div>
</div>
<!-- #wrapper -->



</body>
</html>

