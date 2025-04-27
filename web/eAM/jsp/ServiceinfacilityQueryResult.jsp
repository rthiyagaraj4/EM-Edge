<!DOCTYPE html>
<%--
	FileName	: SubserviceinfacilityQueryResult.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>
    <HTML>
		<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		</head>
		<BODY  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  class='CONTENT' >
		<form name='ServiceinFacility_query' id='ServiceinFacility_query'>

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
	String fid = request.getParameter("operating_facility_id");
	if(fid==null) fid = "";

	String fname = request.getParameter("facility_name");
	if(fname==null) fname = "";
	
	String scode = request.getParameter("service_code");
	if(scode==null) scode = "";
	
	String sdesc = request.getParameter("service_short_desc"); 
	if(sdesc==null) sdesc = "";
	
	String dcode = request.getParameter("dept_code");
	if(dcode==null) dcode = "";
	
	String dname = request.getParameter("dept_short_desc"); 
	if(dname==null) dname = "";
	
	String estatus = request.getParameter("eff_status");
	if(estatus==null) estatus = "";
	
	int andCheck = 0;

	fid=fid.toUpperCase();
	if ( !(fid == null || fid.equals("")) )
	{
		sql.setLength(0);
		sql.append( "where operating_facility_id like '"+fid+"%'");
		andCheck = 1;
	}

	if ( !(fname == null || fname.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(facility_name)  like  upper('"+fname+"%') " );
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(facility_name)  like upper('"+fname+"%') " );
			andCheck = 1;
		}
	}

	scode=scode.toUpperCase();
	if ( !(scode == null || scode.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(service_code) like  upper('"+scode+"%')" );
		}
		else
		{
			sql.setLength(0);
			sql.append( "where upper(service_code) like upper('"+scode+"%')" );
			andCheck = 1;
		}

	}

	if ( !(sdesc == null || sdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(service_short_desc) like  upper( '"+sdesc+"%')" );
		}
		else
		{
			sql.setLength(0);
			sql.append(" where upper( service_short_desc)  like upper('"+sdesc+"%') " );
			andCheck = 1;
		}
	}

	dcode=dcode.toUpperCase();
	if ( !(dcode == null || dcode.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(dept_code) like  upper('"+dcode+"%')" );
		}
		else
		{
			sql.setLength(0);
			sql.append("where upper(dept_code) like upper('"+dcode+"%')" );
			andCheck = 1;
		}
	}
	

	if ( !(dname == null || dname.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sql.append(" and upper(dept_short_desc)  like  upper( '"+dname+"%') " );
		}
		else
		{ 
			sql.setLength(0);
			sql.append("where upper( dept_short_desc) like upper('"+dname+"%') " );
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
			sql.append(sql+ord[i]+",");
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
	

		String strsql2="select * from am_facility_service_vw "+sql.toString();
		stmt = conn.createStatement();
		if(rs!=null) 	rs.close();
		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}

		while( i<=end && rs.next() )
		{
			if(maxRecord==0)
			{
%>

<p>
	<table align='right'>
	 <tr>
		
	<%
	if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/ServiceinfacilityQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/ServiceinfacilityQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
	%>
		
	 </tr>
	</table>
</p>
<br><br>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th class='columnheader'><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.ServiceDescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/></th> 
		<th class='columnheader'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/> <fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<% }
  
	String classValue = "" ;
	
	        if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			
		

		out.println("<tr><td class='" + classValue + "'>");
		String code = rs.getString("service_code");
		String fcode= rs.getString("operating_facility_id");
		
		out.println(fcode+"</td><td class='" + classValue + "'>");
		out.println( rs.getString("facility_name") );
		out.println("</td><td class='" + classValue + "'>");
		out.println(code);
		out.println("</td><td class='" + classValue + "'>");
		out.println(rs.getString("service_short_desc") );
		out.println("</td><td class='" + classValue + "'>");
		out.println(rs.getString("dept_code") );
		out.println("</td><td class='" + classValue + "'>");
		out.println(rs.getString("dept_short_desc") );
		out.println("</td><td align='center' class='" + classValue + "'>");
		if ( rs.getString("eff_status").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		i++;
		maxRecord++;

  	}//end of while

	 if(maxRecord == 0)
		{ %>
			 <script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<% }

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

