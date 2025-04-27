<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head><title><fmt:message key="eOR.PatientOrdersView.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<table cellpadding=0 cellspacing=0 border=1 width="100%" align="left" >
<tr>
	<td class="OABLOCK" width="5%">&nbsp;</td>
	<td class="DATA" width="5%">Pending</td>
	<td class="LABEL" width="5%">&nbsp;</td>
	<td class="DATA" width="5%">Active</td>
	<td class="OAGREEN" width="5%">&nbsp;</td>
	<td class="DATA" width="5%">Completed</td>
	<td class="ORCANCEL" width="5%">&nbsp;</td>
	<td class="DATA" width="5%">Cancelled</td>
	<td class="OAYELLOW" width="5%">&nbsp;</td>
	<td class="DATA" width="5%">Inactive</td>
	<td class="LABEL" width="50%">&nbsp;</td>
</tr>
</table>
</html>
