<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*, java.sql.*,  java.text.*,webbeans.eCommon.*"  %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhMednStatistics.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject(bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednOrdStatCriteria.p_dt_from.focus();"> 
		<form name="formPhMednOrdStatCriteria" id="formPhMednOrdStatCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				
				<tr>
					<td align="right" class="label" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
					<td class="label" align="left" ><input type="text" size="10" maxlength=10 name="p_dt_from" id="p_dt_from" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_from');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"><!--dt_from to p_dt_from Added for DateConversion identification--> </td><td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td class="label">&nbsp;<input type="text" size="10" maxlength=10 name="p_dt_to" id="p_dt_to" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td><!--dt_to to p_dt_to Added for DateConversion identification-->
				</tr>
					
				<tr>
					<td align="right" width="15%" class="label"><fmt:message key="Common.PractitionerFrom.label" bundle="${common_labels}"/></td>
					<td align="left" width="30%" class="label"><input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" value="" ><input type="button" class="button" value="?" name="pract_search" id="pract_search"
					onClick="parent.searchPractitionerName(formPhMednOrdStatCriteria.pract_name, 1)"></td>
					<input type="hidden" name="pract_id" id="pract_id" value="">
					<td align="right" width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td align="left" width="50%" class="label">&nbsp;<input type="text" name="tpract_name" id="tpract_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tpract_search" id="tpract_search"
					onClick="parent.searchPractitionerName(formPhMednOrdStatCriteria.tpract_name, 2)"></td>
					<input type="hidden" name="tpract_id" id="tpract_id" value="">
				</tr>
				
				<tr>
				 <td width="3%" class="label" nowrap ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td> 
				 <td align="left" class="label"><input type="text" name="p_spec_desc" id="p_spec_desc" maxlength="40" size="40" value=""><input type="button" class="button" value="?" name="specialist" id="specialist"
					onfocus="SpecialistSearch(document.formPhMednOrdStatCriteria.p_spec_desc)"></td>
				<td class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		     <td>&nbsp;&nbsp;<input align="center" type='text'  name='p_patient_id' id='p_patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'
		        onfocus="callPatientLookup();" onClick="callPatientLookup();"></td>
				</tr>
				<tr>
				<td class="label" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		       <td >&nbsp;<input type="text" name="p_locn_name" id="p_locn_name" maxlength="20" size="20" ><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationSearch(document.formPhMednOrdStatCriteria.p_locn_name)" onClick="locationSearch(document.formPhMednOrdStatCriteria.locn_name)"></td>
		         <td align="right" class="label" nowrap><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
					<td align="left" class="label">&nbsp;<input type="text" name="p_drug_name" id="p_drug_name" maxlength="40" size="40" value=""><input type="button" class="button" value="?" name="p_drug_desc" id="p_drug_desc" onfocus="callDrugSearch(document.formPhMednOrdStatCriteria.p_drug_name)" onClick="callDrugSearch(document.formPhMednOrdStatCriteria.p_drug_name)">
					</td>
				</tr>
				
		<tr>
		<td align="right" class="label" width='15%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
					<td align="left" class="label">
						<select name="p_pat_class" id="p_pat_class">
							<option value="ALL"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
							<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
							<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
							<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
							<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
							<option value="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option>
						</select>
					</td>
					<td align="right" class="label" nowrap><fmt:message key="ePH.CustomerGroup.label" bundle="${common_labels}"/></td>
					<td align="left" class="label">&nbsp;<input type="text" name="p_customer_group" id="p_customer_group" maxlength="40" size="40" value=""><input type="button" class="button" value="?" name="p_customer_group_desc" id="p_customer_group_desc" onfocus="CustomerGroupSearch(document.formPhMednOrdStatCriteria.p_customer_group);" onClick="CustomerGroupSearch(document.formPhMednOrdStatCriteria.p_customer_group);">
                    </tr>
				
				<tr>
				<td align="right" class="label" nowrap><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><input type="text" name="p_customer" id="p_customer" maxlength="40" size="40" value=""><input type="button" class="button" value="?" name="p_customer_desc" id="p_customer_desc"
					onfocus="CustomerSearch(document.formPhMednOrdStatCriteria.p_customer)"
					onClick="CustomerSearch(document.formPhMednOrdStatCriteria.p_customer)"></td>
					<td  class="label" nowrap><fmt:message key="ePH.BillingGroup.label" bundle="${ph_labels}"/></td>
			      <td align="left" class="label">
				&nbsp;<input type="text" name="p_billing" id="p_billing" maxlength="40" size="40" value=""><input type="button" name="billing_Button" id="billing_Button" value="?" CLASS="button"  onClick="selectBillingGroup(document.formPhMednOrdStatCriteria.p_billing)" >
				</td></tr><tr></tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3" align="left" class="label"><select name="p_report_by" id="p_report_by">
					<option value="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					<option value="DT"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
                    </select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
				</td>
			</tr>
			</table>
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%=p_facility_id %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
			<input type="hidden" name="p_drug_code" id="p_drug_code" value="">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="p_spec_code" id="p_spec_code" VALUE="">
			<INPUT TYPE="hidden" name="P_CUST_GROUP_CODE" id="P_CUST_GROUP_CODE" VALUE=""> 
			<INPUT TYPE="hidden" name="P_CUST_CODE" id="P_CUST_CODE" VALUE="">
        	<input type ='hidden' name='P_BLNG_GRP_ID' id='P_BLNG_GRP_ID' value =''/>
        	<input type="hidden" name="p_locn_code" id="p_locn_code" value=""/> 
			<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=""/> 
			<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=""/>
			<% putObjectInBean(bean_id,bean,request); %>
		</form>
		
	</body>
</html>

