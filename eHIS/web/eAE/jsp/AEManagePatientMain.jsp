<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
String height1 = "12vh";
String height2 = "87vh";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	  <script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<%if(function_id.equals("AE_MANAGE_PATIENT")){
	height1 = "12vh";
	height2 = "88vh";
%>
<!-- <frameset rows='12%,*' id='AECurEmerFrameset'> -->

<%}if(function_id.equals("AE_CHECK_OUT")){
%>
<!-- <frameset rows='13%,*' id='AECurEmerFrameset'> -->
<%}%>
	<iframe name='AEMPSearchCriteriaFrame' id='AEMPSearchCriteriaFrame' src='../../eAE/jsp/AEMPSearchCriteria.jsp?<%=request.getQueryString()%>&function_id='<%=function_id%>'' frameborder=0 scrolling='no' noresize style='height:20vh;width:100vw'></iframe>
	<iframe name='AEMPSearchResultFrame' id='AEMPSearchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:80vh;width:100vw'></iframe>
	
<!-- </frameset> --> 
</html> 
