/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package eST;
import java.util.*; 
import java.io.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.*;
import javax.rmi.* ;
import javax.naming.* ;
import eST.Common.* ;
import eCommon.Common.*;
//import eST.Common.StTransaction;
//import eST.Common.StHeaderBean;
import eST.ManufacturingReceipt.*; 
import javax.servlet.* ;
import javax.servlet.http.*;

//import eST.Common.StAdapter;
//import eST.Common.StEJBSessionAdapter;
//import eST.Common.StRepository;


//import eCommon.Common.*;
//import eCommon.Common.CommonAdapter;
//import eCommon.Common.CommonEJBSessionInterface; 

//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpSession;



  
public class ManufacturingReceiptsBean extends StHeaderBean implements Serializable { 
	private String child_item_code;
	private String item_code;
	private String short_desc;
	private String process_loss_percent;
	private String unit_cost;
	private String req_type;
	private String lable_type;
//	private String prep_type;
	private String prep_mode;
	private String prep_loc;
	private String req_store;
	private String req_qty;
	private String patient_name;
	private String patient_id;
	private String encounter_id;
	private String store_code;
	private String stock_uom;
	private String Item_desc;
	private String checkBoxVals;
	private String doc_type;
	private String doc_no;
	private String doc_ref;
	private String bin_location_code;
	private String base_qty;
	private String component_qty;
	private String doc_date;
	private String batch_id;
	private String expiry_date;
	private String prepare_qty;
	private String trade_id;
	private String trn_type;
	private String finalized_yn;
	private String composition_for_qty;
	private String index;
	private String ExpiredBatch;
	private String EWDays;	
    private String barcode_id;  
    private String no_of_labels;  

	

	private String PDocNo = "";
	private String PgetDoc_type_code = "";
	private String PgetStore_codest = "";
	private String stReportid = null;

	private String packed_by = "";		
	private String remarks = "";	
	private String counter = "";
	private String auto_gen_batch_yn = "";
	 private String remarks_code = ""; //18/06/12
    private String remarks_desc = "";	//18/06/12
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
	public int seq_no;  
	private String mfg_uom;  
	private String extemp_item_seq;

//	private HttpSession session;
	private ArrayList DataList=new ArrayList() ;
	private ArrayList DataDtlList=new ArrayList() ;
	private ArrayList DataRecordList=new ArrayList() ;
	private ArrayList expDetailsList=new ArrayList() ;
	private ArrayList expBatchDetailsList=new ArrayList() ;
	private ArrayList modDtlList=new ArrayList() ;
	private ArrayList refreshList=new ArrayList() ;
	private ArrayList DataModifyList=new ArrayList();	
	private ArrayList batchDataDisp=new ArrayList();	
	public String reportserver = "";
	public String report_connect_string = "";
/*	private javax.servlet.http.HttpServletRequest request;
	private javax.servlet.http.HttpServletResponse response;

	public void setReFamily(javax.servlet.http.HttpServletRequest request,javax.servlet.http.HttpServletResponse response){
		this.request=request; 
		this.response=response	;
	}*/

	public void setExpBatchDetailsList(ArrayList expBatchDetailsList) {
		 this.expBatchDetailsList = expBatchDetailsList;
	}

	public ArrayList getExpBatchDetailsList( ) {
		 return expBatchDetailsList;
	}

	public void setDataDtlList(ArrayList DataDtlList) {
		 this.DataDtlList = DataDtlList;
	}

	public ArrayList getDataDtlList( ) {
		 return DataDtlList;
	
	}

	public void setRefreshList(ArrayList refreshList) {
		 this.refreshList = refreshList;
	}

	public ArrayList getRefreshList( ) {
		 return refreshList;
	}

	public void setPrintDocNo(String Pdoc_no){
		PDocNo = Pdoc_no;
	}

	public String getPrintDocNo(){
		return PDocNo;
	}

	public void setModDtlList(ArrayList modDtlList) {
		 this.modDtlList = modDtlList;
	}

	public ArrayList getModDtlList( ) {
		 return modDtlList;
	}

	public void setExpDetailsList(ArrayList expDetailsList) {
		 this.expDetailsList = expDetailsList;
	}

	public ArrayList getExpDetailsList( ) {
		 return expDetailsList;
	}

	public void setDataList(ArrayList DataList) {
		 this.DataList = DataList;
	}

	public ArrayList getDataList( ) {
		 return DataList;
	}
	public void setDataModifyList(ArrayList DataModifyList) {
	 this.DataModifyList = DataModifyList;
	}

	public ArrayList getDataModifyList( ) {
		return DataModifyList;
	}

	public void setDataRecordList(ArrayList DataRecordList) {
		 this.DataRecordList = DataRecordList;
	}

	public ArrayList getDataRecordList() {
      
		 return DataRecordList;
	}

	public void setItem_code(String itemcode) {

		 this.item_code = checkForNull(itemcode);
	}

	public String getItem_code() {
		 return item_code;
	}

	public void setItem_desc(String Item_desc) {
		 this.Item_desc = checkForNull(Item_desc);
	}

	public String getItem_desc() {
		 return Item_desc;
	}
	
	public void setChild_item_code(String child_item_code) {
		 this.child_item_code = checkForNull(child_item_code);
	}

	public String getChild_item_code() {
		 return child_item_code;
	}

	public void setShort_desc(String short_desc) {
		 this.short_desc = checkForNull(short_desc);
	}

	public String getShort_desc() {
		 return short_desc;
	}

	public void setPrepare_qty(String prepare_qty) {
		 this.prepare_qty = checkForNull(prepare_qty);
	}

	public String getPrepare_qty() {
		 return prepare_qty;
	}

	public void setBase_qty(String base_qty) {
		 this.base_qty = checkForNull(base_qty);
	}

	public String getBase_qty() {
		 return base_qty;
	}

	public void setBinLocation_code(String bin_location_code) {
		 this.bin_location_code = checkForNull(bin_location_code);
	}

	public String getBinLocation_code( ) {
		 return bin_location_code;
	}

	public void setTrade_id(String trade_id) {
		 this.trade_id = checkForNull(trade_id);
	}

	public String getTrade_id( ) {
		 return trade_id;
	}

	public void setReq_store(String req_store) {
		 this.req_store = req_store;
	}

	public String getReq_store( ) {
		 return req_store;
	}
	public void setLabel_Type(String labletype) {
		 this.lable_type = labletype;
	}

	public String getLabel_Type( ) {
		 return lable_type;
	}

	

	public void setUnit_cost(String unit_cost) {
		 this.unit_cost = checkForNull(unit_cost);
	}

	public String getUnit_cost( ) {
		 return unit_cost;
	}

	public void setReq_type(String req_type) {
		 this.req_type = checkForNull(req_type);
	}

	public String getReq_type( ) {
		 return req_type;
	}

	public void setTrntype(String trn_type) {
		 this.req_type = checkForNull(trn_type);
	}

	public String getTrntype( ) {
		 return trn_type;
	}
	
	public void setPrep_loc(String prep_loc) {
		 this.prep_loc = prep_loc;
	}

	public String getPrep_loc( ) {
		 return prep_loc;
	}

	public void setDoc_type(String doc_type) {
		 this.doc_type = checkForNull(doc_type);
	}

	public String getDoc_type( ) {
		 return doc_type;
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = checkForNull(doc_no);
	}

	public String getDoc_no( ) {
		 return doc_no;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = checkForNull(doc_ref);
	}

	public String getDoc_ref( ) {
		 return doc_ref;
	}
	
	public void setDoc_date(String doc_date) {
		 this.doc_date = checkForNull(doc_date);
		 
	}

	public String getDoc_date( ) {
		  return doc_date;
	}

/*	public void setStorecode(String store_code) {
		 this.store_code = checkForNull(store_code);
	

	}

	public String getStorecode( ) {
	
		 return store_code;
	}*/

	public void setBatch_id(String batch_id) {
		 this.batch_id = checkForNull(batch_id);
	}

	public String getBatch_id( ) {
		 return batch_id;
	}
	public void setExpiry_date(String expiry_date) {
		 this.expiry_date = checkForNull(expiry_date);
	}

	public String getExpiry_date( ) {
		 return expiry_date;
	}

	public void setStock_uom(String stock_uom) {
		 this.stock_uom = checkForNull(stock_uom);
	}

	public String getStock_uom( ) {
		 return stock_uom;
	}

	public void setComponent_qty(String component_qty) {
		 this.component_qty = checkForNull(component_qty);
	}

	public String getComponent_qty( ) {
		 return component_qty;
	}

	public void setPrep_mode(String prep_mode) {
		 this.prep_mode = checkForNull(prep_mode);
	}

	public String getPrep_mode( ) {
		 return prep_mode;
	}
	
	public void setPatient_id(String patient_id) {
		 this.patient_id = checkForNull(patient_id);
	}

	public String getPatient_id( ) {
		 return patient_id;
	}

	public void setPatient_name(String patient_name) {
		 this.patient_name = checkForNull(patient_name);
	}

	public String getPatient_name( ) {
		 return patient_name;
	}

	public void setEncounter_id(String encounter_id) {
		 this.encounter_id = checkForNull(encounter_id);
	}

	public String getEncounter_id( ) {
		 return encounter_id;
	}

	 //Commented by Rabbani #Inc no : 38990 on 28-MAR-2013 Starts
	/*public void setStore_code(String store_code) {
		 this.store_code = checkForNull(store_code);
		super. setStore_code(store_code);
 		 	}

	public String getStore_code( ) {
 		 	 return store_code;
	} ends */

	public void setProcess_loss_percent(String process_loss_percent) {
		 this.process_loss_percent = checkForNull(process_loss_percent);
	}

	public String getProcess_loss_percent( ) {
		 return process_loss_percent;
	}

	public void setReq_qty(String req_qty) {
		 this.req_qty = checkForNull(req_qty);
	}

	public String getReq_qty( ) {
		 return req_qty;
	}

	public void setIndex(String index) {
		 this.index = checkForNull(index);
	}

	public String getIndex( ) {
		 return index;
	}

