/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
06/02/2017		IN0063027			Badmavathi B							GHL-CRF-0413.7 - US009 - Barcode search
24/07/2018		66199				Shazana Hasan							GHL-CRF- 0499 - Added Challan_No in Batch Search
9/8/2021		TFS:22264			Shazana									MOHE-CRF-0084.1-US015
---------------------------------------------------------------------------------------------------------
*/
 package eST;

import eST.Common.*;
import java.io.Serializable;
import java.util.*;
import java.sql.*;
import javax.servlet.* ; 
import javax.servlet.http.*;

 
//import eST.Common.ReportCallerThread;

//import eCommon.Common.CommonAdapter;
//import eCommon.Common.CommonEJBSessionInterface;
//import eST.Common.StAdapter;
//import eST.Common.StTransaction;
//import eST.Common.StHeaderBean;
//import javax.ejb.EJBObject;
//import javax.naming.InitialContext;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.


public class CondemnExpiredBatchesHeaderBean extends StTransaction implements Serializable { 
	//private StHeaderBean						stHeaderBean	;
//	private javax.servlet.http.HttpServletRequest request;
//	private javax.servlet.http.HttpServletResponse response;
	private String adj_doc_ref="";
    private String trn_type="";
    //private String doctypes="";
    private String getdocno="";
    private String default_doc="";
    private String adj_doc_type_code="";
    private String adj_doc_type_desc="";
    private String adj_doc_date="";
    private String adj_doc_no="";
    private String adj_remarks = "";
    private String sys_date="";
    //private String language_id;
    private ArrayList alHeaderData;
    private HashMap hmStParameter;
    private ArrayList alDocTypeListOption;
	private String default_doc_type_code = "";
	//private String doc_type_code = "";

	//private String PDocNo = "";
	private String PgetDoc_type_code = "";
	//private String PgetStore_codest = "";
	private String stReportid = null;

	private ArrayList alExpiredBatches = new ArrayList();
	private ArrayList alCheckedExpiredBatches = new ArrayList();
//	 javax.servlet.http.HttpSession session =null; 
	public String reportserver = "";
	public String report_connect_string = "";
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013  
	public String finalized_yn = "Y"; 
	public String con_doc_no = "";
	private String adj_remarks_desc = "";
	private ArrayList PDocNo ; 


	public void initialize(String trn_type) {
		try {
	        hmStParameter	=	getStParameter();
		    adj_doc_type_code	=	checkForNull((String)hmStParameter.get("DEF_"+getDefault_doc()+"_DOC_TYPE_CODE"));
			if(!isDocNoAutoGenYN(adj_doc_type_code))
				adj_doc_type_code = "";
			if (!adj_doc_type_code.equals("")) {

			ArrayList arr_lang=new ArrayList();
			arr_lang.add(adj_doc_type_code);
			arr_lang.add(getLanguageId());
				adj_doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_lang).get("SHORT_DESC").toString();
		    }

			adj_doc_date		=	hmStParameter.get("SYS_DATE").toString();
			adj_doc_ref			=	"";
			adj_doc_no			=	"";
			adj_remarks			=	"";
			con_doc_no          =   "";
			this.trn_type	=	trn_type;
			initDoc_type_code_List();
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
    }

