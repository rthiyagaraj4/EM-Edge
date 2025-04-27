/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
 package ePH ;

import java.io.Serializable ;
import java.util.* ;
import java.sql.* ;
/*import javax.rmi.PortableRemoteObject ;
import javax.naming.InitialContext ;*/
import ePH.Common.* ;
import eCommon.Common.* ;
import ePH.DispenseLocation.*;

public class DispenseLocationBean extends PhAdapter implements Serializable {
   
	private String stock_yn						= "N";
	private String ip_yn						= "N";
	private String billing_yn					= "N";
	private String store_code					= "";
	private String disp_locn_code				= "";
	private String working_hrs_from				= "";
	private String working_hrs_to				= "";
	private String long_desc					= "";
	private String short_desc					= "";
	private String disp_locn_type				= "";
	private String disp_locn_category			= "";
	private String eff_status					= "E";
	private String disp_drug_class_g			= "Y";
	private String disp_drug_class_n			= "N";
	private String disp_drug_class_c			= "N";
	private String disp_regn_reqd_yn			= "N";
	private String print_prescription			= "N";
	private String issue_token					= "N";
	private String disp_flng_reqd_yn			= "N";
	private String disp_flng_stage				= "";
	private String disp_verf_stage				= "";
	private String disp_cash_coll_stage			= "";
	private String disp_bill_stage				= "";
	private String disp_cash_coll_stage_op			= ""; //added for SRR20056-SCF-7639 ICN027720
	private String disp_bill_stage_op				= ""; //added for SRR20056-SCF-7639 ICN027720
	//private String disp_cash_coll_stage		= "";
	private String disp_delv_reqd_yn			= "N";
	
	private String print_bal_med_sheet_op_yn	= "N";
	private String allow_drug_return_yn			= "N";
	private String max_durn_for_op_med_rtn		= "";
	private String max_drug_retention_bef_rtn	= "";
	private String stat_order					= "";
	private String routine_order				= "";
	private String ip_verf_yn					= "N";
	private String ip_fill_prd_ahead			= "";
	private String ip_fill_prd_unit				= "";
	private String ip_delv_reqd_yn				= "N";
	private String ip_fill_excl_prd_behind		= "";
	private String ip_fill_dflt_start_time		= "";
	private String ip_stat_order				= "";
	private String ip_routine_order				= "";
	private String ip_alloc_yn					= "";
	private String AUTO_DISP_AT_ADMIN_YN		= "";
	private String disp_stage					= "";
	private String ip_allow_drug_return_yn		= "";
	private String ip_fill_allocate_bathces_yn	= "N";
	private String allow_usage_of_spil_qty_yn	= "N";
	private String charge_pat_for_spill_qty_yn	= "N";
	//private String charge_qty_ind				= "";
	private String ip_fill_prd_ahead_for_check	= "";
	private String ip_fill_prd_unit_for_check	= "";
	private String ip_fill_prd_behind_for_check	= "";
	private String disp_level					= "";
	private String op_disp_period               = "";
	private String admix_prep_alwd_yn           = "";
	private String generate_tokon_reissue_yn    = "";
	private String generate_tokon_return_yn		= "";
	private String generate_tokon_direct_yn		= "";
	private String direct_disp_allowed_yn		= "";
	private String direct_disp_yn				= "";
	private String external_rx_allowed_yn		= "N";
	private String verify_regular_ip_rx_yn		= "N";
	private String remarks_code				= "";
	private String remarks_desc			= "";
	private String reason_desc			= "";

	private String print_disp_sheet_op_yn		= "Y";
	private String alloc_disp_sheet_default_yn	= "";
	private String alloc_disp_label_default_yn	= "";
	private String alloc_drug_label_default_yn	= "";
	private String del_disp_sheet_default_yn	= "";
	private String del_disp_label_default_yn	= "";
	private String del_drug_label_default_yn	= "";
	private String ip_sqence_no_from	= "";
	private String ip_sqence_no_to	= "";

	private String reimbursement_opallocation ="";
	/*  Removed for IN063877 start
	  private String reimbursement_opfill = "";	
	private String reimbursement_opallstages = "";	
	private String balancemedication_opallocation = "";
	private String balancemedication_opfill = "";
	private String balancemedication_opdelivery = "";
	private String balancemedication_opallstages = "";	
	private String refillmedication_opallocation = "";
	private String refillmedication_opfill = "";
	private String refillmedication_opdelivery = "";
	private String refillmedication_opallstages = "";	
	private String labelofdrug_opallocation = "";
	private String labelofdrug_opfill = "";
	private String labelofdrug_opdelivery = "";
	private String labelofdrug_opallstages = "";
	private String labelofdrug_ipfillrunipfill = "";
	private String labelofdrug_ipfillwithfill = "";
	private String labelofdrug_ipfillwithoutfill = "";
	private String labelofdrug_ipdeliverywithfill = "";
	private String labelofdrug_ipdeliverywithoutfill = "";	
	private String medicalsupply_opallocation = "";
	private String medicalsupply_opfill = "";
	private String medicalsupply_opdelivery = "";
	private String medicalsupply_opallstages = "";
	private String medicalsupply_ipfillrunipfill = "";
	private String medicalsupply_ipfillwithfill = "";
	private String medicalsupply_ipfillwithoutfill = "";
	private String medicalsupply_ipdeliverywithfill = "";
	private String medicalsupply_ipdeliverywithoutfill = "";	
	private String manufacturinglabel_opallocation = "";
	private String manufacturinglabel_opfill = "";
	private String manufacturinglabel_opdelivery = "";
	private String manufacturinglabel_opallstages = "";
	private String manufacturinglabel_ipfillwithoutfill = "";
	private String manufacturinglabel_ipdeliverywithoutfill = "";	
	private String filllistbypatient_ipfillrunipfill = "";
	private String filllistbypatient_ipfillwithfill = "";
	private String filllistbypatient_ipfillwithoutfill = "";	
	private String medicationlist_opallstages = "";
	private String medicationlist_opdelivery = "";
	private String medicationlist_ipfillrunipfill = "";
	private String medicationlist_ipfillwithfill = "";
	private String medicationlist_ipfillwithoutfill = "";	
	private String homemedication_opallocation = "";
	private String homemedication_opfill = "";
	private String homemedication_opdelivery = "";
	private String homemedication_opallstages = "";	
	private String worksheet_opallocation = "";
	private String worksheet_opfill = "";	
	private String worksheet_opallstages = "";
	private String worksheet_ipfillwithoutfill = "";
	private String worksheet_ipdeliverywithoutfill = "";	
	private String pharmacydispensing_opallocation = "";
	private String pharmacydispensing_opfill = "";
	private String pharmacydispensing_opallstages = "";
	private String pharmacydispensing_ipfillrunipfill = "";
	private String pharmacydispensing_ipfillwithfill = "";
	private String pharmacydispensing_ipfillwithoutfill = "";
	private String pharmacydispensing_ipdeliverywithfill = "";
	private String pharmacydispensing_ipdeliverywithoutfill = "";
	private String filllistbydrug_ipfillrunipfill = "";
	private String filllistbydrug_ipfillwithfill = "";
	private String filllistbydrug_ipfillwithoutfill = "";
	private String ipfilllist_ipfillrunipfill = ""; 
	 Removed for IN063877 end
	*/
	private String select_all = "";
	private ArrayList onlinePrintList =null;
	private ArrayList onlinePrintList_d =null;
	private HashMap onlinePrintMap = new HashMap();
	private HashMap  hmRow		   = null;
	/* added for SRR20056-CRF-0663		--START*/
	private String ip_fill_disp_prd = ""; //Default period for IP Fill without fill list --IP_FILL_DISP_PRD
	private String ip_fill_disp_prd_unit = ""; //Default periodunit for IP Fill without fill list --IP_FILL_DISP_PRD_UNIT 
	private String ip_dflt_prty_disp = "";		//Default priority for Disp Medication -- IP_DFLT_PRTY_DISP
	/* added for SRR20056-CRF-0663		--END*/
	private String barcode_scan_yn	= "N";//Added forKDAH-CRF-0231 [IN-034551] 
	private String pat_arrival = "N"; //Added for Bru-HIMS-CRF-142 [IN:030195] - start
	private String actual_token = "N";
	private String token_no_label = "N";
	private String storage_loc   = "N";	//Added for Bru-HIMS-CRF-142 [IN:030195] - end
	private String pin_auth_yn	= "N";//Added for RUT-CRF-0035 [IN029926] 
	private String default_bms_location = ""; //Added for HSA-CRF-0113 [IN:048166] 
	private String ext_disp_app_yn ="N";//Added for NMC-JD-CRF-0008
	public DispenseLocationBean() {
		try {
			doCommon() ;
		}
		catch(Exception e) {
		  e.printStackTrace();
		}
	}

	/* Over-ridden Adapter methods start here */
	private void doCommon() throws Exception {
	}

	public void clear() {
		super.clear() ;
		stock_yn						= "N";
		ip_yn							= "N";
		billing_yn						= "N";
		store_code						= "";
		disp_locn_code					= "";
		working_hrs_from				= "";
	    working_hrs_to				    = "";
		long_desc						= "";
		short_desc						= "";
		disp_locn_type					= "";
		disp_locn_category				= "";
		eff_status						= "E";
		disp_drug_class_g				= "Y";
		disp_drug_class_n				= "N";
		disp_drug_class_c				= "N";
		disp_regn_reqd_yn				= "N";
		print_prescription				= "N";
		issue_token						= "N";
		disp_flng_reqd_yn				= "N";
		disp_flng_stage					= "";
		disp_verf_stage					= "";
		//disp_cash_coll_stage			= "";
		disp_delv_reqd_yn				= "N";
		print_disp_sheet_op_yn			= "N";
		print_bal_med_sheet_op_yn		= "N";
		allow_drug_return_yn			= "N";
		max_durn_for_op_med_rtn			= "";
		max_drug_retention_bef_rtn		= "";
		stat_order						= "";
		routine_order					= "";
		ip_verf_yn						= "N";
		ip_fill_prd_ahead				= "";
		ip_fill_prd_unit				= "";
		ip_delv_reqd_yn					= "N";
		ip_fill_excl_prd_behind			= "";
		ip_fill_dflt_start_time			= "";
		ip_stat_order					= "";
		ip_routine_order				= "";
		disp_stage						= "";
		ip_alloc_yn						= "";
		AUTO_DISP_AT_ADMIN_YN			= "";
		ip_allow_drug_return_yn			= "";
		ip_fill_allocate_bathces_yn		= "N";
		allow_usage_of_spil_qty_yn		= "N";
		charge_pat_for_spill_qty_yn		= "N";
	//	charge_qty_ind					= "";
		ip_fill_prd_ahead_for_check		= "";
		ip_fill_prd_unit_for_check		= "";
		ip_fill_prd_behind_for_check	= "";
		disp_level						= "";
		op_disp_period                  = "";
		direct_disp_allowed_yn          = "";
		direct_disp_yn                  = "";
		external_rx_allowed_yn          = "N";
		verify_regular_ip_rx_yn         = "N";
		remarks_code					= "";
		remarks_desc			= "";
		reason_desc			= "";

	 print_disp_sheet_op_yn		= "Y";

	 alloc_disp_sheet_default_yn	= "";
	 alloc_disp_label_default_yn	= "";
	 alloc_drug_label_default_yn	= "";
	 del_disp_sheet_default_yn	= "";
	 del_disp_label_default_yn	= "";
	 del_drug_label_default_yn	= "";
	 ip_sqence_no_from	= "";
	 ip_sqence_no_to	= "";
	 onlinePrintList = null;
	 onlinePrintList_d = null;
	 onlinePrintMap.clear(); 
	 hmRow = null; 
	
	 select_all = "";
	/* added for SRR20056-CRF-0663		--START*/
	ip_fill_disp_prd = ""; 
	ip_fill_disp_prd_unit = ""; 
	ip_dflt_prty_disp = "";	
	/* added for SRR20056-CRF-0663		--END*/


/*	reimbursement_opallocation ="";
	reimbursement_opfill = "";	
	reimbursement_opallstages = "";	
	balancemedication_opallocation = "";
	balancemedication_opfill = "";
	balancemedication_opdelivery = "";
	balancemedication_opallstages = "";	
	refillmedication_opallocation = "";
	refillmedication_opfill = "";
	refillmedication_opdelivery = "";
	refillmedication_opallstages = "";	
	labelofdrug_opallocation = "";
	labelofdrug_opfill = "";
	labelofdrug_opdelivery = "";
	labelofdrug_opallstages = "";
	labelofdrug_ipfillrunipfill = "";
	labelofdrug_ipfillwithfill = "";
	labelofdrug_ipfillwithoutfill = "";
	labelofdrug_ipdeliverywithfill = "";
	labelofdrug_ipdeliverywithoutfill = "";	
	medicalsupply_opallocation = "";
	medicalsupply_opfill = "";
	medicalsupply_opdelivery = "";
	medicalsupply_opallstages = "";
	medicalsupply_ipfillrunipfill = "";
	medicalsupply_ipfillwithfill = "";
	medicalsupply_ipfillwithoutfill = "";
	medicalsupply_ipdeliverywithfill = "";
	medicalsupply_ipdeliverywithoutfill = "";	
	manufacturinglabel_opallocation = "";
	manufacturinglabel_opfill = "";
	manufacturinglabel_opdelivery = "";
	manufacturinglabel_opallstages = "";
	manufacturinglabel_ipfillwithoutfill = "";
	manufacturinglabel_ipdeliverywithoutfill = "";	
	filllistbypatient_ipfillrunipfill = "";
	filllistbypatient_ipfillwithfill = "";
	filllistbypatient_ipfillwithoutfill = "";	
	medicationlist_opallstages = "";
	medicationlist_opdelivery = "";
	medicationlist_ipfillrunipfill = "";
	medicationlist_ipfillwithfill = "";
	medicationlist_ipfillwithoutfill = "";	
	homemedication_opallocation = "";
	homemedication_opfill = "";
	homemedication_opdelivery = "";
	homemedication_opallstages = "";	
	worksheet_opallocation = "";
	worksheet_opfill = "";	
	worksheet_opallstages = "";
	worksheet_ipfillwithoutfill = "";
	worksheet_ipdeliverywithoutfill = "";	
	pharmacydispensing_opallocation = "";
	pharmacydispensing_opfill = "";
	pharmacydispensing_opallstages = "";
	pharmacydispensing_ipfillrunipfill = "";
	pharmacydispensing_ipfillwithfill = "";
	pharmacydispensing_ipfillwithoutfill = "";
	pharmacydispensing_ipdeliverywithfill = "";
	pharmacydispensing_ipdeliverywithoutfill = "";
	filllistbydrug_ipfillrunipfill = "";
	filllistbydrug_ipfillwithfill = "";
	filllistbydrug_ipfillwithoutfill = "";
	ipfilllist_ipfillrunipfill = "";
	*/

	}

