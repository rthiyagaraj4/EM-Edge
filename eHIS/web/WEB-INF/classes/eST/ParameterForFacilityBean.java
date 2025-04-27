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
27/02/2014				43682			        Abdul Rabbani        27/02/2014      Abdul Rabbani     AMS-SCF-0275
--------------------------------------------------------------------------------------------------------------------------------------------
*/
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/02/2014				42063			        Suresh R           27/02/2014        Suresh R     AMS-CRF-0054(Added Item Based IssueReturn)
27/02/2015				52253			        Suresh R           27/02/2014        Suresh R     MMS-QH-CRF-0205(Added Allow Equivalent UOM’s for Physical Inventory Entry)
26/04/2016				56060				Badmavathi B					  					  PMG2015-CRF-INT-ST-0001(Use 'Authorize at Issue Store' privilege to Authorize)
31/01/2017				63276				Badmavathi B										  GHL-CRF-0446 Added column RESTRICT_SPLIT_GRN_BATCHES
1/2/2018				66368				Shazana 						  						GHL-CRF-0503 Added new column Include_Zero_Stock_QOH						
10/10/2019              IN:071343              B Haribabu                                         GHL-CRF-0608					
05/02/2021      TFS id:6938                     B Haribabu          05/02/2021       Manickam           MMS-DM-CRF-0174.3				
12/02/2021		TFS-14324						B.Haribabu			12/02/2021		 Manickam	  ST-PMG2020-COMN-CRF-0031-US001/05 - ST Facility Parameter
7/6/2021				TFS-19787				Shazana													MOHE-CRF-0084.1 

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
import java.sql.*;
import javax.sql.*;
import eCommon.Common.*;

public class ParameterForFacilityBean extends StAdapter implements Serializable { 

	private String def_store_code_for_rec;
	private String current_specific_phy_inv_id;
	private String def_tfr_doc_type_code;
	private String def_sal_doc_type_code;
	private String def_srt_doc_type_code;
	private String def_ret_doc_type_code;
	private String curr_proc_year;
	private String def_var_doc_type_code;
	private String def_iss_doc_type_code;
	private String def_urg_doc_type_code;
	private String current_phy_inv_id;
	private String def_prt_doc_type_code;
	private String def_rtv_doc_type_code;
	private String def_grn_doc_type_code;
	private String material_group_code;
	private String curr_proc_month;
	private String def_mfg_doc_type_code;
	private String def_adj_doc_type_code;
	private String def_obs_doc_type_code;
	private String def_bin_doc_type_code;
	private String def_stk_item_con_doc_type_code;
	private String def_spl_doc_type_code;
    private String adjustment_remarks;
    private String remarks_code;
    private String batch_look_up_entry_yn;
    private String appl_batches_in_phy_inv_entry;
	private String iss_ack_req_yn;
    private String iss_ret_ack_req_yn;
    private String stock_trans_ack_req_yn;
	private String dflt_item_search;    //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
	private String durn_for_start_date; //06/03/12Added by Rabbani #inc no:30909 on 12/03/12
	private String authorize_batch_change_yn;
	private String authorize_partial_qty_rmks_yn;
	private String item_image_catlg_path;
	private String cut_off_days; //Added By Sakti against CRF# - RUT-CRF-0081 inc#34757
  //  private String language_id;
   private String dflt_mfg_mode; //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
   private String dflt_Durn_for_ExpDate; //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts
   
   private String phy_inv_dev_yn; //Added by Sakti against Bru-HIMS-CRF-408
   
   private String Sal_Doc_Picked_yn;//Added by Sharanraj against GHL-CRF-0483
   
    private String iss_ret_based_on;//Added by suresh.r on 31-01-2014 against AMS-CRF-0054
	private String hdr_rems_mode; //Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014
	 private String allow_equal_UOM_yn;//Added by suresh.r on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253
	//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts 
	private String allow_authorize_at_issue_store;
	private String barcode_for_ack_req_yn;//Added for TFS id:6938
	private String issue_history_durn;//Added for MO-CRF-20166
	private String user_access_store_reports_yn;//Added for TFS id: 19787
	public String getUser_access_store_reports_yn() {
		return user_access_store_reports_yn;
	}
	public void setUser_access_store_reports_yn(String user_access_store_reports_yn) {
		this.user_access_store_reports_yn = user_access_store_reports_yn;
	}//19787 end 
	public String getAllow_authorize_at_issue_store() {
		return allow_authorize_at_issue_store;
	}
	//Added for IN:071343 start
	public String getRestrict_request_exd_max_stock() {
		return restrict_request_exd_max_stock;
	}
	
	public void setRestrict_request_exd_max_stock(
			String restrict_request_exd_max_stock) {
		this.restrict_request_exd_max_stock = checkForNull(restrict_request_exd_max_stock,"N");
	}
	//Added for IN:071343 end
	public void setAllow_authorize_at_issue_store(String allow_authorize_at_issue_store) {
		this.allow_authorize_at_issue_store = checkForNull(allow_authorize_at_issue_store,"N");
	}
	//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends 
	//Added against GHL-CRF-0446 starts
	private String restrict_split_GRN_batches;
	private String restrict_request_exd_max_stock;//Added for IN:071343
	private boolean site_spec_yn = false;
	
	/*Added Against ghl-crf-0503 Split batch Start*/
	private String include_Zero_Stock_QOH;
	
	public String getInclude_Zero_Stock_QOH() {
		return include_Zero_Stock_QOH;
	}
	public void setInclude_Zero_Stock_QOH(String include_Zero_Stock_QOH) {
		this.include_Zero_Stock_QOH = checkForNull(include_Zero_Stock_QOH,"N");
	}
	/*Added Against ghl-crf-0503 Split batch END*/
	public boolean isSite_spec_yn() {
		return site_spec_yn;
	}
	public void setSite_spec_yn(boolean site_spec_yn) {
		this.site_spec_yn = site_spec_yn;
	}
	public String getRestrict_split_GRN_batches() {
		return restrict_split_GRN_batches;
	}
	public void setRestrict_split_GRN_batches(String restrict_split_GRN_batches) {
		this.restrict_split_GRN_batches = checkForNull(restrict_split_GRN_batches,"N");
	}
	//Added against GHL-CRF-0446 ends
	public void setDef_store_code_for_rec(String def_store_code_for_rec) {
		 this.def_store_code_for_rec = checkForNull(def_store_code_for_rec);
	}

	public String getDef_store_code_for_rec( ) {
		 return def_store_code_for_rec;
	}
	/*	public void setLanguageId(String language_id) {
		 this.language_id= language_id;
	}

	public String getLanguageId( ) {
		 return language_id;
	}
*/
	public void setCurrent_specific_phy_inv_id(String current_specific_phy_inv_id) {
		 this.current_specific_phy_inv_id = checkForNull(current_specific_phy_inv_id);
	}

	public String getCurrent_specific_phy_inv_id( ) {
		 return current_specific_phy_inv_id;
	}

	public void setDef_bin_doc_type_code(String def_bin_doc_type_code) {
		 this.def_bin_doc_type_code = checkForNull(def_bin_doc_type_code);
	}

	public String getDef_bin_doc_type_code( ) {
		 return def_bin_doc_type_code;
	}

	public void setDef_stk_item_con_doc_type_code(String def_stk_item_con_doc_type_code) {
		 this.def_stk_item_con_doc_type_code = checkForNull(def_stk_item_con_doc_type_code);
	}

	public String getDef_stk_item_con_doc_type_code() {
		 return def_stk_item_con_doc_type_code;
	}

	public void setDef_spl_doc_type_code(String def_spl_doc_type_code) {
		 this.def_spl_doc_type_code = checkForNull(def_spl_doc_type_code);
	}

	public String getDef_spl_doc_type_code( ) {
		 return def_spl_doc_type_code;
	}

	public void setDef_tfr_doc_type_code(String def_tfr_doc_type_code) {
		 this.def_tfr_doc_type_code = checkForNull(def_tfr_doc_type_code);
	}

	public String getDef_tfr_doc_type_code( ) {
		 return def_tfr_doc_type_code;
	}

	public void setDef_srt_doc_type_code(String def_srt_doc_type_code) {
		 this.def_srt_doc_type_code = checkForNull(def_srt_doc_type_code);
	}

	public String getDef_srt_doc_type_code( ) {
		 return def_srt_doc_type_code;
	}

	public void setDef_sal_doc_type_code(String def_sal_doc_type_code) {
		 this.def_sal_doc_type_code = checkForNull(def_sal_doc_type_code);
	}

	public String getDef_sal_doc_type_code( ) {
		 return def_sal_doc_type_code;
	}

	public void setDef_ret_doc_type_code(String def_ret_doc_type_code) {
		 this.def_ret_doc_type_code = checkForNull(def_ret_doc_type_code);
	}

	public String getDef_ret_doc_type_code( ) {
		 return def_ret_doc_type_code;
	}

	public void setCurr_proc_year(String curr_proc_year) {
		 this.curr_proc_year = curr_proc_year;
	}

	public String getCurr_proc_year( ) {
		 return curr_proc_year;
	}

	public void setDef_var_doc_type_code(String def_var_doc_type_code) {
		 this.def_var_doc_type_code = checkForNull(def_var_doc_type_code);
	}

	public String getDef_var_doc_type_code( ) {
		 return def_var_doc_type_code;
	}

	public void setDef_iss_doc_type_code(String def_iss_doc_type_code) {
		 this.def_iss_doc_type_code = checkForNull(def_iss_doc_type_code);
	}

	public String getDef_iss_doc_type_code( ) {
		 return def_iss_doc_type_code;
	}

	public void setDef_urg_doc_type_code(String def_urg_doc_type_code) {
		 this.def_urg_doc_type_code = checkForNull(def_urg_doc_type_code);
	}

	public String getDef_urg_doc_type_code( ) {
		 return def_urg_doc_type_code;
	}

	public void setCurrent_phy_inv_id(String current_phy_inv_id) {
		 this.current_phy_inv_id = checkForNull(current_phy_inv_id);
	}

