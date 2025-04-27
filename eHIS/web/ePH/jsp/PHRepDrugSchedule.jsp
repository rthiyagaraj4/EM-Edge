<!DOCTYPE html>
 <%-- saved on 03/11/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	//
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHmessages.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  onload="document.formPHRepDrugSchedule.p_from_schid.focus();">
<BR>
<FORM name="formPHRepDrugSchedule" id="formPHRepDrugSchedule" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
	<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TH COLSPAN="3" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR>
			<TD WIDTH="30%">&nbsp;</TD>
			<TD CLASS="label" ALIGN="left" WIDTH="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
			<TD CLASS="label" ALIGN="left" WIDTH="45%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
		</TR>
		<TR>
			<TD ALIGN="right" WIDTH="30%" CLASS="label"><fmt:message key="ePH.DrugScheduleID.label" bundle="${ph_labels}"/></TD>
			<TD ALIGN="left" WIDTH="25%"><INPUT TYPE=text name="p_from_schid" id="p_from_schid" SIZE="8" maxlength="8" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" tabIndex="1"><INPUT TYPE="button" name="narrationFrom" id="narrationFrom" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'Drug Schedule', p_from_schid)"></TD>
			<TD ALIGN="left" WIDTH="45%"><INPUT TYPE=text name="p_to_schid" id="p_to_schid" SIZE="8" maxlength="8" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" tabIndex="2"><INPUT TYPE="button" name="narrationTo" id="narrationTo" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'Drug Schedule', p_to_schid)"></TD>
		
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>
		<TR>
			<TD ALIGN="right" WIDTH="25%" CLASS="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/>&nbsp;</TD>
			<TD COLSPAN="2" ALIGN="left">
				<SELECT name="p_effstat" id="p_effstat" tabIndex="3">
					<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></OPTION>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>
		<TR>
			<TD ALIGN="right" WIDTH="25%" CLASS="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;</TD>
			<TD COLSPAN="2" ALIGN="left">
				<SELECT name="p_orderby" id="p_orderby" tabIndex="3">
					<OPTION VALUE="1"><fmt:message key="ePH.ScheduleID.label" bundle="${ph_labels}"/></OPTION>
					<OPTION VALUE="2"><fmt:message key="ePH.ScheduleDescription.label" bundle="${ph_labels}"/></OPTION>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>
	</TABLE>

	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_user_name" id="p_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="PH">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHBDRSCH">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">

</FORM>

	<INPUT TYPE="hidden" name="SQL_PH_REPORTS_SCHED_LOOKUP" id="SQL_PH_REPORTS_SCHED_LOOKUP" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_REPORTS_SCHED_LOOKUP" ) %>">
</BODY>
</HTML>

