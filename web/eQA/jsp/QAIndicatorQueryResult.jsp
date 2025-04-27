<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link> -->

<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	//String sql="" ;
	StringBuffer sql		= new StringBuffer();
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		//sql="";
		if (sql.length() > 0) sql.delete(0,sql.length());
        String qind_clind_id    = request.getParameter("qind_clind_id")==null ?"":request.getParameter("qind_clind_id");	
		String qind_clind_desc            = request.getParameter("qind_clind_desc")==null ?"":request.getParameter("qind_clind_desc");	
		String qind_group_id    = request.getParameter("qind_group_id")==null ?"":request.getParameter("qind_group_id");	
		String qind_group_desc    = request.getParameter("qind_group_desc")==null ?"":request.getParameter("qind_group_desc");	
		String clind_type        = (request.getParameter("clind_type")==null ||request.getParameter("clind_type").equals("A" )) ?"":request.getParameter("clind_type");	
		String clind_class    =( request.getParameter("clind_class")==null ||request.getParameter("clind_class").equals("A" ))?"":request.getParameter("clind_class");	
		String eff_status = request.getParameter("eff_status") == null ?"":request.getParameter("eff_status");
		int andCheck = 0;
		
		qind_clind_id=qind_clind_id.toUpperCase();

		if ( !(qind_clind_id == null || qind_clind_id.equals("")) )
		{
			if (sql.length() > 0) sql.delete(0,sql.length());
		   sql.append("where upper(qind_clind_id) like upper('"+qind_clind_id+"%')");
		   andCheck = 1;
		}
		
			if ( !(eff_status == null || eff_status.equals("")) )
		{
		   if ( eff_status.equals("E") )
		        {
			if ( andCheck == 0 )
			{
			if (sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where eff_status='E'");
			andCheck=1;
			}
			else
			{
			sql.append(" and eff_status='E'");
			}
			}
		   if ( eff_status.equals("D") )
			{
			if ( andCheck == 0 )
				{
				if (sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where  eff_status='D'");
				andCheck=1;
				}
			else
				{
				sql.append(" and eff_status='D'");
				}
		}
		}
		
			if ( !(qind_group_desc == null || qind_group_desc.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sql.append(" and upper(qind_group_desc)  like upper('"+qind_group_desc+"%') ");

				   }
				   else
				   {
					if (sql.length() > 0) sql.delete(0,sql.length());
					sql.append("where upper(qind_group_desc)  like upper('"+qind_group_desc+"%') " );
					andCheck = 1;
				   }
		}
		
		if ( !(qind_clind_desc == null || qind_clind_desc.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sql.append(" and upper(qind_clind_desc)  like upper('"+qind_clind_desc+"%') ");

				   }
				   else
				   {
					 if (sql.length() > 0) sql.delete(0,sql.length());
					sql.append("where upper(qind_clind_desc)  like upper('"+qind_clind_desc+"%') ");
					andCheck = 1;
				   }
		}

		if ( !(qind_group_id == null || qind_group_id.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sql.append(" and upper(qind_group_id)  like upper('"+qind_group_id+"%') ");

				   }
				   else
				   {
					if (sql.length() > 0) sql.delete(0,sql.length());
					sql.append("where upper(qind_group_id)  like upper('"+qind_group_id+"%') " );
					andCheck = 1;
				   }
		}

		if ( !(clind_type == null || clind_type.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sql.append(" and upper(clind_type)  like upper('"+clind_type+"%') ");

				   }
				   else
				   {
					if (sql.length() > 0) sql.delete(0,sql.length());
					sql.append("where upper(clind_type)  like upper('"+clind_type+"%') " );
					andCheck = 1;
				   }
		}

		if ( !(clind_class == null || clind_class.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sql.append(" and upper(clind_class)  like upper('"+clind_class+"%') ");

				   }
				   else
				   {
					    if (sql.length() > 0) sql.delete(0,sql.length());
					sql.append("where upper(clind_class)  like upper('"+clind_class+"%') ") ;
					andCheck = 1;
				   }
		}

		
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
				sql.append(ord[i]);
		else
			{
				sql.append(ord[i]);
				sql.append(",");
			}
		}
	}
} //end of where clause IF
else
{
if (sql.length() > 0) sql.delete(0,sql.length());
sql.append(whereClause);
}

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

Statement stmt=null;
ResultSet rset=null;
ResultSet rs=null;
Connection conn = ConnectionManager.getConnection(request);
int maxRecord = 0;
try{

stmt = conn.createStatement();
String strsql1="select count(*) as total from qa_qind_clind_vw "+sql.toString();

rs = stmt.executeQuery(strsql1);
if (rs.next())
	{
	maxRecord = rs.getInt("total");
	}
	if(rs!=null)rs.close();

	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); history.go(-1);</script>");

String strsql2="select * from qa_qind_clind_vw "+sql.toString();
rs = stmt.executeQuery(strsql2);

%>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>Previous</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>Next</A>");

%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th>Indicator ID</th>
<th>Indicator Description</th>
<th>Enabled</th>

<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue = "" ;
	  
while ( rs.next() && i<=end )
{
       if ( i % 2 == 0 )
       	  	classValue = "QRYEVEN" ;
       	  else
       	  	classValue = "QRYODD" ;
       	  

	out.println("<tr><td class='" + classValue + "'>");
	String qind_clind_id = rs.getString("qind_clind_id");
	

	out.println("<a href='../../eQA/jsp/addModifyQAIndicator.jsp?qind_clind_id="+ qind_clind_id +"'target='f_query_add_mod' >");
	out.println(qind_clind_id+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("qind_clind_desc") );
	out.println("</td><td class='" + classValue + "' align=center>");
	

	if ( rs.getString("eff_status").equals("E") )
	{

	out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			
	}
	else
	{
	
	out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");;
	}
	i++;

  }//endwhile
	if(rs!=null)	rs.close();
	if(rset!=null)	rset.close();
	if(stmt!=null)	stmt.close();
}
catch(Exception e)
{
		out.print(e.toString());
}
	finally   
	{
		ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br>
</BODY>
</HTML>

