/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /* 
Request Status 
-----------------
E - Entered
W - Authorized at Requesting Store
A - Authorized at Issuing Store
P - Partially Issued
C - Fully Issued
L - Closed/Cancelled  before Fully Issued
*/

/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
21/04/2016				56060					B.Badmavathi									  Authorize at Issue Store	
03/06/2016				60468					B.Badmavathi									  Batch auto allocation for Expiry batch
20/04/2017				63281					B.Badmavathi									  To display Available Quantity at Request Store 
08/05/2018				67386					Shazana 										  ML-MMOH-SCF-0979 - Conversion factor live issue 
22/05/2018				67677					Shazana 											ML-MMOH-SCF-1003	
10/07/2018				67830					Shazana 											ML-MMOH-SCF-1013
19/06/2019              70724                   B Haribabu                                         NMC-JD-SCF-0016
02/12/2019              71868          			Haribabu                                       		GHL-SCF-1471
2/7/2021				15757					Shazana												Common-ICN-0028

--------------------------------------------------------------------------------------------------------------------------------------------
*/

package eST;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections; 
import java.util.HashMap; 
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.Properties;
//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
import eCommon.Common.CommonRepository;
import eST.Common.StRepository;
//import eST.Common.StAdapter;
import eST.Common.InsufficientBatchException;
import eST.Common.StUtilities;
import eST.AuthorizeAtIssueStoreDetailBean;
import eST.AuthorizeAtIssueStore.*;
import javax.servlet.* ;
import javax.servlet.http.*;
/**
* @Name - Mahesh
* @Date - 20/01/2010
* @Inc# - IN015496
* @Desc - All Interger.parseInt for quantity is changed to Double.parseDouble and variable names are made double
*/

public class AuthorizeAtIssueStoreBean extends eST.Common.StTransaction implements Serializable { 
	
	private String doc_type_code;
	private String doc_type_desc;
	private String doc_no;
	private String doc_ref;
	private String doc_date;
	private String request_by_store;
	private String request_on_store;
	private String finalize_yn;
	//private String authorized_by_id;
	//private String finalized_yn;
	private String item_class_code;
	private String request_by_store_desc;
	private String request_on_store_desc;
	private String item_class_desc;
	private String acc_entity_id;
	private String remarks;
	private String request_status;
	private String remarkscode; //18/06/15
	
	private HashMap		hmExpRecords=new HashMap();
	private HashMap		hmTempRecords=new HashMap();
	private ArrayList	alDtlRecords=new ArrayList();
	private ArrayList	alMinMaxRecords=new ArrayList();
	private ArrayList  closeItemList = new ArrayList();//ADDED for MO-CRF-20173
	private HashMap closeItemMap = new HashMap();
	private HashMap itemRemarksMap = new HashMap();
	
	public String getItemRemarksMap(String itemCode) {
		return (String)itemRemarksMap.get(itemCode);
	}
	public void setItemRemarksMap(String itemCode, String remarks) {
		itemRemarksMap.put(itemCode, remarks) ; 
	}
	  
	public String getCloseItemMap(String itemCode) {
		return (String)closeItemMap.get(itemCode);
	}
	public void setCloseItemMap(String itemCode, String closeItemYN) {
		closeItemMap.put(itemCode, closeItemYN) ; 
	}//MO-CRF-20173 
	public ArrayList getCloseItemList() {
		return closeItemList;
	}
	public void setCloseItemList(ArrayList closeItemList) {
		this.closeItemList = closeItemList;
	}//MO-CRF-20173 END  
	//private ArrayList	alDetailRecords=new ArrayList();
	private int doc_srl_no	=	0;
	
	public String getAcc_entity_id(){
		return this.acc_entity_id;
	};
	private String close_req_after_issue_yn;
// Added for online printing on  9/29/2004	 starts here
	private ArrayList PDocNo = new ArrayList();
	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
	private String stReportid = null;
	private int seq_no = 0;
	public String reportserver = "";
	public String report_connect_string = "";
	public String req_fac_id = "";
	public String qty = "";
	double issuomqty = 0.0;//added for ML-MMOH-0979
// Ends here 9/29/2004
	private boolean isAutoNo;
	private String togglePoint = "DOCSRLNO";
	private String defaultDocType;
	private HashMap hmItemDetail;
	private ArrayList itemKeys;
	private ArrayList addedItemKeys;
	private String closeRemarksDesc ; //MO-CRF-20173  
	private String closeRemarksCode;//end 

	public ArrayList	errorItems  = new ArrayList();
	public ArrayList	arTempDesc  = new ArrayList();
	public ArrayList	arTempCode  = new ArrayList();

	ArrayList checkedDValues=new ArrayList();

/*	private javax.servlet.http.HttpServletRequest request;
	private javax.servlet.http.HttpServletResponse response;
	
	public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; 
		this.response=response	;
	}*/
	public String getRequestStatus()
	{
	  return this.request_status;
	}
	//MO-CRF-20173
	public String getCloseRemarksDesc() {
		return closeRemarksDesc;
	}

	public void setCloseRemarksDesc(String closeRemarksDesc) {
		this.closeRemarksDesc = closeRemarksDesc;
	}
	public String getCloseRemarksCode() {
		return closeRemarksCode;
	}
	public void setCloseRemarksCode(String closeRemarksCode) {
		this.closeRemarksCode = closeRemarksCode;
	}
	//END  
	public void setRequestStatus(String request_status)
	{
	this.request_status=request_status;
	}

	public String getTogglePoint(){
		return this.togglePoint;
	}
	public void setTogglePoint(String toggle){
		this.togglePoint=toggle;
	}
	
	
	public void setErrorItems(ArrayList errorItems){
		this.errorItems = errorItems;
	}
	public ArrayList getKitErrorData(){
		return this.errorItems;
	}

	public AuthorizeAtIssueStoreBean() {
		itemKeys = new java.util.ArrayList();
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}
	public void setReq_by_on_qty(String qty) {
		 this.qty = qty;
	}

	public String getReq_by_on_qty() {
		 return qty;
	}

	public void setDoc_type_desc(String doc_type_desc) {
		 this.doc_type_desc = doc_type_desc;
	}

