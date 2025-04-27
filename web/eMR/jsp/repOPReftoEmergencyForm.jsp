<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<%
	String p_module_id		= "MR" ;
	String p_report_id		= "MROPRFLS" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>	
<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		

</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="mychangerepOPRefto();">
<br>
<br>
<form name="repOPReftoEmergencyForm" id="repOPReftoEmergencyForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

	
				
					
					<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
					<tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_type" id="p_type" onchange='mychangerepOPRefto()'>
						 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
				</tr>
					
					


				<tr>
					<td align='right' width='35%' class="label">&nbsp;</td>
					<td width='25%'  ></td>
					<td >&nbsp;</td>
				</tr>
					<td colspan ='3'></td>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
						<td align='right' id='MY1'class="label">&nbsp;</td>
						<td align='left' id='MY' > &nbsp; </td>
				        <td align='left' id='MY3' > &nbsp; </td>
				        <td></td>  
				</tr>
				<tr>
					<td align='right' width='35%' class="label"> &nbsp;</td>
					<td width='25%'  ></td>
					<td>&nbsp;</td>
				</tr>

				<!--Added by Ashwini on 26-Aug-2019 for ML-MMOH-CRF-1348-->
				<tr>
					<td align='right' class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
					<td>
					   <select name='p_service_type' id='p_service_type' onchange="enableSpecialty(this);">
						   <option value=''> ------------ <fmt:message key="Common.all.label" bundle="${common_labels}"/> ------------ </option>
						   <option value='ED'><fmt:message key="eMR.EmergencyDepartment.label" bundle="${mr_labels}"/></option>
						   <option value='SC'><fmt:message key="Common.SpecialistClinic.label" bundle="${common_labels}"/></option>
						   <!--Modified by Ashwini on 05-Jan-2021 for ML-MMOH-SCF-1697-->
						   <!--<option value='ST'><fmt:message key="Common.Staff.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>-->
						   <option value='ST'><fmt:message key="eMR.SpecialClinic.label" bundle="${mr_labels}"/></option>
						   <option value='PU'><fmt:message key="Common.PAC.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
								
				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/>&nbsp;</td>
						<td width='20%'  >
							<input type=text onkeypress='return ValidStringrepOPRefto(event)' name='p_fm_speciality_code' id='p_fm_speciality_code' size="4" maxlength="4" align="center" disabled><input type='button' name='speciality_code' id='speciality_code' value='?' class='button' onclick='searchCoderepOPRefto(this, p_fm_speciality_code)' disabled>
						</td>
						<!--Commented by Ashwini on 26-Aug-2019 for ML-MMOH-CRF-1348--> 
						<!--<td width='40%'>
							<input type=text onkeypress='return ValidStringrepOPRefto(event)' name='p_to_speciality_code' id='p_to_speciality_code' size="4" maxlength="4" align="center"><input type='button' name='speciality_code' id='speciality_code' value='?' class='button' onclick='searchCoderepOPRefto(this, p_to_speciality_code)'>
						</td>-->
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="report_type" id="report_type" >
						 <option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
                         <option value="S"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
    <input type="hidden" name="P_LOCATION_TYPE" id="P_LOCATION_TYPE"		value=''>
	<!--Added by Ashwini on 26-Aug-2019 for ML-MMOH-CRF-1348-->
    <input type="hidden" name="p_to_speciality_code" id="p_to_speciality_code" value=''>
</form>
</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

