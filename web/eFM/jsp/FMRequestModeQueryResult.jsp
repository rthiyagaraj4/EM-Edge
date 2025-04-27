<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	10/06/2002
	Module			:	FM - Deficiency
	Function		:	This function is used to load query result set for the function
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="javascript" src="../js/FMRequestMode.js"></script>

<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='' onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>");
	
	StringBuffer sql		= null;
	StringBuffer strsql1	= null;
	StringBuffer strsql2	= null;
	sql						= new StringBuffer();
	strsql1					= new StringBuffer();
	strsql2					= new StringBuffer();

	String whereClause = request.getParameter("whereclause");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int andCheck = 0;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		String req_mode		= request.getParameter("req_mode");
		String long_desc	= request.getParameter("long_desc");
		String enabled		= request.getParameter("eff_status");
				

		if (!(req_mode == null || req_mode.equals("")) )
		{
			req_mode=req_mode.toUpperCase();
			sql.append(" where req_mode like '"+req_mode+"%' ");
			andCheck = 1;
		} 

		if ( !(long_desc == null || long_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sql.append(" and ");
				sql.append("upper(long_desc) like  upper('"+long_desc+"%') ");
			}
			else
			{
				sql.append("where upper(long_desc) like  upper('"+long_desc+"%') ");
				andCheck = 1;
			}
		}
		if ( !(enabled == null || enabled.equals("")) )
		{
			if ( enabled.equals("E") )
		    {
				if ( andCheck == 0 )
				{
					sql.append("where eff_status='E' ");
					andCheck = 1;
				}
		
				else
				{
					sql.append(" and eff_status='E' ");
				}
			}
			if ( enabled.equals("D") )
			{
				if ( andCheck == 0 )
				{
					sql.append(" where  eff_status='D' ");
					andCheck = 1;
				}
				else
				{
					sql.append(" and eff_status='D' ");
				}
			}
		}
		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				{
				sql.append(ord[i]);
				}
			else
				{
				sql.append(ord[i]);
				sql.append(" , ");
				}
			}
		}
	}// end if whereClause
	else 
	{
		sql.append(whereClause);
	}

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null ) start = 1 ;
	else start = Integer.parseInt( from ) ;

	if ( to == null ) end = 14 ;
	else end = Integer.parseInt( to ) ;

	Connection conn = null;
	java.sql.Statement stmt = null;
	ResultSet rs=null;
//	int maxRecord = 0;

	try
	{
		conn = webbeans.eCommon.ConnectionManager.getConnection(request);
	
		stmt = conn.createStatement();
		/*strsql1.append(" select count(*) as total from fm_manual_request_mode ");
		strsql1.append(sql);
		rs = stmt.executeQuery(strsql1.toString());
		rs.next();
		maxRecord = rs.getInt("total");

	   if (maxRecord== 0)
	  {*/
	  %>
	  	<script>
		//alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
	//	parent.frames[1]. location.href ="../../eFM/jsp/FMRequestModeQueryCriteria.jsp" ;
		</script>
	 <%
	  //}
		if(rs!=null)	rs.close();
		strsql2.append(" select req_mode, long_desc,short_desc,eff_status from fm_manual_request_mode ");
		strsql2.append(sql);
		rs = stmt.executeQuery(strsql2.toString());
	
	%>

	

	<%
		if ( start != 1 )

		for( int j=1; j<start; i++,j++ )
		{
		  rs.next() ;
		}

		String classValue = "" ;
		int cnt=0;
		while ( i<=end && rs.next())
		{
			if(cnt==0)
			{%>
				<P>
				<table align='right'>
				<tr>
				
				<%
				if ( !(start <= 1) )
				out.println("<td align ='right' id='prev'><A HREF='../jsp/FMRequestModeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
				%>
				<td align ='right' id='next' style='visibility:hidden'>
				<%
				//if ( !( (start+14) > maxRecord ) )
				out.println("<A HREF='../jsp/FMRequestModeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				%>
				</td>
				</tr>
				</table>
				<br><br>
				</P>

				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th class='columnheader'><fmt:message key="Common.RequestMode.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%			}
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			String req_mode	=	rs.getString("req_mode");
			String long_desc		=	rs.getString("long_desc");
			String short_desc		=	rs.getString("short_desc");
			String eff_status		=	rs.getString("eff_status");

			if(req_mode==null || req_mode.equals("null")) req_mode="&nbsp;";
			if(long_desc==null || long_desc.equals("null")) long_desc="&nbsp;";
			if(short_desc==null || short_desc.equals("null")) short_desc="&nbsp;";
			
			out.println("<tr><td class='" + classValue + "'>");
			out.println("<a href='../jsp/FMRequestModeAddModify.jsp?req_mode="+req_mode+ "&target=f_query_add_mod&operation=modify'>");
			out.println(req_mode+"</a></td><td class='" + classValue + "' >");
			out.println(long_desc);
			out.println("<td class='" + classValue + "' >");
			out.println(short_desc);
			out.println("</td><td class='" + classValue + "' align='center'>");
			if (eff_status.equals("E") )
				out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			else
				out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

			out.println("</td></tr>");	
			i++;
			cnt++;
		}//endwhile

		if (cnt==0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		boolean flag = false;
		if ( cnt < 14 || (!rs.next()) ) {
		%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
			</script>
		<% flag = true;
				} else {%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%}

		if((sql != null) && (sql.length() >0))
		{
			sql.delete(0,sql.length());
		}
		if((strsql1 != null) && (strsql1.length() >0))
		{
			strsql1.delete(0,strsql1.length());
		}
		if((strsql2 != null) && (strsql2.length() >0))
		{
			strsql2.delete(0,strsql2.length());
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println(e.toString());
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

