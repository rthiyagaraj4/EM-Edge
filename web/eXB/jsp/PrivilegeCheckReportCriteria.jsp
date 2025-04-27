<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection, java.util.*, java.text.*, java.sql.*, java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager, webbeans.eCommon.*, eXB.*" contentType="text/html;charset=UTF-8"  %> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 
<html>
<head>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>

<script language="JavaScript" src='../../eXH/js/InterfaceUtil.js'></script>
<script language="JavaScript" src='../../eXB/js/PrivlegeCheckReport.js'></script>
<script language="JavaScript" src='../../eXB/js/XHAjaxUtil.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<html>
<TITLE></TITLE>

<%
	String p_module_id		= "XB" ;
//	String p_report_id		= "" ;
	String p_passing_local_date = "";
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");

	if(locale.equals("th"))
	{
		p_passing_local_date = "Y";
	}
	else 
	{
		p_passing_local_date = "N";
	}

%>

</HEAD>

<BODY  onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<% 
	String Sysdate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	String encounterQuery = "SELECT distinct encounter_id FROM xb_privileges_vw ORDER BY encounter_id";
%>
<br>
<br>
<form name="PrivChkRepCriteria" id="PrivChkRepCriteria" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

	<td  class='columnheader' align='left'> 
		<fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
	</td>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="3" cellSpacing="3"  align='center'>

			<tr>
				<td  width="30%">&nbsp;</td>
				<td class="fields" width="30%">
					<fmt:message key="Common.from.label" bundle="${common_labels}"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				</td>
			</tr>

			<tr>
				<td align='right' width='30%' class="label">Loaded Date</td>
				<td width='30%'>
					<input type=text size=12 maxlength="12"  value='' align="center"  name='p_from_loaded_date1' id='p_from_loaded_date1' onBlur="validate_date(this,'LOADED_DATE')"> <input type='image' name=showcalndr id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_from_loaded_date1','dd/mm/y');"  >
					<input type=text size=12 maxlength="12"  value='' name='p_to_loaded_date1' id='p_to_loaded_date1' align="center" onBlur="validate_date(this,'LOADED_DATE')"> <input type='image' name=showcalndr id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_loaded_date1','dd/mm/y');"  >
				</td>
			</tr>

			<tr>
				<td align='right' width='30%' class="label">Billing Group </td>
				<td width='50%'  >
					<input type="hidden" name="p_blng_grp_id" id="p_blng_grp_id" size=10  value="">
					<input type=text id="blng_grp_desc"  name ='blng_grp_desc' size=36 value=''> 
					<input class="BUTTON" type="button" name=orgIDSearch value='?' onClick='searchBllngGrp();'>
					<img src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>			

			<!-- <tr>
				<td align='right' width='30%' class="label">Patient Name </td>
				<td width='50%'  >
					<input type="hidden" name="patient_id" id="patient_id" size=10  value="">
					<input type=text id="store_desc"  name ='p_patient_name' size=36 value=''>
				</td>
			</tr> -->

			<tr>
				<td align='right' width='30%' class="label">Patient ID </td>
				<td width='50%'>
					<input type="hidden" id="p_patient_id" name="p_patient_id" id="p_patient_id" size=10 value="">
					<input type=text id="hosp_name" name ='hosp_name' size=36 value=''> 
					<input class="BUTTON" type="button" name=hospNoSearch value='?' onClick="getPatientID('p_patient_id', 'hosp_name');">
				</td>
			</tr>

			<tr>
				<td align='right' width='30%' class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
				<td width='50%'>
					<SELECT name="P_Patient_Class" id="P_Patient_Class">
						<OPTION VALUE="ALL" SELECTED><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
						<OPTION VALUE="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></OPTION>
						<OPTION VALUE="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></OPTION>
						<OPTION VALUE="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></OPTION>
						<OPTION VALUE="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></OPTION>
						<OPTION VALUE="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></OPTION>
					</SELECT>
				</td>
			</tr>	

			<tr>
				<td align='right' width='30%' class="label">Encounter ID</td>
				<td width='50%'>						
					<input type="text" id="p_encounter_id" name="p_encounter_id" id="p_encounter_id" size=36 value=''>
				</td>
			</tr>

			<tr>
				<td align='right' width='30%' class="label">Policy </td>
				<td width='50%'>
					<input type="hidden" name="p_policy_type_code" id="p_policy_type_code" size=10  value="">
					<input type=text id="policy_desc"  name ='policy_desc' size=36 value=''>
					<input class="BUTTON"  type="button" name=policySearch value='?' onClick='searchPolicy();'>
				</td>
			</tr>

			<tr>
				<td  width="30%">&nbsp;</td>
				<td class="fields" width="30%">
					<fmt:message key="Common.from.label" bundle="${common_labels}"/>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				</td>
			</tr>

			<tr>
				<td align='right' width='30%' class="label">Visit/Admission Date  </td>
				<td width='30%' >
					<input type=text size=12 maxlength="12"  value='' align="center"  name='p_from_visit_adm_date1' id='p_from_visit_adm_date1' onBlur="validate_date(this,'TO_DATE_LESS_FROM')"> <input type='image' name=showcalndr id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_from_visit_adm_date1','dd/mm/y');"  >
					<input type=text size=12 maxlength="12"  value='' name='p_to_visit_adm_date1' id='p_to_visit_adm_date1' align="center" onBlur="validate_date(this,'TO_DATE_LESS_FROM')"> <input type='image' name=showcalndr id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_visit_adm_date1','dd/mm/y');"  >
				</td>
			</tr>
 
			<tr>
				<td align='right' width='30%' class="label">Number of records per page</td>
				<td width='50%'>						
					<SELECT name="p_records_per_page" id="p_records_per_page">
						<OPTION VALUE="S" SELECTED>Single</OPTION>
						<OPTION VALUE="M">Multiple</OPTION>
					</SELECT>
				</td>
			</tr>					

		</table>
	</td>
</tr>
</table>

<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" value="">
<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
<input type='hidden' name="locale" id="locale"	value='<%=locale%>'>
<input type="hidden" name="sysdate" id="sysdate"	value="<%=Sysdate%>">

</form>

<form name="dummyForm" id="dummyForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" value="XBPRVCHK">
<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
<input type='hidden' name="locale" id="locale" value='<%=locale%>'>
<input type="hidden" name="sysdate" id="sysdate"	value="<%=Sysdate%>">
<input type="hidden" name="p_records_per_page" id="p_records_per_page" value="">
<input type="hidden" name="P_Patient_Class" id="P_Patient_Class" value="">
<input type="hidden" name="p_from_visit_adm_date" id="p_from_visit_adm_date" value="">
<input type="hidden" name="p_to_visit_adm_date" id="p_to_visit_adm_date"	value="">
<input type="hidden" name="p_policy_type_code" id="p_policy_type_code" value="">
<input type="hidden" name="p_encounter_id" id="p_encounter_id" value="">
<input type="hidden" name="p_patient_id" id="p_patient_id" value="">
<input type="hidden" name="p_blng_grp_id" id="p_blng_grp_id" value="">
<input type="hidden" name="p_from_loaded_date" id="p_from_loaded_date" value="">
<input type="hidden" name="p_to_loaded_date" id="p_to_loaded_date" value="">

</form> 

</BODY>
</HTML>

