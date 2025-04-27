<!DOCTYPE html>
<%--
	FileName	: AMPractSetup.jsp
	Version	    : 3	
	Modified On	: 22-2-2005
--%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*" %>

<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String params = request.getQueryString() ;
	%>
	</head>

	<iframe src="AM_Pract_Setup.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize style='height:100vh;width:19vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" style='height:100vh;width:81vw'></iframe>
</html>


