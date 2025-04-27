<!DOCTYPE html>


<%@page contentType="text/html;charset=UTF-8"%>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<table id="tableheader" cellpadding=3 cellspacing=0 border=1 width="100%" height="100%">
	<tr>
		<td class=columnheader width='' nowrap><fmt:message key="Common.Event.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.Result.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.Unit.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.LowValue.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.HighValue.label" bundle="${common_labels}"/></td>
		<td class=columnheadercenter width='' nowrap><fmt:message key="Common.EventStatus.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	</tr>
</table>
</body>
</html>

