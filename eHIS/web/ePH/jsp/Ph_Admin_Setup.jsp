<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<!--

	Created By		:	Nanda Kumar R.
	Created Date	:	19/02/2003
	Module ID		:	PH
	Function Name	:   Admin Setup Jsp called from Menu

-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<html>
<head>
<%
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String params = request.getQueryString() ;
%>
</head>

<iframe src="../../ePH/jsp/PhAdminSetup.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize style="height:100vh;width:3vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" style="height:100vh;width:15vw"></iframe>
</html>

