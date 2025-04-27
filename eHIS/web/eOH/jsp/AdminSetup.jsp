<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>

<html>
<head>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String params = request.getQueryString() ;
%>
</head>

<iframe src="../../eOH/jsp/OHAdminSetupFunctions.jsp?query_string=<%=params%>" name="master_menu" scrolling='yes' noresize></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages"></iframe>
</html>

