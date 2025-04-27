<!DOCTYPE html>
<HTML>
<HEAD>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown ='lockKey()' method="post">

<form name="viewmsg_auditlog_msgstatus_form" id="viewmsg_auditlog_msgstatus_form">
<table cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
	<td class=label ><fmt:message key="Common.MessageText.label" bundle="${common_labels}"/></td><td></td>
</tr>
<tr>
	<td colspan=2 class='fields'><textarea rows=8 cols=125><%=request.getParameter("MESSAGE_TEXT").equals("null")?"":request.getParameter("MESSAGE_TEXT")%></textarea></td>
</tr>
</table>
</form>
</body>
</html>

