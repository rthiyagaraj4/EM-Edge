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
import javax.rmi.* ;
import java.sql.*;
import javax.naming.* ;
import webbeans.eCommon.*;
import eOR.ORPrivilegeGroup.* ;
import eOR.Common.*;
import eCommon.Common.*;

public class PrivilegeGroupBean extends eOR.Common.OrAdapter implements Serializable
{
	protected String exception_type;
	protected String grp_exception_id;
	protected String grp_exception_name;
	protected String order_category;
	protected String order_type_code;
	protected String EFF_STATUS;
	protected String priv_long_desc;
	public String debug="";
	public String bean_mode="";
	private HashMap hs			= new HashMap();
	private HashMap category			= new HashMap();
	private HashMap ordertype			= new HashMap();
	private HashMap catalog			= new HashMap();
	private LinkedHashMap tab_code			= new LinkedHashMap();
	private LinkedHashMap category_code			= new LinkedHashMap();
	private LinkedHashMap ordertype_code			= new LinkedHashMap();
	private LinkedHashMap catalog_code			= new LinkedHashMap();
	private LinkedHashMap view_code			= new LinkedHashMap();
	private LinkedHashMap order_tab			= new LinkedHashMap();
	private LinkedHashMap allValues			= new LinkedHashMap();
	private LinkedHashMap updateAllValues			= new LinkedHashMap();
	private LinkedHashMap Effstatus			= new LinkedHashMap();
	private LinkedHashMap privLongDesc			= new LinkedHashMap();
	private HashMap updatevalues=new HashMap();
	public  HashMap						privilegeHeaderStr ;
	eOR.Common.MultiRecordBean multiRecBean  = new eOR.Common.MultiRecordBean();

/*********************Constructor *************************/

