<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<!-- import the calendar script -->
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
 	<script LANGUAGE="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/DrugsAfterOfficeHours.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
	<script LANGUAGE="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
	<script LANGUAGE="javascript" src="../../ePH/js/PhCommon.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="formPhDrugAfterOfficeHoursCriteria" id="formPhDrugAfterOfficeHoursCriteria" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
    <BR><BR><BR>
	<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0"> 
	<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<tr><td COLSPAN="4" class="label">&nbsp;</td></tr> 
	<tr>
        <td  class="label" width="23%"><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td >&nbsp;
			<SELECT name="location_type" id="location_type" onChange="getDispLoc(this);">
				<OPTION VALUE="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;</OPTION> 
		   		<OPTION VALUE="C"> <fmt:message key="Common.clinic.label" bundle="${common_labels}"/></OPTION>
			    <OPTION VALUE="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></OPTION>
   			</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif" ></td>
		<td  COLSPAN="2" class="label"></td>
	</tr>
	<tr id='disp_lookup' style='display:none'> 
    <td width="15%" class="label" id="disp_txt"></td>
    <td align="left" width="30%">
        &nbsp;
        <input type="text" name="drug_name" id="drug_name" STYLE='overflow:visible;' value="" readonly>
        <input type="button" class="button" value="?" name="drug_search" id="drug_search" onClick="locationLookup(drug_name,1);">
        <input type="hidden" name="locn_code1" id="locn_code1">
    </td>
    <input type="hidden" name="drug_code" id="drug_code" value="">
    <td width="5%" class="label">
        <fmt:message key="Common.to.label" bundle="${common_labels}"/>
    </td>
    <td align="left" width="50%">
        &nbsp;
        <input type="text" name="tdrug_name" id="tdrug_name" STYLE='overflow:visible;' value="" readonly>
        <input type="button" class="button" value="?" name="tdrug_search" id="tdrug_search" onClick="locationLookup(tdrug_name,2);">
        <input type="hidden" name="locn_code2" id="locn_code2">
    </td> 
    <input type="hidden" name="tdrug_code" id="tdrug_code" value="">
</tr>

	<tr>
        <td  class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
		<td  align="left">&nbsp; 
		 <SELECT name="disp_location" id="disp_location" onChange="showtimings(this);">
		      <OPTION VALUE="">&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;</OPTION> 
	      </SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
		<td align="left" COLSPAN="3" class="label"><label id="working_hrs_txt" CLASS="label">&nbsp;</label>&nbsp;&nbsp;
		 <label id="from_time" name='from_time'><b>&nbsp</b></label>&nbsp;&nbsp;<label id="to_time" name='to_time'>&nbsp</label></td>	
	</tr>
	<tr>
		<td  class="label" ><fmt:message key="ePH.DispensedDateFrom.label" bundle="${ph_labels}"/></td> 
		<td COLSPAN="3" align="left" >&nbsp;&nbsp;<input type="text" size="12" maxlength=10 name="dt_from" id="dt_from" OnBlur='CheckDateT(this);chkDate(dt_from,dt_to);'><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_from');"  readonly >&nbsp;<img src="../../eCommon/images/mandatory.gif"   &nbsp;&nbsp;<label class="label"><fmt:message key="ePH.DispensedDateTo.label" bundle="${ph_labels}"/></label>&nbsp;<input type="text" size="10" name="dt_to" id="dt_to" maxlength=10 OnBlur='CheckDateT(this);chkDate(dt_from,dt_to);' readonly ><IMG SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="return showCalendar('dt_to');" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td><!--changed CheckDate to CheckDateT for Leap year calculation on 
24/02/2012 -->
	</tr>
	<TR>
		<TD COLSPAN="4">&nbsp;</TD>
	</TR>
	</table>
	
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHORDAFTOFFHRS"> 
	<INPUT TYPE="hidden" name="working_hr_from" id="working_hr_from" VALUE="">
	<INPUT TYPE="hidden" name="working_hr_to" id="working_hr_to" VALUE=""> 
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">
</form>

<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT1" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT1")%>">
	<input type="hidden" name="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" id="SQL_PH_PRINT_PRESCRIPTIONS_SELECT2" value="<%=PhRepository.getPhKeyValue("SQL_PH_PRINT_PRESCRIPTIONS_SELECT2")%>"> 
</body>
</html>

