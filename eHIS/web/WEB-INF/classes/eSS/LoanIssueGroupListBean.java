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
public class LoanIssueGroupListBean extends eSS.Common.SsTransaction implements Serializable { 

	private String patient_id;
	private String bin_location_desc;
	private String tray_no;
	private String expiry_date;
	private String req_group_code;
	private String patient_name;
	private String issue_group_code;
	private String issue_group_desc;
	private String bin_location_code;
	private String req_group_desc;
	private String store_code   ;
	private String issue_cost   ;
	private String auth_group_code;
	private String auth_group_desc;

//for tray search
	public void setStore_code(String store_code) {
		 this.store_code = store_code.toUpperCase();
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public void setIssue_cost(String issue_cost) {
		this.issue_cost = issue_cost.toUpperCase();
	}

	public String getIssue_cost( ) {
		return issue_cost;
	}

	public String getStore_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLanguageId());
		alParam.add(getLoginFacilityId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_SELECT_LIST"),alParam), getStore_code());
	}
//
	public void setPatient_id(String patient_id) {
		 this.patient_id = checkForNull(patient_id);
	}

	public String getPatient_id( ) {
		 return patient_id;
	}

	public void setBin_location_desc(String bin_location_desc) {
		 this.bin_location_desc = checkForNull(bin_location_desc);
	}

	public String getBin_location_desc( ) {
		 return bin_location_desc;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no = checkForNull(tray_no);
	}

	public String getTray_no( ) {
		 return tray_no;
	}

	public void setExpiry_date(String expiry_date) {
		 this.expiry_date = checkForNull(expiry_date);
	}

	public String getExpiry_date( ) {
		 return expiry_date;
	}

	public void setReq_group_code(String req_group_code) {
		 this.req_group_code = req_group_code;
	}

	public String getReq_group_code( ) {
		 return req_group_code;
	}

	public void setPatient_name(String patient_name) {
		 this.patient_name = checkForNull(patient_name);
	}

	public String getPatient_name( ) {
		 return patient_name;
	}

	public void setIssue_group_code(String issue_group_code) {
		 this.issue_group_code = issue_group_code;
	}

	public String getIssue_group_code( ) {
		 return issue_group_code;
	}

	public void setBin_location_code(String bin_location_code) {
		 this.bin_location_code = checkForNull(bin_location_code);
	}

	public String getBin_location_code( ) {
		 return bin_location_code;
	}

	public void setReq_group_desc(String req_group_desc) {
		 this.req_group_desc = req_group_desc;
	}

	public String getReq_group_desc( ) {
		 return req_group_desc;
	}

	public void setIssue_group_desc(String issue_group_desc) {
		 this.issue_group_desc = issue_group_desc;
	}

	public String getIssue_group_desc( ) {
		 return issue_group_desc;
	}

	public void setAuth_group_code(String auth_group_code) {
		this.auth_group_code = auth_group_code;
	}

	public String getAuth_group_code (){
		return this.auth_group_code;
	}

	public void setAuth_group_desc(String auth_group_desc) {
		this.auth_group_desc = auth_group_desc;
	}

	public String getAuth_group_desc(){
		return this.auth_group_desc;
	}

	public void clear(){
		patient_id="";
		bin_location_desc="";
		tray_no="";
		expiry_date="";
		req_group_code="";
		patient_name="";
		issue_group_code="";
		bin_location_code="";
		req_group_desc="";
		store_code="";
		issue_group_desc="";
		issue_cost="";
		auth_group_code ="";
		auth_group_desc ="";
	}

	public String getIssue_group_code_List(String fr_store_code, String to_store_code, String dflt_code){
		ArrayList alParameters	=	new ArrayList(4);
		alParameters.add(getAuth_group_code());
		alParameters.add(getAuth_group_code());
		alParameters.add(fr_store_code);
		alParameters.add(to_store_code);
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_ALTERNATE_GROUP_SELECT_LIST"),alParameters), dflt_code);
	}

	public boolean isTrayInArrayList(ArrayList alLoanIssueGroupList, String stTrayNo, String stLoanIssueGroupCode, int exceptionalIndex){
		boolean result=false;
		for (int i=0;i<alLoanIssueGroupList.size();i++) {
			if (exceptionalIndex == i) continue;
			if ( ((HashMap)alLoanIssueGroupList.get(i)).get("tray_no").toString().equals(stTrayNo)&&((HashMap)alLoanIssueGroupList.get(i)).get("issue_group_code").toString().equals(stLoanIssueGroupCode) ) {
				result=true;
				break;
			}
		}
		return result;
	}

	public void initialize(HashMap hmLoanIssueGroupListItem){
		setPatient_id		((String)hmLoanIssueGroupListItem.get("patient_id"));
		setBin_location_desc((String)hmLoanIssueGroupListItem.get("bin_location_desc"));
		setTray_no  		((String)hmLoanIssueGroupListItem.get("tray_no"));
		setExpiry_date		((String)hmLoanIssueGroupListItem.get("expiry_date"));
		setReq_group_code	((String)hmLoanIssueGroupListItem.get("req_group_code"));
		setPatient_name     ((String)hmLoanIssueGroupListItem.get("patient_name"));
		setIssue_group_code	((String)hmLoanIssueGroupListItem.get("issue_group_code"));
		setBin_location_code((String)hmLoanIssueGroupListItem.get("bin_location_code"));
		setReq_group_desc  	((String)hmLoanIssueGroupListItem.get("req_group_desc"));
		setIssue_group_desc((String)hmLoanIssueGroupListItem.get("issue_group_desc"));
		setIssue_cost		((String)hmLoanIssueGroupListItem.get("issue_cost"));
		setAuth_group_code((String) hmLoanIssueGroupListItem.get("auth_group_code"));
		setAuth_group_desc((String) hmLoanIssueGroupListItem.get("auth_group_desc"));
	}

	public String getGroupCost(String stGroup_code, String stCost_flag) throws Exception{
		String sql=getSsRepositoryValue("SQL_SS_GET_GROUP_UNIT_COST_SELECT_COST");
		String [] stParameters={stGroup_code, stCost_flag};
		return (String)fetchRecord(sql,stParameters).get("COST"); 
	}
	
	public String getSterilizationCost(String stGroup_code) throws Exception{
		String stSterile_type=checkForNull((String)fetchRecord(getSsRepositoryValue("SQL_SS_GROUP_SELECT_SINGLE"),stGroup_code).get("DEF_STERILE_TYPE"));
		String sql=getSsRepositoryValue("SQL_SS_GET_STERILIZATION_COST_SELECT");
		String [] stParameters={stGroup_code, stSterile_type};
		return (String)fetchRecord(sql,stParameters).get("COST"); 
	}
	
}