	/* Set Methods Start */
	 public void setToOnlinePrintMap(String index, String indexValue){
		if (! onlinePrintMap.containsKey(index))
		{
			onlinePrintMap.put(index,indexValue);
		}
	}

	public HashMap getOnlinePrintMap(){
		return onlinePrintMap;
	}


	public void setAllocDispSheetDefaultYN(String alloc_disp_sheet_default_yn){
		this.alloc_disp_sheet_default_yn = alloc_disp_sheet_default_yn;
	}

	public void setAllocDispLabelDefaultYN(String alloc_disp_label_default_yn){
		this.alloc_disp_label_default_yn = alloc_disp_label_default_yn;
	}

	public void setAllocDrugLabelDefaultYN(String alloc_drug_label_default_yn){
		this.alloc_drug_label_default_yn = alloc_drug_label_default_yn;
	}

	public void setDelDispSheetDefaultYN(String del_disp_sheet_default_yn){
		this.del_disp_sheet_default_yn = del_disp_sheet_default_yn;
	}

	public void setDelDispLabelDefaultYN(String del_disp_label_default_yn){
		this.del_disp_label_default_yn = del_disp_label_default_yn;
	}

	public void setDelDrugLabelDefaultYN(String del_drug_label_default_yn){
		this.del_drug_label_default_yn = del_drug_label_default_yn;
	}

	public void setIPAllowDrugReturnYN(String ip_allow_drug_return_yn){
		this.ip_allow_drug_return_yn = ip_allow_drug_return_yn;
	}
	public void setIP_SQENCE_NO_FROM(String IP_SQENCE_NO_FROM){
		this.ip_sqence_no_from = IP_SQENCE_NO_FROM;
	}
	public void setIP_SQENCE_NO_TO(String IP_SQENCE_NO_TO){
		this.ip_sqence_no_to = IP_SQENCE_NO_TO;
	}


	public void setIPFillBatchesYN(String ip_fill_allocate_bathces_yn){
		this.ip_fill_allocate_bathces_yn = ip_fill_allocate_bathces_yn;
	}

	public void setIPAllowSpillUsageYN(String allow_usage_of_spil_qty_yn) {
		this.allow_usage_of_spil_qty_yn = allow_usage_of_spil_qty_yn;
	}

	//public void setIPChargeQtyInd(String charge_qty_ind) {
	//	this.charge_qty_ind = charge_qty_ind;
	//}
	public void setDispCashCollStage(String disp_cash_coll_stage){
		this.disp_cash_coll_stage = disp_cash_coll_stage;
	}
    
	public void setDispCashCollStageOP(String disp_cash_coll_stage_op){
		this.disp_cash_coll_stage_op = disp_cash_coll_stage_op;
	}
	public void setIPAllocYN(String ip_alloc_yn){
		this.ip_alloc_yn = ip_alloc_yn;
	}

	public void setAUTODISPATADMINYN(String AUTO_DISP_AT_ADMIN_YN){
		this.AUTO_DISP_AT_ADMIN_YN = AUTO_DISP_AT_ADMIN_YN;
	}

	public void setStockModuleYN(String stock_yn) {
		this.stock_yn = stock_yn;
	}

	public void setIPModuleYN(String ip_yn) {
		this.ip_yn = ip_yn;
	}

	public void setBillingModuleYN(String billing_yn) {
		this.billing_yn = billing_yn;
	}

	public void setStoreCode(String store_code) {
		this.store_code = store_code;
	}

	public void setDispLocnCode(String disp_locn_code) {
		this.disp_locn_code = disp_locn_code;
	}
	public void setWorkingFrom(String working_hrs_from) {
		this.working_hrs_from = working_hrs_from;
	}
	public void setWorkingTo(String working_hrs_to) {
		this.working_hrs_to = working_hrs_to;
	}
	public void setLongDesc(String long_desc) {
		if(long_desc.length()>40)
			this.long_desc = long_desc.substring(0,39);
		else
			this.long_desc = long_desc;
	}

	public void setShortDesc(String short_desc) {
		if(short_desc.length()>15)
			this.short_desc = short_desc.substring(0,14);
		else
			this.short_desc = short_desc;
	}

	public void setDispLocnType(String disp_locn_type) {
		this.disp_locn_type = disp_locn_type;
	}

	public void setDispLocnCategory(String disp_locn_category) {
		this.disp_locn_category = disp_locn_category;
	}

	public void setEffStat(String eff_status) {
		this.eff_status = eff_status;
	}

	public void setGenDrug(String disp_drug_class_g) {
		this.disp_drug_class_g = disp_drug_class_g;
	}

	public void setNarcoDrug(String disp_drug_class_n) {
		this.disp_drug_class_n = disp_drug_class_n;
	}

	public void setControlDrug(String disp_drug_class_c) {
		this.disp_drug_class_c = disp_drug_class_c;
	}

	public void setRegistration(String disp_regn_reqd_yn) {
		this.disp_regn_reqd_yn = disp_regn_reqd_yn;
	}

	public void setPrintPresc(String print_prescription) {
		this.print_prescription = print_prescription;
	}

	public void setIssueToken(String issue_token) {
		this.issue_token = issue_token;
	}

	public void setFilling(String disp_flng_reqd_yn) {
		this.disp_flng_reqd_yn = disp_flng_reqd_yn;
	}

	public void setFillingStage(String disp_flng_stage) {
		this.disp_flng_stage = disp_flng_stage;
	}

	public void setPharmVerfn(String disp_verf_stage) {
		this.disp_verf_stage = disp_verf_stage;
	}
	public void setRemarksCode(String remarks_code) {
	
		this.remarks_code = remarks_code;
	}
	public void setRemarksDesc(String remarks_desc) {
		this.remarks_desc = remarks_desc;
	}
	public void setReasonDesc(String reason_desc) {
		this.reason_desc = reason_desc;
	}


	
	
	//public void setBillGen(String disp_cash_coll_stage) {
		//this.disp_cash_coll_stage = disp_cash_coll_stage;
	//}

	public void setDelivery(String disp_delv_reqd_yn) {
		this.disp_delv_reqd_yn = disp_delv_reqd_yn;
	}

	public void setPrintDispSheet(String print_disp_sheet_op_yn) {
		this.print_disp_sheet_op_yn = print_disp_sheet_op_yn;
	}
	public void setPrintDispSheet_phparam(String print_disp_sheet_op_yn) {
		this.print_disp_sheet_op_yn = print_disp_sheet_op_yn;
	}

	public void setPrintBalMedSheet(String print_bal_med_sheet_op_yn) {
		this.print_bal_med_sheet_op_yn = print_bal_med_sheet_op_yn;
	}

	public void setMedReturn(String allow_drug_return_yn) {
		this.allow_drug_return_yn = allow_drug_return_yn;
	}

	public void setMaxRetPrd(String max_durn_for_op_med_rtn) {
		this.max_durn_for_op_med_rtn = max_durn_for_op_med_rtn;
	}

	public void setReturnWithin(String max_drug_retention_bef_rtn) {
		this.max_drug_retention_bef_rtn = max_drug_retention_bef_rtn;
	}

	public void setStatOrder(String stat_order) {
		this.stat_order = stat_order;
	}

	public void setReturnOrder(String routine_order) {
		this.routine_order = routine_order;
	}

	public void setIPVerify(String ip_verf_yn) {
		this.ip_verf_yn = ip_verf_yn;
	}

	public void setIPFillPeriod(String ip_fill_prd_ahead) {
		this.ip_fill_prd_ahead = ip_fill_prd_ahead;
	}

	public void setIPFillPeriodUnit(String ip_fill_prd_unit) {
		this.ip_fill_prd_unit = ip_fill_prd_unit;
	}

	public void setIPFillPeriodForCheck(String ip_fill_prd_ahead_for_check) {
		this.ip_fill_prd_ahead_for_check = ip_fill_prd_ahead_for_check;
	}

	public void setIPFillPeriodUnitForCheck(String ip_fill_prd_unit_for_check) {
		this.ip_fill_prd_unit_for_check = ip_fill_prd_unit_for_check;
	}

	public void setExcludeOrdersForCheck(String ip_fill_prd_behind_for_check) {
		this.ip_fill_prd_behind_for_check = ip_fill_prd_behind_for_check;
	}

	public void setIPDelivery(String ip_delv_reqd_yn) {
		this.ip_delv_reqd_yn = ip_delv_reqd_yn;
	}

	public void setExcludeOrders(String ip_fill_excl_prd_behind) {
		this.ip_fill_excl_prd_behind = ip_fill_excl_prd_behind;
	}

	public void setContIntermittent(String ip_fill_dflt_start_time) {
		this.ip_fill_dflt_start_time = ip_fill_dflt_start_time;
	}

	public void setIPStatOrder(String ip_stat_order) {
		this.ip_stat_order = ip_stat_order;
	}

	public void setIPReturnOrder(String ip_routine_order) {
		this.ip_routine_order = ip_routine_order;
	}

	public void setDispStage(String disp_stage){
		this.disp_stage = disp_stage;
	}

	public void setDispLevel(String disp_level){
		this.disp_level	= disp_level;
	}
	public void setOpDispPeriod(String op_disp_period){
		this.op_disp_period = op_disp_period;
	}
	public void setAdmixPrepAlwd_YN(String admix_prep_alwd_yn){
		this.admix_prep_alwd_yn = admix_prep_alwd_yn;
	}
	

	public void setGenerateTokonReissueYN(String generate_tokon_reissue_yn){
		this.generate_tokon_reissue_yn = generate_tokon_reissue_yn;
	}
    
	public void setGenerateTokonReturnYN(String generate_tokon_return_yn){
		this.generate_tokon_return_yn = generate_tokon_return_yn;
	}

	public void setGenerateTokonDirectYN(String generate_tokon_direct_yn){
		this.generate_tokon_direct_yn = generate_tokon_direct_yn;
	}
	

	public void setDirdispAllowe(String direct_disp_allowed_yn){
	//System.err.println("generate_tokon_direct_yn------------>"+direct_disp_allowed_yn);
		this.direct_disp_allowed_yn = direct_disp_allowed_yn;
	}
	
    public void setExternalPrescriptionYN(String external_rx_allowed_yn){
		this.external_rx_allowed_yn = external_rx_allowed_yn;
	}
	public void setNewPrescriptionsOnlyYN(String verify_regular_ip_rx_yn){
		this.verify_regular_ip_rx_yn = verify_regular_ip_rx_yn;
	}
   public void setChargePatForSpillQtyYN(String charge_pat_for_spill_qty_yn){
		this.charge_pat_for_spill_qty_yn = charge_pat_for_spill_qty_yn;
	}

	 public void setDispBillStage(String disp_bill_stage){
		this.disp_bill_stage = disp_bill_stage;
	}
	// setDispBillStageOP added for SRR20056-SCF-7639
	 public void setDispBillStageOP(String disp_bill_stage_op){
		this.disp_bill_stage_op = disp_bill_stage_op;
	}
	/* added for SRR20056-CRF-0663		--START*/
	public void setIPFillDispPrd(String ip_fill_disp_prd){
		this.ip_fill_disp_prd = ip_fill_disp_prd;
	}
   public void setIPFillDispPrdUnit(String ip_fill_disp_prd_unit){
		this.ip_fill_disp_prd_unit = ip_fill_disp_prd_unit;
	}

	 public void setIPDfltPrtyDisp(String ip_dflt_prty_disp){
		this.ip_dflt_prty_disp = ip_dflt_prty_disp;
	}
	/* added for SRR20056-CRF-0663		--END*/
	public String getRemarksCode() {
		return this.remarks_code;
	}
	public String getRemarksDesc() {
		return this.remarks_desc;
	}
	public String getReasonDesc() {
		return this.reason_desc;
	}

	//Added for KDAH-CRF-0231 [IN-034551] - -start
	public void setBarcode_Scan_YN(String barcode_scan_yn){
	    if(barcode_scan_yn==null || barcode_scan_yn.equals(""))
			this.barcode_scan_yn="N";
	    else
			this.barcode_scan_yn=barcode_scan_yn;
	}
	
	public String getBarcode_Scan_YN(){
	    return this.barcode_scan_yn;
	}
	//Added for KDAH-CRF-0231 [IN-034551] -end
	
	public void setPIN_Auth_DispMed(String pin_auth_yn){
	    if(pin_auth_yn==null || pin_auth_yn.equals(""))
			this.pin_auth_yn="N";
	    else
			this.pin_auth_yn=pin_auth_yn;
	}
	
