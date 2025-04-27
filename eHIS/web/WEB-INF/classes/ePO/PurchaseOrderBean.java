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
import java.util.Map;
import java.util.Iterator;
import ePO.PurchaseOrder.*;
import ePO.Common.PoRepository;
import eCommon.Common.*;
import java.util.Properties;
import javax.servlet.* ; 
import javax.servlet.http.*;

public class PurchaseOrderBean extends ePO.Common.PoTransaction implements Serializable{

	private String master_type;
	private String purchase_type;
	private String from_purchase_unit;
	private String to_supplier;
	private String po_mode;
	private String blanket_purchase;
	private String doc_no;
	private String doc_ref;
	private String doc_date;
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
	private HashMap	hmBillRecords;
	private ArrayList	alBillRecords;
	private String qnt_ref;
	private String pmnt_term;
	private String acc_no;
	private String terms_conditions;
	private String delivery_mode;
	private String deliver_to_address;
	private String bill_to_address;
	private String exp_date;
	private String old_po_no;
	private String request_by_pu;
	private String request_on_supp;
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
	private String PgetPu_codepo="";


	public PurchaseOrderBean() {
		itemKeys = new java.util.ArrayList();
		reqKeys = new java.util.ArrayList();
		
		checkedItemKeys = new java.util.ArrayList();
		hmItemDetail = new java.util.HashMap();
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
	
	public void setPurchase_type(String purchase_type) {
		 this.purchase_type = checkForNull(purchase_type);
	}

	public String getPurchase_type() {
		 return purchase_type;
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
	
	public String getFacilityList(String po_purchase_unit) {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(po_purchase_unit);
		sqlParam.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_FACILITY_BASED_ON_PU_SELECT"),sqlParam),""); 
		
	}
	
	public String getFacilityList(String po_purchase_unit,String facility_code) {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(po_purchase_unit);
		sqlParam.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_FACILITY_BASED_ON_PU_SELECT"),sqlParam),facility_code); 
		
	}
	
	public String getRequestByStoreList() { 
		ArrayList alParameters =  new ArrayList();							
		alParameters.add(getLoginById());
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_USER_ACCESS_FOR_STORE_SELECT"),alParameters),""); 
	}
	
	public String getPurchase_type_List() {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add(getMasterType());
		   arr_language.add(getLanguageId());
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),getPurchase_type()); 
    }
	
