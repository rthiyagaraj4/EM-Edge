/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMM ;

import java.io.Serializable ;
import java.sql.Connection ;
import java.sql.PreparedStatement ;
import java.sql.ResultSet ;
import java.util.HashMap ;
import java.util.Hashtable ;
import java.util.ArrayList ;
import eMM.Common.MmAdapter;
import eMM.Common.MmRepository;
import eCommon.Common.CommonRepository;
import eCommon.SingleTableHandler.SingleTableHandlerRemote;
import eCommon.SingleTableHandler.SingleTableHandlerHome;

public class StoreGroupBean extends MmAdapter implements Serializable
{	protected String store_group_code				= "";
	protected String store_group_long_desc				= "";
	protected String store_group_short_desc				= "";
	protected String store_group_enabled				= "D";

	
	public StoreGroupBean() throws Exception
	{ 
		try
		{
			doCommon();
		}
		catch(Exception e){
		e.printStackTrace();
		}
	}

	public void setStoreGroupCode (String store_group_code)
	{
		this.store_group_code = store_group_code;
	}
	public void setStoreGroupLongDesc (String store_group_long_desc)
	{
		this.store_group_long_desc = store_group_long_desc;
	}
	public void setStoreGroupShortDesc (String store_group_short_desc)
	{
		this.store_group_short_desc = store_group_short_desc;
	}  
	public void setStoreGroupEnabled( String store_group_enabled ) 
	{
		if(store_group_enabled.equals("") || store_group_enabled==null )
            this.store_group_enabled = "D" ;
        else
            this.store_group_enabled = store_group_enabled ;
	}

	public String getStoreGroupCode() 
	{
		return this.store_group_code;
	}
	public String getStoreGroupLongDesc() 
	{
		return this.store_group_long_desc;
	}
	public String getStoreGroupShortDesc() 
	{
		return this.store_group_short_desc;
	}
	public String getStoreGroupEnabled() 
	{
		return this.store_group_enabled	;
	}

	public void clear()
	{
		super.clear();
		store_group_code = "";
		store_group_long_desc = "";
		store_group_short_desc = "";
		store_group_enabled = "E";
	}

	public void setAll (Hashtable recordSet)
	{
		super.setAll(recordSet);

		if(recordSet.containsKey("store_group_code"))
			setStoreGroupCode((String)recordSet.get("store_group_code")) ;

		if(recordSet.containsKey("store_group_long_desc"))
			setStoreGroupLongDesc((String)recordSet.get("store_group_long_desc")) ;

		if(recordSet.containsKey("store_group_short_desc"))
			setStoreGroupShortDesc((String)recordSet.get("store_group_short_desc")) ;

		if(recordSet.containsKey("store_group_enabled") && (!((String)recordSet.get("store_group_enabled")).equals("")))
			setStoreGroupEnabled((String)recordSet.get("store_group_enabled"));
		else
			setStoreGroupEnabled("D");
	}

	private void doCommon() throws Exception 
	{
	}

