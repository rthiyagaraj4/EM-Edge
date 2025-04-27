<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCA.PatientProfile.label" bundle="${ca_labels}"/></title>
</head>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id = request.getParameter("patient_id");
%>



<frameset rows='40,*,50'>
	<frame name="fraPatientinfo" src='../../eCA/jsp/PatientProfileHeader.jsp?patient_id=<%=patient_id%>' frameborder=0 scrolling="no" noresize>

	<frameset cols="200px,*">
		<frame name="fraPatientTree" src='../../eCA/jsp/PatientProfileTree.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="auto" noresize>
		<frame name="fraPatientContent" src='../../eCA/jsp/PatientProfileContent.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling="auto" noresize>

	</frameset>
	<frame name="fraActionButton" src="../../eCA/jsp/PatientProfileActionButton.jsp" frameborder=0 scrolling="no" noresize>
</frameset>

</html>
