/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/* 
 ------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
20/04/2017	IN061750		Badmavathi B										ML-MMOH-CRF-0567	
22/05/2018	67677			Shazana 											ML-MMOH-SCF-1003	
10/10/2019  IN:071343       B Haribabu                                          GHL-CRF-0608	
13/10/2021	TFS-24348		Shazana		13/10/2021		Manickam				MO-CRF-20172
23/2/2022	TFS27891		Shazana										MO-CRF-20176	
13/7/2023   TFS-46322       hariharan                    Ramesh goil            COMMON-ICN-0310
-------------------------------------------------------------------------------------------------------------------------------
*/  
 package eST;
import eCommon.Common.*;
//import javax.ejb.EJBObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Collections;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import eST.Request.*;

//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
//import eCommon.Common.CommonRepository;
//import eCommon.Common.CommonEJBSessionInterface;
import eST.RequestDetailBean;
import eST.Common.StRepository;
//import eST.Common.StHeaderBean;
//import eST.Common.StAdapter;

//import eST.Request.RequestHome;
//import eST.Request.RequestRemote;
import javax.servlet.* ;
import javax.servlet.http.*;
/**
* @Name - Mahesh
* @Date - 12/01/2010
* @Inc# - IN015496
* @Desc - All Interger.parseInt for quantity is changed to Double.parseDouble and variable names are made double
*/

public class RequestBean extends eST.Common.StTransaction implements Serializable {	
	//private StHeaderBean stHeaderBean;
	private String doc_type_code;
	private String doc_no;
	private String doc_ref;
	private String doc_date;
	private String request_by_store;
	private String request_on_store;
	private String finalize_yn;
	private String item_class_code;
	private String entity_param;
	private String Pending_qty;
	private boolean isAutoNo;
	private String defaultDocType;
	private HashMap hmItemDetail;
	private ArrayList itemKeys;
	private ArrayList itemKeysDesc;
	private ArrayList checkedItemKeys;
	private ArrayList itemKeysAdded;
	private ArrayList itemKeysDescAdded;
	private ArrayList allItemKeys;
	private String item_class_desc;
	private String request_type;
//	private String language;
	private String togglePoint ="";
	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
  //  private String PgetTrnType = "";
	private ArrayList PDocNo ;
	public String reportserver = "";
	public String report_connect_string = "";
	//private ArrayList	kitDataList =new ArrayList();
	//public static int count = 0;
	private String hdrRemarks_desc = "";  //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013  
	private String hdrRemarks_code = ""; //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013  

	
	
	public RequestBean() {
		itemKeys = new java.util.ArrayList();
		itemKeysDesc = new java.util.ArrayList();
		checkedItemKeys = new java.util.ArrayList();
		hmItemDetail = new java.util.HashMap();
	}

/*	private javax.servlet.http.HttpServletRequest request;
	private javax.servlet.http.HttpServletResponse response;

	public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; 
		this.response=response	;
	}*/

/* public void setStHeaderBean()
	{
		this.StHeaderBean=StHeaderBean;
	}
	public Object getStHeaderBean() {
		return stHeaderBean;
	}
*/

/*	public void setLanguageId(String language)
	{
		this.language=language;
	}

	public String getLanguageId()
	{
		return language;
	}
*/
	
	/*For ordering based on Item Description Clicking*/
	public String getTogglePoint(){
		return this.togglePoint;
	}
	public void setTogglePoint(String toggle){
		this.togglePoint=toggle;
	}


	/*public int getCount(){
		return count++;
	}*/
	/*public ArrayList getKitDtlData(){
		return kitDataList;
	}*/
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
	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getPrintDocNo(){
		return PDocNo;
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
	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}
	public boolean getIsAutoNo() {
		return this.isAutoNo;
	}
	public ArrayList getItemKeys() {
		return this.itemKeys;
	}
	public java.util.HashMap getHmItemDetail() {
		return this.hmItemDetail;
	}

//added on 06/08/2004

	public void setHmItemDetail(HashMap hmItemDetail) {
		this.hmItemDetail = hmItemDetail;
	}


	public java.util.ArrayList getItemKeysAdded() {
		return this.itemKeysAdded;
	}

	
	public void setEntity_param(String entity_param) {
		this.entity_param = entity_param;
	}
	public String getEntity_param() {
		return this.entity_param;
	}
	
	//Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 Starts
	 public void setHdrRemarks_Desc(String hdrRemarks_desc) {
		 this.hdrRemarks_desc= checkForNull(hdrRemarks_desc);
	}
	public String getHdrRemarks_Desc() {
		 return hdrRemarks_desc;
	}
	public void setHdrRemarks_Code(String hdrRemarks_code) {
		 this.hdrRemarks_code= checkForNull(hdrRemarks_code);
	}
	public String getHdrRemarks_Code( ) {
		 return hdrRemarks_code;
	}
	//ends

	/* code for display UOM -- 24/06/2004 */

	public String getDefaultUOM(String item_code,String store_code) throws Exception {
		String chkdefaultParameters[] = {item_code,store_code};
		String default_value		  = "";	
		HashMap default_uom			  = new HashMap();
		try{
			default_uom = fetchRecord(getStRepositoryValue("SQL_ST_REQUEST_UOM_DEFAULT"),chkdefaultParameters);
		}catch(Exception e){
			default_value = "";
		}
		
		if(default_uom.size() > 0){
			default_value = (String)default_uom.get("DEF_REQUEST_UOM");
		}

		return default_value;

	}


	public ArrayList getPur_uom_code_List(String parameters,String item_code) throws Exception{
		String chkParameters[] = {parameters,getLanguageId(),parameters,getLanguageId(),parameters,getLanguageId(),item_code};
		ArrayList result = new ArrayList();
		
		result = fetchRecords(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters);
			return result;
	}

	public String getPur_uom_code_Modify_List(String parameters,String item_code,String def_uom) throws Exception{
			boolean select=false;
			String chkParameters[] = {parameters,getLanguageId(),parameters,getLanguageId(),parameters,getLanguageId(),item_code};
		 	return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters,select),def_uom);
		
	}

	
	/* code ends * /


	/* Default List value population methods*/
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}
	public String getDocTypeCodes() {
		return getDefaultDocumentTypeList("ISS",defaultDocType);
	}
	public String getRequestByStore() {
//modified by manish on Thursday, December 25, 2003.
//		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_REQ_BY_STORE_SELECT");
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_FROM_STORE_SELECT_FROMST_STORE");
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLoginById());
//		sqlParam.add(getAccEntityID());//Mahesh 6/2/2008
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_by_store());
	}
	public String getRequestOnStore() {
// Query Fine Tuned For PE 2 Rams 6/22/2010	
//String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_FROM_STORE_SELECT");
		String sql = "SELECT st.store_code,	mm.short_desc FROM st_user_access_for_store	st,	mm_store_lang_vw mm, sm_appl_user sm, st_store ststr WHERE  st.user_id =	? AND st.store_code = mm.store_code and st.store_code = ststr.store_code  AND st.user_id=sm.appl_user_id AND mm.eff_status = 'E' AND sm.eff_status='E' AND (st.req_allowed_yn='Y' and ststr.req_allowed_yn='Y') AND mm.facility_id	=? AND mm.language_id = ?  and EXISTS (select 'X' from st_store_parent_store where st.store_code=store_code) order by	2";
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLoginById());
		sqlParam.add(getLoginFacilityId());
