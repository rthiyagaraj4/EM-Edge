<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/js;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>

<%!
	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;
%>

<%
	//con = (Connection) session.getValue( "connection" ) ;
	try{
	con=ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement( "select message_id, message_ref, message_text_sysdef from sm_message" ) ;
	rs = pstmt.executeQuery() ;

	out.println( "var messageArray = new Array() ; " ) ;

	if ( rs != null ) {
		while( rs.next() ) {
			String message_id		= rs.getString( "message_id" ) ;
			String message_ref	= rs.getString( "message_ref" ) ;
			String message_text	= rs.getString( "message_text_sysdef" ) ;
			out.println( "messageArray['" + message_ref + "'] = \"APP-" + message_id + " " + message_text + "\" ;" ) ;
		}
	}
%>

<%
	try {
		if ( rs != null ) rs.close() ;
		if ( pstmt != null ) pstmt.close() ;
	} catch ( Exception ce ) {}

	}catch(Exception e){out.println(e);}
	finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
%>
