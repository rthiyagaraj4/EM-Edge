/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.io.*;
import java.util.*; 
import java.sql.* ;

import javax.naming.*;
import javax.rmi.*;
import eOR.Common.* ;

import eCommon.Common.*;
import eCommon.SingleTableHandler.*;

public class OROrderablesBySourceBean extends OrAdapter implements java.io.Serializable 
{
	public OROrderablesBySourceBean()
	{
	}
	public ArrayList getCategoryList()
	{
		ArrayList catalogList = new ArrayList() ;
		Vector order_category = new Vector();
		Vector short_desc = new Vector();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST_AWC1")) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) 
			{
				while ( resultSet.next() ) 
				{
					order_category.add( resultSet.getString( "order_category" ) ) ;
					short_desc.add( resultSet.getString( "short_desc" ) );
				}
			}
			catalogList.add(order_category);
			catalogList.add(short_desc);
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				System.err.println("error"+es);
			}
		}

		return catalogList;
	}
	public ArrayList getOrderTypeList(String order_category)
	{
		ArrayList orderList = new ArrayList() ;
		Vector order_type_code = new Vector();
		Vector short_desc = new Vector();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue("SQL_OR_PRINT_ORD_ORDER_TYPE_SELECT ")) ;
			pstmt.setString(1,order_category);
			
			resultSet = pstmt.executeQuery() ;
		
			//if ( resultSet != null ) 
			//{
				while (resultSet != null && resultSet.next() ) 
				{
					order_type_code.add( resultSet.getString( "order_type_code" ) ) ;
					short_desc.add( resultSet.getString( "short_desc" ) );
				}
			//}
			orderList.add(order_type_code);
			orderList.add(short_desc);
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				System.err.println("Error"+es);
			}
		}
		return orderList;
	}
	public ArrayList getSourceCodeList(String code,String facility_id)
	{
		ArrayList codeList = new ArrayList() ;
		Vector unit_code = new Vector();
		Vector short_desc = new Vector();
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;

		try {
			connection = getConnection() ;
			String strQuery = "";
			if(code.equalsIgnoreCase("C"))
				strQuery = "SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_CLINIC";
			else
				strQuery = "SQL_OR_SPECIMEN_COLLECTION_SOURCE_CODE_NURSING";

			pstmt = connection.prepareStatement(OrRepository.getOrKeyValue(strQuery)) ;
			pstmt.setString(1,facility_id);
			resultSet = pstmt.executeQuery() ;
			if(code.equalsIgnoreCase("C"))
			{
				if ( resultSet != null ) 
				{
					while ( resultSet.next() ) 
					{
						unit_code.add( resultSet.getString( "clinic_code" ) ) ;
						//unit_code.add( resultSet.getString( "nursing_unit_code" ) ) ;
						short_desc.add( resultSet.getString( "short_desc" ) );
					}
				}
			}
				
			else 
			{
				if ( resultSet != null ) 
				{
					while ( resultSet.next() ) 
					{
						  //unit_code.add( resultSet.getString( "clinic_code" ) ) ;
						unit_code.add( resultSet.getString( "code" ) ) ;
						short_desc.add( resultSet.getString( "short_desc" ) );
					}
				}
			}
				codeList.add(unit_code);
				codeList.add(short_desc);
		}
		catch ( Exception e ) {
			//System.err.println( "Error loading values from database" ) ;
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
					System.err.println("Error"+es);
				}
		}
		return codeList;
	}
}
