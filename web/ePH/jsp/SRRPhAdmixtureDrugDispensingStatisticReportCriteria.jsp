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
		<script LANGUAGE="javascript" src="../../ePH/js/SRRPhAdmixtureDrugDispensingStatisticReport.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String p_facility_id		= (String) session.getValue( "facility_id" ) ;
		//String bean_id				= "PHRepMednOrdStatBySrcBean" ;
		//String bean_name			= "ePH.PHRepMednOrdStatBySrcBean";
		//PHRepMednOrdStatBySrcBean bean	= (PHRepMednOrdStatBySrcBean)getBeanObject( bean_id,bean_name , request) ;
		//bean.setLanguageId(locale);

		String bean_id			= "SRRPHDrugUsageByPractBean" ;
		String bean_name		= "ePH.SRRPHDrugUsageByPractBean";
		SRRPHDrugUsageByPractBean bean = (SRRPHDrugUsageByPractBean)getBeanObject( bean_id,bean_name,request ) ;
		bean.setLanguageId(locale);
		String bl_interface_yn = bean.checkforbillinginterface();
		 ArrayList IVlegends = (ArrayList)bean.getIVLegends();
		String visibility = "";
		if (bl_interface_yn.equals("Y")){
		 visibility = "visibility:visible";
		}else
			visibility = "visibility:hidden";
			String ivlegend_option  = "";
			//for(int i=0;i<=IVlegends.size()-2;i=i+2){
				//if(i==2||i==6){
				//ivlegend_option		=ivlegend_option +	"<option value='"+((String) IVlegends.get(i))+"'>"+((String) IVlegends.get(i+1))+"</option>";
			//}
			//}
			for(int i=0;i<=IVlegends.size()-2;i=i+2){
				if(i==2){
				ivlegend_option		=ivlegend_option +	"<option value='2'>"+((String) IVlegends.get(i+1))+"</option>";
			}
			if(i==6){
				ivlegend_option		=ivlegend_option +	"<option value='4'>"+((String) IVlegends.get(i+1))+"</option>";
			}
			}

		
%>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="populateDispLocs()"> 
	<form name="AdmixtureDrugdispStatisticReportCriteriaForm" id="AdmixtureDrugdispStatisticReportCriteriaForm" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<TH COLSPAN="4" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		
		<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr>
		<td align="right" class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left"><SELECT name="p_report_type" id="p_report_type"   style="width:155px">
			<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
		   	<option value ="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
			<option value ="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>	
    	  </select>
		  &nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
        </td>
    </tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr>
        <td align="right" class="label"><fmt:message key="Common.Month/Year.label" bundle="${common_labels}"/></td>	
		<td  align="left">
			<input type='text' name='P_FRM_MONTH' id='P_FRM_MONTH' size='2' maxlength='2' value='' onBlur='checkMonth(this);ChkSplChars(this);' onkeypress='return allowPositiveNumber()' /> / 
			<input type='text' name='p_fm_year1' id='p_fm_year1' size='4' maxlength='4' value='' onBlur='checkYear(this);ChkSplChars(this);' onkeypress='return allowPositiveNumber()'  />
			&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
			<td>
			<label class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></label>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type='text' name='P_TO_MONTH' id='P_TO_MONTH' size='2' maxlength='2' value='' onBlur='checkMonth(this)' onkeypress='return allowPositiveNumber()' /> / <input type='text' name='p_to_year1' id='p_to_year1' size='4' maxlength='4' value='' onBlur='checkYear(this)' onkeypress='return allowPositiveNumber()' />&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
		</td>
		</tr>
		<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr>
        <td align="right" class="label"><fmt:message key="ePH.TimeHH:MM.label" bundle="${ph_labels}"/></td>	
		<td  align="left">
			<input type='text' name='p_frm_time' id='p_frm_time' size='15' maxlength='5' value='' onBlur='ChkSplChars_time(this);' onkeypress='return allowPositiveNumber()' /> &nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
			<td><label class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></label>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type='text' name='p_to_time' id='p_to_time' size='15' maxlength='5' value=''onkeypress='return allowPositiveNumber()'; onBlur='ChkSplChars_time(this);'  />&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center">
		</td>
		</tr>
		<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr>
        <td align="right" class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td align="left"><SELECT name="p_disp_locn_code" id="p_disp_locn_code"  maxlength="40">
		<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
		</select> &nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>		
		<td  class="label"><fmt:message key="ePH.TypeofOrder.label" bundle="${ph_labels}"/>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<select name="p_type_of_order" id="p_type_of_order" onChange="">
		            <option value="6"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
					<%=ivlegend_option%>
					<option value="8"><fmt:message key="ePH.TPNAdmixture.label" bundle="${ph_labels}"/></option>
					<option value="0"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
				</select>
				</td></tr>
		<tr><td class='label' colspan='4' height='4'></td></tr>
		<tr>
		<td  class='label' align ='left'><label><fmt:message key="ePH.SpecialClinic.label" bundle="${ph_labels}"/></td>
		<td>
		<SELECT name="p_specialist_clinic" id="p_specialist_clinic" style="width:150px">
		<option value =""> ---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------- </option>
	
		<option value ="Y"><fmt:message key="ePH.SpecialClinic.label" bundle="${ph_labels}"/></option>
		<option value ="N"><fmt:message key="ePH.NonSpecialClinic.label" bundle="${ph_labels}"/></option>
		</select></td>
		<td  class='label'><label><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/> </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<SELECT name="p_report_option" id="p_report_option" style="width:150px">	
		<option value ="WD"><fmt:message key="ePH.Weekday.label" bundle="${ph_labels}"/></option>
		<option value ="WE"><fmt:message key="ePH.Weekend.label" bundle="${ph_labels}"/></option>
		<option value ="HD"><fmt:message key="Common.Holiday.label" bundle="${common_labels}"/> </option>
		<option value ="WH"><fmt:message key="ePH.WeekendHoliday.label" bundle="${ph_labels}"/></option>
		<option value ="" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		</select>&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
		</tr>
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	<input type="hidden" name="p_user_name" id="p_user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="p_module_id" id="p_module_id" value="PH">
	<input type="hidden" name="p_reprint" id="p_reprint" value="Y">
	<input type="hidden" name="p_report_id" id="p_report_id" value="">
	<input type="hidden" name="p_disp_locn" id="p_disp_locn" value="">
	<input type="hidden" name="p_frm_year" id="p_frm_year" value="">
	<input type="hidden" name="p_to_year" id="p_to_year" value="">
	</form>
	
	
	</body>
	</html>

