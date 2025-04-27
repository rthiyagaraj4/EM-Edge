<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8" %> 
<html>
<head>


<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");%>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=authorise_order_hdg>
<%


	//String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	//String resp_id = (String)session.getValue("responsibility_id"); // the exact sessionname is needed to be taken

	//if(resp_id== null)resp_id = "CLINICIAN";
	
	String priority			= request.getParameter( "priority" ) ;
	String ord_cat			= request.getParameter( "ord_cat" ) ;
	String order_by			= request.getParameter( "order_by" ) ;
	String ord_cat_desc		= request.getParameter( "ord_cat_desc" ) ;
	String priority_desc	= request.getParameter( "priority_desc" ) ;

	if(priority == null) priority= " ";
	if(order_by == null || order_by.equals("null")) order_by= " ";
	if(ord_cat == null) ord_cat =" ";
	if(ord_cat_desc== null) ord_cat_desc="" ; else ord_cat_desc = ord_cat_desc.trim();
	if(priority_desc== null) priority_desc="" ; else priority_desc = priority_desc.trim();
//System.out.println("###in AuthorizeOrdersBottomRightHeading.jsp, begin##");	//out.println("??>"+priority+"<==>"+priority_desc+"<==>"+order_by+"<==>"+ord_cat+"<<br>");

	//String slClassValue = "";
	//String classValue = "";
	//int total = 0;



%>
<table id="tableheader" cellpadding=3 cellspacing=0 border=1 width="100%" height="100%">
<%
/*
if(!(priority.equals(" "))){
	out.println("<tr><th align=left colspan=6>"+priority_desc+"</td></tr>");
}
if(!(ord_cat.equals(" "))){
	out.println("<tr><th align=left colspan=6>"+ord_cat_desc+"</td></tr>");
}*/
%>
	<tr><td class='columnheader' width='' nowrap><input type=checkbox name='select_all' id='select_all' onClick='clickAll()'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></td>
	<%if((order_by.equals(" ")||(order_by.equals("P"))) && ord_cat_desc.equals("")){%>
		<td class=columnheader width='' nowrap><fmt:message key="Common.category.label" bundle="${common_labels}"/></td>
	<%}%>

	<%if((order_by.equals(" ")||(order_by.equals("O"))) && priority_desc.equals("")){	%>
		<td class=columnheader width='' nowrap><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
	<%}//System.out.println("###in AuthorizeOrdersBottomRightHeading.jsp,ends##");%>
		<td class=columnheader width='' nowrap><fmt:message key="eOR.OrderedAt.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="eOR.OrderCatalogs.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.OrderDetails.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="eOR.ChargeDtls.label" bundle="${or_labels}"/></td>
	</tr>
</table>
</form>
</body>
</html>

