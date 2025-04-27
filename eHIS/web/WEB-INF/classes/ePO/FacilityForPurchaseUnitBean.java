/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import eCommon.SingleTableHandler.*;
import ePO.Common.PoRepository;
import eCommon.Common.CommonRepository;
import ePO.Common.PoAdapter;


public class FacilityForPurchaseUnitBean extends PoAdapter implements Serializable {	
	
	private String pur_unit_id ;
	String[] facility_id;
	java.util.ArrayList facilityId;
	java.util.ArrayList selectedFacilityId;
	
	public void setPur_unit_id( String pur_unit_id) {
			this.pur_unit_id		=	pur_unit_id;
	}
		
	public String getPur_unit_id() {
		return this.pur_unit_id;
	}
	
	public FacilityForPurchaseUnitBean() {
		selectedFacilityId = new java.util.ArrayList();
	}
	
	public java.util.ArrayList getFacilityId() {
		return this.facilityId;
	}
	
	public void loadFacilityId() {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		try {
			facilityId = new java.util.ArrayList();
			connection = getConnection();
			preparedStatement = connection.prepareStatement(ePO.Common.PoRepository.getPoKeyValue("SQL_PO_FACILITY_PURCHASE_UNIT_EXIST_SELECT")); 
			preparedStatement.setString(1, getPur_unit_id());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				facilityId.add(resultSet.getString("facility_id"));
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
	
	public java.util.ArrayList getSelectedFacilityId() {
		return selectedFacilityId;
	}
	
	public void updateSelectedFacilityId(Hashtable htItemClass) {
		ArrayList  removeList = new java.util.ArrayList(12);
		String keyName = "";
		java.util.Enumeration enumKeyItemClass = htItemClass.keys();
		while (enumKeyItemClass.hasMoreElements()) {
			keyName = (String)enumKeyItemClass.nextElement();
			if (keyName.startsWith("remove_facility_id_") ||keyName.startsWith("PreviousListValueExit") ) {
				removeList.add(htItemClass.get(keyName));
				htItemClass.remove(keyName);
			}
		}
		selectedFacilityId.removeAll(removeList);
		keyName = null;
		removeList = null;
		enumKeyItemClass = null;
		String value = "";
		java.util.Enumeration enumItemClass = htItemClass.elements();

		while (enumItemClass.hasMoreElements()) {
			value = (String) enumItemClass.nextElement();
	
			if (value != null || value.trim().length()>0) 
				selectedFacilityId.add(value);

		}
		enumItemClass = null;
	}
	
	public void setAll(Hashtable hashValues) {
		hashValues.remove("mode");
		hashValues.remove("user_id");
		hashValues.remove("canProcess");
		hashValues.remove("total_facility_id");
		this.updateSelectedFacilityId(hashValues);
	}
	
	public void clear() {
		if (selectedFacilityId!= null) {
			selectedFacilityId.clear();
		}
	}

	public int hasRecords() {
		if (selectedFacilityId != null) {
			return selectedFacilityId.size();
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
		for (int index=0;index<selectedFacilityId.size();index++) {
			if((selectedFacilityId.get(index) == null) || (selectedFacilityId.get(index).equals(""))) 
					continue;
			ArrayList alInsertRecord = new ArrayList();
			alInsertRecord.add(getPur_unit_id());
			alInsertRecord.add(selectedFacilityId.get(index));
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertRecord.add(login_by_id);
			alInsertRecord.add(login_at_ws_no);
			alInsertRecord.add(login_facility_id);
			alInsertData.add(alInsertRecord);
		}
		hmSQLMap.put("InsertSQL", PoRepository.getPoKeyValue("SQL_PO_FACILITY_PURCHASE_UNIT_INSERT")); 
		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertData",alInsertData);
			hmTableData.put("LanguageData",LanguageData);

		SingleTableHandlerRemote singleTableHandlerRemote	= null;
		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;
			System.out.println(" hmTableData in fcy pu bean = "+hmTableData);
			System.out.println(" hmSQLMap in fcy pu bean = "+hmSQLMap);
			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
	
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get( "result" )).booleanValue() )
				hmResult.put( "message",  getPOMessage(getLanguageId(),(String) hmResult.get("msgid" ),"PO") ) ;
			else{
				if( ((String)hmResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getPOMessage(getLanguageId(),(String) hmResult.get(" msgid" ),"PO")  ;
					msgID = msgID.substring(0,(msgID.indexOf("<br>")));
					hmResult.put( "message", msgID  );
					hmResult.put( "invalidCode", delimitedString( (ArrayList)hmResult.get("invalidCode")) );
						
				} 
				else{
					hmResult.put( "message", (hmResult.get("msgid")));
				}
			}

		
		} 
		catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		finally {
			try {
				if(singleTableHandlerRemote != null){}
				//	singleTableHandlerRemote.remove();
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
}
