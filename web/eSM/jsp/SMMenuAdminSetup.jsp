<!DOCTYPE html>
<%@ page import ="java.sql.*" contentType="text/html;charset=UTF-8"%>

<html>
<head>
<%
	
	String params = request.getQueryString() ;

%>
</head>
<iframe src="../../eSM/jsp/SM_Menu_Admin_Setup.jsp?query_string=<%=params%>" name="master_menu" id="master_menu" noresize style='height:3vh;width:100vw'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" scrolling='no' noresize style='height:15vh;width:100vw'></iframe>

</html>

