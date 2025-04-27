/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 02.11.2005
package ePH ;

import java.io.Serializable ;
import java.util.ArrayList;
import java.sql.*;
import ePH.Common.* ;
import eCommon.Common.* ;

public class PhIssueTokenBean extends PhAdapter implements Serializable {

	public PhIssueTokenBean() {
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
/*   Facility desc returns ends here    */

/*  Dispense Location starts where disp_locn_type = 'P' */

public ArrayList getDispLocationList() {
		ArrayList displocationlist = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_COMN_SELECT2" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());
	

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					displocationlist.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					displocationlist.add( resultSet.getString( "SHORT_DESC" ) );
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

		return displocationlist;
	}


// This getDispLocationList1 calling from worksheet chart jsp

public ArrayList getDispLocation() {
		ArrayList displocation = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_COMN_SELECT3" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					displocation.add( resultSet.getString( "DISP_LOCN_CODE" ) ) ;
					displocation.add( resultSet.getString( "SHORT_DESC" ) );
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

		return displocation;
	}

// upto this section

public ArrayList getTokenSeriesList(String facility_id,String disp_locn_code) {
		ArrayList TokenSerieslist = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TOKEN_SERIES_GEN_SELECT1" )) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					TokenSerieslist.add( resultSet.getString( "TOKEN_SERIES_CODE" ) ) ;
					TokenSerieslist.add( resultSet.getString( "DESCRIPTION" ) );
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

		return TokenSerieslist;
	}

	public ArrayList getTokenSeriesNos(String facility_id,String disp_locn_code,String token_series_code,String patient_id) {
		ArrayList TokenSerieslist = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TOKEN_SERIES_GEN_SELECT2" )) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,disp_locn_code);
			pstmt.setString(3,token_series_code);
			pstmt.setString(4,patient_id);

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					TokenSerieslist.add( resultSet.getString( "TOKEN_SERIAL_NO" ) ) ;
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
		return TokenSerieslist;
	}

	public String getPatientIDLength()
{
		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet			= pstmt.executeQuery(); 
			
			if( resultSet != null && resultSet.next() ) {
				pat_txt_length	=	checkForNull(resultSet.getString("PATIENT_ID_LENGTH"));
			}						
		}catch(Exception e){
				pat_txt_length	=e.toString();
		}
 	    finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			    }catch(Exception es){  
				es.printStackTrace() ;
				}
		      }
			return pat_txt_length;	
	  }

	
}
