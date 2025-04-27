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
*	Created On		:	21 Mar 2005
--%>
<html>
<head>

<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
//This file is saved on 19/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/CommonCalendar.js" type="text/javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
<script src="../../eCP/js/EvaluateCarePlanMarkError.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String facilty_id = request.getParameter("facilty_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");;
	String p_patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
	String p_care_mgr_id = request.getParameter("p_care_manager_id")==null?"":request.getParameter("p_care_manager_id");
	String p_t_set_id = request.getParameter("p_term_set_id")==null?"":request.getParameter("p_term_set_id");
	String p_t_code = request.getParameter("p_term_code")==null?"":request.getParameter("p_term_code");
	String view_plans = request.getParameter("view_plans")==null?"":request.getParameter("view_plans");
	String view_summary = request.getParameter("view_summary")==null?"":request.getParameter("view_summary");
	String p_fr_date = 
	request.getParameter("p_fr_date")==null?"":request.getParameter("p_fr_date");
	String p_to_date = 
	request.getParameter("p_to_date")==null?"":request.getParameter("p_to_date");
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_cnt = null;
	PreparedStatement pstmt_diag_goal = null;
	PreparedStatement pstmt_intvn = null;
	PreparedStatement pstmt_outcome = null;
	ResultSet rs = null;
	ResultSet rs_cnt = null;
	ResultSet rs_diag_goal = null;
	ResultSet rs_intvn = null;
	ResultSet rs_outcome = null;
