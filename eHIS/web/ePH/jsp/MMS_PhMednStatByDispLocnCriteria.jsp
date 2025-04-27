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
 <%--Created  on 14/04/2009 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*,  java.text.*,webbeans.eCommon.*" %>

<html>
<head>
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
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/MMS_PhMednStatByPract.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
Connection con			= null;  // Added for MOHE-CRF-0074 - start
try{
	 con				= ConnectionManager.getConnection(request);
	boolean region_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REGION_CHECK");
	 // Added for MOHE-CRF-0074 - End
	
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	//String disp_locn_sql_select1=PhRepository.getPhKeyValue("SQL_PH_REPORT_DISP_LOCATION");

	String bean_id				= "PHRepMednOrdStatByPractBean" ;
	String bean_name			= "ePH.PHRepMednOrdStatByPractBean";
	PHRepMednOrdStatByPractBean bean	= (PHRepMednOrdStatByPractBean)getBeanObject( bean_id, bean_name ,request);
	bean.setLanguageId(locale);
    ArrayList facilityList        = bean.getMednFacilityList();
	String sys_date				  = "";
	sys_date					  = com.ehis.util.DateUtils.getCurrentDate("DMY","en");
	
	String customer_group_query="SELECT  CUST_GROUP_CODE CODE,SHORT_DESC DESCRIPTION FROM AR_CUST_GROUP_LANG_VW WHERE upper(CUST_GROUP_CODE) like upper(?) and upper(SHORT_DESC) like upper(?) AND LANGUAGE_ID=";//added for MMS CRF-0107 start
	String customer_query="SELECT CUST_CODE CODE,SHORT_NAME DESCRIPTION FROM AR_CUSTOMER_LANG_VW WHERE upper(CUST_CODE) like upper(?) and upper(SHORT_NAME) like upper(?) AND LANGUAGE_ID=";//added for MMS CRF-0107 end
			
	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074

%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednStatByDispLocnCriteria.p_facility_code.focus();"> 

<form name="formPhMednStatByDispLocnCriteria" id="formPhMednStatByDispLocnCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="3" cellspacing="3" width="100%" align="center" border="0">
	<TH COLSPAN="6" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td align="right" width="10%" class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="2" align="left">&nbsp;<SELECT name="p_facility_code" id="p_facility_code" onChange='parent.clerrDispanceLocation()'>
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
	if (facilityList.size() > 0 )
				for (int i=0; i<facilityList.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= facilityList.get(i) %>"><%= facilityList.get(i+1) %></OPTION>

<% 	} 
	} //Added for MOHE-CRF-0074
%>
	</SELECT></td>
	<td align="right" COLSPAN="3">&nbsp;</td>
	</tr>
	<tr>
		<td align="right" width="10%" class="label" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
     	<td  align="left" width="12%" >&nbsp;<input type="text" size="10" maxlength=10 name="P_DATE_FROM" id="P_DATE_FROM" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('P_DATE_FROM');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"></td>
        <td align="left" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td align="right" class="label"><input type="text" size="10" maxlength=10 name="P_DATE_TO" id="P_DATE_TO" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('P_DATE_TO');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	   <td  COLSPAN="3">&nbsp;</td>
	</tr>
	<tr>
		
		<td align="right" width="10%"  class="label" nowrap><fmt:message key="ePH.DispenseLocationFrom.label" bundle="${ph_labels}"/></td>
		<td align="left" width="12%" >&nbsp;<input type="text" name="from_location_name" id="from_location_name" maxlength="20" size="20" value="" 
		OnBlur="parent.assgnDispenseLocation(formPhMednStatByDispLocnCriteria.from_location_name, 1)"
		onchange="parent.assgnDispenseLocation(formPhMednStatByDispLocnCriteria.from_location_name, 1)"><input type="button" class="button" value="?" name="from_location_search" id="from_location_search"
		onClick="parent.searchDispenseLocation(formPhMednStatByDispLocnCriteria.from_location_name, 1)">
		<input type="hidden" name="from_location_code" id="from_location_code" value=""></td>
		
		<td align="left" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
<td>&nbsp;<input type="text" name="to_location_name" id="to_location_name" maxlength="20" size="20" value="" OnBlur="parent.assgnDispenseLocation(formPhMednStatByDispLocnCriteria.to_location_name, 2)" onchange="parent.assgnDispenseLocation(formPhMednStatByDispLocnCriteria.to_location_name, 2)"><input type="button" class="button" value="?" name="to_location_search" id="to_location_search"onClick="parent.searchDispenseLocation(formPhMednStatByDispLocnCriteria.to_location_name, 2)">
		<input type="hidden" name="to_location_code" id="to_location_code" value=""></td>
		<td  COLSPAN="3">&nbsp;</td>
	</tr>
	</tr>
	<tr>
	               <td align="right" class="label" width='15%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td> <!-- //added for MMS CRF-0107 start -->
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
	</tr>
	<tr style="white-space: nowrap;">
    <td align="right" class="label" nowrap><fmt:message key="ePH.CustomerGroup.label" bundle="${common_labels}"/></td>
    <td align="left" class="label">
        <input type="text" name="p_customer_group" id="p_customer_group" maxlength="40" size="40" value="">
        <input type="button" class="button" value="?" name="p_customer_group_desc" id="p_customer_group_desc"  onClick="CustomerGroupSearch(document.formPhMednStatByDispLocnCriteria.p_customer_group);">
    </td>
    <td width="5%" class="label" align="right" nowrap><fmt:message key="Common.Customer.label" bundle="${common_labels}"/></td>
    <td colspan="2" align="left" class="label">
        <input type="text" name="p_customer" id="p_customer" maxlength="40" size="40" value="">
        <input type="button" class="button" value="?" name="p_customer_desc" id="p_customer_desc"  onClick="CustomerSearch(document.formPhMednStatByDispLocnCriteria.p_customer)">
    </td>
</tr>
 <!-- //added for MMS CRF-0107 end -->
	
	</table>
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue("login_user") %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
 	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHMEDORSTATDLOC"> 
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE="">
	<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE="">
	<INPUT TYPE="hidden" name="systemdate" id="systemdate" VALUE="<%=sys_date%>">
    <INPUT TYPE="hidden" name="disp_locn_sql_select1" id="disp_locn_sql_select1" VALUE="SELECT A.DISP_LOCN_CODE code,SHORT_DESC description FROM PH_DISP_LOCN_LANG_VW A WHERE  A.FACILITY_ID LIKE ? AND upper(DISP_LOCN_CODE) LIKE upper(?) AND upper(SHORT_DESC )LIKE upper(?) AND EFF_STATUS='E' and a.language_id=">
    <INPUT TYPE="hidden" name="SQL_PH_CUSTOMER_GROUP_SELECT" id="SQL_PH_CUSTOMER_GROUP_SELECT" value="<%=customer_group_query%>"> <!-- //added for MMS CRF-0107 start -->
	<INPUT TYPE="hidden" name="SQL_PH_CUSTOMER_SELECT" id="SQL_PH_CUSTOMER_SELECT" value="<%=customer_query%>"> 
	<INPUT TYPE="hidden" name="P_CUST_GROUP_CODE" id="P_CUST_GROUP_CODE" VALUE=""> 
	<INPUT TYPE="hidden" name="P_CUST_CODE" id="P_CUST_CODE" VALUE=""><!-- //added for MMS CRF-0107 end -->
<% putObjectInBean(bean_id,bean,request); %>
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

