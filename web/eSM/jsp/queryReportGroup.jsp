<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<%

	Connection conn=null;
	try{
		 request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
	Statement stmt =conn.createStatement();
	ResultSet rs=null;

%>

	<HTML><head>
		<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' class='CONTENT' >
<%
	String whereClause = request.getParameter("whereclause");
	String sql = " order by report_group_id " ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	if ( !(whereClause == null || whereClause.equals("")) )
	
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
rs = stmt.executeQuery("select a.*,b.printer_name  from sm_report_group a , sm_printer b where a.DFLT_PRINTER_ID=b.PRINTER_ID(+)  "+sql);
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
	<A HREF='../jsp/queryReportGroup.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql)%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
	<%}

if (endOfRes.equals("1"))
	{%>
	<A id='nextval' HREF='../jsp/queryReportGroup.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql)%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
	<%}%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="eSM.ReportGroupID.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th ><fmt:message key="eSM.DefaultPrinter.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%}

String dflt_printer_id="";

	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;

	dflt_printer_id = rs.getString("printer_name");
		if(dflt_printer_id == null) dflt_printer_id="&nbsp;";
	{%>
	<tr><td class='<%=classValue%>'>
	<%}
	String reportgroupid = rs.getString("report_group_id");


	%>
	<a href='../jsp/ReportGroupModify.jsp?reportgroup_id=<%=reportgroupid%>' target='f_query_add_mod' >
	<%=reportgroupid%></a></td><td class='<%=classValue%>'>
	<%=rs.getString("long_desc")%>
	</td><td class='<%=classValue%>'>
	<%=rs.getString("short_desc")%>
	</td><td  class='<%=classValue%>'>
	
	<%=dflt_printer_id%>
	</td><td align=center class='<%=classValue%>'>
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
}//endwhile
if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
if(!rs.next()&&cnt!=0){
   endOfRes="0";%>
   <script>
	   document.getElementById('nextval').innerHTML=" ";
   </script>
<% }  
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
%>

</td></tr>
</table>
<br><center>

</center>
</BODY>
</HTML>
<%
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(conn,request);
}	
%>

