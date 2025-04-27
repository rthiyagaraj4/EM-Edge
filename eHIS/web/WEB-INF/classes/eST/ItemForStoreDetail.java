/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603			Badmavathi B								GHL-CRF-0456
31/10/2019      IN:071344        B Haribabu      15/10/2019      Manickam        GHL-CRF-0609  
31/12/2020		TFS-8224           Prabha      31/12/2020		Manickam	  MMS-DM-CRF-0177
13/10/2021		TFS-24348			Shazana		13/10/2021		Manickam		MO-CRF-20172

---------------------------------------------------------------------------------------------------------
*/
 package eST;

import eCommon.Common.CommonAdapter;

public class ItemForStoreDetail implements java.io.Serializable {
	private String store_code;
	private String store_desc;
	private String item_code;
	private String item_desc;
	private String bin_location_code;
	private String bin_location_desc;
	private String stock_item_yn;
	private String min_stock_qty;
	private String max_stock_qty;
	private String reorder_level;
	private String reorder_freq_days;
	private String lead_days;
	private String min_stock_days;
	private String min_stock_percentage;
	private String req_gen_stg  = "";
	private String request_uom  = "";
	private String issue_uom    = "";
	private String eff_status   = "";
	private String gen_uom_code = "";
	private String phy_inv_type = "";
	private String phy_inv_count_per_year= "";
	private String re_order_qty = "";
	private String no_of_days = ""; //MO-CRF-20172  
	
	public String getNo_of_days() {
		return no_of_days;
	}
	public void setNo_of_days(String no_of_days) {
		this.no_of_days = no_of_days;
	}//end 
	//Added for MMS-DM-CRF-0177
	private String near_expiry_appl = "";
	private String durn_value = "";
	private String durn_type = "";
	private String durn_value_in_days = "";
	//Added for MMS-DM-CRF-0177
	
	//Added for  IN:071344 start
	private String auto_rol_yn = "N";
	public String getAutoRolYN() {
		return auto_rol_yn;
	}
	public void setAutoRolYN(String auto_rol_yn) {
		this.auto_rol_yn = auto_rol_yn;
	}
//Added for  IN:071344  end
	//Added for GHL-CRF-0456 starts
	private String sales_allowed_yn ="";
	private String consumption_allowed_yn = "";
		public String getSales_allowed_yn() {
		return sales_allowed_yn;
	}
	public void setSales_allowed_yn(String sales_allowed_yn) {
		this.sales_allowed_yn = sales_allowed_yn;
	}
	public String getConsumption_allowed_yn() {
		return consumption_allowed_yn;
	}
	public void setConsumption_allowed_yn(String consumption_allowed_yn) {
		this.consumption_allowed_yn = consumption_allowed_yn;
	}
	
	//Added for MMS-DM-CRF-0177 - Start
	public String getNearExpiryAppl() {
		return near_expiry_appl;
	}
	public void setNearExpiryAppl(String near_expiry_appl) {
		this.near_expiry_appl = near_expiry_appl;
	}
	
	public String getDurnValue() {
		return durn_value;
	}
	public void setDurnValue(String durn_value) {
		this.durn_value = durn_value;
	}
	
	public String getDurnType() {
		return durn_type;
	}
	public void setDurnType(String durn_type) {
		this.durn_type = durn_type;
	}
	
	public String getDurnValueInDays() {
		return durn_value_in_days;
	}
	public void setDurnValueInDays(String durn_value_in_days) {
		this.durn_value_in_days = durn_value_in_days;
	}
	
	//Added for MMS-DM-CRF-0177 - End
	
//Added for GHL-CRF-0456 ends
	public ItemForStoreDetail() {
	}

