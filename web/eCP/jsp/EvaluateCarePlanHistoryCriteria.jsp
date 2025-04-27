<!DOCTYPE html>
<html>
<head>
<title>Evaluation History</title>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*" %>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<!-- <script src="../../eCP/js/common.js" language="JavaScript"></script> -->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/messages.js" language="JavaScript"></script>
<!-- <script src="../../eCommon/js/MstCodeCommon.js" language="javascript"></script> -->
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/CpMessages.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection conn = null;
PreparedStatement stmt_eval_cnt = null;
PreparedStatement stmt = null;
ResultSet rs_eval_cnt = null;
ResultSet rset = null;
try
{

int eval_cnt=0;

String care_plan_id=request.getParameter("care_plan_id")==null?"":request.getParameter("care_plan_id") ;
String md_care_plan_id=request.getParameter("md_care_plan_id")==null?"":request.getParameter("md_care_plan_id") ;

String eval_count_sql = "select count(*) from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ? and status = 'V'";

String sql="SELECT a.eval_by,to_char(a.eval_datetime,'dd/mm/yy hh24:mi:ss') eval_date ,to_char(b.care_plan_start_date,'dd/mm/yyyy') start_date,to_char(b.care_plan_target_date,'dd/mm/yyyy') target_date,a.remarks,a.eval_id FROM cp_pat_care_plan_eval a,cp_pat_care_plan b WHERE a.md_care_plan_id=b.md_care_plan_id AND a.care_plan_id=b.care_plan_id AND a.md_care_plan_id=? AND a.care_plan_id=? AND a.status='V' ORDER BY a.eval_datetime  desc";

conn= ConnectionManager.getConnection(request);

try
{
stmt_eval_cnt = conn.prepareStatement(eval_count_sql);
stmt_eval_cnt.setString(1,md_care_plan_id);
stmt_eval_cnt.setString(2,care_plan_id);
rs_eval_cnt = stmt_eval_cnt.executeQuery();

if(rs_eval_cnt!=null)
{
	while(rs_eval_cnt.next())
	{
		eval_cnt=rs_eval_cnt.getInt(1);
	}

}
}
catch(Exception e)
{
	out.println(e.toString());
}
finally
{
	if(rs_eval_cnt!=null) rs_eval_cnt.close();
	if(stmt_eval_cnt!=null) stmt_eval_cnt.close();
}

%>
<body OnMouseDown='CodeArrest()'>
<form name='eval_cp_history_criteria' id='eval_cp_history_criteria'>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<tr>
<td width="25%" class="ITRVNHDR" align='left'><B>&nbsp;&nbsp;Evaluation Date</B></td>
<td width="35%" class="ITRVNHDR" align='left'><B>&nbsp;&nbsp;Evaluated By</B></td>
<td width="35%" class="ITRVNHDR" align='left'><B>Evaluation Remarks</B></td> 
<td class="ITRVNHDR">&nbsp;</td>
</tr>
<%
String eval_date="";
String eval_date_time="";
String start_date="";
String target_date="";
String remarks="";
String eval_id="";
String eval_by="";

try
{
	stmt=conn.prepareStatement(sql);
	stmt.setString(1,md_care_plan_id);
	stmt.setString(2,care_plan_id);
	rset=stmt.executeQuery();

	if(rset!=null)
	{
		while(rset.next())
		{
			eval_date=rset.getString("eval_date");
			eval_date_time=eval_date.substring(0,14);
			start_date=rset.getString("start_date");
			target_date=rset.getString("target_date");
			remarks=rset.getString("remarks")==null?"":rset.getString("remarks");
			eval_id=rset.getString("eval_id");
			eval_by=rset.getString("eval_by");
%>
<tr>
<td width="25%" class="label" align='left'>&nbsp;&nbsp;<%=eval_date_time%></td> 
<td width="35%" class="label" align='left'>&nbsp;&nbsp;<%=eval_by%></td>
<td width="35%" class="label" align='left' style='cursor:pointer;color=#3333FF' onclick="ShowRemarks('<%=remarks%>');">Remarks</td> 
<td class="label">&nbsp;</td>
</tr>
<%
		}
	}
%>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<tr>
<td align="right"><input type=button class='button' name="close" id="close" value="Close" onclick="wincls()">&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
</table>
<%
}
catch(Exception e)
{
//	out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
}
}
catch(Exception e)
{
//	out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(rs_eval_cnt!=null) rs_eval_cnt.close();
	if(stmt_eval_cnt!=null) stmt_eval_cnt.close();
	if(rset!=null) rset.close();
	if(stmt!=null) stmt.close();
	
	if(conn!=null)
	ConnectionManager.returnConnection(conn,request);
}
%>
</table>
</form>
</body>
</html>

