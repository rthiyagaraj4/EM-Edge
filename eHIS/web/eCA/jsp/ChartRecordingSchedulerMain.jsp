<!DOCTYPE html>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<iframe name="ChartRecordingSchedulerFrame" id="ChartRecordingSchedulerFrame" frameborder="1" scrolling="no" noresize src="../../eCA/jsp/ChartRecordingScheduler.jsp?<%=request.getQueryString()%>" style="height:92%;width:100vw"></iframe>
	<iframe name="ChartRecordingSchedulerToolBarFrame" id="ChartRecordingSchedulerToolBarFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/ChartRecordingSchedulerTool.jsp" style="height:8%;width:100vw"></iframe>


