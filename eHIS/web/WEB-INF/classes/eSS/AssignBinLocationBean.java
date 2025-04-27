/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
* Java Bean for Assign Bin Location
*/
package eSS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Hashtable;
import java.util.HashMap;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import eSS.Common.*;
import eSS.AssignBinLocation.AssignBinLocationHome;
import eSS.AssignBinLocation.AssignBinLocationRemote;


public class AssignBinLocationBean extends eSS.Common.SsTransaction implements java.io.Serializable {

	// Table Column Variables 
	private String doc_ref;
	private String trn_type;
	private String prepare_qty;
	private String store_code;
	private String group_code;
	private String total_cost;
	private String doc_type_code;
	private String doc_date;
	private String doc_no;
	private String bin_location_code;
	private String facility_id;
	private String tray_no;
	private String finalized_yn;
	private boolean isAutoNo;
	private String selected_bin_location_code;
	private String defaultStoreCode;
	private String defaultDocType;


	private ArrayList trayDetails;

	/* For Selected Values Values ! */
	private String selectedDocType = "";
	private String selectedStoreCode = "";
	private String selectedGroupCode = "";
	
	public ArrayList getTrayDetails() {
		return this.trayDetails;
	}

	public AssignBinLocationBean() {
		trayDetails = new java.util.ArrayList();
	}

	public void addTrayDetails(String trayNo) {
		String trayValue[] = {"Y",trayNo,null,null};

		trayDetails.add(trayValue);
		

	}

	public void setSelectedDocType (String selectedDocType) {
		this.selectedDocType  = selectedDocType;
	}

	public String getSelectedDocType () {
		return this.selectedDocType;
	}

	public void setSelectedStoreCode (String selectedStoreCode) {
		this.selectedStoreCode = selectedStoreCode;
	}

	public String getSelectedStoreCode() {
		return this.selectedStoreCode;
	}

	public void setSelectedGroupCode (String selectedGroupCode) {
		this.selectedGroupCode = selectedGroupCode;
	}

