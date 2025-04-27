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
//pmd 19/02/2005
//import java.util.Properties;
import eST.Common.*;
import java.sql.*;
import javax.sql.*;
import eCommon.Common.*;

public class StDefineBarcodeRulesBean extends StAdapter implements Serializable { 

	private String barcode_gen_rule;
	private String item_yn;
	private String batch_id_yn;
	private String expiry_dt_yn;
	private String facility_id_yn;
	private String trade_id_yn;
	private String mfg_id_yn;
	private String supp_id_yn;
	private String store_code_yn;
	private String bin_locn_yn;
	private String mrp_yn;
	private String barcode_seq;
	

	
  //  private String language_id;

	public void setBarcode_gen_rule(String barcode_gen_rule) {
		 this.barcode_gen_rule = checkForNull(barcode_gen_rule);
	}

	public String getBarcode_gen_rule( ) {
		 return barcode_gen_rule;
	}
	/*	public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}
*/
public void setItem_yn(String item_yn) {
		 this.item_yn = checkForNull(item_yn);
	}

	public String getItem_yn( ) {
		 return item_yn;
	}

	public void setBatch_id_yn(String batch_id_yn) {
		 this.batch_id_yn = checkForNull(batch_id_yn);
	}

	public String getBatch_id_yn( ) {
		 return batch_id_yn;
	}

	public void setExpiry_dt_yn(String expiry_dt_yn) {
		 this.expiry_dt_yn = checkForNull(expiry_dt_yn);
	}

	public String getExpiry_dt_yn( ) {
		 return expiry_dt_yn;
	}
	
	public void setFacility_id_yn(String facility_id_yn) {
		 this.facility_id_yn = checkForNull(facility_id_yn);
	}

	public String getFacility_id_yn( ) {
		 return facility_id_yn;
	}

	public void setTrade_id_yn(String trade_id_yn) {
		 this.trade_id_yn = checkForNull(trade_id_yn);
	}

	public String getTrade_id_yn( ) {
		 return trade_id_yn;
	}

	public void setMfg_id_yn(String mfg_id_yn) {
		 this.mfg_id_yn = checkForNull(mfg_id_yn);
	}

	public String getMfg_id_yn( ) {
		 return mfg_id_yn;
	}

	public void setSupp_id_yn(String supp_id_yn) {
		 this.supp_id_yn = checkForNull(supp_id_yn);
	}

	public String getSupp_id_yn( ) {
		 return supp_id_yn;
	}

	public void setStore_code_yn(String store_code_yn) {
		 this.store_code_yn = checkForNull(store_code_yn);
	}

	public String getStore_code_yn( ) {
		 return store_code_yn;
	}

	public void setBin_locn_yn(String bin_locn_yn) {
		 this.bin_locn_yn = checkForNull(bin_locn_yn);
	}

	public String getBin_locn_yn( ) {
		 return bin_locn_yn;
	}

	public void setMrp_yn(String mrp_yn) {
		 this.mrp_yn = checkForNull(mrp_yn);
	}

	public String getMrp_yn() {
		 return mrp_yn;
	}

	public void setBarcode_seq(String barcode_seq) {
		 this.barcode_seq = checkForNull(barcode_seq);
	}

	public String getBarcode_seq() {
		 return barcode_seq;
	}

	

	public void setAll(Hashtable htRecordSet){
	
		super.setAll(htRecordSet);
		setBarcode_gen_rule((String) htRecordSet.get("barcode_gen_rule"));
		setItem_yn((String) htRecordSet.get("item_yn"));
		setBatch_id_yn((String) htRecordSet.get("batch_id_yn"));
		setExpiry_dt_yn((String) htRecordSet.get("expiry_dt_yn"));
		setFacility_id_yn((String) htRecordSet.get("facility_id_yn"));
		setTrade_id_yn((String) htRecordSet.get("trade_id_yn"));
		setMfg_id_yn((String) htRecordSet.get("mfg_id_yn"));
		setSupp_id_yn((String) htRecordSet.get("supp_id_yn"));
		setStore_code_yn((String) htRecordSet.get("store_code_yn"));
		setBin_locn_yn((String) htRecordSet.get("bin_locn_yn"));
		setMrp_yn((String) htRecordSet.get("mrp_yn"));
		setBarcode_seq((String) htRecordSet.get("barcode_seq"));
		
		
		
	}

