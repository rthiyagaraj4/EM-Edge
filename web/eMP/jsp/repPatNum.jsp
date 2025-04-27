<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<%
	request.setCharacterEncoding("UTF-8");
	String p_module_id		= "MP" ;
	String p_report_id		= "MPBPTNUM" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>

<center>
	<form name="repRegnDistStat" id="repRegnDistStat" action="../../eCommon/jsp/report_options.jsp">
		<table>
			<tr>
				<td align="right" class="label">
					<fmt:message key="eMP.RegnDateFrom.label" bundle="${mp_labels}"/>
				</td>

				<td>
					&nbsp;&nbsp;
					<input type="text" name="p_from_regn_date" id="p_from_regn_date" size="10" maxlength="10">
				</td>

				<td align="right" class="label">
					<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				</td>

				<td>
					&nbsp;&nbsp;
					<input type="text" name="p_to_regn_date" id="p_to_regn_date" size="10" maxlength="10">
				</td>
			</tr>

			<tr>
				<td align="right" class="label">
					<fmt:message key="eMP.DistrictCodeFrom.label" bundle="${mp_labels}"/>
				</td>

				<td>
					&nbsp;&nbsp;
					<input type="text" name="p_from_patient_id" id="p_from_patient_id" size="6" maxlength="6">
				</td>

				<td align="right" class="label">
					<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				</td>

				<td>
					&nbsp;&nbsp;
					<input type="text" name="p_to_patient_id" id="p_to_patient_id" size="6" maxlength="6">
				</td>
			</tr>
		</table>
		<br>

		<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
		<input type="submit" value="Generate">
	</form>

</center>
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

