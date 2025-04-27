<!DOCTYPE html>

<!-- this file to be deleted later -->

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<head>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/EMail.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<body onKeyDown="lockKey()">
	<table align='center'>
	<tr>
	<h1>
	<td class='label' align='center'><a href="#" onclick="openEmail('AE','AEBSTAT')" ><h1>Email</h1></a><td>
	</h1>
	</tr>
	</table>
	</body>

</head>

</html>

