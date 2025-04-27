<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<HTML>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8"); 
%>

<HEAD>
<TITLE>User Authentication</TITLE>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = ((String)session.getAttribute("LOCALE"));
%> 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<style>
	body {
	margin:30px 0px; padding:0px;
	text-align:center;
	}
</style>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eXB/js/ssMonDPReport.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY leftmargin='0' topmargin='0' class="body" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="ValidateUserForm" id="ValidateUserForm" method='post' action='../../servlet/eXB.SSMonDPDynaValServlet'>

<table width='100%' align='center' valign='center'>
<tr align="center">
	<td class="label"><fmt:message key="eXH.AUTH_USER_ID.Label" bundle="${xh_labels}"/></td>
	<td class="FIELDS">		
		<input type="text" id="userID" name='userID' id='userID' size="19"> <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr align="center">
	<td class="label"><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
	<td class="FIELDS">		
		<input type="password" id="password" name='password' id='password'> <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	<td class='button' colspan='2'><INPUT TYPE="button" onClick="validateUser()" VALUE='<fmt:message key="Common.Submit.label" bundle="${common_labels}"/>'></td>
</tr>
</table>

<input type="hidden" name="actionReq" id="actionReq" id="actionReq" value="AUTH">
</form>
</body>
</html>

