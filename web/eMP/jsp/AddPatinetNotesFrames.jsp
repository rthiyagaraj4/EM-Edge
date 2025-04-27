<!DOCTYPE html>
<%@ page import ="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String patient_id = request.getParameter("patientid")== null?"":request.getParameter("patientid");
	String encounter_id = request.getParameter("encounter_id")== null?"":request.getParameter("encounter_id");
	String visit_date_time = request.getParameter("visit_date_time")== null?"":request.getParameter("visit_date_time");
	String TOOL_TIP_TEXT = request.getParameter("visit_date_time")== null?"":request.getParameter("TOOL_TIP_TEXT");



%>
<html>
<head>
<title><%=TOOL_TIP_TEXT%></title>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<iframe name="DisplayPatientNotes" id="DisplayPatientNotes" src="../../eMP/jsp/DisplayPatientNotes.jsp?patientid=<%=patient_id%>"  marginheight=0 marginwidth=0 scrolling="no" style="height:80vh;width:100vw;border:0"></iframe>
<iframe name="PatientNotes" id="PatientNotes" src="../../eMP/jsp/AddPatientNotes.jsp?patientid=<%=patient_id%>&encounter_id=<%=encounter_id%>&visit_date_time=<%=visit_date_time%>"  marginheight=0 marginwidth=0  noresize scrolling="no" style="height:18vh;width:100vw;border:0"></iframe>
<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling=auto style='height:2vh;width:100vw;border:0'></iframe>

</html>

