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

import java.util.*;
import java.io.*;
public class TrayDtlBean extends eSS.Common.SsTransaction implements Serializable { 

	private String group_type;
	private String req_group_code;
	private String description;
	private String request_qty;
	private String status;
	private String linenApplicableYN;//mmoh-crf-1661
	
	public String getLinenApplicableYN() {
		return linenApplicableYN;
	} 

	public void setLinenApplicableYN(String linenApplicableYN) {
		this.linenApplicableYN = linenApplicableYN;
	}//END 

	public String getGroup_type() {
		 return group_type;
	}

	public void setGroup_type(String group_type) {
		 this.group_type =  group_type.toUpperCase();
	}

	public String getStatus() {
		 return status;
	}

	public void setStatus(String status) {
		 this.status =  status.toUpperCase();
	}

	public String getGroup_type_List(){
		if(getLinenApplicableYN()!=null && getLinenApplicableYN().equals("Y")){//mmoh-crf-1661
			return getStaticListOptionTag( "%,All;E,Set;T,Tray;P,Soft Pack;S,Single;L,Linen;");

		}else{
			return getStaticListOptionTag( "%,All;E,Set;T,Tray;P,Soft Pack;S,Single;");

		}
	}

	public String getStatus_List(){
		return getStaticListOptionTag( "%,All;S,Sterilized;U,Unsterilized;R,At Service Location;W,Destroyed;");
	}

	public void clear(){
		group_type	  ="";    
		req_group_code="";          
		description   ="";          
		request_qty   ="";          
		mode          ="";   
		linenApplicableYN = ""; //mmoh-crf-1661  
	}
	
	public String getStores() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParameters = new java.util.ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLanguageId());
		// Changed from SQL_SS_PREPARE_GROUP_STORE
		//alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_QUERY_OWNER_SELECT_LIST"),alParameters,false);
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_QUERY_OWNER_SELECT_LIST"),alParameters);
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
	}

	public String getAllStores() {

java.util.ArrayList alParam = new java.util.ArrayList();
alParam.add(getLanguageId());
alParam.add(getLoginFacilityId());
return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_SELECT_LIST"),alParam));
		}

	public String getCurrentTRDStores() {

java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_TRD_SELECT_LIST"),alParam));
	}

	public String getCurrentREQStores() {


		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_REQ_SELECT_LIST"),getLoginFacilityId()));
	}

	public String getCurrentISSStores() {
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_ISS_SELECT_LIST"),getLoginFacilityId()));
	}

	public String getCurrentROFStores() {
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_ROF_SELECT_LIST"),getLoginFacilityId()));
	}

	public String getOwnerStores() {
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(getLoginFacilityId());
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_OWNER_SELECT_LIST"),alParam));
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
	
	public String getDiscrepancy() {

		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		// Changed from SQL_SS_PREPARE_GROUP_STORE
		alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_DISCREPANCY_QUERY"),getLanguageId());
		optionValues = getListOptionTag(alOptionValues);
		alOptionValues = null;
		return optionValues;
	}
	
	//Added by Rabbani #INC no:32068 on 06/12/2012 Starts
	public String getBlockedQty(String owner_store_code, String group_code,String curr_store_code){
	
		ArrayList alParam1 = new ArrayList();
		alParam1.add(owner_store_code);
		alParam1.add(group_code);
		alParam1.add(curr_store_code);
		String blocked_qty  = "0";	
		try{
		//blocked_qty =  (String)((HashMap)fetchRecord("select count(*) COUNT from ss_tray_dtls  where owner_store_code  = ? and group_code = ? and NVL (curr_store_code, owner_store_code) = ?   AND blocked_by is not null",alParam1)).get("COUNT"); 
		//Added   ACK_CONFIRM_REQD_YN='N' against PMG2014-CRF-0008
		//blocked_qty =  (String)((HashMap)fetchRecord("select count(*) COUNT from ss_tray_dtls  where owner_store_code  = ? and group_code = ? and NVL (curr_store_code, owner_store_code) = ? AND ACK_CONFIRM_REQD_YN='N'   AND blocked_by is not null",alParam1)).get("COUNT");
		//Modified by Sakti added blocked_by instead (curr_store_code, owner_store_code) = ?
		blocked_qty =  (String)((HashMap)fetchRecord("select count(*) COUNT from ss_tray_dtls  where owner_store_code  = ? and group_code = ? and  blocked_by = ? AND ACK_CONFIRM_REQD_YN='N'   AND blocked_by is not null",alParam1)).get("COUNT");
		}catch(Exception e){
		    blocked_qty  = "0";	
			e.printStackTrace();
		}
		return blocked_qty;
	}
	
	public Boolean getAckReqd(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT ISS_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("ISS_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}
	//ends

	public String getPendingAcknowledgeQty(String owner_store_code, String group_code,String curr_store_code){
	
		ArrayList alParam = new ArrayList();
		alParam.add(owner_store_code);
		alParam.add(group_code);
		alParam.add(curr_store_code);
		String pending_ack_qty  = "0";	
		try{
		//pending_ack_qty =  (String)((HashMap)fetchRecord("select count(*) COUNT from ss_tray_dtls  where owner_store_code  = ? and group_code = ? and	decode(blocked_yn,'Y',owner_store_code, nvl(curr_store_code,blocked_by)) = ?  AND blocked_by is not null ",alParam)).get("COUNT"); 
		//in this query decode(blocked_yn,'Y',owner_store_code, nvl(curr_store_code,blocked_by)) is changed to decode(blocked_yn,'Y',blocked_by, nvl(curr_store_code,owner_store_code))  AND AND ACK_CONFIRM_REQD_YN='Y' against PMG2014-CRF-0008
		pending_ack_qty =  (String)((HashMap)fetchRecord("select count(*) COUNT from ss_tray_dtls  where owner_store_code  = ? and group_code = ? and	decode(blocked_yn,'Y',blocked_by, nvl(curr_store_code,blocked_by)) = ? AND ACK_CONFIRM_REQD_YN='Y'  AND blocked_by is not null ",alParam)).get("COUNT"); 
		}catch(Exception e){
		    pending_ack_qty  = "0";	
			e.printStackTrace();
		}
		return pending_ack_qty;
	}
	public String getPendingRequestQty(String curr_store_code, String group_code){
	
		ArrayList alParam = new ArrayList();
		alParam.add(curr_store_code);
		alParam.add(group_code);

		String pending_req_qty  = "0";	
		try{
		pending_req_qty =  (String)((HashMap)fetchRecord("select nvl(pending_req_qty,0) pending_req_qty from ss_group_for_store  where store_code  = ? and group_code = ? ",alParam)).get("PENDING_REQ_QTY"); 
		}catch(Exception e){
		    pending_req_qty  = "0";	
			e.printStackTrace();
		}
		return pending_req_qty;
	}

}


