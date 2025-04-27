<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title><fmt:message key="Common.RequestforTransfer.label" bundle="${common_labels}"/></title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String patientid	= request.getParameter("patientId");
	String encounterid	= request.getParameter("encounterId");
	String facilityId	= (String)session.getValue("facility_id");
	String bl_interfaced_yn=request.getParameter("bl_interfaced_yn");
	String priotity_status=request.getParameter("priotity_status");
	String change_bed_class_yn= request.getParameter("change_bed_class_yn");
	String queryString= request.getQueryString();
%>	
	
	<iframe src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=java.net.URLEncoder.encode(facilityId)%>&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>" name="PatientLine_frame" scrolling=NO noresize style="height:10vh;width:98vw"></iframe>
	<iframe src="../jsp/addModifyBedBookingTransfer.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&patient_id=<%=java.net.URLEncoder.encode(patientid)%>&bl_interfaced_yn=<%=bl_interfaced_yn%>&priotity_status=<%=priotity_status%>&change_bed_class_yn=<%=change_bed_class_yn%>&queryString=<%=queryString%>" name="Transfer_frame" id="Transfer_frame"  scrolling='no' noresize style='height:78vh;width:98vw'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='yes' noresize style='height:0vh;width:98vw'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="Dummy_frame2" id="Dummy_frame2" scrolling='yes' noresize style='height:0vh;width:98vw'></iframe>

</html>

