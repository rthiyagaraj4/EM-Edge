<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%!
	final String p_module_id		= "MP" ;
	final String p_report_id		= "MPBTOWN" ;

%>

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<html>

<HEAD>
<script src="../js/MPReportMasterList.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>

</HEAD>
<BODY onKeyDown = 'lockKey()'>
<form name="repTownList" id="repTownList" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<br>
<br>
<table width='80%' align='center' valign='top'>
		<td class='columnheader'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></td>
	<tr>
		<td width="80%" class="Border" >
				<table width='80%' cellPadding="3" cellSpacing="0" align='center'>
					<tr>
						<td width='35%'></td>
						<td width='25%' class="querydata"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
						<td width='40%' class="querydata"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>
						<td class='label'><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td>
						<td class='fields'><input type="text" name="p_from_regn_code" id="p_from_regn_code" size="6" maxlength="6"><input type='button' name='region' id='region' value='?' class='button' onclick='searchCode(this, p_from_regn_code)'>
						</td>
						<td class='fields'><input type="text" name="p_to_regn_code" id="p_to_regn_code" size="6" maxlength="6"><input type='button' name='region' id='region' value='?' class='button' onclick='searchCode(this, p_to_regn_code)'>
						</td>
				</tr>
				<tr>
						<td class='label'><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type="text" name="p_from_res_area_code" id="p_from_res_area_code" size="6" maxlength="6"><input type='button' name='area' id='area' value='?' class='button' onclick='searchCode(this, p_from_res_area_code)'>
						</td>
						<td class='fields'><input type="text" name="p_to_res_area_code" id="p_to_res_area_code" size="6" maxlength="6"><input type='button' name='area' id='area' value='?' class='button' onclick='searchCode(this, p_to_res_area_code)'>
						</td>
				</tr>
					<tr>
						<td class='label'><fmt:message key="Common.Town.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type="text" name="p_from_res_town_code" id="p_from_res_town_code" size="6" maxlength="6"><input type='button' name='town' id='town' value='?' class='button' onclick='searchCode(this, p_from_res_town_code)'>
						</td>
						<td class='fields'><input type="text" name="p_to_res_town_code" id="p_to_res_town_code" size="6" maxlength="6"><input type='button' name='town' id='town' value='?' class='button' onclick='searchCode(this, p_to_res_town_code)'>
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
								<option value="3"><fmt:message key="eMP.Regioncode.label" bundle="${mp_labels}"/>
								<option value="4"><fmt:message key="eMP.RegionDesc.label" bundle="${mp_labels}"/>
								</select>
						</td>
					</tr>
					<tr>
						<td > </td>
						<td class='fields'><select name='p_order_by_2' id='p_order_by_2'>
								<option value="1"><fmt:message key="Common.AreaCode.label" bundle="${common_labels}"/>
								<option value="2"><fmt:message key="eMP.AreaDesc.label" bundle="${mp_labels}"/>
							</select>
						</td>
					</tr>
					<tr>
						<td > </td>
						<td class='fields'><select name='p_order_by_3' id='p_order_by_3'>
						<option value="5"><fmt:message key="Common.TownCode.label" bundle="${common_labels}"/>
						<option value="6"><fmt:message key="eMP.TownDesc.label" bundle="${mp_labels}"/>
						</select>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td>&nbsp;</td>
					</tr>
				</tr>
		</table>
	</td>
</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= session.getValue( "facility_id" ) %>">
<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=  session.getValue( "login_user" ) %>">
<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
</form>

</BODY>
</HTML>

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