	public String getCurrent_phy_inv_id( ) {
		 return current_phy_inv_id;
	}

	public void setDef_prt_doc_type_code(String def_prt_doc_type_code) {
		 this.def_prt_doc_type_code = checkForNull(def_prt_doc_type_code);
	}

	public String getDef_prt_doc_type_code( ) {
		 return def_prt_doc_type_code;
	}

	public void setDef_rtv_doc_type_code(String def_rtv_doc_type_code) {
		 this.def_rtv_doc_type_code = checkForNull(def_rtv_doc_type_code);
	}

	public String getDef_rtv_doc_type_code( ) {
		 return def_rtv_doc_type_code;
	}

	public void setDef_grn_doc_type_code(String def_grn_doc_type_code) {
		 this.def_grn_doc_type_code = checkForNull(def_grn_doc_type_code);
	}

	public String getDef_grn_doc_type_code( ) {
		 return def_grn_doc_type_code;
	}

	public void setMaterial_group_code(String material_group_code) {
		 this.material_group_code = material_group_code;
	}

	public String getMaterial_group_code( ) {
		 return material_group_code;
	}

	public void setCurr_proc_month(String curr_proc_month) {
		 this.curr_proc_month = curr_proc_month;
	}

	public String getCurr_proc_month( ) {
		 return curr_proc_month;
	}

	public void setDef_mfg_doc_type_code(String def_mfg_doc_type_code) {
		 this.def_mfg_doc_type_code = checkForNull(def_mfg_doc_type_code);
	}

	public String getDef_mfg_doc_type_code( ) {
		 return def_mfg_doc_type_code;
	}

	public void setDef_adj_doc_type_code(String def_adj_doc_type_code) {
		 this.def_adj_doc_type_code = checkForNull(def_adj_doc_type_code);
	}

	public String getDef_adj_doc_type_code( ) {
		 return def_adj_doc_type_code;
	}

	public void setDef_obs_doc_type_code(String def_obs_doc_type_code) {
		 this.def_obs_doc_type_code = checkForNull(def_obs_doc_type_code);
	}

	public String getDef_obs_doc_type_code( ) {
		 return def_obs_doc_type_code;
	}


	public void setDef_adjustment_remarks(String adjustment_remarks) {
		 this.adjustment_remarks = checkForNull(adjustment_remarks);
	}

	public String getDef_adjustment_remarks() {
		 return adjustment_remarks;
	}
	public void setRemarks_code(String remarks_code) {
		 this.remarks_code = checkForNull(remarks_code);
	}

	public String getRemarks_code() {
		 return remarks_code;
	}
	

	public void setBatch_look_up_entry_yn(String batch_look_up_entry_yn) {
		 this.batch_look_up_entry_yn = checkForNull(batch_look_up_entry_yn,"N");
	}
	public String getBatch_look_up_entry_yn() {
		 return batch_look_up_entry_yn;
	}
	
	public void setAppl_batches_in_phy_inv_entry(String appl_batches_in_phy_inv_entry) {
		 this.appl_batches_in_phy_inv_entry = checkForNull(appl_batches_in_phy_inv_entry,"ALL");
	}
		
	public String getAppl_batches_in_phy_inv_entry() {
		 return appl_batches_in_phy_inv_entry;
	}
//Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
	public void setDflt_item_search(String dflt_item_search) {
		 this.dflt_item_search = checkForNull(dflt_item_search);
	}
		
	public String getDflt_item_search() {
		 return dflt_item_search;
	}
//Added ends

//Added by Rabbani #inc no:30909 on 12/03/12 Starts
 public void setDurn_for_start_date(String durn_for_start_date) {
		 this.durn_for_start_date = checkForNull(durn_for_start_date);
	}
		
	public String getDurn_for_start_date() {
		 return durn_for_start_date;
	}
	
	//ends
	public void setIss_ack_req_yn(String iss_ack_req_yn) {
		 this.iss_ack_req_yn = checkForNull(iss_ack_req_yn,"N");
	}
	public String getIss_ack_req_yn() {
		 return iss_ack_req_yn;
	}
	public void setIss_ret_ack_req_yn(String iss_ret_ack_req_yn) {
		 this.iss_ret_ack_req_yn = checkForNull(iss_ret_ack_req_yn,"N");
	}

	public String getIss_ret_ack_req_yn() {
		 return iss_ret_ack_req_yn;
	}
	public void setStock_trans_ack_req_yn(String stock_trans_ack_req_yn) {
		 this.stock_trans_ack_req_yn = checkForNull(stock_trans_ack_req_yn,"N");
	}

	public String getStock_trans_ack_req_yn() {
		 return stock_trans_ack_req_yn;
	}
	
	
	public void setAuthorize_batch_change_yn(String authorize_batch_change_yn) {
		 this.authorize_batch_change_yn = checkForNull(authorize_batch_change_yn,"N");
	}
	public String getAuthorize_batch_change_yn() {
		 return authorize_batch_change_yn;
	}
	
	public void setAuthorize_partial_qty_rmks_yn(String authorize_partial_qty_rmks_yn) {
		 this.authorize_partial_qty_rmks_yn = checkForNull(authorize_partial_qty_rmks_yn,"N");
	}
	public String getAuthorize_partial_qty_rmks_yn() {
		 return authorize_partial_qty_rmks_yn;
	}

	public void setItem_image_catlg_path(String item_image_catlg_path) {
		 this.item_image_catlg_path = checkForNull(item_image_catlg_path);
	}
		
	public String getItem_image_catlg_path() {
		 return item_image_catlg_path;
	}

//Added By Sakti against CRF# - RUT-CRF-0081 inc#34757
	public void setCut_off_days(String cut_off_days) {
		 this.cut_off_days = checkForNull(cut_off_days);
	}
		
	public String getCut_off_days() {
		 return cut_off_days;
	}
//Added ends

  //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 Starts
 public void setDflt_mfg_mode(String dflt_mfg_mode) {
		 this.dflt_mfg_mode = checkForNull(dflt_mfg_mode);
	}
	public String getDflt_mfg_mode() {
		 return dflt_mfg_mode;
	}
	//ends
	
	//Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 
 public void setDflt_Durn_for_ExpDate(String dflt_Durn_for_ExpDate) {
		 this.dflt_Durn_for_ExpDate = checkForNull(dflt_Durn_for_ExpDate);
	}
		
	public String getDflt_Durn_for_ExpDate() {
		 return dflt_Durn_for_ExpDate;
	}
	
	//ends
	
	 //Added by Sakti #Inc no:45332(Bru-HIMS-CRF-408) on 20-JAN-2014 Starts
	 public void setPhy_inv_dev_yn(String phy_inv_dev_yn) {
			 this.phy_inv_dev_yn = checkForNull(phy_inv_dev_yn,"N");
		}
		public String getPhy_inv_dev_yn() {
			 return phy_inv_dev_yn;
		}
		//ends
	//Added by suresh.r on 31-01-2014 against AMS-CRF-0054 beg

		
	//Added by sharanraj against GHL-CRF-0483 starts	
		 public void setSal_Doc_Picked_yn(String Sal_Doc_Picked_yn) {
			 this.Sal_Doc_Picked_yn = checkForNull(Sal_Doc_Picked_yn,"N");
		}
		public String getSal_Doc_Picked_yn() {
			 return Sal_Doc_Picked_yn;
		}
	//Added by sharanraj against GHL-CRF-0483 ends	
		
		
	public String getIss_ret_based_on() {
		return iss_ret_based_on;
	}

	public void setIss_ret_based_on(String iss_ret_based_on) {
		this.iss_ret_based_on = iss_ret_based_on;
	}
	//Added by suresh.r on 31-01-2014 against AMS-CRF-0054 end	
		
	//Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014
	public String getHdrrems_mode() {
		return hdr_rems_mode;
	}
	public void setHdrrems_mode(String hdr_rems_mode) {
		this.hdr_rems_mode = hdr_rems_mode;
	}
	//ends
	//Added by suresh.r on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253 beg
	public String getAllow_equal_UOM_yn() {
		return allow_equal_UOM_yn;
	}

