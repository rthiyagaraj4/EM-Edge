<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>


<%
	request.setCharacterEncoding("UTF-8");
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer("");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) ||whereClause.equals("null"))
	{
		sql.append("");
		String cd = request.getParameter("dept_code");
		if(cd==null) 
		cd = "";
		String longdesc = request.getParameter("long_desc");
		String enabled = request.getParameter("nature");
		
		int andCheck = 0;
		cd=cd.toUpperCase();
		
		if ( !(cd == null || cd.equals("")) )
		{
		sql.append("where upper(dept_code) like upper('"+cd+"%')");
		andCheck = 1;
		}
			if ( !(longdesc == null || longdesc.equals("")) )
			{
					if ( andCheck == 1 )
					{	sql.append(" and ");
						sql.append("upper(long_desc)  like  upper('"+longdesc+"%')" );
					}
					else
					{
						sql.append("where upper(long_desc)  like upper('"+longdesc+"%')" );
						andCheck = 1;
					}
			}
			if ( !(enabled == null || enabled.equals("")) )
			{
				   if ( enabled.equals("E") )
					{
					if ( andCheck == 0 )
						sql.append("where eff_status='E'");
					else
						sql.append(" and eff_status='E'");
					}
				   if ( enabled.equals("D") )
					{
					if ( andCheck == 0 )
						sql.append(" where  eff_status='D'");
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
	Statement stmt1=null;
	ResultSet rset=null;
	ResultSet rs=null;

	int maxRecord = 0;

	try
	{
		conn = ConnectionManager.getConnection(request);

		stmt = conn.createStatement();
		
		String strsql2="select acc_entity_id,long_desc,short_desc,eff_status,dept_code from am_dept "+sql;
		rs = stmt.executeQuery(strsql2);

		if ( start != 1 )
			 for( int j=1; j<start; i++,j++ ){
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
					out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/DepartmentqueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

					out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/DepartmentqueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
				%>
				
			</tr>
		</table>
	</p>

	<br>
	<br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th class='columnheader'><fmt:message key="Common.AccountingEntity.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

		<% }
		
			  String classValue = "" ;
			  String acc_entity_id = "";
			  String acc_entity_desc = "";

			if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				  else
					classValue = "QRYODD" ;

				acc_entity_id = rs.getString("acc_entity_id");
				

					if (acc_entity_id==null) acc_entity_id = "";
			stmt1 = conn.createStatement();
				strsql2="select accounting_name_short from sm_acc_entity_param where acc_entity_id = '"+acc_entity_id+"'";
				rset = stmt1.executeQuery(strsql2);
				if (rset !=null && rset.next())
				acc_entity_desc = rset.getString("accounting_name_short");
			else
				acc_entity_desc = "";
			

			if (acc_entity_desc.equals(""))
				out.println("<tr><td class='" + classValue + "'>&nbsp;");
			else
			{
				out.println("<tr><td class='" + classValue + "'>");
					out.println( acc_entity_desc );
			}
			
			out.println("</td><td class='" + classValue + "'>");
			String code = rs.getString("dept_code");

			out.println("<a href='../../eAM/jsp/addModifyDepartment.jsp?dept_code="+ code + "' target='f_query_add_mod' >");
			out.println(code+"</a></td><td class='" + classValue + "'>");
			out.println( rs.getString("long_desc") );
			out.println("</td><td class='" + classValue + "'>");
			out.println(rs.getString("short_desc") );
			out.println("</td><td align='center' class='" + classValue + "'>");
			if ( rs.getString("eff_status").equals("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				
		  if(rset!=null) rset.close();
		  if(stmt1!=null) stmt1.close();

			i++;
			maxRecord++;

		  }//endwhile

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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
		  
		   if(rset!=null) rset.close();
		  if(stmt1!=null) stmt1.close();
		  
		}
		catch(Exception e)
		{
			e.toString();
		}
		finally 
		{	
			if(rs!=null) rs.close();
		  if(rset!=null) rset.close();
		  if(stmt!=null) stmt.close();	
		  if(stmt1!=null) stmt1.close();	
			
			sql.setLength(0);
			ConnectionManager.returnConnection(conn,request);	
		}
	%>
	</td></tr>
	</table>
	<br>
</BODY>
</HTML>

