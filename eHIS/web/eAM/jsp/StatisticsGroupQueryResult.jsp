<!DOCTYPE html>
<%--
	FileName	: StatisticsGroupQueryResult.jsp
	Version	    : 3	
	Modified On	: 23-2-2005
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>



<HTML><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()' onLoad=''>
<%
request.setCharacterEncoding("UTF-8");	
	String strsql2="";
	StringBuffer sql=new StringBuffer(" ");
	String strsql1=" ";

	String whereClause = request.getParameter("whereclause");

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int andCheck = 0;


	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql.setLength(0);
		sql.append(" ");
		String grp_id    = request.getParameter("stat_grp_id");
		String grp_desc= request.getParameter("stat_grp_desc");
		String grp_cat  = request.getParameter("stat_grp_cat") ;
				

			if (!(grp_id == null || grp_id.equals("")) )
			{
				grp_id=grp_id.toUpperCase();
				sql.setLength(0);
				sql.append(" where upper(stat_grp_id) like upper('"+grp_id+"%')  ");
				andCheck = 1;
			}

			if ( !(grp_desc == null || grp_desc.equals("")) )
			{
				if ( andCheck == 1 )
				{	
					sql.append(" and ");
					sql.append(" upper(stat_grp_desc)  like  upper('"+grp_desc+"%') " );
				}
				else
				{
					sql.setLength(0);
					sql.append("where upper(stat_grp_desc)  like  upper('"+grp_desc+"%') " );
					andCheck = 1;
				}
			}

			if ( !(grp_cat == null || grp_cat.equals("")) )
			{
				if(!grp_cat.equals("A"))
				{
				if ( andCheck == 1 )
				{	
					sql.append( " and ");
					sql.append( "stat_grp_cat like  upper('"+grp_cat+"%') " );
				}
				else
				{
					sql.setLength(0);
					sql.append( "where stat_grp_cat like  upper('"+grp_cat+"%') " );
					andCheck = 1;
				}
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
				sql.append(ord[i]+",");
			}

		}

	}// end if whereClause
	else {
		sql.setLength(0);
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

Connection conn = ConnectionManager.getConnection(request);
Statement stmt=null;

ResultSet rs=null;
int maxRecord = 0;

try
{
	stmt				= conn.createStatement();
	strsql1			= "select count(*) as total from AM_STAT_GROUP "+  sql;
	rs					= stmt.executeQuery(strsql1);
	rs.next();
	maxRecord	= rs.getInt("total");	
	
	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");

	strsql2			="select * from AM_STAT_GROUP "+  sql;	
	if(rs!=null) rs.close();
	rs					= stmt.executeQuery(strsql2);	
	%>

<P>
<table align='right'>
<tr >
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAM/jsp/StatisticsGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eAM/jsp/StatisticsGroupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
</P>
<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th width='25%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/> </th>
	<th width='50%'><fmt:message key="Common.description.label" bundle="${common_labels}"/> </th>
	<th width='25%'><fmt:message key="Common.category1.label" bundle="${common_labels}"/> </th>

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
			String code = rs.getString("stat_grp_id");
			
			out.println("<a href='../../eAM/jsp/AddModifyStatisticsGroup.jsp?stat_grp_id="+ code + "&target=f_query_add_mod&operation=modify' >");
			out.println(code+"</a></td><td class='" + classValue + "' >");
			out.println( rs.getString("stat_grp_desc"));
			out.println("<td class='" + classValue + "' >");

			if ( rs.getString("stat_grp_cat").equals("N") )
				out.println("Nationality");
			else if ( rs.getString("stat_grp_cat").equals("S") )
				out.println("Service");
			else if ( rs.getString("stat_grp_cat").equals("P") )
				out.println("Speciality");

				out.println("");
		
			out.println("</td></tr>");	
			
			i++;

		}//endwhile

	
}
catch(Exception e){
		out.println(e.toString());
}
finally {
	try{
	if(rs!=null)	 	rs.close();
	if(stmt!=null)	stmt.close();

	}
	catch(Exception e)
	{}
ConnectionManager.returnConnection(conn,request);
}
%>

</td></tr>
</table>
<br><center>


</center>
</BODY>
</HTML>

