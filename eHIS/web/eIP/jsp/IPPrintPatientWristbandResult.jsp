<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
request.setCharacterEncoding("UTF-8");
String p_facility_id		= (String) session.getValue( "facility_id" );
String p_user_name		= (String) session.getValue( "login_user" );
String p_locale		= (String) session.getValue( "LOCALE" );
String p_module_id		= "IP" ;
 %>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eIP/js/IPPrintPatientWristband.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	
</head>
<%
	String facility_id	=(String)session.getValue("facility_id");
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String encounter_id	= checkForNull(request.getParameter("encounter_id"));
	String location_desc	= checkForNull(request.getParameter("location_desc"));	
%>

 <jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="Facility_Id" value="<%=facility_id%>"/>
		<jsp:param name="Patient_ID" value="<%=patient_id%>"/>
		<jsp:param name="EncounterId" value="<%=encounter_id%>"/>
</jsp:include>

<body>
<form name="IPPrintPatientWristbandResult_form" id="IPPrintPatientWristbandResult_form"  action="../../eIP/jsp/IPPrintPatientWristbandReport.jsp" target="messageFrame">
<table cellpadding='0' cellspacing='0' border='1' width='100%' align='center' bordercolor='#D5E2E5'>
<tr>
	<th align='left' width='70%'><fmt:message key="Common.reportname.label" bundle="${common_labels}"/></th>
	<th width='15%'><fmt:message key="Common.copies.label" bundle="${common_labels}"/></th>
</tr>
<tr>
	<td>
		<table width='100%' border='0'>
			<tr>
				<td width='30%' nowrap><fmt:message key="eIP.PatientWristBandLabel.label" bundle="${ip_labels}"/></td>
				<td width='20%'><input type='checkbox' name='White' id='White' value='N' onclick='changeReportID(this)'><fmt:message key="eIP.White.label" bundle="${ip_labels}"/></td>
				<td width='20%'><input type='checkbox' name='Blue' id='Blue' value='N' onclick='changeReportID(this)'><fmt:message key="eIP.Blue.label" bundle="${ip_labels}"/></td>
				<td width='20%'><input type='checkbox' name='Red' id='Red' value='N' onclick='changeReportID(this)'><fmt:message key="eIP.Red.label" bundle="${ip_labels}"/></td>
				</td>
			</tr>
		</table>
	</td>
	<td><input type='textbox' name='copies' id='copies' value='1' size='2' maxlength='2'></td>
</tr>

</table>

<table align='center'>
<!-- <tr>&nbsp;</tr>
<tr>&nbsp;</tr> -->
<tr>&nbsp;</tr>
<tr>
		<td align ='right' ><INPUT TYPE="button" class="button" name="OK" id="OK" value = '<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick='apply_wristband()'></td>		
</tr>	
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
<input type="hidden" name="p_locale" id="p_locale"		value="<%= p_locale %>">
<input type="hidden" name="p_report_id" id="p_report_id"		value="">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
<input type="hidden" name="patient_id" id="patient_id"		value="<%= patient_id %>">
<input type="hidden" name="encounter_id" id="encounter_id"		value="<%= encounter_id %>">
<input type="hidden" name="location_desc" id="location_desc"		value="<%= location_desc %>">

</form>
</body>	
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

