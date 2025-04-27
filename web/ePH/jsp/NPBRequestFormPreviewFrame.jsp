<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<title><fmt:message key="ePH.NPBRequestForm.label" bundle="${ph_labels}"/></title>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
%>
	<iframe name="NPBReqForm" id="NPBReqForm" src="../../ePH/jsp/NPBRequestFormPreview.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="auto" noresize  style="height:90vh;width:100vw"></iframe><iframe name="NPBReqFormButton" id="NPBReqFormButton"   src="../../ePH/jsp/NPBRequestButtons.jsp?<%=request.getQueryString()%>" frameborder="none" border="none" scrolling="no" noresize style="height:10vh;width:100vw"></iframe> 
	
</html>

