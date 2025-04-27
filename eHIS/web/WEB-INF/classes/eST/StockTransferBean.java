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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.StringTokenizer;
import eST.StockTransfer.*;
import java.sql.Connection;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//port javax.servlet.http.HttpServletRequest;
//port javax.servlet.http.HttpServletResponse;
import javax.servlet.* ;
import javax.servlet.http.*;

public class StockTransferBean  extends eST.Common.StDuoHeaderBean implements Serializable{


	private String authorized_by_id;
	private String finalized_yn;
	private String records_to_delete;
	private String defaultDocType;

	private ArrayList PDocNo = new ArrayList();
	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
	private String stReportid = null;

	private HashMap		hmExpRecords;
	private ArrayList	alDtlRecords;
	private int doc_srl_no	=	0;
	public String reportserver = "";
	public String report_connect_string = "";
	public String acc_entity_id = "";
	private ArrayList	alMinMaxRecords=new ArrayList();
	
	private double	tmpConv			=	1;
	private double	frm_tmp_conv	=	1;
	private HashMap barcodeBatch =new HashMap();//Added for MOHE-CRF-0167
   // private HttpServletRequest request;
   // private HttpServletResponse response;

//Modified on 23/12
	public void initialize(){
		super.initialize();
		System.out.println("StockTransferBean initialize");
		hmExpRecords=new HashMap();
		alDtlRecords=new ArrayList();
		authorized_by_id=""; 
		finalized_yn="N";     
		records_to_delete="";
		defaultDocType = "";
		alMinMaxRecords=new ArrayList();

	}
// ended...
	public void  clear(){

		super.clear();
		System.out.println("StockTransferBean clear");
		hmExpRecords=null;  
		alDtlRecords=null;
		alMinMaxRecords=null;
		doc_srl_no	=	0;
		authorized_by_id=null; 
		finalized_yn=null;     
		records_to_delete=null;
		defaultDocType = null;
	}
  /*  public void setReFamily(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse) {
        request = httpservletrequest;
        response = httpservletresponse;
    }*/
	

	public void setTempConvFact(double tmpConv){
		this.tmpConv=tmpConv;
	}
	public double getTempConvFact(){
		return tmpConv;
	}
	public void setFromTempConvFact(double frm_tmp_conv){
		this.frm_tmp_conv=frm_tmp_conv;
	}
	public double getFromTempConvFact(){
		return frm_tmp_conv;
	}
	public void setAuthorized_by_id(String authorized_by_id) {
		 this.authorized_by_id= authorized_by_id;
	}

	public String getAuthorized_by_id( ) {
		 return authorized_by_id;
	}

	public void setFinalized_yn(String finalized_yn) {
		 this.finalized_yn= finalized_yn;
	}

	public String getFinalized_yn( ) {
		 return finalized_yn;
	}

	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete= records_to_delete;
	}

	public String getRecords_to_delete( ) {
		 return records_to_delete;
	}

	public int getNextDoc_srl_no(){
		return ++doc_srl_no;
	}

	public int getDoc_srl_no(){
		return doc_srl_no;
	}

	public void setDoc_srl_no(String doc_srl_no){
		this.doc_srl_no=Integer.parseInt(doc_srl_no);
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

	public void setBarcodeData( HashMap batch_data) {//Adding start for MOHE-CRF-0167
		this.barcodeBatch = batch_data;
	}
	public HashMap getBarcodeData() {
		return barcodeBatch;
	}//Adding end for MOHE-CRF-0167
		/* Default List value population methods*/
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}

	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("TFR",defaultDocType);
	}

	
		public String getFromStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_QRY_ST_STOCK_TFR_FROM_STORE");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getFrom_store_code());
	}

	public String getToStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_QRY_ST_STOCK_TO_STORE");
		java.util.ArrayList sqlParam = new java.util.ArrayList (3);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLoginById());
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
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(getLanguageId());
		//sqlParam.add(getTo_store_code());
		String sql = eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST");
		return getListValues(sql,sqlParam,"");
	}

	String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}

