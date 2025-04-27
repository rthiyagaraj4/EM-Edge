<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='BtnForm' id='BtnForm'>		
<table border='0' cellpadding='3' cellspacing='0' width="90%" align='center' >
	<tr>
		<td colspan=2 align='right' width='100%'>
			<input type='BUTTON' class='BUTTON' name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='closeForwardWindow();'>&nbsp;<input type='BUTTON' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='parent.window.close();'>
		</td>
	</tr>
</table>
<form>
</form>
</body>
</html>

