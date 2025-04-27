<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
request.setCharacterEncoding("UTF-8");	
	String whereClause = request.getParameter("whereclause");
	String sql="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	String qryWhere = "";

	if ((whereClause == null || whereClause.equals("")))
	{
		
		String qry_position_code = request.getParameter("position_desc").equals("") ? "":request.getParameter("position_desc");
		
		String qry_shift_desc = request.getParameter("shift_desc").equals("") ? "":request.getParameter("shift_desc");
		if(qry_position_code==null) qry_position_code="";
		if(qry_shift_desc==null) qry_shift_desc="";
		
qryWhere = "where  b.shift_code = a.shift_code and c.position_code = a.position_code and a.eff_status='E'";
if(!qry_position_code.equals(""))
qryWhere =qryWhere+"and a.position_code = nvl('"+qry_position_code+"',a.position_code)";
if(!qry_shift_desc.equals(""))
qryWhere=qryWhere+" and b.shift_code = nvl('"+qry_shift_desc+"',a.shift_code)";
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
	String position_code = "";
	String shift_desc = "";

Connection conn = ConnectionManager.getConnection(request);
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
try{
stmt = conn.createStatement();

String strsql = "select a.position_code,a.shift_code,b.short_desc shift_desc,c.position_desc position_desc1  from am_shift_for_position a, am_shift b, am_position c "+ sql;


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



	rs = stmt.executeQuery(strsql);

	if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		 {
			rs.next() ;
		 }
	while ( i<=end && rs.next() )
	{
		if(maxRecord==0)
		{
%>
	
<P>
<table align='right'>
<tr>
<%
	
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='ShiftForPositionQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='ShiftForPositionQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
</P>
<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<tr>
<td class='columnheader' ><fmt:message key="Common.Position.label" bundle="${common_labels}"/></td>
<td class='columnheader'><fmt:message key="Common.SHIFT.label" bundle="${common_labels}"/></td>
</tr>

<% }
	String classValue = "" ;
	

	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
		  
	position_code = rs.getString("position_desc1")==null ? "":rs.getString("position_desc1");
	shift_desc = rs.getString("shift_desc")==null ? "":rs.getString("shift_desc");
	
	out.println("<td class='" + classValue + "'>");
	out.println(position_code +"</td><td class='" + classValue + "'>");
	out.println(shift_desc +"</td></tr>");
	i++;
	maxRecord++;
  }//end of while

  if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}

  %>
	  </table>
<%
}catch(Exception e)
{
	e.printStackTrace();
}
finally {
	  if (rs != null)   rs.close();
	  if (stmt != null) stmt.close();
	  
	  ConnectionManager.returnConnection(conn,request);
	}
%>

</body>
</html>

