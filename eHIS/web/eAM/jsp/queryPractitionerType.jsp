<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%--
	FileName	: PractitionerType.jsp
	Version	    : 3	
	Modified On	: 17-2-2005
--%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" %>

<HTML>
	<head>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<%
request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//MMS-ME-SCF-0096 vulnerability Issue	
String from = request.getParameter( "from" );
String to = request.getParameter( "to" );
%>
<script src="../../eAM/js/PractitionerType.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
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
	
	//Statement stmt;
	Statement stmt = null;
	ResultSet rs = null;
	int maxRecord = 0;


try {	
	conn = ConnectionManager.getConnection(request);

	StringBuffer sql =new StringBuffer("");
	String classValue = "" ;
	stmt = conn.createStatement();
	
	rs = stmt.executeQuery("select * from am_pract_type order by seq_no");
	if ( start != 1 )
	for( int j=1; j<start; i++,j++ )
	  rs.next() ;	

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
			out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryPractitionerType.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

		//if ( !( (start+14) > maxRecord ) )
			out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryPractitionerType.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");

		%>
		
		</tr>
		</table>
		</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th class='columnheader'><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.SystemDescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.UserDescription.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>  
	<% }
        if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;


 	out.println("<tr><td align='left' class='" + classValue + "'>");
	String code = rs.getString("pract_type");
	out.println("<a href='../../eAM/jsp/PractitionerTypeModify.jsp?pract_type="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("desc_sysdef") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("desc_userdef") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("seq_no") );
	out.println("</td>");
	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
}// end of while 

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
%>

</td></tr>
</table>

<%

}// end of try
catch(Exception e) 
{
	e.printStackTrace();
}
finally 
{
try
{
  if (stmt != null)	 stmt.close();
  if (rs != null)	 rs.close();
}
catch(Exception e)
{
	e.printStackTrace();
}
  	ConnectionManager.returnConnection(conn,request);
}

%>


</BODY>
</HTML>

