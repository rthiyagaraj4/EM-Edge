<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../js/QueryNoteTemplate.js'></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
String QueryString = request.getQueryString() ;	
%>
	<iframe name='QueryTemplateHeader' id='QueryTemplateHeader'	src='../../eCA/jsp/QueryNoteTemplateHeader.jsp?<%=QueryString%>' frameborder=0 noresize scrolling='no' style='height:22vh;width:100vw'></iframe><iframe name='QueryTemplateDetail' id='QueryTemplateDetail'	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:78vh;width:100vw'></iframe>
</html>

