<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
	request.setCharacterEncoding("UTF-8");
%>

<html>
<%
	String patientId=request.getParameter("patientId");
	if(patientId == null) patientId="";
	
	String encounter_id = request.getParameter("encounterId");
	if(encounter_id == null) encounter_id = "";

	String fileNo = request.getParameter("fileNo");
	if(fileNo == null) fileNo = "";

	String title = "Encounter-Document Details"; 
	String frfunction = request.getParameter("p_fr_function")==null?"":request.getParameter("p_fr_function");

	String call_function = request.getParameter("call_function")==null?"":request.getParameter("call_function");

	String Patient_Class = request.getParameter("Patient_Class")==null?"":request.getParameter("Patient_Class");

	if(frfunction.equals("IP"))
		title = "Stay Details";
	String facilityId = (String)session.getValue("facility_id");
%>
<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<head>
<title><%=title%></title>

<% if (!call_function.equals("")){%><!-- Dont display currentencounter.jsp  -->
<iframe name='pline' id='pline' 	src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Facility_Id=<%=facilityId%>" frameborder=0 scrolling=no style='height:10%;width:100vw'></iframe><iframe name='LastAdmissionRes' id='LastAdmissionRes'  src='../jsp/FMLastAdmissionResult.jsp?Filename=CurrentEncounterMain&LastDet=1&encounter_id=<%=encounter_id%>&patientId=<%=patientId%>&fileNo=<%=fileNo%>&Patient_Class=<%=Patient_Class%>' noresize  frameborder=no scrolling=auto style='height:100vh;width:100vw'></iframe>
<% } else {%>
	<iframe name='pline' id='pline' 	src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Facility_Id=<%=facilityId%>" frameborder=0 scrolling=no style='height:10%;width:100vw'></iframe><iframe name='CurEnc' id='CurEnc' src='../jsp/FMCurrentEncounter.jsp?LastDet=1&patientId=<%=patientId%>&encounterId=<%=encounter_id%>&Patient_Class=<%=Patient_Class%>' noresize  frameborder=no scrolling=no style='height:20%;width:100vw'></iframe><iframe name='LastAdmissionRes' id='LastAdmissionRes'  src='../jsp/FMLastAdmissionResult.jsp?Filename=CurrentEncounterMain&LastDet=1&encounter_id=<%=encounter_id%>&patientId=<%=patientId%>&fileNo=<%=fileNo%>&Patient_Class=<%=Patient_Class%>' noresize  frameborder=no scrolling=auto style='height:100vh;width:100vw'></iframe>
<% } %>
</head>
</html>