	public String getSelectedGroupCode() {
		return this.selectedGroupCode;
	}

	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}

	public boolean getIsAutoNo() {
		return this.isAutoNo;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = doc_ref;
	}

	public String getDoc_ref() {
		 return doc_ref;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no = tray_no;
	}

	public String getTray_no() {
		 return tray_no;
	}

	public void setTrn_type(String trn_type) {
		 this.trn_type = trn_type;
	}

	public String getTrn_type() {
		 return trn_type;
	}

	public void setPrepare_qty(String prepare_qty) {
		 this.prepare_qty = prepare_qty;
	}

	public String getPrepare_qty() {
		 return prepare_qty;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code() {
		 return store_code;
	}

	public void setGroup_code(String group_code) {
		 this.group_code = group_code;
	}

	public String getGroup_code() {
		 return group_code;
	}

	public void setTotal_cost(String total_cost) {
		 this.total_cost = total_cost;
	}

	public String getTotal_cost() {
		 return total_cost;
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}

	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public String getDoc_date() {
		try {
			if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
				return getSystemDate();
			}
			else {
				return doc_date;
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return exception.toString();
		}
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no() {
		 return doc_no;
	}

	public void setBin_location_code(String bin_location_code) {
		 this.bin_location_code = bin_location_code;
	}

	public String getBin_location_code() {
		 return bin_location_code;
	}

	public void setFacility_id(String facility_id) {
		 this.facility_id = facility_id;
	}

	public String getFacility_id() {
		 return facility_id;
	}

	public void setFinalized_yn(String finalized_yn) {
		this.finalized_yn = finalized_yn;
	}

	public String getFinalized_yn() {
		return this.finalized_yn;
	}

	public void setSelected_bin_location_code(String selected_bin_location_code) {
		this.selected_bin_location_code = selected_bin_location_code;
	}

	public String getSelected_bin_location_code () {
		return this.selected_bin_location_code;
	}

	public void setDefaultStoreCode (String defaultStoreCode) {
		this.defaultStoreCode = defaultStoreCode;
	}

	public String getDefaultStoreCode() {
		return this.defaultStoreCode;
	}
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType  = defaultDocType;
	}

	public String getDefaultDocType() {
		return this.defaultDocType;
	}
	

	public void clear(){
		super.clear();
		doc_ref="";          
		trn_type="";         
		prepare_qty="";      
		store_code="";       
		group_code="";       
		total_cost="";       
		doc_type_code="";      
		doc_no="";           
		bin_location_code="";
		facility_id="";      
		tray_no="";          
		finalized_yn="";     
	}

	public void setAll(Hashtable htRecordSet) {
		
		int totalTrayNos = Integer.parseInt((String)htRecordSet.get("total_checkboxes"));
		if (totalTrayNos > 0) {
			String trayInfo[] = null;
			for (int index=0; index<totalTrayNos;index++ ) {
				if ((((String)htRecordSet.get("tray_id_"+index)).equals("on"))) {
					trayInfo = (String[])trayDetails.get(index);
					trayInfo[0] = "X";
					trayInfo[2] = ((String)htRecordSet.get("bin_location_"+index));
					
				}
			}
		}
	}

	
public String getDocTypes(String doc_type_code) {
		String optionValues = null;
		//Get the selected Document Type Code for the given Document Type
		java.util.ArrayList alPrepareGroupDoc = new java.util.ArrayList(5);
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alPrepareGroupDoc.add(login_facility_id);
		alPrepareGroupDoc.add("PRE");
		alPrepareGroupDoc.add(getLanguageId());
		//Changed from SQL_SS_PREPARE_GROUP_DOC_TYPE - 1/16/2003
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRN_DOC_TYPE_SELECT_LIST"), alPrepareGroupDoc);

		optionValues = getListOptionTag(alOptionValues,getDefaultDocType());
		alPrepareGroupDoc = null;
		alOptionValues = null;
		return optionValues;
	}
	
		
		public String getStores(String store_code) {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		// Changed from SQL_SS_PREPARE_GROUP_STORE
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_PRE_SELECT_LIST"), alParam);
		optionValues = getListOptionTag(alOptionValues,getDefaultStoreCode());
		alOptionValues = null;
		
		return optionValues;
		}
	public String getGroupName() {
		try {
			java.util.HashMap groupName = fetchRecord(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_SELECT_LIST_SINGLE"), getGroup_code());
			return (String)groupName.get("SHORT_DESC");
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

public String getBinLocations(String default_store_code) {
	
	   java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(default_store_code);
		alParam.add(getLanguageId());

		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alOptionValues = getListOptionArrayList(SsRepository.getSsKeyValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),alParam);
		optionValues = getListOptionTag(alOptionValues,selected_bin_location_code);
		alOptionValues = null;
		return optionValues;
	}


    public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "" ) ;
        return map ;
    }

	public void loadData() {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		try {
			connection = getConnection();

			// To load the Header Information 
			preparedStatement = connection.prepareStatement(getSsRepositoryValue("SQL_SS_ASSIGN_BIN_LOCATION_SELECT_SINGLE")); 
			preparedStatement.setString(1, getLoginFacilityId());
			preparedStatement.setString(2, getDoc_type_code());
			preparedStatement.setInt(3, Integer.parseInt(getDoc_no()));

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				setDoc_date(resultSet.getString("doc_date"));
				setDoc_ref(resultSet.getString("doc_ref"));
				setStore_code(resultSet.getString("store_code"));
				setPrepare_qty(""+resultSet.getInt("prepare_qty"));
				setGroup_code(resultSet.getString("group_code"));
				setTotal_cost(""+resultSet.getInt("total_cost"));
			
			}
			preparedStatement = null;
			resultSet = null;
			//To load the Tray Detail Info
			trayDetails.clear();
			preparedStatement = connection.prepareStatement(getSsRepositoryValue("SQL_SS_ASSIGN_BIN_LOCATION_SELECT_MULTIPLE")); 
			preparedStatement.setString(1, getLoginFacilityId());
			preparedStatement.setString(2, getDoc_type_code());
			preparedStatement.setInt(3, Integer.parseInt(getDoc_no()));
	
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				addTrayDetails(String.valueOf(resultSet.getInt("tray_no")));				
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

	public String toString() {
		return "	doc_ref = "+ doc_ref + 
		"	trn_type = "+ trn_type+ 
		"	prepare_qty = "+ prepare_qty+
		"	store_code = "+ store_code+
		"	group_code = "+ group_code+
		"	total_cost = "+ total_cost+
		"	doc_type_code = "+ doc_type_code+
		"	doc_date = "+ doc_date+
		"	doc_no = "+ doc_no+
		"	bin_location_code = "+ bin_location_code+
		"	finalized_yn  = "+ finalized_yn+
		"	facility_id = "+ facility_id+
		"	tray_no = "+ tray_no+
		"	isAutoNo = "+ isAutoNo+
		"	mode = "+mode;
	}

	public void updateTrayDetail(String[] trayDetailArray) {
		
		setSelected_bin_location_code(trayDetailArray[2]);
		
		trayDetails.add(trayDetailArray[0]);
		trayDetails.add(trayDetailArray[1]);
		trayDetails.add(trayDetailArray[2]);
		ArrayList tempTrayDetail=new ArrayList();
		tempTrayDetail.add(trayDetailArray[0]);
		tempTrayDetail.add(trayDetailArray[1]);
		tempTrayDetail.add(trayDetailArray[2]);
		
		tempTrayDetail.add("U");
		tempTrayDetail.add(trayDetailArray[1]);
		tempTrayDetail.add(trayDetailArray[2]);
		
		
	}

	public java.util.ArrayList getUpdateRecord(String[] currentUpdateRecord) {
		java.util.ArrayList tempModifyRecord = new java.util.ArrayList();
		tempModifyRecord.add(currentUpdateRecord[2]);
		tempModifyRecord.add(login_by_id);
		tempModifyRecord.add(login_at_ws_no);
		tempModifyRecord.add(login_facility_id);
		tempModifyRecord.add(getLoginFacilityId());
		tempModifyRecord.add(getDoc_type_code());
		tempModifyRecord.add(new Integer(getDoc_no()));
		tempModifyRecord.add(new Integer(currentUpdateRecord[1]));
		return tempModifyRecord;
	}

	public HashMap modify() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap	hmSQLMap	= new HashMap();
		ArrayList	alModifyData = new ArrayList();
		ArrayList	alModifyRecord = null;
		Properties properties = getProperties();
        
		
		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Initial Message") ;
		for (int index=0;index<trayDetails.size();index++) {
			String[] currentUpdateRecord = (String[]) trayDetails.get(index);
			
			
			if (currentUpdateRecord[0].equals("X") && currentUpdateRecord[2]!=null) {
				alModifyRecord = getUpdateRecord(currentUpdateRecord);
				
				alModifyData.add(alModifyRecord);
			}
		}
        
		

		hmTableData.put("properties",properties);
		hmTableData.put("UpdateData",alModifyData);
		hmSQLMap.put("UpdateSQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_DTL_UPDATE"));

		try {
		
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eSS.Common.SsRepository.getSsKeyValue("JNDI_SS_ASSIGN_BIN_LOCATION"),AssignBinLocationHome.class,getLocalEJB());
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			
		} 
		catch(Exception e) {
			hmResult.put("message", e.toString()) ;
			e.printStackTrace() ;
		} 
		
		return hmResult;
	}
}
