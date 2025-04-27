<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
String locale			= (String)session.getAttribute("LOCALE"); //Added by Suji Keerthi for MOHE-CRF-0038
	request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<table border='1' width='100%' bordercolor="black">			
		   <tr><td>
		   <div align='center'><img height ="12" src="../../eIP/images/BillPrepared.gif" align='left'><font size=2>&nbsp;<fmt:message key="eIP.DischargebillPrepared.label" bundle="${ip_labels}"/>&nbsp;</div>
		   </td></tr>
		   <%if(locale.equals("ar")){ //Added by Suji Keerthi for MOHE-CRF-0038%>
			<tr>
				<td class='IP_GreenButton' ><font size=2 >&nbsp;<fmt:message key="eIP.VacantNormalBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='IP_RedButton' ><font size=2>&nbsp;<fmt:message key="eIP.OccupiedNormalBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='IP_LGreenButton' ><font size=2>&nbsp;<fmt:message key="eIP.VacantPseudoBabyBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='IP_LPinkButton' ><font size=2>&nbsp;<fmt:message key="eIP.OccupiedPseudoBabyBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
			</tr>
            <%}else{ //Added by Suji Keerthi for MOHE-CRF-0038%>
			<tr>
				<td class='IP_GreenButton' ><font size=2 >&nbsp;<fmt:message key="Common.Vacant.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.NormalBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='IP_RedButton' ><font size=2>&nbsp;<fmt:message key="Common.Occupied.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.NormalBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='IP_LGreenButton' ><font size=2>&nbsp;<fmt:message key="Common.Vacant.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.PseudoBabyBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='IP_LPinkButton' ><font size=2>&nbsp;<fmt:message key="Common.Occupied.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.PseudoBabyBeds.label" bundle="${ip_labels}"/>&nbsp;</td>
			</tr>
            <%} //Added by Suji Keerthi for MOHE-CRF-0038%>
			<tr>
				<td class='IP_BrownButton' ><font size=2>&nbsp;<fmt:message key="Common.blocked.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.Nonoverrideable.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='IP_YellowButton' ><font size=2>&nbsp;<fmt:message key="Common.blocked.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.Overrideable.label" bundle="${ip_labels}"/>&nbsp;</td>
				<td class='IP_violetButton' ><font size=2>&nbsp;<fmt:message key="eIP.ReservedBeds.label" bundle="${ip_labels}"/></td>
				<td class='IP_newButton' ><font size=2>&nbsp;<fmt:message key="eIP.OcccupiedDeparted.label" bundle="${ip_labels}"/></td>
			</tr>
			<tr>
				<td class='IP_WoodButton' ><font size=2>&nbsp;<fmt:message key="eIP.BookedOverrideableConfirmed.label" bundle="${ip_labels}"/></td>
				<td class='IP_LWoodButton' ><font size=2>&nbsp;<fmt:message key="eIP.BookedOverrideableUnConfirmed.label" bundle="${ip_labels}"/></td>
				<td class='IP_PurpleButton' ><font size=2>&nbsp;<fmt:message key="eIP.BookedNonOverrideableConfirmed.label" bundle="${ip_labels}"/></td>
				<td class='IP_LpurpleButton' ><font size=2>&nbsp;<fmt:message key="eIP.BookedNonOverrideableUnConfirmed.label" bundle="${ip_labels}"/></td>
			</tr>
		</table>
	</body>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

