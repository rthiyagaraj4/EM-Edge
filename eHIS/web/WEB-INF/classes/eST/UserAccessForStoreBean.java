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
21/02/2016				57461					B.Badmavathi									  Product Transfer\Repackaging					
21/04/2016				56060					B.Badmavathi									  Authorize at Issue Store	
06/04/2022				TFSID-23934																  MO-CRF-20177 - Cancel Authorization at Issue Store
12/04/2022  			TFS:30369				Mohamed											  ML-MMOH-CRF-1821		
28/04/2022  			TFS29303				Mohamed											  MO-CRF-20174 - Reject Authorization at Issue Store		

--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eST ;

import java.io.Serializable;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import eST.Common.StAdapter;
import eCommon.SingleTableHandler.*;
import eCommon.Common.*;

public class UserAccessForStoreBean extends StAdapter implements Serializable {

   
	private String store_code;
	private String user_id;
	private String grn_allowed_yn;
	private String rtv_allowed_yn;
	private String mfg_allowed_yn;
	private String req_allowed_yn;
	private String iss_allowed_yn;
	private String urg_allowed_yn;
	private String ret_allowed_yn;
	private String tfr_allowed_yn;
	private String adj_allowed_yn;
	private String var_allowed_yn;
	private String prt_allowed_yn;
	private String sal_allowed_yn;
	private String srt_allowed_yn;
	private String obs_allowed_yn;
	private String cancel_request_yn;
	private String split_batch_allowed_yn;
	private String bin_change_allowed_yn;
	private String authorize_special_req_yn;
	private String process_expired_items_yn;
	private String process_suspended_items_yn;
	private String stk_item_con_allowed_yn;

	private String grn_finalize_allowed_yn;
	private String rtv_finalize_allowed_yn ;
    private String mfg_finalize_allowed_yn ;
	private String req_authorize_allowed_yn ;
    private String iss_finalize_allowed_yn  ;
	private String tfr_finalize_allowed_yn  ;
	private String adj_finalize_allowed_yn  ;
	private String sal_authorize_allowed_yn ;
	private String srt_finalize_allowed_yn  ; 
	private String urg_finalize_allowed_yn  ;
	private String ret_finalize_allowed_yn  ;
	private String iss_acknowledge_yn, iss_confirm_yn,urg_acknowledge_yn, urg_confirm_yn,ret_acknowledge_yn, ret_confirm_yn,tfr_acknowledge_yn, tfr_confirm_yn;
	private String prq_finalize_allowed_yn;
	private String cndmn_exp_btch_allowed_yn;
	private String prq_allowed_yn;
	private String interface_to_external_po_yn;
	private String view_sale_yn;  //Added By Rabbani #inc no:28266 on 16/09/11 
	private String view_cost_yn;
	private String dflt_item_search; //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
	private String trn_type;
	private String enable_yn;  
	private String dflt_sal_type;   // Added by Padmapriya 
	/* transaction audit trail*/
	private String req_delete_yn	=""; 
	private String urg_delete_yn	=""; 
	private String iss_delete_yn	="";  
	private String ret_delete_yn	=""; 
	private String adj_delete_yn	=""; 
	private String prt_delete_yn	=""; 
	private String sal_delete_yn	="";  
	private String srt_delete_yn	="";  
	private String grn_delete_yn	="";  
	private String rtv_delete_yn	="";  
	private String mfg_delete_yn	=""; 
	private String tfr_delete_yn	="";  
	private String prq_delete_yn	=""; 
	
	//Added for SKR-CRF-0039 By Ganga on 2nd Aug 2013
	private String grn_finalize_prompt_yn;
	private String rtv_finalize_prompt_yn ;
    private String mfg_finalize_prompt_yn ;
	private String req_authorize_prompt_yn ;
    private String iss_finalize_prompt_yn  ;
	private String tfr_finalize_prompt_yn  ;
	private String adj_finalize_prompt_yn  ;
	private String sal_authorize_prompt_yn ;
	private String srt_finalize_prompt_yn  ; 
	private String urg_finalize_prompt_yn  ;
	private String ret_finalize_prompt_yn  ;
	private String disp_curr_enc_findtl_yn  ;//Added by suresh.r 12-11-2013 against JD-CRF-156
	private String disp_min_rol_yn;//Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
	private String prt_finalize_allowed_yn; //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 
	private String prt_finalize_prompt_yn;  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 
	//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
	private boolean site_spec_yn = false;
	private String authorize_at_issue_store_allowed_yn; //Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
	private String cancel_authorize_iss_allow_yn; // TFS ID - 23934 - MO-CRF-20177 
	private String reject_request_issue_store_allowed_yn; // TFS ID - 23934 - MO-CRF-20177 
	public boolean isSite_spec_yn() {
		return site_spec_yn;
	}
	public void setSite_spec_yn(boolean site_spec_yn) {
		this.site_spec_yn = site_spec_yn;
	}//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
     ArrayList hmp = null;  //Added By Rabbani #inc no:28266 on 13/09/11 
   
	public void setGrn_finalize_allowed_yn(String grn_finalize_allowed_yn) {
		 this.grn_finalize_allowed_yn = checkForNull(grn_finalize_allowed_yn,"N");
	}
	public String getGrn_finalize_allowed_yn() {
		 return grn_finalize_allowed_yn;
	}

	public void setRtv_finalize_allowed_yn(String rtv_finalize_allowed_yn) {
		 this.rtv_finalize_allowed_yn = checkForNull(rtv_finalize_allowed_yn,"N");
	}
	public String getRtv_finalize_allowed_yn() {
		 return rtv_finalize_allowed_yn;
	}

    public void setMfg_finalize_allowed_yn(String mfg_finalize_allowed_yn) {
		 this.mfg_finalize_allowed_yn = checkForNull(mfg_finalize_allowed_yn,"N");
	}
	public String getMfg_finalize_allowed_yn() {
		 return mfg_finalize_allowed_yn;
	}
	public void setReq_authorize_allowed_yn(String req_authorize_allowed_yn) {
		 this.req_authorize_allowed_yn = checkForNull(req_authorize_allowed_yn,"N");
	}
	public String getReq_authorize_allowed_yn() {
		 return req_authorize_allowed_yn;
	}

    public void setIss_finalize_allowed_yn(String iss_finalize_allowed_yn) {
		 this.iss_finalize_allowed_yn = checkForNull(iss_finalize_allowed_yn,"N");
	}
	public String getIss_finalize_allowed_yn() {
		 return iss_finalize_allowed_yn;
	}

    public void setTfr_finalize_allowed_yn(String tfr_finalize_allowed_yn) {
		 this.tfr_finalize_allowed_yn = checkForNull(tfr_finalize_allowed_yn,"N");
	}
	public String getTfr_finalize_allowed_yn() {
		 return tfr_finalize_allowed_yn;
	}

    public void setAdj_finalize_allowed_yn(String adj_finalize_allowed_yn) {
		 this.adj_finalize_allowed_yn = checkForNull(adj_finalize_allowed_yn,"N");
	}
	public String getAdj_finalize_allowed_yn() {
		 return adj_finalize_allowed_yn;
	}

	public void setSal_authorize_allowed_yn(String sal_authorize_allowed_yn) {
		 this.sal_authorize_allowed_yn = checkForNull(sal_authorize_allowed_yn,"N");
	}
	public String getSal_authorize_allowed_yn() {
		 return sal_authorize_allowed_yn;
	}

  	public void setSrt_finalize_allowed_yn(String srt_finalize_allowed_yn) {
		 this.srt_finalize_allowed_yn = checkForNull(srt_finalize_allowed_yn,"N");
	}
	public String getSrt_finalize_allowed_yn() {
		 return srt_finalize_allowed_yn;
	}

    public void setUrg_finalize_allowed_yn(String urg_finalize_allowed_yn) {
		 this.urg_finalize_allowed_yn = checkForNull(urg_finalize_allowed_yn,"N");
	}
	public String getUrg_finalize_allowed_yn() {
		 return urg_finalize_allowed_yn;
	}

    public void setRet_finalize_allowed_yn(String ret_finalize_allowed_yn) {
		 this.ret_finalize_allowed_yn = checkForNull(ret_finalize_allowed_yn,"N");
	}
	public String getRet_finalize_allowed_yn() {
		 return ret_finalize_allowed_yn;
	}


	public void bin_change_allowed_yn(String bin_change_allowed_yn) {
		 this.bin_change_allowed_yn= checkForNull(bin_change_allowed_yn,"N");
	}

	public void split_batch_allowed_yn(String split_batch_allowed_yn) {
		 this.split_batch_allowed_yn = checkForNull(split_batch_allowed_yn,"N");
	}

	public void setSrt_allowed_yn(String srt_allowed_yn) {
		 this.srt_allowed_yn = checkForNull(srt_allowed_yn,"N");
	}

	public void setSal_allowed_yn(String sal_allowed_yn) {
		 this.sal_allowed_yn = checkForNull(sal_allowed_yn,"N");
	}
	public void setStk_item_con_allowed_yn(String stk_item_con_allowed_yn) {
		 this.stk_item_con_allowed_yn = checkForNull(stk_item_con_allowed_yn,"N");
	}

	public void setPrt_allowed_yn(String prt_allowed_yn) {
		 this.prt_allowed_yn = checkForNull(prt_allowed_yn,"N");
	}

	public void setVar_allowed_yn(String var_allowed_yn) {
		 this.var_allowed_yn = checkForNull(var_allowed_yn,"N");
	}

	public void setAdj_allowed_yn(String adj_allowed_yn) {
		 this.adj_allowed_yn = checkForNull(adj_allowed_yn,"N");
	}

	public void setTfr_allowed_yn(String tfr_allowed_yn) {
		 this.tfr_allowed_yn = checkForNull(tfr_allowed_yn,"N");
	}

	public void setRet_allowed_yn(String ret_allowed_yn) {
		 this.ret_allowed_yn = checkForNull(ret_allowed_yn,"N");
	}

	public void setUrg_allowed_yn(String urg_allowed_yn) {
		 this.urg_allowed_yn = checkForNull(urg_allowed_yn,"N");
	}

	public void setIss_allowed_yn(String iss_allowed_yn) {
		 this.iss_allowed_yn = checkForNull(iss_allowed_yn,"N");
	}

	public void setReq_allowed_yn(String req_allowed_yn) {
		 this.req_allowed_yn = checkForNull(req_allowed_yn,"N");
	}

	public void setMfg_allowed_yn(String mfg_allowed_yn) {
		 this.mfg_allowed_yn = checkForNull(mfg_allowed_yn,"N");
	}

	public void setGrn_allowed_yn(String grn_allowed_yn) {
		 this.grn_allowed_yn = checkForNull(grn_allowed_yn,"N");
	}

	public void setObs_allowed_yn(String obs_allowed_yn) {
		 this.obs_allowed_yn = checkForNull(obs_allowed_yn,"N");
	}

	public void setRtv_allowed_yn(String rtv_allowed_yn) {
		 this.rtv_allowed_yn = checkForNull(rtv_allowed_yn,"N");
	}

    public void setBin_change_allowed_yn(String bin_change_allowed_yn) {
		 this.bin_change_allowed_yn =checkForNull(bin_change_allowed_yn,"N");
	}
	public void setSplit_batch_allowed_yn(String split_batch_allowed_yn) {
		 this.split_batch_allowed_yn = checkForNull(split_batch_allowed_yn,"N");
	}

	public void setCndmn_exp_btch_allowed_yn(String cndmn_exp_btch_allowed_yn) {
		 this.cndmn_exp_btch_allowed_yn = checkForNull(cndmn_exp_btch_allowed_yn,"N");
	}
	
	public String getCndmn_exp_btch_allowed_yn() {
		 return cndmn_exp_btch_allowed_yn;
	}
	//Added By Rabbani #inc no:28266 on 16/09/11 
	//Starts Here
	public void setView_sale_yn(String view_sale_yn) {
		 this.view_sale_yn = checkForNull(view_sale_yn,"N");
	}
	
	public String getView_sale_yn() {
		 return view_sale_yn;
	} 
	public void setView_cost_yn(String view_cost_yn) {
		 this.view_cost_yn = checkForNull(view_cost_yn,"N");
	}
	
	public String getView_cost_yn() {
		 return view_cost_yn;
	}
	public void setTrn_type(String trn_type) {
		 this.trn_type = trn_type;
	}
	
	public String getTrn_type() {
		 return trn_type;
	}
	public void setEnable_yn(String enable_yn) {
		 this.enable_yn = checkForNull(enable_yn,"N");
	}
	
	public String getEnable_yn() {
		 return enable_yn;
	}  
	//Ends Here
	/* ends here */

 
	/* ends here */

    /* setter and getter for User_id and Store_code */

	public void setUser_id(String user_id) {
		 this.user_id = user_id;
	}
    public String getUser_id()  
	{
		return user_id;
	}
	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}
	public String getStore_code( ) {
		 return store_code;
	}
// Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria

	public void setDflt_item_search(String dflt_item_search) {
		 this.dflt_item_search = dflt_item_search;
	}
	public String getDflt_item_search() {
		 return dflt_item_search;
	}
