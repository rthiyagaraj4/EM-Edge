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
<%@ page import="eSS.ReturnGroupBean,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>
 

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle			=			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/ReturnGroup.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String mode				 =			request.getParameter("mode");

		if ((mode == null) || (mode.equals(""))) 
			return;
		if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;
		mode					 =			mode.trim();

		String bean_id			 =			"returnGroupBean";
		String bean_name		 =			"eSS.ReturnGroupBean";
		String disabled			 =			"";
		String visibility		 =			"visibility:hidden";// Added by Rabbani #Inc no:39364 (Bru-HIMS-CRF-360) on 30-Apr-2013  

		ReturnGroupBean bean	 =			(ReturnGroupBean) getBeanObject( bean_id, bean_name, request );	
		bean.setMode(mode);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		bean.setLanguageId(locale);
		String binValues		=			bean.getSsRepositoryValue("DEFAULT_LIST_OPTION");

		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			disabled			=			"disabled";
		}
		else {
			bean.clear();
		}
	%>
	<body onLoad="getPatientName(document.forms[0].patient_id,document.forms[0].patient_name,document.forms[0]);"onMouseDown="CodeArrest()">
		<form name="formReturnGroupDetail" id="formReturnGroupDetail" action="../../eSS/jsp/ReturnGroupList.jsp" method="post" target="frameReturnGroupList">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' height='100%' align='center' valign='top'>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'>
					<tr>
						<td>&nbsp;</td><td>&nbsp;</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td><td class="label">&nbsp;&nbsp;<input type="text" name="group_desc" id="group_desc" size="12" maxlength =  "12" value="<%=bean.checkForNull(bean.getGroup_code())%>" disabled >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center><a style = "CURSOR:DEFAULT" href='javascript:details();'  disabled id='details'><fmt:message key="Common.details.label" bundle="${common_labels}"/>&nbsp&nbsp</a></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></td><td class="label">&nbsp;&nbsp;<input type="text" name="tray_no" id="tray_no" size="12" maxlength =  "12" class="NUMBER" value="<%=bean.checkForNull(bean.getTray_no())%>" disabled >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
					<tr>
						<!-- Default to previous bin_location from ss_tray_dtls -->
						<td  class="label"><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></td><td class="label">&nbsp;&nbsp;<select name="bin_location_code" id="bin_location_code" disabled><%=binValues%></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.Expired.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;<input type="checkbox" name="expired_yn" id="expired_yn" value="N" disabled></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="Common.used.label" bundle="${common_labels}"/></td><td class="label" >&nbsp;<input type="checkbox" name="used_yn" id="used_yn" disabled onClick="canDisableDiscrepancy(this);"></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td><td class="label" >&nbsp;&nbsp;<input type="text" name="patient_id" id="patient_id" size=20 maxlength=20 onBlur= "return getPatientName(patient_id,patient_name,formReturnGroupDetail);" disabled><input class="button" onClick="return callPatientSearch(patient_id,patient_name,formReturnGroupDetail);" type="button" name="cmdPatientSearch" id="cmdPatientSearch" value="?" disabled></td>
					</tr>
					<tr>
						<td align="right" class="label"><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td><td class="label" >&nbsp;&nbsp;<input type="text" name="patient_name" id="patient_name" size=20 disabled></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="eSS.Sterilize.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;<input type="checkbox" name="sterilize_yn" id="sterilize_yn" onClick="checkSterilized();" disabled></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="eSS.Wash.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;<input type="checkbox" name="wash_yn" id="wash_yn" disabled></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;<input type="checkbox" name="pack_yn" id="pack_yn" disabled></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.Contaminated.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;<input type="checkbox" name="contaminated_yn" id="contaminated_yn" disabled></td>
					</tr>
					<tr>
						<td  class="label"><fmt:message key="eSS.ChargeConsumables.label" bundle="${ss_labels}"/></td><td class="label" >&nbsp;<input type="checkbox" name="charge_consumable_yn" id="charge_consumable_yn" disabled></td>
					</tr>
					<!-- Added by Rabbani #Inc no:39364 (Bru-HIMS-CRF-360) on 30-Apr-2013 -->
				
					<tr>
					<td class="label"><fmt:message key="eSS.Reason.label" bundle="${ss_labels}"/></td><input type="hidden" name="remarks_code" id="remarks_code" value=""><td class="label" >&nbsp;<textarea name="remarks" rows="3" cols="40" onpaste="" disabled readonly onpaste="return false;" Onblur="validateRemarksDetail();"></textarea><input type='button' class='BUTTON' name='remark' id='remark' value='?' disabled onClick="searchRemarks(remarks_code,remarks);" ><img id="img_remarks"  src="../../eCommon/images/mandatory.gif" style="<%=visibility%>" /></td> 
					</tr>
				
					<tr></tr>
					<!-- ends -->
					<tr>
						<td class="label" colspan='3'>
							<input type="button" value="Discrepancy" name="discrepancy" id="discrepancy" class="BUTTON" disabled onClick="return showDiscrepancyDetails(patient_id,group_code,tray_no);">
							<input type="button" value="Modify" name="modify" id="modify" class="BUTTON" disabled onClick="return updateTrayDetail();">
							<input type="button" value="Cancel" name="cancel" id="cancel" class="BUTTON" disabled onClick="disableAndResetForm(formReturnGroupDetail);">
							
						</td>
					</tr>
				</table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="mode" id="mode"				value="<%=mode%>">
			<input type='hidden' name="table_row_index" id="table_row_index"		value="-1">
			<input type='hidden' name="group_code" id="group_code"			value="">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="updated" id="updated"				value="N">
			<input type="hidden" name="language_id" id="language_id"			value="<%=locale%>">
			<input type="hidden" name="SQL_SS_TRN_REMARKS_LOOKUP_SELECT" id="SQL_SS_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRN_REMARKS_LOOKUP_SELECT")%>">
		</form>
	</body>
	<%
			putObjectInBean(bean_id,bean,request); 
	%>

</html>