 public PrivilegeGroupBean(){
	privilegeHeaderStr				= new HashMap();
	exception_type = "";
	grp_exception_id = "";
	grp_exception_name = "";
	order_category = "";
	order_type_code = "";
	bean_mode ="";
	
 }
 

/*********************METHOD TO SET ALL THE FEILDS AT ONCE*************************/
 public void setAll( Hashtable recordSet ) 
{
	 String tempEff = "";
	 String LongDescTemp = ""; 
	 System.out.println("===in set All method 59"+recordSet);
	if(recordSet.containsKey("Privilege_id"))
		 privilegeHeaderStr.put("Privilege_id",(String)recordSet.get("Privilege_id"));
	if(recordSet.containsKey("Privilege_long_desc"))
		 privilegeHeaderStr.put("Privilege_long_desc",(String)recordSet.get("Privilege_long_desc"));
	if(recordSet.containsKey("eff_status_yn"))
		 privilegeHeaderStr.put("eff_status_yn",(String)recordSet.get("eff_status_yn"));
	System.out.println("in bean =="+(String)recordSet.get("eff_status_yn"));
	tempEff = (String)Effstatus.get(recordSet.get("Privilege_id"));
	LongDescTemp = (String)privLongDesc.get(recordSet.get("Privilege_id"));
	privilegeHeaderStr.put("eff_status_yn_temp",tempEff);
	privilegeHeaderStr.put("Privilege_long_desc_temp",LongDescTemp);
	System.out.println("in bean == 70"+tempEff);
	System.out.println("in bean == LongDescTemp 71"+LongDescTemp);
	
 }


/*********************METHOD TO Insert*************************/
public HashMap insert()
{
	try
	{
	//System.out.println("in insert method....");
	HashMap map = new HashMap() ;
	HashMap sqlMap = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	HashMap recordStoreParam = new HashMap() ;
	recordStoreParam.put("privilegeHeaderStr"		,privilegeHeaderStr);
	recordStoreParam.put("category"	,category);
	recordStoreParam.put("ordertype"		,ordertype);
	recordStoreParam.put("catalog"		,catalog);
    recordStoreParam.put("login_by_id"		,login_by_id) ;
	recordStoreParam.put("login_at_ws_no"	,login_at_ws_no ) ;
	recordStoreParam.put("login_facility_id",login_facility_id ) ;
	sqlMap.put("SQL_OR_PRIVILEGE_GROUP_INSERT"			,OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_INSERT"));
	sqlMap.put("SQL_OR_PRIVILEGE_GROUP_DUP"			,OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_DUP"));
	sqlMap.put("SQL_OR_PRIVILEGE_GROUP_INSERT_ACCESS_RIGHTS"				,OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_INSERT_ACCESS_RIGHTS"));
	map.put("recordStoreParam",recordStoreParam);
	map.put("////sqlMap",sqlMap);
	return getResult(recordStoreParam,sqlMap );
	}
	catch(Exception e){
		System.err.println(" Err in Insert Meth ");
		logErrorMessage(e);
		return null;
	}
	
	} //end of insert method

	public HashMap modify()
	{
	try
		{
	//System.out.println("in modify method....");
	HashMap map = new HashMap() ;
	HashMap sqlMap = new HashMap();
	map.put( "result", new Boolean( false ) ) ;
	HashMap recordStoreParam = new HashMap() ;
	recordStoreParam.put("privilegeHeaderStr"		,privilegeHeaderStr);
	recordStoreParam.put("category"	,category);
	recordStoreParam.put("ordertype"		,ordertype);
	recordStoreParam.put("catalog"		,catalog);
    recordStoreParam.put("login_by_id"		,login_by_id) ;
	recordStoreParam.put("login_at_ws_no"	,login_at_ws_no ) ;
	recordStoreParam.put("login_facility_id",login_facility_id ) ;
	sqlMap.put("SQL_OR_PRIVILEGE_GROUP_DELETE"			,OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_DELETE"));
	sqlMap.put("SQL_OR_PRIVILEGE_GROUP_UPDATE"			,OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_UPDATE"));
	sqlMap.put("SQL_OR_PRIVILEGE_GROUP_UPDATE_EFF_STATUS"			,OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_UPDATE_EFF_STATUS"));
	sqlMap.put("SQL_OR_PRIVILEGE_GROUP_INSERT_ACCESS_RIGHTS"			,OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_INSERT_ACCESS_RIGHTS"));
	sqlMap.put("SQL_OR_PRIVILEGE_GROUP_AVAILABLE"			,OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_AVAILABLE"));
	sqlMap.put("SQL_OR_PRIVILEGE_GROUP_STATUS"			,OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_STATUS"));
	System.out.println("in modify method...."+recordStoreParam);
	map.put("recordStoreParam",recordStoreParam);
	map.put("////sqlMap",sqlMap);
	return getResult(recordStoreParam,sqlMap );
	}
	catch(Exception e){
		System.err.println(" Err in Insert Meth ");
		logErrorMessage(e);
		return null;
	}
	
	} //end of modify method

 private  HashMap getResult(HashMap record , HashMap sqlMap ) {
		//System.out.println("in getResult method....");
		 HashMap map  = new HashMap() ;
		 try{
			 //System.out.println("here");
			  Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(OrRepositoryExt.getOrKeyValue("PRIVILEGE_GROUP_JNDI"), ORPrivilegeGroupHome.class, getLocalEJB());
			  Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			  //System.out.println("home==="+home+"==busObj=="+busObj);
			HashMap tabDataParam =  new HashMap() ;
			tabDataParam.put( "properties", getProperties() );
			tabDataParam.put( "tabData",     record );
			//System.out.println("#####record="+record);
			Object argArray[]	= new Object[2];
			argArray[0]		= tabDataParam;
			argArray[1]		= sqlMap;
			Class [] paramArray = new Class[2];
			paramArray[0]	= tabDataParam.getClass();
			paramArray[1]	= sqlMap.getClass();		
						
			
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))){
				return null ;
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				//System.out.println("###in get result,insert ####");
				// map = remote.insert(tabDataParam, sqlMap ) ;
				map = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			}else if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
				//System.out.println("###in get result,modify ####");
					//map = remote.modify(tabDataParam, sqlMap )    ;
					map = (java.util.HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			}

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);	
			 
			  argArray		= null;
			  paramArray	= null;

			if( ((Boolean) map.get( "result" )).booleanValue() ){
					//map.put( "message", (String) map.get( "msgid" ));
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "SM")) ;
				}else{
					//map.put( "message", ((String) map.get("msgid"))) ;
					map.put( "message", getMessage(language_id, (String) map.get( "message" ), "Common")) ;
				}

	  //return map;

	 }catch(Exception e){
		System.err.println( "Error Calling EJB :" + e ) ;
		map.put( "message", e.getMessage() );
		e.printStackTrace() ;
		
	}
return map ;
		
	 }

/********************Validate Method ****************************/

 public HashMap validate() throws Exception{
	HashMap map = new HashMap() ;
	map.put( "result", new Boolean( true ) ) ;
	map.put( "message", "success.." ) ;
	return map ;
 }
 public Connection getConnection(Properties properties) throws Exception {
		Connection connection = ConnectionManager.getConnection(properties) ;
		return connection ;
	}

	public void closeConnection( Connection connection, Properties properties ) throws Exception {
		if( connection != null )
			ConnectionManager.returnConnection( connection, properties ) ;
	}

// public HashMap validate() throws Exception { } //end of validate

/*********************METHOD TO Reset the Class variable*************************/
public boolean copyValues(String tabvalue,String from) throws Exception
	{
			Connection connection = null ;
			Properties pt=null;
			boolean test=false; 
			try{
			pt = (Properties)getProperties();
			connection = getConnection(pt) ;
			String cate_code="";
			String Or_order_type_code="";

			
			Set s;
			Iterator it;
			s = category.entrySet();
			it = s.iterator();
			while (it.hasNext()){
			String temp_value=it.next().toString();
			String[] hashValues=temp_value.split("=");
			String[] keyValues=hashValues[0].split("!!");
			if(keyValues[0].equals(from))
			{
			test=true;
			hashValues[0]=tabvalue+"!!"+keyValues[1];
			hs.put(hashValues[0],hashValues[1]);
			}
			}
			if(test)
			{
			category.putAll(hs);
			allValues.putAll(hs);
			}
			hs.clear();
			s = ordertype.entrySet();
			it = s.iterator();
			while (it.hasNext()){
			String  temp_value=it.next().toString();
			String[] hashValues=temp_value.split("=");
			String[] keyValues=hashValues[0].split("!!");
			if(keyValues[0].equals(from))
			{
			test=true;
			hashValues[0]=tabvalue+"!!"+keyValues[1]+"!!"+keyValues[2];
			hs.put(hashValues[0],hashValues[1]);
			}
			}
			if(test)
			{
			ordertype.putAll(hs);
			allValues.putAll(hs);
			}
			hs.clear();
			s = catalog.entrySet();
			it = s.iterator();
			while (it.hasNext()){
			String temp_value=it.next().toString();
			String[] hashValues=temp_value.split("=");
			String[] keyValues=hashValues[0].split("!!");
			if(keyValues[0].equals(from))
			{
			test=true;
			hashValues[0]=tabvalue+"!!"+keyValues[1]+"!!"+keyValues[2]+"!!"+keyValues[3];
			hs.put(hashValues[0],hashValues[1]);
			}
			}
			if(test)
			{
			catalog.putAll(hs);
			allValues.putAll(hs);
			}
			hs.clear();
			s = updateAllValues.entrySet();
			it = s.iterator();
			String type="";
			while (it.hasNext()){
			String temp_value=it.next().toString();
			String[] hashValues=temp_value.split("=");
			String[] keyValues=hashValues[0].split("!!");
			type=keyValues[1];
			if(keyValues[0].equals(from))
			{
			test=true;
			if(keyValues[1].equals("C"))
			{
			hashValues[0]=tabvalue+"!!"+keyValues[2];
			category.put(hashValues[0],hashValues[1]);
			}
			else if(keyValues[1].equals("T"))
			{
			cate_code=getCategoryCode(keyValues[2],connection);
			hashValues[0]=tabvalue+"!!"+cate_code+"!!"+keyValues[2];
			ordertype.put(hashValues[0],hashValues[1]);
			}
			else if(keyValues[1].equals("I"))
			{
			Or_order_type_code=getTypeCode(keyValues[2],connection);
			cate_code=getCategoryCode(Or_order_type_code,connection);
			hashValues[0]=tabvalue+"!!"+cate_code+"!!"+Or_order_type_code+"!!"+keyValues[2];
			catalog.put(hashValues[0],hashValues[1]);
			}
			hs.put(hashValues[0],hashValues[1]);
			}
			}
			if(test)
			{
			allValues.putAll(hs);
			}

			hs.clear();
			}
			catch( Exception e ){
				connection.rollback();
					System.err.println( e.getMessage() ) ;
					e.printStackTrace() ;
			}
			finally{
	            	try {
						 closeConnection( connection ,pt);

        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }
			return test;
	}

public void clearHashValues()
	{
	category.clear();
	ordertype.clear();
	catalog.clear();
	allValues.clear();
	}
public String get_order_tab(String key)
	{
	return (String)order_tab.get(key);
	}
public void set_order_tab()
	{
	order_tab.put("OR","Ordering");
	//order_tab.put("VW","Viewing");
	order_tab.put("AU","Authorizing");
	//order_tab.put("SA","Spl-Approving");
	//order_tab.put("CS","Co-Signing");
	//order_tab.put("RR","Resulting");
	//order_tab.put("CN","Consent");
	//order_tab.put("RC","Recording");
	}
public HashMap get_category()
	{
	return category;
	}
public LinkedHashMap get_view_code()
	{
	return view_code;
	}
public String getViewCode(String key)
	{
	//System.out.println("===in get=key=="+key);
	return (String)view_code.get(key);
	}
public String get_tabCode(String key)
	{
	//System.out.println("===in get=key=="+key);
	return (String)tab_code.get(key);
	}
public LinkedHashMap get_tab_code()
	{
	return tab_code;
	}
public LinkedHashMap get_category_code()
	{
	return category_code;
	}

public LinkedHashMap get_ordertype_code()
	{
	return ordertype_code;
	}
public LinkedHashMap get_catalog_code()
	{
	return catalog_code;
	}

public LinkedHashMap getAllValues()
	{
	return allValues;
	}

public LinkedHashMap getUpdateAllValues()
	{
	return updateAllValues;
	}


public void setCategoryValues(String key, String value)
	{
	//System.out.println("before=="+category+"=="+allValues);
	category.put(key,value);
	allValues.put(key,value);
	//System.out.println("before=="+category+"=="+allValues);
	}
public void removeCategoryValues(String key)
	{
	//System.out.println("before=="+category+"=="+allValues);
	category.remove(key);
	allValues.remove(key);
	//System.out.println("before=="+category+"=="+allValues);
	}
public String getCategoryValue(String key)
	{
	//System.out.println("===in get=key=="+key);
	return (String)category.get(key);
	}
public void setTypeValues(String key, String value)
	{
	//System.out.println("==in set==key=="+key+"====value==="+value);
	ordertype.put(key,value);
	allValues.put(key,value);
	}
	public void removeTypeValues(String key)
	{
	ordertype.remove(key);
	allValues.remove(key);
	}
	public String getTypeValue(String key)
	{
	//System.out.println("===in get=key=="+key);
	return (String)ordertype.get(key);
	}

	public void setCatalogValues(String key, String value)
	{
	//System.out.println("==in set==key=="+key+"====value==="+value);
	catalog.put(key,value);
	allValues.put(key,value);
	}

	public void removeCatalogValues(String key)
	{
	catalog.remove(key);
	allValues.remove(key);
	}

public String getCatalogValue(String key)
	{
	//System.out.println("===in get=key=="+key);
	return (String)catalog.get(key);
	}
	public String getValueForUpdate(String key)
	{
	//System.out.println("===in get=key=="+key);
	return (String)updatevalues.get(key);
	}
	

	public boolean undoChanges(String tabvalue,String typecode,String type) throws Exception
	{
		Connection connection = null ;
		Properties pt=null;
		boolean flag=false;
		try{
		pt = (Properties)getProperties();
		connection = getConnection(pt) ;
		String cate_code="";
		String ordertype_ccode="";
		String key=tabvalue+"!!"+type+"!!"+typecode;
		//System.out.println("in undo.."+key);
		
		if(getUpdateAllValues().containsKey(key))
		{
		//System.out.println("coming here..");
		String value=getValueForUpdate(key);
		//System.out.println("here.."+value);
		if(type.equals("C"))
		{
				key=tabvalue+"!!"+typecode;
				setCategoryValues(key,value);
				flag=true;
		}else if(type.equals("T"))
		{
		cate_code=getCategoryCode(typecode,connection);
		key=tabvalue+"!!"+cate_code+"!!"+typecode;
		setTypeValues(key,value);
		flag=true;
		}else if(type.equals("I"))
		{
			ordertype_ccode=getTypeCode(typecode,connection);
			cate_code=getCategoryCode(ordertype_ccode,connection);
			key=tabvalue+"!!"+cate_code+"!!"+ordertype_ccode+"!!"+typecode;
			setCatalogValues(key,value);
			flag=true;
		}
		}
		}
			catch( Exception e ){
				connection.rollback();
				System.err.println( e.getMessage() ) ;
				e.printStackTrace() ;
			}
			finally{
	            	try {
						 closeConnection( connection ,pt);

        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }
		return flag;
	}
	public void copyOnceUpdateValues() throws Exception
	{
		Connection connection = null ;
		Properties pt=null;
		try{
		pt = (Properties)getProperties();
		connection = getConnection(pt) ;
		String cate_code="";
		String ordertype_ccode="";
		Set s;
		Iterator it;
		s = updateAllValues.entrySet();
			it = s.iterator();
			while (it.hasNext()){
			String temp_value=it.next().toString();
			String[] hashValues=temp_value.split("=");
			String[] keyValues=hashValues[0].split("!!");
			if(keyValues[1].equals("C"))
			{
			hashValues[0]=keyValues[0]+"!!"+keyValues[2];
			setCategoryValues(hashValues[0],hashValues[1]);
			}
			else if(keyValues[1].equals("T"))
			{
			cate_code=getCategoryCode(keyValues[2],connection);
			hashValues[0]=keyValues[0]+"!!"+cate_code+"!!"+keyValues[2];
			setTypeValues(hashValues[0],hashValues[1]);
			}
			else if(keyValues[1].equals("I"))
			{
			ordertype_ccode=getTypeCode(keyValues[2],connection);
			cate_code=getCategoryCode(ordertype_ccode,connection);
			hashValues[0]=keyValues[0]+"!!"+cate_code+"!!"+ordertype_ccode+"!!"+keyValues[2];
			setCatalogValues(hashValues[0],hashValues[1]);
			}
		}
		}
		catch( Exception e ){
				connection.rollback();
				System.err.println( e.getMessage() ) ;
				e.printStackTrace() ;
			}
			finally{
	            	try {
						 closeConnection( connection ,pt);

        			} catch ( Exception fe ) {
		     			System.err.println( fe.getMessage() ) ;
					   	fe.printStackTrace() ;
			        }
	    	    }

	}

	public void setDBValues()
	{
		Set s;
		Iterator it;
		int count=0;
		view_code.put("OR","Common.Ordering.label");
		//view_code.put("VW","eOR.Viewing.label");
		view_code.put("AU","eOR.Authorizing.label");
		//view_code.put("SA","eOR.Spl-Approving.label");
		//view_code.put("CS","eOR.Co-Signing.label");
		//view_code.put("RR","eOR.Resulting.label");
		//view_code.put("CN","eOR.Consent.label");
		//view_code.put("CN","Common.Consent.label");
		//view_code.put("RC","eOR.Recording.label");
				
		s = getAllValues().entrySet();
		it = s.iterator();
		while (it.hasNext()){
			String temp_value=it.next().toString();
			String[] hashValues=temp_value.split("=");
			StringTokenizer kv=new StringTokenizer(hashValues[0],"!!");
			count=kv.countTokens();
			String[] keyValues=hashValues[0].split("!!");
			tab_code.put(keyValues[0],keyValues[0]);
			if(count==2)
			{
				category_code.put(keyValues[1],keyValues[1]);
				
			}else if(count==3)
			{
				category_code.put(keyValues[1],keyValues[1]);
				ordertype_code.put(keyValues[2],keyValues[2]);
				
			}else if(count==4)
			{
				category_code.put(keyValues[1],keyValues[1]);
				ordertype_code.put(keyValues[2],keyValues[2]);
				catalog_code.put(keyValues[3],keyValues[3]);
				
			}

	}
	}
	public void clearDBValues()
		{
			category_code.clear();
			ordertype_code.clear();
			catalog_code.clear();
			view_code.clear();
			tab_code.clear();
		}

	public void clearUpdateValues()
	{
		updatevalues.clear();
		updateAllValues.clear();

	}


 public void clear() {
	grp_exception_id="";
	order_category="";
	order_type_code="";
	grp_exception_name="";
	super.clear() ;
 }//end of clear

 public ArrayList getOrderCategory()  throws Exception{
	Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
	ArrayList OrderCategory	= new ArrayList() ;
	try{
		connection = getConnection();
		pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATEG_LIST")) ;
			pstmt.setString(1,language_id);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				String[] orderCategoryRecords = new String[2];
				orderCategoryRecords[0] = resultSet.getString("order_category");
				orderCategoryRecords[1] = resultSet.getString("short_desc");

				OrderCategory.add(orderCategoryRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return OrderCategory;
	
}



 public ArrayList getOrderTypes(String orderCategory) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList OrderTypes	= new ArrayList() ;
		try
		{
			connection = getConnection();

			pstmt = connection.prepareStatement( OrRepository.getOrKeyValue("SQL_OR_ORDER_CATALOG_ORDER_TYPE")) ;
			pstmt.setString(1,orderCategory);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				String[] orderTypeRecords = new String[2];
				orderTypeRecords[0] = resultSet.getString("ORDER_TYPE_CODE");
				orderTypeRecords[1] = resultSet.getString("SHORT_DESC");

				OrderTypes.add(orderTypeRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return OrderTypes;
	}

	public String  getCategoryCode(String code,Connection connection) throws Exception
	{
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String OrderCategory=null;
		try{
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_GET_CATEGORY_CODE")) ;
			pstmt.setString(1,code);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				OrderCategory = resultSet.getString("Order_category");

				
			}

		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
		}
		return OrderCategory;
	}

	public String  getTypeCode(String code,Connection connection) throws Exception
	{
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String OrderType=null;
		try{
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_GET_ORDERTYPE_CODE")) ;
			pstmt.setString(1,code);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				OrderType = resultSet.getString("ORDER_TYPE_CODE");

				
			}

		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
		}
		return OrderType;
	}

	public String  getCategoryDesc(String code) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String OrderCategory=null;
		try{
				connection = getConnection();

			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_GET_CATEGORY_VALUES")) ;
			pstmt.setString(1,language_id);
			pstmt.setString(2,code);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				OrderCategory = resultSet.getString("SHORT_DESC");

				
			}

		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return OrderCategory;
	}

	public String  getOrderTypeDesc(String category ,String code) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String OrderType=null;
		try{
				connection = getConnection();

			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_GET_ORDERTYPE_VALUES")) ;
			pstmt.setString(1,category);
			pstmt.setString(2,code);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				OrderType = resultSet.getString("SHORT_DESC");

				
			}

		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return OrderType;
	}

	public String  getCatalogDesc(String category ,String type,String code) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String catalog_desc=null;
		try{
				connection = getConnection();

			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_GET_CATALOG_VALUES")) ;
			pstmt.setString(1,category);
			pstmt.setString(2,type);
			pstmt.setString(3,code);
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				catalog_desc = resultSet.getString("SHORT_DESC");

				
			}

		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return catalog_desc;
	}


	 public ArrayList getOrdercatalogs(String orderCategory,String ordertype,String alp,String tabValue,String limit_text) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		ArrayList Ordercatalogs	= new ArrayList() ;
		String sql ="";
		String[] orderCatalogRecords = null;
		if(orderCategory == null) orderCategory = "";
		if(ordertype == null) ordertype = "";
		if(alp == null) alp = "";
		if(tabValue == null) tabValue = "";
		if(limit_text == null) limit_text = "";
		try
		{
			connection = getConnection();
			if(alp.equalsIgnoreCase("others"))
			{
				sql= (String)OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_ORDER_CATALOGS_OTHERS");
			}
			else
			{
				sql= (String)OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_ORDER_CATALOGS");
			}
			if (tabValue.equalsIgnoreCase("AU"))
			{
				sql =sql.replace("##FILTER$$",", (select 'Y' FROM OR_ORDER_CATALOG_BY_PTCL WHERE ORDER_CATALOG_CODE=a.order_catalog_code AND ORD_AUTH_REQD_YN='Y' and rownum=1) authorise_req_yn ");
				if(limit_text.equalsIgnoreCase("AA"))
				{
					sql =sql.replace("##FILTER2$$"," and 'Y' = (select 'Y' FROM OR_ORDER_CATALOG_BY_PTCL WHERE ORDER_CATALOG_CODE=a.order_catalog_code AND ORD_AUTH_REQD_YN='Y' and rownum=1)");
				}
				else
				{
					sql =sql.replace("##FILTER2$$"," ");
				}
			}
			else
			{
				sql =sql.replace("##FILTER$$"," ");
				sql =sql.replace("##FILTER2$$"," ");
			}
			//System.out.println("sql 922"+sql);

			pstmt = connection.prepareStatement(sql); //connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_ORDER_CATALOGS")) ;
			
			pstmt.setString(1 , orderCategory);
			pstmt.setString(2 , orderCategory);
			pstmt.setString(3 , ordertype);
			if(!alp.equalsIgnoreCase("others"))
			{
				pstmt.setString(4 , alp+"%");
			}

			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				if (tabValue.equalsIgnoreCase("AU"))
				{
					orderCatalogRecords = new String[3];
				}
				else
				{
					orderCatalogRecords = new String[2];
				}
				orderCatalogRecords[0] = resultSet.getString("order_catalog_code");
				orderCatalogRecords[1] = resultSet.getString("SHORT_DESC");
				if (tabValue.equalsIgnoreCase("AU"))
				{
					orderCatalogRecords[2] = resultSet.getString("authorise_req_yn");
				}
				Ordercatalogs.add(orderCatalogRecords);
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return Ordercatalogs;
	}

public void setEFF_STATUS(String EFFSTATUS)
{
	  if(EFFSTATUS.trim().equals("") )
	  this.EFF_STATUS = "D";
	  else
	  this.EFF_STATUS=  EFFSTATUS;
}

public String getEff_status() { return this.EFF_STATUS ; } ;

public void setPrivDesc(String priv_long_desc)
{
	  if(priv_long_desc.trim().equals("") )
		this.priv_long_desc = "";
	  else
		this.priv_long_desc=  priv_long_desc;
}

public String getPrivDesc() 
{
	return this.priv_long_desc; 
} ;

public void setValuesForUpdate(String Priv_group_id) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		PreparedStatement pstmt1 	= null;
		ResultSet resultSet 		= null;
		ResultSet resultSet1 		= null;
		String EStatus				=null;
		String priv_long_desc   =null;
		
		try
		{
			connection = getConnection();
			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_GET_MODIFY_VALUES")) ;
			pstmt.setString(1,Priv_group_id);
		
			resultSet = pstmt.executeQuery();

			while(resultSet !=null && resultSet.next())
			{
				String[] Records = new String[4];
				Records[0] = resultSet.getString("priv_type");
				Records[1] = resultSet.getString("memb_ref");
				Records[2] = resultSet.getString("memb_id");
				Records[3] = resultSet.getString("acc_priv");
				
				String key=Records[0]+"!!"+Records[1]+"!!"+Records[2];
				String value=Records[3];
				updatevalues.put(key,value);
				updateAllValues.put(key,value);
				
			}
			pstmt1 = connection.prepareStatement("SELECT B.EFF_STATUS EFF_STATUS,PRIV_GRP_DESC PRIV_GRP_DESC FROM OR_PRIV_GROUP B WHERE B.PRIV_GRP_ID=?");
			pstmt1.setString(1,Priv_group_id);
			resultSet1 = pstmt1.executeQuery();
			while(resultSet1 !=null && resultSet1.next())
			{
				EStatus             =resultSet1.getString("EFF_STATUS");
				priv_long_desc =resultSet1.getString("PRIV_GRP_DESC");
			}
			//System.out.println("EStatus 1042"+EStatus);
			setEFF_STATUS(EStatus);
			setPrivDesc(priv_long_desc);
			Effstatus.put(Priv_group_id,EStatus);
			privLongDesc.put(Priv_group_id,priv_long_desc);
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			try{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
			}
			catch(Exception e)
				{throw e;}
		}
	}

	public String getAuthReqdYN(String order_catalog_code) throws Exception
	{
		Connection connection 		= null;
		PreparedStatement pstmt 	= null;
		ResultSet resultSet 		= null;
		String auth_reqd_yn = "N";
		try
		{
			connection = getConnection();

			pstmt = connection.prepareStatement(OrRepositoryExt.getOrKeyValue("SQL_OR_PRIVILEGE_GROUP_AUTHORISE")) ;
			pstmt.setString(1,order_catalog_code);
			resultSet = pstmt.executeQuery();
			while(resultSet !=null && resultSet.next())
			{
				auth_reqd_yn = resultSet.getString("auth_reqd_yn")==null?"N":resultSet.getString("auth_reqd_yn");	
			}
		}
		catch(Exception e)
		{
			System.err.println("Error loading values from database");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		return auth_reqd_yn;
	}
}//end of class


