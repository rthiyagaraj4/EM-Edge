<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?          	created
15/10/2013	  IN041155		Karthi L		Preview screen opens and Billing details are displayed
11/02/2019	IN069657	Dinesh  T	11/02/2019	Ramesh G	IN069657	
07/06/2020  IN072654	Nijitha S     		07/06/2020		Ramesh G		MMS-KH-CRF-0029.4
---------------------------------------------------------------------------------------------------------
-->

<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html; charset=UTF-8" %><!--  modified for IN041155 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String bean_id					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	String called_from 				= request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String displayRefresh = "display:inline";
	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ; //IN041155
	String show_bill_info_yn = bean.getBillingInterfaceShowYn(); //IN041155
	String l_hide_refresh = request.getParameter("hideRefresh")==null?"":request.getParameter("hideRefresh");//IN069657
	//IN069657, starts
	/*if(called_from.equals("OP_VISIT_REG"))
		displayRefresh = "display:none";
	else
		displayRefresh = "display:inline";*/
	
	if("Y".equals(l_hide_refresh) || called_from.equals("OP_VISIT_REG"))
		displayRefresh = "display:none";	
	//IN069657, ends
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryPreview.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
	<script language="Javascript" src="../../eOR/js/OrderEntryTab.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
   	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name ="buttonForm">
  

<table border="0" cellpadding="3" cellspacing="0" width="100%" height='50%' >

<tr>
   <td colspan="4" >

			<!--     <table cellpadding=0 cellspacing=0 border=0 width='100%' align='center' style='border-width:0' height='50%' id="billing_dtl" > IN041155 --> 	
			<table cellpadding=0 cellspacing=0 border=0 width='100%' align='center' <%if(show_bill_info_yn.equals("Y")) {%>style='border-width:0;display:inline'<%}else{%>style='border-width:0;display:none' <%}%> height='50%' id="billing_dtl" >      <!-- IN041155 -->
		<tr >	
			<td colspan="" class="label" width="65%" style='border-width: 0;text-align: right;font-size: 3%'><font class='label' size="10"><B><fmt:message key="Common.total.label" bundle="${common_labels}"/> <fmt:message key="Common.Charge.label" bundle="${common_labels}"/>:</B></font></td>
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

   </td>
</tr>

<tr>
	<td  width="20%" class="data" id="order_mandatory"></td><!-- Changed width for IN072654  -->
	<td  width="20%" class="intraction"  id="drug_interaction">&nbsp;</td><!-- Added for IN072654  -->
	<td  width="4%" class="eORConsent"></td>
	<td  width="40%" class="data"><fmt:message key="eOR.ConsentRequiredfromthePatient.label" bundle="${or_labels}"/></td>
	<td class="button" id="EmailPreview" style="display:none"><input type="button" name="Email" id="Email"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.EmailPreview.label","or_labels")%>" onclick="parent.parent.email('<%=bean_id%>','<%=bean_name%>')"></td>
	<td class="white" align="right"><input type="button" name="refresh" id="refresh" class="BUTTON" style="<%=displayRefresh%>" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Refresh.label","common_labels")%>" title ="Refresh" onClick="parent.parent.previewRefresh()"><input type="button" name="record" id="record" id="recordApply" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Release.label","common_labels")%>" title ="Release"  onClick="apply()">
</tr>
</table>
	<input type="hidden" name="hdr_format_mandatory_count" id="hdr_format_mandatory_count" value="0">
	<input type="hidden" name="hdr_format_count" id="hdr_format_count" value="0">
	<input type="hidden" name="line_level_mandatory_yn" id="line_level_mandatory_yn" value="N">
	<input type="hidden" name="format_id_yn" id="format_id_yn" value="N">
</form>
</body>
</html>

