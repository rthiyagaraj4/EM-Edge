/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package ePO ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import ePO.Common.*;
import java.sql.*;
import javax.sql.*;
import eCommon.Common.*;

public class ParameterBean extends PoAdapter implements Serializable { 

	private String def_store_code_for_rec;
	private String def_purchase_dept;
	private String dflt_item_search;
	
	private String rec_str_as_req_str_yn;
	private String recqv_is_ne_poqv;
	private String totGRN_is_mt_totPO;
	private String grndt_eq_PO_deldt_yn;
	private String doc_no_generate_yn;

	private String itmLvlOrdApReq_yn;
	private String alowOvOrDelDt;
	private String alowOvOrQtRe;
	private	String alowOvOrPrRe;
	private	String hdr_remarks1;
	private	String hdr_remarks2;
	
	private String budgetCheckReq_yn;

	private	String po_reqd_for_do_yn;
	private	String allow_chage_to_do_price_yn;
	
	
	
	public void setDef_store_code_for_rec(String def_store_code_for_rec) {
		 this.def_store_code_for_rec = checkForNull(def_store_code_for_rec);
	}

	public String getDef_store_code_for_rec( ) {
		 return def_store_code_for_rec;
	}
	
	public void setDef_purchase_dept(String def_purchase_dept) {
		 this.def_purchase_dept = checkForNull(def_purchase_dept);
	}

	public String getDef_purchase_dept( ) {
		 return def_purchase_dept;
	}
	
	/*public void setDflt_item_search(String dflt_item_search) {
		 this.dflt_item_search = checkForNull(dflt_item_search);
	}
		
	public String getDflt_item_search() {
		 return dflt_item_search;
	}*/




	public void setItmLvlOrdApReq_yn(String itmLvlOrdApReq_yn) {
		 this.itmLvlOrdApReq_yn = checkForNull(itmLvlOrdApReq_yn,"N");
	}

	public String getItmLvlOrdApReq_yn( ) {
		 return itmLvlOrdApReq_yn;
	}
	
	public void setBudgetCheckReq_yn(String budgetCheckReq_yn) {
		 this.budgetCheckReq_yn = checkForNull(budgetCheckReq_yn,"N");
	}

	public String getBudgetCheckReq_yn( ) {
		 return budgetCheckReq_yn;
	}

	
	public void setAlowOvOrDelDt(String alowOvOrDelDt) {
		 this.alowOvOrDelDt = checkForNull(alowOvOrDelDt,"N");
	}
		
	public String getAlowOvOrDelDt() {
		 return alowOvOrDelDt;
	}

	
	public void setAlowOvOrQtRe(String alowOvOrQtRe) {
		 this.alowOvOrQtRe = checkForNull(alowOvOrQtRe,"N");
	}
		
	public String getAlowOvOrQtRe() {
		 return alowOvOrQtRe;
	}
	public void setAlowOvOrPrRe(String alowOvOrPrRe) {
		 this.alowOvOrPrRe = checkForNull(alowOvOrPrRe,"N");
	}

	public String getAlowOvOrPrRe( ) {
		 return alowOvOrPrRe;
	}

	public void setHdr_remarks1(String hdr_remarks1) {
		 this.hdr_remarks1 = checkForNull(hdr_remarks1);
	}

	public String getHdr_remarks1( ) {
		 return hdr_remarks1;
	}

	public void setHdr_remarks2(String hdr_remarks2) {
		 this.hdr_remarks2 = checkForNull(hdr_remarks2);
	}

	public String getHdr_remarks2( ) {
		 return hdr_remarks2;
	}

	//Added By Sakti on 04/01/2013 against Inc#30079

	public void setPo_reqd_for_do_yn(String po_reqd_for_do_yn) {
		 this.po_reqd_for_do_yn = checkForNull(po_reqd_for_do_yn,"N");
	}

	public String getPo_reqd_for_do_yn( ) {
		 return po_reqd_for_do_yn;
	}
	
