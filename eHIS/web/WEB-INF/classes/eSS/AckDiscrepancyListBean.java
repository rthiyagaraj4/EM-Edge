
package eSS;

import java.util.*;
import java.io.*;
public class AckDiscrepancyListBean extends eSS.Common.SsTransaction implements Serializable { 
	
	private String tray_no	            ;
	private String group_code           ;
	private String item_code            ;
	private String item_desc            ;
	private String write_off_reason_code;
	private String write_off_reason_desc;
	private String remarks              ;
	private String discrepancy_qty      ;
	private String discrepancy_cost     ;
	private String mode					;
	private String markedAsDelete		;
  
	public void setFilter(String group_code, String tray_no){
		 this.group_code=  group_code;
		 this.tray_no	=  tray_no;
	}

	public String getWrite_off_reason_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WRITE_OFF_REASON_SELECT_LIST"),getLanguageId()),getWrite_off_reason_code());
		
	}

	public String getWrite_off_reason_code_List(int i){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WRITE_OFF_REASON_SELECT_LIST"),getLanguageId()));
	}

	public String getItem_desc() {
		 return item_desc;
	}

	public void setItem_desc(String item_desc) {
		 this.item_desc=  item_desc;
	}

	public String getMarkedAsDelete() {
		 return markedAsDelete;
	}

	public void setMarkedAsDelete(String markedAsDelete) {
		 this.markedAsDelete=  markedAsDelete;
	}

	public String getWrite_off_reason_desc() {
		 return write_off_reason_desc;
	}

	public void setWrite_off_reason_desc(String write_off_reason_desc) {
		 this.write_off_reason_desc=  write_off_reason_desc;
	}

	public String getTray_no() {
		 return tray_no;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no =  tray_no;
	}

	public String getGroup_code() {
		 return group_code;
	}

	public void setGroup_code(String group_code) {
		 this.group_code =  group_code;
	}

	public String getItem_code_List(int i) {
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getGroup_code() );
		alParam.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_LIST_FOR_TRD"),alParam));
	}

	public String getItem_code_List() {
	java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getGroup_code() );
		alParam.add(getLanguageId());

		return getListOptionTag(getListOptionArrayList(getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_LIST_FOR_TRD"),alParam),getItem_code());
	}

	public String getItem_code() {
		 return item_code;
	}

	public void setItem_code(String item_code) {
		 this.item_code =  item_code;
	}

	public String getWrite_off_reason_code() {
		 return write_off_reason_code;
	}

	public void setWrite_off_reason_code(String write_off_reason_code) {
		 this.write_off_reason_code =  write_off_reason_code;
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

	public String getDiscrepancy_cost() {
		 return discrepancy_cost;
	}

	public void setDiscrepancy_cost(String discrepancy_cost) {
		 this.discrepancy_cost =  checkForNull(discrepancy_cost);
	}

	public String getMode() {
		 return mode;
	}

	public void setMode(String mode) {
		 this.mode =  mode;
	}

	public String getItem_code_List(String group_code){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_ITEM_FOR_GROUP_SELECT_LIST_FOR_TRD"),group_code), getItem_code());
	}

	public void clear(){
		item_code            =""; 
		write_off_reason_code=""; 
		remarks              =""; 
		discrepancy_qty      =""; 
		discrepancy_cost     =""; 
		markedAsDelete	     ="N"; 
//		group_code			 =""; 
//		tray_no			     =""; 
		mode				 ="";    
	}
	public boolean isValidDiscrepancyQty(String group_code, String tray_no, String item_code, String discrepancy_type, String discrepancy_qty) throws Exception{
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(group_code);
		alParameters.add(new Long(tray_no));
		alParameters.add(item_code);
		alParameters.add(discrepancy_type);
		alParameters.add(new Long(discrepancy_qty));
		AckDiscrepancyListBean discrep=new AckDiscrepancyListBean();
		discrep.setItem_code(item_code);
		return ((HashMap)fetchRecord(getSsRepositoryValue("SQL_SS_VALIDATE_DISCREPANCY_QTY_SELECT"),alParameters)).get("MESSAGE").toString().equals("NO_ERROR");
	}
		public String isValidDiscrepancyQtyMessage(String group_code, String tray_no, String item_code, String discrepancy_type, String discrepancy_qty) throws Exception{
		ArrayList alParameters	=	new ArrayList();
		alParameters.add(group_code);
		alParameters.add(new Long(tray_no));
		alParameters.add(item_code);
		alParameters.add(discrepancy_type);
		alParameters.add(new Long(discrepancy_qty));
		return (((HashMap)fetchRecord(getSsRepositoryValue("SQL_SS_VALIDATE_DISCREPANCY_QTY_SELECT"),alParameters)).get("MESSAGE").toString());
	}


	public boolean isItemAndDiscrepancyInArrayList(ArrayList alAckDiscrepancyList, String stItem_code, String stWriteOffReasonCode, int exceptionalIndex){
		boolean result=false;
		for (int i=0;i<alAckDiscrepancyList.size();i++) {
			HashMap	hmRecord	=	(HashMap)alAckDiscrepancyList.get(i);
			if (exceptionalIndex == i) continue;
			if (! ( hmRecord.get("group_code").toString().equals(group_code) && hmRecord.get("tray_no").toString().equals(tray_no) ) )
				continue;
			if ( hmRecord.get("item_code").toString().equals(stItem_code) ) 
				if ( hmRecord.get("write_off_reason_code").toString().equals(stWriteOffReasonCode) ) {
					result=true;
					break;
				}
		}
		return result;
	}

	public boolean initialize(HashMap hmAckDiscrepancyItem){
		if(! (hmAckDiscrepancyItem.get("group_code").toString().equals(group_code)&&hmAckDiscrepancyItem.get("tray_no").toString().equals(tray_no))) {
			return false;
		}
		setItem_desc            (hmAckDiscrepancyItem.get("item_desc").toString());
		setItem_code            (hmAckDiscrepancyItem.get("item_code").toString());
		setWrite_off_reason_code(hmAckDiscrepancyItem.get("write_off_reason_code").toString());
		setWrite_off_reason_desc(hmAckDiscrepancyItem.get("write_off_reason_desc").toString());
		setRemarks              (hmAckDiscrepancyItem.get("remarks").toString());
		setDiscrepancy_qty      (hmAckDiscrepancyItem.get("discrepancy_qty").toString());
		setDiscrepancy_cost     (hmAckDiscrepancyItem.get("discrepancy_cost").toString());
		setMode				    (hmAckDiscrepancyItem.get("mode").toString());
		setMarkedAsDelete	    (hmAckDiscrepancyItem.get("markedAsDelete").toString());
		return true;
	}
}
