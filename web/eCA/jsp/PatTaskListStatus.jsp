<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");	
String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body onKeyDown='lockKey()'>
		<form>
			<table border="1" cellpadding='0' cellspacing='0'   id='tableId' width="100%"  >
			<tr>
				<td width='50%'>&nbsp;</td>
				<td width='10%' align='center' style='background:#CCFFCC' class='label'><font size='1'>&nbsp;<fmt:message key="Common.Due.label" bundle="${common_labels}"/></font></td>
				<td width='10%' align='center'  style='background:#FFFFCC'><font size='1'>&nbsp;<fmt:message key="Common.Overdue.label" bundle="${common_labels}"/></font></td>
				<td width='10%' align='center'  style='background:#D5006A'><font size='1'>&nbsp;<fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></font></td>
				<td width='10%' align='center'  style='background:#0099FF'><font size='1'>&nbsp;<fmt:message key="Common.Performed.label" bundle="${common_labels}"/></font></td>
				<td width='10%' align='center'  style='background:#FFCCCC'><font size='1'>&nbsp;<fmt:message key="Common.Future.label" bundle="${common_labels}"/></font></td>
				
			<tr>
			</form>
		</body>
	</html>

