<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*, java.lang.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()'>

<%
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");

	StringBuffer sql= new StringBuffer("");

	String from = request.getParameter( "from" );
	String to = request.getParameter( "to" );

	if ( (whereClause == null || whereClause.equals("")) )
	{
		String facility_id    = request.getParameter("facility_id")==null ?"":request.getParameter("facility_id");	
		String resource_class    = request.getParameter("resource_class")==null ?"":request.getParameter("resource_class");
		String resource_type    = request.getParameter("resource_type")==null ?"":request.getParameter("resource_type");
		String short_desc    = request.getParameter("short_desc")==null ?"":request.getParameter("short_desc");
		String resource_id    = request.getParameter("resource_id")==null ?"":request.getParameter("resource_id");
		String long_desc    = request.getParameter("long_desc")==null ?"":request.getParameter("long_desc");
		String enabled    = request.getParameter("eff_status")==null ?"":request.getParameter("eff_status");
		
		
		int andCheck = 0;

	

		if ( !(facility_id == null || facility_id.equals("")) )
		{
			sql.append("and upper(a.facility_id) like upper('"+facility_id+"%')");
			andCheck = 1;
		}

		if ( !(resource_class == null || resource_class.equals("")) )
		{
			if(resource_class.equals("A")) resource_class="";
			
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append(" upper(a.resource_class) like upper('"+resource_class+"%')");
			}
			else
			{
				sql.append(" and upper(a.resource_class) like upper('"+resource_class+"%')");
				andCheck = 1;
			}
		}

		if ( !(resource_type == null || resource_type.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append(" upper(a.resource_type) like upper('"+resource_type+"%')");
			}
			else
			{
				sql.append(" and upper(a.resource_type) like upper('"+resource_type+"%')");
				andCheck = 1;
			}
		}

		if ( !(short_desc == null || short_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append(" upper(b.short_desc)  like  upper('"+short_desc+"%')");
			}
			else
			{
				sql.append(" and upper(b.short_desc)  like upper('"+short_desc+"%')");
				andCheck = 1;
			}
		}

		if ( !(resource_id == null || resource_id.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append(" upper(a.resource_id)  like  upper('"+resource_id+"%')");
			}
			else
			{
				sql.append(" upper(a.resource_id)  like upper('"+resource_id+"%')");
				andCheck = 1;
			}
		}
		
		if ( !(long_desc == null || long_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append(" upper(a.long_desc)  like  upper('"+long_desc+"%')");
			}
			else
			{
				sql.append(" and upper(a.long_desc)  like upper('"+long_desc+"%')");
				andCheck = 1;
			}
		}
		if ( !(enabled == null || enabled.equals("")) )
		{
			if (enabled.equals("E"))
			{
				if (andCheck == 0)
					sql.append(" and a.eff_status='E'");
				else
					sql.append(" and a.eff_status='E'");
			}
		   if (enabled.equals("D"))
		   {
				if (andCheck == 0)
					sql.append(" and a.eff_status='D'");
				else
					sql.append(" and a.eff_status='D'");
		   }
		}

		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord.equals("")) )
		{
			sql.append(" order by ");

			for (int i=0;i < ord.length;i++)
		 	{
	 			if (i == ord.length - 1)
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
		
		String strsql2="select a.facility_id,a.resource_class,a.resource_type,(b.short_desc)a1,a.resource_id,a.long_desc,(a.short_desc)a2,a.eff_status from am_resource a,am_resource_type b where a.resource_type = b.resource_type "+sql;
		stmt = conn.createStatement();
		if(rs!=null)rs.close();
		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}

		while ( i<=end && rs.next())
		{
			if(maxRecord==0)
			{
%>
		<P>
		<table align='right'>
		<tr>
<%
		
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/EqpOthResourceQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//		if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/EqpOthResourceQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");	
%>
		</tr>
		</table>
		</P>
		<br><br>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<th class='columnheader'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.resourceclass.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="eAM.ResourceTypeDescription.label" bundle="${am_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.resourceid.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%	}
		/* This for loop is to take the record pointer to the corresponding record in the result set. */

		
		String classValue = "" ;
		
			if ( i % 2 == 0 )
			  	classValue = "QRYEVEN" ;
			else
		  		classValue = "QRYODD" ;

			out.println("<tr><td  class='" + classValue + "'>");

			String facility_id = rs.getString("facility_id");
			String resource_class = rs.getString("resource_class");
			String resource_type = rs.getString("resource_type");
		
			String resource_type_description=rs.getString("a1");
			
			String resource_id = rs.getString("resource_id");
			String long_desc = rs.getString("long_desc");
			String short_desc = rs.getString("a2");

			if (resource_class.equals("E")) resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			if (resource_class.equals("O")) resource_class=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			
			out.println("<a href='../../eAM/jsp/addModifyEqpOthResource.jsp?facId="+facility_id+"&resource_class="+resource_class+"&resource_type="+resource_type+"&resource_type_desc="+resource_type_description+"&resource_id="+resource_id+"' target='f_query_add_mod' >");
			out.println(facility_id+"</a></td><td  class='" + classValue + "'>");

			out.println("<a href='../../eAM/jsp/addModifyEqpOthResource.jsp?facId="+facility_id+"&resource_class="+resource_class+"&resource_type_desc="+resource_type_description+"&resource_type="+resource_type+"&resource_id="+resource_id+"' target='f_query_add_mod' >");
			out.println(resource_class+"</a></td><td  class='" + classValue + "'>");
			
			out.println("<a href='../../eAM/jsp/addModifyEqpOthResource.jsp?facId="+facility_id+"&resource_class="+resource_class+"&resource_type_desc="+resource_type_description+"&resource_type="+resource_type+"&resource_id="+resource_id+"' target='f_query_add_mod' >");
			out.println(resource_type+"</a></td><td  class='" + classValue + "'>");
			out.println(resource_type_description+"</td><td  class='" + classValue + "'>");			
			out.println("<a href='../../eAM/jsp/addModifyEqpOthResource.jsp?facId="+facility_id+"&resource_class="+resource_class+"&resource_type_desc="+resource_type_description+"&resource_type="+resource_type+"&resource_id="+resource_id+"' target='f_query_add_mod' >");
			out.println(resource_id+"</a></td><td  class='" + classValue + "'>");
			
			out.println(long_desc+"</td><td  class='" + classValue + "'>");
			out.println(short_desc+"</td><td align='center' class='" + classValue + "'>");
			if ( rs.getString("eff_status").equals("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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

		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{
		//e.toString();
		//out.println("First : "+e);
		e.printStackTrace();
	}
	finally 
	{
		
		ConnectionManager.returnConnection(conn,request);
	}

%>
			</td></tr>
		</table>
	</BODY>
</HTML>

