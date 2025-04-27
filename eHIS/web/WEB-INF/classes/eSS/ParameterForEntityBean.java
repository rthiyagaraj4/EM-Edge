/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eSS ;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.HashMap;
import java.util.Properties;
import eSS.Common.*;
import eCommon.SingleTableHandler.*;

public class ParameterForEntityBean extends SsAdapter implements Serializable { 

	private String acc_entity_id;
	private String item_image_path;
	private String def_blng_serv_code;
	private String def_rof_doc_type_code;
	private String def_req_doc_type_code;
	private String def_rtg_doc_type_code;
	private String def_pre_doc_type_code;
	private String curr_proc_year;
	private String def_var_doc_type_code;
	private String def_iss_doc_type_code;
	private String bl_interface_yn;
	private String current_phy_inv_id;
	private String curr_proc_month;
	private String def_trd_doc_type_code;
	private String def_adj_doc_type_code;
	private String gl_interface_yn;
	private String def_rti_doc_type_code;
	private String def_write_off_reason_code;
	private String gen_rof_at_pre_yn;
	private String dflt_sterile_life;
//32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
	private String def_rql_doc_type_code;
	private String def_isl_doc_type_code;
	private String def_rtl_doc_type_code;
	//ended
//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
	private String def_rqv_doc_type_code;
	private String def_rtv_doc_type_code;
//Added ends
	public void setDflt_sterile_life(String dflt_sterile_life) {
		 this.dflt_sterile_life = checkForNull( dflt_sterile_life);
	}

	public String getDflt_sterile_life( ) {
		 return dflt_sterile_life;
	}

	public void setItem_image_path(String item_image_path) {
		 this.item_image_path = item_image_path;
	}

	public String getItem_image_path( ) {
		
		 return item_image_path;
	}

	public void setAcc_entity_id(String acc_entity_id) {
		 this.acc_entity_id = acc_entity_id;
	}

	public String getAcc_entity_id( ) {
		
		 return acc_entity_id;
	}

	public void setDef_blng_serv_code(String def_blng_serv_code) {
		 this.def_blng_serv_code = def_blng_serv_code;
		 
	}

	public String getDef_blng_serv_code( ) {
		
		 return def_blng_serv_code;
	}

	public void setDef_rof_doc_type_code(String def_rof_doc_type_code) {
		 this.def_rof_doc_type_code = def_rof_doc_type_code;
	}

	public String getDef_rof_doc_type_code( ) {
    
		 return def_rof_doc_type_code;
	}

	public void setDef_req_doc_type_code(String def_req_doc_type_code) {
		 this.def_req_doc_type_code = def_req_doc_type_code;
	}

	public String getDef_req_doc_type_code( ) {
		 return def_req_doc_type_code;
	}

	public void setDef_rtg_doc_type_code(String def_rtg_doc_type_code) {
		 this.def_rtg_doc_type_code = def_rtg_doc_type_code;
	}

	public String getDef_rtg_doc_type_code( ) {
		 return def_rtg_doc_type_code;
	}

	public void setDef_pre_doc_type_code(String def_pre_doc_type_code) {
		 this.def_pre_doc_type_code = def_pre_doc_type_code;
	}

	public String getDef_pre_doc_type_code( ) {
		 return def_pre_doc_type_code;
	}

	public void setCurr_proc_year(String curr_proc_year) {
		 this.curr_proc_year = checkForNull(curr_proc_year);
	}

	public String getCurr_proc_year( ) {
		
		 return curr_proc_year;
	}

	public void setDef_var_doc_type_code(String def_var_doc_type_code) {
		 this.def_var_doc_type_code = def_var_doc_type_code;
	}

	public String getDef_var_doc_type_code( ) {
		 return def_var_doc_type_code;
	}

	public void setDef_iss_doc_type_code(String def_iss_doc_type_code) {
		 this.def_iss_doc_type_code = def_iss_doc_type_code;
	}

	public String getDef_iss_doc_type_code( ) {
		 return def_iss_doc_type_code;
	}

	public void setBl_interface_yn(String bl_interface_yn) {
		 this.bl_interface_yn = checkForNull(bl_interface_yn,"N");
	}

	public String getBl_interface_yn( ) {
		 return bl_interface_yn;
	}

	public void setGen_rof_at_pre_yn(String gen_rof_at_pre_yn) {
		 this.gen_rof_at_pre_yn = checkForNull(gen_rof_at_pre_yn,"N");
	}

	public String getGen_rof_at_pre_yn( ) {
		 return gen_rof_at_pre_yn;
	}

