/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /**
* Java Bean for Generate Request
*/
/*
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
10/10/2019  IN:071343       B Haribabu                                          GHL-CRF-0608	
26/11/2020      TFS:6626         Haribabu                                  ML-MMOH-SCF-1642
-------------------------------------------------------------------------------------------------------------------------------
*/
package eST;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.CallableStatement;
//import java.sql.Types;
import java.util.Collections;
import java.util.ArrayList;
//import java.util.Properties;
import java.util.Hashtable;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.ServletException;

//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;

import java.util.HashMap;

import eST.Common.StRepository;
import eCommon.Common.CommonRepository;
//import eCommon.Common.CommonEJBSessionInterface;
//import eST.Common.StAdapter;
//import eST.GenerateRequestDetail;
import eST.GenerateRequest.*;
//import eST.GenerateRequest.GenerateRequestRemote;
import javax.servlet.* ;
import javax.servlet.http.*;
/**
* @Name - Mahesh
* @Date - 20/01/2010
* @Inc# - IN015496
* @Desc - All Interger.parseInt for quantity is changed to Double.parseDouble and variable names are made double
*/

public class GenerateRequestBean extends eST.Common.StTransaction implements java.io.Serializable {
	
	private String doc_ref;
	private String effective_date;
	private String requisition_on_store;
	private String requisition_by_store;
	private String item_from_code;
	private String item_to_code;
	private String doc_type_code;
	private String doc_date;
	private String doc_no;
	private String facility_id;
	private String finalized_yn;
	private boolean isAutoNo;
	private String acc_entity_id;
	private String trn_type;
	private String alpha_to_code;
	private String alpha_from_code;
	private String item_class_code;
	private String consignment;
	private String entity_param;
	//private String language;
	private GenerateRequestDetail generateRequestDetail;
	//private ArrayList allItemKeys;

	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
   // private String PgetTrnType = "";
	private ArrayList PDocNo ;
	public String reportserver = "";
	public String report_connect_string = "";


	java.util.ArrayList generateRequestKeys;
	java.util.ArrayList checkedItem;
	java.util.HashMap hmGenerateRequest;
	java.util.ArrayList checkedValues=new ArrayList();

	/* For default Values ! */
	private String defaultDocType = "";
	private String defaultStoreCode = "";

	public GenerateRequestBean() {
		generateRequestKeys = new java.util.ArrayList();
		checkedItem = new java.util.ArrayList();
		hmGenerateRequest = new java.util.HashMap();
	}

	public java.util.HashMap getHmGenerateRequest() {
		return this.hmGenerateRequest;
	}

	public java.util.ArrayList getGenerateRequestKeys() {
		return this.generateRequestKeys;
	}

	public void setDefaultDocType (String defaultDocType) {
		this.defaultDocType  = defaultDocType;
	}

	public String getDefaultDocType () {
		return this.defaultDocType;
	}

	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getPrintDocNo(){
		return PDocNo;
	}

	public void setDefaultStoreCode (String defaultStoreCode) {
		this.defaultStoreCode = defaultStoreCode;
	}

