<!DOCTYPE html>
<html>
<title>View Mark Evaluation Error</title>
<head>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
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

<body OnMouseDown='CodeArrest()'>
<form name="view_cp_mrk_err_rsn_form" id="view_cp_mrk_err_rsn_form" method="post" target="blanFrame" action="">
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String md_plan_id = request.getParameter("md_plan_id");
String care_plan_id = request.getParameter("care_plan_id");
String eval_id = request.getParameter("eval_id");
String error_remarks = request.getParameter("error_remarks");

Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String sql = "select status_remarks from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ? and eval_id=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,md_plan_id);
		pstmt.setString(2,care_plan_id);
		pstmt.setString(3,eval_id);
		rs = pstmt.executeQuery();
		if(rs!=null)
		{
			if(rs.next())
			{
				error_remarks = rs.getString("status_remarks")==null?"":rs.getString("status_remarks");
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch (Exception e)
	{
		e.printStackTrace(System.err);
		System.out.println("Exception in ViewCarePlanMarkErrorReason.jsp="+e.toString());
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
%>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
	<tr>
		<td align='left' class='label'><B>Error Remarks</B><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<tr>
		<td align='right'>&nbsp;&nbsp;<TEXTAREA NAME="mrk_reason" ROWS="10" COLS="50" readOnly><%=error_remarks%></TEXTAREA>&nbsp;&nbsp;</td>
	</tr>

	<tr>
		<td align="right"><INPUT TYPE="button" value="Close" class="button" onclick="window.close();">
		</td>
	</tr>

	<tr>
		<td align='left' class='label'>&nbsp;</td>
	</tr>
</table>
<INPUT TYPE="hidden" name="md_plan_id" id="md_plan_id" value="<%=md_plan_id%>">
<INPUT TYPE="hidden" name="care_plan_id" id="care_plan_id" value="<%=care_plan_id%>">
<INPUT TYPE="hidden" name="eval_id" id="eval_id" value="<%=eval_id%>">
</form>
</body>
</head>
</html>

