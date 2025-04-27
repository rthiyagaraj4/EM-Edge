<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="JavaScript" src="../../eOR/js/HotSpot.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
String function_id=request.getParameter("function_id");
%>

</head>
	<iframe name='query' id='query' src='ImageHotspotAddModify.jsp?mode=1&function_id='<%=function_id%> framespacing='0' frameborder=0 border='none' scrolling='no' noresize style="height:18vh;width:98vw"></iframe>
	<iframe name='result' id='result' src='../../eCommon/html/blank.html' framespacing='0'  frameborder=0 scrolling='no' noresize style="height:81vh;width:98vw"></iframe>
	
</html>

