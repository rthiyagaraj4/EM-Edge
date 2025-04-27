<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="ePH.MedicationPlanSheet.label" bundle="${ph_labels}" /></title>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
 <%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
 String params = request.getQueryString() ;
 %>
	<iframe name="f_medication_plan" id="f_medication_plan" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/MedicationPlanner.jsp?<%=params%>" style="height:95vh;width:100vw"></iframe>
	<iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/MstCodeError.jsp" frameborder="0" noresize scrolling="auto" style="height:5vh;width:100vw"></iframe>
</html>

