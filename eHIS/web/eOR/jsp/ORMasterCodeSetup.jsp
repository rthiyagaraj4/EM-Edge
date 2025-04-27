<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
//	String source = url + params ;
%>
</head>

<iframe src="ORMaster_Code_Setup.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize style="height:50vh;width:100vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" style="height:50vh;width:100vw"></iframe>
</html>


