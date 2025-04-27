<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>

	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/ReviewNotes.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
	<%
	//String resComments	= request.getParameter("comments")==null?"":request.getParameter("comments");
	//out.println("<script>alert('resComments"+resComments+"')</script>");
	%>
    </head>
    <body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
	<center>
	<form name='' id=''>
		<table border='0' cellpadding='0' cellspacing='0' width='100%' >
		<!-- <tr><td colspan=2>&nbsp;</td></tr>
		<tr><td colspan=2>&nbsp;</td></tr> -->
		<tr><td class='LABEL'  width='30%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td colspan=1 class='fields'><TEXTAREA NAME="remarks" ROWS="3"  COLS="35"  maxlength=200 onKeyPress="checkMaxLimit(this,200);"></TEXTAREA><img align='center' src='../../eCommon/images/mandatory.gif'></img></td></tr>
		<!-- <tr><td colspan=2 align='center' width='100%'>&nbsp;</td></tr> -->
		<tr><td colspan=2 align='center' width='100%'><input type='BUTTON' class='BUTTON' name='ok' id='ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Send.label","ca_labels")%>"  onClick='sendRemarks();'><input type='BUTTON' class='BUTTON' name='cancel' id='cancel' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>"  onClick='const dialogTag = parent.document.getElementById("dialog_tag");dialogTag.close();'></td></tr>
		<!-- <tr><td colspan=2>&nbsp;</td></tr>
		<tr><td colspan=2>&nbsp;</td></tr> -->
		</table>		
	</form>
	</center>
</body>
</html>