	public void setAllow_equal_UOM_yn(String allow_equal_UOM_yn) {
		this.allow_equal_UOM_yn = checkForNull(allow_equal_UOM_yn,"N");
	}
	//Added by suresh.r on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253 end
	//Added for TFS id:6938 start
	public void setBarcodeForAckReqYN(String barcode_for_ack_req_yn) {
		 this.barcode_for_ack_req_yn = checkForNull(barcode_for_ack_req_yn,"N");
	}
	public String getBarcodeForAckReqYN() {
		 return barcode_for_ack_req_yn;
	}
	//Added for TFS id:6938 end
	//Adding start for MO-CRF-20166
	 public void setIssueHistoryDurn(String issue_history_durn) {
			 this.issue_history_durn = issue_history_durn;
		}
		public String getIssueHistoryDurn() {
			 return issue_history_durn;
		}
	//Adding end for MO-CRF-20166
	public void setAll(Hashtable htRecordSet){
	
		super.setAll(htRecordSet);
		setDef_store_code_for_rec((String) htRecordSet.get("def_store_code_for_rec"));
		setCurrent_specific_phy_inv_id((String) htRecordSet.get("current_specific_phy_inv_id"));
		setDef_bin_doc_type_code((String) htRecordSet.get("def_bin_doc_type_code"));
		setDef_stk_item_con_doc_type_code((String) htRecordSet.get("def_stk_item_con_doc_type_code"));
		setDef_spl_doc_type_code((String) htRecordSet.get("def_spl_doc_type_code"));
		setDef_tfr_doc_type_code((String) htRecordSet.get("def_tfr_doc_type_code"));
		setDef_srt_doc_type_code((String) htRecordSet.get("def_srt_doc_type_code"));
		setDef_sal_doc_type_code((String) htRecordSet.get("def_sal_doc_type_code"));
		setDef_ret_doc_type_code((String) htRecordSet.get("def_ret_doc_type_code"));
		setCurr_proc_year((String) htRecordSet.get("curr_proc_year"));
		setDef_var_doc_type_code((String) htRecordSet.get("def_var_doc_type_code"));
		setDef_iss_doc_type_code((String) htRecordSet.get("def_iss_doc_type_code"));
		setDef_urg_doc_type_code((String) htRecordSet.get("def_urg_doc_type_code"));
		setCurrent_phy_inv_id((String) htRecordSet.get("current_phy_inv_id"));
		setDef_prt_doc_type_code((String) htRecordSet.get("def_prt_doc_type_code"));
		setDef_rtv_doc_type_code((String) htRecordSet.get("def_rtv_doc_type_code"));
		setDef_grn_doc_type_code((String) htRecordSet.get("def_grn_doc_type_code"));
		setCurr_proc_month((String) htRecordSet.get("curr_proc_month"));
		setDef_mfg_doc_type_code((String) htRecordSet.get("def_mfg_doc_type_code"));
		setDef_adj_doc_type_code((String) htRecordSet.get("def_adj_doc_type_code"));
		setDef_obs_doc_type_code((String) htRecordSet.get("def_obs_doc_type_code"));
        setDef_adjustment_remarks((String) htRecordSet.get("adjustment_remarks"));
        setBatch_look_up_entry_yn((String) htRecordSet.get("batch_look_up_entry_yn"));
        setAppl_batches_in_phy_inv_entry((String) htRecordSet.get("appl_batches_in_phy_inv_entry"));
		setRemarks_code((String) htRecordSet.get("remarks_code"));
		setIss_ack_req_yn((String) htRecordSet.get("iss_ack_req_yn"));
		setIss_ret_ack_req_yn((String) htRecordSet.get("iss_ret_ack_req_yn"));
		setStock_trans_ack_req_yn((String) htRecordSet.get("stock_trans_ack_req_yn"));
		setDflt_item_search((String) htRecordSet.get("dflt_item_search")); //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		setDurn_for_start_date((String) htRecordSet.get("durn_for_start_date"));  //Added by Rabbani #inc no:30909 on 12/03/12
		setAuthorize_batch_change_yn((String) htRecordSet.get("authorize_batch_change_yn"));
		setAuthorize_partial_qty_rmks_yn((String) htRecordSet.get("authorize_partial_qty_rmks_yn"));
		setItem_image_catlg_path((String) htRecordSet.get("item_image_catlg_path"));
		setCut_off_days((String) htRecordSet.get("cut_off_days")); //Added By Sakti against CRF# - RUT-CRF-0081 inc#34757
		setDflt_mfg_mode((String) htRecordSet.get("dflt_mfg_mode")); //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 13-FEB-2013
		setDflt_Durn_for_ExpDate((String) htRecordSet.get("dflt_Durn_for_ExpDate")); //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 
		
		setPhy_inv_dev_yn((String) htRecordSet.get("phy_inv_dev_yn")); //Added By Sakti against CRF# - Bru-HIMS-CRF-408
		
		setSal_Doc_Picked_yn((String) htRecordSet.get("Sal_Doc_Picked_yn"));//Added by sharanraj against GHL-CRF-0483
		
		setIss_ret_based_on((String) htRecordSet.get("iss_ret_based_on"));//Added by suresh.r on 31-01-2014 against AMS-CRF-0054
		setHdrrems_mode((String) htRecordSet.get("hdr_rems_mode")); //Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014
		setAllow_equal_UOM_yn((String) htRecordSet.get("allow_equal_UOM_yn")); //Added by suresh.r on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253
		setAllow_authorize_at_issue_store((String)htRecordSet.get("allow_authorize_at_issue_store"));//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 
		setRestrict_split_GRN_batches((String)htRecordSet.get("restrict_split_GRN_batches"));//Added against GHL-CRF-0446 
		setInclude_Zero_Stock_QOH((String)htRecordSet.get("include_Zero_Stock_QOH")); //Added against ghl-crf-0503 Split Batch 
		setRestrict_request_exd_max_stock((String)htRecordSet.get("restrict_request_exd_max_stock"));//Added for IN:071343
		setBarcodeForAckReqYN((String) htRecordSet.get("barcode_for_ack_req_yn"));//Added for TFS id:6938
		String issue_history_durn_val =(String)htRecordSet.get("issue_history_durn");//Adding start for MO-CRF-20166
		if(issue_history_durn_val.equals(""))
			issue_history_durn_val="0";
		setIssueHistoryDurn(issue_history_durn_val);//Adding end for MO-CRF-20166
		setUser_access_store_reports_yn(checkForNull((String)htRecordSet.get("user_access_store_reports_yn"),"N"));//Added for TFS id:19787
	}

	public HashMap validate() throws Exception{
		HashMap hmReturn = getMessageHashMap(true);	
		String stParameters[] = {getCurr_proc_month(),com.ehis.util.DateUtils.convertDate(getCurr_proc_year(),"YY",getLanguageId(),"en")}; //Modified for TBMC-SCF-0018
		HashMap hmRecord	=	fetchRecord(getStRepositoryValue("SQL_SY_ACC_PERIOD_DEFN_SELECT_COUNT"),stParameters);
		if (hmRecord.get("TOTAL").toString().equals("0")) {
			hmReturn.put(RESULT, FALSE);
//Changed By Mahesh on 3/19/2008 as this message id is not present in Common Messages.java(Refer StController for validation Code)
			//hmReturn.put(MSGID, "INVALID_PERIOD_MONTH_YEAR");
			hmReturn.put(MESSAGE, getSTMessage(getLanguageId(),"INVALID_PERIOD_MONTH_YEAR","ST"));
		}
		return hmReturn;
	}

	public void clear(){
		super.clear();
		def_store_code_for_rec="";
		current_specific_phy_inv_id="";
		def_tfr_doc_type_code="";
		def_srt_doc_type_code="";
		def_bin_doc_type_code="";
		def_stk_item_con_doc_type_code="";
		def_spl_doc_type_code="";
		def_sal_doc_type_code="";
		def_ret_doc_type_code="";
		curr_proc_year="";
		def_var_doc_type_code="";
		def_iss_doc_type_code="";
		def_urg_doc_type_code="";
		current_phy_inv_id="";
		def_prt_doc_type_code="";
		def_rtv_doc_type_code="";
		def_grn_doc_type_code="";
		material_group_code="";
		curr_proc_month="";
		def_mfg_doc_type_code="";
		def_obs_doc_type_code="";
        adjustment_remarks="";
		remarks_code="";
		batch_look_up_entry_yn = "";
		appl_batches_in_phy_inv_entry = "ALL";
		iss_ack_req_yn="";
		iss_ret_ack_req_yn="";
		stock_trans_ack_req_yn="";
		dflt_item_search = ""; //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		durn_for_start_date = ""; //Added by Rabbani #inc no:30909 on 12/03/12
		authorize_batch_change_yn = "";
		authorize_partial_qty_rmks_yn="";
		item_image_catlg_path = "";
		cut_off_days = "";
		dflt_Durn_for_ExpDate = ""; //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts 
		phy_inv_dev_yn  ="";
		
		Sal_Doc_Picked_yn=""; // Added by Sharanraj against GHL-CRF-0483
		
		iss_ret_based_on= "";//Added by suresh.r on 31-01-2014 against AMS-CRF-0054
		hdr_rems_mode = ""; //Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014
		allow_equal_UOM_yn="";//Added by suresh.r on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253
		allow_authorize_at_issue_store="";//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001  
		restrict_split_GRN_batches = "";//Added against GHL-CRF-0446 
		site_spec_yn = false;//Added against GHL-CRF-0446 
		include_Zero_Stock_QOH="";//Added against ghl-crf-0503 Split Batch CRF
		barcode_for_ack_req_yn="";//Added for TFS id:6938
		restrict_request_exd_max_stock=""; //Added for TFS-14324
		issue_history_durn ="";//Added for MO-CRF-20166
		
	}

	public HashMap insert() {
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		alInsertData.add(getLoginFacilityId            ());
		alInsertData.add(getMaterial_group_code        ());
		alInsertData.add(getCurr_proc_month            ());
		alInsertData.add(getCurr_proc_year             ());
		alInsertData.add(getDef_store_code_for_rec     ());
		alInsertData.add(getDef_grn_doc_type_code      ());
		alInsertData.add(getDef_rtv_doc_type_code      ());
		alInsertData.add(getDef_mfg_doc_type_code      ());
		alInsertData.add(getDef_iss_doc_type_code      ());
		alInsertData.add(getDef_ret_doc_type_code      ());
		alInsertData.add(getDef_urg_doc_type_code      ());
		alInsertData.add(getDef_tfr_doc_type_code      ());
		alInsertData.add(getDef_adj_doc_type_code      ());
		alInsertData.add(getDef_var_doc_type_code      ());
		alInsertData.add(getDef_prt_doc_type_code      ());
		alInsertData.add(getDef_sal_doc_type_code      ());
		alInsertData.add(getDef_srt_doc_type_code      ());
		alInsertData.add(getDef_obs_doc_type_code      ());
		alInsertData.add(getDef_bin_doc_type_code      ());
		alInsertData.add(getDef_spl_doc_type_code      ());
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getDef_stk_item_con_doc_type_code());
		alInsertData.add(getRemarks_code());
        alInsertData.add(getBatch_look_up_entry_yn());
        alInsertData.add(getAppl_batches_in_phy_inv_entry());
		alInsertData.add(getIss_ack_req_yn());
        alInsertData.add(getIss_ret_ack_req_yn());
        alInsertData.add(getStock_trans_ack_req_yn());
		alInsertData.add(getDflt_item_search()); //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		alInsertData.add(getDurn_for_start_date()); //Added by Rabbani #inc no:30909 on 12/03/12
		alInsertData.add(getAuthorize_batch_change_yn());
		alInsertData.add(getAuthorize_partial_qty_rmks_yn());
		alInsertData.add(getItem_image_catlg_path());
		alInsertData.add(getCut_off_days());
		alInsertData.add(getDflt_mfg_mode()); //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
		alInsertData.add(getDflt_Durn_for_ExpDate()); //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 
		
