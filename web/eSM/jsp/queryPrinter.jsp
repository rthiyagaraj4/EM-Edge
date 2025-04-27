<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>



<HTML><head> 
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY class='CONTENT'  onKeyDown = 'lockKey()'; OnMouseDown='CodeArrest()'>
<%
	
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql =new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd = request.getParameter("Printer_ID");
	String ccd = request.getParameter("Printer_Type");
	String printername = request.getParameter("Printer_Name");
	String enabled = request.getParameter("eff_status");
	String 	reportservice = request.getParameter("report_service");


	if ( !(cd == null || cd.equals("")) )
	{
		sql.append(" and upper(printer_id) like upper('"+cd+"%')");
	}

	if ( !(printername == null || printername.equals("")) )
	{
			sql.append(" and upper(printer_name)  like  upper('"+printername+"%') " );
	}
	
	if ( !(reportservice == null || reportservice.equals("")) )
	{
			sql.append(" and upper(a.report_service_id) like  upper('"+reportservice+"%')");
	}

	if ( !(ccd == null || ccd.equals("")) )
	{
	     if( ccd.equals("S") )
	     {
	   	   sql.append(" and printer_type='S'");
	     }
	     if ( ccd.equals("D") )
	     {
	     	           sql.append(" and printer_type='D'");
	     }
	     if ( ccd.equals("I") )
	     {
	     	           sql.append(" and printer_type='I'");
	     }
	     if ( ccd.equals("L") )
	     {
	     	           sql.append(" and printer_type='L'");
	     }
	     if ( ccd.equals("B") )
	     {
	     	           sql.append(" and printer_type='B'");
	     }
	}

	if ( !(enabled == null || enabled.equals("")) )
	{
	     if( enabled.equals("E") )
	     {
			   sql.append(" and a.eff_status='E' ");
	     }
	     if ( enabled.equals("D") )
	     {
			   sql.append(" and a.eff_status='D' ");
	     }
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
			sql.append(ord[i]+",");
		}
	}
	else
	{	
		if(sql.length() > 0) sql.delete(0,sql.length());
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
			try{
			conn = ConnectionManager.getConnection(request);

Statement stmt =conn.createStatement();
ResultSet rs = null;
int cnt = 0;
String endOfRes="1";
try
{

String exesql = "select printer_id,printer_name,queue_name,printer_type,report_service_name,a.eff_status from sm_printer a,sm_report_service b where a.report_service_id=b.report_service_id "+sql.toString();
rs = stmt.executeQuery(exesql); 
	 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
	  String classValue = "" ;
	  
while ( i<=end && rs.next()){
	if(cnt==0){

%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	{%>
	<A HREF='../jsp/queryPrinter.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'>Previous</A>
<%}
if (endOfRes.equals("1"))
	{%>
	<A id='nextval' HREF='../jsp/queryPrinter.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'>Next</A>
<%}%>
</td>
</tr>
</table>
<br><br>
</p>


<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="eSM.PrinterID.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="eSM.PrinterName.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="eSM.QueueName.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="eSM.PrinterType.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="eSM.ReportService.label" bundle="${sm_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%}

	if ( i % 2 == 0 )
	  	classValue = "QRYEVEN" ;
	  else
	  	classValue = "QRYODD" ;
%>
	<tr><td align=='left' class='<%=classValue%>'>
<%
	String ID = rs.getString("printer_id");
%>
	<a href='../jsp/printerModify.jsp?printer_id=<%=ID%>' target='f_query_add_mod' >
    <%=ID%></a></td><td class='<%=classValue%>'>
	<%=rs.getString("printer_name")%>
	</td><td class='<%=classValue%>'>
	<%=rs.getString("queue_name")%>
	</td><td class='<%=classValue%>'>
<%
	String printer_type = rs.getString("printer_type");
	String report_service=rs.getString("report_service_name");
	if(report_service == null || report_service.equals("null"))
		report_service="&nbsp;";
	if(printer_type.equals("S"))
	{%>
		<fmt:message key="eSM.Laser.label" bundle="${sm_labels}"/></td><td class='<%=classValue%>'>
	<%}
	else if(printer_type.equals("D"))   
	{%>
		<fmt:message key="eSM.DMP.label" bundle="${sm_labels}"/></td><td class='<%=classValue%>'> 
	<%}
	else if(printer_type.equals("I")) 
	{%>
		<fmt:message key="eSM.Inkjet.label" bundle="${sm_labels}"/></td><td class='<%=classValue%>'>
	<%}
	else if(printer_type.equals("L")) 
	{%>
		<fmt:message key="Common.Line.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/></td><td class='<%=classValue%>'>
	<%}
	else 
	{%>
		<fmt:message key="eSM.LabelPrinter.label" bundle="${sm_labels}"/></td><td class='<%=classValue%>'>
	<%}%>
	<%=report_service%>
	</td><td align=center class='<%=classValue%>'>
	<%
	
	if ( rs.getString("eff_status").equals("E") )
	{%>
		<img src='../../eCommon/images/enabled.gif'></img>
	<%}else{%>
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
<% }%>

</td></tr>
</table>
</center>

<br><center>
<%
	
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	sql.setLength(0);
}catch(Exception ce){out.println("Exception "+ce+sql.toString());}
%>

</center>
</BODY>
</HTML>
<%
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(conn,request);
}	
%>

