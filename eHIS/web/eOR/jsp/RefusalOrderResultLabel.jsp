<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%> 

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/RefusalOrders.js"></script> 
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

	<table border="" cellpadding="3" cellspacing="0" width="100%" height="100%" align="center">
	<tr>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="eOR.RefusalDateTime.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="eOR.OrderableNonOrderable.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' width="20%"><fmt:message key="eOR.RefusalForm.label" bundle="${or_labels}"/></td>
	</tr>

	</table>
</body>
</html>

