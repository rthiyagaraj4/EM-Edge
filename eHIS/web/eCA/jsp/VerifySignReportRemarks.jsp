<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
	<title>Remarks</title>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/VerifySignReports.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
	<%
		String remarks = request.getParameter("remarks") == null ? "" : request.getParameter("remarks");
		String mode = request.getParameter("mode") == null ? "" : request.getParameter("mode");
	%>
		<form name='SignRepRemarkForm' id='SignRepRemarkForm'>
				<table border=0 cellpadding=3 cellspacing=0 width='100%' height='100%'>
					<tr>
						<td><textarea name='remarks' value="" rows=5 cols=62 value=''><%=remarks%></textarea></td>
					</tr>
					<tr>
						<td align='right'><input type='button' name='ok' id='ok' class='button' onclick='ClickOK()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>'>
						<input type='button' name='cancel' id='cancel' class='button' onclick="ClickCancel('<%=mode%>')" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'></td>
					</tr>
				</table>
		</form>
	</body>
</html>