	public String getPurchase_type_List(String pur_type) {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add(getMasterType());
		   arr_language.add(getLanguageId());
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),pur_type); 
    }
	
	public String getRequestFromPurchaseUnit() {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		sqlParam.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_ORD"),sqlParam),""); 
		
	}
	
	
	public String getRequestFromPurchaseUnit(String pur_unit) {

		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		sqlParam.add(getLoginFacilityId());
		
	/*	try{
			int cnt = Integer.parseInt((String)fetchRecord(getPoRepositoryValue("SQL_PURCHASE_UNIT_COUNT"),sqlParam).get("COUNT"));
			
			if(cnt == 1){
				pur_unit		=	(String)fetchRecord(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_ORD"),sqlParam).get("CODE");
				System.out.println("pur_unit in po bean = "+pur_unit);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	*/	
		
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_ORD"),sqlParam),pur_unit); 
		
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
	
//	public java.util.ArrayList getAccount_no(String dept_id,String commit_code) throws Exception 	{
	public java.util.ArrayList getAccount_no(String dept_id,String commit_code,String eff_from) throws Exception 	{
		ArrayList chkParameters=new ArrayList();
		chkParameters.add(dept_id);
		chkParameters.add(commit_code);
		chkParameters.add(eff_from);
		ArrayList result		=	new ArrayList();
		result = fetchRecords(PoRepository.getPoKeyValue("SQL_PO_ACCOUNT_NO_SELECT"),chkParameters);
		return result;
	}
	
//	public HashMap getAcctDesc(String acc_no,String commit_code,String dept_id){
	public HashMap getAcctDesc(String acc_no,String commit_code,String dept_id,String eff_from){
		HashMap hmRecord = null;
		ArrayList chkParameters=new ArrayList();
		chkParameters.add(acc_no);
		chkParameters.add(commit_code);
		chkParameters.add(dept_id);
		chkParameters.add(eff_from);
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
			
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_DELIVERY_MODE_SELECT")),getDelivery_mode()); 
		
    }

	public String getPayment_term() {
			
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PAYMENT_TERM_SELECT")),getPmnt_term()); 
		
    }

	public String getTermsandcondition() {
			
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_TERM_AND_COND_SELECT")),getTerms_conditions()); 
		
    }
	

			
	public void clear() {
	
		super.clear();
		doc_no = null;
		doc_ref = null;
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
		hmBillRecords = null;
		alBillRecords = null;
		qnt_ref= null;
		pmnt_term= null;
		terms_conditions= null;
		delivery_mode= null;
		deliver_to_address= null;
		bill_to_address= null;
		order_remarks = null;
		purchase_type = null;
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
	}
	public void initialize() {
	
		super.initialize();
		doc_no = "";
		doc_ref = "";
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
		hmBillRecords= new java.util.HashMap();
		alBillRecords =new java.util.ArrayList();
		qnt_ref= "";
		pmnt_term= "";
		terms_conditions= "";
		delivery_mode= "";
		deliver_to_address= "";
		bill_to_address= "";
		order_remarks = "";
		purchase_type = "";
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
	
	
	public PurchaseOrderDetailBean getItemDetail(String item_code) {
		return (PurchaseOrderDetailBean) hmItemDetail.get(item_code);
	}
	
	 
	public java.util.HashMap addDetailRecord(java.util.Hashtable detailRecord) {
		System.out.println("addDetailRecord in po bean = "+detailRecord);
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
		
		
		
		
		hmItemDetail.put(item_code, new PurchaseOrderDetailBean(detailRecord));
		hashResult.put("result",new Boolean(true));
		hashResult.put("message","");
		return hashResult;
	}
	

	public java.util.HashMap addDetailRecordModifyMode(java.util.Hashtable detailRecord) {
		
			System.out.println("detailRecord in addDetailRecordModifyMode = "+detailRecord);
			java.util.HashMap hashResult = new java.util.HashMap(2);
			hashResult.put("result",new Boolean(false));
		try {
					
			String item_code = (String) detailRecord.get("item_code");
			String editing = (String) detailRecord.get("editing");
			if (editing.equals("1") && itemKeys.contains(item_code)) {
				hashResult.put("message","DUPLICATE_CODE_EXISTS");
				return hashResult;
			}
			
			itemKeysAdded.add(item_code);
			hmItemDetail.put(item_code, new PurchaseOrderDetailBean(detailRecord));
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
		ArrayList	alInsertDeliveryData=	new ArrayList()	;
		ArrayList	alInsertBillDeliveryData=	new ArrayList()	;
		PurchaseOrderDetailBean requestDetailBean;
		hmResult.put("result", new Boolean(false));
		ArrayList final_dtl=new ArrayList();
		ArrayList req_dtl=new ArrayList();
		ArrayList req_hdr=new ArrayList();
		//ArrayList mm_item_dtl=new ArrayList();
		ArrayList commt_dtl=new ArrayList();
		ArrayList block_dtl=new ArrayList();
		ArrayList app_yn=new ArrayList();
		String appvl_yn = "";
		
		
		
		final_dtl=(ArrayList)newInsert();
		
		
		
		HashMap hashApp = new HashMap();
		String app_item = "";
			
		try{
		 hashApp=fetchRecord(PoRepository.getPoKeyValue("SQL_ST_PO_ITEM_APPROVAL_YN"));
		 app_item=(String)hashApp.get("ITEM_LEVEL_ORDER_APPROVAL");
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		if(app_item.equals("Y")){
			
			app_yn = (ArrayList)getApprovedYN();
			
			ArrayList alDevlRecord = null;
			if(app_yn != null){
				for (int i=0;i<app_yn.size();i++) {
					alDevlRecord = (java.util.ArrayList) app_yn.get(i);
					for (int j=0;j<alDevlRecord.size();j++) {	
						if(alDevlRecord.get(j).equals("N")){
							appvl_yn = "PA";
							break;
						}else if(alDevlRecord.get(j).equals("Y")){
							appvl_yn = "FA";
						}
					}
				}		
			}
		}else{
			appvl_yn = "FA";
		}
		
		
	/*	if(getFinalize_yn().equals("Yes") && appvl_yn.equals("FA")){
			
			// Update QTY_ON_ORDER & LAST_PUR_COST in MM_ITEM 	
			mm_item_dtl=(ArrayList)newMMITEMUpdate();
			System.out.println("mm_item_dtl in po bean insert = "+mm_item_dtl);
			hmTableData.put("UpdateMMITEMData",mm_item_dtl);
			hmSQLMap.put("UpdateMMITEMSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_MM_ITEM_UPDATE"));
		}
	*/	
		if(getFinalize_yn().equals("Yes") && appvl_yn.equals("FA") && getPo_mode().equals("R")){
			// Update Request Detail 
			req_dtl=(ArrayList)newReqDetPOUpdate();
			
			//hmSQLMap.put("UpdateREQDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQ_DTL_UPDATE"));
			hmSQLMap.put("UpdateREQDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQ_DTL_PO_QTY_UPDATE"));
			hmTableData.put("UpdateREQDTLData",req_dtl);
			
			// Update Request Header
			req_hdr=(ArrayList)newReqHdrUpdate();
			
			hmSQLMap.put("UpdateREQHDRSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQ_HDR_UPDATE"));
			hmTableData.put("UpdateREQHDRData",req_hdr);
		
		}
		
		if(getFinalize_yn().equals("No") && getPo_mode().equals("R")){
		
		// Update Request Detail po_blocked_qty	
			req_dtl=(ArrayList)newReqDetUpdate();
			
			hmSQLMap.put("UpdateREQDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQ_DTL_PO_BLOCKED_QTY_UPDATE"));
			hmTableData.put("UpdateREQDTLData",req_dtl);
		
		
		}
		
		
		
		
				
	// Update Budget Amount in PO_COMMTTMENT_ACCOUNT	
		if(getFinalize_yn().equals("Yes") && appvl_yn.equals("FA")){
			String budget_check_yn = "";
			try{
			 budget_check_yn =	checkForNull((String)fetchRecord("SELECT BUDGET_CHECK_REQD_YN FROM PO_PARAMETER").get("BUDGET_CHECK_REQD_YN"),"");
			}catch(Exception e){
				e.printStackTrace();
			}
			if(budget_check_yn.equals("Y")){
				commt_dtl=(ArrayList)newCommt();
				hmTableData.put("UpdateCOMMTData",commt_dtl);
				hmSQLMap.put("UpdateCOMMTSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_COMMT_CODE_UPDATE_FINALIZE_YES_INSERT"));
			}
			
		}
		
		// Update Blocked Budget Amount in PO_COMMTTMENT_ACCOUNT	
		if(getFinalize_yn().equals("No")){
			String budget_check_yn = "";
			try{
			 budget_check_yn =	checkForNull((String)fetchRecord("SELECT BUDGET_CHECK_REQD_YN FROM PO_PARAMETER").get("BUDGET_CHECK_REQD_YN"),"");
			}catch(Exception e){
				e.printStackTrace();
			}
			if(budget_check_yn.equals("Y")){
				block_dtl=(ArrayList)newBlock();
				hmTableData.put("UpdateBlockData",block_dtl);
				hmSQLMap.put("UpdateBlockSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_COMMT_CODE_UPDATE_FINALIZE_NO"));
			}
		}
	
		HashMap hashGlobal=new HashMap();
		String global_unit="";
			
		try{
		 hashGlobal=fetchRecord(PoRepository.getPoKeyValue("SQL_ST_PO_GLOBAL_YN") ,getRequest_by_pu());
		 global_unit=(String)hashGlobal.get("GLOBAL_UNIT_YN");
		}catch(Exception e){
			e.printStackTrace();
		}		
	
		ArrayList alHdrInsertRecord = new ArrayList();
		
		alHdrInsertRecord.add(getDoc_no()); //PO_NO
		alHdrInsertRecord.add("0");//PO_REVN_NO
		alHdrInsertRecord.add(getRequest_by_pu());
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(checkForNull(global_unit," "));//Global_unit
		alHdrInsertRecord.add(getPo_mode());
		alHdrInsertRecord.add(getPurchase_type()); //master_code
		alHdrInsertRecord.add(getBlanket_po_yn()); //blanket_po_yn
		alHdrInsertRecord.add(getDoc_date_value());
		alHdrInsertRecord.add(getDoc_ref());
		alHdrInsertRecord.add(getRequest_on_supp());
		alHdrInsertRecord.add(getCurrency_code());//currency_code
		alHdrInsertRecord.add(getLocal_currency());//local_currency
		alHdrInsertRecord.add(getExc_rate());//conversion_rate
		alHdrInsertRecord.add(getGross_poAmt());//gross_poAmt
		alHdrInsertRecord.add("A");//PO_DISC_INDICATOR  getDis_type()
		alHdrInsertRecord.add("");//PO_DISC_PERCENT
		alHdrInsertRecord.add(getAddi_dist());//PO_DISC_AMT
		alHdrInsertRecord.add(getNet_poAmt());//PO_NET_AMT
		alHdrInsertRecord.add(getFinalize_yn().equals("Yes")?appvl_yn:"UF");//PO_STATUS
		alHdrInsertRecord.add("");//PO_LAST_REVN_NO
		alHdrInsertRecord.add(getDelivery_mode());//MODE_OF_DELV_CODE
		alHdrInsertRecord.add(getPmnt_term());//PAYMENT_TERM
		alHdrInsertRecord.add(getQnt_ref());//QUOTATION_REF
		alHdrInsertRecord.add(getOld_po_no());//LAST_PO_NO
		alHdrInsertRecord.add(checkForNull(getOrder_remarks(),""));//PO_REMARKS
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		if(getBlanket_po_yn().equals("Y")){
		alHdrInsertRecord.add(getValid_upto());//PO_VALIDITY_DATE
		}else if(getBlanket_po_yn().equals("N")){
		alHdrInsertRecord.add("");//PO_VALIDITY_DATE
		}
		alHdrInsertRecord.add(getTerms_conditions());//TERMS_AND_CONS_CODE
		alHdrInsertRecord.add(getExp_date());//EXPECTED_DELV_DATE
		alHdrInsertRecord.add(getMasterType());//PO_MASTER_TYPE
		
		
		
		
		allanguageData.add(getLanguageId());
	//start for delivery_schedule
	
	try{
		ArrayList sourceArrayList;
		int devl_srl_no=1;
		String item_code = "";

		
		
		if(hmExpRecords.size()>0){
		//	for (int i=0;i<itemKeys.size();i++) {
			for (int i=0;i<checkedItemKeys.size();i++) {		
					// item_code = (String)itemKeys.get(i);
					item_code = (String)checkedItemKeys.get(i);
						sourceArrayList	=	(ArrayList)hmExpRecords.get(item_code);

						

						if(hmExpRecords.containsKey(item_code)){
								if(sourceArrayList.size()>0){

								  for (int j=0;j<sourceArrayList.size();j++) {
									
									HashMap	hmExpRecord	=	(HashMap)sourceArrayList.get(j);

									

									if((hmExpRecord.get("DELV_DATE") == null) || (hmExpRecord.get("DELV_DATE").equals(""))) {
										devl_srl_no = 1;
										continue;
									}
											
									ArrayList alInsertDeliveryRecord        =       new ArrayList();
									alInsertDeliveryRecord.add(getDoc_no()); // PO_NO
									alInsertDeliveryRecord.add(hmExpRecord.get("ITEM_CODE")); // ITEM_CODE
									alInsertDeliveryRecord.add(""+(i+1)); //PO_SRL_NO
									alInsertDeliveryRecord.add(""+(j+1)); //DELV_SRL_NO
									alInsertDeliveryRecord.add(hmExpRecord.get("DELV_QTY")); //DELV_QTY
									alInsertDeliveryRecord.add(hmExpRecord.get("DELV_DATE")); // DELV_DATE
									alInsertDeliveryRecord.add("ND"); //DELV_STATUS
									alInsertDeliveryRecord.add(login_by_id);
									alInsertDeliveryRecord.add(login_at_ws_no);
									alInsertDeliveryRecord.add(login_facility_id);
									alInsertDeliveryRecord.add(login_by_id);
									alInsertDeliveryRecord.add(login_at_ws_no);
									alInsertDeliveryRecord.add(login_facility_id);

									alInsertDeliveryData.add(alInsertDeliveryRecord);							
								}
							}
						}else{ 

							requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(item_code);

							String del_date = (String)requestDetailBean.getDel_date();

							if( del_date == null || del_date.equals(""))
							continue;
						
							
								
							ArrayList alDevyRecord = new ArrayList();
							
							alDevyRecord.add(getDoc_no());//PO_NO
							alDevyRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
							alDevyRecord.add(""+(i+1));//PO_SRL_NO
							alDevyRecord.add("1");//DELV_SRL_NO
							alDevyRecord.add(requestDetailBean.getOrder_qty());//DELV_QTY
							alDevyRecord.add(requestDetailBean.getDel_date());//DELV_DATE
							alDevyRecord.add("ND");//DELV_STATUS
							alDevyRecord.add(login_by_id);
							alDevyRecord.add(login_at_ws_no);
							alDevyRecord.add(login_facility_id);
							alDevyRecord.add(login_by_id);
							alDevyRecord.add(login_at_ws_no);
							alDevyRecord.add(login_facility_id);

							alInsertDeliveryData.add(alDevyRecord);	
						
						}
			}
			
		}else if (checkedItemKeys.size() > 0) {			
						
					//	java.util.Collections.reverse(checkedItemKeys);
					
					int detailSize = checkedItemKeys.size();

						for (int index=0;index<detailSize;index++) {
					
					

							if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
							continue;
								
							requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
						
							String del_date = (String)requestDetailBean.getDel_date();

							if( del_date == null || del_date.equals(""))
							continue;
						
							
								
							ArrayList alDevyRecord = new ArrayList();
							
							alDevyRecord.add(getDoc_no());//PO_NO
							alDevyRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
							alDevyRecord.add(""+(index+1));//PO_SRL_NO
							alDevyRecord.add("1");//DELV_SRL_NO
							alDevyRecord.add(requestDetailBean.getOrder_qty());//DELV_QTY
							alDevyRecord.add(requestDetailBean.getDel_date());//DELV_DATE
							alDevyRecord.add("ND");//DELV_STATUS
							alDevyRecord.add(login_by_id);
							alDevyRecord.add(login_at_ws_no);
							alDevyRecord.add(login_facility_id);
							alDevyRecord.add(login_by_id);
							alDevyRecord.add(login_at_ws_no);
							alDevyRecord.add(login_facility_id);

							alInsertDeliveryData.add(alDevyRecord);		
				
					}
		}	
	
			
			


		}catch(Exception e){
			e.printStackTrace();			
		}

	
	//end for delivery_schedule
	
	//start for Bill delivery_schedule
	
		
		ArrayList bDArrayList ; 
		
	try{
				
			
			if(getPo_mode().equals("R")){	
				if(hmBillRecords.size() > 0){
					
						bDArrayList	=	(ArrayList)hmBillRecords.get(0);
						if(bDArrayList.size()>0){

							for (int j=0;j<bDArrayList.size();j++) {
								
															
								HashMap	hmExpRecord	=	(HashMap)bDArrayList.get(j);
								
									if((hmExpRecord.get("FACILITY_CODE") == null) || (hmExpRecord.get("FACILITY_CODE").equals(""))) {
										continue;
									}
								
								ArrayList alInsertBDRecord        =       new ArrayList();
								
								alInsertBDRecord.add(getDoc_no()); // PO_NO
								alInsertBDRecord.add(hmExpRecord.get("FACILITY_CODE")); // FACILITY_ID
								alInsertBDRecord.add(hmExpRecord.get("BILL_TO")); //BILL_TO_ADDR
								alInsertBDRecord.add(hmExpRecord.get("DELIVER_TO")); //DELV_TO_ADDR
								alInsertBDRecord.add(login_by_id);
								alInsertBDRecord.add(login_at_ws_no);
								alInsertBDRecord.add(login_facility_id);
								alInsertBDRecord.add(login_by_id);
								alInsertBDRecord.add(login_at_ws_no);
								alInsertBDRecord.add(login_facility_id);	
								alInsertBillDeliveryData.add(alInsertBDRecord);
																
							}	
						}		
				}
				else if(itemKeys.size() > 0){
					
					ArrayList alInsertBillDeliveryRecord        =       new ArrayList();
					alInsertBillDeliveryRecord.add(getDoc_no()); // PO_NO
					alInsertBillDeliveryRecord.add("*A"); // FACILITY_ID
					alInsertBillDeliveryRecord.add(getBill_to_address()); //BILL_TO_ADDR
					alInsertBillDeliveryRecord.add(getDeliver_to_address()); //DELV_TO_ADDR
					alInsertBillDeliveryRecord.add(login_by_id);
					alInsertBillDeliveryRecord.add(login_at_ws_no);
					alInsertBillDeliveryRecord.add(login_facility_id);
					alInsertBillDeliveryRecord.add(login_by_id);
					alInsertBillDeliveryRecord.add(login_at_ws_no);
					alInsertBillDeliveryRecord.add(login_facility_id);
					alInsertBillDeliveryData.add(alInsertBillDeliveryRecord);
					
				}
				else {
				
					ArrayList alInsertBillDeliveryRecord        =       new ArrayList();
					alInsertBillDeliveryRecord.add(getDoc_no()); // PO_NO
					alInsertBillDeliveryRecord.add(login_facility_id); // FACILITY_ID
					alInsertBillDeliveryRecord.add(getBill_to_address()); //BILL_TO_ADDR
					alInsertBillDeliveryRecord.add(getDeliver_to_address()); //DELV_TO_ADDR
					alInsertBillDeliveryRecord.add(login_by_id);
					alInsertBillDeliveryRecord.add(login_at_ws_no);
					alInsertBillDeliveryRecord.add(login_facility_id);
					alInsertBillDeliveryRecord.add(login_by_id);
					alInsertBillDeliveryRecord.add(login_at_ws_no);
					alInsertBillDeliveryRecord.add(login_facility_id);
					alInsertBillDeliveryData.add(alInsertBillDeliveryRecord);
					
				}
			} 
			else {
				ArrayList alInsertBillDeliveryRecord        =       new ArrayList();
				alInsertBillDeliveryRecord.add(getDoc_no()); // PO_NO
				alInsertBillDeliveryRecord.add("*A"); // FACILITY_ID
				alInsertBillDeliveryRecord.add(getBill_to_address()); //BILL_TO_ADDR
				alInsertBillDeliveryRecord.add(getDeliver_to_address()); //DELV_TO_ADDR
				alInsertBillDeliveryRecord.add(login_by_id);
				alInsertBillDeliveryRecord.add(login_at_ws_no);
				alInsertBillDeliveryRecord.add(login_facility_id);
				alInsertBillDeliveryRecord.add(login_by_id);
				alInsertBillDeliveryRecord.add(login_at_ws_no);
				alInsertBillDeliveryRecord.add(login_facility_id);
				alInsertBillDeliveryData.add(alInsertBillDeliveryRecord);
			
			}
			
			

			
		}catch(Exception e){
			e.printStackTrace();			
		}

	
	//end for Bill delivery_schedule
	
	
	

		java.util.ArrayList alUpdateData = new java.util.ArrayList (4);
		alUpdateData.add(login_by_id);
		alUpdateData.add(login_at_ws_no);
		alUpdateData.add(login_facility_id);
				
		hmSQLMap.put("InsertHDRSQL", PoRepository.getPoKeyValue("SQL_PO_ORDER_HDR_INSERT")); 
		hmSQLMap.put("InsertDTLSQL", PoRepository.getPoKeyValue("SQL_PO_ORDER_DTL_INSERT")); 
		hmSQLMap.put("InsertDELVSQL", PoRepository.getPoKeyValue("SQL_PO_ORDER_DELV_SCH_INSERT")); 
		hmSQLMap.put("InsertBILLDELVSQL", PoRepository.getPoKeyValue("SQL_PO_ORDER_BILLDELV_DTL_INSERT")); 
		hmSQLMap.put("UpdateSQL", PoRepository.getPoKeyValue("SQL_UPDATE_NEXT_DOC_NO_IN_DOCNO_CONTROL_FOR_PO")); 
		hmSQLMap.put("SQL_PO_DOC_TYPE_SELECT_FLAG_FROM_CONTROL_TABLE",PoRepository.getPoKeyValue("SQL_PO_DOC_TYPE_SELECT_FLAG_FROM_CONTROL_TABLE"));
		

		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertHDRData",alHdrInsertRecord);
		hmTableData.put("InsertDELVData",alInsertDeliveryData);
		hmTableData.put("InsertBILLDELVData",alInsertBillDeliveryData);
		hmTableData.put("UpdateData",alUpdateData);
		hmTableData.put("LANGUAGE_DATA",	allanguageData);
		hmTableData.put("FINAL_DTL",final_dtl);
		
		PurchaseOrderRemote requestRemote = null;

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PurchaseOrder", PurchaseOrderHome.class,getLocalEJB());
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
			setPrintDocNo(doc_no);  // Added By Padmapriya INC # 34823 on 07/09/2012
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
				
		setPurchase_type((String)hashValues.get("purchase_type"));
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

