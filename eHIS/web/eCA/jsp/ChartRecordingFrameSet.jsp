<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
21/01/2019      IN067541        Sivabagyam M       21/01/2019       Ramesh G        ML-MMOH-CRF-1159
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079  
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085  
%>
<!-- <title><fmt:message key="eCA.DefineChartScope.label" bundle="${ca_labels}"/></title>--><!--IN067541 -->
<title><fmt:message key="eCA.DefineChartCategory.label" bundle="${ca_labels}"/></title><!--IN067541 -->
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<iframe name="chartRecordingTopFrame" id="chartRecordingTopFrame" frameborder="0" scrolling="auto" noresize src="../../eCA/jsp/ChartRecordingCriteriaForAddingItems.jsp?<%=request.getQueryString()%>" style="height:87vh;width:92vw"></iframe>
<iframe name="chartRecordingBottomFrame" id="chartRecordingBottomFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/blank.jsp" style="height:41vh;width:97vw"></iframe>
<iframe name="blankFrame" id="blankFrame" frameborder="0" scrolling="no" noresize src="../../eCA/jsp/blank.jsp" style="height:0%;width:100vw"></iframe>


