<!DOCTYPE html>
	<%@ page   import="java.sql.*, webbeans.eCommon.* , java.io.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">



<form name='' id=''>
<table cellpadding=3 cellspacing=0 border=1 width="100%" align='left'>
	<td align='left' class='columnHeader' colspan='12'><fmt:message key="eBL.PAYER_POLICY_DTLS.label" bundle="${bl_labels}"/></td>
	<tr><td></td></tr>

	<td class='COLUMNHEADER' width='8%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='13%'><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='7%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='13%'><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='13%'><fmt:message key="eBL.POLICY_NO.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.POLICY_START_DATE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="eBL.POLICY_EXPIRY_DATE.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='15%'><fmt:message key="eBL.CREDIT_AUTH.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='11%'><fmt:message key="eBL.CREDIT_AUTH_DATE.label" bundle="${bl_labels}"/></td>
<!--
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.APPROVED_AMT.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='5%'><fmt:message key="eBL.APPROVED_DAY.label" bundle="${bl_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EffectiveFrom.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='10%'><fmt:message key="Common.EffectiveTo.label" bundle="${common_labels}"/></td>
-->

	
</table>
</form>
</body>
</html>

