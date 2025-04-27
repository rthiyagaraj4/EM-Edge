<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>              
<% request.setCharacterEncoding("UTF-8");%>
<%@ page  import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
 <% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%
	String locale	= (String)session.getAttribute("LOCALE");
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   String implanttype_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ProsthesisImplantsTypes.Label","ot_labels");

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eOT/js/MasterReports.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.MRepImplantTypesForm.param1.focus();">
	<BR>
	<FORM name="MRepImplantTypesForm" id="MRepImplantTypesForm" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">

 
		<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TH COLSPAN="4" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR>
			<TD WIDTH="25%">&nbsp;</TD>
			<TD CLASS="label" ALIGN="left" WIDTH="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
			<TD CLASS="label" ALIGN="left" WIDTH="25%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
			<TD WIDTH="25%">&nbsp;</TD>
		</TR>
		<TR>
			<TD ALIGN="left" WIDTH="25%" CLASS="label">
				<fmt:message key="eOT.ProsthesisImplantsTypes.Label" bundle="${ot_labels}"/>
			</TD>
			<TD ALIGN="left" WIDTH="25%">
				<INPUT TYPE=text name="param1" id="param1" SIZE="8" maxlength="8" onBlur="if(this.value!='')searchCode(document.all, 'IMPLANTTYPES','<%=implanttype_title%>', document.forms[0].param1); else this.value='' " onKeyPress="return CheckForSpecChars(event)" tabIndex="1" >
				<INPUT TYPE="button" name="implanttypeFrom" id="implanttypeFrom" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'IMPLANTTYPES','<%=implanttype_title%>', document.forms[0].param1)">
			</TD>
			<TD ALIGN="left" WIDTH="25%">
				<INPUT TYPE=text name="param2" id="param2" SIZE="8" maxlength="8" onBlur="if(this.value!='')searchCode(document.all, 'IMPLANTTYPES','<%=implanttype_title%>', document.forms[0].param2); else this.value='' " onKeyPress="return CheckForSpecChars(event)" tabIndex="2" >
				<INPUT TYPE="button" name="implanttypeTo" id="implanttypeTo" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'IMPLANTTYPES','<%=implanttype_title%>', document.forms[0].param2)">
			</TD>
			<TD WIDTH="25%">&nbsp;</TD>
		</TR>
		<TR>
			<TD COLSPAN="4">&nbsp;</TD>
		</TR>
		<TR>
			<TD COLSPAN="4">&nbsp;</TD>
		</TR>
		<TR>
			<TD ALIGN="left" WIDTH="25%" CLASS="label"><fmt:message key="eOT.PrintOption.Label" bundle="${ot_labels}"/> &nbsp;</TD>
			<TD ALIGN="left">
			<SELECT name="printoption" id="printoption" tabIndex="3">
				<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="A"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="S"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></OPTION>
			</SELECT>
			</TD>
			<TD class='label'>
			<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
			</TD>
			<TD>
			<SELECT name="p_order_by" id="p_order_by" tabIndex="4">
				<OPTION VALUE="D" selected><fmt:message key="Common.description.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="C"><fmt:message key="Common.code.label" bundle="${common_labels}"/></OPTION>
			</SELECT>
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="4">&nbsp;</TD>
		</TR>
	</TABLE>

	<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="module_id" id="module_id" VALUE="OT">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="OT">
	<INPUT TYPE="hidden" name="report_id" id="report_id" VALUE="OTCPROTT">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="OTCPROTT">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
	
</FORM>
</BODY>
</HTML>





