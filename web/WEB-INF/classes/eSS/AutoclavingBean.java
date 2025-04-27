/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
-------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name			INC Number       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------------------------

12/11/2014				AAKH_CRF_0057			Sakti Sankar		52312											Autoclaving function, option to select
																													Biological indicator , BMS Pass / Fail 
																													Both in Master as wel as Transaction function.
--------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

package eSS;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.StringTokenizer;
import eSS.Common.SsTransaction;
import eSS.Autoclaving.*;
import javax.servlet.http.HttpSession;

public class AutoclavingBean extends SsTransaction implements Serializable { 

	private String autoclave_wash_unit_code;
	private String load_no;
	private String temperature;
	private String autoclave_date;
	private String store_code;
	private String old_load_no;
	private String entry_completed_yn;
	private String finalized;
	private String added_by_id;
	private String load_status;
	private String sterileTypeDesc;
    private String serviceLocation;
    private String select_all;

	private String b_indicator_test_done_yn; //Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
	private String bms_pass_fail; //Added by Sakti against  AAKH_CRF_0057 added  BIOLOGICAL_IND_TEST_APPL_YN , BMS_APPL_YN inc#52312
	private String room_temp; //Added by Sakti against  AAKH_CRF_0057  inc#52312
	private String relative_humidity; //Added by Sakti against  AAKH_CRF_0057  inc#52312
	private String test_code; //Added by Badmavathi against  AAKH_CRF_0057 on 03/12/2014
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
	public void initAutoclaving_date() {
		autoclave_date=hmSsParameter.get("SYS_DATE").toString() ;
	}

	public void initStore_code() {
		setStore_code(checkForNull((String)hmSsParameter.get("DEF_STORE_CODE_FOR_PRE")) );
	}

	public void setAutoclave_wash_unit_code(String autoclave_wash_unit_code) {
		 this.autoclave_wash_unit_code = checkForNull(autoclave_wash_unit_code);
	}

	public String getAutoclave_wash_unit_code() {
		 return autoclave_wash_unit_code;
	}


	public void setLoad_no(String load_no) {
		 this.load_no = checkForNull(load_no);
	}

	public String getLoad_no() {
		 return load_no;
	}
	public void setSelect_All(String select_all) {
		 this.select_all = checkForNull(select_all);
	}

	public String getSelect_All() {
		 return select_all;
	}

	public void setTemperature(String temperature) {
		 this.temperature = checkForNull(temperature);
	}

	public String getTemperature() {
		 return temperature;
	}
	//Added by Pankaj on 05/08/2003

    public void setServiceLocation(String serviceLocation) {
		 this.serviceLocation = checkForNull(serviceLocation);
	}

	public String getServiceLocation() {
		 return serviceLocation;
	}

	public void setSterileTypeDesc(String sterileTypeDesc) {
		 this.sterileTypeDesc = checkForNull(sterileTypeDesc);
	}

	public String getSterileTypeDesc() {
		 return sterileTypeDesc;
	}

   // END by Pankaj 

	public void setAutoclave_date(String autoclave_date) {
		 this.autoclave_date = checkForNull(autoclave_date);
	}

	public String getAutoclave_date() {
		 return autoclave_date;
	}
	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code() {
		 return store_code;
	}

	public void setOld_load_no(String old_load_no) {
		 this.old_load_no = checkForNull(old_load_no);
	}

	public String getOld_load_no() {
		 return old_load_no;
	}
	public String getOld_load_no1() {
		 return load_no;
	}

	public void setEntry_completed_yn(String entry_completed_yn) {
		 this.entry_completed_yn = checkForNull(entry_completed_yn,"N");
	}

	public String getEntry_completed_yn() {
		 return entry_completed_yn;
	}

	public void setAdded_by_id(String added_by_id) {
		 this.added_by_id = added_by_id;
	}

	public String getAdded_by_id() {
		 return added_by_id;
	}

	public String getStore_code_List(){
		java.util.ArrayList alParam = new java.util.ArrayList();
		alParam.add(login_facility_id);
		alParam.add(login_by_id);
		alParam.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_WRITE_OFF_SELECT_LIST"),alParam), getStore_code());
	}

