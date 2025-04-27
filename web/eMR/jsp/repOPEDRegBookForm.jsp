<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
    Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
try {
    con=ConnectionManager.getConnection(request);
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
	<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="MROPBKED" id="MROPBKED" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='80%' cellpadding="0" cellspacing="0"  align='center'>
		<th align='left' colspan='3'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/> </th>
		<tr>
			<td align="center" width="35%">&nbsp;</td>
			<td class="querydata" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="querydata" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>	
		</tr>
	    <tr>
			<td align='right' width='30%' class="label"><fmt:message key="Common.RegnDate.label" bundle="${common_labels}"/> &nbsp;</td>
			<td><input type='text' id='birthfrom' name='P_FM_DATE' id='P_FM_DATE' size='10' onBlur='CheckDate(this)' maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>

			<td><input type='text' id='birthto' name='P_TO_DATE' id='P_TO_DATE' size='10' onBlur='CheckDate(this)' maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"/>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></td>
	   </tr>
    <tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<tr>
		<td align='right' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>			
		<td>
			<SELECT name="p_patient_class" id="p_patient_class" onchange='disableLocationType(this)' >
				<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value='OP'><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
				<option value='EM'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
			</SELECT>&nbsp;
		</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	
	<tr>
		<td align ='right' class = "label" ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp</td>
		<td>
			<SELECT name="p_location_type" id="p_location_type"  disabled onchange='changeLocationType(this)'>
				<option value="C" selected><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
		</td>
		<td>&nbsp;</td>
	</tr>

	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	
	<tr>
	<td align='right'  class="label" id="loc_type_legend"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/>&nbsp</td>
	<td id = "fm_loc_type">
			<input type=text onkeypress="return ValidStringrepOPED(event)" name='P_FM_LOC_TYPE_CODE' id='P_FM_LOC_TYPE_CODE' size="4" maxlength="4"><input type='button' name='special' id='special' value='?' class='button' onclick='searchCode1repOPED(this, P_FM_LOC_TYPE_CODE)'>&nbsp;
		
	</td>
	<td  id = "to_loc_type">
			<input type=text onkeypress="return ValidStringrepOPED(event)" name='P_TO_LOC_TYPE_CODE' id='P_TO_LOC_TYPE_CODE' size="4" maxlength="4"><input type='button' name='special' id='special' value='?' class='button' onclick='searchCode1repOPED(this, P_TO_LOC_TYPE_CODE)'>&nbsp;
	</td>
	</tr>
		<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
	<tr>
	<td align='right'  class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;</td>
	<td id = "fm_splty">
			<input type=text onkeypress="return ValidStringrepOPED(event)" name='P_FM_SPECIALITY_CODE' id='P_FM_SPECIALITY_CODE' size="4" maxlength="4"><input type='button' name='special' id='special' value='?' class='button' onclick='searchCoderepOPED(this, P_FM_SPECIALITY_CODE)'>&nbsp;
	</td>
	<td id = "to_splty">
			<input type=text onkeypress="return ValidStringrepOPED(event)" name='P_TO_SPECIALITY_CODE' id='P_TO_SPECIALITY_CODE' size="4" maxlength="4"><input type='button' name='special' id='special' value='?' class='button' onclick='searchCoderepOPED(this, P_TO_SPECIALITY_CODE)'>&nbsp;
	</td>
	</tr>
	<tr>
		<td colspan=3>&nbsp;</td>
	</tr>
		
   
   </table>


<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="MROPBKED">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
</form>
</body>
</html>
<%
} catch(Exception e) { /*  out.println("in else "+e); */e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
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