	public String getPIN_Auth_DispMed(){
	    return this.pin_auth_yn;
	}
//	public void setDirdispAlloweYN(String direct_disp_yn){
	//	this.direct_disp_yn = direct_disp_yn;
	//}
	/* Set Methods End */

	/* Get Methods Start */
	public String getDefaultBmsLocation() {//Added for HSA-CRF-0113 [IN:048166] 
		return default_bms_location;
	}
	public void setDefaultBmsLocation(String default_bms_location) {//Added for HSA-CRF-0113 [IN:048166] 
		this.default_bms_location = default_bms_location;
	}
	public String getIPAllowDrugReturnYN() {
		return this.ip_allow_drug_return_yn;
	}

	public String getIPFillBatchesYN() {
		return ip_fill_allocate_bathces_yn;
	}

	public String getIPAllowSpillUsageYN() {
		return this.allow_usage_of_spil_qty_yn;
	}

	//public String getIPChargeQtyInd() {
	//	return this.charge_qty_ind;
	//}

	public String getIPAllocYN() {
		return ip_alloc_yn;
	}

	public String getAUTODISPATADMINYN() {
		return AUTO_DISP_AT_ADMIN_YN;
	}

	public String getLoggedInFacility() {
		return login_facility_id;
	}

	public String getStockModuleYN() {
		return this.stock_yn;
	}

	public String getIPModuleYN() {
		return this.ip_yn;
	}

	public String getBillingModuleYN() {
		return this.billing_yn;
	}

	public String getStoreCode() {
		return this.store_code;
	}

	public String getDispLocnCode() {
		return this.disp_locn_code;
	}

	public String getWorkingFrom() {
		return this.working_hrs_from;
	}

	public String getWorkingTo() {
		return this.working_hrs_to;
	}

	public String getLongDesc() {
		return this.long_desc;
	}

	public String getShortDesc() {
		return this.short_desc;
	}

	public String getDispLocnType() {
		return this.disp_locn_type;
	}

	public String getDispLocnCategory() {
		return this.disp_locn_category;
	}

	public String getEffStat() {
		return this.eff_status;
	}

	public String getGenDrug() {
		return this.disp_drug_class_g;
	}

	public String getNarcoDrug() {
		return this.disp_drug_class_n;
	}

	public String getControlDrug() {
		return this.disp_drug_class_c;
	}

	public String getRegistration() {
		return this.disp_regn_reqd_yn;
	}

	public String getPrintPresc() {
		return this.print_prescription;
	}

	public String getIssueToken() {
		return this.issue_token;
	}

	public String getFilling() {
		return this.disp_flng_reqd_yn;
	}

	public String getFillingStage() {
		return this.disp_flng_stage;
	}

	public String getPharmVerfn() {
		return this.disp_verf_stage;
	}

	//public String getBillGen() {
	//	return this.disp_cash_coll_stage;
	//}

	public String getDelivery() {
		return this.disp_delv_reqd_yn;
	}

	public String getPrintDispSheet() {
		return this.print_disp_sheet_op_yn;
	}
	public String getPrintDispSheet_phparam() {
		return this.print_disp_sheet_op_yn;
	}

	public String getPrintBalMedSheet() {
		return this.print_bal_med_sheet_op_yn;
	}

	public String getMedReturn() {
		return this.allow_drug_return_yn;
	}

	public String getMaxRetPrd() {
		return this.max_durn_for_op_med_rtn;
	}

	public String getReturnWithin() {
		return this.max_drug_retention_bef_rtn;
	}

	public String getStatOrder() {
		return this.stat_order;
	}

	public String getReturnOrder() {
		return this.routine_order;
	}

	public String getIPVerify() {
		return this.ip_verf_yn;
	}

	public String getIPFillPeriod() {
		return this.ip_fill_prd_ahead;
	}

	public String getIPFillPeriodUnit() {
		return this.ip_fill_prd_unit;
	}

	public String getIPFillPeriodForCheck() {
		return this.ip_fill_prd_ahead_for_check;
	}

	public String getIPFillPeriodUnitForCheck() {
		return this.ip_fill_prd_unit_for_check;
	}

	public String getExcludeOrdersForCheck() {
		return this.ip_fill_prd_behind_for_check;
	}

	public String getIPDelivery() {
		return this.ip_delv_reqd_yn;
	}

	public String getExcludeOrders() {
		return this.ip_fill_excl_prd_behind;
	}

	public String getContIntermittent() {
		return this.ip_fill_dflt_start_time;
	}

	public String getIPStatOrder() {
		return this.ip_stat_order;
	}

	public String getIPReturnOrder() {
		return this.ip_routine_order;
	}

	public String getDispStage(){
		return  this.disp_stage;
	}

	public String getDispLevel(){
		return this.disp_level;
	}
	public String getOpDispPeriod(){
		return this.op_disp_period;
	}
	public String getGenerateTokonReissueYN(){
		return this.generate_tokon_reissue_yn;
	}
	public String getAdmixPrepAlwd_YN(){
		return this.admix_prep_alwd_yn;
	}

   public String getGenerateTokonReturnYN(){
		return this.generate_tokon_return_yn;
	}
   
	public String getGenerateTokonDirectYN(){
		return this.generate_tokon_direct_yn;
	}

	public String getDirdispAllowe(){
		return this.direct_disp_allowed_yn;
	}
	public String getExternalPrescriptionYN(){
		return this.external_rx_allowed_yn;
	}
	public String getNewPrescriptionsOnlyYN(){
		return this.verify_regular_ip_rx_yn;
	}
   public String getChargePatForSpillQtyYN(){
		return this.charge_pat_for_spill_qty_yn;
	}

	public String getDispBillStage(){
		return this.disp_bill_stage;
	}
	//getDispBillStageOP() added for SRR20056-SCF-7639
	public String getDispBillStageOP(){
		return this.disp_bill_stage_op;
	}
	public String getDispCashCollStage(){
		return this.disp_cash_coll_stage;
	}
	//getDispCashCollStageOP() added for SRR20056-SCF-7639
	public String getDispCashCollStageOP(){
		return this.disp_cash_coll_stage_op;
	}

	public String getAllocDispSheetDefaultYN(){
		return this.alloc_disp_sheet_default_yn;
	}

	public String getAllocDispLabelDefaultYN(){
		return this.alloc_disp_label_default_yn;
	}

	public String getAllocDrugLabelDefaultYN(){
		return this.alloc_drug_label_default_yn;
	}

	public String getDelDispSheetDefaultYN(){
		return this.del_disp_sheet_default_yn;
	}

	public String getDelDispLabelDefaultYN(){
		return this.del_disp_label_default_yn;
	}

	public String getDelDrugLabelDefaultYN(){
		return	this.del_drug_label_default_yn;
	}
	public String getIP_SQENCE_NO_FROM(){
		return	this.ip_sqence_no_from;
	}
	public String getIP_SQENCE_NO_TO(){
		return	this.ip_sqence_no_to;
	}
	
	public String getReimbursementOPAllocation() {
		return reimbursement_opallocation;
	}


	public String getSelectAll() {
		return select_all;
	}

	
	public void setSelectAll(String select_all) {
		this.select_all = select_all;
	}

	public void setOnlinePrintList(ArrayList onlinePrintList){
	this.onlinePrintList = onlinePrintList;
	}
	public ArrayList getOnlinePrintList() {
		return onlinePrintList;
	}

	public void setOnlinePrintList_d (ArrayList onlinePrintList){
	this.onlinePrintList = onlinePrintList;
	}
	public ArrayList getOnlinePrintList_d() {
		return onlinePrintList;
	}

	public void setOnlinePrintSetupMap (HashMap hmRow){
	this.hmRow = hmRow;
	}
	public HashMap getOnlinePrintSetupMap() {
		return hmRow;
	}

	/* added for SRR20056-CRF-0663   ---START*/
	public String getIPFillDispPrd(){
		return this.ip_fill_disp_prd;
	}
   public String getIPFillDispPrdUnit(){
		return this.ip_fill_disp_prd_unit;
	}

	 public String getIPDfltPrtyDisp(){
		return this.ip_dflt_prty_disp;
	}
	/* added for SRR20056-CRF-0663	--END*/

//  public String getDisplocRemarks(){
//		return this.disploc_remarks;
//  }

	//Added for Bru-HIMS-CRF-142 [IN:030195] - start
	public void setPatArrival(String pat_arrival) {
		this.pat_arrival = pat_arrival;
	}
	public void setActualToken(String actual_token) {
		this.actual_token = actual_token;
	}
	public void setTokenNoLabel(String token_no_label) {
		this.token_no_label = token_no_label;
	}
	public void setStorageLoc(String storage_loc) {
		this.storage_loc = storage_loc;
	}
    public String getPatArrival() {
		return this.pat_arrival ;
	}
	public String getActualToken() {
		return this.actual_token ;
	}
	public String getTokenNoLabel() {
		return this.token_no_label ;
	}
  
    public String getStorageLoc() {
		return this.storage_loc ;
	}
	//Added for Bru-HIMS-CRF-142 [IN:030195] - end
	/* Get Methods End */
    //Added for NMC-JD-CRF-0008 start
    public void setExtDispAppYN(String ext_disp_app_yn){
	    if(ext_disp_app_yn==null || ext_disp_app_yn.equals(""))
			this.ext_disp_app_yn="N";
	    else
			this.ext_disp_app_yn=ext_disp_app_yn;
	}
	
