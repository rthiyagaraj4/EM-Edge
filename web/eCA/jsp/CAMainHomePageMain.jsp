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
<iframe src="../../eCA/jsp/CAMainHomePageTree.jsp" noresize scrolling="auto" name="SummeryTree" id="SummeryTree" frameborder=1></iframe><iframe src="../../eCommon/html/blank.html" noresize scrolling="auto" name="dispFunction" id="dispFunction" frameborder=0></iframe>	
</html>

