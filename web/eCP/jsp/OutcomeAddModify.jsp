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
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	24th Dec 2004
-->

<!--OutcomeAddModify.jsp-->

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
	String mode					=		request.getParameter("mode");
	String operation_type		=		"";
%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle		 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale=(String)session.getAttribute("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/Outcome.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<br><br><br><br><br><br>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='form_Outcome' id='form_Outcome' action='../../servlet/eCP.OutcomeServlet' method='POST'target='messageFrame'>
<% 
	String sql_exp_text					=		"";
	String outcome_code					=		request.getParameter("outcome_code")==null ? "":request.getParameter("outcome_code");
	String outcome_type					=		request.getParameter("outcome_type")==null ? "":request.getParameter("outcome_type");
	String eff_status					=		request.getParameter("eff_status")==null ? "":request.getParameter("eff_status");
	String long_desc					=		"";
	String short_desc					=		"";

	Connection conn						=		null;
	PreparedStatement pstmt_exp_text	=		null;
	ResultSet rs_exp_text				=		null;

	if (mode.equals("1"))
	{

		operation_type="insert";%>
	<table cellpadding=0 cellspacing=0 border=0 width="98%" align='center'>
		<tr>
			<td  width="20%"  align=left class="LABEL"><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
			<td class="LABEL">&nbsp;&nbsp;		
				<fmt:message key="eCP.Goal.label" bundle="${cp_labels}"/><input type="radio" name="outcome_type" id="outcome_type" value="G">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="eCP.ExpectedOutcome.label" bundle="${cp_labels}"/><input type="radio" name="outcome_type" id="outcome_type" value="O" checked>
			</td>
		</tr>
		<tr>
			<td width="20%" align="left" class="LABEL"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text" name="outcome_code" id="outcome_code" size="15" maxlength="10" value="" onKeyPress="return CheckForSpecChars(event)" ><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td width="20%" align="left" class="LABEL"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" size="70" maxlength="60"><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td width="20%" align="left" class="LABEL"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<textarea name="long_desc"  rows='9'cols='50' onKeyPress="checkMaxLimit(this,400);" onblur="checkForMax(this);"></textarea><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td width="20%" align="left" class="LABEL"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td>&nbsp;<input type=checkbox name="eff_status" id="eff_status" checked value='E' onclick="checkActive(this)"></td>
		</tr>
	</table>
<%
}else
	{
				operation_type="modify";
			
conn = ConnectionManager.getConnection(request);	


try
{
	

	//sql_exp_text			=		"select long_desc,short_desc from cp_outcome where outcome_code=?";
	sql_exp_text			=		"SELECT long_desc,short_desc FROM cp_outcome_lang_vw WHERE outcome_code=? AND language_id='"+locale+"'";
	pstmt_exp_text			=		conn.prepareStatement(sql_exp_text);
	pstmt_exp_text.setString(1,outcome_code);

	rs_exp_text				=		pstmt_exp_text.executeQuery();

while(rs_exp_text.next())
	{
		long_desc			=		rs_exp_text.getString("long_desc")==null ? "":rs_exp_text.getString("long_desc");
		short_desc			=		rs_exp_text.getString("short_desc")==null ? "":rs_exp_text.getString("short_desc");
	}
	
}catch(Exception e)
{
	e.printStackTrace();
}finally{
	if (rs_exp_text != null)   rs_exp_text.close();
	if (pstmt_exp_text != null) pstmt_exp_text.close();
	if(conn != null)
		ConnectionManager.returnConnection(conn,request);

}

%>
				<table cellpadding=0 cellspacing=0 border=0 width="98%" align='center'>
		<tr>
			<td  width="20%"  align=left class="LABEL"><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></td>
	<% if(eff_status.equals("E")){
		if(outcome_type.equals("G"))
		{
	%>
			 <td class="LABEL">&nbsp;&nbsp;
				<fmt:message key="eCP.Goal.label" bundle="${cp_labels}"/><input type="radio" name="outcome_type" id="outcome_type" value="G" onchange='radioselect(this);' checked>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="eCP.ExpectedOutcome.label" bundle="${cp_labels}"/><input type="radio" name="outcome_type" id="outcome_type" value="O" onchange='radioselect(this);' >
			</td>
<%}
	else
		{%>
			<td class="LABEL">&nbsp;&nbsp;
				<fmt:message key="eCP.Goal.label" bundle="${cp_labels}"/><input type="radio" name="outcome_type" id="outcome_type" onchange='radioselect(this);' value="G">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="eCP.ExpectedOutcome.label" bundle="${cp_labels}"/><input type="radio" name="outcome_type" id="outcome_type" value="O"onchange='radioselect(this);' checked>
			</td>	
		<%}
}else{
	if(outcome_type.equals("G"))
		{
	%>
			<td class="LABEL">&nbsp;&nbsp;
				<fmt:message key="eCP.Goal.label" bundle="${cp_labels}"/><input type="radio" name="outcome_type" id="outcome_type"  disabled value="G" checked  onchange='radioselect(this);'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="eCP.ExpectedOutcome.label" bundle="${cp_labels}"/><input type="radio" name="outcome_type" id="outcome_type" value="O" disabled onchange='radioselect(this);'>
			</td>
<%}
	else
		{%>
			<td class="LABEL">&nbsp;&nbsp;
				<fmt:message key="eCP.Goal.label" bundle="${cp_labels}"/><input type="radio" name="outcome_type" id="outcome_type" value="G" disabled onchange='radioselect(this);'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="eCP.ExpectedOutcome.label" bundle="${cp_labels}"/><input type="radio" name="outcome_type" id="outcome_type"  disabled value="O" checked  onchange='radioselect(this);'>
			</td>	
		<%}
}%>
<input type='hidden' name="outcome_type1" id="outcome_type1" value='<%=outcome_type%>'>

		</tr>
		<tr>
			<td width="20%" align="left" class="LABEL"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text" name="outcome_code" id="outcome_code" readable size="15" maxlength="10"  onKeyPress="return CheckForSpecChars(event)"  value="<%=outcome_code%>" readonly><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td width="20%" align="left" class="LABEL"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<%if(eff_status.equals("E"))
		{
				%>
			<td>&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" size="70" maxlength="60" value="<%=short_desc%>"><img src="../../eCommon/images/mandatory.gif"></td>
		<%
		}
			else
		{%>
			<td>&nbsp;&nbsp;<input type="text" name="short_desc" id="short_desc" size="70" maxlength="60" value="<%=short_desc%>" readonly><img src="../../eCommon/images/mandatory.gif"></td>
				<%}%>
		</tr>
		<tr>
				
			<td width="20%" align="left" class="LABEL"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
			<%if(eff_status.equals("E"))
		{
				%>
			<td>&nbsp;&nbsp;<textarea name="long_desc"  rows='9'cols='50' onKeyPress="checkMaxLimit(this,400);" onblur="checkForMax(this);" ><%=long_desc%></textarea><img src="../../eCommon/images/mandatory.gif"></td>
				<%
		}
			else
		{%>
			<td>&nbsp;&nbsp;<textarea name="long_desc"  rows='9'cols='50' readonly><%=long_desc%></textarea><img src="../../eCommon/images/mandatory.gif"></td>
				<%}%>
		</tr>
		<tr>
			<td width="20%" align="left" class="LABEL"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<%if(eff_status.equals("E"))
		{
				%>
			<td>&nbsp;<input type=checkbox name="eff_status" id="eff_status" checked value="<%=eff_status%>" onclick="checkActive(this)"></td>
		<%
		}
			else
		{%>
				<td>&nbsp;<input type=checkbox name="eff_status" id="eff_status"  value="<%=eff_status%>" onclick="checkActive(this)"></td>
				<%}%>
		</tr>
	</table>
	<%}%>


<input type='hidden' name="operation_type" id="operation_type" value="<%=operation_type%>">
</form>
</body>
</html>

