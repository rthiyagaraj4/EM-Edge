<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
 -->	
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String params = request.getQueryString() ; //Added for Bru-HIMS-CRF-073.1 [IN:047222]
%>
<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
 <script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
		<iframe name="reg_prescriptions_query" id="reg_prescriptions_query" frameborder="0" scrolling="no" noresize  src="../../ePH/jsp/RegPrescriptionsQueryCriteria.jsp?<%=params%>" style="height:21vh;width:100vw"></iframe>
		<iframe name="reg_prescriptions_header" id="reg_prescriptions_header" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/RegPrescriptionsHeaderFrame.jsp"  style="height:79vh;width:100vw"></iframe>
</html>