	public ItemForStoreDetail(String store_code, String store_desc, String item_code, String item_desc,String request_uom) {
		this.store_code = store_code;
		this.store_desc = store_desc;
		this.item_code = item_code;
		this.item_desc = item_desc;
		this.stock_item_yn = "";
		this.min_stock_qty = "";
		this.max_stock_qty = "";
		this.reorder_level = "";
		this.reorder_freq_days = "";
		this.lead_days = "";
		this.min_stock_days = "";
		this.min_stock_percentage = "";
		this.req_gen_stg	= "";
		this.request_uom	= request_uom;
		this.issue_uom		= request_uom;
		this.phy_inv_type   = phy_inv_type;
		this.phy_inv_count_per_year=phy_inv_count_per_year;
		this.eff_status		= "";
		this.sales_allowed_yn="";//Added for GHL-CRF-0456
		this.consumption_allowed_yn="";//Added for GHL-CRF-0456
		//Added for MMS-DM-CRF-0177
		this.near_expiry_appl="";
		this.durn_value="";
		this.durn_type="";
		this.durn_value_in_days="";
		//Added for MMS-DM-CRF-0177
		this.no_of_days = ""; //MO-CRF-20172 
	}

	public ItemForStoreDetail(String store_code, String item_code) {
		this.store_code = store_code;
		this.store_desc = "";
		this.item_code = item_code;
		this.item_desc = "";
		this.stock_item_yn = "";
		this.min_stock_qty = "";
		this.max_stock_qty = "";
		this.reorder_level = "";
		this.reorder_freq_days = "";
		this.lead_days = "";
		this.min_stock_days = "";
		this.min_stock_percentage = "";
		this.req_gen_stg	= "S";
		this.sales_allowed_yn="";//Added for GHL-CRF-0456
		this.consumption_allowed_yn="";//Added for GHL-CRF-0456
		//Added for MMS-DM-CRF-0177
		this.near_expiry_appl="";
		this.durn_value="";
		this.durn_type="";
		this.durn_value_in_days="";
		//Added for MMS-DM-CRF-0177
		this.no_of_days = ""; //MO-CRF-20172 
	}


	public ItemForStoreDetail(String store_code, String item_code, String bin_location_code, String stock_item_yn, String min_stock_qty, String max_stock_qty, String reorder_level, String reorder_freq_days, String lead_days, String min_stock_days, String min_stock_percentage) {
		this.store_code = store_code;
		this.item_code = item_code;
		this.bin_location_code  = bin_location_code;
		this.bin_location_desc  = bin_location_desc;
		this.stock_item_yn  = stock_item_yn;
		this.min_stock_qty = min_stock_qty;
		this.max_stock_qty  =  max_stock_qty;
		this.reorder_level = reorder_level;
		this.reorder_freq_days = reorder_freq_days;
		this.lead_days = lead_days;
		this.min_stock_days = min_stock_days;
		this.min_stock_percentage = min_stock_percentage;
		this.req_gen_stg = "";
		this.sales_allowed_yn="";//Added for GHL-CRF-0456
		this.consumption_allowed_yn="";//Added for GHL-CRF-0456
		//Added for MMS-DM-CRF-0177
		this.near_expiry_appl="";
		this.durn_value="";
		this.durn_type="";
		this.durn_value_in_days="";
		//Added for MMS-DM-CRF-0177
		this.no_of_days = ""; //MO-CRF-20172 
	}
	
	public void setMax_stock_qty(String max_stock_qty) {
		 this.max_stock_qty = max_stock_qty;
	}

	public String getMax_stock_qty( ) {
		 return max_stock_qty;
	}

	public void setMin_stock_percentage(String min_stock_percentage) {
		 this.min_stock_percentage = min_stock_percentage;
	}

	public String getMin_stock_percentage( ) {
		 return min_stock_percentage;
	}

	public void setStore_code(String store_code) {
		 this.store_code = store_code;
	}

	public String getStore_code( ) {
		 return store_code;
	}

	public void setStore_desc(String store_desc) {
		 this.store_desc = store_desc;
	}

	public String getStore_desc( ) {
		 return store_desc;
	}

	public void setReorder_freq_days(String reorder_freq_days) {
		 this.reorder_freq_days = reorder_freq_days;
	}

