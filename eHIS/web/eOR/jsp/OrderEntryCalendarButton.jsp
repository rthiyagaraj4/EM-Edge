<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title><fmt:message key="eOR.OrderEntryCalendarButton.label" bundle="${or_labels}"/></title>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
			<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="Javascript" src="../../eCommon/js/common.js"></script>

			<script language="Javascript" src="../../eOR/js/OrderEntryCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name ="calendarButtonForm">
			<table border="0" cellpadding="3" cellspacing="0" width="100%" id='test'>
			<tr>
				<td class="OAYELLOW" id="date_id" width="25%"></td>
				<td class="LABEL"  width="35%" id="active_legends"><fmt:message key="Common.ActiveBookings.label" bundle="${common_labels}"/></td>
				<td class="LABEL"  id="active_id" width="25%"></td>
			</tr>
			<tr>
				<td class="LABEL"  colspan="4">
					<input type="button" name="ok" id="ok" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" title ="OK"  onClick="parent.parent.closeModal()">
				</td>
			</tr>
			<input type="hidden" align="left" name="date_value" id="date_value" value="" >
		</table>
		</form>
	</body>
</html>