	public String getExtDispAppYN(){
	    return this.ext_disp_app_yn;
	}
	//Added for NMC-JD-CRF-0008 end
	public void setAll( Hashtable recordSet ) {
		System.err.println("recordSet@@@ setAll=="+recordSet);
		if(recordSet.containsKey("mode"))
			setMode((String)recordSet.get("mode")) ;

		if(recordSet.containsKey("STORE_CODE"))
			setStoreCode((String)recordSet.get("STORE_CODE"));

		if(recordSet.containsKey("DISP_LOCN_CODE"))
			setDispLocnCode((String)recordSet.get("DISP_LOCN_CODE"));
		
		if(recordSet.containsKey("working_hour_from"))
			setWorkingFrom((String)recordSet.get("working_hour_from"));
		
		if(recordSet.containsKey("working_hour_to"))
			setWorkingTo((String)recordSet.get("working_hour_to"));

		if(recordSet.containsKey("LONG_DESC"))
			setLongDesc((String)recordSet.get("LONG_DESC"));

		if(recordSet.containsKey("SHORT_DESC"))
			setShortDesc((String)recordSet.get("SHORT_DESC"));

		if(recordSet.containsKey("DISP_LOCN_TYPE"))
			setDispLocnType((String)recordSet.get("DISP_LOCN_TYPE"));

		if(recordSet.containsKey("DISP_LOCN_CATEGORY"))
			setDispLocnCategory((String)recordSet.get("DISP_LOCN_CATEGORY"));

		if(recordSet.containsKey("EFF_STATUS")) {
			if ( recordSet.get("EFF_STATUS").toString().equals("E") )
				setEffStat("E") ;
			else
				setEffStat("D") ;
		}

		if(recordSet.containsKey("DIRECT_DISP_ALLOWED_YN")) {
			if ( recordSet.get("DIRECT_DISP_ALLOWED_YN").toString().equals("Y") )
				setDirdispAllowe("Y") ;
			else
				setDirdispAllowe("N") ;
		}
		if(recordSet.containsKey("EXTERNAL_RX_ALLOWED_YN")) {
			if ( recordSet.get("EXTERNAL_RX_ALLOWED_YN").toString().equals("Y") )
				setExternalPrescriptionYN("Y") ;
			else
				setExternalPrescriptionYN("N") ;
		}
		if(recordSet.containsKey("VERIFY_REGULAR_IP_RX_YN")) {
			if ( recordSet.get("VERIFY_REGULAR_IP_RX_YN").toString().equals("Y") )
				setNewPrescriptionsOnlyYN("Y") ;
			else
				setNewPrescriptionsOnlyYN("N") ;
		}
		if(recordSet.containsKey("DISP_DRUG_CLASS_G")) {
			if ( recordSet.get("DISP_DRUG_CLASS_G").toString().equals("Y") )
				setGenDrug("Y") ;
			else
				setGenDrug("N") ;
		}

		if(recordSet.containsKey("DISP_DRUG_CLASS_N")) {
			if ( recordSet.get("DISP_DRUG_CLASS_N").toString().equals("Y") )
				setNarcoDrug("Y") ;
			else
				setNarcoDrug("N") ;
		}

		if(recordSet.containsKey("DISP_DRUG_CLASS_C")) {
			if ( recordSet.get("DISP_DRUG_CLASS_C").toString().equals("Y") )
				setControlDrug("Y") ;
			else
				setControlDrug("N") ;
		}

		if(recordSet.containsKey("REGN_CHK_BOX")) {
			if ( recordSet.get("REGN_CHK_BOX").toString().equals("Y") )
				setRegistration("Y") ;
			else
				setRegistration("N") ;
		}

		if(recordSet.containsKey("PRINT_PRES")) {
			if ( recordSet.get("PRINT_PRES").toString().equals("Y") )
				setPrintPresc("Y") ;
			else
				setPrintPresc("N") ;
		}

		if(recordSet.containsKey("ISSUE_TOKEN")) {
			if ( recordSet.get("ISSUE_TOKEN").toString().equals("Y") )
				setIssueToken("Y") ;
			else
				setIssueToken("N") ;
		}

		if(recordSet.containsKey("FILLING_CHK_BOX")) {
			if ( recordSet.get("FILLING_CHK_BOX").toString().equals("Y") )
				setFilling("Y") ;
			else
				setFilling("N") ;
		}

		if(recordSet.containsKey("FILLING_STAGE"))
				setFillingStage((String)recordSet.get("FILLING_STAGE")) ;

		if(recordSet.containsKey("PHARM_VERFN"))
			if(recordSet.get("PHARM_VERFN")== null ||recordSet.get("PHARM_VERFN").equals("")){
				setPharmVerfn("C");
		   }else{
			     setPharmVerfn((String)recordSet.get("PHARM_VERFN"));
		   }

		//if(recordSet.containsKey("BILL_GEN_CASH_COLL"))
			//setBillGen((String)recordSet.get("BILL_GEN_CASH_COLL"));

		if(recordSet.containsKey("DELIVERY_CHK_BOX")) {
			if ( recordSet.get("DELIVERY_CHK_BOX").toString().equals("Y") )
				setDelivery("Y") ;
			else
				setDelivery("N") ;
		}

		if(recordSet.containsKey("PRINT_DISP_SHEET")) {
			if ( recordSet.get("PRINT_DISP_SHEET").toString().equals("Y") )
				setPrintDispSheet("Y") ;
			else
				setPrintDispSheet("N") ;
		}

		if(recordSet.containsKey("PRINT_BAL_MED_SHEET")) {
			if ( recordSet.get("PRINT_BAL_MED_SHEET").toString().equals("Y") )
				setPrintBalMedSheet("Y") ;
			else
				setPrintBalMedSheet("N") ;
		}

		if(recordSet.containsKey("ALLOW_MED_RETURN")) {
			if ( recordSet.get("ALLOW_MED_RETURN").toString().equals("Y") )
				setMedReturn("Y") ;
			else
				setMedReturn("N") ;
		}

		if(recordSet.containsKey("RETURN_WITHIN"))
			setMaxRetPrd((String)recordSet.get("RETURN_WITHIN"));

		if(recordSet.containsKey("MAX_RETURN_STOCK"))
			setReturnWithin((String)recordSet.get("MAX_RETURN_STOCK"));

		if(recordSet.containsKey("STAT_ORDER"))
			setStatOrder((String)recordSet.get("STAT_ORDER"));

		if(recordSet.containsKey("ROUTINE_ORDER"))
			setReturnOrder((String)recordSet.get("ROUTINE_ORDER"));

		if(recordSet.containsKey("VERIFY")) {
			if ( recordSet.get("VERIFY").toString().equals("Y") )
				setIPVerify("Y") ;
			else
				setIPVerify("N") ;
		}

		if(recordSet.containsKey("FILL_PROCESS"))
			setIPFillPeriod((String)recordSet.get("FILL_PROCESS"));

		if(recordSet.containsKey("FILL_PROCESS_UNIT"))
			setIPFillPeriodUnit((String)recordSet.get("FILL_PROCESS_UNIT"));

		if(recordSet.containsKey("DELIVERY")) {
			if ( recordSet.get("DELIVERY").toString().equals("Y") )
				setIPDelivery("Y") ;
			else
				setIPDelivery("N") ;
		}

		if(recordSet.containsKey("EXCLUDE_ORDERS"))
			setExcludeOrders((String)recordSet.get("EXCLUDE_ORDERS"));

		if(recordSet.containsKey("CONT_INT_ORDERS"))
			setContIntermittent((String)recordSet.get("CONT_INT_ORDERS"));

		if(recordSet.containsKey("IP_STAT_ORDER"))
			setIPStatOrder((String)recordSet.get("IP_STAT_ORDER"));

		if(recordSet.containsKey("IP_ROUTINE_ORDER"))
			setIPReturnOrder((String)recordSet.get("IP_ROUTINE_ORDER"));

		if(recordSet.containsKey("DISP_STAGE"))
			setDispStage((String)recordSet.get("DISP_STAGE"));

		if(recordSet.containsKey("IP_ALLOC_YN")) {
			if ( recordSet.get("IP_ALLOC_YN").toString().equals("Y") )
				setIPAllocYN("Y") ;
			else
				setIPAllocYN("N") ;
		}
		if(disp_locn_type.equals("C")||disp_locn_type.equals("N")){
			 setAUTODISPATADMINYN("Y") ;
		}
		else{			
			if(recordSet.containsKey("AUTO_DISP_AT_ADMIN_YN")) {
				if ( recordSet.get("AUTO_DISP_AT_ADMIN_YN").toString().equals("Y") )
					setAUTODISPATADMINYN("Y") ;
				else
					setAUTODISPATADMINYN("N") ;
			}
		}

		if(recordSet.containsKey("IP_ALLOW_DRUG_RETURN_YN")) {
			if ( recordSet.get("IP_ALLOW_DRUG_RETURN_YN").toString().equals("Y") )
				setIPAllowDrugReturnYN("Y") ;
			else
				setIPAllowDrugReturnYN("N") ;
		}

		if(recordSet.containsKey("IP_FILL_ALLOCATE_BATHCES_YN")) {
			if ( recordSet.get("IP_FILL_ALLOCATE_BATHCES_YN").toString().equals("Y") )
				setIPFillBatchesYN("Y") ;
			else
				setIPFillBatchesYN("N") ;
		}

		if(recordSet.containsKey("ALLOW_USAGE_OF_SPIL_QTY_YN")) {
			if ( recordSet.get("ALLOW_USAGE_OF_SPIL_QTY_YN").toString().equals("Y") )
				setIPAllowSpillUsageYN("Y") ;
			else
				setIPAllowSpillUsageYN("N") ;
		}
		if(recordSet.containsKey("CHARGE_PAT_FOR_SPILL_QTY_YN")) {
			if ( recordSet.get("CHARGE_PAT_FOR_SPILL_QTY_YN").toString().equals("Y") )
				setChargePatForSpillQtyYN("Y") ;
			else  
				setChargePatForSpillQtyYN("N") ;
		}

		//if(recordSet.containsKey("CHARGE_QTY_IND"))
			//setIPChargeQtyInd((String)recordSet.get("CHARGE_QTY_IND"));
		
		if(recordSet.containsKey("disp_level"))
			setDispLevel((String)recordSet.get("disp_level"));
		if(recordSet.containsKey("op_disp_period"))
			setOpDispPeriod((String)recordSet.get("op_disp_period"));

		if(recordSet.containsKey("ADMIX_PREP_ALWD")) {
			if ( recordSet.get("ADMIX_PREP_ALWD").toString().equals("Y") )
				setAdmixPrepAlwd_YN("Y") ;
			else
				setAdmixPrepAlwd_YN("N") ;
		}

       
	   if(recordSet.containsKey("GENERATE_TOKON_REISSUE")) {
			if ( recordSet.get("GENERATE_TOKON_REISSUE").toString().equals("Y") )
				setGenerateTokonReissueYN("Y") ;
			else
				setGenerateTokonReissueYN("N") ;
		}


          if(recordSet.containsKey("GENERATE_TOKON_RETURN_MEDI")) {
			if ( recordSet.get("GENERATE_TOKON_RETURN_MEDI").toString().equals("Y") )
				setGenerateTokonReturnYN("Y") ;
			else
				setGenerateTokonReturnYN("N") ;
		}

		  if(recordSet.containsKey("GENERATE_TOKON_DIRECT_DISP")) {
			if ( recordSet.get("GENERATE_TOKON_DIRECT_DISP").toString().equals("Y") )
				setGenerateTokonDirectYN("Y") ;
			else
				setGenerateTokonDirectYN("N") ;
		}

		if(recordSet.containsKey("DISP_BILL_STAGE")){
			if ( recordSet.get("DISP_BILL_STAGE").toString().equals("X") )
				setDispBillStage("X");
			else if ( recordSet.get("DISP_BILL_STAGE").toString().equals("A") )
				setDispBillStage("A");
			else if ( recordSet.get("DISP_BILL_STAGE").toString().equals("D") )
				setDispBillStage("D");
		}
		else
				setDispBillStage("X");
		if(recordSet.containsKey("DISP_CASH_COLL_STAGE")){
			if ( recordSet.get("DISP_CASH_COLL_STAGE").toString().equals("X") )
				setDispCashCollStage("X");
			else if ( recordSet.get("DISP_CASH_COLL_STAGE").toString().equals("D") )
				setDispCashCollStage("D");
			else if ( recordSet.get("DISP_CASH_COLL_STAGE").toString().equals("S") )
				setDispCashCollStage("S");
		}
//added for SRR20056-SCF-7639 - start
		if(recordSet.containsKey("DISP_BILL_STAGE_OP")){
			if ( recordSet.get("DISP_BILL_STAGE_OP").toString().equals("X") )
				setDispBillStageOP("X");
			else if ( recordSet.get("DISP_BILL_STAGE_OP").toString().equals("A") )
				setDispBillStageOP("A");
			else if ( recordSet.get("DISP_BILL_STAGE_OP").toString().equals("D") )
				setDispBillStageOP("D");
		}
		if(recordSet.containsKey("DISP_CASH_COLL_STAGE_OP")){
			if ( recordSet.get("DISP_CASH_COLL_STAGE_OP").toString().equals("X") )
				setDispCashCollStageOP("X");
			else if ( recordSet.get("DISP_CASH_COLL_STAGE_OP").toString().equals("D") )
				setDispCashCollStageOP("D");
			else if ( recordSet.get("DISP_CASH_COLL_STAGE_OP").toString().equals("S") )
				setDispCashCollStageOP("S");
		}
//added for SRR20056-SCF-7639 - END
			if(recordSet.containsKey("ALLO_DISP_SHEET")){
				//System.out.println("ALLO_DISP_SHEET "+recordSet.get("ALLO_DISP_SHEET").toString());
				if ( recordSet.get("ALLO_DISP_SHEET").toString().equals("Y") )
				setAllocDispSheetDefaultYN("Y");
			else
				setAllocDispSheetDefaultYN("N");
			}

			if(recordSet.containsKey("DELI_DISP_SHEET")){
				//System.out.println("DELI_DISP_SHEET "+recordSet.get("DELI_DISP_SHEET").toString());
				if ( recordSet.get("DELI_DISP_SHEET").toString().equals("Y") )
				setDelDispSheetDefaultYN("Y");
			else
				setDelDispSheetDefaultYN("N");
			}

			if(recordSet.containsKey("ALLO_DISP_LABEL")){
					//System.out.println("ALLO_DISP_LABEL "+recordSet.get("ALLO_DISP_LABEL").toString());
				if ( recordSet.get("ALLO_DISP_LABEL").toString().equals("Y") )
				setAllocDispLabelDefaultYN("Y");
			else
				setAllocDispLabelDefaultYN("N");
			}

			if(recordSet.containsKey("DELI_DISP_LABEL")){
				//System.out.println("DELI_DISP_LABEL "+recordSet.get("DELI_DISP_LABEL").toString());
				if ( recordSet.get("DELI_DISP_LABEL").toString().equals("Y") )
				setDelDispLabelDefaultYN("Y");
			else
				setDelDispLabelDefaultYN("N");
			}
        
			if(recordSet.containsKey("ALLO_DRUG_LABEL")){
				//System.out.println("ALLO_DRUG_LABEL "+recordSet.get("ALLO_DRUG_LABEL").toString());
				if ( recordSet.get("ALLO_DRUG_LABEL").toString().equals("Y") )
				setAllocDrugLabelDefaultYN("Y");
			else
				setAllocDrugLabelDefaultYN("N");
			}

			if(recordSet.containsKey("DELI_DRUG_LABEL")){
				//System.out.println("DELI_DRUG_LABEL "+recordSet.get("DELI_DRUG_LABEL").toString());
				if ( recordSet.get("DELI_DRUG_LABEL").toString().equals("Y") )
				setDelDrugLabelDefaultYN("Y");
				else
				setDelDrugLabelDefaultYN("N");
			}
			if(recordSet.containsKey("IP_SQENCE_NO_FROM"))
			setIP_SQENCE_NO_FROM((String)recordSet.get("IP_SQENCE_NO_FROM"));
			if(recordSet.containsKey("IP_SQENCE_NO_TO"))
			setIP_SQENCE_NO_TO((String)recordSet.get("IP_SQENCE_NO_TO"));
	
			/* added for SRR20056-CRF-0663	--START*/
			if(recordSet.containsKey("IP_FILL_DISP_PRD"))
				setIPFillDispPrd((String)recordSet.get("IP_FILL_DISP_PRD")); 
			if(recordSet.containsKey("IP_FILL_DISP_PRD_UNIT"))
				setIPFillDispPrdUnit((String)recordSet.get("IP_FILL_DISP_PRD_UNIT"));
			if(recordSet.containsKey("IP_DFLT_PRTY_DISP"))
				setIPDfltPrtyDisp((String)recordSet.get("IP_DFLT_PRTY_DISP"));
			/* added for SRR20056-CRF-0663		--END*/
			if(recordSet.containsKey("BAR_SCAN_ALLOWED_YN"))//if block added for KDAH-CRF-0231 [IN-034551] - Barcode CRF Changes.
			    setBarcode_Scan_YN(recordSet.get("BAR_SCAN_ALLOWED_YN").toString());

			//Added for Bru-HIMS-CRF-142 [IN:030195] - start
			if(recordSet.containsKey("PAT_ARRIVAL")) 
			if ( recordSet.get("PAT_ARRIVAL").toString().equals("Y") )

				setPatArrival("Y") ;
			else
				setPatArrival("N") ;

	     	if(recordSet.containsKey("ACTUAL_TOKEN"))
			if ( recordSet.get("ACTUAL_TOKEN").toString().equals("Y") )
				setActualToken("Y") ;
			else
				setActualToken("N") ;
		
		    if(recordSet.containsKey("TOKEN_NO_LABEL"))
			if ( recordSet.get("TOKEN_NO_LABEL").toString().equals("Y") )
				setTokenNoLabel("Y") ;
			else
				setTokenNoLabel("N") ;

		    if(recordSet.containsKey("STORAGE_LOCN"))
			if ( recordSet.get("STORAGE_LOCN").toString().equals("Y") )
				setStorageLoc("Y") ;
			else
				setStorageLoc("N") ;
			//Added for  Bru-HIMS-CRF-142 [IN:030195] - end
			if(recordSet.containsKey("PIN_AUTH_DISP_YN")) //if block added for RUT-CRF-0035 [IN029926] 
			    setPIN_Auth_DispMed(recordSet.get("PIN_AUTH_DISP_YN").toString());
			if(recordSet.containsKey("CURRENT_DISP_LOC") && "Y".equals((String) recordSet.get("CURRENT_DISP_LOC")))//Added for HSA-CRF-0113 [IN:048166] 
				setDefaultBmsLocation(getDispLocnCode());
			else if(recordSet.containsKey("defBMSDispLoc"))//Added for HSA-CRF-0113 [IN:048166] 
				setDefaultBmsLocation(recordSet.get("defBMSDispLoc").toString());
			//Added for NMC-JD-CRF-0008 start
			if(recordSet.containsKey("EXT_DISP_YN")) {
				setExtDispAppYN(recordSet.get("EXT_DISP_YN").toString());
			}else{
				setExtDispAppYN("N");
			}
			//Added for NMC-JD-CRF-0008 end
	}

