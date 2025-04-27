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

17/1/2022	  			TFS-27751	   			Shazana     										MO-CRF-20175
25/2/2022               29023                   K Hemanth Kumar                                             Common-ICN-0091
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
import eCommon.Common.CommonBean;

// Referenced classes of package eST.Common:
//		StAdapter, StRepository

/**
* Class to hold the exp detail records. All the records has been kept in the
* form of HashMaps in an arraylist. 
*/

public class BatchSearchBean extends StTransaction implements Serializable {
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
	private boolean batchsearch_puruom_appl=false;//MO-CRF-20175
	
	//private String user_name="";

	//private String user_name  =  (String) session.getValue( "login_user" ) ;

	public boolean isBatchsearch_puruom_appl() {
		return batchsearch_puruom_appl;
	}

	public void setBatchsearch_puruom_appl(boolean batchsearch_puruom_appl) {
		this.batchsearch_puruom_appl = batchsearch_puruom_appl;
	}//MO-CRF-20175 END 
	private String item_class_from="";
	private String item_class_to="";
	private String drug_type="";
	public HashMap selQuantity =new HashMap();//Added for TH-KW-CRF-0043
	public HashMap batchSelQty =new HashMap();//Added for TH-KW-CRF-0043
	public HashMap  selQty = null;

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




