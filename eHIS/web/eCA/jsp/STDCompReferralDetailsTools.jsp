<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.Tools.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
			String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCA/js/STDCompReferralDetails.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown='lockKey()'>
		<form name='refDetToolsForm' id='refDetToolsForm'>
			<table cellpadding='3' cellspacing='0' border='0' width='100%'>
				<tr><td width='25%'></td><td width='25%'></td><td width='25%'></td>
					<td width='25%'><input type='button' name='okBtn' id='okBtn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' class='button' onClick = "clickOK()" >&nbsp;<input type='button' name='cancelBtn' id='cancelBtn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onClick='closeWindow()'></td>
				</tr>
			<table>
			<input type='hidden' name='valOfBtn' id='valOfBtn' value=''>
		</form>
	</body>
</html>