		alInsertData.add(getPhy_inv_dev_yn()); //Added by Sakti CRF#(Bru-HIMS-CRF-408) on 20-JAN-2014
		alInsertData.add(getSal_Doc_Picked_yn());//Added by Sharanraj against GHL-CRF-0483
		alInsertData.add(getIss_ret_based_on());//Added by suresh.r on 31-01-2014 against AMS-CRF-0054
		alInsertData.add(getHdrrems_mode()); //Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014
		alInsertData.add(getAllow_equal_UOM_yn()); //Added by suresh.r on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253
		alInsertData.add(getAllow_authorize_at_issue_store());//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001  
		alInsertData.add(getRestrict_split_GRN_batches());//Added against GHL-CRF-0446 
		alInsertData.add(getInclude_Zero_Stock_QOH());//Added against ghl-crf-0503 SPlit BAtch CRF
		alInsertData.add(getRestrict_request_exd_max_stock());//Added for IN:071343
		alInsertData.add(getIssueHistoryDurn());//Added for MO-CRF-20166
		alInsertData.add(getBarcodeForAckReqYN());//Added for TFS id:6938		
		alInsertData.add(getUser_access_store_reports_yn());//Added for TFS id:19787 
		//Commented by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
		//hmSQLMap.put( "InsertSQL", "INSERT	INTO ST_FACILITY_PARAM(FACILITY_ID,	MATERIAL_GROUP_CODE, CURR_PROC_MONTH, CURR_PROC_YEAR, DEF_STORE_CODE_FOR_REC, DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE,	DEF_ISS_DOC_TYPE_CODE, DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE,	DEF_ADJ_DOC_TYPE_CODE, DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE,	DEF_SRT_DOC_TYPE_CODE, DEF_OBS_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE,	ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS )	VALUES (?, ?, ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, SYSDATE, ?, ?, ?,	SYSDATE, ?,	?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
		//hmSQLMap.put( "InsertSQL", "INSERT	INTO ST_FACILITY_PARAM(FACILITY_ID,	MATERIAL_GROUP_CODE, CURR_PROC_MONTH, CURR_PROC_YEAR, DEF_STORE_CODE_FOR_REC, DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE,	DEF_ISS_DOC_TYPE_CODE, DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE,	DEF_ADJ_DOC_TYPE_CODE, DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE,	DEF_SRT_DOC_TYPE_CODE, DEF_OBS_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE,	ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE )	VALUES (?, ?, ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, SYSDATE, ?, ?, ?,	SYSDATE, ?,	?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		//Modified by Sakti CRF#(Bru-HIMS-CRF-408) on 20-JAN-2014 added PHY_INV_DEV_YN
		//hmSQLMap.put( "InsertSQL", "INSERT	INTO ST_FACILITY_PARAM(FACILITY_ID,	MATERIAL_GROUP_CODE, CURR_PROC_MONTH, CURR_PROC_YEAR, DEF_STORE_CODE_FOR_REC, DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE,	DEF_ISS_DOC_TYPE_CODE, DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE,	DEF_ADJ_DOC_TYPE_CODE, DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE,	DEF_SRT_DOC_TYPE_CODE, DEF_OBS_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE,	ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN )	VALUES (?, ?, ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, SYSDATE, ?, ?, ?,	SYSDATE, ?,	?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		
		//Modified by suresh.r on 31-01-2014 against AMS-CRF-0054 added ISS_RET_BASED_ON
		//hmSQLMap.put( "InsertSQL", "INSERT	INTO ST_FACILITY_PARAM(FACILITY_ID,	MATERIAL_GROUP_CODE, CURR_PROC_MONTH, CURR_PROC_YEAR, DEF_STORE_CODE_FOR_REC, DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE,	DEF_ISS_DOC_TYPE_CODE, DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE,	DEF_ADJ_DOC_TYPE_CODE, DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE,	DEF_SRT_DOC_TYPE_CODE, DEF_OBS_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE,	ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN,ISS_RET_BASED_ON )	VALUES (?, ?, ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, SYSDATE, ?, ?, ?,	SYSDATE, ?,	?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");		
		//Modified by suresh.r(added ALLOW_EQVL_UOMS_PHY_INV_ENTRY) on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253
		//hmSQLMap.put( "InsertSQL", "INSERT	INTO ST_FACILITY_PARAM(FACILITY_ID,	MATERIAL_GROUP_CODE, CURR_PROC_MONTH, CURR_PROC_YEAR, DEF_STORE_CODE_FOR_REC, DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE,	DEF_ISS_DOC_TYPE_CODE, DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE,	DEF_ADJ_DOC_TYPE_CODE, DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE,	DEF_SRT_DOC_TYPE_CODE, DEF_OBS_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE,	ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN,ISS_RET_BASED_ON,HDR_RMKS_MODE,ALLOW_EQVL_UOMS_PHY_INV_ENTRY)	VALUES (?, ?, ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, SYSDATE, ?, ?, ?,	SYSDATE, ?,	?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 
		//hmSQLMap.put( "InsertSQL", "INSERT	INTO ST_FACILITY_PARAM(FACILITY_ID,	MATERIAL_GROUP_CODE, CURR_PROC_MONTH, CURR_PROC_YEAR, DEF_STORE_CODE_FOR_REC, DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE,	DEF_ISS_DOC_TYPE_CODE, DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE,	DEF_ADJ_DOC_TYPE_CODE, DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE,	DEF_SRT_DOC_TYPE_CODE, DEF_OBS_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE,	ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN,ISS_RET_BASED_ON,HDR_RMKS_MODE,ALLOW_EQVL_UOMS_PHY_INV_ENTRY, ALLOW_AUTHORIZE_AT_ISSUE_STORE)	VALUES (?, ?, ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, SYSDATE, ?, ?, ?,	SYSDATE, ?,	?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		//Modified against GHL-CRF-0446 
		
		//inserted SAL_DOC_PICKED_YN into ST_FACILITY_PARAM table against GHL-CRF-0483 
		//hmSQLMap.put( "InsertSQL", "INSERT	INTO ST_FACILITY_PARAM(FACILITY_ID,	MATERIAL_GROUP_CODE, CURR_PROC_MONTH, CURR_PROC_YEAR, DEF_STORE_CODE_FOR_REC, DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE,	DEF_ISS_DOC_TYPE_CODE, DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE,	DEF_ADJ_DOC_TYPE_CODE, DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE,	DEF_SRT_DOC_TYPE_CODE, DEF_OBS_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE,	ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN,SAL_DOC_PICKED_YN,ISS_RET_BASED_ON,HDR_RMKS_MODE,ALLOW_EQVL_UOMS_PHY_INV_ENTRY, ALLOW_AUTHORIZE_AT_ISSUE_STORE, RESTRICT_SPLIT_GRN_BATCHES)	VALUES (?, ?, ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?,?, ?, SYSDATE, ?, ?, ?,	SYSDATE, ?,	?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); //Added by sharanraj against GHL-CRF-0483
		hmSQLMap.put( "InsertSQL", "INSERT	   INTO ST_FACILITY_PARAM(FACILITY_ID,	MATERIAL_GROUP_CODE, CURR_PROC_MONTH, CURR_PROC_YEAR, DEF_STORE_CODE_FOR_REC, DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE,	DEF_ISS_DOC_TYPE_CODE, DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE,	DEF_ADJ_DOC_TYPE_CODE, DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE,	DEF_SRT_DOC_TYPE_CODE, DEF_OBS_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE,	ADDED_BY_ID, ADDED_AT_WS_NO, ADDED_FACILITY_ID,	MODIFIED_BY_ID,	MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN,SAL_DOC_PICKED_YN,ISS_RET_BASED_ON,HDR_RMKS_MODE,ALLOW_EQVL_UOMS_PHY_INV_ENTRY, ALLOW_AUTHORIZE_AT_ISSUE_STORE, RESTRICT_SPLIT_GRN_BATCHES,INCLUDE_ZERO_STOCK_QOH,RESTRICT_REQ_EXD_MAX_STOCK,DURN_FOR_ISS_HISTORY,ADDED_DATE,MODIFIED_DATE,BARCODE_FOR_ACK_REQ_YN,RESTRICT_USER_ACCESS_STORE_YN)	VALUES (?, ?, ?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?, ?, ?,	?, ?,?, ?, ?, ?, ?,	 ?,	?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,SYSDATE,SYSDATE,?,?)");//Chnaged Added Date and Modified date position to last Values for ARYU-SCF-0049//Modified for IN:071343,Modified for TFS id:6938 added new column barcode_for_ack_req_yn,DURN_FOR_ISS_HISTORY Added for MO-CRF-20166,modified for TFS 19787 
		//hmSQLMap.put( "InsertSQL", getStRepositoryValue("SQL_ST_FACILITY_PARAM_INSERT")	);
		hmSQLMap.put( "SelectSQL", getStRepositoryValue("SQL_ST_FACILITY_PARAM_COUNT")	);