	/*public HashMap validate() throws Exception{
		HashMap hmReturn = getMessageHashMap(true);	
		String stParameters[] = {getCurr_proc_month(),getCurr_proc_year()};
		HashMap hmRecord	=	fetchRecord(getStRepositoryValue("SQL_SY_ACC_PERIOD_DEFN_SELECT_COUNT"),stParameters);
		if (hmRecord.get("TOTAL").toString().equals("0")) {
			hmReturn.put(RESULT, FALSE);
//Changed By Mahesh on 3/19/2008 as this message id is not present in Common Messages.java(Refer StController for validation Code)
			//hmReturn.put(MSGID, "INVALID_PERIOD_MONTH_YEAR");
			hmReturn.put(MESSAGE, getSTMessage(getLanguageId(),"INVALID_PERIOD_MONTH_YEAR","ST"));
		}
		return hmReturn;
	}*/

	public void clear(){
		super.clear();
		barcode_gen_rule = "";
		item_yn = "";
		batch_id_yn = "";
		expiry_dt_yn = "";
		facility_id_yn = "";
		trade_id_yn = "";
		mfg_id_yn = "";
		supp_id_yn = "";
		store_code_yn = "";
		bin_locn_yn = "";
		mrp_yn = "";
		barcode_seq = "";

	}

	public HashMap insert() {
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		alInsertData.add(getLoginFacilityId            ());
		alInsertData.add(getBarcode_gen_rule           ());
		alInsertData.add(getItem_yn			           ());
		alInsertData.add(getBatch_id_yn	               ());
		alInsertData.add(getExpiry_dt_yn	               ());
		alInsertData.add(getFacility_id_yn		       ());
		alInsertData.add( getTrade_id_yn		       ());
		alInsertData.add(getMfg_id_yn			       ());
		alInsertData.add(getSupp_id_yn			       ());
		alInsertData.add(getStore_code_yn		       ());
		alInsertData.add(getBin_locn_yn			       ());
		alInsertData.add(getMrp_yn				       ());
		alInsertData.add(getBarcode_seq			       ());
	
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());

		System.out.println("alInsertData"+alInsertData);
		
		hmSQLMap.put( "InsertSQL", "INSERT	INTO ST_ITEM_BARCODE_RULES(FACILITY_ID,BARCODE_GEN_RULE,ITEM_YN, BATCH_ID_YN, EXPIRY_DT_YN, FACILITY_ID_YN, TRADE_ID_YN, MFG_ID_YN, SUPP_ID_YN,	STORE_CODE_YN, BIN_LOCN_YN, MRP_YN,BARCODE_SEQ, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID)	VALUES (?,?,?, ?, ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, SYSDATE, ?, ?, ?,	SYSDATE, ?,	?)");
		//hmSQLMap.put( "InsertSQL", getStRepositoryValue("ST_ITEM_BARCODE_RULES_INSERT")	);
		//hmSQLMap.put( "SelectSQL", getStRepositoryValue("ST_ITEM_BARCODE_RULES_COUNT")	);

