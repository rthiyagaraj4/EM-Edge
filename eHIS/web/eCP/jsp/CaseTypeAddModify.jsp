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
*	Created By		:	Sreelatha
*	Created On		:	27th Dec 2004
-->

<!--CaseTypeAddModify.jsp-->

<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.net.*"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
	  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	  String mode=request.getParameter("mode");
      String operation_type="";
%>
<html>
<head>
	<%
	//This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../js/CaseType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<br><br><br>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='form_casetype' id='form_casetype' action='../../servlet/eCP.CaseTypeServlet' method='POST'target='messageFrame'>
<% 
Connection conn=null;
PreparedStatement pstmt_exp_text=null;
ResultSet rs_exp_text=null;

String sql_exp_text="";
String long_desc="";
String short_desc="";
String case_type_code="";
String case_type_nature="";
String eff_status="";

if (mode.equals("1"))
{
	operation_type="insert";
%>
		
	<table cellpadding="1" cellspacing="0" border="0" width="98%" align='center'>
				<tr>
			<td  width="18%"   class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>   
			<td class="label">
				<fmt:message key="eCP.lllness.label" bundle="${cp_labels}"/><input type="radio" name="case_type_nature" id="case_type_nature" value="I"   
				checked>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="Common.Wellness.label" bundle="${common_labels}"/><input type="radio" name="case_type_nature" id="case_type_nature" value="W" >
			</td>
		</tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td>&nbsp;<input type="text" name="case_type_code" id="case_type_code" size="15" maxlength="10" value=""  onKeyPress="return CheckForSpecChars(event)">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td>&nbsp;<input type="text" name="short_desc" id="short_desc" size="70" maxlength="60">&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
			<td>&nbsp;<textarea name="long_desc"  rows='10' cols='60'  onKeyPress="checkMaxLimit(this,400);" onblur="checkForMax(this);"></textarea>&nbsp;<img src="../../eCommon/images/mandatory.gif">
		</tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td><input type=checkbox name="eff_status" id="eff_status" checked value='E' onclick="checkActive(this)"></td>
		</tr>
	</table>
<%
}else
	{
operation_type="modify";
conn = ConnectionManager.getConnection(request);	

case_type_code=request.getParameter("case_type_code")==null ? "":request.getParameter("case_type_code");
//String short_desc=request.getParameter("short_desc")==null ? "":request.getParameter("short_desc");
case_type_nature=request.getParameter("case_type_nature")==null ? "":request.getParameter("case_type_nature");
eff_status=request.getParameter("eff_status")==null ? "":request.getParameter("eff_status");


try
{
	

sql_exp_text="select long_desc,short_desc from cp_case_type where case_type_code=?";
pstmt_exp_text=conn.prepareStatement(sql_exp_text);
pstmt_exp_text.setString(1,case_type_code);

rs_exp_text=pstmt_exp_text.executeQuery();

while(rs_exp_text.next())
	{
		long_desc=rs_exp_text.getString("long_desc")==null ? "":rs_exp_text.getString("long_desc");
		short_desc=rs_exp_text.getString("short_desc")==null ? "":rs_exp_text.getString("short_desc");
	}
	

}catch(Exception e)
{
	e.printStackTrace();
}finally{
	if (rs_exp_text != null)   rs_exp_text.close();
	if (pstmt_exp_text != null) pstmt_exp_text.close();
		ConnectionManager.returnConnection(conn,request);
}
	
%>
	
	<table cellpadding=1 cellspacing=0 border=0 width="98%" align='center'>
		<tr>
			<td  width="20%"  align=right class="label"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
	<%if(eff_status.equals("E")){
		if(case_type_nature.equals("W"))
		{
	%>
		<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="eCP.lllness.label" bundle="${cp_labels}"/><input type="radio" name="case_type_nature" id="case_type_nature" value="I" onchange='radioselect(this);'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="Common.Wellness.label" bundle="${common_labels}"/><input type="radio" name="case_type_nature" id="case_type_nature" value="W"  onchange='radioselect(this);' checked>
			</td>
<%}
	else
		{%>
			<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="eCP.lllness.label" bundle="${cp_labels}"/><input type="radio" name="case_type_nature" id="case_type_nature" value="I" onchange='radioselect(this);' checked>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="Common.Wellness.label" bundle="${common_labels}"/><input type="radio" name="case_type_nature" id="case_type_nature" value="W" onchange='radioselect(this);' >
			</td>	
		<%}
}else{
	if(case_type_nature.equals("W"))
		{
	%>
			<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="eCP.lllness.label" bundle="${cp_labels}"/><input type="radio" name="case_type_nature" id="case_type_nature" disabled value="I" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="Common.Wellness.label" bundle="${common_labels}"/><input type="radio" name="case_type_nature" id="case_type_nature" value="W" disabled checked>
			</td>
<%}
	else
		{%>
			<td class="label">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="eCP.lllness.label" bundle="${cp_labels}"/><input type="radio" name="case_type_nature" id="case_type_nature" value="I" checked   disabled>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<fmt:message key="Common.Wellness.label" bundle="${common_labels}"/><input type="radio" name="case_type_nature" id="case_type_nature"  value="W"   disabled>
			</td>	
		<%}
}%>
		<input type='hidden' name="case_type_nature1" id="case_type_nature1" value='<%=case_type_nature%>'>
		</tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input type="text" name="case_type_code" id="case_type_code" readable size="15" maxlength="10"  onKeyPress="return CheckForSpecChars(event)" value="<%=case_type_code%>" readonly><img src="../../eCommon/images/mandatory.gif"></td>
		</tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
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
				
			<td width="20%" align="right" class="label"><fmt:message key="Common.ExplanatoryText.label" bundle="${common_labels}"/></td>
			<%if(eff_status.equals("E"))
		{
				%>
			<td>&nbsp;&nbsp;<textarea name="long_desc" rows='10'cols='60'  onKeyPress="checkMaxLimit(this,400);" onblur="checkForMax(this);"><%=long_desc%></textarea><img src="../../eCommon/images/mandatory.gif"></td>
				<%
		}
			else
		{%>
			<td>&nbsp;&nbsp;<textarea name="long_desc"  rows='10'cols='60' readonly><%=long_desc%></textarea><img src="../../eCommon/images/mandatory.gif"></td>
				<%}%>
		</tr>
		<tr>
			<td width="20%" align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<%if(eff_status.equals("E"))
		{
				%>
			<td>&nbsp;&nbsp;<input type=checkbox name="eff_status" id="eff_status" checked value="<%=eff_status%>" onclick="checkActive(this)"></td>
		<%
		}
			else
		{%>
				<td>&nbsp;&nbsp;<input type=checkbox name="eff_status" id="eff_status"  value="<%=eff_status%>" onclick="checkActive(this)"></td>
				<%}%>
		</tr>
	</table>
	<%}%>
<input type='hidden' name="operation_type" id="operation_type" value="<%=operation_type%>">
</form>
</body>
</html>

