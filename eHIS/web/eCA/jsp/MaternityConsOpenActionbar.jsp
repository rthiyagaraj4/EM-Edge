<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<title><fmt:message key="eCA.SectionTemplateToolbar.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCA/js/MaternityConsTree.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<center>
			<form name='RecMaternityConsEvents' id='RecMaternityConsEvents' action=''>
				<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
					<tr><td  class="label" width='25%'></td><td  class="label" width='25%'></td><td  class="label" width='25%'></td>
					<td  class="fields" width='25%'>
					&nbsp;
					</td></tr>
				</table>
			</form>
		</center>
	</body>
</html>