	public void setAllow_chage_to_do_price_yn(String allow_chage_to_do_price_yn) {
		 this.allow_chage_to_do_price_yn = checkForNull(allow_chage_to_do_price_yn,"N");
	}

	public String getAllow_chage_to_do_price_yn( ) {
		 return allow_chage_to_do_price_yn;
	}
	//Added ends


	/*public void setDoc_no_generate_yn(String doc_no_generate_yn) {
		 this.doc_no_generate_yn = checkForNull(doc_no_generate_yn,"A");
	}
		
	public String getDoc_no_generate_yn() {
		 return doc_no_generate_yn;
	}*/
	
	public void setAll(Hashtable htRecordSet){
	
		super.setAll(htRecordSet);
		setItmLvlOrdApReq_yn((String) htRecordSet.get("itmLvlOrdApReq_yn"));
		setBudgetCheckReq_yn((String) htRecordSet.get("budgetCheckReq_yn"));
		setAlowOvOrDelDt((String) htRecordSet.get("alowOvOrDelDt"));
		setAlowOvOrQtRe((String) htRecordSet.get("alowOvOrQtRe"));
		setAlowOvOrPrRe((String) htRecordSet.get("alowOvOrPrRe"));
		setHdr_remarks1((String) htRecordSet.get("hdr_remarks1"));
		setHdr_remarks2((String) htRecordSet.get("hdr_remarks2"));

		setPo_reqd_for_do_yn((String) htRecordSet.get("po_reqd_for_do_yn"));
		setAllow_chage_to_do_price_yn((String) htRecordSet.get("allow_chage_to_do_price_yn"));
	}

	

	public void clear(){
		super.clear();
		def_store_code_for_rec="";
		def_purchase_dept="";
		dflt_item_search = ""; 
		doc_no_generate_yn="";

		rec_str_as_req_str_yn="";
		recqv_is_ne_poqv="";
		totGRN_is_mt_totPO="";
		grndt_eq_PO_deldt_yn = "";

		itmLvlOrdApReq_yn="";
		budgetCheckReq_yn = "";
		alowOvOrDelDt="";
		alowOvOrQtRe="";
		alowOvOrPrRe = "";
		hdr_remarks1 = "";
		hdr_remarks2 = "";
		po_reqd_for_do_yn = "";
		allow_chage_to_do_price_yn = "";
	}

	public HashMap insert() {

		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		alInsertData.add(getItmLvlOrdApReq_yn      ());
		alInsertData.add(getAlowOvOrDelDt      ());
		alInsertData.add(getAlowOvOrQtRe      ());
		alInsertData.add(getAlowOvOrPrRe      ());
		alInsertData.add(getHdr_remarks1      ());
		alInsertData.add(getHdr_remarks2      ());
		
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		
		alInsertData.add(getBudgetCheckReq_yn());

		alInsertData.add(getPo_reqd_for_do_yn());
		alInsertData.add(getAllow_chage_to_do_price_yn());

		hmSQLMap.put( "InsertSQL", getPoRepositoryValue("SQL_PO_PARAM_INSERT"));
		hmSQLMap.put( "SelectSQL", getPoRepositoryValue("SQL_PO_PARAM_COUNT"));

		
		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
		hmTableData.put("LanguageData",LanguageData);
		
		System.out.println("hmTableData = "+hmTableData);
		System.out.println("hmSQLMap = "+hmSQLMap);
		
		return callSingleTableHandler(hmTableData, hmSQLMap, PoRepository.SINGLE_INSERT);
	}

	public HashMap modify() {
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());


		alModifyData.add(getItmLvlOrdApReq_yn      ());
		alModifyData.add(getAlowOvOrDelDt      ());
		alModifyData.add(getAlowOvOrQtRe      ());
		alModifyData.add(getAlowOvOrPrRe      ());
		alModifyData.add(getHdr_remarks1      ());
		alModifyData.add(getHdr_remarks2      ());
		
		alModifyData.add(getLoginById());      
		alModifyData.add(getLoginAtWsNo());    
		alModifyData.add(getLoginFacilityId());
		
