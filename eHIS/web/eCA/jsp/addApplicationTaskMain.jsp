<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title><fmt:message key="Common.Tasks.label" bundle="${common_labels}"/></title>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
			<iframe src="../../eCA/jsp/addApplicationTaskSearch.jsp" noresize scrolling="no" name="searchFrame" id="searchFrame" frameborder=0 style="height:17vh;width:100vw"></iframe>
			<iframe src="../../eCA/jsp/addApplicationTask.jsp" noresize scrolling="auto" name="dispFrame" id="dispFrame" frameborder=0 style="height:82vh;width:100vw"></iframe>	
</html>

