/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 05/11/2005
package ePH ;

import java.io.Serializable ;
import java.util.ArrayList;
import java.sql.*;
import ePH.Common.* ;
import eCommon.Common.* ;

public class PHRepDispStatByDrugBean extends PhAdapter implements Serializable {

	public PHRepDispStatByDrugBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
	}

	public ArrayList getFacilityList() {
		ArrayList facilityList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;


		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DRUG_DIAGNOSIS1" )) ;
			pstmt.setString(1,login_by_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					facilityList.add( resultSet.getString( "FACILITY_ID" ) ) ;
					facilityList.add( resultSet.getString( "FACILITY_NAME" ) );
				}
			}

		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
			es.printStackTrace() ;
			}
		}

		return facilityList;
	}
	/* Over-ridden Adapter methods end here */
}
