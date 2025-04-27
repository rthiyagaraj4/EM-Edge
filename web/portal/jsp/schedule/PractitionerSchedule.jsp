<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.Locale"%>
<%@page import="portalrefimpl.PortalConstants"%>
<%@page import="java.util.Map"%>
<%@page import="portalrefimpl.schedule.ScheduleHelper"%>
<%@page import="java.util.Calendar"%>
<%@page import="portalrefimpl.PortalHelper"%>
<%@page import="java.util.Date"%>
<%@page import="portalrefimpl.schedule.createappointment.response.Schedule"%>
<%@page import="java.util.List"%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.schedule.createappointment.response.PractitionerScheduleResponse"%>
<%@page import="portalrefimpl.schedule.createappointment.svc.serviceinvoker.PractitionerScheduleServiceInvoker"%>
<%@page import="portalrefimpl.schedule.createappointment.request.PractitionerScheduleRequest"%>
<%@page import="portalrefimpl.schedule.createappointment.CreateAppointmentConstants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../../css/style_ie.css" type="text/css"/>
<!-- <link rel="stylesheet" href="../../jquery/jquery.mobile-1.0a4.1.min.css" /> 
<script src="../../jquery/jquery-1.5.2.min.js"></script> 
<script src="../../jquery/jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->

<script>
function showLeftPanel(currentCounter,maxPanels){
	var currentSectionComp = document.getElementById("section"+currentCounter);
	if(currentSectionComp){
		currentSectionComp.style.display = 'none';
		var leftPanelCnt = 0;
		try{
			leftPanelCnt = parseInt(currentCounter);
		}catch(e){
			leftPanelCnt = 0;
		}
		if(leftPanelCnt <= 0){
			alert('System error - cannot view earlier records');
			currentSectionComp.style.display = 'block';
		}
		
		leftPanelCnt = leftPanelCnt - 1;
		var leftPanel = document.getElementById("section"+leftPanelCnt);
		if(leftPanel){
			leftPanel.style.display = 'block';
		}
	}
}

function showRightPanel(currentCounter,maxPanels){
	var currentSectionComp = document.getElementById("section"+currentCounter);
	if(currentSectionComp){
		currentSectionComp.style.display = 'none';
		var rightPanelCnt = 0;
		try{
			rightPanelCnt = parseInt(currentCounter);
		}catch(e){
			rightPanelCnt = 0;
		}
		var maxPanelCnt = 0;
		try{
			maxPanelCnt = parseInt(maxPanels);
		}catch(e){
			maxPanelCnt = 0;
		}
		
		if(maxPanelCnt == 0 || rightPanelCnt >= maxPanels){
			alert('System error - cannot view future records');
			currentSectionComp.style.display = 'block';
		}
		
		rightPanelCnt = rightPanelCnt + 1;
		var rightPanel = document.getElementById("section"+rightPanelCnt);
		if(rightPanel){
			rightPanel.style.display = 'block';
		}
	}
}

</script>

