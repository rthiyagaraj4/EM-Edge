/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eST ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
//import java.util.Properties;
import eST.Common.StAdapter;
import eCommon.SingleTableHandler.SingleTableHandlerHome;
import eCommon.SingleTableHandler.SingleTableHandlerRemote;
import eCommon.Common.CommonRepository;
// import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
//import javax.servlet.http.HttpServletRequest;

public class TrnDocTypeBean extends StAdapter implements Serializable { 
	protected int RECORD_SIZE = Integer.parseInt((String)CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));  
	private String[] doc_type_code;
	private String[] trn_type;
	private String[] applicable_to_ph_yn;
	private String[] print_alert_reqd_yn;
	//private String	acc_entity_id ;

	public TrnDocTypeBean() {
		doc_type_code = new String [RECORD_SIZE];
		trn_type = new String [RECORD_SIZE];
		applicable_to_ph_yn = new String [RECORD_SIZE];
		print_alert_reqd_yn = new String [RECORD_SIZE];
	}

	public void setDoc_type_code(String doc_type,int index) {
		 this.doc_type_code[index]= doc_type;
	}

	public String getDoc_type_code(int index) {
		 return doc_type_code[index];
	}
	
	public void setApplicable_to_ph_yn(String applicable_to_ph_yn,int index) {
		 this.applicable_to_ph_yn[index]= checkForNull(applicable_to_ph_yn,"N");
	}

	public String getApplicable_to_ph_yn(int index) {
		 return applicable_to_ph_yn[index];
	}

	public void setPrint_alert_reqd_yn(String print_alert_reqd_yn,int index) {
		 this.print_alert_reqd_yn[index]= checkForNull(print_alert_reqd_yn,"N");
	}

	public String getPrint_alert_reqd_yn(int index) {
		 return print_alert_reqd_yn[index];
	}


	public void setTrn_type(String trn,int index) {
		 this.trn_type[index]= trn;
	}

	public String getTrn_type(int index) {
		 return trn_type[index];
	}

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		for (int index=0;index<RECORD_SIZE;index++) {
			String temp_doc_type_code = (String)htRecordSet.get("doc_type_code_"+index);
			String temp_trn_type = (String)htRecordSet.get("trn_type_"+index);
			String temp_applicable_to_ph_yn = (String)htRecordSet.get("applicable_to_ph_yn_"+index);
			String temp_print_alert_reqd_yn = (String)htRecordSet.get("print_alert_reqd_yn_"+index);
			if((temp_doc_type_code== null) || (temp_doc_type_code.equals(""))) {
				setDoc_type_code (null,index);
				setTrn_type (null,index);
				setApplicable_to_ph_yn (null,index);
				setPrint_alert_reqd_yn (null,index);
				continue; 
			}
			setDoc_type_code(temp_doc_type_code,index);
			setTrn_type(temp_trn_type,index);
			setApplicable_to_ph_yn(temp_applicable_to_ph_yn,index);
			setPrint_alert_reqd_yn(temp_print_alert_reqd_yn,index);
		}
	}

	public HashMap insert() {
		HashMap hmTableData		=	new HashMap();
		ArrayList alInsertData	=	new ArrayList();
		HashMap hmSQLMap		=	new HashMap();
		ArrayList alWhereData	=	new ArrayList();
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		for (int index=0;index<RECORD_SIZE;index++) {
			if (getDoc_type_code(index) == null || getDoc_type_code(index).equals("")) {
				continue;
			}
			java.util.ArrayList alInsertRecord = new java.util.ArrayList ();
			alInsertRecord.add(getLoginFacilityId());
			alInsertRecord.add(getDoc_type_code(index));
			alInsertRecord.add(getTrn_type(index));
			alInsertRecord.add(getApplicable_to_ph_yn(index));
			alInsertRecord.add(getLoginById());      
			alInsertRecord.add(getLoginAtWsNo());    
			alInsertRecord.add(getLoginFacilityId());
			alInsertRecord.add(getLoginById());      
			alInsertRecord.add(getLoginAtWsNo());    
			alInsertRecord.add(getLoginFacilityId());
			alInsertRecord.add(getPrint_alert_reqd_yn(index));
			alInsertData.add(alInsertRecord);
			ArrayList duplicateValue = new ArrayList();
			duplicateValue.add(getLoginFacilityId());
			duplicateValue.add(getDoc_type_code(index));
			alWhereData.add(duplicateValue);
		}
		hmSQLMap.put( "InsertSQL", getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_INSERT")	);
		hmSQLMap.put( "SelectSQL", getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_COUNT"));
		hmTableData.put( "properties", getProperties() );
		hmTableData.put( "WhereData", alWhereData);
		hmTableData.put( "InsertData", alInsertData);
		hmTableData.put("LanguageData",LanguageData);
/**/
		java.util.HashMap hmResult = new java.util.HashMap();
//SingleTableHandlerHome singleTableHandlerHome = null;
		SingleTableHandlerRemote	singleTableHandlerRemote	= null;

		try {
			/*InitialContext context = new InitialContext();
			Object object = context.lookup(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"));
			
			singleTableHandlerHome  = (SingleTableHandlerHome) PortableRemoteObject.narrow(object, SingleTableHandlerHome.class);
			singleTableHandlerRemote = singleTableHandlerHome.create();
			hmResult = singleTableHandlerRemote.singleBatchHandler(hmTableData, hmSQLMap);*/

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(eCommon.Common.CommonRepository.getCommonKeyValue("JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = hmTableData;
			argArray[1] = hmSQLMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = hmTableData.getClass(); 
			paramArray[1] = hmSQLMap.getClass();

			 hmResult = (HashMap)(busObj.getClass().getMethod("singleBatchHandler",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) hmResult.get( "result" )).booleanValue() )
				hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST") ) ;
			else{
				if( ((String)hmResult.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) ){
					String msgID = getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"Common")  ;
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
				hmResult.put("message", ee.toString());
			}
		}

		return hmResult;

/**/
//		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT_BATCH );
	}

	public HashMap modify() {
		HashMap hmTableData		=	new HashMap();
		ArrayList alModifyData	=	new ArrayList();
		HashMap hmSQLMap		=	new HashMap();

		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		alModifyData.add(getApplicable_to_ph_yn(0));
		alModifyData.add(getPrint_alert_reqd_yn(0));
		alModifyData.add(getLoginById());      
		alModifyData.add(getLoginAtWsNo());    
		alModifyData.add(getLoginFacilityId());
		alModifyData.add(getLoginFacilityId());
		alModifyData.add(getDoc_type_code(0));
	
		hmSQLMap.put( "ModifySQL", getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_UPDATE")	);
		hmTableData.put( "properties", getProperties() );
		hmTableData.put( "ModifyData", alModifyData);
		hmTableData.put("LanguageData",LanguageData);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE);
	}

	public HashMap validate() {
		return getMessageHashMap(true);
	}
	
	public String getDoc_type_code_List(){
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(getLoginFacilityId());
		arr_lang.add(getLanguageId());

		//return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_SY_DOC_TYPE_MASTER_SELECT_LIST"),arr_lang),getDoc_type_code(0));
		return getListOptionTag( getListOptionArrayList("SELECT   A.DOC_TYPE_CODE, B.SHORT_DESC FROM SY_DOC_TYPE_MASTER_DTL A, SY_DOC_TYPE_MASTER_LANG_VW B WHERE A.MODULE_ID = 'ST' AND A.DOC_TYPE_CODE = B.DOC_TYPE_CODE AND ((SUBSTR (A.DOC_TYPE_CODE, 1, 2) = ? AND B.ENTITY_OR_FACILITY_BASED = 'F' ) OR B.ENTITY_OR_FACILITY_BASED = 'E' ) AND B.STATUS IS NULL AND B.LANGUAGE_ID = ? ORDER BY 2, 1",arr_lang),getDoc_type_code(0));
		//return getListOptionTag( getListOptionArrayList("SELECT a.doc_type_code, b.short_desc FROM sy_doc_type_master_dtl a, sy_doc_type_master_lang_vw b, st_acc_entity_param D WHERE a.module_id = 'ST' AND a.doc_type_code = b.doc_type_code AND ((SUBSTR (a.doc_type_code, 1, 2) = ? AND b.entity_or_facility_based = 'F' ) OR b.entity_or_facility_based = 'E') AND b.status IS NULL AND b.language_id = ? AND ((a.doc_type_code NOT IN(SELECT a.doc_type_code doc_type_code FROM st_trn_doc_type a, sy_doc_type_master_lang_vw b,sy_acc_entity_doc_type c WHERE a.facility_id = ? AND a.doc_type_code = b.doc_type_code  AND a.trn_type = 'PRQ'  AND b.status IS NULL  AND a.doc_type_code = c.doc_type_code AND b.language_id = ?) OR a.doc_type_code IN(SELECT a.doc_type_code doc_type_code FROM st_trn_doc_type a, sy_doc_type_master_lang_vw b, sy_acc_entity_doc_type c  WHERE a.facility_id = ? AND a.doc_type_code = b.doc_type_code AND a.trn_type = 'PRQ' AND b.status IS NULL  AND a.doc_type_code = c.doc_type_code AND b.language_id = ?) AND d.ACC_ENTITY_ID=? and d.INTERFACE_TO_EXTERNAL_PO_YN='Y'))" ,arr_lang),getDoc_type_code(0));
	}
	public String getTrn_type_List(){
		String interface_to_external_po_yn	=	"N";
		try{
			interface_to_external_po_yn	= checkForNull((String)fetchRecord("SELECT NVL (INTERFACE_TO_EXTERNAL_PO_YN, 'N') INTERFACE_TO_EXTERNAL_PO_YN FROM ST_ACC_ENTITY_PARAM WHERE ACC_ENTITY_ID = ?",getAcc_entity_id()).get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");
		}catch(Exception e){
			e.printStackTrace();
		}

		if(interface_to_external_po_yn.equals("N")){
			return getListOptionTag( getListOptionArrayList("SELECT TRN_TYPE, LONG_DESC, SHORT_DESC FROM ST_TRN_TYPE_LANG_VW ST_TRN_TYPE WHERE TRN_TYPE NOT IN('REQ','PRQ') AND LANGUAGE_ID = ?",getLanguageId()), getTrn_type(0));
		}else{
			return getListOptionTag( getListOptionArrayList("SELECT TRN_TYPE, LONG_DESC, SHORT_DESC FROM ST_TRN_TYPE_LANG_VW ST_TRN_TYPE WHERE TRN_TYPE NOT IN('REQ') AND LANGUAGE_ID = ?",getLanguageId()), getTrn_type(0));
		}
		//return getListOptionTag( getListOptionArrayList("select trn_type, long_desc, short_desc FROM st_trn_type_lang_vw st_trn_type,st_acc_entity_param d where trn_type not in('REQ') AND language_id = ? AND ((trn_type NOT IN('PRQ') OR trn_type = 'PRQ' AND d.ACC_ENTITY_ID=? and d.INTERFACE_TO_EXTERNAL_PO_YN='Y')) ORDER BY 2",arr_lang), getTrn_type(0));
	}
	public void clear() {
		super.clear();
		for (int i=0;i<RECORD_SIZE;i++) {
			doc_type_code[i]		=	null; 
			trn_type[i]				=	null; 
			applicable_to_ph_yn[i]	=	"Y"; 
			print_alert_reqd_yn[i]	=	"Y"; 
		}
	}

	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
		String []stParameters	=	{getLoginFacilityId(),getDoc_type_code(0)};
		HashMap hmRecord		=	null;
		hmRecord = fetchRecord(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_SINGLE"), stParameters);
		setTrn_type ((String)hmRecord.get("TRN_TYPE"),0);
		setApplicable_to_ph_yn ((String)hmRecord.get("APPLICABLE_TO_PH_YN"),0);
		setPrint_alert_reqd_yn ((String)hmRecord.get("ALERT_REQD_YN"),0);
	}

	public String toString(){
		return 	"|doc_type_code:"	+doc_type_code[0]+	"||trn_type:"+trn_type[0];
	}
}
