<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    request.setCharacterEncoding("UTF-8");
%>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<title><fmt:message key="eMP.ReferralNotes.label" bundle="${mp_labels}"/> </title>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>

<script language="JavaScript">
<!--
		function returnText(val)
		{
			if(val == 'O')
			{
				parent.window.returnValue = document.getElementById("ref_notes").value;
			}
			else
			{
				parent.window.returnValue = 'C';
			}
			parent.window.close();
		}
//-->
</script>
</head>

<body onKeyDown = 'lockKey();'>
	<table cellpadding=3 cellspacing=0 border=0 width="100%">
	<tr>
		<td align=center><textarea name="ref_notes" rows="12" cols="78"></textarea></td>
	</tr>
	<tr>
		<td align=right><input type="button" class=BUTTON value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="returnText('O')"><input type="button" class=BUTTON value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="returnText('C')"></td>
	</tr>
	</table>

<script language="JavaScript">
<!--
	var a = window.dialogArguments;
	if(a != '')
			document.getElementById("ref_notes").value = a;
//-->
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</body>
</html>

