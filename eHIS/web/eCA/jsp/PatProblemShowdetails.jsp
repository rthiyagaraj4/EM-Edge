<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCA.ProblemDetails.label" bundle="${ca_labels}"/></title>	
	<head>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String params = request.getQueryString() ;
%>
<iframe name="ProblemsDetailsFrame" id="ProblemsDetailsFrame" src="../../eCA/jsp/ProblemsDetails.jsp?<%=params%>" frameborder='0' scrolling='no' noresize ></iframe><iframe name="ProblemsAssessmentFrame" id="ProblemsAssessmentFrame" src="../../eCA/jsp/ProblemsAssessment.jsp?<%=params%>" frameborder='0' scrolling='no' noresize ></iframe>
</html>

