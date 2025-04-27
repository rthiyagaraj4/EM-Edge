/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
1/2/2018				66368					Shazana 						  								GHL-CRF-0503 Split batch	
6/2/2018				66562					Shazana															GHL-CRF-0503 - Modified Query
16/5/2018										Shazana 														GHL-ICN-0023 - SPLIT BATCH
22/07/2019             IN070913                 Haribabu                                                        GHL-ICN-0049
--------------------------------------------------------------------------------------------------------------------------------------------
 */


package eST;

import eST.Common.StTransaction;
import eST.Common.StRepository;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;

// Referenced classes of package eST.Common:
//		StAdapter, StRepository

/**
* Class to hold the exp detail records. All the records has been kept in the
* form of HashMaps in an arraylist. 
*/

public class BatchSearchBeanForBarcode extends StTransaction implements Serializable {
	private ArrayList DataList=new ArrayList();
	private ArrayList selectedList;

	private String item_code_from="";
	private String item_code_to="";
	private String store_code_from="";
	private String store_code_to="";
	private String manufacturer_code="";
	private String period_of_expiry="";
	private String includeZeroStockBatches="N";
	private String includeExpiredBatches="N";
	private String includeSuspendedBatches="N";
	private String searchFunction="N";
	private String multipleSelect="N";
	private String cuttOffDate="";
	private String maxAllowed="1";
	private String batch_id="";
	private String Trade_code="";
	//private String language_id="";
	//private boolean search=true;
	private boolean bSortDesc =false;
	//private String user_name="";

	//private String user_name  =  (String) session.getValue( "login_user" ) ;

	private String item_class_from="";
	private String item_class_to="";
	private String drug_type="";
	/*Added for GHL-CRF-0503 START*/
	private String allow_zero_batches;
	//added for GHL-CRF-0531 START
	
	private String srcBatchid;
	private String srcExpDate;
	private String srcStoreCode;//added for GHL-CRF-0531 fix*/


	public String getSrcStoreCode() {
		return srcStoreCode;
	}

	public void setSrcStoreCode(String srcStoreCode) {
		this.srcStoreCode = srcStoreCode;
	}

	public String getSrcBatchid() {
		return srcBatchid;
	}

	public void setSrcBatchid(String srcBatchid) {
		this.srcBatchid = srcBatchid;
	}

	public String getSrcExpDate() {
		return srcExpDate;
	}

	
	public void setSrcExpDate(String srcExpDate) {
		this.srcExpDate = srcExpDate;
	}
	//added for GHL-CRF-0531 END
	public String getAllow_zero_batches() {
		return allow_zero_batches;
	}

	public void setAllow_zero_batches(String allow_zero_batches) {
		this.allow_zero_batches = allow_zero_batches;
	}
	/*Added for GHL-CRF-0503 END*/
	public String getManufacturerList() {
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_AM_MANUFACTURER_LIST"),getLanguageId()));
	}

	public void toggleSort(){
		bSortDesc =!bSortDesc ;
	}

	public boolean getSortDesc(){
		return bSortDesc ;
	}


	public void setCuttOffDate(String cuttOffDate) {
		 this.cuttOffDate = checkForNull(cuttOffDate,"");
	}

	public String getCuttOffDate( ) {
		 return cuttOffDate;
	}
	
	/*public void setLanguageId(String language_id) {
		 this.language_id = checkForNull(language_id,"");
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
	public void setIncludeZeroStockBatches(String includeZeroStockBatches) {
		 this.includeZeroStockBatches = checkForNull(includeZeroStockBatches,"N");
	}

	public String getIncludeZeroStockBatches( ) {
		 return includeZeroStockBatches;
	}

	public void setMaxAllowed(String maxAllowed) {
		 this.maxAllowed = checkForNull(maxAllowed,"1");
	}

	public String getMaxAllowed( ) {
		 return maxAllowed;
	}

	public void setBatch_id(String batch_id) {
		 this.batch_id = checkForNull(batch_id,"");
	}

   public void setTrade_Code(String Trade_code) {
		 this.Trade_code = checkForNull(Trade_code,"");
	}
 
	public String getBatch_id( ) {
		 return batch_id;
	}
	
	public String getTrade_Code( ) {
		 return Trade_code;
	}
	/*public void setUser_name(String user_name) {
		 this.user_name = checkForNull(user_name,"");
	}

	public String getUser_name( ) {
		 return user_name;
	}*/