		alWhereData.add(getLoginFacilityId());
		alWhereData.add(getMaterial_group_code());

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

//		alModifyData.add(getCurrent_phy_inv_id         ());
//		alModifyData.add(getCurrent_specific_phy_inv_id());
		alModifyData.add(getDef_store_code_for_rec     ());
		alModifyData.add(getDef_grn_doc_type_code      ());
		alModifyData.add(getDef_rtv_doc_type_code      ());
		alModifyData.add(getDef_mfg_doc_type_code      ());
		alModifyData.add(getDef_iss_doc_type_code      ());
		alModifyData.add(getDef_ret_doc_type_code      ());
		alModifyData.add(getDef_urg_doc_type_code      ());
		alModifyData.add(getDef_tfr_doc_type_code      ());
		alModifyData.add(getDef_adj_doc_type_code      ());
		alModifyData.add(getDef_var_doc_type_code      ());
		alModifyData.add(getDef_prt_doc_type_code      ());
		alModifyData.add(getDef_sal_doc_type_code      ());
		alModifyData.add(getDef_srt_doc_type_code      ());
		alModifyData.add(getDef_obs_doc_type_code      ());
		alModifyData.add(getDef_bin_doc_type_code      ());
		alModifyData.add(getDef_spl_doc_type_code      ());
		alModifyData.add(getLoginById());      
		alModifyData.add(getLoginAtWsNo());    
		alModifyData.add(getLoginFacilityId());
        alModifyData.add(getDef_stk_item_con_doc_type_code());
	    alModifyData.add(getRemarks_code());
	    alModifyData.add(getBatch_look_up_entry_yn());
	    alModifyData.add(getAppl_batches_in_phy_inv_entry());
		alModifyData.add(getIss_ack_req_yn());
	    alModifyData.add(getIss_ret_ack_req_yn());
	    alModifyData.add(getStock_trans_ack_req_yn());
		alModifyData.add(getDflt_item_search()); //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
        alModifyData.add(getDurn_for_start_date()); //Added by Rabbani #inc no:30909 on 12/03/12
		alModifyData.add(getAuthorize_batch_change_yn());
		alModifyData.add(getAuthorize_partial_qty_rmks_yn());
		alModifyData.add(getItem_image_catlg_path());
		alModifyData.add(getCut_off_days());
		alModifyData.add(getDflt_mfg_mode()); //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
		alModifyData.add(getDflt_Durn_for_ExpDate()); //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 
		
		alModifyData.add(getPhy_inv_dev_yn()); //Added by Sakti CRF#(Bru-HIMS-CRF-408) on 20-JAN-2014
		
		alModifyData.add(getSal_Doc_Picked_yn());//Added by Sharanraj against GHL-CRF-0483
		
		alModifyData.add(getIss_ret_based_on());//Added by suresh.r on 31-01-2014 against AMS-CRF-0054
		alModifyData.add(getHdrrems_mode()); //Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014
		alModifyData.add(getAllow_equal_UOM_yn()); //Added by suresh.r on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253
		alModifyData.add(getAllow_authorize_at_issue_store());//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 
		alModifyData.add(getRestrict_split_GRN_batches());//Added against GHL-CRF-0446 
		alModifyData.add(getInclude_Zero_Stock_QOH());//Added against ghl-crf-0503 split batch
		alModifyData.add(getRestrict_request_exd_max_stock());//Added for IN:071343
		alModifyData.add(getBarcodeForAckReqYN());//Added for TFS id:6938
		alModifyData.add(getIssueHistoryDurn());//Added for MO-CRF-20166
		alModifyData.add((getUser_access_store_reports_yn()));		//added for tfs id: 19787
		System.out.println("getUser_access_store_reports_yn(): "+getUser_access_store_reports_yn()); 
		alModifyData.add(getLoginFacilityId		  ());
		alModifyData.add(getMaterial_group_code	  ());

		//Commented by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
		//hmSQLMap.put( "ModifySQL", "UPDATE	ST_FACILITY_PARAM SET DEF_STORE_CODE_FOR_REC=?, DEF_GRN_DOC_TYPE_CODE=?, DEF_RTV_DOC_TYPE_CODE=?, DEF_MFG_DOC_TYPE_CODE=?,	DEF_ISS_DOC_TYPE_CODE=?, DEF_RET_DOC_TYPE_CODE=?, DEF_URG_DOC_TYPE_CODE=?, DEF_TFR_DOC_TYPE_CODE=?,	DEF_ADJ_DOC_TYPE_CODE=?, DEF_VAR_DOC_TYPE_CODE=?, DEF_PRT_DOC_TYPE_CODE=?, DEF_SAL_DOC_TYPE_CODE=?,	DEF_SRT_DOC_TYPE_CODE=?, DEF_OBS_DOC_TYPE_CODE=?, DEF_BIN_DOC_TYPE_CODE=?, DEF_SPL_DOC_TYPE_CODE=?,	MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,DEF_STK_ITEM_CON_DOC_TYPE_CODE=?,DEF_ADJ_REMARKS=?,PHY_INV_BATCH_LOOKUP_ENTRY_YN=?,APPL_BATCHES_IN_PHY_INV_ENTRY=?,ISS_ACK_REQ_YN=?,RET_ACK_REQ_YN=?,TFR_ACK_REQ_YN=?,DFLT_ITEM_SEARCH=?,DURN_FOR_START_DATE = ? ,ALLOW_BATCH_CHANGE_ON_AUTH = ?, ALLOW_PARTIALQTY_WO_RMKS = ? ,ITEM_IMAGE_CATLG_PATH = ?, DFLT_CUTOFF_DAYS = ? WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?");
		
		//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
		//hmSQLMap.put( "ModifySQL", "UPDATE	ST_FACILITY_PARAM SET DEF_STORE_CODE_FOR_REC=?, DEF_GRN_DOC_TYPE_CODE=?, DEF_RTV_DOC_TYPE_CODE=?, DEF_MFG_DOC_TYPE_CODE=?,	DEF_ISS_DOC_TYPE_CODE=?, DEF_RET_DOC_TYPE_CODE=?, DEF_URG_DOC_TYPE_CODE=?, DEF_TFR_DOC_TYPE_CODE=?,	DEF_ADJ_DOC_TYPE_CODE=?, DEF_VAR_DOC_TYPE_CODE=?, DEF_PRT_DOC_TYPE_CODE=?, DEF_SAL_DOC_TYPE_CODE=?,	DEF_SRT_DOC_TYPE_CODE=?, DEF_OBS_DOC_TYPE_CODE=?, DEF_BIN_DOC_TYPE_CODE=?, DEF_SPL_DOC_TYPE_CODE=?,	MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,DEF_STK_ITEM_CON_DOC_TYPE_CODE=?,DEF_ADJ_REMARKS=?,PHY_INV_BATCH_LOOKUP_ENTRY_YN=?,APPL_BATCHES_IN_PHY_INV_ENTRY=?,ISS_ACK_REQ_YN=?,RET_ACK_REQ_YN=?,TFR_ACK_REQ_YN=?,DFLT_ITEM_SEARCH=?,DURN_FOR_START_DATE = ? ,ALLOW_BATCH_CHANGE_ON_AUTH = ?, ALLOW_PARTIALQTY_WO_RMKS = ? ,ITEM_IMAGE_CATLG_PATH = ?, DFLT_CUTOFF_DAYS = ?,DFLT_MFG_MODE = ?,DFLT_DURN_FOR_EXPDATE = ? WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?");
		
		//Modified by Sakti CRF#(Bru-HIMS-CRF-408) on 20-JAN-2014 added PHY_INV_DEV_YN
		//hmSQLMap.put( "ModifySQL", "UPDATE	ST_FACILITY_PARAM SET DEF_STORE_CODE_FOR_REC=?, DEF_GRN_DOC_TYPE_CODE=?, DEF_RTV_DOC_TYPE_CODE=?, DEF_MFG_DOC_TYPE_CODE=?,	DEF_ISS_DOC_TYPE_CODE=?, DEF_RET_DOC_TYPE_CODE=?, DEF_URG_DOC_TYPE_CODE=?, DEF_TFR_DOC_TYPE_CODE=?,	DEF_ADJ_DOC_TYPE_CODE=?, DEF_VAR_DOC_TYPE_CODE=?, DEF_PRT_DOC_TYPE_CODE=?, DEF_SAL_DOC_TYPE_CODE=?,	DEF_SRT_DOC_TYPE_CODE=?, DEF_OBS_DOC_TYPE_CODE=?, DEF_BIN_DOC_TYPE_CODE=?, DEF_SPL_DOC_TYPE_CODE=?,	MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,DEF_STK_ITEM_CON_DOC_TYPE_CODE=?,DEF_ADJ_REMARKS=?,PHY_INV_BATCH_LOOKUP_ENTRY_YN=?,APPL_BATCHES_IN_PHY_INV_ENTRY=?,ISS_ACK_REQ_YN=?,RET_ACK_REQ_YN=?,TFR_ACK_REQ_YN=?,DFLT_ITEM_SEARCH=?,DURN_FOR_START_DATE = ? ,ALLOW_BATCH_CHANGE_ON_AUTH = ?, ALLOW_PARTIALQTY_WO_RMKS = ? ,ITEM_IMAGE_CATLG_PATH = ?, DFLT_CUTOFF_DAYS = ?,DFLT_MFG_MODE = ?,DFLT_DURN_FOR_EXPDATE = ?, PHY_INV_DEV_YN = ? WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?");
		
