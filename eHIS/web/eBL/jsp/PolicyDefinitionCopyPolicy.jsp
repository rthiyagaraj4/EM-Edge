<!DOCTYPE html>
<!-- 
Sr No        Version             TFS			SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201207            9896		  MMS-KH-SCF-0114       Ramkumar/MuthuN
-----------------------------------------------------------------------------------
-->
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Copy Policy</title>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

	String locale = request.getParameter("locale");
	String facility_id = request.getParameter("facility_id"); 
	String toPayerCode = request.getParameter("toPayerCode");
	String toPayer = request.getParameter("toPayer"); 
	String toPolicy = request.getParameter("toPolicy");
	String startDate = request.getParameter("startDate");
	String endDate = request.getParameter("endDate");
	//V201207
	Connection con = null;
	con = ConnectionManager.getConnection(request);
	Boolean siteSpecPolDefRemarks=false;
	siteSpecPolDefRemarks = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","BL_POLICY_DEF_REMARKS_ALLOWED");
	//V201207	
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<body>
<form name='frmCopyPolicy' id='frmCopyPolicy' method='post'>
	<table width="90%" align="center">
		<tr>
			<td width='35%' class='label' ><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
			<td width='65%' class='fields' >
				<input type='text' name='payerGroup2' id='payerGroup2' size='40' maxlength='40' value='' onblur='if(this.value!=""){ callCommonValidation(3,payerGroup2,payerCode2); validateCopyPolicy(payerCode2,payerCode,policyTypeCode)}'/>
				<input type='hidden' name='payerCode2' id='payerCode2' value=''>
				<input type='button' class='button' name="payerGroup2_btn" id="payerGroup2_btn" value='?' onClick="callCommonValidation(3,payerGroup2,payerCode2);validateCopyPolicy(payerCode2,payerCode,policyTypeCode);" tabindex='2'>
				<img src='../../eCommon/images/mandatory.gif'>
			</td>   
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td  width='35%' class='label' ><fmt:message key="eBL.PAYER.label" bundle="${bl_labels}"/></td>
			<td  width='65%' class='fields' >
				<input type='text' name='payerGroup1' id='payerGroup1' size='40' maxlength='40'  value='' onblur='if(this.value!=""){ callCommonValidation(2,payerGroup1,payerCode);validateCopyPolicy(payerCode2,payerCode,policyTypeCode);}'/>
				<input type='hidden' name='payerCode' id='payerCode' value=''>
				<input type='button' class='button' name="payerGroup1_btn" id="payerGroup1_btn" value='?' onClick="callCommonValidation(2,payerGroup1,payerCode);validateCopyPolicy(payerCode2,payerCode,policyTypeCode);" tabindex='2'>
				<img src='../../eCommon/images/mandatory.gif'>
			</td>   
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>		
		<tr>
			<td  width='35%' class='label' ><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/></td>
			<td  width='65%' class='fields' >
				<input type='text' name='policyType' id='policyType' size='40' maxlength='40' value='' onblur='if(this.value!=""){ callCommonValidation(4,policyType,policyTypeCode);validateCopyPolicy(payerCode2,payerCode,policyTypeCode);}'/>
				<input type='hidden' name='policyTypeCode' id='policyTypeCode' value=''>
				<input type='button' class='button' name="policyType_btn" id="policyType_btn" value='?'  onClick="callCommonValidation(4,policyType,policyTypeCode);validateCopyPolicy(payerCode2,payerCode,policyTypeCode);" tabindex='2'>
				<img src='../../eCommon/images/mandatory.gif'>
			</td>  
		</tr>
		<tr>
			<td>
				&nbsp;
			</td>
		</tr>
		<tr>
			<td width='35%'></td>
			<td width='65%'>
			<input type='button' class='button' value='Apply' onclick='fnApplyCopyPolicy(payerCode2,payerCode,policyTypeCode)'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class='button' type='button' value='Cancel' onclick='fnCancelCopyPolicy()'></td>
		</tr>
	</table>
	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
    <input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
	<input type='hidden' name='toPayerCode' id='toPayerCode' value='<%=toPayerCode %>'>
    <input type='hidden' name='toPayer' id='toPayer' value='<%=toPayer %>'>
	<input type='hidden' name='toPolicy' id='toPolicy' value='<%=toPolicy %>'>
	<input type='hidden' name='startDate' id='startDate' value='<%=startDate %>'>
	<input type='hidden' name='endDate' id='endDate' value='<%=endDate %>'>
	<!-- V201207 -->
	<input type='hidden' name='pageInfo' id='pageInfo' id='pageInfo' value='PolicyInfo'>
	<input type='hidden' name='siteSpecPolDefIncExc' id='siteSpecPolDefIncExc' id='siteSpecPolDefIncExc' value="<%=siteSpecPolDefRemarks %>">
	<input type='hidden' name="siteSpecPolDefRemarks" id="siteSpecPolDefRemarks" id="siteSpecPolDefRemarks" value="<%=siteSpecPolDefRemarks %>">
	<!-- V201207 -->
</form>
</body>
</html>

