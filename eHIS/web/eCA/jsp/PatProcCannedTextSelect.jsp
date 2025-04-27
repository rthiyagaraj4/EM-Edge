<!DOCTYPE html>
<%@page  language="java" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="eCA.CannedText.label" bundle="${ca_labels}"/></title>
	<% 	request.setCharacterEncoding("UTF-8");	%>
<%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCA/js/procedures.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<center>
	<form name='RecClinicalNotesCTForm' id='RecClinicalNotesCTForm'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' >
		<tr><td width='25%'></td><td width='25%'></td><td width='25%'></td><td width='25%'><input type='button' class='button' name='select' id='select' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>' onClick='closeCannedTextWindow();' ><input type='button' class='button' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='parent.parent.document.getElementById("dialog_tag").close()'></td></tr>
		</table>
	</form>
	</center>
</body>
</html>

