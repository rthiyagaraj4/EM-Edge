<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
	<head>
		<script src="../../eCA/js/ResearchPatient.js"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<iframe name="ResearchPatientQueryframe" id="ResearchPatientQueryframe" src='../../eCA/jsp/ResearchPatientQueryResult.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="yes" noresize style='height:35vh;width:100vw'></iframe>
		<iframe name="ResearchPatientRecordframe" id="ResearchPatientRecordframe" src="../../eCA/jsp/ResearchPatientRecord.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling="no" noresize style="height:100vh;width:100vw"></iframe>
	
</html>


