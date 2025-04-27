/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------
06/04/2017				IN063878				Badmavathi B					        					 Unused variables
27/01/2021              TFS ID:-13356           Haribabu                                                     PH-MMS-DM-CRF-0174.2-US002/04 - Issue Return
23/2/2022				TFS27891				Shazana														MO-CRF-20176
-------------------------------------------------------------------------------------------------------------------------------
*/  
 package eST ;

import eST.IssueReturn.IssueReturnHome;
import eST.IssueReturn.IssueReturnRemote;
//import eCommon.Common.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.io.Serializable;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;
//import java.util.Properties;

//import eST.Common.StHeaderBean;
//import eST.Common.StAdapter;
//import eST.Common.StTransaction;
//import eST.Common.StEJBSessionAdapter;
//import eST.Common.StRepository;

//import eCommon.Common.CommonAdapter;
//port eCommon.Common.CommonEJBSessionInterface;

//port javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
//port javax.servlet.http.HttpSession;
import javax.servlet.* ;
import javax.servlet.http.*;




public class IssueReturnBean extends eST.Common.StDuoHeaderBean implements java.io.Serializable {

	java.util.HashMap hmItemDetail;
//ava.util.HashMap hmItemDetailExp;
//ava.util.HashMap hmItemDetailExpKeys;
	java.util.ArrayList itemKeys;

	
	
	private String seq_no;
	private String issue_date;
	private String finalized_yn;
	private String remarks;
	private String close_req_after_issue_yn;
	private String cancel_request_yn;
	private String availableQty;
	private boolean isAutoNo;
	//private String doc_no="";
	private ArrayList PDocNo = new ArrayList();
	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
	private String acc_entity_id = "";
	private String stReportid = null;

	private ArrayList	alMinMaxRecords=new ArrayList();

/*	private String seq_no;
	private String trn_type;
	private String PDocNo ;

	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
    private String PgetTrnType = "";
	private String PgetSeqNo = "";*/

//	private String stReportid = null;

	

	private String ret_doc_type_code;
	private String ret_doc_no;
	private String ret_doc_date;
	private String ret_doc_ref;
	private String defaultDocType ;

    private String from_store_code ;
	private String to_store_code ;

    private String from_store_description ;
	private String to_store_description ;
	private String doc_type_description ;
	private String item_class_description ;
	


	private String records_to_delete ;

	public double dAvg_unit_cost;

	boolean autoGenerateYN=false;
	public String reportserver = "";
	public String report_connect_string = "";
	public String issue_doc_type_code = "";
	public String issue_doc_no = "";

	private HashMap		hmExpRecords=new HashMap();
	private ArrayList		alTempExpRecords=new ArrayList();//Added against GHL-CRF-0413
	private ArrayList	alDtlRecords=new ArrayList();
	private int doc_srl_no	=	0;
	private double	tmpConv		=	1;
	private double	frm_tmp_conv		=	1;

	private String alt_facility_id = "" ;

/*	private javax.servlet.http.HttpServletRequest request;
	private javax.servlet.http.HttpServletResponse response;

	public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; 
		this.response=response	;
	}*/
	

	public IssueReturnBean() {
		hmItemDetail = new java.util.HashMap();	
//hmItemDetailExp = new java.util.HashMap();
//hmItemDetailExpKeys = new java.util.HashMap();
		itemKeys = new java.util.ArrayList();
	}
	public void setTempConvFact(double tmpConv){
		this.tmpConv=tmpConv;
	}
	public double getTempConvFact(){
		return tmpConv;
	}
	public void setIssueDocTypeCode(String issue_doc_type_code){
		this.issue_doc_type_code=issue_doc_type_code;
	}
	public String getIssueDocTypeCode(){
		return this.issue_doc_type_code;
	}

	public void setIssueDocNo(String issue_doc_no){
		this.issue_doc_no=issue_doc_no;
	}
	public String getIssueDocNo(){
		return this.issue_doc_no;
	}

		
	public void setFromTempConvFact(double frm_tmp_conv){
		this.frm_tmp_conv=frm_tmp_conv;
	}
	public double getFromTempConvFact(){
		return frm_tmp_conv;
	}
	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}

	public ArrayList getPrintDocNo(){
		return PDocNo;
	}

	public java.util.HashMap getHmItemDetail() {
		return this.hmItemDetail;
	}

	public java.util.ArrayList getItemKeys() {
		return this.itemKeys;
	}

	public void setSeq_no(String seq_no) {
		this.seq_no = seq_no;
	}

	public String getSeq_no() {
		return this.seq_no;
	}
	
	public void setIsAutoNo(boolean isAutoNo) {
		this.isAutoNo = isAutoNo;
	}

	public boolean setIsAutoNo() {
		return this.isAutoNo;
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

    public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}

	public void setDoc_type_code(String ret_doc_type_code) {
		this.ret_doc_type_code = ret_doc_type_code;
	}

	public String getDoc_type_code() {
		return this.ret_doc_type_code;
	}

	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("RET",defaultDocType);
	}
	public void setAcc_entity_id(String acc_entity_id) {
		this.acc_entity_id = acc_entity_id;	
	}
	
	public String getAcc_entity_id(){
		return this.acc_entity_id;
	}
     public String getBinLocation_desc(String bin_code) {
		String bin_desc="";
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(bin_code);
			arr_language.add(getLanguageId());
			bin_desc=fetchRecord(getStRepositoryValue("SQL_ST_BIN_LOCATION_DESC"), arr_language).get("SHORT_DESC").toString() ;
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return bin_desc;
    }


	String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}

	public String getFinalize_allowed_yn(String stStore_code) throws Exception{
		String stParameters[]	=	{getLoginById(), stStore_code};
		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		return hmRecord.get("RET_FINALIZE_ALLOWED_YN").toString();
	}
	public String getFromStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_QRY_ST_ISSUE_RET_FROM_STORE");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getFrom_store_code());
	}

	public String getToStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_RET_TO_STORE");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(getLoginById());
		sqlParam.add(getAccEntityID());
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getTo_store_code());
	}

	public String getItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(getFrom_store_code());
		sqlParam.add(getTo_store_code());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getItem_class_code());
	}

	public String getAllItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(getLanguageId());
		return getListValues(sql,sqlParam,"");
	}

	public void setDoc_no(String ret_doc_no) {
		this.ret_doc_no = ret_doc_no;
	}

	public String getDoc_no() {
		return this.ret_doc_no;
	}
	
	public void setDoc_date(String ret_doc_date) {
		this.ret_doc_date = ret_doc_date;
	}

	public String getDoc_date() {
		return this.ret_doc_date;
	}

	public void setDoc_ref(String ret_doc_ref) {
		this.ret_doc_ref = ret_doc_ref;
	}

	public String getDoc_ref() {
		return this.ret_doc_ref;
	}


   public void setFrom_store_code(String from_store_code) {
		this.from_store_code = from_store_code;
	}

	public String getFrom_store_code() {
		return from_store_code;
	}

   public void setTo_store_code(String to_store_code) {
		this.to_store_code = to_store_code;
	}

   public String getTo_store_code() {
		return to_store_code;
	}


	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public String getIssue_date() {
		return this.issue_date;
	}

	public String getAvailableQty() {
		return this.availableQty;
	}

	public void setFinalized_yn(String finalized_yn) {
		this.finalized_yn = finalized_yn;
	}

	public String getFinalized_yn() {
		return this.finalized_yn;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setCancel_request_yn(String cancel_request_yn) {
		this.cancel_request_yn = cancel_request_yn;
	}

	public String getCancel_request_yn() {
		return this.cancel_request_yn;
	}

	public void setClose_req_after_issue_yn(String close_req_after_issue_yn) {
		this.close_req_after_issue_yn = close_req_after_issue_yn;
	}

	public String getClose_req_after_issue_yn() {
		return this.close_req_after_issue_yn;
	}

	public int getNextDoc_srl_no(){
		return ++doc_srl_no;
	}

	public int getDoc_srl_no(){
		return doc_srl_no;
	}

	public ArrayList getDtlRecords(){
		return alDtlRecords;
	}


	public ArrayList getExpRecords(int index){
		return (ArrayList)hmExpRecords.get(""+index);
	}

	public HashMap getExpRecords(){
		return hmExpRecords;
	}

	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete= records_to_delete;
	}

	public void setAltFacilityId(String facility_id){
	
	this.alt_facility_id = facility_id ;
	}
	
	public String getAltFacilityId()
	{
		return alt_facility_id ; 
	}

	public String getRecords_to_delete( ) {
		 return records_to_delete;
	}

	
	public void setExpRecords(int index, ArrayList alExpRecords){

		if (index==-1) {
			index	=	alDtlRecords.size();
		}
   		hmExpRecords.put(""+index,alExpRecords);
	}

	public void updateMinMaxRecords(int index, HashMap hmMinMaxRecord){        // Min Max Validation by Rammohan.C 11/8/2006
		String mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");

		if (index!=-1){
			mode	=	(String)((HashMap)alMinMaxRecords.get(index)).get("mode");
		}
		hmMinMaxRecord.put("mode",mode);		
		if (index==-1){
//			hmDtlRecord.put("doc_srl_no",""+getNextDoc_srl_no());
			alMinMaxRecords.add(hmMinMaxRecord);
		}
		else {
			alMinMaxRecords.set(index, hmMinMaxRecord);
		}
	}

	public HashMap getMinMaxRecord(int index){
	
		return (HashMap)alMinMaxRecords.get(index);
	}

	public ArrayList getMinMaxRecords(){
		return alMinMaxRecords;
	}

	public void updateDtlRecord(int index, HashMap hmDtlRecord){
		String mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");

		if (index!=-1){
			mode	=	(String)((HashMap)alDtlRecords.get(index)).get("mode");
		}

		hmDtlRecord.put("mode",mode);
		
		if (index==-1){
			hmDtlRecord.put("doc_srl_no",""+getNextDoc_srl_no());
			alDtlRecords.add(hmDtlRecord);
		}
		else
			alDtlRecords.set(index, hmDtlRecord);
	} 


    public HashMap getDtlRecord(int index){
		return (HashMap)alDtlRecords.get(index);
	}

	public void updateExpRecords(int index, Hashtable htExpRecords){

		if (index==-1) {
			index	=	alDtlRecords.size()-1;
		}

		ArrayList alExpRecords	=	(ArrayList)hmExpRecords.get(""+index);

		HashMap hmAldtlData = (HashMap)alDtlRecords.get(index);
		int batch_records = Integer.parseInt((String)hmAldtlData.get("batch_records"));
		//hmAldtlData.put("batch_records",""+batch_records);
		//alDtlRecords.set(index,hmAldtlData);
        
		double dTotalValue=0;
		int i,totalSelectedRecord=0;
		double lTotalQty=0;

		for (i=0;i<alExpRecords.size(); i++){

            HashMap hmExpRecord	=	(HashMap)alExpRecords.get(i);

            String stTempItemQty= (String)htExpRecords.get("item_qty_"+i);
			/*   Only to add those exp record where ret qty is not blank or null */

	//		if(!(stTempItemQty.equals("") || stTempItemQty.equals("0") || stTempItemQty==null ))
	//		{
				totalSelectedRecord++;
				if((((String)stTempItemQty).equals("") || ((String)stTempItemQty).equals("0") || (String)stTempItemQty==null ))
				{
					stTempItemQty = "0";
				}
				lTotalQty=lTotalQty+Double.parseDouble(stTempItemQty);
				
				
				hmExpRecord.put("QTY",	stTempItemQty);


				if( hmExpRecord.containsKey("NEW_BIN_LOCATION_CODE") == true )
                {
					hmExpRecord.remove("NEW_BIN_LOCATION_CODE");
					hmExpRecord.put("NEW_BIN_LOCATION_CODE", htExpRecords.get("to_bin_location_code_"+i));
			    }else{
                    hmExpRecord.put("NEW_BIN_LOCATION_CODE", htExpRecords.get("to_bin_location_code_"+i));
				}

				dTotalValue=dTotalValue+(Double.parseDouble((String)hmExpRecord.get("ITEM_UNIT_COST"))*Double.parseDouble(checkForNull((String)hmExpRecord.get("QTY"),(String)hmExpRecord.get("AVAIL_QTY"))));
//			}
		
			    alExpRecords.set(i,hmExpRecord); 
		  }

		dAvg_unit_cost=(dTotalValue/lTotalQty);

		ArrayList MyList =new ArrayList();
		
		for( i=0;i<alExpRecords.size(); i++){
			if( ! ((String)((HashMap)alExpRecords.get(i)).get("QTY")).equals("0")   ){
			MyList.add(alExpRecords.get(i));
			}else{
				batch_records = batch_records - 1;
			}
		}
	alExpRecords=MyList;
		hmAldtlData.put("batch_records",""+batch_records);
		alDtlRecords.set(index,hmAldtlData);

		setExpRecords(index, alExpRecords);
	 }



 public String getDefaultBinLocationCode(String store_code,String item_code){


		String def_Bin_Loc;
		String []stParameters={store_code,item_code};
		try {
			def_Bin_Loc=(String)fetchRecord(getStRepositoryValue("SQL_ST_DEF_TO_STORE_TO_BIN"),stParameters).get("BIN_LOCATION_CODE");
		}
		catch(Exception e){
			e.printStackTrace();
			def_Bin_Loc="";
		}
		return def_Bin_Loc;
	}


  public void initialize(){

        super.initialize();
		hmItemDetail = new java.util.HashMap();
		itemKeys= new java.util.ArrayList ();
		hmItemDetail = new java.util.HashMap();
//hmItemDetailExp = new java.util.HashMap();
//hmItemDetailExpKeys = new java.util.HashMap();
		alMinMaxRecords=new ArrayList();

		hmExpRecords=new HashMap();  
		alDtlRecords=new ArrayList();
		alTempExpRecords = new ArrayList();//Added against GHL-CRF-0413
		doc_srl_no	=	0;
//		authorized_by_id=""; 
		finalized_yn="";     
		remarks="";
//		records_to_delete="";
		seq_no = "";
		close_req_after_issue_yn = "";
		availableQty = "";
		ret_doc_type_code=  "";
		ret_doc_no=  "";
		ret_doc_ref=  "";
	}
 
public void clear() {
		super.clear();
		hmItemDetail = null;
		itemKeys= null;
		hmItemDetail = null;
		alMinMaxRecords=null;

//hmItemDetailExp = null;
//hmItemDetailExpKeys = null;

		hmExpRecords=null;  
		alDtlRecords=null;
		alTempExpRecords = null;//Added against GHL-CRF-0413
		doc_srl_no	=	0;
//		authorized_by_id=""; 
		finalized_yn=null;     
		remarks=null;
//		records_to_delete="";
		seq_no = null;
		close_req_after_issue_yn = null;
		availableQty = null;
		ret_doc_type_code=  null;
		ret_doc_no=  null;
		ret_doc_ref=  null;

	}

	public String getBinLocationList(String store_code,String bin_location_code) {
			ArrayList arr_language=new ArrayList();
			arr_language.add(store_code);
			arr_language.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_language),bin_location_code);
	}