	public String getAutoclave_wash_unit_code_List()
	{
	   //Added by Rabbani #Bru-HIMS-CRF-390(42494) on 17-apr-2014
	   ArrayList alParam = new  ArrayList();
	    alParam.add(getLanguageId());
		alParam.add(login_facility_id);
		
		//return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_AUTOCLAVE_UNIT_SELECT_LIST"),getLanguageId()),getAutoclave_wash_unit_code());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_AUTOCLAVE_UNIT_SELECT_LIST"),alParam),getAutoclave_wash_unit_code());
	}
public String getAutoclave_wash_unit_code_List1()
	{
	   //Added by Badmavathi  against AAKH_CRF0057.1 inc 54283 06-mar-2015
	   ArrayList alParam = new  ArrayList();
	    alParam.add(getLanguageId());
		alParam.add(login_facility_id);
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_AUTOCLAVE_UNIT_SELECT_LIST_LOG"),alParam),getAutoclave_wash_unit_code());
	}
	public String getLoad_status_List(){
		return getStaticListOptionTag( "P,Passed;F,Failed;", getLoad_status());
	}

	public String getLoad_status() {
		 return load_status;
	}

	public void setLoad_status(String load_status) {
		 this.load_status =  load_status;
	}


	
//Added by Sakti against  AAKH_CRF_0057  inc#52312
	public String getBIndicator_List(){
		return getStaticListOptionTag( "Y,Test Done;N,Not Done;", getBIndicatorTestDone_yn());
	}

	public String getBIndicatorTestDone_yn() {
		 return b_indicator_test_done_yn;
	}

	public void setBIndicatorTestDone_yn(String b_indicator_test_done_yn) {
		 this.b_indicator_test_done_yn =  checkForNull(b_indicator_test_done_yn,"N");
	}

	public String getBMS_PassFail_List(){
		return getStaticListOptionTag( "P,Pass;F,Fail;", getBMSPassFail_yn());
	}

	public String getBMSPassFail_yn() {
		 return bms_pass_fail;
	}

	public void setBMSPassFail_yn(String bms_pass_fail) {
		 this.bms_pass_fail =  checkForNull(bms_pass_fail,"P");
	}

	public String getRoom_temp() {
		 return room_temp;
	}

	public void setRoomTemp(String room_temp) {
		 this.room_temp =  checkForNull(room_temp);
	}

	public String getRelativeHumidity() {
		 return relative_humidity;
	}

	public void setRelativeHumidity(String relative_humidity) {
		 this.relative_humidity =  checkForNull(relative_humidity);
	} 

//Added ends
//Added by Badmavathi against  AAKH_CRF_0057 on 03/12/2014 
	public String getTest_code() {
		return test_code;
	}

