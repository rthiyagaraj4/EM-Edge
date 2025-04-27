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
import java.util.StringTokenizer;
import eSS.LoanIssueGroup.*;
import eSS.Common.*;
import javax.servlet.http.HttpSession;

public class LoanIssueGroupBean extends SsTransaction implements Serializable { 

	private String doc_ref;
	private String req_doc_type_code;
	private String fr_store_code;
	private String req_doc_no;
	private String entry_completed_yn;
	private String doc_type_code;
	private String doc_date;
	private String doc_no;
	private String to_store_code;
	private HashMap hmSsParameter =null;
	private String records_to_delete;
	private HttpSession session;
			
	public void setSession(HttpSession session) {
		 this.session =  session;
	}

	public HttpSession getSession() {
		 return session;
	}

	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete =  records_to_delete;
	}

	public String getRecords_to_delete() {
		 return records_to_delete;
	}

	public void initSsParameter() throws Exception {
		hmSsParameter=getSSParameter();
	}

	public void initReq_doc_type_code() {
		req_doc_type_code=checkForNull((String)hmSsParameter.get("DEF_RQL_DOC_TYPE_CODE")) ;
	}

	public void initDoc_type_code() {
		doc_type_code=checkForNull((String)hmSsParameter.get("DEF_ISL_DOC_TYPE_CODE")) ;
	}

	public void initDoc_date() {
		doc_date=hmSsParameter.get("SYS_DATE").toString() ;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = doc_ref;
	}

	public String getDoc_ref( ) {
		 return doc_ref;
	}

	public void setReq_doc_type_code(String req_doc_type_code) {
		 this.req_doc_type_code = req_doc_type_code;
	}

	public String getReq_doc_type_code( ) {
		 return req_doc_type_code;
	}

	public void setFr_store_code(String fr_store_code) {
		 this.fr_store_code = fr_store_code;
	}

	public String getFr_store_code( ) {
		 return fr_store_code;
	}

	public void setReq_doc_no(String req_doc_no) {
		 this.req_doc_no = req_doc_no;
	}

	public String getReq_doc_no( ) {
		 return req_doc_no;
	}

	public void setEntry_completed_yn(String entry_completed_yn) {
		 this.entry_completed_yn = entry_completed_yn;
	}

	public String getEntry_completed_yn( ) {
		 return entry_completed_yn;
	}

	public void setDoc_type_code(String doc_type_code) {
		 this.doc_type_code = doc_type_code;
	}

	public String getDoc_type_code( ) {
		 return doc_type_code;
	}

	public void setDoc_date(String doc_date) {
		 this.doc_date = doc_date;
	}

	public String getDoc_date( ) {
		 return doc_date;
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no( ) {
		 return doc_no;
	}

	public void setTo_store_code(String to_store_code) {
		 this.to_store_code = to_store_code;
	}

	public String getTo_store_code( ) {
		 return to_store_code;
	}

	public String getReq_doc_type_code_List(){
		return getDoc_type_code_ListOptions("RQL",getReq_doc_type_code());
	}

	public String getDoc_type_code_List(){
		return getDoc_type_code_ListOptions("ISL",getDoc_type_code());
	}

	public String getFr_store_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(getLanguageId());
		alParam.add(login_by_id);
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_LOAN_ISSUE_STORE_SELECT_LIST"), alParam), getFr_store_code());
	}

	public String getTo_store_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(getLanguageId());

		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_LOAN_REQUEST_STORE_SELECT_LIST"), alParam), getTo_store_code());
	}


	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setDoc_ref((String) htRecordSet.get("doc_ref"));
		setReq_doc_type_code((String) htRecordSet.get("req_doc_type_code"));
		setFr_store_code((String) htRecordSet.get("fr_store_code"));
		setReq_doc_no((String) htRecordSet.get("req_doc_no"));
		setEntry_completed_yn((String) htRecordSet.get("entry_completed_yn"));
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_date(com.ehis.util.DateUtils.convertDate((String) htRecordSet.get("doc_date"),"DMY",getLanguageId(),"en"));
		setDoc_no((String) htRecordSet.get("doc_no"));
		setTo_store_code((String) htRecordSet.get("to_store_code"));
		setRecords_to_delete((String) htRecordSet.get("records_to_delete"));
	}

	public void clear(){
		super.clear();
		doc_ref="";
		req_doc_type_code="";
		fr_store_code="";
		req_doc_no="";
		entry_completed_yn="";
		doc_type_code="";
		doc_date="";
		doc_no="";
		to_store_code="";
		records_to_delete="";
		hmSsParameter =null;
	}

	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		ArrayList alLoanIssueGroupList;
		hmReturn.put(RESULT,TRUE);
		try { 
			if (!isDocNoAutoGenYN(getDoc_type_code())) {
				ArrayList alParameters	=	new ArrayList();
				alParameters.add(getLoginFacilityId());
				alParameters.add(getDoc_type_code());
				alParameters.add(new Long(getDoc_no()));
				if (!fetchRecord(getSsRepositoryValue("SQL_SS_LOAN_ISSUE_HDR_COUNT"),alParameters).get("TOTAL").toString().equals("0")) {
					throw new Exception("DUPLICATE_DOC_NO");
				}
			}
			
			int iValidDocDate	=	isValidDocDate(getDoc_date());
			switch (iValidDocDate){
				case 1:
					throw new Exception("DOC_DT_NOT_LT_PROC_MTH");
				case 2:
					throw new Exception("DOC_DT_NOT_GR_SYSDATE");
			}
						
			alLoanIssueGroupList	=	(ArrayList)session.getAttribute("alLoanIssueGroupList");
			
			if((alLoanIssueGroupList.size()==0)||(getRecords_to_delete().indexOf("N")==-1)){
				throw new Exception("MIN_ONE_DETAIL_REQUIRED");
			}
		}
		catch (Exception exception) {
			hmReturn.put(RESULT,FALSE);
			hmReturn.put(MSGID,exception.getMessage());
			hmReturn.put(MESSAGE,exception.toString());
		}
		
		return hmReturn;
	}
	public HashMap insert(){

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrInsertData		=	new ArrayList()	;
		ArrayList	alDtlInsertData		=	new ArrayList()	;
		ArrayList	alLoanIssueGroupList	=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		 
		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");
		try { 

			if (isDocNoAutoGenYN(getDoc_type_code())) {
				setDoc_no(fetchNextDocNo(getDoc_type_code()));
			}
			alHdrInsertData.add(getLoginFacilityId()    );
			alHdrInsertData.add(getDoc_type_code()      );
			alHdrInsertData.add(new Long (getDoc_no())	);
			alHdrInsertData.add(getDoc_date()			);
			alHdrInsertData.add(getFr_store_code()      );
			alHdrInsertData.add(getTo_store_code()      );
			alHdrInsertData.add(getDoc_ref()			);
			alHdrInsertData.add(getReq_doc_type_code()	);
			alHdrInsertData.add(getReq_doc_no());
		
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());

			if(getAckReqd()){
			alHdrInsertData.add("Y");
			}else{
			alHdrInsertData.add("N");
			}

			alLoanIssueGroupList	=	(ArrayList)session.getAttribute("alLoanIssueGroupList");

			for (int i=0;i<alLoanIssueGroupList.size() ;i++ ) {
				if(stRecordsToDel.nextToken().equals("N")){
					alDtlInsertData.add((HashMap)alLoanIssueGroupList.get(i));		
				}
			}			 

			hmSQLMap.put( "HdrInsertSQL",		getSsRepositoryValue("SQL_SS_LOAN_ISSUE_HDR_INSERT")				);
			hmSQLMap.put( "DtlInsertSQL",		getSsRepositoryValue("SQL_SS_LOAN_ISSUE_DTL_INSERT")				);
			hmSQLMap.put( "DtlQtyLeftSQL",		getSsRepositoryValue("SQL_SS_LOAN_REQUEST_DTL_LEFT_QTY")			);			
			hmSQLMap.put( "DtlTrayNotIssuedSQL",getSsRepositoryValue("SQL_SS_TRAY_DTLS_COUNT_NOT_LOAN_ISSUED")	);
			hmSQLMap.put( "NextDocNoUpdateSQL",	getSsRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")	);
			hmSQLMap.put( "GroupForStoreUpdForPendingReqSQL",	getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_PEND_REQ_QTY_REDUCE_UPDATE")	);
			
			hmSQLMap.put( "DtlTrayIssuedCountSQL",getSsRepositoryValue("SQL_SS_LOAN_ISSUE_DTL_COUNT_SELECT"));			
			hmSQLMap.put( "DtlTrayBlockedQtyUpdateSQL",getSsRepositoryValue("SQL_SS_LOAN_REQUEST_DTL_UPDATE_FOR_BLOCKED_QTY"));			
			hmSQLMap.put( "GroupForStoreUpdForPendingAckSQL",	getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_PEND_ACK")	);		


			hmTableData.put( "isDocNoAutoGenYN",	new Boolean(isDocNoAutoGenYN(getDoc_type_code())) );
			hmTableData.put( "properties",			getProperties() );
			hmTableData.put( "HdrInsertData",		alHdrInsertData	);
			hmTableData.put( "DtlInsertData",		alDtlInsertData	);
			
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return LoanIssueGroupMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}


	/*There is no use of this method
	public HashMap modify(){ 

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrModifyData		=	new ArrayList()	;
		ArrayList	alDtlModifyInsertData		=	new ArrayList()	;
		ArrayList	alLoanIssueGroupList	=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		ArrayList alCommonData		=	new ArrayList();

		alCommonData.add(getReq_doc_no());
		alCommonData.add(getReq_doc_type_code());
		alCommonData.add(getTo_store_code());
		
		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");
		try { 

				alHdrModifyData.add(getLoginById());      
				alHdrModifyData.add(getLoginAtWsNo());    
				alHdrModifyData.add(getLoginFacilityId());
				//if(getAckReqd()){
				//alHdrModifyData.add("Y");
				//}else{
				alHdrModifyData.add("N");
				//}
				alHdrModifyData.add(getLoginFacilityId()    );
				alHdrModifyData.add(getDoc_type_code()      );
				alHdrModifyData.add(new Long (getDoc_no().trim())	);

			

			alLoanIssueGroupList	=	(ArrayList)session.getAttribute("alLoanIssueGroupList");

			for (int i=0;i<alLoanIssueGroupList.size() ;i++ ) {
				if(stRecordsToDel.nextToken().equals("N")){
					alDtlModifyInsertData.add((HashMap)alLoanIssueGroupList.get(i));		
				}
			}			 

			hmSQLMap.put( "HdrUpdateSQL",		getSsRepositoryValue("SQL_SS_ISSUE_HDR_UPDATE")				);
			hmSQLMap.put( "DtlInsertSQL",		getSsRepositoryValue("SQL_SS_ISSUE_DTL_INSERT_FOR_RE_ISSUE")				);
			hmSQLMap.put( "DtlQtyLeftSQL",		getSsRepositoryValue("SQL_SS_REQUEST_DTL_LEFT_QTY")			);
			hmSQLMap.put( "DtlTrayNotIssuedSQL",getSsRepositoryValue("SQL_SS_TRAY_DTLS_COUNT_NOT_ISSUED")	);
			hmSQLMap.put( "DtlTrayIssuedCountSQL",getSsRepositoryValue("SQL_SS_ISSUE_DTL_COUNT_SELECT_FOR_RE_ISSUE"));
			//hmSQLMap.put( "DtlTrayIssuedQtyUpdateSQL",getSsRepositoryValue("SQL_SS_ISSUE_DTL_UPDATE"));
			hmSQLMap.put( "DtlTrayBlockedQtyUpdateSQL",getSsRepositoryValue("SQL_SS_ISSUE_DTL_UPDATE_FOR_BLOCKED_QTY_FOR_RE_ISSUE"));
			hmSQLMap.put( "DtlUpdateSQL",		getSsRepositoryValue("SQL_SS_ISSUE_DTL_UPDATE_FOR_RE_ISSUE")				);
			hmSQLMap.put( "GroupForStoreUpdForPendingAckSQL",	getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_PEND_ACK")	);
			hmSQLMap.put( "GroupForStoreUpdForPendingReqSQL",	getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_PEND_REQ_QTY_REDUCE_UPDATE")	);


			hmTableData.put( "properties",			getProperties() );
			hmTableData.put( "HdrModifyData",		alHdrModifyData	);
			hmTableData.put( "DtlModifyInsertData",		alDtlModifyInsertData	);
			hmTableData.put("COMMON_DATA",	alCommonData);

			
		}
		catch (Exception exception) {
			exception.printStackTrace();
			System.err.println("hmTableData in modify"+hmTableData);

		}

		return LoanIssueGroupMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}*/

	public HashMap LoanIssueGroupMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_LOAN_ISSUE_GROUP"),LoanIssueGroupHome.class,getLocalEJB());
			
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();			

			switch (functionID)
			{
				case FUNCTION_INSERT:
				      hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			          (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					break;
				
				case FUNCTION_UPDATE:
					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			        (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					break;
				
				case FUNCTION_DELETE:
					hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
			        (busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					break;				
				default:
					hmResult.put( "message", "Invalid Function ID passed to LoanIssueGroupMethodCall()") ;
			}

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			else if( hmResult.get("msgid")!=null  )
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;

		}
		catch(Exception exception) {
			System.err.println( "Error Calling Issue Group EJB : "+exception) ;
			hmResult.put( "message", "Bean 383: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		}

		/*if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (isInternalRequest("SS","SSBISSLS")) {
				doOnlineReportPrinting();				
			}
		}*/

		return hmResult;
	
	}

	/*public Boolean getAckReqd(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT ISL_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("ISS_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}

		public void loadData() throws Exception {

		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(new Long(getDoc_no()));

		HashMap hmRecord		= 	fetchRecord(getSsRepositoryValue("SQL_SS_ISSUE_HDR_SELECT_SINGLE"),alParameters);

		setDoc_ref(				(String) hmRecord.get("DOC_REF")			);      
		setFr_store_code(	(String) hmRecord.get("FR_STORE_CODE")	);
		setTo_store_code(	(String) hmRecord.get("TO_STORE_CODE")	);
		setDoc_date(			(String) hmRecord.get("DOC_DATE")			);      
		
	}*/
	
		//Added by Sakti against BRU-HIMS-CRF-375
		public String getTrayNo(String issue_group_code,String fr_store_code,String dflt_value) {
			String optionValues = null;
			ArrayList <String> alOptionValues = new ArrayList<String>();
			ArrayList alParam = new ArrayList();
			alParam.add(issue_group_code);
			alParam.add(fr_store_code);			
			alOptionValues = getListOptionArrayList(getSsRepositoryValue("SQL_SS_ISSUE_GROUP_TRAY_SELECT_LIST_FOR_LOAN"), alParam,true);
			optionValues = getListOptionTag(alOptionValues,dflt_value);
							
			return optionValues;			
		}
		
		public ArrayList getTrayNoArrayList(String issue_group_code,String fr_store_code) throws Exception{ 
			ArrayList <String> arraylist = new ArrayList<String>();
	        arraylist.add(issue_group_code);
	        arraylist.add(fr_store_code);
			return fetchRecords(getSsRepositoryValue("SQL_SS_ISSUE_GROUP_TRAY_SELECT_LIST_FOR_LOAN"), arraylist);
		}//Added ends

		public Boolean getAckReqd(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT ISL_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("ISL_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}
} 
