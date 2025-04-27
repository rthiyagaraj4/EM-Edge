/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
	/**
	  *Developed by		:	Manish Anand
	  *Created on		:	Tuesday, December 10, 2002
	  *Last Modified on	:	Friday, January 03, 2003
	  *Module			:	eSS
	  *Function			:	Java Bean for Usage Type
	  */

package eSS ;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import eSS.Common.SsAdapter;
import eCommon.SingleTableHandler.*;
import eCommon.Common.CommonRepository;

public class TrnDocTypeBean extends SsAdapter implements Serializable { 
	protected int RECORD_SIZE = Integer.parseInt((String)CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));  
	private String[] doc_type_code;
	private String[] trn_type;
	private String[] print_alert_reqd_yn;//Added by Badmavathi against AAKH-CRF-0057 Inc 51898

	private java.util.ArrayList alTrnType;
	private java.util.ArrayList alDocType;

	public TrnDocTypeBean() {
		doc_type_code = new String [RECORD_SIZE];
		trn_type = new String [RECORD_SIZE];
		print_alert_reqd_yn = new String [RECORD_SIZE];
	}

	public void setDoc_type_code(String doc_type,int index) {
		 this.doc_type_code[index]= doc_type;
	}

	public String getDoc_type_code(int index) {
		 return doc_type_code[index];
	}

	public void setTrn_type(String trn,int index) {
		 this.trn_type[index]= trn;
	}

	public String getTrn_type(int index) {
		 return trn_type[index];
	}
	//Added by Badmavathi against AAKH-CRF-0057 Inc 51898
	public void setPrint_alert_reqd_yn(String print_alert_reqd_yn,int index) {
		 this.print_alert_reqd_yn[index]= checkForNull(print_alert_reqd_yn,"N");
	}

	public String getPrint_alert_reqd_yn(int index) {
		 return print_alert_reqd_yn[index];
	}
	//Added ends
	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		for (int index=0;index<RECORD_SIZE;index++) {

			String temp_doc_type_code = (String)htRecordSet.get("doc_type_code_"+index);
			String temp_trn_type = (String)htRecordSet.get("trn_type_"+index);
			String temp_print_alert_reqd_yn = (String)htRecordSet.get("print_alert_reqd_yn_"+index);//Added by Badmavathi against Commented by Badmavathi against AAKH-CRF-0057 Inc 51898
			if((temp_doc_type_code== null) || (temp_doc_type_code.equals(""))) {
				setDoc_type_code (null,index);
				setTrn_type (null,index);
				setPrint_alert_reqd_yn (null,index);
				continue; 
			}
			setDoc_type_code(temp_doc_type_code,index);
			setTrn_type(temp_trn_type,index);
			setPrint_alert_reqd_yn(temp_print_alert_reqd_yn,index);//Added by Badmavathi against Commented by Badmavathi against AAKH-CRF-0057 Inc 51898
		}
	}

	public HashMap insert() {
		HashMap hmTableData	=	new HashMap();
		ArrayList	 alInsertData=	new ArrayList();
		HashMap hmSQLMap	=	new HashMap();
		ArrayList	 alWhereData	=	new ArrayList();

		for (int index=0;index<RECORD_SIZE;index++) {
			
			if (getDoc_type_code(index) == null || getDoc_type_code(index).equals("")) {
				continue;
			}
			
					java.util.ArrayList alInsertRecord = new java.util.ArrayList ();

			
			alInsertRecord.add(getLoginFacilityId());
			alInsertRecord.add(getDoc_type_code(index));
			alInsertRecord.add(getTrn_type(index));

			alInsertRecord.add(getLoginById());      
			alInsertRecord.add(getLoginAtWsNo());    
			alInsertRecord.add(getLoginFacilityId());
			alInsertRecord.add(getLoginById());      
			alInsertRecord.add(getLoginAtWsNo());    
			alInsertRecord.add(getLoginFacilityId());
			alInsertRecord.add(getPrint_alert_reqd_yn(index));
			alInsertData.add(alInsertRecord);  

			ArrayList duplicateValue = new ArrayList();
			duplicateValue.add(login_facility_id);
			duplicateValue.add(getDoc_type_code(index));
			alWhereData.add(duplicateValue);
		}
		hmSQLMap.put( "InsertSQL", getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_INSERT")	); 
		hmSQLMap.put( "SelectSQL", getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_COUNT"));  
 		hmTableData.put( "properties", getProperties() );
		hmTableData.put( "WhereData", alWhereData);
		hmTableData.put( "InsertData", alInsertData); // to be changed

		java.util.HashMap hmResult = new java.util.HashMap();

		SingleTableHandlerRemote	singleTableHandlerRemote	= null;

		try {
			Object home					=			com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj				=			(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]			=			new Object[2];
			argArray[0]					=			hmTableData;
			argArray[1]					=			hmSQLMap;

			Class [] paramArray			=			new Class[2];
			paramArray[0]				=			hmTableData.getClass(); 
			paramArray[1]				=			hmSQLMap.getClass();
			
			 hmResult					=			(HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);
			
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
	

			if( ((Boolean) hmResult.get( "result" )).booleanValue() )

				hmResult.put( "message", getMessage(getLanguageId(),(String)hmResult.get("msgid"),"SS") ) ;
			else{
				if( ((String)hmResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"Common")  ;
					msgID = msgID.substring(0,(msgID.indexOf("<br>")));
					hmResult.put( "message", msgID);
					ArrayList tempInvaliCode = (ArrayList)hmResult.get("invalidCode");
					for (int index=0;index<tempInvaliCode.size();index++) {
						((java.util.ArrayList)tempInvaliCode.get(index)).remove(0);
					}
					hmResult.put( "invalidCode", delimitedString(tempInvaliCode));
				} 
				else{
					hmResult.put( "message", (hmResult.get("msgid"))) ;
				}
			}
			
			
		}
		catch(Exception e) {
			
			hmResult.put("message", e.toString());
			e.printStackTrace();
		} 
		finally {
			try {
				if(singleTableHandlerRemote != null)
					singleTableHandlerRemote.remove();
			}
			catch(Exception ee) {
				System.err.println("Exceptions : SSM" +ee.getMessage());
				hmResult.put("message", ee.toString());
			}
		}
		
		return hmResult;

	}

/*	public HashMap modify() {	Commented by Badmavathi against AAKH-CRF-0057 Inc 51898
		HashMap		hmReturn	=	new HashMap()	;
		hmReturn.put("result",new Boolean(false));
		hmReturn.put("msgid","MODIFICATION_NOT_ALLOWED");
		hmReturn.put("message",getMessage(getLanguageId(),(String)hmReturn.get("msgid"),"SS"));
		return hmReturn;
	}	
	
*/
//Added by Badmavathi against Commented by Badmavathi against AAKH-CRF-0057 Inc 51898
	public HashMap modify() {
		HashMap hmTableData		=	new HashMap();
		ArrayList alModifyData	=	new ArrayList();
		HashMap hmSQLMap		=	new HashMap();

		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		//alModifyData.add(getApplicable_to_ph_yn(0)); Commented by Badmavathi against AAKH-CRF-0057 Inc 51898
		alModifyData.add(getPrint_alert_reqd_yn(0));
		alModifyData.add(getLoginById());      
		alModifyData.add(getLoginAtWsNo());    
		alModifyData.add(getLoginFacilityId());
		alModifyData.add(getLoginFacilityId());
		alModifyData.add(getDoc_type_code(0));
	
		hmSQLMap.put( "ModifySQL", getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_UPDATE")	);
		hmTableData.put( "properties", getProperties() );
		hmTableData.put( "ModifyData", alModifyData);
		hmTableData.put("LanguageData",LanguageData);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public String getDoc_type_code_List(){
		ArrayList arr_lang=new ArrayList();
	    arr_lang.add(getLoginFacilityId());
	    arr_lang.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_LIST"),arr_lang),getDoc_type_code(0));
	}

	public String getTrn_type_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRN_TYPE_SELECT_LIST"),getLanguageId()), getTrn_type(0));
	}

	public void loadMultipleList(){
		alDocType = getListOptionArrayList(getSsRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_LIST"),login_facility_id);
		alTrnType = getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRN_TYPE_SELECT_LIST"));
	}
	
	public String getMultipleTrn_type_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRN_TYPE_SELECT_LIST"),getLanguageId()), getTrn_type(0));

	}

	public String getMultipleDoc_type_List(){
		ArrayList arr_lang=new ArrayList();
	    arr_lang.add(getLoginFacilityId());
	    arr_lang.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_LIST"),arr_lang),getDoc_type_code(0));

	}

	public void clear() {
		super.clear();
		for (int i=0;i<RECORD_SIZE;i++) {
			doc_type_code[i] =	null; 
			trn_type[i] =	null;
			print_alert_reqd_yn[i]	=	"Y";	//Added by Badmavathi against Commented by Badmavathi against AAKH-CRF-0057 Inc 51898
		}
	}

	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
		String []stParameters	=	{getLoginFacilityId(),getDoc_type_code(0)};
		HashMap hmRecord		=	null;
		hmRecord = fetchRecord(getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_SELECT_SINGLE"), stParameters);
		setTrn_type ((String)hmRecord.get("TRN_TYPE"),0);
		setPrint_alert_reqd_yn ((String)hmRecord.get("ALERT_REQD_YN"),0);	//Added by Badmavathi against Commented by Badmavathi against AAKH-CRF-0057 Inc 51898
	}

	public String paramsInBean(){
		return 	"|doc_type_code:"	+doc_type_code[0]+	"||trn_type:"+trn_type[0];
	}
}
