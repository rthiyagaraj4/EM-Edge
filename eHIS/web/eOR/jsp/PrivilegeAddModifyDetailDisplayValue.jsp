<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%> 
<%-- JSP Page specific attributes end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 
<body style='overflow-y:hidden' onMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name="privilegeDetailDisplayValue" id="privilegeDetailDisplayValue" method="post" >

<table cellpadding='3' cellspacing='0' border='1' BORDERCOLOR='#000000' width='100%' align='center' >
<tr>

	 <td><B><B><fmt:message key="eOR.SSelfOrder.label" bundle="${or_labels}"/> <fmt:message key="eOR.MMedicalTeam.label" bundle="${or_labels}"/> <fmt:message key="eOR.AAllOrders.label" bundle="${or_labels}"/> <fmt:message key="eOR.NNotApplicable.label" bundle="${or_labels}"/></B></B></td>

</tr>
</table>
</form>
</body>
</html>


