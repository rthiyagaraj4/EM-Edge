<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
16/09/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<title>Sub Section Main</title>
<script language='javascript' src='../js/GlobalArray.js'></script>
<script language='javascript' src='../js/EncSummConfig.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<%
String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
%>
<iframe name="HeaderFrame" id="HeaderFrame" src="../../eCA/jsp/EncSummConfigHdr.jsp?mode=<%=mode%>" frameborder="0" scrolling ="no" noresize style="height:8%;width:100vw"></iframe>
	<iframe name="DetailsFrame" id="DetailsFrame" src="../../eCA/jsp/EncSummConfigFrameSet.jsp" frameborder="0" scrolling ="no" noresize style="height:100vh;width:100vw"></iframe>

<html>