	public String getDoc_type_desc() {
		 return doc_type_desc;
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no() {
		 return doc_no;
	}

	public void setItem_class_code(String item_class_code) {
		 this.item_class_code = item_class_code;
	}

	public String getItem_class_code() {
		 return this.item_class_code;
	}

	public void setItem_class_desc(String item_class_desc) {
		 this.item_class_desc = item_class_desc;
	}

	public String getItem_class_desc() {
		 return this.item_class_desc;
	}
	public void setReq_Facility_id(String req_fac_id) {
		 this.req_fac_id = req_fac_id;
	}

	public String getReq_Facility_id() {
		 return req_fac_id;
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

	public void setRequest_by_store_desc(String request_by_store_desc) {
		 this.request_by_store_desc = request_by_store_desc;
	}

	public String getRequest_by_store_desc() {
		 return request_by_store_desc;
	}

	public void setRequest_on_store(String request_on_store) {
		 this.request_on_store = request_on_store;
	}

	public String getRequest_on_store() {
		 return request_on_store;
	}

	public void setRequest_on_store_desc(String request_on_store_desc) {
		 this.request_on_store_desc = request_on_store_desc;
	}

	public String getRequest_on_store_desc() {
		 return request_on_store_desc;
	}

	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}

	public boolean getIsAutoNo() {
		return this.isAutoNo;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return this.remarks;
	}

	//Added by Rabbani  #Inc no:33352 on 18/06/12 Remarks code
	public void setRemarks_code(String remarkscode) {
		this.remarkscode = remarkscode;
	}
	public String getRemarks_code() {
		return this.remarkscode;
	}
	//ends
	
	
	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getPrintDocNo(){
		return PDocNo;
	}

	public void setClose_req_after_issue_yn(String close_req_after_issue_yn) {
		this.close_req_after_issue_yn = close_req_after_issue_yn;
	}

	public String getClose_req_after_issue_yn() {
		return this.close_req_after_issue_yn;
	}

	public ArrayList getItemKeys() {
		return this.itemKeys;
	}

	public ArrayList getAddedItemKeys() {
		return this.addedItemKeys;
	}

	public java.util.HashMap getHmItemDetail() {
		return this.hmItemDetail;
	}
	public int getNextDoc_srl_no(){
		return ++doc_srl_no;
	}

	/* Default List value population methods*/
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}
public java.util.ArrayList getCheckedDValues() {
		return this.checkedDValues;
	}
	public void setCheckedDValues(java.util.ArrayList checkedDValues) {
		 this.checkedDValues = checkedDValues;
	}
	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("ISS","");
//		return getDefaultDocumentTypeList("ISS",defaultDocType);
	}

		public String getRequestOnStoreQuery() {
		//String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_FROM_STORE_SELECT_FOR_AUTH_AT_ISS");
		String sql ="SELECT   x.parent_store_code, y.short_desc FROM (SELECT DISTINCT stp.parent_store_code FROM st_store_parent_store stp, mm_store mm, st_user_access_for_store st, st_store ststr WHERE st.store_code = mm.store_code AND st.store_code = ststr.store_code AND (    st.iss_allowed_yn = 'Y' AND ststr.iss_allowed_yn = 'Y' ) AND mm.eff_status = 'E' AND stp.parent_store_code = mm.store_code AND mm.facility_id = ? AND st.user_id = ?) x, mm_store_lang_vw y WHERE x.parent_store_code = y.store_code AND language_id = ? ORDER BY 2, 1 ";
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_on_store());
		
	}
		//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts 
		public String getRequestOnStoreQuery1() {
			String sql ="SELECT   x.parent_store_code, y.short_desc FROM (SELECT DISTINCT stp.parent_store_code FROM st_store_parent_store stp, mm_store mm, st_user_access_for_store st, st_store ststr WHERE st.store_code = mm.store_code AND st.store_code = ststr.store_code AND ST.AUTHORIZE_AT_ISSUE_ALLOWED_YN = 'Y'  AND mm.eff_status = 'E' AND stp.parent_store_code = mm.store_code AND mm.facility_id = ? AND st.user_id = ?) x, mm_store_lang_vw y WHERE x.parent_store_code = y.store_code AND language_id = ? ORDER BY 2, 1";
			java.util.ArrayList sqlParam = new java.util.ArrayList ();
			sqlParam.add(getLoginFacilityId());
			sqlParam.add(getLoginById());
			sqlParam.add(getLanguageId());
			return getListValues(sql, sqlParam,getRequest_on_store());
		}
		public String getAllow_Auth_Issue_store() throws Exception {
			HashMap result = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_FACILITY_PARAM_SELECT_AUTH_ISS_STORE"),getLoginFacilityId());
			String result_yn = checkForNull((String)result.get("ALLOW_AUTHORIZE_AT_ISSUE_STORE"),"N");
			return result_yn;
		}
		//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends
	public String getRequestOnStore() {
		//System.out.println("+1111+1111+1111");
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_REQ_ON_STORE_SELECT");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getRequest_on_store());
	}

	public String getItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(request_by_store);
		sqlParam.add(request_on_store);
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getItem_class_code());
	}

	public String getAllItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLanguageId());
		return getListValues(sql,sqlParam,"");
	}
	
	public AuthorizeAtIssueStoreDetailBean getItemDetail(String item_code)  {
		if (hmItemDetail.containsKey(item_code)) {
			return (AuthorizeAtIssueStoreDetailBean) hmItemDetail.get(item_code);
		}
		return new AuthorizeAtIssueStoreDetailBean();
	}

	public String getYTTDIssueQty(String item_code) {
		try {
			java.util.ArrayList sqlParameter = new java.util.ArrayList(4);
			sqlParameter.add(login_facility_id);
			sqlParameter.add(item_code);
			java.util.HashMap hmYTTD = fetchRecord("select abs(sum(nvl(out_iss_qty_ns,0) + nvl(out_iss_qty_st,0) + nvl(out_urg_qty_ns,0) + nvl(out_urg_qty_st,0) + nvl(sal_qty,0))) ytd_issue_qty from st_item_move_summ a,st_facility_param b where a.facility_id= b.facility_id and b.facility_id=? and a.item_code=?  and a.move_year=b.curr_proc_year",sqlParameter); // Modified for performence issue
			if(getAllowDecimalsYN( item_code).equals("Y")){
			return setNumber(checkForNull((String)hmYTTD.get("YTD_ISSUE_QTY")),getNoOfDecimals());
			}else{
			return setNumber(checkForNull((String)hmYTTD.get("YTD_ISSUE_QTY")),0);

			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
			return "";
		}
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
	
	
	
	public boolean hasRecord(String item_code) {
		if (itemKeys.contains(item_code)) {
			return true;
		}
		return false;
	}

	public java.util.HashMap getItemDetails(java.util.Hashtable details) {
		try {
			
			java.util.ArrayList param = new java.util.ArrayList ();
			String bystoreUom[] = {(String)details.get("request_by_store_code"),(String)details.get("item_code")};
			String onstoreUom[] = {(String)details.get("request_on_store_code"),(String)details.get("item_code")};
			param.add(""+getConvFactTemp((String)details.get("item_code"),(String)details.get("request_by_store_code")));
			param.add(""+getConvFactTemp((String)details.get("item_code"),(String)details.get("request_on_store_code")));
			param.add(details.get("request_by_store_code"));
			param.add(details.get("request_on_store_code"));
			param.add(details.get("item_code"));
			param.add(getLanguageId());
			param.add(getGenItemUOM((String)details.get("item_code")));
			java.util.HashMap byStoreUOM=fetchRecord("SELECT DEF_ISSUE_UOM UOM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=? AND EFF_STATUS = 'E'",bystoreUom);
			param.add(checkForNull((String)byStoreUOM.get("UOM_CODE")));
			param.add(getGenItemUOM((String)details.get("item_code")));
			java.util.HashMap onStoreUOM=fetchRecord("SELECT DEF_ISSUE_UOM UOM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=? AND EFF_STATUS = 'E'",onstoreUom);
			param.add(checkForNull((String)onStoreUOM.get("UOM_CODE")));

			java.util.HashMap dataValue = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DETAIL_SELECT1"),param);
			dataValue.put("result",new Boolean(true));
			dataValue.put("message","");
			return dataValue;
		}
		catch (Exception exception) {
			java.util.HashMap dataValue = new java.util.HashMap();
			dataValue.put("result",new Boolean(false));
			dataValue.put("message","ITEM_STORE_NOT_FOUND");
			exception.printStackTrace();
			return dataValue;
		}
	}
	public void setAcc_entity_id(String acc_entity_id) {
		this.acc_entity_id = acc_entity_id;	
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
		remarks = "";
		remarkscode = ""; //18/06/12
		isAutoNo = false;
		hmItemDetail = new java.util.HashMap();
		itemKeys = new java.util.ArrayList();
		addedItemKeys = new java.util.ArrayList ();
		togglePoint = "DOCSRLNO";
		arTempCode = new java.util.ArrayList();
		arTempDesc = new java.util.ArrayList();
		checkedDValues = new java.util.ArrayList();
		item_class_code="";
		request_status="";
		this.hmExpRecords=new HashMap();  
		this.hmTempRecords=new HashMap();  
		this.alDtlRecords=new ArrayList();
		this.alMinMaxRecords=new ArrayList();
		doc_srl_no	=	0;
		this.closeItemList = new ArrayList();
		this.closeItemMap = new HashMap();  
		this.itemRemarksMap = new HashMap();  
		
		
	}
	public void clear() {

		doc_type_code = null;
		doc_no = null;
		doc_ref = null;
		doc_date = null;
		request_by_store = null;
		request_on_store = null;
		defaultDocType = null;
		remarks = null;
		remarkscode = null; //18/06/12
		isAutoNo = false;
		hmItemDetail = null;
		itemKeys = null ;
		addedItemKeys = null;
		arTempCode = null;
		arTempDesc = null;
		togglePoint = "DOCSRLNO";
		item_class_code="";
		checkedDValues=null;
		request_status="";
		hmExpRecords=null; 
		hmTempRecords=null;		
		alDtlRecords=null;
		alMinMaxRecords=null;
		doc_srl_no	=0;
		closeItemList = null;
		closeItemMap = null;  
		itemRemarksMap = null;  
	}
	
	/* code for display UOM -- 24/06/2004 */

	public String getDefaultUOM(String item_code,String store_code) throws Exception {
		String chkdefaultParameters[] = {item_code,store_code};
		String default_value		  = "";	
		HashMap default_uom			  = new HashMap();
		try{
			default_uom = fetchRecord(getStRepositoryValue("SQL_ST_REQUEST_UOM_DEFAULT"),chkdefaultParameters);
		}catch(Exception e){
			default_value = "";
			e.printStackTrace();
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

	public String getPur_uom_code_Modify_List(String uom_code,String parameters,String item_code) throws Exception{
			boolean select=false;
			String chkParameters[] = {checkForNull(uom_code),getLanguageId(),checkForNull(uom_code),getLanguageId(),checkForNull(uom_code),getLanguageId(),item_code};
			
		 		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_EQVL_UOM_SELECT1"),chkParameters,select),parameters);
		
	}

	public String getDefaultIssueUOM(String item_code,String store_code) throws Exception {
		String chkdefaultParameters[] = {item_code,store_code};
		String default_value		  = "";	
		HashMap default_uom			  = new HashMap();
		try{
			default_uom = fetchRecord(getStRepositoryValue("SQL_ST_ISSUE_UOM_DEFAULT"),chkdefaultParameters);
		}catch(Exception e){
			default_value = "";
			e.printStackTrace();
		}
		
		if(default_uom.size() > 0)
			default_value = (String)default_uom.get("DEF_ISSUE_UOM");

		return default_value;

	}
	//code ends...

	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());


		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}
	
	
	public HashMap validate() {

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "");
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			try {
				int docDateValidation = isValidDocDate(getDoc_date_value());
				if (docDateValidation == 1) {
					resultMap.put("result", new Boolean(false));
					resultMap.put("message", "ST_DOC_DT_NOT_LT_PROC_MTH");
				}
				else if (docDateValidation == 2) {
					resultMap.put("result", new Boolean(false));
					resultMap.put("message", "ST_DOC_DT_NOT_GR_SYSDATE");
				}
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		return resultMap;
	}

	public void setAll(Hashtable hashValues) {
		String close_req_yn = "";
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_DELETE"))) {
			return ;
		}
		if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
			setDoc_ref((String)hashValues.get("doc_ref"));
			setDoc_date((String)hashValues.get("doc_date"));
			close_req_yn = (String)hashValues.get("close_upon_issue_yn");
			
			if(!(close_req_yn.equals("Y")))
				close_req_yn = "N";
			setClose_req_after_issue_yn(close_req_yn);
			return;
		}
		//String keyCode;
		//String selectedKey;
		setDoc_type_code((String)hashValues.get("doc_type_code"));
		setDoc_no((String)hashValues.get("doc_no"));
		setDoc_date((String)hashValues.get("doc_date"));
		setDoc_ref((String)hashValues.get("doc_ref"));
		setRequest_by_store((String)hashValues.get("request_by_store_code"));
		setRequest_on_store((String)hashValues.get("request_on_store_code"));
		setIsAutoNo(hashValues.get("autono_yn").equals("Yes")?true:false);
		setFinalize_yn((String)hashValues.get("finalize_yn"));
		setItem_class_code((String)hashValues.get("item_class_code"));

		close_req_yn = (String)hashValues.get("close_upon_issue_yn");
		/*if (!(close_req_yn == null || close_req_yn.trim() == "")) {
			close_req_yn = "N";
		}
		setClose_req_after_issue_yn(close_req_yn);
		*/
		if(!(close_req_yn.equals("Y")))
				close_req_yn = "N";
			setClose_req_after_issue_yn(close_req_yn);
	}

	public void loadData(String doc_type_code, String doc_no) {

		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		java.util.HashMap resultMap = new java.util.HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "");
		AuthorizeAtIssueStoreDetailBean requisitionIssueDetailBean = new AuthorizeAtIssueStoreDetailBean();
		try {
            connection = getConnection();
            pstmt = connection.prepareStatement("SELECT hdr.doc_type_code,        (SELECT short_desc           FROM sy_doc_type_master_lang_vw          WHERE hdr.doc_type_code = doc_type_code            AND language_id = rons.LANGUAGE_ID) doc_type_desc,        hdr.doc_no, TO_CHAR (hdr.doc_date, 'dd/mm/yyyy') doc_date, hdr.doc_ref,        hdr.req_by_store_code,        (SELECT short_desc           FROM mm_store_lang_vw          WHERE hdr.req_by_store_code = store_code            AND language_id = rons.LANGUAGE_ID            AND hdr.facility_id = facility_id) req_by_store_desc,        hdr.req_on_store_code, rons.short_desc req_on_store_desc,        hdr.item_class_code,        (SELECT short_desc           FROM mm_item_class_lang_vw          WHERE hdr.item_class_code = item_class_code            AND language_id = rons.LANGUAGE_ID) item_class_desc,        hdr.facility_id facility_id, hdr.request_status request_status   FROM st_request_hdr hdr, mm_store_lang_vw rons, st_acc_entity_param stp  WHERE hdr.req_on_store_code = rons.store_code    AND DECODE (trn_across_facility_yn, 'Y', 'X', hdr.facility_id) =                    DECODE (trn_across_facility_yn,                            'Y', 'X',                            rons.facility_id                           )     AND hdr.doc_type_code = ?    AND hdr.doc_no =? AND rons.LANGUAGE_ID =?   AND hdr.request_status NOT IN ('L', 'C')    ");
            //pstmt.setString(1, login_facility_id);
            pstmt.setString(1, doc_type_code);
            pstmt.setString(2, doc_no);
			pstmt.setString(3, getLanguageId());
           
            resultSet = pstmt.executeQuery();
            if (resultSet != null && resultSet.next()) {
				setDoc_type_code(resultSet.getString("doc_type_code"));
				setDoc_type_desc(resultSet.getString("doc_type_desc"));
				setDoc_no(resultSet.getString("doc_no"));
				setDoc_date(resultSet.getString("doc_date"));
				setDoc_ref(resultSet.getString("doc_ref"));
				setRequest_by_store(resultSet.getString("req_by_store_code"));
				setRequest_by_store_desc(resultSet.getString("req_by_store_desc"));
				setRequest_on_store(resultSet.getString("req_on_store_code"));
				setRequest_on_store_desc(resultSet.getString("req_on_store_desc"));
				setItem_class_code(resultSet.getString("item_class_code"));
				setItem_class_desc(resultSet.getString("item_class_desc"));
//				setFacility_id(resultSet.getString("facility_id"));
				setReq_Facility_id((String)resultSet.getString("facility_id"));
				setRequestStatus((String)resultSet.getString("request_status"));
            }
			// Load Detail Data
			//pstmt = null;
			//resultSet = null;
			 closeResultSet(resultSet);
             closeStatement(pstmt);
			String key = null;
            //pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REQUEST_ISSUE_DTL_SELECT"));
            //pstmt = connection.prepareStatement("SELECT  hdr.req_by_store_code, hdr.req_on_store_code store_code,dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty, iss_item_qty, DECODE (rons.qty_on_hand,0, 0,pending_item_qty - committed_item_qty) pending_item_qty,committed_item_qty,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =itm.gen_uom_code AND language_id = itm.language_id)uom_desc, dtl.stock_item_yn, rbys.min_stk_qty req_by_min_stk_qty, rbys.max_stk_qty req_by_max_stk_qty,rbys.reorder_level req_by_reorder_level, sitm.curr_pack_size,rons.min_stk_qty req_on_min_stk_qty, rons.max_stk_qty req_on_max_stk_qty,rons.reorder_level req_on_reorder_level, itm.unit_cost, sitm.issue_int_qty_yn, rbys.bin_location_code to_bin_location_code, request_uom, request_uom_conv, request_uom_qty, itm.gen_uom_code uom_code,(SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_by_store_code ) req_by_qty_on_hand, (SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_lang_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_on_store_code AND stbvw.language_id = itm.language_id AND itm.language_id = stbvw.lang1 AND itm.language_id = stbvw.lang2) req_on_qty_on_hand FROM st_request_hdr hdr, st_request_dtl dtl,mm_item_lang_vw itm, st_item_store rbys,st_item_store rons, st_item sitm WHERE HDR.doc_type_code = ?  AND HDR.doc_no = ? 	 AND hdr.facility_id = ? AND hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = sitm.item_code AND dtl.item_code = itm.item_code AND hdr.req_by_store_code = rbys.store_code AND dtl.item_code = rbys.item_code AND hdr.req_on_store_code = rons.store_code  AND dtl.item_code = rons.item_code AND dtl.pending_item_qty > 0  AND itm.language_id =? AND NOT EXISTS ( SELECT DISTINCT item_code FROM st_issue_dtl dtl, st_issue_hdr hdr WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND hdr.facility_id = dtl.facility_id  AND hdr.seq_no = dtl.seq_no     AND hdr.doc_no = ? AND hdr.finalized_yn = 'D' and hdr.facility_id=? and hdr.doc_type_code=?) ORDER BY doc_srl_no");
              
			  //Commented by Rabbani #Inc no:34905 on 20/09/12
			//pstmt = connection.prepareStatement("SELECT  hdr.req_by_store_code, hdr.req_on_store_code store_code,dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty, iss_item_qty, DECODE (rons.qty_on_hand,0, 0,pending_item_qty - committed_item_qty) pending_item_qty,committed_item_qty,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =itm.gen_uom_code AND language_id = itm.language_id)uom_desc, dtl.stock_item_yn, rbys.min_stk_qty req_by_min_stk_qty, rbys.max_stk_qty req_by_max_stk_qty,rbys.reorder_level req_by_reorder_level, sitm.curr_pack_size,rons.min_stk_qty req_on_min_stk_qty, rons.max_stk_qty req_on_max_stk_qty,rons.reorder_level req_on_reorder_level, itm.unit_cost, sitm.issue_int_qty_yn, rbys.bin_location_code to_bin_location_code, request_uom, request_uom_conv, request_uom_qty, itm.gen_uom_code uom_code,(SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_by_store_code ) req_by_qty_on_hand, (SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_lang_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_on_store_code AND stbvw.language_id = itm.language_id AND itm.language_id = stbvw.lang1 AND itm.language_id = stbvw.lang2) req_on_qty_on_hand FROM st_request_hdr hdr, st_request_dtl dtl,mm_item_lang_vw itm, st_item_store rbys,st_item_store rons, st_item sitm,st_Acc_entity_param WHERE HDR.doc_type_code = ?  AND HDR.doc_no = ? 	 AND hdr.facility_id = DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) AND hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = sitm.item_code AND dtl.item_code = itm.item_code AND hdr.req_by_store_code = rbys.store_code AND dtl.item_code = rbys.item_code AND hdr.req_on_store_code = rons.store_code  AND dtl.item_code = rons.item_code AND dtl.pending_item_qty > 0  AND itm.language_id =? AND NOT EXISTS ( SELECT DISTINCT item_code FROM st_issue_dtl dtl, st_issue_hdr hdr WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND hdr.facility_id = dtl.facility_id  AND hdr.seq_no = dtl.seq_no     AND hdr.doc_no = ? AND hdr.finalized_yn = 'D' and hdr.facility_id=DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) and hdr.doc_type_code=?) ORDER BY doc_srl_no");	//changed on 3/2/2011
			
			//added by Rabbani #Inc no:34905 on 20/09/12
			//Commented to pass UOM_DESC By Sakti Sankar against Inc#32347 on 22/10/2012
			//pstmt = connection.prepareStatement("SELECT  hdr.req_by_store_code, hdr.req_on_store_code store_code,dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty, iss_item_qty, DECODE (rons.qty_on_hand,0, 0,pending_item_qty - committed_item_qty) pending_item_qty,committed_item_qty,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =itm.gen_uom_code AND language_id = itm.language_id)uom_desc, dtl.stock_item_yn, rbys.min_stk_qty req_by_min_stk_qty, rbys.max_stk_qty req_by_max_stk_qty,rbys.reorder_level req_by_reorder_level, sitm.curr_pack_size,rons.min_stk_qty req_on_min_stk_qty, rons.max_stk_qty req_on_max_stk_qty,rons.reorder_level req_on_reorder_level, itm.unit_cost, sitm.issue_int_qty_yn, rbys.bin_location_code to_bin_location_code, request_uom, request_uom_conv, request_uom_qty, itm.gen_uom_code uom_code,(SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_by_store_code ) req_by_qty_on_hand, (SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_lang_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_on_store_code AND stbvw.language_id = itm.language_id AND itm.language_id = stbvw.lang1 AND itm.language_id = stbvw.lang2) req_on_qty_on_hand,dtl.usage_type FROM st_request_hdr hdr, st_request_dtl dtl,mm_item_lang_vw itm, st_item_store rbys,st_item_store rons, st_item sitm,st_Acc_entity_param WHERE HDR.doc_type_code = ?  AND HDR.doc_no = ? 	 AND hdr.facility_id = DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) AND hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = sitm.item_code AND dtl.item_code = itm.item_code AND hdr.req_by_store_code = rbys.store_code AND dtl.item_code = rbys.item_code AND hdr.req_on_store_code = rons.store_code  AND dtl.item_code = rons.item_code AND dtl.pending_item_qty > 0  AND itm.language_id =? AND NOT EXISTS ( SELECT DISTINCT item_code FROM st_issue_dtl dtl, st_issue_hdr hdr WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND hdr.facility_id = dtl.facility_id  AND hdr.seq_no = dtl.seq_no     AND hdr.doc_no = ? AND hdr.finalized_yn = 'D' and hdr.facility_id=DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) and hdr.doc_type_code=?) ORDER BY doc_srl_no"); 
			
			//commented and added below in else condition  for RUT-CRF-0079
			//pstmt = connection.prepareStatement("SELECT  hdr.req_by_store_code, hdr.req_on_store_code store_code,dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty, iss_item_qty, DECODE (rons.qty_on_hand,0, 0,pending_item_qty - committed_item_qty) pending_item_qty,committed_item_qty,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =itm.gen_uom_code AND language_id = itm.language_id)uom_desc, dtl.stock_item_yn, rbys.min_stk_qty req_by_min_stk_qty, rbys.max_stk_qty req_by_max_stk_qty,rbys.reorder_level req_by_reorder_level, sitm.curr_pack_size,rons.min_stk_qty req_on_min_stk_qty, rons.max_stk_qty req_on_max_stk_qty,rons.reorder_level req_on_reorder_level, itm.unit_cost, sitm.issue_int_qty_yn, rbys.bin_location_code to_bin_location_code, request_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =request_uom AND language_id = itm.language_id)request_uom_desc, request_uom_conv, request_uom_qty, itm.gen_uom_code uom_code,(SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_by_store_code ) req_by_qty_on_hand, (SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_lang_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_on_store_code AND stbvw.language_id = itm.language_id AND itm.language_id = stbvw.lang1 AND itm.language_id = stbvw.lang2) req_on_qty_on_hand,dtl.usage_type FROM st_request_hdr hdr, st_request_dtl dtl,mm_item_lang_vw itm, st_item_store rbys,st_item_store rons, st_item sitm,st_Acc_entity_param WHERE HDR.doc_type_code = ?  AND HDR.doc_no = ? 	 AND hdr.facility_id = DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) AND hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = sitm.item_code AND dtl.item_code = itm.item_code AND hdr.req_by_store_code = rbys.store_code AND dtl.item_code = rbys.item_code AND hdr.req_on_store_code = rons.store_code  AND dtl.item_code = rons.item_code AND dtl.pending_item_qty > 0  AND itm.language_id =? AND NOT EXISTS ( SELECT DISTINCT item_code FROM st_issue_dtl dtl, st_issue_hdr hdr WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND hdr.facility_id = dtl.facility_id  AND hdr.seq_no = dtl.seq_no     AND hdr.doc_no = ? AND hdr.finalized_yn = 'D' and hdr.facility_id=DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) and hdr.doc_type_code=?) ORDER BY doc_srl_no"); 

			if(isBarCodeApplicableForValidation("VALIDATEBARCODE","ISS")){
				//pstmt = connection.prepareStatement("SELECT  hdr.req_by_store_code, hdr.req_on_store_code store_code,dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty, iss_item_qty, DECODE (rons.qty_on_hand,0, 0,pending_item_qty - committed_item_qty) pending_item_qty,committed_item_qty,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =itm.gen_uom_code AND language_id = itm.language_id)uom_desc, dtl.stock_item_yn, rbys.min_stk_qty req_by_min_stk_qty, rbys.max_stk_qty req_by_max_stk_qty,rbys.reorder_level req_by_reorder_level, sitm.curr_pack_size,rons.min_stk_qty req_on_min_stk_qty, rons.max_stk_qty req_on_max_stk_qty,rons.reorder_level req_on_reorder_level, itm.unit_cost, sitm.issue_int_qty_yn, rbys.bin_location_code to_bin_location_code, request_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =request_uom AND language_id = itm.language_id)request_uom_desc, request_uom_conv, request_uom_qty, itm.gen_uom_code uom_code,(SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_by_store_code ) req_by_qty_on_hand, (SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_lang_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_on_store_code AND stbvw.language_id = itm.language_id AND itm.language_id = stbvw.lang1 AND itm.language_id = stbvw.lang2) req_on_qty_on_hand,dtl.usage_type,(SELECT short_desc  FROM mm_bin_location_lang_vw  WHERE store_code = hdr.req_on_store_code  AND bin_location_code = rons.bin_location_code  AND language_id = itm.language_id) bin_locn_desc, (SELECT short_desc   FROM mm_item_class_lang_vw  WHERE item_class_code = itm.item_class_code  AND language_id = itm.language_id) item_class_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal1_code    AND language_id = itm.language_id) item_anal1_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal2_code  AND language_id = itm.language_id) item_anal2_desc,(SELECT short_desc   FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal3_code  AND language_id = itm.language_id) item_anal3_desc FROM st_request_hdr hdr, st_request_dtl dtl,mm_item_lang_vw itm, st_item_store rbys,st_item_store rons, st_item sitm,st_Acc_entity_param WHERE HDR.doc_type_code = ?  AND HDR.doc_no = ? 	 AND hdr.facility_id = DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) AND hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = sitm.item_code AND dtl.item_code = itm.item_code AND hdr.req_by_store_code = rbys.store_code AND dtl.item_code = rbys.item_code AND hdr.req_on_store_code = rons.store_code  AND dtl.item_code = rons.item_code AND dtl.pending_item_qty > 0  AND itm.language_id =? AND NOT EXISTS ( SELECT DISTINCT item_code FROM st_issue_dtl dtl, st_issue_hdr hdr WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND hdr.facility_id = dtl.facility_id  AND hdr.seq_no = dtl.seq_no     AND hdr.doc_no = ? AND hdr.finalized_yn = 'D' and hdr.facility_id=DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) and hdr.doc_type_code=?) ORDER BY 30,31,32,33,34,5");
				
                 //Added by Rabbani #Inc no:44011 (ML-BRU-SCF-1071) on 23-OCT-2013				
				//pstmt = connection.prepareStatement("SELECT  hdr.req_by_store_code, hdr.req_on_store_code store_code,dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty, iss_item_qty, DECODE (rons.qty_on_hand,0, 0,pending_item_qty - committed_item_qty) pending_item_qty,committed_item_qty,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =itm.gen_uom_code AND language_id = itm.language_id)uom_desc, dtl.stock_item_yn, rbys.min_stk_qty req_by_min_stk_qty, rbys.max_stk_qty req_by_max_stk_qty,rbys.reorder_level req_by_reorder_level, sitm.curr_pack_size,rons.min_stk_qty req_on_min_stk_qty, rons.max_stk_qty req_on_max_stk_qty,rons.reorder_level req_on_reorder_level, TRIM(ST_DISPLAY_UNIT_COST (DTL.ITEM_CODE)) base_unit_cost, sitm.issue_int_qty_yn, rbys.bin_location_code to_bin_location_code, request_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =request_uom AND language_id = itm.language_id)request_uom_desc, request_uom_conv, request_uom_qty, itm.gen_uom_code uom_code,(SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_by_store_code ) req_by_qty_on_hand, (SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_lang_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_on_store_code AND stbvw.language_id = itm.language_id AND itm.language_id = stbvw.lang1 AND itm.language_id = stbvw.lang2) req_on_qty_on_hand,dtl.usage_type,(SELECT short_desc  FROM mm_bin_location_lang_vw  WHERE store_code = hdr.req_on_store_code  AND bin_location_code = rons.bin_location_code  AND language_id = itm.language_id) bin_locn_desc, (SELECT short_desc   FROM mm_item_class_lang_vw  WHERE item_class_code = itm.item_class_code  AND language_id = itm.language_id) item_class_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal1_code    AND language_id = itm.language_id) item_anal1_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal2_code  AND language_id = itm.language_id) item_anal2_desc,(SELECT short_desc   FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal3_code  AND language_id = itm.language_id) item_anal3_desc FROM st_request_hdr hdr, st_request_dtl dtl,mm_item_lang_vw itm, st_item_store rbys,st_item_store rons, st_item sitm,st_Acc_entity_param WHERE HDR.doc_type_code = ?  AND HDR.doc_no = ? 	 AND hdr.facility_id = DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) AND hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = sitm.item_code AND dtl.item_code = itm.item_code AND hdr.req_by_store_code = rbys.store_code AND dtl.item_code = rbys.item_code AND hdr.req_on_store_code = rons.store_code  AND dtl.item_code = rons.item_code AND dtl.pending_item_qty > 0  AND itm.language_id =? /*AND NOT EXISTS ( SELECT DISTINCT item_code FROM st_issue_dtl dtl, st_issue_hdr hdr WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND hdr.facility_id = dtl.facility_id  AND hdr.seq_no = dtl.seq_no     AND hdr.doc_no = ? AND hdr.finalized_yn = 'D' and hdr.facility_id=DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) and hdr.doc_type_code=?) */ ORDER BY 30,31,32,33,34,5"); 
				//Modified by suresh.r on 13-11-2014 against Inc 52256
				pstmt = connection.prepareStatement("SELECT  hdr.req_by_store_code, hdr.req_on_store_code store_code,dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty, iss_item_qty, DECODE (rons.qty_on_hand,0, 0,pending_item_qty - committed_item_qty) pending_item_qty,committed_item_qty,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =itm.gen_uom_code AND language_id = itm.language_id)uom_desc, dtl.stock_item_yn, rbys.min_stk_qty req_by_min_stk_qty, rbys.max_stk_qty req_by_max_stk_qty,rbys.reorder_level req_by_reorder_level, sitm.curr_pack_size,rons.min_stk_qty req_on_min_stk_qty, rons.max_stk_qty req_on_max_stk_qty,rons.reorder_level req_on_reorder_level, TRIM(ST_DISPLAY_UNIT_COST (DTL.ITEM_CODE,SYSDATE,'CURRENT_STOCK')) base_unit_cost, sitm.issue_int_qty_yn, rbys.bin_location_code to_bin_location_code, request_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =request_uom AND language_id = itm.language_id)request_uom_desc, request_uom_conv, request_uom_qty, itm.gen_uom_code uom_code,(SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_by_store_code ) req_by_qty_on_hand, (SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_lang_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_on_store_code AND stbvw.language_id = itm.language_id AND itm.language_id = stbvw.lang1 AND itm.language_id = stbvw.lang2) req_on_qty_on_hand,dtl.usage_type,(SELECT short_desc  FROM mm_bin_location_lang_vw  WHERE store_code = hdr.req_on_store_code  AND bin_location_code = rons.bin_location_code  AND language_id = itm.language_id) bin_locn_desc, (SELECT short_desc   FROM mm_item_class_lang_vw  WHERE item_class_code = itm.item_class_code  AND language_id = itm.language_id) item_class_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal1_code    AND language_id = itm.language_id) item_anal1_desc, (SELECT short_desc  FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal2_code  AND language_id = itm.language_id) item_anal2_desc,(SELECT short_desc   FROM mm_item_analysis_lang_vw  WHERE item_anal_code = itm.item_anal3_code  AND language_id = itm.language_id) item_anal3_desc FROM st_request_hdr hdr, st_request_dtl dtl,mm_item_lang_vw itm, st_item_store rbys,st_item_store rons, st_item sitm,st_Acc_entity_param WHERE HDR.doc_type_code = ?  AND HDR.doc_no = ? 	 AND hdr.facility_id = DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) AND hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = sitm.item_code AND dtl.item_code = itm.item_code AND hdr.req_by_store_code = rbys.store_code AND dtl.item_code = rbys.item_code AND hdr.req_on_store_code = rons.store_code  AND dtl.item_code = rons.item_code AND dtl.pending_item_qty > 0  AND itm.language_id =? /*AND NOT EXISTS ( SELECT DISTINCT item_code FROM st_issue_dtl dtl, st_issue_hdr hdr WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND hdr.facility_id = dtl.facility_id  AND hdr.seq_no = dtl.seq_no     AND hdr.doc_no = ? AND hdr.finalized_yn = 'D' and hdr.facility_id=DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) and hdr.doc_type_code=?) */ ORDER BY 30,31,32,33,34,5"); 
			}else{
				//pstmt = connection.prepareStatement("SELECT  hdr.req_by_store_code, hdr.req_on_store_code store_code,dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty, iss_item_qty, DECODE (rons.qty_on_hand,0, 0,pending_item_qty - committed_item_qty) pending_item_qty,committed_item_qty,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =itm.gen_uom_code AND language_id = itm.language_id)uom_desc, dtl.stock_item_yn, rbys.min_stk_qty req_by_min_stk_qty, rbys.max_stk_qty req_by_max_stk_qty,rbys.reorder_level req_by_reorder_level, sitm.curr_pack_size,rons.min_stk_qty req_on_min_stk_qty, rons.max_stk_qty req_on_max_stk_qty,rons.reorder_level req_on_reorder_level, itm.unit_cost, sitm.issue_int_qty_yn, rbys.bin_location_code to_bin_location_code, request_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =request_uom AND language_id = itm.language_id)request_uom_desc, request_uom_conv, request_uom_qty, itm.gen_uom_code uom_code,(SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_by_store_code ) req_by_qty_on_hand, (SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_lang_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_on_store_code AND stbvw.language_id = itm.language_id AND itm.language_id = stbvw.lang1 AND itm.language_id = stbvw.lang2) req_on_qty_on_hand,dtl.usage_type FROM st_request_hdr hdr, st_request_dtl dtl,mm_item_lang_vw itm, st_item_store rbys,st_item_store rons, st_item sitm,st_Acc_entity_param WHERE HDR.doc_type_code = ?  AND HDR.doc_no = ? 	 AND hdr.facility_id = DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) AND hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = sitm.item_code AND dtl.item_code = itm.item_code AND hdr.req_by_store_code = rbys.store_code AND dtl.item_code = rbys.item_code AND hdr.req_on_store_code = rons.store_code  AND dtl.item_code = rons.item_code AND dtl.pending_item_qty > 0  AND itm.language_id =? AND NOT EXISTS ( SELECT DISTINCT item_code FROM st_issue_dtl dtl, st_issue_hdr hdr WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND hdr.facility_id = dtl.facility_id  AND hdr.seq_no = dtl.seq_no     AND hdr.doc_no = ? AND hdr.finalized_yn = 'D' and hdr.facility_id=DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) and hdr.doc_type_code=?) ORDER BY doc_srl_no");
				
				//Added by Rabbani #Inc no:44011 (ML-BRU-SCF-1071) on 23-OCT-2013
				//pstmt = connection.prepareStatement("SELECT  hdr.req_by_store_code, hdr.req_on_store_code store_code,dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty, iss_item_qty, DECODE (rons.qty_on_hand,0, 0,pending_item_qty - committed_item_qty) pending_item_qty,committed_item_qty,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =itm.gen_uom_code AND language_id = itm.language_id)uom_desc, dtl.stock_item_yn, rbys.min_stk_qty req_by_min_stk_qty, rbys.max_stk_qty req_by_max_stk_qty,rbys.reorder_level req_by_reorder_level, sitm.curr_pack_size,rons.min_stk_qty req_on_min_stk_qty, rons.max_stk_qty req_on_max_stk_qty,rons.reorder_level req_on_reorder_level, TRIM(ST_DISPLAY_UNIT_COST (DTL.ITEM_CODE)) base_unit_cost, sitm.issue_int_qty_yn, rbys.bin_location_code to_bin_location_code, request_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =request_uom AND language_id = itm.language_id)request_uom_desc, request_uom_conv, request_uom_qty, itm.gen_uom_code uom_code,(SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_by_store_code ) req_by_qty_on_hand, (SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_lang_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_on_store_code AND stbvw.language_id = itm.language_id AND itm.language_id = stbvw.lang1 AND itm.language_id = stbvw.lang2) req_on_qty_on_hand,dtl.usage_type FROM st_request_hdr hdr, st_request_dtl dtl,mm_item_lang_vw itm, st_item_store rbys,st_item_store rons, st_item sitm,st_Acc_entity_param WHERE HDR.doc_type_code = ?  AND HDR.doc_no = ? 	 AND hdr.facility_id = DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) AND hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = sitm.item_code AND dtl.item_code = itm.item_code AND hdr.req_by_store_code = rbys.store_code AND dtl.item_code = rbys.item_code AND hdr.req_on_store_code = rons.store_code  AND dtl.item_code = rons.item_code AND dtl.pending_item_qty > 0  AND itm.language_id =? /*AND NOT EXISTS ( SELECT DISTINCT item_code FROM st_issue_dtl dtl, st_issue_hdr hdr WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND hdr.facility_id = dtl.facility_id  AND hdr.seq_no = dtl.seq_no     AND hdr.doc_no = ? AND hdr.finalized_yn = 'D' and hdr.facility_id=DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) and hdr.doc_type_code=?)*/ ORDER BY doc_srl_no");
				//Modified by suresh.r on 13-11-2014 against Inc 52256
				pstmt = connection.prepareStatement("SELECT  hdr.req_by_store_code, hdr.req_on_store_code store_code,dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty, iss_item_qty, DECODE (rons.qty_on_hand,0, 0,pending_item_qty - committed_item_qty) pending_item_qty,committed_item_qty,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =itm.gen_uom_code AND language_id = itm.language_id)uom_desc, dtl.stock_item_yn, rbys.min_stk_qty req_by_min_stk_qty, rbys.max_stk_qty req_by_max_stk_qty,rbys.reorder_level req_by_reorder_level, sitm.curr_pack_size,rons.min_stk_qty req_on_min_stk_qty, rons.max_stk_qty req_on_max_stk_qty,rons.reorder_level req_on_reorder_level, TRIM(ST_DISPLAY_UNIT_COST (DTL.ITEM_CODE,SYSDATE,'CURRENT_STOCK')) base_unit_cost, sitm.issue_int_qty_yn, rbys.bin_location_code to_bin_location_code, request_uom,(SELECT short_desc FROM am_uom_lang_vw WHERE uom_code =request_uom AND language_id = itm.language_id)request_uom_desc, request_uom_conv, request_uom_qty, itm.gen_uom_code uom_code,(SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_by_store_code ) req_by_qty_on_hand, (SELECT SUM (NVL (stbvw.avail_qty, 0)) FROM st_batch_search_lang_view stbvw WHERE stbvw.item_code = dtl.item_code AND stbvw.store_code = hdr.req_on_store_code AND stbvw.language_id = itm.language_id AND itm.language_id = stbvw.lang1 AND itm.language_id = stbvw.lang2) req_on_qty_on_hand,dtl.usage_type, dtl.CLOSE_ITEM_YN FROM st_request_hdr hdr, st_request_dtl dtl,mm_item_lang_vw itm, st_item_store rbys,st_item_store rons, st_item sitm,st_Acc_entity_param WHERE HDR.doc_type_code = ?  AND HDR.doc_no = ? 	 AND hdr.facility_id = DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) AND hdr.facility_id = dtl.facility_id AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = sitm.item_code AND dtl.item_code = itm.item_code AND hdr.req_by_store_code = rbys.store_code AND dtl.item_code = rbys.item_code AND hdr.req_on_store_code = rons.store_code  AND dtl.item_code = rons.item_code AND dtl.pending_item_qty > 0  AND itm.language_id =? /*AND NOT EXISTS ( SELECT DISTINCT item_code FROM st_issue_dtl dtl, st_issue_hdr hdr WHERE hdr.doc_no = dtl.doc_no AND hdr.doc_type_code = dtl.doc_type_code AND hdr.facility_id = dtl.facility_id  AND hdr.seq_no = dtl.seq_no     AND hdr.doc_no = ? AND hdr.finalized_yn = 'D' and hdr.facility_id=DECODE (TRN_ACROSS_FACILITY_YN, 'Y', hdr.facility_id,?) and hdr.doc_type_code=?)*/ and (dtl.close_item_yn!='Y' OR DTL.CLOSE_ITEM_YN IS NULL) ORDER BY doc_srl_no");//added close_item_yn for MO-CRF-20173 
			}



            //pstmt.setString(1, login_facility_id);
            pstmt.setString(1, doc_type_code);
            pstmt.setString(2, doc_no);
			pstmt.setString(3, login_facility_id);
			pstmt.setString(4, getLanguageId());
			//commented by Rabbani #Inc no:44011 (ML-BRU-SCF-1071) on 23-OCT-2013
         /*   pstmt.setString(5, doc_no);
			pstmt.setString(6, login_facility_id);
			pstmt.setString(7, doc_type_code); */
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
				requisitionIssueDetailBean = new AuthorizeAtIssueStoreDetailBean();
				
				requisitionIssueDetailBean.setAll(resultSet);
				if(!requisitionIssueDetailBean.getReq_on_min_stk_level().equals("")){
				double req_on_min_qty = 
			     Double.parseDouble(requisitionIssueDetailBean.getReq_on_min_stk_level())	*getConvFactTemp((String)requisitionIssueDetailBean.getItem_code(),(String)getRequest_on_store());
                 requisitionIssueDetailBean.setReq_on_min_stk_level(""+req_on_min_qty);
				}
				double pending_qty = Double.parseDouble(requisitionIssueDetailBean.getPending_item_qty())*getConvFactTemp(requisitionIssueDetailBean.getItem_code(),getRequest_by_store());//commented for ML-MMOH-SCF-1003,Modified for 70724
				//double pending_qty = Double.parseDouble(requisitionIssueDetailBean.getPending_item_qty());//ADDED FOR ML-MMOH-SCF-1003,Modified for 70724
				requisitionIssueDetailBean.setPending_item_qty(""+pending_qty);
				//code added for Defaulting Issue Details...
				String iss_default_uom = getDefaultIssueUOM(requisitionIssueDetailBean.getItem_code(),requisitionIssueDetailBean.getStore_code());
				
				if(iss_default_uom == null || iss_default_uom == ""){
 				  iss_default_uom = requisitionIssueDetailBean.getUomCode() ;
				}



				String iss_conv_value = "";

				if(iss_default_uom !=null || iss_default_uom ==""){
				try
				{
					//settting Issue UOM Code
					requisitionIssueDetailBean.setIssUomCode(iss_default_uom);
					if(iss_default_uom.equals(((String)requisitionIssueDetailBean.getUomCode()).trim()))
					{
						requisitionIssueDetailBean.setIssConvFact("1");
					}else{
						iss_conv_value=(String)fetchRecord("SELECT	eqvl_value FROM	am_uom_eqvl	WHERE uom_code =? AND eqvl_uom_code=? UNION  SELECT eqvl_value/EQVL_UOM_QTY eqvl_value FROM	MM_ITEM_UOM_DEFN WHERE uom_code =? AND eqvl_uom_code=? AND item_code =? union select 1 from dual where ?=?",new String[]{requisitionIssueDetailBean.getUomCode(), iss_default_uom,requisitionIssueDetailBean.getUomCode(), iss_default_uom,requisitionIssueDetailBean.getItem_code(),requisitionIssueDetailBean.getUomCode(), iss_default_uom}).get("EQVL_VALUE");
					    //setting Issue conv.factor
						requisitionIssueDetailBean.setIssConvFact(iss_conv_value);
					}
					
					//String reqqty  = requisitionIssueDetailBean.getReq_item_qty();
					//added for ML-MMOH-SCF-1013 START
					String am_count=((String)fetchRecord("SELECT  eqvl_value  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{requisitionIssueDetailBean.getUomCode(), requisitionIssueDetailBean.getPurUomCode()}).get("EQVL_VALUE"));
					am_count=checkForNull(am_count,"1");
					//added for ML-MMOH-SCF-1013 END
					
                    String reqqty  = requisitionIssueDetailBean.getPending_item_qty();
					//String issconv = checkForNull(requisitionIssueDetailBean.getIssConvFact(),"0");
                    
                   
					String issconv = checkForNull(requisitionIssueDetailBean.getIssConvFact(),"1");
				//	double conv = getConvFactTemp1(requisitionIssueDetailBean.getItem_code(), requisitionIssueDetailBean.getStore_code());//added for ml-mmoh-crf-1200//COMMENTED FOR 15757
					 
					 //ADDED FOR ML-MMOH-0979 START
				/*	if((Double.parseDouble(reqqty))<(Double.parseDouble(issconv))){
						 issuomqty  = (Double.parseDouble(reqqty)) ;
						 System.out.println("issuomqty 1: "+ issuomqty); 
					}
					else{*/ //commented for ml-mmoh-scf-1013
					 
					 //added for ML-MMOH-SCF-1013 start 
					/* if(!(requisitionIssueDetailBean.getPurUomCode().equalsIgnoreCase(requisitionIssueDetailBean.getUomCode()))){
						 
						 if((requisitionIssueDetailBean.getIssUomCode().equalsIgnoreCase(requisitionIssueDetailBean.getUomCode()))){
							 
							 issuomqty = (Double.parseDouble(reqqty)) ; 
						 }
						
						 else{
								 issuomqty = (Double.parseDouble(reqqty)) * Double.parseDouble(am_count);	 
						 }
					 }
					 else{
						 issuomqty  = ((Double.parseDouble(reqqty)) /(Double.parseDouble(issconv)));	
					 }*/ //COMMENTED FOR ML-MMOH-CRF-1200
					 
					 //added for ML-MMOH-SCF-1013 END 	  
					//}   commnted for ml-mmoh-scf-1013
					 issuomqty = (Double.parseDouble(reqqty)) / (Double.parseDouble(issconv));	//added for ML-MMOH-CRF-1200
					String iss_qty = issuomqty+"";
					System.out.println("iss_qty: "+iss_qty); //	//ADDED FOR ML-MMOH-0979 END
				
					requisitionIssueDetailBean.setIssUomQty(iss_qty);


					double auth_int = issuomqty * (Double.parseDouble(issconv));
					String auth_qty = auth_int+"";
					requisitionIssueDetailBean.setIssuing_item_qty(auth_qty);
					
				}catch(Exception e){
						requisitionIssueDetailBean.setIssUomCode("");
						requisitionIssueDetailBean.setIssConvFact("");
						requisitionIssueDetailBean.setIssUomQty("");
						e.printStackTrace();
						throw new Exception("NO_CONV_FAC_FOR_ISS_UOM_CODE");
					}
				}
				//code ended....
				key = requisitionIssueDetailBean.getItem_code();
				if (key != null && key.trim() != "") {
					hmItemDetail.put(key,requisitionIssueDetailBean);
					itemKeys.add(key);
				}
				key = null;
			arTempCode.add(requisitionIssueDetailBean.getItem_code());
			arTempDesc.add(requisitionIssueDetailBean.getItem_desc());
			String temp = "";
			for (int k=0;k<arTempDesc.size(); k++ ) {
				for (int j=0;j<arTempDesc.size()-1; j++ ) {
					if ( ((String)(arTempDesc.get(j))).compareTo(((String)(arTempDesc.get(j+1))))>0 ) {
						temp	=	(String)arTempDesc.get(j);
						arTempDesc.set(j,(String)arTempDesc.get(j+1));
						arTempDesc.set(j+1,temp);
						temp	=	(String)arTempCode.get(j);
						arTempCode.set(j,(String)arTempCode.get(j+1));
						arTempCode.set(j+1,temp);
					}
				}
			}
			}
			// The procedure is getting called here to load the stock availability
			setItemValues();			
			
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

	public void setItemValues() {

		
		String key = "";
		AuthorizeAtIssueStoreDetailBean authorizeAtIssueStoreDetailBean;
		String[] param = new String[7];
		
		try {
			for (int i=0;i<itemKeys.size();i++) {
				key = (String) itemKeys.get(i);
				if (key == null) {
					continue;
				}

				
				authorizeAtIssueStoreDetailBean = (AuthorizeAtIssueStoreDetailBean) hmItemDetail.get(key);
				param[0] = authorizeAtIssueStoreDetailBean.getItem_code();
				param[1] = getRequest_on_store();
				param[2] = authorizeAtIssueStoreDetailBean.getReq_item_qty();
				param[3] = "N";
				param[4] = "";
				param[5] = "";
				param[6] = getRequest_by_store();
							  
				java.util.HashMap stockValues = getStockAvailabilityStatus(param);
				authorizeAtIssueStoreDetailBean.setReq_by_qty_on_hand(checkForNull((String) stockValues.get("to_qty_on_hand"),"0"));
				authorizeAtIssueStoreDetailBean.setReq_on_qty_on_hand(checkForNull((String) stockValues.get("available_stock")));
				//authorizeAtIssueStoreDetailBean.setUnit_cost((String) stockValues.get("store_item_unit_cost"));
				authorizeAtIssueStoreDetailBean.setUnit_cost(String.valueOf(getBaseUnitCost((String)authorizeAtIssueStoreDetailBean.getItem_code())));
				authorizeAtIssueStoreDetailBean.setStock_item_yn((String) stockValues.get("to_stock_item_yn"));
				authorizeAtIssueStoreDetailBean.setTo_bin_location_code((String) stockValues.get("to_store_master_bin"));

				// to get the qty on hand after converting into corresponding issue uom

				double conv_fact_on_store=getConvFactTemp(authorizeAtIssueStoreDetailBean.getItem_code(),getRequest_on_store());
				//double conv_fact_on_store=convertUOMForQtyOnHand(getRequest_on_store(),authorizeAtIssueStoreDetailBean.getItem_code());
				//int conv_fact_by_store=convertUOMForQtyOnHand(getRequest_by_store(),authorizeAtIssueStoreDetailBean.getItem_code());
				double converted_qty_by_store=(Double.parseDouble(authorizeAtIssueStoreDetailBean.getReq_by_qty_on_hand()));
				//int converted_qty_by_store=(Integer.parseInt(authorizeAtIssueStoreDetailBean.getReq_by_qty_on_hand())/conv_fact_by_store);
				double converted_qty_on_store=(Double.parseDouble(authorizeAtIssueStoreDetailBean.getReq_on_qty_on_hand())/conv_fact_on_store);
				//int converted_qty=(Integer.parseInt(authorizeAtIssueStoreDetailBean.getReq_by_qty_on_hand())/conv_fact_by_store);
				setReq_by_on_qty((String)authorizeAtIssueStoreDetailBean.getReq_by_qty_on_hand());
				authorizeAtIssueStoreDetailBean.setReq_by_qty_on_hand(String.valueOf(converted_qty_by_store));
				authorizeAtIssueStoreDetailBean.setReq_on_qty_on_hand(String.valueOf(converted_qty_on_store));
				

			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		//return;
	}

	/* Commented PE
	public double convertUOMForQtyOnHand(String store_code,String item_code)
	{
		//AuthorizeAtIssueStoreDetailBean authorizeAtIssueStoreDetailBean =new AuthorizeAtIssueStoreDetailBean() ;
		
		Connection connection = null;
        PreparedStatement pstmt,pstmt1 = null;
        ResultSet resultSet,resultSet1 = null;
		
		String gen_uom_code="";
		double conv_factor =1;
		try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_GEN_UOM_CODE_SELECT"));
            pstmt.setString(1, item_code);
            pstmt.setString(2, getLanguageId());
            resultSet = pstmt.executeQuery();
		   resultSet.next();

				gen_uom_code = resultSet.getString("GEN_UOM_CODE");
				
			
			 pstmt1 = connection.prepareStatement("SELECT EQVL_VALUE/EQVL_UOM_QTY CONV_FACTOR  FROM MM_ITEM_UOM_DEFN WHERE UOM_CODE = ? AND EQVL_UOM_CODE= (SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE= ? AND ITEM_CODE=  ?) AND ITEM_CODE = ? UNION SELECT	eqvl_value FROM	am_uom_eqvl	WHERE uom_code = ? AND eqvl_uom_code= (SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=?");
            pstmt1.setString(1, gen_uom_code);
            pstmt1.setString(2, store_code);
            pstmt1.setString(3,item_code);
            pstmt1.setString(4,item_code);
			pstmt1.setString(5, gen_uom_code);
			pstmt1.setString(6, store_code);
            pstmt1.setString(7, item_code);
			resultSet1 = pstmt1.executeQuery();
             resultSet1.next();

				conv_factor = resultSet1.getInt("CONV_FACTOR");
				
				
			
			closeResultSet(resultSet);
			closeResultSet(resultSet1);
			closeStatement(pstmt1);
			closeStatement(pstmt);
			closeConnection(connection);
		}
		catch(Exception e)
		{}

			return conv_factor;		
	}*/


	public java.util.HashMap updateItemDetailRecord(java.util.Hashtable itemRecord) {
		java.util.HashMap resultMap = new java.util.HashMap();
		resultMap.put("result", new Boolean(true));
		//commented by Rabbani on 08/12/11
		//resultMap.put("message", "success");
		resultMap.put("message","SUCCESS");
		String item_code = (String) itemRecord.get("item_code");
		String issuing_qty_entered = (String) itemRecord.get("issuing_qty");
		setRequest_on_store((String)itemRecord.get("request_on_store_code"));
		setRequest_by_store((String)itemRecord.get("request_by_store_code"));
		//System.out.println("getCloseRemarksDesc in AuthAtIssueStoreBean.java: "+getCloseRemarksDesc());  //MO-CRF-20173 
		String closeRemarksDesc = "";
		closeRemarksDesc = getCloseRemarksDesc();  
		try {
			java.util.ArrayList sqlParameter = new java.util.ArrayList ();
			sqlParameter.add(itemRecord.get("request_on_store_code"));
			sqlParameter.add(itemRecord.get("item_code"));
//			java.util.HashMap availItem = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_BATCH_AVAIL_SELECT"),sqlParameter);
//			String avail = (String) availItem.get("AVAIL_QTY");
			//int avail_qty = -1;
			//if (avail != null && ((avail = avail.trim()) != "")) {
			//	avail_qty = Integer.parseInt(avail);
//			}
/*			if (avail_qty < Integer.parseInt(issuing_qty_entered)) {
				resultMap.put("message","REQ_QTY_NOT_GR_PEND_QTY1");
				resultMap.put("result",new Boolean(false));
				return resultMap;
			}
*/
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		AuthorizeAtIssueStoreDetailBean requisitionIssueDetailBean = (AuthorizeAtIssueStoreDetailBean) hmItemDetail.get(item_code);
		requisitionIssueDetailBean.setIssuing_item_qty(issuing_qty_entered);
		//code added for Issue UOM... 2/7/2004
		requisitionIssueDetailBean.setIssUomCode((String)itemRecord.get("iss_uom_code"));
		requisitionIssueDetailBean.setIssConvFact((String)itemRecord.get("iss_conv_fact"));
		requisitionIssueDetailBean.setIssUomQty((String)itemRecord.get("iss_uom_qty"));

		requisitionIssueDetailBean.setPurUomCode(checkForNull((String)itemRecord.get("pur_uom_code")));
		requisitionIssueDetailBean.setReqConvFact(checkForNull((String)itemRecord.get("req_conv_fact")));
		requisitionIssueDetailBean.setReqUomQty(checkForNull((String)itemRecord.get("req_uom_qty")));
		requisitionIssueDetailBean.setReq_item_qty((String)itemRecord.get("req_item_qty"));

		requisitionIssueDetailBean.setUomCode((String)itemRecord.get("uom"));
		requisitionIssueDetailBean.setRemarksCode((String)itemRecord.get("remarks_code"));
		requisitionIssueDetailBean.setRemarksDesc((String)itemRecord.get("remarks_desc"));
		requisitionIssueDetailBean.setIssConvText(checkForNull((String) itemRecord.get("iss_conv_text")));
		requisitionIssueDetailBean.setReqConvText(checkForNull((String) itemRecord.get("req_conv_text")));
		
		requisitionIssueDetailBean.setFromMultiples((String)itemRecord.get("from_multiples"));
		requisitionIssueDetailBean.setToMultiples((String)itemRecord.get("to_multiples"));
		requisitionIssueDetailBean.setBatchMultiples((String)itemRecord.get("batch_multiples"));
		requisitionIssueDetailBean.setIssueUOMMultiples((String)itemRecord.get("issue_uom_multiples"));
		requisitionIssueDetailBean.setReqBatchMultiples((String)itemRecord.get("req_batch_multiples"));
		requisitionIssueDetailBean.setReqUOMMultiples((String)itemRecord.get("req_uom_multiples"));
		requisitionIssueDetailBean.setClose_item_yn(checkForNull((String)itemRecord.get("close_item")));  //MO-CRF-20173  
		requisitionIssueDetailBean.setCloseRemarksDesc(closeRemarksDesc);  
		updateCloseItemYN(item_code, checkForNull((String)itemRecord.get("close_item")));  
		String str = ""; 
//		boolean closeResult = false;  //COMMON-ICN-0118
		int j = 0;
		int itemSize=0;
		itemSize = addedItemKeys.size() + getItemKeys().size();
		if(closeItemMap.size() == itemSize ){
			
		//	System.out.println("getCloseItemList: "+getCloseItemList());  
			for(int i=0;i<getCloseItemList().size();i++){
				 str =(String) getCloseItemList().get(i);
				 if(str.equals("Y")){
					// System.out.println("close value is true");  
					 j++;
				 }
			}
			if(getCloseItemList().size() == j ){
				//System.out.println("All values are Y");
				updateCloseItemYN(item_code, "N"); //26677
				requisitionIssueDetailBean.setClose_item_yn("N");  //TFS:26677
				resultMap.put("result", new Boolean(false));
				resultMap.put("message", "TRANSACTION_ONE_RECORD");
				return resultMap;
			} 
		}//MO-CRF-20173 END 
	
		
		checkSeverity(requisitionIssueDetailBean,issuing_qty_entered);

		hmItemDetail.put(item_code,requisitionIssueDetailBean);
		return resultMap;
	}

	public java.util.HashMap addItemDetailRecord(java.util.Hashtable itemRecord) {
		java.util.HashMap resultMap = new java.util.HashMap();
		if (addedItemKeys == null) {
			addedItemKeys = new java.util.ArrayList ();
		}
		String item_code = (String) itemRecord.get("item_code");
		if (addedItemKeys.contains(item_code)) {
			resultMap.put("result", new Boolean(false));
			resultMap.put("message", "ITEM_CODE_ALREADY_EXIST");
			return resultMap;
		}							 										 		
		setRequest_on_store((String)itemRecord.get("request_on_store_code"));
		setRequest_by_store((String)itemRecord.get("request_by_store_code"));
//		String [] params={item_code,getRequest_by_store(),"0","N","","N",getRequest_on_store()};
/*		try {
			HashMap hashStock=getStockAvailabilityStatus(params);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}*/
		
		resultMap.put("result", new Boolean(true));
		//commented by Rabbani on 08/12/11
		//resultMap.put("message", "success");
        resultMap.put("message", "SUCCESS");		
		AuthorizeAtIssueStoreDetailBean requisitionIssueDetailBean = new AuthorizeAtIssueStoreDetailBean();
		requisitionIssueDetailBean.setItem_code ((String)itemRecord.get("item_code"));
		requisitionIssueDetailBean.setItem_desc((String)itemRecord.get("item_desc"));
		requisitionIssueDetailBean.setReq_item_qty((String)itemRecord.get("req_item_qty"));
		requisitionIssueDetailBean.setIssuing_item_qty((String)itemRecord.get("issuing_qty"));
		requisitionIssueDetailBean.setStock_item_yn((String)itemRecord.get("stock_item_yn"));

		//code added for displaying UOM Details..
		requisitionIssueDetailBean.setPurUomCode(checkForNull((String)itemRecord.get("pur_uom_code")));	requisitionIssueDetailBean.setReqConvFact(checkForNull((String)itemRecord.get("req_conv_fact")));	requisitionIssueDetailBean.setReqUomQty(checkForNull((String)itemRecord.get("req_uom_qty")));


		requisitionIssueDetailBean.setIssUomCode(checkForNull((String)itemRecord.get("iss_uom_code")));		requisitionIssueDetailBean.setIssConvFact(checkForNull((String)itemRecord.get("iss_conv_fact")));
		requisitionIssueDetailBean.setIssUomQty(checkForNull((String)itemRecord.get("iss_uom_qty")));
		
		requisitionIssueDetailBean.setUomCode(checkForNull((String)itemRecord.get("uom")));
		requisitionIssueDetailBean.setUom_desc(checkForNull((String)itemRecord.get("uom_desc")));
		requisitionIssueDetailBean.setRemarksCode((String)itemRecord.get("remarks_code"));
		requisitionIssueDetailBean.setRemarksDesc((String)itemRecord.get("remarks_desc"));
		requisitionIssueDetailBean.setIssConvText(checkForNull((String) itemRecord.get("iss_conv_text")));
		requisitionIssueDetailBean.setReqConvText(checkForNull((String) itemRecord.get("req_conv_text")));
    
		//requisitionIssueDetailBean.setRemarksDescNew("ABC");
		requisitionIssueDetailBean.setKit_template_uom((String)itemRecord.get("kit_template_uom"));
		requisitionIssueDetailBean.setKit_item_yn((String)itemRecord.get("kit_item_yn"));
	
		requisitionIssueDetailBean.setFromMultiples((String)itemRecord.get("from_multiples"));
		requisitionIssueDetailBean.setToMultiples((String)itemRecord.get("to_multiples"));
		requisitionIssueDetailBean.setBatchMultiples((String)itemRecord.get("batch_multiples"));
		requisitionIssueDetailBean.setIssueUOMMultiples((String)itemRecord.get("issue_uom_multiples"));
		requisitionIssueDetailBean.setReqBatchMultiples((String)itemRecord.get("req_batch_multiples"));
		requisitionIssueDetailBean.setReqUOMMultiples((String)itemRecord.get("req_uom_multiples"));
		requisitionIssueDetailBean.setClose_item_yn(checkForNull((String)itemRecord.get("close_item")));  //MO-CRF-20173   
		requisitionIssueDetailBean.setCloseRemarksDesc(getCloseRemarksDesc());//MO-CRF-20173   
		updateCloseItemYN(item_code, checkForNull((String)itemRecord.get("close_item")));  //27496
		//requisitionIssueDetailBean.setCloseRemarksDesc();
		//code ended...
		java.util.ArrayList sqlParameter = new java.util.ArrayList ();
		sqlParameter.add(itemRecord.get("request_on_store_code"));
		sqlParameter.add(itemRecord.get("item_code"));
/*		try {
//			java.util.HashMap availItem = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_BATCH_AVAIL_SELECT"),sqlParameter);
			//String required_qty = (String)itemRecord.get("required_qty");
//			String required_qty = (String)itemRecord.get("issuing_qty");
//			String avail = (String) availItem.get("AVAIL_QTY");
//			int avail_qty = -1;
//			if (avail != null && ((avail = avail.trim()) != "")) {
//				avail_qty = Integer.parseInt(avail);
//			}
/*			if (avail_qty < Integer.parseInt(required_qty)) {
				resultMap.put("message","REQ_QTY_NOT_GR_PEND_QTY2");
				resultMap.put("result",new Boolean(false));
				return resultMap;
			}

		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
*/
		java.util.ArrayList param = new java.util.ArrayList ();
		/*param.add(getRequest_by_store());
		param.add(getRequest_on_store());
		param.add(itemRecord.get("item_code"));
		param.add(getLanguageId());*/
		try {
/*			java.util.ArrayList param = new java.util.ArrayList ();
			String bystoreUom[] = {(String)details.get("request_by_store_code"),(String)details.get("item_code")};
			String onstoreUom[] = {(String)details.get("request_on_store_code"),(String)details.get("item_code")};
			param.add(details.get("request_by_store_code"));
			param.add(details.get("request_on_store_code"));
			param.add(details.get("item_code"));
			param.add(getLanguageId());
			param.add(getGenItemUOM((String)details.get("item_code")));
			java.util.HashMap byStoreUOM=fetchRecord("SELECT DEF_ISSUE_UOM UOM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=?",bystoreUom);
			param.add((String)byStoreUOM.get("UOM_CODE"));
			param.add(getGenItemUOM((String)details.get("item_code")));
			java.util.HashMap onStoreUOM=fetchRecord("SELECT DEF_ISSUE_UOM UOM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=?",onstoreUom);
			param.add((String)onStoreUOM.get("UOM_CODE"));
//			java.util.HashMap dataValue = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DETAIL_SELECT"),param);
			java.util.HashMap dataValue = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DETAIL_SELECT1"),param);

*/			
			
			String bystoreUom[] = {getRequest_by_store(),(String)itemRecord.get("item_code")};
			String onstoreUom[] = {getRequest_on_store(),(String)itemRecord.get("item_code")};
			param.add(""+getConvFactTemp((String)itemRecord.get("item_code"),(String)getRequest_by_store()));
			param.add(""+getConvFactTemp((String)itemRecord.get("item_code"),(String)getRequest_on_store()));
			param.add(getRequest_by_store());
			param.add(getRequest_on_store());
			param.add(itemRecord.get("item_code"));
			param.add(getLanguageId());
			param.add(getGenItemUOM((String)itemRecord.get("item_code")));
			java.util.HashMap byStoreUOM=fetchRecord("SELECT DEF_ISSUE_UOM UOM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=?",bystoreUom);
			param.add(checkForNull((String)byStoreUOM.get("UOM_CODE")));
			param.add(getGenItemUOM((String)itemRecord.get("item_code")));
			java.util.HashMap onStoreUOM=fetchRecord("SELECT DEF_ISSUE_UOM UOM_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=?",onstoreUom);
			param.add((String)onStoreUOM.get("UOM_CODE"));
//			java.util.HashMap dataValue = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DETAIL_SELECT"),param);
			//java.util.HashMap dataValue = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DETAIL_SELECT1"),param);
			java.util.HashMap dataValue = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DETAIL_SELECT1"),param);
			//java.util.HashMap dataValue = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_DETAIL_SELECT"),param);
		//	requisitionIssueDetailBean.setReq_on_qty_on_hand((String)dataValue.get("REQ_BY_QTY_ON_HAND"));
		//	requisitionIssueDetailBean.setReq_by_qty_on_hand((String)dataValue.get("REQ_ON_QTY_ON_HAND"));
	//	Modified on 09/07/2004...
			arTempCode.add((String)itemRecord.get("item_code"));
			arTempDesc.add((String)dataValue.get("ITEM_DESC"));
			String temp = "";
			for (int k=0;k<arTempDesc.size(); k++ ) {
				for (int j=0;j<arTempDesc.size()-1; j++ ) {
					if ( checkForNull((String)(arTempDesc.get(j))).compareTo(checkForNull((String)(arTempDesc.get(j+1))))>0 ) {
						temp	=	(String)arTempDesc.get(j);
						arTempDesc.set(j,(String)arTempDesc.get(j+1));
						arTempDesc.set(j+1,temp);
						temp	=	(String)arTempCode.get(j);
						arTempCode.set(j,(String)arTempCode.get(j+1));
						arTempCode.set(j+1,temp);
					}
				}
			}
			String[] strParameters = new String[7];
			strParameters[0] = item_code;
			strParameters[1] = (String)getRequest_on_store();
			strParameters[2] = "0";
			strParameters[3] = "N";
			strParameters[4] = "";//stHeaderBean.getSysDate();
			strParameters[5] = "N";
			strParameters[6] = (String)getRequest_by_store();

			java.util.HashMap stockValues = getStockAvailabilityStatus(strParameters);
			requisitionIssueDetailBean.setReq_by_qty_on_hand(checkForNull((String) stockValues.get("to_qty_on_hand"),"0"));
			double qty_on_store = Double.parseDouble(checkForNull((String) stockValues.get("available_stock")))/getConvFactTemp((String)itemRecord.get("item_code"),(String)getRequest_on_store());
			requisitionIssueDetailBean.setReq_on_qty_on_hand(""+qty_on_store);

			setReq_by_on_qty(checkForNull((String)dataValue.get("REQ_BY_QTY_ON_HAND"),"0"));
			//requisitionIssueDetailBean.setReq_by_qty_on_hand(checkForNull((String)dataValue.get("REQ_BY_QTY_ON_HAND"),"0"));
			requisitionIssueDetailBean.setReq_by_max_stk_level(checkForNull((String)dataValue.get("REQ_BY_MAX_STK_QTY")));
			requisitionIssueDetailBean.setReq_by_min_stk_level(checkForNull((String)dataValue.get("REQ_BY_MIN_STK_QTY")));
			requisitionIssueDetailBean.setReq_by_reorder_level(checkForNull((String)dataValue.get("REQ_BY_REORDER_LEVEL")));
			//requisitionIssueDetailBean.setReq_on_qty_on_hand(checkForNull((String)dataValue.get("REQ_ON_QTY_ON_HAND"),"0"));
			requisitionIssueDetailBean.setReq_on_max_stk_level(checkForNull((String)dataValue.get("REQ_ON_MAX_STK_QTY")));
			requisitionIssueDetailBean.setReq_on_min_stk_level(checkForNull((String)dataValue.get("REQ_ON_MIN_STK_QTY")));
			requisitionIssueDetailBean.setReq_on_reorder_level(checkForNull((String)dataValue.get("REQ_ON_REORDER_LEVEL")));

			requisitionIssueDetailBean.setReq_on_reorder_level((String)dataValue.get("REQ_ON_REORDER_LEVEL"));
			requisitionIssueDetailBean.setCurr_pack_size((String)dataValue.get("CURR_PACK_SIZE"));
		//	requisitionIssueDetailBean.setStock_item_yn((String)dataValue.get("STOCK_ITEM_YN")); //	--- Commented by Padmapriya On 08/02/2011 
		requisitionIssueDetailBean.setStock_item_yn((String)stockValues.get("to_stock_item_yn")); // --- Added by Padmapriya On 08/02/2011
			/**
			 * @Name - Priya
			 * @Date - 23/06/2010
			 * @Inc# - 20890
			 * @Desc -  To get the Store Level Unit Cost
			 */
			//requisitionIssueDetailBean.setUnit_cost((String)dataValue.get("UNIT_COST"));
			//requisitionIssueDetailBean.setUnit_cost((String)stockValues.get("store_item_unit_cost"));
			requisitionIssueDetailBean.setUnit_cost(String.valueOf(getBaseUnitCost((String)itemRecord.get("item_code"))));
			requisitionIssueDetailBean.setTo_bin_location_code((String)dataValue.get("TO_BIN_LOCATION_CODE"));
			//requisitionIssueDetailBean.setUom_desc((String)dataValue.get("UOM_DESC"));
			requisitionIssueDetailBean.setPending_item_qty("0");
			//checkSeverity(requisitionIssueDetailBean,(String)itemRecord.get("required_qty"));
			checkSeverity(requisitionIssueDetailBean,(String)itemRecord.get("issuing_qty"));
			hmItemDetail.put(item_code,requisitionIssueDetailBean);
			addedItemKeys.add(item_code);
		}
		catch (Exception exception) {
			hmItemDetail.put(item_code,requisitionIssueDetailBean);
			addedItemKeys.add(item_code);
			exception.printStackTrace();
		}
		return resultMap;
	}

	public void  checkSeverity(AuthorizeAtIssueStoreDetailBean requisitionIssueDetailBean,String required_qty) {
//		int req_on_max_qty = 0;
		double req_on_min_qty = 0;
		int req_on_reorder_level = 0;
	//	int req_item_qty = Integer.parseInt(required_qty);
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REQUEST_ISSUE_SEVERITY_SELECT"));
            pstmt.setString(1, getRequest_on_store());
            pstmt.setString(2, requisitionIssueDetailBean.getItem_code());
            resultSet = pstmt.executeQuery();
            if (resultSet != null && resultSet.next()) {
//				req_on_max_qty = resultSet.getInt("req_on_max_stk_qty");
				req_on_min_qty = resultSet.getInt("req_on_min_stk_qty");
				req_on_reorder_level = resultSet.getInt("req_on_reorder_level");
			}
			closeResultSet(resultSet);
			closeStatement(pstmt);
			closeConnection(connection);

			String qty_on_hand_from_bean = requisitionIssueDetailBean.getReq_on_qty_on_hand() != null?requisitionIssueDetailBean.getReq_on_qty_on_hand():"0";
			String committed_item_qty_from_bean = requisitionIssueDetailBean.getCommitted_item_qty() != null?requisitionIssueDetailBean.getCommitted_item_qty():"0";
			String issuing_qty_from_bean = requisitionIssueDetailBean.getIssuing_item_qty() != null ? requisitionIssueDetailBean.getIssuing_item_qty():"0";
			double avilable_qty_on_req_on_store = Double.parseDouble(qty_on_hand_from_bean) - Double.parseDouble(committed_item_qty_from_bean);
			double issue_qty = Double.parseDouble(issuing_qty_from_bean);
			double avail_store = avilable_qty_on_req_on_store*getConvFactTemp((String)requisitionIssueDetailBean.getItem_code(),(String)getRequest_on_store());
			req_on_min_qty = req_on_min_qty*getConvFactTemp((String)requisitionIssueDetailBean.getItem_code(),(String)getRequest_on_store());
			//if ((avilable_qty_on_req_on_store - issue_qty) < req_on_min_qty) {
			if ((avail_store - issue_qty) < req_on_min_qty) {
				requisitionIssueDetailBean.setSeverity_color("HIGH");
			}
			//else if((avilable_qty_on_req_on_store - issue_qty) < req_on_reorder_level) {
			else if((avail_store - issue_qty) < req_on_reorder_level) {
				requisitionIssueDetailBean.setSeverity_color("LOW");
			}	
			else {
				requisitionIssueDetailBean.setSeverity_color("NORMAL");
			}
        } 
		catch (Exception e) {
            e.printStackTrace();
        } 
	}

	public java.util.HashMap insert() {
		HashMap hmResult = new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		//ArrayList alInsertData = new ArrayList();
		java.util.Properties properties = getProperties();

		AuthorizeAtIssueStoreDetailBean authorizeAtIssueStoreDetailBean ;
		hmResult.put("result", new Boolean(false));
		seq_no = 1;
		int flag= 1;

	
		ArrayList alHdrInsertRecord = new ArrayList();
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(getDoc_type_code());
		alHdrInsertRecord.add(getDoc_no());
		
		alHdrInsertRecord.add(""+seq_no);
		alHdrInsertRecord.add(getDoc_date_value());
		alHdrInsertRecord.add(getDoc_ref());

	

		alHdrInsertRecord.add(getRequest_on_store());
		alHdrInsertRecord.add(getRequest_by_store());
		alHdrInsertRecord.add("N");	  // finalized_yn
		alHdrInsertRecord.add("N");	  // gl_interfaced_yn
		alHdrInsertRecord.add("ISS");
		alHdrInsertRecord.add("Y"); //entry completed ?
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(checkForNull(getClose_req_after_issue_yn(),"N"));
		//alHdrInsertRecord.add(checkForNull(getRemarks(),""));
		alHdrInsertRecord.add(checkForNull(getRemarks_code(),""));//18/06/12
		
        alHdrInsertRecord.add(checkForNull(getItem_class_code()));
	
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);


		/* Request related insert*/

		ArrayList alReqHdrInsertRecord = new ArrayList();
		alReqHdrInsertRecord.add(login_facility_id);
		alReqHdrInsertRecord.add(getDoc_type_code());
		alReqHdrInsertRecord.add(getDoc_no());
		alReqHdrInsertRecord.add(getDoc_date_value());
		alReqHdrInsertRecord.add(getDoc_ref());
		alReqHdrInsertRecord.add(getItem_class_code());
		alReqHdrInsertRecord.add(""+seq_no);

		/*if(getClose_req_after_issue_yn().equals("Y"))
			alReqHdrInsertRecord.add("L");
		else*/
	//	alReqHdrInsertRecord.add("A");  // -- Commented by Padmapriya On 03/02/2012
	
	//Start added cancelled_by_id and cancelled_remarks by Padmapriya On 31/1/2012
		//String cancelled_by_id = "";   //commented by Rabbani on 24-Mar-2014 for chkstyles
		//String cancelled_remarks = (String)	getRemarks(); //commented by Rabbani #inc no:33352
		//String cancelled_remarks = (String)	getRemarks_code();//18/06/12 //commented by Rabbani on 24-Mar-2014 for chkstyles
		
		if(getClose_req_after_issue_yn().equals("Y")){
			//alReqHdrInsertRecord.add(login_by_id);  
			alReqHdrInsertRecord.add("");  
			alReqHdrInsertRecord.add("");  
			//alReqHdrInsertRecord.add(cancelled_remarks); 
			alReqHdrInsertRecord.add("L");
			}
		else{
		//alReqHdrInsertRecord.add(cancelled_by_id);  
		alReqHdrInsertRecord.add("");  
		alReqHdrInsertRecord.add("");  
		//alReqHdrInsertRecord.add(cancelled_remarks);	   
		alReqHdrInsertRecord.add("A");
		}
		//end by Padmapriya On 31/1/2012
	
		
		//else if( Integer.parseInt((String)authorizeAtIssueStoreDetailBean.getReq_item_qty()) == Integer.parseInt((String)authorizeAtIssueStoreDetailBean.getIssuing_item_qty())  )
		//	alReqHdrInsertRecord.add("C");
		
		alReqHdrInsertRecord.add(getRequest_by_store());
		alReqHdrInsertRecord.add(getRequest_on_store());
		alReqHdrInsertRecord.add(login_by_id);
		alReqHdrInsertRecord.add(login_by_id);
		alReqHdrInsertRecord.add("ISS");
		alReqHdrInsertRecord.add(login_by_id);
		alReqHdrInsertRecord.add(login_at_ws_no);
		alReqHdrInsertRecord.add(login_facility_id);
		alReqHdrInsertRecord.add(login_by_id);
		alReqHdrInsertRecord.add(login_at_ws_no);
		alReqHdrInsertRecord.add(login_facility_id);


		int detailSize = addedItemKeys.size();
		int doc_srl_no = 0;
		ArrayList alDtlInsertRecord = new ArrayList(detailSize);
		ArrayList alItemBtachUpdateRecord = new ArrayList();
		ArrayList alDtlExpInsertRecord = new ArrayList();
		ArrayList alReqDtlInsertRecord = new ArrayList();
		ArrayList expRecords		   = new ArrayList();

		for (int index=0;index<detailSize;index++) {
			doc_srl_no = doc_srl_no + 1;
			if((addedItemKeys.get(index) == null) || (addedItemKeys.get(index).equals(""))) {
					continue;
			}
			authorizeAtIssueStoreDetailBean = (AuthorizeAtIssueStoreDetailBean) hmItemDetail.get(addedItemKeys.get(index));

			/* NOTE :  the item_cost_value is calculated by using the req_item_qty and unit_cost 
			*/
			//double item_cost_value = Integer.parseInt(authorizeAtIssueStoreDetailBean.getReq_item_qty()) * Double.parseDouble(authorizeAtIssueStoreDetailBean.getUnit_cost());
			double item_cost_value = (Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty())/(getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_on_store()))) * Double.parseDouble(checkForNull(authorizeAtIssueStoreDetailBean.getUnit_cost(),"0"));
			ArrayList alDtlRecord = new ArrayList(18);
			ArrayList alReqDtlRecord = new ArrayList();
			try {
					alDtlRecord.add(login_facility_id);
					alDtlRecord.add(getDoc_type_code());
					alDtlRecord.add(getDoc_no());
					alDtlRecord.add(""+seq_no);
					alDtlRecord.add(""+doc_srl_no);
					alDtlRecord.add(getRequest_on_store());
					alDtlRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());
					/*
					* iss_item_qty is inserted as 0
					*/
					alDtlRecord.add("0");
					//alDtlRecord.add(authorizeAtIssueStoreDetailBean.getUnit_cost());
					/* @Name - Priya
					* @Date - 27/05/2010
					* @Inc# - 
					* @Desc - item cost_value is rounded with noOfDecimalsForCost
					*/
					//alDtlRecord.add(setNumber(""+item_cost_value,3));
					int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
					alDtlRecord.add(setNumber(authorizeAtIssueStoreDetailBean.getUnit_cost(),noOfDecimalsForCost));
					alDtlRecord.add(setNumber(""+item_cost_value,noOfDecimalsForCost));
					alDtlRecord.add("N");
					alDtlRecord.add(authorizeAtIssueStoreDetailBean.getStock_item_yn());
					/**
					* The req_item_qty is used to insert the value for authorized_item_qty 
					*/ 
					//alDtlRecord.add(authorizeAtIssueStoreDetailBean.getReq_item_qty());
//Added By Mahesh To arrive iss_item_qty for st_issue_dtl in stock uom uncomment this line if any problems in iss_item_qty
					//alDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssuing_item_qty());
					double iss_item_qty = Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty())/getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_on_store());
					alDtlRecord.add(""+iss_item_qty);
					alDtlRecord.add(login_by_id);
					alDtlRecord.add(login_at_ws_no);
					alDtlRecord.add(login_facility_id);
					alDtlRecord.add(login_by_id);
					alDtlRecord.add(login_at_ws_no);
					alDtlRecord.add(login_facility_id);
					//code added for inserting Issue uom,conv.factor.Issue Qty on 2/7/2004...
					alDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssUomCode());
					alDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssConvFact());
					alDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssUomQty());
					
				
					// code ended...
					if (Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty()) > 0)
					{
					flag=0;
					alDtlInsertRecord.add(alDtlRecord);
					
					


					/* Request related insert*/

					alReqDtlRecord.add(login_facility_id);
					alReqDtlRecord.add(getDoc_type_code());
					alReqDtlRecord.add(getDoc_no());
					alReqDtlRecord.add(""+doc_srl_no);
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getReq_item_qty());
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getStock_item_yn());
					double pending_qty =0;
					pending_qty = Double.parseDouble(authorizeAtIssueStoreDetailBean.getReq_item_qty())/getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_by_store());
					double comm_qty = Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty())/getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_by_store());

					//alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssuing_item_qty()); // commited_item_qty
					alReqDtlRecord.add(""+comm_qty); // commited_item_qty
					
					alReqDtlRecord.add(""+pending_qty);
					
					alReqDtlRecord.add(login_by_id);
					alReqDtlRecord.add(login_at_ws_no);
					alReqDtlRecord.add(login_facility_id);
					alReqDtlRecord.add(login_by_id);
					alReqDtlRecord.add(login_at_ws_no);
					alReqDtlRecord.add(login_facility_id);
					//code added for RequestUOM,RequestQty,Conv.factor 2/7/2004...
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getPurUomCode());
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getReqConvFact());
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getReqUomQty());
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getRemarksCode());
					//code ended....
					alReqDtlInsertRecord.add(alReqDtlRecord);

					}
					StUtilities stUtilities = new StUtilities(properties);

					HashMap hmParameters	=	new HashMap();
					hmParameters.put("ITEM_CODE",authorizeAtIssueStoreDetailBean.getItem_code());
					hmParameters.put("STORE_CODE",getRequest_on_store());
					//hmParameters.put("TRN_QTY",authorizeAtIssueStoreDetailBean.getReq_item_qty());
					hmParameters.put("TRN_QTY",authorizeAtIssueStoreDetailBean.getIssuing_item_qty());
					hmParameters.put("INCLUDE_SUSPENDED","FALSE");//optional, by default FALSE
					hmParameters.put("INCLUDE_EXPIRED","FALSE");//optional, by default FALSE
					hmParameters.put("VERIFY_INSUFFICIENT_QTY","TRUE");//optional, by default TRUE
					stUtilities.setLanguageId(getLanguageId());
					stUtilities.setLoginById(getLoginById());//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
					//System.out.println("HMparameters = > "+hmParameters);
					java.util.HashMap dataValue = stUtilities.getBatches(hmParameters);
					//System.out.println("dataValue = > "+dataValue);
					java.util.ArrayList expBatchDetails = (ArrayList) dataValue.get("BATCH_DATA");
					if (Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty()) >0 )
					{
					expRecords.add(""+expBatchDetails.size());
					
					ArrayList params = null;
					String barcode_id = "";
					
					for (int cnt=0; cnt<expBatchDetails.size();cnt++) {
						java.util.ArrayList alDtlExpRecord = new java.util.ArrayList(17);
						java.util.HashMap tempExpBatchDtl =  (java.util.HashMap) expBatchDetails.get(cnt);
						alDtlExpRecord.add(login_facility_id);
						alDtlExpRecord.add(getDoc_type_code());
						alDtlExpRecord.add(getDoc_no());
						alDtlExpRecord.add(""+(seq_no));
						alDtlExpRecord.add(""+doc_srl_no);
						alDtlExpRecord.add(getRequest_on_store());
						alDtlExpRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());
						alDtlExpRecord.add(tempExpBatchDtl.get("BATCH_ID"));
						alDtlExpRecord.add(tempExpBatchDtl.get("BIN_LOCATION_CODE"));
						alDtlExpRecord.add(tempExpBatchDtl.get("EXPIRY_DATE"));
						alDtlExpRecord.add(tempExpBatchDtl.get("QTY"));
						alDtlExpRecord.add(tempExpBatchDtl.get("TRADE_ID"));
						alDtlExpRecord.add(authorizeAtIssueStoreDetailBean.getTo_bin_location_code());
						alDtlExpRecord.add(login_by_id);
						alDtlExpRecord.add(login_at_ws_no);
						alDtlExpRecord.add(login_facility_id);
						alDtlExpRecord.add(login_by_id);
						alDtlExpRecord.add(login_at_ws_no);
						alDtlExpRecord.add(login_facility_id);
						
						//Added By Ganga for RUT-CRF-0079 On Aug 16th 2013
						if(isBarCodeApplicableForValidation("VALIDATEBARCODE","ISS")){
							params = new ArrayList();						
							
							params.add(getRequest_on_store());
							params.add(authorizeAtIssueStoreDetailBean.getItem_code());
							params.add(tempExpBatchDtl.get("BATCH_ID"));
							params.add(tempExpBatchDtl.get("BIN_LOCATION_CODE"));
							params.add(tempExpBatchDtl.get("EXPIRY_DATE"));
							
							barcode_id =(String)(fetchRecord(getStRepositoryValue("SQL_ST_ITEM_BATCH_GET_BARCODE_ID"),params).get("BARCODE_ID"));
						}
						
						alDtlExpRecord.add(checkForNull(barcode_id));
						
						//Ended
						alDtlExpInsertRecord.add(alDtlExpRecord);

						//Update Record
						java.util.ArrayList alBatchUpdRecord = new java.util.ArrayList(10);
						alBatchUpdRecord.add(tempExpBatchDtl.get("QTY"));
						alBatchUpdRecord.add(login_by_id);
						alBatchUpdRecord.add(login_at_ws_no);
						alBatchUpdRecord.add(login_facility_id);
						alBatchUpdRecord.add(getRequest_on_store());
						alBatchUpdRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());
						alBatchUpdRecord.add(tempExpBatchDtl.get("BATCH_ID"));
						alBatchUpdRecord.add(tempExpBatchDtl.get("BIN_LOCATION_CODE"));
						alBatchUpdRecord.add(tempExpBatchDtl.get("EXPIRY_DATE"));
						alItemBtachUpdateRecord.add(alBatchUpdRecord);
				}
					}
				}
				catch (InsufficientBatchException insufficient) {
 					System.out.println("Authorizebean, InsufficientBatchException = > "+insufficient.getMessage());
					hmResult.put("msgid", "INSUFFICIENT_BATCH_QTY");
					hmResult.put("message", getSTMessage(getLanguageId(),(String) hmResult.get("msgid"), "ST")) ;

					hmResult.put("flag", authorizeAtIssueStoreDetailBean.getItem_desc());
					insufficient.printStackTrace();
					return hmResult;
				}
				catch (Exception exception) {
					hmResult.put("message", exception.getMessage());
					exception.printStackTrace();
					return hmResult;
				}
			}

				if(flag==1)
				{
				hmResult.put("result", new Boolean(false));
				hmResult.put("msgid", "ISS_QTY_CANNOT_BE_ZERO");
				hmResult.put("message", getSTMessage(getLanguageId(),(String) hmResult.get("message"), "ST")) ;

			//	hmResult.put("flag", index+"");
				return hmResult;
				}

			java.util.ArrayList alUpdateData = new java.util.ArrayList (4);
			alUpdateData.add(login_by_id);
			alUpdateData.add(login_at_ws_no);
			alUpdateData.add(login_facility_id);
			alUpdateData.add(getDoc_type_code());

			java.util.ArrayList alUpdateDocData = new java.util.ArrayList ();
			alUpdateDocData.add(login_by_id);
			alUpdateDocData.add(login_at_ws_no);
			alUpdateDocData.add(login_facility_id);
			alUpdateDocData.add(getDoc_type_code());

			hmTableData.put("properties",properties);
			hmSQLMap.put("InsertHDRSQL", StRepository.getStKeyValue("SQL_ST_ISSUE_HDR_INSERT")); 

		


			hmSQLMap.put("InsertDTLSQL", StRepository.getStKeyValue("SQL_ST_ISSUE_DTL_INSERT")); 

			hmSQLMap.put("InsertReqHdrSQL", StRepository.getStKeyValue("SQL_ST_REQ_HDR_INSERT_FOR_AUTH")); 
			hmSQLMap.put("InsertReqDtlSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_INSERT")); 

			hmSQLMap.put("InsertDTLEXPSQL", StRepository.getStKeyValue("SQL_ST_ISSUE_DTL_EXP_INSERT")); 
			hmSQLMap.put("UpdateITMBCHSQL", StRepository.getStKeyValue("SQL_ST_ITEM_BATCH_ISS_AUTH_UPDATE"));
			hmSQLMap.put("UpdateDocSQL", StRepository.getStKeyValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")); 
			hmSQLMap.put("sql_st_records_per_trn_select", getStRepositoryValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
			hmSQLMap.put("sql_sy_acc_entity_doc_type_select", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
			hmSQLMap.put("sql_sy_acc_entity_doc_type_update", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmSQLMap.put("sql_sy_acc_entity_doc_type_select_flag", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
	
			
			hmTableData.put("InsertHDRData",alHdrInsertRecord);
			hmTableData.put("InsertDTLData",alDtlInsertRecord);

			hmTableData.put("InsertReqHdrData",alReqHdrInsertRecord);
			hmTableData.put("InsertReqDtlData",alReqDtlInsertRecord);

			hmTableData.put("InsertDTLEXPData",alDtlExpInsertRecord);
			hmTableData.put("ExpRecords",expRecords);
			hmTableData.put("UpdateItemBatchData",alItemBtachUpdateRecord);
			hmTableData.put("UpdateData",alUpdateData);
			hmTableData.put("UpdateDocData",alUpdateDocData);

			if((getItemClassBased("ISS").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
				hmTableData = (HashMap)modifiedTableData(hmTableData,"ISS");
			}
			AuthorizeAtIssueStoreRemote authorizeAtIssueStoreRemote = null;
			try {
			
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(StRepository.getStKeyValue("JNDI_ST_AUTHORIZE_AT_ISSUE_STORE"),AuthorizeAtIssueStoreHome.class,getLocalEJB());
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
				hmResult.put("message", getSTMessage(getLanguageId(),(String) hmResult.get("message"), "ST")) ;
				hmResult.put("flag", s1) ;

		/* SEND TO PRINT ONLINE REPORT STARTS 9/27/2004 */		
				String alertRqdYN = "";
				setPrintDocNo(doc_no);
				PgetDoc_type_code = getDoc_type_code();
				PgetStore_codest  = getRequest_on_store() ;
				ArrayList params = new ArrayList ();
				params.add(PgetStore_codest);
				alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_FOR_PRINT_PICKSLIP_YN_SELECT"),params).get("ALERT_FOR_PRINT_PICKSLIP_YN"));
				stReportid= "STBPKSLP";
				if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
				{
					if ( isInternalRequest("ST",stReportid) &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
					{
							if(alertRqdYN.equals("Y")){	
								hmResult.put("flag",hmResult.get("flag") + "~PY");
							}
							else{
								//doOnlineReportPrinting(doc_no);		
								//Comented By Sakti Sankar on 06/03/2013 against Inc#
								/*String pdocno = "";
								for(int i=0;i<doc_no.size();i++){
									pdocno=(String)doc_no.get(i);
									doOnlineReportPrinting(pdocno);	
								}*/
								hmResult.put("flag",hmResult.get("flag") + "~PN"); //Added By Sakti Sankar on 06/03/2013 against Inc#
							}
					 }
				}
			
		/* SEND TO PRINT ONLINE REPORT ENDS*/	


			}
			catch(Exception e) {
				hmResult.put("message", e.toString());
				e.printStackTrace();
			} 
			finally {
				try {
					if(authorizeAtIssueStoreRemote != null)
						authorizeAtIssueStoreRemote.remove();
				}
				catch(Exception ee) {
					hmResult.put("message", ee.toString());
					ee.printStackTrace();
				}
			}

			if (((Boolean) hmResult.get("result")).booleanValue() ) {
				initialize();
			} 

		return hmResult;
	}
	/*
	public void doOnlineReportPrinting(String doc_no) {
		try{
		     
			String reportid = "";
			 int count = 0;
			 ArrayList params = new ArrayList ();
				params.add("STBATRIS2_SRR");
			count=Integer.parseInt((String)(fetchRecord("select count(*) count from sm_report where report_id=?",params).get("COUNT")));
			if(count==1)
			 reportid= "STBATRIS2_SRR";
			if(count==0)
			reportid= "STBPKSLP";
			

			if (!isInternalRequest("ST",reportid)) return;
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_seq_no",Integer.toString(seq_no));//getSeq_no());
			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);
			hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());

			hmParameters.put("location_type","S");
			hmParameters.put("location_code",PgetStore_codest);
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}
	*/

	public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{

			String reportid = "";
			 int count = 0;
			 ArrayList params = new ArrayList ();
				params.add("STBATRIS2_SRR");
			count=Integer.parseInt((String)(fetchRecord("select count(*) count from sm_report where report_id=?",params).get("COUNT")));
			if(count==1)
			 reportid= "STBATRIS2_SRR";
			if(count==0)
			reportid= "STBPKSLP";
			//String copies = getNoOfCopies(reportid);
	
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
				report2.addParameter("p_seq_no",Integer.toString(seq_no));//getSeq_no());
				//report2.addParameter("copies",checkForNull(copies,"1"));
				onlineReports.add( report2) ;
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}

	public java.util.HashMap modify() {
		//System.out.println("AuthoriseAtIssueStoreBean - modify");
		HashMap hmResult = new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		//ArrayList alInsertData = new ArrayList();
		ArrayList alPendingQtyUpdRecord = new ArrayList();
		ArrayList alDeleteDtlRecord = new ArrayList();
		java.util.Properties properties = getProperties();
		AuthorizeAtIssueStoreDetailBean authorizeAtIssueStoreDetailBean;
		hmResult.put("result", new Boolean(false));
		seq_no = 0;
		int doc_srl_no = 0;
		int flag= 1;
		double iss_item_qty=0.0;//added for ml-mmoh-0979

		try {
			java.util.ArrayList sqlParameter = new java.util.ArrayList(3);
			sqlParameter.add(getReq_Facility_id());
			sqlParameter.add(getDoc_type_code());
			sqlParameter.add(getDoc_no());
			java.util.HashMap hmSeq_no = fetchRecord(getStRepositoryValue("SQL_ST_REQUEST_SEQ_SELECT"),sqlParameter);

			if (hmSeq_no.containsKey("ISSUE_SEQ_NO")) {
				seq_no = Integer.parseInt((String) hmSeq_no.get("ISSUE_SEQ_NO"));
			}
			seq_no += 1;
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		ArrayList alReqDtlInsertRecord = new ArrayList();

		ArrayList alIssueSeqUpdateData = new ArrayList();
		alIssueSeqUpdateData.add(""+seq_no);
		alIssueSeqUpdateData.add(login_by_id);
		alIssueSeqUpdateData.add(login_at_ws_no);
		alIssueSeqUpdateData.add(login_facility_id);
		alIssueSeqUpdateData.add(getReq_Facility_id());
		alIssueSeqUpdateData.add(getDoc_type_code());
		alIssueSeqUpdateData.add(getDoc_no()); 	   

		ArrayList alHdrInsertRecord = new ArrayList();
		//alHdrInsertRecord.add(getReq_Facility_id());		//Commented By Mahesh on 8/28/2008 because the logged in facility should be inserted into Issue Tables instead of the Requesting Facility
		alHdrInsertRecord.add(login_facility_id);		// 0
		alHdrInsertRecord.add(getDoc_type_code());		// 1 
		alHdrInsertRecord.add(getDoc_no());				// 2
		alHdrInsertRecord.add(""+seq_no);				// 3
		alHdrInsertRecord.add(getDoc_date_value());		// 4
		alHdrInsertRecord.add(getDoc_ref());			// 5
		alHdrInsertRecord.add(getRequest_on_store());	// 6
		alHdrInsertRecord.add(getRequest_by_store());	// 7

		alHdrInsertRecord.add("N");	// finalized_yn	    // 8

		alHdrInsertRecord.add("N");	// gl_interfaced_yn	// 9
		alHdrInsertRecord.add("ISS");					// 10
		alHdrInsertRecord.add("Y"); //entry completed ?	// 11
		alHdrInsertRecord.add(login_by_id);				// 12
		alHdrInsertRecord.add(checkForNull(getClose_req_after_issue_yn(),"N")); // 13
		//alHdrInsertRecord.add(checkForNull(getRemarks(),""));
		alHdrInsertRecord.add(checkForNull(getRemarks_code(),"")); //18/06/12

		//added by Pankaj on 03/11/2004 
        alHdrInsertRecord.add(checkForNull(getItem_class_code()));

		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);
		alHdrInsertRecord.add(login_by_id);
		alHdrInsertRecord.add(login_at_ws_no);
		alHdrInsertRecord.add(login_facility_id);

		ArrayList allItemKeys = new ArrayList();

		ArrayList dupRemove=new ArrayList();
		/* remove the newly added current pending items begin */
		for(int i=0;i<checkedDValues.size();i++){
			if(addedItemKeys.contains(checkedDValues.get(i))){
				addedItemKeys.remove(checkedDValues.get(i));
				dupRemove.add(checkedDValues.get(i));
			}
		}
		for(int i=0;i<dupRemove.size();i++){
			checkedDValues.remove(dupRemove.get(i));
		}
		/* remove the newly added current pending items end */
		allItemKeys.addAll(itemKeys);
		allItemKeys.addAll(addedItemKeys);


		int detailSize = allItemKeys.size();
		ArrayList alDtlInsertRecord = new ArrayList(detailSize);
		ArrayList alDtlExpInsertRecord = new ArrayList();
	    ArrayList alitemstoreData = new ArrayList(); //added by Rabbani #inc no:27426 on 08/8/11
        ArrayList alItemBtachUpdateRecord = new ArrayList();
        ArrayList alReqDtlZeroQtyRecord = new ArrayList();//MO-CRF-20173
        ArrayList alReqDtlZeroQtyData = new ArrayList();//MO-CRF-20173
/*****...............*/
		//int count=1;
		//System.out.println("###############################");
		//System.out.println("#1705# detail = > "+allItemKeys+" detailSize = > "+detailSize);
		for (int index=0;index<detailSize;index++) {
			if((allItemKeys.get(index) == null) || (allItemKeys.get(index).equals(""))) 
					continue;
			authorizeAtIssueStoreDetailBean = (AuthorizeAtIssueStoreDetailBean) hmItemDetail.get(allItemKeys.get(index));
			/*
			* Here the item_cost_value is calculted using issuing_item_qty and unit_cost
			*/		

			double item_cost_value = (Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty())/getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_on_store())) * Double.parseDouble(authorizeAtIssueStoreDetailBean.getUnit_cost());

			if(!checkedDValues.contains(authorizeAtIssueStoreDetailBean.getItem_code())){
        		    
			ArrayList alDtlRecord = new ArrayList(22);
			//alDtlRecord.add(getReq_Facility_id()); //Commented By Mahesh on 8/28/2008 because the logged in facility should be inserted into Issue Tables instead of the Requesting Facility
			alDtlRecord.add(login_facility_id); //0
			alDtlRecord.add(getDoc_type_code());   //1
			alDtlRecord.add(getDoc_no());			  //2
			alDtlRecord.add(""+(seq_no));				 //3
			//if(checkedDValues.size()==0){
			if(authorizeAtIssueStoreDetailBean.getDoc_srl_no() != null) {
					alDtlRecord.add(authorizeAtIssueStoreDetailBean.getDoc_srl_no());//4
					doc_srl_no = Integer.parseInt(authorizeAtIssueStoreDetailBean.getDoc_srl_no());
				}else {
					doc_srl_no++;
					alDtlRecord.add(""+doc_srl_no);
				}
			
		//	}
		//	if(checkedDValues.size()!=0){
		//	alDtlRecord.add(""+(count++));
		//	}
			alDtlRecord.add(getRequest_on_store());				 
			alDtlRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());		
			alDtlRecord.add("0");									   //7
			alDtlRecord.add(authorizeAtIssueStoreDetailBean.getUnit_cost());
			/* @Name - Priya
			* @Date - 27/05/2010
			* @Inc# - 
			* @Desc - item cost_value is rounded with noOfDecimalsForCost
			*/
			//alDtlRecord.add(setNumber(""+item_cost_value,3));
			int noOfDecimalsForCost=0;
			try{
				noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
			}catch(Exception e){
				e.printStackTrace();
			}
			alDtlRecord.add(setNumber(""+item_cost_value,noOfDecimalsForCost));//8
										//9
			alDtlRecord.add("N");											   //10
			alDtlRecord.add(authorizeAtIssueStoreDetailBean.getStock_item_yn());				   //11
			/* authorized_item_qty is updated with issuing_item_qty*/
//Added By Mahesh To arrive iss_item_qty for st_issue_dtl in stock uom uncomment this line if any problems in iss_item_qty
			//alDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssuing_item_qty());
			//added for ml-mmoh-scf-0979 start
			//double convfactor= getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_on_store()); //Commented for Common-ICN-0060
			//String conv=String.valueOf(convfactor);//15757
			//double issQty=Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty());///commented for 15757
			//System.out.println("issQty: "+issQty); 
		//	System.out.println("convfactor: "+convfactor);
			 
			/*MODIFIED FOR ML-MMOH-SCF-1003*/
			iss_item_qty = Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty())/getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_on_store());//Modified for 70724
			alDtlRecord.add(""+iss_item_qty);
		//	System.out.println("iss_item_qty in AuthAtIssueStoreBean: "+iss_item_qty);
			/*MODIFIED FOR ML-MMOH-SCF-1003*/
			
			//alDtlRecord.add(""+iss_item_qty);commented and added above for ML-MMOH-SCF-0979
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			alDtlRecord.add(login_by_id);
			alDtlRecord.add(login_at_ws_no);
			alDtlRecord.add(login_facility_id);
			//code added for inserting Issue uom,conv.factor.Issue Qty on 2/7/2004...
			alDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssUomCode());
//			alDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssConvFact());//Modified against ML-MMOH-SCF-0636
			alDtlRecord.add(checkForNull(authorizeAtIssueStoreDetailBean.getIssConvFact(),""+getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_by_store())));
			alDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssUomQty());
			double comted_qty = Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty())/getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_by_store());//added for ML-MMOH-SCF-1003,Modified for 70724
			//System.err.println("comted_qty IN authAtIssueStoreBean: "+comted_qty); 
			//added by Rabbani #inc no:27426 on 08\08\11
			double pending_qty=0;
			pending_qty = Double.parseDouble(authorizeAtIssueStoreDetailBean.getReq_item_qty())/getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_by_store());
			//ends  
			alDtlRecord.add(authorizeAtIssueStoreDetailBean.getRemarksCode());//29/06/12
			alDtlRecord.add(authorizeAtIssueStoreDetailBean.getUsagetype());//20/09/12 //23
			alDtlRecord.add(""+comted_qty);
			
			alDtlRecord.add(getClose_req_after_issue_yn());
