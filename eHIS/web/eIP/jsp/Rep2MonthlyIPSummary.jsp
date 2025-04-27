<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8"  %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBMBDCS" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
%>

<HEAD>
<TITLE></TITLE>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>	
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript">
	
		function setFirstDate()
		{
			var arr = document.Rep2MonthlyIPSummaryForm.p_trn_date.value.split("/");
			var yr = arr[1];
			document.Rep2MonthlyIPSummaryForm.p_first_date.value = "01/01/"+yr;
			document.Rep2MonthlyIPSummaryForm.p_first_month_year.value = "01/"+yr;
			document.Rep2MonthlyIPSummaryForm.p_curr_year.value = yr;
			return true;
		}
		
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2MonthlyIPSummaryForm" id="Rep2MonthlyIPSummaryForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr><td colspan='2'>&nbsp;</td></tr>
				<tr>
					<td align='right' width='30%' class="label" width='50%'  ><fmt:message key="eIP.CensusMonthYear.label" bundle="${ip_labels}"/>&nbsp;</td>
					<td width='50%'  >
						<input type=text id="census_date" name='p_trn_date' id='p_trn_date' size="7" maxlength="7" align="center" onblur='validDateObj(this,"MY",localeName);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('census_date','mm/y',null);">
						<img align='center' src='../../eMP/images/mandatory.gif'>
					</td>
				</tr>
				<tr><td colspan='2'>&nbsp;</td></tr>
		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
	<input type="hidden" name="p_first_date" id="p_first_date" 	value="">
	<input type="hidden" name="p_curr_year" id="p_curr_year" 	value="">
	<input type="hidden" name="p_first_month_year" id="p_first_month_year" 	value="">

	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
		
		
</form>
</BODY>
</HTML>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

