<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=ISO-8859-1"%>
<jsp:useBean id="diagBean" class="eCP.PatientAssessmentDiag" scope="session"/>
	<head>
		<title>View Care Plan Patient Assessment</title>
		<script src='../../eCP/js/PatientAssessment.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
//		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
//		String param = request.getQueryString();
//		String source = url+param;
		diagBean.clearDiagBean();
	%>
	<frameset rows='20%,50%,12%,50%,0%' id='framesID'>
		<frame name='patAssessmentAddModifyFrame' id='patAssessmentAddModifyFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='no' ></frame>
		<frame name='patAssessmentPhysicianNotesFrame' id='patAssessmentPhysicianNotesFrame' src='../../eCommon/html/blank.html' frameborder='0' borderColor = '#E2E3F0' border='1' scrolling='auto'></frame>
		<frame name='patAssessmentDependencyFrame' id='patAssessmentDependencyFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto'></frame>
		<frame name='patAssessmentDiagnosisFrame' id='patAssessmentDiagnosisFrame' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto'></frame>	
		<frame name='blankFrameStaDep' id='blankFrameStaDep' src='../../eCommon/html/blank.html' frameborder='0' scrolling='auto' noresize></frame>
		
	<frameset>
</html>

