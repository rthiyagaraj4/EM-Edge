<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/VerifySignReports.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
		<form name='SignRepBtnForm' id='SignRepBtnForm'>
			<table cellpadding=3 cellspacing=0 width="100%" align='center' border='0'>
				<tr>
					<td class=BODYCOLORFILLED align=right>
						<input type="button" class=button name='sign' id='sign'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")%>' onClick="callVerifyProc()">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>

