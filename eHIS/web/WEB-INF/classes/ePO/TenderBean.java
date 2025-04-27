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
import ePO.Tender.*;
import ePO.Common.*;
import eCommon.Common.*;

import java.util.Properties;
import javax.servlet.http.*; 


public class TenderBean extends PoTransaction implements Serializable{
 
	private String master_type;
	private String tender_type;
	private String request_on_supp;
	private String doc_no;
	private String doc_ref;
	private String doc_date;
	private String expiry_date;
	private String approval_date;
	private String contract_date;
	private String tender_remarks;
	
	private String from_purchase_unit;
	private String to_supplier;
	private String po_mode;
	private String blanket_purchase;
	private String doc_remarks;
	public String pur_req_no;
	public String currency_code;
	private String dflt_currency = "";
	private String exc_rate;
	private String local_currency;
	private String blanket_po_yn;
	private String addi_dist;
	private String gross_poAmt;
	private String net_poAmt;
	private String valid_upto;
	private String order_remarks;
	
	private HashMap	hmExpRecords;
	private HashMap	hmBatchRecords;
	private HashMap	hmSelectionCriteriaRecords;
	private HashMap	hmSupplierRecords;
	
	private HashMap	hmBillRecords;
	private ArrayList	alBillRecords;
	private String qnt_ref;
	private String pmnt_term;
	private String acc_no;
	private String terms_conditions;
	private String delivery_mode;
	private String deliver_to_address;
	private String bill_to_address;
	
	/*private String inv_no;
	private String inv_date;
	private String inv_recdBy;
	private String delivery_remarks;*/
	
	private String exp_date;
	private String old_po_no;
	private String request_by_pu;
	
	private String finalize_yn;
	private HashMap hmItemDetail;
	private ArrayList itemKeys;
	private ArrayList reqKeys;
	private ArrayList checkedItemKeys;
	private ArrayList itemKeysAdded;
	private ArrayList reqKeysAdded;
	private ArrayList allItemKeys;
	private HashMap PoItemDetails;
	
	private ArrayList PDocNo ;
	public String reportserver = "";
	public String report_connect_string = "";
	//private String PgetPu_codepo="";
	
	private String supp_code="";
	
	private java.util.HashMap hmRemarks;
	private java.util.HashMap hmRecomRemarks;
	
	private String cancelled_remarks = "";
		private String place_of_origin;
	
	private HashMap		hmMm_parameter=new HashMap();
	
	
	


	public TenderBean() {
		itemKeys = new java.util.ArrayList();
		reqKeys = new java.util.ArrayList();
		checkedItemKeys = new java.util.ArrayList();
		hmItemDetail = new java.util.HashMap();
		hmRemarks = new java.util.HashMap();
		hmRecomRemarks = new java.util.HashMap();
	}
	
	public void setCancelled_remarks(String cancelled_remarks) {
		 this.cancelled_remarks = cancelled_remarks;
	}
	
	public String getCancelled_remarks() {
		 return this.cancelled_remarks;
	}
	public String getDoc_date_value() {
		return doc_date;
	}
	
	public void setFinalize_yn(String finalize_yn) {
		this.finalize_yn = finalize_yn;
	}
	public String getFinalize_yn() {
		return this.finalize_yn;
	}
	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getPrintDocNo(){
		return PDocNo;
	}
	public void setReport_Connect_String(String report_connect_string) {
		 this.report_connect_string= report_connect_string;

	}

	public String getReport_Connect_String( ) {
		 return report_connect_string;
	}
	public void setReport_Server(String reportserver) {
		 this.reportserver= reportserver;
 	}

	public String  getReport_Server( ) {
		 return reportserver;
	}
	public void setRequest_by_pu(String request_by_pu) {
	
		this.request_by_pu = request_by_pu;
	}
	public String getRequest_by_pu() {
		 return request_by_pu;
	}
	public void setRequest_on_supp(String request_on_supp) {
		
		this.request_on_supp = request_on_supp;
	}
	public String getRequest_on_supp() {
		 return request_on_supp;
	}
	public ArrayList getItemKeys() {
		return this.itemKeys;
	}
	public ArrayList getReqKeys() {
		return this.reqKeys;
	}
	public void setReqKeys(ArrayList reqKeys) {
	
		this.reqKeys = reqKeys;
	}
	public java.util.ArrayList getItemKeysAdded() {
		return this.itemKeysAdded;
	}
	public java.util.ArrayList getReqKeysAdded() {
		return this.reqKeysAdded;
	}
	public java.util.HashMap getHmItemDetail() {
		return this.hmItemDetail;
	}

	public void setHmItemDetail(HashMap hmItemDetail) {
		this.hmItemDetail = hmItemDetail;
	}
	
	public void setTender_type(String tender_type) {
		 this.tender_type = checkForNull(tender_type);
	}

	public String getTender_type() {
		 return tender_type;
	}

	public void setMasterType(String master_type) {
		 this.master_type = master_type;
	}
	
	public String getMasterType() {
        return master_type;
    }
	
	public void setFrom_purchase_unit(String from_purchase_unit) {
		 this.from_purchase_unit = from_purchase_unit;
	}

	public String getFrom_purchase_unit() {
		 return from_purchase_unit;
	}

	public void setTo_supplier(String to_supplier) {
		 this.to_supplier = to_supplier;
	}

	public String getTo_supplier() {
		 return to_supplier;
	}
	
	public void setPo_mode(String po_mode) {
		 this.po_mode = po_mode;
	}
	
	public String getPo_mode() {
		 return po_mode;
	}
	
