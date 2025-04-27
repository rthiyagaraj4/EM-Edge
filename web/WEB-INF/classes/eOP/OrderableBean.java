/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOP;

import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import eCommon.Common.*;

public class  OrderableBean implements java.io.Serializable
{
	 
	 public HashMap order_catalog_lookup			= new HashMap();

	 public ArrayList  getOrderCategory(Properties property) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList orderCategory		= new ArrayList();
		String locale				= (String) property.getProperty("LOCALE");

		try {
			connection = ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=?  ORDER BY short_desc") ;
			pstmt.setString( 1, locale);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] order_cat 			= new String[2];
				//order_cat[0] = resultSet.getString(1)  ;
				//order_cat[1] = resultSet.getString(2)  ;

				order_cat[0] = resultSet.getString("order_category")  ;
				order_cat[1] = resultSet.getString("short_desc")  ;

				orderCategory.add(order_cat);
				
			}
			

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(connection);
		}

		return orderCategory;
	}

	 public ArrayList  getOrderType(Properties property,String order_cat) throws Exception {
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList orderType		= new ArrayList();
		String locale				= (String) property.getProperty("LOCALE");

		try {
			connection = ConnectionManager.getConnection();
			pstmt = connection.prepareStatement("select short_desc,order_type_code from or_order_type_lang_vw where order_category=? and language_id=? order by short_desc") ;
			pstmt.setString( 1, order_cat);
			pstmt.setString( 2, locale);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet != null && resultSet.next() ) {
				String[] order_Type 			= new String[2];
				order_Type[0] = resultSet.getString(2)  ;
				order_Type[1] = resultSet.getString(1)  ;
				orderType.add(order_Type);
				
			}
			

		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet != null) resultSet.close();
			if(pstmt != null) pstmt.close();
			ConnectionManager.returnConnection(connection);
		}

		return orderType;
	}
	public ArrayList getActivityType(Properties property,String order_category, String order_type) throws Exception 
	{
			Connection connection 		= null;
			PreparedStatement pstmt 	= null;
			ResultSet resultSet 		= null;
			ArrayList ActivityType		= new ArrayList() ;
			String locale				= (String) property.getProperty("LOCALE");
			try {
					
					connection = ConnectionManager.getConnection();
					pstmt = connection.prepareStatement("SELECT activity_type, short_desc  FROM or_activity_type_lang_vw WHERE language_id=? and order_category = nvl(?, order_category) AND ( order_type_code = nvl(?,order_type_code) OR order_type_code = '*ALL' ) and eff_status ='E'   ORDER BY short_desc");
					pstmt.setString( 1, locale);
					pstmt.setString( 2, order_category) ;
					pstmt.setString( 3, order_type) ;
					

					resultSet = pstmt.executeQuery() ;

				while ( resultSet != null && resultSet.next() ) {
							String[] record = new String[2];
							record[0] = resultSet.getString( "activity_type" )  ;
							record[1] = resultSet.getString( "short_desc" )  ;
							ActivityType.add(record) ;
					}
			} catch ( Exception e )	{
			
				e.printStackTrace() ;
				throw e ;
			} finally {

				if(resultSet != null) 
					resultSet.close();
				if(pstmt != null) 
					pstmt.close();
				ConnectionManager.returnConnection(connection);	
			}
			return ActivityType;
	}
	public void  setOrderCatalogs(String key,String value)
{
	order_catalog_lookup.put(key,value);
}
public HashMap  getOrderCatalogs()
{
	return order_catalog_lookup;
}
public void removeOrderCatalog(String key)
{
	
	order_catalog_lookup.remove(key);
}
public void clearOrderCatalog(String key)
{
	order_catalog_lookup.clear();
}



	public String checkForNull(String IntermediateString)	
	{
		if(IntermediateString == null ||IntermediateString.equals(""))
		IntermediateString="";

		return IntermediateString;
	}

}


