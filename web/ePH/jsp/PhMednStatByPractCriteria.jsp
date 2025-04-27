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
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*, java.sql.*,  java.text.*,webbeans.eCommon.*"  %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
	<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String p_user_name= (String) session.getValue( "login_user" ) ;	 //Added for MOHE-CRF-0074
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<!-- import the calendar script -->
		<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script LANGUAGE="javascript" src="../../ePH/js/PhMednStatByPract.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script LANGUAGE="javascript" src="../js/PhCommon.js"></script>
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
	String sql_ph_medn_stat_pract_select1=PhRepository.getPhKeyValue("SQL_PH_MEDN_STAT_PRACT_MODIFIED_SELECT");

	String bean_id				= "PHRepMednOrdStatByPractBean" ;
	String bean_name			= "ePH.PHRepMednOrdStatByPractBean";
	PHRepMednOrdStatByPractBean bean	= (PHRepMednOrdStatByPractBean)getBeanObject( bean_id, bean_name ,request) ;
	bean.setLanguageId(locale);
	String  med_or_yn			= bean.getMednOrList();
    ArrayList facilityList        = bean.getMednFacilityList();
	ArrayList jobtitle             = bean.getTitle();
	String sys_date					  = com.ehis.util.DateUtils.getCurrentDate("DMY","en");

	//ArrayList dateList          = bean.getMednDateList();

	if(med_or_yn.equals("N"))
		out.println("<script>GoBack()</script>");

	String order_facility_id="" , order_facility_name=""; //Added for MOHE-CRF-0074
	String region_code = bean.getRegionCode(); //Added for MOHE-CRF-0074
	ArrayList region_code_check = bean.getRegionCheck(p_user_name,region_code); //Added for MOHE-CRF-0074
%>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.formPhMednStatByPractCriteria.p_facility_code.focus();"> 

<form name="formPhMednStatByPractCriteria" id="formPhMednStatByPractCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
	
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr>
        <td align="right" class="label"><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<SELECT name="p_facility_code" id="p_facility_code"  onchange='callLocation(this)'>
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

<% 				}
			} //Added for MOHE-CRF-0074
%>
	
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="ePH.SelectBy.label" bundle="${ph_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<select name="p_select_by" id="p_select_by">
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<option value="D"><fmt:message key="Common.date.label" bundle="${common_labels}"/></option>
			<option value="M"><fmt:message key="Common.month.label" bundle="${common_labels}"/></option>
			<option value="Y"><fmt:message key="Common.year.label" bundle="${common_labels}"/></option>
			</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
 	</tr>
	<tr>
		<td align="right" class="label" ><fmt:message key="Common.periodfrom.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left" >&nbsp;<input type="text" size="10" maxlength=10 name="dt_from_1" id="dt_from_1" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from_1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif"  align="center"> &nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;<input type="text" size="10" maxlength=10 name="dt_to_1" id="dt_to_1" OnBlur='CheckDate(this)'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to_1');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	</tr>
	<tr><td class='label' colspan='4' height='4'></td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.JobTitle.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left" >&nbsp;<select name="p_job_title" id="p_job_title" id="p_job_title" DISABLED onchange='clear1(this)'>
		<OPTION VALUE="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</OPTION>
	<%	 if (facilityList.size() > 0 )
				for (int i=0; i<jobtitle.size(); i+=2) {
	%>
			 <OPTION VALUE="<%= jobtitle.get(i) %>"><%= jobtitle.get(i+1) %></OPTION>

	<% 	} %>
	</select>
		</td>
	</tr>


	<tr>
		<td align="right" width="15%" class="label"><fmt:message key="Common.PractitionerFrom.label" bundle="${common_labels}"/></td>
		<td align="left" width="30%">&nbsp;<input type="text" name="pract_name" id="pract_name" maxlength="30" size="30" value="" onblur="parent.searchPractitionerName(formPhMednStatByPractCriteria.pract_name, 1)"><input type="button" class="button" value="?" name="pract_search" id="pract_search"
		onClick="parent.searchPractitionerName(formPhMednStatByPractCriteria.pract_name, 1)"></td><!--- onblur Added for MMS_ADHOC_0044-->
		<input type="hidden" name="pract_id" id="pract_id" value="">
		<td align="right" width="5%" class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td align="left" width="50%">&nbsp;<input type="text" name="tpract_name" id="tpract_name" maxlength="30" size="30" value="" onblur="parent.searchPractitionerName(formPhMednStatByPractCriteria.tpract_name, 2)"><input type="button" class="button" value="?" name="tpract_search" id="tpract_search"
		onClick="parent.searchPractitionerName(formPhMednStatByPractCriteria.tpract_name, 2)"></td><!--- onblur Added for MMS_ADHOC_0044-->
		<input type="hidden" name="tpract_id" id="tpract_id" value="">
	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<select name="p_group_by" id="p_group_by">
					<option value="PD"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></option>
					<option value="PT"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
 	</tr>
	<tr>
		<td align="right" class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
		<td COLSPAN="3" align="left">&nbsp;<select name="p_report_by" id="p_report_by">
					<option value="DT"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></option>
					<option value="SM"><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center">
		</td>
	</tr>
	</table>
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= p_facility_id %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHRMSBYDR">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="dt_from" id="dt_from" VALUE="">
	<INPUT TYPE="hidden" name="dt_to" id="dt_to" VALUE="">
	<INPUT TYPE="hidden" name="systemdate" id="systemdate" VALUE="<%=sys_date%>">
<% putObjectInBean(bean_id,bean,request); %>
</form>
<INPUT TYPE="hidden" name="sql_ph_medn_stat_pract_select1" id="sql_ph_medn_stat_pract_select1" VALUE="<%=sql_ph_medn_stat_pract_select1%>">
</body>
<%
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

