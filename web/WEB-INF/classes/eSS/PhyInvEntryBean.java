/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Hashtable;

import java.util.HashMap;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import eSS.Common.SsAdapter;
import eCommon.Common.CommonRepository;
import eCommon.SingleTableHandler.*;
import eSS.PhyInvEntry.*;


public class PhyInvEntryBean extends eSS.Common.SsTransaction implements java.io.Serializable{
	
	private String facility_id = "";
	private String phy_inv_id = "";
	private String store_code = "";
	private String curr_store_code = "";
	private String tray_no = "";
	private String bin_location_code = "";
	private String count_sheet_date = null;
	private String temp_bin_location = "";
	private String selected_group_code = "";
	private String selected_bin_location_code = "";

	private java.util.ArrayList trayDetailsKey;
	private java.util.ArrayList selectedTrays;
	private java.util.ArrayList oldTrays;
	private java.util.Hashtable trayDetailsTable;

	public PhyInvEntryBean () {
		trayDetailsKey = new java.util.ArrayList();
		trayDetailsTable = new java.util.Hashtable();
		selectedTrays = new java.util.ArrayList();
	}

	public java.util.ArrayList getTrayDetailsKey() {
		return trayDetailsKey;
	}

	public java.util.Hashtable getTrayDetailsTable() {
		return trayDetailsTable;
	}

	public void clear() {
		facility_id = "";
		phy_inv_id = "";
		store_code = "";
		curr_store_code = "";
		tray_no = "";
		bin_location_code = "";
		trayDetailsKey.clear();
		if (oldTrays != null) {
			oldTrays.clear();
		}
		trayDetailsKey.clear();
		selectedTrays.clear();
		trayDetailsTable.clear();
	}

	public String getFacility_id() {
		return login_facility_id;
	}
	public String getPhy_inv_id() {
		return this.phy_inv_id;
	}

	public String getTemp_bin_location() {
		return this.temp_bin_location;
	}

	public String getStore_code() {
		return this.store_code;
	}
	public String getCurr_store_code() {
		return this.curr_store_code;
	}
	public String getTray_no() {
		return this.tray_no;
	}
	public String getBin_location_code() {
		return this.bin_location_code;
	}

	public void setTemp_bin_location(String temp_bin_location) {
		this.temp_bin_location = temp_bin_location;
	}

	public void setFacility_id (String facility_id) {
		this.facility_id = facility_id;
	}               

	public void setPhy_inv_id (String phy_inv_id) {
		this.phy_inv_id = phy_inv_id;
	}

	public void setStore_code (String store_code) {
		this.store_code = store_code;
	}

	public void setCurr_store_code(String curr_store_code) {
		this.curr_store_code = curr_store_code;
	}

	public void setTray_no	(String tray_no) {
		this.tray_no = tray_no;
	}

	public void setBin_location_code (String bin_location_code) {
		this.bin_location_code = bin_location_code;
	}

	public void setCount_sheet_date(String count_sheet_date) {
		this.count_sheet_date = count_sheet_date;
	}

	public void setSelected_group_code(String selected_group_code) {
		this.selected_group_code = selected_group_code;
	}
	
	public String getSelected_group_code() {
		return this.selected_group_code;
	}

	public String getCount_sheet_date() {
		isValidPhyInvID();
		return this.count_sheet_date;
	}

	public void setSelected_bin_location_code(String selected_bin_location_code) {
		this.selected_bin_location_code = selected_bin_location_code;
	}

	public String getSelected_bin_location_code() {
		return this.selected_bin_location_code;
	}

