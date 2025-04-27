<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"	import="java.util.*,ePH.*,ePH.Common.*,eCommon.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)||(session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE"): "IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script type="text/javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhRepPatientDrugProfileList.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String bean_id = "PHReportsBean";
	String bean_name = "ePH.PHReportsBean";
	PHReportsBean bean = (PHReportsBean) getBeanObject(	bean_id, bean_name, request);
	bean.setLanguageId(locale);
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()"	onload="document.formPatientDrugProfileList.p_patient_id.focus()">
		<form name="formPatientDrugProfileList" id="formPatientDrugProfileList" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
			<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0">
				<TH COLSPAN="8" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}" /></TH>
				<tr>
					<td class="label" width='10%'><fmt:message key="Common.patientId.label" bundle="${common_labels}" /></td>
					<td class="feild" width='18%'>
						<input type="text" name="p_patient_id" id="p_patient_id" maxlength="<%=bean.getPatientIDLength()%>" size="20" onChange="Duplicatecheck();populateEncounter();" onKeyPress="changeToUpper();">
						<input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="callPatientSearch(document.formPatientDrugProfileList.p_patient_id);populateEncounter();">&nbsp;<img
						src="../../eCommon/images/mandatory.gif">
					</td>
					<td class="label" width='13%'><fmt:message key="Common.periodfrom.label" bundle="${common_labels}" /></td>
					<td class="feild" width='15%'><input type="text" name="p_period_from" id="p_period_from" size="8" value="" maxlength="10" onBlur="CheckDateT(this);validate_date(this);">
						<IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="showCalendar('p_period_from');document.formPatientDrugProfileList.p_period_from.focus();return false;">&nbsp;
					</td>
					<td class="label" width='10%'><fmt:message key="Common.to.label" bundle="${common_labels}" /></td>
					<td class="feild" width='15%' ><input type="text" name="p_period_to" id="p_period_to" size="8" value="" maxlength="10" onBlur="CheckDateT(this);validate_date(this);">
						<IMG SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="showCalendar('p_period_to');document.formPatientDrugProfileList.p_period_to.focus();return false;">&nbsp;
						</td>
					<td class="label" width='10%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}" /></td>
					<td class="feild" width='10%'>
						<select name="p_patient_class" id="p_patient_class" onChange="populateEncounter(); ">
							<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
							<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}" /></option>
							<option value="OP"><fmt:message key="Common.Outpatient.label"bundle="${common_labels}" /></option>
							<option value="XT"><fmt:message key="Common.external.label"bundle="${common_labels}" /></option>
							<option value="OP"><fmt:message key="Common.emergency.label"bundle="${common_labels}" /></option>
							<option value="IP"><fmt:message key="Common.daycare.label"bundle="${common_labels}" /></option>
						</select>
					</td>
				</tr>
				<tr><td colspan='8'>&nbsp;</td></tr>
				<tr>
					<td class="label" valign='top'><fmt:message key="Common.status.label" bundle="${common_labels}" /></td>
					<td class="feild" valign='top'>
						<select name="p_status" id="p_status" size="14" multiple="multiple">
							<option  value="ALL" selected="selected" ><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
							<option value="AL"><fmt:message key="ePH.Allocated.label" bundle="${ph_labels}" /></option>
							<option value="CN"><fmt:message key="Common.cancelled.label" bundle="${common_labels}" /></option>
							<option value="DC"><fmt:message key="Common.Discontinued.label" bundle="${common_labels}" /></option>
							<option value="DF"><fmt:message key="ePH.DispensedComplete.label" bundle="${ph_labels}" /></option>
							<option value="DP"><fmt:message key="ePH.DispensedPartial.label" bundle="${ph_labels}" /></option>
							<option value="IP"><fmt:message key="ePH.InProcess.label" bundle="${ph_labels}" /></option>
							<option value="HC"><fmt:message key="ePH.OnHoldBycareProvider.label" bundle="${ph_labels}" /></option>
							<option value="HD"><fmt:message key="ePH.OnHoldByDepartment.label" bundle="${ph_labels}" /></option>
							<option value="OS"><fmt:message key="Common.Ordered.label" bundle="${common_labels}" /></option>
							<option value="PO"><fmt:message key="Common.PendingAuthorization.label" bundle="${common_labels}" /></option>
							<option value="PC"><fmt:message key="Common.PendingConsent.label" bundle="${common_labels}" /></option>
							<option value="PS"><fmt:message key="ePH.PendingSplAprvl.label" bundle="${ph_labels}" /></option>
							<option value="RG"><fmt:message key="Common.Registered.label" bundle="${common_labels}" /></option>
							<option value="UC"><fmt:message key="ePH.Uncollected.label" bundle="${ph_labels}" /></option>
							<option value="VF"><fmt:message key="ePH.Verified.label" bundle="${ph_labels}" /></option>
						</select>
					</td>
					<td class="label" valign='top'><fmt:message key="Common.DrugProfile.label" bundle="${common_labels}" /></td>
					<td class="feild" valign='top'>
						<select name="p_drug_profile" id="p_drug_profile" >
							<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}" /></option>
							<option value="I"><fmt:message key="ePH.Internaldrugs.label" bundle="${ph_labels}" /></option>
							<option value="E"><fmt:message key="ePH.Externaldrugs.label" bundle="${ph_labels}" /></option>
							<option value="M"><fmt:message key="Common.MedicalItem.label" bundle="${common_labels}" /></option>
						</select>
					</td>
					<td class="label"valign='top'><label id='encounter_lable'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></label></td>
					<td class="feild" valign='top' colspan='3'><select name="p_encounter_id" id="p_encounter_id"><option><fmt:message key="Common.all.label" bundle="${common_labels}"/></option></select>
					</td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_order_status" id="p_order_status" VALUE="">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPATDRGPFLIST"> 
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%=session.getValue("facility_id")%>">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%=bean_name%>">
		</form>
	</body>
<%
	putObjectInBean(bean_id, bean, request);
%>
</html>