// This method is not used anywhere..Keeping for future use...

   public ArrayList getBatchDetails(String item_code, String store_code)throws Exception {
		ArrayList BatchDetails=new ArrayList();
		Connection connection = null;
//int isValidDocDate = -1;
		try {
			connection = getConnection();

			// To call the procedure st_stock_availability_status

			String[] strParameters = new String[7];

			strParameters[0] = item_code;
			strParameters[1] = store_code;
			strParameters[2] = "0";
			strParameters[3] = "N";
			strParameters[4] = "";//stHeaderBean.getSysDate();
			strParameters[5] = "Y";
			strParameters[6] = "";


			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(strParameters);

			BatchDetails.add((String)hmStockAvailabilityStatus.get("stock_available_yn"));
			BatchDetails.add((String)hmStockAvailabilityStatus.get("item_unit_cost"));
			
			/* @Name - Priya
				* @Date - 02/06/2010
				* @Inc# - 
				* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' and  assign it to the item_unit_cost key
				*/
			String storeItemUnitCost=getUnitCost(item_code,store_code);
			//BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("store_item_unit_cost")));
			BatchDetails.add(new Double (storeItemUnitCost));
			/**END**/
			BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("available_stock")));
			BatchDetails.add(new Double ((String)hmStockAvailabilityStatus.get("expired_stock")));
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

	public void setAll(Hashtable hashtable) {
		setDoc_type_code((String)hashtable.get("doc_type_code"));  
		setDoc_no((String)hashtable.get("doc_no"));  
		setIsAutoNo(hashtable.get("autono_yn").equals("Yes")?true:false);
		setDoc_ref(checkForNull((String)hashtable.get("doc_ref"),""));  
		setItem_class_code((String)hashtable.get("item_class_code"));  
		setDoc_date((String)hashtable.get("doc_date"));  
		setFrom_store_code((String)hashtable.get("from_store_code"));  
		setTo_store_code((String)hashtable.get("to_store_code"));  
        setRecords_to_delete((String)hashtable.get("records_to_delete"));
		finalized_yn     =(String)hashtable.get("finalized_yn");  
		setFinalized_yn(finalized_yn);

        setRemarks((String)hashtable.get("remarks"));
 	  }

	  public void loadData() throws Exception	{

		ArrayList alParameters	=	new ArrayList(3);
		HashMap hmTempFactor = new HashMap();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());


		HashMap hmRecord =	fetchRecord(getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_SELECT_MAX_DOC_SRL_NO"), alParameters);
		doc_srl_no		 =	Integer.parseInt((String)hmRecord.get("MAX_DOC_SRL_NO"));

		alParameters.clear();
		
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getLanguageId());
//		hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_ISSUE_RETURN_HDR_SELECT"), alParameters);
				
		hmRecord	=	fetchRecord("SELECT HDR.DOC_TYPE_CODE,SY.SHORT_DESC DOC_TYPE_DESC,HDR.DOC_NO,TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') DOC_DATE, HDR.DOC_REF DOC_REFERENCE, HDR.FM_STORE_CODE,RBYS.SHORT_DESC FM_STORE_DESC,HDR.TO_STORE_CODE, RONS.SHORT_DESC	TO_STORE_DESC,HDR.ISS_DOC_TYPE_CODE, HDR.ISS_DOC_NO FROM ST_ISSUE_RET_HDR HDR,SY_DOC_TYPE_MASTER_LANG_VW SY,MM_STORE_LANG_VW RBYS, MM_STORE_LANG_VW RONS WHERE SY.DOC_TYPE_CODE=HDR.DOC_TYPE_CODE AND RBYS.STORE_CODE=HDR.FM_STORE_CODE AND RONS.STORE_CODE=HDR.FM_STORE_CODE AND HDR.FACILITY_ID = ? AND HDR.DOC_TYPE_CODE = ? AND HDR.DOC_NO	= ? AND SY.LANGUAGE_ID = RONS.LANGUAGE_ID AND RONS.LANGUAGE_ID = RBYS.LANGUAGE_ID AND RONS.LANGUAGE_ID = ?", alParameters);
		setDoc_date((String)hmRecord.get ("DOC_DATE"));  
		setDoc_ref((String)hmRecord.get ("doc_reference"));  
		setFrom_store_code((String)hmRecord.get("FM_STORE_CODE"));  
		setTo_store_code((String)hmRecord.get ("TO_STORE_CODE"));
		setIssueDocTypeCode((String)hmRecord.get ("ISS_DOC_TYPE_CODE"));
		setIssueDocNo((String)hmRecord.get ("ISS_DOC_NO"));
        //setRemarks((String)hmRecord.get ("remarks"));
		//setItem_class_code((String)hmRecord.get ("ITEM_CLASS_CODE"));

        alParameters.clear();
		alParameters.add(getLanguageId());
		alParameters.add(getTo_store_code());
		alParameters.add(getFrom_store_code());
        alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_no());
		alParameters.add(getDoc_type_code());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		
		alParameters.add(getLanguageId());
		alParameters.add(getTo_store_code());
		alParameters.add(getFrom_store_code());
        alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_no());
		alParameters.add(getDoc_type_code());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());

		//ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_SELECT_MULTIPLE"), alParameters);
		//ArrayList alRecords	=	fetchRecords("SELECT FM_STORE_CODE, DOC_NO, ITEM_CODE,ITEM_DESC,  UNIT_COST,COST_VALUE, DOC_SRL_NO,ITEM_QTY, REMARKS,  UOM_CODE, UOM_DESC,DEF_ISSUE_UOM, STOCK_UOM, SUM(NVL(PEND_QTY,0))PEND_QTY FROM(SELECT   HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, DTL.ITEM_UNIT_COST UNIT_COST,DTL.ITEM_COST_VALUE COST_VALUE, DTL.DOC_SRL_NO,DTL.RET_ITEM_QTY ITEM_QTY,(  SUM (NVL (ISS_EXP.ISS_ITEM_QTY, 0) - NVL (ISS_EXP.RET_ITEM_QTY, 0))+  NVL (DTL_EXP.ITEM_QTY, 0)) PEND_QTY,DTL.REMARKS REMARKS, AM.UOM_CODE UOM_CODE, AM.SHORT_DESC UOM_DESC,STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC STOCK_UOM, DTL_EXP.BATCH_ID FROM ST_ISSUE_RET_DTL DTL,MM_ITEM_LANG_VW MMITEM, ST_ISSUE_DTL_EXP ISS_EXP,ST_ISSUE_RET_HDR HDR,AM_UOM_LANG_VW AM,AM_UOM_LANG_VW AM1,ST_ISSUE_DTL ISS_DTL,ST_ITEM_STORE STITM,ST_ISSUE_RET_DTL_EXP DTL_EXP WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND ISS_EXP.ITEM_CODE = DTL.ITEM_CODE AND (ISS_EXP.FACILITY_ID,ISS_EXP.DOC_TYPE_CODE,ISS_EXP.DOC_NO,ISS_EXP.SEQ_NO) IN (SELECT FACILITY_ID, DOC_TYPE_CODE, DOC_NO, SEQ_NO FROM ST_ISSUE_HDR WHERE FM_STORE_CODE = ? AND TO_STORE_CODE = ? AND FINALIZED_YN = 'Y') AND DTL.FACILITY_ID = ? AND DTL.DOC_NO = ? AND DTL.DOC_TYPE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = MMITEM.ITEM_CODE AND DTL.ITEM_CODE = STITM.ITEM_CODE AND HDR.FM_STORE_CODE = STITM.STORE_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND AM1.UOM_CODE = STITM.DEF_ISSUE_UOM AND ISS_DTL.DOC_NO = ISS_EXP.DOC_NO AND ISS_DTL.DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND ISS_DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_DOC_NO = ISS_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.FACILITY_ID = DTL_EXP.FACILITY_ID GROUP BY HDR.FM_STORE_CODE,DTL.DOC_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC,DTL.ITEM_UNIT_COST,DTL.ITEM_COST_VALUE,DTL.DOC_SRL_NO,DTL.RET_ITEM_QTY,DTL.REMARKS,AM.UOM_CODE,AM.SHORT_DESC,STITM.DEF_ISSUE_UOM,AM1.SHORT_DESC,DTL_EXP.ITEM_QTY,DTL_EXP.BATCH_ID) GROUP BY FM_STORE_CODE, DOC_NO, ITEM_CODE,ITEM_DESC,  UNIT_COST,COST_VALUE, DOC_SRL_NO,ITEM_QTY,REMARKS,  UOM_CODE, UOM_DESC,DEF_ISSUE_UOM, STOCK_UOM", alParameters);
		//ArrayList alRecords	=	fetchRecords("SELECT  REMARKS,REMARKS_CODE, FM_STORE_CODE, DOC_NO, ITEM_CODE, ITEM_DESC, UNIT_COST, COST_VALUE,DOC_SRL_NO, ITEM_QTY,  UOM_CODE, UOM_DESC, DEF_ISSUE_UOM,STOCK_UOM, SUM (NVL (PEND_QTY, 0)) PEND_QTY,SEQ_NO FROM (SELECT  (SELECT trm.remarks_desc FROM mm_trn_remarks_lang trm WHERE dtl.remarks = trm.trn_remarks_code AND  trm.language_id = ?) REMARKS, HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE,MMITEM.SHORT_DESC ITEM_DESC, DTL.ITEM_UNIT_COST UNIT_COST,DTL.ITEM_COST_VALUE COST_VALUE, DTL.DOC_SRL_NO,DTL.RET_ITEM_QTY ITEM_QTY,(  SUM (  NVL (ACK.RECEIVED_QTY,NVL (ISS_EXP.ISS_ITEM_QTY, 0))- NVL (ACK.RECEIVED_QTY,NVL(ISS_EXP.RET_ITEM_QTY, 0))) + NVL (DTL_EXP.ITEM_QTY, 0)) PEND_QTY,DTL.REMARKS REMARKS_CODE, AM.UOM_CODE UOM_CODE,AM.SHORT_DESC UOM_DESC, STITM.DEF_ISSUE_UOM,AM1.SHORT_DESC STOCK_UOM, ISS_EXP.BATCH_ID,ORG_SEQ_NO SEQ_NO  /*+index( st_acknowledge_trn_dtl ack,st_issue_dtl,st_issue_dtl_exp)*/ FROM ST_ISSUE_RET_DTL DTL,MM_ITEM_LANG_VW MMITEM,ST_ISSUE_DTL_EXP ISS_EXP,ST_ISSUE_RET_HDR HDR,AM_UOM_LANG_VW AM,AM_UOM_LANG_VW AM1,ST_ISSUE_DTL ISS_DTL,ST_ITEM_STORE STITM,ST_ISSUE_RET_DTL_EXP DTL_EXP,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1 WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND ISS_EXP.ITEM_CODE = DTL.ITEM_CODE AND (ISS_EXP.FACILITY_ID,ISS_EXP.DOC_TYPE_CODE,ISS_EXP.DOC_NO,ISS_EXP.SEQ_NO) IN (SELECT FACILITY_ID, DOC_TYPE_CODE, DOC_NO, SEQ_NO FROM ST_ISSUE_HDR WHERE FM_STORE_CODE = ? AND TO_STORE_CODE = ? AND FINALIZED_YN = 'Y') AND DTL.FACILITY_ID = ? AND DTL.DOC_NO = ? AND DTL.DOC_TYPE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = MMITEM.ITEM_CODE AND DTL.ITEM_CODE = STITM.ITEM_CODE AND HDR.FM_STORE_CODE = STITM.STORE_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND AM1.UOM_CODE = STITM.DEF_ISSUE_UOM AND ISS_DTL.DOC_NO = ISS_EXP.DOC_NO AND ISS_DTL.DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_DTL.SEQ_NO = ISS_EXP.SEQ_NO AND MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND ISS_DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_EXP.SEQ_NO = DTL_EXP.ORG_SEQ_NO(+) AND ISS_DOC_NO = ISS_EXP.DOC_NO AND ISS_EXP.DOC_TYPE_CODE = DTL_EXP.ORG_DOC_TYPE_CODE(+) AND ISS_EXP.DOC_NO = DTL_EXP.ORG_DOC_NO(+) AND ISS_EXP.BATCH_ID = DTL_EXP.BATCH_ID(+) AND ISS_EXP.FACILITY_ID = DTL_EXP.FACILITY_ID(+) AND ACK.DOC_NO(+) = ISS_EXP.DOC_NO AND ACK.DOC_TYPE_CODE(+) = ISS_EXP.DOC_TYPE_CODE AND ACK.BATCH_ID(+) = ISS_EXP.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = ISS_EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND ACK.DOC_SRL_NO(+) = ISS_EXP.DOC_SRL_NO AND ACK.NEW_BIN_LOCATION_CODE(+) = ISS_EXP.TO_BIN_LOCATION_CODE AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL_EXP.DOC_NO = ACK1.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND DTL_EXP.BATCH_ID = ACK1.BATCH_ID(+) GROUP BY HDR.FM_STORE_CODE,DTL.DOC_NO,DTL.ITEM_CODE,MMITEM.SHORT_DESC,DTL.ITEM_UNIT_COST,DTL.ITEM_COST_VALUE,DTL.DOC_SRL_NO,DTL.RET_ITEM_QTY,DTL.REMARKS,AM.UOM_CODE,AM.SHORT_DESC,STITM.DEF_ISSUE_UOM,AM1.SHORT_DESC,DTL_EXP.ITEM_QTY,ISS_EXP.BATCH_ID,ACK.RECEIVED_QTY,ORG_SEQ_NO) GROUP BY FM_STORE_CODE,DOC_NO,ITEM_CODE,ITEM_DESC,UNIT_COST,COST_VALUE,DOC_SRL_NO,ITEM_QTY,REMARKS,UOM_CODE,UOM_DESC,DEF_ISSUE_UOM,STOCK_UOM,remarks_code,SEQ_NO", alParameters);

		
		//Commented by Rabbani on 17/02/2012
		//ArrayList alRecords	=	fetchRecords("SELECT   REMARKS, REMARKS_CODE, FM_STORE_CODE, DOC_NO, ITEM_CODE, ITEM_DESC, UNIT_COST, COST_VALUE, DOC_SRL_NO, ITEM_QTY, UOM_CODE, UOM_DESC, DEF_ISSUE_UOM, STOCK_UOM, /*SUM (NVL (PEND_QTY, 0)) PEND_QTY, */ SEQ_NO, SUM ((CASE WHEN (  NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL (ACK_RET_QTY, RET_QTY) ) < (BATCH_QTY - BATCH_COMMT_QTY) THEN (  NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL (ACK_RET_QTY, RET_QTY) ) ELSE BATCH_QTY - BATCH_COMMT_QTY END )) PEND_QTY,facility_id  FROM (SELECT   (SELECT TRM.REMARKS_DESC FROM MM_TRN_REMARKS_LANG TRM WHERE DTL.REMARKS = TRM.TRN_REMARKS_CODE AND TRM.LANGUAGE_ID = ?) REMARKS, HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC, DTL.ITEM_UNIT_COST UNIT_COST, DTL.ITEM_COST_VALUE COST_VALUE, DTL.DOC_SRL_NO, DTL.RET_ITEM_QTY ITEM_QTY,  ACK.RECEIVED_QTY ACK_ISSUE_QTY, SUM (NVL (ACK1.RECEIVED_QTY, 0)) ACK_RET_QTY, SUM (NVL (DTL_EXP.ITEM_QTY, 0)) RET_QTY, NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY, NVL (ISS_EXP.ISS_ITEM_QTY, 0) ISS_QTY, /*  (  SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (ISS_EXP.ISS_ITEM_QTY, 0) > NVL (STB.QTY_ON_HAND, 0) THEN NVL (STB.QTY_ON_HAND, 0) ELSE NVL (ISS_EXP.ISS_ITEM_QTY, 0) END ) ) - NVL (ACK.RECEIVED_QTY, NVL (ISS_EXP.RET_ITEM_QTY, 0) ) ) + NVL (DTL_EXP.ITEM_QTY, 0) ) PEND_QTY,*/ DTL.REMARKS REMARKS_CODE, AM.UOM_CODE UOM_CODE, AM.SHORT_DESC UOM_DESC, STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC STOCK_UOM, ISS_EXP.BATCH_ID, ORG_SEQ_NO SEQ_NO ,iss_dtl.facility_id facility_id FROM ST_ISSUE_RET_DTL DTL, MM_ITEM_LANG_VW MMITEM, ST_ISSUE_DTL_EXP ISS_EXP, ST_ISSUE_RET_HDR HDR, AM_UOM_LANG_VW AM, AM_UOM_LANG_VW AM1, ST_ISSUE_DTL ISS_DTL, ST_ITEM_STORE STITM, ST_ISSUE_RET_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB,ST_ACC_ENTITY_PARAM pa WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND ISS_EXP.ITEM_CODE = DTL.ITEM_CODE AND (ISS_EXP.FACILITY_ID, ISS_EXP.DOC_TYPE_CODE, ISS_EXP.DOC_NO, ISS_EXP.SEQ_NO ) IN ( SELECT FACILITY_ID, DOC_TYPE_CODE, DOC_NO, SEQ_NO FROM ST_ISSUE_HDR WHERE FM_STORE_CODE = ? AND TO_STORE_CODE = ? AND FINALIZED_YN = 'Y') AND DTL.FACILITY_ID = ? AND DTL.DOC_NO = ? AND DTL.DOC_TYPE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = MMITEM.ITEM_CODE AND DTL.ITEM_CODE = STITM.ITEM_CODE AND HDR.FM_STORE_CODE = STITM.STORE_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND AM1.UOM_CODE = STITM.DEF_ISSUE_UOM AND ISS_DTL.DOC_NO = ISS_EXP.DOC_NO AND ISS_DTL.DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_DTL.SEQ_NO = ISS_EXP.SEQ_NO AND MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND ISS_DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_EXP.SEQ_NO = DTL_EXP.ORG_SEQ_NO(+) AND ISS_DOC_NO = ISS_EXP.DOC_NO AND ISS_EXP.DOC_TYPE_CODE = DTL_EXP.ORG_DOC_TYPE_CODE(+) AND ISS_EXP.DOC_NO = DTL_EXP.ORG_DOC_NO(+) AND ISS_EXP.BATCH_ID = DTL_EXP.BATCH_ID(+) AND iss_exp.facility_id =  decode(pa.TRN_ACROSS_FACILITY_YN,'Y',iss_exp.facility_id, dtl_exp.facility_id) AND ACK.DOC_NO(+) = ISS_EXP.DOC_NO AND ACK.DOC_TYPE_CODE(+) = ISS_EXP.DOC_TYPE_CODE AND ACK.BATCH_ID(+) = ISS_EXP.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = ISS_EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND ACK.DOC_SRL_NO(+) = ISS_EXP.DOC_SRL_NO AND ACK.NEW_BIN_LOCATION_CODE(+) = ISS_EXP.TO_BIN_LOCATION_CODE AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL_EXP.DOC_NO = ACK1.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND DTL_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND STB.ITEM_CODE = ISS_EXP.ITEM_CODE AND STB.STORE_CODE = HDR.FM_STORE_CODE AND STB.BATCH_ID = ISS_EXP.BATCH_ID AND STB.TRADE_ID = ISS_EXP.TRADE_ID AND STB.EXPIRY_DATE_OR_RECEIPT_DATE = ISS_EXP.EXPIRY_DATE_OR_RECEIPT_DATE GROUP BY HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, DTL.DOC_SRL_NO, DTL.RET_ITEM_QTY, DTL.REMARKS, AM.UOM_CODE,AM.SHORT_DESC, STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC, DTL_EXP.ITEM_QTY, ISS_EXP.BATCH_ID, ACK.RECEIVED_QTY, ORG_SEQ_NO,STB.QTY_ON_HAND,STB.COMMITTED_QTY ,ISS_EXP.ISS_ITEM_QTY  ,iss_dtl.facility_id ) GROUP BY FM_STORE_CODE, DOC_NO, ITEM_CODE, ITEM_DESC, UNIT_COST, COST_VALUE, DOC_SRL_NO, ITEM_QTY, REMARKS, UOM_CODE, UOM_DESC, DEF_ISSUE_UOM, STOCK_UOM, REMARKS_CODE, SEQ_NO, facility_id ", alParameters);

		  //Added by Rabbani on 17/02/2012
		 // Commented by Rabbani on 29/02/2012 
		//ArrayList alRecords	=	fetchRecords("SELECT   REMARKS, REMARKS_CODE, FM_STORE_CODE, DOC_NO, ITEM_CODE, ITEM_DESC, UNIT_COST, COST_VALUE, DOC_SRL_NO, ITEM_QTY, UOM_CODE, UOM_DESC, DEF_ISSUE_UOM, STOCK_UOM, /*SUM (NVL (PEND_QTY, 0)) PEND_QTY, */ SEQ_NO, SUM ((CASE WHEN (  NVL (ISS_QTY,ACK_ISSUE_QTY) - NVL (RET_ITM_QTY,ACK_RET_QTY) ) < (BATCH_QTY - BATCH_COMMT_QTY) THEN ((  NVL (ISS_QTY,ACK_ISSUE_QTY) - NVL (RET_ITM_QTY,ACK_RET_QTY) + RET_QTY )) ELSE BATCH_QTY - BATCH_COMMT_QTY+ RET_QTY END )) PEND_QTY,facility_id  FROM (SELECT   (SELECT TRM.REMARKS_DESC FROM MM_TRN_REMARKS_LANG TRM WHERE DTL.REMARKS = TRM.TRN_REMARKS_CODE AND TRM.LANGUAGE_ID = ?) REMARKS, HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC, DTL.ITEM_UNIT_COST UNIT_COST, DTL.ITEM_COST_VALUE COST_VALUE, DTL.DOC_SRL_NO, DTL.RET_ITEM_QTY ITEM_QTY,  ACK.RECEIVED_QTY ACK_ISSUE_QTY, SUM (NVL (ACK1.RECEIVED_QTY, 0)) ACK_RET_QTY,  (NVL (DTL_EXP.ITEM_QTY, 0)) RET_QTY,  (NVL (ISS_EXP.RET_ITEM_QTY, 0)) RET_ITM_QTY,NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY, NVL (ISS_EXP.ISS_ITEM_QTY, 0) ISS_QTY, /*  (  SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (ISS_EXP.ISS_ITEM_QTY, 0) > NVL (STB.QTY_ON_HAND, 0) THEN NVL (STB.QTY_ON_HAND, 0) ELSE NVL (ISS_EXP.ISS_ITEM_QTY, 0) END ) ) - NVL (ACK.RECEIVED_QTY, NVL (ISS_EXP.RET_ITEM_QTY, 0) ) ) + NVL (DTL_EXP.ITEM_QTY, 0) ) PEND_QTY,*/ DTL.REMARKS REMARKS_CODE, AM.UOM_CODE UOM_CODE, AM.SHORT_DESC UOM_DESC, STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC STOCK_UOM, ISS_EXP.BATCH_ID, ORG_SEQ_NO SEQ_NO ,iss_dtl.facility_id facility_id FROM ST_ISSUE_RET_DTL DTL, MM_ITEM_LANG_VW MMITEM, ST_ISSUE_DTL_EXP ISS_EXP, ST_ISSUE_RET_HDR HDR, AM_UOM_LANG_VW AM, AM_UOM_LANG_VW AM1, ST_ISSUE_DTL ISS_DTL, ST_ITEM_STORE STITM, ST_ISSUE_RET_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB,ST_ACC_ENTITY_PARAM pa WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND ISS_EXP.ITEM_CODE = DTL.ITEM_CODE AND (ISS_EXP.FACILITY_ID, ISS_EXP.DOC_TYPE_CODE, ISS_EXP.DOC_NO, ISS_EXP.SEQ_NO ) IN ( SELECT FACILITY_ID, DOC_TYPE_CODE, DOC_NO, SEQ_NO FROM ST_ISSUE_HDR WHERE FM_STORE_CODE = ? AND TO_STORE_CODE = ? AND FINALIZED_YN = 'Y') AND DTL.FACILITY_ID = ? AND DTL.DOC_NO = ? AND DTL.DOC_TYPE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = MMITEM.ITEM_CODE AND DTL.ITEM_CODE = STITM.ITEM_CODE AND HDR.FM_STORE_CODE = STITM.STORE_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND AM1.UOM_CODE = STITM.DEF_ISSUE_UOM AND ISS_DTL.DOC_NO = ISS_EXP.DOC_NO AND ISS_DTL.DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_DTL.SEQ_NO = ISS_EXP.SEQ_NO AND MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND ISS_DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_EXP.SEQ_NO = DTL_EXP.ORG_SEQ_NO(+) AND ISS_DOC_NO = ISS_EXP.DOC_NO AND ISS_EXP.DOC_TYPE_CODE = DTL_EXP.ORG_DOC_TYPE_CODE(+) AND ISS_EXP.DOC_NO = DTL_EXP.ORG_DOC_NO(+) AND ISS_EXP.BATCH_ID = DTL_EXP.BATCH_ID(+) AND iss_exp.facility_id =  decode(pa.TRN_ACROSS_FACILITY_YN,'Y',iss_exp.facility_id, dtl_exp.facility_id) AND ACK.DOC_NO(+) = ISS_EXP.DOC_NO AND ACK.DOC_TYPE_CODE(+) = ISS_EXP.DOC_TYPE_CODE AND ACK.BATCH_ID(+) = ISS_EXP.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = ISS_EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND ACK.DOC_SRL_NO(+) = ISS_EXP.DOC_SRL_NO AND ACK.NEW_BIN_LOCATION_CODE(+) = ISS_EXP.TO_BIN_LOCATION_CODE AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL_EXP.DOC_NO = ACK1.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND DTL_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND STB.ITEM_CODE = ISS_EXP.ITEM_CODE AND STB.STORE_CODE = HDR.FM_STORE_CODE AND STB.BATCH_ID = ISS_EXP.BATCH_ID AND STB.TRADE_ID = ISS_EXP.TRADE_ID AND STB.EXPIRY_DATE_OR_RECEIPT_DATE = ISS_EXP.EXPIRY_DATE_OR_RECEIPT_DATE GROUP BY HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, DTL.DOC_SRL_NO, DTL.RET_ITEM_QTY, DTL.REMARKS, AM.UOM_CODE,AM.SHORT_DESC, STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC, DTL_EXP.ITEM_QTY, ISS_EXP.BATCH_ID, ACK.RECEIVED_QTY, ORG_SEQ_NO,STB.QTY_ON_HAND,STB.COMMITTED_QTY ,ISS_EXP.ISS_ITEM_QTY,ISS_EXP.RET_ITEM_QTY  ,iss_dtl.facility_id ) GROUP BY FM_STORE_CODE, DOC_NO, ITEM_CODE, ITEM_DESC, UNIT_COST, COST_VALUE, DOC_SRL_NO, ITEM_QTY, REMARKS, UOM_CODE, UOM_DESC, DEF_ISSUE_UOM, STOCK_UOM, REMARKS_CODE, SEQ_NO, facility_id ", alParameters);
		
		//Added by Rabbani on 29/02/2012
		//ArrayList alRecords	=	fetchRecords("SELECT   REMARKS, REMARKS_CODE, FM_STORE_CODE, DOC_NO, ITEM_CODE, ITEM_DESC, UNIT_COST, COST_VALUE, DOC_SRL_NO, ITEM_QTY, UOM_CODE, UOM_DESC, DEF_ISSUE_UOM, STOCK_UOM, /*SUM (NVL (PEND_QTY, 0)) PEND_QTY, */ SEQ_NO, SUM ((CASE WHEN (  NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL (ACK_RET_QTY, RET_ITM_QTY) ) < (BATCH_QTY - BATCH_COMMT_QTY) THEN ((  NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL (ACK_RET_QTY, RET_ITM_QTY)+ RET_QTY ) ) ELSE BATCH_QTY - BATCH_COMMT_QTY+ RET_QTY END )) PEND_QTY,facility_id  FROM (SELECT   (SELECT TRM.REMARKS_DESC FROM MM_TRN_REMARKS_LANG TRM WHERE DTL.REMARKS = TRM.TRN_REMARKS_CODE AND TRM.LANGUAGE_ID = ?) REMARKS, HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC, DTL.ITEM_UNIT_COST UNIT_COST, DTL.ITEM_COST_VALUE COST_VALUE, DTL.DOC_SRL_NO, DTL.RET_ITEM_QTY ITEM_QTY,  ACK.RECEIVED_QTY ACK_ISSUE_QTY, /*SUM (NVL (ACK1.RECEIVED_QTY, 0)) ACK_RET_QTY,*/ (ACK1.RECEIVED_QTY) ACK_RET_QTY ,  NVL (DTL_EXP.ITEM_QTY, 0) RET_QTY, (NVL (ISS_EXP.RET_ITEM_QTY, 0)) RET_ITM_QTY,NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY, NVL (ISS_EXP.ISS_ITEM_QTY, 0) ISS_QTY, /*  (  SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (ISS_EXP.ISS_ITEM_QTY, 0) > NVL (STB.QTY_ON_HAND, 0) THEN NVL (STB.QTY_ON_HAND, 0) ELSE NVL (ISS_EXP.ISS_ITEM_QTY, 0) END ) ) - NVL (ACK.RECEIVED_QTY, NVL (ISS_EXP.RET_ITEM_QTY, 0) ) ) + NVL (DTL_EXP.ITEM_QTY, 0) ) PEND_QTY,*/ DTL.REMARKS REMARKS_CODE, AM.UOM_CODE UOM_CODE, AM.SHORT_DESC UOM_DESC, STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC STOCK_UOM, ISS_EXP.BATCH_ID, ORG_SEQ_NO SEQ_NO ,iss_dtl.facility_id facility_id FROM ST_ISSUE_RET_DTL DTL, MM_ITEM_LANG_VW MMITEM, ST_ISSUE_DTL_EXP ISS_EXP, ST_ISSUE_RET_HDR HDR, AM_UOM_LANG_VW AM, AM_UOM_LANG_VW AM1, ST_ISSUE_DTL ISS_DTL, ST_ITEM_STORE STITM, ST_ISSUE_RET_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB,ST_ACC_ENTITY_PARAM pa WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND ISS_EXP.ITEM_CODE = DTL.ITEM_CODE AND (ISS_EXP.FACILITY_ID, ISS_EXP.DOC_TYPE_CODE, ISS_EXP.DOC_NO, ISS_EXP.SEQ_NO ) IN ( SELECT FACILITY_ID, DOC_TYPE_CODE, DOC_NO, SEQ_NO FROM ST_ISSUE_HDR WHERE FM_STORE_CODE = ? AND TO_STORE_CODE = ? AND FINALIZED_YN = 'Y') AND DTL.FACILITY_ID = ? AND DTL.DOC_NO = ? AND DTL.DOC_TYPE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = MMITEM.ITEM_CODE AND DTL.ITEM_CODE = STITM.ITEM_CODE AND HDR.FM_STORE_CODE = STITM.STORE_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND AM1.UOM_CODE = STITM.DEF_ISSUE_UOM AND ISS_DTL.DOC_NO = ISS_EXP.DOC_NO AND ISS_DTL.DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_DTL.SEQ_NO = ISS_EXP.SEQ_NO AND MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND ISS_DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_EXP.SEQ_NO = DTL_EXP.ORG_SEQ_NO(+) AND ISS_DOC_NO = ISS_EXP.DOC_NO AND ISS_EXP.DOC_TYPE_CODE = DTL_EXP.ORG_DOC_TYPE_CODE(+) AND ISS_EXP.DOC_NO = DTL_EXP.ORG_DOC_NO(+) AND ISS_EXP.BATCH_ID = DTL_EXP.BATCH_ID(+) AND   iss_exp.expiry_date_or_receipt_date =  dtl_exp.expiry_date_or_receipt_date(+) AND iss_exp.facility_id =  decode(pa.TRN_ACROSS_FACILITY_YN,'Y',iss_exp.facility_id, dtl_exp.facility_id) AND ACK.DOC_NO(+) = ISS_EXP.DOC_NO AND ACK.DOC_TYPE_CODE(+) = ISS_EXP.DOC_TYPE_CODE AND ACK.BATCH_ID(+) = ISS_EXP.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = ISS_EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND ACK.DOC_SRL_NO(+) = ISS_EXP.DOC_SRL_NO AND ACK.NEW_BIN_LOCATION_CODE(+) = ISS_EXP.TO_BIN_LOCATION_CODE AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL_EXP.DOC_NO = ACK1.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND DTL_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND STB.ITEM_CODE = ISS_EXP.ITEM_CODE AND STB.STORE_CODE = HDR.FM_STORE_CODE AND STB.BATCH_ID = ISS_EXP.BATCH_ID AND STB.TRADE_ID = ISS_EXP.TRADE_ID AND STB.EXPIRY_DATE_OR_RECEIPT_DATE = ISS_EXP.EXPIRY_DATE_OR_RECEIPT_DATE GROUP BY HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, DTL.DOC_SRL_NO, DTL.RET_ITEM_QTY, DTL.REMARKS, AM.UOM_CODE,AM.SHORT_DESC, STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC, DTL_EXP.ITEM_QTY, ISS_EXP.BATCH_ID, ACK.RECEIVED_QTY,ACK1.RECEIVED_QTY, ORG_SEQ_NO,STB.QTY_ON_HAND,STB.COMMITTED_QTY ,ISS_EXP.ISS_ITEM_QTY  ,ISS_EXP.RET_ITEM_QTY,iss_dtl.facility_id ) GROUP BY FM_STORE_CODE, DOC_NO, ITEM_CODE, ITEM_DESC, UNIT_COST, COST_VALUE, DOC_SRL_NO, ITEM_QTY, REMARKS, UOM_CODE, UOM_DESC, DEF_ISSUE_UOM, STOCK_UOM, REMARKS_CODE, SEQ_NO, facility_id ", alParameters);
		
		//by ganga Thursday, March 15, 2012
		//Added by suresh.r on 29-01-2013 against AMS-CRF-0054 beg
		ArrayList alRecords;
		 if(getIssueRetBasedOn().equals("D")){
			 alRecords	=	fetchRecords("SELECT   REMARKS, REMARKS_CODE, FM_STORE_CODE, DOC_NO, ITEM_CODE, ITEM_DESC, UNIT_COST, COST_VALUE, DOC_SRL_NO, ITEM_QTY, UOM_CODE, UOM_DESC, DEF_ISSUE_UOM, STOCK_UOM, /*SUM (NVL (PEND_QTY, 0)) PEND_QTY, */ SEQ_NO, SUM ((CASE WHEN (  NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL (ACK_RET_QTY, RET_ITM_QTY) ) < (BATCH_QTY - BATCH_COMMT_QTY) THEN ((  NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL (ACK_RET_QTY, RET_ITM_QTY)+ RET_QTY ) ) ELSE BATCH_QTY - BATCH_COMMT_QTY+ RET_QTY END )) PEND_QTY,facility_id  FROM (SELECT   (SELECT TRM.REMARKS_DESC FROM MM_TRN_REMARKS_LANG TRM WHERE DTL.REMARKS = TRM.TRN_REMARKS_CODE AND TRM.LANGUAGE_ID = ?) REMARKS, HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC, DTL.ITEM_UNIT_COST UNIT_COST, DTL.ITEM_COST_VALUE COST_VALUE, DTL.DOC_SRL_NO, DTL.RET_ITEM_QTY ITEM_QTY,  ACK.RECEIVED_QTY ACK_ISSUE_QTY, /*SUM (NVL (ACK1.RECEIVED_QTY, 0)) ACK_RET_QTY,*/ (ACK1.RECEIVED_QTY) ACK_RET_QTY ,  NVL (DTL_EXP.ITEM_QTY, 0) RET_QTY, (NVL (ISS_EXP.RET_ITEM_QTY, 0)) RET_ITM_QTY,NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY, NVL (ISS_EXP.ISS_ITEM_QTY, 0) ISS_QTY, /*  (  SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (ISS_EXP.ISS_ITEM_QTY, 0) > NVL (STB.QTY_ON_HAND, 0) THEN NVL (STB.QTY_ON_HAND, 0) ELSE NVL (ISS_EXP.ISS_ITEM_QTY, 0) END ) ) - NVL (ACK.RECEIVED_QTY, NVL (ISS_EXP.RET_ITEM_QTY, 0) ) ) + NVL (DTL_EXP.ITEM_QTY, 0) ) PEND_QTY,*/ DTL.REMARKS REMARKS_CODE, AM.UOM_CODE UOM_CODE, AM.SHORT_DESC UOM_DESC, STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC STOCK_UOM, ISS_EXP.BATCH_ID, ORG_SEQ_NO SEQ_NO ,iss_dtl.facility_id facility_id FROM ST_ISSUE_RET_DTL DTL, MM_ITEM_LANG_VW MMITEM, ST_ISSUE_DTL_EXP ISS_EXP, ST_ISSUE_RET_HDR HDR, AM_UOM_LANG_VW AM, AM_UOM_LANG_VW AM1, ST_ISSUE_DTL ISS_DTL, ST_ITEM_STORE STITM, ST_ISSUE_RET_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB,ST_ACC_ENTITY_PARAM pa WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND ISS_EXP.ITEM_CODE = DTL.ITEM_CODE AND (ISS_EXP.FACILITY_ID, ISS_EXP.DOC_TYPE_CODE, ISS_EXP.DOC_NO, ISS_EXP.SEQ_NO ) IN ( SELECT FACILITY_ID, DOC_TYPE_CODE, DOC_NO, SEQ_NO FROM ST_ISSUE_HDR WHERE FM_STORE_CODE = ? AND TO_STORE_CODE = ? AND FINALIZED_YN = 'Y') AND DTL.FACILITY_ID = ? AND DTL.DOC_NO = ? AND DTL.DOC_TYPE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = MMITEM.ITEM_CODE AND DTL.ITEM_CODE = STITM.ITEM_CODE AND HDR.FM_STORE_CODE = STITM.STORE_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND AM1.UOM_CODE = STITM.DEF_ISSUE_UOM AND ISS_DTL.DOC_NO = ISS_EXP.DOC_NO AND ISS_DTL.DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_DTL.SEQ_NO = ISS_EXP.SEQ_NO AND MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND ISS_DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_EXP.SEQ_NO = DTL_EXP.ORG_SEQ_NO(+) AND ISS_DOC_NO = ISS_EXP.DOC_NO AND ISS_EXP.DOC_TYPE_CODE = DTL_EXP.ORG_DOC_TYPE_CODE(+) AND ISS_EXP.DOC_NO = DTL_EXP.ORG_DOC_NO(+) AND ISS_EXP.BATCH_ID = DTL_EXP.BATCH_ID(+) AND   iss_exp.expiry_date_or_receipt_date =  dtl_exp.expiry_date_or_receipt_date(+) AND iss_exp.facility_id =  decode(pa.TRN_ACROSS_FACILITY_YN,'Y',iss_exp.facility_id, dtl_exp.facility_id) AND ACK.DOC_NO(+) = ISS_EXP.DOC_NO AND ACK.DOC_TYPE_CODE(+) = ISS_EXP.DOC_TYPE_CODE AND ACK.BATCH_ID(+) = ISS_EXP.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = ISS_EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND ACK.DOC_SRL_NO(+) = ISS_EXP.DOC_SRL_NO AND ACK.NEW_BIN_LOCATION_CODE(+) = ISS_EXP.TO_BIN_LOCATION_CODE AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL_EXP.DOC_NO = ACK1.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND DTL_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND STB.ITEM_CODE = ISS_EXP.ITEM_CODE AND STB.STORE_CODE = HDR.FM_STORE_CODE AND STB.BATCH_ID = ISS_EXP.BATCH_ID AND STB.TRADE_ID = ISS_EXP.TRADE_ID AND STB.EXPIRY_DATE_OR_RECEIPT_DATE = ISS_EXP.EXPIRY_DATE_OR_RECEIPT_DATE GROUP BY HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, DTL.DOC_SRL_NO, DTL.RET_ITEM_QTY, DTL.REMARKS, AM.UOM_CODE,AM.SHORT_DESC, STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC, DTL_EXP.ITEM_QTY, ISS_EXP.BATCH_ID, ACK.RECEIVED_QTY,ACK1.RECEIVED_QTY, ORG_SEQ_NO,STB.QTY_ON_HAND,STB.COMMITTED_QTY ,ISS_EXP.ISS_ITEM_QTY  ,ISS_EXP.RET_ITEM_QTY,iss_dtl.facility_id UNION SELECT   (SELECT TRM.REMARKS_DESC FROM MM_TRN_REMARKS_LANG TRM WHERE DTL.REMARKS = TRM.TRN_REMARKS_CODE AND TRM.LANGUAGE_ID = ?) REMARKS, HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC ITEM_DESC, DTL.ITEM_UNIT_COST UNIT_COST, DTL.ITEM_COST_VALUE COST_VALUE, DTL.DOC_SRL_NO, DTL.RET_ITEM_QTY ITEM_QTY,  ACK.RECEIVED_QTY ACK_ISSUE_QTY, /*SUM (NVL (ACK1.RECEIVED_QTY, 0)) ACK_RET_QTY,*/ (ACK1.RECEIVED_QTY) ACK_RET_QTY ,  NVL (DTL_EXP.ITEM_QTY, 0) RET_QTY, (NVL (ISS_EXP.RET_ITEM_QTY, 0)) RET_ITM_QTY,10000000 BATCH_QTY, 0 BATCH_COMMT_QTY, NVL (ISS_EXP.ISS_ITEM_QTY, 0) ISS_QTY, /*  (  SUM (  NVL (ACK.RECEIVED_QTY, (CASE WHEN NVL (ISS_EXP.ISS_ITEM_QTY, 0) > NVL (STB.QTY_ON_HAND, 0) THEN NVL (STB.QTY_ON_HAND, 0) ELSE NVL (ISS_EXP.ISS_ITEM_QTY, 0) END ) ) - NVL (ACK.RECEIVED_QTY, NVL (ISS_EXP.RET_ITEM_QTY, 0) ) ) + NVL (DTL_EXP.ITEM_QTY, 0) ) PEND_QTY,*/ DTL.REMARKS REMARKS_CODE, AM.UOM_CODE UOM_CODE, AM.SHORT_DESC UOM_DESC, STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC STOCK_UOM, ISS_EXP.BATCH_ID, ORG_SEQ_NO SEQ_NO ,iss_dtl.facility_id facility_id FROM ST_ISSUE_RET_DTL DTL, MM_ITEM_LANG_VW MMITEM, ST_ISSUE_DTL_EXP ISS_EXP, ST_ISSUE_RET_HDR HDR, AM_UOM_LANG_VW AM, AM_UOM_LANG_VW AM1, ST_ISSUE_DTL ISS_DTL, ST_ITEM_STORE STITM, ST_ISSUE_RET_DTL_EXP DTL_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ACC_ENTITY_PARAM pa WHERE MMITEM.ITEM_CODE = DTL.ITEM_CODE AND ISS_EXP.ITEM_CODE = DTL.ITEM_CODE AND (ISS_EXP.FACILITY_ID, ISS_EXP.DOC_TYPE_CODE, ISS_EXP.DOC_NO, ISS_EXP.SEQ_NO ) IN ( SELECT FACILITY_ID, DOC_TYPE_CODE, DOC_NO, SEQ_NO FROM ST_ISSUE_HDR WHERE FM_STORE_CODE = ? AND TO_STORE_CODE = ? AND FINALIZED_YN = 'Y') AND DTL.FACILITY_ID = ? AND DTL.DOC_NO = ? AND DTL.DOC_TYPE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND DTL.ITEM_CODE = MMITEM.ITEM_CODE AND DTL.ITEM_CODE = STITM.ITEM_CODE AND HDR.FM_STORE_CODE = STITM.STORE_CODE AND MMITEM.GEN_UOM_CODE = AM.UOM_CODE AND AM1.UOM_CODE = STITM.DEF_ISSUE_UOM AND ISS_DTL.DOC_NO = ISS_EXP.DOC_NO AND ISS_DTL.DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_DTL.SEQ_NO = ISS_EXP.SEQ_NO AND MMITEM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = ? AND AM.LANGUAGE_ID = AM1.LANGUAGE_ID AND ISS_DOC_TYPE_CODE = ISS_EXP.DOC_TYPE_CODE AND ISS_EXP.SEQ_NO = DTL_EXP.ORG_SEQ_NO(+) AND ISS_DOC_NO = ISS_EXP.DOC_NO AND ISS_EXP.DOC_TYPE_CODE = DTL_EXP.ORG_DOC_TYPE_CODE(+) AND ISS_EXP.DOC_NO = DTL_EXP.ORG_DOC_NO(+) AND ISS_EXP.BATCH_ID = DTL_EXP.BATCH_ID(+) AND   iss_exp.expiry_date_or_receipt_date =  dtl_exp.expiry_date_or_receipt_date(+) AND iss_exp.facility_id =  decode(pa.TRN_ACROSS_FACILITY_YN,'Y',iss_exp.facility_id, dtl_exp.facility_id) AND ACK.DOC_NO(+) = ISS_EXP.DOC_NO AND ACK.DOC_TYPE_CODE(+) = ISS_EXP.DOC_TYPE_CODE AND ACK.BATCH_ID(+) = ISS_EXP.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = ISS_EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND ACK.DOC_SRL_NO(+) = ISS_EXP.DOC_SRL_NO AND ACK.NEW_BIN_LOCATION_CODE(+) = ISS_EXP.TO_BIN_LOCATION_CODE AND DTL.DOC_NO = DTL_EXP.DOC_NO AND DTL.DOC_TYPE_CODE = DTL_EXP.DOC_TYPE_CODE AND DTL_EXP.DOC_NO = ACK1.DOC_NO(+) AND DTL_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND DTL_EXP.BATCH_ID = ACK1.BATCH_ID(+)  AND DTL.stock_item_yn='N' GROUP BY HDR.FM_STORE_CODE, DTL.DOC_NO, DTL.ITEM_CODE, MMITEM.SHORT_DESC, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, DTL.DOC_SRL_NO, DTL.RET_ITEM_QTY, DTL.REMARKS, AM.UOM_CODE,AM.SHORT_DESC, STITM.DEF_ISSUE_UOM, AM1.SHORT_DESC, DTL_EXP.ITEM_QTY, ISS_EXP.BATCH_ID,ACK.RECEIVED_QTY,ACK1.RECEIVED_QTY,ORG_SEQ_NO,ISS_EXP.ISS_ITEM_QTY  ,ISS_EXP.RET_ITEM_QTY,iss_dtl.facility_id  ) GROUP BY FM_STORE_CODE, DOC_NO, ITEM_CODE, ITEM_DESC, UNIT_COST, COST_VALUE, DOC_SRL_NO, ITEM_QTY, REMARKS, UOM_CODE, UOM_DESC, DEF_ISSUE_UOM, STOCK_UOM, REMARKS_CODE, SEQ_NO, facility_id ", alParameters);
		 }else{
			 alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_SELECT_MULTIPLE_ITEM_BASE"), alParameters);
		 }
		//Added by suresh.r on 29-01-2013 against AMS-CRF-0054 end
		


                 System.out.println("alParameters 733===>" +alParameters);
				 System.out.println("alRecords 734===>" +alRecords);
		/**
			 * @Name - Priya
			 * @Date - 02/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost and round up unit cost & item cost value with 	noOfDecimalsForCost
			 */
	int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
	String alMaxReturnableQty="";

    
	    for (int i=0; i<alRecords.size(); i++) {
			hmTempFactor = new HashMap();
			hmRecord	=	(HashMap)alRecords.get(i);

			
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
						
			setAltFacilityId((String)hmRecord.get("FACILITY_ID"));
			
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",setNumber((String)hmRecord.get("COST_VALUE"),noOfDecimalsForCost));
			hmTemp.put("item_unit_cost",setNumber((String)hmRecord.get("UNIT_COST"),noOfDecimalsForCost));
			hmTemp.put("item_unit_cost_org",(String)hmRecord.get("UNIT_COST"));
			//hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			hmTemp.put("seq_no",hmRecord.get("SEQ_NO"));
			if(getAllowDecimalsYN((String)hmRecord.get("ITEM_CODE")).equals("N")){
				//hmTempFactor = (HashMap)getConvFactTemp((String)hmRecord.get("ITEM_CODE"),getFrom_store_code(),getTo_store_code(),(String)hmRecord.get("DEF_ISSUE_UOM"));
				hmTempFactor = (HashMap)getConvFactTemp((String)hmRecord.get("ITEM_CODE"),getFrom_store_code(),getTo_store_code(),(String)hmRecord.get("DEF_ISSUE_UOM"));
				hmTemp.put("from_multiples",(String)hmTempFactor.get("FROM_STORE_MULTIPLES"));
				hmTemp.put("to_multiples",(String)hmTempFactor.get("TO_STORE_MULTIPLES"));
				hmTemp.put("batch_multiples",(String)hmTempFactor.get("BATCH_QTY_MULTIPLES"));
				hmTemp.put("issue_uom_multiples",(String)hmTempFactor.get("ISSUE_UOM_MULTIPLES"));
			}
			double store_qty=(Double.parseDouble((String)hmRecord.get("PEND_QTY")))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("FM_STORE_CODE"));
			//Added by Sakti against inc no:50521 on 28/08/2014 to take max return qty from sum of avail_qty from batch search query
			 if(getIssueRetBasedOn().equals("I")){
			alMaxReturnableQty = getMaxReturnableQty(getLoginFacilityId(), getTo_store_code(), getFrom_store_code(),(String) hmRecord.get("ITEM_CODE"),getDoc_no());
			double stPendingQty=Double.parseDouble(checkForNull(alMaxReturnableQty,"0"))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("FM_STORE_CODE")) ;
				hmTemp.put("Max_Returnable_Qty",""+stPendingQty);
			 }else{
				 hmTemp.put("Max_Returnable_Qty",""+store_qty);

			 }
			//Added ends

			hmTemp.put("stock_available",hmRecord.get("PEND_QTY"));
			hmTemp.put("stock_available",""+store_qty);
           // hmTemp.put("Max_Returnable_Qty",""+store_qty);
		    
 //           hmTemp.put("Max_Returnable_Qty",hmRecord.get("PEND_QTY"));
			hmTemp.put("item_qty",hmRecord.get("ITEM_QTY"));
			
			double toStrQty=((Double.parseDouble((String)hmTemp.get("item_qty")))*getFromTempConvFact())/(getTempConvFact());
			hmTemp.put("to_str_qty",""+toStrQty);
