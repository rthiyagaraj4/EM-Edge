<!DOCTYPE html>
 <%@page contentType="text/html; charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
 <!--This file is saved on 07/11/2005-->
<!--

	Created By		:	Nanda Kumar R.
	Created Date	:	04/12/2002
	Module ID		:	PH
	Function Name	:   Code Setup Jsp called from Menu

-->
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String params = request.getQueryString() ;

%>
</head>

<iframe src="../../ePH/jsp/PhCodeSetup.jsp?query_string=<%=params%>" name="master_menu" scrolling='no' noresize style="height:100vh;width:3vw"></iframe>
	<iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" style="height:100vh;width:15vw"></iframe>
</html>

