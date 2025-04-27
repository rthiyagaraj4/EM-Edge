<!DOCTYPE html>
<!--Created by Thamizh selvi on 17th Jan 2019 against ML-MMOH-CRF-1233-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,com.ehis.util.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<TITLE><fmt:message key="eMR.Modification.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></TITLE>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src="../js/MedRecRequestButtons.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");

	String patientId			= checkForNull(request.getParameter("patientId"));
	String deliveredDate		= checkForNull(request.getParameter("deliveredDate"));
	String collectionMode		= checkForNull(request.getParameter("collectionMode"));
	String collectDate			= checkForNull(request.getParameter("collectDate"));
	String preparedDate			= checkForNull(request.getParameter("preparedDate"));
	String preparedPract		= checkForNull(request.getParameter("preparedPract"));
	String requestId			= checkForNull(request.getParameter("requestId"));
	String facilityId			= checkForNull(request.getParameter("facilityId"));
	String revisedCollectDate	= checkForNull(request.getParameter("revisedCollectDate"));
%>
<script>

</script>
</head>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='ModificationDetails' id='ModificationDetails' action='../../servlet/eMR.PrepareReportServlet' method='post' target='messageFrame'> 
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
	<tr>
		<td width="30%" class='label' valign="top"><fmt:message key="Common.reason.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMR.Modification.label" bundle="${mr_labels}"/></td>
		<td width="70%" class='fields'><textarea name='modifyReason' rows="4" cols="50" maxlength="100" onBlur = 'makeValidString(this);validateMaxLength(this);' onkeypress='return imposeMaxLength(this,100);'></textarea>&nbsp;<img align='top' src="../../eCommon/images/mandatory.gif"></td>
	</tr>
</table>
<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
	<tr>&nbsp;</tr>
	<tr>&nbsp;</tr>
	<tr>
		<td width="30%" class='label'>&nbsp;</td>
		<td width="35%" class='label'>&nbsp;</td>
		<td width="7%" class='label'>&nbsp;</td>
		<td width="28%" class="fields" nowrap><input type=button class='button' name = 'confirmBtn' style= "width: 50px;  height: 20px;" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.confirm.label","common_labels")%>' onClick='confirm(this);'>&nbsp;&nbsp;<input type=button class='button' name = 'closeBtn' style= "width: 50px;  height: 20px;" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='closeWin(this);'></td> 
	</tr>
</table>
<input type="hidden" name="call_function" id="call_function" value="MODIFICATION_REQUEST">
<input type="hidden" name="requestId" id="requestId" value="<%=requestId%>">
<input type="hidden" name="preparedDate" id="preparedDate" value="<%=preparedDate%>">
<input type="hidden" name="preparedPract" id="preparedPract" value="<%=preparedPract%>">
<input type="hidden" name="collectDate" id="collectDate" value="<%=collectDate%>">
<input type="hidden" name="collectionMode" id="collectionMode" value="<%=collectionMode%>">
<input type="hidden" name="deliveredDate" id="deliveredDate" value="<%=deliveredDate%>">
<input type="hidden" name="patientId" id="patientId" value="<%=patientId%>">
<input type="hidden" name="facilityId" id="facilityId" value="<%=facilityId%>">
<input type="hidden" name="revisedCollectDate" id="revisedCollectDate" value="<%=revisedCollectDate%>">

</form>
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

