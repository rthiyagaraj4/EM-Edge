<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title>RecClinicalNotesLink.jsp</title>
	
	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkHist.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
	<center>
	<form name='RecClinicalNotesLinkHistNoteAddButtonsForm' id='RecClinicalNotesLinkHistNoteAddButtonsForm'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' height='100%'>
		<tr>
		<td class="NOTEHEADER">
			<fmt:message key="eCA.FinalSelection.label" bundle="${ca_labels}"/>
		</td>
		<td colspan ='3' align ='right' class="NOTEHEADER">
			<input type='BUTTON' class='BUTTON' name='select' id='select' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")+">>" %>' onClick="addToDiv()" >&nbsp;
		</td>
		</tr>
		</table>
	</form>
	</center>
</body>
</html>

