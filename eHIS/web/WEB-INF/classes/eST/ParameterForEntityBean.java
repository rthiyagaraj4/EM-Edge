/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 /*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
02/05/2014				48528			        Abdul Rabbani      08/05/2014        Abdul Rabbani           HSA-CRF-0168
--------------------------------------------------------------------------------------------------------------------------------------------
*/
 package eST ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
//pmd 19/02/2005
//import java.util.Properties;
import eST.Common.*;

public class ParameterForEntityBean extends StAdapter implements Serializable { 

 
	private String age_slot_5;
	private String age_slot_4;
	private String age_slot_3;
	private String age_slot_2;
	private String age_slot_1;
	private String grace_days_for_hc_pat;
	private String expiry_warning_days;
	private String def_tfr_doc_type_code;
	private String def_ret_doc_type_code;
	private String trn_across_facility_yn;
	private String multi_store_issue_yn;
	private String curr_proc_year;
	private String def_var_doc_type_code;
	private String def_iss_doc_type_code;
	private String def_srt_doc_type_code;
	private String def_urg_doc_type_code;
	private String bl_interface_yn;
	private String batch_sale_price_yn;
	private String def_prt_doc_type_code;
	private String def_rtv_doc_type_code;
	private String def_grn_doc_type_code;
	private String curr_proc_month;
	private String acc_entity_id;
	private String def_mfg_doc_type_code;
	private String def_sal_doc_type_code;
	private String def_adj_doc_type_code;
	private String def_obs_doc_type_code;
	private String def_bin_doc_type_code;
//	private String language_id;

	private String def_stk_item_con_doc_type_code;

	private String def_spl_doc_type_code;
	private String gl_interface_yn;
	private String lesser_sale_price_yn;
	private String sale_price_appl_yn;
	private String po_details_applicable_yn;
	private String interface_to_external_po_yn;		
	private String porequest_by;
	private String restrict_view_stock_status;
	// sakti
	private String allow_unf_grn_thru_interface_yn;
	private String interface_po_applicable_yn;
	private String supplier;
	private String trade_name;
	private String bin_location;
/**
	* @Name - Mahesh
	* @Date - 05/01/2010
	* @Inc# - IN015494
	* @Desc - Variable for No of Decimals
	*/
	private String no_of_decimals;
	private String prepacking; //Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
	private String standardformulary;
	private String extemporaneous;
	private String others;
	private String disp_decimal_dtls_yn;//Added by suresh.r on 10-07-2014 against AAKH-SCF-0113
	private String average_cost_unit_price_yn; //Added for PMG2023-COMN-CRF-0039 

	public void setAge_slot_5(String age_slot_5) {
		 this.age_slot_5 = checkForNull( age_slot_5);
	}
	
		/*public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}*/
	public String getAge_slot_5( ) {
		 return age_slot_5;
	}

	public void setAge_slot_4(String age_slot_4) {
		 this.age_slot_4 = checkForNull( age_slot_4);
	}

	public String getAge_slot_4( ) {
		 return age_slot_4;
	}

	public void setAge_slot_3(String age_slot_3) {
		 this.age_slot_3 = checkForNull( age_slot_3);
	}

	public String getAge_slot_3( ) {
		 return age_slot_3;
	}

	public void setAge_slot_2(String age_slot_2) {
		 this.age_slot_2 = checkForNull( age_slot_2);
	}

	public String getAge_slot_2( ) {
		 return age_slot_2;
	}

	public void setAge_slot_1(String age_slot_1) {
		 this.age_slot_1 = checkForNull( age_slot_1);
	}

	public String getAge_slot_1( ) {
		 return age_slot_1;
	}

	public void setGrace_days_for_hc_pat(String grace_days_for_hc_pat) {
		 this.grace_days_for_hc_pat = checkForNull( grace_days_for_hc_pat);
	}

	public String getGrace_days_for_hc_pat( ) {
		 return grace_days_for_hc_pat;
	}

	public void setExpiry_warning_days(String expiry_warning_days) {
		 this.expiry_warning_days = checkForNull( expiry_warning_days);
	}

	public String getExpiry_warning_days( ) {
		 return expiry_warning_days;
	}

	public void setDef_tfr_doc_type_code(String def_tfr_doc_type_code) {
		 this.def_tfr_doc_type_code = checkForNull( def_tfr_doc_type_code);
	}

	public String getDef_tfr_doc_type_code( ) {
		 return def_tfr_doc_type_code;
	}

	public void setDef_ret_doc_type_code(String def_ret_doc_type_code) {
		 this.def_ret_doc_type_code = checkForNull( def_ret_doc_type_code);
	}

	public String getDef_ret_doc_type_code( ) {
		 return def_ret_doc_type_code;
	}

	public void setTrn_across_facility_yn(String trn_across_facility_yn) {
		 this.trn_across_facility_yn = checkForNull( trn_across_facility_yn,"N");
	}

	public String getTrn_across_facility_yn( ) {
		 return trn_across_facility_yn;
	}

	public void setMulti_store_issue_yn(String multi_store_issue_yn) {
		 this.multi_store_issue_yn = checkForNull( multi_store_issue_yn,"N");
	}

	public String getMulti_store_issue_yn( ) {
		 return multi_store_issue_yn;
	}

	public void setCurr_proc_year(String curr_proc_year) {
		 this.curr_proc_year = checkForNull( curr_proc_year);
	}

	public String getCurr_proc_year( ) {
		 return curr_proc_year;
	}

	public void setDef_var_doc_type_code(String def_var_doc_type_code) {
		 this.def_var_doc_type_code = checkForNull( def_var_doc_type_code);
	}

	public String getDef_var_doc_type_code( ) {
		 return def_var_doc_type_code;
	}

	public void setDef_iss_doc_type_code(String def_iss_doc_type_code) {
		 this.def_iss_doc_type_code = checkForNull( def_iss_doc_type_code);
	}

	public String getDef_iss_doc_type_code( ) {
		 return def_iss_doc_type_code;
	}

	public void setDef_srt_doc_type_code(String def_srt_doc_type_code) {
		 this.def_srt_doc_type_code = checkForNull( def_srt_doc_type_code);
	}

	public String getDef_srt_doc_type_code( ) {
		 return def_srt_doc_type_code;
	}

	public void setDef_urg_doc_type_code(String def_urg_doc_type_code) {
		 this.def_urg_doc_type_code = checkForNull( def_urg_doc_type_code);
	}

	public String getDef_urg_doc_type_code( ) {
		 return def_urg_doc_type_code;
	}

