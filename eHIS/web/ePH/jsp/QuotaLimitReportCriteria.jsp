<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
21/04/2023        40016               HARIHARAN     21/04/2023       ramesh goli          ML-MMOH-CRF-1823.V1.0
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.*, eCA.*, ePH.*, ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
<%
		request.setCharacterEncoding("UTF-8");
		String locale	= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../ePH/js/QuotaLimitReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script> 
		<script language="javascript" src="../../eOR/js/OrCommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
	    String sql_ph_drug_query_select2		=	PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2");
		String bean_id		= "PHReportsBean" ; 
		String bean_name	= "ePH.PHReportsBean";
		PHReportsBean bean = (PHReportsBean)getBeanObject( bean_id,bean_name, request) ;
		bean.setLanguageId(locale);
		ArrayList facilityList      = bean.getFacilitys();
        
    	String curr_sys_date = "";
    	String curr_week_date  = "";
    	curr_sys_date = com.ehis.util.DateUtils.getCurrentDate("DMY",localeName);
    	curr_week_date	= com.ehis.util.DateUtils.minusDate(curr_sys_date,"DMY",localeName,6,"d");

		
		String Sysdate 				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	
		
	%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="formQuoLimitReportCriteria" id="formQuoLimitReportCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
		   <table cellpadding="0" cellspacing="0" width="85%" align="center" border="0">
		         <tr ><td COLSPAN=5>&nbsp;</td></tr>
		         
	<th align='left' colspan="8"><fmt:message key="Common.reportcritera.label" bundle="${ph_labels}"/></th>
	<tr ><td COLSPAN=5>&nbsp;</td></tr>	
	<tr>
			
	<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td>
		<input type="text" name="p_patient_id" id="p_patient_id" size="20" value=""  maxlength="<%=bean.getPatientIDLength()%>" onKeyPress="changeToUpper()" >
		<input type="button" value="?" class="button" name="btnPatientID" id="btnPatientID" onClick="callPatientSearch()"   >
	</td>
	<td class="label" colspan = 2 ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td class='fields' >
	    <input type="text" name="p_speciality" id="p_speciality" size="20" value=""   onBlur='getSplCode(this);' OnChange='resetValues()'>
	    <input type="button" value="?" class="button" name='splSearch' id='splSearch' onClick='populateSpl();'>&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif">
	    <input type="hidden" name="p_speciality_code" id="p_speciality_code" size="20" maxlength="20" value="">
	</td>				
			
	<td class="label" nowrap ><fmt:message key="Common.PrescribedBy.label" bundle="${common_labels}"/></td>
    <td>
      	<input type="text" maxlength="40" size="20" name="p_prescribed_by" id="p_prescribed_by"   value="" onBlur='getpractCode(this);' OnChange='resetValues()'>
      	<input type="button" class="button" value="?"   onClick="PrescribeSearchCode(this);">
      	<input type="hidden" name="p_prescribed_id" id="p_prescribed_id" size="20" maxlength="20" value="">
	</td>
				
    </tr>   
     <tr ><td COLSPAN=5>&nbsp;</td></tr>
     <tr>
          <td class="label"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></td>
          <td><input type="text" name="p_drug_name" id="p_drug_name" size="20" value="" onBlur='getdrugname(this);' OnChange='resetValues()'>
		  <input type="button" class="button" value="?" name="drug_search" id="drug_search" onclick="searchDrugName1(this);">
		  <input type="hidden" name="p_drug_code" id="p_drug_code" value="">
	</td>
		
          <td class="label" colspan = 2><fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/></td> 
		  <td class="label"><input type="text" size="12" maxlength=10 name="p_ord_fm_date" id="p_ord_fm_date" value="<%=curr_week_date%>" OnBlur="CheckDateLeap1(this);"><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_ord_fm_date');" >&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif"></td>
		  <td class="label">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		  <td class="label"><input type="text" size="10" name="p_ord_to_date" id="p_ord_to_date" maxlength=10 value="<%=curr_sys_date%>" OnBlur="CheckDateLeap1(this);"><IMG  SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_ord_to_date');" >&nbsp;<img name='mandatory'  src="../../eCommon/images/mandatory.gif"></td>
	</tr>
		
		
							
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input tYPE="hidden" name="p_user_id" id="p_user_id" VALUE="<%= session.getValue( "login_user" ) %>">
			<input tYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
			<input tYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
			<input type="hidden" name="p_report_id" id="p_report_id" value="PHQUOTALR">
			<input tYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
			<input type="hidden" name="P_FRDATE" id="P_FRDATE" value="">
		    <input type="hidden" name="P_TODATE" id="P_TODATE" value="">
			<input type="hidden" name="sys_date" id="sys_date" value="<%=curr_sys_date%>">
			<input type='hidden' name='flag' id='flag' value='true'>
			<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
			<input type="hidden" name="sql_ph_drug_query_select2" id="sql_ph_drug_query_select2" value="<%=sql_ph_drug_query_select2%>">
		  

		</form>
		<% putObjectInBean(bean_id,bean,request); %>
		</body>

	


</html>