	public HashMap validate() throws Exception {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( true ) ) ;
		map.put( "message", "success.." ) ;
		return map ;
	}

	public HashMap insert() {
		ArrayList insertData = new ArrayList() ;
		insertData.add(login_facility_id);//0
		insertData.add(getDispLocnCode());	//1	
		insertData.add(getStoreCode());//2
		insertData.add(getLongDesc());//3
		insertData.add(getShortDesc());//4
		insertData.add(getDispLocnType());//5
		insertData.add(getDispLocnCategory());//6
		insertData.add(getEffStat());//7
		insertData.add(getGenDrug());//8
		insertData.add(getNarcoDrug());//9
		insertData.add(getControlDrug());//10
		insertData.add(getRegistration());//11
		insertData.add(getPrintPresc());//12
		insertData.add(getIssueToken());//13
		insertData.add(getFilling());//14
		insertData.add(getFillingStage());//15
		insertData.add(getPharmVerfn());//16
		//insertData.add(getBillGen());
		insertData.add(getDelivery());//17
		insertData.add(getPrintDispSheet());//18
		insertData.add(getPrintBalMedSheet());//19
		insertData.add(getMedReturn());//20
		insertData.add(getMaxRetPrd());//21
		insertData.add(getReturnWithin());//22
		insertData.add(getStatOrder());//23
		insertData.add(getReturnOrder());//24
		insertData.add(getIPVerify());//25
		insertData.add(getIPFillPeriod());//26

		if(getIPFillPeriodUnit()==null || getIPFillPeriodUnit().equals(""))
			insertData.add("D");//27
		else
			insertData.add(getIPFillPeriodUnit());//27

		insertData.add(getIPDelivery());//28
		insertData.add(getExcludeOrders());//29

		if(getContIntermittent()==null || getContIntermittent().equals(""))
			insertData.add("00:00");//30
		else
			insertData.add(getContIntermittent());//30

		//insertData.add(getContIntermittent());
		insertData.add(getIPStatOrder());//31
		insertData.add(getIPReturnOrder());//32
		insertData.add(login_by_id);//33
		insertData.add(login_at_ws_no);//34
		insertData.add(login_facility_id);//35
		insertData.add(login_by_id);//36
		insertData.add(login_at_ws_no);//37
		insertData.add(login_facility_id);//38
		insertData.add(getDispStage());//39
		insertData.add(getIPAllocYN());//40

		if(getAUTODISPATADMINYN()==null || getAUTODISPATADMINYN().equals(""))
			insertData.add("Y");//41
		else
			insertData.add(getAUTODISPATADMINYN());//41

		if(getIPAllowDrugReturnYN() ==null || getIPAllowDrugReturnYN().equals(""))
			insertData.add("N");//42
		else
			insertData.add(getIPAllowDrugReturnYN());//42

		insertData.add(getIPFillBatchesYN());//43
		insertData.add(getIPAllowSpillUsageYN());//44
		//insertData.add(getIPChargeQtyInd());
		insertData.add(getDispLevel());//45
		
		//----------------
		insertData.add(getWorkingFrom());//46
		insertData.add(getWorkingTo());//47
        //----------------
		insertData.add(getOpDispPeriod());//48
		insertData.add(getAdmixPrepAlwd_YN());//49
		insertData.add(getGenerateTokonReissueYN());//50
		insertData.add(getGenerateTokonReturnYN());//51
		insertData.add(getGenerateTokonDirectYN());//52
		insertData.add(getDirdispAllowe());		//53
		if(getChargePatForSpillQtyYN() ==null || getChargePatForSpillQtyYN().equals(""))
			insertData.add("N");//54
		else
			insertData.add(getChargePatForSpillQtyYN());//54
		//insertData.add(getChargePatForSpillQtyYN());
		insertData.add(getDispBillStage());//55
		insertData.add(getDispCashCollStage());//56		
		if(getRemarksCode() ==null || getRemarksCode().equals("null"))
			insertData.add("");//57
		else
			insertData.add(getRemarksCode());//57

		insertData.add(getExternalPrescriptionYN());//58
		insertData.add(getNewPrescriptionsOnlyYN());//59
/*System.out.println("getAllocDispSheetDefaultYN()=="+getAllocDispSheetDefaultYN());
		insertData.add(getAllocDispSheetDefaultYN());//60
		insertData.add(getAllocDispLabelDefaultYN());//61
		insertData.add(getAllocDrugLabelDefaultYN());//62
		insertData.add(getDelDispSheetDefaultYN());//63
		insertData.add(getDelDispLabelDefaultYN());//64
		insertData.add(getDelDrugLabelDefaultYN());//65*/
		insertData.add("Y");//60
		insertData.add("Y");//61
		insertData.add("Y");//62		
		insertData.add(getDelDispSheetDefaultYN());//63
		insertData.add(getDelDispLabelDefaultYN());//64
		insertData.add("Y");//65
		insertData.add(getIP_SQENCE_NO_FROM());//66
		insertData.add(getIP_SQENCE_NO_TO());//67
		insertData.add(getOnlinePrintSetupMap());//68

		/* added for SRR20056-CRF-0663 ----------------START*/
		insertData.add(getIPFillDispPrd());//69
		if((getIPFillDispPrd()!=null && !getIPFillDispPrd().equals("")) || getIPFillDispPrdUnit().equals("P") )
			insertData.add(getIPFillDispPrdUnit());//71
		else
			insertData.add("");//71
		insertData.add(getIPDfltPrtyDisp());//72
		/* added for SRR20056-CRF-0663 ----------------END*/

		//added for SRR20056-SCF-7639 ICN027720- start
		insertData.add(getDispBillStageOP());//73
		insertData.add(getDispCashCollStageOP());//74		
		//added for SRR20056-SCF-7639 ICN027720 - END

		insertData.add(getBarcode_Scan_YN());//75	// added for KDAH-CRF-0231 [IN-034551]

		insertData.add(getPatArrival());//75	//addded for Bru-HIMS-CRF-142 [IN:030195] -start
		insertData.add(getActualToken());//76
		insertData.add(getTokenNoLabel());//77
		insertData.add(getStorageLoc());//78	//Added for  Bru-HIMS-CRF-142 [IN:030195] -end
		insertData.add(getPIN_Auth_DispMed());//79	//Added for  RUT-CRF-0035 [IN029926]
		insertData.add(getDefaultBmsLocation());//80 //Added for HSA-CRF-0113 [IN:048166] 
		insertData.add(getExtDispAppYN());//Added for NMC-JD-CRF-0008
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "InsertDataDL", insertData ) ;

		HashMap sqlMap = new HashMap() ;
		try {
			sqlMap.put( "InsertSQLDL", PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_INSERT" ));
			sqlMap.put( "InsertSQLDL1","INSERT INTO ph_disp_locn_prn_option(FACILITY_ID,DISP_LOCN_CODE,REPORT_ID,PATIENT_CLASS,DISP_STAGE,PRINT_STATUS,DISPLAY_ORDER,EFF_STATUS) values (?, ?, ?, ?, ?, ?, ?, ?) "); 
		}
		catch (Exception e) {
			e.printStackTrace() ;
		}
		return callFunctionEJB( tabData,sqlMap );
	}

	public HashMap modify() {
		ArrayList modifyData = new ArrayList() ;
		modifyData.add(getLongDesc());
		modifyData.add(getShortDesc());
		modifyData.add(getEffStat());
		modifyData.add(getGenDrug());
		modifyData.add(getNarcoDrug());
		modifyData.add(getControlDrug());
		modifyData.add(getRegistration());
		modifyData.add(getPrintPresc());
		modifyData.add(getIssueToken());
		modifyData.add(getFilling());
		modifyData.add(getFillingStage());
		modifyData.add(getPharmVerfn());
		//modifyData.add(getBillGen());
		modifyData.add(getDelivery());
		modifyData.add(getPrintDispSheet());
		modifyData.add(getPrintBalMedSheet());
		modifyData.add(getMedReturn());
		modifyData.add(getMaxRetPrd());
		modifyData.add(getReturnWithin());
		modifyData.add(getStatOrder());
		modifyData.add(getReturnOrder());
		modifyData.add(getIPVerify());
		modifyData.add(getIPFillPeriod());
		if(getIPFillPeriodUnit()==null || getIPFillPeriodUnit().equals(""))
			modifyData.add("D");
		else
			modifyData.add(getIPFillPeriodUnit());

		modifyData.add(getIPDelivery());
		modifyData.add(getExcludeOrders());
		if(getContIntermittent()==null || getContIntermittent().equals(""))
			modifyData.add("00:00");
		else
			modifyData.add(getContIntermittent());
		//modifyData.add(getContIntermittent());
		modifyData.add(getIPStatOrder());
		modifyData.add(getIPReturnOrder());
		modifyData.add(login_by_id);
		modifyData.add(login_at_ws_no);
		modifyData.add(login_facility_id);
		modifyData.add(getIPAllocYN());

		if(getAUTODISPATADMINYN()==null || getAUTODISPATADMINYN().equals(""))
			modifyData.add("Y");
		else
			modifyData.add(getAUTODISPATADMINYN());

		if(getIPAllowDrugReturnYN() ==null || getIPAllowDrugReturnYN().equals(""))
			modifyData.add("N");
		else
			modifyData.add(getIPAllowDrugReturnYN());
		
		modifyData.add(getIPFillBatchesYN());
		modifyData.add(getIPAllowSpillUsageYN());
		//modifyData.add(getIPChargeQtyInd());
		modifyData.add(getDispLevel());
		//----------------
		modifyData.add(getWorkingFrom());
		modifyData.add(getWorkingTo());
		modifyData.add(getOpDispPeriod());
		modifyData.add(getAdmixPrepAlwd_YN());
		modifyData.add(getGenerateTokonReissueYN());
		modifyData.add(getGenerateTokonReturnYN());
		modifyData.add(getGenerateTokonDirectYN());
		modifyData.add(getDirdispAllowe());
		if(getChargePatForSpillQtyYN() ==null || getChargePatForSpillQtyYN().equals(""))
			modifyData.add("N");
		else
			modifyData.add(getChargePatForSpillQtyYN());
		//modifyData.add(getChargePatForSpillQtyYN());
		modifyData.add(getDispBillStage());
		modifyData.add(getDispCashCollStage());

		try{
			if(((String) getRemarksCode()).equals("")){
				//ArrayList dummy=(ArrayList)getBMSRemarksDescription(getDispLocnCode());  Removed for IN063877
				 
			}
		}catch(Exception e){
		}
		if( getRemarksCode() ==null ||  getRemarksCode().equals("null"))
		modifyData.add("");
		else
		modifyData.add(this.remarks_code);

		modifyData.add(getExternalPrescriptionYN());
		modifyData.add(getNewPrescriptionsOnlyYN());
		//modifyData.add( getRemarksCode());
		
        //----------------
		modifyData.add("Y");//getAllocDispSheetDefaultYN()
		modifyData.add("Y");//getAllocDispLabelDefaultYN()
		modifyData.add("Y");//getAllocDrugLabelDefaultYN()
		modifyData.add(getDelDispSheetDefaultYN());
		modifyData.add(getDelDispLabelDefaultYN());
		modifyData.add("Y");//getDelDrugLabelDefaultYN()
		modifyData.add(getIP_SQENCE_NO_FROM());
		modifyData.add(getIP_SQENCE_NO_TO());
		modifyData.add(login_facility_id);
		modifyData.add(getDispLocnCode());//60th index in modifya data list		
		modifyData.add(getDispLocnType());//61		
		modifyData.add(getOnlinePrintSetupMap());//62

		/* added for SRR20056-CRF-0663 ----------------START*/
		modifyData.add(getIPFillDispPrd());//63
		if((getIPFillDispPrd()!=null && !getIPFillDispPrd().equals("")) || getIPFillDispPrdUnit().equals("P") )
			modifyData.add(getIPFillDispPrdUnit());//64
		else
			modifyData.add("");//64
		modifyData.add(getIPDfltPrtyDisp());//65
		/* added for SRR20056-CRF-0663 ----------------END*/
		//added for SRR20056-SCF-7639 ICN027720- start
		modifyData.add(getDispBillStageOP()); //66
		modifyData.add(getDispCashCollStageOP()); //67
		//added for SRR20056-SCF-7639 ICN027720- end
		modifyData.add(getBarcode_Scan_YN()); //68 //Added for KDAH-CRF-0231 [IN-034551] - Barcode CRF Changes.

		modifyData.add(getPatArrival());//68	//Added for  Bru-HIMS-CRF-142 [IN:030195] - start
		modifyData.add(getActualToken());//69
		modifyData.add(getTokenNoLabel());//70
		modifyData.add(getStorageLoc());//71 //Added for  Bru-HIMS-CRF-142 [IN:030195] - End
		modifyData.add(getPIN_Auth_DispMed());//72 //Added for  RUT-CRF-0035 [IN029926]
		modifyData.add(getDefaultBmsLocation());//73 //Added for HSA-CRF-0113 [IN:048166] 
		modifyData.add(getExtDispAppYN());//Added for NMC-JD-CRF-0008
		HashMap tabData = new HashMap() ;
		tabData.put( "properties", getProperties() );
		tabData.put( "ModifyDataDL", modifyData ) ;
        
		HashMap sqlMap = new HashMap() ;
		try {
			sqlMap.put( "ModifySQLDL", PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_UPDATE" ));
			sqlMap.put( "ModifySQLDL1","INSERT INTO ph_disp_locn_prn_option(FACILITY_ID,DISP_LOCN_CODE,REPORT_ID,PATIENT_CLASS,DISP_STAGE,PRINT_STATUS,DISPLAY_ORDER,EFF_STATUS) values (?, ?, ?, ?, ?, ?, ?, ?)");
		}
		catch (Exception e) {
			e.printStackTrace() ;
		}

		return callFunctionEJB( tabData,sqlMap );
	}
	/* Over-ridden Adapter methods end here */

	/* Function specific methods start */
	private  HashMap callFunctionEJB( HashMap tabData , HashMap sqlMap ) {
		HashMap map = new HashMap() ;
		map.put( "result", new Boolean( false ) ) ;

/*		DispenseLocationHome home = null;
		DispenseLocationRemote remote = null;*/
		try {
/*			InitialContext context = new InitialContext() ;
			Object object = context.lookup( PhRepository.getPhKeyValue( "JNDI_PH_DISP_LOCN" ) ) ;
			home  = (DispenseLocationHome) PortableRemoteObject.narrow( object, DispenseLocationHome.class ) ;
			remote = home.create() ;

			if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )  )
				map = remote.insert( tabData, sqlMap ) ;
			else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) )
				map = remote.modify( tabData, sqlMap ) ;*/

			Object home=com.ehis.eslp.ServiceLocator.getInstance().getHome(PhRepository.getPhKeyValue("JNDI_PH_DISP_LOCN"),DispenseLocationHome.class,getLocalEJB());
			Object busObj=(home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[]=new Object[2];
			argArray[0]=tabData;
			argArray[1]=sqlMap;

			Class[] paramArray=new Class[2];
			paramArray[0]=tabData.getClass();
			paramArray[1]=sqlMap.getClass();

			if( mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )  )
    			map=(HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			else if ( mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) )
	    		map=(HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);

			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) map.get( "result" )).booleanValue() )
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
			else
				map.put( "message", (map.get("msgid"))) ;
		}
		catch(Exception e) {
			System.err.println( "Error Calling EJB classcast : "+e ) ;
			map.put( "message", e.getMessage()) ;
			e.printStackTrace() ;
		}
