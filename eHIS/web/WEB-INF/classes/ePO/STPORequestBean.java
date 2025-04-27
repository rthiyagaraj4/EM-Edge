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
import ePO.Common.PoRepository;
import eCommon.Common.*;
import java.util.Properties;
import eMM.MM_license_rights;
import javax.servlet.* ;
import javax.servlet.http.*;


public class STPORequestBean extends ePO.Common.PoTransaction implements Serializable{
	private String doc_type_code;
	private String doc_no;
	private String doc_ref;
	private String doc_date;
	private String request_by_store;
	private String request_on_store;
	private String finalize_yn;
	private String item_class_code;
	private String entity_param;
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
	private ArrayList PDocNo ;
	private String PgetStore_codepo = "";
	public String reportserver = "";
	public String report_connect_string = "";

	private String master_type;
	private String headerRemarks;




	public STPORequestBean() {
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
		return getDefaultDocumentTypeList("POREQN",defaultDocType);
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
		master_type ="";
		headerRemarks="";
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
		master_type="";
		headerRemarks="";
	}

	public String getQRYRequestOnStore() {
		String sql = ePO.Common.PoRepository.getPoKeyValue("SQL_ST_PO_REQUEST_FROM_STORE_SELECT");
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_on_store());
	}  	
		public String getItemClasses() {
		String sql = ePO.Common.PoRepository.getPoKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(request_by_store);
		sqlParam.add(request_by_store);
		return getListValues(sql, sqlParam,getItem_class_code());
	}

	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
		String chkParameters[] = {request_by_store,getLanguageId()};
		ArrayList result = new ArrayList();
		result = fetchRecords(getPoRepositoryValue("SQL_ST_ITEM_CLASS_STORE_SELECT"),chkParameters);
		return result;
	}

	private String getDefaultDocumentTypeList(String master_type, String defaultValue) {
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(master_type);
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),alParameters),defaultValue);
	}

	
	public String getRequestByStore() {
		String sql = ePO.Common.PoRepository.getPoKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT");
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_by_store());
	}
	public String getRequestOnStore() {
		String sql = ePO.Common.PoRepository.getPoKeyValue("SQL_ST_PO_REQUEST_TO_DEPT_SELECT");
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_on_store());
	}
	public String getPur_uom_code_Modify_List(String parameters,String item_code,String def_uom) throws Exception{
			boolean select=false;
			String chkParameters[] = {parameters,getLanguageId(),parameters,getLanguageId(),parameters,getLanguageId(),item_code};
		 	return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters,select),def_uom);
		
	}

		public STPORequestDetailBean getItemDetail(String item_code) {
		return (STPORequestDetailBean) hmItemDetail.get(item_code);
	}

	public java.util.HashMap addDetailRecord(java.util.Hashtable detailRecord) {
		
			java.util.HashMap hashResult = new java.util.HashMap(2);
			hashResult.put("result",new Boolean(false));
	try {
			java.util.HashMap recordCount;
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(detailRecord.get("request_by_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			recordCount = fetchRecord(getPoRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			String total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_BY_ITEM_STORE_NOT_FOUND");
				return hashResult;
			}
			sqlParameter.clear();
	
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
		hmItemDetail.put(item_code, new STPORequestDetailBean(detailRecord));
		hashResult.put("result",new Boolean(true));
		hashResult.put("message","");
		return hashResult;
	}
		public java.util.HashMap canAuthorize(String store_code) { 
		try {
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(getLoginById());
			sqlParameter.add(store_code);
			return fetchRecord(getPoRepositoryValue("SQL_PO_USER_ACCESS_ALLOW_AUTHORIZE_SELECT"),sqlParameter);
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
			recordCount = fetchRecord(getPoRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			String total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_BY_ITEM_STORE_NOT_FOUND");
				return hashResult;
			}
			sqlParameter.clear();
		
			String item_code = (String) detailRecord.get("item_code");
			String editing = (String) detailRecord.get("editing");
			if (editing.equals("1") && itemKeys.contains(item_code)) {
				hashResult.put("message","DUPLICATE_CODE_EXISTS");
				return hashResult;
			}
			itemKeysAdded.add(item_code);
			hmItemDetail.put(item_code, new STPORequestDetailBean(detailRecord));
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
			HashMap hmRecord	=	fetchRecord(getPoRepositoryValue("SQL_ST_ITEM_STORE_QTY_ON_HAND"),stParameters);
			
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
			
			
			HashMap hmRecord	= fetchRecord(getPoRepositoryValue("SQL_ST_ITEM_REQUEST_TYPE"),strParameters);
			
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
			default_uom = fetchRecord(getPoRepositoryValue("SQL_ST_REQUEST_UOM_DEFAULT"),chkdefaultParameters);
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
		
		result = fetchRecords(getPoRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters);
		return result;
	}
	public String getAuthorizeForRequest(String store_code)throws Exception{
		String result = "";
		try{
		String[] strParameters = new String[2];
		strParameters[0]	   = login_by_id;
		strParameters[1]	   = store_code;
		HashMap results = fetchRecord(getPoRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SPL_REQ_AUTHORIZE"),strParameters);
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
			
		base_uom = fetchRecord(getPoRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
		gen_uom_code = "";
		}
		
		if(base_uom.size() > 0){
			gen_uom_code = (String)base_uom.get("GEN_UOM_CODE");
			String chkdefaultParameters1[] = {gen_uom_code,getLanguageId()};
			base_uom = fetchRecord(getPoRepositoryValue("SQL_ST_UOM_SHORT_DESC_SELECT1"),chkdefaultParameters1);
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
		ArrayList allanguageData	=	new ArrayList();
		ArrayList alUpdateItemData = new ArrayList();
		ArrayList alDtlInsertRecord = null;
		STPORequestDetailBean requestDetailBean;

		hmResult.put("result", new Boolean(false));


		ArrayList alHdrInsertRecord = new ArrayList();
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(getDoc_type_code());
		alHdrInsertRecord.add(getDoc_no());
		alHdrInsertRecord.add(getDoc_date_value());
		alHdrInsertRecord.add(getDoc_ref());
		alHdrInsertRecord.add(""); //material_group_code
		alHdrInsertRecord.add(getItem_class_code());
		alHdrInsertRecord.add(getRequest_by_store());
		alHdrInsertRecord.add(getRequest_on_store());
		alHdrInsertRecord.add(getFinalize_yn().equals("Yes")?"FA":"UF");//CURR_STATUS
		alHdrInsertRecord.add(getHeaderRemarks());//CURR_STATUS_REMARKS
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);

		java.util.Collections.reverse(checkedItemKeys);

		try{
		int detailSize = checkedItemKeys.size();
		int no_of_decimals					=			getNoOfDecimals();
		
		alDtlInsertRecord = new ArrayList(detailSize);
		for (int index=0;index<detailSize;index++) {
		if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) 
		continue;
		requestDetailBean = (STPORequestDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
		
			ArrayList alDtlRecord = new ArrayList();
			alDtlRecord.add(login_facility_id);//FACILITY_ID
			alDtlRecord.add(getDoc_no());//DOC_NO
			alDtlRecord.add(""+(index+1));//DOC_SRL_NO

			if(getAllowDecimalsYN((String)requestDetailBean.getItem_code()).equals("N")){
			no_of_decimals = 0;
			}

			alDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
			alDtlRecord.add(setNumber((String)requestDetailBean.getReqUomQty(),no_of_decimals));//REQ_GEN_UOM_QTY -- Actual REQ_QTY
			alDtlRecord.add(requestDetailBean.getPurUomCode()); //req_uom
			alDtlRecord.add(requestDetailBean.getConvFact());//REQ_GEN_UOM_CONV_FACTOR
			alDtlRecord.add(setNumber((String)requestDetailBean.getRequired_qty(),no_of_decimals));//REQ_QTY  //REQ_GEN_UOM_QTY
			alDtlRecord.add(getFinalize_yn().equals("Yes")?"FA":"UF"); //REQ_ITEM_STATUS
			alDtlRecord.add(requestDetailBean.getRemarks());
			alDtlRecord.add(requestDetailBean.getRequired_by_date());//REQD_BY_DATE
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);

			alDtlInsertRecord.add(alDtlRecord);		

			double pending_qty = Double.parseDouble((String)requestDetailBean.getRequired_qty())/getConvFactTemp(requestDetailBean.getItem_code(),getRequest_by_store());
		
			java.util.ArrayList alUpdRecord = new java.util.ArrayList();
			alUpdRecord.add(setNumber(""+pending_qty,no_of_decimals));
			alUpdRecord.add(login_by_id);
			alUpdRecord.add(login_at_ws_no);
			alUpdRecord.add(login_facility_id);			  
			alUpdRecord.add(getRequest_by_store());
			alUpdRecord.add(requestDetailBean.getItem_code());
			alUpdateItemData.add(alUpdRecord);
			
		}
		}catch(Exception e){
			e.printStackTrace();			
		}
	
		allanguageData.add(getLanguageId());
	

		java.util.ArrayList alUpdateData = new java.util.ArrayList (3);
		alUpdateData.add(login_by_id);
		alUpdateData.add(login_at_ws_no);
		alUpdateData.add(login_facility_id);
	
		hmSQLMap.put("InsertHDRSQL", PoRepository.getPoKeyValue("SQL_PO_REQUEST_HEADER_INSERT")); 
		hmSQLMap.put("InsertDTLSQL", PoRepository.getPoKeyValue("SQL_PO_REQUEST_DETAIL_INSERT")); 	
		hmSQLMap.put("UpdateSQL", PoRepository.getPoKeyValue("SQL_UPDATE_NEXT_DOC_NO_IN_DOCNO_CONTROL_FOR_PR")); 
		hmSQLMap.put("SQL_PO_DOC_TYPE_SELECT_FLAG_FROM_CONTROL_TABLE",PoRepository.getPoKeyValue("SQL_PO_DOC_TYPE_SELECT_FLAG_FROM_CONTROL_TABLE"));

		
		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertHDRData",alHdrInsertRecord);
		hmTableData.put("InsertDTLData",alDtlInsertRecord);
		hmTableData.put("UpdateData",alUpdateData);
		hmTableData.put("LANGUAGE_DATA",	allanguageData);

			
		PORequisitionRemote requestRemote = null;
		try {
		
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PORequisition", PORequisitionHome.class,getLocalEJB());
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
		
			hmResult.put("message","Transaction failed") ;
			}
			

			System.out.println("hmResult===640==>"+hmResult);

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

		System.out.println("hashValues===setall=====672===>"+hashValues);

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
		setHeaderRemarks((String)hashValues.get("remarks"));
		java.util.Enumeration hashKeys = hashValues.keys();

		//itemKeysAdded=new ArrayList(); commented by ganga
		while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("add_itm_")) {
				selectedKey = (String) hashValues.get(keyCode);
				if (selectedKey != null && selectedKey.trim().length()>0) {
					
					//itemKeysAdded.add(selectedKey); commented by ganga
					checkedItemKeys.add(selectedKey);
				}
			}
		}
	}

		public java.util.ArrayList getOnStores(String req_by_store) throws Exception {
			ArrayList result		=	new ArrayList();
			String chkParameters[]  = {getLoginById()};
			result = fetchRecords(PoRepository.getPoKeyValue("SQL_ST_PO_PURCHASE_UNIT_LIST"),chkParameters);
			return result;
	}


	public void loadData(String doc_type_code, String doc_no) {
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		STPORequestDetailBean requestDetailBean;
        itemKeysAdded = new java.util.ArrayList();
		try {
            connection = getConnection();
            pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_REQUEST_HDR_SELECT1"));
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
				setRequest_on_store(resultSet.getString("pur_unit_code"));
				setItem_class_code(resultSet.getString("item_class_code"));
				setHeaderRemarks(resultSet.getString("req_remarks"));				
            }
			ArrayList al_doc_no = new ArrayList();
			al_doc_no.add(getDoc_no());

			setPrintDocNo(al_doc_no);


			closeResultSet(resultSet);
            closeStatement(pstmt);
			allItemKeys = new java.util.ArrayList();
            pstmt = connection.prepareStatement(PoRepository.getPoKeyValue("SQL_PO_REQUEST_DTL_SELECT"));          
            pstmt.setString(1, login_facility_id);
            pstmt.setString(2, doc_type_code);
            pstmt.setString(3, doc_no);
            pstmt.setString(4, getLanguageId());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				requestDetailBean = new STPORequestDetailBean(resultSet);				
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
		PORequisitionRemote requestRemote = null;


		int no_of_decimals					=			getNoOfDecimals();
		int no_of_decimals_temp				=			getNoOfDecimals();

		try
		{
		connection = getConnection();

		String key = (String) allItemKeys.get(allItemKeys.size()-1);
		STPORequestDetailBean requestDetailBean = (STPORequestDetailBean) hmItemDetail.get(key);
		requestDetailBean = null;											

		alModifyData.add(getDoc_date_value());
		alModifyData.add(getDoc_ref());
		alModifyData.add(getFinalize_yn().equals("Yes")?"FA":"UF");
		alModifyData.add(checkForNull(getHeaderRemarks()));
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id);
		alModifyData.add(login_facility_id);
		alModifyData.add(getDoc_no());

		hmTableData.put("UpdateData",alModifyData);
		hmSQLMap.put("UpdateSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQUEST_HEADER_UPDATE"));

		

		int detailSize = -1;
		alParams.add(getDoc_no());
		alParams.add(login_facility_id);

		int last_srl_no = Integer.parseInt((String)fetchRecord(getPoRepositoryValue("SQL_PO_REQUEST_DETAIL_MAX_SRL_NO"),alParams).get("LAST_SRL_NO"));

		if (itemKeysAdded != null && itemKeysAdded.size()>0) {
			detailSize		= itemKeysAdded.size();
			ArrayList alInsertRecord = new ArrayList(detailSize);
			for (int index=0;index<detailSize;index++) {
				if((itemKeysAdded.get(index) == null) || (itemKeysAdded.get(index).equals(""))) {
						continue;
				}

				requestDetailBean = (STPORequestDetailBean) hmItemDetail.get(itemKeysAdded.get(index));
				ArrayList alInsertDtlRecord = new ArrayList();


			if(getAllowDecimalsYN((String)requestDetailBean.getItem_code()).equals("N")){
			no_of_decimals = 0;
			}else{
			no_of_decimals=	no_of_decimals_temp;
			}
				alInsertDtlRecord.add(login_facility_id);//FACILITY_ID
				alInsertDtlRecord.add(getDoc_no());//DOC_NO
				if(requestDetailBean.getSrl_no()==-1)
				alInsertDtlRecord.add(""+(++last_srl_no));
				else
				alInsertDtlRecord.add(""+(requestDetailBean.getSrl_no()));
				alInsertDtlRecord.add(requestDetailBean.getItem_code());//ITEM_CODE
				alInsertDtlRecord.add(setNumber((String)requestDetailBean.getReqUomQty(),no_of_decimals));//REQ_QTY
				alInsertDtlRecord.add(requestDetailBean.getPurUomCode()); //req_uom
				alInsertDtlRecord.add(requestDetailBean.getConvFact());//REQ_GEN_UOM_CONV_FACTOR
				alInsertDtlRecord.add(setNumber((String)requestDetailBean.getRequired_qty(),no_of_decimals));//REQ_GEN_UOM_QTY
				alInsertDtlRecord.add(getFinalize_yn().equals("Yes")?"FA":"UF"); //REQ_ITEM_STATUS
				alInsertDtlRecord.add(checkForNull(requestDetailBean.getRemarks()));	//REQ_ITEM_REMARKS
				alInsertDtlRecord.add(checkForNull(requestDetailBean.getRequired_by_date())); //REQD_BY_DATE
				alInsertDtlRecord.add(login_by_id);
				alInsertDtlRecord.add(login_at_ws_no);
				alInsertDtlRecord.add(login_facility_id);
				alInsertDtlRecord.add(login_by_id);
				alInsertDtlRecord.add(login_at_ws_no);
				alInsertDtlRecord.add(login_facility_id);
				alInsertRecord.add(alInsertDtlRecord);	

				
			}
			hmTableData.put("InsertDTLData",alInsertRecord);
			hmSQLMap.put("InsertDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQUEST_DETAIL_INSERT"));
			checkedItemKeys.removeAll(itemKeysAdded);
		}

		detailSize = checkedItemKeys.size();

		requestDetailBean = null;
		ArrayList alUpdateRecord = new ArrayList(detailSize);
		for (int index=0;index<detailSize;index++) {
			if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) {
					continue;
			}
			requestDetailBean = (STPORequestDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
			ArrayList alUpdateDtlRecord = new ArrayList(10);


			if(getAllowDecimalsYN((String)requestDetailBean.getItem_code()).equals("N")){
			no_of_decimals = 0;
			}else{
			no_of_decimals=	no_of_decimals_temp;
			}
			//alUpdateDtlRecord.add(setNumber((String)requestDetailBean.getRequired_qty(),no_of_decimals));//REQ_QTY
			alUpdateDtlRecord.add(setNumber((String)requestDetailBean.getReqUomQty(),no_of_decimals));//REQ_QTY
			alUpdateDtlRecord.add(requestDetailBean.getPurUomCode());//req_uom
			alUpdateDtlRecord.add(requestDetailBean.getConvFact());//REQ_GEN_UOM_CONV_FACTOR
			//alUpdateDtlRecord.add(setNumber((String)requestDetailBean.getReqUomQty(),no_of_decimals));//REQ_GEN_UOM_QTY
			alUpdateDtlRecord.add(setNumber((String)requestDetailBean.getRequired_qty(),no_of_decimals));//REQ_GEN_UOM_QTY
			alUpdateDtlRecord.add(getFinalize_yn().equals("Yes")?"FA":"UF"); //REQ_ITEM_STATUS
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getRemarks()));	//REQ_ITEM_REMARKS
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getRequired_by_date())); //REQD_BY_DATE
			alUpdateDtlRecord.add(login_by_id);
			alUpdateDtlRecord.add(login_at_ws_no);
			alUpdateDtlRecord.add(login_facility_id);
			alUpdateDtlRecord.add(login_facility_id);
			alUpdateDtlRecord.add(getDoc_no());
			alUpdateDtlRecord.add(""+requestDetailBean.getSrl_no());
			alUpdateRecord.add(alUpdateDtlRecord);
			
		}
		hmTableData.put("UpdateDTLData",alUpdateRecord);
		hmSQLMap.put("UpdateDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQUEST_DETAIL_UPDATE"));

		detailSize = -1;
		if (allItemKeys != null && allItemKeys.size() > 0) {
			allItemKeys.removeAll(checkedItemKeys);
			if (allItemKeys.size() >0) {
				detailSize = allItemKeys.size();
				ArrayList alDeleteRecord = new ArrayList(detailSize);
				for (int index=0;index<detailSize;index++) {
					if((allItemKeys.get(index) == null) || (allItemKeys.get(index).equals(""))) 
							continue;
					requestDetailBean = (STPORequestDetailBean) hmItemDetail.get(allItemKeys.get(index));
					ArrayList alDeleteDtlRecord = new ArrayList(4);
					alDeleteDtlRecord.add(login_facility_id);
					alDeleteDtlRecord.add(getDoc_no());
					alDeleteDtlRecord.add(""+requestDetailBean.getSrl_no());
					alDeleteRecord.add(alDeleteDtlRecord);
				}
				hmTableData.put("DeleteDTLData",alDeleteRecord);
				hmSQLMap.put("DeleteDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQUEST_DETAIL_DELETE"));
			}
		}
		
		System.out.println("hmTableData====983===>"+hmTableData);
		System.out.println("hmSQLMap====983===>"+hmSQLMap);

		
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PORequisition",PORequisitionHome.class,getLocalEJB());
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
		alDeleteData.add(login_facility_id);
		alDeleteData.add(getDoc_no());								
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	
		
		hmTableData.put("properties",properties);
		hmTableData.put("DeleteHDRData",alDeleteData);
		hmTableData.put("DeleteDTLData",alDeleteData);
		hmSQLMap.put("DeleteHDRSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQUEST_HEADER_DELETE"));
		hmSQLMap.put("DeleteDTLSQL", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_REQUEST_DETAIL_DELETE1"));

	
		PORequisitionRemote requestRemote = null;
		try {
				
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/PORequisition",PORequisitionHome.class,getLocalEJB());
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
	
	
	public void setMasterType(String master_type) {
		 this.master_type = master_type;
	}
	
	public String getMasterType() {
        return master_type;
    }

	
	public String getPurchaseTypeList() {
		   ArrayList arr_language = new ArrayList();
		   arr_language.add(getMasterType());
		   arr_language.add(getLanguageId());
		   return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language),getDoc_type_code()); 
    }
	
	public String getPurchaseUnitList() {
		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		sqlParam.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_REQ"),sqlParam),getRequest_on_store()); 
		
	}

	public String getRequestByStoreList() {
		ArrayList alParameters =  new ArrayList();							
		alParameters.add(getLoginById());
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_USER_ACCESS_FOR_STORE_SELECT"),alParameters),getRequest_by_store()); 
	}

	public void setHeaderRemarks(String headerRemarks) {
		 this.headerRemarks = headerRemarks;
	}
	
	public String getHeaderRemarks() {
        return headerRemarks;
    }

	public String getUOMDesc(String uom_code) throws Exception {

		String uom	  = "";	
		HashMap default_uom			  = new HashMap();
		ArrayList alParameters =  new ArrayList();							
		
		try{

		alParameters.add(uom_code);
		alParameters.add(getLanguageId());

		default_uom = fetchRecord(getPoRepositoryValue("SQL_PO_UOM_DESC_SELECT"),alParameters);

		}catch(Exception e){
			uom = "";
		}
		
		if(default_uom.size() > 0)
			uom = (String)default_uom.get("SHORT_DESC");

		return uom;

	}

	public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{
			
			PgetStore_codepo  = getRequest_by_store() ;
           
			String reportid = "POBREQST";

		/*	HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","PO");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_finalized_yn",getFinalize_yn().substring(0,1));

			System.out.println("hmReportParameter"+hmReportParameter);

			
			
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());

			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codepo);
			System.out.println("hmParameters"+hmParameters);
		   new ePO.Common.ReportCallerThread(getURLString(hmParameters)).start();

		 */
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   	
				onlineReports 	= new ecis.utils.OnlineReports() ;
			//	report2= new ecis.utils.OnlineReport( login_facility_id, "PO", "POBREQST") ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "PO", reportid, "S", PgetStore_codepo) ;
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


}