	public void setTest_code(String test_code) {
		this.test_code = checkForNull(test_code);
	}
//Added ends

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);



		setFinalized((String) htRecordSet.get("finalized"));
		setAutoclave_wash_unit_code((String) htRecordSet.get("autoclave_wash_unit_code"));
		setTemperature((String) htRecordSet.get("temperature"));
		setEntry_completed_yn((String) htRecordSet.get("entry_completed_yn"));
		setLoad_no((String) htRecordSet.get("load_no"));
		setAutoclave_date((String) htRecordSet.get("autoclave_date"));
		setStore_code((String) htRecordSet.get("store_code"));

		setLoad_no((String) htRecordSet.get("load_no"));
		setLoad_status((String) htRecordSet.get("load_status"));
		setRecords_to_delete((String) htRecordSet.get("records_to_delete"));
        
		setServiceLocation((String) htRecordSet.get("service_location"));
		setSterileTypeDesc((String) htRecordSet.get("sterilization_type"));

		//Added by Sakti against  AAKH_CRF_0057  inc#52312
		setBIndicatorTestDone_yn((String) htRecordSet.get("b_indicator_test_done_yn"));
		setBMSPassFail_yn((String) htRecordSet.get("bms_pass_fail"));
		setRoomTemp((String) htRecordSet.get("room_temp"));
		setRelativeHumidity((String) htRecordSet.get("relative_humidity"));
		//Added ends

	}

	public void clear(){
		super.clear();
		autoclave_wash_unit_code="";
		load_no="";
		temperature="";
		autoclave_date="";
		old_load_no="";
		store_code="";
		//finalized="";
		entry_completed_yn="";
		load_status="";
		added_by_id="";
		finalized="N";
		records_to_delete="";
		sterileTypeDesc="";
        serviceLocation="";

		b_indicator_test_done_yn = "";
		bms_pass_fail = "";
		room_temp = "";
		relative_humidity = "";

	}

	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		ArrayList alAutoclavingList;
		hmReturn.put(RESULT,TRUE);
		if (getMode().equals(getCommonRepositoryValue("MODE_DELETE"))) 
		{
			return hmReturn;
		}
		//else if (getMode().equals(getCommonRepositoryValue("MODE_INSERT"))) 
		//{}
		//else
		//{
		//try { 
				alAutoclavingList	=	(ArrayList)session.getAttribute("alAutoclavingList");
				
				HashMap hmAutoclavingRecord=new HashMap();
				int noOfRecordsToDelete=0;
				for(int i=0;i<alAutoclavingList.size();i++)
				{
					hmAutoclavingRecord	=	(HashMap)alAutoclavingList.get(i);
					if(hmAutoclavingRecord.get("SELECTED").equals("Y"))
					{
						noOfRecordsToDelete++;
					}
				}

				/*if((alAutoclavingList.size()==0)|| (noOfRecordsToDelete==alAutoclavingList.size()))
				{
					throw new Exception("MIN_ONE_DETAIL_REQUIRED");
				}*/
				if( getMode().equals(getCommonRepositoryValue("MODE_INSERT")) && noOfRecordsToDelete == 0 ){
					//throw new Exception("MIN_ONE_DETAIL_REQUIRED");
					hmReturn.put("result", new Boolean(false));
					hmReturn.put("msgid","MIN_ONE_DETAIL_REQUIRED");
					hmReturn.put("message",getMessage(getLanguageId(),(String) hmReturn.get("msgid"),"Common"));
				}else if( (getMode().equals(getCommonRepositoryValue("MODE_MODIFY"))) && ((alAutoclavingList.size()==0)|| (noOfRecordsToDelete==alAutoclavingList.size()) ) )
				{
						//throw new Exception("MIN_ONE_DETAIL_REQUIRED");
					hmReturn.put("result", new Boolean(false));
					hmReturn.put("msgid","MIN_ONE_DETAIL_REQUIRED");
					hmReturn.put("message",getMessage(getLanguageId(),(String) hmReturn.get("msgid"),"Common"));
				}  
			//}
			/*catch (Exception exception) 
			{
				hmReturn.put(RESULT,FALSE);
				hmReturn.put(MSGID,exception.getMessage());
				hmReturn.put(MESSAGE,exception.toString());
				exception.printStackTrace();
			}*/
		//}
		return hmReturn;
	}

public void updateSelectedTrays(Hashtable htTrays, int start, int end, int totalRecords) {
	HashMap hmRecord=null;
	ArrayList	alAutoclavingList	=	null			;
	alAutoclavingList	=	(ArrayList)session.getAttribute("alAutoclavingList");
	if(end>totalRecords)
		end=totalRecords;
			for (int idx = start; idx<end;idx++ ) {
				hmRecord	=	(HashMap)alAutoclavingList.get(idx);
				hmRecord.put("SELECTED",(String) htTrays.get("SELECTED"+idx));
			}

			
	}
