<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd = request.getParameter("postal_code");
	cd = cd.toUpperCase();
	String longdesc = request.getParameter("a.LONG_DESC");
	longdesc = longdesc.toUpperCase();
	String RES_TOWN_CODE = request.getParameter("a.RES_TOWN_CODE");
	RES_TOWN_CODE = RES_TOWN_CODE.toUpperCase();
	String town_shortdesc = request.getParameter("b.LONG_DESC");
	town_shortdesc = town_shortdesc.toUpperCase();

	String enabled = request.getParameter("nature");


	if ( !(cd == null || cd.equals("")) )
		{
		sbQuery.append(" and upper(postal_code) like '");
		sbQuery.append(cd);
		sbQuery.append("%'");
		}
	
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		sbQuery.append(" and upper(a.LONG_DESC) like  '");
		sbQuery.append(longdesc);
		sbQuery.append("%'");
	}
	
	if ( !(RES_TOWN_CODE == null || RES_TOWN_CODE.equals("")) )
	{
		sbQuery.append(" and upper(a.RES_TOWN_CODE) like  '");
		sbQuery.append(RES_TOWN_CODE);
		sbQuery.append("%'" );
	}
	
	if ( !(town_shortdesc == null || town_shortdesc.equals("")) )
		{
			sbQuery.append(" and a.res_town_code in (select res_town_code from mp_res_town where upper(long_desc) like '");
			sbQuery.append(town_shortdesc);
			sbQuery.append("%')");
		}

	if ( !(enabled == null || enabled.equals("")) )
	{
		 if( enabled.equals("E") ){
			 sbQuery.append(" and a.eff_status='E'");
		 }
	     if ( enabled.equals("D") ){
			 sbQuery.append(" and a.eff_status='D'");
		 }
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");


	if ( !(ord == null || ord .equals("")) )
	{
			sbQuery.append(" order by ");
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append("Upper("+ord[i]+")");
				}else{
					sbQuery.append("Upper("+ord[i]+")");
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
//	int maxRecord = 0;
try{
	conn = ConnectionManager.getConnection(request);

	/*pstmt = conn.prepareStatement("select count(*) as total from MP_POSTAL_CODE a, MP_RES_TOWN b where a.RES_TOWN_CODE = b.RES_TOWN_CODE(+) "+sbQuery.toString());

	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();

if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

	pstmt = conn.prepareStatement("SELECT a.postal_code postal_postal_code, a.long_desc postal_long_desc, a.short_desc postal_short_desc, a.res_town_code postal_res_town_code, b.long_desc town_short_desc, a.eff_status postal_eff_status FROM mp_postal_code a, mp_res_town b WHERE a.res_town_code = b.res_town_code(+) "+sbQuery.toString());
	
	rs = pstmt.executeQuery();
%>



<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
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
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/queryPostal.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		%>
			<td align ='right' id='next' style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/queryPostal.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
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
		<th><fmt:message key="Common.Town.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Town.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'>");

	String code = rs.getString("postal_postal_code");
	
	out.println("<a href='../../eMP/jsp/PostalModify.jsp?postal_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("postal_long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("postal_short_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("postal_res_town_code") == null ? "&nbsp;" : rs.getString("postal_res_town_code"));
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("town_short_desc") == null ? "&nbsp;" : rs.getString("town_short_desc") );
	out.println("</td><td class='" + classValue +
		"'  align='center'>");
	if ( rs.getString("postal_eff_status").equals("E") )
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

	<%}
%>

</td></tr>
</table>
<br><center>
<%
}catch(Exception e) { 
	//out.println(e.toString());
	e.printStackTrace();
}
finally{
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
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

