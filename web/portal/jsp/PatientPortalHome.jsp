<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.result.viewtestresult.svc.TestDetailsServiceInvoker"%>
<%@page import="portalrefimpl.schedule.viewappointment.svc.AppointmentDetailsHelper"%>
<%@page import="portalrefimpl.result.viewtestresult.response.TestDetails"%>
<%@page import="portalrefimpl.common.serviceinvoker.ServiceInvoker"%>
<%@page import="portalrefimpl.result.viewtestresult.response.TestDetailsResponse"%>
<%@page import="portalrefimpl.result.viewtestresult.svc.TestDetailsSvcImpl"%>
<%@page import="portalrefimpl.result.viewtestresult.request.TestDetailsRequest"%>
<%@page import="portalrefimpl.schedule.viewappointment.response.AppointmentDetails"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.schedule.viewappointment.response.AppointmentDetailsResponse"%>
<%@page import="portalrefimpl.schedule.viewappointment.svc.AppointmentSvcImpl"%>
<%@page import="portalrefimpl.schedule.viewappointment.request.AppointmentDetailsRequest"%>
<%@page import="portalrefimpl.homepage.HomePageInfoResponse"%>
<%@page import="portalrefimpl.homepage.HomePageInfoHandler"%>
<%@page import="portalrefimpl.homepage.HomePageInfoRequest"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Patient Portal</title>

<style>
.divheader {
	height: 74px;
	width: 100%;
	background: #ffffff;
}