	public void setFinalized_yn(String finalized_yn) {
		 this.finalized_yn = checkForNull(finalized_yn);
	}

	public String getFinalized_yn( ) {
		 return finalized_yn;
	}

	public void setComposition_for_qty(String composition_for_qty) {
		 this.composition_for_qty = checkForNull(composition_for_qty);
	}

	public String getComposition_for_qty( ) {
		 return composition_for_qty;
	}

	public void setCheckBoxVals(String checkBoxVals) {
		 this.checkBoxVals = checkForNull(checkBoxVals);
	}

	public String getCheckBoxVals( ) {
		 return checkBoxVals;
	}

	public void setEWD(String EWDays){
		this.EWDays = EWDays;
	}
	
	public String getEWD(){
		return EWDays;
	}

	public void setExpiredBatch(String expired_batch){
		this.ExpiredBatch = expired_batch;
	}
	
	public String getExpiredBatch(){
		return ExpiredBatch;
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
	public void setPackedBy(String packedby){
		this.packed_by = packedby;
	}
	public void setRemarks(String remark){
		this.remarks = remark;
	}
	public void setCounterChk(String counter){
		this.counter = counter;
	}
	public void setAutoGenBatch_yn(String auto_gen_batch_yn){
		this.auto_gen_batch_yn = auto_gen_batch_yn;
	}
	
    //Added by Rabbani #Inc no:32766 on 18/05/12 Starts
	public void setBarcode_id(String barcode_id) {
		 this.barcode_id = checkForNull(barcode_id);
	}

	public String getBarcode_id() {
		 return barcode_id;
	}
	
  public void setNo_of_labels(String no_of_labels) {
		 this.no_of_labels = checkForNull(no_of_labels);
	}

	public String getNo_of_labels() {
		 return no_of_labels;
	}
	
	//ends
	//Added by Rabbani #Inc no:33352 on 18/06/12
	public void setRemarks_code(String remarks_code){
		this.remarks_code = remarks_code;
	}
	
	public void setRemarks_desc(String remarks_desc){
		this.remarks_desc = remarks_desc;
	}
	
	public String getRemarks_desc() {
		 return remarks_desc;
	}
	//ends
	
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
	public void setMfg_uom(String mfg_uom) {  
		 this.mfg_uom = checkForNull(mfg_uom);
	}
	public String getMfg_uom( ) {
		 return mfg_uom;
	}
	public void setExtemp_item_seq(String extemp_item_seq) {
		 this.extemp_item_seq = extemp_item_seq;
	}
	public String getExtemp_item_seq( ) {
		 return extemp_item_seq;
	}
	
   //ends
	
	

// added on 19/11/04 by sri
	public HashMap getBatchGenDetails(){
		HashMap auto_gen_batch_id=null;
		try{
		 auto_gen_batch_id=fetchRecord(getStRepositoryValue("SQL_ST_MAN_RECEIPT_BATCH_GEN"),getPrep_loc());
		}catch(Exception e){
				e.printStackTrace() ;
		}
		return auto_gen_batch_id;
	}

	public void setAll( Hashtable recordSet){
		
		setBase_qty((String)recordSet.get("baseqty"));
		setBatch_id((String)recordSet.get("batch_id"));
		setExpiry_date((String)recordSet.get("expiry_date"));
		setBinLocation_code((String)recordSet.get("bin_location"));
		setTrade_id((String)recordSet.get("trade_id"));
		setProcess_loss_percent((String)recordSet.get("process_loss"));
		setFinalized_yn((String)recordSet.get("finalized_yn"));
		setComposition_for_qty((String)recordSet.get("composition_for_qty"));
		setCheckBoxVals((String)recordSet.get("checkBoxVals"));

		setPackedBy((String)recordSet.get("packed_by"));
		setRemarks((String)recordSet.get("remarks"));
		setCounterChk((String)recordSet.get("counter"));


	}

	 public HashMap validate(){
        HashMap hashmap = new HashMap();
        //ArrayList arraylist = new ArrayList();
        hashmap.put("result", super.TRUE);
        return hashmap;
    }

public void initialize(){

        super.initialize();
		 child_item_code="";
		 item_code="";
		 short_desc="";
		 process_loss_percent="";
		 unit_cost="";
		 req_type="";
		 lable_type="";
//		 prep_type="";
		 prep_mode="";
		 prep_loc="";
		 req_store="";
		 req_qty="";
		 patient_name="";
		 patient_id="";
		 encounter_id="";
		 store_code="";
		 stock_uom="";
		 Item_desc="";
		 checkBoxVals="";
		 doc_type="";
		 doc_no="";
		 doc_ref="";
		 bin_location_code="";
		 base_qty="";
		 component_qty="";
		 doc_date="";
		 batch_id="";
		 expiry_date="";
		 prepare_qty="";
		 EWDays="";
		 ExpiredBatch="";
		 barcode_id = ""; 
		 no_of_labels ="";
		 mfg_uom ="";   //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
		 seq_no=0;  
		 index = "";
		 DataList.clear();
		 DataDtlList.clear();
		 DataRecordList.clear();
		 expDetailsList.clear();
		 expBatchDetailsList.clear();
	}

	public void clear(){
		
		 super.clear();	
		 child_item_code=null;
		 item_code=null;
		 short_desc=null;
		 process_loss_percent=null;
		 unit_cost=null;
		 req_type=null;
		 lable_type=null;
//		 prep_type=null;
		 prep_mode=null;
		 prep_loc=null;
		 req_store=null;
		 req_qty=null;
		 patient_name=null;
		 patient_id=null;
		 encounter_id=null;
		 store_code=null;
		 stock_uom=null;
		 Item_desc=null;
		 checkBoxVals=null;
		 doc_type=null;
		 doc_no=null;
		 doc_ref=null;
		 bin_location_code=null;
		 base_qty=null;
		 component_qty=null;
		 doc_date=null;
		 batch_id=null;
		 expiry_date=null;
		 prepare_qty=null;
		 EWDays=null;
		 ExpiredBatch=null;
		 barcode_id=null; 
		 no_of_labels =null;
		  mfg_uom =null;
		  seq_no=0;  
		  index= null;
		 DataList.clear();
		 DataDtlList.clear();
		 DataRecordList.clear();
		 expDetailsList.clear();
		 expBatchDetailsList.clear();
    }	
	
	public HashMap getDtlRecord(int index){
		return (HashMap)expDetailsList.get(index);
	}

	 public HashMap insert()
    {
//	    HashMap hashmap = new HashMap();
//        HashMap hmDtlScreenData = null;
        HashMap hashmapQry = new HashMap();
        ArrayList arraylist = new ArrayList();
              
//        HashMap hmSQLMap		=	new HashMap();
		HashMap hmTableData		=	new HashMap();
//		ArrayList alHdrData		=	new ArrayList();
		ArrayList alDtlData		=	new ArrayList();
		ArrayList alExpData		=	new ArrayList();
//		ArrayList alCommonData	=	new ArrayList();
		ArrayList languageData	=	new ArrayList();
		HashMap hmCommonData	=	new HashMap();
		HashMap hashmapHdr      =   new HashMap(); 
		
		StringTokenizer stringtokenizer = new StringTokenizer(getCheckBoxVals(), ",");
		try{
			boolean autoGenerateYN=isDocNoAutoGenYN(getDoc_type_code());
			if(autoGenerateYN)
				doc_no=fetchNextDocNo(getDoc_type_code());
			else
				doc_no=getDoc_no();

			setPrintDocNo(doc_no);

			//HashMap hashmapHdr = (HashMap)DataRecordList.get(Integer.parseInt(getIndex()));
			 //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
			 if(getIndex() != null && getIndex() != ""){
			  hashmapHdr = (HashMap)DataRecordList.get(Integer.parseInt(getIndex()));
			}else{
			  hashmapHdr = (HashMap)DataRecordList.get(0);
			}
			arraylist.add(getLoginFacilityId());
			arraylist.add(getDoc_type_code());
			arraylist.add(doc_no);
			arraylist.add(getDoc_date());
			arraylist.add(getDoc_ref());
			arraylist.add((String)hashmapHdr.get("REQUESTING_STORE_CODE"));
			arraylist.add((String)hashmapHdr.get("ITEM_CODE"));
			//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
			//Commented by Rabbani #Inc no:37445(RUT-CRF-0097) on 08-MAY-2013
			//if((String)hashmapHdr.get("DFLT_MFG_MODE") != null){
			// if(((String)hashmapHdr.get("DFLT_MFG_MODE")).equals("D")){
			  arraylist.add(checkForNull(getReq_qty()));  
		    //}
			//}else{
			//arraylist.add((String)hashmapHdr.get("REQUEST_QTY"));  
			//}
			arraylist.add(getExpiry_date());
			arraylist.add(getBatch_id());
			arraylist.add(getBinLocation_code());
			arraylist.add(getFinalized_yn());
			arraylist.add("N");
						
			if(!((String)hashmapHdr.get("PREPARATION_TYPE")).equals("E"))
				arraylist.add(getStockYn((String)hashmapHdr.get("REQUESTING_STORE_CODE"),(String)hashmapHdr.get("ITEM_CODE")));
			else
				arraylist.add("N");

			arraylist.add((String)hashmapHdr.get("PREPARATION_TYPE"));
			arraylist.add((String)hashmapHdr.get("PREPARATION_MODE"));
			arraylist.add((String)hashmapHdr.get("PREPARE_LOCATION_CODE"));
			arraylist.add(checkForNull((String)hashmapHdr.get("PATIENT_ID")));
			arraylist.add(checkForNull((String)hashmapHdr.get("ENCOUNTER_ID")));
			arraylist.add(checkForNull((String)hashmapHdr.get("UNIT_COST")));
			arraylist.add("");
			arraylist.add(getProcess_loss_percent());
			arraylist.add(getComposition_for_qty());
			arraylist.add((String)hashmapHdr.get("MFG_REQUEST_NO"));
			arraylist.add(getTrade_id());

			if(!((String)hashmapHdr.get("PREPARATION_TYPE")).equals("E")){
			arraylist.add(checkForNull((String)hashmapHdr.get("UOM_CODE")));
			arraylist.add(base_qty);
			}
			else{
			arraylist.add("");
			arraylist.add(req_qty);
			}
			arraylist.add(base_qty);
			//arraylist.add(remarks);
		    arraylist.add(checkForNull(remarks_code));//Added by Rabbani #Inc no:33352 on 18/06/12
			arraylist.add(checkForNull(packed_by));
			arraylist.add(counter);
			arraylist.add(auto_gen_batch_yn);
			arraylist.add(checkForNull(getBarcode_id()));  //Added by Rabbani #Inc no:32766 on 18/05/12
			arraylist.add(checkForNull(getNo_of_labels())); //33
			arraylist.add(checkForNull((String)hashmapHdr.get("DFLT_MFG_MODE"),"R")); //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013   
		 
			System.out.println("arraylist==703bean insert=>" +arraylist);
			
		    int doc_srl_no=0;
			
			for (int i=0;i<DataDtlList.size();i++) {
				String nextToken = stringtokenizer.nextToken();
				HashMap hmDtlRecord	=	(HashMap) DataDtlList.get(i);
				if(nextToken.equals("N")) {
					//expDetailsList=expBatchDetailsList;
					doc_srl_no++;
					//(String)hmDtlRecord.get("CHILD_ITEM_CODE")
					ArrayList sourceArrayList	=	getDtlExpList((String)hmDtlRecord.get("CHILD_ITEM_CODE"),(String)hashmapHdr.get("REQUESTING_STORE_CODE"));
					System.out.println("sourceArrayList==712==>" +sourceArrayList);
					if (sourceArrayList!=null) 
						for (int j=0;j<sourceArrayList.size(); j++ ) {
							HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(j);
							hmExpRecord.put("doc_srl_no",""+doc_srl_no);
							hmExpRecord.put("unit_cost",hmDtlRecord.get("UNIT_COST"));
							hmExpRecord.put("UOM_CODE",hmDtlRecord.get("UOM_CODE"));
							 
							alExpData.add(hmExpRecord);
						System.out.println("alExpData==720==>" +alExpData);	
						}
						alDtlData.add(hmDtlRecord);
						 
				}
				
			}
			languageData.add(getLanguageId());
			hmCommonData.put("login_by_id",getLoginById()			);
			hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
			hmCommonData.put("login_facility_id",getLoginFacilityId()	);
			
			hmTableData.put("properties",	getProperties());
			hmTableData.put("HDR_DATA",		arraylist);
			hmTableData.put("DTL_DATA",		alDtlData);
			hmTableData.put("DTL_EXP_DATA",	alExpData);    
			hmTableData.put("COMMON_DATA",	hmCommonData);
			hmTableData.put("isDocNoAutoGenYN", new Boolean(autoGenerateYN));
			hmTableData.put("PREPARATION_TYPE", (String)hashmapHdr.get("PREPARATION_TYPE"));
			hmTableData.put("finalized_yn", getFinalized_yn());
             hmTableData.put("LANGUAGE_DATA", languageData);
	}
	catch (Exception e){
		e.printStackTrace() ;
		}
		return methodCall(hmTableData, hashmapQry, 1);
	   //return hashmap;
    }

    public HashMap methodCall(HashMap hashmap, HashMap hashmapQuery,int mode )
    {
        HashMap hashmapResult = new HashMap();
		
	/*	
		if(mode==2)
			hashmapResult = new eST.ManufacturingReceiptT.ManufacturingReceiptManager().modify(hashmap, hashmapQuery);
		else if(mode==1)
			hashmapResult = new eST.ManufacturingReceiptT.ManufacturingReceiptManager().insert(hashmap, hashmapQuery);
		else
			hashmapResult = new eST.ManufacturingReceiptT.ManufacturingReceiptManager().delete(hashmap, hashmapQuery);
*/
        try
        {
//          ManufacturingReceiptHome manufacturingReceipthome = null;
  //        ManufacturingReceiptRemote manufacturingReceiptremote = null;
           /* InitialContext initialcontext = new InitialContext();
            Object obj = initialcontext.lookup(getStRepositoryValue("JNDI_ST_MANUFACTURING_RECEIPT"));
            manufacturingReceipthome = (ManufacturingReceiptHome)PortableRemoteObject.narrow(obj, ManufacturingReceiptHome.class);
            manufacturingReceiptremote = manufacturingReceipthome.create();*/
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_MANUFACTURING_RECEIPT"),ManufacturingReceiptHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hashmap;
			argArray[1] = hashmapQuery;

			Class [] paramArray = new Class[2];
			paramArray[0] = hashmap.getClass(); ;
			paramArray[1] = hashmapQuery.getClass();
           
		

			if(mode==2)
			{
				hashmapResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			}
          //  hashmapResult = manufacturingReceiptremote.modify(hashmap, hashmapQuery);
			else if(mode==1)
			{
			
				hashmapResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			}
		//	hashmapResult = manufacturingReceiptremote.insert(hashmap, hashmapQuery);
			else
			 hashmapResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		//	hashmapResult = manufacturingReceiptremote.delete(hashmap, hashmapQuery);
		
        if(((Boolean)hashmapResult.get("result")).booleanValue()){
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get( "msgid" ),"ST") ) ;
		}
        else if(hashmapResult.get("msgid") != null)
			{
            hashmapResult.put("message", getSTMessage(getLanguageId(),(String) hashmapResult.get( "msgid" ),"ST") ) ;
			}
        else
            hashmapResult.put("message", replaceNewLineChar((String)hashmapResult.get("message")));
		}
		catch(Exception exception) {
			hashmapResult.put( "message", ""+exception.getMessage()) ;
			exception.printStackTrace() ;
		}
	if( mode == 1|| mode==2)
		{
		/* SEND TO PRINT ONLINE REPORT STARTS 9/28/2004 */		

/*	        String doc_no	=	(String)hashmapResult.get("doc_no");	
			String alertRqdYN = "";
			setPrintDocNo(doc_no);*/
			String alertRqdYN = "";
			//String doc_no	=	getPrintDocNo();	
			PgetDoc_type_code = getDoc_type_code();
			PgetStore_codest  = getStore_code( );
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			try
			{
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			}
			catch(Exception e)
			{
					e.printStackTrace() ;
			}

			stReportid= "STBMFGDC";
			
//			if (finalized_yn.substring(0,1).equals("Y")&& hashmapResult.get("result") != null && (((Boolean)hashmapResult.get("result")).booleanValue()))
			if (hashmapResult.get("result") != null && (((Boolean)hashmapResult.get("result")).booleanValue()))
			{
				if ( isInternalRequest("ST",stReportid) &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{
						if(alertRqdYN.equals("Y")){	
							hashmapResult.put("flag",hashmapResult.get("flag") + "~PY");
							
						}else{
							//doOnlineReportPrinting(doc_no);
							hashmapResult.put("flag",hashmapResult.get("flag") + "~PN");
						}
				 }
			}
	}

	/*if (finalized_yn.equals("Y")&& hashmapResult.get("result") != null && (((Boolean)hashmapResult.get("result")).booleanValue())) 
		{
			if (isInternalRequest("ST","STBMFGDC")) {
				String doc_no	=	(String)hashmapResult.get("doc_no");	
				doOnlineReportPrinting(doc_no);				
			}
	}*/


        return hashmapResult;
    }
	
