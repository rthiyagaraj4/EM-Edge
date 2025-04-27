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
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import eST.Common.StRepository;

public class POCancelRequestBean extends eST.Common.StTransaction implements Serializable {
	
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
	private java.util.ArrayList alItems;
	private java.util.ArrayList alCheckedItems;
	private java.util.HashMap hmRemarks;

	public POCancelRequestBean() {
		alCheckedItems = new java.util.ArrayList();
		hmRemarks = new java.util.HashMap();
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
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}

	public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("PRQ",defaultDocType);
	}

	public String getRequestByStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_POREQUEST_REQ_BY_STORE_SELECT");
		java.util.ArrayList sqlParam = new java.util.ArrayList (1);
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		sqlParam.add(getLoginById());
		return getListValues(sql, sqlParam,"");
	}

	public String getRequestOnStore() {
		String sql = "SELECT DEPT_CODE,SHORT_DESC FROM AM_DEPT_LANG_VW WHERE   EFF_STATUS='E'AND LANGUAGE_ID = ? ORDER BY SHORT_DESC";
		java.util.ArrayList sqlParam = new java.util.ArrayList (1);
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,"");
	}

	public String getItemClasses() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_SELECT_LIST");
		java.util.ArrayList sqlParam = new java.util.ArrayList (2);
		sqlParam.add(request_by_store);
		sqlParam.add(request_by_store);
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
			String chkParameters[] = {request_by_store,getLanguageId()};
			ArrayList result = new ArrayList();
			result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_STORE_SELECT"),chkParameters);
			return result;
	}
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
		
		hmRemarks.put(key.toString(),new POCancelRequestRemarksBean(doc_type_code, doc_no, (String)remarksData.get("remarks")));
		setCancelled_remarks( (String)remarksData.get("remarks") );
	}
	
	public String getRemarks(String key) {
		if (hmRemarks.containsKey(key)) {
			POCancelRequestRemarksBean poCancelRequestRemarksBean = (POCancelRequestRemarksBean) hmRemarks.get(key);
			return poCancelRequestRemarksBean.getRemarks();
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
		doc_type_code = "";
		doc_no = "";
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
	}

	public HashMap validate()
	{

		HashMap resultMap = new HashMap();
		resultMap.put("result", new Boolean(true));
		resultMap.put("message", "success");

		POCancelRequestRemarksBean remarksBean;
		for (int i=0;i<alCheckedItems.size(); i++){
			String key = (String) alCheckedItems.get(i);
			String remarks="";
			if (key == null || key.trim() == "") {
				continue;
			}
			if(hmRemarks.get(key) != null){
				remarksBean = (POCancelRequestRemarksBean) hmRemarks.get(key);
				remarks = remarksBean.getRemarks();
                remarks = remarks.substring(remarks.lastIndexOf("=")+1) ;
			}else{
         		hmRemarks.put(key,"Cancelled as per request");
			}

			resultMap.put("result", new Boolean(true));
		}

		return resultMap;
	}


	public void setAll(Hashtable hashValues) {
		updateSelectedValues(hashValues);
	}

	public void loadData(String doc_type_code, String doc_no) {
		Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
		POCancelRequestDetailBean poCancelRequestDetailBean;
		alItems = new java.util.ArrayList ();
		try {
            connection = getConnection();
            //pstmt = connection.prepareStatement(StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_DTL_SELECT"));
            pstmt = connection.prepareStatement("SELECT   DOC_NO, DOC_SRL_NO, DTL.ITEM_CODE, ITM.SHORT_DESC ITEM_DESC,REQ_QTY REQ_GEN_UOM_QTY, NVL(GRN_GEN_UOM_QTY,0) GRN_QTY FROM PO_REQUEST_DTL DTL, MM_ITEM_LANG_VW ITM WHERE FACILITY_ID = (SELECT DISTINCT FACILITY_ID FROM PO_REQUEST_DTL WHERE DOC_TYPE_CODE = DTL.DOC_TYPE_CODE AND DOC_NO = DTL.DOC_NO) AND DOC_TYPE_CODE = ? AND DOC_NO = ? AND DTL.ITEM_CODE = ITM.ITEM_CODE AND ITM.LANGUAGE_ID = ? ORDER BY DOC_SRL_NO");

			String docTypeCode = doc_type_code.trim();
			
         //   pstmt.setString(1, loginFacilityID);
            pstmt.setString(1, docTypeCode);
            pstmt.setString(2, doc_no);
            pstmt.setString(3, getLanguageId());
            resultSet = pstmt.executeQuery();

	        while (resultSet != null && resultSet.next()) {
				poCancelRequestDetailBean = new POCancelRequestDetailBean(resultSet);
				alItems.add(poCancelRequestDetailBean);
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
			ArrayList alRevertBackData = new ArrayList();
			ArrayList alPORevertBackData = new ArrayList();
			 pstmt = connection.prepareStatement("SELECT HDR.REQ_STORE_CODE, DTL.REQ_QTY,DTL.ITEM_CODE FROM PO_REQUEST_HDR HDR, PO_REQUEST_DTL DTL WHERE HDR.DOC_NO = DTL.DOC_NO AND HDR.DOC_NO = ? AND HDR.DOC_TYPE_CODE = ? AND HDR.FACILITY_ID = ? AND HDR.FACILITY_ID=DTL.FACILITY_ID");
	    
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
				String docTypeCode = st.nextToken().trim();
				String docNoValue = st.nextToken();
				int docNo = 0;

				if(docNoValue != null && !(docNoValue.equals(""))) 
				{
					docNo = Integer.parseInt(docNoValue);
				}

				String remarks = "";
				if( ( hmRemarks.get(key) != null ) &&  (hmRemarks.get(key) != "")){
                    remarks = ((Object)hmRemarks.get(key)).toString();
					remarks = remarks.substring(remarks.lastIndexOf("=")+1) ;
				}else{
					remarks = "Cancelled as per request";
				}

				ArrayList alModifyRecord = new java.util.ArrayList();
				alModifyRecord.add(login_by_id);

				alModifyRecord.add(remarks);

				alModifyRecord.add("X");
				alModifyRecord.add(login_by_id);
				alModifyRecord.add(login_at_ws_no);
				alModifyRecord.add(login_facility_id);
				alModifyRecord.add(login_facility_id);
				alModifyRecord.add(docTypeCode);
				alModifyRecord.add(""+docNo);
				alCheckedDocNumbers.add(""+docNo);				

				alModifyData.add(alModifyRecord);
				ArrayList alRecordToRevertBack = new ArrayList();
				alRecordToRevertBack.add(login_facility_id);
				alRecordToRevertBack.add(docTypeCode);
				alRecordToRevertBack.add(docNo);
				String status_srl_no = "1";
				try{
					status_srl_no=(String)fetchRecord("select ST_STATUS_SRL_NO.nextval count  from dual").get("COUNT");
				}catch (Exception e){
					e.printStackTrace();
				}
				alRecordToRevertBack.add(status_srl_no);
				alRecordToRevertBack.add("X");
				alRecordToRevertBack.add(login_by_id);
				alRecordToRevertBack.add(remarks);
				alRecordToRevertBack.add(login_by_id);
				alRecordToRevertBack.add(login_at_ws_no);
				alRecordToRevertBack.add(login_facility_id);
				alRecordToRevertBack.add(login_by_id);
				alRecordToRevertBack.add(login_at_ws_no);
				alRecordToRevertBack.add(login_facility_id);
				alRevertBackData.add(alRecordToRevertBack);
			
			/* Forming the data needed to revert back the pending_item_qty in st_item_store */

	             pstmt.setInt(1, docNo);
	            pstmt.setString(2, docTypeCode);
	            pstmt.setString(3, login_facility_id);
	            resultSet = pstmt.executeQuery();

				while(resultSet != null && resultSet.next()) {
					String reqByStoreCode = resultSet.getString("REQ_STORE_CODE");
					String pendingItemQty = resultSet.getString("REQ_QTY");
					String itemCode = resultSet.getString("ITEM_CODE");

					ArrayList alPORecordToRevertBack = new ArrayList();		
					alPORecordToRevertBack.add(pendingItemQty);
					alPORecordToRevertBack.add(login_by_id);
					alPORecordToRevertBack.add(login_at_ws_no);
					alPORecordToRevertBack.add(login_facility_id);
					alPORecordToRevertBack.add(reqByStoreCode);
					alPORecordToRevertBack.add(itemCode);

					alPORevertBackData.add(alPORecordToRevertBack);
				}
				closeResultSet(resultSet); // Common-ICN-0091 
			}

		




			hmTableData.put("HeaderUpdateData",alModifyData);
			hmSQLMap.put("UpdateHDRSQL", "UPDATE PO_REQUEST_HDR SET CURR_STATUS_BY_ID =	? ,	CURR_STATUS_REMARKS =	?,CURR_STATUS_DATE=SYSDATE, CURR_STATUS =	?, MODIFIED_BY_ID =	? ,	MODIFIED_DATE =	SYSDATE	, MODIFIED_AT_WS_NO	= ?	, MODIFIED_FACILITY_ID = ?	WHERE FACILITY_ID =	?  AND DOC_TYPE_CODE = ?  AND DOC_NO = ?");

			hmTableData.put("RevertBackData",alRevertBackData);
			hmSQLMap.put("RevertBackSQL", "INSERT INTO po_request_status (FACILITY_ID, DOC_TYPE_CODE, DOC_NO, STATUS_SRL_NO, STATUS, STATUS_BY_ID, STATUS_DATE, STATUS_REMARKS, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID) VALUES (?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?)");
			hmTableData.put("PORevertBackData",alPORevertBackData);
			hmSQLMap.put("PORevertBackSQL", "UPDATE ST_ITEM_STORE SET PENDING_PO_REQ_QTY = PENDING_PO_REQ_QTY - NVL(?,0), MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_AT_WS_NO = ?, MODIFIED_FACILITY_ID = ? WHERE STORE_CODE = ? AND ITEM_CODE = ?");
			
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
