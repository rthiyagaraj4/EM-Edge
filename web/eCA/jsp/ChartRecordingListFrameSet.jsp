<!DOCTYPE html>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<title><fmt:message key="eCA.ChartEvents.label" bundle="${ca_labels}"/></title>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<iframe name="chartRecordingListTopFrame" id="chartRecordingListTopFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/ChartRecordingListText.jsp?<%=request.getQueryString()%>" style="height:100vh;width:100vw"></iframe>
<iframe name="chartRecordingListBottomFrame" id="chartRecordingListBottomFrame" frameborder="0" scrolling="auto" noresize src="../../eCA/jsp/ChartRecordingCriteriaForAddingItems.jsp?<%=request.getQueryString()%>" style="height:0%;width:100vw"></iframe>


