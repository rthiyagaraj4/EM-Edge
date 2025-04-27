/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;
import eST.PORequest.*;
import eST.Common.StRepository;
import eCommon.Common.*;
import java.util.Properties;
import eMM.MM_license_rights;


public class PORequestBean extends eST.Common.StTransaction implements Serializable{
	private String doc_type_code;
	private String doc_no;
	private String doc_ref;
	private String doc_date;
	private String request_by_store;
	private String request_on_store;
	private String finalize_yn;
	private String item_class_code;
	private String entity_param;
	//private String Pending_qty;
	private boolean isAutoNo;
	private String defaultDocType;
	private HashMap hmItemDetail;
	private ArrayList itemKeys;
	private ArrayList checkedItemKeys;
	private ArrayList itemKeysAdded;
	private ArrayList allItemKeys;
	private String item_class_desc;
	private String request_type="";
	public static int count = 0;
	//private String PgetDoc_type_code = "";
	private ArrayList PDocNo ;
	//private String PgetStore_codest = "";
	public String reportserver = "";
	public String report_connect_string = "";




	public PORequestBean() {
		itemKeys = new java.util.ArrayList();
		checkedItemKeys = new java.util.ArrayList();
		hmItemDetail = new java.util.HashMap();
	}
	public void setEntity_param(String entity_param) {
		this.entity_param = entity_param;
	}
	public String getEntity_param() {
		return this.entity_param;
	}
	
	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}
	public String getDoc_type_code() {
		 return doc_type_code;
	}
	public void setItem_class_Desc(String item_class_desc) {
		 this.item_class_desc = checkForNull(item_class_desc);
	}
	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}
	public String getDoc_no() {
		 return doc_no;
	}
	public String getItem_class_Desc() {
		 return this.item_class_desc;
	}
	public void setItem_class_code(String item_class_code) {
		 this.item_class_code = item_class_code;
	}
	public String getItem_class_code() {
		 return this.item_class_code;
	}
	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = doc_ref;
	}
	public String getDoc_ref() {
		 return (doc_ref==null)?"":doc_ref;
	}
		public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}

	public void setRequestType(String request_type){
		this.request_type = request_type;
	}

	public String getRequestType(){
		return request_type;
	}
	public String getDocTypeCodes() {
		return getDefaultDocumentTypeList("PRQ",defaultDocType);
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

	public void setRequest_by_store(String request_by_store) {
	
		this.request_by_store = request_by_store;
	}
	public String getRequest_by_store() {
		 return request_by_store;
	}
	public void setRequest_on_store(String request_on_store) {
		
		this.request_on_store = request_on_store;
	}
	public String getRequest_on_store() {
		 return request_on_store;
	}
		public ArrayList getItemKeys() {
		return this.itemKeys;
	}
	public java.util.ArrayList getItemKeysAdded() {
		return this.itemKeysAdded;
	}
	public java.util.HashMap getHmItemDetail() {
		return this.hmItemDetail;
	}

	public void setHmItemDetail(HashMap hmItemDetail) {
		this.hmItemDetail = hmItemDetail;
	}
	public int getCount(){
		return count++;
	}
	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}
	public boolean getIsAutoNo() {
		return this.isAutoNo;
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

	public void clear() {
		super.clear();
		doc_type_code = null;
		doc_no = null;
		doc_ref = null;
		doc_date = null;
		request_by_store = null;
		request_on_store = null;
		defaultDocType = null;
		isAutoNo = false;
		hmItemDetail = null;
		itemKeys = null;
		itemKeysAdded = null;
		checkedItemKeys =null;
		request_type	=null;
	}
	public void initialize() {
		super.initialize();
		doc_no = "";
		doc_ref = "";
		doc_date = "";
		doc_type_code = "";
		request_by_store = "";
		request_on_store = "";
		defaultDocType = "";
		isAutoNo = false;
		hmItemDetail = new java.util.HashMap();
		itemKeys = new java.util.ArrayList();
		itemKeysAdded = new java.util.ArrayList();
		checkedItemKeys = new java.util.ArrayList();
		request_type = "";
	}

	public String getQRYRequestOnStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_FROM_STORE_SELECT");
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_on_store());
	}  	
		public String getItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(request_by_store);
		sqlParam.add(request_by_store);
		return getListValues(sql, sqlParam,getItem_class_code());
	}

	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
		String chkParameters[] = {request_by_store,getLanguageId()};
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_ITEM_CLASS_STORE_SELECT"),chkParameters);
		//result = fetchRecords("SELECT st.item_class_code, mm.short_desc   FROM st_item_class_store st, mm_item_class_lang_vw mm  WHERE st.store_code = ? AND mm.item_class_code = st.item_class_code AND mm.language_id = ? ORDER BY short_desc",chkParameters);
		return result;
	}

	private String getDefaultDocumentTypeList(String trn_type, String defaultValue) {
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}

	
	public String getRequestByStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT");
		//String sql ="SELECT st.store_code,	mm.short_desc FROM st_user_access_for_store	st,mm_store_lang_vw mm,sm_appl_user sm, st_store ststr WHERE st.store_code = mm.store_code AND st.store_code = ststr.store_code AND st.user_id=sm.appl_user_id AND mm.eff_status = 'E' AND sm.eff_status='E' AND (st.PRQ_allowed_yn='Y' AND ststr.PRQ_allowed_yn='Y') AND mm.facility_id	=? AND st.user_id =? AND mm.language_id = ?  ORDER BY 2";
		
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_by_store());
	}
	public String getRequestOnStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_TO_DEPT_SELECT");
		//String sql="SELECT dept_code,SHORT_DESC FROM am_dept_lang_vw WHERE   eff_status='E'and language_id = ? ORDER BY short_desc";
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_on_store());
	}
	public String getPur_uom_code_Modify_List(String parameters,String item_code,String def_uom) throws Exception{
			boolean select=false;
			String chkParameters[] = {parameters,getLanguageId(),parameters,getLanguageId(),parameters,getLanguageId(),item_code};
		 	return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters,select),def_uom);
		
	}

		public PORequestDetailBean getItemDetail(String item_code) {
		return (PORequestDetailBean) hmItemDetail.get(item_code);
	}

	public java.util.HashMap addDetailRecord(java.util.Hashtable detailRecord) {
		
			java.util.HashMap hashResult = new java.util.HashMap(2);
			hashResult.put("result",new Boolean(false));
	try {
			java.util.HashMap recordCount;
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(detailRecord.get("request_by_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			recordCount = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			String total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_BY_ITEM_STORE_NOT_FOUND");
				return hashResult;
			}
			sqlParameter.clear();
		/*	sqlParameter.add(detailRecord.get("request_on_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			recordCount = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_ON_ITEM_STORE_NOT_FOUND");
				return hashResult;
			}*/
		}
		catch (Exception exception) {
			hashResult.put("message",exception.getMessage());
			return hashResult;
		}															// Validations of store codes Over
		// Logic which adds the record 
		String item_code = (String) detailRecord.get("item_code");
		String editing = (String) detailRecord.get("editing");
		if (editing.equals("1") && itemKeys.contains(item_code)) {
			hashResult.put("message","DUPLICATE_CODE_EXISTS");
			return hashResult;
		}
		else if (editing.equals("1")) {
			itemKeys.add(item_code);
		}
		hmItemDetail.put(item_code, new PORequestDetailBean(detailRecord));
		hashResult.put("result",new Boolean(true));
		hashResult.put("message","");
		return hashResult;
	}
		public java.util.HashMap canAuthorize(String store_code) { 
		try {
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(login_by_id);
			sqlParameter.add(store_code);
			//sqlParameter.add(getLanguageId());
			return fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_REQ_AUTHORIZE_SELECT"),sqlParameter);
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}

		public java.util.HashMap addDetailRecordModifyMode(java.util.Hashtable detailRecord) {
			java.util.HashMap hashResult = new java.util.HashMap(2);
			hashResult.put("result",new Boolean(false));
		try {
			java.util.HashMap recordCount;
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(detailRecord.get("request_by_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			recordCount = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			String total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_BY_ITEM_STORE_NOT_FOUND");
				return hashResult;
			}
			sqlParameter.clear();
			// Validate request on store combination
			/*sqlParameter.add(detailRecord.get("request_on_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			recordCount = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_ON_ITEM_STORE_NOT_FOUND");
				return hashResult;
			}*/
			String item_code = (String) detailRecord.get("item_code");
			String editing = (String) detailRecord.get("editing");
			if (editing.equals("1") && itemKeys.contains(item_code)) {
				hashResult.put("message","DUPLICATE_CODE_EXISTS");
				return hashResult;
			}
			itemKeysAdded.add(item_code);
			hmItemDetail.put(item_code, new PORequestDetailBean(detailRecord));
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
	public ArrayList getBatchDetails(String item_code, String store_code)throws Exception {
			ArrayList BatchDetails=new ArrayList();
		try {
			// To call the procedure st_stock_availability_status
			String[] strParameters = new String[7];
			strParameters[0] = item_code;
			strParameters[1] = store_code;
			strParameters[2] = "0";
			strParameters[3] = "N";
			strParameters[4] = "";//stHeaderBean.getSysDate();
			strParameters[5] = "N";
			strParameters[6] = "";

			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(strParameters);
			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_item_yn"));
			String stParameters[]={store_code, item_code};
			HashMap hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_ON_HAND"),stParameters);
			
			BatchDetails.add(hmRecord.get("QTY_ON_HAND"));
		}
		catch(Exception exception) {
			throw exception;
		}
		return BatchDetails;
	}
	public ArrayList getRequestTypeValue(String item_code,String request_type) throws Exception{
			ArrayList result = new ArrayList();
			try{
			String[] strParameters = new String[2];
			strParameters[0] = item_code;
			strParameters[1] = request_type;
			
			
			HashMap hmRecord	= fetchRecord(getStRepositoryValue("SQL_ST_ITEM_REQUEST_TYPE"),strParameters);
			
			result.add(hmRecord.get("ITEM_CODE"));
			}catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}
			return result;
		}
	public String getDefaultUOM(String item_code,String store_code) throws Exception {
		String chkdefaultParameters[] = {item_code,store_code};
		String default_value		  = "";	
		HashMap default_uom			  = new HashMap();
		try{
			default_uom = fetchRecord(getStRepositoryValue("SQL_ST_REQUEST_UOM_DEFAULT"),chkdefaultParameters);
		}catch(Exception e){
			default_value = "";
		}
		
		if(default_uom.size() > 0)
			default_value = (String)default_uom.get("DEF_REQUEST_UOM");

		return default_value;

	}
	public ArrayList getPur_uom_code_List(String parameters,String item_code) throws Exception{
		String chkParameters[] = {parameters,getLanguageId(),parameters,getLanguageId(),parameters,getLanguageId(),item_code};
		ArrayList result = new ArrayList();
		
		result = fetchRecords(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters);
		return result;
	}
	public String getAuthorizeForRequest(String store_code)throws Exception{
		String result = "";
		try{
		String[] strParameters = new String[2];
		strParameters[0]	   = login_by_id;
		strParameters[1]	   = store_code;
		HashMap results = fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SPL_REQ_AUTHORIZE"),strParameters);
		result = (String)results.get("AUTHORIZE_SPECIAL_REQ_YN");
			}catch(Exception exception){
				exception.printStackTrace();
				throw exception;
			}
		return result;


		}
	public String getGenItemUOMDesc(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};
		String gen_uom_code			  = "";	
		String gen_uom_desc			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			
		base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
		gen_uom_code = "";
		}
		
		if(base_uom.size() > 0){
			gen_uom_code = (String)base_uom.get("GEN_UOM_CODE");
			String chkdefaultParameters1[] = {gen_uom_code,getLanguageId()};
			base_uom = fetchRecord(getStRepositoryValue("SQL_ST_UOM_SHORT_DESC_SELECT1"),chkdefaultParameters1);
			if(base_uom.size() > 0){
				gen_uom_desc = (String)base_uom.get("SHORT_DESC");
			}
		}
		
		return gen_uom_desc;
	}
			
