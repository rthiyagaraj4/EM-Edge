<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
<% 
	String mode = request.getParameter("mode");	
%>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<iframe name='EncSummGroupCompFrame' id='EncSummGroupCompFrame' src='../../eCA/jsp/EncSummGroupCompHeader.jsp?mode=<%=mode%>' frameborder=0  scrolling='no' style='height:7%;width:100vw'></iframe>
		<iframe name='componentsFrame' id='componentsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:88%;width:100vw'></iframe>
		<iframe name='addCompsFrame' id='addCompsFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
		<iframe name='BlankFrame' id='BlankFrame' src='../../eCommon/html/blank.html' frameborder=0 style='height:0%;width:100vw'></iframe>		
	
</html>

