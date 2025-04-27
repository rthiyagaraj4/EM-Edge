/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
--------------------------------------------------------------------------------------------------------------------
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


public class CAMenstrualHistDtlBean extends eCA.Common.CaAdapter implements java.io.Serializable {
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
	
	 public ArrayList getMenstrualHistoryDetailsRecords(String facility_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet rs 			= null;

		ArrayList MenstrualHistDtlResult  =new ArrayList();
		try 
		{
			connection = getConnection() ;
			//33870 Start.
			pstmt = connection.prepareStatement( "SELECT FACILITY_ID,MIN_AGE,MAX_AGE,CUT_OFF_BACK_DATE,CUT_OFF_DATE_DELIVERY,CUT_OFF_DELIVERY_LMP,CUT_OFF_MISCARRIAGE_LMP,ENABLE_MARK_AS_ERROR_YN FROM CA_MENSTRUAL_HIST_DTL WHERE FACILITY_ID=?" );//32902   added.
			
			pstmt.setString(1, facility_id);
			rs = pstmt.executeQuery() ;

			while ( rs != null && rs.next() ) 
			{
				ArrayList<String>  MenstrualHistDtlRec = new ArrayList<String>();
				MenstrualHistDtlRec.add(rs.getString("FACILITY_ID")==null?"":(String)rs.getString("FACILITY_ID"));
	            MenstrualHistDtlRec.add(rs.getInt("MIN_AGE") == 0 ? "1" : String.valueOf(rs.getInt("MIN_AGE")));
	            MenstrualHistDtlRec.add(rs.getInt("MAX_AGE") == 0 ? "999" : String.valueOf(rs.getInt("MAX_AGE")));
	            MenstrualHistDtlRec.add(rs.getInt("CUT_OFF_BACK_DATE") == 0 ? "0" : String.valueOf(rs.getInt("CUT_OFF_BACK_DATE")));
	            MenstrualHistDtlRec.add(rs.getInt("CUT_OFF_DATE_DELIVERY") == 0 ? "0" : String.valueOf(rs.getInt("CUT_OFF_DATE_DELIVERY")));
	            MenstrualHistDtlRec.add(rs.getInt("CUT_OFF_DELIVERY_LMP") == 0 ? "1" : String.valueOf(rs.getInt("CUT_OFF_DELIVERY_LMP")));
	            MenstrualHistDtlRec.add(rs.getInt("CUT_OFF_MISCARRIAGE_LMP") == 0 ? "1" : String.valueOf(rs.getInt("CUT_OFF_MISCARRIAGE_LMP")));
				MenstrualHistDtlRec.add(rs.getString("ENABLE_MARK_AS_ERROR_YN")==null?"N":(String)rs.getString("ENABLE_MARK_AS_ERROR_YN"));

				MenstrualHistDtlResult.add(MenstrualHistDtlRec);

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
			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return MenstrualHistDtlResult;
	}
}