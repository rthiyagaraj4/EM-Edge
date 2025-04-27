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
21/04/2016				56060					B.Badmavathi									  Authorize at Issue Store	
31/10/2019              IN:071344               B Haribabu         15/10/2019        Manickam        GHL-CRF-0609  
08/06/2020              IN:072963               Haribabu           08/06/2020        Manickam                ML-MMOH-CRF-1389.1
22/2/2022				TFS27891				Shazana													MO-CRF-20176
--------------------------------------------------------------------------------------------------------------------------------------------
*/ 
package eST ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
//import java.util.Properties;
//import javax.naming.InitialContext ;
//import javax.rmi.PortableRemoteObject;
import eST.Common.StAdapter;
import eCommon.SingleTableHandler.*;

public class StoreBean extends StAdapter implements Serializable { 


	private String store_code				=	"";
	private String store_type_flag			=	"";
	private String parent_store_code		=	"";
	private String medical_item_yn			=	"N";
	private String nonmedical_item_yn		=	"N";
	private String reorder_freq_days		=	"";
	private String chk_stk_lvl_for_pur_yn	=	"N";
	private String grn_allowed_yn			=	"N";
	private String rtv_allowed_yn			=	"N";
	private String mfg_allowed_yn			=	"N";
	private String req_allowed_yn			=	"N";
	private String iss_allowed_yn			=	"N";
	private String urg_allowed_yn			=	"N";
	private String ret_allowed_yn			=	"N";
	private String tfr_allowed_yn			=	"N";
	private String adj_allowed_yn			=	"N";
	private String var_allowed_yn			=	"N";
	private String prt_allowed_yn			=	"N";
	private String sal_allowed_yn			=	"N";
	private String srt_allowed_yn			=	"N";
	private String obs_allowed_yn			=	"N";
	private String split_batch_allowed_yn	=	"N";
	private String bin_change_allowed_yn	=	"N";
	private String store_desc				=	"";
	private String dept_desc				=	"";
	private String external_yn				=	"N";
	private String storeTypeFlag			=	"N";
	private String checkCount				=	""; 
	private String authorizespecialreq_yn	=	"N";
	private String stock_item_cons_yn		=	"N";
	private String alert_for_print_yn		=	"N" ;
	private String prq_allowed_yn			=	"N" ;
	private String op_sale_appl_yn			=	"N" ;
	private String ip_sale_appl_yn			=	"N" ;
	private String ref_sale_appl_yn			=	"N" ;
    private String dc_sale_appl_yn			=	"N";
    private String em_sale_appl_yn			=	"N";
    private String direct_sale_appl_yn		=	"N";
	private String bin_loc_code				=	"";
	private String bin_loc_desc				=	"";
	private String cndmn_exp_btch_allowed_yn=	"N";
	//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 13-AUG-2013  
	private String iss_ack_yn               =	"N";
	private String urg_iss_ack_yn           =	"N";
	private String iss_ret_ack_yn           =	"N";
	private String tfr_ack_yn               =	"N";
    private String auth_allowed_yn          =	"N"; //Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
    private String chk_auto_rol_yn          =	"N"; //Added for  IN:071344 
    private String consm_freq_days		=	"";//Added for  IN:071344 
	private String auto_assoc_intf_items_yn			=	"N" ;//Added for IN:072963
	private String records_per_trn_urg = ""; //MO-CRF-20176
	private String records_per_trn_iss = "";
	private String records_per_trn_ret = "";
	private String uom = "";//Added for MMS-DM-CRF-0230 US002
	
  public String getRecords_per_trn_iss() {
		return records_per_trn_iss;
	}

	public void setRecords_per_trn_iss(String records_per_trn_iss) {
		this.records_per_trn_iss = records_per_trn_iss;
	}

	public String getRecords_per_trn_ret() {
		return records_per_trn_ret;
	}

	public void setRecords_per_trn_ret(String records_per_trn_ret) {
		this.records_per_trn_ret = records_per_trn_ret;
	}

public String getRecords_per_trn_urg() {
		return records_per_trn_urg;
	}

	public void setRecords_per_trn_urg(String records_per_trn_urg) {
		this.records_per_trn_urg = records_per_trn_urg;
	}//MO-CRF-20176 END  

//Added for  IN:071344  start
  public String getConsm_freq_days() {
		return consm_freq_days;
	}

	public void setConsm_freq_days(String consm_freq_days) {
		this.consm_freq_days = consm_freq_days;
	}

	
	public String getChk_auto_rol_yn() {
		return chk_auto_rol_yn;
	}

	public void setChk_auto_rol_yn(String chk_auto_rol_yn) {
		this.chk_auto_rol_yn = chk_auto_rol_yn;
	}
	//Added for  IN:071344  end
	public void setStoreTypeFlag (String p_store_type_flag) {
		this.storeTypeFlag = p_store_type_flag; 
	}

