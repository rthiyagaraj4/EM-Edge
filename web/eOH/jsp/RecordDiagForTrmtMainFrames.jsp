<!DOCTYPE html>
<%@ page contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>

<%
	String params = request.getQueryString() ;
	String window_title = request.getParameter("window_title") ;
%>
<html>
	<head>
		<title><%=window_title%></title>
		<script src="../../eOH/js/RecordDiagForTrmt.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<iframe name='RecordDiagForTrmtFrames' id='RecordDiagForTrmtFrames'	src='../../eOH/jsp/RecordDiagForTrmtFrames.jsp?<%=params%>' frameborder=0  noresize style='height:*%;width:100vw'></iframe>
		<iframe name='blank' id='blank'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling="no" style='height:0%;width:100vw'></iframe>
</html>

