<!DOCTYPE html>
<%--
	FileName	: AM_Statistics_Setup.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
	
%>
</head>

<iframe src="AMStatisticsSetup.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages"></iframe>
</html>

