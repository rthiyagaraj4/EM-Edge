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
05/05/2020              IN072890               Haribabu													 NMC-JD-SCF-0050
2/7/2021				15757					Shazana														Common-ICN-0028

-------------------------------------------------------------------------------------------------------------------------------
*/
 package eST;

//import eCommon.Common.CommonAdapter;
import eST.Common.StTransaction;
import java.io.Serializable;
import java.sql.*;
import java.util.*;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Hashtable;


// Referenced classes of package eST.Common:
//		StAdapter, StRepository

/**
* Class to hold the exp detail records. All the records has been kept in the
* form of HashMaps in an arraylist. 
*/

public class BatchSearchIssueReturnBean extends StTransaction implements Serializable { 

	private ArrayList DataList=new ArrayList();
	private ArrayList selectedList;

	private String item_code_from="";
	private String item_code_to="";

	private String store_code_from="";
	private String store_code_to="";
	private String issue_doc_no="";
	//private String language_id="";

	private String searchFunction="N";
	private String multipleSelect="N";
	private String maxAllowed="1";
	//private boolean search=true;
	private boolean bSortDesc =false;

	
	public void toggleSort(){
		bSortDesc =!bSortDesc ;
	}

	public boolean getSortDesc(){
		return bSortDesc ;
	}


	public void setMaxAllowed(String maxAllowed) {
		 this.maxAllowed = checkForNull(maxAllowed,"1");
	}

	public String getMaxAllowed( ) {
		 return maxAllowed;
	}

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
	
