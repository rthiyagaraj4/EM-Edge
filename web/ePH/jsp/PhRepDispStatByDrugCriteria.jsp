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
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ;	 //Added for MOHE-CRF-0074
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PhRepDispStatByDrug.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;  //UnCommented for MOHE-CRF-0074 -End
	String bean_id		= "PHRepDispStatByDrugBean" ;
	String bean_name	= "ePH.PHRepDispStatByDrugBean";
	PHRepDispStatByDrugBean bean	= (PHRepDispStatByDrugBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	ArrayList facilityList = bean.getFacilityList();
	
	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074
%>
	<body onMouseDown="" onKeyDown="lockKey()" onload="document.formPhRepDispStatByDrugCriteria.p_facility_code.focus();">
		<form name="formPhRepDispStatByDrugCriteria" id="formPhRepDispStatByDrugCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="3" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td align="left">&nbsp;&nbsp;<SELECT name="p_facility_code" id="p_facility_code" >
						<OPTION VALUE=" "> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
<%
		if(region_check){ // MOHE-CRF-0074-Start
			   for (int i=0;i<region_code_check.size();i+=2){
					order_facility_id=(String)region_code_check.get(i);
					order_facility_name=(String)region_code_check.get(i+1);
%>
			<option value='<%=order_facility_id%>' ><%=order_facility_name%></option>
<%
			   }
			}else{ //Added for MOHE-CRF-0074 - End
						if (facilityList.size() > 0 ){
							for (int i=0; i<facilityList.size(); i+=2) { 
%>
								<OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>
<% 	
							}
						}
			} //Added for MOHE-CRF-0074
%>
						</SELECT>
					</td>
				</tr>
				<tr><!-- On focus changed to onbluer for ML-BRU-SCF-2209 40219-->
					<td align="right" class="label" ><fmt:message key="ePH.ConsumptionDateFrom.label" bundle="${ph_labels}"/></td>
					<td align="left" class="label"><input type="text" size="10" maxlength=10  name="p_dt_from" id="p_dt_from" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_from');" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;<input type="text" size="10" maxlength=10 name="p_dt_to" id="p_dt_to" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_to');" ></td><!--dt_from to p_dt_from AND dt_to to p_dt_to Added for DateConversion identification -->
				</tr>
					<td align="right" class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
					<td align="left" class="label">
					<input type="text" name="drug_name" id="drug_name" maxlength="40" size="40" value=""  onBlur="callDrugSearch(document.formPhRepDispStatByDrugCriteria.drug_name)">
					<input type="button" class="button" value="?" name="drug_desc" id="drug_desc"
					onClick="callDrugSearch(document.formPhRepDispStatByDrugCriteria.drug_name)">
					<input type="hidden" name="drug_code" id="drug_code" value="">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
					<td align="left" class="label" ><select name="Encounter_Type" id="Encounter_Type">
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
						<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
						<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><select name="P_Report_By" id="P_Report_By">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value="PA"><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
						<option value="PC"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
						<option value="SO"><fmt:message key="Common.source.label" bundle="${common_labels}"/></option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				 </tr>
			</table>
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRDSBYDR">
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=""><!--Added for DateConversion identification -->
			<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=""><!--Added for DateConversion identification -->
			<% putObjectInBean(bean_id,bean,request); %>
		</form>
	</body>
	<%  // Added for MOHE-CRF-0074 - start
} 
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->
</html>

