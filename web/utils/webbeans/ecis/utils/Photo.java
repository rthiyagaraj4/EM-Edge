/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ecis.utils ;

import java.io.* ;
import java.sql.* ;

public class Photo {
	PreparedStatement pstmt ;
	ResultSet rs ;

	public String rename( Connection con, String oldFile, String newFile ) {
		String result = "" ;
		boolean changed = false ;

		try {
			pstmt = con.prepareStatement( "select pat_photo_os_path from sm_db_info" ) ;
			rs = pstmt.executeQuery() ;
			String path = "" ;

			if ( rs != null && rs.next() )
				path = rs.getString( "pat_photo_os_path" ) ;

			File oldPhoto = new File( path + oldFile ) ;
			File newPhoto = new File( path + newFile ) ;

			changed = oldPhoto.renameTo( newPhoto ) ;
		} catch ( Exception e ) {
			result = result + e.getMessage() ;
		} finally {
			try {
				if ( rs != null ) rs.close() ;
				if ( pstmt != null ) pstmt.close() ;
			} catch ( Exception fe ) {
				result = result + fe.getMessage() ;
			}
		}

		return result + changed ;
	}
}

