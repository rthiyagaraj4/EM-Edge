<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title></title>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
			<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCA/js/CASectionTemplateMessage.js"></script>
		
        <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
	<form name="CASectionTemplateMessageHeaderForm" id="CASectionTemplateMessageHeaderForm">
		<!--<table align='center' border='1' width='100%' cellpadding='3' cellspacing='0'>
			<tr>
				<td class='columnHeadercenter' width='75%'><fmt:message key="Common.Message.label" bundle="${common_labels}"/></td>
				<td class='columnHeadercenter' width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
			</tr>
		</table>-->
	</form>
	</body>
</html>

