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
14/02/2017		IN060945			Badmavathi B						MMS-DM-CRF-0084 - FDA_CODE added
2/1/2019		IN069010			Shazana								GHL-CRF-0548.1
7/1/2019		IN068781			Shazana								GHL-CRF-0549.1
07/05/2019      IN:069013           B Haribabu                          AMS-CRF-0204.1[Modified sitespecific logic]
09/09/2022	    IN:32744												TH-KW-CRF-0046
/---------------------------------------------------------------------------------------------------------/
*/ 
package eMM ;

import java.io.* ;
import java.util.* ;
import java.sql.* ;
import java.sql.Clob.* ;
import javax.servlet.* ;
import javax.servlet.http.*;

import javax.rmi.* ;
import javax.naming.* ;
import eMM.Common.* ;
import eCommon.Common.*;
import eCommon.SingleTableHandler.*;

public class ItemMasterBean extends MmAdapter implements Serializable {
	protected String item_code				= "" ;
	protected String fda_code				= "" ;//Added for MMS-DM-CRF-0084
	protected String alpha_code				= "" ;
	protected String hsn_no				= "" ;//  Added for AMS-CRF-0127
	protected String long_desc				= "" ;
	protected String short_desc				= "" ;
 	protected String eff_status				= "D" ;
 	protected String item_remarks			= "" ;
	protected String item_specification		= "" ;
	protected String category_type_code		= "" ;
	protected String material_group_code	= "" ;
	protected String gen_uom_code 			= "" ;
	//protected String pr_based_budget_yn		= "N" ;
	protected String unit_cost				= "0"	;
	protected String sole_source_yn			= "N" ;
	protected String curr_supp_code			= "" ;
	protected String item_tech_code			= "" ;// GHL-CRF-0548.1
	protected String curr_supp_desc			= "" ;
	protected String item_tech_desc			= "" ;// GHL-CRF-0548.1
	protected String special_item_yn		= "N" ;
	//protected String pur_uom_code			= "" ;
	//protected String pur_gen_uom_conv		= "" ;
	//protected String qty_on_order			= "" ;
	protected String item_class_code		= "" ;
	protected String item_anal1_code		= "" ;
	protected String item_anal2_code		= "" ;
	protected String item_anal3_code		= "" ;
	//protected String last_pur_advice_date	= "" ;
//	protected String language_id;
	protected String cssd_component_yn      = "N" ;
	protected String manufacturer_id        = "" ;
	protected String ps_item_yn		        = "N" ;
	protected int initial_cost				= 0  ;
	protected String current_cost_date      = "" ;        
	protected int last_cost					= 0  ;        
	protected String last_cost_date         = "" ;        
	protected int next_last_cost			= 0  ;        
	protected String next_last_cost_date    = "" ;        
	protected String last_receipt_date      = "" ;
	protected String billing_item_yn		= "N";
	protected String direct_sale_allowed_yn = "N";
	protected String imported_item			= "N";
	protected String essential_item			= "N";
	protected String reimburse_type			= "N";
	protected String reimbursable_item_yn	= "N";
	protected String package_item_yn	= "N";
//	protected String item_spec		= "";

	protected String place_of_origin	= ""; //Added by sakti against CRF - 12 inc#29966
	
	protected String shelf_life_no		= ""; //Added by Padmapriya against CRF - 108 inc#30067
	protected String shelf_life_time	= ""; //Added by Padmapriya against CRF - 108 inc#30067
	protected boolean issite	=false;   //AMS-CRF-0127 -saran
//	Clob   item_spec;
	
	/*added for GHL-CRF-0549.1 START*/
	protected String low_cost_item				= "" ;
	protected String high_margin_item				= "" ;
	protected String innovator_item				= "" ;
	protected boolean issiteSpecific	=false; 
	protected String price_type				= "" ; //TH-KW-CRF-0046
	protected String category_code          = "" ; //Added for MMS-DM-CRF-0209.2 
    protected String alternate_yn           = "" ; //Added for MMS-DM-CRF-0209.2 
	
	public boolean isIssiteSpecific() {
		return issiteSpecific;
	}

	public void setIssiteSpecific(boolean issiteSpecific) {
		this.issiteSpecific = issiteSpecific;
	}

	public String getLowCostItem() {
		return low_cost_item;
	}

	public void setLowCostItem(String low_cost_item) {
		this.low_cost_item = low_cost_item;
	}

	public String getHighCostItem() {
		return high_margin_item;
	}

	public void setHighCostItem(String high_cost_item) {
		this.high_margin_item = high_cost_item;
	}

	public String getInnovatorItem() {
		return innovator_item;
	}

	public void setInnovatorItem(String innovator_item) {
		this.innovator_item = innovator_item;
	}
	
	/*added for GHL-CRF-0549.1 END*/
	
	
	//added for ams-crf-0127 start
	public boolean isIssite() {
		return issite;
	}

	public void setIssite(boolean issite) {
		this.issite = issite;
	}//added for ams-crf-0127 end
	public ItemMasterBean() throws Exception
	{
		try {
			doCommon();
		}catch(Exception e) {
			e.printStackTrace() ;
		}
	}

	/* Set Methods Start */
	public void setItemCode( String item_code ) {
		this.item_code = checkForNull(item_code)  ;
	}

	public void setFda_code(String fda_code) {//Added for MMS-DM-CRF-0084
		this.fda_code = checkForNull(fda_code) ;
	}
	public void setAlphaCode( String alpha_code ) {
		this.alpha_code = checkForNull(alpha_code)  ;
	}

	public void setHsnNo( String hsn_no ) { //added for AMS-CRF-0127 - Start
		this.hsn_no = checkForNull(hsn_no)  ;
	} //added for AMS-CRF-0127 - End
	public void setBillableItemYN(String billing_item_yn){
		this.billing_item_yn = checkForNull(billing_item_yn,"N");
	}

	public void setPackageItemYN(String package_item_yn){
		this.package_item_yn = checkForNull(package_item_yn,"N");
	}
// @ -----direct_sale_allowed_yn

	public void setDirectSaleAllowedYN(String direct_sale_allowed_yn){
		this.direct_sale_allowed_yn = checkForNull(direct_sale_allowed_yn,"N");
	}


	public void setLongDesc( String long_desc ) {
		this.long_desc = checkForNull(long_desc)  ;
	} 
/*	public void setLanguageId (String language_id)
	{
		this.language_id = language_id;
	}
*/
	public void setShortDesc( String short_desc ) {

		try	{
			/*InputStreamReader inputstreamreader = new InputStreamReader(new ByteArrayInputStream(atc_class_l3_desc.getBytes()), "windows-1256");
            atc_class_l3_desc = (new BufferedReader(inputstreamreader)).readLine(); */

			this.short_desc = checkForNull(short_desc)  ;
		}
		catch(Exception e){
			e.printStackTrace() ;
		}
	}

	/*public void setDispSeqNo( int disp_seq_no ) {
		this.disp_seq_no  = disp_seq_no ;
	}*/

	public void setEffStatus ( String eff_status ) {
		this.eff_status = checkForNull(eff_status) ;
	}

	public void setRemarks( String item_remarks ) {
		this.item_remarks = checkForNull(item_remarks)  ;
	}

	public void setSpecification( String item_specification ) {
		this.item_specification = checkForNull(item_specification)  ;
		}

	public void setUOM( String gen_uom_code ) {
		this.gen_uom_code = checkForNull(gen_uom_code)  ;
	}

	public void setUnitCost( String unit_cost ) {
		this.unit_cost = unit_cost  ;
	}

	public void setMaterialCode( String material_group_code ) {
		this.material_group_code = checkForNull(material_group_code)  ;
	}

	public void setCategoryCode( String category_type_code ) {
		this.category_type_code = checkForNull(category_type_code)  ;
	}

	/*public void setPrBudget( String pr_based_budget_yn ) {
		this.pr_based_budget_yn = pr_based_budget_yn  ;
	}*/

	public void setSoleSource( String sole_source_yn ) {
		this.sole_source_yn = checkForNull(sole_source_yn)  ;
	}

	public void setSupplierCode( String curr_supp_code ) {
		this.curr_supp_code = checkForNull(curr_supp_code)  ;
	}

	public void setSupplierDesc( String curr_supp_desc ) {
		this.curr_supp_desc = checkForNull(curr_supp_desc)  ;
	}
/*Sharanraj GHL-CRF-0548.1 Starts*/
	public void setItemTechDesc( String Item_Tech_Desc ) {
		this.item_tech_desc = checkForNull(Item_Tech_Desc)  ;
	}
	public void setItemTechCode( String Item_Tech_Code ) {
		this.item_tech_code = checkForNull(Item_Tech_Code)  ;
	}
/*sharanraj GHL-CRF-0548.1 ends*/	
	public void setSpecialItem( String special_item_yn ) {

		this.special_item_yn = checkForNull(special_item_yn)  ;
	}

	/*public void setPurchaseUOM( String pur_uom_code ) {
		this.pur_uom_code = pur_uom_code  ;
	}

	public void setConversionFactor( String pur_gen_uom_conv ) {
		this.pur_gen_uom_conv = pur_gen_uom_conv  ;
	}

	public void setQtyOnOrder( String qty_on_order ) {
		this.qty_on_order = qty_on_order  ;
	}

	public void setLastPurAdviceDt( String last_pur_advice_date ) {
		this.last_pur_advice_date = last_pur_advice_date  ;
	}*/

	public void setItemClass( String item_class_code ) {
		this.item_class_code = checkForNull(item_class_code)  ;
	}

	public void setItemAnal1Code( String item_anal1_code ) {
		this.item_anal1_code = checkForNull(item_anal1_code)  ;
	}

	public void setItemAnal2Code( String item_anal2_code ) {
		this.item_anal2_code = checkForNull(item_anal2_code)  ;
	}

	public void setItemAnal3Code( String item_anal3_code ) {
		this.item_anal3_code = checkForNull(item_anal3_code)  ;
	}

	public void setCSSDComponent( String cssd_component_yn ) {
		this.cssd_component_yn = checkForNull(cssd_component_yn)  ;
	}

	public void setManufacturer( String manufacturer_id ) {
		this.manufacturer_id = checkForNull(manufacturer_id)  ;
	}

