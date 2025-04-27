<!DOCTYPE html>
 <%-- Added newly for the CRF-072 BRU by SureshKumar T --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, ePH.*, ePH.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/MedicationPlanReport.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="MedicationPlanReportform" id="MedicationPlanReportform" action="" target="messageFrame">
<%
	DispMedicationAllStages all_bean = (DispMedicationAllStages)getBeanObject( "DispMedicationAllStages", "ePH.DispMedicationAllStages",request);
	DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( "DispMedicationBean", "ePH.DispMedicationBean",request);
	String medplan_bean_id="MedicationPlannerBean";
	String medplan_bean_name="ePH.MedicationPlannerBean";
	MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request); 
	medplan_bean.setObject(dispBean);
	medplan_bean.setObject(all_bean);
	medplan_bean.setLanguageId(locale);
	ArrayList displocation = medplan_bean.getDispLocation();
	String Sysdate = com.ehis.util.DateUtils.getCurrentDate("DMY", locale);
	String currentdate = com.ehis.util.DateUtils.getCurrentDate("DMY", locale);
%>
		<table cellpadding="0" cellspacing="0" width="100%" align="center"
			border="0" id="prescriptionquerycriteriatable">
			<tr>
				<td class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}" /></td>
				<td class="field" width="20%"><input align="center"	type='text' name='patient_id' id='patient_id' size=20 value=""	onKeyPress="return CheckForSpecChars(event)"
					maxlength="<%=medplan_bean.getPatientIDLength()%>"	onblur="Duplicatecheck();">
					<input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button' onfocus="callPatientLookup();" onClick="callPatientLookup();">
					<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>
				<td class="label" nowrap><fmt:message key="ePH.DispenseDate.label" bundle="${ph_labels}" /></td>
				<td><input type="text" name="p_disp_date_from" id="p_disp_date_from" value="<%=currentdate%>" maxlength="10" size="10"
					onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_disp_date_from))validate_date(this,'TO_DATE_LESS_FROM')">
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_date_from');" onblur='p_disp_date_from.focus()'>&nbsp;
					<img name='mandatory' src="../../eCommon/images/mandatory.gif">
				</td>
				<td class="label" align="right" nowrap><fmt:message key="Common.to.label" bundle="${common_labels}" /></td>
				<td><input type="text" name="p_disp_date_to" id="p_disp_date_to" value="<%=currentdate%>" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_disp_date_to))validate_date(this,'TO_DATE_LESS_FROM')">
					<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_date_to');" onblur='p_disp_date_to.focus()'>&nbsp;
					<img name='mandatory' src="../../eCommon/images/mandatory.gif"> <INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE="">
				</td>
			</tr>
			<tr>
				<td class="label" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}" /></td>
				<td><input type="text" name="p_encounter" id="p_encounter" maxlength="20" size="20" onKeyPress="return CheckForSpecChars(event);"></td>
				<td class="label" nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}" /></td>
				<td><SELECT name="p_disp_locn_code" id="p_disp_locn_code">
						<OPTION VALUE="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" /> --- </OPTION>
						<%if (displocation.size() > 0)
								for (int i = 0; i < displocation.size(); i += 2) {
						%>
						<OPTION VALUE="<%=displocation.get(i)%>"><%=displocation.get(i + 1)%></OPTION>
						<%
							}
						%>
				</SELECT>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>
				<td>&nbsp;</td>
				<td><input type="button" name="btnSearch" id="btnSearch" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResults();"></td>
			</tr>
		</table>
<input type="hidden" name="p_order_id" id="p_order_id" value="">
<input type="hidden" name="p_fm_order_id" id="p_fm_order_id" value="">
<input type="hidden" name="p_to_order_id" id="p_to_order_id" value="">
<input type="hidden" name="p_patclass" id="p_patclass" value="">
<input type="hidden" name="p_locncode" id="p_locncode" value="">
<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%=session.getValue("facility_id")%>">
<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%=session.getValue("login_user")%>">
<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHPRMEDPL">
<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
</form>
<%
	putObjectInBean(medplan_bean_id,medplan_bean,request);
%>
</body>
</html>

