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
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	27 Dec 2004
-->

<!-- OutcomeQueryResult.jsp-->

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 19/10/2005.
	request.setCharacterEncoding("UTF-8");
	String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale=(String)session.getAttribute("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
	<script language="javascript" src="../js/CpMessages.js"></script>  
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%

	String whereClause			=		request.getParameter("whereclause");
	String sql					=		"";
	String from					=		request.getParameter( "from" ) ;
	String to					=		request.getParameter( "to" ) ;
	String qryWhere				=		"";

	String qry_outcome_type		=		"";
	String qry_outcome_code		=		"";
	String qry_short_desc		=		"";
	String qry_Enabled			=		"";
	String outcome_code			=		"";
	String short_desc			=		"";
	String outcome_type			=		"";
	String eff_status			=		"";

	Connection conn				=		null;
	Statement stmt				=		null;
	ResultSet rs				=		null;
	int maxRecord				=		0;

	String sqlCount				=		"";
	String strsql				=		"";
	String classValue			=		"" ;




	if (whereClause == null || whereClause.equals(""))
		{
			qry_outcome_type	=	request.getParameter("outcome_type").equals("") ? "":request.getParameter("outcome_type");
			qry_outcome_code	=	request.getParameter("outcome_code").equals("") ? "":request.getParameter("outcome_code");
			qry_short_desc		=	request.getParameter("short_desc").equals("") ? "":request.getParameter("short_desc");
			qry_Enabled			=	request.getParameter("eff_status").equals("") ? "":request.getParameter("eff_status");

			qry_outcome_type	=	qry_outcome_type +"%";
			qry_outcome_code	=	qry_outcome_code +"%";
			qry_short_desc		=   qry_short_desc +"%";
			qry_Enabled			=	qry_Enabled + "%";
			
			
			

			qryWhere = "where upper(outcome_type) like upper('"+qry_outcome_type+"') and upper(outcome_code) like upper('"+qry_outcome_code+"') and upper(short_desc) like upper('"+qry_short_desc+"') and  upper(eff_status) like upper('"+qry_Enabled+"')AND LANGUAGE_ID = '"+locale+"'";


			sql = qryWhere;
			//appending order by clause
			String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql+" order by ";

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql=sql+ord[i];
			else
				sql=sql+ord[i]+",";
			}
		}
		}
	else
			sql = whereClause;	

try{
		conn		=		 ConnectionManager.getConnection(request);
		stmt		=		 conn.createStatement();
		//sqlCount	=		"select count(*) from cp_outcome "+ sql;
		sqlCount	=		"select count(*) from cp_outcome_lang_vw "+ sql;

		//strsql		=		"select outcome_code,short_desc,outcome_type,eff_status from cp_outcome "+ sql;
		strsql		=		"select outcome_code,short_desc,outcome_type,eff_status from cp_outcome_lang_vw "+ sql;

		int start	=		0 ;
		int end		=		0 ;
		int i=1;

		if ( from == null )
			start	=		1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end		=			14 ;
		else
			end		=			Integer.parseInt( to ) ;

		
rs = stmt.executeQuery(sqlCount);
if(rs.next())
{
	maxRecord		=		rs.getInt(1);

}
rs.close();
	if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");


%>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='OutcomeQueryResult.jsp?from="+(start-13)+"&to="+(end-13)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='OutcomeQueryResult.jsp?from="+(start+13)+"&to="+(end+13)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
</P>
<br><br>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		
	<tr>
		<th rowspan="2"><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
	<%
	rs = stmt.executeQuery(strsql);

	if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }
	while ( rs.next() && i<end)
	{

	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

    outcome_code		=	rs.getString("outcome_code")==null ? "":rs.getString("outcome_code");
	short_desc			=	rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	outcome_type		=	rs.getString("outcome_type")==null ? "":rs.getString("outcome_type");
	eff_status			=	rs.getString("eff_status")==null ? "D":rs.getString("eff_status");

	
	%>
		<tr>
			<td align="left" class=<%=classValue%>><a href="../../eCP/jsp/OutcomeAddModify.jsp?mode=2&outcome_code=<%=outcome_code%>&outcome_type=<%=outcome_type%>&eff_status=<%=eff_status%>"><%=outcome_code%></a></td>
			<td align="left" class=<%=classValue%>><%=short_desc%></td>
				<%if(outcome_type.equals("G")){%>
					<td align="left" class=<%=classValue%>>Goal</td>
				<%}else{%>
					<td align="left" class=<%=classValue%>>Expected Outcome</td>
				<%}%>
				<% if(eff_status.equals("E")){%>
				<td align="center" class=<%=classValue%>><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
				<%}else{%>
				<td align="center" class=<%=classValue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
					<%}%>
		</tr>
	
<%
	i++;

  }
  rs.close();
  
  %>
	  </table>
<%
}catch(Exception e)
{
	//out.println(e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();
}
finally {
	  if (rs != null)   rs.close();
	  if (stmt != null) stmt.close();
  	  if(conn != null)
		ConnectionManager.returnConnection(conn,request);
	}
%>

</BODY>
</HTML>

