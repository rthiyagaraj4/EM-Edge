<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--  -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ReportAuthorization.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<form name=report_authorization_hdg>
<%
	
	String patient_id_found = request.getParameter("patient_id_found");
%>
<table id="tableheader" cellpadding=3 cellspacing=0 border=1 width='100%' height='100%' >
	<tr>
		<%if(patient_id_found.equals("yes")){%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/><input type=checkbox name='select_all' id='select_all' onClick='clickAll()' disabled></td>
		<%}else{%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/><input type=checkbox name='select_all' id='select_all' onClick='clickAll()' disabled></td>
		<%}%>
	</tr>
</table>
</form>
</body>	
</html>

