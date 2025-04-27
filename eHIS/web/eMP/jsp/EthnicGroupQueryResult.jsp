<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* "  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
    out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	String sql ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	/*Added by lakshmanan for security issue ID 174156232 on 05-09-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174156232 on 05-09-2023 end */

	if ( (whereClause == null || whereClause.equals("")) )
	{
	sql = "";
	String cd = request.getParameter("RACE_CODE");
	cd = cd.toUpperCase();
	String longdesc = request.getParameter("LONG_DESC");
	longdesc = longdesc.toUpperCase();
	String enabled = request.getParameter("nature");

	int andCheck = 0;


	if ( !(cd == null || cd.equals("")) )
		{
		sql = "where RACE_CODE like ? ";
		psthashmap.put(++psthmcount,cd+"%");
		andCheck = 1;
		}
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	sql = sql + " and ";
			sql = sql + "upper(LONG_DESC) like  ? " ;
			psthashmap.put(++psthmcount,longdesc+"%");
		}
		else
		{
			sql = "where upper(LONG_DESC) like ? " ;
			psthashmap.put(++psthmcount,longdesc+"%");
			andCheck = 1;
		}
	}
	if ( !(enabled == null || enabled.equals("")) )
	{
	   if ( enabled.equals("D") )
	   {
	        if ( andCheck == 0 )
	           sql = " where  EFF_STATUS='D'";
	        else
	           sql = sql + " and EFF_STATUS='D'";
	   }
	   if ( enabled.equals("E") )
	   {
		if ( andCheck == 0 )
		   sql = "where EFF_STATUS='E'";
		else
	  	   sql = sql + " and EFF_STATUS='E'";
	   }
	   if ( enabled.equals("B") )
	   {
		//out.println(sql );

		//sql = sql; //nothing is added to get both E and D
	   }
	}

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
	} //end of where clause IF
	else
		sql = whereClause;

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
//int maxRecord = 0;
try{
	 conn = ConnectionManager.getConnection(request);
	 /*
try{

	pstmt = conn.prepareStatement("select count(*) as total from MP_RACE "+sql);
	rs = pstmt.executeQuery();
	rs.next();
//	maxRecord = rs.getInt("total");
}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}

if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
*/
try{
	pstmt =conn.prepareStatement("select * from MP_RACE "+sql); 
	int pstcount=1;
	while ( pstcount<=psthashmap.size()) {
	pstmt.setString(pstcount,(String) psthashmap.get(pstcount));
	pstcount++;
	}
	psthashmap.clear();
	psthmcount=0;
	rs = pstmt.executeQuery();

 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	
	String classValue = "" ;

	/* Counter variable to check the number of records displayed */
	int cnt = 0;
	
	while ( i<=end && rs.next() )
	{
	/* Painting the Header Part */
	if (cnt==0)
	{%>
		<P>
		<table align='right'>
		<tr>
		
		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/EthnicGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		%>
		<td align ='right' id='next' style='visibility:hidden'>
		<%
			out.println("<A HREF='../../eMP/jsp/EthnicGroupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
		<br><br>
		</P>
	<center>
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

	out.println("<tr><td align='left' class='" + classValue + "'>");
	String code = rs.getString("RACE_CODE");

	out.println("<a href='../../eMP/jsp/EthnicGroupModify.jsp?RACE_CODE="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("LONG_DESC") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("SHORT_DESC") );
	out.println("</td><td class='" + classValue +
		"' align='center'>");

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
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% flag = true;
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}%>
</td></tr>
<% //if (flag)	out.println("<tr><td colspan='4'  class='labelcenter'>End Of Results</td></tr>");
	%>
</table>
</center>

<br><center>
	<%

}catch(Exception e) { 
	// out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174203015 on 05-09-2023
	}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}
}catch(Exception e) { 
	// out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174203016 on 05-09-2023
	}
finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>
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
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

