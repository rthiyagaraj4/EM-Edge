<!DOCTYPE html>
<%@ page import ="java.sql.*" %>

<html>
<head>
<%
	String params = request.getQueryString() ;
%>
</head>

<iframe src="RSMaster_Code_Setup.jsp?query_string=<%=params%>" name="master_menu" id="master_menu" scrolling='no' noresize style="height:3vh;width:100vw"></iframe>
<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" style="height:15vh;width:100vw"></iframe>
</html>

