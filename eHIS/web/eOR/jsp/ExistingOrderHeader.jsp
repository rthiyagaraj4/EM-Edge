<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ExistingOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=existing_order_hdg>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String view_by = request.getParameter("view_by");
    if (view_by == null) view_by = "";
	String called_from = request.getParameter("called_from"); // NO PARAMETER WILL COME FOR EXISTING_ORDER , ONLY FOR ORDER SET RESULTS VALUE WILL COME AS ORDER_SET
	    if (called_from == null) called_from = "";
%>
<table cellpadding=3 cellspacing=0 border=1 width='100%'  id="tableheader">
	<tr>
		<%if (view_by.equals("L")) {%>
		<%if (called_from.equals(""))
		{%>
			<td  class='columnheader' width='' nowrap></td>
			<td  class='columnheader' width='' nowrap></td>
	<%}%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
		<%} else {%>
		<%if (called_from.equals(""))
		{%>
			<td class='columnheader' width='' nowrap></td>
			<td  class='columnheader' width='' nowrap></td>
	<%}%>
        <td class='columnheader' width='' nowrap ><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
        <%}%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<%if (view_by.equals("L")) {%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<%} else {%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<%}%>
  <td class='columnheader' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	<%if (called_from.equals("")){%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.action.label" bundle="${common_labels}"/><BR><input type=checkbox name='select_all' id='select_all' onClick='clickAll()' disabled></td>
	<% } %>
	</tr>
</table>
</form>
</body>
</html>

