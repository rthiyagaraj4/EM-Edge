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
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
24/08/2013    IN030284		Chowminya G 	Created:To capture Pre-consultation orders in Appointment Scheduling
---------------------------------------------------------------------------------------------------------------
-->
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%		String bean_id = "refusalOrdersBean" ;
		String bean_name = "eOR.RefusalOrdersBean";
%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String appt_ref_no=(request.getParameter("appt_ref_no")==null||request.getParameter("appt_ref_no").equals("null"))?"":request.getParameter("appt_ref_no");
		String Mode=(request.getParameter("Mode")==null||request.getParameter("Mode").equals("null"))?"":request.getParameter("Mode");
		String facilityid=(request.getParameter("facilityid")==null||request.getParameter("facilityid").equals("null"))?"":request.getParameter("facilityid");
		String recordyn = "enable";
		if(!"Record".equals(Mode))
			recordyn = "disabled";		
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eOR/js/ORApptOrderSelection.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</head>
	
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
	<center>
	<form name='OrderSelectionRecord' id='OrderSelectionRecord'>
	<p align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'  align='center'>
		<tr >
		<td class=label width='25%' >&nbsp;</td>		
        
		<td width='25%' ></td>
		<td  width='25%' align='right'>
			<input type='BUTTON' class='BUTTON' name='record' id='record' <%=recordyn%> value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' onClick='Add();'>&nbsp;
			<input type='BUTTON' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='Cancel();'>&nbsp;&nbsp;
		<input type=hidden name='facilityid' id='facilityid' value='<%=facilityid%>'>
		<input type=hidden name='Mode' id='Mode' value='<%=Mode%>'>
		<input type=hidden name='bean_id' id='bean_id' value='<%=bean_id%>'>
		<input type=hidden name='bean_name' id='bean_name' value='<%=bean_name%>'>
		<input type=hidden name='appt_ref_no' id='appt_ref_no' value='<%=appt_ref_no%>'>
		<input type=hidden name='mode' id='mode' value='1'>
		</td>
		</tr>
		</table>
	</p>
	</form>
	</center>
</body>
</html>

