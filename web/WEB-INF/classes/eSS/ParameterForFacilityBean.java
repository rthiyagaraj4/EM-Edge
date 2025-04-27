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

public class ParameterForFacilityBean extends SsAdapter implements Serializable { 

	private String item_image_path;
	private String def_blng_serv_code;
	private String def_rof_doc_type_code;
	private String def_req_doc_type_code;
	private String def_rtg_doc_type_code;
	private String def_pre_doc_type_code;
	private String def_store_code_for_pre;
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
	private String def_service_location_code;
	private String def_write_off_reason_code;
	private String gen_rof_at_pre_yn;
	private String surg_nature_link_ot_yn;//Added by Sakti against KDAH-CRF-0247

	//Added By Sakti Sankar on 06/12/2012 against CRF#222
	private String iss_ack_req_yn;
    private String ret_ack_req_yn;
	//Added ends

	private String	def_auto_req_doc_type_code;//Added for 36422	Bru-HIMS-CRF-268.2
	private String	def_auto_req_on_store;//Added for 36422	Bru-HIMS-CRF-268.2
	private String	auto_req_yn;//Added for 36422	Bru-HIMS-CRF-268.2

	//32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
	private String def_rql_doc_type_code;
	private String def_isl_doc_type_code;
	private String def_rtl_doc_type_code;
	//ended

	 //Added By Sakti Sankar on 24/02/2014 against CRF#225.1
  	private String isl_ack_req_yn;
    private String rtl_ack_req_yn;
  	//Added ends

	private String durn_for_start_date; // Added by Sakti #inc no:48848 on 30/04/14  

	//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
	private String def_rqv_doc_type_code;
	private String def_rtv_doc_type_code;
	//Added ends

	//Added for ML-MMOH-CRF-1821
	private String instruction_label_pack;
	private String print_packed_label_yn;
	private String linen_group_label_type;
	private String set_group_label_type;
	private String single_group_label_type;
	private String soft_pack_group_label_type;
	private String tray_group_label_type;

	private String allow_multi_group_types_yn;
	private String group_type_mandatory_yn;

	//Added ends for ML-MMOH-CRF-1821
	public void setItem_image_path(String item_image_path) {
		 this.item_image_path = item_image_path;
	}

