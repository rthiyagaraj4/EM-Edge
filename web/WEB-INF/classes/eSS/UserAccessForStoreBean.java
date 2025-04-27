/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS;

import java.util.ArrayList;
import java.sql.Connection;
import eCommon.SingleTableHandler.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Hashtable;
import eSS.Common.SsTransaction;
import eSS.Common.SsRepository;
import eCommon.Common.CommonRepository;
import java.util.Properties;
import eSS.UserAccessForStore.*;
import java.io.Serializable;


public class UserAccessForStoreBean extends SsTransaction  implements Serializable {

	private ArrayList arrStoreList	=	null;
	private ArrayList record_insertList = null;
	private ArrayList record_updateList = null;
	private	Hashtable hmInsertNextPrev  = null;
	private	Hashtable hmUpdateNextPrev  = null;

	public UserAccessForStoreBean() {
		arrStoreList = new java.util.ArrayList(); 
		record_insertList = new java.util.ArrayList(); 
		record_updateList = new java.util.ArrayList();
		hmInsertNextPrev  =	new Hashtable();
		hmUpdateNextPrev  = new Hashtable();

	}


	public void clear() {
		arrStoreList.clear();
		record_insertList.clear();
		record_updateList.clear();
		hmInsertNextPrev.clear();
		hmUpdateNextPrev.clear();
	}