	public void setPsItem( String ps_item_yn ) {
		this.ps_item_yn = checkForNull(ps_item_yn)  ;
	}

	public void setInitialCost( int initial_cost ) {
		this.initial_cost = initial_cost  ;
	}

	public void setCurrentCostDate( String current_cost_date ) {
		this.current_cost_date = checkForNull(current_cost_date)  ;
	}

	public void setLastCost( int last_cost ) {
		this.last_cost = last_cost  ;
	}

	public void setLastCostDate( String last_cost_date ) {
		this.last_cost_date = checkForNull(last_cost_date)  ;
	}

	public void setNextLastCost( int next_last_cost ) {
		this.next_last_cost = next_last_cost  ;
	}

	public void setNextLastCostDate( String next_last_cost_date ) {
		this.next_last_cost_date = checkForNull(next_last_cost_date)  ;
	}

	public void setLastReceiptDate( String last_receipt_date ) {
		this.last_receipt_date = checkForNull(last_receipt_date)  ;
	}
	
	public void setImportedItem( String imported_item ) {
		this.imported_item = checkForNull(imported_item)  ;
	}
	
	public void setEssentialItem( String essential_item ) {
		this.essential_item = checkForNull(essential_item)  ;
	}
	
	public void setReimburseType( String reimburse_type ) {
		this.reimburse_type = checkForNull(reimburse_type)  ;
	}
	public void setReimbursableItemYN( String reimbursable_item_yn ) {
		this.reimbursable_item_yn = checkForNull(reimbursable_item_yn)  ;
	}

	public void setPlaceOfOrigin(String place_of_origin)
	{
		this.place_of_origin=checkForNull(place_of_origin);
	}
	
	public void setShelf_life_no(String shelf_life_no)
	{
		this.shelf_life_no=checkForNull(shelf_life_no);
	}
	public void setShelf_life_time(String shelf_life_time)
	{
		this.shelf_life_time=checkForNull(shelf_life_time);
	}
	
	public void setPriceType(String price_type)  //TH-KW-CRF-0046
	{
		this.price_type=checkForNull(price_type);
	}

	//Added for MMS-DM-CRF-0209.2 starts
		public void setCategory(String category_code) {
			if (category_code == null) {
				this.category_code = "";
			} else {
				this.category_code = category_code;
			}
		}

		public void setAlternate(String alternate_yn) {
			if (category_code == null) {
				this.alternate_yn = "";
			} else {
				this.alternate_yn = alternate_yn;
			}

		}
		
		//Added for MMS-DM-CRF-0209.2 ends
		
	/* Set Methods End */


	/* Get Methods Start */
	public String getItemCode() {
		return this.item_code;
	}
	public String getFda_code() {//Added for MMS-DM-CRF-0084
		return this.fda_code;
	}

	public String getBillableItemYN(){
		return this.billing_item_yn;
	}

	public String getPackageItemYN(){
		return this.package_item_yn;
	}
	
//@-----direct_sale_allowed_yn

	public String getDirectSaleAllowedYN(){
		return this.direct_sale_allowed_yn;
	}

	public String getAlphaCode() {
		return this.alpha_code;
	}

	public String getHsnNo() { //added for AMS-CRF-0127 - Start
		return this.hsn_no;
	} //added for AMS-CRF-0127  - End
	public String getLongDesc() {
		return this.long_desc;
	}

	public String getShortDesc() {
		return this.short_desc;

	}

	public String getEffStatus () {
		return this.eff_status;
	}

	public String getRemarks() {
		return this.item_remarks;
	}

	public String getSpecification() {
		return this.item_specification;
	}

	public String getUOM() {
		return this.gen_uom_code;
	}

	public String getUnitCost() {
		return this.unit_cost;
	}

	public String getMaterialCode() {
		return this.material_group_code;
	}
	
/*	public String getLanguageId() 
	{
		return this.language_id;
	}*/
	public String getCategoryCode() {
		return this.category_type_code;
	}

	/*public String getPrBudget() {
		return this.pr_based_budget_yn;
	}*/

	public String getSoleSource()
	{
		return this.sole_source_yn;
	}

	public String getSupplierCode()
	{
		return this.curr_supp_code;
	}
	
	public String getSupplierDesc()
	{
		return this.curr_supp_desc;
	}
	/*Sharanraj GHL-CRF-0548.1 starts*/
	public String getItemTechDesc()
	{
		return this.item_tech_desc;
	}
	public String getItemTechCode()
	{
		return this.item_tech_code;
	}
	/*Sharanraj GHL-CRF-0548.1 ends*/
	public String getSpecialItem()
	{
		return this.special_item_yn;
	}

	/*public String getPurchaseUOM()
	{
		return this.pur_uom_code;
	}

	public String getConversionFactor()
	{
		return this.pur_gen_uom_conv;
	}

	public String getQtyOnOrder()
	{
		return this.qty_on_order;
	}

	public String getLastPurAdviceDt()
	{
		return this.last_pur_advice_date;
	}*/

	public String getItemClass()
	{
		return this.item_class_code;
	}

	public String getItemAnal1Code()
	{
		return this.item_anal1_code;
	}

	public String getItemAnal2Code()
	{
		return this.item_anal2_code;
	}

	public String getItemAnal3Code()
	{
		return this.item_anal3_code;
	}
	
	public String getCSSDComponent()
	{
		return this.cssd_component_yn;
	}

	public String getManufacturer()
	{
		return this.manufacturer_id;
	}

	public String getPsItem() 
	{
		return this.ps_item_yn;
	}

	public int getInitialCost()
	{
		return this.initial_cost;
	}

	public String getCurrentCostDate()
	{
		return this.current_cost_date;
	}

	public int getLastCost()
	{
		return this.last_cost;
	}

	public String getLastCostDate()
	{
		return this.last_cost_date;
	}

	public int getNextLastCost()
	{
		return this.next_last_cost;
	}

	public String getNextLastCostDate()
	{
		return this.next_last_cost_date;
	}

	public String getLastReceiptDate()
	{
		return this.last_receipt_date;
	}
	public String getImportedItem()
	{
		return this.imported_item;
	}
	public String getEssentialItem()
	{
		return this.essential_item;
	}
	public String getReimburseType()
	{
		return this.reimburse_type;
	}
	public String getReimbursableItemYN()
	{
		return this.reimbursable_item_yn;
	}

	public String getPlaceOfOrigin()
	{
		return this.place_of_origin;
	}
	
	public String getShelf_life_no()
	{
		return this.shelf_life_no;
	}
	
	public String getShelf_life_time()
	{
		return this.shelf_life_time;
	}

	public String getPriceType()  //TH-KW-CRF-0046
	{
		return this.price_type;
	}
	
	//Method added for finding Billing Module is installed or not...on 18/5/2004
	public String getBLModuleInstalled() throws Exception
	{
		HashMap result = fetchRecord(eMM.Common.MmRepository.getMmKeyValue( "SQL_MM_ITEM_BILLING_YN"));
//		String result_yn = (String)result.get("INSTALL_YN");
		String result_yn = "N";
		int icount = Integer.parseInt((String)result.get("CNT"));
		if (icount > 0)
			result_yn = "Y";
		
		return result_yn;
		

	}
	
	//Added for MMS-DM-CRF-0209.2 starts
		public String getCategory() {
			if (category_code == null)
				return ("");
			return category_code;
		}

		public String getAlternate() {
			if (alternate_yn == null)
				return ("");
			return alternate_yn;
		}

	//Added for MMS-DM-CRF-0209.2 ends
	/* Get Methods End */

	/* Over-ridden Adapter methods start here */
	public HashMap validate() throws Exception
	{
		HashMap map = new HashMap();
		map.put( "result", new Boolean( true ) ) ;
		return map;
	}

