<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            ?           	 created
11/12/2013  IN045512		Nijithas	    The dependent field option is not displayed in View Order Format
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
17/02/2020	IN071260		Nijitha S	17/02/2020		Ramesh G		MMS-KH-CRF-0029.3
23/08/2020	IN073695	 	Durga N		23/08/2020		Ramesh G 		OR-Common-Health Risk Assessment
---------------------------------------------------------------------------------------------------------------
--> 
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title></title>

<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntry1.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryCalendar.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntryTab.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name ="buttonForm" id ="buttonForm">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String order_category			= request.getParameter("order_category");
		String user_id = (String)session.getValue("login_user");
		String oledb_con_string=(String)session.getValue("oledb_con_string");
		String bean_id			= request.getParameter("bean_id");
		String bean_name 		= request.getParameter("bean_name");
		String function_from 	= request.getParameter("function_from"); //IN073695
%>
		<table cellpadding=0 cellspacing=0 border=0 width='100%' align='center' style='border-width:0' height='50%' id="billing_dtl" style="visibility:hidden"> 
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
		<table border="0" cellpadding="0" cellspacing="0" width="100%" height='50%'>
			<tr>
				<td  width="20%" class="data"  id="order_mandatory">&nbsp;</td>
				<td  width="20%" class="intraction"  id="drug_interaction">&nbsp;</td><!-- Added for IN071260  -->
				<td width="4%" class="eORConsent">&nbsp;</td>
				<td  width="39%" class="data"><fmt:message key="eOR.ConsentRequiredfromthePatient.label" bundle="${or_labels}"/></td>
				<td  align="right"><%//if(order_category.equalsIgnoreCase("CS")){%><!--<input type="button" 	name="ph_details" id="ph_details" class="BUTTON" value ="PH Details" title ="PH Details" onClick="PharmacyDetails()">--><%//}%></td>
				<td  class="button" align='right'>
					<span id="EmailPreview" style="display:none">
						<input type="button" name="Email" id="Email"  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.EmailPreview.label","or_labels")%>" onclick="parent.parent.email('<%=bean_id%>','<%=bean_name%>')">
					</span>
					<%if(!order_category.equalsIgnoreCase("CS") && !function_from.equalsIgnoreCase("HIGH_RISK_ASSESS")){  // IN073695 remove Refresh button calling from place order in Helth Risk Assessment %>
					<input type="button" name="refresh" id="refresh"  style='width:30%' class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Refresh.label","common_labels")%>" title ="Refresh" onClick="parent.parent.refresh()">
					<%}%>
					<input type="button" name="record" id="record"  class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>" title ="Record"  onClick="apply();">
					<input type="button" name="preview" id="preview" id="recordPreview" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Preview.label","common_labels")%>" title ="Preview"  onClick="parent.parent.preview()">
				</td>
			</tr>
		</table>
			<input type="hidden" name="hdr_format_mandatory_count" id="hdr_format_mandatory_count" value="0">
			<input type="hidden" name="hdr_format_count" id="hdr_format_count" value="0">
			<input type="hidden" name="line_level_mandatory_yn" id="line_level_mandatory_yn" value="N">
			<input type="hidden" name="format_id_yn" id="format_id_yn" value="N">
			<input type="hidden" name="signature_flag" id="signature_flag" value="false">
			<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>">
			
			<input type="hidden" name="oledb_con_string" id="oledb_con_string" value="<%=oledb_con_string%>">
			<!--<input type="hidden" name="order_format_line_onload" id="order_format_line_onload" value="Y"> IN045512 -->

           <!--  <OBJECT ID="WebFp" CLASSID="CLSID:CA452A7B-737F-434D-904A-AB06E644C25F" CODEBASE="PrintFPCom.CAB#version=1,0,0,0" VIEWASTEXT></OBJECT> -->
		</form>
	</body>
</html>

