<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
	Developed by 		:	C.Rammohan
	Created on 			:	16/09/2006
	Module				    :	Confirm Transactions for Finalize : V3....
	Function			    :	This function is used to display the Confirmation Page for Finalizing the Transaction Screens (V3).. .
-->
<%@page import="java.util.*, eSS.Common.*, eSS.*,java.util.*,java.sql.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<title><fmt:message key="eSS.ConfirmFinalize.label" bundle="${ss_labels}"/></title>
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad='document.getElementById("yes").focus();'>
<form name='ConfirmTransactionForm' id='ConfirmTransactionForm' method='post'>

	<table border=0 cellspacing=0 cellpadding=0 width='100%'>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	<tr>
		<td  colspan=2>
			<center> <h5> <fmt:message key="eSS.Finalize.label" bundle="${ss_labels}"/>? </h5> </center>
		</td>
	</tr>
	<tr>
		<td colspan=2> 
			<center>
			<input type='button' class='button' name='yes' id='yes' value='  Yes  ' onClick='return clickYes();'> &nbsp;&nbsp;&nbsp;
			<input type='button' class='button' name='no' id='no' value='  No  ' onClick='return clickNo();'>
			</center>
		</td>
	</tr>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	</table>
</form>
</body>
</html>

