<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script src='../../eCommon/js/common.js' language='javascript'></script>
    	
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<%
	Connection conn=null;
	try{
		request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
	Statement stmt=conn.createStatement();
	ResultSet rs=null;
%>

	<HTML><head><%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'; class='CONTENT'>
		<% request.setCharacterEncoding("UTF-8");%>
<%
	String whereClause = request.getParameter("whereclause");
	String sql =" order by Report_Service_Id ";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if (! (whereClause == null || whereClause.equals("")) )
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
	int cnt = 0;
	String endOfRes="1";

try {

	if(rs!=null)rs.close();

	rs = stmt.executeQuery("select * from Sm_Report_Service "+sql);
	 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  String classValue = "" ;
	  
while (i<=end && rs.next()){
	if(cnt==0){
%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	{%>
	<A HREF='../jsp/queryReportService.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql)%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%}
if ( endOfRes.equals("1"))
	{%>
	<A id='nextval' HREF='../jsp/queryReportService.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql)%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>

<%}%>
</td>
</tr>
</table>
<br><br>
</p>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="eSM.ReportServiceID.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="eSM.ReportServiceName.label" bundle="${sm_labels}"/></th>

<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%}

	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
		  
%>
	<tr><td align='left' class='<%=classValue%>'>
<%
	String id = rs.getString("Report_Service_Id");
%>
	<a href='../jsp/ReportServiceModify.jsp?Report_Service_Id=<%=id%>' target='f_query_add_mod' >
	<%=id%></a></td><td class='<%=classValue%>'>
	<%=rs.getString("Report_Service_Name")%>
	</td><td align='center' class='<%=classValue%>'>
<%
	if ( rs.getString("eff_status").equals("E") )
	{%>
		<img src='../../eCommon/images/enabled.gif'></img>
	<%}
	else{
	%>
		<img src='../../eCommon/images/disabled.gif'></img>
	<%}

	i++;
	cnt++;
	} 
	if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	if(!rs.next()&&cnt!=0){
		endOfRes="0";
		%>
		<script>
			document.getElementById('nextval').innerHTML=" ";
		</script>
	<%} %>
</td></tr>
</table>
<br><center>

<%
if(rs !=null) rs.close(); 
if(stmt != null) stmt.close();
	
} 
catch(Exception e){//out.println("Exception "+e+sql);
	e.printStackTrace();
}
%>

</center>
</BODY>
</HTML>
<%
}catch(Exception e){//out.println(e);
	e.printStackTrace();
}
finally { 
	ConnectionManager.returnConnection(conn,request);
}	
%>

