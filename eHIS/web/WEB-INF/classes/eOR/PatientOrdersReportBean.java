/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import eOR.Common.* ;
import java.io.*;
import java.util.*;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;
import javax.servlet.* ;
import eCommon.Common.*;
import javax.servlet.http.*;
import webbeans.eCommon.*;
//String bean_id	= patient_report ;

public class PatientOrdersReportBean extends eOR.Common.OrAdapter implements Serializable 
	{
//this will get the patient id length

	public int getpatient_id_length()throws Exception
		{
		int pat_length = 0 ;
		Connection connection		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;

		try 
			{
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_PATIENT_ID_LENGTH") ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() )
				{
				pat_length = resultSet.getInt( "patient_id_length" )  ;
			}
		} catch ( Exception e )	
			{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally
			{
			try
				{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}catch(Exception e)
				{
				System.err.println("catch"+e);
			}
		}
		return pat_length ;
	}

//////////////////
//For retreiving order_category values from data base
/////////////////

/*public String getComboOptions() 
	{
Connection connection = null ;
	String[] language_id_param = new String[1];
try
{
		language_id_param[0] = language_id;
		connection = getConnection() ;
		String str = Populate.getComboOptions(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST"),connection,"ORDER_CATEGORY","SHORT_DESC",language_id_param);
		return str;
	}
	catch(Exception e){
		System.out.println(e.getMessage());
		return null;
	}
	finally
	{
		try
		 {
				closeConnection(connection);
		 }catch(Exception e){

		 }
	}

}*/
	public ArrayList getAllOrderCategory () throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST") ) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_category" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
		}

		return OrderCat;
	}
	
	public ArrayList getOrderTypeData(String p_order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		if(p_order_category.equals(""))
			p_order_category = null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
			pstmt.setString( 1, p_order_category ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return OrderCat;
	}
	
	public ArrayList getOrderTypeData1(String p_order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		if(p_order_category.equals(""))
			p_order_category = null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
			pstmt.setString( 1, p_order_category ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return OrderCat;
	}
	}
//////////////////
//For retreiving order_Type values from data base
/////////////////

 /*public ArrayList getComboOptions1(String order_category) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		if(order_category.equals(""))
			order_category = null;
		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_EXISTING_ORDER_SELECT_ORDER_TYPE") ) ;
			pstmt.setString( 1, order_category ) ;
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] record = new String[2];
				record[0] = resultSet.getString( "order_type_code" )  ;
				record[1] = resultSet.getString( "short_desc" )  ;

				OrderCat.add(record) ;
			}
		} catch ( Exception e )	{
			System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);

		}

		return OrderCat;
	}
}*/