//load Bill to Delivery to data
	public ArrayList getBillToDeliverToData(String po_no){
	
	
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			ArrayList alExpRecords = new ArrayList();
			String facility_code = "";
			try {
            connection = getConnection();
			
			pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_ORDER_BILLDEV_DTL_SELECT"));
			
			pstmt.setString(1, po_no);
			
			resultSet = pstmt.executeQuery();
			
				
		while (resultSet != null && resultSet.next()) {
				
			HashMap hmExpRecord	=	new HashMap();
			facility_code = resultSet.getString("FACILITY_ID");
			
			
			if(facility_code.equals("*A")){
				setBill_to_address(resultSet.getString("BILL_TO_ADDR"));
				setDeliver_to_address(resultSet.getString("DELV_TO_ADDR"));
			}else{
			hmExpRecord.put("FACILITY_CODE",	resultSet.getString("FACILITY_ID"));
			hmExpRecord.put("BILL_TO_ADDR",	resultSet.getString("BILL_TO_ADDR"));
			hmExpRecord.put("DELV_TO_ADDR",	resultSet.getString("DELV_TO_ADDR"));
			alExpRecords.add(hmExpRecord);
			
			}
			setDelivery_mode(resultSet.getString("MODE_OF_DELV_CODE"));
			setPmnt_term(resultSet.getString("PAYMENT_TERM"));
			setQnt_ref(resultSet.getString("QUOTATION_REF"));
			setTerms_conditions(resultSet.getString("TERMS_AND_CONS_CODE"));

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


	
	public void loadData(String purchase_type_code, String po_no) {
	
	 
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		PurchaseOrderDetailBean requestDetailBean;
        itemKeysAdded = new java.util.ArrayList();
		try {
            connection = getConnection();
		//load PO hdr data	
          
		    pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_ORDER_HDR_SELECT"));
			
            pstmt.setString(1, login_facility_id);
            pstmt.setString(2, purchase_type_code);
            pstmt.setString(3, po_no);
            resultSet = pstmt.executeQuery();
			
			
            while (resultSet != null && resultSet.next()) {
				setPo_mode(resultSet.getString("PO_ORDER_MODE"));
				setPurchase_type(resultSet.getString("PO_MASTER_CODE"));
				setDoc_no(resultSet.getString("po_no"));
				setDoc_date(resultSet.getString(4));
				setDoc_ref(resultSet.getString("po_ref"));
				setRequest_by_pu(resultSet.getString("PUR_UNIT_CODE"));
				setRequest_on_supp(resultSet.getString("SUPP_CODE"));
				setOrder_remarks(resultSet.getString("PO_REMARKS"));
				setBlanket_po_yn(resultSet.getString("BLANKET_PO_YN"));
				setValid_upto(resultSet.getString(10));
				setExc_rate(resultSet.getString("CONVERSION_RATE"));
				setExp_date(resultSet.getString(12));
				setAddi_dist(resultSet.getString("PO_DISC_AMT"));
				setNet_poAmt(resultSet.getString("PO_NET_AMT"));
				setOld_po_no(resultSet.getString("LAST_PO_NO"));
				setCurrency_code(resultSet.getString("TRANS_CURRENCY"));
								
            }
			
			ArrayList al_doc_no = new ArrayList();
			al_doc_no.add(getDoc_no());
			setPrintDocNo(al_doc_no);   // Added By Padmapriya INC # 34823 on 07/09/2012
			
			closeResultSet(resultSet);
            closeStatement(pstmt);
			
			
			getBillToDeliverToData(po_no);
				
			//load PO dtl data
			allItemKeys = new java.util.ArrayList();
          
		  
			pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_ORDER_DTL_SELECT"));
		
            pstmt.setString(1, getLanguageId());
			pstmt.setString(2, "COMMNT" );
			pstmt.setString(3, login_facility_id);
            pstmt.setString(4, purchase_type_code);
            pstmt.setString(5, po_no);
            pstmt.setString(6, getLanguageId());
			resultSet = pstmt.executeQuery();
			
			
			String item_code = "";
            while (resultSet != null && resultSet.next()) {
				requestDetailBean = new PurchaseOrderDetailBean(resultSet);
				
				item_code = requestDetailBean.getItem_code()+checkForNull(requestDetailBean.getReq_no(),"") ;
				
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
		ArrayList	alModifyBillDeliveryData = new ArrayList();
		ArrayList	alInsertBillDeliveryData = new ArrayList();
		ArrayList	alParams = new ArrayList();
		ArrayList	alDevyParams = new ArrayList();
		Properties properties = getProperties();
		ArrayList	alInsertDeliveryData=	new ArrayList()	;

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

		hmTableData.put("properties",properties);
		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Initial Message") ;

	int no_of_decimals					=			getNoOfDecimals();
	int no_of_decimals_temp				=			getNoOfDecimals();
	
	PurchaseOrderRemote requestRemote = null;

		try
		{
		connection = getConnection();
		String key = (String) allItemKeys.get(allItemKeys.size()-1);
		PurchaseOrderDetailBean requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(key);
		requestDetailBean = null;		
		
		int detailSize = -1;
		alParams.add(getDoc_no());
		alParams.add(getRequest_by_pu());
		
		
		
		int detailSizeTemp = Integer.parseInt((String)fetchRecord(getPoRepositoryValue("SQL_PURCHASE_ORDER_DTL_MAX_SRL_NO"),alParams).get("LAST_SRL_NO"));

		
		itemKeysAdded.addAll(reqKeysAdded);
		if (itemKeysAdded != null && itemKeysAdded.size()>0) {
			detailSize		= itemKeysAdded.size();
			
			ArrayList alInsertRecord = new ArrayList(detailSize);
			for (int index=0;index<detailSize;index++) {
				if((itemKeysAdded.get(index) == null) || (itemKeysAdded.get(index).equals(""))) {
						continue;
				}
			if(checkedItemKeys.contains(itemKeysAdded.get(index))){
				requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(itemKeysAdded.get(index));
				
				ArrayList alInsertDtlRecord = new ArrayList();
				
				
				alInsertDtlRecord.add(getRequest_by_pu());//PURCHASE_UNIT_CODE
				alInsertDtlRecord.add(getDoc_no());//DOC_NO
				if(getPo_mode().equals("D")){	
				alInsertDtlRecord.add("*A");// REQ_FACILITY_ID
				alInsertDtlRecord.add("*A");// REQ_STORE_CODE
				}else if(getPo_mode().equals("R")){
					if(requestDetailBean.getFacility_code() != null && requestDetailBean.getFacility_code() != ""){	
						alInsertDtlRecord.add(requestDetailBean.getFacility_code());// REQ_FACILITY_ID
						alInsertDtlRecord.add(requestDetailBean.getStore_code());// REQ_STORE_CODE
					}else{
						alInsertDtlRecord.add("*A");// REQ_FACILITY_ID
						alInsertDtlRecord.add("*A");// REQ_STORE_CODE
					}
				}
				alInsertDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
				if(requestDetailBean.getSrl_no()==-1 || requestDetailBean.getSrl_no()==0)
				alInsertDtlRecord.add(""+(++detailSizeTemp));
				else
				alInsertDtlRecord.add(""+(requestDetailBean.getSrl_no()));
				alInsertDtlRecord.add(requestDetailBean.getOrder_qty());//ORDER_QTY
				alInsertDtlRecord.add(requestDetailBean.getUom());//UOM
				//alInsertDtlRecord.add("1");//PO_GEN_UOM_CONV_FACTOR
				alInsertDtlRecord.add(requestDetailBean.getConvFact());//PO_GEN_UOM_CONV_FACTOR
				
				Double conv_fact,order_qty,po_gen_uom_qty;
				conv_fact = Double.parseDouble(requestDetailBean.getConvFact());
				order_qty = Double.parseDouble(requestDetailBean.getOrder_qty());
				po_gen_uom_qty = order_qty * conv_fact ;
				alInsertDtlRecord.add(new Double(po_gen_uom_qty).toString());//PO_GEN_UOM_QTY
				
				//alInsertDtlRecord.add(requestDetailBean.getOrder_qty());//PO_GEN_UOM_QTY
			alInsertDtlRecord.add(requestDetailBean.getPur_price());//UNIT_PRICE
			alInsertDtlRecord.add(requestDetailBean.getTot_value());//TOTAL_VALUE
			alInsertDtlRecord.add(requestDetailBean.getDis_type());  //DISC_INDICATOR
			alInsertDtlRecord.add(requestDetailBean.getDis_amt());  //DISC_AMOUNT
			alInsertDtlRecord.add(requestDetailBean.getNet_amount());  //ITEM_NET_VALUE 
			alInsertDtlRecord.add("COMMNT"); //COMMNT_TYPE
			alInsertDtlRecord.add(checkForNull(requestDetailBean.getCommit_code())); //COMMNT_CODE
			alInsertDtlRecord.add(checkForNull(requestDetailBean.getDept_no())); //DEPT_NO
			alInsertDtlRecord.add(checkForNull(requestDetailBean.getAcc_no())); //ACCOUNT_NO
			alInsertDtlRecord.add(checkForNull(requestDetailBean.getAcc_desc())); //ACCOUNT_NAME
			alInsertDtlRecord.add(requestDetailBean.getApp_ref()); //APPROVED_YN
			if(requestDetailBean.getApp_ref().equals("Y")){
				alInsertDtlRecord.add(login_by_id); //APPROVED_BY
				alInsertDtlRecord.add(getDoc_date_value()); //APPROVED_DATE
				alInsertDtlRecord.add(requestDetailBean.getRef_value()); //APPROVAL_REMARKS
			}else if(requestDetailBean.getApp_ref().equals("N")){
				alInsertDtlRecord.add(""); //APPROVED_BY
				alInsertDtlRecord.add(""); //APPROVED_DATE
				alInsertDtlRecord.add(""); //APPROVAL_REMARKS
			}
			alInsertDtlRecord.add(requestDetailBean.getItem_remarks()); //PO_LINE_REMARKS
			if(getPo_mode().equals("D")){	
				alInsertDtlRecord.add(""); //REQ_NO
				alInsertDtlRecord.add(""); //REQ_SRL_NO
			} else if(getPo_mode().equals("R")){
				if(requestDetailBean.getReq_no() != null && requestDetailBean.getReq_no() != ""){
					alInsertDtlRecord.add(requestDetailBean.getReq_no()); //REQ_NO
					alInsertDtlRecord.add(requestDetailBean.getReq_srl_no()); //REQ_SRL_NO
				}else{
					alInsertDtlRecord.add(""); //REQ_NO
					alInsertDtlRecord.add(""); //REQ_SRL_NO
				}
				
			}
				
				
				alInsertDtlRecord.add(login_by_id);
				alInsertDtlRecord.add(login_at_ws_no);
				alInsertDtlRecord.add(login_facility_id);
				alInsertDtlRecord.add(login_by_id);
				alInsertDtlRecord.add(login_at_ws_no);
				alInsertDtlRecord.add(login_facility_id);
				alInsertDtlRecord.add(checkForNull(requestDetailBean.getUnit_price()));//LIST_PRICE
				alInsertDtlRecord.add("ND");//PO_LINE_STATUS
				alInsertDtlRecord.add(requestDetailBean.getEff_from_dt()); //COMMNT_EFF_DATE_FROM
				alInsertRecord.add(alInsertDtlRecord);	
					
					
				
			}
			}
			hmTableData.put("InsertDTLData",alInsertRecord);
			hmSQLMap.put("InsertDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_ORDER_DTL_INSERT"));
		}
		
		
		
		HashMap hashApp = new HashMap();
		String app_item = "";
			
		try{
		 hashApp=fetchRecord(PoRepository.getPoKeyValue("SQL_ST_PO_ITEM_APPROVAL_YN"));
		 app_item=(String)hashApp.get("ITEM_LEVEL_ORDER_APPROVAL");
		}catch(Exception e){
			e.printStackTrace();
		}	
		
		String appvl_yn = "";
		if(app_item.equals("Y")){	
	
	
	//get Approval YN	
		
		
		if (allItemKeys != null && allItemKeys.size() > 0) {
			detailSize		= allItemKeys.size();
			
			ArrayList alAppRecord = new ArrayList(detailSize);
			for (int index=0;index<detailSize;index++) {
				if((allItemKeys.get(index) == null) || (allItemKeys.get(index).equals(""))) {
						continue;
				}

				requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(allItemKeys.get(index));
				ArrayList alInsertAppRecord = new ArrayList();
				
				
			alInsertAppRecord.add(requestDetailBean.getApp_ref()); //APPROVED_YN
			alAppRecord.add(alInsertAppRecord);	
					
					
				
			}
			
		
		ArrayList alDevlRecord = null;
		
		if(alAppRecord != null){
			for (int i=0;i<alAppRecord.size();i++) {
					alDevlRecord = (java.util.ArrayList) alAppRecord.get(i);
					
					for (int j=0;j<alDevlRecord.size();j++) {	
					if(alDevlRecord.get(j).equals("N")){
						appvl_yn = "PA";
						break;
					}else if(alDevlRecord.get(j).equals("Y") && !appvl_yn.equals("PA") ){
						appvl_yn = "FA";
					}
						
				}
			}
		
		}
			
		
		}
		
		}else{
			appvl_yn = "FA";
		}
		
		
		// Update Budget Amount in  PO_COMMTTMENT_ACCOUNT
	
	if(getFinalize_yn().equals("Yes") && appvl_yn.equals("FA")){
	
		String budget_check_yn = "";
			try{
			 budget_check_yn =	checkForNull((String)fetchRecord("SELECT BUDGET_CHECK_REQD_YN FROM PO_PARAMETER").get("BUDGET_CHECK_REQD_YN"),"");
			}catch(Exception e){
				e.printStackTrace();
			}
			if(budget_check_yn.equals("Y")){
			
		if (checkedItemKeys != null && checkedItemKeys.size()>0) {
			detailSize		= checkedItemKeys.size();
			
			ArrayList alUpdateCommtRecord = new ArrayList(detailSize);
			HashMap amountHandler = new HashMap();
			for (int index=0;index<detailSize;index++) {
				if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) {
						continue;
				}

				requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
				
				String amount = "";			
				//int amt;
				Double amt;
				
				
			/*	if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()))){
					amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()));
					amt = Double.parseDouble(amount) + Double.parseDouble(requestDetailBean.getNet_amount());
					amount = new Double(amt).toString();
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),amount);
				}else{
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),checkForNull(requestDetailBean.getNet_amount()));
				}
			*/
			
			//if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()))){
				if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()) +"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()))){
					//amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()));
					amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()) +"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()));
					amt = Double.parseDouble(amount) + Double.parseDouble(requestDetailBean.getNet_amount());
					amount = new Double(amt).toString();
					//amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),amount);
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no())+"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()),amount);
					
				}else{
				//	amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),checkForNull(requestDetailBean.getNet_amount()));
				amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no())+"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()),checkForNull(requestDetailBean.getNet_amount()));
				}	
				
				
			}
				
			System.out.println("amountHandler = "+amountHandler);
			Iterator it = amountHandler.entrySet().iterator();
			while (it.hasNext()) {
				ArrayList alCommtRecord = new ArrayList();
				ArrayList alBudgetRecord = new ArrayList();
				Map.Entry pairs = (Map.Entry)it.next();
				
				for (String retval: ((String)pairs.getKey()).split("-")){
					alBudgetRecord.add(retval); //COMMNT_CODE , DEPT_NO
				}
				alBudgetRecord.add(getDoc_no());
				
				System.out.println("alBudgetRecord = "+alBudgetRecord);
				
				String prev_net_amount = checkForNull((String)fetchRecord(getPoRepositoryValue("SQL_PO_DTL_SELECT_NET_AMOUNT"),alBudgetRecord).get("ITEM_NET_VALUE"),"0");
				
				
				//starts
				ArrayList chkParameters=new ArrayList();
				for (String retval: ((String)pairs.getKey()).split("-")){
					chkParameters.add(retval); //COMMNT_CODE , DEPT_NO
				}
				String override_budget= "";
				override_budget =	checkForNull((String)fetchRecord("SELECT OVERRIDE_BUDGET FROM PO_COMMTTMENT_ACCOUNT WHERE MASTER_CODE = ? AND DEPT_CODE = ? and ACCOUNT_NO = ? and EFF_DATE_FROM = to_date(?,'dd/mm/yyyy')",chkParameters).get("OVERRIDE_BUDGET"),"");
				if(!override_budget.equals("N")){
			//end
				
				alCommtRecord.add(pairs.getValue()); //NET_AMT_CURRENT
				alCommtRecord.add(prev_net_amount); //NET_AMT_PREVIOUS
				alCommtRecord.add(login_by_id);
				alCommtRecord.add(login_at_ws_no);
				alCommtRecord.add(login_facility_id);
				
				
				for (String retval: ((String)pairs.getKey()).split("-")){
					alCommtRecord.add(retval); //COMMNT_CODE , DEPT_NO
				}
				
				
				it.remove(); // avoids a ConcurrentModificationException
				alUpdateCommtRecord.add(alCommtRecord);	
				}
			}
			
			
			hmTableData.put("UpdateCOMMTData",alUpdateCommtRecord);
			hmSQLMap.put("UpdateCOMMTSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_COMMT_CODE_UPDATE_FINALIZE_YES"));
			
			
			
		}
		}	
			
	}
	
	// end 	

