<!DOCTYPE html>
<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =

		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
	<body  onKeyDown="lockKey()">
	<form>
		<table align='right'><tr><td align='right'><input type='button' class='button' value='Close' onclick=window.close()></td></tr></table>
	</form>
	</body>
</html>

