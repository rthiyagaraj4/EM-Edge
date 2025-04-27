/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        	Description
-----------------------------------------------------------------------
?             100            DineshT           	created  - CRF 160
15/11/2012      IN036069            Karthik L           Delete rows issue.
09/10/2023     51003           Krishna Pranay    10/10/2023       Ramesh Goli        COMMON-ICN-0178

-----------------------------------------------------------------------
*/
package eOR;

import java.io.* ;
import java.util.* ;
import java.sql.*;
import javax.rmi.* ;
import javax.naming.* ;

import eOR.Common.* ;
import eCommon.Common.*;
import eCommon.SingleTableHandler.* ;

import eOR.ORRegisterOrder.*;
import webbeans.eCommon.*; 
import com.ehis.persist.*;

public class OrderCatalogForDeceasedBean extends eOR.Common.OrAdapter implements java.io.Serializable 
{
	
	protected String order_category = "";
	protected String order_type = "";
	protected String order_catalog_code = "";
	protected String postmortem_appl = "";
	protected String postmortem_type = "";
	protected String allow_for_deceased = "";
	protected Hashtable hashMultiple	=null;
	protected int record_Count = 0;
	
	ArrayList deleteRecords = new ArrayList();
	
	public String getOrder_category() 
	{
		return order_category;
	}
	public void setOrder_category(String order_category) 
	{
		this.order_category = order_category;
	}
	public String getOrder_type() 
	{
		return order_type;
	}
	public void setOrder_type(String order_type) 
	{
		this.order_type = order_type;
	}
	public String getOrder_catalog_code() 
	{
		return order_catalog_code;
	}
	public void setOrder_catalog_code(String order_catalog_code) 
	{
		this.order_catalog_code = order_catalog_code;
	}
	public String getPostmortem_appl() 
	{
		return postmortem_appl;
	}
	public void setPostmortem_appl(String postmortem_appl) 
	{
		this.postmortem_appl = postmortem_appl;
	}
	public String getPostmortem_type() 
	{
		return postmortem_type;
	}
	public void setPostmortem_type(String postmortem_type) 
	{
		this.postmortem_type = postmortem_type;
	}
	public String getAllow_for_deceased() 
	{
		return allow_for_deceased;
	}
	public void setAllow_for_deceased(String allow_for_deceased) 
	{
		//allow_for_deceased = (allow_for_deceased.trim().equals(""))? "N":allow_for_deceased;  IN036465
		if(allow_for_deceased.trim().equalsIgnoreCase("on")){ //IN036069
			allow_for_deceased = "Y";	
		}
		this.allow_for_deceased = allow_for_deceased;
	}
	public int getRecord_Count() 
	{
		return record_Count;
	}
	public void setRecord_Count(int record_Count) 
	{
		this.record_Count = record_Count;
	}
	
	public ArrayList getOrderTypes(String orderCategory)throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList OrderCat = new ArrayList();

		try 
		{
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT ORDER_TYPE_CODE , OR_GET_DESC.OR_ORDER_TYPE(ORDER_TYPE_CODE,?,'2') SHORT_DESC FROM OR_ORDER_TYPE WHERE ORDER_CATEGORY = ?") ;
			pstmt.setString( 1, language_id);
			pstmt.setString( 2, orderCategory.trim() ) ;
			resultSet = pstmt.executeQuery() ;

			while( resultSet != null && resultSet.next() ) 
			{
				String[] record = new String[2];
				record[0] = resultSet.getString( "ORDER_TYPE_CODE" )  ;
				record[1] = resultSet.getString( "SHORT_DESC" )  ;
				OrderCat.add(record) ;
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
			closeStatement( pstmt ) ;
			closeResultSet( resultSet ) ;
			closeConnection(connection) ;
		}

		return OrderCat;
	}	

	public String getOrderCategoryValues() 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String  description	="";
		String  value="";
		
