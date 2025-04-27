<!DOCTYPE html>
<%@ page  import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>              
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
<%
	String locale	= (String)session.getAttribute("LOCALE");
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String surgicalaccessories_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SurgicalAccessories.Label","ot_labels");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT> 
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT> 
<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT> 
<script language='javascript' src='../../eOT/js/MasterReports.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.Mrepsurgicalaccessoriesform.param1.focus();">
	<BR>
	<FORM name="Mrepsurgicalaccessoriesform" id="Mrepsurgicalaccessoriesform" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">

 
		<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TH COLSPAN="3" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR>
			<TD WIDTH="30%">&nbsp;</TD>
			<TD CLASS="label" ALIGN="left" WIDTH="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
			<TD CLASS="label" ALIGN="left" WIDTH="45%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
		</TR>
		<TR>
			<TD ALIGN="left" WIDTH="30%" CLASS="label"><fmt:message key="eOT.SurgicalAccessories.Label" bundle="${ot_labels}"/>&nbsp;</TD>
			<TD ALIGN="left" WIDTH="25%">
<!--  			<INPUT TYPE=text name="from_surgicalaccessories" id="from_surgicalaccessories" SIZE="8" maxlength="8" onBlur="ChangeUpperCase(this)" onKeyPress="return 			CheckForSpecChars(event)" tabIndex="1" >
			<INPUT TYPE="button" name="narrationFrom" id="narrationFrom" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'SURGICALACCESSORIES','<%=surgicalaccessories_title%>', document.forms[0].from_surgicalaccessories)">  -->
<!-- 			<select name="appl_desc" id="appl_desc" db_value="<%//=applicability%>" onchange='chkSpecificOperation(this);'> -->
 			    <select name="param1" id="param1">
				<option value='AOPR'>
					<fmt:message key="Common.AllOperations.label" bundle="${common_labels}"/>
				</option>
				<option value='SSPL'>
					<fmt:message key="Common.SpecificSpecialty.label" bundle="${common_labels}"/>
				</option>
				<option value='SCAT'>
					<fmt:message key="eOT.SpecificOperationCategoryWithinSpeciality.Label" bundle="${ot_labels}"/>
				</option>
				<option value='SSUB'>
					<fmt:message key="eOT.SpecificOperationSubCategoryWithinSpeciality.Label" bundle="${ot_labels}"/>
				</option>
				<option value='SOPR'>
					<fmt:message key="Common.SpecificOperation.label" bundle="${common_labels}"/>
				</option>
			</select> 
			</TD>
			<TD ALIGN="left" WIDTH="45%">
<!--  			<INPUT TYPE=text name="to_surgicalaccessories" id="to_surgicalaccessories" SIZE="8" maxlength="8" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" tabIndex="2" >
			<INPUT TYPE="button" name="narrationTo" id="narrationTo" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'SURGICALACCESSORIES','<%=surgicalaccessories_title%>', document.forms[0].to_surgicalaccessories)">  -->
 			    <select name="param2" id="param2">
				<option value='AOPR'>
					<fmt:message key="Common.AllOperations.label" bundle="${common_labels}"/>
				</option>
				<option value='SSPL'>
					<fmt:message key="Common.SpecificSpecialty.label" bundle="${common_labels}"/>
				</option>
				<option value='SCAT'>
					<fmt:message key="eOT.SpecificOperationCategoryWithinSpeciality.Label" bundle="${ot_labels}"/>
				</option>
				<option value='SSUB'>
					<fmt:message key="eOT.SpecificOperationSubCategoryWithinSpeciality.Label" bundle="${ot_labels}"/>
				</option>
				<option value='SOPR'>
					<fmt:message key="Common.SpecificOperation.label" bundle="${common_labels}"/>
				</option>
			</select> 


			</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>
		<TR><!-- Commented by rajesh according to vishwa's instruction for SPR-6585 on 20/01/09 -->
			<!-- <TD ALIGN="right" WIDTH="25%" CLASS="label"><fmt:message key="eOT.PrintOption.Label" bundle="${ot_labels}"/> &nbsp;</TD>
			<TD COLSPAN="2" ALIGN="left">
			<SELECT name="param3" id="param3" tabIndex="3">
				<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="A"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="S"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></OPTION>
			</SELECT>
			</TD> -->
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>
	</TABLE>

	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="module_id" id="module_id" VALUE="OT">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="OT">
	<INPUT TYPE="hidden" name="report_id" id="report_id" VALUE="OTRSURAC">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="OTRSURAC">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">

</FORM>
</BODY>
</HTML>





