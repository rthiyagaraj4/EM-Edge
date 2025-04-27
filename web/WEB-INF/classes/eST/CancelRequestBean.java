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

//import eCommon.Common.CommonEJBSessionInterface;
//import eST.Common.StTransaction;
//import eST.Common.StHeaderBean;
//import javax.ejb.EJBObject;
//import javax.servlet.http.HttpSession;
//import javax.rmi.PortableRemoteObject;
//import javax.naming.InitialContext;
//import eCommon.Common.CommonRepository;
import eST.Common.StRepository;
//import eST.Common.StAdapter;
//import eST.CancelRequestDetailBean;
 
//import eST.CancelRequestRemarksBean;
//import eCommon.SingleTableHandler.SingleTableHandlerRemote;
//import eCommon.SingleTableHandler.SingleTableHandlerHome;

public class CancelRequestBean extends eST.Common.StTransaction implements Serializable {
	
	private String doc_type_code;
	private String doc_no;
	private String doc_ref;
	private String doc_date;
	private String request_by_store;
	private String request_on_store;
	private String item_class_code;
	private String cancelled_remarks;
	private String defaultDocType;
	private String entity_param;
	private String user_id;
	//private String language;
	private java.util.ArrayList alItems;
	private java.util.ArrayList alCheckedItems;
	private java.util.HashMap hmRemarks;
	//Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
	private  ArrayList alDtlCheckedItems;
	private  HashMap   hmItemRemarks;     
	private ArrayList PDocNo ; 
	private String to_date;
	private String from_date;
	
	//private String PgetDoc_type_code = "";
	//private String PgetStore_codest = "";
	//ends

	public CancelRequestBean() {
		alCheckedItems = new java.util.ArrayList();
		hmRemarks = new java.util.HashMap();
		alDtlCheckedItems = new  ArrayList(); //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
		hmItemRemarks     =  new HashMap();  //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}

/*	public void setLanguageId(String language)
	{
		this.language=language;
	}

	public String getLanguageId()
	{
		return language;
	}*/

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
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

	public void setCancelled_remarks(String cancelled_remarks) {
		 this.cancelled_remarks = cancelled_remarks;
	}

	public String getCancelled_remarks() {
		 return this.cancelled_remarks;
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
	/* Default List value population methods*/
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}

	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("ISS",defaultDocType);
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

	public String getRequestByStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_REQ_BY_STORE_SELECT");
		java.util.ArrayList sqlParam = new java.util.ArrayList (1);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		sqlParam.add(getLoginById());
		return getListValues(sql, sqlParam,"");
	}

	public String getRequestOnStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_REQ_ON_STORE_SELECT");
		java.util.ArrayList sqlParam = new java.util.ArrayList (1);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
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
	
	public void setPrintDocNo(ArrayList Pdoc_no){
		PDocNo = Pdoc_no;
	}
	public ArrayList getPrintDocNo(){
		return PDocNo;
	}