//			String zeroQty="0.0";  //COMMON-ICN-0118
					// code ended...
					//added by Rabbani #inc no:27426 on 08\08\11 starts 
				 if(getClose_req_after_issue_yn().equals("Y")){
					pending_qty = comted_qty;
					alDtlRecord.add(+pending_qty);
 					}else{ 
 					//	System.out.println("getClose_item_yn-2129: "+authorizeAtIssueStoreDetailBean.getClose_item_yn());
 					//	System.out.println("iss_item_qty in AuthAtIssueStoreBean: "+iss_item_qty);
 						if(authorizeAtIssueStoreDetailBean.getClose_item_yn().equals("Y") && iss_item_qty==0.0 ){//added for MO-CRF-20173
 					//		System.out.println("---2131---");   
 							double pending_zero_qty=0;  
 							alDtlRecord.add(+pending_qty);
 							alReqDtlZeroQtyRecord.add(+pending_zero_qty); 
 							alReqDtlZeroQtyRecord.add(login_by_id);
 							alReqDtlZeroQtyRecord.add(login_at_ws_no);
 							alReqDtlZeroQtyRecord.add(login_facility_id);
							alReqDtlZeroQtyRecord.add(authorizeAtIssueStoreDetailBean.getClose_item_yn());  
					        alReqDtlZeroQtyRecord.add(authorizeAtIssueStoreDetailBean.getCloseRemarksDesc()); //MO-CRF-20173 
 							alReqDtlZeroQtyRecord.add(login_facility_id);
 							alReqDtlZeroQtyRecord.add(getDoc_type_code());//doc_type_code
 							alReqDtlZeroQtyRecord.add(getDoc_no());//doc_no
 							alReqDtlZeroQtyRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());//item_code
 							alReqDtlZeroQtyData.add(alReqDtlZeroQtyRecord);
 					//		System.err.println("alReqDtlZeroQtyData: "+alReqDtlZeroQtyData);  
 							
 						}else{
 							alDtlRecord.add(+pending_qty);
 						}//end 
					
					}
			//System.out.println("getClose_item_yn: "+authorizeAtIssueStoreDetailBean.getClose_item_yn());  
			if(authorizeAtIssueStoreDetailBean.getClose_item_yn()==null ||authorizeAtIssueStoreDetailBean.getClose_item_yn().equals("") )//MO-CRF-20173 START 
			authorizeAtIssueStoreDetailBean.setClose_item_yn("N"); 
			alDtlRecord.add(authorizeAtIssueStoreDetailBean.getClose_item_yn());//MO-CRF-20173  
			if(authorizeAtIssueStoreDetailBean.getClose_item_yn().equals("N")){
				alDtlRecord.add("");
			}else{
				alDtlRecord.add(authorizeAtIssueStoreDetailBean.getCloseRemarksDesc());//end  
			}
			
			//System.out.println("alDtlRecord: "+alDtlRecord);  
				//update pending qty in st_item_store at the time of close upon issue	 
					
					Connection connection = null;
                    PreparedStatement pstmt = null;
                        ResultSet resultSet = null;
						double remainingpendingItemQty = 0;
		      try {
            connection = getConnection();
	       pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REQ_DTL_PEND_QTY_SELECT"));
	           pstmt.setString(1, getDoc_no());
	           pstmt.setString(2, getDoc_type_code());
			   pstmt.setString(3, authorizeAtIssueStoreDetailBean.getItem_code());
	            resultSet = pstmt.executeQuery();
				while(resultSet != null && resultSet.next()) {
					String reqByStoreCode = resultSet.getString("REQ_BY_STORE_CODE");
				    double pendingItemQty = Double.parseDouble(resultSet.getString("PENDING_ITEM_QTY"));
					remainingpendingItemQty = pendingItemQty-comted_qty;				
					String itemCode = resultSet.getString("ITEM_CODE");
					ArrayList alitemdata = new ArrayList();		
					alitemdata.add(remainingpendingItemQty);
					alitemdata.add(reqByStoreCode);
					alitemdata.add(itemCode);
					alitemstoreData.add(alitemdata);
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
			//ends here 08/08/11
					
			if (Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty()) > 0)
			{
			   flag=0;

			   alDtlInsertRecord.add(alDtlRecord);
			}

			if( iss_item_qty > Float.parseFloat(checkForNull(authorizeAtIssueStoreDetailBean.getReq_on_qty_on_hand(),"0"))){
				HashMap hmException=new HashMap();
				hmException.put("result", FALSE);
				hmException.put("msgid", "REQ_QTY_NOT_GR_PEND_QTY");
				hmException.put("message", "REQ_QTY_NOT_GR_PEND_QTY") ;

				//hmException.put("flag", index+"" );
				hmException.put("flag", authorizeAtIssueStoreDetailBean.getItem_desc() ); // Added item description in flag against MMS-SCF-0400
				return hmException;
			}
			}else{
				double checked_item_pen_qty = 0;
				ArrayList alParam = new ArrayList();
				alParam.add(getReq_Facility_id());
				alParam.add(getDoc_type_code());
				alParam.add(getDoc_no());
				alParam.add(authorizeAtIssueStoreDetailBean.getDoc_srl_no());
				alParam.add(authorizeAtIssueStoreDetailBean.getItem_code());
				try{
					checked_item_pen_qty = Double.parseDouble(checkForNull((String)(((HashMap)fetchRecord("SELECT PENDING_ITEM_QTY FROM ST_REQUEST_DTL WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND  DOC_NO = ? AND DOC_SRL_NO = ? AND ITEM_CODE = ?",alParam)).get("PENDING_ITEM_QTY")),"0"))/getConvFactTemp((String)authorizeAtIssueStoreDetailBean.getItem_code(),(String)getRequest_by_store());
				}catch(Exception e){
					e.printStackTrace();
				}
				alParam = new ArrayList();
				alParam.add(checked_item_pen_qty);
				alParam.add(getRequest_by_store());
				alParam.add(authorizeAtIssueStoreDetailBean.getItem_code());
				alPendingQtyUpdRecord.add(alParam);
				alParam = new ArrayList();
				alParam.add(authorizeAtIssueStoreDetailBean.getItem_code());
				alParam.add(getDoc_type_code());
				alParam.add(getDoc_no());
				alParam.add(getReq_Facility_id());
				alDeleteDtlRecord.add(alParam);
			}
