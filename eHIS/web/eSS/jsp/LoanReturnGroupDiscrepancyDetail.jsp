<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@ page import="eSS.LoanReturnGroupBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
 

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/LoanReturnGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String bean_id				=		"LoanReturnGroupBean";
		String bean_name			=		"eSS.LoanReturnGroupBean";
		String function_id			=		request.getParameter("function_id");
		String mode					=		request.getParameter("mode");
		String patient_id			=		request.getParameter("patient_id");
		String group_code			=		request.getParameter("group_code");
		String tray_no				=		request.getParameter("tray_no");
		String discrepancyMainKey	=		group_code + "-"+tray_no;

		group_code					=		group_code.trim();
		tray_no						=		tray_no.trim();
		LoanReturnGroupBean bean		=		(LoanReturnGroupBean) getBeanObject( bean_id, bean_name,  request);	
		bean.setGroup_code(group_code);
		bean.setLanguageId(locale);

		bean.selectDiscrepancyDetails(discrepancyMainKey);
		bean.loadIssueQty(group_code);


	
	%>
	<body onLoad="canAllowEdit('<%=group_code%>','<%=tray_no%>');"onMouseDown="CodeArrest()">
		<form name="formLoanReturnGroupDiscrepancyDetail" id="formLoanReturnGroupDiscrepancyDetail">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="eSS.Instruments.label" bundle="${ss_labels}"/></td><td class="label">&nbsp;&nbsp;<select name="item_code" id="item_code"><%=bean.getDiscrepancyItems()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
						
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.DiscrepancyReason.label" bundle="${ss_labels}"/></td><td class="label">&nbsp;&nbsp;<select name="write_off_reason_code" id="write_off_reason_code"><%=bean.getDiscrepancyReasons()%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
					<tr>
						<td class="label" valign="top"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><td class="label" >&nbsp;&nbsp;<textarea name="remarks" rows="3" cols="20" onKeyPress="return setTextAreaMaxLength(this, 200);"></textarea></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.DiscrepancyQuantity.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;&nbsp;<input type="text" name="discrepancy_qty" id="discrepancy_qty" size="15" maxlength = "15" class="NUMBER" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);return checkMaxQty(this);">&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td class="label" >&nbsp;&nbsp;<input type="text" name="patient_id" id="patient_id" size=20 maxlength="20" value="<%=patient_id%>" readOnly></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="eSS.ReturnableInstrument.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;<input type="checkbox" name="item_returnable_yn" id="item_returnable_yn" value="Y"></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td><td class="label" >&nbsp;&nbsp;<select name="encounter_id" id="encounter_id" >
						<%=bean.getEncounter_id_List(patient_id)%>
						</select></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.ChargeOption.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;&nbsp;<select name="charge_option" id="charge_option">
						<option value="N" selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
						<option value="C"><fmt:message key="eSS.Charge.label" bundle="${ss_labels}"/></option>
						<option value="D"><fmt:message key="eSS.Deposit.label" bundle="${ss_labels}"/></option></select></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.Cost.label" bundle="${ss_labels}"/></td><td class="label">&nbsp;&nbsp;<input type="text" name="charge_amt" id="charge_amt" class="NUMBER" disabled></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.ReceiptReference.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;&nbsp;<input type="text" name="rec_reference" id="rec_reference" size="20" maxlength = "20" ></td>
					</tr>
					<tr>
						<td align="center" class="label" colspan='2'>
							<input type="button" value="  Add  " name="modify" id="modify" class="BUTTON" onClick="return addToList();">
							<input type="button" value="Cancel" name="cancel" id="cancel" class="BUTTON" onClick="enableDiscreancySelect();">
							<input type="button" value="Close" name="close" id="close" class="BUTTON" onClick='closeMe();'>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
				</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="write_off_reason_desc" id="write_off_reason_desc"		value="">
			<input type='hidden' name="item_desc" id="item_desc"					value="">
			<input type='hidden' name="mode" id="mode"						value="<%=mode%>">
			<input type='hidden' name="table_index" id="table_index"					value="-1">
			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"					value="<%=function_id%>">
			<input type="hidden" name="patient_name" id="patient_name"				value="">
			<input type="hidden" name="max_qty" id="max_qty"						value="">
			<input type="hidden" name="table_row_index" id="table_row_index"				value="-1">
			<input type="hidden" name="group_code" id="group_code"					value="<%=group_code%>">
			<input type="hidden" name="tray_no" id="tray_no"						value="<%=tray_no%>">
			<input type="hidden" name="discrepancy_key" id="discrepancy_key"				value="<%=discrepancyMainKey%>">
<%
putObjectInBean(bean_id,bean,request); 
%>
		</form>
	</body>
</html>

