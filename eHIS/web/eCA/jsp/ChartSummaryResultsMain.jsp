<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,org.apache.commons.codec.binary.Base64,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString = request.getQueryString() == null ? "" : request.getQueryString();
	String title= request.getParameter("title")==null?"":request.getParameter("title");
	if("Y".equals(request.getParameter("compressed")==null?"":request.getParameter("compressed"))) //27788
		queryString = new String(Base64.decodeBase64(((String)request.getParameter("parameterStringValues")).getBytes())); //27788
%>
<html>
	<head>
		<title><%=title%></title>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name="viewsFrame" id="viewsFrame" src="ChartSummaryResults.jsp?<%=queryString%>" scrolling="auto" noresize marginheight=0 marginwidth=0 frameborder='0' style='height:100vh;width:100vw'></iframe>
		<iframe name="closeGroupFrame" id="closeGroupFrame" src="../../eCA/jsp/ChartSummaryResultsGraphToolbar.jsp?<%=queryString%>" scrolling="no" noresize marginheight=0 marginwidth=0 frameborder='0' style='height:5%;width:100vw'></iframe>
		<iframe name="messageFrame" id="messageFrame" frameborder="0" scrolling="no" noresize src="../../eCommon/jsp/error.jsp" style="height:0%;width:100vw"></iframe>
	
</html>