	/*public void setLanguageId(String language_id) {
		 this.language_id = checkForNull(language_id);
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
	public void setStore_code_from(String store_code_from) {
		 this.store_code_from = checkForNull(store_code_from);
	}

	public String getStore_code_from( ) {
		 return store_code_from;
	}

	public void setIssueDocNo(String issue_doc_no) {
		 this.issue_doc_no = checkForNull(issue_doc_no);
	}

	public String getIssueDocNo( ) {
		 return issue_doc_no;
	}

	public void setStore_code_to(String store_code_to) {
		 this.store_code_to = checkForNull(store_code_to);
	}


	public void loadResultPage(String doc_type_code,String doc_no,String trn_type,String issue_doc_type_code,String seq_no) throws Exception {
	
		ArrayList alParameters=new ArrayList();
		ArrayList facParameters = new ArrayList();

		//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 beg
		String facility_new="";
		//StringBuffer sql; //commented by Rabbani on 24-Mar-2014 for chkstyles
		String IssueRetBasedOn=getIssueRetBasedOn();
		if(IssueRetBasedOn.equals("D")){//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 end
			facParameters.add(getIssueDocNo());
			facParameters.add(issue_doc_type_code);
			facParameters.add(seq_no);
	
			facility_new  = (String)((HashMap)fetchRecord("Select FACILITY_ID  from st_issue_hdr a where a.DOC_NO = ? and a.DOC_TYPE_CODE = ? and a.SEQ_NO = ?  ",facParameters)).get("FACILITY_ID");
		//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 beg
		}else{
			facility_new	=(String)((HashMap)fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_ID_SELECT"),store_code_from)).get("FACILITY_ID");
		}//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 end	

		alParameters.add(getLoginFacilityId());//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 be
		//alParameters.add(facility_new);//Commented by suresh.r on 24-01-2014 against AMS-CRF-0054 be
		alParameters.add(doc_type_code);
		alParameters.add(doc_no);
		alParameters.add(trn_type);
		alParameters.add(getLoginFacilityId());//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 be
		//alParameters.add(facility_new);//Commented by suresh.r on 24-01-2014 against AMS-CRF-0054 be
		alParameters.add(doc_type_code);
		alParameters.add(doc_no);
		alParameters.add(trn_type);
        //alParameters.add(getLoginFacilityId());
        alParameters.add(facility_new);
        alParameters.add(store_code_from);
		alParameters.add(store_code_to);
        alParameters.add(item_code_from);
        alParameters.add(getLanguageId());
        alParameters.add(getLanguageId());
      

        
				
//		ArrayList listRecord =new ArrayList();
		try {
						

		ArrayList alRecords	=null;
		HashMap hmStockItem=fetchRecord(getStRepositoryValue("SQL_ST_STOCK_ITEM_YN"),new String[]{item_code_from,store_code_to});
		if (hmStockItem.get("STOCK_ITEM_YN").toString().equals("Y")) {
			if(IssueRetBasedOn.equals("D")){//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
			alParameters.add(getLanguageId());
	        alParameters.add(getIssueDocNo());
			alParameters.add(issue_doc_type_code);
			alParameters.add(seq_no);
			//alRecords=fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RETURN_BATCH_SEARCH_QUERY"),alParameters);
		//	alRecords=fetchRecords("SELECT  DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID,IHR.ADDED_DATE,IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC,SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE,IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE,MMB1.SHORT_DESC TO_BIN_DESC,TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME,NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY) ISS_ITEM_QTY,NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)) RET_ITEM_QTY,LEAST ((  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0))- NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0))),SBV.AVAIL_QTY)+ ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE) AVAIL_QTY,IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO,IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE,ITEM_UNIT_COST, IDE.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP IDE,ST_ISSUE_HDR IHR,ST_BATCH_SEARCH_LANG_VIEW SBV,MM_BIN_LOCATION_LANG_VW MMB,MM_BIN_LOCATION_LANG_VW MMB1,ST_ISSUE_DTL IDTL,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)) + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE)) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? and IDE.seq_no=? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID  AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE  AND RETEXP.ITEM_CODE (+) = IDE.ITEM_CODE  AND ACK.SEQ_NO(+) = IDE.SEQ_NO ORDER BY IHR.ADDED_DATE",alParameters);
		//Added by suresh.r on 17-03-2014 against 047777
		//alRecords=fetchRecords("SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, LEAST((ISS_ITEM_QTY- RET_ITEM_QTY),BATCH_QTY) + AVAIL_QTY1 AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE, IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, ST_COMM_QTY_FOR_DOCNO (?, ?,?, ?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE, IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) AVAIL_QTY1, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) + ST_COMM_QTY_FOR_DOCNO (?,?, ?, ?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE, IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) ) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? AND IDE.SEQ_NO = ? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, AVAIL_QTY1, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY",alParameters);	
	//	alRecords=fetchRecords("SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, LEAST((ISS_ITEM_QTY- RET_ITEM_QTY),BATCH_QTY) + AVAIL_QTY1 AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE, IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, ST_COMM_QTY_FOR_DOCNO (?, ?,?, ?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE, IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) AVAIL_QTY1, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) + ST_COMM_QTY_FOR_DOCNO (?,?, ?, ?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE, IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) ) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? AND IDE.SEQ_NO = ? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, AVAIL_QTY1, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY ORDER BY BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC",alParameters);
		//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 beg
			//Added barcode_id against GHL-CRF-0413.3
			//alRecords=fetchRecords("SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, LEAST((ISS_ITEM_QTY- RET_ITEM_QTY),BATCH_QTY) + AVAIL_QTY1 AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO , BARCODE_ID FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE, IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, ST_COMM_QTY_FOR_DOCNO (?, ?,?, ?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE, IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) AVAIL_QTY1, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY,SBV.BARCODE_ID BARCODE_ID FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) + ST_COMM_QTY_FOR_DOCNO (?,?, ?, ?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE, IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) ) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? AND IDE.SEQ_NO = ? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, AVAIL_QTY1, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY,BARCODE_ID ORDER BY BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC",alParameters);
			alRecords=fetchRecords("SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, LEAST((ISS_ITEM_QTY- RET_ITEM_QTY),BATCH_QTY)   AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO , BARCODE_ID FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE, IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, ST_COMM_QTY_FOR_DOCNO (?, ?,?, ?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE, IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) AVAIL_QTY1, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY,SBV.BARCODE_ID BARCODE_ID FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) + ST_COMM_QTY_FOR_DOCNO (?,?, ?, ?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE, IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) ) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? AND IDE.SEQ_NO = ? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, AVAIL_QTY1, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY,BARCODE_ID ORDER BY BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC",alParameters);
			
			}else{
					alParameters.clear();
					alParameters.add(facility_new);
			        alParameters.add(store_code_from);
					alParameters.add(store_code_to);
			        alParameters.add(item_code_from);
			        alParameters.add(getLanguageId());
			        alParameters.add(getLanguageId());
					alParameters.add(getLanguageId());
					if(getMode().equals("2")){
						alParameters.add(doc_no); 
						//alRecords=fetchRecords("SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, (ISS_ITEM_QTY- RET_ITEM_QTY) + AVAIL_QTY1 AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE, IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, NVL(RETEXP.ITEM_QTY,0) AVAIL_QTY1, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) + NVL(RETEXP.ITEM_QTY,0) ) > 0 AND ((NVL (ide.iss_item_qty, 0) - NVL (ide.ret_item_qty, 0)) + NVL(RETEXP.ITEM_QTY,0)) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND (IHR.FINALIZED_YN = 'Y' OR (ihr.process_for_acknowledge = 'Y' AND NVL(ACK.RECEIVED_QTY,0)>0)) AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ?  AND RETEXP.DOC_NO(+) = ?  AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND retexp.batch_id(+) = ide.batch_id AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.TO_BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, AVAIL_QTY1, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY ORDER BY DOC_NO,SEQ_NO,BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC",alParameters);
						//Added avail_qty > 0 against IN:62770
	//					alRecords=fetchRecords("SELECT   item_code, item_desc, batch_id, added_date, issue_fm_bin_location_code, new_bin_location_code, bin_desc, bin_location_code, issue_to_bin_location_code, to_bin_desc, expiry_receipt_dt, trade_id, trade_name, iss_item_qty, LEAST ((iss_item_qty - ret_item_qty), batch_qty) + avail_qty1 avail_qty, doc_type_code, doc_no, seq_no, doc_date, item_unit_cost, doc_srl_no FROM (SELECT DISTINCT ide.item_code, sbv.item_desc item_desc, ide.batch_id, ihr.added_date, ide.bin_location_code issue_fm_bin_location_code, ide.bin_location_code new_bin_location_code, mmb.short_desc bin_desc, sbv.bin_location_code bin_location_code, ide.to_bin_location_code issue_to_bin_location_code, mmb1.short_desc to_bin_desc, TO_CHAR (ide.expiry_date_or_receipt_date, 'DD/MM/YYYY' ) expiry_receipt_dt, ide.trade_id, sbv.trade_name trade_name, NVL (ack.received_qty, ide.iss_item_qty ) iss_item_qty, NVL (ack1.received_qty, NVL (ide.ret_item_qty, 0) ) ret_item_qty, NVL (retexp.item_qty, 0) avail_qty1, ide.doc_type_code doc_type_code, ide.doc_no doc_no, ide.seq_no seq_no, TO_CHAR (ihr.doc_date, 'DD/MM/YYYY') doc_date, item_unit_cost, ide.doc_srl_no, sbv.avail_qty batch_qty FROM st_issue_dtl_exp ide, st_issue_hdr ihr, st_batch_search_lang_view sbv, mm_bin_location_lang_vw mmb, mm_bin_location_lang_vw mmb1, st_issue_dtl idtl, st_acknowledge_trn_dtl ack, st_acknowledge_trn_dtl ack1, st_issue_ret_dtl_exp retexp WHERE (  NVL (ack.received_qty, NVL (ide.iss_item_qty, 0)) - NVL ((ack1.received_qty), (NVL (ide.ret_item_qty, 0) ) ) + NVL (retexp.item_qty, 0) ) > 0 AND (  (  NVL (ide.iss_item_qty, 0) - NVL (ide.ret_item_qty, 0) ) + NVL (retexp.item_qty, 0) ) > 0 AND ide.facility_id = ? AND (    ide.facility_id = ihr.facility_id AND ide.doc_type_code = ihr.doc_type_code AND ide.doc_no = ihr.doc_no AND ide.seq_no = ihr.seq_no ) AND (   ihr.finalized_yn = 'Y' OR (    ihr.process_for_acknowledge = 'Y' AND NVL (ack.received_qty, 0) > 0 ) ) AND ihr.fm_store_code = ? AND ihr.to_store_code = ? AND (    ihr.to_store_code = sbv.store_code AND ide.item_code = sbv.item_code AND ide.batch_id = sbv.batch_id AND ide.to_bin_location_code = sbv.bin_location_code AND ide.expiry_date_or_receipt_date = sbv.expiry_date ) AND (    ihr.fm_store_code = mmb.store_code AND ide.bin_location_code = mmb.bin_location_code ) AND (    ihr.to_store_code = mmb1.store_code AND sbv.bin_location_code = mmb1.bin_location_code ) AND idtl.facility_id = ide.facility_id AND idtl.doc_type_code = ide.doc_type_code AND idtl.doc_no = ide.doc_no AND idtl.seq_no = ihr.seq_no AND idtl.item_code = ide.item_code AND ide.item_code = ? AND sbv.language_id = mmb.language_id AND sbv.language_id = mmb1.language_id AND sbv.language_id = ? AND sbv.lang1 = ? AND sbv.lang2 = ? AND retexp.doc_no(+) = ? AND ack.doc_no(+) = ide.doc_no AND ack.doc_type_code(+) = ide.doc_type_code AND ack.doc_srl_no(+) = ide.doc_srl_no AND ack.item_code(+) = ide.item_code AND ack.batch_id(+) = ide.batch_id AND ack.expiry_date_or_receipt_date(+) = ide.expiry_date_or_receipt_date AND retexp.org_doc_no(+) = ide.doc_no AND retexp.org_doc_type_code(+) = ide.doc_type_code AND retexp.org_seq_no(+) = ide.seq_no AND retexp.doc_no = ack1.doc_no(+) AND retexp.doc_type_code = ack1.doc_type_code(+) AND retexp.batch_id = ack1.batch_id(+) AND retexp.trade_id(+) = ide.trade_id AND retexp.expiry_date_or_receipt_date(+) = ide.expiry_date_or_receipt_date AND retexp.batch_id(+) = ide.batch_id AND retexp.item_code(+) = ide.item_code AND ack.seq_no(+) = ide.seq_no AND retexp.to_bin_location_code(+) = ide.bin_location_code AND sbv.avail_qty > 0) GROUP BY iss_item_qty, avail_qty1, item_code, item_desc, batch_id, added_date, issue_fm_bin_location_code, new_bin_location_code, bin_desc, bin_location_code, issue_to_bin_location_code, to_bin_desc, expiry_receipt_dt, trade_id, trade_name, doc_type_code, doc_no, seq_no, doc_date, item_unit_cost, doc_srl_no, ret_item_qty, batch_qty ORDER BY doc_no, seq_no, batch_id, expiry_receipt_dt, to_bin_desc",alParameters);//Modified for IN072890
						alRecords=fetchRecords("SELECT   item_code, item_desc, batch_id, added_date, issue_fm_bin_location_code, new_bin_location_code, bin_desc, bin_location_code, issue_to_bin_location_code, to_bin_desc, expiry_receipt_dt, trade_id, trade_name, iss_item_qty, LEAST ((iss_item_qty - ret_item_qty), batch_qty)  avail_qty, doc_type_code, doc_no, seq_no, doc_date, item_unit_cost, doc_srl_no FROM (SELECT DISTINCT ide.item_code, sbv.item_desc item_desc, ide.batch_id, ihr.added_date, ide.bin_location_code issue_fm_bin_location_code, ide.bin_location_code new_bin_location_code, mmb.short_desc bin_desc, sbv.bin_location_code bin_location_code, ide.to_bin_location_code issue_to_bin_location_code, mmb1.short_desc to_bin_desc, TO_CHAR (ide.expiry_date_or_receipt_date, 'DD/MM/YYYY' ) expiry_receipt_dt, ide.trade_id, sbv.trade_name trade_name, NVL (ack.received_qty, ide.iss_item_qty ) iss_item_qty, NVL (ack1.received_qty, NVL (ide.ret_item_qty, 0) ) ret_item_qty, NVL (retexp.item_qty, 0) avail_qty1, ide.doc_type_code doc_type_code, ide.doc_no doc_no, ide.seq_no seq_no, TO_CHAR (ihr.doc_date, 'DD/MM/YYYY') doc_date, item_unit_cost, ide.doc_srl_no, sbv.avail_qty batch_qty FROM st_issue_dtl_exp ide, st_issue_hdr ihr, st_batch_search_lang_view sbv, mm_bin_location_lang_vw mmb, mm_bin_location_lang_vw mmb1, st_issue_dtl idtl, st_acknowledge_trn_dtl ack, st_acknowledge_trn_dtl ack1, st_issue_ret_dtl_exp retexp WHERE (  NVL (ack.received_qty, NVL (ide.iss_item_qty, 0)) - NVL ((ack1.received_qty), (NVL (ide.ret_item_qty, 0) ) ) + NVL (retexp.item_qty, 0) ) > 0 AND (  (  NVL (ide.iss_item_qty, 0) - NVL (ide.ret_item_qty, 0) ) + NVL (retexp.item_qty, 0) ) > 0 AND ide.facility_id = ? AND (    ide.facility_id = ihr.facility_id AND ide.doc_type_code = ihr.doc_type_code AND ide.doc_no = ihr.doc_no AND ide.seq_no = ihr.seq_no ) AND (   ihr.finalized_yn = 'Y' OR (    ihr.process_for_acknowledge = 'Y' AND NVL (ack.received_qty, 0) > 0 ) ) AND ihr.fm_store_code = ? AND ihr.to_store_code = ? AND (    ihr.to_store_code = sbv.store_code AND ide.item_code = sbv.item_code AND ide.batch_id = sbv.batch_id AND ide.to_bin_location_code = sbv.bin_location_code AND ide.expiry_date_or_receipt_date = sbv.expiry_date ) AND (    ihr.fm_store_code = mmb.store_code AND ide.bin_location_code = mmb.bin_location_code ) AND (    ihr.to_store_code = mmb1.store_code AND sbv.bin_location_code = mmb1.bin_location_code ) AND idtl.facility_id = ide.facility_id AND idtl.doc_type_code = ide.doc_type_code AND idtl.doc_no = ide.doc_no AND idtl.seq_no = ihr.seq_no AND idtl.item_code = ide.item_code AND ide.item_code = ? AND sbv.language_id = mmb.language_id AND sbv.language_id = mmb1.language_id AND sbv.language_id = ? AND sbv.lang1 = ? AND sbv.lang2 = ? AND retexp.doc_no(+) = ? AND ack.doc_no(+) = ide.doc_no AND ack.doc_type_code(+) = ide.doc_type_code AND ack.doc_srl_no(+) = ide.doc_srl_no AND ack.item_code(+) = ide.item_code AND ack.batch_id(+) = ide.batch_id AND ack.expiry_date_or_receipt_date(+) = ide.expiry_date_or_receipt_date AND retexp.org_doc_no(+) = ide.doc_no AND retexp.org_doc_type_code(+) = ide.doc_type_code AND retexp.org_seq_no(+) = ide.seq_no AND retexp.doc_no = ack1.doc_no(+) AND retexp.doc_type_code = ack1.doc_type_code(+) AND retexp.batch_id = ack1.batch_id(+) AND retexp.trade_id(+) = ide.trade_id AND retexp.expiry_date_or_receipt_date(+) = ide.expiry_date_or_receipt_date AND retexp.batch_id(+) = ide.batch_id AND retexp.item_code(+) = ide.item_code AND ack.seq_no(+) = ide.seq_no AND retexp.to_bin_location_code(+) = ide.bin_location_code AND sbv.avail_qty > 0) GROUP BY iss_item_qty, avail_qty1, item_code, item_desc, batch_id, added_date, issue_fm_bin_location_code, new_bin_location_code, bin_desc, bin_location_code, issue_to_bin_location_code, to_bin_desc, expiry_receipt_dt, trade_id, trade_name, doc_type_code, doc_no, seq_no, doc_date, item_unit_cost, doc_srl_no, ret_item_qty, batch_qty ORDER BY doc_no, seq_no, batch_id, expiry_receipt_dt, to_bin_desc",alParameters);//Modified for IN072890
						
					}else{
	//					alRecords=fetchRecords("SELECT   ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE,ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, ISS_ITEM_QTY, (ISS_ITEM_QTY- RET_ITEM_QTY) AVAIL_QTY, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO FROM (SELECT DISTINCT IDE.ITEM_CODE, SBV.ITEM_DESC ITEM_DESC, IDE.BATCH_ID, IHR.ADDED_DATE, IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE, IDE.BIN_LOCATION_CODE NEW_BIN_LOCATION_CODE, MMB.SHORT_DESC BIN_DESC, SBV.BIN_LOCATION_CODE BIN_LOCATION_CODE, IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, MMB1.SHORT_DESC TO_BIN_DESC, TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY' ) EXPIRY_RECEIPT_DT, IDE.TRADE_ID, SBV.TRADE_NAME TRADE_NAME, NVL (ACK.RECEIVED_QTY, IDE.ISS_ITEM_QTY ) ISS_ITEM_QTY, NVL (ACK1.RECEIVED_QTY, NVL (IDE.RET_ITEM_QTY, 0) ) RET_ITEM_QTY, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO, TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST, IDE.DOC_SRL_NO,SBV.AVAIL_QTY BATCH_QTY FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, ST_BATCH_SEARCH_LANG_VIEW SBV, MM_BIN_LOCATION_LANG_VW MMB, MM_BIN_LOCATION_LANG_VW MMB1, ST_ISSUE_DTL IDTL, ST_ACKNOWLEDGE_TRN_DTL ACK, ST_ACKNOWLEDGE_TRN_DTL ACK1, ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL ((ACK1.RECEIVED_QTY), (NVL (IDE.RET_ITEM_QTY, 0) )) ) > 0 AND IDE.FACILITY_ID = ? AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND (IHR.FINALIZED_YN = 'Y' OR (ihr.process_for_acknowledge = 'Y' AND NVL(ACK.RECEIVED_QTY,0)>0)) AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? AND (    IHR.TO_STORE_CODE = SBV.STORE_CODE AND IDE.ITEM_CODE = SBV.ITEM_CODE AND IDE.BATCH_ID = SBV.BATCH_ID AND IDE.TO_BIN_LOCATION_CODE = SBV.BIN_LOCATION_CODE AND IDE.EXPIRY_DATE_OR_RECEIPT_DATE = SBV.EXPIRY_DATE ) AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND (    IHR.TO_STORE_CODE = MMB1.STORE_CODE AND SBV.BIN_LOCATION_CODE = MMB1.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND SBV.LANGUAGE_ID = MMB.LANGUAGE_ID AND SBV.LANGUAGE_ID = MMB1.LANGUAGE_ID AND SBV.LANGUAGE_ID = ? AND SBV.LANG1 = ? AND SBV.LANG2 = ?  AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) = IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND retexp.batch_id(+) = ide.batch_id AND RETEXP.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.BIN_LOCATION_CODE(+) = IDE.BIN_LOCATION_CODE ) GROUP BY ISS_ITEM_QTY, ITEM_CODE, ITEM_DESC, BATCH_ID, ADDED_DATE, ISSUE_FM_BIN_LOCATION_CODE, NEW_BIN_LOCATION_CODE, BIN_DESC, BIN_LOCATION_CODE, ISSUE_TO_BIN_LOCATION_CODE, TO_BIN_DESC, EXPIRY_RECEIPT_DT, TRADE_ID, TRADE_NAME, DOC_TYPE_CODE, DOC_NO, SEQ_NO, DOC_DATE, ITEM_UNIT_COST, DOC_SRL_NO,RET_ITEM_QTY,BATCH_QTY ORDER BY DOC_NO,SEQ_NO,BATCH_ID,EXPIRY_RECEIPT_DT,TO_BIN_DESC",alParameters);
						//Added avail_qty > 0 against IN:62770
						alRecords=fetchRecords("SELECT   item_code, item_desc, batch_id, added_date, issue_fm_bin_location_code, new_bin_location_code, bin_desc, bin_location_code, issue_to_bin_location_code, to_bin_desc, expiry_receipt_dt, trade_id, trade_name, iss_item_qty, LEAST((iss_item_qty - ret_item_qty),batch_qty) avail_qty, doc_type_code, doc_no, seq_no, doc_date, item_unit_cost, doc_srl_no FROM (SELECT DISTINCT ide.item_code, sbv.item_desc item_desc, ide.batch_id, ihr.added_date, ide.bin_location_code issue_fm_bin_location_code, ide.bin_location_code new_bin_location_code, mmb.short_desc bin_desc, sbv.bin_location_code bin_location_code, ide.to_bin_location_code issue_to_bin_location_code, mmb1.short_desc to_bin_desc, TO_CHAR (ide.expiry_date_or_receipt_date, 'DD/MM/YYYY' ) expiry_receipt_dt, ide.trade_id, sbv.trade_name trade_name, NVL (ack.received_qty, ide.iss_item_qty ) iss_item_qty, NVL (ack1.received_qty, NVL (ide.ret_item_qty, 0) ) ret_item_qty, ide.doc_type_code doc_type_code, ide.doc_no doc_no, ide.seq_no seq_no, TO_CHAR (ihr.doc_date, 'DD/MM/YYYY') doc_date, item_unit_cost, ide.doc_srl_no, sbv.avail_qty batch_qty FROM st_issue_dtl_exp ide, st_issue_hdr ihr, st_batch_search_lang_view sbv, mm_bin_location_lang_vw mmb, mm_bin_location_lang_vw mmb1, st_issue_dtl idtl, st_acknowledge_trn_dtl ack, st_acknowledge_trn_dtl ack1, st_issue_ret_dtl_exp retexp WHERE (  NVL (ack.received_qty, NVL (ide.iss_item_qty, 0)) - NVL ((ack1.received_qty), (NVL (ide.ret_item_qty, 0) ) ) ) > 0 AND ide.facility_id = ? AND (    ide.facility_id = ihr.facility_id AND ide.doc_type_code = ihr.doc_type_code AND ide.doc_no = ihr.doc_no AND ide.seq_no = ihr.seq_no ) AND (   ihr.finalized_yn = 'Y' OR (    ihr.process_for_acknowledge = 'Y' AND NVL (ack.received_qty, 0) > 0 ) ) AND ihr.fm_store_code = ? AND ihr.to_store_code = ? AND (    ihr.to_store_code = sbv.store_code AND ide.item_code = sbv.item_code AND ide.batch_id = sbv.batch_id AND ide.to_bin_location_code = sbv.bin_location_code AND ide.expiry_date_or_receipt_date = sbv.expiry_date ) AND (    ihr.fm_store_code = mmb.store_code AND ide.bin_location_code = mmb.bin_location_code ) AND (    ihr.to_store_code = mmb1.store_code AND sbv.bin_location_code = mmb1.bin_location_code ) AND idtl.facility_id = ide.facility_id AND idtl.doc_type_code = ide.doc_type_code AND idtl.doc_no = ide.doc_no AND idtl.seq_no = ihr.seq_no AND idtl.item_code = ide.item_code AND ide.item_code = ? AND sbv.language_id = mmb.language_id AND sbv.language_id = mmb1.language_id AND sbv.language_id = ? AND sbv.lang1 = ? AND sbv.lang2 = ? AND ack.doc_no(+) = ide.doc_no AND ack.doc_type_code(+) = ide.doc_type_code AND ack.doc_srl_no(+) = ide.doc_srl_no AND ack.item_code(+) = ide.item_code AND ack.batch_id(+) = ide.batch_id AND ack.expiry_date_or_receipt_date(+) = ide.expiry_date_or_receipt_date AND retexp.org_doc_no(+) = ide.doc_no AND retexp.org_doc_type_code(+) = ide.doc_type_code AND retexp.org_seq_no(+) = ide.seq_no AND retexp.doc_no = ack1.doc_no(+) AND retexp.doc_type_code = ack1.doc_type_code(+) AND retexp.batch_id = ack1.batch_id(+) AND retexp.trade_id(+) = ide.trade_id AND retexp.expiry_date_or_receipt_date(+) = ide.expiry_date_or_receipt_date AND retexp.batch_id(+) = ide.batch_id AND retexp.item_code(+) = ide.item_code AND ack.seq_no(+) = ide.seq_no AND retexp.bin_location_code(+) = ide.bin_location_code AND sbv.avail_qty > 0) GROUP BY iss_item_qty, item_code, item_desc, batch_id, added_date, issue_fm_bin_location_code, new_bin_location_code, bin_desc, bin_location_code, issue_to_bin_location_code, to_bin_desc, expiry_receipt_dt, trade_id, trade_name, doc_type_code, doc_no, seq_no, doc_date, item_unit_cost, doc_srl_no, ret_item_qty, batch_qty ORDER BY doc_no, seq_no, batch_id, expiry_receipt_dt, to_bin_desc",alParameters);//Modified for IN072890
					}
			}//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 end
		System.out.println("alParameters....."+alParameters);
		}
		else{
			if(IssueRetBasedOn.equals("D")){//Added by suresh.r on 24-01-2014 against AMS-CRF-0054
				alParameters.add(getIssueDocNo());
				alParameters.add(issue_doc_type_code);
				alParameters.add(seq_no);
				//alRecords=fetchRecords(getStRepositoryValue("SQL_ST_ISSUE_RETURN_BATCH_SEARCH_QUERY_NONSTK"),alParameters);
				//alRecords=fetchRecords("SELECT IDE.ITEM_CODE,  MMITM.SHORT_DESC ITEM_DESC,  IDE.BATCH_ID,  IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,  MMB.SHORT_DESC BIN_DESC,  IDE.TO_BIN_LOCATION_CODE  ISSUE_TO_BIN_LOCATION_CODE,  '' TO_BIN_DESC, TO_CHAR(IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,  IDE.TRADE_ID,  NVL(LONG_NAME,IDE.TRADE_ID) TRADE_NAME,  IDE.ISS_ITEM_QTY, NVL(IDE.RET_ITEM_QTY,0) RET_ITEM_QTY,  (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) +ST_COMM_QTY_FOR_DOCNO(?, ?, ?,?, IHR.TO_STORE_CODE, IDE.TO_BIN_LOCATION_CODE , IDE.BATCH_ID, IDE.EXPIRY_DATE_OR_RECEIPT_DATE, IDE.ITEM_CODE ) AVAIL_QTY,  IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO,  TO_CHAR(IHR.DOC_DATE,'DD/MM/YYYY') DOC_DATE,  ITEM_UNIT_COST,  STOCK_ITEM_YN, IDE.DOC_SRL_NO  FROM ST_ISSUE_DTL_EXP IDE, ST_ISSUE_HDR IHR, MM_BIN_LOCATION_LANG_VW MMB, ST_ISSUE_DTL IDTL, MM_ITEM_LANG_VW MMITM, AM_TRADE_NAME_LANG_VW AMTRADE WHERE (IDE.ISS_ITEM_QTY -IDE.RET_ITEM_QTY + ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE)) >0 AND IDE.FACILITY_ID = ? AND IDTL.ITEM_CODE=MMITM.ITEM_CODE AND IDE.TRADE_ID=AMTRADE.TRADE_ID(+) AND (IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO =IHR.SEQ_NO) AND IHR.FINALIZED_YN='Y' AND IHR.FM_STORE_CODE= ? AND IHR.TO_STORE_CODE = ? /*AND (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) >= 0*/ AND (IHR.FM_STORE_CODE=MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE=MMB.BIN_LOCATION_CODE) AND IDTL.FACILITY_ID=IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE=IDE.DOC_TYPE_CODE AND IDTL.DOC_NO=IDE.DOC_NO AND  IDTL.SEQ_NO=IHR.SEQ_NO AND IDTL.ITEM_CODE=IDE.ITEM_CODE AND IDE.ITEM_CODE= ? AND MMB.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMB.LANGUAGE_ID = ? AND AMTRADE.LANGUAGE_ID(+) = ? AND IDE.DOC_NO =? AND IDE.DOC_TYPE_CODE=?",alParameters);
				//Added by suresh.r on 17-03-2014 against 047777
				//alRecords=fetchRecords("SELECT DISTINCT IDE.ITEM_CODE, MMITM.SHORT_DESC ITEM_DESC, IDE.BATCH_ID,IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,MMB.SHORT_DESC BIN_DESC,IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, '' TO_BIN_DESC,TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,IDE.TRADE_ID, NVL (LONG_NAME, IDE.TRADE_ID) TRADE_NAME,NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) ISS_ITEM_QTY,NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)) RET_ITEM_QTY,(  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0))- NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)))+ ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE) AVAIL_QTY,IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO,TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST,STOCK_ITEM_YN, IDE.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP IDE,ST_ISSUE_HDR IHR,MM_BIN_LOCATION_LANG_VW MMB,ST_ISSUE_DTL IDTL,MM_ITEM_LANG_VW MMITM,AM_TRADE_NAME_LANG_VW AMTRADE,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0))+ ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE)) > 0 AND IDE.FACILITY_ID = ? AND IDTL.ITEM_CODE = MMITM.ITEM_CODE AND IDE.TRADE_ID =  AMTRADE.TRADE_ID(+) AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? /*AND (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) >= 0*/ AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND MMB.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMB.LANGUAGE_ID = ? AND AMTRADE.LANGUAGE_ID(+) = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? and IDE.seq_no=? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) =  IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID  AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE  AND RETEXP.ITEM_CODE (+) = IDE.ITEM_CODE  AND ACK.SEQ_NO(+) = IDE.SEQ_NO",alParameters);
				alRecords=fetchRecords("SELECT DISTINCT IDE.ITEM_CODE, MMITM.SHORT_DESC ITEM_DESC, IDE.BATCH_ID,IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,MMB.SHORT_DESC BIN_DESC,IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, '' TO_BIN_DESC,TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,IDE.TRADE_ID, NVL (LONG_NAME, IDE.TRADE_ID) TRADE_NAME,NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) ISS_ITEM_QTY,NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)) RET_ITEM_QTY,(  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0))- NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)))+ ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE) AVAIL_QTY,IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO,TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST,STOCK_ITEM_YN, IDE.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP IDE,ST_ISSUE_HDR IHR,MM_BIN_LOCATION_LANG_VW MMB,ST_ISSUE_DTL IDTL,MM_ITEM_LANG_VW MMITM,AM_TRADE_NAME_LANG_VW AMTRADE,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0))+ ST_COMM_QTY_FOR_DOCNO (?,?,?,?,IHR.TO_STORE_CODE,IDE.TO_BIN_LOCATION_CODE,IDE.BATCH_ID,IDE.EXPIRY_DATE_OR_RECEIPT_DATE,IDE.ITEM_CODE)) > 0 AND IDE.FACILITY_ID = ? AND IDTL.ITEM_CODE = MMITM.ITEM_CODE AND IDE.TRADE_ID =  AMTRADE.TRADE_ID(+) AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND IHR.FINALIZED_YN = 'Y' AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? /*AND (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) >= 0*/ AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND MMB.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMB.LANGUAGE_ID = ? AND AMTRADE.LANGUAGE_ID(+) = ? AND IDE.DOC_NO = ? AND IDE.DOC_TYPE_CODE = ? and IDE.seq_no=? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) =  IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID  AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE  AND RETEXP.ITEM_CODE (+) = IDE.ITEM_CODE  AND ACK.SEQ_NO(+) = IDE.SEQ_NO ORDER BY IDE.BATCH_ID,EXPIRY_RECEIPT_DT",alParameters);
				//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 beg
			}else{
				alParameters.clear();
				alParameters.add(facility_new);
		        alParameters.add(store_code_from);
				alParameters.add(store_code_to);
		        alParameters.add(item_code_from);
		        alParameters.add(getLanguageId());
		        alParameters.add(getLanguageId());
					if(getMode().equals("2")){
						alParameters.add(doc_no);
						alRecords=fetchRecords("SELECT DISTINCT IDE.ITEM_CODE, MMITM.SHORT_DESC ITEM_DESC, IDE.BATCH_ID,IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,MMB.SHORT_DESC BIN_DESC,IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, '' TO_BIN_DESC,TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,IDE.TRADE_ID, NVL (LONG_NAME, IDE.TRADE_ID) TRADE_NAME,NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) ISS_ITEM_QTY,NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)) RET_ITEM_QTY,(  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0))- NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)))+nvl(retexp.item_qty,0) AVAIL_QTY, IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO,TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST,STOCK_ITEM_YN, IDE.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP IDE,ST_ISSUE_HDR IHR,MM_BIN_LOCATION_LANG_VW MMB,ST_ISSUE_DTL IDTL,MM_ITEM_LANG_VW MMITM,AM_TRADE_NAME_LANG_VW AMTRADE,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0))+ +nvl(retexp.item_qty,0)) > 0 AND ((NVL (ide.iss_item_qty, 0) - NVL (ide.ret_item_qty, 0)) + NVL(RETEXP.ITEM_QTY,0)) > 0 AND IDE.FACILITY_ID = ? AND IDTL.ITEM_CODE = MMITM.ITEM_CODE AND IDE.TRADE_ID =  AMTRADE.TRADE_ID(+) AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND ( ihr.finalized_yn = 'Y' OR ( ihr.process_for_acknowledge = 'Y'  AND NVL (ack.received_qty, 0) > 0)) AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? /*AND (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) >= 0*/ AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND MMB.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMB.LANGUAGE_ID = ? AND AMTRADE.LANGUAGE_ID(+) = ? AND retexp.doc_no(+) = ? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) =  IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID  AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND retexp.batch_id(+) = ide.batch_id AND retexp.to_bin_location_code(+) = ide.bin_location_code AND RETEXP.ITEM_CODE (+) = IDE.ITEM_CODE  AND ACK.SEQ_NO(+) = IDE.SEQ_NO ORDER BY DOC_NO,SEQ_NO,IDE.BATCH_ID,EXPIRY_RECEIPT_DT",alParameters);
					}else{
						alRecords=fetchRecords("SELECT DISTINCT IDE.ITEM_CODE, MMITM.SHORT_DESC ITEM_DESC, IDE.BATCH_ID,IDE.BIN_LOCATION_CODE ISSUE_FM_BIN_LOCATION_CODE,MMB.SHORT_DESC BIN_DESC,IDE.TO_BIN_LOCATION_CODE ISSUE_TO_BIN_LOCATION_CODE, '' TO_BIN_DESC,TO_CHAR (IDE.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY') EXPIRY_RECEIPT_DT,IDE.TRADE_ID, NVL (LONG_NAME, IDE.TRADE_ID) TRADE_NAME,NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) ISS_ITEM_QTY,NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0)) RET_ITEM_QTY,(  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0))- NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0))) AVAIL_QTY,IDE.DOC_TYPE_CODE DOC_TYPE_CODE, IDE.DOC_NO DOC_NO, IDE.SEQ_NO SEQ_NO,TO_CHAR (IHR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, ITEM_UNIT_COST,STOCK_ITEM_YN, IDE.DOC_SRL_NO FROM ST_ISSUE_DTL_EXP IDE,ST_ISSUE_HDR IHR,MM_BIN_LOCATION_LANG_VW MMB,ST_ISSUE_DTL IDTL,MM_ITEM_LANG_VW MMITM,AM_TRADE_NAME_LANG_VW AMTRADE,ST_ACKNOWLEDGE_TRN_DTL ACK,ST_ACKNOWLEDGE_TRN_DTL ACK1,ST_ISSUE_RET_DTL_EXP RETEXP WHERE (  NVL (ACK.RECEIVED_QTY, NVL (IDE.ISS_ITEM_QTY, 0)) - NVL (ACK1.RECEIVED_QTY,NVL(IDE.RET_ITEM_QTY,0))) > 0  AND IDE.FACILITY_ID = ? AND IDTL.ITEM_CODE = MMITM.ITEM_CODE AND IDE.TRADE_ID =  AMTRADE.TRADE_ID(+) AND (    IDE.FACILITY_ID = IHR.FACILITY_ID AND IDE.DOC_TYPE_CODE = IHR.DOC_TYPE_CODE AND IDE.DOC_NO = IHR.DOC_NO AND IDE.SEQ_NO = IHR.SEQ_NO ) AND ( ihr.finalized_yn = 'Y' OR ( ihr.process_for_acknowledge = 'Y'  AND NVL (ack.received_qty, 0) > 0)) AND IHR.FM_STORE_CODE = ? AND IHR.TO_STORE_CODE = ? /*AND (IDE.ISS_ITEM_QTY-NVL(IDE.RET_ITEM_QTY,0)) >= 0*/ AND (    IHR.FM_STORE_CODE = MMB.STORE_CODE AND IDE.BIN_LOCATION_CODE = MMB.BIN_LOCATION_CODE ) AND IDTL.FACILITY_ID = IDE.FACILITY_ID AND IDTL.DOC_TYPE_CODE = IDE.DOC_TYPE_CODE AND IDTL.DOC_NO = IDE.DOC_NO AND IDTL.SEQ_NO = IHR.SEQ_NO AND IDTL.ITEM_CODE = IDE.ITEM_CODE AND IDE.ITEM_CODE = ? AND MMB.LANGUAGE_ID = MMITM.LANGUAGE_ID AND MMB.LANGUAGE_ID = ? AND AMTRADE.LANGUAGE_ID(+) = ? AND ACK.DOC_NO(+) = IDE.DOC_NO AND ACK.DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND ACK.DOC_SRL_NO(+) =  IDE.DOC_SRL_NO AND ACK.ITEM_CODE(+) = IDE.ITEM_CODE AND ACK.BATCH_ID(+) = IDE.BATCH_ID AND ACK.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND RETEXP.ORG_DOC_NO(+) = IDE.DOC_NO AND RETEXP.ORG_DOC_TYPE_CODE(+) = IDE.DOC_TYPE_CODE AND RETEXP.ORG_SEQ_NO(+) = IDE.SEQ_NO AND RETEXP.DOC_NO = ACK1.DOC_NO(+) AND RETEXP.DOC_TYPE_CODE = ACK1.DOC_TYPE_CODE(+) AND RETEXP.BATCH_ID = ACK1.BATCH_ID(+) AND RETEXP.TRADE_ID(+) = IDE.TRADE_ID  AND RETEXP.EXPIRY_DATE_OR_RECEIPT_DATE(+) = IDE.EXPIRY_DATE_OR_RECEIPT_DATE AND retexp.batch_id(+) = ide.batch_id AND retexp.bin_location_code(+) = ide.bin_location_code AND RETEXP.ITEM_CODE (+) = IDE.ITEM_CODE  AND ACK.SEQ_NO(+) = IDE.SEQ_NO ORDER BY DOC_NO,SEQ_NO,IDE.BATCH_ID,EXPIRY_RECEIPT_DT",alParameters);
					}
			}//Added by suresh.r on 24-01-2014 against AMS-CRF-0054 end
		}

