<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%> 
<%request.setCharacterEncoding("UTF-8");%>
<HTML>
<Head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<TITLE><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></TITLE>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</Head>
<iframe name='ResultEntryCultureTestPreview' id='ResultEntryCultureTestPreview' src='ResultEntryCultureTestPreview.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no style='height:100vh;width:100vw'></iframe><iframe name='ResultEntryCultureTestPreviewBtn' id='ResultEntryCultureTestPreviewBtn' src='ResultEntryCultureTestPreviewBtn.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no style='height:5%;width:100vw'></iframe>
</HTML>