//			alDtlData.add(hmDtlRecord);
	
//			tempRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_SELECT_QTY"), alParameters);

			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
			hmTemp.put("stock_uom",hmRecord.get("STOCK_UOM"));
            hmTemp.put("remarks",checkForNull((String)hmRecord.get("REMARKS"),""));
            hmTemp.put("remarks_code",checkForNull((String)hmRecord.get("REMARKS_CODE"),""));
			hmTemp.put("uom_desc_base",hmRecord.get("UOM_DESC"));


			alDtlRecords.add(hmTemp);

		} 
     
		for (int i=0; i<alDtlRecords.size(); i++) {


			hmRecord	=	(HashMap)alDtlRecords.get(i);
            alParameters.clear();
			alParameters.add(getLoginFacilityId());
			//alParameters.add(getTo_store_code());
			//alParameters.add(getFrom_store_code());
			alParameters.add(getDoc_no());
			alParameters.add(getDoc_type_code());
			//Added by suresh.r on 24-02-2013 against AMS-CRF-0054 beg
			//alParameters.add((String)hmRecord.get("doc_srl_no"));
			alParameters.add((String)hmRecord.get("item_code"));
			//Added by suresh.r on 24-02-2013 against AMS-CRF-0054 end
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());

			alParameters.add(getLoginFacilityId());
			alParameters.add(getDoc_no());
			alParameters.add(getDoc_type_code());
			//Added by suresh.r on 24-02-2013 against AMS-CRF-0054 beg
			//alParameters.add((String)hmRecord.get("doc_srl_no"));
			alParameters.add((String)hmRecord.get("item_code"));
			//Added by suresh.r on 24-02-2013 against AMS-CRF-0054 end
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());

			
			//alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_EXP_SELECT_MULTIPLE"), alParameters);
			//alRecords	=	fetchRecords("SELECT  K.FM_STORE_CODE STORE_CODE, K.TO_STORE_CODE, A.ITEM_CODE,F.SHORT_DESC ITEM_DESC, A.BATCH_ID,A.BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,(CASE WHEN A.BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = A.BIN_LOCATION_CODE AND STORE_CODE = A.STORE_CODE AND LANGUAGE_ID = F.LANGUAGE_ID) END) TO_BIN_DESC,A.TO_BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,A.TO_BIN_LOCATION_CODE, E.SHORT_DESC BIN_DESC,TO_CHAR (A.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,A.TRADE_ID, NVL (LONG_NAME, A.TRADE_ID) TRADE_NAME,NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY) ISS_ITEM_QTY,NVL (C.RET_ITEM_QTY, 0) RET_ITEM_QTY, A.ITEM_QTY QTY,(NVL (L.RECEIVED_QTY, NVL (C.ISS_ITEM_QTY, 0)) - NVL(M.RECEIVED_QTY,NVL(C.RET_ITEM_QTY,0)))+ A.ITEM_QTY AVAIL_QTY,A.ORG_DOC_TYPE_CODE DOC_TYPE_CODE, A.ORG_DOC_NO DOC_NO,A.ORG_SEQ_NO SEQ_NO, I.ITEM_UNIT_COST, C.DOC_SRL_NO,TO_CHAR (K.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,A.TO_BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE /* +index( st_issue_dtl_exp,st_issue_ret_hdr,st_acknowledge_trn_dtl)*/ FROM ST_ISSUE_RET_DTL_EXP A,ST_ISSUE_DTL_EXP C,ST_ISSUE_RET_HDR D,MM_BIN_LOCATION_LANG_VW E,MM_ITEM_LANG_VW F,AM_TRADE_NAME_LANG_VW H,ST_ISSUE_RET_DTL I,ST_ISSUE_HDR K,ST_ACKNOWLEDGE_TRN_DTL L,ST_ACKNOWLEDGE_TRN_DTL M WHERE A.ITEM_CODE = F.ITEM_CODE AND A.TRADE_ID = H.TRADE_ID(+) AND A.FACILITY_ID = C.FACILITY_ID AND A.ORG_DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.ORG_DOC_NO = C.DOC_NO AND A.ORG_SEQ_NO = C.SEQ_NO AND A.ITEM_CODE = C.ITEM_CODE AND A.BATCH_ID = C.BATCH_ID AND A.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND D.TO_STORE_CODE = E.STORE_CODE AND A.TO_BIN_LOCATION_CODE = E.BIN_LOCATION_CODE AND A.TO_BIN_LOCATION_CODE = C.BIN_LOCATION_CODE AND /* (C.ISS_ITEM_QTY-C.RET_ITEM_QTY) > 0 AND */ A.FACILITY_ID = I.FACILITY_ID AND A.DOC_TYPE_CODE = I.DOC_TYPE_CODE AND A.DOC_NO = I.DOC_NO AND A.ITEM_CODE = I.ITEM_CODE AND A.FACILITY_ID = ? AND A.DOC_NO = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_SRL_NO = ? AND (    C.FACILITY_ID = K.FACILITY_ID AND C.DOC_TYPE_CODE = K.DOC_TYPE_CODE AND C.DOC_NO = K.DOC_NO AND C.SEQ_NO = K.SEQ_NO ) AND E.LANGUAGE_ID = ? AND F.LANGUAGE_ID = ? AND H.LANGUAGE_ID(+) = ? AND L.DOC_NO(+) = C.DOC_NO AND L.DOC_TYPE_CODE(+) = C.DOC_TYPE_CODE AND L.BATCH_ID(+) = C.BATCH_ID AND L.EXPIRY_DATE_OR_RECEIPT_DATE(+) =  C.EXPIRY_DATE_OR_RECEIPT_DATE AND L.DOC_SRL_NO(+) = C.DOC_SRL_NO AND L.NEW_BIN_LOCATION_CODE(+) = C.BIN_LOCATION_CODE AND A.DOC_NO = M.DOC_NO(+) AND A.DOC_TYPE_CODE = M.DOC_TYPE_CODE(+) AND A.BATCH_ID = M.BATCH_ID(+) ORDER BY C.EXPIRY_DATE_OR_RECEIPT_DATE", alParameters);
			//Commented By Rabbani on 17/02/2012
			//alRecords	=	fetchRecords("SELECT K.FM_STORE_CODE STORE_CODE, K.TO_STORE_CODE, A.ITEM_CODE,F.SHORT_DESC ITEM_DESC, A.BATCH_ID,A.BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,(CASE WHEN A.BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = A.BIN_LOCATION_CODE AND STORE_CODE = A.STORE_CODE AND LANGUAGE_ID = F.LANGUAGE_ID) END ) TO_BIN_DESC, A.TO_BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,  A.TO_BIN_LOCATION_CODE, E.SHORT_DESC BIN_DESC, TO_CHAR (A.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, A.TRADE_ID, NVL (LONG_NAME, A.TRADE_ID) TRADE_NAME, NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY) ISS_ITEM_QTY, NVL (C.RET_ITEM_QTY, 0) RET_ITEM_QTY, A.ITEM_QTY QTY, (CASE WHEN((  NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY ) - NVL (M.RECEIVED_QTY, NVL (C.RET_ITEM_QTY, 0)) ) + A.ITEM_QTY) < STB.QTY_ON_HAND -STB.COMMITTED_QTY THEN ((  NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY ) - NVL (M.RECEIVED_QTY, NVL (C.RET_ITEM_QTY, 0)) ) + A.ITEM_QTY) ELSE STB.QTY_ON_HAND - STB.COMMITTED_QTY+A.ITEM_QTY END) AVAIL_QTY, A.ORG_DOC_TYPE_CODE DOC_TYPE_CODE, A.ORG_DOC_NO DOC_NO,A.ORG_SEQ_NO SEQ_NO, I.ITEM_UNIT_COST, C.DOC_SRL_NO, TO_CHAR (K.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, A.TO_BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE FROM ST_ISSUE_RET_DTL_EXP A, ST_ISSUE_DTL_EXP C, ST_ISSUE_RET_HDR D, MM_BIN_LOCATION_LANG_VW E, MM_ITEM_LANG_VW F, AM_TRADE_NAME_LANG_VW H, ST_ISSUE_RET_DTL I, ST_ISSUE_HDR K, ST_ACKNOWLEDGE_TRN_DTL L, ST_ACKNOWLEDGE_TRN_DTL M, ST_ITEM_BATCH STB,ST_ACC_ENTITY_PARAM PA WHERE A.ITEM_CODE = F.ITEM_CODE AND A.TRADE_ID = H.TRADE_ID(+) /* AND A.FACILITY_ID = C.FACILITY_ID */ AND a.facility_id = decode(pa.TRN_ACROSS_FACILITY_YN,'Y',a.facility_id, c.facility_id) AND A.ORG_DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.ORG_DOC_NO = C.DOC_NO AND A.ORG_SEQ_NO = C.SEQ_NO AND A.ITEM_CODE = C.ITEM_CODE AND A.BATCH_ID = C.BATCH_ID AND A.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND D.TO_STORE_CODE = E.STORE_CODE AND A.TO_BIN_LOCATION_CODE = E.BIN_LOCATION_CODE /* AND A.TO_BIN_LOCATION_CODE = C.BIN_LOCATION_CODE */ AND /* (C.ISS_ITEM_QTY-C.RET_ITEM_QTY) > 0 AND */ A.FACILITY_ID =I.FACILITY_ID AND A.DOC_TYPE_CODE = I.DOC_TYPE_CODE AND A.DOC_NO = I.DOC_NO AND A.ITEM_CODE = I.ITEM_CODE AND A.FACILITY_ID = ? AND A.DOC_NO = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_SRL_NO = ? AND (    C.FACILITY_ID = K.FACILITY_ID AND C.DOC_TYPE_CODE = K.DOC_TYPE_CODE AND C.DOC_NO = K.DOC_NO AND C.SEQ_NO = K.SEQ_NO) AND E.LANGUAGE_ID = ? AND F.LANGUAGE_ID = ? AND H.LANGUAGE_ID(+) = ? AND L.DOC_NO(+) = C.DOC_NO AND L.DOC_TYPE_CODE(+) = C.DOC_TYPE_CODE AND L.BATCH_ID(+) = C.BATCH_ID AND L.EXPIRY_DATE_OR_RECEIPT_DATE(+) = C.EXPIRY_DATE_OR_RECEIPT_DATE AND L.DOC_SRL_NO(+) = C.DOC_SRL_NO AND L.NEW_BIN_LOCATION_CODE(+) = C.BIN_LOCATION_CODE AND A.DOC_NO = M.DOC_NO(+) AND A.DOC_TYPE_CODE = M.DOC_TYPE_CODE(+) AND A.BATCH_ID = M.BATCH_ID(+) AND STB.ITEM_CODE = C.ITEM_CODE AND STB.BATCH_ID = C.BATCH_ID AND STB.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.TRADE_ID = C.TRADE_ID AND STB.STORE_CODE = D.FM_STORE_CODE ORDER BY C.EXPIRY_DATE_OR_RECEIPT_DATE", alParameters);
			//Commented By Rabbani on 29/02/2012
			//Added By Rabbani on 17/02/2012
			//alRecords	=	fetchRecords("SELECT K.FM_STORE_CODE STORE_CODE, K.TO_STORE_CODE, A.ITEM_CODE,F.SHORT_DESC ITEM_DESC, A.BATCH_ID,A.BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,(CASE WHEN A.BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = A.BIN_LOCATION_CODE AND STORE_CODE = A.STORE_CODE AND LANGUAGE_ID = F.LANGUAGE_ID) END ) TO_BIN_DESC, A.TO_BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,  A.TO_BIN_LOCATION_CODE, E.SHORT_DESC BIN_DESC, TO_CHAR (A.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, A.TRADE_ID, NVL (LONG_NAME, A.TRADE_ID) TRADE_NAME, NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY) ISS_ITEM_QTY, NVL (C.RET_ITEM_QTY, 0) RET_ITEM_QTY, A.ITEM_QTY QTY, (CASE WHEN((  NVL (C.ISS_ITEM_QTY,L.RECEIVED_QTY ) - NVL (NVL (C.RET_ITEM_QTY, 0),M.RECEIVED_QTY) )) < STB.QTY_ON_HAND -STB.COMMITTED_QTY THEN ((  NVL (C.ISS_ITEM_QTY,L.RECEIVED_QTY ) - NVL ( NVL (C.RET_ITEM_QTY, 0),M.RECEIVED_QTY) )+A.ITEM_QTY) ELSE STB.QTY_ON_HAND - STB.COMMITTED_QTY+A.ITEM_QTY END) AVAIL_QTY, A.ORG_DOC_TYPE_CODE DOC_TYPE_CODE, A.ORG_DOC_NO DOC_NO,A.ORG_SEQ_NO SEQ_NO, I.ITEM_UNIT_COST, C.DOC_SRL_NO, TO_CHAR (K.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, A.TO_BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE FROM ST_ISSUE_RET_DTL_EXP A, ST_ISSUE_DTL_EXP C, ST_ISSUE_RET_HDR D, MM_BIN_LOCATION_LANG_VW E, MM_ITEM_LANG_VW F, AM_TRADE_NAME_LANG_VW H, ST_ISSUE_RET_DTL I, ST_ISSUE_HDR K, ST_ACKNOWLEDGE_TRN_DTL L, ST_ACKNOWLEDGE_TRN_DTL M, ST_ITEM_BATCH STB,ST_ACC_ENTITY_PARAM PA WHERE A.ITEM_CODE = F.ITEM_CODE AND A.TRADE_ID = H.TRADE_ID(+) /* AND A.FACILITY_ID = C.FACILITY_ID */ AND a.facility_id = decode(pa.TRN_ACROSS_FACILITY_YN,'Y',a.facility_id, c.facility_id) AND A.ORG_DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.ORG_DOC_NO = C.DOC_NO AND A.ORG_SEQ_NO = C.SEQ_NO AND A.ITEM_CODE = C.ITEM_CODE AND A.BATCH_ID = C.BATCH_ID AND A.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND D.TO_STORE_CODE = E.STORE_CODE AND A.TO_BIN_LOCATION_CODE = E.BIN_LOCATION_CODE /* AND A.TO_BIN_LOCATION_CODE = C.BIN_LOCATION_CODE */ AND /* (C.ISS_ITEM_QTY-C.RET_ITEM_QTY) > 0 AND */ A.FACILITY_ID =I.FACILITY_ID AND A.DOC_TYPE_CODE = I.DOC_TYPE_CODE AND A.DOC_NO = I.DOC_NO AND A.ITEM_CODE = I.ITEM_CODE AND A.FACILITY_ID = ? AND A.DOC_NO = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_SRL_NO = ? AND (    C.FACILITY_ID = K.FACILITY_ID AND C.DOC_TYPE_CODE = K.DOC_TYPE_CODE AND C.DOC_NO = K.DOC_NO AND C.SEQ_NO = K.SEQ_NO) AND E.LANGUAGE_ID = ? AND F.LANGUAGE_ID = ? AND H.LANGUAGE_ID(+) = ? AND L.DOC_NO(+) = C.DOC_NO AND L.DOC_TYPE_CODE(+) = C.DOC_TYPE_CODE AND L.BATCH_ID(+) = C.BATCH_ID AND L.EXPIRY_DATE_OR_RECEIPT_DATE(+) = C.EXPIRY_DATE_OR_RECEIPT_DATE AND L.DOC_SRL_NO(+) = C.DOC_SRL_NO AND L.NEW_BIN_LOCATION_CODE(+) = C.BIN_LOCATION_CODE AND A.DOC_NO = M.DOC_NO(+) AND A.DOC_TYPE_CODE = M.DOC_TYPE_CODE(+) AND A.BATCH_ID = M.BATCH_ID(+) AND STB.ITEM_CODE = C.ITEM_CODE AND STB.BATCH_ID = C.BATCH_ID AND STB.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.TRADE_ID = C.TRADE_ID AND STB.STORE_CODE = D.FM_STORE_CODE ORDER BY C.EXPIRY_DATE_OR_RECEIPT_DATE", alParameters);
			//Added by Rabbani on 29/02/2012
			//alRecords	=	fetchRecords("SELECT K.FM_STORE_CODE STORE_CODE, K.TO_STORE_CODE, A.ITEM_CODE,F.SHORT_DESC ITEM_DESC, A.BATCH_ID,A.BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,(CASE WHEN A.BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = A.BIN_LOCATION_CODE AND STORE_CODE = A.STORE_CODE AND LANGUAGE_ID = F.LANGUAGE_ID) END ) TO_BIN_DESC, A.TO_BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,  A.TO_BIN_LOCATION_CODE, E.SHORT_DESC BIN_DESC, TO_CHAR (A.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, A.TRADE_ID, NVL (LONG_NAME, A.TRADE_ID) TRADE_NAME, NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY) ISS_ITEM_QTY, NVL (C.RET_ITEM_QTY, 0) RET_ITEM_QTY, A.ITEM_QTY QTY, (CASE WHEN(  NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY ) - NVL (M.RECEIVED_QTY, NVL (C.RET_ITEM_QTY, 0)) ) < STB.QTY_ON_HAND -STB.COMMITTED_QTY THEN ((  NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY ) - NVL (M.RECEIVED_QTY , NVL (C.RET_ITEM_QTY, 0)) ) + A.ITEM_QTY) ELSE STB.QTY_ON_HAND - STB.COMMITTED_QTY+A.ITEM_QTY END) AVAIL_QTY, A.ORG_DOC_TYPE_CODE DOC_TYPE_CODE, A.ORG_DOC_NO DOC_NO,A.ORG_SEQ_NO SEQ_NO, I.ITEM_UNIT_COST, C.DOC_SRL_NO, TO_CHAR (K.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, A.TO_BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE FROM ST_ISSUE_RET_DTL_EXP A, ST_ISSUE_DTL_EXP C, ST_ISSUE_RET_HDR D, MM_BIN_LOCATION_LANG_VW E, MM_ITEM_LANG_VW F, AM_TRADE_NAME_LANG_VW H, ST_ISSUE_RET_DTL I, ST_ISSUE_HDR K, ST_ACKNOWLEDGE_TRN_DTL L, ST_ACKNOWLEDGE_TRN_DTL M, ST_ITEM_BATCH STB,ST_ACC_ENTITY_PARAM PA WHERE A.ITEM_CODE = F.ITEM_CODE AND A.TRADE_ID = H.TRADE_ID(+) /* AND A.FACILITY_ID = C.FACILITY_ID */ AND a.facility_id = decode(pa.TRN_ACROSS_FACILITY_YN,'Y',a.facility_id, c.facility_id) AND A.ORG_DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.ORG_DOC_NO = C.DOC_NO AND A.ORG_SEQ_NO = C.SEQ_NO AND A.ITEM_CODE = C.ITEM_CODE AND A.BATCH_ID = C.BATCH_ID AND A.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND D.TO_STORE_CODE = E.STORE_CODE AND A.TO_BIN_LOCATION_CODE = E.BIN_LOCATION_CODE /* AND A.TO_BIN_LOCATION_CODE = C.BIN_LOCATION_CODE */ AND /* (C.ISS_ITEM_QTY-C.RET_ITEM_QTY) > 0 AND */ A.FACILITY_ID =I.FACILITY_ID AND A.DOC_TYPE_CODE = I.DOC_TYPE_CODE AND A.DOC_NO = I.DOC_NO AND A.ITEM_CODE = I.ITEM_CODE AND A.FACILITY_ID = ? AND A.DOC_NO = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_SRL_NO = ? AND (    C.FACILITY_ID = K.FACILITY_ID AND C.DOC_TYPE_CODE = K.DOC_TYPE_CODE AND C.DOC_NO = K.DOC_NO AND C.SEQ_NO = K.SEQ_NO) AND E.LANGUAGE_ID = ? AND F.LANGUAGE_ID = ? AND H.LANGUAGE_ID(+) = ? AND L.DOC_NO(+) = C.DOC_NO AND L.DOC_TYPE_CODE(+) = C.DOC_TYPE_CODE AND L.BATCH_ID(+) = C.BATCH_ID AND L.EXPIRY_DATE_OR_RECEIPT_DATE(+) = C.EXPIRY_DATE_OR_RECEIPT_DATE AND L.DOC_SRL_NO(+) = C.DOC_SRL_NO AND L.NEW_BIN_LOCATION_CODE(+) = C.BIN_LOCATION_CODE AND A.DOC_NO = M.DOC_NO(+) AND A.DOC_TYPE_CODE = M.DOC_TYPE_CODE(+) AND A.BATCH_ID = M.BATCH_ID(+) AND STB.ITEM_CODE = C.ITEM_CODE AND STB.BATCH_ID = C.BATCH_ID AND STB.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.TRADE_ID = C.TRADE_ID AND STB.STORE_CODE = D.FM_STORE_CODE ORDER BY C.EXPIRY_DATE_OR_RECEIPT_DATE", alParameters);
			
			//by ganga Thursday, March 15, 2012
			//Added by suresh.r on 24-02-2013 against AMS-CRF-0054 beg
			//alRecords	=	fetchRecords("SELECT K.FM_STORE_CODE STORE_CODE, K.TO_STORE_CODE, A.ITEM_CODE,F.SHORT_DESC ITEM_DESC, A.BATCH_ID,A.BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,(CASE WHEN A.BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = A.BIN_LOCATION_CODE AND STORE_CODE = A.STORE_CODE AND LANGUAGE_ID = F.LANGUAGE_ID) END ) TO_BIN_DESC, A.TO_BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,  A.TO_BIN_LOCATION_CODE, E.SHORT_DESC BIN_DESC, TO_CHAR (A.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, A.TRADE_ID, NVL (LONG_NAME, A.TRADE_ID) TRADE_NAME, NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY) ISS_ITEM_QTY, NVL (C.RET_ITEM_QTY, 0) RET_ITEM_QTY, A.ITEM_QTY QTY, (CASE WHEN(  NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY ) - NVL (M.RECEIVED_QTY, NVL (C.RET_ITEM_QTY, 0)) ) < STB.QTY_ON_HAND -STB.COMMITTED_QTY THEN ((  NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY ) - NVL (M.RECEIVED_QTY , NVL (C.RET_ITEM_QTY, 0)) ) + A.ITEM_QTY) ELSE STB.QTY_ON_HAND - STB.COMMITTED_QTY+A.ITEM_QTY END) AVAIL_QTY, A.ORG_DOC_TYPE_CODE DOC_TYPE_CODE, A.ORG_DOC_NO DOC_NO,A.ORG_SEQ_NO SEQ_NO, I.ITEM_UNIT_COST, C.DOC_SRL_NO, TO_CHAR (K.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, A.TO_BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE FROM ST_ISSUE_RET_DTL_EXP A, ST_ISSUE_DTL_EXP C, ST_ISSUE_RET_HDR D, MM_BIN_LOCATION_LANG_VW E, MM_ITEM_LANG_VW F, AM_TRADE_NAME_LANG_VW H, ST_ISSUE_RET_DTL I, ST_ISSUE_HDR K, ST_ACKNOWLEDGE_TRN_DTL L, ST_ACKNOWLEDGE_TRN_DTL M, ST_ITEM_BATCH STB,ST_ACC_ENTITY_PARAM PA WHERE A.ITEM_CODE = F.ITEM_CODE AND A.TRADE_ID = H.TRADE_ID(+) /* AND A.FACILITY_ID = C.FACILITY_ID */ AND a.facility_id = decode(pa.TRN_ACROSS_FACILITY_YN,'Y',a.facility_id, c.facility_id) AND A.ORG_DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.ORG_DOC_NO = C.DOC_NO AND A.ORG_SEQ_NO = C.SEQ_NO AND A.ITEM_CODE = C.ITEM_CODE AND A.BATCH_ID = C.BATCH_ID AND A.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND D.TO_STORE_CODE = E.STORE_CODE AND A.TO_BIN_LOCATION_CODE = E.BIN_LOCATION_CODE /* AND A.TO_BIN_LOCATION_CODE = C.BIN_LOCATION_CODE */ AND /* (C.ISS_ITEM_QTY-C.RET_ITEM_QTY) > 0 AND */ A.FACILITY_ID =I.FACILITY_ID AND A.DOC_TYPE_CODE = I.DOC_TYPE_CODE AND A.DOC_NO = I.DOC_NO AND A.ITEM_CODE = I.ITEM_CODE AND A.FACILITY_ID = ? AND A.DOC_NO = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_SRL_NO = ? AND (    C.FACILITY_ID = K.FACILITY_ID AND C.DOC_TYPE_CODE = K.DOC_TYPE_CODE AND C.DOC_NO = K.DOC_NO AND C.SEQ_NO = K.SEQ_NO) AND E.LANGUAGE_ID = ? AND F.LANGUAGE_ID = ? AND H.LANGUAGE_ID(+) = ? AND L.DOC_NO(+) = C.DOC_NO AND L.DOC_TYPE_CODE(+) = C.DOC_TYPE_CODE AND L.BATCH_ID(+) = C.BATCH_ID AND L.EXPIRY_DATE_OR_RECEIPT_DATE(+) = C.EXPIRY_DATE_OR_RECEIPT_DATE AND L.DOC_SRL_NO(+) = C.DOC_SRL_NO AND L.NEW_BIN_LOCATION_CODE(+) = C.BIN_LOCATION_CODE AND A.DOC_NO = M.DOC_NO(+) AND A.DOC_TYPE_CODE = M.DOC_TYPE_CODE(+) AND A.BATCH_ID = M.BATCH_ID(+) AND STB.ITEM_CODE = C.ITEM_CODE AND STB.BATCH_ID = C.BATCH_ID AND STB.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.TRADE_ID = C.TRADE_ID AND STB.STORE_CODE = D.FM_STORE_CODE UNION SELECT K.FM_STORE_CODE STORE_CODE, K.TO_STORE_CODE, A.ITEM_CODE,F.SHORT_DESC ITEM_DESC, A.BATCH_ID,A.BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,(CASE WHEN A.BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = A.BIN_LOCATION_CODE AND STORE_CODE = A.STORE_CODE AND LANGUAGE_ID = F.LANGUAGE_ID) END ) TO_BIN_DESC, A.TO_BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,  A.TO_BIN_LOCATION_CODE, E.SHORT_DESC BIN_DESC, TO_CHAR (A.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, A.TRADE_ID, NVL (LONG_NAME, A.TRADE_ID) TRADE_NAME, NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY) ISS_ITEM_QTY, NVL (C.RET_ITEM_QTY, 0) RET_ITEM_QTY, A.ITEM_QTY QTY, ((  NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY ) - NVL (M.RECEIVED_QTY , NVL (C.RET_ITEM_QTY, 0)) ) + A.ITEM_QTY) AVAIL_QTY, A.ORG_DOC_TYPE_CODE DOC_TYPE_CODE, A.ORG_DOC_NO DOC_NO,A.ORG_SEQ_NO SEQ_NO, I.ITEM_UNIT_COST, C.DOC_SRL_NO, TO_CHAR (K.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, A.TO_BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE FROM ST_ISSUE_RET_DTL_EXP A, ST_ISSUE_DTL_EXP C, ST_ISSUE_RET_HDR D, MM_BIN_LOCATION_LANG_VW E, MM_ITEM_LANG_VW F, AM_TRADE_NAME_LANG_VW H, ST_ISSUE_RET_DTL I, ST_ISSUE_HDR K, ST_ACKNOWLEDGE_TRN_DTL L, ST_ACKNOWLEDGE_TRN_DTL M,ST_ACC_ENTITY_PARAM PA WHERE A.ITEM_CODE = F.ITEM_CODE AND A.TRADE_ID = H.TRADE_ID(+) /* AND A.FACILITY_ID = C.FACILITY_ID */ AND a.facility_id = decode(pa.TRN_ACROSS_FACILITY_YN,'Y',a.facility_id, c.facility_id) AND A.ORG_DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.ORG_DOC_NO = C.DOC_NO AND A.ORG_SEQ_NO = C.SEQ_NO AND A.ITEM_CODE = C.ITEM_CODE AND A.BATCH_ID = C.BATCH_ID AND A.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND D.TO_STORE_CODE = E.STORE_CODE AND A.TO_BIN_LOCATION_CODE = E.BIN_LOCATION_CODE /* AND A.TO_BIN_LOCATION_CODE = C.BIN_LOCATION_CODE */ AND /* (C.ISS_ITEM_QTY-C.RET_ITEM_QTY) > 0 AND */ A.FACILITY_ID =I.FACILITY_ID AND A.DOC_TYPE_CODE = I.DOC_TYPE_CODE AND A.DOC_NO = I.DOC_NO AND A.ITEM_CODE = I.ITEM_CODE AND A.FACILITY_ID = ? AND A.DOC_NO = ? AND A.DOC_TYPE_CODE = ? AND A.DOC_SRL_NO = ? AND (    C.FACILITY_ID = K.FACILITY_ID AND C.DOC_TYPE_CODE = K.DOC_TYPE_CODE AND C.DOC_NO = K.DOC_NO AND C.SEQ_NO = K.SEQ_NO) AND E.LANGUAGE_ID = ? AND F.LANGUAGE_ID = ? AND H.LANGUAGE_ID(+) = ? AND L.DOC_NO(+) = C.DOC_NO AND L.DOC_TYPE_CODE(+) = C.DOC_TYPE_CODE AND L.BATCH_ID(+) = C.BATCH_ID AND L.EXPIRY_DATE_OR_RECEIPT_DATE(+) = C.EXPIRY_DATE_OR_RECEIPT_DATE AND L.DOC_SRL_NO(+) = C.DOC_SRL_NO AND L.NEW_BIN_LOCATION_CODE(+) = C.BIN_LOCATION_CODE AND A.DOC_NO = M.DOC_NO(+) AND A.DOC_TYPE_CODE = M.DOC_TYPE_CODE(+) AND A.BATCH_ID = M.BATCH_ID(+)  AND I.STOCK_ITEM_YN = 'N' ORDER BY EXPIRY_RECEIPT_DT", alParameters);
			alRecords	=	fetchRecords("SELECT K.FM_STORE_CODE STORE_CODE, K.TO_STORE_CODE, A.ITEM_CODE,F.SHORT_DESC ITEM_DESC, A.BATCH_ID,A.BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,(CASE WHEN A.BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = A.BIN_LOCATION_CODE AND STORE_CODE = A.STORE_CODE AND LANGUAGE_ID = F.LANGUAGE_ID) END ) TO_BIN_DESC, A.TO_BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,  A.TO_BIN_LOCATION_CODE, E.SHORT_DESC BIN_DESC, TO_CHAR (A.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, A.TRADE_ID, NVL (LONG_NAME, A.TRADE_ID) TRADE_NAME, NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY) ISS_ITEM_QTY, NVL (C.RET_ITEM_QTY, 0) RET_ITEM_QTY, A.ITEM_QTY QTY, (CASE WHEN(  NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY ) - NVL (M.RECEIVED_QTY, NVL (C.RET_ITEM_QTY, 0)) ) < STB.QTY_ON_HAND -STB.COMMITTED_QTY THEN ((  NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY ) - NVL (M.RECEIVED_QTY , NVL (C.RET_ITEM_QTY, 0)) ) + A.ITEM_QTY) ELSE STB.QTY_ON_HAND - STB.COMMITTED_QTY+A.ITEM_QTY END) AVAIL_QTY, A.ORG_DOC_TYPE_CODE DOC_TYPE_CODE, A.ORG_DOC_NO DOC_NO,A.ORG_SEQ_NO SEQ_NO, I.ITEM_UNIT_COST, C.DOC_SRL_NO, TO_CHAR (K.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, A.TO_BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE FROM ST_ISSUE_RET_DTL_EXP A, ST_ISSUE_DTL_EXP C, ST_ISSUE_RET_HDR D, MM_BIN_LOCATION_LANG_VW E, MM_ITEM_LANG_VW F, AM_TRADE_NAME_LANG_VW H, ST_ISSUE_RET_DTL I, ST_ISSUE_HDR K, ST_ACKNOWLEDGE_TRN_DTL L, ST_ACKNOWLEDGE_TRN_DTL M, ST_ITEM_BATCH STB,ST_ACC_ENTITY_PARAM PA WHERE A.ITEM_CODE = F.ITEM_CODE AND A.TRADE_ID = H.TRADE_ID(+) /* AND A.FACILITY_ID = C.FACILITY_ID */ AND a.facility_id = decode(pa.TRN_ACROSS_FACILITY_YN,'Y',a.facility_id, c.facility_id) AND A.ORG_DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.ORG_DOC_NO = C.DOC_NO AND A.ORG_SEQ_NO = C.SEQ_NO AND A.ITEM_CODE = C.ITEM_CODE AND A.BATCH_ID = C.BATCH_ID AND A.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND D.TO_STORE_CODE = E.STORE_CODE AND A.TO_BIN_LOCATION_CODE = E.BIN_LOCATION_CODE /* AND A.TO_BIN_LOCATION_CODE = C.BIN_LOCATION_CODE */ AND /* (C.ISS_ITEM_QTY-C.RET_ITEM_QTY) > 0 AND */ A.FACILITY_ID =I.FACILITY_ID AND A.DOC_TYPE_CODE = I.DOC_TYPE_CODE AND A.DOC_NO = I.DOC_NO AND A.ITEM_CODE = I.ITEM_CODE AND A.FACILITY_ID = ? AND A.DOC_NO = ? AND A.DOC_TYPE_CODE = ? AND A.ITEM_CODE = ? AND (    C.FACILITY_ID = K.FACILITY_ID AND C.DOC_TYPE_CODE = K.DOC_TYPE_CODE AND C.DOC_NO = K.DOC_NO AND C.SEQ_NO = K.SEQ_NO) AND E.LANGUAGE_ID = ? AND F.LANGUAGE_ID = ? AND H.LANGUAGE_ID(+) = ? AND L.DOC_NO(+) = C.DOC_NO AND L.DOC_TYPE_CODE(+) = C.DOC_TYPE_CODE AND L.BATCH_ID(+) = C.BATCH_ID AND L.EXPIRY_DATE_OR_RECEIPT_DATE(+) = C.EXPIRY_DATE_OR_RECEIPT_DATE AND L.DOC_SRL_NO(+) = C.DOC_SRL_NO AND L.NEW_BIN_LOCATION_CODE(+) = C.BIN_LOCATION_CODE AND A.DOC_NO = M.DOC_NO(+) AND A.DOC_TYPE_CODE = M.DOC_TYPE_CODE(+) AND A.BATCH_ID = M.BATCH_ID(+) AND STB.ITEM_CODE = C.ITEM_CODE AND STB.BATCH_ID = C.BATCH_ID AND STB.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.TRADE_ID = C.TRADE_ID AND STB.STORE_CODE = D.FM_STORE_CODE UNION SELECT K.FM_STORE_CODE STORE_CODE, K.TO_STORE_CODE, A.ITEM_CODE,F.SHORT_DESC ITEM_DESC, A.BATCH_ID,A.BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,(CASE WHEN A.BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = A.BIN_LOCATION_CODE AND STORE_CODE = A.STORE_CODE AND LANGUAGE_ID = F.LANGUAGE_ID) END ) TO_BIN_DESC, A.TO_BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,  A.TO_BIN_LOCATION_CODE, E.SHORT_DESC BIN_DESC, TO_CHAR (A.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, A.TRADE_ID, NVL (LONG_NAME, A.TRADE_ID) TRADE_NAME, NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY) ISS_ITEM_QTY, NVL (C.RET_ITEM_QTY, 0) RET_ITEM_QTY, A.ITEM_QTY QTY, ((  NVL (L.RECEIVED_QTY, C.ISS_ITEM_QTY ) - NVL (M.RECEIVED_QTY , NVL (C.RET_ITEM_QTY, 0)) ) + A.ITEM_QTY) AVAIL_QTY, A.ORG_DOC_TYPE_CODE DOC_TYPE_CODE, A.ORG_DOC_NO DOC_NO,A.ORG_SEQ_NO SEQ_NO, I.ITEM_UNIT_COST, C.DOC_SRL_NO, TO_CHAR (K.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, A.TO_BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE FROM ST_ISSUE_RET_DTL_EXP A, ST_ISSUE_DTL_EXP C, ST_ISSUE_RET_HDR D, MM_BIN_LOCATION_LANG_VW E, MM_ITEM_LANG_VW F, AM_TRADE_NAME_LANG_VW H, ST_ISSUE_RET_DTL I, ST_ISSUE_HDR K, ST_ACKNOWLEDGE_TRN_DTL L, ST_ACKNOWLEDGE_TRN_DTL M,ST_ACC_ENTITY_PARAM PA WHERE A.ITEM_CODE = F.ITEM_CODE AND A.TRADE_ID = H.TRADE_ID(+) /* AND A.FACILITY_ID = C.FACILITY_ID */ AND a.facility_id = decode(pa.TRN_ACROSS_FACILITY_YN,'Y',a.facility_id, c.facility_id) AND A.ORG_DOC_TYPE_CODE = C.DOC_TYPE_CODE AND A.ORG_DOC_NO = C.DOC_NO AND A.ORG_SEQ_NO = C.SEQ_NO AND A.ITEM_CODE = C.ITEM_CODE AND A.BATCH_ID = C.BATCH_ID AND A.EXPIRY_DATE_OR_RECEIPT_DATE = C.EXPIRY_DATE_OR_RECEIPT_DATE AND A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND D.TO_STORE_CODE = E.STORE_CODE AND A.TO_BIN_LOCATION_CODE = E.BIN_LOCATION_CODE /* AND A.TO_BIN_LOCATION_CODE = C.BIN_LOCATION_CODE */ AND /* (C.ISS_ITEM_QTY-C.RET_ITEM_QTY) > 0 AND */ A.FACILITY_ID =I.FACILITY_ID AND A.DOC_TYPE_CODE = I.DOC_TYPE_CODE AND A.DOC_NO = I.DOC_NO AND A.ITEM_CODE = I.ITEM_CODE AND A.FACILITY_ID = ? AND A.DOC_NO = ? AND A.DOC_TYPE_CODE = ?  AND A.ITEM_CODE = ?  AND (    C.FACILITY_ID = K.FACILITY_ID AND C.DOC_TYPE_CODE = K.DOC_TYPE_CODE AND C.DOC_NO = K.DOC_NO AND C.SEQ_NO = K.SEQ_NO) AND E.LANGUAGE_ID = ? AND F.LANGUAGE_ID = ? AND H.LANGUAGE_ID(+) = ? AND L.DOC_NO(+) = C.DOC_NO AND L.DOC_TYPE_CODE(+) = C.DOC_TYPE_CODE AND L.BATCH_ID(+) = C.BATCH_ID AND L.EXPIRY_DATE_OR_RECEIPT_DATE(+) = C.EXPIRY_DATE_OR_RECEIPT_DATE AND L.DOC_SRL_NO(+) = C.DOC_SRL_NO AND L.NEW_BIN_LOCATION_CODE(+) = C.BIN_LOCATION_CODE AND A.DOC_NO = M.DOC_NO(+) AND A.DOC_TYPE_CODE = M.DOC_TYPE_CODE(+) AND A.BATCH_ID = M.BATCH_ID(+)  AND I.STOCK_ITEM_YN = 'N' ORDER BY EXPIRY_RECEIPT_DT", alParameters);
			//Added by suresh.r on 24-02-2013 against AMS-CRF-0054 end
			


			//if(getAckReqd()){//Commented by suresh.r on 29-01-2013 against AMS-CRF-0054
			if(getAckReqd() && !checkForNull((String)getIssueDocNo()).equals("")){//Added by suresh.r on 29-01-2013 against AMS-CRF-0054
			for(int r = 0 ; r < alRecords.size() ; r++){
			HashMap altemp = (HashMap)alRecords.get(r);
			ArrayList RejectedQty = getRejectedQty(getIssueDocNo(),getIssueDocTypeCode(),getLoginFacilityId());			
			 if(RejectedQty.size() > 0){
			 for(int r1 = 0 ; r1 < RejectedQty.size() ; r1++ ){
				HashMap RejectedQty1 = (HashMap)RejectedQty.get(r1);
				if (altemp.get("ITEM_CODE").equals(RejectedQty1.get("ITEM_CODE")) && altemp.get("DOC_NO").equals(RejectedQty1.get("DOC_NO"))  &&  altemp.get("DOC_TYPE_CODE").equals(RejectedQty1.get("DOC_TYPE_CODE")) && 	altemp.get("BATCH_ID").equals(RejectedQty1.get("BATCH_ID")) &&	altemp.get("EXPIRY_RECEIPT_DT").equals(RejectedQty1.get("EXPIRY_DATE_OR_RECEIPT_DATE")) &&	altemp.get("ISSUE_FM_BIN_LOCATION_CODE").equals(RejectedQty1.get("BIN_LOCATION_CODE")) && altemp.get("TRADE_ID").equals(RejectedQty1.get("TRADE_ID")) ) {
				double avail_qty = Double.parseDouble((String)altemp.get("AVAIL_QTY")) - Double.parseDouble((String)RejectedQty1.get("REJECTED_QTY"));
				altemp.put("AVAIL_QTY",""+avail_qty);
				}				
			 }
			 }
			}
			}
			
			
			hmExpRecords.put(""+i,alRecords);
			System.out.println("alParameters===820==>" +alParameters);
             System.out.println("hmExpRecords===822==>" +hmExpRecords);
			

