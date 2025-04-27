<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

//			String modevalue = request.getParameter("modeValue") == null ? "" : request.getParameter("modeValue");
		%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<title><fmt:message key="eCA.SectionTemplateToolbar.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCA/js/RecMaternityCons.js'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
		<form name='recMaternityPendingTasksToolbarForm' id='recMaternityPendingTasksToolbarForm'>
			<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
				<tr>
					<td align='right'>
						<input type="button" class="BUTTON" name="Record" id="Record" onclick='recordForcedClose()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>'>
						<input type="button" class="BUTTON" name="close" id="close" onclick='window.close()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'>
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

