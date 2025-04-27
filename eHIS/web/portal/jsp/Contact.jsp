<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.common.model.ContactDetails"%>
<%@page import="portalrefimpl.facility.FacilityHelper"%>
<%@page import="portalrefimpl.common.model.Address"%>
<%@page
	import="portalrefimpl.facility.facilityforcontact.response.FacilityDetails"%>
<%@page import="java.util.List"%>
<%@page
	import="portalrefimpl.facility.facilityforcontact.response.FacilityForContactResponse"%>
<%@page
	import="portalrefimpl.facility.facilityforcontact.svc.FacilityForContactServiceInvoker"%>
<%@page import="portalrefimpl.facility.FacilityConstants"%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page
	import="portalrefimpl.facility.facilityforcontact.request.FacilityForContactRequest"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Patient Portal - Contact Us</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../css/style.css" type="text/css" />
<link rel="stylesheet" href="../css/style_ie.css" type="text/css" />
</head>
<body>

	<%
		String patientId = "";
		patientId = (String) session
				.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);

		String patientName = "";
		patientName = (String) session
				.getAttribute(PortalConstants.PATIENTNAME_SESSION_KEY);
		if (patientName == null) {
			patientName = "";
		}
	%>

	<div id="wrapper">
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
							<a href="../servlet/LogoutServlet" class="logout"> Logout</a>
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
						<img src="../images/logo.png">
					</div>
					<div id="Menubox">
						<ul class="menu">
							<li class="menuselect"><div class="menuicons">
									<img src="../images/Contact.png" />
								</div>Contact</li>
							<li><a href="./result/DetailedResult.jsp"><div
										class="menuicons">
										<img src="../images/Results.png" />
									</div>My Results</a></li>
							<li><a href="./schedule/UpcomingAppointments.jsp"><div
										class="menuicons">
										<img src="../images/Appointment.png" />
									</div>My Appointments</a></li>
							<li><a href="./PortalHome.jsp"><div class="menuicons">
										<img src="../images/Home.png" />
									</div>Home</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<!-- #logo And Menu -->

		<div class="line"></div>


		<div id="content">


			<!-- #Content Area-->
			<div id="contentbg"></div>

			<div id="contentArea">

				<div id="contentArearow">
					<div style="min-height: 462px;">
						<div id="ContactDiv">

							<div id="Contactadd" style="display: table;">
								<%
									int index = 0;
								%>
								<p class="ContactTitle">Contact Us!</p>
								<div style="display: table-row;">
									<!-- TODO this needs to be modified for getting the hospital details -->
									<div class="Facilityadd" style="display: table-cell;">
										<div class="Contactcontent">
											<p class="contenboldregistered">Registered office</p>
											<p class="Footeradd">Envato Marketplace</p>
											<p class="Footeradd">Melbourne St</p>
											<p class="Footeradd">Sydney</p>
										</div>
									</div>
									<%
										// increment the index
										index++;

										FacilityForContactRequest facilityRequest = new FacilityForContactRequest();
										String considerAllFacilityValue = PortalHelper
												.getConfigPropertyValue(
														FacilityConstants.FACILITY_FORCONTACT_CONSIDER_ALL_PARAM,
														true);
										if (FacilityConstants.FACILITY_FORCONTACT_CONSIDER_NOT
												.equals(considerAllFacilityValue)) {
											String recordCntStr = PortalHelper
													.getConfigPropertyValue(FacilityConstants.FACILITY_FORCONTACT_COUNT_PARAM);
											int recordCnt = PortalHelper
													.getIntegerValue(
															recordCntStr,
															FacilityConstants.FACILITY_FORCONTACT_DEFAULT_COUNT_VALUE);
											/* recordCnt=15; */
											//recordCnt++;
											facilityRequest.setFacilityCount(recordCnt);
										}
										facilityRequest
												.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);

										FacilityForContactServiceInvoker serviceInvoker = new FacilityForContactServiceInvoker();
										serviceInvoker.registerService(facilityRequest);
										FacilityForContactResponse facilityResponse = (FacilityForContactResponse) serviceInvoker
												.getDataThroughWebService(facilityRequest);

										if (facilityResponse.isSuccessful()) {
											List<FacilityDetails> facilitiesList = facilityResponse
													.getFacilitiesList();
											// no need to check for list null as list is non empty in success case
											for (FacilityDetails facilityDetails : facilitiesList) {
												if ((index % 2) == 0) {
													index = 0;
									%>
								</div>
								<div style="display: table-row;">
									<%
										}
									%>
									<div class="Facilityadd" style="display: table-cell;">
										<div class="Contactcontent" style="word-break: break-all;">
											<p class="contenboldregistered"><%=facilityDetails.getFacilityName()%></p>
											<%
												Address address = facilityDetails.getFacilityAddress();
														List<String> addressContentList = FacilityHelper
																.getAddressContentsAsList(address);
														// no need to check for null - just iterate through and show
														for (String addressContent : addressContentList) {
											%>
											<p class="Footeradd"><%=addressContent%></p>
											<%
												}

														ContactDetails contactDetails = facilityDetails
																.getFacilityContactDetails();
														List<String> contactDetailsList = FacilityHelper
																.getContactDetailsAsList(contactDetails);
														// no need to check for null - just iterate through and show
														for (String facilityContent : contactDetailsList) {
											%>
											<p class="Footeradd"><%=facilityContent%></p>
											<%
												}
											%>
										</div>
									</div>
									<%
										index++;
											}
										}
										if (index != 0) {
									%>
								</div>
								<!-- <div style="display: table-row;"> -->
								<%
									}
								%>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="Footerbg">
			<div id="poweredby">
				<p class="poweredby">
					Powered by <img src="../images/csc.png" width="25" height="14">
				</p>
			</div>
		</div>
	</div>

</body>
</html>
