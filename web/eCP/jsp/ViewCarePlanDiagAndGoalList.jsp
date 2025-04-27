<!DOCTYPE html>
<!--
-----------------------------------------------------------------------
Date       Edit History   		Name        Description
-----------------------------------------------------------------------
?             100         		?           created
08/05/2012	  IN032586			Menaka V	View Care Plan details>Click on X hyperlink in the frame>View Evaluation error page Opens
											>Click on + Hyperlink>We get internal server Error. 							
-----------------------------------------------------------------------
-->
<html>
<head>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
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
PreparedStatement stmt = null;
ResultSet rs = null;
ResultSet rs_view_cnt = null;
Statement stmt_termCode_msr_id = null;
ResultSet  rs_termCode_msr_id = null;
Statement stmt_goal_msr_id = null;
ResultSet  rs_goal_msr_id = null;
String p_pract_id = (String)session.getAttribute("ca_practitioner_id");
String care_mgr_name = request.getParameter("care_mgr_name")==null?"":request.getParameter("care_mgr_name");
String care_plan_id = request.getParameter("planid");
String md_plan_id = request.getParameter("md_plan_id");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String eval_id = request.getParameter("eval_id")==null?"":request.getParameter("eval_id");


int diag_count = 1;
int goal_count = 1;
try
{
	String term_set_id = "";
	String term_code = "";
	String termcodeDesc="";
	String goal_code = "";
	String goal_desc="";
	String termcodemsrlookupdisabled="";
	String goalmsrlookupdisabled="";
	int diag_pct = 0;
	int goal_pct = 0;
	String evaluation_allowed_yn = "";
	String evaluation_allowed_goal_yn = "";
	String onclickwork_diag = "";
	String onclickwork_goal = "";
	String onclickchgcolorfr = "";
	String onclickchgcolorfr_goal = "";
	String onclickchgcolorbac = "";
	String onclickchgcolorbac_goal = "";
	String current_date="";
	String pract_id_diag = "";
	String pract_id_goal = "";
	String sql = "";
	// Added on nov 11 2005
	String termCodeMsrid="";
	String termCodeMsrDesc="";
	String termCodeMsrsql="";

	String goalMsrid="";
	String goalMsrDesc="";
	String goalMsrsql="";
	//end 
	int k = 1;
	int view_cnt = 0;
	String view_count_sql = "select count(*) from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ? and status = 'V'";
	sql = "select a.LAST_EVAL_TERM_CODE_MSR_ID,c.LAST_EVAL_GOAL_MSR_ID,a.term_set_id termsetid,a.term_code termcode,a.term_code_srl_no term_code_srl_no,b.short_desc||'('||a.term_set_id||')' diag_desc,f.progress_percent last_diag_prog_pct,c.goal_code goalcode,a.last_eval_by pract_id_diag,c.last_eval_by pract_id_goal,c.goal_srl_no goal_srl_no,d.short_desc goal_desc,g.progress_percent last_goal_prog_pct,a.status diag_status, c.status goal_status,to_char(a.target_date,'dd/mm/yyyy') diag_target_date,to_char(c.goal_target_date,'dd/mm/yyyy') goal_target_date from cp_pat_care_plan_term_code a, mr_term_code b,cp_pat_care_plan_goal c, cp_outcome d,cp_pat_term_code_eval f,cp_pat_goal_eval g where a.md_care_plan_id = ? and a.care_plan_id = ? and a.appl_yn = 'Y' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and c.md_care_plan_id = ? and c.care_plan_id = ? and c.term_set_id = a.term_set_id and c.term_code = a.term_code and c.appl_yn = 'Y' and d.outcome_code = c.goal_code and f.md_care_plan_id = a.md_care_plan_id(+) and f.care_plan_id = a.care_plan_id(+) and f.eval_id = ? and  g.md_care_plan_id = a.md_care_plan_id and g.care_plan_id = a.care_plan_id and g.eval_id = ? order by a.term_set_id,a.term_code,c.goal_code";

	String  sql_curent_date = "select to_char(sysdate,'dd/mm/yyyy hh24:mi') cur_date from dual ";

	con = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement(view_count_sql);
	stmt.setString(1,md_plan_id);
	stmt.setString(2,care_plan_id);
	rs_view_cnt = stmt.executeQuery();
	if(rs_view_cnt != null)
		if(rs_view_cnt.next())
			view_cnt = rs_view_cnt.getInt(1);
	if(rs_view_cnt!=null) rs_view_cnt.close();
	if(stmt!=null) stmt.close();
	stmt = con.prepareStatement(sql_curent_date);
	rs	=	stmt.executeQuery();
	while((rs!= null)&&rs.next())
	{
		current_date=rs.getString("cur_date");
	}
	if(rs != null) rs.close();
	if(stmt!=null) stmt.close();
	stmt = con.prepareStatement(sql);
	stmt.setString(1,md_plan_id);
	stmt.setString(2,care_plan_id);
	stmt.setString(3,md_plan_id);
	stmt.setString(4,care_plan_id);
	stmt.setString(5,eval_id);
	stmt.setString(6,eval_id);


	rs = stmt.executeQuery();
%>
</head>
<body OnMouseDown='CodeArrest()'>
<form name='view_cp_diagandgoallist' id='view_cp_diagandgoallist' target='blankFrame' method='post' action="">
<table border="0" cellpadding="1" cellspacing="0" width="100%" align='center' id="DiagGoalTable">
	<tr>
		<td class='ITRVNHDR' colspan='2' width='30%' align='left'><B>Diagnosis</B></th>
		<td class='ITRVNHDR' width='23%' align='left'><B>Target Date</B></th>
		<td class='ITRVNHDR' width='7%'>&nbsp;</td>
		<td class='ITRVNHDR' colspan='30' align='left'><B>Evaluation Score</B></th>
		<td class='ITRVNHDR' width='5%' colspan='2' nowrap align='left'></th>
		
	</tr>
<%
	if(rs!=null)
	{
		int i = 1;
		while(rs.next())
		{	
			if((!term_set_id.equals(rs.getString("termsetid")))||(!term_code.equals(rs.getString("termcode"))))
			{
					diag_pct = Integer.parseInt(rs.getString("last_diag_prog_pct")==null?"104":rs.getString("last_diag_prog_pct"));
					term_code = rs.getString("termcode");
					term_set_id = rs.getString("termsetid");
					termcodeDesc=rs.getString("diag_desc");
					termCodeMsrid=rs.getString("LAST_EVAL_TERM_CODE_MSR_ID")==null?"":rs.getString("LAST_EVAL_TERM_CODE_MSR_ID");
					if(!termCodeMsrid.equals("")){
						termCodeMsrsql ="Select TERM_CODE_MSR_DESC from CP_TERM_CODE_MSR where TERM_SET_ID='"+term_set_id+"' and TERM_CODE='"+term_code+"'and  TERM_CODE_MSR_ID='"+termCodeMsrid+"'";
						stmt_termCode_msr_id 	=	con.createStatement();
						rs_termCode_msr_id 	=	stmt_termCode_msr_id .executeQuery(termCodeMsrsql);
						if(rs_termCode_msr_id !=null){
							rs_termCode_msr_id .next();
							termCodeMsrDesc =rs_termCode_msr_id .getString("TERM_CODE_MSR_DESC");
						}
					}
					if(rs_termCode_msr_id!=null) rs_termCode_msr_id.close();
                	if(stmt_termCode_msr_id!=null) stmt_termCode_msr_id.close();
					    out.println("<tr height='3px'>");
						out.println("<td colspan='2' width='30%' class='CLASHEAD'><B>"+termcodeDesc+"</B></td>");
						out.println("<td class='CLASHEAD' width='23%'><B>"+rs.getString("diag_target_date")+"</B></td>");
						out.println("<td class='CLASHEAD' width='10%'>&nbsp;</td>");
						if((rs.getString("diag_status").equals("9"))||(rs.getString("diag_status").equals("D"))||(rs.getString("diag_status").equals("R")))
							evaluation_allowed_yn = "N";
						else
							evaluation_allowed_yn = "Y";
						if(evaluation_allowed_yn .equals("N"))
						{
							 onclickwork_diag = "";
							 onclickwork_goal = "";
							 onclickchgcolorfr = "";
							 onclickchgcolorfr_goal = "";
							 onclickchgcolorbac = "";
							 onclickchgcolorbac_goal = "";
						}
						else
						{
							 onclickwork_diag = "valfix";
							 onclickwork_goal = "valfix";
							 onclickchgcolorfr = "colorcgfront";
							 onclickchgcolorfr_goal = "colorcgfront";
							 onclickchgcolorbac = "colorcgback";
							 onclickchgcolorbac_goal = "colorcgback";
						}
						 onclickwork_diag = "";
						 onclickwork_goal = "";
						 onclickchgcolorfr = "";
						 onclickchgcolorfr_goal = "";
						 onclickchgcolorbac = "";
						 onclickchgcolorbac_goal = "";
					
						if(diag_pct==0)
							out.println("<td class='CLASSHEADVAL' style='color:red' onclick="+onclickwork_diag+"(00,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1');"+onclickchgcolorfr+"(this) width='1%' id='id1"+i+"'><B>[</B></td>");
						else
							out.println("<td class='CLASSHEADVAL' onclick="+onclickwork_diag+"(00,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1');"+onclickchgcolorfr+"(this) width='1%' id='id1"+i+"'><B>[</B></td>");
						if(diag_pct==4)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id2"+i+"' onclick="+onclickwork_diag+"(04,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id2"+i+"' onclick="+onclickwork_diag+"(04,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==8)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id3"+i+"' onclick="+onclickwork_diag+"(08,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id3"+i+"' onclick="+onclickwork_diag+"(08,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==12)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id4"+i+"' onclick="+onclickwork_diag+"(12,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id4"+i+"' onclick="+onclickwork_diag+"(12,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==16)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id5"+i+"' onclick="+onclickwork_diag+"(16,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id5"+i+"' onclick="+onclickwork_diag+"(16,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==20)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id6"+i+"' onclick="+onclickwork_diag+"(20,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id6"+i+"' onclick="+onclickwork_diag+"(20,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==24)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id7"+i+"' onclick="+onclickwork_diag+"(24,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id7"+i+"' onclick="+onclickwork_diag+"(24,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==28)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id8"+i+"' onclick="+onclickwork_diag+"(28,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id8"+i+"' onclick="+onclickwork_diag+"(28,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==32)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id9"+i+"' onclick="+onclickwork_diag+"(32,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id9"+i+"' onclick="+onclickwork_diag+"(32,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==36)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id10"+i+"' onclick="+onclickwork_diag+"(36,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id10"+i+"' onclick="+onclickwork_diag+"(36,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==40)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id11"+i+"' onclick="+onclickwork_diag+"(40,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id11"+i+"' onclick="+onclickwork_diag+"(40,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==44)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id12"+i+"' onclick="+onclickwork_diag+"(44,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id12"+i+"' onclick="+onclickwork_diag+"(44,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==48)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id13"+i+"' onclick="+onclickwork_diag+"(48,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id13"+i+"' onclick="+onclickwork_diag+"(48,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==52)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id14"+i+"' onclick="+onclickwork_diag+"(52,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id14"+i+"' onclick="+onclickwork_diag+"(52,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==56)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id15"+i+"' onclick="+onclickwork_diag+"(56,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id15"+i+"' onclick="+onclickwork_diag+"(56,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==60)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id16"+i+"' onclick="+onclickwork_diag+"(60,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id16"+i+"' onclick="+onclickwork_diag+"(60,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==64)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id17"+i+"' onclick="+onclickwork_diag+"(64,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id17"+i+"' onclick="+onclickwork_diag+"(64,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==68)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id18"+i+"' onclick="+onclickwork_diag+"(68,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id18"+i+"' onclick="+onclickwork_diag+"(68,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==72)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id19"+i+"' onclick="+onclickwork_diag+"(72,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id19"+i+"' onclick="+onclickwork_diag+"(72,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==76)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id20"+i+"' onclick="+onclickwork_diag+"(76,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id20"+i+"' onclick="+onclickwork_diag+"(76,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==80)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id21"+i+"' onclick="+onclickwork_diag+"(80,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id21"+i+"' onclick="+onclickwork_diag+"(80,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==84)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id22"+i+"' onclick="+onclickwork_diag+"(84,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id22"+i+"' onclick="+onclickwork_diag+"(84,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==88)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id23"+i+"' onclick="+onclickwork_diag+"(88,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id23"+i+"' onclick="+onclickwork_diag+"(88,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==92)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id24"+i+"' onclick="+onclickwork_diag+"(92,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id24"+i+"' onclick="+onclickwork_diag+"(92,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==96)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id25"+i+"' onclick="+onclickwork_diag+"(96,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id25"+i+"' onclick="+onclickwork_diag+"(96,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==100){
							termcodemsrlookupdisabled ="disabled";
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' style='color:#1AFF1A' id='id26"+i+"' onclick="+onclickwork_diag+"(100,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1');"+onclickchgcolorbac+"(this)><B>]</B></td>");
						}else{
							termcodemsrlookupdisabled ="";
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id26"+i+"' onclick="+onclickwork_diag+"(100,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1');"+onclickchgcolorbac+"(this)><B>]</B></td>");
						}
						out.println("<td class='CLASSHEADVAL' width='1%'>&nbsp;</td>");
						pract_id_diag = rs.getString("pract_id_diag")==null?"":rs.getString("pract_id_diag");
						if(!pract_id_diag.equals(""))
							out.println("<td class='CLASSHEADVAL' width='1%'onclick='showDiagHistory(\"error_mode\",\""+rs.getString("termsetid")+"\",\""+rs.getString("termcode")+"\",\""+rs.getString("term_code_srl_no")+"\",\""+rs.getString("diag_desc")+"\");'><B>H</B></td>");
						else
							out.println("<td class='CLASSHEADVAL' width='1%'>&nbsp;</td>");
						out.println("<td class='CLASHEAD' colspan='2'>&nbsp;</td>");

						out.println("<td class='CLASSHEADVAL' colspan='2' width='10%' align='center' id='id27"+i+"' onclick=resetval(this,"+diag_pct+","+diag_count+",'Diag')><B>&nbsp;</B></td>");

					out.println("</tr>");
					// For DB action these vales are put into hidden fields.
					out.println("<input type='hidden' name='term_set_id_diag"+diag_count+"' id='term_set_id_diag"+diag_count+"' value='"+rs.getString("termsetid")+"'>");
					out.println("<input type='hidden' name='term_code_diag"+diag_count+"' id='term_code_diag"+diag_count+"' value='"+rs.getString("termcode")+"'>");
					out.println("<input type='hidden' name='term_code_srl_no_diag"+diag_count+"' id='term_code_srl_no_diag"+diag_count+"' value='"+rs.getString("term_code_srl_no")+"'>");
					out.println("<input type='hidden' name='dx_prog_pct"+diag_count+"' id='dx_prog_pct"+diag_count+"'>");
					out.println("<input type='hidden' name='diag_status"+diag_count+"' id='diag_status"+diag_count+"' value='"+rs.getString("diag_status")+"'>");
					out.println("<input type='hidden' name='evaluation_allowed_diag_yn"+diag_count+"' id='evaluation_allowed_diag_yn"+diag_count+"' value='"+evaluation_allowed_yn+"'>");
					out.println("<input type='hidden' name='evaluated_diag_yn"+diag_count+"' id='evaluated_diag_yn"+diag_count+"'>");
					out.println("<input type='hidden' name='tempidvaldiag"+diag_count+"' id='tempidvaldiag"+diag_count+"'>");
					out.println("<input type='hidden' name='DiagmsrID"+diag_count+"' id='DiagmsrID"+diag_count+"' value='"+termCodeMsrid+"'>");
					diag_count++;
					//End.
					
					goal_code = "";
					i++;
			}
			if(!goal_code.equals(rs.getString("goalcode")))
			{
				goal_pct = Integer.parseInt(rs.getString("last_goal_prog_pct")==null?"104":rs.getString("last_goal_prog_pct"));
				goal_code = rs.getString("goalcode");
				goal_desc=rs.getString("goal_desc");
				goalMsrid =rs.getString("LAST_EVAL_GOAL_MSR_ID")==null?"":rs.getString("LAST_EVAL_GOAL_MSR_ID");
				if(!goalMsrid .equals("")){
					goalMsrsql ="Select OUTCOME_MSR_DESC from CP_OUTCOME_MSR where OUTCOME_MSR_ID='"+goalMsrid+"' and OUTCOME_CODE='"+goal_code+"'";
					stmt_goal_msr_id  	=	con.createStatement();
					rs_goal_msr_id  	=	stmt_goal_msr_id  .executeQuery(goalMsrsql);
					if(rs_goal_msr_id  !=null){
						rs_goal_msr_id  .next();
						goalMsrDesc  =rs_goal_msr_id  .getString("OUTCOME_MSR_DESC");
					}
				}
					if(rs_goal_msr_id!=null) rs_goal_msr_id.close();
					if(stmt_goal_msr_id!=null) stmt_goal_msr_id.close();
				out.println("<tr height='3px'>");
					out.println("<td class='FONTSTYL' width='5%'>&nbsp;</td>");
					out.println("<td class='FONTVALHYPER' onclick=callintvnandoutcomepg('"+care_plan_id+"','"+md_plan_id+"','"+rs.getString("termsetid")+"','"+rs.getString("termcode")+"','"+rs.getString("goalcode")+"','"+eval_id+"') width='50%'>"+goal_desc+"</td>");
					if((rs.getString("goal_status").equals("9"))||(rs.getString("goal_status").equals("D"))||(rs.getString("goal_status").equals("A"))||(rs.getString("goal_status").equals("N")))
						evaluation_allowed_goal_yn = "N";
					else if((rs.getString("diag_status").equals("9"))||(rs.getString("diag_status").equals("D"))||(rs.getString("diag_status").equals("R")))
						evaluation_allowed_goal_yn = "N";
					else
						evaluation_allowed_goal_yn = "Y";
					out.println("<td width='23%' class='FONTSTYL'>"+rs.getString("goal_target_date")+"</td>");
					out.println("<td class='FONTSTYL' width='10%'>&nbsp;</td>");
					if(evaluation_allowed_goal_yn .equals("N"))
					{
						 onclickwork_goal = "";
						 onclickchgcolorfr_goal = "";
						 onclickchgcolorbac_goal = "";
					}
					else
					{
						 onclickwork_goal = "valfix";
						 onclickchgcolorfr_goal = "colorcgfront";
						 onclickchgcolorbac_goal = "colorcgback";
					}
					 onclickwork_goal = "";
					 onclickchgcolorfr_goal = "";
					 onclickchgcolorbac_goal = "";

					if(goal_pct==0)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' id='ids1"+k+"' style='color:red' onclick="+onclickwork_goal+"(00,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1');"+onclickchgcolorfr_goal+"(this) width='1%'><B>[</B></td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' id='ids1"+k+"' onclick="+onclickwork_goal+"(00,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1');"+onclickchgcolorfr_goal+"(this) width='1%'><B>[</B></td>");
					if(goal_pct==4)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids2"+k+"' onclick="+onclickwork_goal+"(04,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids2"+k+"' onclick="+onclickwork_goal+"(04,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==8)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids3"+k+"' onclick="+onclickwork_goal+"(08,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids3"+k+"' onclick="+onclickwork_goal+"(08,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==12)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids4"+k+"' onclick="+onclickwork_goal+"(12,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids4"+k+"' onclick="+onclickwork_goal+"(12,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==16)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids5"+k+"' onclick="+onclickwork_goal+"(16,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids5"+k+"' onclick="+onclickwork_goal+"(16,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==20)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids6"+k+"' onclick="+onclickwork_goal+"(20,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids6"+k+"' onclick="+onclickwork_goal+"(20,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==24)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids7"+k+"' onclick="+onclickwork_goal+"(24,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids7"+k+"' onclick="+onclickwork_goal+"(24,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==28)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids8"+k+"' onclick="+onclickwork_goal+"(28,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids8"+k+"' onclick="+onclickwork_goal+"(28,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==32)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids9"+k+"' onclick="+onclickwork_goal+"(32,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids9"+k+"' onclick="+onclickwork_goal+"(32,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==36)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids10"+k+"' onclick="+onclickwork_goal+"(36,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids10"+k+"' onclick="+onclickwork_goal+"(36,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==40)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids11"+k+"' onclick="+onclickwork_goal+"(40,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids11"+k+"' onclick="+onclickwork_goal+"(40,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==44)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids12"+k+"' onclick="+onclickwork_goal+"(44,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids12"+k+"' onclick="+onclickwork_goal+"(44,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==48)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids13"+k+"' onclick="+onclickwork_goal+"(48,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids13"+k+"' onclick="+onclickwork_goal+"(48,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==52)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids14"+k+"' onclick="+onclickwork_goal+"(52,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids14"+k+"' onclick="+onclickwork_goal+"(52,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==56)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids15"+k+"' onclick="+onclickwork_goal+"(56,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids15"+k+"' onclick="+onclickwork_goal+"(56,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==60)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids16"+k+"' onclick="+onclickwork_goal+"(60,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids16"+k+"' onclick="+onclickwork_goal+"(60,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==64)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids17"+k+"' onclick="+onclickwork_goal+"(64,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids17"+k+"' onclick="+onclickwork_goal+"(64,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==68)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids18"+k+"' onclick="+onclickwork_goal+"(68,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids18"+k+"' onclick="+onclickwork_goal+"(68,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==72)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids19"+k+"' onclick="+onclickwork_goal+"(72,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids19"+k+"' onclick="+onclickwork_goal+"(72,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==76)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids20"+k+"' onclick="+onclickwork_goal+"(76,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids20"+k+"' onclick="+onclickwork_goal+"(76,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==80)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids21"+k+"' onclick="+onclickwork_goal+"(80,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids21"+k+"' onclick="+onclickwork_goal+"(80,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==84)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids22"+k+"' onclick="+onclickwork_goal+"(84,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids22"+k+"' onclick="+onclickwork_goal+"(84,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==88)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids23"+k+"' onclick="+onclickwork_goal+"(88,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids23"+k+"' onclick="+onclickwork_goal+"(88,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==92)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids24"+k+"' onclick="+onclickwork_goal+"(92,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids24"+k+"' onclick="+onclickwork_goal+"(92,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==96)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids25"+k+"' onclick="+onclickwork_goal+"(96,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids25"+k+"' onclick="+onclickwork_goal+"(96,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==100){
						goalmsrlookupdisabled ="disabled";
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' style='color:#1AFF1A' width='1%' id='ids26"+k+"' onclick="+onclickwork_goal+"(100,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1');"+onclickchgcolorbac_goal+"(this)><B>]</B></td>");
					}
					else{
						goalmsrlookupdisabled ="";
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids26"+k+"' onclick="+onclickwork_goal+"(100,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1');"+onclickchgcolorbac_goal+"(this)><B>]</B></td>");
					}
					out.println("<td class='FONTVAL' width='1%'>&nbsp;</td>");
					pract_id_goal = rs.getString("pract_id_goal")==null?"":rs.getString("pract_id_goal");
					if(!pract_id_goal.equals(""))
						out.println("<td class='FONTVAL' width='1%' onclick='showGoalHistory(\"error_mode\",\""+rs.getString("termsetid")+"\",\""+rs.getString("termcode")+"\",\""+rs.getString("term_code_srl_no")+"\",\""+rs.getString("goalcode")+"\",\""+rs.getString("goal_srl_no")+"\",\""+rs.getString("goal_desc")+"\",\""+rs.getString("diag_desc")+"\");'>H</td>");
					else
						out.println("<td class='FONTVAL' width='1%'>&nbsp;</td>");
					out.println("<td class='FONTSTYL' colspan='2'>&nbsp;</td>");
					out.println("<td class='FONTVAL' width='10%' colspan='2' id='ids27"+k+"' onclick=resetval(this,"+goal_pct+","+goal_count+",'Goal') align='center'><B>&nbsp;</B></td>");
				//	out.println("<td class='CLASHEAD' colspan='2'>&nbsp;</td>");
				out.println("</tr>");
				// For DB action these vales are put into hidden fields.
				out.println("<input type='hidden' name='term_set_id_goal"+goal_count+"' id='term_set_id_goal"+goal_count+"' value='"+rs.getString("termsetid")+"'>");
				out.println("<input type='hidden' name='term_code_goal"+goal_count+"' id='term_code_goal"+goal_count+"' value='"+rs.getString("termcode")+"'>");
	//			goal_code = rs.getString("goalcode");
				out.println("<input type='hidden' name='term_code_srl_no_goal"+goal_count+"' id='term_code_srl_no_goal"+goal_count+"' value='"+rs.getString("term_code_srl_no")+"'>");
				out.println("<input type='hidden' name='goal_code"+goal_count+"' id='goal_code"+goal_count+"' value='"+rs.getString("goalcode")+"'>");
				out.println("<input type='hidden' name='goal_srl_no"+goal_count+"' id='goal_srl_no"+goal_count+"' value='"+rs.getString("goal_srl_no")+"'>");
				out.println("<input type='hidden' name='goal_status"+goal_count+"' id='goal_status"+goal_count+"' value='"+rs.getString("goal_status")+"'>");
				out.println("<input type='hidden' name='diag_status_for_goal"+goal_count+"' id='diag_status_for_goal"+goal_count+"' value='"+rs.getString("diag_status")+"'>");
				out.println("<input type='hidden' name='goal_prog_pct"+goal_count+"' id='goal_prog_pct"+goal_count+"' value=''>");
				out.println("<input type='hidden' name='evaluation_allowed_goal_yn"+goal_count+"' id='evaluation_allowed_goal_yn"+goal_count+"' value='"+evaluation_allowed_goal_yn+"'>");
				out.println("<input type='hidden' name='evaluation_goal_yn"+goal_count+"' id='evaluation_goal_yn"+goal_count+"' value=''>");
				out.println("<input type='hidden' name='tempidvalgoal"+goal_count+"' id='tempidvalgoal"+goal_count+"'>");
				out.println("<input type='hidden' name='GoalmsrID"+goal_count+"' id='GoalmsrID"+goal_count+"' value='"+goalMsrid+"'>");
				goal_count++;
				// End.
				k++;
			}
			termCodeMsrDesc="";
			goalMsrDesc="";
		}
			if(rs!=null) rs.close();
        	if(stmt!=null) stmt.close();
	}
}
catch(Exception e)
{
	e.printStackTrace(System.err);
	System.out.println("Exception in ViewCarePlanDiagAndGoalList.jsp="+e.toString());
}
finally
{
	if(rs_termCode_msr_id!=null) rs_termCode_msr_id.close();
	if(stmt_termCode_msr_id!=null) stmt_termCode_msr_id.close();
	if(rs_goal_msr_id!=null) rs_goal_msr_id.close();
	if(stmt_goal_msr_id!=null) stmt_goal_msr_id.close();
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}
%>
	<tr>
		<td id='dynacreation_outcome' colspan='36'>&nbsp;</td>
	</tr>
</table>
<INPUT TYPE="hidden" name="diag_count" id="diag_count" value="<%=diag_count%>">
<INPUT TYPE="hidden" name="goal_count" id="goal_count" value="<%=goal_count%>">
<INPUT TYPE="hidden" name="outcome_count" id="outcome_count" value="">
<INPUT TYPE="hidden" name="care_plan_id" id="care_plan_id" value="<%=care_plan_id%>">
<INPUT TYPE="hidden" name="md_plan_id" id="md_plan_id" value="<%=md_plan_id%>">
<INPUT TYPE="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<INPUT TYPE="hidden" name="care_manager" id="care_manager" value="<%=care_mgr_name%>">
<input type="hidden" name="pract_id" id="pract_id" value='<%=p_pract_id%>'>
<input type="hidden" name="encounter_id" id="encounter_id" value='<%=encounter_id%>'>
</form>
</body>
</html>

