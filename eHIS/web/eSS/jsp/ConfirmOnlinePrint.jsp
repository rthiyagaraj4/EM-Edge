<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <!--
	Created on 			:	13/09/2004
	Module				:	Confirm Transaction for Online printing....
	Function			:	This function is used to display the Confirmation Page for Online printing .
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eSS.ConfirmPrinting.label" bundle="${ss_labels}"/></title>
	<%

		request.setCharacterEncoding("UTF-8");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String confirmPrintLable = request.getParameter("confirmLable")==null?"":(String)request.getParameter("confirmLable");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<script language="javascript" src="../../eSS/js/SsCommon.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<body onLoad='document.getElementById("no").focus();'>
<form name='ConfirmTransactionForm' id='ConfirmTransactionForm' method='post'>

	<table border=0 cellspacing=0 cellpadding=0 width='100%' align=center>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	<tr>
		<td  colspan=2>
			<%if("".equals(confirmPrintLable)){%>
			<center> <h5> <fmt:message key="eSS.PrintPackingLabel.label" bundle="${ss_labels}"/>? </h5> </center>
			<%}else if("PRINT_DOC".equals(confirmPrintLable)){%>
				<center> <h5> <fmt:message key="eSS.PrintDocumentLabel.label" bundle="${ss_labels}"/>? </h5> </center>
			<%}%>
		</td>
	</tr>
	<tr>
		<td colspan=2> 
			<center>
			<input type='button' class='button' name='yes' id='yes' value='  <fmt:message key="Common.yes.label" bundle="${common_labels}"/>  ' onClick='return clickYes();'> &nbsp;&nbsp;&nbsp;
			<input type='button' class='button' name='no' id='no' value='  <fmt:message key="Common.no.label" bundle="${common_labels}"/>  '  onClick='return clickNo();'>
			</center>
		</td>
	</tr>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	</table>
</form>
</body>
</html>

