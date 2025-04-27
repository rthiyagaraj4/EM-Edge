<!DOCTYPE html>
<!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
06/05/2021		TFS-15598       Prabha          MOHE-CRF-0074
---------------------------------------------------------------------------------------------------------------
*/ --> 

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*, java.sql.*,  java.text.*,webbeans.eCommon.*"  %> <!-- Modified for MOHE-CRF-0074 -->
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ;	 //Added for MOHE-CRF-0074
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../js/MMS_StatisticalReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	
    String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PHReportsBean" ;
	String bean_name			= "ePH.PHReportsBean";
	PHReportsBean bean	= (PHReportsBean)getBeanObject(bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String currentyear				= com.ehis.util.DateUtils.getCurrentDate("YY",locale);
	bean.setLoginFacilityId(p_facility_id);
	ArrayList customerGrouplist = bean.getCustomerGroup();
	ArrayList customerlist = bean.getCustomer();
    ArrayList Policylist= bean.getPolicy();
	ArrayList facilities=bean.getFacilitys();
	
	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheckNew(region_code); //Added for MOHE-CRF-0074 //Modified for MOHE-CRF-0074
%>
    <BODY onMouseDown="CodeArrest()" onKeyDown=""> 
		<form name="MMS_StatisticalReportsCriteria" id="MMS_StatisticalReportsCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" >
				<TH COLSPAN="6" ALIGN="center"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr><td class='label' colspan='6' >&nbsp;</td></tr>
				<tr>
					<td class="label" width='10%'><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class="label" width='20%'><SELECT name="p_report_type" id="p_report_type"  onChange="dispReqFields(this);" style="width:200px">
						<option value =""> -------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------- </option>
						<option value ="CP"> <fmt:message key="ePH.CostPerprescription.label" bundle="${ph_labels}"/></option>
						<option value ="CC"> <fmt:message key="ePH.CostPerCapita.label" bundle="${ph_labels}"/></option>	
						<option value ="SC"> <fmt:message key="ePH.MedicationSaleToCustomer.label" bundle="${ph_labels}"/></option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
					<td class="label" width='10%' id='lblfacility' style='visibility:hidden;'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td class="label" width='*' colspan='3' id='fldfacility' style='visibility:hidden;'>		  
						<SELECT name="facility_id" id="facility_id" style="width:250px">
						<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/> 
<%
if(region_check){ // MOHE-CRF-0074-Start
	   for (int i=0;i<region_code_check.size();i+=2){
			order_facility_id=(String)region_code_check.get(i);
			order_facility_name=(String)region_code_check.get(i+1);
%>
	<option value='<%=order_facility_id%>'><%=order_facility_name%></option>
<%	
		}
	}else{ //Added for MOHE-CRF-0074 - End
						if(facilities.size()!= 0 ){
							for(int i=0;i<facilities.size();i+=2){ 
%>
								<OPTION VALUE="<%=(String)facilities.get(i)%>"><%=(String)facilities.get(i+1)%></OPTION>
<%
							}
						}
	} //Added for MOHE-CRF-0074
%>
				  </SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
					</td>
				 </tr>
				<tr><td class='label' colspan='6' >&nbsp;</td></tr>
				 <tr>	
					<td class="label" width='10%' id='lblCustGroup' style='visibility:hidden;'><fmt:message key="ePH.CustomerGroup.label" bundle="${common_labels}"/></td>
					<td class="label" width='20%' id='fldCustGroup' style='visibility:hidden;'><SELECT name="p_cust_group_code" id="p_cust_group_code"  onChange="" style="width:200px">
						<option value =""> -------<fmt:message key="Common.all.label" bundle="${common_labels}"/>------- </option>
<%
						if(customerGrouplist!=null && customerGrouplist.size()>0){
							for(int i=0; i<customerGrouplist.size(); i+=2){
%>
								<OPTION  VALUE="<%= customerGrouplist.get(i) %>" ><%=customerGrouplist.get(i+1)%></OPTION>
<%
							}
						}
%>
						</select>
					</td>
					<td class="label" width='10%' id='lblCustomer' style='visibility:hidden;'><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
					<td class="label" width='20%' id='fldCustomer' style='visibility:hidden;'><SELECT name="p_cust_code" id="p_cust_code"  onChange="" style="width:250px">
						<option value =""> -------<fmt:message key="Common.all.label" bundle="${common_labels}"/>------- </option>
<%
						if(customerlist!=null && customerlist.size()>0){
							for(int i=0; i<customerlist.size(); i+=2){
%>
								<OPTION  VALUE="<%= customerlist.get(i) %>" ><%=customerlist.get(i+1)%></OPTION>
<%
							}
						}
%>
						</select>
					</td>
					<td class="label" width='10%' id='lblPolicy' style='visibility:hidden;'><fmt:message key="ePH.Policy.label" bundle="${common_labels}"/></td>
					<td class="label" width='20%' id='fldPolicy' style='visibility:hidden;'><SELECT name="p_policy_type_code" id="p_policy_type_code"  onChange="" style="width:350px">
						<option value =""> -------<fmt:message key="Common.all.label" bundle="${common_labels}"/>------- </option>
<%
						if(Policylist!=null && Policylist.size()>0){
							for(int i=0; i<Policylist.size(); i+=2){
%>
								<OPTION  VALUE="<%= Policylist.get(i) %>" ><%=Policylist.get(i+1)%></OPTION>
<%
							}
						}
%>
						</select>
					</td>
				</tr>
				<tr><td class='label' colspan='6' >&nbsp;</td></tr>
				<tr>	
					<td class="label" width='10%' id='lblYear' style='visibility:hidden;'><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
					<td class="label" width='20%' id='fldYear' style='visibility:hidden;'><input type='text' class="NUMBER" name='p_year' id='p_year' size='3' maxlength='4' value='<%=currentyear%>' onchange='checkYear(this);' onKeyPress="return allowValidNumber(this,event,4,0);" style='text-align:right;'>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
					<td class="label" width='10%' id='lblMonthFrom' style='visibility:hidden;'><fmt:message key="Common.MonthFrom.label" bundle="${common_labels}"/></td>
					<td class="label" width='20%' id='fldMonthFrom' style='visibility:hidden;'><SELECT name="p_fm_month" id="p_fm_month"  style="width:200px" onchange='validateMonths("FROM");'>
						<OPTION  VALUE="01" selected><fmt:message key="Common.January.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="02" ><fmt:message key="Common.February.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="03" ><fmt:message key="Common.March.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="04" ><fmt:message key="Common.April.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="05" ><fmt:message key="Common.May.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="06" ><fmt:message key="Common.June.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="07" ><fmt:message key="Common.July.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="08" ><fmt:message key="Common.August.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="09" ><fmt:message key="Common.September.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="10" ><fmt:message key="Common.October.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="11" ><fmt:message key="Common.November.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="12" ><fmt:message key="Common.December.label" bundle="${common_labels}"/></OPTION>
						</select>
					</td>
					<td class="label" width='10%' id='lblMonthTo' style='visibility:hidden;'><fmt:message key="Common.MonthTo.label" bundle="${common_labels}"/></td>
					<td class="label" width='20%' id='fldMonthTo' style='visibility:hidden;'><SELECT name="p_to_month" id="p_to_month"  style="width:200px" onchange='validateMonths("TO");'>
						<OPTION  VALUE="01" ><fmt:message key="Common.January.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="02" ><fmt:message key="Common.February.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="03" ><fmt:message key="Common.March.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="04" ><fmt:message key="Common.April.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="05" ><fmt:message key="Common.May.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="06" ><fmt:message key="Common.June.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="07" ><fmt:message key="Common.July.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="08" ><fmt:message key="Common.August.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="09" ><fmt:message key="Common.September.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="10" ><fmt:message key="Common.October.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="11" ><fmt:message key="Common.November.label" bundle="${common_labels}"/></OPTION>
						<OPTION  VALUE="12" selected><fmt:message key="Common.December.label" bundle="${common_labels}"/></OPTION>
						</select>
					</td>
                 </tr>
			</table>
			<input type="hidden" name="currYear" id="currYear" value="<%=currentyear%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=p_facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
			<input type="hidden" name="p_module_id" id="p_module_id" value="PH">
			<input type="hidden" name="p_report_id" id="p_report_id" value="">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
		</form>
	</body>
	<%	} // Added for MOHE-CRF-0074 - start
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->
</html>

