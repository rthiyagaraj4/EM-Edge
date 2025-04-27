<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" %>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" %>
<%

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/messages.js" language="JavaScript"></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eCommon/js/MstCodeCommon.js" language="javascript"></script>
<script src="../../eCP/js/ViewCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/CpMessages.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
String care_plan_id = request.getParameter("planid");
String md_plan_id = request.getParameter("md_plan_id");
String cp_start_date = request.getParameter("cp_start_date");
String cp_target_date = request.getParameter("cp_target_date");
String current_status = request.getParameter("current_status");
String care_mgr_name = request.getParameter("care_mgr_name");
String remarks = "";
String error_color = "";
String error_color_plus = "";
if(current_status.equals("O"))
	current_status = "Pending";
else if(current_status.equals("C"))
	current_status = "Completed";
else if(current_status.equals("A"))
	current_status = "Active";
else if(current_status.equals("D"))
	current_status = "Discontinued";
%>
</head>
<body OnMouseDown='CodeArrest()'>
<form name="view_cp_mrk_err_hdr_form" id="view_cp_mrk_err_hdr_form">
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
	<tr >
		<td width='25%' class='label' align='left'  colspan='2'>&nbsp;Care Manager Name</td>
		<td width='20%' class='label' align='left'>&nbsp;Start Date</td>
		<td width='20%' class='label' align='left'>&nbsp;Target Date</td>
		<td width='20%' class='label' align='left'>&nbsp;Status</td>
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
	String sql = "select eval_id,practitioner_name,to_char(eval_datetime,'dd/mm/yyyy hh:mi') eval_date,remarks,status from cp_pat_care_plan_eval,am_practitioner where md_care_plan_id=? and care_plan_id=? and practitioner_id=eval_by order by eval_id DESC";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,md_plan_id);
	pstmt.setString(2,care_plan_id);
	rs = pstmt.executeQuery();
	if(rs!=null)
	{
		int i = 0;
%>
	<tr>
		<td class = 'ITRVNHDR' width='25%' align='left' colspan='2'>&nbsp;&nbsp;&nbsp;&nbsp;<B>Evaluation Date</B></td>
		<td class = 'ITRVNHDR' width='20%' align='left'><B>Evaluated By</B></td>
		<td class = 'ITRVNHDR' width='20%' align='left' colspan='2'><B>Remarks</B></td>
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
			out.println("<td width='1%'class='label' onclick=viewCarePlanShowDetail('"+md_plan_id+"','"+care_plan_id+"','"+rs.getString("eval_id")+"')><font color='"+error_color_plus+"'  style='cursor:pointer'><B>+&nbsp;</B></font></td>");
			out.println("<td width='25%' class='label' align='left'>&nbsp;<font  color='"+error_color+"'>"+rs.getString("eval_date")+"</font></td>");
			out.println("<td width='20%' class='label' align='left'><font color='"+error_color+"'>"+rs.getString("practitioner_name")+"</font></td>");
			out.println("<td width='20%' class='label' align='left'><font color='"+error_color+"' onclick=viewCarePlanCallreason('"+md_plan_id+"','"+care_plan_id+"','"+rs.getString("eval_id")+"') style='cursor:pointer'><B>Text</B></font></td>");
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
	e.printStackTrace(System.err);
	System.out.println("Exception in ViewCarePlanMarkErrorHeader.jsp="+e.toString());
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