	public void loadResultPage(String doc_type_code,String doc_no,String trn_type) throws Exception {
		ArrayList alParameters	=	new ArrayList();
		ArrayList listRecord	=	new ArrayList();
		String stSQL			=	"";
		String item_adj_type	=	"N";
		String function_id = getFunctionId(); 
		DataList = new ArrayList();
		int conv_factor=0;//MO-CRF-20175
		int pur_uom_qoh = 0;
		int pur_uom_avlQty = 0;
		String store_facility_id = ""; //ICN-
		try {
			if(!(doc_no.equals(""))){
				alParameters.add(getLoginFacilityId());
				alParameters.add(doc_type_code);
				alParameters.add(doc_no);
				alParameters.add(item_code_from);
				item_adj_type = (String)((HashMap)fetchRecord("SELECT ITEM_ADJ_TYPE FROM ST_ADJ_DTL WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND ITEM_CODE = ?",alParameters)).get("ITEM_ADJ_TYPE");
			}

			store_facility_id = checkForNull(((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", store_code_from)).get("FACILITY_ID")),getLoginFacilityId()); //ICN
			System.out.println("===store_facility_id - ICN==="+store_facility_id);

			alParameters = new ArrayList();
			if((checkForNull(item_adj_type,"N")).equals("N")){
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
				//alParameters.add(checkForNull(((String)((HashMap)fetchRecord("SELECT FACILITY_ID FROM MM_STORE WHERE STORE_CODE = ?", store_code_from)).get("FACILITY_ID")),getLoginFacilityId()));
				alParameters.add(store_facility_id); // ICN
				alParameters.add(drug_type);
				alParameters.add(item_class_from);
				alParameters.add(item_class_to);
				//stSQL		=		getStRepositoryValue("SQL_ST_BATCH_SEARCH_QUERY");
				
				if(function_id == null) {
					function_id = "";
				}
				if(function_id.equals("ST_STOCK_STATUS_BY_ITEM") || function_id.equals("ST_STOCK_STATUS_BY_STORE") || function_id.equals("ST_DRUG_STOCK_STATUS_BY_STORE")) {
				
				//Commented  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
				//stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  (avail_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code)) avail_qty,expiry_yn,batch_status,SUSPENDED_YN  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty +ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code) >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( /* use_after_expiry_yn='Y' and */ (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                FROM st_item WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  ( SELECT 'X'   FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";
				
				//Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
				//Commented  by Rabbani #inc no :39203 on 18-APR-2013
				//stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  (avail_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code)) avail_qty,expiry_yn,batch_status,SUSPENDED_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=a.pur_uom_code and language_id= a.language_id) pur_uom_desc  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty +ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code) >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( /* use_after_expiry_yn='Y' and */ (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                FROM st_item WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  ( SELECT 'X'   FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";
				
				//Added by Rabbani #Inc no :39203 on  18-APR-2013
				stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  (avail_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code)) avail_qty,expiry_yn,batch_status,SUSPENDED_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=a.pur_uom_code and language_id= a.language_id) pur_uom_desc, a.pur_uom_code  FROM	st_batch_search_lang_view a, mm_store_lang_vw b,st_acc_entity_param c WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty +ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code) >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( /* use_after_expiry_yn='Y' and */ (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id LIKE nvl(?,'%') and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                FROM st_item WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  ( SELECT 'X'   FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";//pur_uom_code added for MO-CRF-20175 // ICN changed decode(c.trn_across_facility_yn,'Y','%', ? to nvl(?,'%')
				}
				 else {
				//Commented  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
				//stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  (avail_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code)) avail_qty,expiry_yn,batch_status,SUSPENDED_YN  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty +ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code) >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( use_after_expiry_yn='Y' and (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                FROM st_item WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  ( SELECT 'X'   FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";
				
				//Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
				//Commented by Rabbani #Inc no :39203 on  18-APR-2013
				//stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  (avail_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code)) avail_qty,expiry_yn,batch_status,SUSPENDED_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=a.pur_uom_code and language_id= a.language_id) pur_uom_desc  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty +ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code) >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( use_after_expiry_yn='Y' and (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                FROM st_item WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  ( SELECT 'X'   FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";
				
				//Added by Rabbani #Inc no :39203 on  18-APR-2013
				//stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  (avail_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code)) avail_qty,expiry_yn,batch_status,SUSPENDED_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=a.pur_uom_code and language_id= a.language_id) pur_uom_desc  FROM	st_batch_search_lang_view a, mm_store_lang_vw b ,st_acc_entity_param c WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty +ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code) >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( use_after_expiry_yn='Y' and (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id LIKE decode(c.trn_across_facility_yn,'Y','%', ?) and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                FROM st_item WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  ( SELECT 'X'   FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";					 
				//Added barcode_id against GHL-CRF-0413
				stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  (avail_qty + ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code)) avail_qty,expiry_yn,batch_status,SUSPENDED_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=a.pur_uom_code and language_id= a.language_id) pur_uom_desc ,barcode_id ,a.pur_uom_code FROM	st_batch_search_lang_view a, mm_store_lang_vw b ,st_acc_entity_param c WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty +ST_COMM_QTY_FOR_DOCNO(?,?,?,?,a.store_code, bin_location_code, batch_id , expiry_date, item_code) >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( use_after_expiry_yn='Y' and (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id LIKE nvl(?,'%') and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                FROM st_item WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  ( SELECT 'X'   FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!') AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";//added pur_uom_code for MO-CRF-20175 // ICN changed decode(c.trn_across_facility_yn,'Y','%', ? to nvl(?,'%')
				}
			}
			else{
				alParameters.add(item_code_from);
				alParameters.add(item_code_to);
				alParameters.add(store_code_from);
				alParameters.add(store_code_to);
				alParameters.add(manufacturer_code);
				alParameters.add(includeZeroStockBatches);
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
				//Commented  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
				//stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  avail_qty avail_qty,expiry_yn,batch_status,SUSPENDED_YN  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty  >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( /* use_after_expiry_yn='Y' and */ (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                   FROM st_item   WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  (SELECT 'X' FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!')  AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";
				
				//Added  by Rabbani #inc no :35661 (PMG2012-CRF-0012) on 23/11/2012
				stSQL		=		"SELECT item_code,item_desc, a.store_code, store_desc, trade_id_applicable_yn, batch_id,	 TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	bin_location_code, bin_desc, trade_id, trade_name,	uom_code , uom_desc ,qty_on_hand, nod, manufacturer_id, manufacturer_name,  avail_qty avail_qty,expiry_yn,batch_status,SUSPENDED_YN,(SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=a.pur_uom_code and language_id= a.language_id) pur_uom_desc, a.pur_uom_code  FROM	st_batch_search_lang_view a, mm_store_lang_vw b WHERE	item_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   a.store_code BETWEEN NVL(UPPER(?),'!') AND NVL(UPPER(?),'~')	AND		   manufacturer_id LIKE	NVL(UPPER(?),'%') AND		  (?='Y' OR	avail_qty  >	0) AND	 (expiry_yn	= 'N' /*OR use_after_expiry_yn='Y'*/ OR	(expiry_yn='Y'	AND	(( /* use_after_expiry_yn='Y' and */ (?='Y')) OR	expiry_date	>= TRUNC(NVL(TO_DATE(?,'dd/mm/yyyy'),SYSDATE)))))   AND expiry_date <= TRUNC(SYSDATE)+ NVL(?,999999)	AND	(?='Y' OR suspended_yn='N') AND UPPER(batch_id) LIKE UPPER(?) AND a.language_id = ? AND a.lang1 = ? AND a.lang2 = ? and trade_id like nvl(?,'%') and a.store_code = b.store_code and b.facility_id = ? and b.language_id = a.language_id AND EXISTS  (SELECT 'X'                   FROM st_item   WHERE a.item_code = item_code  AND  drug_item_yn LIKE ?) AND EXISTS  (SELECT 'X' FROM mm_item  WHERE a.item_code = item_code AND  item_class_code BETWEEN NVL (UPPER (?), '!')  AND NVL (UPPER (?), '~')) ORDER BY a.item_desc,store_desc,to_date(expiry_date,'dd/mm/yyyy')";//added a.pur_uom_code for MO-CRF-20175
			}


				/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin

				**/
			int no_of_decimals=getNoOfDecimals();
			String allow_decimals_yn="N";
			/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end

			**/
			listRecord			=		fetchRecords(stSQL.toString(),alParameters);
			/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications begin

			**/
			
			System.out.println("module_id batch" +getModuleId());
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
			if(checkForNull(getModuleId()).equals("PH")) // //Added by Rabbani on 11-06-2014 EMR-2491
			dataList.put("QTY",setNumber((String)dataList.get("AVAIL_QTY"),no_of_decimals));
			}else{
			dataList.put("AVAIL_QTY",setNumber((String)dataList.get("AVAIL_QTY"),0));
			dataList.put("QTY_ON_HAND",setNumber((String)dataList.get("QTY_ON_HAND"),0));
			if(checkForNull(getModuleId()).equals("PH")) // //Added by Rabbani on 11-06-2014 EMR-2491
			dataList.put("QTY",setNumber((String)dataList.get("AVAIL_QTY"),0));
			}
			dataList.put("ALLOW_DECIMALS_YN",allow_decimals_yn);
			//MO-CRF-20175 START
			if(isBatchsearch_puruom_appl()){
				if((String)dataList.get("PUR_UOM_CODE")!=null){
					conv_factor = getConversionFact((String)dataList.get("ITEM_CODE"),(String)dataList.get("UOM_CODE"),(String)dataList.get("PUR_UOM_CODE") );
					int qoh  = Integer.parseInt((String)dataList.get("QTY_ON_HAND"));
					int avl_qty = Integer.parseInt((String)dataList.get("AVAIL_QTY"));
					pur_uom_qoh = qoh/conv_factor;
					pur_uom_avlQty = avl_qty/conv_factor;
					dataList.put("PUR_UOM_QOH", pur_uom_qoh); 
					dataList.put("PUR_UOM_AVL_QTY", pur_uom_avlQty); 
				}else{
					dataList.put("PUR_UOM_QOH", ""); 
					dataList.put("PUR_UOM_AVL_QTY", "");   
				}
				 
			}	//END		
			listRecord.set(i,dataList);
			}
			/** @ 
						 CRF_SRR20056-CRF-0537.1 
						 For handle the Decimals in QOH, avail_Qty Modifications end

			**/
			DataList			=		listRecord;
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} 
	}
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
	public void selectedQuantity(String sel_key,String sel_val,String row_no,String item_code){//Adding start for TH-KW-CRF-0043
	         setSelectedQTY(sel_key,sel_val,item_code);
	    if(row_no.equals("0"))
			 selQuantity = new HashMap();
		  selQuantity.put(sel_key,sel_val);
		  //System.err.println("getSelectedQuantity@@@===="+getSelectedQuantity()+"row_no=="+row_no);
	}
	public HashMap getSelectedQuantity(){
		return selQuantity ;
	}
	
	public void setSelectedQTY(String key,String value,String item_code){
		if(!getSelectedQTY().containsKey(item_code)){
		      selQty = new HashMap();
		  }else{
              HashMap selRecords =getSelectedQTY();
               selQty =(HashMap)selRecords.get(item_code);
		  }
		  System.err.println("selQtybefore@@==="+selQty);
		     selQty.put(key,value);
			 System.err.println("selQty@@==="+selQty);
		     batchSelQty.put(item_code,selQty);
			 System.err.println("batchSelQty@@==="+batchSelQty);
	}
	public HashMap getSelectedQTY(){
		     return batchSelQty;
	}
	//Adding end for TH-KW-CRF-0043

	public void clear(){
		//super.clear();
		//DataList=new ArrayList();
		selectedList=new ArrayList();
		//batchSelQty = new HashMap();//Added for TH-KW-CRF-0043
	
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
//added for GHL-CRF-0499 START
//modified for GHL-ICN-0032
public String getChallanNo(String item_code,String batch_id,String expiry_date, String storeCode){
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
	String vmi_batch_id="";//added for GHL-ICN-0030
	try {		
		if(batch_id.contains("-")){
		//COMMENTED for GHL-ICN-0030
		//	String[] arrOfStr = batch_id.split("-", 2);
		//	batchid = arrOfStr[0];
		//	challNo =arrOfStr[1];
		
		//added for GHL-ICN-0030 START
		connection=getConnection();
				pstmt		= connection.prepareStatement("select VMI_BATCH_ID from st_item_batch where item_code=? and batch_id=? and EXPIRY_DATE_OR_RECEIPT_DATE=TO_DATE(?,'DD/MM/YYYY') AND STORE_CODE= ?");
				pstmt.setString(1,item_code);
				pstmt.setString(2,batch_id);
				pstmt.setString(3,expiry_date);
				pstmt.setString(4,storeCode); //added for GHL-ICN-0032
				
				resultSet	= pstmt.executeQuery() ;
				
				
				 
				if(resultSet.next())
					vmi_batch_id=resultSet.getString("VMI_BATCH_ID");
				
				int batch_id_length=vmi_batch_id.length();
				if(batch_id_length>10)
					batch_id_length=10;
				batchid=batch_id.substring(0,batch_id_length);
				challNo=batch_id.substring(batch_id_length+2,batch_id.length());
				//added for GHL-ICN-0030 END
			//System.out.println("batch id :"+batchid); 
		}
		else{
			batchid=batch_id;
		}
		challNo = '%'+challNo+'%';
		alParameters.add(item_code);
		alParameters.add(vmi_batch_id);//added for GHL-ICN-0030
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
	if(consignmentMap.size() > 0)
		consignment_yn = (String)consignmentMap.get("CONSIGNMENT_ITEM_YN");
	return consignment_yn;
}
//added for GHL-CRF-0499 END
public int getConversionFact(String item_code,String uom_code,String pur_uom_code){
	//HashMap hmCount1			  = new HashMap();  //Common-ICN-0091
	//HashMap hmCount2			  = new HashMap();   //Common-ICN-0091  
	int  stEqvl_value1 = 0; 
	String []stParameters1=	{uom_code,pur_uom_code};
	String []stParameters2=	{uom_code,pur_uom_code,item_code};
   //	String str_am_count = "";   //Common-ICN-0091
	//String str_item_uom_count="";  //Common-ICN-0091
	int am_count= 0;
	int item_uom_count=0;
	//int conver_factor = 0;         //Common-ICN-0091
	try{
		try{
			am_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",stParameters1)).get("COUNT"));
			item_uom_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM mm_item_uom_defn where uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",stParameters2)).get("COUNT"));
		}catch(Exception e){
			am_count = 0;
			item_uom_count = 0; 
		}
		if(item_uom_count>0){
			try{
				stEqvl_value1 =Integer.parseInt((String)((HashMap)fetchRecord("SELECT (eqvl_value / eqvl_uom_qty) CONV_FACTOR FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",stParameters2)).get("CONV_FACTOR"));
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if (am_count > 0){
			try{
				stEqvl_value1 =Integer.parseInt((String)((HashMap)fetchRecord("SELECT eqvl_value  FROM am_uom_eqvl  WHERE uom_code = ? AND eqvl_uom_code = ?",stParameters1)).get("EQVL_VALUE"));
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}		
	}
	catch (Exception e){
		e.printStackTrace();
	}
	if(stEqvl_value1==0){
		stEqvl_value1 = 1; 
	}
	return stEqvl_value1;
}
}