public java.util.HashMap insert() {
		HashMap hmResult = new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		//PORequestDetailBean requestDetailBean;
		ArrayList allanguageData	=	new ArrayList();
		hmResult.put("result", new Boolean(false));
		HashMap porequest=new HashMap();
		String po_req_by="";
		HashMap final_dtl=new HashMap();
		HashMap hmRecord=new HashMap();
		boolean isDocNoAutoGenerated	=	false;
		try{
		 porequest=fetchRecord("select PO_REQ_BY from st_acc_entity_param where ACC_ENTITY_ID=?" ,getEntity_param());
		po_req_by=(String)porequest.get("PO_REQ_BY");
		hmRecord=	fetchRecord(StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"), getDoc_type_code());
				isDocNoAutoGenerated=	hmRecord.get("DOC_NUM_GEN_FLAG").toString().equals("Y");
		}catch(Exception e){
				e.printStackTrace();
		
		}
		if (!isDocNoAutoGenerated) {
			po_req_by="NA";
		
			final_dtl=(HashMap)newInsert("NA");
							
		}else if(po_req_by.equals("MG") && new eMM.MM_license_rights().getSTboundary().equals("I")){
			po_req_by="MG";
			
			final_dtl=newInsert("MG");
			
		}else if(po_req_by.equals("IC")){
			po_req_by="IC";
		
			final_dtl=newInsert("IC");
			}
		else{
			po_req_by="NA";
			
			final_dtl=(HashMap)newInsert("NA");
			}

		
		

		ArrayList alHdrInsertRecord = new ArrayList();
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(getDoc_type_code());
		alHdrInsertRecord.add(getDoc_no());
		alHdrInsertRecord.add(com.ehis.util.DateUtils.convertDate(((String)(getDoc_date_value())),"DMY",getLanguageId(),"en"));//	alHdrInsertRecord.add(getDoc_date_value()); changed by Badmavathi for SRR20056-SCF-9539 on 30/07/2015
		alHdrInsertRecord.add(getDoc_ref());
		alHdrInsertRecord.add(""); //material_group_code
		alHdrInsertRecord.add(getItem_class_code());
		alHdrInsertRecord.add(getRequest_by_store());
		alHdrInsertRecord.add(getRequest_on_store());
		alHdrInsertRecord.add(getFinalize_yn().equals("Yes")?"P":"U");//CURR_STATUS
		alHdrInsertRecord.add(login_by_id);//CURR_STATUS_BY_ID
		alHdrInsertRecord.add("");//CURR_STATUS_REMARKS
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(getRequestType());//request_type
		
		allanguageData.add(getLanguageId());
	
		ArrayList alRequestStatusInsertRecord = new ArrayList();
		alRequestStatusInsertRecord.add(login_facility_id);//FACILITY_ID
		alRequestStatusInsertRecord.add(getDoc_type_code());//DOC_TYPE_CODE
		alRequestStatusInsertRecord.add(getDoc_no());//DOC_NO
		alRequestStatusInsertRecord.add("1");//STATUS_SRL_NO
		alRequestStatusInsertRecord.add(getFinalize_yn().equals("Yes")?"P":"U");//STATUS
		alRequestStatusInsertRecord.add(login_by_id);//STATUS_BY_ID
		alRequestStatusInsertRecord.add("");//STATUS_REMARKS
		alRequestStatusInsertRecord.add(login_by_id);
		alRequestStatusInsertRecord.add(login_at_ws_no);
		alRequestStatusInsertRecord.add(login_facility_id);
		alRequestStatusInsertRecord.add(login_by_id);
		alRequestStatusInsertRecord.add(login_at_ws_no);
		alRequestStatusInsertRecord.add(login_facility_id);

		java.util.ArrayList alUpdateData = new java.util.ArrayList (4);
		alUpdateData.add(login_by_id);
		alUpdateData.add(login_at_ws_no);
		alUpdateData.add(login_facility_id);
		alUpdateData.add(getDoc_type_code());
	
		hmSQLMap.put("InsertHDRSQL", StRepository.getStKeyValue("SQL_ST_PO_REQUEST_HDR_INSERT")); 
	
		//	hmSQLMap.put("InsertHDRSQL", "INSERT INTO po_request_hdr (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, DOC_DATE, DOC_REF, MATERIAL_GROUP_CODE, ITEM_CLASS_CODE, REQ_STORE_CODE, PUR_DEPT_CODE, CURR_STATUS, CURR_STATUS_BY_ID, CURR_STATUS_DATE, CURR_STATUS_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,REQUEST_TYPE)VALUES(?, ?,?, TO_DATE(?,'DD/MM/YYYY'), ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?)"); 
		hmSQLMap.put("InsertDTLSQL", StRepository.getStKeyValue("SQL_ST_PO_REQUEST_DTL_INSERT")); 
	
	
		//	hmSQLMap.put("InsertDTLSQL","INSERT INTO po_request_dtl (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, DOC_SRL_NO, ITEM_CODE, REQ_QTY, REQ_UOM, REQ_GEN_UOM_CONV_FACTOR, REQ_GEN_UOM_QTY, GRN_QTY, GRN_UOM, GRN_GEN_UOM_QTY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)" ); 
		hmSQLMap.put("InsertStatusDTLSQL", StRepository.getStKeyValue("SQL_ST_PO_REQUEST_STATUS_INSERT")); 

		//hmSQLMap.put("InsertStatusDTLSQL","INSERT INTO po_request_status (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, STATUS_SRL_NO, STATUS, STATUS_BY_ID, STATUS_DATE, STATUS_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)"); 
	
	
	
		hmSQLMap.put("UpdateSQL", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")); 
		hmSQLMap.put("sql_st_records_per_trn_select", StRepository.getStKeyValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_select", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_select_flag", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertHDRData",alHdrInsertRecord);
		//hmTableData.put("InsertDTLData",alDtlInsertRecord);
		hmTableData.put("alRequestStatusInsertRecord",alRequestStatusInsertRecord);
		hmTableData.put("UpdateData",alUpdateData);
		hmTableData.put("LANGUAGE_DATA",	allanguageData);
	//	hmSQLMap.put("UpdateITMSQL", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_PENDING_UPDATE")); 
		hmSQLMap.put("UpdateITMSQL", "UPDATE ST_ITEM_STORE SET PENDING_PO_REQ_QTY = NVL(PENDING_PO_REQ_QTY,0) +	? ,	MODIFIED_BY_ID = ?,	MODIFIED_DATE =	SYSDATE, MODIFIED_AT_WS_NO = ?,	MODIFIED_FACILITY_ID = ? WHERE STORE_CODE =	? AND  ITEM_CODE = ?"); 
	//	hmTableData.put("UpdateITMData",alUpdateItemData);
		hmTableData.put("FINAL_DTL",final_dtl);
		hmTableData.put("PO_REQUEST_BY",po_req_by);
		hmTableData.put("ISDOCNOAUTOGENERATED",hmRecord.get("DOC_NUM_GEN_FLAG").toString());
			
		PORequestRemote requestRemote = null;
		try {
		//	Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(StRepository.getStKeyValue("JNDI_ST_REQUEST"), RequestHome.class,getLocalEJB());
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PORequest", PORequestHome.class,getLocalEJB());
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
			hmResult.put("message",getSTMessage(getLanguageId(),ms_id,"ST") ) ;
			else {
		
			hmResult.put("message","Transcation failed") ;
			}
			//hmResult.put("message",getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
		}
		catch(Exception e) {
				hmResult.put("message", e.toString());
				e.printStackTrace();
		} 
		finally {
			try {
				if(requestRemote != null)
					requestRemote.remove();
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
		/*if (mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))) {
			setDoc_type_code((String)hashValues.get("doc_type_code"));
			setDoc_no((String)hashValues.get("doc_no"));
			setDoc_date((String)hashValues.get("doc_date"));
			return;
		}*/
		setDoc_type_code((String)hashValues.get("doc_type_code"));
		setDoc_no((String)hashValues.get("doc_no"));
		setDoc_date((String)hashValues.get("doc_date"));
		setDoc_ref((String)hashValues.get("doc_ref"));
		setRequest_by_store((String)hashValues.get("request_by_store"));
		setRequest_on_store((String)hashValues.get("request_on_store"));
		setIsAutoNo(hashValues.get("autono_yn").equals("Yes")?true:false);
		setFinalize_yn((String)hashValues.get("finalize_yn"));
		setItem_class_code((String)hashValues.get("item_class_code"));
		setRequestType((String)hashValues.get("request_type"));
		java.util.Enumeration hashKeys = hashValues.keys();
		itemKeysAdded=new ArrayList();
		while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("add_itm_")) {
				selectedKey = (String) hashValues.get(keyCode);
				if (selectedKey != null && selectedKey.trim().length()>0) {
					
					itemKeysAdded.add(selectedKey);
					checkedItemKeys.add(selectedKey);
				}
			}
		}
	}

		public java.util.ArrayList getOnStores(String req_by_store) throws Exception {
			ArrayList result		=	new ArrayList();
			String chkParameters[]  = {getLanguageId(),getRequest_by_store()};
			result = fetchRecords(StRepository.getStKeyValue("SQL_ST_MM_STORE_SELECT"),chkParameters);
			//	result = fetchRecords("SELECT mm.po_dept_code PARENT_STORE_CODE, am.short_desc FROM mm_store_lang_vw mm, am_dept_lang_vw am WHERE  mm.language_id = am.language_id   AND mm.po_dept_code =  am.dept_code  AND mm.language_id = ? and  mm.store_code = ? ORDER BY 2, 1",chkParameters);
			
			return result;
	}


	public void loadData(String doc_type_code, String doc_no) {
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		PORequestDetailBean requestDetailBean;
        itemKeysAdded = new java.util.ArrayList();
		try {
            connection = getConnection();
           pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_PO_REQUEST_HDR_SELECT1"));
          //  pstmt = connection.prepareStatement("SELECT facility_id, doc_type_code, doc_no,TO_CHAR (doc_date, 'dd/mm/yyyy'), doc_ref, item_class_code,   req_store_code, pur_dept_code,request_type FROM po_request_hdr WHERE facility_id = ? AND doc_type_code = ? AND doc_no = ?");
            pstmt.setString(1, login_facility_id);
            pstmt.setString(2, doc_type_code);
            pstmt.setString(3, doc_no);
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				setDoc_type_code(resultSet.getString("doc_type_code"));
				setDoc_no(resultSet.getString("doc_no"));

				setDoc_date(resultSet.getString(4));
				setDoc_ref(resultSet.getString("doc_ref"));
				setRequest_by_store(resultSet.getString("req_store_code"));
				setRequest_on_store(resultSet.getString("pur_dept_code"));
				setItem_class_code(resultSet.getString("item_class_code"));
				setRequestType(resultSet.getString("request_type"));
            }
			closeResultSet(resultSet);
            closeStatement(pstmt);
			allItemKeys = new java.util.ArrayList();
          //  pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_PO_REQUEST_DTL_SELECT"));
          pstmt = connection.prepareStatement("SELECT   doc_srl_no, dtl.item_code, itm.short_desc item_desc, dtl.REQ_QTY, itstr1.def_issue_uom uom,uom.short_desc uom_desc, dtl.req_uom,dtl.REQ_GEN_UOM_CONV_FACTOR, dtl.REQ_GEN_UOM_QTY,itstr1.qty_on_hand, itstr1.max_stk_qty, itm.gen_uom_code,(CASE WHEN allow_decimals_yn = 'Y' AND disp_decimal_dtls_yn = 'Y' THEN no_of_decimals ELSE 0 END ) no_of_decimals, (CASE WHEN disp_decimal_dtls_yn = 'N' THEN 'N' ELSE NVL (c.allow_decimals_yn, 'N') END ) allow_decimals_yn  FROM po_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw uom, po_request_hdr hdr, st_item_store itstr1,st_item c,ST_ACC_ENTITY_PARAM PM WHERE dtl.facility_id = ? AND dtl.doc_type_code = ? AND dtl.doc_no = ?  AND dtl.item_code = itm.item_code  AND itstr1.def_issue_uom = uom.uom_code  AND dtl.facility_id = hdr.facility_id  AND dtl.doc_type_code = hdr.doc_type_code   AND dtl.doc_no = hdr.doc_no  AND hdr.req_store_code = itstr1.store_code  AND dtl.item_code = itstr1.item_code AND itm.language_id = uom.language_id AND itm.language_id = ?  and C.ITEM_CODE=DTL.ITEM_CODE and PM.ACC_ENTITY_ID = 'ZZ' ORDER BY doc_srl_no");
            pstmt.setString(1, login_facility_id);
            pstmt.setString(2, doc_type_code);
            pstmt.setString(3, doc_no);
            pstmt.setString(4, getLanguageId());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				requestDetailBean = new PORequestDetailBean(resultSet);

				itemKeys.add(requestDetailBean.getItem_code());
				allItemKeys.add(requestDetailBean.getItem_code());
				hmItemDetail.put(requestDetailBean.getItem_code(), requestDetailBean);
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

	}



	public java.util.HashMap modify() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	alModifyData = new ArrayList();
		ArrayList	alParams = new ArrayList();
		Properties properties = getProperties();

        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

		hmTableData.put("properties",properties);
		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Initial Message") ;
		PORequestRemote requestRemote = null;
		/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function 
	*/

	int no_of_decimals					=			getNoOfDecimals();
	int no_of_decimals_temp				=			getNoOfDecimals();

		try
		{
		connection = getConnection();

		//Get the maximum serial no
		java.util.ArrayList alUpdateItemData = new java.util.ArrayList ();
		String key = (String) allItemKeys.get(allItemKeys.size()-1);
		PORequestDetailBean requestDetailBean = (PORequestDetailBean) hmItemDetail.get(key);
		int max_serial_no = requestDetailBean.getSrl_no();
		requestDetailBean = null;											
		alModifyData.add(com.ehis.util.DateUtils.convertDate(((String)(getDoc_date_value())),"DMY",getLanguageId(),"en"));//	alModifyData.add(getDoc_date_value()); changed by Badmavathi for SRR20056-SCF-9539 on 30/07/2015 
		alModifyData.add(getDoc_ref());
	//	alModifyData.add(getFinalize_yn().equals("Yes")?login_by_id:"");
		alModifyData.add(getFinalize_yn().equals("Yes")?"P":"U");
		alModifyData.add(login_by_id);
		alModifyData.add(com.ehis.util.DateUtils.convertDate(((String)(getDoc_date_value())),"DMY",getLanguageId(),"en"));// 	alModifyData.add(getDoc_date_value()); changed by Badmavathi for SRR20056-SCF-9539 on 30/07/2015
		alModifyData.add("");
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id);
		alModifyData.add(login_facility_id);
		alModifyData.add(getDoc_type_code());
		alModifyData.add(getDoc_no());
		hmTableData.put("UpdateData",alModifyData);
		hmSQLMap.put("UpdateSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_HDR_UPDATE"));
		//	hmSQLMap.put("UpdateSQL","UPDATE PO_REQUEST_HDR SET DOC_DATE= TO_DATE(?,'DD/MM/YYYY') ,DOC_REF= ? ,CURR_STATUS=?,CURR_STATUS_BY_ID=?,CURR_STATUS_DATE=TO_DATE(?,'DD/MM/YYYY'),CURR_STATUS_REMARKS=?, MODIFIED_BY_ID = ? , MODIFIED_DATE = SYSDATE , MODIFIED_AT_WS_NO = ? , MODIFIED_FACILITY_ID =?  WHERE FACILITY_ID = ?  AND DOC_TYPE_CODE= ? AND DOC_NO= ?");

		

		int detailSize = -1;
		alParams.add(getDoc_no());
		alParams.add(login_facility_id);
		alParams.add(getDoc_type_code());
		//int detailSizeTemp = Integer.parseInt((String)fetchRecord("SELECT COUNT(*) COUNT FROM PO_REQUEST_DTL WHERE DOC_NO =? AND FACILITY_ID=? AND DOC_TYPE_CODE = ?",alParams).get("COUNT"));
		int detailSizeTemp = Integer.parseInt((String)fetchRecord(getStRepositoryValue("SQL_ST_PO_REQUEST_DTL_COUNT"),alParams).get("COUNT"));
		

		max_serial_no=0;
		if (itemKeysAdded != null && itemKeysAdded.size()>0) {
			detailSize		= itemKeysAdded.size();
			ArrayList alInsertRecord = new ArrayList(detailSize);
			for (int index=0;index<detailSize;index++) {
				if((itemKeysAdded.get(index) == null) || (itemKeysAdded.get(index).equals(""))) {
						continue;
				}

				requestDetailBean = (PORequestDetailBean) hmItemDetail.get(itemKeysAdded.get(index));
				ArrayList alInsertDtlRecord = new ArrayList();
	/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/

			if(getAllowDecimalsYN((String)requestDetailBean.getItem_code()).equals("N")){
			no_of_decimals = 0;
			}else{
			no_of_decimals=	no_of_decimals_temp;
			}
				alInsertDtlRecord.add(login_facility_id);//FACILITY_ID
				alInsertDtlRecord.add(getDoc_type_code());//DOC_TYPE_CODE
				alInsertDtlRecord.add(getDoc_no());//DOC_NO
				if(requestDetailBean.getSrl_no()==-1)
				alInsertDtlRecord.add(""+(++detailSizeTemp));
				else
				alInsertDtlRecord.add(""+(requestDetailBean.getSrl_no()));
				alInsertDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
				alInsertDtlRecord.add(setNumber((String)requestDetailBean.getRequired_qty(),no_of_decimals));//REQ_QTY
				alInsertDtlRecord.add(requestDetailBean.getPurUomCode()); //req_uom
				alInsertDtlRecord.add(requestDetailBean.getConvFact());//REQ_GEN_UOM_CONV_FACTOR
				alInsertDtlRecord.add(setNumber((String)requestDetailBean.getReqUomQty(),no_of_decimals));//REQ_GEN_UOM_QTY
				alInsertDtlRecord.add("0"); //grn_qty
				alInsertDtlRecord.add(""); //grn_uom
				alInsertDtlRecord.add(""); //grn_gen_uom_qty
				alInsertDtlRecord.add(login_by_id);
				alInsertDtlRecord.add(login_at_ws_no);
				alInsertDtlRecord.add(login_facility_id);
				alInsertDtlRecord.add(login_by_id);
				alInsertDtlRecord.add(login_at_ws_no);
				alInsertDtlRecord.add(login_facility_id);
				alInsertRecord.add(alInsertDtlRecord);	
					pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_PO_REQUEST_DTL_SELECT1"));
				//	pstmt = connection.prepareStatement("SELECT REQ_QTY FROM po_request_dtl WHERE facility_id = ? AND doc_type_code = ? AND doc_no = ?  AND doc_srl_no = ?");
					String old_pending_item_qty = "";
					
					double req_qty=Double.parseDouble(requestDetailBean.getRequired_qty())/getConvFactTemp(requestDetailBean.getItem_code(),getRequest_by_store());
					pstmt.setString(1, login_facility_id);
					pstmt.setString(2, getDoc_type_code());
					pstmt.setString(3, getDoc_no());
					pstmt.setString(4, ""+requestDetailBean.getSrl_no());
					resultSet = pstmt.executeQuery();
					while (resultSet != null && resultSet.next()) {
						old_pending_item_qty = resultSet.getString("REQ_QTY");
						if(old_pending_item_qty != null) {
							double i_pending_item_qty = Double.parseDouble(old_pending_item_qty);
							old_pending_item_qty = setNumber(""+(-(i_pending_item_qty-req_qty)),no_of_decimals);
							ArrayList alUpdRecord=new ArrayList();
							alUpdRecord.add(old_pending_item_qty);
							alUpdRecord.add(login_by_id);
							alUpdRecord.add(login_at_ws_no);
							alUpdRecord.add(login_facility_id);
					 		alUpdRecord.add(getRequest_by_store());
							alUpdRecord.add(requestDetailBean.getItem_code());
					alUpdateItemData.add(alUpdRecord);
						}
					}
				closeResultSet(resultSet);
               closeStatement(pstmt);
			}
			hmTableData.put("InsertDTLData",alInsertRecord);

		//	hmSQLMap.put("InsertDTLSQL","INSERT INTO po_request_dtl (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, DOC_SRL_NO, ITEM_CODE, REQ_QTY, REQ_UOM, REQ_GEN_UOM_CONV_FACTOR, REQ_GEN_UOM_QTY, GRN_QTY, GRN_UOM, GRN_GEN_UOM_QTY, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)" ); 
	
		hmSQLMap.put("InsertDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_DTL_INSERT"));
			checkedItemKeys.removeAll(itemKeysAdded);
		}
		detailSize = checkedItemKeys.size();
		requestDetailBean = null;
		ArrayList alUpdateRecord = new ArrayList(detailSize);
		for (int index=0;index<detailSize;index++) {
			if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) {
					continue;
			}
			requestDetailBean = (PORequestDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
			ArrayList alUpdateDtlRecord = new ArrayList(10);
						/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item.
	*/

			if(getAllowDecimalsYN((String)requestDetailBean.getItem_code()).equals("N")){
			no_of_decimals = 0;
			}else{
			no_of_decimals=	no_of_decimals_temp;
			}
			alUpdateDtlRecord.add(setNumber((String)requestDetailBean.getRequired_qty(),no_of_decimals));//REQ_QTY
			alUpdateDtlRecord.add(requestDetailBean.getPurUomCode());//req_uom
			alUpdateDtlRecord.add(requestDetailBean.getConvFact());//REQ_GEN_UOM_CONV_FACTOR
			alUpdateDtlRecord.add(setNumber((String)requestDetailBean.getReqUomQty(),no_of_decimals));//REQ_GEN_UOM_QTY
			
			alUpdateDtlRecord.add("0"); //grn_qty
			alUpdateDtlRecord.add(""); //grn_uom
			alUpdateDtlRecord.add(""); 
			alUpdateDtlRecord.add(login_by_id);
			alUpdateDtlRecord.add(login_at_ws_no);
			alUpdateDtlRecord.add(login_facility_id);
			alUpdateDtlRecord.add(login_facility_id);
			alUpdateDtlRecord.add(getDoc_type_code());
			alUpdateDtlRecord.add(getDoc_no());
			alUpdateDtlRecord.add(""+requestDetailBean.getSrl_no());
			alUpdateRecord.add(alUpdateDtlRecord);
			
		}
		hmTableData.put("UpdateDTLData",alUpdateRecord);
		hmSQLMap.put("UpdateDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_DTL_UPDATE"));
	
 	//	hmSQLMap.put("UpdateDTLSQL","UPDATE	po_request_dtl SET REQ_QTY	= ?,REQ_UOM=? ,REQ_GEN_UOM_CONV_FACTOR=?  ,REQ_GEN_UOM_QTY=?,GRN_QTY=?,GRN_UOM=?, GRN_GEN_UOM_QTY=? ,modified_by_id =? ,modified_date =	SYSDATE	, modified_at_ws_no	= ?	, modified_facility_id = ? WHERE facility_id =	?  AND doc_type_code = ?  AND doc_no = ?  AND doc_srl_no = ?");
		//hmSQLMap.put("UpdateITMSQL", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_PENDING_UPDATE")); 
		hmSQLMap.put("UpdateITMSQL", "UPDATE ST_ITEM_STORE SET PENDING_PO_REQ_QTY = NVL(PENDING_PO_REQ_QTY,0) +	? ,	MODIFIED_BY_ID = ?,	MODIFIED_DATE =	SYSDATE, MODIFIED_AT_WS_NO = ?,	MODIFIED_FACILITY_ID = ? WHERE STORE_CODE =	? AND  ITEM_CODE = ?"); 
		hmTableData.put("UpdateITMData",alUpdateItemData); 
		detailSize = -1;
		if (allItemKeys != null && allItemKeys.size() > 0) {
			allItemKeys.removeAll(checkedItemKeys);
			if (allItemKeys.size() >0) {
				detailSize = allItemKeys.size();
				ArrayList alDeleteRecord = new ArrayList(detailSize);
				for (int index=0;index<detailSize;index++) {
					if((allItemKeys.get(index) == null) || (allItemKeys.get(index).equals(""))) 
							continue;
					requestDetailBean = (PORequestDetailBean) hmItemDetail.get(allItemKeys.get(index));
					ArrayList alDeleteDtlRecord = new ArrayList(4);
					alDeleteDtlRecord.add(login_facility_id);
					alDeleteDtlRecord.add(getDoc_type_code());
					alDeleteDtlRecord.add(getDoc_no());
					alDeleteDtlRecord.add(""+requestDetailBean.getSrl_no());
					alDeleteRecord.add(alDeleteDtlRecord);
				}
				hmTableData.put("DeleteDTLData",alDeleteRecord);
				hmSQLMap.put("DeleteDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_DTL_DELETE"));
			//	hmSQLMap.put("DeleteDTLSQL","DELETE FROM	po_request_dtl WHERE facility_id = ?  AND doc_type_code	= ?	 AND doc_no	= ?	AND	doc_srl_no = ?");
			}
		}