	public void setBl_interface_yn(String bl_interface_yn) {
		 this.bl_interface_yn = checkForNull( bl_interface_yn,"N");
	}

	public String getBl_interface_yn( ) {
		 return bl_interface_yn;
	}

	public void setBatch_sale_price_yn(String batch_sale_price_yn) {
		 this.batch_sale_price_yn = checkForNull( batch_sale_price_yn,"N");
	}
	public String getBatch_sale_price_yn( ) {
		 return batch_sale_price_yn;
	}

	

	public void setDef_prt_doc_type_code(String def_prt_doc_type_code) {
		 this.def_prt_doc_type_code = checkForNull( def_prt_doc_type_code);
	}

	public String getDef_prt_doc_type_code( ) {
		 return def_prt_doc_type_code;
	}

	public void setDef_rtv_doc_type_code(String def_rtv_doc_type_code) {
		 this.def_rtv_doc_type_code = checkForNull( def_rtv_doc_type_code);
	}

	public String getDef_rtv_doc_type_code( ) {
		 return def_rtv_doc_type_code;
	}

	public void setDef_grn_doc_type_code(String def_grn_doc_type_code) {
		 this.def_grn_doc_type_code = checkForNull( def_grn_doc_type_code);
	}

	public String getDef_grn_doc_type_code( ) {
		 return def_grn_doc_type_code;
	}

	public void setDef_bin_doc_type_code(String def_bin_doc_type_code) {
		 this.def_bin_doc_type_code = checkForNull( def_bin_doc_type_code);
	}

	public String getDef_bin_doc_type_code( ) {
		 return def_bin_doc_type_code;
	}

    public void setDef_stk_item_con_doc_type_code(String def_stk_item_con_doc_type_code) {
		 this.def_stk_item_con_doc_type_code = checkForNull( def_stk_item_con_doc_type_code);
	}

	public String getDef_stk_item_con_doc_type_code() {
		 return def_stk_item_con_doc_type_code;
	}


	public void setDef_spl_doc_type_code(String def_spl_doc_type_code) {
		 this.def_spl_doc_type_code = checkForNull( def_spl_doc_type_code);
	}

	public String getDef_spl_doc_type_code( ) {
		 return def_spl_doc_type_code;
	}

	public void setCurr_proc_month(String curr_proc_month) {
		 this.curr_proc_month = checkForNull( curr_proc_month);
	}

	public String getCurr_proc_month( ) {
		 return curr_proc_month;
	}

	public void setAcc_entity_id(String acc_entity_id) {
		 this.acc_entity_id = checkForNull( acc_entity_id);
	}

	public String getAcc_entity_id( ) {
		 return acc_entity_id;
	}

	public void setDef_mfg_doc_type_code(String def_mfg_doc_type_code) {
		 this.def_mfg_doc_type_code = checkForNull( def_mfg_doc_type_code);
	}

	public String getDef_mfg_doc_type_code( ) {
		 return def_mfg_doc_type_code;
	}

	public void setDef_sal_doc_type_code(String def_sal_doc_type_code) {
		 this.def_sal_doc_type_code = checkForNull( def_sal_doc_type_code);
	}

	public String getDef_sal_doc_type_code( ) {
		 return def_sal_doc_type_code;
	}

	public void setDef_adj_doc_type_code(String def_adj_doc_type_code) {
		 this.def_adj_doc_type_code = checkForNull( def_adj_doc_type_code);
	}

	public String getDef_adj_doc_type_code( ) {
		 return def_adj_doc_type_code;
	}

	public void setDef_obs_doc_type_code(String def_obs_doc_type_code) {
		 this.def_obs_doc_type_code = checkForNull( def_obs_doc_type_code);
	}

	public String getDef_obs_doc_type_code( ) {
		 return def_obs_doc_type_code;
	}

	public void setGl_interface_yn(String gl_interface_yn) {
		 this.gl_interface_yn = checkForNull( gl_interface_yn,"N");
	}

	public String getGl_interface_yn( ) {
		 return gl_interface_yn;
	}
	public void setSale_price_appl_yn(String sale_price_appl_yn) {
		 this.sale_price_appl_yn = checkForNull( sale_price_appl_yn,"N");
	}

	public String getSale_price_appl_yn( ) {
		 return sale_price_appl_yn;
	}
	public void setLesser_sale_price_yn(String lesser_sale_price_yn) {
		 this.lesser_sale_price_yn = checkForNull( lesser_sale_price_yn,"N");
	}

	public String getLesser_sale_price_yn( ) {
		 return lesser_sale_price_yn;
	}
	public void setPo_details_applicable_yn(String po_details_applicable_yn) {
		 this.po_details_applicable_yn = checkForNull( po_details_applicable_yn,"N");
	}

	public String getPo_details_applicable_yn( ) {
		 return po_details_applicable_yn;
	}
	public void setInterface_to_external_po_yn(String interface_to_external_po_yn) {
		 this.interface_to_external_po_yn = checkForNull( interface_to_external_po_yn,"N");
	}

	public String getInterface_to_external_po_yn() {
		 return interface_to_external_po_yn;
	}			

	public void setPOrequest_by(String porequest_by) {
		 this.porequest_by = checkForNull( porequest_by,"NA");
	}

	public String getPOrequest_by() {
		 return porequest_by;
	}

	public void setRestrictViewStockStatus(String restrict_view_stock_status) {
		 this.restrict_view_stock_status = checkForNull(restrict_view_stock_status,"UAS");
	}

	public String getRestrictViewStockStatus() {
		 return restrict_view_stock_status;
	}
	public void setNo_of_decimals(String no_of_decimals) {
		 this.no_of_decimals = checkForNull(no_of_decimals,"0");
	}

	public String getNo_of_decimals() {
		 return no_of_decimals;
	}

// sakti
	public void setAllow_unf_grn_thru_interface_yn(String allow_unf_grn_thru_interface_yn) {
		 this.allow_unf_grn_thru_interface_yn = checkForNull(allow_unf_grn_thru_interface_yn,"N");
	}

	public String getAllow_unf_grn_thru_interface_yn() {
		 return allow_unf_grn_thru_interface_yn;
	}

	public void setInterface_po_applicable_yn(String interface_po_applicable_yn) {
		 this.interface_po_applicable_yn = checkForNull(interface_po_applicable_yn,"N");
	}

	public String getInterface_po_applicable_yn() {
		 return interface_po_applicable_yn;
	}


	public void setSupplier(String supplier) {
		 this.supplier = checkForNull(supplier,"N");
	}

	public String getSupplier() {
		 return supplier;
	}

	public void setTrade_name(String trade_name) {
		 this.trade_name = checkForNull(trade_name,"N");
	}

