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
	String QueryString = checkForNull(request.getQueryString());

%>	
<html>
<head>
<title><fmt:message key="eIP.EmergencyTransfer.label" bundle="${ip_labels}"/></title>
</head>
<iframe src="../../eCommon/jsp/pline.jsp?Facility_Id=<%=java.net.URLEncoder.encode(facilityId)%>&EncounterId=<%=java.net.URLEncoder.encode(encounterid)%>" name="PatientLine_frame" noresize scrolling='no' style='height:10vh;width:99vw'></iframe>
<iframe src="../jsp/AddModifyEmergencyTransfer.jsp?encounter_id=<%=java.net.URLEncoder.encode(encounterid)%>&patient_id=<%=java.net.URLEncoder.encode(patientid)%>&bed_class_req_cnt=<%=bed_class_req_cnt%>&trans_req_cnt=<%=trans_req_cnt%>&oper_stn_id=<%=oper_stn_id%>&func_id=<%=function_name%>&QueryString=<%=QueryString%>" name="Transfer_frame" scrolling='no' style='height:65vh;width:99vw'></iframe>
<iframe src="../html/blank.html" name="Dummy_frame" id="Dummy_frame" scrolling='no' noresize style='height:0vh;width:99vw'></iframe>
<iframe src="../html/blank.html" name="Submit_frame" id="Submit_frame" scrolling='no' noresize style='height:12vh;width:99vw'></iframe>

</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

