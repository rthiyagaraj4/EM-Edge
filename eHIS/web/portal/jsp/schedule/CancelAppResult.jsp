<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="portalrefimpl.common.response.ErrorInfo"%>
<%@page import="portalrefimpl.schedule.ScheduleConstants"%>
<%@page import="portalrefimpl.schedule.cancelappointment.response.CancelAppointmentResponse"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> ::: Cancel Appointment Results ::: </title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="../../css/style.css" type="text/css"/>
<link rel="stylesheet" href="../../css/style_ie.css" type="text/css"/>
<script src="../../js/jquery.min.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body>

<%
CancelAppointmentResponse cancelApptResponse = (CancelAppointmentResponse)request.getAttribute(ScheduleConstants.CANCELAPPT_RESPONSE_ATTRIBUTE_KEY);
/* ErrorInfo errorInfo = cancelApptResponse.getErrorInfo();
int errorCode = errorInfo.getErrorCode(); */
String errorMessage = null;//errorInfo.getErrorMessage();
%>

<div id="popwrapperbooked" >
	
<div id="popheader" >
<div class="row">
		<div id="poptitle">Details
        </div>
        <div id="close" onclick="closeCancelAppointmentResultPage()">x
        </div>
</div>
</div>

<div id="popmsgboxbooked" >

<div id="resultholder" >
	<div class="row">
    	
        <div id="resultcell">
        	<%
        		/* if(ErrorInfo.SUCCESS_CODE == errorCode){ */
        		if(cancelApptResponse.isSuccessful()){	
        	%>
			<span class="contentnormal">"Your booking is cancelled successfully"</span><br/>
			<%
        		}else{
        		errorMessage = cancelApptResponse.getErrorMessage();	
			%>
			<span class="contentnormal"><%=errorMessage %></span><br/>
			<%
        		}
			%>
			<span><a href="#"  onclick="closeCancelAppointmentResultPage()" class="popbtncenter hmepgbtnspace">Ok</a></span> 
        </div>
         
        
    </div>
</div>

</div>
</div>
<!-- #wrapper -->


</body>
</html>

