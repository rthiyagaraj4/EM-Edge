<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100               ?          		created
20/08/2014   MMS-QH-CRF-0112   SureshKumar T    Pharmacy Management->Issues by Doctor / Company ? Report Criteria
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,ePH.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhIssuesByDoctorCompany.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject(bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String sys_date=bean.getSysDate();
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	bean.setLoginFacilityId(p_facility_id);

	ArrayList customerGrouplist = bean.getCustomerGroup();
	ArrayList customerlist = bean.getCustomer();
	ArrayList billingGroup = bean.getBillingGroup();


	String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
	String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formIssuesByDoctor.doc_from_date.focus();">  
		<form name="formIssuesByDoctor" id="formIssuesByDoctor" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="2" width="100%" align="center" border="0">
				<TH  colspan='10' height='4' ALIGN="Center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
					<td class="label" WIDTH='15%'><fmt:message key="Common.DateFrom.label" bundle="${ph_labels}"/>
					<td class='label' WIDTH='15%'><input type="text" name="doc_from_date" id="doc_from_date" value="<%=currentdate%>" maxlength="10" size="10" onKeyPress="return AllowDateFormat()" onBlur="if(CheckDateT(this)) validateDate();"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='CalendarFrom' onclick="return showCalendar('doc_from_date');"  onblur='from_dt.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>
					<td class='label' WIDTH='15%'><label class="label" width='30%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class='label' WIDTH='15%'><input type="text" name="doc_to_date" id="doc_to_date" value="<%=currentdate%>" maxlength="10" size="10" onKeyPress="return AllowDateFormat()" onBlur="if(CheckDateT(this)) validateDate();"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id='CalendarTo' onclick="return showCalendar('doc_to_date');"  onBlur='doc_to_date.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>
					<td class='label' WIDTH='40%'>&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
					<td class='label' ><SELECT name="p_sal_trn_type" id="p_sal_trn_type"  style="width:150px">
						<option value =""> <fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
						<option value ="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
						<option value ="D"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
						<option value ="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
						<option value ="X"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option> 
						<option value ="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option><!--added for MMS-DM-SCF-0016 [IN:055389]  -->
					</select></td>
					<td class='label' ><fmt:message key="ePH.Practitoner.label" bundle="${ph_labels}"/>
					<td class='label' ><input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="pract_search" id="pract_search" onfocus="searchPractitionerName(formIssuesByDoctor.pract_name);"  onClick="searchPractitionerName(formIssuesByDoctor.pract_name);"></td>				
					<td class='label' >&nbsp;</td>
				</tr>
				<tr>	
					<td class="label" nowrap><fmt:message key="ePH.CustomerGroup.label" bundle="${common_labels}"/></td>
					<td class='label'>
						<select name="p_cust_grp_code" id="p_cust_grp_code" onChange="" id="p_fm_cust_group_code">
							<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
<%
							for (int i=0;i<customerGrouplist.size();i+=2){
%>
								<OPTION  VALUE="<%= customerGrouplist.get(i) %>" id="<%=customerGrouplist.get(i)%>"><%= customerGrouplist.get(i+1) %></OPTION>
<%               
							}
%>	
						</select></td>
						<td class='label' ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
						<td class='label' ><select name="p_cust_code" id="p_cust_code" onChange="" >
							<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
							for (int i=0;i<customerlist.size();i+=2){
%>
								<OPTION  VALUE="<%= customerlist.get(i) %>" id="<%=customerlist.get(i)%>"><%= customerlist.get(i+1) %></OPTION>
<%               
							}
%>
						</select>
					</td>			
					<td class='label' >&nbsp;</td>
				</tr>	
				<tr>
					<td class="label" align='right'><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/></td>
					<td class='label' align="right"><select name="p_blng_grp_id" id="p_blng_grp_id" >
							<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
							for (int i=0;i<billingGroup.size();i+=3){
%>
								<OPTION  VALUE="<%= billingGroup.get(i) %>" id="<%=billingGroup.get(i)%>"><%= billingGroup.get(i+1) %></OPTION>
<%               
							}
%>
					</select></td>
					<td class='label' ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td class='label' ><input type="text" name="disp_location" id="disp_location"  size="20" value="" ><input type="button" class="button" value="?" name="disp_loc_search" id="disp_loc_search" onfocus="callDispLocSearch(formIssuesByDoctor.disp_location)" onClick="callDispLocSearch(formIssuesByDoctor.disp_location)"></td>
					<td class='label' >&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </td>
					<td class="label"><select name="reportType" id="reportType" onChange=" ">
						<option value="S" selected><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
						<option value="D"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
					</select></td>
					<td class='label' colspan='3' >&nbsp;</td>
				</tr> 
			</table>
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden"  name="p_report_id" id="p_report_id" VALUE="">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_mode" id="p_mode" value="VIEW"> 
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
			<INPUT TYPE="hidden" name="p_practitioner_id" id="p_practitioner_id" VALUE="">
			<INPUT TYPE="hidden" name="p_disp_locn_id" id="p_disp_locn_id" VALUE="">
			<INPUT TYPE="hidden" name="p_doc_from_date" id="p_doc_from_date" VALUE="">
			<INPUT TYPE="hidden" name="p_doc_to_date" id="p_doc_to_date" VALUE="">
			<input type="hidden" name="SQL_PH_DISP_LOCN_LANG_VW_SELECT" id="SQL_PH_DISP_LOCN_LANG_VW_SELECT" value="SELECT A.DISP_LOCN_CODE code,SHORT_DESC description FROM PH_disp_locn_lang_vw A WHERE  A.FACILITY_ID LIKE ? AND upper(DISP_LOCN_CODE) LIKE upper(?) AND upper(SHORT_DESC )LIKE upper(?) AND A.DISP_LOCN_TYPE='P' and a.language_id=">
		</form>
	</body>
</html>

