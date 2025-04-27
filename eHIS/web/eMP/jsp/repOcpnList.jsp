<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%!
	final String p_module_id		= "MP" ;
	final String p_report_id		= "MPBOCPN" ;

%>
<% 
request.setCharacterEncoding("UTF-8");
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<html>

<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../js/MPReportMasterList.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<!-- <body onLoad="check(this)">-->
<body onKeyDown = 'lockKey()'>
<br>
<br>
<form name="repOcpnList" id="repOcpnList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='80%' align='center' valign='top'>

		<td class='columnheader'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
	<tr>
		<td width="100%" class="Border" >
				<table width='80%' cellPadding="3" cellSpacing="0" align='center'>
					<tr>
						<td width="35%">&nbsp;</td>
						<td width="20%" class="querydata"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td width="40%" class="querydata"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td class='label' ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
						<td class='fields'><input type=text  name='p_from_occpn_class_code' id='p_from_occpn_class_code' size="2" maxlength="2"><input type='button' name='occpnclass' id='occpnclass' value='?' class='button' onclick='searchCode(this, p_from_occpn_class_code)'>

						 </td>
						 <td  class='fields'><input type=text  name='p_to_occpn_class_code' id='p_to_occpn_class_code' size="2" maxlength="2"><input type='button' name='occpnclass' id='occpnclass' value='?' class='button' onclick='searchCode(this, p_to_occpn_class_code)'>

						  </td>
						</tr>
						<tr>
							<td class='label'><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/></td>
							<td class='fields'><input type=text  name='p_from_occpn_code' id='p_from_occpn_code' size="6" maxlength="6"><input type='button' name='occupation' id='occupation' value='?' class='button' onclick='searchCode(this, p_from_occpn_code)'>
							</td>
							 <td class='fields'><input type=text  name='p_to_occpn_code' id='p_to_occpn_code' size="6" maxlength="6"><input type='button' name='occupation' id='occupation' value='?' class='button' onclick='searchCode(this, p_to_occpn_code)'>

							</td>
						</tr>
						<tr>
							<td class='label'><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
							<td class='fields'><select name='p_report_nature' id='p_report_nature'>
							<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
							<option value="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
							<option value="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/>
							</select>
							</td>
						</tr>
						<tr>
							<td class='label'><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
							<td class='fields'><select name='p_order_by_1' id='p_order_by_1'>
							<option value="1" ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></Option>
							<option value="2"><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></Option>
							</select>
							</td>
						</tr>
						<tr>
							<td></td>
							<td class='fields'><select name='p_order_by_2' id='p_order_by_2'>
							<option value="6"><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></Option>
							<option value="7"><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></Option>
							</select>
							</td>
						</tr>
						<tr>
								<td>&nbsp;</td>
								<Td>&nbsp;</td>
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