	public void setCurrent_phy_inv_id(String current_phy_inv_id) {
		 this.current_phy_inv_id = checkForNull(current_phy_inv_id,"N");
	}

	public String getCurrent_phy_inv_id( ) {
		 return current_phy_inv_id;
	}

	public void setCurr_proc_month(String curr_proc_month) {
		 this.curr_proc_month = checkForNull(curr_proc_month);
	}

	public String getCurr_proc_month( ) {
		
		 return curr_proc_month;
	}

	public void setDef_trd_doc_type_code(String def_trd_doc_type_code) {
		 this.def_trd_doc_type_code = def_trd_doc_type_code;
	}

	public String getDef_trd_doc_type_code( ) {
		 return def_trd_doc_type_code;
	}

	public void setDef_adj_doc_type_code(String def_adj_doc_type_code) {
		 this.def_adj_doc_type_code = def_adj_doc_type_code;
	}

	public String getDef_adj_doc_type_code( ) {
		 return def_adj_doc_type_code;
	}

	public void setGl_interface_yn(String gl_interface_yn) {
		 this.gl_interface_yn = checkForNull(gl_interface_yn,"N");
	}

	public String getGl_interface_yn( ) {
		 return gl_interface_yn;
	}

	public void setDef_rti_doc_type_code(String def_rti_doc_type_code) {
		 this.def_rti_doc_type_code = def_rti_doc_type_code;
	}

	public String getDef_rti_doc_type_code( ) {
		 return def_rti_doc_type_code;
	}

	public void setDef_write_off_reason_code(String def_write_off_reason_code) {
		 this.def_write_off_reason_code = def_write_off_reason_code;
	}

	public String getDef_write_off_reason_code( ) {
		
		 return def_write_off_reason_code;
	}
//Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
	public void setDef_rql_doc_type_code(String def_rql_doc_type_code) {
		 this.def_rql_doc_type_code = def_rql_doc_type_code;
	}
	public String getDef_rql_doc_type_code( ) {
		 return def_rql_doc_type_code;
	}

	public void setDef_isl_doc_type_code(String def_isl_doc_type_code) {
		 this.def_isl_doc_type_code = def_isl_doc_type_code;
	}
	public String getDef_isl_doc_type_code( ) {
		 return def_isl_doc_type_code;
	}

	public void setDef_rtl_doc_type_code(String def_rtl_doc_type_code) {
		 this.def_rtl_doc_type_code = def_rtl_doc_type_code;
	}
	public String getDef_rtl_doc_type_code( ) {
		 return def_rtl_doc_type_code;
	}
//ended
//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
	public void setDef_rqv_doc_type_code(String def_rqv_doc_type_code) {
		 this.def_rqv_doc_type_code = def_rqv_doc_type_code;
	}
	public String getDef_rqv_doc_type_code( ) {
		 return def_rqv_doc_type_code;
	}
	public void setDef_rtv_doc_type_code(String def_rtv_doc_type_code) {
		 this.def_rtv_doc_type_code = def_rtv_doc_type_code;
	}
	public String getDef_rtv_doc_type_code( ) {
		 return def_rtv_doc_type_code;
	}
//Added ends
	public void setAll(Hashtable htRecordSet){
		super.setAll(htRecordSet);
		setItem_image_path			(	(String) htRecordSet.get("item_image_path"));
		setDef_blng_serv_code		(	(String) htRecordSet.get("def_blng_serv_code"));
		setDef_rof_doc_type_code	(	(String) htRecordSet.get("def_rof_doc_type_code"));
		setDef_req_doc_type_code	(	(String) htRecordSet.get("def_req_doc_type_code"));
		setDef_rtg_doc_type_code	(	(String) htRecordSet.get("def_rtg_doc_type_code"));
		setDef_pre_doc_type_code	(	(String) htRecordSet.get("def_pre_doc_type_code"));
		setCurr_proc_year			(	checkForNull((String) htRecordSet.get("curr_proc_year")));
		setDef_var_doc_type_code	(	(String) htRecordSet.get("def_var_doc_type_code"));
		setDef_iss_doc_type_code	(	(String) htRecordSet.get("def_iss_doc_type_code"));
		setBl_interface_yn			(	(String) htRecordSet.get("bl_interface_yn"));
		setCurrent_phy_inv_id		(	(String) htRecordSet.get("current_phy_inv_id"));
		setCurr_proc_month			(	checkForNull((String) htRecordSet.get("curr_proc_month")));
		setDef_trd_doc_type_code	(	(String) htRecordSet.get("def_trd_doc_type_code"));
		setDef_adj_doc_type_code	(	(String) htRecordSet.get("def_adj_doc_type_code"));
		setGl_interface_yn			(	(String) htRecordSet.get("gl_interface_yn"));
		setDef_rti_doc_type_code	(	(String) htRecordSet.get("def_rti_doc_type_code"));
		setDef_write_off_reason_code(	(String) htRecordSet.get("def_write_off_reason_code"));
		setGen_rof_at_pre_yn(	(String) htRecordSet.get("gen_rof_at_pre_yn"));
		setDflt_sterile_life(	(String) htRecordSet.get("dflt_sterile_life"));
//Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		setDef_rql_doc_type_code(	checkForNull((String) htRecordSet.get("def_rql_doc_type_code")));
		setDef_isl_doc_type_code(	checkForNull((String) htRecordSet.get("def_isl_doc_type_code")));
		setDef_rtl_doc_type_code(	checkForNull((String) htRecordSet.get("def_rtl_doc_type_code")));
//ended
//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		setDef_rqv_doc_type_code(	checkForNull((String) htRecordSet.get("def_rqv_doc_type_code")));
		setDef_rtv_doc_type_code(	checkForNull((String) htRecordSet.get("def_rtv_doc_type_code")));
//Added ends
	}

