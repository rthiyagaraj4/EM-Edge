<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String md_care_plan_id=request.getParameter("md_care_plan_id");
if(md_care_plan_id == null) md_care_plan_id="";
String care_plan_id=request.getParameter("care_plan_id");
if(care_plan_id == null) care_plan_id="";

String PatientId=request.getParameter("PatientId");
if(PatientId == null) PatientId="";
String encounterId=request.getParameter("encounterId");
if(encounterId == null) encounterId="";
String taskCode=request.getParameter("taskCode");
if(taskCode == null) taskCode="";
String facility_id=request.getParameter("facility_id");
if(facility_id == null) facility_id="";
String ca_practitioner_id=request.getParameter("ca_practitioner_id");
if(ca_practitioner_id == null) ca_practitioner_id="";
String requestURL="?md_care_plan_id="+md_care_plan_id+"&care_plan_id="+care_plan_id+"&md_care_plan_id="+md_care_plan_id+"&PatientId="+PatientId+"&encounterId="+encounterId+"&taskCode="+taskCode+"&viewScope=A&checkIntervention=Y&facility_id="+facility_id+"&ca_practitioner_id"+ca_practitioner_id+"&CP=Y&dateTime=6";

//String requestURL = "?facility_id=KB&md_care_plan_id=647&care_plan_id=2006&taskCode=DIASTOBPOK&PatientId=KB00005548&encounterId=20054456&ca_practitioner_id=NAREN&checkIntervention=Y&dateTime=6";
//out.println(requestURL);
%>
<html>
<title>	
	<fmt:message key="eCA.InterventionDetails.label" bundle="${ca_labels}"/>
</title>
<iframe src="../../eCA/jsp/PatTaskListResult.jsp<%=requestURL%>" name='patTaskListResultFrame' scrolling = "auto" noresize  frameborder='0' style='height:90vh;width:100vw'></iframe>
	 <iframe src="../../eCA/jsp/PatTaskListStatus.jsp" scrolling = "no"  name='blankFrame' id='blankFrame' style='height:5vh;width:100vw'></iframe>
	
</html>

