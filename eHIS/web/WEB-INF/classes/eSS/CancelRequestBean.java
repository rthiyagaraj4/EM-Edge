/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Properties;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.StringTokenizer;

import eSS.Common.SsRepository;
import eSS.CancelRequestGroup.*;


public class CancelRequestBean extends eSS.Common.SsTransaction implements Serializable { 

	private String doc_ref;
	private String req_by_store_code;
	private String req_on_store_code;
	private String entry_completed_yn;
	private String cancelled_remarks;
	private String doc_type_code;
	private String doc_date;
	private String added_by_id;
	private String request_type;
	private String doc_no;
	private HashMap hmSsParameter =null;
	//private CancelRequestListBean		cancelRequestListBean	;
	private String req_qty;
	private String req_grp_code;

	private ArrayList alCheckedItems;
	private String cancelAll;


	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = checkForNull(doc_ref);
	}

	public String getDoc_ref() {
		 return doc_ref;
	}

	public void setReq_by_store_code(String req_by_store_code) {
		 this.req_by_store_code = req_by_store_code;
	}

	public void initSsParameter() throws Exception {
		hmSsParameter=getSSParameter();
	}

	public void initDoc_type_code() {
		doc_type_code=checkForNull((String)hmSsParameter.get("DEF_REQ_DOC_TYPE_CODE")) ;
	}

	public String getReq_by_store_code() {
		 return req_by_store_code;
	}

	public void setCancelled_remarks(String cancelled_remarks) {
		 this.cancelled_remarks = cancelled_remarks;
	}

	public String getCancelled_remarks() {
		 return cancelled_remarks;
	}

	public void setReq_on_store_code(String req_on_store_code) {
		 this.req_on_store_code = req_on_store_code;
	}

	public String getReq_on_store_code() {
		 return req_on_store_code;
	}

	public void setEntry_completed_yn(String entry_completed_yn) {
		 this.entry_completed_yn = checkForNull(entry_completed_yn,"N");
	}

	public String getEntry_completed_yn() {
		 return entry_completed_yn;
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code() {
		 return doc_type_code;
	}

	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public String getDoc_date() {
		 return doc_date;
	}

	public void setRequest_type(String request_type) {
		 this.request_type = request_type;
	}

	public String getRequest_type() {
		 return request_type;
	}

	public void setAdded_by_id(String added_by_id) {
		 this.added_by_id = added_by_id;
	}

	public String getAdded_by_id() {
		 return added_by_id;
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no() {
		 return doc_no;
	}
//Added By Sakti against BRU-HIMS-CRF-374
	public void setcancelAll(String cancelAll) {
		 this.cancelAll = checkForNull(cancelAll);
	}

	public String getcancelAll() {
		 return cancelAll;
	}
//Added ends
	public String getDoc_type_code_List(){
		return getDoc_type_code_ListOptions("REQ",getDoc_type_code());
	}

	public String getReq_on_store_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
//		alParam.add(login_by_id);
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_ISS_SELECT_LIST"), alParam), getReq_on_store_code());
	}

	public String getReq_by_store_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_REQ_SELECT_LIST"), alParam), getReq_by_store_code());
	}

	public String getRequest_type_List(){
		return getStaticListOptionTag( "N,Normal;U,Urgent;E,Elective", getRequest_type());
	}

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		updateSelectedValues(htRecordSet);//Added By Sakti against BRU-HIMS-CRF-374
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_no((String) htRecordSet.get("doc_no"));
		setCancelled_remarks((String) htRecordSet.get("cancelled_remarks"));
		setcancelAll(checkForNull((String) htRecordSet.get("cancelAll"),"N"));//Added By Sakti against BRU-HIMS-CRF-374
		
	}

//Added By Sakti against BRU-HIMS-CRF-374
	public void updateSelectedValues(Hashtable htFormValues) {
		int total = Integer.parseInt((String)htFormValues.get("total_check_boxes"));
		String checkedIndices = (String)htFormValues.get("checkedIndices");
		String key = null;
		ArrayList alRemoveKey = new ArrayList (total);
		for (int i=0;i<total;i++) {
			alRemoveKey.add((String)htFormValues.get("group_code_"+i));
		}		
		alCheckedItems.removeAll(alRemoveKey);
		alRemoveKey = null;
		StringTokenizer checked = new StringTokenizer(checkedIndices,",");
		ArrayList alAddKey  = new ArrayList ();
		while (checked.hasMoreElements()) {
			key = (String)checked.nextElement();
			if (key != null && key.trim() != "") {
				alAddKey.add((String) htFormValues.get("group_code_"+key.trim()));
			}
		}
		alCheckedItems.addAll(alAddKey);
	}
//Added ends

	public void clear(){
		super.clear();
		hmSsParameter =null;
		doc_ref="";
		req_by_store_code="";
		req_on_store_code="";
		entry_completed_yn="";
		doc_type_code="";
		doc_date="";
		request_type="";
		added_by_id="";
		doc_no="";
		req_qty="";
		req_grp_code="";
		cancelAll = "";

	}
