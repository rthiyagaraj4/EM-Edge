<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	
	String whereClause = request.getParameter("whereclause");
	String from        = request.getParameter( "from" ) ;
	String to          = request.getParameter( "to" ) ;
	StringBuffer sb  = null;
    Statement stmt   = null;
    ResultSet rs     = null;
	Connection conn  = null;
	try
	{
		sb=new StringBuffer("");
		if ((whereClause == null || whereClause.equals("")) )
	{
	
		String qind_discipline_id      = request.getParameter("qind_discipline_id")==null ?"":request.getParameter("qind_discipline_id");	
		String qind_discipline_desc    = request.getParameter("qind_discipline_desc")==null ?"":request.getParameter("qind_discipline_desc");	
		String eff_status              = request.getParameter("eff_status") == null ?"":request.getParameter("eff_status");
		int andCheck = 0;
		qind_discipline_id=qind_discipline_id.toUpperCase();

		if ( !(qind_discipline_id == null || qind_discipline_id.equals("")) )
		{
		   sb.append(" where upper(qind_discipline_id) like upper('"+qind_discipline_id+"%')");
		  
		   andCheck = 1;
		}
		
			if ( !(eff_status == null || eff_status.equals("")) )
		{
		   if ( eff_status.equals("E") )
		        {
			if ( andCheck == 0 )
					{
				 if((sb != null) && (sb.length() > 0))
			     {
				   sb.delete(0,sb.length());
			     }
			sb.append(" where eff_status='E'");
					andCheck = 1;
					}
			else
					{
				sb.append(" and eff_status='E'");
				
					}
			}
		   if ( eff_status.equals("D") )
			{
			if ( andCheck == 0 )
				{
				if((sb != null) && (sb.length() > 0))
			     {
				   sb.delete(0,sb.length());
			     }
			
			    sb.append(" where  eff_status='D'");
				andCheck=1;
				}
			else
				{	
				sb.append(" and eff_status='D'");
			
				}
		}
		}
		
		
		if ( !(qind_discipline_desc == null || qind_discipline_desc.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sb.append(" and upper(qind_discipline_desc)  like upper('"+qind_discipline_desc+"%') ");
					

				   }
				   else
				   {
					if((sb != null) && (sb.length() > 0))
			     {
				   sb.delete(0,sb.length());
			     }
					sb.append(" where upper(qind_discipline_desc)  like upper('"+qind_discipline_desc+"%') ") ;
					
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
else
{
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


 conn = ConnectionManager.getConnection(request);
int maxRecord = 0;

stmt = conn.createStatement();
String strsql1="select count(*) as total from QA_QIND_DISCIPLINE "+sb.toString();
rs = stmt.executeQuery(strsql1);
if (rs.next())
	{
	maxRecord = rs.getInt("total");
	}
    if(rs!=null)	rs.close();
	
	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");


String strsql2="select * from QA_QIND_DISCIPLINE "+sb.toString();
rs = stmt.executeQuery(strsql2);

%>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eQA/jsp/QADisciplineQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sb.toString())+"'"+" text-decoration='none'>Previous</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eQA/jsp/QADisciplineQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sb.toString())+"'"+" text-decoration='none'>Next</A>");

%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th>Discipline Code</th>
<th>Discipline Description</th>
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
	String qind_discipline_id = rs.getString("qind_discipline_id");
	

	out.println("<a href='../../eQA/jsp/addModifyQADiscipline.jsp?qind_discipline_id="+ qind_discipline_id +"'target='f_query_add_mod' >");
	out.println(qind_discipline_id+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("qind_discipline_desc") );
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
    if((sb != null) && (sb.length() > 0))
	  {
	    sb.delete(0,sb.length());
	   }
    if(rs!=null)	rs.close();
     if(stmt!=null)	stmt.close();
	}
	catch(Exception e){
		out.print("Exception in File QADisciplineQueryResult"+e.toString());
}
	finally   {
	
	ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>


</center>
</BODY>
</HTML>

