<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue  
	%>
<%
	String patientid	= checkForNull(request.getParameter("patientId"));
	String encounterid	= checkForNull(request.getParameter("encounterId"));
	String facilityId	= (String)session.getValue("facility_id");
	String function_name= checkForNull(request.getParameter("function_name"));
	String bed_class_req_cnt = checkForNull(request.getParameter("bed_class_req_cnt"));
	String trans_req_cnt = checkForNull(request.getParameter("trans_req_cnt"));
	String oper_stn_id = checkForNull(request.getParameter("oper_stn_id"));
	String transfer_wo_delink_yn = checkForNull(request.getParameter("transfer_wo_delink_yn"),"N");//Added for the CRF - HSA-CRF-0035
	String queryString = request.getQueryString();
	String function_id = "";
	
	
	if(function_name!=null && function_name.equals("Intra-Ward Patient Transfer"))
		function_id = "INTRA_WARD_PATIENT_TRANSFER";
	else if(function_name!=null && function_name.equals("Modify Service for Inpatient"))
		function_id = "MODIFY_SERVICE_INPATIENT";
%>	
<html>
<head>
<title><%if(function_id.equals("MODIFY_SERVICE_INPATIENT")){%>Modify Service for Inpatient
<%}else{%><fmt:message key="eIP.Intraward.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="eIP.PatientTransfer.label" bundle="${ip_labels}"/><%}%></title>
</head>
	<iframe src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=java.net.URLEncoder.encode(facilityId)%>&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>" name="PatientLine_frame" noresize scrolling='no' style='height:8vh;width:98vw'></iframe>
	<iframe src="../jsp/EmergencyTransfer.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&patient_id=<%=java.net.URLEncoder.encode(patientid)%>&bed_class_req_cnt=<%=bed_class_req_cnt%>&trans_req_cnt=<%=trans_req_cnt%>&oper_stn_id=<%=oper_stn_id%>&func_id=<%=function_id%>&transfer_wo_delink_yn=<%=transfer_wo_delink_yn%>&queryString=<%=queryString%>" name="Transfer_frame" scrolling='no' style="height:80vh;width:98vw"></iframe>
	<iframe src="../html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='no'  style='height:0vh;width:98vw'></iframe>
	<iframe src="../html/blank.html" name="Submit_frame" id="Submit_frame" scrolling='no'  style='height:2vh;width:98vw'></iframe>

</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
%>

