<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	11 Feb 05
-->
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<head>
<%
	 //This file is saved on 01/12/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- <script language="JavaScript" src="../../eCP/js/common.js"></script> -->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../js/AssessmentCriteriaScore.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
PreparedStatement pstmt = null;//common-icn-0180
String assess_note = request.getParameter("assess_note")==null?"":request.getParameter("assess_note");
String assess_desc = request.getParameter("assess_desc")==null?"":request.getParameter("assess_desc");
String catg_code = request.getParameter("catg_code")==null?"":request.getParameter("catg_code");
String catg_desc = request.getParameter("catg_desc")==null?"":request.getParameter("catg_desc");
assess_note = assess_note.toUpperCase();
assess_desc = assess_desc.toUpperCase();
catg_code = catg_code.toUpperCase();
catg_desc = catg_desc.toUpperCase();
String whereClause = "and a.assess_note_id like '"+assess_note+"%'and a.assess_catg_code like '"+catg_code+"%' and upper(c.assess_note_desc) like '"+assess_desc+"%' and upper(b.long_desc) like '"+catg_desc+"%'";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
try
{
	con = ConnectionManager.getConnection(request);
	from = request.getParameter("from") ;
	to = request.getParameter("to") ;
	int maxRecord = 0;
	int maxRecordnum = 0;
	int maxRecordlist = 0;
	int start = 0 ;
	int end = 0 ;
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
	stmt = con.createStatement();
	/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by P.Anuradha on 03/08/2005 requested by Sheelvant*/
	String sql_cnt_num = "select count(*) from cp_assess_num_crit_score a,cp_assess_catg b,	cp_assess_note c,am_discr_msr d where 	a.assess_note_id = c.assess_note_id "+whereClause+" and a.assess_catg_code = b.assess_catg_code and	a.comp_id = d.discr_msr_id";
/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by 
P.Anuradha on 03/08/2005 requested by Sheelvant*/
	String sql_cnt_list = "select count(*) from cp_assess_list_crit_score a,cp_assess_catg b,cp_assess_note c,am_discr_msr d,am_discr_msr_ref_rng_list e where 	a.assess_note_id = c.assess_note_id "+whereClause+"  and a.assess_catg_code = b.assess_catg_code and	a.comp_id = d.discr_msr_id and a.comp_id = e.discr_msr_id(+) and a.list_item_id = e.result_value(+)";
	rs = stmt.executeQuery(sql_cnt_num);
	if(rs!=null)
	{
		if(rs.next())
		{
			maxRecordnum = rs.getInt(1);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql_cnt_list);
	if(rs!=null)
	{
		if(rs.next())
		{
			maxRecordlist = rs.getInt(1);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
    maxRecord = maxRecordnum + maxRecordlist;
%>
<script>
function submitPrevNext(from, to,assess_note,assess_desc,catg_code,catg_desc)
{
parent.f_query_add_mod.location.href="../../eCP/jsp/AssessmentCriteriaScoresQueryResult.jsp?from="+from+"&to="+to+"&assess_note="+assess_note+"&assess_desc="+assess_desc+"&catg_code="+catg_code+"&catg_desc="+catg_desc;
}
</script>
</head>
<body onKeyDown="lockKey()" OnMouseDown='CodeArrest()'> 
<form METHOD=POST target='messageFrame' ACTION="" name='assess_crit_score_result' id='assess_crit_score_result'>
<table width='95%'>
<tr>
<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
<input type=hidden name="from" id="from" value="<%=start%>">
<input type=hidden name="to" id="to" value="<%=end%>">
<input type=hidden name="start" id="start" value="<%=start%>">
<input type=hidden name="end" id="end" value="<%=end%>">
<%
	if ( !(start <= 1))
	{
%>
	<a href='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>,"<%=assess_note%>","<%=assess_desc%>","<%=catg_code%>","<%=catg_desc%>")'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
<%
	}
	if ( !((start+10) > maxRecord ))
	{
%>
	<a href='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>,"<%=assess_note%>","<%=assess_desc%>","<%=catg_code%>","<%=catg_desc%>")'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
<%
	}
%>
</td>
</tr>
</table>
<TABLE border="1" cellpadding="0" cellspacing="0" width="100%" align='right'>
<%
	if(maxRecord != 0 )
	{
		%>	
			<TR>
				<TH><fmt:message key="eCP.NoteID.label" bundle="${cp_labels}"/></TH>
				<TH nowrap><fmt:message key="Common.NoteDescription.label" bundle="${common_labels}"/></TH>
				<TH><fmt:message key="eCP.CategoryCode.label" bundle="${cp_labels}"/></TH>
				<TH nowrap><fmt:message key="eCP.CategoryDescription.label" bundle="${cp_labels}"/></TH>
				<TH><fmt:message key="Common.type.label" bundle="${common_labels}"/></TH>
				<TH><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></TH>
				<TH><fmt:message key="Common.Response.label" bundle="${common_labels}"/></TH>
				<TH><fmt:message key="Common.Score.label" bundle="${common_labels}"/></TH>
			</TR>
		<%
	}
		/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by P.Anuradha on 03/08/2005 requested by Sheelvant*/
//	String sql = "select a.assess_note_id assess_note_id,c.assess_note_desc assess_note_desc,a.assess_catg_code assess_catg_code,b.long_desc assess_catg_desc,a.comp_id,d.short_desc comp_desc,	a.normal_rng_low, a.normal_rng_high,a.normal_score,a.abnormal_rng_low, a.abnormal_rng_high,a.abnormal_score,a.critical_rng_low, a.critical_rng_high,a.critical_score,to_char(null) list_item_id, to_char(null) list_item_text ,to_number(null) score,d.result_type comp_type from cp_assess_num_crit_score a,cp_assess_catg b,cp_assess_note c,am_discr_msr d where a.assess_note_id = c.assess_note_id "+whereClause+" and a.assess_catg_code = b.assess_catg_code and	a.comp_id = d.discr_msr_id union all select	a.assess_note_id,c.assess_note_desc,a.assess_catg_code,b.long_desc,a.comp_id,d.short_desc comp_desc,to_number(null) normal_rng_low, to_number(null) normal_rng_high,to_number(null) normal_score,to_number(null) abnormal_rng_low, to_number(null) abnormal_rng_high,to_number(null) abnormal_score,	to_number(null) critical_rng_low, to_number(null) critical_rng_high,to_number(null) critical_score,a.list_item_id list_item_id,e.ref_rng_desc list_item_text, score,d.result_type comp_type from cp_assess_list_crit_score a,cp_assess_catg b,cp_assess_note c,am_discr_msr d,am_discr_msr_ref_rng_list e where 	a.assess_note_id = c.assess_note_id "+whereClause+" and	a.assess_catg_code = b.assess_catg_code and	a.comp_id = d.discr_msr_id and a.comp_id = e.discr_msr_id(+) and a.list_item_id = e.result_value(+) order by assess_catg_desc";
	//String sql = "SELECT a.assess_note_id assess_note_id,c.assess_note_desc assess_note_desc,a.assess_catg_code assess_catg_code,b.long_desc assess_catg_desc,a.comp_id,d.short_desc comp_desc,	a.normal_rng_low, a.normal_rng_high,a.normal_score,a.abnormal_rng_low, a.abnormal_rng_high,a.abnormal_score,a.critical_rng_low, a.critical_rng_high,a.critical_score,TO_CHAR(NULL) list_item_id, TO_CHAR(NULL) list_item_text ,TO_NUMBER(NULL) score,d.result_type comp_type FROM cp_assess_num_crit_score a,cp_assess_catg_lang_vw b,cp_assess_note_lang_vw c,am_discr_msr_lang_vw d WHERE a.assess_note_id = c.assess_note_id "+whereClause+" AND a.assess_catg_code = b.assess_catg_code AND	a.comp_id = d.discr_msr_id AND B.LANGUAGE_ID = '"+locale+"' AND C.LANGUAGE_ID = B.LANGUAGE_ID AND D.LANGUAGE_ID = B.LANGUAGE_ID UNION ALL SELECT	a.assess_note_id,c.assess_note_desc,a.assess_catg_code,b.long_desc,a.comp_id,d.short_desc comp_desc,TO_NUMBER(NULL) normal_rng_low, TO_NUMBER(NULL) normal_rng_high,TO_NUMBER(NULL) normal_score,TO_NUMBER(NULL) abnormal_rng_low, TO_NUMBER(NULL) abnormal_rng_high,TO_NUMBER(NULL) abnormal_score,	TO_NUMBER(NULL) critical_rng_low, TO_NUMBER(NULL) critical_rng_high,TO_NUMBER(NULL) critical_score,a.list_item_id list_item_id,e.ref_rng_desc list_item_text, score,d.result_type comp_type FROM cp_assess_list_crit_score a,cp_assess_catg_LANG_VW b,cp_assess_note_LANG_VW c,am_discr_msr_LANG_VW d,am_discr_msr_ref_rng_list e WHERE 	a.assess_note_id = c.assess_note_id "+whereClause+" AND	a.assess_catg_code = b.assess_catg_code AND	a.comp_id = d.discr_msr_id AND a.comp_id = e.discr_msr_id(+) AND a.list_item_id = e.result_value(+) AND B.LANGUAGE_ID = '"+locale+"' AND C.LANGUAGE_ID = B.LANGUAGE_ID AND D.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY assess_catg_desc";//common-icn-0180
	String sql = "SELECT a.assess_note_id assess_note_id,c.assess_note_desc assess_note_desc,a.assess_catg_code assess_catg_code,b.long_desc assess_catg_desc,a.comp_id,d.short_desc comp_desc,	a.normal_rng_low, a.normal_rng_high,a.normal_score,a.abnormal_rng_low, a.abnormal_rng_high,a.abnormal_score,a.critical_rng_low, a.critical_rng_high,a.critical_score,TO_CHAR(NULL) list_item_id, TO_CHAR(NULL) list_item_text ,TO_NUMBER(NULL) score,d.result_type comp_type FROM cp_assess_num_crit_score a,cp_assess_catg_lang_vw b,cp_assess_note_lang_vw c,am_discr_msr_lang_vw d WHERE a.assess_note_id = c.assess_note_id "+whereClause+" AND a.assess_catg_code = b.assess_catg_code AND	a.comp_id = d.discr_msr_id AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID AND D.LANGUAGE_ID = B.LANGUAGE_ID UNION ALL SELECT	a.assess_note_id,c.assess_note_desc,a.assess_catg_code,b.long_desc,a.comp_id,d.short_desc comp_desc,TO_NUMBER(NULL) normal_rng_low, TO_NUMBER(NULL) normal_rng_high,TO_NUMBER(NULL) normal_score,TO_NUMBER(NULL) abnormal_rng_low, TO_NUMBER(NULL) abnormal_rng_high,TO_NUMBER(NULL) abnormal_score,	TO_NUMBER(NULL) critical_rng_low, TO_NUMBER(NULL) critical_rng_high,TO_NUMBER(NULL) critical_score,a.list_item_id list_item_id,e.ref_rng_desc list_item_text, score,d.result_type comp_type FROM cp_assess_list_crit_score a,cp_assess_catg_LANG_VW b,cp_assess_note_LANG_VW c,am_discr_msr_LANG_VW d,am_discr_msr_ref_rng_list e WHERE 	a.assess_note_id = c.assess_note_id "+whereClause+" AND	a.assess_catg_code = b.assess_catg_code AND	a.comp_id = d.discr_msr_id AND a.comp_id = e.discr_msr_id(+) AND a.list_item_id = e.result_value(+) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID AND D.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY assess_catg_desc";//common-icn-0180


	//stmt = con.createStatement();//common-icn-0180
	pstmt=con.prepareStatement(sql);//common-icn-0180
	pstmt.setString(1, locale);//common-icn-0180
	pstmt.setString(2, locale);//common-icn-0180
	//rs = stmt.executeQuery(sql);//common-icn-0180
	rs = pstmt.executeQuery();//common-icn-0180
	String className = "";
	String  assess_note_id = "";
	String  assess_note_desc = "";
	String  assess_catg_code = "";
	String  assess_catg_desc = "";
	String  comp_desc = "";
	String  comp_type = "";
	String comp_type_desc = "";
	String  resp = "";
	String  score = ""; 
	String  list_item_id = ""; 
	int i = 1;

	if(rs!=null)
	{
		if ( start != 0 )
		{
			for( int n=1; n<start; i++,n++ )
			{
				rs.next() ;
			}
		}
		while(rs.next() && i<=end )
		{
			if ( i % 2 == 0 )
				className = "QRYEVEN" ;
			else
				className = "QRYODD" ;
			assess_note_id = rs.getString("assess_note_id")==null?"&nbsp;":rs.getString("assess_note_id");
			assess_note_desc = rs.getString("assess_note_desc")==null?"&nbsp;":rs.getString("assess_note_desc");
			assess_catg_code = rs.getString("assess_catg_code")==null?"&nbsp;":rs.getString("assess_catg_code");
			assess_catg_desc = rs.getString("assess_catg_desc")==null?"&nbsp;":rs.getString("assess_catg_desc");
			comp_desc = rs.getString("comp_desc")==null?"&nbsp;":rs.getString("comp_desc");
			comp_type = rs.getString("comp_type")==null?"&nbsp;":rs.getString("comp_type");
			if(comp_type.equals("L"))
				comp_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ListItem.label","common_labels");
			else if(comp_type.equals("C"))
				comp_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckBox.label","common_labels");
			else if((comp_type.equals("N"))||(comp_type.equals("I")))
				comp_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Numeric.label","common_labels");
			resp = rs.getString("list_item_text")==null?"&nbsp;":rs.getString("list_item_text");
			score = rs.getString("score")==null?"&nbsp;":rs.getString("score");
			if(comp_type.equals("C"))
			{
				list_item_id = rs.getString("list_item_id");
				if(list_item_id.equals("Y"))
					resp  = "Yes";
				else if(list_item_id.equals("N"))
					resp = "No";
			}
			else if((comp_type.equals("N"))||(comp_type.equals("I")))
			{
				resp = "Normal (0-1) <BR> Abnormal (2-5) <BR> Critical (6-9)";
				score = ""+rs.getString("normal_score")+"<BR>"+rs.getString("abnormal_score")+"<BR>"+rs.getString("critical_score")+"";
			}
			  out.println("<tr>");
			  out.println("<td class='"+className+"'>"+assess_note_id+"</td>");
			  out.println("<td class='"+className+"'>"+assess_note_desc+"</td>");
			  out.println("<td class='"+className+"'>"+assess_catg_code+"</td>");
			  out.println("<td class='"+className+"'>"+assess_catg_desc+"</td>");
			  out.println("<td nowrap class='"+className+"'>"+comp_type_desc+"</td>");
			  out.println("<td nowrap class='"+className+"'>"+comp_desc+"</td>");
			  out.println("<td class='"+className+"'>"+resp+"</td>");
			  out.println("<td align='right' class='"+className+"'>"+score+"</td>");
			  out.println("</tr>");
			  i++;
		}
	}

    if(i==1)
    {%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
}
%>
</TABLE>
</form>
<%
}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();//common-icn-0180
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

