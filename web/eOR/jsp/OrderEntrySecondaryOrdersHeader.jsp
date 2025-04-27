<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* " contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrderEntrySearch.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%
	String sec_catalog_type=request.getParameter("sec_catalog_type")==null?"":request.getParameter("sec_catalog_type");
	%>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="" id="">
<table cellpadding=3 cellspacing=0 border=1 width="100%" id="tableheader">
	<tr><td class='columnheader' width='' nowrap><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
	<%
	if(sec_catalog_type.equals("O"))
	{
	%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
	<%
	}
	else
	{%>
		<td class='columnheader' width='' nowrap><fmt:message key="Common.Intervention.label" bundle="${common_labels}"/></td>
	<%
	}
	%>
	<td class='columnheader' width='' nowrap><fmt:message key="eOR.OrderStage.label" bundle="${or_labels}"/></td></tr>

</table>
</body>
</form>
</html>

