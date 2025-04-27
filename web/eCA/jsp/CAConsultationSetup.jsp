<!DOCTYPE html>
<%@ page import ="java.sql.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String params = request.getQueryString() ; 
%>
</head>

<iframe src="CA_Consultation_Specific_Setup.jsp?query_string=<%=params%>" name="cc_master_menu" scrolling='no' noresize></iframe>
	<iframe src="../../eCommon/html/blank.html" name="cc_master_pages" id="cc_master_pages"></iframe>
</html>


