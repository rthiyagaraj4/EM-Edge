<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<%

	String whereClause = request.getParameter("whereclause");
	String sql="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String qryWhere = "";
	if (whereClause == null || whereClause.equals(""))
		{
			
			String qry_library_id=request.getParameter("LIBRARY_ID")==null ? "":request.getParameter("LIBRARY_ID");
			String qry_short_desc=request.getParameter("SHORT_DESC")==null ? "":request.getParameter("SHORT_DESC");
			String qry_version_no=request.getParameter("VERSION_NO")==null ? "":request.getParameter("VERSION_NO");
			String qry_status=request.getParameter("STATUS")==null ? "":request.getParameter("STATUS");
			String qry_Enabled = request.getParameter("EFF_STATUS").equals("") ? "":request.getParameter("EFF_STATUS");

			 qry_library_id =  qry_library_id +"%";
		     qry_short_desc  = qry_short_desc +"%";
			qry_version_no  =   qry_version_no +"%";
			qry_status  =   qry_status +"%";
			qry_Enabled = qry_Enabled + "%";
			
			

			qryWhere = "where language_id='"+locale+"' and upper(LIBRARY_ID) like upper('"+qry_library_id+"') and upper(SHORT_DESC) like upper('"+qry_short_desc+"') and upper(VERSION_NO) like upper('"+qry_version_no+"') and upper(STATUS) like upper('"+qry_status+"')and  upper(eff_status) like upper('"+qry_Enabled+"')";
		

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

			String library_id="";
			String short_desc  = "";
			//String long_desc="";
			String version_no = "";
			String status="";
			String eff_status = "";

			Connection conn = null;
			Statement stmt=null;
			ResultSet rs=null;
			int maxRecord = 0;
			try{
				conn = ConnectionManager.getConnection(request);
				stmt = conn.createStatement();
				String sqlCount = "select count(*) from cp_library_lang_vw "+ sql;

				String librarysqlquery = "select library_id,short_desc,long_desc,version_no,eff_status,decode(status,'I','Inactive','D','Draft','F','Final') status from cp_library_lang_vw "+ sql;
				
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
	out.println("<A HREF='../../eCP/jsp/LibrarySetUpQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eCP/jsp/LibrarySetUpQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
</P>
	<br><br>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		
	<tr>
		<th ><fmt:message key="eCP.LibraryID.label" bundle="${cp_labels}"/></th>
		<th ><fmt:message key="eCP.VersionNo.label" bundle="${cp_labels}"/></th>
		<th nowrap><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
<%
	String classValue = "" ;
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
			version_no = rs.getString("version_no")==null ? "":rs.getString("version_no");
			status = rs.getString("status")==null ? "":rs.getString("status");
			eff_status = rs.getString("eff_status")==null ? "D":rs.getString("eff_status");
			//long_desc=rs.getString("long_desc")==null ? "D":rs.getString("long_desc");
			
	%>

		<tr>
			<td align="left" class=<%=classValue%>><a href="../../eCP/jsp/LibrarySetUpFrameSet.jsp?mode=2&library_id=<%=library_id%>&version_no=<%=version_no%>&eff_status=<%=eff_status%>"><%=library_id%></a></td>
			<td align="left" class=<%=classValue%>><%=version_no%></td>
			<td align="left" class=<%=classValue%>><%=short_desc%></td>
			<td align="left" class=<%=classValue%>><%=status%></td>
			<% if(eff_status.equals("E")){%>
				<td align="Center" class=<%=classValue%>><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
				<%}else{%>
				<td align="Center" class=<%=classValue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
				<%}%>
		</tr>
	<%i++;
		}
			if(rs!=null) 	rs.close();
			  if(stmt!=null) stmt.close();
  %>
	  </table>

	<%
			}catch(Exception e){
				out.println(e.getMessage());
			e.printStackTrace();
			}
			finally {
				if (rs != null)   rs.close();
				if (stmt != null) stmt.close();
			    if(conn != null)
					ConnectionManager.returnConnection(conn,request);
	}
		
	%>

