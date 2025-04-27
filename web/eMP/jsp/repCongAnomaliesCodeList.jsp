<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%!
	final String p_module_id		= "MP" ;
	final String p_report_id		= "MPBCONANO" ;

%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../js/MPReportMasterList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY onKeyDown = 'lockKey()'>
<br>
<br>
<form name="repCongenitalAnomalies" id="repCongenitalAnomalies" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<td class='columnheader'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
	<tr>
		<td width="80%" class="Border" align="center">

				<table width='90%' cellPadding="3" cellSpacing="0"  align='center'>
					<tr>
						<td width="30%">&nbsp;</td>
						<td class="querydata"  width="40%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td class="querydata" width="30%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="eMP.CongenitalAnomalies.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type=text name='p_fm_cong_anomalies_code' id='p_fm_cong_anomalies_code' size=11 maxlength="10"><input type='button' name='congenitalanomalies' id='congenitalanomalies' value='?' class='button' onclick='searchCode(this, p_fm_cong_anomalies_code)'>
						</td>
						<td class='fields'><input type=text  name='p_to_cong_anomalies_code' id='p_to_cong_anomalies_code' size=11 maxlength="10"><input type='button' name='congenitalanomalies' id='congenitalanomalies' value='?' class='button' onclick='searchCode(this, p_to_cong_anomalies_code)'>

				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name='p_nature' id='p_nature'>
						<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
						<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name='p_order_by' id='p_order_by'>
						<option value='1'><fmt:message key="eMP.CongenitalAnomalies.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/>
						<option value='2'><fmt:message key="eMP.CongenitalAnomalies.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>
						</select>
					</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= session.getValue( "facility_id" ) %>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=  session.getValue( "login_user" ) %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>

</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