	/*public void doOnlineReportPrinting(String doc_no) {
		try{
			String reportid = "STBMFGDC";
			if (!isInternalRequest("ST",reportid)) return;

			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_doc_no",doc_no);
			if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;

           // javax.servlet.http.HttpSession session = request.getSession(false);
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
			doOnlineLabelPrinting(doc_no);
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/

public void doOnlineReportPrinting(String doc_no,Object request,Object response) {
		try{
	
			String reportid = "STBMFGDC";
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
				

				if (!isDocTypePrintAllowed(PgetDoc_type_code)) return;

				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
				doOnlineLabelPrinting(doc_no,request,response);
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}

	/*public void doOnlineLabelPrinting(String doc_no) {
		String labeltype ="";
		String reportid  ="";
		try
		{
			//labeltype=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ASM_DTL_LABEL_TYPE_SELECT"),getItem_code()).get("LABEL_TYPE"));
			labeltype= checkForNull(getLabel_Type());
			if (labeltype.equals("2"))
			{
				 reportid = "STBMFGLS";
			}
			else 
			{
				reportid = "STBMFGLB";
			}
		}
		catch(Exception e)
		{
				e.printStackTrace() ;
		}
		try{
			
			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_doc_type_code",PgetDoc_type_code);
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_doc_no",doc_no);
		//	javax.servlet.http.HttpSession session = request.getSession(false);
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

public void doOnlineLabelPrinting(String doc_no,Object request,Object response) {

		ecis.utils.OnlineReports onlineReports 	= null;
		ecis.utils.OnlineReport report2			= null;
		String labeltype						= "";
		String reportid							= "";
		String no_of_labels_					= "";
		String print_on_label					= "N";
		boolean print_label_online              = true;  //added by Rabbani #inc no:46817(RUT-SCF-0324.1) on 10-Feb-2014

		no_of_labels_ = checkForNull(getNo_of_labels());//Added by Rabbani #Inc no : 38900 on 23-Mar-2013 
		labeltype	  = checkForNull(getLabel_Type());
	try {	
         trn_type = "MFG";
         if(isBarCodeApplicable(getLoginFacilityId(),trn_type)){   //added by Rabbani #inc no:46817(RUT-SCF-0324.1)
			if(no_of_labels_.equals("") || no_of_labels_.equals("0")) 
				print_label_online = false;	
		}
		 print_on_label = checkForNull((String)(fetchRecord("SELECT  print_on_label_yn  FROM st_assembly_dtl WHERE assembly_item_code = ? AND NVL(print_on_label_yn,'N') = 'Y' ",getItem_code()).get("PRINT_ON_LABEL_YN")),"N");
	          
			// if(!no_of_labels_.equals("") && !no_of_labels_.equals("0") &&  print_on_label.equals("Y")){
			
			 if(print_label_online &&  print_on_label.equals("Y")){	//added by Rabbani #inc no:46817(RUT-SCF-0324.1) on 10-Feb-2014
				if (labeltype.equals("2")){
					 reportid = "STBMFGLS";
				}else{
					reportid = "STBMFGLB";
				}
				 System.out.println("reportid=inside=123>"+reportid);
	   
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
					onlineReports.add( report2) ;

					onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
					
			}
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
}
/*
	public void doOnlineReportPrinting(String doc_no) {
		try{
			ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports() ;
			String reportid = "STBMFGDC";
			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid,"S", getStore_code());

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

	public String getRequestType(){
			return getStaticListOptionTag("A,All;P,Pre packing;S,Standard Formulary ;E,Extemporaneous ;O,Others",getReq_type());
	}
	public String getPrepLoc(){
		String params[]={getLoginFacilityId(),getLanguageId()};
			return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_MAN_REQ_PRELOC_SELECT"),params),getPrep_loc());
	}
	public String getPrepMode(){
			return getStaticListOptionTag("A,All;S,Sterile;N,Non Sterile ;O,Others ;");//,getPrep_mode()
	}
	
	public String getRequestStore(){
		String [] params={getLoginFacilityId(),getLoginById(),getLanguageId()};
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_MAN_REQ_STORE_SELECT"),params),getPrep_mode());
	}


	public String getRequestStoreQuery(){
		String [] params={getLoginFacilityId(),getLoginById(),getLanguageId()};
		return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_MAN_REQ_STORE_QRY_SELECT"),params),getPrep_mode());
	}

	public String getBinLocation(){
			return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_MFG_RECEIPT_BIN_LOCATION"),getLanguageId()));
	}

	public HashMap getBaseProcessCost(){
		try
        {
			 HashMap hashmap = fetchRecord(getStRepositoryValue("SQL_ST_MFG_RECEIPT_ASMB_HDR"), getItem_code());
			 return hashmap;
		}
		 catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
	}

	public void getAssemblyDtlData (String req_status, String dt_frm, String dt_to , String req_frm, String req_to, String store) throws Exception{  

		
		ArrayList listRecord=new ArrayList();
		String [] alParameters={req_status,getReq_store(),getPrep_loc(),getReq_type(),getPrep_mode(),req_frm,req_to,dt_frm,dt_to,getLanguageId(),getLanguageId(),getLanguageId(),getLanguageId(),getLoginFacilityId()};
		try {
				String stSQL=getStRepositoryValue("SQL_ST_MAN_REQ_HDR_RESULT");
				listRecord = fetchRecords(stSQL.toString(),alParameters);
				DataRecordList=listRecord;
				
				
		} catch ( Exception e )	{

				e.printStackTrace() ;
				throw e ;
		} 
	}

	public void getAssemblyTempDtlData() throws Exception{ 
		ArrayList listRecord=new ArrayList();
		//ArrayList DataDtlList = new ArrayList();
		String [] alParameters;
		String stSQL;
		if(getReq_type().equals("E")){
			alParameters=new String[4] ;
			alParameters[0]=getItem_code().trim();
			alParameters[1]=getReq_store().trim();
			alParameters[2]=getLanguageId().trim();
			alParameters[3]=getLanguageId().trim();
			stSQL=getStRepositoryValue("SQL_ST_MAN_RECEIPT_ASSMBL_TEMP_DTL_RESULT");
			
			


		}
		else{
			alParameters=new String[5] ;
			alParameters[0]=getItem_code();
			alParameters[1]=getReq_store();
			alParameters[2]=getLanguageId();
			alParameters[3]=getLanguageId();
			alParameters[4]=getLanguageId();
			stSQL=getStRepositoryValue("SQL_ST_MAN_RECEIPT_ASSMBL_DTL_RESULT");
			
		}
		try {
		
				listRecord = fetchRecords(stSQL.toString(),alParameters);
				
			
				DataDtlList=listRecord;
				
				
	
		} catch ( Exception e )	{
			
				e.printStackTrace() ;
				throw e ;
		} 
   
	}
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
    public String getMfgUom(){  
    return getListOptionTag(getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ASM_DTL_MFG_UOM_LIST"),getLanguageId()),getMfg_uom());
	}
public int LinkChk(String item_code,String store_code)
	{
//	     StringBuffer sb=new StringBuffer();
		  java.util.HashMap result = new HashMap();
          String recordCount ="";
		  String [] alParameters	={item_code,store_code};
	
		try{
	            String stSQL=getStRepositoryValue("SQL_ST_ITEM_STORE_COMB_CHECK");			
			
				result = fetchRecord(stSQL,alParameters);
                recordCount =(String)result.get("COUNT");
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
	return Integer.parseInt(recordCount);
	
	
	}

	public String getDefault_trade_id() {
		HashMap hmResult =new HashMap();
		try {
			hmResult = fetchRecord(getStRepositoryValue("SQL_ST_DEFAULT_TRADE_ID"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("DFLT_TRADE_ID");
	}

	public String initDoc_type_codeList() {
        ArrayList arraylist = new ArrayList();
        arraylist.add(getLoginFacilityId());
	    arraylist.add("MFG");
	    arraylist.add(getLanguageId());
       return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST_HDR"), arraylist));
	}

	public ArrayList getDtlExpList(String item_code,String store_code) {
		int srl_no=0;
		for (int k=0;k<expDetailsList.size();k++){
					ArrayList al123	=(ArrayList)	expDetailsList.get(k);
						for (int l=0;l<al123.size();l++){
						
						HashMap  hashMap=(HashMap)al123.get(l);
				
								if(item_code.equals((String)(hashMap.get("ITEM_CODE"))) &&  
									store_code.equals((String)(hashMap.get("STORE_CODE")))) {
				
							srl_no=k;
								}
							}
				}
		ArrayList resultList=	(ArrayList)	expDetailsList.get(srl_no);
		return resultList;
	}

	public String getTradeList(String item_code,String trade_id) {

		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_MAN_RECEIPT_TRADE_DETAILS")),trade_id);
	}

	public String getTradeList(String item_code) {
		String params[]={item_code,getLanguageId()};
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRADE_DETAILS"),params),getTrade_id());
	}

	public String getBinLocationList(String store_code) {
		String params[]={store_code,getLanguageId()};
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST"),params),getBinLocation_code());
	}	
	
	public void setExpBatch(ArrayList expbatch){
		expBatchDetailsList.add(expbatch);
	}
	
	

		public void setValues (Hashtable htFormData) {
		try {
		    System.out.println("htFormData====>" +htFormData);
			setEWD((String)(htFormData.get("ex_param_days")));
			setExpiredBatch((String)(htFormData.get("expired_batch")));
			String ind = "";
		
			ind = (String)htFormData.get("index");
			int iSerialNumber = Integer.parseInt(((String)(htFormData.get("index"))));
			int temp = 0;
		//	ArrayList exp=expDetailsList;
		//	if(((String)htFormData.get("mode")).equals("2")){
			//expDetailsList=new ArrayList();
			//expDetailsList.add(exp);
			//}else{
		//	expDetailsList=new ArrayList();
		//	expDetailsList=exp;
		//	}
			
			for (int k=0;k<expDetailsList.size();k++){

					ArrayList al123	=(ArrayList)	expDetailsList.get(k);
					//System.out.println("al123===1182===>" +al123);
						for (int l=0;l<al123.size();l++){
						HashMap  hashMap=(HashMap)al123.get(l);
								if(((String)(htFormData.get("item_code"))).equals((String)(hashMap.get("ITEM_CODE"))) && ((String)(htFormData.get("store_code"))).equals((String)(hashMap.get("STORE_CODE")))) {
									
									iSerialNumber=k;
									
									((HashMap)((ArrayList)expDetailsList.get(iSerialNumber)).get(l)).remove("QTY");
									((HashMap)((ArrayList)expDetailsList.get(iSerialNumber)).get(l)).put("QTY",(String)htFormData.get("item_qty_"+temp));
									temp++;
								}
							}
				}
			((HashMap)DataDtlList.get(Integer.parseInt(ind))).remove("PREP_QTY");
			((HashMap)DataDtlList.get(Integer.parseInt(ind))).put("PREP_QTY",""+Double.parseDouble((String)(htFormData.get("item_qty_parent"))));
			
			((HashMap)DataDtlList.get(Integer.parseInt(ind))).remove("NOD");
			((HashMap)DataDtlList.get(Integer.parseInt(ind))).put("NOD",(String)(htFormData.get("nod_expiry")));
			System.out.println("DataDtlList setvalues==>" +DataDtlList);

			if(((String)htFormData.get("mode")).equals("2")){

				for(int d=0; d<DataDtlList.size(); d++){
	
				if(item_code.equals((String)(((HashMap)DataDtlList.get(d)).get("CHILD_ITEM_CODE")))) {

						((HashMap)DataDtlList.get(d)).remove("PREP_QTY");
						((HashMap)DataDtlList.get(d)).put("PREP_QTY",""+Double.parseDouble((String)(htFormData.get("item_qty_parent"))));
				}
				}
			}

				ArrayList  arSetData=(ArrayList)expDetailsList.get(iSerialNumber);
				System.out.println("arSetData===1211===>" +arSetData);

				if(refreshList.size()>0){

			/*		for(int j=0;j<refreshList.size();j++) {
						if(((String)htFormData.get("item_qty_"+j)).equals("") || ((String)htFormData.get("item_qty_"+j)).equals("0"))
						{
							refreshList.remove(j);
						}else{
						HashMap hmRow=(HashMap)refreshList.get(j) ;
						hmRow.put("index",""+iSerialNumber);
						hmRow.put("QTY", htFormData.get("item_qty_"+j));
						refreshList.set(j,hmRow);
						}
					}*/

