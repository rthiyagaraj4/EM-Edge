<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
<%
	Connection conn=null;
	Statement stmt=null;
	try{
	request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
	ResultSet rs=null;


// This is included to check the logged in user name
%>


<HTML><head><%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		</head><BODY class='CONTENT'  OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer() ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	if(sql.length() > 0) sql.delete(0,sql.length());
	String cd = request.getParameter("code");
	String longdesc = request.getParameter("long_desc");
	String enabled = request.getParameter("enabled");

	int andCheck = 0;


	if ( !(cd == null || cd.equals("")) )
		{
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append("where mar_status_code like '"+cd+"%'");
		andCheck = 1;
		}
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	sql.append( " and ");
			sql.append("long_desc like  '"+longdesc+"%'");
		}
		else
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append( "where long_desc like '"+longdesc+"%'");
			andCheck = 1;
		}
	}
	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("E") )
	        {
		if ( andCheck == 0 )
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append("where eff_status='E'");
		}
		else
			sql.append(" and eff_status='E'");
		}
	   if ( enabled.equals("D") )
		{
		if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where  eff_status='D'");
			}
		else
			sql.append(" and eff_status='D'");
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
	} //end of where clause IF
	else
		{
			if(sql.length() > 0) sql.delete(0,sql.length());
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

	stmt = conn.createStatement();
	int maxRecord = 0;
	rs = stmt.executeQuery("select count(*) as total from sm_site_param "+sql.toString());
	rs.next();
	maxRecord = rs.getInt("total");
	if(rs!=null) rs.close();

	rs = stmt.executeQuery("select * from sm_site_param "+sql.toString());

%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
		{%>
	<A HREF='../jsp/querySiteParameter.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/>
</A>
	<%}
if ( !( (start+14) > maxRecord ) )
		{%>
	<A HREF='../jsp/querySiteParameter.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>

<%}sql.setLength(0);%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th><fmt:message key="eSM.SiteID.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="Common.SiteName.label" bundle="${common_labels}"/></th>

<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  String classValue = "" ;

while ( rs.next() && i<=end )
{
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	%>
	<tr><td align='left' class='<%=classValue%>'>
	<%
	String code = rs.getString("site_id");
	%>
	<a href='../jsp/SiteParameterModify.jsp?site_id=<%=code%>' target='f_query_add_mod' >
	<%=code%></a></td><td class='<%=classValue%>'>
	<%
	String name = rs.getString("site_name");
	%>
	<%=name%></td>
	<%
	i++;
}   
if(rs != null) rs.close();
if(stmt != null) stmt.close();
%>
</tr>
</table>
<br><center>
<%
}catch(Exception e){out.println(e);}
finally {
			ConnectionManager.returnConnection(conn,request);
		}

%>

</center>
</BODY>
</HTML>