//PoStatus
		ArrayList alRequestStatusInsertRecord = new ArrayList();
		alRequestStatusInsertRecord.add(login_facility_id);//FACILITY_ID
		alRequestStatusInsertRecord.add(getDoc_type_code());//DOC_TYPE_CODE
		alRequestStatusInsertRecord.add(getDoc_no());//DOC_NO
		String status_srl_no="0";
		try{
		status_srl_no=(String)fetchRecord("select ST_STATUS_SRL_NO.nextval count  from dual").get("COUNT");
		}catch (Exception e){
			e.printStackTrace();

		}
		alRequestStatusInsertRecord.add(status_srl_no);//STATUS_SRL_NO
		alRequestStatusInsertRecord.add(getFinalize_yn().equals("Yes")?"P":"U");//STATUS
		alRequestStatusInsertRecord.add(login_by_id);//STATUS_BY_ID
		alRequestStatusInsertRecord.add("");//STATUS_REMARKS
		alRequestStatusInsertRecord.add(login_by_id);
		alRequestStatusInsertRecord.add(login_at_ws_no);
		alRequestStatusInsertRecord.add(login_facility_id);
		alRequestStatusInsertRecord.add(login_by_id);
		alRequestStatusInsertRecord.add(login_at_ws_no);
		alRequestStatusInsertRecord.add(login_facility_id);
		hmTableData.put("alRequestStatusInsertRecord",alRequestStatusInsertRecord);
		hmSQLMap.put("InsertStatusDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_STATUS_INSERT"));
	
		//hmSQLMap.put("InsertStatusDTLSQL","INSERT INTO po_request_status (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, STATUS_SRL_NO, STATUS, STATUS_BY_ID, STATUS_DATE, STATUS_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)"); 
	
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PORequest",PORequestHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); ;
		paramArray[1] = hmSQLMap.getClass();

		hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		hmResult.put("message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;

		} 
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString()) ;
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(requestRemote != null)
					requestRemote.remove() ;
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

		alDeleteData.add(login_facility_id);
		alDeleteData.add(getDoc_type_code());
		alDeleteData.add(getDoc_no());
		try {
			connection = getConnection();
          pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_PO_REQUEST_HDR_SELECT2"));
        //    pstmt = connection.prepareStatement("SELECT req_store_code, item_code, req_qty FROM po_request_hdr hdr, po_request_dtl dtl WHERE hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND hdr.facility_id = ? AND hdr.doc_type_code = ? AND hdr.doc_no = ?");
            pstmt.setString(1, login_facility_id);
            pstmt.setString(2, getDoc_type_code());
            pstmt.setString(3, getDoc_no());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
	      
			
		//	pstmt1 = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_STORE_PENDING_UPDATE"));
			pstmt1 = connection.prepareStatement("UPDATE ST_ITEM_STORE SET PENDING_PO_REQ_QTY = NVL(PENDING_PO_REQ_QTY,0) +	? ,	MODIFIED_BY_ID = ?,	MODIFIED_DATE =	SYSDATE, MODIFIED_AT_WS_NO = ?,	MODIFIED_FACILITY_ID = ? WHERE STORE_CODE =	? AND  ITEM_CODE = ?");
			pstmt1.setString(1, "-"+resultSet.getString("req_qty"));
            pstmt1.setString(2, login_by_id);
            pstmt1.setString(3, login_at_ws_no);
            pstmt1.setString(4, login_facility_id);
            pstmt1.setString(5, resultSet.getString("req_store_code"));
            pstmt1.setString(6, resultSet.getString("item_code"));
			pstmt1.executeUpdate();
			
			

			closeStatement(pstmt1);
			}
						
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	
		
		hmTableData.put("properties",properties);
		hmTableData.put("DeleteHDRData",alDeleteData);
		hmTableData.put("DeleteDTLData",alDeleteData);
		hmTableData.put("DeleteSTATUSData",alDeleteData);
		hmSQLMap.put("DeleteHDRSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_HDR_DELETE"));
		//	hmSQLMap.put("DeleteHDRSQL","DELETE	FROM po_request_hdr	WHERE facility_id =	?  AND doc_type_code = ?  AND doc_no = ?");
		hmSQLMap.put("DeleteDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_DTL_DELETE1"));
		//	hmSQLMap.put("DeleteDTLSQL","DELETE	FROM po_request_dtl	WHERE facility_id =	?  AND doc_type_code = ?  AND doc_no = ?");
		hmSQLMap.put("DeleteSTATUSSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_STATUS_DELETE"));

		//	hmSQLMap.put("DeleteSTATUSSQL","DELETE	FROM po_request_status	WHERE facility_id =	?  AND doc_type_code = ?  AND doc_no = ?");
	
		PORequestRemote requestRemote = null;
		try {
				
		//	Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(StRepository.getStKeyValue("JNDI_ST_REQUEST"),RequestHome.class,getLocalEJB());
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PORequest",PORequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			 hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		hmResult.put("message",getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
		}catch(Exception e) {
			hmResult.put("message", e.toString()) ;
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(requestRemote != null)
					requestRemote.remove() ;
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


public HashMap newInsert(String PORequest_by) {
		//HashMap hmTableData = new HashMap();
	//	HashMap hmSQLMap = new HashMap();
		String metarial="";
		HashMap final_dtl= new HashMap();
		PORequestDetailBean requestDetailBean;
	//	ArrayList allanguageData	=	new ArrayList();
		java.util.ArrayList alUpdateItemData = new ArrayList();
		int detailSize = checkedItemKeys.size();
		HashMap meterial_group = new HashMap();
		ArrayList all_mm_item_code = new ArrayList();
		/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function 
	*/

	int no_of_decimals					=			getNoOfDecimals();
	int no_of_decimals_temp				=			getNoOfDecimals();
		HashMap ITEM_CODE=new  HashMap();
		try{
		ArrayList alDtlInsertRecord = new ArrayList(detailSize);
		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (PORequestDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
			if(PORequest_by.equals("MG")){
				ITEM_CODE=fetchRecord("select MATERIAL_GROUP_CODE from mm_item where ITEM_CODE=?",(String)requestDetailBean.getItem_code());
				metarial=(String)ITEM_CODE.get("MATERIAL_GROUP_CODE");
			}else if(PORequest_by.equals("IC")){
				ITEM_CODE=fetchRecord("select ITEM_CLASS_CODE  from mm_item where ITEM_CODE=?",(String)requestDetailBean.getItem_code());
				metarial=(String)ITEM_CODE.get("ITEM_CLASS_CODE");
			}
		
			ArrayList alDtlRecord = new ArrayList();
			alDtlRecord.add(login_facility_id);//FACILITY_ID
			alDtlRecord.add(getDoc_type_code());//DOC_TYPE_CODE
			alDtlRecord.add(getDoc_no());//DOC_NO
			if(PORequest_by.equals("MG") || PORequest_by.equals("IC")){
			if(meterial_group.containsKey(metarial)){
				alDtlInsertRecord=(ArrayList)meterial_group.get(metarial);
				alDtlRecord.add(""+(alDtlInsertRecord.size()+1));//DOC_SRL_NO
			}else{
			alDtlRecord.add(""+1);//DOC_SRL_NO
			}
			}else{
			alDtlRecord.add(""+(index+1));//DOC_SRL_NO
			}
	/**
	* @Name - krishna
	* @Date - 22/01/2010
	* @Inc# - IN015496
	* @Desc - Making No.of Decimals to zero if Decimal is not allowed by the item set number is called.
	*/

			if(getAllowDecimalsYN((String)requestDetailBean.getItem_code()).equals("N")){
			no_of_decimals = 0;
			}else{
			no_of_decimals=	no_of_decimals_temp;
			}

			alDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
			alDtlRecord.add(setNumber((String)requestDetailBean.getRequired_qty(),no_of_decimals));//REQ_QTY
			alDtlRecord.add(requestDetailBean.getPurUomCode()); //req_uom
			alDtlRecord.add(requestDetailBean.getConvFact());//REQ_GEN_UOM_CONV_FACTOR
			alDtlRecord.add(setNumber((String)requestDetailBean.getReqUomQty(),no_of_decimals));//REQ_GEN_UOM_QTY
			alDtlRecord.add("0"); //grn_qty
			alDtlRecord.add(""); //grn_uom
			alDtlRecord.add(""); //grn_gen_uom_qty
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			if(PORequest_by.equals("MG") || PORequest_by.equals("IC")){
			if(meterial_group.containsKey(metarial)){
			alDtlInsertRecord=(ArrayList)meterial_group.get(metarial);
			alDtlInsertRecord.add(alDtlRecord);	
			}else{
			alDtlInsertRecord = new java.util.ArrayList ();
			alDtlInsertRecord.add(alDtlRecord);	
			all_mm_item_code.add(metarial);
			}
			meterial_group.put(metarial,alDtlInsertRecord);
			}else{
			alDtlInsertRecord.add(alDtlRecord);		
			}
			double pending_qty = Double.parseDouble((String)requestDetailBean.getRequired_qty())/getConvFactTemp(requestDetailBean.getItem_code(),getRequest_by_store());
		
			java.util.ArrayList alUpdRecord = new java.util.ArrayList();
			alUpdRecord.add(setNumber(""+pending_qty,no_of_decimals));
			alUpdRecord.add(login_by_id);
			alUpdRecord.add(login_at_ws_no);
			alUpdRecord.add(login_facility_id);			  
			/* The pending req qty has to be updated for the request_by_store */
			alUpdRecord.add(getRequest_by_store());
			alUpdRecord.add(requestDetailBean.getItem_code());
			alUpdateItemData.add(alUpdRecord);
			
		}
		if(PORequest_by.equals("MG") || PORequest_by.equals("IC")){
		final_dtl.put("FINAL_DTL",meterial_group);
		final_dtl.put("ALL_MM_ITEM_CODE",all_mm_item_code);
		final_dtl.put("ALUPDATEITEMDATA",alUpdateItemData);

		}else{
		final_dtl.put("FINAL_DTL",alDtlInsertRecord);
		final_dtl.put("ALUPDATEITEMDATA",alUpdateItemData);
		}
		}catch(Exception e){
			e.printStackTrace();
			
		}

	return final_dtl;
	}
	public double getConvFactTemp(String item_code,String store_code){
		double conv_fac_temp=1.0;
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		ArrayList alParameters = new ArrayList();
		try {
			
			
			alParameters.add(item_code);
			alParameters.add(store_code);

			 conv_fac_temp=Double.parseDouble(checkForNull((String)fetchRecord("SELECT St_Get_Uom_Conv_Fac_Sing_Str(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"),"1.0"));
			
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
                      try{
							closeResultSet(resultSet);
							closeStatement(pstmt);
							closeConnection(connection);
                         }
					  catch(Exception es){
				             es.printStackTrace();
                         }
		}
		return conv_fac_temp;
	}


}

