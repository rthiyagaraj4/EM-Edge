<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<head>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<html>
<TITLE>Processing Result</TITLE>

<%
	String noExPrivExtended = XHDBAdapter.checkNull(request.getParameter("noexprivextended"));
	String noExPrivRemoved = XHDBAdapter.checkNull(request.getParameter("noexprivremoved"));
	String noPrivilegeAdded = XHDBAdapter.checkNull(request.getParameter("noprivilegeadded"));
	String noPrivilegeInvalid = XHDBAdapter.checkNull(request.getParameter("noPrivilegeInvalid"));
	String dataBypassed = XHDBAdapter.checkNull(request.getParameter("dataBypassed"));
	String p_facility_id = (String) session.getValue("facility_id");
	String p_user_name = (String) session.getValue("login_user");
	String locale = (String)session.getAttribute("LOCALE");
%>
</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<form name="ssMonDPProcessResult" id="ssMonDPProcessResult">
<table width="100%" align='center'>
	<tr>
		<td class='Header' colspan='2' align="center"><fmt:message key="eXH.NO_OF_PAT_PRIV.Label" bundle="${xh_labels}"/></td>
	</tr>
	<tr>
		<td align='right' width='50%'><font class='label'><fmt:message key="eXH.EXTENDED.Label" bundle="${xh_labels}"/> : </td><td class='DATA' width='50%'><%= noExPrivExtended %></td>
	</tr>
	<tr>
		<td align='right' width='50%'><font class='label'><fmt:message key="eXH.REMOVED.Label" bundle="${xh_labels}"/> : </td><td class='DATA' width='50%'><%= noExPrivRemoved %></td>
	</tr>
	<tr>
		<td align='right' width='50%'><font class='label'><fmt:message key="eXH.ADDED.Label" bundle="${xh_labels}"/> : </td><td class='DATA' width='50%'><%= noPrivilegeAdded %></td>
	</tr>
	<tr>
		<td align='right' width='50%'><font class='label'><fmt:message key="Common.invalid.label" bundle="${common_labels}"/> : </td><td class='DATA' width='50%'><%= noPrivilegeInvalid %></td>
	</tr>
	<tr>
		<td align='right' width='50%'><font class='label'><fmt:message key="eXH.DATA_BYPASSED.Label" bundle="${xh_labels}"/> : </td><td class='DATA' width='50%'><%= dataBypassed %></td>
	</tr>
	<tr>
		<td class='button' align="center"><INPUT TYPE="button" onClick="javascript:window.close();" VALUE="OK"></td>
	</tr>
</table>
</form>
</BODY>
</HTML>