// Update Blocked Budget Amount in  PO_COMMTTMENT_ACCOUNT
	
	if(getFinalize_yn().equals("No")){
	
		String budget_check_yn = "";
			try{
			 budget_check_yn =	checkForNull((String)fetchRecord("SELECT BUDGET_CHECK_REQD_YN FROM PO_PARAMETER").get("BUDGET_CHECK_REQD_YN"),"");
			}catch(Exception e){
				e.printStackTrace();
			}
			if(budget_check_yn.equals("Y")){
			
		if (checkedItemKeys != null && checkedItemKeys.size()>0) {
	
			detailSize		= checkedItemKeys.size();
			
			ArrayList alUpdateBlockRecord = new ArrayList(detailSize);
			HashMap amountHandler = new HashMap();
			for (int index=0;index<detailSize;index++) {
				if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) {
						continue;
				}

				requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
				
				String amount = "";			
				Double amt;
				
				
			/*	if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()))){
					amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()));
					amt = Double.parseDouble(amount) + Double.parseDouble(requestDetailBean.getNet_amount());
					amount = new Double(amt).toString();
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),amount);
				}else{
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),checkForNull(requestDetailBean.getNet_amount()));
				}
			*/
			
			//if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()))){
				if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()) +"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()))){
					//amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()));
					amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()) +"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()));
					amt = Double.parseDouble(amount) + Double.parseDouble(requestDetailBean.getNet_amount());
					amount = new Double(amt).toString();
					//amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),amount);
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no())+"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()),amount);
					
				}else{
				//	amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),checkForNull(requestDetailBean.getNet_amount()));
				amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no())+"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()),checkForNull(requestDetailBean.getNet_amount()));
				}	
				
				
			}
				
			Iterator it = amountHandler.entrySet().iterator();
			while (it.hasNext()) {
				ArrayList alBlockRecord = new ArrayList();
				ArrayList alBudgetRecord = new ArrayList();
				Map.Entry pairs = (Map.Entry)it.next();
				
				for (String retval: ((String)pairs.getKey()).split("-")){
					alBudgetRecord.add(retval); //COMMNT_CODE , DEPT_NO
				}
				alBudgetRecord.add(getDoc_no());
				String prev_net_amount = checkForNull((String)fetchRecord(getPoRepositoryValue("SQL_PO_DTL_SELECT_NET_AMOUNT"),alBudgetRecord).get("ITEM_NET_VALUE"),"0");
				
				
				
				Double net_amt = Double.parseDouble((String)pairs.getValue()) - Double.parseDouble(prev_net_amount);
				
				//starts
				ArrayList chkParameters=new ArrayList();
				for (String retval: ((String)pairs.getKey()).split("-")){
					chkParameters.add(retval); //COMMNT_CODE , DEPT_NO
				}
				String override_budget= "";
				override_budget =	checkForNull((String)fetchRecord("SELECT OVERRIDE_BUDGET FROM PO_COMMTTMENT_ACCOUNT WHERE MASTER_CODE = ? AND DEPT_CODE = ? and ACCOUNT_NO = ? and EFF_DATE_FROM = to_date(?,'dd/mm/yyyy')",chkParameters).get("OVERRIDE_BUDGET"),"");
				if(!override_budget.equals("N")){
			//end
				
				alBlockRecord.add(new Double(net_amt).toString()); //NET_AMT
				alBlockRecord.add(login_by_id);
				alBlockRecord.add(login_at_ws_no);
				alBlockRecord.add(login_facility_id);
				
				
				for (String retval: ((String)pairs.getKey()).split("-")){
					alBlockRecord.add(retval); //COMMNT_CODE , DEPT_NO
				}
				
				
				it.remove(); // avoids a ConcurrentModificationException
				alUpdateBlockRecord.add(alBlockRecord);	
				}
			}
			
			
			hmTableData.put("UpdateBlockData",alUpdateBlockRecord);
			hmSQLMap.put("UpdateBlockSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_COMMT_CODE_UPDATE_FINALIZE_NO"));
			
		}	
		}	
	}
	
	// end 	

		
		
		detailSize = checkedItemKeys.size();
		requestDetailBean = null;
		ArrayList alUpdateRecord = new ArrayList(detailSize);
		for (int index=0;index<detailSize;index++) {
			if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) {
					continue;
			}
			requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
			ArrayList alUpdateDtlRecord = new ArrayList(10);
	

			if(getAllowDecimalsYN((String)requestDetailBean.getItem_code()).equals("N")){
			no_of_decimals = 0;
			}else{
			no_of_decimals=	no_of_decimals_temp;
			}
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getOrder_qty()));//ORDER_QTY
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getUom()));//UOM
			//alUpdateDtlRecord.add("1");//PO_GEN_UOM_CONV_FACTOR
			alUpdateDtlRecord.add(requestDetailBean.getConvFact());//PO_GEN_UOM_CONV_FACTOR
			
			Double conv_fact,order_qty,po_gen_uom_qty;
			conv_fact = Double.parseDouble(requestDetailBean.getConvFact());
			order_qty = Double.parseDouble(requestDetailBean.getOrder_qty());
			po_gen_uom_qty = order_qty * conv_fact ;
			alUpdateDtlRecord.add(new Double(po_gen_uom_qty).toString());//PO_GEN_UOM_QTY
			
			//alUpdateDtlRecord.add(checkForNull(requestDetailBean.getOrder_qty()));//PO_GEN_UOM_QTY
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getPur_price()));//UNIT_PRICE
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getTot_value()));//TOTAL_VALUE
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getDis_type()));  //DISC_INDICATOR
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getDis_amt()));  //DISC_AMOUNT
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getNet_amount()));  //ITEM_NET_VALUE 
			alUpdateDtlRecord.add("COMMNT"); //COMMNT_TYPE
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getCommit_code())); //COMMNT_CODE
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getDept_no())); //DEPT_NO
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getAcc_no())); //ACCOUNT_NO
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getAcc_desc())); //ACCOUNT_NAME
			alUpdateDtlRecord.add(requestDetailBean.getApp_ref()); //APPROVED_YN
			if(checkForNull(requestDetailBean.getApp_ref()).equals("Y")){
				alUpdateDtlRecord.add(login_by_id); //APPROVED_BY
				alUpdateDtlRecord.add(getDoc_date_value()); //APPROVED_DATE
				alUpdateDtlRecord.add(requestDetailBean.getRef_value()); //APPROVAL_REMARKS
			}else {
				alUpdateDtlRecord.add(""); //APPROVED_BY
				alUpdateDtlRecord.add(""); //APPROVED_DATE
				alUpdateDtlRecord.add(""); //APPROVAL_REMARKS
			}
			alUpdateDtlRecord.add(requestDetailBean.getItem_remarks()); //PO_LINE_REMARKS
			
			
			alUpdateDtlRecord.add(login_by_id);
			alUpdateDtlRecord.add(login_at_ws_no);
			alUpdateDtlRecord.add(login_facility_id);
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getUnit_price()));//LIST_PRICE
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getEff_from_dt())); //DEPT_NO
			
			alUpdateDtlRecord.add(getRequest_by_pu());
			alUpdateDtlRecord.add(getDoc_no());
			if(getPo_mode().equals("R") && requestDetailBean.getSrl_no() == 0)
				alUpdateDtlRecord.add(""+requestDetailBean.getReq_srl_no());
			else
				alUpdateDtlRecord.add(""+requestDetailBean.getSrl_no());
			alUpdateRecord.add(alUpdateDtlRecord);
			
		}
		hmTableData.put("UpdateDTLData",alUpdateRecord);
		hmSQLMap.put("UpdateDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_ORDER_DTL_UPDATE"));
	
 	
	
		detailSize = -1;
		if (allItemKeys != null && allItemKeys.size() > 0) {
			allItemKeys.removeAll(checkedItemKeys);
			if (allItemKeys.size() >0) {
				detailSize = allItemKeys.size();
				ArrayList alDeleteRecord = new ArrayList(detailSize);
				for (int index=0;index<detailSize;index++) {
					if((allItemKeys.get(index) == null) || (allItemKeys.get(index).equals(""))) 
							continue;
					requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(allItemKeys.get(index));
					ArrayList alDeleteDtlRecord = new ArrayList(4);
					
					alDeleteDtlRecord.add(getRequest_by_pu());
					alDeleteDtlRecord.add(getDoc_no());
					alDeleteDtlRecord.add(""+requestDetailBean.getSrl_no());
					alDeleteRecord.add(alDeleteDtlRecord);
				}
				
				hmTableData.put("DeleteDTLData",alDeleteRecord);
				hmSQLMap.put("DeleteDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_ORDER_DTL_DELETE"));
			
			}
		}

		
		

		//Get the maximum serial no
											
		alModifyData.add("0");//PO_REVN_NO	
		alModifyData.add(getDoc_date_value());
		alModifyData.add(getDoc_ref());
		alModifyData.add(getFinalize_yn().equals("Yes")?appvl_yn:"UF");
		alModifyData.add(getDelivery_mode());
		alModifyData.add(getPmnt_term());
		alModifyData.add(getQnt_ref());
		alModifyData.add(getTerms_conditions());
		alModifyData.add(getOrder_remarks());
		alModifyData.add(getBlanket_po_yn());
		alModifyData.add(getValid_upto());
		alModifyData.add(getExc_rate());
		alModifyData.add(getGross_poAmt());//PO_GROSS_AMT
		alModifyData.add(getAddi_dist());//PO_DISC_AMT
		alModifyData.add(getNet_poAmt());//PO_NET_AMT
		alModifyData.add(getExp_date());//EXPECTED_DELV_DATE
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id);
		alModifyData.add(login_facility_id);
		alModifyData.add(getPurchase_type());
		alModifyData.add(getDoc_no());
		hmTableData.put("UpdateData",alModifyData);
		hmSQLMap.put("UpdateSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PURCHASE_ORDER_HDR_UPDATE"));
		
		// Update bill devly data
		
		//start for Bill delivery_schedule
	
		
		ArrayList bDArrayList ; 
				
	try{
		
			ArrayList result = new ArrayList();
			ArrayList result_final = new ArrayList();
			if(getPo_mode().equals("R")){	
				result = fetchRecords(PoRepository.getPoKeyValue("SQL_PO_ORDER_BILLDELV_DTL_SELECT"),getDoc_no());
				for(int k=0;k<result.size();k++){
					HashMap hmBill = (HashMap)result.get(k);
					if(!hmBill.get("FACILITY_ID").equals("*A"))
						result_final.add(hmBill.get("FACILITY_ID"));
				}	
					
				
				
						
				if(hmBillRecords.size() > 0){	
					
					bDArrayList	=	(ArrayList)hmBillRecords.get(0);
						if(bDArrayList.size()>0){

							for (int j=0;j<bDArrayList.size();j++) {
								
															
								HashMap	hmExpRecord	=	(HashMap)bDArrayList.get(j);
								
									if((hmExpRecord.get("FACILITY_CODE") == null) || (hmExpRecord.get("FACILITY_CODE").equals(""))) {
										continue;
									}
								
								ArrayList alModifyBillDvlyData        =       new ArrayList();
								ArrayList alInsertBillDvlyData        =       new ArrayList();
								
								
								for(int k=0;k<result.size();k++){
									HashMap hmBill = (HashMap)result.get(k);
									if(hmBill.get("FACILITY_ID").equals("*A"))
									 continue;
							
			
								if(result_final.contains(hmExpRecord.get("FACILITY_CODE"))){	 
									if(hmExpRecord.get("FACILITY_CODE").equals(hmBill.get("FACILITY_ID"))){
														
										alModifyBillDvlyData.add(hmExpRecord.get("BILL_TO")); //BILL_TO_ADDR
										alModifyBillDvlyData.add(hmExpRecord.get("DELIVER_TO")); //DELV_TO_ADDR
										alModifyBillDvlyData.add(login_by_id);
										alModifyBillDvlyData.add(login_at_ws_no);
										alModifyBillDvlyData.add(login_facility_id);
										alModifyBillDvlyData.add(hmExpRecord.get("FACILITY_CODE")); // FACILITY_ID
										alModifyBillDvlyData.add(getDoc_no());
										alModifyBillDeliveryData.add(alModifyBillDvlyData);
								
									}
									}else{
								
										alInsertBillDvlyData.add(getDoc_no());
										alInsertBillDvlyData.add(hmExpRecord.get("FACILITY_CODE")); // FACILITY_ID
										alInsertBillDvlyData.add(hmExpRecord.get("BILL_TO")); //BILL_TO_ADDR
										alInsertBillDvlyData.add(hmExpRecord.get("DELIVER_TO")); //DELV_TO_ADDR
										alInsertBillDvlyData.add(login_by_id);
										alInsertBillDvlyData.add(login_at_ws_no);
										alInsertBillDvlyData.add(login_facility_id);
										alInsertBillDvlyData.add(login_by_id);
										alInsertBillDvlyData.add(login_at_ws_no);
										alInsertBillDvlyData.add(login_facility_id);
										alInsertBillDeliveryData.add(alInsertBillDvlyData);
									}
								}
									
							}	
						}		
				//	}
				
				}
				
				if(itemKeys.size() > 0){
					
					ArrayList alModifyBillDvlyData        =       new ArrayList();
					ArrayList alInsertBillDvlyData        =       new ArrayList();
					String facility_id = "";
					for(int k=0;k<result.size();k++){
						HashMap hmBill = (HashMap)result.get(k);
						if(hmBill.get("FACILITY_ID").equals("*A")){
						 facility_id = (String)hmBill.get("FACILITY_ID");
						 break;
						 }
					}
						
						if(facility_id.equals("*A")){
							
							alModifyBillDvlyData.add(getBill_to_address());
							alModifyBillDvlyData.add(getDeliver_to_address());
							alModifyBillDvlyData.add(login_by_id);
							alModifyBillDvlyData.add(login_at_ws_no);
							alModifyBillDvlyData.add(login_facility_id);
							alModifyBillDvlyData.add("*A");
							alModifyBillDvlyData.add(getDoc_no());
							alModifyBillDeliveryData.add(alModifyBillDvlyData);
							
						}else{
						
							
							alInsertBillDvlyData.add(getDoc_no());
							alInsertBillDvlyData.add("*A"); // FACILITY_ID
							alInsertBillDvlyData.add(getBill_to_address()); //BILL_TO_ADDR
							alInsertBillDvlyData.add(getDeliver_to_address()); //DELV_TO_ADDR
							alInsertBillDvlyData.add(login_by_id);
							alInsertBillDvlyData.add(login_at_ws_no);
							alInsertBillDvlyData.add(login_facility_id);
							alInsertBillDvlyData.add(login_by_id);
							alInsertBillDvlyData.add(login_at_ws_no);
							alInsertBillDvlyData.add(login_facility_id);
							alInsertBillDeliveryData.add(alInsertBillDvlyData);
						}
					
				}
			} 
			else {
				ArrayList alModifyBillDvlyData        =       new ArrayList();
				alModifyBillDvlyData.add(getBill_to_address());
				alModifyBillDvlyData.add(getDeliver_to_address());
				alModifyBillDvlyData.add(login_by_id);
				alModifyBillDvlyData.add(login_at_ws_no);
				alModifyBillDvlyData.add(login_facility_id);
				alModifyBillDvlyData.add("*A");
				alModifyBillDvlyData.add(getDoc_no());
				alModifyBillDeliveryData.add(alModifyBillDvlyData);
			
			}
			
			

			
		}catch(Exception e){
			e.printStackTrace();			
		}

	
	//end for Bill delivery_schedule
	
		
		
		hmTableData.put("UpdateBillDvlyData",alModifyBillDeliveryData);
		hmSQLMap.put("UpdateBillDvlySQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_ORDER_BILLDELV_DTL_UPDATE"));
		hmTableData.put("InsertBillDvlyData",alInsertBillDeliveryData);
		hmSQLMap.put("InsertBillDvlySQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_ORDER_BILLDELV_DTL_INSERT"));
				
		ArrayList req_dtl=new ArrayList();
		ArrayList req_hdr=new ArrayList();
		//ArrayList mm_item_dtl=new ArrayList();
		
	/*	if(getFinalize_yn().equals("Yes") && appvl_yn.equals("FA")){
			
			// Update QTY_ON_ORDER & LAST_PUR_COST in MM_ITEM 	
			mm_item_dtl=(ArrayList)newMMITEMUpdate();
			System.out.println("mm_item_dtl in po bean modify = "+mm_item_dtl);
			hmTableData.put("UpdateMMITEMData",mm_item_dtl);
			hmSQLMap.put("UpdateMMITEMSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_MM_ITEM_UPDATE"));
		}
	*/	
		
		if(getFinalize_yn().equals("Yes") && appvl_yn.equals("FA") && getPo_mode().equals("R")){
		
			// Update Request Detail 	
			req_dtl=(ArrayList)newReqDetPOAQtyUpdate();
			
			hmSQLMap.put("UpdateREQDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQ_DTL_PO_QTY_AND_BLOCKED_QTY_UPDATE"));
			hmTableData.put("UpdateREQDTLData",req_dtl);
			
			// Update Request Header
			req_hdr=(ArrayList)newReqHdrUpdate();
			
			hmSQLMap.put("UpdateREQHDRSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQ_HDR_UPDATE"));
			hmTableData.put("UpdateREQHDRData",req_hdr);
		}
		
		if(getFinalize_yn().equals("No") && getPo_mode().equals("R")){
		
		// Update Request Detail po_blocked_qty	
			req_dtl=(ArrayList)newReqDetUpdate();
			
			hmSQLMap.put("UpdateREQDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQ_DTL_PO_BLOCKED_QTY_UPDATE"));
			hmTableData.put("UpdateREQDTLData",req_dtl);
		
		
		}
		
			
		// delete selected record from PO_ORDER_DELV_SCH
		
		
		ArrayList devlArrayList1;
		ArrayList alDeleteRecord = new ArrayList();
		if (hmExpRecords.size() >0) {
			String item_code = "";
			for (int i=0;i<allItemKeys.size();i++) {
					
					 item_code = (String)allItemKeys.get(i);
						
					 if(hmExpRecords.containsKey(item_code)){
					 
						devlArrayList1	=	(ArrayList)hmExpRecords.get(item_code);
						
						HashMap	hmExpRecord	=	(HashMap)devlArrayList1.get(0);
						
						
						ArrayList alDeleteDtlRecord = new ArrayList();
						alDeleteDtlRecord.add(getDoc_no());
						alDeleteDtlRecord.add(hmExpRecord.get("ITEM_CODE"));
						alDeleteRecord.add(alDeleteDtlRecord);
					 }else{

							requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(item_code);

							String del_date = (String)requestDetailBean.getDel_date();

							if( del_date == null || del_date.equals(""))
							continue;
						
							
								
							ArrayList alDeleteDtlRecord = new ArrayList();
							
							alDeleteDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
							alDeleteDtlRecord.add(""+(i+1));//PO_SRL_NO
							alDeleteRecord.add(alDeleteDtlRecord);	
						
						}
			}

				
				hmTableData.put("DeleteDevlDTLData",alDeleteRecord);
				hmSQLMap.put("DeleteDevlDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_DEVL_DTL_DELETE"));
			
		}
		else{			

					
					if (allItemKeys != null && allItemKeys.size() > 0) {
					if (allItemKeys.size() >0) {
						int detailSize1 = allItemKeys.size();

						for (int index=0;index<detailSize1;index++) {
								
							if((allItemKeys.get(index) == null) || (allItemKeys.get(index).equals(""))) 
							continue;
								
							requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(allItemKeys.get(index));
						
							
								
							ArrayList alDevyRecord = new ArrayList();
							
							alDevyRecord.add(getDoc_no());//PO_NO
							alDevyRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
							alDeleteRecord.add(alDevyRecord);		
				
					}
					
					
					hmTableData.put("DeleteDevlDTLData",alDeleteRecord);
					hmSQLMap.put("DeleteDevlDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_DEVL_DTL_DELETE"));
				}
			}
		}
		
		
		
		// end
		
		
		
		
		// delete exisiting record from PO_ORDER_DELV_SCH
		
		
		ArrayList devlArrayList;
		if (hmExpRecords.size() >0) {
			String item_code = "";
			for (int i=0;i<itemKeys.size();i++) {
					
					 item_code = (String)itemKeys.get(i);
						
					 if(hmExpRecords.containsKey(item_code)){
					 
						devlArrayList	=	(ArrayList)hmExpRecords.get(item_code);
						
						HashMap	hmExpRecord	=	(HashMap)devlArrayList.get(0);
						
						
						ArrayList alDeleteDtlRecord = new ArrayList();
						alDeleteDtlRecord.add(getDoc_no());
						alDeleteDtlRecord.add(hmExpRecord.get("ITEM_CODE"));
						alDeleteRecord.add(alDeleteDtlRecord);
					 }else{

							requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(item_code);

							String del_date = (String)requestDetailBean.getDel_date();

							if( del_date == null || del_date.equals(""))
							continue;
						
							
								
							ArrayList alDeleteDtlRecord = new ArrayList();
							
							alDeleteDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
							alDeleteDtlRecord.add(""+(i+1));//PO_SRL_NO
							alDeleteRecord.add(alDeleteDtlRecord);	
						
						}
			}

				
				hmTableData.put("DeleteDevlDTLData",alDeleteRecord);
				hmSQLMap.put("DeleteDevlDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_DEVL_DTL_DELETE"));
			
		}
		else{			

					int detailSize1 = checkedItemKeys.size();

						for (int index=0;index<detailSize1;index++) {

							if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
							continue;
								
							requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
						
							String del_date = (String)requestDetailBean.getDel_date();

							if( del_date == null || del_date.equals(""))
							continue;
						
							
								
							ArrayList alDevyRecord = new ArrayList();
							
							alDevyRecord.add(getDoc_no());//PO_NO
							alDevyRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
							alDeleteRecord.add(alDevyRecord);		
				
					}
					
					
					hmTableData.put("DeleteDevlDTLData",alDeleteRecord);
					hmSQLMap.put("DeleteDevlDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_DEVL_DTL_DELETE"));
		}
		
		
		
		// end
		
			
		//start for delivery_schedule insert
	
	try{
	
		alDevyParams.add(getDoc_no());
			
		
		int po_srl_no_devy = Integer.parseInt((String)fetchRecord(getPoRepositoryValue("SQL_PURCHASE_ORDER_DEVY_DTL_MAX_SRL_NO"),alDevyParams).get("LAST_SRL_NO"));
		ArrayList sourceArrayList;
		ArrayList dummyItemKeys = new ArrayList();
		int devl_srl_no=1;
		String item_code = "";

		
		
		if(hmExpRecords.size()>0){
			if(itemKeysAdded.size() > 0){
				dummyItemKeys.addAll(itemKeysAdded);
			}else{
				dummyItemKeys.addAll(itemKeys);
			}
			
		 

				for (int i=0;i<dummyItemKeys.size();i++) {
								
					 item_code = (String)dummyItemKeys.get(i);

						sourceArrayList	=	(ArrayList)hmExpRecords.get(item_code);

						
						po_srl_no_devy = ++po_srl_no_devy;	
						if(hmExpRecords.containsKey(item_code)){
								if(sourceArrayList.size()>0){
									
								  for (int j=0;j<sourceArrayList.size();j++) {
									
									HashMap	hmExpRecord	=	(HashMap)sourceArrayList.get(j);

									

									if((hmExpRecord.get("DELV_DATE") == null) || (hmExpRecord.get("DELV_DATE").equals(""))) {
										devl_srl_no = 1;
										continue;
									}
											
									requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(hmExpRecord.get("ITEM_CODE"));
									
									ArrayList alInsertDeliveryRecord        =       new ArrayList();
									alInsertDeliveryRecord.add(getDoc_no()); // PO_NO
									alInsertDeliveryRecord.add(hmExpRecord.get("ITEM_CODE")); // ITEM_CODE
									
									if(requestDetailBean.getSrl_no()==-1 || requestDetailBean.getSrl_no()== 0)
										alInsertDeliveryRecord.add(""+(po_srl_no_devy));
									else
										alInsertDeliveryRecord.add(""+(requestDetailBean.getSrl_no()));
								
									alInsertDeliveryRecord.add(""+(j+1)); //DELV_SRL_NO
									alInsertDeliveryRecord.add(hmExpRecord.get("DELV_QTY")); //DELV_QTY
									alInsertDeliveryRecord.add(hmExpRecord.get("DELV_DATE")); // DELV_DATE
									alInsertDeliveryRecord.add("ND"); //DELV_STATUS
									alInsertDeliveryRecord.add(login_by_id);
									alInsertDeliveryRecord.add(login_at_ws_no);
									alInsertDeliveryRecord.add(login_facility_id);
									alInsertDeliveryRecord.add(login_by_id);
									alInsertDeliveryRecord.add(login_at_ws_no);
									alInsertDeliveryRecord.add(login_facility_id);

									alInsertDeliveryData.add(alInsertDeliveryRecord);							
								}
							}
						}else{

							requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(item_code);

							String del_date = (String)requestDetailBean.getDel_date();

							if( del_date == null || del_date.equals(""))
							continue;
						
							
								
							ArrayList alDevyRecord = new ArrayList();
							
							alDevyRecord.add(getDoc_no());//PO_NO
							alDevyRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
						
							if(requestDetailBean.getSrl_no()==-1 || requestDetailBean.getSrl_no()== 0)
								alDevyRecord.add(""+(++po_srl_no_devy));
							else
								alDevyRecord.add(""+(requestDetailBean.getSrl_no()));
						
							alDevyRecord.add("1");//DELV_SRL_NO
							alDevyRecord.add(requestDetailBean.getOrder_qty());//DELV_QTY
							alDevyRecord.add(requestDetailBean.getDel_date());//DELV_DATE
							alDevyRecord.add("ND");//DELV_STATUS
							alDevyRecord.add(login_by_id);
							alDevyRecord.add(login_at_ws_no);
							alDevyRecord.add(login_facility_id);
							alDevyRecord.add(login_by_id);
							alDevyRecord.add(login_at_ws_no);
							alDevyRecord.add(login_facility_id);

							alInsertDeliveryData.add(alDevyRecord);	
						
						}
				}
		}else{			
					
					int detailSize1 = checkedItemKeys.size();

						for (int index=0;index<detailSize1;index++) {

							if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
							continue;
								
							requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
						
							String del_date = (String)requestDetailBean.getDel_date();

							if( del_date == null || del_date.equals(""))
							continue;
						
							
								
							ArrayList alDevyRecord = new ArrayList();
							
							alDevyRecord.add(getDoc_no());//PO_NO
							alDevyRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
						
							if(requestDetailBean.getSrl_no()==-1 || requestDetailBean.getSrl_no()== 0)
								alDevyRecord.add(""+(++po_srl_no_devy));
							else
								alDevyRecord.add(""+(requestDetailBean.getSrl_no()));	
						
							alDevyRecord.add("1");//DELV_SRL_NO
							alDevyRecord.add(requestDetailBean.getOrder_qty());//DELV_QTY
							alDevyRecord.add(requestDetailBean.getDel_date());//DELV_DATE
							alDevyRecord.add("ND");//DELV_STATUS
							alDevyRecord.add(login_by_id);
							alDevyRecord.add(login_at_ws_no);
							alDevyRecord.add(login_facility_id);
							alDevyRecord.add(login_by_id);
							alDevyRecord.add(login_at_ws_no);
							alDevyRecord.add(login_facility_id);

							alInsertDeliveryData.add(alDevyRecord);		
				
					}
		}
			
			


		}catch(Exception e){
			e.printStackTrace();			
		}

		hmTableData.put("InsertDELVData",alInsertDeliveryData);
		hmSQLMap.put("InsertDELVSQL", PoRepository.getPoKeyValue("SQL_PO_ORDER_DELV_SCH_INSERT")); 
		
	//end for delivery_schedule insert
	
	
	
	
	
	
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PurchaseOrder",PurchaseOrderHome.class,getLocalEJB());
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