public int  getSelectedTrays(Hashtable htTrays, int start, int end, int totalRecords) {
	int count=0;
	HashMap hmRecord=null;
	ArrayList	alAutoclavingList	=	null			;
	alAutoclavingList	=	(ArrayList)session.getAttribute("alAutoclavingList");
	if(end>totalRecords)
		end=totalRecords;
			for (int idx = start; idx<end;idx++ ) {
				hmRecord	=	(HashMap)alAutoclavingList.get(idx);
				if((String) htTrays.get("SELECTED"+idx)=="Y") count=count+1;

			}
	return count;
			
	}
	
	public HashMap insert(){
		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrInsertData		=	new ArrayList()	;
		ArrayList	alDtlInsertData		=	new ArrayList()	;
		ArrayList	alAutoclavingList	=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;

		try { 

			alHdrInsertData.add(getAutoclave_wash_unit_code()          );
			alHdrInsertData.add(getLoad_no());
			alHdrInsertData.add(getTemperature()				);
			alHdrInsertData.add(getAutoclave_date()				);
			alHdrInsertData.add(getStore_code()      );
			alHdrInsertData.add(getOld_load_no()				);
			alHdrInsertData.add(getEntry_completed_yn()		);
			alHdrInsertData.add(getFinalized()       );
              
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());
			alHdrInsertData.add(getLoad_status());

			//Added by Sakti against  AAKH_CRF_0057  inc#52312
			if(chkBioindAndBMSNotApp(getAutoclave_wash_unit_code(),"1")){//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057  inc#52312
				alHdrInsertData.add(getBIndicatorTestDone_yn());
			}else{
				alHdrInsertData.add("X");
			}
			if(chkBioindAndBMSNotApp(getAutoclave_wash_unit_code(),"2")){//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057  inc#52312
				alHdrInsertData.add(getBMSPassFail_yn());
			}else{
				alHdrInsertData.add("X");
			}    
			alHdrInsertData.add(getRoom_temp());
			alHdrInsertData.add(getRelativeHumidity());
			//Added ends



			alAutoclavingList	=	(ArrayList)session.getAttribute("alAutoclavingList");
	
			for (int i=0;i<alAutoclavingList.size() ;i++ ) {
					alDtlInsertData.add((HashMap)alAutoclavingList.get(i));		
			}

			hmSQLMap.put( "HdrInsertSQL",		getSsRepositoryValue("SQL_SS_AUTOCLAVE_HDR_INSERT")			);
			hmSQLMap.put( "DtlInsertSQL",		getSsRepositoryValue("SQL_SS_AUTOCLAVE_DTL_INSERT")			);
			hmSQLMap.put( "ROFUpdateSQL",	getSsRepositoryValue("SQL_SS_ROF_DTL_UPDATE")	);
			hmSQLMap.put( "AutoclaveWashUnitUpdateSQL",	getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_UNIT_UPDATE_LOAD_NO")	);
			hmSQLMap.put( "FetchLoadNoSQL",	getSsRepositoryValue("SQL_SS_WASHING_LOAD_NO")	);


			hmTableData.put( "properties",			getProperties() );
			hmTableData.put( "HdrInsertData",		alHdrInsertData	);
			hmTableData.put( "DtlInsertData",		alDtlInsertData	);
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return AutoclavingMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}
	
	public HashMap modify() {
		System.err.println("MODIFY_METHOD_CALLED");
		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alHdrModifyData		=	new ArrayList()	;
		ArrayList	alDtlModifyData		=	new ArrayList()	;

		ArrayList	alHdrInsertData		=	new ArrayList()	;
		ArrayList	alDtlInsertData		=	new ArrayList()	;


		ArrayList	alAutoclavingList			=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;

		alHdrModifyData.add(getTemperature()				);
		alHdrModifyData.add(getAutoclave_date()				);
		alHdrModifyData.add(getStore_code()      );
		alHdrModifyData.add(getOld_load_no()				);
		alHdrModifyData.add(getLoad_status()				);

		alHdrModifyData.add(getEntry_completed_yn()		);
		alHdrModifyData.add(getFinalized()       );

 		alHdrModifyData.add(getLoginById());      
		alHdrModifyData.add(getLoginAtWsNo());    
		alHdrModifyData.add(getLoginFacilityId());

				
		//Added by Sakti against  AAKH_CRF_0057  inc#52312
		if(chkBioindAndBMSNotApp(getAutoclave_wash_unit_code(),"1")){//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057  inc#52312
			alHdrModifyData.add(getBIndicatorTestDone_yn());
		}else{
			alHdrModifyData.add("X");
		}
		if(chkBioindAndBMSNotApp(getAutoclave_wash_unit_code(),"2")){//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057  inc#52312
			alHdrModifyData.add(getBMSPassFail_yn());
		}else{
			alHdrModifyData.add("X");
		}    
		alHdrModifyData.add(getRoom_temp());
		alHdrModifyData.add(getRelativeHumidity());
		//Added ends


		alHdrModifyData.add(getLoginFacilityId());
		alHdrModifyData.add(getAutoclave_wash_unit_code()          );
		alHdrModifyData.add(getLoad_no()	    );
		alAutoclavingList	=	(ArrayList)session.getAttribute("alAutoclavingList");
		for (int i=0;i<alAutoclavingList.size() ;i++ ) {
			HashMap hmRecord	=	(HashMap)alAutoclavingList.get(i);
			if(hmRecord.get("SELECTED").equals("Y"))
			{
					hmRecord.put("mode",getCommonRepositoryValue("MODE_DELETE"));
			}
				else
			{
					hmRecord.put("mode",getCommonRepositoryValue("MODE_MODIFY"));

					alDtlInsertData.add((HashMap)alAutoclavingList.get(i));		
			}

			alDtlModifyData.add(hmRecord);		
		}

		hmSQLMap.put( "HdrModifySQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_HDR_UPDATE")	);
		hmSQLMap.put( "DtlModifySQL",		getSsRepositoryValue("SQL_SS_AUTOCLAVE_DTL_UPDATE")			);

		hmSQLMap.put( "DtlInsertSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_DTL_INSERT")		);
		hmSQLMap.put( "DtlDeleteSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_DTL_DELETE")		);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "HdrModifyData",		alHdrModifyData	);
		hmTableData.put( "DtlModifyData",		alDtlModifyData	);

	


	if(getLoad_status().equals("F") && getFinalized().equals("Y"))
		{

		

			alHdrInsertData.add(getAutoclave_wash_unit_code()          );
			alHdrInsertData.add(getLoad_no());
			alHdrInsertData.add(getTemperature()				);
			alHdrInsertData.add(getAutoclave_date()				);
			alHdrInsertData.add(getStore_code()      );
			alHdrInsertData.add(getOld_load_no1()				);
			alHdrInsertData.add(getEntry_completed_yn()		);
			alHdrInsertData.add(getFinalized()       );
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());
			alHdrInsertData.add(getLoginById());      
			alHdrInsertData.add(getLoginAtWsNo());    
			alHdrInsertData.add(getLoginFacilityId());
			alHdrInsertData.add("P");

			if(chkBioindAndBMSNotApp(getAutoclave_wash_unit_code(),"1")){//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057  inc#52312
				alHdrInsertData.add(getBIndicatorTestDone_yn());
			}else{
				alHdrInsertData.add("X");
			}
			if(chkBioindAndBMSNotApp(getAutoclave_wash_unit_code(),"2")){//Added by suresh.r on 10-12-2014 against AAKH_CRF_0057  inc#52312
				alHdrInsertData.add(getBMSPassFail_yn());
			}else{
				alHdrInsertData.add("X");
			}    
			alHdrInsertData.add(getRoom_temp());
			alHdrInsertData.add(getRelativeHumidity());
		
			
			hmSQLMap.put( "HdrInsertSQL",		getSsRepositoryValue("SQL_SS_AUTOCLAVE_HDR_INSERT")			);
			hmSQLMap.put( "DtlInsertSQL",		getSsRepositoryValue("SQL_SS_AUTOCLAVE_DTL_INSERT")			);
			hmSQLMap.put( "ROFUpdateSQL",	getSsRepositoryValue("SQL_SS_ROF_DTL_UPDATE")	);
			hmSQLMap.put( "AutoclaveWashUnitUpdateSQL",	getSsRepositoryValue("SQL_SS_AUTOCLAVE_WASH_UNIT_UPDATE_LOAD_NO")	);
			hmSQLMap.put( "FetchLoadNoSQL",	getSsRepositoryValue("SQL_SS_WASHING_LOAD_NO")	);

			hmTableData.put( "properties",			getProperties() );
			hmTableData.put( "HdrInsertData",		alHdrInsertData	);
			hmTableData.put( "DtlInsertData",		alDtlInsertData	);
	}

		
		return AutoclavingMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public HashMap delete(){
		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alDeleteData		=	new ArrayList()	;
		HashMap		hmSQLMap			=	new HashMap()	;
		

		alDeleteData.add(getLoginFacilityId()        );
		alDeleteData.add(getAutoclave_wash_unit_code()          );
		alDeleteData.add(new Long (getLoad_no())	    );

		hmSQLMap.put( "HdrDeleteSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_HDR_DELETE")	);
		hmSQLMap.put( "DtlDeleteSQL", getSsRepositoryValue("SQL_SS_AUTOCLAVE_DTL_DELETE_GROUP")	);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "DeleteData",			alDeleteData	);

		return AutoclavingMethodCall(hmTableData, hmSQLMap, FUNCTION_DELETE);
	}

	public HashMap AutoclavingMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){
		
		HashMap		hmResult	=	new HashMap()	;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_AUTOCLAVING"),AutoclavingHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			
			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); ;
			paramArray[1] = hmSQLMap.getClass();