//added ends
		//System.out.println("#1819#");
			/* st_request_dtl insert for the newly added records */
			if(addedItemKeys.contains(authorizeAtIssueStoreDetailBean.getItem_code())) {
				//System.out.println("#1822#");
				ArrayList alReqDtlRecord = new ArrayList(19);
				alReqDtlRecord.add(getReq_Facility_id()); 
				alReqDtlRecord.add(getDoc_type_code());   
				alReqDtlRecord.add(getDoc_no());
				//if(checkedDValues.size()==0){
				alReqDtlRecord.add(""+(doc_srl_no));	
			//	}else{
			//	alReqDtlRecord.add(""+(count++));	
			//	}
				alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());		
				alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getReq_item_qty());				   
				alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getStock_item_yn());				   
				//alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssuing_item_qty()); Commented against ML-MMOH-SCF-0635				   
				alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getReq_item_qty());				   
				//alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getIssuing_item_qty());				   
				alReqDtlRecord.add(login_by_id);
				alReqDtlRecord.add(login_at_ws_no);
				alReqDtlRecord.add(login_facility_id);
				alReqDtlRecord.add(login_by_id);
				alReqDtlRecord.add(login_at_ws_no);
				alReqDtlRecord.add(login_facility_id);
				//code added for RequestUOM,RequestQty,Conv.factor 2/7/2004...
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getPurUomCode());
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getReqConvFact());
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getReqUomQty());
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getRemarksCode());
					alReqDtlRecord.add(""); //18/09/12
			//		System.out.println("authorizeAtIssueStoreDetailBean.getClose_item_yn(): "+authorizeAtIssueStoreDetailBean.getClose_item_yn()); 
					if(authorizeAtIssueStoreDetailBean.getClose_item_yn()==null ||authorizeAtIssueStoreDetailBean.getClose_item_yn().equals("") )//MO-CRF-20173 START 
						authorizeAtIssueStoreDetailBean.setClose_item_yn("N"); 
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getClose_item_yn());  
					alReqDtlRecord.add(authorizeAtIssueStoreDetailBean.getCloseRemarksDesc()); //MO-CRF-20173  
					//code ended....
				alReqDtlInsertRecord.add(alReqDtlRecord);
			}

						//System.out.println("#1853#");
			//Exp Records
		/*	if(!checkedDValues.contains(authorizeAtIssueStoreDetailBean.getItem_code())){
			System.out.println("#1856#");
			try {
				StUtilities stUtilities = new StUtilities(properties);
				HashMap hmParameters	=	new HashMap();
				stUtilities.setLanguageId(getLanguageId());
				hmParameters.put("ITEM_CODE",authorizeAtIssueStoreDetailBean.getItem_code());
				hmParameters.put("STORE_CODE",getRequest_on_store());
				hmParameters.put("TRN_QTY",authorizeAtIssueStoreDetailBean.getIssuing_item_qty());
				hmParameters.put("INCLUDE_SUSPENDED","FALSE");//optional, by default FALSE
				hmParameters.put("INCLUDE_EXPIRED","FALSE");//optional, by default FALSE
				hmParameters.put("VERIFY_INSUFFICIENT_QTY","TRUE");//optional, by default TRUE

				System.out.println("Modify, hmParameters = >"+hmParameters);

				java.util.HashMap dataValue = stUtilities.getBatches(hmParameters);
				java.util.ArrayList expBatchDetails = (ArrayList) dataValue.get("BATCH_DATA");
				
				if (Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty()) > 0)
				{
				System.out.println("#1875#");
				for (int cnt=0; cnt<expBatchDetails.size();cnt++) {
									System.out.println("#1877#");
					java.util.ArrayList alDtlExpRecord = new java.util.ArrayList(17);
					java.util.HashMap tempExpBatchDtl =  (java.util.HashMap) expBatchDetails.get(cnt);
					//alDtlExpRecord.add(getReq_Facility_id()); Commented By Mahesh on 8/28/2008 because the logged in facility should be inserted into Issue Tables instead of the Requesting Facility
					alDtlExpRecord.add(login_facility_id);
					alDtlExpRecord.add(getDoc_type_code());
					alDtlExpRecord.add(getDoc_no());
					alDtlExpRecord.add(""+(seq_no));
					//Modified on 07/07/2004... bean is returning null value 
					//alDtlExpRecord.add(authorizeAtIssueStoreDetailBean.getDoc_srl_no());
				//	if(checkedDValues.size()==0){
					alDtlExpRecord.add(""+(doc_srl_no));	
				//	}else{
				//	alDtlExpRecord.add(""+(count));	
				//	}
				//	alDtlExpRecord.add(""+(doc_srl_no));
					alDtlExpRecord.add(getRequest_on_store());
					alDtlExpRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());
					alDtlExpRecord.add(tempExpBatchDtl.get("BATCH_ID"));
					alDtlExpRecord.add(tempExpBatchDtl.get("BIN_LOCATION_CODE"));
					alDtlExpRecord.add(tempExpBatchDtl.get("EXPIRY_DATE"));
					alDtlExpRecord.add(tempExpBatchDtl.get("QTY"));
					alDtlExpRecord.add(tempExpBatchDtl.get("TRADE_ID"));
					alDtlExpRecord.add(authorizeAtIssueStoreDetailBean.getTo_bin_location_code());
					alDtlExpRecord.add(login_by_id);
					alDtlExpRecord.add(login_at_ws_no);
					alDtlExpRecord.add(login_facility_id);
					alDtlExpRecord.add(login_by_id);
					alDtlExpRecord.add(login_at_ws_no);
					alDtlExpRecord.add(login_facility_id);
					alDtlExpInsertRecord.add(alDtlExpRecord);

					//Update Record
					java.util.ArrayList alBatchUpdRecord = new java.util.ArrayList(10);
					alBatchUpdRecord.add(tempExpBatchDtl.get("QTY"));
					alBatchUpdRecord.add(login_by_id);
					alBatchUpdRecord.add(login_at_ws_no);
					alBatchUpdRecord.add(login_facility_id);
					alBatchUpdRecord.add(getRequest_on_store());
					alBatchUpdRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());
					alBatchUpdRecord.add(tempExpBatchDtl.get("BATCH_ID"));
					alBatchUpdRecord.add(tempExpBatchDtl.get("BIN_LOCATION_CODE"));
					alBatchUpdRecord.add(tempExpBatchDtl.get("EXPIRY_DATE"));
					alItemBtachUpdateRecord.add(alBatchUpdRecord);
				}
				}
			}
			catch (InsufficientBatchException insufficient) {
				System.out.println("INSUFFICIENT_BATCH_QTY = >"+insufficient.getMessage());
				hmResult.put("msgid", "INSUFFICIENT_BATCH_QTY");
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;

				hmResult.put("flag", authorizeAtIssueStoreDetailBean.getItem_desc());
				insufficient.printStackTrace();
				return hmResult;
			}
			catch (Exception exception) {
				hmResult.put("message", exception.getMessage());
				hmResult.put("flag", index+"");
				exception.printStackTrace();
				return hmResult;
			}
		}
		System.out.println("###############################");
	*/	
	//Exp Records
			if(!checkedDValues.contains(authorizeAtIssueStoreDetailBean.getItem_code())){
			//System.out.println("new exp record modify");
			java.util.ArrayList expBatchDetails=null;
			java.util.HashMap dataValue = null;
			try {
				expBatchDetails = (ArrayList) getExpRecords(authorizeAtIssueStoreDetailBean.getItem_code());
				
				if(expBatchDetails == null){
					StUtilities stUtilities = new StUtilities(properties);
					HashMap hmParameters	=	new HashMap();
					stUtilities.setLanguageId(getLanguageId());
					stUtilities.setLoginById(getLoginById());//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
					hmParameters.put("ITEM_CODE",authorizeAtIssueStoreDetailBean.getItem_code());
					hmParameters.put("STORE_CODE",getRequest_on_store());
					hmParameters.put("TRN_QTY",authorizeAtIssueStoreDetailBean.getIssuing_item_qty());
					hmParameters.put("INCLUDE_SUSPENDED","FALSE");//optional, by default FALSE
					hmParameters.put("INCLUDE_EXPIRED","FALSE");//optional, by default FALSE
					hmParameters.put("VERIFY_INSUFFICIENT_QTY","TRUE");//optional, by default TRUE
					hmParameters.put("AUTHORIZE_YN", "Y");//Added for MMS-DM-SCF-0244 by B.Badmavathi on 06/06/2016
					//System.out.println("Modify, hmParameters = >"+hmParameters);
					dataValue = stUtilities.getBatches(hmParameters);
					expBatchDetails = (ArrayList) dataValue.get("BATCH_DATA");
					if ((expBatchDetails.size() == 0) && (Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty()) != 0)){
						throw new InsufficientBatchException(); 
					}
				}
				
				if (Double.parseDouble(authorizeAtIssueStoreDetailBean.getIssuing_item_qty()) > 0)
				{
				//System.out.println("#2060#");
				
				ArrayList params = null;
				String barcode_id="";
				for (int cnt=0; cnt<expBatchDetails.size();cnt++) {
									//System.out.println("#2062#");
					java.util.ArrayList alDtlExpRecord = new java.util.ArrayList(17);
					java.util.HashMap tempExpBatchDtl =  (java.util.HashMap) expBatchDetails.get(cnt);
					if(tempExpBatchDtl.size() > 0 && tempExpBatchDtl.get("QTY") != null && tempExpBatchDtl.get("QTY") != ""){
					alDtlExpRecord.add(login_facility_id);
					alDtlExpRecord.add(getDoc_type_code());
					alDtlExpRecord.add(getDoc_no());
					alDtlExpRecord.add(""+(seq_no));
					alDtlExpRecord.add(""+(doc_srl_no));	
					alDtlExpRecord.add(getRequest_on_store());
					alDtlExpRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());
					alDtlExpRecord.add(tempExpBatchDtl.get("BATCH_ID"));
					alDtlExpRecord.add(tempExpBatchDtl.get("BIN_LOCATION_CODE"));
					alDtlExpRecord.add(tempExpBatchDtl.get("EXPIRY_DATE"));
					alDtlExpRecord.add(tempExpBatchDtl.get("QTY"));
					alDtlExpRecord.add(tempExpBatchDtl.get("TRADE_ID"));
					if(dataValue == null)
						alDtlExpRecord.add(tempExpBatchDtl.get("TO_BIN_LOCATION_CODE"));
					else
						alDtlExpRecord.add(authorizeAtIssueStoreDetailBean.getTo_bin_location_code());	
					alDtlExpRecord.add(login_by_id);
					alDtlExpRecord.add(login_at_ws_no);
					alDtlExpRecord.add(login_facility_id);
					alDtlExpRecord.add(login_by_id);
					alDtlExpRecord.add(login_at_ws_no);
					alDtlExpRecord.add(login_facility_id);
					alDtlExpInsertRecord.add(alDtlExpRecord);
					
					//Added By Ganga for RUT-CRF-0079 On Aug 16th 2013
					
					if(isBarCodeApplicableForValidation("VALIDATEBARCODE","ISS")){
						params = new ArrayList();						
						
						params.add(getRequest_on_store());
						params.add(authorizeAtIssueStoreDetailBean.getItem_code());
						params.add(tempExpBatchDtl.get("BATCH_ID"));
						params.add(tempExpBatchDtl.get("BIN_LOCATION_CODE"));
						params.add(tempExpBatchDtl.get("EXPIRY_DATE"));
						
						barcode_id =(String)(fetchRecord(getStRepositoryValue("SQL_ST_ITEM_BATCH_GET_BARCODE_ID"),params).get("BARCODE_ID"));
					}
					
					alDtlExpRecord.add(checkForNull(barcode_id));
					
					//Ended
					
					

					//Update Record
					java.util.ArrayList alBatchUpdRecord = new java.util.ArrayList(10);
					alBatchUpdRecord.add(tempExpBatchDtl.get("QTY"));
					alBatchUpdRecord.add(login_by_id);
					alBatchUpdRecord.add(login_at_ws_no);
					alBatchUpdRecord.add(login_facility_id);
					alBatchUpdRecord.add(getRequest_on_store());
					alBatchUpdRecord.add(authorizeAtIssueStoreDetailBean.getItem_code());
					alBatchUpdRecord.add(tempExpBatchDtl.get("BATCH_ID"));
					alBatchUpdRecord.add(tempExpBatchDtl.get("BIN_LOCATION_CODE"));
					alBatchUpdRecord.add(tempExpBatchDtl.get("EXPIRY_DATE"));
					alItemBtachUpdateRecord.add(alBatchUpdRecord);
				}
				}
				}
			} catch (Exception exception) {
				hmResult.put("message", exception.getMessage());
				//hmResult.put("flag", index+"");
				hmResult.put("flag", authorizeAtIssueStoreDetailBean.getItem_desc());// Added item description in flag against MMS-SCF-0400
				exception.printStackTrace();
				return hmResult;
			}
		}
	}






				   //System.out.println("flag = > "+flag);
				if(flag==1)
				{
		
				hmResult.put("result", new Boolean(false));
				hmResult.put("msgid", "ISS_QTY_CANNOT_BE_ZERO");
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") 
				) ;