//		sqlParam.add(getEntity_param());
		return getListValues(sql, sqlParam,getRequest_on_store());
	}
	public String getQRYRequestOnStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_QRY_ST_REQ_BY_STORE_SELECT");
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_on_store());
	}  	
	public String getItemClasses() {
		// Query Fine Tuned For PE 2 Rams 6/22/2010	
//		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		String sql = "SELECT   item_class_code, short_desc FROM mm_item_class_lang_vw WHERE eff_status = 'E' AND EXISTS  (SELECT 'X'  FROM st_item_class_store t WHERE store_code IN (?) AND t.item_class_code = item_class_code ) AND EXISTS (SELECT 'X' FROM st_item_class_store t WHERE store_code IN (?) AND t.item_class_code = item_class_code) AND language_id = ? ORDER BY 2";
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(request_by_store);
		sqlParam.add(request_on_store);
		return getListValues(sql, sqlParam,getItem_class_code());
	}
	public String getAllItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (1);
		sqlParam.add(getLanguageId());
		return getListValues(sql,sqlParam,"");
	}
	public void setPending_item_qty(String pending_item_qty) {
		this.Pending_qty=Pending_qty;
	}
	public String getPending_item_qty() {
		return this.Pending_qty;
	}			
	
	//code added for Request Type Values
	public void setRequestType(String request_type){
		this.request_type = request_type;
	}

	public String getRequestType(){
		return request_type;
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
	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
		String chkParameters[] = {request_by_store,request_on_store,getLanguageId()};
			ArrayList result = new ArrayList();
			//result = fetchRecords("SELECT stp.item_class_code, mm.short_desc FROM st_store_parent_store stp, mm_item_class_lang_vw mm WHERE mm.item_class_code = stp.item_class_code AND stp.store_code =? AND stp.parent_store_code =? AND stp.eff_status = 'E'  AND language_id =?",chkParameters);
			result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);

		 return result;
	}

	public void clear() {
		super.clear();
		//stHeaderBean=null;
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
		itemKeysDesc = null;
		itemKeysAdded = null;
		itemKeysDescAdded = null;
		checkedItemKeys =null;
		request_type	=null;
		togglePoint="";
		hdrRemarks_desc = "";  //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013  
	    hdrRemarks_code = ""; //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013  
	}

	public void initialize() {
		super.initialize();
		doc_type_code = "";
		doc_no = "";
		doc_ref = "";
		doc_date = "";
		request_by_store = "";
		request_on_store = "";
		defaultDocType = "";
		isAutoNo = false;
		hmItemDetail = new java.util.HashMap();
		itemKeys = new java.util.ArrayList();
		itemKeysDesc = new java.util.ArrayList();
		itemKeysAdded = new java.util.ArrayList();
		 itemKeysDescAdded = new java.util.ArrayList();
		checkedItemKeys = new java.util.ArrayList();
		//stHeaderBean=new StHeaderBean();
		//stHeaderBean.setProperties(getProperties());
		request_type = "";
		togglePoint = "";
		hdrRemarks_desc = "";  //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013  
	    hdrRemarks_code = ""; //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 
	}

	public java.util.HashMap addDetailRecord(java.util.Hashtable detailRecord) {
		
		java.util.HashMap hashResult = new java.util.HashMap(2);
		hashResult.put("result",new Boolean(false));
		try {
			java.util.HashMap recordCount;
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(detailRecord.get("request_by_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			//sqlParameter.add(getLanguageId());
			recordCount = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			String total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_BY_ITEM_STORE_NOT_FOUND");
				return hashResult;
			}
			sqlParameter.clear();
			// Validate REquest On Store
			sqlParameter.add(detailRecord.get("request_on_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			//sqlParameter.add(getLanguageId());
			recordCount = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_ON_ITEM_STORE_NOT_FOUND");
				return hashResult;
			}
		}
		catch (Exception exception) {
			hashResult.put("message",exception.getMessage());
			return hashResult;
		}																// Validations of store codes Over
		// Logic which adds the record 
		String item_code = (String) detailRecord.get("item_code");
		String editing = (String) detailRecord.get("editing");
		if (editing.equals("1") && (itemKeys.contains(item_code) || itemKeysAdded.contains(item_code))) {
			hashResult.put("message","ITEM_CODE_ALREADY_EXIST");
			return hashResult;
		}
		else if (editing.equals("1")) {
			itemKeys.add(item_code);
			itemKeysDesc.add(detailRecord.get("item_desc"));//priya
			
		}
		hmItemDetail.put(item_code, new RequestDetailBean(detailRecord));
		hashResult.put("result",new Boolean(true));
		hashResult.put("message","");
		return hashResult;
	}
	public java.util.HashMap addDetailRecord1(java.util.Hashtable detailRecord) {
		
		java.util.HashMap hashResult = new java.util.HashMap(2);
		hashResult.put("result",new Boolean(false));
		/*try {
			java.util.HashMap recordCount;
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(detailRecord.get("request_by_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			//sqlParameter.add(getLanguageId());
			recordCount = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			String total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_BY_ITEM_STORE_NOT_FOUND");
				return hashResult;
			}
			sqlParameter.clear();
			// Validate REquest On Store
			sqlParameter.add(detailRecord.get("request_on_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			//sqlParameter.add(getLanguageId());
			recordCount = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_ON_ITEM_STORE_NOT_FOUND");
				return hashResult;
			}
		}
		catch (Exception exception) {
			hashResult.put("message",exception.getMessage());
			return hashResult;
		}*/																// Validations of store codes Over
		// Logic which adds the record 
		String item_code = (String) detailRecord.get("item_code");
		String editing = (String) detailRecord.get("editing");
		if (editing.equals("1") && (itemKeys.contains(item_code) || itemKeysAdded.contains(item_code))) {
			hashResult.put("message","ITEM_CODE_ALREADY_EXIST");
			return hashResult;
		}
		else if (editing.equals("1")) {
			itemKeys.add(item_code);
			itemKeysDesc.add(detailRecord.get("item_desc"));//priya
		}
		hmItemDetail.put(item_code, new RequestDetailBean(detailRecord));
		System.out.println("hmItemDetail====509===>" +hmItemDetail);
		hashResult.put("result",new Boolean(true));
		hashResult.put("message","");
		return hashResult;
	}



	public java.util.HashMap addDetailRecordModifyMode(java.util.Hashtable detailRecord) {
		java.util.HashMap hashResult = new java.util.HashMap(2);
		hashResult.put("result",new Boolean(false));
		try {
			java.util.HashMap recordCount;
			java.util.ArrayList sqlParameter = new java.util.ArrayList();
			sqlParameter.add(detailRecord.get("request_by_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			//sqlParameter.add(getLanguageId());
			recordCount = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			String total = (String)recordCount.get("COUNT");
		
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_BY_ITEM_STORE_NOT_FOUND");
			//	return hashResult;  /* commment for kit templete crf683
			}
			sqlParameter.clear();
			// Validate request on store combination
			sqlParameter.add(detailRecord.get("request_on_store"));
			sqlParameter.add(detailRecord.get("item_code"));
			//sqlParameter.add(getLanguageId());
			recordCount = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_COUNT"),sqlParameter);
			total = (String)recordCount.get("COUNT");
			if (Integer.parseInt(total) <= 0) {
				hashResult.put("message","REQ_ON_ITEM_STORE_NOT_FOUND");
			//	return hashResult; /* commment for kit templete crf683 
			}
			String item_code = (String) detailRecord.get("item_code");
			String editing = (String) detailRecord.get("editing");
			if (editing.equals("1") && (itemKeys.contains(item_code) || itemKeysAdded.contains(item_code))) {
				hashResult.put("message","ITEM_CODE_ALREADY_EXIST");
				return hashResult;
			}
			itemKeysAdded.add(item_code);
			itemKeysDescAdded.add(detailRecord.get("item_desc"));//priya
			hmItemDetail.put(item_code, new RequestDetailBean(detailRecord));
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
	private String getDefaultDocumentTypeList(String trn_type, String defaultValue) {
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}
	
	public RequestDetailBean getItemDetail(String item_code) {
		return (RequestDetailBean) hmItemDetail.get(item_code);
	}

	public HashMap validate() {
		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			try {
				int docDateValidation = isValidDocDate(getDoc_date_value());
				if (docDateValidation == 1) {
					resultMap.put("result", new Boolean(false));
					//resultMap.put("message", "ST_DOC_DT_NOT_LT_PROC_MTH");
					resultMap.put("message", getSTMessage(getLanguageId(),"ST_DOC_DT_NOT_LT_PROC_MTH","ST"));
				}
				 
				  else if (docDateValidation == 2) {
					resultMap.put("result", new Boolean(false));
					//resultMap.put("message", "ST_DOC_DT_NOT_GR_SYSDATE");
					resultMap.put("message", getSTMessage(getLanguageId(),"ST_DOC_DT_NOT_GR_SYSDATE","ST"));
				}  
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return resultMap;
	}

	public void setAll(Hashtable hashValues) {
		String keyCode;
		String selectedKey;
        checkedItemKeys.clear();
		ArrayList alitems_sort = new ArrayList();
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))) {
			setDoc_type_code((String)hashValues.get("doc_type_code"));
			setDoc_no((String)hashValues.get("doc_no"));
			setDoc_date((String)hashValues.get("doc_date"));
			return;
		}
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
		itemKeysDescAdded=new ArrayList();
		/*while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("add_itm_")) {
				selectedKey = (String) hashValues.get(keyCode);
				if (selectedKey != null && selectedKey.trim().length()>0) {
					
					itemKeysAdded.add(selectedKey);
					itemKeysDescAdded.add(hashValues.get("item_desc"));//priya
					checkedItemKeys.add(selectedKey);
				}
			}
		}*/
		  while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("add_itm_")) {
			    alitems_sort.add(keyCode);
				java.util.Collections.sort(alitems_sort); 
			}
		}
		//Added by rabbani For Ordering of items on 05-JUN-2013 Starts
		         for(int i = 0; i< alitems_sort.size();i++){
		         selectedKey = (String) hashValues.get("add_itm_"+i);
				 if (selectedKey != null && selectedKey.trim().length()>0) {
					itemKeysAdded.add(selectedKey);
					itemKeysDescAdded.add(hashValues.get("item_desc"));//priya
					checkedItemKeys.add(selectedKey);
				 }
				}
				//ends
	}

	public void loadData(String doc_type_code, String doc_no) {
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		RequestDetailBean requestDetailBean;
        itemKeysAdded = new java.util.ArrayList();
		try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REQUEST_HDR_SELECT"));
			pstmt.setString(1, getLanguageId()); //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013
            pstmt.setString(2, login_facility_id);
            pstmt.setString(3, doc_type_code);
            pstmt.setString(4, doc_no);
			
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				setDoc_type_code(resultSet.getString("doc_type_code"));
				setDoc_no(resultSet.getString("doc_no"));

				setDoc_date(resultSet.getString(4));
				setDoc_ref(resultSet.getString("doc_ref"));
				setRequest_by_store(resultSet.getString("req_by_store_code"));
				setRequest_on_store(resultSet.getString("req_on_store_code"));
				setItem_class_code(resultSet.getString("item_class_code"));
				setRequestType(resultSet.getString("REQUEST_TYPE"));
				//Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013 Starts
				setHdrRemarks_Desc(checkForNull((String)resultSet.getString("REMARKS")));  
			    setHdrRemarks_Code(checkForNull((String)resultSet.getString("REMARKS_CODE")));
               //ends	
            }
			// Load Detail Data
		//	pstmt = null;
		//	resultSet = null;
				closeResultSet(resultSet);
                closeStatement(pstmt);
			allItemKeys = new java.util.ArrayList();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_SELECT"));
            pstmt.setString(1, login_facility_id);
            pstmt.setString(2, doc_type_code);
            pstmt.setString(3, doc_no);
            pstmt.setString(4, getLanguageId());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				requestDetailBean = new RequestDetailBean(resultSet);

				itemKeys.add(requestDetailBean.getItem_code());
				itemKeysDesc.add(requestDetailBean.getItem_desc());//priya
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

	public java.util.HashMap insert() {
		HashMap hmResult = new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
//		ArrayList alInsertData = new ArrayList();
		RequestDetailBean requestDetailBean;
		ArrayList allanguageData	=	new ArrayList();
		hmResult.put("result", new Boolean(false));
	/*	try {
			if (isAutoNo) {
				String next_doc_no = super.fetchNextDocNo(getDoc_type_code());
				setDoc_no(next_doc_no);
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}*/
		java.util.ArrayList alUpdateItemData = new java.util.ArrayList ();
		//ArrayList alHdrInsertRecord = new ArrayList(18);
		ArrayList alHdrInsertRecord = new ArrayList(19);//Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(getDoc_type_code());
		alHdrInsertRecord.add(getDoc_no());
		alHdrInsertRecord.add(getDoc_date_value());
		alHdrInsertRecord.add(getDoc_ref());
		alHdrInsertRecord.add(getItem_class_code());
			
		alHdrInsertRecord.add(getFinalize_yn().equals("Yes")?"W":"E");
		alHdrInsertRecord.add(getRequest_by_store());
		alHdrInsertRecord.add(getRequest_on_store());
		alHdrInsertRecord.add(login_by_id);
		
		alHdrInsertRecord.add(getFinalize_yn().equals("Yes")?login_by_id:"");
		alHdrInsertRecord.add("ISS");
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		//code added for Request Type
		alHdrInsertRecord.add(getRequestType());
		alHdrInsertRecord.add(checkForNull(getHdrRemarks_Code())); //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/02/2013
		allanguageData.add(getLanguageId());
		
		//java.util.Collections.reverse(checkedItemKeys); //18/09/12
	
		int detailSize = checkedItemKeys.size();
		ArrayList alDtlInsertRecord = new ArrayList(detailSize);
		for (int index=0;index<detailSize;index++) {
			if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))){ 
					continue;
			}
			requestDetailBean = (RequestDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
			ArrayList alDtlRecord = new ArrayList(14);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(getDoc_type_code());
			alDtlRecord.add(getDoc_no());
			alDtlRecord.add(""+(index+1));
			alDtlRecord.add(requestDetailBean.getItem_code());
			alDtlRecord.add(requestDetailBean.getRequired_qty());
			alDtlRecord.add(requestDetailBean.getStock_item_yn());
			alDtlRecord.add("0"); // committed_qty
			double pending_qty = Double.parseDouble((String)requestDetailBean.getRequired_qty())/getConvFactTemp1(requestDetailBean.getItem_code(),getRequest_by_store());
			alDtlRecord.add(""+pending_qty);
//			alDtlRecord.add(requestDetailBean.getRequired_qty());
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);

			//code added onm 24/06/2004
			alDtlRecord.add(requestDetailBean.getPurUomCode());
			alDtlRecord.add(requestDetailBean.getConvFact());
			alDtlRecord.add(requestDetailBean.getReqUomQty());
			alDtlRecord.add("");
			alDtlRecord.add(checkForNull(requestDetailBean.getUsagetype())); //18/09/12
			alDtlInsertRecord.add(alDtlRecord);	
