<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.GroupButtons.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCA/js/ChartRecording.js'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%

			request.setCharacterEncoding("UTF-8");
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	</head>
	<body onKeyDown="lockKey()">
		<form name='ChartRecordingButtonsForm' id='ChartRecordingButtonsForm'>
			<table cellpadding='3' cellspacing='0' border='1' width='100%'>
				<tr>
					<td align='right'>
						<input type='button' class='button' name='grpButtonOK' id='grpButtonOK' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='closeWindow(this)' align='right'></input>
						<input type='button' class='button' name='grpButtonClose' id='grpButtonClose' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick='closeWindow(this)' align='right'></input>
					</td>
				</tr>
			</table>	
			<input type='hidden' name='forRetValue' id='forRetValue' value=''>
		</form>
	</body>
</html>

