<!DOCTYPE html>
<html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>	
<jsp:useBean id="diagBean" class="eCP.PatientAssessmentDiag" scope="session"/>
	<head>
		<title>View Care Patient Assessment</title>
		<script src='../../eCP/js/ViewCarePlan.js language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
		String param = request.getQueryString();
		String source = url+param;
		diagBean.clearDiagBean();
	%>
	<frameset cols='11%,*' id='frID'>
		<frame name='patAssessmentResultFrame' id='patAssessmentResultFrame' src='../../eCP/jsp/ViewCarePlanPatAssmtResult.jsp?<%=source%>' frameborder='0' scrolling='auto'></frame>
		<frame name='patAssessmentMainFrame' id='patAssessmentMainFrame' src='../../eCP/jsp/ViewCarePlanPatAssmtFrames.jsp?<%=source%>' frameborder='0' scrolling='auto' id='framesId'></frame>
	<frameset>
</html>

