<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	String p_module_id		= "AM" ;
	String p_report_id		= "AMBFQSCH" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>
<HEAD>
<TITLE></TITLE>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../js/SearchPopup.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY onLoad="FocusFirstElement()" onMouseDown="CodeArrest();" onKeyDown = "lockKey();">
<br>
<br>
<form name="repFrequencyScheduleForm" id="repFrequencyScheduleForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

				<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

					<tr>
						<td align="center" width="35%">&nbsp;</td>
						<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>

					<tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.FrequencyCode.label" bundle="${common_labels}"/>	&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_code' id='p_fm_code' size="4" maxlength="4" align="center"><input type='button' name='frequency schedule' id='frequency schedule' value='?' class='button' onclick='searchCode(this, p_fm_code)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_fm_code' id='p_to_fm_code' size="4" maxlength="4" align="center"><input type='button' name='frequency schedule' id='frequency schedule' value='?' class='button' onclick='searchCode(this, p_to_fm_code)'>
						</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
				<tr>
					<td align='right' width='30%' class="label"><fmt:message key="eAM.AdminFacilityID.label" bundle="${am_labels}"/>&nbsp;</td>
						<td width='20%'  ><input type=text  name='p_fm_status' id='p_fm_status' size="2" maxlength="2" align="center"><input type='button' name='freqscheduleid' id='freqscheduleid' value='?' class='button' onclick='searchCode(this, p_fm_status)'>
						</td>
						<td width='40%'> <input type=text  name='p_to_status' id='p_to_status' size="2" maxlength="2" align="center"><input type='button' name='freqscheduleid' id='freqscheduleid' value='?' class='button' onclick='searchCode(this, p_to_status)'>
						</td>
				</tr>
				
			
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
</form>
</BODY>
</HTML>