	public HashMap validate()throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		return map;
	}

	public HashMap insert()
	{
		HashMap hmResult	=	new HashMap()	;
		HashMap hmTableData	=	new HashMap()	;
		HashMap hmSQLMap	=	new HashMap()	;
		ArrayList alInsertData	=	new ArrayList()	;
		ArrayList alWhereData	=	new ArrayList()	; 		
		ArrayList alLanguageData	= new ArrayList()	;
		
		hmResult.put("result", new Boolean( false ) ) ;

		alInsertData.add(store_group_code);		
		alInsertData.add(store_group_short_desc);
		alInsertData.add(store_group_long_desc); 		
		alInsertData.add(store_group_enabled);
		alInsertData.add(login_by_id);
		alInsertData.add(login_at_ws_no);
		alInsertData.add(login_facility_id); 
		alInsertData.add(login_by_id);
		alInsertData.add(login_at_ws_no);
		alInsertData.add(login_facility_id);
		
		alWhereData.add(store_group_code);
		alLanguageData.add(getLanguageId());

		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "InsertData",alInsertData);
		hmTableData.put	( "WhereData",alWhereData);
		hmTableData.put	( "LanguageData",alLanguageData);

		SingleTableHandlerRemote remote = null ;

		try {
			hmSQLMap.put	( "InsertSQL", "INSERT INTO MM_STORE_GROUP (STORE_GROUP_CODE,SHORT_DESC,LONG_DESC,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");

			hmSQLMap.put	( "SelectSQL", "SELECT COUNT(*) COUNT FROM MM_STORE_GROUP WHERE STORE_GROUP_CODE = ?"); 

			Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);		 				
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get( "result" )).booleanValue() )
					hmResult.put( "message", getMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else
					hmResult.put( "message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"ST") ) ;
			
		} 
		catch(Exception e)
		{
			hmResult.put( "message", e.toString()) ;
			e.printStackTrace() ;
		}
		finally
		{
			try {
					if( remote != null )
						remote.remove() ;
			}
			catch( Exception ee ) {
					hmResult.put( "message", ee.getMessage() ) ;
					ee.printStackTrace() ;
			}
		}  
		return hmResult;

	}

	public HashMap modify() 
	{
		HashMap hmResult = new HashMap();
		hmResult.put( "result", new Boolean( false ) ) ;

		HashMap hmTableData = new HashMap() ;
		ArrayList alModifyData = new ArrayList();
		ArrayList alLanguageData = new ArrayList() ;
		alModifyData.add(store_group_short_desc);
		alModifyData.add(store_group_long_desc);				
		alModifyData.add(store_group_enabled);
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id);
		alModifyData.add(store_group_code);
		
		alLanguageData.add(getLanguageId());

		hmTableData.put( "ModifyData",	alModifyData) ;
		hmTableData.put( "properties",	getProperties()) ;
		hmTableData.put( "LanguageData",alLanguageData);
		
		HashMap hmSQLMap = new HashMap() ;
		SingleTableHandlerRemote remote = null ;
		try
		{	
			hmSQLMap.put("ModifySQL", "UPDATE MM_STORE_GROUP SET SHORT_DESC=?,LONG_DESC=?,EFF_STATUS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE STORE_GROUP_CODE=?");

			Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);		 				
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
			if( ((Boolean) hmResult.get( "result" )).booleanValue() )		
					hmResult.put( "message", getMMMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else
					hmResult.put( "message", getMMMessage(getLanguageId(),(String) hmResult.get("msgid"),"ST") ) ;
		}
		catch(Exception e)
		{
			hmResult.put( "message", e.getMessage() ) ;
			e.printStackTrace() ;
		}
		finally
		{
			try {
				if( remote != null )
					remote.remove() ;
			} 
			catch( Exception ee ) 
			{
				hmResult.put( "message", ee.getMessage() ) ;
				ee.printStackTrace() ;
			}
		}

		return hmResult ;
	}

	public void loadData() throws Exception {
		Connection connection = null; 
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			pstmt = connection.prepareStatement("SELECT STORE_GROUP_CODE,SHORT_DESC,LONG_DESC,EFF_STATUS FROM  MM_STORE_GROUP_LANG_VW WHERE STORE_GROUP_CODE = ? AND LANGUAGE_ID = ?");	  
			pstmt.setString( 1, store_group_code);
			pstmt.setString( 2, getLanguageId());

			resultSet = pstmt.executeQuery();

			if ((resultSet != null) && (resultSet.next())) {				
				setStoreGroupCode(checkForNull(resultSet.getString("STORE_GROUP_CODE")));
				setStoreGroupLongDesc(checkForNull(resultSet.getString("LONG_DESC")));
				setStoreGroupShortDesc(checkForNull(resultSet.getString("SHORT_DESC")));
				setStoreGroupEnabled(checkForNull(resultSet.getString("EFF_STATUS")));		
			}
		} 
		catch (Exception e )	{
			e.printStackTrace();
			throw e;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}

		}
	}
}

 
