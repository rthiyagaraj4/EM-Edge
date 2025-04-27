<!DOCTYPE html>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<title><fmt:message key="Common.Calendar.label" bundle="${common_labels}"/></title>
<script src='../../eCommon/js/dchk.js' language='javascript'></SCRIPT>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<iframe name="ChartRecordingDiaryCalendarFrameTop" id="ChartRecordingDiaryCalendarFrameTop" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/ChartRecordingDiaryTop.jsp?<%=request.getQueryString()%>" style="height:16%;width:100vw"></iframe>
<iframe name="ChartRecordingDiaryCalendarFrameBottom" id="ChartRecordingDiaryCalendarFrameBottom" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/blank.jsp" style="height:100vh;width:100vw"></iframe>
<iframe name="blankFrame" id="blankFrame" frameborder="0" scrolling="yes" noresize src="../../eCA/jsp/blank.jsp" style="height:0%;width:100vw"></iframe>


