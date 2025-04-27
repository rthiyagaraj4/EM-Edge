<!DOCTYPE html>
<%--
/** 
  * @filename queryMaritalStatus.jsp
  * Last Modified Date Time : 12/13/2005 12:06 PM
  */
--%>

<%@ page import="webbeans.eCommon.ConnectionManager, java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.net.URLEncoder" contentType="text/html;charset=UTF-8"   %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>

<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	</head>
	<body class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause	= request.getParameter("whereclause");
	String from			= request.getParameter("from");
	String to			= request.getParameter("to");

	StringBuffer sbQuery = new StringBuffer();
	/*Added by lakshmanan for security issue ID 174131244 on 04-09-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174131244 on 04-09-2023 end */
	
	if((whereClause == null || whereClause.equals(""))) {
		
		String cd = request.getParameter("mar_status_code");
		cd = cd.toUpperCase();

		String longdesc = request.getParameter("long_desc");
		longdesc = longdesc.toUpperCase();
		
		String enabled = request.getParameter("nature");

		int andCheck = 0;
		if(!(cd == null || cd.equals(""))) {

			sbQuery.append(" where upper(mar_status_code) like ? ");
			psthashmap.put(++psthmcount,cd+"%");
			//sbQuery.append(cd);
			//sbQuery.append("%'");
			andCheck = 1;
		}
		if(!(longdesc == null || longdesc.equals(""))) {
			if(andCheck == 1) {
				sbQuery.append(" and ");
				sbQuery.append(" upper(long_desc) like ? ");
				psthashmap.put(++psthmcount,longdesc+"%");
				//sbQuery.append(longdesc);
				//sbQuery.append("%'");
			} else {
				sbQuery.setLength(0);
				sbQuery.append(" where upper(long_desc) like ? ");
				psthashmap.put(++psthmcount,longdesc+"%");
				//sbQuery.append(longdesc);
				//sbQuery.append("%'" );
				andCheck = 1;
			}
		}
		if(!(enabled == null || enabled.equals(""))) {
			String strEffStatus="";
			if(enabled.equals("E"))
				strEffStatus="E";
			else if(enabled.equals("D"))
				strEffStatus="D";
			
			if(andCheck == 0 && !enabled.equals("B")){
				sbQuery.setLength(0);
				sbQuery.append("where eff_status=? ");
				psthashmap.put(++psthmcount,strEffStatus);
				andCheck = 1;
			}else if(!enabled.equals("B")){
				sbQuery.append(" and eff_status=? ");
				psthashmap.put(++psthmcount,strEffStatus);
			}
		    if ( enabled.equals("B") ){
				if(andCheck == 0){
					sbQuery.setLength(0);
					sbQuery.append("where (eff_status='E' or eff_status='D')");
				}else
					sbQuery.append(" and (eff_status='E' or eff_status='D')");
			}
		}
		String ord[] = request.getParameterValues("orderbycolumns");
		if ( !(ord == null || ord.equals("")) ){
			sbQuery.append(" order by ");
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
				}
			}
		}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
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
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	/*int maxRecord = 0;
	try{
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement("select count(*) as total from mp_marital_status "+sbQuery.toString());
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
	}catch(Exception e) { 
		out.println(e.toString());
		e.printStackTrace();
	}
	if (maxRecord==0) 									
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/
	try{
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement("select mar_status_code,long_desc,short_desc,eff_Status from mp_marital_status "+sbQuery.toString());
		int pstcount=1;
		while ( pstcount<=psthashmap.size()) {
		pstmt.setString(pstcount,(String) psthashmap.get(pstcount));
		pstcount++;
		}
		rs = pstmt.executeQuery();
		psthashmap.clear();
		psthmcount=0;
%>


<%
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		String classValue = "" ;
		String code="";
		int cnt=0;
		while (i<=end && rs.next()){
			if(cnt==0)
			{%>	
				<P>
				<table align='right'>
				<tr>

				<%
						if ( !(start <= 1) )
							out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryMaritalStatus.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
				%>
						<td align ='right' id='next' style='visibility:hidden'>
				<%
					//	if ( !( (start+14) > maxRecord ) )
							out.println("<A HREF='../../eMP/jsp/queryMaritalStatus.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>	
			<%}
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			out.println("<tr><td class='" + classValue + "'>");
			code = rs.getString("mar_status_code");
			out.println("<a href='../../eMP/jsp/maritalStatusModify.jsp?marital_status_code="+ code + "' target='f_query_add_mod' >");
			out.println(code+"</a></td><td class='" + classValue + "'>");
			out.println( rs.getString("long_desc") );
			out.println("</td><td class='" + classValue + "'>");
			out.println(rs.getString("short_desc") );
			out.println("</td>");
			out.println("<td align='center' class='" + classValue + "'>");

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
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%}
		
		%>

</td></tr>
</table>
<br><center>
<%
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
		sbQuery.setLength(0);
	}catch(Exception e) { 
		// out.println(e.toString());
		e.printStackTrace();
	}finally{
		if(conn!=null) ConnectionManager.returnConnection(conn,request);
	}
%>
<script>  </script>
</center>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

