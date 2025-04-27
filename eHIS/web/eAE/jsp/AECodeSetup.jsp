<!DOCTYPE html>
<%@ page import ="java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src='../eCommon/js/common.js' language='javascript'></script>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String params = request.getQueryString() ;
%>
</head>

<iframe src="../../eAE/jsp/AE_Code_Setup.jsp?query_string=<%=params%>" name="master_menu" id="master_menu" scrolling='no' noresize style="height:3vh;width:100vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" scrolling='no' noresize style="height:15vh;width:100vw"></iframe>

</html>

