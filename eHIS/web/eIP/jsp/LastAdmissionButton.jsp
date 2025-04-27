<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
request.setCharacterEncoding("UTF-8"); %>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
<script language="JavaScript">
function callLastAdmission()
{ 
	const dialogTag = parent.parent.document.getElementById("dialog_tag");    
	dialogTag.close();
}
</script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<table cellpadding=0 cellspacing=0 align="right" width="100%" border=0>
<tr>
	<td align='right' class='bodycolorfilled'><input type="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick="callLastAdmission()"></td>
</tr>
</table>
</body>
</html>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

