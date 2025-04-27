<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/PatOrderByPrivReln.js"></script>
 	<script language="JavaScript" src="../js/PatOrderByPrivRelnTracking.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<form name=formPatOrderByPrHeader action=post target=messageFrame>
<%
String order_by = request.getParameter( "order_by" ) ; 
String view_by = request.getParameter( "view_by" ) ; 
%>
<table id="tableheader" cellpadding=3 cellspacing=0 border=1 width='100%'>
<tr>
	<%
		if(order_by.equals("P"))
		{
	%>
			<td class='columnheader' width='16px' nowrap></td>
			<td class='columnheader' width='16px' nowrap></td>
		<%
			if(view_by.equals("H"))
			{
		%>
				<td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
		<%
			}
			else
			{
		%>
				<td class='columnheader' width='' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
				<td class='columnheader' width='' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
		<%
			}
		%>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/> </td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.print.label" bundle="${common_labels}"/><br><Input Type='CheckBox' name='CheckPrint' id='CheckPrint' value="" class='Header'  align ='center' onClick='clickAll()' disabled></td>
	   
<%}else if(order_by.equals("T")){%>
		<td class='columnheader' width='16px' nowrap></td>
		<td class='columnheader' width='16px' nowrap></td>
		<td class='columnheader' width='' nowrap ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
	<%
		if(view_by.equals("H"))
		{
	%>
			<td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
	<%
		}
		else
		{
	%>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
	<%
		}
	%>
		<td class='columnheader' width='' nowrap ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.print.label" bundle="${common_labels}"/><Input Type='CheckBox' name='CheckPrint' id='CheckPrint' value="" class='Header'  align ='center' onClick='clickAll()' disabled></td>
<%}

		else{%>
		<td  class='columnheader' width='16px' nowrap></td>
		<td  class='columnheader' width='16px' nowrap></td>
		<td class='columnheader' width='' nowrap ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
	<%
		if(view_by.equals("H"))
		{
	%>
			<td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
	<%
		}
		else
		{
	%>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width='' nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
	<%
		}
	%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap> <fmt:message key="Common.print.label" bundle="${common_labels}"/><Input Type='CheckBox' name='CheckPrint' id='CheckPrint' value="" class='Header'  align ='center' onClick='clickAll()' disabled></td>	
<%}%>
</tr>	
</table>
</form>
</body>
</html>

