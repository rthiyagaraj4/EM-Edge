<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*, java.sql.*,webbeans.eCommon.*" %>
<%
			request.setCharacterEncoding("UTF-8");	

	String file = request.getParameter( "file" ) ;
	String path = "" ;
	String httpPath = "" ;
	String oldFile = "" ;
	String oldFileExists = "0" ;

	if ( file == null ) file = "patient" ;		

	Connection con=ConnectionManager.getConnection(request);
	PreparedStatement pstmt = con.prepareStatement( "select pat_photo_os_path, pat_photo_http_path from sm_db_info" ) ;
	ResultSet rs = pstmt.executeQuery() ;

	if ( rs != null && rs.next() ) {
		path = rs.getString( "pat_photo_os_path" );
		httpPath = rs.getString( "pat_photo_http_path" ) ;
	}

	oldFile = path + file ;

	File f = new File( oldFile ) ;
	if ( f.exists() )
	oldFileExists = "1" ;
	
%>
<html>
	<head>
		<link rel='stylesheet' type ='text/css' href='../html/IeStyle.css'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<body onKeyDown = 'lockKey()'>
		<table align=center width='100%' height='100%' border=0 cellpadding=0 cellspacing=0>
			<tr>
				<td class='label' align=center id='preview'>
				<img name='oldPhoto' src='../images\blank.jpg'>
				</td>
				<td class='label' align=center id='final'>
				<% if ( oldFileExists.equals( "1" ) )out.println( "<img name='oldPhoto' src='" + httpPath + file + "'>" ) ;
				else out.println( "<img name='oldPhoto' src='" + httpPath + "blank.jpg" + "'>" ) ;%>
				</td>
			</tr>			
		</table>
	</body>
</html>
<%

	rs.close();
	pstmt.close();
	ConnectionManager.returnConnection(con,request);

%>

