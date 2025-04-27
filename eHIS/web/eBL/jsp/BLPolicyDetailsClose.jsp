<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>	
<head>
<!--
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
	-->
		<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>
-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function CloseModal()
	{
		parent.window.close();
	}
	</script>
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr>
	<td class="button"><input type='button' name='close_button' id='close_button' class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='return CloseModal();'><td>
</tr>
</body>
</html>

