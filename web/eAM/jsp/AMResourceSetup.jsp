<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*" %>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
%>
</head>

<iframe src="AM_Resource_Setup.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize style='height:100vh;width:19vw'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" style='height:100vh;width:81vw'></iframe>
</html>


