<!DOCTYPE html>
<!--

	Created On	: 6/7/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Code Setup Main
	
-->
<%@ page import ="java.sql.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	//String source = url + params ;
%>
<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<iframe src="FM_Code_Setup.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages"></iframe>
</html>


