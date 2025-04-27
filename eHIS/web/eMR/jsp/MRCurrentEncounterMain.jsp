<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<%

	request.setCharacterEncoding("UTF-8");
	String patientId=request.getParameter("patientId");
	if(patientId == null) patientId="";
	
	String encounter_id = request.getParameter("encounterId");
	if(encounter_id == null) encounter_id = "";

	String title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounterdetails.label","common_labels");
	String frfunction = request.getParameter("p_fr_function")==null?"":request.getParameter("p_fr_function");

	String call_function = request.getParameter("call_function")==null?"":request.getParameter("call_function");

	String Patient_Class = request.getParameter("Patient_Class")==null?"":request.getParameter("Patient_Class");

	if(frfunction.equals("IP"))
		title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.staydetails.label","common_labels");


	

	String facilityId = request.getParameter("facilityId")==null?"":request.getParameter("facilityId");
	if(facilityId.equals(""))
		facilityId = (String)session.getValue("facility_id");
%>
<head>
<title><%=title%></title>
<% if (!call_function.equals("")){%><!-- Dont display currentencounter.jsp  -->
<iframe name='pline' id='pline' 	src="../../eCommon/jsp/pline.jsp?EncounterId=<%=encounter_id%>&Facility_Id=<%=facilityId%>" frameborder=0 scrolling=no style='height:8vh;width:98vw'></iframe>
<iframe name='LastAdmissionRes' id='LastAdmissionRes'  src='../jsp/MREncounter.jsp?call_function=<%=call_function%>&Filename=CurrentEncounterMain&LastDet=1&encounter_id=<%=encounter_id%>&patientId=<%=patientId%>&Patient_Class=<%=Patient_Class%>&facilityId=<%=facilityId%>'   frameborder=no scrolling=auto style='height:25vh;width:98vw'></iframe>
<iframe name='MRStayDet' id='MRStayDet'  src='../jsp/MRStayDetails.jsp?facilityId=<%=facilityId%>call_function=<%=call_function%>&Filename=CurrentEncounterMain&LastDet=1&encounter_id=<%=encounter_id%>&patientId=<%=patientId%>'  frameborder=no scrolling=auto style='height:60vh;width:98vw'></iframe>
<% } %>
	
</head>
</html>

