<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" %>
<html>
<%@ page contentType="text/html;charset=UTF-8"%>	
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
	<frameset cols='11%,*' id='frID'>
		<frame name='patAssessmentResultFrame' id='patAssessmentResultFrame' src='../../eCP/jsp/PatientAssessmentResult.jsp?<%=source%>' frameborder='0' scrolling='auto'></frame>
		<frame name='patAssessmentMainFrame' id='patAssessmentMainFrame' src='../../eCP/jsp/PatientAssessmentFrames.jsp?<%=source%>' frameborder='0' scrolling='auto' id='framesId'></frame>
	<frameset>
</html>

