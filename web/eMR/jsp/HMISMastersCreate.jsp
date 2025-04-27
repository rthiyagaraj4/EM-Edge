<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eMR/js/HMISMaster.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>

	<body  onLoad="FocusFirstElement()"   onKeyDown = 'lockKey()'; OnMouseDown="CodeArrest()">
	<form name='HMISMASTERForm' id='HMISMASTERForm'  target='messageFrame'>
	<table border='0' cellpadding='5' cellspacing='0' width='100%'>
	<tr>
		<td class='label' width='20%' ><fmt:message key="eMR.Master.label" bundle="${mr_labels}"/></td>
		<td class='fields' width='20%'>
		<select name='hmisid' id='hmisid' onChange='clf();'>
		<option value=''>----------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------------</option>
		<option value='IP_BED_CLASS~BED_CLASS_CODE~A.LONG_DESC~B.HMIS_CODE1~B.MEDICOM_CODE~Bed Class'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></option>
		<option value='MP_COUNTRY~A.COUNTRY_CODE~A.LONG_NAME~B.HMIS_CODE1~B.MEDICOM_CODE~ Country'><fmt:message key="Common.country.label" bundle="${common_labels}"/></option>
		<option value='MP_NOD_TYPE~A.NOD_TYPE~A.LONG_DESC~B.HMIS_CODE1~B.MEDICOM_CODE~Delivery Type'><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></option>
		<option value='IP_DISCHARGE_TYPE~DISCHARGE_TYPE_CODE~A.LONG_DESC~B.HMIS_CODE1~B.MEDICOM_CODE~Discharge Type'><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/></option>
		<option value='AM_SPECIALITY~A.SPECIALITY_CODE~A.LONG_DESC~B.HMIS_CODE1~B.MEDICOM_CODE~Discipline'><fmt:message key="eMR.Discipline.label" bundle="${mr_labels}"/></option>
		<option value='ExternalFileStorageLocation'><fmt:message key="eMR.ExternalFileStorageLocation.label" bundle="${mr_labels}"/></option>
		<option value='SM_FACILITY_PARAM~A.FACILITY_ID~A.FACILITY_NAME~B.HMIS_CODE1~B.MEDICOM_CODE1~Hospital'><fmt:message key="Common.Hospital.label" bundle="${common_labels}"/></option>
		<option value='MP_MARITAL_STATUS~A.MAR_STATUS_CODE~A.LONG_DESC~B.HMIS_CODE1~B.MEDICOM_CODE~Marital Status'><fmt:message key="eMP.maritalstatus.label" bundle="${mp_labels}"/></option>
		<option value='MP_RACE~A.RACE_CODE~A.LONG_DESC~B.HMIS_CODE1~B.MEDICOM_CODE~Race'><fmt:message key="Common.race.label" bundle="${common_labels}"/></option>
		<option value='AM_REFERRAL~A.REFERRAL_CODE~A.LONG_DESC~B.HMIS_CODE1~B.MEDICOM_CODE~Referral '><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
		<option value='MP_RELIGION~A.RELGN_CODE~A.LONG_DESC~B.HMIS_CODE1~B.MEDICOM_CODE~Religion'><fmt:message key="Common.religion.label" bundle="${common_labels}"/></option>
		<option value='MP_REGION~A.REGION_CODE~A.LONG_DESC~B.HMIS_CODE1~B.MEDICOM_CODE~State'><fmt:message key="Common.State.label" bundle="${common_labels}"/></option>
        <option value=''>------------------------------------------</option>
       
		<option value='OP_CLINIC~Emergency Clinic'>Emergency Clinic</option>
		<option value='IP_NURSING_UNIT~A.FACILITY_ID~A.NURSING_UNIT_CODE~A.LONG_DESC~B.FACILITY_ID hospital_code~B.HMIS_CODE1~B.MEDICOM_CODE~Ward'><fmt:message key="Common.Ward.label" bundle="${common_labels}"/></option>
		<option value='IP_NURS_UNIT_FOR_SPECIALTY~A.FACILITY_ID~A.NURSING_UNIT_CODE~ A.SPECIALTY_CODE~B.FACILITY_ID hospital_code~B.HMIS_CODE1~B.HMIS_CODE2~Discipline for Ward'><fmt:message key="eMR.DisciplineforWard.label" bundle="${mr_labels}"/></option>
	    </select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td class='label' width='20%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'>
		<input type=text  name='longdesc' id='longdesc' maxlength=50 size =30> </td>

		<td class='button' width='15%'><input type = button class = button value = 'Select' onClick='fetchVals1()'></td>
         	</tr>           
   
	</form>
</body>
</html>
 
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

