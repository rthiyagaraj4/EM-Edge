<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html> 
<title><%=request.getParameter("title")%></title>
<HEAD>
	<script src="../../eCommon/js/common.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
String queryString = request.getQueryString();
%>
<iframe src="../../eCA/jsp/ChartSummaryCareFlowsheetD.jsp?<%=queryString%>" name='ChartSummaryCareFlowsheetDtlsFrame' noresize style='height:100vh;width:100vw'></iframe>
<iframe src="../../eCA/jsp/blank.jsp" noresize name='messageFrame' id='messageFrame'  style='height:0%;width:100vw'></iframe>

</html>

