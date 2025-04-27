<!DOCTYPE html>
<HTML>
<HEAD>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name="viewserver_processerrors_footer_form" id="viewserver_processerrors_footer_form">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class=label><fmt:message key="eXH.ApplicationMessage.Label" bundle="${xh_labels}"/></td>
	</tr>
<tr>
	<td class='fields'><textarea name="Appl_msg" id="Appl_msg" rows=2 cols=100><%=request.getParameter("Appl_msg").equals("null")?"":request.getParameter("Appl_msg")%> </textarea></td>
</tr>
<tr>
	<td class=label><fmt:message key="Common.ErrorMessage.label" bundle="${common_labels}"/></td>
	</tr>
<tr>
	<td class='fields'><textarea name="Err_msg" id="Err_msg" rows=2 cols=100><%=request.getParameter("Err_msg").equals("null")?"":request.getParameter("Err_msg")%></textarea></td></tr>
<tr>
	<td class=label><fmt:message key="eXH.ApplicationKey.Label" bundle="${xh_labels}"/></td></tr><tr>
<td class='fields'>
	<textarea name="Appl_key" id="Appl_key" rows=2 cols=100><%=request.getParameter("Appl_key").equals("null")?"":request.getParameter("Appl_key")%></textarea></td></tr>
</table>
</form>
</body>
</html>