		alModifyData.add(getBudgetCheckReq_yn());

		alModifyData.add(getPo_reqd_for_do_yn());
		alModifyData.add(getAllow_chage_to_do_price_yn());

		hmSQLMap.put( "ModifySQL", getPoRepositoryValue("SQL_PO_PARAM_UPDATE"));
		
		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);
		hmTableData.put("LanguageData",LanguageData);

		System.out.println("hmTableData in modify = "+hmTableData);
		System.out.println("hmSQLMap = "+hmSQLMap);

		return callSingleTableHandler(hmTableData, hmSQLMap, PoRepository.SINGLE_UPDATE );
	}

	public boolean recordExists() throws Exception{
		//String poParameters[]={getModuleId()};
		HashMap hmResult = fetchRecord(getPoRepositoryValue("SQL_PO_PARAM_COUNT"));
		return !((String)hmResult.get("TOTAL")).equals("0");
	}

	public String getDef_store_code_for_rec_List(){
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getPoRepositoryValue("SQL_ST_PO_STORE_SELECT_LIST_GRN"),alParameters), getDef_store_code_for_rec());
	}

	public String getDef_purchase_dept_List(){
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		//alParameters.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getPoRepositoryValue("SQL_ST_PO_PURCHASE_DEPT_SELECT_LIST"),alParameters), getDef_purchase_dept());
	}
	
	
	/* Function specific methods start */
	public void loadData() throws Exception {
		//String []poParameters=	{getModuleId()};
		HashMap hmRecord	=	null;
		
		hmRecord	=	fetchRecord("SELECT	ITEM_LEVEL_ORDER_APPROVAL, ALLOW_OVERRIDE_PO_DLVDT, ALLOW_QTY_OVERRIDE_IN_GRN,ALLOW_PRICE_OVERRIDE_IN_GRN,HEADER_REMARKS1,HEADER_REMARKS2, BUDGET_CHECK_REQD_YN,PO_REQD_FOR_DO,ALLOW_CHAGE_TO_DO_PRICE FROM PO_PARAMETER" );
		
		
		setItmLvlOrdApReq_yn ( (String)hmRecord.get("ITEM_LEVEL_ORDER_APPROVAL")) ; 
		setAlowOvOrDelDt		  ( (String)hmRecord.get("ALLOW_OVERRIDE_PO_DLVDT")) ; 
		setAlowOvOrQtRe     ( checkForNull((String)hmRecord.get("ALLOW_QTY_OVERRIDE_IN_GRN" )	)) ;
		setAlowOvOrPrRe     ( checkForNull((String)hmRecord.get("ALLOW_PRICE_OVERRIDE_IN_GRN" )	)) ;
		setHdr_remarks1     ( checkForNull((String)hmRecord.get("HEADER_REMARKS1" )	)) ;
		setHdr_remarks2     ( checkForNull((String)hmRecord.get("HEADER_REMARKS2" )	)) ;
		setBudgetCheckReq_yn ( (String)hmRecord.get("BUDGET_CHECK_REQD_YN")) ; 

		setPo_reqd_for_do_yn ( (String)hmRecord.get("PO_REQD_FOR_DO")) ; 
		setAllow_chage_to_do_price_yn ( (String)hmRecord.get("ALLOW_CHAGE_TO_DO_PRICE")) ; 

	}

	
	public String toString(){
		return "ParameterBean";
	}

	public String getDflt_search_item() {
		String []stParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT	DFLT_ITEM_SEARCH FROM	st_facility_param WHERE facility_id=?", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return (String)hmRecord.get("DFLT_ITEM_SEARCH");
	}
	
	
	public HashMap validate() {
		System.out.println("validate");
		HashMap hmReturn = new HashMap() ;
		hmReturn.put("result", new Boolean( true ) ) ;
		hmReturn.put("message", "success, mode="+getMode() ) ;
		System.out.println("hmReturn validate = "+hmReturn);
		return hmReturn ;
	}
}