//end 
	public ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
		ArrayList result = new ArrayList();
		
			String chkParameters[] = {request_on_store,request_by_store,getLanguageId()};
			//result = fetchRecords("SELECT stp.item_class_code, mm.short_desc FROM st_store_parent_store stp, mm_item_class_lang_vw mm WHERE mm.item_class_code = stp.item_class_code AND stp.store_code =? AND stp.parent_store_code =? AND stp.eff_status = 'E'  AND language_id =?",chkParameters);
			result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);
			
       
        return result;
	}
	public String getStock_item_yn(String item_code, String store_code) throws Exception{
		return (String)fetchRecord(getStRepositoryValue("SQL_ST_ITEM_STORE_SELECT_FOR_GRN"),new String[]{item_code, store_code}).get("STOCK_ITEM_YN");
	}


	public void updateDtlRecord(int index, HashMap hmDtlRecord){
		String mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
		if (index!=-1){
			mode	=	(String)((HashMap)alDtlRecords.get(index)).get("mode");
		}
		hmDtlRecord.put("mode",mode);
		
		if (index==-1){
			hmDtlRecord.put("doc_srl_no",""+getNextDoc_srl_no());
//			mode	=	eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
			alDtlRecords.add(hmDtlRecord);
		}
		else
			alDtlRecords.set(index, hmDtlRecord);
	}

	public HashMap getDtlRecord(int index){
		return (HashMap)alDtlRecords.get(index);
	}

	public ArrayList getDtlRecords(){
		return alDtlRecords;
	}
	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getPrintDocNo(){
		return PDocNo;
	}

	public void updateExpRecords(int index, Hashtable htExpRecords){

		if (index==-1) {
			index	=	alDtlRecords.size()-1;
		}


		ArrayList alExpRecords	=	(ArrayList)hmExpRecords.get(""+index);
		for (int i=0;i<alExpRecords.size(); i++) {

			HashMap hmExpRecord	=	(HashMap)alExpRecords.get(i);
			hmExpRecord.put("TO_BIN_LOCATION_CODE",	htExpRecords.get("to_bin_location_code_"+i));
			hmExpRecord.put("QTY",	htExpRecords.get("item_qty_"+i));
		}
		ArrayList MyList =new ArrayList();
		HashMap hmAldtlData = (HashMap)alDtlRecords.get(index);
		int batch_records = Integer.parseInt((String)hmAldtlData.get("batch_records"));

		for(int i=0;i<alExpRecords.size(); i++){
			if( ! ((String)((HashMap)alExpRecords.get(i)).get("QTY")).equals("")   ){
				MyList.add(alExpRecords.get(i));
			}else
				--batch_records;
		}
		alExpRecords=MyList;

		hmAldtlData.put("batch_records",""+batch_records);
		alDtlRecords.set(index,hmAldtlData);

		setExpRecords(index, alExpRecords);
	}

	public void setExpRecords(int index, ArrayList alExpRecords){
		if (index==-1) {
			index	=	alDtlRecords.size();

		}
		
		hmExpRecords.put(""+index,alExpRecords);

	}
	
	public ArrayList getExpRecords(int index){

		return (ArrayList)hmExpRecords.get(""+index);
	}

	public HashMap getExpRecords(){

		return hmExpRecords;
	}
	public void updateMinMaxRecords(int index, HashMap hmMinMaxRecord){        // Min Max Validation by Rammohan.C 11/30/2006
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

	public String getBin_location_code_List(String store_code, String bin_location_code){
		ArrayList arr_language=new ArrayList();
		arr_language.add(store_code);
		arr_language.add(getLanguageId());
		return 		getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),arr_language),bin_location_code);
	}



	public String getDefaultBinLocationCode(String store_code,String item_code){
		String def_Bin_Loc="";
		String []stParameters={store_code,item_code};
		try {
			HashMap hmRecord = new HashMap();
			hmRecord=	fetchRecord(getStRepositoryValue("SQL_ST_DEF_TO_STORE_TO_BIN"), stParameters);
			if (hmRecord != null &&hmRecord.size() >0 )
			{
				def_Bin_Loc		=	(String)hmRecord.get("BIN_LOCATION_CODE");
			}
		
			//HashMap defltbin=new HashMap();
			//HashMap=fetchRecord(getStRepositoryValue("SQL_ST_DEF_TO_STORE_TO_BIN"),stParameters);
			//def_Bin_Loc=(String)defltbin.get("BIN_LOCATION_CODE");
		}
		catch(Exception e){
			e.printStackTrace();
			def_Bin_Loc="";
		}
		return def_Bin_Loc;
	}

	

	public void setAll(Hashtable hashtable) {
		
		setDoc_type_code((String)hashtable.get("doc_type_code"));  
		setDoc_no((String)hashtable.get("doc_no"));  
		setDoc_ref((String)hashtable.get("doc_ref"));  
		setItem_class_code((String)hashtable.get("item_class_code"));  
		String mode=(String)hashtable.get("mode");
		if(mode.equals("2"))
		{
			setItem_class_code((String)hashtable.get("item_class_code1"));  
			
		}

		setDoc_date((String)hashtable.get("doc_date"));  
		setFrom_store_code((String)hashtable.get("from_store_code"));  
		setTo_store_code((String)hashtable.get("to_store_code"));  

		authorized_by_id =(String)hashtable.get("authorized_by_id");  
		finalized_yn     =(String)hashtable.get("finalize_yn");  
		records_to_delete=(String)hashtable.get("records_to_delete");  

		setRecords_to_delete_for_barcode(records_to_delete);//added for barcode
    }


	public HashMap validate(){
		/*processs detail records as required based on Records to be deleted var of dtl bean
		not required to process exp records..*/
 		return getMessageHashMap(true);	
	}

	
	public void loadData() throws Exception{
		ArrayList alParameters	=	new ArrayList(3);
		HashMap hmTempFactor = new HashMap();


		try{
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		
		HashMap hmRecord=	fetchRecord(getStRepositoryValue("SQL_ST_TRANSFER_DTL_SELECT_MAX_DOC_SRL_NO"), alParameters);

		doc_srl_no		=	Integer.parseInt((String)hmRecord.get("MAX_DOC_SRL_NO"));

		setNextDoc_srl_noforBarCode(doc_srl_no);
		
		alParameters.add(getLanguageId());
	
		hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_STOCK_TRANSFER_HDR_SELECT"), alParameters);

		setDoc_date((String)hmRecord.get ("DOC_DATE"));  
		setDoc_ref((String)hmRecord.get ("DOC_REF"));  
		setFrom_store_code((String)hmRecord.get("FM_STORE_CODE"));  
		setTo_store_code((String)hmRecord.get ("TO_STORE_CODE"));
		setItem_class_code((String)hmRecord.get ("ITEM_CLASS_CODE"));
	
		String no_deci = ""+getNoOfDecimals();
		alParameters.clear();
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getFrom_store_code());
		alParameters.add(getLanguageId());
		/*alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());*/
		
		
		//alParameters.add(getFrom_store_code());

		/*
		Query is Modifed By Rams For The Performance Engineering on 4/21/2010 


		*/
		//ArrayList alRecords	=	fetchRecords(" SELECT   dtl.doc_no, dtl.item_code,         (SELECT short_desc            FROM mm_item_lang_vw           WHERE item_code = dtl.item_code AND language_id =?) item_desc,         stitem.expiry_yn expiry_yn, dtl.doc_srl_no, item_qty,         stitem.sale_uom_code uom_code1, am.short_desc uom_desc,         (SUM (avail_qty) + item_qty) stock_available,         NVL(stitem.allow_decimals_yn,'N') allow_deci_yn, dtl.store_code,         dtl.stock_item_yn, stitem.reorder_level, stitem.min_stk_qty,         ROUND ((  DECODE (ststr.qty_on_hand, 0, 0, ststr.item_value)                 / DECODE (ststr.qty_on_hand, 0, 1, ststr.qty_on_hand) ), 3 ) unit_cost, ROUND (  (  DECODE (ststr.qty_on_hand, 0, 0, ststr.item_value)                   / DECODE (ststr.qty_on_hand, 0, 1, ststr.qty_on_hand)) * item_qty, 3) item_cost_value,         def_issue_uom uom_code   /*+index(st_batch_control,st_item_batch ) */   FROM st_transfer_dtl dtl, /* mm_item_lang_vw mmitem,*/  mm_item mmitem,st_item stitem,         am_uom_lang_vw am, st_batch_search_view bsview, st_item_store ststr WHERE dtl.facility_id =?   AND dtl.doc_type_code =? AND dtl.doc_no =? AND dtl.store_code = bsview.store_code  AND bsview.store_code = ? /*AND  mmitem.item_code = dtl.item_code*/ AND  mmitem.item_code=dtl.item_code AND stitem.item_code = dtl.item_code  AND ststr.def_issue_uom = am.uom_code(+)  AND dtl.item_code = bsview.item_code  AND dtl.item_code = ststr.item_code    AND dtl.store_code = ststr.store_code /*AND bsview.store_code = dtl.store_code AND mmitem.language_id = 'en'  --AND mmitem.language_id = bsview.language_id  AND DECODE (bsview.lang1, NULL, '', bsview.lang1) ='' AND DECODE (bsview.lang2, NULL, '', bsview.lang2) = ''*/ AND am.language_id(+) = ? GROUP BY dtl.doc_no,         dtl.item_code, /* mmitem.short_desc, */ stitem.expiry_yn,  dtl.doc_srl_no, item_qty,        stitem.sale_uom_code, am.short_desc, dtl.store_code, stitem.allow_decimals_yn,   dtl.stock_item_yn,         stitem.reorder_level, stitem.min_stk_qty, def_issue_uom,    ROUND ((  DECODE (ststr.qty_on_hand, 0, 0, ststr.item_value)/ DECODE (ststr.qty_on_hand, 0, 1, ststr.qty_on_hand)), 3 ),         ROUND (  (  DECODE (ststr.qty_on_hand, 0, 0, ststr.item_value)/ DECODE (ststr.qty_on_hand, 0, 1, ststr.qty_on_hand)                  )* item_qty, 3 )", alParameters);
		/**
		 * @Name - Priya
		 * @Date - 26/05/2010
		 * @Inc# - 
		 * @Desc -  To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' the above query is modified & To get no of decimals for cost and assign it to 'no_of_decimals_for_cost' hidden field 
		 */

		//ArrayList alRecords	=	fetchRecords(" SELECT   dtl.doc_no, dtl.item_code,         (SELECT short_desc            FROM mm_item_lang_vw           WHERE item_code = dtl.item_code AND language_id =?) item_desc,         stitem.expiry_yn expiry_yn, dtl.doc_srl_no, item_qty,         stitem.sale_uom_code uom_code1, am.short_desc uom_desc,         (SUM (avail_qty) + item_qty) stock_available,         NVL(stitem.allow_decimals_yn,'N') allow_deci_yn, dtl.store_code,         dtl.stock_item_yn, nvl(stitem.reorder_level,0) reorder_level, nvl(stitem.min_stk_qty,0) min_stk_qty ,         TRIM(ST_DISPLAY_COST_DECIMALS (dtl.item_code, dtl.store_code)) unit_cost, (TRIM(ST_DISPLAY_COST_DECIMALS (dtl.item_code, dtl.store_code)) * item_qty ) item_cost_value, def_issue_uom uom_code   /*+index(st_batch_control,st_item_batch ) */ ,dtl.usage_type  FROM st_transfer_dtl dtl, /* mm_item_lang_vw mmitem,*/  mm_item mmitem,st_item stitem,         am_uom_lang_vw am, st_batch_search_view bsview, st_item_store ststr WHERE dtl.facility_id =?   AND dtl.doc_type_code =? AND dtl.doc_no =? AND dtl.store_code = bsview.store_code  AND bsview.store_code = ? /*AND  mmitem.item_code = dtl.item_code*/ AND  mmitem.item_code=dtl.item_code AND stitem.item_code = dtl.item_code  AND ststr.def_issue_uom = am.uom_code(+)  AND dtl.item_code = bsview.item_code  AND dtl.item_code = ststr.item_code    AND dtl.store_code = ststr.store_code /*AND bsview.store_code = dtl.store_code AND mmitem.language_id = 'en'  --AND mmitem.language_id = bsview.language_id  AND DECODE (bsview.lang1, NULL, '', bsview.lang1) ='' AND DECODE (bsview.lang2, NULL, '', bsview.lang2) = ''*/ AND am.language_id(+) = ? GROUP BY dtl.doc_no,         dtl.item_code, /* mmitem.short_desc, */ stitem.expiry_yn,  dtl.doc_srl_no, item_qty,        stitem.sale_uom_code, am.short_desc, dtl.store_code, stitem.allow_decimals_yn,   dtl.stock_item_yn,  stitem.reorder_level, stitem.min_stk_qty, def_issue_uom,dtl.usage_type order by dtl.doc_srl_no ", alParameters);
		//Modified by suresh.r on 11-08-2014 against Inc #50521
		//Modified by suresh.r on 13-11-2014 against Inc 52256(Added 2 args to ST_DISPLAY_UNIT_COST)
		ArrayList alRecords	=	fetchRecords(" SELECT   dtl.doc_no, dtl.item_code,         (SELECT short_desc            FROM mm_item_lang_vw           WHERE item_code = dtl.item_code AND language_id =?) item_desc,         stitem.expiry_yn expiry_yn, dtl.doc_srl_no, item_qty,         stitem.sale_uom_code uom_code1, am.short_desc uom_desc,         (SUM (avail_qty) + item_qty) stock_available,         NVL(stitem.allow_decimals_yn,'N') allow_deci_yn, dtl.store_code,         dtl.stock_item_yn, nvl(stitem.reorder_level,0) reorder_level, nvl(stitem.min_stk_qty,0) min_stk_qty ,         TRIM(st_display_unit_cost (dtl.item_code,SYSDATE,'CURRENT_STOCK')*st_get_uom_conv_fac_sing_str(dtl.item_code, dtl.store_code)) unit_cost, (TRIM(st_display_unit_cost (dtl.item_code,SYSDATE,'CURRENT_STOCK')*st_get_uom_conv_fac_sing_str(dtl.item_code, dtl.store_code)) * item_qty ) item_cost_value, def_issue_uom uom_code   /*+index(st_batch_control,st_item_batch ) */ ,dtl.usage_type  FROM st_transfer_dtl dtl, /* mm_item_lang_vw mmitem,*/  mm_item mmitem,st_item stitem,         am_uom_lang_vw am, st_batch_search_view bsview, st_item_store ststr WHERE dtl.facility_id =?   AND dtl.doc_type_code =? AND dtl.doc_no =? AND dtl.store_code = bsview.store_code  AND bsview.store_code = ? /*AND  mmitem.item_code = dtl.item_code*/ AND  mmitem.item_code=dtl.item_code AND stitem.item_code = dtl.item_code  AND ststr.def_issue_uom = am.uom_code(+)  AND dtl.item_code = bsview.item_code  AND dtl.item_code = ststr.item_code    AND dtl.store_code = ststr.store_code /*AND bsview.store_code = dtl.store_code AND mmitem.language_id = 'en'  --AND mmitem.language_id = bsview.language_id  AND DECODE (bsview.lang1, NULL, '', bsview.lang1) ='' AND DECODE (bsview.lang2, NULL, '', bsview.lang2) = ''*/ AND am.language_id(+) = ? GROUP BY dtl.doc_no,         dtl.item_code, /* mmitem.short_desc, */ stitem.expiry_yn,  dtl.doc_srl_no, item_qty,        stitem.sale_uom_code, am.short_desc, dtl.store_code, stitem.allow_decimals_yn,   dtl.stock_item_yn,  stitem.reorder_level, stitem.min_stk_qty, def_issue_uom,dtl.usage_type order by dtl.doc_srl_no ", alParameters);
		int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
		for (int i=0; i<alRecords.size(); i++) {
			hmTempFactor = new HashMap();
			hmRecord	=	(HashMap)alRecords.get(i);
			System.out.println("hmRecord====440=>" +hmRecord);
			HashMap hmTemp	=	new HashMap();
			hmTemp.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"));
			hmTemp.put("item_code",hmRecord.get("ITEM_CODE"));
			hmTemp.put("item_desc",hmRecord.get("ITEM_DESC"));
			hmTemp.put("item_cost_value",setNumber((String)hmRecord.get("ITEM_COST_VALUE"),noOfDecimalsForCost));
			//hmTemp.put("item_unit_cost",hmRecord.get("UNIT_COST"));
			//Modified by suresh.r on 11-08-2014 against Inc #50521
			hmTemp.put("item_unit_cost",setNumber((String)hmRecord.get("UNIT_COST"),noOfDecimalsForCost));
			hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			hmTemp.put("doc_srl_no",hmRecord.get("DOC_SRL_NO"));
			hmTemp.put("stock_available",hmRecord.get("STOCK_AVAILABLE"));
			hmTemp.put("item_qty",hmRecord.get("ITEM_QTY"));
			hmTemp.put("uom_code",hmRecord.get("UOM_CODE"));
			hmTemp.put("uom_desc",hmRecord.get("UOM_DESC"));
			hmTemp.put("store_code",hmRecord.get("STORE_CODE"));
			hmTemp.put("stock_item_yn",hmRecord.get("STOCK_ITEM_YN"));
			hmTemp.put("allow_deci_yn",hmRecord.get("ALLOW_DECI_YN"));
			hmTemp.put("no_deci",no_deci);
			System.out.println("StockTransferBean==hmTemp"+hmTemp);
			if(((String)hmRecord.get("ALLOW_DECI_YN")).equals("N")){
				hmTempFactor = (HashMap)getConvFactTemp((String)hmRecord.get("ITEM_CODE"),getFrom_store_code(),getTo_store_code());
				hmTemp.put("from_multiples",(String)hmTempFactor.get("FROM_STORE_MULTIPLES"));
				hmTemp.put("to_multiples",(String)hmTempFactor.get("TO_STORE_MULTIPLES"));
				hmTemp.put("batch_multiples",(String)hmTempFactor.get("BATCH_QTY_MULTIPLES"));
				double toStrQty=(Double.parseDouble((String)hmTemp.get("item_qty"))/Double.parseDouble((String)hmTempFactor.get("FROM_STORE_MULTIPLES")))*Double.parseDouble((String)hmTempFactor.get("TO_STORE_MULTIPLES"));
				hmTemp.put("to_str_qty",""+toStrQty);
			}else{
				double toStrQty=((Double.parseDouble((String)hmTemp.get("item_qty")))*getFromTempConvFact())/(getTempConvFact());
				hmTemp.put("to_str_qty",""+toStrQty);
			}
			double FrmStrQty=((Double.parseDouble((String)hmTemp.get("stock_available")))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),getFrom_store_code()));
			hmTemp.put("frm_str_avl_qty",""+FrmStrQty);