	public String getItem_image_path( ) {
		 return item_image_path;
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

	public void setDef_store_code_for_pre(String def_store_code_for_pre) {
		 this.def_store_code_for_pre = def_store_code_for_pre;
	}

	public String getDef_store_code_for_pre( ) {
		 return def_store_code_for_pre;
	}

	public void setCurr_proc_year(String curr_proc_year) {
		 this.curr_proc_year = curr_proc_year;
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
		 this.curr_proc_month = curr_proc_month;
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

	public void setDef_service_location_code(String def_service_location_code) {
		 this.def_service_location_code = def_service_location_code;
	}

	public String getDef_service_location_code( ) {
		 return def_service_location_code;
	}

	public void setDef_write_off_reason_code(String def_write_off_reason_code) {
		 this.def_write_off_reason_code = def_write_off_reason_code;
	}

	public String getDef_write_off_reason_code( ) {
		 return def_write_off_reason_code;
	}

	//Added By Sakti Sankar on 06/12/2012 against CRF#222
	public void setIss_ack_req_yn(String iss_ack_req_yn) {
		 this.iss_ack_req_yn = checkForNull(iss_ack_req_yn,"N");
	}
	public String getIss_ack_req_yn() {
		 return iss_ack_req_yn;
	}

	public void setRet_ack_req_yn(String ret_ack_req_yn) {
		 this.ret_ack_req_yn = checkForNull(ret_ack_req_yn,"N");
	}

	public String getRet_ack_req_yn() {
		 return ret_ack_req_yn;
	}
	//Added ends
	
	//Added for 36422	Bru-HIMS-CRF-268.2
	public void setDef_auto_req_doc_type_code(String def_auto_req_doc_type_code) {
		 this.def_auto_req_doc_type_code = checkForNull(def_auto_req_doc_type_code);
	}

	public String getDef_auto_req_doc_type_code() {
		 return def_auto_req_doc_type_code;
	}
	public void setDef_auto_req_on_store(String def_auto_req_on_store) {
		 this.def_auto_req_on_store = checkForNull(def_auto_req_on_store);
	}

	public String getDef_auto_req_on_store() {
		 return def_auto_req_on_store;
	}
	public void setAuto_req_yn(String auto_req_yn) {
		 this.auto_req_yn = checkForNull(auto_req_yn,"N");
	}

	public String getAuto_req_yn( ) {
		 return auto_req_yn;
	}
	//end for 36422	Bru-HIMS-CRF-268.2

	//Added by sakti against KDAH-CRF-0247
	public void setSurgery_Type_Linked_To_OT(String surg_nature_link_ot_yn) {
		 this.surg_nature_link_ot_yn = checkForNull(surg_nature_link_ot_yn,"N"); 
	}

	public String getSurgery_Type_Linked_To_OT( ) {
		 return surg_nature_link_ot_yn;
	}
	//Added ends
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

	//Added By Sakti Sankar on 24/02/2014 against CRF#225.1
	public void setIsl_ack_req_yn(String isl_ack_req_yn) {
		 this.isl_ack_req_yn = checkForNull(isl_ack_req_yn,"N");
	}
	public String getIsl_ack_req_yn() {
		 return isl_ack_req_yn;
	}

	public void setRtl_ack_req_yn(String rtl_ack_req_yn) {
		 this.rtl_ack_req_yn = checkForNull(rtl_ack_req_yn,"N");
	}

	public String getRtl_ack_req_yn() {
		 return rtl_ack_req_yn;
	}
	//Added ends

	//Added by Sakti #inc no:48848 on 30/04/14 Starts
	public void setDurn_for_start_date(String durn_for_start_date) {
		this.durn_for_start_date = checkForNull(durn_for_start_date);
	}
				
	public String getDurn_for_start_date() {
		return durn_for_start_date;
	}
			
	//ends

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

	//Added for ML-MMOH-CRF-1821
	public void setInstruction_label_pack(String instruction_label_pack) {
		 this.instruction_label_pack = instruction_label_pack;
	}
	public String getInstruction_label_pack( ) {
		 return instruction_label_pack;
	}

	public void setPrint_packed_labelYn(String print_packed_label_yn) {
		 this.print_packed_label_yn = checkForNull(print_packed_label_yn,"N");
	}
	public String getPrint_packed_labelYn() {
		 return print_packed_label_yn;
	}
	public void setLinen_group_label_type(String linen_group_label_type) {
		 this.linen_group_label_type = linen_group_label_type;
	}

	public String getLinen_group_label_type() {
		 return linen_group_label_type;
	}
	public void setGroup_label_type(String set_group_label_type) {
		 this.set_group_label_type = set_group_label_type;
	}
	public String getGroup_label_type() {
		 return set_group_label_type;
	}
	public void setSingle_group_label_type(String single_group_label_type) {
		 this.single_group_label_type = single_group_label_type;
	}
	public String getSingle_group_label_type() {
		 return single_group_label_type;
	}

	public void setSoft_pack_group_label_type(String soft_pack_group_label_type) {
		 this.soft_pack_group_label_type = soft_pack_group_label_type;
	}
	public String getSoft_pack_group_label_type() {
		 return soft_pack_group_label_type;
	}

	public void setTray_group_label_type(String tray_group_label_type) {
		 this.tray_group_label_type = tray_group_label_type;
	}
	public String getTray_group_label_type() {
		 return tray_group_label_type;
	}

	public void setAllow_multi_group_typeYn(String allow_multi_group_types_yn) {
		 this.allow_multi_group_types_yn = checkForNull(allow_multi_group_types_yn,"N");
	}
	public String getAllow_multi_group_typeYn() {
		 return allow_multi_group_types_yn;
	}


	public void setGroup_type_mandatoryYn(String group_type_mandatory_yn) {
		 this.group_type_mandatory_yn = checkForNull(group_type_mandatory_yn,"N");
	}
	public String getGroup_type_mandatoryYn() {
		 return group_type_mandatory_yn;
	}

	//Added ends for ML-MMOH-CRF-1821


	public void setAll(Hashtable htRecordSet){

		super.setAll(htRecordSet);
		setItem_image_path			(	(String) htRecordSet.get("item_image_path"));
		setDef_blng_serv_code		(	(String) htRecordSet.get("def_blng_serv_code"));
		setDef_rof_doc_type_code	(	(String) htRecordSet.get("def_rof_doc_type_code"));
		setDef_req_doc_type_code	(	(String) htRecordSet.get("def_req_doc_type_code"));
		setDef_rtg_doc_type_code	(	(String) htRecordSet.get("def_rtg_doc_type_code"));
		setDef_pre_doc_type_code	(	(String) htRecordSet.get("def_pre_doc_type_code"));
		setDef_store_code_for_pre	(	(String) htRecordSet.get("def_store_code_for_pre"));
		setCurr_proc_year			(	(String) htRecordSet.get("curr_proc_year"));
		setDef_var_doc_type_code	(	(String) htRecordSet.get("def_var_doc_type_code"));
		setDef_iss_doc_type_code	(	(String) htRecordSet.get("def_iss_doc_type_code"));
		setBl_interface_yn			(	(String) htRecordSet.get("bl_interface_yn"));
		setCurrent_phy_inv_id		(	(String) htRecordSet.get("current_phy_inv_id"));
		setCurr_proc_month			(	(String) htRecordSet.get("curr_proc_month"));
		setDef_trd_doc_type_code	(	(String) htRecordSet.get("def_trd_doc_type_code"));
		setDef_adj_doc_type_code	(	(String) htRecordSet.get("def_adj_doc_type_code"));
		setGl_interface_yn			(	(String) htRecordSet.get("gl_interface_yn"));
		setDef_rti_doc_type_code	(	(String) htRecordSet.get("def_rti_doc_type_code"));
		setDef_service_location_code(	(String) htRecordSet.get("def_service_location_code"));
		setDef_write_off_reason_code(	(String) htRecordSet.get("def_write_off_reason_code"));
		setGen_rof_at_pre_yn(	(String) htRecordSet.get("gen_rof_at_pre_yn"));
 
		//Added By Sakti Sankar on 06/12/2012 against CRF#222
		setIss_ack_req_yn(	(String) htRecordSet.get("iss_ack_req_yn"));
		setRet_ack_req_yn(	(String) htRecordSet.get("ret_ack_req_yn"));
		//Added ends

		setDef_auto_req_doc_type_code((String) htRecordSet.get("def_auto_req_doc_type_code"));//Added for 36422	Bru-HIMS-CRF-268.2
		setDef_auto_req_on_store((String) htRecordSet.get("def_auto_req_on_store"));//Added for 36422	Bru-HIMS-CRF-268.2
		setAuto_req_yn((String) htRecordSet.get("auto_req_yn"));//Added for 36422	Bru-HIMS-CRF-268.2
		setSurgery_Type_Linked_To_OT(	(String) htRecordSet.get("surg_nature_link_ot_yn"));//Added by sakti against KDAH-CRF-0247
		//Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		setDef_rql_doc_type_code(	checkForNull((String) htRecordSet.get("def_rql_doc_type_code")));
		setDef_isl_doc_type_code(	checkForNull((String) htRecordSet.get("def_isl_doc_type_code")));
		setDef_rtl_doc_type_code(	checkForNull((String) htRecordSet.get("def_rtl_doc_type_code")));
		//ended

		//Added By Sakti Sankar on 24/02/2014 against CRF#225.1
		setIsl_ack_req_yn(	(String) htRecordSet.get("isl_ack_req_yn"));
		setRtl_ack_req_yn(	(String) htRecordSet.get("rtl_ack_req_yn"));
		//Added ends

		setDurn_for_start_date((String) htRecordSet.get("durn_for_start_date"));  //Added by Sakti #inc no:48848 on 30/04/14

		setDef_rqv_doc_type_code((String)htRecordSet.get("def_rqv_doc_type_code")); //Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		setDef_rtv_doc_type_code((String)htRecordSet.get("def_rtv_doc_type_code"));	//Added ends


		//Added for ML-MMOH-CRF-1821
		setInstruction_label_pack((String)htRecordSet.get("instruction_label_pack"));	
		setPrint_packed_labelYn(checkForNull((String)htRecordSet.get("print_packed_label_yn"),"N"));	
		setLinen_group_label_type((String)htRecordSet.get("linen_group_label_type"));	
		setGroup_label_type((String)htRecordSet.get("set_group_label_type"));	
		setSingle_group_label_type((String)htRecordSet.get("single_group_label_type"));	
		setSoft_pack_group_label_type((String)htRecordSet.get("soft_pack_group_label_type"));	
		setTray_group_label_type((String)htRecordSet.get("tray_group_label_type"));	

		setAllow_multi_group_typeYn(checkForNull((String)htRecordSet.get("allow_multi_group_types_yn"),"N"));	
		setGroup_type_mandatoryYn(checkForNull((String)htRecordSet.get("group_type_mandatory_yn"),"N"));	
  		//Added ends for ML-MMOH-CRF-1821
	}

	public HashMap insert() {

		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alInsertData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;
		ArrayList	alWhereData	=	new ArrayList()	;

		alInsertData.add(getLoginFacilityId		  ());
		alInsertData.add(new Long(getCurr_proc_month       ()));
		alInsertData.add(new Long(getCurr_proc_year        ()));
		alInsertData.add(getDef_store_code_for_pre());
		alInsertData.add(getBl_interface_yn       ());
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
		alInsertData.add(getDef_service_location_code       ());	
		alInsertData.add(getDef_write_off_reason_code       ());	

		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());
		alInsertData.add(getLoginById());      
		alInsertData.add(getLoginAtWsNo());    
		alInsertData.add(getLoginFacilityId());

		//Added By Sakti Sankar on 06/12/2012 against CRF#222
		alInsertData.add(getIss_ack_req_yn ());
		alInsertData.add(getRet_ack_req_yn ());
		//Added ends

		//Added for 36422	Bru-HIMS-CRF-268.2
		alInsertData.add(getDef_auto_req_doc_type_code ());
		alInsertData.add(getDef_auto_req_on_store ());
		alInsertData.add(getAuto_req_yn ());
		//ends
		alInsertData.add(getSurgery_Type_Linked_To_OT ());//Added by sakti against KDAH-CRF-0247
		
		alInsertData.add(getDef_rql_doc_type_code   ());	//Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		alInsertData.add(getDef_isl_doc_type_code   ());	
		alInsertData.add(getDef_rtl_doc_type_code   ());	//ended

		//Added By Sakti Sankar on 24/02/2014 against CRF#225.1
		alInsertData.add(getIsl_ack_req_yn ());
		alInsertData.add(getRtl_ack_req_yn ());
		//Added ends
		alInsertData.add(getDurn_for_start_date()); //Added by Sakti #inc no:48848 on 30/04/2014
		alInsertData.add(getDef_rqv_doc_type_code());	//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		alInsertData.add(getDef_rtv_doc_type_code());	//Added ends

		//Added for ML-MMOH-CRF-1821
		alInsertData.add(getInstruction_label_pack());
		alInsertData.add(getPrint_packed_labelYn());
		alInsertData.add(getLinen_group_label_type());
		alInsertData.add(getGroup_label_type());

		alInsertData.add(getSingle_group_label_type());
  		alInsertData.add(getSoft_pack_group_label_type());

		alInsertData.add(getTray_group_label_type());
		alInsertData.add(getAllow_multi_group_typeYn());
		alInsertData.add(getGroup_type_mandatoryYn());
		//Added ends for ML-MMOH-CRF-1821

		hmSQLMap.put( "InsertSQL", getSsRepositoryValue("SQL_SS_PARAMETER_INSERT")		);
		hmSQLMap.put( "SelectSQL", getSsRepositoryValue("SQL_SS_PARAMETER_COUNT")		);

		alWhereData.add(getLoginFacilityId());



		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "WhereData",			alWhereData		);
		hmTableData.put( "InsertData",			alInsertData	);
 		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_INSERT);
	}

	public HashMap modify() {


		HashMap		hmTableData	=	new HashMap()	;
		ArrayList	alModifyData=	new ArrayList()	;
		HashMap		hmSQLMap	=	new HashMap()	;

		alModifyData.add(getDef_store_code_for_pre());
		alModifyData.add(getBl_interface_yn       ());
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
		alModifyData.add(getDef_service_location_code());	
		alModifyData.add(getDef_write_off_reason_code());

		alModifyData.add(getLoginById());      
		alModifyData.add(getLoginAtWsNo());    
		alModifyData.add(getLoginFacilityId());
	
		//Added By Sakti Sankar on 06/12/2012 against CRF#222
		alModifyData.add(getIss_ack_req_yn ());
		alModifyData.add(getRet_ack_req_yn ());
		//Added ends

		//Added for 36422	Bru-HIMS-CRF-268.2
		alModifyData.add(getDef_auto_req_doc_type_code ());
		alModifyData.add(getDef_auto_req_on_store ());
		alModifyData.add(getAuto_req_yn ());
		//ends
		alModifyData.add(getSurgery_Type_Linked_To_OT ());//Added by sakti against KDAH-CRF-0247
		alModifyData.add(getDef_rql_doc_type_code   ());	//Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		alModifyData.add(getDef_isl_doc_type_code   ());	
		alModifyData.add(getDef_rtl_doc_type_code   ());	//ended

		//Added By Sakti Sankar on 24/02/2014 against CRF#222
		alModifyData.add(getIsl_ack_req_yn ());
		alModifyData.add(getRtl_ack_req_yn ());
		//Added ends
		alModifyData.add(getDurn_for_start_date()); //Added by Sakti #inc no:48848 on 30/04/2014

		alModifyData.add(getDef_rqv_doc_type_code());//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		alModifyData.add(getDef_rtv_doc_type_code());//Added ends
	

		//Added for ML-MMOH-CRF-1821
		alModifyData.add(getInstruction_label_pack());
		alModifyData.add(getPrint_packed_labelYn());
		alModifyData.add(getLinen_group_label_type());

		alModifyData.add(getGroup_label_type());
		alModifyData.add(getSingle_group_label_type());
  		alModifyData.add(getSoft_pack_group_label_type());

		alModifyData.add(getTray_group_label_type());

		alModifyData.add(getAllow_multi_group_typeYn());
		alModifyData.add(getGroup_type_mandatoryYn());

		//Added ends for ML-MMOH-CRF-1821

		alModifyData.add(getLoginFacilityId());
 
		hmSQLMap.put( "ModifySQL", getSsRepositoryValue("SQL_SS_PARAMETER_UPDATE"));

		hmTableData.put( "properties",			getProperties() );
		hmTableData.put( "ModifyData",			alModifyData	);

		return singleTableHandlerMethodCall(hmTableData, hmSQLMap, FUNCTION_UPDATE );
	}

	public boolean recordExists() throws Exception{
		HashMap hmResult = fetchRecord(getSsRepositoryValue("SQL_SS_PARAMETER_COUNT"), getLoginFacilityId());
		return !((String)hmResult.get("TOTAL")).equals("0");
	}
	public boolean isModuleInstalled(String moduleID) throws Exception{
		String []stParameterForFacilitys={getLoginFacilityId(),moduleID};
		HashMap hmResult = fetchRecord(getSsRepositoryValue("SQL_SM_MODULES_FACILITY_COUNT_VALID"), stParameterForFacilitys);
		return !((String)hmResult.get("TOTAL")).equals("0");
	}
	public String getDef_blng_serv_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_BL_BLNG_SERV_SELECT_LIST"),getLanguageId()), getDef_blng_serv_code());
	}
	public String getDef_store_code_for_pre_List(){
		ArrayList alParameter=new ArrayList();
		alParameter.add(getLoginFacilityId());
		alParameter.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_QUERY_OWNER_SELECT_LIST"),alParameter), getDef_store_code_for_pre());
	}

	private String getDefaultDocumentTypeList(String trn_type, String defaultValue){
		ArrayList alParameterForFacilitys=new ArrayList();
		alParameterForFacilitys.add(getLoginFacilityId());
		alParameterForFacilitys.add(trn_type);
		alParameterForFacilitys.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_SELECT_LIST"),alParameterForFacilitys),defaultValue);
	}

	public String getDef_service_location_code_List(){
		ArrayList alParameter=new ArrayList();
		alParameter.add(getLoginFacilityId());
		alParameter.add(getLanguageId());
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_SERVICE_LOCATION_SELECT_LIST"),alParameter),getDef_service_location_code());
		
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
	
	//Added for 36422	Bru-HIMS-CRF-268.2
	public String getDef_auto_req_doc_type_code_List(){
		return getDefaultDocumentTypeList("REQ",getDef_auto_req_doc_type_code());
	}

	public String getReq_on_store_code_List(){
		return getListOptionTag( getListOptionArrayList(getSsRepositoryValue("SQL_SS_STORE_ISS_SELECT_LIST"),login_facility_id), getDef_auto_req_on_store());
	}
	//added ends

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
//Added By Sakti Sankar on 06/12/2012 against CRF#222
	public Boolean getRecordCountForIssueGroup() {
		String []ssParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM SS_ISSUE_HDR WHERE  PROCESS_FOR_ACKNOWLEDGE = 'Y' AND FACILITY_ID = ?", ssParameters);
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}
		if(!((String)hmRecord.get("COUNT")).equals("0"))
			return true;
		else
			return false;
	}

	public Boolean getRecordCountForReturnGroup() {
		String []ssParameters=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		try{
			hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM SS_RETURN_HDR WHERE FINALIZED_YN = 'N' AND PROCESS_FOR_ACKNOWLEDGE = 'Y' AND FACILITY_ID = ? ", ssParameters);
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}
		if(!((String)hmRecord.get("COUNT")).equals("0"))
			return true;
		else
			return false;
	}
