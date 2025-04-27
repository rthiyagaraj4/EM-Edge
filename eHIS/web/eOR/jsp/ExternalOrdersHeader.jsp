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
<head><title><fmt:message key="eOR.ExternalOrders.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ExternalOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="externalOrdersHeader" id="externalOrdersHeader">
	<table id="tab" cellspacing=0 cellpadding="3" border="0">
	 	<tr>
			<td class="CASECONDSELECTHORZ" width="20%" onClick="changeColor(this)"><a  style='color:white;cursor:pointer' href="javascript:callExternal('NewOrders')" ><fmt:message key="Common.NewOrders.label" bundle="${common_labels}"/></td>
			<td class="CAFIRSTSELECTHORZ" width="20%" onClick="changeColor(this)"><a  style='color:white;cursor:pointer' href="javascript:callExternal('ExistingOrder')" ><fmt:message key="eOR.ExistingOrders.label" bundle="${or_labels}"/></td>
			<td class="white" width="60%"></td>
 			</tr>
	</table>
 </form>
</body>
</html> 

