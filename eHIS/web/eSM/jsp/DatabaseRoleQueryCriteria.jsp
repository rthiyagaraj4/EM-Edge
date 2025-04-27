<!DOCTYPE html>
<%@ page import="java.sql.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%	

Connection con=null ;

try {
    request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	
	PreparedStatement pstmt  = null;		
	PreparedStatement pstmt1 = null;		
	ResultSet rs = null;
	ResultSet rs1 = null;
	int maxRecord = 0;
	
	int start = 0 ;
	int end   = 0 ;
	int i=1;
	
	
%>
	<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../eSM/js/facility_param.js"></script>

<center>
<%	String classValue = "" ;
	String sql ="";
	sql = "SELECT ora_role_type,ora_role_id,app_password.decrypt(ora_role_password), ora_privilege from sm_ora_role" ;				
	pstmt = con.prepareStatement(sql);
	
	String count="select count(*) as total from sm_ora_role";		
	pstmt1 = con.prepareStatement( count );
	rs1= pstmt1.executeQuery() ;	
	rs1.next();
	maxRecord = rs1.getInt(1);
	if(rs1!=null)rs1.close();
	if(pstmt1!=null)pstmt1.close();
	
	rs = pstmt.executeQuery( sql ) ;
	
%>
	<p>
		<table align='right'>
		<tr>
		<td>
<%	
		if ( !(start <= 1) )
			out.println("<A HREF='../eSM/jsp/AddDatabaseRole.jsp?from="+(start-14)+"&to="+(end-14)+"&operation=query&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				
		if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../eSM/jsp/AddDatabaseRole.jsp?from="+(start+14)+"&to="+(end+14)+"&operation=query&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
		</td>
		</tr>
	</table>	
	</p>

	
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<%
	out.println( "<table border='1' width='100%' cellspacing='0' cellpadding='0'>" ) ;
	out.println( "<tr bgcolor=black>" ) ;
	out.println( "<th>" ) ;
	out.println( "Role Type" ) ;
	out.println( "</th>" ) ;
	out.println( "<th>" ) ;
	out.println( "Role ID" ) ;
	out.println( "</th>" ) ;
	out.println( "<th>" ) ;
	out.println( "Enabled" ) ;
	out.println( "</th>" ) ;
	out.println(start);
	
	if ( start != 1 )
	{
	start = -1;
		for( int j=1; j<start; i++,j++ )
		{
		out.println("in");
			rs.next() ;
	  		while( rs.next() && i<=end )
	  		{					
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				out.println( "<tr>" ) ;
			
				String ora_type  = "" + rs.getObject("ora_role_type") ;
				String ora_id 	 = "" + rs.getObject("ora_role_id") ;
				String ora_priv	 = "" + rs.getObject("ora_privilege") ;
				out.println(ora_type+" "+ora_id+" "+ora_priv);
				
				out.println( "<td width='33%' class='" + classValue + "'>+ora_type+</td>" ) ;	
				out.println( "<td width='33%' class='" + classValue + "'>" + ora_id  + "</td>" ) ;	
				out.println( "<td width='33%' class='" + classValue + "'>" + ora_priv + "</td>" ) ;	
				out.println( "</tr>" ) ;
			}	i++;
		}	
			if ( pstmt != null ) pstmt.close() ;
			if ( pstmt1 != null ) pstmt1.close() ;
			if ( rs != null ) rs.close() ;
			out.println( "</tr>" ) ;
			out.println( "</table>" ) ;	
	} 
	else 
	{
%>
 
<%
	}

} catch (Exception e) {}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%></center>

