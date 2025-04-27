<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection, java.util.*, java.text.*, java.sql.*, java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager, webbeans.eCommon.*, eXB.*, com.ehis.util.DateUtils" contentType="text/html;charset=UTF-8"  %> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
  
<html>
<head>
 
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String locale = (String)session.getAttribute("LOCALE");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eXB/js/ProcessDocFee.js"></script>
<script language="javascript" src="../../eXH/js/InterfaceUtil.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<html>
<TITLE>Process Doctor Fee Delivery Transaction</TITLE>
</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = "lockKey();" onLoad="initFunc()">
<form name='ssMonDPReportForm' id='ssMonDPReportForm' method='post' action='../../servlet/eXB.ProcessDocFeeServlet' target='schemaBrowserResultFrame'>
<table align='center' valign='top'>
	<tr>
		<td class='label'><fmt:message key="Common.CurrentProcessMonth/Year.label" bundle="${common_labels}"/>(MM/YYYY)</td>
		<td class='fields'>
			<input type='text' name='processDate' id='processDate' id='processDate' onBlur="xhBeforeNow(this,'MY')">
			<input type='image' name='showcalndr' id='showcalndr' id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('processDate','mm/y');"  >
			<img src='../../eCommon/images/mandatory.gif' align='middle'>
		</td>
		<td><input class="button" type="button" name='process' id='process' value='<fmt:message key="Common.Process.label" bundle="${common_labels}"/>' onClick='submitForm()'></td>
	</tr>
</table>

<input type='hidden' id='locale' value='<%= locale %>'>

</form>

</BODY>
</HTML>

