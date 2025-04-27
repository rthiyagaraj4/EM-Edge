<!DOCTYPE html>
 <!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
 <!-- Author - kumar: Included in packages where close button is provided-->
 <%@  page  contentType="text/html;charset=UTF-8" %>

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
<!--	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<FORM name = "close" METHOD=POST ACTION="">
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
<!--
	<tr>
	<td class='label' colspan='10'>
		&nbsp;
	<td>
	</tr>
-->
<tr>
	<td align='center' class="button"><input type="button" name="close" id="close" value = "<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" class="Button" onClick="parent.window.close();"></td>	
</td>
</tr>
<!--
	<tr>
	<td class='label' colspan='10'>
		&nbsp;
	<td>
	</tr>
-->
</table>
</FORM>
</body>
</html>