System.out.println("functionID==="+functionID);
System.out.println("argArray0==="+argArray[0]);
System.out.println("argArray1==="+argArray[1]);
System.err.println("functionID==="+functionID);
			try{
			switch (functionID)
			{
				case FUNCTION_INSERT:
					hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

					break;
				
				case FUNCTION_UPDATE:
					System.out.println("aaaaa");
					hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					System.out.println("bbbbbb");
					break;
				
				case FUNCTION_DELETE :
					hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to AutoclavingMethodCall()") ;
			}

			}
		catch (Exception exception) {
			exception.printStackTrace();
			}
			if( ((Boolean) hmResult.get("result")).booleanValue() )	
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;

			else if( hmResult.get("msgid")!=null  )
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;

			else
				hmResult.put( "message", replaceNewLineChar((String)hmResult.get("message")) ) ;
			System.out.println("cccc"+hmResult.get("msgid")+"ssss"+hmResult.get("message"));
	 }catch(Exception exception) {
			hmResult.put( "message", "Bean 395: "+exception.getMessage()) ;
			exception.printStackTrace() ;
	} 
	


	return hmResult;
	}


	public void loadData() throws Exception {

		ArrayList alParameters	=	new ArrayList(3);
		alParameters.add(getLoginFacilityId());
		alParameters.add(getAutoclave_wash_unit_code());

		alParameters.add(new Long(getLoad_no()));
		HashMap hmRecord		= 	fetchRecord(getSsRepositoryValue("SQL_SS_AUTOCLAVE_HDR_SELECT_SINGLE"),alParameters);
		setTemperature(	(String) hmRecord.get("TEMPERATURE")			);       
		setFinalized(	(String) hmRecord.get("FINALIZED_YN")	);
		setLoad_status(	(String) hmRecord.get("LOAD_STATUS")	);
		setOld_load_no(	(String) hmRecord.get("OLD_LOAD_NO")	);
		setStore_code(	(String) hmRecord.get("STORE_CODE")	);
		setEntry_completed_yn(	(String) hmRecord.get("ENTRY_COMPLETED_YN")	);
		setAutoclave_date((String) hmRecord.get("AUTOCLAVE_DATE")			);      
		setAdded_by_id((String) hmRecord.get("ADDED_BY_ID")		);
		setServiceLocation(	(String) hmRecord.get("STERILE_DESC")		);
		setSterileTypeDesc(	(String) hmRecord.get("SERVICE_LOC_DESC")		);

		//Added by Sakti against  AAKH_CRF_0057  inc#52312
		setBIndicatorTestDone_yn(	(String) hmRecord.get("BIOLOGICAL_IND_TEST_DONE")		);
		setBMSPassFail_yn(	(String) hmRecord.get("BMS_PASS_FAIL")		);
		setRoomTemp(	(String) hmRecord.get("ROOM_TEMP")		);
		setRelativeHumidity(	(String) hmRecord.get("RELATIVE_HUMIDITY")		);
		//Added ends
		

	}

