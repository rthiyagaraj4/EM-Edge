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
??
23/06/2017		IN064596		Badmavathi B							ML-BRU-SCF-1715
---------------------------------------------------------------------------------------------------------
*/   
package eST;

import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.servlet.* ;
import javax.servlet.http.*; 

import eST.Common.StRepository;
import eCommon.Common.CommonRepository;
import eCommon.SingleTableHandler.SingleTableHandlerRemote;
import eCommon.SingleTableHandler.SingleTableHandlerHome;

public class CancelAuthorizationBean extends eST.Common.StTransaction implements Serializable {
	
	private String doc_type_code;
	private String doc_no;
	private String doc_ref;
	private String doc_date;
	private String request_by_store;
	private String request_on_store;
	private String item_class_code;
	//private String cancelled_remarks;
	private String defaultDocType;
	private String entity_param;
	private String user_id;
	//private String language;
	private java.util.ArrayList alItems;
	private java.util.ArrayList alCheckedItems;
	private java.util.HashMap hmRemarks;
	private  ArrayList alDtlCheckedItems;
	private  HashMap   hmItemRemarks;     
	//private ArrayList PDocNo ; 
	private String to_date;
	private String from_date;
	protected HashMap hdrRemarks		= new HashMap();
	protected HashMap dtlRemarks		= new HashMap();
	
	

