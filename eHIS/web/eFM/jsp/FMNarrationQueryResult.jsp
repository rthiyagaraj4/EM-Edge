<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
</head>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>

<%
	Connection conn		= ConnectionManager.getConnection(request);
	
	String whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter( "from" ) ;
	String to			= request.getParameter( "to" ) ;
	
	StringBuffer sql = null;
	sql				 = new StringBuffer();


	if((whereClause == null || whereClause.equals("")))
	{
		String cd = request.getParameter("NARRATION_CODE");
		String cd1= request.getParameter("LONG_DESC");
		String status = request.getParameter("eff_status");

		int andCheck = 0;

		if(!(cd == null || cd.equals("")))
		{
			cd = cd.toUpperCase();
			sql.append("where upper(NARRATION_CODE) like '"+cd+"%' ");
			andCheck = 1;
		}
		if(!(cd1 == null || cd1.equals("")))
		{
			cd1 = cd1.toUpperCase();

 			if(andCheck == 1)
			{	
				sql.append(" and ");
				sql.append("upper(LONG_DESC) like '"+cd1+"%' ");
			}
			else
			{
				sql.append(" where upper(LONG_DESC) like '"+cd1+"%' ");
				andCheck = 1;
			}
		}
		if(!(status == null || status.equals("")))
		{
			if(andCheck == 1)
			{	
				sql.append(" and ");
				sql.append("eff_status in  decode('"+status+"','E','E','D','D',eff_status) ");
			}
			else
			{
				sql.append("where eff_status in  decode('"+status+"','E','E','D','D',eff_status) ");
				andCheck = 1;
			}
		}
	}
	//	appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if(!(ord == null || ord .equals("")))
	{
		sql.append(" order by ");

		for(int i=0; i < ord.length; i++)
	 	{
	 		if(i == ord.length - 1)
			{
				sql.append(ord[i]);
			}
			else
			{
				sql.append(ord[i]);
				sql.append(" , ");
			}
		}
		
	} //end of where clause IF
	else
	{
		sql.append(whereClause);
	}

	int start	= 0;
	int end		= 0;
	int i		= 1;

	if(from == null) start = 1 ;
	else start = Integer.parseInt( from ) ;

	if(to == null) end = 14 ;
	else end = Integer.parseInt( to ) ;

	java.sql.Statement stmt = null;
	ResultSet rset			= null;
	ResultSet rs			= null;

//	int maxRecord = 0;

	try
	{
		stmt = conn.createStatement();

		StringBuffer strsql1	= null;
		strsql1					= new StringBuffer();

		/*strsql1.append(" select count(*) as total from FM_NARRATION ");
		strsql1.append(sql);

		rs = stmt.executeQuery(strsql1.toString());
		if(rs.next())
		{
			maxRecord = rs.getInt(1);
		} if(rs != null) rs.close();
	   
		if(maxRecord== 0)
	    {*/%>
		  	<script>
				//alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));
			//	parent.frames[1]. location.href ="../../eFM/jsp/FMNarrationQueryCriteria.jsp" ;
			</script>
			<%//}
		
		//String strsql2="select * from FM_NARRATION "+sql;

		StringBuffer strsql2 = null;
		strsql2				 = new StringBuffer();

		strsql2.append("select * from FM_NARRATION ");
		strsql2.append(sql);

		rs = stmt.executeQuery(strsql2.toString());
%>
		
		<%
		
		if(start != 1)
			for( int j=1; j<start; i++,j++ )
			{
				rs.next() ;
			}
		
		String classValue = "" ;
		int cnt=0;

		while( i <= end && rs.next())
		{	
			if(cnt==0)
			{%>
				<p>
				<table align='right'>
				<tr>
				

				<%
				if(!(start <= 1))
					out.println("<td align ='right' id='prev'><A HREF='../../eFM/jsp/FMNarrationQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
				%>
				<td align ='right' id='next' style='visibility:hidden'>
				<%
				//if(!( (start+14) > maxRecord))
					out.println("<A HREF='../../eFM/jsp/FMNarrationQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
				%>

				</td>
				</tr>
				</table><br><br>
				</p>

				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th class='columnheader'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%			}
			
			if(i % 2 == 0) classValue = "QRYEVEN" ;
			else classValue = "QRYODD" ;

			String code = rs.getString("NARRATION_CODE");
			String eff  = rs.getString("eff_status");

			out.println("<tr><td class='" + classValue + "'>");
			out.println("<a href='../../eFM/jsp/FMNarrationAddMod.jsp?NarrationCode="+ code + "& target=f_query_add_mod&operation=modify' >");
			out.println(code+"</a></td><td  class='" + classValue + "'>");
			out.println( rs.getString("LONG_DESC") );
			out.println("</td><td class='" + classValue + "'>");
			out.println( rs.getString("SHORT_DESC") );
			out.println("</td><td align='center' class='" + classValue + "'>");	

			if(eff.equals("E"))
			{
				%><IMG SRC="../../eCommon/images/enabled.gif" BORDER=0 ALT=""></IMG><%
			}
			else 
			{
				%><IMG SRC="../../eCommon/images/RRnwd.gif" BORDER=0 ALT=""></IMG><%
			}
			out.println("</td></tr>");

			i++;
			cnt++;
		} 
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
			//endwhile
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
	
		if(rs!=null)	rs.close();
		if(rset!=null)	rset.close();
		if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{
		out.print(e.toString());
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

