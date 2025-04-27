<!DOCTYPE html>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartRecordingErrorList.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String queryStr = request.getQueryString() == null ? "" : request.getQueryString();
%>
		<script language='javascript' src='../../eCA/js/ChartRecording.js'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='chartRecErrorViewToolBarFrame' id='chartRecErrorViewToolBarFrame' src='../../eCA/jsp/ChartRecordingViewErrorResults.jsp?<%=queryStr%>' frameborder=0 noresize scrolling='auto' style='height:88vh;width:99vw'></iframe>
		<iframe name='chartRecErrorToolBarFrame' id='chartRecErrorToolBarFrame' src='../../eCA/jsp/ChartRecordingViewErrorTools.jsp' frameborder=0 noresize scrolling='no' style='height:5vh;width:99vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:2vh;width:99vw'></iframe> <!-- IN036093 -->
	
</html>

