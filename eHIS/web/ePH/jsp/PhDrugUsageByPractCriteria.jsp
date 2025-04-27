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
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*, java.text.*, webbeans.eCommon.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ;	 //Added for MOHE-CRF-0074
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhDrugUsageByPract.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>

		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
     
	</head>
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK"); 
	// Added for MOHE-CRF-0074 - END
	
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String sql_ph_medn_stat_pract_select1=PhRepository.getPhKeyValue("SQL_PH_MEDN_STAT_PRACT_MODIFIED_SELECT");

	String sql_ph_reports_atc1_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC1_LOOKUP");
	String sql_ph_reports_atc2_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC2_LOOKUP");
	String sql_ph_reports_atc3_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC3_LOOKUP");
	String sql_ph_reports_atc4_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC4_LOOKUP");
	String sql_ph_reports_atc5_lookup=PhRepository.getPhKeyValue("SQL_PH_REPORTS_ATC5_LOOKUP");

	String bean_id				= "PHDrugUsageByPractBean" ;
	String bean_name			= "ePH.PHDrugUsageByPractBean";
	PHDrugUsageByPractBean bean	= (PHDrugUsageByPractBean)getBeanObject( bean_id,bean_name, request ) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList      = bean.getMednFacilityList();
	//ArrayList dateList          = bean.getMednDateList();
	ArrayList jobtitle          = bean.getTitle();

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");
	SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy");
	java.util.Date date_time	 	= new java.util.Date();
	String Sysdate ="";
	Sysdate 				= dtSystemFormat.format(date_time); 
	Sysdate=com.ehis.util.DateUtils.convertDate(Sysdate,"DMY","en",locale);
	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074
%>
	<!-- <BODY onload="document.formPhDrugUsageByPractCriteria.p_facility_code.focus();"> -->
	<BODY onload="document.formPhDrugUsageByPractCriteria.p_facility_code.focus();" onMouseDown="" onKeyDown="lockKey()">
	<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednStatByPractCriteria.p_facility_code.focus();"> -->
		<form name="formPhDrugUsageByPractCriteria" id="formPhDrugUsageByPractCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame"  >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="4"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr><td class='label' colspan='4' height='4'></td></tr>
				<tr>
					<td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" onchange='callLocation(this)'>
						<OPTION VALUE="" > <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
<%	
			if(region_check){ // MOHE-CRF-0074-Start
				   for (int i=0;i<region_code_check.size();i+=2){
						order_facility_id=(String)region_code_check.get(i);
						order_facility_name=(String)region_code_check.get(i+1);
%>
				<option value='<%=order_facility_id%>' ><%=order_facility_name%></option>
<%	
					}
				}else{ // MOHE-CRF-0074-End
						if (facilityList.size() > 0 ){
							for (int i=0; i<facilityList.size(); i+=2) {
%>
								<OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>
<% 
							}
						}
					}  //Added for MOHE-CRF-0074
%>
	
						</select>
					</td>
				</tr>
				<tr><td class='label' colspan='4' height='4'></td></tr>
				<tr>
					<td class="label" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3">&nbsp;<input type="text" size="10" maxlength=10 name="dt_from1" id="dt_from1" Onblur="CheckDateT(this);DateCheck(sysdate,dt_from1);validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> &nbsp;&nbsp;<label class="label">To</label>&nbsp;<input type="text" size="10" name="dt_to1" id="dt_to1" Onblur="CheckDateT(this);if(DateCheck(sysdate,dt_to1))validate_date(this,'TO_DATE_LESS_FROM')"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td><!--changed CheckDate to CheckDateT for Leap year calculation on 24/02/2012 -->
					<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" ">
					<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" ">
				</tr>
				<tr><td class='label' colspan='4' height='4'></td></tr>
				<tr>
					<td class="label"><fmt:message key="Common.JobTitle.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3">&nbsp;<select name="p_job_title" id="p_job_title" DISABLED onchange='clear1(this)'>
						<OPTION VALUE="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
<%	
						if (facilityList.size() > 0 ){
							for (int i=0; i<jobtitle.size(); i+=2) {
%>
							 <OPTION VALUE="<%= jobtitle.get(i) %>"><%= jobtitle.get(i+1) %></OPTION>
<%
							}
						}
