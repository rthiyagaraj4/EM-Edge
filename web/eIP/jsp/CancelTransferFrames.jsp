<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title><fmt:message key="Common.CancelTransfer.label" bundle="${common_labels}"/> </title>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String patientid = request.getParameter("patientId");
	String encounterid=request.getParameter("encounterId");
	String facilityId = (String)session.getValue("facility_id");

	String strSrlNo = request.getParameter("srlno");
	String strCountry= request.getParameter("country");
%>	
<iframe src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=java.net.URLEncoder.encode(facilityId)%>&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>" name="PatientLine_frame" noresize scrolling='no' style='height:6%;width:100vw'></iframe><iframe src="../jsp/CancelTransferMain.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&patient_id=<%=java.net.URLEncoder.encode(patientid)%>&srlno=<%=strSrlNo%>&country=<%=strCountry%>" name="Transfer_frame" scrolling='no'>
	<iframe src="../html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='no' noresize style='height:80vh;width:100vw'></iframe>

</html>

