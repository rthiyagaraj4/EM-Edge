<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>

<script language="JavaScript">
	function showBlankImage() {
		var path = document.getElementById("path").value ;
		document.getElementById('patient_photo').src = path + "blank.jpg" ;
	}
</script>

<%!
	Connection con =null;
	PreparedStatement pstmt ;
	ResultSet rs ;
%>

<%
try{
	request.setCharacterEncoding("UTF-8");	

	String patient_id	= (String) session.getValue( "patient_id" ) ;
	String path		= "" ;
	String image	= "" ;

	if ( patient_id == null ) patient_id = " " ;

//	con = (Connection) session.getValue( "connection" ) ;

	con = ConnectionManager.getConnection(request);

	pstmt = con.prepareStatement( "select pat_photo_http_path from sm_db_info" ) ;
	rs = pstmt.executeQuery() ;

	if ( rs != null && rs.next() ) {
		path = rs.getString( "pat_photo_http_path" ) ;
	}

	image = path + patient_id + ".jpg" ;

	out.println( "<img name='patient_photo' src='" + image + "' width='110' height='110' onError=\"showBlankImage();\">" ) ;

	out.println( "<form name='photo_form' id='photo_form'>" ) ;
	out.println( "<input type='hidden' name='path' id='path' value='" + path + "'>" ) ;
	out.println( "<input type='hidden' name='hello' id='hello' value='hello' >" ) ;
	out.println( "</form>" ) ;
%>

<%
	try {
		if ( rs != null ) rs.close() ;
		if ( pstmt != null ) pstmt.close() ;
	} catch ( Exception e ) {}
	} catch (Exception e ) {out.println(e);}
finally {
ConnectionManager.returnConnection(con,request);
}
%>