	public String getOwnerStores() {
		String sql = (String) getSsRepositoryValue("SQL_SS_STORE_PHY_INV_OWNER_SELECT_LIST");

		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
	
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,alParam);
		return getListOptionTag(alOptionValues,getStore_code());
	}

	public String getCurrentStores() {
		String sql = (String) getSsRepositoryValue("SQL_SS_STORE_CANCEL_COUNT_ALL_SELECT_LIST");

		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,alParam);
		return getListOptionTag(alOptionValues,getCurr_store_code());
	}

	public String getBinLocations() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alOptionValues = getListOptionArrayList(SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"));
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
	}

	 public ArrayList getBinLocationData (String store_code) throws Exception {
        ArrayList binLocationData = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
			this.store_code = store_code;
            connection = getConnection();
            pstmt = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"));
            pstmt.setString(1, store_code);
            resultSet = pstmt.executeQuery();

            while (resultSet != null && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                binLocationData.add(record);
            }
        } 
		catch (Exception e) {
            e.printStackTrace();
            throw e;
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return binLocationData;
    }
	
	public boolean isValidPhyInvID() {
		boolean validID = false;
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;	
		count_sheet_date = null;
		setFacility_id(login_facility_id);
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement((String) eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PHY_INV_PARAM_DATE_SELECT"));
		    pstmt.setString(1, facility_id);
		    pstmt.setString(2, phy_inv_id);
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				validID = true;
				setCount_sheet_date (resultSet.getString("count_sheet_date"));
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es){
				es.printStackTrace();
            }
		}
		return validID;
	}

	public boolean isValidPhyInvRecord() {
		boolean validRecord = false;
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;	
		int totalRecords = -1;
		try {
			setFacility_id(login_facility_id);
			connection = getConnection();
			pstmt = connection.prepareStatement((String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PHY_INV_GROUP_HDR_COUNT"));
		    pstmt.setString(1, facility_id);
		    pstmt.setString(2, phy_inv_id);
		    pstmt.setString(3, store_code);
		    pstmt.setString(4, curr_store_code);
		    //pstmt.setString(5, group_code);
			resultSet = pstmt.executeQuery();
			if (resultSet.next()) {
				totalRecords = resultSet.getInt(1);
			}
			if (totalRecords > 0) {
				validRecord = true;
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es){
				es.printStackTrace();
            }
		}
		return validRecord;
	}

	public boolean trayNoExists(String storeCode, String groupCode, String trayNo,String currentStoreCode,String phy_inv_id) {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		boolean hasTray = false;
		try {
			setTemp_bin_location("");
			connection = getConnection();
			preparedStatement = connection.prepareStatement((String)eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRAY_DTLS_TRAY_SELECT")); 
			preparedStatement.setString(1, login_facility_id);
			preparedStatement.setString(2, phy_inv_id);
			preparedStatement.setString(3, groupCode);
			preparedStatement.setString(4, trayNo);
			preparedStatement.setString(5, storeCode);
			preparedStatement.setString(6, currentStoreCode);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				hasTray = true;
				setTemp_bin_location (resultSet.getString(1));
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
		return hasTray;
	}

	public java.util.HashMap updateTrayDetails(java.util.Hashtable htUserData) {
		java.util.HashMap resultMap = new java.util.HashMap();
		boolean isEditing = false;
		resultMap.put("result",new Boolean(false));
		String trayDetail[] = new String[5];
		String tray_no  = (String) htUserData.get("tray_no");
		String editing_key = (String) htUserData.get("editing_key");
		
		if (editing_key != null && (trayDetailsTable.get(editing_key) != null)) {
			isEditing = true;
		}
		trayDetail[0] = tray_no;
		trayDetail[1] = (String) htUserData.get("bin_location_code");
		trayDetail[2] = (String) htUserData.get("bin_location_desc");
		trayDetail[3] = (String) htUserData.get("group_code");
		trayDetail[4] = (String) htUserData.get("group_desc");

		String refKey = trayDetail[3]+"-"+trayDetail[0];
		if ((!isEditing) && trayDetailsKey.contains(refKey)) {
			resultMap.put("msgid","RECORD_ALREADY_EXISTS");
			resultMap.put("message","Cannot duplicate instrument");
			return resultMap;
		}
		else {
			if (!isEditing) {
				trayDetailsKey.add(refKey);
			}
			trayDetailsTable.put(refKey,trayDetail);
			resultMap.put("result",new Boolean(true));
			resultMap.put("msgid","");
			resultMap.put("message","");
		}
		return resultMap;
	}
	
	public java.util.HashMap modify() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		Properties properties = getProperties();
		
		ArrayList alDTLUpdateData = new java.util.ArrayList();
		ArrayList alDTLUpdateRecord = null;
		ArrayList alDTLDeleteData = new java.util.ArrayList();
		ArrayList alDTLDeleteRecord = null;
		hmTableData.put("properties",properties );
		hmResult.put("result", new Boolean(false)) ;

		try {
			String key = null;
			if (oldTrays != null) {
				for (int index=0;index < oldTrays.size();index++) {
					key = (String)oldTrays.get(index);
					if (selectedTrays.contains(key)) {
						//update
						alDTLUpdateRecord = new ArrayList ();
						String[] tempRecord = (String[]) trayDetailsTable.get(key);
						alDTLUpdateRecord.add(tempRecord[1]); // bin Location
						alDTLUpdateRecord.add(login_by_id);
						alDTLUpdateRecord.add(login_at_ws_no);
						alDTLUpdateRecord.add(login_facility_id);
						alDTLUpdateRecord.add(getFacility_id());
						alDTLUpdateRecord.add(getPhy_inv_id());
						alDTLUpdateRecord.add(getStore_code());
						alDTLUpdateRecord.add(getCurr_store_code());
						alDTLUpdateRecord.add(tempRecord[3]); // Group Code
						alDTLUpdateRecord.add(tempRecord[0]); //Tray No
						alDTLUpdateData.add(alDTLUpdateRecord);
						selectedTrays.remove(key);
					}
					else {
						//delete
						alDTLDeleteRecord = new ArrayList();
						String[] tempRecord = (String[]) trayDetailsTable.get(key);
						alDTLDeleteRecord.add(getFacility_id());
						alDTLDeleteRecord.add(getPhy_inv_id());
						alDTLDeleteRecord.add(getStore_code());
						alDTLDeleteRecord.add(getCurr_store_code());
						alDTLDeleteRecord.add(tempRecord[3]); // group code
						alDTLDeleteRecord.add(tempRecord[0]); //Tray No
						alDTLDeleteData.add(alDTLDeleteRecord);
					}
				}
			}

			if (alDTLDeleteData.size()>0) {
				hmSQLMap.put("DeleteDTLSQL", SsRepository.getSsKeyValue("SQL_SS_PHY_INV_GROUP_DTL_ITEM_DELETE"));
				hmTableData.put("DeleteDTLData", alDTLDeleteData);
			}
			if (alDTLUpdateData.size()>0) {
				hmSQLMap.put("UpdateDTLSQL", SsRepository.getSsKeyValue("SQL_SS_PHY_INV_GROUP_DTL_UPDATE"));
				hmTableData.put("UpdateDTLData", alDTLUpdateData);
			}
			
			ArrayList alDTLInsertData = new java.util.ArrayList();
			ArrayList alDTLInsertRecord = null;
			for (int arrayIndex=0;arrayIndex<selectedTrays.size();arrayIndex++) {
				alDTLInsertRecord = new java.util.ArrayList();
				String hashKey = (String) selectedTrays.get(arrayIndex);
				String[] tempRecord = (String[]) trayDetailsTable.get(hashKey);
				alDTLInsertRecord.add(getFacility_id());
				alDTLInsertRecord.add(getPhy_inv_id());
				alDTLInsertRecord.add(getStore_code());
				alDTLInsertRecord.add(getCurr_store_code());
				alDTLInsertRecord.add(tempRecord[3]);
				alDTLInsertRecord.add(tempRecord[0]); //Tray No
				alDTLInsertRecord.add(tempRecord[1]); // bin Location
				alDTLInsertRecord.add(login_by_id);
				alDTLInsertRecord.add(login_at_ws_no);
				alDTLInsertRecord.add(login_facility_id);
				alDTLInsertRecord.add(login_by_id);
				alDTLInsertRecord.add(login_at_ws_no);
				alDTLInsertRecord.add(login_facility_id);
				alDTLInsertData.add(alDTLInsertRecord);
			}
			hmSQLMap.put("InsertDTLSQL", SsRepository.getSsKeyValue("SQL_SS_PHY_INV_GROUP_DTL_INSERT"));
			hmTableData.put("InsertDTLData", alDTLInsertData);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome( SsRepository.getSsKeyValue("JNDI_SS_PHY_INV_ENTRY"),PhyInvEntryHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
				  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) hmResult.get("result")).booleanValue() )	
		
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else if( hmResult.get("msgid")!=null  )
			
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;


		} 
		catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		finally {
			try {
			//	if(phyInvEntryRemote != null)
			//		phyInvEntryRemote.remove();
			}
			catch(Exception ee) {
				
				hmResult.put("message", ee.toString());
			}
		}
		trayDetailsKey.clear();
		trayDetailsTable.clear();
		selectedTrays.clear();
		oldTrays.clear();
		loadData();
		return hmResult;
	}

	public HashMap delete() {
        HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	 alDeleteHDRData = new ArrayList();
		Properties properties = getProperties();

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Delete Mode") ;
		
		alDeleteHDRData.add(getFacility_id());            
		alDeleteHDRData.add(getPhy_inv_id());          
		alDeleteHDRData.add(getStore_code());         
		alDeleteHDRData.add(getCurr_store_code());

		hmTableData.put("properties",properties);
		hmTableData.put("DeleteHDRData",alDeleteHDRData);
		hmSQLMap.put("DeleteHDRSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PHY_INV_GROUP_HDR_DELETE"));
		if (selectedTrays.size() > 0) {
			hmTableData.put("DeleteDTLData",alDeleteHDRData);
			hmSQLMap.put("DeleteDTLSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PHY_INV_GROUP_DTL_DELETE"));
		}
		PhyInvEntryRemote phyInvEntryRemote = null ;
		try {
			Object home =com.ehis.eslp.ServiceLocator.getInstance().getHome( SsRepository.getSsKeyValue("JNDI_SS_PHY_INV_ENTRY"),PhyInvEntryHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

			  (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
		
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else if( hmResult.get("msgid")!=null  )
			
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;


			hmResult.put("flag", "") ;
		}
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(phyInvEntryRemote != null)
					phyInvEntryRemote.remove() ;
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString()) ;
			}
		}	
		return hmResult	;
    }

	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		hmReturn.put(RESULT,TRUE);
		return hmReturn;
	}

	public void updateSelectedTrays(java.util.Hashtable hash) {
		for (int index=0;index<hash.size();index++) {
			selectedTrays.add(hash.get("selected_tray_"+index));
		}
	}

	public void setAll(java.util.Hashtable hashtable) {
		setLanguageId((String) hashtable.get("locale"));

	}

	public void loadData() {
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		oldTrays = new java.util.ArrayList();
        try {
			setFacility_id(login_facility_id);
            connection = getConnection();
            pstmt = connection.prepareStatement(SsRepository.getSsKeyValue("SQL_SS_PHY_INV_GROUP_DTL_SELECT_MULTIPLE"));
            pstmt.setString(1, getFacility_id());
            pstmt.setString(2, getPhy_inv_id());
            pstmt.setString(3, getStore_code());
            pstmt.setString(4, getCurr_store_code());
            resultSet = pstmt.executeQuery();

            while (resultSet != null && resultSet.next()) {
                String[] record = new String[5];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                record[2] = resultSet.getString(3);
                record[3] = resultSet.getString("group_code");
                record[4] = resultSet.getString("group_desc");
				trayDetailsKey.add(record[3]+"-"+record[0]);
				oldTrays.add(record[3]+"-"+record[0]);
				trayDetailsTable.put(record[3]+"-"+record[0],record);
            }
        } 
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
	}

	public String getBinLocationsForStore() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();

		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getStore_code());
		alParam.add(getLanguageId());

		alOptionValues = getListOptionArrayList(SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),alParam);
		optionValues = getListOptionTag(alOptionValues,selected_bin_location_code);
		alOptionValues = null;
		selected_bin_location_code = "";
		return optionValues;
	}

	public String getGroups() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		String sql = SsRepository.getSsKeyValue("SQL_SS_PHY_INV_GROUP_HDR_GROUP_SELECT_LIST");
		java.util.ArrayList alOptionParameters = new java.util.ArrayList();
		alOptionParameters.add(getFacility_id());
		alOptionParameters.add(getPhy_inv_id());
		alOptionParameters.add(getStore_code());
		alOptionParameters.add(getCurr_store_code());
		alOptionParameters.add(getLanguageId());
		alOptionValues = getListOptionArrayList(sql,alOptionParameters);
		optionValues = getListOptionTag(alOptionValues,getSelected_group_code());
		setSelected_group_code("");
		alOptionValues = null;
		return optionValues;
	}
}
