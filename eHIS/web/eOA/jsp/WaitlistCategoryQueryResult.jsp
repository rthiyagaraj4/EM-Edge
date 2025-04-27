<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
    <HTML>
		<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		</head>
		<BODY  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  class='CONTENT' >
<%
request.setCharacterEncoding("UTF-8");
    String whereClause = request.getParameter("whereclause");

    StringBuffer sql=new StringBuffer("");
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;

    if ( (whereClause == null || whereClause.equals("")) )
    {
	sql.setLength(0);
	sql.append("");
	
	String scode = request.getParameter("waitlist_code");
	if(scode==null) scode = "";
	
	String ldesc = request.getParameter("long_desc"); 
	if(ldesc==null) ldesc = "";
	
	String sdesc = request.getParameter("short_desc"); 
	if(sdesc==null) sdesc = "";
	
	String estatus = request.getParameter("eff_status");
	if(estatus==null) estatus = "";
	
	int andCheck = 0;

	
	
	scode=scode.toUpperCase();
	if ( !(scode == null || scode.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(WAITLIST_CATEGORY_CODE) like  upper('"+scode+"%')" );
		}
		else
		{
			sql.setLength(0);
			sql.append( "where upper(WAITLIST_CATEGORY_CODE) like upper('"+scode+"%')" );
			andCheck = 1;
		}

	}

	if ( !(ldesc == null || ldesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(long_desc) like  upper( '"+ldesc+"%')" );
		}
		else
		{
			sql.setLength(0);
			sql.append(" where upper( long_desc)  like upper('"+ldesc+"%') " );
			andCheck = 1;
		}
	}

	if ( !(sdesc == null || sdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(short_desc)  like  upper( '"+sdesc+"%') " );
		}
		else
		{ 
			sql.setLength(0);
			sql.append("where upper(short_desc) like upper('"+sdesc+"%') " );
			andCheck = 1;
		}
	}

	if ( !(estatus == null || estatus.equals("")) )
	{
	     
	   if ( estatus.equals("E") )
	   {
		if ( andCheck == 0 )
		   {
			sql.setLength(0);
			sql.append("where eff_status='E'");
		   }
		else
			sql.append(" and eff_status='E'");
	   }
	   if ( estatus.equals("D") )
	   {
		if ( andCheck == 0 )
		   {
			sql.setLength(0);
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
		
	Connection conn = null;
	Statement stmt=null;
	ResultSet rs=null;
	int maxRecord = 0;

    try
    {
   	conn = ConnectionManager.getConnection(request);	


		String strsql2="select * from OA_WAITLIST_CATEGORY "+sql.toString();
		stmt = conn.createStatement();
		if(rs!=null) 	rs.close();
		rs = stmt.executeQuery(strsql2);

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

<p>
	<table align='right'>
	 <tr>
	<%
	if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eOA/jsp/WaitlistCategoryQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//	if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eOA/jsp/WaitlistCategoryQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>
	 </tr>
	</table>
</p>
<br><br>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<td class='COLUMNHEADER'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

<% }

	String classValue = "" ;
	
	        if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			
		

		out.println("<tr><td class='" + classValue + "'>");
		String code = rs.getString("WAITLIST_CATEGORY_CODE");
		out.println("<a href='../../eOA/jsp/addModifyWaitlistCategory.jsp?code="+ code + "' target='f_query_add_mod'>"+code+"<a>");
		out.println("</td><td class='" + classValue + "'>");
		out.println(rs.getString("long_desc") );
		out.println("</td><td class='" + classValue + "'>");
		out.println(rs.getString("short_desc") );
		out.println("</td><td align='center' class='" + classValue + "'>");
		if ( rs.getString("eff_status").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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

	if(rs!=null) 	rs.close();
    if(stmt!=null) 	stmt.close();
    }
	catch(Exception e)
    {
		e.toString();
    }
	finally   
	{	
		sql.setLength(0);
	    ConnectionManager.returnConnection(conn,request);	
	}
%>
		</td>
	</tr>
</table>
</BODY>
</HTML>

