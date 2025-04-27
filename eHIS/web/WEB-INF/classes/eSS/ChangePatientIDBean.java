/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
1/7/2021  	TFS:19249        	Shazana                      			ML-MMOH-CRF-1661-US001

-------------------------------------------------------------------------------------------------------------------------------------------------------------
 */
package eSS;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;

public class ChangePatientIDBean extends eSS.Common.SsTransaction implements Serializable { 

	private String group_type;
	private String doc_type_code;
	private String doc_no;
	private String tray_no;
	private String patient_id;
	private String issue_group_code;
	private String group_desc;
	private String bin_location_code;
	private String patient_name;
	private String linenApplicableYN;//mmoh-crf-1661 
	
	public String getLinenApplicableYN() {
		return linenApplicableYN;
	}

	public void setLinenApplicableYN(String linenApplicableYN) {
		this.linenApplicableYN = linenApplicableYN;
	}//END 

	private HashMap hmSsParameter =null;

	public void setPatient_name(String patient_name) {
		 this.patient_name = checkForNull(patient_name);
	}

	public String getPatient_name( ) {
		 return patient_name;
	}

	public void setPatient_id(String patient_id) {
		 this.patient_id = checkForNull(patient_id);
	}

	public String getPatient_id( ) {
		 return patient_id;
	}

	public void setBin_location_code(String bin_location_code) {
		 this.bin_location_code = checkForNull(bin_location_code);
	}

	public String getBin_location_code( ) {
		 return bin_location_code;
	}

	public void setGroup_desc(String group_desc) {
		 this.group_desc = group_desc;
	}

	public String getGroup_desc( ) {
		 return group_desc;
	}

	public void setIssue_group_code(String issue_group_code) {
		 this.issue_group_code = issue_group_code;
	}

	public String getIssue_group_code( ) {
		 return issue_group_code;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no = checkForNull(tray_no);
	}

	public String getTray_no( ) {
		 return tray_no;
	}

	public void initSsParameter() throws Exception {
		hmSsParameter=getSSParameter();
	}

	public void initDoc_type_code() {
		doc_type_code=checkForNull((String)hmSsParameter.get("DEF_ISS_DOC_TYPE_CODE")) ;
	}


	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}


	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no() {
		 return doc_no;
	}

	public String getDoc_type_code_List(){
		
	return getDoc_type_code_ListOptions("ISS",getDoc_type_code());
	}

	public String getGroup_type( ) {
		 return group_type;
	}

	public void setGroup_type(String group_type) {
		 this.group_type = group_type;
	}

	public String getGroup_type_List(){
		if(getLinenApplicableYN()!=null && getLinenApplicableYN().equals("Y")){//mmoh-crf-1661 
			return getStaticListOptionTag( "%,All;E,Set;T,Tray;P,Soft Pack;S,Single;L,Linen;", getGroup_type()); 
		}else{
			return getStaticListOptionTag( "%,All;E,Set;T,Tray;P,Soft Pack;S,Single;", getGroup_type());
		}
		
	}

	public String getStore_code_List(){

		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_SELECT_LIST"),alParameters));
	}

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setPatient_id      ((String) htRecordSet.get("patient_id"));
	}

	public void clear(){
		super.clear();
		hmSsParameter =null;
		group_type="";
		doc_type_code="";
		doc_no="";
		tray_no="";        
		patient_id="";     
		issue_group_code="";
		linenApplicableYN ="";//MMOH-CRF-1661 
	}

	public HashMap validate(){
		HashMap hmReturn	=	getMessageHashMap(true);
		try { 
			if (!getPatient_id().equals(""))
				getPatientName(getPatient_id());
		}
		catch (Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MESSAGE,"INVALID_PATIENT");
			hmReturn.put(MSGID,"INVALID_PATIENT");
		}
		return hmReturn;
	}

	public HashMap modify() {

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alModifyData		=	new ArrayList()	;
		HashMap		hmSQLMap			=	new HashMap()	;

		alModifyData.add(getPatient_id()		);      

		alModifyData.add(getLoginById()			);      
		alModifyData.add(getLoginAtWsNo()		);    
		alModifyData.add(getLoginFacilityId()	);

		alModifyData.add(getLoginFacilityId()	);      
		alModifyData.add(getDoc_type_code()		);
		alModifyData.add(new Long (getDoc_no())	);
		alModifyData.add(getIssue_group_code()		);
		alModifyData.add(new Long (getTray_no())	);

		hmSQLMap.put( "ModifySQL",		getSsRepositoryValue("SQL_SS_ISSUE_DTL_UPDATE_CHANGE_PID")	);

		hmTableData.put( "properties",	getProperties() );
		hmTableData.put( "ModifyData",	alModifyData	);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public void loadData() throws Exception {

		ArrayList alParameters	=	new ArrayList(5);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(new Long(getDoc_no()));
		alParameters.add(getIssue_group_code());
		alParameters.add(new Long(getTray_no()));

		HashMap hmRecord		= 	fetchRecord(getSsRepositoryValue("SQL_SS_ISSUE_DTL_SELECT_SINGLE_CHANGE_PID"),alParameters);

		setGroup_type			(	(String) hmRecord.get("GROUP_TYPE")			);       
		setGroup_desc			(	(String) hmRecord.get("GROUP_DESC")			);       
		setBin_location_code	(	(String) hmRecord.get("BIN_LOCATION_CODE")	);
		setPatient_id			(	(String) hmRecord.get("PATIENT_ID")	);
		setPatient_name			(	(String) hmRecord.get("PATIENT_NAME")	);
	}
	
//Bru-HIMS-CRF-360 
	public String getAccess_store_code_List(){
	String sql = (String) getSsRepositoryValue("SQL_SS_STORE_TRAY_USAGE_PATIENT");
		java.util.ArrayList alParam = new java.util.ArrayList();
		String dflt_store = "";
		alParam.add(getLanguageId());
		alParam.add(getLoginFacilityId());
		alParam.add(getLoginById());
		try{
			int cnt = Integer.parseInt((String)fetchRecord(getSsRepositoryValue("SQL_SS_STORE_TRAY_USAGE_PATIENT_COUNT"),alParam).get("COUNT"));
			
				if(cnt == 1){
					dflt_store		=	(String)fetchRecord(sql,alParam).get("STORE_CODE");
				}
			
		}catch(Exception e){
			e.printStackTrace();
		}

		java.util.ArrayList alOptionValues = getListOptionArrayList(sql, alParam);
			return getListOptionTag(alOptionValues,dflt_store);
	}


}