/*		finally {
			try {
				if( remote != null )
					remote.remove() ;
			}
			catch( Exception ee ) {
				System.err.println( ee.getMessage() ) ;
				map.put( "message", ee.getMessage() ) ;
			}
		}*/
		return map;
	}

	public boolean loadInitVals() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		boolean chkFacility = false ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_SELECT1" )) ;
			pstmt.setString(1, login_facility_id) ;
			resultSet = pstmt.executeQuery() ;

			if ( resultSet.next() )
				chkFacility = true ;

			if (chkFacility) {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;

				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_SELECT2" )) ;
				resultSet = pstmt.executeQuery() ;

				while ( resultSet.next() ) {
					if (resultSet.getString("MODULE_ID").trim().equals("ST"))
						setStockModuleYN("Y");
					else if (resultSet.getString("MODULE_ID").trim().equals("IP"))
						setIPModuleYN("Y");
					else if (resultSet.getString("MODULE_ID").trim().equals("BL"))
						setBillingModuleYN("Y");
				}

				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;

				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_SELECT3" )) ;
				//pstmt = connection.prepareStatement("SELECT DISP_REGN_REQD_YN, DISP_FLNG_REQD_YN, DISP_FILL_STAGE, DISP_VERF_STAGE,DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, PRINT_BAL_MED_SHEET_OP_YN, ALLOW_DRUG_RETURN_YN, MAX_DURN_FOR_OP_MED_RTN, MAX_DRUG_RETENTION_BEF_RTN, IP_VERF_YN, IP_FILL_PRD_AHEAD, IP_FILL_PRD_UNIT, IP_DELV_REQD_YN, IP_FILL_EXCL_PRD_BEHIND, TO_CHAR(IP_FILL_DFLT_START_TIME,'HH24:MI') IP_FILL_DFLT_START_TIME FROM PH_FACILITY_PARAM WHERE FACILITY_ID = UPPER(?)") ;
				pstmt.setString(1, login_facility_id);
				resultSet = pstmt.executeQuery() ;

				while ( resultSet.next() ) {
					setRegistration(resultSet.getString("DISP_REGN_REQD_YN"));
					setFilling(resultSet.getString("DISP_FLNG_REQD_YN"));

					if (resultSet.getString("DISP_FILL_STAGE") != null )
						setFillingStage(resultSet.getString("DISP_FILL_STAGE"));
					else
						setFillingStage("");

					if (resultSet.getString("DISP_VERF_STAGE") != null )
						setPharmVerfn(resultSet.getString("DISP_VERF_STAGE"));
					else
						setPharmVerfn("");

					//if (resultSet.getString("DISP_CASH_COLL_STAGE") != null )
					//	setBillGen(resultSet.getString("DISP_CASH_COLL_STAGE"));
					//else
					//	setBillGen("");

					setDelivery(resultSet.getString("DISP_DELV_REQD_YN"));
					setPrintDispSheet(resultSet.getString("PRINT_DISP_SHEET_OP_YN"));
					setPrintBalMedSheet(resultSet.getString("PRINT_BAL_MED_SHEET_OP_YN"));
					setMedReturn(resultSet.getString("ALLOW_DRUG_RETURN_YN"));

					if (resultSet.getString("MAX_DURN_FOR_OP_MED_RTN") != null )
						setReturnWithin(resultSet.getString("MAX_DURN_FOR_OP_MED_RTN"));
					else
						setReturnWithin("");

					if (resultSet.getString("MAX_DRUG_RETENTION_BEF_RTN") != null )
						setMaxRetPrd(resultSet.getString("MAX_DRUG_RETENTION_BEF_RTN"));
					else
						setMaxRetPrd("");					

					setIPVerify(resultSet.getString("IP_VERF_YN"));

					if (resultSet.getString("IP_FILL_PRD_AHEAD") != null ) {
						setIPFillPeriod(resultSet.getString("IP_FILL_PRD_AHEAD"));
						setIPFillPeriodForCheck(resultSet.getString("IP_FILL_PRD_AHEAD"));
					}
					else {
						setIPFillPeriod("");
						setIPFillPeriodForCheck("");
					}

					if (resultSet.getString("IP_FILL_PRD_UNIT") != null ) {
						setIPFillPeriodUnit(resultSet.getString("IP_FILL_PRD_UNIT"));
						setIPFillPeriodUnitForCheck(resultSet.getString("IP_FILL_PRD_UNIT"));
					}
					else {
						setIPFillPeriodUnit("");
						setIPFillPeriodUnitForCheck("");
					}

					setIPDelivery(resultSet.getString("IP_DELV_REQD_YN"));

					if (resultSet.getString("IP_FILL_EXCL_PRD_BEHIND") != null ) {
						setExcludeOrders(resultSet.getString("IP_FILL_EXCL_PRD_BEHIND"));
						setExcludeOrdersForCheck(resultSet.getString("IP_FILL_EXCL_PRD_BEHIND"));
					}
					else {
						setExcludeOrders("");
						setExcludeOrdersForCheck(resultSet.getString("IP_FILL_EXCL_PRD_BEHIND"));
					}

					if (resultSet.getString("IP_FILL_DFLT_START_TIME") != null )
						setContIntermittent(resultSet.getString("IP_FILL_DFLT_START_TIME"));
					else
						setContIntermittent("");
				}
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
			catch(Exception es){ 
				 es.printStackTrace();
		    }
		}
		return chkFacility;
	}

	public HashMap getFacilityParamVals() {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		HashMap paramVals = new HashMap();

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_SELECT3" )) ;
			//pstmt = connection.prepareStatement("SELECT DISP_REGN_REQD_YN, DISP_FLNG_REQD_YN, DISP_FILL_STAGE, DISP_VERF_STAGE, DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, PRINT_BAL_MED_SHEET_OP_YN, ALLOW_DRUG_RETURN_YN, MAX_DURN_FOR_OP_MED_RTN, MAX_DRUG_RETENTION_BEF_RTN, IP_VERF_YN, IP_FILL_PRD_AHEAD, IP_FILL_PRD_UNIT, IP_DELV_REQD_YN, IP_FILL_EXCL_PRD_BEHIND, TO_CHAR(IP_FILL_DFLT_START_TIME,'HH24:MI') IP_FILL_DFLT_START_TIME FROM PH_FACILITY_PARAM WHERE FACILITY_ID = UPPER(?)") ;
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery() ;

			while ( resultSet.next() ) {
				paramVals.put("DISP_REGN_REQD_YN",	resultSet.getString("DISP_REGN_REQD_YN"));
				paramVals.put("DISP_FLNG_REQD_YN",	resultSet.getString("DISP_FLNG_REQD_YN"));

				if (resultSet.getString("DISP_FILL_STAGE") != null )
					paramVals.put("DISP_FILL_STAGE", resultSet.getString("DISP_FILL_STAGE"));
				else
					paramVals.put("DISP_FILL_STAGE", "");

				if (resultSet.getString("DISP_VERF_STAGE") != null )
					paramVals.put("DISP_VERF_STAGE", resultSet.getString("DISP_VERF_STAGE"));
				else
					paramVals.put("DISP_VERF_STAGE", "");

				//if (resultSet.getString("DISP_CASH_COLL_STAGE") != null )
				//	paramVals.put("DISP_CASH_COLL_STAGE", resultSet.getString("DISP_CASH_COLL_STAGE"));
				//else
				//	paramVals.put("DISP_CASH_COLL_STAGE", "");

				paramVals.put("DISP_DELV_REQD_YN",			resultSet.getString("DISP_DELV_REQD_YN"));
				paramVals.put("PRINT_DISP_SHEET_OP_YN",		resultSet.getString("PRINT_DISP_SHEET_OP_YN"));
				paramVals.put("PRINT_BAL_MED_SHEET_OP_YN",	resultSet.getString("PRINT_BAL_MED_SHEET_OP_YN"));
				paramVals.put("ALLOW_DRUG_RETURN_YN",		resultSet.getString("ALLOW_DRUG_RETURN_YN"));

				if (resultSet.getString("MAX_DURN_FOR_OP_MED_RTN") != null )
					paramVals.put("MAX_DURN_FOR_OP_MED_RTN", resultSet.getString("MAX_DURN_FOR_OP_MED_RTN"));
				else
					paramVals.put("MAX_DURN_FOR_OP_MED_RTN", "");

				if (resultSet.getString("MAX_DRUG_RETENTION_BEF_RTN") != null )
					paramVals.put("MAX_DRUG_RETENTION_BEF_RTN", resultSet.getString("MAX_DRUG_RETENTION_BEF_RTN"));
				else
					paramVals.put("MAX_DRUG_RETENTION_BEF_RTN", "");

				paramVals.put("IP_VERF_YN", resultSet.getString("IP_VERF_YN"));

				if (resultSet.getString("IP_FILL_PRD_AHEAD") != null ) {
					paramVals.put("IP_FILL_PRD_AHEAD", resultSet.getString("IP_FILL_PRD_AHEAD"));
					setIPFillPeriodForCheck(resultSet.getString("IP_FILL_PRD_AHEAD"));
				}
				else {
					paramVals.put("IP_FILL_PRD_AHEAD", "");
					setIPFillPeriodForCheck("");
				}

				if (resultSet.getString("IP_FILL_PRD_UNIT") != null ) {
					paramVals.put("IP_FILL_PRD_UNIT", resultSet.getString("IP_FILL_PRD_UNIT"));
					setIPFillPeriodUnitForCheck(resultSet.getString("IP_FILL_PRD_UNIT"));
				}
				else {
					paramVals.put("IP_FILL_PRD_UNIT", "");
					setIPFillPeriodUnitForCheck("");
				}

				paramVals.put("IP_DELV_REQD_YN", resultSet.getString("IP_DELV_REQD_YN"));

				if (resultSet.getString("IP_FILL_EXCL_PRD_BEHIND") != null ) {
					paramVals.put("IP_FILL_EXCL_PRD_BEHIND", resultSet.getString("IP_FILL_EXCL_PRD_BEHIND"));
					setExcludeOrdersForCheck(resultSet.getString("IP_FILL_EXCL_PRD_BEHIND"));
				}
				else {
					paramVals.put("IP_FILL_EXCL_PRD_BEHIND", "");
					setExcludeOrdersForCheck("");
				}

				if (resultSet.getString("IP_FILL_DFLT_START_TIME") != null )
					paramVals.put("IP_FILL_DFLT_START_TIME", resultSet.getString("IP_FILL_DFLT_START_TIME"));
				else
					paramVals.put("IP_FILL_DFLT_START_TIME", "");
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
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return paramVals;
	}

	public boolean loadValsForModify(String dispLocnCode) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		boolean chkFacility = false ;

		try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_SELECT1" )) ;
			pstmt.setString(1, login_facility_id) ;
			resultSet = pstmt.executeQuery() ;

			if ( resultSet.next() )
				chkFacility = true ;

			if (chkFacility) {
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;

				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_SELECT2" )) ;
				resultSet = pstmt.executeQuery() ;

				while ( resultSet.next() ) {
					if (resultSet.getString("MODULE_ID").trim().equals("ST"))
						setStockModuleYN("Y");
					else if (resultSet.getString("MODULE_ID").trim().equals("IP"))
						setIPModuleYN("Y");
					else if (resultSet.getString("MODULE_ID").trim().equals("BL"))
						setBillingModuleYN("Y");
				}
			}

			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;

			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_SELECT4")) ;
			pstmt.setString(1, login_facility_id);
			pstmt.setString(2, dispLocnCode);
			pstmt.setString(3, getLanguageId());
			resultSet = pstmt.executeQuery() ;

			if ( resultSet != null ) {
				while ( resultSet.next() ) {
					setDispLocnCode(resultSet.getString("DISP_LOCN_CODE"));
					
					setStoreCode(resultSet.getString("STORE_CODE") ==null ? "": resultSet.getString("STORE_CODE"));
					setLongDesc(resultSet.getString("LONG_DESC"));
					setShortDesc(resultSet.getString("SHORT_DESC"));
					setDispLocnType(resultSet.getString("DISP_LOCN_TYPE"));
					setDispLocnCategory(resultSet.getString("DISP_LOCN_CATEGORY"));
					setEffStat(resultSet.getString("EFF_STATUS"));
					setGenDrug(resultSet.getString("DISP_GENL_DRUG_YN"));
					setNarcoDrug(resultSet.getString("DISP_NARCOTICS_DRUG_YN"));
					setControlDrug(resultSet.getString("DISP_CONTROLLED_DRUG_YN"));
					setRegistration(resultSet.getString("DISP_REGN_REQD_YN"));
					setPrintPresc(resultSet.getString("PRINT_PRES_ON_REGN_YN"));
					setIssueToken(resultSet.getString("ISSUE_TOKEN_ON_REGN_YN"));
					setFilling(resultSet.getString("DISP_FLNG_REQD_YN"));

					if (resultSet.getString("DISP_FILL_STAGE") != null )
						setFillingStage(resultSet.getString("DISP_FILL_STAGE"));
					else
						setFillingStage("");

					if (resultSet.getString("DISP_VERF_STAGE") != null )
						setPharmVerfn(resultSet.getString("DISP_VERF_STAGE"));
					else
						setPharmVerfn("");

					//if (resultSet.getString("DISP_CASH_COLL_STAGE") != null )
					//	setBillGen(resultSet.getString("DISP_CASH_COLL_STAGE"));
					//else
					//	setBillGen("");

					setDelivery(resultSet.getString("DISP_DELV_REQD_YN"));
					setPrintDispSheet(resultSet.getString("PRINT_DISP_SHEET_OP_YN"));
					setPrintBalMedSheet(resultSet.getString("PRINT_BAL_MED_SHEET_YN"));
					setMedReturn(resultSet.getString("ALLOW_DRUG_RETURN_YN"));

					if (resultSet.getString("MAX_DURN_FOR_OP_MED_RTN") != null )
						setReturnWithin(resultSet.getString("MAX_DURN_FOR_OP_MED_RTN"));
					else
						setReturnWithin("");

					if (resultSet.getString("MAX_DRUG_RETENTION_BEF_RTN") != null )
						setMaxRetPrd(resultSet.getString("MAX_DRUG_RETENTION_BEF_RTN"));
					else
						setMaxRetPrd("");

					if (resultSet.getString("PRINTER_LOCN_NAME_STAT_ORD") != null )
						setStatOrder(resultSet.getString("PRINTER_LOCN_NAME_STAT_ORD"));
					else
						setStatOrder("");

					if (resultSet.getString("PRINTER_LOCN_NAME_RTN_ORD") != null )
						setReturnOrder(resultSet.getString("PRINTER_LOCN_NAME_RTN_ORD"));
					else
						setReturnOrder("");

					setIPVerify(resultSet.getString("IP_VERF_YN"));

					if (resultSet.getString("IP_FILL_PRD_AHEAD") != null )
						setIPFillPeriod(resultSet.getString("IP_FILL_PRD_AHEAD"));
					else
						setIPFillPeriod("");

					if (resultSet.getString("IP_FILL_PRD_UNIT") != null )
						setIPFillPeriodUnit(resultSet.getString("IP_FILL_PRD_UNIT"));
					else
						setIPFillPeriodUnit("");

					setIPDelivery(resultSet.getString("IP_DELV_REQD_YN"));

					if (resultSet.getString("IP_FILL_EXCL_PRD_BEHIND") != null )
						setExcludeOrders(resultSet.getString("IP_FILL_EXCL_PRD_BEHIND"));
					else
						setExcludeOrders("");

					if (resultSet.getString("IP_FILL_DFLT_START_TIME") != null )
						setContIntermittent(resultSet.getString("IP_FILL_DFLT_START_TIME"));
					else
						setContIntermittent("");

					if (resultSet.getString("IP_PRINTER_LOCN_NAME_STAT_ORD") != null )
						setIPStatOrder(resultSet.getString("IP_PRINTER_LOCN_NAME_STAT_ORD"));
					else
						setIPStatOrder("");

					if (resultSet.getString("IP_PRINTER_LOCN_NAME_RTN_ORD") != null )
						setIPReturnOrder(resultSet.getString("IP_PRINTER_LOCN_NAME_RTN_ORD"));
					else
						setIPReturnOrder("");

					if(resultSet.getString("DISP_STAGE") != null )
						setDispStage(resultSet.getString("DISP_STAGE"));
					else
						setDispStage("");

					if(resultSet.getString("IP_ALLOC_YN") != null )
						setIPAllocYN(resultSet.getString("IP_ALLOC_YN"));
					else
						setIPAllocYN("");

					if(resultSet.getString("AUTO_DISP_AT_ADMIN_YN") != null )
						setAUTODISPATADMINYN(resultSet.getString("AUTO_DISP_AT_ADMIN_YN"));
					else
						setAUTODISPATADMINYN("");

					if(resultSet.getString("IP_ALLOW_DRUG_RETURN_YN") != null )
						setIPAllowDrugReturnYN(resultSet.getString("IP_ALLOW_DRUG_RETURN_YN"));

					if(resultSet.getString("IP_FILL_ALLOCATE_BATHCES_YN") != null )
						setIPFillBatchesYN(resultSet.getString("IP_FILL_ALLOCATE_BATHCES_YN"));

					if(resultSet.getString("ALLOW_USAGE_OF_SPIL_QTY_YN") != null )
						setIPAllowSpillUsageYN(resultSet.getString("ALLOW_USAGE_OF_SPIL_QTY_YN"));

					//if(resultSet.getString("CHARGE_QTY_IND") != null )
						//setIPChargeQtyInd(resultSet.getString("CHARGE_QTY_IND"));
					//else
						//setIPChargeQtyInd("P");
				
					if(resultSet.getString("DISP_LEVEL") != null )
						setDispLevel(resultSet.getString("DISP_LEVEL"));

					if(resultSet.getString("OP_DISP_PERIOD") != null )
						setOpDispPeriod(resultSet.getString("OP_DISP_PERIOD"));
			
					if(resultSet.getString("WORKING_HOURS_FROM") != null )
						setWorkingFrom(resultSet.getString("WORKING_HOURS_FROM"));
					else  setWorkingFrom("");

					if(resultSet.getString("WORKING_HOURS_TO") != null )
						setWorkingTo(resultSet.getString("WORKING_HOURS_TO"));
					else setWorkingTo("");

					setAdmixPrepAlwd_YN(resultSet.getString("ADMX_PREP_ALLOWED_YN"));
					setGenerateTokonReissueYN(resultSet.getString("GEN_TOKEN_UPON_REISSUE_YN"));
					
					setGenerateTokonReturnYN(resultSet.getString("GEN_TOKEN_UPON_RET_MEDN_YN"));
					setGenerateTokonDirectYN(resultSet.getString("GEN_TOKEN_UPON_DIR_DISP_YN"));
					setDirdispAllowe(resultSet.getString("DIRECT_DISP_ALLOWED_YN"));					
					setChargePatForSpillQtyYN(resultSet.getString("CHARGE_PAT_FOR_SPILL_QTY_YN"));
					setDispBillStage(resultSet.getString("DISP_BILL_STAGE"));
					setDispCashCollStage(resultSet.getString("DISP_CASH_COLL_STAGE"));
					setDispBillStageOP(resultSet.getString("DISP_BILL_STAGE_OP")); //added for SRR20056-SCF-7639
					setDispCashCollStageOP(resultSet.getString("DISP_CASH_COLL_STAGE_OP"));//added for SRR20056-SCF-7639
					setExternalPrescriptionYN(resultSet.getString("EXTERNAL_RX_ALLOWED_YN"));
					setNewPrescriptionsOnlyYN(resultSet.getString("VERIFY_REGULAR_IP_RX_YN"));
					
					if (resultSet.getString("ALLOC_DISP_SHEET_DEFAULT_YN") != null )
						setAllocDispSheetDefaultYN(resultSet.getString("ALLOC_DISP_SHEET_DEFAULT_YN"));
					else
						setAllocDispSheetDefaultYN("");

					if (resultSet.getString("ALLOC_DISP_LABEL_DEFAULT_YN") != null )
						setAllocDispLabelDefaultYN(resultSet.getString("ALLOC_DISP_LABEL_DEFAULT_YN"));
					else
						setAllocDispLabelDefaultYN("");

					if (resultSet.getString("ALLOC_DRUG_LABEL_DEFAULT_YN") != null )
						setAllocDrugLabelDefaultYN(resultSet.getString("ALLOC_DRUG_LABEL_DEFAULT_YN"));
					else
						setAllocDrugLabelDefaultYN("");

					if (resultSet.getString("DEL_DISP_SHEET_DEFAULT_YN") != null )
						setDelDispSheetDefaultYN(resultSet.getString("DEL_DISP_SHEET_DEFAULT_YN"));
					else
						setDelDispSheetDefaultYN("");

					if (resultSet.getString("DEL_DISP_LABEL_DEFAULT_YN") != null )
						setDelDispLabelDefaultYN(resultSet.getString("DEL_DISP_LABEL_DEFAULT_YN"));
					else
						setDelDispLabelDefaultYN("");

					if (resultSet.getString("DEL_DRUG_LABEL_DEFAULT_YN") != null )
						setDelDrugLabelDefaultYN(resultSet.getString("DEL_DRUG_LABEL_DEFAULT_YN"));
					else
						setDelDrugLabelDefaultYN("");


					if (resultSet.getString("IP_DSN_FROM") != null )
						setIP_SQENCE_NO_FROM((String)resultSet.getString("IP_DSN_FROM"));
					else
						setIP_SQENCE_NO_FROM("");

					if (resultSet.getString("IP_DSN_TO") != null )
						setIP_SQENCE_NO_TO((String)resultSet.getString("IP_DSN_TO"));
					else
						setIP_SQENCE_NO_TO("");
					/* added for SRR20056-CRF-0663		--START*/

					if (resultSet.getString("IP_FILL_DISP_PRD") != null )
						setIPFillDispPrd((String)resultSet.getString("IP_FILL_DISP_PRD")); 
					else
						setIPFillDispPrd(""); 

					if (resultSet.getString("IP_FILL_DISP_PRD_UNIT") != null )
						setIPFillDispPrdUnit((String)resultSet.getString("IP_FILL_DISP_PRD_UNIT")); 
					else
						setIPFillDispPrdUnit(""); 

					if (resultSet.getString("IP_DFLT_PRTY_DISP") != null )
						setIPDfltPrtyDisp((String)resultSet.getString("IP_DFLT_PRTY_DISP")); 
					else
						setIPDfltPrtyDisp(""); 
					/* added for SRR20056-CRF-0663		--END*/
					setBarcode_Scan_YN(resultSet.getString("BAR_CODE_SCAN_YN"));//Added for KDAH-CRF-0231 [IN-034551] - Barcode CRF Changes.

					if(resultSet.getString("MARK_PATIENT_ARRIVE_YN") != null )	//Added for Bru-HIMS-CRF-142 [IN:030195] -Start
						setPatArrival(resultSet.getString("MARK_PATIENT_ARRIVE_YN"));
					else 
						setPatArrival("");

					if(resultSet.getString("GENERATE_ACTUAL_TOKEN_YN") != null )
						setActualToken(resultSet.getString("GENERATE_ACTUAL_TOKEN_YN"));
					else 
						setActualToken("");
					
					if(resultSet.getString("PRINT_TOKEN_ON_LABEL_YN") != null )
						setTokenNoLabel(resultSet.getString("PRINT_TOKEN_ON_LABEL_YN"));
					else 
						setTokenNoLabel("");

					if(resultSet.getString("STORAGE_LOCN_APPL_YN") != null )
						setStorageLoc(resultSet.getString("STORAGE_LOCN_APPL_YN"));
					else 
						setStorageLoc(""); //Added for Bru-HIMS-CRF-142 [IN:030195] -End
					if(resultSet.getString("DISP_AUTH_REQD_YN") != null )   //If block added for RUT-CRF-0035 [IN029926]
						setPIN_Auth_DispMed(resultSet.getString("DISP_AUTH_REQD_YN"));
					else 
						setPIN_Auth_DispMed(""); 
					if(resultSet.getString("DEFAULT_BMS_LOCATION") != null)//Added for HSA-CRF-0113 [IN:048166] 
						setDefaultBmsLocation(resultSet.getString("DEFAULT_BMS_LOCATION"));
					else
						setDefaultBmsLocation("");
					//Added for NMC-JD-CRF-0008 start
					if(resultSet.getString("EXT_DISP_YN") != null )
						setExtDispAppYN(resultSet.getString("EXT_DISP_YN"));
					else 
						setExtDispAppYN("");
					//setInterfaceAppYN(resultSet.getString("INTERFACE_APPL_YN"));
					
					//Added for NMC-JD-CRF-0008 start
				}
			}
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			//added for crf 293.1
            String  sqlQry= "select print_disp_sheet_op_yn from ph_facility_param where facility_id = ?";
			pstmt = connection.prepareStatement( sqlQry) ;
			pstmt.setString(1, login_facility_id);
			resultSet = pstmt.executeQuery() ;
			if (resultSet != null & resultSet.next()){
				setPrintDispSheet_phparam(resultSet.getString("print_disp_sheet_op_yn"));
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
			catch(Exception es){
				es.printStackTrace();
			}
		}
		return chkFacility;
	}

	public String validateCode(String code, int mode) {
		Connection connection = null ;
		PreparedStatement pstmt = null ;
		ResultSet resultSet = null ;
		String retVal = "false" ;

		try {
			connection = getConnection() ;

			if (mode == 1) {
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_SELECT6" )) ;
				pstmt.setString(1, login_facility_id) ;
				pstmt.setString(2, code) ;
				resultSet = pstmt.executeQuery() ;

				if ( resultSet.next() )
					retVal = "true" ;
			}
			else if (mode == 2) {
				pstmt = connection.prepareStatement( PhRepository.getPhKeyValue( "SQL_PH_DISP_LOCN_SELECT9" )) ;
				pstmt.setString(1, code) ;
				pstmt.setString(2, getLanguageId()) ;
				pstmt.setString(3, login_facility_id) ;
				resultSet = pstmt.executeQuery() ;

				if ( resultSet.next() )
					retVal = resultSet.getString("SHORT_DESC") + "|" + resultSet.getString("LONG_DESC");
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
			catch(Exception es) 
			{
			System.err.println("Error while closing statements and resultsets"+es.toString());  es.printStackTrace();
			}
		}
		return retVal;
	}

	// Raghunath
	// We are getting the Dispense Stages (Legends) from PH_PARAM Table....
	public Hashtable getLegendsFromParam()throws Exception {
		Hashtable param_legends = new Hashtable();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT35") ) ;
			pstmt.setString(1,getLanguageId());
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				param_legends.put("V",resultSet.getString("VERIFY_STAGE_PROMPT"));
				param_legends.put("A",resultSet.getString("ALLOCATE_STAGE_PROMPT"));
				param_legends.put("F",resultSet.getString("FILL_STAGE_PROMPT"));
				param_legends.put("B",resultSet.getString("BILL_RECEIPT_STAGE_PROMPT"));
				param_legends.put("D",resultSet.getString("DELIVER_STAGE_PROMPT"));
				param_legends.put("R",resultSet.getString("REGN_STAGE_PROMPT"));
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) {
				es.printStackTrace();
			}
        }
		return param_legends;
	}

	public String getDirdispYN()throws Exception {
		String param_legends = "";
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		 pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_DIRDISP_SELECT") ) ;
		 //   pstmt = connection.prepareStatement("Select DIR_DISP_ALLOWED from ph_facility_param where facility_id = ? ") ;
			pstmt.setString(1,getLoggedInFacility());
			
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				param_legends=resultSet.getString("DIR_DISP_ALLOWED");
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
				es.printStackTrace();
			}
        }
		return param_legends;
	}

	public String getRemarksDescription(String remarks)throws Exception {
		String param_legends = "";
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_REASON_REMARKS") ) ;
			pstmt.setString(1,remarks);
			pstmt.setString(2,"BR");
			pstmt.setString(3,getLanguageId());
			
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				param_legends=resultSet.getString("REMARKS");
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) {
				es.printStackTrace();
			}
        }
		return param_legends;
	}

	public ArrayList getBMSRemarksDescription(String remarks)throws Exception {
		ArrayList param_legends =new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_LOCN_SELECT12") ) ;
			pstmt.setString(1,getLoggedInFacility());
			pstmt.setString(2,remarks);
			pstmt.setString(3,getLanguageId());
			
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {

			/*	if(resultSet.getString("BMS_REMARKS_CODE") != null )
						setDisplocRemarks(resultSet.getString("BMS_REMARKS_CODE"));
					else setDisplocRemarks("");
					if(resultSet.getString("REASON_DESC") != null )
						setDispRemarksDesc(resultSet.getString("REASON_DESC"));
					else setDispRemarksDesc("");
				if(resultSet.getString("REMARKS") != null )
						setDisplocRemarksDesc(resultSet.getString("REMARKS"));
					else setDisplocRemarksDesc(""); */
				this.remarks_code=resultSet.getString("BMS_REMARKS_CODE");
				param_legends.add(resultSet.getString("BMS_REMARKS_CODE"));
				param_legends.add(resultSet.getString("REASON_DESC"));
				param_legends.add(resultSet.getString("REMARKS"));
		
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
				es.printStackTrace();
			}
        }
		return param_legends;
	}

	public ArrayList getDailySpecificRange()throws Exception {
		ArrayList view_ranges =new ArrayList();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("select SHORT_DESC, IP_DSN_FROM,IP_DSN_TO,DISP_LOCN_CODE from PH_DISP_LOCN where FACILITY_ID = ? and IP_DSN_TO is not null ") ;
			pstmt.setString(1,getLoggedInFacility());

			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
			view_ranges.add(resultSet.getString("SHORT_DESC"));
			view_ranges.add(resultSet.getString("IP_DSN_FROM"));
			view_ranges.add(resultSet.getString("IP_DSN_TO"));
			view_ranges.add(resultSet.getString("DISP_LOCN_CODE"));
		
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) {
				es.printStackTrace();
			}
        }
		return view_ranges;
	}

	public String getDailySpecificRangeYN()throws Exception {
		String Daily_Specific_rangeYN=null;
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
			pstmt = connection.prepareStatement("SELECT IP_DSN_YN FROM PH_FACILITY_PARAM WHERE FACILITY_ID =?") ;
			pstmt.setString(1,getLoggedInFacility());

			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
			Daily_Specific_rangeYN=resultSet.getString("IP_DSN_YN");
		
			}
        }
        catch ( Exception e ) {
            e.printStackTrace() ;
            throw e ;
        }
        finally {
            try {
                closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;
                closeConnection( connection );
            }
            catch(Exception es) { 
				es.printStackTrace();
			}
        }
		return Daily_Specific_rangeYN;
	}

	public boolean getRangeOverlapValidate(ArrayList range_list,int from,int to,String disp_loc_code_modify){
		String temp_from="";
		String temp_to="";
		String temp_disp_locn="";
		int list_from;
		int list_to;
		boolean t_range = false;
	
        for(int i=0;i<range_list.size();i+=4){
			boolean range_flag[] = {false,false,false,false};
			temp_from=(String)range_list.get(i+1);
			temp_to =(String)range_list.get(i+2);
			temp_disp_locn =(String)range_list.get(i+3);
			list_from=Integer.parseInt(temp_from);
			list_to=Integer.parseInt(temp_to);

			if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) ){
				if(!disp_loc_code_modify.equals(temp_disp_locn)){
						
					range_flag[0]= getChk_range(list_from,list_to,from);
					range_flag[1] = getChk_range(list_from,list_to,to);
					range_flag[2]= getChk_range(from,to,list_from);
					range_flag[3] = getChk_range(from,to,list_to);
					if(range_flag[0]==true||range_flag[1] ==true ||range_flag[2]== true||range_flag[3]==true){
						t_range =  true;
						break;
					}
				}
			}
			else{
				range_flag[0]= getChk_range(list_from,list_to,from);
				range_flag[1] = getChk_range(list_from,list_to,to);
				range_flag[2]= getChk_range(from,to,list_from);
				range_flag[3] = getChk_range(from,to,list_to);

				if(range_flag[0]==true||range_flag[1] ==true ||range_flag[2]== true||range_flag[3]==true){
					t_range =  true;
					break;
				}
			}
		}
		return t_range;
	}

	public boolean getChk_range(int list_from,int list_to,int no){
		if(no >= list_from && no <= list_to){
			return true;
		}
		else{
			return false;
		}
	}

