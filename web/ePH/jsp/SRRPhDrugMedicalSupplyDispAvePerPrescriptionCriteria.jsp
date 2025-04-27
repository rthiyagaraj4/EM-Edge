<!DOCTYPE html>
	 <%-- saved on 16/2/2010 --%>
	<%-- JSP Page specific attributes start --%>
	<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
	<%-- JSP Page specific attributes end --%>
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

	<%-- Mandatory declarations start --%>

	<%-- Mandatory declarations end --%>
	<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

	<html>
	<head>

	<% 
			request.setCharacterEncoding("UTF-8");
			String locale			= (String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
			(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/SRRPhDrugMedicalSupplyDispAvePerPrescription.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		String bean_id			= "SRRPHDrugUsageByPractBean" ;
		String bean_name		= "ePH.SRRPHDrugUsageByPractBean";
		SRRPHDrugUsageByPractBean bean = (SRRPHDrugUsageByPractBean)getBeanObject( bean_id,bean_name,request ) ;
		bean.setLanguageId(locale);
		String bl_interface_yn = bean.checkforbillinginterface();
		String visibility = "";
		if (bl_interface_yn.equals("Y")){
		 visibility = "visibility:visible";
		}else
			visibility = "visibility:hidden";
		String sql_ph_nursing_unit_select	=	"SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";

		String sql_ph_clinic_select			=	"SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND upper(CLINIC_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) AND A.LANGUAGE_ID = ";
%>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="populateDispLocs()"> 
	<form name="formDispAvgPerPres" id="formDispAvgPerPres" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<TH COLSPAN="4" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		
		<tr><td class='label' colspan='4' height='6'></td></tr>

		<tr>
		<td align="right" class="label" ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td  align="left" >
			<input type="text" size="10" maxlength="10" name="dt_from" id="dt_from" OnBlur='CheckDate(this)'>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
		</td>
		<td> &nbsp;
			<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
			&nbsp;&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="text" size="10" maxlength="10" name="dt_to" id="dt_to" OnBlur='CheckDate(this)'>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
		</tr>

		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="ePH.TimeHH:MM.label" bundle="${ph_labels}"/> </td>	
			<td  align="left">
				<input type='text' name='p_disp_time_from' id='p_disp_time_from' size='15' maxlength='5' value=''  onkeypress='return allowPositiveNumber()' onBlur='ChkSplChars_time(this);' /> &nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
				<td><label class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></label>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='text' name='p_disp_time_to' id='p_disp_time_to' size='15' maxlength='5' value=''  onkeypress='return allowPositiveNumber()'  onBlur='ChkSplChars_time(this);'  />&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="ePH.DispenseLocationType.label" bundle="${ph_labels}"/></td>
			<td align="left">
				<SELECT name="p_disp_type" id="p_disp_type" style="width:150px" onChange= "populateDispLocs()">
					<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
					<option value ="P"><fmt:message key="Common.pharmacy.label" bundle="${common_labels}"/></option>
					<option value ="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<option value ="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				</select>
			</td>		
			<td  class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>&nbsp;
				<select name="p_disp_locn" id="p_disp_locn" style="width:150px">
				</select>
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td align="left">
				<SELECT name="p_patient_class" id="p_patient_class" style="width:150px">
					<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
					<option value ="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
					<option value ="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
					<option value ="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value ="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value ="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
				</select>
			</td>		
			<td  class="label"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<SELECT name="p_drug_class" id="p_drug_class" style="width:150px">
					<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
					<option value ="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
					<option value ="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
					<option value ="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
		</tr>

		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td>
				<SELECT name="p_locn_type" id="p_locn_type" style="width:150px" onChange ='clearLocation();'>
					<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
					<option value ="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<option value ="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<td class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="locn_text" id="locn_text" size="20" value="" ><INPUT TYPE="button" name="locn_lookup_btn" id="locn_lookup_btn" VALUE="?" CLASS="button"  onClick="callLocationLookup(locn_text);" >
				<input type="hidden" name="p_locn_code" id="p_locn_code" value ="" /> 
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr style="<%=visibility%>">
			<td  class='label'><label><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></label></td>
			<td >
				<input type=text name="billing_from" id="billing_from" readonly maxlength="30"  size="30" value="" />
				<input TYPE="button" name="billing_button_from" id="billing_button_from" value="?" class="button"  onClick='selectbilling(billing_from,"from");' >
				<input type ='hidden' name='p_privilege_fm' id='p_privilege_fm' value =''/>
			</td>
			<td  class="label" nowrap><label><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type=text name="billing_to" id="billing_to" readonly maxlength="30"  size="30" value="" /><INPUT TYPE="button" name="billing_button_to" id="billing_button_to" VALUE="?" CLASS="button"  onClick='selectbilling(billing_to,"to");' >
				<input type ='hidden' name='p_privilege_to' id='p_privilege_to' value =''/>			
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td  class='label' align ='left'><fmt:message key="ePH.SpecialClinic.label" bundle="${ph_labels}"/></td>
			<td>
				<SELECT name="p_speciality_clinic" id="p_speciality_clinic" style="width:150px">
					<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>			
					<option value ="Y"><fmt:message key="ePH.SpecialClinic.label" bundle="${ph_labels}"/></option>
					<option value ="N"><fmt:message key="ePH.NonSpecialClinic.label" bundle="${ph_labels}"/></option>
				</select>
			</td>
			<td  class='label'><label><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/> </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<SELECT name="p_report_option" id="p_report_option" style="width:150px">	
					<option value ="WD"><fmt:message key="ePH.Weekday.label" bundle="${ph_labels}"/></option>
					<option value ="WE"><fmt:message key="ePH.Weekend.label" bundle="${ph_labels}"/></option>
					<option value ="HD"><fmt:message key="Common.Holiday.label" bundle="${common_labels}"/></option>
					<option value ="WH"><fmt:message key="ePH.WeekendHoliday.label" bundle="${ph_labels}"/></option>
					<option value ="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
				</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td  class='label'><label><fmt:message key="ePH.SelectBy.label" bundle="${ph_labels}"/> </label></td>
			<td>
				<SELECT name="p_select_by" id="p_select_by" style="width:175px">						
					<option value ="OD"><fmt:message key="ePH.OnlyDischargeMedication.label" bundle="${ph_labels}"/> </option>
					<option value ="ED"><fmt:message key="ePH.ExcludeDischargeMedication.label" bundle="${ph_labels}"/> </option>
					<option value ="A" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/>  </option>		
				</select>
			</td>
		</tr>
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	<input type="hidden" name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="PH">	
	<input type="hidden" name="p_reprint" id="p_reprint" value="Y">
	<input type="hidden" name="p_report_id" id="p_report_id" value="PHDISPAP" />		
	<input type="hidden" name="p_disp_date_from" id="p_disp_date_from" value="">
	<input type="hidden" name="p_disp_date_to" id="p_disp_date_to" value="">
	<input type="hidden" name="p_disp_loc_code" id="p_disp_loc_code" value="">
	<input type="hidden" name="p_report_exec_name" id="p_report_exec_name" value="">

	</form>
	<input type="hidden" name="sql_ph_nursing_unit_select" id="sql_ph_nursing_unit_select" value="<%=sql_ph_nursing_unit_select%>">
	<input type="hidden" name="sql_ph_clinic_select" id="sql_ph_clinic_select" value="<%=sql_ph_clinic_select%>">	
	</body>
	</html>