		try
		{
			connection		= getConnection();
			pstmt			= connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_ORDER_TYPE_ORD_CATEGORY_SELECT"));
			pstmt.setString(1,language_id);
			resultSet		= pstmt.executeQuery() ;
			StringBuffer sb	= new StringBuffer();
			
			while (resultSet!=null && resultSet.next())
			{
				  description		= resultSet.getString(1);
				  value			= resultSet.getString(2);
				  sb.append(value+ "," + description + ",");
			}

			String str =   sb.toString() ;
			sb.setLength(0);
			
			return str.substring(0, str.length()-1);			 
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
			return null;
		}
		finally
		{
			try
			{	
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection(connection);
			}
			catch(Exception e)
			{
				 e.printStackTrace() ;
			}
		}
	}
	
	/* Get Methods End */
	/* Over-ridden Adapter methods start here */
	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;

		return map ;
	}

	public void setAll( Hashtable recordSetMultiple ) 
	{
		try
		{
				hashMultiple = recordSetMultiple ;
				setMode((String)recordSetMultiple.get("mode"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public HashMap insert() 
	{

		HashMap map			= new HashMap() ;
	    StringBuffer tmpBuff	= new StringBuffer();
	    map.put( "result", new Boolean( false ) ) ;
	
	   	ArrayList insertData = null;
		ArrayList whereData =null;
		HashMap tabData = null;
		int rec_count = Integer.parseInt((String)hashMultiple.get("totalRecords"));
		int avail_rec_count =  0;
		StringBuffer rec_success = new StringBuffer();
		StringBuffer rec_failure = new StringBuffer();
		StringBuffer rec_pass = new StringBuffer();
		StringBuffer rec_nos = new StringBuffer();
	//	String dupRec = "";//51003
		int index_success = 0;
		int index_failure = 0;
		
		boolean recordSuccess = false;
		boolean recordFailure = false;
		for(int i=0;i <= rec_count;i++) //IN036352
		{
		if((((String)hashMultiple.get("order_type"+i)) != null && ((String)hashMultiple.get("order_type"+i)) != "") && (((String)hashMultiple.get("order_category"+i)) != null && ((String)hashMultiple.get("order_category"+i)) != "") && (((String)hashMultiple.get("order_catalog_code"+i)) != null && ((String)hashMultiple.get("order_catalog_code"+i)) != "")) // IN036069
		{
			if(hashMultiple.containsKey("order_type"+i))
				setOrder_type((String)hashMultiple.get("order_type"+i)) ;
			if(hashMultiple.containsKey("order_category"+i))
				setOrder_category((String)hashMultiple.get("order_category"+i)) ;
			if(hashMultiple.containsKey("order_catalog_code"+i))
				setOrder_catalog_code((String)hashMultiple.get("order_catalog_code"+i)) ;
			if(hashMultiple.containsKey("postmortem_appl"+i))
				setPostmortem_appl((String)hashMultiple.get("postmortem_appl"+i)) ;
			if(hashMultiple.containsKey("postmortem_type"+i))
				setPostmortem_type((String)hashMultiple.get("postmortem_type"+i)) ;
			if(hashMultiple.containsKey("allow_for_deceased"+i))	
				setAllow_for_deceased((String)hashMultiple.get("allow_for_deceased"+i)) ;
				
			allow_for_deceased = (allow_for_deceased.trim().equals(""))? "Y":allow_for_deceased; // IN036465				
			insertData = new ArrayList();	
			
			insertData.add( order_category ) ;
			insertData.add( order_type ) ;
			insertData.add( order_catalog_code ) ;
			insertData.add( postmortem_appl ) ;
			insertData.add( postmortem_type ) ;
			insertData.add( allow_for_deceased ) ;
			insertData.add( login_by_id ) ;
			insertData.add( login_at_ws_no ) ;
			insertData.add( login_facility_id ) ;
			insertData.add( login_by_id ) ;
			insertData.add( login_at_ws_no ) ;
			insertData.add( login_facility_id ) ;
						
			whereData = new ArrayList() ;
			
			whereData.add( order_category ) ;
			whereData.add( order_type ) ;
			whereData.add( order_catalog_code ) ;
			whereData.add( postmortem_appl ) ;
			whereData.add( postmortem_type ) ;
						
			tabData = new HashMap() ;
			
			tabData.put( "InsertData", insertData);
			tabData.put( "WhereData", whereData);
			tabData.put( "properties",	getProperties() ) ;
			
			
			HashMap sqlMap = new HashMap() ;
			try
			{
				sqlMap.put( "SelectSQL", OrRepository.getOrKeyValue("SQL_OR_CATALOG_FOR_DECEASED_DUPE_SELECT") );
				sqlMap.put( "InsertSQL", OrRepository.getOrKeyValue("SQL_OR_CATALOG_FOR_DECEASED_INSERT") );
			}
			catch(Exception e)
			{
				e.printStackTrace() ;
			}
			try
			{
			
					Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
					Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
					Object argArray[]	= new Object[2];
					argArray[0]		= tabData;
					argArray[1]		= sqlMap;
					Class [] paramArray = new Class[2];
					paramArray[0]	= tabData.getClass();
					paramArray[1]	= sqlMap.getClass();
					map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
						
					 (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
					argArray=null;
					paramArray=null;
					avail_rec_count++;
					
					if( ((Boolean) map.get( "result" )).booleanValue() )
					{
						recordSuccess = true;
					//	String truemsg = (String)map.get("msgid");//51003
						index_success = avail_rec_count; //IN036069
						rec_pass.append(index_success);
					}
					else
					{
						recordFailure = true;
						index_failure = avail_rec_count; //IN036069
						rec_nos.append(index_failure);
						rec_nos.append(", ");
					}
					map.put("traceVal", (String)tmpBuff.toString());
					tmpBuff.setLength(0);
				} 
				catch(Exception e) 
				{
					System.err.println( "Error Calling EJB : "+e ) ;
					map.put( "message", e.getMessage() ) ;
					e.printStackTrace() ;
				} 
				finally 
				{
					 clear();
				}
				}
		}
		
		if(recordSuccess == true) 
		{
			rec_success.append(getMessage(language_id, "RECORD_INSERTED" , "SM"));
			if(recordFailure == true) 
			{
				rec_success.append("<BR>");
				rec_success.append(rec_nos);
				rec_success.append(getMessage(language_id, "DUPLICATE_RECORDS" , "OR"));
				recordFailure = false;
			}
			map.put(  "message", rec_success.toString());
			
		}
		if(recordFailure == true)
		{
			rec_failure.append(getMessage(language_id,(String) map.get( "msgid" ), "Common") + "   ");
			rec_failure.append("<BR>");
			rec_failure.append(rec_nos);
			rec_failure.append(getMessage(language_id, "DUPLICATE_RECORDS" , "OR"));
			map.put(  "message", rec_failure.toString());
			
		}
		return map ;
	} // end of insert
	
	public HashMap modify() 
	{

		HashMap map = new HashMap() ;
		StringBuffer tmpBuff = new StringBuffer();
		ArrayList formData = new ArrayList() ;
		
		int i = 0;
		if(hashMultiple.containsKey("upd_order_type"))
			setOrder_type((String)hashMultiple.get("upd_order_type")) ;
		if(hashMultiple.containsKey("upd_category_code"))
			setOrder_category((String)hashMultiple.get("upd_category_code")) ;
		if(hashMultiple.containsKey("upd_order_catalog_code"))
			setOrder_catalog_code((String)hashMultiple.get("upd_order_catalog_code")) ;
		if(hashMultiple.containsKey("upd_postmortem_app"))
			setPostmortem_appl((String)hashMultiple.get("upd_postmortem_app"));
		if(hashMultiple.containsKey("upd_postmortem_type"))
			setPostmortem_type((String)hashMultiple.get("upd_postmortem_type"));
		if(hashMultiple.containsKey("allow_for_deceased"+i))	
			setAllow_for_deceased((String)hashMultiple.get("allow_for_deceased"+i)) ;
	
		allow_for_deceased = (allow_for_deceased.trim().equals(""))? "N":allow_for_deceased; //IN036465
		formData.add( allow_for_deceased ) ;
		formData.add( login_by_id ) ;
		formData.add( login_at_ws_no ) ;
		formData.add( login_facility_id ) ;
		formData.add( order_category ) ;
		formData.add( order_type ) ;
		formData.add( order_catalog_code ) ;
		formData.add( postmortem_appl ) ;
		formData.add( postmortem_type ) ;
		
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",formData);
			
		formData=null;
		
		HashMap sqlMap = new HashMap() ;
		try
		{
			sqlMap.put( "ModifySQL",  OrRepository.getOrKeyValue("SQL_OR_CATALOG_FOR_DECEASED_UPDATE") );
			
		}
		catch(Exception e)
		{
			e.printStackTrace() ;
		}
		try 
		{
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"), SingleTableHandlerHome.class, getLocalEJB());
    		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]	= new Object[2];
			argArray[0]		= tabData;
			argArray[1]		= sqlMap;
 			Class [] paramArray = new Class[2];
 			paramArray[0]	= tabData.getClass();
			paramArray[1]	= sqlMap.getClass();
 			map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
			argArray=null;
			paramArray=null;
			map.put( "message", getMessage(language_id, (String) map.get( "msgid" ), "SM")) ;
			map.put("traceVal", (String)tmpBuff.toString());
		} 
		catch(Exception e)
		{
			System.err.println( "Error Calling EJB : "+e ) ;
			map.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		} 
		finally 
		{
			clear();
			/*try {
				if( remote != null ) remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}*/
		}
		map.put("traceVal", (String)tmpBuff.toString());
		tmpBuff.setLength(0);
		return map;
	}
	
	public void addDeleteRecords(String value)
	{
		if(!deleteRecords.contains(value))
		deleteRecords.add(value);
	}

	public void removeDeleteRecords(String value)
	{
		if(deleteRecords.contains(value))
		deleteRecords.remove(value);
	}

	public ArrayList getDeleteRecords()
	{
		return deleteRecords;
	}
}
