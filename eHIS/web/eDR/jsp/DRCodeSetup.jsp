<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	String params = request.getQueryString();
%>
</head>
	<iframe src="DR_Code_Setup.jsp?query_string=<%=params%>" name="master_menu" id="master_menu" scrolling='no' noresize style='height:100vh;width:4vw;border:0'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" style='height:100vh;width:15vw;border:0'></iframe>
</html>