//				alDtlData.add(hmDtlRecord); 

			//hmTemp.put("expiry_yn",hmRecord.get("EXPIRY_YN"));
			//hmTemp.put("nod",hmRecord.get("NOD"));


			if((Double.parseDouble((String)hmRecord.get("STOCK_AVAILABLE")) - Double.parseDouble((String)hmRecord.get("ITEM_QTY"))) < Integer.parseInt((String)hmRecord.get("REORDER_LEVEL")))
				hmTemp.put("ROL_YN", "Y"	);
			else
				hmTemp.put("ROL_YN", "N"	);
			
			if((Double.parseDouble((String)hmRecord.get("STOCK_AVAILABLE")) - Double.parseDouble((String)hmRecord.get("ITEM_QTY"))) < Integer.parseInt((String)hmRecord.get("MIN_STK_QTY")))
				hmTemp.put("Min_YN", "Y"	);
			else
				hmTemp.put("Min_YN", "N"	);

			String[] strParameters = new String[7];
			strParameters[0] = (String)hmRecord.get("ITEM_CODE");
			strParameters[1] = getFrom_store_code();
			strParameters[2] = "0"; 
			strParameters[3] = "N";
			strParameters[4] = "";
			strParameters[5] = "N";
			strParameters[6] = getTo_store_code();
			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(strParameters);
			//int qty = Integer.parseInt((String)hmMinMaxRecord1.get("AVAILABLE_QTY"))+Integer.parseInt(checkForNull(resultSet.getString("issue_uom_qty"),"0")); available_stock
			double avail_stock = Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))/getConvFactTemp((String)hmRecord.get("ITEM_CODE"),getFrom_store_code())+Double.parseDouble((String)hmRecord.get("ITEM_QTY"));
			hmTemp.put("stock_available",""+avail_stock);
			hmTemp.put("usage_type",checkForNull((String)hmRecord.get("USAGE_TYPE")));
            System.out.println("hmTemp=502====>" +hmTemp);
			alDtlRecords.add(hmTemp);
			setalDtlRecordsforBarCode(hmTemp);//added for barcode
			System.out.println("alDtlRecords=502====>" +alDtlRecords);

			/* ===== Start of Min Max details while loading details in Query mode*/
			HashMap hmMinMaxRecord1	=	new HashMap();
			HashMap hmMinMaxRecord2	=	new HashMap();
			hmMinMaxRecord1 = getMinMaxdetails((String)hmRecord.get("ITEM_CODE"),getFrom_store_code());
			//int qty = Integer.parseInt((String)hmMinMaxRecord1.get("AVAILABLE_QTY"))+Integer.parseInt((String)hmTemp.get("item_qty"));
			if (hmMinMaxRecord1!= null  )
			{
				hmMinMaxRecord2.put("frm_store_qty_on_hand",""+avail_stock);
				hmMinMaxRecord2.put("frm_store_min_stk_level",checkForNull((String)hmMinMaxRecord1.get("MIN_STK_QTY"),""));
				hmMinMaxRecord2.put("frm_store_max_stk_level",checkForNull((String)hmMinMaxRecord1.get("MAX_STK_QTY"),""));
				hmMinMaxRecord2.put("frm_store_reorder_level",checkForNull((String)hmMinMaxRecord1.get("REORDER_LEVEL"),""));
			}
			hmMinMaxRecord1.clear();
			hmMinMaxRecord1 = getMinMaxdetails((String)hmRecord.get("ITEM_CODE"),getTo_store_code());

			if (hmMinMaxRecord1!= null  )
			{
				hmMinMaxRecord2.put("to_store_qty_on_hand",checkForNull((String)hmMinMaxRecord1.get("QTY_ON_HAND"),"0"));
				hmMinMaxRecord2.put("to_store_min_stk_level",checkForNull((String)hmMinMaxRecord1.get("MIN_STK_QTY"),""));
				hmMinMaxRecord2.put("to_store_max_stk_level",checkForNull((String)hmMinMaxRecord1.get("MAX_STK_QTY"),""));
				hmMinMaxRecord2.put("to_store_reorder_level",checkForNull((String)hmMinMaxRecord1.get("REORDER_LEVEL"),""));
			}
			alMinMaxRecords.add(hmMinMaxRecord2); 
			setMinMaxRecordsforBarcode(hmMinMaxRecord2);




			/* ===== End of Min Max details while loading details in Query mode*/

		}
		
		alParameters.clear();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(getDoc_no());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		alParameters.add(getLanguageId());
		

          /*
		Query is Modifed By Rams For The Performance Engineering on 4/21/2010 

		Taken Out from the Loop For the Performence Engineering

           
		*/


        alRecords	=	fetchRecords("SELECT batchview.batch_status, batchview.trade_id, batchview.qty_on_hand,       batchview.use_after_expiry_yn, batchview.expiry_yn expiry_yn,       (batchview.avail_qty + stexp.item_qty) avail_qty,       batchview.trade_id_applicable_yn, batchview.manufacturer_id,       stexp.item_qty qty, batchview.store_desc, batchview.trade_name,       batchview.nod nod, batchview.item_desc, batchview.manufacturer_name,       batchview.store_code, batchview.suspended_yn, batchview.item_code,       batchview.bin_location_code, batchview.bin_desc,       stexp.to_bin_location_code, mm_bin.short_desc to_bin_desc,       TO_CHAR (batchview.expiry_date, 'dd/mm/yyyy') expiry_date,       batchview.batch_id /*+index(st_batch_control,st_item_batch ) */  FROM st_batch_search_lang_view batchview,       st_transfer_dtl_exp stexp,       mm_bin_location_lang_vw mm_bin WHERE stexp.facility_id = ?   AND stexp.doc_type_code =?   AND stexp.doc_no =?    AND batchview.store_code = stexp.store_code   AND batchview.item_code = stexp.item_code   AND batchview.batch_id = stexp.batch_id   AND batchview.bin_location_code = stexp.bin_location_code   AND batchview.expiry_date = stexp.expiry_date_or_receipt_date   AND stexp.store_code = mm_bin.store_code(+)   AND stexp.to_bin_location_code = mm_bin.bin_location_code(+)   AND mm_bin.language_id(+) = ?   AND batchview.language_id =?   AND batchview.lang1 = ?  AND batchview.lang2 =? ", alParameters);  

		ArrayList temp = new ArrayList();
		for (int i=0; i<alDtlRecords.size(); i++) {
			hmRecord	=	(HashMap)alDtlRecords.get(i);
			temp = new ArrayList();
			for(int j=0;j<alRecords.size();j++){
				HashMap dataList		=		(HashMap)alRecords.get(j);
				if(((String)hmRecord.get("item_code")).equals((String)dataList.get("ITEM_CODE"))){
					temp.add(alRecords.get(j));
					}
			}
		
		hmExpRecords.put(""+i,temp);
		setExpRecordsforBarCode(i,temp); // added for barcode
		
		}
		}
		catch(Exception exception){
		exception.printStackTrace();
		}
	}

	public HashMap insert(){

// 		HashMap hmResult=new HashMap();

		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();

		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alCommonData	=	new ArrayList();
		ArrayList allanguageData	=	new ArrayList();

		alCommonData.add(getLoginById()			);
		alCommonData.add(getLoginAtWsNo()		);
		alCommonData.add(getLoginFacilityId()	);
		alCommonData.add(getDoc_type_code());


		alHdrData.add(getLoginFacilityId()	);
		alHdrData.add(getDoc_type_code()	);
		alHdrData.add(getDoc_no()			);
//		alHdrData.add(getDoc_date());
		alHdrData.add(com.ehis.util.DateUtils.convertDate(getDoc_date(),"DMY",getLanguageId(),"en"));
		alHdrData.add(getDoc_ref()			);
		alHdrData.add(getFrom_store_code()	);
		alHdrData.add(getTo_store_code()	);
		if(getAckReqd()){
			alHdrData.add("N");//finalize
			alHdrData.add(getFinalized_yn().substring(0,1));//process for acknowledge
		}
		else{
			alHdrData.add(getFinalized_yn().substring(0,1));//finalize
			alHdrData.add("N");//process for acknowledge
		}
		alHdrData.add("N");
		alHdrData.add("TFR"); 
		alHdrData.add("Y"); //entry completed ?);
		alHdrData.add(getItem_class_code()	);
		alHdrData.add(getLoginById()		);
		alHdrData.add(getLoginAtWsNo()		);
		alHdrData.add(getLoginFacilityId()	);
		

		allanguageData.add(getLanguageId()	);
		try {


//alDtlRecords
			
			//StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");

			StringTokenizer stRecordsToDelete;

			if(getBarcodeApplicable().equals("Y")){				
			stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete_for_barcode(),",");
			System.out.println("StockTransferBean---if----"+getRecords_to_delete_for_barcode());

			}
			else{			
			stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");
			System.out.println("StockTransferBean---else----"+getRecords_to_delete());

			}

			int alDtlRecords_size = 0;

			if(getBarcodeApplicable().equals("Y")){

				ArrayList alDtl  = getDtlRecordsforBarCode();

				alDtlRecords_size	=	alDtl.size();
				System.out.println("StockTransferBean---if--alDtlRecords_size--"+alDtlRecords_size);
				}
			else{	
				alDtlRecords_size	=	alDtlRecords.size();
				System.out.println("StockTransferBean---else--alDtlRecords_size--"+alDtlRecords_size);
			}




			for (int i=0;i<alDtlRecords_size;i++) {

				System.out.println("StockTransferBean-643-"+getBarcodeApplicable());

				String nextToken = stRecordsToDelete.nextToken();
				
				//HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);

				HashMap hmDtlRecord	= null;

				if(getBarcodeApplicable().equals("Y")){
				hmDtlRecord	=	getDtlRecordforBarCode(i);
				System.out.println("StockTransferBean---if--hmDtlRecord--"+hmDtlRecord);
				}
				else{	
				hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				System.out.println("StockTransferBean---else--hmDtlRecord--"+hmDtlRecord);
				}



				hmDtlRecord.put("store_code",getFrom_store_code());
				hmDtlRecord.put("stock_item_yn","Y");
				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					//ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);

					ArrayList sourceArrayList = null;

				if(getBarcodeApplicable().equals("Y")){
				sourceArrayList	=	getExpRecordsforBarCode(i);
				System.out.println("StockTransferBean---if--sourceArrayList--"+sourceArrayList);
				}
				else{	
				sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
				System.out.println("StockTransferBean---else--sourceArrayList--"+sourceArrayList);
				}
				//Added by suresh.r on 11-08-2014 against Inc #50521 beg
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
				String unit_cost=setNumber(""+(Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))/getConvFactTemp((String)hmDtlRecord.get("item_code"),getFrom_store_code())),noOfDecimalsForCost);
				//Added by suresh.r on 11-08-2014 against Inc #50521 end

					for (int j=0;j<sourceArrayList.size(); j++ ) {
						HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
						hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
						hmExpRecord.put("uom_code",hmDtlRecord.get("uom_code"));
						//hmExpRecord.put("item_unit_cost",hmDtlRecord.get("item_unit_cost"));
						//Modified by suresh.r on 11-08-2014 against Inc #50521
						hmExpRecord.put("item_unit_cost",unit_cost);
						alExpData.add(hmExpRecord);
						System.out.println("StockTransferBean----alExpData--"+alExpData);
					}
				}
			//double toStrQty=((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(Double.parseDouble((String)hmDtlRecord.get("to_conv_fact"))));
			//double mm_trn_qty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(Double.parseDouble((String)hmDtlRecord.get("frm_conv_fact"))));
			double mm_trn_qty	= 1;
			double toStrQty		= 1;

			String allow_deci_yn1 = "";

			if (hmDtlRecord.containsKey("allow_deci_yn")){
			allow_deci_yn1= (String)hmDtlRecord.get("allow_deci_yn");
			}else if (hmDtlRecord.containsKey("decimal_allowedYN")){
			allow_deci_yn1= (String)hmDtlRecord.get("decimal_allowedYN");
			}


			if(getAllowDecimalsYN((String)hmDtlRecord.get("item_code")).equals("N")){
				mm_trn_qty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty"))/(Double.parseDouble((String)hmDtlRecord.get("from_multiples"))))*(Double.parseDouble((String)hmDtlRecord.get("batch_multiples"))));
				toStrQty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty"))/(Double.parseDouble((String)hmDtlRecord.get("from_multiples"))))*(Double.parseDouble((String)hmDtlRecord.get("to_multiples"))));
			}else{
				mm_trn_qty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(Double.parseDouble((String)hmDtlRecord.get("frm_conv_fact"))));
				toStrQty=(mm_trn_qty/(Double.parseDouble((String)hmDtlRecord.get("to_conv_fact"))));
			}
			//double toStrQty=(mm_trn_qty/(Double.parseDouble((String)hmDtlRecord.get("to_conv_fact"))));
			//double toStrQty=(mm_trn_qty/(Double.parseDouble((String)hmDtlRecord.get("to_conv_fact"))));

			hmDtlRecord.put("to_str_qty",setNumber(""+toStrQty,getNoOfDecimals()));
			hmDtlRecord.put("mm_trn_qty",setNumber(""+mm_trn_qty,getNoOfDecimals()));
				alDtlData.add(hmDtlRecord); 
			}

			hmTableData.put("properties",	getProperties());
			hmTableData.put("HDR_DATA",		alHdrData);
			hmTableData.put("DTL_DATA",		alDtlData);
			hmTableData.put("DTL_EXP_DATA",	alExpData);
			hmTableData.put("COMMON_DATA",	alCommonData);
			hmTableData.put("LANGUAGE_DATA",	allanguageData);
			hmSQLMap=stockSQL();

			System.out.println("StockTransferBean----hmTableData--"+hmTableData);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}
		if((getItemClassBased("TFR").equals("Y")) && (getAutoDocGen(getDoc_type_code()).equals("Y"))){
			hmTableData = modifiedTableData(hmTableData,"TFR");
		}
		//return new HashMap();
		return stockTransferMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );

	}

	public HashMap modify(){
		System.out.println("StockTransferBean----- modify()-------------");
 		HashMap hmResult=new HashMap();
		ArrayList<String> alParam = new ArrayList<String>();
		int doc_count = 0;
		try{
			alParam.add(getLoginFacilityId());
			alParam.add(getDoc_type_code());
			alParam.add(getDoc_no());
			doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_TRANSFER_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND (FINALIZED_YN='Y' OR PROCESS_FOR_ACKNOWLEDGE='Y')",alParam)).get("COUNT"));
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
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();

		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
		ArrayList alCommonData	=	new ArrayList();
		
		ArrayList allanguageData	=	new ArrayList();

		alCommonData.add(getLoginById()			);
		alCommonData.add(getLoginAtWsNo()		);
		alCommonData.add(getLoginFacilityId()	);
		alCommonData.add(getDoc_type_code());

		alHdrData.add(getLoginFacilityId());
		alHdrData.add(getDoc_type_code());
		alHdrData.add(getDoc_no());
		alHdrData.add(com.ehis.util.DateUtils.convertDate(getDoc_date(),"DMY",getLanguageId(),"en"));
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
		alHdrData.add("N");//gl_interface
		alHdrData.add("TFR");
		alHdrData.add("Y");//Entry completed yn
		alHdrData.add(getItem_class_code());
		
		alHdrData.add(getLoginById());
		alHdrData.add(getLoginAtWsNo());
		alHdrData.add(getLoginFacilityId());
   
		allanguageData.add(getLanguageId());

		try {
//alDtlRecords
			
			//StringTokenizer stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");

			StringTokenizer stRecordsToDelete ;

			if(getBarcodeApplicable().equals("Y")){				
			stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete_for_barcode(),",");
			}
			else{			
			stRecordsToDelete	=	new StringTokenizer(getRecords_to_delete(),",");
			}

			int alDtlRecords_size = 0;

			if(getBarcodeApplicable().equals("Y")){

				ArrayList alDtl  = getDtlRecordsforBarCode();

				alDtlRecords_size	=	alDtl.size();
				System.out.println("StockTransferBean-mod--if--alDtlRecords_size--"+alDtlRecords_size);
				}
			else{	
				alDtlRecords_size	=	alDtlRecords.size();
				System.out.println("StockTransferBean-mod--else--alDtlRecords_size--"+alDtlRecords_size);
			}


			for (int i=0;i<alDtlRecords_size;i++) {

				String nextToken = stRecordsToDelete.nextToken();

				HashMap hmDtlRecord	= null;

			//	HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);

				if(getBarcodeApplicable().equals("Y")){
				hmDtlRecord	=	getDtlRecordforBarCode(i);
				System.out.println("StockTransferBean--mod-if--hmDtlRecord--"+hmDtlRecord);
				}
				else{	
				hmDtlRecord	=	(HashMap) alDtlRecords.get(i);
				System.out.println("StockTransferBean--mod-else--hmDtlRecord--"+hmDtlRecord);
				}
				
				//HashMap hmDtlRecord	=	(HashMap) alDtlRecords.get(i);



				if(nextToken.equals("Y")) {
					if (((String)hmDtlRecord.get("mode")).equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY")) ){
						hmDtlRecord.put("mode",eCommon.Common.CommonRepository.getCommonKeyValue("MODE_DELETE"));
					}
					else{
						continue;
					}
				}
				else{
					ArrayList sourceArrayList = null;

					//ArrayList sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);

				if(getBarcodeApplicable().equals("Y")){
				sourceArrayList	=	getExpRecordsforBarCode(i);
				System.out.println("StockTransferBean--mod-if--sourceArrayList--"+sourceArrayList);
				}
				else{	
				sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
				System.out.println("StockTransferBean-mod--else--sourceArrayList--"+sourceArrayList);
				}
				//Added by suresh.r on 11-08-2014 against Inc #50521 beg
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());
				String unit_cost=setNumber(""+(Double.parseDouble((String)hmDtlRecord.get("item_unit_cost"))/getConvFactTemp((String)hmDtlRecord.get("item_code"),getFrom_store_code())),noOfDecimalsForCost);
				//Added by suresh.r on 11-08-2014 against Inc #50521 end


					for (int j=0;j<sourceArrayList.size(); j++ ) {
						HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
						hmExpRecord.put("doc_srl_no",hmDtlRecord.get("doc_srl_no"));
						hmExpRecord.put("uom_code",hmDtlRecord.get("uom_code"));
						//hmExpRecord.put("item_unit_cost",hmDtlRecord.get("item_unit_cost"));
						//Modified by suresh.r on 11-08-2014 against Inc #50521
						hmExpRecord.put("item_unit_cost",unit_cost);
						alExpData.add(hmExpRecord);
					}
				}
			//double toStrQty=((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code())));
			//double mm_trn_qty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code())));
			double mm_trn_qty	= 1;
			double toStrQty		= 1;

			//if(((String)hmDtlRecord.get("allow_deci_yn")).equals("N")){
			if( getAllowDecimalsYN((String)hmDtlRecord.get("item_code")).equals("N") ){
				mm_trn_qty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty"))/(Double.parseDouble((String)hmDtlRecord.get("from_multiples"))))*(Double.parseDouble((String)hmDtlRecord.get("batch_multiples"))));
				toStrQty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty"))/(Double.parseDouble((String)hmDtlRecord.get("from_multiples"))))*(Double.parseDouble((String)hmDtlRecord.get("to_multiples"))));
			}else{
				mm_trn_qty = ((Double.parseDouble((String)hmDtlRecord.get("item_qty")))*(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getFrom_store_code())));
				toStrQty=(mm_trn_qty/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getTo_store_code())));
			}
			//double toStrQty=(mm_trn_qty/(getConvFactTemp((String)hmDtlRecord.get("item_code"),(String)getTo_store_code())));
			hmDtlRecord.put("to_str_qty",""+toStrQty);
			hmDtlRecord.put("mm_trn_qty",""+mm_trn_qty);
			alDtlData.add(hmDtlRecord); 
			}
			hmTableData.put("properties",	getProperties());
			hmTableData.put("HDR_DATA",		alHdrData);
			hmTableData.put("DTL_DATA",		alDtlData);
			hmTableData.put("DTL_EXP_DATA",	alExpData);
			hmTableData.put("COMMON_DATA",	alCommonData);
			hmTableData.put("LANGUAGE_DATA",allanguageData);
		}
		catch(Exception exception) {
			exception.printStackTrace();
		}

		hmSQLMap=stockSQL();
		//return new HashMap();
		return stockTransferMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);

	}

	public HashMap stockTransferMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
		HashMap		hmResult	=	new HashMap()	;
		StockTransferRemote	stockTransferRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_STOCK_TRANSFER"),StockTransferLocalHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			switch (functionID)
			{
				case FUNCTION_INSERT:
				     hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					//hmResult = stockTransferRemote.insert( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_UPDATE:
					 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					//hmResult = stockTransferRemote.modify( hmTableData, hmSQLMap ) ;
					break;
				
				case FUNCTION_DELETE:
					 hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					//hmResult = stockTransferRemote.delete( hmTableData, hmSQLMap ) ;
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to stockTransferMethodCall()") ;
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else 
			{
				if( hmResult.get("msgid")!=null  )
					hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
				 else
					hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
				if(hmResult.get("flag") != null)
					hmResult.put( "flag", replaceNewLineChar((String)hmResult.get("flag")) ) ;
			}
/* SEND TO PRINT ONLINE REPORT STARTS 9/30/2004*/		
		    //String doc_no	=	(String)hmResult.get("doc_no");	
	        ArrayList doc_no	=	new ArrayList();
			if(hmResult.containsKey("doc_no") == true)
				doc_no	= (ArrayList)hmResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);
			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest  = getFrom_store_code() ;
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			stReportid= "STBTFRDC";
//			if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
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
							hmResult.put("flag",hmResult.get("flag") + "~PN");
						}
				 }
			}
		