		//Modified by suresh.r on 31-01-2014 against AMS-CRF-0054 beg added ISS_RET_BASED_ON
		//hmSQLMap.put( "ModifySQL", "UPDATE	ST_FACILITY_PARAM SET DEF_STORE_CODE_FOR_REC=?, DEF_GRN_DOC_TYPE_CODE=?, DEF_RTV_DOC_TYPE_CODE=?, DEF_MFG_DOC_TYPE_CODE=?,	DEF_ISS_DOC_TYPE_CODE=?, DEF_RET_DOC_TYPE_CODE=?, DEF_URG_DOC_TYPE_CODE=?, DEF_TFR_DOC_TYPE_CODE=?,	DEF_ADJ_DOC_TYPE_CODE=?, DEF_VAR_DOC_TYPE_CODE=?, DEF_PRT_DOC_TYPE_CODE=?, DEF_SAL_DOC_TYPE_CODE=?,	DEF_SRT_DOC_TYPE_CODE=?, DEF_OBS_DOC_TYPE_CODE=?, DEF_BIN_DOC_TYPE_CODE=?, DEF_SPL_DOC_TYPE_CODE=?,	MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,DEF_STK_ITEM_CON_DOC_TYPE_CODE=?,DEF_ADJ_REMARKS=?,PHY_INV_BATCH_LOOKUP_ENTRY_YN=?,APPL_BATCHES_IN_PHY_INV_ENTRY=?,ISS_ACK_REQ_YN=?,RET_ACK_REQ_YN=?,TFR_ACK_REQ_YN=?,DFLT_ITEM_SEARCH=?,DURN_FOR_START_DATE = ? ,ALLOW_BATCH_CHANGE_ON_AUTH = ?, ALLOW_PARTIALQTY_WO_RMKS = ? ,ITEM_IMAGE_CATLG_PATH = ?, DFLT_CUTOFF_DAYS = ?,DFLT_MFG_MODE = ?,DFLT_DURN_FOR_EXPDATE = ?, PHY_INV_DEV_YN = ? ,ISS_RET_BASED_ON=? WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?");
		//Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014//Modified by suresh.r(added ALLOW_EQVL_UOMS_PHY_INV_ENTRY) on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253
		//hmSQLMap.put( "ModifySQL", "UPDATE	ST_FACILITY_PARAM SET DEF_STORE_CODE_FOR_REC=?, DEF_GRN_DOC_TYPE_CODE=?, DEF_RTV_DOC_TYPE_CODE=?, DEF_MFG_DOC_TYPE_CODE=?,	DEF_ISS_DOC_TYPE_CODE=?, DEF_RET_DOC_TYPE_CODE=?, DEF_URG_DOC_TYPE_CODE=?, DEF_TFR_DOC_TYPE_CODE=?,	DEF_ADJ_DOC_TYPE_CODE=?, DEF_VAR_DOC_TYPE_CODE=?, DEF_PRT_DOC_TYPE_CODE=?, DEF_SAL_DOC_TYPE_CODE=?,	DEF_SRT_DOC_TYPE_CODE=?, DEF_OBS_DOC_TYPE_CODE=?, DEF_BIN_DOC_TYPE_CODE=?, DEF_SPL_DOC_TYPE_CODE=?,	MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,DEF_STK_ITEM_CON_DOC_TYPE_CODE=?,DEF_ADJ_REMARKS=?,PHY_INV_BATCH_LOOKUP_ENTRY_YN=?,APPL_BATCHES_IN_PHY_INV_ENTRY=?,ISS_ACK_REQ_YN=?,RET_ACK_REQ_YN=?,TFR_ACK_REQ_YN=?,DFLT_ITEM_SEARCH=?,DURN_FOR_START_DATE = ? ,ALLOW_BATCH_CHANGE_ON_AUTH = ?, ALLOW_PARTIALQTY_WO_RMKS = ? ,ITEM_IMAGE_CATLG_PATH = ?, DFLT_CUTOFF_DAYS = ?,DFLT_MFG_MODE = ?,DFLT_DURN_FOR_EXPDATE = ?, PHY_INV_DEV_YN = ? ,ISS_RET_BASED_ON=? , HDR_RMKS_MODE = ?,ALLOW_EQVL_UOMS_PHY_INV_ENTRY=? WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?");
		//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		//hmSQLMap.put( "ModifySQL", "UPDATE	ST_FACILITY_PARAM SET DEF_STORE_CODE_FOR_REC=?, DEF_GRN_DOC_TYPE_CODE=?, DEF_RTV_DOC_TYPE_CODE=?, DEF_MFG_DOC_TYPE_CODE=?,	DEF_ISS_DOC_TYPE_CODE=?, DEF_RET_DOC_TYPE_CODE=?, DEF_URG_DOC_TYPE_CODE=?, DEF_TFR_DOC_TYPE_CODE=?,	DEF_ADJ_DOC_TYPE_CODE=?, DEF_VAR_DOC_TYPE_CODE=?, DEF_PRT_DOC_TYPE_CODE=?, DEF_SAL_DOC_TYPE_CODE=?,	DEF_SRT_DOC_TYPE_CODE=?, DEF_OBS_DOC_TYPE_CODE=?, DEF_BIN_DOC_TYPE_CODE=?, DEF_SPL_DOC_TYPE_CODE=?,	MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,DEF_STK_ITEM_CON_DOC_TYPE_CODE=?,DEF_ADJ_REMARKS=?,PHY_INV_BATCH_LOOKUP_ENTRY_YN=?,APPL_BATCHES_IN_PHY_INV_ENTRY=?,ISS_ACK_REQ_YN=?,RET_ACK_REQ_YN=?,TFR_ACK_REQ_YN=?,DFLT_ITEM_SEARCH=?,DURN_FOR_START_DATE = ? ,ALLOW_BATCH_CHANGE_ON_AUTH = ?, ALLOW_PARTIALQTY_WO_RMKS = ? ,ITEM_IMAGE_CATLG_PATH = ?, DFLT_CUTOFF_DAYS = ?,DFLT_MFG_MODE = ?,DFLT_DURN_FOR_EXPDATE = ?, PHY_INV_DEV_YN = ? ,ISS_RET_BASED_ON=? , HDR_RMKS_MODE = ?,ALLOW_EQVL_UOMS_PHY_INV_ENTRY=?, ALLOW_AUTHORIZE_AT_ISSUE_STORE = ? WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?");
		//Modified against GHL-CRF-0446 
		//hmSQLMap.put( "ModifySQL", "UPDATE	ST_FACILITY_PARAM SET DEF_STORE_CODE_FOR_REC=?, DEF_GRN_DOC_TYPE_CODE=?, DEF_RTV_DOC_TYPE_CODE=?, DEF_MFG_DOC_TYPE_CODE=?,	DEF_ISS_DOC_TYPE_CODE=?, DEF_RET_DOC_TYPE_CODE=?, DEF_URG_DOC_TYPE_CODE=?, DEF_TFR_DOC_TYPE_CODE=?,	DEF_ADJ_DOC_TYPE_CODE=?, DEF_VAR_DOC_TYPE_CODE=?, DEF_PRT_DOC_TYPE_CODE=?, DEF_SAL_DOC_TYPE_CODE=?,	DEF_SRT_DOC_TYPE_CODE=?, DEF_OBS_DOC_TYPE_CODE=?, DEF_BIN_DOC_TYPE_CODE=?, DEF_SPL_DOC_TYPE_CODE=?,	MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,DEF_STK_ITEM_CON_DOC_TYPE_CODE=?,DEF_ADJ_REMARKS=?,PHY_INV_BATCH_LOOKUP_ENTRY_YN=?,APPL_BATCHES_IN_PHY_INV_ENTRY=?,ISS_ACK_REQ_YN=?,RET_ACK_REQ_YN=?,TFR_ACK_REQ_YN=?,DFLT_ITEM_SEARCH=?,DURN_FOR_START_DATE = ? ,ALLOW_BATCH_CHANGE_ON_AUTH = ?, ALLOW_PARTIALQTY_WO_RMKS = ? ,ITEM_IMAGE_CATLG_PATH = ?, DFLT_CUTOFF_DAYS = ?,DFLT_MFG_MODE = ?,DFLT_DURN_FOR_EXPDATE = ?, PHY_INV_DEV_YN = ? , SAL_DOC_PICKED_YN=?,  ISS_RET_BASED_ON=? , HDR_RMKS_MODE = ?,ALLOW_EQVL_UOMS_PHY_INV_ENTRY=?, ALLOW_AUTHORIZE_AT_ISSUE_STORE = ?, RESTRICT_SPLIT_GRN_BATCHES=? WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?"); //Added by sharanraj against GHL-CRF-0483
		hmSQLMap.put( "ModifySQL", "UPDATE	ST_FACILITY_PARAM SET DEF_STORE_CODE_FOR_REC=?, DEF_GRN_DOC_TYPE_CODE=?, DEF_RTV_DOC_TYPE_CODE=?, DEF_MFG_DOC_TYPE_CODE=?,	DEF_ISS_DOC_TYPE_CODE=?, DEF_RET_DOC_TYPE_CODE=?, DEF_URG_DOC_TYPE_CODE=?, DEF_TFR_DOC_TYPE_CODE=?,	DEF_ADJ_DOC_TYPE_CODE=?, DEF_VAR_DOC_TYPE_CODE=?, DEF_PRT_DOC_TYPE_CODE=?, DEF_SAL_DOC_TYPE_CODE=?,	DEF_SRT_DOC_TYPE_CODE=?, DEF_OBS_DOC_TYPE_CODE=?, DEF_BIN_DOC_TYPE_CODE=?, DEF_SPL_DOC_TYPE_CODE=?,	MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID=?,DEF_STK_ITEM_CON_DOC_TYPE_CODE=?,DEF_ADJ_REMARKS=?,PHY_INV_BATCH_LOOKUP_ENTRY_YN=?,APPL_BATCHES_IN_PHY_INV_ENTRY=?,ISS_ACK_REQ_YN=?,RET_ACK_REQ_YN=?,TFR_ACK_REQ_YN=?,DFLT_ITEM_SEARCH=?,DURN_FOR_START_DATE = ? ,ALLOW_BATCH_CHANGE_ON_AUTH = ?, ALLOW_PARTIALQTY_WO_RMKS = ? ,ITEM_IMAGE_CATLG_PATH = ?, DFLT_CUTOFF_DAYS = ?,DFLT_MFG_MODE = ?,DFLT_DURN_FOR_EXPDATE = ?, PHY_INV_DEV_YN = ? , SAL_DOC_PICKED_YN=?,  ISS_RET_BASED_ON=? , HDR_RMKS_MODE = ?,ALLOW_EQVL_UOMS_PHY_INV_ENTRY=?, ALLOW_AUTHORIZE_AT_ISSUE_STORE = ?, RESTRICT_SPLIT_GRN_BATCHES=? , INCLUDE_ZERO_STOCK_QOH=? , RESTRICT_REQ_EXD_MAX_STOCK=?, BARCODE_FOR_ACK_REQ_YN=? , DURN_FOR_ISS_HISTORY=? , RESTRICT_USER_ACCESS_STORE_YN=? WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?");//Modified for IN:071343,Modified for TFS id:6938, modified for tfs id: 19787
		//hmSQLMap.put( "ModifySQL", getStRepositoryValue("SQL_ST_FACILITY_PARAM_UPDATE"));

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);
		hmTableData.put("LanguageData",LanguageData);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public boolean recordExists() throws Exception{
		String stParameters[]={getLoginFacilityId(),getMaterial_group_code()};
		HashMap hmResult = fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_PARAM_COUNT"), stParameters);
		return !((String)hmResult.get("TOTAL")).equals("0");
	}

	public String getDef_store_code_for_rec_List(){
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(getLanguageId());
			return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_ST_STORE_SELECT_LIST_GRN"),alParameters), getDef_store_code_for_rec());
	}

	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameters=new ArrayList();
		alParameters.add(getLoginFacilityId());
		alParameters.add(trn_type);
		alParameters.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_ST_TRN_DOC_TYPE_SELECT_LIST"),alParameters),defaultValue);
	}

	public String getDef_spl_doc_type_code_List(){
		return getDefaultDocumentTypeList("SPB",getDef_spl_doc_type_code());
	}

	public String getDef_bin_doc_type_code_List(){
		return getDefaultDocumentTypeList("CBL",getDef_bin_doc_type_code());
	}

	public String getDef_grn_doc_type_code_List(){
		return getDefaultDocumentTypeList("GRN",getDef_grn_doc_type_code());
	}

	public String getDef_rtv_doc_type_code_List(){
		return getDefaultDocumentTypeList("RTV",getDef_rtv_doc_type_code());
	}

	public String getDef_iss_doc_type_code_List(){
		return getDefaultDocumentTypeList("ISS",getDef_iss_doc_type_code());
	}

	public String getDef_mfg_doc_type_code_List(){
		return getDefaultDocumentTypeList("MFG",getDef_mfg_doc_type_code());
	}

	public String getDef_ret_doc_type_code_List(){
		return getDefaultDocumentTypeList("RET",getDef_ret_doc_type_code());
	}

	public String getDef_urg_doc_type_code_List(){
		return getDefaultDocumentTypeList("URG",getDef_urg_doc_type_code());
	}

	public String getDef_trf_doc_type_code_List(){
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

	
	public String getDef_srt_doc_type_code_List(){
		return getDefaultDocumentTypeList("SRT",getDef_srt_doc_type_code());
	}

	public String getDef_tfr_doc_type_code_List(){
		return getDefaultDocumentTypeList("TFR",getDef_tfr_doc_type_code());
	}

	/* Over-ridden Adapter methods end here */
	/* Function specific methods start */
	public void loadData() throws Exception {
		String []stParameters=	{getLoginFacilityId(), getMaterial_group_code()};
		HashMap hmRecord	=	null;
		//hmRecord	=	fetchRecord(getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		//hmRecord	=	fetchRecord("SELECT	TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) SYS_DATE,CURR_PROC_MONTH, CURR_PROC_YEAR, CURR_PHY_INV_ID, CURR_SPEC_PHY_INV_ID, DEF_STORE_CODE_FOR_REC,	DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE, DEF_ISS_DOC_TYPE_CODE,	DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE, DEF_ADJ_DOC_TYPE_CODE,	DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE, DEF_SRT_DOC_TYPE_CODE,	DEF_OBS_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE FROM ST_FACILITY_PARAM WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?", stParameters);
		
		//Modified by Sakti CRF#(Bru-HIMS-CRF-408) on 20-JAN-2014 added PHY_INV_DEV_YN
		//hmRecord	=	fetchRecord("SELECT	TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) SYS_DATE,CURR_PROC_MONTH, CURR_PROC_YEAR, CURR_PHY_INV_ID, CURR_SPEC_PHY_INV_ID, DEF_STORE_CODE_FOR_REC,	DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE, DEF_ISS_DOC_TYPE_CODE,	DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE, DEF_ADJ_DOC_TYPE_CODE,	DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE, DEF_SRT_DOC_TYPE_CODE,	DEF_OBS_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?", stParameters);
		
		//Modified by suresh.r on 31-01-2014 against AMS-CRF-0054 beg added ISS_RET_BASED_ON
		//hmRecord	=	fetchRecord("SELECT	TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) SYS_DATE,CURR_PROC_MONTH, CURR_PROC_YEAR, CURR_PHY_INV_ID, CURR_SPEC_PHY_INV_ID, DEF_STORE_CODE_FOR_REC,	DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE, DEF_ISS_DOC_TYPE_CODE,	DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE, DEF_ADJ_DOC_TYPE_CODE,	DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE, DEF_SRT_DOC_TYPE_CODE,	DEF_OBS_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN,ISS_RET_BASED_ON FROM ST_FACILITY_PARAM WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?", stParameters);
		//Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014//Modified by suresh.r(added ALLOW_EQVL_UOMS_PHY_INV_ENTRY) on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253
		//hmRecord	=	fetchRecord("SELECT	TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) SYS_DATE,CURR_PROC_MONTH, CURR_PROC_YEAR, CURR_PHY_INV_ID, CURR_SPEC_PHY_INV_ID, DEF_STORE_CODE_FOR_REC,	DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE, DEF_ISS_DOC_TYPE_CODE,	DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE, DEF_ADJ_DOC_TYPE_CODE,	DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE, DEF_SRT_DOC_TYPE_CODE,	DEF_OBS_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN,ISS_RET_BASED_ON,HDR_RMKS_MODE,ALLOW_EQVL_UOMS_PHY_INV_ENTRY FROM ST_FACILITY_PARAM WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?", stParameters);
		//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001  
		//hmRecord	=	fetchRecord("SELECT	TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) SYS_DATE,CURR_PROC_MONTH, CURR_PROC_YEAR, CURR_PHY_INV_ID, CURR_SPEC_PHY_INV_ID, DEF_STORE_CODE_FOR_REC,	DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE, DEF_ISS_DOC_TYPE_CODE,	DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE, DEF_ADJ_DOC_TYPE_CODE,	DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE, DEF_SRT_DOC_TYPE_CODE,	DEF_OBS_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN,ISS_RET_BASED_ON,HDR_RMKS_MODE,ALLOW_EQVL_UOMS_PHY_INV_ENTRY, ALLOW_AUTHORIZE_AT_ISSUE_STORE FROM ST_FACILITY_PARAM WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?", stParameters);
		//Modifed against GHL-CRF-0446 
		//hmRecord	=	fetchRecord("SELECT	TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) SYS_DATE,CURR_PROC_MONTH, CURR_PROC_YEAR, CURR_PHY_INV_ID, CURR_SPEC_PHY_INV_ID, DEF_STORE_CODE_FOR_REC,	DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE, DEF_ISS_DOC_TYPE_CODE,	DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE, DEF_ADJ_DOC_TYPE_CODE,	DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE, DEF_SRT_DOC_TYPE_CODE,	DEF_OBS_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN,SAL_DOC_PICKED_YN,ISS_RET_BASED_ON,HDR_RMKS_MODE,ALLOW_EQVL_UOMS_PHY_INV_ENTRY, ALLOW_AUTHORIZE_AT_ISSUE_STORE, RESTRICT_SPLIT_GRN_BATCHES FROM ST_FACILITY_PARAM WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?", stParameters);//Added by sharanraj against GHL-CRF-0483
		hmRecord	=	fetchRecord("SELECT	TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) SYS_DATE,CURR_PROC_MONTH, CURR_PROC_YEAR, CURR_PHY_INV_ID, CURR_SPEC_PHY_INV_ID, DEF_STORE_CODE_FOR_REC,	DEF_GRN_DOC_TYPE_CODE, DEF_RTV_DOC_TYPE_CODE, DEF_MFG_DOC_TYPE_CODE, DEF_ISS_DOC_TYPE_CODE,	DEF_RET_DOC_TYPE_CODE, DEF_URG_DOC_TYPE_CODE, DEF_TFR_DOC_TYPE_CODE, DEF_ADJ_DOC_TYPE_CODE,	DEF_VAR_DOC_TYPE_CODE, DEF_PRT_DOC_TYPE_CODE, DEF_SAL_DOC_TYPE_CODE, DEF_SRT_DOC_TYPE_CODE,	DEF_OBS_DOC_TYPE_CODE, DEF_SPL_DOC_TYPE_CODE, DEF_BIN_DOC_TYPE_CODE, DEF_STK_ITEM_CON_DOC_TYPE_CODE,DEF_ADJ_REMARKS,PHY_INV_BATCH_LOOKUP_ENTRY_YN,APPL_BATCHES_IN_PHY_INV_ENTRY,ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN,DFLT_ITEM_SEARCH,DURN_FOR_START_DATE,ALLOW_BATCH_CHANGE_ON_AUTH,ALLOW_PARTIALQTY_WO_RMKS,ITEM_IMAGE_CATLG_PATH,DFLT_CUTOFF_DAYS,DFLT_MFG_MODE,DFLT_DURN_FOR_EXPDATE,PHY_INV_DEV_YN,SAL_DOC_PICKED_YN,ISS_RET_BASED_ON,HDR_RMKS_MODE,ALLOW_EQVL_UOMS_PHY_INV_ENTRY, ALLOW_AUTHORIZE_AT_ISSUE_STORE, RESTRICT_SPLIT_GRN_BATCHES,INCLUDE_ZERO_STOCK_QOH,RESTRICT_REQ_EXD_MAX_STOCK,BARCODE_FOR_ACK_REQ_YN, DURN_FOR_ISS_HISTORY , RESTRICT_USER_ACCESS_STORE_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID=? AND MATERIAL_GROUP_CODE=?", stParameters);//Added against ghl-crf-0503 Split Batch,Modified for TFS id:6938 , tfs id 19787
		setCurr_proc_month            ( checkForNull((String)hmRecord.get("CURR_PROC_MONTH" )	)) ;	
		setCurr_proc_year             ( checkForNull((String)hmRecord.get("CURR_PROC_YEAR" )	)) ;	
		setCurrent_phy_inv_id         ( checkForNull((String)hmRecord.get("CURRENT_PHY_INV_ID" )	)) ;	
		setCurrent_specific_phy_inv_id( checkForNull((String)hmRecord.get("CURRENT_SPECIFIC_PHY_INV_ID" )	)) ;	
		setDef_store_code_for_rec     ( checkForNull((String)hmRecord.get("DEF_STORE_CODE_FOR_REC" )	)) ;	
		setDef_grn_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_GRN_DOC_TYPE_CODE" )	)) ;	
		setDef_rtv_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_RTV_DOC_TYPE_CODE" )	)) ;	
		setDef_mfg_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_MFG_DOC_TYPE_CODE" )	)) ;	
		setDef_iss_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_ISS_DOC_TYPE_CODE" )	)) ;	
		setDef_ret_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_RET_DOC_TYPE_CODE" )	)) ;	
		setDef_urg_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_URG_DOC_TYPE_CODE" )	)) ;	
		setDef_tfr_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_TFR_DOC_TYPE_CODE" )	)) ;	
		setDef_adj_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_ADJ_DOC_TYPE_CODE" )	)) ;	
		setDef_obs_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_OBS_DOC_TYPE_CODE" )	)) ;	
		setDef_var_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_VAR_DOC_TYPE_CODE" )	)) ;	
		setDef_prt_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_PRT_DOC_TYPE_CODE" )	)) ;	
		setDef_sal_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_SAL_DOC_TYPE_CODE" )	)) ;	
		setDef_srt_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_SRT_DOC_TYPE_CODE" )	)) ;	
		setDef_spl_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_SPL_DOC_TYPE_CODE" )	)) ;	
		setDef_bin_doc_type_code      ( checkForNull((String)hmRecord.get("DEF_BIN_DOC_TYPE_CODE" )	)) ;	
		setDef_stk_item_con_doc_type_code( checkForNull((String)hmRecord.get("DEF_STK_ITEM_CON_DOC_TYPE_CODE" )	)) ;	
		setRemarks_code				  ( checkForNull((String)hmRecord.get("DEF_ADJ_REMARKS" ))) ;
		setBatch_look_up_entry_yn		  ( (String)hmRecord.get("PHY_INV_BATCH_LOOKUP_ENTRY_YN")) ;
		setAppl_batches_in_phy_inv_entry		  ( (String)hmRecord.get("APPL_BATCHES_IN_PHY_INV_ENTRY")) ;
		setIss_ack_req_yn		  ( (String)hmRecord.get("ISS_ACK_REQ_YN")) ;
		setIss_ret_ack_req_yn		  ( (String)hmRecord.get("RET_ACK_REQ_YN")) ;
		setStock_trans_ack_req_yn		  ( (String)hmRecord.get("TFR_ACK_REQ_YN")) ;
		setDflt_item_search		  ( (String)hmRecord.get("DFLT_ITEM_SEARCH")) ; //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		setDurn_for_start_date		  ( (String)hmRecord.get("DURN_FOR_START_DATE")) ; //Added by Rabbani #inc no:30909 on 12/03/12
		setAuthorize_batch_change_yn		  ( (String)hmRecord.get("ALLOW_BATCH_CHANGE_ON_AUTH")) ;
		setAuthorize_partial_qty_rmks_yn		  ( (String)hmRecord.get("ALLOW_PARTIALQTY_WO_RMKS")) ;
		setItem_image_catlg_path ( (String)hmRecord.get("ITEM_IMAGE_CATLG_PATH")) ;
		setCut_off_days ( (String)hmRecord.get("DFLT_CUTOFF_DAYS")) ;
		setDflt_mfg_mode( checkForNull((String)hmRecord.get("DFLT_MFG_MODE"),"R")) ; //Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013 
		setDflt_Durn_for_ExpDate( checkForNull((String)hmRecord.get("DFLT_DURN_FOR_EXPDATE"))) ; //Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 Starts
		
		setPhy_inv_dev_yn( checkForNull((String)hmRecord.get("PHY_INV_DEV_YN"),"R")) ; //Added by Sakti CRF#(Bru-HIMS-CRF-408) on 20-JAN-2014
	
		setSal_Doc_Picked_yn( checkForNull((String)hmRecord.get("SAL_DOC_PICKED_YN"),"R")) ; //Added by Sharanraj Against GHL-CRF-0483
		
		setIss_ret_based_on( checkForNull((String)hmRecord.get("ISS_RET_BASED_ON"),"D")) ;//Added by suresh.r on 31-01-2014 against AMS-CRF-0054
		setHdrrems_mode(checkForNull((String)hmRecord.get("HDR_RMKS_MODE"),"M")) ;//Added by Rabbani #Inc no:43682(AMS-SCF-0275) on 22-MAY-2014
		setAllow_equal_UOM_yn(checkForNull((String)hmRecord.get("ALLOW_EQVL_UOMS_PHY_INV_ENTRY"),"N")) ;//Added by suresh.r on 27-02-2015 against MMS-QH-CRF-0205 Inc 52253
		setAllow_authorize_at_issue_store(checkForNull((String)hmRecord.get("ALLOW_AUTHORIZE_AT_ISSUE_STORE"),"N"));//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		setRestrict_split_GRN_batches(checkForNull((String)hmRecord.get("RESTRICT_SPLIT_GRN_BATCHES"),"N"));//Added against GHL-CRF-0446 
		setInclude_Zero_Stock_QOH(checkForNull((String)hmRecord.get("INCLUDE_ZERO_STOCK_QOH"),"N")); // Added against ghl-crf-0503  Split bAtch 
		setRestrict_request_exd_max_stock(checkForNull((String)hmRecord.get("RESTRICT_REQ_EXD_MAX_STOCK"),"N"));//Added for IN:071343
		setBarcodeForAckReqYN((String)hmRecord.get("BARCODE_FOR_ACK_REQ_YN")) ;//Added for TFS id:6938
		setIssueHistoryDurn((String)hmRecord.get("DURN_FOR_ISS_HISTORY"));//Added for MO-CRF-20166
		setUser_access_store_reports_yn (checkForNull((String)hmRecord.get("RESTRICT_USER_ACCESS_STORE_YN"),"N"));  //TFS ID: 19787
		String remarks_desc=""; 
		String remarks_code_1=getRemarks_code();
		if(!remarks_code_1.equals(""))
		{	
			 remarks_desc=getRemarksDesc(remarks_code_1);
			
	}
        setDef_adjustment_remarks (remarks_desc) ;	

	}

	public String getRemarksDesc(String remarks_code1) {
		String []stParameters=	{remarks_code1, getLanguageId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord(getStRepositoryValue("SQL_MM_TRN_REM_SELECT"), stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return (String)hmRecord.get("REMARKS_DESC");
	}
	public Boolean getRecordCountForIssue() {
		String []stParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_ISSUE_HDR WHERE FINALIZED_YN = 'N' AND PROCESS_FOR_ACKNOWLEDGE = 'Y' AND FACILITY_ID = ?", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}
		if(!((String)hmRecord.get("COUNT")).equals("0"))
			return true;
		else
			return false;
	}

public Boolean getRecordCountForIssueReturn() {
	String []stParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_ISSUE_RET_HDR WHERE FINALIZED_YN = 'N' AND PROCESS_FOR_ACKNOWLEDGE = 'Y' AND FACILITY_ID = ? ", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}
		if(!((String)hmRecord.get("COUNT")).equals("0"))
			return true;
		else
			return false;
	}
public Boolean getRecordCountForStockTransfer() {
	String []stParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_TRANSFER_HDR WHERE FINALIZED_YN = 'N' AND PROCESS_FOR_ACKNOWLEDGE = 'Y' AND FACILITY_ID = ? ", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}
		if(!((String)hmRecord.get("COUNT")).equals("0"))
			return true;
		else
			return false;
	}


	public Boolean getPhyInvRecordCount() {
		String []stParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT count(*) count FROM st_phy_inv_param WHERE facility_id=? and posted_date is null and cancelled_date is null AND ENTRY_COMPLETED_YN = 'N'", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}
		if(((String)hmRecord.get("COUNT")).equals("0"))
			return false;
		else
			return true;
	}
/*		
//        ArrayList alEqvlUomCode = new ArrayList() ; 
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
		String remarksdescription = "";
        try {
            connection = getConnection();
			//String  sql="SELECT REMARKS_DESC FROM   MM_TRN_REMARKS WHERE EFF_STATUS = 'E' AND TRN_REMARKS_CODE= ? "; 
            pstmt = connection.prepareStatement(getStRepositoryValue("SQL_MM_TRN_REM_SELECT"));
			
            pstmt.setString(1, remarks_code1);
            pstmt.setString(2, getLanguageId());
		
			//pstmt.setString(2, repack_uom);
			resultSet = pstmt.executeQuery();
			 
            while (resultSet != null && resultSet.next()) 
			{
				remarksdescription = resultSet.getString("REMARKS_DESC");
				//alEqvlUomCode.add(eqvluom);
			}
        } 
		catch (Exception e) {
			 e.printStackTrace();
        } 
		finally {
            try{
                closeResultSet(resultSet);
                closeStatement(pstmt);
                closeConnection(connection);
            }catch(Exception es){
				es.printStackTrace();
            }
        }
		
		return remarksdescription;
	}
*/
	public String toString(){
		return "ParameterForFacility Bean";
	}
	/* To populate the SEARCH BY ITEM LIST in the front end list box for ITEM ON 21/10/2011*/
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
	//Added by Rabbani #Inc no:29950(Bru-HIMS-CRF-084) on 18-FEB-2013
	public String getDft_mode_mfg() {
		String []stParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT DFLT_MFG_MODE FROM	st_facility_param WHERE facility_id=?", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return "";
		}
		return (String)hmRecord.get("DFLT_MFG_MODE");
	}
	//ends
	//Added by suresh.r on 09-03-2015 against MMS-QH-CRF-0205 Inc 52253 beg
	public Boolean getRecordCountForPhyInvEntry() {
			HashMap hmRecord	=	null;
			try{
				hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_PHY_INV_DTL WHERE FACILITY_ID = ? ", getLoginFacilityId());
			}catch(Exception e){
				e.printStackTrace();
				return true;
			}
			if(!((String)hmRecord.get("COUNT")).equals("0"))
				return true;
			else
				return false;
		}
	//Added by suresh.r on 09-03-2015 against MMS-QH-CRF-0205 Inc 52253 end
}


 
