<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.schedule.createappointment.CreateAppointmentConstants"%>
<%@page import="portalrefimpl.schedule.ScheduleHelper"%>
<%@page import="portalrefimpl.schedule.rescheduleappointment.RescheduleRequestConstants"%>
<%@page import="portalrefimpl.schedule.rescheduleappointment.response.RescheduleAppointmentResponse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>::: Patient Portal - Reschedule Appointment Request - Result</title>
<link rel="stylesheet" href="../../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../../css/style_ie.css" type="text/css"/>
<script src="../../js/jquery.min.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style scoped>
#popwrapperbooked
{
	width:575px;
	height:auto;
	background-color:#ffffff;
	-moz-box-shadow: 0px 0px 10px  #ADADAD;
	-webkit-box-shadow: 0px 0px 10px  #ADADAD;
	box-shadow: 0px 0px 10px  #ADADAD;
}

#popmsgboxbooked
{
	width:564px;
	height:auto;
	margin:5px 5px 5px 4px;
	border:#92b82d solid 1px;
	background-color:#ffffff;
	display:table;
}

</style>
</head>
<body>

<%
RescheduleAppointmentResponse rescheduleApptReqResponse = (RescheduleAppointmentResponse) request.
							getAttribute(RescheduleRequestConstants.RESCHEDULE_APPTREQ_RESPONSE_PARAM);

%>


<div id="popwrapperbooked">
	
<div id="popheader">
<div class="row">
		<div id="poptitle">Details
        </div>
        <div id="close">x
        </div>
    
</div>
</div>

<div id="popmsgboxbooked">

<div id="resultholder">
	<div class="row">
    	
        <div id="resultcell">
       <%
       	if(rescheduleApptReqResponse == null){
       %>
       		<span id="resulttitle">Appointment request was not rescheduled. System error</span>
       		<div style="min-height: 100px;"></div>
       		<span><a href="#" onclick="postOperation('1')" class="popbtncenter">Ok</a></span>
       <%
       	}else{
       		/* ErrorInfo errorInfo = bookApptResponse.getErrorInfo();
       		int errorCode = errorInfo.getErrorCode(); */
	       	/* if(ErrorInfo.SUCCESS_CODE != errorCode){ */
	       	if(!rescheduleApptReqResponse.isSuccessful()){	
	       		String errorMessage = rescheduleApptReqResponse.getErrorMessage();
       %> 
       		<span id="resulttitle"><%out.println(errorMessage);%></span>
       		<div style="min-height: 100px;"></div>
       		<span><a href="#" onclick="postOperation('1')" class="popbtncenter">Ok</a></span>
       <%
      		 }else{
    	   		String practitionerName = request.getParameter(
    	   					RescheduleRequestConstants.APPTREQ_DETAILS_PRACTITIONERNAME_PARAM);
    	   		if(practitionerName == null){
    	   			practitionerName = "";
    	   		}
    	   		String selectedSpecialtyDesc = request.getParameter(
    	   					RescheduleRequestConstants.HIDDEN_SPECIALTY_DESC_PARAM);
    	   		if(selectedSpecialtyDesc == null){
    	   			selectedSpecialtyDesc = "";
    	   		}
    	   		
    	   		String preferredDate = request.getParameter
    	   				(RescheduleRequestConstants.HIDDEN_PREFERRED_DATE_TIMESLOT_PARAM);
    	   		if(preferredDate == null){
    	   			preferredDate = "";
    	   		}
    	   		String preferredDateDisplayStr = ScheduleHelper
						.getPreferredDateInDisplayFormat(
								preferredDate,
								RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT,
								RescheduleRequestConstants.APPTREQ_DETAILS_DATE_DISPLAY_FORMAT2);
    	   		
    	   		String selectedTimeSlot = request.getParameter
    	   				(RescheduleRequestConstants.SELECTED_TIMESLOT_PARAM);
    	   		if(selectedTimeSlot == null){
    	   			selectedTimeSlot = "";
    	   		}
       %>
		        <span id="resulttitle">Appointment rescheduled successfully</span>
				<div class="bookedDetails">
					<div class="bookedcontent">
						<span class="contenbold"><%=practitionerName %>,</span><span class="contentnormal"> <%=selectedSpecialtyDesc %></span><br/>
						<div class="popupoverflow" >
							<div class="floatleft">
								<span class="contentnormalpopup">Appointment Request Date and Time</span>
							</div>
							<div class="floatleft">
								<span class="contentnormal">:&nbsp;</span><span class="contenbold"><%=preferredDateDisplayStr %>, <%=selectedTimeSlot %></span><br/>
							</div>
						</div>
					
					</div>
				</div>
		    	<span><a href="#" onclick="postOperation('2')" class="popbtncenter">Ok</a></span>    
        <%
      		 }
       	}
        %>
      	</div>
        
    </div>

</div>

</div>
</div>


</body>
</html>

