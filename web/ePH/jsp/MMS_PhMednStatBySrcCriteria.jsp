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
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/MMS_PhMednStatBySrc.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	 // Added for MOHE-CRF-0074 - End
	 
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String sql_ph_nursing_unit_select =	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_NU_SELECT1");
	String sql_ph_clinic_select =	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_CL_SELECT1");
	String bean_id				= "PHRepMednOrdStatBySrcBean" ;
	String bean_name			= "ePH.PHRepMednOrdStatBySrcBean";
	PHRepMednOrdStatBySrcBean bean	= (PHRepMednOrdStatBySrcBean)getBeanObject( bean_id,bean_name, request) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = bean.getMednFacilityList();
	
    String customer_group_query="SELECT  CUST_GROUP_CODE CODE,SHORT_DESC DESCRIPTION FROM AR_CUST_GROUP_LANG_VW WHERE upper(CUST_GROUP_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) AND LANGUAGE_ID=";//added for MMS CRF-0107 start
	String customer_query="SELECT CUST_CODE CODE,SHORT_NAME DESCRIPTION FROM AR_CUSTOMER_LANG_VW WHERE upper(CUST_CODE) like upper(?) and upper(SHORT_NAME) like upper(?) AND LANGUAGE_ID=";//added for MMS CRF-0107 end

	if(med_or_yn.equals("N"))
		out.println("<script>GoBack()</script>");
			
	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednStatBySrcCriteria.p_facility_code.focus();"> 
		<form name="formPhMednStatBySrcCriteria" id="formPhMednStatBySrcCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
				<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
				<tr>
					<td  class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3" align="left" class="label"><SELECT name="p_facility_code" id="p_facility_code" >
						<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
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
						if (facilityList.size() > 0 ){
							for (int i=0; i<facilityList.size(); i+=2) {
			%>
								<OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

<% 	
						}
					}
				} //Added for MOHE-CRF-0074
%>
						</select>
					</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="ePH.SelectBy.label" bundle="${ph_labels}"/></td>
					<td COLSPAN="3" align="left" class="label"><select name="p_select_by" id="p_select_by">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						<option value="D"><fmt:message key="Common.date.label" bundle="${common_labels}"/></option>
						<option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
						<option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
					<td class="label" align="left" ><input type="text" size="10" maxlength="10" name="p_dt_from" id="p_dt_from" OnBlur='CheckDate(this)'>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_from');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> &nbsp;&nbsp;</td><td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td class="label"><input type="text" size="10" maxlength="10" name="p_dt_to" id="p_dt_to" OnBlur='CheckDate(this)'>&nbsp;<INPUT TYPE="image" SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3" align="left" class="label"><select name="Location_Type" id="Location_Type" onChange="parent.disableLocation(this.value)">
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
					<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option><option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					</select></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td  width="15%" class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/> <fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="left" width="30%" class="label"><input type="text" name="loc_name" id="loc_name" maxlength="30" size="30" value="" disabled="true"><input type="button" class="button"  value="?" name="loc_search" id="loc_search"
					disabled="true"
					onClick="parent.searchLocationName(formPhMednStatBySrcCriteria.loc_name, 1)"></td><!-- Modified for ML-BRU-SCF-1220 -->
					<input type="hidden" name="loc_id" id="loc_id" value="">
					<td  width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td align="left" width="50%" class="label"><input type="text" name="tloc_name" id="tloc_name" maxlength="30" size="30" value="" disabled="true"><input type="button" class="button"  value="?" name="tloc_search" id="tloc_search"
					disabled="true" 
					onClick="parent.searchLocationName(formPhMednStatBySrcCriteria.tloc_name, 2)"></td><!-- Modified for ML-BRU-SCF-1220 -->
					<input type="hidden" name="tloc_id" id="tloc_id" value="">
				</tr>
				
				</tr>
					<td  class="label" width='15%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td> <!-- //added for MMS CRF-0107 start -->
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
				<tr>
				<tr>
					<td  class="label" nowrap><fmt:message key="ePH.CustomerGroup.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><input type="text" name="p_customer_group" id="p_customer_group" maxlength="40" size="40" value=""><input type="button" class="button" value="?" name="p_customer_group_desc" id="p_customer_group_desc" onClick="CustomerGroupSearch(document.formPhMednStatBySrcCriteria.p_customer_group);"></td>
					<td  class="label" nowrap><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
					<td align="left" class="label"><input type="text" name="p_customer" id="p_customer" maxlength="40" size="40" value=""><input type="button" class="button" value="?" name="p_customer_desc" id="p_customer_desc"
					
					onClick="CustomerSearch(document.formPhMednStatBySrcCriteria.p_customer)"></td>
				</tr> <!-- //added for MMS CRF-0107 end -->
				<tr>
					<td  class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3" align="left" class="label"><select name="p_group_by" id="p_group_by">
							<option value="PD"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></option>
							<option value="LC"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
							</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td COLSPAN="3" align="left" class="label"><select name="p_report_by" id="p_report_by">
						<option value="DT"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
						<option value="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
						</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
					</td>
				</tr>
			</table>
			<input type="hidden" name="Nursing_Unit_Code" id="Nursing_Unit_Code" value="">
			<input type="hidden" name="Clinic_Code" id="Clinic_Code" value="">
			<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
			<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
			<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRMSBYSR">
			<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>"> 
			<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<INPUT TYPE="hidden" name="SQL_PH_CUSTOMER_GROUP_SELECT" id="SQL_PH_CUSTOMER_GROUP_SELECT" value="<%=customer_group_query%>"> <!-- //added for MMS CRF-0107 start -->
			<INPUT TYPE="hidden" name="SQL_PH_CUSTOMER_SELECT" id="SQL_PH_CUSTOMER_SELECT" value="<%=customer_query%>"> 
			<INPUT TYPE="hidden" name="P_CUST_GROUP_CODE" id="P_CUST_GROUP_CODE" VALUE=""> 
			<INPUT TYPE="hidden" name="P_CUST_CODE" id="P_CUST_CODE" VALUE="">
			<input type="hidden" name="dt_from" id="dt_from" value="">
			<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=""> <!-- //added for MMS CRF-0107 end -->
		</form>
		<% putObjectInBean(bean_id,bean,request); %>
		<input type="hidden" name="nursing_unit_query" id="nursing_unit_query" value="<%=sql_ph_nursing_unit_select%>">

		<input type="hidden" name="clinic_query" id="clinic_query" value="<%=sql_ph_clinic_select%>">
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

