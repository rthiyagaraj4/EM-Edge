<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------
Date			Edit History	Name        Description
-----------------------------------------------------------------------
09/11/2012		IN030473		Ramesh G	Bru-HIMS-CRF-032 								 
-----------------------------------------------------------------------
*/
%>
<%@page  import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
  <% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085  
  %>
<head>
	<title><fmt:message key="eCP.PatientInstructionsIntervention.label" bundle="${cp_labels}"/></title>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<iframe src="../../eOR/jsp/PatientInterventionsDetails.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 scrolling="auto" name="patientinterventions_details" noresize style="height:92vh;width:100vw"></iframe>
		<iframe src="../../eOR/jsp/PatientInterventionsButtons.jsp" frameborder=0  scrolling="no" name="patientinterventions_button" id="patientinterventions_button" noresize style="height:8vh;width:100vw"></iframe>		
	
</html>

