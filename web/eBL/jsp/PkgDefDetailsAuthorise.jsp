<!DOCTYPE html>
<%@ page   import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.* , java.io.*,webbeans.op.CurrencyFormat,eOR.*,eOR.Common.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
try
{
%>
<html>
<head>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/FieldFormatMethods.js'></Script>
	<script language='javascript' src='../js/PkgDef.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eBL.AUTH_SCREEN.label" bundle="${bl_labels}"/></title> 
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<center>
	<form name='AuthForm' id='AuthForm'>
	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
	<tr>
		<td colspan=15>&nbsp;</td>
	</tr>
	<tr>
	<td width="50%" class="label"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='text' name='user_id' id='user_id' size='20' maxlength='20' onKeyPress='return changeToUpper()'><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	 <tr>
	<td width="50%" class="label" ><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='password' name='passwd' id='passwd' size='21' maxlength='64'><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<tr>
	<td width="50%"class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><textarea name='remarks' rows="2" cols="25" onKeyPress='checkMaxLimit(this,50)'></textarea><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<tr>
	<td width="50%"></td>
	<td width="50%">
	<input type='button' class='button' name='auth_ok' id='auth_ok' value="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>    " onClick ='return confirmPasswdchk(this);'><input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="    <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>    " onClick='retModal(this);'>
	</td>
	</tr>
	<tr>
	<td colspan=15>&nbsp;</td>
	</tr>
	<tr>
	<td colspan=15>&nbsp;</td>
	</tr>
	<script>
	document.forms[0].user_id.focus();
	</script>
	</table>
	</form>
	</center>
	</body>
	</html>
	<%
}
catch(Exception ee)
{
  System.err.println("Error in PkgDefDetailsAuthorise.jsp: " +ee);
}
%>

