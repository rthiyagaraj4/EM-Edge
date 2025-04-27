<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "eXH.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" %>
<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%@ include file="../../eXH/jsp/CommonInclude.jsp"%>
<HEAD> 
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
%>

<c:if test="${param.mode == 'I'}">
	<c:set var="path" value="../"/>
</c:if>

<link rel='StyleSheet' href='${path}../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="${path}../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="${path}../eXH/js/Validate.js" ></script>
<script language="javascript" src="${path}../eCommon/js/common.js" ></script>
<script Language="JavaScript" src="${path}../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="${path}../eCommon/js/jquery-3.6.3.jss"></script>
<script language="javascript" src="${path}../eXH/js/QMSRDCounterSetup.js"></script>
<script src='${path}../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="init()">
<FORM ID="counterInfo" name="counterInfo" id="counterInfo" METHOD="post" TARGET="messageFrame" ACTION='${path}../servlet/eXH.QMSRDCounterSetupServlet'>

<c:if test="${mode == 'U'}">
	<c:set var="disable" value="DISABLED"/>
</c:if>

<TABLE CELLSPACING="0" CELLPADDING="3" ALIGN="center">
<TR>
	<TD CLASS=label><fmt:message key="Common.Section.label" bundle="${common_labels}"/></TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="sectionDesc" id="sectionDesc" ID="sectionDesc" onBlur="callLookup(this, 'searchSection()')" VALUE="${counterInfo['sectionDesc']}" ${disable}>
		<INPUT TYPE="button" onClick="searchSection()" VALUE="?" ${disable}>
		<INPUT TYPE="hidden" name="sectionCode" id="sectionCode" ID="sectionCode" VALUE="${counterInfo['sectionCode']}" ${disable}>
		<IMG SRC='${path}../eCommon/images/mandatory.gif'>
	</TD>
</TR>
<TR>
	<TD CLASS="label"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="facilityName" id="facilityName" ID="facilityName" SIZE="35" onBlur="callLookup(this, 'searchFacility()')" VALUE="${counterInfo['facilityName']}" ${disable}>
		<INPUT TYPE="button" onClick="searchFacility()" VALUE="?" ${disable}>
		<INPUT TYPE="hidden" name="facilityID" id="facilityID" ID="facilityID" VALUE="${counterInfo['facilityID']}" ${disable}>
		<IMG SRC='${path}../eCommon/images/mandatory.gif'>
	</TD>
</TR>
<TR>
	<TD CLASS="label"><fmt:message key="eXH.STUDY_LOCATION.Label" bundle="${xh_labels}"/></TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="studyLocationDesc" id="studyLocationDesc" ID="studyLocationDesc" onBlur="callLookup(this, 'searchStudyLocation()')" VALUE="${counterInfo['studyLocationDesc']}" DISABLED>
		<INPUT TYPE="button" ID="studyLocationLookupButton" onClick="searchStudyLocation()" VALUE="?" DISABLED>
		<INPUT TYPE="hidden" name="studyLocation" id="studyLocation" ID="studyLocation" VALUE="${counterInfo['studyLocation']}" ${disable}>
		<IMG SRC='${path}../eCommon/images/mandatory.gif'>
	</TD>
</TR>
<TR>
	<TD CLASS="label"><fmt:message key="eXH.QMS_SERVICE_ID.Label" bundle="${xh_labels}"/></TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="serviceNo" id="serviceNo" ID="serviceNo" VALUE="${counterInfo['serviceNo']}">
		<IMG SRC='${path}../eCommon/images/mandatory.gif'>
	</TD>
</TR>
<TR>
	<TD CLASS="label"><fmt:message key="eXH.COUNTER_NAME.Label" bundle="${xh_labels}"/></TD>
	<TD CLASS="fields">
		<INPUT TYPE="text" name="counterName" id="counterName" ID="counterName" VALUE="${counterInfo['counterName']}">
		<IMG SRC='${path}../eCommon/images/mandatory.gif'>
	</TD>
</TR>
</TABLE>

<INPUT TYPE='hidden' name='mode' id='mode' ID='mode' VALUE="${mode}">
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType' VALUE="SAVE">
<c:if test="${mode == 'U'}">
<INPUT TYPE='hidden' name="sectionCode" id="sectionCode" ID="sectionCode" VALUE="${counterInfo['sectionCode']}">
<INPUT TYPE='hidden' name="studyLocation" id="studyLocation" ID="studyLocation" VALUE="${counterInfo['studyLocation']}">
<INPUT TYPE='hidden' name="facilityID" id="facilityID" ID="facilityID" VALUE="${counterInfo['facilityID']}">
</c:if>
</FORM>
</BODY>
</HTML>