	public HashMap insert() {

		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;

		alInsertData.add(getAcc_entity_id		  ());
		alInsertData.add(getCurr_proc_month       ());
		alInsertData.add(getCurr_proc_year        ());
		alInsertData.add(getBl_interface_yn       ());
		alInsertData.add(getGl_interface_yn       ());
		alInsertData.add(getDef_blng_serv_code    ());
		alInsertData.add(getDef_pre_doc_type_code ());
		alInsertData.add(getDef_req_doc_type_code ());
		alInsertData.add(getDef_iss_doc_type_code ());
		alInsertData.add(getDef_rtg_doc_type_code ());
		alInsertData.add(getDef_rti_doc_type_code ());
		alInsertData.add(getDef_trd_doc_type_code ());
		alInsertData.add(getDef_adj_doc_type_code ());
		alInsertData.add(getDef_var_doc_type_code ());
		alInsertData.add(getDef_rof_doc_type_code ());
		alInsertData.add(getItem_image_path       ());	
		alInsertData.add(getDef_write_off_reason_code       ());	
		alInsertData.add(getGen_rof_at_pre_yn       ());	
		alInsertData.add(getDflt_sterile_life       ());	

		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getDef_rql_doc_type_code   ());	//Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		alInsertData.add(getDef_isl_doc_type_code   ());	
		alInsertData.add(getDef_rtl_doc_type_code   ());	//ended

        alInsertData.add(getDef_rqv_doc_type_code	());	//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015 
		alInsertData.add(getDef_rtv_doc_type_code	());	//Added ends
		hmSQLMap.put( "InsertSQL", getSsRepositoryValue("SQL_SS_ACC_ENTITY_PARAM_INSERT")		);
		hmSQLMap.put( "SelectSQL", getSsRepositoryValue("SQL_SS_ACC_ENTITY_PARAM_COUNT")		);