public ArrayList getApprovedYN() {
		
		PurchaseOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alAppYNRecord = new ArrayList(detailSize);
		
		try{
		
		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
		
				
			ArrayList alAppRecord = new ArrayList();
			alAppRecord.add(requestDetailBean.getApp_ref()); //APPROVED_YN
			
			alAppYNRecord.add(alAppRecord);	
		}		
	
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alAppYNRecord;
	}

	
public ArrayList checkApprovedYN() {
		
		PurchaseOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alAppYNRecord = new ArrayList(detailSize);
		
		try{
		
		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
		
				
			ArrayList alAppRecord = new ArrayList();

			alAppRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
			alAppRecord.add(requestDetailBean.getApp_ref()); //APPROVED_YN
			
			alAppYNRecord.add(alAppRecord);	
		}		
	
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return alAppYNRecord;
	}
	
	
	

// Blocked budget amount in Committment_account 

public ArrayList newBlock() {

		PurchaseOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alUpdateBlockRecord = new ArrayList(detailSize);
		HashMap amountHandler = new HashMap();
	try{
		
	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
		
				
			String amount = "";			
			Double amt;
		
				
			/*	if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()))){
					amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()));
					amt = Double.parseDouble(amount) + Double.parseDouble(requestDetailBean.getNet_amount());
					amount = new Double(amt).toString();
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),amount);
				}else{
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),checkForNull(requestDetailBean.getNet_amount()));
				}
			*/
			//if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()))){
				if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()) +"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()))){
					//amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()));
					amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()) +"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()));
					amt = Double.parseDouble(amount) + Double.parseDouble(requestDetailBean.getNet_amount());
					amount = new Double(amt).toString();
					//amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),amount);
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no())+"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()),amount);
					
				}else{
				//	amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),checkForNull(requestDetailBean.getNet_amount()));
				amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no())+"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()),checkForNull(requestDetailBean.getNet_amount()));
				}
			
				
				
			}
				
			Iterator it = amountHandler.entrySet().iterator();
			while (it.hasNext()) {
				ArrayList alBlockRecord = new ArrayList();
				Map.Entry pairs = (Map.Entry)it.next();
				
			//starts
				ArrayList chkParameters=new ArrayList();
				for (String retval: ((String)pairs.getKey()).split("-")){
					chkParameters.add(retval); //COMMNT_CODE , DEPT_NO
				}
				System.out.println("chkParameters = "+chkParameters);
				String override_budget= "";
				override_budget =	checkForNull((String)fetchRecord("SELECT OVERRIDE_BUDGET FROM PO_COMMTTMENT_ACCOUNT WHERE MASTER_CODE = ? AND DEPT_CODE = ? and  ACCOUNT_NO = ? and EFF_DATE_FROM = to_date(?,'dd/mm/yyyy')",chkParameters).get("OVERRIDE_BUDGET"),"");
				if(!override_budget.equals("N")){
			//end	
				alBlockRecord.add(pairs.getValue()); //NET_AMT
				alBlockRecord.add(login_by_id);
				alBlockRecord.add(login_at_ws_no);
				alBlockRecord.add(login_facility_id);
				
				
				for (String retval: ((String)pairs.getKey()).split("-")){
					alBlockRecord.add(retval); //COMMNT_CODE , DEPT_NO
				}
				
				
				it.remove(); // avoids a ConcurrentModificationException
				alUpdateBlockRecord.add(alBlockRecord);	
				}
			}
			
			
		
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alUpdateBlockRecord;
	}
	
	