//Added ends

	public void setCancelRequest_yn(String cancel_request_yn) {
		 this.cancel_request_yn = checkForNull(cancel_request_yn,"N");
	}
    /* setter and getter for User_id and Store_code ends here */ 
	
	// Start Added by Padmapriya 
	
	public void setDflt_sal_type(String dflt_sal_type) {
		 this.dflt_sal_type =  checkForNull(dflt_sal_type);
	}
	public String getDflt_sal_type() {
		 return  checkForNull(dflt_sal_type,"");
	}
	
	// End by Padmapriya 
	
	
	//Added for SKR-CRF-0039 
	public void setGrn_finalize_prompt_yn(String grn_finalize_prompt_yn) {
		 this.grn_finalize_prompt_yn = checkForNull(grn_finalize_prompt_yn,"N");
	}
	public String getGrn_finalize_prompt_yn() {
		 return grn_finalize_prompt_yn;
	}
	public void setRtv_finalize_prompt_yn(String rtv_finalize_prompt_yn) {
		 this.rtv_finalize_prompt_yn = checkForNull(rtv_finalize_prompt_yn,"N");
	}
	public String getRtv_finalize_prompt_yn() {
		 return rtv_finalize_prompt_yn;
	}

   public void setMfg_finalize_prompt_yn(String mfg_finalize_prompt_yn) {
		 this.mfg_finalize_prompt_yn = checkForNull(mfg_finalize_prompt_yn,"N");
	}
	public String getMfg_finalize_prompt_yn() {
		 return mfg_finalize_prompt_yn;
	}
	public void setReq_authorize_prompt_yn(String req_authorize_prompt_yn) {
		 this.req_authorize_prompt_yn = checkForNull(req_authorize_prompt_yn,"N");
	}
	public String getReq_authorize_prompt_yn() {
		 return req_authorize_prompt_yn;
	}

   public void setIss_finalize_prompt_yn(String iss_finalize_prompt_yn) {
		 this.iss_finalize_prompt_yn = checkForNull(iss_finalize_prompt_yn,"N");
	}
	public String getIss_finalize_prompt_yn() {
		 return iss_finalize_prompt_yn;
	}

   public void setTfr_finalize_prompt_yn(String tfr_finalize_prompt_yn) {
		 this.tfr_finalize_prompt_yn = checkForNull(tfr_finalize_prompt_yn,"N");
	}
	public String getTfr_finalize_prompt_yn() {
		 return tfr_finalize_prompt_yn;
	}

   public void setAdj_finalize_prompt_yn(String adj_finalize_prompt_yn) {
		 this.adj_finalize_prompt_yn = checkForNull(adj_finalize_prompt_yn,"N");
	}
	public String getAdj_finalize_prompt_yn() {
		 return adj_finalize_prompt_yn;
	}

	public void setSal_authorize_prompt_yn(String sal_authorize_prompt_yn) {
		 this.sal_authorize_prompt_yn = checkForNull(sal_authorize_prompt_yn,"N");
	}
	public String getSal_authorize_prompt_yn() {
		 return sal_authorize_prompt_yn;
	}

 	public void setSrt_finalize_prompt_yn(String srt_finalize_prompt_yn) {
		 this.srt_finalize_prompt_yn = checkForNull(srt_finalize_prompt_yn,"N");
	}
	public String getSrt_finalize_prompt_yn() {
		 return srt_finalize_prompt_yn;
	}

   public void setUrg_finalize_prompt_yn(String urg_finalize_prompt_yn) {
		 this.urg_finalize_prompt_yn = checkForNull(urg_finalize_prompt_yn,"N");
	}
	public String getUrg_finalize_prompt_yn() {
		 return urg_finalize_prompt_yn;
	}

   public void setRet_finalize_prompt_yn(String ret_finalize_prompt_yn) {
		 this.ret_finalize_prompt_yn = checkForNull(ret_finalize_prompt_yn,"N");
	}
	public String getRet_finalize_prompt_yn() {
		 return ret_finalize_prompt_yn;
	}
	//ended
	
	

	/* getter for transaction starts here */

	public String getGrn_allowed_yn() {
		 return grn_allowed_yn;
	}

	public String getRtv_allowed_yn( ) {
		 return rtv_allowed_yn;
	}

	public String getMfg_allowed_yn( ) {
		 return mfg_allowed_yn;
	}

	public String getReq_allowed_yn( ) {
		 return req_allowed_yn;
	}

	public String getIss_allowed_yn( ) {
		 return iss_allowed_yn;
	}

    public String getUrg_allowed_yn( ) {
		 return urg_allowed_yn;
	}
	public String getRet_allowed_yn( ) {
		 return ret_allowed_yn;
	}
	public String getTfr_allowed_yn( ) {
		 return tfr_allowed_yn;
	}
	public String getAdj_allowed_yn( ) {
		 return adj_allowed_yn;
	}
	public String getVar_allowed_yn( ) {
		 return var_allowed_yn;
	}
	public String getPrt_allowed_yn( ) {
		 return prt_allowed_yn;
	}
	public String getSal_allowed_yn( ) {
		 return sal_allowed_yn;
	}
	public String getStk_item_con_allowed_yn( ) {
		 return stk_item_con_allowed_yn;
	}

	public String getCancelRequest_yn( ) {
		 return cancel_request_yn;
	}
	public String getSrt_allowed_yn( ) {
		 return srt_allowed_yn;
	}
	public String getObs_allowed_yn( ) {
		 return obs_allowed_yn;
	}

	public String getSplit_batch_allowed_yn( ) {
		 return split_batch_allowed_yn;
	}
	public String getBin_change_allowed_yn( ) {
		 return bin_change_allowed_yn;
	}

	public void setAuthorizeSpecialReq_yn(String authorize_special_req_yn){
		this.authorize_special_req_yn = checkForNull(authorize_special_req_yn,"N");
	}

	public String getAuthorizeSpecialReq_yn(){
		return this.authorize_special_req_yn;
	}

	public void setProcessExpiredBatch_yn(String process_expired_items_yn){
		this.process_expired_items_yn = checkForNull(process_expired_items_yn,"N");
	}

	public String getProcessExpiredBatch_yn(){
		return process_expired_items_yn;
	}

	public void setProcessSuspendedBatch_yn(String process_suspended_items_yn){
		
		this.process_suspended_items_yn = checkForNull(process_suspended_items_yn,"N");
	}

	public String getProcessSuspendedBatch_yn(){
		
		return process_suspended_items_yn;
	}
	/* getter for transaction ends here */
/* Setter and Getter Methods for Acknowledgment Mahesh 4/21/2008*/
	public void setIss_acknowledge_yn(String iss_acknowledge_yn) {
		 this.iss_acknowledge_yn = checkForNull(iss_acknowledge_yn,"N");
	}
	
	public String getIss_acknowledge_yn() {
		 return iss_acknowledge_yn;
	}
	
	public void setIss_confirm_yn(String iss_confirm_yn) {
		 this.iss_confirm_yn = checkForNull(iss_confirm_yn,"N");
	}
	
	public String getIss_confirm_yn() {
		 return iss_confirm_yn;
	}

	public void setUrg_acknowledge_yn(String urg_acknowledge_yn) {
		 this.urg_acknowledge_yn = checkForNull(urg_acknowledge_yn,"N");
	}
	
	public String getUrg_acknowledge_yn() {
		 return urg_acknowledge_yn;
	}
	
	public void setUrg_confirm_yn(String urg_confirm_yn) {
		 this.urg_confirm_yn = checkForNull(urg_confirm_yn,"N");
	}
	
	public String getUrg_confirm_yn() {
		 return urg_confirm_yn;
	}

	public void setRet_acknowledge_yn(String ret_acknowledge_yn) {
		 this.ret_acknowledge_yn = checkForNull(ret_acknowledge_yn,"N");
	}
	public String getRet_acknowledge_yn() {
		 return ret_acknowledge_yn;
	}
	public void setRet_confirm_yn(String ret_confirm_yn) {
		 this.ret_confirm_yn = checkForNull(ret_confirm_yn,"N");
	}
	public String getRet_confirm_yn() {
		 return ret_confirm_yn;
	}
	public void setTfr_acknowledge_yn(String tfr_acknowledge_yn) {
		 this.tfr_acknowledge_yn = checkForNull(tfr_acknowledge_yn,"N");
	}
	public String getTfr_acknowledge_yn() {
		 return tfr_acknowledge_yn;
	}
	public void setTfr_confirm_yn(String tfr_confirm_yn) {
		 this.tfr_confirm_yn = checkForNull(tfr_confirm_yn,"N");
	}
	public String getTfr_confirm_yn() {
		 return tfr_confirm_yn;
	}

	//PORequest

	public void setPRQ_finalize_allowed_yn(String prq_finalize_allowed_yn) {
		 this.prq_finalize_allowed_yn = checkForNull(prq_finalize_allowed_yn,"N");
	}
	public String getPRQ_finalize_allowed_yn() {
		 return prq_finalize_allowed_yn;
	}
	public void setInterface_to_external_po_yn(String interface_to_external_po_yn){
		this.interface_to_external_po_yn = checkForNull(interface_to_external_po_yn,"N");
	}

	public String getInterface_to_external_po_yn(){
		return interface_to_external_po_yn;
	}
	public void setPRQ_allowed_yn(String prq_allowed_yn) {
		 this.prq_allowed_yn = checkForNull(prq_allowed_yn,"N");
	}
	public String getPRQ_allowed_yn( ) {
		 return prq_allowed_yn;
	}
