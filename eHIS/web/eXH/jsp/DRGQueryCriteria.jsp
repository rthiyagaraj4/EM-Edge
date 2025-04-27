<!DOCTYPE html>
<html>
<%@ page import="webbeans.eCommon.ConnectionManager,java.sql.*"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<head>

<%
String locale = ((String)session.getAttribute("LOCALE"));
request.setCharacterEncoding("UTF-8");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eXH/js/drginterface.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>													  

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="initParams();">
<FORM name="drg_query_form" id="drg_query_form" target="drg_results_frame" method="post" ACTION="../../servlet/eXB.DRGCalculationServlet">

<TABLE cellspacing='0' cellpadding='0' align=center width="100%">

<TR><TD class="label">&nbsp;</TD></TR>
<!-- <TR><TD class="HEADER"><CENTER><FONT size="4"><fmt:message key="eMR.PatientInformation.label" bundle="${mr_labels}"/></CENTER></TD></TR> -->
<TR><TD class="HEADER"><CENTER><FONT size="4">Patient Information</CENTER></TD></TR>
<TR><TD class="label">&nbsp;</TD></TR>

</TABLE>

<TABLE cellspacing='0' cellpadding='0' width='100%'>
<TR>
	<TD class="label"><fmt:message key="Common.Application.label" bundle="${common_labels}"/></TD>
	<TD class="fields">
		<INPUT TYPE="hidden" name="applicationID" id="applicationID" id="applicationID">
		<INPUT TYPE="text" name="appName" id="appName" id="appName" MAXLENGTH="540">
		<INPUT TYPE="BUTTON" CLASS="BUTTON" name="appLU" id="appLU" ID="appLU" VALUE="?" onClick="getApplicationInfo();">
		<img src='../../eCommon/images/mandatory.gif' align=middle></TD>	
	<TD></TD>
</TR>
<TR>
	<TD class="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></TD>
	<TD class="fields">
		<INPUT TYPE="hidden" name="facilityID" id="facilityID" id="facilityID">
		<INPUT TYPE="text" name="facilityName" id="facilityName" id="facilityName" MAXLENGTH="30">
		<INPUT TYPE="BUTTON" CLASS="BUTTON" name="facilityLU" id="facilityLU" ID="facilityLU" VALUE="?" onClick="getFacility();">
		<img src='../../eCommon/images/mandatory.gif' align=middle></TD>	
	<TD></TD>
</TR>
<TR>
	<TD class="label"><fmt:message key="Common.EventType.label" bundle="${common_labels}"/></TD>
	<TD class="fields">
		<INPUT TYPE="hidden" name="eventType" id="eventType" id="eventType">
		<INPUT TYPE="text" name="eventName" id="eventName" id="eventName" MAXLENGTH="240" DISABLED>
		<INPUT TYPE="BUTTON" CLASS="BUTTON" name="eventLU" id="eventLU" ID="eventLU" VALUE="?" DISABLED onClick="getEventTypeInfo();">
		<img src='../../eCommon/images/mandatory.gif' align=middle></TD>	
	<TD></TD>
</TR>
<TR>
	<TD class="label"><fmt:message key="Common.patient.label" bundle="${common_labels}"/></TD>	
	<TD class="fields">
	<INPUT TYPE="hidden" name="patientID" id="patientID" id="patientID" MAXLENGTH="20">
	<INPUT TYPE="text" name="patientName" id="patientName" id="patientName" MAXLENGTH="100">
	<INPUT TYPE="BUTTON" CLASS="BUTTON" name="patientLU" id="patientLU" ID="patientLU" VALUE="?" onClick="searchPatientId();">
	<img src='../../eCommon/images/mandatory.gif' align=middle></TD>
	<TD></TD>
</TR>
<TR>
	<TD class="label"><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></TD>
	<TD class="fields">
	<INPUT TYPE="text" name="encounterID" id="encounterID" id="encounterID" MAXLENGTH="12" DISABLED onBlur="CheckNum(this);">
	<INPUT TYPE="BUTTON" CLASS="BUTTON" name="encounterLU" id="encounterLU" ID="encounterLU" VALUE="?" DISABLED onClick="getEncounter();">
	<img src='../../eCommon/images/mandatory.gif' align=middle></TD>
	<TD></TD>
</TR>
<TR>
	<TD class="label" STYLE="display:none"><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></TD>	
	<TD class="fields" STYLE="display:none"><INPUT TYPE="text" name="profileID" id="profileID" id="profileID" value="SRRDRG1" MAXLENGTH="15"><img src='../../eCommon/images/mandatory.gif' align=middle></TD>	
	<TD></TD>
	<TD></TD>
	<TD>
	<TABLE align="right">
	<TR><TD CLASS="LABEL"><fmt:message key="Common.Message.label" bundle="${common_labels}"/></TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="msg_id" id="msg_id" id="msg_id">
	<!--	<INPUT TYPE="button" CLASS="BUTTON" VALUE='<fmt:message key="eMR.CalculateDRG.label" bundle="${mr_labels}"/>' onClick="getMsgData();"> -->
		<INPUT TYPE="button" CLASS="BUTTON" VALUE='Calculate DRG' onClick="getMsgData();">
	</TD></TR>
	</TABLE>
	</TD>
</TR>
<TR ALIGN="right">	
	<TD></TD>
	<TD>
		<INPUT CLASS="BUTTON" TYPE='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>'>
		<INPUT CLASS="BUTTON" TYPE="button" VALUE='<fmt:message key="Common.Submit.label" bundle="${common_labels}"/>' onClick="refFrames();">
	</TD>	
	<TD></TD>
</TR>
</TABLE>

<INPUT TYPE="hidden" name="req_mode" id="req_mode" VALUE="">
<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">

</FORM>
</BODY>
</html>