//Added ends

//Added By Sakti Sankar on 24/02/2014 against CRF#225.1
		public Boolean getRecordCountForLoanIssueGroup() {
			String []ssParameters=	{getLoginFacilityId()};
			HashMap hmRecord	=	null;
			try{
				hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM SS_LOAN_ISSUE_HDR WHERE  PROCESS_FOR_ACKNOWLEDGE = 'Y' AND FACILITY_ID = ?", ssParameters);
			}catch(Exception e){
				e.printStackTrace();
				return true;
			}
			if(!((String)hmRecord.get("COUNT")).equals("0"))
				return true;
			else
				return false;
		}

		public Boolean getRecordCountForLoanReturnGroup() {
			String []ssParameters=	{getLoginFacilityId()};
			HashMap hmRecord	=	null;
			try{
				hmRecord	=	(HashMap)fetchRecord("SELECT COUNT (*) COUNT FROM SS_LOAN_RETURN_HDR WHERE FINALIZED_YN = 'N' AND PROCESS_FOR_ACKNOWLEDGE = 'Y' AND FACILITY_ID = ? ", ssParameters);
			}catch(Exception e){
				e.printStackTrace();
				return true;
			}
			if(!((String)hmRecord.get("COUNT")).equals("0"))
				return true;
			else
				return false;
		}
	//Added ends	



	public void clear() {
		item_image_path			=	""; 
		def_blng_serv_code		=	""; 
		def_rof_doc_type_code	=	""; 
		def_req_doc_type_code	=	""; 
		def_rtg_doc_type_code	=	""; 
		def_pre_doc_type_code	=	""; 
		def_store_code_for_pre	=	""; 		
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
		def_service_location_code	=	""; 
		def_write_off_reason_code	=	""; 
		gen_rof_at_pre_yn			=	"Y";
		iss_ack_req_yn				=	"N";
		ret_ack_req_yn				=	"N";
		def_auto_req_doc_type_code	= "" ;//Added for 36422	Bru-HIMS-CRF-268.2
		def_auto_req_on_store		= "" ;//Added for 36422	Bru-HIMS-CRF-268.2
		auto_req_yn		= "" ;//Added for 36422	Bru-HIMS-CRF-268.2
		surg_nature_link_ot_yn		= "" ;//Added by sakti against KDAH-CRF-0247
		def_rql_doc_type_code		=	""; //Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		def_isl_doc_type_code		=	""; 
		def_rtl_doc_type_code		=	""; //ended

		isl_ack_req_yn				=	"N";
		rtl_ack_req_yn				=	"N";

		durn_for_start_date = ""; //Added against inc#48848

		//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		def_rqv_doc_type_code		=	"";
		def_rtv_doc_type_code		=	"";
		//Added ends

		//Added for ML-MMOH-CRF-1821
		instruction_label_pack		=	"";
		print_packed_label_yn		=	"N";	
		linen_group_label_type		=	"";
		set_group_label_type		=	"";
		single_group_label_type		=	"";
		soft_pack_group_label_type	=	"";
		tray_group_label_type		=	"";

		allow_multi_group_types_yn	=   "";
		group_type_mandatory_yn		=	"N";

		//Added ends for ML-MMOH-CRF-1821
	}

	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
		String []stParameterForFacilitys		=	{getLoginFacilityId()};
		HashMap hmRecord	=	null;
		hmRecord	=	fetchRecord(getSsRepositoryValue("SQL_SS_PARAMETER_SELECT_SINGLE"), stParameterForFacilitys);

		setCurr_proc_month       ( (String)hmRecord.get("CURR_PROC_MONTH" )			) ;
		setCurr_proc_year        ( (String)hmRecord.get("CURR_PROC_YEAR" )			) ;	
		setDef_store_code_for_pre( checkForNull((String)hmRecord.get("DEF_STORE_CODE_FOR_PRE" )	)) ;	
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
		setDef_service_location_code( checkForNull((String)hmRecord.get("DEF_SERVICE_LOCATION_CODE" )			)) ;	
		setDef_write_off_reason_code( checkForNull((String)hmRecord.get("DEF_WRITE_OFF_REASON_CODE" )			)) ;	
		setGen_rof_at_pre_yn( checkForNull((String)hmRecord.get("GEN_ROF_AT_PRE_YN" )			)) ;
		setIss_ack_req_yn( checkForNull((String)hmRecord.get("ISS_ACK_REQ_YN" ))) ;
		setRet_ack_req_yn( checkForNull((String)hmRecord.get("RET_ACK_REQ_YN" ))) ;
		setDef_auto_req_doc_type_code((String) hmRecord.get("DEF_AUTO_REQ_DOC_TYPE_CODE"));//Added for 36422	Bru-HIMS-CRF-268.2
		setDef_auto_req_on_store((String) hmRecord.get("DEF_AUTO_REQ_ON_STORE"));//Added for 36422	Bru-HIMS-CRF-268.2
		setAuto_req_yn((String) hmRecord.get("AUTO_REQ_YN"));//Added for 36422	Bru-HIMS-CRF-268.2
		setSurgery_Type_Linked_To_OT((String) hmRecord.get("SURG_NATURE_LINK_OT_YN"));//Added by sakti against KDAH-CRF-0247
		setDef_rql_doc_type_code( checkForNull((String)hmRecord.get("DEF_RQL_DOC_TYPE_CODE" )			)) ;	//Inc32071	Bru-HIMS-CRF-225	BY GANGA Tuesday, April 09, 2013
		setDef_isl_doc_type_code( checkForNull((String)hmRecord.get("DEF_ISL_DOC_TYPE_CODE" )			)) ;	
		setDef_rtl_doc_type_code( checkForNull((String)hmRecord.get("DEF_RTL_DOC_TYPE_CODE" )			)) ;	//ended

		setIsl_ack_req_yn( checkForNull((String)hmRecord.get("ISL_ACK_REQ_YN" ))) ; //Added against Bru-HIMS-CRF-225	BY SAKTI 24/02/2014
		setRtl_ack_req_yn( checkForNull((String)hmRecord.get("RTL_ACK_REQ_YN" ))) ; //Added against Bru-HIMS-CRF-225	BY SAKTI 24/02/2014
		setDurn_for_start_date		  ( (String)hmRecord.get("DURN_FOR_START_DATE")) ; //Added by Sakti #inc no:18848 on 20/04/2014
		setDef_rqv_doc_type_code( checkForNull((String)hmRecord.get("DEF_RQV_DOC_TYPE_CODE" )	)) ;//Added for AAKH-CRF-0058 and inc#51899 By B.Badmavathi on 06-07-2015
		setDef_rtv_doc_type_code( checkForNull((String)hmRecord.get("DEF_RTV_DOC_TYPE_CODE" )	)) ;//Added ends

		//Added for ML-MMOH-CRF-1821
		setInstruction_label_pack(checkForNull((String)hmRecord.get("INSTRUCTION_LABEL_PACK" )	) );	
		setPrint_packed_labelYn(checkForNull((String)hmRecord.get("PRINT_PACKED_LABEL_YN" ),"N"	) );	
		setLinen_group_label_type( checkForNull((String)hmRecord.get("LINEN_GROUP_LABEL_TYPE" )	) );	
		setGroup_label_type( checkForNull((String)hmRecord.get("SET_GROUP_LABEL_TYPE" )	) );	
		setSingle_group_label_type(checkForNull((String)hmRecord.get("SINGLE_GROUP_LABEL_TYPE" ))  );	
		setSoft_pack_group_label_type(checkForNull((String)hmRecord.get("SOFT_PACK_GROUP_LABEL_TYPE" )));	
		setTray_group_label_type(checkForNull((String)hmRecord.get("TRAY_GROUP_LABEL_TYPE" )));	


		setAllow_multi_group_typeYn(checkForNull((String)hmRecord.get("ALLOW_MULTI_GROUP_TYPES_YN" ),"N"	) );
		setGroup_type_mandatoryYn(checkForNull((String)hmRecord.get("GROUP_TYPE_MANDATORY_YN" ),"N"	) );
	  	//Added ends for ML-MMOH-CRF-1821

	}

	public String toString(){
		return "ParameterForFacility Bean";
	}
}
