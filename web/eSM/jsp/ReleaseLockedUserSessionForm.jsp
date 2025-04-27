<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>
	<%
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script src="../../eSM/js/ReleaseLockedUserSession.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'  OnMouseDown="CodeArrest();">
<form name='ReleaseLockedUserForm' id='ReleaseLockedUserForm' >
	<table border='0' cellpadding='0' cellspacing='0' align='center'  width='100%' >
		<tr> 
		<td colspan='3' width="25%">&nbsp;</td>
		
		</tr>
		<tr>
			<td width="20%">&nbsp;</td>
			<td class='label'width="5%" align='left'><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
			<td class='fields'width="25%"  align='left'>
			<input type='text' name='userName' id='userName' size='22' onblur='GetLookupBlur(userName)'><input type='button' class='button' name='user_lookup' id='user_lookup' value='?' onClick='GetLookup(userName)'>
			<input type='hidden' name='userID' id='userID' value=''>
			</td>
		</tr>
		
		<tr> 
			<td colspan='3' >&nbsp;</td>
		</tr>
	</table>

</form>
</body>

</html>

