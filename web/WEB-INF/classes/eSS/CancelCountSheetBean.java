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
import eSS.Common.*;

public class CancelCountSheetBean extends eSS.Common.SsTransaction implements java.io.Serializable{
	private String facility_id = "";
	private String phy_inv_id = "";
	private String store_code = "";
	private String curr_store_code = "";

	private java.util.ArrayList countSheetRecord;
	private java.util.Hashtable countSheetTable;
	private java.util.ArrayList oldTrays;
	int[] insertDetailIndex;

	private java.util.ArrayList selectedGroups;

	public CancelCountSheetBean () {
		countSheetRecord = new java.util.ArrayList();
		countSheetTable = new java.util.Hashtable();
		selectedGroups = new java.util.ArrayList();
	}

	public java.util.ArrayList getPhyInvDeleteRecord() {
		return countSheetRecord;
	}

	public java.util.Hashtable getTrayDetailsTable() {
		return countSheetTable;
	}

	public void clear() {
		facility_id = "";
		phy_inv_id = "";
		store_code = "";
		curr_store_code = "";
		countSheetRecord.clear();
		if (oldTrays != null) {
			oldTrays.clear();
		}
		countSheetTable.clear();
		selectedGroups.clear();
	}

	public String getFacility_id() {
		return login_facility_id;
	}
	public String getPhy_inv_id() {
		return this.phy_inv_id;
	}

	public String getStore_code() {
		return this.store_code;
	}
	public String getCurr_store_code() {
		return this.curr_store_code;
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

	public String getOwnerStores() {
		String sql = (String) getSsRepositoryValue("SQL_SS_STORE_CANCEL_COUNT_OWNER_SELECT_LIST");
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
	
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,alParam);
		return getListOptionTag(alOptionValues,getStore_code());
	}

	public String getPhyInvIds() {
		String sql = (String) getSsRepositoryValue("SQL_SS_PHY_INV_PARAM_SELECT_LIST");
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,login_facility_id);
		return getListOptionTag(alOptionValues);
	}

	public String getCurrentStores() {
		String sql = (String) getSsRepositoryValue("SQL_SS_STORE_CANCEL_COUNT_ALL_SELECT_LIST");

		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
		java.util.ArrayList alOptionValues = getListOptionArrayList(sql,alParam);
		return getListOptionTag(alOptionValues,getCurr_store_code());
	}
public void setAll(Hashtable htRecordSet){
	setLanguageId((String) htRecordSet.get("locale"));
		
	}
	public void updateSelectedValues(java.util.Hashtable hashValues) {
		String key = null;
		String phy_inv_id = null;
		String owner_store_code = null;
		String current_store_code = null;
		String group_code = null;
		java.util.ArrayList checkedList = new java.util.ArrayList ();
		java.util.ArrayList uncheckedList = new java.util.ArrayList ();
		int checked_values = Integer.parseInt((String) hashValues.get("checked_values"));
		int unchecked_values = Integer.parseInt((String) hashValues.get("unchecked_values"));

		String selectedIndices = (String) hashValues.get("selectedIndices");
		java.util.StringTokenizer strTokens = new java.util.StringTokenizer(selectedIndices,",");
		insertDetailIndex = new int[strTokens.countTokens()];
		int count = 0;
		while (strTokens.hasMoreElements()) {
			insertDetailIndex[count++] = Integer.parseInt(strTokens.nextToken());
		}

		for (int chkd_idx=0;chkd_idx<checked_values;chkd_idx++) {
			checkedList.add(hashValues.get("checked_tray_"+chkd_idx));
		}
		for (int unchkd_idx=0;unchkd_idx<unchecked_values;unchkd_idx++) {
			uncheckedList.add(hashValues.get("unchecked_tray_"+unchkd_idx));
		}
		selectedGroups.removeAll(uncheckedList);
		selectedGroups.addAll(checkedList);
		for (int cnt=0;cnt<uncheckedList.size();cnt++) {
			key = (String)uncheckedList.get(cnt);
			if (countSheetTable.containsKey(key))
				countSheetTable.remove(key);
		}

		for (int selectCount=0;selectCount<insertDetailIndex.length;selectCount++) {
			java.util.ArrayList phyInvRecord = new ArrayList();
			phy_inv_id = (String) hashValues.get("phy_inv_id");
			owner_store_code = (String) hashValues.get("owner_store_code_"+insertDetailIndex[selectCount]);
			current_store_code = (String) hashValues.get("current_store_code_"+insertDetailIndex[selectCount]);
			group_code = (String) hashValues.get("group_code_"+insertDetailIndex[selectCount]);
			phyInvRecord.add(login_facility_id);
			phyInvRecord.add(phy_inv_id);
			phyInvRecord.add(owner_store_code);
			phyInvRecord.add(current_store_code);
			phyInvRecord.add(group_code);
			countSheetRecord.add(phyInvRecord);
			key = phy_inv_id+"-"+owner_store_code+"-"+current_store_code+"-"+group_code;
			countSheetTable.put(key,phyInvRecord);
		}
		return;
	}
	
	public HashMap modify() {
        HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	 alDeleteHDRData = new ArrayList();
		Properties properties = getProperties();
try{
		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Delete Mode") ;
		
		for (int i=0;i<countSheetTable.size();i++) {
			alDeleteHDRData.add(countSheetTable.get(selectedGroups.get(i)));
		}

		hmTableData.put("properties",properties);
		hmTableData.put("InsertData",alDeleteHDRData);
		hmSQLMap.put("InsertSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PHY_INV_GROUP_HDR_DELETE"));

		hmResult = singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT_BATCH);

		}
		catch(Exception e) {
			
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		return hmResult;
   
	}

	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		hmReturn.put(RESULT,TRUE);
		return hmReturn;
	}

}
