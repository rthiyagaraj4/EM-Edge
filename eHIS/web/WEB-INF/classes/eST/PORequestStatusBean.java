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
import java.util.ArrayList;
public class PORequestStatusBean extends eST.Common.StTransaction implements Serializable {

	private String entity_param;
	private String defaultDocType;
	private String request_by_store;


	public PORequestStatusBean() {
	}
	public void setEntity_param(String entity_param) {
		this.entity_param = entity_param;
	}

	public String getEntity_param() {
		return this.entity_param;
	}
	public void setDefaultDocType(String defaultDocType) {
		this.defaultDocType = defaultDocType;
	}
	public void setRequest_by_store(String request_by_store) {
		 this.request_by_store = request_by_store;
	}

	public String getRequest_by_store() {
		 return request_by_store;
	}

	public void clear() {
		request_by_store = "";
		defaultDocType = "";
	}

public String getDocTypeCodes(){
		return getDefaultDocumentTypeList("PRQ",defaultDocType);
	}

	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}

	public String getRequestByStore() {
		String sql = eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT2");
		//String sql ="SELECT   st.store_code, mm.short_desc FROM st_store st,mm_store_lang_vw mm WHERE st.store_code = mm.store_code  AND st.prq_allowed_yn = 'Y' AND mm.facility_id = ? AND mm.language_id = ? ORDER BY 2";
		java.util.ArrayList sqlParam = new java.util.ArrayList ();
		sqlParam.add(getLoginFacilityId());
		sqlParam.add(getLanguageId());
		return getListValues(sql, sqlParam,"");
	}

public java.util.ArrayList getOnDepartmentRequestStatus(String req_by_store) throws Exception {
			String chkParameters[]={getLanguageId(),getRequest_by_store()};
			ArrayList result = new ArrayList();
			
		//	result = fetchRecords("SELECT mm.po_dept_code po_dept_code, am.short_desc FROM mm_store_lang_vw mm, am_dept_lang_vw am WHERE  mm.language_id = am.language_id   AND mm.po_dept_code =  am.dept_code  AND mm.language_id = ? and  mm.store_code = ? ORDER BY 2",chkParameters);
		result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_ST_AM_DEPT_SELECT1"),chkParameters);	
		return result;
	
	}
		public java.util.ArrayList getItemClasses(String request_by_store,String request_on_department) throws Exception {
			
			/**
			* @Name - Priya
			* @Date - 29/01/2010
			* @Inc# - IN018492
			* @Desc - As Item Classes have to be populated based on the selected store, the query has been modified
			*/
			//result = fetchRecords(eST.Common.StRepository.getStKeyValue("SQL_MM_ITEM_CLASS_FOR_STORE_SELECT_LIST"),chkParameters);
			String chkParameters[] = {request_by_store,getLanguageId()};
			ArrayList result = new ArrayList();
			String SQLQuery = "SELECT STP.ITEM_CLASS_CODE, MM.SHORT_DESC FROM ST_ITEM_CLASS_STORE STP, MM_ITEM_CLASS_LANG_VW MM WHERE MM.ITEM_CLASS_CODE = STP.ITEM_CLASS_CODE AND STP.STORE_CODE = ? AND LANGUAGE_ID = ?";
			result = fetchRecords(SQLQuery,chkParameters);
			return result;
	}



}
