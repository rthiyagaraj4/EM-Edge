<!DOCTYPE html>
<!--This file is saved on 15/12/2009-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/SRRNarcoticTypeApprovalForm.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String bean_id				= "PhIssueTokenBean" ;
	String bean_name			= "ePH.PhIssueTokenBean";
	PhIssueTokenBean bean		= (PhIssueTokenBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	java.util.Date date_time	 	= new java.util.Date();
	String currentdate				= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	/*Updates Drug  Query by adding DRUG_YN column in Drug lookup for Loading only drugs on 26/7/2010 */
	String SQL_PH_DRUG_SEARCH_DRUG	=	"SELECT DRUG_CODE code, DRUG_DESC description FROM PH_DRUG_LANG_VW PH_DRUG WHERE  DISCONTINUED_YN='N' AND UPPER(DRUG_CODE) LIKE UPPER(?) AND UPPER(DRUG_DESC) LIKE UPPER(?) and drug_yn='Y' AND LANGUAGE_ID =";
	
%>
<BODY onload="document.formsrrnarcotictypeapproval.p_patient_id.focus();" onMouseDown="" onKeyDown="lockKey()">
<form name="formsrrnarcotictypeapproval" id="formsrrnarcotictypeapproval" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td class="label" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td>&nbsp;<input align="center" type='text'  name='p_patient_id' id='p_patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" maxlength="<%=bean.getPatientIDLength()%>" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'
		onfocus="callPatientLookup();" onClick="callPatientLookup();"></td>

	

		<td  class="label" nowrap><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td nowrap>&nbsp;<input type="text" name="p_disp_date_from" id="p_disp_date_from" value="<%=currentdate%>" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_disp_date_from))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_date_from');"  onblur='p_disp_date_from.focus()'>&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>

		<td  class="label" nowrap><label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label></td>
		<td nowrap>&nbsp;<input type="text" name="p_disp_date_to" id="p_disp_date_to" value="<%=currentdate%>" maxlength="10" size="10" onBlur="if(CheckDate(this))if(DateCheck(currentdate,p_disp_date_to))validate_date(this,'TO_DATE_LESS_FROM')">
		<IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('p_disp_date_to');" onblur='p_disp_date_to.focus()' >&nbsp;<img name='mandatory' src="../../eCommon/images/mandatory.gif"></td>   
		<INPUT TYPE="hidden" name="p_disp_date" id="p_disp_date" VALUE=""> 
			

	
  </tr>
  <tr>
		<td  class="label" nowrap><fmt:message key="ePH.PrescriptionID.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
		<td >&nbsp;<input type="text" maxLength="10" size="20"  name="p_fr_pre" id="p_fr_pre" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
		<td  class="label" nowrap><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" maxLength="10" size="20" name="p_to_pre" id="p_to_pre" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
		
		<td class="label" nowrap>&nbsp;&nbsp;</td> 
		<td>&nbsp;</td>
		
	
 </tr>
  <tr>
	
		<td  class="label" nowrap><fmt:message key="ePH.NarcoticNo.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
		<td>&nbsp;<input type="text" maxLength="12" size="20" name="p_narcotics" id="p_narcotics"" onKeyPress="return CheckForSpecialChars(event);"> </td>
		<td  class="label" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" maxLength="12" size="20" name="p_encounter" id="p_encounter"" onKeyPress="return CheckForSpecialChars(event);"> </td>
		<td  class="label" nowrap><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input type="text" name="p_pract_id" id="p_pract_id" maxlength="20" size="20" value=""  ><input type="button" name="btnLocation" id="btnLocation" class="button" value="?"  onClick=" searchPractitionerName(formsrrnarcotictypeapproval.p_pract_id);"><input type="hidden" name="pract_code" id="pract_code"></td>
	


 </tr>
 <tr>
		<td class="label" nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td >&nbsp;<select name="locn_type" id="locn_type" onChange="resetLocation()">		 <BR>
		<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
		<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
		<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
		</select></td>
		<td class="label" nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td >&nbsp;<input type="text" name="locn_name" id="locn_name" maxlength="20" size="20"  disabled><input type="button" name="btnLocation" id="btnLocation" class="button" value="?" onfocus="locationLookup(locn_name)" onClick="locationLookup(locn_name)"><input type="hidden" name="locn_code" id="locn_code"> </td>
		<td  class="label" nowrap><fmt:message key="Common.Drug.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td >&nbsp;<input type="text" maxlength="20" size="20" name="drug_desc" id="drug_desc"   value=""><input type="button" class="button" value="?"   onClick="searchCode(this);"  ><input type="hidden" name="drug_code" id="drug_code" value=""></td>

			<td  class="label" nowrap><input type="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="showResult()"></td>
 </tr>  
<INPUT TYPE="hidden" name="currentdate" id="currentdate" VALUE="<%=currentdate%>">
<INPUT TYPE="hidden" name="P_FACILITY_ID" id="P_FACILITY_ID" VALUE="<%=p_facility_id%>">
<INPUT TYPE="hidden" name="P_LANGUAGE_ID" id="P_LANGUAGE_ID" VALUE="<%=locale%>">
<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
<INPUT TYPE="hidden" name="P_NARCOTIC_NO" id="P_NARCOTIC_NO" VALUE="">
<INPUT TYPE="hidden" name="P_REPRINT" id="P_REPRINT" VALUE="">
<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="">
<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
</table>
</form>
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>">
<input type="hidden" name="SQL_PH_DRUG_SEARCH_DRUG" id="SQL_PH_DRUG_SEARCH_DRUG" value="<%=SQL_PH_DRUG_SEARCH_DRUG%>">
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

