<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	P.Anuradha
*	Created On		:	19 July 2005
--%>
<%@page language="java" import ="com.ehis.eslp.*,java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
//This file is saved on 07/11/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCP/js/CarePlanVariance.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection conn=null;
PreparedStatement pstmt_date=null;
ResultSet rset_date=null;
PreparedStatement pstmt_variance_cause=null;
ResultSet rset_variance_cause=null;
PreparedStatement pstmt_outcome=null;
ResultSet rset_outcome=null;

String sql_date="select to_char(sysdate,'dd/mm/yyyy hh:mi:ss') sys_date from dual";
String variance_date="";
String sql_variance_cause="";
String sql_outcome="";
String var_cause_code="";
String var_cause_desc="";
String p_care_plan_id="";
String p_md_care_plan_id="";
String p_var_comp_type="";
String p_outcome_code="";
String p_goal_code="";
String p_term_code="";
String p_term_set_id="";
String outcome_code="";
String outcome_desc="";

try
{
conn=ConnectionManager.getConnection(request);

p_care_plan_id=request.getParameter("p_care_plan_id")==null?"":request.getParameter("p_care_plan_id");
p_md_care_plan_id=request.getParameter("p_md_care_plan_id")==null?"":request.getParameter("p_md_care_plan_id");
p_var_comp_type=request.getParameter("p_var_comp_type")==null?"":request.getParameter("p_var_comp_type");
p_outcome_code=request.getParameter("p_outcome_code")==null?"":request.getParameter("p_outcome_code");
p_goal_code=request.getParameter("p_goal_code")==null?"":request.getParameter("p_goal_code");
p_term_code=request.getParameter("p_term_code")==null?"":request.getParameter("p_term_code");
p_term_set_id=request.getParameter("p_term_set_id")==null?"":request.getParameter("p_term_set_id");

pstmt_date=conn.prepareStatement(sql_date);
rset_date=pstmt_date.executeQuery();
if(rset_date!=null)
{
	while(rset_date.next())
	{
        variance_date=com.ehis.util.DateUtils.convertDate(rset_date.getString("sys_date"),"DMYHMS","en",locale);
	}
}
%>
<body onMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown="lockKey()" >
<form name="CarePlanVarianceHeader_Form" id="CarePlanVarianceHeader_Form" method="post" target="messageFrame">
<table cellpadding=0 cellspacing=0 width="100%" border=0>
<tr>
<td colspan="4">&nbsp;</td>
</tr>
<tr>
<td align="right" class="label" colspan="1"><fmt:message key="Common.date.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td align="left" colspan="3" class="data"><%=variance_date%></td>
</tr>
<tr>
<td colspan="4">&nbsp;</td>
</tr>
<tr>
<td align="right" class="label" colspan="1"><fmt:message key="eCP.ExpectedOutcome.label" bundle="${cp_labels}"/>&nbsp;&nbsp;</td>
<td align="left" colspan="3">
<select name='Expected_Outcome' id='Expected_Outcome'>
<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
//sql_outcome="select distinct a.outcome_code outcome_code,b.short_desc outcome_desc from cp_pat_outcome_eval a,cp_outcome b where a.md_care_plan_id=? and a.care_plan_id=? and a.outcome_code=b.outcome_code";
sql_outcome="SELECT DISTINCT a.outcome_code outcome_code,b.short_desc outcome_desc FROM cp_pat_outcome_eval a,cp_outcome_LANG_VW b WHERE a.md_care_plan_id=? AND a.care_plan_id=? AND a.outcome_code=b.outcome_code AND B.LANGUAGE_ID = ?";

pstmt_outcome=conn.prepareStatement(sql_outcome);
pstmt_outcome.setString(1,p_md_care_plan_id);
pstmt_outcome.setString(2,p_care_plan_id);
pstmt_outcome.setString(3,locale);

rset_outcome=pstmt_outcome.executeQuery();

if(rset_outcome!=null)
{
	while(rset_outcome.next())
	{
		outcome_code=rset_outcome.getString("outcome_code");
		outcome_desc=rset_outcome.getString("outcome_desc");
%>
<option value="<%=outcome_code%>"><%=outcome_desc%></option>
<%
	}
}
%>
</select>
</td>
</tr>
<tr>
<td colspan="4">&nbsp;</td>
</tr>
<tr>
<td align="right" class="label" colspan="1"><fmt:message key="eCP.VarianceCause.label" bundle="${cp_labels}"/>&nbsp;&nbsp;</td>
<td align="left" colspan="3">
<select name='Variance_Cause' id='Variance_Cause' onChange="getVarianceReason(this);">
<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
//sql_variance_cause="select var_cause_code,var_cause_desc from cp_variance_cause order by var_cause_desc";
sql_variance_cause="SELECT var_cause_code,var_cause_desc FROM cp_variance_cause_LANG_VW WHERE LANGUAGE_ID = ? ORDER BY var_cause_desc";
pstmt_variance_cause=conn.prepareStatement(sql_variance_cause);
pstmt_variance_cause.setString(1,locale);
rset_variance_cause=pstmt_variance_cause.executeQuery();

if(rset_variance_cause!=null)
{
	while(rset_variance_cause.next())
	{
		var_cause_code=rset_variance_cause.getString("var_cause_code");
		var_cause_desc=rset_variance_cause.getString("var_cause_desc");
%>
<option value="<%=var_cause_code%>"><%=var_cause_desc%></option>
<%
	}
}
%>
</select>
<img src="../../eCommon/images/mandatory.gif">&nbsp;
</td>
</tr>
<tr>
<td colspan="4">&nbsp;</td>
</tr>
<tr>
<td align="right" class="label" width="13%"><fmt:message key="eCP.ReasonForVariance.label" bundle="${cp_labels}"/>&nbsp;&nbsp;</td>
<td align="left" colspan="3">
<select name='Variance_Reason' id='Variance_Reason'>
<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
</select>
<img src="../../eCommon/images/mandatory.gif">&nbsp;
</td>
</tr>
<tr>
<td colspan="4">&nbsp;</td>
</tr>
<tr>
<td align="right" class="label" colspan="1"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td align="left" colspan="1">
<textarea name="Variance_Remarks" cols=50 rows=4 value="" onKeyPress="checkMaxLimit(this,200);" onblur="checkForMax(this);"></textarea></td>
<td align="right" class="label" colspan="1"><fmt:message key="eCP.ActionPlan.label" bundle="${cp_labels}"/>&nbsp;&nbsp;</td>
<td align="left" colspan="1">
<textarea name="Action_Plan" cols=50 rows=4 value="" onKeyPress="checkMaxLimit(this,200);" onblur="checkForMax(this);"></textarea></td>
</tr>
<tr>
<td colspan="4">&nbsp;</td>
</tr>
</table>
<table cellspacing=0 cellpadding=0 border=0 width="100%">
<tr>
<td align='right' width="89%"><input type=button class=button name=Variance_Next value='<fmt:message key="Common.next.label" bundle="${common_labels}"/>' onClick="LoadDetail();">&nbsp;</td>
<td align='left' width="11%"><input type=button class=button name=Variance_Clear value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="ClearHeader();"></td>
</tr>
<tr>
<td colspan="4">&nbsp;</td>
</tr>
</table>
<%
}
catch(Exception exp)
{
	out.println(exp.toString());
}
finally
{
	try
	{
	if(pstmt_date!=null) pstmt_date.close();
	if(rset_date!=null) rset_date.close();
	if(pstmt_variance_cause!=null) pstmt_variance_cause.close();
	if(rset_variance_cause!=null) rset_variance_cause.close();
	if(pstmt_outcome!=null) pstmt_outcome.close();
	if(rset_outcome!=null) rset_outcome.close();
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
	catch(Exception exp)
	{
		out.println(exp.toString());
	}
}
%>
<input type=hidden name="select_yn" id="select_yn" value="Y">
<input type=hidden name="p_care_plan_id" id="p_care_plan_id" value="<%=p_care_plan_id%>">
<input type=hidden name="p_md_care_plan_id" id="p_md_care_plan_id" value="<%=p_md_care_plan_id%>">
<input type=hidden name="p_var_comp_type" id="p_var_comp_type" value="<%=p_var_comp_type%>">
<input type=hidden name="p_term_code" id="p_term_code" value="<%=p_term_code%>">
<input type=hidden name="p_term_set_id" id="p_term_set_id" value="<%=p_term_set_id%>">
<input type=hidden name="p_goal_code" id="p_goal_code" value="<%=p_goal_code%>">
<input type=hidden name="p_outcome_code" id="p_outcome_code" value="<%=p_outcome_code%>">
</body>
</html>

