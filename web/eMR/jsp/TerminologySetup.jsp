<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*" %>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
//	String source = url + params ;
%>
</head>

<iframe src="TerminologySetupMenu.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages"></iframe>
</html>