	public void setBlanket_purchase(String blanket_purchase) {
		 this.blanket_purchase = blanket_purchase;
	}
	public String getBlanket_purchase() {
		 return blanket_purchase;
	}
	
	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}
	
	public String getDoc_no() {
		 return doc_no;
	}
	
	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = doc_ref;
	}
	
	public String getDoc_ref() {
		 return (doc_ref==null)?"":doc_ref;
	}
	
	public void setDoc_remarks(String doc_remarks) {
		 this.doc_remarks = doc_remarks;
	}
	
	public String getDoc_remarks() {
		 return (doc_remarks==null)?"":doc_remarks;
	}
	
	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}
	
	public void setPlaceOfOrigin(String place_of_origin)
	{
		this.place_of_origin=checkForNull(place_of_origin);
	}
	public String getPlaceOfOrigin()
	{
		return this.place_of_origin;
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
			return exception.toString();
		}
	}
	
	public void setPur_req_no(String pur_req_no)
	{
		this.pur_req_no=checkForNull(pur_req_no);
	}

	public String getPur_req_no()
	{
		return pur_req_no;
	}
	
	public void setCurrency_code(String currency_code)
	{
		this.currency_code=checkForNull(currency_code);
	}

	public String getCurrency_code()
	{
		return currency_code;
	}
	public void setExc_rate(String exc_rate)
	{
		this.exc_rate=checkForNull(exc_rate);
	}

	public String getExc_rate()
	{
		return exc_rate;
	}
	public void setLocal_currency(String local_currency)
	{
		this.local_currency=checkForNull(local_currency);
	}

	public String getLocal_currency()
	{
		return local_currency;
	}
	public void setBlanket_po_yn(String blanket_po_yn)
	{
		this.blanket_po_yn=checkForNull(blanket_po_yn,"N");
	}

	public String getBlanket_po_yn()
	{
		return blanket_po_yn;
	}
	public void setAddi_dist(String addi_dist)
	{
		this.addi_dist=checkForNull(addi_dist);
	}

	public String getAddi_dist()
	{
		return addi_dist;
	}	
	public void setGross_poAmt(String gross_poAmt)
	{
		this.gross_poAmt=checkForNull(gross_poAmt);
	}

	public String getGross_poAmt()
	{
		return gross_poAmt;
	}	
	public void setNet_poAmt(String net_poAmt)
	{
		this.net_poAmt=checkForNull(net_poAmt);
	}

	public String getNet_poAmt()
	{
		return net_poAmt;
	}		
	public void setValid_upto(String valid_upto)
	{
		this.valid_upto=checkForNull(valid_upto);
	}

	public String getValid_upto()
	{
		return valid_upto;
	}	
	public void setOrder_remarks(String order_remarks)
	{
		this.order_remarks=checkForNull(order_remarks," ");
	}

	public String getOrder_remarks()
	{
		return order_remarks;
	}	
	
	public void setQnt_ref(String qnt_ref)
	{
		this.qnt_ref=checkForNull(qnt_ref," ");
	}

	public String getQnt_ref()
	{
		return qnt_ref;
	}
	public void setPmnt_term(String pmnt_term)
	{
		this.pmnt_term=checkForNull(pmnt_term," ");
	}

	public String getPmnt_term()
	{
		return pmnt_term;
	}
	public void setAcc_no(String acc_no)
	{
		this.acc_no=checkForNull(acc_no," ");
	}

	public String getAcc_no()
	{
		return acc_no;
	}
	public void setTerms_conditions(String terms_conditions)
	{
		this.terms_conditions=checkForNull(terms_conditions," ");
	}

	public String getTerms_conditions()
	{
		return terms_conditions;
	}
	
	public void setDelivery_mode(String delivery_mode)
	{
		this.delivery_mode=checkForNull(delivery_mode," ");
	}

	public String getDelivery_mode()
	{
		return delivery_mode;
	}

	public void setDeliver_to_address(String deliver_to_address)
	{
		this.deliver_to_address=checkForNull(deliver_to_address," ");
	}

	public String getDeliver_to_address()
	{
		return deliver_to_address;
	}

	public void setBill_to_address(String bill_to_address)
	{
		this.bill_to_address=checkForNull(bill_to_address," ");
	}

	public String getBill_to_address()
	{
		return bill_to_address;
	}
	
	public void setExp_date(String exp_date)
	{
		this.exp_date=checkForNull(exp_date);
	}

	public String getExp_date()
	{
		return exp_date;
	}
	
	public void setOld_po_no(String old_po_no)
	{
		this.old_po_no=checkForNull(old_po_no);
	}

	public String getOld_po_no()
	{
		return old_po_no;
	}
	
	public void setSupp_code(String supp_code) {
		 this.supp_code = checkForNull(supp_code);
	}

	public String getSupp_code( ) {
		 return supp_code;
	}
	
		
	
	public void setTender_remarks(String tender_remarks) {
		 this.tender_remarks = checkForNull(tender_remarks," ");
	}

	public String getTender_remarks( ) {
		 return tender_remarks;
	}
	
	public void setExpiry_date(String expiry_date)
	{
		this.expiry_date=checkForNull(expiry_date);
	}

	public String getExpiry_date()
	{
		return expiry_date;
	}
	
	public void setApproval_date(String approval_date)
	{
		this.approval_date=checkForNull(approval_date);
	}

	public String getApproval_date()
	{
		return approval_date;
	}
	
	public void setContract_date(String contract_date)
	{
		this.contract_date=checkForNull(contract_date);
	}

	public String getContract_date()
	{
		return contract_date;
	}
		
	public String getFacilityList() {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_FACILITY_DATA_SELECT_LIST"),sqlParam),""); 
		
	}
	
	public String getFacilityList(String facility_code) {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_FACILITY_DATA_SELECT_LIST"),sqlParam),facility_code); 
		
	}
	
	public String getSelCriteriaList(String selection_criteria) {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLanguageId());
		sqlParam.add("SELCRT");
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_SELECTION_CRITERIA_LIST"),sqlParam),selection_criteria); 
		
	}
	
	public String getEvalFactorList(String eval_factor) {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLanguageId());
		sqlParam.add("EVALFT");
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_SELECTION_CRITERIA_LIST"),sqlParam),eval_factor); 
		
	}
	
	public String getRequestByStoreList() { 
		ArrayList alParameters =  new ArrayList();							
		alParameters.add(getLoginById());
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_USER_ACCESS_FOR_STORE_SELECT"),alParameters),""); 
	}
	
	public String getRequestByStoreList(String store_code,String facility_id) { 
		ArrayList alParameters =  new ArrayList();							
		alParameters.add(getLoginById());
		alParameters.add(getLanguageId());
		alParameters.add(facility_id);
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_USER_ACCESS_FOR_STORE_SELECT"),alParameters),store_code); 
	}
	
	public java.util.ArrayList getRequestByStoreList(String facility_id) throws Exception 	{
		ArrayList result		=	new ArrayList();
		ArrayList alParameters =  new ArrayList();							
		alParameters.add(getLoginById());
		alParameters.add(getLanguageId());
		alParameters.add(facility_id);
		result = fetchRecords(PoRepository.getPoKeyValue("SQL_PO_USER_ACCESS_FOR_STORE_SELECT"),alParameters);
		return result;
	}
	
	public String getTender_type_List() {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add(getMasterType());
		   arr_language.add(getLanguageId());
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_TENDER_TYPE_SELECT"),arr_language),getTender_type()); 
		   
		   
    }
	
	public String getTender_type_List(String pur_type) {
		   ArrayList arr_language1 = new ArrayList();
		   arr_language1.add(getMasterType());
		   arr_language1.add(getLanguageId());
		   ArrayList arr_language = new ArrayList();
		   arr_language.add(getMasterType());
		   arr_language.add(getLanguageId());
		   		   
		try{
			int cnt = Integer.parseInt((String)fetchRecord(getPoRepositoryValue("SQL_DO_TYPE_COUNT"),arr_language1).get("COUNT"));
			
			if(cnt == 1){
				pur_type		=	(String)fetchRecord(getPoRepositoryValue("SQL_PO_TENDER_TYPE_SELECT"),arr_language).get("MASTER_CODE");
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		   
		   
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_TENDER_TYPE_SELECT"),arr_language),pur_type); 
		  
    }
	
	public String getRequestFromPurchaseUnit() {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		sqlParam.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_TENDER"),sqlParam),""); 
		
	}
	
	
	public String getRequestFromPurchaseUnit(String pur_unit) {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		sqlParam.add(getLoginFacilityId());
		
	/*	try{
			int cnt = Integer.parseInt((String)fetchRecord(getPoRepositoryValue("SQL_PURCHASE_UNIT_COUNT"),sqlParam).get("COUNT"));
			
			if(cnt == 1){
				pur_unit		=	(String)fetchRecord(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_TENDER"),sqlParam).get("CODE");
				System.out.println("pur_unit in po bean = "+pur_unit);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	*/	
		
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_TENDER"),sqlParam),pur_unit); 
		
	}
	
	public String getRequestToSupp() {
							
		ArrayList alParameters = new ArrayList();
		alParameters.add(getLanguageId());
		return getListValues(ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SUPPLIER_LIST"), alParameters,"");
		
		}
	public String getRequestToSupp(String supp_code) {
							
		ArrayList alParameters = new ArrayList();
		alParameters.add(getLanguageId());
		return getListValues(ePO.Common.PoRepository.getPoKeyValue("SQL_PO_SUPPLIER_LIST"), alParameters,supp_code);
		
		}	
		
	public String getSupp_code_List() {			
/*	ArrayList arr_language = new ArrayList();
	arr_language.add(getLanguageId());
	arr_language.add(getSupp_code());	*/			
		return  getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_AP_SUPPLIER_SELECT_LIST"),getLanguageId()),getRequest_on_supp());
	}	

public String getSupp_code_List(String supp_code) {
	return  getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_AP_SUPPLIER_SELECT_LIST"),getLanguageId()),supp_code);
}	
		
public String getSupp_code_ListForAll(String supp_code) {
	return  getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_AP_SUPPLIER_SELECT_LIST_FOR_ALL_STATUS"),getLanguageId()),supp_code);
}	

	public String getUOMDesc(String uom_code) throws Exception {

		String uom	  = "";	
		HashMap default_uom			  = new HashMap();
		try{
			default_uom = fetchRecord(getPoRepositoryValue("SQL_ST_UOM_DESC_SELECT"),uom_code);
		}catch(Exception e){
			uom = "";
		}
		
		if(default_uom.size() > 0)
			uom = (String)default_uom.get("SHORT_DESC");

		return uom;

	}
	
	public String loadCurrencyList(String curecy_code) {
							
		ArrayList alParameters = new ArrayList();
		String default_curecy = "";
		if(curecy_code != "" && curecy_code != null){
			default_curecy = curecy_code;
		}else{
			default_curecy = dflt_currency;
		}
		alParameters.add(getLanguageId());
		return getListValues(ePO.Common.PoRepository.getPoKeyValue("SQL_AP_CURRENCY_CODE_SELECT_SINGLE"), alParameters,default_curecy);
		
		}	
	
	public java.util.ArrayList getCurrencyLists() throws Exception 	{
	
		ArrayList result		=	new ArrayList();
		ArrayList chkParameters=new ArrayList();
		chkParameters.add(getLanguageId());
		result = fetchRecords(PoRepository.getPoKeyValue("SQL_AP_CURRENCY_CODE_SELECT_SINGLE"),chkParameters);
	
		return result;
	}
	
	public HashMap getCurrencyDesc(String store_code){
		HashMap hmRecord = null;
		
		try{
		
			ArrayList chkParameters=new ArrayList();
			chkParameters.add(store_code);
			chkParameters.add(getLanguageId());
			hmRecord		=	fetchRecord(getPoRepositoryValue("SQL_AP_CURRENCY_DESC"),chkParameters);
			
			if(hmRecord.size()>0){
			dflt_currency = (String)hmRecord.get("CURRENCY_CODE");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return hmRecord;
	}

	public String getComm_code(String commit_code) {
	
		ArrayList chkParameters=new ArrayList();
		chkParameters.add(getLanguageId());	
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_COMM_CODE_SELECT"),chkParameters),commit_code); 
		
    }
	
	public java.util.ArrayList getDept_no(String commit_code) throws Exception 	{
		
		ArrayList result		=	new ArrayList();
		ArrayList chkParameters=new ArrayList();
		chkParameters.add(getLanguageId());	
		chkParameters.add(commit_code);	
		result = fetchRecords(PoRepository.getPoKeyValue("SQL_PO_DEPT_NO_SELECT"),chkParameters);
		return result;
	}
	
	public java.util.ArrayList getAccount_no(String dept_id,String commit_code) throws Exception 	{
		ArrayList chkParameters=new ArrayList();
		chkParameters.add(dept_id);
		chkParameters.add(commit_code);
		ArrayList result		=	new ArrayList();
		result = fetchRecords(PoRepository.getPoKeyValue("SQL_PO_ACCOUNT_NO_SELECT"),chkParameters);
		return result;
	}
	
	public HashMap getAcctDesc(String acc_no,String commit_code,String dept_id){
		HashMap hmRecord = null;
		ArrayList chkParameters=new ArrayList();
		chkParameters.add(acc_no);
		chkParameters.add(commit_code);
		chkParameters.add(dept_id);
		try{
			hmRecord		=	fetchRecord(getPoRepositoryValue("SQL_PO_ACCOUNT_DESC_SELECT"),chkParameters);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return hmRecord;
	}
	
	public String getUom_code(String uom_code) {
			
		ArrayList chkParameters=new ArrayList();
		chkParameters.add(getLanguageId());	
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_UOM_CODE_SELECT"),chkParameters),uom_code); 
		
    }
	public HashMap getUomDesc(String uom_code){
		HashMap hmRecord = null;
		
		try{
			ArrayList chkParameters=new ArrayList();
			chkParameters.add(uom_code);
			chkParameters.add(getLanguageId());
			hmRecord		=	fetchRecord(getPoRepositoryValue("SQL_PO_UOM_DESC_SELECT"),chkParameters);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return hmRecord;
	}
	
	public HashMap getCommntDesc(String commt_code){
		HashMap hmRecord = null;
		
		try{
			ArrayList chkParameters=new ArrayList();
			chkParameters.add(getLanguageId());
			chkParameters.add(commt_code);
			hmRecord		=	fetchRecord(getPoRepositoryValue("SQL_PO_COMM_DESC_SELECT"),chkParameters);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return hmRecord;
	}
	
	
	public String loadDelivery_mode() {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add("DELVRY");
		   arr_language.add(getLanguageId());
		  
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),getDelivery_mode()); 
    }
	
	public String getPayment_term() {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add("PAYTRM");
		   arr_language.add(getLanguageId());
		  
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),getPmnt_term()); 
    }
	
	public String getTermsandcondition() {
			
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_TERM_AND_COND_SELECT")),getTerms_conditions()); 
		
    }
	

			
	public void clear() {
	
		super.clear();
		doc_no = null;
		doc_ref = null;
		doc_remarks = null;
		doc_date = null;
		request_by_pu = null;
		request_on_supp = null;
		blanket_po_yn = null;
		hmItemDetail = null;
		itemKeys = null;
		reqKeys = null;
		itemKeysAdded = null;
		reqKeysAdded = null;
		checkedItemKeys =null;
		hmExpRecords = null;
		hmBatchRecords = null;
		hmSelectionCriteriaRecords = null;
		hmSupplierRecords = null;
		hmBillRecords = null;
		alBillRecords = null;
		qnt_ref= null;
		pmnt_term= null;
		terms_conditions= null;
		delivery_mode= null;
		deliver_to_address= null;
		bill_to_address= null;
		order_remarks = null;
		tender_type = null;
		exc_rate = null;
		valid_upto = null;
		PoItemDetails = null;
		addi_dist = null;
		net_poAmt = null;
		exp_date = null;
		old_po_no = null;
		dflt_currency = null;
		currency_code = null;
		po_mode = null;
		
		expiry_date = null;
		approval_date = null;
		contract_date = null;
		tender_remarks = null;
		
		hmMm_parameter=null;
		hmRemarks = null;
		hmRecomRemarks = null;
		place_of_origin = null;
	}
	public void initialize() {
	
		super.initialize();
		doc_no = "";
		doc_ref = "";
		doc_remarks = "";
		doc_date = "";
		request_by_pu = "";
		request_on_supp = "";
		blanket_po_yn = "";
		hmItemDetail = new java.util.HashMap();
		itemKeys = new java.util.ArrayList();
		reqKeys = new java.util.ArrayList();
		itemKeysAdded = new java.util.ArrayList();
		reqKeysAdded = new java.util.ArrayList();
		checkedItemKeys = new java.util.ArrayList();
		hmExpRecords=new java.util.HashMap();
		hmBatchRecords = new java.util.HashMap();
		hmSelectionCriteriaRecords = new java.util.HashMap();
		hmSupplierRecords = new java.util.HashMap();
		
		hmBillRecords= new java.util.HashMap();
		alBillRecords =new java.util.ArrayList();
		qnt_ref= "";
		pmnt_term= "";
		terms_conditions= "";
		delivery_mode= "";
		deliver_to_address= "";
		bill_to_address= "";
		order_remarks = "";
		tender_type = "";
		exc_rate = "";
		valid_upto = "";
		PoItemDetails = new java.util.HashMap();
		addi_dist = "";
		net_poAmt = "";
		exp_date = "";
		old_po_no = "";
		dflt_currency = "";
		currency_code = "";
		po_mode = "";
		
		expiry_date = "";
		approval_date = "";
		contract_date = "";
		tender_remarks = "";
		
		hmRemarks = new HashMap();
		hmRecomRemarks = new HashMap();
			place_of_origin = "";
		
		try { 
			
			hmMm_parameter=fetchRecord(getPoRepositoryValue("SQL_MM_PARAMETER_SELECT_SINGLE"),"MM");
		}
		catch (Exception exception) {
			
			exception.printStackTrace();
		}
	}
	public String getFacility_code(String pur_unit) {
			
			return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_FACILITY_CODE_SELECT"),pur_unit),""); 
		
    }
	public String getStore_code() {
			
			ArrayList arr_language=new ArrayList();
			arr_language.add(getLoginFacilityId());
			arr_language.add(getLanguageId());
			return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_ST_PO_REQUEST_FROM_STORE_SELECT"),arr_language),""); 
			
		
    }
	
	public String getQRYRequestOnStore() {
		String sql = ePO.Common.PoRepository.getPoKeyValue("SQL_ST_PO_REQUEST_FROM_STORE_SELECT");
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_on_supp());
	}  	
	
	
	public TenderDetailBean getItemDetail(String item_code) {
		return (TenderDetailBean) hmItemDetail.get(item_code);
	}
	

	 
	public java.util.HashMap addDetailRecord(java.util.Hashtable detailRecord) {
		
			java.util.HashMap hashResult = new java.util.HashMap(2);
			hashResult.put("result",new Boolean(false));
	
		// Logic which adds the record 
		String item_code = "";
		
		if(detailRecord.get("itemCode_reqNO") == ""){
			item_code = (String) detailRecord.get("item_code");
		}else{
			item_code = (String) detailRecord.get("itemCode_reqNO");
		}
		
		
		String editing = (String) detailRecord.get("editing");
		if (editing.equals("1") && itemKeys.contains(item_code)) {
			hashResult.put("message","DUPLICATE_CODE_EXISTS");
			return hashResult;
		}
		else if (editing.equals("1")) {
			
			itemKeys.add(item_code);
			
		}
		
		
		if (editing.equals("2") && getPo_mode().equals("R")) {
			
			reqKeysAdded.add(item_code);
			
		}
		if(reqKeysAdded != null){
		 for(int k=0;k<itemKeys.size();k++){
			for(int i=0;i<reqKeysAdded.size();i++){
				if(itemKeys.contains(reqKeysAdded.get(i))){
					reqKeysAdded.remove(itemKeys.get(k));
					
				}	
			}
		 }	
		}
		
		
		
		
		hmItemDetail.put(item_code, new TenderDetailBean(detailRecord));
		hashResult.put("result",new Boolean(true));
		hashResult.put("message","");
		return hashResult;
	}
	

	public HashMap addDetailRecordModifyMode(java.util.Hashtable detailRecord) {			
		
			
			HashMap hashResult = new HashMap(2);
			hashResult.put("result",new Boolean(false));
		try {
					
			String item_code = (String) detailRecord.get("item_code");
			String editing = (String) detailRecord.get("editing");
			if (editing.equals("1") && itemKeys.contains(item_code)) {
				hashResult.put("message","DUPLICATE_CODE_EXISTS");
				return hashResult;
			}
			
			itemKeysAdded.add(item_code);
			hmItemDetail.put(item_code, new TenderDetailBean(detailRecord));
			hashResult.put("result",new Boolean(true));
			hashResult.put("message","");
		}
		catch (Exception exception) {
			exception.printStackTrace();
			hashResult.put("message",exception.getMessage());
			return hashResult;
		}
		return hashResult;
	}
	
			
public java.util.HashMap insert() {
		HashMap hmResult = new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		ArrayList allanguageData	=	new ArrayList();
		//ArrayList	alInsertDistData=	new ArrayList()	;
		//ArrayList	alInsertSelectedData=	new ArrayList()	;
		ArrayList	alInsertSupplierData=	new ArrayList()	;
		//TenderDetailBean requestDetailBean;
		hmResult.put("result", new Boolean(false));
		ArrayList final_dtl=new ArrayList();
		//ArrayList unf_dtl=new ArrayList();
		//ArrayList po_dtl=new ArrayList();
		//ArrayList po_hdr=new ArrayList();
		//ArrayList delv_sch =new ArrayList();
		//ArrayList delv_sch_no =new ArrayList();
		
		ArrayList bDArrayList ; 
		
		if(hmSupplierRecords.size() > 0){
					
						bDArrayList	=	(ArrayList)hmSupplierRecords.get(0);
						if(bDArrayList.size()>0){

							for (int j=0;j<bDArrayList.size();j++) {
															
								HashMap	hmExpRecord	=	(HashMap)bDArrayList.get(j);
								
									if((hmExpRecord.get("SUPP_CODE") == null) || (hmExpRecord.get("SUPP_CODE").equals(""))) {
										continue;
									}
								 
								ArrayList alInsertBDRecord        =       new ArrayList();
								if(hmExpRecord.get("SELECT_DATA").equals("Y")){ //Added by Rabbani on for validation of Supplier check box 21/06/2013
								alInsertBDRecord.add(getDoc_no()); // TENDER_NO
								alInsertBDRecord.add(hmExpRecord.get("SUPP_CODE")); // SUPP_CODE
								alInsertBDRecord.add(""+(j+1)); //SUPP_SRL_NO
								alInsertBDRecord.add(hmExpRecord.get("CONTACT_PERSON")); //CONTACT_NAME
								alInsertBDRecord.add(hmExpRecord.get("CONTACT_NUMBER")); //TEL_NUM
								alInsertBDRecord.add(hmExpRecord.get("EMAIL_ID")); //EMAIL_ID
								alInsertBDRecord.add(login_by_id);
								alInsertBDRecord.add(login_at_ws_no);
								alInsertBDRecord.add(login_facility_id);
								alInsertBDRecord.add(login_by_id);
								alInsertBDRecord.add(login_at_ws_no);
								alInsertBDRecord.add(login_facility_id);	
								alInsertSupplierData.add(alInsertBDRecord);
								}								
							}	
						}		
				}
						
		
		
		
		final_dtl=(ArrayList)newInsert();
		
		
		ArrayList alHdrInsertRecord = new ArrayList();
				
		alHdrInsertRecord.add(getDoc_no()); //TENDER_NO
		alHdrInsertRecord.add(getRequest_by_pu());//PUR_UNIT_CODE
		alHdrInsertRecord.add(login_facility_id); //FACILITY_ID
		alHdrInsertRecord.add(getTender_type()); // PO_MASTER_CODE
		alHdrInsertRecord.add(getDoc_date_value()); // TENDER_DATE
		alHdrInsertRecord.add(getDoc_ref());  // TENDER_REF
		alHdrInsertRecord.add(getLocal_currency());  //CURRENCY_CODE
		alHdrInsertRecord.add(checkForNull(getTender_remarks()," ")); //TENDER_REMARKS
		alHdrInsertRecord.add(getFinalize_yn().equals("Yes")?"FN":"UN");//TENDER_STATUS
		alHdrInsertRecord.add(getApproval_date());  //APPROVAL_DATE
		alHdrInsertRecord.add(getContract_date());  // CONTRACT_SIGN_DATE
		alHdrInsertRecord.add(getExpiry_date());  //TENDER_EXPIRY_DATE
		
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		
		allanguageData.add(getLanguageId());
		
		java.util.ArrayList alUpdateData = new java.util.ArrayList (4);
		alUpdateData.add(login_by_id);
		alUpdateData.add(login_at_ws_no);
		alUpdateData.add(login_facility_id);
		
		
		
		
				
		hmSQLMap.put("InsertHDRSQL", PoRepository.getPoKeyValue("SQL_TNDR_HDR_INSERT")); 
		hmSQLMap.put("InsertDTLSQL", PoRepository.getPoKeyValue("SQL_TNDR_DTL_INSERT")); 
		hmSQLMap.put("InsertSuppDTLSQL", PoRepository.getPoKeyValue("SQL_TNDR_SUPP_DTL_INSERT")); 
		hmSQLMap.put("UpdateSQL", PoRepository.getPoKeyValue("SQL_UPDATE_NEXT_DOC_NO_IN_DOCNO_CONTROL_FOR_TNDR")); 
		hmSQLMap.put("SQL_PO_DOC_TYPE_SELECT_FLAG_FROM_CONTROL_TABLE",PoRepository.getPoKeyValue("SQL_PO_DOC_TYPE_SELECT_FLAG_FROM_CONTROL_TABLE"));
		

		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertHDRData",alHdrInsertRecord);
		hmTableData.put("UpdateData",alUpdateData);
		hmTableData.put("LANGUAGE_DATA",	allanguageData);
		hmTableData.put("FINAL_DTL",final_dtl);
		hmTableData.put("SUPP_DTL",alInsertSupplierData);
		
		
		
		
		TenderRemote requestRemote = null;

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Tender", TenderHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			
			 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			String ms_id=(String) hmResult.get( "msgid" );
			if(ms_id.equals("CODE_ALREADY_EXISTS") || ms_id.equals("RECORD_INSERTED") || ms_id.equals("RECORD_MODIFIED") || ms_id.equals("RECORD_DELETED") )
			hmResult.put("message",getPOMessage(getLanguageId(),ms_id,"PO") ) ;
			else if(ms_id.equals("DOCNO_NULL")){
				hmResult.put("message","Doc No Null") ;
			}else {
		
			hmResult.put("message","Transcation failed") ;
			}

			ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no") ;  
			setPrintDocNo(doc_no);  
		}
		catch(Exception e) {
				hmResult.put("message", e.toString());
				e.printStackTrace();
		} 
		finally {
			try {
				if(requestRemote != null){}
				//	requestRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString());
			}
		}
	return hmResult;
	}





	public void setAll(Hashtable hashValues) {
	
	
		String keyCode;
		String selectedKey;
        checkedItemKeys.clear();
				
		setTender_type((String)hashValues.get("tender_type"));
		setPo_mode((String)hashValues.get("po_mode"));
		setCurrency_code((String)hashValues.get("currency_code"));
		setExc_rate((String)hashValues.get("exc_rate"));
		setLocal_currency((String)hashValues.get("local_currency"));
		setBlanket_po_yn((String)hashValues.get("blanket_po_yn"));
		setAddi_dist((String)hashValues.get("addi_dist"));
		setGross_poAmt((String)hashValues.get("gross_poAmt"));
		setNet_poAmt((String)hashValues.get("net_poAmt"));
		setValid_upto((String)hashValues.get("valid_upto"));
		setExp_date((String)hashValues.get("exp_date"));
		setOld_po_no((String)hashValues.get("old_po_no"));
		setDoc_no((String)hashValues.get("doc_no"));
		setDoc_date((String)hashValues.get("doc_date"));
		setDoc_ref((String)hashValues.get("doc_ref"));
		setDoc_remarks((String)hashValues.get("doc_remarks"));
		setRequest_by_pu((String)hashValues.get("request_by_pu"));
		setRequest_on_supp((String)hashValues.get("request_on_supp"));
		setFinalize_yn((String)hashValues.get("finalize_yn"));
		java.util.Enumeration hashKeys = hashValues.keys();
		while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("add_itm_")) {
				selectedKey = (String) hashValues.get(keyCode);
				if (selectedKey != null && selectedKey.trim().length()>0) {
					checkedItemKeys.add(selectedKey);
				}
			}
		}
	}
	
	//load Delivery Schedule data
	public ArrayList getDeliveryData(String po_no, String itm_code){
	
	
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			ArrayList alExpRecords = new ArrayList();
			String item_code = "";
			try {
            connection = getConnection();
			
			pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_DELV_SCH_SELECT"));
			
			pstmt.setString(1, po_no);
			pstmt.setString(2, itm_code);
			resultSet = pstmt.executeQuery();
			
				
		while (resultSet != null && resultSet.next()) {
				
			HashMap hmExpRecord	=	new HashMap();
			item_code = resultSet.getString("ITEM_CODE");
					
			hmExpRecord.put("ITEM_CODE",	resultSet.getString("ITEM_CODE"));
			hmExpRecord.put("DELV_QTY",	resultSet.getString("DELV_QTY"));
			hmExpRecord.put("DELV_DATE",	resultSet.getString("DELV_DATE"));
			alExpRecords.add(hmExpRecord);
			

		}
		
			closeResultSet(resultSet);
            closeStatement(pstmt);
		}catch (Exception e) {
            e.printStackTrace();
        }
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es){
				es.printStackTrace();
            }
        }
			
		
		return alExpRecords;
	
	}

