<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<HTML>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int start = 0 ;
	int end = 0 ;
	int i=1;
       if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt(from);

	if ( to == null )
	  	end = 14 ;
	else
		end =Integer.parseInt(to);
		int maxRecord = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

	try {
		conn = ConnectionManager.getConnection(request);
		pstmt = conn.prepareStatement("select count(*) as total from mp_param_for_facility");
		rs = pstmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
	}
	if (maxRecord==0) 	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
try{
		pstmt = conn.prepareStatement("select a.*,b.facility_name from mp_param_for_facility a,sm_facility_param b where a.facility_id=b.facility_id order by a.facility_id");
		rs = pstmt.executeQuery();
%>

<P>
<table align='right'>
<tr>
<td>
<%

if ( !(start <= 1) )
	out.println("<A HREF='../jsp/queryFacilityLevel.jsp?from="+(start-14)+"&to="+(end-14)+"&text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../jsp/queryFacilityLevel.jsp?from="+(start+14)+"&to="+(end+14)+"&text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");


%>
</td>
</tr>
</table>
	<BR><BR>
</P>


<center>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.FacilityID.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.FacilityName.label" bundle="${common_labels}"/></th>
<%
	if ( start != 1 )
	 	for( int j=1; j<start; i++,j++ )
	 	rs.next() ;
	    String classValue = "" ;
		while ( rs.next() && i<=end )
		{
			if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
			else
			classValue = "QRYODD" ;

			out.println("<tr><td align='center' width='20%%' class='" + classValue + "'>");
			String ID = rs.getString("facility_id");
			out.println("<a href='../jsp/FacilityLevelModify.jsp?facility_id="+ ID + "' target='f_query_add_mod' >");
			out.println(ID+"</a></td><td width='60%%' class='" + classValue + "'>");
			out.println( rs.getString("facility_name") );
			out.println("</td></tr>");
			i++;
		}
%>
</table><br>
<%
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();
	}catch(Exception e) { out.println(e.toString());}
	finally
	{
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

