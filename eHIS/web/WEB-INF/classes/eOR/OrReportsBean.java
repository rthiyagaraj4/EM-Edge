/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR ;

import java.io.Serializable ;
import java.util.ArrayList;
import java.sql.*;
import eOR.Common.* ;
import eCommon.Common.* ;

public class OrReportsBean extends OrAdapter implements Serializable {

	public OrReportsBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {e.printStackTrace();}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
	}

	public ArrayList getMasterList() {
		ArrayList masterList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue( "SQL_OR_REPORT_CODE_SELECT" )) ;
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					masterList.add( resultSet.getString( "MASTER_CODE" ) ) ;
					masterList.add( resultSet.getString( "MASTER_CODE_DESC" ) );
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {es.printStackTrace(); }
		}

		return masterList;
	}
	/* Over-ridden Adapter methods end here */
}
