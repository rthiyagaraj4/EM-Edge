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
<script language='javascript' src='../../eCA/js/MultiTransRequest.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<iframe src="../../eCA/jsp/MultiTransRequestCriteria.jsp?<%=request.getQueryString()%>" name='MultiTransRequestCriteriFrame' scrolling = "no" noresize  frameborder='0' style='height:25vh;width:100vw'></iframe>
		<iframe src="../../eCommon/html/blank.html" name='MultiTransRequestResultFrame' id='MultiTransRequestResultFrame' scrolling = "auto" noresize  frameborder='0' style='height:58vh;width:100vw'></iframe>
		<iframe src="../../eCA/jsp/MultiTransRequestToolbar.jsp?<%=request.getQueryString()%>" name='MultiTransRequestToolbarFrame' scrolling = "no" noresize  frameborder='0' style='height:36vh;width:100vw'></iframe>

</html>

