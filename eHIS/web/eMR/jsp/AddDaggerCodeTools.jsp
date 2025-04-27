<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JavaScript">
<!--
function closew(val)
{
	
	if(val == 'OK'){
		window.returnValue = parent.AddDaggerCodeAddModifyFrame.document.form1.convals.value;
		window.close();
	}
	else
		{
    window.returnValue = parent.AddDaggerCodeAddModifyFrame.document.form1.convals1.value;
	window.close();
		}
}
//-->
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onKeyDown = 'lockKey()'>
<form name='daggar_buttons' id='daggar_buttons'>
<table width="19%" align='right'>
	<tr>
		<td class='button'>
			<input type="button" class="button" name="OK" id="OK" value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%> ' onclick="closew('OK')">
			<input type="button" class="button" name="Cancel" id="Cancel" value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%> ' onclick="closew('CANCEL');">
		</td>
	</tr>
</table>
</form>
</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