/* SEND TO PRINT ONLINE REPORT ENDS*/	
		}catch(Exception exception) {
			hmResult.put( "message", "Bean 383: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( stockTransferRemote != null )
					stockTransferRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", "Bean 393: "+exception.toString()) ;
			}
		}

/*		if (finalized_yn.substring(0,1).equals("Y")&& hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (isInternalRequest("ST","STBTFRDC")) {
				String doc_no	=	(String)hmResult.get("doc_no");	
				doOnlineReportPrinting(doc_no);				
			}
		}*/

		return hmResult;
	}

	/*public void doOnlineReportPrinting(String doc_no) {
		try{
			String reportid = "STBTFRDC";
			if (!isInternalRequest("ST",reportid)) return;
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			hmReportParameter.put("p_language_id",getLanguageId());
			if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;
     //       javax.servlet.http.HttpSession session = request.getSession(false);
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
			
			
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/

	public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{

			String reportid = "STBTFRDC";
			//String copies = getNoOfCopies(reportid);
	
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", "STBTFRDC") ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid, "S", PgetStore_codest) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", "STBTFRDC") ;
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
			String reportid = "STBTFRDC";
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

//sql for mgr
	hmSQLMap.put("stSQLHdrUpdate", getStRepositoryValue("SQL_ST_TRANSFER_HDR_UPDATE"));
	hmSQLMap.put("stSQLHdrInsert", getStRepositoryValue("SQL_ST_TRANSFER_HDR_INSERT"));
	hmSQLMap.put("stSQLHdrDelete", getStRepositoryValue("SQL_ST_TRANSFER_HDR_DELETE"));

	hmSQLMap.put("stSQLDtlUpdate", getStRepositoryValue("SQL_ST_TRANSFER_DTL_UPDATE"));
	hmSQLMap.put("stSQLDtlInsert", getStRepositoryValue("SQL_ST_TRANSFER_DTL_INSERT"));
	hmSQLMap.put("stSQLDtlDeleteAll", getStRepositoryValue("SQL_ST_TRANSFER_DTL_DELETE_ALL"));
	hmSQLMap.put("stSQLDtlDelete", getStRepositoryValue("SQL_ST_TRANSFER_DTL_DELETE"));

	hmSQLMap.put("stSQLExpUpdate", getStRepositoryValue("SQL_ST_TRANSFER_DTL_EXP_UPDATE"));
	hmSQLMap.put("stSQLExpInsert", getStRepositoryValue("SQL_ST_TRANSFER_DTL_EXP_INSERT"));
	hmSQLMap.put("stSQLExpDeleteAll", getStRepositoryValue("SQL_ST_TRANSFER_DTL_EXP_DELETE_ALL"));
	hmSQLMap.put("stSQLExpDelete", getStRepositoryValue("SQL_ST_TRANSFER_DTL_EXP_DELETE"));

	hmSQLMap.put("sql_sy_acc_entity_doc_type_select", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT"));
	hmSQLMap.put("sql_sy_acc_entity_doc_type_update", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));
	hmSQLMap.put("sql_sy_acc_entity_doc_type_select_flag", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_SELECT_FLAG"));

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

    hmSQLMap.put("SQL_TRADE_ID_APPLICABLE_SELECT", getStRepositoryValue("SQL_TRADE_ID_APPLICABLE_SELECT"));
    hmSQLMap.put("SQL_DFLT_TRADE_ID_SELECT", getStRepositoryValue("SQL_DFLT_TRADE_ID_SELECT"));
	hmSQLMap.put("SQL_ITEM_TRADE_SELECT", getStRepositoryValue("SQL_ITEM_TRADE_SELECT"));
	hmSQLMap.put("SQL_ITEM_CODE_TRADE_ID_INSERT", getStRepositoryValue("SQL_ITEM_CODE_TRADE_ID_INSERT")); 

	hmSQLMap.put("SQLBatchBlockRelease", getStRepositoryValue("SQL_ST_ITEM_BATCH_ISS_AUTH_UPDATE"));
	
	hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
	hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
//
	hmSQLMap.put("ItemMovSumInsertSQL", getStRepositoryValue("SQL_STOCK_TRANSFER_ST_ITEM_MOVE_SUMM_INSERT"));
	hmSQLMap.put("ItemMovSumFromUpdateSQL", getStRepositoryValue("SQL_ST_STOCK_TRANSFER_FROM_ITEM_MOVE_SUMM_UPDATE"));
	hmSQLMap.put("ItemMovSumToUpdateSQL", getStRepositoryValue("SQL_ST_STOCK_TRANSFER_TO_ITEM_MOVE_SUMM_UPDATE"));
//

	hmSQLMap.put("FmItemMovSumInsertSQL", getStRepositoryValue("SQL_FM_STOCK_TRANSFER_ST_ITEM_MOVE_SUMM_INSERT"));
	hmSQLMap.put("ToItemMovSumInsertSQL", getStRepositoryValue("SQL_TO_STOCK_TRANSFER_ST_ITEM_MOVE_SUMM_INSERT"));
	hmSQLMap.put("FmItemMovSumFromUpdateSQL", getStRepositoryValue("SQL_FM_STOCK_TRANSFER_FROM_ITEM_MOVE_SUMM_UPDATE"));
	hmSQLMap.put("ToItemMovSumFromUpdateSQL", getStRepositoryValue("SQL_TO_STOCK_TRANSFER_FROM_ITEM_MOVE_SUMM_UPDATE"));

    hmSQLMap.put("TrnDtlInsertSQL", getStRepositoryValue("SQL_ST_STOCK_TRANSFER_ITEM_TRN_DTL_INSERT"));
    hmSQLMap.put("sql_st_transfer_dtl_exp_select_for_block_rel", getStRepositoryValue("SQL_ST_TRANSFER_DTL_EXP_SELECT_FOR_BLOCK_REL"));
    hmSQLMap.put("sql_st_records_per_trn_select", getStRepositoryValue("SQL_ST_RECORDS_PER_TRN_SELECT"));
	
	
	hmSQLMap.put("UpdateSqlfordelete", "update  st_transfer_hdr set 	FINALIZED_YN='D', MODIFIED_BY_ID=?, MODIFIED_DATE=sysdate, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=? where facility_id	= ?	 AND doc_type_code = ?	AND	doc_no = ? ");
	
	hmSQLMap.put("sql_st_facility_id_select", getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT")); //Added by Rabbani on 15/04/2014

//end sql for mgr

	return hmSQLMap;

    }

	public String getFinalize_allowed_yn(String stStore_code) throws Exception{
		String stParameters[]	=	{getLoginById(), stStore_code};
		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		return hmRecord.get("TFR_FINALIZE_ALLOWED_YN").toString();
	}

	public HashMap delete(){
// 		HashMap hmResult		=	new HashMap();;
	
		HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
		ArrayList alHdrData		=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

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
	
		hmTableData.put("properties",	getProperties());
		hmTableData.put("DATA",			alHdrData);
		hmTableData.put("COMMON_DATA",	hmCommonData);
		hmSQLMap=stockSQL();
		return stockTransferMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE );
	}


	public HashMap getROL(String item_code,String store_code){
		HashMap hmRecord = null;
		ArrayList arr = new ArrayList();
		arr.add(item_code);
		arr.add(store_code);
		try{
		hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_STOCK_TRANSFER_ROL"),arr);
		}catch(Exception e){
			e.printStackTrace() ;
		}
		
		return hmRecord;
	}

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
	public ArrayList getBatchStatus(String stItem_code,String stBatch_id,String stExpiry_date) throws Exception{
		

		String chkParameters[] = {stItem_code,stBatch_id,stExpiry_date};
         
		ArrayList result = new ArrayList();
		result = fetchRecords(getStRepositoryValue("SQL_ST_BATCH_STATUS_SELECT_QUERY"),chkParameters);

		return result;
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
	/*public int getConvFactTemp(String item_code,String store_code) {
		int conv_fac_temp		  = 1;	
		HashMap conv_factor		  = new HashMap();
		try{
			String chkdefaultParameters[] = {getGenItemUOM(item_code),store_code,item_code,item_code,getGenItemUOM(item_code),store_code,item_code};

			conv_factor = fetchRecord(getStRepositoryValue("SQL_ST_CONV_FACTOR_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			conv_fac_temp = 1;
			e.printStackTrace();
		}
		
		if(conv_factor.size() > 0)
			conv_fac_temp = Integer.parseInt((String)conv_factor.get("CONV_FACTOR"));

		return conv_fac_temp;
	}*/
	/*public double getConvFactTemp_To(String item_code,String store_code){
		double conv_fac_temp=1;
		ArrayList alParameters = new ArrayList();
		try {
			alParameters.add(item_code);
			alParameters.add(store_code);
			conv_fac_temp=Double.parseDouble(checkForNull((String)fetchRecord("SELECT ST_GET_UOM_CONV_FAC_SING_STR(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"),"1.0"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return conv_fac_temp;
	}
	public double getConvFactTemp_From(String item_code,String store_code){
		double conv_fac_temp=1;
		ArrayList alParameters = new ArrayList();
		try {
   			alParameters.add(item_code);
			alParameters.add(store_code);
			conv_fac_temp=Double.parseDouble(checkForNull((String)fetchRecord("SELECT ST_GET_UOM_CONV_FAC_SING_STR(?,?) CON_FACTOR FROM DUAL",	alParameters).get("CON_FACTOR"),"1.0"));
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
public void setAcc_entity_id(String acc_entity_id) {
		this.acc_entity_id = acc_entity_id;
	}

	public String getAcc_entity_id() {
		return this.acc_entity_id;
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
	public java.util.ArrayList getOnStoresStock(String req_by_store) throws Exception {
			String chkParameters[]={getLoginById(),getAcc_entity_id(),login_facility_id,getLanguageId(),getFrom_store_code()};
			ArrayList result = new ArrayList();
			
			result = fetchRecords(getStRepositoryValue("SQL_ST_STOCK_TO_STORE"),chkParameters);

		
		
		return result;
	
	}
	
	public Boolean getAckReqd(){
		String ack_reqd = "N";
		String ack_facility_reqd = "N";
		String ack_facility_id  = "";
		try{
		    ack_facility_id =  (String)fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT"),getTo_store_code()).get("FACILITY_ID");
			ack_facility_reqd = (String)fetchRecord("SELECT TFR_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", ack_facility_id).get("TFR_ACK_REQ_YN");
			//ack_facility_reqd = (String)fetchRecord("SELECT TFR_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("TFR_ACK_REQ_YN");
			if(ack_facility_reqd.equals("Y")){
			ack_reqd = (String)fetchRecord("SELECT TFR_ACK_REQ_YN FROM ST_STORE WHERE STORE_CODE = ?", getTo_store_code()).get("TFR_ACK_REQ_YN");
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
		ArrayList<HashMap> alItemDtlData = (ArrayList<HashMap>)hmTableData.get("DTL_DATA");
		ArrayList<HashMap> alItemDtlExpData = (ArrayList<HashMap>)hmTableData.get("DTL_EXP_DATA");
		ArrayList<ArrayList> alNewItemHdrData = new ArrayList<ArrayList>();//hmTableData.get("InsertHDRData");
		ArrayList<String> alItemHdrData = (ArrayList<String>)hmTableData.get("HDR_DATA");
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
			for(int j=0;j<alItemDtlData.size();j++){
				hmTempData = new HashMap<String,String>();
				hmTempData = alItemDtlData.get(j);
				try{
					item_class_code = (String)fetchRecord("SELECT ITEM_CLASS_CODE FROM MM_ITEM WHERE ITEM_CODE =?",hmTempData.get("item_code")).get("ITEM_CLASS_CODE");
					if(item_class_code.equals(alItemClassData.get(i))){
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
			alTemp.set(12,alNewItemClassData.get(i));
			alNewItemHdrData.add(alTemp);
		}
			//hmTableData.put("InsertDTLData",alNewTempDtlData);
		//hmTableData.put("InsertHDRData",alNewItemHdrData);
		hmTableData.put("HDR_DATA",alNewItemHdrData);
		hmTableData.put("DTL_DATA",alNewTempDtlData);
		hmTableData.put("DTL_EXP_DATA",alNewTempDtlExpData);
		hmTableData.put("ItemClassCount",alCount);
		hmTableData.put("ItemClass",alNewItemClassData);
		hmTableData.put("ITEM_CLASS_BASED","Y");
		return hmTableData;
	}
	public HashMap validateData(int i) {
		ArrayList sourceArrayList;
		HashMap hmExpRecord			;
		String toBinLocationCode	;
		HashMap hmReturn = getMessageHashMap(true);	
			sourceArrayList	=	(ArrayList)hmExpRecords.get(""+i);
			for (int j=0;j<sourceArrayList.size(); j++ ) {
				hmExpRecord			=	(HashMap)sourceArrayList.get(j);
				toBinLocationCode	= (String)hmExpRecord.get("TO_BIN_LOCATION_CODE");
				if(!((String)hmExpRecord.get("QTY")).equals("0")){
					if(toBinLocationCode == null || toBinLocationCode.equals("")) {
						hmReturn.put(MSGID,"TO_BIN_LOC_NOT_BLANK");
						hmReturn.put(RESULT,FALSE);
						hmReturn.put("flag",(String)hmExpRecord.get("ITEM_DESC"));
						return hmReturn;
					}
				}
			}
		return hmReturn;
	}
	//Added By Rabbani #inc no:28266 on 16/09/11 
	//Starts Here
	public String getAccessSaleyn(String store_code) throws Exception{ 
		String chkdefaultParameters[] = {getLoginById(),store_code};
		String sale_yn			  = "N";	
		HashMap view_sale_yn	  = new HashMap();
		try{
		view_sale_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_SALE_YN_SELECT"),chkdefaultParameters);	
		}catch(Exception e){
			 e.printStackTrace();
		}
		if(view_sale_yn.size() > 0){
		  sale_yn = checkForNull((String)view_sale_yn.get("VIEW_SALE_YN"),"N");
		}
		return sale_yn;
	} 
   
	  public String getCostYN(String from_store_code) throws Exception{ 
		String chkdefaultParameters[] = {getLoginById(),from_store_code};
		String cost_yn			  = "N";	
		HashMap view_cost_yn	  = new HashMap();
		try{
		view_cost_yn = fetchRecord(getStRepositoryValue("ST_SQL_VIEW_COST_SELECT"),chkdefaultParameters);
		}catch(Exception e){
			 e.printStackTrace();
		}
		if(view_cost_yn.size() > 0){
		  cost_yn = checkForNull((String)view_cost_yn.get("VIEW_COST_YN"),"N");
		}
		return cost_yn;
	} 
	
	public ArrayList getTrnTypeArrayList() throws Exception{
	  ArrayList alList = null;
		try{
	      alList = fetchRecords("SELECT TRNTYPE  FROM ST_VIEW_CSTSAL_TRNTYPE");
		 }
		catch(Exception e){
			e.printStackTrace();
		}
	  return alList;
	  }
	  //16/09/11 ends Here 
	 
    //Added for NMC-JD-CRF-0174 starts
	public boolean getStockTransferSite(){
		Connection connection	 = null;  
		boolean site			 = false;
	    try {
				  
				connection = getConnection();
				site = eCommon.Common.CommonBean.isSiteSpecific(connection, "ST","ST_STOCK_TRANSFER_TO_STORE");	
			}
			catch(Exception ex){
				ex.printStackTrace();
			} 
			finally{
				try{
					closeConnection(connection);
				} catch(Exception e) 
				{	
					e.printStackTrace();
				}
			}
		return site;
	}
	//Added for NMC-JD-CRF-0174 ends
		public String getItemByGTIN(String barcode_id)throws Exception{//Addign start for MOHE-CRF-0167
	    
		 HashMap itemDetails =new HashMap();
		 LinkedList batchData=new LinkedList();	 
		 HashMap barcodeData = getBarcodeData();
		 String gtin_item="";
		 String temp_expiry_date ="";
		 String temp_batch_id ="";
		 boolean rec_found = false;
		 HashMap BarcodeDetails = new HashMap();
		 HashMap BarcodeDetails1 = new HashMap();

	   
		   try{
	   
	      String gtin = null;
	      String batchNumber = null;
	      String expiryDate = null;
			String srlNo      =null;

			BarcodeDetails =getBarcodedetails(barcode_id);
			gtin =(String)BarcodeDetails.get("GTIN");
			expiryDate =(String)BarcodeDetails.get("EXPIRY_DATE");
			batchNumber =(String)BarcodeDetails.get("BATCH_ID");
			srlNo =(String)BarcodeDetails.get("SRLNO");

	      
			SimpleDateFormat inputFormat = new SimpleDateFormat("yymmdd");
			SimpleDateFormat outputFormat = new SimpleDateFormat("dd/mm/yyyy");
			java.util.Date inputDate = inputFormat.parse(expiryDate); 

			String temp_exp_date = outputFormat.format(inputDate);

	          System.out.println("new GTIN: " + gtin);
	          System.out.println("new Expiry Date: " + expiryDate+"temp_exp_date==="+temp_exp_date);
	          System.out.println("new Batch ID: " + batchNumber);

	          System.out.println("new GTIN get2DBarcodeItem: " + gtin);
	          
			
				ArrayList alParameters	=	new ArrayList(4);
				
				alParameters.add(checkForNull(gtin));
				
	           gtin_item =	checkForNull((String)fetchRecord("SELECT B.ITEM_CODE FROM AM_TRADE_NAME A, MM_TRADE_NAME_FOR_ITEM B WHERE MANUFACTURER_ID = ? AND A.TRADE_ID = B.TRADE_ID",alParameters).get("ITEM_CODE"));

			if(barcodeData.containsKey(gtin_item)){
					   batchData = (LinkedList)barcodeData.get(gtin_item);
					   for(int i=0;i<batchData.size();i+=2){
					      temp_expiry_date = (String)batchData.get(i+1);
						  temp_batch_id    = (String)batchData.get(i);
						  if(batchNumber.equals(temp_batch_id) && temp_exp_date.equals(temp_expiry_date)){
							  rec_found =true;
							  break;
						  }
					   }

			}else {
					  batchData  =new LinkedList();
			}
			if(!rec_found){
			   batchData.add(batchNumber);
			   batchData.add(temp_exp_date);
			   itemDetails.put(gtin_item,batchData);
			   setBarcodeData(itemDetails);
			}
		   }
			catch (Exception exception) {
				System.out.println("Exception thrown from get2DBarcodeItem = >"+exception.getMessage());
				exception.printStackTrace();
				throw exception;
			 }

			 return gtin_item;
	}//Adding end for MOHE-CRF-0167

}
