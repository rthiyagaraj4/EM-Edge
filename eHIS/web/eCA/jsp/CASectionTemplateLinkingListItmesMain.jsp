<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String qs=request.getQueryString();
%>
<head>
	<title><fmt:message key="eCA.LinkingListItems.label" bundle="${ca_labels}"/></title>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
</head>
<iframe name='templateLinkingListItemsFrame' id='templateLinkingListItemsFrame' src='../../eCA/jsp/CASectionTemplateLinkingListItems.jsp?<%=qs%>' frameborder="no" scrolling="auto" noresize style='height:100vh;width:100vw'></iframe>
	<iframe name='templateLinkingListToolbarFrame' id='templateLinkingListToolbarFrame'	 src='../../eCA/jsp/CASectionTemplateLinkingListToolbar.jsp?<%=qs%>' frameborder=0 scrolling="no" noresize style='height:7%;width:100vw'></iframe>


