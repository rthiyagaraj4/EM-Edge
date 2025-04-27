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
	PreparedStatement pstmtInsert ;
	PreparedStatement pstmtUpdate ;
	ResultSet rs ;
%>

<%
	try {
		 request.setCharacterEncoding("UTF-8");	

		String pat_id = request.getParameter( "patient_id" ) ;
		String file = request.getParameter( "file" ) ;
		String path = "\\\\dsg09\\Dev_eCIS\\eCIS\\pat_photo\\" ;
		String pat_file_name = "" ;

		if ( pat_id != null && file != null ) {
			pat_file_name	= path + file + ".jpg" ;
			out.println( "Writing Blob into Oracle Database for Patient id : " + pat_id ) ;

//			con		= (Connection) session.getValue( "connection" ) ;
			
			con=ConnectionManager.getConnection(request);

			con.setAutoCommit(false);
			out.println( "Connection established" ) ;

			pstmtInsert = con.prepareStatement( "insert into mp_patient_photo ( patient_id, pat_photo_blob ) values ( ?, empty_blob() ) " ) ;
			pstmtUpdate = con.prepareStatement( "select * from mp_patient_photo where patient_id = ? for update" ) ;

			pstmtInsert.setString( 1, pat_id ) ;
			pstmtUpdate.setString( 1, pat_id ) ;

			rs = pstmtUpdate.executeQuery() ;

			if ( !( rs != null && rs.next() ) ) {
				out.println( "Inserting a new record" ) ;
				pstmtInsert.executeUpdate() ;
				con.commit() ;
				pstmtInsert.close();
			}
			rs.close();


			rs = pstmtUpdate.executeQuery() ;

			if ( rs != null && rs.next() ) {
				out.println( "Record exists" ) ;

				Blob pat_photo = rs.getBlob( "pat_photo_blob" ) ;
				OutputStream os = ( (oracle.sql.BLOB) pat_photo ).getBinaryOutputStream();
				out.println( "Output Stream opened" ) ;

				File pat_file = new File( pat_file_name ) ;
				InputStream is = new FileInputStream( pat_file ) ;
				out.println( "Input Stream opened" ) ;

				byte[] buffer = new byte[ 10*1024 ] ;
				int read = 0 ;

				while ( ( read = is.read( buffer ) ) != -1 )
					os.write( buffer, 0, read ) ;

				out.println( "Blob data written" ) ;

				is.close() ;
				os.close() ;

				out.println( "Image successfully written to database" ) ;
			}
			rs.close();
			pstmtUpdate.close();
			con.commit() ;
		}
	} catch ( Exception e ) {
		out.println( e.getMessage() ) ;
	} finally {
		con.setAutoCommit( true ) ;
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}
	
%>

<%
	try {
		if ( rs != null ) rs.close() ;
		if ( pstmtInsert != null ) pstmtInsert.close() ;
		if ( pstmtUpdate != null ) pstmtUpdate.close() ;
	} catch ( Exception e ) {
		out.println( e.getMessage() ) ;
	}
	
%>
