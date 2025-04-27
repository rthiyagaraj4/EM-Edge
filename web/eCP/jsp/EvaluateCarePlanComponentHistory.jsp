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
*	Purpose 			:	
*	Created By		:	Subbulakshmy.K
*	Created On		:	10 April 2005
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
15/09/2012    IN033183        Chowminya G     Evaluation History In Care Plan - Duplicates
---------------------------------------------------------------------------------------------------------------
--> 
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCP.EvaluationHistory.label" bundle="${cp_labels}"/></title>
	
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link></head>

<%
	String comp	=	request.getParameter("comp")== null?"":request.getParameter("comp");
	String care_plan_id	=	request.getParameter("care_plan_id")== null?"":request.getParameter("care_plan_id");
	String md_plan_id	=	request.getParameter("md_plan_id")== null?"":request.getParameter("md_plan_id");
	String term_set_id	=	request.getParameter("term_set_id")== null?"":request.getParameter("term_set_id");
	String term_code	=	request.getParameter("term_code")== null?"":request.getParameter("term_code");
	String term_code_srl_no	=	request.getParameter("term_code_srl_no")== null?"":request.getParameter("term_code_srl_no");
	String disp_text="-";
	String color="black";
	String goal_desc="";
	String diag_desc="";
	Connection con =	 null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//System.err.println("comp="+comp+",Care Plan Id="+care_plan_id+", md plan id="+md_plan_id+",term set id ="+term_set_id+",term code="+term_code+",term code srl no="+term_code_srl_no);
