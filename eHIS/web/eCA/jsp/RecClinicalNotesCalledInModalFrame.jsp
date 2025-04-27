<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title><fmt:message key="eCA.RecordingClinicalNotes.label" bundle="${ca_labels}"/></title>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<iframe name="workAreaFrame" id="workAreaFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/RecClinicalNotes.jsp?<%=request.getQueryString()%>" style="height:90%;width:100vw"></iframe>
		<iframe name="messageFrame" id="messageFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/jsp/error.jsp" style="height:10%;width:100vw"></iframe>
	
</head>
</html>

