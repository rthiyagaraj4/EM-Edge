<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*, java.sql.*,webbeans.eCommon.*" %>

<%!
	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;
%>

<%
try{
request.setCharacterEncoding("UTF-8");	
	String path = "" ;

	String old_file = request.getParameter( "old_file" ) ;
	String new_file = request.getParameter( "new_file" ) ;

//	con = (Connection) session.getValue( "connection" ) ;
	
	con = ConnectionManager.getConnection(request);

	pstmt = con.prepareStatement( "select pat_photo_os_path from sm_db_info" ) ;
	rs = pstmt.executeQuery() ;

	if ( rs != null && rs.next() ) {
		path = rs.getString( "pat_photo_os_path" ) ;
	}

	try {
		File aFile = new File( path + old_file ) ;
		File bFile = new File( path + new_file ) ;

		aFile.renameTo( bFile ) ;
	} catch ( Exception e ) {
		out.println( e.getMessage() ) ;
	}
%>

<%
	try {
		if ( rs != null ) rs.close() ;
		if ( pstmt != null ) pstmt.close() ;
	} catch ( Exception e ) {}
}catch(Exception e){out.println(e);}
finally{
if(con!=null)
	ConnectionManager.returnConnection(con,request);
}
%>
