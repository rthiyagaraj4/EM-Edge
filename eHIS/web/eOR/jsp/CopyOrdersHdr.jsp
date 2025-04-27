<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
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
<table cellpadding='3' cellspacing='0' border='1' width='99%' >
	<tr>
		<td class='COLUMNHEADER' width='5%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></Td> 
		<td class='COLUMNHEADER' width='8%' ><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='10%'><fmt:message key="eOR.Orderables.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER' width='12%'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='12%'><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='6%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.OrderingPractitioner.label" bundle="${common_labels}"/></td>
		<%--<TH width='10%'>Ordering Location</TH>--%>
		<%--<TH width='10%'>Ordering Facility</TH>--%>
		<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	</tr>
</table>
</form>
</body>
</html>

