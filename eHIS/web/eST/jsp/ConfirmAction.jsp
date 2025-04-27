<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eST.Confirm.label" bundle="${st_labels}"/></title> 
	<%

		request.setCharacterEncoding("UTF-8");
		
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		String legend	= request.getParameter("str")==null?"":request.getParameter("str");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eST/js/StCommon.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

<body onLoad='document.getElementById("no").focus();'>
<form name='ConfirmActionForm' id='ConfirmActionForm' method='post'>

	<table border=0 cellspacing=0 cellpadding=0 width='100%' align=center>

	<tr>
		<td wrap><%=legend%>&nbsp;&nbsp;&nbsp;</td>
	</tr>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
	<tr>
		<td > 
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

