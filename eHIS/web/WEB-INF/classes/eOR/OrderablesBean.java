/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
import eCommon.Common.*;

public class  OrderablesBean implements java.io.Serializable
{
	 ArrayList recordsLine1 = new ArrayList();
	 public OrderablesBean()
    {
             
    }
	 public HashMap order_catalog_lookup			= new HashMap();
	//public ArrayList ar=new ArrayList();

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
			System.err.println( "Error loading values from database" ) ;
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
			System.err.println( "Error loading values from database" ) ;
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
/*	public void  setOrderCatalogs(String key,String value)
{
	order_catalog_lookup.put(key,value);
}
public HashMap  getOrderCatalogs()
{
	return order_catalog_lookup;
}*/
public void removeOrderCatalog(String key)
{
	System.out.println("key.."+key);
	order_catalog_lookup.remove(key);
	System.out.println("order_catalog_lookup.."+order_catalog_lookup);
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
	public ArrayList getStatusByDetail(String order_category, String order_type_code, String long_desc, String search_by, String description_code, String activity_type,int start,int end) throws Exception 
{
		
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList() ;
		String sql="";

 		

		try {
			if(order_category.equals(" ")) order_category = null;
			if(order_type_code.equals(" ")) order_type_code = null;
			if(long_desc.equals(" ")) long_desc = null;
			if(search_by.equals(" ")) search_by = null;
			if(description_code.equals(" ")) description_code = null;
			if(activity_type==null || activity_type.equals(" ")) activity_type = "";
			
		
			connection = ConnectionManager.getConnection();
			sql="SELECT order_catalog_code,long_desc FROM or_order_catalog WHERE order_category not in( 'PH' ,'CS') and order_category=NVL(?,order_category) AND order_type_code=NVL(?,order_type_code) AND ((upper(long_desc) LIKE DECODE(?,'C',UPPER('%'|| ? ||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) AND 'D' = ?) OR (upper(order_catalog_code) LIKE DECODE(?,'C',UPPER('%'|| ? ||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) AND 'C' = ?))  AND eff_status='E' AND NVL(activity_type,'!') = NVL(?,NVL(activity_type,'!')) ORDER BY long_desc";
		
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, order_category);
			pstmt.setString(2, order_type_code);
			pstmt.setString(3, description_code);
			pstmt.setString(4, long_desc);
			pstmt.setString(5, long_desc);
			pstmt.setString(6, long_desc);
			pstmt.setString(7, search_by);
			pstmt.setString(8, description_code);
			pstmt.setString(9, long_desc);
			pstmt.setString(10, long_desc);
			pstmt.setString(11, long_desc);
			pstmt.setString(12, search_by);
			pstmt.setString(13, activity_type);
						 
			resultSet = pstmt.executeQuery() ;

		
				if(start > 0)
					for(int i=0;(i<start-1 && resultSet.next());i++);
				while ( start <= end && resultSet!=null && resultSet.next()) {
  				 		String[] record = new String[3];
						
						record[0] = resultSet.getString( "order_catalog_code")==null?"":resultSet.getString("order_catalog_code");
						record[1] = resultSet.getString( "long_desc")==null?"":resultSet.getString("long_desc");
						
						OrderCat.add(record) ;
						start++;
 				}
				if (resultSet.next())
				{
					String[] templist = (String[])OrderCat.get(0);
					templist[2] = ""+(end+7);
					OrderCat.set(0,templist);
				}
			//}
		 
		} catch ( Exception e )	{
			System.err.println( "s7 Error loading values from database STATUS DETAIL" ) ;
			e.printStackTrace() ;
			throw e ;
		} finally {
			if(resultSet != null) 
					resultSet.close();
				if(pstmt != null) 
					pstmt.close();
				ConnectionManager.returnConnection(connection);	
		}

		return OrderCat;
}
public void addRecordstoLine1(String value)
{
		recordsLine1.add(value);
}
		/*public void  setOrderCatalogs(Object key,String value)
{
	//HashMap hm=new HashMap();
	//hm.put("code",key);
	//hm.put("desc",value);
	//System.out.println("HashMap hm in bean"+hm);
	if(!(ar.contains(key)))
	{
		ar.add(key);
	}
	System.out.println("ArrayList 1267"+ar);
	System.out.println("ArrayList 1268 size"+ar.size());

	//order_catalog_lookup.put(key,value);
}
public ArrayList  getOrderCatalogs()
{
	System.out.println("250 arraylist ar"+ar);
	 return this.ar;
	//return order_catalog_lookup;
}
	*/
public ArrayList returnList1()
{
		return recordsLine1;
}

}