	public void setSearchFunction(String searchFunction) {
		 this.searchFunction = checkForNull(searchFunction,"N");
	}

	public String getSearchFunction( ) {
		 return searchFunction;
	}

	public void setMultipleSelect(String multipleSelect) {
		 this.multipleSelect = checkForNull(multipleSelect,"N");
	}

	public String getMultipleSelect( ) {
		 return multipleSelect;
	}

	public void setIncludeExpiredBatches(String includeExpiredBatches) {
		 this.includeExpiredBatches= checkForNull(includeExpiredBatches,"N");
	}

	public String getIncludeExpiredBatches( ) {
		 return includeExpiredBatches;
	}

	public void setIncludeSuspendedBatches(String includeSuspendedBatches) {
		 this.includeSuspendedBatches= checkForNull(includeSuspendedBatches,"N");
	}

	public String getIncludeSuspendedBatches( ) {
		 return includeSuspendedBatches;
	}

	public void setItem_code_from(String item_code_from) {
		 this.item_code_from = checkForNull(item_code_from);
	}

	public String getItem_code_from( ) {
		 return item_code_from;
	}

	public void setItem_code_to(String item_code_to) {
		 this.item_code_to = checkForNull(item_code_to);
	}

	public String getItem_code_to( ) {
		 return item_code_to;
	}

	public void setStore_code_from(String store_code_from) {
		 this.store_code_from = checkForNull(store_code_from);
	}

	public String getStore_code_from( ) {
		 return store_code_from;
	}

	public void setStore_code_to(String store_code_to) {
		 this.store_code_to = checkForNull(store_code_to);
	}

	public String getStore_code_to( ) {
		 return store_code_to;
	}

	public void setManufacturer_code(String manufacturer_code) {
		 this.manufacturer_code = checkForNull(manufacturer_code);
	}

	public String getManufacturer_code( ) {
		 return manufacturer_code;
	}

	public void setPeriod_of_expiry(String period_of_expiry) {
		this.period_of_expiry = checkForNull(period_of_expiry);
	}
	public String getPeriod_of_expiry( ) {
		 return period_of_expiry;
	}

	

	public void setItemClassFrom(String item_class_from) {
		 this.item_class_from = checkForNull(item_class_from);
	}

	public String getItemClassFrom() {
		 return item_class_from;
	}

	public void setItemClassTo(String item_class_to) {
		 this.item_class_to = checkForNull(item_class_to);
	}
	public String getItemClassTo() {
		 return item_class_to;
	}

	public void setDrugType(String drug_type) {
		 this.drug_type = checkForNull(drug_type);
	}

	public String getDrugType() {
		 return drug_type;
	}




