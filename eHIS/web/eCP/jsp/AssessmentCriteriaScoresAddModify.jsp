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
*	Created By		:	Vinay
*	Created On		:	01 Feb 2005
--%>
<html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	 //This file is saved on 16/12/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
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
Statement Liststmt = null;
ResultSet rs = null;
ResultSet Listrs = null;
ResultSet rsVal = null;
Statement stmtVal = null;
PreparedStatement pstmt = null;//common-icn-0180
PreparedStatement pstmt1 = null;//common-icn-0180
String assess_note = request.getParameter("assess_note");
String assess_catg = request.getParameter("assess_catg");
if(assess_note==null) assess_note="";
if(assess_catg==null) assess_catg="";
String sec_hdg_code = "";
String child_sec_hdg_code = "";
String srl_no = "";
String comp_type = "";
String comp_type_desc = "";
String comp_id = "";
String short_desc = "";
String list_item_id = "";
String list_item_text = "";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
try
{
	con = ConnectionManager.getConnection(request);
	from = request.getParameter("from") ;
	to = request.getParameter("to") ;
	int maxRecord = 0;
	int Listcnt = 0;
	int start = 0 ;
	int end = 0 ;
	int inc = 1;
	int list_inc = 1;
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 200 ; }   else {  end = Integer.parseInt( to ) ; }
	//stmt = con.createStatement();//common-icn-0180
	/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by P.Anuradha on 03/08/2005 requested by Sheelvant*/
	//String cntsql = "select count(*) from cp_assess_crit a, am_discr_msr b where a.assess_note_id = '"+assess_note+"' and assess_catg_code = '"+assess_catg+"' and a.comp_id=b.discr_msr_id and b.result_type in ('L','C','N','I')";
	String cntsql = "select count(*) from cp_assess_crit a, am_discr_msr b where a.assess_note_id = ? and assess_catg_code = ? and a.comp_id=b.discr_msr_id and b.result_type in ('L','C','N','I')";
	pstmt=con.prepareStatement(cntsql);//common-icn-0180
	pstmt.setString(1, assess_note);//common-icn-0180
	pstmt.setString(2, assess_catg);//common-icn-0180
	rs = pstmt.executeQuery();//common-icn-0180
	//rs = stmt.executeQuery(cntsql);//common-icn-0180
	
	if(rs!=null)
	{
		if(rs.next())
		{
			maxRecord = rs.getInt(1);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();//common-icn-0180
	}
%>
<script>
function submitPrevNext(from, to)
{
		document.assess_crit_score_addmod.from.value = from;
	    document.assess_crit_score_addmod.to.value = to; 
	    var assess_note = document.assess_crit_score_addmod.assess_note.value; 
	    var assess_catg = document.assess_crit_score_addmod.assess_catg.value; 
		parent.assess_crit_score_addmod.location.href="../../eCP/jsp/AssessmentCriteriaScoresAddModify.jsp?assess_note="+assess_note+"&assess_catg="+assess_catg+"&from="+from+"&to="+to+"";
}
</script>
</head>
<body onKeyDown="lockKey()" OnMouseDown='CodeArrest()'> 
<form METHOD=POST target='messageFrame' ACTION="../../servlet/eCP.AssessmentCriteriaScoresServlet" name='assess_crit_score_addmod' id='assess_crit_score_addmod'>
<table width='95%'>
<tr>
<td align='right'  id='prevNext'  class='BODYCOLORFILLED'>
<%
	if ( !(start <= 1))
	{
%>
	<a href='javascript:submitPrevNext(<%=(start-200)%>,<%=(end-200)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
<%
	}
	if ( !((start+200) > maxRecord ))
	{
%>
	<a href='javascript:submitPrevNext(<%=(start+200)%>,<%=(end+200)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
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
				<TH><fmt:message key="eCP.CriteriaDescription.label" bundle="${cp_labels}"/></TH>
				<TH><fmt:message key="Common.type.label" bundle="${common_labels}"/></TH>
				<TH><fmt:message key="Common.Response.label" bundle="${common_labels}"/></TH>
				<TH><fmt:message key="Common.Score.label" bundle="${common_labels}"/></TH>
			</TR>
		<%
	}
	else
	{
	%>
		<script>
			parent.assess_crit_score_addmod.location.href="../../eCommon/html/blank.html";
		</script>
		<%
	}
/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by 
P.Anuradha on 03/08/2005 requested by Sheelvant*/
//	String sql = "select a.SEC_HDG_CODE sec_hdg_code,a.child_sec_hdg_code child_sec_hdg_code,a.comp_SRL_NO srl_no,b.result_type comp_type,a.comp_id comp_id,b.short_desc short_desc from cp_assess_crit a, am_discr_msr b where a.assess_note_id = '"+assess_note+"' and assess_catg_code = '"+assess_catg+"' and a.COMP_ID=b.discr_msr_id and b.result_type in ('L','C','N','I')";
	//String sql = "SELECT a.SEC_HDG_CODE sec_hdg_code,a.child_sec_hdg_code child_sec_hdg_code,a.comp_SRL_NO srl_no,b.result_type comp_type,a.comp_id comp_id,b.short_desc short_desc FROM cp_assess_crit a, am_discr_msr_LANG_VW b WHERE a.assess_note_id = '"+assess_note+"' AND assess_catg_code = '"+assess_catg+"' AND a.COMP_ID=b.discr_msr_id AND b.result_type IN ('L','C','N','I') AND B.LANGUAGE_ID = '"+locale+"'";//common-icn-0180
	String sql = "SELECT a.SEC_HDG_CODE sec_hdg_code,a.child_sec_hdg_code child_sec_hdg_code,a.comp_SRL_NO srl_no,b.result_type comp_type,a.comp_id comp_id,b.short_desc short_desc FROM cp_assess_crit a, am_discr_msr_LANG_VW b WHERE a.assess_note_id = ? AND assess_catg_code = ? AND a.COMP_ID=b.discr_msr_id AND b.result_type IN ('L','C','N','I') AND B.LANGUAGE_ID = ?";//common-icn-0180
	
	//stmt = con.createStatement();//common-icn-0180
	pstmt1 = con.prepareStatement(sql);//common-icn-0180
	pstmt1.setString(1, assess_note);//common-icn-0180
	pstmt1.setString(2, assess_catg);//common-icn-0180
	pstmt1.setString(3, locale);//common-icn-0180
	rs = pstmt1.executeQuery();//common-icn-0180
	//rs = stmt.executeQuery(sql);//common-icn-0180
	String className = "";
	String sql_chk = "";
	String sql_list = "";
	String sql_num = "";
	//String selected = "";
	String normal_rng_low = "";
	String normal_rng_high = "";
	String abnormal_rng_low = "";
	String abnormal_rng_high = "";
	String critical_rng_low = "";
	String critical_rng_high = "";
	int chkValyes = 0;
	int chkValno = 0;
	int num_normal_score = 0;
	int num_abnormal_score = 0;
	int num_critical_score = 0;
	int b=0;
	int i = 1;
	int cnt = 0;
	int list_cnts = 1;
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
			short_desc = rs.getString("short_desc");
			sec_hdg_code = rs.getString("sec_hdg_code");
			child_sec_hdg_code = rs.getString("child_sec_hdg_code");
			srl_no = rs.getString("srl_no");
			comp_type = rs.getString("comp_type");
			if(comp_type.equals("L"))
				comp_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ListItem.label","common_labels");
			else if(comp_type.equals("C"))
				comp_type_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckBox.label","common_labels");
			else if((comp_type.equals("N"))||(comp_type.equals("I")))
				comp_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Numeric.label","common_labels");
			comp_id = rs.getString("comp_id");
			out.println("<tr >");
			out.println("<input type='hidden' value='"+srl_no+"' name='srl_no"+i+"' id='srl_no"+i+"'>");
			out.println("<input type='hidden' value='"+comp_type+"' name='comp_type"+i+"' id='comp_type"+i+"'>");
			out.println("<input type='hidden' value='"+comp_id+"' name='comp_id"+i+"' id='comp_id"+i+"'>");
			out.println("<input type='hidden' value='"+sec_hdg_code+"' name='sec_hdg_code"+i+"' id='sec_hdg_code"+i+"'>");
			out.println("<input type='hidden' value='"+child_sec_hdg_code+"' name='child_sec_hdg_code"+i+"' id='child_sec_hdg_code"+i+"'>");
			out.println("<td class='"+className+"'align='left'>"+short_desc+"</td>");
			out.println("<td class='"+className+"' align='left' width='15%'>"+comp_type_desc+"</td>");
			if(comp_type.equals("C"))
			{
				out.println("<td class='"+className+"' align='right'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+"<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"</td>");
				//sql_chk = "select list_item_id,score from cp_assess_list_crit_score where assess_note_id = '"+assess_note+"' and assess_catg_code = '"+assess_catg+"' and comp_id='"+comp_id+"' order by list_item_id desc";//common-icn-0180
				sql_chk = "select list_item_id,score from cp_assess_list_crit_score where assess_note_id = ? and assess_catg_code = ? and comp_id=? order by list_item_id desc";//common-icn-0180
				pstmt1 = con.prepareStatement(sql_chk);//common-icn-0180
				pstmt1.setString(1, assess_note);//common-icn-0180
				pstmt1.setString(2, assess_catg);//common-icn-0180
				pstmt1.setString(3, comp_id);//common-icn-0180
				rsVal = pstmt1.executeQuery();//common-icn-0180
				//stmtVal = con.createStatement();//common-icn-0180
				//rsVal = stmtVal.executeQuery(sql_chk);//common-icn-0180
				out.println("<td class='"+className+"' align='center'><SELECT name='scorelistyes"+i+"' id='scorelistyes"+i+"'>");
				for(b=0;b<=9;b++)
				{
					if(rsVal!=null)
					{
						while(rsVal.next())
						{
							if(cnt==0)
								chkValyes = Integer.parseInt(rsVal.getString("score"));
							else
								chkValno = Integer.parseInt(rsVal.getString("score"));
							cnt++;
						}
					}
					if(chkValyes==b)
					{
						out.println("<option value='"+b+"' selected>"+b+"</option>");
					}
					else
					{
						out.println("<option value='"+b+"'>"+b+"</option>");
					}
				}
				b = 0;
				cnt = 0;
				out.println("</select><BR><SELECT name='scorelistno"+i+"' id='scorelistno"+i+"'>");
				for(b=0;b<=9;b++)
				{
					if(chkValno==b)
					{
						out.println("<option value='"+b+"' selected>"+b+"</option>");
					}
					else
					{
						out.println("<option value='"+b+"'>"+b+"</option>");
					}
				}
				out.println("</select></td>");
				b = 0;
			}
			else if(comp_type.equals("L"))
			{
				//Liststmt = con.createStatement();//common-icn-0180
				StringBuffer list_items_id = new StringBuffer();
				/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by P.Anuradha on 03/08/2005 requested by Sheelvant*/
				//String Listcntsql = "select count(*) from am_discr_msr_ref_rng_list where discr_msr_id ='"+comp_id+"'";//common-icn-0180
				String Listcntsql = "select count(*) from am_discr_msr_ref_rng_list where discr_msr_id =?";//common-icn-0180
				pstmt1 = con.prepareStatement(Listcntsql);//common-icn-0180
				pstmt1.setString(1, comp_id);//common-icn-0180
				Listrs = pstmt1.executeQuery();//common-icn-0180
				//Listrs = Liststmt.executeQuery(Listcntsql);//common-icn-0180
				if(Listrs!=null)
				{
					if(Listrs.next())
					{
						Listcnt = Listrs.getInt(1);
					}
					if(Listrs!=null) Listrs.close();
					if(Liststmt!=null) Liststmt.close();
				}
				//Liststmt = con.createStatement();//common-icn-0180
				/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by P.Anuradha on 03/08/2005 requested by Sheelvant*/
				//String Listsql = "select result_value,ref_rng_desc  from am_discr_msr_ref_rng_list where discr_msr_id ='"+comp_id+"' order by sort_order";//common-icn-0180
				String Listsql = "select result_value,ref_rng_desc  from am_discr_msr_ref_rng_list where discr_msr_id =? order by sort_order";//common-icn-0180
				
				pstmt1 = con.prepareStatement(Listsql);//common-icn-0180
				pstmt1.setString(1, comp_id);//common-icn-0180
				Listrs = pstmt1.executeQuery();//common-icn-0180
				//Listrs = Liststmt.executeQuery(Listsql);
				if(Listrs!=null)
				{	
					int k = 1;
					out.println("<td class='"+className+"' align='right'>");

					while(Listrs.next())
					{
						list_item_id = Listrs.getString("result_value");
						if(k==1)
							list_items_id.append("'"+list_item_id+"'");
						else
							list_items_id.append(","+"'"+list_item_id+"'");
						out.println("<input type='hidden' value='"+list_item_id+"' name='list_item_id"+list_inc+"' id='list_item_id"+list_inc+"'>");
						list_item_text = Listrs.getString("ref_rng_desc");
						out.println(list_item_text+"<BR>");
						k++;
						list_inc++;
					}
					out.println("</td>");
					if(Listrs!=null) Listrs.close();
					if(Liststmt!=null) Liststmt.close();
				}
				if(Listcnt!=0)
				{
					out.println("<td class='"+className+"' align='center'>");
					//sql_list = "select score from cp_assess_list_crit_score where assess_note_id = '"+assess_note+"' and assess_catg_code = '"+assess_catg+"' and comp_id='"+comp_id+"' and list_item_id in ("+list_items_id.toString()+")";
					sql_list = "select score from cp_assess_list_crit_score where assess_note_id = ? and assess_catg_code = ? and comp_id= ? and list_item_id in ("+list_items_id.toString()+")";//common-icn-0180
					
					//stmtVal = con.createStatement();//common-icn-0180
					pstmt1 = con.prepareStatement(sql_list);//common-icn-0180
					pstmt1.setString(1, assess_note);//common-icn-0180
					pstmt1.setString(2, assess_catg);//common-icn-0180
					pstmt1.setString(3, comp_id);//common-icn-0180
					rsVal = pstmt1.executeQuery();//common-icn-0180
					//rsVal = stmtVal.executeQuery(sql_list);//common-icn-0180
					int j = 1;
					if(rsVal!=null)
					{
						while(rsVal.next())
						{
							out.println("<SELECT name='scorelist"+inc+"' id='scorelist"+inc+"'>");
							for(b=0;b<=9;b++)
							{
								if(b==Integer.parseInt(rsVal.getString("score")))
								{
									out.println("<option value='"+b+"' selected>"+b+"</option>");
								}
								else
								{
									out.println("<option value='"+b+"'>"+b+"</option>");
								}
							}
							out.println("</select><BR>");
							j++;
							inc++;
						}
					}
					if(b==0)
					{
						for(j=1;j<=Listcnt;j++)
						{
							out.println("<SELECT name='scorelist"+inc+"' id='scorelist"+inc+"'><option value='0'>0</option><option value='1'>1</option><option value='2'>2</option><option value='3'>3 </option><option value='4'>4</option><option value='5'>5</option><option value='6'>6</option><option value='7'>7</option><option value='8'>8</option><option value='9'>9</option></select><BR>");
							inc++;
						}
					}
					if(rsVal!=null) rsVal.close();
					if(stmtVal!=null) stmtVal.close();
					out.println("</td>");
					b = 0;
				}
				else
				{
					out.println("<td class='"+className+"' align='center'>&nbsp;</td>");
				}
				out.println("<INPUT TYPE='hidden' name='Listcnt"+list_cnts+"' id='Listcnt"+list_cnts+"' value='"+Listcnt+"'>");
				list_cnts++;
			}
			else if((comp_type.equals("N"))||(comp_type.equals("I")))
			{
				//sql_num = "select abnormal_rng_low,abnormal_rng_high,abnormal_score,normal_rng_low,normal_rng_high,normal_score,critical_rng_low,critical_rng_high,critical_score from cp_assess_num_crit_score  where assess_note_id = '"+assess_note+"' and assess_catg_code = '"+assess_catg+"' and comp_id='"+comp_id+"'";//common-icn-0180
				sql_num = "select abnormal_rng_low,abnormal_rng_high,abnormal_score,normal_rng_low,normal_rng_high,normal_score,critical_rng_low,critical_rng_high,critical_score from cp_assess_num_crit_score  where assess_note_id = ? and assess_catg_code = ? and comp_id=?";//common-icn-0180
				
				//stmtVal = con.createStatement();//common-icn-0180
				pstmt1 = con.prepareStatement(sql_num);//common-icn-0180
				pstmt1.setString(1, assess_note);//common-icn-0180
				pstmt1.setString(2, assess_catg);//common-icn-0180
				pstmt1.setString(3, comp_id);//common-icn-0180
				rsVal = pstmt1.executeQuery();//common-icn-0180
				//rsVal = stmtVal.executeQuery(sql_num);//common-icn-0180
				if(rsVal!=null)
				{
					if(rsVal.next())
					{
						num_normal_score = Integer.parseInt(rsVal.getString("normal_score"));
						num_abnormal_score = Integer.parseInt(rsVal.getString("abnormal_score"));
						num_critical_score = Integer.parseInt(rsVal.getString("critical_score"));
						normal_rng_low = rsVal.getString("normal_rng_low")==null?"":rsVal.getString("normal_rng_low");
						normal_rng_high = rsVal.getString("normal_rng_high")==null?"":rsVal.getString("normal_rng_high");
						abnormal_rng_low = rsVal.getString("abnormal_rng_low")==null?"":rsVal.getString("abnormal_rng_low");
						abnormal_rng_high = rsVal.getString("abnormal_rng_high")==null?"":rsVal.getString("abnormal_rng_high");
						critical_rng_low = rsVal.getString("critical_rng_low")==null?"":rsVal.getString("critical_rng_low");
						critical_rng_high = rsVal.getString("critical_rng_high")==null?"":rsVal.getString("critical_rng_high");
					}
				}
				out.println("<td  class='"+className+"' align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+" &nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE='text' size='2' name='txtnl"+i+"' id='txtnl"+i+"' value='"+normal_rng_low+"'>&nbsp;<INPUT TYPE='text' size='2' value='"+normal_rng_high+"' name='txtnh"+i+"' id='txtnh"+i+"'><BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"&nbsp;<INPUT TYPE='text' name='txtal"+i+"' id='txtal"+i+"' size='2' value='"+abnormal_rng_low+"'>&nbsp;<INPUT TYPE='text' name='txtah"+i+"' id='txtah"+i+"' size='2' value='"+abnormal_rng_high+"'><BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE='text' name='txtcl"+i+"' id='txtcl"+i+"' size='2' value='"+critical_rng_low+"'>&nbsp;<INPUT TYPE='text' name='txtch"+i+"' id='txtch"+i+"' size='2' value='"+critical_rng_high+"'></td>");
				out.println("</select></td>");
				out.println("<td class='"+className+"' align='center'><SELECT name='scorelistnor"+i+"' id='scorelistnor"+i+"'>");
				for(b=0;b<=1;b++)
				{
					if(num_normal_score==b)
					{
						//selected = "selected";
						out.println("<option value='"+b+"' selected>"+b+"</option>");
					}
					else
					{
						out.println("<option value='"+b+"'>"+b+"</option>");
					}
				}
				b = 0;
				out.println("</select><BR><SELECT name='scorelistabnor"+i+"' id='scorelistabnor"+i+"'>");
				if(num_abnormal_score==0)
					out.println("<option value='0' selected>0</option>");
				else
					out.println("<option value='0'>0</option>");
				for(b=2;b<=5;b++)
				{
					if(num_abnormal_score==b)
					{
						//selected = "selected";
						out.println("<option value='"+b+"' selected>"+b+"</option>");
					}
					else
					{
						out.println("<option value='"+b+"'>"+b+"</option>");
					}
				}
				b = 0;
				out.println("</select><BR><SELECT name='scorelistcrit"+i+"' id='scorelistcrit"+i+"'>");
				if(num_critical_score==0)
					out.println("<option value='0' selected>0</option>");
				else
					out.println("<option value='0'>0</option>");
				for(b=6;b<=9;b++)
				{
					if(num_critical_score==b)
					{
						//selected = "selected";
						out.println("<option value='"+b+"' selected>"+b+"</option>");
					}
					else
					{
						out.println("<option value='"+b+"'>"+b+"</option>");
					}
				}
				b = 0;
				if(rsVal!=null) rsVal.close();
				if(stmtVal!=null) stmtVal.close();
				out.println("</select></td>");
			}
			out.println("</tr>");
			i++;
		}
	}
%>
</TABLE>
<INPUT TYPE="hidden" name="maxRecord" id="maxRecord" value="<%=maxRecord%>">
<INPUT TYPE="hidden" name="assess_note" id="assess_note" value="<%=assess_note%>">
<INPUT TYPE="hidden" name="assess_catg" id="assess_catg" value="<%=assess_catg%>">
<INPUT type=hidden name="from" id="from" value="<%=start%>">
<INPUT type=hidden name="to" id="to" value="<%=end%>">
<INPUT type=hidden name="start" id="start" value="<%=start%>">
<INPUT type=hidden name="end" id="end" value="<%=end%>">
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
	if(rsVal!=null) rsVal.close();
	if(stmt!=null) stmt.close();
	if(stmtVal!=null) stmtVal.close();
	if(pstmt1!=null) pstmt1.close();//common-icn-0180
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

