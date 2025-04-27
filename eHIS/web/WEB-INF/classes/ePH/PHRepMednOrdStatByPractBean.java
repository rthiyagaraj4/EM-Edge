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

public class PHRepMednOrdStatByPractBean extends PhAdapter implements Serializable {

	public PHRepMednOrdStatByPractBean() {
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

	public String getMednOrList() {
		String  med_or_yn		= "";
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;


		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_ORD_STAT_PRACT_SELECT" )) ;
		/*	pstmt.setString(1,login_facility_id);*/

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				if ( resultSet.next() ) {
					med_or_yn	= resultSet.getString( "INSTALL_YN" ) ;
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
			catch(Exception es) {System.err.println(es); }
		}

		return med_or_yn;
    }
 	/* Over-ridden Adapter methods end here */


public ArrayList getMednFacilityList() {
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
			System.err.println( "Error loading facility list" +e.toString()) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {System.err.println(es); }
		}

		return facilityList;
	}
/*   Facility desc returns ends here    */

/*  Getting sysdate & time ,sysdate & time  + 1 and sydate concate with 23:59  */


public ArrayList getMednDateList() {
		ArrayList dateList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;


		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_ADMN_DATE_SELECT1" )) ;
			
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					dateList.add( resultSet.getString( "IN_DATE" ) ) ;
					dateList.add( resultSet.getString( "EN_DATE" ) );
					dateList.add( resultSet.getString( "AD_DATE" ) );
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
			catch(Exception es) { System.err.println(es);}
		}

		return dateList;
	}

	public ArrayList getTitle(){

		ArrayList jobList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;


		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DRUG_PRACTITIONER_JOB_TITLE" )) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					jobList.add( resultSet.getString( "PRACT_TYPE" ) ) ;
					jobList.add( resultSet.getString( "DESC_SYSDEF" ) ) ;
					
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

		return jobList;
   }
}