.header {
	height: 74px;
	width: 188px;
	bottom-border: #004657 3px solid;
	background: #0a87b0; /* Old browsers */
	/* IE9 SVG, needs conditional override of 'filter' to 'none' */
	background:
		url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIxMDAlIiB5Mj0iMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzBhODdiMCIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiMwODYzN2MiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
	background: -moz-linear-gradient(left, #0a87b0 0%, #08637c 100%);
	/* FF3.6+ */
	background: -webkit-gradient(linear, left top, right top, color-stop(0%, #0a87b0),
		color-stop(100%, #08637c) ); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(left, #0a87b0 0%, #08637c 100%);
	/* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(left, #0a87b0 0%, #08637c 100%);
	/* Opera 11.10+ */
	background: -ms-linear-gradient(left, #0a87b0 0%, #08637c 100%);
	/* IE10+ */
	background: linear-gradient(to right, #0a87b0 0%, #08637c 100%);
	/* W3C */
	filter: progid:DXImageTransform.Microsoft.gradient(           startColorstr='#0a87b0',
		endColorstr='#08637c', GradientType=1 ); /* IE6-8 */
}

.centerheader {
	height: 74px;
	width: 990px;
	bottom-border: #175766 3px solid;
	background: #0a87b0; /* Old browsers */
	/* IE9 SVG, needs conditional override of 'filter' to 'none' */
	background:
		url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIxMDAlIiB5Mj0iMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIwJSIgc3RvcC1jb2xvcj0iIzBhODdiMCIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiMwODYzN2MiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
	background: -moz-linear-gradient(left, #0a87b0 0%, #08637c 100%);
	/* FF3.6+ */
	background: -webkit-gradient(linear, left top, right top, color-stop(0%, #0a87b0),
		color-stop(100%, #08637c) ); /* Chrome,Safari4+ */
	background: -webkit-linear-gradient(left, #0a87b0 0%, #08637c 100%);
	/* Chrome10+,Safari5.1+ */
	background: -o-linear-gradient(left, #0a87b0 0%, #08637c 100%);
	/* Opera 11.10+ */
	background: -ms-linear-gradient(left, #0a87b0 0%, #08637c 100%);
	/* IE10+ */
	background: linear-gradient(to right, #0a87b0 0%, #08637c 100%);
	/* W3C */
	filter: progid:DXImageTransform.Microsoft.gradient(        startColorstr='#0a87b0',
		endColorstr='#08637c', GradientType=1 ); /* IE6-8 */
}

.imgIcon {
	height: 65px;
	width: 65px;
}

.homeIcon {
	height: 24px;
	width: 24px;
}

.contentarea {
	width: 100%;
	height: 509px;
	/* background: #f1f1f1; */
}

.footerleft {
	width: 188px;
	height: 65px;
	background-color: #606060;
}

.contentleft {
	width: 188px;
	height: 509px;
	background-color: #f1f1f1;
}

.footer {
	width: 990px;
	height: 65px;
	background-color: #6e6e6e;
}

.dvfooter {
	width: 100%;
	height: 65px;
}

.contentcenter {
	width: 990px;
	height: 509px;
	background-color: #ffffff;
}

.contentareabox {
	width: 982px;
	/* height:609px; */
	border: #a4a4a4 1px solid;
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	border-bottom-left-radius: 10px;
	border-bottom-right-radius: 10px;
	background-color: #ffffff;
	padding-left: 4px;
}

.menuheader {
	border-top-left-radius: 10px;
	border-top-right-radius: 10px;
	height: 45px;
	border: #6e6e6e 1px solid;
	background-color: #f1f1f1;
}

.menucontent {
	height: 424px;
}

.menuitemstyle {
	padding: 5px;
	font-family: Arial;
	font-size: 14px;
	color: #000000;
}

.divmaincontent {
	height: 125px;
	padding-left: 10px;
	padding-right: 10px;
}

.div {
	height: 429px;
	width: 982px;
}

.div1 {
	width: 982px;
}

.nextappointmentsdiv {
	position: relative; 
	float: left;
	width: 330px;
	
}

.resultsdiv {
	float: right;
	width: 330px;
	
}
.appointheader{
height:30px;
background-color: #1d758b;
box-shadow: 3px 3px 3px #b8b8b8; 
border: #bacfd5 1px  solid;
border-top-left-radius: 5px;
border-top-right-radius: 5px;

}
.appointheaderstyle
{
font: Arial;
font-size: 12px;
font-weight: bold;
color: #ffffff;

}
.content
{
height:210px;
width:60%;
background-color: #ffffff;



}
.contentstyle{
width:100%;
height:70px;


}
.maincontent{

width:100%;


}
.contentbottom
{
height:65px;
width:60%;
border:#bacfd5 1px solid;

}
.contentstyle
{
border:#bacfd5 1px solid;
}
.newappoint{

border-radius:3px;
background :-webkit-gradient(linear, left top, left bottom, from( #37b8d0  ), to( #3fa4b6 )); /* Saf4+, Chrome */
    background :-webkit-linear-gradient( #37b8d0 , #3fa4b6 ); /* Chrome 10+, Saf5.1+ */
   background :-moz-linear-gradient( #37b8d0 , #3fa4b6 ); /* FF3.6 */
border : 1px solid #006c7f;
padding:2px;


}
.newappointstyle{
font :Arial;
font-size: 11px;
font-weight: bold;
color: #ffffff;
}

.buttonStyle{
font-family: Arial;
font-size : 11px;
font-style : bold;
color : #ffffff;
background-color: #37b8d0;
border : 1px solid #006c7f;
padding: 2px;
border-radius:3px;

}

.apptPractNameStyle{
font: Arial;
font-size: 14px;
color: #0a84a2;
margin-left:5px;
}

.apptSpecialityStyle{
font: Arial;
font-size: 12px;
color: #0a84a2 ;
}

.apptTimeStyle{
font: Arial;
font-size: 12px;
color: #5e5e5e;
margin-left:5px;
}

.apptDateStyle{
font: Arial;
font-size: 24px;
color: #e67418;
font-weight: bold;
}

.apptWeekDayStyle{
font: Arial;
font-size: 12px;
color: #e67418;
}

.apptMonthYearStyle{
font: Arial;
font-size: 12px;
color: #e67418;
}


.apptPractNameNormalStyle{
font: Arial;
font-size: 14px;
color: #5e5e5e;
margin-left:5px;
}

.apptSpecialityNormalStyle{
font: Arial;
font-size: 12px;
color: #5e5e5e ;
}

.apptTimeNormalStyle{
font: Arial;
font-size: 12px;
color: #5e5e5e ;
margin-left:5px;
}

.apptDateNormalStyle{
font: Arial;
font-size: 24px;
color: #5e5e5e;
font-weight: bold;
}

.apptWeekDayNormalStyle{
font: Arial;
font-size: 12px;
color: #5e5e5e;
}

.apptMonthYearNormalStyle{
font: Arial;
font-size: 12px;
color: #5e5e5e;
}


.resultCategoryStyle{
font: Arial;
font-size: 12px;
color: #e67418;
font-style: bold;
}

.resultDateStyle{
font: Arial;
font-size: 12px;
color: #e67418;
}

.resultCategoryNormalStyle{
font: Arial;
font-size: 12px;
color: #0a84a2;
font-style: bold;
}

.resultDateNormalStyle{
font: Arial;
font-size: 12px;
color: #5e5e5e;
}

</style>

</head>
<body>

<%

	String useWebService = request.getParameter("useWebService");
	if (useWebService == null || useWebService.trim().equals("")) {
		useWebService = (String)getServletConfig().getServletContext().getAttribute("useWebService");
		if (useWebService == null || useWebService.trim().equals("")){
			useWebService = "N";	
		}
	}

	String patientId = request.getParameter("patientId");
	if (patientId == null) {
		patientId = (String)getServletConfig().getServletContext().getAttribute("patientId");
		if(patientId == null){
			patientId = "";	
		}
	}
	
	final int NUMROWS = 3;
	
	HomePageInfoRequest homePageInfoRequest = new HomePageInfoRequest();
	homePageInfoRequest.setPatientId(patientId);
	
	HomePageInfoHandler handler = new HomePageInfoHandler();
	HomePageInfoResponse homePageInfoResponse = handler.getHomePageInfo(homePageInfoRequest);
	
	// TODO
	// need to have logic to check for ErrorInfo and then set error message accordingly
	 
	String completePatientName = homePageInfoResponse.getCompletePatientName();
	String patientName = homePageInfoResponse.getPatientName();
	String sex = homePageInfoResponse.getSex();
	String age = homePageInfoResponse.getPatientAge();
	String nricId = homePageInfoResponse.getNricId();
	if(nricId == null){
		nricId = "";
	}
	
%>

	<div class="divheader">
		<table border="0" style="width: 100%; height: auto" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<div class="header"></div>
				</td>

				<td>
					<div class="centerheader">
						<table border="0" style="width: 100%; height: auto"
							cellpadding="0" cellspacing="0">
							<tr>
								<td style="width: 4px;">&nbsp;</td>
								<td style="width: 65px;">
									<table border="0" style="width: 100%; height: auto"
										cellpadding="0" cellspacing="0">
										<tr style="width: 65px; height: 65px;">
											<td><img
												src="../images/Logo.png"
												style="margin-top: 4px; margin-left: 4px; margin-right: 10px;"
												class="imgIcon"></img></td>
										</tr>
									</table>
								</td>
								<td style="width: 917px; height: 74px;">
									<table border="0" style="width: 100%; height: auto"
										cellpadding="0" cellspacing="0">

										<tr style="height: 40%;">
											<td><span
												style="font-family: Arial; font-size: 12px; color: #ffffff; font-weight: bold;">PATIENT
													ID : <%=patientId %></span></td>
										</tr>
										<tr style="height: 40%;">
											<td><span
												style="font-family: Arial; font-size: 12px; color: #ffffff; font-weight: bold;">NRIC
													ID : <%=nricId %></span></td>
										</tr>
										<tr style="height: 20%;">
											<td><span
												style="font-family: Arial; font-size: 11px; color: #ffffff; font-style: italic;"><%=patientName %>, <%=sex %>, <%=age %></span></td>
										</tr>

									</table>
								</td>
								<td style="width: 4px;">&nbsp;</td>
							</tr>
						</table>
					</div>
				</td>

				<td>
					<div class="header"></div>
				</td>
			</tr>
		</table>
	</div>

	<div class="contentarea">
		<table border="0" style="width: 100%; height: 100%" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<div class="contentleft"></div>
				</td>
				<td>
					<div class="contentcenter">
						<table border="0" style="width: 990px; height: 509px"
							cellpadding="0" cellspacing="0">
							<tr style="width: 990px; height: 10px;">
								<td>&nbsp;</td>
							</tr>
							<tr style="width: 990px; height: 479px;">
								<td>
									<table border="0" style="width: 990px; height: 479px;"
										cellpadding="0" cellspacing="0">
										<tr>
											<td class="contentareabox" align="center">
												<div class="menuheader">
													<table border="0" style="width: 982px; height: 45px;"
														cellpadding="0" cellspacing="0">
														<tr>
															<td align="center" style="width: 100px; height: 45px;">
																<table border="0" style="width: 100px; height: 45px;"
																	cellpadding="0" cellspacing="0">
																	<tr>
																		<td align="center" style="width: 34px; height: 45px;"><img
																			src="../images/Home.png"
																			style="margin-top: 5px; margin-bottom: 5px; margin-right: 5px; margin-left: 5px;"
																			class="homeIcon"></img></td>

																		<td align="left" style="width: 66px; height: 45px;"><span
																			class="menuitemstyle">Home</span></td>
																	</tr>
																</table>
															</td>
															<td align="center"
																style="width: 1px; height: 45px; background-color: #c8c8c8">&nbsp;</td>
															<td align="center" style="width: 150px; height: 45px;">
																<table border="0" style="width: 150px; height: 45px;"
																	cellpadding="0" cellspacing="0">
																	<tr>
																		<td align="center" style="width: 34px; height: 45px;"><img
																			src="../images/Appointments.png"
																			style="margin-top: 5px; margin-bottom: 5px; margin-right: 5px; margin-left: 5px;"
																			class="homeIcon"></img></td>

																		<td align="left" style="width: 116px; height: 45px;"><span
																			class="menuitemstyle">Appointments</span></td>
																	</tr>
																</table>
															</td>
															<td align="center"
																style="width: 1px; height: 45px; background-color: #c8c8c8">&nbsp;</td>
															<td align="center" style="width: 120px; height: 45px;">
																<table border="0" style="width: 120px; height: 45px;"
																	cellpadding="0" cellspacing="0">
																	<tr>
																		<td align="center" style="width: 34px; height: 45px;"><img
																			src="../images/Results.png"
																			style="margin-top: 5px; margin-bottom: 5px; margin-right: 5px; margin-left: 5px;"
																			class="homeIcon"></img></td>

																		<td align="left" style="width: 86px; height: 45px;"><span
																			class="menuitemstyle">Results</span></td>
																	</tr>
																</table>
															</td>
															<td align="center"
																style="width: 1px; height: 45px; background-color: #c8c8c8">&nbsp;</td>
															<td align="center" style="width: 120px; height: 45px;">
																<table border="0" style="width: 120px; height: 45px;"
																	cellpadding="0" cellspacing="0">
																	<tr>
																		<td align="center" style="width: 34px; height: 45px;"><img
																			src="../images/Settings.png"
																			style="margin-top: 5px; margin-bottom: 5px; margin-right: 5px; margin-left: 5px;"
																			class="homeIcon"></img></td>

																		<td align="left" style="width: 86px; height: 45px;"><span
																			class="menuitemstyle">Settings</span></td>
																	</tr>
																</table>
															</td>
															<td align="center"
																style="width: 1px; height: 45px; background-color: #c8c8c8">&nbsp;</td>
															<td align="center" style="width: 427px; height: 45px;">&nbsp;</td>
															<td align="center"
																style="width: 1px; height: 45px; background-color: #c8c8c8">&nbsp;</td>
															<td align="center" style="width: 120px; height: 45px;">
																<table border="0" style="width: 120px; height: 45px;"
																	cellpadding="0" cellspacing="0">
																	<tr>
																		<td align="center" style="width: 34px; height: 45px;"><img
																			src="D:/WebApplicationWorkspace/sample/WebContent/images/Exit.png"
																			style="margin-top: 5px; margin-bottom: 5px; margin-right: 5px; margin-left: 5px;"
																			class="homeIcon"></img></td>

																		<td align="left" style="width: 86px; height: 45px;"><span
																			class="menuitemstyle">Exit</span></td>
																	</tr>
																</table>
															</td>

														</tr>
													</table>
												</div>
												
												<div class="menucontent">
													<div class="divmaincontent">

														<table border="0" style="width: 100%; height: 100%;"
															cellpadding="0" cellspacing="0">
															<tr>
																<td style="width: 100%; height: 49%;">
																	<table border="0" style="width: 100%; height: 100%;"
																		cellpadding="0" cellspacing="0">
																		<tr style="width: 100%; height: 50%;">
																			<td align="left">
																				<span
																				style="font-family: Arial; font-size: 11px; color: #1d738b; font-weight: bold; font-style: italic;">Hi
																					<%=completePatientName %> !
																				</span>
																			</td>
																		</tr>
																		<tr style="width: 100%; height: 50%;">
																			<td align="left">
																				<span
																				style="font-family: Arial; font-size: 11px; color: #5d5b5b;">Welcome
																					to iCare Hospital Patient Portal,Your Patient ID
																					<%=patientId %> and NRIC ID <%=nricId %>,
																				</span>
																			</td>
																		</tr>
																	</table>

																</td>
															</tr>
															<tr>
																<td style="width: 100%; height: 2%;">................................................................................................................................................................................................................................................
																</td>
															</tr>
															<tr>
																<td style="width: 100%; height: 49%;">
																	<table border="0" style="width: 100%; height: 100%;"
																		cellpadding="0" cellspacing="0">
																		<tr style="width: 100%; height: 50%;">
																			<td align="left">
																				<span
																				style="font-family: Arial; font-size: 14px; color: #000000; font-weight: bold;">Some
																					of the many things you can do in the patient portal
																					are..
																				</span>
																			</td>
																		</tr>
																		<tr style="width: 100%; height: 50%;">
																			<td align="left"><span
																				style="font-family: Arial; font-size: 11px; color: #5d5b5b;">Manage
																					your appointments,view your lab and view your
																					radiology results</span></td>
																		</tr>
																	</table>

																</td>
															</tr>

														</table>
													</div>
													
													<div id="verticalspacediv" style="padding-bottom: 10px;">
													</div>
													
													<div id="leftdiv" class="div" style="width:46%;padding-top: 10px;padding-left: 10px;padding-right:5px;padding-bottom:10px;float: left;">
														<table style="width: 100%; height: 57%;border: 1px solid #bacfd5;border-top-left-radius: 5px;border-top-right-radius: 5px;border-bottom-left-radius:5px;border-bottom-right-radius:5px;"
													cellpadding="0" cellspacing="0" align="left">
															<tr height="15%">
																<td  valign="top" align="left">
																
																	<table class = "appointheader" valign="top" border="1" style="width: 100%; height: 100%;"
														cellpadding="0" cellspacing="0" >
																		<tr>
																			<td  align="left" style="padding-left: 10px;"> 
																			<span class="appointheaderstyle" valign = "middle">Your Next Appointments</span>
																			</td>
																		</tr>
																	</table>		
																</td>
															</tr>
		<%
	AppointmentDetailsRequest appointmentDetailsRequest = new AppointmentDetailsRequest();
	appointmentDetailsRequest.setPatientId(patientId);

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
	if (appointmentDetailsResponse == null) {
%>
										<tr valign="top" align="center">
											<td valign="top" align="center">
												<table width="100%">
													<tr>
														<td>
															<span style="font: Arial;font-size: 12px;">Could not obtain appointment details</span> 
														</td>
													
													</tr>
												</table>	
											</td>
										</tr>

<%
	}
	else{
		ErrorInfo errorInfo = appointmentDetailsResponse.getErrorInfo();
		int errorCode = errorInfo.getErrorCode();
		String errorMessage = errorInfo.getErrorMessage();
		if (ErrorInfo.SUCCESS_CODE != errorCode
				&& (errorMessage != null && errorMessage.trim().equals(""))) {
%>

												<tr valign="top" align="center">
													<td valign="top" align="center">
														<table width="100%">
															<tr>
																<td>
																	<span style="font: Arial;font-size: 12px;">Error while obtaining appointment details, Error Message = <%=errorMessage%></span> 
																</td>
															
															</tr>
														</table>	
													</td>
												</tr>
									<%
										
										}else{
											
										
										List<AppointmentDetails> appointmentDetailsList = appointmentDetailsResponse
												.getAppointmentDetailsList();
										if (appointmentDetailsList == null
												|| appointmentDetailsList.isEmpty()) {
									%>
									
												<tr valign="top" align="center">
													<td valign="top" align="center">
													<table  width="100%">
														<tr>
															<td>
															<span style="font: Arial;font-size: 12px;">Could not obtain appointment details</span> 
															</td>
														
														</tr>
													</table>
													</td>
												</tr>			
											<%
	
												}else{
											
										String appointmentDate = "";
										String practitioner = "";
										String speciality = "";
										String startTime = "";
										String endTime = "";
										int counter = 0;
										
										String dateStyle = "";
										String weekDayStyle = "";
										String monthYearStyle = "";
										String practNameStyle = "";
										String specialityStyle = "";
										String timeStyle = "";
										
										for (AppointmentDetails appointmentDetails : appointmentDetailsList) {
											if(counter >= NUMROWS){
												break;
											}
											counter++;
											
											dateStyle = "apptDateNormalStyle";
											weekDayStyle = "apptWeekDayNormalStyle";
											monthYearStyle = "apptMonthYearNormalStyle";
											practNameStyle = "apptPractNameNormalStyle";
											specialityStyle = "apptSpecialityNormalStyle";
											timeStyle = "apptTimeNormalStyle";
											
											if(counter == 1){
												dateStyle = "apptDateStyle";
												weekDayStyle = "apptWeekDayStyle";
												monthYearStyle = "apptMonthYearStyle";
												practNameStyle = "apptPractNameStyle";
												specialityStyle = "apptSpecialityStyle";
												timeStyle = "apptTimeStyle";
											}
											
											appointmentDate = appointmentDetails
													.getAppointmentDateAsString();
											practitioner = appointmentDetails.getPractitioner();
											speciality = appointmentDetails.getApptSpeciality();
											startTime = appointmentDetails.getApptStartTimeAsString();
											endTime = appointmentDetails.getApptEndTimeAsString();
											%>
												<tr>
													<td align="left">
													<table cellpadding=0 cellspacing=0  width="100%">
														<tr>
															<td  style ="width:25%;padding-left : 5px;" align="left"> 
																<table border="0" style="width: 100%;" cellpadding="0"
																cellspacing="0">
																	<tr>
																		<td style="height: 40%;" align = "center">
																			<span class="<%=dateStyle %>" ><%=appointmentDetails.getAppointmentDateAsInt() %></span>
																		</td>
																	</tr>
																	<tr>
																		<td style="height: 25%;" align = "center">
																			<span class="<%=weekDayStyle %>" ><%=appointmentDetails.getAppointmentDay() %></span>
																		</td>
																	</tr>
																	<tr>
																		<td style="height: 35%;" align = "center">
																			<span class="<%=monthYearStyle %>" ><%=appointmentDetails.getAppointmentMonthAndYear() %></span>
																		</td>
																	</tr>
																 </table>
															</td>
															<td  style ="width:80%;padding-left : 5px;" align="left">
																<table>
																	<tr>
																		<td height="50%"> 
																			<span class="<%=practNameStyle %>" ><%=practitioner%> -</span>
																			<span class="<%=specialityStyle %>" ><%=speciality%></span>
																		</td>
																	</tr>
																	<tr>
																		<td height="50%"> <span class="<%=timeStyle %>" ><%=startTime%> - <%=endTime%></span>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
													</table>
													</td>
												</tr>	
												<%
															}
														}
													}
	}
												%>
															
															
															<tr height="20%" valign="center">
																<td style="padding-right: 10px;" align="right">
																	<table>
																		<tr>
																			<td align="right">
																				<input type="button" class="buttonStyle" value="New appointment"/>
																			</td>
																			<td>
																				<input type="button" class="buttonStyle" value="View more appointments"/>
																			</td>
																		</tr>
																	</table>
																</td>
															</tr>
														</table>
														
													</div>					
														
													<div id="rightdiv" class="div" style="width:50%;padding-top: 10px;padding-left: 5px;padding-right:10px;padding-bottom:10px;float: right;">
														<table style="width: 100%; height: 57%;border: 1px solid #bacfd5;border-top-left-radius: 5px;border-top-right-radius: 5px;border-bottom-left-radius:5px;border-bottom-right-radius:5px;"
													cellpadding="0" cellspacing="0" align="left">
															<tr height="15%">
																<td  valign="top" align="left">
																
																	<table class = "appointheader" valign="top" border="1" style="width: 100%; height: 100%;"
														cellpadding="0" cellspacing="0" >
																		<tr>
																			<td  align="left" style="padding-left: 10px;"> 
																				<span class="appointheaderstyle" valign = "middle">Your Test Results</span>
																			</td>
																		</tr>
																	</table>		
																</td>
															</tr>
															
															<%
												TestDetailsRequest testDetailsRequest = new TestDetailsRequest();
												testDetailsRequest.setPatientId(patientId);
											
												TestDetailsSvcImpl testDetailSvc = new TestDetailsSvcImpl();
												testDetailSvc.registerService(testDetailsRequest);
											
												TestDetailsResponse testDetailsResponse = null;
											
												if ("N".equalsIgnoreCase(useWebService)) {
													testDetailsResponse = testDetailSvc
															.getTestDetails(testDetailsRequest);
												} else if ("Y".equalsIgnoreCase(useWebService)) {
													ServiceInvoker testDetailsServiceInvoker = new TestDetailsServiceInvoker();
													// need to call the service as a web service
													testDetailsResponse = (TestDetailsResponse)testDetailsServiceInvoker
															.getDataThroughWebService(testDetailsRequest);
												}
												
												if (testDetailsResponse == null) {
												%>
												
												<tr  valign="top" align="center">
													<td  valign="top" align="center"> 
														<table width="100%">
															<tr>
															<td>
															<span style="font: Arial;font-size: 12px;">Could not obtain test results</span> 
															</td>
														
															</tr>
														</table>
													</td>	
												</tr>			
												
												<%
		
											} else{
											
											ErrorInfo errorInfo = testDetailsResponse.getErrorInfo();
											int errorCode = errorInfo.getErrorCode();
											String errorMessage = errorInfo.getErrorMessage();
											if (ErrorInfo.SUCCESS_CODE != errorCode
													&& (errorMessage != null && errorMessage.trim().equals(""))) {
											%>
												<tr  valign="top" align="center">
													<td  valign="top" align="center">
														<table  width="100%">
														<tr>
														<td>
														<span style="font: Arial;font-size: 12px;">Error while obtaining test details, Error Message = <%=errorMessage%></span> 
														</td>
		
														</tr>
														</table>	
													</td>
												</tr>	
												
												<%
													
												}else{
													List<TestDetails> testDetailsList = testDetailsResponse
															.getTestDetailsList();
													if (testDetailsList == null
															|| testDetailsList.isEmpty()) {
												%>
												<tr  valign="top" align="center">
													<td  valign="top" align="center">
														<table  width="100%">
															<tr>
															<td>
															<span style="font: Arial;font-size: 12px;">Could not obtain test details</span> 
															</td>
															
															</tr>
														</table>
													</td>
												</tr>	
												<%
												
												} else{
											%>
											
											<%
												//local vars used for processing
												String orderNo = null;
												String location = null;
												String practId = null;
												String practName = null;
												String status = null;
												String order = null;
												Date orderDate = null;
												String resultType = null;
												
												String orderDateStr = null;
												String orderCategoryStyle = "";
												String orderDateStyle = "";
												
												int counter = 0;
												for (TestDetails testDetail : testDetailsList) {
													if(counter >= NUMROWS){
														break;
													}
													counter++;
													
													orderCategoryStyle = "resultCategoryNormalStyle";
													orderDateStyle = "resultDateNormalStyle";
													if(counter == 1){
														orderCategoryStyle = "resultCategoryStyle";
														orderDateStyle = "resultDateStyle";
													}
													
													orderNo = testDetail.getOrderNo();
													location = testDetail.getLocation();
													resultType = testDetail.getResultType();
													order = testDetail.getOrder();
													orderDate = testDetail.getOrderDate();
													practName = testDetail.getPractName();
													practId = testDetail.getPractId();
													status = testDetail.getStatus();
													
													orderDateStr = testDetail.getOrderDateString();
											%>
											<tr>
												<td>
													<table  width="100%">
														<tr>
															<td width="40%" align="left" style="padding-left:15px;" >
																<table>
																	<tr>
																		<td>
																			<span class="<%=orderCategoryStyle %>" ><%=order %></span>
																		</td>
																	</tr>
																	<tr>
																		<td>
																			<span class="<%=orderDateStyle %>" ><%=orderDateStr %></span>
																		</td>
																	</tr>	
																</table> 
															</td>
															<td  width="60%" align="right" style="padding-right: 20px;">
																<table>
																	<tr>
																		<td> <input type="button" class="buttonStyle" value="View Result"/>
																		</td>
																	</tr>
																</table>
															</td>
														</tr>
											
													</table>
												</td>
											</tr>
											
											<%
														}
													}
												}
											}
											
											%>
											
												
															<tr height="20%">
																<td valign="center" align="right">
																	<table>
																		<tr>
																			<td align="right" style="padding-right: 10px;">
																				<input type="button" class="buttonStyle" value="View more results"/>
																			</td>
																		</tr>
																	</table>
																</td>
															</tr>
															
															
														</table>
													
													
													</div>
																		
													
												</div>
												
												
												
											</td>	
										</tr>	
									</table>
								</td>
							</tr>
						</table>
					</div>	
				</td>
				<td>
					<div class="contentleft"></div>
				</td>
			</tr>
		</table>	
	</div>		
	




<div class="dvfooter">
		<table border="0" style="width: 100%; height: auto" cellpadding="0"
			cellspacing="0">
			<tr>
				<td>
					<div class="footerleft"></div>
				</td>

				<td>
					<div class="footer">
						<table border="0" style="width: 100%; height: auto"
							cellpadding="0" cellspacing="0">
							<tr style="height: 27px;">
								<td>&nbsp;</td>
							</tr>
							<tr>

								<td align="center" style="height: 10px;"><span
									style="font-family: Arial; font-size: 10px; color: #bcbcbc;">Copyright
										2012 Computer Sciences Corporation - All rights reserved. </span></td>
							</tr>
							<tr style="height: 28px;">
								<td>&nbsp;</td>
							</tr>
						</table>
					</div>
				</td>
				<td>
					<div class="footerleft"></div>
				</td>
		</table>
	</div>


</body>
</html>

