<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
request.setCharacterEncoding("UTF-8");
String mode="";
mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
//out.println("mode="+mode);
String qs = request.getQueryString();%>
<HTML>
<HEAD>
<TITLE><fmt:message key="Common.MatrixDefinition.label" bundle="${common_labels}"/></TITLE>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</HEAD>
<iframe id = "templateComponentRowColDefFrame" name = "templateComponentRowColDefFrame" src="../../eAM/jsp/DiscrMsrCompMatrixDef.jsp?<%=mode%>&<%=qs%>" noresize frameborder="no" scrolling="auto" style='height:13vh;width:100vw' ></iframe>
	<iframe id = "templateComponentMatrixAddModifyFrame" name = "templateComponentMatrixAddModifyFrame" src="../../eCommon/html/blank.html?" noresize frameborder="no" scrolling="auto" style='height:44vh;width:100vw' ></iframe>
	<iframe id = "templateComponentMatrixPreviewFrame" name="templateComponentMatrixPreviewFrame" id="templateComponentMatrixPreviewFrame" src="../../eCommon/html/blank.html" noresize frameborder="no" scrolling="auto" style='height:24.5vh;width:100vw' ></iframe>
	<iframe name="matrixToolbarFrame" id="matrixToolbarFrame" src='../../eAM/jsp/DiscrMsrCompMatrixToolbar.jsp?<%=qs%>' frameborder="no" scrolling="auto" noresize style='height:7.5vh;width:100vw'></iframe>
	<iframe name='messageframe' id='messageframe' src='../../eCommon/jsp/error.jsp' frameborder="no" scrolling="auto" noresize style='height:11vh;width:100vw'></iframe>

</HTML>

