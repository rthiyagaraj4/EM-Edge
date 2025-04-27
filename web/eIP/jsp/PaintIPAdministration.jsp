<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<head>
<%
	String params = request.getQueryString() ;
%>
</head>
<iframe src="../jsp/IPAdministration.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages"></iframe>
</html>

