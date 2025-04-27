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
	<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/PHmessages.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  onload="document.formPHRepATClassification.p_from_atcl1.focus();">
	<BR>
	<FORM name="formPHRepATClassification" id="formPHRepATClassification" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
	<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
	<TH COLSPAN="3"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
	<TR>
		<TD WIDTH="30%">&nbsp;</TD>
		<TD CLASS="label" WIDTH="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
		<TD CLASS="label" WIDTH="45%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
	</TR>
	<TR>
		<TD WIDTH="30%" CLASS="label">
		<fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;1</TD>
		<TD  WIDTH="25%"><INPUT TYPE="text" name="p_from_atcl1" id="p_from_atcl1" SIZE="8" MAXLENGTH="6" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" TABINDEX="1" ><INPUT TYPE="button" name="narrationFrom" id="narrationFrom" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'ATC Level1', p_from_atcl1)" TABINDEX="2"></TD>
		<TD WIDTH="45%"><INPUT TYPE="text" name="p_to_atcl1" id="p_to_atcl1" SIZE="8" MAXLENGTH="6" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" TABINDEX="3" ><INPUT TYPE="button" name="narrationTo" id="narrationTo" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'ATC Level1', p_to_atcl1)" TABINDEX="4"></TD>
		
	</TR>
	<TR>
		<TD COLSPAN="3">&nbsp;</TD>
	</TR>
	<TR>
		<TD  WIDTH="30%" CLASS="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;2</TD>
		<TD  WIDTH="25%"><INPUT TYPE="text" name="p_from_atcl2" id="p_from_atcl2" SIZE="8" MAXLENGTH="6" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" TABINDEX="5" ><INPUT TYPE="button" name="narrationFrom" id="narrationFrom" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'ATC Level2', p_from_atcl2)" TABINDEX="6"></TD>
		<TD  WIDTH="45%"><INPUT TYPE="text" name="p_to_atcl2" id="p_to_atcl2" SIZE="8" MAXLENGTH="6" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" TABINDEX="7" ><INPUT TYPE="button" name="narrationTo" id="narrationTo" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'ATC Level2', p_to_atcl2)" TABINDEX="8"></TD>
			</TR>
	<TR>
		<TD COLSPAN="3">&nbsp;</TD>
	</TR>
	<TR>
		<TD  WIDTH="30%" CLASS="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;3</TD>
		<TD  WIDTH="25%"><INPUT TYPE="text" name="p_from_atcl3" id="p_from_atcl3" SIZE="8" MAXLENGTH="6" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" TABINDEX="9" ><INPUT TYPE="button" name="narrationFrom" id="narrationFrom" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'ATC Level3', p_from_atcl3)" TABINDEX="10"></TD>
		<TD  WIDTH="45%"><INPUT TYPE="text" name="p_to_atcl3" id="p_to_atcl3" SIZE="8" MAXLENGTH="6" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" TABINDEX="11" ><INPUT TYPE="button" name="narrationTo" id="narrationTo" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'ATC Level3', p_to_atcl3)" TABINDEX="12"></TD>
	
	</TR>
	<TR>
		<TD COLSPAN="3">&nbsp;</TD>
	</TR>
	<TR>
		<TD  WIDTH="30%" CLASS="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;4</TD>
		<TD  WIDTH="25%"><INPUT TYPE="text" name="p_from_atcl4" id="p_from_atcl4" SIZE="8" MAXLENGTH="6" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" TABINDEX="13" ><INPUT TYPE="button" name="narrationFrom" id="narrationFrom" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'ATC Level4', p_from_atcl4)" TABINDEX="14"></TD>
		<TD WIDTH="45%"><INPUT TYPE="text" name="p_to_atcl4" id="p_to_atcl4" SIZE="8" MAXLENGTH="6" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" TABINDEX="15" ><INPUT TYPE="button" name="narrationTo" id="narrationTo" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'ATC Level4', p_to_atcl4)" TABINDEX="16"></TD>
		
	</TR>
	<TR>
		<TD COLSPAN="3">&nbsp;</TD>
	</TR>
	<TR>
		<TD  WIDTH="30%" CLASS="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;5</TD>
		<TD  WIDTH="25%"><INPUT TYPE="text" name="p_from_atcl5" id="p_from_atcl5" SIZE="8" MAXLENGTH="6" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" TABINDEX="17" ><INPUT TYPE="button" name="narrationFrom" id="narrationFrom" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'ATC Level5', p_from_atcl5)" TABINDEX="18"></TD>
		<TD WIDTH="45%"><INPUT TYPE="text" name="p_to_atcl5" id="p_to_atcl5" SIZE="8" MAXLENGTH="6" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" TABINDEX="19" ><INPUT TYPE="button" name="narrationTo" id="narrationTo" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'ATC Level5', p_to_atcl5)" TABINDEX="20"></TD>
		
	</TR>
	<TR>
		<TD COLSPAN="3">&nbsp;</TD>
	</TR>
	<TR>
		<TD WIDTH="25%" CLASS="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;</TD>
		<TD COLSPAN="2" >
			<SELECT name="p_orderby" id="p_orderby" TABINDEX="21">
				<OPTION VALUE="1"><fmt:message key="ePH.Level1Code.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="2"><fmt:message key="ePH.Level1Description.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="3"><fmt:message key="ePH.Level2Code.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="4"><fmt:message key="ePH.Level2Description.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="5"><fmt:message key="ePH.Level3Code.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="6"><fmt:message key="ePH.Level3Description.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="7"><fmt:message key="ePH.Level4Code.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="8"><fmt:message key="ePH.Level4Description.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="9"><fmt:message key="ePH.Level5Code.label" bundle="${ph_labels}"/></OPTION>
				<OPTION VALUE="10"><fmt:message key="ePH.Level5Description.label" bundle="${ph_labels}"/></OPTION>
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
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="PHBATCCL">
	<INPUT TYPE="hidden" name="p_language_id" id="p_language_id" VALUE="<%=locale%>">

</FORM>

<INPUT TYPE="hidden" name="SQL_PH_REPORTS_ATC1_LOOKUP" id="SQL_PH_REPORTS_ATC1_LOOKUP" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_REPORTS_ATC1_LOOKUP" ) %>">

<INPUT TYPE="hidden" name="SQL_PH_REPORTS_ATC2_LOOKUP" id="SQL_PH_REPORTS_ATC2_LOOKUP" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_REPORTS_ATC2_LOOKUP" ) %>">

<INPUT TYPE="hidden" name="SQL_PH_REPORTS_ATC3_LOOKUP" id="SQL_PH_REPORTS_ATC3_LOOKUP" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_REPORTS_ATC3_LOOKUP" ) %>">

<INPUT TYPE="hidden" name="SQL_PH_REPORTS_ATC4_LOOKUP" id="SQL_PH_REPORTS_ATC4_LOOKUP" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_REPORTS_ATC4_LOOKUP" ) %>">

<INPUT TYPE="hidden" name="SQL_PH_REPORTS_ATC5_LOOKUP" id="SQL_PH_REPORTS_ATC5_LOOKUP" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_REPORTS_ATC5_LOOKUP" ) %>">



</BODY>
</HTML>

