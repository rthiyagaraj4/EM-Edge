<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
	String qs=request.getQueryString();	
%>

<HTML>
<HEAD>
<TITLE><fmt:message key="Common.GridComponentDefinition.label" bundle="${common_labels}"/></TITLE>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<iframe name='templateGridPreviewFrame' id='templateGridPreviewFrame' src='../../eCommon/html/blank.html' frameborder="no" scrolling="auto" noresize style='height:30vh;width:100vw'></iframe>	
	<iframe name='templateGridListFrame' id='templateGridListFrame' src='../../eAM/jsp/DiscrMsrCompGridList.jsp?<%=qs%>' frameborder="no" scrolling="auto" noresize style='height:30vh;width:100vw'></iframe>
	<iframe name='templateGridDefFrame' id='templateGridDefFrame' src='../../eAM/jsp/DiscrMsrCompGridDef.jsp?<%=qs%>' frameborder="no" scrolling="no" noresize style='height:30vh;width:100vw'></iframe>
	<iframe name='messageframe' id='messageframe' src='../../eCommon/jsp/error.jsp' frameborder="no" scrolling="auto" noresize style='height:10vh;width:100vw'></iframe>

</HTML>

