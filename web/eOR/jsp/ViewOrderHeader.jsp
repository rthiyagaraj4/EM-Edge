<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<table cellpadding=3 cellspacing=0 border=1 id='titleTab'  width="100%">
	<tr>
		<td class='columnheader' width=''><fmt:message key="Common.ordercatalog.label" bundle="${Common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.priority.label" bundle="${Common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width=''><fmt:message key="eOR.Formats.label" bundle="${or_labels}"/></td>
		<td class='columnheader' width=''></td>
	</tr>

</table>
</body>
<script>
parent.ViewOrderDtl.location.href="ViewOrderDetail.jsp?<%=request.getQueryString()%>"
</script>

</html>

