<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:
*	Created By		:	
*	Created On		:	18th July 2005
-->

<!--OutcomeAddModify.jsp-->

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<HEAD>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<SCRIPT src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="javascript" src="../js/VarianceCause.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<br><br><br><br><br><br>
<BODY  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<FORM name='VarianceCauseform' id='VarianceCauseform'  action='../../servlet/eCP.VarianceCauseServlet' method='POST'target='messageFrame'>
<%
String mode=request.getParameter("mode");
String varianceCauseCode="";
String varianceCausedesc="";
String eff_status="";
String enablestatus="Checked";
String readonly="";
String readonly1="";
if(mode.equals("2")){
	varianceCauseCode=request.getParameter("variance_code")==null?"":request.getParameter("variance_code");
	varianceCausedesc=request.getParameter("variance_desc")==null?"":request.getParameter("variance_desc");
	eff_status=request.getParameter("eff_status")==null?"":request.getParameter("eff_status");
	if(eff_status.equals("D")){
		enablestatus="";
		readonly="readonly";
	}
	readonly1="readonly";
}

	
%>
<TABLE cellpadding=0 cellspacing=0 border=0 width="70%" align='center'>
	<TR>
		<TD class="label" colspan="2">&nbsp;</TD>
	</TR>
	<TR>
		<TD align="center" class="label" width="10%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></TD>
		<TD align=left >&nbsp;
			<INPUT TYPE="text" name="Code" id="Code" size="6" maxlength="4" <%=readonly1%> onKeyPress="return CheckForSpecChars(event);" value="<%=varianceCauseCode%>">&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</TD>
	</TR>
	<TR>
		<TD class="label" colspan="2">&nbsp;</TD>
	</TR>
	<TR>
		<TD align="center" class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></TD>
		<TD align=left >&nbsp;
			<INPUT TYPE="text" name="Desc" id="Desc" size="60" maxlength="60" <%=readonly%> value="<%=varianceCausedesc%>">&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</TD>
	</TR>
	<TR>
		<TD class="label" colspan="2">&nbsp;</TD>
	</TR>
	<TR>
		<TD align="center" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TD>
		<TD align=left >&nbsp;
			<INPUT TYPE="checkbox" <%=enablestatus%> NAME="eff_status" value="E" onclick="enablestaus(this)">
		</TD>
	</TR>
	<TR>
		<TD class="label" colspan="2">&nbsp;</TD>
	</TR>
</TABLE>
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
</FORM>
</BODY>
</HTML>