//load getSelecionCriteriaData data

	public ArrayList getSelecionCriteriaData(String do_no,String item_code){
	
		
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			ArrayList alExpRecords = new ArrayList();
			//String facility_code = "";
			try {
            connection = getConnection();
			
				pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_QUOT_SELECTION_CRITERIA_SELECT"));
			
				pstmt.setString(1, do_no);
				pstmt.setString(2, item_code);
						
			
			resultSet = pstmt.executeQuery();
			
				
		while (resultSet != null && resultSet.next()) {
				
			HashMap hmExpRecord	=	new HashMap();
			
			hmExpRecord.put("PO_MASTER_CODE",	resultSet.getString("PO_MASTER_CODE"));
			hmExpRecord.put("SELECTED_YN",	resultSet.getString("SELECTED_YN"));
			
			
			alExpRecords.add(hmExpRecord);
			
		
		}
		
			closeResultSet(resultSet);
            closeStatement(pstmt);
		}catch (Exception e) {
            e.printStackTrace();
        }
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es){
				es.printStackTrace();
            }
        }
			
		
		return alExpRecords;
	
	}

//load getSupplierData data

	public ArrayList getSupplierDtlData(String do_no){
	
		
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			ArrayList alExpRecords = new ArrayList();
		//	String facility_code = "";
			try {
            connection = getConnection();
			
				pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_TNDR_SUPP_DTL_SELECT"));
			
				pstmt.setString(1, do_no);
				
			resultSet = pstmt.executeQuery();
			
				
		while (resultSet != null && resultSet.next()) {
				
			HashMap hmExpRecord	=	new HashMap();
			
			hmExpRecord.put("SUPP_CODE",	resultSet.getString("SUPP_CODE"));
			hmExpRecord.put("CONTACT_NAME",	resultSet.getString("CONTACT_NAME"));
			hmExpRecord.put("TEL_NUM",	resultSet.getString("TEL_NUM"));
			hmExpRecord.put("EMAIL_ID",	resultSet.getString("EMAIL_ID"));
			hmExpRecord.put("MODE_DISABLED",	"DISABLED");
			
			alExpRecords.add(hmExpRecord);
			
		
		}
		
			closeResultSet(resultSet);
            closeStatement(pstmt);
		}catch (Exception e) {
            e.printStackTrace();
        }
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es){
				es.printStackTrace();
            }
        }
			
		
		return alExpRecords;
	
	}



	
	public void loadData(String tender_type_code, String tender_no) {
	
	 
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		TenderDetailBean requestDetailBean;
        itemKeysAdded = new java.util.ArrayList();
		try {
            connection = getConnection();
		//load DO hdr data	
          
		    pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_TENDER_HDR_SELECT"));
			
            pstmt.setString(1, login_facility_id);
            pstmt.setString(2, tender_type_code);
            pstmt.setString(3, tender_no);
            resultSet = pstmt.executeQuery();
			
	
            while (resultSet != null && resultSet.next()) {
						
				setRequest_by_pu(resultSet.getString("PUR_UNIT_CODE"));		
				setTender_type(resultSet.getString("PO_MASTER_CODE"));
				setDoc_no(resultSet.getString("TENDER_NO"));
				setDoc_date(resultSet.getString(5));
				setDoc_ref(resultSet.getString("TENDER_REF"));
				setLocal_currency(resultSet.getString("CURRENCY_CODE"));
								
				setTender_remarks(resultSet.getString("REMARKS"));
				setApproval_date(resultSet.getString("APPROVAL_DATE"));
				setContract_date(resultSet.getString("CONTRACT_SIGN_DATE"));
				setExpiry_date(resultSet.getString("TENDER_EXPIRY_DATE"));
				
											
            }
			
			ArrayList al_doc_no = new ArrayList();
			al_doc_no.add(getDoc_no());
			setPrintDocNo(al_doc_no);  
			
			closeResultSet(resultSet);
            closeStatement(pstmt);
			
				
			//load DO dtl data
			allItemKeys = new java.util.ArrayList();
			pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_TENDER_DTL_SELECT"));
			pstmt.setString(1, login_facility_id);
            pstmt.setString(2, tender_type_code);
            pstmt.setString(3, tender_no);
            pstmt.setString(4, getLanguageId());
	
			resultSet = pstmt.executeQuery();
			
			String item_code = "";
            while (resultSet != null && resultSet.next()) {
				requestDetailBean = new TenderDetailBean(resultSet);
				item_code = requestDetailBean.getItem_code() ;
				itemKeys.add(item_code);
				allItemKeys.add(item_code);
				hmItemDetail.put(item_code, requestDetailBean);
				
			
			}
			
			closeResultSet(resultSet);
            closeStatement(pstmt);
			
			
			
			
        }
		catch (Exception e) {
            e.printStackTrace();
        }
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es){
				es.printStackTrace();
            }
        }

	}



	public java.util.HashMap modify() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	alModifyData = new ArrayList();
		//ArrayList	alModifyBillDeliveryData = new ArrayList();
		//ArrayList	alInsertBillDeliveryData = new ArrayList();
		ArrayList	alParams = new ArrayList();
		//ArrayList	alDevyParams = new ArrayList();
		Properties properties = getProperties();
		//ArrayList	alInsertBatchData=	new ArrayList()	;
		ArrayList	alInsertSupplierData=	new ArrayList()	;

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

		hmTableData.put("properties",properties);
		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Initial Message") ;

	//int no_of_decimals					=			getNoOfDecimals();
	//int no_of_decimals_temp				=			getNoOfDecimals();
	//Double dis_perc ;
	
	TenderRemote requestRemote = null;

		try
		{
		connection = getConnection();
		String key = (String) allItemKeys.get(allItemKeys.size()-1);
		TenderDetailBean requestDetailBean = (TenderDetailBean) hmItemDetail.get(key);
		requestDetailBean = null;		
		
		int detailSize = -1;
		alParams.add(getDoc_no());
		
		int detailSizeTemp = Integer.parseInt((String)fetchRecord(getPoRepositoryValue("SQL_TENDER_DTL_MAX_SRL_NO"),alParams).get("LAST_SRL_NO"));

		itemKeysAdded.addAll(reqKeysAdded);
		itemKeysAdded.addAll(reqKeys);
		if (itemKeysAdded != null && itemKeysAdded.size()>0) {
			detailSize		= itemKeysAdded.size();
			ArrayList alInsertRecord = new ArrayList(detailSize);
			for (int index=0;index<detailSize;index++) {
				if((itemKeysAdded.get(index) == null) || (itemKeysAdded.get(index).equals(""))) {
						continue;
				}
			if(checkedItemKeys.contains(itemKeysAdded.get(index))){
				requestDetailBean = (TenderDetailBean) hmItemDetail.get(itemKeysAdded.get(index));
				
				
			ArrayList alInsertDtlRecord = new ArrayList();
			
			
			alInsertDtlRecord.add(getDoc_no());//TENDER_NO	
			alInsertDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE	
				
			if(requestDetailBean.getSrl_no()==-1 || requestDetailBean.getSrl_no()==0)
				alInsertDtlRecord.add(""+(++detailSizeTemp));
				else
				alInsertDtlRecord.add(""+(requestDetailBean.getSrl_no()));
			
						
			alInsertDtlRecord.add(requestDetailBean.getTender_qty());//TENDER_QTY
			alInsertDtlRecord.add(requestDetailBean.getTender_uom_code());//TENDER_UOM
		//	alInsertDtlRecord.add(requestDetailBean.getConvFact());//GEN_UOM_CONV_FACTOR
			alInsertDtlRecord.add(checkForNull(requestDetailBean.getTender_price()));//TENDER_PRICE
			alInsertDtlRecord.add(checkForNull(requestDetailBean.getNet_amount()));  //NET_AMOUNT 
			alInsertDtlRecord.add(checkForNull(requestDetailBean.getTrade_id())); //TRADE_ID
			alInsertDtlRecord.add(getFinalize_yn().equals("Yes")?"FN":"UN");//ITEM_STATUS
			alInsertDtlRecord.add(requestDetailBean.getItem_remarks()); //ITEM_REMARKS
			
			alInsertDtlRecord.add(login_by_id);
			alInsertDtlRecord.add(login_at_ws_no);
			alInsertDtlRecord.add(login_facility_id);
			alInsertDtlRecord.add(login_by_id);
			alInsertDtlRecord.add(login_at_ws_no);
			alInsertDtlRecord.add(login_facility_id);
						
			alInsertRecord.add(alInsertDtlRecord);	
					
					
				
			}
			}
			hmTableData.put("InsertDTLData",alInsertRecord);
			hmSQLMap.put("InsertDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_TNDR_DTL_INSERT"));
		}
		
							
		detailSize = checkedItemKeys.size();
		requestDetailBean = null;
		ArrayList alUpdateRecord = new ArrayList(detailSize);
		for (int index=0;index<detailSize;index++) {
			if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) {
					continue;
			}
			requestDetailBean = (TenderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
			ArrayList alUpdateDtlRecord = new ArrayList();
	

			alUpdateDtlRecord.add(requestDetailBean.getTender_qty());//TENDER_QTY
			alUpdateDtlRecord.add(requestDetailBean.getTender_uom_code());//TENDER_UOM
		//	alUpdateDtlRecord.add(requestDetailBean.getConvFact());//GEN_UOM_CONV_FACTOR
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getTender_price()));//TENDER_PRICE
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getNet_amount()));  //NET_AMOUNT 
			alUpdateDtlRecord.add(getFinalize_yn().equals("Yes")?"FN":"UN");//ITEM_STATUS
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getTrade_id())); //TRADE_ID
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getItem_remarks())); //ITEM_REMARKS
						
			alUpdateDtlRecord.add(login_by_id);
			alUpdateDtlRecord.add(login_at_ws_no);
			alUpdateDtlRecord.add(login_facility_id);
			alUpdateDtlRecord.add(getDoc_no());
			alUpdateDtlRecord.add(""+requestDetailBean.getSrl_no());
			
			alUpdateRecord.add(alUpdateDtlRecord);
			
			
			
		}
		hmTableData.put("UpdateDTLData",alUpdateRecord);
		hmSQLMap.put("UpdateDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_TENDER_DTL_UPDATE"));
	
 	
	
		detailSize = -1;
		if (allItemKeys != null && allItemKeys.size() > 0) {
			allItemKeys.removeAll(checkedItemKeys);
			if (allItemKeys.size() >0) {
				detailSize = allItemKeys.size();
				ArrayList alDeleteRecord = new ArrayList(detailSize);
				for (int index=0;index<detailSize;index++) {
					if((allItemKeys.get(index) == null) || (allItemKeys.get(index).equals(""))) 
							continue;
					requestDetailBean = (TenderDetailBean) hmItemDetail.get(allItemKeys.get(index));
					ArrayList alDeleteDtlRecord = new ArrayList(4);
					
					alDeleteDtlRecord.add(getDoc_no());
					alDeleteDtlRecord.add(""+requestDetailBean.getSrl_no());
					alDeleteRecord.add(alDeleteDtlRecord);
				}
				
				hmTableData.put("DeleteDTLData",alDeleteRecord);
				hmSQLMap.put("DeleteDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_TENDER_DTL_MODIFY_DELETE"));
			
			}
		}

	

		//Get the maximum serial no
				
		alModifyData.add(getDoc_date_value()); // TENDER_DATE
		alModifyData.add(getDoc_ref());  // TENDER_REF
		alModifyData.add(getCurrency_code());//CURRENCY_CODE
		alModifyData.add(getTender_remarks());  // REMARKS	
		alModifyData.add(getFinalize_yn().equals("Yes")?"FN":"UN");//TENDER_STATUS
		alModifyData.add(getApproval_date()); //APPROVAL_DATE
		alModifyData.add(getContract_date()); //CONTRACT_SIGN_DATE
		alModifyData.add(getExpiry_date()); //TENDER_EXPIRY_DATE
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id);
				
		alModifyData.add(login_facility_id); //FACILITY_ID
		alModifyData.add(getTender_type()); // PO_MASTER_CODE
		alModifyData.add(getDoc_no()); //TENDER_NO
		
	
		
		hmTableData.put("UpdateData",alModifyData);
		hmSQLMap.put("UpdateSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_TENDER_HDR_UPDATE"));
		
		
		//start supplier details
			
		// delete exisiting record from PO_TENDER_SUPPL
		
		ArrayList evalDeleteRecord = new ArrayList();
		ArrayList evalArrayList;
		if (hmSupplierRecords.size() >0) {
				evalArrayList	=	(ArrayList)hmSupplierRecords.get(0);
				if(evalArrayList.size() > 0){
					/*for(int j=0;j<evalArrayList.size();j++){ commented by Ganga
						HashMap	hmExpRecord	=	(HashMap)evalArrayList.get(j);
						ArrayList alDeleteDtlRecord = new ArrayList();
						alDeleteDtlRecord.add(getDoc_no());  //TENDER_NO
						alDeleteDtlRecord.add(hmExpRecord.get("SUPP_CODE"));  //SUPP_CODE 
						evalDeleteRecord.add(alDeleteDtlRecord);
					}	*/
					ArrayList alDeleteDtlRecord = new ArrayList();
					alDeleteDtlRecord.add(getDoc_no());  //TENDER_NO
					evalDeleteRecord.add(alDeleteDtlRecord);					
				}
				
				hmTableData.put("DeleteSUPPData",evalDeleteRecord);
				hmSQLMap.put("DeleteSUPPSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_TENDER_SUPP_DTL_MODIFY_DELETE"));
			
		}
		
		
		
		// end
		
			
		//start for supplier list insert
	
	try{
	
		ArrayList bDArrayList ; 
		
		if(hmSupplierRecords.size() > 0){
					
						bDArrayList	=	(ArrayList)hmSupplierRecords.get(0);
						if(bDArrayList.size()>0){

							for (int j=0;j<bDArrayList.size();j++) {
															
								HashMap	hmExpRecord	=	(HashMap)bDArrayList.get(j);
								
									if((hmExpRecord.get("SUPP_CODE") == null) || (hmExpRecord.get("SUPP_CODE").equals(""))) {
										continue;
									}
								 
								ArrayList alInsertBDRecord        =       new ArrayList();
								if(hmExpRecord.get("SELECT_DATA").equals("Y")){ //Added by Rabbani on for validation of Supplier check box 21/06/2013
								alInsertBDRecord.add(getDoc_no()); // TENDER_NO
								alInsertBDRecord.add(hmExpRecord.get("SUPP_CODE")); // SUPP_CODE
								alInsertBDRecord.add(""+(j+1)); //SUPP_SRL_NO
								alInsertBDRecord.add(hmExpRecord.get("CONTACT_PERSON")); //CONTACT_NAME
								alInsertBDRecord.add(hmExpRecord.get("CONTACT_NUMBER")); //TEL_NUM
								alInsertBDRecord.add(hmExpRecord.get("EMAIL_ID")); //EMAIL_ID
								alInsertBDRecord.add(login_by_id);
								alInsertBDRecord.add(login_at_ws_no);
								alInsertBDRecord.add(login_facility_id);
								alInsertBDRecord.add(login_by_id);
								alInsertBDRecord.add(login_at_ws_no);
								alInsertBDRecord.add(login_facility_id);	
								alInsertSupplierData.add(alInsertBDRecord);
								}								
							}	
						}		
				}
			
		}catch(Exception e){
			e.printStackTrace();			
		}

		hmTableData.put("InsertSUPPData",alInsertSupplierData);
		hmSQLMap.put("InsertSUPPSQL", PoRepository.getPoKeyValue("SQL_TNDR_SUPP_DTL_INSERT")); 
	
	
	//end for evaluation factor  insert
		
		
			
	
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Tender",TenderHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); ;
		paramArray[1] = hmSQLMap.getClass();

		hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		hmResult.put("message", getPOMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"PO") ) ;

		} 
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString()) ;
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(requestRemote != null)
				//	requestRemote.remove() ;
				closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
			}
			catch(Exception ee) {
				ee.printStackTrace();
				hmResult.put("message", ee.toString()) ;
			}
		}
	
		return hmResult;
}