	public HashMap modify()
	{
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
	
		HashMap tabData = new HashMap() ;

		ArrayList ModifyData = new ArrayList();
		
		ModifyData.add(category_type_code);
		ModifyData.add(checkForNull(material_group_code));
		ModifyData.add(alpha_code);
		ModifyData.add(long_desc);
		ModifyData.add(short_desc);
		ModifyData.add(item_remarks);
		ModifyData.add(getSpecification());
		ModifyData.add(sole_source_yn);
		ModifyData.add(checkForNull(curr_supp_code));
		ModifyData.add(checkForNull(item_tech_code));//Sharanraj GHL-CRF-0548.1
		ModifyData.add(special_item_yn);
		ModifyData.add(gen_uom_code);
		//ModifyData.add(pur_uom_code);
		//ModifyData.add(pur_gen_uom_conv);
		ModifyData.add(item_class_code);
		ModifyData.add(item_anal1_code);
		ModifyData.add(item_anal2_code);
		ModifyData.add(item_anal3_code);
		//ModifyData.add(qty_on_order);
		//ModifyData.add(last_pur_advice_date);
		//ModifyData.add(pr_based_budget_yn);

		ModifyData.add(cssd_component_yn);
		ModifyData.add(manufacturer_id);
		ModifyData.add(ps_item_yn);
		ModifyData.add(new Integer(initial_cost));
		ModifyData.add(current_cost_date);
		ModifyData.add(new Integer(last_cost));
		ModifyData.add(last_cost_date);
		ModifyData.add(new Integer(next_last_cost));
		ModifyData.add(next_last_cost_date);
		ModifyData.add(last_receipt_date);

		ModifyData.add(unit_cost);
		ModifyData.add(billing_item_yn);
		ModifyData.add(eff_status);
		ModifyData.add(imported_item);
		ModifyData.add(essential_item);
		ModifyData.add(reimbursable_item_yn);
		ModifyData.add(reimburse_type);
		ModifyData.add(price_type); // Added for TH-KW-CRF-0046
		ModifyData.add(login_by_id);
		ModifyData.add(login_at_ws_no);
		ModifyData.add(login_facility_id);
//@---
		ModifyData.add(direct_sale_allowed_yn);
		ModifyData.add(package_item_yn);
		ModifyData.add(place_of_origin);
		System.out.println("shelf_life_no in modify bean = "+shelf_life_no);
		if(!shelf_life_no.equals(""))
			ModifyData.add(shelf_life_no+shelf_life_time);
		else
			ModifyData.add(shelf_life_no);
		ModifyData.add(fda_code);//Added for MMS-DM-CRF-0084
		//Added for AMS-CRF-0127 starts
		if(issite)
		{
			ModifyData.add(hsn_no);
		}
		//Added for AMS-CRF-0127 ends
		//Added for GHL-CRF-0549.1 STARTS
				if(issiteSpecific){
					ModifyData.add(low_cost_item);
					ModifyData.add(innovator_item);
					ModifyData.add(high_margin_item);
					
				} //Added for GHL-CRF-0549.1 ENDS
				// Added for MMS-DM-CRF-0209.2 starts
					ModifyData.add(checkForNull(category_code));
					ModifyData.add(checkForNull(alternate_yn));
				// Added for MMS-DM-CRF-0209.2 ends
				
		ModifyData.add(item_code);
	
		tabData.put( "ModifyData",	ModifyData ) ;
		tabData.put( "properties",	getProperties() ) ;
		
		HashMap sqlMap = new HashMap() ;
		//sqlMap.put( "ModifySQL", MmInterface.SQL_MM_ITEM_MASTER_UPDATE );

//		SingleTableHandlerHome home = null ;
		SingleTableHandlerRemote remote = null ;
			try 
			{

				//sqlMap.put("ModifySQL", MmRepository.getMmKeyValue( "SQL_MM_ITEM_MASTER_UPDATE" ));
				//sqlMap.put("ModifySQL","UPDATE mm_item SET category_type_code = ? , material_group_code = ? , alpha_code = ? , long_desc = ? ,short_desc = ? , item_remarks = ? , item_specification = ? , sole_source_yn = ? , curr_supp_code = ? , special_item_yn = ? , gen_uom_code = ? , item_class_code = ? , item_anal1_code = ? , item_anal2_code = ? , item_anal3_code = ? ,cssd_component_yn = ?,manufacturer_id = ?,ps_item_yn = ?,initial_cost = ?,current_cost_date = TO_DATE(?,'dd/mm/yyyy'), last_cost = ? ,last_cost_date = TO_DATE(?,'dd/mm/yyyy'), next_last_cost = ?, next_last_cost_date = TO_DATE(?,'dd/mm/yyyy') ,last_receipt_date = TO_DATE(?,'dd/mm/yyyy'),unit_cost = ? , billable_item_yn =? ,eff_status = ?,imported_item_yn=?,essential_item_yn=?,reimbursable_item_yn=?,reimbursable_ind=?, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? ,direct_sale_allowed_yn = ?, package_item_yn = ?,place_of_origin = ?, shelf_life = ? WHERE item_code = ?");
				//start AMS-CRF-0127, GHL-CRF-0549.1 
				if(issite == true && issiteSpecific == false ){
				sqlMap.put("ModifySQL","UPDATE mm_item SET category_type_code = ? , material_group_code = ? , alpha_code = ? , long_desc = ? ,short_desc = ? , item_remarks = ? , item_specification = ? , sole_source_yn = ? , curr_supp_code = ? ,Item_Tech_Code= ?, special_item_yn = ? , gen_uom_code = ? , item_class_code = ? , item_anal1_code = ? , item_anal2_code = ? , item_anal3_code = ? ,cssd_component_yn = ?,manufacturer_id = ?,ps_item_yn = ?,initial_cost = ?,current_cost_date = TO_DATE(?,'dd/mm/yyyy'), last_cost = ? ,last_cost_date = TO_DATE(?,'dd/mm/yyyy'), next_last_cost = ?, next_last_cost_date = TO_DATE(?,'dd/mm/yyyy') ,last_receipt_date = TO_DATE(?,'dd/mm/yyyy'),unit_cost = ? , billable_item_yn =? ,eff_status = ?,imported_item_yn=?,essential_item_yn=?,reimbursable_item_yn=?,reimbursable_ind=?, price_type = ?, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? ,direct_sale_allowed_yn = ?, package_item_yn = ?,place_of_origin = ?, shelf_life = ?, fda_code=?,hsn_no=?,category_code = ?,alternate_yn =?  WHERE item_code = ?");//Added for AMS-CRF-0127,Added for MMS-DM-CRF-0084,GHL-CRF-0548.1 //price_type added for TH-KW-CRF-0046//category_code and alternate_yn added for MMS-DM-CRF-0209
				}
				else if (issite == true && issiteSpecific == true ){
					sqlMap.put("ModifySQL","UPDATE mm_item SET category_type_code = ? , material_group_code = ? , alpha_code = ? , long_desc = ? ,short_desc = ? , item_remarks = ? , item_specification = ? , sole_source_yn = ? , curr_supp_code = ? ,Item_Tech_Code= ?, special_item_yn = ? , gen_uom_code = ? , item_class_code = ? , item_anal1_code = ? , item_anal2_code = ? , item_anal3_code = ? ,cssd_component_yn = ?,manufacturer_id = ?,ps_item_yn = ?,initial_cost = ?,current_cost_date = TO_DATE(?,'dd/mm/yyyy'), last_cost = ? ,last_cost_date = TO_DATE(?,'dd/mm/yyyy'), next_last_cost = ?, next_last_cost_date = TO_DATE(?,'dd/mm/yyyy') ,last_receipt_date = TO_DATE(?,'dd/mm/yyyy'),unit_cost = ? , billable_item_yn =? ,eff_status = ?,imported_item_yn=?,essential_item_yn=?,reimbursable_item_yn=?,reimbursable_ind=?, price_type = ?, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? ,direct_sale_allowed_yn = ?, package_item_yn = ?,place_of_origin = ?, shelf_life = ?, fda_code=?,hsn_no=? ,LOW_COST_ITEM = ?,INNOVATOR_ITEM = ?,HIGH_MARGIN_ITEM = ?,category_code = ?,alternate_yn =?   WHERE item_code = ?");//Added for AMS-CRF-0127,Added for MMS-DM-CRF-0084,GHL-CRF-0548.1,GHL-CRF-0549.1 //price_type added for TH-KW-CRF-0046//category_code and alternate_yn added for MMS-DM-CRF-0209
				}//Added for IN:069013 start
				else if (issite == false && issiteSpecific == true ){
					sqlMap.put("ModifySQL","UPDATE mm_item SET category_type_code = ? , material_group_code = ? , alpha_code = ? , long_desc = ? ,short_desc = ? , item_remarks = ? , item_specification = ? , sole_source_yn = ? , curr_supp_code = ? ,Item_Tech_Code= ?, special_item_yn = ? , gen_uom_code = ? , item_class_code = ? , item_anal1_code = ? , item_anal2_code = ? , item_anal3_code = ? ,cssd_component_yn = ?,manufacturer_id = ?,ps_item_yn = ?,initial_cost = ?,current_cost_date = TO_DATE(?,'dd/mm/yyyy'), last_cost = ? ,last_cost_date = TO_DATE(?,'dd/mm/yyyy'), next_last_cost = ?, next_last_cost_date = TO_DATE(?,'dd/mm/yyyy') ,last_receipt_date = TO_DATE(?,'dd/mm/yyyy'),unit_cost = ? , billable_item_yn =? ,eff_status = ?,imported_item_yn=?,essential_item_yn=?,reimbursable_item_yn=?,reimbursable_ind=?, price_type = ?, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? ,direct_sale_allowed_yn = ?, package_item_yn = ?,place_of_origin = ?, shelf_life = ?, fda_code=?,LOW_COST_ITEM = ?,INNOVATOR_ITEM = ?,HIGH_MARGIN_ITEM = ?,category_code = ?,alternate_yn =?   WHERE item_code = ?");//category_code and alternate_yn added for MMS-DM-CRF-0209
				}//Added for IN:069013 end  //price_type added for TH-KW-CRF-0046
					
				else
				{
					sqlMap.put("ModifySQL","UPDATE mm_item SET category_type_code = ? , material_group_code = ? , alpha_code = ? , long_desc = ? ,short_desc = ? , item_remarks = ? , item_specification = ? , sole_source_yn = ? , curr_supp_code = ? ,Item_Tech_Code= ?, special_item_yn = ? , gen_uom_code = ? , item_class_code = ? , item_anal1_code = ? , item_anal2_code = ? , item_anal3_code = ? ,cssd_component_yn = ?,manufacturer_id = ?,ps_item_yn = ?,initial_cost = ?,current_cost_date = TO_DATE(?,'dd/mm/yyyy'), last_cost = ? ,last_cost_date = TO_DATE(?,'dd/mm/yyyy'), next_last_cost = ?, next_last_cost_date = TO_DATE(?,'dd/mm/yyyy') ,last_receipt_date = TO_DATE(?,'dd/mm/yyyy'),unit_cost = ? , billable_item_yn =? ,eff_status = ?,imported_item_yn=?,essential_item_yn=?,reimbursable_item_yn=?,reimbursable_ind=?, price_type = ?, modified_by_id = ? , modified_date = SYSDATE , modified_at_ws_no = ? , modified_facility_id = ? ,direct_sale_allowed_yn = ?, package_item_yn = ?,place_of_origin = ?, shelf_life = ?, fda_code=?,category_code = ?,alternate_yn =?  WHERE item_code = ?"); //modified for GHL-CRF-0548.1  //price_type added for TH-KW-CRF-0046//category_code and alternate_yn added for MMS-DM-CRF-0209
				}//End AMS-CRf-0127
			/*	InitialContext context = new InitialContext() ;
				//Object object = context.lookup( MmInterface.JNDI_SINGLE_TABLE_HANDLER ) ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;

				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.modify( tabData, sqlMap ) ;*/

				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
		Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

		Object argArray[] = new Object[2];
		argArray[0] = tabData;
		argArray[1] = sqlMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = tabData.getClass(); ;
		paramArray[1] = sqlMap.getClass();

		map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


				if( ((Boolean) map.get( "result" )).booleanValue() )		
					map.put("message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
				else
					map.put("message",map.get("msgid"));		

			}
			catch(Exception e)
			{
				map.put( "message", e.getMessage() ) ;
				e.printStackTrace() ;
			}
			finally
			{
			try {
					if( remote != null )
						remote.remove() ;
				} 
				catch( Exception ee )
				{
					map.put( "message", ee.getMessage() ) ;
					ee.printStackTrace();
				}
			}

		return map ;
	} 

	public HashMap insert()
	{
	
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;
		HashMap tabData = new HashMap() ;
		ArrayList WhereData = new ArrayList();
		ArrayList InsertData = new ArrayList();

		InsertData.add(item_code);
		InsertData.add(category_type_code);
		
		InsertData.add(material_group_code);
		InsertData.add(alpha_code);
		InsertData.add(long_desc);
		InsertData.add(short_desc);
		InsertData.add(item_remarks);
		InsertData.add(getSpecification());
		InsertData.add(sole_source_yn);
		InsertData.add(curr_supp_code);
		InsertData.add(special_item_yn);
		InsertData.add(gen_uom_code);
		//InsertData.add(pur_uom_code);
		//InsertData.add(pur_gen_uom_conv);
		InsertData.add(item_class_code);
		InsertData.add(item_anal1_code);
		InsertData.add(item_anal2_code);
		InsertData.add(item_anal3_code);
		//InsertData.add(qty_on_order);
		//InsertData.add(last_pur_advice_date);
		//InsertData.add(pr_based_budget_yn);

		InsertData.add(cssd_component_yn);
		InsertData.add(manufacturer_id);
		InsertData.add(ps_item_yn);
		InsertData.add(new Integer(initial_cost));
		InsertData.add(current_cost_date);
		InsertData.add(new Integer(last_cost));
		InsertData.add(last_cost_date);
		InsertData.add(new Integer(next_last_cost));
		InsertData.add(next_last_cost_date);
		InsertData.add(last_receipt_date);

		InsertData.add(unit_cost);
		InsertData.add(billing_item_yn);
		InsertData.add(eff_status);
		InsertData.add(imported_item);
		InsertData.add(essential_item);
		InsertData.add(reimbursable_item_yn);
		InsertData.add(reimburse_type);
		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);
		InsertData.add(login_by_id);
		InsertData.add(login_at_ws_no);
		InsertData.add(login_facility_id);
// @---
		InsertData.add(direct_sale_allowed_yn);
		InsertData.add(package_item_yn);
		InsertData.add(place_of_origin);
		System.out.println("shelf_life_no in insert bean = "+shelf_life_no);
		if(!shelf_life_no.equals(""))
			InsertData.add(shelf_life_no+shelf_life_time);
		else
			InsertData.add(shelf_life_no);
		InsertData.add(fda_code);//Added for MMS-DM-CRF-0084
		//Added for AMS-CRF-0127 starts
		if(issite)
		{	
			InsertData.add(hsn_no);
		}
		//Added for GHL-CRF-0549.1 STARTS
		if(issiteSpecific){
			InsertData.add(low_cost_item);
			InsertData.add(innovator_item);
			InsertData.add(high_margin_item);
			
		} //Added for GHL-CRF-0549.1 ENDS
		//Added for AMS-CRF-0127 ends
		InsertData.add(item_tech_code);//Sharanraj GHL-CRF-0548.1
	
		InsertData.add(price_type); //added for TH-KW-CRF-0046
		
		// Added for MMS-DM-CRF-0209.2 starts
		InsertData.add(checkForNull(category_code));
		InsertData.add(checkForNull(alternate_yn));		
		// Added for MMS-DM-CRF-0209.2 ends
		
		WhereData.add(item_code);

		tabData.put( "InsertData",	InsertData ) ;
		tabData.put( "WhereData",	WhereData ) ;
		tabData.put( "properties",	getProperties() ) ;
		HashMap sqlMap = new HashMap() ;
		//sqlMap.put( "InsertSQL", MmInterface.SQL_MM_ITEMMASTER_INSERT );
		//sqlMap.put( "SelectSQL", MmInterface.SQL_MM_ITEMMASTER_EXISTS );

//		SingleTableHandlerHome home = null ;
		SingleTableHandlerRemote remote = null ;
				try {

				//sqlMap.put( "InsertSQL", MmRepository.getMmKeyValue( "SQL_MM_ITEMMASTER_INSERT" ));
				//sqlMap.put( "InsertSQL", "INSERT INTO mm_item ( item_code, category_type_code, material_group_code,alpha_code, long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code, special_item_yn, gen_uom_code, item_class_code, item_anal1_code,item_anal2_code, item_anal3_code, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost,current_cost_date,last_cost,last_cost_date,next_last_cost,next_last_cost_date,last_receipt_date, unit_cost, billable_item_yn ,eff_status,imported_item_yn,essential_item_yn,reimbursable_item_yn,reimbursable_ind, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,direct_sale_allowed_yn,package_item_yn,place_of_origin,shelf_life ) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? ,? , ? , ? , ? , ? , ? , ? , ?, ?, ?, ?, ?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),? , ?,? , ?,?,?,?,?, SYSDATE , ? , ? ,? ,SYSDATE , ? , ? ,?,?,?,? )" );	   				
				//start AMS-CRF-0127 
					if(issite == true && issiteSpecific == false )
					sqlMap.put( "InsertSQL", "INSERT INTO mm_item ( item_code, category_type_code, material_group_code,alpha_code,long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code,special_item_yn, gen_uom_code, item_class_code, item_anal1_code,item_anal2_code, item_anal3_code, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost,current_cost_date,last_cost,last_cost_date,next_last_cost,next_last_cost_date,last_receipt_date, unit_cost, billable_item_yn ,eff_status,imported_item_yn,essential_item_yn,reimbursable_item_yn,reimbursable_ind, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,direct_sale_allowed_yn,package_item_yn,place_of_origin,shelf_life,fda_code,hsn_no,Item_Tech_Code,price_type,category_code,alternate_yn) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? ,? , ? , ? , ? , ? , ? , ? , ?, ?, ?, ?, ?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),? , ?,? , ?,?,?,?,?, SYSDATE , ? , ? ,? ,SYSDATE , ? , ? ,?,?,?,?,?,?,?, ?,?,?)" );//Added for AMS-CRF-0127,Added for MMS-DM-CRF-0084, GHL-CRF-0548.1 //price_type added for TH-KW-CRF-0046//category_code and alternate_yn added for MMS-DM-CRF-0209.2
					else if (issite == true && issiteSpecific == true )
						sqlMap.put( "InsertSQL", "INSERT INTO mm_item ( item_code, category_type_code, material_group_code,alpha_code,long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code, special_item_yn, gen_uom_code, item_class_code, item_anal1_code,item_anal2_code, item_anal3_code, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost,current_cost_date,last_cost,last_cost_date,next_last_cost,next_last_cost_date,last_receipt_date, unit_cost, billable_item_yn ,eff_status,imported_item_yn,essential_item_yn,reimbursable_item_yn,reimbursable_ind, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,direct_sale_allowed_yn,package_item_yn,place_of_origin,shelf_life,fda_code,hsn_no,LOW_COST_ITEM,INNOVATOR_ITEM,HIGH_MARGIN_ITEM, Item_Tech_Code, price_type,category_code,alternate_yn ) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? ,? , ? , ? , ? , ? , ? , ? , ?, ?, ?, ?, ?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),? , ?,? , ?,?,?,?,?, SYSDATE , ? , ? ,? ,SYSDATE , ? , ? ,?,?,?,?,?,?,?,?,?,?, ?,?,?)" );//Added for GHL-CRF-0549.1 //price_type added for TH-KW-CRF-0046//category_code and alternate_yn added for MMS-DM-CRF-0209.2
					else if (issite == false && issiteSpecific == true )
						sqlMap.put( "InsertSQL", "INSERT INTO mm_item ( item_code, category_type_code, material_group_code,alpha_code,long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code, special_item_yn, gen_uom_code, item_class_code, item_anal1_code,item_anal2_code, item_anal3_code, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost,current_cost_date,last_cost,last_cost_date,next_last_cost,next_last_cost_date,last_receipt_date, unit_cost, billable_item_yn ,eff_status,imported_item_yn,essential_item_yn,reimbursable_item_yn,reimbursable_ind, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,direct_sale_allowed_yn,package_item_yn,place_of_origin,shelf_life,fda_code,LOW_COST_ITEM,INNOVATOR_ITEM,HIGH_MARGIN_ITEM, Item_Tech_Code, price_type ,category_code,alternate_yn) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? ,? , ? , ? , ? , ? , ? , ? , ?, ?, ?, ?, ?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),? , ?,? , ?,?,?,?,?, SYSDATE , ? , ? ,? ,SYSDATE , ? , ? ,?,?,?,?,?,?,?,?,?, ?,?,?)" );//Added for IN:069013  //price_type added for TH-KW-CRF-0046//category_code and alternate_yn added for MMS-DM-CRF-0209.2
					else
				//end AMS-CRF-0127		
						sqlMap.put( "InsertSQL", "INSERT INTO mm_item ( item_code, category_type_code, material_group_code,alpha_code,long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code, special_item_yn, gen_uom_code, item_class_code, item_anal1_code,item_anal2_code, item_anal3_code, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost,current_cost_date,last_cost,last_cost_date,next_last_cost,next_last_cost_date,last_receipt_date, unit_cost, billable_item_yn ,eff_status,imported_item_yn,essential_item_yn,reimbursable_item_yn,reimbursable_ind, added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,direct_sale_allowed_yn,package_item_yn,place_of_origin,shelf_life,fda_code,Item_Tech_Code, price_type,category_code,alternate_yn) VALUES  ( ? , ? , ? , ? , ? , ? , ? , ? ,? , ? , ? , ? , ? , ? , ? , ?, ?, ?, ?, ?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),?,TO_DATE(?,'dd/mm/yyyy'),TO_DATE(?,'dd/mm/yyyy'),? , ?,? , ?,?,?,?,?, SYSDATE , ? , ? ,? ,SYSDATE , ? , ? ,?,?,?,?,?,?, ?,?,? )" );//Added for AMS-CRF-0127,Added for MMS-DM-CRF-0084//End AMS-CRF-0127 , GHL-CRF-0548.1  //price_type added for TH-KW-CRF-0046//category_code and alternate_yn added for MMS-DM-CRF-0209.2
						
				sqlMap.put( "SelectSQL", MmRepository.getMmKeyValue( "SQL_MM_ITEMMASTER_EXISTS"));

				/*InitialContext context = new InitialContext() ;
				//Object object = context.lookup( MmInterface.JNDI_SINGLE_TABLE_HANDLER ) ;
				Object object = context.lookup( CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER") ) ;

		
				home  = (SingleTableHandlerHome) PortableRemoteObject.narrow( object, SingleTableHandlerHome.class ) ;
				remote = home.create() ;
				map = remote.insert( tabData, sqlMap ) ;*/
				Object home1 = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER"),SingleTableHandlerHome.class,getLocalEJB());
		Object busObj = (home1.getClass().getMethod("create",null)).invoke(home1,null);

		Object argArray[] = new Object[2];
		argArray[0] = tabData;
		argArray[1] = sqlMap;

		Class [] paramArray = new Class[2];
		paramArray[0] = tabData.getClass(); ;
		paramArray[1] = sqlMap.getClass();

		map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
		(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				
				if( ((Boolean) map.get( "result" )).booleanValue() )		
					map.put( "message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
				else
					map.put( "message", getMMMessage(getLanguageId(),(String) map.get( "msgid" ),"ST") ) ;
			} 
			catch(Exception e)
			{
				map.put( "message", e.getMessage()) ;
				e.printStackTrace() ;
			}
			finally
			{
				try {
						if( remote != null )
							remote.remove() ;
					} catch( Exception ee )
					{
						map.put( "message", ee.getMessage() ) ;
						ee.printStackTrace();
					}
			}
		return map ;
	}

	public void clear()
	{
		unit_cost				=	"0";			special_item_yn		=	"N";
		sole_source_yn			=	"N";			short_desc			=	"";
		//qty_on_order			=	"";			//pur_uom_code		=	"";
		//pur_gen_uom_conv		=	"";			//pr_based_budget_yn	=	"";
		material_group_code		=	"";			long_desc			=	"";
		//last_pur_advice_date	=	"";			
		item_specification		=	"";
		item_remarks			=	"";			item_code			=	"";
		item_class_code			=	"";			item_anal3_code		=	"";	
		item_anal2_code			=	"";			item_anal1_code		=	"";
		gen_uom_code			=	"";			eff_status			=	"D"; 
		alpha_code				=	"";			curr_supp_code		=	"";		
		manufacturer_id			=	"";			initial_cost		=	0 ;
		current_cost_date		=	"";			last_cost			=	0 ;
		last_cost_date			=	"";			next_last_cost		=	0 ;
		next_last_cost_date		=	"";			last_receipt_date	=	"";
		curr_supp_desc			=	"";			category_type_code  =   "";
		ps_item_yn		        =   "N";		fda_code ="";//Added for MMS-DM-CRF-0084
		cssd_component_yn       =   "N";		hsn_no="";//Added for AMS-CRF-0127
		billing_item_yn			= "N";          item_tech_desc="";//Sharanraj GHL-CRF-0548.1
		direct_sale_allowed_yn  = "N";          item_tech_code="";//sharanraj GHL-CRF-0548.1
		package_item_yn = "N";
		place_of_origin			=	"";
		shelf_life_no			=	"";
		shelf_life_time			=	"";	
		low_cost_item = ""; high_margin_item = ""; innovator_item="";//added for GHL-CRF-0549.1
		price_type				= ""; //added for TH-KW-CRF-0046
		category_code			=   "";   //Added for MMS-DM-CRF-0209.2
		alternate_yn			=   "";  //Added for MMS-DM-CRF-0209.2
		
		super.clear() ;
	}
	
	
	public void setAll( Hashtable recordSet ) {
		
		if(recordSet.containsKey("item_code"))
			setItemCode((String)recordSet.get("item_code")) ;

		if(recordSet.containsKey("billable_yn"))
			setBillableItemYN((String)recordSet.get("billable_yn")) ;

		if(recordSet.containsKey("alpha_code"))
			setAlphaCode((String)recordSet.get("alpha_code")) ;
		
		
		if(recordSet.containsKey("hsn_no")){ //Added for AMS-CRF-0127 - Start
			setHsnNo((String)recordSet.get("hsn_no")) ;
		} //Added for AMS-CRF-0127 - End

		if(recordSet.containsKey("long_desc"))
			setLongDesc((String)recordSet.get("long_desc")) ;

		if(recordSet.containsKey("short_desc"))
			setShortDesc((String)recordSet.get("short_desc")) ;

		if(recordSet.containsKey("eff_status")&& (!((String)recordSet.get("eff_status")).equals("")))
			setEffStatus((String)recordSet.get("eff_status")) ;
		else
			setEffStatus("D") ;

		if(recordSet.containsKey("item_remarks"))
			setRemarks((String)recordSet.get("item_remarks")) ;

//		if(recordSet.containsKey("item_specification"))
//			setSpecification((String)recordSet.get("item_specification")) ;
		
		if(recordSet.containsKey("gen_uom_code"))
			setUOM((String)recordSet.get("gen_uom_code")) ;

		if(recordSet.containsKey("unit_cost"))
			setUnitCost(checkForNull((String)recordSet.get("unit_cost"),"0")) ;

		if(recordSet.containsKey("material_group_code"))
			setMaterialCode((String)recordSet.get("material_group_code")) ;

		if(recordSet.containsKey("category_type_code"))
			setCategoryCode((String)recordSet.get("category_type_code")) ;

		/*if(recordSet.containsKey("pr_based_budget_yn"))
			setPrBudget((String)recordSet.get("pr_based_budget_yn")) ;*/

		if(recordSet.containsKey("sole_source_yn") && (!((String)recordSet.get("sole_source_yn")).equals("")))
			setSoleSource((String)recordSet.get("sole_source_yn")) ;
			

		if(recordSet.containsKey("curr_supp_code"))
			setSupplierCode((String)recordSet.get("curr_supp_code")) ;

		if(recordSet.containsKey("curr_supp_desc"))
			setSupplierDesc((String)recordSet.get("curr_supp_desc")) ;

		/*Sharanraj GHL-CRF-0548.1 starts*/
		if(recordSet.containsKey("Item_Tech_Desc"))
			setItemTechDesc((String)recordSet.get("Item_Tech_Desc")) ;
		
		if(recordSet.containsKey("Item_Tech_Code"))
			setItemTechCode((String)recordSet.get("Item_Tech_Code")) ;
		
		/*Sharanraj GHL-CRF-0548.1 ends*/
		
		if(recordSet.containsKey("special_item_yn") && (!((String)recordSet.get("special_item_yn")).equals("")))
			setSpecialItem((String)recordSet.get("special_item_yn")) ;

		/*if(recordSet.containsKey("pur_uom_code"))
			setPurchaseUOM((String)recordSet.get("pur_uom_code")) ;

		if(recordSet.containsKey("pur_gen_uom_conv"))
			setConversionFactor((String)recordSet.get("pur_gen_uom_conv")) ;

		if(recordSet.containsKey("qty_on_order"))
			setQtyOnOrder((String)recordSet.get("qty_on_order")) ;

		if(recordSet.containsKey("last_pur_advice_date"))
			setLastPurAdviceDt((String)recordSet.get("last_pur_advice_date")) ; */

		if(recordSet.containsKey("item_class_code"))
			setItemClass((String)recordSet.get("item_class_code")) ;

		if(recordSet.containsKey("item_anal1_code"))
			setItemAnal1Code((String)recordSet.get("item_anal1_code")) ;

		if(recordSet.containsKey("item_anal2_code"))
			setItemAnal2Code((String)recordSet.get("item_anal2_code")) ;

		if(recordSet.containsKey("item_anal3_code"))
			setItemAnal3Code((String)recordSet.get("item_anal3_code")) ;

		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		if(recordSet.containsKey("cssd_component_yn") && (!((String)recordSet.get("cssd_component_yn")).equals("")))
			setCSSDComponent((String)recordSet.get("cssd_component_yn")) ;

		if(recordSet.containsKey("manufacturer_id"))
			setManufacturer((String)recordSet.get("manufacturer_id")) ;

		if(recordSet.containsKey("ps_item_yn") && (!((String)recordSet.get("ps_item_yn")).equals("")))
			setPsItem((String)recordSet.get("ps_item_yn")) ;

		if(recordSet.containsKey("initial_cost"))
			setInitialCost((Integer.parseInt(checkForNull((String)recordSet.get("initial_cost"),"0")))) ;

		if(recordSet.containsKey("current_cost_date"))
			setCurrentCostDate( checkForNull((String)recordSet.get("current_cost_date"),"") ) ;

		if(recordSet.containsKey("last_cost"))
			setLastCost((Integer.parseInt(checkForNull((String)recordSet.get("last_cost"),"0")))) ;

		if(recordSet.containsKey("last_cost_date"))
			setLastCostDate(checkForNull((String)recordSet.get("last_cost_date"),"")) ;

		if(recordSet.containsKey("next_last_cost"))
			setNextLastCost((Integer.parseInt(checkForNull((String)recordSet.get("next_last_cost"),"0")))) ;

		if(recordSet.containsKey("next_last_cost_date"))
			setNextLastCostDate(checkForNull((String)recordSet.get("next_last_cost_date"),"")) ;

		if(recordSet.containsKey("last_receipt_date"))
			setLastReceiptDate(checkForNull((String)recordSet.get("last_receipt_date"),"")) ;

		if(recordSet.containsKey("direct_sale_allowed_yn"))
			setDirectSaleAllowedYN(checkForNull((String)recordSet.get("direct_sale_allowed_yn"),"")) ;
		
		if(recordSet.containsKey("imported_item"))
			setImportedItem(checkForNull((String)recordSet.get("imported_item"),"N")) ;
		
		if(recordSet.containsKey("essential_item"))
			setEssentialItem(checkForNull((String)recordSet.get("essential_item"),"N")) ;
		
		if(recordSet.containsKey("reimburse_type"))
			setReimburseType(checkForNull((String)recordSet.get("reimburse_type"),"N")) ;
		if(recordSet.containsKey("reimbursable_item_yn"))
			setReimbursableItemYN(checkForNull((String)recordSet.get("reimbursable_item_yn"),"N")) ;
		if(recordSet.containsKey("package_item_yn"))
			setPackageItemYN(checkForNull((String)recordSet.get("package_item_yn"),"N"));
		 
		 if(recordSet.containsKey("place_of_origin"))
			setPlaceOfOrigin((String)recordSet.get("place_of_origin")) ;
			
		if(recordSet.containsKey("shelf_life_no"))
			setShelf_life_no((String)recordSet.get("shelf_life_no")) ;	
			
		if(recordSet.containsKey("shelf_life_time"))
			setShelf_life_time((String)recordSet.get("shelf_life_time")) ;		
		//Added for MMS-DM-CRF-0084
		if(recordSet.containsKey("fda_code"))
			setFda_code((String)recordSet.get("fda_code")) ;
		//added for GHL-CRF-0549.1
		if(recordSet.containsKey("lowcost_item"))
			setLowCostItem(checkForNull((String)recordSet.get("lowcost_item"),"N")) ;
		
		if(recordSet.containsKey("innovator_item"))	
			setInnovatorItem(checkForNull((String)recordSet.get("innovator_item"),"N"));
		
		
		if(recordSet.containsKey("highcost_item"))	
			setHighCostItem(checkForNull((String)recordSet.get("highcost_item"),"N"));

		if(recordSet.containsKey("price_type"))	
			setPriceType(checkForNull((String)recordSet.get("price_type"),""));
		// Added for MMS-DM-CRF-0209.2 starts
		if (recordSet.containsKey("category_code1"))
			setCategory((String) recordSet.get("category_code1"));

		if (recordSet.containsKey("alternate"))
			setAlternate((String) recordSet.get("alternate"));

		// Added for MMS-DM-CRF-0209.2 ends	
			
		
	}

	private void doCommon() throws Exception {

	}
	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	public void loadData() throws Exception {
	//	Clob   item_spec;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		
		try {

			connection = getConnection();
		/*	if (isAPModuleInstalled())
			{*/
				
				//pstmt = connection.prepareStatement(MmInterface.SQL_MM_ITEMMASTER_MODIFY);
				//pstmt = connection.prepareStatement(MmRepository.getMmKeyValue( "SQL_MM_ITEMMASTER_MODIFY_WHEN_AP_INS"));
					
				//pstmt = connection.prepareStatement("SELECT item_code, category_type_code, material_group_code, alpha_code, long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code,ss.short_name curr_supp_desc,special_item_yn, gen_uom_code, item_class_code, item_anal1_code, item_anal2_code, item_anal3_code,  unit_cost, mi.eff_status, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost, TO_CHAR(current_cost_date,'dd/mm/yyyy') current_cost_date,last_cost,	TO_CHAR(last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,next_last_cost, TO_CHAR(last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,direct_sale_allowed_yn,imported_item_yn imported_item,essential_item_yn essential_item,reimbursable_ind reimburse_type,reimbursable_item_yn,package_item_yn FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ?");
				/* @Name - Priya
					* @Date - 15/06/2010
					* @Inc# - 22038
					* @Desc - To round up Unit cost  with st_get_cost_decimals function the above query is commented 
					*/
				//pstmt = connection.prepareStatement("SELECT item_code, category_type_code, material_group_code, alpha_code, long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code,ss.short_name curr_supp_desc,special_item_yn, gen_uom_code, item_class_code, item_anal1_code, item_anal2_code, item_anal3_code,  st_get_cost_decimals(unit_cost,'N') unit_cost, mi.eff_status, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost, TO_CHAR(current_cost_date,'dd/mm/yyyy') current_cost_date,last_cost,	TO_CHAR(last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,next_last_cost, TO_CHAR(last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,direct_sale_allowed_yn,imported_item_yn imported_item,essential_item_yn essential_item,reimbursable_ind reimburse_type,reimbursable_item_yn,package_item_yn,place_of_origin,shelf_life FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ?");

				//pstmt = connection.prepareStatement("SELECT item_code, category_type_code, material_group_code, alpha_code, long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code,ss.short_name curr_supp_desc,special_item_yn, gen_uom_code, item_class_code, item_anal1_code, item_anal2_code, item_anal3_code,  st_get_cost_decimals(unit_cost,'N') unit_cost,(select round(Sum(Item_cost_Value)/Sum(Item_qty_normal),3) UnitCost from (select Item_cost_Value,Item_qty_normal,a.item_code,a.Added_Date TrnDate from st_grn_hdr b , st_grn_dtl a  where A.FACILITY_ID = b.FACILITY_ID and a.DOC_TYPE_CODE = b.DOC_TYPE_CODE and  a.DOC_NO =b.DOC_NO and b.FINALIZED_YN ='Y' and item_code= ? union select ITEM_COST_VALUE,-1*ITEM_QTY_NORMAL ITEM_QTY_NORMAL,item_code,a.added_date trn_date  from st_rtv_dtl a,st_rtv_hdr b where a.FACILITY_ID = b.FACILITY_ID  and a.DOC_TYPE_CODE = b.DOC_TYPE_CODE and a.DOC_NO =b.DOC_NO and b.FINALIZED_YN ='Y'and item_code= ? Union select ITEM_COST_VALUE,ADJ_ITEM_QTY ITEM_QTY_NORMAL,a.item_code,a.added_date TrnDate from st_adj_dtl a ,st_adj_hdr b where a.FACILITY_ID = b.FACILITY_ID and a.DOC_TYPE_CODE = b.DOC_TYPE_CODE and a.DOC_NO =b.DOC_NO and b.FINALIZED_YN ='Y' and trn_type ='OBS' and item_code= ?) group by item_code) unit_cost_new, mi.eff_status, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost, TO_CHAR(current_cost_date,'dd/mm/yyyy') current_cost_date,last_cost,	TO_CHAR(last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,next_last_cost, TO_CHAR(last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,direct_sale_allowed_yn,imported_item_yn imported_item,essential_item_yn essential_item,reimbursable_ind reimburse_type,reimbursable_item_yn,package_item_yn,place_of_origin,shelf_life FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ?");

				//pstmt = connection.prepareStatement("SELECT item_code, category_type_code, material_group_code, alpha_code, long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code,ss.short_name curr_supp_desc,special_item_yn, gen_uom_code, item_class_code, item_anal1_code, item_anal2_code, item_anal3_code,  st_get_cost_decimals(unit_cost,'N') unit_cost,(st_display_unit_cost(?)) unit_cost_new, mi.eff_status, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost, TO_CHAR(current_cost_date,'dd/mm/yyyy') current_cost_date,last_cost,	TO_CHAR(last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,next_last_cost, TO_CHAR(last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,direct_sale_allowed_yn,imported_item_yn imported_item,essential_item_yn essential_item,reimbursable_ind reimburse_type,reimbursable_item_yn,package_item_yn,place_of_origin,shelf_life FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ?");
				//Modified by suresh.r on 12-11-2014 against Inc 52256
				//pstmt = connection.prepareStatement("SELECT item_code, category_type_code, material_group_code, alpha_code, long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code,ss.short_name curr_supp_desc,special_item_yn, gen_uom_code, item_class_code, item_anal1_code, item_anal2_code, item_anal3_code,  st_get_cost_decimals(unit_cost,'N') unit_cost,(st_display_unit_cost(?,SYSDATE,'CURRENT_STOCK')) unit_cost_new, mi.eff_status, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost, TO_CHAR(current_cost_date,'dd/mm/yyyy') current_cost_date,last_cost,	TO_CHAR(last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,next_last_cost, TO_CHAR(last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,direct_sale_allowed_yn,imported_item_yn imported_item,essential_item_yn essential_item,reimbursable_ind reimburse_type,reimbursable_item_yn,package_item_yn,place_of_origin,shelf_life FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ?"); 				
			//start AMS-CRF-0127
			if(issite == true && issiteSpecific == false )//modified for GHL-CRF-0549.1	
			//pstmt = connection.prepareStatement("SELECT item_code, category_type_code, material_group_code, alpha_code,long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code,ss.short_name curr_supp_desc,special_item_yn, gen_uom_code, item_class_code, item_anal1_code, item_anal2_code, item_anal3_code,  st_get_cost_decimals(unit_cost,'N') unit_cost,(st_display_unit_cost(?,SYSDATE,'CURRENT_STOCK')) unit_cost_new, mi.eff_status, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost, TO_CHAR(current_cost_date,'dd/mm/yyyy') current_cost_date,last_cost,	TO_CHAR(last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,next_last_cost, TO_CHAR(last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,direct_sale_allowed_yn,imported_item_yn imported_item,essential_item_yn essential_item,reimbursable_ind reimburse_type,reimbursable_item_yn,package_item_yn,place_of_origin,shelf_life,fda_code,hsn_no FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ?");//Added for AMS-CRF-0127,Added for MMS-DM-CRF-0084
			pstmt = connection.prepareStatement("SELECT mi.item_code, mi.category_type_code, mi.material_group_code, mi.alpha_code,mi.long_desc, mi.short_desc, mi.item_remarks, mi.item_specification, mi.sole_source_yn, mi.curr_supp_code,ss.short_name curr_supp_desc,mi.special_item_yn, mi.gen_uom_code, mi.item_class_code, mi.item_anal1_code, mi.item_anal2_code, mi.item_anal3_code,  st_get_cost_decimals(mi.unit_cost,'N') unit_cost,(st_display_unit_cost(?,SYSDATE,'CURRENT_STOCK')) unit_cost_new, mi.eff_status, mi.cssd_component_yn,mi.manufacturer_id,mi.ps_item_yn,mi.initial_cost, TO_CHAR(mi.current_cost_date,'dd/mm/yyyy') current_cost_date,mi.last_cost,	TO_CHAR(mi.last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(mi.next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,mi.next_last_cost, TO_CHAR(mi.last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,mi.direct_sale_allowed_yn,mi.imported_item_yn imported_item,mi.essential_item_yn essential_item,mi.reimbursable_ind reimburse_type,mi.reimbursable_item_yn,mi.package_item_yn,mi.place_of_origin,mi.shelf_life,mi.fda_code,mi.hsn_no,mi.Item_Tech_Code,it.short_desc Item_Tech_Desc,mi.price_type price_type,mi.category_code,mi.alternate_yn FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss,mm_item_tech_name_lang_vw it WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ? AND mi.item_tech_code = it.item_tech_name_code(+)");//Added for AMS-CRF-0127,Added for MMS-DM-CRF-0084 , GHL-CRF-0548.1 ,price_type added for TH-KW-CRF-0046//mi.category_code,mi.alternate_yn added for MMS-DM-CRF-0209.2
			else if (issite == true && issiteSpecific == true)
				//pstmt = connection.prepareStatement("SELECT item_code, category_type_code, material_group_code, alpha_code,long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code,ss.short_name curr_supp_desc,special_item_yn, gen_uom_code, item_class_code, item_anal1_code, item_anal2_code, item_anal3_code,  st_get_cost_decimals(unit_cost,'N') unit_cost,(st_display_unit_cost(?,SYSDATE,'CURRENT_STOCK')) unit_cost_new, mi.eff_status, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost, TO_CHAR(current_cost_date,'dd/mm/yyyy') current_cost_date,last_cost,	TO_CHAR(last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,next_last_cost, TO_CHAR(last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,direct_sale_allowed_yn,imported_item_yn imported_item,essential_item_yn essential_item,reimbursable_ind reimburse_type,reimbursable_item_yn,package_item_yn,place_of_origin,shelf_life,fda_code,hsn_no,LOW_COST_ITEM,INNOVATOR_ITEM,HIGH_MARGIN_ITEM FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ?");//Added for GHL-CRF-0549.1
				pstmt = connection.prepareStatement("SELECT mi.item_code, mi.category_type_code, mi.material_group_code, mi.alpha_code,mi.long_desc, mi.short_desc, mi.item_remarks, mi.item_specification, mi.sole_source_yn, mi.curr_supp_code,ss.short_name curr_supp_desc,mi.special_item_yn, mi.gen_uom_code, mi.item_class_code, mi.item_anal1_code, mi.item_anal2_code, mi.item_anal3_code,  st_get_cost_decimals(mi.unit_cost,'N') unit_cost,(st_display_unit_cost(?,SYSDATE,'CURRENT_STOCK')) unit_cost_new, mi.eff_status, mi.cssd_component_yn,mi.manufacturer_id,mi.ps_item_yn,mi.initial_cost, TO_CHAR(mi.current_cost_date,'dd/mm/yyyy') current_cost_date,mi.last_cost,	TO_CHAR(mi.last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(mi.next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,mi.next_last_cost, TO_CHAR(mi.last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,mi.direct_sale_allowed_yn,mi.imported_item_yn imported_item,mi.essential_item_yn essential_item,mi.reimbursable_ind reimburse_type,mi.reimbursable_item_yn,mi.package_item_yn,mi.place_of_origin,mi.shelf_life,mi.fda_code,mi.hsn_no,mi.Item_Tech_Code,it.short_desc Item_Tech_Desc,LOW_COST_ITEM,INNOVATOR_ITEM,HIGH_MARGIN_ITEM,mi.price_type price_type,mi.category_code,mi.alternate_yn FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss,mm_item_tech_name_lang_vw it WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ? AND mi.item_tech_code = it.item_tech_name_code(+)");  //price_type added for TH-KW-CRF-0046//mi.category_code,mi.alternate_yn added for MMS-DM-CRF-0209.2
			else if (issite == false && issiteSpecific == true)
				pstmt = connection.prepareStatement("SELECT mi.item_code, mi.category_type_code, mi.material_group_code, mi.alpha_code,mi.long_desc, mi.short_desc, mi.item_remarks, mi.item_specification, mi.sole_source_yn, mi.curr_supp_code,ss.short_name curr_supp_desc,mi.special_item_yn, mi.gen_uom_code, mi.item_class_code, mi.item_anal1_code, mi.item_anal2_code, mi.item_anal3_code,  st_get_cost_decimals(mi.unit_cost,'N') unit_cost,(st_display_unit_cost(?,SYSDATE,'CURRENT_STOCK')) unit_cost_new, mi.eff_status, mi.cssd_component_yn,mi.manufacturer_id,mi.ps_item_yn,mi.initial_cost, TO_CHAR(mi.current_cost_date,'dd/mm/yyyy') current_cost_date,mi.last_cost,	TO_CHAR(mi.last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(mi.next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,mi.next_last_cost, TO_CHAR(mi.last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,mi.direct_sale_allowed_yn,mi.imported_item_yn imported_item,mi.essential_item_yn essential_item,mi.reimbursable_ind reimburse_type,mi.reimbursable_item_yn,mi.package_item_yn,mi.place_of_origin,mi.shelf_life,mi.fda_code,mi.Item_Tech_Code,it.short_desc Item_Tech_Desc,LOW_COST_ITEM,INNOVATOR_ITEM,HIGH_MARGIN_ITEM,mi.price_type price_type,mi.category_code,mi.alternate_yn  FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss,mm_item_tech_name_lang_vw it WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ? AND mi.item_tech_code = it.item_tech_name_code(+)");//Added for IN:069013  //price_type added for TH-KW-CRF-0046//mi.category_code,mi.alternate_yn added for MMS-DM-CRF-0209.2
				
			else
			//end AMS-CRF-0127	
			
				//pstmt = connection.prepareStatement("SELECT item_code, category_type_code, material_group_code, alpha_code,long_desc, short_desc, item_remarks, item_specification, sole_source_yn, curr_supp_code,ss.short_name curr_supp_desc,special_item_yn, gen_uom_code, item_class_code, item_anal1_code, item_anal2_code, item_anal3_code,  st_get_cost_decimals(unit_cost,'N') unit_cost,(st_display_unit_cost(?,SYSDATE,'CURRENT_STOCK')) unit_cost_new, mi.eff_status, cssd_component_yn,manufacturer_id,ps_item_yn,initial_cost, TO_CHAR(current_cost_date,'dd/mm/yyyy') current_cost_date,last_cost,	TO_CHAR(last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,next_last_cost, TO_CHAR(last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,direct_sale_allowed_yn,imported_item_yn imported_item,essential_item_yn essential_item,reimbursable_ind reimburse_type,reimbursable_item_yn,package_item_yn,place_of_origin,shelf_life,fda_code FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ?");//Added for AMS-CRF-0127,Added for MMS-DM-CRF-0084//END AMS-CRF-0127 END
				pstmt = connection.prepareStatement("SELECT mi.item_code, mi.category_type_code, mi.material_group_code, mi.alpha_code,mi.long_desc, mi.short_desc, mi.item_remarks, mi.item_specification, mi.sole_source_yn,mi.curr_supp_code,ss.short_name curr_supp_desc,mi.special_item_yn, mi.gen_uom_code, mi.item_class_code, mi.item_anal1_code, mi.item_anal2_code,mi.item_anal3_code, st_get_cost_decimals(mi.unit_cost,'N') unit_cost,(st_display_unit_cost(?,SYSDATE,'CURRENT_STOCK')) unit_cost_new, mi.eff_status, mi.cssd_component_yn,mi.manufacturer_id,mi.ps_item_yn,mi.initial_cost, TO_CHAR(mi.current_cost_date,'dd/mm/yyyy') current_cost_date,mi.last_cost,	TO_CHAR(mi.last_cost_date,'dd/mm/yyyy') last_cost_date,TO_CHAR(mi.next_last_cost_date,'dd/mm/yyyy')next_last_cost_date,mi.next_last_cost, TO_CHAR(mi.last_receipt_date,'dd/mm/yyyy') last_receipt_date ,mi.billable_item_yn,mi.direct_sale_allowed_yn,mi.imported_item_yn imported_item,mi.essential_item_yn essential_item,mi.reimbursable_ind reimburse_type,mi.reimbursable_item_yn,mi.package_item_yn,mi.place_of_origin,mi.shelf_life,mi.fda_code,mi.Item_Tech_Code,it.short_desc Item_Tech_Desc,mi.price_type price_type,mi.category_code,mi.alternate_yn FROM mm_item_lang_vw mi , ap_supplier_lang_vw ss,mm_item_tech_name_lang_vw it WHERE  mi.curr_supp_code = ss.supp_code(+) AND mi.item_code = ? AND mi.language_id = ss.language_id(+) AND mi.language_id = ? AND mi.item_tech_code = it.item_tech_name_code(+)");//Added for AMS-CRF-0127,Added for MMS-DM-CRF-0084//END AMS-CRF-0127, GHL-CRF-0548.1 END //price_type added for TH-KW-CRF-0046//mi.category_code,mi.alternate_yn added for MMS-DM-CRF-0209.2
				pstmt.setString( 1, item_code);
				pstmt.setString( 2, item_code);
				pstmt.setString( 3, getLanguageId());
				//pstmt.setString( 3, getLanguageId());
				resultSet = pstmt.executeQuery();			
			/*}
			else
			{
				//pstmt = connection.prepareStatement(MmInterface.SQL_MM_ITEMMASTER_MODIFY);
				pstmt = connection.prepareStatement(MmRepository.getMmKeyValue( "SQL_MM_ITEMMASTER_MODIFY"));
				pstmt.setString( 1, item_code);
				resultSet = pstmt.executeQuery();
			}*/

				if (resultSet.next()) {	
					setItemCode(resultSet.getString		("item_code"));             
					setCategoryCode(resultSet.getString	("category_type_code"));  
					setMaterialCode(resultSet.getString	("material_group_code"));   
					setAlphaCode(resultSet.getString	("alpha_code"));            
					setLongDesc(resultSet.getString		("long_desc"));             
					setShortDesc(resultSet.getString	("short_desc"));            
					setRemarks(resultSet.getString		("item_remarks"));          
				//	setSpecification(checkForNull(resultSet.getString("item_specification")));         
					item_specification = resultSet.getString("item_specification");
				/*	if(item_spec!=null)
					{
					StringBuffer clob_data					= new StringBuffer();
					clob_data.append(item_spec.getSubString(1,(int)item_spec.length()));
					item_specification=clob_data.toString();
					}*/
					setSpecification(item_specification);
	
					setSoleSource(resultSet.getString	("sole_source_yn"));        
					setSupplierCode(resultSet.getString	("curr_supp_code"));        
					setItemTechCode(resultSet.getString ("Item_Tech_Code")) ;//Sharanraj GHL-CRF-0548.1
					setSupplierDesc(resultSet.getString	("curr_supp_desc"));   
					setItemTechDesc(resultSet.getString	("Item_Tech_Desc"));//Sharanraj GHL-CRF-0548.1
					setSpecialItem(resultSet.getString	("special_item_yn"));       
					setUOM(resultSet.getString			("gen_uom_code"));          
					//setPurchaseUOM(resultSet.getString	("pur_uom_code"));          
					//setConversionFactor(resultSet.getString("pur_gen_uom_conv"));      
					setItemClass(checkForNull(resultSet.getString	("item_class_code")));       
					setItemAnal1Code(checkForNull(resultSet.getString("item_anal1_code")));       
					setItemAnal2Code(checkForNull(resultSet.getString("item_anal2_code")));       
					setItemAnal3Code(checkForNull(resultSet.getString("item_anal3_code")));       
					//setQtyOnOrder(checkForNull(resultSet.getString	("qty_on_order")));          
					//setLastPurAdviceDt(checkForNull(resultSet.getString("last_pur_advice_date")));  
					//setPrBudget(checkForNull(resultSet.getString	("pr_based_budget_yn")));
					
					/* @Name - Priya
					* @Date - 15/06/2010
					* @Inc# - 22038
					* @Desc - As unit cost is already rounded up with st_get_cost_decimals function the below round up is removed
					*/
					//setUnitCost(setNumber(resultSet.getString	("unit_cost"),6));
					//setUnitCost(resultSet.getString	("unit_cost"));
					setUnitCost(resultSet.getString	("unit_cost_new"));

					setEffStatus(resultSet.getString	("eff_status"));
					setCSSDComponent(resultSet.getString	("cssd_component_yn"));
					setManufacturer(resultSet.getString	("manufacturer_id"));
					setPsItem(resultSet.getString	("ps_item_yn"));
					setInitialCost(resultSet.getInt	("initial_cost"));
					setCurrentCostDate(resultSet.getString	("current_cost_date"));
					setLastCost(resultSet.getInt	("last_cost"));
					setLastCostDate(resultSet.getString	("last_cost_date"));
					setNextLastCost(resultSet.getInt	("next_last_cost"));
					setNextLastCostDate(resultSet.getString	("next_last_cost_date"));
					setLastReceiptDate(resultSet.getString	("last_receipt_date"));
				
					setBillableItemYN(resultSet.getString("billable_item_yn"));	

//@----
					setDirectSaleAllowedYN(resultSet.getString("direct_sale_allowed_yn"));	
					setImportedItem(resultSet.getString("imported_item"));	
					setEssentialItem(resultSet.getString("essential_item"));	
					setReimburseType(resultSet.getString("reimburse_type"));	
					setReimbursableItemYN(resultSet.getString("reimbursable_item_yn"));	
					setPackageItemYN(resultSet.getString("package_item_yn"));
					setPlaceOfOrigin(resultSet.getString("place_of_origin"));
					
					String shelf_life = resultSet.getString("shelf_life");
					if(shelf_life != null && shelf_life.length() > 0){
						setShelf_life_time(shelf_life.substring(shelf_life.length() - 1)) ;	
						setShelf_life_no(shelf_life.substring(0,shelf_life.length() - 1)) ;	
					}	
					setFda_code(resultSet.getString("fda_code"));//Added for MMS-DM-CRF-0084
					if(issite)
					setHsnNo(resultSet.getString	("hsn_no"));//Added for AMS-CRF-0127
					//Added for GHL-CRF-0549.1
					if(issiteSpecific){
						setLowCostItem(resultSet.getString("low_cost_item"));
						setInnovatorItem(resultSet.getString("innovator_item"));
						setHighCostItem(resultSet.getString("high_margin_item"));
					}
					//Added for GHL-CRF-0549.1
					setPriceType(resultSet.getString("price_type")); //added for TH-KW-CRF-0046
					// Added for MMS-DM-CRF-0209.2 starts
					setCategory(resultSet.getString("category_code"));
					setAlternate(resultSet.getString("alternate_yn"));
					// Added for MMS-DM-CRF-0209.2 ends
				}
			
		} 
		catch (Exception e )	{
			e.printStackTrace();
			throw e;
		} 
		finally {
			try{
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}

		}
	}

	/* Function specific methods start */
	
	public ArrayList getUomList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrUOM		=	new  ArrayList();
		HashMap		hmUOM		=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(MmRepository.getMmKeyValue( "SQL_MM_ITEM_MASTER_PURCHASE"));
				pstmt.setString(1,getLanguageId());
				//pstmt = connection.prepareStatement(MmInterface.SQL_MM_ITEM_MASTER_PURCHASE); //Commented by Martin eSS.Common.SsInterface.SQL_SS_SURGERYTYPE_MODIFY
				resultSet = pstmt.executeQuery();
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmUOM	=	new HashMap();
					hmUOM.put("code",checkForNull(resultSet.getString(1)));
					hmUOM.put("desc",checkForNull(resultSet.getString(2)));
					arrUOM.add(hmUOM);
				}
			} 
			catch (Exception e )
			{
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrUOM;
		}

