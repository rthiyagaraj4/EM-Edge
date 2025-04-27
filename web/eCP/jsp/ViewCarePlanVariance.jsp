<!DOCTYPE html>
<%@page language="java" import ="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<html>
<head>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCP/js/CpMessages.js"></script>
<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
<!-- <script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
<script language="JavaScript" src="../../eCP/js/CarePlanVariance.js"></script>
<script language="JavaScript" src="../../eCP/js/ViewCarePlan.js"></script>
<script language="JavaScript" src="../../eCP/js/CpMessages.js"></script>
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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
RecordSet	CarePlanVariance	=	null;
CarePlanVariance	=	(webbeans.eCommon.RecordSet)session.getAttribute("CarePlanVariance");
Connection conn=null;

PreparedStatement pstmt=null;
ResultSet rset=null;

try
{
conn=ConnectionManager.getConnection(request);


String p_care_plan_id=request.getParameter("p_care_plan_id")==null?"":request.getParameter("p_care_plan_id");
String p_md_care_plan_id=request.getParameter("p_md_care_plan_id")==null?"":request.getParameter("p_md_care_plan_id");
String p_var_comp_type=request.getParameter("p_var_comp_type")==null?"":request.getParameter("p_var_comp_type");
String facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");

%>
<body onMouseDown="CodeArrest()"  onload='FocusFirstElement()' onKeyDown="lockKey()" >
<form name="CarePlanVarianceDetail_Form" id="CarePlanVarianceDetail_Form" method="post" action="" target="care_plan_dyn_val">
<table cellpadding=0 cellspacing=0 width="100%" border=0>

<tr>
<td align="left" class="data" colspan="5">List of Variances</td>
</tr>
</table>
<table cellpadding=0 cellspacing=0 width="100%" border=1>
<tr>
<th  width='36%' align='center'>Outcome</th>
<th  width='25%' align='center'>Cause</th>
<th  width='25%' align='center'>Reason</th>
<th  width='7%' >&nbsp;</th>
<th  width='7%' >&nbsp;</th>
</tr>

<%
String expected_outcome="";
String expected_outcome_desc="";
String variance_cause="";
String variance_cause_desc="";
String variance_reason="";
String variance_reason_desc="";
String variance_remark="";
String variance_action_plan="";
pstmt=conn.prepareStatement("select a.var_outcome_code expected_outcome,b.short_desc expected_outcome_desc,a.var_cause_code variance_cause,c.var_cause_desc variance_cause_desc,a.var_reason_code variance_reason,d.var_reason_desc variance_reason_desc, a.variance_remarks variance_remark,a.action_plan variance_action_plan from cp_pat_care_plan_var_dtl a,cp_outcome b,cp_variance_cause c,cp_variance_reason d where md_care_plan_id=? and care_plan_id=? and var_comp_type=? and a.added_facility_id=? and a.VAR_OUTCOME_CODE=b.outcome_code(+) and a.VAR_CAUSE_CODE=c.var_cause_code and a.VAR_REASON_CODE=d.VAR_REASON_CODE order by variance_log_id,srl_no");
	pstmt.setString(1,p_md_care_plan_id);
	pstmt.setString(2,p_care_plan_id);
	pstmt.setString(3,p_var_comp_type);
	pstmt.setString(4,facility_id);
	rset=pstmt.executeQuery();

	
while(rset!=null && rset.next())
{
	
        expected_outcome	=	checkForNull(rset.getString("expected_outcome"));
        expected_outcome_desc=checkForNull(rset.getString("expected_outcome_desc"));
        variance_cause=checkForNull(rset.getString("variance_cause"));
        variance_cause_desc=checkForNull(rset.getString("variance_cause_desc"));
        variance_reason=checkForNull(rset.getString("variance_reason"));
        variance_reason_desc=checkForNull(rset.getString("variance_reason_desc"));
        variance_remark=checkForNull(rset.getString("variance_remark"));
        variance_action_plan=checkForNull(rset.getString("variance_action_plan"));
		
%>
<tr>
<%
	if(!(expected_outcome.equals("")))
	{
%>
<td align='left'  class="label"  ><%=expected_outcome_desc%></td>
<%
	}
    else
	{
%>
<td align='left' class="label">&nbsp;</td>
<%
	}
%>
<td align='left' class="label"><%=variance_cause_desc%></td>
<td align='left' class="label"><%=variance_reason_desc%></td>
<%
	if(!(variance_remark.equals("")))
	{
%>
<td align='center' class="FONTVALHYPER" onClick="getRemarks('<%=variance_remark%>');" nowrap>Remarks</td>
<%
	}
    else
	{
%>
<td align='center'>&nbsp;</td>
<%
	}
    if(!(variance_action_plan.equals("")))
	{
%>
<td align='center' class="FONTVALHYPER" onClick="getActionPlan('<%=variance_action_plan%>');" nowrap>Action Plan</td>
<%
	}
  else
	{
%>
<td align='center'>&nbsp;</td>
<%
	}
%>

</tr>
<%

}
%>
</table>
<input type=hidden name="p_care_plan_id" id="p_care_plan_id" value="<%=p_care_plan_id%>">
<input type=hidden name="p_md_care_plan_id" id="p_md_care_plan_id" value="<%=p_md_care_plan_id%>">
<input type=hidden name="p_var_comp_type" id="p_var_comp_type" value="<%=p_var_comp_type%>">
<body>
<%
}
catch(Exception exp)
{
  System.out.println("111 Exception in ViewCarePlanVariance.jsp="+exp.toString());
  exp.printStackTrace();
}
finally
{
	try
	{

	if(rset!=null)	 rset.close();
	if(pstmt!=null)	 pstmt.close();
	
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
	catch(Exception exp)
	{
		System.out.println("2222 Exception in ViewCarePlanVariance.jsp="+exp.toString());
		exp.printStackTrace();
	}
}
%>
</html>

<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