//Added By Sakti against BRU-HIMS-CRF-374
	public void initialize() {
	
		alCheckedItems = new ArrayList();
	}
//Added ends
	public HashMap validate(){
		HashMap hmReturn	=	getMessageHashMap(true);
		if(getCancelled_remarks().length()>100){
			hmReturn.put(RESULT,FALSE);
		}
		return hmReturn;
	}

	public HashMap modify() {

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alModifyData		=	new ArrayList()	;
		HashMap		hmSQLMap			=	new HashMap()	;
		HashMap		hmResult			=	new HashMap();
		HashMap		hmRecord			=	new HashMap();
		ArrayList  alPendReqData		=	new ArrayList()	;
		//ArrayList  alDelReqData			=	new ArrayList()	; commented for unused variables by Ganga Thursday, June 27, 2013
		//Properties properties			= getProperties();
		Connection connection			= null;
        PreparedStatement pstmt			= null;
        ResultSet resultSet				= null;
		String key						= null;

		//String GroupCodeValue			= ""; commented for unused variables by Ganga Thursday, June 27, 2013
		//String ReqQtyValue				= "";
		String group_code				= "";
		String req_qty					= "";

		hmResult.put("result", new Boolean(false)) ;
		CancelRequestGroupRemote cancelRequestGroupRemote = null ;
	try {
			
				connection = getConnection();

				alModifyData.add(getLoginById()			);      
				alModifyData.add(getCancelled_remarks()	);

				alModifyData.add(getLoginById()			);      
				alModifyData.add(getLoginAtWsNo()		);    
				alModifyData.add(getLoginFacilityId()	);

				alModifyData.add(getLoginFacilityId()	);      
				alModifyData.add(getDoc_type_code()		);
				alModifyData.add(new Long (getDoc_no())	);
			
			for (int i=0;i<alCheckedItems.size(); i++) 
			{
				key = (String) alCheckedItems.get(i);
				
				StringTokenizer st = new StringTokenizer(key,"-");
				group_code = st.nextToken().trim();
				req_qty = st.nextToken().trim();
				
				hmRecord = new HashMap(); 
				hmRecord.put("request_qty",req_qty);
				hmRecord.put("request_group_code",group_code);
				hmRecord.put("req_by_store_code",getReq_by_store_code());

				hmRecord.put("facility_id",getLoginFacilityId());
				hmRecord.put("doc_type_code",getDoc_type_code()	);
				hmRecord.put("doc_no",getDoc_no());
				hmRecord.put("group_code",group_code	);

				alPendReqData.add(hmRecord);

			}
		
		hmSQLMap.put( "ModifySQL",		getSsRepositoryValue("SQL_SS_REQUEST_HDR_UPDATE_CANCEL")	);
		hmSQLMap.put( "UpdateGroupForStoreSQL",	getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_PEND_REQ_QTY_REDUCE_UPDATE"));
		hmSQLMap.put( "DeleteRequestDetailSQL",	getSsRepositoryValue("SQL_SS_REQUEST_DTL_DELETE_GROUP_CODE_WISE"));
	
		hmTableData.put( "properties",	getProperties() );
		hmTableData.put( "ModifyData",	alModifyData	);
		hmTableData.put( "alPendReqData",	alPendReqData	);
		hmTableData.put ("cancelAll",getcancelAll());

	
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_CANCEL_REQUEST_GROUP") ,CancelRequestGroupHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();

			hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


		if( ((Boolean) hmResult.get("result")).booleanValue() )	
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else if( hmResult.get("msgid")!=null  )
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("message"),"SS")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
			hmResult.put("flag", "0") ;
		}
		catch(Exception e) {
			hmResult.put("message", hmResult.get("message") + e.toString());
			e.printStackTrace() ;
		} 
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
				if(cancelRequestGroupRemote != null)
					cancelRequestGroupRemote.remove() ;
			}
			catch(Exception ee) {
				hmResult.put("message", ee.toString()) ;
			}
		}
		return hmResult;
	}

	public void loadData() throws Exception {

		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(new Long(getDoc_no()));

		HashMap hmRecord		= 	fetchRecord(getSsRepositoryValue("SQL_SS_REQUEST_HDR_SELECT_SINGLE_CANCEL"),alParameters);

		setDoc_ref(				(String) hmRecord.get("DOC_REF")			);       
		setReq_by_store_code(	(String) hmRecord.get("REQ_BY_STORE_CODE")	);
		setReq_on_store_code(	(String) hmRecord.get("REQ_ON_STORE_CODE")	);
		setEntry_completed_yn(	(String) hmRecord.get("ENTRY_COMPLETED_YN")	);
		setDoc_date(			(String) hmRecord.get("DOC_DATE")			);      
		setRequest_type(		(String) hmRecord.get("REQUEST_TYPE")		);  
		setAdded_by_id(			(String) hmRecord.get("ADDED_BY_ID")		);  
	}
} 