// Get over ride budget from validate	


public HashMap newOverride() {
		
		PurchaseOrderDetailBean requestDetailBean;
		ArrayList dummyItemKeys = new ArrayList();
		dummyItemKeys.addAll(itemKeys);
		dummyItemKeys.addAll(reqKeys); 
		dummyItemKeys.addAll(itemKeysAdded);
		int detailSize = dummyItemKeys.size();
		HashMap amountHandler = new HashMap();
	try{
		
		java.util.Collections.reverse(dummyItemKeys);
		
		
		
		for (int index=0;index<detailSize;index++) {
		if((dummyItemKeys.get(index) == null) || (dummyItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(dummyItemKeys.get(index));
		
		
				
			String amount = "";			
				Double amt;	
				
				
				//if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()))){
				if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()) +"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()))){
					//amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()));
					amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()) +"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()));
					amt = Double.parseDouble(amount) + Double.parseDouble(requestDetailBean.getNet_amount());
					amount = new Double(amt).toString();
					//amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),amount);
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no())+"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()),amount);
					
				}else{
				//	amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),checkForNull(requestDetailBean.getNet_amount()));
				amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no())+"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()),checkForNull(requestDetailBean.getNet_amount()));
				}
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
				
			
		}

		return amountHandler;
	}	


// end

	
	