	public String getReorder_freq_days( ) {
		 return reorder_freq_days;
	}

	public void setMin_stock_days(String min_stock_days) {
		 this.min_stock_days = min_stock_days;
	}

	public String getMin_stock_days( ) {
		 return min_stock_days;
	}

	public void setLead_days(String lead_days) {
		 this.lead_days = lead_days;
	}

	public String getLead_days( ) {
		 return lead_days;
	}

	public void setStock_item_yn(String stock_item_yn) {
		 this.stock_item_yn = stock_item_yn;
	}

	public String getStock_item_yn( ) {
		 return stock_item_yn;
	}

	public void setItem_code(String item_code) {
		 this.item_code = item_code;
	}

	public String getItem_code( ) {
		 return item_code;
	}

	public void setItem_desc(String item_desc) {
		 this.item_desc = item_desc;
	}

	public String getItem_desc( ) {
		 return item_desc;
	}

	public void setReorder_level(String reorder_level) {
		 this.reorder_level = reorder_level;
	}

	public String getReorder_level( ) {
		 return reorder_level;
	}


	public void setBin_location_code(String bin_location_code) {
		 this.bin_location_code = bin_location_code;
	}

	public String getBin_location_code( ) {
		 return bin_location_code;
	}

	public void setBin_location_desc(String bin_location_desc) {
		 this.bin_location_desc = bin_location_desc;
	}

	public String getBin_location_desc( ) {
		 return bin_location_desc;
	}

	public void setMin_stock_qty(String min_stock_qty) {
		 this.min_stock_qty = min_stock_qty;
	}

	public String getMin_stock_qty( ) {
		 return min_stock_qty;
	}

	//code added for Request 
	public void setRequestGenStage(String req_gen_stg){
		this.req_gen_stg = req_gen_stg;
	}

	public String getRequestGenStage(){
		return req_gen_stg;
	}
	//code added for Request UOM

	public void setRequestUOM(String request_uom){
		this.request_uom = request_uom;
	}

	public String getRequestUOM(){
		return request_uom;
	}

	public void setIssueUOM(String issue_uom){
		
		this.issue_uom = issue_uom;
	}

	public String getIssueUOM(){
		return issue_uom;
	}

	public void setPhyinv_type(String phy_inv_type){
		this.phy_inv_type = phy_inv_type;
	}
	public String getPhyinv_type(){
		return phy_inv_type;
	}
	
	public void setPhycountper_year(String phy_inv_count_per_year)
	{
		this.phy_inv_count_per_year=phy_inv_count_per_year;
	}
	public String getPhycountper_year()
	{
		
		return phy_inv_count_per_year;
	}

	public void setReorderqty(String re_order_qty)
	{
		this.re_order_qty=re_order_qty;
	}
	public String getReorderqty()
	{
		return re_order_qty;
	}
	
	
	public void setEff_status(String eff_status){
		this.eff_status = eff_status;
	}

	public String getEff_status(){
		return eff_status;
	}
	

	public void setGen_uom_code(String gen_uom_code){
		this.gen_uom_code = gen_uom_code;
	}

	public String getGen_uom_code(){
		return gen_uom_code;
	}

	//code added for Request UOM


