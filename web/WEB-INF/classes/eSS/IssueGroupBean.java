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
04/07/2022				TFS31754 				Shazana														ML-MMOH-CRF-1829  
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eSS;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;
import eSS.Common.SsTransaction;
import eSS.IssueGroup.*;
import eSS.Common.*;
import javax.servlet.http.HttpSession;

public class IssueGroupBean extends SsTransaction implements Serializable { 

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

	private ArrayList selectedList  = new ArrayList();
	private ArrayList ModifySelectedList = new ArrayList();
	//private ArrayList DataList=new ArrayList(); //Comented by sakti as this is unused against inc#48061  
	private HashMap dataList = new HashMap();
	
	private ArrayList alSelectedDetails = new ArrayList();
	private ArrayList alModifyRecord = new ArrayList();
	private ArrayList alExistGroups;
			
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
		req_doc_type_code=checkForNull((String)hmSsParameter.get("DEF_REQ_DOC_TYPE_CODE")) ;
	}

	public void initDoc_type_code() {
		doc_type_code=checkForNull((String)hmSsParameter.get("DEF_ISS_DOC_TYPE_CODE")) ;
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
		return getDoc_type_code_ListOptions("REQ",getReq_doc_type_code());
	}

	public String getDoc_type_code_List(){
		return getDoc_type_code_ListOptions("ISS",getDoc_type_code());
	}

	public String getFr_store_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_ISS_SELECT_LIST"), alParam), getFr_store_code());
	}

	public String getTo_store_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);

		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_REQ_SELECT_LIST"), alParam), getTo_store_code());
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

	//Added by Sakti against BRU-HIMS-CRF-375 for Re-Issue

	public ArrayList getSelectedList(){
		return selectedList ;
	}
	public void setSelectedList(ArrayList selectedList){
		this.selectedList = selectedList;
	}
	
	public ArrayList getModifySelectedList(){
		return ModifySelectedList ;
	}
	public void setModifySelectedList(ArrayList ModifySelectedList){
		this.ModifySelectedList = ModifySelectedList;
	}
	
public void setnewalGroupRecords(String group_code){
		
		alExistGroups.add(group_code);
	}

