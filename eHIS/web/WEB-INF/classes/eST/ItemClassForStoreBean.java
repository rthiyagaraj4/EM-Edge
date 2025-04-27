/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import eCommon.SingleTableHandler.*;
//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
import eST.Common.StRepository;
import eCommon.Common.CommonRepository;
import eST.Common.StAdapter;


public class ItemClassForStoreBean extends StAdapter implements Serializable {

	String store_code;
	//String language_id;
	String[] item_class_code;
	java.util.ArrayList itemClasses;
	java.util.ArrayList selectedItemClasses;

	public ItemClassForStoreBean() {
		selectedItemClasses = new java.util.ArrayList();
	}

	public void setStore_code(String store_code) {
		this.store_code = store_code;
	}

	public String getStore_code() {
		return this.store_code;
	}

/*	public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}

	public String getLanguageId() 
	{
		return this.language_id;
	}*/

	public String getStores() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		//java.util.ArrayList alParam = new java.util.ArrayList();
	//	alParam.add(login_facility_id);
	ArrayList alParameters=new ArrayList();
		alParameters.add(login_facility_id);
		//alParameters.add(trn_type);
		alParameters.add(getLanguageId());
	//	String chkParameters[] ={login_facility_id,getLanguageId()};
		alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST_WT_LANG"), alParameters);
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
	}	

	public java.util.ArrayList getItemClasses() {
		return this.itemClasses;
	}

	public void loadItemClass() {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		try {
			itemClasses = new java.util.ArrayList();
			connection = getConnection();
			preparedStatement = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_EXIST_SELECT")); 
			preparedStatement.setString(1, getStore_code());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				itemClasses.add(resultSet.getString("item_class_code"));
			}
		} 
		catch (Exception e )	{
			e.printStackTrace();
			} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
	}

	public void updateSelectedItemClass(Hashtable htItemClass) {
		ArrayList  removeList = new java.util.ArrayList(12);
		String keyName = "";
		java.util.Enumeration enumKeyItemClass = htItemClass.keys();
		while (enumKeyItemClass.hasMoreElements()) {
			keyName = (String)enumKeyItemClass.nextElement();
			if (keyName.startsWith("remove_item_class_") ||keyName.startsWith("PreviousListValueExit") ) {
				removeList.add(htItemClass.get(keyName));
				htItemClass.remove(keyName);
			}
		}
		selectedItemClasses.removeAll(removeList);
		keyName = null;
		removeList = null;
		enumKeyItemClass = null;
		String value = "";
		java.util.Enumeration enumItemClass = htItemClass.elements();

		while (enumItemClass.hasMoreElements()) {
			value = (String) enumItemClass.nextElement();
	
			if (value != null || value.trim().length()>0) 
				selectedItemClasses.add(value);

		}
		enumItemClass = null;
	}

	public java.util.ArrayList getSelectedItemClass() {
		return selectedItemClasses;
	}

	public void clear() {
		if (selectedItemClasses!= null) {
			selectedItemClasses.clear();
		}
	}

	public int hasRecords() {
		if (selectedItemClasses != null) {
			return selectedItemClasses.size();
		}
		return -1;
	}

	public java.util.HashMap insert() {

		HashMap hmResult = new HashMap()	;
		HashMap hmTableData = new HashMap()	;
		HashMap hmSQLMap = new HashMap()	;
		ArrayList alInsertData = new ArrayList()	;
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
		hmResult.put("result", new Boolean(false));
		for (int index=0;index<selectedItemClasses.size();index++) {
			if((selectedItemClasses.get(index) == null) || (selectedItemClasses.get(index).equals(""))) 
					continue;
			ArrayList alInsertRecord = new ArrayList();
			alInsertRecord.add(getStore_code());
			alInsertRecord.add(selectedItemClasses.get(index));
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertData.add(alInsertRecord);
		}
		hmSQLMap.put("InsertSQL", StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_STORE_INSERT")); 
		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertData",alInsertData);
			hmTableData.put("LanguageData",LanguageData);

//SingleTableHandlerHome singleTableHandlerHome = null;
		SingleTableHandlerRemote singleTableHandlerRemote	= null;
		try {
			/*InitialContext context = new InitialContext();
			Object object = context.lookup(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));
			
			singleTableHandlerHome  = (SingleTableHandlerHome) PortableRemoteObject.narrow(object, SingleTableHandlerHome.class);
			singleTableHandlerRemote = singleTableHandlerHome.create();

			hmResult = singleTableHandlerRemote.singleBatchHandler(hmTableData, hmSQLMap);*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
	
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get( "result" )).booleanValue() )
				hmResult.put( "message",  getSTMessage(getLanguageId(),(String) hmResult.get("msgid" ),"ST") ) ;
			else{
				if( ((String)hmResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getSTMessage(getLanguageId(),(String) hmResult.get(" msgid" ),"Common")  ;
					msgID = msgID.substring(0,(msgID.indexOf("<br>")));
					hmResult.put( "message", msgID  );
					hmResult.put( "invalidCode", delimitedString( (ArrayList)hmResult.get("invalidCode")) );
						//(map.get("invalidCode"))  );
				} 
				else{
					hmResult.put( "message", (hmResult.get("msgid")));
				}
			}

			/*
			if(((Boolean) hmResult.get("result")).booleanValue())
				hmResult.put("message", getMessage((String) hmResult.get("msgid")));
			else{
				if(((String) hmResult.get("msgid")).equals("CODE_ALREADY_EXISTS"))
					hmResult.put("message", getMessage((String) hmResult.get("msgid")));
				else
					hmResult.put("message", (hmResult.get("msgid")));
			}
			*/
		} 
		catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		finally {
			try {
				if(singleTableHandlerRemote != null)
					singleTableHandlerRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString());
			}
		}
		return hmResult;
	}

	public HashMap validate() {
		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");
		return resultMap;
	}

	public void setAll(Hashtable hashValues) {
		hashValues.remove("mode");
		hashValues.remove("user_id");
		hashValues.remove("canProcess");
		hashValues.remove("total_item_class");
		this.updateSelectedItemClass(hashValues);
	}
}