/* ===== Start of Min Max details while loading details in Query mode*/
			HashMap hmMinMaxRecord1	=	new HashMap();
			HashMap hmMinMaxRecord2	=	new HashMap();
			hmMinMaxRecord1 = getMinMaxdetails((String)hmRecord.get("item_code"),getFrom_store_code());
			double available_qty1=Double.parseDouble((String)hmMinMaxRecord1.get("AVAILABLE_QTY"));
			double q = Double.parseDouble((String)hmRecord.get("item_qty"))+ available_qty1;
			//int q = Integer.parseInt((String)hmRecord.get("item_qty"))+ Integer.parseInt((String)hmMinMaxRecord1.get("AVAILABLE_QTY"));
			if (hmMinMaxRecord1!= null  )
			{
				hmMinMaxRecord2.put("frm_store_qty_on_hand",""+q );   // Availabe Qty has to be taken based on document no without commited qty , hmMinMaxRecord.get("QTY_ON_HAND") will not give doc no based available qty
				hmMinMaxRecord2.put("frm_store_min_stk_level",checkForNull((String)hmMinMaxRecord1.get("MIN_STK_QTY"),""));
				hmMinMaxRecord2.put("frm_store_max_stk_level",checkForNull((String)hmMinMaxRecord1.get("MAX_STK_QTY"),""));
				hmMinMaxRecord2.put("frm_store_reorder_level",checkForNull((String)hmMinMaxRecord1.get("REORDER_LEVEL"),""));
			}
			hmMinMaxRecord1.clear();
			hmMinMaxRecord1 = getMinMaxdetails((String)hmRecord.get("item_code"),getTo_store_code());

			if (hmMinMaxRecord1!= null  )
			{
				hmMinMaxRecord2.put("to_store_qty_on_hand",checkForNull((String)hmMinMaxRecord1.get("QTY_ON_HAND"),"0"));
				hmMinMaxRecord2.put("to_store_min_stk_level",checkForNull((String)hmMinMaxRecord1.get("MIN_STK_QTY"),""));
				hmMinMaxRecord2.put("to_store_max_stk_level",checkForNull((String)hmMinMaxRecord1.get("MAX_STK_QTY"),""));
				hmMinMaxRecord2.put("to_store_reorder_level",checkForNull((String)hmMinMaxRecord1.get("REORDER_LEVEL"),""));
			}
			alMinMaxRecords.add(hmMinMaxRecord2); 

			/* ===== End of Min Max details while loading details in Query mode*/

		  }
     
	}


	public java.util.ArrayList calculatePendingQuantity(String facility_id,String item_code,String fm_store_code,String to_store_code, boolean isStockItem){


        java.util.ArrayList alPendingQty=new  java.util.ArrayList();
	    java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;

        try {
            connection = getConnection();
          //Added by suresh.r on 18-03-2014 against AMS-CRF-0054 beg
           /* if (isStockItem){
				pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_RET_CALCULATE_PENDING_QTY"));
				pstmt.setString(5, getLanguageId());
            }
			else{
				pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_RET_CALCULATE_PENDING_QTY_NONSTK"));
			}*/
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_RET_CALCULATE_RETUNABLE_QTY"));
            //Added by suresh.r on 24-02-2014 against AMS-CRF-0054 beg
            facility_id	=(String)((HashMap)fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT"),to_store_code)).get("FACILITY_ID");
            //Added by suresh.r on 24-02-2014 against AMS-CRF-0054 end
            pstmt.setString(1, facility_id);
            pstmt.setString(2, to_store_code);
            pstmt.setString(3, fm_store_code);
            pstmt.setString(4, item_code);

            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String stPendingQty = "" ;
                stPendingQty = resultSet.getString(1);
                alPendingQty.add(stPendingQty);
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
            }catch(Exception es){
				es.printStackTrace();
            }
        }
	return alPendingQty;
}

public HashMap getIssueBatches(HashMap hmParameters)throws Exception{
		
		String stItem_code				=	(String)hmParameters.get("ITEM_CODE");
		String stfmStore_code			=	(String)hmParameters.get("FM_STORE_CODE");
        String sttoStore_code			=	(String)hmParameters.get("TO_STORE_CODE");
		double iTxn_qty					=	Double.parseDouble((String)hmParameters.get("TRN_QTY"));
		boolean bVerifyInsufficientQty	=	checkForNull(((String)hmParameters.get("VERIFY_INSUFFICIENT_QTY")),"TRUE").equals("TRUE");

		int iCount		=	0;
		
		HashMap hmReturn	= new HashMap();
		ArrayList alReturn	= new ArrayList();

		try { 
					
			ArrayList alParameters	=	new ArrayList(2);
			//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 beg
            //String stFacilityId=getLoginFacilityId();
    		String stFacilityId="";
    		ArrayList facParameters = new ArrayList();
    		String IssueRetBasedOn=getIssueRetBasedOn();
    		if(IssueRetBasedOn.equals("D")){
    			facParameters.add(getIssueDocNo());
    			facParameters.add(getIssueDocTypeCode());
    			stFacilityId  = (String)((HashMap)fetchRecord("Select FACILITY_ID  from st_issue_hdr a where a.DOC_NO = ? and a.DOC_TYPE_CODE = ? ",facParameters)).get("FACILITY_ID");
    		}else{
    			stFacilityId	=(String)((HashMap)fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT"),sttoStore_code)).get("FACILITY_ID");
    		}//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 end	

			alParameters.add(getLoginFacilityId());
			alParameters.add(getDoc_type_code());
			alParameters.add(getDoc_no());
			alParameters.add("RET");
			alParameters.add(getLoginFacilityId());
			alParameters.add(getDoc_type_code());
			alParameters.add(getDoc_no());
			alParameters.add("RET");
			//alParameters.add(getLoginFacilityId());//Commented by suresh.r on 24-01-2014 against AMS-CRF-0054
			alParameters.add(stFacilityId);
			alParameters.add(sttoStore_code);
			alParameters.add(stfmStore_code);
			alParameters.add(stItem_code);
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());



			ArrayList alRecords	=null;
			//StringBuffer sql; Commented for unused variables IN063878 
			//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
			HashMap hmStockItem=fetchRecord(getStRepositoryValue("SQL_ST_STOCK_ITEM_YN"),new String[]{stItem_code,stfmStore_code});
			if (hmStockItem.get("STOCK_ITEM_YN").toString().equals("Y")) {
				if(IssueRetBasedOn.equals("D")){//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
					alParameters.add(getLanguageId());
					alParameters.add(getIssueDocNo());
					alParameters.add(getIssueDocTypeCode());
					//alRecords=fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RETURN_BATCH_SEARCH_QUERY"),alParameters);
					//alRecords=fetchRecords("SELECT   IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID,IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC,SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE,IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,MMB1.SHORT_DESC TO_BIN_DESC,TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, IDE.ISS_ITEM_QTY,NVL (IDE.RET_ITEM_QTY, 0) RET_ITEM_QTY,LEAST ((IDE.ISS_ITEM_QTY - NVL (IDE.RET_ITEM_QTY, 0)),SBV.AVAIL_QTY) + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE) AVAIL_QTY,IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO,IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,ITEM_UNIT_COST, IDE.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP IDE,ST_ISSUE_HDR IHR,ST_BATCH_SEARCH_LANG_VIEW SBV,MM_BIN_LOCATION_LANG_VW MMB,MM_BIN_LOCATION_LANG_VW MMB1,ST_ISSUE_DTL IDTL WHERE (IDE.ISS_ITEM_QTY -IDE.RET_ITEM_QTY + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE)) >0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND  (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID /* AND  IDE.TO_BIN_LOCATION_CODE=SBV.BIN_LOCATION_CODE*/ AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? ORDER BY IHR.ADDED_DATE",alParameters);
					//Added by suresh.r on 17-03-2014 against 047777
					//alRecords=fetchRecords("SELECT   IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID,IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC,SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE,IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,MMB1.SHORT_DESC TO_BIN_DESC,TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, IDE.ISS_ITEM_QTY,NVL (IDE.RET_ITEM_QTY, 0) RET_ITEM_QTY,LEAST ((IDE.ISS_ITEM_QTY - NVL (IDE.RET_ITEM_QTY, 0)),SBV.AVAIL_QTY) + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE) AVAIL_QTY,IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO,IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,ITEM_UNIT_COST, IDE.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP IDE,ST_ISSUE_HDR IHR,ST_BATCH_SEARCH_LANG_VIEW SBV,MM_BIN_LOCATION_LANG_VW MMB,MM_BIN_LOCATION_LANG_VW MMB1,ST_ISSUE_DTL IDTL WHERE (IDE.ISS_ITEM_QTY -IDE.RET_ITEM_QTY + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE)) >0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND  (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID /* AND  IDE.TO_BIN_LOCATION_CODE=SBV.BIN_LOCATION_CODE*/ AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? ORDER BY IHR.ADDED_DATE",alParameters);
					alRecords=fetchRecords("SELECT   IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID,IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC,SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE,IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,MMB1.SHORT_DESC TO_BIN_DESC,TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, IDE.ISS_ITEM_QTY,NVL (IDE.RET_ITEM_QTY, 0) RET_ITEM_QTY,LEAST ((IDE.ISS_ITEM_QTY - NVL (IDE.RET_ITEM_QTY, 0)),SBV.AVAIL_QTY) + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE) AVAIL_QTY,IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO,IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,ITEM_UNIT_COST, IDE.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP IDE,ST_ISSUE_HDR IHR,ST_BATCH_SEARCH_LANG_VIEW SBV,MM_BIN_LOCATION_LANG_VW MMB,MM_BIN_LOCATION_LANG_VW MMB1,ST_ISSUE_DTL IDTL WHERE (IDE.ISS_ITEM_QTY -IDE.RET_ITEM_QTY + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE)) >0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND  (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID /* AND  IDE.TO_BIN_LOCATION_CODE=SBV.BIN_LOCATION_CODE*/ AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? ORDER BY BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC",alParameters);
				}else{//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 beg
					alParameters.clear();
					alParameters.add(stFacilityId);
					alParameters.add(sttoStore_code);
					alParameters.add(stfmStore_code);
					alParameters.add(stItem_code);
					alParameters.add(getLanguageId());
					alParameters.add(getLanguageId());
					alParameters.add(getLanguageId());
						if(getMode().equals("2")){
							alParameters.add(getDoc_no());
							alRecords=fetchRecords("SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, (ISS_ITEM_QTY- RET_ITEM_QTY) + AVAIL_QTY1 AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE, IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, NVL(RETEXP.ITEM_QTY,0) AVAIL_QTY1, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) + NVL(RETEXP.ITEM_QTY,0) ) > 0 AND ((NVL (ide.iss_item_qty, 0) - NVL (ide.ret_item_qty, 0)) + NVL(RETEXP.ITEM_QTY,0)) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND (IHR.FINALIZED_YN = 'Y' OR (ihr.process_for_acknowledge = 'Y' AND NVL(ACK.RECEIVED_QTY,0)>0)) AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ?  AND RETEXP.DOC_NO(+) = ?  AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND retexp.batch_id(+) = ide.batch_id AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.TO_BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, AVAIL_QTY1, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY ORDER BY DOC_NO,SEQ_NO,BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC",alParameters);
						}else{
							alRecords=fetchRecords("SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, (ISS_ITEM_QTY- RET_ITEM_QTY) AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE, IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) ) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND (IHR.FINALIZED_YN = 'Y' OR (ihr.process_for_acknowledge = 'Y' AND NVL(ACK.RECEIVED_QTY,0)>0)) AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ?  AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND retexp.batch_id(+) = ide.batch_id AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY ORDER BY DOC_NO,SEQ_NO,BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC",alParameters);
						}
				}//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 end
			}
			else{
				if(IssueRetBasedOn.equals("D")){//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
					alParameters.add(getIssueDocNo());
					alParameters.add(getIssueDocTypeCode());

					//alRecords=fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RETURN_BATCH_SEARCH_QUERY_NONSTK"),alParameters);
					//Added by suresh.r on 17-03-2014 against 047777
					//alRecords=fetchRecords("SELECT IDE.ITEM_CODE,  MMITM.SHORT_DESC ITEM_DESC,  IDE.BATCH_ID,  IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,  MMB.SHORT_DESC BIN_DESC,  IDE.TO_BIN_LOCATION_CODE  ISSUE_TO_BIN_LOCATION_CODE,  '' TO_BIN_DESC, TO_CHAR(IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,  IDE.TRADE_ID,  NVL(LONG_NAME,IDE.TRADE_ID) TRADE_NAME,  IDE.ISS_ITEM_QTY, NVL(IDE.RET_ITEM_QTY,0) RET_ITEM_QTY,  (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) +ST_COMM_QTY_FOR_DOCNO(?, ?, ?,?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE , IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) AVAIL_QTY,  IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO,  TO_CHAR(IHR.DOC_DATE,'DD/MM/YYYY') DOC_DATE,  ITEM_UNIT_COST,  STOCK_ITEM_YN, IDE.DOC_SRL_NO  FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, MM_BIN_LOCATION_LANG_VW MMB, ST_ISSUE_DTL IDTL, MM_ITEM_LANG_VW MMITM, AM_TRADE_NAME_LANG_VW AMTRADE WHERE (IDE.ISS_ITEM_QTY -IDE.RET_ITEM_QTY + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE)) >0 AND IDE.FACILITY_ID = ? AND IDTL.ITEM_CODE=MMITM.ITEM_CODE AND IDE.TRADE_ID=AMTRADE.TRADE_ID(+) AND (IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO =IHR.SEQ_NO) AND IHR.FINALIZED_YN='Y' AND IHR.FM_STORE_CODE= ? AND IHR.TO_STORE_CODE = ? /*AND (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) >= 0*/ AND (IHR.FM_STORE_CODE=MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE=MMB.BIN_LOCATION_CODE) AND IDTL.FACILITY_ID=IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE=IDE.DOC_TYPE_CODE AND IDTL.DOC_NO=IDE.DOC_NO AND  IDTL.SEQ_NO=IHR.SEQ_NO AND IDTL.ITEM_CODE=IDE.ITEM_CODE AND IDE.ITEM_CODE= ? AND MMB.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMB.LANGUAGE_ID = ? AND AMTRADE.LANGUAGE_ID(+) = ? AND IDE.DOC_NO =? AND IDE.DOC_TYPE_CODE=?",alParameters);
					alRecords=fetchRecords("SELECT IDE.ITEM_CODE,  MMITM.SHORT_DESC ITEM_DESC,  IDE.BATCH_ID,  IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,  MMB.SHORT_DESC BIN_DESC,  IDE.TO_BIN_LOCATION_CODE  ISSUE_TO_BIN_LOCATION_CODE,  '' TO_BIN_DESC, TO_CHAR(IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,  IDE.TRADE_ID,  NVL(LONG_NAME,IDE.TRADE_ID) TRADE_NAME,  IDE.ISS_ITEM_QTY, NVL(IDE.RET_ITEM_QTY,0) RET_ITEM_QTY,  (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) +ST_COMM_QTY_FOR_DOCNO(?, ?, ?,?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE , IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) AVAIL_QTY,  IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO,  TO_CHAR(IHR.DOC_DATE,'DD/MM/YYYY') DOC_DATE,  ITEM_UNIT_COST,  STOCK_ITEM_YN, IDE.DOC_SRL_NO  FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, MM_BIN_LOCATION_LANG_VW MMB, ST_ISSUE_DTL IDTL, MM_ITEM_LANG_VW MMITM, AM_TRADE_NAME_LANG_VW AMTRADE WHERE (IDE.ISS_ITEM_QTY -IDE.RET_ITEM_QTY + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE)) >0 AND IDE.FACILITY_ID = ? AND IDTL.ITEM_CODE=MMITM.ITEM_CODE AND IDE.TRADE_ID=AMTRADE.TRADE_ID(+) AND (IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO =IHR.SEQ_NO) AND IHR.FINALIZED_YN='Y' AND IHR.FM_STORE_CODE= ? AND IHR.TO_STORE_CODE = ? /*AND (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) >= 0*/ AND (IHR.FM_STORE_CODE=MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE=MMB.BIN_LOCATION_CODE) AND IDTL.FACILITY_ID=IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE=IDE.DOC_TYPE_CODE AND IDTL.DOC_NO=IDE.DOC_NO AND  IDTL.SEQ_NO=IHR.SEQ_NO AND IDTL.ITEM_CODE=IDE.ITEM_CODE AND IDE.ITEM_CODE= ? AND MMB.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMB.LANGUAGE_ID = ? AND AMTRADE.LANGUAGE_ID(+) = ? AND IDE.DOC_NO =? AND IDE.DOC_TYPE_CODE=? ORDER BY IDE.BATCH_ID,EXPIRY_RECEIPT_DT",alParameters);
				}else{//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 beg
					alParameters.clear();
					alParameters.add(stFacilityId);
					alParameters.add(sttoStore_code);
					alParameters.add(stfmStore_code);
					alParameters.add(stItem_code);
					alParameters.add(getLanguageId());
					alParameters.add(getLanguageId());
					if(getMode().equals("2")){
						alParameters.add(getDoc_no());
						alRecords=fetchRecords("SELECT DISTINCT IDE.ITEM_CODE, MMITM.SHORT_DESC ITEM_DESC, IDE.BATCH_ID,IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,MMB.SHORT_DESC BIN_DESC,IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, '' TO_BIN_DESC,TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,IDE.TRADE_ID, NVL (LONG_NAME, IDE.TRADE_ID) TRADE_NAME,NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) ISS_ITEM_QTY,NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)) RET_ITEM_QTY,(  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0))- NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)))+nvl(retexp.item_qty,0) AVAIL_QTY, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO,TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST,STOCK_ITEM_YN, IDE.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP IDE,ST_ISSUE_HDR IHR,MM_BIN_LOCATION_LANG_VW MMB,ST_ISSUE_DTL IDTL,MM_ITEM_LANG_VW MMITM,AM_TRADE_NAME_LANG_VW AMTRADE,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0))+ +nvl(retexp.item_qty,0)) > 0 AND ((NVL (ide.iss_item_qty, 0) - NVL (ide.ret_item_qty, 0)) + NVL(RETEXP.ITEM_QTY,0)) > 0 AND IDE.FACILITY_ID = ? AND IDTL.ITEM_CODE = MMITM.ITEM_CODE AND IDE.TRADE_ID =  AMTRADE.TRADE_ID(+) AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND ( ihr.finalized_yn = 'Y' OR ( ihr.process_for_acknowledge = 'Y'  AND NVL (ack.received_qty, 0) > 0)) AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? /*AND (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) >= 0*/ AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND MMB.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMB.LANGUAGE_ID = ? AND AMTRADE.LANGUAGE_ID(+) = ? AND retexp.doc_no(+) = ? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) =  IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID  AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND retexp.batch_id(+) = ide.batch_id AND retexp.to_bin_location_code(+) = ide.bin_location_code AND RETEXP.ITEM_CODE (+) = IDE.ITEM_CODE  AND ACK.SEQ_NO(+) = IDE.SEQ_NO ORDER BY DOC_NO,SEQ_NO,IDE.BATCH_ID,EXPIRY_RECEIPT_DT",alParameters);
					}else{
						alRecords=fetchRecords("SELECT DISTINCT IDE.ITEM_CODE, MMITM.SHORT_DESC ITEM_DESC, IDE.BATCH_ID,IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,MMB.SHORT_DESC BIN_DESC,IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, '' TO_BIN_DESC,TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,IDE.TRADE_ID, NVL (LONG_NAME, IDE.TRADE_ID) TRADE_NAME,NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) ISS_ITEM_QTY,NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)) RET_ITEM_QTY,(  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0))- NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0))) AVAIL_QTY,IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO,TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST,STOCK_ITEM_YN, IDE.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP IDE,ST_ISSUE_HDR IHR,MM_BIN_LOCATION_LANG_VW MMB,ST_ISSUE_DTL IDTL,MM_ITEM_LANG_VW MMITM,AM_TRADE_NAME_LANG_VW AMTRADE,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0))) > 0  AND IDE.FACILITY_ID = ? AND IDTL.ITEM_CODE = MMITM.ITEM_CODE AND IDE.TRADE_ID =  AMTRADE.TRADE_ID(+) AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND ( ihr.finalized_yn = 'Y' OR ( ihr.process_for_acknowledge = 'Y'  AND NVL (ack.received_qty, 0) > 0)) AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? /*AND (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) >= 0*/ AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND MMB.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMB.LANGUAGE_ID = ? AND AMTRADE.LANGUAGE_ID(+) = ? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) =  IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID  AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND retexp.batch_id(+) = ide.batch_id AND retexp.bin_location_code(+) = ide.bin_location_code AND RETEXP.ITEM_CODE (+) = IDE.ITEM_CODE  AND ACK.SEQ_NO(+) = IDE.SEQ_NO ORDER BY DOC_NO,SEQ_NO,IDE.BATCH_ID,EXPIRY_RECEIPT_DT",alParameters);
					}
				}//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 end
			}
				

			for (int i=0;i<alRecords.size();i++ ) {
				HashMap hmRecord	=	(HashMap)alRecords.get(i);
				double avail_qty		=	Double.parseDouble((String)hmRecord.get("AVAIL_QTY"));

				if (iTxn_qty>(iCount+avail_qty)) {
					iCount+=avail_qty;
					hmRecord.put("QTY",""+avail_qty);
					alReturn.add(hmRecord);
				}
				else{
					avail_qty=	iTxn_qty-iCount;
					iCount+=avail_qty;
					hmRecord.put("QTY",""+avail_qty);
					alReturn.add(hmRecord);
					break;
				}
			}
			if(iTxn_qty!=iCount){
				hmReturn.put("EXCEPTION","Insufficient Batch Exception"); //InsufficientBatchException(iCount)
				if (bVerifyInsufficientQty) {
					throw new Exception(); //InsufficientBatchException(iCount);
				}
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
		hmReturn.put("BATCH_DATA",alReturn);
		return hmReturn;
	}


    public String getFrom_store_description(String stFrom_store_code) {
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(stFrom_store_code);
			arr_language.add(getLanguageId());
			from_store_description=fetchRecord(getStRepositoryValue("SQL_ST_STORE_SELECT") ,arr_language).get("SHORT_DESC").toString() ;
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return from_store_description;
    }
	
	 public String getTo_store_description(String stTo_store_code) {
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(stTo_store_code);
			arr_language.add(getLanguageId());
			to_store_description=fetchRecord(getStRepositoryValue("SQL_ST_STORE_SELECT"), arr_language).get("SHORT_DESC").toString() ;
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return to_store_description;
    }

	public String getDoc_type_description(String stDoc_type_code)
    {
		try{
			ArrayList arr_language=new ArrayList();
			arr_language.add(stDoc_type_code);
			arr_language.add(getLanguageId());
			doc_type_description	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_language).get("SHORT_DESC").toString();
		}
		catch(Exception exception ){
			exception.printStackTrace();
		}
		return doc_type_description;
    }

	public String getItem_class_description( String stItem_class_code) {
		String empty="";
		if(! stItem_class_code.equals(""))
		{
		try {
			ArrayList arr_language=new ArrayList();
			arr_language.add(stItem_class_code);
			arr_language.add(getLanguageId());
			item_class_description=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_SELECT"), arr_language).get("SHORT_DESC").toString() ;
		
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return item_class_description;
		}
		return empty;
    }


public HashMap insert(){


//System.out.println("insert");
//	HashMap hmResult=new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();

		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alCommonData	=	new ArrayList();
		ArrayList allanguageData	=	new ArrayList();

       	alCommonData.add(getLoginById() );
		alCommonData.add(getLoginAtWsNo() );
		alCommonData.add(getLoginFacilityId() );
        alCommonData.add(getDoc_type_code());		
				
		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());
		alHdrData.add(getDoc_date());

		alHdrData.add(getDoc_ref());
		alHdrData.add(getFrom_store_code());
        alHdrData.add(getTo_store_code());
		if(getAckReqd()){
			alHdrData.add("N");//finalize
			alHdrData.add(getFinalized_yn().substring(0,1));//process for acknowledge
		}
		else{
			alHdrData.add(getFinalized_yn().substring(0,1));//finalize
			alHdrData.add("N");//process for acknowledge
		}

        alHdrData.add("N");//Changed to N on 12/26/2007 by Mahesh/Bharati
		alHdrData.add("RET");
        alHdrData.add(getLoginById());
		alHdrData.add(getLoginAtWsNo());

		alHdrData.add(getLoginFacilityId() );
		alHdrData.add(getLoginById());
		alHdrData.add(getLoginAtWsNo());
		alHdrData.add(getLoginFacilityId() );

		//alHdrData.add(getLanguageId() );
        alHdrData.add(getItem_class_code() );
      //Added by suresh.r on 29-01-2013 against AMS-CRF-0054 beg
        if(getIssueRetBasedOn().equals("I")){
        	alHdrData.add("");
        	alHdrData.add("");
        	try{
        		setAltFacilityId((String)((HashMap)fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT"),getTo_store_code())).get("FACILITY_ID"));
        	}catch(Exception exception) {
    			exception.printStackTrace();
    		}
        }else{ //Added by suresh.r on 29-01-2013 against AMS-CRF-0054 end
        	alHdrData.add(getIssueDocTypeCode() );
        	alHdrData.add(getIssueDocNo() );
        }

		allanguageData.add(getLanguageId());
		
		autoGenerateYN = isAutoNo ;

		/*try {
			autoGenerateYN = isAutoNo ;
			if (isAutoNo) {
				String next_doc_no = super.fetchNextDocNo(getDoc_type_code());
				setDoc_no(next_doc_no);
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}*/



 
       
		try {

//alDtlRecords
		   
			StringTokenizer stRecordsToDelete =	new StringTokenizer(getRecords_to_delete(),",");

			for (int i=0;i<alDtlRecords.size();i++) {

				String nextToken = stRecordsToDelete.nextToken();

			
				HashMap hmDtlRecord	=(HashMap)alDtlRecords.get(i);

				hmDtlRecord.put("from_store_code",getFrom_store_code());
                hmDtlRecord.put("to_store_code",  getTo_store_code());

				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
					if (sourceArrayList!=null) 
						for (int j=0;j<sourceArrayList.size(); j++ ) {
							HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							//Added by suresh.r on 20-02-2014 against AMS-CRF-0054 beg
							//hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
							int doc_srl_no=j+1;
							hmExpRecord.put("doc_srl_no",""+doc_srl_no);
							//Added by suresh.r on 20-02-2014 against AMS-CRF-0054 end
							double ret_item_qty = Double.parseDouble(checkForNull((String)hmExpRecord.get("QTY"),(String)hmExpRecord.get("AVAIL_QTY")))/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getTo_store_code()));
							//System.out.println("ret_item_qty 114" +ret_item_qty);
							hmExpRecord.put("ret_item_qty",""+ret_item_qty);
							alExpData.add(hmExpRecord);
							//System.out.println("alExpData 1142" +alExpData);
						}
				   }
				double toStrQty=((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code())))/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getTo_store_code()));
				double mm_trn_qty=((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code())));
				hmDtlRecord.put("to_str_qty",""+toStrQty);
				hmDtlRecord.put("mm_trn_qty",""+mm_trn_qty);
				hmDtlRecord.put("frm_conv_fact",""+getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code()));
				//hmDtlRecord.remove("frm_conv_fact");
				//hmDtlRecord.remove("to_conv_fact");
				alDtlData.add(hmDtlRecord);
				
			}

  	   
			
			 

					String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
                     
	    HashMap hmRecord = new HashMap();
		ArrayList  hmparam = new ArrayList();
	  for (int l=0; l<alExpData.size();l++ )
		   {
		   
		  hmparam = new ArrayList();
			hmRecord  = new HashMap();
			hmRecord	=	(HashMap)alExpData.get(l);
		   hmparam.add(getTo_store_code());
		   hmparam.add((String)hmRecord.get("ITEM_CODE"));
		   hmparam.add((String)hmRecord.get("BATCH_ID"));
  	       hmparam.add(checkForNull((String)hmRecord.get("BIN_LOCATION_CODE")));
		   hmparam.add((String)hmRecord.get("EXPIRY_RECEIPT_DT"));
		 //  hmRecord.put("MODIFIED_DATE",(String)((HashMap)fetchRecord(modified_date,hmparam)).get("MODIFIED_DATE"));

		   HashMap modified_dt = fetchRecord(modified_date,hmparam);
			String modified_date1 = "";
			
			if (modified_dt!= null)	{
			modified_date1 = (String)modified_dt.get("MODIFIED_DATE");
			}

		   hmRecord.put("MODIFIED_DATE",modified_date1);

		   alExpData.set(l,hmRecord);
		   
		   }	
			
			
			hmTableData.put("properties",	getProperties());
			hmTableData.put("HdrInsertData",	alHdrData);
			hmTableData.put("DtlInsertData",	alDtlData);
			hmTableData.put("ExpInsertData",	alExpData);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(autoGenerateYN));
			hmTableData.put("CommonData",	alCommonData);
			hmTableData.put("LANGUAGE_DATA",	allanguageData);
			hmTableData.put("AltFacilityId",	getAltFacilityId());
			hmTableData.put("fromStore", getFrom_store_code()); //MO-CRF-20176  
			
