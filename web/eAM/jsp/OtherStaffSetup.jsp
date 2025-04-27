<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*" %>

<html>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
<%
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString() ;
%>
</head>

<iframe src="Other_Staff_Setup.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize style='height:100vh;width:19vw'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" style='height:100vh;width:81vw'></iframe>
</html>