	public String toString()
	{
		return item_code;
	}

	public ArrayList getManufacturerList() throws Exception
	{
		java.sql.Connection connection = null;
		java.sql.PreparedStatement pstmt = null;
		java.sql.ResultSet resultSet = null;

		ArrayList	arrManufacuturer		=	new  ArrayList();
		HashMap		hmManu		=	null;	

		try {
				connection = getConnection();
				pstmt = connection.prepareStatement(MmRepository.getMmKeyValue( "SQL_MM_MANUFACTURER_SELECT"));
				pstmt.setString(1,getLanguageId());
				//pstmt = connection.prepareStatement(MmInterface.SQL_MM_ITEM_MASTER_PURCHASE); //Commented by Martin eSS.Common.SsInterface.SQL_SS_SURGERYTYPE_MODIFY
				resultSet = pstmt.executeQuery();
				
				while ((resultSet != null) && (resultSet.next()))
				{
					hmManu	=	new HashMap();
					hmManu.put("code",checkForNull(resultSet.getString(1)));
					hmManu.put("desc",checkForNull(resultSet.getString(2)));
					arrManufacuturer.add(hmManu);
				}
			} 
			catch (Exception e )
			{
				e.printStackTrace();
				throw e;
			} 
			finally
			{
				 try{
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
					}
					catch(Exception es) 
					{
					es.printStackTrace();
					}
			}
			return arrManufacuturer;
		}

