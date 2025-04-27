<!DOCTYPE html>
<%@ page import ="java.sql.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
	String params = request.getQueryString() ;
%>
</head>

<iframe src="MP_Code_Setup_UM.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize style='height:3vh;width:100vw;border:0'></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" style='height:15vh;width:100vw;border:0'></iframe>
</html>


