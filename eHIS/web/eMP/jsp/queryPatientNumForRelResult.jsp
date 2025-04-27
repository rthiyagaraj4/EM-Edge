<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	%>
<%
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	//String pat_no_ctrl = "" ;




	if ( (whereClause == null || whereClause.equals("")) )
	{

	String cd = request.getParameter("pat_ser_grp_code");
	cd = cd.toUpperCase();
	String longdesc = request.getParameter("long_desc");
	longdesc = longdesc.toUpperCase();

	int andCheck = 0;
	if ( !(cd == null || cd.equals("")) )
		{
		sql.append("where pat_ser_grp_code like '");
		sql.append(cd);
		sql.append("%'");
		andCheck = 1;
		}


	if ( !(longdesc == null || longdesc.equals("")) )
		{
			if ( andCheck == 1 )
			{	sql.append(" and ");
				sql.append("upper(long_desc) like  '");
				sql.append(longdesc+"%'");
			}
			else
			{
				sql.append("where upper(long_desc) like '");
				sql.append(longdesc);
				sql.append("%'");
				andCheck = 1;
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
			{
			sql.append(ord[i]);
			sql.append(",");
			}
		}
	}
	} //end of where clause IF
	else
	{
		sql.setLength(0);
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

Connection conn=null;
try
{
conn = ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;

try{
	pstmt = conn.prepareStatement("select pat_ser_grp_code,pat_ser_grp_desc, prefix_or_suffix_length, relationship_level, combined_rel_level_code, sex_ind, prefix1, prefix2, prefix3 from mp_rel_for_pat_ser_grp_vw  "+sql.toString());
	rs = pstmt.executeQuery();

%>



<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
    String classValue = "" ;
	int cnt = 0;
	while ( i<=end && rs.next())
	{
	if (cnt==0)
	{%>
		<P>
	<table align='right'>
	<tr>

	<%
	if ( !(start <= 1) )
		out.println("<td align ='right' id='prev'><A HREF='../jsp/queryPatientNumForRelResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>"); %>
	<td align ='right' id='next' style='visibility:hidden'>
	<% //if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF='../jsp/queryPatientNumForRelResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	%>
	</td>
	</tr>
	</table>
		<BR><BR>
	</p>

	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<!-- 	<th><fmt:message key="eMP.PrefixSuffix.label" bundle="${mp_labels}"/></th>
 -->	<th><fmt:message key="Common.length.label" bundle="${common_labels}"/></th>
	<th><fmt:message key="eMP.RelationshipLevel.label" bundle="${mp_labels}"/></th>
	<th><fmt:message key="eMP.Relationship.label" bundle="${mp_labels}"/></th>
	<th><fmt:message key="eMP.SexInd.label" bundle="${mp_labels}"/></th>
	<th><fmt:message key="eMP.Prefix1.label" bundle="${mp_labels}"/></th>
	<th><fmt:message key="eMP.Prefix2.label" bundle="${mp_labels}"/></th>
	<th><fmt:message key="eMP.Prefix3.label" bundle="${mp_labels}"/></th>
<!-- 	<th><fmt:message key="eMP.Prefix4.label" bundle="${mp_labels}"/></th>
 --><%	}
	if ( i % 2 == 0 )
	classValue = "QRYEVEN" ;
	else
	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("pat_ser_grp_code");
	out.println("<a href='../jsp/addPatNumberingForRel.jsp?pat_ser_grp_code="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("pat_ser_grp_desc") );
	//out.println("</td><td align='center' class='" + classValue + "'>");
	//out.println(checkForNull(rs.getString("prefix_or_suffix_ind"),"&nbsp") );
	out.println("</td><td align='center' class='" + classValue + "'>");
	out.println(checkForNull(rs.getString("prefix_or_suffix_length"),"&nbsp") );
    out.println("</td><td align='center' class='" + classValue + "'>");
	out.println(checkForNull(rs.getString("relationship_level"),"&nbsp") );
    out.println("</td><td align='center' class='" + classValue + "'>");
	out.println(checkForNull(rs.getString("combined_rel_level_code"),"&nbsp") );
    out.println("</td><td align='center' class='" + classValue + "'>");
	out.println(checkForNull(rs.getString("sex_ind"),"&nbsp") );
    out.println("</td><td align='center' class='" + classValue + "'>");
	out.println(checkForNull(rs.getString("prefix1"),"&nbsp") );
    out.println("</td><td align='center' class='" + classValue + "'>");
	out.println(checkForNull(rs.getString("prefix2"),"&nbsp") );
    out.println("</td><td align='center' class='" + classValue + "'>");
	out.println(checkForNull(rs.getString("prefix3"),"&nbsp") );
	//out.println("</td><td align='center' class='" + classValue + "'>");
	//out.println(checkForNull(rs.getString("prefix4"),"&nbsp") );
	out.println("</td>");


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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%}%>
</td></tr>
</table>
<br><center>
<%

}catch(Exception e) { out.println(e.toString());}
finally	
{
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
}

}catch(Exception e) { out.println(e.toString());}
finally { 
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

