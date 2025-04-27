<!--<!DOCTYPE html>-->
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
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
   	<script language="JavaScript" src="../js/PendingOrdersSchedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=pending_order_hdg>
<table cellpadding=3 cellspacing=0 border=1 width='100%'  height="100%">
	<tr>
		<th width='8%'><fmt:message key="eOR.WaitingTime.label" bundle="${or_labels}"/></th>
		<th width='8%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
		<th width='17%'>Start Date Time</th>
		<th width='25%'><fmt:message key="Common.Orderable.label" bundle="${common_labels}"/></th>
 		<th width='27%'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></th>
		<th width='15%'><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></th>
	</tr>
</table>
</form>
</body>
</html>

