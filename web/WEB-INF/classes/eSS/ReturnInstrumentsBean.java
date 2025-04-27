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
import javax.servlet.http.HttpSession;
import java.util.*;

import eSS.ReturnInstruments.*;

public class ReturnInstrumentsBean extends eSS.Common.SsTransaction implements Serializable { 

	private String doc_ref;
	private String patient_id;
	private String authorized_by_id;
	private String doc_type_code;
	private String doc_date;
	private HttpSession session;
	private String patient_name;
	private String doc_no;
	private String finalized_yn;
	private String rec_store_code;
	private String ret_store_code;
	private String added_by_id;
	private HashMap hmSsParameter =null;
	private String records_to_delete;
	private String entry_completed_yn;
			
	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete =  records_to_delete;
	}

	public String getRecords_to_delete() {
		 return records_to_delete;
	}

	public void initSsParameter() throws Exception {
		hmSsParameter=getSSParameter();
	}

	public void initDoc_type_code() {
		doc_type_code=checkForNull((String)hmSsParameter.get("DEF_RTI_DOC_TYPE_CODE")) ;
	}

	public void initDoc_date() {
		doc_date=hmSsParameter.get("SYS_DATE").toString() ;
	}

	public String getDoc_type_code_List(){
		return getDoc_type_code_ListOptions("RTI",getDoc_type_code());
	}

	public String getRec_store_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_RTI_SELECT_LIST"), alParam), getRec_store_code());
	}

	public String getRet_store_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_RTG_SELECT_LIST"),alParam), getRet_store_code());
	}

	public void setEntry_completed_yn(String entry_completed_yn) {
		 this.entry_completed_yn = checkForNull(entry_completed_yn,"N");
	}

	public String getEntry_completed_yn() {
		 return entry_completed_yn;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = checkForNull(doc_ref);
	}

	public String getDoc_ref( ) {
		 return doc_ref;
	}

	public void setPatient_id(String patient_id) {
		 this.patient_id = checkForNull(patient_id);
	}

	public String getPatient_id( ) {
		 return patient_id;
	}

	public void setAuthorized_by_id(String authorized_by_id) {
		 this.authorized_by_id = authorized_by_id;
	}

	public String getAuthorized_by_id( ) {
		 return authorized_by_id;
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

	public void setSession(HttpSession session) {
		 this.session = session;
	}

	public HttpSession getSession( ) {
		 return session;
	}

	public void setPatient_name(String patient_name) {
		 this.patient_name = checkForNull(patient_name);
	}

	public String getPatient_name( ) {
		 return patient_name;
	}

	public void setDoc_no(String doc_no) {
		 this.doc_no = doc_no;
	}

	public String getDoc_no( ) {
		 return doc_no;
	}

	public void setFinalized_yn(String finalized_yn) {
		 this.finalized_yn = finalized_yn;
	}

	public String getFinalized_yn( ) {
		 return finalized_yn;
	}

	public void setRec_store_code(String rec_store_code) {
		 this.rec_store_code = rec_store_code;
	}

	public String getRec_store_code() {
		 return rec_store_code;
	}

	public void setRet_store_code(String ret_store_code) {
		 this.ret_store_code = ret_store_code;
	}

	public String getRet_store_code( ) {
		 return ret_store_code;
	}

	public void setAdded_by_id(String added_by_id) {
		 this.added_by_id = added_by_id;
	}

	public String getAdded_by_id( ) {
		 return added_by_id;
	}

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setDoc_ref((String) htRecordSet.get("doc_ref"));
		setPatient_id((String) htRecordSet.get("patient_id"));
		setAuthorized_by_id((String) htRecordSet.get("authorized_by_id"));
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_date((String) htRecordSet.get("doc_date"));
		setPatient_name((String) htRecordSet.get("patient_name"));
		setDoc_no((String) htRecordSet.get("doc_no"));
		setFinalized_yn((String) htRecordSet.get("finalized_yn"));
		setRec_store_code((String) htRecordSet.get("rec_store_code")) ;
		setRet_store_code((String) htRecordSet.get("ret_store_code")) ;
		setAdded_by_id((String) htRecordSet.get("added_by_id"));
		setEntry_completed_yn((String) htRecordSet.get("entry_completed_yn"));
		setRecords_to_delete((String) htRecordSet.get("records_to_delete"));
	}

	public void clear(){
		super.clear();
		doc_ref="";
		patient_id="";
		authorized_by_id="";
		doc_type_code="";
		doc_date="";
		session=null;
		patient_name="";
		doc_no="";
		finalized_yn="";
		rec_store_code="";
		ret_store_code="";
		added_by_id="";
		records_to_delete="";
		entry_completed_yn="";
	}
	
	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		ArrayList alReturnInstrumentsList;
		hmReturn.put(RESULT,TRUE);
		if (getMode().equals(getCommonRepositoryValue("MODE_DELETE"))) {
			return hmReturn;
		}
		try { 
			if (!isDocNoAutoGenYN(getDoc_type_code())) {
				ArrayList alParameters	=	new ArrayList();
				alParameters.add(getLoginFacilityId());
				alParameters.add(getDoc_type_code());
				alParameters.add(new Long(getDoc_no()));
				if (!fetchRecord(getSsRepositoryValue("SQL_SS_RET_ITEM_HDR_COUNT"),alParameters).get("TOTAL").toString().equals("0")) {
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
			

			alReturnInstrumentsList	=	(ArrayList)session.getAttribute("alReturnInstrumentsList");
			if((alReturnInstrumentsList.size()==0)||(getRecords_to_delete().indexOf("N")==-1)){
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
		ArrayList	alReturnInstrumentsList	=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");
		try { 
			if (isDocNoAutoGenYN(getDoc_type_code())) {
				setDoc_no(fetchNextDocNo(getDoc_type_code()));
			}
			alHdrInsertData.add(getLoginFacilityId()        );
			alHdrInsertData.add(getDoc_type_code()          );
			alHdrInsertData.add(new Long (getDoc_no())	    );
			alHdrInsertData.add(getDoc_date()				);
			alHdrInsertData.add(getDoc_ref()				);
			alHdrInsertData.add(getRec_store_code()      );
			alHdrInsertData.add(getPatient_id()      );
			alHdrInsertData.add(getEntry_completed_yn()		);
			alHdrInsertData.add(getFinalized_yn()           );
			alHdrInsertData.add(getRet_store_code()         );
							  
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());

			alReturnInstrumentsList	=	(ArrayList)session.getAttribute("alReturnInstrumentsList");

			for (int i=0;i<alReturnInstrumentsList.size() ;i++ ) {
				if(stRecordsToDel.nextToken().equals("N")){
					alDtlInsertData.add((HashMap)alReturnInstrumentsList.get(i));		
				}
			}
			
			hmSQLMap.put( "HdrInsertSQL",		getSsRepositoryValue("SQL_SS_RET_ITEM_HDR_INSERT")			);
			hmSQLMap.put( "DtlInsertSQL",		getSsRepositoryValue("SQL_SS_RET_ITEM_DTL_INSERT")			);
			hmSQLMap.put( "NextDocNoUpdateSQL",	getSsRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")	);

			hmTableData.put( "isDocNoAutoGenYN",	new Boolean(isDocNoAutoGenYN(getDoc_type_code())) );
			hmTableData.put( "properties",			getProperties() );
			hmTableData.put( "HdrInsertData",		alHdrInsertData	);
			hmTableData.put( "DtlInsertData",		alDtlInsertData	);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return returnInstrumentsMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}
	
	public HashMap modify() {

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrModifyData		=	new ArrayList()	;
		ArrayList	alDtlModifyData		=	new ArrayList()	;
		ArrayList	alReturnInstrumentsList			=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");

		alHdrModifyData.add(getDoc_date()			);
		alHdrModifyData.add(getDoc_ref()			);
		alHdrModifyData.add(getRec_store_code()		);
		alHdrModifyData.add(getPatient_id()			);
		alHdrModifyData.add(getEntry_completed_yn()	);
		alHdrModifyData.add(getFinalized_yn()       );

		alHdrModifyData.add(getLoginById());      
		alHdrModifyData.add(getLoginAtWsNo());    
		alHdrModifyData.add(getLoginFacilityId());

		alHdrModifyData.add(getLoginFacilityId());      
		alHdrModifyData.add(getDoc_type_code()          );
		alHdrModifyData.add(new Long (getDoc_no())	    );

		alReturnInstrumentsList	=	(ArrayList)session.getAttribute("alReturnInstrumentsList");

		for (int i=0;i<alReturnInstrumentsList.size() ;i++ ) {
			HashMap hmRecord	=	(HashMap)alReturnInstrumentsList.get(i);
			if(stRecordsToDel.nextToken().equals("Y")){
				if( hmRecord.get("mode").toString().equals(getCommonRepositoryValue("MODE_INSERT"))) 
					continue;
				else
					hmRecord.put("mode",getCommonRepositoryValue("MODE_DELETE"));
			}
			alDtlModifyData.add(hmRecord);		
		}
		

		hmSQLMap.put( "HdrModifySQL", getSsRepositoryValue("SQL_SS_RET_ITEM_HDR_UPDATE")	);
		hmSQLMap.put( "DtlModifySQL", getSsRepositoryValue("SQL_SS_RET_ITEM_DTL_UPDATE")		);
		hmSQLMap.put( "DtlInsertSQL", getSsRepositoryValue("SQL_SS_RET_ITEM_DTL_INSERT")		);
		hmSQLMap.put( "DtlInsertSQL", getSsRepositoryValue("SQL_SS_RET_ITEM_DTL_DELETE")		);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "HdrModifyData",		alHdrModifyData	);
		hmTableData.put( "DtlModifyData",		alDtlModifyData	);

		return returnInstrumentsMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public HashMap delete(){
		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alDeleteData		=	new ArrayList()	;
		HashMap		hmSQLMap			=	new HashMap()	;

		alDeleteData.add(getLoginFacilityId()        );
		alDeleteData.add(getDoc_type_code()          );
		alDeleteData.add(new Long (getDoc_no())		 );

		hmSQLMap.put( "HdrDeleteSQL", getSsRepositoryValue("SQL_SS_RET_ITEM_HDR_DELETE")	);
		hmSQLMap.put( "DtlDeleteSQL", getSsRepositoryValue("SQL_SS_RET_ITEM_DTL_DELETE_GROUP")	);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "DeleteData",			alDeleteData	);

		return returnInstrumentsMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE);
	}

	public HashMap returnInstrumentsMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){

		HashMap		hmResult	=	new HashMap()	;
		ReturnInstrumentsRemote	returnInstrumentsRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_RETURN_INSTRUMENTS") ,ReturnInstrumentsHome.class,getLocalEJB());

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
			try{
			switch (functionID)
			{
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
					hmResult.put( "message", "Invalid Function ID passed to returnInstrumentsMethodCall()") ;
			}
			}
			catch (Exception exception) {
				System.out.println("exception====in 471 bean =>"+exception.getMessage());
			exception.printStackTrace();
			}
		
			if( ((Boolean) hmResult.get("result")).booleanValue() )	
					hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;

			else if( hmResult.get("msgid")!=null  )
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			else
			hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		} 
		catch(Exception exception) {
			System.err.println( "Error Calling Return Instruments EJB : "+exception.getMessage()) ;
			hmResult.put( "message", "Bean 383: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( returnInstrumentsRemote != null )
					returnInstrumentsRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", "Bean 393: "+exception.toString()) ;
			}
		}

		

		return hmResult;
	}

	public void loadData() throws Exception {

		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(new Long(getDoc_no()));

		HashMap hmRecord		= 	fetchRecord(getSsRepositoryValue("SQL_SS_RET_ITEM_HDR_SELECT_SINGLE"),alParameters);

		setDoc_date(			(String) hmRecord.get("DOC_DATE")			);      
		setDoc_ref(				(String) hmRecord.get("DOC_REF")			);       
		setRec_store_code(		(String) hmRecord.get("REC_STORE_CODE")	);
		setRet_store_code(		(String) hmRecord.get("RET_STORE_CODE")	);
		setEntry_completed_yn(	(String) hmRecord.get("ENTRY_COMPLETED_YN")	);
		setPatient_id(			(String) hmRecord.get("PATIENT_ID")		);  
		setPatient_name(		(String) hmRecord.get("PATIENT_NAME")		);  
	}

	public void doOnlineReportPrinting() {
		try{
			{			
			ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports() ;
			String reportid = "SSBRTIST";
			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "SS", reportid,"L", "1");
			reportParam.addParameter("p_module_id","SS");
			reportParam.addParameter("p_report_id",reportid);
			reportParam.addParameter("p_user_name",getLoginById());
			reportParam.addParameter("p_facility_id",getLoginFacilityId());

			reportParam.addParameter("p_from_doc_type",getDoc_type_code());
			reportParam.addParameter("p_to_doc_type",getDoc_type_code());

			reportParam.addParameter("p_from_doc_no",getDoc_no());
			reportParam.addParameter("p_to_doc_no",getDoc_no());


			onlineReports.add(reportParam) ;
			
			}
			{			
			ecis.utils.OnlineReports onlineReports = new ecis.utils.OnlineReports() ;
			String reportid = "SSBRTIPT";
			ecis.utils.OnlineReport reportParam= new ecis.utils.OnlineReport( getLoginFacilityId(), "SS", reportid,"L", "1");
			reportParam.addParameter("p_module_id","SS");
			reportParam.addParameter("p_report_id",reportid);
			reportParam.addParameter("p_user_name",getLoginById());
			reportParam.addParameter("p_facility_id",getLoginFacilityId());

			reportParam.addParameter("p_from_doc_type",getDoc_type_code());
			reportParam.addParameter("p_to_doc_type",getDoc_type_code());

			reportParam.addParameter("p_from_doc_no",getDoc_no());
			reportParam.addParameter("p_to_doc_no",getDoc_no());


			onlineReports.add(reportParam) ;
			}
		}
		catch ( Exception exception) {
			exception.printStackTrace();
			return;
		}
	} 
	
}
