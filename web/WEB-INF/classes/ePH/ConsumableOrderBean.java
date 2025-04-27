/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************
 *----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History     Name      			Rev.Date		Rev.Name		                   Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?				?				?				?					?									?
07/01/2019		IN068344		Devindra				 		                                       Required indication of different item types during dispense/order 
                                                                                                       according to patient billing group.
28/05/2020      IN072995        Haribabu                                                                       PMG2020-NMC-JD-CRF-0001                                                                                                        
29/05/2020		IN:072092	    Manickavasagam J			     GHL-CRF-0618
03/11/2020		IN:074297	        Manickavasagam J			     GHL-SCF-1527
16/03/2021		IN:15664	        Manickavasagam J			     COMMON-ICN-0029
03/10/2023	  	50818  			    Himanshu 						GHL-SCF-1738 					GHL-SCF-1738 
---------------------------------------------------------------------------------------------------------------------------------------------------------
 */
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eOR.*;
import ePH.ConsumableOrder.*;
import java.text.DecimalFormat;
import javax.servlet.* ;
import javax.servlet.http.*;

public class ConsumableOrderBean extends PhAdapter implements Serializable{
	private String location_code = "";
	private String location_type = "";
	private String patient_id = "";
	private String encounter_id = "";
	private String patient_class = "";
	private String act_patient_class = "";
	private String called_from = "";
	private String trn_group_ref= "";
	private String tokens_generated_yn= "";
	private String store_desc= "";
	private String store_code= "";
	private HashMap selectedItemList = new HashMap();
	private ArrayList presItemList = new ArrayList();
	private ArrayList OrderID = new ArrayList();
	private String billInstallYN = "";;
	private String dispChargeDtlInDrugLKPYN = "";;
	private String dispPriceTypeinDrugLKPYN = "";
	private String priority = "";
	private String takeHomeMedication ="";
	private String radioval ="";
	private String order_date = null;  // Added for Bru-HIMS-CRF-385 [IN:041644] start
	private String print_ord_sht_rule_ind	= "" ; //Added for Bru-HIMS-CRF-393_1.0
	private String  OrderRemarks ="";	//Added for GHL-CRF-0470
	private String allow_alt_for_med_item = "N";// Added for GHL-CRF-0549 [IN:068344] - Start - Devindra
	private HashMap altItemClicked = new HashMap();
	private String blg_grp_id = ""; //GHL-CRF-0618
	private String formulary_code = ""; //GHL-CRF-0618
	private String formulary_type = ""; //GHL-CRF-0618
	private HashMap itemTypeForSelectedDrug = new HashMap();
	private HashMap	external_disp_yn	    = new HashMap();//Added for IN072995
	private boolean ext_disp_appl=false;//Added for IN072995
	private HashMap nonPreferenceRemarks    = new HashMap();//GHL-CRF-0618
	private ArrayList itemGenericType = new ArrayList(); //GHL-CRF-0618
	public String getItemTypeForSelectedDrug(String itemType) {
		return checkForNull((String)itemTypeForSelectedDrug.get(itemType));
	}
	public void setItemTypeForSelectedDrug(String itemType) {
		if(itemType.equals(""))
			itemTypeForSelectedDrug = new HashMap();
		else
			itemTypeForSelectedDrug.put(itemType,"Y");		
	}
	public String getAltItemClicked(String item_code) {
		return checkForNull((String)altItemClicked.get(item_code));
	}
	public void setAltItemClicked(String item_code) {
		if(item_code.equals(""))
			altItemClicked = new HashMap();
		else
		   altItemClicked.put(item_code,"Y");
	}
	public String getAllowAltForMedItem() {
		return allow_alt_for_med_item;
	}
	public void setAllowAltForMedItem(String allow_alt_for_med_item) {
		this.allow_alt_for_med_item = allow_alt_for_med_item;
	} // Added for GHL-CRF-0549 [IN:068344] - End - Devindra
	public void setOrderDate(String order_date)	{
		this.order_date	=	order_date;
	}
	public String getOrderDate(){
		return this.order_date;
	}								// // Added for Bru-HIMS-CRF-385 [IN:041644] end
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getTakeHomeMedication() {
		return takeHomeMedication;
	}

	public void setTakeHomeMedication(String takeHomeMedication) {
	this.takeHomeMedication = takeHomeMedication;
	}

	public String getBillInstallYN() {
		return billInstallYN;
	}

	public void setBillInstallYN(String billInstallYN) {
		this.billInstallYN = billInstallYN;
	}

	public String getDispChargeDtlInDrugLKPYN() {
		return dispChargeDtlInDrugLKPYN;
	}

	public void setDispChargeDtlInDrugLKPYN(String dispChargeDtlInDrugLKPYN) {
		this.dispChargeDtlInDrugLKPYN = dispChargeDtlInDrugLKPYN;
	}

	public String getDispPriceTypeinDrugLKPYN() {
		return dispPriceTypeinDrugLKPYN;
	}

	public void setDispPriceTypeinDrugLKPYN(String dispPriceTypeinDrugLKPYN) {
		this.dispPriceTypeinDrugLKPYN = dispPriceTypeinDrugLKPYN;
	} 

	public void setPatientId(String patient_id){
		this.patient_id = patient_id;
	}
	public void setEncounterId(String encounter_id){
		this.encounter_id = encounter_id;
	}
	public void setPatientClass(String patient_class){
		this.patient_class = patient_class;
	}
	public void setActPatientClass(String act_patient_class){
		this.act_patient_class = act_patient_class;
	}
	public void setStoreCode(String store_code){
		this.store_code = store_code;
	}
	public void setStoreDesc(String store_desc){
		this.store_desc = store_desc;
	}
	public void setLocationCode(String location_code){
		this.location_code = location_code;
	}
	public void setLocationType(String location_type){
		this.location_type = location_type;
	}
	public void setCalledFrom(String called_from){
		this.called_from = called_from;
	}

	public String getPatientId(){
		return this.patient_id ;
	}
	public String getEncounterId(){
		return this.encounter_id ;
	}
	public String getPatientClass(){
		return this.patient_class ;
	}
	public String getActPatientClass(){
		return this.act_patient_class ;
	}
	public String getStoreCode(){
		return this.store_code ;
	}
	public String getStoreDesc(){
		return this.store_desc ;
	}
	public String getLocationCode(){
		return this.location_code ;
	}
	public String getLocationType(){
		return this.location_type;
	}
	public ArrayList getPresItemList(){
		return this.presItemList;
	}
	public String getCalledFrom(){
		return this.called_from;
	}
	public void setTrnGroupRef(String trn_group_ref){
		this.trn_group_ref = trn_group_ref;
	}
	public String getTrnGroupRef(){
		return trn_group_ref;
	}
	public void setTokensGeneratedYN(String tokens_generated_yn){
		this.tokens_generated_yn = tokens_generated_yn;
	}
	public String getTokensGeneratedYN(){
		return tokens_generated_yn;
	}
	public ArrayList getOrderID(){
		return OrderID;
	}
	public String getRadioVal() {
		return radioval;
	}
	public void setRadioVal(String radioval) {
		this.radioval = radioval;
	}
	public void setPrintOrdShtRuleInd(String print_ord_sht_rule_ind) {//Added for Bru-HIMS-CRF-393_1.0
		 this.print_ord_sht_rule_ind=print_ord_sht_rule_ind;			
	}
	public String getPrintOrdShtRuleInd() {	
		return this.print_ord_sht_rule_ind;
	}
	//added for GHL-CRF-0618 - start
	public void setBillingGrpId(String blg_grp_id){
		this.blg_grp_id = blg_grp_id;
	}
	public String getBillingGrpId(){
		return blg_grp_id;
	}

	public void setFormularyCode(String formulary_code){
		this.formulary_code = formulary_code;
	}

	public String getFormularyCode(){
		return formulary_code;
	}
	public void setFormularyBlngGrpType(String formulary_type){
		this.formulary_type = formulary_type;
	}

	public String getFormularyBlngGrpType(){
		return formulary_type;
	}
	public void setNonPrefernceRemarksMedicalItem(String item_code,String item_remarks){
		this.nonPreferenceRemarks.put(item_code,item_remarks);
	}

	public HashMap getNonPrefernceRemarksMedicalItem(){
		
		return nonPreferenceRemarks;
	}
	public void setItemGenericType(String item_type){
	  this.itemGenericType.add(item_type);
	}

	public ArrayList getItemGenericType(){
	 return this.itemGenericType;
	}
//added for GHL-CRF-0618 - end
	//GHL-CRF-0470 starts
	public void setPresRemarks(String remarks)	{
		this.OrderRemarks	=remarks;
	}
	public String getPresRemarks()	{
		return this.OrderRemarks;
	}
	//GHL-CRF-0470 ends
	public void setAll( Hashtable recordSet ) {

		if(recordSet.get("mode") != null){
             mode = (String)recordSet.get("mode") ;
		}
	}
	//Added for IN072995
		public boolean getExtDispAppl() {
			return ext_disp_appl;
		}