	public void setAllNext(java.util.Hashtable htResult) {

		int total_no_rows = Integer.parseInt((String)htResult.get("arr_size"));
 		setMode((String) htResult.get("mode"));
		for (int t=0; t<total_no_rows;t++ ) {
			ArrayList user_access_data = new ArrayList();
			String check=(String) htResult.get("check_"+t);
			if(check.equals("Y")) {
				user_access_data.add(checkForNull((String) htResult.get("user_id"),""));
				user_access_data.add(checkForNull((String) htResult.get("store_id_"+t),""));  
				user_access_data.add(checkForNull((String) htResult.get("pre_allowed_yn_"+t),"N"));      
				user_access_data.add(checkForNull((String) htResult.get("req_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("iss_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rtg_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rti_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("trd_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("adj_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("var_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rof_allowed_yn_"+t),"N"));

				//Added By Sakti Sankar against CRF#222
				user_access_data.add(checkForNull((String) htResult.get("iss_ack_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("iss_conf_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("ret_ack_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("ret_conf_allowed_yn_"+t),"N"));//Added by Sakti against PMG2014-CRF-0008
				//user_access_data.add("N"); //Return_confirm_yn
				//Added ends
				//Inc32071	Bru-HIMS-CRF-225	BY GANGA
				user_access_data.add(checkForNull((String) htResult.get("rql_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("isl_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rtl_allowed_yn_"+t),"N"));//Inc32071	Bru-HIMS-CRF-225	BY GANGA
				//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				user_access_data.add(checkForNull((String) htResult.get("rqv_allowed_yn_"+t),"N")); 
				user_access_data.add(checkForNull((String) htResult.get("rqv_ack_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rtv_allowed_yn_"+t),"N"));
				//Added ends 
				//Added By Sakti Sankar against CRF#225.1
				user_access_data.add(checkForNull((String) htResult.get("isl_ack_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("isl_conf_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rtl_ack_allowed_yn_"+t),"N"));

				user_access_data.add(checkForNull(login_by_id,""));      
				user_access_data.add(checkForNull(login_at_ws_no,""));   
				user_access_data.add(checkForNull(login_facility_id,""));
				user_access_data.add(checkForNull(login_by_id,""));       
				user_access_data.add(checkForNull(login_at_ws_no,""));    
				user_access_data.add(checkForNull(login_facility_id,"")); 
				record_insertList.add(htResult.get("store_id_"+t));
				hmInsertNextPrev.put(htResult.get("store_id_"+t) ,user_access_data);
			}
			else if(check.equals("U")) {
				user_access_data.add(checkForNull((String) htResult.get("pre_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("req_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("iss_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rtg_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rti_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("trd_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("adj_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("var_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rof_allowed_yn_"+t),"N"));

				//Added By Sakti Sankar against CRF#222
				user_access_data.add(checkForNull((String) htResult.get("iss_ack_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("iss_conf_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("ret_ack_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("ret_conf_allowed_yn_"+t),"N")); //Added by Sakti against PMG2014-CRF-0008
				//user_access_data.add("N"); //Return_confirm_yn
				//Added ends
				//Inc32071	Bru-HIMS-CRF-225	BY GANGA
				user_access_data.add(checkForNull((String) htResult.get("rql_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("isl_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rtl_allowed_yn_"+t),"N"));//Inc32071	Bru-HIMS-CRF-225	BY GANGA
				//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 13-07-2015
				user_access_data.add(checkForNull((String) htResult.get("rqv_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rqv_ack_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rtv_allowed_yn_"+t),"N"));
				//Added ends 
				//Added By Sakti Sankar against CRF#225.1
				user_access_data.add(checkForNull((String) htResult.get("isl_ack_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("isl_conf_allowed_yn_"+t),"N"));
				user_access_data.add(checkForNull((String) htResult.get("rtl_ack_allowed_yn_"+t),"N"));

				user_access_data.add(checkForNull(login_by_id,""));
				user_access_data.add(checkForNull(login_at_ws_no,""));
				user_access_data.add(checkForNull(login_facility_id,""));
				user_access_data.add(checkForNull((String) htResult.get("user_id"),""))			;
				user_access_data.add(checkForNull((String) htResult.get("store_id_"+t),""))		;
				record_updateList.add(htResult.get("store_id_"+t));
               // System.err.println("record_insertList"+record_insertList);
				hmUpdateNextPrev.put(htResult.get("store_id_"+t) ,user_access_data);
			}	
			else {	
				if (record_insertList.contains(htResult.get("store_id_"+t))) {
				int x=record_insertList.indexOf(htResult.get("store_id_"+t));
				record_insertList.remove(x);
				hmInsertNextPrev.remove(htResult.get("store_id_"+t));
				}
			}
		}
	}

	public ArrayList isInlist(String store_ck_code)
	{
		if((ArrayList) hmInsertNextPrev.get(store_ck_code)==null)
		return (ArrayList) hmUpdateNextPrev.get(store_ck_code);
		else
		return (ArrayList) hmInsertNextPrev.get(store_ck_code);
	}

	public void setAll(java.util.Hashtable htResult) { 
		setAllNext(htResult);		
	}

	public java.util.HashMap insert() {
		
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		Properties properties = getProperties();
		hmTableData.put("properties",properties );
		
		hmResult.put("result", new Boolean(false)) ;
		try {

			ArrayList insertDataList = new ArrayList();
			ArrayList updateDataList = new ArrayList();
			
			java.util.Enumeration inshashKeys;
			java.util.Enumeration updhashKeys;

			inshashKeys= hmInsertNextPrev.keys();
			while(inshashKeys.hasMoreElements()) {
				insertDataList.add(hmInsertNextPrev.get(inshashKeys.nextElement()));
			}
			hmSQLMap.put("InsertSQL", SsRepository.getSsKeyValue("SQL_SS_USER_ACCESS_FOR_STORE_INSERT"));
			hmTableData.put("InsertData",insertDataList);

			updhashKeys= hmUpdateNextPrev.keys();
			while(updhashKeys.hasMoreElements()) {
				updateDataList.add(hmUpdateNextPrev.get(updhashKeys.nextElement()));
			}
 			hmSQLMap.put("UpdateSQL", SsRepository.getSsKeyValue("SQL_SS_USER_ACCESS_FOR_STORE_UPDATE"));
			hmTableData.put("UpdateData",updateDataList );  

		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_USER_ACCESS_FOR_STORE"),UserAccessForStoreHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if(((Boolean) hmResult.get("result")).booleanValue())
			{
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			}
			else{
				if(((String) hmResult.get("msgid")).equals("CODE_ALREADY_EXISTS"))
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"Common")) ;
				else
					hmResult.put("message", (hmResult.get("msgid")));
			}
		} 
		catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		clear();
return hmResult;
	
	}


	
	    public java.util.HashMap modify() {
		HashMap hmResult	=	new HashMap();
		HashMap hmTableData = new HashMap();
		HashMap hmSQLMap = new HashMap();
		Properties properties = getProperties();
		hmTableData.put("properties",properties );
		
		hmResult.put("result", new Boolean(false)) ;
		try {

			ArrayList updateDataList = new ArrayList();
			
			java.util.Enumeration updhashKeys;


             updhashKeys= hmUpdateNextPrev.keys();
			while(updhashKeys.hasMoreElements()) {
				updateDataList.add(hmUpdateNextPrev.get(updhashKeys.nextElement()));
			}
 			hmSQLMap.put("UpdateSQL", SsRepository.getSsKeyValue("SQL_SS_USER_ACCESS_FOR_STORE_UPDATE"));
			hmTableData.put("UpdateData",updateDataList ); 
		}
		 catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		}
		try {

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(getSsRepositoryValue("JNDI_USER_ACCESS_FOR_STORE"),UserAccessForStoreHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;
			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if(((Boolean) hmResult.get("result")).booleanValue())
			hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"SS")) ;
			else{
				if(((String) hmResult.get("msgid")).equals("CODE_ALREADY_EXISTS"))
				hmResult.put("message", getMessage(getLanguageId(),(String) hmResult.get("msgid"),"Common")) ;
				else
					hmResult.put("message", (hmResult.get("msgid")));
			}
		} 
		catch(Exception e) {
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
	clear();
	return hmResult;
	
}
	public HashMap validate(){
		HashMap hmReturn	=	new HashMap();
		hmReturn.put("result",new Boolean(true));
		hmReturn.put("message","");
		return hmReturn;
		}

//Modified By Sakti Sankar on 06/12/2012 against CFR#222
	public Boolean getAckReqdForIssueGroup(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT ISS_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("ISS_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}
	public Boolean getAckReqdForReturnGroup(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT RET_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("RET_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}
//Added ends
	
	//Modified By Sakti Sankar on 24/02/2014 against CFR#225.1
		public Boolean getAckReqdForLoanIssueGroup(){
			String ack_reqd = "N";
			try{
				ack_reqd = (String)fetchRecord("SELECT ISL_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("ISL_ACK_REQ_YN");
			}catch(Exception e){
				e.printStackTrace();
			}
			return checkForNull(ack_reqd,"N").equals("Y");
		}
		public Boolean getAckReqdForLoanReturnGroup(){
			String ack_reqd = "N"; 
			try{
				ack_reqd = (String)fetchRecord("SELECT RTL_ACK_REQ_YN FROM SS_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("RTL_ACK_REQ_YN");
			}catch(Exception e){
				e.printStackTrace();
			}
			return checkForNull(ack_reqd,"N").equals("Y");
		}
	//Added ends
		
}