	/*
	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) {
        ArrayList itemClasses = new ArrayList();
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
           pstmt = connection.prepareStatement("SELECT stp.item_class_code, mm.short_desc FROM st_store_parent_store stp, mm_item_class_lang_vw mm WHERE mm.item_class_code = stp.item_class_code AND stp.store_code =? AND stp.parent_store_code =? AND stp.eff_status = 'E'  AND language_id =? ");
            pstmt.setString(1, request_by_store);
            pstmt.setString(2, request_on_store);
            pstmt.setString(3, getLanguageId());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                itemClasses.add(record);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return itemClasses;
	}
*/
	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST1"),alParameters),defaultValue);
	}

	public void updateRemarks(java.util.Hashtable remarksData) {
		StringBuffer key = new StringBuffer();
		String doc_type_code = (String) remarksData.get("doc_type_code");
		doc_type_code = doc_type_code.trim();
		String doc_no = (String) remarksData.get("doc_no");
		doc_no=doc_no.trim();
		key.append(doc_type_code);
		key.append('-');
		key.append(doc_no);
		
	//	hmRemarks.put(key.toString(),new CancelRequestRemarksBean(doc_type_code, doc_no, (String)remarksData.get("remarks")));
	//	setCancelled_remarks( (String)remarksData.get("remarks") );
	
	hmRemarks.put(key.toString(),new CancelRequestRemarksBean(doc_type_code, doc_no, (String)remarksData.get("remarks"),   (String)remarksData.get("remarks_code_1")));
	setCancelled_remarks( (String)remarksData.get("remarks") );
	
  //hmRemarks.put(key.toString(),new CancelRequestRemarksBean(doc_type_code, doc_no, (String)remarksData.get("remarks_code_1")));
  //setCancelled_remarks( (String)remarksData.get("remarks_code_1") ); //Added by Rabbani #Inc no:33352 on 18/06/12 
		
	}
	
	public String getRemarks(String key) {
		if (hmRemarks.containsKey(key)) {
			CancelRequestRemarksBean cancelRequestRemarksBean = (CancelRequestRemarksBean) hmRemarks.get(key);
			return cancelRequestRemarksBean.getRemarks();
		}
		return "";
	}
	
	public String getRemarks_code(String key) {  
		if (hmRemarks.containsKey(key)) {
			CancelRequestRemarksBean cancelRequestRemarksBean = (CancelRequestRemarksBean) hmRemarks.get(key);
			return cancelRequestRemarksBean.getRemarks_code();
		}
		return "";
	}
	//Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 19-JULY-2013  Starts
	public void updateItemRemarks(java.util.Hashtable remarksData) {
		StringBuffer key = new StringBuffer();
		String doc_type_code = (String) remarksData.get("doc_type_code");
		doc_type_code = doc_type_code.trim();
		String doc_no = (String) remarksData.get("doc_no");
		doc_no=doc_no.trim();
		String item_code = (String) remarksData.get("item_code");
		key.append(doc_type_code);
		key.append('-');
		key.append(doc_no);
		key.append('-');
		key.append(item_code);
		
	  hmItemRemarks.put(key.toString(),new CancelRequestRemarksBean(doc_type_code, doc_no, (String)remarksData.get("remarks"),   (String)remarksData.get("remarks_code_1")));
	}
	public String getItemRemarks(String key) {
		if (hmItemRemarks.containsKey(key)){
			CancelRequestRemarksBean cancelRequestRemarksBean = (CancelRequestRemarksBean) hmItemRemarks.get(key);
			return cancelRequestRemarksBean.getDtlRemarks();
		}
		return "";
	}
	
	public String getItemRemarks_code(String key) {
		if (hmItemRemarks.containsKey(key)) {
			CancelRequestRemarksBean cancelRequestRemarksBean = (CancelRequestRemarksBean) hmItemRemarks.get(key);
			return cancelRequestRemarksBean.getDtl_Remarks_code();
		}
		return "";
	}
	
	public ArrayList getDtlCheckItems(){
	return alDtlCheckedItems;
    }
	
	public void setRemarks(String key) {
		hmRemarks.remove(key);
	}
	
	public void setDtlRemarks(String key) {	
		hmItemRemarks.remove(key);
	}
	//ends

	public void updateSelectedValues(java.util.Hashtable selectedValues) {
		int total = Integer.parseInt((String)selectedValues.get("total_check_boxes"));
		String checkedIndices = (String)selectedValues.get("checkedIndices");
		String checked_item_indices = (String)selectedValues.get("checked_item_indices"); //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
		String key = null;
		ArrayList aldtlRemoveKey = new ArrayList();
		ArrayList alAddItemKey  = new ArrayList ();  
		java.util.ArrayList alRemoveKey = new java.util.ArrayList (total);
		for (int i=0;i<total;i++) {
			alRemoveKey.add((String)selectedValues.get("doc_"+i));
			int dtl_length    = Integer.parseInt((String)selectedValues.get("item_size_"+i));
			   aldtlRemoveKey = new ArrayList (dtl_length);
			for(int j = 0; j< dtl_length;j++){
			aldtlRemoveKey.add((String)selectedValues.get("item_cancel_"+i+"_"+j));
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

	//public void loadData(String doc_type_code, String doc_no) {//commented by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 19-JULY-2013 
	public void loadData(String facility_id,String doc_type_code, String doc_no,String item_code,String item_desc) {
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		CancelRequestDetailBean cancelRequestDetailBean;
		alItems = new java.util.ArrayList ();
		try {
            connection = getConnection();
            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_DTL_SELECT"));

			String docTypeCode = doc_type_code.trim();
			
         //   pstmt.setString(1, loginFacilityID);
		 
            pstmt.setString(1, facility_id);
			pstmt.setString(2, docTypeCode);
            pstmt.setString(3, doc_no);
            pstmt.setString(4, item_code);
            pstmt.setString(5, item_desc);
            pstmt.setString(6, getLanguageId());
            resultSet = pstmt.executeQuery();

	        while (resultSet != null && resultSet.next()) {
				cancelRequestDetailBean = new CancelRequestDetailBean(resultSet);
				alItems.add(cancelRequestDetailBean);
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
	}


	public java.util.HashMap modify() {

		HashMap hmResult	=	new HashMap();
		ArrayList aldocdtl  = new ArrayList();
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		
		

		try {
            connection = getConnection();

			HashMap hmTableData = new HashMap();
			HashMap hmSQLMap	= new HashMap();
			ArrayList alModifyData = new ArrayList();
			ArrayList alRevertBackData = new ArrayList();
			ArrayList  datadtl  = new ArrayList();  //added by Rabbani,#inc no:27426 ,27-07-11 

			String key = null;
			Properties properties = getProperties();
			//CancelRequestRemarksBean remarksBean = new CancelRequestRemarksBean();
			hmTableData.put("properties",properties);

			hmResult.put("result", new Boolean(false)) ;
			hmResult.put("message", "Initial Message") ;

			ArrayList alCheckedDocNumbers = new ArrayList();
			if(alCheckedItems.size() != 0 ){
			 for (int i=0;i<alCheckedItems.size(); i++) 
			{
			    key = (String) alCheckedItems.get(i);
				if (key == null || key.trim() == "") 
				  continue;
				
				//StringTokenizer st = new StringTokenizer(key,"-"); Commented by suresh.r on 28/04/2015 against 55201
				StringTokenizer st = new StringTokenizer(key,"~");
				String docTypeCode = st.nextToken().trim();
				String docNoValue = st.nextToken();
				String reqfacility_id = st.nextToken(); //Added by Rabbani for Req facility_id on 23/10/2013
				//Added by Rabbani #Bru-HIMS-CRF-118[inc no:30077] for online reports
				HashMap hmdocdtl	=	new HashMap();
				hmdocdtl.put("doc_type_code",docTypeCode);
				hmdocdtl.put("doc_no",docNoValue);
                aldocdtl.add(hmdocdtl);
				
				int docNo = 0;
				if(docNoValue != null && !(docNoValue.equals(""))) 
				{
					docNo = Integer.parseInt(docNoValue);
				}
				String remarks      = "";
				String remarks_desc = ""; 
				String remarks_hdr  = "";
				 key = "";
				 key = docTypeCode+"-"+docNoValue;
				if( ( hmRemarks.get(key) != null ) &&  (hmRemarks.get(key) != ""))
				{
				   // Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
                    remarks_hdr  = ((Object)hmRemarks.get(key)).toString();
					remarks      = remarks_hdr.substring(remarks_hdr.lastIndexOf("=")+1).trim(); 
					remarks_desc = getRemarks(key);
				 }else{
					remarks     = "Cancelled as per request";
					remarks_desc = getRemarks(key);
				  }
				ArrayList<String> alParam = new ArrayList<String>();
				int doc_count = 0;
				try{
					alParam.add(login_facility_id);
					alParam.add(docTypeCode);
					alParam.add(""+docNo);
					doc_count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_REQUEST_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND REQUEST_STATUS NOT IN ('W','P')",alParam)).get("COUNT"));
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

				ArrayList alModifyRecord = new java.util.ArrayList();
				 
				alModifyRecord.add(login_by_id);
				alModifyRecord.add(checkForNull(remarks));
				alModifyRecord.add("L");
				alModifyRecord.add(login_by_id);
				alModifyRecord.add(login_at_ws_no);
				alModifyRecord.add(login_facility_id);
				alModifyRecord.add(checkForNull(remarks_desc)); //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
				//alModifyRecord.add(login_facility_id); //Commented by Rabbani # Inc no : 42782 on 05-SEP-2013
				alModifyRecord.add(reqfacility_id); //Added by Rabbani for Req facility_id on 23/10/2013 
				alModifyRecord.add(docTypeCode);
				alModifyRecord.add(""+docNo);
				alCheckedDocNumbers.add(""+docNo);				

				alModifyData.add(alModifyRecord);
				 
                
				/* Forming the data needed to revert back the pending_item_qty in st_item_store */
	            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REVERT_DTL_SELECT"));
	            pstmt.setInt(1, docNo);
	            pstmt.setString(2, docTypeCode);
	            resultSet = pstmt.executeQuery();

				while(resultSet != null && resultSet.next()) {
					String reqByStoreCode = resultSet.getString("REQ_BY_STORE_CODE");
					String pendingItemQty = resultSet.getString("PENDING_ITEM_QTY");
					String itemCode = resultSet.getString("ITEM_CODE");

					ArrayList alRecordToRevertBack = new ArrayList();		
					alRecordToRevertBack.add(pendingItemQty);
					alRecordToRevertBack.add(pendingItemQty);//Added for TTM-SCF-0202
					alRecordToRevertBack.add(login_by_id);
					alRecordToRevertBack.add(login_at_ws_no);
					alRecordToRevertBack.add(login_facility_id);
					alRecordToRevertBack.add(reqByStoreCode);
					alRecordToRevertBack.add(itemCode);

					alRevertBackData.add(alRecordToRevertBack);
				} 
				//added by Rabbani,#inc no:27426 ,27-07-11 
				//starts here #updating st_request_dtl at the time of cancel the request.
				pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REVERT_DTL_SELECT"));
                pstmt.setInt(1, docNo);
                pstmt.setString(2, docTypeCode);
				
				resultSet = pstmt.executeQuery();
				 
                while (resultSet != null && resultSet.next()) {
					 key = "";
					//String reqByStoreCode = resultSet.getString("REQ_BY_STORE_CODE"); commented by ganga for unused variables on Wednesday, October 19, 2011
					String pendingItemQty = resultSet.getString("PENDING_ITEM_QTY");
                    String itemcode = resultSet.getString("item_code"); 
					
					//Rabbani # Bru-HIMS-CRF-118[INC NO:30077] Starts
				    String dtl_remarks_desc   = "";
				    String dtl_remarks_code   = ""; 
				    String remarks_dtl        = "";
			         key = docTypeCode+"-"+docNo+"-"+itemcode;
	
				  if( ( hmItemRemarks.get(key) != null ) &&  (hmItemRemarks.get(key) != ""))
				  {
                    remarks_dtl = ((Object)hmItemRemarks.get(key)).toString();
					dtl_remarks_code      =  remarks_dtl.substring(remarks_dtl.lastIndexOf("=")+1).trim(); 
					dtl_remarks_desc      =  getItemRemarks(key);
				  }else{
					dtl_remarks_desc      =  checkForNull(getItemRemarks(key));
					dtl_remarks_code      =  "Cancelled as per request";
					if(dtl_remarks_desc == ""){
					dtl_remarks_desc = remarks_desc;
					dtl_remarks_code = remarks;
					}
				  }
				  //ends				 
					ArrayList dtlupd = new ArrayList();		
				    dtlupd.add(pendingItemQty);
					dtlupd.add(login_by_id);
					dtlupd.add(login_at_ws_no);
					dtlupd.add(login_facility_id);
					dtlupd.add(checkForNull(dtl_remarks_code)); //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
					dtlupd.add(checkForNull(dtl_remarks_desc)); //Rabbani # Bru-HIMS-CRF-118[INC NO:30077]
					dtlupd.add(itemcode);
					dtlupd.add(docNo);
					dtlupd.add(docTypeCode);
					
			        datadtl.add(dtlupd);
			 }
			  //ends here 
				closeResultSet(resultSet);
                closeStatement(pstmt);
			 }
		  }
		  //Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 19-JULY-2013  for item level updation
		  for (int i=0;i<alDtlCheckedItems.size(); i++) 
			{
			    key = "";
				key = (String) alDtlCheckedItems.get(i);
				if (key == null || key.trim() == "") 
				  continue;
				
				//StringTokenizer st = new StringTokenizer(key,"-"); Commented by suresh.r on 28/04/2015 against 55201
				StringTokenizer st = new StringTokenizer(key,"~");
				String doc_type_code_value = st.nextToken().trim();
				String doc_no_value = st.nextToken();
				String item_code =  st.nextToken();
				//Added by Rabbani #Bru-HIMS-CRF-118[inc no:30077] for online reports
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
				
				if(doc_no_value != null && !(doc_no_value.equals(""))) 
				{
					doc_No = Integer.parseInt(doc_no_value);
				}
				   String dtl_remarks_desc  = "";
				   String dtl_remarks_code  = "";
				   String remarks_dtl       = "";
				   //Modified against ML-BRU-SCF-1715 starts
				 String  key1 = doc_type_code_value+"-"+doc_No+"-"+item_code; 
				if( ( hmItemRemarks.get(key1) != null ) &&  (hmItemRemarks.get(key1) != ""))
				{
                    remarks_dtl = ((Object)hmItemRemarks.get(key1)).toString();
					dtl_remarks_code      =  remarks_dtl.substring(remarks_dtl.lastIndexOf("=")+1).trim(); 
					dtl_remarks_desc      =  getItemRemarks(key1);
				}else{
				    dtl_remarks_desc      =  checkForNull(getItemRemarks(key1));
				   //Modified against ML-BRU-SCF-1715 ends
					dtl_remarks_code      =  "Cancelled as per request";
					//String remarks = ""; //commented by Rabbani on 24-Mar-2014 for chkstyles
				    //String remarks_desc = "";   //commented by Rabbani on 24-Mar-2014 for chkstyles
					if(dtl_remarks_desc == ""){
					key = doc_type_code_value+"-"+doc_No;
			         dtl_remarks_desc = getRemarks(key);
			         dtl_remarks_code = getRemarks_code(key);
					}
				}
			   ArrayList<String> alParamtr = new ArrayList<String>();
				int doc_count_ = 0;
				try{
					alParamtr.add(login_facility_id);
					alParamtr.add(doc_type_code_value);
					alParamtr.add(""+doc_No);
					doc_count_ = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT(*) COUNT FROM ST_REQUEST_HDR WHERE FACILITY_ID = ? AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND REQUEST_STATUS NOT IN ('W','P')",alParamtr)).get("COUNT"));
					
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
				/* Forming the data needed to revert back the pending_item_qty in st_item_store */
	            pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REVERT_DTL_SELECT_CANCEL_REQUEST"));
	            pstmt.setInt(1, doc_No);
	            pstmt.setString(2, doc_type_code_value);
	            pstmt.setString(3, item_code);
	            resultSet = pstmt.executeQuery();
				
				while(resultSet != null && resultSet.next()) {
					String reqByStoreCode = resultSet.getString("REQ_BY_STORE_CODE");
					String pendingItemQty = resultSet.getString("PENDING_ITEM_QTY");
					String itemCode = resultSet.getString("ITEM_CODE");
					
					ArrayList alRecordToRevertBack = new ArrayList();		
					alRecordToRevertBack.add(pendingItemQty);
					alRecordToRevertBack.add(pendingItemQty);//Added for TTM-SCF-0202
					alRecordToRevertBack.add(login_by_id);
					alRecordToRevertBack.add(login_at_ws_no);
					alRecordToRevertBack.add(login_facility_id);
					alRecordToRevertBack.add(reqByStoreCode);
					alRecordToRevertBack.add(itemCode);

					alRevertBackData.add(alRecordToRevertBack);
				}
				//starts here #updating st_request_dtl at the time of cancel the request.
				pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_REVERT_DTL_SELECT_CANCEL_REQUEST"));
				pstmt.setInt(1, doc_No);
	            pstmt.setString(2, doc_type_code_value);
	            pstmt.setString(3, item_code);
				
				resultSet = pstmt.executeQuery();
                while (resultSet != null && resultSet.next()) {
					String pendingItemQty = resultSet.getString("PENDING_ITEM_QTY");
                    String itemcode = resultSet.getString("item_code"); 
			        					 
					ArrayList dtlupd = new ArrayList();		
				    dtlupd.add(pendingItemQty);
					dtlupd.add(login_by_id);
					dtlupd.add(login_at_ws_no);
					dtlupd.add(login_facility_id);
					dtlupd.add(checkForNull(dtl_remarks_code)); // remarks code
					dtlupd.add(checkForNull(dtl_remarks_desc)); // remarks desc
					dtlupd.add(itemcode);
					dtlupd.add(doc_No);
					dtlupd.add(doc_type_code_value);
					
			        datadtl.add(dtlupd);
			 }
				closeResultSet(resultSet);
                closeStatement(pstmt);
			}
			//ends Rabbani # Bru-HIMS-CRF-118[INC NO:30077]

			//hmTableData.put("ModifyData",alModifyData);
			//hmSQLMap.put("ModifySQL", eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_UPDATE"));


			hmTableData.put("HeaderUpdateData",alModifyData);
			hmSQLMap.put("UpdateHDRSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_UPDATE"));

			hmTableData.put("RevertBackData",alRevertBackData);
			hmSQLMap.put("RevertBackSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_REVERT_REQUEST_ON_CANCEL"));

			//added by Rabbani,#inc no:27426 ,27-07-11
			hmTableData.put("DetailUpdateData",datadtl);
			//hmSQLMap.put("UpdateDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_DTL"));
			hmSQLMap.put("UpdateDTLSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_BY_ITEM"));
			// ENDS HERE 
			//eST.CancelRequest.CancelRequestRemote cancelRequestremote = null;

/*			InitialContext initialcontext = new InitialContext();
			Object obj1 = initialcontext.lookup(getStRepositoryValue("JNDI_ST_CANCEL_REQUEST"));
			eST.CancelRequest.CancelRequestHome cancelRequesthome = (eST.CancelRequest.CancelRequestHome)PortableRemoteObject.narrow(obj1, eST.CancelRequest.CancelRequestHome.class);
			cancelRequestremote = cancelRequesthome.create();
			hmResult = cancelRequestremote.modify(hmTableData, hmSQLMap);*/

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



			hmResult.put("message",getSTMessage(getLanguageId(),(String) hmResult.get( "message" ),"ST") ) ;
		
		/*	try {
				hmResult = new eST.CancelRequestLocal.CancelRequestManager().modify( hmTableData, hmSQLMap ) ;
				hmResult.put("msgid", (String) hmResult.get("message"));
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}

			/* New Code Added - end*/

			/*SingleTableHandlerHome singleTableHandlerHome = null;
			SingleTableHandlerRemote singleTableHandlerRemote = null;
			try {
				InitialContext context = new InitialContext();
				Object object = context.lookup(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));
				singleTableHandlerHome = (SingleTableHandlerHome) PortableRemoteObject.narrow(object, SingleTableHandlerHome.class);
				singleTableHandlerRemote = singleTableHandlerHome.create();
		
				hmResult = singleTableHandlerRemote.singleBatchHandler(hmTableData, hmSQLMap) ;
				hmResult.put("msgid", (String) hmResult.get("msgid")) ;
			} 
			catch(Exception e) {
				hmResult.put("message", hmResult.get("message") + e.toString()) ;
				e.printStackTrace() ;
			} 
			finally {
				try {
					if(singleTableHandlerRemote != null)
						singleTableHandlerRemote.remove() ;
				}
				catch(Exception ee) {
					ee.printStackTrace();
					hmResult.put("message", ee.toString()) ;
				}
			} */
		}
		catch(Exception ex) {
			ex.printStackTrace();
			if(ex.getMessage().equals("ST_DOC_NO_FINALIZED_USER")){
				hmResult.put("result",false);
				hmResult.put("msgid","ST_DOC_NO_FINALIZED_USER");
				//hmResult.put("message",getSTMessage(getLanguageId(),"ST_DOC_NO_FINALIZED_USER","ST"));
				hmResult.put("message","ST_DOC_NO_FINALIZED_USER");
			}
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
		
		     /* SEND TO PRINT ONLINE REPORT STARTS*/	
            //Added by Rabbani #Bru-HIMS-CRF-118[inc no:30077] for online reports
			
			setPrintDocNo(aldocdtl);
			
			/*String alertRqdYN = "";
			PgetDoc_type_code = getDoc_type_code();
			ArrayList params = new ArrayList ();
			params.add(PgetDoc_type_code);
			params.add(getLoginFacilityId());
		
			try{			
				alertRqdYN=(String)(fetchRecord(getStRepositoryValue("SQL_ST_ONLINE_PRINT_ALERT_REQD_YN_SELECT"),params).get("ALERT_REQD_YN"));
			}catch(Exception e)
			{
				e.printStackTrace();
			} */
		
		if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			/*if (isInternalRequest("ST","STBCANREQ")&& isDocTypePrintAllowed(PgetDoc_type_code)) {
				if(alertRqdYN.equals("Y")){	
						hmResult.put("flag",hmResult.get("flag") + "~PY");
				}
					else{
							hmResult.put("flag",hmResult.get("flag") + "~PN");
						}				
		}*/
		hmResult.put("flag",hmResult.get("flag") + "~PY");
	  }
		return hmResult;
	}

	public java.util.ArrayList getOnStores(String req_by_store) throws Exception {
			String chkParameters[] = {login_facility_id,getLanguageId(),checkForNull(req_by_store)};
			ArrayList result = new ArrayList();
				
			result = fetchRecords(StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_REQ_ON_STORE_SELECT"),chkParameters);
			return result;
	
	}
	public java.util.ArrayList getRequestOnStore(String request_type) throws Exception {
			String chkParameters[] = {login_facility_id,getLanguageId(),login_by_id,request_type,request_type};
			ArrayList result = new ArrayList();
			//result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);
			result = fetchRecords("SELECT   st.store_code store_code, mm.short_desc short_desc FROM st_store st, mm_store_lang_vw mm, st_user_access_for_store su  WHERE st.store_code = mm.store_code    AND mm.eff_status = 'E' AND st.req_allowed_yn = 'Y' AND su.req_allowed_yn = 'Y' AND su.cancl_allowed_yn = 'Y' AND su.store_code = st.store_code AND mm.facility_id = ? AND mm.language_id = ? AND user_id = ? and mm.EXTERNAL_YN like decode(?,'A','%',?) ORDER BY 2, 1",chkParameters);

			
			
			return result;
	}	
	//Added by Rabbani #BRU-HIMS-CRF-118[INC NO: 30077] on 24-JULY-2013 for online report Starts
	public void doOnlineReportPrinting(String doc_no,String doc_type_code,Object request,Object response) {
		try{  
	
			String reportid = "STBCANREQ";
			if (!isInternalRequest("ST",reportid)) return;
			ecis.utils.OnlineReports onlineReports 	= null;
			ecis.utils.OnlineReport report2 = null;
		   
				onlineReports 	= new ecis.utils.OnlineReports() ;
				report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid) ;
				//report2= new ecis.utils.OnlineReport( getLoginFacilityId(), "ST", reportid, "S", "") ;
				report2.addParameter("p_facility_id", getLoginFacilityId()) ;
				report2.addParameter("p_module_id", "ST") ;
				report2.addParameter("p_report_id", reportid) ;
				report2.addParameter("p_user_name", getLoginById()) ;
				report2.addParameter("p_language_id", getLanguageId()) ;
				report2.addParameter("p_doc_type_code",doc_type_code);
				report2.addParameter("p_doc_no",doc_no);
				report2.addParameter("p_req_on_store_code",checkForNull(getRequest_on_store()));
				report2.addParameter("p_req_by_store_code",checkForNull(getRequest_by_store()));
				report2.addParameter("p_req_date_from",checkForNull(getFrom_date()));
				report2.addParameter("p_req_date_to",checkForNull(getTo_date()));
				//report2.addParameter("p_finalized_yn","Y");
				
				onlineReports.add( report2) ;
				 
				if (!isDocTypePrintAllowed(doc_type_code)){ return;}
				
				onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );

		}
		catch ( Exception exception) {
			exception.printStackTrace();
		}
	}
//ends	
	
	
}
