<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String qs=request.getQueryString();
%>
<head>
	<title><fmt:message key="Common.ParagraphDefinition.label" bundle="${common_labels}"/></title>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
	<iframe name='templateParagraphMasterFrame' id='templateParagraphMasterFrame' src='../../eAM/jsp/DiscrMsrCompParagraphMaster.jsp?<%=qs%>' frameborder="no" scrolling="no" noresize style='height:80vh;width:95vw'></iframe>
	<iframe name='previewFrame' id='previewFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling=auto noresize style='height:0vh;width:95vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder="no" scrolling="auto" noresize style='height:6vh;width:95vw'></iframe>


