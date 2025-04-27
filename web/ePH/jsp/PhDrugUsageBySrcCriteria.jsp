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
22/06/2021		TFS-19207       Manickavasagam          MOHE-SCF-0108
---------------------------------------------------------------------------------------------------------------
*/ --> 
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String p_user_name= (String) session.getValue( "login_user" ) ;	 //Added for MOHE-CRF-0074
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/PhDrugUsageBySrc.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<!-- 	<script LANGUAGE="javascript" src="../js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>

<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK"); 
	// Added for MOHE-CRF-0074 - END
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
//	String sql_ph_nursing_unit_select =	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_NU_SELECT1");
	String sql_ph_nursing_unit_select = "SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID  AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?))AND EFF_STATUS='E' AND LOCN_TYPE ='N' AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) AND UPPER(LONG_DESC) LIKE UPPER(?) AND A.LANGUAGE_ID = ";

//	String sql_ph_clinic_select =	PhRepository.getPhKeyValue("SQL_PH_MEDN_ORD_STAT_SRC_CL_SELECT1");
	//String sql_ph_clinic_select = "SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE='C' AND  UPPER(CLINIC_CODE) LIKE  UPPER(?) AND  UPPER(LONG_DESC) LIKE  UPPER(?) AND A.LANGUAGE_ID = "; //ML-MMOH-SCF-0210 
	String sql_ph_clinic_select = "SELECT CLINIC_CODE CODE , LONG_DESC DESCRIPTION  FROM OP_CLINIC_LANG_VW A, SM_FACILITY_FOR_USER B WHERE A.FACILITY_ID = B.FACILITY_ID AND UPPER(A.FACILITY_ID) LIKE UPPER(DECODE(?,NULL,'%',?)) AND EFF_STATUS='E' AND CLINIC_TYPE in ('C','E') AND  UPPER(CLINIC_CODE) LIKE  UPPER(?) AND  UPPER(LONG_DESC) LIKE  UPPER(?) AND A.LANGUAGE_ID = "; //ML-MMOH-SCF-0210 - added clinic_type E - procedure unit
	String bean_id				= "PHRepMednOrdStatBySrcBean" ;
	String bean_name			= "ePH.PHRepMednOrdStatBySrcBean";
	PHRepMednOrdStatBySrcBean bean	= (PHRepMednOrdStatBySrcBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList       = bean.getMednFacilityList();
    
   

	if(med_or_yn.equals("N"))
	out.println("<script>GoBack()</script>");

	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074

%>

<BODY onload="document.formPhDrugUsageBySrcCriteria.p_facility_code.focus();" onMouseDown="" onKeyDown="lockKey()">
<!-- <BODY onload="document.formPhDrugUsageBySrcCriteria.p_facility_code.focus();"> -->
<!--<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhDrugUsageBySrcCriteria.p_facility_code.focus();"> -->

<form name="formPhDrugUsageBySrcCriteria" id="formPhDrugUsageBySrcCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" >
		   	<OPTION VALUE=""> <fmt:message key="ePH.AllAccessFacility.label" bundle="${ph_labels}"/></OPTION>
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
	if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

<% 		} 
	} //Added for MOHE-CRF-0074
%>
	</select>
	</tr>
	
	<tr>
		<td class="label" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<input type="text" size="10" name="dt_from1" id="dt_from1" maxlength=10 OnBlur='CheckDateT(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> &nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;<input type="text" size="10" name="dt_to1" id="dt_to1" maxlength=10 OnBlur='CheckDateT(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td><!--changed CheckDate to CheckDateT for Leap year calculation on 
24/02/2012 -->
		<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE=" ">
		<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE=" ">
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<select name="Location_Type" id="Location_Type" onChange="parent.disableLocation(this.value)">
		<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
		<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option><option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		</select></select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
    </tr>
	<tr>
		<td width="15%" class="label"><fmt:message key="ePH.LocationForm.label" bundle="${ph_labels}"/></td>
		<td width="30%">&nbsp;<input type="text" name="loc_name" id="loc_name" STYLE='overflow:visible;' value="" ><!--size="30" maxlength="30" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
		<input type="button" class="button"  disabled value="?" name="loc_search" id="loc_search"  onClick="parent.searchLocationName(formPhDrugUsageBySrcCriteria.loc_name, 1)"></td><!-- onfocus removed for MOHE-SCF-0108-->
		<input type="hidden" name="loc_id" id="loc_id" value="">
		<td width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%">&nbsp;<input type="text" name="tloc_name" id="tloc_name" STYLE='overflow:visible;' value="" ><!--size="30" maxlength="30" removed and STYLE='overflow:visible;' added for ML-MMOH-CRF-0752-->
		<input type="button" class="button" disabled value="?" name="tloc_search" id="tloc_search" onClick="parent.searchLocationName(formPhDrugUsageBySrcCriteria.tloc_name, 2)"></td> <!-- onfocus removed for MOHE-SCF-0108-->
		<input type="hidden" name="tloc_id" id="tloc_id" value="">
	</tr>
	<tr>
		<td width="15%" class="label"><fmt:message key="ePH.DrugNameFrom.label" bundle="${ph_labels}"/></td>
		<td width="30%" id="drug_from">&nbsp;<input type="text" name="drug_name" id="drug_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="drug_search" id="drug_search"  onClick="callDrugSearch(document.formPhDrugUsageBySrcCriteria.drug_name, 1)"></td> 
		<input type="hidden" name="drug_code" id="drug_code" value="">		<!-- Added id="drug_from" for ML-MMOH-SCF-0373 [IN:059797] -->
		<td width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td width="50%" id="drug_to">&nbsp;<input type="text" name="tdrug_name" id="tdrug_name" maxlength="30" size="30" value=""><input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search"  onClick="callDrugSearch(document.formPhDrugUsageBySrcCriteria.tdrug_name, 2)"></td>
		<input type="hidden" name="tdrug_code" id="tdrug_code" value="">	<!-- Added id="drug_to" for ML-MMOH-SCF-0373 [IN:059797] -->
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<select name="p_group_by" id="p_group_by">
					<option value="LC"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></option>
					<option value="DR"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
 	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3">&nbsp;<select name="p_report_by" id="p_report_by">
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
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHUSBYSRC">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">

</form>
<input type="hidden" name="nursing_unit_query" id="nursing_unit_query" value="<%=sql_ph_nursing_unit_select%>">
<input type="hidden" name="clinic_query" id="clinic_query" value="<%=sql_ph_clinic_select%>">
<% putObjectInBean(bean_id,bean,request); %>
</body>
<%} // Added for MOHE-CRF-0074 - start
catch(Exception e){
	e.printStackTrace();
}
finally{ 
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
}
%> <!-- Added for MOHE-CRF-0074 - End -->
</html>

