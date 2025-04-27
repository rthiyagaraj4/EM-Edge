<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eXH.XHUtil,eXH.XHDBAdapter" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<head>
<TITLE>SS Monthly - OPD Social Security Privilege Usage Output</TITLE>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eXB/js/opIPOBReport.js"></script>
<script language="javascript" src="../../eXH/js/InterfaceUtil.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	String locale = (String)session.getAttribute("LOCALE");
	String p_facility_id = (String) session.getValue("facility_id");
%>

</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<form name="ssMonOPDCriteria" id="ssMonOPDCriteria" method='post'>
<table width='100%'>
<tr align="center">
	<td class='LABEL'><fmt:message key="eXH.OP_Mon_Year.Label" bundle="${xh_labels}"/></td>
	<td class='fields'>
		<input type='text' name='opdDate' id='opdDate' id='opdDate' onBlur='xhBeforeNow(this, "MY")'>
		<input type='image' name='showcalndr' id='showcalndr' id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('opdDate','mm/y');"  >
		<img src='../../eCommon/images/mandatory.gif' align='middle'>
	</td>
</tr>
<tr align="center">
	<td class='LABEL'><fmt:message key="eXH.PAYER_CODE.Label" bundle="${xh_labels}"/></td>
	<td class='fields'>
		<input type='text' name='payer1Desc' id='payer1Desc' id='payer1Desc' onBlur="payerSearch(payer1Desc,payer1)">
		<input type='hidden' name='payer1' id='payer1' id='payer1'>
		<input class="BUTTON" type="button" name="payerSearch1" id="payerSearch1" value='?' onClick="payerSearch(payer1Desc,payer1)">
		<img src='../../eCommon/images/mandatory.gif' align='middle'>
	</td>
</tr>
<tr align="center" style="display:none;">
	<td class='LABEL'>Payer2</td>
	<td class='fields'>
		<input type='text' name='payer2Desc' id='payer2Desc' id='payer2Desc' onBlur="payerSearch(payer2Desc,payer2)">
		<input type='hidden' name='payer2' id='payer2' id='payer2'>
		<input class="BUTTON" type="button" name="payerSearch2" id="payerSearch2" value='?' onClick="payerSearch(payer2Desc,payer2)">
	</td>
</tr>
<tr align="center" style="display:none;">
	<td class='LABEL'>Payer3</td>
	<td class='fields'>
		<input type='text' name='payer3Desc' id='payer3Desc' id='payer3Desc' onBlur="payerSearch(payer3Desc,payer3)">
		<input type='hidden' name='payer3' id='payer3' id='payer3'>
		<input class="BUTTON" type="button" name="payerSearch3" id="payerSearch3" value='?' onClick="payerSearch(payer3Desc,payer3)">
	</td>
</tr>
<tr>
	<td colspan="2" CLASS="button">
		<INPUT TYPE="button" VALUE='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="opdDataProcess()">
	</td>
</tr>
</table>

<INPUT TYPE="hidden" name="locale" id="locale" VAlUE="<%= locale %>">
<INPUT TYPE="hidden" name="facilityID" id="facilityID" VAlUE="<%= p_facility_id %>">

</form>

</BODY>
</HTML>

