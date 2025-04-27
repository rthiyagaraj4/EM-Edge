<!DOCTYPE html>
 <!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ;	 //Added for MOHE-CRF-0074
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script LANGUAGE="javascript" src="../js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/MMS_PhRepDispStatByDrug.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	 // Added for MOHE-CRF-0074 - End
	 
	String bean_id		= "PHRepDispStatByDrugBean" ;
	String bean_name	= "ePH.PHRepDispStatByDrugBean";
	PHRepDispStatByDrugBean bean	= (PHRepDispStatByDrugBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	ArrayList facilityList = bean.getFacilityList();
	
	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074
%>
	<body onMouseDown="" onKeyDown="lockKey()" onload="document.formPhRepDispStatByDrugCriteria.p_facility_code.focus();">
		<form name="formPhRepDispStatByDrugCriteria" id="formPhRepDispStatByDrugCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="2" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="7" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
					<td align="right" class="label" width="15%" nowrap><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td align="left" class="label" colspan='6'><SELECT name="p_facility_code" id="p_facility_code" >
						<OPTION VALUE=" "> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
<% 
if(region_check){ // MOHE-CRF-0074-Start
	   for (int i=0;i<region_code_check.size();i+=2){
			order_facility_id=(String)region_code_check.get(i);
			order_facility_name=(String)region_code_check.get(i+1);
%>
	<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%	
		}
	}else{ //Added for MOHE-CRF-0074 - End
						if (facilityList.size() > 0 ){
							for (int i=0; i<facilityList.size(); i+=2) { 
%>
								<OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>
<% 	
							}
						}
	} //Added for MOHE-CRF-0074
%>
					</SELECT>
				</tr>
				<tr>

				</tr>
					<td align="right" class="label" nowrap><fmt:message key="ePH.Drugby.label" bundle="${ph_labels}"/></td> 
					<td align="left" class="label" width='20%'><select name="p_drug" id="p_drug" onchange="changeLegend();displayfields();">
						<option value="ATC"><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/></option>
						<option value="DC"><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
					<td align="right" id="lbl_ATC_level" class="label" width='10%'><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/></td>
					<td class="label" id="fld_ATC_level" width='25%'><input type="text" name="p_ATC_class_desc" id="p_ATC_class_desc" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="btnformsearch" id="btnformsearch" onClick="callAssociateATC();">
					</td>
					<td id="lbl_drug_class" style='display:none;' width='10%' align="right" class="label" nowrap><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/>
					<td id="fld_drug_class" class="label" style='display:none' width='*'><select name="P_DRUG_CLASS" id="P_DRUG_CLASS">
						<option value="">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
						<option value="G"><fmt:message key="Common.general.label" bundle="${common_labels}"/></option>
						<option value="N"><fmt:message key="ePH.Narcotics.label" bundle="${ph_labels}"/></option>
						<option value="C"><fmt:message key="ePH.Controlled.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
					<td>&nbsp;<td>
				</tr>
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="ePH.ConsumptionDateFrom.label" bundle="${ph_labels}"/></td>
					<td align="left"  class="label"><input type="text" size="10" maxlength=10  name="p_dt_from" id="p_dt_from" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_from');"><img src="../../eCommon/images/mandatory.gif" align="center"></td>
					<td align="right" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td align="left"  class="label"><input type="text" size="10" maxlength=10 name="p_dt_to" id="p_dt_to" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_to');" ><img src="../../eCommon/images/mandatory.gif" align="center"></td>
				</tr>
				</tr>
					<td align="right" class="label" nowrap><fmt:message key="ePH.FormofDrug.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label" ><input type="text" name="p_form_desc" id="p_form_desc" maxlength="30" size="30" value="">
					<input type="button" class="button" value="?" name="p_form_of_drug_desc" id="p_form_of_drug_desc"onClick="SearchDrugForm()">
					<td align="right" class="label" nowrap><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><input type="text" name="p_drug_name" id="p_drug_name" maxlength="30" size="30" value="" onblur="callDrugSearch(document.formPhRepDispStatByDrugCriteria.p_drug_name)">
					<input type="button" class="button" value="?" name="p_drug_desc" id="p_drug_desc" 	onClick="callDrugSearch(document.formPhRepDispStatByDrugCriteria.p_drug_name)"><!-- onfocus changed to onblur for ml-bru-scf-2209 -->
					</td>
					<td>&nbsp;<td>
				</tr>
				<tr>
					<td align="right" class="label" nowrap><fmt:message key="ePH.CustomerGroup.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label"><input type="text" name="p_customer_group" id="p_customer_group" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="p_customer_group_desc" id="p_customer_group_desc" onClick="CustomerGroupSearch(document.formPhRepDispStatByDrugCriteria.p_customer_group);"></td>
					<td align="right" class="label" nowrap><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
					<td align="left" class="label" colspan='3'><input type="text" name="p_customer" id="p_customer" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="p_customer_desc" id="p_customer_desc" onClick="CustomerSearch(document.formPhRepDispStatByDrugCriteria.p_customer)"></td>
					<td>&nbsp;<td>
				</tr>
					<tr>
					<td align="right" class="label" nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td align="left" class=label><input name="p_dispense_location" id="p_dispense_location" maxlength="30" size="30" value="" ><input   class="button" onClick="return searchCodeDispenseLocation(p_dispense_location);" type="button" value="?"></td>
					<td align="right" class="label" nowrap><fmt:message key="Common.OrderingLocation.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><select name="p_Ordering_Location" id="p_Ordering_Location" onchange="changeLegend();displayfields();">
						<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
						<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td class="label" align="left" id="Locn_text" style='display:none;' nowrap><input type="text" name="p_ordering_locn" id="p_ordering_locn" STYLE='overflow:visible;' onKeyPress="changeToUpper();" value=""><!--size="40" maxlength="40" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
					<input type="button" class="button" value="?" name="locn_search" id="locn_search" onClick="LocationSearch(document.formPhRepDispStatByDrugCriteria.p_Ordering_Location);" onfocus="LocationSearch(document.formPhRepDispStatByDrugCriteria.p_Ordering_Location);"></td>	
					<td>&nbsp;<td>
				</tr>
				<tr>
					<td align="right" class="label"nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><select name="encounter_type" id="encounter_type">
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
						<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td align="right" class="label"nowrap><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>
					<td align="left"  class="label"><select name="P_Report_By" id="P_Report_By" onchange="changeLegend();displayfields();">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value="PA"><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
						<option value="PC"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
						<option value="SO"><fmt:message key="Common.source.label" bundle="${common_labels}"/></option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
					<td class="label" align="right"nowrap><label id='changelabel'></td>
					<td class="label" align="left" id="pat_text" style='display:none;' nowrap><input type="text" name="p_patient_id" id="p_patient_id"  size="20" onKeyPress="changeToUpper();" value=""><input type="button" class="button" value="?" name="pat_search" id="pat_search" onClick="ReportSearch(document.formPhRepDispStatByDrugCriteria.P_Report_By);"></td>				
					<td>&nbsp;<td>
				</tr>
			</table>
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRDSBYDR">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">

			<input type="hidden" name="drug_code" id="drug_code" value="">
			<INPUT TYPE="hidden" name="P_CUST_GROUP_CODE" id="P_CUST_GROUP_CODE" VALUE=""> 
			<INPUT TYPE="hidden" name="P_CUST_CODE" id="P_CUST_CODE" VALUE="">
			<input type="hidden" name="P_FORM_CODE" id="P_FORM_CODE" value=""> 
			<input type="hidden" name="P_DISP_LOCN_CODE" id="P_DISP_LOCN_CODE" value=""> 
			<input type="hidden" name="P_CLINIC_CODE" id="P_CLINIC_CODE" value=""> 
			<input type="hidden" name="P_NUR_UNIT_CODE" id="P_NUR_UNIT_CODE" value=""> 
			<input type="hidden" name="p_pract_id" id="p_pract_id" value="">
			<input type="hidden" name="p_Locn_code" id="p_Locn_code" value="">
			<input type="hidden" name="p_atc_level" id="p_atc_level" value="">
			<input type="hidden" name="p_pract_desc" id="p_pract_desc" value="">
			<input type="hidden" name="p_locn_desc" id="p_locn_desc" value=""> 
			<input type="hidden" name="dt_from" id="dt_from" value="">
			<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=""> 
			<INPUT TYPE="hidden" name="disp_locn_sql_select1" id="disp_locn_sql_select1" VALUE="SELECT A.DISP_LOCN_CODE code,SHORT_DESC description FROM PH_DISP_LOCN_LANG_VW A WHERE  A.FACILITY_ID LIKE ? and a.language_id like ? AND upper(DISP_LOCN_CODE) LIKE upper(?) AND upper(SHORT_DESC )LIKE upper(?) AND EFF_STATUS='E'">
			<INPUT TYPE="hidden" name="nursing_unit_sql_select1" id="nursing_unit_sql_select1" VALUE="SELECT   nursing_unit_code code, short_desc description FROM ip_nursing_unit_lang_vw ip_nursing_unit WHERE facility_id LIKE ? AND language_id LIKE ? and  eff_status = 'E' AND UPPER (nursing_unit_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) ORDER BY 2">
			<INPUT TYPE="hidden" name="clinic_sql_select1" id="clinic_sql_select1" VALUE="SELECT   clinic_code code, short_desc description FROM op_clinic_lang_vw op_clinic WHERE facility_id LIKE ? AND language_id like ? AND UPPER (clinic_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) AND eff_status = 'E' AND clinic_type = 'C' ORDER BY 2">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<% putObjectInBean(bean_id,bean,request); %>
		</form>
	</body>
<%	} // Added for MOHE-CRF-0074 - start
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->
</html>

