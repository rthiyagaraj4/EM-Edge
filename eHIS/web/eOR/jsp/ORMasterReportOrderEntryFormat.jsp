<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.*, eOR.Common.*, eCommon.Common.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
<HTML>
<HEAD>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/OrMasterReport.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  onload="document.formOrRepOrderEntryFormat.from_order_entry_format.focus();">
<BR>
<FORM name="formOrRepOrderEntryFormat" id="formOrRepOrderEntryFormat" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">
	<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TH COLSPAN="3" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR>
			<TD WIDTH="30%">&nbsp;</TD>
			<TD CLASS="label" ALIGN="left" WIDTH="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
			<TD CLASS="label" ALIGN="left" WIDTH="45%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
		</TR>
		<TR>
			<TD ALIGN="right" WIDTH="30%" CLASS="label"><fmt:message key="eOR.OrderEntryFormat.label" bundle="${or_labels}"/> </TD>
			<TD ALIGN="left" WIDTH="25%">
			<INPUT TYPE=text name="from_order_entry_format" id="from_order_entry_format" SIZE="8" maxlength="8" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" tabIndex="1">
			<INPUT TYPE="button" name="from_button_order_entry_format" id="from_button_order_entry_format" VALUE="?" CLASS="button" onclick="searchCode(document.formOrRepOrderCatalog, 'Order Entry Format', from_order_entry_format)"></TD>
			
			<TD ALIGN="left" WIDTH="45%">
			<INPUT TYPE=text name="to_order_entry_format" id="to_order_entry_format" SIZE="8" maxlength="8" onBlur="ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)" tabIndex="2">
			<INPUT TYPE="button" name="to_button_order_entry_format" id="to_button_order_entry_format" VALUE="?" CLASS="button" onclick="searchCode(document.formOrRepOrderCatalog, 'Order Entry Format',to_order_entry_format)">
			</TD>																																										 
			
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>
		<TR>
			<TD ALIGN="right" WIDTH="30%" CLASS="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/> </TD>
			<TD COLSPAN="2" ALIGN="left">
				<SELECT name="o_effstat" id="o_effstat" tabIndex="3">
					<OPTION VALUE=""><fmt:message key="Common.Both.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="E"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="D"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></OPTION>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>
		<TR>
			<TD ALIGN="right" WIDTH="25%" CLASS="label"><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;</TD>
			<TD COLSPAN="2" ALIGN="left">
				<SELECT name="o_orderby" id="o_orderby" tabIndex="4">
					<OPTION VALUE="2"><fmt:message key="eOR.OrderTypeCategory.label" bundle="${or_labels}"/> </OPTION>
					<OPTION VALUE="3"><fmt:message key="Common.OrderTypeCode.label" bundle="${common_labels}"/></OPTION>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="3">&nbsp;</TD>
		</TR>
	</TABLE>	   <%try{%>
<input type=hidden  name='SQL_OR_REPORTS_ORDER_ENTRY_FORMAT_LOOKUP' id='SQL_OR_REPORTS_ORDER_ENTRY_FORMAT_LOOKUP'     value='<%=OrRepository.getOrKeyValue("SQL_OR_REPORTS_ORDER_ENTRY_FORMAT_LOOKUP")%>' >
	
	<INPUT TYPE="hidden" name="o_facility_id" id="o_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" NAME=o_user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="o_module_id" id="o_module_id" VALUE="OR">
	<INPUT TYPE="hidden" name="o_report_id" id="o_report_id" VALUE="OROEFFRM">
									  <%}catch(Exception e){out.println(e);}%>
</FORM>
</BODY>
</HTML>

