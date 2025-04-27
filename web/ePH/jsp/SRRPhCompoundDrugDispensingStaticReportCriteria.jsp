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
		<script LANGUAGE="javascript" src="../../ePH/js/SRRPhrugAndMedicalSupplyReturnAvePerReturnVoucher.js"></script>
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
		%>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="populateDispLocs()"> 
	<form name="FormCompoundingDrugDispensingStaticReportCriteria" id="FormCompoundingDrugDispensingStaticReportCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
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
				<input type='text' name='p_time_from' id='p_time_from' size='15' maxlength='5' value=''  onkeypress='return allowPositiveNumber()' onBlur='ChkSplChars_time(this);' /> &nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
				<td><label class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></label>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type='text' name='p_time_to' id='p_time_to' size='15' maxlength='5' value=''  onkeypress='return allowPositiveNumber()'  onBlur='ChkSplChars_time(this);'  />&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
			</td>
		</tr>
		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td align="right" class="label"><fmt:message key="ePH.DispenseLocationType.label" bundle="${ph_labels}"/></td>
			<td align="left">
				<SELECT name="p_disp_locn_type" id="p_disp_locn_type" style="width:150px" onChange= "populateDispLocs()">
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
			<td align="right" class="label"><fmt:message key="Common.ProductName.label" bundle="${common_labels}"/></td>
			<td align="left"><input type="text" name="p_product_name" id="p_product_name" size="60" value="">
			
			</td>		
			<td  class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name='p_search_by' id='p_search_by'>
					<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
					<option value="C" selected><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>

		<tr><td class='label' colspan='4' height='6'></td></tr>
		<tr>
			<td  class='label' align ='left'><fmt:message key="ePH.SpecialClinic.label" bundle="${ph_labels}"/></td>
			<td>
				<SELECT name="p_spl_clinic" id="p_spl_clinic" style="width:150px">
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
		
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	<input type="hidden" name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="p_reprint" id="p_reprint" value="Y">
	<input type="hidden" name="p_report_id" id="p_report_id" value="PHCOMPDRGSTAT">
	<input type="hidden" name="p_module_id" id="p_module_id" value="PH">
	<input type="hidden" name="p_report_name" id="p_report_name" value="">
	<input type="hidden" name="p_report_exec_name" id="p_report_exec_name" value="">
	<input type="hidden" name="p_frm_date" id="p_frm_date" value="">
	<input type="hidden" name="p_to_date" id="p_to_date" value="">
	<input type="hidden" name="p_frm_time" id="p_frm_time" value="">
	<input type="hidden" name="p_to_time" id="p_to_time" value="">
	<input type="hidden" name="p_disp_locn_code" id="p_disp_locn_code" value="">
	
	

	</form>
	<% putObjectInBean(bean_id,bean,request); %>
	</body>
	</html>

