<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 	<script language="JavaScript" src="../js/SpecimenOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String option = request.getParameter("option");
	option = (option == null) ? "" : option.trim();
	String select_td_style="";
	if(option.equals("S"))
		select_td_style="display:inline;visibility:hidden";
	else{
		select_td_style="display:inline;visibility:visible";
	}
//out.println("<script>alert('select_td_style="+select_td_style+"');</script>");
%>
<form name=specimen_order_hdg action=post target=messageFrame>
<table id="tableheader" cellpadding=3 cellspacing=0 border=1 width='100%' height='100%'>
	<tr>
		<td class=columnheader width='' nowrap><fmt:message key="eOR.PatientOrderDetail.label" bundle="${or_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.OrderID.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		<td class=columnheader width='' nowrap id='select_td' style="<%=select_td_style%>">
		<% if (option.equals("D") || option.equals("N") ) {%>
			<a  class="gridLink" id='hdr' title=''><font color='white'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></a><input type=checkbox  name='check_all' id='check_all' onClick='clickAll(this)' disabled></td>
		<%} else {%><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td><%}%>
	</tr>
	<input type="hidden" name="specimen_date_time" id="specimen_date_time" value="">
	<input type="hidden" name="specimen_remarks" id="specimen_remarks" value="">
	<input type="hidden" name="collected_by" id="collected_by" value="">
	<input type="hidden" name="dispatch_mode" id="dispatch_mode" value="">
</table>
</form>
</body>
</html>

