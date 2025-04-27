<!DOCTYPE html>
<%--
/**
  *
  * @filename queryReligion.jsp
  * @version 3.0 updated on 2/17/2005
  */
--%>

<%@ page import ="webbeans.eCommon.ConnectionManager, java.sql.Connection, eCommon.XSSRequestWrapper,java.sql.PreparedStatement, java.sql.ResultSet, java.net.URLEncoder" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	%>
<HTML>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	</head>
	<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	
	StringBuffer sbQuery  = new StringBuffer();
//	String sql ;											// Will be deleted once testing is done
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	/*Added by lakshmanan for security issue ID 174125924 on 04-09-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174125924 on 04-09-2023 end */

	if ( (whereClause == null || whereClause.equals("")) ){
//	sql = "";
		String cd = request.getParameter("relgn_code");
		if(cd != null)
			cd=cd.toUpperCase();
		String longdesc = request.getParameter("long_desc");
		if(longdesc != null)
			longdesc = longdesc.toUpperCase();
		String enabled = request.getParameter("enabled"); 		

		int andCheck = 0;

		if ( !(cd == null || cd.equals("")) ){
			sbQuery.append("where upper(relgn_code) like ? ");
			psthashmap.put(++psthmcount,cd+"%");
			//sbQuery.append(cd);
			//sbQuery.append("%'");
//			sql = "where mar_status_code like '"+cd+"%'";
			andCheck = 1;
		}
		if ( !(longdesc == null || longdesc.equals("")) ){
			if ( andCheck == 1 ){	
				sbQuery.append(" and ");
				sbQuery.append("upper(long_desc) like ? ");
				psthashmap.put(++psthmcount,longdesc+"%");
				//sbQuery.append(longdesc);
				//sbQuery.append("%'");
//				sql = sql + " and ";
//				sql = sql + "long_desc like  '"+longdesc+"%'" ;
			}else{
				sbQuery.setLength(0);
				sbQuery.append("where upper(long_desc) like ? ");
				psthashmap.put(++psthmcount,longdesc+"%");
				//sbQuery.append(longdesc);
				//sbQuery.append("%'");
//				sql = "where long_desc like '"+longdesc+"%'" ;
				andCheck = 1;
			}
		}
		if ( !(enabled == null || enabled.equals("") || enabled.equals("B")) ){
	/*	   if ( enabled.equals("E") )
			{
			if ( andCheck == 0 )
			sql = "where eff_status='E'";
			else
			sql = sql + " and eff_status='E'";
			}
			if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
			sql = " where  eff_status='D'";
			else
			sql = sql + " and eff_status='D'";
			}
	*/		
			//Added by Sabarinathan S on 2/17/2005
			String strEffStatus="";
			if(enabled.equals("E"))
				strEffStatus="E";
			else if(enabled.equals("D"))
				strEffStatus="D";
			
			if(andCheck == 0 ){
				sbQuery.setLength(0);
				sbQuery.append("where eff_status=? ");
				psthashmap.put(++psthmcount,strEffStatus);
			}else{
				sbQuery.append(" and eff_status=? ");
				psthashmap.put(++psthmcount,strEffStatus);
				
			}
		   if ( enabled.equals("B") )	{
			//out.println(sql );
			// sql = sql; nothing is added to get both E and D
				
			}
		}

		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) ){
			sbQuery.append(" order by ");
	//		sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
	//					sql=sql+ord[i];
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
	//					sql=sql+ord[i]+",";
				}
			}
		}
	}else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
//		sql = whereClause;
	}//end of where clause IF

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

//Connection conn = (Connection) session.getValue( "connection" ) ;
	Connection conn = null;
	PreparedStatement pstmt=null;

	ResultSet rs=null;
//	int maxRecord = 0;
	try{
		conn = ConnectionManager.getConnection(request);
	/*	pstmt = conn.prepareStatement("select count(*) as total from mp_religion "+sbQuery.toString());
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
	
		if (maxRecord==0) 			
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/
		//pstmt = conn.prepareStatement("select * from mp_religion order by RELGN_CODE "+sbQuery.toString());
		pstmt = conn.prepareStatement("select * from mp_religion "+sbQuery.toString());
		int pstcount=1;
		while ( pstcount<=psthashmap.size()) {
		pstmt.setString(pstcount,(String) psthashmap.get(pstcount));
		pstcount++;
		}
		psthashmap.clear();
		psthmcount=0;
		rs = pstmt.executeQuery();
%>



<%
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;
		String classValue ="";
		int cnt=0;
		while (i<=end && rs.next() ){


			
			if(cnt==0)
			{%>
			<P>
			<table align='right'>
			<tr>

			<%
					if ( !(start <= 1) )
						out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryReligion.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			%>
					<td align ='right' id='next' style='visibility:hidden'>
			<%
					//if ( !( (start+14) > maxRecord ) )
						out.println("<A HREF='../../eMP/jsp/queryReligion.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
			</tr>
			</table>
				<BR><BR>
			</P>
			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<!--th >Effective From</th>
			<th >Effective To</th-->
			<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			<%}
			if ( i%2 == 0 )
				classValue="QRYEVEN";
			else
				classValue="QRYODD";
			out.println("<tr>");
			out.println("<td class='"+classValue+"'>");
			String code = rs.getString("relgn_code");
			// if ( rs.getString("eff_status").equals("E") )
			out.println("<a href='../../eMP/jsp/ReligionModify.jsp?religion_code="+ code + "' target='f_query_add_mod' >");
			out.println(code+"</a></td><td class='"+classValue+"'>");
			out.println( rs.getString("long_desc") );
			out.println("</td><td class='"+classValue+"'>");
			out.println(rs.getString("short_desc") );
			out.println("</td><td class='"+classValue+"' align='center'>");
			/*if ( rs.getDate("eff_date_from") != null )
			{
			 java.util.Date date = rs.getDate("eff_date_from");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 String dateString = formatter.format(date);
			 out.println(dateString);
			 dateString = null;
			 formatter = null;
			}
			else
			{
				out.println("&nbsp;");
			}
			out.println("</td><td class='"+classValue+"'>");

			if ( rs.getDate("eff_date_to") != null )
			{
			 java.util.Date date1 = rs.getDate("eff_date_to");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 String dateString = formatter.format(date1);
			 out.println(dateString);
			}
			else
			{
				out.println("&nbsp;");
			}
			out.println("</td><td align='center' class='"+classValue+"'>");
		*/
		if ( rs.getString("eff_status").equals("E") )
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%}%>

</td></tr>
</table>
<br><center>
<!--%
if ( !(start <= 1) )
	out.println("<A HREF='/eCIS/mp/jsp/queryReligion.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='/eCIS/common/images/previous.gif' alt='Previous' border='0'></A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='/eCIS/mp/jsp/queryReligion.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'><img src='/eCIS/common/images/next.gif' alt='Next' border='0'></A>");
//rs.close();
%-->
<%
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}catch(Exception e) { 
	// out.println(e.toString());
	e.printStackTrace();
}finally{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
</center>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

