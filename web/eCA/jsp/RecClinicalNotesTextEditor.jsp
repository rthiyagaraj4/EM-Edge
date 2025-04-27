<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eCA.DictationWindow.label" bundle="${ca_labels}"/></title>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript'>
function returnEditorText()
{
	if(document.forms[0].cancel!=null)
	{
		var clipBoardVal=document.forms[0].cancel.createTextRange();
		clipBoardVal.select();
		clipBoardVal.execCommand("copy","","");
		//document.RecClinicalNotesHeaderForm.body.focus();
	}
	var		retVal		=	document.TextEditorForm.text_editor.value;
	window.returnValue	=	retVal;
	window.close();
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onunload='//returnEditorText()' class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name='TextEditorForm' id='TextEditorForm'>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<tr><td class='fields'><textarea name='text_editor' rows=11 cols=70></textarea></td></tr>
	<tr> <td width='25%'></td><td width='25%'></td><td width='25%'></td>
	<td ><input type=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.accept.label","common_labels")%>' class=button onclick="returnEditorText()"><input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'name=cancel onclick='window.close()'></td></tr>
</table>
</form>
</body>
</html>

