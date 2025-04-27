/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 //saved on 29.12.2009
package ePH ;

import java.io.Serializable ;
import java.util.ArrayList;
import java.sql.*;
import ePH.Common.* ;
import eCommon.Common.* ;

public class SRRPHRepMednAdmnListBean extends PhAdapter implements Serializable {

	public SRRPHRepMednAdmnListBean() {
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

	public String getMednAdmnList() {
		String  med_adm_yn		= "";
		Connection connection	= null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet		= null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MEDN_ADMN_REQ" )) ;
			pstmt.setString(1,login_facility_id);

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				if ( resultSet.next() ) {
					med_adm_yn	= resultSet.getString( "MED_ADMIN_REQD_YN" ) ;
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
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return med_adm_yn;
    }
 	/* Over-ridden Adapter methods end here */

	public String getPatientIDLength(){

		Connection connection	=	null ;
		PreparedStatement pstmt =	null ;
		ResultSet resultSet		=	null ;        
		String	pat_txt_length	=	null ;

		try{
			connection			= getConnection() ;
			pstmt				= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_COMMON_SELECT1") ) ;
			resultSet	= pstmt.executeQuery(); 
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
				es.printStackTrace();
			}
		}
		return pat_txt_length;	
	}

	public ArrayList getMednNursingList(String locale) {
		ArrayList nursingList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_MED_ADMIN_SELECT2B" )) ;
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,login_by_id);
			pstmt.setString(3,login_facility_id); 
			pstmt.setString(4,locale);
	
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					nursingList.add( resultSet.getString( "NURSING_UNIT_CODE" ) ) ;
					nursingList.add( resultSet.getString( "SHORT_DESC" ) );
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
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return nursingList;
	}
/*   Nursing Unit desc returns ends here    */

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
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return dateList;
	}
/* to get the Dispense Locations List for Daily Dispense Summary Report -- added by Subbulakshmy(12/07/2006) */
	public ArrayList getDispLocnList(String facility_id){

		ArrayList dispLocnList = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		try {
			String disp_locn_sql = PhRepository.getPhKeyValue("SQL_PH_REPORT_DISP_LOCATION");
			connection = getConnection() ;
			pstmt = connection.prepareStatement(disp_locn_sql) ;
			pstmt.setString(1, facility_id);
			pstmt.setString(2,getLanguageId());

			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					dispLocnList.add( resultSet.getString( "disp_locn_code" ) ) ;
					dispLocnList.add( resultSet.getString( "short_desc" ) );
				}
			}
		}
		catch ( Exception e ) {
			System.err.println( "Error loading DispLocn List from database" ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace();
			}
		}
		return dispLocnList;
	}


public ArrayList getOrderingFacilities(String userName, String locale)
	{
		ArrayList order_facilities = new ArrayList() ;
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String sql = "SELECT B.FACILITY_ID FACILITY_ID,B.FACILITY_NAME FACILITY_NAME FROM SM_FACILITY_FOR_USER A, SM_FACILITY_PARAM_lang_vw B WHERE A.FACILITY_ID = B.FACILITY_ID AND B.STATUS ='E' AND APPL_USER_ID = ? AND B.LANGUAGE_ID= ?";

		try {
			connection = getConnection() ;
			
			pstmt = connection.prepareStatement(sql) ;
			pstmt.setString(1,userName);
			pstmt.setString(2,locale);
		
			resultSet = pstmt.executeQuery() ;
			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					order_facilities.add( resultSet.getString( "FACILITY_ID" ) ) ;
					order_facilities.add( resultSet.getString( "FACILITY_NAME" ) );
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
			catch(Exception es) {es.printStackTrace();}
		}

		return order_facilities;

	}

}