		alWhereData.add(getLoginFacilityId());
		alWhereData.add(getBarcode_gen_rule());
		

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
		hmTableData.put("LanguageData",LanguageData);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}

	public HashMap modify() {
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());


		alModifyData.add(getBarcode_gen_rule     ());
		alModifyData.add(getItem_yn      ());
		alModifyData.add(getBatch_id_yn      ());
		alModifyData.add(getExpiry_dt_yn      ());
		alModifyData.add(getFacility_id_yn      ());
		alModifyData.add(getTrade_id_yn      ());
		alModifyData.add(getMfg_id_yn      ());
		alModifyData.add(getSupp_id_yn      ());
		alModifyData.add(getStore_code_yn      ());
		alModifyData.add(getBin_locn_yn      ());
		alModifyData.add(getMrp_yn      ());
		alModifyData.add(getBarcode_seq	());
		alModifyData.add(getLoginById());      
		alModifyData.add(getLoginAtWsNo());    
		alModifyData.add(getLoginFacilityId());
       
		//alModifyData.add(getBarcode_gen_rule());
		alModifyData.add(getLoginFacilityId		  ());
		

		System.out.println("alModifyData"+alModifyData);
		

		//hmSQLMap.put( "ModifySQL", "UPDATE	ST_ITEM_BARCODE_RULES SET BARCODE_GEN_RULE=?,ITEM_YN=?, BATCH_ID_YN=?, EXPIRY_DT_YN=?, FACILITY_ID_YN=?, TRADE_ID_YN=?, MFG_ID_YN=?, SUPP_ID_YN=?,	STORE_CODE_YN=?, BIN_LOCN_YN=?, MRP_YN=?,BARCODE_SEQ=?,	MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?, WHERE BARCODE_GEN_RULE=? AND FACILITY_ID=?");
		hmSQLMap.put( "ModifySQL", getStRepositoryValue("ST_ITEM_BARCODE_RULES_UPDATE"));

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);
		hmTableData.put("LanguageData",LanguageData);

		System.out.println("hmTableData"+hmTableData);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public boolean recordExists() throws Exception{
		//String stParameters[]={getLoginFacilityId(),getBarcode_gen_rule()};
		HashMap hmResult = fetchRecord(getStRepositoryValue("SQL_ST_ITEM_BARCODE_RULES_COUNT"), getLoginFacilityId());
		return !((String)hmResult.get("TOTAL")).equals("0");
	}

	

	
	public void loadData() throws Exception {
		//String []stParameters=	{ getLoginFacilityId(), getBarcode_gen_rule()};
		HashMap hmRecord	=	null;
		//hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		hmRecord	=	fetchRecord("SELECT	BARCODE_GEN_RULE,ITEM_YN, BATCH_ID_YN, EXPIRY_DT_YN, FACILITY_ID_YN, TRADE_ID_YN, MFG_ID_YN, SUPP_ID_YN,	STORE_CODE_YN, BIN_LOCN_YN, MRP_YN,BARCODE_SEQ FROM ST_ITEM_BARCODE_RULES WHERE FACILITY_ID=?  ", getLoginFacilityId());
		System.out.println("hmRecord"+hmRecord);
	
		setBarcode_gen_rule           ( checkForNull((String)hmRecord.get("BARCODE_GEN_RULE" )	)) ;	
		setItem_yn		              ( checkForNull((String)hmRecord.get("ITEM_YN" )	)) ;	
		setBatch_id_yn				  ( checkForNull((String)hmRecord.get("BATCH_ID_YN" )	)) ;	
		setExpiry_dt_yn				  ( checkForNull((String)hmRecord.get("EXPIRY_DT_YN" )	)) ;	
		setFacility_id_yn             ( checkForNull((String)hmRecord.get("FACILITY_ID_YN" )	)) ;	
		setTrade_id_yn				  ( checkForNull((String)hmRecord.get("TRADE_ID_YN" )	)) ;	
		setMfg_id_yn				  ( checkForNull((String)hmRecord.get("MFG_ID_YN" )	)) ;	
		setSupp_id_yn				  ( checkForNull((String)hmRecord.get("SUPP_ID_YN" )	)) ;	
		setStore_code_yn			  ( checkForNull((String)hmRecord.get("STORE_CODE_YN" )	)) ;	
		setBin_locn_yn				  ( checkForNull((String)hmRecord.get("BIN_LOCN_YN" )	)) ;	
		setMrp_yn					  ( checkForNull((String)hmRecord.get("MRP_YN" )	)) ;	
		setBarcode_seq				  ( checkForNull((String)hmRecord.get("BARCODE_SEQ" )	)) ;	
		
		
	

	}

	
}