//			
		}
		catch(Exception exception) {
			exception.printStackTrace();
		} 
        hmSQLMap=stockSQL();
		if((getItemClassBased("RET").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
			hmTableData = modifiedTableData(hmTableData,"RET");
		}
		//return new HashMap();
		return issueReturnMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
	}


public HashMap modify(){

//	HashMap hmResult=new HashMap();;

	//System.out.println("modify" );
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();

		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alCommonData	=	new ArrayList();
		ArrayList allanguageData=	new ArrayList();

		HashMap hmResult=new HashMap();
		ArrayList<String> alParam = new ArrayList<String>();
		int doc_count = 0;
		try{
			alParam.add(getLoginFacilityId());
			alParam.add(getDoc_type_code());
			alParam.add(getDoc_no());
			doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_ISSUE_RET_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND (FINALIZED_YN='Y' OR PROCESS_FOR_ACKNOWLEDGE='Y')",alParam)).get("COUNT"));
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

		try{
			alCommonData.add(getLoginById() );
			alCommonData.add(getLoginAtWsNo() );
			alCommonData.add(getLoginFacilityId() );
			alCommonData.add(getDoc_type_code());
		
			alHdrData.add(getLoginFacilityId());
			alHdrData.add(getDoc_type_code());
			alHdrData.add(getDoc_no());
			alHdrData.add(getDoc_date());

			alHdrData.add(getDoc_ref());
			alHdrData.add(getFrom_store_code());
			alHdrData.add(getTo_store_code());
			if(getAckReqd()){
				alHdrData.add("N");//finalize
				alHdrData.add(getFinalized_yn().substring(0,1));//process for acknowledge
			}
			else{
				alHdrData.add(getFinalized_yn().substring(0,1));//finalize
				alHdrData.add("N");//process for acknowledge
			}

			alHdrData.add("N");//Changed to N on 12/26/2007 by Mahesh/Bharati
			alHdrData.add("RET");
			alHdrData.add(getLoginById());
			alHdrData.add(getLoginAtWsNo());
			alHdrData.add(getLoginFacilityId() );

			alHdrData.add(getLoginById());
			alHdrData.add(getLoginAtWsNo());
			alHdrData.add(getLoginFacilityId() );
			alHdrData.add(getRemarks());
			alHdrData.add(getLanguageId());
		allanguageData.add(getLanguageId());

	//	try {

			StringTokenizer stRecordsToDelete =	new StringTokenizer(getRecords_to_delete(),",");
			for (int i=0;i<alDtlRecords.size();i++) {

				String nextToken = stRecordsToDelete.nextToken();

			
				HashMap hmDtlRecord	=(HashMap)alDtlRecords.get(i);

				hmDtlRecord.put("from_store_code",getFrom_store_code());
                hmDtlRecord.put("to_store_code",  getTo_store_code());

				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
					if (sourceArrayList!=null) 
						for (int j=0;j<sourceArrayList.size(); j++ ) {
							HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							//Added by suresh.r on 20-02-2014 against AMS-CRF-0054 beg
							//hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
							int doc_srl_no=j+1;
							hmExpRecord.put("doc_srl_no",""+doc_srl_no);
							//Added by suresh.r on 20-02-2014 against AMS-CRF-0054 end
							double ret_item_qty = Double.parseDouble(checkForNull((String)hmExpRecord.get("QTY"),(String)hmExpRecord.get("AVAIL_QTY")))/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getTo_store_code()));
							hmExpRecord.put("ret_item_qty",""+ret_item_qty);
							alExpData.add(hmExpRecord);
						}
				   }
			double toStrQty=((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code())))/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getTo_store_code()));
			double mm_trn_qty=((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code())));
				hmDtlRecord.put("to_str_qty",""+toStrQty);
				hmDtlRecord.put("mm_trn_qty",""+mm_trn_qty);
				hmDtlRecord.put("to_conv_fact",""+getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getTo_store_code()));
				hmDtlRecord.put("frm_conv_fact",""+getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code()));
				alDtlData.add(hmDtlRecord);
				
			}

 			 

					String modified_date ="Select TO_CHAR (modified_date, 'dd/mm/yyyy hh24:mi:ss') modified_date from ST_ITEM_BATCH WHERE store_code	= ?	 AND item_code = ?	AND	batch_id = ?  AND bin_location_code	= ?	 AND trunc(expiry_date_or_receipt_date)	= TO_DATE(?,'dd/mm/yyyy')";
                     
	    HashMap hmRecord = new HashMap();
		ArrayList  hmparam = new ArrayList();
	  for (int l=0; l<alExpData.size();l++ )
		   {
		   
		  hmparam = new ArrayList();
			hmRecord  = new HashMap();
			hmRecord	=	(HashMap)alExpData.get(l);
		   hmparam.add(getTo_store_code());
		   hmparam.add((String)hmRecord.get("ITEM_CODE"));
		   hmparam.add((String)hmRecord.get("BATCH_ID"));
		   hmparam.add(checkForNull((String)hmRecord.get("ISSUE_FM_BIN_LOCATION_CODE")));
		   hmparam.add((String)hmRecord.get("EXPIRY_RECEIPT_DT"));

		 //  hmRecord.put("MODIFIED_DATE",(String)((HashMap)fetchRecord(modified_date,hmparam)).get("MODIFIED_DATE"));

		    HashMap modified_dt = fetchRecord(modified_date,hmparam);
			String modified_date1 = "";
			
			if (modified_dt!= null)	{
			modified_date1 = (String)modified_dt.get("MODIFIED_DATE");
			}

		   hmRecord.put("MODIFIED_DATE",modified_date1);

		   alExpData.set(l,hmRecord);
		   
		   }	
			
			 
			hmTableData.put("properties",	getProperties());
			hmTableData.put("HdrInsertData",	alHdrData);
			hmTableData.put("DtlInsertData",	alDtlData);
			hmTableData.put("ExpInsertData",	alExpData);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(autoGenerateYN));
			hmTableData.put("CommonData",	alCommonData);
			hmTableData.put("LANGUAGE_DATA",	allanguageData);
			//Added by suresh.r on 29-01-2013 against AMS-CRF-0054 beg
	        if(getIssueRetBasedOn().equals("I")){
	        	try{
	        		hmTableData.put("AltFacilityId",(String)((HashMap)fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT"),getTo_store_code())).get("FACILITY_ID"));
	        	}catch(Exception exception) {
	    			exception.printStackTrace();
	    		}
	        }else{ //Added by suresh.r on 29-01-2013 against AMS-CRF-0054 end
			hmTableData.put("AltFacilityId",	getAltFacilityId());
	        }

		}
		catch(Exception exception) {
			exception.printStackTrace();
		}

		hmSQLMap=stockSQL();
		return issueReturnMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);

	}


		public HashMap delete(){

//	HashMap hmResult=new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();

		ArrayList alHdrData		=	new ArrayList();
		ArrayList alCommonData	=	new ArrayList();

       	alCommonData.add(getLoginById() );
		alCommonData.add(getLoginAtWsNo() );
		alCommonData.add(getLoginFacilityId() );
		alCommonData.add(getAltFacilityId());//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
        
		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());
/*update for doc no for audit trail start*/
		ArrayList alUpdateHdrData		=	new ArrayList();
		alUpdateHdrData.add(getLoginById());
		alUpdateHdrData.add(getLoginAtWsNo());
		alUpdateHdrData.add(getLoginFacilityId());
		alUpdateHdrData.add(getLoginFacilityId());
		alUpdateHdrData.add(getDoc_type_code());
		alUpdateHdrData.add(getDoc_no());
		hmTableData.put("ALUPDATEHDRDATA",			alUpdateHdrData);
		
/*update for doc no for audit trail end*/
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();

		for (int i=0;i<alDtlRecords.size();i++) {
		
				HashMap hmDtlRecord	=(HashMap)alDtlRecords.get(i);
				hmDtlRecord.put("from_store_code",getFrom_store_code());
                hmDtlRecord.put("to_store_code",  getTo_store_code());
				hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
				ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
					if (sourceArrayList!=null) 
						for (int j=0;j<sourceArrayList.size(); j++ ) {
							HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
							double ret_item_qty = Double.parseDouble(checkForNull((String)hmExpRecord.get("QTY"),(String)hmExpRecord.get("AVAIL_QTY")))/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getTo_store_code()));
							hmExpRecord.put("ret_item_qty",""+ret_item_qty);
							alExpData.add(hmExpRecord);
						}
					
				alDtlData.add(hmDtlRecord);
				}

		hmTableData.put("properties",	getProperties());
		hmTableData.put("HdrInsertData",	alHdrData);
		hmTableData.put("DtlInsertData",	alDtlData);
		hmTableData.put("ExpInsertData",	alExpData);
		//hmTableData.put("isDocNoAutoGenYN", new Boolean(autoGenerateYN));
		hmTableData.put("CommonData",	alCommonData);

		hmSQLMap=stockSQL();


		return issueReturnMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE );
	}



public HashMap issueReturnMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
        
		HashMap		hmResult	=	new HashMap()	;

//IssueReturnHome	issueReturnHome		= null ;
		IssueReturnRemote	issueReturnRemote		= null ;

		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;
		
		try { 
			
			/* InitialContext context = new InitialContext() ;
			Object object = context.lookup( getStRepositoryValue("JNDI_ST_ISSUE_RETURN") ) ;
			issueReturnHome  = (IssueReturnHome) PortableRemoteObject.narrow( object, IssueReturnHome.class ) ;
			issueReturnRemote = issueReturnHome.create() ;*/
				
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_ISSUE_RETURN"),IssueReturnHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); ;
		paramArray[1] = hmSQLMap.getClass();

			switch (functionID)
			{
				case FUNCTION_INSERT:
					 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);

					//hmResult = issueReturnRemote.insert( hmTableData, hmSQLMap ) ;

                    /*if(((Boolean) hmResult.get("result")).booleanValue()){
						if(autoGenerateYN)
						{
						String s1=getSTMessage(getLanguageId(), "DOC_NO", "ST")+" :"+getDoc_no();
						  hmResult.put("flag", s1) ;
						  }
					}*/

					break;
				

               	case FUNCTION_UPDATE:
					 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					// hmResult = issueReturnRemote.modify( hmTableData, hmSQLMap ) ;
					 break;
     
				
				case FUNCTION_DELETE:
					 hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);

					//hmResult = issueReturnRemote.delete( hmTableData, hmSQLMap ) ;
					break;

				default:
					hmResult.put( "message", "Invalid Function ID passed to salesMethodCall()") ;
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else if( hmResult.get("msgid")!=null  )
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
				
				/* SEND TO PRINT ONLINE REPORT STARTS 9/28/2004 */		

	        ArrayList doc_no	=	new ArrayList();
			if(hmResult.containsKey("doc_no") == true)
				doc_no	= (ArrayList)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest  = getFrom_store_code();
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			stReportid= "STBRETDC";

//			if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			{
				if ( isInternalRequest("ST",stReportid) &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{
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
		






		/*	 SEND TO PRINT ONLINE REPORT STARTS

	        String doc_no	=	(String)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);

			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest  = getFrom_store_code() ;
            PgetTrnType  = getTrn_type() ; 
			PgetSeqNo = getSeq_no() ;


			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));



			if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			{
				boolean bnTrueFalse ;

				bnTrueFalse = isInternalRequest("ST",stReportid);

				if ( bnTrueFalse &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{
						if(alertRqdYN.equals("Y")){	
							hmResult.put("flag",hmResult.get("flag") + "~PY");
						}else{
							doOnlineReportPrinting(doc_no);				
						}
				}
			}*/

	/*	if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
				if (isInternalRequest("ST","STBRETDC")) {
					String doc_no	=	(String)hmResult.get("doc_no");	
					doOnlineReportPrinting(doc_no);				
				}
			}*/

			}
			catch (Exception exception) {
    			    hmResult.put( "message", "Bean 383: "+exception.getMessage()) ;
			        exception.printStackTrace() ;
			}
			finally {
				 try {
				       if( issueReturnRemote != null )
					    issueReturnRemote.remove() ;
			         }
				 catch( Exception exception) {
						hmResult.put( "message", "Bean 393: "+exception.toString()) ;
					}
			}
		    return hmResult;

	}

	public boolean DocTypePrintAllowed (String PgetDoc_type_code){
		if (isDocTypePrintAllowed(PgetDoc_type_code)) 
			return true;
		else
			return false;
	}


	/*public void doOnlineReportPrinting(String doc_no) {
		try{

			String reportid = "STBRETDC";
			if (!isInternalRequest("ST",reportid)) return;

			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_language_id",getLanguageId());
			//hmReportParameter.put("p_finalized_yn",finalized_yn.substring(0,1));

		
			if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;

          //  javax.servlet.http.HttpSession session = request.getSession(false);
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
//			hmParameters.put("p_language_id",getLanguageId());

			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/

	public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{
	
			String reportid = "STBRETDC";
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
			String reportid = "STBRETDC";
			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid,"S", getFrom_store_code());
			//((StDuoHeaderBean)getStHeaderBean()).getFrom_store_code();

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

public HashMap stockSQL(){

			HashMap hmSQLMap		=	new HashMap();

		//	hmSQLMap.put("HdrInsertSQL", getStRepositoryValue("SQL_ST_ISSUE_RETURN_HDR_INSERT"));
			hmSQLMap.put("HdrInsertSQL","INSERT INTO ST_ISSUE_RET_HDR ( facility_id,doc_type_code,doc_no,doc_date,doc_ref,fm_store_code,to_store_code,finalized_yn,process_for_acknowledge,gl_interfaced_yn,trn_type,added_by_id,added_date,added_at_ws_no,added_facility_id,modified_by_id,modified_date,modified_at_ws_no,modified_facility_id,ITEM_CLASS_CODE,ISS_DOC_TYPE_CODE, ISS_DOC_NO) values( ?,?,?,TO_DATE(?, 'dd/mm/yyyy'),?,?,?,?,?,?,?,?,SYSDATE,?,?,?,SYSDATE,?,?,?,?,? )");

			hmSQLMap.put("stSQLHdrUpdate", getStRepositoryValue("SQL_ST_ISSUE_RETURN_HDR_UPDATE"));
			hmSQLMap.put("stSQLHdrDelete", getStRepositoryValue("SQL_ST_ISSUE_RETURN_HDR_DELETE"));

            hmSQLMap.put("DtlInsertSQL", getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_INSERT"));
            hmSQLMap.put("stSQLDtlUpdate", getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_UPDATE"));
			hmSQLMap.put("stSQLDtlDelete", getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_DELETE"));
			hmSQLMap.put("stSQLDtlDeleteALL", getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_DELETE_ALL"));

            hmSQLMap.put("DtlExpInsertSQL", getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_EXP_INSERT"));
			hmSQLMap.put("stSQLExpUpdate", getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_EXP_UPDATE"));
			hmSQLMap.put("stSQLExpDelete", getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_EXP_DELETE"));
			hmSQLMap.put("stSQLExpDeleteAll", getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_EXP_DELETE_ALL"));
			hmSQLMap.put("GetStockItemYNFlag", getStRepositoryValue("SQL_ST_STOCK_ITEM_YN_FLAG"));

			hmSQLMap.put("sql_st_issue_ret_dtl_exp_select_for_block_rel", getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_EXP_SELECT_FOR_BLOCK_REL"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));
			hmSQLMap.put("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));


            hmSQLMap.put("TrnDtlInsertSQL", getStRepositoryValue("SQL_ST_ISSUE_RET_ITEM_TRN_DTL_INSERT"));
            hmSQLMap.put("TrnIssDtlExpUpdateSQL", getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_EXP_UPDATE"));
	        hmSQLMap.put("TrnIssDtlUpdateSQL", getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_UPDATE"));
			

			hmSQLMap.put("NextDocNoUpdateSQL", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));

            hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));
			hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS")); 

			hmSQLMap.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
			hmSQLMap.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
			hmSQLMap.put("ItemCostValueSelectSQL", getStRepositoryValue("SQL_ST_ITEM_VALUE_SELECT"));
			hmSQLMap.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
			hmSQLMap.put("SQLBatchBlockRelease", getStRepositoryValue("SQL_ST_ITEM_BATCH_ISSUE_RET_UPDATE"));
			//hmSQLMap.put("TrnPendQtyIssDtlExpUpdateSQL", getStRepositoryValue("")); QUERY NOT YET WRITTEN..
			
             
            hmSQLMap.put("SQL_TRADE_ID_APPLICABLE_SELECT", getStRepositoryValue("SQL_TRADE_ID_APPLICABLE_SELECT"));
            hmSQLMap.put("SQL_DFLT_TRADE_ID_SELECT", getStRepositoryValue("SQL_DFLT_TRADE_ID_SELECT"));
			hmSQLMap.put("SQL_ITEM_TRADE_SELECT", getStRepositoryValue("SQL_ITEM_TRADE_SELECT"));
			hmSQLMap.put("SQL_ITEM_CODE_TRADE_ID_INSERT", getStRepositoryValue("SQL_ITEM_CODE_TRADE_ID_INSERT")); 

			hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
			hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
			hmSQLMap.put("ItemMovSumInsertSQLST", getStRepositoryValue("SQL_ISSUE_RETURN_ST_ITEM_MOVE_SUMM_INSERT_ST"));
			hmSQLMap.put("ItemMovSumInsertSQLNS", getStRepositoryValue("SQL_ISSUE_RETURN_ST_ITEM_MOVE_SUMM_INSERT_NS"));
			hmSQLMap.put("ItemMovSumFromUpdateSQLST", getStRepositoryValue("SQL_ST_ISSUE_RETURN_FROM_STORE_ITEM_MOVE_SUMM_UPDATE_ST"));
			hmSQLMap.put("ItemMovSumToUpdateSQLST", getStRepositoryValue("SQL_ST_ISSUE_RETURN_TO_STORE_ITEM_MOVE_SUMM_UPDATE_ST"));
			hmSQLMap.put("ItemMovSumFromUpdateSQLNS", getStRepositoryValue("SQL_ST_ISSUE_RETURN_FROM_STORE_ITEM_MOVE_SUMM_UPDATE_NS"));
			hmSQLMap.put("SQL_ST_ISSUE_RET_DTL_EXP_SELECT_MULTIPLE", getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_EXP_SELECT_MULTIPLE"));
			hmSQLMap.put("sql_st_records_per_trn_select", getStRepositoryValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
			hmSQLMap.put("SQL_ST_CONV_FACTOR_SELECT", getStRepositoryValue("SQL_ST_CONV_FACTOR_SELECT"));
			hmSQLMap.put("SQL_ST_GEN_UOM_CODE_SELECT", getStRepositoryValue("SQL_ST_GEN_UOM_CODE_SELECT"));
			hmSQLMap.put("UpdateSqlfordelete", "update  st_issue_ret_hdr set 	FINALIZED_YN='D', MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id	= ?	 AND doc_type_code = ?	AND	doc_no = ? ");
			hmSQLMap.put("sql_st_facility_id_select", getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT"));//Added by Rabbani on 15/04/2014
			hmSQLMap.put("sql_st_store_records_per_trn_select", "SELECT RECORDS_PER_TRN_RET FROM ST_STORE WHERE STORE_CODE=?");//MO-CRF-20176


			return hmSQLMap;

    }

	public HashMap getMinMaxdetails(String  item_code, String store_code)
	{
		HashMap hm = new HashMap();
		try
		{
			String[] stParameters={""+getConvFactTemp(item_code,store_code),item_code,store_code};
			hm=fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),stParameters);
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return hm;	
	}

/*	public String getFinalize_allowed_yn(String stStore_code) throws Exception{
		String stParameters[]	=	{getLoginById(), stStore_code};
		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		return hmRecord.get("RET_FINALIZE_ALLOWED_YN").toString();
	}*/