		alWhereData.add(getAcc_entity_id());

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}

	public HashMap modify() {

		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;

		alModifyData.add(getBl_interface_yn       ());
		alModifyData.add(getGl_interface_yn       ());
		alModifyData.add(getDef_blng_serv_code    ());
		alModifyData.add(getDef_pre_doc_type_code ());
		alModifyData.add(getDef_req_doc_type_code ());
		alModifyData.add(getDef_iss_doc_type_code ());
		alModifyData.add(getDef_rtg_doc_type_code ());
		alModifyData.add(getDef_rti_doc_type_code ());
		alModifyData.add(getDef_trd_doc_type_code ());
		alModifyData.add(getDef_adj_doc_type_code ());
		alModifyData.add(getDef_var_doc_type_code ());
		alModifyData.add(getDef_rof_doc_type_code ());
		alModifyData.add(getItem_image_path       ());		
		alModifyData.add(getDef_write_off_reason_code());	
		alModifyData.add(getGen_rof_at_pre_yn());	
		alModifyData.add(getDflt_sterile_life());	

		alModifyData.add(getLoginById());      
		alModifyData.add(getLoginAtWsNo());    
		alModifyData.add(getLoginFacilityId());

		alModifyData.add(getDef_rql_doc_type_code   ());	//Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		alModifyData.add(getDef_isl_doc_type_code   ());	
		alModifyData.add(getDef_rtl_doc_type_code   ());	//ended

		alModifyData.add(getDef_rqv_doc_type_code	());	//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		alModifyData.add(getDef_rtv_doc_type_code   ());	//Added ends
	
		alModifyData.add(getAcc_entity_id());

		hmSQLMap.put( "ModifySQL", getSsRepositoryValue("SQL_SS_ACC_ENTITY_PARAM_UPDATE"));

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public boolean recordExists() throws Exception{
		HashMap hmResult = fetchRecord(getSsRepositoryValue("SQL_SS_ACC_ENTITY_PARAM_COUNT"), getAcc_entity_id());
		return !((String)hmResult.get("TOTAL")).equals("0");
	}

	public boolean isModuleInstalled(String moduleID) throws Exception{
		HashMap hmResult = fetchRecord(getSsRepositoryValue("SQL_SM_MODULE_COUNT_VALID"), moduleID);
		return !((String)hmResult.get("TOTAL")).equals("0");
	}
	public String getDef_blng_serv_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_BL_BLNG_SERV_SELECT_LIST"),getLanguageId()), getDef_blng_serv_code());
	}

	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameterForEntitys=new ArrayList();
		alParameterForEntitys.add(getLoginFacilityId());
		alParameterForEntitys.add(trn_type);
		alParameterForEntitys.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_SELECT_LIST_ENT"),alParameterForEntitys),defaultValue);
	}

	public String getDef_write_off_reason_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_WRITE_OFF_REASON_SELECT_LIST"),getLanguageId()),getDef_write_off_reason_code());
	}

	public String getDef_pre_doc_type_code_List(){
		return getDefaultDocumentTypeList("PRE",getDef_pre_doc_type_code());
	}

	public String getDef_req_doc_type_code_List(){
		return getDefaultDocumentTypeList("REQ",getDef_req_doc_type_code());
	}

	public String getDef_iss_doc_type_code_List(){
		return getDefaultDocumentTypeList("ISS",getDef_iss_doc_type_code());
	}

	public String getDef_rtg_doc_type_code_List(){
		return getDefaultDocumentTypeList("RTG",getDef_rtg_doc_type_code());
	}

	public String getDef_rti_doc_type_code_List(){
		return getDefaultDocumentTypeList("RTI",getDef_rti_doc_type_code());
	}

	public String getDef_trd_doc_type_code_List(){
		return getDefaultDocumentTypeList("TRD",getDef_trd_doc_type_code());
	}

	public String getDef_adj_doc_type_code_List(){
		return getDefaultDocumentTypeList("ADJ",getDef_adj_doc_type_code());
	}

	public String getDef_var_doc_type_code_List(){
		return getDefaultDocumentTypeList("VAR",getDef_var_doc_type_code());
	}

	public String getDef_rof_doc_type_code_List(){
		return getDefaultDocumentTypeList("ROF",getDef_rof_doc_type_code());
	}
//Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
	public String getDef_rql_doc_type_code_List(){
		return getDefaultDocumentTypeList("RQL",getDef_rql_doc_type_code());
	}

	public String getDef_isl_doc_type_code_List(){
		return getDefaultDocumentTypeList("ISL",getDef_isl_doc_type_code());
	}

	public String getDef_rtl_doc_type_code_List(){
		return getDefaultDocumentTypeList("RTL",getDef_rtl_doc_type_code());
	}
//ended

