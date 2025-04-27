<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>

<html>
<head>
<%
//	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	//String source = url + params ;
%>
</head>

<iframe src="../../eOH/jsp/OHCodeSetupFunctions.jsp?query_string=<%=params%>" name="master_menu" scrolling='yes' noresize></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages"></iframe>
</html>

