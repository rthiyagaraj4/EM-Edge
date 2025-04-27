<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<title><%=request.getParameter("event_desc")%></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String queryString = request.getQueryString() == null ? "" : request.getQueryString();
		%>
		<script language='javascript' src='../../eCA/js/ChartRecording.js'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='viewResultLinkFrame' id='viewResultLinkFrame' src='../../eCA/jsp/ViewLabWordResultLink.jsp?<%=queryString%>' frameborder=0 noresize scrolling='no' style='height:25%;width:100vw'></iframe>
		<iframe name='viewResultDataFrame' id='viewResultDataFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0%;width:100vw'></iframe>
		<iframe name='viewResultToolbarFrame' id='viewResultToolbarFrame' src='../../eCA/jsp/ViewLabWordResultToolbar.jsp' frameborder=0 noresize scrolling='no' style='height:5%;width:100vw'></iframe>
	
</html>