					for(int j=0;j<refreshList.size();j++) {
						
						HashMap hmRow=(HashMap)refreshList.get(j) ;
						hmRow.put("index",""+iSerialNumber);
						hmRow.put("QTY", htFormData.get("item_qty_"+j));
						refreshList.set(j,hmRow);
						
					}
				
		ArrayList myList = new ArrayList();
		for(int j=0;j<refreshList.size();j++) {
			if(!( (String)((HashMap)refreshList.get(j)).get("QTY")).equals("")  )
					{
						myList.add(refreshList.get(j));
					}
		}

		refreshList = myList;
		arSetData=refreshList;
		
				expDetailsList.set(iSerialNumber,refreshList);
				refreshList=new ArrayList();
			}else{
								
				int siz = ((ArrayList)expDetailsList.get(iSerialNumber)).size();
				for(int j=0; j<siz;j++){
					if(((String)((HashMap)((ArrayList)expDetailsList.get(iSerialNumber)).get(j)).get("QTY")).equals("") )
					{
						((ArrayList)expDetailsList.get(iSerialNumber)).remove(j);
					}
				}
			}
				



		}
		catch(Exception e) {
			expBatchDetailsList.clear();
 			e.printStackTrace();
		}
	}

	public  String getStockYn  (String store_code,String item_code){
		String [] params={store_code,item_code};
		HashMap hmResult =new HashMap();
		try {
			hmResult = fetchRecord(getStRepositoryValue("SQL_ST_MFG_RECEIPT_STOCK_ITEM_YN"),params);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return (String)hmResult.get("STOCK_ITEM_YN");
	} 

	public void loadData (String store_code,String doc_type,String doc_no) throws Exception{ 
		//ArrayList listRecord=new ArrayList();
		//ArrayList DataDtlList = new ArrayList(); 
		//String  params[]={store_code,doc_type,doc_no,getLanguageId(),getLanguageId(),getLoginFacilityId()}; 
		try {
				//String stSQL="SELECT   A.DOC_TYPE_CODE, A.DOC_NO, A.STORE_CODE, A.ITEM_CODE, A.ITEM_QTY,A.PREPARE_LOCATION_CODE, PROCESS_LOSS_PERCENT, BATCH_ID,TO_CHAR (EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE, BIN_LOCATION_CODE,TRADE_ID, B.*, C.SHORT_DESC LOC_DESC, D.UNIT_COST,D.SHORT_DESC ITEMDESC, NVL (E.EXPIRY_YN, 'N') EXPIRY_YN,A.PREPARE_QTY, D.GEN_UOM_CODE UOM_CODE, A.REMARKS, A.PACKED_BY,A.COUNTER_CHECKED_BY,MMVW.SHORT_DESC STORE_DESC    FROM ST_MFG_HDR A,ST_MFG_REQUEST_HDR B,MM_ITEM_LANG_VW D,ST_PREPARE_LOCATION_LANG_VW C,ST_ITEM E,MM_STORE_LANG_VW MMVW WHERE A.MFG_REQUEST_NO = B.MFG_REQUEST_NO AND A.FINALIZED_YN = 'N' AND A.PREPARE_LOCATION_CODE = C.PREPARE_LOCATION_CODE(+) AND A.ITEM_CODE = D.ITEM_CODE(+) AND A.STORE_CODE =? AND A.DOC_TYPE_CODE =? AND A.ITEM_CODE = E.ITEM_CODE(+) AND A.DOC_NO = ? AND D.LANGUAGE_ID = ? AND C.LANGUAGE_ID(+) = ? AND D.LANGUAGE_ID = MMVW.LANGUAGE_ID AND A.STORE_CODE = MMVW.STORE_CODE AND MMVW.FACILITY_ID = ?  ORDER BY A.MFG_REQUEST_NO ";
				//listRecord = fetchRecords(stSQL.toString(),params);
				//DataRecordList=listRecord;
				
                String args[]={getLanguageId(),doc_no,doc_type,store_code,getLoginFacilityId(),getLoginFacilityId(),getLanguageId(),doc_no,doc_type,store_code};
				//DataDtlList= fetchRecords("SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.CHILD_ITEM_CODE, A.CHILD_ITEM_QTY COMPONENT_QTY, A.CHILD_ITEM_TRANS_QTY TRANS_QTY,ROUND (  DECODE (F.QTY_ON_HAND, 0, 0, F.ITEM_VALUE)/ DECODE (F.QTY_ON_HAND, 0, 1, F.QTY_ON_HAND),3) UNIT_COST,B.SHORT_DESC, A.DOC_SRL_NO, 'Y' MANDATORY_ITEM,B.GEN_UOM_CODE UOM_CODE, E.SHORT_DESC STOCK_UOM FROM ST_MFG_DTL A, MM_ITEM_LANG_VW B, ST_MFG_HDR D, AM_UOM_LANG_VW E, ST_ITEM_STORE F WHERE A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND A.CHILD_ITEM_CODE = B.ITEM_CODE AND PREPARATION_TYPE = 'E' AND E.UOM_CODE = B.GEN_UOM_CODE AND F.ITEM_CODE = B.ITEM_CODE AND F.STORE_CODE = D.STORE_CODE AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND D.DOC_NO=? AND  D.DOC_TYPE_CODE=? AND D.STORE_CODE=? AND D.FACILITY_ID=? UNION SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.CHILD_ITEM_CODE, A.CHILD_ITEM_QTY COMPONENT_QTY, A.CHILD_ITEM_TRANS_QTY TRANS_QTY, ROUND (  DECODE (F.QTY_ON_HAND, 0, 0, F.ITEM_VALUE) / DECODE (F.QTY_ON_HAND, 0, 1, F.QTY_ON_HAND), 3 ) UNIT_COST, B.SHORT_DESC, A.DOC_SRL_NO, MANDATORY_ITEM_YN MANDATORY_ITEM, B.GEN_UOM_CODE UOM_CODE, E.SHORT_DESC STOCK_UOM FROM ST_MFG_DTL A, MM_ITEM_LANG_VW B, ST_ASSEMBLY_DTL C, ST_MFG_HDR D, AM_UOM_LANG_VW E, ST_ITEM_STORE F WHERE A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND A.CHILD_ITEM_CODE = B.ITEM_CODE AND A.CHILD_ITEM_CODE = C.CHILD_ITEM_CODE AND D.ITEM_CODE = C.ASSEMBLY_ITEM_CODE AND PREPARATION_TYPE <> 'E' AND A.FACILITY_ID = ? AND E.UOM_CODE = B.GEN_UOM_CODE AND F.ITEM_CODE = B.ITEM_CODE AND F.STORE_CODE = D.STORE_CODE AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND D.DOC_NO=? AND  D.DOC_TYPE_CODE=? AND D.STORE_CODE=? ",args);
				/**
				 * @Name - Priya
				 * @Date - 02/06/2010
				 * @Inc# - 
				 * @Desc -    To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' the above query is modified 
				 */
				 //Commented by Rabbani #inc no:31772 on 21/09/12
				//DataDtlList= fetchRecords("SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.CHILD_ITEM_CODE, A.CHILD_ITEM_QTY COMPONENT_QTY, A.CHILD_ITEM_TRANS_QTY TRANS_QTY,TRIM(ST_DISPLAY_COST_DECIMALS (F.ITEM_CODE,F.STORE_CODE )) UNIT_COST,B.SHORT_DESC, A.DOC_SRL_NO, 'Y' MANDATORY_ITEM,B.GEN_UOM_CODE UOM_CODE, E.SHORT_DESC STOCK_UOM FROM ST_MFG_DTL A, MM_ITEM_LANG_VW B, ST_MFG_HDR D, AM_UOM_LANG_VW E, ST_ITEM_STORE F WHERE A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND A.CHILD_ITEM_CODE = B.ITEM_CODE AND PREPARATION_TYPE = 'E' AND E.UOM_CODE = B.GEN_UOM_CODE AND F.ITEM_CODE = B.ITEM_CODE AND F.STORE_CODE = D.STORE_CODE AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND D.DOC_NO=? AND  D.DOC_TYPE_CODE=? AND D.STORE_CODE=? AND D.FACILITY_ID=? UNION SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.CHILD_ITEM_CODE, A.CHILD_ITEM_QTY COMPONENT_QTY, A.CHILD_ITEM_TRANS_QTY TRANS_QTY, TRIM(ST_DISPLAY_COST_DECIMALS (F.ITEM_CODE,F.STORE_CODE )) UNIT_COST, B.SHORT_DESC, A.DOC_SRL_NO, MANDATORY_ITEM_YN MANDATORY_ITEM, B.GEN_UOM_CODE UOM_CODE, E.SHORT_DESC STOCK_UOM FROM ST_MFG_DTL A, MM_ITEM_LANG_VW B, ST_ASSEMBLY_DTL C, ST_MFG_HDR D, AM_UOM_LANG_VW E, ST_ITEM_STORE F WHERE A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND A.CHILD_ITEM_CODE = B.ITEM_CODE AND A.CHILD_ITEM_CODE = C.CHILD_ITEM_CODE AND D.ITEM_CODE = C.ASSEMBLY_ITEM_CODE AND PREPARATION_TYPE <> 'E' AND A.FACILITY_ID = ? AND E.UOM_CODE = B.GEN_UOM_CODE AND F.ITEM_CODE = B.ITEM_CODE AND F.STORE_CODE = D.STORE_CODE AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND D.DOC_NO=? AND  D.DOC_TYPE_CODE=? AND D.STORE_CODE=? ",args);
				
				//Added by Rabbani #inc no:31772 on 21/09/12
				//DataDtlList= fetchRecords("SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.CHILD_ITEM_CODE, A.CHILD_ITEM_QTY COMPONENT_QTY, A.CHILD_ITEM_TRANS_QTY TRANS_QTY,TRIM(ST_DISPLAY_COST_DECIMALS (F.ITEM_CODE,F.STORE_CODE )) UNIT_COST,B.SHORT_DESC, A.DOC_SRL_NO, 'Y' MANDATORY_ITEM,B.GEN_UOM_CODE UOM_CODE, E.SHORT_DESC STOCK_UOM FROM ST_MFG_DTL A, MM_ITEM_LANG_VW B, ST_MFG_HDR D, AM_UOM_LANG_VW E, ST_ITEM_STORE F WHERE A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND A.CHILD_ITEM_CODE = B.ITEM_CODE AND PREPARATION_TYPE = 'E' AND E.UOM_CODE = B.GEN_UOM_CODE AND F.ITEM_CODE = B.ITEM_CODE AND F.STORE_CODE = D.STORE_CODE AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND D.DOC_NO=? AND  D.DOC_TYPE_CODE=? AND D.STORE_CODE=? AND D.FACILITY_ID=? UNION SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.CHILD_ITEM_CODE, A.CHILD_ITEM_QTY COMPONENT_QTY, A.CHILD_ITEM_TRANS_QTY TRANS_QTY, TRIM(ST_DISPLAY_COST_DECIMALS (F.ITEM_CODE,F.STORE_CODE )) UNIT_COST, B.SHORT_DESC, A.DOC_SRL_NO, MANDATORY_ITEM_YN MANDATORY_ITEM, B.GEN_UOM_CODE UOM_CODE, E.SHORT_DESC STOCK_UOM FROM ST_MFG_DTL A, MM_ITEM_LANG_VW B, ST_ASSEMBLY_DTL C, ST_MFG_HDR D, AM_UOM_LANG_VW E, ST_ITEM_STORE F WHERE A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND A.CHILD_ITEM_CODE = B.ITEM_CODE AND A.CHILD_ITEM_CODE = C.CHILD_ITEM_CODE AND D.ITEM_CODE = C.ASSEMBLY_ITEM_CODE AND PREPARATION_TYPE <> 'E' AND A.FACILITY_ID = ? AND E.UOM_CODE = B.GEN_UOM_CODE AND F.ITEM_CODE = B.ITEM_CODE AND F.STORE_CODE = D.STORE_CODE AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND D.DOC_NO=? AND  D.DOC_TYPE_CODE=? AND D.STORE_CODE=? ORDER BY DOC_SRL_NO ",args);
				
				//Modified above query by sakti on 21-08-2014 against Inc #50616 to display unitcost from ST_DISPLAY_UNIT_COST function
				//Modified by suresh.r on 13-11-2014 against Inc 52256(Added 2 args to ST_DISPLAY_UNIT_COST)
				DataDtlList= fetchRecords("SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.CHILD_ITEM_CODE, A.CHILD_ITEM_QTY COMPONENT_QTY, A.CHILD_ITEM_TRANS_QTY TRANS_QTY,/*TRIM(ST_DISPLAY_COST_DECIMALS (F.ITEM_CODE,F.STORE_CODE )) UNIT_COST*/ TRIM(ST_DISPLAY_UNIT_COST (F.ITEM_CODE,SYSDATE,'CURRENT_STOCK')*ST_GET_UOM_CONV_FAC_SING_STR(F.ITEM_CODE, F.STORE_CODE)) UNIT_COST,B.SHORT_DESC, A.DOC_SRL_NO, 'Y' MANDATORY_ITEM,B.GEN_UOM_CODE UOM_CODE, E.SHORT_DESC STOCK_UOM FROM ST_MFG_DTL A, MM_ITEM_LANG_VW B, ST_MFG_HDR D, AM_UOM_LANG_VW E, ST_ITEM_STORE F WHERE A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND A.CHILD_ITEM_CODE = B.ITEM_CODE AND PREPARATION_TYPE = 'E' AND E.UOM_CODE = B.GEN_UOM_CODE AND F.ITEM_CODE = B.ITEM_CODE AND F.STORE_CODE = D.STORE_CODE AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND D.DOC_NO=? AND  D.DOC_TYPE_CODE=? AND D.STORE_CODE=? AND D.FACILITY_ID=? UNION SELECT A.DOC_TYPE_CODE, A.DOC_NO, A.CHILD_ITEM_CODE, A.CHILD_ITEM_QTY COMPONENT_QTY, A.CHILD_ITEM_TRANS_QTY TRANS_QTY, /*TRIM(ST_DISPLAY_COST_DECIMALS (F.ITEM_CODE,F.STORE_CODE )) UNIT_COST*/ TRIM(ST_DISPLAY_UNIT_COST (F.ITEM_CODE,SYSDATE,'CURRENT_STOCK')*ST_GET_UOM_CONV_FAC_SING_STR(F.ITEM_CODE, F.STORE_CODE)) UNIT_COST, B.SHORT_DESC, A.DOC_SRL_NO, MANDATORY_ITEM_YN MANDATORY_ITEM, B.GEN_UOM_CODE UOM_CODE, E.SHORT_DESC STOCK_UOM FROM ST_MFG_DTL A, MM_ITEM_LANG_VW B, ST_ASSEMBLY_DTL C, ST_MFG_HDR D, AM_UOM_LANG_VW E, ST_ITEM_STORE F WHERE A.FACILITY_ID = D.FACILITY_ID AND A.DOC_TYPE_CODE = D.DOC_TYPE_CODE AND A.DOC_NO = D.DOC_NO AND A.CHILD_ITEM_CODE = B.ITEM_CODE AND A.CHILD_ITEM_CODE = C.CHILD_ITEM_CODE AND D.ITEM_CODE = C.ASSEMBLY_ITEM_CODE AND PREPARATION_TYPE <> 'E' AND A.FACILITY_ID = ? AND E.UOM_CODE = B.GEN_UOM_CODE AND F.ITEM_CODE = B.ITEM_CODE AND F.STORE_CODE = D.STORE_CODE AND B.LANGUAGE_ID = E.LANGUAGE_ID AND B.LANGUAGE_ID = ? AND D.DOC_NO=? AND  D.DOC_TYPE_CODE=? AND D.STORE_CODE=? ORDER BY DOC_SRL_NO ",args);
				
				String args1[]={getLoginFacilityId(),getLanguageId(),getLanguageId(),getLanguageId(),doc_no,doc_type,store_code};
				//15/05/12
				expDetailsList= fetchRecords("SELECT BATCHVIEW.TRADE_ID, BATCHVIEW.QTY_ON_HAND,BATCHVIEW.USE_AFTER_EXPIRY_YN, BATCHVIEW.EXPIRY_YN, (BATCHVIEW.AVAIL_QTY+STEXP.ITEM_QTY) AVAIL_QTY, BATCHVIEW.TRADE_ID_APPLICABLE_YN, BATCHVIEW.MANUFACTURER_ID, STEXP.ITEM_QTY QTY, STEXP.ITEM_CODE, STEXP.DOC_TYPE_CODE, STEXP.DOC_NO, DOC_SRL_NO, BATCHVIEW.STORE_DESC, BATCHVIEW.TRADE_NAME, BATCHVIEW.NOD, BATCHVIEW.ITEM_DESC, BATCHVIEW.MANUFACTURER_NAME, BATCHVIEW.STORE_CODE, BATCHVIEW.SUSPENDED_YN, BATCHVIEW.ITEM_CODE, BATCHVIEW.BIN_LOCATION_CODE, TO_CHAR (BATCHVIEW.EXPIRY_DATE, 'DD/MM/YYYY') EXPIRY_DATE, BATCHVIEW.BIN_DESC, BATCHVIEW.BATCH_ID, BATCH_STATUS,BATCHVIEW.BARCODE_ID  FROM ST_BATCH_SEARCH_LANG_VIEW BATCHVIEW, ST_MFG_DTL_EXP STEXP WHERE BATCHVIEW.STORE_CODE = STEXP.STORE_CODE AND BATCHVIEW.ITEM_CODE = STEXP.ITEM_CODE AND BATCHVIEW.BATCH_ID = STEXP.BATCH_ID AND BATCHVIEW.BIN_LOCATION_CODE = STEXP.BIN_LOCATION_CODE AND BATCHVIEW.EXPIRY_DATE = STEXP.EXPIRY_DATE_OR_RECEIPT_DATE AND STEXP.FACILITY_ID = ? AND BATCHVIEW.LANGUAGE_ID = ? AND BATCHVIEW.LANG1 = ? AND BATCHVIEW.LANG2 = ? AND STEXP.DOC_NO=? AND STEXP.DOC_TYPE_CODE=? AND STEXP.STORE_CODE=? ",args1);
			//	return listRecord;
		} catch ( Exception e )	{
			
				e.printStackTrace() ;
				throw e ;
		} 
	}

	public ArrayList getHdrData (String store_code,String doc_type,String doc_no) throws Exception{ 
		ArrayList listRecord=new ArrayList();
		//ArrayList DataDtlList = new ArrayList(); 
		//17/05/12
		
		//String  params[]={store_code,doc_type,doc_no,getLanguageId(),getLanguageId(),getLoginFacilityId()}; 
		//Added by Rabbani #Inc no:38409 on 07-MAR-2013 
		String  params[]={store_code,doc_type,doc_no,getLanguageId(),getLanguageId(),getLanguageId(),getLoginFacilityId()}; 
		try {
				String stSQL=getStRepositoryValue("SQL_ST_MAN_RECEIPT_HDR_QUERY");
				listRecord = fetchRecords(stSQL.toString(),params);
				DataRecordList=listRecord;
				
             /*   String args[]={getLanguageId(),getLoginFacilityId(),getLanguageId()};
				DataDtlList= fetchRecords(getStRepositoryValue("SQL_ST_MAN_RECEIPT_DTL_QUERY"),args);
				String args1[]={getLoginFacilityId(),getLanguageId(),getLanguageId(),getLanguageId()};
				expDetailsList= fetchRecords(getStRepositoryValue("SQL_ST_MAN_RECEIPT_EXP_QUERY"),args1);*/
				
		} catch ( Exception e )	{
			
				e.printStackTrace() ;
				throw e ;
		} 
		return listRecord;
	}


	public HashMap modify(){
		//shMap hashmap = new HashMap();
		//HashMap hashmapResult = new HashMap();
	//        HashMap hmDtlScreenData = null;
			HashMap hashmapQry = new HashMap();
			ArrayList arraylist = new ArrayList();
			//HashMap hmResult=new HashMap();
	//		HashMap hmSQLMap		=	new HashMap();
			HashMap hmTableData		=	new HashMap();
	//		ArrayList alHdrData		=	new ArrayList();
			ArrayList alDtlData		=	new ArrayList();
			ArrayList alExpData		=	new ArrayList();
			HashMap hmCommonData	=	new HashMap();

			hmCommonData.put("login_by_id",getLoginById()			);
			hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
			hmCommonData.put("login_facility_id",getLoginFacilityId()	);
 

			StringTokenizer stringtokenizer = new StringTokenizer(getCheckBoxVals(), ",");
			try{
				doc_no=getDoc_no();
				HashMap hashmapHdr = (HashMap)DataRecordList.get(Integer.parseInt(getIndex()));
				
				arraylist.add(getExpiry_date());
				arraylist.add(getBatch_id());
				arraylist.add(getBinLocation_code());
				arraylist.add(getTrade_id());
				arraylist.add(getFinalized_yn());
				arraylist.add((String)hashmapHdr.get("PREPARE_LOCATION_CODE"));
				arraylist.add(checkForNull((String)hashmapHdr.get("PATIENT_ID")));
				arraylist.add(checkForNull((String)hashmapHdr.get("ENCOUNTER_ID")));
				arraylist.add(getProcess_loss_percent());
				//arraylist.add((String)hashmapHdr.get("REQUEST_QTY")); //Commented by Rabbani #Inc no:37445(RUT-CRF-0097) on 14-MAY-2013
				arraylist.add(checkForNull(getReq_qty()));
				arraylist.add(getLoginFacilityId());
				arraylist.add(getDoc_type_code());
				arraylist.add(doc_no);
				arraylist.add(checkForNull((String)hashmapHdr.get("MFG_REQUEST_NO")));  
				arraylist.add((String)hashmapHdr.get("REQUESTING_STORE_CODE"));
				arraylist.add((String)hashmapHdr.get("ITEM_CODE"));
				arraylist.add(getDoc_date());
				arraylist.add(getDoc_ref());
				arraylist.add(checkForNull((String)hashmapHdr.get("UNIT_COST")));
				arraylist.add(checkForNull((String)hashmapHdr.get("PREPARATION_TYPE")));
				arraylist.add(getComposition_for_qty());
				if(!((String)hashmapHdr.get("PREPARATION_TYPE")).equals("E"))
				arraylist.add(checkForNull((String)hashmapHdr.get("UOM_CODE")));
				else
				arraylist.add("");

               //arraylist.add(remarks);	
                arraylist.add(checkForNull(remarks_code));		//Added by Rabbani #Inc no:33352 on 18/06/12	   
				arraylist.add(packed_by);
				arraylist.add(counter);
                arraylist.add(checkForNull(getBarcode_id()));  //Added by Rabbani #Inc no:32766 on 18/05/12
				arraylist.add(checkForNull(getNo_of_labels())); //18/05/12 //26
				
				System.out.println("arraylist===modify====>" +arraylist);

				for(int i = 0; i < modDtlList.size(); i++)
				{
					HashMap hashmapDtl = (HashMap)modDtlList.get(i);
					hashmapDtl.put("mode","0");
					 if(stringtokenizer.nextToken().equals("N")){
							hashmapDtl.put("mode","2");
						/*}
					else{		
						//hashmapDtl.put("mode","0");
					}*/
					ArrayList sourceArrayList	=	getDtlExpList((String)hashmapDtl.get("CHILD_ITEM_CODE"),(String)hashmapHdr.get("REQUESTING_STORE_CODE"));
				
					if (sourceArrayList!=null) 
						for (int k=0;k<sourceArrayList.size(); k++ ) {
							HashMap hmExpRecord	=	(HashMap)sourceArrayList.get(k);
							System.out.println("hmExpRecord:1402==modify=>" +hmExpRecord);
							hmExpRecord.put("doc_srl_no",""+(i+1));
							hmExpRecord.put("unit_cost",hashmapDtl.get("UNIT_COST"));
							hmExpRecord.put("UOM_CODE",hashmapDtl.get("UOM_CODE"));
						    
							alExpData.add(hmExpRecord);
							System.out.println("alExpData:1402==modify=>" +alExpData);
						}
				      }else{		
						hashmapDtl.put("mode","0");
					   }
					  alDtlData.add(hashmapDtl);
				   }
				hmTableData.put("properties",	getProperties());
				hmTableData.put("HDR_DATA",		arraylist);
				hmTableData.put("DTL_DATA",		alDtlData);
				hmTableData.put("DTL_EXP_DATA",	alExpData);
				hmTableData.put("COMMON_DATA",	hmCommonData);
				

		}
		catch (Exception e){
			e.printStackTrace() ;
			}
		
			return methodCall(hmTableData, hashmapQry, 2);
	}
	public HashMap delete()
    {
		//HashMap hashmapResult=new HashMap();
		HashMap hashmapQry=new HashMap();
		HashMap hashmap=new HashMap();
		HashMap hmCommonData=new HashMap();
		ArrayList  arDelData=new ArrayList();
	
		arDelData.add(getLoginFacilityId());
		arDelData.add(getDoc_type_code());
		arDelData.add(getDoc_no());

		hmCommonData.put("login_by_id",getLoginById()			);
		hmCommonData.put("login_at_ws_no",getLoginAtWsNo()		);
		hmCommonData.put("login_facility_id",getLoginFacilityId()	);

		hashmap.put("properties", getProperties());
		hashmap.put("arDelData", arDelData);
		hashmap.put("COMMON_DATA",	hmCommonData);
		return methodCall(hashmap, hashmapQry, 0);
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

//added on 26/08/04
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



	public void getAssemblyData () throws Exception{ 
		ArrayList listRecord=new ArrayList();
		String [] alParameters={getItem_code(),getReq_type(),getPrep_mode(),getLanguageId(),getLanguageId()};
		try {
				String stSQL=getStRepositoryValue("SQL_ST_ASSEMBLY_HDR_QUERY_RESULT");
				listRecord = fetchRecords(stSQL.toString(),alParameters);
				DataRecordList=listRecord;
		} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
		} 
	}

	public void getDtlData () throws Exception{ 
		ArrayList listRecord=new ArrayList();
		String [] alParameters={getItem_code(),getLanguageId(),getLanguageId(),getLanguageId()};
		try {
				String stSQL=getStRepositoryValue("SQL_ST_ASSEMBLY_DTL_QUERY_RESULT");
				listRecord = fetchRecords(stSQL.toString(),alParameters);
				DataModifyList=listRecord;
				//return listRecord;
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} 
	}


	public void setBatchDataDisp(String doc_no, String doc_type_code){
				ArrayList listRecord=new ArrayList();
				String [] alParameters={getLoginFacilityId(),doc_type_code,getDoc_no()};
			try{
					String stSQL=getStRepositoryValue("SQL_ST_ITEM_DOC_TYPE_SELECT");
					listRecord = fetchRecords(stSQL.toString(),alParameters);
					batchDataDisp = listRecord;
			}catch(Exception e){
				e.printStackTrace();
			}
			

	} 
	public ArrayList getBatchDataDisp(){ 
			
			return batchDataDisp ;
	}

	public HashMap getDataRecordListDisp(){

			ArrayList listRecord=new ArrayList();
			HashMap DataRecordList = new HashMap();
			String [] alParameters =		{getItem_code(),getItem_desc( ),getReq_type(),getPrep_mode(),getLanguageId(),getLanguageId()};		
			try {
					String stSQL=getStRepositoryValue("SQL_ST_ASSEMBLY_HDR_QUERY_RESULT");
					listRecord = fetchRecords(stSQL.toString(),alParameters);
					DataRecordList=(HashMap)listRecord.get(0);
			} catch ( Exception e )	{
					e.printStackTrace() ;
			} 
			
			return DataRecordList;
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
	public String getMFGItemClassBased(String trntype)
	{
		String chkdefaultParameters[] = {trntype,getLanguageId()};
			HashMap records			  = new HashMap();
			String result				="";
		try{
			
				//records = fetchRecord("SELECT     ITEM_CLASS_BASED_YN   FROM     st_trn_type_lang_vw   WHERE   TRN_TYPE= ? AND LANGUAGE_ID=?",chkdefaultParameters);
				records = fetchRecord(getStRepositoryValue("SQL_ST_GRN_ITEM_CLASS_BASED_YN"),chkdefaultParameters);
				result=(String)records.get("ITEM_CLASS_BASED_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts 
	public void loadHdrData(Hashtable hash){  //hdr
		HashMap hmRecord=new HashMap();
		hmRecord.put("ENCOUNTER_ID",checkForNull((String)hash.get("encounter_id")) );
		hmRecord.put("PATIENT_ID",checkForNull((String)hash.get("patient_id")) );
		hmRecord.put("SHORT_DESC",(String)hash.get("item_code_desc") );
		hmRecord.put("ITEM_CODE",(String)hash.get("item_code") );
		hmRecord.put("STOCK_UOM", stock_uom);
		hmRecord.put("PREPARE_LOCATION_CODE",(String)hash.get("prep_loc") );
		hmRecord.put("REQUESTING_STORE_CODE",(String)hash.get("store_code") );
		hmRecord.put("PREPARATION_MODE",(String)hash.get("prep_mode") );
		hmRecord.put("MFG_REQUEST_NO","" );
		hmRecord.put("PREPARATION_TYPE",(String)hash.get("req_type") );
		hmRecord.put("REQUEST_QTY",(String)hash.get("req_qty") );
		hmRecord.put("DFLT_MFG_MODE",(String)hash.get("dflt_mfg_mode"));
		//hmRecord.put("SELECTED","N" );
		hmRecord.put("PATIENT_NAME",checkForNull((String)hash.get("patient_name") ));
		hmRecord.put("REMARKS",checkForNull((String)hash.get("remarks") ));
		DataRecordList.add(hmRecord);
		DataList.add(hmRecord);
		System.out.println("DataRecordList========>" +DataRecordList);
		//seq_no++;
		//setExtemp_item_seq(""+seq_no);
	}
	
	public String getpatlength () //throws Exception
		{ 
		String patient_id_length ;
		try {
				String stSQL=getStRepositoryValue("SQL_ST_PATIENT_ID_LENGTH");
				patient_id_length = fetchRecord(stSQL.toString()).get("PATIENT_ID_LENGTH").toString();
				return patient_id_length;
			} catch ( Exception e )	{
				e.printStackTrace() ;
				//throw e ;
			} 
			return null;
	}
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
	public ArrayList getEncounterData () throws Exception{ 
		ArrayList encounter=new ArrayList() ;
		String alParams[]={getLoginFacilityId(),getPatient_id()};
		try {
				String stSQL=getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST_1");
				encounter = fetchRecords(stSQL.toString(),alParams);
				return encounter;
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} 
	}
	public String getEncounter_id_List(){
		String stParameters[]={getLoginFacilityId(),getPatient_id()};
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_MAN_REQ_ENCOUNTER_SELECT_LIST_1"), stParameters),getEncounter_id());
	}
	
	 public String getPatientName()
    {
        try
        {
		 
            HashMap hashmap = fetchRecord(getStRepositoryValue("SQL_ST_MAN_REQ_PATIENT_SELECT_SINGLE"), getPatient_id());
            return (String)hashmap.get("PATIENT_NAME");
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
	public void setValForArrayList(Hashtable hash,String stock_uom,String mfg_desc ){
		HashMap hmRecord=new HashMap();
		hmRecord.put("CHILD_ITEM_CODE",(String)hash.get("child_item_code") );
		hmRecord.put("COMPONENT_QTY",(String)hash.get("component_qty") );
		hmRecord.put("SHORT_DESC",(String)hash.get("child_item_code_desc") );
		hmRecord.put("MFG_UOM_CODE",(String)hash.get("mfg_uom") );
		hmRecord.put("STOCK_UOM", stock_uom);
		hmRecord.put("MFG_DESC",mfg_desc);
		hmRecord.put("UOM_CODE",(String)hash.get("uom_code") );
		hmRecord.put("MFG_REQUEST_NO","" );
		hmRecord.put("DATATYPE","ND" );
		hmRecord.put("SELECTED","N" );
		hmRecord.put("MANDATORY_ITEM", "E");
		hmRecord.put("PREP_QTY", (String)hash.get("component_qty"));
		hmRecord.put("CONV_FACTOR", (String)hash.get("tmp_conv"));
		hmRecord.put("UNIT_COST", (String)hash.get("unit_cost"));
		DataList.add(hmRecord);
		DataDtlList.add(hmRecord);
	}
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
	public void setValForArrayListModify(Hashtable hash,String stock_uom,String mfg_desc,int index ){
		HashMap hmRecord	=	(HashMap)DataList.get(index);
		hmRecord.put("CHILD_ITEM_CODE",(String)hash.get("child_item_code") );
		hmRecord.put("COMPONENT_QTY",(String)hash.get("component_qty") );
		hmRecord.put("SHORT_DESC",(String)hash.get("child_item_code_desc") );
		hmRecord.put("MFG_UOM_CODE",(String)hash.get("mfg_uom") );
		hmRecord.put("MFG_DESC",mfg_desc);
		hmRecord.put("STOCK_UOM", stock_uom);
		hmRecord.put("UOM_CODE",(String)hash.get("uom_code") );
		DataList.set(index,hmRecord);
		DataDtlList.set(index,hmRecord);
		//System.out.println("DataDtlList 1789===>" +DataDtlList);
	}
	
	 //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
	public void loadHdrData(Hashtable hash,String stock_uom,String patient_name ){
		HashMap hmRecord=new HashMap();
		hmRecord.put("ENCOUNTER_ID",checkForNull((String)hash.get("encounter_id")) );
		hmRecord.put("PATIENT_ID",checkForNull((String)hash.get("patient_id")) );
		hmRecord.put("SHORT_DESC",(String)hash.get("item_code_desc") );
		hmRecord.put("ITEM_CODE",(String)hash.get("item_code") );
		hmRecord.put("STOCK_UOM", stock_uom);
		hmRecord.put("PREPARE_LOCATION_CODE",(String)hash.get("prep_loc") );
		hmRecord.put("REQUESTING_STORE_CODE",(String)hash.get("store_code") );
		hmRecord.put("PREPARATION_MODE",(String)hash.get("prep_mode") );
		hmRecord.put("MFG_REQUEST_NO","" );
		hmRecord.put("PREPARATION_TYPE",(String)hash.get("req_type") );
		hmRecord.put("REQUEST_QTY",(String)hash.get("req_qty") );
		hmRecord.put("DATATYPE","ND" );
		hmRecord.put("SELECTED","N" );
		hmRecord.put("PATIENT_NAME",patient_name );
		hmRecord.put("REMARKS",checkForNull((String)hash.get("remarks") ));
		hmRecord.put("DFLT_MFG_MODE", "D");
		
		DataRecordList.add(hmRecord);
		 
		//System.out.println("DataRecordList=======1819===>" +DataRecordList);
		
		seq_no++;
		setExtemp_item_seq(""+seq_no);
	}
	
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts
	public void  setCheckBox(String itemCode,String seq_no,String checkVals){
			for	(int i	=0;	i<DataList.size();i++){
			HashMap hmRecord	=(HashMap)	DataList.get(i);
		//	if(((String)hmRecord.get("MFG_REQUEST_NO")).equals(seq_no)){
				StringTokenizer stringtokenizerIc = new StringTokenizer(itemCode, ",");
				for (; stringtokenizerIc.hasMoreElements();) {
					if((stringtokenizerIc.nextToken()).equals((String)hmRecord.get("CHILD_ITEM_CODE"))){
						hmRecord.put("SELECTED", "Y");
						DataList.set(i,hmRecord);
						DataDtlList.remove(i);
						DataList.remove(i);
						break;
					}
				}
				StringTokenizer stringtokenizerCv = new StringTokenizer(checkVals, ",");
				for (; stringtokenizerCv.hasMoreElements();) {
					if((stringtokenizerCv.nextToken()).equals((String)hmRecord.get("CHILD_ITEM_CODE"))){
						hmRecord.put("SELECTED", "N");
						DataList.set(i,hmRecord);
						break;
					}
				}
			//}
		}
	}
	//ends
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 
	public  HashMap checkAssemblydtl(String item_code){
		try
        {
		    HashMap hashmap = fetchRecord(getStRepositoryValue("SQL_ST_MAN_REQ_CHECK_ASSEMB_DTL"), item_code);
            return hashmap;
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        return null;
	}
	 
	  //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 08-FEB-2013 Starts 
		public ArrayList getHdrQueryData(String store_code,String doc_type,String doc_no) throws Exception{ //Query mode Result page
		ArrayList listRecord=new ArrayList();
		String  params[]={store_code,doc_type,doc_no,getLanguageId(),getLanguageId(),getLanguageId(),getLoginFacilityId()}; 
		try {
				String stSQL=getStRepositoryValue("SQL_ST_MAN_RECEIPT_HDR_QUERY_DIRECT_MFG");
				listRecord = fetchRecords(stSQL.toString(),params);
				DataRecordList=listRecord;
				
		 }catch(Exception e){
				e.printStackTrace() ;
				throw e ;
		} 
		return listRecord;
	}
	 //Added by Rabbani #Inc no :40572 (Ref:37445(RUT-CRF-0097)) on 05-JUN-2013
	public boolean MFG_PROCESS_LOSS_NA(String trn_type)  throws Exception {
        boolean flag  = false;

        try {
            String stSQL = eST.Common.StRepository.getStKeyValue("SQL_ST_TRANS_APPL_FOR_MFG_PROCESS_LOSS_NA");
			String stArray[] = {trn_type};
			flag = fetchRecord(stSQL, stArray).get("BARCODE_APPL").toString().equals("MFG_PROCESS_LOSS_NA");
			}
           catch(Exception exception) {
			flag  = false;
         }
         return flag;
     }
	public String getFinalize_allowed_yn(String stStore_code) throws Exception{
		String stParameters[]	=	{getLoginById(), stStore_code};
		HashMap hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE"),stParameters);
		return hmRecord.get("MFG_FINALIZE_ALLOWED_YN").toString();
	}
	//Added for ML-MMOH-CRF-1909
	public HashMap getShelfLifeTime(String item_code){
		Connection connection			= null ;
		PreparedStatement pstmt			= null ;
		ResultSet resultSet				= null ;
		String shelf_life_value	= "";
		String shelf_life_flag="";
		HashMap hmshelfTemp=new HashMap();
		
		try{
			connection = getConnection() ;

			pstmt			= connection.prepareStatement("select SHELF_LIFE_FLAG,SHELF_LIFE_VALUE from ST_ASSEMBLY_HDR  where item_code= ?") ;
			pstmt.setString(1,item_code);
			
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				shelf_life_value=  checkForNull(resultSet.getString("SHELF_LIFE_VALUE"));		
				shelf_life_flag=  checkForNull(resultSet.getString("SHELF_LIFE_FLAG"));		
				hmshelfTemp.put("SHELF_LIFE_VALUE",shelf_life_value);
				hmshelfTemp.put("SHELF_LIFE_FLAG",shelf_life_flag);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		} 
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return hmshelfTemp;
	}

	public String setExpiryDate(String formate,String time){
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null;
		String sql="";
		String newdate="";
		try{
			connection	= getConnection() ;
			// pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT25") ) ;
			if(formate.equals("W")){
				int timeInt=Integer.parseInt(time)*7;
				sql="select sysdate, to_char(sysdate + interval '"+timeInt+"' DAY(4),'DD/MM/RRRR')newdate FROM dual";
			}
			else if(formate.equals("D")){
				sql="select sysdate, to_char(sysdate + interval  '"+time+"'  DAY(3),'DD/MM/RRRR')newdate FROM dual";
			}
			else if(formate.equals("M")){
				sql="select sysdate, to_char(sysdate + interval '"+time+"' MONTH,'DD/MM/RRRR')newdate FROM dual";
			}
			else if(formate.equals("Y")){
				sql="select sysdate, to_char(sysdate + interval  '"+time+"'  YEAR(3),'DD/MM/RRRR')newdate FROM dual";
			}
			pstmt		=connection.prepareStatement(sql);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet.next()){
				newdate		=	resultSet.getString("newdate");
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return newdate;
	}
	// Add ended for ML-MMOH-CRF-1909-US2
}