	public String getTrade_name() {
		 return trade_name;
	}

	public void setBin_location(String bin_location) {
		 this.bin_location = checkForNull(bin_location,"N");
	}

	public String getBin_location() {
		 return bin_location;
	}

	
	
	//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014 Starts
	public void setPrepacking(String prepacking) {
		 this.prepacking = checkForNull( prepacking);
	}

	public String getPrepacking( ) {
		 return prepacking;
	}
	
	public void setStandardFormulary(String standardformulary) {
		 this.standardformulary = checkForNull( standardformulary);
	}

	public String getStandardFormulary( ) {
		 return standardformulary;
	}
	
	public void setExtemporaneous(String extemporaneous) {
		 this.extemporaneous = checkForNull( extemporaneous);
	}

	public String getExtemporaneous( ) {
		 return extemporaneous;
	}
	
	public void setOthers(String others) {
		 this.others = checkForNull( others);
	}

	public String getOthers( ) {
		 return others;
	}
	//ends
	//Added by suresh.r on 10-07-2014 against AAKH-SCF-0113 beg
	public String getDisp_decimal_dtls_yn() {
		return disp_decimal_dtls_yn;
	}

	public void setDisp_decimal_dtls_yn(String disp_decimal_dtls_yn) {
		this.disp_decimal_dtls_yn = checkForNull( disp_decimal_dtls_yn,"N");
	}//Added by suresh.r on 10-07-2014 against AAKH-SCF-0113 end
	

	//PMG2023-COMN-CRF-0039 - Starts
	public void setAverageCostUnitPriceYn(String average_cost_unit_price_yn) {
		 this.average_cost_unit_price_yn = checkForNull( average_cost_unit_price_yn,"N");
	}

	public String getAverageCostUnitPriceYn( ) {
		 return average_cost_unit_price_yn;
	}
	//PMG2023-COMN-CRF-0039 - Ends

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setAge_slot_5((String) htRecordSet.get("age_slot_5"));
		setAge_slot_4((String) htRecordSet.get("age_slot_4"));
		setAge_slot_3((String) htRecordSet.get("age_slot_3"));
		setAge_slot_2((String) htRecordSet.get("age_slot_2"));
		setAge_slot_1((String) htRecordSet.get("age_slot_1"));
		setGrace_days_for_hc_pat((String) htRecordSet.get("grace_days_for_hc_pat"));
		setExpiry_warning_days((String) htRecordSet.get("expiry_warning_days"));
		setDef_tfr_doc_type_code((String) htRecordSet.get("def_tfr_doc_type_code"));
		setDef_ret_doc_type_code((String) htRecordSet.get("def_ret_doc_type_code"));
		setTrn_across_facility_yn((String) htRecordSet.get("trn_across_facility_yn"));
		setMulti_store_issue_yn((String) htRecordSet.get("multi_store_issue_yn"));
		setCurr_proc_year((String) htRecordSet.get("curr_proc_year"));
		setDef_var_doc_type_code((String) htRecordSet.get("def_var_doc_type_code"));
		setDef_iss_doc_type_code((String) htRecordSet.get("def_iss_doc_type_code"));
		setDef_srt_doc_type_code((String) htRecordSet.get("def_srt_doc_type_code"));
		setDef_urg_doc_type_code((String) htRecordSet.get("def_urg_doc_type_code"));
		setBl_interface_yn((String) htRecordSet.get("bl_interface_yn"));
		setBatch_sale_price_yn((String) htRecordSet.get("batch_sale_price_yn"));
		setDef_prt_doc_type_code((String) htRecordSet.get("def_prt_doc_type_code"));
		setDef_rtv_doc_type_code((String) htRecordSet.get("def_rtv_doc_type_code"));
		setDef_grn_doc_type_code((String) htRecordSet.get("def_grn_doc_type_code"));
		setDef_bin_doc_type_code((String) htRecordSet.get("def_bin_doc_type_code"));
		setDef_stk_item_con_doc_type_code((String) htRecordSet.get("def_stk_item_con_doc_type_code"));
		setDef_spl_doc_type_code((String) htRecordSet.get("def_spl_doc_type_code"));
		setCurr_proc_month((String) htRecordSet.get("curr_proc_month"));
		setDef_mfg_doc_type_code((String) htRecordSet.get("def_mfg_doc_type_code"));
		setDef_sal_doc_type_code((String) htRecordSet.get("def_sal_doc_type_code"));
		setDef_adj_doc_type_code((String) htRecordSet.get("def_adj_doc_type_code"));
		setDef_obs_doc_type_code((String) htRecordSet.get("def_obs_doc_type_code"));
		setSale_price_appl_yn((String) htRecordSet.get("sale_price_appl_yn"));
		setLesser_sale_price_yn((String) htRecordSet.get("lesser_sale_price_yn"));
		setGl_interface_yn((String) htRecordSet.get("gl_interface_yn"));
		setPo_details_applicable_yn((String) htRecordSet.get("po_details_applicable_yn"));
		setInterface_to_external_po_yn((String) htRecordSet.get("interface_to_external_po_yn"));					  				
		setPOrequest_by((String) htRecordSet.get("porequest_by"));
		setRestrictViewStockStatus((String) htRecordSet.get("restrict_view_stock_status"));
		setNo_of_decimals(checkForNull((String) htRecordSet.get("no_of_decimals"),"0"));
//sakti
		setAllow_unf_grn_thru_interface_yn(checkForNull((String) htRecordSet.get("allow_unf_grn_thru_interface_yn")));
		setSupplier(checkForNull((String) htRecordSet.get("supplier")));
		setTrade_name(checkForNull((String) htRecordSet.get("trade_name")));
		setBin_location(checkForNull((String) htRecordSet.get("bin_location")));
		setInterface_po_applicable_yn(checkForNull((String) htRecordSet.get("interface_po_applicable_yn")));
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
		setPrepacking(checkForNull((String) htRecordSet.get("prepacking")));
		setStandardFormulary(checkForNull((String) htRecordSet.get("standardformulary")));  
		setExtemporaneous(checkForNull((String) htRecordSet.get("extemporaneous")));
		setOthers(checkForNull((String) htRecordSet.get("others")));
		setDisp_decimal_dtls_yn(	(String) htRecordSet.get("disp_decimal_dtls_yn"));//Added by suresh.r on 10-07-2014 against AAKH-SCF-0113
			