//Added by Sakti against  AAKH_CRF_0057  inc#52312
	public boolean BiologicalIndicator_appl_yn(String autoclave_wash_unit_code){
		String biologicalIndicator_appl_yn = "N";
		boolean flag=false;
		try{
			String [] alParameter	=	{autoclave_wash_unit_code};
			HashMap hmRecord=fetchRecord("  SELECT BIOLOGICAL_INDICATOR FROM SS_AUTOCLAVE_WASH_UNIT WHERE AUTOCLAVE_WASH_UNIT_CODE = ? ", alParameter);
			biologicalIndicator_appl_yn = checkForNull((String) hmRecord.get("BIOLOGICAL_INDICATOR"),"X");
			if(biologicalIndicator_appl_yn.equals("N") || biologicalIndicator_appl_yn.equals("Y")){
				setBIndicatorTestDone_yn(biologicalIndicator_appl_yn);
				flag= true;
			}else{
				flag= false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}

	public boolean Bms_appl_yn(String autoclave_wash_unit_code){
		String bms_appl_yn = "N";
		boolean flag=false;
		try{
			String [] alParameter	=	{autoclave_wash_unit_code};
			HashMap hmRecord=fetchRecord("  SELECT BMS_APPLICABLE FROM SS_AUTOCLAVE_WASH_UNIT WHERE AUTOCLAVE_WASH_UNIT_CODE = ?", alParameter);
			bms_appl_yn = checkForNull((String) hmRecord.get("BMS_APPLICABLE"),"X");
			if(bms_appl_yn.equals("N") || bms_appl_yn.equals("Y")){
				if(bms_appl_yn.equals("Y")){
					setBMSPassFail_yn("P");
				}else{
					setBMSPassFail_yn("F");
				}
				flag= true;
			}else{
				flag= false;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	//Added ends
	//Added by Badmavathi against  AAKH_CRF_0057 on 03/12/2014 
	public String getTest_code_List()
	{
		String optionValues = null;
		ArrayList alOptionValues = new ArrayList(); 
		ArrayList alParam = new  ArrayList();
	    alParam.add(getLanguageId());
		alParam.add(login_facility_id);	
		alOptionValues = getListOptionArrayList(getSsRepositoryValue("SQL_SS_AUTOCLAVE_TEST_SELECT_LIST"),alParam);
		alOptionValues.remove(0);
		optionValues = getListOptionTag(alOptionValues, getTest_code());
		return optionValues;
	}
	//Added ends
	//Added by suresh.r on 15-12-2014 against Inc 53002 beg
	public boolean chkBioindAndBMSNotApp(String autoclave_wash_unit_code,String opt){
		String biologicalIndicator_appl_yn = "",bms_appl_yn = "";
		boolean flag=false;
		try{
			String [] alParameter	=	{autoclave_wash_unit_code};
			HashMap hmRecord=fetchRecord("  SELECT BMS_APPLICABLE,BIOLOGICAL_INDICATOR FROM SS_AUTOCLAVE_WASH_UNIT WHERE AUTOCLAVE_WASH_UNIT_CODE = ?", alParameter);
			biologicalIndicator_appl_yn = checkForNull((String) hmRecord.get("BIOLOGICAL_INDICATOR"),"X");
			bms_appl_yn = checkForNull((String) hmRecord.get("BMS_APPLICABLE"),"X");
			if(opt.equals("1")){
				if(biologicalIndicator_appl_yn.equals("X")){
					flag= false;
				}else{
					flag= true;
				}
			}else{
				if(bms_appl_yn.equals("X")){
					flag= false;
				}else{
					flag= true;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
	}
	//Added by suresh.r on 15-12-2014 against Inc 53002 end

}