// Committment_account details

public ArrayList newCommt() {

		PurchaseOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alUpdateCommtRecord = new ArrayList(detailSize);
		HashMap amountHandler = new HashMap();
	try{
		
	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
		
				
			String amount = "";			
			Double amt;	
				
				
			/*	if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()))){
					amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()));
					amt = Double.parseDouble(amount) + Double.parseDouble(requestDetailBean.getNet_amount());
					amount = new Double(amt).toString();
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),amount);
				}else{
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),checkForNull(requestDetailBean.getNet_amount()));
				}
			*/	
				
				//if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()))){
				if(amountHandler.containsKey(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()) +"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()))){
					//amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()));
					amount = (String)amountHandler.get(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()) +"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()));
					amt = Double.parseDouble(amount) + Double.parseDouble(requestDetailBean.getNet_amount());
					amount = new Double(amt).toString();
					//amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),amount);
					amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no())+"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()),amount);
					
				}else{
				//	amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no()),checkForNull(requestDetailBean.getNet_amount()));
				amountHandler.put(checkForNull(requestDetailBean.getCommit_code())+"-"+checkForNull(requestDetailBean.getDept_no())+"-"+checkForNull(requestDetailBean.getAcc_no())+"-"+checkForNull(requestDetailBean.getEff_from_dt()),checkForNull(requestDetailBean.getNet_amount()));
				}
				
				
			}
				
			Iterator it = amountHandler.entrySet().iterator();
			while (it.hasNext()) {
				ArrayList alCommtRecord = new ArrayList();
				ArrayList alBudgetRecord = new ArrayList();
				Map.Entry pairs = (Map.Entry)it.next();
				
				for (String retval: ((String)pairs.getKey()).split("-")){
					alBudgetRecord.add(retval); //COMMNT_CODE , DEPT_NO
				}
				
			//starts
				ArrayList chkParameters=new ArrayList();
				for (String retval: ((String)pairs.getKey()).split("-")){
					chkParameters.add(retval); //COMMNT_CODE , DEPT_NO
				}
				String override_budget= "";
				override_budget =	checkForNull((String)fetchRecord("SELECT OVERRIDE_BUDGET FROM PO_COMMTTMENT_ACCOUNT WHERE MASTER_CODE = ? AND DEPT_CODE = ?  and ACCOUNT_NO = ? and EFF_DATE_FROM = to_date(?,'dd/mm/yyyy')",chkParameters).get("OVERRIDE_BUDGET"),"");
				if(!override_budget.equals("N")){
			//end	
					alCommtRecord.add(pairs.getValue()); //NET_AMT
					alCommtRecord.add(login_by_id);
					alCommtRecord.add(login_at_ws_no);
					alCommtRecord.add(login_facility_id);
				
				
				for (String retval: ((String)pairs.getKey()).split("-")){
					alCommtRecord.add(retval); //COMMNT_CODE , DEPT_NO
				}
				
				
				it.remove(); // avoids a ConcurrentModificationException
				alUpdateCommtRecord.add(alCommtRecord);	
				}
			}
			
			
		
		}catch(Exception e){
			e.printStackTrace();
				
			
		}

		return alUpdateCommtRecord;
	}


// Update MM_ITEM Record

/*
public ArrayList newMMITEMUpdate() {
		
		
		PurchaseOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alMMITEMUpdateRecord = new ArrayList(detailSize);
	
	try{

		java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
		System.out.println("requestDetailBean in PO bean = "+requestDetailBean);
				
			ArrayList alMMITEMRecord = new ArrayList();
			
			alMMITEMRecord.add(requestDetailBean.getOrder_qty());//ORDER_QTY
			alMMITEMRecord.add(checkForNull(requestDetailBean.getUnit_price()));//UNIT_PRICE
			alMMITEMRecord.add(requestDetailBean.getUom());////PUR_UOM_CODE
			alMMITEMRecord.add(login_by_id);
			alMMITEMRecord.add(login_at_ws_no);
			alMMITEMRecord.add(login_facility_id);
			alMMITEMRecord.add(requestDetailBean.getItem_code());
			alMMITEMUpdateRecord.add(alMMITEMRecord);
			
			}	
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alMMITEMUpdateRecord;
	}
*/	
	
	
// Update Request Detail Record

public ArrayList newReqDetPOUpdate() {
		
		PurchaseOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alReqDtlUpdateRecord = new ArrayList(detailSize);
	try{

	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
		
				
			ArrayList alReqDtlRecord = new ArrayList();
			
			if(requestDetailBean.getReq_no() != null && requestDetailBean.getReq_no() != ""){
			
			alReqDtlRecord.add(requestDetailBean.getOrder_qty());//ORDER_QTY
			alReqDtlRecord.add(requestDetailBean.getUom());//UOM
			
			alReqDtlRecord.add(login_by_id);
			alReqDtlRecord.add(login_at_ws_no);
			alReqDtlRecord.add(login_facility_id);
			alReqDtlRecord.add(requestDetailBean.getItem_code());
			alReqDtlRecord.add(requestDetailBean.getReq_no());
			alReqDtlRecord.add(""+requestDetailBean.getReq_srl_no());
			alReqDtlUpdateRecord.add(alReqDtlRecord);
			}
			
			}	
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alReqDtlUpdateRecord;
	}
	
	
// Update Request Detail Record

public ArrayList newReqDetUpdate() {
		
		PurchaseOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alReqDtlUpdateRecord = new ArrayList(detailSize);
	try{

	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
		
				
			ArrayList alReqDtlRecord = new ArrayList();
			
			if(requestDetailBean.getReq_no() != null && requestDetailBean.getReq_no() != ""){
			
			ArrayList alParams = new ArrayList();
			alParams.add(getDoc_no());
			alParams.add(requestDetailBean.getReq_no());
			alParams.add(""+requestDetailBean.getReq_srl_no());
			
			String po_qty = (String)fetchRecord(getPoRepositoryValue("SQL_PURCHASE_ORDER_DTL_PO_QTY"),alParams).get("PO_QTY");
			
			alReqDtlRecord.add(checkForNull(po_qty,"0"));// old_po_QTY
			alReqDtlRecord.add(requestDetailBean.getOrder_qty());//ORDER_QTY
			alReqDtlRecord.add(requestDetailBean.getUom());//UOM
			
			alReqDtlRecord.add(login_by_id);
			alReqDtlRecord.add(login_at_ws_no);
			alReqDtlRecord.add(login_facility_id);
			alReqDtlRecord.add(requestDetailBean.getItem_code());
			alReqDtlRecord.add(requestDetailBean.getReq_no());
			alReqDtlRecord.add(""+requestDetailBean.getReq_srl_no());
			alReqDtlUpdateRecord.add(alReqDtlRecord);
			}
			
			}	
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alReqDtlUpdateRecord;
	}
//Update Request Detail PO_Qty 
	
	
public ArrayList newReqDetPOAQtyUpdate() {
		
		PurchaseOrderDetailBean requestDetailBean;
		int detailSize = checkedItemKeys.size();
		ArrayList alReqDtlUpdateRecord = new ArrayList(detailSize);
	try{

	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
				
			ArrayList alReqDtlRecord = new ArrayList();
			
			if(requestDetailBean.getReq_no() != null && requestDetailBean.getReq_no() != ""){
			
			ArrayList alBlockedRecord = new ArrayList();
			alBlockedRecord.add(requestDetailBean.getItem_code());	
			alBlockedRecord.add(requestDetailBean.getReq_no());	
			alBlockedRecord.add(""+requestDetailBean.getReq_srl_no());	
			
			String prev_blocked_qty = checkForNull((String)fetchRecord(getPoRepositoryValue("SQL_PO_REQ_DTL_SELECT_BLOCKED_QTY"),alBlockedRecord).get("PO_BLOCKED_QTY"),"0");
			
			System.out.println("prev_blocked_qty in po bean = "+prev_blocked_qty);
						
		//	alReqDtlRecord.add(requestDetailBean.getOrder_qty());//ORDER_QTY
			alReqDtlRecord.add(prev_blocked_qty);//PO_BLOCKED_QTY
			alReqDtlRecord.add(requestDetailBean.getOrder_qty());//ORDER_QTY
			alReqDtlRecord.add(requestDetailBean.getUom());//UOM
			
			alReqDtlRecord.add(login_by_id);
			alReqDtlRecord.add(login_at_ws_no);
			alReqDtlRecord.add(login_facility_id);
			alReqDtlRecord.add(requestDetailBean.getItem_code());
			alReqDtlRecord.add(requestDetailBean.getReq_no());
			alReqDtlRecord.add(""+requestDetailBean.getReq_srl_no());
			alReqDtlUpdateRecord.add(alReqDtlRecord);
			}
			
			}	
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alReqDtlUpdateRecord;
	}
	
	
	
	
	
// Update Request Header Record

public ArrayList newReqHdrUpdate() {
		
		
		PurchaseOrderDetailBean requestDetailBean;
		PurchaseOrderDetailBean requestDetailBean1;
		int detailSize = checkedItemKeys.size();
		ArrayList alReqHdrUpdateRecord = new ArrayList(detailSize);
			

		try{

	//	java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
		
				
			ArrayList alReqHdrRecord = new ArrayList();
			if(requestDetailBean.getReq_no() != null && requestDetailBean.getReq_no() != ""){
			
			String tot_req_qty = "";
			//String order_qty = "";
			String pre_ord_qty = "";
			tot_req_qty =	checkForNull((String)fetchRecord("SELECT SUM(REQ_QTY)REQ_QTY FROM PO_REQUEST_DETAIL WHERE REQ_NO = ? ",requestDetailBean.getReq_no()).get("REQ_QTY"),"");	
			pre_ord_qty =	checkForNull((String)fetchRecord("SELECT SUM(PO_QTY)PO_QTY FROM PO_REQUEST_DETAIL WHERE REQ_NO = ? ",requestDetailBean.getReq_no()).get("PO_QTY"),"");	
			int tot_req_qty1 = Integer.parseInt(checkForNull(tot_req_qty,"0"));	
			int pre_ord_qty1 = Integer.parseInt(checkForNull(pre_ord_qty,"0"));	
			int order_qty1 = 0;
				
			for (int j=0;j<detailSize;j++) {
				if((checkedItemKeys.get(j) == null) || (checkedItemKeys.get(j).equals(""))) 
					continue;
				requestDetailBean1 = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(j));
				
				if(requestDetailBean1.getReq_no() != null && requestDetailBean1.getReq_no() != ""){
					
					if(requestDetailBean1.getOrder_qty() != null && requestDetailBean1.getOrder_qty() != ""){
						order_qty1 = order_qty1 + Integer.parseInt(requestDetailBean1.getOrder_qty()) ; 
					}		
				}
				
			}
						
			if((order_qty1 + pre_ord_qty1) < tot_req_qty1){
				alReqHdrRecord.add("PO");//REQ_STATUS
			}else{
				alReqHdrRecord.add("OR");//REQ_STATUS
			}	
			
			alReqHdrRecord.add(login_by_id);
			alReqHdrRecord.add(login_at_ws_no);
			alReqHdrRecord.add(login_facility_id);
			alReqHdrRecord.add(requestDetailBean.getReq_no());
			alReqHdrUpdateRecord.add(alReqHdrRecord);
			}
		}	
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alReqHdrUpdateRecord;
	}
	
	

