/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO;

import java.io.Serializable;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import ePO.Common.PoRepository;
import eCommon.Common.*;
import ePO.POCancelRequest.*;


public class STPOCancelRequestBean extends ePO.Common.PoTransaction implements Serializable {
	
	private String req_code;
	private String req_no;
	private String doc_ref;
	private String doc_date;
	private String request_by_store;
	private String request_on_store;
	private String item_class_code;
	private String cancelled_remarks;
	private String defaultDocType;
	private String entity_param;
	private String user_id;
	private java.util.ArrayList alItems;
	private java.util.ArrayList alCheckedItems;
	private java.util.HashMap hmRemarks;

	public STPOCancelRequestBean() {
		alCheckedItems = new java.util.ArrayList();
		hmRemarks = new java.util.HashMap();
	}

	public void setDoc_type_code(String req_code) {
		 this.req_code = req_code;
	}

	public String getDoc_type_code() {
		 return req_code;
	}
	public void setDoc_no(String req_no) {
		 this.req_no = req_no;
	}

	public String getDoc_no() {
		 return req_no;
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
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}

	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("PRQ",defaultDocType);
	}
	public String getPODocTypeCodes(){
		return getPODefaultDocumentTypeList("POREQN");	
	}
	private String getPODefaultDocumentTypeList(String trn_type){
		ArrayList arr_language = new ArrayList();   
		arr_language.add(trn_type);
		arr_language.add(getLanguageId());
   //	return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),trn_type));
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_TYPE_SELECT"),arr_language));  // Added By Padmapriya INC # 34817 on 07/09/2012
	}
     
	public String getRequestByStore() {
		ArrayList alParameters =  new ArrayList();							
		alParameters.add(getLoginById());
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_USER_ACCESS_FOR_STORE_SELECT"),alParameters),getRequest_by_store()); 
	}
	
	
		public String getPurchaseUnit() {
		ArrayList sqlParam = new ArrayList();		
		sqlParam.add(getLoginById());
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST"),sqlParam),getRequest_on_store()); 
		
	}
	public String getPurchaseUnitList() {
	    ArrayList Param = new ArrayList();		
		Param.add(getLoginById());
		Param.add(getLoginFacilityId());
		//return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PUR_UNIT_LIST"),Param),getRequest_on_store()); 
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_PO_PURCHASE_UNIT_LIST_FOR_PUR_REQ_CANCEL"),Param),getRequest_on_store());  // Added By Padmapriya INC # 34817 on 07/09/2012
		
	}
	

	public String getRequestOnStore() {
		String sql = "SELECT DEPT_CODE,SHORT_DESC FROM AM_DEPT_LANG_VW WHERE   EFF_STATUS='E'AND LANGUAGE_ID = ? ORDER BY SHORT_DESC";
		java.util.ArrayList sqlParam = new java.util.ArrayList (1);
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,"");
	}

	public String getItemClasses() {
		String sql = ePO.Common.PoRepository.getPoKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(request_by_store);
		sqlParam.add(request_by_store);
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,getItem_class_code());
	}

	public String getAllItemClasses() {
		String sql = ePO.Common.PoRepository.getPoKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(getLanguageId());
		return getListValues(sql,sqlParam,"");
	}

	public ArrayList getCheckItems(){
	return alCheckedItems;
}
	public java.util.ArrayList getItemClasses(String request_by_store,String request_on_store) throws Exception {
			String chkParameters[] = {request_by_store,getLanguageId()};
			ArrayList result = new ArrayList();
			result = fetchRecords(ePO.Common.PoRepository.getPoKeyValue("SQL_ST_ITEM_CLASS_STORE_SELECT"),chkParameters);
			return result;
	}
	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList(2);
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		
		return getListOptionTag(getListOptionArrayList(getPoRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}
	
	public HashMap getUomDesc(String uom_code){
		HashMap hmRecord = null;
		
		try{
			ArrayList chkParameters=new ArrayList();
			chkParameters.add(uom_code);
			chkParameters.add(getLanguageId());
			hmRecord		=	fetchRecord(getPoRepositoryValue("SQL_PO_UOM_DESC_SELECT"),chkParameters);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return hmRecord;
	}

	public void updateRemarks(java.util.Hashtable remarksData) {
		StringBuffer key = new StringBuffer();
		String req_code = (String) remarksData.get("req_code");
		req_code = req_code.trim();
		String req_no = (String) remarksData.get("req_no");
		req_no=req_no.trim();
		key.append(req_code);
		key.append('-');
		key.append(req_no);
		
	hmRemarks.put(key.toString(),new STPOCancelRequestRemarksBean(req_code, req_no, (String)remarksData.get("remarks"),(String)remarksData.get("remarks_code_1")));
		setCancelled_remarks( (String)remarksData.get("remarks") );
			
	}
	
	public String getRemarks(String key) {
		if (hmRemarks.containsKey(key)) {
			STPOCancelRequestRemarksBean stpoCancelRequestRemarksBean = (STPOCancelRequestRemarksBean) hmRemarks.get(key);
			return stpoCancelRequestRemarksBean.getRemarks();
		}
		return "";
	}
	
	public void setRemarks(String key) {
		java.util.ArrayList alRemoveKey = new java.util.ArrayList ();
		alRemoveKey.add(key);
		alCheckedItems.removeAll(alRemoveKey);
	/*	if (hmRemarks.containsKey(key)) {
			STPOCancelRequestRemarksBean stpoCancelRequestRemarksBean = (STPOCancelRequestRemarksBean) hmRemarks.get(key);
			stpoCancelRequestRemarksBean.setRemarks("");
		}
	*/
		hmRemarks.remove(key);
		
	}

	public String getRemarks_code(String key) { 
		if (hmRemarks.containsKey(key)) {
			STPOCancelRequestRemarksBean stpoCancelRequestRemarksBean = (STPOCancelRequestRemarksBean) hmRemarks.get(key);
			return stpoCancelRequestRemarksBean.getRemarks_code();
		}
		return "";
	}
	
	public void updateSelectedValues(java.util.Hashtable selectedValues) {
		int total = Integer.parseInt((String)selectedValues.get("total_check_boxes"));
		String checkedIndices = (String)selectedValues.get("checkedIndices");
		String key = null;
		java.util.ArrayList alRemoveKey = new java.util.ArrayList (total);
		for (int i=0;i<total;i++) {
			alRemoveKey.add((String)selectedValues.get("doc_"+i));
		}		
		alCheckedItems.removeAll(alRemoveKey);
		alRemoveKey = null;
		java.util.StringTokenizer checked = new  java.util.StringTokenizer(checkedIndices,",");
		java.util.ArrayList alAddKey  = new java.util.ArrayList ();
		while (checked.hasMoreElements()) {
			key = (String)checked.nextElement();
			if (key != null && key.trim() != "") {
				alAddKey.add((String) selectedValues.get("doc_"+key.trim()));
			}
		}
		alCheckedItems.addAll(alAddKey);
	}

	public void initialize() {
		super.initialize();
		req_code = "";
		req_no = "";
		doc_ref = "";
		doc_date = "";
		request_by_store = "";
		request_on_store = "";
		defaultDocType = "";
		alItems = new ArrayList();
		alCheckedItems = new ArrayList();
		hmRemarks = new HashMap();
	}

	public void clear() {
		super.clear();
		req_code = null;
		req_no = null;
		doc_ref = null;
		doc_date = null;
		request_by_store = null;
		request_on_store = null;
		defaultDocType = null;
		alItems = null;
		alCheckedItems = null;
		hmRemarks = null;
	}

	public HashMap validate()
	{

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");

		STPOCancelRequestRemarksBean remarksBean;
		for (int i=0;i<alCheckedItems.size(); i++){
			String key = (String) alCheckedItems.get(i);
			String remarks="";
			if (key == null || key.trim() == "") {
				continue;
			}
			if(hmRemarks.get(key) != null){
				remarksBean = (STPOCancelRequestRemarksBean) hmRemarks.get(key);
				remarks = remarksBean.getRemarks();
				remarks = remarks.substring(remarks.lastIndexOf("~")+1) ;
			}else{
         	//	hmRemarks.put(key,"Cancelled as per request");
				resultMap.put("message","REMARKS_NOT_BLANK");
				return resultMap;
			}

			resultMap.put("result", new Boolean(true));
		}

		return resultMap;
	}


	public void setAll(Hashtable hashValues) {
		updateSelectedValues(hashValues);
	}

	public void loadData(String req_code, String req_no) {
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		STPOCancelRequestDetailBean STpoCancelRequestDetailBean;
		alItems = new java.util.ArrayList ();
		try {
            connection = getConnection();
			
		   pstmt = connection.prepareStatement("SELECT   REQ_NO, REQ_SRL_NO, DTL.ITEM_CODE, ITM.SHORT_DESC ITEM_DESC,REQ_QTY REQ_GEN_UOM_QTY, NVL(GRN_GEN_UOM_QTY,0) GRN_QTY,DTL.REQ_UOM REQ_UOM  FROM PO_REQUEST_DETAIL DTL, MM_ITEM_LANG_VW ITM WHERE FACILITY_ID = (SELECT DISTINCT FACILITY_ID FROM PO_REQUEST_DETAIL WHERE  REQ_NO = DTL.REQ_NO) AND REQ_NO = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE AND ITM.LANGUAGE_ID = ? ORDER BY REQ_SRL_NO");

		    pstmt.setString(1, req_no);
            pstmt.setString(2, getLanguageId());
            resultSet = pstmt.executeQuery();

	        while (resultSet != null && resultSet.next()) {
				STpoCancelRequestDetailBean = new STPOCancelRequestDetailBean(resultSet);
				alItems.add(STpoCancelRequestDetailBean);
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
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;

		try {
            connection = getConnection();
			HashMap hmTableData = new HashMap();
			HashMap hmSQLMap	= new HashMap();
			ArrayList	alModifyData = new ArrayList();
		 
			String key = null;
			Properties properties = getProperties();
			hmTableData.put("properties",properties);

			hmResult.put("result", new Boolean(false)) ;
			hmResult.put("message", "Initial Message") ;

			ArrayList alCheckedDocNumbers = new ArrayList();
			for (int i=0;i<alCheckedItems.size(); i++) 
			{
				key = (String) alCheckedItems.get(i);
				if (key == null || key.trim() == "") 
				  continue;
				
				StringTokenizer st = new StringTokenizer(key,"-");
				String reqcode = st.nextToken().trim();
				String reqNoValue = st.nextToken();
				String  reqNo = "";
				
				if(reqcode != null && !(reqcode.equals(""))) 
				{
					reqcode = reqcode;

				}

				if(reqNoValue != null && !(reqNoValue.equals(""))) 
				{
					reqNo = reqNoValue;

				}

				String remarks = "";
				if( ( hmRemarks.get(key) != null ) &&  (hmRemarks.get(key) != "")){
                    remarks = ((Object)hmRemarks.get(key)).toString();
					remarks = remarks.substring(remarks.lastIndexOf("~")+1) ;
					
				}else{
				//	remarks = "Cancelled as per request";
					hmResult.put("message","REMARKS_NOT_BLANK");
					return hmResult;
				}

				ArrayList alModifyRecord = new java.util.ArrayList();
				
				alModifyRecord.add(remarks);

				alModifyRecord.add("CA");
				alModifyRecord.add(login_by_id);
				alModifyRecord.add(login_at_ws_no);
				alModifyRecord.add(login_facility_id);
				alModifyRecord.add(login_facility_id);
				alModifyRecord.add(""+reqNo);
				alCheckedDocNumbers.add(""+reqNo);	
                System.out.println("alModifyRecord===>" +alModifyRecord);				

				alModifyData.add(alModifyRecord);
			
				
		     closeResultSet(resultSet);
             closeStatement(pstmt);
			}
			

			hmTableData.put("HeaderUpdateData",alModifyData);
			hmSQLMap.put("UpdateHDRSQL", "UPDATE PO_REQUEST_HEADER SET REQ_CANCEL_REMARKS =    ? , REQ_STATUS =    ?, MODIFIED_BY_ID =    ? , MODIFIED_DATE =    SYSDATE    , MODIFIED_AT_WS_NO    = ?    , MODIFIED_FACILITY_ID = ?	WHERE FACILITY_ID =	?    AND REQ_NO = ?");
			 
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getPoRepositoryValue("JNDI_PO_CANCEL_REQUEST"),ePO.POCancelRequest.POCancelRequestHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			hmResult.put("message",getPOMessage(getLanguageId(),(String) hmResult.get( "message" ),"PO") ) ;
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
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
		return hmResult;
	}

	public java.util.ArrayList getOnStores(String req_by_store) throws Exception {
			String chkParameters[] = {getLanguageId(),checkForNull(req_by_store)};
			ArrayList result = new ArrayList();
				
			result = fetchRecords("SELECT MM.PO_DEPT_CODE PARENT_STORE_CODE, AM.SHORT_DESC FROM MM_STORE_LANG_VW MM, AM_DEPT_LANG_VW AM WHERE  MM.LANGUAGE_ID = AM.LANGUAGE_ID   AND MM.PO_DEPT_CODE =  AM.DEPT_CODE  AND MM.LANGUAGE_ID = ? AND  MM.STORE_CODE = ? ORDER BY 2, 1",chkParameters);
			return result;
	}
}
