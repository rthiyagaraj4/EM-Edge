/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
-----------------------------------------------------------------------------------------------------------------------
14/10/2019		IN071513		Ramesh G			14/10/2019		Ramesh G		ML-BRU-CRF-0585.1
06/04/2020		IN072674		Durga Natarajan		07/04/2020		Ramesh G		MMS-KH-CRF-0032
14/07/2022      33870           Twinkle Shah        21/07/2022		Ramesh G        ML-MMOH-CRF-1763
10/03/2022      36285             Hariharan k       		                                            MMs-DM-CRF-0221.v1.0(003)
16/10/2023  32902              Ranjith P R      17/10/2023		Ramesh G        MMS-DM-CRF-0210
-----------------------------------------------------------------------------------------------------------------------
*/
package eCA;

import java.io.*;
import java.util.*;
import java.sql.* ;

import javax.naming.*;
import javax.rmi.*;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;
import webbeans.eCommon.*;


public class CAParamForFacilityBean extends eCA.Common.CaAdapter implements java.io.Serializable {
	public int checkForMode(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		int record = 0;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( "SELECT COUNT(*) AS TOTAL FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=?" ) ;
			pstmt.setString(1,facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				 record = resultSet.getInt("total");
			}
		} catch ( Exception e )	{
			
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return record;
	}
	public String getFacilityName(String facility_id) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		String record = "";
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select facility_name from sm_facility_param where facility_id =?") ;
			pstmt.setString(1, facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				 record = resultSet.getString("facility_name");
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return record;
	}
	public String[] getValues(String facility_id) throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;

		// 33870 starts.
		// String[] allValues = new String[3];//modified for IN066119//IN072674
		  // String[] allValues = new String[4];
		//33870 end.
		 //  String[] allValues = new String[5];//36285 
		   String[] allValues = new String[6];//32902 
		try 
		{
			connection = getConnection() ;
			//33870 Start.
			//pstmt = connection.prepareStatement( "SELECT FACILITY_ID,LOGO_SITE_FACILITY,THIRDPARTY_VITALS_TIME_DUR FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=?" ) ;//IN072674
			//pstmt = connection.prepareStatement( "SELECT FACILITY_ID,LOGO_SITE_FACILITY,THIRDPARTY_VITALS_TIME_DUR,PRACT_LOC_DEFAULT_YN FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=?" );//33870  added.
			//33870 End.
			//pstmt = connection.prepareStatement( "SELECT FACILITY_ID,LOGO_SITE_FACILITY,THIRDPARTY_VITALS_TIME_DUR,PRACT_LOC_DEFAULT_YN,EN_PRI_SEC_PROC_YN FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=?" );//36285   added.
			pstmt = connection.prepareStatement( "SELECT FACILITY_ID,LOGO_SITE_FACILITY,THIRDPARTY_VITALS_TIME_DUR,PRACT_LOC_DEFAULT_YN,EN_PRI_SEC_PROC_YN,HIDE_PAT_UNAUTH_PRACT_YN FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=?" );//32902   added.
			
			pstmt.setString(1, facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) 
			{
				allValues[0] = resultSet.getString("FACILITY_ID");
				allValues[1] = resultSet.getString("LOGO_SITE_FACILITY");
				allValues[2] = resultSet.getString("THIRDPARTY_VITALS_TIME_DUR");//IN072674 starts
				allValues[3] = resultSet.getString("PRACT_LOC_DEFAULT_YN");//33870  added.
				allValues[4] = resultSet.getString("EN_PRI_SEC_PROC_YN");//36285 
				allValues[5] = resultSet.getString("HIDE_PAT_UNAUTH_PRACT_YN");//rpr
						}
		} 
		catch ( Exception e )	
		{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} 
		finally 
		{
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return allValues;
	}
}