	public CancelAuthorizationBean() {
		alCheckedItems = new java.util.ArrayList();
		hmRemarks = new java.util.HashMap();
		alDtlCheckedItems = new  ArrayList(); 
		hmItemRemarks     =  new HashMap();  
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}

	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("ISS",defaultDocType);
	}

	public String getDoc_no() {
		 return doc_no;
	}

	public void setDoc_ref(String doc_ref) {  
		 this.doc_ref = doc_ref;
	}

	public String getDoc_ref() {
		 return (doc_ref==null)?"":doc_ref; 
	}

	public void setItem_class_code(String item_class_code) {
		 this.item_class_code = item_class_code;
	}

	public String getItem_class_code() {
		 return this.item_class_code;
	}

	
	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public String getDoc_date() {
		 return this.doc_date;
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

	public java.util.ArrayList getAlItems() {
		return this.alItems;
	}

	public void setEntity_param(String entity_param) {
		this.entity_param = entity_param;
	}

	public String getEntity_param() {
		return this.entity_param;
	}
public void setUser_id(String user_id) {
		 this.user_id = user_id;
	}
    public String getUser_id()
	{
		return user_id;
	}
	
	public void setFrom_date(String from_date) {
		 this.from_date = from_date;
	}

	public String getFrom_date() {
		 return from_date;
	}
	
	public void setTo_date(String to_date) {
		 this.to_date = to_date;
	}

	public String getTo_date() {
		 return to_date;
	}

	public void setHdrRemarks(String key,String hdr_remarks) {
		this.hdrRemarks.put(key,hdr_remarks);
	}
    public void removeHdrRemarks(String key) {
		if(this.hdrRemarks.containsKey(key))
			this.hdrRemarks.remove(key);
	}

	public String getHdrRemarks(String key){
		if(this.hdrRemarks.containsKey(key))
			return (String)this.hdrRemarks.get(key);
		else
			return "";
	}

	public void setDtlRemarks(String key,String dtl_remarks) {
		this.dtlRemarks.put(key,dtl_remarks);
	}
    public void removeDtlRemarks(String key) {
		if(this.dtlRemarks.containsKey(key))
			this.dtlRemarks.remove(key);
	}

	public String getDtlRemarks(String key){
		if(this.dtlRemarks.containsKey(key))
			return (String)this.dtlRemarks.get(key);
		else
			return "";
	}

	public String getRequestByStore(String request_on_store) {
		String sql = "SELECT DISTINCT stp.parent_store_code, mm.short_desc FROM st_store_parent_store stp, mm_store_lang_vw mm, st_store st, st_acc_entity_param stpa  WHERE mm.store_code = stp.parent_store_code AND mm.eff_status = 'E'  AND  st.store_code = mm.store_code   AND st.iss_allowed_yn = 'Y' AND mm.facility_id LIKE DECODE( TRN_ACROSS_FACILITY_YN, 'Y','%',?) AND mm.language_id = ? AND stp.store_Code = ? ORDER BY	2";
		java.util.ArrayList sqlParam = new java.util.ArrayList (1);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		sqlParam.add(request_on_store);
		
		return getListValues(sql, sqlParam,"");
	}

	public String getRequestOnStore() {
		String sql = "SELECT   st.store_code, mm.short_desc FROM st_store st, mm_store_lang_vw mm, st_user_access_for_store su  WHERE st.store_code = mm.store_code    AND mm.eff_status = 'E' AND st.req_allowed_yn = 'Y' AND su.req_allowed_yn = 'Y' AND su.cancel_authorize_iss_allow_yn = 'Y' AND su.store_code = st.store_code AND mm.facility_id = ? AND mm.language_id = ? AND user_id = ? ORDER BY 2, 1";
		java.util.ArrayList sqlParam = new java.util.ArrayList (1);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		sqlParam.add(getLoginById());
		return getListValues(sql, sqlParam,"");
	}

	public String getItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(request_by_store);
		sqlParam.add(request_on_store);
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getItem_class_code());
	}

	public String getAllItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(getLanguageId());
		return getListValues(sql,sqlParam,"");
	}

	public ArrayList getCheckItems(){
	return alCheckedItems;
}
	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
			String chkParameters[] = {request_by_store,request_on_store,getLanguageId()};
			ArrayList result = new ArrayList();
			result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);
			return result;
	}
	
	
	
	public ArrayList getDtlCheckItems(){
	return alDtlCheckedItems;
    }
	
	

	public void updateSelectedValues(java.util.Hashtable selectedValues) {
		//System.err.println("selectedValues@@@@==="+selectedValues);
		int total = Integer.parseInt((String)selectedValues.get("total_check_boxes"));
		String checkedIndices = (String)selectedValues.get("checkedIndices");
		String checked_item_indices = (String)selectedValues.get("checked_item_indices"); //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
		String key = null;
		ArrayList aldtlRemoveKey = new ArrayList();
		ArrayList alAddItemKey  = new ArrayList ();  
		java.util.ArrayList alRemoveKey = new java.util.ArrayList (total);
		for (int i=0;i<total;i++) {
			alRemoveKey.add((String)selectedValues.get("doc_"+i));
			System.err.println("hdr key@@@===="+(String)selectedValues.get("doc_"+i));
			System.err.println("hdr Remarks@@@===="+(String)selectedValues.get("hed_remarks_textarea_"+i));
			setHdrRemarks((String)selectedValues.get("doc_"+i),(String)selectedValues.get("hed_remarks_textarea_"+i));
			int dtl_length    = Integer.parseInt((String)selectedValues.get("item_size_"+i));
			   aldtlRemoveKey = new ArrayList (dtl_length);
			for(int j = 0; j< dtl_length;j++){
			aldtlRemoveKey.add((String)selectedValues.get("item_cancel_"+i+"_"+j));
			System.err.println("dtl key@@@===="+(String)selectedValues.get("item_cancel_"+i+"_"+j));
			System.err.println("dtl Remarks@@@===="+(String)selectedValues.get("item_cancel_"+i+"_"+j));
			 setDtlRemarks((String)selectedValues.get("item_cancel_"+i+"_"+j),(String)selectedValues.get("dtl_remarks_textarea_"+i+"_"+j));
			}
			alDtlCheckedItems.removeAll(aldtlRemoveKey);
			aldtlRemoveKey = null;	 	
		   }
		    alCheckedItems.removeAll(alRemoveKey);
		    alRemoveKey = null;
		
		java.util.StringTokenizer checked = new  java.util.StringTokenizer(checkedIndices,",");
		  StringTokenizer checked_item    = new  StringTokenizer(checked_item_indices,",");//Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
		java.util.ArrayList alAddKey  = new java.util.ArrayList ();
		while (checked.hasMoreElements()) {
			key = (String)checked.nextElement();
			if (key != null && key.trim() != "") {
				alAddKey.add((String) selectedValues.get("doc_"+key.trim()));
			}
		}
		//Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
		 while (checked_item.hasMoreElements()) {
			key = (String)checked_item.nextElement();
			if (key != null && key.trim() != "") {
				alAddItemKey.add((String) selectedValues.get("item_cancel_"+key.trim()));
			}
		 }//ends
		alCheckedItems.addAll(alAddKey);
		alDtlCheckedItems.addAll(alAddItemKey); 
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
		  to_date = "";
		from_date = "";
		alItems = new ArrayList();
		alCheckedItems = new ArrayList();
		hmRemarks = new HashMap();
		alDtlCheckedItems = new ArrayList();
		hmItemRemarks = new HashMap();
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
		alItems = null;
		alCheckedItems = null;
		hmRemarks = null;
		alDtlCheckedItems = null;
		hmItemRemarks = null;
		to_date = null;
		from_date = null;
        hdrRemarks		= new HashMap();
        dtlRemarks		= new HashMap();
	}

	public HashMap validate()
	{

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");

		CancelRequestRemarksBean remarksBean = new CancelRequestRemarksBean() ;

		for (int i=0;i<alCheckedItems.size(); i++)
		{
			String key = (String) alCheckedItems.get(i);
			String remarks="";

			if (key == null || key.trim() == "") {
				continue;
			}
			if(hmRemarks.get(key) != null)
			{
				  remarksBean = (CancelRequestRemarksBean) hmRemarks.get(key);
				  remarks = remarksBean.getRemarks();
                  remarks = remarks.substring(remarks.lastIndexOf("=")+1) ;

			}else{
         			hmRemarks.put(key,"Cancelled as per request");

			}
//---ends---

			resultMap.put("result", new Boolean(true));
		}
		return resultMap;
	}

	public void setAll(Hashtable hashValues) {
		updateSelectedValues(hashValues);
	}

	
	public ArrayList loadData(String facility_id,String doc_type_code, String doc_no,String item_code,String item_desc) {
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		CancelAuthorizationDetailBean cancelAuthorizationDetailBean;
		alItems = new java.util.ArrayList ();
		try {
            connection = getConnection();
            pstmt = connection.prepareStatement("SELECT doc_no,doc_srl_no, dtl.item_code, itm.short_desc item_desc,req_item_qty,iss_item_qty, pending_item_qty,committed_item_qty FROM st_request_dtl dtl, mm_item_lang_vw itm WHERE facility_id = ?  AND doc_type_code    = ?     AND doc_no    = ?     AND dtl.item_code = itm.item_code AND DTL.item_code LIKE  ?  AND UPPER (itm.short_desc) LIKE UPPER (?) AND itm.language_id = ?  ORDER BY    doc_srl_no");

			String docTypeCode = doc_type_code.trim();
			
    
		 
            pstmt.setString(1, facility_id);
			pstmt.setString(2, docTypeCode);
            pstmt.setString(3, doc_no);
            pstmt.setString(4, item_code);
            pstmt.setString(5, item_desc);
            pstmt.setString(6, getLanguageId());
            resultSet = pstmt.executeQuery();

	        while (resultSet != null && resultSet.next()) {
				cancelAuthorizationDetailBean = new CancelAuthorizationDetailBean(resultSet);
				alItems.add(cancelAuthorizationDetailBean);
				
			}	   
        } 
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
            try {
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }
			catch(Exception es) {
				es.printStackTrace();
            }
        }
		return alItems;
	}


	public java.util.HashMap modify() {

		HashMap hmResult	=	new HashMap();
		ArrayList aldocdtl  = new ArrayList();
		Connection connection = null;
        PreparedStatement pstmt = null;
		PreparedStatement pstmt_update_store = null;
		PreparedStatement pstmt_update_batch = null;
		PreparedStatement pstmt_update_req_hdr = null;
		PreparedStatement pstmt_update_req_dtl = null;
		PreparedStatement pstmt_delete_iss_hdr = null;
		PreparedStatement pstmt_delete_iss_dtl = null;
		PreparedStatement pstmt_delete_iss_exp = null;
		//PreparedStatement pstmt_iss_count = null;
		PreparedStatement pstmt_select_seq = null;
		PreparedStatement pstmt_update_req_status =null;
        ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		boolean isUpdateSuccessful = false;
		int result =0;
		int result1 =0;
		int result2 =0;
		int result3 =0;
		int result4 =0;
		int result5 =0;
		int result6 =0;
		int result7 =0;
		
		

		try {
            connection = getConnection();

			

			String key = null;
			//Properties properties = getProperties();


			hmResult.put("result", new Boolean(false)) ;
			hmResult.put("message", "Initial Message") ;

		//	ArrayList alCheckedDocNumbers = new ArrayList();
			System.err.println("alCheckedItems outside===="+alCheckedItems);
			if(alCheckedItems.size() != 0 ){
			 for (int i=0;i<alCheckedItems.size(); i++) 
			{
				 System.err.println("alCheckedItems inside===="+alCheckedItems);
			    key = (String) alCheckedItems.get(i);
				if (key == null || key.trim() == "") 
				  continue;
				
				StringTokenizer st = new StringTokenizer(key,"~");
				String docTypeCode = st.nextToken().trim();
				String docNoValue = st.nextToken();
				String reqfacility_id = st.nextToken(); 
				HashMap hmdocdtl	=	new HashMap();
				hmdocdtl.put("doc_type_code",docTypeCode);
				hmdocdtl.put("doc_no",docNoValue);
                aldocdtl.add(hmdocdtl);
				
				int docNo = 0;
				if(docNoValue != null && !(docNoValue.equals(""))) 
				{
					docNo = Integer.parseInt(docNoValue);
				}
				String hdr_remarks_desc = ""; 
				String dtl_remarks_desc ="";
				 key = "";
				 key = docTypeCode+"-"+docNoValue;
				
					hdr_remarks_desc = getHdrRemarks(docTypeCode+"~"+docNoValue+"~"+reqfacility_id);

				
				ArrayList<String> alParam = new ArrayList<String>();
				int doc_count = 0;
				try{
					alParam.add(login_facility_id);
					alParam.add(docTypeCode);
					alParam.add(""+docNo);
					doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_REQUEST_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND REQUEST_STATUS NOT IN ('A','P','L')",alParam)).get("COUNT"));
				}catch(Exception e){
					hmResult.put("result",false);
					hmResult.put("msgid","OPER_CANCELLED");
					hmResult.put("message",getSTMessage(getLanguageId(),"OPER_CANCELLED","ST"));
					e.printStackTrace();
					return hmResult;
				}
				if(doc_count>0){
					throw new Exception("ST_DOC_NO_FINALIZED_USER");
				}
              
			  try{
           pstmt_update_req_hdr = connection.prepareStatement("UPDATE ST_REQUEST_HDR SET CANCEL_AUTHORIZED_BY_ID =	? ,	CANCEL_AUTH_HDR_REMARKS =	?, REQUEST_STATUS =	?, MODIFIED_BY_ID =	? ,	MODIFIED_DATE =	SYSDATE	, MODIFIED_AT_WS_NO	= ?	, MODIFIED_FACILITY_ID = ?	WHERE FACILITY_ID =	?  AND DOC_TYPE_CODE = ?  AND DOC_NO = ?");

		            pstmt_update_req_hdr.setString(1, login_by_id);  
					pstmt_update_req_hdr.setString(2, hdr_remarks_desc);  
					pstmt_update_req_hdr.setString(3, "W");  
					pstmt_update_req_hdr.setString(4, login_by_id);
					pstmt_update_req_hdr.setString(5, login_at_ws_no);  
					pstmt_update_req_hdr.setString(6, login_facility_id);  
					pstmt_update_req_hdr.setString(7, reqfacility_id); 
					pstmt_update_req_hdr.setString(8, docTypeCode);
					pstmt_update_req_hdr.setString(9, ""+docNo);
                
				  result = pstmt_update_req_hdr.executeUpdate(); 

				  if(result >0){
					  isUpdateSuccessful = true;             
				  }
					 
					closeStatement(pstmt_update_req_hdr);
   if(isUpdateSuccessful){

	        pstmt_update_req_dtl = connection.prepareStatement("UPDATE ST_REQUEST_DTL SET   CANCEL_AUTHORIZED_BY_ID =?,CANCEL_AUTH_DTL_REMARKS = ?, COMMITTED_ITEM_QTY = COMMITTED_ITEM_QTY-NVL(?,0), MODIFIED_BY_ID = ?,MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,CLOSE_ITEM_YN =? WHERE  ITEM_CODE=? AND DOC_NO = ? AND DOC_TYPE_CODE	= ?");
            
			pstmt_update_store = connection.prepareStatement("UPDATE ST_ITEM_STORE SET PENDING_REQ_QTY = DECODE (SIGN (PENDING_REQ_QTY - ?), -1, 0, (PENDING_REQ_QTY - ?) ), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE STORE_CODE = ? AND ITEM_CODE = ?");

			pstmt_update_batch = connection.prepareStatement("UPDATE ST_ITEM_BATCH SET COMMITTED_QTY = DECODE (SIGN (COMMITTED_QTY - ?), -1, 0, (COMMITTED_QTY - ?) ), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE STORE_CODE = ? AND ITEM_CODE = ? AND BATCH_ID =? AND EXPIRY_DATE_OR_RECEIPT_DATE = TO_DATE(?,'DD/MM/YYYY') AND BIN_LOCATION_CODE	= ?");
                
				/* Forming the data needed to revert back the pending_item_qty in st_item_store */
	            pstmt = connection.prepareStatement("SELECT HDR.REQ_BY_STORE_CODE,HDR.REQ_ON_STORE_CODE,DTL.PENDING_ITEM_QTY,DTL.COMMITTED_ITEM_QTY, DTL.ITEM_CODE,EX.BATCH_ID,TO_CHAR (EX.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY')EXPIRY_DATE_OR_RECEIPT_DATE,EX.BIN_LOCATION_CODE FROM ST_REQUEST_HDR HDR, ST_REQUEST_DTL DTL,ST_ISSUE_DTL_EXP EX WHERE HDR.DOC_NO = DTL.DOC_NO AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE =? AND HDR.FACILITY_ID=? AND DTL.DOC_TYPE_CODE =EX.DOC_TYPE_CODE AND DTL.DOC_NO =EX.DOC_NO AND DTL.DOC_SRL_NO =EX.DOC_SRL_NO AND DTL.ITEM_CODE = EX.ITEM_CODE AND DTL.PENDING_ITEM_QTY > 0");//Removed HDR.FACILITY_ID =EX.FACILITY_ID for MO-GN-5575
	            pstmt.setInt(1, docNo);
	            pstmt.setString(2, docTypeCode);
				//pstmt.setString(3, login_facility_id);
	            pstmt.setString(3,reqfacility_id);  //Changed for MO-GN-5575
	            resultSet = pstmt.executeQuery();

				while(resultSet != null && resultSet.next()) {
					String reqByStoreCode = resultSet.getString("REQ_BY_STORE_CODE");
					String pendingItemQty = resultSet.getString("PENDING_ITEM_QTY");
					String itemCode = resultSet.getString("ITEM_CODE");
					String batch_id = resultSet.getString("BATCH_ID");
					String exp_date = resultSet.getString("EXPIRY_DATE_OR_RECEIPT_DATE");
					String bin_locn = resultSet.getString("BIN_LOCATION_CODE");
					String committed_qty = resultSet.getString("COMMITTED_ITEM_QTY");
					String req_on_store = resultSet.getString("REQ_ON_STORE_CODE");
					//System.err.println("pendingItemQty@@@==="+pendingItemQty+"COMMITTED_ITEM_QTY==="+committed_qty+"REQ_ON_STORE_CODE=="+req_on_store+"REQ_BY_STORE_CODE=="+reqByStoreCode);

                     dtl_remarks_desc = getDtlRemarks(docTypeCode+"~"+docNoValue+"~"+itemCode);
					pstmt_update_req_dtl.setString(1, login_by_id);  
					pstmt_update_req_dtl.setString(2, dtl_remarks_desc);  
					if(committed_qty.equals("0"))
						pstmt_update_req_dtl.setString(3, pendingItemQty);
					else
					    pstmt_update_req_dtl.setString(3, committed_qty);
					pstmt_update_req_dtl.setString(4, login_by_id);
					pstmt_update_req_dtl.setString(5, login_at_ws_no);  
					pstmt_update_req_dtl.setString(6, login_facility_id);  
                    pstmt_update_req_dtl.setString(7, "N");  
					pstmt_update_req_dtl.setString(8, itemCode); 
					pstmt_update_req_dtl.setInt(9, docNo);
					pstmt_update_req_dtl.setString(10, docTypeCode);
                
				  result1 = pstmt_update_req_dtl.executeUpdate(); 

				  if(result1 >0){
					  isUpdateSuccessful = true;             
				  }
             if(isUpdateSuccessful){

					pstmt_update_store.setString(1, pendingItemQty);  //MO-CRF-20174
					pstmt_update_store.setString(2, pendingItemQty);  
					pstmt_update_store.setString(3, login_by_id);  
					pstmt_update_store.setString(4, login_at_ws_no);  
					pstmt_update_store.setString(5, login_facility_id);  
					pstmt_update_store.setString(6, reqByStoreCode); 
					pstmt_update_store.setString(7, itemCode);  
					
					result2 = pstmt_update_store.executeUpdate();
                  
				  if(result2 >0){
					  isUpdateSuccessful = true;             
				  }
             }
				  if(isUpdateSuccessful){

       //System.err.println("pendingItemQty@@@==="+pendingItemQty+"COMMITTED_ITEM_QTY==="+committed_qty);
					pstmt_update_batch.setString(1, committed_qty);  //MO-CRF-20174
					pstmt_update_batch.setString(2, committed_qty);  
					pstmt_update_batch.setString(3, login_by_id);  
					pstmt_update_batch.setString(4, login_at_ws_no);  
					pstmt_update_batch.setString(5, login_facility_id);  
					pstmt_update_batch.setString(6, req_on_store);
					pstmt_update_batch.setString(7, itemCode);
					pstmt_update_batch.setString(8, batch_id);  
					pstmt_update_batch.setString(9, exp_date);  
					pstmt_update_batch.setString(10, bin_locn);  
					
					result3 = pstmt_update_batch.executeUpdate();

					if(result3 >0){
					  isUpdateSuccessful = true;             
				    }

				  }
					
				}
				closeResultSet(resultSet);
			    closeStatement(pstmt);
           if(isUpdateSuccessful){
				pstmt_delete_iss_hdr = connection.prepareStatement("DELETE FROM ST_ISSUE_HDR WHERE DOC_TYPE_CODE =? AND DOC_NO =? AND FACILITY_ID = ?");
				pstmt_delete_iss_dtl = connection.prepareStatement("DELETE FROM ST_ISSUE_DTL WHERE DOC_TYPE_CODE =? AND DOC_NO =? AND FACILITY_ID = ?");
				pstmt_delete_iss_exp = connection.prepareStatement("DELETE FROM ST_ISSUE_DTL_EXP WHERE DOC_TYPE_CODE =? AND DOC_NO =? AND FACILITY_ID = ?");
                   
				 
					pstmt_delete_iss_exp.setString(1, docTypeCode);  //MO-CRF-20174
					pstmt_delete_iss_exp.setInt(2, docNo);  
					//pstmt_delete_iss_exp.setString(3, reqfacility_id);  
					pstmt_delete_iss_exp.setString(3,login_facility_id);  //Changed for MO-GN-5575

					result6 = pstmt_delete_iss_exp.executeUpdate();

					if(result6 >0){
					  isUpdateSuccessful = true;             
				    }
				
					closeStatement(pstmt_delete_iss_exp);
				if(isUpdateSuccessful){
					pstmt_delete_iss_dtl.setString(1, docTypeCode);  //MO-CRF-20174
					pstmt_delete_iss_dtl.setInt(2, docNo);  
					//pstmt_delete_iss_dtl.setString(3, reqfacility_id);  
					pstmt_delete_iss_dtl.setString(3, login_facility_id);//Changed for MO-GN-5575

					result5 = pstmt_delete_iss_dtl.executeUpdate();

					if(result5 >0){
					  isUpdateSuccessful = true;             
				    }
					closeStatement(pstmt_delete_iss_dtl);
				}

				  if(isUpdateSuccessful){
				    pstmt_delete_iss_hdr.setString(1, docTypeCode);  //MO-CRF-20174
					pstmt_delete_iss_hdr.setInt(2, docNo);  
					//pstmt_delete_iss_hdr.setString(3, reqfacility_id);  
					pstmt_delete_iss_hdr.setString(3, login_facility_id);  //Changed for MO-GN-5575

					result4 = pstmt_delete_iss_hdr.executeUpdate();

					if(result4 >0){
					  isUpdateSuccessful = true;             
				    }
					closeStatement(pstmt_delete_iss_hdr);
		         }
		   }
					
				

				
				
              }
			  
			    closeResultSet(resultSet);
                closeStatement(pstmt);
				closeStatement(pstmt_update_req_dtl);
				closeStatement(pstmt_update_store);
				closeStatement(pstmt_update_batch);
				
			if(!isUpdateSuccessful){
				connection.rollback();
				throw new Exception("Update failed while updating cancel Authorization");
		     }else{
			   connection.commit();
			   hmResult.put("result", new Boolean(true));
			   hmResult.put("message", getMessage(getLanguageId(),"RECORD_INSERTED","ST"));
		          }
			 }catch(Exception e){
					hmResult.put("result",false);
					hmResult.put("msgid","OPER_CANCELLED");
					hmResult.put("message",getSTMessage(getLanguageId(),"OPER_CANCELLED","ST"));
					e.printStackTrace();
					return hmResult;
				}
		   }
	 }
	     //System.err.println("alDtlCheckedItems outside===="+alDtlCheckedItems);	   
		 int z =1;
		  for (int i=0;i<alDtlCheckedItems.size(); i++) 
			{
			    key = "";
				key = (String) alDtlCheckedItems.get(i);
				if (key == null || key.trim() == "") 
				  continue;
				
				StringTokenizer st = new StringTokenizer(key,"~");
				String doc_type_code_value = st.nextToken().trim();
				String doc_no_value = st.nextToken();
				String item_code =  st.nextToken();
				String seq_no ="";
				ArrayList alCount   =new ArrayList();
				ArrayList hdrCount  =new ArrayList();
		//		System.err.println("item_code==="+item_code);
				String hdr_remarks_desc =getHdrRemarks(doc_type_code_value+"~"+doc_no_value+"~"+login_facility_id);
				String dtl_remarks_desc =getDtlRemarks(key);
				if(!((doc_type_code_value.equals((String)getDoc_type_code())) && (doc_no_value.equals((String)getDoc_no())))){
				setDoc_type_code(doc_type_code_value);  
				setDoc_no(doc_no_value);  
				HashMap hmdocdtl	=	new HashMap();
				hmdocdtl.put("doc_type_code",doc_type_code_value);
				hmdocdtl.put("doc_no",doc_no_value);
                aldocdtl.add(hmdocdtl);
				}
				//ends
				
				int doc_No = 0;
				ArrayList<String> alParamtr = new ArrayList<String>();
				int doc_count_ = 0;
				
				if(doc_no_value != null && !(doc_no_value.equals(""))) 
				{
					doc_No = Integer.parseInt(doc_no_value);
				}
				 
				try{
					alParamtr.add(login_facility_id);
					alParamtr.add(doc_type_code_value);
					alParamtr.add(""+doc_No);
					doc_count_ = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_REQUEST_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND REQUEST_STATUS NOT IN ('A','P','L')",alParamtr)).get("COUNT"));
					
				}catch(Exception e){
					hmResult.put("result",false);
					hmResult.put("msgid","OPER_CANCELLED");
					hmResult.put("message",getSTMessage(getLanguageId(),"OPER_CANCELLED","ST"));
					e.printStackTrace();
					return hmResult;
				}
				if(doc_count_>0){
					throw new Exception("ST_DOC_NO_FINALIZED_USER");
				}
	try{
           pstmt_update_req_hdr = connection.prepareStatement("UPDATE ST_REQUEST_HDR SET CANCEL_AUTHORIZED_BY_ID =	? ,	CANCEL_AUTH_HDR_REMARKS =	?, REQUEST_STATUS =	?, MODIFIED_BY_ID =	? ,	MODIFIED_DATE =	SYSDATE	, MODIFIED_AT_WS_NO	= ?	, MODIFIED_FACILITY_ID = ?	WHERE FACILITY_ID =	?  AND DOC_TYPE_CODE = ?  AND DOC_NO = ?");

		            pstmt_update_req_hdr.setString(1, login_by_id);  
					pstmt_update_req_hdr.setString(2, hdr_remarks_desc);  
					pstmt_update_req_hdr.setString(3, "A");  
					pstmt_update_req_hdr.setString(4, login_by_id);
					pstmt_update_req_hdr.setString(5, login_at_ws_no);  
					pstmt_update_req_hdr.setString(6, login_facility_id);  
					pstmt_update_req_hdr.setString(7, login_facility_id); 
					pstmt_update_req_hdr.setString(8, doc_type_code_value);
					pstmt_update_req_hdr.setInt(9, doc_No);
                
				  result = pstmt_update_req_hdr.executeUpdate(); 

				  if(result >0){
					  isUpdateSuccessful = true;             
				  }
                 closeStatement(pstmt_update_req_hdr);

   if(isUpdateSuccessful){

	        pstmt_update_req_dtl = connection.prepareStatement("UPDATE ST_REQUEST_DTL SET   CANCEL_AUTHORIZED_BY_ID =?,CANCEL_AUTH_DTL_REMARKS = ?, COMMITTED_ITEM_QTY = COMMITTED_ITEM_QTY-NVL(?,0), MODIFIED_BY_ID = ?,MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ?,CLOSE_ITEM_YN =? WHERE  ITEM_CODE=? AND DOC_NO = ? AND DOC_TYPE_CODE	= ?");

			pstmt_update_store = connection.prepareStatement("UPDATE ST_ITEM_STORE SET PENDING_REQ_QTY = DECODE (SIGN (PENDING_REQ_QTY - ?), -1, 0, (PENDING_REQ_QTY - ?) ), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE STORE_CODE = ? AND ITEM_CODE = ?");

			pstmt_update_batch = connection.prepareStatement("UPDATE ST_ITEM_BATCH SET COMMITTED_QTY = DECODE (SIGN (COMMITTED_QTY - ?), -1, 0, (COMMITTED_QTY - ?) ), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE STORE_CODE = ? AND ITEM_CODE = ? AND BATCH_ID =? AND EXPIRY_DATE_OR_RECEIPT_DATE = TO_DATE(?,'DD/MM/YYYY') AND BIN_LOCATION_CODE	= ?");
                
				/* Forming the data needed to revert back the pending_item_qty in st_item_store */
	            pstmt = connection.prepareStatement("SELECT HDR.REQ_BY_STORE_CODE,HDR.REQ_ON_STORE_CODE, DTL.PENDING_ITEM_QTY,DTL.COMMITTED_ITEM_QTY, DTL.ITEM_CODE,EX.BATCH_ID,TO_CHAR (EX.EXPIRY_DATE_OR_RECEIPT_DATE,'DD/MM/YYYY')EXPIRY_DATE_OR_RECEIPT_DATE,EX.BIN_LOCATION_CODE FROM ST_REQUEST_HDR HDR, ST_REQUEST_DTL DTL,ST_ISSUE_DTL_EXP EX WHERE HDR.DOC_NO = DTL.DOC_NO  AND DTL.ITEM_CODE =? AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE =? AND HDR.FACILITY_ID=? AND HDR.FACILITY_ID =EX.FACILITY_ID AND DTL.DOC_TYPE_CODE =EX.DOC_TYPE_CODE AND DTL.DOC_NO =EX.DOC_NO AND DTL.DOC_SRL_NO =EX.DOC_SRL_NO AND DTL.ITEM_CODE = EX.ITEM_CODE AND DTL.PENDING_ITEM_QTY > 0");
	            pstmt.setString(1, item_code);
	            pstmt.setInt(2, doc_No);
				pstmt.setString(3, doc_type_code_value);
				pstmt.setString(4, login_facility_id);
	            resultSet = pstmt.executeQuery();

				while(resultSet != null && resultSet.next()) {
					String reqByStoreCode = resultSet.getString("REQ_BY_STORE_CODE");
					String pendingItemQty = resultSet.getString("PENDING_ITEM_QTY");
					String itemCode = resultSet.getString("ITEM_CODE");
					String batch_id = resultSet.getString("BATCH_ID");
					String exp_date = resultSet.getString("EXPIRY_DATE_OR_RECEIPT_DATE");
					String bin_locn = resultSet.getString("BIN_LOCATION_CODE");
					String committed_qty = resultSet.getString("COMMITTED_ITEM_QTY");
					String req_on_store = resultSet.getString("REQ_ON_STORE_CODE");
				
					// System.err.println("pendingItemQty@@@else condition11==="+pendingItemQty+"COMMITTED_ITEM_QTY==="+committed_qty);

					pstmt_update_req_dtl.setString(1, login_by_id);  
					pstmt_update_req_dtl.setString(2, dtl_remarks_desc);  
					if(committed_qty.equals("0"))
						pstmt_update_req_dtl.setString(3, pendingItemQty);
					else
					    pstmt_update_req_dtl.setString(3, committed_qty);
					pstmt_update_req_dtl.setString(4, login_by_id);
					pstmt_update_req_dtl.setString(5, login_at_ws_no);  
					pstmt_update_req_dtl.setString(6, login_facility_id);
					pstmt_update_req_dtl.setString(7, "N");
					pstmt_update_req_dtl.setString(8, itemCode); 
					pstmt_update_req_dtl.setInt(9, doc_No);
					pstmt_update_req_dtl.setString(10, doc_type_code_value);
                
				  result1 = pstmt_update_req_dtl.executeUpdate(); 

				  if(result1 >0){
					  isUpdateSuccessful = true;             
				  }
             if(isUpdateSuccessful){

					pstmt_update_store.setString(1, pendingItemQty);  //MO-CRF-20174
					pstmt_update_store.setString(2, pendingItemQty);  
					pstmt_update_store.setString(3, login_by_id);  
					pstmt_update_store.setString(4, login_at_ws_no);  
					pstmt_update_store.setString(5, login_facility_id);  
					pstmt_update_store.setString(6, reqByStoreCode); 
					pstmt_update_store.setString(7, itemCode);  
					
					result2 = pstmt_update_store.executeUpdate();
                  
				  if(result2 >0){
					  isUpdateSuccessful = true;             
				  }
             }
				  if(isUpdateSuccessful){
					// System.err.println("pendingItemQty@@@else condition11==="+pendingItemQty+"COMMITTED_ITEM_QTY==="+committed_qty);
					pstmt_update_batch.setString(1, committed_qty);  //MO-CRF-20174
					pstmt_update_batch.setString(2, committed_qty);  
					pstmt_update_batch.setString(3, login_by_id);  
					pstmt_update_batch.setString(4, login_at_ws_no);  
					pstmt_update_batch.setString(5, login_facility_id);  
					pstmt_update_batch.setString(6, req_on_store); 
					pstmt_update_batch.setString(7, itemCode);
					pstmt_update_batch.setString(8, batch_id);  
					pstmt_update_batch.setString(9, exp_date);  
					pstmt_update_batch.setString(10, bin_locn); 
					
					result3 = pstmt_update_batch.executeUpdate();

					if(result3 >0){
					  isUpdateSuccessful = true;             
				    }

				  }
					
				}
				 closeResultSet(resultSet);
				 closeStatement(pstmt);
           if(isUpdateSuccessful){
				pstmt_delete_iss_hdr = connection.prepareStatement("DELETE FROM ST_ISSUE_HDR WHERE DOC_TYPE_CODE =? AND DOC_NO =? AND FACILITY_ID = ? AND SEQ_NO =?");
				pstmt_delete_iss_dtl = connection.prepareStatement("DELETE FROM ST_ISSUE_DTL WHERE DOC_TYPE_CODE =? AND DOC_NO =? AND ITEM_CODE =? AND FACILITY_ID = ? AND SEQ_NO =?");
				pstmt_delete_iss_exp = connection.prepareStatement("DELETE FROM ST_ISSUE_DTL_EXP WHERE DOC_TYPE_CODE =? AND DOC_NO =? AND ITEM_CODE =? AND FACILITY_ID = ? AND SEQ_NO =?");

				pstmt_select_seq =connection.prepareStatement("SELECT SEQ_NO FROM ST_ISSUE_DTL WHERE DOC_TYPE_CODE =? AND DOC_NO =? AND ITEM_CODE =? AND FACILITY_ID = ?");	
	           
				 pstmt_select_seq.setString(1, doc_type_code_value);
				 pstmt_select_seq.setInt(2, doc_No);
				 pstmt_select_seq.setString(3, item_code);
				 pstmt_select_seq.setString(4, login_facility_id);
	             resultSet1 = pstmt_select_seq.executeQuery();
                 while(resultSet1 != null && resultSet1.next()) {
					 seq_no =resultSet1.getString("SEQ_NO");
				 }
				  closeResultSet(resultSet);
				  closeStatement(pstmt_select_seq);
				//System.err.println("doc_type_code_value@@=="+doc_type_code_value+"doc_No==="+doc_No+"item_code=="+item_code+"login_facility_id=="+login_facility_id+"seq_no=="+seq_no);
					pstmt_delete_iss_exp.setString(1, doc_type_code_value);  //MO-CRF-20174
					pstmt_delete_iss_exp.setInt(2, doc_No);  
					pstmt_delete_iss_exp.setString(3, item_code);  
					pstmt_delete_iss_exp.setString(4, login_facility_id);
					pstmt_delete_iss_exp.setString(5, seq_no);  

					result6 = pstmt_delete_iss_exp.executeUpdate();

					if(result6 >0){
					  isUpdateSuccessful = true;             
				    }
				

				if(isUpdateSuccessful){
					pstmt_delete_iss_dtl.setString(1, doc_type_code_value);  //MO-CRF-20174
					pstmt_delete_iss_dtl.setInt(2, doc_No);
					pstmt_delete_iss_dtl.setString(3, item_code);  
					pstmt_delete_iss_dtl.setString(4, login_facility_id); 
					pstmt_delete_iss_dtl.setString(5, seq_no);  

					result5 = pstmt_delete_iss_dtl.executeUpdate();

					if(result5 >0){
					  isUpdateSuccessful = true;             
				    }
				}
                if(isUpdateSuccessful){
					//System.err.println("i===="+i+"alDtlCheckedItems=="+alDtlCheckedItems.size()+"z======"+z+"seq_no==="+seq_no);
					//if(z==alDtlCheckedItems.size()){
					alCount.add(login_facility_id);
					alCount.add(doc_type_code_value);
					alCount.add(""+doc_No);
					alCount.add(seq_no);
					int delete_hdr = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_ISSUE_DTL WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND SEQ_NO =?",alCount)).get("COUNT"));
					
					//System.err.println("delete hdr Value@@@==="+delete_hdr+"alDtlCheckedItems.size()=="+alDtlCheckedItems.size());
					if(delete_hdr==1){
				    pstmt_delete_iss_hdr.setString(1, doc_type_code_value);
					pstmt_delete_iss_hdr.setInt(2, doc_No);  
					pstmt_delete_iss_hdr.setString(3, login_facility_id);  
					pstmt_delete_iss_hdr.setString(4, seq_no);  

					result4 = pstmt_delete_iss_hdr.executeUpdate();

					if(result4 >0){
					  isUpdateSuccessful = true;             
				    }

					hdrCount.add(login_facility_id);
					hdrCount.add(doc_type_code_value);
					hdrCount.add(""+doc_No);
					
					int request_hdr_update = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_ISSUE_DTL WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ?",hdrCount)).get("COUNT"));

					//System.err.println("request_hdr_update@@==="+request_hdr_update);
               if(request_hdr_update==1){
				pstmt_update_req_status = connection.prepareStatement("UPDATE ST_REQUEST_HDR SET  REQUEST_STATUS =	?, MODIFIED_BY_ID =	? ,	MODIFIED_DATE =	SYSDATE	, MODIFIED_AT_WS_NO	= ?	, MODIFIED_FACILITY_ID = ?	WHERE FACILITY_ID =	?  AND DOC_TYPE_CODE = ?  AND DOC_NO = ?");

					pstmt_update_req_status.setString(1, "W");  
					pstmt_update_req_status.setString(2, login_by_id);
					pstmt_update_req_status.setString(3, login_at_ws_no);  
					pstmt_update_req_status.setString(4, login_facility_id);  
					pstmt_update_req_status.setString(5, login_facility_id); 
					pstmt_update_req_status.setString(6, doc_type_code_value);
					pstmt_update_req_status.setInt(7, doc_No);
                
				  result7 = pstmt_update_req_status.executeUpdate(); 

				  if(result7 >0){
					  isUpdateSuccessful = true;             
				    }
					closeStatement(pstmt_update_req_status);
			   }

				   }
				 // }
		         }
		         }
				closeStatement(pstmt_delete_iss_hdr);	
				closeStatement(pstmt_delete_iss_dtl);
				closeStatement(pstmt_delete_iss_exp);
              }
			  
			    closeResultSet(resultSet);
				closeResultSet(resultSet1);
                closeStatement(pstmt);
				closeStatement(pstmt_select_seq);
				closeStatement(pstmt_update_batch);
                closeStatement(pstmt_update_store);
				

				
			if(!isUpdateSuccessful){
				connection.rollback();
				throw new Exception("Update failed while updating cancel Authorization");
		     }else{
			   connection.commit();
			   hmResult.put("result", new Boolean(true));
			  hmResult.put("message", getMessage(getLanguageId(),"RECORD_INSERTED","ST"));
		          }
			 }catch(Exception e){
					hmResult.put("result",false);
					hmResult.put("msgid","OPER_CANCELLED");
					hmResult.put("message",getSTMessage(getLanguageId(),"OPER_CANCELLED","ST"));
					e.printStackTrace();
					return hmResult;
				}
				z++;
			}
			


			/*hmTableData.put("HeaderUpdateData",alModifyData);
			hmSQLMap.put("UpdateHDRSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_UPDATE"));

			hmTableData.put("RevertBackData",alRevertBackData);
			hmSQLMap.put("RevertBackSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_REVERT_REQUEST_ON_CANCEL"));

			hmTableData.put("DetailUpdateData",datadtl);
			hmSQLMap.put("UpdateDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_BY_ITEM"));
			
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getStRepositoryValue("JNDI_ST_CANCEL_REQUEST"),eST.CancelRequest.CancelRequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);



			hmResult.put("message",getSTMessage(getLanguageId(),(String) hmResult.get( "message" ),"ST") ) ;*/
		
		}
		catch(Exception ex) {
			ex.printStackTrace();
			
			if(ex.getMessage().equals("ST_DOC_NO_FINALIZED_USER")){
				hmResult.put("result",false);
				hmResult.put("msgid","ST_DOC_NO_FINALIZED_USER");
				hmResult.put("message","ST_DOC_NO_FINALIZED_USER");
			}
			
		}	  

		finally {
            try {
                closeResultSet(resultSet);
                closeStatement(pstmt);
				closeStatement(pstmt_update_store);
				closeStatement(pstmt_update_batch);
				closeStatement(pstmt_update_req_hdr);
				closeStatement(pstmt_update_req_dtl);
				closeStatement(pstmt_delete_iss_hdr);
				closeStatement(pstmt_delete_iss_dtl);
				closeStatement(pstmt_delete_iss_exp);
				closeStatement(pstmt_update_req_status);
                closeConnection(connection);
				
            }
			catch(Exception es) { 
				es.printStackTrace();
            }
        }
		
		     
	    	return hmResult;
	  }
		
	

	public java.util.ArrayList getbyStores(String req_on_store) throws Exception {
			String chkParameters[] = {login_facility_id,getLanguageId(),checkForNull(req_on_store)};
			ArrayList result = new ArrayList();
				
			result = fetchRecords("SELECT DISTINCT stp.store_code, mm.short_desc FROM st_store_parent_store stp, mm_store_lang_vw mm, st_store st, st_acc_entity_param stpa  WHERE mm.store_code = stp.store_code AND mm.eff_status = 'E'  AND  st.store_code = mm.store_code   AND st.iss_allowed_yn = 'Y' AND mm.facility_id LIKE DECODE( TRN_ACROSS_FACILITY_YN, 'Y','%',?) AND mm.language_id = ? AND stp.parent_store_Code = ? ORDER BY	2",chkParameters);
			return result;
	
	}
	public java.util.ArrayList getRequestOnStore(String request_type) throws Exception {
			String chkParameters[] = {login_facility_id,getLanguageId(),login_by_id,request_type,request_type};
			ArrayList result = new ArrayList();
			//result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);
			result = fetchRecords("SELECT   st.store_code, mm.short_desc FROM st_store st, mm_store_lang_vw mm, st_user_access_for_store su  WHERE st.store_code = mm.store_code    AND mm.eff_status = 'E' AND st.req_allowed_yn = 'Y' AND su.req_allowed_yn = 'Y' AND su.cancel_authorize_iss_allow_yn = 'Y' AND su.store_code = st.store_code AND mm.facility_id = ? AND mm.language_id = ? AND user_id = ? and mm.EXTERNAL_YN like decode(?,'A','%',?) ORDER BY 2, 1",chkParameters);	
			
			return result;
	}	
	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST1"),alParameters),defaultValue);
	}
	
	public String getMasterRemarks() {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;
			ArrayList alOptionValues = new ArrayList();
			String optionValues = null;
			String sql="";
			String select_option_legend="<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
			alOptionValues.add(select_option_legend);
			try {
				connection=getConnection();
				sql ="SELECT a.TRN_REMARKS_CODE,REMARKS_DESC FROM MM_TRN_REMARKS_LANG_VW A, ST_TRN_TYPE_FOR_REMARKS B WHERE A.TRN_REMARKS_CODE =B.TRN_REMARKS_CODE AND A.EFF_STATUS='E' AND B.REJECT_STATUS ='E' AND A.LANGUAGE_ID= ? AND B.TRN_TYPE='ISS'";
				preparedStatement=connection.prepareStatement(sql);
				
	            preparedStatement.setString(1, getLanguageId());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					alOptionValues.add(new String[]{resultSet.getString(1),resultSet.getString(1)});
					
				}
				alOptionValues.add(new String[]{"O","Others"});
				optionValues = getListOptionTag(alOptionValues);
			}
			catch (java.sql.SQLException exception) {
				alOptionValues.add(new String[]{"",exception.getMessage()});
				
			}
			catch (Exception exception) {
				alOptionValues.add(new String[]{"",exception.getMessage()});
			}
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					alOptionValues.add(new String[]{"",exception.getMessage()});
				}
			}
	//		System.err.println("alOptionValues@@@while return======="+optionValues);
			return optionValues;
	}

	
	public String getListOptionTag(ArrayList arrayListValue ) {
		if (arrayListValue == null) {
			return null;
		}
		StringBuffer tagValue = new StringBuffer();
		for (int count=0;count<arrayListValue.size();count++ ) {
			Object obj	=	arrayListValue.get(count);
			if (obj instanceof String[]) {
				tagValue.append("<option value=\"");
				tagValue.append(((String[])obj)[0]);
				tagValue.append("\">");
				tagValue.append(((String[])obj)[1]);
				tagValue.append("</option>\n");
			}
			else{
				tagValue.append(arrayListValue.get(count).toString());
				tagValue.append('\n');
			}
		}
		return tagValue.toString();
	}

	public String getRemarksDesc(String remarks_code) {
			Connection connection				= null;
			PreparedStatement preparedStatement = null;
			ResultSet resultSet					=	null;
			String remarks_desc = "";
			String sql="";
			
			try {
				connection=getConnection();
				sql ="SELECT REMARKS_DESC FROM MM_TRN_REMARKS_LANG_VW A WHERE  A.EFF_STATUS='E'  AND a.TRN_REMARKS_CODE =? AND A.LANGUAGE_ID= ? ";
				preparedStatement=connection.prepareStatement(sql);
				
				preparedStatement.setString(1, remarks_code);
	            preparedStatement.setString(2, getLanguageId());
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					remarks_desc = resultSet.getString("REMARKS_DESC");
					
				}
				
			}
			catch (Exception e) {
					e.printStackTrace() ;
			}
			
			finally{
				try { 
					closeResultSet(resultSet);
					closeStatement(preparedStatement);
					closeConnection(connection);
				}
				catch (Exception exception) {
					exception.printStackTrace() ;
				}
			}
			return remarks_desc;
	}

	private  HashMap CallSingleTableHandler(HashMap tabData , HashMap sqlMap )
	 {
	    HashMap map = new HashMap() ;
	    map.put( "result", new Boolean( false ) ) ;

//	    SingleTableHandlerHome home = null;
	    SingleTableHandlerRemote remote = null;
	    try {
	     /*   InitialContext context = new InitialContext() ;
					Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;
	        home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
	        remote = home.create() ;*/

				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ,SingleTableHandlerHome.class,getLocalEJB());
				Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

				Object argArray[] = new Object[2];
				argArray[0] = tabData;
				argArray[1] = sqlMap;

				Class [] paramArray = new Class[2];
				paramArray[0] = tabData.getClass(); 
				paramArray[1] = sqlMap.getClass();

	        if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT"))  ){
				map = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
	           // map = remote.singleBatchHandler( tabData, sqlMap ) ;
	        }else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY")) ){
				map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
	           // map = remote.modify( tabData, sqlMap ) ;
	        }else if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_DELETE") ) ){
				map = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
	           //  map = remote.delete( tabData, sqlMap ) ;
	        }
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

	        if( ((Boolean) map.get( "result" )).booleanValue() )
	                map.put( "message", getMessage((String) map.get( "msgid" )) ) ;
	        else{
	            if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
	            {
	                String msgID = getMessage((String) map.get( "msgid" ),false) ;
	                msgID = msgID.substring(0,(msgID.indexOf("<br>"))) ;
	                map.put( "message", msgID  ) ;
	                map.put( "invalidCode", delimitedString( (ArrayList)map.get("invalidCode")) ) ;
	                    //(map.get("invalidCode"))  ) ;
	            }
	            else
	                map.put( "message", (map.get("msgid"))) ;
	            }
	        }
	        catch(Exception e) {
	        System.err.println( "Error Calling EJB classcast : "+e ) ;
	        map.put( "message", e.getMessage()+"classcast") ;
	        e.printStackTrace() ;
	        }
			finally {
					try {
						if( remote != null )
							remote.remove() ;
						} catch( Exception ee ) {
							System.err.println( ee.getMessage() ) ;
								map.put( "message", ee.getMessage() );
									ee.printStackTrace();
						}
					} 
	return map;
	}


	
}