		setAverageCostUnitPriceYn(	(String) htRecordSet.get("unit_cost_price_yn"));// Added for PMG2023-COMN-CRF-0039
		
	}

	public HashMap validate() throws Exception{
		HashMap hmReturn = getMessageHashMap(true);	
		if ( (!checkForNull(getCurr_proc_month()).equals(""))  && (!checkForNull(getCurr_proc_year()).equals(""))  ) {
			String stParameters[] = {getCurr_proc_month(),com.ehis.util.DateUtils.convertDate(getCurr_proc_year(),"YY",getLanguageId(),"en")}; //Modified for TBMC-SCF-0018
			HashMap hmRecord	=	fetchRecord(getStRepositoryValue("SQL_SY_ACC_PERIOD_DEFN_SELECT_COUNT"),stParameters);
			if (hmRecord.get("TOTAL").toString().equals("0")) {
				hmReturn.put(RESULT, FALSE);
//Changed By Mahesh on 3/19/2008 as this message id is not present in Common Messages.java(Refer StController for validation Code)
				//hmReturn.put(MSGID, "INVALID_PERIOD_MONTH_YEAR");
				hmReturn.put(MESSAGE, getSTMessage(getLanguageId(),"INVALID_PERIOD_MONTH_YEAR","ST"));
				//hmResult.put( "message", getSTMessage(getLanguageId(),(String) hmResult.get( "msgid" ),"ST")) ;
			}
		}
		return hmReturn;
	}


	public void clear(){
		super.clear();
		age_slot_5="";
		age_slot_4="";
		age_slot_3="";
		age_slot_2="";
		age_slot_1="";
		grace_days_for_hc_pat="";
		expiry_warning_days="";
		def_tfr_doc_type_code="";
		def_ret_doc_type_code="";
		trn_across_facility_yn="N";
		multi_store_issue_yn="N";
		curr_proc_year="";
		def_var_doc_type_code="";
		def_iss_doc_type_code="";
		def_srt_doc_type_code="";
		def_urg_doc_type_code="";
		bl_interface_yn="N";
		batch_sale_price_yn="N";
		def_prt_doc_type_code="";
		def_rtv_doc_type_code="";
		def_grn_doc_type_code="";
		def_bin_doc_type_code="";
		def_stk_item_con_doc_type_code="";
		def_spl_doc_type_code="";
		curr_proc_month="";
		acc_entity_id="";
		def_mfg_doc_type_code="";
		def_sal_doc_type_code="";
		def_adj_doc_type_code="";
		def_obs_doc_type_code="";
		gl_interface_yn="N";
		porequest_by="NA";
		no_of_decimals="0";
//sakti
		allow_unf_grn_thru_interface_yn="";
		supplier = "";
		trade_name ="";
		bin_location="";
		interface_po_applicable_yn = "";
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
		  prepacking = "";
	      standardformulary = "";
		  extemporaneous = "";
		  others= "";
		  disp_decimal_dtls_yn		=	"N";//Added by suresh.r on 10-07-2014 against AAKH-SCF-0113
		  average_cost_unit_price_yn = "N"; //Added for PMG2023-COMN-CRF-0039
		  
}

	public HashMap insert() {
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		alInsertData.add(getAcc_entity_id());
		alInsertData.add(getCurr_proc_month       ());
		alInsertData.add(getCurr_proc_year        ());
		alInsertData.add(getBl_interface_yn       ());		
		alInsertData.add(getGl_interface_yn       ());
		alInsertData.add(getTrn_across_facility_yn ());
		alInsertData.add(getExpiry_warning_days    ());

		alInsertData.add(getDef_grn_doc_type_code());
		alInsertData.add(getDef_rtv_doc_type_code());
		alInsertData.add(getDef_mfg_doc_type_code());
		alInsertData.add(getDef_iss_doc_type_code());
		alInsertData.add(getDef_ret_doc_type_code());
		alInsertData.add(getDef_urg_doc_type_code());
		alInsertData.add(getDef_tfr_doc_type_code());
		alInsertData.add(getDef_adj_doc_type_code());
		alInsertData.add(getDef_var_doc_type_code());
		alInsertData.add(getDef_prt_doc_type_code());
		alInsertData.add(getDef_sal_doc_type_code());
		alInsertData.add(getDef_srt_doc_type_code());
		alInsertData.add(getDef_obs_doc_type_code());
		alInsertData.add(getDef_bin_doc_type_code());
		alInsertData.add(getDef_spl_doc_type_code());

		alInsertData.add(getAge_slot_1());
		alInsertData.add(getAge_slot_2());
		alInsertData.add(getAge_slot_3());
		alInsertData.add(getAge_slot_4());
		alInsertData.add(getAge_slot_5());

		alInsertData.add(getMulti_store_issue_yn  ());	
		alInsertData.add(getGrace_days_for_hc_pat ());	

		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());

        alInsertData.add(getDef_stk_item_con_doc_type_code());
		alInsertData.add(getBatch_sale_price_yn       ());
		alInsertData.add(getSale_price_appl_yn        ());
		alInsertData.add(getLesser_sale_price_yn      ());
		alInsertData.add(getPo_details_applicable_yn  ());
		alInsertData.add(getInterface_to_external_po_yn());
		alInsertData.add(getPOrequest_by());
		alInsertData.add(getRestrictViewStockStatus());
		alInsertData.add(getNo_of_decimals());

