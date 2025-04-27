<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- CancelOrderHeader.jsp -->
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ReviewStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<FORM METHOD=POST name="review_status_hdg" id="review_status_hdg">
<%
	String task_type=request.getParameter("task_type");
%>
<table cellpadding=3 cellspacing=0 border=1 width="100%"  align=center id='titleTab'>
<tr>
		<font size=1>
		<td class=columnheader width='13%'><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='10%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='8%'><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='9%'><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='9%'><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='8%'><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='10%'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='8%'><fmt:message key="eOR.Formats.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='8%'></td>
		<%if(task_type.trim().equalsIgnoreCase("UpdateLine")){%>
		<td class=columnheader width='8%'></td><%}%></font></tr>
</table>
<input type="hidden" name="complete_all_desc" id="complete_all_desc" value="">
</FORM>
</body>
</html>

