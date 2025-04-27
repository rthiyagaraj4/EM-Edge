<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*,eCA.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<% 
String title =request.getParameter("title")==null?"":request.getParameter("title");
%>
		<title><%=title%></title>
		</head>
<iframe src="../../eCA/jsp/IPConsultationListChargeDetails.jsp?<%=request.getQueryString()%>" name='IPConsultationListChargeDetailsFrame' scrolling = "no" noresize frameborder='0' style='height:100vh;width:100vw'></iframe>
		<iframe src="../../eCA/jsp/IPConsultationListChargeDetailsToolBar.jsp?<%=request.getQueryString()%>" name='IPConsultationListChargeDetailsToolBarFrame' scrolling = "no" noresize frameborder='0' style='height:12%;width:100vw'></iframe>
		

</html>