// added for the CRF 293.1
	public void  setOnlinePrintDetails(String facility_id, String disp_locn_code){
	   	
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
		//int count = 0;  Removed for IN063877
		String sqlQuery ="SELECT REPORT_ID,PATIENT_CLASS,DISP_STAGE,PRINT_STATUS,DISPLAY_ORDER,EFF_STATUS from PH_DISP_LOCN_PRN_OPTION WHERE EFF_STATUS='E' and FACILITY_ID=? and DISP_LOCN_CODE =? ORDER BY REPORT_ID,DISPLAY_ORDER";

		hmRow		  = new HashMap();
		hmRow.clear();
		HashMap hmCol = null;
		String rowKey =	"";
		String colKey = "";

		try { 
			connection = getConnection() ;
			pstmt = connection.prepareStatement(sqlQuery) ;
			pstmt.setString(1,facility_id);
			pstmt.setString(2,disp_locn_code);
			resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
				//count =1; //Commented for  [IN:051565]
				rowKey = resultSet.getString("REPORT_ID");
				if(hmRow.containsKey(rowKey)) //Added for  [IN:051565] -start
					hmCol =(HashMap)hmRow.get(rowKey);
				else
					hmCol = new HashMap(); //added for  [IN:051565] -end

				colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
				hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
				/*if(resultSet.next()){ //Commented for  [IN:051565] -start
					colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
					hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
				}
				if(resultSet.next()){
					colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
					hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
				}
				if(resultSet.next()){
					colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
					hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
				}
				if(resultSet.next()){
					colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
					hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
				}

				if(resultSet.next()){
					colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
					hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
				}
				if(resultSet.next()){
					colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
					hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
				}

				if(resultSet.next()){
					colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
					hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
				}

				if(resultSet.next()){
					colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
					hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
				}*/ //commented fro  [IN:051565] -end
				hmRow.put(rowKey,hmCol);
			}
			//if (count == 0){//commented for  [IN:051565]
				closeResultSet( resultSet ) ;
				closeStatement( pstmt ) ;
               
				String sqlQuery1 ="SELECT REPORT_ID,PATIENT_CLASS,DISP_STAGE,PRINT_STATUS,DISPLAY_ORDER,EFF_STATUS from PH_DISP_PRN_OPTION WHERE EFF_STATUS='E' ORDER BY REPORT_ID,DISPLAY_ORDER";
				pstmt = connection.prepareStatement(sqlQuery1) ;

    			resultSet =  pstmt.executeQuery() ;
				while ( resultSet != null && resultSet.next() ) {
					//hmCol = new HashMap();
					rowKey = resultSet.getString("REPORT_ID");
					colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");

					if(hmRow.containsKey(rowKey))//added for  [IN:051565] -start
						hmCol =(HashMap)hmRow.get(rowKey);
					else
						hmCol = new HashMap();
					if(!hmCol.containsKey(colKey)){
						hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
						hmRow.put(rowKey,hmCol);
					} //added fro  [IN:051565] -end
				/*	if(resultSet.next()){ //Commented for  [IN:051565] -start
						colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
						hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
					}

					if(resultSet.next()){
						colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
						hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
					}

					if(resultSet.next()){
						colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
						hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
					}

					if(resultSet.next()){
						colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
						hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
					}
					if(resultSet.next()){
						colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
						hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
					}
					if(resultSet.next()){
						colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
						hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
					}
					if(resultSet.next()){
						colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
						hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
					}

					if(resultSet.next()){
						colKey = resultSet.getString("PATIENT_CLASS")+"_"+resultSet.getString("DISP_STAGE");
						hmCol.put(colKey,resultSet.getString("PRINT_STATUS"));
					}
					hmRow.put(rowKey,hmCol);	*/ //commented for  [IN:051565] -end
				}
			//} // commented for  [IN:051565]
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
            catch(Exception es){
				es.printStackTrace();
			}
        }	
		setOnlinePrintSetupMap(hmRow);	
	}
	//Added for HSA-CRF-0113 [IN:048166] 
	public ArrayList getDispenseLocns() throws Exception {
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		String	disp_locn_code	=	"";
		String disp_locn_desc   =	"";
		 
		ArrayList displocns		=	new ArrayList();
		try {

            connection	= getConnection() ;
            pstmt		= connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_PRINT_DIALOG_SELECT")) ;

			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,getLanguageId());
			resultSet	= pstmt.executeQuery() ;
			while(resultSet.next()){
				disp_locn_code				=	checkForNull(resultSet.getString("DISP_LOCN_CODE"));//DISP_LOCN_CODE
				disp_locn_desc		=	checkForNull(resultSet.getString("SHORT_DESC"));//SHORT_DESC
				
				displocns.add(disp_locn_code);
				displocns.add(disp_locn_desc);
			}
		}
		catch ( Exception e ) {
			e.printStackTrace() ;
		}
		finally {
			closeResultSet( resultSet ) ;
			closeStatement( pstmt ) ;
			closeConnection( connection ); 
		}	
		return displocns;
	}
	
	}