	public void setAll(java.util.Hashtable htResult) {
		setStore_code((String) htResult.get("store_code"));
		setStore_desc((String) htResult.get("store_desc"));
		setItem_code((String) htResult.get("item_code"));
		setItem_desc((String) htResult.get("item_desc"));
		setStock_item_yn((String) htResult.get("stock_item_yn"));
		setMax_stock_qty((String) htResult.get("max_stock_qty"));
		setMin_stock_qty((String) htResult.get("min_stock_qty"));
		setBin_location_code((String) htResult.get("bin_location_code"));
		setBin_location_desc((String) htResult.get("bin_location_desc"));
		setMin_stock_percentage((String) htResult.get("min_stock_percentage"));
		setReorder_freq_days((String) htResult.get("reorder_freq_days"));
		setMin_stock_days((String) htResult.get("min_stock_days"));
		setLead_days((String) htResult.get("lead_days"));
		setReorder_level((String) htResult.get("reorder_level"));
		setRequestGenStage((String) htResult.get("req_gen_stg"));
		setRequestUOM((String) htResult.get("request_uom"));
		setIssueUOM((String) htResult.get("issue_uom"));
		setEff_status((String) htResult.get("Eff_status"));
		setPhyinv_type((String)htResult.get("phy_inv_type"));
		setPhycountper_year((String)htResult.get("phy_inv_count_per_year"));
		setReorderqty((String)htResult.get("reorder_qty"));
		setSales_allowed_yn((String)htResult.get("sales_allowed_yn"));//Added for GHL-CRF-0456
		setConsumption_allowed_yn((String)htResult.get("consumption_allowed_yn"));//Added for GHL-CRF-0456
		//Added for MMS-DM-CRF-0177
		setNearExpiryAppl((String)htResult.get("near_expiry_appl"));
		setDurnValue((String)htResult.get("durn_value"));
		setDurnType((String)htResult.get("durn_type"));
		setDurnValueInDays((String)htResult.get("durn_value_in_days"));
		//Added for MMS-DM-CRF-0177
		//setNo_of_days((String)htResult.get("no_of_days"));//MO-CRF-20172
		setNo_of_days(CommonAdapter.checkForNull((String)htResult.get("no_of_days")));
	}

	public void setMutiple(java.util.Hashtable htResult) {		
		setMax_stock_qty((String) htResult.get("m_max_stock_qty"));
		setMin_stock_qty((String) htResult.get("m_min_stock_qty"));
		setBin_location_code((String) htResult.get("m_bin_location_code"));
		setBin_location_desc((String) htResult.get("m_bin_location_desc"));
		setMin_stock_percentage((String) htResult.get("m_min_stock_percentage"));
		setReorder_freq_days((String) htResult.get("m_reorder_freq_days"));
		setMin_stock_days((String) htResult.get("m_min_stock_days"));
		setLead_days((String) htResult.get("m_lead_days"));
		setReorder_level((String) htResult.get("m_reorder_level"));
		setRequestUOM((String) htResult.get("request_uom"));
		setIssueUOM((String) htResult.get("issue_uom"));
		//code added for Request Generate Stage
		setRequestGenStage((String) htResult.get("m_req_gen_stg"));
		setPhyinv_type((String) htResult.get("phy_inv_type"));
		setPhycountper_year((String)htResult.get("phy_inv_count_per_year"));
		setReorderqty((String)htResult.get("reorder_qty"));

		setSales_allowed_yn((String)htResult.get("sales_allowed_yn"));//Added for GHL-CRF-0456
		setConsumption_allowed_yn((String)htResult.get("consumption_allowed_yn"));//Added for GHL-CRF-0456
		//Added for MMS-DM-CRF-0177
		setNearExpiryAppl((String)htResult.get("near_expiry_appl"));
		setDurnValue((String)htResult.get("durn_value"));
		setDurnType((String)htResult.get("durn_type"));
		setDurnValueInDays((String)htResult.get("durn_value_in_days"));
		//Added for MMS-DM-CRF-0177
		//setNo_of_days((String)htResult.get("NO_OF_DAYS"));//MO-CRF-20172 
		setNo_of_days(CommonAdapter.checkForNull((String)htResult.get("NO_OF_DAYS")));
		System.out.println(" ItemForStoreDetail.java  setMutiple" + (String)htResult.get("no_of_days"));
	}