%>
<body>
<%
	try{
		con = ConnectionManager.getConnection(request);
		if(comp.equals("D")){
			diag_desc	=	request.getParameter("diag_desc")== null?"":request.getParameter("diag_desc");//--[IN033183]
//			String sql_diag	 ="select b.short_desc diag_desc,to_char(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date, short_name last_eval_by, progress_percent from cp_pat_term_code_eval a,am_practitioner ,mr_term_code b where md_care_plan_id=? and care_plan_id=? and a.term_set_id = ? and a.term_code=? and term_code_srl_no=? and practitioner_id = last_eval_by and a.status='V' and a.term_code = b.term_code order by last_eval_datetime desc";
			//String sql_diag	 ="SELECT b.short_desc diag_desc,TO_CHAR(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date, c.short_name last_eval_by, progress_percent FROM cp_pat_term_code_eval a,am_practitioner_lang_vw c ,mr_term_code b WHERE md_care_plan_id=? AND care_plan_id=? AND a.term_set_id = ? AND a.term_code=? AND term_code_srl_no=? AND c.practitioner_id = last_eval_by AND a.status='V' AND a.term_code = b.term_code AND c.language_id = ? ORDER BY last_eval_datetime DESC"; //Commentted --[IN033183]
			String sql_diag	 ="SELECT b.short_desc diag_desc,TO_CHAR(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date, c.short_name last_eval_by, progress_percent FROM cp_pat_term_code_eval a,am_practitioner_lang_vw c ,mr_term_code b WHERE md_care_plan_id=? AND care_plan_id=? AND a.term_set_id = ? AND a.term_code=? AND term_code_srl_no=? AND c.practitioner_id = last_eval_by AND a.status='V' AND a.term_code = b.term_code AND a.term_set_id = b.term_set_id AND c.language_id = ? ORDER BY last_eval_datetime DESC";//--[IN033183]
			
			pstmt = con.prepareStatement(sql_diag);
			pstmt.setString(1, md_plan_id);
			pstmt.setString(2, care_plan_id);
			pstmt.setString(3, term_set_id);
			pstmt.setString(4, term_code);
			pstmt.setString(5, term_code_srl_no);
			pstmt.setString(6, locale);
			rs = pstmt.executeQuery();
			/*if(rs.next())
			{
				diag_desc	=	rs.getString("diag_desc");
			}*/ //Commentted--[IN033183]
%>
	<table width='100%' cellspacing='0' cellpadding='0' border=0>
	<tr>
		<td colspan='28' align='left' class='Diag'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>:&nbsp;&nbsp;&nbsp;<%=diag_desc%><td>
	</tr>
<%		}
		else if(comp.equals("G")){
			String goal_code	=	request.getParameter("goal_code")== null?"":request.getParameter("goal_code");
			String goal_srl_no	=	request.getParameter("goal_srl_no")== null?"":request.getParameter("goal_srl_no");
			goal_desc	=	request.getParameter("goal_desc")== null?"":request.getParameter("goal_desc");
			diag_desc	=	request.getParameter("diag_desc")== null?"":request.getParameter("diag_desc");
			//String sql_goal ="select to_char(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date, short_name last_eval_by, progress_percent from cp_pat_goal_eval a, am_practitioner where md_care_plan_id=? and care_plan_id=? and term_set_id = ?  and term_code=? and term_code_srl_no=? and goal_code=? and goal_srl_no=? and practitioner_id = last_eval_by and a.status = 'V' order by last_eval_datetime desc";
			String sql_goal ="SELECT TO_CHAR(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date, b.short_name last_eval_by, progress_percent FROM cp_pat_goal_eval a, am_practitioner_lang_vw b WHERE md_care_plan_id=? AND care_plan_id=? AND term_set_id = ?  AND term_code=? AND term_code_srl_no=? AND goal_code=? AND goal_srl_no=? AND b.practitioner_id = last_eval_by AND a.status = 'V' AND b.language_id = ? ORDER BY last_eval_datetime DESC";
			pstmt = con.prepareStatement(sql_goal);
			pstmt.setString(1, md_plan_id);
			pstmt.setString(2, care_plan_id);
			pstmt.setString(3, term_set_id);
			pstmt.setString(4, term_code);
			pstmt.setString(5, term_code_srl_no);
			pstmt.setString(6, goal_code);
			pstmt.setString(7, goal_srl_no);
			pstmt.setString(8, locale);
			rs = pstmt.executeQuery();
%>
	<table width='100%' cellspacing='0' cellpadding='0' border=0>
	<tr>
		<td colspan='28' align='left' class='Diag'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>:&nbsp;&nbsp;&nbsp;<%=diag_desc%><td>
	</tr>
	<tr>
		<td colspan='28' align='left' class='Goal'><fmt:message key="eCP.Goal.label" bundle="${cp_labels}"/>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=goal_desc%><td>
	</tr>
<%		}
		else if(comp.equals("O")){
			String goal_code	=	request.getParameter("goal_code")== null?"":request.getParameter("goal_code");
			String goal_srl_no	=	request.getParameter("goal_srl_no")== null?"":request.getParameter("goal_srl_no");
			String outcome_code	=	request.getParameter("outcome_code")== null?"":request.getParameter("outcome_code");
			String outcome_srl_no	=	request.getParameter("outcome_srl_no")== null?"":request.getParameter("outcome_srl_no");
			//System.err.println("goal code ="+goal_code+" ,goal srl no="+goal_srl_no+" ,outcome code ="+outcome_code+", outcome srl no="+outcome_srl_no);
			String sql_term_desc = "select short_desc||'('||term_code||')' diag_desc from mr_term_code where term_set_id = ? and term_code = ?";
			pstmt = con.prepareStatement(sql_term_desc);
			pstmt.setString(1, term_set_id);
			pstmt.setString(2, term_code);
			rs = pstmt.executeQuery();
			if(rs!=null)
				if(rs.next())
					diag_desc = rs.getString("diag_desc");
			//String sql_goal_desc = "select short_desc goal_desc from cp_outcome where outcome_code=?";
			String sql_goal_desc = "SELECT short_desc goal_desc FROM cp_outcome_lang_vw WHERE outcome_code=? AND language_id = ?";
			pstmt = con.prepareStatement(sql_goal_desc);
			pstmt.setString(1, goal_code);
			pstmt.setString(2, locale);
			rs = pstmt.executeQuery();
			if(rs!=null)
				if(rs.next())
					goal_desc = rs.getString("goal_desc");
//			String sql_outcome ="SELECT   b.short_desc outcome_desc,TO_CHAR (a.last_eval_datetime, 'dd/mm/yyyy hh24:mi') last_eval_date,short_name last_eval_by, a.progress_percent progress_percent FROM cp_pat_outcome_eval a, am_practitioner,cp_outcome b WHERE b.outcome_code=a.outcome_code and a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = ? AND a.term_code = ? AND a.term_code_srl_no = ? AND a.goal_code = ? AND a.goal_srl_no = ? AND a.outcome_code = ? AND a.outcome_srl_no = ?  and practitioner_id = a.last_eval_by and a.status = 'V' ORDER BY a.last_eval_datetime DESC";
			String sql_outcome ="SELECT   b.short_desc outcome_desc,TO_CHAR (a.last_eval_datetime, 'dd/mm/yyyy hh24:mi') last_eval_date,c.short_name last_eval_by, a.progress_percent progress_percent FROM cp_pat_outcome_eval a, am_practitioner_lang_vw c,cp_outcome_lang_vw b WHERE b.outcome_code=a.outcome_code AND a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = ? AND a.term_code = ? AND a.term_code_srl_no = ? AND a.goal_code = ? AND a.goal_srl_no = ? AND a.outcome_code = ? AND a.outcome_srl_no = ?  AND c.practitioner_id = a.last_eval_by AND a.status = 'V' AND c.language_id = ? AND b.language_id = ? ORDER BY a.last_eval_datetime DESC";
			pstmt = con.prepareStatement(sql_outcome);
			pstmt.setString(1, md_plan_id);
			pstmt.setString(2, care_plan_id);
			pstmt.setString(3, term_set_id);
			pstmt.setString(4, term_code);
			pstmt.setString(5, term_code_srl_no);
			pstmt.setString(6, goal_code);
			pstmt.setString(7, goal_srl_no);
			pstmt.setString(8, outcome_code);
			pstmt.setString(9, outcome_srl_no);
			pstmt.setString(10, locale);
			pstmt.setString(11, locale);
			rs = pstmt.executeQuery();
			if(rs!=null){
				if(rs.next())
				{
%>
	<table width='100%' cellspacing='0' cellpadding='0' border=0>
	<tr>
		<td colspan='28' align='left' class='Diag'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>:&nbsp;&nbsp;&nbsp;<%=diag_desc%><td>
	</tr>
	<tr>
		<td colspan='28' align='left' class='Goal'><fmt:message key="eCP.Goal.label" bundle="${cp_labels}"/>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=goal_desc%><td>
	</tr>
	<tr>
		<td colspan='28' align='left' class='Outcome'><fmt:message key="Common.outcome.label" bundle="${common_labels}"/>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=rs.getString("outcome_desc")%><td>
	</tr>
<%
				String last_eval_date = rs.getString("last_eval_date")==null?"":com.ehis.util.DateUtils.convertDate(rs.getString("last_eval_date"),"DMYHM","en",locale);
				String last_eval_by = rs.getString("last_eval_by")==null?"":rs.getString("last_eval_by");
				String progress_percent = rs.getString("progress_percent")==null?"0":rs.getString("progress_percent");
				int int_progress	= Integer.parseInt(progress_percent);
				out.println("<tr><td  width='20%' class='List'>"+last_eval_date +"</td>");
				out.println("<td width='50%' class='List'>"+last_eval_by +"</td>");
				for(int i=0;i<=100; i+=4){
					if(i==0){
						disp_text="<b>[</b>";
					}
					else 	if(i==100){
						disp_text="<b>]</b>";
					}
					else{
						disp_text="-";
					}
					color="black";

					if(i==int_progress){
						if(int_progress == 0){
							disp_text="<b>[</b>";
							color="red";
						}
						else if(int_progress == 100){
							disp_text="<b>]</b>";
							color="green";
						}
						else{
							disp_text ="|";
							color="black";
						}
					}
					out.println("<td width='8' class='List'><font color="+color+">"+disp_text+"</font></td>");
				}
			}
			}
		}
		while((rs != null)&&rs.next())
		{
				String last_eval_date = rs.getString("last_eval_date")==null?"":com.ehis.util.DateUtils.convertDate(rs.getString("last_eval_date"),"DMYHM","en",locale);
				String last_eval_by = rs.getString("last_eval_by")==null?"":rs.getString("last_eval_by");
				String progress_percent = rs.getString("progress_percent")==null?"0":rs.getString("progress_percent");
				int int_progress	= Integer.parseInt(progress_percent);
				out.println("<tr><td class='List' width='35%'>"+last_eval_date +"</td>");
				out.println("<td class='List' width='50%'>"+last_eval_by +"</td>");
				for(int i=0;i<=100; i+=4){
					if(i==0){
						disp_text="<b>[</b>";
					}
					else 	if(i==100){
						disp_text="<b>]</b>";
					}
					else{
						disp_text="-";
					}
					color="black";

					if(i==int_progress){
						if(int_progress == 0){
							disp_text="<b>[</b>";
							color="red";
						}
						else if(int_progress == 100){
							disp_text="<b>]</b>";
							color="green";
						}
						else{
							disp_text ="|";
							color="black";
						}
					}
					out.println("<td width='8' class='List'><font color="+color+">"+disp_text+"</font></td>");
				}
				out.println("</tr>");
%>
</body>
<%	}
		if(pstmt !=null)
			pstmt.close();
}catch(Exception e){
	//out.println(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}finally{
	if(rs!=null)rs.close();
	if(pstmt !=null)
		pstmt.close();
	if(con != null)
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>
