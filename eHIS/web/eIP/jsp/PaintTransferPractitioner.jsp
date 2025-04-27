<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<html>
<head>
<title><fmt:message key="Common.PractitionerTransfer.label" bundle="${common_labels}"/></title>
</head>

<%
request.setCharacterEncoding("UTF-8");
	String patientid	= request.getParameter("patientId");
	String encounterid	= request.getParameter("encounterId");
	String facilityId	= (String)session.getValue("facility_id");
%>	
	<iframe src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=java.net.URLEncoder.encode(facilityId)%>&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>" name="PatientLine_frame" id="PatientLine_frame" noresize scrolling='no' style='height:8vh;width:98vw'></iframe>
		<iframe src="../../eIP/jsp/TransferPractitionerMain.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&patient_id=<%=java.net.URLEncoder.encode(patientid)%>" name="Transfer_frame" id="Transfer_frame" scrolling='no'style='height:70vh;width:98vw'></iframe>
		<iframe src="../html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='no' noresize style='height:0vh;width:98vw'></iframe>
		<iframe src="../html/blank.html" name="Submit_frame" id="Submit_frame" scrolling='no' noresize style='height:0vh;width:98vw'></iframe>
	
</html>

