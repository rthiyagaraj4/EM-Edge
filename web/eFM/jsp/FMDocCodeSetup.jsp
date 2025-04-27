<!DOCTYPE html>
<!--
	Created On	: 24/8/2004
	Created By	: Kiran K K
	Module		: File Management (FM)
	Function	: Document Code Setup Main	
-->
<%@ page import ="java.sql.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
//	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
//	String source = url + params ;
%>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<iframe src="FM_Doc_Code_Setup.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages"></iframe>
</html>

