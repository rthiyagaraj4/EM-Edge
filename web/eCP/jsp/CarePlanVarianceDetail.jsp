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
<%@page language="java" import ="com.ehis.eslp.*,java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
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
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCP/js/CarePlanVariance.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
TD.FONTVALHYPER
{
	FONT-SIZE: 10 ;
	color:BLUE;
	cursor:pointer;
}
</style>
</head>
<%
RecordSet	CarePlanVariance	=	null;
CarePlanVariance	=	(webbeans.eCommon.RecordSet)session.getAttribute("CarePlanVariance");
Connection conn=null;

PreparedStatement pstmt_variance_cause=null;
ResultSet rset_variance_cause=null;

PreparedStatement pstmt_variance_reason=null;
ResultSet rset_variance_reason=null;

PreparedStatement pstmt_expected_outcome=null;
ResultSet rset_expected_outcome=null;

try
{
conn=ConnectionManager.getConnection(request);

//String sql_variance_cause="select var_cause_desc from cp_variance_cause where var_cause_code=?";
String sql_variance_cause="SELECT var_cause_desc FROM cp_variance_cause_LANG_VW WHERE var_cause_code=? AND LANGUAGE_ID = ?";
//String sql_variance_reason="select var_reason_desc from cp_variance_reason where var_reason_code=?";
String sql_variance_reason="SELECT var_reason_desc FROM cp_variance_reason_LANG_VW WHERE var_reason_code=? AND LANGUAGE_ID = ?";
//String sql_expected_outcome="select short_desc outcome_desc from cp_outcome where outcome_code=?";
String sql_expected_outcome="SELECT short_desc outcome_desc FROM cp_outcome_LANG_VW WHERE outcome_code=? AND LANGUAGE_ID = ?";

pstmt_variance_cause=conn.prepareStatement(sql_variance_cause);
pstmt_variance_reason=conn.prepareStatement(sql_variance_reason);
pstmt_expected_outcome=conn.prepareStatement(sql_expected_outcome);

String p_care_plan_id=request.getParameter("p_care_plan_id")==null?"":request.getParameter("p_care_plan_id");
String p_md_care_plan_id=request.getParameter("p_md_care_plan_id")==null?"":request.getParameter("p_md_care_plan_id");
String p_var_comp_type=request.getParameter("p_var_comp_type")==null?"":request.getParameter("p_var_comp_type");
//String p_outcome_code=request.getParameter("p_outcome_code")==null?"":request.getParameter("p_outcome_code");
String p_goal_code=request.getParameter("p_goal_code")==null?"":request.getParameter("p_goal_code");
String p_term_code=request.getParameter("p_term_code")==null?"":request.getParameter("p_term_code");
String p_term_set_id=request.getParameter("p_term_set_id")==null?"":request.getParameter("p_term_set_id");
%>
<body onMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown="lockKey()" >
<form name="CarePlanVarianceDetail_Form" id="CarePlanVarianceDetail_Form" method="post" action="../../servlet/eCP.CarePlanVarianceServlet" target="care_plan_dyn_val">
<table cellpadding=0 cellspacing=0 width="100%" border=0>
<tr>
<th colspan="6"></th>
</tr>
<tr>
<th colspan="6"></th>
</tr>
<tr>
<td align="left" class="data" colspan="6"><fmt:message key="eCP.ListofVariances.label" bundle="${cp_labels}"/></td>
</tr>
<tr>
<td colspan="6"></td>
</tr>
<tr>
<td colspan="6"></td>
</tr>
<tr>
<td colspan="6"></td>
</tr>
<tr>
<th  width='25%' align='left'><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></th>
<th  width='30%' align='left'><fmt:message key="eCP.Cause.label" bundle="${cp_labels}"/></th>
<th  width='30%' align='left'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
<th  width='7%' >&nbsp</th>
<th  width='10%' >&nbsp</th>
<th  align='center'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
</tr>
<%
String variance_cause="";
String variance_reason="";
String variance_remark="";
String variance_action_plan="";
String select_yn="";
String select_status="";
String variance_cause_desc="";
String variance_reason_desc="";
String expected_outcome="";
String expected_outcome_desc="";

expected_outcome=request.getParameter("p_outcome_code")==null?"":request.getParameter("p_outcome_code");
variance_cause=request.getParameter("variance_cause1")==null?"":request.getParameter("variance_cause1");
variance_reason=request.getParameter("variance_reason")==null?"":request.getParameter("variance_reason");
variance_remark=request.getParameter("variance_remark")==null?"":request.getParameter("variance_remark");
variance_action_plan=request.getParameter("variance_action_plan")==null?"":request.getParameter("variance_action_plan");
select_yn=request.getParameter("select_yn")==null?"N":request.getParameter("select_yn");

ArrayList variance_set=new ArrayList();

ArrayList Variance_Data=new ArrayList();
Variance_Data.add(expected_outcome);
Variance_Data.add(variance_cause);
Variance_Data.add(variance_reason);
Variance_Data.add(variance_remark);
Variance_Data.add(variance_action_plan);
Variance_Data.add(select_yn);
CarePlanVariance.putObject(Variance_Data);

int n=CarePlanVariance.getSize();

for(int k=0;k<n;k++)
{
        variance_set=(ArrayList)CarePlanVariance.getObject(k);

		expected_outcome=(String)variance_set.get(0);
		variance_cause=(String)variance_set.get(1);
		variance_reason=(String)variance_set.get(2);
		variance_remark=(String)variance_set.get(3);
		variance_action_plan=(String)variance_set.get(4);
		select_yn=(String)variance_set.get(5);

        pstmt_variance_cause.setString(1,variance_cause);
        pstmt_variance_cause.setString(2,locale);
		rset_variance_cause=pstmt_variance_cause.executeQuery();

		if(rset_variance_cause!=null)
		{
			while(rset_variance_cause.next())
			{
                variance_cause_desc=rset_variance_cause.getString("var_cause_desc");
			}
		}
		rset_variance_cause.close();

        pstmt_variance_reason.setString(1,variance_reason);
        pstmt_variance_reason.setString(2,locale);
		rset_variance_reason=pstmt_variance_reason.executeQuery();
		if(rset_variance_reason!=null)
		{
			while(rset_variance_reason.next())
			{
                variance_reason_desc=rset_variance_reason.getString("var_reason_desc");
			}
		}

    	rset_variance_reason.close();

    	pstmt_expected_outcome.setString(1,expected_outcome);
    	pstmt_expected_outcome.setString(2,locale);
		rset_expected_outcome=pstmt_expected_outcome.executeQuery();
		if(rset_expected_outcome!=null)
		{
			while(rset_expected_outcome.next())
			{
                expected_outcome_desc=rset_expected_outcome.getString("outcome_desc");
			}
		}

    	rset_expected_outcome.close();

		if(select_yn.equals("Y"))
			select_status="checked";
		else
			select_status="";
%>
<tr>
<%
	if(!(expected_outcome.equals("")))
	{
%>
<td align='left' class="label"><%=expected_outcome_desc%></td>
<%
	}
    else
	{
%>
<td align='left' class="label"></td>
<%
	}
%>
<td align='left' class="label"><%=variance_cause_desc%></td>
<td align='left' class="label"><%=variance_reason_desc%></td>
<%
	if(!(variance_remark.equals("")))
	{
%>
<td align='left' class="FONTVALHYPER" onClick="getRemarks('<%=variance_remark%>');" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
<%
	}
    else
	{
%>
<td align='left'></td>
<%
	}
    if(!(variance_action_plan.equals("")))
	{
%>
<td align='left' class="FONTVALHYPER" onClick="getActionPlan('<%=variance_action_plan%>');" nowrap>Action Plan</td>
<%
	}
  else
	{
%>
<td align='left'></td>
<%
	}
%>
<td align='center'><input type=checkbox  name=select<%=k%> value="<%=select_yn%>" <%=select_status%> onClick="ChangeStatus(this,'<%=k%>');"></td>
</tr>
<%
}
%>
</table>
<input type=hidden name="p_care_plan_id" id="p_care_plan_id" value="<%=p_care_plan_id%>">
<input type=hidden name="p_md_care_plan_id" id="p_md_care_plan_id" value="<%=p_md_care_plan_id%>">
<input type=hidden name="p_var_comp_type" id="p_var_comp_type" value="<%=p_var_comp_type%>">
<input type=hidden name="p_term_code" id="p_term_code" value="<%=p_term_code%>">
<input type=hidden name="p_term_set_id" id="p_term_set_id" value="<%=p_term_set_id%>">
<input type=hidden name="p_goal_code" id="p_goal_code" value="<%=p_goal_code%>">
<input type=hidden name="size" id="size" value="<%=n%>">
<body>
<%
}
catch(Exception exp)
{
 // out.println(exp.toString());//COMMON-ICN-0181
     exp.printStackTrace();//COMMON-ICN-0181
}
finally
{
	try
	{
	if(rset_variance_cause!=null)	 rset_variance_cause.close();
	if(rset_variance_reason!=null)	 rset_variance_reason.close();
	if(rset_expected_outcome!=null)	 rset_expected_outcome.close();
	if(pstmt_variance_cause!=null)	 pstmt_variance_cause.close();
	if(pstmt_variance_reason!=null)	 pstmt_variance_reason.close();
	if(pstmt_expected_outcome!=null) pstmt_expected_outcome.close();
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
	catch(Exception exp)
	{
		//out.println(exp.toString());//COMMON-ICN-0181
                exp.printStackTrace();//COMMON-ICN-0181
	}
}
%>
</html>

