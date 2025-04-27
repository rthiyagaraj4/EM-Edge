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
*	Created By		:	Sandhya.S
*	Created On		:	24 jan 2005

--%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale=(String) session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<SCRIPT language="JavaScript" src="../../eCP/js/BuildLibrary.js"></SCRIPT>

<%
	String whereClause = request.getParameter("whereclause");
	String sql="";
	String versionno="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String qryWhere = "";
	String qry_library_id="";
	String qry_short_desc="";
	String library_id="";
	String short_desc  = "";

	String sqlCount = "";
	String librarysqlquery = ""	;
	String classValue = "" ;



	Connection conn = null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;
	int start = 0 ;
	int end = 0 ;

	if (whereClause == null || whereClause.equals(""))
		{
			
			 qry_library_id=request.getParameter("LIBRARY_ID")==null ? "":request.getParameter("LIBRARY_ID");
			 qry_short_desc=request.getParameter("SHORT_DESC")==null ? "":request.getParameter("SHORT_DESC");

			qry_library_id =  qry_library_id +"%";
		     qry_short_desc  = qry_short_desc +"%";

			 qryWhere = "where language_id='"+locale+"' and upper(LIBRARY_ID) like upper('"+qry_library_id+"') and upper(SHORT_DESC) like upper('"+qry_short_desc+"')";
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
		}else
			sql = whereClause;

			
			try{
				conn = ConnectionManager.getConnection(request);
				stmt = conn.createStatement();
				 sqlCount = "SELECT COUNT(*) FROM CP_LIBRARY_LANG_VW "+ sql;

				 librarysqlquery = "SELECT LIBRARY_ID,VERSION_NO,SHORT_DESC FROM CP_LIBRARY_LANG_VW "+ sql;
				
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
	out.println("<A HREF='../../eCP/jsp/BuildLibraryQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eCP/jsp/BuildLibraryQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
</P>
	<br><br>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		
	<tr>
		<th width="25%" ><fmt:message key="eCP.LibraryID.label" bundle="${cp_labels}"/></th>
		<th><fmt:message key="eCP.VersionNo.label" bundle="${cp_labels}"/></th>
		<th nowrap><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		
	</tr>
<%
	stmt = conn.createStatement();
	rs = stmt.executeQuery(librarysqlquery);

	if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }
	while ( rs.next() && i<=end)
	{
			
	if ( i % 2 == 0 )

		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

			 library_id = rs.getString("library_id")==null ? "":rs.getString("library_id");
			short_desc  = rs.getString("short_desc")==null ? "":rs.getString("short_desc");
			versionno	= rs.getString("VERSION_NO")==null	?"":rs.getString("VERSION_NO");
			
			%>

		<tr>
			<td align="left" class='<%=classValue%>'><label  style="cursor:pointer " onclick="showQueryDetails('<%=library_id%>','<%=short_desc%>','<%=versionno%>')"><B><font color=blue>+</font></B></label>&nbsp;<%=library_id%></td>
			<td align="center" class='<%=classValue%>'><%=versionno%></td>
			<td align="left" class='<%=classValue%>'><%=short_desc%></td>
		</tr>
	
	<%

			i++;
		}
			if(rs!=null) 	rs.close();
			  if(stmt!=null) stmt.close();
  %>
	  </table>

	<%
			}catch(Exception e){
			//	out.println(e.getMessage());//COMMON-ICN-0181
			e.printStackTrace();
			}
			finally {
				if (rs != null)   rs.close();
				if (stmt != null) stmt.close();
				if(conn != null)
				ConnectionManager.returnConnection(conn,request);
	}
		
	%>

