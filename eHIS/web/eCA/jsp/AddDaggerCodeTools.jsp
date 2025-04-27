<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
function closew(val)
{
	if(val == 'OK'){
		window.returnValue = top.AddDaggerCodeAddModifyFrame.document.form1.convals.value;
		//alert("  "+top.AddDaggerCodeAddModifyFrame.document.form1.convals.value);
	}
	else
		window.returnValue = top.AddDaggerCodeAddModifyFrame.document.form1.convals1.value;
	window.close();
}
//-->
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
<form>
<table width="100%" align='right'>
	<tr>
		<td align='right' colspan = 4 width = '100%';>
			<input type="button" class="button" name="OK" id="OK" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick="closew('OK')">
			<input type="button" class="button" name="Cancel" id="Cancel" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onclick="closew('CANCEL');">
		</td>
	</tr>
</table>
</form>
</BODY>
</HTML>

