<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
	<head>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<iframe src='CASearchScreenFrmesDet.jsp?<%=request.getQueryString()%>' name='scrn1' noresize frameborder=0 style='height:100vh;width:100vw'></iframe><iframe src='CASearchScreenComp.jsp?<%=request.getQueryString()%>' name='scrn2' noresize frameborder=0 style='height:10%;width:100vw'></iframe><iframe src='../../eCommon/html/blank.html' name='messageFrame' id='messageFrame' noresize frameborder=0 style='height:0%;width:100vw'></iframe>		
	</head>	
</html>

