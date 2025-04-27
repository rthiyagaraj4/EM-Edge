<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?			?				?				?				?				?
25/01/2016	IN058139		Ramesh G										INT-CRF-BRU-CIS-005-US001
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
%>
<html>
	<head>
		<title><fmt:message key="eCA.Graphs.label" bundle="${ca_labels}"/></title>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name="viewsFrame" id="viewsFrame" src="ChartSummaryResultsGraph.jsp?<%=queryString%>" scrolling="auto" noresize marginheight=0 marginwidth=0 frameborder='0' style='height:68vh;width:100vw'></iframe>
		<iframe name="closeGroupFrame" id="closeGroupFrame" src="../../eCA/jsp/ChartSummaryResultsGraphToolbar.jsp?<%=queryString%>" scrolling="no" noresize marginheight=0 marginwidth=0 frameborder='0' style='height:5%;width:100vw'></iframe>
		<iframe SRC="../../eCommon/html/blank.html" name="blank_frame" id="blank_frame" scrolling=no noresize marginheight=0 marginwidth=0 frameborder='0' style='height:0%;width:100vw'></iframe>
</html>

