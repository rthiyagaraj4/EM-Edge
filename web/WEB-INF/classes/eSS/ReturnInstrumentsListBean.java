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

public class ReturnInstrumentsListBean extends eSS.Common.SsTransaction implements java.io.Serializable { 

	private String ret_item_qty;
	private String ret_item_cost;
	private String remarks;
	private String damaged_yn;
	private String item_code;
	private String item_desc;
	private String contaminated_yn;
	private String group_code;
	private String group_desc;
	private String tray_no;
	private String expiry_date;//Added for TH-KW-CRF-0030

	public String getItem_code_List(String ret_store_code, String rec_store_code, String patient_id){
		ArrayList alParameters	=	new ArrayList(4);
		alParameters.add(getLoginFacilityId());
		alParameters.add(ret_store_code);
		alParameters.add(rec_store_code);
		alParameters.add(checkForNull(patient_id,""));
		
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_RETURN_DISCREPANCY_DTL_SELECT_LIST"),alParameters),item_code);
	}

	public String getItem_code_List_for_store(String store_code){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_RETURN_DISCREPANCY_DTL_SELECT_LIST_STORE"),store_code),item_code);
	}

	public String getItem_code_List_for_pat(String patient_id){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_RETURN_DISCREPANCY_DTL_SELECT_LIST_PAT"),patient_id),item_code);
	}

	public void setGroup_desc(String group_desc) {
		 this.group_desc = group_desc;
	}

	public String getGroup_desc( ) {
		 return group_desc;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no = tray_no;
	}

	public String getTray_no( ) {
		 return tray_no;
	}

	public void setGroup_code(String group_code) {
		 this.group_code = group_code;
	}

	public String getGroup_code( ) {
		 return group_code;
	}

	public void setRet_item_qty(String ret_item_qty) {
		 this.ret_item_qty = ret_item_qty;
	}

	public String getRet_item_qty( ) {
		 return ret_item_qty;
	}

	public void setRet_item_cost(String ret_item_cost) {
		 this.ret_item_cost = checkForNull(ret_item_cost);
	}

	public String getRet_item_cost( ) {
		 return ret_item_cost;
	}

	public void setRemarks(String remarks) {
		 this.remarks = checkForNull(remarks);
	}

	public String getRemarks( ) {
		 return remarks;
	}

	public void setExpiryDate(String expiry_date) {//Adding start for TH-KW-CRF-0030
		 this.expiry_date = checkForNull(expiry_date);
	}

	public String getExpiryDate( ) {
		 return expiry_date;
	}//Adding end for TH-KW-CRF-0030

	public String getInitRemarks( ) {
		if (remarks.length()==0) return "&nbsp;"; 

		StringBuffer sbRemarks	=	new StringBuffer();
		sbRemarks.append(remarks.substring(0,(remarks.length()>10)?10:remarks.length() ) );
		if (remarks.length()>0) 
			sbRemarks.append("...");
		else
			sbRemarks.append("&nbsp;");
		return sbRemarks.toString();
	}

	public void setDamaged_yn(String damaged_yn) {
		 this.damaged_yn = damaged_yn;
	}

	public String getDamaged_yn( ) {
		 return damaged_yn;
	}

