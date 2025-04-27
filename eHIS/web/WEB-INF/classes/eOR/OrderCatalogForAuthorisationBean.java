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
?             100            ?           	created  - CRF 160
14/03/2014     IN041644		Nijitha S		Prescription Authorization of Drugs Based on Rules
18/03/2014     IN047812		Nijitha S		System displays an error message on duplicate entry
-----------------------------------------------------------------------
*/
package eOR;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import eCommon.Common.CommonRepository;
import eCommon.SingleTableHandler.SingleTableHandlerHome;
import eOR.Common.OrRepository;
import eOR.Common.OrRepositoryExt;

public class OrderCatalogForAuthorisationBean extends eOR.Common.OrAdapter implements java.io.Serializable 
{
	
	
	private static final long serialVersionUID = -871625485600877961L;
	protected String order_category = "";
	protected String order_type = "";
	protected String order_catalog_code = "";
	protected String duration_value = "";
	protected String duration_type = "";
	protected Hashtable hashMultiple	=null;
	protected int record_Count = 0;
	protected String ordering_practioner ="";
	protected String patient_id ="";
	protected String encounter_id ="";
	protected String order_date_time="";
	
	
	ArrayList deleteRecords = new ArrayList();
	
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
	
	
	public String getDuration_value() {
		return duration_value;
	}
	public void setDuration_value(String duration_value) {
		this.duration_value = duration_value;
	}
	public String getDuration_type() {
		return duration_type;
	}
	public void setDuration_type(String duration_type) {
		this.duration_type = duration_type;
	}
	public int getRecord_Count() 
	{
		return record_Count;
	}
	public void setRecord_Count(int record_Count) 
	{
		this.record_Count = record_Count;
	}
	
	public ArrayList<String[]> getOrderTypes(String orderCategory)throws Exception 
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 			= null;
		ArrayList<String[]> OrderCat = new ArrayList<String[]>();

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
	
	   	ArrayList<String> insertData = null;
		ArrayList<String> whereData =null;
		HashMap<String,ArrayList<String>> tabData = null;
		int rec_count = Integer.parseInt((String)hashMultiple.get("totalRecords"));
		int avail_rec_count =  0;
		StringBuffer rec_success = new StringBuffer();
		StringBuffer rec_failure = new StringBuffer();
		StringBuffer rec_pass = new StringBuffer();
		StringBuffer rec_nos = new StringBuffer();
		//String dupRec = ""; //COMMON-ICN-0122
		int index_success = 0;
		int index_failure = 0;
		
		boolean recordSuccess = false;
		boolean recordFailure = false;
		for(int i=0;i <= rec_count;i++)
		{
		if((((String)hashMultiple.get("order_type"+i)) != null && ((String)hashMultiple.get("order_type"+i)) != "") && (((String)hashMultiple.get("order_category"+i)) != null && ((String)hashMultiple.get("order_category"+i)) != "") && (((String)hashMultiple.get("order_catalog_code"+i)) != null && ((String)hashMultiple.get("order_catalog_code"+i)) != ""))
		{
			if(hashMultiple.containsKey("order_type"+i))
				setOrder_type((String)hashMultiple.get("order_type"+i)) ;
			if(hashMultiple.containsKey("order_category"+i))
				setOrder_category((String)hashMultiple.get("order_category"+i)) ;
			if(hashMultiple.containsKey("order_catalog_code"+i))
				setOrder_catalog_code((String)hashMultiple.get("order_catalog_code"+i)) ;
			if(hashMultiple.containsKey("duration_value"+i))
				setDuration_value((String)hashMultiple.get("duration_value"+i)) ;
			if(hashMultiple.containsKey("duration_type"+i))
				setDuration_type((String)hashMultiple.get("duration_type"+i)) ;
							
			insertData = new ArrayList<String>();	
			
			insertData.add( order_category ) ;
			insertData.add( order_type ) ;
			insertData.add( order_catalog_code ) ;
			insertData.add( duration_value ) ;
			insertData.add( duration_type ) ;
			insertData.add( login_by_id ) ;
			insertData.add( login_at_ws_no ) ;
			insertData.add( login_facility_id ) ;
			insertData.add( login_by_id ) ;
			insertData.add( login_at_ws_no ) ;
			insertData.add( login_facility_id ) ;
						
			whereData = new ArrayList<String>() ;
			
			whereData.add( order_category ) ;
			whereData.add( order_type ) ;
			whereData.add( order_catalog_code ) ;
			//whereData.add( duration_value ) ;//IN047812
			//whereData.add( duration_type ) ;//IN047812
						
			tabData = new HashMap<String,ArrayList<String>>() ;
			
			tabData.put( "InsertData", insertData);
			tabData.put( "WhereData", whereData);
			//tabData.put( "properties",	getProperties() ) ;
			
			
			HashMap<String, String> sqlMap = new HashMap<String, String>() ;
			try
			{
				sqlMap.put( "SelectSQL", OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_FOR_AUTHORISATION_DUPE_SELECT") );
				sqlMap.put( "InsertSQL", "INSERT INTO OR_ORDER_RULE_AUTHORISATION(ORDER_CATEGORY, ORDER_TYPE_CODE, ORDER_CATALOG_CODE,AUTH_DURN_VAL,AUTH_DURN_TYPE,ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?)" );
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
						//String truemsg = (String)map.get("msgid"); //COMMON-ICN-0122
						index_success = avail_rec_count;
						rec_pass.append(index_success);
					}
					else
					{
						recordFailure = true;
						index_failure = avail_rec_count;
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
		
		//int i = 0; //COMMON-ICN-0122
		if(hashMultiple.containsKey("upd_order_type"))
			setOrder_type((String)hashMultiple.get("upd_order_type")) ;
		if(hashMultiple.containsKey("upd_category_code"))
			setOrder_category((String)hashMultiple.get("upd_category_code")) ;
		if(hashMultiple.containsKey("upd_order_catalog_code"))
			setOrder_catalog_code((String)hashMultiple.get("upd_order_catalog_code")) ;
		if(hashMultiple.containsKey("upd_duration_value"))
			setDuration_value((String)hashMultiple.get("upd_duration_value"));
		if(hashMultiple.containsKey("upd_duration_type"))
			setDuration_type((String)hashMultiple.get("upd_duration_type"));
		
		formData.add( login_by_id ) ;
		formData.add( login_at_ws_no ) ;
		formData.add( login_facility_id ) ;
		formData.add( duration_value ) ;
		formData.add( duration_type ) ;
		formData.add( order_category ) ;
		formData.add( order_type ) ;
		formData.add( order_catalog_code ) ;
		
		
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyData",formData);
			
		formData=null;
		
		HashMap sqlMap = new HashMap() ;
		try
		{
			sqlMap.put( "ModifySQL", "UPDATE OR_ORDER_RULE_AUTHORISATION SET  MODIFIED_BY_ID = (?), MODIFIED_DATE = sysdate , MODIFIED_AT_WS_NO = (?), MODIFIED_FACILITY_ID  = (?), AUTH_DURN_VAL = (?) , AUTH_DURN_TYPE = (?) WHERE ORDER_CATEGORY = (?) and ORDER_TYPE_CODE = (?) and ORDER_CATALOG_CODE = (?)");
			
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
			try {
				//if( remote != null ) remote.remove() ;
			} catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}
		map.put("traceVal", (String)tmpBuff.toString());
		tmpBuff.setLength(0);
		return map;
	}
	
	public HashMap<String,String> insertAuthorisationDtls(){
		return null;
		
	}
	
	
}
