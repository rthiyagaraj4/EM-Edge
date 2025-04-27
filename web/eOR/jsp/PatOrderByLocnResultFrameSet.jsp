<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head><title>Patient Order by Location</title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<iframe name="PatOrderByLocnTree" id="PatOrderByLocnTree" src="../../eOR/jsp/PatOrderByLocnTree.jsp?<%=request.getQueryString()%>" frameborder=0 scrolling=auto noresize style="height:90vh;width:100vw"></iframe>
	<iframe name="PatOrderByLocnSearchResult" id="PatOrderByLocnSearchResult" src="../../eCommon/html/blank.html" frameborder=0 scrolling=no noresize style="height:10vh;width:100vw"></iframe>

</html>