//			String stSQL=getStRepositoryValue("SQL_ST_ISSUE_RETURN_BATCH_SEARCH_QUERY");
//			listRecord = fetchRecords(stSQL.toString(),alParameters);

			DataList=alRecords;
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
	public void clear(){
	selectedList=new ArrayList();
	}
	
	//added for GHL-CRF-0499 START , modified for GHL-ICN-0032
public String getChallanNo(String item_code,String batch_id,String expiry_date, String strCode){
	Connection connection			 =		null ;
	PreparedStatement pstmt	 =		null ;
	ResultSet resultSet				 =		null ;
	HashMap hmChallan			  = new HashMap();
	ArrayList alParameters	=	new ArrayList();
	String challan_no =	"";
	//String challNo=""; //Commented for common-icn-0048
	//String batchid= ""; //Commented  for common-icn-0048
	String consignment_yn = getConsignment_yn(item_code); 
	//setting challan_no to null when item is not a consignment item
	if(consignment_yn.equalsIgnoreCase("N")){
		challan_no="";
		return challan_no;
	}
	//ADDED FOR GHL-ICN-0030 START
	//String vmi_batch_id=""; //Commented for common-icn-0048
	try {	
		//commented for GHL-ICN-0034
		/*if(batch_id.contains("-")){
		//	String[] arrOfStr = batch_id.split("-", 2);
		//	batchid = arrOfStr[0];
		//	challNo =arrOfStr[1];
		connection=getConnection();
				pstmt		= connection.prepareStatement("select VMI_BATCH_ID from st_item_batch where item_code=? and batch_id=? and EXPIRY_DATE_OR_RECEIPT_DATE=TO_DATE(?,'DD/MM/YYYY') and store_code= ?");
				pstmt.setString(1,item_code);
				pstmt.setString(2,batch_id);
				pstmt.setString(3,expiry_date);
				pstmt.setString(4,strCode);
				
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
		challNo = '%'+challNo+'%';*/
		alParameters.add(getIssueDocNo());
		alParameters.add(item_code);
		alParameters.add(batch_id); //ADDED FOR GHL-ICN-0030
		alParameters.add(expiry_date);
		alParameters.add(strCode);
		hmChallan = fetchRecord("SELECT CHALLAN_NO FROM ST_ISSUE_DTL_EXP WHERE DOC_NO= ? AND  ITEM_CODE= ? AND BATCH_ID= ? AND TRUNC(EXPIRY_DATE_OR_RECEIPT_DATE) = TO_DATE (?,'DD/MM/YYYY') AND STORE_CODE= ? ",alParameters);
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
}
