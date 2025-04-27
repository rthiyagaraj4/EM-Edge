<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
 

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");%>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
  	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/FutureOrder.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	String oledb_con_string=(String)session.getValue("oledb_con_string");
	String user_id = (String)session.getValue("login_user");
	String bean_id = "Or_FutureOrder" ;
	String bean_name = "eOR.FutureOrders";
	
%>
<form name='future_order_btn' id='future_order_btn' target='messageFrame' >
<table cellpadding=0 cellspacing=0 border=0 width='100%' align='center' style='border-width:0'  id="billing_dtl" style="visibility:hidden"> 
		<tr >	
			<td colspan="" class="label" width="60%" style='border-width: 0;text-align: right;font-size: 3%'><font class='label' size="10"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/> <fmt:message key="Common.Charge.label" bundle="${common_labels}"/>:</B></font></td>
			<td colspan="" class="label" width="7%"style='border-width: 0;text-align: right;'><font class='label' size="1" size="1"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/></B></font></td>
			<td colspan="" class="label" width="6%" style='border-width: 0;text-align: right;'><font class='label' size="1" size="1"><B><fmt:message key="Common.patient.label" bundle="${common_labels}"/></B></font></td>
			<td colspan="" class="label" width="27%" style='border-width: 0;text-align: center;'><font class='label' size="1">&nbsp;</font></td>
			
			
		</tr>
		<tr >	
			<td colspan="" class="label" width="" style='border-width: 0;text-align: right;font-size: 3%'><font class='label' size="10"><B><!-- Total Billing Charge: --></B></font></td>
			<td colspan="" class="label" width=""style='border-width: 0;text-align: right;'><font class='label' size="2" size="1"><B><span id='actual_'>0.0</span></B></font></td>
			<td colspan="" class="label" width="" style='border-width: 0;text-align: right;'><font class='label' size="2" size="1"><B><span id='payable_'>0.0</span></B></font></td>
			<td colspan="" class="label" width="" style='border-width: 0;text-align: center;'><font class='label' size="1">&nbsp;</font></td>
			
			
		</tr>
				
		</table>
<table cellpadding=3 cellspacing=0 border=0 width="100%" height="100%" align=center>
	<tr>
		<td class='button'>
		<INPUT TYPE="button" id="FutureOrderConfirm"  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' name='record' class='button' onClick='future()'>
		
		<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class='button' onClick='clearChecked()'>
		</td>
	</tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<input type="hidden" name="help_function_id" id="help_function_id" value="FUTURE_ORDERS">
<input type='hidden' name ='oledb_con_string' value='<%=oledb_con_string%>' >
</form>
</body>
</html>