	public boolean hasAllMandatoryValue()throws Exception {
		return ((!adj_doc_type_code.equals(""))&&
				(!(adj_doc_no.equals("")&& !isDocNoAutoGenYN(adj_doc_type_code)) )&&
				(!adj_doc_date.equals("")));
	}
	public void initialize(String trn_type, String adj_doc_type_code, String adj_doc_no, String adj_doc_date, String adj_doc_ref, String adj_ramarks) {
		this.adj_doc_type_code	=	adj_doc_type_code;
		this.adj_doc_no			=	adj_doc_no;
		this.adj_doc_date		=	adj_doc_date;
		this.adj_doc_ref		=	adj_doc_ref;
		this.trn_type			=	trn_type;
		this.adj_remarks		=	adj_remarks;
		try {
			if (!adj_doc_type_code.equals("")) {
				ArrayList arr_lang=new ArrayList();
				arr_lang.add(adj_doc_type_code);
				arr_lang.add(getLanguageId());
					adj_doc_type_desc	=	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_lang).get("SHORT_DESC").toString();
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		initDoc_type_code_List();
    }

    public void setAdj_remarks (String p_adj_remarks) {
		this.adj_remarks = p_adj_remarks;
	}

	public String getAdj_remarks () {
		return adj_remarks;
	}
	
	public String getRemarks(String remarks_code) throws Exception{
		if(remarks_code.equals("")){
			return "";
		}else{
			ArrayList alParam =  new ArrayList();
			alParam.add(remarks_code);
			alParam.add(getLanguageId());
			return checkForNull((String)((HashMap)fetchRecord("SELECT REMARKS_DESC SHORT_DESC FROM MM_TRN_REMARKS_LANG_VW WHERE TRN_REMARKS_CODE = ? AND LANGUAGE_ID = ?",alParam)).get("SHORT_DESC"));
		}
	}

	public void setDoc_ref(String adj_doc_ref) {
		this.adj_doc_ref = checkForNull(adj_doc_ref);
	}

	public String getDoc_ref() {
		 return adj_doc_ref;
	}

	public void setTrn_type(String trn_type) {
		this.trn_type = trn_type;
	}

	public String getTrn_type() {
		 return trn_type;
	}
/*public void setLanguageId(String language_id) {
		this.language_id = language_id;
	}

	public String getLanguageId() {
		 return language_id;
	}*/

	public void setDefault_doc(String default_doc) {
		 this.default_doc = default_doc;
	}

	public String getDefault_doc() {
		 return default_doc;
	}

	public void setDoc_no(String adj_doc_no) {
		 this.adj_doc_no = adj_doc_no;
	}

	public String getDoc_no() {
		 return adj_doc_no;
	}

    public String getDoc_type_desc(String doc_type_code) {
		try {
				ArrayList arr_lang=new ArrayList();
				arr_lang.add(doc_type_code);
				arr_lang.add(getLanguageId());
			adj_doc_type_desc	=checkForNull((String)((HashMap)	fetchRecord(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_DESC"),arr_lang)).get("SHORT_DESC"));
		}
		catch(Exception exception ) {
			exception.printStackTrace();
		}
		return adj_doc_type_desc;
    }

	public void setDoc_type_desc(String adj_doc_type_desc) {
		this.adj_doc_type_desc=adj_doc_type_desc;
	}


    public void setDoc_type_code(String s) {
        adj_doc_type_code = s;
    }

    public String getDoc_type_code() {
        return adj_doc_type_code;
    }

    public void setDoc_date(String s) {
        adj_doc_date = s;
    }

    public String getDoc_date() {
        return adj_doc_date;
    }

	public void initDoc_type_code_List() {
        ArrayList arraylist = new ArrayList();
		int alDoc_size = 0;
        arraylist.add(getLoginFacilityId());
        arraylist.add(getTrn_type());
        arraylist.add(getLanguageId());
        alDocTypeListOption = getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_AUTO_DOC_TYPE_SELECT_LIST_HDR"), arraylist);
		 alDoc_size = alDocTypeListOption.size();
		    if(alDoc_size == 2)
		    alDocTypeListOption.remove(0);
	}

	public String getDoc_type_code_List() {
        return getListOptionTag(alDocTypeListOption, getDoc_type_code());
    }

	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
	public void setAdj_remarks_Desc (String p_adj_remarks_desc) {
		this.adj_remarks_desc = p_adj_remarks_desc;
	}
	public String getAdj_remarks_Desc () {
		return adj_remarks_desc;
	}
	public void setCon_doc_no(String con_doc_no) {
		 this.con_doc_no = con_doc_no;
	}
	public String getCon_doc_no() {
		 return con_doc_no;
	}
	/*public void setDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getDocNo(){
		return PDocNo;
	}*/
	public void setFinalized_yn (String p_finalized_yn) {
		finalized_yn = p_finalized_yn;
	}
	public String getFinalized_yn(){
		return finalized_yn;
	}
	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getPrintDocNo(){
		return PDocNo;
	}
	//ends
	
	public void initialize(){
		super.initialize();
		adj_doc_ref="";
		trn_type="";
		adj_doc_type_code="";
		adj_doc_date="";
		adj_doc_no="";
		adj_remarks = "";
		hmStParameter=null;
		alDocTypeListOption=null;
		alExpiredBatches = new ArrayList();
		alCheckedExpiredBatches = new ArrayList();
		con_doc_no  = "";
		adj_remarks_desc = "";
	}

    public void clear() {
        super.clear();
		adj_doc_ref=null;
		trn_type=null;
		adj_doc_type_code=null;
		adj_doc_date=null;
		adj_doc_no=null;
		adj_remarks =null;
		hmStParameter=null;
		alDocTypeListOption=null;
		alExpiredBatches = null;
		alCheckedExpiredBatches = null;
		con_doc_no = null;
		adj_remarks_desc = null;
    }
	public String toString() {
		return
		adj_doc_ref+
		trn_type+
		adj_doc_type_code+
		adj_doc_date+
		adj_doc_no+
		adj_remarks+
		alDocTypeListOption;
	}

	public String getSysDate() {
		//HashMap hmResult=new HashMap();

		try {
			sys_date=(String)getStParameter().get("SYS_DATE");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return sys_date;
	}


	// All the methods from CondemnExpirdBatchesBean

	/*public String getDoc_type_code () {
		return doc_type_code;
	}*/

	public String getDefault_doc_type_code () {
		return default_doc_type_code;
	}

	/**
	* To retirive all the expired batches from the database
	* @return ArrayList, the list of expired batches.
	*/
	public ArrayList getExpired_batches () {
		return alExpiredBatches;
	}
	public void loadExpired_batches (HashMap hmParameters) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		//alExpiredBatches =null;
		alExpiredBatches.clear() ;

		try {
			connection = getConnection() ;
//			pstmt = connection.prepareStatement(getStRepositoryValue("SQL_ST_EXPIRED_BATCHES_SELECT") ) ;
			//pstmt = connection.prepareStatement("SELECT	btvw.item_code, item_desc, btvw.store_code, store_desc, batch_id,	bin_location_code, bin_desc, TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	expiry_date ex_date, trade_id, trade_name, qty_on_hand, replace_on_expiry_yn	FROM st_batch_search_lang_view btvw, mm_store_lang_vw mmvw WHERE	expiry_yn =	'Y'	AND	qty_on_hand	> 0	AND	expiry_date	 BETWEEN TO_DATE(NVL(?,'01/01/1901'),'dd/mm/yyyy') AND TO_DATE(NVL(?,TO_CHAR(SYSDATE,'DD/MM/YYYY')),'dd/mm/yyyy')	AND	btvw.store_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND item_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND batch_id LIKE DECODE(?,'','%',?) AND PHY_INV_ID IS NULL AND EXISTS (SELECT  DISTINCT 'X' FROM st_user_access_for_store WHERE user_id= ? and store_code=btvw.store_code AND CNDMN_EXP_BTCH_ALLOWED_YN='Y') AND btvw.language_id = ? AND btvw.lang1=? AND btvw.lang2=? AND btvw.store_code = mmvw.store_code AND btvw.language_id = mmvw.language_id AND mmvw.facility_id = ? ORDER BY ex_date") ;
			//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
			String exp_yn = checkForNull((String)hmParameters.get("exp_yn"),"Y");
			if(exp_yn.equals("Y")){
			//pstmt = connection.prepareStatement("SELECT	btvw.item_code, item_desc, btvw.store_code, store_desc, batch_id,	bin_location_code, bin_desc, TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	expiry_date ex_date, trade_id, trade_name, qty_on_hand,AVAIL_QTY, replace_on_expiry_yn	FROM st_batch_search_lang_view btvw, mm_store_lang_vw mmvw WHERE	expiry_yn =	'Y'	 AND  qty_on_hand > 0 AND	qty_on_hand = AVAIL_QTY	AND	expiry_date	 BETWEEN TO_DATE(NVL(?,'01/01/1901'),'dd/mm/yyyy') AND TO_DATE(NVL(?,TO_CHAR(SYSDATE,'DD/MM/YYYY')),'dd/mm/yyyy')	AND	btvw.store_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND item_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND batch_id LIKE DECODE(?,'','%',?) AND PHY_INV_ID IS NULL AND EXISTS (SELECT  DISTINCT 'X' FROM st_user_access_for_store WHERE user_id= ? and store_code=btvw.store_code AND CNDMN_EXP_BTCH_ALLOWED_YN='Y') AND btvw.language_id = ? AND btvw.lang1=? AND btvw.lang2=? AND btvw.store_code = mmvw.store_code AND btvw.language_id = mmvw.language_id AND mmvw.facility_id = ? AND suspended_yn  <> 'Y' ORDER BY ex_date") ;
			//Added by Rabbani #inc no:45074 on 20-NOV-2013
			//pstmt = connection.prepareStatement("SELECT	btvw.item_code, item_desc, btvw.store_code, store_desc, batch_id,	bin_location_code, bin_desc, TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	expiry_date ex_date, trade_id, trade_name, qty_on_hand,AVAIL_QTY, replace_on_expiry_yn	FROM st_batch_search_lang_view btvw, mm_store_lang_vw mmvw WHERE	expiry_yn =	'Y'	 AND  qty_on_hand > 0 AND	qty_on_hand = AVAIL_QTY	AND	expiry_date	 BETWEEN TO_DATE(NVL(?,'01/01/1901'),'dd/mm/yyyy') AND TO_DATE(NVL(?,TO_CHAR(SYSDATE,'DD/MM/YYYY')),'dd/mm/yyyy')	AND	btvw.store_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND item_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND batch_id LIKE DECODE(?,'','%',?) AND PHY_INV_ID IS NULL AND EXISTS (SELECT  DISTINCT 'X' FROM st_user_access_for_store WHERE user_id= ? and store_code=btvw.store_code AND CNDMN_EXP_BTCH_ALLOWED_YN='Y') AND btvw.language_id = ? AND btvw.lang1=? AND btvw.lang2=? AND btvw.store_code = mmvw.store_code AND btvw.language_id = mmvw.language_id AND mmvw.facility_id = ? AND suspended_yn  <> 'Y' ORDER BY item_desc,store_desc,ex_date,batch_id,trade_name,bin_desc") ;
			//Added barcode_id for GHL-CRF-0413.7 
				pstmt = connection.prepareStatement("SELECT	btvw.item_code, item_desc, btvw.store_code, store_desc, batch_id,	bin_location_code, bin_desc, TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	expiry_date ex_date, trade_id, trade_name, qty_on_hand,AVAIL_QTY, replace_on_expiry_yn, barcode_id	FROM st_batch_search_lang_view btvw, mm_store_lang_vw mmvw WHERE	expiry_yn =	'Y'	 AND  qty_on_hand > 0 AND	qty_on_hand = AVAIL_QTY	AND	expiry_date	 BETWEEN TO_DATE(NVL(?,'01/01/1901'),'dd/mm/yyyy') AND TO_DATE(NVL(?,TO_CHAR(SYSDATE,'DD/MM/YYYY')),'dd/mm/yyyy')	AND	btvw.store_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND item_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND batch_id LIKE DECODE(?,'','%',?) AND PHY_INV_ID IS NULL AND EXISTS (SELECT  DISTINCT 'X' FROM st_user_access_for_store WHERE user_id= ? and store_code=btvw.store_code AND CNDMN_EXP_BTCH_ALLOWED_YN='Y') AND btvw.language_id = ? AND btvw.lang1=? AND btvw.lang2=? AND btvw.store_code = mmvw.store_code AND btvw.language_id = mmvw.language_id AND mmvw.facility_id = ? AND suspended_yn  <> 'Y' ORDER BY item_desc,store_desc,ex_date,batch_id,trade_name,bin_desc") ;//modified for GHL-CRF-0499
			}else{
				//pstmt = connection.prepareStatement("SELECT	btvw.item_code, item_desc, btvw.store_code, store_desc, batch_id,	bin_location_code, bin_desc, TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	expiry_date ex_date, trade_id, trade_name, qty_on_hand,AVAIL_QTY, replace_on_expiry_yn	FROM st_batch_search_lang_view btvw, mm_store_lang_vw mmvw WHERE	expiry_yn =	'N'	 AND  qty_on_hand > 0 AND	qty_on_hand = AVAIL_QTY	AND	expiry_date	 BETWEEN TO_DATE(NVL(?,'01/01/1901'),'dd/mm/yyyy') AND TO_DATE(NVL(?,TO_CHAR(SYSDATE,'DD/MM/YYYY')),'dd/mm/yyyy')	AND	btvw.store_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND item_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND batch_id LIKE DECODE(?,'','%',?) AND PHY_INV_ID IS NULL AND EXISTS (SELECT  DISTINCT 'X' FROM st_user_access_for_store WHERE user_id= ? and store_code=btvw.store_code AND CNDMN_EXP_BTCH_ALLOWED_YN='Y') AND btvw.language_id = ? AND btvw.lang1=? AND btvw.lang2=? AND btvw.store_code = mmvw.store_code AND btvw.language_id = mmvw.language_id AND mmvw.facility_id = ? AND suspended_yn  <> 'Y' ORDER BY ex_date") ;
				//Added by Rabbani #inc no:45074 on 20-NOV-2013
				//pstmt = connection.prepareStatement("SELECT	btvw.item_code, item_desc, btvw.store_code, store_desc, batch_id,	bin_location_code, bin_desc, TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	expiry_date ex_date, trade_id, trade_name, qty_on_hand,AVAIL_QTY, replace_on_expiry_yn	FROM st_batch_search_lang_view btvw, mm_store_lang_vw mmvw WHERE	expiry_yn =	'N'	 AND  qty_on_hand > 0 AND	qty_on_hand = AVAIL_QTY	AND	expiry_date	 BETWEEN TO_DATE(NVL(?,'01/01/1901'),'dd/mm/yyyy') AND TO_DATE(NVL(?,TO_CHAR(SYSDATE,'DD/MM/YYYY')),'dd/mm/yyyy')	AND	btvw.store_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND item_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND batch_id LIKE DECODE(?,'','%',?) AND PHY_INV_ID IS NULL AND EXISTS (SELECT  DISTINCT 'X' FROM st_user_access_for_store WHERE user_id= ? and store_code=btvw.store_code AND CNDMN_EXP_BTCH_ALLOWED_YN='Y') AND btvw.language_id = ? AND btvw.lang1=? AND btvw.lang2=? AND btvw.store_code = mmvw.store_code AND btvw.language_id = mmvw.language_id AND mmvw.facility_id = ? AND suspended_yn  <> 'Y' ORDER BY item_desc, store_desc, ex_date, batch_id, trade_name, bin_desc") ;
				//Added barcode_id for GHL-CRF-0413.7
				pstmt = connection.prepareStatement("SELECT	btvw.item_code, item_desc, btvw.store_code, store_desc, batch_id,	bin_location_code, bin_desc, TO_CHAR(expiry_date,'dd/mm/yyyy') expiry_date,	expiry_date ex_date, trade_id, trade_name, qty_on_hand,AVAIL_QTY, replace_on_expiry_yn, barcode_id 	FROM st_batch_search_lang_view btvw, mm_store_lang_vw mmvw WHERE	expiry_yn =	'N'	 AND  qty_on_hand > 0 AND	qty_on_hand = AVAIL_QTY	AND	expiry_date	 BETWEEN TO_DATE(NVL(?,'01/01/1901'),'dd/mm/yyyy') AND TO_DATE(NVL(?,TO_CHAR(SYSDATE,'DD/MM/YYYY')),'dd/mm/yyyy')	AND	btvw.store_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND item_code BETWEEN NVL(?,'!') AND NVL(?,'~') AND batch_id LIKE DECODE(?,'','%',?) AND PHY_INV_ID IS NULL AND EXISTS (SELECT  DISTINCT 'X' FROM st_user_access_for_store WHERE user_id= ? and store_code=btvw.store_code AND CNDMN_EXP_BTCH_ALLOWED_YN='Y') AND btvw.language_id = ? AND btvw.lang1=? AND btvw.lang2=? AND btvw.store_code = mmvw.store_code AND btvw.language_id = mmvw.language_id AND mmvw.facility_id = ? AND suspended_yn  <> 'Y' ORDER BY item_desc, store_desc, ex_date, batch_id, trade_name, bin_desc") ;// modified for GHL-CRF-0499
			}
			pstmt.setString(1,(String)hmParameters.get("from_date"));
			pstmt.setString(2,(String)hmParameters.get("to_date"));
			pstmt.setString(3,(String)hmParameters.get("from_store"));
			pstmt.setString(4,(String)hmParameters.get("to_store"));
			pstmt.setString(5,(String)hmParameters.get("from_item"));
			pstmt.setString(6,(String)hmParameters.get("to_item"));
			pstmt.setString(7,(String)hmParameters.get("batch_id"));
			pstmt.setString(8,(String)hmParameters.get("batch_id"));

			// added on 14/09/04 
            pstmt.setString(9,getLoginById());
			pstmt.setString(10,getLanguageId());
			pstmt.setString(11,getLanguageId());
			pstmt.setString(12,getLanguageId());
			pstmt.setString(13,getLoginFacilityId());

			resultSet = pstmt.executeQuery() ;
			//alExpiredBatches = new ArrayList();

			while ( resultSet != null && resultSet.next() ) {

				String item_code	= resultSet.getString( "item_code" );
				String store_code	= resultSet.getString( "store_code" );
				String batch_id		= resultSet.getString( "batch_id" );
				String bin_location_code = resultSet.getString( "bin_location_code" );
				String expiry_date	= resultSet.getString( "expiry_date");	

				HashMap hmExpiredBatch = new HashMap();
				hmExpiredBatch.put( "item_code",resultSet.getString( "item_code" ) ) ;
				hmExpiredBatch.put( "store_code",resultSet.getString( "store_code" ) ) ;
				hmExpiredBatch.put( "batch_id",resultSet.getString( "batch_id" ) ) ;
				hmExpiredBatch.put( "bin_location_code",resultSet.getString( "bin_location_code" )) ;
				hmExpiredBatch.put( "expiry_date",resultSet.getString( "expiry_date")) ;

				hmExpiredBatch.put( "item_desc",resultSet.getString( "item_desc" ) ) ;
				hmExpiredBatch.put( "store_desc",resultSet.getString( "store_desc" ) ) ;
				hmExpiredBatch.put( "bin_desc",resultSet.getString( "bin_desc" )) ;
				hmExpiredBatch.put( "trade_id",resultSet.getString( "trade_id" ) ) ;
				hmExpiredBatch.put( "trade_name",resultSet.getString( "trade_name" ) ) ;
				hmExpiredBatch.put( "qty_on_hand",resultSet.getString( "qty_on_hand" ) ) ;
				hmExpiredBatch.put( "avail_qty",resultSet.getString( "avail_qty" )) ;
				hmExpiredBatch.put( "replace_on_expiry_yn",resultSet.getString("replace_on_expiry_yn")) ;
				hmExpiredBatch.put( "barcode_id",resultSet.getString( "barcode_id" )) ;//Added against GHL-CRF-0413.7
				
				/*commented for GHL-CRF-0499 START*/
				/*if(getCustomerID().equals("MC")){
					hmExpiredBatch.put( "challan_no",resultSet.getString( "challan_no" )) ;	
				}*/
				/*added for GHL-CRF-0499 END*/
				
				boolean flag = false;
				//if(alExpiredBatches!=null)
				//{
				for(int i=0;i<alExpiredBatches.size();i++) {
					HashMap hmListExpiredBatch	=  (HashMap)alExpiredBatches.get(i);
					String list_item_code = (String)(hmListExpiredBatch.get("item_code"));
					String list_store_code = (String)(hmListExpiredBatch.get("store_code"));
					String list_batch_id = (String)(hmListExpiredBatch.get("batch_id"));
					String list_bin_location_code = (String)(hmListExpiredBatch.get("bin_location_code"));
					String list_expiry_date = (String)(hmListExpiredBatch.get("expiry_date"));
					if(item_code.equals(list_item_code) && store_code.equals(list_store_code) && batch_id.equals(list_batch_id) && bin_location_code.equals(list_bin_location_code) && expiry_date.equals(list_expiry_date)) {
						flag = true;
					}
				}
				//}
				if(flag == false) {
					alExpiredBatches.add(hmExpiredBatch);
				}
			}
		 }
		 catch ( Exception e )	{
			alExpiredBatches.add(e.toString());
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
	}


	public int isDocNoValid (String p_doc_no) {
		int l_doc_no = Integer.parseInt(p_doc_no);
		HashMap hm=new HashMap();
		int l_doc_no_from_db = 0;

		try {
			hm=fetchRecord(getStRepositoryValue("SQL_ST_FETCH_MAX_DOC_NO"));
			l_doc_no_from_db = Integer.parseInt((String)hm.get("DOC_NO"));
		}
		catch(Exception e) {
			e.printStackTrace();
		}

		if(l_doc_no > l_doc_no_from_db) {
			return 0;
		}
		else {
			return l_doc_no_from_db;
		}
	}

	public String getDocTypeCodes(){
		//String result = getDefaultDocumentTypeList("ADJ",default_doc_type_code);
		String result = getDefaultDocumentTypeList("CEB",default_doc_type_code);
		return result;
	}
	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList();
		ArrayList  alDocType_desc = new ArrayList();
		int alDoc_size = 0;
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		//return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
		//Added by Rabbani #inc no:45073 on 20-NOV-2013
		alDocType_desc = getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_AUTO_DOC_TYPE_SELECT_LIST_HDR"), alParameters);
		   alDoc_size = alDocType_desc.size();
		    if(alDoc_size == 2)
		    alDocType_desc.remove(0);
		//return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_AUTO_DOC_TYPE_SELECT_LIST_HDR"),alParameters),defaultValue);
		return getListOptionTag(alDocType_desc,defaultValue);
	}


	public void setDefaultDocType(String p_default_doc_type_code) {
		this.default_doc_type_code = p_default_doc_type_code;
	}

	// Methods added for apply

	public void setAll(java.util.Hashtable hashValues) {
		String keyCode = "";
		String selectedKey ="";

		java.util.Enumeration hashKeys = hashValues.keys();
		String finalise_yn = (String)hashValues.get("finalized");
		setFinalized_yn(finalise_yn);
		//Added by suresh.r on 10/07/2015 against AAKH-SCF-0214 beg
		if(alCheckedExpiredBatches==null){
			alCheckedExpiredBatches=new ArrayList();
		}else{
			alCheckedExpiredBatches.clear();
		}
		//Added by suresh.r on 10/07/2015 against AAKH-SCF-0214 end
		while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("remove_")) {
				selectedKey = (String) hashValues.get(keyCode);
				if (selectedKey != null && selectedKey.trim().length()>0) {
					alCheckedExpiredBatches.add(selectedKey);
				}
			}
		}
	}

	public boolean validateCheckedCount(java.util.Hashtable hashValues) {
		String keyCode = "";
		String selectedKey ="";
		ArrayList alCheckedItems = new ArrayList();

		java.util.Enumeration hashKeys = hashValues.keys();

		while (hashKeys.hasMoreElements()) {
			keyCode = (String) hashKeys.nextElement();
			if (keyCode.startsWith("remove_")) {
				selectedKey = (String) hashValues.get(keyCode);
				if (selectedKey != null && selectedKey.trim().length()>0) {
					alCheckedItems.add(selectedKey);
				}
			}
		}

		if(alCheckedItems.size() > 0) {
			return true;
		}
		else {
			return false;
		}

	}


	/**
	* Method which returns the header data as an arraylist.
	* @return ArrayList, the Header related data as an ArrayList.
	*/

	public ArrayList getHeaderDataAsArrayList () {
		//facility_id, doc_type_code, doc_no, doc_date, doc_ref, store_code,
		//authorized_by_id, finalized_yn, gl_interfaced_yn, trn_type, sale_to_ext_yn,
		//ext_agency_name

		ArrayList HdrData	=	new ArrayList();

		try {
			HdrData.add(getLoginFacilityId());    // LoginfacilityId - 0
			String doctypes=checkForNull(getDoc_type_code());	
			String trntypes=checkForNull(getTrn_type());
			String documentdate=checkForNull(getDoc_date());
			if(documentdate.equals(""))
			{
				hmStParameter	=	getStParameter();
				 adj_doc_date		=	hmStParameter.get("SYS_DATE").toString();

				 setDoc_date(adj_doc_date);
			}
			
			 
			if(trntypes.equals(""))
			{	trntypes="ADJ";
					setTrn_type(trntypes);
			}
			if(doctypes.equals("")  )
			{
				 ArrayList arraylist1 = new ArrayList();
				 arraylist1.add(getLoginFacilityId());
				 arraylist1.add(getTrn_type());
				 arraylist1.add(getLanguageId());
				 getdocno=(String)(fetchRecord(getStRepositoryValue("SQL_ST_TRN_AUTO_DOC_TYPE_SELECT_LIST_HDR_CONDEMN"),arraylist1).get("DOC_TYPE_CODE"));
				 setDoc_type_code(getdocno);

//				 getdocno=(String)(HashMap)fetchRecord(getStRepositoryValue("SQL_ST_TRN_AUTO_DOC_TYPE_SELECT_LIST_HDR"), arraylist1).get("doc_type_code"));
				 HdrData.add(getdocno); 
			}
			else
			{
				HdrData.add(getDoc_type_code());     
			}// DocTypeCode - 1
            if(getFinalized_yn().equals("Y")){//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013  
			if(isDocNoAutoGenYN(getDoc_type_code())) {
				setDoc_no(fetchNextDocNo(getDoc_type_code()));
			}
           }
			HdrData.add(getDoc_no());			// DocNo - 2
			HdrData.add(getDoc_date());			// DocDate - 3
			HdrData.add(getDoc_ref());			// DocRef - 4
			HdrData.add("");// there is no store-code in this header as such... - 5
			HdrData.add("");//authorised_by  - 6
			//HdrData.add("Y");//finalized_yn  - 7
			HdrData.add(getFinalized_yn());//finalized_yn  - 7
			HdrData.add("N");//gl_interfaced_yn -8
			HdrData.add(getTrn_type());  // TrnType - 9
			HdrData.add("N");//sale_to_external_yn	- 10
			HdrData.add("");//ext_agency_name	- 11
		}
        catch(Exception exception) {
            exception.printStackTrace();
        }
		return HdrData;
	}

	/**
	* Method responsible to call the insert method in the EJB, which is responsible for
	* inserting the data.
	* @return HashMap, the Map containing the result and the message
	*/

	public HashMap insert() {

		HashMap hmResult = new HashMap();
		try {
			

			ArrayList alExpiredBatchesToBeInserted = new ArrayList();
			HashMap hmDataMap  = new HashMap();
			HashMap hmSQLMap = new HashMap();

			ArrayList alCommonData=new ArrayList();
			ArrayList  languageData=new ArrayList();

			alCommonData.add(getLoginById());
			alCommonData.add(getLoginAtWsNo());
			alCommonData.add(getLoginFacilityId());
			alCommonData.add(getFinalized_yn()); //Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
			
			languageData.add(getLanguageId());
			int size = alCheckedExpiredBatches.size();

			for(int i=0;i<size;i++) {
				HashMap hmExpiredBatch = new HashMap();

				String stBatch = (String)alCheckedExpiredBatches.get(i);
				StringTokenizer st = new StringTokenizer (stBatch,"||");

				hmExpiredBatch.put("item_code",st.nextToken());
				hmExpiredBatch.put("store_code",st.nextToken());
				hmExpiredBatch.put("batch_id",st.nextToken());
				hmExpiredBatch.put("bin_location_code",st.nextToken());
				hmExpiredBatch.put("expiry_date_or_receipt_date",st.nextToken());
				hmExpiredBatch.put("trade_id",st.nextToken());
				hmExpiredBatch.put("qty_on_hand",st.nextToken());
				hmExpiredBatch.put("replace_on_expiry_yn",st.nextToken());
				try{
					hmExpiredBatch.put("trn_remarks_code",st.nextToken());
				}catch(Exception e){
					hmExpiredBatch.put("trn_remarks_code","");
				}
				//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 
				hmExpiredBatch.put("doc_type_code", checkForNull(getDoc_type_code()));
				hmExpiredBatch.put("condemn_hdr_remarks", checkForNull(getAdj_remarks_Desc()));
				hmExpiredBatch.put("doc_ref" , checkForNull(getDoc_ref()));

				alExpiredBatchesToBeInserted.add(hmExpiredBatch);
			}
			/**
			* The following block of code will form the Header abd detail data by using
			* alExpiredBatchesToBeInserted
			*/

			alHeaderData	= new ArrayList();
			ArrayList alDetailData	= new ArrayList();
			ArrayList alExpData		= new ArrayList();		
			ArrayList alItemStoreData= new ArrayList();		
			
			ArrayList alStockOnlineData = new ArrayList();
			ArrayList alTrnDetail		= new ArrayList();

			ArrayList alHeaderRow	= getHeaderDataAsArrayList();
			ArrayList alDetailRow	= new ArrayList();
			//ArrayList alExpRow		= new ArrayList();


			/**
			* Logic to form the Header data
			*/

			HashMap hmRecord = (HashMap) alExpiredBatchesToBeInserted.get(0);
			String store_code = (String)hmRecord.get("store_code");
			if(getFinalized_yn().equals("Y")){
			alHeaderRow.set(5, store_code);
			alHeaderRow.add(getLoginById());
			alHeaderRow.add(getLoginAtWsNo());
			alHeaderRow.add(getLoginFacilityId());
			alHeaderRow.add(getLoginById());
			alHeaderRow.add(getLoginAtWsNo());
			alHeaderRow.add(getLoginFacilityId());
			//alHeaderRow.add(getAdj_remarks());
			alHeaderRow.add(checkForNull(getAdj_remarks_Desc()));
			alHeaderData.add(alHeaderRow);
			((HashMap) alExpiredBatchesToBeInserted.get(0)).put("doc_no", getDoc_no());

			int doc_no = Integer.parseInt(getDoc_no());

			for(int i=1;i<alExpiredBatchesToBeInserted.size();i++) {
				store_code = (String) (((HashMap)alExpiredBatchesToBeInserted.get(i)).get("store_code"));
				boolean flag = false;
				for (int j=0;j<alHeaderData.size();j++) {
					String list_store_code = (String)(((ArrayList)alHeaderData.get(j)).get(5));
					String list_doc_no = (String)(((ArrayList)alHeaderData.get(j)).get(2));
					if(list_store_code.equals(store_code)) {
						((HashMap)alExpiredBatchesToBeInserted.get(i)).put("doc_no",list_doc_no);
						flag = true;
						break;
					}
				}

				if (flag == false ) {
					doc_no++;
					alHeaderRow = getHeaderDataAsArrayList();
					alHeaderRow.set(2,Integer.toString(doc_no));
					alHeaderRow.set(5, store_code);
					alHeaderRow.add(getLoginById());
					alHeaderRow.add(getLoginAtWsNo());
					alHeaderRow.add(getLoginFacilityId());
					alHeaderRow.add(getLoginById());
					alHeaderRow.add(getLoginAtWsNo());
					alHeaderRow.add(getLoginFacilityId());
					alHeaderRow.add(checkForNull(getAdj_remarks_Desc()));
					alHeaderData.add(alHeaderRow);
					((HashMap)alExpiredBatchesToBeInserted.get(i)).put("doc_no",Integer.toString(doc_no));
				 }
			}



			/**
			* Logic to form the detail as well as exp data
			*/
			
			hmRecord = (HashMap)alExpiredBatchesToBeInserted.get(0);
			
			

			alDetailRow	= new ArrayList();

			alDetailRow.add(getLoginFacilityId());
			alDetailRow.add(getDoc_type_code());
			alDetailRow.add(hmRecord.get("doc_no"));
			alDetailRow.add("doc_srl_no");
			alDetailRow.add(hmRecord.get("item_code"));
			/*
			ArrayList alItemDetails = getItemDetails((String)(hmRecord.get("item_code")), (String) (hmRecord.get("store_code")));				
			double l_unit_cost = ((Double)alItemDetails.get(2)).doubleValue(); */
			/* @Name - Priya
				* @Date - 24/05/2010
				* @Inc# - 
				* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS'function and  assign it to the item_unit_cost field
				*/
				ArrayList alParameters = new ArrayList(); 		
				alParameters.add((String)(hmRecord.get("item_code")));
				alParameters.add((String) (hmRecord.get("store_code")));
				/*Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 beg
				double l_unit_cost=Double.parseDouble(getUnitCost((String)hmRecord.get("item_code"), (String) hmRecord.get("store_code")));

				double l_qty_on_hand = Double.parseDouble((String)(hmRecord.get("qty_on_hand")));*/
				double base_unit_cost=getBaseUnitCost((String)hmRecord.get("item_code"));
				double conv_fact =getConvFactTemp((String)hmRecord.get("item_code"), (String) hmRecord.get("store_code"));
				double l_unit_cost=base_unit_cost*conv_fact;
				double l_qty_on_hand = Double.parseDouble((String)(hmRecord.get("qty_on_hand")))/conv_fact;
				//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 end
				
				double l_item_cost_value = (l_unit_cost * l_qty_on_hand);
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());

			alDetailRow.add(Double.toString(-l_qty_on_hand));
			/*alDetailRow.add(setNumber(Double.toString(l_unit_cost),6));
			alDetailRow.add(setNumber(Double.toString(-l_item_cost_value),3));*/
			
                        alDetailRow.add(setNumber(""+l_unit_cost,noOfDecimalsForCost));
			alDetailRow.add(setNumber(Double.toString(-l_item_cost_value),noOfDecimalsForCost));

			alDetailRow.add("Condemned on:"+getDoc_date()); // remarks//PASS DOC_DATE PROCESS IT FOR REMARKS
			alDetailRow.add(getLoginById()); 
			alDetailRow.add(getLoginAtWsNo()); 
			alDetailRow.add(getLoginFacilityId()); 
			alDetailRow.add(getLoginById()); 
			alDetailRow.add(getLoginAtWsNo()); 
			alDetailRow.add(getLoginFacilityId()); 

			alDetailRow.add(hmRecord.get("store_code"));   // This has to be removed
			//alDetailRow.add(setNumber(Double.toString(l_unit_cost),6));  // This has to be removed		
			alDetailRow.add(setNumber(""+l_unit_cost,noOfDecimalsForCost));
			
                        alDetailData.add(alDetailRow);

			//((HashMap)alExpiredBatchesToBeInserted.get(0)).put("l_unit_cost", setNumber(Double.toString(l_unit_cost),6));
			((HashMap)alExpiredBatchesToBeInserted.get(0)).put("l_unit_cost",l_unit_cost);
			for(int i=1;i<alExpiredBatchesToBeInserted.size();i++) {
				store_code = (String) (((HashMap)alExpiredBatchesToBeInserted.get(i)).get("store_code"));
				String item_code = (String) (((HashMap)alExpiredBatchesToBeInserted.get(i)).get("item_code"));
				double qty_on_hand = Double.parseDouble((String) (((HashMap)alExpiredBatchesToBeInserted.get(i)).get("qty_on_hand")));
				//Added by suresh.r on 01/07/2015 against AAKH-SCF-0214 beg
				conv_fact =getConvFactTemp(item_code,store_code);
				base_unit_cost=getBaseUnitCost(item_code);
				//Added by suresh.r on 01/07/2015 against AAKH-SCF-0214 end

				boolean flag = false;

				for (int j=0;j<alDetailData.size();j++) {
					String list_store_code	= (String)(((ArrayList)alDetailData.get(j)).get(15));
					String list_item_code	= (String)(((ArrayList)alDetailData.get(j)).get(4));
					double qty_from_list		= Double.parseDouble((String)(((ArrayList)alDetailData.get(j)).get(5)));

					if(list_store_code.equals(store_code) && list_item_code.equals(item_code)) {
						qty_from_list=(Math.abs(qty_from_list) + Math.abs(qty_on_hand))*-1;		
						//((HashMap)alExpiredBatchesToBeInserted.get(i)).put("l_unit_cost",setNumber((String)((ArrayList)alDetailData.get(j)).get(16),6));
					((HashMap)alExpiredBatchesToBeInserted.get(i)).put("l_unit_cost",(((ArrayList)alDetailData.get(j)).get(16)));

						//l_unit_cost = ((Double)((ArrayList)alDetailData.get(j)).get(6));//Modified by suresh.r on 14/07/2015 against AAKH-SCF-0214
						l_unit_cost = (Double.parseDouble((String)((ArrayList)alDetailData.get(j)).get(6)));
						l_item_cost_value = (l_unit_cost * qty_from_list);

						((ArrayList)alDetailData.get(j)).set(5,Double.toString(qty_from_list));
						((ArrayList)alDetailData.get(j)).set(7,setNumber(Double.toString(l_item_cost_value),noOfDecimalsForCost));

						flag = true;
						break;
					}
				}

				if (flag == false ) {
					ArrayList alDetailDataRow = new ArrayList();
					alDetailDataRow.add(getLoginFacilityId());
					alDetailDataRow.add(getDoc_type_code());
					alDetailDataRow.add(((HashMap)alExpiredBatchesToBeInserted.get(i)).get("doc_no"));
					alDetailDataRow.add("doc_srl_no");
					alDetailDataRow.add(item_code);
					/**
					 * @Name - Priya
					 * @Date - 24/05/2010
					 * @Inc# - 
					 * @Desc -  Commented by priya as the l_unit_cost calculation is duplicated
					 */
					/*alItemDetails = getItemDetails(item_code, store_code);				
					l_unit_cost = ((Double)alItemDetails.get(2)).doubleValue();	*/

					//l_qty_on_hand = -Double.parseDouble((String)(((HashMap)alExpiredBatchesToBeInserted.get(i)).get("qty_on_hand")));
					//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 beg
					l_unit_cost=base_unit_cost*conv_fact;
					l_qty_on_hand = qty_on_hand/conv_fact;
					//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 end
					//l_item_cost_value = (l_unit_cost * l_qty_on_hand);

					alDetailDataRow.add(Double.toString(l_qty_on_hand));
					/*alDetailDataRow.add(setNumber(Double.toString(l_unit_cost),6));
					alDetailDataRow.add(setNumber(Double.toString(l_item_cost_value),3)); */

									
					//l_unit_cost = Double.parseDouble(getUnitCost(item_code,store_code));//Commented by suresh.r on 01/07/2015 against AAKH-SCF-0214

					l_item_cost_value = (l_unit_cost * l_qty_on_hand);
					
					alDetailDataRow.add(setNumber(""+l_unit_cost,noOfDecimalsForCost));
					alDetailDataRow.add(setNumber(Double.toString(l_item_cost_value),noOfDecimalsForCost));

					alDetailDataRow.add(""); // remarks
					alDetailDataRow.add(getLoginById()); 
					alDetailDataRow.add(getLoginAtWsNo()); 
					alDetailDataRow.add(getLoginFacilityId()); 
					alDetailDataRow.add(getLoginById()); 
					alDetailDataRow.add(getLoginAtWsNo()); 
					alDetailDataRow.add(getLoginFacilityId());
					
					alDetailDataRow.add(store_code);				// This has to be removed
					alDetailDataRow.add(Double.toString(l_unit_cost));  // This has to be removed		

					alDetailData.add(alDetailDataRow);
					

					((HashMap)alExpiredBatchesToBeInserted.get(i)).put("l_unit_cost",Double.toString(l_unit_cost));
				}
			}

			for (int i = 0; i<alExpiredBatchesToBeInserted.size();i++) {
				hmRecord = (HashMap)alExpiredBatchesToBeInserted.get(i);

				ArrayList alExpDataRow = new ArrayList();

//added by manish on Wednesday, October 22, 2003
				ArrayList alItemStoreRow = new ArrayList();
///////////
					/**
					 * @Name - Priya
					 * @Date - 24/05/2010
					 * @Inc# - 
					 * @Desc -  Commented by priya as the l_unit_cost calculation is duplicated
					 */
					/*alItemDetails = getItemDetails((String)hmRecord.get("item_code"), (String)hmRecord.get("store_code"));				
					l_unit_cost = ((Double)alItemDetails.get(2)).doubleValue();	 */
					
					//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 beg
					/*l_unit_cost=Double.parseDouble(getUnitCost((String)hmRecord.get("item_code"), (String) hmRecord.get("store_code")));

					l_qty_on_hand = Double.parseDouble((String)hmRecord.get("qty_on_hand"));*/
					base_unit_cost=getBaseUnitCost((String)hmRecord.get("item_code"));
					conv_fact =getConvFactTemp((String)hmRecord.get("item_code"), (String) hmRecord.get("store_code"));
					l_unit_cost=base_unit_cost*conv_fact;
					l_qty_on_hand = Double.parseDouble((String)(hmRecord.get("qty_on_hand")))/conv_fact;
					//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 end
					l_item_cost_value = (l_unit_cost * l_qty_on_hand);
//////////

				//alItemStoreRow.add(hmRecord.get("qty_on_hand"));
				alItemStoreRow.add(""+l_qty_on_hand);
				//alItemStoreRow.add(setNumber(""+l_item_cost_value,3));
				alItemStoreRow.add(setNumber(""+l_item_cost_value,noOfDecimalsForCost));	
				alItemStoreRow.add(getLoginById());
				alItemStoreRow.add(getLoginAtWsNo());
				alItemStoreRow.add(getLoginFacilityId());
				alItemStoreRow.add(hmRecord.get("item_code"));
				alItemStoreRow.add(hmRecord.get("store_code"));
				alItemStoreData.add(alItemStoreRow);
//				

				alExpDataRow.add(getLoginFacilityId());
				alExpDataRow.add(getDoc_type_code());
				alExpDataRow.add(hmRecord.get("doc_no"));
				alExpDataRow.add("doc_srl_no");
				alExpDataRow.add(hmRecord.get("store_code"));
				alExpDataRow.add(hmRecord.get("item_code"));
				alExpDataRow.add(hmRecord.get("batch_id"));
				alExpDataRow.add(hmRecord.get("bin_location_code"));
				alExpDataRow.add(hmRecord.get("expiry_date_or_receipt_date"));
				alExpDataRow.add(hmRecord.get("trade_id"));

				double negative_qty = -(Double.parseDouble((String)hmRecord.get("qty_on_hand")));

				alExpDataRow.add(""+negative_qty);
				alExpDataRow.add(getLoginById());
				alExpDataRow.add(getLoginAtWsNo());
				alExpDataRow.add(getLoginFacilityId());
				alExpDataRow.add(getLoginById());
				alExpDataRow.add(getLoginAtWsNo());
				alExpDataRow.add(getLoginFacilityId());
				
				//alExpDataRow.add(hmRecord.get("l_unit_cost")); // This has to be removed
				//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214
				alExpDataRow.add(setNumber(""+base_unit_cost,noOfDecimalsForCost));

				alExpData.add(alExpDataRow);
			}


			/**
			* Logic to generate doc_srl_no, trn_srl_no...
			*/

			for(int i=0;i<alHeaderData.size();i++) {
				String header_doc_no	= (String)(((ArrayList)alHeaderData.get(i)).get(2));
				int doc_srl_no = 1;
				for(int j=0;j<alDetailData.size();j++) {
					String dtl_doc_no	= (String)(((ArrayList)alDetailData.get(j)).get(2));
					if(header_doc_no.equals(dtl_doc_no)) {
						((ArrayList)alDetailData.get(j)).set(3,Integer.toString(doc_srl_no));
						doc_srl_no++;
					}
				}
			}

			for(int i=0;i<alDetailData.size();i++) {
				String detail_doc_no	= (String)(((ArrayList)alDetailData.get(i)).get(2));
				String detail_item_code = (String)(((ArrayList)alDetailData.get(i)).get(4));
				String detail_srl_no    = (String)(((ArrayList)alDetailData.get(i)).get(3));

				for(int j=0;j<alExpData.size();j++) {
					String exp_doc_no = (String)(((ArrayList)alExpData.get(j)).get(2));
					String exp_item_code = (String)(((ArrayList)alExpData.get(j)).get(5));

					if(exp_doc_no.equals(detail_doc_no) && exp_item_code.equals(detail_item_code)) {
						((ArrayList)alExpData.get(j)).set(3,detail_srl_no);	
					}
				}
			}


			for (int i=0;i<alExpData.size();i++) {
				ArrayList alExpDataRow = (ArrayList)(alExpData.get(i));

				double normal_trn_qty = Double.parseDouble((String)alExpDataRow.get(10));
				//int negative_trn_qty = - normal_trn_qty;

				HashMap hmParamaters = new HashMap();

				hmParamaters.put("item_code", alExpDataRow.get(5));
				hmParamaters.put("store_code", alExpDataRow.get(4));
				hmParamaters.put("trn_type",  (((ArrayList)(alHeaderData.get(0))).get(9)));
				hmParamaters.put("trn_qty", Double.toString(normal_trn_qty));
				hmParamaters.put("batch_id", alExpDataRow.get(6));
				hmParamaters.put("expiry_date_or_receipt_date", alExpDataRow.get(8));
				hmParamaters.put("trade_id", alExpDataRow.get(9));
				hmParamaters.put("from_bin_location_code", alExpDataRow.get(7));
				hmParamaters.put("suspended_batch_allowed_yn", "Y");

				hmParamaters.put("release_batch_yn","N");

				//hmParamaters.put("last_receipt_date", (((ArrayList)(alHeaderData.get(0))).get(3))); // doc_date

				hmParamaters.put("login_by_id", alCommonData.get(0));
				hmParamaters.put("login_at_ws_no", alCommonData.get(1));
				hmParamaters.put("login_facility_id", alCommonData.get(2));

			
				alStockOnlineData.add(hmParamaters);

				/* Insert in to st_item_trn_dtl table*/

				ArrayList alExpRecord = new ArrayList();
				alExpRecord.add(((ArrayList)(alHeaderData.get(0))).get(0));
				alExpRecord.add(alExpDataRow.get(4));
				alExpRecord.add(alExpDataRow.get(5));
				alExpRecord.add("trn_srl_no");
				alExpRecord.add((((ArrayList)(alHeaderData.get(0))).get(9)));
				alExpRecord.add(((ArrayList)(alHeaderData.get(0))).get(1)); // doc_type_code
				alExpRecord.add(alExpDataRow.get(2)); // doc_no
				alExpRecord.add(alExpDataRow.get(3));
				alExpRecord.add(((ArrayList)(alHeaderData.get(0))).get(3)); // doc_date
				alExpRecord.add(((ArrayList)(alHeaderData.get(0))).get(4)); // doc_ref
				alExpRecord.add(alExpDataRow.get(6));
				alExpRecord.add(alExpDataRow.get(8));
				alExpRecord.add(""+normal_trn_qty);	// item_qty_normal
				alExpRecord.add(alExpDataRow.get(17));
				alExpRecord.add(getStockUOMCode((String)alExpDataRow.get(5)));  // Stock - uom code
				alExpRecord.add("Y"); // stock_item_yn
				alExpRecord.add(alCommonData.get(0));
				alExpRecord.add(alCommonData.get(1));
				alExpRecord.add(alCommonData.get(2));
				alExpRecord.add(alCommonData.get(0));
				alExpRecord.add(alCommonData.get(1));
				alExpRecord.add(alCommonData.get(2));

				alExpRecord.add(alExpDataRow.get(7)); // bin_location_code
				alExpRecord.add(alExpDataRow.get(9)); // trade_id

				alTrnDetail.add(alExpRecord);

			}

			for(int i=0; i<alDetailData.size(); i++) {
				String detail_doc_no	= (String)(((ArrayList)alDetailData.get(i)).get(2));
				String detail_doc_srl_no    = (String)(((ArrayList)alDetailData.get(i)).get(3));

				int trn_srl_no			=	1;

				for(int j=0; j<alTrnDetail.size(); j++) {
					String trn_doc_no	= (String)(((ArrayList)alTrnDetail.get(j)).get(6));
					String trn_doc_srl_no    = (String)(((ArrayList)alTrnDetail.get(j)).get(7));
					if (detail_doc_no.equals(trn_doc_no) && detail_doc_srl_no.equals(trn_doc_srl_no)) {
						((ArrayList)alTrnDetail.get(j)).set(3, Integer.toString(trn_srl_no));
						trn_srl_no++;
					}
				}
			}


			/* Code to form the item move summary insert data
			*/
			ArrayList alItmMoveSummData = new ArrayList();
			for(int i=0;i<alDetailData.size();i++) {
				HashMap hmItmMoveSummRecord = new HashMap();
				ArrayList alDtlRow = (ArrayList)alDetailData.get(i);	
				hmItmMoveSummRecord.put("facility_id", alDtlRow.get(0));
				hmItmMoveSummRecord.put("item_code", alDtlRow.get(4));
				hmItmMoveSummRecord.put("store_code", alDtlRow.get(15));
				hmItmMoveSummRecord.put("doc_date", getDoc_date());
				hmItmMoveSummRecord.put("adj_qty", alDtlRow.get(5));
				hmItmMoveSummRecord.put("adj_cost", alDtlRow.get(7));
				hmItmMoveSummRecord.put("login_by_id", alDtlRow.get(9));
				hmItmMoveSummRecord.put("login_at_ws_no", alDtlRow.get(10));
				hmItmMoveSummRecord.put("login_facility_id", alDtlRow.get(11));
				alItmMoveSummData.add(hmItmMoveSummRecord);
			}		
			

			/* Item movement summary data formation ends here
			*/

			for(int i=0;i<alDetailData.size();i++) {
				((ArrayList)(alDetailData.get(i))).remove(15);
				((ArrayList)(alDetailData.get(i))).remove(15);
			}
			for(int i=0;i<alExpData.size();i++) {
				((ArrayList)(alExpData.get(i))).remove(17);
			}			


			boolean isDocNoAutoGenYN = isDocNoAutoGenYN((String)( ((ArrayList) (alHeaderData.get(0))).get(1)));
			
			hmDataMap.put("HeaderData", alHeaderData);
			hmDataMap.put("DetailData", alDetailData);
			hmDataMap.put("ExpData", alExpData);
			hmDataMap.put("ItemStoreData", alItemStoreData);
			hmDataMap.put("ItemMoveSummData", alItmMoveSummData);
			hmDataMap.put("alTrnDetail", alTrnDetail);
			hmDataMap.put("alStockOnlineData", alStockOnlineData);
			hmDataMap.put("isDocNoAutoGenYN", new Boolean(isDocNoAutoGenYN));
		}
			hmDataMap.put("properties",	getProperties());
			hmDataMap.put("InsertData", alExpiredBatchesToBeInserted);
			hmDataMap.put("CommonData", alCommonData);
			hmDataMap.put("LanguageData", languageData);

			
			//Commented  by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
			/*hmSQLMap.put("CondemnIDSelectSQL", getStRepositoryValue("SQL_ST_CONDEMN_ID_SELECT"));
			hmSQLMap.put("ExpiredItemInsertSQL", getStRepositoryValue("SQL_ST_EXPIRED_ITEM_INSERT"));
			hmSQLMap.put("CondemnIDUpdateSQL", getStRepositoryValue("SQL_ST_CONDEMN_ID_UPDATE"));

			hmSQLMap.put("HeaderInsertSQL", getStRepositoryValue("SQL_ST_ADJ_HDR_INSERT_FOR_CON_EXP"));
			hmSQLMap.put("DetailInsertSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_INSERT"));
			hmSQLMap.put("ExpInsertSQL", "INSERT  INTO st_adj_dtl_exp(facility_id, doc_type_code,	doc_no,	doc_srl_no,	store_code,	item_code, batch_id, bin_location_code,	expiry_date_or_receipt_date, trade_id, item_qty, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date,	modified_at_ws_no, modified_facility_id) VALUES	(?,	?, ?, ?, ?,	?, ?, ?, to_date(?,'dd/mm/yyyy'), ?, ?,	?, SYSDATE,? , ?, ?, SYSDATE, ?, ?)");
			hmSQLMap.put("DocNoUpdate", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));

			// Queries for Online Stock updation
			hmSQLMap.put("ItemTrnDtlInsertSQL", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT"));
			hmSQLMap.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
			hmSQLMap.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
			hmSQLMap.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
			hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));

			hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
			hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
			hmSQLMap.put("ItemMovSumInsertSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_ADJ"));
			hmSQLMap.put("ItemMovSumUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_UPDATE"));
			hmSQLMap.put("SQL_ST_ITEM_STORE_QTY_ON_HAND_UPDATE", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_ON_HAND_UPDATE"));
			hmSQLMap.put("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE", getStRepositoryValue("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE"));
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_CONDEMN_EXPIRED_BATCHES"),eST.CondemnExpiredBatches.CondemnExpiredBatchesHome.class,getLocalEJB());
		   Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		Object argArray[] = new Object[2];
		argArray[0] = hmDataMap;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmDataMap.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

		 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

		if( ((Boolean) hmResult.get("result")).booleanValue() )	{
			hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
		}
		else if( hmResult.get("msgid")!=null  ) {
			hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST")) ;
		}
		else {
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		}

			String alertRqdYN = "";
			PgetDoc_type_code = getDoc_type_code();
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			stReportid= "STBCEBDC";
			if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			{
				if ( isInternalRequest("ST",stReportid) &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{
						if(alertRqdYN.equals("Y")){	
							hmResult.put("flag",hmResult.get("flag") + "~PY");
						}
						else{
								CalldoOnlineReportPrinting();
							//	doOnlineReportPrinting(doc_nos);				
							}
				 }
			}

*/


			/*hmResult = new eST.CondemnTemp.CondemnExpiredBatchesManager().insert( hmDataMap, hmSQLMap ) ;*/
			hmSQLMap=stockSQL();  
			return condemnMethodCall(hmDataMap, hmSQLMap, FUNCTION_INSERT );
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return hmResult;
	}
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
	public HashMap modify() {

		HashMap hmResult = new HashMap();
		try {
			ArrayList alExpiredBatchesToBeInserted = new ArrayList();
			HashMap hmDataMap  =       new HashMap();
			HashMap hmSQLMap   =      new HashMap();
			ArrayList alCommonData =  new ArrayList();
			ArrayList  languageData = new ArrayList();

			alCommonData.add(getLoginById());
			alCommonData.add(getLoginAtWsNo());
			alCommonData.add(getLoginFacilityId());
			alCommonData.add(getFinalized_yn()); //finalise_yn
			alCommonData.add(getCon_doc_no()); //con doc_no
			alCommonData.add(checkForNull(getDoc_type_code())); //doc_type_code
			
			languageData.add(getLanguageId());
			int size = alCheckedExpiredBatches.size();
			for(int i=0;i<size;i++) {
				HashMap hmExpiredBatch = new HashMap();

				String stBatch = (String)alCheckedExpiredBatches.get(i);
				StringTokenizer st = new StringTokenizer (stBatch,"||");

				hmExpiredBatch.put("item_code",st.nextToken());
				hmExpiredBatch.put("store_code",st.nextToken());
				hmExpiredBatch.put("batch_id",st.nextToken());
				hmExpiredBatch.put("bin_location_code",st.nextToken());
				hmExpiredBatch.put("expiry_date_or_receipt_date",st.nextToken());
				hmExpiredBatch.put("trade_id",st.nextToken());
				hmExpiredBatch.put("qty_on_hand",st.nextToken());
				hmExpiredBatch.put("replace_on_expiry_yn",st.nextToken());
				try{
					hmExpiredBatch.put("trn_remarks_code",st.nextToken());
				}catch(Exception e){
					hmExpiredBatch.put("trn_remarks_code","");
				}
				hmExpiredBatch.put("doc_type_code", checkForNull(getDoc_type_code()));
				hmExpiredBatch.put("condemn_hdr_remarks", checkForNull(getAdj_remarks_Desc()));
				hmExpiredBatch.put("doc_ref" , checkForNull(getDoc_ref()));
				
				alExpiredBatchesToBeInserted.add(hmExpiredBatch);
			}
			alHeaderData	= new ArrayList();
			ArrayList alDetailData	= new ArrayList();
			ArrayList alExpData		= new ArrayList();		
			ArrayList alItemStoreData= new ArrayList();		
			
			ArrayList alStockOnlineData = new ArrayList();
			ArrayList alTrnDetail		= new ArrayList();

			ArrayList alHeaderRow	= getHeaderDataAsArrayList();
			ArrayList alDetailRow	= new ArrayList();
			
			 
			
			/**
			* Logic to form the Header data
			*/
			HashMap hmRecord = (HashMap) alExpiredBatchesToBeInserted.get(0);
			String store_code = (String)hmRecord.get("store_code");
			if(getFinalized_yn().equals("Y")){ 
			alHeaderRow.set(5, store_code);
			alHeaderRow.add(getLoginById());
			alHeaderRow.add(getLoginAtWsNo());
			alHeaderRow.add(getLoginFacilityId());
			alHeaderRow.add(getLoginById());
			alHeaderRow.add(getLoginAtWsNo());
			alHeaderRow.add(getLoginFacilityId());
			alHeaderRow.add(getAdj_remarks_Desc());
			alHeaderData.add(alHeaderRow);
			
			((HashMap) alExpiredBatchesToBeInserted.get(0)).put("doc_no", getDoc_no());
			int doc_no = Integer.parseInt(getDoc_no());
			for(int i=1;i<alExpiredBatchesToBeInserted.size();i++) {
				store_code = (String) (((HashMap)alExpiredBatchesToBeInserted.get(i)).get("store_code"));
				boolean flag = false;
				for (int j=0;j<alHeaderData.size();j++) {
					String list_store_code = (String)(((ArrayList)alHeaderData.get(j)).get(5));
					String list_doc_no = (String)(((ArrayList)alHeaderData.get(j)).get(2));
					if(list_store_code.equals(store_code)) {
						((HashMap)alExpiredBatchesToBeInserted.get(i)).put("doc_no",list_doc_no);
						flag = true;
						break;
					}
				}

				if (flag == false ) {
					doc_no++;
					alHeaderRow = getHeaderDataAsArrayList();
					alHeaderRow.set(2,Integer.toString(doc_no));
					alHeaderRow.set(5, store_code);
					alHeaderRow.add(getLoginById());
					alHeaderRow.add(getLoginAtWsNo());
					alHeaderRow.add(getLoginFacilityId());  
					alHeaderRow.add(getLoginById());
					alHeaderRow.add(getLoginAtWsNo());
					alHeaderRow.add(getLoginFacilityId());
					alHeaderRow.add(getAdj_remarks_Desc());  
					alHeaderData.add(alHeaderRow);
					((HashMap)alExpiredBatchesToBeInserted.get(i)).put("doc_no",Integer.toString(doc_no));
				 }
			}
			/**
			* Logic to form the detail as well as exp data
			*/
			
			hmRecord = (HashMap)alExpiredBatchesToBeInserted.get(0);
			alDetailRow	= new ArrayList();
			alDetailRow.add(getLoginFacilityId());
			alDetailRow.add(getDoc_type_code());
			alDetailRow.add(hmRecord.get("doc_no"));
			alDetailRow.add("doc_srl_no");
			alDetailRow.add(hmRecord.get("item_code"));
			
				ArrayList alParameters = new ArrayList(); 		
				alParameters.add((String)(hmRecord.get("item_code")));
				alParameters.add((String) (hmRecord.get("store_code")));
				/*Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 beg
				double l_unit_cost=Double.parseDouble(getUnitCost((String)hmRecord.get("item_code"), (String) hmRecord.get("store_code")));

				double l_qty_on_hand = Double.parseDouble((String)(hmRecord.get("qty_on_hand")));*/
				double base_unit_cost=getBaseUnitCost((String)hmRecord.get("item_code"));
				double conv_fact =getConvFactTemp((String)hmRecord.get("item_code"), (String) hmRecord.get("store_code"));
				double l_unit_cost=base_unit_cost*conv_fact;
				double l_qty_on_hand = Double.parseDouble((String)(hmRecord.get("qty_on_hand")))/conv_fact;
				//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 end
				
				double l_item_cost_value = (l_unit_cost * l_qty_on_hand);
				int noOfDecimalsForCost=Integer.parseInt(getNoOfDecimalsCost());

			alDetailRow.add(Double.toString(-l_qty_on_hand));
            alDetailRow.add(setNumber(""+l_unit_cost,noOfDecimalsForCost));
			alDetailRow.add(setNumber(Double.toString(-l_item_cost_value),noOfDecimalsForCost));
			alDetailRow.add("Condemned on:"+getDoc_date()); // remarks//PASS DOC_DATE PROCESS IT FOR REMARKS
			alDetailRow.add(getLoginById()); 
			alDetailRow.add(getLoginAtWsNo()); 
			alDetailRow.add(getLoginFacilityId()); 
			alDetailRow.add(getLoginById()); 
			alDetailRow.add(getLoginAtWsNo()); 
			alDetailRow.add(getLoginFacilityId()); 
			alDetailRow.add(hmRecord.get("store_code"));   // This has to be removed
			alDetailRow.add(l_unit_cost);
            alDetailData.add(alDetailRow);

			((HashMap)alExpiredBatchesToBeInserted.get(0)).put("l_unit_cost",l_unit_cost);
			for(int i=1;i<alExpiredBatchesToBeInserted.size();i++) {
				store_code = (String) (((HashMap)alExpiredBatchesToBeInserted.get(i)).get("store_code"));
				String item_code = (String) (((HashMap)alExpiredBatchesToBeInserted.get(i)).get("item_code"));
				double qty_on_hand = Double.parseDouble((String) (((HashMap)alExpiredBatchesToBeInserted.get(i)).get("qty_on_hand")));
				//Added by suresh.r on 01/07/2015 against AAKH-SCF-0214 beg
				base_unit_cost=getBaseUnitCost(item_code);
				conv_fact =getConvFactTemp(item_code,store_code);
				//Added by suresh.r on 01/07/2015 against AAKH-SCF-0214 end

				boolean flag = false;

				for (int j=0;j<alDetailData.size();j++) {
					String list_store_code	= (String)(((ArrayList)alDetailData.get(j)).get(15));
					String list_item_code	= (String)(((ArrayList)alDetailData.get(j)).get(4));
					double qty_from_list		= Double.parseDouble((String)(((ArrayList)alDetailData.get(j)).get(5)));
					
					if(list_store_code.equals(store_code) && list_item_code.equals(item_code)) {
						qty_from_list=(Math.abs(qty_from_list) + Math.abs(qty_on_hand))*-1;		
						
					((HashMap)alExpiredBatchesToBeInserted.get(i)).put("l_unit_cost",(((ArrayList)alDetailData.get(j)).get(16)));

						//l_unit_cost = ((Double)((ArrayList)alDetailData.get(j)).get(6));
					//Modified by suresh.r on 14-07-2015 against
					l_unit_cost = Double.parseDouble((String)((ArrayList)alDetailData.get(j)).get(6));
						l_item_cost_value = (l_unit_cost * qty_from_list);

						((ArrayList)alDetailData.get(j)).set(5,Double.toString(qty_from_list));
						((ArrayList)alDetailData.get(j)).set(7,setNumber(Double.toString(l_item_cost_value),noOfDecimalsForCost));

						flag = true;
						break;
					}
				}

				if (flag == false ) {
					ArrayList alDetailDataRow = new ArrayList();
					alDetailDataRow.add(getLoginFacilityId());
					alDetailDataRow.add(getDoc_type_code());
					alDetailDataRow.add(((HashMap)alExpiredBatchesToBeInserted.get(i)).get("doc_no"));
					alDetailDataRow.add("doc_srl_no");
					alDetailDataRow.add(item_code);
					//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 beg
					//l_qty_on_hand = -Double.parseDouble((String)(((HashMap)alExpiredBatchesToBeInserted.get(i)).get("qty_on_hand")));
					l_qty_on_hand =-qty_on_hand/conv_fact; 
					
					alDetailDataRow.add(Double.toString(l_qty_on_hand));
						
					//l_unit_cost = Double.parseDouble(getUnitCost(item_code,store_code));
					l_unit_cost =base_unit_cost*conv_fact;
					l_item_cost_value = (l_unit_cost * l_qty_on_hand);
			
					alDetailDataRow.add(setNumber(""+l_unit_cost,noOfDecimalsForCost));
					alDetailDataRow.add(setNumber(Double.toString(l_item_cost_value),noOfDecimalsForCost));
					alDetailDataRow.add(""); // remarks
					alDetailDataRow.add(getLoginById()); 
					alDetailDataRow.add(getLoginAtWsNo()); 
					alDetailDataRow.add(getLoginFacilityId()); 
					alDetailDataRow.add(getLoginById()); 
					alDetailDataRow.add(getLoginAtWsNo()); 
					alDetailDataRow.add(getLoginFacilityId());
					alDetailDataRow.add(store_code);				// This has to be removed
					alDetailDataRow.add(Double.toString(l_unit_cost));  // This has to be removed		
					alDetailData.add(alDetailDataRow);
					
					((HashMap)alExpiredBatchesToBeInserted.get(i)).put("l_unit_cost",Double.toString(l_unit_cost));
				}
			}
			
			for (int i = 0; i<alExpiredBatchesToBeInserted.size();i++) {
				hmRecord = (HashMap)alExpiredBatchesToBeInserted.get(i);
				
				ArrayList alExpDataRow = new ArrayList();
				ArrayList alItemStoreRow = new ArrayList();
					/*Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 beg
					l_unit_cost=Double.parseDouble(getUnitCost((String)hmRecord.get("item_code"), (String) hmRecord.get("store_code")));

					l_qty_on_hand = Double.parseDouble((String)hmRecord.get("qty_on_hand"));*/
					base_unit_cost=getBaseUnitCost((String)hmRecord.get("item_code"));
					conv_fact =getConvFactTemp((String)hmRecord.get("item_code"), (String) hmRecord.get("store_code"));
					l_unit_cost=base_unit_cost*conv_fact;
					l_qty_on_hand = Double.parseDouble((String)(hmRecord.get("qty_on_hand")))/conv_fact;
					//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214 end
					l_item_cost_value = (l_unit_cost * l_qty_on_hand);
 

				//alItemStoreRow.add(hmRecord.get("qty_on_hand"));
				alItemStoreRow.add(""+l_qty_on_hand);
				alItemStoreRow.add(setNumber(""+l_item_cost_value,noOfDecimalsForCost));	
				alItemStoreRow.add(getLoginById());
				alItemStoreRow.add(getLoginAtWsNo());
				alItemStoreRow.add(getLoginFacilityId());
				alItemStoreRow.add(hmRecord.get("item_code"));
				alItemStoreRow.add(hmRecord.get("store_code"));
				alItemStoreData.add(alItemStoreRow);

				alExpDataRow.add(getLoginFacilityId());
				alExpDataRow.add(getDoc_type_code());
				alExpDataRow.add(hmRecord.get("doc_no"));
				alExpDataRow.add("doc_srl_no");
				alExpDataRow.add(hmRecord.get("store_code"));
				alExpDataRow.add(hmRecord.get("item_code"));
				alExpDataRow.add(hmRecord.get("batch_id"));
				alExpDataRow.add(hmRecord.get("bin_location_code"));
				alExpDataRow.add(hmRecord.get("expiry_date_or_receipt_date"));
				alExpDataRow.add(hmRecord.get("trade_id"));

				double negative_qty = -(Double.parseDouble((String)hmRecord.get("qty_on_hand")));

				alExpDataRow.add(""+negative_qty);
				alExpDataRow.add(getLoginById());
				alExpDataRow.add(getLoginAtWsNo());
				alExpDataRow.add(getLoginFacilityId());
				alExpDataRow.add(getLoginById());
				alExpDataRow.add(getLoginAtWsNo());
				alExpDataRow.add(getLoginFacilityId());
				//alExpDataRow.add(hmRecord.get("l_unit_cost")); // This has to be removed
				//Modified by suresh.r on 01/07/2015 against AAKH-SCF-0214
				alExpDataRow.add(setNumber(""+base_unit_cost,noOfDecimalsForCost));

				alExpData.add(alExpDataRow);
			}


			/**
			* Logic to generate doc_srl_no, trn_srl_no...
			*/

			for(int i=0;i<alHeaderData.size();i++) {
				String header_doc_no	= (String)(((ArrayList)alHeaderData.get(i)).get(2));
				int doc_srl_no = 1;
				for(int j=0;j<alDetailData.size();j++) {
					String dtl_doc_no	= (String)(((ArrayList)alDetailData.get(j)).get(2));
					if(header_doc_no.equals(dtl_doc_no)) {
						((ArrayList)alDetailData.get(j)).set(3,Integer.toString(doc_srl_no));
						doc_srl_no++;
					}
				}
			}

			for(int i=0;i<alDetailData.size();i++) {
				String detail_doc_no	= (String)(((ArrayList)alDetailData.get(i)).get(2));
				String detail_item_code = (String)(((ArrayList)alDetailData.get(i)).get(4));
				String detail_srl_no    = (String)(((ArrayList)alDetailData.get(i)).get(3));

				for(int j=0;j<alExpData.size();j++) {
					String exp_doc_no = (String)(((ArrayList)alExpData.get(j)).get(2));
					String exp_item_code = (String)(((ArrayList)alExpData.get(j)).get(5));

					if(exp_doc_no.equals(detail_doc_no) && exp_item_code.equals(detail_item_code)) {
						((ArrayList)alExpData.get(j)).set(3,detail_srl_no);	
					}
				}
			}


			for (int i=0;i<alExpData.size();i++) {
				ArrayList alExpDataRow = (ArrayList)(alExpData.get(i));

				double normal_trn_qty = Double.parseDouble((String)alExpDataRow.get(10));

				HashMap hmParamaters = new HashMap();

				hmParamaters.put("item_code", alExpDataRow.get(5));
				hmParamaters.put("store_code", alExpDataRow.get(4));
				hmParamaters.put("trn_type",  (((ArrayList)(alHeaderData.get(0))).get(9)));
				hmParamaters.put("trn_qty", Double.toString(normal_trn_qty));
				hmParamaters.put("batch_id", alExpDataRow.get(6));
				hmParamaters.put("expiry_date_or_receipt_date", alExpDataRow.get(8));
				hmParamaters.put("trade_id", alExpDataRow.get(9));
				hmParamaters.put("from_bin_location_code", alExpDataRow.get(7));
				hmParamaters.put("suspended_batch_allowed_yn", "Y");
				hmParamaters.put("release_batch_yn","N");
				hmParamaters.put("login_by_id", alCommonData.get(0));
				hmParamaters.put("login_at_ws_no", alCommonData.get(1));
				hmParamaters.put("login_facility_id", alCommonData.get(2));
			
				alStockOnlineData.add(hmParamaters);

				/* Insert in to st_item_trn_dtl table*/

				ArrayList alExpRecord = new ArrayList();
				alExpRecord.add(((ArrayList)(alHeaderData.get(0))).get(0));
				alExpRecord.add(alExpDataRow.get(4));
				alExpRecord.add(alExpDataRow.get(5));
				alExpRecord.add("trn_srl_no");
				alExpRecord.add((((ArrayList)(alHeaderData.get(0))).get(9)));
				alExpRecord.add(((ArrayList)(alHeaderData.get(0))).get(1)); // doc_type_code
				alExpRecord.add(alExpDataRow.get(2)); // doc_no
				alExpRecord.add(alExpDataRow.get(3));
				alExpRecord.add(((ArrayList)(alHeaderData.get(0))).get(3)); // doc_date
				alExpRecord.add(((ArrayList)(alHeaderData.get(0))).get(4)); // doc_ref
				alExpRecord.add(alExpDataRow.get(6));
				alExpRecord.add(alExpDataRow.get(8));
				alExpRecord.add(""+normal_trn_qty);	// item_qty_normal
				alExpRecord.add(alExpDataRow.get(17));
				alExpRecord.add(getStockUOMCode((String)alExpDataRow.get(5)));  // Stock - uom code
				alExpRecord.add("Y"); // stock_item_yn
				alExpRecord.add(alCommonData.get(0));
				alExpRecord.add(alCommonData.get(1));
				alExpRecord.add(alCommonData.get(2));
				alExpRecord.add(alCommonData.get(0));
				alExpRecord.add(alCommonData.get(1));
				alExpRecord.add(alCommonData.get(2));

				alExpRecord.add(alExpDataRow.get(7)); // bin_location_code
				alExpRecord.add(alExpDataRow.get(9)); // trade_id

				alTrnDetail.add(alExpRecord);

			}

			for(int i=0; i<alDetailData.size(); i++) {
				String detail_doc_no	= (String)(((ArrayList)alDetailData.get(i)).get(2));
				String detail_doc_srl_no    = (String)(((ArrayList)alDetailData.get(i)).get(3));

				int trn_srl_no			=	1;

				for(int j=0; j<alTrnDetail.size(); j++) {
					String trn_doc_no	= (String)(((ArrayList)alTrnDetail.get(j)).get(6));
					String trn_doc_srl_no    = (String)(((ArrayList)alTrnDetail.get(j)).get(7));
					if (detail_doc_no.equals(trn_doc_no) && detail_doc_srl_no.equals(trn_doc_srl_no)) {
						((ArrayList)alTrnDetail.get(j)).set(3, Integer.toString(trn_srl_no));
						trn_srl_no++;
					}
				}
			}


			/* Code to form the item move summary insert data
			*/
			ArrayList alItmMoveSummData = new ArrayList();
			for(int i=0;i<alDetailData.size();i++) {
				HashMap hmItmMoveSummRecord = new HashMap();
				ArrayList alDtlRow = (ArrayList)alDetailData.get(i);	
				hmItmMoveSummRecord.put("facility_id", alDtlRow.get(0));
				hmItmMoveSummRecord.put("item_code", alDtlRow.get(4));
				hmItmMoveSummRecord.put("store_code", alDtlRow.get(15));
				hmItmMoveSummRecord.put("doc_date", getDoc_date());
				hmItmMoveSummRecord.put("adj_qty", alDtlRow.get(5));
				hmItmMoveSummRecord.put("adj_cost", alDtlRow.get(7));
				hmItmMoveSummRecord.put("login_by_id", alDtlRow.get(9));
				hmItmMoveSummRecord.put("login_at_ws_no", alDtlRow.get(10));
				hmItmMoveSummRecord.put("login_facility_id", alDtlRow.get(11));
				alItmMoveSummData.add(hmItmMoveSummRecord);
			}		
			

			/* Item movement summary data formation ends here
			*/

			for(int i=0;i<alDetailData.size();i++) {
				((ArrayList)(alDetailData.get(i))).remove(15);
				((ArrayList)(alDetailData.get(i))).remove(15);
			}
			for(int i=0;i<alExpData.size();i++) {
				((ArrayList)(alExpData.get(i))).remove(17);
			}			
			boolean isDocNoAutoGenYN = isDocNoAutoGenYN((String)( ((ArrayList) (alHeaderData.get(0))).get(1)));
			
			  
			hmDataMap.put("HeaderData", alHeaderData);
			hmDataMap.put("DetailData", alDetailData);
			hmDataMap.put("ExpData", alExpData);
			hmDataMap.put("ItemStoreData", alItemStoreData);
			hmDataMap.put("ItemMoveSummData", alItmMoveSummData);
			hmDataMap.put("alTrnDetail", alTrnDetail);
			hmDataMap.put("alStockOnlineData", alStockOnlineData);
			hmDataMap.put("isDocNoAutoGenYN", new Boolean(isDocNoAutoGenYN));
		}
			hmDataMap.put("properties",	getProperties());
			hmDataMap.put("InsertData", alExpiredBatchesToBeInserted);
			hmDataMap.put("CommonData", alCommonData);
			hmDataMap.put("LanguageData", languageData);
			
			hmSQLMap=stockSQL();  
			return condemnMethodCall(hmDataMap, hmSQLMap, FUNCTION_UPDATE);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return hmResult;
	}
	
	public HashMap delete() {

		HashMap hmResult = new HashMap();
		try {
			HashMap hmDataMap  = new HashMap();
			HashMap hmSQLMap = new HashMap();
			ArrayList alCommonData=new ArrayList();
			ArrayList  languageData=new ArrayList();

			alCommonData.add(getLoginById());
			alCommonData.add(getLoginAtWsNo());
			alCommonData.add(getLoginFacilityId());
			alCommonData.add(getFinalized_yn()); //finalise_yn
			alCommonData.add(getCon_doc_no()); //con doc_no 
			alCommonData.add(getDoc_type_code()); //con doc type code 
			
			languageData.add(getLanguageId());
			
			hmDataMap.put("properties",	getProperties());
			hmDataMap.put("CommonData", alCommonData);
			hmDataMap.put("LanguageData", languageData);
			
			hmSQLMap=stockSQL();  
		 
			return condemnMethodCall(hmDataMap, hmSQLMap, FUNCTION_DELETE);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return hmResult;
	}
	public HashMap condemnMethodCall(HashMap hmDataMap, HashMap hmSQLMap, int functionID ){
		

		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;
		try
		{
		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_CONDEMN_EXPIRED_BATCHES"),eST.CondemnExpiredBatches.CondemnExpiredBatchesHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
		
		Object argArray[] = new Object[2];
		argArray[0] = hmDataMap;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmDataMap.getClass(); 
		paramArray[1] = hmSQLMap.getClass();
		 
		switch (functionID) {
		     case FUNCTION_INSERT: 
				hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
				break;
			
			case FUNCTION_UPDATE:
				hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
				break;
			
			case FUNCTION_DELETE:
				hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
				break;
			
			default:
				hmResult.put( "message", "Invalid Function ID passed to condemnMethodCall()") ;
		}
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
		
		if( ((Boolean) hmResult.get("result")).booleanValue() )	{ 
			hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
		}
		else if( hmResult.get("msgid")!=null  ) {
			hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST")) ;
		}
		 else {
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		}
		
          /* SEND TO PRINT ONLINE REPORT STARTS*/	
		
	
	        String doc_no	=	(String)hmResult.get("doc_no");	
	        String alertRqdYN = "";
			PgetDoc_type_code = getDoc_type_code();
			ArrayList aldocdtl  = new ArrayList(); 
			ArrayList params   =  new ArrayList();
                aldocdtl.add(checkForNull(PgetDoc_type_code));
                aldocdtl.add(checkForNull(doc_no));
			    setPrintDocNo(aldocdtl);
				
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
			alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			stReportid= "STBCEBDC";
			if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue()))
			{
				if ( isInternalRequest("ST",stReportid) &&  isDocTypePrintAllowed(PgetDoc_type_code) ) 
				{
						if(alertRqdYN.equals("Y")){	
							hmResult.put("flag",hmResult.get("flag") + "~PY");
						}
						else{
								//CalldoOnlineReportPrinting();
								hmResult.put("flag",hmResult.get("flag") + "~PN");
							}
				 }
			}
		}
		catch (Exception e)
		{		
		  e.printStackTrace();
		}

		return hmResult;
	}
	public HashMap stockSQL(){
	HashMap hmSQLMap		=	new HashMap();
	
	        hmSQLMap.put("CondemnIDSelectSQL", getStRepositoryValue("SQL_ST_CONDEMN_ID_SELECT"));
	        //hmSQLMap.put("ExpiredItemInsertSQL", getStRepositoryValue("SQL_ST_EXPIRED_ITEM_INSERT"));
	        hmSQLMap.put("ExpiredItemInsertSQL", getStRepositoryValue("SQL_ST_EXPIRED_ITEM_INSERT_CONDEMN"));
			hmSQLMap.put("CondemnIDUpdateSQL", getStRepositoryValue("SQL_ST_CONDEMN_ID_UPDATE"));
			hmSQLMap.put("HeaderInsertSQL", getStRepositoryValue("SQL_ST_ADJ_HDR_INSERT_FOR_CON_EXP"));
			hmSQLMap.put("DetailInsertSQL", getStRepositoryValue("SQL_ST_ADJ_DTL_INSERT"));
			hmSQLMap.put("ExpInsertSQL", "INSERT  INTO st_adj_dtl_exp(facility_id, doc_type_code,	doc_no,	doc_srl_no,	store_code,	item_code, batch_id, bin_location_code,	expiry_date_or_receipt_date, trade_id, item_qty, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date,	modified_at_ws_no, modified_facility_id) VALUES	(?,	?, ?, ?, ?,	?, ?, ?, to_date(?,'dd/mm/yyyy'), ?, ?,	?, SYSDATE,? , ?, ?, SYSDATE, ?, ?)");
			hmSQLMap.put("DocNoUpdate", getStRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE"));

			// Queries for Online Stock updation
			hmSQLMap.put("ItemTrnDtlInsertSQL", getStRepositoryValue("SQL_ST_ITEM_TRN_DTL_INSERT"));
			hmSQLMap.put("ItemStoreStkPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_STORE_STOCK_POS"));
			hmSQLMap.put("ItemStoreQtyUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_UPDATE"));
			hmSQLMap.put("ItemMasterUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MASTER_UPDATE"));
			hmSQLMap.put("BatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_BATCH_EXISTS"));
			hmSQLMap.put("BatchControlInsertSQL", getStRepositoryValue("SQL_ST_BATCH_CONTROL_INSERT"));
			hmSQLMap.put("ItemBatchExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_ITEM_BATCH_EXISTS"));
			hmSQLMap.put("ItemBatchInsertSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_INSERT"));
			hmSQLMap.put("ItemBatchStcPosSelectSQL", getStRepositoryValue("SQL_ST_GET_ITEM_BATCH_STOCK_POS"));
			hmSQLMap.put("ItemBatchUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_UPDATE"));
			hmSQLMap.put("ItemBatchDeleteSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_DELETE"));

			hmSQLMap.put("GetMonthAndYear", getStRepositoryValue("SQL_ST_GET_MONTH_AND_YEAR"));
			hmSQLMap.put("SummaryExistsCheckSQL", getStRepositoryValue("SQL_ST_CHECK_SUMMARY_EXISTS"));
			hmSQLMap.put("ItemMovSumInsertSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_INSERT_FOR_ADJ"));
			hmSQLMap.put("ItemMovSumUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_MOVE_SUMM_UPDATE"));

			hmSQLMap.put("SQL_ST_ITEM_STORE_QTY_ON_HAND_UPDATE", getStRepositoryValue("SQL_ST_ITEM_STORE_QTY_ON_HAND_UPDATE"));
			hmSQLMap.put("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE", getStRepositoryValue("SQL_MM_ITEM_UNIT_COST_UPDATE_FOR_POST_VARIANCE"));
			
		//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
			hmSQLMap.put("BatchCondemnUpdateSQL", getStRepositoryValue("SQL_ST_ITEM_BATCH_CONDEMN"));
			hmSQLMap.put("ExpItmDelSQL", getStRepositoryValue("SQL_ST_EXP_ITEM_DELETE_CONDEMN"));
			hmSQLMap.put("ExpItmUpdateSQL", getStRepositoryValue("SQL_ST_EXP_ITEM_UPDATE_CONDEMN"));
			hmSQLMap.put("STEXPBATCHSQL",getStRepositoryValue("SQL_ST_EXP_BATCH_CONDEMN_SQL"));
			 
			
			return hmSQLMap;
	}
	public void loadData(String doc_type_code, String doc_no) throws Exception {
	
	    Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		 
		  HashMap hmExpRecord = new HashMap();
		  ArrayList alRecords = new ArrayList();
		  ArrayList alParameters =		new ArrayList();
		  boolean chk_remarks = true;
		
		try {
			
			// Loading the exp records..
			alParameters.clear();
			alParameters.add(getLanguageId());
			alParameters.add(getLoginFacilityId());
			alParameters.add(doc_type_code);
			alParameters.add(doc_no);
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			alParameters.add(getLanguageId());
			 
                 
			//alRecords		=	fetchRecords("SELECT EXITM.store_code,mm_store.SHORT_DESC STORE_DESC, EXITM.item_code, itm.short_desc item_desc,EXITM.TRADE_ID ,am.short_name trade_name, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY') EXPIRY_DATE, EXPIRY_DATE ex_date,EXITM.BATCH_ID,  EXITM.BIN_LOCATION_CODE, bin.short_desc bin_desc,EXITM.ITEM_QTY item_qty, NVL(BTVW.AVAIL_QTY,0)AVAIL_QTY, EXITM.REPLACE_ON_EXPIRY_YN, EXITM.TRN_REMARKS_CODE ,(SELECT REMARKS_DESC SHORT_DESC FROM MM_TRN_REMARKS_LANG_VW WHERE TRN_REMARKS_CODE = EXITM.TRN_REMARKS_CODE AND LANGUAGE_ID = ?) remarks_desc,EXITM.CONDEMN_HDR_REMARKS,EXITM.DOC_REF,btvw.EXPIRY_YN FROM st_expired_item EXITM, mm_item_lang_vw itm, mm_bin_location_lang_vw bin, am_trade_name_lang_vw am,MM_STORE_LANG_VW mm_store, st_batch_search_lang_view btvw WHERE EXITM.FACILITY_ID = ? and EXITM.FACILITY_ID = MM_STORE.FACILITY_ID and EXITM.doc_type_code = ? and EXITM.CONDEMN_ID = ? AND EXITM.item_code = itm.item_code and EXITM.STORE_CODE = MM_STORE.STORE_CODE   AND EXITM.bin_location_code = bin.bin_location_code AND EXITM.store_code = bin.store_code AND EXITM.trade_id = am.trade_id(+) AND exitm.store_code = btvw.store_code(+) AND exitm.item_code = btvw.item_code(+) and EXITM.BATCH_ID  = BTVW.BATCH_ID(+)  AND exitm.trade_id = BTVW.trade_id(+) and EXITM.BIN_LOCATION_CODE = BTVW.BIN_LOCATION_CODE(+) and EXITM.EXPIRY_DATE_OR_RECEIPT_DATE = BTVW.EXPIRY_DATE(+) AND btvw.language_id(+) = ? AND BTVW.LANG1(+) = ?  and BTVW.LANG2(+) = ? AND itm.language_id = bin.language_id AND itm.language_id = ? and mm_store.LANGUAGE_ID = ? AND am.language_id(+)= ? ORDER BY ex_date", alParameters);
			//Added by Rabbani #inc no:45074 on 20-NOV-2013
			alRecords		=	fetchRecords("SELECT EXITM.store_code,mm_store.SHORT_DESC STORE_DESC, EXITM.item_code, itm.short_desc item_desc,EXITM.TRADE_ID ,am.short_name trade_name, TO_CHAR (EXPIRY_DATE_OR_RECEIPT_DATE, 'DD/MM/YYYY') EXPIRY_DATE, EXPIRY_DATE ex_date,EXITM.BATCH_ID,  EXITM.BIN_LOCATION_CODE, bin.short_desc bin_desc,EXITM.ITEM_QTY item_qty, NVL(BTVW.AVAIL_QTY,0)AVAIL_QTY, EXITM.REPLACE_ON_EXPIRY_YN, EXITM.TRN_REMARKS_CODE ,(SELECT REMARKS_DESC SHORT_DESC FROM MM_TRN_REMARKS_LANG_VW WHERE TRN_REMARKS_CODE = EXITM.TRN_REMARKS_CODE AND LANGUAGE_ID = ?) remarks_desc,EXITM.CONDEMN_HDR_REMARKS,EXITM.DOC_REF,st.EXPIRY_YN FROM st_expired_item EXITM, mm_item_lang_vw itm, mm_bin_location_lang_vw bin, am_trade_name_lang_vw am,MM_STORE_LANG_VW mm_store, st_batch_search_lang_view btvw,st_item st WHERE EXITM.FACILITY_ID = ? and EXITM.FACILITY_ID = MM_STORE.FACILITY_ID and EXITM.doc_type_code = ? and EXITM.CONDEMN_ID = ? AND EXITM.item_code = itm.item_code and st.item_code = itm.item_code and EXITM.STORE_CODE = MM_STORE.STORE_CODE   AND EXITM.bin_location_code = bin.bin_location_code AND EXITM.store_code = bin.store_code AND EXITM.trade_id = am.trade_id(+) AND exitm.store_code = btvw.store_code(+) AND exitm.item_code = btvw.item_code(+) and EXITM.BATCH_ID  = BTVW.BATCH_ID(+)  AND exitm.trade_id = BTVW.trade_id(+) and EXITM.BIN_LOCATION_CODE = BTVW.BIN_LOCATION_CODE(+) and EXITM.EXPIRY_DATE_OR_RECEIPT_DATE = BTVW.EXPIRY_DATE(+) AND btvw.language_id(+) = ? AND BTVW.LANG1(+) = ?  and BTVW.LANG2(+) = ? AND itm.language_id = bin.language_id AND itm.language_id = ? and mm_store.LANGUAGE_ID = ? AND am.language_id(+)= ?  ORDER BY item_desc,store_desc,ex_date,batch_id,trade_name,bin_desc", alParameters);
			for(int j=0;j<alRecords.size();j++) {
				hmExpRecord = (HashMap)(alRecords.get(j));
				 if(chk_remarks){
					   setDoc_ref(checkForNull((String) hmExpRecord.get("DOC_REF")));
				       setAdj_remarks_Desc(checkForNull((String) hmExpRecord.get("CONDEMN_HDR_REMARKS")));
				       chk_remarks = false;
					}
				String item_code	= (String) hmExpRecord.get( "ITEM_CODE" );
				String store_code	   = (String) hmExpRecord.get( "STORE_CODE" );
				String batch_id		= (String) hmExpRecord.get( "BATCH_ID" );
				String bin_location_code =(String) hmExpRecord.get( "BIN_LOCATION_CODE" );
				String expiry_date	= (String) hmExpRecord.get( "EXPIRY_DATE");	

				HashMap hmExpiredBatch = new HashMap();
				hmExpiredBatch.put( "item_code",(String) hmExpRecord.get( "ITEM_CODE" ) ) ;
				hmExpiredBatch.put( "store_code",(String) hmExpRecord.get( "STORE_CODE" ) ) ;
				hmExpiredBatch.put( "batch_id",(String) hmExpRecord.get( "BATCH_ID" ) ) ;
				hmExpiredBatch.put( "bin_location_code",(String) hmExpRecord.get( "BIN_LOCATION_CODE" )) ;
				hmExpiredBatch.put( "expiry_date",(String) hmExpRecord.get( "EXPIRY_DATE")) ;
				hmExpiredBatch.put( "item_desc",(String) hmExpRecord.get( "ITEM_DESC" ) ) ;
				hmExpiredBatch.put( "store_desc",checkForNull((String) hmExpRecord.get( "STORE_DESC" ), "") ) ;
				hmExpiredBatch.put( "bin_desc",(String) hmExpRecord.get( "BIN_DESC" )) ;
				hmExpiredBatch.put( "trade_id",(String) hmExpRecord.get( "TRADE_ID" ) ) ;
				hmExpiredBatch.put( "trade_name",(String) hmExpRecord.get( "TRADE_NAME" ) ) ;
				hmExpiredBatch.put( "ITEM_QTY",(String) hmExpRecord.get( "ITEM_QTY" ) ) ; 
				hmExpiredBatch.put( "qty_on_hand",(String) hmExpRecord.get( "ITEM_QTY" ) ) ;
				hmExpiredBatch.put( "avail_qty",(String) hmExpRecord.get( "AVAIL_QTY" ) ) ; 
				hmExpiredBatch.put( "remarks",(String) hmExpRecord.get( "TRN_REMARKS_CODE" ) );
				hmExpiredBatch.put( "remarks_desc",(String) hmExpRecord.get( "REMARKS_DESC" ) ) ;
				hmExpiredBatch.put( "replace_on_expiry_yn",(String) hmExpRecord.get( "REPLACE_ON_EXPIRY_YN" )) ;
				hmExpiredBatch.put( "expiry_yn",(String) hmExpRecord.get( "EXPIRY_YN" )) ;
				
				
				boolean flag = false;
				for(int k=0;k<alExpiredBatches.size();k++) {
					HashMap hmListExpiredBatch	=  (HashMap)alExpiredBatches.get(k);
					String list_item_code = (String)(hmListExpiredBatch.get("item_code"));
					String list_store_code = (String)(hmListExpiredBatch.get("store_code"));
					String list_batch_id = (String)(hmListExpiredBatch.get("batch_id"));
					String list_bin_location_code = (String)(hmListExpiredBatch.get("bin_location_code"));
					String list_expiry_date = (String)(hmListExpiredBatch.get("expiry_date"));
					if(item_code.equals(list_item_code) && store_code.equals(list_store_code) && batch_id.equals(list_batch_id) && bin_location_code.equals(list_bin_location_code) && expiry_date.equals(list_expiry_date)) {
						flag = true;
					}
				}
				if(flag == false) {
					alExpiredBatches.add(hmExpiredBatch);
				}
			} 
		} 
		catch ( Exception e ){
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
	}
	//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 ends

// Added for online printing on 9/30/2004
	public void CalldoOnlineReportPrinting()
	{
		ArrayList alHeaderList = null;
		for(int i=0;i<alHeaderData.size();i++) 
		{
			alHeaderList = (ArrayList)alHeaderData.get(i);
			//String doc_nos	=	(String)alHeaderList.get(2);	//doc_no //commented by Rabbani on 24-Mar-2014 for chkstyles
			//doOnlineReportPrinting(doc_nos+"", (String)alHeaderList.get(1),(String)alHeaderList.get(5));				
		}
	}

// Online printing ends here 9/30/2004
	public ArrayList getItemDetails(String item_code, String store_code)throws Exception {
		ArrayList alItemDetails=new ArrayList();
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
			strParameters[5] = "N";
			strParameters[6] = "";

			HashMap hmStockAvailabilityStatus = getStockAvailabilityStatus(strParameters);

			alItemDetails.add((String)hmStockAvailabilityStatus.get("stock_available_yn")); //0
			alItemDetails.add((String)hmStockAvailabilityStatus.get("item_unit_cost")); //1
			alItemDetails.add(new Double ((String)hmStockAvailabilityStatus.get("store_item_unit_cost"))); //2
			alItemDetails.add(new Double ((String)hmStockAvailabilityStatus.get("available_stock"))); //3
			alItemDetails.add(new Double ((String)hmStockAvailabilityStatus.get("expired_stock"))); //4
			alItemDetails.add((String)hmStockAvailabilityStatus.get("stock_item_yn")); //5

		}
		catch(Exception exception) {
			exception.printStackTrace();
			throw exception;
		}
		finally {
			closeConnection(connection);
		}
		return alItemDetails;
	}

	/**
	* Method to get the stock_uom_code from mm_item table.
	* @param String, the item code, corresponding to that
	* @return String, the stock_uom code for the given item_code.
	*/

	public String getStockUOMCode (String item_code) {
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

//Added by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
public void doOnlineReportPrinting(String doc_no,String doc_type_code,Object request,Object response) {
		try{
			
			String reportid = "STBCEBDC";
			if (!isInternalRequest("ST",reportid)) return;
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
			
			//System.out.println("alHeaderList online report bean==inside>" );
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid) ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",doc_type_code);
				report2.addParameter("p_condemn_id",doc_no); // Added by Rabbani #Inc no:45256 on 28-11-2013
				//report2.addParameter("p_store_code",checkForNull(store_code));
				//report2.addParameter("p_finalized_yn","Y");
				//System.out.println("report2 online report bean==inside>"+report2 );
				
				onlineReports.add( report2) ;
				 
				if (!isDocTypePrintAllowed(doc_type_code)){ return;}
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
				//System.out.println("report2 online report bean==execute==>" );

		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}

//Commented   by Rabbani #Inc no:30304(Bru-HIMS-CRF-185) on 13-NOV-2013 Starts
 /*public void doOnlineReportPrinting(String doc_no, String doc_type_code,String store_code) {

		try{

			String reportid = "STBCEBDC";

			HashMap hmReportParameter	=	new HashMap();
			hmReportParameter.put("p_module_id","ST");
			hmReportParameter.put("p_report_id",reportid);
			hmReportParameter.put("p_user_name",getLoginById());
			hmReportParameter.put("p_facility_id",getLoginFacilityId());
			hmReportParameter.put("p_language_id",getLanguageId());
			hmReportParameter.put("p_doc_type_code",doc_type_code);
			hmReportParameter.put("p_doc_no",doc_no);
			

			if (!isDocTypePrintAllowed(doc_type_code)) return;
           

			HashMap hmParameters	=	new HashMap();
			hmParameters.put("report_parameter",hmReportParameter);*/
/*			hmParameters.put("jdbc",session.getAttribute("jdbc"));
			hmParameters.put("report_server",session.getAttribute("report_server"));
			hmParameters.put("report_connect_string",session.getAttribute("report_connect_string"));*/
			/*hmParameters.put("jdbc",getProperties());
			hmParameters.put("report_server",getReport_Server());
			hmParameters.put("report_connect_string",getReport_Connect_String());
			hmParameters.put("location_type","S");

			hmParameters.put("location_code",store_code);
			//hmParameters.put("p_language_id",getLanguageId());
			new eST.Common.ReportCallerThread(getURLString(hmParameters)).start();
		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}*/

/*public void setReFamily( javax.servlet.http.HttpServletRequest httpservletrequest,  javax.servlet.http.HttpServletResponse httpservletresponse) {
        request = httpservletrequest;
        response = httpservletresponse;
		session=request.getSession(false);
    }*/

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
	
	//added for GHL-CRF-0499 START , MODIFIED FOR ghl-icn-0032
public String getChallanNo(String item_code,String batch_id,String expiry_date, String storeCode){
	Connection connection			 =		null ;
	PreparedStatement pstmt	 =		null ;
	ResultSet resultSet				 =		null ;
	HashMap hmChallan			  = new HashMap();
	ArrayList alParameters	=	new ArrayList();
	String challan_no =	"";
	String challNo="";
	String batchid= "";
	int batch_id_length = 0;
	String consignment_yn = getConsignment_yn(item_code); 
	//setting challan_no to null when item is not a consignment item
	if(consignment_yn.equalsIgnoreCase("N")){
		challan_no="";
		return challan_no;
	}
	String vmi_batch_id=""; //added for GHL-ICN-0030
	try {		
		if(batch_id.contains("-")){
		
		//added for GHL-ICN-0030 START
		//	String[] arrOfStr = batch_id.split("-", 2);
		//	batchid = arrOfStr[0];
		//	challNo =arrOfStr[1];
		connection=getConnection();
				pstmt		= connection.prepareStatement("select VMI_BATCH_ID from st_item_batch where item_code=? and batch_id=? and EXPIRY_DATE_OR_RECEIPT_DATE=TO_DATE(?,'DD/MM/YYYY') and store_code= ? ");
				pstmt.setString(1,item_code);
				pstmt.setString(2,batch_id);
				pstmt.setString(3,expiry_date);
				pstmt.setString(4,storeCode);
				
				resultSet	= pstmt.executeQuery() ;
				
				
				
				if(resultSet.next())
					vmi_batch_id=resultSet.getString("VMI_BATCH_ID");
				if(vmi_batch_id!=null){
					batch_id_length =vmi_batch_id.length();	
				}
					
				
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
		alParameters.add(vmi_batch_id); //added for GHL-ICN-0030 
		alParameters.add(expiry_date);
		alParameters.add(challNo);
		hmChallan = fetchRecord("SELECT CHALLAN_NO FROM XI_TRN_GRN WHERE ITEM_CODE= ? AND BATCH_ID= ? AND TRUNC(EXPIRY_DATE) = TO_DATE (?,'DD/MM/YYYY') AND CHALLAN_NO LIKE ?  ",alParameters);
		//challan_no = (String)hmChallan.get("CHALLAN_NO");
		if(hmChallan!=null){
			challan_no = (String)hmChallan.get("CHALLAN_NO");
		}
		else{
			challan_no ="";
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
			
			
			//MOHE-CRF-0084.1 - US015
		    public String getRestrictUserAccessStore(){
		     	String []stParameters=	{getLoginFacilityId()};
		    		HashMap hmRecord	=	null;
		    		try{
		    			hmRecord	=	(HashMap)fetchRecord("SELECT RESTRICT_USER_ACCESS_STORE_YN FROM	st_facility_param WHERE facility_id=?", stParameters);
		    		}catch(Exception e){
		    			e.printStackTrace();
		    			return "";
		    		}
		    		return (String)hmRecord.get("RESTRICT_USER_ACCESS_STORE_YN"); 
		     	
		     } 
			
}

