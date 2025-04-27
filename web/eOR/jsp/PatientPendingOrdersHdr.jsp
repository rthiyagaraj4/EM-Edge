<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- PatientPendingOrdersHdr.jsp -->


<%@page contentType="text/html; charset=UTF-8" %>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head><title><fmt:message key="eOR.ActiveOrders.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>


	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>

 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<form name='formPatientPendingOrdersHdr' id='formPatientPendingOrdersHdr'>
<table name='' id='' border='1' cellspacing='0' cellpadding = '0' width='100%' align='center'>
	
		<th width='16%' align=center><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
		<th width='16%' align=center><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
		<th width='10%' align=center><fmt:message key="Common.priority.label" bundle="${common_labels}"/></th>
		<th width='14%' align=center><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/> </th>
		<th width='16%' align=center><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></th>
		<th width='14%' align=center><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></th>
		<th width='14%' align=center><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
</table>
</form>
</body>
</html>

