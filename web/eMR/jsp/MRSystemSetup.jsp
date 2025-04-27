<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*" %>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
//	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
//	String source = url + params ;
%>
</head>

<iframe src="../../eMR/jsp/MR_System_Setup.jsp?query_string=<%=params%>" name="master_menu" noresize></iframe>
	<iframe src="../../eCommon/html/blank.html" name="system_pages" id="system_pages" scrolling='no' noresize></iframe>

</html>