%>
<body OnMouseDown='CodeArrest()'>
<form name='eval_cp_result' id='eval_cp_result'>
<input type=hidden name=encounter_id value='<%=encounter_id%>'>
<input type=hidden name=facilty_id value='<%=facilty_id%>'>
<input type=hidden name=p_care_mgr_id value='<%=p_care_mgr_id%>'>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<%
try
{
con = ConnectionManager.getConnection(request);

String tempString = "";	
String tempStrings = "";
String error_status = "";
String status_sql = "";
String eval_font = "";
String eval_title = "";
String rev_font = "";
String rev_title = "";
String task_font = "";
String task_title = "";
if(view_plans.equals("L"))
	status_sql = "(a.current_status in('O','F','C','D','9') or b.status in ('O','R','D','9'))";
else if(view_plans.equals("A"))
	status_sql = "(a.current_status = 'O' or b.status = 'O')";
// Queries
String eval_count_sql = "select count(*) from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ?";
String rev_count_sql = "select count(*) from cp_pat_care_plan_revision where md_care_plan_id = ? and care_plan_id = ?";
//String sql_result = "select a.md_care_plan_id md_plan_id,a.care_plan_id plan_id, b.term_set_id term_set_id,b.term_code term_code, c.short_desc diag_desc,d.practitioner_name care_manager_name,	to_char(a.last_eval_datetime,'dd/mm/yyyy hh24:mi') last_eval_date_time,to_char(a.last_revision_date_time,'dd/mm/yyyy hh24:mi') last_revision_date_time,e.short_name eval_by_name,g.short_name rev_by_name, a.patient_id patient_id, f.patient_name pat_name, decode(f.sex,'F','Female','M','Male','U','Unknown') pat_sex,	get_age(f.date_of_birth) pat_age, to_char(a.CARE_PLAN_START_DATE,'dd/mm/yyyy hh24:mi') cp_start_date, to_char(a.CARE_PLAN_TARGET_DATE,'dd/mm/yyyy hh24:mi') cp_target_date,h.status error_status,h.eval_id,decode(sign(trunc(sysdate) - trunc(a.care_plan_start_date) ),0,1,1,(trunc(sysdate) - trunc(a.care_plan_start_date))+1) cp_day_no,a.current_status current_status FROM cp_pat_care_plan a, cp_pat_care_plan_term_code b,	mr_term_code c, am_practitioner d, am_practitioner e, mp_patient f, am_practitioner g,cp_pat_care_plan_eval h where a.patient_id = ? and a.current_facility_id = ? and (? is null or a.current_care_manager_id = ? ) and a.care_plan_start_date between nvl(to_date(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date) and (nvl(to_date(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date)+1)  and ( (? is null and ? is null) or ( exists (select 1 from cp_pat_care_plan_term_code  where md_care_plan_id = a.md_care_plan_id and care_plan_id = a.care_plan_id and (? is null or term_set_id = ?) and (? is null or term_code = ?) ) ) ) and b.md_care_plan_id = a.md_care_plan_id and h.md_care_plan_id(+) = a.md_care_plan_id and b.care_plan_id = a.care_plan_id and h.care_plan_id(+) = a.care_plan_id and	b.appl_yn = 'Y' and "+status_sql+" and	c.term_set_id = b.term_set_id and c.term_code = b.term_code  and	d.practitioner_id(+) = a.current_care_manager_id and e.practitioner_id(+) = a.last_eval_by and g.practitioner_id(+) = a.last_revision_pract_id and f.patient_id = a.patient_id order by patient_id, a.care_plan_id,b.term_code,h.eval_id desc";
String sql_result = "SELECT a.md_care_plan_id md_plan_id,a.care_plan_id plan_id, b.term_set_id term_set_id,b.term_code term_code, c.short_desc diag_desc,d.practitioner_name care_manager_name,	TO_CHAR(a.last_eval_datetime,'dd/mm/yyyy hh24:mi') last_eval_date_time,TO_CHAR(a.last_revision_date_time,'dd/mm/yyyy hh24:mi') last_revision_date_time,e.short_name eval_by_name,g.short_name rev_by_name, a.patient_id patient_id, f.patient_name pat_name,f.sex pat_sex,	get_age(f.date_of_birth) pat_age, TO_CHAR(a.CARE_PLAN_START_DATE,'dd/mm/yyyy hh24:mi') cp_start_date, TO_CHAR(a.CARE_PLAN_TARGET_DATE,'dd/mm/yyyy hh24:mi') cp_target_date,h.status error_status,h.eval_id,DECODE(SIGN(TRUNC(SYSDATE) - TRUNC(a.care_plan_start_date) ),0,1,1,(TRUNC(SYSDATE) - TRUNC(a.care_plan_start_date))+1) cp_day_no,a.current_status current_status FROM cp_pat_care_plan a, cp_pat_care_plan_term_code b,	mr_term_code c, am_practitioner_lang_vw d, am_practitioner_lang_vw e, mp_patient f, am_practitioner_lang_vw g,cp_pat_care_plan_eval h WHERE a.patient_id = ? AND a.current_facility_id = ? AND (? IS NULL OR a.current_care_manager_id = ? ) AND a.care_plan_start_date BETWEEN NVL(TO_DATE(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date) AND (NVL(TO_DATE(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date)+1)  AND ( (? IS NULL AND ? IS NULL) OR ( EXISTS (SELECT 1 FROM cp_pat_care_plan_term_code  WHERE md_care_plan_id = a.md_care_plan_id AND care_plan_id = a.care_plan_id AND (? IS NULL OR term_set_id = ?) AND (? IS NULL OR term_code = ?) ) ) ) AND b.md_care_plan_id = a.md_care_plan_id AND h.md_care_plan_id(+) = a.md_care_plan_id AND b.care_plan_id = a.care_plan_id AND h.care_plan_id(+) = a.care_plan_id AND	b.appl_yn = 'Y' AND "+status_sql+" AND	c.term_set_id = b.term_set_id AND c.term_code = b.term_code  AND	d.practitioner_id(+) = a.current_care_manager_id AND e.practitioner_id(+) = a.last_eval_by AND g.practitioner_id(+) = a.last_revision_pract_id AND f.patient_id = a.patient_id AND d.language_id(+) = ? AND e.language_id(+) = ?  AND g.language_id(+) = ? ORDER BY patient_id, a.care_plan_id,b.term_code,h.eval_id DESC";
// Query for Diag and Goal.
//String sql_diag_goal = "select a.term_set_id termsetid,a.term_code termcode,a.term_code_srl_no term_code_srl_no, b.short_desc||'('||a.term_set_id||')' diag_desc,a.last_progress_percent last_diag_prog_pct, c.goal_code goalcode,a.last_eval_by pract_id_diag,c.last_eval_by pract_id_goal,c.goal_srl_no goal_srl_no,d.short_desc goal_desc,c.last_progress_percent last_goal_prog_pct,a.status diag_status, c.status goal_status,to_char(a.target_date,'dd/mm/yyyy') diag_target_date,to_char(c.goal_target_date,'dd/mm/yyyy') goal_target_date from cp_pat_care_plan_term_code a, mr_term_code b,cp_pat_care_plan_goal c, cp_outcome d where a.md_care_plan_id = ? and a.care_plan_id = ? and a.appl_yn = 'Y' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and c.md_care_plan_id = ? and c.care_plan_id = ? and c.term_set_id = a.term_set_id and c.term_code = a.term_code and c.appl_yn = 'Y' and d.outcome_code = c.goal_code order by a.term_set_id,a.term_code,c.goal_code";
String sql_diag_goal = "SELECT a.term_set_id termsetid,a.term_code termcode,a.term_code_srl_no term_code_srl_no, b.short_desc||'('||a.term_set_id||')' diag_desc,a.last_progress_percent last_diag_prog_pct, c.goal_code goalcode,a.last_eval_by pract_id_diag,c.last_eval_by pract_id_goal,c.goal_srl_no goal_srl_no,d.short_desc goal_desc,c.last_progress_percent last_goal_prog_pct,a.status diag_status, c.status goal_status,TO_CHAR(a.target_date,'dd/mm/yyyy') diag_target_date,TO_CHAR(c.goal_target_date,'dd/mm/yyyy') goal_target_date FROM cp_pat_care_plan_term_code a, mr_term_code b,cp_pat_care_plan_goal c, cp_outcome_lang_vw d WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.appl_yn = 'Y' AND b.term_set_id = a.term_set_id AND b.term_code = a.term_code AND c.md_care_plan_id = ? AND c.care_plan_id = ? AND c.term_set_id = a.term_set_id AND c.term_code = a.term_code AND c.appl_yn = 'Y' AND d.outcome_code = c.goal_code AND d.language_id = ? ORDER BY a.term_set_id,a.term_code,c.goal_code";
// end of Diag and Goal Query.
// Query for Intervention and Outcome.
//	String sql_intvn = "select a.term_set_id term_set_id,a.term_code term_code,a.goal_code goal_code,a.group_id group_id_intvn,a.intervention_code intervention_code,b.short_desc intvn_desc,b.lmt_for_tsk_due_bf_st_tm,b.lmt_for_tsk_due_bf_st_tm_unit,       b.lmt_for_tsk_odue_af_st_tm,b.lmt_for_tsk_odue_af_st_tm_unit,       b.lmt_for_tsk_exp_af_end_tm,b.lmt_for_tsk_exp_af_end_tm_unit,decode(a.status,'O','Pending','D','Discontinued','9','Cancelled','P','Partially Completed','A','Achieved','N','Not Achieved') status from cp_pat_care_plan_intvn a, ca_intervention b where a.md_care_plan_id = ? and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code) and a.appl_yn = 'Y' and b.intervention_code = a.intervention_code order by a.term_set_id,a.term_code,a.group_id,a.intervention_code";
	String sql_intvn = "SELECT a.term_set_id term_set_id,a.term_code term_code,a.goal_code goal_code,a.group_id group_id_intvn,a.intervention_code intervention_code,b.short_desc intvn_desc,b.lmt_for_tsk_due_bf_st_tm,b.lmt_for_tsk_due_bf_st_tm_unit,       b.lmt_for_tsk_odue_af_st_tm,b.lmt_for_tsk_odue_af_st_tm_unit,       b.lmt_for_tsk_exp_af_end_tm,b.lmt_for_tsk_exp_af_end_tm_unit,a.status FROM cp_pat_care_plan_intvn a, ca_intervention_lang_vw b WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = NVL(?,a.term_set_id) AND a.term_code = NVL(?,a.term_code) AND a.goal_code = NVL(?,a.goal_code) AND a.appl_yn = 'Y' AND b.intervention_code = a.intervention_code AND b.language_id = ? ORDER BY a.term_set_id,a.term_code,a.group_id,a.intervention_code";
//	String sql_outcome = "select a.term_set_id term_set_id,a.term_code term_code,a.term_code_srl_no term_code_srl_no,a.goal_code goal_code,a.goal_srl_no goal_srl_no,a.group_id group_id_outcome,a.outcome_code outcome_code,a.outcome_srl_no outcome_srl_no,b.short_desc outcome_desc,a.last_progress_percent outcome_prog_pct,a.status outcome_status,c.status term_code_status, d.status goal_status,a.last_eval_by pract_id_outcome from cp_pat_care_plan_outcome a, cp_outcome b,cp_pat_care_plan_term_code c, cp_pat_care_plan_goal d where a.md_care_plan_id = ?   and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code)   and a.appl_yn = 'Y' and b.outcome_code = a.outcome_code and c.md_care_plan_id = a.md_care_plan_id and c.care_plan_id = a.care_plan_id and c.term_set_id = a.term_set_id   and c.term_code = a.term_code and d.md_care_plan_id = a.md_care_plan_id and d.care_plan_id = a.care_plan_id and d.term_set_id = a.term_set_id and d.term_code = a.term_code and d.goal_code = a.goal_code order by a.term_set_id,a.term_code,a.group_id,a.outcome_code";
	String sql_outcome = "SELECT a.term_set_id term_set_id,a.term_code term_code,a.term_code_srl_no term_code_srl_no,a.goal_code goal_code,a.goal_srl_no goal_srl_no,a.group_id group_id_outcome,a.outcome_code outcome_code,a.outcome_srl_no outcome_srl_no,b.short_desc outcome_desc,a.last_progress_percent outcome_prog_pct,a.status outcome_status,c.status term_code_status, d.status goal_status,a.last_eval_by pract_id_outcome FROM cp_pat_care_plan_outcome a, cp_outcome_lang_vw b,cp_pat_care_plan_term_code c, cp_pat_care_plan_goal d WHERE a.md_care_plan_id = ?   AND a.care_plan_id = ? AND a.term_set_id = NVL(?,a.term_set_id) AND a.term_code = NVL(?,a.term_code) AND a.goal_code = NVL(?,a.goal_code)   AND a.appl_yn = 'Y' AND b.outcome_code = a.outcome_code AND b.language_id = ? AND c.md_care_plan_id = a.md_care_plan_id AND c.care_plan_id = a.care_plan_id AND c.term_set_id = a.term_set_id   AND c.term_code = a.term_code AND d.md_care_plan_id = a.md_care_plan_id AND d.care_plan_id = a.care_plan_id AND d.term_set_id = a.term_set_id AND d.term_code = a.term_code AND d.goal_code = a.goal_code ORDER BY a.term_set_id,a.term_code,a.group_id,a.outcome_code";

	// End of Intervention and Outcome Queries.
	// End of Queries.
	pstmt=con.prepareStatement(sql_result);//,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt.setString(1,p_patient_id);
	pstmt.setString(2,facilty_id);
	pstmt.setString(3,p_care_mgr_id);
	pstmt.setString(4,p_care_mgr_id);
	pstmt.setString(5,p_fr_date);
	pstmt.setString(6,p_to_date);
	pstmt.setString(7,p_t_set_id);
	pstmt.setString(8,p_t_code);
	pstmt.setString(9,p_t_set_id);
	pstmt.setString(10,p_t_set_id);
	pstmt.setString(11,p_t_code);
	pstmt.setString(12,p_t_code);
	pstmt.setString(13,locale);
	pstmt.setString(14,locale);
	pstmt.setString(15,locale);
	rs=pstmt.executeQuery();

	String intvn_desc = "";
	String achv_pct = "";
	String notachv_pct = "";
	String achv_notachv_pct = "";
	String classvalue = "";
	String last_eval_date_time = "";
	String last_revision_date_time = "";
	String eval_by_name = "";
	String rev_by_name = "";
	String patient_id = "";
	String plan_id = "";
	String care_mgr = "";
	String eval_cnts = "";
	String rev_cnts = "";
	String term_set_id = "";
	String term_code = "";
	String goal_code = "";
	String Intvnkey = "";
	String outcomekey = "";
	String ItermSet = "";
	String ItermCode = "";
	String Igrpid = "";
	String IDesc = "";
	String Istatus = "";
	String Icode = "";
	String Icode_val = "";
	String otermSet = "";
	String otermCode = "";
	String ogrpid = "";
	String outcome_desc = "";
	String outcome_hyp = "";
	String markerror = "";
	String markerrortitle = "";
	String disp_style = "";
	String disp_font = "-";
	String disp_summary = "";
	String current_status = "";
	StringBuffer diag_percentage = new StringBuffer();
	StringBuffer goal_percentage = new StringBuffer();
	StringBuffer outcome_percentage = new StringBuffer();
	String callvar = "";
	String hand = "";
	String clr = "";
	int diag_pct = 0;
	int goal_pct = 0;
	int outcome_pct = 0;
	int i=1;
	int k=0;
	int eval_cnt=0;
	int rev_cnt=0;
	int diag_cnt = 0;
	int goal_cnt = 0;
	int outcome_cnt = 0;
	//int maxRecord=0;
	HashMap record = new HashMap();
	ArrayList result = null;
	if(view_summary.equals("S"))
	{
		disp_style = "none";
		disp_font = "&nbsp;";
	}
	int count=0;

		
	
	if(rs!=null )
	{
		while(rs.next())
		{	count++;
			care_mgr = rs.getString("care_manager_name")==null?"&nbsp":rs.getString("care_manager_name");
			last_eval_date_time = rs.getString("last_eval_date_time")==null?"&nbsp;":com.ehis.util.DateUtils.convertDate(rs.getString("last_eval_date_time"),"DMYHM","en",locale);
			last_revision_date_time = rs.getString("last_revision_date_time")==null?"&nbsp;":com.ehis.util.DateUtils.convertDate(rs.getString("last_revision_date_time"),"DMYHM","en",locale);
			eval_by_name = rs.getString("eval_by_name")==null?"&nbsp;":rs.getString("eval_by_name");
			rev_by_name = rs.getString("rev_by_name")==null?"&nbsp;":rs.getString("rev_by_name");
			current_status = rs.getString("current_status");
			pstmt_cnt = con.prepareStatement(eval_count_sql);
			pstmt_cnt.setString(1,rs.getString("md_plan_id"));
			pstmt_cnt.setString(2,rs.getString("plan_id"));
			rs_cnt = pstmt_cnt.executeQuery();
			if(rs_cnt!=null)
				if(rs_cnt.next())
					eval_cnt = rs_cnt.getInt(1);
			if(rs_cnt!=null) rs_cnt.close(); 
			if(pstmt_cnt!=null) pstmt_cnt.close();
			if(eval_cnt==0)
			{
				eval_cnts = eval_cnt+"";
				eval_cnts = "&nbsp;";
				markerrortitle = "";
				markerror = "&nbsp;";
				callvar = "";
				hand = "";
				clr = "#00009D";
			}
			else
			{
				eval_cnts = eval_cnt+"";
				markerrortitle = "Mark Error";
				markerror = "X";
				callvar = "callvar";
				hand = "hand";
				clr = "blue";
			}
			error_status = rs.getString("error_status")==null?"":rs.getString("error_status");
			if(current_status.equals("O"))
			{
				eval_font = "E";
				eval_title = "Evaluate Plan";
				rev_font = "R";
				rev_title = "Revise Plan";
				task_font = "T";
				task_title = "Task List";
				if(error_status.equals("E"))
				{
					markerrortitle = "";
					markerror = "&nbsp;";
				}
			}
			else 
			{
				eval_font = "&nbsp;";
				rev_font = "&nbsp;";
				task_font = "&nbsp;";
				markerrortitle = "";
				eval_title = "";
				rev_title = "";
				markerror = "&nbsp;";
				task_title = "";
			}
			pstmt_cnt = con.prepareStatement(rev_count_sql);
			pstmt_cnt.setString(1,rs.getString("md_plan_id"));
			pstmt_cnt.setString(2,rs.getString("plan_id"));
			rs_cnt = pstmt_cnt.executeQuery();
			if(rs_cnt!=null)
				if(rs_cnt.next())
					rev_cnt = rs_cnt.getInt(1);
			if(rs_cnt!=null) rs_cnt.close(); 
			if(pstmt_cnt!=null) pstmt_cnt.close();
			if(rev_cnt==0)
			{
				rev_cnts = rev_cnt+"";
				rev_cnts = "&nbsp;";
			}
			else
				rev_cnts = rev_cnt+"";
			pstmt_diag_goal = con.prepareStatement(sql_diag_goal);
			pstmt_diag_goal.setString(1,rs.getString("md_plan_id"));
			pstmt_diag_goal.setString(2,rs.getString("plan_id"));
			pstmt_diag_goal.setString(3,rs.getString("md_plan_id"));
			pstmt_diag_goal.setString(4,rs.getString("plan_id"));
			pstmt_diag_goal.setString(5,locale);
			rs_diag_goal = pstmt_diag_goal.executeQuery();
			
			if(p_patient_id.equals(""))
			{
				if(!patient_id.equals(rs.getString("patient_id")))
				{
					i =1;
					patient_id = rs.getString("patient_id");
					String patSex=rs.getString("pat_sex");
					if(patSex.equals("F"))
						patSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					if(patSex.equals("M"))
						patSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					if(patSex.equals("U"))
						patSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					out.println("<tr height='5px'>");
						out.println("<td class='CLASSVAL' colspan='5' align='left'>"+rs.getString("patient_id")+","+rs.getString("pat_name")+","+rs.getString("pat_age")+","+patSex+"</td>");
					out.println("</tr>");
				}
			}
			
			//out.println("<tr height='3px'>");
				if(!plan_id.equals(rs.getString("plan_id")))
				{
					if(view_summary.equals("S"))
					{
						if(!disp_summary.equals("S"))
						{
%>
							<tr height='5px'>
								<td align='center' class=CLASSHEAD width='1%'>&nbsp;</td>
								<td align='center' class=CLASSHEAD width='7%'><fmt:message key="eCP.PlanNo.label" bundle="${cp_labels}"/></td>
								<td align='left' class=CLASSHEAD width='23%'><fmt:message key="eCP.CareManager.label" bundle="${cp_labels}"/></td>
								<td align='left' class=CLASSHEAD width='2%'>&nbsp;</td>
								<td align='left' class=CLASSHEAD width='2%'>&nbsp;</td>
								<td align='left' class=CLASSHEAD width='2%'>&nbsp;</td>
								<td align='left' class=CLASSHEAD width='2%'>&nbsp;</td>
								<td align='right' class=CLASSHEAD width='3%'><fmt:message key="eCP.R.label" bundle="${cp_labels}"/>&nbsp;</td>
								<td align='left' class=CLASSHEAD  width='14%'><fmt:message key="eCP.LastRevision.label" bundle="${cp_labels}"/></td>
								<td class=CLASSHEAD width="15%"><fmt:message key="Common.revisedby.label" bundle="${common_labels}"/></td>
								<td align='left' class=CLASSHEAD width='3%'><fmt:message key="eCP.E.label" bundle="${cp_labels}"/></td>
								<td align='left' class=CLASSHEAD width="14%"><fmt:message key="eCP.LastEvaluation.label" bundle="${cp_labels}"/></td>
								<td align='left' class=CLASSHEAD width='15%' colspan='2'><fmt:message key="eCP.EvaluatedBy.label" bundle="${cp_labels}"/></td>
							</tr>
<%		
							disp_summary = "S";
						}
					}
					else
					{
%>
						<tr height='5px'>
							<td align='center' class=CLASSHEAD width='1%'>&nbsp;</td>
							<td align='center' class=CLASSHEAD width='7%'><fmt:message key="eCP.PlanNo.label" bundle="${cp_labels}"/></td>
							<td align='left' class=CLASSHEAD width='23%'><fmt:message key="eCP.CareManager.label" bundle="${cp_labels}"/></td>
							<td align='left' class=CLASSHEAD width='2%'>&nbsp;</td>
							<td align='left' class=CLASSHEAD width='2%'>&nbsp;</td>
							<td align='left' class=CLASSHEAD width='2%'>&nbsp;</td>
							<td align='left' class=CLASSHEAD width='2%'>&nbsp;</td>
							<td align='right' class=CLASSHEAD width='3%'><fmt:message key="eCP.R.label" bundle="${cp_labels}"/>&nbsp;</td>
							<td align='left' class=CLASSHEAD  width='14%'><fmt:message key="eCP.LastRevision.label" bundle="${cp_labels}"/></td>
							<td class=CLASSHEAD width="15%"><fmt:message key="Common.revisedby.label" bundle="${common_labels}"/></td>
							<td align='left' class=CLASSHEAD width='3%'><fmt:message key="eCP.E.label" bundle="${cp_labels}"/></td>
							<td align='left' class=CLASSHEAD width="14%"><fmt:message key="eCP.LastEvaluation.label" bundle="${cp_labels}"/></td>
							<td align='left' class=CLASSHEAD width='15%' colspan='2'><fmt:message key="eCP.EvaluatedBy.label" bundle="${cp_labels}"/></td>
						</tr>
<%
					}
				tempString = java.net.URLEncoder.encode(care_mgr);
				plan_id = rs.getString("plan_id");
				out.println("<tr height='5px'>");
				out.println("<td align='center' class='FONTVALHYPERS' width='2%' onclick=rowcompress(this,'"+i+"')><B>"+disp_font+"</B></td>");
				out.println("<td align='center' class='FONTVALS' width='7%'>"+i+"</td>");
				out.println("<input type=hidden name='start"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' id='start"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' value='"+rs.getString("cp_start_date")+"'>");
				out.println("<input type=hidden name='target"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' id='target"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' value='"+rs.getString("cp_target_date")+"'>");
				out.println("<td width='23%' class='FONTVALS'>"+care_mgr+"</td>");
				out.println("<td width='2%' class='FONTVALS' onclick="+callvar+"('CP','"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+p_patient_id+"') title='Variance'><FONT COLOR='"+clr+"' style='cursor:"+hand+"'><B>V</B></FONT></td>");
				out.println("<td width='2%' class='FONTVALHYPERS' onclick=calltasklist(this,'"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+p_patient_id+"','"+Icode_val+"','"+encounter_id+"') title='"+task_title+"'><B>"+task_font+"</B></td>");
				out.println("<td width='2%' class='FONTVALHYPERS' onclick=callplan('"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+p_patient_id+"','"+tempString+"',this,'"+rs.getString("cp_day_no")+"') title='"+eval_title+"'><B>"+eval_font+"</B></td>");
				out.println("<td width='2%' class='FONTVALHYPERS' onclick=callplan('"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+p_patient_id+"','"+tempString+"',this,'"+rs.getString("cp_day_no")+"') title='"+rev_title+"'><B>"+rev_font+"</B></td>");
				out.println("<td width='3%' align='right' class='FONTVALS'>"+rev_cnts+"&nbsp;</td>");
				out.println("<td width='15%' class='FONTVALS'>"+last_revision_date_time+"</td>");
				out.println("<td width='15%' class='FONTVALS'>"+rev_by_name+"</td>");
				out.println("<td width='3%' align='right' class='FONTVALS'>"+eval_cnts+"&nbsp;&nbsp;</td>");
				out.println("<td class='FONTVALS' width='14%'>"+last_eval_date_time+"</td>");
				out.println("<td class='FONTVALS' width='15%'>"+eval_by_name+"</td>");
				out.println("<td class='FONTVALHYPERS' width='5%' title='"+markerrortitle+"' onclick=showerror(this,'"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+rs.getString("current_status")+"','"+p_patient_id+"','"+tempString+"')><B>"+markerror+"</B></td>");
				out.println("</tr>");
				if(rs_diag_goal!=null)
				{
					diag_cnt = 0;
					out.println("<tr id='plan"+i+"' style='display:"+disp_style+"' height='5px'>");
					out.println("<td class=CLASSHEADDIAG colspan='8' align='left'>&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels")+"</td>");
					out.println("<td align='left' class=CLASSHEADDIAG colspan='3'><fmt:message key='eCP.TargetDate.label' bundle='${cp_labels}'/></td>");
					out.println("<td align='left' class=CLASSHEADDIAG colspan='3'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>");
					while(rs_diag_goal.next())
					{
						if((!term_set_id.equals(rs_diag_goal.getString("termsetid")))||(!term_code.equals(rs_diag_goal.getString("termcode"))))
						{
							achv_notachv_pct = "";
							diag_percentage = new StringBuffer();
							diag_pct = Integer.parseInt(rs_diag_goal.getString("last_diag_prog_pct")==null?"104":rs_diag_goal.getString("last_diag_prog_pct"));
							for(diag_cnt = 0;diag_cnt<=100;diag_cnt+=4  )
							{
								if(diag_cnt == 0)
								{
									if(diag_cnt == diag_pct)
										achv_notachv_pct = "[";
									else
										diag_percentage.append("[");
									
								}
								else if (diag_cnt == 100)
								{
									if(diag_cnt == diag_pct)
										achv_notachv_pct = "]";
									else
										diag_percentage.append("]");
								}
								else
								{
									if (diag_cnt == diag_pct)
										diag_percentage.append("|");
									else
										diag_percentage.append("-");
								}
							}
							out.println("<tr height='5px' style='display:"+disp_style+"' id='plan"+i+"'>");
							out.println("<td colspan='8'  class='CLASSHEADDIAGROW'><B>&nbsp;&nbsp;"+rs_diag_goal.getString("diag_desc")+"</B></td>");
							out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+rs_diag_goal.getString("diag_target_date")+"</B></td>");
							if(achv_notachv_pct.equals(""))	
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+diag_percentage.toString()+"</B></td>");
							else if(achv_notachv_pct.equals("["))
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B><Font color='red'>"+achv_notachv_pct+"</Font>"+diag_percentage.toString()+"</B></td>");
							else if(achv_notachv_pct.equals("]"))
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+diag_percentage.toString()+"<Font color='green'>"+achv_notachv_pct+"</Font></B></td>");
							out.println("</tr>");
							term_code = rs_diag_goal.getString("termcode");
							term_set_id = rs_diag_goal.getString("termsetid");
							goal_code = "";
						}
						if(!goal_code.equals(rs_diag_goal.getString("goalcode")))
						{
							achv_notachv_pct = "";
							achv_pct = "";
							notachv_pct = "";
							goal_percentage = new StringBuffer();
							goal_pct = Integer.parseInt(rs_diag_goal.getString("last_goal_prog_pct")==null?"104":rs_diag_goal.getString("last_goal_prog_pct"));
							for(goal_cnt = 0;goal_cnt<=100;goal_cnt+=4  )
							{
								if(goal_cnt == 0)
								{
									if(goal_cnt == goal_pct)
									{
										notachv_pct = "[";
										achv_notachv_pct = "notachv_pct";
									}
									else
										notachv_pct = "[";
								}
								else if (goal_cnt == 100)
								{
									if(goal_cnt == goal_pct)
									{
										achv_pct = "]";
										achv_notachv_pct = "achv_pct";
									}
									else
										achv_pct = "]";
								}
								else
								{
									if (goal_cnt == goal_pct)
										goal_percentage.append("|");
									else
										goal_percentage.append("-");
								}
							}
							goal_code = rs_diag_goal.getString("goalcode");
							classvalue = "";
							outcome_hyp = "";
							out.println("<tr height='5px' style='display:"+disp_style+"' id='plan"+i+"'>");
							out.println("<td class='CLASSHEADDIAGROW' colspan='8' >&nbsp;&nbsp;"+rs_diag_goal.getString("goal_desc")+"</td>");
							out.println("<td colspan='3' class='CLASSHEADDIAGROW'>"+rs_diag_goal.getString("goal_target_date")+"</td>");
							if(achv_notachv_pct.equals(""))
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+notachv_pct+"</B>"+goal_percentage.toString()+"<B>"+achv_pct+"</B></td>");
							else if (achv_notachv_pct.equals("notachv_pct"))
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><Font color='red'><B>"+notachv_pct+"</B></Font>"+goal_percentage.toString()+"<B>"+achv_pct+"</B></td>");
							else if(achv_notachv_pct.equals("achv_pct"))
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+notachv_pct+"</B>"+goal_percentage.toString()+"<Font color='green'><B>"+achv_pct+"</B></Font></td>");
							out.println("</tr>");
							
							pstmt_intvn = con.prepareStatement(sql_intvn);
							pstmt_intvn.setString(1,rs.getString("md_plan_id"));
							pstmt_intvn.setString(2,rs.getString("plan_id"));
							pstmt_intvn.setString(3,term_set_id);
							pstmt_intvn.setString(4,term_code);
							pstmt_intvn.setString(5,goal_code);
							pstmt_intvn.setString(6,locale);
							rs_intvn = pstmt_intvn.executeQuery();
							//out.println("=md_plan_id="+rs.getString("md_plan_id")+"=plan_id="+rs.getString("plan_id")+"=term_code="+term_code+"=goal_code="+goal_code);
							if(rs_intvn!=null)
							{
								out.println("<tr height='5px' style='display:"+disp_style+"' id='plan"+i+"'>");
								out.println("<td class='ITRVNHDR' colspan='1'>&nbsp;</td>");
								out.println("<td class='ITRVNHDR' colspan='5'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Interventions.label","cp_labels")+"</td>");
								out.println("<td class='ITRVNHDR' colspan='2' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>");
								out.println("<td class='ITRVNHDR' colspan='3'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.outcome.label","common_labels")+"</td>");
								out.println("<td class='ITRVNHDR' colspan='3'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>");
								out.println("</tr>");
								result = new ArrayList();
								record = new HashMap();
								while(rs_intvn.next())
								{
									ItermSet=rs_intvn.getString("term_set_id");
									ItermCode=rs_intvn.getString("term_code");
									Igrpid=rs_intvn.getString("group_id_intvn");
									IDesc=rs_intvn.getString("intvn_desc");
									Istatus=rs_intvn.getString("status");
							
									if(Istatus.equals("O")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");	
									if(Istatus.equals("D")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
									if(Istatus.equals("9")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");	
									if(Istatus.equals("P")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartiallyCompleted.label","common_labels");
									if(Istatus.equals("A")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Achieved.label","cp_labels");
									if(Istatus.equals("N")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.NotAchieved.label","cp_labels");
									if(Istatus.equals("C")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
									Icode=rs_intvn.getString("intervention_code");
									Intvnkey = ItermSet+ItermCode+Igrpid;
									if(record.containsKey(Intvnkey))
									{
										result=(ArrayList)record.get(Intvnkey);
										result.add(IDesc);
										result.add(Istatus);
										result.add(Icode);
										for(int l=0;l<2;l++)
										{
											result.add("");
										}
									}
									else
									{
										result=new ArrayList();
										result.add(IDesc);
										result.add(Istatus);
										result.add(Icode);
										for(int l=0;l<2;l++)
										{
											result.add("");
										}
										record.put(Intvnkey,result);
									}
								}
							}

							rs_intvn.close();
							pstmt_intvn.close();

							pstmt_outcome = con.prepareStatement(sql_outcome);
							pstmt_outcome.setString(1,rs.getString("md_plan_id"));
							pstmt_outcome.setString(2,rs.getString("plan_id"));
							pstmt_outcome.setString(3,term_set_id);
							pstmt_outcome.setString(4,term_code);
							pstmt_outcome.setString(5,goal_code);
							pstmt_outcome.setString(6,locale);
							rs_outcome = pstmt_outcome.executeQuery();
							if(rs_outcome!=null)
							{
								while(rs_outcome.next())
								{
									otermSet=rs_outcome.getString("term_set_id");
									otermCode=rs_outcome.getString("term_code");
									ogrpid=rs_outcome.getString("group_id_outcome");
									outcomekey=otermSet+otermCode+ogrpid;
									if(record.containsKey(outcomekey))
									{	
										k=0;
										result=(ArrayList)record.get(outcomekey);
										for(int j=0;j<result.size();j=j+5)
										{
											tempStrings = (String)result.get(j+3);
											if(!tempStrings.equals(""))
											{
												k=k+5;
											}
											else
											{	
												
												break;
											}
										}
										if(k<result.size())
										{
											result.set(k+3,rs_outcome.getString("outcome_desc"));
											result.set(k+4,rs_outcome.getString("outcome_prog_pct")==null?"104":rs_outcome.getString("outcome_prog_pct"));	
										}
										else
										{
											result.add("");
											result.add("");
											result.add("");
											result.add(rs_outcome.getString("outcome_desc"));
											result.add(rs_outcome.getString("outcome_prog_pct")==null?"104":rs_outcome.getString("outcome_prog_pct"));	
										}
									}		
								}
							}

							rs_outcome.close();
							pstmt_outcome.close();
							Set itr_set	= record.keySet();
							Iterator recordItr = itr_set.iterator();
							while(recordItr.hasNext())
							{
								if(classvalue.equals("CLASSINTVNOUTCOMEODD"))
								{
									classvalue="CLASSINTVNOUTCOMEEVEN";
									outcome_hyp = "CLASSINTVNOUTCOMEEVENHYP";
								}
								else
								{
									classvalue="CLASSINTVNOUTCOMEODD";
									outcome_hyp="CLASSINTVNOUTCOMEODDHYP";
								}
								outcomekey="";
								outcomekey=(String)recordItr.next();
								result=(ArrayList)record.get(outcomekey);
								for(int m=0;m<result.size();m+=5)
								{
									intvn_desc = (String)result.get(m)==null?"":(String)result.get(m);
									outcome_desc = (String)result.get(m+3)==null?"":(String)result.get(m+3);
									Icode_val = (String)result.get(m+2);
									out.println("<tr height='5px' style='display:"+disp_style+"' id='plan"+i+"'>");
									if(intvn_desc.equals(""))
										out.println("<td colspan='1' align='right' class='"+outcome_hyp+"'>&nbsp;</td>");
									else
										out.println("<td colspan='1' align='right' class='"+outcome_hyp+"' onclick=calltasklist(this,'"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+p_patient_id+"','"+Icode_val+"','"+encounter_id+"')>+</td>");
									out.println("<td td colspan='5' class='"+classvalue+"'>&nbsp;"+result.get(m)+"</td>");
									out.println("<td colspan='2' class='"+classvalue+"'>&nbsp;"+result.get(m+1)+"&nbsp;</td>");
									out.println("<td colspan='3' class='"+classvalue+"'>"+result.get(m+3)+"</td>");
									if(!outcome_desc.equals(""))
									{
										achv_notachv_pct = "";
										achv_pct = "";
										notachv_pct = "";
										outcome_percentage = new StringBuffer();
										outcome_pct = Integer.parseInt((String)result.get(m+4));
										for(outcome_cnt = 0;outcome_cnt<=100;outcome_cnt+=4  )
										{
											if(outcome_cnt == 0)
											{
												if(outcome_cnt == outcome_pct)
												{
													notachv_pct = "[";
													achv_notachv_pct = "notachv_pct";
												}
												else
													notachv_pct = "[";
											}
											else if (outcome_cnt == 100)
											{
												if(outcome_cnt == outcome_pct)
												{
													achv_pct = "]";
													achv_notachv_pct = "achv_pct";
												}
												else
													achv_pct = "]";
											}
											else
											{
												if (outcome_cnt == outcome_pct)
													outcome_percentage.append("|");
												else
													outcome_percentage.append("-");
											}
										}
										if(achv_notachv_pct.equals(""))
											out.println("<td  colspan='3' class='"+classvalue+"'><B>"+notachv_pct+"</B>"+outcome_percentage.toString()+"<B>"+achv_pct+"</B></td>");
										else if(achv_notachv_pct.equals("notachv_pct"))
											out.println("<td  colspan='3' class='"+classvalue+"'><Font color='red'><B>"+notachv_pct+"</B></font>"+outcome_percentage.toString()+"<B>"+achv_pct+"</B></td>");
										else if(achv_notachv_pct.equals("achv_pct"))
											out.println("<td  colspan='3' class='"+classvalue+"'><B>"+notachv_pct+"</B>"+outcome_percentage.toString()+"<Font color='green'><B>"+achv_pct+"</B></font></td>");
									}
									else
										out.println("<td  colspan='3' class='"+classvalue+"'>&nbsp;</td>");
								}
							}
						}
					}
				}
				i++;
				rs_diag_goal.close();
			    pstmt_diag_goal.close();
			}
			/*else
			{
				out.println("<td colspan='2'>&nbsp;</td>");
				out.println("<td width='3%' class='FONTVALS'>"+rev_cnts+"</td>");
				out.println("<td width='13%' class='FONTVALS'>"+last_revision_date_time+"</td>");
				out.println("<td width='15%' class='FONTVALS'>"+rev_by_name+"</td>");
				out.println("<td width='3%' class='FONTVALS'>"+eval_cnts+"</td>");
				out.println("<td class='FONTVALS' width='13%'>"+last_eval_date_time+"</td>");
				out.println("<td class='FONTVALS' width='15%'>"+eval_by_name+"</td>");
			}*/
			//out.println("</tr>");
		}
		if(count == 0){ %>
			<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</SCRIPT>
<%		}

	}else{
		//System.err.println("inside else");
	%>
	<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));</SCRIPT>
<%
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	System.err.println(e.toString());
		e.printStackTrace();
}
finally
{
	try
	{
	if(rs!=null) rs.close();
	if(rs_diag_goal!=null)rs_diag_goal.close();
	if(rs_intvn!=null) rs_intvn.close();
	if(pstmt_intvn!=null) pstmt_intvn.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt_diag_goal!=null)pstmt_diag_goal.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
}
%>
</table>
</form>
</body>
</html>

