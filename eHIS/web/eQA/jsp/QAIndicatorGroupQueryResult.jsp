<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.URLEncoder,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/messages.js"></Script>
<Script src="../../eQA/js/QAMessages.js" language="JavaScript"></Script>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");
String whereClause    = request.getParameter("whereclause");
StringBuffer strbuff  = new StringBuffer();
String from           = request.getParameter( "from" ) ;
String to             = request.getParameter( "to" ) ;
if ( (whereClause == null || whereClause.equals("")) )
{
	String qind_group_id    = request.getParameter("qind_group_id")==null ?"":request.getParameter("qind_group_id");	
	String qind_group_desc  = request.getParameter("qind_group_desc")==null ?"":request.getParameter("qind_group_desc");	
	String eff_status       = request.getParameter("eff_status") == null ?"":request.getParameter("eff_status");
	int andCheck            = 0;
	qind_group_id=qind_group_id.toUpperCase();
	if ( !(qind_group_id == null || qind_group_id.equals("")) )
	{
		strbuff.append("where upper(qind_group_id) like upper('"+qind_group_id+"%')");
	    andCheck = 1;
	}
	if ( !(eff_status == null || eff_status.equals("")) )
	{
	   if ( eff_status.equals("E") )
	   {
		 if ( andCheck == 0 )
		 {	
			strbuff.append("where eff_status='E'");
			andCheck=1;
		 }
		 else
		 {	
			strbuff.append("and eff_status='E'");
		 }
	  }
	  if ( eff_status.equals("D") )
	  {
		if ( andCheck == 0 )
		{	
			strbuff.append(" where  eff_status='D'");
			andCheck=1;
		}
		else
		{
			strbuff.append(" and eff_status='D'");
		}
	  }
	}
	if ( !(qind_group_desc == null || qind_group_desc.equals("")) )
	{
	  if ( andCheck == 1 )
	  {
	   	strbuff.append(" and upper(qind_group_desc)  like upper('"+qind_group_desc+"%') ");
      }
	  else
	  {
		strbuff.append("where upper(qind_group_desc)  like upper('"+qind_group_desc+"%') ") ;
		andCheck = 1;
	  }
	}
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	if ( !(ord == null || ord .equals("")) )
	{
		strbuff.append(" order by ");
		for ( int i=0;i < ord.length;i++ )
	 	{
	 		if ( i == ord.length - 1 )
				strbuff.append(ord[i]);
			else
				strbuff.append(ord[i]+",");
		}
	}
} //end of where clause IF
else
{
	strbuff.append(whereClause);
}
int start = 0 ;
int end   = 0 ;
int i     = 1;
if ( from == null )
	start = 1 ;
else
	start = Integer.parseInt( from ) ;
if ( to == null )
  	end = 14 ;
else
	end = Integer.parseInt( to ) ;

Statement stmt = null;
ResultSet rs   = null;
Connection conn = ConnectionManager.getConnection(request);
int maxRecord = 0;
try
{
	stmt = conn.createStatement();
	String strsql1="select count(*) as total from qa_qind_group "+strbuff.toString();
	rs = stmt.executeQuery(strsql1);
	if (rs.next())
	{
		maxRecord = rs.getInt("total");
	}if(rs!=null)	rs.close();
	 
	if(maxRecord == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));history.go(-1);</script>");
	String strsql2="select * from qa_qind_group "+strbuff.toString();
	rs = stmt.executeQuery(strsql2);
%>
<p>
<table align='right'>
<tr><td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(strbuff.toString())+"'"+" text-decoration='none'>Previous</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../../eQA/jsp/QAIndicatorGroupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(strbuff.toString())+"'"+" text-decoration='none'>Next</A>");

%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th>Group Code</th>
<th>Group Description</th>
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
   String qind_group_id = rs.getString("qind_group_id");
   out.println("<a href='../../eQA/jsp/addModifyQAIndicatorGroup.jsp?qind_group_id="+ qind_group_id +"'target='f_query_add_mod' >");
   out.println(qind_group_id+"</a></td><td class='" + classValue + "'>");
   out.println( rs.getString("qind_group_desc") );
   out.println("</td><td class='" + classValue + "' align=center >");
   if ( rs.getString("eff_status").equals("E") )
   {
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
   }
   else
   {
	   out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");;
   }
   out.println("</td>");
   i++;
 }//endwhile
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
}catch(Exception e){
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

