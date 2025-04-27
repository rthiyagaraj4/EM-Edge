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
import eST.Common.*;
import eCommon.Common.* ;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import eMM.Common.MmAdapter;
import eMM.Common.MmRepository;
import eCommon.Common.CommonRepository;
import eCommon.SingleTableHandler.SingleTableHandlerRemote;
import eCommon.SingleTableHandler.SingleTableHandlerHome;

public class ItemTechNameBean extends MmAdapter implements Serializable
{
	protected String Item_Tech_Name_code				= "";
	protected String Item_Tech_long_desc				= "";
	protected String Item_Tech_short_desc				= "";
	protected String Item_Tech_Remarks				= "";
	protected String Item_Tech_enabled				= "Y";
	
	public void setItemTechCode (String Item_Tech_Name_code)
	{
		this.Item_Tech_Name_code = Item_Tech_Name_code;
	}
	public String getItemTechCode() 
	{
		return this.Item_Tech_Name_code;
	}
	
	public void setItemTechLongDesc (String Item_Tech_long_desc)
	{
		this.Item_Tech_long_desc = Item_Tech_long_desc;
	}
	public String getItemTechLongDesc() 
	{
		return this.Item_Tech_long_desc;
	}
	
	public void setItemTechShortDesc (String Item_Tech_short_desc)
	{
		this.Item_Tech_short_desc = Item_Tech_short_desc;
	}
	public String getItemTechSHortDesc() 
	{
		return this.Item_Tech_short_desc;
	}
	
	public void setItemTechRemarks (String Item_Tech_Remarks)
	{
		this.Item_Tech_Remarks = Item_Tech_Remarks;
	}
	public String getItemTechRemarks() 
	{
		return this.Item_Tech_Remarks;
	}
	public void setItemTechNameEnabled (String Item_Tech_enabled)
	{
		this.Item_Tech_enabled = Item_Tech_enabled;
	}
	public String getItemTechNameEnabled() 
	{
		return this.Item_Tech_enabled	;
	}
	public void clear()
	{
		super.clear();
		Item_Tech_Name_code = "";
		Item_Tech_long_desc="";
		Item_Tech_short_desc="";
		Item_Tech_Remarks="";
		Item_Tech_enabled="Y";
		
	}
	public void setAll (Hashtable recordSet)
	{
		super.setAll(recordSet);

		if(recordSet.containsKey("Item_Tech_Name_code"))
			setItemTechCode((String)recordSet.get("Item_Tech_Name_code")) ;

		if(recordSet.containsKey("Item_Tech_long_desc"))
			setItemTechLongDesc((String)recordSet.get("Item_Tech_long_desc")) ;

		if(recordSet.containsKey("Item_Tech_short_desc"))
			setItemTechShortDesc((String)recordSet.get("Item_Tech_short_desc")) ;

		if(recordSet.containsKey("Item_Tech_Remarks"))
			setItemTechRemarks((String)recordSet.get("Item_Tech_Remarks")) ;
		
		if(recordSet.containsKey("Item_Tech_enabled") && (!((String)recordSet.get("Item_Tech_enabled")).equals("")))
			setItemTechNameEnabled((String)recordSet.get("Item_Tech_enabled"));
		else
			setItemTechNameEnabled("N");
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

		alInsertData.add(Item_Tech_Name_code);		
		alInsertData.add(Item_Tech_long_desc);
		alInsertData.add(Item_Tech_short_desc); 		
		alInsertData.add(Item_Tech_Remarks);
		alInsertData.add(Item_Tech_enabled);
		alInsertData.add(login_by_id);
		alInsertData.add(login_at_ws_no);
		alInsertData.add(login_facility_id); 
		alInsertData.add(login_by_id);
		alInsertData.add(login_at_ws_no);
		alInsertData.add(login_facility_id);
		
		alWhereData.add(Item_Tech_Name_code);
		alLanguageData.add(getLanguageId());

		hmTableData.put	( "properties",getProperties());
		hmTableData.put	( "InsertData",alInsertData);
		hmTableData.put	( "WhereData",alWhereData);
		hmTableData.put	( "LanguageData",alLanguageData);

		SingleTableHandlerRemote remote = null ;

		try {
			hmSQLMap.put	( "InsertSQL", "INSERT INTO MM_ITEM_TECH_NAME (ITEM_TECH_NAME_CODE,LONG_DESC,SHORT_DESC,REMARKS,EFF_STATUS,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES (?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?)");

			hmSQLMap.put	( "SelectSQL", "SELECT COUNT(*) COUNT FROM MM_ITEM_TECH_NAME WHERE ITEM_TECH_NAME_CODE = ?"); 

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
		
		alModifyData.add(Item_Tech_short_desc);				
		alModifyData.add(Item_Tech_long_desc);
		alModifyData.add(Item_Tech_Remarks);
		alModifyData.add(Item_Tech_enabled);
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id);
		alModifyData.add(Item_Tech_Name_code);
		
		alLanguageData.add(getLanguageId());

		hmTableData.put( "ModifyData",	alModifyData) ;
		hmTableData.put( "properties",	getProperties()) ;
		hmTableData.put( "LanguageData",alLanguageData);
		
		HashMap hmSQLMap = new HashMap() ;
		SingleTableHandlerRemote remote = null ;
		try
		{	
			hmSQLMap.put("ModifySQL", "UPDATE MM_ITEM_TECH_NAME SET SHORT_DESC=?,LONG_DESC=?,REMARKS=?,EFF_STATUS=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=? WHERE ITEM_TECH_NAME_CODE=?");

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
			pstmt = connection.prepareStatement("SELECT ITEM_TECH_NAME_CODE,LONG_DESC,SHORT_DESC,REMARKS,EFF_STATUS FROM  MM_ITEM_TECH_NAME_lang_vw WHERE ITEM_TECH_NAME_CODE = ? AND LANGUAGE_ID = ?");	  
			pstmt.setString( 1, Item_Tech_Name_code);
			pstmt.setString( 2, getLanguageId());

			resultSet = pstmt.executeQuery();

			if ((resultSet != null) && (resultSet.next())) {				
				setItemTechCode(checkForNull(resultSet.getString("ITEM_TECH_NAME_CODE")));
				setItemTechLongDesc(checkForNull(resultSet.getString("LONG_DESC")));
				setItemTechShortDesc(checkForNull(resultSet.getString("SHORT_DESC")));
				setItemTechRemarks(checkForNull(resultSet.getString("REMARKS")));
				setItemTechNameEnabled(checkForNull(resultSet.getString("EFF_STATUS")));		
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
	
	/*ADDED FOR ghl-crf-0548.1*/
    public Boolean getRecordCountForItemTechCode(String itemTechCode) {
    	String []stParameters=	{itemTechCode};
    		HashMap hmRecord	=	null;
    		try{
    			hmRecord	=	(HashMap)fetchRecord("select Count(*) from mm_item where ITEM_TECH_CODE= ? ", stParameters);
    		}catch(Exception e){
    			e.printStackTrace();
    			return true;
    		}
    		if(!((String)hmRecord.get("COUNT")).equals("0"))
    			return true;
    		else
    			return false;
    	}
}