	public void setItem_code(String item_code) {
		 this.item_code = item_code;
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setItem_desc(String item_desc) {
		 this.item_desc= item_desc;
	}

	public String getItem_desc( ) {
		 return item_desc;
	}

	public void setContaminated_yn(String contaminated_yn) {
		 this.contaminated_yn = contaminated_yn;
	}

	public String getContaminated_yn( ) {
		 return contaminated_yn;
	}

	public boolean isEntryCompleted(String doc_type_code, String doc_no) throws Exception{
		HashMap hmResult		=	new HashMap();
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(new Long(doc_no));
		hmResult	=	fetchRecord(getSsRepositoryValue("SQL_SS_RET_ITEM_HDR_SELECT_SINGLE"),alParameters);
		return hmResult.get("ENTRY_COMPLETED_YN").toString().equals("Y");
	}

	public String getPatient_id(String doc_type_code, String doc_no) throws Exception{
		HashMap hmResult		=	new HashMap();
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(new Long(doc_no));
		hmResult	=	fetchRecord(getSsRepositoryValue("SQL_SS_RET_ITEM_HDR_SELECT_SINGLE"),alParameters);
		return (String)hmResult.get("PATIENT_ID");
	}

	public String getRet_store_code(String doc_type_code, String doc_no) throws Exception{
		HashMap hmResult		=	new HashMap();
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(new Long(doc_no));
		hmResult	=	fetchRecord(getSsRepositoryValue("SQL_SS_RET_ITEM_HDR_SELECT_SINGLE"),alParameters);
		return (String)hmResult.get("RET_STORE_CODE");
	}

   public String getRec_store_code(String doc_type_code, String doc_no) throws Exception{
		HashMap hmResult		=	new HashMap();
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(new Long(doc_no));
		hmResult	=	fetchRecord(getSsRepositoryValue("SQL_SS_RET_ITEM_HDR_SELECT_SINGLE"),alParameters);
		return (String)hmResult.get("REC_STORE_CODE");
	}

	public String getItemDescription(String item_code) throws Exception{
		HashMap hmRecord	=	fetchRecord(getSsRepositoryValue("SQL_SS_ITEM_SELECT_SINGLE"),item_code);
		if (hmRecord.get("CONSUMABLE_YN").toString().equals("Y")) {
			throw new Exception("ITEM_IS_CONSUMABLE");
		}
		return hmRecord.get("SHORT_DESC").toString();
	}

	public void initialize(HashMap hmReturnInstrumentsListItem){
		setRet_item_qty((String) hmReturnInstrumentsListItem.get("ret_item_qty"));
		setRet_item_cost((String) hmReturnInstrumentsListItem.get("ret_item_cost"));
		setRemarks((String) hmReturnInstrumentsListItem.get("remarks"));
		setDamaged_yn((String) hmReturnInstrumentsListItem.get("damaged_yn"));
		setItem_code((String) hmReturnInstrumentsListItem.get("item_code"));
		setItem_desc((String) hmReturnInstrumentsListItem.get("item_desc"));
		setContaminated_yn((String) hmReturnInstrumentsListItem.get("contaminated_yn"));
		setExpiryDate((String) hmReturnInstrumentsListItem.get("expiry_date"));//Added for TH-KW-CRF-0030
	}

	public boolean isItemInArrayList(ArrayList alReturnInstrumentsList, String stTrayNo, int exceptionalIndex){
		boolean result=false;
		for (int i=0;i<alReturnInstrumentsList.size();i++) {
			if (exceptionalIndex == i) continue;
			if ( ((HashMap)alReturnInstrumentsList.get(i)).get("item_code").toString().equals(stTrayNo) ) {
				result=true;
				break;
			}
		}
		return result;
	}

	public void clear(){
		ret_item_qty="";
		ret_item_cost="";
		remarks="";
		damaged_yn="";
		item_code="";
		item_desc="";
		contaminated_yn="";
		group_code="";  
		group_desc="";  	
		tray_no="";
		expiry_date ="";
	}

	public String getGroupCode(String doc_type_code,String doc_no)throws Exception{//Adding start for TH-KW-CRF-0030
        HashMap hmResult		=	new HashMap();
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(doc_type_code);
		alParameters.add(new Long(doc_no));
		System.err.println("alParameters@@==="+alParameters);

		 hmResult		= 	fetchRecord("SELECT SS.GROUP_CODE FROM SS_RET_ITEM_DTL SS WHERE SS.FACILITY_ID=? AND SS.DOC_TYPE_CODE=? AND SS.DOC_NO=?",alParameters);
       System.err.println("group_code=="+(String)hmResult.get("GROUP_CODE"));
		return (String)hmResult.get("GROUP_CODE");
	}//Adding end for TH-KW-CRF-0030
}
