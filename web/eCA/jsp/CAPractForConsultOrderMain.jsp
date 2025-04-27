<!DOCTYPE html>

<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
	<title></title>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../js/CAConsultation.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<iframe name="CAPractForConsultHdr" id="CAPractForConsultHdr" src="../../eCA/jsp/CAPractForConsultOrderHdr.jsp?<%=request.getQueryString()%>" noresize scrolling='no' frameborder='0' style="height:27vh;width:100vw;"></iframe>
<iframe name="CAPractForConsultDtl" id="CAPractForConsultDtl" src="../../eCommon/html/blank.html" noresize scrolling='no'sss frameborder='0' style="height:72vh;width:100vw;"></iframe>
</html>