	public void loadResultPage(String doc_type_code,String doc_no,String trn_type,String barcode) throws Exception {
		ArrayList alParameters	=	new ArrayList();
		ArrayList listRecord	=	new ArrayList();
		String stSQL			=	"";
		//String item_adj_type	=	"N";
		//String function_id = getFunctionId();//doc no always be null for barcode
		DataList = new ArrayList();

		String barcode_new		= "";
		try {
				barcode_new = "%" + barcode + "%";

				alParameters.add(checkForNull(((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", store_code_from)).get("FACILITY_ID")),getLoginFacilityId()));
				alParameters.add(doc_type_code);
				alParameters.add(doc_no);
				alParameters.add(trn_type);
				alParameters.add(item_code_from);
				alParameters.add(item_code_to);
				alParameters.add(store_code_from);
				alParameters.add(store_code_to);
				alParameters.add(manufacturer_code);
				alParameters.add(includeZeroStockBatches);
				alParameters.add(checkForNull(((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", store_code_from)).get("FACILITY_ID")),getLoginFacilityId()));
				alParameters.add(doc_type_code);
				alParameters.add(doc_no);
				alParameters.add(trn_type);
				alParameters.add(includeExpiredBatches);
				alParameters.add(cuttOffDate);
				alParameters.add(period_of_expiry);
				alParameters.add(includeSuspendedBatches);
				alParameters.add(batch_id);
				alParameters.add(getLanguageId());
				alParameters.add(getLanguageId());
				alParameters.add(getLanguageId());
				alParameters.add(Trade_code);
				alParameters.add(checkForNull(((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", store_code_from)).get("FACILITY_ID")),getLoginFacilityId()));
				alParameters.add(drug_type);
				alParameters.add(item_class_from);
				alParameters.add(item_class_to);
				alParameters.add(barcode_new);
					
			//	stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  (avail_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code)) avail_qty,expiry_yn,batch_status,SUSPENDED_YN  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty +ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code) >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( use_after_expiry_yn='Y' and (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                FROM st_item WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  ( SELECT 'X'   FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~'))  and BARCODE_ID like (?) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy') "; Added Barcode_id for GHL-CRF-0413
				stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  (avail_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code)) avail_qty,expiry_yn,batch_status,SUSPENDED_YN,BARCODE_ID  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty +ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code) >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( use_after_expiry_yn='Y' and (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                FROM st_item WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  ( SELECT 'X'   FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~'))  and BARCODE_ID like (?) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy') ";
			

			int no_of_decimals=getNoOfDecimals();
			String allow_decimals_yn="N";
			System.out.println("alParameters=============273"+alParameters);
			System.out.println("stSQL.toString()=============273"+stSQL.toString());

			listRecord			=		fetchRecords(stSQL.toString(),alParameters);

			System.out.println("listRecord=============273"+listRecord);

			if(item_code_from.equals(item_code_to)){
			allow_decimals_yn=getAllowDecimalsYN(item_code_from);
			}
			for(int i=0;i<listRecord.size();i++){
			HashMap dataList		=		(HashMap)listRecord.get(i);
			if(!item_code_from.equals(item_code_to)){
			allow_decimals_yn=getAllowDecimalsYN((String)dataList.get("ITEM_CODE"));
			}
			if(allow_decimals_yn.equals("Y")){
			dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),no_of_decimals));
			dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),no_of_decimals));
			}else{
			dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),0));
			dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),0));
			}
			dataList.put("ALLOW_DECIMALS_YN",allow_decimals_yn);
			listRecord.set(i,dataList);
			}

			DataList			=		listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}
//Added against GHL-CRF-0446 starts
	public void loadResultPage(String doc_type_code,String doc_no,String trn_type,String barcode, String src_batch_id, String src_bin_location_code, String src_expiry_date , String allow_zero_batches, String store_code) throws Exception {//Added allow_zero_batches for GHL-CRF-0503, Added store_code for IN070913
		ArrayList alParameters	=	new ArrayList();
		ArrayList listRecord	=	new ArrayList();
		String stSQL			=	"";
		DataList = new ArrayList();
		String barcode_new		= ""; 
		System.out.println("allow_zero_batches in BatchSearchBeanForBarcode.java: "+allow_zero_batches);// Added for GHL-CRF-0503
		try {
			barcode_new = "%" + barcode + "%";
			/*Added against GHL-CRF-0503 start*/
		
			if(allow_zero_batches.equals("Y")){
				System.out.println("Inside allow_zero_batches");
								
				alParameters.add(getLanguageId());
				
				alParameters.add(item_code_from); 
				
				
				alParameters.add(item_code_from); 
				alParameters.add(getLanguageId());
				alParameters.add(item_code_from); 

				/*ADDED AGAINST 66562 FOR GHL-CRF-0503 START*/
				alParameters.add(item_code_from); 
				alParameters.add(item_code_from);
				
				/*ADDED AGAINST 66562 FOR GHL-CRF-0503 END*/
				
				alParameters.add(item_code_from); 
				//Modified for IN070913 start
				alParameters.add(item_code_from);
				alParameters.add(store_code);
				System.out.println("store_code_from .. >>"+store_code);
				/*ADDED AGAINST 66562 FOR GHL-CRF-0503 END*/

			//	alParameters.add(item_code_from); 
				
				
				//alParameters.add(item_code_from); 
				
			//	alParameters.add(getLanguageId()); REMOVED for IN070913 
			//	alParameters.add(getLanguageId()); Removed for IN070913 
			//	alParameters.add(getLanguageId()); for IN070913 
				
				//alParameters.add(item_code_from);  for IN070913 
				
			//	alParameters.add(includeExpiredBatches);Removed for IN070913
				//alParameters.add(item_code_from);//added for ghl-icn-0035
				
				alParameters.add(batch_id);
				alParameters.add(Trade_code);
				alParameters.add(manufacturer_code);
				
				alParameters.add(includeSuspendedBatches);//ADDED against 66562 FOR GHL-CRF-0503
				 
				alParameters.add(src_batch_id);
				alParameters.add(src_bin_location_code);
				alParameters.add(src_expiry_date);

  
				System.out.println("added for Removed for IN070913 alParameters1: tuned query"+alParameters);
				//query modified  for ghl-icn-0035 "+(String)getBatchidList(item_code_from)+"
				//stSQL		=		"SELECT ITEM_CODE,ITEM_DESC,STORE_CODE,STORE_DESC,TRADE_ID_APPLICABLE_YN,BATCH_ID,EXPIRY_DATE_OR_RECEIPT_DATE,EXPIRY_DATE,  BIN_LOCATION_CODE,BIN_DESC,TRADE_ID,TRADE_NAME,UOM_CODE,UOM_DESC,QTY_ON_HAND,NOD,MANUFACTURER_ID,MANUFACTURER_NAME,AVAIL_QTY,  EXPIRY_YN,BATCH_STATUS,SUSPENDED_YN,BARCODE_ID FROM (SELECT DISTINCT a.item_code, d.short_desc AS item_desc, c.store_code, c.short_desc AS store_desc, b.trade_id_applicable_yn, a.batch_id,a.expiry_date_or_receipt_date,  TO_CHAR            (a.expiry_date_or_receipt_date,'DD/MM/YYYY') AS expiry_date, i.bin_location_code,  (SELECT short_desc    FROM mm_bin_location_lang_vw   WHERE store_code = c.store_code   AND language_id = ?  AND bin_location_code = i.bin_location_code)  AS bin_desc,  a.trade_id, h.trade_id AS trade_name,    f.gen_uom_code AS uom_code,  (SELECT i.short_desc  FROM am_uom_lang_vw i  WHERE i.uom_code = f.gen_uom_code   AND i.language_id = e.language_id) uom_desc,    NVL (DECODE (h.qty_on_hand,   NULL, 0,  (SELECT qty_on_hand  FROM st_item_batch   WHERE item_code = ?  AND store_code = c.store_code   AND batch_id = a.batch_id      AND expiry_date_or_receipt_date =  a.expiry_date_or_receipt_date   AND bin_location_code = i.bin_location_code) ), 0 ) qty_on_hand, TRUNC (a.expiry_date_or_receipt_date - SYSDATE) + 1 nod,  (SELECT manufacturer_id  FROM mm_item  WHERE item_code = ?) AS manufacturer_id, (SELECT short_name   FROM am_manufacturer_lang_vw    WHERE language_id = ?    AND manufacturer_id IN (SELECT manufacturer_id  FROM mm_item   WHERE item_code = ?))  AS manufacturer_name,  (NVL (DECODE  (h.qty_on_hand, NULL, 0,  (SELECT NVL (qty_on_hand, 0)- NVL (committed_qty, 0)  FROM st_item_batch  WHERE item_code = ?  AND store_code = c.store_code   AND batch_id = a.batch_id  AND expiry_date_or_receipt_date = a.expiry_date_or_receipt_date  AND bin_location_code =  i.bin_location_code) ), 0 ) ) avail_qty, b.expiry_yn, a.batch_status, NVL (DECODE (h.suspended_yn,  NULL, 'N',  (SELECT suspended_yn   FROM st_item_batch   WHERE item_code = ?   AND store_code = c.store_code  AND batch_id = a.batch_id  AND expiry_date_or_receipt_date = a.expiry_date_or_receipt_date   AND bin_location_code =  i.bin_location_code)  ),  'N'  ) suspended_yn,   a.barcode_id  FROM st_batch_control a,  st_item b,  mm_store c,   mm_item d,  am_trade_name_lang_vw e,  mm_item_lang_vw f,  am_manufacturer_lang_vw g, st_item_batch h, (SELECT DISTINCT aa.expiry_date_or_receipt_date,   bb.bin_location_code, aa.item_code,   cc.store_code, aa.batch_id   FROM st_batch_control aa,  st_item_trn_dtl bb,  st_item_store cc  WHERE aa.item_code = bb.item_code    AND aa.batch_id = bb.batch_id  AND aa.expiry_date_or_receipt_date =   bb.expiry_date  AND cc.store_code = bb.store_code   AND aa.item_code = cc.item_code) i   WHERE i.store_code = c.store_code       AND i.batch_id = a.batch_id   AND i.item_code = a.item_code  AND a.item_code = ?  AND a.item_code = b.item_code   AND a.item_code = d.item_code   AND a.item_code = f.item_code    AND e.trade_id = a.trade_id   AND e.language_id = ?  AND f.language_id = ?   AND g.language_id = ?  AND e.manufacturer_id = g.manufacturer_id  AND a.grn_doc_type_code IS NOT NULL   AND a.grn_doc_no IS NOT NULL  AND h.store_code = c.store_code  AND a.item_code = h.item_code  AND suspended_yn = 'N'   AND a.trade_id = h.trade_id  AND ( (? = 'Y')  OR a.expiry_date_or_receipt_date >= TRUNC (SYSDATE)  ) AND a.batch_id IN ("+(String)getBatchidList(item_code_from)+") AND UPPER (a.batch_id) LIKE UPPER (?)  AND a.trade_id LIKE NVL (?, '%')   AND e.manufacturer_id LIKE NVL (UPPER (?), '%')   AND a.expiry_date_or_receipt_date = i.expiry_date_or_receipt_date    ORDER BY item_code, store_desc) cs  WHERE (? = 'Y' OR (suspended_yn) = 'N')  AND (cs.batch_id <> ? OR cs.bin_location_code <> ? OR cs.expiry_date <> ?  ) ORDER BY expiry_date_or_receipt_date,batch_id";//MODIFIED FOR GHL-CRF-0531 END	removed for IN070913 
				stSQL		=		"SELECT item_code, item_desc, store_code, store_desc, trade_id_applicable_yn, batch_id, expiry_date_or_receipt_date, expiry_date, bin_location_code, bin_desc, trade_id, trade_name, uom_code, uom_desc, qty_on_hand, nod, manufacturer_id, manufacturer_name, avail_qty, expiry_yn, batch_status, suspended_yn, barcode_id FROM ( select DISTINCT i.item_code, d.short_desc AS item_desc, c.store_code, c.short_desc AS store_desc, b.trade_id_applicable_yn, i.batch_id, i.expiry_date_or_receipt_date, TO_CHAR (i.expiry_date_or_receipt_date, 'DD/MM/YYYY' ) AS expiry_date, i.bin_location_code, (SELECT short_desc FROM mm_bin_location_lang_vw WHERE store_code = c.store_code AND language_id = ? AND bin_location_code = i.bin_location_code) AS bin_desc, a.trade_id, a.trade_id AS trade_name, d.gen_uom_code AS uom_code, (SELECT i.short_desc FROM am_uom i WHERE i.uom_code = d.gen_uom_code ) uom_desc, NVL ( (SELECT qty_on_hand FROM st_item_batch WHERE item_code = ? AND store_code = c.store_code AND batch_id = i.batch_id AND expiry_date_or_receipt_date = i.expiry_date_or_receipt_date AND bin_location_code =i.bin_location_code) , 0 ) qty_on_hand, TRUNC (i.expiry_date_or_receipt_date - SYSDATE ) + 1 nod, (SELECT manufacturer_id FROM mm_item WHERE item_code = ?) AS manufacturer_id, (SELECT short_name FROM am_manufacturer_lang_vw WHERE language_id = ? AND manufacturer_id IN (SELECT manufacturer_id FROM mm_item WHERE item_code = ?)) AS manufacturer_name, NVL ( (SELECT NVL (qty_on_hand, 0) - NVL (committed_qty, 0) FROM st_item_batch WHERE item_code = ? AND store_code = c.store_code AND batch_id = i.batch_id AND expiry_date_or_receipt_date = i.expiry_date_or_receipt_date AND bin_location_code = i.bin_location_code) , 0 ) avail_qty, b.expiry_yn, a.batch_status, NVL( (SELECT suspended_yn FROM st_item_batch WHERE item_code = ? AND store_code = c.store_code AND batch_id = i.batch_id AND expiry_date_or_receipt_date = i.expiry_date_or_receipt_date AND bin_location_code = i.bin_location_code), 'N' ) suspended_yn, a.barcode_id from st_batch_control a, st_item b, mm_store c, mm_item d, am_trade_name e, am_manufacturer g, (SELECT DISTINCT aa.expiry_date_or_receipt_date, bb.bin_location_code, aa.item_code, bb.store_code, aa.batch_id FROM st_batch_control aa, ST_GRN_DTL_EXP bb WHERE aa.item_code = bb.item_code AND aa.batch_id = bb.batch_id AND aa.expiry_date_or_receipt_date = bb.expiry_date_or_receipt_date AND bb.expiry_date_or_receipt_date >= TRUNC (SYSDATE) AND bb.ITEM_CODE=? UNION select aa.expiry_date_or_receipt_date, aa.bin_location_code, aa.item_code, aa.store_code, aa.batch_id From st_item_batch aa, ST_GRN_DTL_EXP bb WHERE aa.item_code = bb.item_code AND aa.batch_id = bb.batch_id AND aa.expiry_date_or_receipt_date = bb.expiry_date_or_receipt_date AND aa.expiry_date_or_receipt_date >= TRUNC (SYSDATE) AND aa.ITEM_CODE=? and aa.store_code = ? ) i where i.item_code =b.item_code and i.store_code = c.store_code AND i.item_code = d.item_code AND e.trade_id = a.trade_id AND e.manufacturer_id = g.manufacturer_id AND i.batch_id = a.batch_id AND i.item_code = a.item_code AND a.expiry_date_or_receipt_date = i.expiry_date_or_receipt_date AND UPPER (a.batch_id) LIKE UPPER (?) AND a.trade_id LIKE NVL (?, '%') AND e.manufacturer_id LIKE NVL (UPPER (?), '%') ORDER BY item_code, store_desc ) cs WHERE (? = 'Y' OR (suspended_yn) = 'N') AND (cs.batch_id <> ? OR cs.bin_location_code <> ? OR cs.expiry_date <> ? ) ORDER BY expiry_date_or_receipt_date, batch_id";//MODIFIED FOR GHL-CRF-0531 END	
			//Modified for IN070913 end
			
			}/*Added against GHL-CRF-0503 end*/

			else
			{
				//System.out.println("Inside allow_zero_batches=N");
				alParameters.add(checkForNull(((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", store_code_from)).get("FACILITY_ID")),getLoginFacilityId()));
				alParameters.add(doc_type_code);
				alParameters.add(doc_no);
				alParameters.add(trn_type);
				alParameters.add(item_code_from);
				alParameters.add(item_code_to);
				alParameters.add(store_code_from);
				alParameters.add(store_code_to);
				alParameters.add(manufacturer_code);
				alParameters.add(includeZeroStockBatches);
				alParameters.add(checkForNull(((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", store_code_from)).get("FACILITY_ID")),getLoginFacilityId()));
				alParameters.add(doc_type_code);
				alParameters.add(doc_no);
				alParameters.add(trn_type);
				alParameters.add(includeExpiredBatches);
				alParameters.add(cuttOffDate);
				alParameters.add(period_of_expiry);
				alParameters.add(includeSuspendedBatches);
				alParameters.add(batch_id);
				alParameters.add(getLanguageId());
				alParameters.add(getLanguageId());
				alParameters.add(getLanguageId());
				alParameters.add(Trade_code);
				alParameters.add(checkForNull(((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", store_code_from)).get("FACILITY_ID")),getLoginFacilityId()));
				alParameters.add(drug_type);
				alParameters.add(item_class_from);
				alParameters.add(item_class_to);
				alParameters.add(barcode_new);
				alParameters.add(src_batch_id);
				alParameters.add(src_bin_location_code);
				alParameters.add(src_expiry_date);
				System.out.println("alParameters: "+alParameters); 
				stSQL		=		"SELECT * from (SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	expiry_date    expiry_date_for_ord , bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  (avail_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code)) avail_qty,expiry_yn,batch_status,SUSPENDED_YN,BARCODE_ID  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty +ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code) >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( use_after_expiry_yn='Y' and (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                FROM st_item WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  ( SELECT 'X'   FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~'))  and BARCODE_ID like (?) AND a.GRN_DOC_TYPE_CODE IS NOT NULL AND A.GRN_DOC_NO IS NOT NULL ORDER BY a.item_desc,store_desc) cs where cs.batch_id <>?  or cs.bin_location_code<>? or cs.EXPIRY_DATE <> ? order by   expiry_date_for_ord,batch_id";//modified for GHL-CRF-0531
			}


			int no_of_decimals=getNoOfDecimals();
			String allow_decimals_yn="N";
			System.out.println("alParameters=============273"+alParameters);
			System.out.println("stSQL.toString()=============273"+stSQL.toString());
			listRecord			=		fetchRecords(stSQL.toString(),alParameters);
			System.out.println("listRecord=============273"+listRecord);
			if(item_code_from.equals(item_code_to)){
			allow_decimals_yn=getAllowDecimalsYN(item_code_from);
			}
			for(int i=0;i<listRecord.size();i++){
			HashMap dataList		=		(HashMap)listRecord.get(i);
			if(!item_code_from.equals(item_code_to)){
			allow_decimals_yn=getAllowDecimalsYN((String)dataList.get("ITEM_CODE"));
			}
			if(allow_decimals_yn.equals("Y")){
			dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),no_of_decimals));
			dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),no_of_decimals));
			}else{
			dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),0));
			dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),0));
			}
			dataList.put("ALLOW_DECIMALS_YN",allow_decimals_yn);
			listRecord.set(i,dataList);
			}
			//added for GHL-CRF-0531 START
			setSrcBatchid(src_batch_id);
			setSrcExpDate(src_expiry_date);
			//added for GHL-CRF-0531 END
			
			DataList			=		listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}
	//Added against GHL-CRF-0446 ends
	public ArrayList getDataList(){
		
		return DataList ;
	}
	public String getTotalAvailableQty(){
		long lQty	=	0;
		for (int i=0; i<DataList.size(); i++) {
			lQty	=lQty+Long.parseLong((String)((HashMap)DataList.get(i)).get("AVAIL_QTY"));
		}
		return ""+lQty;
	}
	public void selectedBatches(String index,String noOfCheckedRecords)
	{
		selectedList=new ArrayList();
		int i=0;
		if(noOfCheckedRecords.equals("1"))
		{
				selectedList.add((HashMap)DataList.get(Integer.parseInt(index)));
		}
		else
		{
			StringTokenizer st=new StringTokenizer (index,"!");
			while(st.hasMoreTokens())
			{
				i=Integer.parseInt(st.nextToken());
				selectedList.add((HashMap)DataList.get(i));

			}
		}

	}
		public ArrayList getSelectedList(){
		return selectedList ;
	}

	public void clear(){
		//super.clear();
		//DataList=new ArrayList();
		selectedList=new ArrayList();
	
	}
	
	public boolean isGreaterThanSysdate(String date_time) throws Exception{
		
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		boolean result			  = false; 
		//String today			  = "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_BATCH_SEARCH_DATE_VALIDATE"));
			pstmt.setString(1,date_time);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
				if(resultSet.getInt("dt_value") > 0){
					result = true;
				}
			}
            
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return result;
	}

/*public String isSuspendYN(String store_code,String item_code ,String batch_id,String bin_location_code,String expiry_date) throws Exception{
		
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		String suspend_yn		  = "";
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_BATCH_SEARCH_SUSPEND_YN"));
			pstmt.setString(1,store_code);
			pstmt.setString(2,item_code);
			pstmt.setString(3,batch_id);
			pstmt.setString(4,bin_location_code);
			pstmt.setString(5,expiry_date);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
			suspend_yn=	resultSet.getString("suspend_yn");
			}
            
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return suspend_yn;
	}*/


public ArrayList isExpiredYN(String store_code,String user_name ) throws Exception{
		
		

		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		ArrayList alexpired= new ArrayList();
		//String expired_yn		  = "";
		try {
		
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_BATCH_SEARCH_PROCESS"));
			pstmt.setString(1,store_code);
			pstmt.setString(2,user_name);
			resultSet	= pstmt.executeQuery() ;
			
			if (resultSet!=null && resultSet.next()){
			alexpired.add(resultSet.getString("PROCESS_EXPIRED_ITEMS_YN"));
			alexpired.add(resultSet.getString("PROCESS_SUSPENDED_ITEMS_YN"));
			}
            
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return alexpired;
	}

public ArrayList  checkCountRecord(String store_code,String user_name ) throws Exception{
		
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		ArrayList alcount=new ArrayList();
		
		try {
		
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_COUNT"));
			pstmt.setString(1,store_code);
			pstmt.setString(2,user_name);
			resultSet	= pstmt.executeQuery() ;
			
			if (resultSet!=null && resultSet.next()){
			String count =resultSet.getString(1);
			if(!count.equals("0"))
			  alcount=isExpiredYN(store_code,user_name);
			else
				throw new Exception("User Store combination not found..") ;

			}
            
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return alcount;
	}

//this method are used getting the result tradeid,tradedescription

	 public ArrayList getTradeId(String itemcode){
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList TradeIdArraylist =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			pstmt			 = connection.prepareStatement("SELECT a.trade_id, b.short_name FROM MM_TRADE_NAME_FOR_ITEM a, AM_TRADE_NAME b WHERE a.trade_id = b.trade_id AND b.eff_status = 'E' AND item_code =?  ORDER BY short_name") ;
            pstmt.setString(1,itemcode);
			resultSet      = pstmt.executeQuery() ;

			while (resultSet.next()) {
				HashMap Trade		=	new HashMap();
				String TRADE_ID,SHORT_NAME;
				TRADE_ID					=	resultSet.getString("TRADE_ID");
				SHORT_NAME					=	resultSet.getString("SHORT_NAME");
				Trade.put("TRADE_ID",TRADE_ID);
				Trade.put("SHORT_NAME",SHORT_NAME);
				TradeIdArraylist.add(Trade);
			}
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
		return TradeIdArraylist;
	  }


 
/*public int getEntityparam_EWDays(String ACC_ENTITY_ID) throws Exception{
		
		Connection connection	  = null;
        PreparedStatement pstmt	  = null;
        ResultSet resultSet		  = null;
		String EWDays		  = "";
		int IEWDays = 0;
		try {
            connection	= getConnection() ;
			pstmt		= connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_SELECT_EXPIRY_WARNING_DAYS"));
			pstmt.setString(1,ACC_ENTITY_ID);
			resultSet	= pstmt.executeQuery() ;
			if (resultSet!=null && resultSet.next()){
			EWDays =	resultSet.getString("EXPIRY_WARNING_DAYS");
			IEWDays = Integer.parseInt(EWDays);
			}
            
		}catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
		}
		return IEWDays;
	}*/
	public String getUseAfterExpiry(String item_code){
		String use_expiry_yn		  = "";	
		HashMap hmExpiry			  = new HashMap();
		try{
			hmExpiry = fetchRecord("SELECT USE_AFTER_EXPIRY_YN FROM ST_ITEM WHERE ITEM_CODE = ?",item_code);
		}catch(Exception e){
			use_expiry_yn = "Y";
		}
		
		if(hmExpiry.size() > 0)
			use_expiry_yn = (String)hmExpiry.get("USE_AFTER_EXPIRY_YN");

		return use_expiry_yn;

	}
public ArrayList getTradeList(String itemcodefrom,String itemcodeto){

   Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList TradeIdArraylist =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
		pstmt			 = connection.prepareStatement("select * from(SELECT distinct nvl(a.trade_id,c.DFLT_TRADE_ID) trade_id , nvl(b.short_name,c.DFLT_TRADE_ID) short_name FROM mm_trade_name_for_item a, am_trade_name_lang_vw b,mm_parameter c WHERE a.trade_id = b.trade_id(+)  AND b.LANGUAGE_ID =? AND b.eff_status = 'E' AND (item_code BETWEEN NVL (?, '!') AND NVL (?, '~')) ORDER BY short_name)") ;
            pstmt.setString(1,getLanguageId());
			pstmt.setString(2,itemcodefrom);
            pstmt.setString(3,itemcodeto);
			resultSet      = pstmt.executeQuery() ;

			while (resultSet.next()) {
			 HashMap Trade		=	new HashMap();
				String TRADE_ID,SHORT_NAME;
				TRADE_ID					=	resultSet.getString("TRADE_ID");
				SHORT_NAME					=	resultSet.getString("SHORT_NAME");
				Trade.put("TRADE_ID",TRADE_ID);
				Trade.put("SHORT_NAME",SHORT_NAME);
                TradeIdArraylist.add(Trade);
					}
		
			
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
		return TradeIdArraylist;
}
//Commentted for IN070913 start
//public String getBatchidList(String itemcode){
//	Connection connection	= null;
//	PreparedStatement pstmt = null;
//	ResultSet resultSet		= null;
//	String batch_id_list ="";
//	
//	StringBuffer sb = new StringBuffer();
//	int i =0;
//	try {
//		connection			= getConnection();
//		pstmt				= connection.prepareStatement("select DISTINCT BATCH_ID from st_item_trn_dtl where item_code=?");
//		pstmt.setString(1, itemcode);
//		resultSet	= pstmt.executeQuery();
//		if (resultSet != null) {
//			while (resultSet.next()) {
//				if(i!=0)
//					sb.append(",'");
//				else
//					sb.append("'");
//				sb.append(resultSet.getString("BATCH_ID")+"'");
//				//allbatch_idlist.add(resultSet.getString("BATCH_ID"));	
//				i++;
//			}
//		}
//	} catch(Exception e) {
//		e.printStackTrace();
//	}
//	    finally {
//		try {
//			closeResultSet(resultSet);
//			closeStatement(pstmt);
//			closeConnection(connection);
//		}
//		catch(Exception es){ 
//			es.printStackTrace();
//		}
//	}
//	System.out.println("allbatch_idlist>> Heb huli" + sb.toString());
//	return sb.toString();
//	
//}
//Commentted for IN070913 end
}
