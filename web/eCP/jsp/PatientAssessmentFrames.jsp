<!DOCTYPE html>
<html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="diagBean" class="eCP.PatientAssessmentDiag" scope="session"/>
	<head>
		<title><fmt:message key="eCP.PatientAssessment.label" bundle="${cp_labels}"/></title>
		<script src='../../eCP/js/PatientAssessment.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	//This file is saved on 18/10/2005.
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
		String param = request.getQueryString();
		String source = url+param;
		diagBean.clearDiagBean();
	%>
	<frameset rows='8%,75%,8%,40%,5%,0%' id='framesID'>
		<frame name='patAssessmentAddModifyFrame' id='patAssessmentAddModifyFrame' src='../../eCP/jsp/PatientAssessmentAddModify.jsp?<%=source%>' frameborder='0' scrolling='no' ></frame>
		<frame name='patAssessmentPhysicianNotesFrame' id='patAssessmentPhysicianNotesFrame' src='../../eCommon/html/blank.html' frameborder='1' borderColor = '#E2E3F0' border='1' scrolling='auto'></frame>
		<frame name='patAssessmentDependencyFrame' id='patAssessmentDependencyFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='no'></frame>
		<frame name='patAssessmentDiagnosisFrame' id='patAssessmentDiagnosisFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto'></frame>
		<frame name='patAssessmentButtonsFrame' id='patAssessmentButtonsFrame' src='../../eCP/jsp/PatientAssessmentRecordButton.jsp?<%=source%>' frameborder='0' scrolling='NO'></frame>
		<frame name='blankFrameStaDep' id='blankFrameStaDep' src='../../eCP/jsp/PatientAssessmentStatusDepend.jsp?<%=source%>' frameborder='0' scrolling='no' noresize></frame>
		<!-- <frame name='patAssessDescFrame' id='patAssessDescFrame' src='../../eCP/jsp/PatientAssessmentIntermediate.jsp?<%=source%>' frameborder='0' scrolling='no' noresize></frame> -->
		<!-- <frame name='blankFrameDiagIntermediate' id='blankFrameDiagIntermediate' src='../../eCP/jsp/PatientAssessmentDiagIntermediate.jsp?<%=source%>' frameborder='0' scrolling='auto' noresize></frame> -->
	<frameset>
</html>

