/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date	Rev.Name	Description
--------------------------------------------------------------------------------------------------------
?			  100        	?									created
08/05/2015 	IN055319		Nijitha		08/05/2015   Akbar		ML-BRU-SCF-1607 : Include facility id in OR->Order Statistics Report 
--------------------------------------------------------------------------------------------------------
*/
package eOR ;

import java.io.* ;
import java.util.* ;
import java.sql.*;

import javax.rmi.* ;
import javax.naming.* ;
import eCommon.SingleTableHandler.* ;

import eOR.Common.* ;
import eCommon.Common.*;
import webbeans.eCommon.*; 

public class RepOrderStatBean extends OrAdapter implements Serializable {
	
	
	public String getOrderType(String order_Category) throws Exception {

		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;
		String order_type		= "";
		try
		  {
			connection  = getConnection();
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDERSET_ORDER_TYPE"));
			pstmt.setString( 1, order_Category);
			rs	  =pstmt.executeQuery();

			while(rs != null && rs.next())
				{
					order_type = rs.getString("order_type_code");
				}
			
			//if(pstmt!=null) pstmt.close();
			//if(rs!=null) rs.close();
			//if(connection!=null) connection.close();
		  }
		catch(Exception e){
				e.printStackTrace() ;
				throw e ;
				}finally {

			closeResultSet( rs ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}
		
		return order_type;
	}

	
	public ArrayList getOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		String[] record			 =		null;

		ArrayList OrderCategory = new ArrayList() ;

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_TYPE_ORD_CAT_SELECT") ) ;
			pstmt.setString(1,language_id);
			resultSet	= pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
					record = new String[10];
					record[0] = resultSet.getString( "order_category" )  ;
					record[1] = resultSet.getString( "short_desc" )  ;
					record[2] = resultSet.getString( "long_desc" )  ;
					record[3] = resultSet.getString( "result_applicable_yn" )  ;
					record[4] = resultSet.getString( "freq_applicable_yn" )  ;
					record[5] = resultSet.getString( "freq_update_allow_yn" )  ;
					record[6] = resultSet.getString( "soft_stop_applicable_yn" )  ;
					record[7] = resultSet.getString( "soft_stop_update_allow_yn" )  ;
					record[8] = resultSet.getString( "cont_order_applicable_yn" )  ;
					record[9] = resultSet.getString( "cont_order_update_allow_yn" )  ;
					OrderCategory.add(record) ;
			}
			record=null;
			
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database OrderCategory" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection);
		}

		return OrderCategory;
	}
	//IN055319 Starts
	public ArrayList getFacilityDetails() throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList facilityDetails	= new ArrayList() ;
		try 
		{
				connection = getConnection() ;
				pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_SPECIMEN_ORDER_FACILITY_SELECT") ) ;
				pstmt.setString( 1, language_id);
				pstmt.setString( 2, login_by_id );

				resultSet = pstmt.executeQuery() ;
				while(resultSet.next()) {
				    String record[] = new String[2];
				    record[0] = checkForNull(resultSet.getString( "facility_name" ),"");
				    record[1] = checkForNull(resultSet.getString( "facility_id" ),"") ;
					facilityDetails.add(record)  ;

				}
		} catch( Exception e )	{
			System.err.println( "Error loading values from database FACILITY" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection(connection) ;
		}
		return facilityDetails;
	}
	//IN055319 Ends
}
	