		public void setExtDispAppl(boolean ext_disp_appl) {
			this.ext_disp_appl = ext_disp_appl;
		}
		//Added for IN072995
	public HashMap validate() throws Exception {
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( true ) ) ;
        map.put( "message", "success.." ) ;
        return map ;
	}

	public void clear(){
		location_code = "";
		location_type = "";
		store_desc = "";
		store_code = "";
		patient_id = "";       
		encounter_id = "";     
		patient_class = "";    
		act_patient_class = "";
		called_from = "";
		trn_group_ref		= "";	
		tokens_generated_yn		= "";	
		selectedItemList = new HashMap();
		presItemList = new ArrayList();
		OrderID = new ArrayList();
		altItemClicked = new HashMap(); // Added for GHL-CRF-0549 [IN:068344] - Devindra	
		itemTypeForSelectedDrug = new HashMap(); // Added for GHL-CRF-0548 [IN:068345]	
		external_disp_yn    = new HashMap(); //Added for IN072995
		//GHL-CRF-0618 - start
		blg_grp_id = ""; 
		formulary_code = "";
		formulary_type = "";
		if(nonPreferenceRemarks!=null){
			nonPreferenceRemarks.clear();
		}
		itemGenericType	    = new ArrayList();//GHL-CRF-0618
		//GHL-CRF-0618 - end
	}

	public String getSysdatetimesec(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date_time_sec				= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date_time_sec=resultSet.getString("SYS_DATE_TIME_SEC");
			}
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
            try{
                 closeResultSet( resultSet ) ;
                 closeStatement( pstmt ) ;
                 closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return sys_date_time_sec;
	}

	public String getSysdate(){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sys_date				= "";
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT54");
			pstmt					= connection.prepareStatement(str_qry) ;
			resultSet				= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				sys_date=resultSet.getString("SYS_DATE");
			}
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
            try{
                 closeResultSet( resultSet ) ;
                 closeStatement( pstmt ) ;
                 closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return sys_date;
	}

	public void setPresItemList(ArrayList presItemList){
		this.presItemList = presItemList;
	}

	//public ArrayList getItemDetailsList(String item_desc,String from,String to, String bl_install_yn, String disp_charge_dtl_in_drug_lkp_yn, String disp_price_type_in_drug_lkp, String take_home_medication, String priority){
	public ArrayList getItemDetailsList(String item_desc,String from,String to, String bl_install_yn, String disp_charge_dtl_in_drug_lkp_yn, String disp_price_type_in_drug_lkp, String take_home_medication, String priority,String search_string,String search_criteria,String consignment,String Manufacturer,String p_Item_class,String Item_analysis1,String Item_analysis2,String Item_analysis3,String radioval){
		Connection connection       = null ;
		PreparedStatement pstmt_item     = null ;
		PreparedStatement pstmt_store     = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet_item         = null ;
		ResultSet resultSet_store         = null ;
		String sql_query_item			= "";
		ArrayList alItemList= new ArrayList();
		HashMap hmItemDetail= null;
		String item_code="";
		String trade_code="";
		String store_code="";
		String store_desc="";
		String disp_locn="";
		String order_type="";
		String episode_type = "";
		String reimburse_yn = "";	
		String imported_yn = "";		
		String unit_price = "";		
		String error_code = "";		
		String sys_message_id = "";	
		String error_text = "";	
		String encounter_id = getEncounterId();
		String episode_id = "";
		String visit_id = "";
		String prevnextlink			= "";
		boolean ext_disp_appl=getExtDispAppl();//Added for IN072995
		String ext_disp_appl_yn="";//Added for IN072995
		String stock_yn="Y";//Added for IN072995
		String billable_item_yn="";//added for ml-mmoh-scf-2090
		int query_result_size		= 10;
		int start = 0 ;
		int end = 0 ;
		if ( from == null || from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from  ) ;

		if ( to == null || to.equals(""))
			end =query_result_size;
		else
			end = Integer.parseInt( to ) ;
		long count=0;
		long i = 0;
		try{
			connection = getConnection() ;
			String item_code_search="";
			String item_description_search="";
			String trade_id_search="";
			String trade_name_search="";
			if (radioval.equals("IC")){
				
				item_description_search="%";
				trade_id_search="%";
				trade_name_search="%";
				if(search_string.equals("")){
					item_code_search="%";
				}
				else{
					if(search_criteria.equals("S")){
						item_code_search=search_string+"%";
					}
					else if(search_criteria.equals("C")){
						item_code_search="%"+search_string+"%";
					}
					else if(search_criteria.equals("E")){
						item_code_search="%"+search_string;
					}
				}
			}
			else if (radioval.equals("ID")){
				item_code_search="%";
				trade_id_search="%";
				trade_name_search="%";
				if(search_string.equals("")){
				item_description_search="%";
				}
				else{
					if(search_criteria.equals("S")){
						item_description_search=search_string+"%";
					}
					else if(search_criteria.equals("C")){
						item_description_search="%"+search_string+"%";
					}
					else if(search_criteria.equals("E")){
						item_description_search="%"+search_string;
					}
				}
			} //end for ID
			else if (radioval.equals("TC")){
				item_code_search="%";
				item_description_search="%";
				trade_name_search="%";
				if(search_string.equals("")){
					trade_id_search="%";
				}
				else{
					if(search_criteria.equals("S")){
						trade_id_search=search_string+"%";
					}
					else if(search_criteria.equals("C")){
						trade_id_search="%"+search_string+"%";
					}
					else if(search_criteria.equals("E")){
						trade_id_search="%"+search_string;
					}
				}
			}//ends TC
			else if (radioval.equals("TN")){
				item_code_search="%";
				item_description_search="%";
				trade_id_search="%";
				if(search_string.equals("")){
					trade_name_search="%";
				}
				else{
					if(search_criteria.equals("S")){
						trade_name_search=search_string+"%";
					}
					else if(search_criteria.equals("C")){
						trade_name_search="%"+search_string+"%";
					}
					else if(search_criteria.equals("E")){
						trade_name_search="%"+search_string;
					}
				}
			}//ends TN
			if(consignment.equals("A")){
				consignment="A";
			}
			else if(consignment.equals("Y")){
				consignment="Y";
			}

			//sql_query_item        = PhRepository.getPhKeyValue("SQL_PH_CONSUMABLERX_ITEM_SELECT");
			//sql_query_item = "SELECT ord_cat.order_catalog_code item_code , mm.long_desc, mtr.trade_id,st.prompt_alert_preferred_drug,(SELECT short_name FROM am_trade_name_lang_vw WHERE language_id = ? AND trade_id = mtr.trade_id) trade_name, mm.gen_uom_code uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE language_id =? AND uom_code = mm.gen_uom_code) uom_desc, ord_cat.order_type_code, ord_cat.order_category FROM or_order_catalog ord_cat, st_item st, mm_item_lang_vw mm, mm_trade_name_for_item mtr WHERE medical_item_yn = 'Y' AND drug_item_yn = 'N' AND st.item_code = mm.item_code AND mm.language_id = ? and ord_cat.order_catalog_code = mm.item_code and ord_cat.order_category='PH' and ord_cat.order_type_code='MS' AND st.item_code = mtr.item_code(+) AND mm.eff_status = 'E' AND UPPER (mm.long_desc) LIKE UPPER (?)";
			//sql_query_item = "SELECT DISTINCT a.item_code item_code, b.long_desc long_desc  ,f.trade_id,a.prompt_alert_preferred_drug,(SELECT short_name FROM am_trade_name_lang_vw WHERE language_id = ? AND trade_id = f.trade_id) trade_name,b.gen_uom_code uom_code,(SELECT short_desc FROM am_uom_lang_vw WHERE language_id = ? AND uom_code = b.gen_uom_code) uom_desc,ord_cat.order_type_code, ord_cat.order_category FROM st_item a,mm_item_lang_vw b,mm_trade_name_for_item f,am_trade_name_lang_vw g,am_uom_lang_vw i,or_order_catalog ord_cat WHERE a.item_code = b.item_code AND b.eff_status = 'E' and ord_cat.order_category='PH' AND ord_cat.order_type_code = 'MS' and ord_cat.order_catalog_code =a.item_code AND a.item_code = f.item_code(+) AND f.trade_id = g.trade_id(+) AND UPPER (a.item_code) LIKE UPPER (NVL (?, '%')) AND UPPER (b.short_desc) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (f.trade_id, '%')) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (g.short_name, '%')) LIKE UPPER (NVL (?, '%')) AND a.medical_item_yn ='Y' and drug_item_yn='N'and b.item_code in (SELECT item_code FROM mm_item WHERE sole_source_yn='N' AND item_code IN (     SELECT item_code FROM mm_trade_name_for_item WHERE trade_id IN (SELECT trade_id FROM am_trade_name WHERE manufacturer_id = nvl(?,manufacturer_id))) UNION ALL SELECT item_code FROM mm_item WHERE sole_source_yn='Y' and manufacturer_id = nvl(?,manufacturer_id)) AND NVL (b.item_class_code, '%') LIKE  (NVL (?, '%')) AND NVL (b.item_anal1_code, '%') LIKE (NVL (?, '%')) AND NVL (b.item_anal2_code, '%') LIKE (NVL (?, '%'))  AND NVL (b.item_anal3_code, '%') LIKE (NVL (?, '%'))  AND a.consignment_item_yn LIKE DECODE (?, 'A', '%', ?)  AND b.language_id = ? AND g.language_id(+) = ?";
			////billable_item_yn added for ml-mmoh-scf-2090
      sql_query_item = "SELECT DISTINCT a.item_code item_code, b.long_desc long_desc, f.trade_id,a.prompt_alert_preferred_drug,(SELECT short_name FROM am_trade_name_lang_vw WHERE language_id = ? AND trade_id = f.trade_id) trade_name, b.gen_uom_code uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE language_id = ? AND uom_code = b.gen_uom_code) uom_desc, ord_cat.order_type_code, ord_cat.order_category,b.low_cost_item,b.high_margin_item,b.innovator_item,b.item_tech_code,b.BILLABLE_ITEM_YN FROM st_item a,mm_item_lang_vw b,mm_trade_name_for_item f,am_trade_name_lang_vw g, am_uom_lang_vw i,or_order_catalog ord_cat WHERE a.item_code = b.item_code AND b.eff_status = 'E' AND ord_cat.eff_status='E' AND ord_cat.order_category = 'PH' AND ord_cat.order_type_code = 'MS' AND ord_cat.order_catalog_code = a.item_code AND a.item_code = f.item_code(+) AND f.trade_id = g.trade_id(+) AND UPPER (a.item_code) LIKE UPPER (NVL (?, '%')) AND UPPER (b.short_desc) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (f.trade_id, '%')) LIKE UPPER (NVL (?, '%')) AND UPPER (NVL (g.short_name, '%')) LIKE UPPER (NVL (?, '%')) AND a.medical_item_yn = 'Y' AND drug_item_yn = 'N' AND b.item_code IN (SELECT item_code FROM mm_item WHERE sole_source_yn = 'N' AND item_code IN (SELECT item_code FROM mm_trade_name_for_item WHERE trade_id IN (SELECT trade_id FROM am_trade_name WHERE manufacturer_id = NVL (?, manufacturer_id))) UNION ALL SELECT item_code FROM mm_item WHERE sole_source_yn = 'Y' AND manufacturer_id = NVL (?, manufacturer_id)) AND ((b.sole_source_yn='N' and f.trade_id in (SELECT trade_id FROM am_trade_name WHERE manufacturer_id =NVL (?, manufacturer_id))) or b.sole_source_yn='Y') AND NVL (b.item_class_code, '%') LIKE (NVL (?, '%')) AND NVL (b.item_anal1_code, '%') LIKE (NVL (?, '%')) AND NVL (b.item_anal2_code, '%') LIKE (NVL (?, '%')) AND NVL (b.item_anal3_code, '%') LIKE (NVL (?, '%')) AND a.consignment_item_yn LIKE DECODE (?, 'A', '%', ?) AND b.language_id = ? AND g.language_id(+) = ?"; // b.low_cost_item,b.high_margin_item,b.innovator_item Added for GHL-CRF-0549 [IN:068344] - Devindra
			//AND ord_cat.eff_status='E'  added for TBMC-SCF-0043
			pstmt_item				= connection.prepareStatement(sql_query_item) ;
			pstmt_item.setString(1,getLanguageId());
			pstmt_item.setString(2,getLanguageId());
			pstmt_item.setString(3,item_code_search);
			pstmt_item.setString(4,item_description_search);
			pstmt_item.setString(5,trade_id_search);
			pstmt_item.setString(6,trade_name_search);
			pstmt_item.setString(7,Manufacturer);
			pstmt_item.setString(8,Manufacturer);
			pstmt_item.setString(9,Manufacturer);
			pstmt_item.setString(10,p_Item_class);
			pstmt_item.setString(11,Item_analysis1);
			pstmt_item.setString(12,Item_analysis2);
			pstmt_item.setString(13,Item_analysis3);
			pstmt_item.setString(14,consignment);
			pstmt_item.setString(15,consignment);
			pstmt_item.setString(16,getLanguageId());
			pstmt_item.setString(17,getLanguageId());
			resultSet_item			= pstmt_item.executeQuery();

			alItemList.add("link");
			while(resultSet_item!=null && resultSet_item.next()) {
				if( start != 1 && (i+1) < start ) {
					i++;
					continue;
				}
				else{
					i++;
					count++ ;
				}
				if(i <= end ) {
					hmItemDetail= new HashMap();
					item_code = resultSet_item.getString("item_code");
					hmItemDetail.put("ITEM_CODE",item_code);
					hmItemDetail.put("ITEM_DESC",resultSet_item.getString("long_desc"));
					trade_code = resultSet_item.getString("trade_id")==null?"":resultSet_item.getString("trade_id");
					hmItemDetail.put("TRADE_CODE",trade_code);
					hmItemDetail.put("TRADE_NAME",resultSet_item.getString("trade_name")==null?"":resultSet_item.getString("trade_name"));
					hmItemDetail.put("UOM_CODE",resultSet_item.getString("UOM_CODE"));
					hmItemDetail.put("UOM_DESC",resultSet_item.getString("UOM_DESC"));
					hmItemDetail.put("ORDER_TYPE",resultSet_item.getString("ORDER_TYPE_CODE"));
					hmItemDetail.put("PROMPT_ALERT_PREFERRED_DRUG",resultSet_item.getString("PROMPT_ALERT_PREFERRED_DRUG"));
					order_type = resultSet_item.getString("ORDER_TYPE_CODE");
					hmItemDetail.put("LOW_COST_ITEM",checkForNull(resultSet_item.getString("LOW_COST_ITEM"))); // Added for GHL-CRF-0549 [IN:068344] - Start - Devindra
					hmItemDetail.put("HIGH_MARGIN_ITEM",checkForNull(resultSet_item.getString("HIGH_MARGIN_ITEM")));
					hmItemDetail.put("INNOVATOR_ITEM",checkForNull(resultSet_item.getString("INNOVATOR_ITEM")));
					hmItemDetail.put("ITEM_TECH_CODE",checkForNull(resultSet_item.getString("ITEM_TECH_CODE"))); // Added for GHL-CRF-0549 [IN:068344] - End - Devindra
					//added for ml-mmoh-scf-2090
          billable_item_yn=checkForNull(resultSet_item.getString("BILLABLE_ITEM_YN"));
					//to get Billing Details
					System.out.println(billable_item_yn+"billable_item_yn"+disp_charge_dtl_in_drug_lkp_yn+"571 bl_install_yn"+bl_install_yn+checkForNull(resultSet_item.getString("BILLABLE_ITEM_YN")));
					if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y") && billable_item_yn.equals("Y")){//added for ml-mmoh-scf-2090
						episode_type= getActPatientClass();
						if(episode_type !=null && (!episode_type.equals("")))
							episode_type = episode_type.substring(0,1);

						if(episode_type !=null && episode_type.equals("X"))
							episode_type = "R";
                       if(!encounter_id.equals("") && !encounter_id.equals(null)){
                    	   if(encounter_id.length()<=0) 
           				{
           					episode_id =""; 
           					visit_id ="";
           				}
           				else{
           					episode_id = encounter_id.substring(0,(encounter_id.length()-4));  // Added for JD-CRF-0191
    						visit_id = encounter_id.substring(encounter_id.length()-4);        // Added for JD-CRF-0191      
           				}
                    	   
                       }
						cstmt=connection.prepareCall("{call  BL_PROC_ITEM_VALIDATIONS_MP.BL_GET_ITEM_DETAILS_MM (?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // three more '?' added for JD-CRF-0191
						cstmt.setString( 1, login_facility_id);
						cstmt.setString( 2, episode_type); //'O'-Outpatient,'E'-Emergency ,'D'-Daycare,'I'-Inpatient,'R'-External
						cstmt.setString( 3, item_code);
						cstmt.setString( 4, ""); // p_trade_id	--If Batch level price is required (null as of now)
						cstmt.setString( 5, ""); // p_batch_id  --If Batch level price is required (null as of now
						cstmt.setString( 6, getSysdatetimesec()); // p_date
						cstmt.registerOutParameter(7, Types.VARCHAR );	//ESSENTIAL_YN 
						cstmt.registerOutParameter(8, Types.VARCHAR );	//P_REIMBURSABLE_YN Y --Reimbursible
						cstmt.registerOutParameter(9, Types.VARCHAR );	//P_REIMBURSABLE  P --> partially   F --> Fully
						cstmt.registerOutParameter(10, Types.VARCHAR ); //P_IMPORTED_YN	Y  --> Imported
						cstmt.registerOutParameter(11, Types.NUMERIC ); //PUBLIC_PRICE
						cstmt.registerOutParameter(12, Types.NUMERIC ); //P_BASE_PRICE	--Sale price as defined in billing by item/batch for respective passed Episode Type
						cstmt.registerOutParameter(13, Types.NUMERIC ); //P_REIMBURSABLE_AMT
						cstmt.registerOutParameter(14, Types.VARCHAR ); //P_REIM_OVERRIDE
						cstmt.registerOutParameter(15, Types.VARCHAR ); //P_ERROR_CODE
						cstmt.registerOutParameter(16, Types.VARCHAR ); //P_SYS_MESSAGE_ID
						cstmt.registerOutParameter(17, Types.VARCHAR ); //P_ERROR_TEXT
						cstmt.setString( 18, getPatientId()); //Added for JD-CRF-0191 - Start
						cstmt.setString( 19, episode_id);  
						cstmt.setString( 20, visit_id);  //Added for JD-CRF-0191 - End  
						cstmt.execute() ;

						reimburse_yn	= cstmt.getString(8);
						imported_yn		= cstmt.getString(10);
						unit_price		= cstmt.getString(12);
						error_code		= cstmt.getString(15);
						sys_message_id	= cstmt.getString(16);
						error_text		= cstmt.getString(17);
	
						closeStatement( cstmt );

						if(disp_price_type_in_drug_lkp.equals("P") && (error_code ==null && sys_message_id==null && error_text==null)){
							if(encounter_id!= null && !encounter_id.equals("")){
								episode_id = encounter_id;
								if(episode_type.equals("O")||episode_type.equals("E")){
									episode_id = encounter_id.substring(0,(encounter_id.length()-4));
									visit_id = encounter_id.substring(encounter_id.length()-4);
								}
							}
							cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
							cstmt.setString( 1, login_facility_id);
							cstmt.setString( 2, "PH");	//module id
							cstmt.setString( 3, "");	//
							cstmt.setString( 4, "");	//
							cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
							cstmt.setString( 6, getPatientId()); //patient_id
							cstmt.setString( 7, episode_id);  //episode_id
							cstmt.setString( 8, visit_id);  //p_visit_id  
							cstmt.setString( 9, ""); //p_dummy1 - null
							cstmt.setString( 10, ""); //p_dummy12 - null
							cstmt.setString( 11, "SAL"); //p_transaction_type
							cstmt.setString( 12, getSysdatetimesec()); //p_charge_date_time	--Service Data and time

							cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
							cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
							cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
							cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

							cstmt.setString( 17, item_code);  //p_item_code
							cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
							cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 
							cstmt.setString( 20, "S");  //p_serv_panel_ind
							cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 
							cstmt.setString( 22,"1" );  //qty served
							cstmt.setString( 23, "");  //p_charge_amt  
							cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost
							cstmt.setString( 25,"" );  //p_store_code -- Store Code from where issued
							cstmt.setString( 26, "");  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
							cstmt.setString( 27,"" );  //p_oth_disc_perc if any other manual discount is given from transaction
							cstmt.setString( 28, "");  //p_source_doc_ref		null for Sale
							cstmt.setString( 29,"" );  //p_source_doc_ref_line	null for Sale

							cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_qty
							cstmt.registerOutParameter(31, Types.NUMERIC ); //p_base_rate
							cstmt.registerOutParameter(32, Types.NUMERIC ); //p_addl_factor
							cstmt.registerOutParameter(33, Types.NUMERIC ); //p_base_charge_amt       
							cstmt.registerOutParameter(34, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
							cstmt.registerOutParameter(35, Types.NUMERIC ); //p_DISC_AMT              
							cstmt.registerOutParameter(36, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
							cstmt.registerOutParameter(37, Types.NUMERIC ); //p_disc_perc             
							cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
							cstmt.registerOutParameter(39, Types.NUMERIC ); //p_PAT_DISC_AMT          
							cstmt.registerOutParameter(40, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
							cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
							cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_DISC_AMT         
							cstmt.registerOutParameter(43, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
							cstmt.registerOutParameter(44, Types.VARCHAR ); //p_SPLIT_IND             
							cstmt.registerOutParameter(45, Types.NUMERIC ); //p_curr_availed          
							cstmt.registerOutParameter(46, Types.VARCHAR ); //p_credit_auth_ref       
							cstmt.registerOutParameter(47, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt

							cstmt.setString( 48,"" );  //p_dummy4 (IN OUT )
							cstmt.setString( 49, "");  //p_batch_prices  (IN OUT )
							
							cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
							cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
							cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
							cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

							cstmt.setString( 54,"" );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
							cstmt.setString( 55, "");  //p_overridden_action_reason		 --- Pass null or any value entered 

							cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
							cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
							cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text

							cstmt.execute() ;
							unit_price		= cstmt.getString(40);
							error_code		= cstmt.getString(56);
							sys_message_id	= cstmt.getString(57);
							error_text		= cstmt.getString(58);
	
						}
						hmItemDetail.put("BL_REIMBURSE_YN",reimburse_yn);
						hmItemDetail.put("BL_IMPORTED_YN",imported_yn);
						hmItemDetail.put("BL_UNIT_PRICE",unit_price);
						hmItemDetail.put("BL_ERROR_CODE",error_code);
						hmItemDetail.put("BL_SYS_MESSAGE_ID",sys_message_id);
						hmItemDetail.put("BL_ERROR_TEXT",error_text);
					}
					//Billing Details ends here
/*code added for the preferred Drugs to get the billing preference details */
					episode_type= getActPatientClass();
					if(episode_type !=null && (!episode_type.equals("")))
						episode_type = episode_type.substring(0,1);
					if(episode_type !=null && episode_type.equals("X"))
						episode_type = "R";
						if(encounter_id!= null && !encounter_id.equals("")){
								episode_id = encounter_id;
								if(episode_type.equals("O")||episode_type.equals("E")){
									episode_id = encounter_id.substring(0,(encounter_id.length()-4));
									visit_id = encounter_id.substring(encounter_id.length()-4);
							}
						}
//System.err.println("@@episodeId::"+episode_id+"::encounter_id::"+encounter_id+"::visit_id::"+visit_id+"-->episode_type-->"+episode_type+"-->item_code-->"+item_code+"===pat id"+getPatientId()+"==login_facility_id===="+login_facility_id+" bl_install_yn="+bl_install_yn+" disp_charge_dtl_in_drug_lkp_yn="+disp_charge_dtl_in_drug_lkp_yn);
                 if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y")&& billable_item_yn.equals("Y")){//added for ml-mmoh-scf-2090
						cstmt=connection.prepareCall("{call  BLCOMMON.BL_MM_PREF_LOC_ITEM_FOR_IMP(?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
						cstmt.setString( 1, login_facility_id);
						cstmt.setString( 2, getPatientId()); 
						cstmt.setString( 3, episode_type);
						cstmt.setString( 4, episode_id);
						cstmt.setString( 5, visit_id);
						cstmt.setString( 6, encounter_id); 
						cstmt.setString( 7, item_code);
						cstmt.registerOutParameter(8, Types.VARCHAR );	
						cstmt.registerOutParameter(9, Types.VARCHAR );	
						cstmt.registerOutParameter(10, Types.VARCHAR ); 

						cstmt.registerOutParameter(11, Types.VARCHAR ); 
						cstmt.registerOutParameter(12, Types.VARCHAR ); 
						cstmt.registerOutParameter(13, Types.VARCHAR ); 
						cstmt.registerOutParameter(14, Types.VARCHAR ); 
						cstmt.execute();
						hmItemDetail.put("BL_PREFERENCE_CHECK_YN",cstmt.getString(8)==null?"":cstmt.getString(8));
						hmItemDetail.put("BL_PREFERENCE_BASIS_IND",cstmt.getString(9)==null?"":cstmt.getString(9));
						hmItemDetail.put("BL_PREFERENCE_ITEM_CODE",cstmt.getString(10)==null?"":cstmt.getString(10));
						hmItemDetail.put("BL_PREFERENCE_PRIORITY",cstmt.getString(11)==null?"":cstmt.getString(11));
						hmItemDetail.put("BL_PREFERENCE_ERROR_CODE",cstmt.getString(12)==null?"":cstmt.getString(12));
						hmItemDetail.put("BL_PREFERENCE_SYS_MESSAGE_ID",cstmt.getString(13)==null?"":cstmt.getString(13));
						hmItemDetail.put("BL_PREFERENCE_ERROR_TEXT",cstmt.getString(14)==null?"":cstmt.getString(14));
						closeStatement( cstmt );
				 }
//System.err.println("@@@395 in counsumable Order Beean--->-->"+hmItemDetail);
/*code ended  for the preferred Drugs to get the billing preference details */
					String locn_type = getLocationType();
					String locn_code = getLocationCode();
					String patient_class ="";
					if(locn_type==null)
						locn_type = "";
					if(locn_code==null)
						locn_code = "";
					if(getActPatientClass().equals("I")){
						patient_class  ="IP";
					}else if(getActPatientClass().equals("D")){
						patient_class  ="DC";
					}else if(getActPatientClass().equals("O")){
						patient_class  ="OP";
					}else if(getActPatientClass().equals("E")){
						patient_class  ="EM";
					}else if(getActPatientClass().equals("R")){
						patient_class  ="XT";
					}else{
						patient_class =getActPatientClass();
					}					
					if(!locn_type.equals("") && !locn_code.equals("")){  //dont comment this if condition. otherwise it will display wrong stock regarding with disp.location.
					//pstmt_store = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT16A") );
					pstmt_store = connection.prepareStatement("SELECT PH_DISP_STOCK_LOCN(?,?,?,?,?,?,?,?,?,?,?,'M',?,?,?) DISP_LOCN from dual");
					pstmt_store.setString(1,locn_type);
					pstmt_store.setString(2,locn_code);
					pstmt_store.setString(3,login_facility_id);
					pstmt_store.setString(4,login_facility_id);
					pstmt_store.setString(5,""); //drug_class
					pstmt_store.setString(6,item_code);
					pstmt_store.setString(7,order_type);
					pstmt_store.setString(8,patient_class);
					pstmt_store.setString(9,take_home_medication);
					pstmt_store.setString(10,priority);
					pstmt_store.setString(11,getLanguageId());
					pstmt_store.setString(12,takeHomeMedication);//added for MMSissue replication 170215 start
					pstmt_store.setString(13,getPatientId());
					pstmt_store.setString(14,encounter_id);////added for MMSissue replication 170215 end
					resultSet_store = pstmt_store.executeQuery() ;
								
					if(resultSet_store!=null && resultSet_store.next()){
						disp_locn =resultSet_store.getString("DISP_LOCN");
						if(disp_locn!=null && !disp_locn.equals("")){
							if(disp_locn.indexOf("|")>0){
								store_code = disp_locn.substring(0,disp_locn.indexOf("|"));
								store_desc = disp_locn.substring(disp_locn.indexOf("|")+1,disp_locn.lastIndexOf("|"));

							}
						}
					}
					closeStatement(pstmt_store);
					closeResultSet(resultSet_store);
					}
					else{
						store_code = getStoreCode();
						store_desc = getStoreDesc();
					}
					store_code = store_code==null?"":store_code;
					store_desc = store_desc==null?"":store_desc;

					hmItemDetail.put("STORE_CODE",store_code);
					hmItemDetail.put("STORE_DESC",store_desc);
					
					cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString( 1, item_code+"="+trade_code);
					cstmt.setString( 2, store_code);
					cstmt.setString( 3, "1");
					cstmt.setString( 4, "Y");
					cstmt.setString( 5, getSysdate());
					cstmt.setString( 6, "N");
					cstmt.setString( 7, "");
					cstmt.registerOutParameter(8, Types.VARCHAR );
					cstmt.registerOutParameter(9, Types.VARCHAR );
					cstmt.registerOutParameter(10, Types.VARCHAR );
					cstmt.registerOutParameter(11, Types.INTEGER );
					cstmt.registerOutParameter(12, Types.VARCHAR );
					cstmt.registerOutParameter(13, Types.VARCHAR );
					cstmt.registerOutParameter(14, Types.VARCHAR );
					cstmt.registerOutParameter(15, Types.VARCHAR );
					cstmt.registerOutParameter(16, Types.VARCHAR );
					cstmt.registerOutParameter(17, Types.VARCHAR );
					cstmt.registerOutParameter(18, Types.VARCHAR );
					cstmt.registerOutParameter(19, Types.VARCHAR );
					cstmt.execute() ;
						
					//Modified for IN072995 START
					int avail_stock=0;
					if(!ext_disp_appl){
					 avail_stock = cstmt.getInt(11);
					 ext_disp_appl_yn = "N";
					}
					else{
						if(external_disp_yn.containsKey(store_code)){
							ext_disp_appl_yn = (String)external_disp_yn.get(store_code);
						}else{
							ext_disp_appl_yn = getExtDispYN(store_code);
						}
						if(ext_disp_appl_yn.equals("Y")){
							
							pstmt_store = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_EXTERNAL_DISPENSING_QTY") );
							pstmt_store.setString(1,store_code);
							pstmt_store.setString(2,item_code);

							resultSet_store = pstmt_store.executeQuery() ;
												
							if(resultSet_store!=null && resultSet_store.next()){					
									avail_stock = resultSet_store.getInt("EXTERNAL_ITEM_QTY");
							}
							System.out.println("avail_stock=====>"+avail_stock);
							closeStatement(pstmt_store);
							closeResultSet(resultSet_store);
						}
						else{
							avail_stock = cstmt.getInt(11);
						}
						 
					}
					

					if(avail_stock<=0){
						avail_stock	=	0;
						stock_yn="N";
					}
					hmItemDetail.put("STOCK_YN",stock_yn);
					//Modified for IN072995 End
					hmItemDetail.put("AVAIL_QTY",avail_stock+"");
					hmItemDetail.put("EXT_DISP_APPL_YN",ext_disp_appl_yn);	//Added for IN072995
					alItemList.add(hmItemDetail );

				}
			}
			closeResultSet( resultSet_item ) ;
			closeStatement( pstmt_item ) ;
			if( start != 1 )
				prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLink('"+(start-query_result_size)+"','"+(end-query_result_size)+"');\">Previous&nbsp;&nbsp;</a>" ;
			int intCount=10;
			if( count > intCount )
				prevnextlink =prevnextlink+ "<td class='WHITE' align='right'><a href=\"javascript:SubmitLink('"+(start+query_result_size)+"','"+(end+query_result_size)+"');\">Next</a>" ;
			alItemList.set(0,prevnextlink);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet_item ) ;
				closeStatement( pstmt_item ) ;
				closeConnection( connection );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return alItemList;
	}

	public void storeSelectedItem(Hashtable items){
		ArrayList itemDet = null;
		if(items != null){
			String index = (String)items.get("index");
			if(index!=null && !index.equals("")){
				int indx = Integer.parseInt(index);
				if(items.get("select"+indx) != null){
					String select = (String)items.get("select"+indx);
					if (select.equals("E")){
						itemDet = new ArrayList();
						itemDet.add((String)items.get("item_code"+(indx)));
						itemDet.add((String)items.get("trade_code"+(indx)));
						itemDet.add(java.net.URLEncoder.encode((String)items.get("trade_name"+(indx))));
						selectedItemList.put((String)items.get("item_code"+(indx))+(String)items.get("line_no"+(indx)),itemDet);
					}
					else{
						selectedItemList.remove((String)items.get("item_code"+(indx))+(String)items.get("line_no"+(indx)));
					}
				}
			}
		}
	}

	public HashMap getSelectedItems(){
		return selectedItemList;
	}
	public void setSelectedItems(){
		selectedItemList= new HashMap();
	}

	//modified By Himanshu  added Available_Qty in param for GHL-SCF-1738-->
	public void loadItemDetail(String item_code, String order_set_code, String order_set_occur_num, String trade_code, String trade_name, String bl_install_yn, String bl_disp_charge_dtl_in_rx_yn, String take_home_medication, String priority,  String pract_id, String resp_id, String available_stock ){
		//System.err.println("@@@loadItemDetail  item_code="+item_code+" trade_code="+trade_code+" trade_name="+trade_name+" bl_install_yn="+bl_install_yn+" bl_disp_charge_dtl_in_rx_yn="+bl_disp_charge_dtl_in_rx_yn+" take_home_medication="+ take_home_medication+" priority="+priority+" pract_id="+pract_id+" resp_id="+resp_id);
		Connection connection       = null ;
		PreparedStatement pstmt_item     = null ;
		PreparedStatement pstmt_store     = null ;
		PreparedStatement pstmt     = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet_item         = null ;
		ResultSet resultSet_store         = null ;
		ResultSet rsDecimalPlace         = null ;
		ResultSet resultSet         = null ;
		String sql_query_item			= "";
		HashMap hmItemDetail= null;
		String store_code="";
		String store_desc="";
		String disp_locn="";
		String order_type="";
		String total_charge_amt="";		
		String patient_payable_amt="";		
		String bl_included_IE="";	
		String approval_reqd_yn="";		
		String override_allowed_yn="";		
		String error_code = "";		
		String sys_message_id = "";	
		String error_text = "";	
		String encounter_id = getEncounterId();
		String episode_id = "";
		String visit_id = "";
		String episode_type = "";
		String decimalFormatString = "#0";
		int decimal_place = 0;
		//String uom_code="";
		String uom_desc=""; //added on 11/2/2010
		String drug_code=item_code; //added on 11/2/2010 for the scf-4185
		String performingFacilityId = "";

		try{
			connection = getConnection() ;

			//sql_query_item        = PhRepository.getPhKeyValue("SQL_PH_CONSUMABLERX_ITEM_LOOKUP_SELECT");
			sql_query_item = "SELECT ord_cat.order_catalog_code item_code, ord_cat.short_desc long_desc,mtr.trade_id, mm.gen_uom_code uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE language_id = ? AND uom_code = mm.gen_uom_code) uom_desc, ord_cat.order_type_code, ord_cat.order_category, ord_cat.CONSENT_REQD_YN, ord_cat.BILL_YN FROM or_order_catalog ord_cat, st_item st, mm_item_lang_vw mm, mm_trade_name_for_item mtr WHERE medical_item_yn = 'Y' AND drug_item_yn = 'N' AND st.item_code = mm.item_code AND mm.language_id = ? AND ord_cat.order_catalog_code = mm.item_code AND ord_cat.order_category = 'PH' AND st.item_code = mtr.item_code(+) AND ord_cat.order_catalog_code = ? and NVL(mtr.trade_id,'X') = DECODE(?,NULL,NVL (mtr.trade_id, 'X'),?)order by trade_id";

			pstmt_item				= connection.prepareStatement(sql_query_item) ;
			pstmt_item.setString(1,getLanguageId());
			pstmt_item.setString(2,getLanguageId());
			pstmt_item.setString(3,item_code);
			pstmt_item.setString(4,trade_code);
			pstmt_item.setString(5,trade_code);
			resultSet_item			= pstmt_item.executeQuery();

			//while(resultSet_item!=null && resultSet_item.next()) {
			if(resultSet_item!=null && resultSet_item.next()) {
				hmItemDetail= new HashMap();
				item_code = resultSet_item.getString("item_code");
				decimalFormatString = "#0";
				hmItemDetail.put("ITEM_CODE",item_code);
				hmItemDetail.put("ITEM_DESC",resultSet_item.getString("long_desc"));
				hmItemDetail.put("TRADE_CODE",resultSet_item.getString("trade_id")==null?"":resultSet_item.getString("trade_id"));
				if(trade_code.equals(""))
					trade_code = resultSet_item.getString("trade_id")==null?"":resultSet_item.getString("trade_id");
				//hmItemDetail.put("TRADE_CODE",trade_code);
				hmItemDetail.put("UOM_CODE",resultSet_item.getString("UOM_CODE"));
				hmItemDetail.put("UOM_DESC",resultSet_item.getString("UOM_DESC"));
				hmItemDetail.put("ORDER_TYPE",resultSet_item.getString("ORDER_TYPE_CODE"));
				hmItemDetail.put("ORDER_CATEGORY",resultSet_item.getString("ORDER_CATEGORY"));
				hmItemDetail.put("CONSENT_REQD_YN",resultSet_item.getString("CONSENT_REQD_YN"));
				hmItemDetail.put("BILL_YN",resultSet_item.getString("BILL_YN"));
				hmItemDetail.put("QTY_VALUE","1");
				hmItemDetail.put("SELECTED_YN","Y");
				hmItemDetail.put("PRIORITY",priority);
				hmItemDetail.put("REQD_OR_OPT_IND","");
				hmItemDetail.put("available_stock",available_stock); //Available_Qty Added By Himanshu for GHL-SCF-1738 on 3/10/2023 -->
				order_type = resultSet_item.getString("ORDER_TYPE_CODE");

				if(order_set_code!=null && !order_set_code.equals("")){
					if(order_set_occur_num==null || order_set_occur_num.equals(""))
						order_set_occur_num = "1";
					pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CONSUMABLERX_ORDERSET_ITEM_SELECT")) ;
					//pstmt				= connection.prepareStatement("SELECT QTY_VALUE, QTY_UNIT,REQD_OR_OPT_IND,(SELECT short_desc FROM am_uom_lang_vw WHERE language_id = ? AND uom_code = qty_unit) uom_desc FROM OR_ORDER_SET_COMPONENT WHERE ORDER_SET_CODE = ? AND ORDER_CATALOG_CODE = ? AND OCURRANCE_NUM = ?") ;
					pstmt.setString(1,getLanguageId());
					pstmt.setString(2,order_set_code);
					pstmt.setString(3,item_code);
					pstmt.setString(4,order_set_occur_num);
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						hmItemDetail.put("QTY_VALUE",(resultSet.getString("QTY_VALUE")==null ? "":resultSet.getString("QTY_VALUE")) );
						hmItemDetail.put("UOM_CODE",(resultSet.getString("QTY_UNIT")==null ? "":resultSet.getString("QTY_UNIT")) );
						hmItemDetail.put("REQD_OR_OPT_IND",(resultSet.getString("REQD_OR_OPT_IND")==null ? "":resultSet.getString("REQD_OR_OPT_IND")) );
						//uom_code=resultSet.getString("QTY_UNIT")==null ? "":resultSet.getString("QTY_UNIT");
						uom_desc=resultSet.getString("UOM_DESC")==null ? "":resultSet.getString("UOM_DESC");
						closeResultSet( resultSet ) ;
						closeStatement( pstmt ) ;
						if(uom_desc.equals("")){  //condition added on 11/2/2010 for the scf-4185 (UOM description  equals null
							pstmt			 = connection.prepareStatement("SELECT a.short_desc FROM am_uom_lang_vw a,ph_drug b WHERE a.language_id = ? AND a.uom_code = b.PRES_BASE_UOM and b.drug_code =?") ;	
							pstmt.setString(1,getLanguageId());
							pstmt.setString(2,drug_code);
							//System.err.println("drug_code= in inner if= 893=>" +drug_code);
							resultSet			= pstmt.executeQuery();
							if(resultSet!=null && resultSet.next())	{
								uom_desc=resultSet.getString("SHORT_DESC");	
							}
							closeResultSet( resultSet ) ;
							closeStatement( pstmt ) ;
						}
						hmItemDetail.put("UOM_DESC",uom_desc); //ends coding ---if uom==null condition.
					}
				}
				if(!trade_code.equals("")&&trade_name.equals("")){
					pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CONSUMABLERX_ITEM_TRADE_SELECT"));
					//pstmt				= connection.prepareStatement("SELECT short_name trade_name FROM am_trade_name_lang_vw WHERE language_id = ? AND trade_id = ?") ;
					pstmt.setString(1,getLanguageId());
					pstmt.setString(2,trade_code);
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						trade_name = resultSet.getString("TRADE_NAME")==null ? "":resultSet.getString("TRADE_NAME");
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}
				hmItemDetail.put("TRADE_NAME",trade_name);
				pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT3A")) ;
				pstmt.setString(1,item_code);
				pstmt.setString(2,getPatientClass());
				pstmt.setString(3,getLanguageId());
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()) {
					hmItemDetail.put("ORD_AUTH_LEVEL",(resultSet.getString("ORD_AUTH_LEVEL")==null ? "":resultSet.getString("ORD_AUTH_LEVEL")) );
				}
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;

				//to get Billing Details
				if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
					episode_type= getActPatientClass();
					if(episode_type !=null && (!episode_type.equals("")))
						episode_type = episode_type.substring(0,1);

					if(episode_type !=null && episode_type.equals("X"))
						episode_type = "R";
					
						if(encounter_id!= null && !encounter_id.equals("")){
							episode_id = encounter_id;
							if(episode_type.equals("O")||episode_type.equals("E")){
								episode_id = encounter_id.substring(0,(encounter_id.length()-4));
								visit_id = encounter_id.substring(encounter_id.length()-4);
							}
						}
						cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
						cstmt.setString( 1, login_facility_id);
						cstmt.setString( 2, "PH");	//module id
						cstmt.setString( 3, "");	//
						cstmt.setString( 4, "");	//
						cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
						cstmt.setString( 6, getPatientId()); //patient_id
						cstmt.setString( 7, episode_id);  //episode_id
						cstmt.setString( 8, visit_id);  //p_visit_id  
						cstmt.setString( 9, ""); //p_dummy1 - null
						cstmt.setString( 10, ""); //p_dummy12 - null
						cstmt.setString( 11, "SAL"); //p_transaction_type
						cstmt.setString( 12, getSysdatetimesec()); //p_charge_date_time	--Service Data and time

						cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
						cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
						cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
						cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null
						cstmt.setString( 17, item_code);  //p_item_code
						cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
						cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 
						cstmt.setString( 20, "S");  //p_serv_panel_ind

						cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

						cstmt.setString( 22,"1" );  //qty served
						cstmt.setString( 23, "");  //p_charge_amt  

						cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

						cstmt.setString( 25,"" );  //p_store_code -- Store Code from where issued
						cstmt.setString( 26, "");  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
						cstmt.setString( 27,"" );  //p_oth_disc_perc if any other manual discount is given from transaction
						cstmt.setString( 28, "");  //p_source_doc_ref		null for Sale
						cstmt.setString( 29,"" );  //p_source_doc_ref_line	null for Sale

						cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_qty
						cstmt.registerOutParameter(31, Types.NUMERIC ); //p_base_rate
						cstmt.registerOutParameter(32, Types.NUMERIC ); //p_addl_factor
						cstmt.registerOutParameter(33, Types.NUMERIC ); //p_base_charge_amt       
						cstmt.registerOutParameter(34, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
						cstmt.registerOutParameter(35, Types.NUMERIC ); //p_DISC_AMT              
						cstmt.registerOutParameter(36, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
						cstmt.registerOutParameter(37, Types.NUMERIC ); //p_disc_perc             
						cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
						cstmt.registerOutParameter(39, Types.NUMERIC ); //p_PAT_DISC_AMT          
						cstmt.registerOutParameter(40, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
						cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
						cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_DISC_AMT         
						cstmt.registerOutParameter(43, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
						cstmt.registerOutParameter(44, Types.VARCHAR ); //p_SPLIT_IND             
						cstmt.registerOutParameter(45, Types.NUMERIC ); //p_curr_availed          
						cstmt.registerOutParameter(46, Types.VARCHAR ); //p_credit_auth_ref       
						cstmt.registerOutParameter(47, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt

						cstmt.setString( 48,"" );  //p_dummy4 (IN OUT )
						cstmt.setString( 49, "");  //p_batch_prices  (IN OUT )
						
						cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
						cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
						cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
						cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

						cstmt.setString( 54,"" );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
						cstmt.setString( 55, "");  //p_overridden_action_reason		 --- Pass null or any value entered 

						cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
						cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
						cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text

						cstmt.execute() ;

						total_charge_amt		=cstmt.getString(36);
						patient_payable_amt		= cstmt.getString(40);
						bl_included_IE	= cstmt.getString(51)==null?"":cstmt.getString(51);             
						approval_reqd_yn		= cstmt.getString(52)==null?"":cstmt.getString(52);   
						override_allowed_yn		= cstmt.getString(53)==null?"":cstmt.getString(53); 

						error_code		= cstmt.getString(56);
						sys_message_id	= cstmt.getString(57);
						error_text		= cstmt.getString(58);
						closeStatement( cstmt ) ;

						pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_BLCORE_GET_DECIMAL_PLACE"));
						pstmt.setString(1,login_facility_id);
						rsDecimalPlace = pstmt.executeQuery();
						if(rsDecimalPlace.next())
							decimal_place = rsDecimalPlace.getInt("decimal_place");
						closeStatement( pstmt ) ;
						closeResultSet( rsDecimalPlace ) ;

						if(decimal_place > 0)
							decimalFormatString = decimalFormatString+".";

						for(int i=1;i<=decimal_place;i++){
							decimalFormatString = decimalFormatString+"0";
						}

						if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
							DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
							patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
						}
						if(total_charge_amt!=null && !total_charge_amt.equals("")){
							DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
							total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
						}

						hmItemDetail.put("BL_TOTAL_CHARGE_AMT",total_charge_amt);
						hmItemDetail.put("BL_PATIENT_PAYABLE_AMT",patient_payable_amt);
						hmItemDetail.put("BL_INCL_EXCL_VALUE",bl_included_IE);
						hmItemDetail.put("BL_APPROVAL_REQD_YN",approval_reqd_yn);
						hmItemDetail.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn);
						hmItemDetail.put("BL_ERROR_CODE",error_code);
						hmItemDetail.put("BL_SYS_MESSAGE_ID",sys_message_id);
						hmItemDetail.put("BL_ERROR_TEXT",error_text);
						hmItemDetail.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);
					}
					//Billing Details ends here

					hmItemDetail.put("ORD_AUTH_REQD_YN","N");
					hmItemDetail.put("ORD_SPL_APPR_REQD_YN","N");
					hmItemDetail.put("ORD_COSIGN_REQD_YN","N");
					hmItemDetail.put("ORD_AUTHORIZED_YN","N" );
					hmItemDetail.put("ORD_APPROVED_YN","N");
					hmItemDetail.put("ORD_COSIGNED_YN","N");

					pstmt				= connection.prepareStatement("select SPECIALTY_CODE from pr_encounter where facility_id=? and encounter_id=?") ;
					pstmt.setString(1,login_facility_id);
					pstmt.setString(2,encounter_id);
					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						hmItemDetail.put("PAT_SPECIALTY_CODE",(resultSet.getString("SPECIALTY_CODE")==null ? "":resultSet.getString("SPECIALTY_CODE")) );
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;

					cstmt=connection.prepareCall("{call PH_ORDER_CATALOG_AUTH_RULE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString( 1, item_code);
					cstmt.setString( 2, getPatientClass());
					cstmt.setString( 3, getLanguageId());
					cstmt.setString( 4, resp_id);
					cstmt.setString( 5, pract_id);
					cstmt.setString( 6, "");
					cstmt.setString( 7, "PH");
					cstmt.registerOutParameter(8, Types.VARCHAR );
					cstmt.registerOutParameter(9, Types.VARCHAR );
					cstmt.registerOutParameter(10, Types.VARCHAR );
					cstmt.registerOutParameter(11, Types.VARCHAR );
					cstmt.registerOutParameter(12, Types.VARCHAR );
					cstmt.registerOutParameter(13, Types.VARCHAR );
					cstmt.setString( 7, "PH");
					cstmt.registerOutParameter(13, Types.VARCHAR );
					cstmt.setString( 14, (String)hmItemDetail.get("PAT_SPECIALTY_CODE"));
					cstmt.setString( 15, patient_id);// Added for Bru-HIMS-CRF-385 [IN:041644]
					cstmt.setString( 16, getOrderDate());// Added for Bru-HIMS-CRF-385 [IN:041644]
					cstmt.setString( 17, priority);// Added for HSA-CRF-0150 [IN:048467]
					cstmt.registerOutParameter(18, Types.VARCHAR ); // ML-MMOH-CRF-1823 US008- 43528 
					cstmt.execute() ;
			
					hmItemDetail.put("ORD_AUTH_REQD_YN",(cstmt.getString(8)==null ? "N":cstmt.getString(8)));
					hmItemDetail.put("ORD_SPL_APPR_REQD_YN",(cstmt.getString(9)==null ? "N":cstmt.getString(9)) );
					hmItemDetail.put("ORD_COSIGN_REQD_YN",(cstmt.getString(10)==null ? "N":cstmt.getString(10)) );
					hmItemDetail.put("ORD_AUTHORIZED_YN",(cstmt.getString(11)==null ? "N":cstmt.getString(11)) );
					hmItemDetail.put("ORD_APPROVED_YN",(cstmt.getString(12)==null ? "N":cstmt.getString(12)) );
					hmItemDetail.put("ORD_COSIGNED_YN",(cstmt.getString(13)==null ? "N":cstmt.getString(13)) );
					//hmItemDetail.put("PAT_SPECIALTY_CODE",(cstmt.getString(14)==null ? "N":cstmt.getString(14)) );

					closeStatement( cstmt ) ;
//System.err.println("@@@768 LocationType="+getLocationType()+" LocationCode="+getLocationCode()+" login_facility_id="+login_facility_id+" drug_class="+" item_code="+item_code+" order_type="+order_type+" PatientClass="+getPatientClass()+" take_home_medication="+take_home_medication+" priority="+priority+" getLanguageId="+getLanguageId());
					//pstmt_store = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT16A") );
					pstmt_store = connection.prepareStatement("SELECT PH_DISP_STOCK_LOCN(?,?,?,?,?,?,?,?,?,?,?,'M',?,?,?) DISP_LOCN from dual");
					pstmt_store.setString(1,getLocationType());
					pstmt_store.setString(2,getLocationCode());
					pstmt_store.setString(3,login_facility_id);
					pstmt_store.setString(4,login_facility_id);
					pstmt_store.setString(5,""); //drug_class
					pstmt_store.setString(6,item_code);
					pstmt_store.setString(7,order_type);
					pstmt_store.setString(8,getActPatientClass());
					pstmt_store.setString(9,take_home_medication);
					pstmt_store.setString(10,priority);
					pstmt_store.setString(11,getLanguageId());
					pstmt_store.setString(12,takeHomeMedication);//added for MMSissue replication 170215 start
					pstmt_store.setString(13,getPatientId());
					pstmt_store.setString(14,encounter_id);//added for MMSissue replication 170215 end
					resultSet_store = pstmt_store.executeQuery() ;
								
					if(resultSet_store!=null && resultSet_store.next()){
						disp_locn =resultSet_store.getString("DISP_LOCN");
						if(disp_locn!=null && !disp_locn.equals("")){
							if(disp_locn.indexOf("|")>0){
								store_code = disp_locn.substring(0,disp_locn.indexOf("|"));
								store_desc = disp_locn.substring(disp_locn.indexOf("|")+1);
 
								if(store_desc.indexOf("|") <= store_desc.length()) // added for IN25723 --05/01/2011-- priya (perf_facility was not getting updated if the medical item was not confirmed)
									performingFacilityId = store_desc.substring(store_desc.indexOf("|")+1);
								else
									performingFacilityId = "";
							}
						}
					}
					closeStatement(pstmt_store);
					closeResultSet(resultSet_store);
					store_code = store_code==null?"":store_code;
					store_desc = store_desc==null?"":store_desc;

					hmItemDetail.put("STORE_CODE",store_code);
					hmItemDetail.put("STORE_DESC",store_desc);
					hmItemDetail.put("PERFORMING_FACILITY_ID",performingFacilityId);  // added for IN25723 --05/01/2011-- priya
                    pstmt				= connection.prepareStatement("Select form_code,route_code from ph_drug_lang_vw where drug_code =? and language_id=?") ;
					pstmt.setString(1,item_code);
					pstmt.setString(2,getLanguageId());

					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						hmItemDetail.put("FORM_CODE",(resultSet.getString("form_code")==null ? "":resultSet.getString("form_code")) );
						hmItemDetail.put("ROUTE_CODE",(resultSet.getString("route_code")==null ? "":resultSet.getString("route_code")) );
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;

					pstmt				= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT14")) ;
					pstmt.setString(1,getLanguageId());

					resultSet			= pstmt.executeQuery();
					if(resultSet!=null && resultSet.next()) {
						hmItemDetail.put("FREQ_CODE",(resultSet.getString("freq_code")==null ? "":resultSet.getString("freq_code")) );
					}
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
					hmItemDetail.put("ITEM_REMARKS","");	//Added for GHL-CRF-0470		
					presItemList.add(hmItemDetail );
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet ) ;
				closeStatement( cstmt ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	public ArrayList getTrades(String item_code){
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList tradeNames		= new ArrayList();
		try{
			connection				= getConnection() ;
			String str_qry			= PhRepository.getPhKeyValue("SQL_PH_CONSUMABLERX_ITEM_TRADELIST_SELECT");
			//String str_qry			= "select mmtrd.trade_id, amtrdvw.short_name trade_name from mm_trade_name_for_item mmtrd, am_trade_name_lang_vw amtrdvw where mmtrd.item_code=? and amtrdvw.language_id=? and mmtrd.trade_id = amtrdvw.trade_id";
			pstmt					= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,item_code);
			pstmt.setString(2,getLanguageId());
			resultSet				= pstmt.executeQuery();
			while(resultSet.next()){
				tradeNames.add(resultSet.getString("trade_id")==null?"":resultSet.getString("trade_id"));
				tradeNames.add(resultSet.getString("trade_name")==null?"":resultSet.getString("trade_name"));
			}
		}
		catch ( Exception e ) {
            e.printStackTrace() ;
		}
		finally {
            try{
                 closeResultSet( resultSet ) ;
                 closeStatement( pstmt ) ;
                 closeConnection( connection );
            }
			catch(Exception es){
				es.printStackTrace();
			}
        }
		return tradeNames;
	}

	public void setBillingDetail(HashMap itemDetails, String episode_type, String patient_id, String encounter_id, String item_code, String ordered_qty,String take_home_medication){
		Connection connection       = null ;
		CallableStatement cstmt		= null ;
		PreparedStatement pstmt		= null;
		ResultSet rsDecimalPlace	= null;
		int decimal_place			= 0;
		String decimalFormatString	= "#0";
		String episode_id			= "";
		String visit_id				= "";
		String total_charge_amt		= "";
		String patient_payable_amt	= "";
		String approval_reqd_yn		= "";
		String override_allowed_yn	= "";
		String bl_included_IE		= "";
		String error_code			= "";		 
		String sys_message_id		= "";	
		String error_text			= "";
		String billable_item_yn		= "";
		String gross_amt      = ""; // Added for ML-BRU-CRF-0469 [IN:065426]
		String bl_incl_excl_override_value  = (String)itemDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)itemDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");
		String overriden_action_reason		= (String)itemDetails.get("BL_INCL_EXCL_OVERRIDE_REASON")==null?"":(String)itemDetails.get("BL_INCL_EXCL_OVERRIDE_REASON");

			//callin billing procedure
		try{
			connection				= getConnection() ;
			
				if(encounter_id!= null && !encounter_id.equals("")){
					episode_id = encounter_id;
					if(episode_type.equals("O")||episode_type.equals("E")){
						episode_id = encounter_id.substring(0,(encounter_id.length()-4));
						visit_id = encounter_id.substring(encounter_id.length()-4);
					}
				}
				billable_item_yn = getBillableItemYN(item_code);
				if(billable_item_yn.equals("Y")){
					cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?,?)}");
					cstmt.setString( 1, login_facility_id);
					cstmt.setString( 2, "PH");	//module id
					cstmt.setString( 3, "");	//
					cstmt.setString( 4, "");	//
					cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
					cstmt.setString( 6, getPatientId()); //patient_id
					cstmt.setString( 7, episode_id);  //episode_id
					cstmt.setString( 8, visit_id);  //p_visit_id  
					cstmt.setString( 9, ""); //p_dummy1 - null
					cstmt.setString( 10, ""); //p_dummy12 - null
					cstmt.setString( 11, "SAL"); //p_transaction_type
					cstmt.setString( 12, getSysdatetimesec()); //p_charge_date_time	--Service Data and time
					cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
					cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
					cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
					cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

					cstmt.setString( 17, item_code);  //p_item_code

					cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
					cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 

					cstmt.setString( 20, "S");  //p_serv_panel_ind

					cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

					cstmt.setString( 22,ordered_qty );  //qty served
					cstmt.setString( 23, "");  //p_charge_amt  

					cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

					cstmt.setString( 25,"" );  //p_store_code -- Store Code from where issued
					cstmt.setString( 26, "");  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
					cstmt.setString( 27,"" );  //p_oth_disc_perc if any other manual discount is given from transaction
					cstmt.setString( 28, "");  //p_source_doc_ref		null for Sale
					cstmt.setString( 29,"" );  //p_source_doc_ref_line	null for Sale

					cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_qty
					cstmt.registerOutParameter(31, Types.NUMERIC ); //p_base_rate
					cstmt.registerOutParameter(32, Types.NUMERIC ); //p_addl_factor
					cstmt.registerOutParameter(33, Types.NUMERIC ); //p_base_charge_amt       
					cstmt.registerOutParameter(34, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
					cstmt.registerOutParameter(35, Types.NUMERIC ); //p_DISC_AMT              
					cstmt.registerOutParameter(36, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
					cstmt.registerOutParameter(37, Types.NUMERIC ); //p_disc_perc             
					cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
					cstmt.registerOutParameter(39, Types.NUMERIC ); //p_PAT_DISC_AMT          
					cstmt.registerOutParameter(40, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
					cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
					cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_DISC_AMT         
					cstmt.registerOutParameter(43, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
					cstmt.registerOutParameter(44, Types.VARCHAR ); //p_SPLIT_IND             
					cstmt.registerOutParameter(45, Types.NUMERIC ); //p_curr_availed          
					cstmt.registerOutParameter(46, Types.VARCHAR ); //p_credit_auth_ref       
					cstmt.registerOutParameter(47, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt

					cstmt.setString( 48,"" );  //p_dummy4 (IN OUT )
					cstmt.setString( 49, "");  //p_batch_prices  (IN OUT )
					
					cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
					cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
					cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
					cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

					cstmt.setString( 54,bl_incl_excl_override_value );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
					cstmt.setString( 55, overriden_action_reason);  //p_overridden_action_reason		 --- Pass null or any value entered 

					cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
					cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
					cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text
					cstmt.setString( 59, take_home_medication);

					cstmt.execute() ;

				total_charge_amt		=cstmt.getString(36);
				patient_payable_amt		= cstmt.getString(40);
				bl_included_IE			= cstmt.getString(51)==null?"":cstmt.getString(51);             
				approval_reqd_yn		= cstmt.getString(52)==null?"":cstmt.getString(52);   
				override_allowed_yn		= cstmt.getString(53)==null?"":cstmt.getString(53); 
				gross_amt		=cstmt.getString(34); // Added for ML-BRU-CRF-0469 [IN:065426]
				error_code		= cstmt.getString(56);
				sys_message_id	= cstmt.getString(57);
				error_text		= cstmt.getString(58);
				closeStatement( cstmt ) ;


				pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_BLCORE_GET_DECIMAL_PLACE"));
				pstmt.setString(1,login_facility_id);
				rsDecimalPlace = pstmt.executeQuery();
				if(rsDecimalPlace.next())
					decimal_place = rsDecimalPlace.getInt("decimal_place");
				closeStatement( pstmt ) ;
				closeResultSet( rsDecimalPlace ) ;

				if(decimal_place > 0)
					decimalFormatString = decimalFormatString+".";

				for(int i=1;i<=decimal_place;i++){
					decimalFormatString = decimalFormatString+"0";
				}

				if(patient_payable_amt!=null && !patient_payable_amt.equals("")){
					DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
					patient_payable_amt = dfTest.format(Double.parseDouble(patient_payable_amt));
				}
				if(total_charge_amt!=null && !total_charge_amt.equals("")){
					DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
					total_charge_amt = dfTest.format(Double.parseDouble(total_charge_amt));
				}
				if(gross_amt!=null && !gross_amt.equals("")){ // Added for ML-BRU-CRF-0469 [IN:065426] - Start
					DecimalFormat dfTest = new DecimalFormat(decimalFormatString);
					gross_amt = dfTest.format(Double.parseDouble(gross_amt));
				} // ML-BRU-CRF-0469 [IN:065426] - End
			}

		}
		catch(Exception e){
			error_text = "Error in Proc";
			e.printStackTrace();
		}
		finally{
			try{
				closeStatement( cstmt ) ;
				closeStatement( pstmt ) ;
				closeResultSet( rsDecimalPlace ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
       if(billable_item_yn.equals("Y")){
			itemDetails.put("BL_CHARGE_AMT",total_charge_amt);
			itemDetails.put("BL_PATIENT_PAYABLE",patient_payable_amt);
			itemDetails.put("BL_INCL_EXCL_VALUE",bl_included_IE);
			itemDetails.put("BL_APPRVL_REQD_YN",approval_reqd_yn);
			itemDetails.put("BL_OVERRIDE_ALLOWED_YN",override_allowed_yn);
			itemDetails.put("BL_ERROR_CODE",error_code);
			itemDetails.put("BL_SYS_MESSAGE_ID",sys_message_id);
			itemDetails.put("BL_ERROR_TEXT",error_text);
			itemDetails.put("BL_DECIMAL_FORMAT_STRING",decimalFormatString);
			itemDetails.put("BL_GROSS_AMT",gross_amt); // Added for ML-BRU-CRF-0469 [IN:065426]
	   }
		itemDetails.put("BILLABLE_ITEM_YN",billable_item_yn);
		return;
	}

	public ArrayList genOrderID(int groupSize,String patient_class) {

		if(!patient_class.trim().equals("IP") && patient_class.trim().equals("EM")) {
			patient_class = "OP";
		}
		OrderID =new ArrayList();
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		String sql_query			= "";
		try{
			connection = getConnection() ;
			sql_query        = PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT37");
			for(int i=0;i<groupSize;i++){
				pstmt				= connection.prepareStatement(sql_query) ;
				pstmt.setString(1,"PH");
				pstmt.setString(2,patient_class);
				pstmt.setString(3, login_facility_id); //thrid parameter for facility added for IN[032925]
				resultSet			= pstmt.executeQuery();
				if(resultSet!=null && resultSet.next()){
					OrderID.add((String)resultSet.getString("order_id"));
				}
				try{
					closeResultSet( resultSet ) ;
					closeStatement( pstmt ) ;
				}catch(Exception es){
					es.printStackTrace() ;
				}
			}
		}catch ( Exception e ) {
			OrderID.add(e);
			System.err.println( "Error @ generating Order ID :"+e ) ;
			e.printStackTrace() ;
		} finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}catch(Exception es){}
		}

		return OrderID;
	}
	public HashMap insert() {
		
		String locale= getLanguageId()==null?"en":getLanguageId();
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

		ArrayList mandatory_flds	=	new ArrayList();

		mandatory_flds.add(login_by_id);
		mandatory_flds.add(login_at_ws_no);
		mandatory_flds.add(login_facility_id);

		HashMap tabData	= new HashMap();
		HashMap sqlMap		= new HashMap();
		ArrayList presItemList=getPresItemList();
		
		HashMap itemDetail = new HashMap();
		try {
			tabData.put("properties", getProperties() );
			String str_date = "";
			for(int j=0;j<presItemList.size();j++){
				itemDetail = (HashMap) presItemList.get(j);
					if(!locale.equals("en"))
						{
							str_date = (String)itemDetail.get("ORDERED_DATE");
							itemDetail.put("ORDERED_DATE", com.ehis.util.DateUtils.convertDate(str_date, "DMYHM",locale,"en"));
						}
				itemDetail.put("PRIORITY",getPriority()); //added for IN26242 --02/02/2011-- priya
			}
			//Added for Bru-HIMS-CRF-393_1.0-Start 
			HashMap orderTypeDetails=new HashMap();
			String  order_type_code="";
			String patient_class="";
			HashSet keyset=new HashSet();
			if(getActPatientClass().equals("I"))
					patient_class  ="IP";
				else if(getActPatientClass().equals("D"))
					patient_class  ="DC";
				else if(getActPatientClass().equals("O"))
					patient_class  ="OP";
				else if(getActPatientClass().equals("E"))
					patient_class  ="EM";
				else if(getActPatientClass().equals("R"))
					patient_class  ="XT";
				else
					patient_class =getActPatientClass();
			for(int i=0;i<presItemList.size();i++){
				 orderTypeDetails=(HashMap)presItemList.get(i);
				 order_type_code=(String)orderTypeDetails.get("ORDER_TYPE_CODE");
				 keyset.add(order_type_code);
			}
			setPrintOrdShtRuleInd(keyset,patient_class);
			//Added for Bru-HIMS-CRF-393_1.0-End
			tabData.put("presItemList",presItemList);
			tabData.put("mandatory_flds",mandatory_flds);
			tabData.put("called_from",this.called_from);
			tabData.put("language_id",locale);
			tabData.put("license",(String)(PhLicenceRights.getKey()));
			tabData.put("called_from",getCalledFrom());
			tabData.put("OrderRemarks",this.OrderRemarks);	//Added for GHL-CRF-0470 

			tabData.put("nonPreferenceRemarksMedicalItem",getNonPrefernceRemarksMedicalItem());//GHL-CRF-0618
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT19A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT19A") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT20A", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT20A") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT55", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT55") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT",PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_TRN_GROUP_REF_SELECT") );

			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT1", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT1") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT2", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT2") );

			//sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT3", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT3") );	//Commented for GHL-CRF-0470
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT3", "INSERT INTO OR_ORDER_LINE_PH (ORDER_ID,ORDER_LINE_NUM,GENERIC_ID,FORM_CODE,TRADE_CODE,FORMULARY_ITEM_YN,DOSAGE_TYPE,SPLIT_DRUG_PREVIEW,TOT_STRENGTH,TOT_STRENGTH_UOM,INFUSE_OVER,INFUSE_OVER_UNIT,INFUSION_RATE,INFUSION_VOL_STR_UNIT,INFUSION_PER_UNIT,BROUGHT_BY_PATIENT_YN,CUR_DRUG_YN,REFILL_DRUG_YN,DISPENSING_LOC_TYPE,DISPENSING_LOC,DISPENSING_STORE,IP_FILL_PROCESS,IP_FILL_PRD_AHEAD,NEXT_FILL_DATE,LAST_FILL_QTY,DISPENSED_QTY,BMS_QTY,BMS_STRENGTH,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID,SPLIT_DOSE_YN,QTY_VALUE_SPLIT_DOSE,QTY_UNIT_SPLIT_DOSE,STRENGTH_VALUE,STRENGTH_UOM,PRES_QTY_VALUE,PRES_QTY_UOM,ALLERGY_OVERRIDE_REASON,DOSAGE_LIMIT_OVERRIDE_REASON,DUPLICATE_DRUG_OVERRIDE_REASON,PATIENT_BROUGHT_MEDICATION_YN,AMEND_REASON_CODE, AMEND_REASON,PAT_COUNS_REQD_YN, PAT_COUNS_ORD_PRACT_ID,BL_INCL_EXCL_OVERRIDE_VALUE,BL_INCL_EXCL_OVERRIDE_REASON,BUILD_MAR_YN,DRUG_INDICATION,PREGNANCY_OVERRIDE_REASON,ITEM_REMARKS,ALLOW_ALTERNATE_YN,NOT_PREFERED_ITEM_REM_CODE) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)" );	//Added for GHL-CRF-0470 // ALLOW_ALTERNATE_YN Added for GHL-CRF-0549 [IN:068344] - Devindra
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT4", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT4") );
			sqlMap.put( "SQL_PH_PRESCRIPTION_INSERT5", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_INSERT5") );	//Added for GHL-CRF-0470
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT56", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT56") );	//Added for GHL-CRF-0470
			sqlMap.put( "SQL_PH_PRESCRIPTION_SELECT57", PhRepository.getPhKeyValue("SQL_PH_PRESCRIPTION_SELECT57") );	//Added for GHL-CRF-0470
			
			//Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue( "JNDI_PH_CONSUMABLE_ORDER" ),ConsumableOrderHome.class,getLocalEJB());
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/ConsumableOrder",ConsumableOrderHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			HashMap result = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) result.get( "result" )).booleanValue() )	{
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(locale,(String) result.get( "msgid" ),"PH"));
				setTrnGroupRef((String)result.get("trn_group_ref"));
				setTokensGeneratedYN((String)result.get("tokens_generated_yn"));
			}
			else {
				map.put("flag",(String)result.get("flag"));
				map.put( "result", new Boolean( false ) ) ;
				map.put( "message", getMessage(locale,"EXCEPTION_OCCURED_WHILE_INSERTION","PH")+" : "+(String)map.get("flag") ) ;
			}
		}
		catch(Exception e) {
			map.put("message",e.toString());
			e.printStackTrace() ;
		}
		return map ;
	}

	public ArrayList showStockValues(String item_code, String trade_code) {
		Connection connection       = null ;
        PreparedStatement pstmt     = null ;
        ResultSet resultSet         = null ;
		ArrayList stock_values		= new ArrayList();
		try{
			connection				= getConnection() ;
			pstmt					= //connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_CONSUMABLERX_ITEM_STOCK_DTL_SELECT")) ;
			pstmt					= connection.prepareStatement("SELECT a.store_code, b.LONG_desc,  SUM (a.qty_on_hand - committed_qty) avl_qty FROM st_item_batch a, ph_disp_locn_lang_vw b, st_item_store c, st_item d WHERE a.item_code = ?  AND ( (  d.USE_AFTER_EXPIRY_YN = 'N'  AND a.expiry_date_or_receipt_date >= SYSDATE ) OR ( d.USE_AFTER_EXPIRY_YN = 'Y'  AND d.expiry_yn='Y' ) OR (d.expiry_yn='N') )  AND a.store_code = b.store_code  AND a.trade_id = NVL (?, a.trade_id)  AND b.language_id = ?  AND c.store_code = a.store_code  AND c.item_code = a.item_code  AND c.eff_status = 'E'  AND c.phy_inv_id IS NULL AND d.item_code = a.item_code GROUP BY a.store_code, b.LONG_desc") ; 
			/*	pstmt					= connection.prepareStatement("SELECT a.store_code, b.LONG_desc,  SUM (a.qty_on_hand - committed_qty) avl_qty FROM st_item_batch a, ph_disp_locn_lang_vw b, st_item_store c, st_item d WHERE a.item_code = ?  AND a.store_code = b.store_code  AND a.trade_id = NVL (?, a.trade_id)  AND b.language_id = ?  AND c.store_code = a.store_code  AND c.item_code = a.item_code  AND c.eff_status = 'E'  AND c.phy_inv_id IS NULL AND d.item_code = a.item_code GROUP BY a.store_code, b.LONG_desc") ;*/
			pstmt.setString(1,item_code);
			pstmt.setString(2,trade_code);
			pstmt.setString(3,getLanguageId());
			resultSet				= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next()){
				stock_values.add(resultSet.getString("STORE_CODE"));
				stock_values.add(resultSet.getString("LONG_desc"));
				stock_values.add(resultSet.getString("AVL_QTY"));				
			}
		}catch ( Exception e ) {
            e.printStackTrace() ;
		}finally {
            try{
                 closeResultSet( resultSet ) ;
                 closeStatement( pstmt ) ;
                 closeConnection( connection );
            }catch(Exception es){
				es.printStackTrace();
			}
        }
		return stock_values;
	}

	public String checkImageExists(String item_code){
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String fileName="";

		try{
			connection				= getConnection() ;
			String str_qry			= "select IMAGE_FILE_NAME from st_item where item_code =?";
			pstmt			= connection.prepareStatement(str_qry) ;
			pstmt.setString(1,item_code);
			
			resultSet		= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next()){
				fileName=resultSet.getString("IMAGE_FILE_NAME")==null?"":resultSet.getString("IMAGE_FILE_NAME");
			}
					
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return fileName;
	}

	/* code starts for the preferred Drug ITems */
	public ArrayList getItemDetailsList_preferred(String bl_preference_item_code, String bl_install_yn, String disp_charge_dtl_in_drug_lkp_yn, String disp_price_type_in_drug_lkp, String take_home_medication, String priority,String bl_preference_priority){
		Connection connection       = null ;
		PreparedStatement pstmt_item     = null ;
		PreparedStatement pstmt_store     = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet_item         = null ;
		ResultSet resultSet_store         = null ;
		String sql_query_item			= "";
		ArrayList alItemList= new ArrayList();
		HashMap hmItemDetail= null;
		String item_code="";
		String trade_code="";
		String store_code="";
		String store_desc="";
		String disp_locn="";
		String order_type="";
		String episode_type = "";
		String reimburse_yn = "";	
		String imported_yn = "";		
		String unit_price = "";		
		String error_code = "";		
		String sys_message_id = "";	
		String error_text = "";	
		String encounter_id = getEncounterId();
		String episode_id = "";
		String visit_id = "";
		String ext_disp_appl_yn="";//Added for IN072995
		String stock_yn="Y";//Added for IN072995
		episode_type= getActPatientClass();
		if(episode_type !=null && (!episode_type.equals("")))
			episode_type = episode_type.substring(0,1);

		if(episode_type !=null && episode_type.equals("X"))
			episode_type = "R";
		if(encounter_id!= null && !encounter_id.equals("")){
			episode_id = encounter_id;
			if(episode_type.equals("O")||episode_type.equals("E")){
				episode_id = encounter_id.substring(0,(encounter_id.length()-4));
				visit_id = encounter_id.substring(encounter_id.length()-4);
			}
		}
		try{
			connection = getConnection() ;
			//sql_query_item        = PhRepository.getPhKeyValue("SQL_PH_CONSUMABLERX_ITEM_SELECT");
			sql_query_item = "SELECT ord_cat.order_catalog_code item_code , mm.long_desc, mtr.trade_id,(SELECT short_name FROM am_trade_name_lang_vw WHERE language_id = ? AND trade_id = mtr.trade_id) trade_name, mm.gen_uom_code uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE language_id =? AND uom_code = mm.gen_uom_code) uom_desc, ord_cat.order_type_code, ord_cat.order_category FROM or_order_catalog ord_cat, st_item st, mm_item_lang_vw mm, mm_trade_name_for_item mtr WHERE medical_item_yn = 'Y' AND drug_item_yn = 'N'  and ord_cat.eff_status='E' AND st.item_code = mm.item_code AND mm.language_id = ? and blcommon.bl_mm_pref_loc_item_exist(?,?,?,?,?,?,ord_cat.order_catalog_code,trunc(SYSDATE),?) = 'I' and ord_cat.order_catalog_code = mm.item_code and ord_cat.order_category='PH' and ord_cat.order_type_code='MS' AND st.item_code = mtr.item_code(+) AND mm.eff_status = 'E' AND mm.item_code = ?";
// and ord_cat.eff_status='E' added for TBMC-SCF-0043
			pstmt_item				= connection.prepareStatement(sql_query_item) ;
			pstmt_item.setString(1,getLanguageId());
			pstmt_item.setString(2,getLanguageId());
			pstmt_item.setString(3,getLanguageId());
			pstmt_item.setString(4,login_facility_id);//1
			pstmt_item.setString(5,getPatientId());//2
			pstmt_item.setString(6,episode_type);//3
			pstmt_item.setString(7,episode_id);//4
			pstmt_item.setString(8,visit_id);//5
			pstmt_item.setString(9,encounter_id);//6
			//pstmt_item.setString(10,bl_preference_item_code);//7				
			pstmt_item.setString(10,bl_preference_priority);//8
			pstmt_item.setString(11,bl_preference_item_code);
			resultSet_item			= pstmt_item.executeQuery();

			while(resultSet_item!=null && resultSet_item.next()) {
								
				hmItemDetail= new HashMap();
				item_code = resultSet_item.getString("item_code");
				hmItemDetail.put("ITEM_CODE",item_code);
				hmItemDetail.put("ITEM_DESC",resultSet_item.getString("long_desc"));
				trade_code = resultSet_item.getString("trade_id")==null?"":resultSet_item.getString("trade_id");
				hmItemDetail.put("TRADE_CODE",trade_code);
				hmItemDetail.put("TRADE_NAME",resultSet_item.getString("trade_name")==null?"":resultSet_item.getString("trade_name"));
				hmItemDetail.put("UOM_CODE",resultSet_item.getString("UOM_CODE"));
				hmItemDetail.put("UOM_DESC",resultSet_item.getString("UOM_DESC"));
				hmItemDetail.put("ORDER_TYPE",resultSet_item.getString("ORDER_TYPE_CODE"));
				order_type = resultSet_item.getString("ORDER_TYPE_CODE");

				//to get Billing Details
				if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
					/*episode_type= getActPatientClass();
					if(episode_type !=null && (!episode_type.equals("")))
						episode_type = episode_type.substring(0,1);

					if(episode_type !=null && episode_type.equals("X"))
						episode_type = "R";*/
					if(encounter_id!="" && encounter_id!=null){
					episode_id = encounter_id.substring(0,(encounter_id.length()-4));  // Added for JD-CRF-0191
					visit_id = encounter_id.substring(encounter_id.length()-4);        // Added for JD-CRF-0191
					}
					
					cstmt=connection.prepareCall("{call  BL_PROC_ITEM_VALIDATIONS_MP.BL_GET_ITEM_DETAILS_MM (?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // three more '?' added for JD-CRF-0191.
					cstmt.setString( 1, login_facility_id);
					cstmt.setString( 2, episode_type); //'O'-Outpatient,'E'-Emergency ,'D'-Daycare,'I'-Inpatient,'R'-External
					cstmt.setString( 3, item_code);
					cstmt.setString( 4, ""); // p_trade_id	--If Batch level price is required (null as of now)
					cstmt.setString( 5, ""); // p_batch_id  --If Batch level price is required (null as of now
					cstmt.setString( 6, getSysdatetimesec()); // p_date
					cstmt.registerOutParameter(7, Types.VARCHAR );	//ESSENTIAL_YN 
					cstmt.registerOutParameter(8, Types.VARCHAR );	//P_REIMBURSABLE_YN Y --Reimbursible
					cstmt.registerOutParameter(9, Types.VARCHAR );	//P_REIMBURSABLE  P --> partially   F --> Fully
					cstmt.registerOutParameter(10, Types.VARCHAR ); //P_IMPORTED_YN	Y  --> Imported
					cstmt.registerOutParameter(11, Types.NUMERIC ); //PUBLIC_PRICE
					cstmt.registerOutParameter(12, Types.NUMERIC ); //P_BASE_PRICE	--Sale price as defined in billing by item/batch for respective passed Episode Type
					cstmt.registerOutParameter(13, Types.NUMERIC ); //P_REIMBURSABLE_AMT
					cstmt.registerOutParameter(14, Types.VARCHAR ); //P_REIM_OVERRIDE
					cstmt.registerOutParameter(15, Types.VARCHAR ); //P_ERROR_CODE
					cstmt.registerOutParameter(16, Types.VARCHAR ); //P_SYS_MESSAGE_ID
					cstmt.registerOutParameter(17, Types.VARCHAR ); //P_ERROR_TEXT
					cstmt.setString( 18, getPatientId()); //Added for JD-CRF-0191 - Start
					cstmt.setString( 19, episode_id);  
					cstmt.setString( 20, visit_id);  //Added for JD-CRF-0191 - End  
					cstmt.execute() ;

					reimburse_yn	= cstmt.getString(8);
					imported_yn		= cstmt.getString(10);
					unit_price		= cstmt.getString(12);
					error_code		= cstmt.getString(15);
					sys_message_id	= cstmt.getString(16);
					error_text		= cstmt.getString(17);

					closeStatement( cstmt );

					if(disp_price_type_in_drug_lkp.equals("P") && (error_code ==null && sys_message_id==null && error_text==null)){
						if(encounter_id!= null && !encounter_id.equals("")){
							episode_id = encounter_id;
							if(episode_type.equals("O")||episode_type.equals("E")){
								episode_id = encounter_id.substring(0,(encounter_id.length()-4));
								visit_id = encounter_id.substring(encounter_id.length()-4);
							}
						}
						cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
						cstmt.setString( 1, login_facility_id);
						cstmt.setString( 2, "PH");	//module id
						cstmt.setString( 3, "");	//
						cstmt.setString( 4, "");	//
						cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
						cstmt.setString( 6, getPatientId()); //patient_id
						cstmt.setString( 7, episode_id);  //episode_id
						cstmt.setString( 8, visit_id);  //p_visit_id  
						cstmt.setString( 9, ""); //p_dummy1 - null
						cstmt.setString( 10, ""); //p_dummy12 - null
						cstmt.setString( 11, "SAL"); //p_transaction_type
						cstmt.setString( 12, getSysdatetimesec()); //p_charge_date_time	--Service Data and time

						cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
						cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
						cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
						cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null

						cstmt.setString( 17, item_code);  //p_item_code

						cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
						cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 

						cstmt.setString( 20, "S");  //p_serv_panel_ind

						cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 

						cstmt.setString( 22,"1" );  //qty served
						cstmt.setString( 23, "");  //p_charge_amt  

						cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost

						cstmt.setString( 25,"" );  //p_store_code -- Store Code from where issued
						cstmt.setString( 26, "");  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
						cstmt.setString( 27,"" );  //p_oth_disc_perc if any other manual discount is given from transaction
						cstmt.setString( 28, "");  //p_source_doc_ref		null for Sale
						cstmt.setString( 29,"" );  //p_source_doc_ref_line	null for Sale

						cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_qty
						cstmt.registerOutParameter(31, Types.NUMERIC ); //p_base_rate
						cstmt.registerOutParameter(32, Types.NUMERIC ); //p_addl_factor
						cstmt.registerOutParameter(33, Types.NUMERIC ); //p_base_charge_amt       
						cstmt.registerOutParameter(34, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
						cstmt.registerOutParameter(35, Types.NUMERIC ); //p_DISC_AMT              
						cstmt.registerOutParameter(36, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
						cstmt.registerOutParameter(37, Types.NUMERIC ); //p_disc_perc             
						cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
						cstmt.registerOutParameter(39, Types.NUMERIC ); //p_PAT_DISC_AMT          
						cstmt.registerOutParameter(40, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
						cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
						cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_DISC_AMT         
						cstmt.registerOutParameter(43, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
						cstmt.registerOutParameter(44, Types.VARCHAR ); //p_SPLIT_IND             
						cstmt.registerOutParameter(45, Types.NUMERIC ); //p_curr_availed          
						cstmt.registerOutParameter(46, Types.VARCHAR ); //p_credit_auth_ref       
						cstmt.registerOutParameter(47, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt

						cstmt.setString( 48,"" );  //p_dummy4 (IN OUT )
						cstmt.setString( 49, "");  //p_batch_prices  (IN OUT )
						
						cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
						cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
						cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
						cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?

						cstmt.setString( 54,"" );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
						cstmt.setString( 55, "");  //p_overridden_action_reason		 --- Pass null or any value entered 

						cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
						cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
						cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text

						cstmt.execute() ;
						unit_price		= cstmt.getString(40);
						error_code		= cstmt.getString(56);
						sys_message_id	= cstmt.getString(57);
						error_text		= cstmt.getString(58);

					}
					closeStatement( cstmt );
					hmItemDetail.put("BL_REIMBURSE_YN",reimburse_yn);
					hmItemDetail.put("BL_IMPORTED_YN",imported_yn);
					hmItemDetail.put("BL_UNIT_PRICE",unit_price);
					hmItemDetail.put("BL_ERROR_CODE",error_code);
					hmItemDetail.put("BL_SYS_MESSAGE_ID",sys_message_id);
					hmItemDetail.put("BL_ERROR_TEXT",error_text);
				}
				//Billing Details ends here

				String locn_type = getLocationType();
				String locn_code = getLocationCode();
				String patient_class ="";
				if(locn_type==null)
					locn_type = "";
				if(locn_code==null)
					locn_code = "";
				if(getActPatientClass().equals("I")){
					patient_class  ="IP";
				}else if(getActPatientClass().equals("D")){
					patient_class  ="DC";
				}else if(getActPatientClass().equals("O")){
					patient_class  ="OP";
				}else if(getActPatientClass().equals("E")){
					patient_class  ="EM";
				}else if(getActPatientClass().equals("R")){
					patient_class  ="XT";
				}else{
					patient_class =getActPatientClass();
				}
				
				//if(!locn_type.equals("") && !locn_code.equals("")){
				//pstmt_store = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT16A") );
				pstmt_store = connection.prepareStatement("SELECT PH_DISP_STOCK_LOCN(?,?,?,?,?,?,?,?,?,?,?,'M',?,?) DISP_LOCN from dual");
				pstmt_store.setString(1,locn_type);
				pstmt_store.setString(2,locn_code);
				pstmt_store.setString(3,login_facility_id);
				pstmt_store.setString(4,login_facility_id);
				pstmt_store.setString(5,""); //drug_class
				pstmt_store.setString(6,item_code);
				pstmt_store.setString(7,order_type);
				pstmt_store.setString(8,patient_class);
				pstmt_store.setString(9,take_home_medication);
				pstmt_store.setString(10,priority);
				pstmt_store.setString(11,getLanguageId());
				pstmt_store.setString(12,"");//added for MMS-QH-CRF-0048 [IN:037704]
			    pstmt_store.setString(13,getPatientId());//added for MMS-QH-CRF-0048 [IN:037704]
			    pstmt_store.setString(14,encounter_id);//added for MMS-QH-CRF-0048 [IN:037704]
				
				resultSet_store = pstmt_store.executeQuery() ;
							
				if(resultSet_store!=null && resultSet_store.next()){
					disp_locn =resultSet_store.getString("DISP_LOCN");

					if(disp_locn!=null && !disp_locn.equals("")){
						if(disp_locn.indexOf("|")>0){
							store_code = disp_locn.substring(0,disp_locn.indexOf("|"));
							store_desc = disp_locn.substring(disp_locn.indexOf("|")+1,disp_locn.lastIndexOf("|"));

						}
					}
				}
				closeStatement(pstmt_store);
				closeResultSet(resultSet_store);
				/*}
				else{
					store_code = getStoreCode();
					store_desc = getStoreDesc();
				}*/
				store_code = store_code==null?"":store_code;
				store_desc = store_desc==null?"":store_desc;

				hmItemDetail.put("STORE_CODE",store_code);
				hmItemDetail.put("STORE_DESC",store_desc);
				cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
				cstmt.setString( 1, item_code+"="+trade_code);
				cstmt.setString( 2, store_code);
				cstmt.setString( 3, "1");
				cstmt.setString( 4, "Y");
				cstmt.setString( 5, getSysdate());
				cstmt.setString( 6, "N");
				cstmt.setString( 7, "");
				cstmt.registerOutParameter(8, Types.VARCHAR );
				cstmt.registerOutParameter(9, Types.VARCHAR );
				cstmt.registerOutParameter(10, Types.VARCHAR );
				cstmt.registerOutParameter(11, Types.INTEGER );
				cstmt.registerOutParameter(12, Types.VARCHAR );
				cstmt.registerOutParameter(13, Types.VARCHAR );
				cstmt.registerOutParameter(14, Types.VARCHAR );
				cstmt.registerOutParameter(15, Types.VARCHAR );
				cstmt.registerOutParameter(16, Types.VARCHAR );
				cstmt.registerOutParameter(17, Types.VARCHAR );
				cstmt.registerOutParameter(18, Types.VARCHAR );
				cstmt.registerOutParameter(19, Types.VARCHAR );
				cstmt.execute() ;
// Added for IN072995 START
				int avail_stock = 0;
				
				
				if(!ext_disp_appl){
					 avail_stock = cstmt.getInt(11);
					 ext_disp_appl_yn = "N";
					}
					else{
						if(external_disp_yn.containsKey(store_code)){
							ext_disp_appl_yn = (String)external_disp_yn.get(store_code);
						}else{
							ext_disp_appl_yn = getExtDispYN(store_code);
						}
						if(ext_disp_appl_yn.equals("Y")){
							
							pstmt_store = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_EXTERNAL_DISPENSING_QTY") );
							pstmt_store.setString(1,store_code);
							pstmt_store.setString(2,item_code);

							resultSet_store = pstmt_store.executeQuery() ;
												
							if(resultSet_store!=null && resultSet_store.next()){					
									avail_stock = resultSet_store.getInt("EXTERNAL_ITEM_QTY");
							}
							System.out.println("avail_stock=====>"+avail_stock);
							closeStatement(pstmt_store);
							closeResultSet(resultSet_store);
						}
						else{
							avail_stock = cstmt.getInt(11);
						}
						 
					}

				if(avail_stock<=0){
					avail_stock	=	0;
					stock_yn="N";
				}
				hmItemDetail.put("STOCK_YN",stock_yn);
				// Added for IN072995 END
				hmItemDetail.put("AVAIL_QTY",avail_stock+"");
				alItemList.add(hmItemDetail );
			}
			closeResultSet( resultSet_item ) ;
			closeStatement( pstmt_item ) ;
			closeStatement( cstmt );
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet_item ) ;
				closeStatement( pstmt_item ) ;
				closeConnection( connection );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return alItemList;
	}
/* code ends for the preferred Drug ITems */
/*Code starts for the Item_Class List*/
public ArrayList getItemclassList(){
	
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList ItemclassArraylist =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			//pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TERM_SET_SELECT1" )) ;
			pstmt			 = connection.prepareStatement("SELECT ITEM_CLASS_CODE,SHORT_DESC from MM_ITEM_CLASS_LANG_VW WHERE LANGUAGE_ID=? order by short_desc" ) ;
			pstmt.setString(1,getLanguageId());
			resultSet      = pstmt.executeQuery() ;
			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("ITEM_CLASS_CODE");
				desc					=	resultSet.getString("SHORT_DESC");
				rec.put("code",code);
				rec.put("desc",desc);
				ItemclassArraylist.add(rec);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return ItemclassArraylist;
	  }  //Code ends for the Itemclasslist

	  /*************Code starts for Manufacturer List**********************/
 public ArrayList getManufacturerList(){
	
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList ManufacturerArraylist =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			//pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TERM_SET_SELECT1" )) ;
			pstmt			 = connection.prepareStatement("Select MANUFACTURER_ID,SHORT_NAME from AM_MANUFACTURER_LANG_VW WHERE LANGUAGE_ID=? order by SHORT_NAME" ) ;
			pstmt.setString(1,getLanguageId());
			resultSet      = pstmt.executeQuery() ;
			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("MANUFACTURER_ID");
				desc					=	resultSet.getString("SHORT_NAME");
				rec.put("code",code);
				rec.put("desc",desc);
				ManufacturerArraylist.add(rec);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return ManufacturerArraylist;
	  } //Code ends for Manufacturer List

	  public ArrayList getItemAnalysisList(){
	
	  Connection connection			 =		null ;
		PreparedStatement pstmt	 =		null ;
		ResultSet resultSet				 =		null ;
		ArrayList ItemAnalysisArraylist =		new ArrayList();
		
		try {
			connection	 = getConnection() ;
			//pstmt			 = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_TERM_SET_SELECT1" )) ;
			pstmt			 = connection.prepareStatement("Select ITEM_ANAL_CODE,SHORT_DESC from MM_ITEM_ANALYSIS_LANG_VW WHERE LANGUAGE_ID=? order by SHORT_DESC" ) ;
			pstmt.setString(1,getLanguageId());
			resultSet      = pstmt.executeQuery() ;
			while (resultSet.next()) {
				HashMap rec		=	new HashMap();
				String code,desc;
				code					=	resultSet.getString("ITEM_ANAL_CODE");
				desc					=	resultSet.getString("SHORT_DESC");
				rec.put("code",code);
				rec.put("desc",desc);
				ItemAnalysisArraylist.add(rec);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es) { 
				es.printStackTrace() ;
			}
		}
		return ItemAnalysisArraylist;
	  } 

	public String getBillableItemYN (String drug_code){
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;	
		String billable_item_yn	= "";
		try {

            connection	= getConnection() ;
          	pstmt		= connection.prepareStatement( "select BILLABLE_ITEM_YN from ph_drug where drug_CODE=? ") ;
			pstmt.setString(1,drug_code);			
            resultSet	= pstmt.executeQuery() ;
			
			if (resultSet.next()){
				billable_item_yn = resultSet.getString("BILLABLE_ITEM_YN");				
			}
			
		}
		catch ( Exception e ) {
			e.printStackTrace() ;			
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection ); 
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return billable_item_yn;
	}
	// Code added for printing prescription for Medical Items --IN23133-- 18/08/2010-- priya
	public boolean doPrinting(Object request,Object response, String locn_code, String patient_class, String prescriptionPrint) {
		ArrayList all_orders	    =(ArrayList)OrderID.clone();
		String order_id="";
		try{
			if(patient_class.equals("IP")) {
				if((prescriptionPrint.toUpperCase()).equals("Y")){
					ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
					ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPRS_IP") ;
					report2.addParameter("p_facility_id", login_facility_id) ;
					report2.addParameter("p_module_id", "PH") ;
					report2.addParameter("p_report_id", "PHBOPPRS_IP") ;
					report2.addParameter("p_fm_order_id", (String)all_orders.get(0)) ;
					report2.addParameter("p_to_order_id", (String)all_orders.get(all_orders.size()-1)) ;
					report2.addParameter("p_locncode", locn_code) ;
					report2.addParameter("p_patclass", patient_class) ;
					report2.addParameter("p_user_name", login_by_id) ;
					report2.addParameter("p_language_id", getLanguageId()) ;
					report2.addParameter("p_patient_id", getPatientId()) ;//code added for SKR-SCF-0915[IN046734]  
					onlineReports.add( report2) ;
					onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
				}
			}
			else if(patient_class.equals("XT")){
				if((prescriptionPrint.toUpperCase()).equals("Y")){
					if((getCustomerID()).equals("SRR")){
						order_id=(String)all_orders.get(0);			
						ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
						ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPEX") ;
						report2.addParameter("p_facility_id", login_facility_id) ;
						report2.addParameter("p_module_id", "PH") ;
						report2.addParameter("p_report_id", "PHBOPPEX") ;
						report2.addParameter("p_trn_group_ref", this.trn_group_ref) ;
						report2.addParameter("p_order_id", "") ;//Order id is not given importance for SRR as reports are printed based on trn_group_ref
						report2.addParameter("p_locncode", locn_code) ;
						report2.addParameter("p_patclass", patient_class) ;
						report2.addParameter("p_user_name", login_by_id) ;
						report2.addParameter("p_language_id", getLanguageId()) ;
						report2.addParameter("p_patient_id", getPatientId()) ;//code added for SKR-SCF-0915[IN046734]  
						onlineReports.add( report2) ;
						onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
					}
					else{
						for(int i=0;i<all_orders.size();i++){
							order_id=(String)all_orders.get(i);
							ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
							ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPEX") ;
							report2.addParameter("p_facility_id", login_facility_id) ;
							report2.addParameter("p_module_id", "PH") ;
							report2.addParameter("p_report_id", "PHBOPPEX") ;
							report2.addParameter("p_order_id", order_id) ;
							report2.addParameter("p_patclass", patient_class) ;
							report2.addParameter("p_user_name", login_by_id) ;
							report2.addParameter("p_language_id", getLanguageId()) ;
							report2.addParameter("p_patient_id", getPatientId()) ;//code added for SKR-SCF-0915[IN046734]  
							onlineReports.add( report2) ;
							onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
						}
					}
				}
			}
			else{
				if(all_orders.size()>0){
					if((prescriptionPrint.toUpperCase()).equals("Y")){
						if((getCustomerID()).equals("SRR")){
							order_id=(String)all_orders.get(0);				
							ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
							ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPRS") ;
							report2.addParameter("p_facility_id", login_facility_id) ;
							report2.addParameter("p_module_id", "PH") ;
							report2.addParameter("p_report_id", "PHBOPPRS") ;
							report2.addParameter("p_trn_group_ref", this.trn_group_ref) ;
							report2.addParameter("p_order_id", "") ;//Order id is not given importance for SRR as reports are printed based on trn_group_ref
							report2.addParameter("p_locncode", locn_code) ;
							report2.addParameter("p_patclass", patient_class) ;
							report2.addParameter("p_user_name", login_by_id) ;
							report2.addParameter("p_language_id", getLanguageId()) ;
							onlineReports.add( report2) ;
							onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
						}
						else{
							for(int i=0;i<all_orders.size();i++){
								order_id=(String)all_orders.get(i);				
								ecis.utils.OnlineReports onlineReports 	= new ecis.utils.OnlineReports() ;
								ecis.utils.OnlineReport report2= new ecis.utils.OnlineReport( login_facility_id, "PH", "PHBOPPRS") ;
								report2.addParameter("p_facility_id", login_facility_id) ;
								report2.addParameter("p_module_id", "PH") ;
								report2.addParameter("p_report_id", "PHBOPPRS") ;
								report2.addParameter("p_trn_group_ref", this.trn_group_ref) ;
								report2.addParameter("p_order_id", order_id) ;
								report2.addParameter("p_locncode", locn_code) ;
								report2.addParameter("p_patclass", patient_class) ;
								report2.addParameter("p_user_name", login_by_id) ;
								report2.addParameter("p_language_id", getLanguageId()) ;
								onlineReports.add( report2) ;
								onlineReports.execute( (HttpServletRequest)request, (HttpServletResponse)response );
							}
						}
					}
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return true;
	}

	public String getCustomerID()throws Exception	{
		Connection connection		= null;
        PreparedStatement pstmt		= null;
        ResultSet rsCustomerID		= null;
		String customer_id			= "";
		try {
			connection	= getConnection() ;
			pstmt = connection.prepareStatement("SELECT CUSTOMER_ID FROM SM_SITE_PARAM WHERE SITE_ID = 'DS'");
			rsCustomerID = pstmt.executeQuery();
			if(rsCustomerID.next()){
				customer_id = rsCustomerID.getString("CUSTOMER_ID")==null?"":rsCustomerID.getString("CUSTOMER_ID");
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( rsCustomerID ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}
		return customer_id;
	}
	
	public void setPrintOrdShtRuleInd(HashSet order_type_code,String patient_class){//Added for Bru-HIMS-CRF-393_1.0
		Connection connection       = null ;
		PreparedStatement pstmt     = null ;
		ResultSet resultSet         = null ;
		String print_ord_sht_rule_ind = getPrintOrdShtRuleInd();
		Iterator iterator =order_type_code.iterator();
		StringBuffer sbf=new StringBuffer();
		String print_option_sql,print_ord_sht_rule_ind_tmp="";
		String print_ord_sht_rule_ind_tmp1,print_ord_sht_rule_ind_tmp2="";
		try{
			while(iterator.hasNext()){
				print_ord_sht_rule_ind_tmp1=(String)iterator.next();
				sbf.append("'").append(print_ord_sht_rule_ind_tmp1).append("'").append(",");
				print_ord_sht_rule_ind_tmp2=sbf.toString();
				int index=print_ord_sht_rule_ind_tmp2.lastIndexOf(",");
				print_ord_sht_rule_ind_tmp2=print_ord_sht_rule_ind_tmp2.substring(0,index);
			}
			connection		= getConnection() ;
			print_option_sql="SELECT PRINT_ORD_SHT_RULE_IND FROM OR_ORDER_TYPE_ROUTING WHERE ORDER_TYPE_CODE in ("+print_ord_sht_rule_ind_tmp2+") AND PATIENT_CLASS=DECODE(?,PATIENT_CLASS, PATIENT_CLASS, '*A') AND OPERATING_FACILITY_ID=?";
			pstmt			= connection.prepareStatement(print_option_sql) ;
			pstmt.setString(1,patient_class);
			pstmt.setString(2,login_facility_id);
			resultSet		= pstmt.executeQuery();
			while(resultSet!=null && resultSet.next())	{
				print_ord_sht_rule_ind_tmp=resultSet.getString("PRINT_ORD_SHT_RULE_IND")==null ? "C" :resultSet.getString("PRINT_ORD_SHT_RULE_IND");
				if(print_ord_sht_rule_ind.equals("") || print_ord_sht_rule_ind_tmp.equals("C"))
					setPrintOrdShtRuleInd(print_ord_sht_rule_ind_tmp);
				else if(print_ord_sht_rule_ind_tmp.equals("S") && !print_ord_sht_rule_ind.equals("C"))
					setPrintOrdShtRuleInd(print_ord_sht_rule_ind_tmp);
				else if(!print_ord_sht_rule_ind.equals("C") && !print_ord_sht_rule_ind.equals("S"))
					setPrintOrdShtRuleInd(print_ord_sht_rule_ind_tmp);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			try{
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
				closeConnection( connection );
			}
			catch(Exception es){
				es.printStackTrace();
			}
		}
	}
	public ArrayList searchForAltItems(String from,String to, String bl_install_yn, String disp_charge_dtl_in_drug_lkp_yn, String disp_price_type_in_drug_lkp, String take_home_medication, String priority,String item_code,String item_tech_code,boolean formulary_billing_app){ // Added for GHL-CRF-0549 [IN:068344] - Start  // formulary_billing_app GHL-CRF-0618
		Connection connection       = null ;
		PreparedStatement pstmt_item     = null ;
		PreparedStatement pstmt_store     = null ;
		CallableStatement cstmt = null ;
		ResultSet resultSet_item         = null ;
		ResultSet resultSet_store         = null ;
		String sql_query_item			= "";
		ArrayList alItemList= new ArrayList();
		HashMap hmItemDetail= null;		
		String trade_code="";
		String store_code="";
		//String store_desc=""; //Commented for common-icn-0048
		String disp_locn="";
		String order_type="";
		String episode_type = "";
		String reimburse_yn = "";	
		String imported_yn = "";		
		String unit_price = "";		
		String error_code = "";		
		String sys_message_id = "";	
		String error_text = "";	
		String encounter_id = getEncounterId();
		String episode_id = "";
		String visit_id = "";
		String ext_disp_appl_yn="";//Added for IN072995
		String stock_yn="Y";//Added for IN072995
		//int query_result_size		= 10; //Commented for common-icn-0048
		String append_query = ""; //GHL-CRF-0618
		int index=0;//GHL-CRF-0618
		try{
			connection = getConnection() ;
			//String item_code_search=""; //Commented for common-icn-0048		
			//String trade_id_search=""; //Commented for common-icn-0048			
			//GHL-CRF-0618
			if(!formulary_billing_app)
			append_query = "AND b.ITEM_CODE NOT IN (?) ";


			sql_query_item = "SELECT a.item_code item_code, b.long_desc long_desc,f.trade_id, a.prompt_alert_preferred_drug,b.item_tech_code, (SELECT short_name FROM am_trade_name_lang_vw WHERE language_id = ? AND trade_id = f.trade_id) trade_name, (SELECT short_desc FROM mm_item_tech_name_lang_vw WHERE language_id = ? AND ITEM_TECH_NAME_CODE = b.item_tech_code) tech_name, b.gen_uom_code uom_code, (SELECT short_desc FROM am_uom_lang_vw WHERE language_id = ? AND uom_code = b.gen_uom_code) uom_desc, ord_cat.order_type_code, ord_cat.order_category, b.low_cost_item, b.high_margin_item, b.innovator_item FROM st_item a, mm_item_lang_vw b, mm_trade_name_for_item f, am_trade_name_lang_vw g, or_order_catalog ord_cat WHERE a.item_code = b.item_code AND a.item_code = f.item_code(+) AND a.item_code= ord_cat.order_catalog_code AND a.medical_item_yn = 'Y' AND b.eff_status = 'E' and ord_cat.eff_status='E' /* AND b.ITEM_CODE NOT IN (?) */"+append_query+" AND b.language_id = ? AND NVL (b.item_class_code, '%') LIKE ('%') AND NVL (b.item_anal1_code, '%') LIKE ('%') AND NVL (b.item_anal2_code, '%') LIKE ('%') AND NVL (b.item_anal3_code, '%') LIKE ('%') AND ord_cat.order_category = 'PH' AND ord_cat.order_type_code = 'MS' AND f.trade_id = g.trade_id(+) AND drug_item_yn = 'N' AND b.ITEM_TECH_CODE = ? AND g.language_id(+) = ?";
			// and ord_cat.eff_status='E' added for TBMC-SCF-0043
			pstmt_item	= connection.prepareStatement(sql_query_item) ;
			pstmt_item.setString(++index,getLanguageId());
			pstmt_item.setString(++index,getLanguageId());
			pstmt_item.setString(++index,getLanguageId());
			if(!formulary_billing_app) //GHL-CRF-0618
			pstmt_item.setString(++index,item_code);
			
			pstmt_item.setString(++index,getLanguageId());
			pstmt_item.setString(++index,item_tech_code);
			pstmt_item.setString(++index,getLanguageId());
			resultSet_item			= pstmt_item.executeQuery();
			while(resultSet_item!=null && resultSet_item.next()) {
					hmItemDetail= new HashMap();
					item_code = resultSet_item.getString("item_code");
					hmItemDetail.put("ITEM_CODE",item_code);
					hmItemDetail.put("ITEM_DESC",resultSet_item.getString("long_desc"));
					trade_code = resultSet_item.getString("trade_id")==null?"":resultSet_item.getString("trade_id");
					hmItemDetail.put("TRADE_CODE",trade_code);
					hmItemDetail.put("TRADE_NAME",resultSet_item.getString("trade_name")==null?"":resultSet_item.getString("trade_name"));
					hmItemDetail.put("UOM_CODE",resultSet_item.getString("UOM_CODE"));
					hmItemDetail.put("UOM_DESC",resultSet_item.getString("UOM_DESC"));
					hmItemDetail.put("ORDER_TYPE",resultSet_item.getString("ORDER_TYPE_CODE"));
					hmItemDetail.put("PROMPT_ALERT_PREFERRED_DRUG",resultSet_item.getString("PROMPT_ALERT_PREFERRED_DRUG"));
					order_type = resultSet_item.getString("ORDER_TYPE_CODE");
					hmItemDetail.put("LOW_COST_ITEM",checkForNull(resultSet_item.getString("LOW_COST_ITEM")));
					hmItemDetail.put("HIGH_MARGIN_ITEM",checkForNull(resultSet_item.getString("HIGH_MARGIN_ITEM")));
					hmItemDetail.put("INNOVATOR_ITEM",checkForNull(resultSet_item.getString("INNOVATOR_ITEM")));
					hmItemDetail.put("TECH_NAME",checkForNull(resultSet_item.getString("TECH_NAME")));
					if(bl_install_yn.equals("Y") && disp_charge_dtl_in_drug_lkp_yn.equals("Y")){
						episode_type= getActPatientClass();
						if(episode_type !=null && (!episode_type.equals("")))
							episode_type = episode_type.substring(0,1);
						if(episode_type !=null && episode_type.equals("X"))
							episode_type = "R";
                       if(!encounter_id.equals("") && !encounter_id.equals(null)){
						episode_id = encounter_id.substring(0,(encounter_id.length()-4));  
						visit_id = encounter_id.substring(encounter_id.length()-4);      
                       }
						cstmt=connection.prepareCall("{call  BL_PROC_ITEM_VALIDATIONS_MP.BL_GET_ITEM_DETAILS_MM (?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"); // three more '?' added for JD-CRF-0191
						cstmt.setString( 1, login_facility_id);
						cstmt.setString( 2, episode_type); //'O'-Outpatient,'E'-Emergency ,'D'-Daycare,'I'-Inpatient,'R'-External
						cstmt.setString( 3, item_code);
						cstmt.setString( 4, ""); // p_trade_id	--If Batch level price is required (null as of now)
						cstmt.setString( 5, ""); // p_batch_id  --If Batch level price is required (null as of now
						cstmt.setString( 6, getSysdatetimesec()); // p_date
						cstmt.registerOutParameter(7, Types.VARCHAR );	//ESSENTIAL_YN 
						cstmt.registerOutParameter(8, Types.VARCHAR );	//P_REIMBURSABLE_YN Y --Reimbursible
						cstmt.registerOutParameter(9, Types.VARCHAR );	//P_REIMBURSABLE  P --> partially   F --> Fully
						cstmt.registerOutParameter(10, Types.VARCHAR ); //P_IMPORTED_YN	Y  --> Imported
						cstmt.registerOutParameter(11, Types.NUMERIC ); //PUBLIC_PRICE
						cstmt.registerOutParameter(12, Types.NUMERIC ); //P_BASE_PRICE	--Sale price as defined in billing by item/batch for respective passed Episode Type
						cstmt.registerOutParameter(13, Types.NUMERIC ); //P_REIMBURSABLE_AMT
						cstmt.registerOutParameter(14, Types.VARCHAR ); //P_REIM_OVERRIDE
						cstmt.registerOutParameter(15, Types.VARCHAR ); //P_ERROR_CODE
						cstmt.registerOutParameter(16, Types.VARCHAR ); //P_SYS_MESSAGE_ID
						cstmt.registerOutParameter(17, Types.VARCHAR ); //P_ERROR_TEXT
						cstmt.setString( 18, getPatientId());
						cstmt.setString( 19, episode_id);  
						cstmt.setString( 20, visit_id);    
						cstmt.execute() ;
						reimburse_yn	= cstmt.getString(8);
						imported_yn		= cstmt.getString(10);
						unit_price		= cstmt.getString(12);
						error_code		= cstmt.getString(15);
						sys_message_id	= cstmt.getString(16);
						error_text		= cstmt.getString(17);
						closeStatement( cstmt );
						if(disp_price_type_in_drug_lkp.equals("P") && (error_code ==null && sys_message_id==null && error_text==null)){
							if(encounter_id!= null && !encounter_id.equals("")){
								episode_id = encounter_id;
								if(episode_type.equals("O")||episode_type.equals("E")){
									episode_id = encounter_id.substring(0,(encounter_id.length()-4));
									visit_id = encounter_id.substring(encounter_id.length()-4);
								}
							}
							cstmt=connection.prepareCall("{call BL_PROC_ITEM_VALIDATIONS_MP.GET_CHARGE_DTLS_MAT_ITEM (?,?,?,?,?,?,?,?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi:ss'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'N',?,?,?)}");
							cstmt.setString( 1, login_facility_id);
							cstmt.setString( 2, "PH");	//module id
							cstmt.setString( 3, "");	//
							cstmt.setString( 4, "");	//
							cstmt.setString( 5, episode_type); //'R'-referral(External), 'O'-OutPatient, 'E'-Emergency, 'I'-Inpatient, 'D'-Daycare
							cstmt.setString( 6, getPatientId()); //patient_id
							cstmt.setString( 7, episode_id);  //episode_id
							cstmt.setString( 8, visit_id);  //p_visit_id  
							cstmt.setString( 9, ""); //p_dummy1 - null
							cstmt.setString( 10, ""); //p_dummy12 - null
							cstmt.setString( 11, "SAL"); //p_transaction_type
							cstmt.setString( 12, getSysdatetimesec()); //p_charge_date_time	--Service Data and time
							cstmt.registerOutParameter(13, Types.VARCHAR ); //p_day_type_code - null
							cstmt.registerOutParameter(14, Types.VARCHAR ); //Y --p_day_type_desc - null
							cstmt.registerOutParameter(15, Types.VARCHAR ); // p_time_type_code - null
							cstmt.registerOutParameter(16, Types.VARCHAR ); //p_time_type_desc  - null
							cstmt.setString( 17, item_code);  //p_item_code
							cstmt.registerOutParameter(18, Types.VARCHAR ); //p_item_desc 
							cstmt.registerOutParameter(19, Types.VARCHAR ); //P_REFUND_ALLOW_FLAG 
							cstmt.setString( 20, "S");  //p_serv_panel_ind
							cstmt.registerOutParameter(21, Types.VARCHAR ); //p_serv_panel_code 
							cstmt.setString( 22,"1" );  //qty served
							cstmt.setString( 23, "");  //p_charge_amt  
							cstmt.registerOutParameter(24, Types.NUMERIC ); //p_avg_unit_cost
							cstmt.setString( 25,"" );  //p_store_code -- Store Code from where issued
							cstmt.setString( 26, "");  //p_batch_id if batch wise charging is required --> TRADE_ID||';'||BATCH_ID||';'||to_char(EXPIRY_DATE, 'DD/MM/YYYY')||';'||LOCN_CODE||';'||BATCH_QTY||';||  
							cstmt.setString( 27,"" );  //p_oth_disc_perc if any other manual discount is given from transaction
							cstmt.setString( 28, "");  //p_source_doc_ref		null for Sale
							cstmt.setString( 29,"" );  //p_source_doc_ref_line	null for Sale
							cstmt.registerOutParameter(30, Types.NUMERIC ); //p_base_qty
							cstmt.registerOutParameter(31, Types.NUMERIC ); //p_base_rate
							cstmt.registerOutParameter(32, Types.NUMERIC ); //p_addl_factor
							cstmt.registerOutParameter(33, Types.NUMERIC ); //p_base_charge_amt       
							cstmt.registerOutParameter(34, Types.NUMERIC ); //p_GROSS_CHARGE_AMT      
							cstmt.registerOutParameter(35, Types.NUMERIC ); //p_DISC_AMT              
							cstmt.registerOutParameter(36, Types.NUMERIC ); //p_NET_CHARGE_AMT     --- Total Charge Amt   
							cstmt.registerOutParameter(37, Types.NUMERIC ); //p_disc_perc             
							cstmt.registerOutParameter(38, Types.NUMERIC ); //p_PAT_GROSS_CHARGE_AMT  
							cstmt.registerOutParameter(39, Types.NUMERIC ); //p_PAT_DISC_AMT          
							cstmt.registerOutParameter(40, Types.NUMERIC ); //P_PAT_NET_CHARGE_AMT   --- Patient Payable Amt 
							cstmt.registerOutParameter(41, Types.NUMERIC ); //p_CUST_GROSS_CHARGE_AMT 
							cstmt.registerOutParameter(42, Types.NUMERIC ); //p_CUST_DISC_AMT         
							cstmt.registerOutParameter(43, Types.NUMERIC ); //p_CUST_NET_CHARGE_AMT   
							cstmt.registerOutParameter(44, Types.VARCHAR ); //p_SPLIT_IND             
							cstmt.registerOutParameter(45, Types.NUMERIC ); //p_curr_availed          
							cstmt.registerOutParameter(46, Types.VARCHAR ); //p_credit_auth_ref       
							cstmt.registerOutParameter(47, Types.VARCHAR ); //P_PAT_PAID_AMT --- Patient Paid Amt
							cstmt.setString( 48,"" );  //p_dummy4 (IN OUT )
							cstmt.setString( 49, "");  //p_batch_prices  (IN OUT )
							cstmt.registerOutParameter(50, Types.VARCHAR ); //p_cost_indicator (IN OUT ) --- It is out parameter
							cstmt.registerOutParameter(51, Types.VARCHAR ); //p_excl_incl_ind			--- Excluded(E)/Null or included(I)
							cstmt.registerOutParameter(52, Types.VARCHAR ); //p_approval_reqd_yn		--- approval is required or not?
							cstmt.registerOutParameter(53, Types.VARCHAR ); //p_override_allowed_yn		--- whether override allowed for this item?
							cstmt.setString( 54,"" );  //p_overridden_excl_incl_ind --- If Override allowed and after overriding call again with overridded flag to get the revised charge
							cstmt.setString( 55, "");  //p_overridden_action_reason		 --- Pass null or any value entered 
							cstmt.registerOutParameter(56, Types.VARCHAR ); //p_err_code
							cstmt.registerOutParameter(57, Types.VARCHAR ); //p_sys_message_id
							cstmt.registerOutParameter(58, Types.VARCHAR ); //p_error_text
							cstmt.execute() ;
							unit_price		= cstmt.getString(40);
							error_code		= cstmt.getString(56);
							sys_message_id	= cstmt.getString(57);
							error_text		= cstmt.getString(58);
						}
						hmItemDetail.put("BL_REIMBURSE_YN",reimburse_yn);
						hmItemDetail.put("BL_IMPORTED_YN",imported_yn);
						hmItemDetail.put("BL_UNIT_PRICE",unit_price);
						hmItemDetail.put("BL_ERROR_CODE",error_code);
						hmItemDetail.put("BL_SYS_MESSAGE_ID",sys_message_id);
						hmItemDetail.put("BL_ERROR_TEXT",error_text);
					}
					episode_type= getActPatientClass();
					if(episode_type !=null && (!episode_type.equals("")))
						episode_type = episode_type.substring(0,1);
					if(episode_type !=null && episode_type.equals("X"))
						episode_type = "R";
						if(encounter_id!= null && !encounter_id.equals("")){
								episode_id = encounter_id;
								if(episode_type.equals("O")||episode_type.equals("E")){
									episode_id = encounter_id.substring(0,(encounter_id.length()-4));
									visit_id = encounter_id.substring(encounter_id.length()-4);
							}
						}
					String locn_type = getLocationType();
					String locn_code = getLocationCode();
					String patient_class ="";
					if(locn_type==null)
						locn_type = "";
					if(locn_code==null)
						locn_code = "";
					if(getActPatientClass().equals("I")){
						patient_class  ="IP";
					}else if(getActPatientClass().equals("D")){
						patient_class  ="DC";
					}else if(getActPatientClass().equals("O")){
						patient_class  ="OP";
					}else if(getActPatientClass().equals("E")){
						patient_class  ="EM";
					}else if(getActPatientClass().equals("R")){
						patient_class  ="XT";
					}else{
						patient_class =getActPatientClass();
					}										
					pstmt_store = connection.prepareStatement("SELECT PH_DISP_STOCK_LOCN(?,?,?,?,?,?,?,?,?,?,?,'M',?,?,?) DISP_LOCN from dual");
					pstmt_store.setString(1,locn_type);
					pstmt_store.setString(2,locn_code);
					pstmt_store.setString(3,login_facility_id);
					pstmt_store.setString(4,login_facility_id);
					pstmt_store.setString(5,""); //drug_class
					pstmt_store.setString(6,item_code);
					pstmt_store.setString(7,order_type);
					pstmt_store.setString(8,patient_class);
					pstmt_store.setString(9,take_home_medication);
					pstmt_store.setString(10,priority);
					pstmt_store.setString(11,getLanguageId());
					pstmt_store.setString(12,takeHomeMedication);
				    pstmt_store.setString(13,getPatientId());
				    pstmt_store.setString(14,encounter_id);
					resultSet_store = pstmt_store.executeQuery() ;
					if(resultSet_store!=null && resultSet_store.next()){
						disp_locn =resultSet_store.getString("DISP_LOCN");
						if(disp_locn!=null && !disp_locn.equals("")){
							if(disp_locn.indexOf("|")>0){
								store_code = disp_locn.substring(0,disp_locn.indexOf("|"));								
							}
						}
					}
					closeStatement(pstmt_store);
					closeResultSet(resultSet_store);
					closeStatement( cstmt );//common-icn-0029
					store_code = store_code==null?"":store_code;					

					cstmt=connection.prepareCall("{call  st_stock_availability_status (?,?,?,?,TO_DATE(?,'dd/mm/yyyy hh24:mi'),?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
					cstmt.setString( 1, item_code+"="+trade_code);
					cstmt.setString( 2, store_code);
					cstmt.setString( 3, "1");
					cstmt.setString( 4, "Y");
					cstmt.setString( 5, getSysdate());
					cstmt.setString( 6, "N");
					cstmt.setString( 7, "");
					cstmt.registerOutParameter(8, Types.VARCHAR );
					cstmt.registerOutParameter(9, Types.VARCHAR );
					cstmt.registerOutParameter(10, Types.VARCHAR );
					cstmt.registerOutParameter(11, Types.INTEGER );
					cstmt.registerOutParameter(12, Types.VARCHAR );
					cstmt.registerOutParameter(13, Types.VARCHAR );
					cstmt.registerOutParameter(14, Types.VARCHAR );
					cstmt.registerOutParameter(15, Types.VARCHAR );
					cstmt.registerOutParameter(16, Types.VARCHAR );
					cstmt.registerOutParameter(17, Types.VARCHAR );
					cstmt.registerOutParameter(18, Types.VARCHAR );
					cstmt.registerOutParameter(19, Types.VARCHAR );
					cstmt.execute() ;
					
					// Added for IN072995 START
					int avail_stock = 0;
					
					
					if(!ext_disp_appl){
						 avail_stock = cstmt.getInt(11);
						 ext_disp_appl_yn = "N";
						}
						else{
							if(external_disp_yn.containsKey(store_code)){
								ext_disp_appl_yn = (String)external_disp_yn.get(store_code);
							}else{
								ext_disp_appl_yn = getExtDispYN(store_code);
							}
							if(ext_disp_appl_yn.equals("Y")){
								
								pstmt_store = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_EXTERNAL_DISPENSING_QTY") );
								pstmt_store.setString(1,store_code);
								pstmt_store.setString(2,item_code);

								resultSet_store = pstmt_store.executeQuery() ;
													
								if(resultSet_store!=null && resultSet_store.next()){					
										avail_stock = resultSet_store.getInt("EXTERNAL_ITEM_QTY");
								}
								closeStatement(pstmt_store);
								closeResultSet(resultSet_store);
							}
							else{
								avail_stock = cstmt.getInt(11);
							}
							 
						}
					
					if(avail_stock<=0){
						avail_stock	=	0;
						stock_yn="N";
					}
					hmItemDetail.put("STOCK_YN",stock_yn);
					// Added for IN072995 END
					hmItemDetail.put("AVAIL_QTY",avail_stock+"");
					alItemList.add(hmItemDetail );
					closeStatement( cstmt );//common-icn-0029
			}
			closeResultSet( resultSet_item ) ;
			closeStatement( pstmt_item ) ;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				closeResultSet( resultSet_item ) ;
				closeStatement( pstmt_item ) ;
				closeStatement( cstmt );//common-icn-0029
				closeConnection( connection );
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return alItemList;
} 
	public boolean altItemsAvailableYn(String item_code,String item_tech_code){ // Added for GHL-CRF-0549 [IN:068344] - Start
		   Connection connection       = null ;
		   PreparedStatement pstmt_item     = null ;		
		   ResultSet resultSet_item         = null ;
		   String sql_query_item = "";
		   boolean altItemExists = false;
		try{
			connection = getConnection() ;
			//String item_code_search=""; //Commented for common-icn-0048		
			//String trade_id_search=""; //Commented for common-icn-0048
			sql_query_item = "SELECT count(*) FROM st_item a, mm_item_lang_vw b, mm_trade_name_for_item f WHERE a.item_code = b.item_code AND a.item_code = f.item_code(+) AND a.medical_item_yn = 'Y' AND b.eff_status = 'E' AND b.item_code NOT IN (?) AND b.language_id = ? AND NVL (b.item_class_code, '%') LIKE ('%') AND NVL (b.item_anal1_code, '%') LIKE ('%') AND NVL (b.item_anal2_code, '%') LIKE ('%') AND NVL (b.item_anal3_code, '%') LIKE ('%') AND drug_item_yn = 'N' AND b.item_tech_code = ?";
            int count;
			pstmt_item	= connection.prepareStatement(sql_query_item) ;			
			pstmt_item.setString(1,item_code);
			pstmt_item.setString(2,getLanguageId());
			pstmt_item.setString(3,item_tech_code);			
			resultSet_item			= pstmt_item.executeQuery();
			if(resultSet_item!=null && resultSet_item.next()) {
				count = resultSet_item.getInt(1);
			 if(count>0){
			   altItemExists = true;
			 }
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{				
				closeResultSet( resultSet_item ) ;
				closeStatement( pstmt_item ) ;
				closeConnection( connection );				
			}
			catch(Exception e){
				e.printStackTrace();
			}
		   return altItemExists;
		}
	}
	public String getBillingType(String patient_class,String encounter_id){
		Connection connection = null;		
		PreparedStatement pstm_group_type = null;
		ResultSet resultSet = null;
		//GHL-CRF-0618 - start
		PreparedStatement pstmt1 = null;
		ResultSet resultSet1 = null;
		String sql = "";		
		String billingGroupType ="";
		String blng_grp_id = "";
		String sql_query   = "";
		//GHL-CRF-0618 - end
	  try{
		  connection = getConnection();
		 if(patient_class.substring(0,1).equalsIgnoreCase("O") || patient_class.substring(0,1).equalsIgnoreCase("E"))
			 sql = "SELECT BLNG_GRP_ID FROM BL_VISIT_FIN_DTLS WHERE OPERATING_FACILITY_ID = ? AND EPISODE_TYPE = ? AND EPISODE_ID = ?";//modified for GHL-CRF-0618
		 else
		  sql =  "SELECT BLNG_GRP_ID FROM BL_EPISODE_FIN_DTLS WHERE OPERATING_FACILITY_ID = ? AND EPISODE_TYPE = ? AND EPISODE_ID=?"; //modified for GHL-CRF-0618
		  
		//modified for GHL-CRF-0618	
		sql_query= "SELECT ITEM_TYPE_APPLICABLE FROM BL_BLNG_GRP WHERE BLNG_GRP_ID = ?";

		 pstm_group_type	= connection.prepareStatement(sql) ;
		 pstmt1	= connection.prepareStatement(sql_query) ; //added for GHL-CRF-0618
		
		 if(patient_class.substring(0,1).equalsIgnoreCase("O") || patient_class.substring(0,1).equalsIgnoreCase("E")){
			 pstm_group_type.setString(1,login_facility_id);
			 pstm_group_type.setString(2, patient_class.substring(0,1));
			 pstm_group_type.setString(3, encounter_id.substring(0,encounter_id.length()-4));
		 }
		 else{
			 pstm_group_type.setString(1,login_facility_id);
			 pstm_group_type.setString(2, patient_class.substring(0,1));
			 pstm_group_type.setString(3, encounter_id); 
		 }
		  resultSet    = pstm_group_type.executeQuery();
		  if(resultSet!=null && resultSet.next()) {
		  //added for GHL-CRF-0618 - start
			  blng_grp_id = resultSet.getString("BLNG_GRP_ID");			 

			  setBillingGrpId(blng_grp_id);
			}
		
			if(blng_grp_id!=null){
				pstmt1.setString(1,blng_grp_id);
				resultSet1    = pstmt1.executeQuery();
				if(resultSet1!=null && resultSet1.next()) {
					billingGroupType = resultSet1.getString("ITEM_TYPE_APPLICABLE");
				} //added for GHL-CRF-0618 - end
			}
	  }
	  catch (Exception e) {
		e.printStackTrace();
	  }
	  finally{
		  try{				
				closeResultSet( resultSet ) ;
				closeStatement( pstm_group_type ) ;
				closeResultSet( resultSet1 ) ;//common-icn-0029
				closeStatement( pstmt1 ) ; //common-icn-0029
				closeConnection( connection );				
			}
			catch(Exception e){
				e.printStackTrace();
			}		   
		  return billingGroupType; 
	  }
	}// Added for GHL-CRF-0549 [IN:068344] - End
	//Added for IN072995 Start
		public String getExtDispYN(String store_code)
		{
			Connection connection	= null;
			PreparedStatement pstmt = null;
			ResultSet resultSet		= null;
			String ext_disp_appl_yn="";
			try {
				connection			= getConnection();
			
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_EXTERNAL_DISPENSING") );
			pstmt.setString(1,login_facility_id);
			pstmt.setString(2,store_code);

			resultSet = pstmt.executeQuery() ;
								
			if(resultSet!=null && resultSet.next()){					
				
				ext_disp_appl_yn = resultSet.getString("EXT_DISP_YN");	
				if(ext_disp_appl_yn==null)
					ext_disp_appl_yn="N";
				
				this.external_disp_yn.put(store_code,ext_disp_appl_yn);
			}
			} catch(Exception e) {
				e.printStackTrace();
			}
	 	    finally {
				try {
					closeResultSet(resultSet);
					closeStatement(pstmt);
					closeConnection(connection);
				}
				catch(Exception es){ 
					es.printStackTrace();
				}
			}
			return ext_disp_appl_yn;
		}
//GHL-CRF-0618 - start
	public String getFormularyBillingGrpCode(String blng_grp_id){
	
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String formulary_code="";
		String blng_grp_type = "";
		try {
			connection			= getConnection();
		
		pstmt = connection.prepareStatement("SELECT FORMULARY_CODE,BLNG_GRP_TYPE FROM PH_FORMULARY_BLNG_GRP WHERE  BLNG_GRP_ID=? and facility_id=?");
		
		pstmt.setString(1,blng_grp_id);
		pstmt.setString(2,login_facility_id);

		resultSet = pstmt.executeQuery() ;
							
		if(resultSet!=null && resultSet.next()){					
			
			formulary_code = resultSet.getString("FORMULARY_CODE");	
			blng_grp_type  = resultSet.getString("BLNG_GRP_TYPE");	
			if(formulary_code==null)
				formulary_code="";
			if(blng_grp_type==null)
				blng_grp_type = "";

			setFormularyCode(formulary_code);
			setFormularyBlngGrpType(blng_grp_type);
 		}
		} catch(Exception e) {
			e.printStackTrace();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		return formulary_code+"~"+blng_grp_type;
	}

		public HashMap getFormularyBillingGrpCodeDtl(String formulary_code,String blng_grp_id,String item_type){//blng_grp_id,item_type added for GHL-SCF-1527
	
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String item_code="";
		String preference="";
		String item_type_value = "";
		HashMap preferenceItem = new HashMap();

		try {
			connection			= getConnection();
		
		pstmt = connection.prepareStatement("SELECT item_code, preference,ITEM_TYPE FROM ph_formulary_blng_grp a, ph_formulary_blng_grp_dtl b WHERE a.formulary_code = b.formulary_code and a.blng_grp_type = b.blng_grp_type  AND a.formulary_code = ? AND a.facility_id = ? AND BLNG_GRP_ID=? AND ITEM_TYPE=? AND eff_status = 'E'");
		//blng_grp_id,item_type added for GHL-SCF-1527
		pstmt.setString(1,formulary_code);
		pstmt.setString(2,login_facility_id);
		pstmt.setString(3,blng_grp_id);
		pstmt.setString(4,item_type);

		resultSet = pstmt.executeQuery() ;
							
			while(resultSet!=null && resultSet.next()){					
				
				item_code = resultSet.getString("ITEM_CODE");	
				preference = resultSet.getString("PREFERENCE");	
				item_type_value  = resultSet.getString("ITEM_TYPE");	//GHL-CRF-0618

				if(item_code==null)
					item_code="";
				if(preference==null)
					preference = "";
				if(!item_code.equals("")){
					preferenceItem.put(item_code,preference);									if(getItemGenericType()!=null && getItemGenericType().size()>0){
						if(!getItemGenericType().contains(item_type_value))
							setItemGenericType(item_type_value);
					}else{
							setItemGenericType(item_type_value);
					}

				}
				//setPreferenceForFormularyItem(item_code,preference);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
 	    finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		return preferenceItem;
	}

		public ArrayList getNotPreferenceItemRemarks(){
		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		ArrayList arr = new ArrayList();
		//String ext_disp_appl_yn="";
		String locale= getLanguageId()==null?"en":getLanguageId();
		try {
			connection			= getConnection();
			pstmt = connection.prepareStatement("SELECT   REASON_CODE, REASON_DESC FROM PH_MEDN_TRN_REASON_LANG_VW PH_MEDN_TRN_REASON WHERE APPL_TRN_TYPE='NP' AND EFF_STATUS  = 'E' AND LANGUAGE_ID = ?");
			pstmt.setString(1,locale);
			resultSet = pstmt.executeQuery() ;
							
			while(resultSet!=null && resultSet.next()){					
				arr.add(resultSet.getString("REASON_CODE"));	
				arr.add(resultSet.getString("REASON_DESC"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
			finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		//System.err.println("arr============11878====>"+arr);
		return arr;

	}

	public String getUserName(String user_id){

		Connection connection	= null;
		PreparedStatement pstmt = null;
		ResultSet resultSet		= null;
		String user_name="";
		String locale= getLanguageId()==null?"en":getLanguageId();
		try {
			connection			= getConnection();
			pstmt = connection.prepareStatement("SELECT APPL_USER_NAME,APP_PASSWORD.DECRYPT(PIN_NO) PIN_NO  FROM SM_APPL_USER_LANG_VW SM_APPL_USER WHERE APPL_user_id =? AND LANGUAGE_ID = ?");
			pstmt.setString(1,user_id);
			pstmt.setString(2,locale);
			resultSet = pstmt.executeQuery() ;
							
			if(resultSet!=null && resultSet.next()){					
				user_name = resultSet.getString("APPL_USER_NAME");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es){ 
				es.printStackTrace();
			}
		}
		//System.err.println("user_name============11910====>"+user_name);
		return user_name;
	}
		//Added for IN072995 end
} 