	public boolean isAPModuleInstalled() throws Exception{
		boolean	bReturn=false;
		java.sql.Connection connection=null;
		java.sql.PreparedStatement preparedStatement=null;
		java.sql.ResultSet resultSet=null;
		
		try{
			connection=getConnection();
			preparedStatement=connection.prepareStatement(eMM.Common.MmRepository.getMmKeyValue( "SQL_MM_ITEM_AP_MODULE_SEARCH"));
			preparedStatement.setString(1,getLoginFacilityId());
			resultSet=preparedStatement.executeQuery();
			resultSet.next();
			bReturn=(resultSet.getInt("total")!=0);
		}
		catch (Exception exception){
			exception.printStackTrace();
		}
		finally {
			try { 
				closeResultSet(resultSet);
				closeStatement(preparedStatement);
				closeConnection(connection);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}
		
		return bReturn;
	}

	public ArrayList isSSIVModuleInstalled() throws Exception
		{
		HashMap		hmSSIV		=	null;	
		ArrayList	arrSSIV		=	new  ArrayList();
        
		hmSSIV	=	new HashMap();
		hmSSIV.put("IV",checkForNull(MM_license_rights.getSTboundary()));
		hmSSIV.put("SS",checkForNull(MM_license_rights.getSSboundary()));
		hmSSIV.put("PO",checkForNull(MM_license_rights.getPOboundary()));
		arrSSIV.add(hmSSIV);

/*		HashMap		hmSSIV		=	null;	

		java.sql.Connection connection=null;
		java.sql.PreparedStatement preparedStatement=null;
		java.sql.ResultSet resultSet=null;
		
		try{
			connection=getConnection();
			preparedStatement=connection.prepareStatement(eMM.Common.MmRepository.getMmKeyValue( "SQL_MM_ITEM_INST_PARAM"));
			resultSet=preparedStatement.executeQuery();
			while ((resultSet != null) && (resultSet.next()))
				{
					hmSSIV	=	new HashMap();
					hmSSIV.put("IV",checkForNull(resultSet.getString(1)));
					hmSSIV.put("SS",checkForNull(resultSet.getString(2)));
					arrSSIV.add(hmSSIV);
				}
		}
		catch (Exception exception){
			exception.printStackTrace();
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
*/		
		return arrSSIV;
	}	

	public boolean isModuleInstalled(String module_id){
		try { 
			return !fetchRecord(eMM.Common.MmRepository.getMmKeyValue( "SQL_MM_MODULE_INSTALLED_CHECK"),module_id).get("COUNT").toString().equals("0");
		
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}

	public boolean isSTItem(){
		try { 
			return !fetchRecord(eMM.Common.MmRepository.getMmKeyValue( "SQL_ST_ITEM_SELECT_COUNT"),getItemCode()).get("TOTAL").toString().equals("0");
		}
		catch (Exception exception) {
			exception.printStackTrace();
		}
		return false;
	}
public String getReimburseList(){
	java.util.Locale loc = new java.util.Locale(getLanguageId());
	java.util.ResourceBundle mm_labels = java.util.ResourceBundle.getBundle( "eMM.resources.Labels",loc);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
	return getStaticListOptionTag("N,"+common_labels.getString("Common.notapplicable.label")+";P,"+mm_labels.getString("eMM.PartialReimbursable.label")+";F,"+mm_labels.getString("eMM.FullyReimbursable.label"),getReimburseType());
}

/* @Name - Priya
* @Date - 11/05/2010
* @Inc# - 
* @Desc - Added new method 'getBLPackageEnabledYN' to check whether to display the 'Pakage Item' or not by calling the FUNCTION bl_package_enabled_yn
*/
public String getBLPackageEnabledYN(){
	
		String packageItemEnabledYN = "";
		try{
			
			packageItemEnabledYN=(String)fetchRecord("SELECT BL_PACKAGE_ENABLED_YN('"+getLoginFacilityId()+"') BL_PACKAGE_ENABLED_YN FROM DUAL").get("BL_PACKAGE_ENABLED_YN"); 
		}
		catch(Exception exception){
			exception.printStackTrace();
			
		}
		return packageItemEnabledYN;
	}

		public String getPlaceOfOriginList() {

				ArrayList alparameter = new ArrayList();

				alparameter.add(getLanguageId());
				
		
		return  getListOptionTag(getListOptionArrayList(getMmRepositoryValue("SQL_MP_COUNTRY_CODE_SELECT_SINGLE"),alparameter), getPlaceOfOrigin());
	}
	

}
