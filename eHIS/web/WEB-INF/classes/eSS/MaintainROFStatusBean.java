/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

import java.util.*;
import java.io.*;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import eSS.Common.SsAdapter;
import eCommon.SingleTableHandler.*;


public class MaintainROFStatusBean extends eSS.Common.SsTransaction implements Serializable { 

	private String defaultDocType = "";
	private String doc_type_code;
	private String doc_ref;
	private String store_code;
	private String store_desc;
	private String doc_date;
	private String doc_no;
	private String process_stage_code;
	private String process_stage_desc;
	private String process_remarks;
	private String facility_id;
	

	public void setDefaultDocType (String defaultDocType) {
		this.defaultDocType  = defaultDocType;
	}

	public String getDefaultDocType () {
		return this.defaultDocType;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = doc_ref;
	}

	public String getDoc_ref() {
		 return doc_ref;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}
	public String getStore_code() {
		 return store_code;
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
	
	public void setFacility_id(String facility_id) {
		 this.facility_id = facility_id;
	}

	public String getFacility_id() {
		 return facility_id;
	}

	public void setProcess_stage_code(String process_stage_code) {
		 this.process_stage_code = process_stage_code;
	}

	public String getProcess_stage_code() {
		 return process_stage_code;
	}

	public void setProcess_remarks(String process_remarks) {
		 this.process_remarks = checkForNull(process_remarks);
	}

	public String getProcess_remarks() {
		 return process_remarks;
	}

	public void clear(){
	super.clear();
		this.doc_ref="";   
		this.defaultDocType="";
		this.store_code="";       
		this.store_desc="";       
		this.doc_type_code="";    
		this.doc_no="";           
		this.facility_id="";      
		this.process_stage_code="";
		this.process_remarks="";
		this.process_stage_desc="";
	}

	public void setAll(Hashtable htRecordSet) {
		setMode((String) htRecordSet.get("mode"));
		setDoc_ref((String) htRecordSet.get("doc_ref"));
		setStore_code((String) htRecordSet.get("store_code"));
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_date((String) htRecordSet.get("doc_date"));
		setDoc_no((String) htRecordSet.get("doc_no"));
		setFacility_id((String) htRecordSet.get("facility_id"));
		setProcess_stage_code((String) htRecordSet.get("process_stage_code"));
		setProcess_remarks((String) htRecordSet.get("process_remarks"));
	}
	

	public String getStores(String store_code) {
		
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		// Changed from SQL_SS_PREPARE_GROUP_STORE
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_PRE_SELECT_LIST"), alParam);
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			optionValues = getListOptionTag(alOptionValues, store_code);
		}
		else {
			optionValues = getListOptionTag(alOptionValues);
		}
		alOptionValues = null;
		return optionValues;
	}
public String getStores() {
		
		String default_store_code = "";
		try {
				java.util.HashMap defaultParameter = getSSParameter();
				default_store_code = (String)defaultParameter.get("DEF_STORE_CODE_FOR_PRE");
				defaultParameter = null;
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		// Changed from SQL_SS_PREPARE_GROUP_STORE
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_PRE_SELECT_LIST"), alParam);
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
			optionValues = getListOptionTag(alOptionValues, default_store_code);
		}
		else {
			optionValues = getListOptionTag(alOptionValues);
		}
		alOptionValues = null;
		return optionValues;
	}
	public String getProcess() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		// Changed from SQL_SS_PREPARE_GROUP_STORE
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PROCESS_STATUS_SELECT_LIST"));
		if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
		{
			optionValues = getListOptionTag(alOptionValues,getProcess_stage_code());
		}
		else
		{
			optionValues = getListOptionTag(alOptionValues);
		}
		alOptionValues = null;
		return optionValues;
	}

	public String getCurrentStores() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		// Changed from SQL_SS_PREPARE_GROUP_STORE
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_SELECT_LIST"),getLoginFacilityId());
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
	}
	
	public String getDocTypes() {
		String optionValues = null;
		//Get the default Document Type Code for the given Document Type
		java.util.ArrayList alPrepareGroupDoc = new java.util.ArrayList(5);
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alPrepareGroupDoc.add(login_facility_id);
		alPrepareGroupDoc.add("ROF");
		alPrepareGroupDoc.add(getLanguageId());
		//Changed from SQL_SS_PREPARE_GROUP_DOC_TYPE - 1/16/2003
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRN_DOC_TYPE_SELECT_LIST"), alPrepareGroupDoc);
		if ((doc_type_code != null)) {
			optionValues = getListOptionTag(alOptionValues,getDefaultDocType());
		}
		else {
			optionValues = getListOptionTag(alOptionValues);
		}
		alPrepareGroupDoc = null;
		alOptionValues = null;
		return optionValues;
	}

	public void loadData() {
		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		try {
			setFacility_id(login_facility_id);
			connection = getConnection();
			preparedStatement = connection.prepareStatement(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_MAINTAIN_ROF_STATUS_ON_LOAD")); 
			preparedStatement.setString(1, getFacility_id());
			preparedStatement.setString(2, getDoc_type_code());
			preparedStatement.setInt(3, Integer.parseInt(getDoc_no()));

			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				setDoc_date(resultSet.getString("doc_date"));
				setDoc_ref(resultSet.getString("doc_ref"));
				setStore_code(resultSet.getString("store_code"));
				setProcess_stage_code(resultSet.getString("process_stage_code"));
				setProcess_remarks(resultSet.getString("process_remarks"));
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

	public HashMap modify() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	alModifyData = new ArrayList();

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Initial Message") ;

		alModifyData.add(checkForNull(getProcess_stage_code()));
		alModifyData.add(getProcess_remarks());
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id);
		alModifyData.add(getFacility_id());
		alModifyData.add(getDoc_type_code());
		alModifyData.add(new Integer(getDoc_no()));
		

		hmSQLMap.put("ModifySQL", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_MAINTAIN_ROF_HDR_UPDATE")); 

		hmTableData.put("properties",			getProperties());
		hmTableData.put("ModifyData",			alModifyData	);

		try {
			

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
           

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);







			
			if(((Boolean) hmResult.get("result")).booleanValue())		
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;

			else
				hmResult.put("message", hmResult.get("msgid"));
		} 
		catch(Exception e) {
			hmResult.put("message", e.getMessage());
			e.printStackTrace();
		} 
		return hmResult;
	
	}

}