//				hmResult.put("flag", index+"");
				return hmResult;
				}

		java.util.ArrayList alUpdateHDRData = new java.util.ArrayList (7);
		/*if(getClose_req_after_issue_yn().equals("Y"))
			alUpdateHDRData.add("L");
		else*/
	//	alUpdateHDRData.add("A");  // ---Commented by Padmapriya On 31/1/2012
	
	//Start added cancelled_by_id and cancelled_remarks by Padmapriya On 31/1/2012
		//String cancelled_by_id = "";   //commented by Rabbani on 24-Mar-2014 for chkstyles
		//String cancelled_remarks = (String)	getRemarks();
		//String cancelled_remarks = (String)	getRemarks_code(); //commented by Rabbani on 24-Mar-2014 for chkstyles
		
		if(getClose_req_after_issue_yn().equals("Y")){
			//alUpdateHDRData.add(login_by_id);  
			//alUpdateHDRData.add(cancelled_remarks);
			alUpdateHDRData.add("");  
			alUpdateHDRData.add("");
			alUpdateHDRData.add("L");
			}
		else{
		//alUpdateHDRData.add(cancelled_by_id);  
		alUpdateHDRData.add("");  
		alUpdateHDRData.add("");  
		//alUpdateHDRData.add(cancelled_remarks);	   
		alUpdateHDRData.add("A");
		}
		//end by Padmapriya On 31/1/2012
		
		alUpdateHDRData.add(login_by_id);
		alUpdateHDRData.add(login_at_ws_no);
		alUpdateHDRData.add(login_facility_id);
		//alUpdateHDRData.add(getReq_Facility_id());
		/*alUpdateHDRData.add(getDoc_type_code());
		alUpdateHDRData.add(getDoc_no());*/ //commented and moved below for MO-CRF-20173  
		
		java.util.ArrayList alDtlUpdateData = new java.util.ArrayList ();
			
		// Consider only the item which is getting modified
		detailSize = itemKeys.size(); 
		for (int index=0;index<detailSize;index++) {
			if((itemKeys.get(index) == null) || (itemKeys.get(index).equals(""))) 
					continue;

			authorizeAtIssueStoreDetailBean = (AuthorizeAtIssueStoreDetailBean) hmItemDetail.get(itemKeys.get(index));
			if(!checkedDValues.contains(itemKeys.get(index))){
			ArrayList alDtlUpdateRecord = new ArrayList(8);

			/* issuing_item_qty is used to update */

			alDtlUpdateRecord.add(authorizeAtIssueStoreDetailBean.getIssuing_item_qty());
			alDtlUpdateRecord.add(getRequest_on_store());
			alDtlUpdateRecord.add(login_by_id);
			alDtlUpdateRecord.add(login_at_ws_no);
			alDtlUpdateRecord.add(login_facility_id);
			alDtlUpdateRecord.add(login_facility_id);
			alDtlUpdateRecord.add(getDoc_type_code());
			alDtlUpdateRecord.add(getDoc_no());
			alDtlUpdateRecord.add(""+(seq_no));
			alDtlUpdateRecord.add(authorizeAtIssueStoreDetailBean.getDoc_srl_no());
			alDtlUpdateData.add(alDtlUpdateRecord);
		}	
		}
		int itemVal = 0; //MO-CRF-20173
		int alDtlsize = alDtlInsertRecord.size(); 
