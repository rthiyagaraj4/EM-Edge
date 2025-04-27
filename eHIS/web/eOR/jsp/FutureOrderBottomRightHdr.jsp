<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%-- Mandatory declarations start --%>
<%@page  import="java.util.*,eOR.*,eCommon.XSSRequestWrapper " %>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/FutureOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=future_order_hdg>
<%
	String bean_id = "Or_FutureOrder" ;
	String bean_name = "eOR.FutureOrder";
	FutureOrder bean = (FutureOrder)getBeanObject( bean_id, bean_name, request  ) ;
	bean.setLanguageId(localeName);
	bean.clear();

%>
<table cellpadding=3 cellspacing=0 border=1 width="100%" height="100%" align=center id="tableheader">

	<tr>
	<td class='columnheader' width='150' wrap><input type=checkbox name='select_all' id='select_all' onClick='clickAll()'><fmt:message key="eOR.Linktocurrentencounter.label" bundle="${or_labels}"/></td>
	<td class="columnheader" width=''><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
	<td class="columnheader" width=''><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
	<td class="columnheader" width=''><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
	<td class="columnheader" width=''><fmt:message key="eOR.OrderCatalogs.label" bundle="${or_labels}"/></td>
	</tr>
</table>
<input type="hidden" name="querystring" id="querystring" value="<%=request.getQueryString()%>">
</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