public ArrayList newUNFDOInsert() {
		
		DeliveryOrderDetailBean requestDetailBean;
		//java.util.ArrayList alUpdateItemData = new ArrayList();
		int detailSize = checkedItemKeys.size();
		ArrayList alDtlInsertRecord = new ArrayList(detailSize);
		//int no_of_decimals					=			getNoOfDecimals();
		//int no_of_decimals_temp				=			getNoOfDecimals();
		try{
	
	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (DeliveryOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
				
			ArrayList alDtlRecord = new ArrayList();
			
				
			
				
				alDtlRecord.add(getDoc_no());//DO_NO
				alDtlRecord.add(requestDetailBean.getPo_no());//PO_NO
				alDtlRecord.add(requestDetailBean.getDelv_date());  //SCH_DELV_DATE 
				alDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
				alDtlRecord.add(requestDetailBean.getDelivery_qty());//BLOCKED_QTY
				alDtlRecord.add(login_by_id);
				alDtlRecord.add(login_at_ws_no);
				alDtlRecord.add(login_facility_id);
				alDtlRecord.add(login_by_id);
				alDtlRecord.add(login_at_ws_no);
				alDtlRecord.add(login_facility_id);
			
				alDtlInsertRecord.add(alDtlRecord);		
					
		}
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alDtlInsertRecord;
	}

public ArrayList newInsert() {
		
		TenderDetailBean requestDetailBean;
		//java.util.ArrayList alUpdateItemData = new ArrayList();
		int detailSize = checkedItemKeys.size();
		ArrayList alDtlInsertRecord = new ArrayList(detailSize);
		//int no_of_decimals					=			getNoOfDecimals();
		//int no_of_decimals_temp				=			getNoOfDecimals();
		//Double dis_perc;
		try{
	
		java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (TenderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
				
			ArrayList alDtlRecord = new ArrayList();
			
			alDtlRecord.add(getDoc_no());//TENDER_NO	
			alDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE	
			alDtlRecord.add(""+(index+1));//TENDER_SRL_NO
			alDtlRecord.add(requestDetailBean.getTender_qty());//TENDER_QTY
			alDtlRecord.add(requestDetailBean.getTender_uom_code());//TENDER_UOM
		//	alDtlRecord.add(requestDetailBean.getConvFact());//GEN_UOM_CONV_FACTOR
			alDtlRecord.add(requestDetailBean.getTender_price());//TENDER_PRICE
			alDtlRecord.add(requestDetailBean.getNet_amount());  //NET_AMOUNT
			alDtlRecord.add(requestDetailBean.getTrade_id());  //TRADE_ID			
			alDtlRecord.add(getFinalize_yn().equals("Yes")?"FN":"UN");//ITEM_STATUS
			alDtlRecord.add(requestDetailBean.getItem_remarks()); //ITEM_REMARKS
			
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			alDtlInsertRecord.add(alDtlRecord);		
					
		}
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alDtlInsertRecord;
	}
	
	
		public void setPoItemDetails(HashMap PoItemDetails){
		this.PoItemDetails = PoItemDetails;
	}

	public ArrayList getPoItemDetails(String po_number){
		return (ArrayList)PoItemDetails.get(po_number);
	}

	public HashMap getPoItemDetails(){
		return PoItemDetails;
	}
	 
	public java.util.HashMap addDetailRecordNew(java.util.HashMap detailRecord) {
		
			java.util.HashMap hashResult = new java.util.HashMap(2);
			hashResult.put("result",new Boolean(false));
	
		// Logic which adds the record 
		String itemcode_reqno = (String) detailRecord.get("ITEMCODE_REQNO");
		String editing = (String) detailRecord.get("editing");
		//String trans_currency = (String) detailRecord.get("TRANS_CURRENCY");
		

		if (editing.equals("1") && reqKeys.contains(itemcode_reqno)) {
			hashResult.put("message","DUPLICATE_CODE_EXISTS");
			return hashResult;
		}
	
		else if (editing.equals("1")) {
			
			reqKeys.add(itemcode_reqno);
			
			
		}
		
		
		hmItemDetail.put(itemcode_reqno, new TenderDetailBean(detailRecord));
		hashResult.put("result",new Boolean(true));
		hashResult.put("message","");
		return hashResult;
	}
	
public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{
		
		/*
		ecis.utils.OnlineReports onlineReports 	= null;
		ecis.utils.OnlineReport report2 = null;

			if((prescriptionPrint.toUpperCase()).equals("Y")){
				onlineReports 	= new ecis.utils.OnlineReports() ;
				report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPRS_IP") ;
				report2.addParameter("p_facility_id", login_facility_id) ;
				report2.addParameter("p_module_id", "PH") ;
				report2.addParameter("p_report_id", "PHBOPPRS_IP") ;
				report2.addParameter("p_fm_order_id", (String)all_orders.get(0)) ;
				report2.addParameter("p_to_order_id", (String)all_orders.get(all_orders.size()-1)) ;
				report2.addParameter("p_locncode", locn_code) ;
				report2.addParameter("p_patclass", patient_class) ;
				report2.addParameter("p_user_name", login_by_id) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				onlineReports.add( report2) ;
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
			}
		*/
			
			
           
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				report2= new ecis.utils.OnlineReport( login_facility_id, "PO", "POBDELVORD") ;
				report2.addParameter("p_facility_id", login_facility_id) ;
				report2.addParameter("p_module_id", "PO") ;
				report2.addParameter("p_report_id", "POBDELVORD") ;
				report2.addParameter("p_user_name", login_by_id) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				onlineReports.add( report2) ;
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
			
		/*   
			String reportid = "PODELVORD";

			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","PO");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_finalized_yn",getFinalize_yn().substring(0,1));
		
			System.out.println("hmReportParameter"+hmReportParameter);
		
			PgetPu_codepo = getRequest_by_pu();
			
			
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());

			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetPu_codepo);
			System.out.println("hmParameters in bean = "+hmParameters);
		   new ePO.Common.ReportCallerThread(getURLString(hmParameters)).start();
		  */ 

		 }
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}

public java.util.HashMap delete() {
        HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	alDeleteData = new ArrayList();
		Properties properties = getProperties();
		Connection connection = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        ResultSet resultSet = null;
		int cnt = 0;

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Delete Mode") ;

		
		try {
			alDeleteData.add(getDoc_no());
			cnt = Integer.parseInt((String)fetchRecord(getPoRepositoryValue("SQL_TENDER_SUPP_DTL_COUNT"),getDoc_no()).get("COUNT"));
						
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	
		
		hmTableData.put("properties",properties);
		hmTableData.put("DeleteHDRData",alDeleteData);
		hmTableData.put("DeleteDTLData",alDeleteData);

		hmSQLMap.put("DeleteHDRSQL",ePO.Common.PoRepository.getPoKeyValue("SQL_TENDER_HDR_DELETE"));
		hmSQLMap.put("DeleteDTLSQL",ePO.Common.PoRepository.getPoKeyValue("SQL_TENDER_DTL_DELETE"));	
		
		if(cnt > 0){	
			hmTableData.put("DeleteSUPPDTLData",alDeleteData);
			hmSQLMap.put("DeleteSUPPDTLSQL",ePO.Common.PoRepository.getPoKeyValue("SQL_TENDER_SUPP_DTL_DELETE"));
		}	
				
		
		TenderRemote requestRemote = null;
		try {
				
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/Tender",TenderHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			 hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		hmResult.put("message",getPOMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"PO") ) ;
	
		}catch(Exception e) {
			hmResult.put("message", e.toString()) ;
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(requestRemote != null)
				//	requestRemote.remove() ;
				closeResultSet(resultSet);
                closeStatement(pstmt);
                closeStatement(pstmt1);
                closeConnection(connection);
			}
			catch(Exception ee) {
				ee.printStackTrace();
				hmResult.put("message", ee.toString()) ;
			}
		}
		return hmResult;
    }

	public java.util.HashMap canAuthorize(String purchase_unit) { 
		try {
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(getLoginById());
			sqlParameter.add(purchase_unit);
			return fetchRecord(getPoRepositoryValue("SQL_PO_TENDER_USER_ACCESS_ALLOW_AUTHORIZE_SELECT"),sqlParameter);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	public void updateDeliveryRecords(String item_code, Hashtable htExpRecords){
	
		ArrayList alExpRecords = new ArrayList();

		for (int i=0;i<Integer.parseInt((String)htExpRecords.get("totalRecords")); i++) {

			if(((String)htExpRecords.get("delivery_qty_"+i) == null) || (htExpRecords.get("delivery_qty_"+i).equals(""))) 
			continue;

			HashMap hmExpRecord	=	new HashMap();
			
			hmExpRecord.put("ITEM_CODE",	htExpRecords.get("item_code"));
			hmExpRecord.put("FACILITY_CODE",	htExpRecords.get("facility_id_"+i));
			hmExpRecord.put("STORE_CODE",	htExpRecords.get("req_store_code_"+i));
			hmExpRecord.put("DELV_QTY",	htExpRecords.get("delivery_qty_"+i));
			hmExpRecord.put("FREE_QTY",	htExpRecords.get("free_qty_"+i));
			hmExpRecord.put("SAMPLE_QTY",	htExpRecords.get("sample_qty_"+i));
			hmExpRecord.put("DELV_UOM",	htExpRecords.get("delivery_uom_"+i));
			hmExpRecord.put("DELV_PRICE",	htExpRecords.get("delivery_price_"+i));
			hmExpRecord.put("DIST_CONV_FACT",	htExpRecords.get("dist_conv_fact_"+i));
			
			alExpRecords.add(hmExpRecord);

			
		}

		
			setExpRecords(item_code, alExpRecords);
	}

	public void setExpRecords(String item_code, ArrayList alExpRecord){
		hmExpRecords.put(item_code,alExpRecord);
	}

	public ArrayList getExpRecords(String item_code){
		return (ArrayList)hmExpRecords.get(item_code);
	}
	public HashMap getExpRecords(){
		return hmExpRecords;
	}
	
	public java.util.HashMap addItemDetailRecordNew(java.util.HashMap detailRecord) {
	
			java.util.HashMap hashResult = new java.util.HashMap(2);
			hashResult.put("result",new Boolean(false));
	
		// Logic which adds the record 
		String item_code = (String) detailRecord.get("ITEM_CODE");
		//	String editing = (String) detailRecord.get("editing");
	//	String trans_currency = (String) detailRecord.get("TRANS_CURRENCY");
		

/*		if (editing.equals("1") && reqKeys.contains(itemcode_reqno)) {
			hashResult.put("message","DUPLICATE_CODE_EXISTS");
			return hashResult;
		}
	
		else if (editing.equals("1")) {
			System.out.println("editing in po bean = "+editing);
			reqKeys.add(itemcode_reqno);
			System.out.println("reqKeys in po bean = "+reqKeys);
			
		}
	*/	
		
		
		hmItemDetail.put(item_code, new TenderDetailBean(detailRecord));
		hashResult.put("result",new Boolean(true));
		hashResult.put("message","");
		return hashResult;
	}
	
public void updateSelectionCriteriaRecords(String item_code, Hashtable htExpRecords){
	
		ArrayList alExpRecords = new ArrayList();
		//hash in SETSELECTIONCRITERIAVALUES =  {finalize_yn=No, selected_status_1=N, selected_status_0=Y, do_sample_qty=null, do_delivery_price=null, tot_qty=null, language_id=en, item_code=AMBRO1, bean_id=quotationBean, sample_qty=, master_code_1=jjjj, mode=1, master_code_0=dfg, totalRecords=2, Ok=  Ok  , do_free_qty=null, function_id=PO_QUOTATION, req_facility_id=, free_qty=, bean_name=ePO.QuotationBean, delivery_qty=}

		for (int i=0;i<Integer.parseInt((String)htExpRecords.get("totalRecords")); i++) {

			
			if(((String)htExpRecords.get("master_code_"+i) == null) || (htExpRecords.get("master_code_"+i).equals(""))) 
			continue;
			
			HashMap hmExpRecord	=	new HashMap();
			
			hmExpRecord.put("ITEM_CODE",	htExpRecords.get("item_code"));
			hmExpRecord.put("MASTER_CODE",	htExpRecords.get("master_code_"+i));
			hmExpRecord.put("SELECTION_STATUS",	htExpRecords.get("selection_status_"+i));
		
			
			alExpRecords.add(hmExpRecord);

			
		}

		
			setSelectionCriteriaRecords(item_code, alExpRecords);
	}

	public void setSelectionCriteriaRecords(String item_code, ArrayList alExpRecord){
		hmSelectionCriteriaRecords.put(item_code,alExpRecord);
	}

	public ArrayList getSelectionCriteriaRecords(String item_code){
		return (ArrayList)hmSelectionCriteriaRecords.get(item_code);
	}
	public HashMap getSelectionCriteriaRecords(){
		return hmSelectionCriteriaRecords;
	}

public void updateSupplierRecords(Hashtable htBtDRecords){
	
	
		
		ArrayList alExpRecords = new ArrayList();
		int idx = 0;
		
		for (int i=0;i<Integer.parseInt((String)htBtDRecords.get("total_Records")); i++) {
			
			if(((String)htBtDRecords.get("supp_code_"+i)).equals(""))
				continue;

			HashMap hmExpRecord	=	new HashMap();
			//if(((String)htBtDRecords.get("Select_supp_"+i)).equals("Y")){
			hmExpRecord.put("SUPP_CODE",	htBtDRecords.get("supp_code_"+i));
			hmExpRecord.put("CONTACT_PERSON",			htBtDRecords.get("contact_person_"+i));
			hmExpRecord.put("CONTACT_NUMBER",		htBtDRecords.get("contact_number_"+i));
			hmExpRecord.put("EMAIL_ID",		htBtDRecords.get("email_id_"+i));
			hmExpRecord.put("SELECT_DATA",		checkForNull((String)htBtDRecords.get("Select_supp_"+i),"N"));
			hmExpRecord.put("MODE_DISABLED",		checkForNull((String)htBtDRecords.get("mode_disabled_"+i)));

			alExpRecords.add(hmExpRecord);
           //}
			
		}
			if(alExpRecords!= null && alExpRecords.size()>0)
				setSuppRecords(idx, alExpRecords);
	}


	public void setSuppRecords(int idx,ArrayList alExpRecord){
		hmSupplierRecords.put(idx,alExpRecord);
	}

	public ArrayList getSuppRecords(int idx){
		return (ArrayList)hmSupplierRecords.get(idx);
	}
	public HashMap getSuppRecords(){
		return hmSupplierRecords;
	}
	
	
	
public void updateItemRecords(String item_code, Hashtable htExpRecords){
	
		
		ArrayList alExpRecords = new ArrayList();

			HashMap hmExpRecord	=	new HashMap();
			
			hmExpRecord.put("ITEM_CODE",	htExpRecords.get("item_code"));
			hmExpRecord.put("DELV_FREQ_TYPE",	htExpRecords.get("delv_freq_type"));
			hmExpRecord.put("FIRST_DELV_DT",	htExpRecords.get("first_delv_date"));
			hmExpRecord.put("NO_OF_DELV",	htExpRecords.get("no_of_delv"));
			hmExpRecord.put("EQ_SHIPMENT",	htExpRecords.get("eq_shipment"));
			hmExpRecord.put("CATALOGUE_NO",	htExpRecords.get("catalogue_no")); 
			hmExpRecord.put("ITEM_REMARKS",	htExpRecords.get("item_remarks")); 
			hmExpRecord.put("ORIGIN_COUNTRY",	htExpRecords.get("origin_country"));
			hmExpRecord.put("SAMPLE_QTY",	htExpRecords.get("sample_qty"));
			hmExpRecord.put("SAMPLE_TYPE",	htExpRecords.get("sample_type"));
			hmExpRecord.put("MANUFACTURER_ID",	htExpRecords.get("manufactur_id"));
			hmExpRecord.put("TRADE_ID",	htExpRecords.get("trade_id"));
			hmExpRecord.put("REPLACE_TYPE",	htExpRecords.get("replace_type"));
			hmExpRecord.put("ITEM_SPECIFICATION",	htExpRecords.get("item_specification"));
			
			
			
			
			alExpRecords.add(hmExpRecord);

			
			setItemRecords(item_code, alExpRecords);
	}

	public void setItemRecords(String item_code, ArrayList alExpRecord){
		hmBatchRecords.put(item_code,alExpRecord);
	}

	public ArrayList getItemRecords(String item_code){
		return (ArrayList)hmBatchRecords.get(item_code);
	}
	public HashMap getItemRecords(){
		return hmBatchRecords;
	}
		
	
	
// Update DO_BLOCKED_QTY in PO_ORDER_DELV_SCH

public ArrayList newPODelvSchUpdateNO() {
		
		DeliveryOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alPODelvUpdateRecord = new ArrayList(detailSize);
	try{

	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (DeliveryOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
				
			ArrayList alPODelvRecord = new ArrayList();
			
			if(requestDetailBean.getPo_no() != null && requestDetailBean.getPo_no() != ""){
			
			alPODelvRecord.add(getDoc_no()); //DO_NO
						
			if(requestDetailBean.getDelivery_qty() != null && requestDetailBean.getDelivery_qty() != ""){			
				alPODelvRecord.add(requestDetailBean.getDelivery_qty());//DELIVERED_QTY
			}else{
				alPODelvRecord.add(requestDetailBean.getOrder_qty());//DELIVERED_QTY
			}
			
			
			alPODelvRecord.add(login_by_id);
			alPODelvRecord.add(login_at_ws_no);
			alPODelvRecord.add(login_facility_id);
			alPODelvRecord.add(requestDetailBean.getItem_code());
			alPODelvRecord.add(requestDetailBean.getPo_no());
			alPODelvRecord.add(""+requestDetailBean.getPo_srl_no());
			alPODelvRecord.add(""+requestDetailBean.getDelv_srl_no());
			alPODelvRecord.add(requestDetailBean.getDelv_date());
			alPODelvUpdateRecord.add(alPODelvRecord);
			}
			
			}	
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alPODelvUpdateRecord;
	}

// Update DO_BLOCKED_QTY in PO_ORDER_DELV_SCH

public ArrayList newPODelvSchUpdateNOModify() {
		
		DeliveryOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alPODelvUpdateRecord = new ArrayList(detailSize);
	try{

	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (DeliveryOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
				
			ArrayList alPODelvRecord = new ArrayList();
			ArrayList alQtyRecord = new ArrayList();
			String prev_do_qty = "";
			if(requestDetailBean.getPo_no() != null && requestDetailBean.getPo_no() != ""){
				if(requestDetailBean.getRequest_no() != null && requestDetailBean.getRequest_no() != ""){
					alQtyRecord.add(getDoc_no());
					alQtyRecord.add(requestDetailBean.getPo_no());
					alQtyRecord.add(requestDetailBean.getItem_code());
					alQtyRecord.add(requestDetailBean.getRequest_no());
					alQtyRecord.add(requestDetailBean.getDelv_date());
					 prev_do_qty = checkForNull((String)fetchRecord(getPoRepositoryValue("SQL_DO_DTL_SELECT_QTY"),alQtyRecord).get("DO_QTY"),"0");
					
				}else{
					alQtyRecord.add(getDoc_no());
					alQtyRecord.add(requestDetailBean.getPo_no());
					alQtyRecord.add(requestDetailBean.getItem_code());
				//	alQtyRecord.add(requestDetailBean.getRequest_no());
					alQtyRecord.add(requestDetailBean.getDelv_date());
					 prev_do_qty = checkForNull((String)fetchRecord(getPoRepositoryValue("SQL_DO_DTL_SELECT_QTY_REQ_NO_NULL"),alQtyRecord).get("DO_QTY"),"0");
					
				}		
			
		//	String prev_do_qty = checkForNull((String)fetchRecord(getPoRepositoryValue("SQL_DO_DTL_SELECT_QTY"),alQtyRecord).get("DO_QTY"),"0");
		//	System.out.println("prev_do_qty in modify do bean= "+prev_do_qty);
			
			
			alPODelvRecord.add(getDoc_no()); //DO_NO
			alPODelvRecord.add(prev_do_qty);//prev_do_qty			
			alPODelvRecord.add(requestDetailBean.getDelivery_qty());//DELIVERED_QTY
			
			
			alPODelvRecord.add(login_by_id);
			alPODelvRecord.add(login_at_ws_no);
			alPODelvRecord.add(login_facility_id);
			alPODelvRecord.add(requestDetailBean.getItem_code()); 
			alPODelvRecord.add(requestDetailBean.getPo_no());
			alPODelvRecord.add(""+requestDetailBean.getPo_srl_no());
		//	alPODelvRecord.add(""+requestDetailBean.getDelv_srl_no());
			alPODelvRecord.add(requestDetailBean.getDelv_date());
			alPODelvUpdateRecord.add(alPODelvRecord);
			}
			
			}	
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alPODelvUpdateRecord;
	}

	
	

// Update DELIVERED_QTY in PO_ORDER_DELV_SCH

public ArrayList newPODelvSchUpdateModify() {
		
		DeliveryOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alPODelvUpdateRecord = new ArrayList(detailSize);
	try{

	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (DeliveryOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
			ArrayList alPODelvRecord = new ArrayList();
			ArrayList alQtyRecord = new ArrayList();
			String prev_do_qty = "";
			if(requestDetailBean.getPo_no() != null && requestDetailBean.getPo_no() != ""){
				if(requestDetailBean.getRequest_no() != null && requestDetailBean.getRequest_no() != ""){
					alQtyRecord.add(getDoc_no());
					alQtyRecord.add(requestDetailBean.getPo_no());
					alQtyRecord.add(requestDetailBean.getItem_code());
					alQtyRecord.add(requestDetailBean.getRequest_no());
					alQtyRecord.add(requestDetailBean.getDelv_date());
					 prev_do_qty = checkForNull((String)fetchRecord(getPoRepositoryValue("SQL_DO_DTL_SELECT_QTY"),alQtyRecord).get("DO_QTY"),"0");
					
				}else{
					alQtyRecord.add(getDoc_no());
					alQtyRecord.add(requestDetailBean.getPo_no());
					alQtyRecord.add(requestDetailBean.getItem_code());
				//	alQtyRecord.add(requestDetailBean.getRequest_no());
					alQtyRecord.add(requestDetailBean.getDelv_date());
					 prev_do_qty = checkForNull((String)fetchRecord(getPoRepositoryValue("SQL_DO_DTL_SELECT_QTY_REQ_NO_NULL"),alQtyRecord).get("DO_QTY"),"0");
					
				}
						
			//String prev_do_qty = checkForNull((String)fetchRecord(getPoRepositoryValue("SQL_DO_DTL_SELECT_QTY"),alQtyRecord).get("DO_QTY"),"0");
			//System.out.println("prev_do_qty in modify do bean= "+prev_do_qty);
			
			alPODelvRecord.add(getDoc_no()); //DO_NO
						
			if(Integer.parseInt(requestDetailBean.getDelivery_qty()) < Integer.parseInt(requestDetailBean.getOrder_qty())){
				alPODelvRecord.add("PD");
			}else{
				alPODelvRecord.add("FD");
			}
			
			alPODelvRecord.add(requestDetailBean.getDelivery_qty());//DELIVERED_QTY
			alPODelvRecord.add(prev_do_qty);//DO_BLOCKED_QTY
			
			alPODelvRecord.add(login_by_id);
			alPODelvRecord.add(login_at_ws_no);
			alPODelvRecord.add(login_facility_id);
			alPODelvRecord.add(requestDetailBean.getItem_code());
			alPODelvRecord.add(requestDetailBean.getPo_no());
			alPODelvRecord.add(""+requestDetailBean.getPo_srl_no());
		//	alPODelvRecord.add(""+requestDetailBean.getDelv_srl_no());
			alPODelvRecord.add(requestDetailBean.getDelv_date());
			alPODelvUpdateRecord.add(alPODelvRecord);
			}
			
			}	
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alPODelvUpdateRecord;
	}
	

// Update DELIVERED_QTY in PO_ORDER_DELV_SCH

public ArrayList newPODelvSchUpdate() {
		
		DeliveryOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alPODelvUpdateRecord = new ArrayList(detailSize);
	try{

//		java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (DeliveryOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
			ArrayList alPODelvRecord = new ArrayList();
			
			
			if(requestDetailBean.getPo_no() != null && requestDetailBean.getPo_no() != ""){
			
			
			alPODelvRecord.add(getDoc_no()); //DO_NO
			
		if(requestDetailBean.getDelivery_qty() != null && requestDetailBean.getDelivery_qty() != ""){
				
			if(Integer.parseInt(requestDetailBean.getDelivery_qty()) < Integer.parseInt(requestDetailBean.getOrder_qty())){
				alPODelvRecord.add("PD");
			}else{
				alPODelvRecord.add("FD");
			}
			
			alPODelvRecord.add(requestDetailBean.getDelivery_qty());//DELIVERED_QTY
		}else{
		
			if(Integer.parseInt(requestDetailBean.getOrder_qty()) < Integer.parseInt(requestDetailBean.getOrder_qty())){
				alPODelvRecord.add("PD");
			}else{
				alPODelvRecord.add("FD");
			}
			
			alPODelvRecord.add(requestDetailBean.getOrder_qty());//DELIVERED_QTY
		}
						
			alPODelvRecord.add(login_by_id);
			alPODelvRecord.add(login_at_ws_no);
			alPODelvRecord.add(login_facility_id);
			alPODelvRecord.add(requestDetailBean.getItem_code());
			alPODelvRecord.add(requestDetailBean.getPo_no());
			alPODelvRecord.add(""+requestDetailBean.getPo_srl_no());
			alPODelvRecord.add(""+requestDetailBean.getDelv_srl_no());
			alPODelvRecord.add(requestDetailBean.getDelv_date());
			alPODelvUpdateRecord.add(alPODelvRecord);
			}
			
			}	
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alPODelvUpdateRecord;
	}
	


	
// Update PO_ORDER_FCY_DTL  Record

public ArrayList newPODtlUpdate() {
		
		DeliveryOrderDetailBean requestDetailBean;
		//DeliveryOrderDetailBean requestDetailBean1;
		int detailSize = checkedItemKeys.size();
		//ArrayList alPODtlItem = new ArrayList();
		ArrayList alPODtlUpdateRecord = new ArrayList(detailSize);
	try{

	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (DeliveryOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
			
			ArrayList alPODtlRecord = new ArrayList();
			
			if(requestDetailBean.getPo_no() != null && requestDetailBean.getPo_no() != ""){
			
			String delv_qty = (String)fetchRecord("select SUM(DELV_QTY) delv_qty from PO_ORDER_DELV_SCH where po_no= ? and item_code= ? " ,new String[]{requestDetailBean.getPo_no(),requestDetailBean.getItem_code()}).get("DELV_QTY");
			
		if(requestDetailBean.getDelivery_qty() != null && requestDetailBean.getDelivery_qty() != ""){
		
			if(Integer.parseInt(requestDetailBean.getDelivery_qty()) < Integer.parseInt(delv_qty)){
				alPODtlRecord.add("PD");
			}else{
				alPODtlRecord.add("FD");
			}
			
			alPODtlRecord.add(requestDetailBean.getDelivery_qty());//DELIVERED_QTY
		}else{
		
			if(Integer.parseInt(requestDetailBean.getOrder_qty()) < Integer.parseInt(delv_qty)){
				alPODtlRecord.add("PD");
			}else{
				alPODtlRecord.add("FD");
			}
			
			alPODtlRecord.add(requestDetailBean.getOrder_qty());//DELIVERED_QTY
		}		
			
			
			alPODtlRecord.add(login_by_id);
			alPODtlRecord.add(login_at_ws_no);
			alPODtlRecord.add(login_facility_id);
			alPODtlRecord.add(requestDetailBean.getItem_code());
			alPODtlRecord.add(requestDetailBean.getPo_no());
			alPODtlRecord.add(""+requestDetailBean.getPo_srl_no());
			alPODtlRecord.add(requestDetailBean.getFacility_code());
			alPODtlUpdateRecord.add(alPODtlRecord);
			}
			
			}	
			
	
	}catch(Exception e){
		e.printStackTrace();
			
	}

		return alPODtlUpdateRecord;
	}
	
	

	// Update PO_ORDER_HDR Record

public ArrayList newPOHdrUpdate() {
		
		DeliveryOrderDetailBean requestDetailBean;
		DeliveryOrderDetailBean requestDetailBean1;
		int detailSize = checkedItemKeys.size();
		ArrayList alPOHdrUpdateRecord = new ArrayList(detailSize);
	try{

	//	java.util.Collections.reverse(checkedItemKeys);
		ArrayList alPOHdrRecord1 = new ArrayList();
		
		for (int index=0;index<detailSize;index++) {
			if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
				continue;
			
			if(index == detailSize-1)	{ 
			
				requestDetailBean = (DeliveryOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		//	select SUM(DELV_QTY) from PO_ORDER_DELV_SCH where po_no='CPUHS1320404'
		String po_delv_qty = (String)fetchRecord("select SUM(DELV_QTY) DELV_QTY from PO_ORDER_DELV_SCH where po_no= ? " ,new String[]{requestDetailBean.getPo_no()}).get("DELV_QTY");
		
		int po_order_qty = Integer.parseInt(po_delv_qty);	
		
			if(requestDetailBean.getDelivery_qty() != null && requestDetailBean.getDelivery_qty() != ""){
			
				int delv_qty = Integer.parseInt(requestDetailBean.getDelivery_qty());	
				//int order_qty = Integer.parseInt(requestDetailBean.getOrder_qty());	
						
				if( delv_qty < po_order_qty ){
					alPOHdrRecord1.add("PD");  // PO_STATUS
				}else{
					alPOHdrRecord1.add("FD");  // PO_STATUS
				}
								
				alPOHdrRecord1.add(login_by_id);
				alPOHdrRecord1.add(login_at_ws_no);
				alPOHdrRecord1.add(login_facility_id);
				alPOHdrRecord1.add(requestDetailBean.getPo_no());
			
				alPOHdrUpdateRecord.add(alPOHdrRecord1);
				break; 
			}else{
			
				int delv_qty = Integer.parseInt(requestDetailBean.getOrder_qty());	
				//int order_qty = Integer.parseInt(requestDetailBean.getOrder_qty());	
						
				if( delv_qty < po_order_qty ){
					alPOHdrRecord1.add("PD");  // PO_STATUS
				}else{
					alPOHdrRecord1.add("FD");  // PO_STATUS
				}
								
				alPOHdrRecord1.add(login_by_id);
				alPOHdrRecord1.add(login_at_ws_no);
				alPOHdrRecord1.add(login_facility_id);
				alPOHdrRecord1.add(requestDetailBean.getPo_no());
			
				alPOHdrUpdateRecord.add(alPOHdrRecord1);
				break; 
			
			}
		}	
			requestDetailBean = (DeliveryOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
			
			int delv_qty = Integer.parseInt(requestDetailBean.getDelivery_qty());	
			int order_qty = Integer.parseInt(requestDetailBean.getOrder_qty());	
			
			String po_delv_qty = (String)fetchRecord("select SUM(DELV_QTY) from PO_ORDER_DELV_SCH where po_no= ? " ,new String[]{requestDetailBean.getPo_no()}).get("DELV_QTY");
			
			int po_order_qty = Integer.parseInt(po_delv_qty);	
			
			for (int j=index+1;j<detailSize;j++) {
				if((checkedItemKeys.get(j) == null) || (checkedItemKeys.get(j).equals(""))) 
				continue;
				requestDetailBean1 = (DeliveryOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(j));
				
				if(requestDetailBean.getPo_no() != null && requestDetailBean.getPo_no() != "" && requestDetailBean1.getPo_no() != null && requestDetailBean1.getPo_no() != ""){
					if(requestDetailBean.getPo_no().equals(requestDetailBean1.getPo_no()) && requestDetailBean.getItem_code().equals(requestDetailBean1.getItem_code()) ){
					
					if(requestDetailBean.getDelivery_qty() != null && requestDetailBean.getDelivery_qty() != ""){
						delv_qty = delv_qty + Integer.parseInt(requestDetailBean1.getDelivery_qty()) ; 
						order_qty = order_qty + Integer.parseInt(requestDetailBean1.getOrder_qty()) ; 
					}else{
						delv_qty = delv_qty + Integer.parseInt(requestDetailBean1.getOrder_qty()) ; 
						order_qty = order_qty + Integer.parseInt(requestDetailBean1.getOrder_qty()) ; 
					}		
						
					}
				}
			}
			
			ArrayList alPODtlRecord = new ArrayList();
						
			if( delv_qty < po_order_qty ){
				alPODtlRecord.add("PD");  // PO_STATUS
			}else{
				alPODtlRecord.add("FD");  // PO_STATUS
			}
								
			alPODtlRecord.add(login_by_id);
			alPODtlRecord.add(login_at_ws_no);
			alPODtlRecord.add(login_facility_id);
			alPODtlRecord.add(requestDetailBean.getPo_no());
			
			alPOHdrUpdateRecord.add(alPODtlRecord);
			
			
		}	
	}catch(Exception e){
		e.printStackTrace();
			
	}

		return alPOHdrUpdateRecord;
	}
	
	
	public HashMap getMm_parameter(){
		return hmMm_parameter;
	}

	public String getBatchIDFromExpiryDate (String expiry_date) {
		StringBuffer stringBuffer= new StringBuffer(expiry_date);
		stringBuffer.deleteCharAt(5);
		stringBuffer.deleteCharAt(3);
		return stringBuffer.toString();
	}	
	
	public String getTrade_id_List(String item_code,String trade_id) {
			String optionValues = null;
			java.util.ArrayList alOptionValues = new java.util.ArrayList();
			ArrayList arr_language=new ArrayList();
			arr_language.add(item_code);
			arr_language.add(getLanguageId());
			alOptionValues = getListOptionArrayList(ePO.Common.PoRepository.getPoKeyValue("SQL_ST_TRADE_DETAILS"), arr_language);
			optionValues = getListOptionTag(alOptionValues,trade_id );
			alOptionValues = null;
			return optionValues;
	
	}
	

public java.util.ArrayList getTrade_id_List(String item_code) throws Exception 	{
	
		ArrayList result		=	new ArrayList();
		ArrayList chkParameters=new ArrayList();
			chkParameters.add(item_code);
			chkParameters.add(getLanguageId());
			
		/*	try{
			int cnt = Integer.parseInt((String)fetchRecord(getPoRepositoryValue("SQL_ST_TRADE_DETAILS_COUNT"),chkParameters).get("COUNT"));
			
			if(cnt == 1){
				pur_unit		=	(String)fetchRecord(getPoRepositoryValue("SQL_ST_TRADE_DETAILS"),chkParameters).get("TRADE_ID");
				System.out.println("pur_unit in po bean = "+pur_unit);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	*/		
			
			
		result = fetchRecords(PoRepository.getPoKeyValue("SQL_ST_TRADE_DETAILS"),chkParameters);
			
		return result;
	}
	
public String getManufacturer_id_List(String trade_id,String manufacturer_id) {
			String optionValues = null;
			java.util.ArrayList alOptionValues = new java.util.ArrayList();
			ArrayList arr_language=new ArrayList();
			arr_language.add(trade_id);
			arr_language.add(getLanguageId());
			alOptionValues = getListOptionArrayList(ePO.Common.PoRepository.getPoKeyValue("SQL_MANUFACTURER_DETAILS"), arr_language);
			optionValues = getListOptionTag(alOptionValues,manufacturer_id );
			alOptionValues = null;
			return optionValues;
	
	}
		
	
public java.util.ArrayList getManufacturer_id(String trade_id) throws Exception 	{
	
		ArrayList result		=	new ArrayList();
		ArrayList chkParameters=new ArrayList();
			chkParameters.add(trade_id);
			chkParameters.add(getLanguageId());
		result = fetchRecords(PoRepository.getPoKeyValue("SQL_MANUFACTURER_DETAILS"),chkParameters);
	
		return result;
	}	
	
/*	public String getTrade_id_List(String item_code) {
			String optionValues = null;
			java.util.ArrayList alOptionValues = new java.util.ArrayList();
			ArrayList arr_language=new ArrayList();
			arr_language.add(item_code);
			arr_language.add(getLanguageId());
			alOptionValues = getListOptionArrayList(ePO.Common.PoRepository.getPoKeyValue("SQL_ST_TRADE_DETAILS"), arr_language);
			alOptionValues.remove(0);
			optionValues = getListOptionTag(alOptionValues );
			alOptionValues = null;
			return optionValues;

	
	}
*/	

	public String getTrade_id_Default_List(String trade_id) {
		return getListOptionTag(getDefltTrdId(),trade_id);
	}

 public ArrayList getDefltTrdId() {
        
        ArrayList alDfltTrdId=new ArrayList();

        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
		try {
		
			String select_option=getPOMessage(getLanguageId(),"SELECT_OPTION","PO") ;
			String select_option_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---"+select_option+ "---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
			alDfltTrdId.add(select_option_legend);

			connection = getConnection();
				
			pstmt = connection.prepareStatement(ePO.Common.PoRepository.getPoKeyValue("SQL_ST_DEFAULT_TRADE_ID_FROM_AM"));
			pstmt.setString(1, getLanguageId());
 		    resultSet = pstmt.executeQuery();
			
            while (resultSet != null && resultSet.next()) {				
            	alDfltTrdId.add(new String[]{resultSet.getString(1),resultSet.getString(2)});				
			}
		}
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
          try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
             }
		  catch(Exception es){
	             es.printStackTrace();
             }
        }
				   
          return alDfltTrdId;
	  }
     public ArrayList getDefltTradeId() {
        
        ArrayList alDfltTradeId=new ArrayList();

        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
		try {
			
	//*		String stDfltTradeId="";
            connection = getConnection();
            pstmt = connection.prepareStatement(ePO.Common.PoRepository.getPoKeyValue("SQL_ST_DEFAULT_TRADE_ID"));
 		    resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				 String stTempTradeId=resultSet.getString(1);
				 alDfltTradeId.add(stTempTradeId);
			   }
		    }
			catch (Exception e) {
                      e.printStackTrace();
             } 
		    finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
                   }
          return alDfltTradeId;
	  }
		  public String getPlaceOfOriginList() {
			ArrayList alparameter = new ArrayList();
				alparameter.add(getLanguageId());
		        return  getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_COUNTRY_CODE_SELECT_SINGLE"),alparameter), getPlaceOfOrigin());
		}




public void updateRemarks(java.util.Hashtable remarksData) {
	
		StringBuffer key = new StringBuffer();
		String item_code = (String) remarksData.get("item_code");
		item_code = item_code.trim();
		String master_code = (String) remarksData.get("master_code");
		master_code=master_code.trim();
	
			key.append(item_code);
			key.append('-');
			key.append(master_code);
			
		hmRemarks.put(key.toString(),new QuotationRemarksBean(item_code, master_code, (String)remarksData.get("remarks"),   (String)remarksData.get("remarks_code_1")));
		setCancelled_remarks( (String)remarksData.get("remarks") );
		
	}
	
	public String getRemarks(String key) {
		if (hmRemarks.containsKey(key)) {
			QuotationRemarksBean quotRemarksBean = (QuotationRemarksBean) hmRemarks.get(key);
			return quotRemarksBean.getRemarks();
		}
		return "";
	}
	
	public String getRemarks_code(String key) { 
		if (hmRemarks.containsKey(key)) {
			QuotationRemarksBean quotRemarksBean = (QuotationRemarksBean) hmRemarks.get(key);
			return quotRemarksBean.getRemarks_code();
		}
		return "";
	}
	
public void updateRecomRemarks(java.util.Hashtable remarksData) {
	
		StringBuffer key = new StringBuffer();
		String item_code = (String) remarksData.get("item_code");
		item_code = item_code.trim();
		String master_code = (String) remarksData.get("master_code");
		master_code=master_code.trim();
	
			key.append(item_code);
			key.append('-');
			key.append(master_code);
			
		hmRecomRemarks.put(key.toString(),new QuotationRecomRemarksBean(item_code, master_code, (String)remarksData.get("remarks"),   (String)remarksData.get("remarks_code_1")));
		setCancelled_remarks( (String)remarksData.get("remarks") );
		
	}
	
	public String getRecomRemarks(String key) {
		if (hmRecomRemarks.containsKey(key)) {
			QuotationRecomRemarksBean quotRecomRemarksBean = (QuotationRecomRemarksBean) hmRecomRemarks.get(key);
			return quotRecomRemarksBean.getRemarks();
		}
		return "";
	}
	
	public String getRecomRemarks_code(String key) { 
		if (hmRecomRemarks.containsKey(key)) {
			QuotationRecomRemarksBean quotRecomRemarksBean = (QuotationRecomRemarksBean) hmRecomRemarks.get(key);
			return quotRecomRemarksBean.getRemarks_code();
		}
		return "";
	}	
	public String getTradeName(String trade_id) throws Exception 	{	
		ArrayList chkParameters=new ArrayList();
		chkParameters.add(trade_id);
		chkParameters.add(getLanguageId());	
		String trade_name = (String)fetchRecord(PoRepository.getPoKeyValue("SQL_ST_TRADENAME_DETAILS"),chkParameters).get("SHORT_NAME");			
		return trade_name;
	} 

}
