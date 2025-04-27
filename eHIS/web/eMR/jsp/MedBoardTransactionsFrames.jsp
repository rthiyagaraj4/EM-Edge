<!DOCTYPE html>
<%
/*
 ****************************************************************************************
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 29 MARCH 2005
* @Function		: To define frames for the MEDICAL BOARD Transactions...
 ****************************************************************************************
*/
%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	String call_function= checkForNull(request.getParameter("call_function"));
	String PatientId	= checkForNull(request.getParameter("PatientId"));
	String request_id	= checkForNull(request.getParameter("request_id"));
	String called_from	= checkForNull(request.getParameter("called_from"));
	String Title = "";

	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		Title = "Request for Medical Board";
	else if(call_function.equals("MEDICAL_BOARD_STATUS"))
		Title = "Status of Medical Board Request";
	else if(call_function.equals("FORWARD_MEDICAL_BOARD"))
		Title = "Forward Medical Board Request";
	else if(call_function.equals("PREPARE_MEDICAL_BOARD"))
		Title = "Prepare Medical Report by Board";
	else if(call_function.equals("RECEIVE_MEDICAL_BOARD"))
		Title = "Receive Medical Report";
	else if(call_function.equals("DELIVER_MEDICAL_BOARD"))
		Title = "Deliver Medical Board";
	else if(call_function.equals("MEDICAL_BOARD_INT_APPT"))
		Title = "Intimate Appointment for Medical Board Request";
	else if(call_function.equals("MEDICAL_BOARD_APPT"))
		Title = "Appointment for Med Board request";
	else if(call_function.equals("MEDICAL_BOARD_COMPLETED"))
		Title = "Medical Board Completed";
	else if(call_function.equals("REVISE_MEDICAL_BOARD"))
		Title = "Revise Medical Board";

%>
	<head>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<title><%=Title%></title>
		<iframe scrolling="no" name='detail_frame' id='detail_frame' src='../../eMR/jsp/MedBoardRequestDetail.jsp?call_function=<%=call_function%>&request_id=<%=request_id%>&PatientId=<%=PatientId%>&called_from=<%=called_from%>' noresize frameborder=no scrolling="no" style='height:11vh;width:99vw'></iframe>
		<iframe name='detail_frame' id='detail_frame'  src='../jsp/MedBoardRequestDetailTabs.jsp?call_function=<%=call_function%>&request_id=<%=request_id%>&PatientId=<%=PatientId%>&called_from=<%=called_from%>' noresize  frameborder=no scrolling=no style='height:81vh;width:99vw'></iframe>
		<iframe name='RecordButton_frame' id='RecordButton_frame'  src='../jsp/MedBoardRequestButtons.jsp?call_function=<%=call_function%>&request_id=<%=request_id%>&PatientId=<%=PatientId%>&called_from=<%=called_from%>' noresize frameborder=no scrolling='no' style='height:4vh;width:99vw'></iframe>
		<iframe name='ModalMessageFrame' id='ModalMessageFrame' src='../../eCommon/jsp/error.jsp' frameborder=no noresize scrolling='no' style='height:0vh;width:99vw'></iframe>
	</head>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