//System.out.println("alDtlInsertRecord: "+alDtlInsertRecord.size());
for(int k=0;k<alDtlInsertRecord.size();k++){
	ArrayList arrList = new ArrayList();
	arrList= (ArrayList)alDtlInsertRecord.get(k); 
	String closeItemVal = (String)arrList.get(27);
	if (closeItemVal.equals("Y")){
	itemVal = itemVal + 1;	
	}	
}
if(itemVal == alDtlsize){
	//update close_document as 'Y'
	alHdrInsertRecord.add("Y"); 
	alUpdateHDRData.add("Y");//MO-CRF-20173
	
}else{
	alHdrInsertRecord.add("N");  
	alUpdateHDRData.add("N");//MO-CRF-20173
}//END
//moved here from above for MO-CRF-20173

alUpdateHDRData.add(getDoc_type_code());
alUpdateHDRData.add(getDoc_no());
			hmSQLMap.put("InsertHDRSQL", StRepository.getStKeyValue("SQL_ST_ISSUE_HDR_INSERT")); 
			hmSQLMap.put("InsertDTLSQL", StRepository.getStKeyValue("SQL_ST_ISSUE_DTL_INSERT")); 

			hmSQLMap.put("InsertDTLEXPSQL", StRepository.getStKeyValue("SQL_ST_ISSUE_DTL_EXP_INSERT")); 
			hmSQLMap.put("UpdateHDRSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_HDR_ISS_AUTH_UPDATE"));
			if(checkedDValues.size()!=0){
		//	hmSQLMap.put("UpdateDTLSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_ISS_AUTH_UPDATE"));
			hmSQLMap.put("UpdateDTLSQL","UPDATE st_request_dtl	SET	committed_item_qty = committed_item_qty + ?,AUTH_TRN_REMARKS_CODE=?,	 modified_by_id	= ?	, modified_date	= sysdate ,	modified_at_ws_no =	? ,	modified_facility_id = ?, CLOSE_ITEM_YN = ? , CLOSE_REMARKS_DESC = ?   WHERE	facility_id	= ?	 AND doc_type_code = ?	AND	doc_no = ?	AND	item_code = ?");//Added by chandra for MO-CRF-20173
			hmSQLMap.put("UpdateStorePendingQtySQL", "UPDATE ST_ITEM_STORE SET PENDING_REQ_QTY = PENDING_REQ_QTY - NVL(?,0) WHERE STORE_CODE = ? AND ITEM_CODE = ?"); 
			hmSQLMap.put("DeleteDTlItemsSQL", "delete from st_request_dtl where ITEM_CODE=? and DOC_TYPE_CODE=? and doc_no=?  and FACILITY_ID=?"); 
		
			}else{
			
			//added by Rabbani #inc no:27426 on 08\08\11
			// update st_item_store and st_request_dtl in case of close upon issue
			 if(getClose_req_after_issue_yn().equals("Y")){
			hmSQLMap.put("UpdateDTLSQL", "UPDATE st_request_dtl	SET	committed_item_qty = committed_item_qty + ?,AUTH_TRN_REMARKS_CODE=?,PENDING_ITEM_QTY=?, modified_by_id	= ?	, modified_date	= sysdate ,	modified_at_ws_no =	? ,	modified_facility_id = ? , CLOSE_ITEM_YN = ? , CLOSE_REMARKS_DESC = ? WHERE	facility_id	= ?  AND doc_type_code = ?	AND	doc_no = ?	AND	doc_srl_no = ?"); 
			hmSQLMap.put("UpdateITEMSQL", "UPDATE ST_ITEM_STORE SET PENDING_REQ_QTY = PENDING_REQ_QTY -NVL(?,0) WHERE STORE_CODE = ? AND ITEM_CODE = ?"); 
			 }
			else{
			hmSQLMap.put("UpdateDTLSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_ISS_AUTH_UPDATE"));
			}
			}
			hmSQLMap.put("UpdateITMBCHSQL", StRepository.getStKeyValue("SQL_ST_ITEM_BATCH_ISS_AUTH_UPDATE"));
			hmSQLMap.put("UpdateIssueSeqSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_SEQ_NO_UPDATE"));
			hmSQLMap.put("sql_st_records_per_trn_select", getStRepositoryValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
			hmSQLMap.put("sql_sy_acc_entity_doc_type_select", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
			hmSQLMap.put("sql_sy_acc_entity_doc_type_update", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
			hmSQLMap.put("sql_sy_acc_entity_doc_type_select_flag", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));

		if(alReqDtlInsertRecord.size() > 0 ) {
			hmTableData.put("InsertReqDtlData",alReqDtlInsertRecord);
			hmSQLMap.put("InsertReqDtlSQL", StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_INSERT_AUTH")); //Modified from SQL_ST_REQUEST_DTL_INSERT to SQL_ST_REQUEST_DTL_INSERT_AUTH against ML-MMOH-SCF-0635
		}

		hmSQLMap.put("UpdateZeroQtyDTLSQL", "UPDATE st_request_dtl	SET	PENDING_ITEM_QTY = ?, modified_by_id	= ?	, modified_date	= sysdate ,	modified_at_ws_no =	? ,	modified_facility_id = ?, CLOSE_ITEM_YN = ? , CLOSE_REMARKS_DESC = ?  WHERE	facility_id	= ?	 AND doc_type_code = ?	AND	doc_no = ?	AND	item_code = ?");//MO-CRF-20173
		hmTableData.put("properties",getProperties());
		hmTableData.put("InsertHDRData",alHdrInsertRecord);
		hmTableData.put("InsertDTLData",alDtlInsertRecord);
		hmTableData.put("UpdateITEMdata",alitemstoreData); //added by Rabbani #inc no:27426 on 08/08/11
		hmTableData.put("InsertDTLEXPData",alDtlExpInsertRecord);
		hmTableData.put("UpdateHDRData",alUpdateHDRData);
		hmTableData.put("UpdateDTLData",alDtlUpdateData);
		hmTableData.put("UpdateItemBatchData",alItemBtachUpdateRecord);
		hmTableData.put("UpdateIssueSeqData",alIssueSeqUpdateData);
		hmTableData.put("ReqFacilityId",getReq_Facility_id());
		hmTableData.put("alPendingQtyUpdRecord",alPendingQtyUpdRecord);
		hmTableData.put("checkedDValues",checkedDValues);
		hmTableData.put("alDeleteDtlRecord",alDeleteDtlRecord);
		hmTableData.put("alReqDtlZeroQtyData",alReqDtlZeroQtyData);//MO-CRF-20173 
//		System.out.println("hmTableData: "+hmTableData);  
				
		AuthorizeAtIssueStoreRemote authorizeAtIssueStoreRemote = null;
		try {
	
				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(StRepository.getStKeyValue("JNDI_ST_AUTHORIZE_AT_ISSUE_STORE"),AuthorizeAtIssueStoreHome.class,getLocalEJB());
				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				Object argArray[] = new Object[2];
				argArray[0] = hmTableData;
				argArray[1] = hmSQLMap;
		
				Class [] paramArray = new Class[2];
				paramArray[0] = hmTableData.getClass(); ;
				paramArray[1] = hmSQLMap.getClass();

			    hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			   (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			hmResult.put("message", getSTMessage(getLanguageId(),(String) hmResult.get("message"), "ST")) ;
			//hmResult.put("flag", "Doc No: "+getDoc_no()) ;

	/* SEND TO PRINT ONLINE REPORT STARTS 9/27/2004 */		
	        ArrayList doc_no	=	new ArrayList();//hmResult.get("doc_no");	
			doc_no.add(hmResult.get("doc_no"));
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest  = getRequest_on_store() ;
			ArrayList params = new ArrayList ();
			params.add(PgetStore_codest);
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_FOR_PRINT_PICKSLIP_YN_SELECT"),params).get("ALERT_FOR_PRINT_PICKSLIP_YN"));
			stReportid= "STBPKSLP";
			if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			{
				if ( isInternalRequest("ST",stReportid) &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{
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
							hmResult.put("flag",hmResult.get("flag") + "~PN"); //Added By Sakti Sankar on 06/03/2013 against Inc#
						}
				 }
			}
		
	/* SEND TO PRINT ONLINE REPORT ENDS*/	

		}
		catch(Exception e) {
			hmResult.put("message", e.toString());
			//Added by Rabbani #Inc no:28775 on 19/10/12 Starts
			String message = (String)hmResult.get("message");
			System.err.println("Auth manager.java,2328,message = > "+message);
			System.err.println("hmTableData = "+hmTableData);				
			System.err.println("hmSQLMap = "+hmSQLMap);
			if(message.contains("RECORD_UPDATED_BY_OTH_USER"))
			 {
				hmResult.put(MSGID,"RECORD_UPDATED_BY_OTH_USER");
				hmResult.put(MESSAGE,"RECORD_UPDATED_BY_OTH_USER");
			 }
			//ends
			e.printStackTrace();
		} 
		finally {
			try {
				if(authorizeAtIssueStoreRemote != null)
					authorizeAtIssueStoreRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString());
			}
		} 

		if (((Boolean) hmResult.get("result")).booleanValue() ) {
			initialize();
		}
		
		return hmResult;
	}
	
	/*public java.util.HashMap delete() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap	= new HashMap();
		ArrayList	alDeleteData = new ArrayList();
		Properties properties = getProperties();

		hmResult.put("result", new Boolean(false)) ;
		hmResult.put("message", "Delete Mode") ;

		alDeleteData.add(login_facility_id);
		alDeleteData.add(getDoc_type_code());
		alDeleteData.add(getDoc_no());
		
		hmTableData.put("properties",properties);
		hmTableData.put("DeleteHDRData",alDeleteData);
		hmTableData.put("DeleteDTLData",alDeleteData);
		hmSQLMap.put("DeleteHDRSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_HDR_DELETE"));
		hmSQLMap.put("DeleteDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_DTL_DELETE"));
	
		AuthorizeAtIssueStoreHome authorizeAtIssueStoreHome = null;
		AuthorizeAtIssueStoreRemote authorizeAtIssueStoreRemote = null;
		try {
			InitialContext context = new InitialContext();
			Object object = context.lookup(StRepository.getStKeyValue("JNDI_ST_AUTHORIZE_AT_ISSUE_STORE"));
			authorizeAtIssueStoreHome  = (AuthorizeAtIssueStoreHome) PortableRemoteObject.narrow(object, AuthorizeAtIssueStoreHome.class);
			authorizeAtIssueStoreRemote = authorizeAtIssueStoreHome.create();
			hmResult = authorizeAtIssueStoreRemote.delete(hmTableData, hmSQLMap);
			hmResult.put("msgid", hmResult.get("message")) ;
		}
		catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		finally {
			try {
				if(authorizeAtIssueStoreRemote != null)
					authorizeAtIssueStoreRemote.remove();
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString());
			}
		}
		return hmResult;
	}*/

	public ArrayList getBatchDetails(String item_code, String store_code)throws Exception {
		ArrayList BatchDetails=new ArrayList();
		Connection connection = null;
//		int isValidDocDate = -1;
		try {
			connection = getConnection();

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
		}
		catch(Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
		finally {
			closeConnection(connection);
		}
		return BatchDetails;
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
		return conv_fac_temp;
	}
	public String getGenItemUOM(String item_code) throws Exception {
		String chkdefaultParameters[] = {item_code,getLanguageId()};

		String gen_uom_code			  = "";	
		HashMap base_uom			  = new HashMap();
		try{
			//base_uom = fetchRecord("SELECT GEN_UOM_CODE FROM MM_ITEM WHERE ITEM_CODE=?",chkdefaultParameters);
				//base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),item_code);
				base_uom = fetchRecord(getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			gen_uom_code = "";
		}
		
		if(base_uom.size() > 0)
			gen_uom_code = (String)base_uom.get("GEN_UOM_CODE");
		return gen_uom_code;
	}*/
	public String getShortDesc(String item_code,String store_code) throws Exception {
		String chkdefaultParameters[] = {store_code,item_code,getLanguageId()};
		String short_desc			  = "";	
		HashMap short_des			  = new HashMap();
		try{
//			short_des = fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=(SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=?) AND LANGUAGE_ID=?",chkdefaultParameters);
				short_des = fetchRecord(getStRepositoryValue("SQL_ST_UOM_SHORT_DESC_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			short_desc = "";
		}
		
		if(short_des.size() > 0)
			short_desc = (String)short_des.get("SHORT_DESC");

		return short_desc;
	}
	public java.util.ArrayList getOnStores(String req_on_store) throws Exception {
			String chkParameters[] = {getLoginById(),getAcc_entity_id(),login_facility_id,getLanguageId(),req_on_store};
			ArrayList result = new ArrayList();
			result = fetchRecords(StRepository.getStKeyValue("SQL_ST_AUTH_AT_REQ_ON_STORE_SELECT"),chkParameters);
			
		
		return result;
	
	}
	
	public void ascOrder(){
		HashMap hmItemStore		=	getHmItemDetail();
		for(int i=0;i<arTempCode.size();i++){
			AuthorizeAtIssueStoreDetailBean requisitionIssueDetailBean = (AuthorizeAtIssueStoreDetailBean)hmItemStore.get(arTempCode.get(i));
			hmItemDetail.put(this.arTempCode.get(i),requisitionIssueDetailBean);
		}
		this.togglePoint = "DESC";
	}
	public void dscOrder(){
		HashMap hmItemStore		=	getHmItemDetail();
		for(int i=this.arTempCode.size()-1;i>0;i--){
			AuthorizeAtIssueStoreDetailBean requisitionIssueDetailBean = (AuthorizeAtIssueStoreDetailBean)hmItemStore.get(arTempCode.get(i));
			hmItemDetail.put(this.arTempCode.get(i),requisitionIssueDetailBean);
		}
		this.togglePoint = "ASC";
	}

	public String getDefaultItemClasses() {
		String sql = "SELECT   item_class_code, short_desc FROM mm_item_class_lang_vw WHERE eff_status = 'E' AND language_id = ? ORDER BY 2 "; //;eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getItem_class_code());
	}

public java.util.ArrayList getItemClasses(String req_on_store) throws Exception {
		String chkParameters[] = {req_on_store,getLanguageId()};
		ArrayList result = new ArrayList();
		result = fetchRecords("SELECT   b.item_class_code item_class_code, b.short_desc short_desc FROM ST_ITEM_CLASS_STORE a, mm_item_class_lang_vw b WHERE a.ITEM_CLASS_CODE=b.ITEM_CLASS_CODE and a.STORE_CODE=?  and b.eff_status = 'E' AND b.language_id = ? ORDER BY 2 ",chkParameters);
		return result;
	
	}
	public ArrayList getItemClasses(String request_on_store,String request_by_store) throws Exception {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(request_by_store);
		sqlParam.add(request_on_store);
		sqlParam.add(getLanguageId());
		return  fetchRecords(sql, sqlParam);
	}

	
	public ArrayList getDefaultItemClasses1() throws Exception {
		String sql = "SELECT   item_class_code, short_desc FROM mm_item_class_lang_vw WHERE eff_status = 'E' AND language_id = ? ORDER BY 2 "; //;eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLanguageId());
		return  fetchRecords(sql, sqlParam);
	}

	public ArrayList curerentPendingRequestDetalis(String request_by_store)throws Exception{
		ArrayList Doc_details = new ArrayList();
		ArrayList arr = new ArrayList();
		arr=getAddedItemKeys();
		if(arr.size()==0){
			arr=getItemKeys();
		}
			for(int i=0;i<arr.size();i++){
			ArrayList hh=new ArrayList();
			hh=fetchRecords("SELECT DTL.ITEM_CODE ITEM_CODE,MT.SHORT_DESC ITEM_DESC,HDR.REQ_ON_STORE_CODE REQ_ON_STORE_CODE , MS.SHORT_DESC REQ_ON_STORE_DESC,HDR.DOC_NO DOC_NO FROM ST_REQUEST_HDR HDR, ST_REQUEST_DTL DTL,MM_ITEM_LANG_VW MT,MM_STORE_LANG_VW MS WHERE HDR.REQ_BY_STORE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = ? AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.REQUEST_STATUS = 'W' AND HDR.FACILITY_ID = DTL.FACILITY_ID AND MT.ITEM_CODE=DTL.ITEM_CODE AND MS.STORE_CODE=HDR.REQ_ON_STORE_CODE AND MT.LANGUAGE_ID=MS.LANGUAGE_ID AND MT.LANGUAGE_ID=? and DTL.DOC_NO not in(?) ORDER BY DOC_NO",new String[]{request_by_store,(String)arr.get(i),getLanguageId(),checkForNull(getDoc_no(),"0")});
			if(hh.size()>0){
				Doc_details.add(hh);
			}
		}
		ArrayList arr1 = new ArrayList();
		arr1=getItemKeys();
	for(int i=0;i<arr1.size();i++){
		if(!arr.contains(arr1.get(i))){
			ArrayList hh=new ArrayList();
			hh=fetchRecords("SELECT DTL.ITEM_CODE ITEM_CODE,MT.SHORT_DESC ITEM_DESC,HDR.REQ_ON_STORE_CODE REQ_ON_STORE_CODE , MS.SHORT_DESC REQ_ON_STORE_DESC,HDR.DOC_NO DOC_NO FROM ST_REQUEST_HDR HDR, ST_REQUEST_DTL DTL,MM_ITEM_LANG_VW MT,MM_STORE_LANG_VW MS WHERE HDR.REQ_BY_STORE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = ? AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.REQUEST_STATUS = 'W' AND HDR.FACILITY_ID = DTL.FACILITY_ID AND MT.ITEM_CODE=DTL.ITEM_CODE AND MS.STORE_CODE=HDR.REQ_ON_STORE_CODE AND MT.LANGUAGE_ID=MS.LANGUAGE_ID AND MT.LANGUAGE_ID=? and DTL.DOC_NO not in(?) ORDER BY DOC_NO",new String[]{request_by_store,(String)arr1.get(i),getLanguageId(),checkForNull(getDoc_no(),"0")});
			if(hh.size()>0){
				Doc_details.add(hh);

			}
		}
	}
		return Doc_details;
	}

public void clearCheckedValues(){
		if (checkedDValues!= null) {
			checkedDValues.clear();
		}
	}

public String getMaxDocSrlNo()
	{
	String maxdocsrlno = "";
	try {
	java.util.ArrayList sqlParameter = new java.util.ArrayList(3);
			sqlParameter.add(doc_no);
			sqlParameter.add(doc_type_code);
			sqlParameter.add(login_facility_id);
			
			java.util.HashMap maxDocSrlNo = fetchRecord("SELECT NVL( MAX(doc_srl_no),0) DOC_SRL_NO FROM st_request_dtl dtl ,st_request_hdr hdr  WHERE hdr.doc_no = ?  AND hdr.doc_type_code =?  AND hdr.facility_id =?  AND dtl.DOC_NO = hdr.DOC_NO AND dtl.DOC_TYPE_CODE = hdr.DOC_TYPE_CODE AND dtl.FACILITY_ID = hdr.FACILITY_ID",sqlParameter);
			 maxdocsrlno = checkForNull((String)maxDocSrlNo.get("DOC_SRL_NO"),"0");
	} catch(Exception exc)
		{
		exc.printStackTrace();
		}
	 return  maxdocsrlno;
	}
	public HashMap modifiedTableData(HashMap hmTableData,String trn_type){
		String item_class_code = "";
		int records_per_trn = getRecordsPerTrn(trn_type);
		ArrayList<Integer> alCount =  new ArrayList<Integer>();
		ArrayList<String> alTempData = new ArrayList<String>();
		ArrayList<ArrayList> alNewTempData = new ArrayList<ArrayList>();
		ArrayList<ArrayList> alNewReqHdrData = new ArrayList<ArrayList>();
		ArrayList<ArrayList> alNewReqDtlData = new ArrayList<ArrayList>();
		ArrayList<ArrayList> alNewDTLEXPData = new ArrayList<ArrayList>();
		ArrayList<String> alItemClassData = new ArrayList<String>();
		ArrayList<String> alNewItemClassData = new ArrayList<String>();
		ArrayList<String> alTempDTLEXPData = new ArrayList<String>();
		ArrayList<String> alTempReqDtlData = new ArrayList<String>();
		ArrayList<ArrayList> alItemDtlData = (ArrayList<ArrayList>)hmTableData.get("InsertDTLData");
		ArrayList<ArrayList> alReqDtlData = (ArrayList<ArrayList>)hmTableData.get("InsertReqDtlData");
		ArrayList<ArrayList> alDTLEXPData = (ArrayList<ArrayList>)hmTableData.get("InsertDTLEXPData");
		ArrayList<ArrayList> alNewItemHdrData = new ArrayList<ArrayList>();//hmTableData.get("InsertHDRData");
		ArrayList<String> alItemHdrData = (ArrayList<String>)hmTableData.get("InsertHDRData");
		ArrayList<String> alReqHdrData = (ArrayList<String>)hmTableData.get("InsertReqHdrData");
		for(int i=0;i<alItemDtlData.size();i++){
			alTempData = (ArrayList<String>)alItemDtlData.get(i);
			try{
				item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",alTempData.get(6)).get("ITEM_CLASS_CODE");
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
					item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",alTempData.get(6)).get("ITEM_CLASS_CODE");
					if(item_class_code.equals(alItemClassData.get(i))){
						//++count;
						if(k>=records_per_trn){
							alCount.add(k);
							k = 0;
							alNewItemClassData.add(item_class_code);
							//continue;
						}
						(alItemDtlData.get(j)).set(4,++k);
						alNewTempData.add(alItemDtlData.get(j));
						for(int m=0;m<alReqDtlData.size();m++){
							alTempReqDtlData = new ArrayList<String>();
							alTempReqDtlData = alReqDtlData.get(m);
							if((alTempData.get(6)).equals(alTempReqDtlData.get(4))){
								alTempReqDtlData.set(3,""+k);
								alNewReqDtlData.add(alReqDtlData.get(m));
							}
						}
						for(int m=0;m<alDTLEXPData.size();m++){
							alTempDTLEXPData = new ArrayList<String>();
							alTempDTLEXPData = alDTLEXPData.get(m);
							if((alTempDTLEXPData.get(6)).equals(alTempData.get(6))){
								alTempDTLEXPData.set(4,""+k);
								alNewDTLEXPData.add(alDTLEXPData.get(m));
							}
						}
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
			alTemp.set(15,alNewItemClassData.get(i));
			alNewItemHdrData.add(alTemp);
		}
		for(int i=0;i<alNewItemClassData.size();i++){
			ArrayList<String> alTemp = new ArrayList<String>();
			for(int j=0;j<alReqHdrData.size();j++){
				alTemp.add(alReqHdrData.get(j));
			}
			alTemp.set(5,alNewItemClassData.get(i));
			alNewReqHdrData.add(alTemp);
		}
		hmTableData.put("InsertDTLData",alNewTempData);
		hmTableData.put("InsertHDRData",alNewItemHdrData);
		hmTableData.put("InsertReqHdrData",alNewReqHdrData);
		hmTableData.put("InsertReqDtlData",alNewReqDtlData);
		hmTableData.put("InsertDTLEXPData",alNewDTLEXPData);
		hmTableData.put("ItemClassCount",alCount);
		hmTableData.put("ItemClass",alNewItemClassData);
		hmTableData.put("ITEM_CLASS_BASED","Y");
		return hmTableData;
	}
/**/
	public HashMap<String,String> getConvFactTemp(String item_code,String fm_store_code,String to_store_code,String issue_uom,String uom_string){
		HashMap<String,String> conv_factors = new HashMap<String,String>();
		String conv_fac_fm_temp = "";
		String conv_fac_to_temp = "";
		String conv_fac_issue_uom = "";
		int fm_str_eqvl = 1;
		int fm_str_eqvl_qty = 1;
		int to_str_eqvl = 1;
		int to_str_eqvl_qty = 1;
		int issue_uom_eqvl = 1;
		int issue_uom_eqvl_qty = 1;
		
		int fm_str_eqvl_temp = 1;
		int fm_str_eqvl_qty_temp = 1;
		int to_str_eqvl_temp = 1;
		int to_str_eqvl_qty_temp = 1;
		int issue_uom_eqvl_temp = 1;
		int issue_uom_eqvl_qty_temp = 1;
		try {
			conv_fac_fm_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,fm_store_code}).get("CONV_FACTOR");
			conv_fac_to_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,to_store_code}).get("CONV_FACTOR");
			conv_fac_to_temp=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_DUO_STR(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,to_store_code}).get("CONV_FACTOR");
			conv_fac_issue_uom=(String)fetchRecord("SELECT ST_GET_UOM_CONV_FACTOR_UOM(?,?) CONV_FACTOR FROM DUAL",	new String[]{item_code,issue_uom}).get("CONV_FACTOR");
		}catch(Exception e){
			e.printStackTrace();
		}
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
/**/
		fm_str_eqvl_qty = fm_str_eqvl_qty_temp / gcd(fm_str_eqvl_temp,fm_str_eqvl_qty_temp);
		fm_str_eqvl = fm_str_eqvl_temp / gcd(fm_str_eqvl_temp,fm_str_eqvl_qty_temp);
		to_str_eqvl_qty = to_str_eqvl_qty_temp / gcd(to_str_eqvl_temp,to_str_eqvl_qty_temp);
		to_str_eqvl = to_str_eqvl_temp / gcd(to_str_eqvl_temp,to_str_eqvl_qty_temp);
		issue_uom_eqvl_qty = issue_uom_eqvl_qty_temp / gcd(issue_uom_eqvl_temp,issue_uom_eqvl_qty_temp);
		issue_uom_eqvl = issue_uom_eqvl_temp / gcd(issue_uom_eqvl_temp,issue_uom_eqvl_qty_temp);
		int common_lcm = (getLcm(getLcm(fm_str_eqvl,to_str_eqvl),issue_uom_eqvl));
		int issue_uom_multiple = (getLcm(getLcm(fm_str_eqvl,to_str_eqvl),issue_uom_eqvl)*issue_uom_eqvl_qty)/issue_uom_eqvl;
		conv_factors.put("FROM_STORE_MULTIPLES",""+(common_lcm*fm_str_eqvl_qty)/fm_str_eqvl);
		conv_factors.put("TO_STORE_MULTIPLES",""+(common_lcm*to_str_eqvl_qty)/to_str_eqvl);
		if(uom_string.equals("REQ_UOM")){
			conv_factors.put("REQ_UOM_MULTIPLES",""+issue_uom_multiple);
			conv_factors.put("REQ_BATCH_QTY_MULTIPLES",""+common_lcm);
		}else{
			conv_factors.put("ISSUE_UOM_MULTIPLES",""+issue_uom_multiple);
			conv_factors.put("BATCH_QTY_MULTIPLES",""+common_lcm);
		}

		return conv_factors;
	}

/**/

public int getEntityparam_EWDay(String ACC_ENTITY_ID) throws Exception{
		
		int IEWDays = 0;
		try {
				IEWDays = getEntityparam_EWDays(ACC_ENTITY_ID);
			}
            
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		
		return IEWDays;
	}
public String getDefaultBinLocationCode(String store_code,String item_code) throws Exception{


		String def_Bin_Loc= "";
		String []stParameters={store_code,item_code};
		HashMap hmResult = new HashMap();

		ArrayList tempAl = fetchRecords(getStRepositoryValue("SQL_ST_DEF_TO_STORE_TO_BIN"),stParameters) ;
        
		if(tempAl.size()>0){
           hmResult = (HashMap)tempAl.get(0) ;
           def_Bin_Loc =  (String)hmResult.get("BIN_LOCATION_CODE") ;

        }else{

		   def_Bin_Loc="";
		}
		

		return def_Bin_Loc;
	}
public void updateCloseItemYN(String item_code, String closeYN){

	setCloseItemMap(item_code, closeYN); 
//	System.out.println("closeItemMap: "+closeItemMap);
//	System.out.println("closeItemMap values : "+closeItemMap.values());  
	ArrayList<String> list = new ArrayList<String>(closeItemMap.values()); 
//	System.out.println("list: "+list); 
	setCloseItemList(list); 
//	System.out.println("getCloseItemList: "+getCloseItemList());  
}
public void updateItemRemarks(String item_code, String remarks){

	setItemRemarksMap(item_code, remarks);
//	System.out.println("itemRemarksMap: "+itemRemarksMap);
//	System.out.println("itemRemarksMap values : "+itemRemarksMap.values());  
}
//MO-CRF-20173 END
public void updateExpRecords(String item_code, Hashtable htExpRecords){
		ArrayList alExpRecords = new ArrayList();

		

		for (int i=0;i<Integer.parseInt((String)htExpRecords.get("total_checkboxes")); i++) {
			HashMap hmExpRecord	=	new HashMap();
			
			hmExpRecord.put("STORE_CODE",htExpRecords.get("store_code"));
			hmExpRecord.put("ITEM_CODE",htExpRecords.get("item_code"));
			hmExpRecord.put("QTY",	htExpRecords.get("item_qty_"+i));
			hmExpRecord.put("BATCH_ID",htExpRecords.get("batch_id_"+i));
			hmExpRecord.put("BIN_LOCATION_CODE",htExpRecords.get("bin_location_code_"+i));
			hmExpRecord.put("BIN_DESC",htExpRecords.get("bin_desc_"+i));
			hmExpRecord.put("AVAIL_QTY",htExpRecords.get("avail_qty_"+i));
			hmExpRecord.put("EXPIRY_DATE",htExpRecords.get("expiry_date_or_receipt_date_"+i));
			hmExpRecord.put("TO_BIN_LOCATION_CODE",	htExpRecords.get("to_bin_location_code_"+i));
			hmExpRecord.put("TRADE_ID",htExpRecords.get("trade_id_"+i));
			hmExpRecord.put("TRADE_NAME",htExpRecords.get("trade_name_"+i));
			hmExpRecord.put("MANUFACTURER_NAME",htExpRecords.get("manufacturer_name_"+i));
			hmExpRecord.put("NOD",htExpRecords.get("nod_"+i));
			hmExpRecord.put("EXPIRY_YN",htExpRecords.get("expiry_yn_"+i));
			hmExpRecord.put("BATCH_STATUS",htExpRecords.get("batch_status_"+i));
			
			alExpRecords.add(hmExpRecord);
		}

		setExpRecords(item_code, alExpRecords);
	}

	public void setExpRecords(String item_code, ArrayList alExpRecords){
		hmExpRecords.put(item_code,alExpRecords);
	}
	
	public ArrayList getExpRecords(String item_code){
		return (ArrayList)hmExpRecords.get(item_code);
	}

	public HashMap getExpRecords(){
		return hmExpRecords;
	}
	
	
	//start temporary records 
	
	
	public void updateTempRecords(String item_code, Hashtable htExpRecords){
		ArrayList alExpRecords = new ArrayList();

		

		for (int i=0;i<Integer.parseInt((String)htExpRecords.get("total_checkboxes")); i++) {
			HashMap hmExpRecord	=	new HashMap();
			if(htExpRecords.get("item_qty_"+i) != null && htExpRecords.get("item_qty_"+i) != ""){
			hmExpRecord.put("STORE_CODE",htExpRecords.get("store_code"));
			hmExpRecord.put("ITEM_CODE",htExpRecords.get("item_code"));
			hmExpRecord.put("QTY",	htExpRecords.get("item_qty_"+i));
			hmExpRecord.put("BATCH_ID",htExpRecords.get("batch_id_"+i));
			hmExpRecord.put("BIN_LOCATION_CODE",htExpRecords.get("bin_location_code_"+i));
			hmExpRecord.put("BIN_DESC",htExpRecords.get("bin_desc_"+i));
			hmExpRecord.put("AVAIL_QTY",htExpRecords.get("avail_qty_"+i));
			hmExpRecord.put("EXPIRY_DATE",htExpRecords.get("expiry_date_or_receipt_date_"+i));
			hmExpRecord.put("TO_BIN_LOCATION_CODE",	htExpRecords.get("to_bin_location_code_"+i));
			hmExpRecord.put("TRADE_ID",htExpRecords.get("trade_id_"+i));
			hmExpRecord.put("TRADE_NAME",htExpRecords.get("trade_name_"+i));
			hmExpRecord.put("MANUFACTURER_NAME",htExpRecords.get("manufacturer_name_"+i));
			hmExpRecord.put("NOD",htExpRecords.get("nod_"+i));
			hmExpRecord.put("EXPIRY_YN",htExpRecords.get("expiry_yn_"+i));
			hmExpRecord.put("BATCH_STATUS",htExpRecords.get("batch_status_"+i));
			
			alExpRecords.add(hmExpRecord);
			}
		}

		setTempRecords(item_code, alExpRecords);
	}

	public void setTempRecords(String item_code, ArrayList alExpRecords){
		hmTempRecords.put(item_code,alExpRecords);
	}
	
	public ArrayList getTempRecords(String item_code){
		return (ArrayList)hmTempRecords.get(item_code);
	}
	//Added for IN:071868 start
	public void updTempRecords(String item_code){
		boolean isKeyPresent = hmTempRecords.containsKey(item_code);
		if(isKeyPresent)
			hmTempRecords.remove(item_code);	
	}
	//Added for IN:071868 end
	public HashMap getTempRecords(){
		return hmTempRecords;
	}

	
	//end temporary records
	
	public ArrayList getBatchStatus(String stItem_code,String stBatch_id,String stExpiry_date) throws Exception{
		

		String chkParameters[] = {stItem_code,stBatch_id,stExpiry_date};
         
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_BATCH_STATUS_SELECT_QUERY"),chkParameters);

		return result;
	}
	public ArrayList getBatchDetails(String item_code,String store_code, String item_qty)throws Exception{ //declared Exception by suresh.r against ML-BRU-SCF-1005[IN:43173]
		ArrayList alDtlExpInsertRecord = new ArrayList();
		HashMap hmResult = new HashMap();
		
		/*commented for GHL-CRF-0499 start*/
		/*String itemCd="";
		String StoreCd="";
		String batchID="";
		String expDate="";
		String binLocCode="";
		String challan_no="";*/
		/*commented for GHL-CRF-0499 end */
		
		//HashMap hmRecord = new HashMap();
		
		AuthorizeAtIssueStoreDetailBean authorizeAtIssueStoreDetailBean;
		if(!checkedDValues.contains(item_code)){
		
			try {
				StUtilities stUtilities = new StUtilities(properties);
				HashMap hmParameters	=	new HashMap();
				stUtilities.setLanguageId(getLanguageId());
				stUtilities.setLoginById(getLoginById());//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
				hmParameters.put("ITEM_CODE",item_code);
				hmParameters.put("STORE_CODE",store_code);
				hmParameters.put("TRN_QTY",item_qty);
				hmParameters.put("INCLUDE_SUSPENDED","FALSE");//optional, by default FALSE
				hmParameters.put("INCLUDE_EXPIRED","FALSE");//optional, by default FALSE
				hmParameters.put("VERIFY_INSUFFICIENT_QTY","TRUE");//optional, by default TRUE
				hmParameters.put("AUTHORIZE_YN", "Y"); // Added for MMS-DM-SCF-0244 by B.Badmavathi on 06/06/2016

				//System.out.println("Modify, hmParameters = >"+hmParameters);

				java.util.HashMap dataValue = stUtilities.getBatches(hmParameters);
		
				java.util.ArrayList expBatchDetails = (ArrayList) dataValue.get("BATCH_DATA");
		
			
				if (Double.parseDouble(item_qty) > 0)
				{
				
				for (int cnt=0; cnt<expBatchDetails.size();cnt++) {
				
					java.util.HashMap tempExpBatchDtl =  (java.util.HashMap) expBatchDetails.get(cnt);
					authorizeAtIssueStoreDetailBean = (AuthorizeAtIssueStoreDetailBean) hmItemDetail.get(tempExpBatchDtl.get("ITEM_CODE"));
					//java.util.ArrayList alDtlExpRecord = new java.util.ArrayList(17);
				//Added against ML-MMOH-SCF-0635 starts
					String to_bin_locn = "";
					if(authorizeAtIssueStoreDetailBean == null){
						String[] strParameters = new String[7];
						strParameters[0] = item_code;
						strParameters[1] = (String)getRequest_on_store();
						strParameters[2] = "0";
						strParameters[3] = "N";
						strParameters[4] = "";//stHeaderBean.getSysDate();
						strParameters[5] = "N";
						strParameters[6] = (String)getRequest_by_store();
						java.util.HashMap stockValues = getStockAvailabilityStatus(strParameters);
						 to_bin_locn = (String)stockValues.get("to_store_master_bin");
					}
				//Added against ML-MMOH-SCF-0635 ends					
					HashMap hRecord = new HashMap();
					
					hRecord.put("STORE_CODE",tempExpBatchDtl.get("STORE_CODE"));
					hRecord.put("ITEM_CODE",tempExpBatchDtl.get("ITEM_CODE"));
					hRecord.put("QTY",tempExpBatchDtl.get("QTY"));
					hRecord.put("BATCH_ID",tempExpBatchDtl.get("BATCH_ID"));
					hRecord.put("BIN_LOCATION_CODE",tempExpBatchDtl.get("BIN_LOCATION_CODE"));
					hRecord.put("BIN_DESC",tempExpBatchDtl.get("BIN_DESC"));
					hRecord.put("EXPIRY_DATE",tempExpBatchDtl.get("EXPIRY_DATE"));
					hRecord.put("QTY",tempExpBatchDtl.get("QTY"));
					hRecord.put("AVAIL_QTY",tempExpBatchDtl.get("AVAIL_QTY"));
					hRecord.put("TRADE_ID",tempExpBatchDtl.get("TRADE_ID"));
					hRecord.put("TRADE_NAME",tempExpBatchDtl.get("TRADE_NAME"));
					hRecord.put("NOD",tempExpBatchDtl.get("NOD"));
					hRecord.put("EXPIRY_YN",tempExpBatchDtl.get("EXPIRY_YN"));
					hRecord.put("BATCH_STATUS",tempExpBatchDtl.get("BATCH_STATUS"));
					hRecord.put("MANUFACTURER_NAME",tempExpBatchDtl.get("MANUFACTURER_NAME"));
					//Modified against ML-MMOH-SCF-0635 starts
					//	hRecord.put("TO_BIN_LOCATION_CODE",authorizeAtIssueStoreDetailBean.getTo_bin_location_code());
					if(to_bin_locn.length() > 0)
						hRecord.put("TO_BIN_LOCATION_CODE",checkForNull(to_bin_locn, ""));
					else
						hRecord.put("TO_BIN_LOCATION_CODE",authorizeAtIssueStoreDetailBean.getTo_bin_location_code());
					//Modified against ML-MMOH-SCF-0635 ends
					
					/*commented for GHL-CRF-0499 START*/
				/*	if(getCustomerID().equals("MC")){
						itemCd=(String)tempExpBatchDtl.get("ITEM_CODE");
						StoreCd=(String)tempExpBatchDtl.get("STORE_CODE");
						batchID = (String)tempExpBatchDtl.get("BATCH_ID");
						expDate = (String)tempExpBatchDtl.get("EXPIRY_DATE");
						binLocCode =(String)tempExpBatchDtl.get("BIN_LOCATION_CODE");
						System.out.println("itemCd: "+itemCd+" "+"StoreCde: "+StoreCd+" "+"batchid: "+batchID+" "+"expDate: "+expDate+ " "+"binLocCode"+binLocCode);
						challan_no = getChallanNo(itemCd,batchID,expDate);
						System.out.println("challan_no in AuthoriseAtIssueStoreBean.java: "+challan_no); 
						hRecord.put("CHALLAN_NO",challan_no);
					}*/
					 
					/*commented for GHL-CRF-0499 END*/
					
					alDtlExpInsertRecord.add(hRecord);
				}
				
				
				
				}
			}
			catch (InsufficientBatchException insufficient) {
				
				hmResult.put("msgid", "INSUFFICIENT_BATCH_QTY");
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;

				hmResult.put("flag", item_code);
				insufficient.printStackTrace();
				throw insufficient;//Added by suresh.r against ML-BRU-SCF-1005[IN:43173] on 28-04-2014
			
			}
			catch (Exception exception) {
				hmResult.put("message", exception.getMessage());
				hmResult.put("flag", "");
				exception.printStackTrace();
			
			}
		}
		
		return alDtlExpInsertRecord;
		
	}
	//Added for MMS-DM-CRF-0097 starts
	public String getReq_by_avail_qty(String item_code){
		  double avail_stock	=	0;
		  int no_of_decimals = 0;
		  String avail_qty ="";
			if((getAllowDecimalsYN(item_code)).equals("Y")){
				no_of_decimals = getNoOfDecimals();
			}
		  String[] stParameters	= {item_code, getRequest_by_store(), "0", "N", "", "N", getRequest_on_store()};
		  try {
			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(stParameters);
			avail_stock	=	Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))/(getConvFactTemp(item_code,getRequest_by_store()));
			avail_qty = setNumber(""+avail_stock,no_of_decimals);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  return avail_qty;
	}
	//Added for MMS-DM-CRF-0097 ends
	
	 //added for ML-MMOH-SCF-1003 START
	public double getConvFactTemp1(String item_code,String store_code){
		 
//	 	System.out.println("getConvFactTemp1");  
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
	/*	System.out.println("gen_uom: "+gen_uom);
		System.out.println("defult_issue_uom: "+defult_issue_uom);
		System.out.println("defult_request_uom: "+defult_request_uom);*/
		
		if(!gen_uom.equals(defult_request_uom)){
			eqlParameters.add(defult_request_uom);
		    eqlParameters.add(defult_issue_uom);
			conv_fac_temp=Double.parseDouble(checkForNull((String)fetchRecord(getStRepositoryValue("SQL_ST_AM_UOM_EQL_CONVERSION_SELECT"),	eqlParameters).get("eqvl_value"),"1.0"));
			//System.out.println("conv_fac_temp in if condn: "+conv_fac_temp);
		}else{
                 conv_fac_temp =  getConvFactTemp(item_code,getRequest_by_store());
           //      System.out.println("conv_fac_temp in else condn: "+conv_fac_temp);
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
	/*ml-mmoh-scf-1003 END*/
	
	/*added for ghl-crf-0499 start, modified for GHL-ICN-0032*/	
public String getChallanNo(String item_code,String batch_id,String expiry_date,String storeCd){
	Connection connection			 =		null ;
	PreparedStatement pstmt	 =		null ;
	ResultSet resultSet				 =		null ;
	HashMap hmChallan			  = new HashMap();
	ArrayList alParameters	=	new ArrayList();
	String challan_no =	"";
	String challNo="";
	String batchid= "";
	String consignment_yn = getConsignment_yn(item_code); 
	//setting challan_no to null when item is not a consignment item
	if(consignment_yn.equalsIgnoreCase("N")){
		challan_no="";
		return challan_no;
	}
	//ADDED FOR GHL-ICN-0030 START
	String vmi_batch_id="";
	try {		
		if(batch_id.contains("-")){
		//	String[] arrOfStr = batch_id.split("-", 2);
		//	batchid = arrOfStr[0];
		//	challNo =arrOfStr[1];
		connection=getConnection();
				pstmt		= connection.prepareStatement("select VMI_BATCH_ID from st_item_batch where item_code=? and batch_id=? and EXPIRY_DATE_OR_RECEIPT_DATE=TO_DATE(?,'DD/MM/YYYY') and store_code= ? ");
				pstmt.setString(1,item_code);
				pstmt.setString(2,batch_id);
				pstmt.setString(3,expiry_date);
				pstmt.setString(4,storeCd);
				
				resultSet	= pstmt.executeQuery() ;
				
				
				if(resultSet.next())
					vmi_batch_id=resultSet.getString("VMI_BATCH_ID");
				
				int batch_id_length=vmi_batch_id.length();
				if(batch_id_length>10)
					batch_id_length=10;
				batchid=batch_id.substring(0,batch_id_length);
				challNo=batch_id.substring(batch_id_length+2,batch_id.length());
				//ADDED FOR GHL-ICN-0030 END
			//System.out.println("batch id :"+batchid); 
		}
		else{
			batchid=batch_id;
		}
		challNo = '%'+challNo+'%';
		alParameters.add(item_code);
		alParameters.add(vmi_batch_id);//ADDED FOR GHL-ICN-0030
		alParameters.add(expiry_date);
		alParameters.add(challNo);
		hmChallan = fetchRecord("SELECT CHALLAN_NO FROM XI_TRN_GRN WHERE ITEM_CODE= ? AND BATCH_ID= ? AND TRUNC(EXPIRY_DATE) = TO_DATE (?,'DD/MM/YYYY') AND CHALLAN_NO LIKE ?  ",alParameters);
		challan_no = (String)hmChallan.get("CHALLAN_NO");
	}
	catch ( Exception e ) {
		e.printStackTrace() ;
	}
	finally {
		try {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection );
		}
		catch(Exception es) { 
			es.printStackTrace() ;
		}
	}
	return challan_no;
}

	public String getConsignment_yn(String item_code){
		String consignment_yn		  = "";	
		HashMap consignmentMap			  = new HashMap();
		try{
			consignmentMap = fetchRecord("SELECT CONSIGNMENT_ITEM_YN FROM ST_ITEM WHERE ITEM_CODE = ?",item_code);
		}catch(Exception e){
			consignment_yn = "";
		}
	/*added for ghl-crf-0499 end*/
		if(consignmentMap.size() > 0)
			consignment_yn = (String)consignmentMap.get("CONSIGNMENT_ITEM_YN");

		return consignment_yn;
}	 
	//added for MO-CRF-20173
	public boolean getCloseItemValue(){
		boolean returnVal = false;
		//System.out.println("closeItemMap: "+closeItemMap);
		if(closeItemMap.containsValue("Y")){
		//	System.out.println("contains value Y");
			returnVal = true;
		}
		return returnVal;
	}
}
