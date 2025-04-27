<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.io.*,java.util.*"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<%
	try {
%>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
				|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
				.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css' />
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language='javascript' src='../../eBL/js/BLAutoBillGenJobStatus.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"
	onSelect="codeArrestThruSelect();">
	<form name='autoBillGenJobStatusBtnForm' id='autoBillGenJobStatusBtnForm'>
		<table border='0' cellpadding='3' cellspacing='0' align='center'
			width='100%'>
			<tr>
				<td class='button' width="100%"><input type='button'
					name="export_button" id="export_button" value="Export" class='button'
					onClick='downloadExcel()' disabled></td>
			</tr>
		</table>

	</form>
</body>
<%
	} catch (Exception e) {
		System.out
				.println("Main Exception in AddlServChargDtlsBtn page:"
						+ e);
	}
%>
</html>