public ArrayList newInsert() {
		
		PurchaseOrderDetailBean requestDetailBean;
		java.util.ArrayList alUpdateItemData = new ArrayList();
		int detailSize = checkedItemKeys.size();
		ArrayList alDtlInsertRecord = new ArrayList(detailSize);
		int no_of_decimals					=			getNoOfDecimals();
		int no_of_decimals_temp				=			getNoOfDecimals();
		try{
	
		java.util.Collections.reverse(checkedItemKeys);

		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PurchaseOrderDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
		
				
			ArrayList alDtlRecord = new ArrayList();
			alDtlRecord.add(getRequest_by_pu());//PURCHASE_UNIT_CODE
			alDtlRecord.add(getDoc_no());//PO_NO
			if(getPo_mode().equals("D")){	
				alDtlRecord.add("*A");// REQ_FACILITY_ID
				alDtlRecord.add("*A");// REQ_STORE_CODE
			}else if(getPo_mode().equals("R")){	
				if(requestDetailBean.getFacility_code() != null && requestDetailBean.getFacility_code() != ""){
					alDtlRecord.add(requestDetailBean.getFacility_code());// REQ_FACILITY_ID
					alDtlRecord.add(requestDetailBean.getStore_code());// REQ_STORE_CODE
				}else{
					alDtlRecord.add("*A");// REQ_FACILITY_ID
					alDtlRecord.add("*A");// REQ_STORE_CODE
				}
			}
			alDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
			alDtlRecord.add(""+(index+1));//PO_SRL_NO
			alDtlRecord.add(requestDetailBean.getOrder_qty());//ORDER_QTY
			alDtlRecord.add(requestDetailBean.getUom());//UOM
			
			
		//	alDtlRecord.add("1");//PO_GEN_UOM_CONV_FACTOR
			alDtlRecord.add(requestDetailBean.getConvFact());//PO_GEN_UOM_CONV_FACTOR
			
			if(getAllowDecimalsYN((String)requestDetailBean.getItem_code()).equals("N")){
			no_of_decimals = 0;
			}else{
			no_of_decimals=	no_of_decimals_temp;
			}
			
			Double conv_fact,order_qty,po_gen_uom_qty;
			conv_fact = Double.parseDouble(requestDetailBean.getConvFact());
			order_qty = Double.parseDouble(requestDetailBean.getOrder_qty());
			po_gen_uom_qty = order_qty * conv_fact ;
			
			alDtlRecord.add(new Double(po_gen_uom_qty).toString());//PO_GEN_UOM_QTY
		//	alDtlRecord.add(requestDetailBean.getOrder_qty());//PO_GEN_UOM_QTY
			
			alDtlRecord.add(requestDetailBean.getPur_price());//UNIT_PRICE
			alDtlRecord.add(requestDetailBean.getTot_value());//TOTAL_VALUE
			alDtlRecord.add(requestDetailBean.getDis_type());  //DISC_INDICATOR
			alDtlRecord.add(requestDetailBean.getDis_amt());  //DISC_AMOUNT
			alDtlRecord.add(requestDetailBean.getNet_amount());  //ITEM_NET_VALUE 
			alDtlRecord.add("COMMNT"); //COMMNT_TYPE
			alDtlRecord.add(requestDetailBean.getCommit_code()); //COMMNT_CODE
			alDtlRecord.add(requestDetailBean.getDept_no()); //DEPT_NO
			alDtlRecord.add(requestDetailBean.getAcc_no()); //ACCOUNT_NO
			alDtlRecord.add(requestDetailBean.getAcc_desc()); //ACCOUNT_NAME
			alDtlRecord.add(requestDetailBean.getApp_ref()); //APPROVED_YN
			if(requestDetailBean.getApp_ref().equals("Y")){
				alDtlRecord.add(login_by_id); //APPROVED_BY
				alDtlRecord.add(getDoc_date_value()); //APPROVED_DATE
				alDtlRecord.add(requestDetailBean.getRef_value()); //APPROVAL_REMARKS
			}else {
				alDtlRecord.add(""); //APPROVED_BY
				alDtlRecord.add(""); //APPROVED_DATE
				alDtlRecord.add(""); //APPROVAL_REMARKS
			}
			alDtlRecord.add(requestDetailBean.getItem_remarks()); //PO_LINE_REMARKS
			if(getPo_mode().equals("D")){	
				alDtlRecord.add(""); //REQ_NO
				alDtlRecord.add(""); //REQ_SRL_NO
			} else if(getPo_mode().equals("R")){
				if(requestDetailBean.getReq_no() != null && requestDetailBean.getReq_no() != ""){
					alDtlRecord.add(requestDetailBean.getReq_no()); //REQ_NO
					alDtlRecord.add(requestDetailBean.getReq_srl_no()); //REQ_SRL_NO
				}else{
					alDtlRecord.add(""); //REQ_NO
					alDtlRecord.add(""); //REQ_SRL_NO
				}
			}	
			
			
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(checkForNull(requestDetailBean.getUnit_price()));//LIST_PRICE
			alDtlRecord.add("ND"); //PO_LINE_STATUS
			alDtlRecord.add(requestDetailBean.getEff_from_dt()); //COMMNT_EFF_DATE_FROM
			alDtlInsertRecord.add(alDtlRecord);		
	
			java.util.ArrayList alUpdRecord = new java.util.ArrayList();
			alUpdRecord.add(login_by_id);
			alUpdRecord.add(login_at_ws_no);
			alUpdRecord.add(login_facility_id);			  
			alUpdRecord.add(getRequest_by_pu());
			alUpdRecord.add(requestDetailBean.getItem_code());
			alUpdateItemData.add(alUpdRecord);
			
		}
		}catch(Exception e){
			e.printStackTrace();
			
		}

		return alDtlInsertRecord;
	}
		
// start for Bill to Deliver to

	public void updateBillToDeliveryRecords(Hashtable htBtDRecords){
	
	
		
		ArrayList alExpRecords = new ArrayList();
		int idx = 0;
		
		for (int i=1;i<=Integer.parseInt((String)htBtDRecords.get("total_Records")); i++) {

			HashMap hmExpRecord	=	new HashMap();
			
			hmExpRecord.put("FACILITY_CODE",	htBtDRecords.get("facility_code_"+i));
			hmExpRecord.put("BILL_TO",			htBtDRecords.get("bill_to_"+i));
			hmExpRecord.put("DELIVER_TO",		htBtDRecords.get("deliver_to_"+i));

			alExpRecords.add(hmExpRecord);

			
		}

			

			setBtDRecords(idx, alExpRecords);
	}


	public void setBtDRecords(int idx,ArrayList alExpRecord){
		hmBillRecords.put(idx,alExpRecord);
	}

	public ArrayList getBtDRecords(int idx){
		return (ArrayList)hmBillRecords.get(idx);
	}
	public HashMap getBtDRecords(){
		return hmBillRecords;
	}


//	end bill to deliver to	
		
	public void updateDeliveryRecords(String item_code, Hashtable htExpRecords){
	
	
		
		ArrayList alExpRecords = new ArrayList();

		for (int i=0;i<Integer.parseInt((String)htExpRecords.get("totalRecords")); i++) {

			if(((String)htExpRecords.get("order_qty_"+i) == null) || (htExpRecords.get("order_qty_"+i).equals(""))) 
			continue;

			HashMap hmExpRecord	=	new HashMap();
			
			hmExpRecord.put("ITEM_CODE",	htExpRecords.get("item_code"));
			hmExpRecord.put("DELV_QTY",	htExpRecords.get("order_qty_"+i));
			hmExpRecord.put("DELV_DATE",	htExpRecords.get("del_due_dt_"+i));

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
		System.out.println("addDetailRecord in 1946 bean = "+detailRecord);
			java.util.HashMap hashResult = new java.util.HashMap(2);
			hashResult.put("result",new Boolean(false));
	
		// Logic which adds the record 
		String itemcode_reqno = (String) detailRecord.get("ITEMCODE_REQNO");
		String editing = (String) detailRecord.get("editing");

		if (editing.equals("1") && reqKeys.contains(itemcode_reqno)) {
			hashResult.put("message","DUPLICATE_CODE_EXISTS");
			return hashResult;
		}
		else if (editing.equals("1")) {
			
			reqKeys.add(itemcode_reqno);
			
		}
		
		
		hmItemDetail.put(itemcode_reqno, new PurchaseOrderDetailBean(detailRecord));
		hashResult.put("result",new Boolean(true));
		hashResult.put("message","");
		return hashResult;
	}
	
	public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{
			
           
			String reportid = "POBORDER";
			PgetPu_codepo = getRequest_by_pu();

		/*	HashMap hmReportParameter	=	new HashMap();
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
		   
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   	
				onlineReports 	= new ecis.utils.OnlineReports() ;
			//	report2= new ecis.utils.OnlineReport( login_facility_id, "PO", "POBORDER") ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "PO", reportid, "S", PgetPu_codepo) ;
				report2.addParameter("p_facility_id", login_facility_id) ;
				report2.addParameter("p_module_id", "PO") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_doc_no", doc_no) ;
				report2.addParameter("p_user_name", login_by_id) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				onlineReports.add( report2) ;
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );

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

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Delete Mode") ;

		
		try {
			alDeleteData.add(getDoc_no());
						
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	
		
		hmTableData.put("properties",properties);
		hmTableData.put("DeleteHDRData",alDeleteData);
		hmTableData.put("DeleteDTLData",alDeleteData);
		hmTableData.put("DeleteDELVData",alDeleteData);
		hmTableData.put("DeleteBILLDELVData",alDeleteData);
	
		hmSQLMap.put("DeleteHDRSQL",ePO.Common.PoRepository.getPoKeyValue("SQL_ST_PO_ORDER_HDR_DELETE"));
		hmSQLMap.put("DeleteDTLSQL",ePO.Common.PoRepository.getPoKeyValue("SQL_ST_PO_ORDER_DTL_DELETE"));
		hmSQLMap.put("DeleteDELVSQL",ePO.Common.PoRepository.getPoKeyValue("SQL_ST_PO_ORDER_DELV_DELETE"));
		hmSQLMap.put("DeleteBILLDELVSQL",ePO.Common.PoRepository.getPoKeyValue("SQL_ST_PO_ORDER_BILLDELV_DELETE"));
		
		
		PurchaseOrderRemote requestRemote = null;
		try {
				
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PurchaseOrder",PurchaseOrderHome.class,getLocalEJB());
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
			return fetchRecord(getPoRepositoryValue("SQL_PO_USER_ACCESS_ALLOW_AUTHORIZE_SELECT"),sqlParameter);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	//Added by suresh.r on 12-11-2014 against ML-BRU-SCF-1457 beg
	public ArrayList getPur_uom_code_Lists(String parameters,String item_code) throws Exception{
		
		String chkParameters[] = {parameters,getLanguageId(),parameters,getLanguageId(),parameters,getLanguageId(),item_code};
		ArrayList result = new ArrayList();
		result = fetchRecords(getPoRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters);
			return result;
	}
	public String getPur_uom_code_List(String uom_code,String item_code){
		String gen_uom_code ="";
		try{
			gen_uom_code = checkForNull((String)fetchRecord("select gen_uom_code from mm_item where item_code= ?" ,checkForNull(item_code)).get("GEN_UOM_CODE"));
		}catch(Exception e){
			e.printStackTrace();
			
		}
		String chkParameters[] = {gen_uom_code,getLanguageId(),gen_uom_code,getLanguageId(),gen_uom_code,getLanguageId(),item_code};
			return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters,true),uom_code);

		}
	//Added by suresh.r on 12-11-2014 against ML-BRU-SCF-1457 end
}

