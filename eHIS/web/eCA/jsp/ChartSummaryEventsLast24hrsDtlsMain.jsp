<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<title><%=request.getParameter("title")%></title>
<HEAD>
<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
String queryString = request.getQueryString();
%>
<iframe src="../../eCA/jsp/ChartSummaryEventsLast24hrs.jsp?<%=queryString%>" name='ChartSummaryEventsLast24hrsFrame' noresize style='height:100%;width:100vw'></iframe>
<iframe src="../../eCA/jsp/blank.jsp" noresize name='messageFrame' id='messageFrame'  style='height:0%;width:100vw'></iframe>

</html>

