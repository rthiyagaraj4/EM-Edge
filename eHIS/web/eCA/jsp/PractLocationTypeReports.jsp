<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            ?           	created
19/11/2020    5563  	SIVABAGYAM 		19/11/2020 		RAMESH G		ML-MMOH-CRF-1180
--------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id = (String)session.getValue("facility_id");
	String p_login_user  = (String)session.getValue("login_user");
	if(p_facility_id == null)p_facility_id="";
	if(p_login_user == null)p_login_user="";
%>
<html>
<head><title></title>
<%

String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eCA/js/PractLocationTypeReports.js" ></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name='practLocationTypeReports' id='practLocationTypeReports' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<br><br><br><br>
<table align='center' cellpadding='3' cellspacing='0' width='90%' border='0'>
<th class="columnheader"  colspan='4' ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
<tr>
    <td class='label' width='10%'><fmt:message key="Common.PractitionerFrom.label" bundle="${common_labels}"/></td>
    <td class='fields' width='20%'><input type='text' name='p_fr_practitioner_id1' id='p_fr_practitioner_id1' size="26" maxlength="25" onblur="search_Code(this,p_fr_practitioner_id1,'<%=p_facility_id%>');" value=""><input type='hidden' name='p_fr_practitioner_id' id='p_fr_practitioner_id' value=""><input type=button name='p_fr_practitioner_id_src' id='p_fr_practitioner_id_src' class='button' value='?' onclick="search_Code(this,p_fr_practitioner_id1,'<%=p_facility_id%>');"></td>
    <td class='label' width='5%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'><input type='text' name='p_to_practitioner_id1' id='p_to_practitioner_id1'  size="26" maxlength="25" onblur="search_Code(this,p_to_practitioner_id1,'<%=p_facility_id%>');" value=""><input type='hidden' name='p_to_practitioner_id' id='p_to_practitioner_id' value=""><input type='button' name='p_to_practitioner_id_src' id='p_to_practitioner_id_src' class='button' value='?' onclick="search_Code(this,p_to_practitioner_id1,'<%=p_facility_id%>');"></td>
</tr>
<tr>
    <!-- <td class='label'  width='10%' ><fmt:message key="eCA.LocationTypeFrom.label" bundle="${ca_labels}"/></td> -->
	<td class='label'  width='10%' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
    <td class='fields' width='20%'><select name='p_fm_loctype' id='p_fm_loctype'>
	<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
	<option value="Z"><fmt:message key="Common.AllLocations.label" bundle="${common_labels}"/></option>
	<option value="Y"><fmt:message key="eCA.AllNursingUnits.label" bundle="${ca_labels}"/></option>
	<option value="X"><fmt:message key="eCA.AllClinics.label" bundle="${ca_labels}"/></option>
	<option value="C"><fmt:message key="eCA.Clinics.label" bundle="${ca_labels}"/></option>
	<option value="W"><fmt:message key="eCA.NursingUnits.label" bundle="${ca_labels}"/></option>
	<option value="P"><fmt:message key="eCA.ByPractitionerRights.label" bundle="${ca_labels}"/></option>
	</select>
	</td>
	<!-- ML-MMOH-CRF-1180 --5563 STARTS -->
    <td class='label'  width='5%' > <fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
	<td class='fields' ><input type='text' name ='grp_by_name'  onblur=' getSpecialty(grp_by_name,p_specialty_code)'><input type='hidden' name='p_specialty_code' id='p_specialty_code' value=''><input type ='button' class='button' name='spec_search' id='spec_search' value='?' onclick=' getSpecialty(grp_by_name,p_specialty_code)'>
	</td>
	<!-- ML-MMOH-CRF-1180 --5563 ENDS -->
</tr>
<!--<tr><td colspan='4'>&nbsp;</td></tr>-->
<tr>
	<td width='10%'  class='label'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
	<td width='20%'  class='fields' ><select name='p_group_by' id='p_group_by'><option value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option><option value='L'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></option></select></td>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr><td colspan='4'>&nbsp;</td></tr> 
</table>


<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id%>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=p_login_user%>">
<input type="hidden" name="p_module_id" id="p_module_id" 	value="CA">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="CAPRALOT">


</form>
</body>
</html>

