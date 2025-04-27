<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
28/06/2020	  IN073540      		Chandra	             AAKH-CRF-122.1
01/09/2020	        		        Chandra	             AAKH-SCF-0448
--------------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eOR.*"
	contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title>Coders Review</title>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "")?(String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String imgUrl = "";
	if (sStyle.equals("IeStyle.css")) {
		imgUrl = "../../eCommon/images/searchBoxBG.jpg";
	}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCA/js/CACodersReview.js'></script>
<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection con = null;
	PreparedStatement pstmt = null, stmtLen = null;
	ResultSet rs = null, rsetLen = null;

	java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
	String locale = (String) p.getProperty("LOCALE");
	String facility_id = (String) session.getAttribute("facility_id");//IN037756
	String PatIDLen = "";

	try {

		String sqlLen = "Select PATIENT_ID_LENGTH from mp_param";
		con = ConnectionManager.getConnection(request);
		stmtLen = con.prepareStatement(sqlLen);
		rsetLen = stmtLen.executeQuery();
		while (rsetLen.next()) {
			PatIDLen = (rsetLen.getString("PATIENT_ID_LENGTH") == null) ? "0": rsetLen.getString("PATIENT_ID_LENGTH");
		}
		if (rsetLen != null)
			rsetLen.close();
		if (stmtLen != null)
			stmtLen.close();

		String sql = "";
		String toDate = "";
		String frDate = "";
		toDate = com.ehis.util.DateUtils.getCurrentDate("DMY", locale);
		frDate = com.ehis.util.DateUtils.minusDate(toDate, "DMY", locale, 7, "d");
%>
<form name="CodersReviewCriteriaForm" id="CodersReviewCriteriaForm">
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='content'>
		<table border="0" width="100%" cellspacing='0' cellpadding='3' align='left'>
			<tr>
				<td class='label'><fmt:message key="Common.patientId.label"	bundle="${common_labels}"/> </td>
				<td class='fields'>
					<input type='text' size='20' name='patientId' id='patientId' value='' nowrap onKeyPress='return CheckForSpecChars(event)' size='<%=PatIDLen%>' maxlength='<%=PatIDLen%>'>
					<input type='button' name='patSearch' id='patSearch' class='button' value='?' tabIndex="4" onClick="callPatientSearch()">
				</td>

				<td class="label" nowrap colspan="1"><fmt:message key="Common.encounterid.label" bundle="${common_labels}" /></td>
				<td class='fields'>
					<input type="text"   name="encounterCode" id="encounterCode" maxlength="20" size="20" />					
				</td>
				<td class=LABEL><fmt:message key="Common.clinic.label" bundle="${common_labels}" />
			    <td class='fields'>
					<input type="text" name="clinicName" id="clinicName" maxlength="20" size="20" onBlur="getClinicCode(this);">
					<input type='button' name='clinicSearch' id='clinicSearch' class='button' value='?' tabIndex="4" onClick="populateClinic()">
					<input type="hidden" name="clinicCode" id="clinicCode" size="20" maxlength="20" value="">
				</td>
				<td class='label'><fmt:message key="Common.speciality.label" bundle="${common_labels}" /></td>
				<td class='fields'>
					<input type="text" name="splName" id="splName" size='20' maxlength='20' onBlur='getSplCode(this);'>
					<input type="button" value="?" class="button" name='splSearch' id='splSearch' onClick='populateSpl()'>
					<input type="hidden" name="splCode" id="splCode" size="20" maxlength="20" value=""> 
				</td>
			</tr>

			<tr>
				<td class='label'><fmt:message key="Common.discharged.label" bundle="${common_labels}" />&nbsp;<fmt:message key="Common.Period.label" bundle="${common_labels}" /></td>
				<td>
					<input type='textbox' id='dt_from' name='dt_from' id='dt_from' value='<%=frDate%>' size=10 maxlength=10 onblur='chkDateTime(this,"DMY","<%=locale%>","CODER");'></input>
					<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('dt_from')">&nbsp;
					<input type='textbox' id='dt_to' name='dt_to' id='dt_to' value='<%=toDate%>' size=10 maxlength=10 onblur='chkDateTime(this,"DMY","<%=locale%>","CODER");'></input>
					<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('dt_to')"></input>					
				</td>
				
				<td class='fields'>
					<fmt:message key="Common.encounter.label" bundle="${common_labels}" />&nbsp;<fmt:message key="Common.Period.label" bundle="${common_labels}" />
				</td>	
				<td class='fields'>
					<input type='textbox' id='et_from'	name='et_from' id='et_from' value='' size=10 maxlength=10 onblur='chkDateTime1(this,"DMY","<%=locale%>","CODER");'></input>
					<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('et_from')">&nbsp;
					<input type='textbox' id='et_to' name='et_to' id='et_to' value='' size=10	maxlength=10 onblur='chkDateTime1(this,"DMY","<%=locale%>","CODER");'></input>
					<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('et_to')"></input>					
				</td>	
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
					</select>
				</td>
			</tr>

			<tr>
				<td class='label'><fmt:message key="eCA.EncounterCodingstatus.label" bundle="${common_labels}" />
				</td>
				<td class='fields'>					
					<SELECT name="encodingstatusCode" id="encodingstatusCode" style="width:150px">					
						<option value =""> ------ Select ------</option>
						<option value ="NW"><fmt:message key="Common.New.label" bundle="${common_labels}"/></option>
						<option value ="DQ"><fmt:message key="eCA.DoctorQuery.label" bundle="${ca_labels}"/></option>
						<option value ="SQ"><fmt:message key="eCA.SupervisorQuery.label" bundle="${ca_labels}"/></option>
						<option value ="HD"><fmt:message key="Common.Hold.label" bundle="${common_labels}"/></option>
						<option value ="PC"><fmt:message key="Common.PartiallyCompleted.label" bundle="${common_labels}"/></option>
						<option value ="CO"><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
					</select>
				</td>
					
				<td class='label'><fmt:message key="Common.BillingGroup.label"	bundle="${common_labels}" /></td>
				<td class='fields'>
					<input type="hidden" name="billingGroupCode" id="billingGroupCode" size="20" maxlength="20" value=""> 
					<input type="text" name="billingGroupName" id="billingGroupName" size='20' maxlength='20' onBlur='getBillingGroup(this);'>
					<input type="button" value="?" class="button" name='billingSrch' id='billingSrch' onClick='populateBillingGroup()'>
				</td>
				
				<td class='label'><fmt:message key="Common.CustomerGroup.label" bundle="${common_labels}" /></td>
				<td class='fields'>
					<input type="hidden" name="CustomergroupCode" id="CustomergroupCode"	size="20" maxlength="20" value=""> 
					<input type="text" 	name="CustomergroupName" id="CustomergroupName" size='20' maxlength='20' onBlur='getCustomerGroup(this);'>
					<input type="button" value="?" class="button" name='custGroupSrch' id='custGroupSrch'	onClick='populateCustomerGroup()'>
				</td>	
				<td class='label'><fmt:message key="Common.Customer.label"	bundle="${common_labels}" /></td>
				<td class='fields'>
					<input type="hidden" name="CustomerCode" id="CustomerCode"	size="20" maxlength="20" value=""> 
					<input type="text"	name="Customername" id="Customername" size='20' maxlength='20' onBlur='getCustomerGroupCode(this);'>
					<input type="button" value="?" class="button" name='customerSrch' id='customerSrch' onClick='populateCustomer()'>
				</td>

			</tr>

			<tr>				
					
				<td class='label'><fmt:message key="eCA.Policy.label" bundle="${common_labels}" /></td>
				<td class='fields'>
					<input type="hidden" name="Policycode" id="Policycode" size="20" maxlength="20" value=""> 
					<input type="text" name="Policyname" id="Policyname" size='20' maxlength='20' onBlur='getPolicyCode(this);'>
					<input type="button" value="?" class="button" name='policySrch' id='policySrch' onClick='populatePolicy()'>
				</td>			
				<td colspan='4'>&nbsp;</td>
				<td >&nbsp;</td>
				<td align=left>
					<input type="button" class=button name='search' id='search'	value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.search.label","common_labels")%>" onClick="searchForDetails()">
					<input type="button" class=button name='clear' id='clear'	value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>"	onClick="clearData()">
				</td>
			</tr>
		</table>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>' />
		<input type='hidden' name='facilityId' id='facilityId' value='<%=facility_id%>' />
		<!-- Added for AAKH-SCF-0448 -->
		<script>
	   searchForDetails();
	 </script>
	</body>
</form>
<%
	if(rs != null) rs.close();
    if(pstmt != null) pstmt.close();
         
}
catch (Exception e)	
{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
}
finally    
{
	 if(con!=null)
		 ConnectionManager.returnConnection(con,request);
}
%>
</html>