</head>
<body>
<%
	// get the patient id
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

	// now get the individual request parameters
	String preferredDateStr = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDDATE_PARAMETER_KEY);
	if (preferredDateStr == null) {
		preferredDateStr = "";
	}
	// convert the date value in string to a date object
	// this is useful later on
	Date preferredDate = PortalHelper
			.getDateFromString(
					preferredDateStr,
					CreateAppointmentConstants.PRACTITIONER_SERVICE_PREFERRED_DATE_FORMAT);

	String preferredFromTimeStr = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFROMTIME_PARAMETER_KEY);
	if (preferredFromTimeStr == null) {
		preferredFromTimeStr = "";
	}

	String preferredToTimeStr = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDTOTIME_PARAMETER_KEY);
	if (preferredToTimeStr == null) {
		preferredToTimeStr = "";
	}

	String facilityId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITYID_PARAMETER_KEY);
	if (facilityId == null) {
		facilityId = "";
	}

	String facilityDesc = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDFACILITYDESC_PARAMETER_KEY);
	if (facilityDesc == null) {
		facilityDesc = "";
	}

	String specialityId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYID_PARAMETER_KEY);
	if (specialityId == null) {
		specialityId = "";
	}

	String specialityDesc = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDSPECIALITYDESC_PARAMETER_KEY);
	if (specialityDesc == null) {
		specialityDesc = "";
	}

	String practitionerId = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERID_PARAMETER_KEY);
	if (practitionerId == null) {
		practitionerId = "";
	}

	String practitionerName = request
			.getParameter(CreateAppointmentConstants.APPT_PREFERREDPRACTITIONERNAME_PARAMETER_KEY);
	if (practitionerName == null) {
		practitionerName = "";
	}

	System.out.println("Preferred date =" + preferredDateStr);

	//code to get the list of practitioners goes here
	PractitionerScheduleRequest practitionerScheduleRequest = new PractitionerScheduleRequest();
	practitionerScheduleRequest.setPatientId(patientId);
	practitionerScheduleRequest
			.setPortalUserName(PortalConstants.PORTALUSER_REQUEST_PARAM_VALUE);
	practitionerScheduleRequest.setPractitionerId(practitionerId);
	practitionerScheduleRequest.setSpecialityCode(specialityId);
	practitionerScheduleRequest.setSpecialityDesc(specialityDesc);
	// need to set other request parameters as well
	// facility id
	practitionerScheduleRequest.setFacilityId(facilityId);
	practitionerScheduleRequest.setFacilityDesc(facilityDesc);
	// preferred date
	practitionerScheduleRequest
			.setPreferredDateAsString(preferredDateStr);
	practitionerScheduleRequest
			.setPreferredStartTime(preferredFromTimeStr);
	practitionerScheduleRequest.setPreferredEndTime(preferredToTimeStr);
	practitionerScheduleRequest.setLocale(Locale.getDefault().getLanguage());
	practitionerScheduleRequest
			.setOperationStandardId(CreateAppointmentConstants.PRACTITIONER_SERVICE_OPRSTN_DEFAULT_VALUE);
	practitionerScheduleRequest
			.setResourceClass(CreateAppointmentConstants.PRACTITIONER_SERVICE_RESOURCECLASS_DEFAULT_VALUE);

	/* PractitionerScheduleSvcImpl practitionerScheduleSvcImpl = new PractitionerScheduleSvcImpl();
	practitionerScheduleSvcImpl
			.registerService(practitionerScheduleRequest); */

	PractitionerScheduleServiceInvoker practScheduleServiceInvoker = new PractitionerScheduleServiceInvoker();
	practScheduleServiceInvoker.registerService(practitionerScheduleRequest);
	PractitionerScheduleResponse practScheduleResponse = (PractitionerScheduleResponse)practScheduleServiceInvoker
			.getDataThroughWebService(practitionerScheduleRequest);
%>

<div id="popwrapperbooked"  style="width:615px;">
	
<div id="popheader">
<div class="row">
		<div id="poptitle"><%=practitionerName%>'s Schedule
        </div>
        
		<div id="close" onclick="window.parent.closePractitionerSchedulePopup()">x
        </div>
    
</div>
</div>

<div id="popmsgboxbooked" style="width:600px;min-height: 100px;">

