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
*	Created By		:	Sreelatha
*	Created On		:	27 Dec 2004
-->

<!-- CaseTypeQueryResult.jsp-->

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

	String whereClause = request.getParameter("whereclause");

	String sql="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String qryWhere = "";

	String qry_case_type_code="";
	String qry_short_desc="";
	String qry_case_type_nature="";
	String qry_Enabled = "";


	String case_type_code="";
	String short_desc  = "";
	String case_type_nature = "";
	String eff_status = "";

	Connection conn = null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

	String sqlCount = "";
	String strsql = "";
	String classValue = "" ;


	if (whereClause == null || whereClause.equals(""))
		{
			
			 qry_case_type_code=request.getParameter("case_type_code")==null ? "":request.getParameter("case_type_code");
			 qry_short_desc=request.getParameter("short_desc")==null ? "":request.getParameter("short_desc");
			 qry_case_type_nature=request.getParameter("case_type_nature")==null ? "":request.getParameter("case_type_nature");
			 qry_Enabled = request.getParameter("eff_status").equals("") ? "":request.getParameter("eff_status");

			 qry_case_type_nature =  qry_case_type_nature +"%";
		     qry_case_type_code  = qry_case_type_code +"%";
			qry_short_desc  =   qry_short_desc +"%";
			qry_Enabled = qry_Enabled + "%";
			
			

			qryWhere = "where upper(case_type_nature) like upper('"+qry_case_type_nature+"') and upper(case_type_code) like upper('"+qry_case_type_code+"') and upper(short_desc) like upper('"+qry_short_desc+"') and  upper(eff_status) like upper('"+qry_Enabled+"') and language_id='"+locale+"'";
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
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
 sqlCount = "select count(*) from cp_case_type_lang_vw "+ sql;

strsql = "select case_type_code,short_desc,case_type_nature,eff_status from  cp_case_type_lang_vw "+ sql;


	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;

		
rs = stmt.executeQuery(sqlCount);
if(rs.next())
{
	maxRecord = rs.getInt(1);

}
if(stmt!=null) 	stmt.close();	
	if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");


%>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='CaseTypeQueryResult.jsp?from="+(start-13)+"&to="+(end-13)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='CaseTypeQueryResult.jsp?from="+(start+13)+"&to="+(end+13)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");


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
		<th rowspan="2"><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
	<%
	stmt = conn.createStatement();
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

    case_type_code = rs.getString("case_type_code")==null ? "":rs.getString("case_type_code");
	short_desc  = rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	case_type_nature = rs.getString("case_type_nature")==null ? "":rs.getString("case_type_nature");
	eff_status = rs.getString("eff_status")==null ? "D":rs.getString("eff_status");
	%>
		<tr>
			<td align="left" class=<%=classValue%>><a href="../../eCP/jsp/CaseTypeAddModify.jsp?mode=2&case_type_code=<%=case_type_code%>&case_type_nature=<%=case_type_nature%>&eff_status=<%=eff_status%>"><%=case_type_code%></a></td>
			<td align="left" class=<%=classValue%>><%=short_desc%></td>
				<%if(case_type_nature.equals("I")){%>
					<td align="left" class=<%=classValue%>><fmt:message key="eCP.lllness.label" bundle="${cp_labels}"/></td>
				<%}else{%>
					<td align="left" class=<%=classValue%>><fmt:message key="Common.Wellness.label" bundle="${common_labels}"/></td>
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
  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
  %>
	  </table>
<%
}catch(Exception e)
{
	out.println(e.getMessage());
	e.printStackTrace();
}
finally {
	  if (rs != null)   rs.close();
	  if (stmt != null) stmt.close();
	  ConnectionManager.returnConnection(conn,request);
	}
%>

</BODY>
</HTML>

