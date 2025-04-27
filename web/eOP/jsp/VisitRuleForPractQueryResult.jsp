<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script></head><BODY  OnMouseDown='CodeArrest()' onLoad='ClearMsg()'  onKeyDown = 'lockKey()' class='CONTENT'>
<%
request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null)
		whereClause="";
	StringBuffer sql=new StringBuffer(" ");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	
	if((whereClause == null || whereClause.equals("")))
	{
	sql.setLength(0);
	sql.append("");
	String rule_id = request.getParameter("rule_id");
	String pract_id = request.getParameter("pract_id");
	String prname = request.getParameter("pract_name");	

	if ( !(rule_id == null || rule_id.equals("")) )
	{
		sql.setLength(0);
		sql.append("and upper(a.rule_id) like upper('"+rule_id+"%')");
	}
	if ( !(pract_id == null || pract_id.equals("")) )
	{
		sql.setLength(0);
		sql.append("and upper(a.practitioner_id) like upper('"+pract_id+"%')");
	}

	if ( !(prname == null || prname.equals("")) )
	{
		sql.append(" and ");
		sql.append("upper(b.practitioner_name) like  upper('"+prname+"%') " );
	}
	}
	else
	{	sql.setLength(0);
		sql.append(whereClause);
	}

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
	else
	{	
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

Connection conn=null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
try
{

conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
//out.println("sql-->"+sql);

if(rs!=null)rs.close();
rs = stmt.executeQuery("SELECT a.rule_id,a.practitioner_id,b.practitioner_name FROM op_visit_rule_for_pract a,am_practitioner b WHERE a.practitioner_id =b.practitioner_id "+sql);

if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

while ( i<=end && rs.next() )
  {
	if(maxRecord==0)
	  {

%>

<p>
<table align='right'>
<tr>

<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eOP/jsp/VisitRuleForPractQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOP/jsp/VisitRuleForPractQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

%>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="eOP.RuleID.label" bundle="${op_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></th>
</td>

<% }

	  String classValue = "" ;

        if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	
	out.println("<tr><td nowrap class='"+classValue+"'>");	 
	out.println( rs.getString("rule_id")+"</td><td class='" + classValue + "'>");	
	out.println( rs.getString("practitioner_id")+"</td><td class='" + classValue + "'>");	
	out.println( rs.getString("practitioner_name") );
	out.println("</td><td class='" + classValue + "'>");
	i++;
	maxRecord++;
  }// end of while

  if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById("next"))
		document.getElementById("next").style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}

}// end of try
catch(Exception e){out.println(e);}
finally
{
	try
	{
	if(stmt!=null)	stmt.close();
	if(rs!=null) 	rs.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	ConnectionManager.returnConnection(conn,request);

}%>

</td></tr>
</table>
<br>
</BODY>
</HTML>
