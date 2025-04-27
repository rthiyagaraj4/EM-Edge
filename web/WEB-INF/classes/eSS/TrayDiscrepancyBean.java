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
import eSS.TrayDiscrepancy.*;
import javax.servlet.http.HttpSession;

public class TrayDiscrepancyBean extends SsTransaction implements Serializable { 

	private String group_type;
	private String group_code ;    
	private String group_desc ;    
	private String tray_no;   
	private String store_code;  
	private String linen_applicable_yn;//MMOH-CRF-1661 START
	

	public String getLinen_applicable_yn() {
		return linen_applicable_yn;
	}

	public void setLinen_applicable_yn(String linen_applicable_yn) {
		this.linen_applicable_yn = linen_applicable_yn;
	}//END 


	private String records_to_delete;
	private HttpSession session;

	public void setSession(HttpSession session) {
		 this.session =  session;
	}

	public HttpSession getSession() {
		 return session;
	}

	public void setGroup_code(String group_code) {
		 this.group_code =  group_code;
	}

	public String getGroup_code() {
		 return group_code;
	}
	
	public void setGroup_desc(String group_desc) {
		 this.group_desc=  group_desc;
	}

	public String getGroup_desc() {
		 return group_desc;
	}
	
	public void setRecords_to_delete(String records_to_delete) {
		 this.records_to_delete =  records_to_delete;
	}

	public String getRecords_to_delete() {
		 return records_to_delete;
	}

	public void setGroup_type(String group_type) {
		 this.group_type = group_type;
	}

	public String getGroup_type() {
		 return group_type;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code() {
		 return store_code;
	}

	public void setTray_no(String tray_no) {
		 this.tray_no = tray_no;
	}

	public String getTray_no() {
		 return tray_no;
	}

	public String getStore_code_List(){
		try {
			//Modified by Martin on Wednesday, April 16, 2003 11:58:14 AM
			java.util.HashMap defaultParameter = getSSParameter();
			String default_store_code = (String)defaultParameter.get("DEF_STORE_CODE_FOR_PRE");
			defaultParameter = null;
			java.util.ArrayList alParam = new java.util.ArrayList();
			alParam.add(login_facility_id);
			alParam.add(login_by_id);
			alParam.add(getLanguageId());
			return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_TRD_SELECT_LIST"), alParam), default_store_code);
		}
		catch (Exception exception) {
			return exception.getMessage();
		}

	}


	public String getGroup_type_List(){
		if(getLinen_applicable_yn()!=null && getLinen_applicable_yn().equals("Y")){
			return getStaticListOptionTag( "E,Set;T,Tray;P,Soft Pack;S,Single;L,Linen;", getGroup_type()); 
		}else{
			return getStaticListOptionTag( "E,Set;T,Tray;P,Soft Pack;S,Single;", getGroup_type()); 
		}
	}

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setStore_code((String) htRecordSet.get("store_code"));
		setGroup_type((String) htRecordSet.get("group_type"));
		setGroup_code((String) htRecordSet.get("group_code"));
		setGroup_desc((String) htRecordSet.get("group_desc"));
		setTray_no ((String) htRecordSet.get("tray_no"));
		setRecords_to_delete((String) htRecordSet.get("records_to_delete"));
	}

