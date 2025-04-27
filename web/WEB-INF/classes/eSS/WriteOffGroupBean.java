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
import eSS.Common.SsTransaction;
import eSS.WriteOffGroup.*;
import javax.servlet.http.HttpSession;

public class WriteOffGroupBean extends SsTransaction implements Serializable { 

	private String doc_ref;
	private String trn_type;
	private String store_code;
	private String entry_completed_yn;
	private String doc_type_code;
	private String doc_date;

	private String finalized;
	private String doc_no;
	private String added_by_id;
	protected String facilityid		= "";

	private HashMap hmSsParameter =null;

	private String records_to_delete;
	private HttpSession session;

	public void setSession(HttpSession session) {
		 this.session =  session;
	}

	public HttpSession getSession() {
		 return session;
	}

	public void setFinalized(String finalized) {
		 this.finalized =  finalized;
	}

	public String getFinalized() {
		 return finalized;
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

	public void initDoc_type_code() {
		doc_type_code=checkForNull((String)hmSsParameter.get("DEF_ADJ_DOC_TYPE_CODE"));
	}

	public void initStore_code() {
		store_code=checkForNull((String)hmSsParameter.get("DEF_STORE_CODE_FOR_PRE")) ;
		doc_type_code=checkForNull((String)hmSsParameter.get("DEF_ADJ_DOC_TYPE_CODE"));
	}

	public void initDoc_date() {
		doc_date=hmSsParameter.get("SYS_DATE").toString() ;
	}

	public void setDoc_ref(String doc_ref) {
		 this.doc_ref = checkForNull(doc_ref);
	}

	public String getDoc_ref() {
		 return doc_ref;
	}


	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code() {
		 return store_code;
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

	public String getDoc_type_code_List(){
		return getDoc_type_code_ListOptions("ADJ",getDoc_type_code());
	}

	public String getStore_code_List(){
		try {
			if ((getMode() !=  null) && (getMode().equals(getCommonRepositoryValue("MODE_INSERT")))) {
				java.util.HashMap defaultParameter = getSSParameter();
				String default_store_code = (String)defaultParameter.get("DEF_STORE_CODE_FOR_PRE");
				defaultParameter = null;
				setStore_code(default_store_code);
			}
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_WRITE_OFF_SELECT_LIST"),alParam), getStore_code());
	}

	public void setAll(Hashtable htRecordSet){
		
		super.setAll(htRecordSet);
		setFinalized((String) htRecordSet.get("finalized"));
		setDoc_ref((String) htRecordSet.get("doc_ref"));
		setStore_code((String) htRecordSet.get("store_code"));
		setEntry_completed_yn((String) htRecordSet.get("entry_completed_yn"));
		setDoc_type_code((String) htRecordSet.get("doc_type_code"));
		setDoc_date(com.ehis.util.DateUtils.convertDate((String) htRecordSet.get("doc_date"),"DMY",getLanguageId(),"en"));
		setLanguageId((String) htRecordSet.get("locale"));
		setDoc_no((String) htRecordSet.get("doc_no"));
		setRecords_to_delete((String) htRecordSet.get("records_to_delete"));
	}

	public void clear(){
		super.clear();
		hmSsParameter =null;
		doc_ref="";
		trn_type="";
		store_code="";
		entry_completed_yn="";
		doc_type_code="";
		doc_date="";
		added_by_id="";
		doc_no="";
		finalized="N";
		records_to_delete="";
	}

	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		ArrayList alWriteOffGroupList;
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
				if (!fetchRecord(getSsRepositoryValue("SQL_SS_WRITE_OFF_HDR_COUNT"),alParameters).get("TOTAL").toString().equals("0")) {
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
			
			alWriteOffGroupList	=	(ArrayList)session.getAttribute("alWriteOffGroupList");
			if((alWriteOffGroupList.size()==0)||(getRecords_to_delete().indexOf("N")==-1)){
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
		ArrayList	alWriteOffGroupList	=	null			;
		HashMap hmSQLMap			=	new HashMap()	;
		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");
		try { 
			if (isDocNoAutoGenYN(getDoc_type_code())) {
				setDoc_no(fetchNextDocNo(getDoc_type_code()));
			}
			alHdrInsertData.add(getLoginFacilityId()        );
			alHdrInsertData.add(getDoc_type_code()          );
			alHdrInsertData.add(new Long (getDoc_no())	    );
			alHdrInsertData.add(getDoc_date()				);
			alHdrInsertData.add(getStore_code()      );
			alHdrInsertData.add(getDoc_ref()				);
			alHdrInsertData.add(getEntry_completed_yn()		);
			alHdrInsertData.add(getFinalized()       );
							  
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());

			alWriteOffGroupList	=	(ArrayList)session.getAttribute("alWriteOffGroupList");
			for (int i=0;i<alWriteOffGroupList.size() ;i++ ) {
				if(stRecordsToDel.nextToken().equals("N")){
					alDtlInsertData.add((HashMap)alWriteOffGroupList.get(i));		
				}
			}

			hmSQLMap.put( "HdrInsertSQL",		getSsRepositoryValue("SQL_SS_WRITE_OFF_HDR_INSERT")			);
			hmSQLMap.put( "DtlInsertSQL",		getSsRepositoryValue("SQL_SS_WRITE_OFF_DTL_INSERT")			);
			hmSQLMap.put( "NextDocNoUpdateSQL",	getSsRepositoryValue("SQL_SY_ACC_ENTITY_DOC_TYPE_UPDATE")	);

			hmTableData.put( "isDocNoAutoGenYN",	new Boolean(isDocNoAutoGenYN(getDoc_type_code())) );
			hmTableData.put( "properties",			getProperties() );
			hmTableData.put( "HdrInsertData",		alHdrInsertData	);
			hmTableData.put( "DtlInsertData",		alDtlInsertData	);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return WriteOffGroupMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}
	
	public HashMap modify() {

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrModifyData		=	new ArrayList()	;
		ArrayList	alDtlModifyData		=	new ArrayList()	;
		ArrayList	alWriteOffGroupList			=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");
		alHdrModifyData.add(getDoc_date()				);
		alHdrModifyData.add(getStore_code ()		);
		alHdrModifyData.add(getDoc_ref           ()		);
		alHdrModifyData.add(getEntry_completed_yn()		);
		alHdrModifyData.add(getFinalized()		);

		alHdrModifyData.add(getLoginById());      
		alHdrModifyData.add(getLoginAtWsNo());    
		alHdrModifyData.add(getLoginFacilityId());

		alHdrModifyData.add(getLoginFacilityId());      
		alHdrModifyData.add(getDoc_type_code()          );
		alHdrModifyData.add(new Long (getDoc_no())	    );

		alWriteOffGroupList	=	(ArrayList)session.getAttribute("alWriteOffGroupList");

		for (int i=0;i<alWriteOffGroupList.size() ;i++ ) {
			HashMap hmRecord	=	(HashMap)alWriteOffGroupList.get(i);
			if(stRecordsToDel.nextToken().equals("Y")){
				if( hmRecord.get("mode").toString().equals(getCommonRepositoryValue("MODE_INSERT"))) 
					continue;
				else
					hmRecord.put("mode",getCommonRepositoryValue("MODE_DELETE"));
			}
			
			alDtlModifyData.add(hmRecord);		
		}

		hmSQLMap.put( "HdrModifySQL", getSsRepositoryValue("SQL_SS_WRITE_OFF_HDR_UPDATE")	);
		hmSQLMap.put( "DtlModifySQL", getSsRepositoryValue("SQL_SS_WRITE_OFF_DTL_UPDATE")		);
		hmSQLMap.put( "DtlInsertSQL", getSsRepositoryValue("SQL_SS_WRITE_OFF_DTL_INSERT")		);
		hmSQLMap.put( "DtlDeleteSQL", getSsRepositoryValue("SQL_SS_WRITE_OFF_DTL_DELETE")		);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "HdrModifyData",		alHdrModifyData	);
		hmTableData.put( "DtlModifyData",		alDtlModifyData	);

		return WriteOffGroupMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public HashMap delete(){
		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alDeleteData		=	new ArrayList()	;
		HashMap		hmSQLMap			=	new HashMap()	;

		alDeleteData.add(getLoginFacilityId()        );
		alDeleteData.add(getDoc_type_code()          );
		alDeleteData.add(new Long (getDoc_no())		 );

		hmSQLMap.put( "HdrDeleteSQL", getSsRepositoryValue("SQL_SS_WRITE_OFF_HDR_DELETE")	);
		hmSQLMap.put( "DtlDeleteSQL", getSsRepositoryValue("SQL_SS_WRITE_OFF_DTL_DELETE_GROUP")	);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "DeleteData",			alDeleteData	);

		return WriteOffGroupMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE);
	}

	public HashMap WriteOffGroupMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){

		HashMap		hmResult	=	new HashMap()	;
		WriteOffGroupHome	WriteOffGroupHome		= null ;
		WriteOffGroupRemote	WriteOffGroupRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_WRITE_OFF_GROUP"),WriteOffGroupHome.class,getLocalEJB());
		Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

		Object argArray[] = new Object[2];
		argArray[0] = hmTableData;
		argArray[1] = hmSQLMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = hmTableData.getClass(); 
		paramArray[1] = hmSQLMap.getClass();

			switch (functionID)
			{
				case FUNCTION_INSERT:
					hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					break;
		
				case FUNCTION_UPDATE:
					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					break;
				
				case FUNCTION_DELETE :
					hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to WriteOffGroupMethodCall()") ;
			}
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			else if( hmResult.get("msgid")!=null  )
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		} 
		catch(Exception exception) {
			System.err.println( "Error Calling Request Group EJB : "+exception) ;
			hmResult.put( "message", "Bean 395: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( WriteOffGroupRemote != null )
					WriteOffGroupRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", "Bean 394: "+exception.toString()) ;
			}
		}
		return hmResult;

	}

	public void loadData() throws Exception {

		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getDoc_type_code());
		alParameters.add(new Long(getDoc_no()));

		HashMap hmRecord		= 	fetchRecord(getSsRepositoryValue("SQL_SS_WRITE_OFF_HDR_SELECT_SINGLE"),alParameters);

		setDoc_ref(				(String) hmRecord.get("DOC_REF")			);      

		setFinalized(	(String) hmRecord.get("FINALIZED_YN")	);
		setStore_code(	(String) hmRecord.get("STORE_CODE")	);
		setEntry_completed_yn(	(String) hmRecord.get("ENTRY_COMPLETED_YN")	);
		setDoc_date(			(String) hmRecord.get("DOC_DATE")			);      

		setAdded_by_id(			(String) hmRecord.get("ADDED_BY_ID")		);  
	}

}
