<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,eCommon.Common.*"  contentType="text/html;charset=UTF-8" %>
<%

	request.setCharacterEncoding("UTF-8");
	Connection con =null;
	String facility_id = (String) session.getValue("facility_id");
    String resp_id=(String) session.getValue("responsibility_id");
	String user_id = (String) session.getValue("login_user");
	
	Boolean isLabelChangeApplicable=false;//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565 

try {
    con=ConnectionManager.getConnection(request);
	
	isLabelChangeApplicable = CommonBean.isSiteSpecific(con,"IP","GRAVIDA_PARITY_LEGEND_CHG");//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
%>

<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
	<script src='../../eMR/js/MRReports.js' language='javascript'></script>
		<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</script>

</head>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<form name="BirthRegister" id="BirthRegister" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<BR><BR><BR><BR>
<table border="0" width='80%' cellpadding="3" cellspacing="0"  align='center'>
	<tr class='label'>
		<td class='label' colspan='3'>&nbsp;</td>
	</tr>
	<tr>
		<td class='label' width="30%">&nbsp;</td>
		<td class="querydata" width="35%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class="querydata" width="35%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type='text' id='birthfrom' name='date_from' id='date_from' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>')" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthfrom');"/></td>
		<td class='fields'><input type='text' id='birthto' name='date_to' id='date_to' size='10' onBlur="validDateObj(this,'DMY','<%=localeName%>')" maxLength='10'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('birthto');"/></td>
	</tr>
    <tr>
		<td class="label"><fmt:message key="eMR.TypeofDelivery.label" bundle="${mr_labels}"/></td>
		<td class='fields'><input type=text  name='p_fm_delivery' id='p_fm_delivery' size="4" maxlength="4" align="center" enabled><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCoderepBirth(this, p_fm_delivery)'  enabled></td>
		<td class='fields'><input type=text  name='p_to_delivery' id='p_to_delivery' size="4" maxlength="4" align="center"  enabled><input type='button' name='locn1' id='locn1' value='?' class='button' onclick='searchCoderepBirth(this, p_to_delivery)' enabled> </td>
    </tr>
    <tr>
		<td class="label"><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type=text  name='p_fm_attend_pract' id='p_fm_attend_pract' size='15' maxlength='15' align="center" enabled><input type='button' name='Pract' id='Pract' value='?' class='button' onclick='searchCoderepBirth(this,p_fm_attend_pract)'  enabled></td>
		<td class='fields'><input type=text  name='p_to_attend_pract' id='p_to_attend_pract' size="15" maxlength="15" align="center"  enabled><input type='button' name='Pract' id='Pract' value='?' class='button' onclick='searchCoderepBirth(this, p_to_attend_pract)' enabled> </td>
	</tr>
	<tr>
			<td class="label"><fmt:message key="eMP.AttendingNurse.label" bundle="${mp_labels}"/></td>
			<td class='fields'><input type=text  name='p_fm_attend_midwife' id='p_fm_attend_midwife' size="15" maxlength="15" align="center" enabled><input type='button' name='Cunurse' id='Cunurse' value='?' class='button' onclick='searchCoderepBirth(this, p_fm_attend_midwife)'  enabled></td>
			<td class='fields'><input type=text  name='p_to_attend_midwife' id='p_to_attend_midwife' size="15" maxlength="15" align="center"  enabled><input type='button' name='Cunurse' id='Cunurse' value='?' class='button' onclick='searchCoderepBirth(this, p_to_attend_midwife)' enabled> </td>
      </tr>
	  <tr>
			<td class="label"><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text  name='p_fm_nalty_code' id='p_fm_nalty_code' size="15" maxlength="15" align="center" enabled><input type='button' name='Nationlty' id='Nationlty' value='?' class='button' onclick='searchCoderepBirth(this, p_fm_nalty_code)'  enabled></td>
			<td class='fields'><input type=text  name='p_to_nalty_code' id='p_to_nalty_code' size="15" maxlength="15" align="center"  enabled><input type='button' name='Nationlty' id='Nationlty' value='?' class='button' onclick='searchCoderepBirth(this, p_to_nalty_code)' enabled> </td>
      </tr>
		<tr>
			<td class="label"><fmt:message key="eMR.PlaceofDelivery.label" bundle="${mr_labels}"/></td>
			<td class='fields' colspan='2'>
				<select name='p_delivery' id='p_delivery'>
                <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/>
				<option value="A"><fmt:message key="eMP.Ambulance.label" bundle="${mp_labels}"/>
				<option value="B"><fmt:message key="eMP.BornBeforeArrival.label" bundle="${mp_labels}"/>
				<option value="H"><fmt:message key="Common.home.label" bundle="${common_labels}"/>
				<option value="I"><fmt:message key="eMP.InFacility.label" bundle="${mp_labels}"/>
				<option value="O"><fmt:message key="eMP.OtherModesofTpt.label" bundle="${mr_labels}"/>
				<!--<option value="L"><fmt:message key="eMP.Live.label" bundle="${mp_labels}"/>
				<option value="I"><fmt:message key="eMR.BornWithintheHospital.label" bundle="${mr_labels}"/>-->
				</select>
			</td>
		</tr>
    	<tr>
		<td class="label"><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan='2'>
			<select name='p_outcome' id='p_outcome'>
		    <option value=""><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
			<% if(isLabelChangeApplicable){%>
		    <option value="L"><fmt:message key="eMP.Alive.label" bundle="${mp_labels}"/><!-- Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565-->
			<%}else{%>
			 <option value="L"><fmt:message key="eMP.Live.label" bundle="${mp_labels}"/>
			<%}%>
			<option value="S"><fmt:message key="eMP.StillBorn.option.label" bundle="${mp_labels}"/>
			</select>
		</td>
		</tr>
    <tr class='label'>
		<td class='label' colspan='3'>&nbsp;</td>
	</tr>
   </table>
	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
	

<input type="hidden" name="p_module_id" id="p_module_id" 		value="MR">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="MRRBIRRG">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
<input type="hidden" name="P_RESP_ID" id="P_RESP_ID"		value="<%=resp_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
</form>
</body>
</html>
<%
} catch(Exception e) {  /* out.println("in else "+e); */e.printStackTrace();}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>


