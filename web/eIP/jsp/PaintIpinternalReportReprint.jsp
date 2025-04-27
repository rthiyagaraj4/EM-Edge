<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title> <fmt:message key="eIP.EmergencyTransfer.label" bundle="${ip_labels}"/></title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String patientid = request.getParameter("patientId");
	String encounterid=request.getParameter("encounterId");
	String facilityId = (String)session.getValue("facility_id");
%>	
	<iframe src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=facilityId%>&EncounterId=<%=encounterid%>" name="PatientLine_frame" noresize scrolling='no' style='height:8%;width:100vw'></iframe><iframe src="../jsp/EmergencyTransfer.jsp?encounter_id=<%=encounterid%>&patient_id=<%=patientid%>" name="Transfer_frame" scrolling='no'>
		<iframe src="../html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='no' noresize style='height:80vh;width:100vw'></iframe>
	
</html>