	public void setAll(java.sql.ResultSet  resultSet) {
		try {

			setItem_desc(CommonAdapter.checkForNull(resultSet.getString("item_desc")));
			setMax_stock_qty(CommonAdapter.checkForNull(resultSet.getString("max_stk_qty")));
			setMin_stock_qty(CommonAdapter.checkForNull(resultSet.getString("min_stk_qty")));
			setStock_item_yn(CommonAdapter.checkForNull(resultSet.getString("stock_item_yn")));
			setBin_location_code(CommonAdapter.checkForNull(resultSet.getString("bin_location_code")));
			setMin_stock_percentage(CommonAdapter.checkForNull(resultSet.getString("percent_min_stock")));
			setReorder_freq_days(CommonAdapter.checkForNull(resultSet.getString("reorder_freq_days")));
			setMin_stock_days(CommonAdapter.checkForNull(resultSet.getString("min_stock_days")));
			setLead_days(CommonAdapter.checkForNull(resultSet.getString("lead_days")));
			setReorder_level(CommonAdapter.checkForNull(resultSet.getString("reorder_level")));
		
			
			//code added for Request Generate Stage
			setRequestGenStage(CommonAdapter.checkForNull(resultSet.getString("request_gen_stage")));
			//code added for Request UOM
			setRequestUOM(CommonAdapter.checkForNull(resultSet.getString("def_request_uom")));
			setIssueUOM(CommonAdapter.checkForNull(resultSet.getString("def_issue_uom")));
			setEff_status(CommonAdapter.checkForNull(resultSet.getString("eff_status")));
			setGen_uom_code(CommonAdapter.checkForNull(resultSet.getString("gen_uom_code")));

			//code added on 16/10/2004 by jagadeesh For phy inv type
			setPhyinv_type(CommonAdapter.checkForNull(resultSet.getString("phy_inv_type")));
			setPhycountper_year(CommonAdapter.checkForNull(resultSet.getString("phy_inv_count_per_year")));
			setReorderqty(CommonAdapter.checkForNull(resultSet.getString("reorder_qty")));
			setSales_allowed_yn(CommonAdapter.checkForNull(resultSet.getString("sales_allowed_yn")));//Added for GHL-CRF-0456
			setConsumption_allowed_yn(CommonAdapter.checkForNull(resultSet.getString("consumption_allowed_yn")));//Added for GHL-CRF-0456
			setAutoRolYN(CommonAdapter.checkForNull(resultSet.getString("AUTO_ROL_CALC_FLAG"),"N"));//Added for  IN:071344 
			//Added for MMS-DM-CRF-0177
			setNearExpiryAppl(CommonAdapter.checkForNull(resultSet.getString("near_expiry_appl")));
			setDurnValue(CommonAdapter.checkForNull(resultSet.getString("durn_value")));
			setDurnType(CommonAdapter.checkForNull(resultSet.getString("durn_type")));
			setDurnValueInDays(CommonAdapter.checkForNull(resultSet.getString("durn_value_in_days")));
			//Added for MMS-DM-CRF-0177
			setNo_of_days(CommonAdapter.checkForNull(resultSet.getString("NO_OF_DAYS")));//MO-CRF-20172  
		}
		catch (Exception exception ) {
			exception.printStackTrace();
		}
	}

	public void setValues(java.util.Hashtable dataValues) {
	}

	public void clear() {
		store_code = "";
		store_desc = "";
		item_code = "";
		item_desc = "";
		bin_location_code = "";
		bin_location_desc = "";
		stock_item_yn = "";
		min_stock_qty = "";
		max_stock_qty = "";
		reorder_level = "";
		reorder_freq_days = "";
		lead_days = "";
		min_stock_days = "";
		min_stock_percentage = "";
		req_gen_stg = "";
		eff_status = "";
		gen_uom_code = "";
		sales_allowed_yn="";//Added for GHL-CRF-0456
		consumption_allowed_yn="";//Added for GHL-CRF-0456
		auto_rol_yn="N";//Added for  IN:071344 
		//Added for MMS-DM-CRF-0177
		near_expiry_appl="";
		durn_value="";
		durn_type="";
		durn_value_in_days="";
		//Added for MMS-DM-CRF-0177
	}


}
