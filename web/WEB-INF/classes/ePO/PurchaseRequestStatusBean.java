/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;
import ePO.PORequisition.*; 
//import ePO.STPORequest.*;
import ePO.Common.PoRepository;
import eCommon.Common.*;
import java.util.Properties;
import eMM.MM_license_rights;


public class PurchaseRequestStatusBean extends ePO.Common.PoTransaction implements Serializable{

	private String reqByStore;
	private String docDtFrom;
	private String docDtTo;
	private String requestItem;
	private String purchaseUnit;
    private String docNo;
	private String requestStatus;
	private String requestType;
	private String entity_param;
	
	private String master_type;
	
	public String getReqByStore() {
		return reqByStore;
	}
	public void setReqByStore(String reqByStore) {
		this.reqByStore = reqByStore;
	}
	public String getDocDtFrom() {
		return docDtFrom;
	}
	public void setDocDtFrom(String docDtFrom) {
		this.docDtFrom = docDtFrom;
	}
	public String getDocDtTo() {
		return docDtTo;
	}
	public void setDocDtTo(String docDtTo) {
		this.docDtTo = docDtTo;
	}
	public String getRequestItem() {
		return requestItem;
	}
	public void setRequestItem(String requestItem) {
		this.requestItem = requestItem;
	}
	public String getPurchaseUnit() {
		return purchaseUnit;
	}
	public void setPurchaseUnit(String purchaseUnit) {
		this.purchaseUnit = purchaseUnit;
	}
	public String getDocNo() {
		return docNo;
	}
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	
	public void setMasterType(String master_type) {
		 this.master_type = master_type;
	}
	
	public String getMasterType() {
        return master_type;
    }
	public void setEntity_param(String entity_param) {
		this.entity_param = entity_param;
	}
	public String getEntity_param() {
		return this.entity_param;
	}
	
	
	public String getRequestByStoreList() {
		ArrayList alParameters =  new ArrayList();							
		alParameters.add(getLoginById());
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_USER_ACCESS_FOR_STORE_SELECT"),alParameters),getReqByStore()); 
	}
	
	public String getRequestFromPurchaseUnit() {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		sqlParam.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_ORD"),sqlParam),""); 
		
	}
	
	public String getPurchaseTypeList() {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add(getMasterType());
		   arr_language.add(getLanguageId());
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),getRequestType()); 
    }


}