public ArrayList getnewalGroupRecords(){
	
	return alExistGroups;
}


	public void selectedBatches(Hashtable htTrays){
					
			int i=0;
			StringTokenizer st=new StringTokenizer ((String)htTrays.get("index"),"!");
			while(st.hasMoreTokens()) 
			{
				i=Integer.parseInt(st.nextToken());
				
							
				dataList = new HashMap();
				dataList.put("issue_group_code",(String)htTrays.get("group"+i));
				dataList.put("issue_group_desc",(String)htTrays.get("desc"+i));
				dataList.put("req_group_code",(String)htTrays.get("group"+i));
				dataList.put("req_group_desc",(String)htTrays.get("desc"+i));
				dataList.put("auth_group_code",(String)htTrays.get("group"+i));
				dataList.put("auth_group_desc",(String)htTrays.get("desc"+i));
				dataList.put("patient_name","");
				dataList.put("bin_location_desc","");
				dataList.put("expiry_date",""); 
				dataList.put("patient_id","");
				dataList.put("tray_no","");
				dataList.put("issue_cost","");
				dataList.put("sterile_cost","");  
				dataList.put("packing_cost","");  
				dataList.put("consumables_cost","");
				dataList.put("non_consumables_cost","");
				//dataList.put("new_mode",(String)htTrays.get("new_mode"+i));
				dataList.put("mode","1");
						
				//if (! isAlreadySelected((String)htTrays.get("group"+i)) ) {
			
					selectedList.add(dataList);
					alSelectedDetails.add((String)htTrays.get("group"+i));
				//}
								
			}
			
				
						
			int j=0;
			StringTokenizer ss=new StringTokenizer ((String)htTrays.get("unchecked_index"),"!");
			
			while(ss.hasMoreTokens()) 
			{
				j=Integer.parseInt(ss.nextToken());
												
				dataList = new HashMap();
				
				dataList.put("issue_group_code",(String)htTrays.get("group"+j));
				dataList.put("issue_group_desc",(String)htTrays.get("desc"+j));
				dataList.put("req_group_code",(String)htTrays.get("group"+j));
				dataList.put("req_group_desc",(String)htTrays.get("desc"+j));
				dataList.put("auth_group_code",(String)htTrays.get("group"+j));
				dataList.put("auth_group_desc",(String)htTrays.get("desc"+j));
				dataList.put("patient_name","");
				dataList.put("bin_location_desc","");
				dataList.put("expiry_date","");
				dataList.put("patient_id","");
				dataList.put("tray_no","");
				dataList.put("issue_cost","");
				dataList.put("sterile_cost","");  
				dataList.put("packing_cost","");  
				dataList.put("consumables_cost","");
				dataList.put("non_consumables_cost","");
				dataList.put("mode","1");
				
				
				alSelectedDetails.remove((String)htTrays.get("group"+j)); 
				
				selectedList.remove(dataList);
				
			}
			

	}
	
	public void setAlSelectedTrayDetails(String group_code){
		
		alSelectedDetails.add(group_code);
	}
	
		public ArrayList getAlSelectedTrayDetails() { 
			return alSelectedDetails;
		}

		public boolean isAlreadySelected(String groupCode_desc) {
			return alSelectedDetails.contains(groupCode_desc);
		}
		
		public boolean isModifyRecord(String groupCode_groupDesc) {
			return alModifyRecord.contains(groupCode_groupDesc);
		}
		//Added ends

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

		if (selectedList!=null) {
			selectedList.clear();
		}
		if (alSelectedDetails!=null) {
			alSelectedDetails.clear();
		}
		if (alModifyRecord!=null) {
			alModifyRecord.clear();
		}
		
		if (alExistGroups!=null) {
			alExistGroups.clear();
		}
	}

	public void initialize(){
		super.initialize();
		selectedList=new ArrayList();
		alSelectedDetails = new ArrayList();
		alModifyRecord = new ArrayList();
		alExistGroups = new ArrayList();
	}

	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		ArrayList alIssueGroupList;
		hmReturn.put(RESULT,TRUE);
		try { 
			if (!isDocNoAutoGenYN(getDoc_type_code())) {
				ArrayList alParameters	=	new ArrayList();
				alParameters.add(getLoginFacilityId());
				alParameters.add(getDoc_type_code());
				alParameters.add(new Long(getDoc_no()));
				if (!fetchRecord(getSsRepositoryValue("SQL_SS_ISSUE_HDR_COUNT"),alParameters).get("TOTAL").toString().equals("0")) {
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
			alIssueGroupList	=	(ArrayList)session.getAttribute("alIssueGroupList");
			if((alIssueGroupList.size()==0)||(getRecords_to_delete().indexOf("N")==-1)){
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
		ArrayList	alIssueGroupList	=	null			;
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

			alIssueGroupList	=	(ArrayList)session.getAttribute("alIssueGroupList");

			for (int i=0;i<alIssueGroupList.size() ;i++ ) {
				if(stRecordsToDel.nextToken().equals("N")){
					alDtlInsertData.add((HashMap)alIssueGroupList.get(i));		
				}
			}
			 

			hmSQLMap.put( "HdrInsertSQL",		getSsRepositoryValue("SQL_SS_ISSUE_HDR_INSERT")				);
			hmSQLMap.put( "DtlInsertSQL",		getSsRepositoryValue("SQL_SS_ISSUE_DTL_INSERT")				);
			hmSQLMap.put( "DtlQtyLeftSQL",		getSsRepositoryValue("SQL_SS_REQUEST_DTL_LEFT_QTY")			);
			hmSQLMap.put( "DtlTrayNotIssuedSQL",getSsRepositoryValue("SQL_SS_TRAY_DTLS_COUNT_NOT_ISSUED")	);
			hmSQLMap.put( "DtlTrayIssuedCountSQL",getSsRepositoryValue("SQL_SS_ISSUE_DTL_COUNT_SELECT"));
			//hmSQLMap.put( "DtlTrayIssuedQtyUpdateSQL",getSsRepositoryValue("SQL_SS_ISSUE_DTL_UPDATE"));
			hmSQLMap.put( "DtlTrayBlockedQtyUpdateSQL",getSsRepositoryValue("SQL_SS_ISSUE_DTL_UPDATE_FOR_BLOCKED_QTY"));
			hmSQLMap.put( "NextDocNoUpdateSQL",	getSsRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")	);
			hmSQLMap.put( "GroupForStoreUpdForPendingAckSQL",	getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_PEND_ACK")	);
			hmSQLMap.put( "GroupForStoreUpdForPendingReqSQL",	getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_PEND_REQ_QTY_REDUCE_UPDATE")	);


			hmTableData.put( "isDocNoAutoGenYN",	new Boolean(isDocNoAutoGenYN(getDoc_type_code())) );
			hmTableData.put( "properties",			getProperties() );
			hmTableData.put( "HdrInsertData",		alHdrInsertData	);
			hmTableData.put( "DtlInsertData",		alDtlInsertData	);
			
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return issueGroupMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}



	public HashMap modify(){

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrModifyData		=	new ArrayList()	;
		ArrayList	alDtlModifyInsertData		=	new ArrayList()	;
		ArrayList	alIssueGroupList	=	null			;
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
				if(getAckReqd()){
				alHdrModifyData.add("Y");
				}else{
				alHdrModifyData.add("N");
				}
				alHdrModifyData.add(getLoginFacilityId()    );
				alHdrModifyData.add(getDoc_type_code()      );
				alHdrModifyData.add(new Long (getDoc_no().trim())	);

			

			alIssueGroupList	=	(ArrayList)session.getAttribute("alIssueGroupList");

			for (int i=0;i<alIssueGroupList.size() ;i++ ) {
				if(stRecordsToDel.nextToken().equals("N")){
					alDtlModifyInsertData.add((HashMap)alIssueGroupList.get(i));		
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
			//hmSQLMap.put( "NextDocNoUpdateSQL",	getSsRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")	);
			hmSQLMap.put( "GroupForStoreUpdForPendingAckSQL",	getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_UPDATE_FOR_PEND_ACK")	);
			hmSQLMap.put( "GroupForStoreUpdForPendingReqSQL",	getSsRepositoryValue("SQL_SS_GROUP_FOR_STORE_PEND_REQ_QTY_REDUCE_UPDATE")	);


			//hmTableData.put( "isDocNoAutoGenYN",	new Boolean(isDocNoAutoGenYN(getDoc_type_code())) );
			hmTableData.put( "properties",			getProperties() );
			hmTableData.put( "HdrModifyData",		alHdrModifyData	);
			hmTableData.put( "DtlModifyInsertData",		alDtlModifyInsertData	);
			hmTableData.put("COMMON_DATA",	alCommonData);

			
		}
		catch (Exception exception) {
			exception.printStackTrace();
			System.err.println("hmTableData in modify"+hmTableData);

		}

		return issueGroupMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public HashMap issueGroupMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
		HashMap		hmResult	=	new HashMap()	;
		//IssueGroupRemote	issueGroupRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(SsRepository.getSsKeyValue("JNDI_SS_ISSUE_GROUP"),IssueGroupHome.class,getLocalEJB());
			
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
					hmResult.put( "message", "Invalid Function ID passed to issueGroupMethodCall()") ;
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
			/*finally {
			try {
				if( issueGroupRemote != null )
					issueGroupRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", "Bean 393: "+exception.toString()) ;
			}
		}*/

		if (hmResult.get("result") != null && (((Boolean)hmResult.get("result")).booleanValue())) {
			if (isInternalRequest("SS","SSBISSLS")) {
				doOnlineReportPrinting();				
			}
		}

		return hmResult;
	
	}

/*For online report*/

	public void doOnlineReportPrinting() {
		try{
			
		/*	ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports() ;
			String reportid = "SSBISSLS";
			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "SS", reportid,"L", "1");
			reportParam.addParameter("p_module_id","SS");
			reportParam.addParameter("p_report_id",reportid);
			reportParam.addParameter("p_user_name",getLoginById());
			reportParam.addParameter("p_facility_id",getLoginFacilityId());
			reportParam.addParameter("p_request_type","A");

			reportParam.addParameter("p_fm_doc_type_code",getDoc_type_code());
			reportParam.addParameter("p_to_doc_type_code",getDoc_type_code());

			reportParam.addParameter("p_fm_doc_no",getDoc_no());
			reportParam.addParameter("p_to_doc_no",getDoc_no());


			onlineReports.add(reportParam) ;
			String ReportOutput = onlineReports.execute( request, response);
			*/
		}
		catch ( Exception exception) {
			
			exception.printStackTrace();
			return;
		}
	}

	public Boolean getAckReqd(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT ISS_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("ISS_ACK_REQ_YN");
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
		
	}

			//Added by Sakti against BRU-HIMS-CRF-375
		public String getTrayNo(String issue_group_code,String fr_store_code,String dflt_value) {
			

			String optionValues = null;
			ArrayList alOptionValues = new ArrayList();
			ArrayList alParam = new ArrayList();

			alParam.add(issue_group_code);
			alParam.add(fr_store_code);
						
			alOptionValues = getListOptionArrayList(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ISSUE_GROUP_TRAY_SELECT_LIST"), alParam,true);
			
			optionValues = getListOptionTag(alOptionValues,dflt_value);
							
			return optionValues; 
			
		}
		
		public ArrayList getTrayNoArrayList(String issue_group_code,String fr_store_code) throws Exception{  
			ArrayList arraylist = new ArrayList();
	        arraylist.add(issue_group_code);
	        arraylist.add(fr_store_code);
			
			return fetchRecords(eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ISSUE_GROUP_TRAY_SELECT_LIST"),arraylist);
		}
		public String getGroupType(){
			return getStaticListOptionTag( "A,All;T,Tray;E,Set;P,Soft Pack;S,Single;");
		}//Added ends

		//ML-MMOH-CRF-1829 START 
		public ArrayList getGroupTypeList(String doc_no) {  
			Connection connection = null ;
			PreparedStatement pstmt = null ;  
			ResultSet resultSet = null ;
			ArrayList result=new ArrayList();
			try {
				connection = getConnection() ;
				pstmt = connection.prepareStatement("select SHORT_DESC from ss_group where group_code in (select REQ_GROUP_CODE from ss_request_dtl where DOC_NO = ?)");
				pstmt.setString(1,doc_no);
				resultSet = pstmt.executeQuery() ;			

				while (resultSet!=null && resultSet.next()) {
					result.add(resultSet.getString("SHORT_DESC")==null?"":resultSet.getString("SHORT_DESC"));
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
		  
			return result;
		}
		//ML-MMOH-CRF-1829 END 
} 