//sakti
		alInsertData.add(getAllow_unf_grn_thru_interface_yn());
		alInsertData.add(getSupplier());
		alInsertData.add(getTrade_name());
		alInsertData.add(getBin_location());
		alInsertData.add(getInterface_po_applicable_yn());
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
		alInsertData.add(checkForNull(getPrepacking()));
		alInsertData.add(checkForNull(getStandardFormulary()));
		alInsertData.add(checkForNull(getExtemporaneous()));
		alInsertData.add(checkForNull(getOthers()));
		alInsertData.add(getDisp_decimal_dtls_yn       ());//Added by suresh.r on 10-07-2014 against AAKH-SCF-0113
		alInsertData.add(getAverageCostUnitPriceYn());//Added for PMG2023-COMN-CRF-0039 
	
		//hmSQLMap.put( "InsertSQL", getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_INSERT")		);
		
		//hmSQLMap.put( "InsertSQL","INSERT	INTO st_acc_entity_param(acc_entity_id,	curr_proc_month, curr_proc_year, bl_interface_yn, gl_interface_yn, trn_across_facility_yn, expiry_warning_days,	def_grn_doc_type_code, def_rtv_doc_type_code, def_mfg_doc_type_code, def_iss_doc_type_code,	def_ret_doc_type_code, def_urg_doc_type_code, def_tfr_doc_type_code, def_adj_doc_type_code,	def_var_doc_type_code, def_prt_doc_type_code, def_sal_doc_type_code, def_srt_doc_type_code,	def_obs_doc_type_code, def_bin_doc_type_code, def_spl_doc_type_code, age_slot_1, age_slot_2, age_slot_3, age_slot_4, age_slot_5, multi_store_issue_yn, grace_days_for_hc_pat, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no,	modified_facility_id,def_stk_item_con_doc_type_code,batch_sale_price_yn,sale_price_appl_yn,lesser_sale_price_yn,po_details_applicable_yn,interface_to_external_po_yn,po_req_by,restrict_view_stk_status,no_of_decimals,ALLOW_UNFIN_INTF_GRN_YN,DFLT_INTF_SUPP_CODE,DFLT_TRADE_ID,DFLT_BIN_LOCN_CODE,PO_INTERFACE_YN)VALUES(?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, SYSDATE, ?, ?, ?,	SYSDATE, ?,	?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
		//Added DISP_DECIMAL_DTLS_YN by suresh.r on 10-07-2014 against AAKH-SCF-0113
		hmSQLMap.put( "InsertSQL","INSERT	INTO st_acc_entity_param(acc_entity_id,	curr_proc_month, curr_proc_year, bl_interface_yn, gl_interface_yn, trn_across_facility_yn, expiry_warning_days,	def_grn_doc_type_code, def_rtv_doc_type_code, def_mfg_doc_type_code, def_iss_doc_type_code,	def_ret_doc_type_code, def_urg_doc_type_code, def_tfr_doc_type_code, def_adj_doc_type_code,	def_var_doc_type_code, def_prt_doc_type_code, def_sal_doc_type_code, def_srt_doc_type_code,	def_obs_doc_type_code, def_bin_doc_type_code, def_spl_doc_type_code, age_slot_1, age_slot_2, age_slot_3, age_slot_4, age_slot_5, multi_store_issue_yn, grace_days_for_hc_pat, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no,	modified_facility_id,def_stk_item_con_doc_type_code,batch_sale_price_yn,sale_price_appl_yn,lesser_sale_price_yn,po_details_applicable_yn,interface_to_external_po_yn,po_req_by,restrict_view_stk_status,no_of_decimals,ALLOW_UNFIN_INTF_GRN_YN,DFLT_INTF_SUPP_CODE,DFLT_TRADE_ID,DFLT_BIN_LOCN_CODE,PO_INTERFACE_YN,PREP_PREPACK_LG,PREP_STDFORM_LG,PREP_EXTEMP_LG,PREP_OTHERS_LG,DISP_DECIMAL_DTLS_YN,WAC_FOR_UNIT_COST_PRICE_YN)VALUES(?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, SYSDATE, ?, ?, ?,	SYSDATE, ?,	?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		hmSQLMap.put( "SelectSQL", getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_COUNT")		);

		alWhereData.add(getAcc_entity_id());

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
		hmTableData.put("LanguageData",LanguageData);
		
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}

	public HashMap modify() {
//		return getMessageHashMap(true);
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());
//		alModifyData.add(getCurr_proc_month       ());
//		alModifyData.add(getCurr_proc_year        ());
		alModifyData.add(getBl_interface_yn       ());		
		alModifyData.add(getGl_interface_yn       ());
		alModifyData.add(getTrn_across_facility_yn ());
		alModifyData.add(getExpiry_warning_days    ());

		alModifyData.add(getDef_grn_doc_type_code());
		alModifyData.add(getDef_rtv_doc_type_code());
		alModifyData.add(getDef_mfg_doc_type_code());
		alModifyData.add(getDef_iss_doc_type_code());
		alModifyData.add(getDef_ret_doc_type_code());
		alModifyData.add(getDef_urg_doc_type_code());
		alModifyData.add(getDef_tfr_doc_type_code());
		alModifyData.add(getDef_adj_doc_type_code());
		alModifyData.add(getDef_var_doc_type_code());
		alModifyData.add(getDef_prt_doc_type_code());
		alModifyData.add(getDef_sal_doc_type_code());
		alModifyData.add(getDef_srt_doc_type_code());
		alModifyData.add(getDef_obs_doc_type_code());
		alModifyData.add(getDef_bin_doc_type_code());
		alModifyData.add(getDef_spl_doc_type_code());

		alModifyData.add(getAge_slot_1());
		alModifyData.add(getAge_slot_2());
		alModifyData.add(getAge_slot_3());
		alModifyData.add(getAge_slot_4());
		alModifyData.add(getAge_slot_5());

		alModifyData.add(getMulti_store_issue_yn  ());	
		alModifyData.add(getGrace_days_for_hc_pat ());	

		alModifyData.add(getLoginById());      
		alModifyData.add(getLoginAtWsNo());    
		alModifyData.add(getLoginFacilityId());

        alModifyData.add(getDef_stk_item_con_doc_type_code());
		alModifyData.add(getBatch_sale_price_yn       ());
		alModifyData.add(getSale_price_appl_yn        ());
		alModifyData.add(getLesser_sale_price_yn      ());
		alModifyData.add(getPo_details_applicable_yn  ());
		alModifyData.add(getInterface_to_external_po_yn());
		alModifyData.add(getPOrequest_by());
		alModifyData.add(getRestrictViewStockStatus());
		alModifyData.add(getNo_of_decimals());

