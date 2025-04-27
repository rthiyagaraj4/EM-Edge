<!DOCTYPE html>
<%
/*

--------------------------------------------------------------------------------------------------------------
Date       	Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100               ?          		created
01/07/2014   MMS-QH-CRF-0108   SureshKumar T    Pharmacy Management->PH Reports->Consumption by Doctor ? Report Criteria
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,ePH.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/ConsumptionByDoctor.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
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
    ArrayList Policylist= bean.getPolicy();
    ArrayList specialist =bean.getAllSpecaility();
    
    	
	 String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);	
	 String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formDrugConsumCriteria.p_date_from.focus();">  
		<form name="formDrugConsumCriteria" id="formDrugConsumCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
		<table cellpadding="0" cellspacing="2" width="100%" align="center" border="0">
		<TH  colspan='10' height='4' ALIGN="Center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
			 <td width="3%" class="label" nowrap ><fmt:message key="ePH.Practitoner.label" bundle="${ph_labels}"/></td> 
				<td width="30%" class="label"><input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="pract_search" id="pract_search"  onfocus="searchPractitionerName(formDrugConsumCriteria.pract_name);" onClick="searchPractitionerName(formDrugConsumCriteria.pract_name);"></td>
				 <td width="3%" class="label" nowrap ><fmt:message key="Common.speciality.label" bundle="${ph_labels}"/></td> 
			    <td class='label'>
					<select name="p_spec_code" id="p_spec_code" onChange="" id="specialist">
						<option value="">  --------------<fmt:message key="Common.all.label" bundle="${common_labels}"/>--------------   </option>	
<%
						for (int i=0;i<specialist.size();i+=2){
%>
							<OPTION  VALUE="<%= specialist.get(i) %>" id="<%=specialist.get(i)%>"><%= specialist.get(i+1) %></OPTION>
<%              
						}
%>
					</select>
					</td>
			    </tr>
			<tr>	
					<td class="label" nowrap><fmt:message key="ePH.CustomerGroup.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class='label'>
					<select name="p_cust_grp_frm_code" id="p_cust_grp_frm_code" onChange="" id="p_fm_cust_group_code">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
<%
						for (int i=0;i<customerGrouplist.size();i+=2){
%>
							<OPTION  VALUE="<%= customerGrouplist.get(i) %>" id="<%=customerGrouplist.get(i)%>"><%= customerGrouplist.get(i+1) %></OPTION>
<%               
						}
%>
					</select>
					</td>
					<td class="label" nowrap><fmt:message key="ePH.CustomerGroup.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class='label'>
					<select name="p_cust_grp_to_code" id="p_cust_grp_to_code" onChange="" id="p_to_cust_group_code">
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>	
<%
						for (int i=0;i<customerGrouplist.size();i+=2){
%>
							<OPTION  VALUE="<%= customerGrouplist.get(i) %>" id="<%=customerGrouplist.get(i)%>"><%= customerGrouplist.get(i+1) %></OPTION>
<%              
						}
%>
					</select>
					</td></tr>		
					<tr><td  class="label" width='10%' ><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
					<td class='label'  width='15%' >
					<select name="p_cust_frm_code" id="p_cust_frm_code" onChange="" >
					<option value="">   ------------<fmt:message key="Common.all.label" bundle="${common_labels}"/>--------------   </option>
<%
						for (int i=0;i<customerlist.size();i+=2){
%>
							<OPTION  VALUE="<%= customerlist.get(i) %>" id="<%=customerlist.get(i)%>"><%= customerlist.get(i+1) %></OPTION>
<%               
						}
%>
					</select>
					</td>			
				<td align="right" class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td class='label' align="left">
				<SELECT name="P_patient_class" id="P_patient_class" style="width:150px">
					<option value =""> <fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
					<option value ="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
					<option value ="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></option>
					<option value ="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
					<option value ="XT"><fmt:message key="Common.external.label" bundle="${common_labels}"/></option> 
					<option value ="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
				</select>
			</td></tr>	
			
			<tr>
			
			<td  class="label" width='10%' nowrap><fmt:message key="ePH.Policy.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class='label'  width='15%'>
					<select name="p_policy_type_code" id="p_policy_type_code" onChange="" >
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
						for (int i=0;i<Policylist.size();i+=2){
%>
							<OPTION  VALUE="<%= Policylist.get(i) %>" id="<%=Policylist.get(i)%>"><%= Policylist.get(i+1) %></OPTION>
<%               
						}
%>
					</select>
					</td>

		     <td class="label"><fmt:message key="Common.DateFrom.label" bundle="${ph_labels}"/></td>
		        <td class='label'><input type="text" name="p_date_from" id="p_date_from" value="<%=currentdate%>" maxlength="10" size="10" onKeyPress="return AllowDateFormat()" onBlur="CheckDateT(this);DateCheck(currentdate,p_date_from)">
				<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_date_from');"  onblur='from_dt.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/><input type="text" name="p_date_to" id="p_date_to" value="<%=currentdate%>" maxlength="10" size="10" onKeyPress="return AllowDateFormat()" onBlur="CheckDateT(this);DateCheck(currentdate,p_date_to)"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_date_to');"  onBlur='p_date_to.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif">
		</td>
				</tr>
			</table>
		    <INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
		   <INPUT TYPE="hidden"  name="p_report_id" id="p_report_id" VALUE="PHCONSBYDOC">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<input type="hidden" name="p_mode" id="p_mode" value="VIEW"> 
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
			<INPUT TYPE="hidden" name="p_pract_id" id="p_pract_id" VALUE="">
		</form>
	</body>
</html>

