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
<% request.setCharacterEncoding("UTF-8");%>


<html>
	<head>
		<title><fmt:message key="eOR.OrderEntryCalendarButton.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eOR/js/OrderEntryDecisionSupport.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>

	<table border='0' cellpadding='3' cellspacing='0' width='90%' align='center'>
	<tr>
		<td align="right" class="WHITE">
			<input type="button" class="button" name="ok" id="ok" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick="setMultiList()">
		</td>
	</tr>
	</table>
	</head>
</html>