%>
						</select>
					</td>
				</tr>
				<tr><td class='label' colspan='4' height='4'></td></tr>
				<tr>
					<td width="15%" class="label"><fmt:message key="Common.PractitionerFrom.label" bundle="${common_labels}"/></td>
					<td width="30%">&nbsp;<input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="pract_search" id="pract_search" disabled onClick="parent.searchPractitionerName(formPhDrugUsageByPractCriteria.pract_name, 1)"></td><!-- readonly removed for BRU-SCF-1185[45562] -->
					<input type="hidden" name="pract_id" id="pract_id" value=""> 
					<td width="10%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td width="50%">&nbsp;<input type="text" name="tpract_name" id="tpract_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tpract_search" id="tpract_search" disabled onClick="parent.searchPractitionerName(formPhDrugUsageByPractCriteria.tpract_name, 2)"></td><!-- readonly removed for BRU-SCF-1185[45562] -->
					<input type="hidden" name="tpract_id" id="tpract_id" value="">
				</tr>
				<tr><td class='label' colspan='4' height='4'></td></tr>
				<tr>
					<td width="15%" class="label"><fmt:message key="ePH.DrugNameFrom.label" bundle="${ph_labels}"/></td>
					<td width="30%" id="drug_from">
					&nbsp;<input type="text" name="drug_name" id="drug_name" readonly maxlength="30" size="30" value=""><input type="button" class="button" value="?"  name="drug_search" id="drug_search" onClick="callDrugSearch(document.formPhDrugUsageByPractCriteria.drug_name, 1)" ></td>
					<input type="hidden" name="drug_code" id="drug_code" value="">
					<td width="10%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td width="50%" id="drug_to">&nbsp;<input type="text" name="tdrug_name" id="tdrug_name" readonly maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search" onClick="callDrugSearch(document.formPhDrugUsageByPractCriteria.tdrug_name, 2)"></td>
					<input type="hidden" name="tdrug_code" id="tdrug_code" value="">
				</tr>
				<tr><td class='label' colspan='4' height='4'></td></tr>
				<tr>
					<td class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
					<td COLSPAN="1">&nbsp;<select name="p_group_by" id="p_group_by">
								<option value="PT"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
								<option value="DR"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
								</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				<td width="10%" class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td COLSPAN="4">&nbsp;<select name="p_report_by" id="p_report_by">
								<option value="DT"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
								<option value="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
								</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr><td class='label' colspan='4' height='4'></td></tr>

				<tr>
					<td class="label"><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/></td>
					<td COLSPAN="3">&nbsp;<select name="p_atc_level" id="p_atc_level" onChange='callATC(this);'>
					<OPTION VALUE="ALL">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
					<OPTION VALUE="ATC1"><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/>1</OPTION>
					<OPTION VALUE="ATC2"><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/>2</OPTION>
					<OPTION VALUE="ATC3"><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/>3</OPTION>
					<OPTION VALUE="ATC4"><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/>4</OPTION>
					<OPTION VALUE="ATC5"><fmt:message key="ePH.ATCLevel.label" bundle="${ph_labels}"/>5</OPTION>
					</select>
					</td>
				</tr>
				<tr><td class='label' colspan='4' height='4'></td></tr>
				<tr>
					<td width="15%" class="label"><fmt:message key="ePH.ATCLevelCodeFrom.label" bundle="${ph_labels}"/></td>
					<td width="30%" id="atc_from">&nbsp;<input type="text" name="p_atc_from_id" id="p_atc_from_id" readonly maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="narrationFrom" id="narrationFrom" onClick="search1(document.forms[0].p_atc_from_id,'1')" disabled></td>
					
					<td width="10%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td width="50%" id="atc_to">&nbsp;<input type="text" name="p_atc_to_id" id="p_atc_to_id" maxlength="30" readonly size="30" value=""><input type="button" class="button" value="?" name="narrationTo" id="narrationTo" onClick="search1(document.forms[0].p_atc_to_id,'2')" disabled></td>
					
				<input type="hidden" name="p_atc_from" id="p_atc_from" value="">
				<input type="hidden" name="p_atc_to" id="p_atc_to" value="">
				<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
				<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
				<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
				<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
				<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHUSBYPRA">
				</tr>
				<tr><td class='label' colspan='4' height='4'></td></tr>
			</table>
		</form>
		<INPUT TYPE="hidden" name="sql_ph_medn_stat_pract_select1" id="sql_ph_medn_stat_pract_select1" VALUE="<%=sql_ph_medn_stat_pract_select1%>">
		<INPUT TYPE="hidden" name="sql_ph_reports_atc1_lookup" id="sql_ph_reports_atc1_lookup" VALUE="<%=sql_ph_reports_atc1_lookup%>">
		<INPUT TYPE="hidden" name="sql_ph_reports_atc2_lookup" id="sql_ph_reports_atc2_lookup" VALUE="<%=sql_ph_reports_atc2_lookup%>">
		<INPUT TYPE="hidden" name="sql_ph_reports_atc3_lookup" id="sql_ph_reports_atc3_lookup" VALUE="<%=sql_ph_reports_atc3_lookup%>">
		<INPUT TYPE="hidden" name="sql_ph_reports_atc4_lookup" id="sql_ph_reports_atc4_lookup" VALUE="<%=sql_ph_reports_atc4_lookup%>">
		<INPUT TYPE="hidden" name="sql_ph_reports_atc5_lookup" id="sql_ph_reports_atc5_lookup" VALUE="<%=sql_ph_reports_atc5_lookup%>">
		<INPUT TYPE="hidden" name="sysdate" id="sysdate" VALUE="<%=Sysdate%>">
	</body>
<% putObjectInBean(bean_id,bean,request); 
} // Added for MOHE-CRF-0074 - start
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->	
</html>