	public String getStoreTypeFlag() {
		return this.storeTypeFlag;
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

	public void setMedical_item_yn(String medical_item_yn) {
		 this.medical_item_yn = checkForNull(medical_item_yn,"N");
	}

	public void setNonmedical_item_yn(String nonmedical_item_yn) {
		 this.nonmedical_item_yn = checkForNull(nonmedical_item_yn,"N");
	}
	public void setStore_type_flag(String store_type_flag) {
		 this.store_type_flag = store_type_flag;
	}
	public void setReorder_freq_days(String reorder_freq_days) {
		 this.reorder_freq_days = checkForNull(reorder_freq_days,"");
	}
	public void setParent_store_code(String parent_store_code) {
		 this.parent_store_code= parent_store_code;
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

	public String getNonmedical_item_yn () {
		 return nonmedical_item_yn;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public void setStore_desc(String store_desc) {
		 this.store_desc= checkForNull(store_desc,"");
		
	}

	public void setDept_desc(String dept_desc) {
		 this.dept_desc = checkForNull(dept_desc,"");
	}

	public void setExternal_yn(String external_yn) {
		 this.external_yn= checkForNull(external_yn,"N");
	}
	//code added for authorize special request...
	public void setAuthorizeSpecialRequest(String authorizespecialreq_yn){
		this.authorizespecialreq_yn = checkForNull(authorizespecialreq_yn,"N");
	}

	public void setStcons_allowed_yn(String stockitemcons_yn){
		this.stock_item_cons_yn = checkForNull(stockitemcons_yn,"N");
	}

	public void setAlertforPrint_yn(String alert_for_print_yn ){
		this.alert_for_print_yn  = checkForNull(alert_for_print_yn ,"N");
	}
// @ --- 

	public void setOp_sale_appl_yn(String op_sale_appl_yn ){
		this.op_sale_appl_yn  = checkForNull(op_sale_appl_yn ,"N");
	}
	
	public void setIp_sale_appl_yn(String ip_sale_appl_yn ){
		this.ip_sale_appl_yn  = checkForNull(ip_sale_appl_yn ,"N");
	}
	
	public void setRef_sale_appl_yn(String ref_sale_appl_yn ){
		this.ref_sale_appl_yn  = checkForNull(ref_sale_appl_yn ,"N");
	}

	public void setPRQ_allowed_yn(String prq_allowed_yn) {
		 this.prq_allowed_yn = checkForNull(prq_allowed_yn,"N");
	}

	public String getOp_sale_appl_yn(){
		return op_sale_appl_yn;
	}

	public String getIp_sale_appl_yn(){
		return ip_sale_appl_yn;
	}

	public String getRef_sale_appl_yn(){
		return ref_sale_appl_yn;
	}
  public void setDc_sale_appl_yn(String dc_sale_appl_yn ){
		this.dc_sale_appl_yn  = dc_sale_appl_yn;
	}

 public void setEm_sale_appl_yn(String em_sale_appl_yn ){
		this.em_sale_appl_yn  = em_sale_appl_yn;
	}

	public void setDirect_sale_appl_yn(String direct_sale_appl_yn ){
		this.direct_sale_appl_yn  = direct_sale_appl_yn;
	}

	public String getDc_sale_appl_yn(){
		return dc_sale_appl_yn;
	}

	public String getEm_sale_appl_yn(){
		return em_sale_appl_yn;
	}

	public String getDirect_sale_appl_yn(){
		return direct_sale_appl_yn;
	}

	public String getAuthorizeSpecialRequest(){
		return authorizespecialreq_yn;
	}
	public void setBin_loc_code	(String bin_loc_code	) {
		 this.bin_loc_code	 =checkForNull(bin_loc_code,"")	;
	}

	public void setBin_loc_desc(String bin_loc_desc) {
		 this.bin_loc_desc= checkForNull(bin_loc_desc,"");
		
	}

	public String getBin_loc_code( ) {
		 return bin_loc_code;
	}
	public String getBin_loc_desc( ) {
		 return bin_loc_desc;
	}
	public String getStore_code( ) {
		 return store_code;
	}

	public void setChk_stk_lvl_for_pur_yn(String chk_stk_lvl_for_pur_yn) {
		 this.chk_stk_lvl_for_pur_yn= checkForNull(chk_stk_lvl_for_pur_yn,"N");
	}

	public String getMedical_item_yn( ) {
		 return medical_item_yn;
	}

	public String getReorder_freq_days( ) {
		 return reorder_freq_days;
	}

	public String getChk_stk_lvl_for_pur_yn() {
		 return chk_stk_lvl_for_pur_yn;
	}

	public String getGrn_allowed_yn( ) {
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
		public String getStcons_allowed_yn( ) {
		 return stock_item_cons_yn;
	}

		public String getDept_desc( ) {
		 return dept_desc;
	}

		public String getStore_desc( ) {
		return store_desc;
	}

		public String getExternal_yn( ) {
		 return external_yn;
	}
		public String getPRQ_allowed_yn( ) {
		 return prq_allowed_yn;
	}

	public String getCndmn_exp_btch_allowed_yn( ) {
		 return cndmn_exp_btch_allowed_yn;
	}

	//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 13-AUG-2013  Starts
	public void setIss_Ack_Yn(String iss_ack_yn) {
		 this.iss_ack_yn = checkForNull(iss_ack_yn,"N");
	}
	public void setUrg_Iss_Ack_Yn(String urg_iss_ack_yn) {
		 this.urg_iss_ack_yn = checkForNull(urg_iss_ack_yn,"N");
	}
	
	public void setIss_Ret_Ack_Yn(String iss_ret_ack_yn) {
		 this.iss_ret_ack_yn = checkForNull(iss_ret_ack_yn,"N");
	}
	public void setTfr_Ack_Yn(String tfr_ack_yn) {
		 this.tfr_ack_yn = checkForNull(tfr_ack_yn,"N");
	}

	public String getIss_Ack_Yn(){
		return iss_ack_yn;
	}
	public String getUrg_Iss_Ack_Yn(){
		return urg_iss_ack_yn;
	}
	public String getIss_Ret_Ack_Yn(){
		return iss_ret_ack_yn;
	}
	public String getTfr_Ack_Yn(){
		return tfr_ack_yn;
	}
	
	//ends
	
	public String getStore_type_List()
	{
		return getStaticListOptionTag( "M,Main;S,Sub Store;P,Pharmacy;N, Non-Stock Store;", getStore_type_flag());
	}

	public String getStore_type_List(boolean bValue)
	{
		if (bValue)
			return getStaticListOptionTag( "M,Main;S,Sub Store;P,Pharmacy;", getStore_type_flag());
		else 
			return getStaticListOptionTag( "M,Main;S,Sub Store;P,Pharmacy;N,Non-Stock Store;", getStore_type_flag());
	}

	public String getStore_type_flag()
	{
		return store_type_flag;
	}

	public String getParent_store_code_List()
	{
		ArrayList arr_lang=new ArrayList();
		arr_lang.add(getStore_code());
		arr_lang.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getStRepositoryValue("SQL_ST_PARENT_STORE_SELECT_LIST"), arr_lang),getParent_store_code());
	}
	public String getParent_store_code()
	{
		return parent_store_code;
	}

	public String  getAlertforPrint_yn(){
		return alert_for_print_yn ;
	}


	public String getCheckCount() {
		 return checkCount;
	}

	public void setCheckCount(String checkCount) {
		 this.checkCount = checkCount;
	}
	//Added for IN:072963 start	
	public String getAutoAssocIntfItemsYN() {
		return auto_assoc_intf_items_yn;
	}

	public void setAutoAssocIntfItemsYN(String auto_assoc_intf_items_yn) {
		this.auto_assoc_intf_items_yn = auto_assoc_intf_items_yn;
	}
//Added for IN:072963 end
    //Added for MMS-DM-CRF-0230 US002 start
        public void setUom(String uom) {
                if (uom == null) {
                        this.uom = "";
                } else {
                        this.uom = uom;
                }
        }
        public String getUom() {
                if (uom == null) {
                        return "";
                }
                return uom;
        }
        //Added for MMS-DM-CRF-0230 US002 end
/*
	public String getStore_code_List(){
		return getListOptionTag( getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_MM_STORE_SELECT_LIST"),getLoginFacilityId()), getStore_code());
	}
*/

	public HashMap insert() {

		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;
		ArrayList	LanguageData	=	new ArrayList()	;

		hmResult.put( "result", new Boolean( false ) ) ;

		alInsertData.add(store_code  		);
		alInsertData.add(store_type_flag       	);
		alInsertData.add(medical_item_yn);
		alInsertData.add(nonmedical_item_yn);
		alInsertData.add(reorder_freq_days);
		alInsertData.add(chk_stk_lvl_for_pur_yn);
		alInsertData.add(grn_allowed_yn);
		alInsertData.add(rtv_allowed_yn);
		alInsertData.add(mfg_allowed_yn 	);
		alInsertData.add(req_allowed_yn 	);
		alInsertData.add(iss_allowed_yn 	);
		alInsertData.add(urg_allowed_yn 	);
		alInsertData.add(ret_allowed_yn 	);
		alInsertData.add(tfr_allowed_yn 	);
		alInsertData.add(adj_allowed_yn 	);
		alInsertData.add(var_allowed_yn 	);
		alInsertData.add(prt_allowed_yn 	);
		alInsertData.add(sal_allowed_yn 	);
		alInsertData.add(srt_allowed_yn 	);
		alInsertData.add(split_batch_allowed_yn 	);
		alInsertData.add(bin_change_allowed_yn 	);
		alInsertData.add(parent_store_code  		);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		alInsertData.add(login_by_id		);
		alInsertData.add(login_at_ws_no		);
		alInsertData.add(login_facility_id	);
		alInsertData.add(obs_allowed_yn 	);
		alInsertData.add(authorizespecialreq_yn);
		alInsertData.add(stock_item_cons_yn);
        alInsertData.add(alert_for_print_yn);
        alInsertData.add(op_sale_appl_yn);
        alInsertData.add(ip_sale_appl_yn);
        alInsertData.add(ref_sale_appl_yn);
        alInsertData.add(dc_sale_appl_yn);
        alInsertData.add(em_sale_appl_yn);
        alInsertData.add(direct_sale_appl_yn);
		alInsertData.add(prq_allowed_yn);
		alInsertData.add(bin_loc_code);
		alInsertData.add(getCndmn_exp_btch_allowed_yn());
		//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 16-AUG-2013 Starts
		alInsertData.add(checkForNull(iss_ack_yn));
		alInsertData.add(checkForNull(urg_iss_ack_yn));
		alInsertData.add(checkForNull(iss_ret_ack_yn));
		alInsertData.add(checkForNull(tfr_ack_yn));
		alInsertData.add(checkForNull(getAuth_allowed_yn()));//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		alInsertData.add(checkForNull(getChk_auto_rol_yn()));// //Added for  IN:071344 
		alInsertData.add(checkForNull(getConsm_freq_days()));//Added for  IN:071344 
		alInsertData.add(auto_assoc_intf_items_yn);//Added for IN:072963
		alInsertData.add(checkForNull(getRecords_per_trn_urg()));//MO-CRF-20176
		alInsertData.add(checkForNull(getRecords_per_trn_iss())); 
		alInsertData.add(checkForNull(getRecords_per_trn_ret()));   //END  
		alInsertData.add(uom);//Added for MMS-DM-CRF-0230 US002

	LanguageData.add(getLanguageId());

		hmSQLMap.put( "InsertSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_INSERT")	);
		hmSQLMap.put( "SelectSQL", eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_COUNT")	);

		alWhereData.add(	store_code	);

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
		hmTableData.put( "LanguageData",			LanguageData	);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT );
	}

	public HashMap modify() {


		HashMap		hmResult	=	new HashMap()	;
		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
			ArrayList	LanguageData	=	new ArrayList()	;

		hmResult.put( "result", new Boolean( false ) ) ;

		alModifyData.add(store_type_flag			);
		alModifyData.add(medical_item_yn			);
		alModifyData.add(nonmedical_item_yn		);
		alModifyData.add(reorder_freq_days		);
		alModifyData.add(chk_stk_lvl_for_pur_yn		);
		alModifyData.add(grn_allowed_yn		);
		alModifyData.add(rtv_allowed_yn		);
		alModifyData.add(mfg_allowed_yn		);
		alModifyData.add(req_allowed_yn		);
		alModifyData.add(iss_allowed_yn		);
		alModifyData.add(urg_allowed_yn		);
		alModifyData.add(ret_allowed_yn		);
		alModifyData.add(tfr_allowed_yn		);
		alModifyData.add(adj_allowed_yn		);
		alModifyData.add(var_allowed_yn		);
		alModifyData.add(prt_allowed_yn		);
		alModifyData.add(sal_allowed_yn		);
		alModifyData.add(srt_allowed_yn		);
		alModifyData.add(split_batch_allowed_yn		);
		alModifyData.add(bin_change_allowed_yn		);
		alModifyData.add(obs_allowed_yn		);
		alModifyData.add(parent_store_code);
		alModifyData.add(login_by_id		);
		alModifyData.add(login_at_ws_no		);
		alModifyData.add(login_facility_id	);
		alModifyData.add(authorizespecialreq_yn);
		alModifyData.add(stock_item_cons_yn);
        alModifyData.add(alert_for_print_yn);
        alModifyData.add(op_sale_appl_yn);
        alModifyData.add(ip_sale_appl_yn);
        alModifyData.add(ref_sale_appl_yn);
        alModifyData.add(dc_sale_appl_yn);
        alModifyData.add(em_sale_appl_yn);
        alModifyData.add(direct_sale_appl_yn);
		alModifyData.add(prq_allowed_yn		);
		alModifyData.add(bin_loc_code		);
		alModifyData.add(getCndmn_exp_btch_allowed_yn());
		//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 16-AUG-2013 Starts
		alModifyData.add(checkForNull(iss_ack_yn));
		alModifyData.add(checkForNull(urg_iss_ack_yn));
		alModifyData.add(checkForNull(iss_ret_ack_yn));
		alModifyData.add(checkForNull(tfr_ack_yn));
		alModifyData.add(checkForNull(getAuth_allowed_yn()));//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		alModifyData.add(checkForNull(getChk_auto_rol_yn()));//Added for  IN:071344 
		alModifyData.add(checkForNull(getConsm_freq_days()));//Added for  IN:071344 
		alModifyData.add(auto_assoc_intf_items_yn);//Added for IN:072963
		alModifyData.add(checkForNull(getRecords_per_trn_urg()));  //MO-CRF-20176 
		alModifyData.add(checkForNull(getRecords_per_trn_iss())); 
		alModifyData.add(checkForNull(getRecords_per_trn_ret()));//END   
		alModifyData.add(uom); // Added for MMS-DM-CRF-0230 US002
		
		alModifyData.add(store_code);
     	LanguageData.add(getLanguageId());
		hmSQLMap.put( "ModifySQL", eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_UPDATE"));
		
		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);
		hmTableData.put( "LanguageData",			LanguageData	);
  

  
		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public void clear() {
		store_code				=	""; 
		store_type_flag			=	"";
		medical_item_yn			=	"N";	
		nonmedical_item_yn		=	"N";	
		reorder_freq_days		=	"";	
		chk_stk_lvl_for_pur_yn	=	"N";	
		grn_allowed_yn			=	"N";	
		rtv_allowed_yn			=	"N";	
		mfg_allowed_yn			=	"N";	
		req_allowed_yn			=	"N";	
		iss_allowed_yn			=	"N";	
		urg_allowed_yn			=	"N";	
		ret_allowed_yn			=	"N";	
		tfr_allowed_yn			=	"N";	
		adj_allowed_yn			=	"N";	
		var_allowed_yn			=	"N";	
		prt_allowed_yn			=	"N";	
		sal_allowed_yn			=	"N";	
		srt_allowed_yn			=	"N";	
		split_batch_allowed_yn	=	"N";	
		bin_change_allowed_yn	=	"N";	
		obs_allowed_yn			=	"N";	
		store_desc				=	"";	
		dept_desc				=	"";	
		external_yn				=	"N";
		storeTypeFlag			=	"Y";
		authorizespecialreq_yn  =	"N";
		stock_item_cons_yn		=	"N";
		prq_allowed_yn			=	"N";
		bin_loc_code			=	"";
		bin_loc_desc			=	"";
		cndmn_exp_btch_allowed_yn			=	"";
		//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 16-AUG-2013 Starts
		iss_ack_yn     = "N";
		urg_iss_ack_yn = "N";
		iss_ret_ack_yn = "N";
		tfr_ack_yn     = "N";
		auth_allowed_yn = "N";//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
		chk_auto_rol_yn = "N";//Added for  IN:071344 
		consm_freq_days = "";//Added for  IN:071344 
		auto_assoc_intf_items_yn = "N";//Added for IN:072963
		records_per_trn_iss ="";//MO-CRF-20176
		records_per_trn_ret = "";
		records_per_trn_urg = "";//END   
		uom = ""; // Added for MMS-DM-CRF-0230 US002
	}

	public void setAll(Hashtable htRecordSet){
		try {
			super.setAll(htRecordSet);
        
			setStore_code((String) htRecordSet.get("store_code"));
			setStore_type_flag((String) htRecordSet.get("store_type_flag"));
			setMedical_item_yn((String) htRecordSet.get("medical_item_yn"));
			setNonmedical_item_yn((String) htRecordSet.get("nonmedical_item_yn"));
			setReorder_freq_days((String) htRecordSet.get("reorder_freq_days"));
			setChk_stk_lvl_for_pur_yn((String) htRecordSet.get("chk_stk_lvl_for_pur_yn"));
			setGrn_allowed_yn((String) htRecordSet.get("grn_allowed_yn"));
			setRtv_allowed_yn((String) htRecordSet.get("rtv_allowed_yn"));
			setMfg_allowed_yn((String) htRecordSet.get("mfg_allowed_yn"));
			setReq_allowed_yn((String) htRecordSet.get("req_allowed_yn"));
			setIss_allowed_yn((String) htRecordSet.get("iss_allowed_yn"));
			setUrg_allowed_yn((String) htRecordSet.get("urg_allowed_yn"));
			setRet_allowed_yn((String) htRecordSet.get("ret_allowed_yn"));
			setTfr_allowed_yn((String) htRecordSet.get("tfr_allowed_yn"));
			setAdj_allowed_yn((String) htRecordSet.get("adj_allowed_yn"));
			setVar_allowed_yn((String) htRecordSet.get("var_allowed_yn"));
			setPrt_allowed_yn((String) htRecordSet.get("prt_allowed_yn"));
			setSal_allowed_yn((String) htRecordSet.get("sal_allowed_yn"));
			setSrt_allowed_yn((String) htRecordSet.get("srt_allowed_yn"));
			setSplit_batch_allowed_yn((String) htRecordSet.get("split_batch_allowed_yn"));
			setBin_change_allowed_yn((String) htRecordSet.get("bin_change_allowed_yn"));
			setParent_store_code((String) htRecordSet.get("parent_store_code"));
			setObs_allowed_yn((String) htRecordSet.get("obs_allowed_yn"));
			setStore_desc((String) htRecordSet.get("store_desc"));
			setDept_desc((String) htRecordSet.get("dept_desc"));
			setExternal_yn((String) htRecordSet.get("external_yn"));
			//code added for Authorize special request....
			setAuthorizeSpecialRequest((String) htRecordSet.get("authorize_spl_req_yn"));
			setStcons_allowed_yn((String) htRecordSet.get("stock_item_cons_yn"));
            setAlertforPrint_yn((String) htRecordSet.get("alert_pickslip_yn"));
			setOp_sale_appl_yn(checkForNull((String) htRecordSet.get("Outpatient_sale_applicable_yn"),"N") );
			setIp_sale_appl_yn(checkForNull((String) htRecordSet.get("Inpatient_sale_applicable_yn"),"N") );
			setRef_sale_appl_yn(checkForNull((String) htRecordSet.get("Ref_sale_applicable_yn"),"N") );
			setDc_sale_appl_yn(checkForNull((String) htRecordSet.get("dc_sale_applicable_yn"),"N") );
			setEm_sale_appl_yn(checkForNull((String) htRecordSet.get("em_sale_applicable_yn"),"N") );
			setDirect_sale_appl_yn(checkForNull((String) htRecordSet.get("direct_sale_applicable_yn"),"N") );
			setPRQ_allowed_yn((String) htRecordSet.get("prq_allowed_yn"));
			setBin_loc_desc(checkForNull((String) htRecordSet.get("bin_loc_desc"),""));
			setBin_loc_code(checkForNull((String) htRecordSet.get("bin_loc_code"),""));
			setCndmn_exp_btch_allowed_yn(checkForNull((String) htRecordSet.get("cndmn_exp_btch_allowed_yn"),"N"));
			//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 16-AUG-2013 Starts
			setIss_Ack_Yn(checkForNull((String) htRecordSet.get("iss_ack_yn"),"N"));
			setUrg_Iss_Ack_Yn(checkForNull((String) htRecordSet.get("urg_iss_ack_yn"),"N"));
			setIss_Ret_Ack_Yn(checkForNull((String) htRecordSet.get("iss_ret_ack_yn"),"N"));
			setTfr_Ack_Yn(checkForNull((String) htRecordSet.get("tfr_ack_yn"),"N"));
			setAuth_allowed_yn(checkForNull((String) htRecordSet.get("auth_allowed_yn"),"N"));//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
			setChk_auto_rol_yn(checkForNull((String) htRecordSet.get("chk_auto_rol_yn"),"N"));//Added for  IN:071344 
			setConsm_freq_days(checkForNull((String) htRecordSet.get("consm_freq_days"),""));//Added for  IN:071344 
		    setAutoAssocIntfItemsYN(checkForNull((String) htRecordSet.get("auto_associate_intf_items_yn"),"N"));//Added for IN:072963
		    setRecords_per_trn_iss(checkForNull((String) htRecordSet.get("records_per_trn_iss"),""));//MO-CRF-20176
		    setRecords_per_trn_urg(checkForNull((String) htRecordSet.get("records_per_trn_urg"),""));
		    setRecords_per_trn_ret(checkForNull((String) htRecordSet.get("records_per_trn_ret"),""));//END 
			setUom((String)htRecordSet.get("uom1"));//Added for MMS-DM-CRF-0230 US002
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
		
		try {
			String []stParameters		=	{getStore_code(),login_facility_id,getLanguageId()};
			HashMap hmRecord	=	null;
			hmRecord	=	fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_SELECT_SINGLE"), stParameters);
			

			setStore_type_flag		  ( (String)hmRecord.get("STORE_TYPE_FLAG" )		) ;
			setMedical_item_yn ( (String)hmRecord.get("MEDICAL_ITEM_YN" )	) ;
			setNonmedical_item_yn ( (String)hmRecord.get("NONMEDICAL_ITEM_YN" )	) ;
			setReorder_freq_days ( (String)hmRecord.get("REORDER_FREQ_DAYS" )	) ;
			setChk_stk_lvl_for_pur_yn ( (String)hmRecord.get("CHK_STK_LVL_FOR_PUR_YN" )	) ;
			setGrn_allowed_yn ( (String)hmRecord.get("GRN_ALLOWED_YN" )	) ;
			setRtv_allowed_yn ( (String)hmRecord.get("RTV_ALLOWED_YN" )	) ;
			setMfg_allowed_yn ( (String)hmRecord.get("MFG_ALLOWED_YN" )	) ;
			setReq_allowed_yn ( (String)hmRecord.get("REQ_ALLOWED_YN" )	) ;
			setIss_allowed_yn ( (String)hmRecord.get("ISS_ALLOWED_YN" )	) ;
			setUrg_allowed_yn ( (String)hmRecord.get("URG_ALLOWED_YN" )	) ;
			setRet_allowed_yn ( (String)hmRecord.get("RET_ALLOWED_YN" )	) ;
			setTfr_allowed_yn ( (String)hmRecord.get("TFR_ALLOWED_YN" )	) ;
			setAdj_allowed_yn ( (String)hmRecord.get("ADJ_ALLOWED_YN" )	) ;
			setVar_allowed_yn ( (String)hmRecord.get("VAR_ALLOWED_YN" )	) ;
			setPrt_allowed_yn ( (String)hmRecord.get("PRT_ALLOWED_YN" )	) ;
			setSal_allowed_yn ( (String)hmRecord.get("SAL_ALLOWED_YN" )	) ;
			setSrt_allowed_yn ( (String)hmRecord.get("SRT_ALLOWED_YN" )	) ;
			setSplit_batch_allowed_yn( (String)hmRecord.get("SPLIT_BATCH_ALLOWED_YN" )	) ;
			setBin_change_allowed_yn( (String)hmRecord.get("BIN_CHANGE_ALLOWED_YN" )	) ;
			setParent_store_code( (String)hmRecord.get("PARENT_STORE_CODE" )	) ;
			setObs_allowed_yn( (String)hmRecord.get("OBS_ALLOWED_YN" )	) ;
			setStore_desc( (String)hmRecord.get("STORE_DESC" )	) ;
			setDept_desc( (String)hmRecord.get("DEPT_DESC" )	) ;
			setExternal_yn( (String)hmRecord.get("EXTERNAL_YN" )	) ;
			setAuthorizeSpecialRequest((String)hmRecord.get("AUTHORIZE_SPECIAL_REQ_YN") );
			setStcons_allowed_yn((String)hmRecord.get("STK_ITEM_CON_ALLOWED_YN") );
			setAlertforPrint_yn((String)hmRecord.get("ALERT_FOR_PRINT_PICKSLIP_YN") );
			setOp_sale_appl_yn((String)hmRecord.get("OP_SALE_APPL_YN") );
			setIp_sale_appl_yn((String)hmRecord.get("IP_SALE_APPL_YN") );
			setRef_sale_appl_yn((String)hmRecord.get("REF_SALE_APPL_YN") );
			setDc_sale_appl_yn(checkForNull((String) hmRecord.get("DC_SALE_APPL_YN"),"N") );
			setEm_sale_appl_yn(checkForNull((String) hmRecord.get("EM_SALE_APPL_YN"),"N") );
			setDirect_sale_appl_yn(checkForNull((String) hmRecord.get("DIRECT_SALE_APPL_YN"),"N") );
			setPRQ_allowed_yn ( (String)hmRecord.get("PRQ_ALLOWED_YN" )	) ;
			setBin_loc_code(checkForNull((String) hmRecord.get("BIN_LOC_CODE"),""));
			setCndmn_exp_btch_allowed_yn(checkForNull((String) hmRecord.get("CNDMN_EXP_BTCH_ALLOWED_YN"),"N"));
			//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 16-AUG-2013 Starts
			setIss_Ack_Yn(checkForNull((String) hmRecord.get("ISS_ACK_REQ_YN"),"N"));
			setUrg_Iss_Ack_Yn(checkForNull((String) hmRecord.get("URG_ACK_REQ_YN"),"N"));
			setIss_Ret_Ack_Yn(checkForNull((String) hmRecord.get("RET_ACK_REQ_YN"),"N"));
			setTfr_Ack_Yn(checkForNull((String) hmRecord.get("TFR_ACK_REQ_YN"),"N"));
			setAuth_allowed_yn(checkForNull((String) hmRecord.get("AUTHORIZE_AT_ISSUE_ALLOWED_YN"),"N"));//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001
			setChk_auto_rol_yn(checkForNull((String) hmRecord.get("AUTO_ROL_CALC_FLAG"),"N"));//Added for  IN:071344 
			setConsm_freq_days ( checkForNull((String)hmRecord.get("CONS_PERIOD" ),"")) ;//Added for  IN:071344 
			setAutoAssocIntfItemsYN(checkForNull((String) hmRecord.get("ASSOC_INTF_ITEMS_TO_STORE_YN"),"N"));//Added for IN:072963
			setRecords_per_trn_urg(checkForNull((String)hmRecord.get("RECORDS_PER_TRN_URG" ),""));//MO-CRF-20176
			setRecords_per_trn_iss(checkForNull((String)hmRecord.get("RECORDS_PER_TRN_ISS" ),""));
			setRecords_per_trn_ret(checkForNull((String)hmRecord.get("RECORDS_PER_TRN_RET"),""));//END   
			setUom((String) hmRecord.get("UOM_FOR_PHIS_INTERFACE")); // Added for MMS-DM-CRF-0230 US002
			
			// Added for MMS-DM-CRF-0230 US002 end
			String [] alParameter	=	{checkForNull((String) hmRecord.get("BIN_LOC_CODE"),""),getLanguageId(),getStore_code()};
			
			hmRecord=fetchRecord("  select short_desc BIN_LOC_DESC from MM_BIN_LOCATION_lang_vw   where bin_location_code=?  and language_id=? and store_code=?", alParameter);
			setBin_loc_desc(checkForNull((String) hmRecord.get("BIN_LOC_DESC"),""));

		

			hmRecord	=	fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_QTY_ON_HAND"), getStore_code());


			if(hmRecord.get("QTY_ON_HAND") != null) {
				try {
					int totalQTY = Integer.parseInt((String)hmRecord.get("QTY_ON_HAND"));
					if(totalQTY > 0) {
						setStoreTypeFlag("N");					
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		} 
		catch ( Exception exception )	{
			exception.printStackTrace() ;
			throw exception ;
		} 
	}

	public java.util.ArrayList getParentStores(String store_code) {

        ArrayList parentStores = new ArrayList();
        java.sql.Connection connection = null;
        java.sql.PreparedStatement  pstmt = null;
        java.sql.ResultSet  resultSet = null;
        try {
            connection = getConnection();
            pstmt = connection.prepareStatement(eST.Common.StRepository.getStKeyValue("SQL_ST_PARENT_STORE_SELECT_LIST"));
            pstmt.setString(1, store_code);
            pstmt.setString(2, getLanguageId());
            resultSet = pstmt.executeQuery();
            while (resultSet != null && resultSet.next()) {
                String[] record = new String[2];
                record[0] = resultSet.getString(1);
                record[1] = resultSet.getString(2);
                parentStores.add(record);
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
		return parentStores;
	}

	public boolean isStoreDisabled() throws Exception{
		HashMap hmResult	=	null;
		hmResult = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_MM_STORE_SELECT_STATUS"),getStore_code());
		return ((String)hmResult.get("EFF_STATUS")).equals("D");
	}

	public boolean inventoryModuleScope() throws Exception{
/*		HashMap hmResult	=	null;
		hmResult = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_MM_INSTALLATION_PARAMETER_SELECT"));
		return ((String)hmResult.get("INVENTORY_MODULE_SCOPE")).equals("P");*/
		return new eMM.MM_license_rights().getSTboundary().equals("I");

	}

	public String toString(){
	return "mode:"+mode;
	}

	public boolean Store_type() throws Exception{
			ArrayList alParameter	=	new ArrayList(2);
			alParameter.add(getStore_code());

			HashMap hmRecord1 =	fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_TYPE_VALIDATE"), alParameter);
			if(((String)hmRecord1.get("QTY_ON_HAND" ))=="0")
				return true;	
			else
				return false;
	}

	public HashMap validate(){
        HashMap hashmap = new HashMap();
		hashmap.put("result", new Boolean(true));
		hashmap.put("message", "success");

		try{
			fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_MM_STORE_SELECT_STATUS"), this.store_code);
		}
		catch(Exception e)
		{
		    hashmap.put("msgid","INVALID_STORE_CODE");
			hashmap.put("result", new Boolean(false));
		}
        return hashmap;
    }


	public String getInterface_to_external_po_yn(String acc_entity_id) throws Exception {
	
	//HashMap result = fetchRecord("select INTERFACE_TO_EXTERNAL_PO_YN from st_acc_entity_param where acc_entity_id=?",acc_entity_id);
	HashMap result = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_ACC_ENTITY_PARAM_SELECT1"),acc_entity_id);
	String result_yn = checkForNull((String)result.get("INTERFACE_TO_EXTERNAL_PO_YN"),"N");
	return result_yn;
	}
	//Added by Rabbani #Bru-HIMS-CRF-112(INC no:30071) on 16-AUG-2013  
	public Boolean getRecordCountForIssue() {
		String []stParameters=	{getLoginFacilityId(),getStore_code()};
	 
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_ISSUE_HDR WHERE FINALIZED_YN = 'N' AND PROCESS_FOR_ACKNOWLEDGE = 'Y' AND FACILITY_ID = ? AND TO_STORE_CODE = ?", stParameters);
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
	String []stParameters=	{getLoginFacilityId(),getStore_code()};
	 
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_ISSUE_RET_HDR WHERE FINALIZED_YN = 'N' AND PROCESS_FOR_ACKNOWLEDGE = 'Y' AND FACILITY_ID = ? AND  TO_STORE_CODE = ?", stParameters);
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
	String []stParameters=	{getLoginFacilityId(),getStore_code()};
	 
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_TRANSFER_HDR WHERE FINALIZED_YN = 'N' AND PROCESS_FOR_ACKNOWLEDGE = 'Y' AND FACILITY_ID = ? AND TO_STORE_CODE = ?", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}
		if(!((String)hmRecord.get("COUNT")).equals("0"))
			return true;
		else
			return false;
	}
//MO-CRF-20176  
public Boolean getRecordCountForTransactionTables(String storeCode) {
	
	String []stParameters=	{storeCode,getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM ST_REQUEST_HDR WHERE REQ_ON_STORE_CODE = ? AND req_authorized_by_id IS NULL  AND FACILITY_ID = ? ", stParameters);
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}
		if(!((String)hmRecord.get("COUNT")).equals("0"))
			return true;
		else
			return false;
	}
	public HashMap getAckReqdyn(){
        HashMap hashmap = new HashMap();
		try{
			hashmap = fetchRecord("SELECT ISS_ACK_REQ_YN,RET_ACK_REQ_YN,TFR_ACK_REQ_YN FROM ST_FACILITY_PARAM WHERE FACILITY_ID = ?", getLoginFacilityId());
		}catch(Exception e){
			e.printStackTrace();
			 
		}
        return hashmap;
    }
	//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 starts
	public String getAuth_allowed_yn() {
		return auth_allowed_yn;
	}
	public void setAuth_allowed_yn(String auth_allowed_yn) {
		this.auth_allowed_yn =checkForNull(auth_allowed_yn,"N");
	}
	public String getAllow_Auth_Issue_store() throws Exception {
		HashMap result = fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_FACILITY_PARAM_SELECT_AUTH_ISS_STORE"),getLoginFacilityId());
		String result_yn = checkForNull((String)result.get("ALLOW_AUTHORIZE_AT_ISSUE_STORE"),"N");
		return result_yn;
	}
	//Added by B.Badmavathi on 21/04/2016 against PMG2015-CRF-INT-ST-0001 ends
}
