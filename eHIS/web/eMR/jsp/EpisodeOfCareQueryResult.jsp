<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	sanjay Patil
*	Created On		:	20 jan 2005

--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	/*----- Required while Selecting sql and Formatting display------*/
	//String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	//String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;
	request.setCharacterEncoding("UTF-8"); 
	String whereClause = request.getParameter("whereclause");
	String sql="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String qryWhere = "";

	if (whereClause == null || whereClause.equals(""))
		{
			String qry_eoc_code = request.getParameter("eoc_code").equals("") ? "":request.getParameter("eoc_code");
			String qry_short_desc = request.getParameter("short_desc").equals("") ? "":request.getParameter("short_desc");
			String qry_Enabled = request.getParameter("eff_status").equals("") ? "":request.getParameter("eff_status");

			qry_eoc_code = qry_eoc_code +"%";
			qry_short_desc  =   qry_short_desc +"%";
			qry_Enabled = qry_Enabled + "%";
			
			

			qryWhere = "where upper(eoc_code) like upper('"+qry_eoc_code+"')  and upper(short_desc) like upper('"+qry_short_desc+"') and  upper(eff_status) like upper('"+qry_Enabled+"')";


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
		
			String eoc_code="";
			String short_desc  = "";
			String long_desc = "";
			String eff_status = "";
			
Connection conn = null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
try{
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
String sqlCount = "select count(*) from MR_EPISODE_OF_CARE "+ sql;

String strsql = "select eoc_code,long_desc,short_desc,eff_status from MR_EPISODE_OF_CARE "+ sql;

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
	out.println("<A HREF='EpisodeOfCareQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='EpisodeOfCareQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
</P>
<br><br>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		
	<tr>
		<th rowspan="2"><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th rowspan="2" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th rowspan="2"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	</tr>
	<tr>
	<%
	String classValue = "" ;
	stmt = conn.createStatement();
	rs = stmt.executeQuery(strsql);

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

    eoc_code = rs.getString("eoc_code")==null ? "":rs.getString("eoc_code");
	short_desc  = rs.getString("short_desc")==null ? "":rs.getString("short_desc");
	long_desc = rs.getString("long_desc")==null ? "":rs.getString("long_desc");
	eff_status = rs.getString("eff_status")==null ? "D":rs.getString("eff_status");
	%>
		<tr>
			<td align="left" class=<%=classValue%>><a href="../../eMR/jsp/EpisodeOfCareAddModify.jsp?mode=2&eoc_code=<%=eoc_code%>"><%=eoc_code%></a></td>
			<td align="left"  class=<%=classValue%>><%=long_desc%></td>
			<td align="left"  class=<%=classValue%>><%=short_desc%></td>
			<% if(eff_status.equals("E")){%>
				<td align="center" class=<%=classValue%>><img src='../../eCommon/images/enabled.gif' align='center'></img></td>
				<%}else{%>
				<td align="center" class=<%=classValue%>><img src='../../eCommon/images/RRnwd.gif' align='center'></img></td>
				<%}%>
		</tr>
	
<%i++;

  }
  if(rs!=null) 	rs.close();
  if(stmt!=null) stmt.close();
  %>
	  </table>
<%
}catch(Exception e)
{
	//out.println(e.getMessage());
	e.printStackTrace();
}
finally {
	  if (stmt != null) stmt.close();
	  if (rs != null)   rs.close();
	  ConnectionManager.returnConnection(conn,request);
	}
%>

</BODY>
</HTML>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

