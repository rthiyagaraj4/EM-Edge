<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*" %>
<html>
<head>
<%
	String params = request.getQueryString() ;
%>
</head> 

<iframe src="../../eSS/jsp/CodeSetupMenu.jsp?<%=params%>" name="master_menu" noresize scrolling='no'></iframe><iframe src="../../eCommon/html/blank.html" name="master_pages" id="master_pages" scrolling='no' noresize></iframe>

</html>

