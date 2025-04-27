<!DOCTYPE html>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.URL"%>
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %> 

<%
response.setHeader("Access-Control-Allow-Origin", "*");
response.setContentType("application/pdf;charset=UTF-8");

String urlStr = (String)session.getAttribute("TabIASelectedReportURL");

URL url = new URL(urlStr);
InputStream in = url.openStream();
response.setContentType("application/pdf");

OutputStream responseOutputStream = response.getOutputStream();
int bytes;
while ((bytes = in.read()) != -1) {
	responseOutputStream.write(bytes);
}

%>
