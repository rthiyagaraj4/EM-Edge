<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.*,java.net.*,java.text.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	
<%
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()'  class='CONTENT' onKeyDown = 'lockKey()' >");
    Connection conn  = null;
    Statement  stmt  = null;
    ResultSet  rs    = null;
	StringBuffer sb=null;
	try{
	String whereClause = request.getParameter("whereclause");
    sb=new StringBuffer("");
	
	
	String from = request.getParameter( "from" ) ;
	String to   = request.getParameter( "to" ) ;

    	if ( (whereClause == null || whereClause.equals("")) )
	{
	
	String qind_discipline_id 	= request.getParameter("qind_discipline_id");	
	if(qind_discipline_id==null) qind_discipline_id="";
	String qind_discipline_desc 	= request.getParameter("qind_discipline_desc");	
	if(qind_discipline_desc==null) qind_discipline_desc="";


	String qind_clind_id 	= request.getParameter("qind_clind_id");
	if(qind_clind_id==null) qind_clind_id="";
	
	String qind_clind_desc 	= request.getParameter("qind_clind_desc");
	if(qind_clind_desc==null) qind_clind_desc	="";
		
	String qind_slno 	= request.getParameter("qind_slno");	
	if(qind_slno==null||qind_slno.equals("S")) qind_slno="";

	
	int andCheck = 0;

	qind_discipline_id=qind_discipline_id.toUpperCase();
	
	if ( !(qind_discipline_id == null || qind_discipline_id.equals("")) )
	{
		sb.append("where qind_discipline_id like '"+qind_discipline_id+"%'");
		
		
		andCheck = 1;
	}
	if ( !(qind_discipline_desc == null || qind_discipline_desc.equals("")) )
	{
		if((sb != null) && (sb.length() > 0))
			{
				sb.delete(0,sb.length());
			}
		 sb.append(" where qind_discipline_desc like '"+qind_discipline_desc+"%'");
		
		
		andCheck = 1;
	}
	
	if ( !(qind_clind_desc == null || qind_clind_desc.equals("")) )
	{
		sb.append(" where qind_clind_desc like '"+qind_clind_desc+"%'");
		
		
		andCheck = 1;
	}
	if ( !(qind_clind_id == null || qind_clind_id.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sb.append(" and ");
            sb.append(" qind_clind_id like  upper('"+qind_clind_id+"%') ");
		}
		else
		{
			if((sb != null) && (sb.length() > 0))
			{
				sb.delete(0,sb.length());
			}
			sb.append("where qind_clind_id like upper('"+qind_clind_id+"%') ");
			
			
			andCheck = 1;
		}
	}
	
	if ( !(qind_slno == null || qind_slno.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sb.append(" and upper(qind_slno) like  upper('"+qind_slno+"%')");
		}
		else
		{
			if((sb != null) && (sb.length() > 0))
			{
				sb.delete(0,sb.length());
			}
			sb.append("where upper(QIND_SLNO) like upper('"+qind_slno+"%')");
			andCheck = 1;
		}
	}
		//appending order by clause
		
	
	String ord[] = request.getParameterValues("orderbycolumns");
    
	if ( !(ord == null || ord .equals("")) )
	{
		
		sb.append(" order by ");

		for ( int i=0;i < ord.length;i++ )
	 	{
	 	if ( i == ord.length - 1 )
			 sb.append(ord[i]);
		else
			sb.append(ord[i]+",");
		     
		
		}
	}
} //end of where clause IF
	else {
		if((sb != null) && (sb.length() > 0))
			{
				sb.delete(0,sb.length());
			}
			sb.append(whereClause);
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

int maxRecord = 0;

conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
String strsql1="select count(*) as total from qa_qind_discipline_clind_vw "+sb.toString();

rs = stmt.executeQuery(strsql1);
rs.next();
maxRecord = rs.getInt("total");

if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");

if(stmt!=null) 	stmt.close();
if(rs!=null) rs.close();
String strsql2="select * from qa_qind_discipline_clind_vw "+sb.toString();
stmt = conn.createStatement();
rs = stmt.executeQuery(strsql2);
%>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorsForDisciplineQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sb.toString())+"'"+" text-decoration='none'>Previous</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorsForDisciplineQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sb.toString())+"'"+" text-decoration='none'>Next</A>");
%>
</td>
</tr>
</table>
</p>
<br>
<br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th>Discipline Code</th>
<th>Discipline Description</th>
<th>Indicator ID</th>
<th>Serial No</th>

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

	out.println("<tr><td class='" + classValue + "' >");
	String qind_discipline_id 	= rs.getString("qind_discipline_id");
	String qind_clind_id	= rs.getString("qind_clind_id");
	String qind_discipline_desc	= rs.getString("qind_discipline_desc");
	String qind_slno 	= rs.getString("qind_slno");	
		
	out.println("<a href='../../eQA/jsp/QAModifyIndicatorsForDiscipline.jsp?qind_discipline_id="+qind_discipline_id+"&qind_clind_id="+qind_clind_id+"' target='f_query_add_mod' >");
	out.println(qind_discipline_id +"</a></td><td class='" + classValue + "' >");
	out.println(qind_discipline_desc+"</td><td class='" + classValue + "' >");
	out.println(qind_clind_id+"</td><td class='" + classValue + "' >");
	out.println(qind_slno+"</td><td class='" + classValue + "' >");
	i++;
  }//endwhile
  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
  if((sb != null) && (sb.length() > 0))
	{
		sb.delete(0,sb.length());
	}
}catch(Exception e)
{
		out.println("Exception in File QAIndicatorsForDisciplineQueryResult"+e.toString());
}
	finally  
	{
		ConnectionManager.returnConnection(conn,request);
	}
%>
</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