//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
	public String getDef_rqv_doc_type_code_List(){
		return getDefaultDocumentTypeList("RQV",getDef_rqv_doc_type_code());
	}
	public String getDef_rtv_doc_type_code_List(){
		return getDefaultDocumentTypeList("RTV",getDef_rtv_doc_type_code());
	}//Added ends

	public void clear() {
		acc_entity_id			=	""; 
		item_image_path			=	""; 
		def_blng_serv_code		=	""; 
		def_rof_doc_type_code	=	""; 
		def_req_doc_type_code	=	""; 
		def_rtg_doc_type_code	=	""; 
		def_pre_doc_type_code	=	""; 	
		curr_proc_year			=	""; 
		def_var_doc_type_code	=	"";  		
		def_iss_doc_type_code	=	"";  		
		bl_interface_yn			=	"N";        		
		current_phy_inv_id		=	""; 
		curr_proc_month			=	""; 
		def_trd_doc_type_code	=	""; 
		def_adj_doc_type_code	=	""; 
		gl_interface_yn			=	"N"; 
		def_rti_doc_type_code	=	""; 
		def_write_off_reason_code	=	""; 
		gen_rof_at_pre_yn	=	"Y"; 
		dflt_sterile_life	=	""; 
		def_rql_doc_type_code		=	""; //Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		def_isl_doc_type_code		=	""; 
		def_rtl_doc_type_code		=	""; //ended	
		def_rqv_doc_type_code		=	"";	//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		def_rtv_doc_type_code		=	"";	//Added ends
	}

	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
		HashMap hmRecord	=	null;
		hmRecord	=	fetchRecord(getSsRepositoryValue("SQL_SS_ACC_ENTITY_PARAM_SELECT_SINGLE"), getAcc_entity_id());

		setCurr_proc_month       ( (String)hmRecord.get("CURR_PROC_MONTH" )			) ;
		setCurr_proc_year        ( (String)hmRecord.get("CURR_PROC_YEAR" )			) ;	
		setBl_interface_yn       ( (String)hmRecord.get("BL_INTERFACE_YN" )			) ;	
		setGl_interface_yn       ( (String)hmRecord.get("GL_INTERFACE_YN" )			) ;	
		setDef_blng_serv_code    ( checkForNull((String)hmRecord.get("DEF_BLNG_SERV_CODE" )		)) ;	
		setDef_pre_doc_type_code ( checkForNull((String)hmRecord.get("DEF_PRE_DOC_TYPE_CODE" )	)) ;	
		setDef_req_doc_type_code ( checkForNull((String)hmRecord.get("DEF_REQ_DOC_TYPE_CODE" )	)) ;	
		setDef_iss_doc_type_code ( checkForNull((String)hmRecord.get("DEF_ISS_DOC_TYPE_CODE" )	)) ;	
		setDef_rtg_doc_type_code ( checkForNull((String)hmRecord.get("DEF_RTG_DOC_TYPE_CODE" )	)) ;	
		setDef_rti_doc_type_code ( checkForNull((String)hmRecord.get("DEF_RTI_DOC_TYPE_CODE" )	)) ;	
		setDef_trd_doc_type_code ( checkForNull((String)hmRecord.get("DEF_TRD_DOC_TYPE_CODE" )	)) ;	
		setDef_adj_doc_type_code ( checkForNull((String)hmRecord.get("DEF_ADJ_DOC_TYPE_CODE" )	)) ;	
		setDef_var_doc_type_code ( checkForNull((String)hmRecord.get("DEF_VAR_DOC_TYPE_CODE" )	)) ;	
		setDef_rof_doc_type_code ( checkForNull((String)hmRecord.get("DEF_ROF_DOC_TYPE_CODE" )	)) ;	
		setCurrent_phy_inv_id    ( checkForNull((String)hmRecord.get("CURRENT_PHY_INV_ID" )		)) ;	
		setItem_image_path       ( checkForNull((String)hmRecord.get("ITEM_IMAGE_PATH" )			)) ;	
		setDef_write_off_reason_code( checkForNull((String)hmRecord.get("DEF_WRITE_OFF_REASON_CODE" )			)) ;	
		setGen_rof_at_pre_yn( checkForNull((String)hmRecord.get("GEN_ROF_AT_PRE_YN" )			)) ;	
		setDflt_sterile_life( checkForNull((String)hmRecord.get("DFLT_STERILE_LIFE" )			)) ;	
		setDef_rql_doc_type_code( checkForNull((String)hmRecord.get("DEF_RQL_DOC_TYPE_CODE" )			)) ;	//Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		setDef_isl_doc_type_code( checkForNull((String)hmRecord.get("DEF_ISL_DOC_TYPE_CODE" )			)) ;	
		setDef_rtl_doc_type_code( checkForNull((String)hmRecord.get("DEF_RTL_DOC_TYPE_CODE" )			)) ;	//ended
		setDef_rqv_doc_type_code(checkForNull((String)hmRecord.get("DEF_RQV_DOC_TYPE_CODE" )			)) ;	//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		setDef_rtv_doc_type_code(checkForNull((String)hmRecord.get("DEF_RTV_DOC_TYPE_CODE" )			)) ;	//Added ends
		setDef_rqv_doc_type_code(checkForNull((String)hmRecord.get("DEF_RQV_DOC_TYPE_CODE" )			)) ;	//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		setDef_rtv_doc_type_code(checkForNull((String)hmRecord.get("DEF_RTV_DOC_TYPE_CODE" )			)) ;	//Added ends
	}

	public String paramsInBean(){
		return "ParameterForEntity Bean";
	}
}
