<!DOCTYPE html>
<!--Created by P.Anuradha on Jan-06-2005-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language=JavaScript src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../../eOR/js/OrMessages.js"></script>

</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name="TermSetQueryResult_Form" id="TermSetQueryResult_Form">
<%
	request.setCharacterEncoding("UTF-8");
	//String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	//String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;
	Connection conn = null;
    Statement stmt=null;
    ResultSet rs=null;
    String whereClause = request.getParameter("whereclause");
//out.println("<script>alert(\"whereClause:"+whereClause+"\");</script>");
	String sql="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String qryWhere = "";
	String qry_termset_id="";
	String qry_desc="";
	String qry_Enabled="";
	//String sqlCount="";
	String TermSetSelectSql="";
	int start = 0 ;
	int end = 0 ;
	int k=1;
	if (whereClause == null || whereClause.equals(""))
	{
		qry_termset_id = request.getParameter("TermSet_ID")==null? "":request.getParameter("TermSet_ID");
		qry_desc = request.getParameter("TermSet_Desc")==null? "":request.getParameter("TermSet_Desc");
		qry_Enabled = request.getParameter("eff_status_yn")==null? "":request.getParameter("eff_status_yn");
		qry_termset_id = qry_termset_id +"%";
		qry_desc  =   qry_desc +"%";
		qry_Enabled = qry_Enabled+"%";
		qryWhere = " where a.onset_type_cutoff_unit=b.durn_type(+) and upper(term_set_id) like upper('"+qry_termset_id+"')  and upper(term_set_desc) like upper('"+qry_desc+"') and upper(eff_status) like upper('"+qry_Enabled+"')";
		sql = qryWhere;
		//if(!(request.getParameterValues("orderbycolumns") == null || request.getParameterValues("orderbycolumns").equals(""))){
		String ord[] = request.getParameterValues("orderbycolumns");
		
		if ( !(ord == null || ord .equals("")) )
		{
			sql=qryWhere+" order by ";
			for ( int i=0;i < ord.length;i++ )
			{
				if(ord[i]==null) ord[i]="";
				if ( i == ord.length - 1 )
					sql=sql+ord[i];
				else
					sql=sql+ord[i]+",";
			}
		}
		/*
		Anjaneya reddy addedd code for SCF:SRR20056-SCF-2597
		*/
		else{
			sql=qryWhere+"order by term_set_id";
			
		}
		/*
		End appended code
		*/
	}
	else
			sql = whereClause;
		
String termset_id="";
String termset_desc  = "";
String eff_status = "";
			

int maxRecord = 0;
try
{
	conn = ConnectionManager.getConnection(request);
	//stmt = conn.createStatement();

	//sqlCount = "select count(*) from mr_term_set a,am_duration_type b "+sql;

	
	//try
	//{
		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;


		if ( to == null )
			end = 14 ;
		else
			end = Integer.parseInt( to ) ;


	/*rs = stmt.executeQuery(sqlCount);
	if(rs.next())
	{
		maxRecord = rs.getInt(1);
	}

	if(stmt!=null) 	stmt.close();	
		if(maxRecord == 0)
		{	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}*/
		
		TermSetSelectSql = "select term_set_id,term_set_desc,diag_spec_yn,proc_spec_yn,incl_for_stats_yn,build_eoc_yn, defn_levels,level_1_desc,level_1_code_length,level_2_desc,level_2_code_length,level_3_desc, level_3_code_length,level_4_desc,level_4_code_length,level_5_desc,level_5_code_length,priority_appl_yn,age_group_appl_yn,nature_appl_yn,factors_appl_yn,notification_appl_yn,sensitivity_appl_yn,severity_appl_yn,onset_type_appl_yn,onset_type_cutoff_prd,onset_type_cutoff_unit,eff_status,level_6_desc,level_6_code_length,level_7_desc,level_7_code_length,level_8_desc, level_8_code_length,level_9_desc,level_9_code_length,level_10_desc,level_10_code_length from mr_term_set a,am_duration_type b "+sql;

//out.println("<script>alert(\"TermSetSelectSql:"+TermSetSelectSql+"\");</script>");

		stmt = conn.createStatement();
		rs = stmt.executeQuery(TermSetSelectSql);

		if ( start != 1 )
		 for( int j=1; j<start; k++,j++ )
		 {
			rs.next() ;
		 }

		 while (k<=end && rs.next())
			{
				if (maxRecord==0)
				{
	%>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMR/jsp/TermSetQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			
		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/TermSetQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	/*}
	catch(Exception exp)
	{
		out.println(exp.getMessage());
		exp.printStackTrace();
	}*/
%>

			</tr>
			</table>
			</P>
			<br><br>
			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				
				<tr>
					<th rowspan="2"><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
					<th rowspan="2"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					<th rowspan="2"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
				</tr>
				<tr>
<%
				}
			String classValue = "" ;
	//stmt = conn.createStatement();
	//rs = stmt.executeQuery(TermSetSelectSql);

	/*if ( start != 1 )
		 for( int j=1; j<start; k++,j++ )
		 {
			rs.next() ;
		 }*/
	//while (rs.next() && k<=end)
	//{

		if (k%2 == 0)
		  	classValue = "QRYEVEN" ;
		else
		  	classValue = "QRYODD" ;

		termset_id = rs.getString("term_set_id")==null ? "":rs.getString("term_set_id");
		termset_desc = rs.getString("term_set_desc")==null ? "":rs.getString("term_set_desc");
		eff_status  = rs.getString("eff_status")==null?"":rs.getString("eff_status");
%>
		<tr>
		<td align="left" class=<%=classValue%>><a href="../../eMR/jsp/TermSetAddModify.jsp?mode=2&termset_id=<%=termset_id%>"><%=termset_id%></a></td>
				<td align="left" class=<%=classValue%>><%=termset_desc%></td>
				<% if(eff_status.equals("E")){%>
					<td align="center" class=<%=classValue%>><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
					<%}else{%>
					<td align="center" class=<%=classValue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
					<%}%>
		</tr>
<%		
		k++;
		maxRecord++;
			}

		
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		if ( maxRecord < 14 || (!rs.next()) )
		{
		%>
			<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='hidden';
			</script>
		<% 
		}
		else
		{%>
			<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%
		}

  //if(rs!=null) 	rs.close();
  //if(stmt!=null) stmt.close();
  %>
	  </table>
<%
}catch(Exception e)
{
	//out.println(e.getMessage());
	e.printStackTrace();
}
finally 
{
	  if (stmt != null) stmt.close();
	  if (rs != null)   rs.close();
	  ConnectionManager.returnConnection(conn,request);
}
%>
</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