	public void clear(){
		super.clear();
		group_type		="";   		
		group_code		="";  		
		group_desc		="";  		
		tray_no			="";      		
		store_code		="";   		
		records_to_delete="";
		linen_applicable_yn = ""; //mmoh-crf-1661 
	}

	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		hmReturn.put(RESULT,TRUE);
		return hmReturn;
	}

	public HashMap insert(){

		HashMap		hmTableData			=	new HashMap()	;
		ArrayList	alCommonInsertData		=	new ArrayList()	;
		ArrayList	alDtlInsertData		=	new ArrayList()	;
		ArrayList	alTrayDiscrepancyList	=	null			;
		HashMap		hmSQLMap			=	new HashMap()	;
		StringTokenizer stRecordsToDel	=	new StringTokenizer(getRecords_to_delete(),",");
		try { 

			alCommonInsertData.add(	getGroup_code()			);
			alCommonInsertData.add(	getTray_no()			);
			alCommonInsertData.add(	getStore_code()			);
							  
			alCommonInsertData.add(	getLoginById()			);      
			alCommonInsertData.add(	getLoginAtWsNo()		);    
			alCommonInsertData.add(	getLoginFacilityId()	);

			alTrayDiscrepancyList	=	(ArrayList)session.getAttribute("alTrayDiscrepancyList");

			for (int i=0;i<alTrayDiscrepancyList.size() ;i++ ) {
				HashMap hmRecord	=	(HashMap)alTrayDiscrepancyList.get(i);
				if(stRecordsToDel.nextToken().equals("Y")){
					if( hmRecord.get("mode").toString().equals(getCommonRepositoryValue("MODE_INSERT"))) 
						continue;
					else
						hmRecord.put("mode",getCommonRepositoryValue("MODE_DELETE"));
				}
				else if(hmRecord.get("mode").toString().equals(getCommonRepositoryValue("MODE_MODIFY"))){
					if(checkForNull((String)hmRecord.get("finalized_yn")).equals("Y"))
						continue;
					else if(hmRecord.get("usage_ind").toString().equals("U")||hmRecord.get("usage_ind").toString().equals("R"))
						continue;
				}
				alDtlInsertData.add(hmRecord);		
			}
			if (alDtlInsertData.size()==0) {
				HashMap hmNoRecordToProcess	=	getMessageHashMap(false);
				hmNoRecordToProcess.put(MSGID,"MODIFICATION_NOT_ALLOWED");
				hmNoRecordToProcess.put(MESSAGE,"MODIFICATION_NOT_ALLOWED");
				return hmNoRecordToProcess;
			}

			hmSQLMap.put( "InsertSQL",		getSsRepositoryValue("SQL_SS_DISCREPANCY_DTL_INSERT")			);
			hmSQLMap.put( "ModifySQL",		getSsRepositoryValue("SQL_SS_DISCREPANCY_DTL_UPDATE_FOR_TRD")			);
			hmSQLMap.put( "DeleteSQL",		getSsRepositoryValue("SQL_SS_DISCREPANCY_DTL_DELETE")			);
			hmTableData.put( "properties",			getProperties() );
			hmTableData.put( "CommonInsertData",	alCommonInsertData	);
			hmTableData.put( "DtlInsertData",		alDtlInsertData	);
			
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}

		return trayDiscrepancyMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}
	

	public HashMap trayDiscrepancyMethodCall(HashMap hmTableData, HashMap hmSQLMap, int functionID ){

		HashMap		hmResult	=	new HashMap()	;

		TrayDiscrepancyRemote	trayDiscrepancyRemote		= null ;
		hmResult.put(RESULT, FALSE ) ;
		hmResult.put(MESSAGE, "Initial Message" ) ;

		try {
			

		Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_SS_TRAY_DISCREPANCY"),TrayDiscrepancyHome.class,getLocalEJB());
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
				
				case FUNCTION_DELETE:
					hmResult = (HashMap)(busObj.getClass().getMethod("delete",paramArray)).invoke(busObj,argArray);
					break;
				
				default:
					hmResult.put( "message", "Invalid Function ID passed to trayDiscrepancyMethodCall()") ;
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
			hmResult.put( "message", "Bean 383: "+exception.getMessage()) ;
			exception.printStackTrace() ;
		} 
		finally {
			try {
				if( trayDiscrepancyRemote != null )
					trayDiscrepancyRemote.remove() ;
			}
			catch( Exception exception) {
				hmResult.put( "message", "Bean 393: "+exception.toString()) ;
			}
		}

		return hmResult;

	}
}
