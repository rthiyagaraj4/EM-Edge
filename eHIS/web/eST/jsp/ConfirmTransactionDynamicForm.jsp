<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	
	<%

		request.setCharacterEncoding("UTF-8");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eMM/js/ItemImageCatalogue.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onLoad='document.getElementById("no").focus();'>
<%
	String TransactionLabel	= request.getParameter("TransactionLabel")==null?"":request.getParameter("TransactionLabel");
	String TitleLabel	= request.getParameter("TitleLabel")==null?"":request.getParameter("TitleLabel");
%>
<title><%=TitleLabel%></title>
<form name='ConfirmTransactionDynamicForm' id='ConfirmTransactionDynamicForm' method='post'>

	<table border=0 cellspacing=0 cellpadding=0 width='100%' align=center>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	<tr>
		<td  colspan=2>
			<center> <h5><%=TransactionLabel%></h5> </center>
		</td>
	</tr>
	<tr>
		<td colspan=2> 
			<center>
			<input type='button' class='button' name='yes' id='yes' value='<fmt:message key="Common.yes.label" bundle="${common_labels}"/>' onClick='return clickYes();'> &nbsp;&nbsp;&nbsp;
			<input type='button' class='button' name='no' id='no' value='<fmt:message key="Common.no.label" bundle="${common_labels}"/>' onClick='return clickNo();'>
			</center>
		</td>
	</tr>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	<tr><td>&nbsp</td><td>&nbsp</td></tr>
	</table>
</form>
</body>
</html>