<%
	ErrorInfo practErrorInfo = practScheduleResponse.getErrorInfo();
	String errorMessage = null;
	/* if (ErrorInfo.SUCCESS_CODE != practErrorInfo.getErrorCode()) { */
	if (!practScheduleResponse.isSuccessful()) {	
		errorMessage = practScheduleResponse.getErrorMessage();
%>
<span class="loginerror">
   <%
   	out.println(errorMessage);
   %>
</span>
<%
	} else {
		// code to populate the schedule information comes here
		List<Schedule> scheduleList = practScheduleResponse
				.getScheduleList();
		// schedule list will be not null and not empty - hence no need
		// to have safe checks
		
		// this code is to calculate the last date to be shown in the GUI 
		// the preferred date should be not null
		Date endDate = preferredDate;
		Calendar startDateCalendar = Calendar.getInstance();
		Calendar endDateCalendar = Calendar.getInstance();
		Calendar runningDateCalendar = Calendar.getInstance();
		if(preferredDate != null){
			startDateCalendar.setTime(preferredDate);
			endDateCalendar.setTime(preferredDate);
			endDateCalendar.add(Calendar.DATE, CreateAppointmentConstants.BOOKAPPT_PREFERREDENDDATE_RANGE);
			endDate = endDateCalendar.getTime();
			//runningDateCalendar.setTime(preferredDate);
		}
		
		// the practitioner schedule data is manipulated
		// to return data with which the GUI can be shown
		Map<Date,List<Schedule>> scheduleMap = ScheduleHelper.
						getPractitionerScheduleForDisplay(practScheduleResponse);
		
		// the total number of dates to be shown is always a constant as of now
		// it has a value 30
		int totalDatesToShow = CreateAppointmentConstants.BOOKAPPT_PREFERREDENDDATE_RANGE;
		int viewRange = 0;
		int runningCounter = 0;
		// constant denoting the number of weeks till which we need to iterate
		final int NO_OF_WEEKS = 5;
		//int dateCounter = 1;
		Date currentDateSnapshot = preferredDate; 
		%>
	<div id="resultholder">
		<div class="row">
		
		<%
		String divDisplayStyle = "display:block";
		// iterate the dates from the preferred date to 30 days in future 
		for(int weekCounter=1;weekCounter <= NO_OF_WEEKS;weekCounter++){
			viewRange = CreateAppointmentConstants.BOOKAPPT_SCHEDULE_VIEW_RANGE;
			if((totalDatesToShow - runningCounter) < CreateAppointmentConstants.BOOKAPPT_SCHEDULE_VIEW_RANGE){
				viewRange = totalDatesToShow - runningCounter;
			}
			
			if(weekCounter > 1){
				divDisplayStyle = "display : none";
			}
			
			runningDateCalendar.setTime(currentDateSnapshot);
			//currentDateSnapshot = runningDateCalendar.getTime();
		%>
		
		<%-- <section id="section<%=weekCounter%>" data-role = "page"> --%>
		<div id="section<%=weekCounter %>" style="<%=divDisplayStyle%>">
			<div id="resultcell">
				<!--  the overall table for display of this page -->
				<table border='0' cellpadding="0" cellspacing="0" >
        		<tr>
        		<td>
        		<!--  table to show the left arrow -->
					<table border='0' cellpadding="0" cellspacing="0" style="float:left;border-left:1px solid #CCCCCC;border-top:1px solid #CCCCCC;">
						<th height="48px;" style="width:50px;border-bottom:1px solid #D3D3D3;background-color:#DCE8C6;font-size:12px;color:#090000;">
							<span class="contenbold">
							<%
								if(weekCounter == 1){
							%>
							<img class="handcursor" src="../../images/LeftArrow_Dis.png"/>
							<%
								}else{
							%>
							<img class="handcursor" onclick="showLeftPanel('<%=weekCounter %>','<%=NO_OF_WEEKS %>')" src="../../images/LeftArrow.png"/>
							<%
								}
							%>
							</span>
						</th>
						<tr style="width:50px;">
							<td class="odd" height="48px;" style="font-size:12px;width:30px;"></td>
						</tr>
						<tr style="width:50px;">
							<td class="odd" height="48px;" style="font-size:12px;width:30px;"></td>
						</tr>
						<tr style="width:50px;">
							<td class="odd" height="50px;" style="border-bottom:1px solid #D3D3D3;font-size:12px;width:50px;"></td>
						</tr>
					</table>
				</td>
				<td valign="top">
				<!--  table to show the data -->
				<table border='0' cellpadding="0" cellspacing="0" class="scheduleGrid" style="height:100%;min-width: 430px;">
			<%	
				String dayOfWeek = null;
				Date calendarDate = null;
				String dateInDisplayFormat = null;
				// iteration to show the date for the week as header
				for(int dateCounter = 0;dateCounter < viewRange;dateCounter++){
					if(dateCounter > 0 || weekCounter > 1){
						runningDateCalendar.add(Calendar.DATE, 1);	
					}
					
					calendarDate = runningDateCalendar.getTime();
					dayOfWeek = PortalHelper.getDateAsString
							(calendarDate, CreateAppointmentConstants.PRACTITIONERSCHEDULE_DAYOFWEEK_FORMAT);
					dateInDisplayFormat = PortalHelper.getDateAsString
							(calendarDate, CreateAppointmentConstants.PRACTITIONERSCHEDULE_DATE_FORMAT);
					
					// increment the running counter as well
					runningCounter++;
			%>
					<th>
						<span class="contenbold"><%=dayOfWeek %><br><%=dateInDisplayFormat %>
						</span>
					</th>
				<%
				}
				
				// reset the running calendar since we need to iterate once more 
				runningDateCalendar.setTime(currentDateSnapshot);
				List<Schedule> practScheduleList = null;
				Date tempDate = null;
				
				for(int count=0;count<CreateAppointmentConstants.PRACTITIONERSCHEDULE_DISPLAY_TIME_ZONE;count++){
				%>
					<tr>
				<%	
					runningDateCalendar.setTime(currentDateSnapshot);
					String tdStyle = null;
					// iteration to show the schedule
					for(int dateCounter = 0;dateCounter < viewRange;dateCounter++){
						// reset the schedule list
						practScheduleList = null;
						// for setting style
						tdStyle = "even";
						if(dateCounter % 2 != 0){
							tdStyle = "odd";
						}
						
						if(dateCounter > 0 || weekCounter > 1){
							runningDateCalendar.add(Calendar.DATE, 1);	
						}
						tempDate = runningDateCalendar.getTime();
						if(scheduleMap.containsKey(tempDate)){
							practScheduleList = scheduleMap.get(tempDate);
						}
						if(practScheduleList == null || practScheduleList.isEmpty()){
				%>
						<td class="<%=tdStyle%>" style="min-height: 48px;height:48px;">&nbsp;
						</td>
				<%
						}else{
				%>			
						<td class="<%=tdStyle%>" style="min-height: 48px;height:48px;">
				<%
							if(practScheduleList.size() <= count){
				%>
							&nbsp;
						</td>
				<%
							}else{
								Schedule scheduleObj = practScheduleList.get(count);
								String startTime = scheduleObj.getStartTime();
								String endTime = scheduleObj.getEndTime();
				%>						
						<%=startTime%><br><%=endTime %>
						</td>
				<%
							}
						}
					}
				%>	
					</tr>
				<%
				}
				
				// set the current date snapshot to running calendar's value
				currentDateSnapshot = runningDateCalendar.getTime();
				
				%>
				</table>
				<!--  end of the table which shows the data -->	
			</td>
			<td>
				<table border='0' cellpadding="0" cellspacing="0" style="float:left;border-right:1px solid #CCCCCC;border-top:1px solid #CCCCCC;">
				<th height="48px;" style="width:50px;border-bottom:1px solid #D3D3D3;background-color:#DCE8C6;font-size:12px;font-weight:normal;color:#090000;">
						<span class="contenbold">
						<%
							if(weekCounter == NO_OF_WEEKS){
						%>
						<img class="handcursor" src="../../images/RightArrow_Dis.png"/>
						<%
							}else{
						%>
						<img class="handcursor" onclick="showRightPanel('<%=weekCounter %>','<%=NO_OF_WEEKS %>')" src="../../images/RightArrow.png"/>
						<%
							}
						%>
					</span>
				</th>
				<tr style="font-size:12px;">
						<td class="odd" height="48px;" style="font-size:12px;"></td>
					</tr>
					<tr style="font-size:12px;">
						<td class="odd" height="48px;" style="font-size:12px;"></td>
					</tr>
					<tr style="font-size:12px;">
						<td class="odd" height="50px;" style="border-bottom:1px solid #D3D3D3;font-size:12px;"></td>
					</tr>
				</table>
			</td>
		</tr>
        </table>
				
        </div>
      <!-- </section> -->
      </div>
      
      <%
		}
	  %>
        
    </div>
</div>

<%
	} // end of else loop which shows the practitioner schedule
%>

</div>
</div>


</body>
</html>

