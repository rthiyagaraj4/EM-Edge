<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title><fmt:message key="eIP.ConfirmBedClassChange.label" bundle="${ip_labels}"/></title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String patientid = request.getParameter("patientId");
	String encounterid=request.getParameter("encounterId");
	String facilityId = (String)session.getValue("facility_id");
	
%>	
<!--<iframe src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=java.net.URLEncoder.encode(facilityId)%>&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>" name="PatientLine_frame" noresize scrolling='no' style='height:35.3%;width:100vw'></iframe><iframe src="../jsp/ConfirmBedClassChangeDetails.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&patient_id=<%=java.net.URLEncoder.encode(patientid)%>&<%=request.getQueryString()%>" name="Class_Change_frame" scrolling='no'>
	<iframe src="../html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='no' noresize style='height:80vh;width:100vw'></iframe>
	<iframe src="../html/blank.html" name="Submit_frame" id="Submit_frame" scrolling='no' noresize style='height:0%;width:100vw'></iframe>


</html>

