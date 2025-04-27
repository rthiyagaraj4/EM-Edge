<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<title><%=request.getParameter("title")%></title>
	<head>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language="javascript" src="../js/SectionTemplate.js"></script>
		<script language='javascript' src='../js/CASectionTemplateMessage.js'></script>
        <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='Header' id='Header' src='../../eCA/jsp/CASectionTemplateMessageHeader.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no' style='height:2vh;width:99vw'></iframe>
	<iframe name='Result' id='Result' src='../../eCA/jsp/CASectionTemplateMessageLists.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='auto' style='height:74vh;width:99vw'>
	</iframe><iframe name='AddModify' id='AddModify' src='../../eCA/jsp/CASectionTemplateMessageAddModify.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no'  style='height:18vh;width:99vw'></iframe>
</html>

