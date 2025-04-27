<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<head>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link> -->
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	Statement stmt = null;
	ResultSet rs   = null;
	Connection conn= null;
	StringBuffer sb=null;
try
   {
	String whereClause = request.getParameter("whereclause");
    sb=new StringBuffer("");
	String from = request.getParameter( "from" ) ;

	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	
		String indicator_code    = request.getParameter("indicator_code")==null ?"":request.getParameter("indicator_code");	
		String indicator_desc	 = request.getParameter("indicator_desc")==null?"":request.getParameter("indicator_desc"); 
		String complication_code = request.getParameter("complication_code")==null ?"":request.getParameter("complication_code");	
		String complication_desc = request.getParameter("complication_desc") == null ?"":request.getParameter("complication_desc");
		int andCheck = 0;

		if ( !(indicator_code == null || indicator_code.equals("")) )
		{
		   sb.append("where upper(QIND_CLIND_ID) like upper('"+indicator_code+"%')");
		  
		   andCheck = 1;
		}
		if ( !(indicator_desc == null || indicator_desc.equals("")) )
	   	{
				   if ( andCheck == 1 )
				   {
				   	 sb.append(" and upper(QIND_CLIND_DESC)  like upper('"+indicator_desc+"%') ");
					
				   }
				   else
				   {
					if((sb != null) && (sb.length() > 0))
			       {
				   sb.delete(0,sb.length());
			       }
					sb.append("where upper(QIND_CLIND_DESC)  like upper('"+indicator_desc+"%')" );
					
					andCheck = 1;
				   }
		}
		if ( !(complication_code == null || complication_code.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sb.append(" and upper(COMPL_CODE)  like upper('"+complication_code+"%') ");
					

				   }
				   else
				   {
					if((sb != null) && (sb.length() > 0))
			       {
				   sb.delete(0,sb.length());
			       }
				   sb.append("where upper(COMPL_CODE)  like upper('"+complication_code+"%')" );
					
					andCheck = 1;
				   }
		}
		if ( !(complication_desc == null || complication_desc.equals("")) )
				{
				   if ( andCheck == 1 )
				   {
				   	sb.append(" and upper(COMPL_DESCRIPTION)  like upper('"+complication_desc+"%') ");
					
				   }
				   else
				   {
					if((sb != null) && (sb.length() > 0))
			       {
				   sb.delete(0,sb.length());
			       }
					sb.append("where upper(COMPL_DESCRIPTION)  like upper('"+complication_desc+"%')" );
					
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



int maxRecord = 0;

conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
String strsql1="select count(*) as total from QA_QIND_CLIND_COMPL_VW "+sb.toString();
rs = stmt.executeQuery(strsql1);
if (rs.next())
	{
	maxRecord = rs.getInt("total");
	}
	if(rs!=null) rs.close();
	

	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");


String strsql2="select * from QA_QIND_CLIND_COMPL_VW "+sb.toString();
rs = stmt.executeQuery(strsql2);

%>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eQA/jsp/QAComplicationsForIndicatorQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sb.toString())+"'"+" text-decoration='none'>Previous</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eQA/jsp/QAComplicationsForIndicatorQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sb.toString())+"'"+" text-decoration='none'>Next</A>");

%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th>Indicator Code</th>
<th>Indicator Description</th>
<th>Complication Code</th>
<th>Description</th>
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
	String indicator_code = rs.getString("QIND_CLIND_ID");
	String indicator_desc = rs.getString("QIND_CLIND_DESC");
	out.println("<a href='../../eQA/jsp/addModifyQAComplicationsForIndicator.jsp?indicator_code="+ indicator_code+"' target='f_query_add_mod' >");
	out.println(indicator_code+"</a></td><td class='" + classValue + "'>");
	out.println(indicator_desc);
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("COMPL_CODE"));
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("COMPL_DESCRIPTION"));

	
	i++;

  }//endwhile
    if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{
		out.print("Exception in File QAComplicationsForIndicatorQueryResult"+e.toString());
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

