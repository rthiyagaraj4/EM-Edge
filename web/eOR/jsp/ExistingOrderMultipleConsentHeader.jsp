<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
	<script language="JavaScript" src="../../eOR/js/ExistingOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form method="post" name="multiple_consent_form_header" id="multiple_consent_form_header">
<table cellpadding=0 cellspacing=0 border=0 width="100%" height="100%" align=center>
<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='25%'><fmt:message key="eOR.ConsentName.label" bundle="${or_labels}"/></td>
<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.ConsentStage.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.ConsentDetails.label" bundle="${common_labels}"/></td>
</table>
<body>
</html>