/*	public void setAll(Hashtable hashtable) {
		setDoc_type_code((String)hashtable.get("doc_type_code"));  
		setDoc_no((String)hashtable.get("doc_no"));  
		setIsAutoNo(hashtable.get("autono_yn").equals("Yes")?true:false);
		setDoc_ref(checkForNull((String)hashtable.get("doc_ref"),""));  
		//setItem_class_code((String)hashtable.get("item_class_code"));  
		setDoc_date((String)hashtable.get("doc_date"));  
		setFrom_store_code((String)hashtable.get("from_store_code"));  
		setTo_store_code((String)hashtable.get("to_store_code"));  
        setRecords_to_delete((String)hashtable.get("records_to_delete"));
		finalized_yn     =(String)hashtable.get("finalized_yn");  
		setFinalized_yn(finalized_yn);

        setRemarks((String)hashtable.get("remarks"));
 	  }*/


  /*    public void loadData() throws Exception	{

		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());



		
		HashMap hmRecord =	fetchRecord(getStRepositoryValue("SQL_ST_ISSUE_RETURN_DTL_SELECT_MAX_DOC_SRL_NO"), alParameters);
		doc_srl_no		 =	Integer.parseInt((String)hmRecord.get("MAX_DOC_SRL_NO"));

		
		hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_ISSUE_RETURN_HDR_SELECT"), alParameters);
		setDoc_date((String)hmRecord.get ("DOC_DATE"));  
		setDoc_ref((String)hmRecord.get ("doc_reference"));  
		setFrom_store_code((String)hmRecord.get("FM_STORE_CODE"));  
		setTo_store_code((String)hmRecord.get ("TO_STORE_CODE"));
        //setRemarks((String)hmRecord.get ("remarks"));
		//setItem_class_code((String)hmRecord.get ("ITEM_CLASS_CODE"));

        alParameters.clear();

		alParameters.add(getTo_store_code());
		alParameters.add(getFrom_store_code());
        alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_no());
		alParameters.add(getDoc_type_code());

		ArrayList alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_SELECT_MULTIPLE"), alParameters);

 
    
	    for (int i=0; i<alRecords.size(); i++) {

			hmRecord	=	(HashMap)alRecords.get(i);

			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",hmRecord.get("COST_VALUE"));
			hmTemp.put("item_unit_cost",hmRecord.get("UNIT_COST"));
			//hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			hmTemp.put("stock_available",hmRecord.get("PEND_QTY"));
            hmTemp.put("Max_Returnable_Qty",hmRecord.get("PEND_QTY"));
			hmTemp.put("item_qty",hmRecord.get("ITEM_QTY"));
				
//			tempRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_SELECT_QTY"), alParameters);

			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
            hmTemp.put("remarks",checkForNull((String)hmRecord.get("REMARKS"),""));


			alDtlRecords.add(hmTemp);

		} 
     
		for (int i=0; i<alDtlRecords.size(); i++) {


			hmRecord	=	(HashMap)alDtlRecords.get(i);

            alParameters.clear();
			alParameters.add(getLoginFacilityId());
			//alParameters.add(getTo_store_code());
			//alParameters.add(getFrom_store_code());
			alParameters.add(getDoc_no());
			alParameters.add(getDoc_type_code());
			alParameters.add((String)hmRecord.get("doc_srl_no"));


			alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_EXP_SELECT_MULTIPLE"), alParameters);
			hmExpRecords.put(""+i,alRecords);


		  }
     
	}*/
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
	}*/
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
	}
	public String getShortDesc(String item_code,String store_code) throws Exception {
		String chkdefaultParameters[] = {store_code,item_code,getLanguageId()};
		String short_desc			  = "";	
		HashMap short_des			  = new HashMap();
		try{
		//	short_des = fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=(SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE=? AND ITEM_CODE=?) AND LANGUAGE_ID=?",chkdefaultParameters);
				short_des = fetchRecord(getStRepositoryValue("SQL_ST_UOM_SHORT_DESC_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			short_desc = "";
		}
		
		if(short_des.size() > 0)
			short_desc = (String)short_des.get("SHORT_DESC");

		return short_desc;
	}
/*Method moved to Adapter class as this is used commonly in more than 8 functions Mahesh 14/12/2009*/
/*	public String getAccessCostDetails(){
		String cost_yn			  = "N";	
		HashMap view_cost_yn	  = new HashMap();
		try{
			view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_YN_SELECT"),getLoginById());
		}catch(Exception e){
			cost_yn = "";
		}
		if(view_cost_yn.size() > 0){
			//Check For Null is added on 14/12/2009 By Mahesh
			cost_yn = checkForNull((String)view_cost_yn.get("VIEW_COST_YN"),"N");
		}
		return cost_yn;
	}
*/
	public java.util.ArrayList getOnStoresIssueReturn(String req_by_store) throws Exception{
		ArrayList result		=	new ArrayList();
		String chkParameters[]={getLoginById(),getAcc_entity_id(),login_facility_id,getLanguageId(),req_by_store};
		result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_RET_TO_STORE"),chkParameters);
		
		return result;
	}
/*	public String getIssueDocType() {
		//String sql = eST.Common.StRepository.getStKeyValue("SQL_QRY_ST_ISSUE_RET_FROM_STORE");
		String sql = "SELECT DISTINCT A.DOC_TYPE_CODE, B.SHORT_DESC FROM ST_ISSUE_HDR A, SY_DOC_TYPE_MASTER B WHERE A.DOC_TYPE_CODE = B.DOC_TYPE_CODE";
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		//sqlParam.add(getLoginFacilityId());
		//sqlParam.add(getLoginById());
		//sqlParam.add(getLanguageId());
		String def_value = "";
		return getListValues(sql, sqlParam,def_value);
	}
*/	public String getIssueDocType(){
		String defaultValue = "";
		return getListOptionTag(getListOptionArrayList("SELECT DISTINCT A.DOC_TYPE_CODE, B.SHORT_DESC FROM ST_ISSUE_HDR A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND B.LANGUAGE_ID = ?",getLanguageId()),defaultValue);
		//return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST")),defaultValue);
	}
	public String getIssueDocTypeList(){
		return getListOptionTag(getListOptionArrayList("SELECT DISTINCT A.DOC_TYPE_CODE, B.SHORT_DESC FROM ST_ISSUE_HDR A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND B.LANGUAGE_ID = ?",getLanguageId()),getIssueDocTypeCode());
		//return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST")),defaultValue);
	}
	public ArrayList getIssueDocNoArrayList(String issue_doc_type_code){
		String stParameters[]={issue_doc_type_code,getTo_store_code(),getFrom_store_code(),getLoginFacilityId()};
		try{
			return fetchRecords("SELECT   HDR.DOC_NO ISSUE_DOC_NO FROM ST_ISSUE_HDR HDR, ST_ISSUE_DTL_EXP DTL, ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_RET_DTL_EXP RETEXP WHERE HDR.DOC_TYPE_CODE = ? AND HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID = ? AND HDR.DOC_NO = DTL.DOC_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.FACILITY_ID = ACK.FACILITY_ID(+) AND DTL.DOC_NO = ACK.DOC_NO(+) AND DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND DTL.ITEM_CODE = ACK.ITEM_CODE(+) AND DTL.SEQ_NO = ACK.SEQ_NO(+) AND DTL.BATCH_ID = ACK.BATCH_ID(+) AND DTL.TRADE_ID = ACK.TRADE_ID(+) AND DTL.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RETEXP.ORG_DOC_NO(+) = HDR.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = HDR.DOC_TYPE_CODE AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) HAVING SUM (  NVL (ACK.RECEIVED_QTY, ISS_ITEM_QTY) - NVL (ACK1.RECEIVED_QTY,RET_ITEM_QTY)) > 0 GROUP BY HDR.DOC_NO ORDER BY HDR.DOC_NO",stParameters);//
			//Changed By Ramana C 12/29/2008 For Getting the Values In the Doc List
		   //return fetchRecords("SELECT   HDR.DOC_NO ISSUE_DOC_NO FROM ST_ISSUE_HDR HDR, ST_ISSUE_DTL_EXP DTL,ST_ACKNOWLEDGE_TRN_DTL ACK WHERE HDR.DOC_TYPE_CODE = ? AND HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID = ? AND HDR.DOC_NO = DTL.DOC_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.FACILITY_ID = ACK.FACILITY_ID(+) AND DTL.DOC_NO = ACK.DOC_NO(+) AND DTL.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND DTL.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND DTL.ITEM_CODE = ACK.ITEM_CODE(+) AND DTL.SEQ_NO = ACK.SEQ_NO(+) AND DTL.BATCH_ID = ACK.BATCH_ID(+) AND DTL.TRADE_ID = ACK.TRADE_ID(+) AND DTL.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) HAVING SUM (NVL (ACK.RECEIVED_QTY,ISS_ITEM_QTY) - RET_ITEM_QTY) > 0 GROUP BY HDR.DOC_NO ORDER BY HDR.DOC_NO",stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return new ArrayList();
		}
	}
	public String getIssueDocNoList(){
		String stParameters[]= new String[] {getIssueDocTypeCode(),getTo_store_code(),getFrom_store_code(),getLoginFacilityId()};
			return getListOptionTag(getListOptionArrayList("SELECT HDR.DOC_NO,HDR.DOC_NO ISSUE_DOC_NO FROM ST_ISSUE_HDR HDR,ST_ISSUE_DTL DTL WHERE HDR.DOC_TYPE_CODE = ? AND HDR.FM_STORE_CODE = ? AND HDR.TO_STORE_CODE = ? AND HDR.FINALIZED_YN = 'Y' AND HDR.FACILITY_ID = ? AND HDR.DOC_NO = DTL.DOC_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID ORDER BY HDR.DOC_NO",stParameters),(String)getIssueDocNo());
//		return fetchRecords(getStRepositoryValue("ST_SQL_SALES_DOC_NO_SELECT"),stParameters);
	}
	public void loadDetailPage(String doc_no,String issue_doc_type_code,String seq_no,String facility_id){
		HashMap hmRecord = new HashMap();
		HashMap hmTempFactor = new HashMap();
		ArrayList alParameters = new ArrayList();
		setAltFacilityId(facility_id);
		alDtlRecords = new ArrayList();
		//alParameters.add(getLoginFacilityId());
		alParameters.add(facility_id);
		alParameters.add(doc_no);
		alParameters.add(issue_doc_type_code);
		alParameters.add(getLanguageId());
		alParameters.add(seq_no);

		alParameters.add(facility_id);
		alParameters.add(doc_no);
		alParameters.add(issue_doc_type_code);
		alParameters.add(getLanguageId());
		alParameters.add(seq_no);


		try{


			//ArrayList alRecords	=	(ArrayList)fetchRecords("SELECT DISTINCT HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, HDR.DOC_NO ISS_DOC_NO,DTL.STORE_CODE, DTL.ITEM_CODE,((SUM (STEXP.ISS_ITEM_QTY - (NVL(ISSUE_QTY,0)-NVL (RECEIVED_QTY, 0)))/ (SELECT EQVL_VALUE CONV_FACTOR FROM MM_ITEM_UOM_DEFN WHERE UOM_CODE = (SELECT GEN_UOM_CODE FROM MM_ITEM_LANG_VW WHERE ITEM_CODE = DTL.ITEM_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) AND EQVL_UOM_CODE = (SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE = HDR.FM_STORE_CODE AND ITEM_CODE = DTL.ITEM_CODE) AND ITEM_CODE = DTL.ITEM_CODE UNION SELECT EQVL_VALUE FROM AM_UOM_EQVL WHERE UOM_CODE = (SELECT GEN_UOM_CODE FROM MM_ITEM_LANG_VW WHERE ITEM_CODE = DTL.ITEM_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) AND EQVL_UOM_CODE = (SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE = HDR.FM_STORE_CODE AND ITEM_CODE = DTL.ITEM_CODE) UNION SELECT 1 FROM DUAL WHERE (SELECT GEN_UOM_CODE FROM MM_ITEM_LANG_VW WHERE ITEM_CODE = DTL.ITEM_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) = (SELECT DEF_ISSUE_UOM FROM ST_ITEM_STORE WHERE STORE_CODE = HDR.FM_STORE_CODE AND ITEM_CODE = DTL.ITEM_CODE)))- NVL (DTL.RET_ITEM_QTY, 0)) PEND_QTY,DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM,AM.UOM_CODE, AM.SHORT_DESC UOM_DESC, AM1.SHORT_DESC STOCK_UOM,MM.SHORT_DESC ITEM_DESC, DTL.DOC_SRL_NO FROM ST_ISSUE_HDR HDR,ST_ISSUE_DTL DTL,ST_ISSUE_DTL_EXP STEXP,ST_ITEM_STORE STITS,AM_UOM_LANG_VW AM,MM_ITEM_LANG_VW MM,AM_UOM_LANG_VW AM1,ST_ITEM_BATCH STB,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_FACILITY_PARAM STP WHERE HDR.FACILITY_ID = ? AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND STITS.ITEM_CODE = DTL.ITEM_CODE AND STITS.STORE_CODE = HDR.TO_STORE_CODE AND AM.UOM_CODE = MM.GEN_UOM_CODE AND AM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID AND MM.ITEM_CODE = DTL.ITEM_CODE AND AM1.UOM_CODE = STITS.DEF_ISSUE_UOM AND AM1.LANGUAGE_ID = AM.LANGUAGE_ID AND DTL.DOC_NO = STEXP.DOC_NO AND DTL.DOC_TYPE_CODE = STEXP.DOC_TYPE_CODE AND DTL.SEQ_NO = STEXP.SEQ_NO AND STEXP.ITEM_CODE = STB.ITEM_CODE AND STEXP.BATCH_ID = STB.BATCH_ID AND HDR.FM_STORE_CODE = STB.STORE_CODE AND STEXP.BIN_LOCATION_CODE = STB.BIN_LOCATION_CODE AND STEXP.EXPIRY_DATE_OR_RECEIPT_DATE = STB.EXPIRY_DATE_OR_RECEIPT_DATE AND STEXP.FACILITY_ID = ACK.FACILITY_ID(+) AND STEXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND STEXP.DOC_NO = ACK.DOC_NO(+) AND STEXP.ITEM_CODE = ACK.ITEM_CODE(+) AND HDR.FACILITY_ID = STP.FACILITY_ID GROUP BY HDR.FM_STORE_CODE,HDR.TO_STORE_CODE,HDR.DOC_NO,DTL.STORE_CODE,DTL.ITEM_CODE,DTL.ISS_ITEM_QTY,DTL.RET_ITEM_QTY,DTL.ITEM_UNIT_COST,DTL.ITEM_COST_VALUE,STITS.DEF_ISSUE_UOM,AM.UOM_CODE,AM.SHORT_DESC,AM1.SHORT_DESC,MM.SHORT_DESC,DTL.DOC_SRL_NO,MM.LANGUAGE_ID,ACKNOWLEDGE_REQD_YN",alParameters);
			//ArrayList alRecords	=	(ArrayList)fetchRecords("SELECT * FROM (SELECT  SEQ_NO, FM_STORE_CODE, TO_STORE_CODE, ISS_DOC_NO, STORE_CODE,ITEM_CODE, SUM (PEND_QTY) PEND_QTY, ITEM_UNIT_COST, SUM(ITEM_COST_VALUE) ITEM_COST_VALUE,DEF_ISSUE_UOM, UOM_CODE, UOM_DESC, STOCK_UOM, ITEM_DESC,DOC_SRL_NO FROM (SELECT DISTINCT HDR.SEQ_NO, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE,HDR.DOC_NO ISS_DOC_NO, DTL.STORE_CODE,DTL.ITEM_CODE,(NVL(ACK.RECEIVED_QTY,STEXP.ISS_ITEM_QTY)- NVL (ACK1.RECEIVED_QTY,STEXP.RET_ITEM_QTY)) /ST_GET_UOM_CONV_FAC_SING_STR(dtl.ITEM_CODE,hdr.FM_STORE_CODE)PEND_QTY,DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE,STITS.DEF_ISSUE_UOM, AM.UOM_CODE,AM.SHORT_DESC UOM_DESC,AM1.SHORT_DESC STOCK_UOM,MM.SHORT_DESC ITEM_DESC, DTL.DOC_SRL_NO, STEXP.BATCH_ID FROM ST_ISSUE_HDR HDR,ST_ISSUE_DTL DTL,ST_ISSUE_DTL_EXP STEXP,ST_ITEM_STORE STITS,AM_UOM_LANG_VW AM,MM_ITEM_LANG_VW MM,AM_UOM_LANG_VW AM1,ST_ITEM_BATCH STB,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_FACILITY_PARAM STP,ST_ISSUE_RET_DTL_EXP RETEXP,ST_ACKNOWLEDGE_TRN_DTL ACK1 WHERE HDR.FACILITY_ID = ? AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND HDR.DOC_NO = DTL.DOC_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.SEQ_NO = DTL.SEQ_NO AND STITS.ITEM_CODE = DTL.ITEM_CODE AND STITS.STORE_CODE =  HDR.TO_STORE_CODE AND AM.UOM_CODE = MM.GEN_UOM_CODE AND AM.LANGUAGE_ID = ?  AND HDR.SEQ_NO=? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID AND MM.ITEM_CODE = DTL.ITEM_CODE AND AM1.UOM_CODE = STITS.DEF_ISSUE_UOM AND AM1.LANGUAGE_ID = AM.LANGUAGE_ID AND DTL.DOC_NO = STEXP.DOC_NO AND DTL.DOC_TYPE_CODE = STEXP.DOC_TYPE_CODE AND DTL.SEQ_NO = STEXP.SEQ_NO AND DTL.ITEM_CODE = STEXP.ITEM_CODE AND STEXP.ITEM_CODE = STB.ITEM_CODE(+) AND STEXP.BATCH_ID = STB.BATCH_ID(+) AND STEXP.STORE_CODE = STB.STORE_CODE(+) AND STEXP.BIN_LOCATION_CODE = STB.BIN_LOCATION_CODE(+) AND STEXP.EXPIRY_DATE_OR_RECEIPT_DATE = STB.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND STEXP.BATCH_ID = ACK.BATCH_ID(+) AND STEXP.FACILITY_ID = ACK.FACILITY_ID(+) AND STEXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND STEXP.DOC_NO = ACK.DOC_NO(+) AND STEXP.ITEM_CODE = ACK.ITEM_CODE(+) AND HDR.FACILITY_ID = STP.FACILITY_ID AND RETEXP.ORG_DOC_NO(+) = STEXP.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = STEXP.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = STEXP.SEQ_NO AND RETEXP.BATCH_ID(+)=STEXP.BATCH_ID   AND RETEXP.ITEM_CODE(+)=STEXP.ITEM_CODE AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND NVL(ACK.RECEIVED_QTY(+),0) > 0 )  GROUP BY FM_STORE_CODE,TO_STORE_CODE,ISS_DOC_NO,STORE_CODE,ITEM_CODE,ITEM_UNIT_COST, DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM,ITEM_DESC,DOC_SRL_NO,SEQ_NO) WHERE PEND_QTY > 0",alParameters);
			//Commented by Rabbani on 17/02/2012
			//ArrayList alRecords	=	(ArrayList)fetchRecords("SELECT * FROM (SELECT   SEQ_NO,FM_STORE_CODE, TO_STORE_CODE,ISS_DOC_NO,STORE_CODE,ITEM_CODE, DOC_TYPE_CODE, SUM((CASE  WHEN (NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL (ACK_RET_QTY, RET_QTY)) <  (BATCH_QTY - BATCH_COMMT_QTY ) THEN (NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL (ACK_RET_QTY, RET_QTY) ) ELSE BATCH_QTY - BATCH_COMMT_QTY END )) / ST_GET_UOM_CONV_FAC_SING_STR (ITEM_CODE,FM_STORE_CODE ) PEND_QTY, ITEM_UNIT_COST,ITEM_COST_VALUE,DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM, ITEM_DESC,DOC_SRL_NO FROM (SELECT   HDR.SEQ_NO,HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, EXP.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY,  SUM (NVL (ACK1.RECEIVED_QTY,0)) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_QTY, NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY,HDR.DOC_NO ISS_DOC_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM, AM.UOM_CODE, AM.SHORT_DESC UOM_DESC, AM1.SHORT_DESC STOCK_UOM, MM.SHORT_DESC ITEM_DESC, DTL.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK , ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB, ST_ISSUE_HDR HDR, AM_UOM_LANG_VW AM, MM_ITEM_LANG_VW MM, ST_ISSUE_DTL DTL, AM_UOM_LANG_VW AM1, ST_ITEM_STORE STITS WHERE HDR.FACILITY_ID = ? AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND AM.UOM_CODE = MM.GEN_UOM_CODE AND AM.LANGUAGE_ID = ? AND HDR.SEQ_NO = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID AND MM.ITEM_CODE = DTL.ITEM_CODE   AND STITS.ITEM_CODE = DTL.ITEM_CODE AND STITS.STORE_CODE = HDR.TO_STORE_CODE AND DTL.DOC_NO = EXP.DOC_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.ITEM_CODE = EXP.ITEM_CODE     AND AM1.UOM_CODE = STITS.DEF_ISSUE_UOM AND AM1.LANGUAGE_ID = AM.LANGUAGE_ID AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+)  AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND STB.BATCH_ID(+) = EXP.BATCH_ID AND STB.TRADE_ID(+) = EXP.TRADE_ID AND STB.ITEM_CODE(+) = EXP.ITEM_CODE AND STB.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.bin_location_code(+) = EXP.to_bin_location_code AND HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO AND HDR.TO_STORE_CODE = STB.STORE_CODE GROUP BY EXP.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY, STB.QTY_ON_HAND, STB.COMMITTED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, HDR.SEQ_NO,HDR.DOC_NO, DTL.ITEM_UNIT_COST,DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM, AM.UOM_CODE, AM.SHORT_DESC , AM1.SHORT_DESC , MM.SHORT_DESC , DTL.DOC_SRL_NO ) GROUP BY FM_STORE_CODE, TO_STORE_CODE, DOC_TYPE_CODE, STORE_CODE,ITEM_CODE, SEQ_NO, ISS_DOC_NO, ITEM_UNIT_COST, ITEM_COST_VALUE,DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM, ITEM_DESC,DOC_SRL_NO) WHERE PEND_QTY > 0  ",alParameters);
		
		         //Added by Rabbani on 17/02/2012
                 //commented by Rabbani on 29/02/2012				
			//ArrayList alRecords	=	(ArrayList)fetchRecords("SELECT * FROM (SELECT   SEQ_NO,FM_STORE_CODE, TO_STORE_CODE,ISS_DOC_NO,STORE_CODE,ITEM_CODE, DOC_TYPE_CODE, SUM((CASE  WHEN (NVL (ISS_QTY,ACK_ISSUE_QTY) - NVL (RET_QTY,ACK_RET_QTY)) <  (BATCH_QTY - BATCH_COMMT_QTY ) THEN (NVL (ISS_QTY,ACK_ISSUE_QTY) - NVL (RET_QTY,ACK_RET_QTY) ) ELSE BATCH_QTY - BATCH_COMMT_QTY END )) / ST_GET_UOM_CONV_FAC_SING_STR (ITEM_CODE,FM_STORE_CODE ) PEND_QTY, ITEM_UNIT_COST,ITEM_COST_VALUE,DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM, ITEM_DESC,DOC_SRL_NO FROM (SELECT   HDR.SEQ_NO,HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, EXP.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY,  SUM (NVL (ACK1.RECEIVED_QTY,0)) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_QTY, NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY,HDR.DOC_NO ISS_DOC_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM, AM.UOM_CODE, AM.SHORT_DESC UOM_DESC, AM1.SHORT_DESC STOCK_UOM, MM.SHORT_DESC ITEM_DESC, DTL.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK , ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB, ST_ISSUE_HDR HDR, AM_UOM_LANG_VW AM, MM_ITEM_LANG_VW MM, ST_ISSUE_DTL DTL, AM_UOM_LANG_VW AM1, ST_ITEM_STORE STITS WHERE HDR.FACILITY_ID = ? AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND AM.UOM_CODE = MM.GEN_UOM_CODE AND AM.LANGUAGE_ID = ? AND HDR.SEQ_NO = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID AND MM.ITEM_CODE = DTL.ITEM_CODE   AND STITS.ITEM_CODE = DTL.ITEM_CODE AND STITS.STORE_CODE = HDR.TO_STORE_CODE AND DTL.DOC_NO = EXP.DOC_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.ITEM_CODE = EXP.ITEM_CODE     AND AM1.UOM_CODE = STITS.DEF_ISSUE_UOM AND AM1.LANGUAGE_ID = AM.LANGUAGE_ID AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+)  AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND STB.BATCH_ID(+) = EXP.BATCH_ID AND STB.TRADE_ID(+) = EXP.TRADE_ID AND STB.ITEM_CODE(+) = EXP.ITEM_CODE AND STB.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.bin_location_code(+) = EXP.to_bin_location_code AND HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO AND HDR.TO_STORE_CODE = STB.STORE_CODE GROUP BY EXP.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY, STB.QTY_ON_HAND, STB.COMMITTED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, HDR.SEQ_NO,HDR.DOC_NO, DTL.ITEM_UNIT_COST,DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM, AM.UOM_CODE, AM.SHORT_DESC , AM1.SHORT_DESC , MM.SHORT_DESC , DTL.DOC_SRL_NO ) GROUP BY FM_STORE_CODE, TO_STORE_CODE, DOC_TYPE_CODE, STORE_CODE,ITEM_CODE, SEQ_NO, ISS_DOC_NO, ITEM_UNIT_COST, ITEM_COST_VALUE,DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM, ITEM_DESC,DOC_SRL_NO) WHERE PEND_QTY > 0  ",alParameters);
			//Added by Rabbani on 29/02/2012
			//ArrayList alRecords	=	(ArrayList)fetchRecords("SELECT * FROM (SELECT   SEQ_NO,FM_STORE_CODE, TO_STORE_CODE,ISS_DOC_NO,STORE_CODE,ITEM_CODE, DOC_TYPE_CODE, SUM((CASE  WHEN (NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL (RET_QTY,ACK_RET_QTY)) <  (BATCH_QTY - BATCH_COMMT_QTY ) THEN (NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL ( RET_QTY,ACK_RET_QTY) ) ELSE BATCH_QTY - BATCH_COMMT_QTY END )) / ST_GET_UOM_CONV_FAC_SING_STR (ITEM_CODE,FM_STORE_CODE ) PEND_QTY, ITEM_UNIT_COST,ITEM_COST_VALUE,DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM, ITEM_DESC,DOC_SRL_NO FROM (SELECT   HDR.SEQ_NO,HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, EXP.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY,  /*SUM (NVL (ACK1.RECEIVED_QTY,0)) ACK_RET_QTY*/ SUM (ACK1.RECEIVED_QTY+ACK1.REJECTED_QTY) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_QTY, NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY,HDR.DOC_NO ISS_DOC_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM, AM.UOM_CODE, AM.SHORT_DESC UOM_DESC, AM1.SHORT_DESC STOCK_UOM, MM.SHORT_DESC ITEM_DESC, DTL.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK , ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB, ST_ISSUE_HDR HDR, AM_UOM_LANG_VW AM, MM_ITEM_LANG_VW MM, ST_ISSUE_DTL DTL, AM_UOM_LANG_VW AM1, ST_ITEM_STORE STITS WHERE HDR.FACILITY_ID = ? AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND AM.UOM_CODE = MM.GEN_UOM_CODE AND AM.LANGUAGE_ID = ? AND HDR.SEQ_NO = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID AND MM.ITEM_CODE = DTL.ITEM_CODE   AND STITS.ITEM_CODE = DTL.ITEM_CODE AND STITS.STORE_CODE = HDR.TO_STORE_CODE AND DTL.DOC_NO = EXP.DOC_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.ITEM_CODE = EXP.ITEM_CODE     AND AM1.UOM_CODE = STITS.DEF_ISSUE_UOM AND AM1.LANGUAGE_ID = AM.LANGUAGE_ID AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+)  AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND STB.BATCH_ID(+) = EXP.BATCH_ID AND STB.TRADE_ID(+) = EXP.TRADE_ID AND STB.ITEM_CODE(+) = EXP.ITEM_CODE AND STB.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.bin_location_code(+) = EXP.to_bin_location_code AND HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO AND HDR.TO_STORE_CODE = STB.STORE_CODE GROUP BY EXP.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY, STB.QTY_ON_HAND, STB.COMMITTED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, HDR.SEQ_NO,HDR.DOC_NO, DTL.ITEM_UNIT_COST,DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM, AM.UOM_CODE, AM.SHORT_DESC , AM1.SHORT_DESC , MM.SHORT_DESC , DTL.DOC_SRL_NO ) GROUP BY FM_STORE_CODE, TO_STORE_CODE, DOC_TYPE_CODE, STORE_CODE,ITEM_CODE, SEQ_NO, ISS_DOC_NO, ITEM_UNIT_COST, ITEM_COST_VALUE,DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM, ITEM_DESC,DOC_SRL_NO) WHERE PEND_QTY > 0  ",alParameters);


			//by ganga Thursday, March 15, 2012
			ArrayList alRecords	=	(ArrayList)fetchRecords("SELECT * FROM (SELECT   SEQ_NO,FM_STORE_CODE, TO_STORE_CODE,ISS_DOC_NO,STORE_CODE,ITEM_CODE, DOC_TYPE_CODE, SUM((CASE  WHEN (NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL (RET_QTY,ACK_RET_QTY)) <  (BATCH_QTY - BATCH_COMMT_QTY ) THEN (NVL (ACK_ISSUE_QTY, ISS_QTY) - NVL ( RET_QTY,ACK_RET_QTY) ) ELSE BATCH_QTY - BATCH_COMMT_QTY END )) / ST_GET_UOM_CONV_FAC_SING_STR (ITEM_CODE,FM_STORE_CODE ) PEND_QTY, ITEM_UNIT_COST,ITEM_COST_VALUE,DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM, ITEM_DESC,DOC_SRL_NO FROM (SELECT   HDR.SEQ_NO,HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, EXP.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY,  /*SUM (NVL (ACK1.RECEIVED_QTY,0)) ACK_RET_QTY*/ SUM (ACK1.RECEIVED_QTY+ACK1.REJECTED_QTY) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_QTY, NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY,HDR.DOC_NO ISS_DOC_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM, AM.UOM_CODE, AM.SHORT_DESC UOM_DESC, AM1.SHORT_DESC STOCK_UOM, MM.SHORT_DESC ITEM_DESC, DTL.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK , ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB, ST_ISSUE_HDR HDR, AM_UOM_LANG_VW AM, MM_ITEM_LANG_VW MM, ST_ISSUE_DTL DTL, AM_UOM_LANG_VW AM1, ST_ITEM_STORE STITS WHERE HDR.FACILITY_ID = ? AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND AM.UOM_CODE = MM.GEN_UOM_CODE AND AM.LANGUAGE_ID = ? AND HDR.SEQ_NO = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID AND MM.ITEM_CODE = DTL.ITEM_CODE   AND STITS.ITEM_CODE = DTL.ITEM_CODE AND STITS.STORE_CODE = HDR.TO_STORE_CODE AND DTL.DOC_NO = EXP.DOC_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.ITEM_CODE = EXP.ITEM_CODE     AND AM1.UOM_CODE = STITS.DEF_ISSUE_UOM AND AM1.LANGUAGE_ID = AM.LANGUAGE_ID AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+)  AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND STB.BATCH_ID(+) = EXP.BATCH_ID AND STB.TRADE_ID(+) = EXP.TRADE_ID AND STB.ITEM_CODE(+) = EXP.ITEM_CODE AND STB.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.bin_location_code(+) = EXP.to_bin_location_code AND HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO AND HDR.TO_STORE_CODE = STB.STORE_CODE GROUP BY EXP.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY, STB.QTY_ON_HAND, STB.COMMITTED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, HDR.SEQ_NO,HDR.DOC_NO, DTL.ITEM_UNIT_COST,DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM, AM.UOM_CODE, AM.SHORT_DESC , AM1.SHORT_DESC , MM.SHORT_DESC , DTL.DOC_SRL_NO,EXP.batch_id) GROUP BY FM_STORE_CODE, TO_STORE_CODE, DOC_TYPE_CODE, STORE_CODE,ITEM_CODE, SEQ_NO, ISS_DOC_NO, ITEM_UNIT_COST, ITEM_COST_VALUE,DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM, ITEM_DESC,DOC_SRL_NO UNION SELECT  SEQ_NO,FM_STORE_CODE, TO_STORE_CODE,ISS_DOC_NO,STORE_CODE,ITEM_CODE, DOC_TYPE_CODE, SUM(NVL (ack_issue_qty, iss_qty) - NVL (ret_qty, ack_ret_qty)) / ST_GET_UOM_CONV_FAC_SING_STR (ITEM_CODE,FM_STORE_CODE ) PEND_QTY, ITEM_UNIT_COST,ITEM_COST_VALUE,DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM, ITEM_DESC,DOC_SRL_NO FROM (SELECT   HDR.SEQ_NO,HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, EXP.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY, SUM (ACK1.RECEIVED_QTY+ACK1.REJECTED_QTY) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_QTY,0 BATCH_QTY,0 BATCH_COMMT_QTY,HDR.DOC_NO ISS_DOC_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM, AM.UOM_CODE, AM.SHORT_DESC UOM_DESC, AM1.SHORT_DESC STOCK_UOM, MM.SHORT_DESC ITEM_DESC, DTL.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK , ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_HDR HDR, AM_UOM_LANG_VW AM, MM_ITEM_LANG_VW MM, ST_ISSUE_DTL DTL, AM_UOM_LANG_VW AM1, ST_ITEM_STORE STITS WHERE HDR.FACILITY_ID = ? AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND AM.UOM_CODE = MM.GEN_UOM_CODE AND AM.LANGUAGE_ID = ? AND HDR.SEQ_NO = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID AND MM.ITEM_CODE = DTL.ITEM_CODE   AND STITS.ITEM_CODE = DTL.ITEM_CODE AND STITS.STORE_CODE = HDR.TO_STORE_CODE AND DTL.DOC_NO = EXP.DOC_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.ITEM_CODE = EXP.ITEM_CODE     AND AM1.UOM_CODE = STITS.DEF_ISSUE_UOM AND AM1.LANGUAGE_ID = AM.LANGUAGE_ID AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+)  AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO  AND  DTL.STOCK_ITEM_YN ='N' GROUP BY EXP.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, HDR.SEQ_NO,HDR.DOC_NO, DTL.ITEM_UNIT_COST,DTL.ITEM_COST_VALUE, STITS.DEF_ISSUE_UOM, AM.UOM_CODE, AM.SHORT_DESC , AM1.SHORT_DESC , MM.SHORT_DESC , DTL.DOC_SRL_NO,EXP.batch_id ) GROUP BY FM_STORE_CODE, TO_STORE_CODE, DOC_TYPE_CODE, STORE_CODE,ITEM_CODE, SEQ_NO, ISS_DOC_NO, ITEM_UNIT_COST, ITEM_COST_VALUE,DEF_ISSUE_UOM,UOM_CODE,UOM_DESC,STOCK_UOM, ITEM_DESC,DOC_SRL_NO) WHERE PEND_QTY > 0  ",alParameters);
			

			 System.out.println("alRecords===2038==>" +alRecords);
			 System.out.println("alParameters===2039==>" +alParameters);
			//AND DTL.ITEM_CODE = STEXP.ITEM_CODE
			/**
			 * @Name - Priya
			 * @Date - 02/06/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost and round up unit cost & item cost value with 	noOfDecimalsForCost
			 */
	int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());

		for (int i=0; i<alRecords.size(); i++) {
			hmRecord	=	(HashMap)alRecords.get(i);
			hmTempFactor = new HashMap();
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"));
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",setNumber((String)hmRecord.get("ITEM_COST_VALUE"),noOfDecimalsForCost));
			hmTemp.put("item_unit_cost",setNumber((String)hmRecord.get("ITEM_UNIT_COST"),noOfDecimalsForCost));
			hmTemp.put("item_unit_cost_org",(String)hmRecord.get("ITEM_UNIT_COST"));
			hmTemp.put("doc_srl_no",checkForNull((String)hmRecord.get("DOC_SRL_NO"),""));
			hmTemp.put("seq_no",checkForNull((String)hmRecord.get("SEQ_NO"),""));
			//Added against inc#50521 to set new unit cost
			double fmUnitCost=(((Double.parseDouble((String)hmRecord.get("ITEM_UNIT_COST"))))*getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("TO_STORE_CODE")))/(getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("FM_STORE_CODE")));
			System.out.println("fmUnitCost====="+fmUnitCost);

			double fmStrQty=(((Double.parseDouble((String)hmRecord.get("PEND_QTY"))))*getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("FM_STORE_CODE")))/(getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("TO_STORE_CODE")));

			//double dtl_trn_val= Double.parseDouble((String)hmRecord.get("ITEM_UNIT_COST"))*Double.parseDouble(""+fmStrQty);
			double dtl_trn_val= Double.parseDouble(""+fmUnitCost)*Double.parseDouble(""+fmStrQty); //Added against inc#50521 to set new cost value
			
			hmTemp.put("item_unit_cost",setNumber(""+fmUnitCost,noOfDecimalsForCost)); //Added against inc#50521 to set new unit_cost
			hmTemp.put("item_unit_cost_org",setNumber(""+fmUnitCost,noOfDecimalsForCost)); //Added against inc#50521 to set new unit_cost
			hmTemp.put("item_cost_value",setNumber(""+dtl_trn_val,noOfDecimalsForCost));
			hmTemp.put("stock_available",setNumber(""+fmStrQty,getNoOfDecimals()));
			hmTemp.put("item_qty",setNumber(""+fmStrQty,getNoOfDecimals()));
			hmTemp.put("Max_Returnable_Qty",setNumber(""+fmStrQty,getNoOfDecimals()));
			hmTemp.put("to_str_qty",(String)hmRecord.get("PEND_QTY"));
			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
			hmTemp.put("stock_uom",hmRecord.get("STOCK_UOM"));
            hmTemp.put("remarks_code","");
			hmTemp.put("uom_desc_base",hmRecord.get("UOM_DESC"));
			if(getAllowDecimalsYN((String)hmRecord.get("ITEM_CODE")).equals("N")){
				hmTempFactor = (HashMap)getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("TO_STORE_CODE"),(String)hmRecord.get("FM_STORE_CODE"),(String)hmRecord.get("DEF_ISSUE_UOM"));
				hmTemp.put("from_multiples",(String)hmTempFactor.get("FROM_STORE_MULTIPLES"));
				hmTemp.put("to_multiples",(String)hmTempFactor.get("TO_STORE_MULTIPLES"));
				hmTemp.put("batch_multiples",(String)hmTempFactor.get("BATCH_QTY_MULTIPLES"));
				hmTemp.put("issue_uom_multiples",(String)hmTempFactor.get("ISSUE_UOM_MULTIPLES"));
			}else{
            	hmTemp.put("to_conv_fact",""+getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("FM_STORE_CODE")));
            	hmTemp.put("frm_conv_fact",""+getConvFactTemp((String)hmRecord.get("ITEM_CODE"),(String)hmRecord.get("TO_STORE_CODE")));
			}
			//hmDtlRecord.remove("frm_conv_fact");
			//hmDtlRecord.remove("to_conv_fact");
			alDtlRecords.add(hmTemp);
		} 
		for (int i=0; i<alDtlRecords.size(); i++) {
			hmRecord	=	(HashMap)alDtlRecords.get(i);
            alParameters = new ArrayList();
            alRecords = new ArrayList();
			alParameters.add(doc_no);
			alParameters.add(issue_doc_type_code);
			alParameters.add((String)hmRecord.get("doc_srl_no"));
			//alParameters.add(getLoginFacilityId());
			alParameters.add(facility_id);
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add((String)hmRecord.get("seq_no"));

			alParameters.add(doc_no);
			alParameters.add(issue_doc_type_code);
			alParameters.add((String)hmRecord.get("doc_srl_no"));
			alParameters.add(facility_id);
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add((String)hmRecord.get("seq_no"));


			//alRecords	=	fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RET_DTL_EXP_SELECT_MULTIPLE"), alParameters);
			//alRecords	=	fetchRecords("SELECT  DISTINCT HDR.DOC_NO, HDR.DOC_TYPE_CODE,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DTL.ITEM_CODE,DTL.DOC_SRL_NO, EXP.SEQ_NO, DTL.ITEM_UNIT_COST,DTL.ITEM_COST_VALUE, HDR.FM_STORE_CODE STORE_CODE,HDR.TO_STORE_CODE, MM.SHORT_DESC ITEM_DESC, EXP.BATCH_ID,EXP.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,BIN.SHORT_DESC BIN_DESC,EXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE,TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,EXP.TRADE_ID,(CASE WHEN EXP.TO_BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = EXP.TO_BIN_LOCATION_CODE AND STORE_CODE = HDR.TO_STORE_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) END) TO_BIN_DESC,EXP.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,EXP.TO_BIN_LOCATION_CODE BIN_LOCATION_CODE, EXP.ISS_ITEM_QTY,EXP.RET_ITEM_QTY,(  (  NVL (EXP.ISS_ITEM_QTY, 0)- (NVL (ACK.ISSUE_QTY, 0) - NVL (ACK.RECEIVED_QTY, 0)))- NVL (ACK1.RECEIVED_QTY,EXP.RET_ITEM_QTY)) AVAIL_QTY,NVL (AM.LONG_NAME, EXP.TRADE_ID) TRADE_NAME FROM ST_ISSUE_HDR HDR,ST_ISSUE_DTL DTL,ST_ISSUE_DTL_EXP EXP,MM_ITEM_LANG_VW MM,MM_BIN_LOCATION_LANG_VW BIN,AM_TRADE_NAME_LANG_VW AM,ST_FACILITY_PARAM STP,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_RET_DTL_EXP RETEXP WHERE HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND DTL.DOC_SRL_NO = ? AND HDR.FACILITY_ID = ? AND HDR.SEQ_NO=DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.DOC_NO = EXP.DOC_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.ITEM_CODE = EXP.ITEM_CODE AND DTL.FACILITY_ID = EXP.FACILITY_ID AND DTL.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = BIN.LANGUAGE_ID AND AM.LANGUAGE_ID(+) = ? AND HDR.SEQ_NO=? AND EXP.TRADE_ID = AM.TRADE_ID(+) AND BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE AND BIN.STORE_CODE = HDR.FM_STORE_CODE AND (  NVL (ACK.RECEIVED_QTY, EXP.ISS_ITEM_QTY)- NVL (ACK1.RECEIVED_QTY,EXP.RET_ITEM_QTY)) > 0 AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND HDR.FACILITY_ID = STP.FACILITY_ID AND DTL.SEQ_NO = EXP.SEQ_NO AND RETEXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RETEXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE  AND RETEXP.ITEM_CODE(+)=EXP.ITEM_CODE AND RETEXP.BATCH_ID(+)=EXP.BATCH_ID AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+)", alParameters);
			/*alRecords	=	fetchRecords("SELECT  HDR.DOC_NO, HDR.DOC_TYPE_CODE, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DTL.ITEM_CODE, DTL.DOC_SRL_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, HDR.FM_STORE_CODE STORE_CODE, HDR.TO_STORE_CODE, MM.SHORT_DESC ITEM_DESC, EXP.BATCH_ID, EXP.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, BIN.SHORT_DESC BIN_DESC, EXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, EXP.TRADE_ID, (CASE WHEN EXP.TO_BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = EXP.TO_BIN_LOCATION_CODE AND STORE_CODE = HDR.TO_STORE_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) END ) TO_BIN_DESC, EXP.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE BIN_LOCATION_CODE, SUM(EXP.ISS_ITEM_QTY) ISS_ITEM_QTY, SUM(EXP.RET_ITEM_QTY), SUM( (  (  NVL (EXP.ISS_ITEM_QTY, 0) - (NVL (ACK.ISSUE_QTY, 0) - NVL (ACK.RECEIVED_QTY, 0)) ) - NVL (ACK1.RECEIVED_QTY, EXP.RET_ITEM_QTY) )) AVAIL_QTY, NVL (AM.LONG_NAME, EXP.TRADE_ID) TRADE_NAME FROM ST_ISSUE_HDR HDR,  ST_ISSUE_DTL DTL, ST_ISSUE_DTL_EXP EXP, MM_ITEM_LANG_VW MM, MM_BIN_LOCATION_LANG_VW BIN, AM_TRADE_NAME_LANG_VW AM, ST_FACILITY_PARAM STP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND DTL.DOC_SRL_NO = ? AND HDR.FACILITY_ID = ? AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND HDR.SEQ_NO=DTL.SEQ_NO AND DTL.DOC_NO = EXP.DOC_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.ITEM_CODE = EXP.ITEM_CODE AND DTL.FACILITY_ID = EXP.FACILITY_ID AND DTL.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = BIN.LANGUAGE_ID AND AM.LANGUAGE_ID(+) = ? AND EXP.TRADE_ID = AM.TRADE_ID(+) AND BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE AND BIN.STORE_CODE = HDR.FM_STORE_CODE AND (  NVL (ACK.RECEIVED_QTY, EXP.ISS_ITEM_QTY) - NVL (ACK1.RECEIVED_QTY, EXP.RET_ITEM_QTY) ) > 0 AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND HDR.FACILITY_ID = STP.FACILITY_ID AND DTL.SEQ_NO = EXP.SEQ_NO AND RETEXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RETEXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RETEXP.BATCH_ID(+) = EXP.BATCH_ID AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) GROUP BY HDR.DOC_NO, DTL.DOC_NO,HDR.DOC_TYPE_CODE,DTL.DOC_TYPE_CODE, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') , DTL.ITEM_CODE, DTL.DOC_SRL_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, HDR.FM_STORE_CODE , HDR.TO_STORE_CODE, MM.SHORT_DESC , EXP.BATCH_ID, EXP.BIN_LOCATION_CODE , BIN.SHORT_DESC,EXP.BIN_LOCATION_CODE, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) , EXP.TRADE_ID, AM.LONG_NAME, EXP.TO_BIN_LOCATION_CODE  ,MM.LANGUAGE_ID", alParameters);*/
			
			//Commented by Rabbani on 17/02/2012
			//alRecords	=	fetchRecords("SELECT * FROM(SELECT DOC_NO,DOC_TYPE_CODE,DOC_DATE,ITEM_CODE, DOC_SRL_NO,SEQ_NO ,ITEM_UNIT_COST,ITEM_COST_VALUE, STORE_CODE,TO_STORE_CODE, ITEM_DESC, BATCH_ID,ISSUE_FM_BIN_LOCATION_CODE,BIN_DESC, NEW_BIN_LOCATION_CODE, EXPIRY_RECEIPT_DT, TRADE_ID,TO_BIN_DESC,ISSUE_TO_BIN_LOCATION_CODE, BIN_LOCATION_CODE,   ISS_ITEM_QTY, ACK_ISSUE_QTY, ACK_RET_QTY, RET_ITEM_QTY, BATCH_QTY, BATCH_COMMT_QTY, (CASE WHEN (NVL (ACK_ISSUE_QTY, ISS_ITEM_QTY) - NVL (ACK_RET_QTY, RET_ITEM_QTY)) <(BATCH_QTY - BATCH_COMMT_QTY ) THEN (NVL (ACK_ISSUE_QTY, ISS_ITEM_QTY) - NVL (ACK_RET_QTY, RET_ITEM_QTY)) ELSE BATCH_QTY - BATCH_COMMT_QTY END ) AVAIL_QTY, TRADE_NAME FROM (SELECT  HDR.DOC_TYPE_CODE DOC_TYPE_CODE, HDR.DOC_NO, HDR.FM_STORE_CODE STORE_CODE, HDR.TO_STORE_CODE, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DTL.DOC_SRL_NO, HDR.SEQ_NO, MM.SHORT_DESC ITEM_DESC, EXP.ITEM_CODE, EXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_ITEM_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY,  SUM (NVL (ACK1.RECEIVED_QTY,0)) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_ITEM_QTY, NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY, STB.BATCH_ID, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, EXP.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, BIN.SHORT_DESC BIN_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, EXP.TRADE_ID, (CASE WHEN EXP.TO_BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = EXP.TO_BIN_LOCATION_CODE AND STORE_CODE = HDR.TO_STORE_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) END ) TO_BIN_DESC, EXP.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID) TRADE_NAME FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_FACILITY_PARAM STP, ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB, ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, MM_BIN_LOCATION_LANG_VW BIN, AM_TRADE_NAME_LANG_VW AM WHERE HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND DTL.DOC_SRL_NO = ? AND HDR.FACILITY_ID = ? AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.ITEM_CODE = EXP.ITEM_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.FACILITY_ID = EXP.FACILITY_ID AND DTL.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID =? AND MM.LANGUAGE_ID = BIN.LANGUAGE_ID AND AM.LANGUAGE_ID(+) = ?   AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+) AND HDR.SEQ_NO = ? AND EXP.FACILITY_ID = STP.FACILITY_ID AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND STB.BATCH_ID(+) = EXP.BATCH_ID AND STB.TRADE_ID(+) = EXP.TRADE_ID AND STB.ITEM_CODE(+) = EXP.ITEM_CODE AND STB.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.bin_location_code(+) = EXP.to_bin_location_code AND HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO AND HDR.TO_STORE_CODE = STB.STORE_CODE AND BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE AND BIN.STORE_CODE = HDR.FM_STORE_CODE AND EXP.TRADE_ID = AM.TRADE_ID(+) GROUP BY HDR.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY, STB.QTY_ON_HAND, STB.COMMITTED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, STB.BATCH_ID, HDR.DOC_NO, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY'), DTL.DOC_SRL_NO, HDR.SEQ_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, MM.SHORT_DESC, EXP.BIN_LOCATION_CODE,EXP.BIN_LOCATION_CODE, BIN.SHORT_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY'), EXP.TRADE_ID, EXP.TO_BIN_LOCATION_CODE, MM.LANGUAGE_ID, EXP.TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID))) WHERE AVAIL_QTY > 0 ", alParameters);
			//Added by Rabbani on 17/02/2012
			//Commented by Rabbani on 29/02/2012			
			//alRecords	=	fetchRecords("SELECT * FROM(SELECT DOC_NO,DOC_TYPE_CODE,DOC_DATE,ITEM_CODE, DOC_SRL_NO,SEQ_NO ,ITEM_UNIT_COST,ITEM_COST_VALUE, STORE_CODE,TO_STORE_CODE, ITEM_DESC, BATCH_ID,ISSUE_FM_BIN_LOCATION_CODE,BIN_DESC, NEW_BIN_LOCATION_CODE, EXPIRY_RECEIPT_DT, TRADE_ID,TO_BIN_DESC,ISSUE_TO_BIN_LOCATION_CODE, BIN_LOCATION_CODE,   ISS_ITEM_QTY, ACK_ISSUE_QTY, ACK_RET_QTY, RET_ITEM_QTY, BATCH_QTY, BATCH_COMMT_QTY, (CASE WHEN (NVL ( ISS_ITEM_QTY,ACK_ISSUE_QTY) - NVL ( RET_ITEM_QTY,ACK_RET_QTY)) <(BATCH_QTY - BATCH_COMMT_QTY ) THEN (NVL (ISS_ITEM_QTY,ACK_ISSUE_QTY) - NVL (RET_ITEM_QTY,ACK_RET_QTY)) ELSE BATCH_QTY - BATCH_COMMT_QTY END ) AVAIL_QTY, TRADE_NAME FROM (SELECT  HDR.DOC_TYPE_CODE DOC_TYPE_CODE, HDR.DOC_NO, HDR.FM_STORE_CODE STORE_CODE, HDR.TO_STORE_CODE, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DTL.DOC_SRL_NO, HDR.SEQ_NO, MM.SHORT_DESC ITEM_DESC, EXP.ITEM_CODE, EXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_ITEM_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY,  SUM (NVL (ACK1.RECEIVED_QTY,0)) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_ITEM_QTY, NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY, STB.BATCH_ID, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, EXP.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, BIN.SHORT_DESC BIN_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, EXP.TRADE_ID, (CASE WHEN EXP.TO_BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = EXP.TO_BIN_LOCATION_CODE AND STORE_CODE = HDR.TO_STORE_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) END ) TO_BIN_DESC, EXP.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID) TRADE_NAME FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_FACILITY_PARAM STP, ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB, ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, MM_BIN_LOCATION_LANG_VW BIN, AM_TRADE_NAME_LANG_VW AM WHERE HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND DTL.DOC_SRL_NO = ? AND HDR.FACILITY_ID = ? AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.ITEM_CODE = EXP.ITEM_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.FACILITY_ID = EXP.FACILITY_ID AND DTL.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID =? AND MM.LANGUAGE_ID = BIN.LANGUAGE_ID AND AM.LANGUAGE_ID(+) = ?   AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+) AND HDR.SEQ_NO = ? AND EXP.FACILITY_ID = STP.FACILITY_ID AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND STB.BATCH_ID(+) = EXP.BATCH_ID AND STB.TRADE_ID(+) = EXP.TRADE_ID AND STB.ITEM_CODE(+) = EXP.ITEM_CODE AND STB.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.bin_location_code(+) = EXP.to_bin_location_code AND HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO AND HDR.TO_STORE_CODE = STB.STORE_CODE AND BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE AND BIN.STORE_CODE = HDR.FM_STORE_CODE AND EXP.TRADE_ID = AM.TRADE_ID(+) GROUP BY HDR.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY, STB.QTY_ON_HAND, STB.COMMITTED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, STB.BATCH_ID, HDR.DOC_NO, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY'), DTL.DOC_SRL_NO, HDR.SEQ_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, MM.SHORT_DESC, EXP.BIN_LOCATION_CODE,EXP.BIN_LOCATION_CODE, BIN.SHORT_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY'), EXP.TRADE_ID, EXP.TO_BIN_LOCATION_CODE, MM.LANGUAGE_ID, EXP.TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID))) WHERE AVAIL_QTY > 0 ", alParameters);
			
			//Added By Rabbani on 29/02/2012
			//alRecords	=	fetchRecords("SELECT * FROM(SELECT DOC_NO,DOC_TYPE_CODE,DOC_DATE,ITEM_CODE, DOC_SRL_NO,SEQ_NO ,ITEM_UNIT_COST,ITEM_COST_VALUE, STORE_CODE,TO_STORE_CODE, ITEM_DESC, BATCH_ID,ISSUE_FM_BIN_LOCATION_CODE,BIN_DESC, NEW_BIN_LOCATION_CODE, EXPIRY_RECEIPT_DT, TRADE_ID,TO_BIN_DESC,ISSUE_TO_BIN_LOCATION_CODE, BIN_LOCATION_CODE,   ISS_ITEM_QTY, ACK_ISSUE_QTY, ACK_RET_QTY, RET_ITEM_QTY, BATCH_QTY, BATCH_COMMT_QTY, (CASE WHEN (NVL (ACK_ISSUE_QTY, ISS_ITEM_QTY) - NVL (RET_ITEM_QTY,ACK_RET_QTY)) <(BATCH_QTY - BATCH_COMMT_QTY ) THEN (NVL (ACK_ISSUE_QTY, ISS_ITEM_QTY) - NVL (RET_ITEM_QTY,ACK_RET_QTY)) ELSE BATCH_QTY - BATCH_COMMT_QTY END ) AVAIL_QTY, TRADE_NAME FROM (SELECT  HDR.DOC_TYPE_CODE DOC_TYPE_CODE, HDR.DOC_NO, HDR.FM_STORE_CODE STORE_CODE, HDR.TO_STORE_CODE, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DTL.DOC_SRL_NO, HDR.SEQ_NO, MM.SHORT_DESC ITEM_DESC, EXP.ITEM_CODE, EXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_ITEM_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY,  /*SUM (NVL (ACK1.RECEIVED_QTY,0)) ACK_RET_QTY*/ SUM(ACK1.RECEIVED_QTY+ACK1.REJECTED_QTY) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_ITEM_QTY, NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY, STB.BATCH_ID, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, EXP.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, BIN.SHORT_DESC BIN_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, EXP.TRADE_ID, (CASE WHEN EXP.TO_BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = EXP.TO_BIN_LOCATION_CODE AND STORE_CODE = HDR.TO_STORE_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) END ) TO_BIN_DESC, EXP.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID) TRADE_NAME FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_FACILITY_PARAM STP, ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB, ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, MM_BIN_LOCATION_LANG_VW BIN, AM_TRADE_NAME_LANG_VW AM WHERE HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND DTL.DOC_SRL_NO = ? AND HDR.FACILITY_ID = ? AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.ITEM_CODE = EXP.ITEM_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.FACILITY_ID = EXP.FACILITY_ID AND DTL.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID =? AND MM.LANGUAGE_ID = BIN.LANGUAGE_ID AND AM.LANGUAGE_ID(+) = ?   AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+) AND HDR.SEQ_NO = ? AND EXP.FACILITY_ID = STP.FACILITY_ID AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND STB.BATCH_ID(+) = EXP.BATCH_ID AND STB.TRADE_ID(+) = EXP.TRADE_ID AND STB.ITEM_CODE(+) = EXP.ITEM_CODE AND STB.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.bin_location_code(+) = EXP.to_bin_location_code AND HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO AND HDR.TO_STORE_CODE = STB.STORE_CODE AND BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE AND BIN.STORE_CODE = HDR.FM_STORE_CODE AND EXP.TRADE_ID = AM.TRADE_ID(+) GROUP BY HDR.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY,STB.QTY_ON_HAND, STB.COMMITTED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, STB.BATCH_ID, HDR.DOC_NO, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY'), DTL.DOC_SRL_NO, HDR.SEQ_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, MM.SHORT_DESC, EXP.BIN_LOCATION_CODE,EXP.BIN_LOCATION_CODE, BIN.SHORT_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY'), EXP.TRADE_ID, EXP.TO_BIN_LOCATION_CODE, MM.LANGUAGE_ID, EXP.TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID)) UNION  SELECT DOC_NO,DOC_TYPE_CODE,DOC_DATE,ITEM_CODE, DOC_SRL_NO,SEQ_NO ,ITEM_UNIT_COST,ITEM_COST_VALUE, STORE_CODE,TO_STORE_CODE, ITEM_DESC, BATCH_ID,ISSUE_FM_BIN_LOCATION_CODE,BIN_DESC, NEW_BIN_LOCATION_CODE, EXPIRY_RECEIPT_DT, TRADE_ID,TO_BIN_DESC,ISSUE_TO_BIN_LOCATION_CODE, BIN_LOCATION_CODE,   ISS_ITEM_QTY, ACK_ISSUE_QTY, ACK_RET_QTY, RET_ITEM_QTY, BATCH_QTY, BATCH_COMMT_QTY, (NVL (ack_issue_qty, iss_item_qty) - NVL (ret_item_qty, ack_ret_qty)) AVAIL_QTY, TRADE_NAME FROM (SELECT  HDR.DOC_TYPE_CODE DOC_TYPE_CODE, HDR.DOC_NO, HDR.FM_STORE_CODE STORE_CODE, HDR.TO_STORE_CODE, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DTL.DOC_SRL_NO, HDR.SEQ_NO, MM.SHORT_DESC ITEM_DESC, EXP.ITEM_CODE, EXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_ITEM_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY, SUM(ACK1.RECEIVED_QTY+ACK1.REJECTED_QTY) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_ITEM_QTY, 0 BATCH_QTY, 0 BATCH_COMMT_QTY, EXP.BATCH_ID, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, EXP.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, BIN.SHORT_DESC BIN_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, EXP.TRADE_ID, (CASE WHEN EXP.TO_BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = EXP.TO_BIN_LOCATION_CODE AND STORE_CODE = HDR.TO_STORE_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) END ) TO_BIN_DESC, EXP.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID) TRADE_NAME FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_FACILITY_PARAM STP, ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, MM_BIN_LOCATION_LANG_VW BIN, AM_TRADE_NAME_LANG_VW AM WHERE HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND DTL.DOC_SRL_NO = ?  AND HDR.FACILITY_ID = ? AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.ITEM_CODE = EXP.ITEM_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.FACILITY_ID = EXP.FACILITY_ID AND DTL.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID =? AND MM.LANGUAGE_ID = BIN.LANGUAGE_ID AND AM.LANGUAGE_ID(+) = ?   AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+) AND HDR.SEQ_NO = ? AND EXP.FACILITY_ID = STP.FACILITY_ID AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND  HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO  AND BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE AND BIN.STORE_CODE = HDR.FM_STORE_CODE AND EXP.TRADE_ID = AM.TRADE_ID(+) GROUP BY HDR.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, EXP.BATCH_ID, HDR.DOC_NO, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY'), DTL.DOC_SRL_NO, HDR.SEQ_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, MM.SHORT_DESC, EXP.BIN_LOCATION_CODE,EXP.BIN_LOCATION_CODE, BIN.SHORT_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY'), EXP.TRADE_ID, EXP.TO_BIN_LOCATION_CODE, MM.LANGUAGE_ID, EXP.TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID))) WHERE AVAIL_QTY > 0 ", alParameters);		
			
			//by ganga Thursday, March 15, 2012
	//		alRecords	=	fetchRecords("SELECT * FROM(SELECT DOC_NO,DOC_TYPE_CODE,DOC_DATE,ITEM_CODE, DOC_SRL_NO,SEQ_NO ,ITEM_UNIT_COST,ITEM_COST_VALUE, STORE_CODE,TO_STORE_CODE, ITEM_DESC, BATCH_ID,ISSUE_FM_BIN_LOCATION_CODE,BIN_DESC, NEW_BIN_LOCATION_CODE, EXPIRY_RECEIPT_DT, TRADE_ID,TO_BIN_DESC,ISSUE_TO_BIN_LOCATION_CODE, BIN_LOCATION_CODE,   ISS_ITEM_QTY, ACK_ISSUE_QTY, ACK_RET_QTY, RET_ITEM_QTY, BATCH_QTY, BATCH_COMMT_QTY, (CASE WHEN (NVL (ACK_ISSUE_QTY, ISS_ITEM_QTY) - NVL (RET_ITEM_QTY,ACK_RET_QTY)) <(BATCH_QTY - BATCH_COMMT_QTY ) THEN (NVL (ACK_ISSUE_QTY, ISS_ITEM_QTY) - NVL (RET_ITEM_QTY,ACK_RET_QTY)) ELSE BATCH_QTY - BATCH_COMMT_QTY END ) AVAIL_QTY, TRADE_NAME FROM (SELECT  HDR.DOC_TYPE_CODE DOC_TYPE_CODE, HDR.DOC_NO, HDR.FM_STORE_CODE STORE_CODE, HDR.TO_STORE_CODE, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DTL.DOC_SRL_NO, HDR.SEQ_NO, MM.SHORT_DESC ITEM_DESC, EXP.ITEM_CODE, EXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_ITEM_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY,  /*SUM (NVL (ACK1.RECEIVED_QTY,0)) ACK_RET_QTY*/ SUM(ACK1.RECEIVED_QTY+ACK1.REJECTED_QTY) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_ITEM_QTY, NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY, STB.BATCH_ID, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, EXP.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, BIN.SHORT_DESC BIN_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, EXP.TRADE_ID, (CASE WHEN EXP.TO_BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = EXP.TO_BIN_LOCATION_CODE AND STORE_CODE = HDR.TO_STORE_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) END ) TO_BIN_DESC, EXP.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID) TRADE_NAME FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_FACILITY_PARAM STP, ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB, ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, MM_BIN_LOCATION_LANG_VW BIN, AM_TRADE_NAME_LANG_VW AM WHERE HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND DTL.DOC_SRL_NO = ? AND HDR.FACILITY_ID = ? AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.ITEM_CODE = EXP.ITEM_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.FACILITY_ID = EXP.FACILITY_ID AND DTL.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID =? AND MM.LANGUAGE_ID = BIN.LANGUAGE_ID AND AM.LANGUAGE_ID(+) = ?   AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+) AND HDR.SEQ_NO = ? AND EXP.FACILITY_ID = STP.FACILITY_ID AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND STB.BATCH_ID(+) = EXP.BATCH_ID AND STB.TRADE_ID(+) = EXP.TRADE_ID AND STB.ITEM_CODE(+) = EXP.ITEM_CODE AND STB.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.bin_location_code(+) = EXP.to_bin_location_code AND HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO AND HDR.TO_STORE_CODE = STB.STORE_CODE AND BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE AND BIN.STORE_CODE = HDR.FM_STORE_CODE AND EXP.TRADE_ID = AM.TRADE_ID(+) GROUP BY HDR.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY,STB.QTY_ON_HAND, STB.COMMITTED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, STB.BATCH_ID, HDR.DOC_NO, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY'), DTL.DOC_SRL_NO, HDR.SEQ_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, MM.SHORT_DESC, EXP.BIN_LOCATION_CODE,EXP.BIN_LOCATION_CODE, BIN.SHORT_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY'), EXP.TRADE_ID, EXP.TO_BIN_LOCATION_CODE, MM.LANGUAGE_ID, EXP.TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID)) UNION  SELECT DOC_NO,DOC_TYPE_CODE,DOC_DATE,ITEM_CODE, DOC_SRL_NO,SEQ_NO ,ITEM_UNIT_COST,ITEM_COST_VALUE, STORE_CODE,TO_STORE_CODE, ITEM_DESC, BATCH_ID,ISSUE_FM_BIN_LOCATION_CODE,BIN_DESC, NEW_BIN_LOCATION_CODE, EXPIRY_RECEIPT_DT, TRADE_ID,TO_BIN_DESC,ISSUE_TO_BIN_LOCATION_CODE, BIN_LOCATION_CODE,   ISS_ITEM_QTY, ACK_ISSUE_QTY, ACK_RET_QTY, RET_ITEM_QTY, BATCH_QTY, BATCH_COMMT_QTY, (NVL (ack_issue_qty, iss_item_qty) - NVL (ret_item_qty, ack_ret_qty)) AVAIL_QTY, TRADE_NAME FROM (SELECT  HDR.DOC_TYPE_CODE DOC_TYPE_CODE, HDR.DOC_NO, HDR.FM_STORE_CODE STORE_CODE, HDR.TO_STORE_CODE, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DTL.DOC_SRL_NO, HDR.SEQ_NO, MM.SHORT_DESC ITEM_DESC, EXP.ITEM_CODE, EXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_ITEM_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY, SUM(ACK1.RECEIVED_QTY+ACK1.REJECTED_QTY) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_ITEM_QTY, 0 BATCH_QTY, 0 BATCH_COMMT_QTY, EXP.BATCH_ID, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, EXP.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, BIN.SHORT_DESC BIN_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, EXP.TRADE_ID, (CASE WHEN EXP.TO_BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = EXP.TO_BIN_LOCATION_CODE AND STORE_CODE = HDR.TO_STORE_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) END ) TO_BIN_DESC, EXP.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID) TRADE_NAME FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_FACILITY_PARAM STP, ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, MM_BIN_LOCATION_LANG_VW BIN, AM_TRADE_NAME_LANG_VW AM WHERE HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND DTL.DOC_SRL_NO = ?  AND HDR.FACILITY_ID = ? AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.ITEM_CODE = EXP.ITEM_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.FACILITY_ID = EXP.FACILITY_ID AND DTL.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID =? AND MM.LANGUAGE_ID = BIN.LANGUAGE_ID AND AM.LANGUAGE_ID(+) = ?   AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+) AND HDR.SEQ_NO = ? AND EXP.FACILITY_ID = STP.FACILITY_ID AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND  HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO  AND BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE AND BIN.STORE_CODE = HDR.FM_STORE_CODE AND EXP.TRADE_ID = AM.TRADE_ID(+) AND DTL.STOCK_ITEM_YN ='N' GROUP BY HDR.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, EXP.BATCH_ID, HDR.DOC_NO, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY'), DTL.DOC_SRL_NO, HDR.SEQ_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, MM.SHORT_DESC, EXP.BIN_LOCATION_CODE,EXP.BIN_LOCATION_CODE, BIN.SHORT_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY'), EXP.TRADE_ID, EXP.TO_BIN_LOCATION_CODE, MM.LANGUAGE_ID, EXP.TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE, NVL (AM.LONG_NAME, EXP.TRADE_ID))) WHERE AVAIL_QTY > 0 ", alParameters);//Added barcode against GHL-CRF-0413 
		//Modified against GHL-CRF-0413.3 -- added BARCODE_ID
			alRecords	=	fetchRecords("SELECT * FROM(SELECT DOC_NO,DOC_TYPE_CODE,DOC_DATE,ITEM_CODE, DOC_SRL_NO,SEQ_NO ,ITEM_UNIT_COST,ITEM_COST_VALUE, STORE_CODE,TO_STORE_CODE, ITEM_DESC, BATCH_ID,ISSUE_FM_BIN_LOCATION_CODE,BIN_DESC, NEW_BIN_LOCATION_CODE, EXPIRY_RECEIPT_DT, TRADE_ID,TO_BIN_DESC,ISSUE_TO_BIN_LOCATION_CODE, BIN_LOCATION_CODE,   ISS_ITEM_QTY, ACK_ISSUE_QTY, ACK_RET_QTY, RET_ITEM_QTY, BATCH_QTY, BATCH_COMMT_QTY, (CASE WHEN (NVL (ACK_ISSUE_QTY, ISS_ITEM_QTY) - NVL (RET_ITEM_QTY,ACK_RET_QTY)) <(BATCH_QTY - BATCH_COMMT_QTY ) THEN (NVL (ACK_ISSUE_QTY, ISS_ITEM_QTY) - NVL (RET_ITEM_QTY,ACK_RET_QTY)) ELSE BATCH_QTY - BATCH_COMMT_QTY END ) AVAIL_QTY,BARCODE_ID, TRADE_NAME FROM (SELECT  HDR.DOC_TYPE_CODE DOC_TYPE_CODE, HDR.DOC_NO, HDR.FM_STORE_CODE STORE_CODE, HDR.TO_STORE_CODE, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DTL.DOC_SRL_NO, HDR.SEQ_NO, MM.SHORT_DESC ITEM_DESC, EXP.ITEM_CODE, EXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_ITEM_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY,  /*SUM (NVL (ACK1.RECEIVED_QTY,0)) ACK_RET_QTY*/ SUM(ACK1.RECEIVED_QTY+ACK1.REJECTED_QTY) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_ITEM_QTY, NVL (STB.QTY_ON_HAND, 0) BATCH_QTY, NVL (STB.COMMITTED_QTY, 0) BATCH_COMMT_QTY, STB.BATCH_ID, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, EXP.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, BIN.SHORT_DESC BIN_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, EXP.TRADE_ID, (CASE WHEN EXP.TO_BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = EXP.TO_BIN_LOCATION_CODE AND STORE_CODE = HDR.TO_STORE_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) END ) TO_BIN_DESC, EXP.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE BIN_LOCATION_CODE,stb.BARCODE_ID BARCODE_ID, NVL (AM.LONG_NAME, EXP.TRADE_ID) TRADE_NAME FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_FACILITY_PARAM STP, ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ITEM_BATCH STB, ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, MM_BIN_LOCATION_LANG_VW BIN, AM_TRADE_NAME_LANG_VW AM WHERE HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND DTL.DOC_SRL_NO = ? AND HDR.FACILITY_ID = ? AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.ITEM_CODE = EXP.ITEM_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.FACILITY_ID = EXP.FACILITY_ID AND DTL.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID =? AND MM.LANGUAGE_ID = BIN.LANGUAGE_ID AND AM.LANGUAGE_ID(+) = ?   AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+) AND HDR.SEQ_NO = ? AND EXP.FACILITY_ID = STP.FACILITY_ID AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND STB.BATCH_ID(+) = EXP.BATCH_ID AND STB.TRADE_ID(+) = EXP.TRADE_ID AND STB.ITEM_CODE(+) = EXP.ITEM_CODE AND STB.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STB.bin_location_code(+) = EXP.to_bin_location_code AND HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO AND HDR.TO_STORE_CODE = STB.STORE_CODE AND BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE AND BIN.STORE_CODE = HDR.FM_STORE_CODE AND EXP.TRADE_ID = AM.TRADE_ID(+) GROUP BY HDR.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY,STB.QTY_ON_HAND, STB.COMMITTED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, STB.BATCH_ID, HDR.DOC_NO, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY'), DTL.DOC_SRL_NO, HDR.SEQ_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, MM.SHORT_DESC, EXP.BIN_LOCATION_CODE,EXP.BIN_LOCATION_CODE, BIN.SHORT_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY'), EXP.TRADE_ID, EXP.TO_BIN_LOCATION_CODE, MM.LANGUAGE_ID, EXP.TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE,  stb.barcode_id, NVL (AM.LONG_NAME, EXP.TRADE_ID)) UNION  SELECT DOC_NO,DOC_TYPE_CODE,DOC_DATE,ITEM_CODE, DOC_SRL_NO,SEQ_NO ,ITEM_UNIT_COST,ITEM_COST_VALUE, STORE_CODE,TO_STORE_CODE, ITEM_DESC, BATCH_ID,ISSUE_FM_BIN_LOCATION_CODE,BIN_DESC, NEW_BIN_LOCATION_CODE, EXPIRY_RECEIPT_DT, TRADE_ID,TO_BIN_DESC,ISSUE_TO_BIN_LOCATION_CODE, BIN_LOCATION_CODE,   ISS_ITEM_QTY, ACK_ISSUE_QTY, ACK_RET_QTY, RET_ITEM_QTY, BATCH_QTY, BATCH_COMMT_QTY, (NVL (ack_issue_qty, iss_item_qty) - NVL (ret_item_qty, ack_ret_qty)) AVAIL_QTY, BARCODE_ID,TRADE_NAME FROM (SELECT  HDR.DOC_TYPE_CODE DOC_TYPE_CODE, HDR.DOC_NO, HDR.FM_STORE_CODE STORE_CODE, HDR.TO_STORE_CODE, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, DTL.DOC_SRL_NO, HDR.SEQ_NO, MM.SHORT_DESC ITEM_DESC, EXP.ITEM_CODE, EXP.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, NVL (EXP.ISS_ITEM_QTY, 0) ISS_ITEM_QTY, ACK.RECEIVED_QTY ACK_ISSUE_QTY, SUM(ACK1.RECEIVED_QTY+ACK1.REJECTED_QTY) ACK_RET_QTY, SUM (NVL (RET_EXP.ITEM_QTY, 0)) RET_ITEM_QTY, 0 BATCH_QTY, 0 BATCH_COMMT_QTY, EXP.BATCH_ID, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, EXP.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, BIN.SHORT_DESC BIN_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, EXP.TRADE_ID, (CASE WHEN EXP.TO_BIN_LOCATION_CODE IS NULL THEN NULL ELSE (SELECT SHORT_DESC FROM MM_BIN_LOCATION_LANG_VW WHERE BIN_LOCATION_CODE = EXP.TO_BIN_LOCATION_CODE AND STORE_CODE = HDR.TO_STORE_CODE AND LANGUAGE_ID = MM.LANGUAGE_ID) END ) TO_BIN_DESC, EXP.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE BIN_LOCATION_CODE,exp.BARCODE_ID, NVL (AM.LONG_NAME, EXP.TRADE_ID) TRADE_NAME FROM ST_ISSUE_DTL_EXP EXP, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_FACILITY_PARAM STP, ST_ISSUE_RET_DTL_EXP RET_EXP, ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_HDR HDR, ST_ISSUE_DTL DTL, MM_ITEM_LANG_VW MM, MM_BIN_LOCATION_LANG_VW BIN, AM_TRADE_NAME_LANG_VW AM WHERE HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND DTL.DOC_SRL_NO = ?  AND HDR.FACILITY_ID = ? AND HDR.SEQ_NO = DTL.SEQ_NO AND HDR.DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND HDR.DOC_NO = DTL.DOC_NO AND HDR.FACILITY_ID = DTL.FACILITY_ID AND DTL.ITEM_CODE = EXP.ITEM_CODE AND DTL.SEQ_NO = EXP.SEQ_NO AND DTL.DOC_SRL_NO = EXP.DOC_SRL_NO AND DTL.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND DTL.FACILITY_ID = EXP.FACILITY_ID AND DTL.ITEM_CODE = MM.ITEM_CODE AND MM.LANGUAGE_ID =? AND MM.LANGUAGE_ID = BIN.LANGUAGE_ID AND AM.LANGUAGE_ID(+) = ?   AND EXP.FACILITY_ID = ACK.FACILITY_ID(+) AND EXP.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE(+) AND EXP.DOC_NO = ACK.DOC_NO(+) AND EXP.SEQ_NO = ACK.SEQ_NO(+) AND EXP.DOC_SRL_NO = ACK.DOC_SRL_NO(+) AND EXP.ITEM_CODE = ACK.ITEM_CODE(+) AND EXP.BATCH_ID = ACK.BATCH_ID(+) AND EXP.BIN_LOCATION_CODE = ACK.BIN_LOCATION_CODE(+) AND EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND EXP.TRADE_ID = ACK.TRADE_ID(+) AND HDR.SEQ_NO = ? AND EXP.FACILITY_ID = STP.FACILITY_ID AND RET_EXP.ORG_DOC_NO(+) = EXP.DOC_NO AND RET_EXP.ORG_DOC_TYPE_CODE(+) = EXP.DOC_TYPE_CODE AND RET_EXP.ORG_SEQ_NO(+) = EXP.SEQ_NO AND RET_EXP.ITEM_CODE(+) = EXP.ITEM_CODE AND RET_EXP.BATCH_ID(+) = EXP.BATCH_ID AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = EXP.EXPIRY_DATE_OR_RECEIPT_DATE AND RET_EXP.TRADE_ID(+) = EXP.TRADE_ID AND RET_EXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RET_EXP.DOC_NO = ACK1.DOC_NO(+) AND RET_EXP.DOC_SRL_NO = ACK1.DOC_SRL_NO(+) AND RET_EXP.ITEM_CODE = ACK1.ITEM_CODE(+) AND RET_EXP.BATCH_ID = ACK1.BATCH_ID(+) AND RET_EXP.BIN_LOCATION_CODE = ACK1.BIN_LOCATION_CODE(+) AND RET_EXP.EXPIRY_DATE_OR_RECEIPT_DATE = ACK1.EXPIRY_DATE_OR_RECEIPT_DATE(+) AND RET_EXP.TRADE_ID = ACK1.TRADE_ID(+) AND  HDR.FACILITY_ID = EXP.FACILITY_ID AND HDR.DOC_TYPE_CODE = EXP.DOC_TYPE_CODE AND HDR.DOC_NO = EXP.DOC_NO AND HDR.SEQ_NO = EXP.SEQ_NO  AND BIN.BIN_LOCATION_CODE = EXP.BIN_LOCATION_CODE AND BIN.STORE_CODE = HDR.FM_STORE_CODE AND EXP.TRADE_ID = AM.TRADE_ID(+) AND DTL.STOCK_ITEM_YN ='N' GROUP BY HDR.DOC_TYPE_CODE, EXP.STORE_CODE, EXP.ITEM_CODE, EXP.ISS_ITEM_QTY, ACK.RECEIVED_QTY, HDR.FM_STORE_CODE, HDR.TO_STORE_CODE, EXP.BATCH_ID, HDR.DOC_NO, TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY'), DTL.DOC_SRL_NO, HDR.SEQ_NO, DTL.ITEM_UNIT_COST, DTL.ITEM_COST_VALUE, MM.SHORT_DESC, EXP.BIN_LOCATION_CODE,EXP.BIN_LOCATION_CODE, BIN.SHORT_DESC, TO_CHAR (EXP.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY'), EXP.TRADE_ID, EXP.TO_BIN_LOCATION_CODE, MM.LANGUAGE_ID, EXP.TO_BIN_LOCATION_CODE, EXP.TO_BIN_LOCATION_CODE, exp.BARCODE_ID, NVL (AM.LONG_NAME, EXP.TRADE_ID))) WHERE AVAIL_QTY > 0 ", alParameters);
			

			hmExpRecords.put(i+"",alRecords);
			hmRecord.put("batch_records",""+alRecords.size());
			
			alDtlRecords.set(i,hmRecord);

           System.out.println("alParameters===2116==>" +alParameters);
		   System.out.println("hmExpRecords===2117==>" +hmExpRecords);


// ===== Start of Min Max details while loading details in Query mode
			HashMap hmMinMaxRecord1	=	new HashMap();
			HashMap hmMinMaxRecord2	=	new HashMap();
			hmMinMaxRecord1 = getMinMaxdetails((String)hmRecord.get("item_code"),getFrom_store_code());

			double available_qty1=Double.parseDouble((String)hmMinMaxRecord1.get("AVAILABLE_QTY"));
			double q = Double.parseDouble((String)hmRecord.get("item_qty"))+ available_qty1;
			if (hmMinMaxRecord1!= null  )
			{
				hmMinMaxRecord2.put("frm_store_qty_on_hand",""+q );   // Availabe Qty has to be taken based on document no without commited qty , hmMinMaxRecord.get("QTY_ON_HAND") will not give doc no based available qty
				hmMinMaxRecord2.put("frm_store_min_stk_level",checkForNull((String)hmMinMaxRecord1.get("MIN_STK_QTY"),""));
				hmMinMaxRecord2.put("frm_store_max_stk_level",checkForNull((String)hmMinMaxRecord1.get("MAX_STK_QTY"),""));
				hmMinMaxRecord2.put("frm_store_reorder_level",checkForNull((String)hmMinMaxRecord1.get("REORDER_LEVEL"),""));
			}
			hmMinMaxRecord1.clear();
			hmMinMaxRecord1 = getMinMaxdetails((String)hmRecord.get("item_code"),getTo_store_code());

			if (hmMinMaxRecord1!= null  )
			{
				hmMinMaxRecord2.put("to_store_qty_on_hand",checkForNull((String)hmMinMaxRecord1.get("QTY_ON_HAND"),"0"));
				hmMinMaxRecord2.put("to_store_min_stk_level",checkForNull((String)hmMinMaxRecord1.get("MIN_STK_QTY"),""));
				hmMinMaxRecord2.put("to_store_max_stk_level",checkForNull((String)hmMinMaxRecord1.get("MAX_STK_QTY"),""));
				hmMinMaxRecord2.put("to_store_reorder_level",checkForNull((String)hmMinMaxRecord1.get("REORDER_LEVEL"),""));
			}
			alMinMaxRecords.add(hmMinMaxRecord2); 

			// ===== End of Min Max details while loading details in Query mode

		  }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void clearAlDtlRecords(){
		alDtlRecords = new ArrayList();
	}
	public Boolean getAckReqd(){
		String ack_reqd = "N";
		String ack_facility_reqd = "N";
		String ack_facility_id  = "";
		try{
			//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 13-AUG-2013 Starts
			ack_facility_id =  (String)fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT"),getTo_store_code()).get("FACILITY_ID");
			//ack_facility_reqd = (String)fetchRecord("SELECT RET_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("RET_ACK_REQ_YN");
			ack_facility_reqd = (String)fetchRecord("SELECT RET_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", ack_facility_id).get("RET_ACK_REQ_YN");
			
			if(ack_facility_reqd.equals("Y")){
			ack_reqd = (String)fetchRecord("SELECT RET_ACK_REQ_YN FROM ST_STORE WHERE STORE_CODE = ?", getTo_store_code()).get("RET_ACK_REQ_YN");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}

public HashMap modifiedTableData(HashMap hmTableData,String trn_type){
		String item_class_code = "";
		int records_per_trn = getRecordsPerTrn(trn_type);
		ArrayList<Integer> alCount =  new ArrayList<Integer>();
		HashMap<String,String> hmTempData = new HashMap<String,String>();
		HashMap<String,String> hmTempExpData = new HashMap<String,String>();
		ArrayList<HashMap> alNewTempDtlData = new ArrayList<HashMap>();
		ArrayList<HashMap> alNewTempDtlExpData = new ArrayList<HashMap>();
		ArrayList<String> alItemClassData = new ArrayList<String>();
		ArrayList<String> alNewItemClassData = new ArrayList<String>();
		ArrayList<HashMap> alItemDtlData = (ArrayList<HashMap>)hmTableData.get("DtlInsertData");
		ArrayList<HashMap> alItemDtlExpData = (ArrayList<HashMap>)hmTableData.get("ExpInsertData");
		ArrayList<ArrayList> alNewItemHdrData = new ArrayList<ArrayList>();//hmTableData.get("InsertHDRData");
		ArrayList<String> alItemHdrData = (ArrayList<String>)hmTableData.get("HdrInsertData");
		for(int i=0;i<alItemDtlData.size();i++){
			hmTempData = (HashMap<String,String>)alItemDtlData.get(i);
			try{
				item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",hmTempData.get("item_code")).get("ITEM_CLASS_CODE");
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
				hmTempData = new HashMap<String,String>();
				hmTempData = alItemDtlData.get(j);
				//hmTempExpData = (HashMap<String,String>)alItemDtlExpData.get(j);
				try{
					item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",hmTempData.get("item_code")).get("ITEM_CLASS_CODE");
					if(item_class_code.equals(alItemClassData.get(i))){
						//++count;
						if(k>=records_per_trn){
							alCount.add(k);
							k = 0;
							alNewItemClassData.add(item_class_code);
						}
						hmTempData.put("doc_srl_no",""+ (++k));
						alNewTempDtlData.add(alItemDtlData.get(j));
						for(int m=0;m<alItemDtlExpData.size();m++){
							hmTempExpData = new HashMap<String,String>();
							hmTempExpData = alItemDtlExpData.get(m);
							if((hmTempExpData.get("ITEM_CODE")).equals(hmTempData.get("item_code"))){
								hmTempExpData.put("doc_srl_no",""+k);
								alNewTempDtlExpData.add(alItemDtlExpData.get(m));
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
			alTemp.set(17,alNewItemClassData.get(i));
			alNewItemHdrData.add(alTemp);
		}
		//hmTableData.put("InsertDTLData",alNewTempDtlData);
		hmTableData.put("HdrInsertData",alNewItemHdrData);
		hmTableData.put("DtlInsertData",alNewTempDtlData);
		hmTableData.put("ExpInsertData",alNewTempDtlExpData);
		hmTableData.put("ItemClassCount",alCount);
		hmTableData.put("ItemClass",alNewItemClassData);
		hmTableData.put("ITEM_CLASS_BASED","Y");
		return hmTableData;
	}
/**/
	public HashMap<String,String> getConvFactTemp(String item_code,String fm_store_code,String to_store_code,String issue_uom){
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
		conv_factors.put("BATCH_QTY_MULTIPLES",""+common_lcm);
		conv_factors.put("ISSUE_UOM_MULTIPLES",""+issue_uom_multiple);
		return conv_factors;
	}
	 //Added by Ganga against inc no:31625 on 08/03/2012
	public ArrayList getRejectedQty(String doc_no,String doc_type_code,String facility_id) throws Exception {
		String chkdefaultParameters[] = {doc_no,doc_type_code,facility_id};
		ArrayList RejectedQty			  = new ArrayList();
		try{
		RejectedQty = fetchRecords("select sum(nvl(c.rejected_qty,0))rejected_qty,a.doc_no,a.doc_type_code,a.item_code,a.batch_id,to_char(a.expiry_date_or_receipt_date,'dd/mm/yyyy')expiry_date_or_receipt_date,a.bin_location_code,a.trade_id from st_issue_dtl_exp a , st_acknowledge_trn_dtl c where  a.doc_no = c.doc_no(+)  AND a.doc_type_code = c.doc_type_code(+)  AND a.batch_id = c.batch_id(+) AND a.expiry_date_or_receipt_date = c.expiry_date_or_receipt_date(+)  AND a.doc_srl_no = c.doc_srl_no(+)  AND a.BIN_LOCATION_CODE = c.bin_location_code(+)  and a.doc_no = ? and a.doc_type_code = ? AND a.facility_id= ?    group by   a.doc_no,a.doc_type_code,a.item_code,a.batch_id,a.expiry_date_or_receipt_date,a.bin_location_code,a.trade_id",chkdefaultParameters);
		System.out.println("RejectedQty==>"+RejectedQty);
		}catch(Exception e){
		e.printStackTrace();
		}
		return RejectedQty;
	}


//Added by Sakti against inc no:50521 on 28/08/2014 to take max return qty from sum of avail_qty from batch search query
	public String getMaxReturnableQty(String facility_id,String to_store_code,String fm_store_code,String item_code,String doc_no){
		 
		String chkdefaultParameters[]	= {facility_id,to_store_code,fm_store_code,item_code,getLanguageId(),getLanguageId(),getLanguageId(),doc_no};
		String result					=	"";
		HashMap hmRecord				= new HashMap();
		try{
			if(getMode().equals("2")){
			hmRecord = fetchRecord("select sum(avail_qty) avail_qty from(SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, (ISS_ITEM_QTY- RET_ITEM_QTY) + AVAIL_QTY1 AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE, IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, NVL(RETEXP.ITEM_QTY,0) AVAIL_QTY1, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) + NVL(RETEXP.ITEM_QTY,0) ) > 0 AND ((NVL (ide.iss_item_qty, 0) - NVL (ide.ret_item_qty, 0)) + NVL(RETEXP.ITEM_QTY,0)) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND (IHR.FINALIZED_YN = 'Y' OR (ihr.process_for_acknowledge = 'Y' AND NVL(ACK.RECEIVED_QTY,0)>0)) AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ?  AND RETEXP.DOC_NO(+) = ?  AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND retexp.batch_id(+) = ide.batch_id AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.TO_BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, AVAIL_QTY1, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY ORDER BY DOC_NO,SEQ_NO,BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC)",chkdefaultParameters);
			}else{
				String defaultParameters[]	= {facility_id,to_store_code,fm_store_code,item_code,getLanguageId(),getLanguageId(),getLanguageId()};
				hmRecord = fetchRecord("select sum(avail_qty) avail_qty from(SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, (ISS_ITEM_QTY- RET_ITEM_QTY) AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE, IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) ) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND (IHR.FINALIZED_YN = 'Y' OR (ihr.process_for_acknowledge = 'Y' AND NVL(ACK.RECEIVED_QTY,0)>0)) AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ?  AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND retexp.batch_id(+) = ide.batch_id AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY ORDER BY DOC_NO,SEQ_NO,BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC)",defaultParameters);	
			}
			result = (String)hmRecord.get("AVAIL_QTY");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	//Added ends
	//Added against GHL-CRF-0413 starts
	public ArrayList getBatchExpRecords(String seq_no,String valid_store_code,String valid_to_store,String newItemCode,String  valid_trn_type)  throws Exception{
		ArrayList alParameters=new ArrayList();
		ArrayList facParameters = new ArrayList();
		String facility_new="";
		facParameters.add(getIssueDocNo());
			facParameters.add(issue_doc_type_code);
			facParameters.add(seq_no);
			ArrayList alRecords	=null;
			System.out.println("facParameters....."+facParameters);
			facility_new  = (String)((HashMap)fetchRecord("Select FACILITY_ID  from st_issue_hdr a where a.DOC_NO = ? and a.DOC_TYPE_CODE = ? and a.SEQ_NO = ?  ",facParameters)).get("FACILITY_ID");
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(valid_trn_type);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(valid_trn_type);
        alParameters.add(facility_new);
        alParameters.add(valid_to_store);
		alParameters.add(valid_store_code);
        alParameters.add(newItemCode);
        alParameters.add(getLanguageId());
        alParameters.add(getLanguageId());
      try {
    	  	alParameters.add(getLanguageId());
	        alParameters.add(getIssueDocNo());
			alParameters.add(issue_doc_type_code);
			alParameters.add(seq_no);
					System.out.println("alParameters....."+alParameters);
		alRecords=fetchRecords("SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, LEAST((ISS_ITEM_QTY- RET_ITEM_QTY),BATCH_QTY) + AVAIL_QTY1 AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO , BARCODE_ID FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE,  NVL(IDE.TO_BIN_LOCATION_CODE,'') ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, ST_COMM_QTY_FOR_DOCNO (?, ?,?, ?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE, IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) AVAIL_QTY1, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY,SBV.BARCODE_ID BARCODE_ID FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) + ST_COMM_QTY_FOR_DOCNO (?,?, ?, ?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE, IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) ) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? AND IDE.SEQ_NO = ? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, AVAIL_QTY1, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY,BARCODE_ID ORDER BY BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC",alParameters);//Modified for TFS ID:13356
		alTempExpRecords = new ArrayList(alRecords);
		} catch ( Exception e )	{ 
			e.printStackTrace() ;
			throw e ;
		} 
		return alRecords;
	}
	public ArrayList getAlTempExpRecords() {
		return alTempExpRecords;
	}
	public void setAlTempExpRecords(ArrayList alTempExpRecords) {
		this.alTempExpRecords = alTempExpRecords;
	}
}
//Added against GHL-CRF-0413  ends