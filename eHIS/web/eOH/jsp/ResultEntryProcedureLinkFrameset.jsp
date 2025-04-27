<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<title><fmt:message key="eOR.ProcedureLink.label" bundle="${or_labels}"/></title>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<iframe name="proc_detail" id="proc_detail" src="../../eOH/jsp/ResultEntryProcedureLink.jsp?<%=request.getQueryString()%>" frameborder=0  marginheight=0 marginwidth=0 scrolling="auto" noresize style="height:100vh;width:100vw"></iframe>
		<iframe src="../../eOH/jsp/ResultEntryProcedureBtn.jsp?<%=request.getQueryString()%>" frameborder=0  scrolling="no" name="proc_btn" noresize style="height:7%;width:100vw"></iframe>
				


</html>