	public String getDefaultStoreCode() {
		return this.defaultStoreCode;
	}

	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}

	public boolean getIsAutoNo() {
		return this.isAutoNo;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = doc_ref;
	}

	public String getDoc_ref() {
		 return doc_ref;
	}

	public void setItem_from_code(String item_from_code) {
		 this.item_from_code = item_from_code;
	}

	public String getItem_from_code() {
		 return item_from_code;
	}

	public void setItem_to_code(String item_to_code) {
		 this.item_to_code = item_to_code;
	}

	public String getItem_to_code() {
		 return item_to_code;
	}
	
	public void setAlpha_to_code(String alpha_to_code) {
		 this.alpha_to_code = alpha_to_code;
	}

	public String getAlpha_to_code() {
		 return alpha_to_code;
	}

	public void setAlpha_from_code(String alpha_from_code) {
		 this.alpha_from_code = alpha_from_code;
	}

	public String getAlpha_from_code() {
		 return alpha_from_code;
	}

	public void setTrn_type(String trn_type) {
		 this.trn_type = trn_type;
	}

	public String getTrn_type() {
		 return trn_type;
	}

	public void setRequisition_by_store(String requisition_by_store) {
		 this.requisition_by_store = requisition_by_store;
	}

	public String getRequisition_by_store() {
		 return requisition_by_store;
	}

	public void setRequisition_on_store(String requisition_on_store) {
		 this.requisition_on_store = requisition_on_store;
	}

	public String getRequisition_on_store() {
		 return requisition_on_store;
	}
		
	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}

	public String getDoc_date_value() {
		 return doc_date;
	}

	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}
	public void setReport_Server(String reportserver) {
		 this.reportserver= reportserver;
 	}

	public String  getReport_Server( ) {
		 return reportserver;
	}
	
	public void setReport_Connect_String(String report_connect_string) {
		 this.report_connect_string= report_connect_string;

	}

	public String getReport_Connect_String( ) {
		 return report_connect_string;
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

	public void setEffective_date(String effective_date) {
		 this.effective_date = effective_date;
	}

	public String getEffective_date()
	{
		return effective_date;
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

	public void setFinalized_yn(String finalized_yn) {
		
		this.finalized_yn = finalized_yn;
	}

	public String getFinalized_yn() {
		return this.finalized_yn;
	}

	public String getItemAnalysis(){
	  return getListOptionTag(getListOptionArrayList(StRepository.getStKeyValue("SQL_ST_ITEM_ANALYSIS"),getLanguageId()));
	}
	public void setAcc_entity_id(String acc_entity_id) {
		this.acc_entity_id = acc_entity_id;	
	}
	
	public String getAcc_entity_id(){
		return this.acc_entity_id;
	}

	public void setEntity_param(String entity_param) {
		this.entity_param = entity_param;
	}

	public String getEntity_param() {
		return this.entity_param;
	}
	
	public void setItem_class_code(String item_class_code) {
		 this.item_class_code = item_class_code;
	}

	public String getItem_class_code() {
		 return this.item_class_code;
	}
	
	public String getConsignment() {
		 return consignment ;
	}

	public void setConsignment(String consignment) {
		 this.consignment = consignment;
	}
	public java.util.ArrayList getCheckedValues() {
		return this.checkedValues;
	}
	public void setCheckedValues(java.util.ArrayList checkedValues) {
		 this.checkedValues = checkedValues;
	}
	//Added for 6626 Start
	public void setcheckedItem(java.util.ArrayList checkedItem) {
		 this.checkedItem = checkedItem;
	}
	//Added for 6626 end
/*	public String getStock_Status(String store_code, String item_code){
		java.util.ArrayList sqlParameter = new java.util.ArrayList();
		sqlParameter.add(store_code);
		sqlParameter.add(item_code);
		String qty = "";
		try{
		qty =  (String)(fetchRecord(getStRepositoryValue("SQL_ST_REQ_ON_STORE_SELECT_FOR_QTY_CHECK"),sqlParameter)).get("QTY_ON_HAND");
		

		}catch(Exception e){
		}
		return qty;

	}*/

	public void initialize(){
		super.initialize();
		this.requisition_on_store="";
		this.requisition_by_store="";
		this.item_from_code="";
		this.item_to_code="";
		this.doc_type_code="";
		//doc_date;
		//effective_date
		this.doc_no="";
		this.facility_id="";
		this.finalized_yn="";
		this.acc_entity_id="";
		this.trn_type="";		
		this.item_class_code="";		

		if (checkedItem!= null) {
			checkedItem.clear();
		}
		if (generateRequestKeys!= null) {
			generateRequestKeys.clear();
		}
		if (hmGenerateRequest != null) {
			hmGenerateRequest.clear();
		}
		generateRequestDetail = null;
		if (checkedValues!= null) {
			checkedValues.clear();
		}
	}

	

	public void clear(){
		super.clear();
		this.requisition_on_store=null;
		this.requisition_by_store=null;
		this.item_from_code=null;
		this.item_to_code=null;
		this.doc_type_code=null;
		//doc_date;
		//effective_date
		this.doc_no=null;
		this.facility_id=null;
		this.finalized_yn=null;
		this.acc_entity_id=null;
		this.trn_type=null;		
		this.item_class_code="";		

		if (checkedItem!= null) {
			checkedItem.clear();
		}
		if (generateRequestKeys!= null) {
			generateRequestKeys.clear();
		}
		if (hmGenerateRequest != null) {
			hmGenerateRequest.clear();
		}
		generateRequestDetail = null;
		if (checkedValues!= null) {
			checkedValues.clear();
		}
	
	}
	public void setAll(Hashtable htRecordSet) {
		//checkedItem.clear(); //Commented for 6626
		
		setMode((String) htRecordSet.get("mode"));
		setDoc_ref((String) htRecordSet.get("doc_ref"));
		setTrn_type((String) htRecordSet.get("trn_type"));
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_date((String) htRecordSet.get("doc_date"));
		setDoc_no((String) htRecordSet.get("doc_no"));
		setFacility_id((String) htRecordSet.get("facility_id"));
		setFinalized_yn((String)htRecordSet.get("finalize_yn"));
		setIsAutoNo(htRecordSet.get("autono_yn").equals(eST.Common.StRepository.getStKeyValue("YES"))?true:false);
		setEffective_date((String) htRecordSet.get("effective_date"));
		setRequisition_on_store((String) htRecordSet.get("requisition_on_store"));
		setRequisition_by_store((String) htRecordSet.get("requisition_by_store"));
		setItem_to_code((String) htRecordSet.get("item_to_code"));
		setItem_from_code((String) htRecordSet.get("item_from_code"));
		//commented  for 6626 start
		/*		
		String keyCode,selectedKey;
		java.util.Enumeration hashKeys = htRecordSet.keys();
		while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("add_itm_")) {
				String stInd	=	keyCode.substring(8);
				selectedKey = (String) htRecordSet.get(keyCode);
				if (selectedKey != null && selectedKey.trim().length()>0) {
					checkedItem.add(selectedKey);
					GenerateRequestDetail generateRequestDetail = (GenerateRequestDetail) hmGenerateRequest.get(selectedKey);
					generateRequestDetail.setReq_qty((String)htRecordSet.get("req_qty_"+stInd)) ;
				}
			}
		}
	  */
	  	//commented  for 6626 start

	}
	
	public String getDocTypes() {
		String optionValues = null;
		//Get the default Document Type Code for the given Document Type
		//String defaultDocType = getDefaultDocType();
		java.util.ArrayList alGenerateRequestDoc = new java.util.ArrayList(5);
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		alGenerateRequestDoc.add(login_facility_id);
		alGenerateRequestDoc.add("ISS");
		alGenerateRequestDoc.add(getLanguageId());
		//Changed from SQL_ST_PREPARE_GROUP_DOC_TYPE - 1/16/2003
		//alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"), alGenerateRequestDoc);
		alOptionValues = getListOptionArrayList("SELECT	DISTINCT A.DOC_TYPE_CODE, B.SHORT_DESC FROM ST_TRN_DOC_TYPE A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE A.FACILITY_ID=? AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND A.TRN_TYPE =	? AND B.STATUS IS NULL  AND B.LANGUAGE_ID = ? ORDER BY	2,1", alGenerateRequestDoc);
		if ((doc_type_code != null)) {
			optionValues = getListOptionTag(alOptionValues,getDefaultDocType());
		}
		else {
			optionValues = getListOptionTag(alOptionValues);
		}
		alGenerateRequestDoc = null;
		alOptionValues = null;
		return optionValues;
	}

	public java.util.HashMap canAuthorize(String store_code) { 
		try {
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(login_by_id);
			sqlParameter.add(store_code);
			return fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_REQ_AUTHORIZE_SELECT"),sqlParameter);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
	
	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
			String chkParameters[] = {request_by_store,request_on_store,getLanguageId()};
			ArrayList result = new ArrayList();
			result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);
			 return result;
	}

	public String getStores() {
		String optionValues = null;
		java.util.ArrayList alOptionValues = new java.util.ArrayList();
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		alOptionValues = getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_REQ_BY_STORE_SELECT"), alParam);
		optionValues = getListOptionTag(alOptionValues,getDefaultStoreCode());
		alOptionValues = null;
		return optionValues;
	}


	public String getConsignmentList() {
		return getStaticListOptionTag("A,All;Y,Consignment ;N,Non Consignment");
	}

	public String getViewList() {
		return getStaticListOptionTag("R,Reorderable Items;A,All Items");
	}
	public HashMap validate() {

		

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");
		try {
			int docDateValidation = isValidDocDate(getDoc_date_value());
			if (docDateValidation == 1) {
				resultMap.put("result", new Boolean(false));
				resultMap.put("message", getMessage("ST_DOC_DT_NOT_LT_PROC_MTH"));
			}
			else if (docDateValidation == 2) {
				resultMap.put("result", new Boolean(false));
				resultMap.put("message", getMessage("ST_DOC_DT_NOT_GR_SYSDATE"));
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		

		return resultMap;
	}

	public HashMap insert() {

		

		HashMap hmResult = new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		//ArrayList alInsertData = new ArrayList();
		//GenerateRequestDetail generatereRequestDetail;

//		Properties properties = getProperties();
		//boolean canCommit = false;
		
		hmResult.put("result", new Boolean(false)) ;


		/*try {


			if (isAutoNo) {

				String next_doc_no = super.fetchNextDocNo(getDoc_type_code());
				setDoc_no(next_doc_no);

			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}*/

		ArrayList alHdrInsertRecord = new ArrayList();
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(getDoc_type_code());
		alHdrInsertRecord.add(getDoc_no());
		alHdrInsertRecord.add(getDoc_date_value());
		alHdrInsertRecord.add(getDoc_ref());
		alHdrInsertRecord.add(getRequisition_by_store());
		alHdrInsertRecord.add(getRequisition_on_store());
        alHdrInsertRecord.add(login_by_id);

		alHdrInsertRecord.add(getFinalized_yn().equals("Yes")?login_by_id:"");
		alHdrInsertRecord.add(getFinalized_yn().equals("Yes")?"W":"E");
		//alInsertData.add(getTrn_type());
		alHdrInsertRecord.add(checkForNull(getItem_class_code()));
		
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);

		
//getItem_desc( )
		int detailSize = checkedItem.size();
		String temp = "";
		for (int k=0;k<detailSize; k++ ) {
			for (int j=0;j<detailSize-1; j++ ) {
				generateRequestDetail = (GenerateRequestDetail) hmGenerateRequest.get(checkedItem.get(j));
				GenerateRequestDetail generateRequestDetail1 = (GenerateRequestDetail) hmGenerateRequest.get(checkedItem.get(j+1));
				if ( ((String)(generateRequestDetail.getItem_desc())).compareTo(((String)(generateRequestDetail1.getItem_desc())))>0 ) {
					temp	=	(String)checkedItem.get(j);
					checkedItem.set(j,(String)checkedItem.get(j+1));
					checkedItem.set(j+1,temp);
				}
			}
		}
		ArrayList alDtlInsertRecord = new ArrayList(detailSize);
		for (int index=0;index<detailSize;index++) {
			if((checkedItem.get(index) == null) || (checkedItem.get(index).equals(""))) 
					continue;
			generateRequestDetail = (GenerateRequestDetail) hmGenerateRequest.get(checkedItem.get(index));
			ArrayList alDtlRecord = new ArrayList(14);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(getDoc_type_code());
			alDtlRecord.add(getDoc_no());
//Commented by Mahesh on 3/13/2008 as the records are updating in Descending order....
			alDtlRecord.add(""+(index+1));
			//alDtlRecord.add(""+(detailSizeTemp--));
			alDtlRecord.add(generateRequestDetail.getItem_code());
			double req_qty = Double.parseDouble((String)generateRequestDetail.getReq_qty())*generateRequestDetail.getReqUOMConv();
            alDtlRecord.add(""+req_qty);
			alDtlRecord.add(generateRequestDetail.getStock_item_yn());
			alDtlRecord.add("0"); // commited_item_qty
			double pending_qty = (Double.parseDouble((String)generateRequestDetail.getReq_qty())*generateRequestDetail.getReqUOMConv())/generateRequestDetail.getByStockUOMConv();
			alDtlRecord.add(""+pending_qty);
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);

//added on 24/06/2004
            alDtlRecord.add(generateRequestDetail.getUom_code());
            //alDtlRecord.add("1"); // Conversion factor = 1 
            alDtlRecord.add(""+generateRequestDetail.getReqUOMConv()); 
//			int req_qty = Integer.parseInt((String)generateRequestDetail.getReq_qty())*getConvFactTemp(generateRequestDetail.getItem_code(),getRequisition_by_store());
 //           alDtlRecord.add(""+req_qty);
			alDtlRecord.add(generateRequestDetail.getReq_qty());
			alDtlRecord.add("");
			alDtlRecord.add(""); //Added by Rabbani #Inc no: 35333 on 24/09/12

			alDtlInsertRecord.add(alDtlRecord);
		}


		int updateSize = checkedItem.size();
		ArrayList alUpdateData = new ArrayList(updateSize);

		/*if(getFinalized_yn().equals("Yes")) { */

		for (int index=0;index<detailSize;index++) {
			if((checkedItem.get(index) == null) || (checkedItem.get(index).equals(""))) 
				continue;
			generateRequestDetail = (GenerateRequestDetail) hmGenerateRequest.get(checkedItem.get(index));
			ArrayList alUpdInsertRecord = new ArrayList(6);
			double pending_qty = (Double.parseDouble((String)generateRequestDetail.getReq_qty())*generateRequestDetail.getReqUOMConv())/generateRequestDetail.getByStockUOMConv();
			alUpdInsertRecord.add(""+pending_qty);
//			alUpdInsertRecord.add(generateRequestDetail.getReq_qty());
			alUpdInsertRecord.add(getEffective_date());
			alUpdInsertRecord.add(login_by_id);
			alUpdInsertRecord.add(login_at_ws_no);
			alUpdInsertRecord.add(login_facility_id);
			alUpdInsertRecord.add(generateRequestDetail.getItem_code());
			alUpdInsertRecord.add(getRequisition_by_store());
			alUpdateData.add(alUpdInsertRecord);
		}

		/*}*/

		java.util.ArrayList alUpdateDocNoData = new java.util.ArrayList (4);
		alUpdateDocNoData.add(login_by_id);
		alUpdateDocNoData.add(login_at_ws_no);
		alUpdateDocNoData.add(login_facility_id);
		alUpdateDocNoData.add(getDoc_type_code());

		hmSQLMap.put("InsertHDRSQL", StRepository.getStKeyValue("SQL_ST_GENERATE_REQUEST_HDR_INSERT")); 
		hmSQLMap.put("InsertDTLSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_INSERT")); 
		hmSQLMap.put("UpdateDocNoSQL", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")); 
		hmSQLMap.put("sql_st_records_per_trn_select", getStRepositoryValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_select", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_update", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_select_flag", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));

		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertHDRData",alHdrInsertRecord);
		
		hmTableData.put("InsertDTLData",alDtlInsertRecord);
		hmTableData.put("UpdateDocNoData",alUpdateDocNoData);
		hmTableData.put("isAutoNo",""+isAutoNo);

		hmSQLMap.put("UpdateSQL", StRepository.getStKeyValue("SQL_ST_GENERATE_ITEM_STORE_UPDATE")); 
		hmTableData.put("UpdateData",alUpdateData);

		if((getItemClassBased("ISS").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
			hmTableData = (HashMap)modifiedTableData(hmTableData,"ISS");
		}
		
		hmResult.put(RESULT, FALSE ) ;

	//	GenerateRequestHome generateRequestHome = null ;
		GenerateRequestRemote generateRequestRemote = null ;

		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(StRepository.getStKeyValue("JNDI_ST_GENERATE_REQUEST"),GenerateRequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no");	
				
				String s  = "";
				String s1 = "";
				if(doc_no.size()>1){
					java.util.Locale loc = new java.util.Locale(getLanguageId());
					java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
					s = getSTMessage(getLanguageId(), "DOC_NOS_GEN_FROM", "ST") ;
				
					s1=s+"  "+doc_no.get(0)+" "+common_labels.getString("Common.to.label")+" "+doc_no.get(doc_no.size()-1);
				}else{
					s = getSTMessage(getLanguageId(), "DOC_NO", "ST") ;
					s1=s+":  "+doc_no.get(0);
				}
			hmResult.put("message",getSTMessage(getLanguageId(),(String) hmResult.get( "message" ),"ST") ) ;
			
			hmResult.put("flag", s1) ;

			
			
			//String doc_no	= getDoc_no() ;	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetDoc_type_code = getDoc_type_code() ;
			
			PgetStore_codest  = getRequisition_by_store();
			
			ArrayList params  = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());

			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			
			
			if (getFinalized_yn().substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {

	
				
			if (isInternalRequest("ST","STBREQDC")&& isDocTypePrintAllowed(PgetDoc_type_code)) {
	//			
					if(alertRqdYN.equals("Y")){	
						hmResult.put("flag",hmResult.get("flag") + "~PY");
					}
					else{
						/*doOnlineReportPrinting(doc_no);				
						String pdocno = "";
						for(int i=0;i<doc_no.size();i++){
							pdocno=(String)doc_no.get(i);
							doOnlineReportPrinting(pdocno);
						}*/
					hmResult.put("flag",hmResult.get("flag") + "~PN");
					}

					
			}
		 }

		}
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(generateRequestRemote != null)
					generateRequestRemote.remove() ;
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString()) ;
			}
		}

		


		//Added by Martin on Thursday, April 17, 2003 11:58:46 AM to include online printing
		/*if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (getFinalized_yn().equals("Y") && isInternalRequest("ST","STBTRLBL")) {
				doOnlineReportPrinting();				
			}
		}*/
					
      return hmResult;
	}

	/*public void callOnlineReport(){
		if (getFinalized_yn().substring(0,1).equals("Y")) {
			if (isInternalRequest("ST","STBREQDC")) {
				String doc_no	=	getDoc_no();	
				doOnlineReportPrinting(doc_no);				
			}
		}
}*/
	/*public void doOnlineReportPrinting(String doc_no) {
		try{

			String reportid = "STBREQDC";
			
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code );
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_language_id",getLanguageId());
			
		
			if (!isDocTypePrintAllowed(PgetDoc_type_code )) return;

        //    javax.servlet.http.HttpSession session = request.getSession(false);
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			//hmParameters.put("jdbc",session.getAttribute("jdbc"));
			//hmParameters.put("report_server",session.getAttribute("report_server"));
			//hmParameters.put("report_connect_string",session.getAttribute("report_connect_string"));
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());

			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codest);
			hmParameters.put("location_code",PgetStore_codest);
//			hmParameters.put("p_language_id",getLanguageId());
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/

	public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{
	
			String reportid = "STBREQDC";
			//String copies = getNoOfCopies(reportid);

			if (!isInternalRequest("ST",reportid)) return;
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid) ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid, "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",PgetDoc_type_code);
				report2.addParameter("p_doc_no",doc_no);
				//report2.addParameter("copies",checkForNull(copies,"1"));
				onlineReports.add( report2) ;

				if (!isDocTypePrintAllowed(PgetDoc_type_code)){ return;}

				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}

/*
	public void doOnlineReportPrinting(String doc_no) {
		try{
			ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports() ;
			String reportid = "STBREQDC";
			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid,"S", getRequisition_by_store());
	//		((StDuoHeaderBean)getStHeaderBean()).getFrom_store_code();

			reportParam.addParameter("p_module_id","ST");
			reportParam.addParameter("p_report_id",reportid);
			reportParam.addParameter("p_user_name",getLoginById());
			reportParam.addParameter("p_facility_id",getLoginFacilityId());
			reportParam.addParameter("p_doc_type_code",getDoc_type_code());
//			reportParam.addParameter("p_fr_st_code",getStore_code());
			reportParam.addParameter("p_doc_no",doc_no);
			reportParam.addParameter("p_fr_date",getDoc_date());
			reportParam.addParameter("p_to_date",getDoc_date());


			onlineReports.add(reportParam) ;
			String ReportOutput = onlineReports.execute( request, response);
		
		}
		catch ( Exception exception) {
			exception.printStackTrace();
			return;
		}
	}
*/


    public HashMap apply() {
		HashMap test = null;
		try {
			test = super.apply();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return test;
	}
/*Commented By Mahesh to reduce the coding of setting the parameters for prepared statement*/	
/*public void addMultipleRecord(java.util.Hashtable dataTable) {

		java.sql.Connection connection = null;
		java.sql.PreparedStatement preparedStatement = null;
		java.sql.ResultSet resultSet = null;
		GenerateRequestDetail generateRequestDetail;
		generateRequestKeys.clear();
		String request_by_store = (String) dataTable.get("requisition_by_store");
		String request_on_store = (String) dataTable.get("requisition_on_store");


		String effective_date  = (String) dataTable.get("effective_date");
		String item_from_code  = (String) dataTable.get("item_from_code");
		String item_to_code	   = (String) dataTable.get("item_to_code");
		String alpha_from_code = (String) dataTable.get("alpha_from_code");
		String alpha_to_code   = (String) dataTable.get("alpha_to_code");
		String item_class_code = (String) dataTable.get("item_class_code");
		String item_analysis_1 = (String) ((dataTable.get("item_analysis_1"))==null?"":dataTable.get("item_analysis_1"));
		String item_analysis_2 = (String) ((dataTable.get("item_analysis_2"))==null?"":dataTable.get("item_analysis_2"));
		String item_analysis_3 = (String) ((dataTable.get("item_analysis_3"))==null?"":dataTable.get("item_analysis_3"));
			
		String item_code, item_desc,qty_on_hand;
		String max_stock_qty, reorder_level;
		String pending_req_qty,req_qty;
		String stock_item_yn;
        String uom_code				=		"";
        String reorder_qty			=		"";
        String viewitems			=		(String) dataTable.get("viewitems");
		String key					=		"";
		try {
			connection				=		getConnection();
			if (viewitems.equals ("R"))
			{
				//preparedStatement = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_GENERATE_REQUEST_ITEM_SELECT")); 
				preparedStatement = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_GENERATE_REQUEST_ITEM_SELECT_REORDERABLE")); 
			}else if(viewitems.equals ("N")){
				preparedStatement = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_GENERATE_REQUEST_ITEM_SELECT_NON_STOCK")); 
			}else{
				preparedStatement = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_GENERATE_REQUEST_ITEM_SELECT_ALL")); 
			}

			preparedStatement.setString(1, request_by_store.trim());
			preparedStatement.setString(2, request_on_store.trim());
			preparedStatement.setString(3, effective_date.trim());
			preparedStatement.setString(4, effective_date.trim());
			preparedStatement.setString(5, item_from_code.trim());
			preparedStatement.setString(6, item_to_code.trim());
			preparedStatement.setString(7, alpha_from_code.trim());
			preparedStatement.setString(8, alpha_to_code.trim());
			preparedStatement.setString(9, item_class_code.trim());
			preparedStatement.setString(10, item_analysis_1.trim());
			preparedStatement.setString(11, item_analysis_1.trim());
			preparedStatement.setString(12, item_analysis_2.trim());
			preparedStatement.setString(13, item_analysis_2.trim());
			preparedStatement.setString(14, item_analysis_3.trim());
			preparedStatement.setString(15, item_analysis_3.trim());
			preparedStatement.setString(16, getLanguageId());

			
			resultSet = preparedStatement.executeQuery();
			int i = 0;
			while (resultSet.next()) {
				i++;
				item_code = resultSet.getString("item_code");
				item_desc = resultSet.getString("item_desc");
				qty_on_hand = resultSet.getString("qty_on_hand");
				max_stock_qty = resultSet.getString("max_stk_qty");
				reorder_level = resultSet.getString("reorder_level");
				pending_req_qty = resultSet.getString("pending_req_qty");
				req_qty	      = resultSet.getString("req_qty");
				stock_item_yn = resultSet.getString("stock_item_yn");
				uom_code      =	resultSet.getString("uom_code");
				reorder_qty      =	resultSet.getString("reorder_qty");
				key = item_code;

				
				if (!generateRequestKeys.contains(key)) {
					generateRequestDetail = new GenerateRequestDetail(item_code, item_desc,qty_on_hand , max_stock_qty,reorder_level,pending_req_qty,req_qty,stock_item_yn,uom_code,reorder_qty);
					generateRequestKeys.add(key.toString());
					hmGenerateRequest.put(key.toString(), generateRequestDetail);
					
				}
				
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
		//itemStoreDetail.setAll(dataTable);
	}*/

	public void addMultipleRecord(java.util.Hashtable dataTable) {
		GenerateRequestDetail generateRequestDetail;
		generateRequestKeys.clear();
        String viewitems			=		(String) dataTable.get("viewitems");

		ArrayList	alParameters	=	new ArrayList();
		ArrayList	alRecords		=	new ArrayList();
		HashMap		hmResult		=	new HashMap();
		//Added by suresh.r on 23-09-2014 against Inc# 52042 query tuning beg
		StringBuffer sql=new StringBuffer();
		String itm_cd_frm,itm_cd_to,alp_cd_frm,alp_cd_to,itm_cl_cd,itm_ana_1,itm_ana_2,itm_ana_3,consignment,req_on_str,req_by_str;
		String conv_fac_fm_temp ,conv_fac_to_temp,conv_fac_issue_uom,frm_str_mul,to_str_mul,bat_qty_mul,iss_uom_mul;
		int fm_str_eqvl, fm_str_eqvl_qty ,to_str_eqvl ,to_str_eqvl_qty,issue_uom_eqvl,issue_uom_eqvl_qty;
		int fm_str_eqvl_temp,fm_str_eqvl_qty_temp ,to_str_eqvl_temp,to_str_eqvl_qty_temp ,issue_uom_eqvl_temp,issue_uom_eqvl_qty_temp;
		//Added by suresh.r on 23-09-2014 against Inc# 52042 query tuning end
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(((String)dataTable.get("requisition_on_store")).trim());
		alParameters.add(((String)dataTable.get("requisition_on_store")).trim());
		alParameters.add(((String)dataTable.get("requisition_by_store")).trim());
		alParameters.add(((String)dataTable.get("requisition_on_store")).trim());
		if(!(getLanguageId().equals("en"))){ //added for SRR20056-SCF-9522 by Badmavathi on 19/08/2015
			alParameters.add(com.ehis.util.DateUtils.convertDate(((String)dataTable.get("effective_date")).trim(),"DMY",getLanguageId(),"en"));
			alParameters.add(com.ehis.util.DateUtils.convertDate(((String)dataTable.get("effective_date")).trim(),"DMY",getLanguageId(),"en"));
			}else{
		alParameters.add(((String) dataTable.get("effective_date")).trim());
		alParameters.add(((String) dataTable.get("effective_date")).trim());}
		//Modified by suresh.r on 23-09-2014 against Inc# 52042 query tuning beg
		/*alParameters.add(((String)dataTable.get("item_from_code")).trim());
		alParameters.add(((String)dataTable.get("item_to_code")).trim());
		alParameters.add(((String)dataTable.get("alpha_from_code")).trim());
		alParameters.add(((String)dataTable.get("alpha_to_code")).trim());
		alParameters.add(((String)dataTable.get("item_class_code")).trim());
		alParameters.add(((String)dataTable.get("item_analysis_1")).trim());
		alParameters.add(((String)dataTable.get("item_analysis_1")).trim());
		alParameters.add(((String)dataTable.get("item_analysis_2")).trim());
		alParameters.add(((String)dataTable.get("item_analysis_2")).trim());
		alParameters.add(((String)dataTable.get("item_analysis_3")).trim());
		alParameters.add(((String)dataTable.get("item_analysis_3")).trim());*/
		req_on_str=((String)dataTable.get("requisition_on_store")).trim();
		req_by_str=((String)dataTable.get("requisition_by_store")).trim();
		itm_cd_frm=((String)dataTable.get("item_from_code")).trim();
		itm_cd_to=((String)dataTable.get("item_to_code")).trim();
		alp_cd_frm=((String)dataTable.get("alpha_from_code")).trim();
		alp_cd_to=((String)dataTable.get("alpha_to_code")).trim();
		itm_cl_cd=((String)dataTable.get("item_class_code")).trim();
		itm_ana_1=((String)dataTable.get("item_analysis_1")).trim();
		itm_ana_2=((String)dataTable.get("item_analysis_2")).trim();
		itm_ana_3=((String)dataTable.get("item_analysis_3")).trim();
		consignment=((String)dataTable.get("consignment")).trim();
		//Modified by suresh.r on 23-09-2014 against Inc# 52042 query tuning end
		alParameters.add(getLanguageId());
		/*alParameters.add(((String)dataTable.get("consignment")).trim());
		alParameters.add(((String)dataTable.get("consignment")).trim());*/
		try{
			if (viewitems.equals ("R")){
				//alRecords = (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_GENERATE_REQUEST_ITEM_SELECT_REORDERABLE"),alParameters);
				//alRecords = (ArrayList)fetchRecords("SELECT DISTINCT A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,A.QTY_ON_HAND,A.MAX_STK_QTY,A.REORDER_LEVEL,A.REORDER_FREQ_DAYS,A.PENDING_REQ_QTY,DECODE(A.STOCK_ITEM_YN,'Y', NVL(A.MAX_STK_QTY, 0) - NVL(A.QTY_ON_HAND, 0) - NVL(A.PENDING_REQ_QTY,0)	,NVL(A.MAX_STK_QTY,	0))	REQ_QTY,A.STOCK_ITEM_YN, NVL(A.DEF_REQUEST_UOM,A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY FROM ST_ITEM_STORE A, MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE=C.ITEM_CODE AND B.EFF_STATUS='E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE =? AND   A.ITEM_CODE IN (SELECT ITEM_CODE	FROM ST_ITEM_STORE WHERE STORE_CODE=? AND STOCK_ITEM_YN='Y' AND EFF_STATUS = 'E') AND   ((NVL(A.NEXT_REORDER_DATE,TO_DATE('01/01/1800','DD/MM/YYYY')) <=  	DECODE(TO_DATE(?,'DD/MM/YYYY'),'',TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY')) AND     A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S') OR ( NVL(A.QTY_ON_HAND, 0)+NVL(A.PENDING_REQ_QTY,0) <= NVL(A.REORDER_LEVEL,0) AND A.STOCK_ITEM_YN = 'Y' AND REQUEST_GEN_STAGE = 'S'))	/*AND	NVL(A.MAX_STK_QTY, 0) >	0*/ AND A.ITEM_CODE BETWEEN     NVL (	?,'!') AND NVL ( ?,'~')	AND	B.ALPHA_CODE BETWEEN NVL ( UPPER(?),'!') AND NVL (?,'~') AND NVL(B.ITEM_CLASS_CODE,'%') LIKE     NVL(?,'%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL(B.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?) AND	NVL(B.ITEM_ANAL2_CODE,'%')LIKE     DECODE(?,'','%',?)  AND NVL(B.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) =A.ITEM_CODE AND RE_ORDERABLE_YN = 'Y' AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) ORDER	BY UPPER(B.SHORT_DESC)",alParameters);
				//alRecords = (ArrayList)fetchRecords("SELECT NVL(NO_OF_DECIMALS,0) NO_OF_DECIMALS,DECODE(DISP_DECIMAL_DTLS_YN,'N','N',NVL(C.ALLOW_DECIMALS_YN,'N')) ALLOW_DECIMALS_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) REQUEST_UOM,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_ISSUE_UOM AND LANGUAGE_ID = ?) STOCK_UOM,ST_GET_UOM_CONV_REQ(A.ITEM_CODE,A.STORE_CODE) REQ_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,A.STORE_CODE) BY_STOCK_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,?) ON_STOCK_CONV_FACT, A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,A.QTY_ON_HAND,A.MAX_STK_QTY,A.REORDER_LEVEL,A.REORDER_FREQ_DAYS,A.PENDING_REQ_QTY,DECODE(A.STOCK_ITEM_YN,'Y', NVL(A.MAX_STK_QTY, 0) - NVL(A.QTY_ON_HAND, 0) - NVL(A.PENDING_REQ_QTY,0)	,NVL(A.MAX_STK_QTY,	0))	REQ_QTY,A.STOCK_ITEM_YN, NVL(A.DEF_REQUEST_UOM,A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY, (SELECT QTY_ON_HAND  FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND ITEM_CODE = A.ITEM_CODE) QOH_ON_STORE FROM ST_ITEM_STORE A, MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,ST_ACC_ENTITY_PARAM PM WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE=C.ITEM_CODE AND B.EFF_STATUS='E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE =? AND   A.ITEM_CODE IN (SELECT ITEM_CODE	FROM ST_ITEM_STORE WHERE STORE_CODE=? AND STOCK_ITEM_YN='Y' AND EFF_STATUS = 'E') AND   ((NVL(A.NEXT_REORDER_DATE,TO_DATE('01/01/1800','DD/MM/YYYY')) <=  	DECODE(TO_DATE(?,'DD/MM/YYYY'),'',TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY')) AND     A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S') OR ( NVL(A.QTY_ON_HAND, 0)+NVL(A.PENDING_REQ_QTY,0) <= NVL(A.REORDER_LEVEL,0) AND A.STOCK_ITEM_YN = 'Y' AND REQUEST_GEN_STAGE = 'S'))	/*AND	NVL(A.MAX_STK_QTY, 0) >	0*/ AND A.ITEM_CODE BETWEEN     NVL (	?,'!') AND NVL ( ?,'~')	AND	B.ALPHA_CODE BETWEEN NVL ( UPPER(?),'!') AND NVL (?,'~') AND NVL(B.ITEM_CLASS_CODE,'%') LIKE     NVL(?,'%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL(B.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?) AND	NVL(B.ITEM_ANAL2_CODE,'%')LIKE     DECODE(?,'','%',?)  AND NVL(B.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) =A.ITEM_CODE AND RE_ORDERABLE_YN = 'Y' AND MM.UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND MM.EQVL_UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) AND PM.ACC_ENTITY_ID = 'ZZ' ORDER	BY UPPER(B.SHORT_DESC)",alParameters);
				//Modified by suresh.r on 23-09-2014 against Inc# 52042 query tuning
				sql.append("SELECT NVL(NO_OF_DECIMALS,0) NO_OF_DECIMALS,DECODE(DISP_DECIMAL_DTLS_YN,'N','N',NVL(C.ALLOW_DECIMALS_YN,'N')) ALLOW_DECIMALS_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) REQUEST_UOM,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_ISSUE_UOM AND LANGUAGE_ID = ?) STOCK_UOM,ST_GET_UOM_CONV_REQ(A.ITEM_CODE,A.STORE_CODE) REQ_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,A.STORE_CODE) BY_STOCK_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,?) ON_STOCK_CONV_FACT, A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,A.QTY_ON_HAND,A.MAX_STK_QTY,A.REORDER_LEVEL,A.REORDER_FREQ_DAYS,A.PENDING_REQ_QTY,DECODE(A.STOCK_ITEM_YN,'Y', NVL(A.MAX_STK_QTY, 0) - NVL(A.QTY_ON_HAND, 0) - NVL(A.PENDING_REQ_QTY,0)	,NVL(A.MAX_STK_QTY,	0))	REQ_QTY,A.STOCK_ITEM_YN, NVL(A.DEF_REQUEST_UOM,A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY, (SELECT QTY_ON_HAND  FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND ITEM_CODE = A.ITEM_CODE) QOH_ON_STORE " +
						",ST_GET_UOM_CONV_FACTOR_DUO_STR(A.ITEM_CODE,'"+req_by_str+"') FRM_STR_CONV,ST_GET_UOM_CONV_FACTOR_DUO_STR(A.ITEM_CODE,'"+req_on_str+"') TO_STR_CONV,ST_GET_UOM_CONV_FACTOR_UOM(A.ITEM_CODE,NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM)) ISS_UOM_CONV FROM ST_ITEM_STORE A, MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,ST_ACC_ENTITY_PARAM PM WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE=C.ITEM_CODE AND B.EFF_STATUS='E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE =? AND   A.ITEM_CODE IN (SELECT ITEM_CODE	FROM ST_ITEM_STORE WHERE STORE_CODE=? AND STOCK_ITEM_YN='Y' AND EFF_STATUS = 'E') AND   ((NVL(A.NEXT_REORDER_DATE,TO_DATE('01/01/1800','DD/MM/YYYY')) <=  	DECODE(TO_DATE(?,'DD/MM/YYYY'),'',TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY')) AND     A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S') OR ( NVL(A.QTY_ON_HAND, 0)+NVL(A.PENDING_REQ_QTY,0) <= NVL(A.REORDER_LEVEL,0) AND A.STOCK_ITEM_YN = 'Y' AND REQUEST_GEN_STAGE = 'S'))	/*AND	NVL(A.MAX_STK_QTY, 0) >	0*/ AND SPECIAL_REQ_ITEM_YN = 'N' ");
					if(!itm_cd_frm.equals("") || !itm_cd_to.equals("")){
						sql.append(" AND A.ITEM_CODE BETWEEN     NVL (	'"+itm_cd_frm+"','!') AND NVL ( '"+itm_cd_to+"','~')	" );
					}
					if(!alp_cd_frm.equals("") || !alp_cd_to.equals("")){
						sql.append(" AND	B.ALPHA_CODE BETWEEN NVL ( UPPER('"+alp_cd_frm+"'),'!') AND NVL ('"+alp_cd_to+"','~')  " );
					}
					if(!itm_cl_cd.equals("")){	
						sql.append(" AND B.ITEM_CLASS_CODE = '"+itm_cl_cd+"'" );
					}
					if(!itm_ana_1.equals("")){	
						sql.append(" AND B.ITEM_ANAL1_CODE = '"+itm_ana_1+"'" );
					}
					if(!itm_ana_2.equals("")){	
						sql.append(" AND B.ITEM_ANAL2_CODE = '"+itm_ana_2+"'" );
					}
					if(!itm_ana_3.equals("")){	
						sql.append(" AND B.ITEM_ANAL3_CODE = '"+itm_ana_3+"'" );
					}
					if(!consignment.equals("") && !consignment.equals("A")){	
						sql.append(" AND CONSIGNMENT_ITEM_YN = '"+consignment+"'" );
					}
				sql.append(" AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) =A.ITEM_CODE AND RE_ORDERABLE_YN = 'Y' AND MM.UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND MM.EQVL_UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND A.PHY_INV_ID IS NULL AND PM.ACC_ENTITY_ID = 'ZZ' ORDER	BY UPPER(B.SHORT_DESC)");
				//Modified by suresh.r on 23-09-2014 against Inc# 52042 query tuning end
			}else if(viewitems.equals ("N")){
				//alRecords = (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_GENERATE_REQUEST_ITEM_SELECT_NON_STOCK"),alParameters);
				//alRecords = (ArrayList)fetchRecords("SELECT DISTINCT A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,A.QTY_ON_HAND,A.MAX_STK_QTY,A.REORDER_LEVEL,A.REORDER_FREQ_DAYS, A.PENDING_REQ_QTY,DECODE(A.STOCK_ITEM_YN,'Y', NVL(A.MAX_STK_QTY, 0) - NVL(A.QTY_ON_HAND, 0) - NVL(A.PENDING_REQ_QTY,0),NVL(A.MAX_STK_QTY,	0))	REQ_QTY,A.STOCK_ITEM_YN, NVL(A.DEF_REQUEST_UOM,A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY REORDER_QTY	FROM ST_ITEM_STORE A, MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE=C.ITEM_CODE AND B.EFF_STATUS='E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE =? AND A.ITEM_CODE IN (SELECT ITEM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=? AND EFF_STATUS = 'E' AND STOCK_ITEM_YN='Y') AND ((NVL(A.NEXT_REORDER_DATE,TO_DATE('01/01/1800','DD/MM/YYYY')) <=	DECODE(TO_DATE(?,'DD/MM/YYYY'),'',TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY')) AND A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S'))	/*AND	NVL(A.MAX_STK_QTY, 0) >	0*/ AND A.ITEM_CODE BETWEEN NVL (	?,'!') AND NVL ( ?,'~')	AND	B.ALPHA_CODE BETWEEN NVL ( UPPER(?),'!') AND NVL (	?,'~') AND NVL(B.ITEM_CLASS_CODE,'%') LIKE NVL(?,'%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL(B.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?)	AND	NVL(B.ITEM_ANAL2_CODE,'%') LIKE DECODE(?,'','%',?) AND  NVL(B.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) =A.ITEM_CODE AND A.STOCK_ITEM_YN = 'N' AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) ORDER	BY UPPER(B.SHORT_DESC)",alParameters);
				//alRecords = (ArrayList)fetchRecords("SELECT NVL(NO_OF_DECIMALS,0) NO_OF_DECIMALS,DECODE(DISP_DECIMAL_DTLS_YN,'N','N',NVL(C.ALLOW_DECIMALS_YN,'N')) ALLOW_DECIMALS_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) REQUEST_UOM,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_ISSUE_UOM AND LANGUAGE_ID = ?) STOCK_UOM,ST_GET_UOM_CONV_REQ(A.ITEM_CODE,A.STORE_CODE) REQ_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,A.STORE_CODE) BY_STOCK_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,?) ON_STOCK_CONV_FACT, A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,A.QTY_ON_HAND,A.MAX_STK_QTY,A.REORDER_LEVEL,A.REORDER_FREQ_DAYS, A.PENDING_REQ_QTY,DECODE(A.STOCK_ITEM_YN,'Y', NVL(A.MAX_STK_QTY, 0) - NVL(A.QTY_ON_HAND, 0) - NVL(A.PENDING_REQ_QTY,0),NVL(A.MAX_STK_QTY,	0))	REQ_QTY,A.STOCK_ITEM_YN, NVL(A.DEF_REQUEST_UOM,A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY REORDER_QTY, (SELECT QTY_ON_HAND  FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND ITEM_CODE = A.ITEM_CODE) QOH_ON_STORE	FROM ST_ITEM_STORE A, MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,ST_ACC_ENTITY_PARAM PM WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE=C.ITEM_CODE AND B.EFF_STATUS='E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE =? AND A.ITEM_CODE IN (SELECT ITEM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=? AND EFF_STATUS = 'E' AND STOCK_ITEM_YN='Y') AND ((NVL(A.NEXT_REORDER_DATE,TO_DATE('01/01/1800','DD/MM/YYYY')) <=	DECODE(TO_DATE(?,'DD/MM/YYYY'),'',TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY')) AND A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S'))	/*AND	NVL(A.MAX_STK_QTY, 0) >	0*/ AND A.ITEM_CODE BETWEEN NVL (	?,'!') AND NVL ( ?,'~')	AND	B.ALPHA_CODE BETWEEN NVL ( UPPER(?),'!') AND NVL (	?,'~') AND NVL(B.ITEM_CLASS_CODE,'%') LIKE NVL(?,'%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL(B.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?)	AND	NVL(B.ITEM_ANAL2_CODE,'%') LIKE DECODE(?,'','%',?) AND  NVL(B.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) =A.ITEM_CODE AND A.STOCK_ITEM_YN = 'N' AND MM.UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND MM.EQVL_UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) AND PM.ACC_ENTITY_ID = 'ZZ' ORDER	BY UPPER(B.SHORT_DESC)",alParameters);
				//Modified by suresh.r on 23-09-2014 against Inc# 52042 query tuning beg
				sql.append("SELECT NVL(NO_OF_DECIMALS,0) NO_OF_DECIMALS,DECODE(DISP_DECIMAL_DTLS_YN,'N','N',NVL(C.ALLOW_DECIMALS_YN,'N')) ALLOW_DECIMALS_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) REQUEST_UOM,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_ISSUE_UOM AND LANGUAGE_ID = ?) STOCK_UOM,ST_GET_UOM_CONV_REQ(A.ITEM_CODE,A.STORE_CODE) REQ_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,A.STORE_CODE) BY_STOCK_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,?) ON_STOCK_CONV_FACT, A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,A.QTY_ON_HAND,A.MAX_STK_QTY,A.REORDER_LEVEL,A.REORDER_FREQ_DAYS, A.PENDING_REQ_QTY,DECODE(A.STOCK_ITEM_YN,'Y', NVL(A.MAX_STK_QTY, 0) - NVL(A.QTY_ON_HAND, 0) - NVL(A.PENDING_REQ_QTY,0),NVL(A.MAX_STK_QTY,	0))	REQ_QTY,A.STOCK_ITEM_YN, NVL(A.DEF_REQUEST_UOM,A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY REORDER_QTY, (SELECT QTY_ON_HAND  FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND ITEM_CODE = A.ITEM_CODE) QOH_ON_STORE" +
						",ST_GET_UOM_CONV_FACTOR_DUO_STR(A.ITEM_CODE,'"+req_by_str+"') FRM_STR_CONV,ST_GET_UOM_CONV_FACTOR_DUO_STR(A.ITEM_CODE,'"+req_on_str+"') TO_STR_CONV,ST_GET_UOM_CONV_FACTOR_UOM(A.ITEM_CODE,NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM)) ISS_UOM_CONV	FROM ST_ITEM_STORE A, MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,ST_ACC_ENTITY_PARAM PM WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE=C.ITEM_CODE AND B.EFF_STATUS='E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE =? AND A.ITEM_CODE IN (SELECT ITEM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=? AND EFF_STATUS = 'E' AND STOCK_ITEM_YN='Y') AND ((NVL(A.NEXT_REORDER_DATE,TO_DATE('01/01/1800','DD/MM/YYYY')) <=	DECODE(TO_DATE(?,'DD/MM/YYYY'),'',TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY')) AND A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S'))	/*AND	NVL(A.MAX_STK_QTY, 0) >	0*/ AND SPECIAL_REQ_ITEM_YN = 'N' ");
					if(!itm_cd_frm.equals("") || !itm_cd_to.equals("")){
						sql.append(" AND A.ITEM_CODE BETWEEN     NVL (	'"+itm_cd_frm+"','!') AND NVL ( '"+itm_cd_to+"','~')	" );
					}
					if(!alp_cd_frm.equals("") || !alp_cd_to.equals("")){
						sql.append(" AND	B.ALPHA_CODE BETWEEN NVL ( UPPER('"+alp_cd_frm+"'),'!') AND NVL ('"+alp_cd_to+"','~')  " );
					}
					if(!itm_cl_cd.equals("")){	
						sql.append(" AND B.ITEM_CLASS_CODE = '"+itm_cl_cd+"'" );
					}
					if(!itm_ana_1.equals("")){	
						sql.append(" AND B.ITEM_ANAL1_CODE = '"+itm_ana_1+"'" );
					}
					if(!itm_ana_2.equals("")){	
						sql.append(" AND B.ITEM_ANAL2_CODE = '"+itm_ana_2+"'" );
					}
					if(!itm_ana_3.equals("")){	
						sql.append(" AND B.ITEM_ANAL3_CODE = '"+itm_ana_3+"'" );
					}
					if(!consignment.equals("") && !consignment.equals("A")){	
						sql.append(" AND CONSIGNMENT_ITEM_YN = '"+consignment+"'" );
					}
				sql.append(" AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) =A.ITEM_CODE AND A.STOCK_ITEM_YN = 'N' AND MM.UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND MM.EQVL_UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND A.PHY_INV_ID IS NULL AND PM.ACC_ENTITY_ID = 'ZZ' ORDER	BY UPPER(B.SHORT_DESC)");
				//Modified by suresh.r on 23-09-2014 against Inc# 52042 query tuning end
			}else if(viewitems.equals ("S")){
				alParameters.remove(6);
				alParameters.remove(6);
				//alRecords = (ArrayList)fetchRecords("SELECT ITEM_CODE,ITEM_DESC,DECODE(nvl(MAX_STK_QTY,0),0,REORDER_QTY,REQ_QTY) REQ_QTY,QTY_ON_HAND,MAX_STK_QTY,REORDER_LEVEL,REORDER_FREQ_DAYS,PENDING_REQ_QTY,STOCK_ITEM_YN,UOM_CODE,REORDER_QTY FROM (SELECT DISTINCT A.ITEM_CODE, B.SHORT_DESC ITEM_DESC, A.QTY_ON_HAND,A.MAX_STK_QTY, A.REORDER_LEVEL, A.REORDER_FREQ_DAYS,A.PENDING_REQ_QTY,DECODE (A.STOCK_ITEM_YN,'Y', NVL (A.MAX_STK_QTY, 0)- NVL (A.QTY_ON_HAND, 0)- NVL (A.PENDING_REQ_QTY, 0),NVL (A.MAX_STK_QTY, 0)) REQ_QTY,A.STOCK_ITEM_YN,NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY FROM ST_ITEM_STORE A,MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM WHERE A.ITEM_CODE = B.ITEM_CODE AND A.ITEM_CODE = C.ITEM_CODE AND B.EFF_STATUS = 'E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE = ? AND A.ITEM_CODE IN (SELECT ITEM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND STOCK_ITEM_YN = 'Y' AND EFF_STATUS = 'E') AND A.STOCK_ITEM_YN = 'Y' AND REQUEST_GEN_STAGE = 'S' AND NVL (A.QTY_ON_HAND, 0) + NVL (A.PENDING_REQ_QTY, 0) <= NVL (A.REORDER_LEVEL, 0) AND A.ITEM_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND B.ALPHA_CODE BETWEEN NVL (UPPER (?), '!') AND NVL (?, '~') AND NVL (B.ITEM_CLASS_CODE, '%') LIKE NVL (?, '%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL (B.ITEM_ANAL1_CODE, '%') LIKE DECODE (?, '', '%', ?) AND NVL (B.ITEM_ANAL2_CODE, '%') LIKE DECODE (?, '', '%', ?) AND NVL (B.ITEM_ANAL3_CODE, '%') LIKE DECODE (?, '', '%', ?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) = A.ITEM_CODE AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) ORDER BY UPPER(B.SHORT_DESC))",alParameters);
				//alRecords = (ArrayList)fetchRecords("SELECT NVL(NO_OF_DECIMALS,0) NO_OF_DECIMALS,ALLOW_DECIMALS_YN,REQ_CONV_FACT,BY_STOCK_CONV_FACT,ON_STOCK_CONV_FACT,ITEM_CODE,ITEM_DESC,DECODE(nvl(MAX_STK_QTY,0),0,REORDER_QTY,REQ_QTY) REQ_QTY,QTY_ON_HAND,MAX_STK_QTY,REORDER_LEVEL,REORDER_FREQ_DAYS,PENDING_REQ_QTY,STOCK_ITEM_YN,UOM_CODE,REORDER_QTY,REQUEST_UOM,STOCK_UOM FROM (SELECT NO_OF_DECIMALS,DECODE(DISP_DECIMAL_DTLS_YN,'N','N',NVL(C.ALLOW_DECIMALS_YN,'N')) ALLOW_DECIMALS_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) REQUEST_UOM,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_ISSUE_UOM AND LANGUAGE_ID = ?) STOCK_UOM,ST_GET_UOM_CONV_REQ(A.ITEM_CODE,A.STORE_CODE) REQ_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,A.STORE_CODE) BY_STOCK_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,?) ON_STOCK_CONV_FACT, A.ITEM_CODE, B.SHORT_DESC ITEM_DESC, A.QTY_ON_HAND,A.MAX_STK_QTY, A.REORDER_LEVEL, A.REORDER_FREQ_DAYS,A.PENDING_REQ_QTY,DECODE (A.STOCK_ITEM_YN,'Y', NVL (A.MAX_STK_QTY, 0)- NVL (A.QTY_ON_HAND, 0)- NVL (A.PENDING_REQ_QTY, 0),NVL (A.MAX_STK_QTY, 0)) REQ_QTY,A.STOCK_ITEM_YN,NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY, (SELECT QTY_ON_HAND  FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND ITEM_CODE = A.ITEM_CODE) QOH_ON_STORE FROM ST_ITEM_STORE A,MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,ST_ACC_ENTITY_PARAM PM WHERE A.ITEM_CODE = B.ITEM_CODE AND A.ITEM_CODE = C.ITEM_CODE AND B.EFF_STATUS = 'E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE = ? AND A.ITEM_CODE IN (SELECT ITEM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND STOCK_ITEM_YN = 'Y' AND EFF_STATUS = 'E') AND A.STOCK_ITEM_YN = 'Y' AND REQUEST_GEN_STAGE = 'S' AND NVL (A.QTY_ON_HAND, 0) + NVL (A.PENDING_REQ_QTY, 0) <= NVL (A.REORDER_LEVEL, 0) AND A.ITEM_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND B.ALPHA_CODE BETWEEN NVL (UPPER (?), '!') AND NVL (?, '~') AND NVL (B.ITEM_CLASS_CODE, '%') LIKE NVL (?, '%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL (B.ITEM_ANAL1_CODE, '%') LIKE DECODE (?, '', '%', ?) AND NVL (B.ITEM_ANAL2_CODE, '%') LIKE DECODE (?, '', '%', ?) AND NVL (B.ITEM_ANAL3_CODE, '%') LIKE DECODE (?, '', '%', ?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) = A.ITEM_CODE AND MM.UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND MM.EQVL_UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) AND PM.ACC_ENTITY_ID = 'ZZ' ORDER BY UPPER(B.SHORT_DESC))",alParameters);
				//Modified by suresh.r on 23-09-2014 against Inc# 52042 query tuning beg
				sql.append("SELECT NVL(NO_OF_DECIMALS,0) NO_OF_DECIMALS,ALLOW_DECIMALS_YN,REQ_CONV_FACT,BY_STOCK_CONV_FACT,ON_STOCK_CONV_FACT,ITEM_CODE,ITEM_DESC,DECODE(nvl(MAX_STK_QTY,0),0,REORDER_QTY,REQ_QTY) REQ_QTY,QTY_ON_HAND,MAX_STK_QTY,REORDER_LEVEL,REORDER_FREQ_DAYS,PENDING_REQ_QTY,STOCK_ITEM_YN,UOM_CODE,REORDER_QTY,REQUEST_UOM,STOCK_UOM,FRM_STR_CONV,TO_STR_CONV,ISS_UOM_CONV FROM (SELECT NO_OF_DECIMALS,DECODE(DISP_DECIMAL_DTLS_YN,'N','N',NVL(C.ALLOW_DECIMALS_YN,'N')) ALLOW_DECIMALS_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) REQUEST_UOM,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_ISSUE_UOM AND LANGUAGE_ID = ?) STOCK_UOM,ST_GET_UOM_CONV_REQ(A.ITEM_CODE,A.STORE_CODE) REQ_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,A.STORE_CODE) BY_STOCK_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,?) ON_STOCK_CONV_FACT, A.ITEM_CODE, B.SHORT_DESC ITEM_DESC, A.QTY_ON_HAND,A.MAX_STK_QTY, A.REORDER_LEVEL, A.REORDER_FREQ_DAYS,A.PENDING_REQ_QTY,DECODE (A.STOCK_ITEM_YN,'Y', NVL (A.MAX_STK_QTY, 0)- NVL (A.QTY_ON_HAND, 0)- NVL (A.PENDING_REQ_QTY, 0),NVL (A.MAX_STK_QTY, 0)) REQ_QTY,A.STOCK_ITEM_YN,NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY, (SELECT QTY_ON_HAND  FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND ITEM_CODE = A.ITEM_CODE) QOH_ON_STORE" +
						",ST_GET_UOM_CONV_FACTOR_DUO_STR(A.ITEM_CODE,'"+req_by_str+"') FRM_STR_CONV,ST_GET_UOM_CONV_FACTOR_DUO_STR(A.ITEM_CODE,'"+req_on_str+"') TO_STR_CONV,ST_GET_UOM_CONV_FACTOR_UOM(A.ITEM_CODE,NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM)) ISS_UOM_CONV FROM ST_ITEM_STORE A,MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,ST_ACC_ENTITY_PARAM PM WHERE A.ITEM_CODE = B.ITEM_CODE AND A.ITEM_CODE = C.ITEM_CODE AND B.EFF_STATUS = 'E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE = ? AND A.ITEM_CODE IN (SELECT ITEM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND STOCK_ITEM_YN = 'Y' AND EFF_STATUS = 'E') AND A.STOCK_ITEM_YN = 'Y' AND REQUEST_GEN_STAGE = 'S' AND NVL (A.QTY_ON_HAND, 0) + NVL (A.PENDING_REQ_QTY, 0) <= NVL (A.REORDER_LEVEL, 0) AND SPECIAL_REQ_ITEM_YN = 'N' ");
					if(!itm_cd_frm.equals("") || !itm_cd_to.equals("")){
						sql.append(" AND A.ITEM_CODE BETWEEN     NVL (	'"+itm_cd_frm+"','!') AND NVL ( '"+itm_cd_to+"','~')	" );
					}
					if(!alp_cd_frm.equals("") || !alp_cd_to.equals("")){
						sql.append(" AND	B.ALPHA_CODE BETWEEN NVL ( UPPER('"+alp_cd_frm+"'),'!') AND NVL ('"+alp_cd_to+"','~')  " );
					}
					if(!itm_cl_cd.equals("")){	
						sql.append(" AND B.ITEM_CLASS_CODE = '"+itm_cl_cd+"'" );
					}
					if(!itm_ana_1.equals("")){	
						sql.append(" AND B.ITEM_ANAL1_CODE = '"+itm_ana_1+"'" );
					}
					if(!itm_ana_2.equals("")){	
						sql.append(" AND B.ITEM_ANAL2_CODE = '"+itm_ana_2+"'" );
					}
					if(!itm_ana_3.equals("")){	
						sql.append(" AND B.ITEM_ANAL3_CODE = '"+itm_ana_3+"'" );
					}
					if(!consignment.equals("") && !consignment.equals("A")){	
						sql.append(" AND CONSIGNMENT_ITEM_YN = '"+consignment+"'" );
					}
				sql.append(" AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) = A.ITEM_CODE AND MM.UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND MM.EQVL_UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND A.PHY_INV_ID IS NULL AND PM.ACC_ENTITY_ID = 'ZZ' ORDER BY UPPER(B.SHORT_DESC))");
				//Modified by suresh.r on 23-09-2014 against Inc# 52042 query tuning end
			}else{
				//alRecords = (ArrayList)fetchRecords(getStRepositoryValue("SQL_ST_GENERATE_REQUEST_ITEM_SELECT_ALL"),alParameters);
				//alRecords = (ArrayList)fetchRecords("SELECT DISTINCT A.ITEM_CODE,B.SHORT_DESC ITEM_DESC,A.QTY_ON_HAND,A.MAX_STK_QTY,A.REORDER_LEVEL,A.REORDER_FREQ_DAYS,A.PENDING_REQ_QTY,DECODE(A.STOCK_ITEM_YN,'Y', NVL(A.MAX_STK_QTY, 0) - NVL(A.QTY_ON_HAND, 0) - NVL(A.PENDING_REQ_QTY,0)	,NVL(A.MAX_STK_QTY,	0))	REQ_QTY,A.STOCK_ITEM_YN,  NVL(A.DEF_REQUEST_UOM,A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY REORDER_QTY	FROM ST_ITEM_STORE A, MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM WHERE  A.ITEM_CODE=B.ITEM_CODE AND A.ITEM_CODE=C.ITEM_CODE AND B.EFF_STATUS='E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE =? AND A.ITEM_CODE IN (SELECT ITEM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=? AND EFF_STATUS = 'E' AND STOCK_ITEM_YN = 'Y') AND ((NVL(A.NEXT_REORDER_DATE,TO_DATE('01/01/1800','DD/MM/YYYY')) <=	DECODE(TO_DATE(?,'DD/MM/YYYY'),'',TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY')) AND A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S') OR (NVL (A.QTY_ON_HAND, 0) + NVL (A.PENDING_REQ_QTY, 0) <= NVL (A.REORDER_LEVEL, 0) AND A.STOCK_ITEM_YN	= 'Y' AND REQUEST_GEN_STAGE = 'S')) /*AND NVL(A.MAX_STK_QTY, 0) >	0 */ AND A.ITEM_CODE BETWEEN NVL (	?,'!') AND NVL ( ?,'~')	AND	B.ALPHA_CODE BETWEEN NVL ( UPPER(?),'!') AND NVL (	?,'~') AND NVL(B.ITEM_CLASS_CODE,'%') LIKE NVL(?,'%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL(B.ITEM_ANAL1_CODE,'%')LIKE DECODE(?,'','%',?)	AND	NVL(B.ITEM_ANAL2_CODE,'%')LIKE DECODE(?,'','%',?) AND  NVL(B.ITEM_ANAL3_CODE,'%')LIKE DECODE(?,'','%',?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) =A.ITEM_CODE AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE(?,'A','%',?) ORDER	BY UPPER(B.SHORT_DESC)",alParameters);
				//alRecords = (ArrayList)fetchRecords("SELECT NVL(NO_OF_DECIMALS,0) NO_OF_DECIMALS,DECODE(DISP_DECIMAL_DTLS_YN,'N','N',NVL(C.ALLOW_DECIMALS_YN,'N')) ALLOW_DECIMALS_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) REQUEST_UOM,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_ISSUE_UOM AND LANGUAGE_ID = ?) STOCK_UOM,ST_GET_UOM_CONV_REQ(A.ITEM_CODE,A.STORE_CODE) REQ_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,A.STORE_CODE) BY_STOCK_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,?) ON_STOCK_CONV_FACT,A.ITEM_CODE, B.SHORT_DESC ITEM_DESC, A.QTY_ON_HAND,A.MAX_STK_QTY, A.REORDER_LEVEL, A.REORDER_FREQ_DAYS,A.PENDING_REQ_QTY,DECODE (A.STOCK_ITEM_YN,'Y', NVL (A.MAX_STK_QTY, 0)- NVL (A.QTY_ON_HAND, 0)- NVL (A.PENDING_REQ_QTY, 0),NVL (A.MAX_STK_QTY, 0)) REQ_QTY,A.STOCK_ITEM_YN,NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY REORDER_QTY, (SELECT QTY_ON_HAND  FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND ITEM_CODE = A.ITEM_CODE) QOH_ON_STORE FROM ST_ITEM_STORE A,MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,ST_ACC_ENTITY_PARAM PM WHERE A.ITEM_CODE = B.ITEM_CODE AND A.ITEM_CODE = C.ITEM_CODE AND B.EFF_STATUS = 'E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE = ? AND A.ITEM_CODE IN (SELECT ITEM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND EFF_STATUS = 'E' AND STOCK_ITEM_YN = 'Y') AND (   (    NVL (A.NEXT_REORDER_DATE,TO_DATE ('01/01/1800', 'DD/MM/YYYY')) <= DECODE (TO_DATE (?, 'DD/MM/YYYY'),'', TO_DATE (TO_CHAR (SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE (?, 'DD/MM/YYYY')) AND A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S' ) OR (    NVL (A.QTY_ON_HAND, 0) + NVL (A.PENDING_REQ_QTY, 0) <= NVL (A.REORDER_LEVEL, 0) AND A.STOCK_ITEM_YN = 'Y' AND REQUEST_GEN_STAGE = 'S' )) /*AND NVL(A.MAX_STK_QTY, 0) > 0 */ AND A.ITEM_CODE BETWEEN NVL (?, '!') AND NVL (?, '~') AND B.ALPHA_CODE BETWEEN NVL (UPPER (?), '!') AND NVL (?, '~') AND NVL (B.ITEM_CLASS_CODE, '%') LIKE NVL (?, '%') AND SPECIAL_REQ_ITEM_YN = 'N' AND NVL (B.ITEM_ANAL1_CODE, '%') LIKE DECODE (?, '', '%', ?) AND NVL (B.ITEM_ANAL2_CODE, '%') LIKE DECODE (?, '', '%', ?) AND NVL (B.ITEM_ANAL3_CODE, '%') LIKE DECODE (?, '', '%', ?) AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) = A.ITEM_CODE AND MM.UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND MM.EQVL_UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND A.PHY_INV_ID IS NULL AND CONSIGNMENT_ITEM_YN LIKE DECODE (?, 'A', '%', ?) AND PM.ACC_ENTITY_ID = 'ZZ' ORDER BY UPPER (B.SHORT_DESC)",alParameters);
				//Modified by suresh.r on 23-09-2014 against Inc# 52042 query tuning beg
				sql.append(" SELECT NVL(NO_OF_DECIMALS,0) NO_OF_DECIMALS,DECODE(DISP_DECIMAL_DTLS_YN,'N','N',NVL(C.ALLOW_DECIMALS_YN,'N')) ALLOW_DECIMALS_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_REQUEST_UOM AND LANGUAGE_ID = ?) REQUEST_UOM,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE = A.DEF_ISSUE_UOM AND LANGUAGE_ID = ?) STOCK_UOM,ST_GET_UOM_CONV_REQ(A.ITEM_CODE,A.STORE_CODE) REQ_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,A.STORE_CODE) BY_STOCK_CONV_FACT, ST_GET_UOM_CONV_FAC_SING_STR(A.ITEM_CODE,?) ON_STOCK_CONV_FACT,A.ITEM_CODE, B.SHORT_DESC ITEM_DESC, A.QTY_ON_HAND,A.MAX_STK_QTY, A.REORDER_LEVEL, A.REORDER_FREQ_DAYS,A.PENDING_REQ_QTY,DECODE (A.STOCK_ITEM_YN,'Y', NVL (A.MAX_STK_QTY, 0)- NVL (A.QTY_ON_HAND, 0)- NVL (A.PENDING_REQ_QTY, 0),NVL (A.MAX_STK_QTY, 0)) REQ_QTY,A.STOCK_ITEM_YN,NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) UOM_CODE,A.REORDER_QTY REORDER_QTY, (SELECT QTY_ON_HAND  FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND ITEM_CODE = A.ITEM_CODE) QOH_ON_STORE " +
						",ST_GET_UOM_CONV_FACTOR_DUO_STR(A.ITEM_CODE,'"+req_by_str+"') FRM_STR_CONV,ST_GET_UOM_CONV_FACTOR_DUO_STR(A.ITEM_CODE,'"+req_on_str+"') TO_STR_CONV,ST_GET_UOM_CONV_FACTOR_UOM(A.ITEM_CODE,NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM)) ISS_UOM_CONV FROM ST_ITEM_STORE A,MM_ITEM_LANG_VW B,ST_ITEM C,MM_ITEM_UOM_DEFN MM,ST_ACC_ENTITY_PARAM PM WHERE A.ITEM_CODE = B.ITEM_CODE AND A.ITEM_CODE = C.ITEM_CODE AND B.EFF_STATUS = 'E' AND A.EFF_STATUS = 'E' AND A.STORE_CODE = ? AND A.ITEM_CODE IN (SELECT ITEM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE = ? AND EFF_STATUS = 'E' AND STOCK_ITEM_YN = 'Y') AND (   (    NVL (A.NEXT_REORDER_DATE,TO_DATE ('01/01/1800', 'DD/MM/YYYY')) <= DECODE (TO_DATE (?, 'DD/MM/YYYY'),'', TO_DATE (TO_CHAR (SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY'),TO_DATE (?, 'DD/MM/YYYY')) AND A.STOCK_ITEM_YN = 'N' AND REQUEST_GEN_STAGE = 'S' ) OR (    NVL (A.QTY_ON_HAND, 0) + NVL (A.PENDING_REQ_QTY, 0) <= NVL (A.REORDER_LEVEL, 0) AND A.STOCK_ITEM_YN = 'Y' AND REQUEST_GEN_STAGE = 'S' )) /*AND NVL(A.MAX_STK_QTY, 0) > 0 */ AND SPECIAL_REQ_ITEM_YN = 'N' ") ;
					if(!itm_cd_frm.equals("") || !itm_cd_to.equals("")){
						sql.append(" AND A.ITEM_CODE BETWEEN     NVL (	'"+itm_cd_frm+"','!') AND NVL ( '"+itm_cd_to+"','~')	" );
					}
					if(!alp_cd_frm.equals("") || !alp_cd_to.equals("")){
						sql.append(" AND	B.ALPHA_CODE BETWEEN NVL ( UPPER('"+alp_cd_frm+"'),'!') AND NVL ('"+alp_cd_to+"','~')  " );
					}
					if(!itm_cl_cd.equals("")){	
						sql.append(" AND B.ITEM_CLASS_CODE = '"+itm_cl_cd+"'" );
					}
					if(!itm_ana_1.equals("")){	
						sql.append(" AND B.ITEM_ANAL1_CODE = '"+itm_ana_1+"'" );
					}
					if(!itm_ana_2.equals("")){	
						sql.append(" AND B.ITEM_ANAL2_CODE = '"+itm_ana_2+"'" );
					}
					if(!itm_ana_3.equals("")){	
						sql.append(" AND B.ITEM_ANAL3_CODE = '"+itm_ana_3+"'" );
					}
					if(!consignment.equals("") && !consignment.equals("A")){	
						sql.append(" AND CONSIGNMENT_ITEM_YN = '"+consignment+"'" );
					}
				sql.append(" AND B.LANGUAGE_ID = ? AND MM.ITEM_CODE(+) = A.ITEM_CODE AND MM.UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND MM.EQVL_UOM_CODE(+) = NVL (A.DEF_REQUEST_UOM, A.DEF_ISSUE_UOM) AND A.PHY_INV_ID IS NULL AND PM.ACC_ENTITY_ID = 'ZZ' ORDER BY UPPER (B.SHORT_DESC)");
				//Modified by suresh.r on 23-09-2014 against Inc# 52042 query tuning end
			}
			alRecords = (ArrayList)fetchRecords(sql.toString(),alParameters);//Added by suresh.r on 23-09-2014 against Inc# 52042 query tuning
			String req_qty = "";
			for(int i=0;i<alRecords.size();i++){
				hmResult	=	(HashMap)alRecords.get(i);
				req_qty = (String)hmResult.get("REQ_QTY");
				if(((String)hmResult.get("STOCK_ITEM_YN")).equals("N")){
					if((checkForNull((String)hmResult.get("MAX_STK_QTY"),"0")).equals("0")&& !(checkForNull((String)hmResult.get("REORDER_QTY"),"0")).equals("0")) {
						req_qty = (String)hmResult.get("REORDER_QTY");
					}else if(!(checkForNull((String)hmResult.get("MAX_STK_QTY"),"0")).equals("0")&& (checkForNull((String)hmResult.get("REORDER_QTY"),"0")).equals("0")){
						req_qty = (String)hmResult.get("MAX_STK_QTY");
					}else if(!(checkForNull((String)hmResult.get("MAX_STK_QTY"),"0")).equals("0")&& !(checkForNull((String)hmResult.get("REORDER_QTY"),"0")).equals("0")) {
						req_qty = (String)hmResult.get("REORDER_QTY");
					}else{
						req_qty = "0";
					}
				}else{
					if((checkForNull((String)hmResult.get("MAX_STK_QTY"),"0")).equals("0")){
						req_qty = checkForNull((String)hmResult.get("REORDER_QTY"),"0");
					}
				}
				if (!generateRequestKeys.contains((String)hmResult.get("ITEM_CODE"))) {
					generateRequestDetail = new GenerateRequestDetail((String)hmResult.get("ITEM_CODE"), (String)hmResult.get("ITEM_DESC"),(String)hmResult.get("QTY_ON_HAND") , (String)hmResult.get("MAX_STK_QTY"),(String)hmResult.get("REORDER_LEVEL"),(String)hmResult.get("PENDING_REQ_QTY"),req_qty,(String)hmResult.get("STOCK_ITEM_YN"),(String)hmResult.get("UOM_CODE"),(String)hmResult.get("REORDER_QTY"),(String)hmResult.get("REQ_CONV_FACT"),(String)hmResult.get("BY_STOCK_CONV_FACT"),(String)hmResult.get("ON_STOCK_CONV_FACT"),(String)hmResult.get("REQUEST_UOM"),(String)hmResult.get("STOCK_UOM"),(String)hmResult.get("ALLOW_DECIMALS_YN"),(String)hmResult.get("NO_OF_DECIMALS"),(String)dataTable.get("requisition_by_store"),(String)dataTable.get("requisition_on_store"),(String)hmResult.get("QOH_ON_STORE"));
					//Added by suresh.r on 23-09-2014 against Inc# 52042 query tuning beg
					if(((String)hmResult.get("ALLOW_DECIMALS_YN")).equals("N")){
						conv_fac_fm_temp = ""; conv_fac_to_temp = ""; conv_fac_issue_uom = "";
						frm_str_mul="";to_str_mul="";bat_qty_mul="";iss_uom_mul="";
						fm_str_eqvl = 1;
						fm_str_eqvl_qty = 1;
						to_str_eqvl = 1;
						to_str_eqvl_qty = 1;
						issue_uom_eqvl = 1;
						issue_uom_eqvl_qty = 1;
						
						fm_str_eqvl_temp = 1;
						fm_str_eqvl_qty_temp = 1;
						to_str_eqvl_temp = 1;
						to_str_eqvl_qty_temp = 1;
						issue_uom_eqvl_temp = 1;
						issue_uom_eqvl_qty_temp = 1;
						
						conv_fac_fm_temp	=(String)hmResult.get("FRM_STR_CONV");
						conv_fac_to_temp	=(String)hmResult.get("TO_STR_CONV");
						conv_fac_issue_uom	=(String)hmResult.get("ISS_UOM_CONV");
								
						if(conv_fac_fm_temp.indexOf("~")!=-1){
							fm_str_eqvl_temp = Integer.parseInt(conv_fac_fm_temp.substring(0,conv_fac_fm_temp.indexOf("~")));
							fm_str_eqvl_qty_temp = Integer.parseInt(conv_fac_fm_temp.substring(conv_fac_fm_temp.indexOf("~")+1,conv_fac_fm_temp.length()));
						}
						if(conv_fac_to_temp.indexOf("~")!=-1){
							to_str_eqvl_temp = Integer.parseInt(conv_fac_to_temp.substring(0,conv_fac_to_temp.indexOf("~")));
							to_str_eqvl_qty_temp = Integer.parseInt(conv_fac_to_temp.substring(conv_fac_to_temp.indexOf("~")+1,conv_fac_to_temp.length()));
						}
						if(conv_fac_issue_uom.indexOf("~")!=-1){
							issue_uom_eqvl_temp = Integer.parseInt(conv_fac_issue_uom.substring(0,conv_fac_issue_uom.indexOf("~")));
							issue_uom_eqvl_qty_temp = Integer.parseInt(conv_fac_issue_uom.substring(conv_fac_issue_uom.indexOf("~")+1,conv_fac_issue_uom.length()));
						}
						
						fm_str_eqvl_qty = fm_str_eqvl_qty_temp / gcd(fm_str_eqvl_temp,fm_str_eqvl_qty_temp);
						fm_str_eqvl = fm_str_eqvl_temp / gcd(fm_str_eqvl_temp,fm_str_eqvl_qty_temp);
						to_str_eqvl_qty = to_str_eqvl_qty_temp / gcd(to_str_eqvl_temp,to_str_eqvl_qty_temp);
						to_str_eqvl = to_str_eqvl_temp / gcd(to_str_eqvl_temp,to_str_eqvl_qty_temp);
						issue_uom_eqvl_qty = issue_uom_eqvl_qty_temp / gcd(issue_uom_eqvl_temp,issue_uom_eqvl_qty_temp);
						issue_uom_eqvl = issue_uom_eqvl_temp / gcd(issue_uom_eqvl_temp,issue_uom_eqvl_qty_temp);
						int common_lcm = (getLcm(getLcm(fm_str_eqvl,to_str_eqvl),issue_uom_eqvl));
						int issue_uom_multiple = (getLcm(getLcm(fm_str_eqvl,to_str_eqvl),issue_uom_eqvl)*issue_uom_eqvl_qty)/issue_uom_eqvl;
						frm_str_mul=""+((common_lcm*fm_str_eqvl_qty)/fm_str_eqvl);
						to_str_mul=""+((common_lcm*to_str_eqvl_qty)/to_str_eqvl);
						bat_qty_mul=""+common_lcm;
						iss_uom_mul=""+issue_uom_multiple;
						generateRequestDetail.setFromMultiples(frm_str_mul);
						generateRequestDetail.setToMultiples(to_str_mul);
						generateRequestDetail.setBatchMultiples(bat_qty_mul);
						generateRequestDetail.setIssueUOMMultiples(iss_uom_mul);
					}
					//Added by suresh.r on 23-09-2014 against Inc# 52042 query tuning end
					generateRequestKeys.add((String)hmResult.get("ITEM_CODE"));
					hmGenerateRequest.put((String)hmResult.get("ITEM_CODE"), generateRequestDetail);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public java.util.ArrayList getOnStores(String req_by_store) throws Exception {
			String chkParameters[] = {login_facility_id,getLanguageId(),getRequisition_by_store()};
			ArrayList result = new ArrayList();
			//result = fetchRecords(StRepository.getStKeyValue("SQL_ST_REQUEST_FROM_STORE_SELECT_FROMST_STORE"),chkParameters);
			//SQL_ST_REQUEST_FROM_STORE_SELECT_FROMST_STORE rep is changed to SQL_ST_REQUEST_FROM_STORE_SELECT_FROMST_STORE1 SPR NO 2561 
		result = fetchRecords(StRepository.getStKeyValue("SQL_ST_REQUEST_FROM_STORE_SELECT_FROMST_STORE1"),chkParameters);
		return result;
	
	}
	//only modify the method name getConvFactTemp to getConvFactTemp_req  for to get the req_uom_qty
	public double getConvFactTemp_req(String item_code,String store_code){
		double conv_fac_temp=1;
		ArrayList alParameters = new ArrayList();

		try {
			alParameters.add(item_code);
			alParameters.add(store_code);
			conv_fac_temp=Double.parseDouble((String)fetchRecord("SELECT ST_GET_UOM_CONV_REQ(?,?) CONV_FACTOR FROM DUAL",	alParameters).get("CONV_FACTOR"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conv_fac_temp;
	}
	/*public int getConvFactTemp1(String item_code,String store_code){
		int conv_fac_temp=1;
		ArrayList alParameters = new ArrayList();

		try {
			alParameters.add(getGenItemUOM(item_code));
			alParameters.add(store_code);
			alParameters.add(item_code);
			alParameters.add(item_code);
			alParameters.add(getGenItemUOM(item_code));
			alParameters.add(store_code);
			alParameters.add(item_code);
			alParameters.add(getGenItemUOM(item_code));
			alParameters.add(store_code);
			alParameters.add(item_code);
			conv_fac_temp =Integer.parseInt((String)((HashMap)fetchRecord(getStRepositoryValue("SQL_ST_CONV_FACTOR_SELECT1"),alParameters)).get("CONV_FACTOR"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conv_fac_temp;
	}
	public String getGenItemUOM(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};
		String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			//base_uom = fetchRecord("SELECT GEN_UOM_CODE FROM MM_ITEM WHERE ITEM_CODE=?",chkdefaultParameters);
				base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			gen_uom_code = "";
		}
		
		if(base_uom.size() > 0)
			gen_uom_code = (String)base_uom.get("GEN_UOM_CODE");
		return gen_uom_code;
	}*/
	/*public double getLcm(double req_by_req_conv_factor,double req_by_stk_conv_factor,double req_on_stk_conv_factor){
	double lowest = req_by_req_conv_factor<req_by_stk_conv_factor?req_by_req_conv_factor:req_by_stk_conv_factor;
		double hcd=1;
		for (double i=lowest; i>1;i-- ){
			if(req_by_req_conv_factor%i == 0 && req_by_stk_conv_factor%i==0){
				hcd = i;
				break;
			}
		}
		double lcm = (req_by_req_conv_factor*req_by_stk_conv_factor)/hcd;
		lowest = req_on_stk_conv_factor<lcm?req_on_stk_conv_factor:lcm;
		hcd=1;
		for (double i=lowest; i>1;i-- ){
			if(req_on_stk_conv_factor%i == 0 && lcm%i==0){
				hcd = i;
				break;
			}
		}
		lcm = (req_on_stk_conv_factor*lcm)/hcd;
		return lcm;
	}		
	public double getLcm(String req_by_store,String req_on_store,String item_code){
		double req_by_req_conv_factor = getConvFactTemp_req(item_code,req_by_store);
		double req_by_stk_conv_factor = getConvFactTemp(item_code,req_by_store);
		//To get the to store convertion factor to use getConvFactTemp_To any problem releated  to qty call  getConvFactTemp
		double req_on_stk_conv_factor = getConvFactTemp(item_code,req_on_store);
		double lowest = req_by_req_conv_factor<req_by_stk_conv_factor?req_by_req_conv_factor:req_by_stk_conv_factor;
		double hcd=1;
		for (double i=lowest; i>1;i-- ){
			if(req_by_req_conv_factor%i == 0 && req_by_stk_conv_factor%i==0){
				hcd = i;
				break;
			}
		}
		double lcm = (req_by_req_conv_factor*req_by_stk_conv_factor)/hcd;
		lowest = req_on_stk_conv_factor<lcm?req_on_stk_conv_factor:lcm;
		hcd=1;
		for (double i=lowest; i>1;i-- ){
			if(req_on_stk_conv_factor%i == 0 && lcm%i==0){
				hcd = i;
				break;
			}
		}
		lcm = (req_on_stk_conv_factor*lcm)/hcd;
		return lcm;
	}	*/	

	public ArrayList curerentPendingRequestDetalis(String request_by_store,ArrayList arr)throws Exception{
		ArrayList Doc_details = new ArrayList();
	/*	java.util.StringTokenizer st	=		new java.util.StringTokenizer(checkedValues,"~");
		ArrayList arr					=		new ArrayList();
		while( st.hasMoreElements())
		{
		 arr.add(st.nextElement() );
		}*/

		for(int i=0;i<arr.size();i++){
			ArrayList hh=new ArrayList();
			hh=fetchRecords("SELECT DTL.ITEM_CODE ITEM_CODE,MT.SHORT_DESC ITEM_DESC,HDR.REQ_ON_STORE_CODE REQ_ON_STORE_CODE , MS.SHORT_DESC REQ_ON_STORE_DESC,HDR.DOC_NO DOC_NO FROM ST_REQUEST_HDR HDR, ST_REQUEST_DTL DTL,MM_ITEM_LANG_VW MT,MM_STORE_LANG_VW MS WHERE HDR.REQ_BY_STORE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = ? AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.REQUEST_STATUS = 'W' AND HDR.FACILITY_ID = DTL.FACILITY_ID AND MT.ITEM_CODE=DTL.ITEM_CODE AND MS.STORE_CODE=HDR.REQ_ON_STORE_CODE AND MT.LANGUAGE_ID=MS.LANGUAGE_ID AND MT.LANGUAGE_ID=? ORDER BY DOC_NO",new String[]{request_by_store,(String)arr.get(i),getLanguageId()});
			if(hh.size()>0){
				Doc_details.add(hh);
			}
		}
		return Doc_details;
	}

	public void clearCheckedValues(){
		if (checkedValues!= null) {
			checkedValues.clear();
		}
	}
	//Added for 6626 start
	public void clearcheckedItem(){
		if (checkedItem!= null) {
			checkedItem.clear();
		}
	}
	//Added for 6626 end
	public HashMap modifiedTableData(HashMap hmTableData,String trn_type){
		String item_class_code = "";
		int records_per_trn = getRecordsPerTrn(trn_type);
		ArrayList<Integer> alCount =  new ArrayList<Integer>();
		ArrayList<String> alTempData = new ArrayList<String>();
		ArrayList<ArrayList> alNewTempData = new ArrayList<ArrayList>();
		ArrayList<String> alItemClassData = new ArrayList<String>();
		ArrayList<String> alNewItemClassData = new ArrayList<String>();
		ArrayList<ArrayList> alItemDtlData = (ArrayList<ArrayList>)hmTableData.get("InsertDTLData");
		ArrayList<ArrayList> alNewItemHdrData = new ArrayList<ArrayList>();//hmTableData.get("InsertHDRData");
		ArrayList<String> alItemHdrData = (ArrayList<String>)hmTableData.get("InsertHDRData");
		for(int i=0;i<alItemDtlData.size();i++){
			alTempData = (ArrayList<String>)alItemDtlData.get(i);
			try{
				item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",alTempData.get(4)).get("ITEM_CLASS_CODE");
				if(!alItemClassData.contains(item_class_code)){
					alItemClassData.add(item_class_code);
				}
				//alItemClassData.add((String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",alTempData.get(4)).get("ITEM_CLASS_CODE"));
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		Collections.sort(alItemClassData);
		for(int i=0;i<alItemClassData.size();i++){
			alNewItemClassData.add(alItemClassData.get(i));
		}
		item_class_code = "";
		for(int i=0;i<alItemClassData.size();i++){
			int k = 0;
			//int count = 0;
			for(int j=0;j<alItemDtlData.size();j++){
				alTempData = (ArrayList<String>)alItemDtlData.get(j);
				try{
					item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",alTempData.get(4)).get("ITEM_CLASS_CODE");
					if(item_class_code.equals(alItemClassData.get(i))){
						//++count;
						if(k>=records_per_trn){
							alCount.add(k);
							k = 0;
							alNewItemClassData.add(item_class_code);
							//continue;
						}
						(alItemDtlData.get(j)).set(3,++k);
						alNewTempData.add(alItemDtlData.get(j));
					}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
			alCount.add(k);
		}
		Collections.sort(alNewItemClassData);
		for(int i=0;i<alNewItemClassData.size();i++){
			ArrayList<String> alTemp = new ArrayList<String>();
			for(int j=0;j<alItemHdrData.size();j++){
				alTemp.add(alItemHdrData.get(j));
			}
			alTemp.set(10,alNewItemClassData.get(i));
			alNewItemHdrData.add(alTemp);
		}
		hmTableData.put("InsertDTLData",alNewTempData);
		hmTableData.put("InsertHDRData",alNewItemHdrData);
		hmTableData.put("ItemClassCount",alCount);
		hmTableData.put("ItemClass",alNewItemClassData);
		hmTableData.put("ITEM_CLASS_BASED","Y");
		return hmTableData;
	}
	/*public double getConvFactTemp(String item_code,String store_code){
		double conv_fac_temp=1;
		ArrayList alParameters = new ArrayList();

		try {
		
		    alParameters.add(item_code);
			alParameters.add(store_code);

		   conv_fac_temp=Double.parseDouble((String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"));
		}	catch(Exception e){
			//e.printStackTrace();
		}
		return conv_fac_temp;
	}*/
	//Added for IN:071343 start
			public Boolean getRestrictReqExdMaxStock(){
				String restrict_request_exd_max_stock = "N";
				try{
					restrict_request_exd_max_stock = (String)fetchRecord("SELECT RESTRICT_REQ_EXD_MAX_STOCK FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("RESTRICT_REQ_EXD_MAX_STOCK");
				}catch(Exception e){
					e.printStackTrace();
				}
				return checkForNull(restrict_request_exd_max_stock,"N").equals("Y");
			}
			//Added for IN:071343 end
//Added for 6626 start
	public void setAllNew(Hashtable htRecordSet) {
		//checkedItem.clear();
		String keyCode,selectedKey;
		java.util.Enumeration hashKeys = htRecordSet.keys();
		while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("add_itm_")) {
				String stInd	=	keyCode.substring(8);
				selectedKey = (String) htRecordSet.get(keyCode);
				if (selectedKey != null && selectedKey.trim().length()>0) {
					if(checkedItem.indexOf(selectedKey)==-1){
						checkedItem.add(selectedKey);
					}
					GenerateRequestDetail generateRequestDetail = (GenerateRequestDetail) hmGenerateRequest.get(selectedKey);
					generateRequestDetail.setReq_qty((String)htRecordSet.get("req_qty_"+stInd)) ;
				}
			}
		}
	  

	}
	public void removeUnSelectedItems(String item_code) {
		checkedItem.remove(item_code);
		System.out.println("checkedItem after remove>>="+checkedItem);
	}
//Added for 6626 end
}