//sakti
		alModifyData.add(getAllow_unf_grn_thru_interface_yn());
		alModifyData.add(getSupplier());
		alModifyData.add(getTrade_name());
		alModifyData.add(getBin_location());
		alModifyData.add(getInterface_po_applicable_yn());
		
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
		alModifyData.add( getPrepacking());
		alModifyData.add(getStandardFormulary());
		alModifyData.add(getExtemporaneous());
		alModifyData.add(getOthers());
		alModifyData.add(getDisp_decimal_dtls_yn       ());//Added by suresh.r on 10-07-2014 against AAKH-SCF-0113
		
		alModifyData.add(getAverageCostUnitPriceYn());//Added for PMG2023-COMN-CRF-0039 
		

		alModifyData.add(getAcc_entity_id());
		

		//hmSQLMap.put( "ModifySQL", getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_UPDATE"));
		//hmSQLMap.put( "ModifySQL","UPDATE	st_acc_entity_param	set	bl_interface_yn=?, gl_interface_yn=?, trn_across_facility_yn=?,	expiry_warning_days=?, def_grn_doc_type_code=?,	def_rtv_doc_type_code=?, def_mfg_doc_type_code=?, def_iss_doc_type_code=?, def_ret_doc_type_code=?,	def_urg_doc_type_code=?, def_tfr_doc_type_code=?, def_adj_doc_type_code=?, def_var_doc_type_code=?,	def_prt_doc_type_code=?, def_sal_doc_type_code=?, def_srt_doc_type_code=?, def_obs_doc_type_code=?,	def_bin_doc_type_code=?, def_spl_doc_type_code=?, age_slot_1=?,	age_slot_2=?, age_slot_3=?,	age_slot_4=?, age_slot_5=?,	multi_store_issue_yn=?,	grace_days_for_hc_pat=?, modified_by_id=?, modified_date=SYSDATE, modified_at_ws_no=?, modified_facility_id=? ,def_stk_item_con_doc_type_code = ?, batch_sale_price_yn= ?,SALE_PRICE_APPL_YN=?,LESSER_SALE_PRICE_YN = ?,po_details_applicable_yn = ?,interface_to_external_po_yn=?,po_req_by=?,restrict_view_stk_status=?,no_of_decimals = ?,ALLOW_UNFIN_INTF_GRN_YN=?,DFLT_INTF_SUPP_CODE=?,DFLT_TRADE_ID=?,DFLT_BIN_LOCN_CODE=?,PO_INTERFACE_YN=? WHERE	acc_entity_id=?");
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
		//Added DISP_DECIMAL_DTLS_YN by suresh.r on 10-07-2014 against AAKH-SCF-0113
		hmSQLMap.put( "ModifySQL","UPDATE	st_acc_entity_param	set	bl_interface_yn=?, gl_interface_yn=?, trn_across_facility_yn=?,	expiry_warning_days=?, def_grn_doc_type_code=?,	def_rtv_doc_type_code=?, def_mfg_doc_type_code=?, def_iss_doc_type_code=?, def_ret_doc_type_code=?,	def_urg_doc_type_code=?, def_tfr_doc_type_code=?, def_adj_doc_type_code=?, def_var_doc_type_code=?,	def_prt_doc_type_code=?, def_sal_doc_type_code=?, def_srt_doc_type_code=?, def_obs_doc_type_code=?,	def_bin_doc_type_code=?, def_spl_doc_type_code=?, age_slot_1=?,	age_slot_2=?, age_slot_3=?,	age_slot_4=?, age_slot_5=?,	multi_store_issue_yn=?,	grace_days_for_hc_pat=?, modified_by_id=?, modified_date=SYSDATE, modified_at_ws_no=?, modified_facility_id=? ,def_stk_item_con_doc_type_code = ?, batch_sale_price_yn= ?,SALE_PRICE_APPL_YN=?,LESSER_SALE_PRICE_YN = ?,po_details_applicable_yn = ?,interface_to_external_po_yn=?,po_req_by=?,restrict_view_stk_status=?,no_of_decimals = ?,ALLOW_UNFIN_INTF_GRN_YN=?,DFLT_INTF_SUPP_CODE=?,DFLT_TRADE_ID=?,DFLT_BIN_LOCN_CODE=?,PO_INTERFACE_YN=? ,PREP_PREPACK_LG = ? ,PREP_STDFORM_LG = ? ,PREP_EXTEMP_LG = ? ,PREP_OTHERS_LG = ?,DISP_DECIMAL_DTLS_YN=?,WAC_FOR_UNIT_COST_PRICE_YN=? WHERE	acc_entity_id=?");  //Added for WAC_FOR_UNIT_COST_PRICE_YN PMG2023-COMN-CRF-0039 
		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);
		hmTableData.put("LanguageData",LanguageData);
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}


	public boolean recordExists() throws Exception{
		HashMap hmResult = fetchRecord(getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_COUNT"), getAcc_entity_id());
		return !((String)hmResult.get("TOTAL")).equals("0");
	}
	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameterForFacilitys=new ArrayList();
		alParameterForFacilitys.add(getLoginFacilityId());
		alParameterForFacilitys.add(trn_type);
		alParameterForFacilitys.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST_ENT"),alParameterForFacilitys),defaultValue);
	}

	public String getDef_bin_doc_type_code_List(){
		return getDefaultDocumentTypeList("CBL",getDef_bin_doc_type_code());
	}

	public String getDef_stk_item_con_doc_type_code_List(){
		String l_trn_type = "SAL";
		try{
			int l_count=Integer.parseInt((String)fetchRecord("select count(*) count from st_trn_doc_type where trn_type='CON'").get("COUNT"));
				if(l_count > 0){
					l_trn_type = "CON";
				}
						
		}catch(Exception e){
			e.printStackTrace();
		}
		//return getDefaultDocumentTypeList( "SAL",getDef_stk_item_con_doc_type_code());
		return getDefaultDocumentTypeList(l_trn_type,getDef_stk_item_con_doc_type_code());
	}

	public String getDef_spl_doc_type_code_List(){
		return getDefaultDocumentTypeList("SPB",getDef_spl_doc_type_code());
	}

	public String getDef_grn_doc_type_code_List(){
		return getDefaultDocumentTypeList("GRN",getDef_grn_doc_type_code());
	}

	public String getDef_rtv_doc_type_code_List(){
		return getDefaultDocumentTypeList("RTV",getDef_rtv_doc_type_code());
	}

	public String getDef_mfg_doc_type_code_List(){
		return getDefaultDocumentTypeList("MFG",getDef_mfg_doc_type_code());
	}

	public String getDef_iss_doc_type_code_List(){
		return getDefaultDocumentTypeList("ISS",getDef_iss_doc_type_code());
	}


	public String getDef_ret_doc_type_code_List(){
		return getDefaultDocumentTypeList("RET",getDef_ret_doc_type_code());
	}

	public String getDef_urg_doc_type_code_List(){
		return getDefaultDocumentTypeList("URG",getDef_urg_doc_type_code());
	}

	public String getDef_tfr_doc_type_code_List(){
		return getDefaultDocumentTypeList("TFR",getDef_tfr_doc_type_code());
	}

	public String getDef_adj_doc_type_code_List(){
		return getDefaultDocumentTypeList("ADJ",getDef_adj_doc_type_code());
	}

	public String getDef_obs_doc_type_code_List(){
		return getDefaultDocumentTypeList("OBS",getDef_obs_doc_type_code());
	}

	public String getDef_var_doc_type_code_List(){
		return getDefaultDocumentTypeList("VAR",getDef_var_doc_type_code());
	}

	public String getDef_prt_doc_type_code_List(){
		return getDefaultDocumentTypeList("PRT",getDef_prt_doc_type_code());
	}

	public String getDef_sal_doc_type_code_List(){
		return getDefaultDocumentTypeList("SAL",getDef_sal_doc_type_code());
	}

	public String getDef_srt_doc_type_code_List(){
		return getDefaultDocumentTypeList("SRT",getDef_srt_doc_type_code());
	}

	//code added to find Billing Module is Installed....

	public boolean isBillingModuleInstalled( ) throws Exception{
		boolean flag= false;
		HashMap result = fetchRecord(getStRepositoryValue( "SQL_ST_ITEM_BILLING_YN"));
		int result_yn = Integer.parseInt((String)result.get("CNT"));
		if(result_yn > 0)
			flag = true;
		else
			flag = false;
		return flag;


	}
	/* Over-ridden Adapter methods end here */
	/* Function specific methods start */ 
	public void loadData() throws Exception {
		HashMap hmRecord	=	null;
		//hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_ACC_ENTITY_PARAM_SELECT_SINGLE"), getAcc_entity_id());
		//hmRecord	=	fetchRecord("SELECT	curr_proc_month, curr_proc_year, bl_interface_yn, gl_interface_yn, trn_across_facility_yn, expiry_warning_days,	def_grn_doc_type_code, def_rtv_doc_type_code, def_mfg_doc_type_code, def_iss_doc_type_code,	def_ret_doc_type_code, def_urg_doc_type_code, def_tfr_doc_type_code, def_adj_doc_type_code,	def_var_doc_type_code, def_prt_doc_type_code, def_sal_doc_type_code, def_srt_doc_type_code,	def_obs_doc_type_code, def_bin_doc_type_code, def_spl_doc_type_code, age_slot_1, age_slot_2, age_slot_3, age_slot_4, age_slot_5, multi_store_issue_yn, grace_days_for_hc_pat, def_stk_item_con_doc_type_code, batch_sale_price_yn, sale_price_appl_yn, lesser_sale_price_yn, po_details_applicable_yn, interface_to_external_po_yn, po_req_by, restrict_view_stk_status,no_of_decimals,ALLOW_UNFIN_INTF_GRN_YN,DFLT_INTF_SUPP_CODE,DFLT_TRADE_ID,DFLT_BIN_LOCN_CODE,PO_INTERFACE_YN FROM st_acc_entity_param WHERE	acc_entity_id=?", getAcc_entity_id());
		
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
		//Added DISP_DECIMAL_DTLS_YN by suresh.r on 10-07-2014 against AAKH-SCF-0113
		hmRecord	=	fetchRecord("SELECT	curr_proc_month, curr_proc_year, bl_interface_yn, gl_interface_yn, trn_across_facility_yn, expiry_warning_days,	def_grn_doc_type_code, def_rtv_doc_type_code, def_mfg_doc_type_code, def_iss_doc_type_code,	def_ret_doc_type_code, def_urg_doc_type_code, def_tfr_doc_type_code, def_adj_doc_type_code,	def_var_doc_type_code, def_prt_doc_type_code, def_sal_doc_type_code, def_srt_doc_type_code,	def_obs_doc_type_code, def_bin_doc_type_code, def_spl_doc_type_code, age_slot_1, age_slot_2, age_slot_3, age_slot_4, age_slot_5, multi_store_issue_yn, grace_days_for_hc_pat, def_stk_item_con_doc_type_code, batch_sale_price_yn, sale_price_appl_yn, lesser_sale_price_yn, po_details_applicable_yn, interface_to_external_po_yn, po_req_by, restrict_view_stk_status,no_of_decimals,ALLOW_UNFIN_INTF_GRN_YN,DFLT_INTF_SUPP_CODE,DFLT_TRADE_ID,DFLT_BIN_LOCN_CODE,PO_INTERFACE_YN,PREP_PREPACK_LG,PREP_STDFORM_LG,PREP_EXTEMP_LG,PREP_OTHERS_LG,DISP_DECIMAL_DTLS_YN,WAC_FOR_UNIT_COST_PRICE_YN FROM st_acc_entity_param WHERE	acc_entity_id=?", getAcc_entity_id());
		
		setCurr_proc_month       ( checkForNull( (String)hmRecord.get( "CURR_PROC_MONTH" ) ) ) ;	
		setCurr_proc_year        ( checkForNull( (String)hmRecord.get( "CURR_PROC_YEAR" ) ) ) ;	
		setBl_interface_yn       ( checkForNull( (String)hmRecord.get( "BL_INTERFACE_YN" ) ) ) ;
		setBatch_sale_price_yn       ( checkForNull( (String)hmRecord.get( "BATCH_SALE_PRICE_YN" ) ) ) ;	
		setGl_interface_yn       ( checkForNull( (String)hmRecord.get( "GL_INTERFACE_YN" ) ) ) ;	
		setTrn_across_facility_yn( checkForNull( (String)hmRecord.get( "TRN_ACROSS_FACILITY_YN" ) ) ) ;	
		setExpiry_warning_days   ( checkForNull( (String)hmRecord.get( "EXPIRY_WARNING_DAYS" ) ) ) ;	
		setDef_grn_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_GRN_DOC_TYPE_CODE" ) ) ) ;	
		setDef_rtv_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_RTV_DOC_TYPE_CODE" ) ) ) ;	
		setDef_mfg_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_MFG_DOC_TYPE_CODE" ) ) ) ;	
		setDef_iss_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_ISS_DOC_TYPE_CODE" ) ) ) ;	
		setDef_ret_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_RET_DOC_TYPE_CODE" ) ) ) ;	
		setDef_urg_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_URG_DOC_TYPE_CODE" ) ) ) ;	
		setDef_tfr_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_TFR_DOC_TYPE_CODE" ) ) ) ;	
		setDef_adj_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_ADJ_DOC_TYPE_CODE" ) ) ) ;	
		setDef_obs_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_OBS_DOC_TYPE_CODE" ) ) ) ;	
		setDef_var_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_VAR_DOC_TYPE_CODE" ) ) ) ;	
		setDef_prt_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_PRT_DOC_TYPE_CODE" ) ) ) ;	
		setDef_sal_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_SAL_DOC_TYPE_CODE" ) ) ) ;	
		setDef_srt_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_SRT_DOC_TYPE_CODE" ) ) ) ;	
		setDef_bin_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_BIN_DOC_TYPE_CODE" ) ) ) ;	
		setDef_spl_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_SPL_DOC_TYPE_CODE" ) ) ) ;	
		setAge_slot_1            ( checkForNull( (String)hmRecord.get( "AGE_SLOT_1" ) ) ) ;	
		setAge_slot_2            ( checkForNull( (String)hmRecord.get( "AGE_SLOT_2" ) ) ) ;	
		setAge_slot_3            ( checkForNull( (String)hmRecord.get( "AGE_SLOT_3" ) ) ) ;	
		setAge_slot_4            ( checkForNull( (String)hmRecord.get( "AGE_SLOT_4" ) ) ) ;	
		setAge_slot_5            ( checkForNull( (String)hmRecord.get( "AGE_SLOT_5" ) ) ) ;	
		setMulti_store_issue_yn  ( checkForNull( (String)hmRecord.get( "MULTI_STORE_ISSUE_YN" ) ) ) ;	
		setGrace_days_for_hc_pat ( checkForNull( (String)hmRecord.get( "GRACE_DAYS_FOR_HC_PAT" ) ) ) ;	
		setDef_stk_item_con_doc_type_code ( checkForNull( (String)hmRecord.get( "DEF_STK_ITEM_CON_DOC_TYPE_CODE" ) ) ) ;	
		setSale_price_appl_yn	 (checkForNull((String) hmRecord.get("SALE_PRICE_APPL_YN")));
		setLesser_sale_price_yn	 (checkForNull((String) hmRecord.get("LESSER_SALE_PRICE_YN")));
		setPo_details_applicable_yn	 (checkForNull((String) hmRecord.get("PO_DETAILS_APPLICABLE_YN")));
		setInterface_to_external_po_yn(checkForNull((String) hmRecord.get("INTERFACE_TO_EXTERNAL_PO_YN"),"N"));		
		setPOrequest_by((String) hmRecord.get("PO_REQ_BY"));
		setRestrictViewStockStatus(checkForNull((String) hmRecord.get("RESTRICT_VIEW_STK_STATUS")));
		setNo_of_decimals(checkForNull((String) hmRecord.get("NO_OF_DECIMALS")));

//sakti
		setAllow_unf_grn_thru_interface_yn(checkForNull((String) hmRecord.get("ALLOW_UNFIN_INTF_GRN_YN")));
		setSupplier(checkForNull((String) hmRecord.get("DFLT_INTF_SUPP_CODE")));
		setTrade_name(checkForNull((String) hmRecord.get("DFLT_TRADE_ID")));
		setBin_location(checkForNull((String) hmRecord.get("DFLT_BIN_LOCN_CODE")));
		setInterface_po_applicable_yn(checkForNull((String) hmRecord.get("PO_INTERFACE_YN")));
	 
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
		setPrepacking(checkForNull((String) hmRecord.get("PREP_PREPACK_LG")));
		setStandardFormulary(checkForNull((String) hmRecord.get("PREP_STDFORM_LG")));  
		setExtemporaneous(checkForNull((String) hmRecord.get("PREP_EXTEMP_LG")));
		setOthers(checkForNull((String) hmRecord.get("PREP_OTHERS_LG")));
		setDisp_decimal_dtls_yn       ( (String)hmRecord.get("DISP_DECIMAL_DTLS_YN" )			) ;//Added by suresh.r on 10-07-2014 against AAKH-SCF-0113
		setAverageCostUnitPriceYn	((String)hmRecord.get("WAC_FOR_UNIT_COST_PRICE_YN" )	); //PMG2023-COMN-CRF-0039

	}

	public String toString(){
		return "ParameterForEntity Bean";
	}



		public String getSupp_code_List(String defaultValue) {
		
		return  getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_AP_SUPPLIER_SELECT_LIST"),getLanguageId()), getSupplier());
	}

	

		public String getTrade_Name_List(String defaultValue) {

		return  getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_AM_TRADE_NAME_SELECT_LIST"),getLanguageId()), getTrade_name());
	}

	

		public String getBin_Locn_List(String defaultValue) {
			
		return  getListOptionTag(getListOptionArrayList(getStRepositoryValue("SQL_MM_BIN_LOCATION_SELECT_LIST_1"),getLanguageId()), getBin_location());
	}
		
		//Added by Rabbani #48528(HSA-CRF-0168) on 08-MAY-2014
		public Boolean getPrep_Standardform(){
			int count = 0;
			try{
				count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_ASSEMBLY_HDR WHERE PREPARATION_TYPE = 'S'")).get("COUNT"));
				if(count == 0){
					count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_MFG_REQUEST_HDR WHERE PREPARATION_TYPE = 'S' AND REQUEST_STATUS = 'E'")).get("COUNT"));
				}		
				if(count == 0){
						count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_MFG_HDR WHERE PREPARATION_TYPE = 'S' AND FINALIZED_YN = 'N'")).get("COUNT"));
				}				 
			 }catch(Exception e){
				e.printStackTrace();
			}
			if(count>0)
				return true;
			else
				return false;
		}
		
		public Boolean getPrep_Extemp(){
			int count = 0;
			try{
					count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_MFG_REQUEST_HDR WHERE PREPARATION_TYPE = 'E' AND REQUEST_STATUS = 'E'")).get("COUNT"));
			 	
				if(count == 0){
						count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_MFG_HDR WHERE PREPARATION_TYPE = 'E' AND FINALIZED_YN = 'N'")).get("COUNT"));
				}				 
			 }catch(Exception e){
				e.printStackTrace();
			}
			if(count>0)
				return true;
			else
				return false;
		}
		
		public Boolean getPrep_Others(){
			int count = 0;
			try{
				count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_ASSEMBLY_HDR WHERE PREPARATION_TYPE = 'O'")).get("COUNT"));
				if(count == 0){
					count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_MFG_REQUEST_HDR WHERE PREPARATION_TYPE = 'O' AND REQUEST_STATUS = 'E'")).get("COUNT"));
				}		
				if(count == 0){
						count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_MFG_HDR WHERE PREPARATION_TYPE = 'O' AND FINALIZED_YN = 'N'")).get("COUNT"));
				}				 
			 }catch(Exception e){
				e.printStackTrace();
			}
			if(count>0)
				return true;
			else
				return false;
		}
		public Boolean getPrep_prepack(){
			int count = 0;
			
			try{
				count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_ASSEMBLY_HDR WHERE PREPARATION_TYPE = 'P'")).get("COUNT"));
				if(count == 0){
					count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_MFG_REQUEST_HDR WHERE PREPARATION_TYPE = 'P' AND REQUEST_STATUS = 'E'")).get("COUNT"));
				}		
				if(count == 0){
						count = Integer.parseInt((String)((HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_MFG_HDR WHERE PREPARATION_TYPE = 'P' AND FINALIZED_YN = 'N'")).get("COUNT"));
				}				 
			 }catch(Exception e){
				e.printStackTrace();
			}
			if(count>0)
				return true;
			else
				return false;
		}
//ends		
}
