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
import eSS.AutoclaveWashingUnitTest.*;
import javax.servlet.http.HttpSession;

public class AutoclaveWashingUnitTestBean extends SsTransaction implements Serializable { 


	private String entry_completed_yn;

	private String test_date;
	private String unit_type;
	private String autoclave_wash_unit_code;
	private String unit_status;
	private String finalized;
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

	public void initTest_date() {
		test_date=hmSsParameter.get("SYS_DATE").toString() ;
	}

	
	public String getAutoclave_wash_unit_code_List( String unit_type){

		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getUnit_type());
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());  ///Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
		
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WASHING_UNIT_SELECT_LIST"), alParameters),getAutoclave_wash_unit_code());
		
	}
	public String getAutoclave_wash_unit_code_List1( String unit_type){
		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getUnit_type());
		alParameters.add(getLanguageId());
		alParameters.add(getLoginFacilityId());  ///Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
		
	return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WASHING_UNIT_SELECT_LIST"), alParameters),getAutoclave_wash_unit_code());
		
	}

	public void setEntry_completed_yn(String entry_completed_yn) {
		 this.entry_completed_yn = checkForNull(entry_completed_yn,"N");
	}

	public String getEntry_completed_yn() {
		 return entry_completed_yn;
	}

		public String getUnit_type_List(){
		String locale = getLanguageId();
	     java.util.Locale loc = new java.util.Locale(locale);
	     java.util.ResourceBundle ss_labels = java.util.ResourceBundle.getBundle( "eSS.resources.Labels",loc);
		 
		return getStaticListOptionTag( "A,"+ss_labels.getString("eSS.Autoclave.label")+";W,"+ss_labels.getString("eSS.Washing.label"), getUnit_type());
		
	}
		public void setUnit_type(String unit_type) {
			 this.unit_type = unit_type;
		}
		public String initUnit_type()
		{
			this.unit_type="A";
			return unit_type;
		}	
		public String getUnit_type() {
			 return unit_type;
		}

		public void setTest_date(String test_date) {
			 this.test_date = test_date;
		}

		public String getTest_date() {
			 return test_date;
		}
		public void setUnit_Status(String unit_status) {
			 this.unit_status = unit_status;
		}

		public String getUnit_Status() {
			 return unit_status;
		}
		public void setAutoclave_wash_unit_code(String autoclave_wash_unit_code) {
			 this.autoclave_wash_unit_code= autoclave_wash_unit_code;
		}

		public String getAutoclave_wash_unit_code() {
			 return autoclave_wash_unit_code;
		}

	public void setAdded_by_id(String added_by_id) {
		 this.added_by_id = added_by_id;
	}

	public String getAdded_by_id() {
		 return added_by_id;
	}


	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setFinalized((String) htRecordSet.get("finalized"));
		setUnit_type((String) htRecordSet.get("unit_type"));
		setAutoclave_wash_unit_code((String) htRecordSet.get("autoclave_wash_unit_code"));
		setEntry_completed_yn((String) htRecordSet.get("entry_completed_yn"));
		setTest_date((String) htRecordSet.get("test_date"));

		setRecords_to_delete((String) htRecordSet.get("records_to_delete"));
	}

	public void clear(){
		super.clear();
		hmSsParameter =null;
		unit_type="";
		entry_completed_yn="";
		autoclave_wash_unit_code="";
		test_date="";
		added_by_id="";
		finalized="N";
		records_to_delete="";
	}

	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		ArrayList alAutoclaveWashingUnitTestList;
		hmReturn.put(RESULT,TRUE);
		if (getMode().equals(getCommonRepositoryValue("MODE_DELETE"))) {
			return hmReturn;
		}
		try { 
			alAutoclaveWashingUnitTestList	=	(ArrayList)session.getAttribute("alAutoclaveWashingUnitTestList");
			if((alAutoclaveWashingUnitTestList.size()==0)||(getRecords_to_delete().indexOf("N")==-1)){
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
		ArrayList	alAutoclaveWashingUnitTestList	=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");
		try { 
			alHdrInsertData.add(getAutoclave_wash_unit_code()          );
			alHdrInsertData.add(getTest_date()				);

			alHdrInsertData.add(getEntry_completed_yn()		);
			alHdrInsertData.add(getFinalized()       );
							  
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());
			
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());

			alAutoclaveWashingUnitTestList	=	(ArrayList)session.getAttribute("alAutoclaveWashingUnitTestList");
			for (int i=0;i<alAutoclaveWashingUnitTestList.size() ;i++ ) {
				if(stRecordsToDel.nextToken().equals("N")){
					alDtlInsertData.add((HashMap)alAutoclaveWashingUnitTestList.get(i));		
				}
			}

			hmSQLMap.put( "HdrInsertSQL",		getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_HDR_INSERT")			);
			hmSQLMap.put( "DtlInsertSQL",		getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_DTL_INSERT")			);
			hmTableData.put( "properties",			getProperties() );
			hmTableData.put( "HdrInsertData",		alHdrInsertData	);
			hmTableData.put( "DtlInsertData",		alDtlInsertData	);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return AutoclaveWashingUnitTestMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}
	
	public HashMap modify() {

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrModifyData		=	new ArrayList()	;
		ArrayList	alDtlModifyData		=	new ArrayList()	;
		ArrayList	alAutoclaveWashingUnitTestList			=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");

		alHdrModifyData.add(getEntry_completed_yn()		);
		alHdrModifyData.add(getFinalized()		);

		alHdrModifyData.add(getLoginById());      
		alHdrModifyData.add(getLoginAtWsNo());    
		alHdrModifyData.add(getLoginFacilityId());

		alHdrModifyData.add(getAutoclave_wash_unit_code()          );
		alHdrModifyData.add(getTest_date()				);

		alAutoclaveWashingUnitTestList	=	(ArrayList)session.getAttribute("alAutoclaveWashingUnitTestList");
		
		for (int i=0;i<alAutoclaveWashingUnitTestList.size() ;i++ ) {
			HashMap hmRecord	=	(HashMap)alAutoclaveWashingUnitTestList.get(i);

			String stRemarks=checkForNull((String)hmRecord.get("result_remarks"),"");
            hmRecord.put("result_remarks",stRemarks); 

			if(stRecordsToDel.nextToken().equals("Y")){
				if( hmRecord.get("mode").toString().equals(getCommonRepositoryValue("MODE_INSERT"))) 
					continue;
				else
					hmRecord.put("mode",getCommonRepositoryValue("MODE_DELETE"));
			}
			
			alDtlModifyData.add(hmRecord);		
		}

		hmSQLMap.put( "HdrModifySQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_HDR_UPDATE")	);
		hmSQLMap.put( "DtlModifySQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_DTL_UPDATE")		);
        hmSQLMap.put( "UpdateUnitStatusSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_UNIT_UPDATE_UNIT_STATUS")		);
		hmSQLMap.put( "DtlInsertSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_DTL_INSERT")		);
		hmSQLMap.put( "DtlDeleteSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_DTL_DELETE")		);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "HdrModifyData",		alHdrModifyData	);
		hmTableData.put( "DtlModifyData",		alDtlModifyData	);

		return AutoclaveWashingUnitTestMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public HashMap delete(){
		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alDeleteData		=	new ArrayList()	;
		HashMap		hmSQLMap			=	new HashMap()	;

		alDeleteData.add(getAutoclave_wash_unit_code()          );
		alDeleteData.add(getTest_date()          );

		hmSQLMap.put( "HdrDeleteSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_HDR_DELETE")	);
		hmSQLMap.put( "DtlDeleteSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_DTL_DELETE_GROUP")	);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "DeleteData",			alDeleteData	);

		return AutoclaveWashingUnitTestMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE);
	}

	public HashMap AutoclaveWashingUnitTestMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_AUTOCLAVE_WASING_UNIT_TEST"),AutoclaveWashingUnitTestHome.class,getLocalEJB());
			
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
				
				case FUNCTION_DELETE :
					hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to AutoclaveWashingUnitTestMethodCall()") ;
			}

			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;

			else if( hmResult.get("msgid")!=null  )
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"Common")) ;
			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
		} 
		catch(Exception exception) {
			hmResult.put( "message", "Bean 333: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		return hmResult;
	}

	public void loadData() throws Exception {
		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getAutoclave_wash_unit_code().trim());
		alParameters.add(getTest_date().trim());

		HashMap hmRecord		= 	fetchRecord("SELECT b.unit_type UNIT_TYPE,	TO_CHAR(a.test_date,'dd/mm/yyyy') test_date, a.entry_completed_yn, a.finalized_yn, a.added_by_id FROM ss_autoclave_wash_test_hdr  a, ss_autoclave_wash_unit b WHERE a.autoclave_wash_unit_code = ?  AND to_char(a.test_date,'dd/mm/yyyy')=? and a.autoclave_wash_unit_code=b.autoclave_wash_unit_code",alParameters);
//SQL_SS_AUTOCLAVE_WASH_HDR_SELECT_SINGLE
		setUnit_type(				(String) hmRecord.get("UNIT_TYPE")			);       
		setTest_date(			(String) hmRecord.get("TEST_DATE")			);      

		setFinalized(	(String) hmRecord.get("FINALIZED_YN")	);
		setEntry_completed_yn(	(String) hmRecord.get("ENTRY_COMPLETED_YN")	);

		setAdded_by_id(			(String) hmRecord.get("ADDED_BY_ID")		);  
	}

	public ArrayList getAutoclave_wash_unit_codes() {
        ArrayList alautoclave_wash_unit_code = new ArrayList();
        try {
		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getUnit_type());
		HashMap hmRecord		= 	fetchRecord(getSsRepositoryValue("SQL_SS_WASHING_UNIT_SELECT_LIST"),alParameters);
		for(int i=0 ; i<hmRecord.size();i++)
		{
		       alautoclave_wash_unit_code.add((String) hmRecord.get("AUTOCLAVE_WASH_UNIT_CODE"));       
		       alautoclave_wash_unit_code.add((String) hmRecord.get("SHORT_DESC"));       
		}
        } 
		catch (Exception e) {
            e.printStackTrace();
        } 
		finally {
            try{
            }catch(Exception es){
				es.printStackTrace();
            }
        }
        return alautoclave_wash_unit_code;
	}
	
}


