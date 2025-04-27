<!DOCTYPE html>
 <!--
	Developed by 		:	C.Rammohan
	Created on 			:	5/11/2006
	Module					:	eST
	Function				:	This function is used to display the Confirmation Page for selecting View or Print option for Reports
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eST.Print/View.label" bundle="${st_labels}"/></title>
	<%

		request.setCharacterEncoding("UTF-8");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<script language="javascript" src="../../eST/js/StCommon.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<body onLoad='document.getElementById("Print").focus();'>
<form name='ConfirmTransactionForm' id='ConfirmTransactionForm' method='post'>

	<table border=0 cellspacing=0 cellpadding=0 width='100%' align=center>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	<tr>
		<td  colspan=2>
			<center> <h5> <fmt:message key="Common.action.label" bundle="${common_labels}"/>  </h5> </center>
		</td>
	</tr>
	<tr>
		<td colspan=2> 
			<center>
			<input type='button' class='button' name='Print' id='Print' value='<fmt:message key="Common.print.label" bundle="${common_labels}"/>' onClick='return clickYes();'> &nbsp;&nbsp;&nbsp;
			<input type='button' class='button' name='<fmt:message key="Common.view.label" bundle="${common_labels}"/>' id='<fmt:message key="Common.view.label" bundle="${common_labels}"/>' value='  View  ' onClick='return clickNo();'>
			</center>
		</td>
	</tr>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	</table>
</form>
</body>
</html>