/* transaction audit trail*/
		



	public void setReq_delete_yn(String req_delete_yn) {
		 this.req_delete_yn = checkForNull(req_delete_yn,"N");
	}
	public String getReq_delete_yn(){
		return req_delete_yn;
	}
	public void setUrg_delete_yn(String urg_delete_yn) {
		 this.urg_delete_yn = checkForNull(urg_delete_yn,"N");
	}
	public String getUrg_delete_yn(){
		return urg_delete_yn;
	}
	public void setIss_delete_yn(String iss_delete_yn) {
		 this.iss_delete_yn = checkForNull(iss_delete_yn,"N");
	}
	public String getIss_delete_yn(){
		return iss_delete_yn;
	}
	public void setRet_delete_yn(String ret_delete_yn) {
		 this.ret_delete_yn = checkForNull(ret_delete_yn,"N");
	}
	public String getRet_delete_yn(){
		return ret_delete_yn;
	}
	public void setAdj_delete_yn(String adj_delete_yn) {
		 this.adj_delete_yn = checkForNull(adj_delete_yn,"N");
	}
	public String getAdj_delete_yn(){
		return adj_delete_yn;
	}

	public void setPrt_delete_yn(String prt_delete_yn) {
		 this.prt_delete_yn = checkForNull(prt_delete_yn,"N");
	}
	public String getPrt_delete_yn(){
		return prt_delete_yn;
	}
	public void setSal_delete_yn(String sal_delete_yn) {
		 this.sal_delete_yn = checkForNull(sal_delete_yn,"N");
	}
	public String getSal_delete_yn(){
		return sal_delete_yn;
	}
	public void setSrt_delete_yn(String srt_delete_yn) {
		 this.srt_delete_yn = checkForNull(srt_delete_yn,"N");
	}
	public String getSrt_delete_yn(){
		return srt_delete_yn;
	}
	public void setGrn_delete_yn(String grn_delete_yn) {
		 this.grn_delete_yn = checkForNull(grn_delete_yn,"N");
	}
	public String getGrn_delete_yn(){
		return grn_delete_yn;
	}
	public void setRtv_delete_yn(String rtv_delete_yn) {
		 this.rtv_delete_yn = checkForNull(rtv_delete_yn,"N");
	}
	public String getRtv_delete_yn(){
		return rtv_delete_yn;
	}
	public void setMfg_delete_yn(String mfg_delete_yn) {
		 this.mfg_delete_yn = checkForNull(mfg_delete_yn,"N");
	}
	public String getMfg_delete_yn(){
		return mfg_delete_yn;
	}
	public void setTfr_delete_yn(String tfr_delete_yn) {
		 this.tfr_delete_yn = checkForNull(tfr_delete_yn,"N");
	}
	public String getTfr_delete_yn(){
		return tfr_delete_yn;
	}
	public void setPrq_delete_yn(String prq_delete_yn) {
		 this.prq_delete_yn = checkForNull(prq_delete_yn,"N");
	}
	public String getPrq_delete_yn(){
		return prq_delete_yn;
	}
	
	//Added by suresh.r 12-11-2013 against JD-CRF-156 beg
	public String getDisp_curr_enc_findtl_yn() {
		return disp_curr_enc_findtl_yn;
	}
	public void setDisp_curr_enc_findtl_yn(String disp_curr_enc_findtl_yn) {
		this.disp_curr_enc_findtl_yn = disp_curr_enc_findtl_yn;
	}
	//Added by suresh.r 12-11-2013 against JD-CRF-156 end
	
	//Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
	public String getDisp_min_rol_yn() {
		return disp_min_rol_yn;
	}
	public void setDisp_min_rol_yn(String disp_min_rol_yn) {
		this.disp_min_rol_yn = disp_min_rol_yn;
	}
	//ends
	//Added TFS ID - 23934 - MO-CRF-20177
	public String getCancel_Authorize_at_issue_store_allowed_yn() { 
		return cancel_authorize_iss_allow_yn; 
	}
	public void setCancel_Authorize_at_issue_store_allowed_yn(String cancel_authorize_iss_allow_yn) {
		this.cancel_authorize_iss_allow_yn = cancel_authorize_iss_allow_yn;
	}
	//ends
	//Added TFS ID - 29303 - MO-CRF-20174
	public String getReject_Request_at_issue_store_allowed_yn() { 
		return reject_request_issue_store_allowed_yn; 
	}
	public void setReject_Request_at_issue_store_allowed_yn(String reject_request_issue_store_allowed_yn) {
		this.reject_request_issue_store_allowed_yn = reject_request_issue_store_allowed_yn;
	}
	//ends

	//Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 
	  public void setPrt_finalize_allowed_yn(String prt_finalize_allowed_yn) {
			 this.prt_finalize_allowed_yn = checkForNull(prt_finalize_allowed_yn,"N");
		}
		public String getPrt_finalize_allowed_yn() {
			 return prt_finalize_allowed_yn;
		}
		 public void setPrt_finalize_prompt_yn(String prt_finalize_prompt_yn) {
			 this.prt_finalize_prompt_yn = checkForNull(prt_finalize_prompt_yn,"N");
		}
		public String getPrt_finalize_prompt_yn() {
			 return prt_finalize_prompt_yn;
		}
		// ENDED here ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 
	
	//Added By Rabbani #inc no:28266 on 16/09/11 
	//Starts Here
	public ArrayList getTrnTypeArrayList() throws Exception{
	  ArrayList alList = null;
		try{
	      alList = fetchRecords("SELECT TRNTYPE  FROM ST_VIEW_CSTSAL_TRNTYPE");
		 }
		catch(Exception e){
			e.printStackTrace();
		}
	  return alList;
	  }
	  //ends Here


	public HashMap insert() {
		
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		hmResult.put( "result", new Boolean( false ) ) ;
		alInsertData.add(getUser_id());                        
		alInsertData.add(getStore_code()); 
		alInsertData.add(getObs_allowed_yn());                 
		alInsertData.add(getGrn_allowed_yn());                 
		alInsertData.add(getGrn_finalize_allowed_yn());        
		alInsertData.add(getRtv_allowed_yn());                 
		alInsertData.add(getRtv_finalize_allowed_yn());        
		alInsertData.add(getMfg_allowed_yn());                 
		alInsertData.add(getReq_allowed_yn());                 
		alInsertData.add(getReq_authorize_allowed_yn());       
		alInsertData.add(getIss_allowed_yn());                 
		alInsertData.add(getUrg_allowed_yn());               
		alInsertData.add(getUrg_finalize_allowed_yn());        
		alInsertData.add(getRet_allowed_yn());                 
		alInsertData.add(getRet_finalize_allowed_yn());        
		alInsertData.add(getTfr_allowed_yn());                 
		alInsertData.add(getTfr_finalize_allowed_yn());        
		alInsertData.add(getAdj_allowed_yn());                 
		alInsertData.add(getAdj_finalize_allowed_yn());        
		alInsertData.add(getVar_allowed_yn());                 
		alInsertData.add(getPrt_allowed_yn());                 
		alInsertData.add(getSal_allowed_yn());                 
		alInsertData.add(getSal_authorize_allowed_yn());       
		
		alInsertData.add(getSrt_allowed_yn());                 
		alInsertData.add(getSrt_finalize_allowed_yn());        
		alInsertData.add(getSplit_batch_allowed_yn()); 
		alInsertData.add(getBin_change_allowed_yn());  
		alInsertData.add(getLoginById());      //ADDED_BY_ID            
											   //ADDED_DATE             
		alInsertData.add(getLoginAtWsNo());    //ADDED_AT_WS_NO         
		alInsertData.add(getLoginFacilityId());//ADDED_FACILITY_ID      
		
        alInsertData.add(getLoginById());      //MODIFIED_BY_ID         
		//MODIFIED_DATE          
		alInsertData.add(getLoginAtWsNo());    //MODIFIED_AT_WS_NO      
        alInsertData.add(getLoginFacilityId());//MODIFIED_FACILITY_ID   
		alInsertData.add(getIss_finalize_allowed_yn());        					 		    
        alInsertData.add(getMfg_finalize_allowed_yn()); 
		
		alInsertData.add(getAuthorizeSpecialReq_yn()); //Authorize special request
		alInsertData.add(getStk_item_con_allowed_yn());
		alInsertData.add(getProcessExpiredBatch_yn()); 
		alInsertData.add(getProcessSuspendedBatch_yn());
	
		alInsertData.add(getIss_acknowledge_yn());
		alInsertData.add(getIss_confirm_yn());
		alInsertData.add(getUrg_acknowledge_yn());
		alInsertData.add(getUrg_confirm_yn());
		alInsertData.add(getRet_acknowledge_yn());
		alInsertData.add(getRet_confirm_yn());
		alInsertData.add(getTfr_acknowledge_yn());
		alInsertData.add(getTfr_confirm_yn());
		alInsertData.add(getCancelRequest_yn());
		alInsertData.add(getPRQ_allowed_yn());
		alInsertData.add(getPRQ_finalize_allowed_yn());
		/* transaction audit trail*/
		alInsertData.add(getReq_delete_yn());
		alInsertData.add(getUrg_delete_yn()); 
		alInsertData.add(getIss_delete_yn()); 
		alInsertData.add(getRet_delete_yn()); 
		alInsertData.add(getAdj_delete_yn()); 
		alInsertData.add(getPrt_delete_yn()); 
		alInsertData.add(getSal_delete_yn()); 
		alInsertData.add(getSrt_delete_yn()); 
		alInsertData.add(getGrn_delete_yn()); 
		alInsertData.add(getRtv_delete_yn()); 
		alInsertData.add(getMfg_delete_yn()); 
		alInsertData.add(getTfr_delete_yn()); 
		alInsertData.add(getPrq_delete_yn()); 
		alInsertData.add(getCndmn_exp_btch_allowed_yn()); 
		alInsertData.add(getView_cost_yn()); //Added By Rabbani #inc no:28266 on 16/09/11 
		alInsertData.add(getView_sale_yn()); //16/09/11
		alInsertData.add(getDflt_item_search()); //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		alInsertData.add(getDflt_sal_type());  // Added by Padmapriya 

		alInsertData.add(getGrn_finalize_prompt_yn());        //Added For SKR-crf-0039
		alInsertData.add(getRtv_finalize_prompt_yn());
		alInsertData.add(getMfg_finalize_prompt_yn());
		alInsertData.add(getReq_authorize_prompt_yn()); 
		alInsertData.add(getIss_finalize_prompt_yn());	
		alInsertData.add(getUrg_finalize_prompt_yn());        
		alInsertData.add(getRet_finalize_prompt_yn());        
		alInsertData.add(getTfr_finalize_prompt_yn());        
		alInsertData.add(getAdj_finalize_prompt_yn());        
		alInsertData.add(getSal_authorize_prompt_yn());       
		alInsertData.add(getSrt_finalize_prompt_yn());        //ended
		alInsertData.add(getDisp_curr_enc_findtl_yn());//Added by suresh.r 12-11-2013 against JD-CRF-156
		alInsertData.add(checkForNull(getDisp_min_rol_yn(),"N"));//Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
		alInsertData.add(getPrt_finalize_allowed_yn()); //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 
		alInsertData.add(getPrt_finalize_prompt_yn());  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 
		alInsertData.add(getAuthorize_at_issue_store_allowed_yn());//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		alInsertData.add(getCancel_Authorize_at_issue_store_allowed_yn());//Added TFS ID - 23934 - MO-CRF-20177
		alInsertData.add(getReject_Request_at_issue_store_allowed_yn());//Added TFS ID - 29303 - MO-CRF-20174
		
		//System.out.println("alInsertData==>"+alInsertData);
		
		alWhereData.add(user_id);
		alWhereData.add(store_code);
	

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
		hmTableData.put("LanguageData"			,LanguageData);
		
	
	//		hmSQLMap.put( "InsertSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_INSERT"));
		
		//hmSQLMap.put( "InsertSQL","INSERT INTO	ST_USER_ACCESS_FOR_STORE (USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN, GRN_FINALIZE_ALLOWED_YN,RTV_ALLOWED_YN,RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN, PRQ_ALLOWED_YN, PRQ_FINALIZE_ALLOWED_YN, REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN,PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE) VALUES(?, ?,?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );
		//hmSQLMap.put( "InsertSQL","INSERT INTO	ST_USER_ACCESS_FOR_STORE (USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN, GRN_FINALIZE_ALLOWED_YN,RTV_ALLOWED_YN,RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN, PRQ_ALLOWED_YN, PRQ_FINALIZE_ALLOWED_YN, REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN,PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN) VALUES(?, ?,?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );//Commented by suresh.r 13-11-2013 against JD-CRF-156
		//hmSQLMap.put( "InsertSQL","INSERT INTO	ST_USER_ACCESS_FOR_STORE (USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN, GRN_FINALIZE_ALLOWED_YN,RTV_ALLOWED_YN,RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN, PRQ_ALLOWED_YN, PRQ_FINALIZE_ALLOWED_YN, REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN,PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN) VALUES(?, ?,?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );//Added by suresh.r 13-11-2013 against JD-CRF-156
		//Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
		//hmSQLMap.put( "InsertSQL","INSERT INTO	ST_USER_ACCESS_FOR_STORE (USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN, GRN_FINALIZE_ALLOWED_YN,RTV_ALLOWED_YN,RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN, PRQ_ALLOWED_YN, PRQ_FINALIZE_ALLOWED_YN, REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN,PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN,DISP_MIN_ROL_YN) VALUES(?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );
		//Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 
		 // hmSQLMap.put( "InsertSQL","INSERT INTO	ST_USER_ACCESS_FOR_STORE (USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN, GRN_FINALIZE_ALLOWED_YN,RTV_ALLOWED_YN,RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN, PRQ_ALLOWED_YN, PRQ_FINALIZE_ALLOWED_YN, REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN,PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN,DISP_MIN_ROL_YN,PRT_FINALIZE_ALLOWED_YN,PRT_FINALIZE_PROMPT_YN) VALUES(?, ?,?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );
		 //Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		 hmSQLMap.put( "InsertSQL","INSERT INTO	ST_USER_ACCESS_FOR_STORE (USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN, GRN_FINALIZE_ALLOWED_YN,RTV_ALLOWED_YN,RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN, PRQ_ALLOWED_YN, PRQ_FINALIZE_ALLOWED_YN, REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN,PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN,DISP_MIN_ROL_YN,PRT_FINALIZE_ALLOWED_YN,PRT_FINALIZE_PROMPT_YN,AUTHORIZE_AT_ISSUE_ALLOWED_YN, CANCEL_AUTHORIZE_ISS_ALLOW_YN, REJECT_REQUEST_ISS_ALLOW_YN) VALUES(?, ?,?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?,?)" );
		//System.out.println("hmSQLMap==>"+hmSQLMap); // CANCEL_AUTHORIZE_ISS_ALLOW_YN , TFs id : 23934 - MO-CRF-20177



		hmSQLMap.put( "SelectSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_COUNT"));
			
	return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
	
	}
  
	public HashMap modify() {
		
		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		
		ArrayList LanguageData = new ArrayList()	;
		LanguageData.add(getLanguageId());

		hmResult.put( "result", new Boolean( false ) ) ;
		

		alModifyData.add(getObs_allowed_yn());                 
		alModifyData.add(getGrn_allowed_yn());                 
		alModifyData.add(getGrn_finalize_allowed_yn());        
		alModifyData.add(getRtv_allowed_yn());                 
		alModifyData.add(getRtv_finalize_allowed_yn());        
		alModifyData.add(getMfg_allowed_yn());   
		alModifyData.add(getReq_allowed_yn());                 
		alModifyData.add(getReq_authorize_allowed_yn());       
		alModifyData.add(getIss_allowed_yn());                 
		alModifyData.add(getUrg_allowed_yn());                 
		alModifyData.add(getUrg_finalize_allowed_yn());        
		alModifyData.add(getRet_allowed_yn());                 
		alModifyData.add(getRet_finalize_allowed_yn());        
		alModifyData.add(getTfr_allowed_yn());                 
		alModifyData.add(getTfr_finalize_allowed_yn());        
		alModifyData.add(getAdj_allowed_yn());                 
		alModifyData.add(getAdj_finalize_allowed_yn());        
		alModifyData.add(getVar_allowed_yn());                 
		alModifyData.add(getPrt_allowed_yn());                 
		alModifyData.add(getSal_allowed_yn());                 
		alModifyData.add(getSal_authorize_allowed_yn());       
		alModifyData.add(getSrt_allowed_yn());                 
		alModifyData.add(getSrt_finalize_allowed_yn());        
		alModifyData.add(getSplit_batch_allowed_yn()); 
		
		alModifyData.add(getBin_change_allowed_yn());

		alModifyData.add(login_by_id);
		alModifyData.add(login_at_ws_no);
		alModifyData.add(login_facility_id);
        alModifyData.add(getIss_finalize_allowed_yn());        
    	alModifyData.add(getMfg_finalize_allowed_yn());        
		
		alModifyData.add(getAuthorizeSpecialReq_yn());//authorize special request
		alModifyData.add(getStk_item_con_allowed_yn());
	
		alModifyData.add(getProcessExpiredBatch_yn());
		alModifyData.add(getProcessSuspendedBatch_yn()); 

		alModifyData.add(getIss_acknowledge_yn());
		alModifyData.add(getIss_confirm_yn());
		alModifyData.add(getUrg_acknowledge_yn());
		alModifyData.add(getUrg_confirm_yn());
		alModifyData.add(getRet_acknowledge_yn());
		alModifyData.add(getRet_confirm_yn());
		alModifyData.add(getTfr_acknowledge_yn());
		alModifyData.add(getTfr_confirm_yn());
		alModifyData.add(getCancelRequest_yn());
		alModifyData.add(getPRQ_allowed_yn());
		alModifyData.add(getPRQ_finalize_allowed_yn());
	
/* transaction audit trail*/
		alModifyData.add(getReq_delete_yn());
		alModifyData.add(getUrg_delete_yn()); 
		alModifyData.add(getIss_delete_yn()); 
		alModifyData.add(getRet_delete_yn()); 
		alModifyData.add(getAdj_delete_yn()); 
		alModifyData.add(getPrt_delete_yn()); 
		alModifyData.add(getSal_delete_yn()); 
		alModifyData.add(getSrt_delete_yn()); 
		alModifyData.add(getGrn_delete_yn()); 
		alModifyData.add(getRtv_delete_yn()); 
		alModifyData.add(getMfg_delete_yn()); 
		alModifyData.add(getTfr_delete_yn()); 
		alModifyData.add(getPrq_delete_yn()); 
		alModifyData.add(getCndmn_exp_btch_allowed_yn());
        alModifyData.add(getView_cost_yn());  //16/09/11
		alModifyData.add(getView_sale_yn());  //16/09/11
		alModifyData.add(dflt_item_search); //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		alModifyData.add(getDflt_sal_type());   // Added by Padmapriya 
		
		alModifyData.add(getGrn_finalize_prompt_yn());        //Added For SKR-crf-0039
		alModifyData.add(getRtv_finalize_prompt_yn());
		alModifyData.add(getMfg_finalize_prompt_yn());
		alModifyData.add(getReq_authorize_prompt_yn()); 
		alModifyData.add(getIss_finalize_prompt_yn());	
		alModifyData.add(getUrg_finalize_prompt_yn());        
		alModifyData.add(getRet_finalize_prompt_yn());        
		alModifyData.add(getTfr_finalize_prompt_yn());        
		alModifyData.add(getAdj_finalize_prompt_yn());        
		alModifyData.add(getSal_authorize_prompt_yn());       
		alModifyData.add(getSrt_finalize_prompt_yn());        //ended
		alModifyData.add(getDisp_curr_enc_findtl_yn());//Added by suresh.r 12-11-2013 against JD-CRF-156
		alModifyData.add(checkForNull(getDisp_min_rol_yn(),"N"));//Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
		
		alModifyData.add(getPrt_finalize_allowed_yn()); //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 
		alModifyData.add(getPrt_finalize_prompt_yn());  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016 
		alModifyData.add(getAuthorize_at_issue_store_allowed_yn());//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		alModifyData.add(getCancel_Authorize_at_issue_store_allowed_yn());//Added TFS ID - 23934 - MO-CRF-20177
		alModifyData.add(getReject_Request_at_issue_store_allowed_yn());//Added TFS ID - 29303 - MO-CRF-20174

		
		alModifyData.add(getUser_id());                        
		alModifyData.add(getStore_code()); 
		
		//System.out.println("alModifyData==>"+alModifyData);
		
		
		//hmSQLMap.put("ModifySQL",eST.Common.StRepository.getStKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_UPDATE"));
		//hmSQLMap.put("ModifySQL","UPDATE ST_USER_ACCESS_FOR_STORE	 SET  OBS_ALLOWED_YN=?,GRN_ALLOWED_YN=?,GRN_FINALIZE_ALLOWED_YN=?, RTV_ALLOWED_YN=?,RTV_FINALIZE_ALLOWED_YN=?,MFG_ALLOWED_YN=?,REQ_ALLOWED_YN=?,REQ_AUTHORIZE_ALLOWED_YN=?,ISS_ALLOWED_YN=?,URG_ALLOWED_YN=?,URG_FINALIZE_ALLOWED_YN=?,RET_ALLOWED_YN=?,RET_FINALIZE_ALLOWED_YN=?,TFR_ALLOWED_YN=?,TFR_FINALIZE_ALLOWED_YN=?,ADJ_ALLOWED_YN=?,ADJ_FINALIZE_ALLOWED_YN=?,VAR_ALLOWED_YN=?,PRT_ALLOWED_YN=?,SAL_ALLOWED_YN=?,SAL_AUTHORIZE_ALLOWED_YN=?,SRT_ALLOWED_YN=?,SRT_FINALIZE_ALLOWED_YN=?,SPLIT_BATCH_ALLOWED_YN=?,BIN_CHANGE_ALLOWED_YN=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ISS_FINALIZE_ALLOWED_YN=?,MFG_FINALIZE_ALLOWED_YN=?,AUTHORIZE_SPECIAL_REQ_YN=? ,STK_ITEM_CON_ALLOWED_YN = ?,PROCESS_EXPIRED_ITEMS_YN=?, PROCESS_SUSPENDED_ITEMS_YN=?, ISS_ACKNOWLEDGE_YN=?, ISS_CONFIRM_YN=?, URG_ACKNOWLEDGE_YN=?, URG_CONFIRM_YN=?, RET_ACKNOWLEDGE_YN=?, RET_CONFIRM_YN=?, TFR_ACKNOWLEDGE_YN=?, TFR_CONFIRM_YN=?,CANCL_ALLOWED_YN=?, PRQ_ALLOWED_YN=?, PRQ_FINALIZE_ALLOWED_YN=?,REQ_DELETE_YN=?, URG_DELETE_YN=?, ISS_DELETE_YN=?, RET_DELETE_YN=?, ADJ_DELETE_YN=?, PRT_DELETE_YN=?, SAL_DELETE_YN=?, SRT_DELETE_YN=?, GRN_DELETE_YN=?, RTV_DELETE_YN=?, MFG_DELETE_YN=?, TFR_DELETE_YN=?, PRQ_DELETE_YN=?,CNDMN_EXP_BTCH_ALLOWED_YN = ?,VIEW_COST_YN = ?,VIEW_SALE_YN = ?, DFLT_ITEM_SEARCH=? , DFLT_SAL_TRN_TYPE=?  WHERE USER_ID=? AND STORE_CODE=?  ");
		//hmSQLMap.put("ModifySQL","UPDATE ST_USER_ACCESS_FOR_STORE	 SET  OBS_ALLOWED_YN=?,GRN_ALLOWED_YN=?,GRN_FINALIZE_ALLOWED_YN=?, RTV_ALLOWED_YN=?,RTV_FINALIZE_ALLOWED_YN=?,MFG_ALLOWED_YN=?,REQ_ALLOWED_YN=?,REQ_AUTHORIZE_ALLOWED_YN=?,ISS_ALLOWED_YN=?,URG_ALLOWED_YN=?,URG_FINALIZE_ALLOWED_YN=?,RET_ALLOWED_YN=?,RET_FINALIZE_ALLOWED_YN=?,TFR_ALLOWED_YN=?,TFR_FINALIZE_ALLOWED_YN=?,ADJ_ALLOWED_YN=?,ADJ_FINALIZE_ALLOWED_YN=?,VAR_ALLOWED_YN=?,PRT_ALLOWED_YN=?,SAL_ALLOWED_YN=?,SAL_AUTHORIZE_ALLOWED_YN=?,SRT_ALLOWED_YN=?,SRT_FINALIZE_ALLOWED_YN=?,SPLIT_BATCH_ALLOWED_YN=?,BIN_CHANGE_ALLOWED_YN=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ISS_FINALIZE_ALLOWED_YN=?,MFG_FINALIZE_ALLOWED_YN=?,AUTHORIZE_SPECIAL_REQ_YN=? ,STK_ITEM_CON_ALLOWED_YN = ?,PROCESS_EXPIRED_ITEMS_YN=?, PROCESS_SUSPENDED_ITEMS_YN=?, ISS_ACKNOWLEDGE_YN=?, ISS_CONFIRM_YN=?, URG_ACKNOWLEDGE_YN=?, URG_CONFIRM_YN=?, RET_ACKNOWLEDGE_YN=?, RET_CONFIRM_YN=?, TFR_ACKNOWLEDGE_YN=?, TFR_CONFIRM_YN=?,CANCL_ALLOWED_YN=?, PRQ_ALLOWED_YN=?, PRQ_FINALIZE_ALLOWED_YN=?,REQ_DELETE_YN=?, URG_DELETE_YN=?, ISS_DELETE_YN=?, RET_DELETE_YN=?, ADJ_DELETE_YN=?, PRT_DELETE_YN=?, SAL_DELETE_YN=?, SRT_DELETE_YN=?, GRN_DELETE_YN=?, RTV_DELETE_YN=?, MFG_DELETE_YN=?, TFR_DELETE_YN=?, PRQ_DELETE_YN=?,CNDMN_EXP_BTCH_ALLOWED_YN = ?,VIEW_COST_YN = ?,VIEW_SALE_YN = ?, DFLT_ITEM_SEARCH=? , DFLT_SAL_TRN_TYPE=? ,GRN_FINALIZE_PROMPT_YN = ?,RTV_FINALIZE_PROMPT_YN = ?,MFG_FINALIZE_PROMPT_YN = ?,REQ_AUTHORIZE_PROMPT_YN = ?,ISS_FINALIZE_PROMPT_YN = ?,URG_FINALIZE_PROMPT_YN = ?,RET_FINALIZE_PROMPT_YN = ?,TFR_FINALIZE_PROMPT_YN = ?,ADJ_FINALIZE_PROMPT_YN = ?,SAL_AUTHORIZE_PROMPT_YN = ?,SRT_FINALIZE_PROMPT_YN = ? WHERE USER_ID=? AND STORE_CODE=?  ");//Commented by suresh.r 13-11-2013 against JD-CRF-156 
		//hmSQLMap.put("ModifySQL","UPDATE ST_USER_ACCESS_FOR_STORE	 SET  OBS_ALLOWED_YN=?,GRN_ALLOWED_YN=?,GRN_FINALIZE_ALLOWED_YN=?, RTV_ALLOWED_YN=?,RTV_FINALIZE_ALLOWED_YN=?,MFG_ALLOWED_YN=?,REQ_ALLOWED_YN=?,REQ_AUTHORIZE_ALLOWED_YN=?,ISS_ALLOWED_YN=?,URG_ALLOWED_YN=?,URG_FINALIZE_ALLOWED_YN=?,RET_ALLOWED_YN=?,RET_FINALIZE_ALLOWED_YN=?,TFR_ALLOWED_YN=?,TFR_FINALIZE_ALLOWED_YN=?,ADJ_ALLOWED_YN=?,ADJ_FINALIZE_ALLOWED_YN=?,VAR_ALLOWED_YN=?,PRT_ALLOWED_YN=?,SAL_ALLOWED_YN=?,SAL_AUTHORIZE_ALLOWED_YN=?,SRT_ALLOWED_YN=?,SRT_FINALIZE_ALLOWED_YN=?,SPLIT_BATCH_ALLOWED_YN=?,BIN_CHANGE_ALLOWED_YN=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ISS_FINALIZE_ALLOWED_YN=?,MFG_FINALIZE_ALLOWED_YN=?,AUTHORIZE_SPECIAL_REQ_YN=? ,STK_ITEM_CON_ALLOWED_YN = ?,PROCESS_EXPIRED_ITEMS_YN=?, PROCESS_SUSPENDED_ITEMS_YN=?, ISS_ACKNOWLEDGE_YN=?, ISS_CONFIRM_YN=?, URG_ACKNOWLEDGE_YN=?, URG_CONFIRM_YN=?, RET_ACKNOWLEDGE_YN=?, RET_CONFIRM_YN=?, TFR_ACKNOWLEDGE_YN=?, TFR_CONFIRM_YN=?,CANCL_ALLOWED_YN=?, PRQ_ALLOWED_YN=?, PRQ_FINALIZE_ALLOWED_YN=?,REQ_DELETE_YN=?, URG_DELETE_YN=?, ISS_DELETE_YN=?, RET_DELETE_YN=?, ADJ_DELETE_YN=?, PRT_DELETE_YN=?, SAL_DELETE_YN=?, SRT_DELETE_YN=?, GRN_DELETE_YN=?, RTV_DELETE_YN=?, MFG_DELETE_YN=?, TFR_DELETE_YN=?, PRQ_DELETE_YN=?,CNDMN_EXP_BTCH_ALLOWED_YN = ?,VIEW_COST_YN = ?,VIEW_SALE_YN = ?, DFLT_ITEM_SEARCH=? , DFLT_SAL_TRN_TYPE=? ,GRN_FINALIZE_PROMPT_YN = ?,RTV_FINALIZE_PROMPT_YN = ?,MFG_FINALIZE_PROMPT_YN = ?,REQ_AUTHORIZE_PROMPT_YN = ?,ISS_FINALIZE_PROMPT_YN = ?,URG_FINALIZE_PROMPT_YN = ?,RET_FINALIZE_PROMPT_YN = ?,TFR_FINALIZE_PROMPT_YN = ?,ADJ_FINALIZE_PROMPT_YN = ?,SAL_AUTHORIZE_PROMPT_YN = ?,SRT_FINALIZE_PROMPT_YN = ?,DISP_CURR_ENCNTR_FIN_DTL_YN=? WHERE USER_ID=? AND STORE_CODE=?  ");//Added by suresh.r 13-11-2013 against JD-CRF-156
		
		//Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
		//hmSQLMap.put("ModifySQL","UPDATE ST_USER_ACCESS_FOR_STORE	 SET  OBS_ALLOWED_YN=?,GRN_ALLOWED_YN=?,GRN_FINALIZE_ALLOWED_YN=?, RTV_ALLOWED_YN=?,RTV_FINALIZE_ALLOWED_YN=?,MFG_ALLOWED_YN=?,REQ_ALLOWED_YN=?,REQ_AUTHORIZE_ALLOWED_YN=?,ISS_ALLOWED_YN=?,URG_ALLOWED_YN=?,URG_FINALIZE_ALLOWED_YN=?,RET_ALLOWED_YN=?,RET_FINALIZE_ALLOWED_YN=?,TFR_ALLOWED_YN=?,TFR_FINALIZE_ALLOWED_YN=?,ADJ_ALLOWED_YN=?,ADJ_FINALIZE_ALLOWED_YN=?,VAR_ALLOWED_YN=?,PRT_ALLOWED_YN=?,SAL_ALLOWED_YN=?,SAL_AUTHORIZE_ALLOWED_YN=?,SRT_ALLOWED_YN=?,SRT_FINALIZE_ALLOWED_YN=?,SPLIT_BATCH_ALLOWED_YN=?,BIN_CHANGE_ALLOWED_YN=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ISS_FINALIZE_ALLOWED_YN=?,MFG_FINALIZE_ALLOWED_YN=?,AUTHORIZE_SPECIAL_REQ_YN=? ,STK_ITEM_CON_ALLOWED_YN = ?,PROCESS_EXPIRED_ITEMS_YN=?, PROCESS_SUSPENDED_ITEMS_YN=?, ISS_ACKNOWLEDGE_YN=?, ISS_CONFIRM_YN=?, URG_ACKNOWLEDGE_YN=?, URG_CONFIRM_YN=?, RET_ACKNOWLEDGE_YN=?, RET_CONFIRM_YN=?, TFR_ACKNOWLEDGE_YN=?, TFR_CONFIRM_YN=?,CANCL_ALLOWED_YN=?, PRQ_ALLOWED_YN=?, PRQ_FINALIZE_ALLOWED_YN=?,REQ_DELETE_YN=?, URG_DELETE_YN=?, ISS_DELETE_YN=?, RET_DELETE_YN=?, ADJ_DELETE_YN=?, PRT_DELETE_YN=?, SAL_DELETE_YN=?, SRT_DELETE_YN=?, GRN_DELETE_YN=?, RTV_DELETE_YN=?, MFG_DELETE_YN=?, TFR_DELETE_YN=?, PRQ_DELETE_YN=?,CNDMN_EXP_BTCH_ALLOWED_YN = ?,VIEW_COST_YN = ?,VIEW_SALE_YN = ?, DFLT_ITEM_SEARCH=? , DFLT_SAL_TRN_TYPE=? ,GRN_FINALIZE_PROMPT_YN = ?,RTV_FINALIZE_PROMPT_YN = ?,MFG_FINALIZE_PROMPT_YN = ?,REQ_AUTHORIZE_PROMPT_YN = ?,ISS_FINALIZE_PROMPT_YN = ?,URG_FINALIZE_PROMPT_YN = ?,RET_FINALIZE_PROMPT_YN = ?,TFR_FINALIZE_PROMPT_YN = ?,ADJ_FINALIZE_PROMPT_YN = ?,SAL_AUTHORIZE_PROMPT_YN = ?,SRT_FINALIZE_PROMPT_YN = ?,DISP_CURR_ENCNTR_FIN_DTL_YN=?,DISP_MIN_ROL_YN = ?WHERE USER_ID=? AND STORE_CODE=?  "); 
		
		//Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
	//	hmSQLMap.put("ModifySQL","UPDATE ST_USER_ACCESS_FOR_STORE	 SET  OBS_ALLOWED_YN=?,GRN_ALLOWED_YN=?,GRN_FINALIZE_ALLOWED_YN=?, RTV_ALLOWED_YN=?,RTV_FINALIZE_ALLOWED_YN=?,MFG_ALLOWED_YN=?,REQ_ALLOWED_YN=?,REQ_AUTHORIZE_ALLOWED_YN=?,ISS_ALLOWED_YN=?,URG_ALLOWED_YN=?,URG_FINALIZE_ALLOWED_YN=?,RET_ALLOWED_YN=?,RET_FINALIZE_ALLOWED_YN=?,TFR_ALLOWED_YN=?,TFR_FINALIZE_ALLOWED_YN=?,ADJ_ALLOWED_YN=?,ADJ_FINALIZE_ALLOWED_YN=?,VAR_ALLOWED_YN=?,PRT_ALLOWED_YN=?,SAL_ALLOWED_YN=?,SAL_AUTHORIZE_ALLOWED_YN=?,SRT_ALLOWED_YN=?,SRT_FINALIZE_ALLOWED_YN=?,SPLIT_BATCH_ALLOWED_YN=?,BIN_CHANGE_ALLOWED_YN=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ISS_FINALIZE_ALLOWED_YN=?,MFG_FINALIZE_ALLOWED_YN=?,AUTHORIZE_SPECIAL_REQ_YN=? ,STK_ITEM_CON_ALLOWED_YN = ?,PROCESS_EXPIRED_ITEMS_YN=?, PROCESS_SUSPENDED_ITEMS_YN=?, ISS_ACKNOWLEDGE_YN=?, ISS_CONFIRM_YN=?, URG_ACKNOWLEDGE_YN=?, URG_CONFIRM_YN=?, RET_ACKNOWLEDGE_YN=?, RET_CONFIRM_YN=?, TFR_ACKNOWLEDGE_YN=?, TFR_CONFIRM_YN=?,CANCL_ALLOWED_YN=?, PRQ_ALLOWED_YN=?, PRQ_FINALIZE_ALLOWED_YN=?,REQ_DELETE_YN=?, URG_DELETE_YN=?, ISS_DELETE_YN=?, RET_DELETE_YN=?, ADJ_DELETE_YN=?, PRT_DELETE_YN=?, SAL_DELETE_YN=?, SRT_DELETE_YN=?, GRN_DELETE_YN=?, RTV_DELETE_YN=?, MFG_DELETE_YN=?, TFR_DELETE_YN=?, PRQ_DELETE_YN=?,CNDMN_EXP_BTCH_ALLOWED_YN = ?,VIEW_COST_YN = ?,VIEW_SALE_YN = ?, DFLT_ITEM_SEARCH=? , DFLT_SAL_TRN_TYPE=? ,GRN_FINALIZE_PROMPT_YN = ?,RTV_FINALIZE_PROMPT_YN = ?,MFG_FINALIZE_PROMPT_YN = ?,REQ_AUTHORIZE_PROMPT_YN = ?,ISS_FINALIZE_PROMPT_YN = ?,URG_FINALIZE_PROMPT_YN = ?,RET_FINALIZE_PROMPT_YN = ?,TFR_FINALIZE_PROMPT_YN = ?,ADJ_FINALIZE_PROMPT_YN = ?,SAL_AUTHORIZE_PROMPT_YN = ?,SRT_FINALIZE_PROMPT_YN = ?,DISP_CURR_ENCNTR_FIN_DTL_YN=?,DISP_MIN_ROL_YN = ?, PRT_FINALIZE_ALLOWED_YN=? ,PRT_FINALIZE_PROMPT_YN=? WHERE USER_ID=? AND STORE_CODE=?  "); 
		hmSQLMap.put("ModifySQL","UPDATE ST_USER_ACCESS_FOR_STORE	 SET  OBS_ALLOWED_YN=?,GRN_ALLOWED_YN=?,GRN_FINALIZE_ALLOWED_YN=?, RTV_ALLOWED_YN=?,RTV_FINALIZE_ALLOWED_YN=?,MFG_ALLOWED_YN=?,REQ_ALLOWED_YN=?,REQ_AUTHORIZE_ALLOWED_YN=?,ISS_ALLOWED_YN=?,URG_ALLOWED_YN=?,URG_FINALIZE_ALLOWED_YN=?,RET_ALLOWED_YN=?,RET_FINALIZE_ALLOWED_YN=?,TFR_ALLOWED_YN=?,TFR_FINALIZE_ALLOWED_YN=?,ADJ_ALLOWED_YN=?,ADJ_FINALIZE_ALLOWED_YN=?,VAR_ALLOWED_YN=?,PRT_ALLOWED_YN=?,SAL_ALLOWED_YN=?,SAL_AUTHORIZE_ALLOWED_YN=?,SRT_ALLOWED_YN=?,SRT_FINALIZE_ALLOWED_YN=?,SPLIT_BATCH_ALLOWED_YN=?,BIN_CHANGE_ALLOWED_YN=?,MODIFIED_BY_ID=?,MODIFIED_DATE=SYSDATE,MODIFIED_AT_WS_NO=?,MODIFIED_FACILITY_ID=?,ISS_FINALIZE_ALLOWED_YN=?,MFG_FINALIZE_ALLOWED_YN=?,AUTHORIZE_SPECIAL_REQ_YN=? ,STK_ITEM_CON_ALLOWED_YN = ?,PROCESS_EXPIRED_ITEMS_YN=?, PROCESS_SUSPENDED_ITEMS_YN=?, ISS_ACKNOWLEDGE_YN=?, ISS_CONFIRM_YN=?, URG_ACKNOWLEDGE_YN=?, URG_CONFIRM_YN=?, RET_ACKNOWLEDGE_YN=?, RET_CONFIRM_YN=?, TFR_ACKNOWLEDGE_YN=?, TFR_CONFIRM_YN=?,CANCL_ALLOWED_YN=?, PRQ_ALLOWED_YN=?, PRQ_FINALIZE_ALLOWED_YN=?,REQ_DELETE_YN=?, URG_DELETE_YN=?, ISS_DELETE_YN=?, RET_DELETE_YN=?, ADJ_DELETE_YN=?, PRT_DELETE_YN=?, SAL_DELETE_YN=?, SRT_DELETE_YN=?, GRN_DELETE_YN=?, RTV_DELETE_YN=?, MFG_DELETE_YN=?, TFR_DELETE_YN=?, PRQ_DELETE_YN=?,CNDMN_EXP_BTCH_ALLOWED_YN = ?,VIEW_COST_YN = ?,VIEW_SALE_YN = ?, DFLT_ITEM_SEARCH=? , DFLT_SAL_TRN_TYPE=? ,GRN_FINALIZE_PROMPT_YN = ?,RTV_FINALIZE_PROMPT_YN = ?,MFG_FINALIZE_PROMPT_YN = ?,REQ_AUTHORIZE_PROMPT_YN = ?,ISS_FINALIZE_PROMPT_YN = ?,URG_FINALIZE_PROMPT_YN = ?,RET_FINALIZE_PROMPT_YN = ?,TFR_FINALIZE_PROMPT_YN = ?,ADJ_FINALIZE_PROMPT_YN = ?,SAL_AUTHORIZE_PROMPT_YN = ?,SRT_FINALIZE_PROMPT_YN = ?,DISP_CURR_ENCNTR_FIN_DTL_YN=?,DISP_MIN_ROL_YN = ?, PRT_FINALIZE_ALLOWED_YN=? ,PRT_FINALIZE_PROMPT_YN=?, AUTHORIZE_AT_ISSUE_ALLOWED_YN=? , CANCEL_AUTHORIZE_ISS_ALLOW_YN = ?, REJECT_REQUEST_ISS_ALLOW_YN=? WHERE USER_ID=? AND STORE_CODE=?  ");//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 // CANCEL_AUTHORIZE_ISS_ALLOW_YN , TFs id : 23934 - MO-CRF-20177 // REJECT_REQUEST_ISS_ALLOW_YN, TFs id : 29303 - MO-CRF-20174
		//System.out.println("hmSQLMap==>"+hmSQLMap);

		hmTableData.put("properties",getProperties());
		hmTableData.put("ModifyData",alModifyData);
		hmTableData.put("LanguageData",LanguageData);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	
	public void clear() {
		
		store_code				=	"";
		user_id						=	"";
		//view_cost_details			=	"Y";
		grn_allowed_yn				=	"Y";
		rtv_allowed_yn				=	"Y";
		mfg_allowed_yn				=	"Y";
		req_allowed_yn				=	"Y";
		iss_allowed_yn				=	"Y";
		urg_allowed_yn				=	"Y";
		ret_allowed_yn				=	"Y";
		tfr_allowed_yn				=	"Y";
		adj_allowed_yn				=	"Y";
		var_allowed_yn				=	"Y";
		prt_allowed_yn				=	"Y";
		sal_allowed_yn				=	"Y";
		srt_allowed_yn				=	"Y";
		cancel_request_yn			=	"N";
		obs_allowed_yn				=	"Y";
		split_batch_allowed_yn		=	"Y";
		bin_change_allowed_yn		=	"Y";
		process_expired_items_yn	=	"Y";
		process_suspended_items_yn	=	"Y";
		authorize_special_req_yn	=	"N";
		stk_item_con_allowed_yn		=	"Y";
		grn_finalize_allowed_yn		=	"Y";
		rtv_finalize_allowed_yn		=	"Y";
        iss_finalize_allowed_yn		=	"Y";
		req_authorize_allowed_yn	=	"Y";
		mfg_finalize_allowed_yn		=	"Y";
		tfr_finalize_allowed_yn		=	"Y";
		adj_finalize_allowed_yn		=	"Y";
		sal_authorize_allowed_yn	=	"Y";
		srt_finalize_allowed_yn		=	"Y";
		urg_finalize_allowed_yn		=	"Y";
		ret_finalize_allowed_yn		=	"Y";
		iss_acknowledge_yn			=	"N";
		iss_confirm_yn				=	"N";
		urg_acknowledge_yn			=	"N";
		urg_confirm_yn				=	"N";
		ret_acknowledge_yn			=	"N";
		ret_confirm_yn				=	"N";
		tfr_acknowledge_yn			=	"N";
		tfr_confirm_yn				=	"N";
		prq_allowed_yn				=	"N";
		prq_finalize_allowed_yn		=	"N";
		req_delete_yn				=	"N";
		urg_delete_yn				=	"N";
		iss_delete_yn				=	"N";
		ret_delete_yn				=	"N";
		adj_delete_yn				=	"N";
		prt_delete_yn				=	"N";
		sal_delete_yn				=	"N";
		srt_delete_yn				=	"N";
		grn_delete_yn				=	"N";
		rtv_delete_yn				=	"N";
		mfg_delete_yn				=	"N";
		tfr_delete_yn				=	"N";
		prq_delete_yn				=	"N";
		cndmn_exp_btch_allowed_yn	=	"N";
		view_sale_yn                =   "N";  //Added By Rabbani #inc no:28266 on 16/09/11
		view_cost_yn                =   "N";
		dflt_item_search			=	"IN"; //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		enable_yn                   =   "Y";
		dflt_sal_type				=	"I";  // Added by Padmapriya 
		
		grn_finalize_prompt_yn		=	"Y";	//Added For SKR-CRF-0039
		rtv_finalize_prompt_yn		=	"Y";
		iss_finalize_prompt_yn		=	"Y";
		req_authorize_prompt_yn		=	"Y";
		mfg_finalize_prompt_yn		=	"Y";
		tfr_finalize_prompt_yn		=	"Y";
		adj_finalize_prompt_yn		=	"Y";
		sal_authorize_prompt_yn		=	"Y";
		srt_finalize_prompt_yn		=	"Y";
		urg_finalize_prompt_yn		=	"Y";
		ret_finalize_prompt_yn		=	"Y";	//Ended
		disp_curr_enc_findtl_yn		=	"N";//Added by suresh.r 12-11-2013 against JD-CRF-156
		disp_min_rol_yn             =   "N"; //Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
		prt_finalize_allowed_yn		=	"Y"; //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
		prt_finalize_prompt_yn		=	"Y"; //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
		authorize_at_issue_store_allowed_yn = "N";//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		cancel_authorize_iss_allow_yn = "N";  // TFS ID -  23934 -  MO-CRF-20177
		reject_request_issue_store_allowed_yn = "N"; // TFS ID -  29303 - MO-CRF-20174
	}

    /* Over-ridden Adapter methods starts here */

	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setStore_code				((String) htRecordSet.get("store_code"));
		setUser_id					((String) htRecordSet.get("user_id"));
		setGrn_allowed_yn			((String) htRecordSet.get("grn_allowed_yn"));
		setRtv_allowed_yn			((String) htRecordSet.get("rtv_allowed_yn"));
		setMfg_allowed_yn			((String) htRecordSet.get("mfg_allowed_yn"));
		setReq_allowed_yn			((String) htRecordSet.get("req_allowed_yn"));
		setIss_allowed_yn			((String) htRecordSet.get("iss_allowed_yn"));
		setUrg_allowed_yn			((String) htRecordSet.get("urg_allowed_yn"));
		setRet_allowed_yn			((String) htRecordSet.get("ret_allowed_yn"));
		setTfr_allowed_yn			((String) htRecordSet.get("tfr_allowed_yn"));
		setAdj_allowed_yn			((String) htRecordSet.get("adj_allowed_yn"));
		setVar_allowed_yn			((String) htRecordSet.get("var_allowed_yn"));
		setPrt_allowed_yn			((String) htRecordSet.get("prt_allowed_yn"));
		setSal_allowed_yn			((String) htRecordSet.get("sal_allowed_yn"));
		setSrt_allowed_yn			((String) htRecordSet.get("srt_allowed_yn"));
		setObs_allowed_yn			((String) htRecordSet.get("obs_allowed_yn"));
		setCancelRequest_yn			(checkForNull((String) htRecordSet.get("cancel_request_yn"),"N"));
		setSplit_batch_allowed_yn	((String) htRecordSet.get("split_batch_allowed_yn"));
		setProcessExpiredBatch_yn	((String) htRecordSet.get("process_expired_items_yn"));
		setProcessSuspendedBatch_yn	((String) htRecordSet.get("process_suspended_items_yn"));
		setBin_change_allowed_yn	((String) htRecordSet.get("bin_change_allowed_yn"));
		setGrn_finalize_allowed_yn	((String) htRecordSet.get("grn_finalize_allowed_yn"));
		setRtv_finalize_allowed_yn	((String) htRecordSet.get("rtv_finalize_allowed_yn"));
        setIss_finalize_allowed_yn	((String) htRecordSet.get("iss_finalize_allowed_yn"));
		setReq_authorize_allowed_yn	((String) htRecordSet.get("req_authorize_allowed_yn"));
		setMfg_finalize_allowed_yn	((String) htRecordSet.get("mfg_finalize_allowed_yn"));
		setTfr_finalize_allowed_yn	((String) htRecordSet.get("tfr_finalize_allowed_yn"));
		setAdj_finalize_allowed_yn	((String) htRecordSet.get("adj_finalize_allowed_yn"));
		setSal_authorize_allowed_yn	((String) htRecordSet.get("sal_authorize_allowed_yn"));
		setSrt_finalize_allowed_yn	((String) htRecordSet.get("srt_finalize_allowed_yn"));
		setUrg_finalize_allowed_yn	((String) htRecordSet.get("urg_finalize_allowed_yn"));
		setRet_finalize_allowed_yn	((String) htRecordSet.get("ret_finalize_allowed_yn"));
		setAuthorizeSpecialReq_yn	((String) htRecordSet.get("authorize_spl_req_allowed_yn"));
		setStk_item_con_allowed_yn	((String) htRecordSet.get("stk_item_con_allowed_yn"));		
		setIss_acknowledge_yn		((String) htRecordSet.get("iss_acknowledge_yn"));
		setIss_confirm_yn			((String) htRecordSet.get("iss_confirm_yn"));
		setUrg_acknowledge_yn		((String) htRecordSet.get("urg_acknowledge_yn"));
		setUrg_confirm_yn			((String) htRecordSet.get("urg_confirm_yn"));
		setRet_acknowledge_yn		((String) htRecordSet.get("ret_acknowledge_yn"));
		setRet_confirm_yn			((String) htRecordSet.get("ret_confirm_yn"));
		setTfr_acknowledge_yn		((String) htRecordSet.get("tfr_acknowledge_yn"));
		setTfr_confirm_yn			((String) htRecordSet.get("tfr_confirm_yn"));
	//PORequest
		setPRQ_allowed_yn			((String) htRecordSet.get("prq_allowed_yn"));
		setPRQ_finalize_allowed_yn	((String) htRecordSet.get("prq_finalize_allowed_yn"));
		setInterface_to_external_po_yn((String) htRecordSet.get("interface_to_external_po_yn" ));
/* transaction audit trail*/
		setReq_delete_yn((String) htRecordSet.get("req_delete_yn"));
		setUrg_delete_yn((String) htRecordSet.get("urg_delete_yn")); 
		setIss_delete_yn((String) htRecordSet.get("iss_delete_yn")); 
		setRet_delete_yn((String) htRecordSet.get("ret_delete_yn")); 
		setAdj_delete_yn((String) htRecordSet.get("adj_delete_yn")); 
		setPrt_delete_yn((String) htRecordSet.get("prt_delete_yn")); 
		setSal_delete_yn((String) htRecordSet.get("sal_delete_yn")); 
		setSrt_delete_yn((String) htRecordSet.get("srt_delete_yn")); 
		setGrn_delete_yn((String) htRecordSet.get("grn_delete_yn")); 
		setRtv_delete_yn((String) htRecordSet.get("rtv_delete_yn")); 
		setMfg_delete_yn((String) htRecordSet.get("mfg_delete_yn")); 
		setTfr_delete_yn((String) htRecordSet.get("tfr_delete_yn")); 
		setPrq_delete_yn((String) htRecordSet.get("prq_delete_yn")); 
		setCndmn_exp_btch_allowed_yn(checkForNull((String) htRecordSet.get("cndmn_exp_btch_allowed_yn"),"N")); 
		setView_cost_yn((String) htRecordSet.get("view_cost_yn"));  //Added By Rabbani  on
		setView_sale_yn((String) htRecordSet.get("view_sale_yn"));  //16/09/11
		setDflt_item_search((String) htRecordSet.get("dflt_item_search")); //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		setDflt_sal_type(checkForNull((String) htRecordSet.get("dflt_sal_type")));   // Added by Padmapriya 
		
		setGrn_finalize_prompt_yn	((String) htRecordSet.get("grn_finalize_prompt_yn")); //Added for SKR-CRF-0039
		setRtv_finalize_prompt_yn	((String) htRecordSet.get("rtv_finalize_prompt_yn"));
		setIss_finalize_prompt_yn	((String) htRecordSet.get("iss_finalize_prompt_yn"));
		setReq_authorize_prompt_yn	((String) htRecordSet.get("req_authorize_prompt_yn"));
		setMfg_finalize_prompt_yn	((String) htRecordSet.get("mfg_finalize_prompt_yn"));
		setTfr_finalize_prompt_yn	((String) htRecordSet.get("tfr_finalize_prompt_yn"));
		setAdj_finalize_prompt_yn	((String) htRecordSet.get("adj_finalize_prompt_yn"));
		setSal_authorize_prompt_yn	((String) htRecordSet.get("sal_authorize_prompt_yn"));
		setSrt_finalize_prompt_yn	((String) htRecordSet.get("srt_finalize_prompt_yn"));
		setUrg_finalize_prompt_yn	((String) htRecordSet.get("urg_finalize_prompt_yn"));
		setRet_finalize_prompt_yn	((String) htRecordSet.get("ret_finalize_prompt_yn")); //Ended
		setDisp_curr_enc_findtl_yn	((String) htRecordSet.get("disp_curr_enc_findtl_yn"));//Added by suresh.r 12-11-2013 against JD-CRF-156
		setDisp_min_rol_yn	(checkForNull((String) htRecordSet.get("disp_min_rol_yn"),"N"));//Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
		
		setPrt_finalize_allowed_yn	((String) htRecordSet.get("prt_finalize_allowed_yn")); //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
		setPrt_finalize_prompt_yn	((String) htRecordSet.get("prt_finalize_prompt_yn"));  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
		setAuthorize_at_issue_store_allowed_yn(checkForNull((String) htRecordSet.get("authorize_at_issue_store_allowed_yn"),"N"));//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		setCancel_Authorize_at_issue_store_allowed_yn(checkForNull((String) htRecordSet.get("cancel_authorize_iss_allow_yn"),"N"));//Added TFS ID - 23934 - 	MO-CRF-20177
		setReject_Request_at_issue_store_allowed_yn(checkForNull((String) htRecordSet.get("reject_request_issue_store_allowed_yn"),"N"));//Added TFS ID - 29303 - 	MO-CRF-20174

	}
	/* Over-ridden Adapter methods end here */


	/* Function specific methods start */

	public void loadData() {
			
		String []stParameters		=	{getLoginById(), getStore_code()};
		HashMap hmRecord	=	null;
		try
		{
		//	hmRecord	=	fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE1"), stParameters);
			//hmRecord	=	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_SALE_YN,VIEW_COST_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN  FROM	ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters);//Commented by suresh.r 12-11-2013 against JD-CRF-156
			//hmRecord	=	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_SALE_YN,VIEW_COST_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN,  FROM	ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters);//Added by suresh.r 12-11-2013 against JD-CRF-156
			//Added by Rabbani #AMS-CRF-0068(49822) on 08-AUG-2014
			//hmRecord	=	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_SALE_YN,VIEW_COST_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN,DISP_MIN_ROL_YN FROM ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters);//Added by suresh.r 12-11-2013 against JD-CRF-156
			//Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
			//hmRecord	=	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_SALE_YN,VIEW_COST_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN,DISP_MIN_ROL_YN,PRT_FINALIZE_ALLOWED_YN,PRT_FINALIZE_PROMPT_YN FROM ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters);//Added by suresh.r 12-11-2013 against JD-CRF-156
			//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
			hmRecord	=	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_SALE_YN,VIEW_COST_YN,DFLT_ITEM_SEARCH,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN, DISP_MIN_ROL_YN, PRT_FINALIZE_ALLOWED_YN, PRT_FINALIZE_PROMPT_YN, AUTHORIZE_AT_ISSUE_ALLOWED_YN,CANCEL_AUTHORIZE_ISS_ALLOW_YN,REJECT_REQUEST_ISS_ALLOW_YN FROM ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters);  //added CANCEL_AUTHORIZE_AT_ISSUE_ALLOWED_YN - TFS ID -  23934 -  MO-CRF-20177 // REJECT_REQUEST_ISS_ALLOW_YN - TFS ID -  29303 -  MO-CRF-20174



		//System.out.println("stParameters-=-=-=-="+ stParameters);
		//System.out.println("hmRecord-=-=-=-="+ hmRecord);

		}
		
		catch (Exception e)
		{
		}
		
		
		setStore_code              ((String) hmRecord.get("STORE_CODE"));           
		setUser_id                 ((String) hmRecord.get("USER_ID"));              
		setGrn_allowed_yn          ((String) hmRecord.get("GRN_ALLOWED_YN"));       
		setRtv_allowed_yn          ((String) hmRecord.get("RTV_ALLOWED_YN"));       
		setMfg_allowed_yn          ((String) hmRecord.get("MFG_ALLOWED_YN"));       
		setReq_allowed_yn          ((String) hmRecord.get("REQ_ALLOWED_YN"));       
		setIss_allowed_yn          ((String) hmRecord.get("ISS_ALLOWED_YN"));       
		setUrg_allowed_yn          ((String) hmRecord.get("URG_ALLOWED_YN"));       
		setRet_allowed_yn          ((String) hmRecord.get("RET_ALLOWED_YN"));       
		setTfr_allowed_yn          ((String) hmRecord.get("TFR_ALLOWED_YN"));       
		setAdj_allowed_yn          ((String) hmRecord.get("ADJ_ALLOWED_YN"));       
		setVar_allowed_yn          ((String) hmRecord.get("VAR_ALLOWED_YN"));       
		setPrt_allowed_yn          ((String) hmRecord.get("PRT_ALLOWED_YN"));       
		setSal_allowed_yn          ((String) hmRecord.get("SAL_ALLOWED_YN"));       
		setSrt_allowed_yn          ((String) hmRecord.get("SRT_ALLOWED_YN"));       
		setObs_allowed_yn          ((String) hmRecord.get("OBS_ALLOWED_YN"));       
		setSplit_batch_allowed_yn  ((String) hmRecord.get("SPLIT_BATCH_ALLOWED_YN"));
		setProcessExpiredBatch_yn  ((String) hmRecord.get("PROCESS_EXPIRED_ITEMS_YN"));
		setProcessSuspendedBatch_yn((String) hmRecord.get("PROCESS_SUSPENDED_ITEMS_YN"));
		
		setBin_change_allowed_yn   ((String) hmRecord.get("BIN_CHANGE_ALLOWED_YN"));
		setGrn_finalize_allowed_yn ((String) hmRecord.get("GRN_FINALIZE_ALLOWED_YN"));
		setRtv_finalize_allowed_yn ((String) hmRecord.get("RTV_FINALIZE_ALLOWED_YN"));
        setIss_finalize_allowed_yn ((String) hmRecord.get("ISS_FINALIZE_ALLOWED_YN"));
		setReq_authorize_allowed_yn((String) hmRecord.get("REQ_AUTHORIZE_ALLOWED_YN"));
		setMfg_finalize_allowed_yn ((String) hmRecord.get("MFG_FINALIZE_ALLOWED_YN"));
		setTfr_finalize_allowed_yn ((String) hmRecord.get("TFR_FINALIZE_ALLOWED_YN"));
		setAdj_finalize_allowed_yn ((String) hmRecord.get("ADJ_FINALIZE_ALLOWED_YN"));
		setSal_authorize_allowed_yn((String) hmRecord.get("SAL_AUTHORIZE_ALLOWED_YN"));
		setSrt_finalize_allowed_yn ((String) hmRecord.get("SRT_FINALIZE_ALLOWED_YN"));
		setUrg_finalize_allowed_yn ((String) hmRecord.get("URG_FINALIZE_ALLOWED_YN"));
		setRet_finalize_allowed_yn ((String) hmRecord.get("RET_FINALIZE_ALLOWED_YN"));
		setAuthorizeSpecialReq_yn  ((String) hmRecord.get("AUTHORIZE_SPECIAL_REQ_YN"));
		setStk_item_con_allowed_yn ((String) hmRecord.get("STK_ITEM_CON_ALLOWED_YN"));       
		setIss_acknowledge_yn		((String) hmRecord.get("ISS_ACKNOWLEDGE_YN"));
		setIss_confirm_yn			((String) hmRecord.get("ISS_CONFIRM_YN"));
		setUrg_acknowledge_yn		((String) hmRecord.get("URG_ACKNOWLEDGE_YN"));
		setUrg_confirm_yn			((String) hmRecord.get("URG_CONFIRM_YN"));
		setRet_acknowledge_yn		((String) hmRecord.get("RET_ACKNOWLEDGE_YN"));
		setRet_confirm_yn			((String) hmRecord.get("RET_CONFIRM_YN"));
		setTfr_acknowledge_yn		((String) hmRecord.get("TFR_ACKNOWLEDGE_YN"));
		setTfr_confirm_yn			((String) hmRecord.get("TFR_CONFIRM_YN"));
		setCancelRequest_yn			((String) hmRecord.get("CANCL_ALLOWED_YN"));
		setPRQ_allowed_yn          ((String) hmRecord.get("PRQ_ALLOWED_YN"));   
		setPRQ_finalize_allowed_yn ((String) hmRecord.get("PRQ_FINALIZE_ALLOWED_YN"));
		/* transaction audit trail*/
		setReq_delete_yn((String) hmRecord.get("REQ_DELETE_YN"));
		setUrg_delete_yn((String) hmRecord.get("URG_DELETE_YN")); 
		setIss_delete_yn((String) hmRecord.get("ISS_DELETE_YN")); 
		setRet_delete_yn((String) hmRecord.get("RET_DELETE_YN")); 
		setAdj_delete_yn((String) hmRecord.get("ADJ_DELETE_YN")); 
		setPrt_delete_yn((String) hmRecord.get("PRT_DELETE_YN")); 
		setSal_delete_yn((String) hmRecord.get("SAL_DELETE_YN")); 
		setSrt_delete_yn((String) hmRecord.get("SRT_DELETE_YN")); 
		setGrn_delete_yn((String) hmRecord.get("GRN_DELETE_YN")); 
		setRtv_delete_yn((String) hmRecord.get("RTV_DELETE_YN")); 
		setMfg_delete_yn((String) hmRecord.get("MFG_DELETE_YN")); 
		setTfr_delete_yn((String) hmRecord.get("TFR_DELETE_YN")); 
		setPrq_delete_yn((String) hmRecord.get("PRQ_DELETE_YN")); 
		setCndmn_exp_btch_allowed_yn((String) hmRecord.get("CNDMN_EXP_BTCH_ALLOWED_YN")); 
	    setView_cost_yn((String) hmRecord.get("VIEW_COST_YN"));	  //16/09/11
	    setView_sale_yn((String) hmRecord.get("VIEW_SALE_YN"));  //16/09/11
		setDflt_item_search((String) hmRecord.get("DFLT_ITEM_SEARCH")); //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		setDflt_sal_type(checkForNull((String) hmRecord.get("DFLT_SAL_TRN_TYPE")));  // Added by Padmapriya 
		
		setGrn_finalize_prompt_yn	((String) hmRecord.get("GRN_FINALIZE_PROMPT_YN")); //Added For SKR-crf-0039
		setRtv_finalize_prompt_yn	((String) hmRecord.get("RTV_FINALIZE_PROMPT_YN"));
		setIss_finalize_prompt_yn	((String) hmRecord.get("ISS_FINALIZE_PROMPT_YN"));
		setReq_authorize_prompt_yn	((String) hmRecord.get("REQ_AUTHORIZE_PROMPT_YN"));
		setMfg_finalize_prompt_yn	((String) hmRecord.get("MFG_FINALIZE_PROMPT_YN"));
		setTfr_finalize_prompt_yn	((String) hmRecord.get("TFR_FINALIZE_PROMPT_YN"));
		setAdj_finalize_prompt_yn	((String) hmRecord.get("ADJ_FINALIZE_PROMPT_YN"));
		setSal_authorize_prompt_yn	((String) hmRecord.get("SAL_AUTHORIZE_PROMPT_YN"));
		setSrt_finalize_prompt_yn	((String) hmRecord.get("SRT_FINALIZE_PROMPT_YN"));
		setUrg_finalize_prompt_yn	((String) hmRecord.get("URG_FINALIZE_PROMPT_YN"));
		setRet_finalize_prompt_yn	((String) hmRecord.get("RET_FINALIZE_PROMPT_YN")); //ENDED
		setDisp_curr_enc_findtl_yn	((String) hmRecord.get("DISP_CURR_ENCNTR_FIN_DTL_YN"));//Added by suresh.r 12-11-2013 against JD-CRF-156
		setDisp_min_rol_yn(checkForNull((String) hmRecord.get("DISP_MIN_ROL_YN")));//Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
		setPrt_finalize_allowed_yn ((String) hmRecord.get("PRT_FINALIZE_ALLOWED_YN")); //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016

		setPrt_finalize_prompt_yn ((String) hmRecord.get("PRT_FINALIZE_PROMPT_YN"));  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
		setAuthorize_at_issue_store_allowed_yn((String) hmRecord.get("AUTHORIZE_AT_ISSUE_ALLOWED_YN"));//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		setCancel_Authorize_at_issue_store_allowed_yn((String) hmRecord.get("cancel_authorize_iss_allow_yn"));//Added TFS ID - 23934 - MO-CRF-20177
		setReject_Request_at_issue_store_allowed_yn((String) hmRecord.get("REJECT_REQUEST_ISS_ALLOW_YN"));//Added TFS ID - 29303 - MO-CRF-20174
		

	   try{		  
			 hmp = new ArrayList();
			 hmp = getTrnTypeArrayList();
			} catch (Exception e)
		  {
		  } 
	}

    /* To retrive value for check boxes whether checked/unchecked according to the accessibitity
	   given in the st_user_access_for_store table */

	public HashMap getUserAccessForStoreData() {
		try { 
			  String []stParameters		=	{getUser_id(), getStore_code()};
			//  return fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_SINGLE1"), stParameters);
		  //return 	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH ,DFLT_SAL_TRN_TYPE  FROM	ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters);
			  //return 	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH ,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN  FROM	ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters);//Commented DISP_CURR_ENCNTR_FIN_DTL_YN by suresh.r 12-11-2013 against JD-CRF-156
			 // return 	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH ,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN  FROM	ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters);//Added DISP_CURR_ENCNTR_FIN_DTL_YN by suresh.r 12-11-2013 against JD-CRF-156
			 
			 //Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
			 // return 	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH ,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN,DISP_MIN_ROL_YN FROM	ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters); 
			 
			  
			//Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
			  //return 	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH ,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN,DISP_MIN_ROL_YN,PRT_FINALIZE_ALLOWED_YN,PRT_FINALIZE_PROMPT_YN FROM	ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters); 
			  //Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
			  return 	fetchRecord("SELECT USER_ID,STORE_CODE,OBS_ALLOWED_YN,GRN_ALLOWED_YN,GRN_FINALIZE_ALLOWED_YN, RTV_ALLOWED_YN, RTV_FINALIZE_ALLOWED_YN,MFG_ALLOWED_YN,REQ_ALLOWED_YN,REQ_AUTHORIZE_ALLOWED_YN,ISS_ALLOWED_YN,URG_ALLOWED_YN,URG_FINALIZE_ALLOWED_YN,RET_ALLOWED_YN,RET_FINALIZE_ALLOWED_YN,TFR_ALLOWED_YN,TFR_FINALIZE_ALLOWED_YN,ADJ_ALLOWED_YN,ADJ_FINALIZE_ALLOWED_YN,VAR_ALLOWED_YN,PRT_ALLOWED_YN,SAL_ALLOWED_YN,SAL_AUTHORIZE_ALLOWED_YN,SRT_ALLOWED_YN,SRT_FINALIZE_ALLOWED_YN,SPLIT_BATCH_ALLOWED_YN,BIN_CHANGE_ALLOWED_YN,ISS_FINALIZE_ALLOWED_YN,MFG_FINALIZE_ALLOWED_YN,AUTHORIZE_SPECIAL_REQ_YN,STK_ITEM_CON_ALLOWED_YN,PROCESS_EXPIRED_ITEMS_YN,PROCESS_SUSPENDED_ITEMS_YN,ISS_ACKNOWLEDGE_YN, ISS_CONFIRM_YN, URG_ACKNOWLEDGE_YN, URG_CONFIRM_YN, RET_ACKNOWLEDGE_YN, RET_CONFIRM_YN, TFR_ACKNOWLEDGE_YN, TFR_CONFIRM_YN,CANCL_ALLOWED_YN,PRQ_ALLOWED_YN,PRQ_FINALIZE_ALLOWED_YN,REQ_DELETE_YN, URG_DELETE_YN, ISS_DELETE_YN, RET_DELETE_YN, ADJ_DELETE_YN, PRT_DELETE_YN, SAL_DELETE_YN, SRT_DELETE_YN, GRN_DELETE_YN, RTV_DELETE_YN, MFG_DELETE_YN, TFR_DELETE_YN, PRQ_DELETE_YN,CNDMN_EXP_BTCH_ALLOWED_YN,VIEW_COST_YN,VIEW_SALE_YN,DFLT_ITEM_SEARCH ,DFLT_SAL_TRN_TYPE,GRN_FINALIZE_PROMPT_YN,RTV_FINALIZE_PROMPT_YN,MFG_FINALIZE_PROMPT_YN,REQ_AUTHORIZE_PROMPT_YN,ISS_FINALIZE_PROMPT_YN,URG_FINALIZE_PROMPT_YN,RET_FINALIZE_PROMPT_YN,TFR_FINALIZE_PROMPT_YN,ADJ_FINALIZE_PROMPT_YN,SAL_AUTHORIZE_PROMPT_YN,SRT_FINALIZE_PROMPT_YN,DISP_CURR_ENCNTR_FIN_DTL_YN,DISP_MIN_ROL_YN,PRT_FINALIZE_ALLOWED_YN,PRT_FINALIZE_PROMPT_YN,AUTHORIZE_AT_ISSUE_ALLOWED_YN, CANCEL_AUTHORIZE_ISS_ALLOW_YN, REJECT_REQUEST_ISS_ALLOW_YN  FROM	ST_USER_ACCESS_FOR_STORE WHERE USER_ID = ? AND STORE_CODE =? ", stParameters); // TFS ID -  23934 -  MO-CRF-20177
		}	
		catch (Exception exception) {
		
			exception.printStackTrace();
		}
		return null;
	}

   /* To initialize for the checkboxes according to the value retrived */

	public void initialize(HashMap hmRecord){
		setGrn_allowed_yn			((String) hmRecord.get("GRN_ALLOWED_YN"));         
		setRtv_allowed_yn			((String) hmRecord.get("RTV_ALLOWED_YN"));         
		setMfg_allowed_yn			((String) hmRecord.get("MFG_ALLOWED_YN"));         
		setReq_allowed_yn			((String) hmRecord.get("REQ_ALLOWED_YN"));         
		setIss_allowed_yn			((String) hmRecord.get("ISS_ALLOWED_YN"));         
		setUrg_allowed_yn			((String) hmRecord.get("URG_ALLOWED_YN"));         
		setRet_allowed_yn			((String) hmRecord.get("RET_ALLOWED_YN"));         
		setTfr_allowed_yn			((String) hmRecord.get("TFR_ALLOWED_YN"));         
		setAdj_allowed_yn			((String) hmRecord.get("ADJ_ALLOWED_YN"));         
		setVar_allowed_yn			((String) hmRecord.get("VAR_ALLOWED_YN"));         
		setPrt_allowed_yn			((String) hmRecord.get("PRT_ALLOWED_YN"));         
		setSal_allowed_yn			((String) hmRecord.get("SAL_ALLOWED_YN"));         
		setSrt_allowed_yn			((String) hmRecord.get("SRT_ALLOWED_YN"));         
		setObs_allowed_yn			((String) hmRecord.get("OBS_ALLOWED_YN"));         
		setSplit_batch_allowed_yn	((String) hmRecord.get("SPLIT_BATCH_ALLOWED_YN")); 
		setProcessExpiredBatch_yn	((String) hmRecord.get("PROCESS_EXPIRED_ITEMS_YN"));
		setProcessSuspendedBatch_yn	((String) hmRecord.get("PROCESS_SUSPENDED_ITEMS_YN"));
		setBin_change_allowed_yn	((String) hmRecord.get("BIN_CHANGE_ALLOWED_YN"));  
		setGrn_finalize_allowed_yn	((String) hmRecord.get("GRN_FINALIZE_ALLOWED_YN"));
		setRtv_finalize_allowed_yn	((String) hmRecord.get("RTV_FINALIZE_ALLOWED_YN"));
        setIss_finalize_allowed_yn	((String) hmRecord.get("ISS_FINALIZE_ALLOWED_YN"));
		setReq_authorize_allowed_yn	((String) hmRecord.get("REQ_AUTHORIZE_ALLOWED_YN"));
		setMfg_finalize_allowed_yn	((String) hmRecord.get("MFG_FINALIZE_ALLOWED_YN"));
		setTfr_finalize_allowed_yn	((String) hmRecord.get("TFR_FINALIZE_ALLOWED_YN"));
		setAdj_finalize_allowed_yn	((String) hmRecord.get("ADJ_FINALIZE_ALLOWED_YN"));
		setSal_authorize_allowed_yn	((String) hmRecord.get("SAL_AUTHORIZE_ALLOWED_YN"));
		setSrt_finalize_allowed_yn	((String) hmRecord.get("SRT_FINALIZE_ALLOWED_YN"));
		setUrg_finalize_allowed_yn	((String) hmRecord.get("URG_FINALIZE_ALLOWED_YN"));
		setRet_finalize_allowed_yn	((String) hmRecord.get("RET_FINALIZE_ALLOWED_YN"));
		setAuthorizeSpecialReq_yn	(checkForNull((String) hmRecord.get("AUTHORIZE_SPECIAL_REQ_YN"),"N"));
		setStk_item_con_allowed_yn	((String) hmRecord.get("STK_ITEM_CON_ALLOWED_YN"));
		setIss_acknowledge_yn		((String) hmRecord.get("ISS_ACKNOWLEDGE_YN"));
		setIss_confirm_yn			((String) hmRecord.get("ISS_CONFIRM_YN"));
		setUrg_acknowledge_yn		((String) hmRecord.get("URG_ACKNOWLEDGE_YN"));
		setUrg_confirm_yn			((String) hmRecord.get("URG_CONFIRM_YN"));
		setRet_acknowledge_yn		((String) hmRecord.get("RET_ACKNOWLEDGE_YN"));
		setRet_confirm_yn			((String) hmRecord.get("RET_CONFIRM_YN"));
		setTfr_acknowledge_yn		((String) hmRecord.get("TFR_ACKNOWLEDGE_YN"));
		setTfr_confirm_yn			((String) hmRecord.get("TFR_CONFIRM_YN"));
		setCancelRequest_yn			((String) hmRecord.get("CANCL_ALLOWED_YN"));
		setPRQ_allowed_yn			((String) hmRecord.get("PRQ_ALLOWED_YN"));  
		setPRQ_finalize_allowed_yn	((String) hmRecord.get("PRQ_FINALIZE_ALLOWED_YN"));
		/* transaction audit trail*/
		setReq_delete_yn((String) hmRecord.get("REQ_DELETE_YN"));
		setUrg_delete_yn((String) hmRecord.get("URG_DELETE_YN")); 
		setIss_delete_yn((String) hmRecord.get("ISS_DELETE_YN")); 
		setRet_delete_yn((String) hmRecord.get("RET_DELETE_YN")); 
		setAdj_delete_yn((String) hmRecord.get("ADJ_DELETE_YN")); 
		setPrt_delete_yn((String) hmRecord.get("PRT_DELETE_YN")); 
		setSal_delete_yn((String) hmRecord.get("SAL_DELETE_YN")); 
		setSrt_delete_yn((String) hmRecord.get("SRT_DELETE_YN")); 
		setGrn_delete_yn((String) hmRecord.get("GRN_DELETE_YN")); 
		setRtv_delete_yn((String) hmRecord.get("RTV_DELETE_YN")); 
		setMfg_delete_yn((String) hmRecord.get("MFG_DELETE_YN")); 
		setTfr_delete_yn((String) hmRecord.get("TFR_DELETE_YN")); 
		setPrq_delete_yn((String) hmRecord.get("PRQ_DELETE_YN")); 
		setCndmn_exp_btch_allowed_yn((String) hmRecord.get("CNDMN_EXP_BTCH_ALLOWED_YN")); 
	    setView_cost_yn((String) hmRecord.get("VIEW_COST_YN"));  //16/09/11
		setView_sale_yn((String) hmRecord.get("VIEW_SALE_YN"));  //16/09/11
		setDflt_item_search((String) hmRecord.get("DFLT_ITEM_SEARCH")); //Added by Sakti Sankar against Inc#-29441 for defaulting item search criteria
		setDflt_sal_type(checkForNull((String) hmRecord.get("DFLT_SAL_TRN_TYPE")));  // Added by Padmapriya 
		
		setGrn_finalize_prompt_yn	((String) hmRecord.get("GRN_FINALIZE_PROMPT_YN")); //Added For SKR-crf-0039
		setRtv_finalize_prompt_yn	((String) hmRecord.get("RTV_FINALIZE_PROMPT_YN"));
		setIss_finalize_prompt_yn	((String) hmRecord.get("ISS_FINALIZE_PROMPT_YN"));
		setReq_authorize_prompt_yn	((String) hmRecord.get("REQ_AUTHORIZE_PROMPT_YN"));
		setMfg_finalize_prompt_yn	((String) hmRecord.get("MFG_FINALIZE_PROMPT_YN"));
		setTfr_finalize_prompt_yn	((String) hmRecord.get("TFR_FINALIZE_PROMPT_YN"));
		setAdj_finalize_prompt_yn	((String) hmRecord.get("ADJ_FINALIZE_PROMPT_YN"));
		setSal_authorize_prompt_yn	((String) hmRecord.get("SAL_AUTHORIZE_PROMPT_YN"));
		setSrt_finalize_prompt_yn	((String) hmRecord.get("SRT_FINALIZE_PROMPT_YN"));
		setUrg_finalize_prompt_yn	((String) hmRecord.get("URG_FINALIZE_PROMPT_YN"));
		setRet_finalize_prompt_yn	((String) hmRecord.get("RET_FINALIZE_PROMPT_YN"));  //ended
		setDisp_curr_enc_findtl_yn	((String) hmRecord.get("DISP_CURR_ENCNTR_FIN_DTL_YN"));//Added by suresh.r 12-11-2013 against JD-CRF-156
		setDisp_min_rol_yn	(checkForNull((String) hmRecord.get("DISP_MIN_ROL_YN"),"N"));//Added by Rabbani#AMS-CRF-0068(49822) on 08-AUG-2014
	
		setPrt_finalize_allowed_yn	((String) hmRecord.get("PRT_FINALIZE_ALLOWED_YN")); //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
		setPrt_finalize_prompt_yn	((String) hmRecord.get("PRT_FINALIZE_PROMPT_YN"));  //Added for ML-MMOH-CRF-0448-US01 [IN:057461] by Manoj Kumar on 03/02/2016
		setAuthorize_at_issue_store_allowed_yn((String) hmRecord.get("AUTHORIZE_AT_ISSUE_ALLOWED_YN"));//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		setCancel_Authorize_at_issue_store_allowed_yn((String) hmRecord.get("CANCEL_AUTHORIZE_ISS_ALLOW_YN"));//Added TFSID-23934 - MO-CR-20177
		setReject_Request_at_issue_store_allowed_yn((String) hmRecord.get("REJECT_REQUEST_ISS_ALLOW_YN"));//Added TFSID-29303 - MO-CR-20174
	}
    /* To retrive the transaction applicable for a particular store  */

     
	public HashMap getStoreData() throws Exception {
		// Modified by Pankaj on 19/10/2004 
		String []stParameters		=	{getStore_code()} ; //,getLoginFacilityId() };
		HashMap result = null;
		try{
			//result = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_USER_ACCESS_FOR_STORE_SELECT_STORE_SINGLE"),stParameters);
			//result = fetchRecord("SELECT   A.STORE_CODE, A.STORE_TYPE_FLAG,	A.MEDICAL_ITEM_YN ,	  A.NONMEDICAL_ITEM_YN,	A.REORDER_FREQ_DAYS, A.CHK_STK_LVL_FOR_PUR_YN, A.GRN_ALLOWED_YN, A.RTV_ALLOWED_YN, A.MFG_ALLOWED_YN,  A.REQ_ALLOWED_YN,	A.ISS_ALLOWED_YN,  A.URG_ALLOWED_YN, A.RET_ALLOWED_YN,	A.TFR_ALLOWED_YN ,A.ADJ_ALLOWED_YN,	 A.VAR_ALLOWED_YN, A.PRT_ALLOWED_YN,  A.SAL_ALLOWED_YN,	A.SRT_ALLOWED_YN, A.SPLIT_BATCH_ALLOWED_YN,   A.BIN_CHANGE_ALLOWED_YN,	A.OBS_ALLOWED_YN,	A.PARENT_STORE_CODE	,B.SHORT_DESC STORE_DESC, C.SHORT_DESC DEPT_DESC, B.EXTERNAL_YN,A.AUTHORIZE_SPECIAL_REQ_YN, A.STK_ITEM_CON_ALLOWED_YN, A.ALERT_FOR_PRINT_PICKSLIP_YN,A.PRQ_ALLOWED_YN,CNDMN_EXP_BTCH_ALLOWED_YN FROM ST_STORE A,MM_STORE B,	AM_DEPT	C WHERE	A.STORE_CODE = ? AND /* B.FACILITY_ID=? AND */ A.STORE_CODE=B.STORE_CODE AND B.DEPT_CODE=C.DEPT_CODE(+)",stParameters);
		//	result = fetchRecord("SELECT   a.store_code, a.store_type_flag,	a.medical_item_yn ,	  a.nonmedical_item_yn,	a.reorder_freq_days, a.chk_stk_lvl_for_pur_yn, a.grn_allowed_yn, a.rtv_allowed_yn, a.mfg_allowed_yn,  a.req_allowed_yn,	a.iss_allowed_yn,  a.urg_allowed_yn, a.ret_allowed_yn,	a.tfr_allowed_yn ,a.adj_allowed_yn,	 a.var_allowed_yn, a.prt_allowed_yn,  a.sal_allowed_yn,	a.srt_allowed_yn, a.split_batch_allowed_yn,   a.bin_change_allowed_yn,	a.obs_allowed_yn,	a.parent_store_code	,b.short_desc store_desc, c.short_desc dept_desc, b.external_yn,a.AUTHORIZE_SPECIAL_REQ_YN, a.STK_ITEM_CON_ALLOWED_YN, a.alert_for_print_pickslip_yn,a.prq_allowed_yn FROM st_store a,mm_Store b,	am_dept	c WHERE	a.store_code = ? and /* b.facility_id=? and */ a.store_code=b.store_code and b.dept_code=c.dept_code(+)",stParameters);
			//Modified by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
			result = fetchRecord("SELECT   A.STORE_CODE, A.STORE_TYPE_FLAG,	A.MEDICAL_ITEM_YN ,	  A.NONMEDICAL_ITEM_YN,	A.REORDER_FREQ_DAYS, A.CHK_STK_LVL_FOR_PUR_YN, A.GRN_ALLOWED_YN, A.RTV_ALLOWED_YN, A.MFG_ALLOWED_YN,  A.REQ_ALLOWED_YN,	A.ISS_ALLOWED_YN,  A.URG_ALLOWED_YN, A.RET_ALLOWED_YN,	A.TFR_ALLOWED_YN ,A.ADJ_ALLOWED_YN,	 A.VAR_ALLOWED_YN, A.PRT_ALLOWED_YN,  A.SAL_ALLOWED_YN,	A.SRT_ALLOWED_YN, A.SPLIT_BATCH_ALLOWED_YN,   A.BIN_CHANGE_ALLOWED_YN,	A.OBS_ALLOWED_YN,	A.PARENT_STORE_CODE	,B.SHORT_DESC STORE_DESC, C.SHORT_DESC DEPT_DESC, B.EXTERNAL_YN,A.AUTHORIZE_SPECIAL_REQ_YN, A.STK_ITEM_CON_ALLOWED_YN, A.ALERT_FOR_PRINT_PICKSLIP_YN,A.PRQ_ALLOWED_YN,CNDMN_EXP_BTCH_ALLOWED_YN, AUTHORIZE_AT_ISSUE_ALLOWED_YN FROM ST_STORE A,MM_STORE B,	AM_DEPT	C WHERE	A.STORE_CODE = ? AND /* B.FACILITY_ID=? AND */ A.STORE_CODE=B.STORE_CODE AND B.DEPT_CODE=C.DEPT_CODE(+)",stParameters);//Added AUTHORIZE_AT_ISSUE_ALLOWED_YN

		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		return result;
		
		
	}

    /* To populate the stores in the front end list box for search */

    public String getStore_code_List(){
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(getLanguageId());
		String result = null;
		try{
			result = getListOptionTag(getWithoutLangIdListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_LIST_ACROSS_FCY"),arr_lang));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		return result;
	}
/* To populate the SEARCH BY ITEM LIST in the front end list box for ITEM ON 20/10/2011*/
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

	
	// Added by Padmapriya

	public HashMap getSalesType(String store_code){
		HashMap hmRecord = null;
		
		try{
			hmRecord		=	fetchRecord(getStRepositoryValue("SQL_ST_STORE_SELECT1"),store_code);
		}catch(Exception e){
		}
		
		return hmRecord;
	}
	
	// End by Padmapriya
	public boolean isStoreDisabled() throws Exception  {
		HashMap hmResult	=	null;
		
		try{
			hmResult = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_MM_STORE_SELECT_STATUS"),getStore_code());
		}
		catch(Exception e){
			e.printStackTrace();
		}
	
		return ((String)hmResult.get("EFF_STATUS")).equals("D");
			
		
		
	}

	public boolean inventoryModuleScope() {
/*		HashMap hmResult	=	null;
		hmResult = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_(space)MM_INSTALLATION_PARAMETER_SELECT"));
		return ((String)hmResult.get("INVENTORY_MODULE_SCOPE")).equals("P");*/

		return new eMM.MM_license_rights().getSTboundary().equals("I");
	}
 public String getInterface_to_external_po_yn(String acc_entity_id) throws Exception {
	
//	HashMap result = fetchRecord("select INTERFACE_TO_EXTERNAL_PO_YN from st_acc_entity_param where acc_entity_id=?",acc_entity_id);
	HashMap result = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),acc_entity_id);

	String result_yn = checkForNull((String)result.get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");
	return result_yn;
	  }


public Boolean getAckReqdForIssue(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT ISS_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("ISS_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}
public Boolean getAckReqdForIssueReturn(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT RET_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("RET_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}
public Boolean getAckReqdForStockTransfer(){
		String ack_reqd = "N";
		try{
			ack_reqd = (String)fetchRecord("SELECT TFR_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId()).get("TFR_ACK_REQ_YN");
		}catch(Exception e){
			e.printStackTrace();
		}
		return checkForNull(ack_reqd,"N").equals("Y");
	}
	//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 16-AUG-2013  
	public HashMap getAckReqdyn(){
        HashMap hashmap = new HashMap();
		try{
			hashmap = fetchRecord("SELECT ISS_ACK_REQ_YN,URG_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN FROM ST_STORE WHERE STORE_CODE = ?", getStore_code());
		}catch(Exception e){
			e.printStackTrace();
			 
		}
        return hashmap;
    }
	//Added by suresh.r 12-11-2013 against JD-CRF-156 beg
	public String getBLModuleInstalled() throws Exception
	{
		HashMap result = fetchRecord(getStRepositoryValue( "SQL_ST_SAL_CHARGEABLE_YN"));
		String result_yn = checkForNull((String)result.get("BL_INTERFACE_YN"),"N");
		
		return result_yn;


	}
	//Added by suresh.r 12-11-2013 against JD-CRF-156 end
	//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts
		public String getAuthorize_at_issue_store_allowed_yn() {
			return authorize_at_issue_store_allowed_yn;
		}
		public void setAuthorize_at_issue_store_allowed_yn(String authorize_at_issue_store_allowed_yn) {
			this.authorize_at_issue_store_allowed_yn =  checkForNull(authorize_at_issue_store_allowed_yn,"N");
		}
//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends
}
