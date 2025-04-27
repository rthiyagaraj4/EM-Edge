<!DOCTYPE html>

<%
/*							
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History    	Name				Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/01/2023      40628    			SREENADH.M							 Ramesh G    	TH-KW-CRF-0142
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.Date" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%
	request.setCharacterEncoding("UTF-8");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String currDate =	com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DATE, -6);
    String prevCurrDate = format.format(calendar.getTime());    
 %>
<html>
<head>
<%

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCA/js/WaitingTimeAnalysisReport.js' language='javascript'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
<script language="javascript" >

function showCalendarValidate(str){
		var flg = showCalendar(str);
		document.getElementById(str).focus();
		return flg;
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<form name="waittimeanalysisreport" id="waittimeanalysisreport" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<table width='80%' align='center' valign='top' cellpadding='3'>
		<tr>
			<td class='columnheader' ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
		</tr>
		<tr>
			<td width="100%"   class="Border" align='center'>
				<table border=0 width='100%' cellPadding="3" cellSpacing="0"  align='center' >
					<tr>
						<td width='20%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class="fields" width='30%' >
							<input type=textbox value='' size=20 maxlength=6 name="patientId" id="patientId" OnChange='resetValues();' onkeypress="return CheckForSpecChars(event);">
							<input type='button' name='btnPatID' id='btnPatID' value='?' class='button' onclick='callPatientSearch()'>
						</td>					
						<td  class='label' id='id_encounter'  width='15%' nowrap ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/> </td>
						<td class='fields' width="35%">
							<input type='textbox'  name='encounterId' id='encounterId' value='' maxlength=12 nowrap onKeyPress="return(ChkNumberInput(this,event,'0'))" onBlur='ChangeUpperCase(this);'  size="20" OnChange='resetValues();'>
							<input align='right' class='button' type=button name=search1  value='?'   tabIndex="4" onClick="patientEncounterDetailNew('clntaudittrial')">
						</td>						
					</tr>							
					<tr>
						<td class=LABEL><fmt:message key="Common.clinic.label" bundle="${common_labels}" />
			    		<td class='fields'>
							<input type="text" name="clinicName" id="clinicName" maxlength="20" size="20" onBlur="getClinicCode(this);">
							<input type='button' name='clinicSearch' id='clinicSearch' class='button' value='?' tabIndex="4" onClick="populateClinic()">
							<input type="hidden" name="clinicCode" id="clinicCode" size="20" maxlength="20" value="">
						</td>
						<td class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
						<td class='fields' ><input type="hidden" name="splCode" id="splCode" size="20" maxlength="20" value="">
							<input type="text" name="splName" id="splName"  size='20' maxlength='20' onBlur='getSplCode(this);' OnChange='resetValues()'>
							<input type="button" value="?" class="button" name='splSearch' id='splSearch' onClick='resetValues();populateSpl()'>
						</td>
					</tr>		
					<tr>
						<td class='label'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
						<td class='fields'>
							<input type="hidden" name="attendingPractCode" id="attendingPractCode"	size="20" maxlength="20" value=""> 
							<input type="text" name="attendingPractName" id="attendingPractName" size='20' maxlength='20' onBlur='getAttendingPractitionerCode(this);'>
							<input type="button" value="?" class="button" name='splSearch' id='splSearch' onClick='attendingPractioner()'>
						</td>

						<td class="label" nowrap><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}" /></td>
						<td class="fields">
							<SELECT name="episode_type" id="episode_type" style="width:150px">
								<option value =""> ------ Select ------</option>
								<option value ="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
								<option value ="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
								<option value ="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
								<option value ="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
								<option value ="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
							</SELECT>
						</td>
					</tr>
					<tr>
						<td class='label'><fmt:message key="eCA.EncounterCodingstatus.label" bundle="${common_labels}" /></td>
						<td class='fields'>					
							<SELECT name="encodingstatusCode" id="encodingstatusCode" style="width:150px">					
								<option value =""> ------ Select ------</option>
								<option value ="NW"><fmt:message key="Common.New.label" bundle="${common_labels}"/></option>
								<option value ="DQ"><fmt:message key="eCA.DoctorQuery.label" bundle="${ca_labels}"/></option>
								<option value ="SQ"><fmt:message key="eCA.SupervisorQuery.label" bundle="${ca_labels}"/></option>
								<option value ="HD"><fmt:message key="Common.Hold.label" bundle="${common_labels}"/></option>
								<option value ="PC"><fmt:message key="Common.PartiallyCompleted.label" bundle="${common_labels}"/></option>
								<option value ="CO"><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
							</SELECT>
						</td>
						<td class='label'><fmt:message key="Common.BillingGroup.label"	bundle="${common_labels}" /></td>
						<td class='fields'>
								<input type="hidden" name="billingGroupCode" id="billingGroupCode" size="20" maxlength="20" value=""> 
								<input type="text" name="billingGroupName" id="billingGroupName" size='20' maxlength='20' onBlur='getBillingGroup(this);'>
								<input type="button" value="?" class="button" name='billingSrch' id='billingSrch' onClick='populateBillingGroup()'>
						</td>
					</tr>
					<tr>
						<td class='label'><fmt:message key="Common.CustomerGroup.label" bundle="${common_labels}" /></td>
						<td class='fields'>
								<input type="hidden" name="CustomergroupCode" id="CustomergroupCode"	size="20" maxlength="20" value=""> 
								<input type="text" 	name="CustomergroupName" id="CustomergroupName" size='20' maxlength='20' onBlur='getCustomerGroup(this);'>
								<input type="button" value="?" class="button" name='custGroupSrch' id='custGroupSrch'	onClick='populateCustomerGroup()'>
						</td>	
						<td class='label'><fmt:message key="Common.Customer.label"	bundle="${common_labels}" /></td>
						<td class='fields'>
								<input type="hidden" name="CustomerCode" id="CustomerCode"	size="20" maxlength="20" value=""> 
								<input type="text"	name="Customername" id="Customername" size='20' maxlength='20' onBlur='getCustomerCode(this);'>
								<input type="button" value="?" class="button" name='customerSrch' id='customerSrch' onClick='populateCustomer()'>
						</td>

					</tr>
					<tr>
						<td class='label'><fmt:message key="eCA.Policy.label"	bundle="${common_labels}" /></td>
						<td class='fields'>
								<input type="hidden" name="policyCode" id="policyCode"	size="20" maxlength="20" value=""> 
								<input type="text"	name="policyName" id="policyName" size='20' maxlength='20' onBlur='getPolicyCode(this);'>
								<input type="button" value="?" class="button" name='' id='' onClick='populatePolicy()'>
						</td>
						<td class="label"><fmt:message key="eCA.DischargePeriod.label" bundle="${common_labels}"/> </td>
						<td class='fields' >
							<input type=textbox size=10 maxlength=10 name=p_fm_Date value="<%=prevCurrDate%>" onblur='return Check_Date(this,"DMY","<%=locale%>");'>
							<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('p_fm_Date');" >
							<input type=textbox size=10 maxlength=10 name=p_to_Date onblur='return checkingDate(this,"DMY","<%=locale%>")' value="<%=currDate%>">
							<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('p_to_Date');" >
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					    <td class="label">
						<fmt:message key="Common.encounter.label" bundle="${common_labels}" />&nbsp;<fmt:message key="Common.Period.label" bundle="${common_labels}" />
						</td>	
						<td class='fields'>
							<input type='textbox' id='et_from'	name='et_from' id='et_from' value='' size=10 maxlength=10 onblur='chkDateTime1(this,"DMY","<%=locale%>","CODER");'></input>
							<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('et_from')">
							<input type='textbox' id='et_to' name='et_to' id='et_to' value='' size=10	maxlength=10 onblur='chkDateTime1(this,"DMY","<%=locale%>","CODER");'></input>
							<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('et_to')"></input>					
						</td>	
					</tr>	
					<tr>
						<td colspan=4 align="center">
							<input type="button" value="Search"  class="button" name='Search' id='Search' OnClick='getResults()'>	
							<input type="button" value="Print Preview"  class="button" name='Print Preview' id='Print Preview' OnClick="showpreview('Preview')">	
							<input type="button" value="Print"  class="button" name='Print' id='Print' OnClick="showpreview('Print')">	
						</td>
					</tr>
				</table>		
			</td>
		</tr>
		<input type=hidden name=p_facility_id value='<%=facility_id%>'> 
		<input type=hidden name=p_status value=''> 
		<input type=hidden name=p_user_id value='<%=user_id%>'> 
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=user_id%>">
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="CA">
		<input type='hidden' value='N' name='P_ONLINE_YN' id='P_ONLINE_YN'>
		<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="CAREPCLINTAUDTRIAL">
	</table>	
</body>	
</form>
</html>