System.out.println("alDtlInsertRecord====bean=>" +alDtlInsertRecord);			
//			if (getFinalize_yn().equals("Yes")) {
				java.util.ArrayList alUpdRecord = new java.util.ArrayList();
//				int pending_qty = Integer.parseInt((String)requestDetailBean.getRequired_qty())/getConvFactTemp(requestDetailBean.getItem_code(),getRequest_by_store());
				alUpdRecord.add(""+pending_qty);
//				alUpdRecord.add(requestDetailBean.getRequired_qty());
				alUpdRecord.add(login_by_id);
				alUpdRecord.add(login_at_ws_no);
				alUpdRecord.add(login_facility_id);			  
				/* The pending req qty has to be updated for the request_by_store */
				//alUpdRecord.add(getRequest_on_store());	  
				alUpdRecord.add(getRequest_by_store());
				alUpdRecord.add(requestDetailBean.getItem_code());
				alUpdateItemData.add(alUpdRecord);
//			}
		}
		java.util.ArrayList alUpdateData = new java.util.ArrayList (4);
		//java.util.ArrayList alHeaderList	=	 stHeaderBean.toArrayListOBS();
		alUpdateData.add(login_by_id);
		alUpdateData.add(login_at_ws_no);
		alUpdateData.add(login_facility_id);
		alUpdateData.add(getDoc_type_code());	
		hmSQLMap.put("InsertHDRSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_HDR_INSERT")); 
		hmSQLMap.put("InsertDTLSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_INSERT")); 
		hmSQLMap.put("UpdateSQL", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")); 
		hmSQLMap.put("sql_st_records_per_trn_select", StRepository.getStKeyValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_select", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_select_flag", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
		hmSQLMap.put("sql_st_store_records_per_trn_select", "SELECT RECORDS_PER_TRN_ISS FROM ST_STORE WHERE STORE_CODE=?");//MO-CRF-20176 


		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertHDRData",alHdrInsertRecord);
		hmTableData.put("InsertDTLData",alDtlInsertRecord);
		hmTableData.put("UpdateData",alUpdateData);
		hmTableData.put("LANGUAGE_DATA",	allanguageData);
		hmTableData.put("REQUEST_ON_STORE", getRequest_on_store());  //MO-CRF-20176 
		
		//if (getFinalize_yn().equals("Yes")) {
			hmSQLMap.put("UpdateITMSQL", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_PENDING_UPDATE")); 
			hmTableData.put("UpdateITMData",alUpdateItemData);
		//}
	//	RequestHome requestHome = null;
		RequestRemote requestRemote = null;
		if((getItemClassBased("ISS").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
			hmTableData = (HashMap)modifiedTableData(hmTableData,"ISS");
		}
		try {
			/*InitialContext context = new InitialContext();
			Object object = context.lookup(StRepository.getStKeyValue("JNDI_ST_REQUEST"));
			requestHome  = (RequestHome) PortableRemoteObject.narrow(object, RequestHome.class);
			requestRemote = requestHome.create();
			hmResult = requestRemote.insert(hmTableData, hmSQLMap);*/
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(StRepository.getStKeyValue("JNDI_ST_REQUEST"), RequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			//String s = getSTMessage(getLanguageId(), "DOC_NO", "ST") ;
			
			//String s1=s+":  "+getDoc_no();


			hmResult.put("message",getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			//hmResult.put("flag",s1 ) ;
		}
		catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		finally {
			try {
				if(requestRemote != null){
					requestRemote.remove();
				}
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString());
			}
		}


		/* SEND TO PRINT ONLINE REPORT STARTS*/		
			
			ArrayList doc_no	=	(ArrayList)hmResult.get("doc_no") ; 

			String alertRqdYN = "";
			setPrintDocNo(doc_no);

			PgetDoc_type_code = getDoc_type_code() ;
			PgetStore_codest  = getRequest_by_store() ;

			ArrayList params  = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());

			try{			
				alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			

//		if (getFinalize_yn().substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) 
		if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) 
			if (isInternalRequest("ST","STBREQDC")&& isDocTypePrintAllowed(PgetDoc_type_code)) {
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
		return hmResult;
	}

	public java.util.HashMap modify() {
		HashMap hmResult	=	new HashMap();
		ArrayList<String> alParam = new ArrayList<String>();
		int doc_count = 0;
		ArrayList allanguageData	=	new ArrayList();
		try{
			alParam.add(login_facility_id);
			alParam.add(getDoc_type_code());
			alParam.add(getDoc_no());
			doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_REQUEST_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND REQUEST_STATUS <> 'E'",alParam)).get("COUNT"));
		}catch(Exception e){
			hmResult.put("result",false);
			hmResult.put("msgid","OPER_CANCELLED");
			hmResult.put("message",getSTMessage(getLanguageId(),"OPER_CANCELLED","ST"));
			e.printStackTrace();
			return hmResult;
		}
		if(doc_count>0){
			hmResult.put("result",false);
			hmResult.put("msgid","ST_DOC_NO_FINALIZED_USER");
			hmResult.put("message",getSTMessage(getLanguageId(),"ST_DOC_NO_FINALIZED_USER","ST"));
			return hmResult;
		}
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
//		RequestHome requestHome = null;
		RequestRemote requestRemote = null;
		try
		{
		connection = getConnection();

		//Get the maximum serial no
		java.util.ArrayList alUpdateItemData = new java.util.ArrayList ();
		String key = (String) allItemKeys.get(allItemKeys.size()-1);
		RequestDetailBean requestDetailBean = (RequestDetailBean) hmItemDetail.get(key);
		int max_serial_no = requestDetailBean.getSrl_no();
		requestDetailBean = null;
		
		//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record
		ArrayList alHdrInsertRecord = new ArrayList(19);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(getDoc_type_code());
		alHdrInsertRecord.add(getDoc_no());
		alHdrInsertRecord.add(getDoc_date_value());
		alHdrInsertRecord.add(getDoc_ref());
		alHdrInsertRecord.add(checkForNull(getItem_class_code()));
			
		alHdrInsertRecord.add(getFinalize_yn().equals("Yes")?"W":"E");
		alHdrInsertRecord.add(getRequest_by_store());
		alHdrInsertRecord.add(getRequest_on_store());
		alHdrInsertRecord.add(login_by_id);
		
		alHdrInsertRecord.add(getFinalize_yn().equals("Yes")?login_by_id:"");
		alHdrInsertRecord.add("ISS");
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(getRequestType());
		alHdrInsertRecord.add(checkForNull(getHdrRemarks_Code()));
		//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record ends

		alModifyData.add(getDoc_date_value());
		alModifyData.add(getDoc_ref());
		alModifyData.add(getFinalize_yn().equals("Yes")?login_by_id:"");
		alModifyData.add(getFinalize_yn().equals("Yes")?"W":"E");
		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id);
		alModifyData.add(checkForNull(getHdrRemarks_Code())); //Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/FEB/2013
		alModifyData.add(login_facility_id);
		alModifyData.add(getDoc_type_code());
		alModifyData.add(getDoc_no());
		hmTableData.put("UpdateData",alModifyData);
		hmSQLMap.put("UpdateSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_HDR_UPDATE"));
		
		allanguageData.add(getLanguageId());

		

		int detailSize = -1;
		alParams.add(getDoc_no());
		alParams.add(login_facility_id);
		alParams.add(getDoc_type_code());
		//int detailSizeTemp = Integer.parseInt((String)fetchRecord("SELECT COUNT(*) COUNT FROM ST_REQUEST_DTL WHERE DOC_NO =? AND FACILITY_ID=? AND DOC_TYPE_CODE = ?",alParams).get("COUNT"));
//added by manish on Sunday, February 01, 2004 1:14:58 AM		
		max_serial_no=0;
//ends
         //java.util.Collections.reverse(itemKeysAdded); // added by rabbani # inc no:34905 on 20/09/12
		if (itemKeysAdded != null && itemKeysAdded.size()>0) {
			detailSize		= itemKeysAdded.size();
			ArrayList alInsertRecord = new ArrayList(detailSize);
			for (int index=0;index<detailSize;index++) {
				if((itemKeysAdded.get(index) == null) || (itemKeysAdded.get(index).equals(""))) {
						continue;
				}
				requestDetailBean = (RequestDetailBean) hmItemDetail.get(itemKeysAdded.get(index));
				ArrayList alInsertDtlRecord = new ArrayList(14);
				alInsertDtlRecord.add(login_facility_id);
				alInsertDtlRecord.add(getDoc_type_code());
				alInsertDtlRecord.add(getDoc_no());
				alInsertDtlRecord.add(""+(++max_serial_no));
							
//Commented By Mahesh on 3/13/2008 regarding doc_srl_no issue....
			//	if(requestDetailBean.getSrl_no()==-1){
				//	alInsertDtlRecord.add(""+(++detailSizeTemp));
			//	}else{
			//		alInsertDtlRecord.add(""+(requestDetailBean.getSrl_no()));
			//	}
				alInsertDtlRecord.add(requestDetailBean.getItem_code());
				alInsertDtlRecord.add(requestDetailBean.getRequired_qty());
				alInsertDtlRecord.add(requestDetailBean.getStock_item_yn());
				alInsertDtlRecord.add("0");//Committed Quantity
				double pending_qty = Double.parseDouble((String)requestDetailBean.getRequired_qty())/getConvFactTemp1(requestDetailBean.getItem_code(),getRequest_by_store());
				alInsertDtlRecord.add(""+pending_qty);
//				alInsertDtlRecord.add(requestDetailBean.getRequired_qty());
				alInsertDtlRecord.add(login_by_id);
				alInsertDtlRecord.add(login_at_ws_no);
				alInsertDtlRecord.add(login_facility_id);
				alInsertDtlRecord.add(login_by_id);
				alInsertDtlRecord.add(login_at_ws_no);
				alInsertDtlRecord.add(login_facility_id);
				//code added on 24/06/2004..
				alInsertDtlRecord.add(requestDetailBean.getPurUomCode());
				alInsertDtlRecord.add(requestDetailBean.getConvFact());
				alInsertDtlRecord.add(requestDetailBean.getReqUomQty());
				alInsertDtlRecord.add("");
				alInsertDtlRecord.add(checkForNull(requestDetailBean.getUsagetype())); //18/09/12
				
				//ended...
				alInsertRecord.add(alInsertDtlRecord);
				System.out.println("alInsertRecord==1022==>" +alInsertRecord);
/*				if (getFinalize_yn().equals("Yes")) {
					java.util.ArrayList alUpdRecord = new java.util.ArrayList();
					alUpdRecord.add(requestDetailBean.getRequired_qty());
					alUpdRecord.add(login_by_id);
					alUpdRecord.add(login_at_ws_no);
					alUpdRecord.add(login_facility_id);
					alUpdRecord.add(getRequest_by_store());
					alUpdRecord.add(requestDetailBean.getItem_code());
					alUpdateItemData.add(alUpdRecord);
//				}
*/			
/////////////////////////////////////


	//			try {
	//				connection = getConnection();
					pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_STORE_PENDING_SELECT"));
					String old_pending_item_qty = "";
					double req_qty=Double.parseDouble(requestDetailBean.getRequired_qty())/getConvFactTemp(requestDetailBean.getItem_code(),getRequest_by_store());
					pstmt.setString(1, login_facility_id);
					pstmt.setString(2, getDoc_type_code());
					pstmt.setString(3, getDoc_no());
					pstmt.setString(4, ""+requestDetailBean.getSrl_no());
					resultSet = pstmt.executeQuery();
					while (resultSet != null && resultSet.next()) {
						old_pending_item_qty = resultSet.getString("pending_item_qty");
						if(old_pending_item_qty != null) {
							double i_pending_item_qty = Double.parseDouble(old_pending_item_qty);
							old_pending_item_qty = ""+(-(i_pending_item_qty-req_qty));
							ArrayList alUpdRecord=new ArrayList();
							alUpdRecord.add(old_pending_item_qty);
							alUpdRecord.add(login_by_id);
							alUpdRecord.add(login_at_ws_no);
							alUpdRecord.add(login_facility_id);
					 		alUpdRecord.add(getRequest_by_store());
							alUpdRecord.add(requestDetailBean.getItem_code());
					alUpdateItemData.add(alUpdRecord);
//							old_pending_item_qty = ""+(-(i_pending_item_qty));
						}
					}
				closeResultSet(resultSet);
                closeStatement(pstmt);
					//alUpdRecord.add(old_pending_item_qty);
//				}
//				catch (Exception ex) {
//					ex.printStackTrace();
//				}
			}
			hmTableData.put("InsertDTLData",alInsertRecord);
			hmSQLMap.put("InsertDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_INSERT"));
			checkedItemKeys.removeAll(itemKeysAdded);
		}
		detailSize = checkedItemKeys.size();
		requestDetailBean = null;
		ArrayList alUpdateRecord = new ArrayList(detailSize);
		for (int index=0;index<detailSize;index++) {
			if((checkedItemKeys.get(index) == null) || (checkedItemKeys.get(index).equals(""))) {
					continue;
			}
			requestDetailBean = (RequestDetailBean) hmItemDetail.get(checkedItemKeys.get(index));
			ArrayList alUpdateDtlRecord = new ArrayList(10);
			alUpdateDtlRecord.add(requestDetailBean.getRequired_qty());
			double pending_qty = Double.parseDouble((String)requestDetailBean.getRequired_qty())/getConvFactTemp1(requestDetailBean.getItem_code(),getRequest_by_store());
			alUpdateDtlRecord.add(""+pending_qty);
//			alUpdateDtlRecord.add(requestDetailBean.getRequired_qty());
			alUpdateDtlRecord.add(requestDetailBean.getStock_item_yn());
			alUpdateDtlRecord.add(login_by_id);
			alUpdateDtlRecord.add(login_at_ws_no);
			alUpdateDtlRecord.add(login_facility_id);
			// code added on 24/06/2004
			alUpdateDtlRecord.add(requestDetailBean.getPurUomCode());
			alUpdateDtlRecord.add(requestDetailBean.getConvFact());
			alUpdateDtlRecord.add(requestDetailBean.getReqUomQty());
			alUpdateDtlRecord.add(checkForNull(requestDetailBean.getUsagetype())); //18/09/12
			
			// ended...

			alUpdateDtlRecord.add(login_facility_id);
			alUpdateDtlRecord.add(getDoc_type_code());
			alUpdateDtlRecord.add(getDoc_no());
			alUpdateDtlRecord.add(""+requestDetailBean.getSrl_no());
			alUpdateRecord.add(alUpdateDtlRecord);
			System.out.println("alUpdateRecord======>" +alUpdateRecord);
//1			if (getFinalize_yn().equals("Yes")) {
				java.util.ArrayList alUpdRecord = new java.util.ArrayList();
				
		 		// The pending req qty has to be updated for the request_by_store 	
				//alUpdRecord.add(getRequest_on_store());

				/**
				* Logic to get the previous value for the pending_request_qty
				*/
//				try {
//					connection = getConnection();
					pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_STORE_PENDING_SELECT"));
					String old_pending_item_qty = "";
					double req_qty=Double.parseDouble(requestDetailBean.getRequired_qty())/getConvFactTemp(requestDetailBean.getItem_code(),getRequest_by_store());
					pstmt.setString(1, login_facility_id);
					pstmt.setString(2, getDoc_type_code());
					pstmt.setString(3, getDoc_no());
					pstmt.setString(4, ""+requestDetailBean.getSrl_no());
					resultSet = pstmt.executeQuery();
					while (resultSet != null && resultSet.next()) {
						old_pending_item_qty = resultSet.getString("pending_item_qty");
						if(old_pending_item_qty != null) {
							double i_pending_item_qty = Double.parseDouble(old_pending_item_qty);
							old_pending_item_qty = ""+(-(i_pending_item_qty-req_qty));
							alUpdRecord.add(old_pending_item_qty);
							alUpdRecord.add(login_by_id);
							alUpdRecord.add(login_at_ws_no);
							alUpdRecord.add(login_facility_id);
					 		alUpdRecord.add(getRequest_by_store());
							alUpdRecord.add(requestDetailBean.getItem_code());
					alUpdateItemData.add(alUpdRecord);
//							old_pending_item_qty = ""+(-(i_pending_item_qty));
						}
					}
					closeResultSet(resultSet);
                closeStatement(pstmt);
					//alUpdRecord.add(old_pending_item_qty);
//				}
//				catch (Exception ex) {
//					ex.printStackTrace();
//				}
//			}
		}
		hmTableData.put("UpdateDTLData",alUpdateRecord);
		hmSQLMap.put("UpdateDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_UPDATE"));

		
//		if (getFinalize_yn().equals("Yes")) {
			hmSQLMap.put("UpdateITMSQL", StRepository.getStKeyValue("SQL_ST_ITEM_STORE_PENDING_UPDATE")); 
			hmTableData.put("UpdateITMData",alUpdateItemData); 
//		}
		detailSize = -1;
		if (allItemKeys != null && allItemKeys.size() > 0) {
			allItemKeys.removeAll(checkedItemKeys);
			if (allItemKeys.size() >0) {
				detailSize = allItemKeys.size();
				ArrayList alDeleteRecord = new ArrayList(detailSize);
				for (int index=0;index<detailSize;index++) {
					if((allItemKeys.get(index) == null) || (allItemKeys.get(index).equals(""))) 
							continue;
					requestDetailBean = (RequestDetailBean) hmItemDetail.get(allItemKeys.get(index));
					ArrayList alDeleteDtlRecord = new ArrayList(4);
					alDeleteDtlRecord.add(login_facility_id);
					alDeleteDtlRecord.add(getDoc_type_code());
					alDeleteDtlRecord.add(getDoc_no());
					alDeleteDtlRecord.add(""+requestDetailBean.getSrl_no());
					alDeleteRecord.add(alDeleteDtlRecord);
				}
				hmTableData.put("DeleteDTLData",alDeleteRecord);
				hmSQLMap.put("DeleteDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_SINGLE_DELETE"));

				
			}
		}

		hmTableData.put("InsertHDRData",alHdrInsertRecord);//Added here from down for ML-BRU-SCF-1805
		//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record
		if((getItemClassBased("ISS").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
			hmTableData = (HashMap)modifiedTableData(hmTableData,"ISS");
		}
		
		ArrayList alUpdateData = new ArrayList (4);
		//java.util.ArrayList alHeaderList	=	 stHeaderBean.toArrayListOBS();
		alUpdateData.add(login_by_id);
		alUpdateData.add(login_at_ws_no);
		alUpdateData.add(login_facility_id);
		alUpdateData.add(getDoc_type_code());	
		
		hmTableData.put("Sy_UpdateData",alUpdateData);
		hmTableData.put("LANGUAGE_DATA",	allanguageData);
		hmTableData.put("REQUEST_ON_STORE",	getRequest_on_store());//MO-CRF-20176   
		//hmTableData.put("InsertHDRData",alHdrInsertRecord);//Commented here and added above for ML-BRU-SCF-1805
		hmSQLMap.put("InsertHDRSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_HDR_INSERT")); 
		hmSQLMap.put("sql_st_records_per_trn_select", StRepository.getStKeyValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_select", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
		hmSQLMap.put("sql_sy_acc_entity_doc_type_select_flag", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
		hmSQLMap.put("sql_sy_UpdateSQL", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")); 
		hmSQLMap.put("sql_st_store_records_per_trn_select", "SELECT RECORDS_PER_TRN_ISS FROM ST_STORE WHERE STORE_CODE=?");//MO-CRF-20176 
		//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record ends

//		try {
			/*InitialContext context = new InitialContext();
			Object object = context.lookup(StRepository.getStKeyValue("JNDI_ST_REQUEST"));
			requestHome  = (RequestHome) PortableRemoteObject.narrow(object, RequestHome.class);
			requestRemote = requestHome.create();

			hmResult = requestRemote.modify(hmTableData, hmSQLMap) ;*/
		
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(StRepository.getStKeyValue("JNDI_ST_REQUEST"),RequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;
	System.out.println("hmTableData==>"+hmTableData);
			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			hmResult.put("message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;

			/*hmResult = new eST.RequestTemp.RequestManager().modify( hmTableData, hmSQLMap);
			hmResult.put("message", getMessage((String) hmResult.get("message"))) ;*/
		} 
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString()) ;
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(requestRemote != null){
					requestRemote.remove() ;
				}
				closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
			}
			catch(Exception ee) {
				ee.printStackTrace();
				hmResult.put("message", ee.toString()) ;
			}
		}
			//java.util.ArrayList alHeaderList	=	 stHeaderBean.toArrayListOBS();
			ArrayList doc_no	=	new ArrayList();	//doc_no
			
			doc_no.add(getDoc_no());
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest =  getRequest_by_store();
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
		
			//alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			try
			{
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			}catch(Exception E){
				E.printStackTrace();
			}
		
//			if (getFinalize_yn().substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (isInternalRequest("ST","STBREQDC")&& isDocTypePrintAllowed(PgetDoc_type_code)) {
					if(alertRqdYN.equals("Y")){	
						hmResult.put("flag",hmResult.get("flag") + "~PY");
					}else{
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
		return hmResult;
}

	public boolean DocTypePrintAllowed (String PgetDoc_type_code){
		if (isDocTypePrintAllowed(PgetDoc_type_code)){ 
			return true;
		}else{
			return false;
		}
	}

	/*public void doOnlineReportPrinting(String doc_no) {
		try{
           
			String reportid = "STBREQDC";

			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code", PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_finalized_yn",getFinalize_yn().substring(0,1));

		
			if (!isDocTypePrintAllowed(PgetDoc_type_code)){ return;}
 
           

         //   javax.servlet.http.HttpSession session = request.getSession(false);
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
			//hmParameters.put("p_language_id",getLanguageId());
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
				report2.addParameter("p_finalized_yn",getFinalize_yn().substring(0,1));
				//report2.addParameter("copies",checkForNull(copies,"1"));
				onlineReports.add( report2) ;

				if (!isDocTypePrintAllowed(PgetDoc_type_code)){ return;}

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
//
		//ArrayList alUpdateItemData = new ArrayList ();
		//ArrayList alUpdRecord = new ArrayList ();
		Connection connection = null;
        PreparedStatement pstmt = null;
        PreparedStatement pstmt1 = null;
        ResultSet resultSet = null;
       // ResultSet resultSet1 = null;
///

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Delete Mode") ;

		alDeleteData.add(login_facility_id);
		alDeleteData.add(getDoc_type_code());
		alDeleteData.add(getDoc_no());
//
		try {
			connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REQUEST_ITEM_STORE_SELECT"));
            pstmt.setString(1, login_facility_id);
            pstmt.setString(2, getDoc_type_code());
            pstmt.setString(3, getDoc_no());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
	      
			
			pstmt1 = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_ITEM_STORE_PENDING_UPDATE"));
			pstmt1.setString(1, "-"+resultSet.getString("req_item_qty"));
            pstmt1.setString(2, login_by_id);
            pstmt1.setString(3, login_at_ws_no);
            pstmt1.setString(4, login_facility_id);
            pstmt1.setString(5, resultSet.getString("req_by_store_code"));
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
		hmSQLMap.put("DeleteHDRSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_HDR_DELETE"));
		hmSQLMap.put("DeleteDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_DELETE"));
	
//		RequestHome requestHome = null;
		RequestRemote requestRemote = null;
		try {
			/*InitialContext context = new InitialContext();
			Object object = context.lookup(StRepository.getStKeyValue("JNDI_ST_REQUEST"));
			requestHome  = (RequestHome) PortableRemoteObject.narrow(object, RequestHome.class);
			requestRemote = requestHome.create();
			hmResult = requestRemote.delete(hmTableData, hmSQLMap) ;*/
				
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(StRepository.getStKeyValue("JNDI_ST_REQUEST"),RequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			 hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		//	hmResult.put("msgid", hmResult.get("message")) ;
		hmResult.put("message",getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
		}catch(Exception e) {
			hmResult.put("message", e.toString()) ;
			e.printStackTrace() ;
		} 
		finally {
			try {
				if(requestRemote != null){
					requestRemote.remove() ;
				}
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

	public String getRequestTypeList(){
		return getStaticListOptionTag( "N,Normal Request;S,Special Request;",getRequestType());
	}

	public ArrayList getBatchDetails(String item_code, String store_code)throws Exception {
		ArrayList BatchDetails=new ArrayList();
		//int isValidDocDate = -1;
		try {
			// To call the procedure st_stock_availability_status
			/*Removed for PE
			String[] strParameters = new String[7];
			strParameters[0] = item_code;
			strParameters[1] = store_code;
			strParameters[2] = "0";
			strParameters[3] = "N";
			strParameters[4] = "";//stHeaderBean.getSysDate();
			strParameters[5] = "N";
			strParameters[6] = "";

			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(strParameters);
			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_item_yn"));*/
			String stParameters[]={store_code, item_code};
			HashMap hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_ON_HAND"),stParameters);
			
			
			BatchDetails.add(hmRecord.get("STOCK_ITEM_YN"));// Added for PE
			BatchDetails.add(hmRecord.get("QTY_ON_HAND"));//(String)hmStockAvailabilityStatus.get("available_stock"));
		}
		catch(Exception exception) {
			//exception.printStackTrace();
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
		/*public double getConvFactTemp(String item_code,String store_code){
			double conv_fac_temp=1;
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			ArrayList alParameters = new ArrayList();
			try {
			alParameters.add(item_code);
			alParameters.add(store_code);

			 conv_fac_temp=Double.parseDouble(checkForNull((String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"),"1.0"));
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
	public String getGenItemUOM(String item_code) throws Exception {
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
	}*/
	public String getGenItemUOM1(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};
		String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			
				base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			gen_uom_code = "";
		}
		
		if(base_uom.size() > 0){
			gen_uom_code = checkForNull((String)base_uom.get("GEN_UOM_CODE"));
		}

		return gen_uom_code;
	}
	
	//Added by Rabbani #inc no:28708 on 22/11/11
	//Starts
	public String getReqUomDesc(String pur_uom_code) throws Exception {
	    String chkdefaultParameters[] = {pur_uom_code,getLanguageId()};
		String req_uom_desc			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
		base_uom = fetchRecord(getStRepositoryValue("SQL_ST_UOM_SHORT_DESC_SELECT1"),chkdefaultParameters);
		}catch(Exception e){
			req_uom_desc = "";
		}
		if(base_uom.size() > 0){
			req_uom_desc = checkForNull((String)base_uom.get("SHORT_DESC"));
		}
		return req_uom_desc;
	}
	//ends
	
	public java.util.ArrayList getOnStores(String req_by_store) throws Exception {
			ArrayList result		=	new ArrayList();
			//String chkParameters[]  = {login_facility_id,getLoginById(),getLanguageId(),getRequest_by_store()};//Mahesh 6/2/2008
			String chkParameters[]  = {login_facility_id,getLanguageId(),getRequest_by_store()};
			result = fetchRecords(StRepository.getStKeyValue("SQL_ST_REQUEST_FROM_STORE_SELECT_FROMST_STORE"),chkParameters);
			
			return result;
	}
	

	public ArrayList sortList(){
		ArrayList arrItemCodeSorted=new ArrayList();
		if(togglePoint!=null && togglePoint!=""){
			
			ArrayList arrSortedCode=new ArrayList();
			ArrayList arrTemp=new ArrayList();			
			ArrayList arrItemDesc=new ArrayList();

			arrItemCodeSorted.addAll(itemKeys);
			arrItemCodeSorted.addAll(itemKeysAdded);
			arrItemDesc.addAll(itemKeysDesc);
			arrItemDesc.addAll(itemKeysDescAdded);

			arrTemp.addAll(itemKeysDesc);
			arrTemp.addAll(itemKeysDescAdded);

			Collections.sort(arrTemp);

			int size = 0;
			if(arrTemp!=null){
				size=arrTemp.size();
			}
			
			//a) Ascending sort
			if(togglePoint.equalsIgnoreCase("ASC")){
				for (int i=0; i<size; i++)
				{
					arrSortedCode.add(arrItemCodeSorted.get(arrItemDesc.indexOf(arrTemp.get(i))));
				}
				arrItemCodeSorted.clear();
				arrItemCodeSorted.addAll(arrSortedCode);
			}
			//b) Descending sort
			else if(togglePoint.equalsIgnoreCase("DESC")){
				for (int i=size; i>0;)
				{
					arrSortedCode.add(arrItemCodeSorted.get(arrItemDesc.indexOf(arrTemp.get(--i))));
				}
				arrItemCodeSorted.clear();
				arrItemCodeSorted.addAll(arrSortedCode);
			}
		}
		return arrItemCodeSorted;
	}


public ArrayList curerentPendingRequestDetalis(String request_by_store)throws Exception{


		ArrayList alItemKeys = new ArrayList();
		ArrayList Doc_details = new ArrayList();
					for(int i=0;i<getItemKeys().size();i++) {
					  alItemKeys.add(getItemKeys().get(i));	
					 } 
					java.util.ArrayList newKeys = getItemKeysAdded();
					if (newKeys != null && newKeys.size() >0) {
						alItemKeys.addAll(newKeys);
					}
					HashMap hmItemStore = (HashMap)getHmItemDetail();
					String itemStoreKey = "";
					if (alItemKeys != null && (alItemKeys.size()>0)) {
						int totalSize = alItemKeys.size();
						RequestDetailBean detailBean;
						for (int i=0;	i<totalSize;	i++){
							itemStoreKey = (String) alItemKeys.get(i);
							detailBean = (RequestDetailBean)hmItemStore.get(itemStoreKey);
						if(detailBean.getCheck_box_status().equals("Y")){
							ArrayList hh=new ArrayList();
						hh=fetchRecords("SELECT DTL.ITEM_CODE ITEM_CODE,MT.SHORT_DESC ITEM_DESC,HDR.REQ_ON_STORE_CODE REQ_ON_STORE_CODE , MS.SHORT_DESC REQ_ON_STORE_DESC,HDR.DOC_NO DOC_NO FROM ST_REQUEST_HDR HDR, ST_REQUEST_DTL DTL,MM_ITEM_LANG_VW MT,MM_STORE_LANG_VW MS WHERE HDR.REQ_BY_STORE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = ? AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.REQUEST_STATUS = 'W' AND HDR.FACILITY_ID = DTL.FACILITY_ID AND MT.ITEM_CODE=DTL.ITEM_CODE AND MS.STORE_CODE=HDR.REQ_ON_STORE_CODE AND MT.LANGUAGE_ID=MS.LANGUAGE_ID AND MT.LANGUAGE_ID=? and  DTL.DOC_NO not in(?) ORDER BY DOC_NO",new String[]{request_by_store,itemStoreKey,getLanguageId(),checkForNull(getDoc_no(),"0")});
							if(hh.size()>0){
								Doc_details.add(hh);
							}
						}
						}
					}
				


		
		return Doc_details;
}
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
			alTemp.set(5,alNewItemClassData.get(i));
			alNewItemHdrData.add(alTemp);
		}
		hmTableData.put("InsertDTLData",alNewTempData);
		hmTableData.put("InsertHDRData",alNewItemHdrData);
		hmTableData.put("ItemClassCount",alCount);
		hmTableData.put("ITEM_CLASS_BASED","Y");
		return hmTableData;
	}
	//Added for ML-MMOH-CRF-0567 starts
	public String getBaseUOM(String item_code) throws Exception {
		ArrayList alParameters=new ArrayList();
		alParameters.add(item_code);
		HashMap hmResult=new HashMap();
		try{
			hmResult=fetchRecord(getStRepositoryValue("SQL_ST_STOCK_UOM_CODE_SELECT"),alParameters);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("CODE");
	}
	//Added for ML-MMOH-CRF-0567 ends
  
	//ADDED FOR ML-MMOH-SCF-1003 START
	public double getConvFactTemp1(String item_code,String store_code){
		
		 	//System.out.println("getConvFactTemp1");  
			double conv_fac_temp=1; 
			Connection connection = null;
			PreparedStatement pstmt = null;
			ResultSet resultSet = null;
			ArrayList alParameters = new ArrayList();
			ArrayList eqlParameters = new ArrayList();
			String gen_uom ="";
			String defult_issue_uom ="";
			String defult_request_uom ="";
			try {
			alParameters.add(item_code);
			alParameters.add(store_code);
 
			HashMap hmRecord	=	fetchRecord(getStRepositoryValue("ST_GENERATE_REQUEST_DEF_ISSUE_REQUEST_UOM"),alParameters);
			
			gen_uom = (String)hmRecord.get("GEN_UOM_CODE");
			defult_issue_uom = (String)hmRecord.get("DEF_ISSUE_UOM");
			defult_request_uom = (String)hmRecord.get("DEF_REQUEST_UOM");
			
			
			if(!gen_uom.equals(defult_request_uom)){
				eqlParameters.add(defult_request_uom);
			    eqlParameters.add(defult_issue_uom);
				conv_fac_temp=Double.parseDouble(checkForNull((String)fetchRecord(getStRepositoryValue("SQL_ST_AM_UOM_EQL_CONVERSION_SELECT"),	eqlParameters).get("eqvl_value"),"1.0"));
				
			}else{
                     conv_fac_temp =  getConvFactTemp(item_code,getRequest_by_store());
                     //System.out.println("conv_fac_temp in else condn: "+conv_fac_temp);
			}

			 
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
	 
	//MO-CRF-20172
	public String getLastIssuedDate(String store_code,String facility_id, String item_code){
		String []stParameters=	{store_code,facility_id, item_code}; 
		//String lastIssuedDate = ""; COMMON-ICN-0310
		HashMap hmResult=new HashMap();
		try{
			hmResult	=	fetchRecord("select * from (SELECT a.MODIFIED_DATE FROM ST_ISSUE_HDR a,ST_ISSUE_DTL b , st_request_hdr c WHERE to_store_code = ? AND a.facility_id = ? AND a.doc_no=b.doc_no AND a.doc_no= c.doc_no and b.doc_no = c.doc_no and b.item_code= ?  and REQUEST_STATUS IN ('C','P') ORDER BY a.modified_date DESC)  WHERE ROWNUM=1", stParameters);//27143
			System.out.println("hmResult: "+hmResult); 
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return (String)hmResult.get("MODIFIED_DATE");   
		
	}
	
public int getNoOfDaysItemStore(String storeCode,String itemCode) throws Exception{
		
	String []stParameters=	{storeCode,itemCode}; 
     //String lastIssuedDate = "";  COMMON-ICN-0310
	HashMap hmResult=new HashMap();
	int noOfDays = 0;
	String strDays = ""; 
	try{
		hmResult	=	fetchRecord("select NO_OF_DAYS from st_item_store where store_code=? AND ITEM_CODE=? ", stParameters);
		System.out.println("hmResult: "+hmResult);  
		strDays = (String)hmResult.get("NO_OF_DAYS");  
		System.out.println("strDays: "+strDays);  
		if( strDays== null ){    
			noOfDays=0;  
		}else{
			noOfDays = Integer.parseInt(strDays);  
		}
	}catch(Exception e){
		e.printStackTrace();
	}
		
		return noOfDays; 
	}//MO-CRF-20172 END 

}
