<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title><fmt:message key="eIP.CancelTransferPatientOut.label" bundle="${ip_labels}"/></title>
</head>
<%
request.setCharacterEncoding("UTF-8");
	String patientid = request.getParameter("patientId");
	String encounterid=request.getParameter("encounterId");
	String facilityId = (String)session.getValue("facility_id");

		//String url="../../eCommon/jsp/commonToolbar.jsp?";
		//String params = request.getQueryString() ;
		//String source = url + params ;
		String function_id=request.getParameter("function_id");
        if(function_id == null) function_id = "";

%>
	<iframe src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=java.net.URLEncoder.encode(facilityId)%>&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>" name="PatientLine_frame" noresize scrolling='no' style='height:10vh;width:99vw'></iframe>
	<iframe src="../jsp/CancelTransferPatientOutMain.jsp?function_id=<%=function_id%>&encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&patient_id=<%=java.net.URLEncoder.encode(patientid)%>" name="Transfer_frame" scrolling='no' style = "height:75vh;width:99vw"></iframe>
		<iframe src="../html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='no' noresize style='height:5vh;width:99vw'></iframe>
	
</html>

