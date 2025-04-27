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
*	Created By		:	Vinay.
*	Created On		:	05 jul 2005
--%>
<html>
<head>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");	
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" href="../../eCommon/html/CommonCalendar.css" type="text/css"></link>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonCalendar.js" type="text/javascript" ></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></script>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/EvaluateCarePlanMarkError.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String care_plan_id = request.getParameter("planid");
String md_plan_id = request.getParameter("md_plan_id");
String cp_start_date = com.ehis.util.DateUtils.convertDate(request.getParameter("cp_start_date"),"DMYHM","en",locale);
String cp_target_date = com.ehis.util.DateUtils.convertDate(request.getParameter("cp_target_date"),"DMYHM","en",locale);
String current_status = request.getParameter("current_status");
String care_mgr_name = request.getParameter("care_mgr_name");
String remarks = "";
String error_color = "";
String error_color_plus = "";
if(current_status.equals("O"))
	current_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
else if(current_status.equals("C"))
	current_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
else if(current_status.equals("A"))
	current_status =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.active.label","common_labels");
else if(current_status.equals("D"))
	current_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
%>
</head>
<body OnMouseDown='CodeArrest()'>
<form name="eval_cp_mrk_err_hdr_form" id="eval_cp_mrk_err_hdr_form">
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
	<tr >
		<td width='25%' class='label' align='left'  colspan='2'><fmt:message key="eCP.CareManagerName.label" bundle="${cp_labels}"/></td>
		<td width='20%' class='label' align='left'><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
		<td width='20%' class='label' align='left'><fmt:message key="eCP.TargetDate.label" bundle="${cp_labels}"/></td>
		<td width='20%' class='label' align='left'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td width='25%' class='label' align='left'  colspan='2'><b>&nbsp;<%=care_mgr_name%></b></td>
		<td width='20%' class='label' align='left'><b>&nbsp;<%=cp_start_date%></b></td>
		<td width='20%' class='label' align='left'><b>&nbsp;<%=cp_target_date%></b></td>
		<td width='20%' class='label' align='left'><b>&nbsp;<%=current_status %></b></td>
	</tr>
<%
try
{
	con = ConnectionManager.getConnection(request);
//	String sql = "select eval_id,practitioner_name,to_char(eval_datetime,'dd/mm/yyyy hh:mi') eval_date,remarks,status from cp_pat_care_plan_eval,am_practitioner where md_care_plan_id=? and care_plan_id=? and practitioner_id=eval_by order by eval_id DESC";
	String sql = "SELECT eval_id,practitioner_name,TO_CHAR(eval_datetime,'dd/mm/yyyy hh:mi') eval_date,remarks,status FROM cp_pat_care_plan_eval,am_practitioner_LANG_VW WHERE md_care_plan_id=? AND care_plan_id=? AND practitioner_id=eval_by AND LANGUAGE_ID = ? ORDER BY eval_id DESC";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,md_plan_id);
	pstmt.setString(2,care_plan_id);
	pstmt.setString(3,locale);
	rs = pstmt.executeQuery();
	if(rs!=null)
	{
		int i = 0;
%>
	<tr>
		<td class = 'ITRVNHDR' width='25%' align='left' colspan='2'><B><fmt:message key="eCP.EvaluationDate.label" bundle="${cp_labels}"/></B></td>
		<td class = 'ITRVNHDR' width='20%' align='left'><B><fmt:message key="eCP.EvaluatedBy.label" bundle="${cp_labels}"/></B></td>
		<td class = 'ITRVNHDR' width='20%' align='left' colspan='2'><B><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></B></td>
	</tr>
<%
		while(rs.next())
		{
			if(rs.getString("status").equals("E"))
			{
				error_color = "red";
				error_color_plus = "red";
			}
			else
			{
				error_color = "";
				error_color_plus = "blue";
			}
			remarks = rs.getString("remarks")==null?"&nbsp;":rs.getString("remarks");
			out.println("<tr>");
			out.println("<td width='1%'class='label' onclick=showdetail('"+md_plan_id+"','"+care_plan_id+"','"+rs.getString("eval_id")+"','error_page_mode')><font color='"+error_color_plus+"'  style='cursor:pointer'><B>+&nbsp;</B></font></td>");
			out.println("<td width='25%' class='label' align='left'>&nbsp;<font  color='"+error_color+"'>"+com.ehis.util.DateUtils.convertDate(rs.getString("eval_date"),"DMYHM","en",locale)+"</font></td>");
			out.println("<td width='20%' class='label' align='left'><font color='"+error_color+"'>"+rs.getString("practitioner_name")+"</font></td>");
			out.println("<td width='20%' class='label' align='left'><font color='"+error_color+"' onclick=callreason('"+md_plan_id+"','"+care_plan_id+"','"+rs.getString("eval_id")+"','textmsg') style='cursor:pointer'><font class='HYPERLINK'><B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Text.label","common_labels")+"</B></font></td>");
			if(i==0)
				out.println("<td width='20%'class='label' align='left'><FONT  style='cursor:pointer' onclick=callreason('"+md_plan_id+"','"+care_plan_id+"','"+rs.getString("eval_id")+"','mrkerror')><font class='HYPERLINK'><B>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MarkError.label","common_labels")+"</B></FONT></td>");
			else
				out.println("<td width='20%'class='label' align='left'>&nbsp;</td>");
			out.println("</tr>");
			i++;
		}
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}
%>
</table>
</form>
</body>
</html>

