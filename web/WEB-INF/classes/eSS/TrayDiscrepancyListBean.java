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
public class TrayDiscrepancyListBean extends eSS.Common.SsTransaction implements Serializable { 
	
	private String item_code            ;
	private String write_off_reason_code;
	private String item_desc            ;
	private String write_off_reason_desc;
	private String remarks              ;
	private String discrepancy_qty      ;
	private String rec_reference        ;
	private String charge_amt           ;
	private String discrepancy_type     ;
	private String charge_option        ;
	private String usage_ind	        ;
	private String finalized_yn	        ;
	private String mode					;
  
	public String getWrite_off_reason_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WRITE_OFF_REASON_SELECT_LIST"),getLanguageId()),getWrite_off_reason_code());
	}

	public String getUsage_ind() {
		 return usage_ind;
	}

	public void setUsage_ind(String usage_ind) {
		 this.usage_ind =  usage_ind;
	}

	public String getItem_desc() {
		 return item_desc;
	}

	public void setItem_desc(String item_desc) {
		 this.item_desc=  item_desc;
	}

	public String getItem_code() {
		 return item_code;
	}

	public void setItem_code(String item_code) {
		 this.item_code =  item_code;
	}

	public String getFinalized_yn() {
		 return finalized_yn;
	}

	public void setFinalized_yn(String finalized_yn) {
		 this.finalized_yn =  checkForNull(finalized_yn,"N");
	}

	public String getWrite_off_reason_code() {
		 return write_off_reason_code;
	}

	public void setWrite_off_reason_code(String write_off_reason_code) {
		 this.write_off_reason_code =  write_off_reason_code;
	}

	public String getWrite_off_reason_desc() {
		 return write_off_reason_desc;
	}

	public void setWrite_off_reason_desc(String write_off_reason_desc) {
		 this.write_off_reason_desc=  write_off_reason_desc;
	}

	public String getRemarks() {
		 return remarks;
	}

	public void setRemarks(String remarks) {
		 this.remarks =  checkForNull(remarks);
	}

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

	public String getDiscrepancy_qty() {
		 return discrepancy_qty;
	}

	public void setDiscrepancy_qty(String discrepancy_qty) {
		 this.discrepancy_qty =  checkForNull(discrepancy_qty);
	}

	public String getRec_reference() {
		 return rec_reference;
	}

	public void setRec_reference(String rec_reference) {
		 this.rec_reference =  checkForNull(rec_reference);
	}

	public String getCharge_amt() {
		 return charge_amt;
	}

	public void setCharge_amt(String charge_amt) {
		 this.charge_amt =  checkForNull(charge_amt);
	}

	public String getDiscrepancy_type() {
		 return discrepancy_type;
	}

	public void setDiscrepancy_type(String discrepancy_type) {
		 this.discrepancy_type =  discrepancy_type;
	}

	public String getCharge_option() {
		 return charge_option;
	}

	public void setCharge_option(String charge_option) {
		 this.charge_option =  charge_option;
	}

	public String getMode() {
		 return mode;
	}

	public void setMode(String mode) {
		 this.mode =  mode;
	}

	public String getDiscrepancy_type_List(){
		 String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		return getStaticListOptionTag( "P,"+ss_labels.getString("eSS.Positive.label")+";N,"+ss_labels.getString("eSS.Negative.label"), getDiscrepancy_type());
	}

	public String getItem_code_List(String group_code){

		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(group_code );
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_LIST_FOR_TRD"),alParam), getItem_code());
	}

	public boolean isValidDiscrepancyQty(String group_code, String tray_no, String item_code, String discrepancy_type, String discrepancy_qty) throws Exception{
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(group_code);
		alParameters.add(new Long(tray_no));
		alParameters.add(item_code);
		alParameters.add(discrepancy_type);
		alParameters.add(new Long(discrepancy_qty));
		return ((HashMap)fetchRecord(getSsRepositoryValue("SQL_SS_VALIDATE_DISCREPANCY_QTY_SELECT"),alParameters)).get("MESSAGE").toString().equals("NO_ERROR");
	}
	
	public void clear(){
		item_code            =""; 
		write_off_reason_code=""; 
		item_desc            =""; 
		write_off_reason_desc=""; 
		remarks              =""; 
		discrepancy_qty      =""; 
		rec_reference        =""; 
		charge_amt           =""; 
		discrepancy_type     ="N"; 
		finalized_yn	     ="Y"; 
		usage_ind				="";
		charge_option        =""; 
		mode				 ="";    
	}

	public boolean isGroupInArrayList(ArrayList alTrayDiscrepancyList, String stReq_group_code, int exceptionalIndex){
		boolean result=false;
		for (int i=0;i<alTrayDiscrepancyList.size();i++) {
			if (exceptionalIndex == i) continue;
			if ( ((HashMap)alTrayDiscrepancyList.get(i)).get("req_group_code").toString().equals(stReq_group_code) ) {
				result=true;
				break;
			}
		}
		return result;
	}

	public boolean isItemAndDiscrepancyInArrayList(ArrayList alTrayDiscrepancyList, String stItem_code, String stWriteOffReasonCode, int exceptionalIndex){
		boolean result=false;
		for (int i=0;i<alTrayDiscrepancyList.size();i++) {
			if (exceptionalIndex == i) continue;
			if ( ((HashMap)alTrayDiscrepancyList.get(i)).get("item_code").toString().equals(stItem_code) ) 
				if ( ((HashMap)alTrayDiscrepancyList.get(i)).get("write_off_reason_code").toString().equals(stWriteOffReasonCode) ) {
					result=true;
					break;
				}
		}
		return result;
	}
	public String getUsage_indLegend(String stUsage_ind){		
		return stUsage_ind.equals("O")?"Owner Level":stUsage_ind.equals("U")?"Unit Level":"ROF Level";
	}
	public void initialize(HashMap hmTrayDiscrepancyItem){
		setItem_code            (hmTrayDiscrepancyItem.get("item_code").toString());
		setWrite_off_reason_code(hmTrayDiscrepancyItem.get("write_off_reason_code").toString());
		setItem_desc            (hmTrayDiscrepancyItem.get("item_desc").toString());
		setWrite_off_reason_desc(hmTrayDiscrepancyItem.get("write_off_reason_desc").toString());
		setRemarks              (checkForNull((String)hmTrayDiscrepancyItem.get("remarks")).toString());
		setDiscrepancy_qty      (checkForNull((String)hmTrayDiscrepancyItem.get("discrepancy_qty")).toString());
		setFinalized_yn         (checkForNull((String)hmTrayDiscrepancyItem.get("finalized_yn")));
		setCharge_amt           (checkForNull((String)hmTrayDiscrepancyItem.get("charge_amt")));
		setDiscrepancy_type     (hmTrayDiscrepancyItem.get("discrepancy_type").toString());
		setUsage_ind			(hmTrayDiscrepancyItem.get("usage_ind").toString());
		setMode				    (hmTrayDiscrepancyItem.get("mode").toString());
	}
}
