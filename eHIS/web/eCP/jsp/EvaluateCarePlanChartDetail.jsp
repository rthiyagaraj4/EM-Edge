<!DOCTYPE html>
<%@ page language="java" import ="webbeans.eCommon.*,java.sql.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
//This file is saved on 19/10/2005.
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
{
	con = ConnectionManager.getConnection(request);
	String comp	=	request.getParameter("comp")== null?"":request.getParameter("comp");
	String care_plan_id	=	request.getParameter("care_plan_id")== null?"":request.getParameter("care_plan_id");
	String md_plan_id	=	request.getParameter("md_plan_id")== null?"":request.getParameter("md_plan_id");
	String term_set_id	=	request.getParameter("term_set_id")== null?"":request.getParameter("term_set_id");
	String term_code	=	request.getParameter("term_code")== null?"":request.getParameter("term_code");
	String term_code_srl_no	=	request.getParameter("term_code_srl_no")== null?"":request.getParameter("term_code_srl_no");
	String goal_code	=	request.getParameter("goal_code")== null?"":request.getParameter("goal_code");
	String goal_srl_no	=	request.getParameter("goal_srl_no")== null?"":request.getParameter("goal_srl_no");
	String outcome_code	=	request.getParameter("outcome_code")== null?"":request.getParameter("outcome_code");
	String outcome_srl_no	=	request.getParameter("outcome_srl_no")== null?"":request.getParameter("outcome_srl_no");
	ArrayList Date_List =new ArrayList();
	ArrayList Data_List =new ArrayList();

	String description = "";
	String desc = "";
	String event = "";
	//String progress_percent = "";
	//String last_eval_date = "";
	StringBuffer complete_data=new StringBuffer();
	int data_count = 0;
	int series_count=1;

	if(comp.equals("D"))
	{
		String sql_diag	 ="select b.short_desc description,to_char(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date,progress_percent from cp_pat_term_code_eval a,mr_term_code b where md_care_plan_id=? and care_plan_id=? and a.term_set_id = ? and a.term_code=? and term_code_srl_no=? and a.status='V' and a.term_code = b.term_code and a.term_set_id = b.term_set_id order by last_eval_datetime";
		pstmt = con.prepareStatement(sql_diag);
		pstmt.setString(1, md_plan_id);
		pstmt.setString(2, care_plan_id);
		pstmt.setString(3, term_set_id);
		pstmt.setString(4, term_code);
		pstmt.setString(5, term_code_srl_no);
		rs = pstmt.executeQuery();
	}
	else if(comp.equals("G"))
	{
//		String sql_goal ="select b.short_desc description,to_char(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date,progress_percent from cp_pat_goal_eval a,cp_outcome b where md_care_plan_id=? and care_plan_id=? and term_set_id = ?  and term_code=? and term_code_srl_no=? and goal_code=? and goal_srl_no=?  and a.status = 'V' and b.outcome_code = a.goal_code order by last_eval_datetime";
		String sql_goal ="SELECT b.short_desc description,TO_CHAR(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date,progress_percent FROM cp_pat_goal_eval a,cp_outcome_lang_vw b WHERE md_care_plan_id=? AND care_plan_id=? AND term_set_id = ?  AND term_code=? AND term_code_srl_no=? AND goal_code=? AND goal_srl_no=?  AND a.status = 'V' AND b.outcome_code = a.goal_code AND b.language_id = ? ORDER BY last_eval_datetime";
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
	}
	else if(comp.equals("O"))
	{
//		String sql_outcome ="SELECT b.short_desc description,to_char(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date,progress_percent  FROM cp_pat_outcome_eval a ,cp_outcome b WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = ? AND a.term_code = ? AND a.term_code_srl_no = ? AND a.goal_code = ? AND a.goal_srl_no = ? AND a.outcome_code = ? AND a.outcome_srl_no = ?  and a.status = 'V' and a.outcome_code = b.outcome_code ORDER BY a.last_eval_datetime";
		String sql_outcome ="SELECT b.short_desc description,TO_CHAR(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date,progress_percent  FROM cp_pat_outcome_eval a ,cp_outcome_lang_vw b WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = ? AND a.term_code = ? AND a.term_code_srl_no = ? AND a.goal_code = ? AND a.goal_srl_no = ? AND a.outcome_code = ? AND a.outcome_srl_no = ?  AND a.status = 'V' AND a.outcome_code = b.outcome_code AND b.language_id = ? ORDER BY a.last_eval_datetime";
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
		rs = pstmt.executeQuery();
	}
%>
<html>
<%
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link></head>
	<body>
	<script language=javascript>
	document.body.style.scrollbarBaseColor='#E2E3F0';
	document.body.style.scrollbarArrowColor='#000080';
	document.body.style.scrollbarDarkShadowColor='#E2E3F0';
	document.body.style.scrollbarFaceColor='#E2E3F0';
	document.body.style.scrollbarHighlightColor='white';
	document.body.style.scrollbarShadowColor='#E2E3F0';
	document.body.style.scrollbar3dlightColor='#E2E3F0';
	</script>
	<table width='100%' cellspacing='0' cellpadding='0' border=0>
		<tr>
			<td class='label'><B><%=desc%></B></td>
		</tr>
	</table>
	<applet code="barchartApplet" archive="CPChartApplet.jar" codebase="." width="650" height="500">
		<param name='chart_data' value='Bar|<%=series_count%>| Evaluated Dates|1|11|0|0|100'>
		<param name=font		value="Arial,0,11">
		<param name=fontL		value="Arial,1,14">
		<param name=fontT		value="Dialog,3,15">
		<param name=origine		value="60,110">
		<param name=bgcolor 	value="#D0F0FF">
<%
	if(rs!=null)
	{
		while(rs.next())
		{
			Data_List.add(rs.getString("progress_percent")==null?"":rs.getString("progress_percent"));
			Date_List.add(rs.getString("last_eval_date")==null?"":com.ehis.util.DateUtils.convertDate(rs.getString("last_eval_date"),"DMYHM","en",locale));
			description = rs.getString("description")==null?"":rs.getString("description");
		}
	}
	if(comp.equals("D"))
	{
		event = "Diagnosis";
		desc = "Diagnosis:  "+description;
	}
	else if(comp.equals("G"))
	{
		event = "Goal";
		desc = "Goal:  "+description;
	}
	else if(comp.equals("O"))
	{
		event = "Outcome";
		desc = "Outcome:  "+description;
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	data_count=Data_List.size();
%>
 		<param name='title' value='title|<%=desc%>'>
		<param name='label' value='label|Evaluated Dates|Score'>
 		<param name='series_count' value='<%=series_count%>'>
		<param name='data_count' value='<%=data_count%>'>
 		<param name='series0' value=' col|<%=event%>|20024080'>
<%
		complete_data.append("title|"+desc+"~label|Evaluated Dates|Score ~ col|"+event+"|20024080");
		for(int i=0;i<data_count;i++){
			complete_data.append("~"+Date_List.get(i)+"|"+Data_List.get(i));
		}
		for(int i=0;i<data_count ;i++){
%>
			<param name='label<%=i%>' value='<%=Date_List.get(i)%>'>
<%
		}
		for(int i=0;i<data_count ;i++){
%>
			<param name='series0data<%=i%>' value='<%=Data_List.get(i)%>'>
<%
		}
%>
 	<param name='complete_data' value='<%=complete_data%>'>
	</applet>
	</body>
	<html>
<%
}
catch(Exception e1)
{
	out.println("main "+e1);
}
finally
{
	try
	{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
		// out.println(e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
}
%>

