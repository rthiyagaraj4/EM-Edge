<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------

15/01/2018  IN065844       Sharanraj 	16/01/2018      Ramesh G         ML-MMOH-CRF-1000

----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ %>

<%@page  import="java.util.*, eOR.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<head>
<!--<title><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/></title>-->
<title><fmt:message key="eOR.ViewAmndReason.label" bundle="${or_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>

 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
</head>
<body>
<form name="view_Amend_Reason" id="view_Amend_Reason">
<%
String orderId = request.getParameter("orderId");

String bean_id1 = "Or_ViewOrder" ;
String bean_name1 = "eOR.ViewOrder";
ViewOrder bean1=(ViewOrder)getBeanObject( bean_id1, bean_name1, request ) ;
ArrayList amendreason=new ArrayList();
ArrayList Reason=null;
ArrayList date1=null;
ArrayList ordid=null;
amendreason=bean1.getAmendReason(orderId);
Reason=(ArrayList)amendreason.get(0);
date1=(ArrayList)amendreason.get(1);
ordid=(ArrayList)amendreason.get(2);


%>

<table cellpadding=3 cellspacing=0 border=1 width='100%' align='center' class="grid">

<tr >

<th width='2%' class='columnheader'><fmt:message key="eOR.AmndDate.label" bundle="${or_labels}"/></td>
<th width='2%' class='columnheader'><fmt:message key="eOR.AmndOrdId.label" bundle="${or_labels}"/></td>
<th width='5%' class='columnheader'><fmt:message key="eOR.AmndReason.label" bundle="${or_labels}"/></td>

</tr >



<%
for(int i=0;i<ordid.size();i++)
{	
%>
<tr>
<td class="gridData"><%=date1.get(i) %></td>
<td class="gridData"><%=ordid.get(i) %></td>
<td class="gridData"><%=Reason.get(i) %></td>
</tr>
<%} %>


</table>
</form>
</body>

