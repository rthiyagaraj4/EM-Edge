<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* , webbeans.eCommon.ConnectionManager,eOR.Common.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--
	<script language="javascript" src="../../eCommon/js/messages.js"></script>-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
  	<script language="JavaScript" src="../js/ExternalOrder.js"></script>
 	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	/* Mandatory checks start */
	String mode	   = "1";// request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

%>

<form name='external_order_middle' id='external_order_middle' target='messageFrame' >

<table cellpadding=3 cellspacing=0 border=0 width="98%" align=center id='multipleRows'>
	<tr>
		<td class=label><fmt:message key="eOR.Orderables.label" bundle="${or_labels}"/></td>
		<td class=label><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td class=label><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/></td>
		<td class=label></td>
		<td class=label></td>
		<td class=label></td>
	</tr>

	<tr>
		<td class=fields><input type='text' name='orderable0' id='orderable0' size='10'><input type=button name=search value='?'  class=button tabIndex="4" onClick="callOrderableSearch()"></td>
		<td class=fields><input type='text' name='order_type0' id='order_type0' size='10'></td>
		<td class=fields><input type='text' name='order_date0' id='order_date0' size='10'></td>
		<td class=fields><input type='text' name='freq0' id='freq0' size='10'></td>
		<td class=fields><input type='text' name='frequ0' id='frequ0' size='10'></td>
		<td class=fields><a href='javascript: dummy()' onClick='repeatRecord(0)'><img src='../../eCommon/images/mandatory.gif' align=center></td>
	</tr>

</table>


<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%//=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%//= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>">

</form>

</body>
</html>

