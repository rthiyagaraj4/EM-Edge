<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*"  contentType="text/html;charset=UTF-8" %>


<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
%>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
  <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
  <Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
  <script src="../../eCommon/js/common.js" language="javascript"></script>
  <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
   <script src="../../eMR/js/MRReports.js" language="javascript"></script>
   <script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>

<%  
    String p_module_id      = "MR" ;
    String p_report_id      = "MRBCPCIL" ;
    String p_facility_id    = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
%>
<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="Focusing('p_fr_locn_code')">
	<br>
	<br>
	<form name="repCurrentInpatientListBCP_Form" id="repCurrentInpatientListBCP_Form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<table width='80%' align='center' valign='top'>
		<th align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
		<tr>
			<td width="100%" class="Border" align='center'>
				<table width='80%' cellPadding="0" cellSpacing="0"  align='center'>

					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

					<tr>
						<td align="center" width="30%">&nbsp;</td>
						<td class='querydata' width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class='querydata' width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					
					 <tr>
						<td align='left' width='30%' class="label"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
						<td width='30%'  ><input type=text  name='p_fr_locn_code' id='p_fr_locn_code' size="4" maxlength="4" onBlur='if(this.value != "") searchCoderepAppointmentsforopdBCP_Form(locationcode,this)' align="center"><input type='button' name='locationcode' id='locationcode' value='?' class='button' onclick='if (document.getElementById("p_fr_locn_code").value == "") searchCoderepAppointmentsforopdBCP_Form(this, p_fr_locn_code)'></td>
						<td width='40%'> <input type=text  name='p_to_locn_code' id='p_to_locn_code' size="4" maxlength="4" onBlur='if(this.value != "") searchCoderepAppointmentsforopdBCP_Form(locationcode,this)' align="center"><input type='button' name='locationcode' id='locationcode' value='?' class='button' onclick='if (document.getElementById("p_to_locn_code").value == "")searchCoderepAppointmentsforopdBCP_Form(this, p_to_locn_code)'></td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>

					

				</table>
			</td>
		</tr>
	</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
	</form>
	</BODY>
	</html>
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

