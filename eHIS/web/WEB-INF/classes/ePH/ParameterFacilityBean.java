/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/ 
 /*  
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
20/02/2018      ML-BRU-CRF-0473  Chandra      Need to allow Zero Allocated drugs for In Patients. 
25/04/2016	    IN067051         Devindra	  Enhance TPN Ordering Functionality
04/01/2019	    IN068345         Prathyusha	  Required changes in item substitute mapping set up
07/03/2019	    IN069337         Haribabu	  Need to show Generic name in drug search lookup
05/07/2019	IN070605     prathyusha	          It is recommended that the pharmacy implement the appropriate automated drug interaction alerts to the physician at the point of order entry and/or to the pharmacist at the point of second line validation of medication orders.
31/01/2020	    IN071362         Manickavasagam	   AAKH-CRF-0117
10/11/2020		6041			 Shazana       NMC-JD-CRF-0063
01/12/2020  	IN8219           Prabha	  	 12/01/2020	 	 Manickavasagam J          MMS-DM-CRF-0177
12/02/2021		TFS-14326        Prabha      12/02/2021		 Manickavasagam J		   PH-PMG2020-COMN-CRF-0031-US001/06 - PH Parameter for Facility Error
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
08/06/2021  	TFS id:-19371    Manickavasagam J          								ML-MMOH-CRF-1637
01/04/2024		TFS id:	34792     Yogesh      01/04/2023      RAmesh                    NMC-JD-CRF-0186                                        		 													   ML-MMOH-CRF-1755
03/05/2023		TFS id:	43081															   ML-MMOH-CRF-1823
22/05/2023      TFS id:-44841  Ayesha 		22/05/2023        Mohamed Suhail     MMS-DM-CRF-0233		PH parameter for facility
---------------------------------------------------------------------------------------------------------------
*/ 
 //saved on 08/11/2005
package ePH ;
import java.io.* ;
import java.util.* ;
import java.sql.* ;
import webbeans.eCommon.*; // Added for GHL-CRF-0412.3
import javax.servlet.http.HttpServletRequest; // Added for GHL-CRF-0412.3
//import javax.rmi.PortableRemoteObject ;
//import javax.naming.InitialContext ;
import ePH.Common.* ;
import eCommon.Common.* ;
import eCommon.SingleTableHandler.*;

public class ParameterFacilityBean extends PhAdapter implements Serializable {

    protected String facility_id                   ="";
    protected String interface_to_st_yn            ="N";
    protected String pat_instr_loc_lang_yn         ="N";
    protected String consider_stock_for_pres_yn    ="N";
    protected String allow_pres_without_stock_yn   ="N";

    protected String refill_yn                     ="N";
    protected String max_refills_for_pres          ="0";
    protected String print_refill_pres_with_main_yn="N";
    protected String split_based_priority_yn="N";
    protected String split_based_drug_class_yn="N";
    protected String max_durn_for_refill_pres      ="0";
    protected String disp_before_start_date_yn     ="N";

    protected String disp_before_no_of_days        ="0";
    protected String disp_beyond_earliest_start_yn ="N";
    protected String disp_beyond_no_of_days        ="0";
    protected String disp_regn_reqd_yn             ="N";
    protected String ip_daily_seq_no_yn             ="N";
    protected String disp_flng_reqd_yn             ="N";
    protected String disp_delv_reqd_yn             ="N";
   // protected String disp_cash_coll_stage          ="X";
    protected String print_disp_sheet_op_yn        ="N";
    protected String dflt_lang_for_disp_label      =""; //changed "E" - > "" for MMS-QH-CRF-0069 [IN:037977]

    protected String label_format_op               ="";
    protected String allow_drug_return_yn          ="N";
    protected String max_drug_retention_bef_rtn    ="0";
    protected String max_durn_for_op_med_rtn       ="0";
    protected String ip_verf_yn                    ="N";
    protected String ip_fill_prd_ahead             ="0";
    protected String ip_fill_excl_prd_behind       ="0";
    protected String ip_delv_reqd_yn               ="N";
    protected String ip_fill_dflt_start_time       ="";
    protected String dflt_lang_for_disp_label_ip   =""; //changed "E" - > "" for MMS-QH-CRF-0069 [IN:037977]
    protected String ip_label_format               ="";
    protected String ip_disp_locn_rtn_ord          ="";
    protected String ip_disp_locn_stat_ord         ="";
    protected String interface_to_bl_yn            ="N";
    protected String verf_yn                       ="N";
	protected String op_disp_locn_rtn_ord		   ="";
	protected String op_disp_locn_stat_ord		   ="";
	protected String disch_med_disp_locn		   ="";
	protected String print_bal_med_sheet_op_yn	   ="N";
	protected String disp_verf_stage			   ="";
//	protected String ip_disp_loc_stat_ord		   ="";
//	protected String ip_disp_loc_rtn_ord		   ="";
	protected String ip_fill_prd_unit			   ="H";
	protected String disp_fill_stage			   ="X";

	//protected String allow_usage_of_spil_qty_yn ="N";
	//protected String charge_qty_ind				="";
	protected String med_admin_reqd_yn			="";
	protected String verf_reqd_bef_med_admin_yn ="N";
	protected String rec_admin_within_hrs		="";
	protected String allow_med_admin_wo_ord_yn	="N";
	protected String ip_consider_stock			="N";
	protected String ip_allow_stock				="N";
	protected String allow_duplicate_drug		="N";
	//IN30118-SCF No: MO-GN-5400. Initiating For OutPatient Duplicate Drug Check.
	protected String allow_duplicate_drug_op	="N";
	//added on 24/04/2004
	protected String allow_medn_order_without_diag  ="N";
    protected String allow_medn_order_without_wt    ="N";
	protected String allow_medn_ord_without_diag_dd  ="N";//added for CRF MMS-QH-CRF-0068 [IN:037980]

	//code added for unallocated orders...on 29/4/2004
	protected String unalloc_order_del_st		=	"N";
	protected String print_exp_date_on_lbl		=	"N";
	protected String duplicate_check_atc        =   "N";
	protected String remarks_for_prn			=   "N";

	protected	String display_charge_details_lkp = "";
	protected	String display_charge_details_prescription = "";
	protected	String display_price_type_lkp = "";

	protected String iv_admixture_appl_yn		=	"N";
	protected String cdr_admixture_appl_yn		=	"N";
	protected String tpn_regimen_appl_yn		=	"N";
	protected String admx_prep_charges_appl_yn	=	"N";
	protected String working_hours_room_from		=	"";
	protected String working_hours_room_to		    =	"";
	protected String alert_practitioner_yn		=	"N";
	protected String verify_tdm_order_yn		=	"N";
	protected String tdm_reporting_id		=	"";
	protected String pat_couns_reporting_id ="";
	protected String start_adr_no		=	"";
	protected String last_adr_no        =   "";
//	protected String patient_class = "";
    protected String encounter_details_required ="";
    protected String direct_dispensing_allowed = "";
	protected String consider_last = "";
    protected String applicable_encounter ="";
	protected String patientclass= "";

	protected String comp_rx_appl_yn	 = "Y";
    protected String iv_rx_appl_yn		 = "Y";
	protected String oncology_rx_appl_yn = "Y";
    protected String tpn_rx_appl_yn		 = "Y";
	protected String tdm_appl_yn		 = "Y";
	protected String tdm_result_type		 = "";
	protected String pat_couns_result_type	 = "";
   
	protected String drug_db_alergycheck_yn="";
	protected String drug_db_contracheck_yn="";
	protected String drug_db_interaction_yn="";
	protected String drug_db_duptherapy_yn="";
	protected String drug_db_dosecheck_yn="";
	protected String drug_db_interface_name="";
	protected String drug_db_interface_yn="";
    //protected String 
	protected String inpatient_yn			= "";
	protected String Outpatient_yn			= "";
	protected String Daycare_yn			    = "";
	protected String emergency_yn			= "";
	protected String Disch_Med_Mar_Appl_yn	= "";	
	protected String inpatient_yn_rule_check		= "";
	protected String outpatient_yn_rule_check		= "";
	protected String daycare_yn_rule_check		    = "";
	protected String emergency_yn_rule_check		= "";
	protected String dischmedic_yn_rule_check	= "";
	protected String dflt_dir_disp_locn				=	"";	
	protected String dflt_ext_rx_disp_locn				=	"";	
	protected String tpn_screening_type				=	"";	
	protected String tpn_reporting_id					=	"";
	protected String oncology_screening_type			=	"";
	protected String onc_reporting_id					=	"";
	protected String drug_cat_pin_auth_reqd_yn			=	"";
	protected String allow_short_expiry_drugs_yn		=	"N";
	protected String copy_pres_upto_no_of_days			=	"";//for copy prescriptions
	protected String include_zero_allocated_items_in_dispensing  ="N"; //added for INCLUDE ZERO ALLOC ITEMS on 07-03-09
	protected String rec_admin_bef_schdle_time			=	"";
	protected String rec_admin_bef_schdle_time_UOM		=	"";
	protected String allow_disp_record_lock_yn			=	"N";//Added for CRF-0439  To add dispensing locking facility
	protected String promptAlertForPreferredItem		=	"N";//Added for CRF-711 --INC 12669
	protected String defaultPrivilegeDrugSelection		=	"";//Added for CRF-641
	protected String display_uom_transaction_by		=	"";//Added for CRF-749 --Display the UOM in Transactions By code or Description
	//Added for CRF-713 INC 12785
	protected String narcotic_aprvl_form_req_yn		=   "";
	protected String print_narcotic_form_by_default    =   "";
	protected String edit_disp_label_after_del = ""; // Added for BSP30453-CRF-0047 to edit dispensing label after dispense/delivery stage
	protected String rx_qty_by_pres_base_uom_yn = "N"; // Added on 7Dec-09  new label Prescribe Quantity by Prescribing Unit
	protected String dflt_ip_fill_incr_start_with = ""; // Added for PMG20089-CRF-0675 to default the start time for Incremental IP Fill Process
	protected String atc_allergy_alert_level = ""; 
	protected String tab_based_group_sort_disp = ""; 
	protected String discont_canc_dup_medic = "";   //added for Bru-HIMS-CRF-265 [IN:032315]
	protected String disp_exp_orders_yn = "";   //added for ML-BRU-SCF-0636 [IN036826]
	protected String pin_auth_mar_yn = "";   //added for RUT-CRF-0035 [IN029926]
	protected String print_mar_label_yn = "";   //added for  MMS-QH-CRF-0080 [IN:038064]
	protected String alt_drug_remarks_ind = "";   //added for Bru-HIMS-CRF-082 [IN:029948]
	protected String mar_sch_level_yn = "N";   //added for SKR-CRF-0037 [IN:037656] -START
	protected String mar_start_ind = "S";   
	protected String mar_week_day_start = "0";   //Zero
	protected String mar_past_day = "";   
	protected String mar_future_day = "";   
	protected String mar_default_order_by = "O";   
	protected String mar_disc_dose_yn = "N";   
	protected String mar_iv_compl_dt_ind = "I";   //added for Bru-HIMS-CRF-082 [IN:029948] -eND
	protected String allergy_conf_reqd_yn = "N";  //added for RUT-CRF-0064.1 [IN:041799]
	protected String mar_disp_held_disc_orders_yn = "Y"; //added for [IN:043283]
	protected String witness_for_verbal_order_yn ="N"; 	// Added for AAKH-CRF-0023[IN:038259]
	protected String disp_before_start_date_yn_ip    ="N"; //added for AMS-CRF-0009[IN:030935]  -start
	protected String disp_before_no_of_days_ip        ="0";
	protected String disp_beyond_earliest_start_yn_ip ="N"; 
	protected String disp_beyond_no_of_days_ip        ="0";//added for AMS-CRF-0009[IN:030935]  -end
	protected String strDefaultFreqforIV = "";	//Added for Bru-HIMS-CRF-384[IN041642]
	protected String em_medctn_fwd_ip_yn = "N";	//Added for Bru-HIMS-CRF-402[IN044065]
	protected String cary_frwd_ord_nofhrs = "";	//Added for Bru-HIMS-CRF-402[IN044065]
	protected String disp_rx_duration_yn = "";	//Added for Bru-HIMS-CRF-403[IN044541]
	protected String diag_for_medn_order_by = "P";	//Added for  MMS-SCF-0325 [IN:048069]
	protected String allow_mar_share_drug_yn = "N";	//added for HSA-CRF-0090 [IN:041241]
	protected String allow_renew_from_chart_summ_yn = "";//Added for Bru-HIMS-CRF-400
	protected String can_discon_dup_orders_def_sel = "";//Added for HSA-CRF-0151 [IN048468]
	protected String allow_auto_disp_alt_drug_mar = "N";//Added for Bru-HIMS-CRF-399 [IN:043767]
	protected String mar_disp_unbilled_med_yn="N";  //Added for NMC-JD-CRF-0186      <!-- 42911 -->
	protected String preview_rx_yn = "N";//Added for ML-MMOH-CRF-0341 [IN:057179]
	protected String disp_prev_vital_signs_yn = "N";//Added for ML-MMOH-CRF-0346 [IN:057185]
	protected String generic_name="";//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
	protected String generic_code="";//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
	private String working_hrs_from				= "";//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
	private String working_hrs_to				= "";//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
	private String allow_amend_alt_drug_dtl="N";//Allow_Amd_Alt_DRug_Dt Added by prathyusha for JD-CRF-198 on 05/05/2016
	private String skip_duplicate_alert_ip="N";// Added for MO-CRF-20085.1  By Prathyusha on 05/18/2016
	private String skip_duplicate_alert_op="N";// Added for MO-CRF-20085.1  By Prathyusha on 05/18/2016
	private String  overlap_period_for_op="";//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 
	private String  overlap_period_for_ip="";//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 
	private String  ret_medic_restr_stage="N"; // Added for GHL-CRF-0412.3
	protected String split_drug_based_auth_yn="N";//added for ml-mmoh-crf-0864
	protected String include_ip_zero_allocated_drugs_for_dispense="N";//Added for ML-BRU-CRF-0473
	protected String assesment_req_yn ="N"; // Added for ML-MMOH-CRF-1126
	protected String late_or_early_admin ="N"; // Added for GHL-CRF-0482 [IN:064955]
	protected String allow_alternate_for_medical_item_yn="N";// Added for GHL-CRF-0548
	protected String ward_ack_required_yn="";//added forMMS-KH-CRF-0014
	protected String ward_ack_mar_required_yn="";//added forMMS-KH-CRF-0014
	protected String display_generic_name_yn="N";// Added for NMC-JD-CRF-0001 
	protected String reconciliation_ip="N";//ADDED FOR MMS-KH-CRF-0016
	protected   String review_aprrove_applicable_for_ip = "N";   //added for  MMS-KH-CRF-0028
	protected	String review_aprrove_applicable_for_op = "N";   //added for  MMS-KH-CRF-0028
	
	protected String approval_no_yn_ip = "N";   //Added for AAKH-CRF-0117
	protected String approval_no_yn_op = "N";   //Added for AAKH-CRF-0117
	protected String op_disch_med_disp_locn = "";//added for 6041
	
	//Added for MMS-DM-CRF-0177
	
	protected String pre_alloc_appl_yn = "N";
	protected String near_expiry_appl_yn = "E";
	protected String durn_value = ""; 
	protected String durn_type = "N";
	protected String durn_value_in_days = "";
	protected String default_disp_locn = "";//Added for TFS id:-16341
	protected String pat_trans_phar_type = "";//added for ML-MMOH-CRF-1637
	protected String pat_trans_other_type = "";//added for ML-MMOH-CRF-1637
	protected  String drug_indication_mdry="";//added for jd-crf-0220
	protected String disp_auto_refresh = "";//Added for TH-KW-CRF-0011
	protected String display_verif_drug_inst_remarks_yn = "N";//added for ML-MMOH-CRF-1755
	//protected String Amend_ordeiag_ind_pre_rep_yn = "N"; //ML-BRU-CRF-0630
	protected String Amend_orderwise_DispMedication_yn="";//added for ml-mmoh-crf-1748
	protected String do_not_display_sensitive_diagnosis_yn = "N";  //ML-BRU-CRF-0630
	protected String disp_sens_diag_ind_pre_rep_yn = "N";  //ML-BRU-CRF-0630

	
	protected String quota_limit_calculation_required_yn = "N";  //added for ML-MMOH-CRF-1823	
	protected String active_prescription_enabled_for_quota_limit_yn = "N";  //added for ML-MMOH-CRF-1823	
	protected String always_display_dispense_location_yn = "N";  //added for NMC-JD-CRF-0197	
	
	 //Added for MMS-CRF-0233 by Ayesha Khan
	  protected String print_footer_dtls_pres_yn                     ="N"; 
	  protected String print_pres_dtl_en               =""; 
	  protected String print_pres_dtl_loc               =""; 
	  //Ended for MMS-CRF-0233 by Ayesha Khan
	
	//Added for MMS-DM-CRF-0177
	
	public ParameterFacilityBean() {
        try {
            doCommon();
        }
        catch(Exception e) {}
    }
    //Over-ridden Adapter methods start here
    public void clear() {
        super.clear() ;
    }

    private void doCommon() throws Exception {
    }
	//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016 starts
    public void setGeneric_Name(String generic_name) {
		 this.generic_name = checkForNull(generic_name);
	}
	public String getGeneric_Name() {
		 return generic_name;
	}
	public void setGeneric_Code(String generic_code) {
		 this.generic_code = checkForNull(generic_code);
	}
	public String getGeneric_Code() {
		 return generic_code;
	}
	public void setWorkingFrom(String working_hrs_from) {
		this.working_hrs_from = working_hrs_from;
	}
	public void setWorkingTo(String working_hrs_to) {
		this.working_hrs_to = working_hrs_to;
	}
	public String getWorkingFrom() {
		return this.working_hrs_from;
	}
	public String getWorkingTo() {
		return this.working_hrs_to;
	}
	//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016 ends
    public void setAll( Hashtable recordSet ) {
		if(recordSet.containsKey("DFLT_DIR_DISP_LOCN")){
			dflt_dir_disp_locn=(String)recordSet.get("DFLT_DIR_DISP_LOCN");
		}
		if(recordSet.containsKey("DFLT_EXT_RX_DISP_LOCN")){
			dflt_ext_rx_disp_locn=(String)recordSet.get("DFLT_EXT_RX_DISP_LOCN");
		}
		if (recordSet.containsKey("direct_dispensing_allowed")){	
			direct_dispensing_allowed = (String)recordSet.get("direct_dispensing_allowed");
			if (direct_dispensing_allowed == null || direct_dispensing_allowed.equals("")){
				direct_dispensing_allowed = "N";
			}
			else if(direct_dispensing_allowed == "Y"){
				direct_dispensing_allowed =direct_dispensing_allowed ;
			} 
		}

		if(direct_dispensing_allowed.equals("Y")){
	 		if (recordSet.containsKey("Encounter_details_required")){
				encounter_details_required = (String)recordSet.get("Encounter_details_required");
				if(encounter_details_required == null || encounter_details_required.equals("")){
					encounter_details_required = "N";
				}
			}
			if (recordSet.containsKey("flag")){   
				applicable_encounter = (String)recordSet.get("flag");
				if (applicable_encounter == null || applicable_encounter.equals(""))
					applicable_encounter="B";
				else 
					applicable_encounter = applicable_encounter;
			}
			if (recordSet.containsKey("Consider_last")){
				consider_last =(String)recordSet.get("Consider_last");
			}
			if(recordSet.containsKey("flag1")){
				patientclass= (String)recordSet.get("flag1");
				if(patientclass == null || patientclass.equals(""))
					patientclass = "B";
				else 
					patientclass=patientclass;
			}
		}        
		if(direct_dispensing_allowed.equals("N"))	{
		
			encounter_details_required = (String)recordSet.get("Encounter_details_required");
			encounter_details_required = "";
			patientclass= (String)recordSet.get("flag1");
			patientclass = "";
			consider_last =(String)recordSet.get("Consider_last");
			consider_last = "";
			applicable_encounter = (String)recordSet.get("flag");
			applicable_encounter= "";
		} 
		
		if(recordSet.containsKey("facility_id") ){
			facility_id = (String)recordSet.get("facility_id") ;
			if (facility_id == null){
                facility_id=""; 
            }
        }
		if(recordSet.containsKey("interface_to_st_yn") ){
            interface_to_st_yn = (String)recordSet.get("interface_to_st_yn");
            if (interface_to_st_yn == null || interface_to_st_yn.equals("")){
                interface_to_st_yn  = "N";
            }
        }
        if(recordSet.containsKey("pat_instr_loc_lang_yn")){
            pat_instr_loc_lang_yn = (String)recordSet.get("pat_instr_loc_lang_yn") ;
            if (pat_instr_loc_lang_yn==null || pat_instr_loc_lang_yn.equals("")){
                pat_instr_loc_lang_yn   = "N";
            }
        }
        if(recordSet.containsKey("consider_stock_for_pres_yn")){
            consider_stock_for_pres_yn = (String)recordSet.get("consider_stock_for_pres_yn") ;
            if (consider_stock_for_pres_yn ==null || consider_stock_for_pres_yn.equals("")){
                consider_stock_for_pres_yn  = "N";
            }
        }
        if(recordSet.containsKey("allow_pres_without_stock_yn")){
            allow_pres_without_stock_yn = (String)recordSet.get("allow_pres_without_stock_yn");
            if (allow_pres_without_stock_yn == null || allow_pres_without_stock_yn.equals("")){
                allow_pres_without_stock_yn = "N";
            }
        }
        if(recordSet.containsKey("refill_yn") ){
            refill_yn = (String)recordSet.get("refill_yn") ;
            if (refill_yn == null || refill_yn.equals("")){
                refill_yn   = "N";
            }
        }
        if(recordSet.containsKey("max_refills_for_pres") ){
            max_refills_for_pres = (String)recordSet.get("max_refills_for_pres");
            if (max_refills_for_pres==null){
                max_refills_for_pres="";
            }
        }
        if(recordSet.containsKey("print_refill_pres_with_main_yn")){
            print_refill_pres_with_main_yn = (String)recordSet.get("print_refill_pres_with_main_yn");
            if (print_refill_pres_with_main_yn == null || print_refill_pres_with_main_yn.equals("")){
                print_refill_pres_with_main_yn  = "N";
            }
        }
		
		if(recordSet.containsKey("split_based_priority_yn")){
            split_based_priority_yn = (String)recordSet.get("split_based_priority_yn");
            if (split_based_priority_yn == null || split_based_priority_yn.equals("")){
                split_based_priority_yn  = "N";
            }
        }  
		if(recordSet.containsKey("split_based_drug_class_yn")){
            split_based_drug_class_yn = (String)recordSet.get("split_based_drug_class_yn");
            if (split_based_drug_class_yn == null || split_based_drug_class_yn.equals("")){
                split_based_drug_class_yn  = "N";
            }
        }
        if(recordSet.containsKey("max_durn_for_refill_pres")){
            max_durn_for_refill_pres = (String)recordSet.get("max_durn_for_refill_pres") ;
            if (max_durn_for_refill_pres==null){
                max_durn_for_refill_pres="";
            }
        }
        if(recordSet.containsKey("disp_before_start_date_yn") ){
            disp_before_start_date_yn = (String)recordSet.get("disp_before_start_date_yn") ;
            if (disp_before_start_date_yn == null || disp_before_start_date_yn.equals("")){
                disp_before_start_date_yn   = "N";
            }
        }

        if(recordSet.containsKey("disp_before_no_of_days")){
            disp_before_no_of_days = (String)recordSet.get("disp_before_no_of_days");
            if (disp_before_no_of_days == null){
                disp_before_no_of_days = "";
            }
        }
        if(recordSet.containsKey("disp_beyond_earliest_start_yn")){
            disp_beyond_earliest_start_yn = (String)recordSet.get("disp_beyond_earliest_start_yn");
            if (disp_beyond_earliest_start_yn == null || disp_beyond_earliest_start_yn.equals("")){
                disp_beyond_earliest_start_yn   = "N";
            }
        }
        if(recordSet.containsKey("disp_beyond_no_of_days")){
            disp_beyond_no_of_days = (String)recordSet.get("disp_beyond_no_of_days");
            if (disp_beyond_no_of_days==null){
                disp_beyond_no_of_days = "";
            }
        }
        if(recordSet.containsKey("disp_regn_reqd_yn")){
            disp_regn_reqd_yn = (String)recordSet.get("disp_regn_reqd_yn") ;
            if (disp_regn_reqd_yn==null || disp_regn_reqd_yn.equals("")){
                disp_regn_reqd_yn   = "N";
            }
        }
		if(recordSet.containsKey("ip_daily_seq_no_yn")){
			
            ip_daily_seq_no_yn = (String)recordSet.get("ip_daily_seq_no_yn") ;
			
            if (ip_daily_seq_no_yn==null || ip_daily_seq_no_yn.equals("")){
                ip_daily_seq_no_yn   = "N";
            }
        }

        if(recordSet.containsKey("disp_flng_reqd_yn")){
            disp_flng_reqd_yn = (String)recordSet.get("disp_flng_reqd_yn") ;
            if (disp_flng_reqd_yn==null || disp_flng_reqd_yn.equals("")){
                disp_flng_reqd_yn   = "N";
            }
        }
		if(recordSet.containsKey("disp_fill_stage")){
            disp_fill_stage = (String)recordSet.get("disp_fill_stage") ;
        }
        if(recordSet.containsKey("disp_delv_reqd_yn")){
            disp_delv_reqd_yn = (String)recordSet.get("disp_delv_reqd_yn");
            if (disp_delv_reqd_yn==null || disp_delv_reqd_yn.equals("")){
                disp_delv_reqd_yn   = "N";
            }
        }
        /*
		if(recordSet.containsKey("disp_cash_coll_stage")){
            disp_cash_coll_stage = (String)recordSet.get("disp_cash_coll_stage");
            if (disp_cash_coll_stage==null){
                disp_cash_coll_stage="X";
            }
        }
		*/

        if(recordSet.containsKey("print_disp_sheet_op_yn")){
            print_disp_sheet_op_yn = (String)recordSet.get("print_disp_sheet_op_yn");
            if (print_disp_sheet_op_yn==null || print_disp_sheet_op_yn.equals("")){
                print_disp_sheet_op_yn  = "N";
            }
        }
        if(recordSet.containsKey("dflt_lang_for_disp_label")){
            dflt_lang_for_disp_label = (String)recordSet.get("dflt_lang_for_disp_label");
            if (dflt_lang_for_disp_label==null){
                dflt_lang_for_disp_label="";
            }
        }
        if(recordSet.containsKey("label_format_op")){
            label_format_op = (String)recordSet.get("label_format_op");
            if (label_format_op==null){
                label_format_op="";
            }
        }
        if(recordSet.containsKey("allow_drug_return_yn")){
            allow_drug_return_yn = (String)recordSet.get("allow_drug_return_yn");
            if (allow_drug_return_yn==null || allow_drug_return_yn.equals("")){
                allow_drug_return_yn    = "N";
            }
        }
        if(recordSet.containsKey("max_drug_retention_bef_rtn")){
            max_drug_retention_bef_rtn = (String)recordSet.get("max_drug_retention_bef_rtn") ;
            if (max_drug_retention_bef_rtn==null){
                max_drug_retention_bef_rtn="";
            }
        }
        if(recordSet.containsKey("max_durn_for_op_med_rtn")){
            max_durn_for_op_med_rtn = (String)recordSet.get("max_durn_for_op_med_rtn");
            if (max_durn_for_op_med_rtn==null){
                max_durn_for_op_med_rtn="";
            }
        }
        if(recordSet.containsKey("ip_verf_yn")){
            ip_verf_yn = (String)recordSet.get("ip_verf_yn");
            if (ip_verf_yn==null || ip_verf_yn.equals("")){
                ip_verf_yn  = "N";
            }
        }
        if(recordSet.containsKey("ip_fill_prd_ahead")){
            ip_fill_prd_ahead = (String)recordSet.get("ip_fill_prd_ahead");
            if (ip_fill_prd_ahead==null){
                ip_fill_prd_ahead="";
            }
        }
        if(recordSet.containsKey("ip_fill_excl_prd_behind")){
            ip_fill_excl_prd_behind = (String)recordSet.get("ip_fill_excl_prd_behind");
            if (ip_fill_excl_prd_behind==null){
                ip_fill_excl_prd_behind="";
            }
        }
        if(recordSet.containsKey("ip_delv_reqd_yn")){
            ip_delv_reqd_yn = (String)recordSet.get("ip_delv_reqd_yn");
            if (ip_delv_reqd_yn==null|| ip_delv_reqd_yn.equals("")){
                ip_delv_reqd_yn = "N";
            }
        }
        if(recordSet.containsKey("ip_fill_dflt_start_time")){
            ip_fill_dflt_start_time = (String)recordSet.get("ip_fill_dflt_start_time");
            if (ip_fill_dflt_start_time==null){
                ip_fill_dflt_start_time="00:00";
            }
        }
        if(recordSet.containsKey("dflt_lang_for_disp_label_ip")){
            dflt_lang_for_disp_label_ip = (String)recordSet.get("dflt_lang_for_disp_label_ip");
            if (dflt_lang_for_disp_label_ip==null){
                dflt_lang_for_disp_label_ip="";
            }
        }
        if(recordSet.containsKey("label_format_op")){
            label_format_op = (String)recordSet.get("label_format_op");
            if (label_format_op==null){
                label_format_op="";
            }
        }
        if(recordSet.containsKey("max_drug_retention_bef_rtn")){
            max_drug_retention_bef_rtn = (String)recordSet.get("max_drug_retention_bef_rtn");
            if (max_drug_retention_bef_rtn==null){
                max_drug_retention_bef_rtn="";
            }
        }
        if(recordSet.containsKey("max_durn_for_op_med_rtn")){
            max_durn_for_op_med_rtn = (String)recordSet.get("max_durn_for_op_med_rtn");
            if (max_durn_for_op_med_rtn==null){
                max_durn_for_op_med_rtn="";
            }
        }
        if(recordSet.containsKey("ip_fill_prd_ahead")){
            ip_fill_prd_ahead = (String)recordSet.get("ip_fill_prd_ahead");
            if (ip_fill_prd_ahead==null){
                ip_fill_prd_ahead="";
            }
        }
        if(recordSet.containsKey("ip_fill_excl_prd_behind")){
            ip_fill_excl_prd_behind = (String)recordSet.get("ip_fill_excl_prd_behind");
            if (ip_fill_excl_prd_behind==null){
                ip_fill_excl_prd_behind="";
            }
        }
        if(recordSet.containsKey("ip_fill_dflt_start_time")){
            ip_fill_dflt_start_time = (String)recordSet.get("ip_fill_dflt_start_time");
            if (ip_fill_dflt_start_time==null){
                ip_fill_dflt_start_time="";
            }
        }
        if(recordSet.containsKey("dflt_lang_for_disp_label_ip"))
            dflt_lang_for_disp_label_ip = (String)recordSet.get("dflt_lang_for_disp_label_ip");
            if (dflt_lang_for_disp_label_ip==null){
                dflt_lang_for_disp_label_ip="";
            }

        if(recordSet.containsKey("ip_label_format") ){
            ip_label_format = (String)recordSet.get("ip_label_format");
            if (ip_label_format==null){
                ip_label_format="";
            }
        }
        if(recordSet.containsKey("ip_disp_locn_rtn_ord")){
            ip_disp_locn_rtn_ord = (String)recordSet.get("ip_disp_locn_rtn_ord");
            if (ip_disp_locn_rtn_ord==null){
                ip_disp_locn_rtn_ord="";
            }
        }
        if(recordSet.containsKey("ip_disp_locn_stat_ord")){
            ip_disp_locn_stat_ord = (String)recordSet.get("ip_disp_locn_stat_ord");
            if (ip_disp_locn_stat_ord==null){
                ip_disp_locn_stat_ord="";
            }
        }
        if(recordSet.containsKey("interface_to_bl_yn"))
            interface_to_bl_yn = (String)recordSet.get("interface_to_bl_yn");
        if(recordSet.containsKey("verf_yn")){
            verf_yn = (String)recordSet.get("verf_yn");
            if (verf_yn.equals("")|| verf_yn ==null){
                verf_yn = "N";
            }
        }
        if(recordSet.containsKey("op_disp_locn_rtn_ord"))
            op_disp_locn_rtn_ord = (String)recordSet.get("op_disp_locn_rtn_ord");
		if(recordSet.containsKey("op_disp_locn_stat_ord"))
            op_disp_locn_stat_ord = (String)recordSet.get("op_disp_locn_stat_ord");
		if(recordSet.containsKey("disch_med_disp_locn"))
            disch_med_disp_locn = (String)recordSet.get("disch_med_disp_locn");
		if(recordSet.containsKey("ip_fill_prd_unit"))
            ip_fill_prd_unit = (String)recordSet.get("ip_fill_prd_unit");
  /*		if(recordSet.containsKey("ip_disp_loc_stat_ord"))
              ip_disp_loc_stat_ord = (String)recordSet.get("ip_disp_loc_stat_ord");
    		if(recordSet.containsKey("ip_disp_loc_rtn_ord"))
              ip_disp_loc_rtn_ord = (String)recordSet.get("ip_disp_loc_rtn_ord");*/

		if(recordSet.containsKey("print_bal_med_sheet_op_yn")){
            print_bal_med_sheet_op_yn = (String)recordSet.get("print_bal_med_sheet_op_yn");
            if (print_bal_med_sheet_op_yn.equals("")|| print_bal_med_sheet_op_yn ==null){
                print_bal_med_sheet_op_yn = "N";
            }
        }
		if(recordSet.containsKey("disp_verf_stage"))
            disp_verf_stage = (String)recordSet.get("disp_verf_stage");

        /*if(recordSet.containsKey("allow_usage_of_spil_qty_yn")){
            if(recordSet.get("allow_usage_of_spil_qty_yn")!=null){
				allow_usage_of_spil_qty_yn = (String)recordSet.get("allow_usage_of_spil_qty_yn");
			}else{
				allow_usage_of_spil_qty_yn ="N";
			}
        }
		
		if(recordSet.containsKey("charge_qty_ind")){
            if(recordSet.get("charge_qty_ind")!=null){
				charge_qty_ind = (String)recordSet.get("charge_qty_ind");
			}
        }
		else {charge_qty_ind = "";}	*/

		if(recordSet.containsKey("med_admin_reqd_yn")){
            if(recordSet.get("med_admin_reqd_yn")!=null){
				med_admin_reqd_yn = (String)recordSet.get("med_admin_reqd_yn");
			}
			else{
				med_admin_reqd_yn = "N";
			}
        }
		if(recordSet.containsKey("verf_reqd_bef_med_admin_yn")){
            if(recordSet.get("verf_reqd_bef_med_admin_yn")!=null){
				verf_reqd_bef_med_admin_yn  = (String)recordSet.get("verf_reqd_bef_med_admin_yn");
			}
			else{
				verf_reqd_bef_med_admin_yn  = "N";
			}
        }
		if(recordSet.containsKey("rec_admin_within_hrs")){
            if(recordSet.get("rec_admin_within_hrs")!=null){
				rec_admin_within_hrs = (String)recordSet.get("rec_admin_within_hrs");
			}
        }
		if(recordSet.containsKey("allow_med_admin_wo_ord_yn")){
            if(recordSet.get("allow_med_admin_wo_ord_yn")!=null){
				allow_med_admin_wo_ord_yn = (String)recordSet.get("allow_med_admin_wo_ord_yn");
			}
			else{
				allow_med_admin_wo_ord_yn = "N";
			}
        }
		if(recordSet.containsKey("ip_consider_stock")){
            if(recordSet.get("ip_consider_stock")!=null && !((String)recordSet.get("ip_consider_stock")).equals("")){
				ip_consider_stock = (String)recordSet.get("ip_consider_stock");
			}
			else{
				ip_consider_stock = "N";
			}
        }
		if(recordSet.containsKey("ip_allow_stock")){
            if(recordSet.get("ip_allow_stock")!=null && !((String)recordSet.get("ip_allow_stock")).equals("") ){
				ip_allow_stock = (String)recordSet.get("ip_allow_stock");
			}
			else{
				ip_allow_stock = "N";
			}
        }
		if(recordSet.containsKey("allow_duplicate_drug_ip")) {
			if(recordSet.get("allow_duplicate_drug_ip")!=null && !((String)recordSet.get("allow_duplicate_drug_ip")).equals("") ){
				allow_duplicate_drug = (String)recordSet.get("allow_duplicate_drug_ip");
			}
			else{
				allow_duplicate_drug = "N";
			}
		}
		//IN30118-SCF No: MO-GN-5400. Assigning For OutPatient Duplicate Drug Check.
		if(recordSet.containsKey("allow_duplicate_drug_op")) {
			if(recordSet.get("allow_duplicate_drug_op")!=null && !((String)recordSet.get("allow_duplicate_drug_op")).equals("") ){
				allow_duplicate_drug_op = (String)recordSet.get("allow_duplicate_drug_op");
			}
			else{
				allow_duplicate_drug_op = "N";
			}
		}
		if(recordSet.containsKey("allow_medn_order_without_diag")){
            allow_medn_order_without_diag = (String)recordSet.get("allow_medn_order_without_diag") ;
            if ( allow_medn_order_without_diag==null || allow_medn_order_without_diag.equals("")){
                allow_medn_order_without_diag   = "N";
            }
        }
		if(recordSet.containsKey("allow_medn_order_without_wt")){
            allow_medn_order_without_wt = (String)recordSet.get("allow_medn_order_without_wt") ;
            if ( allow_medn_order_without_wt==null || allow_medn_order_without_wt.equals("")){
                allow_medn_order_without_wt   = "N";
            }
        }
		if(recordSet.containsKey("iv_admixture_applicable")){
            iv_admixture_appl_yn = (String)recordSet.get("iv_admixture_applicable") ;
            if ( iv_admixture_appl_yn==null ||iv_admixture_appl_yn.equals("")){
                iv_admixture_appl_yn  = "N";
            }
			if (iv_admixture_appl_yn.equals("on")){
				iv_admixture_appl_yn  = "Y";
			}
        }
		if(recordSet.containsKey("cdr_admixture_applicable")){
           cdr_admixture_appl_yn = (String)recordSet.get("cdr_admixture_applicable") ;
            if (cdr_admixture_appl_yn==null || cdr_admixture_appl_yn.equals("")){
                cdr_admixture_appl_yn   = "N";
            }
		    if (cdr_admixture_appl_yn.equals("on")){
				cdr_admixture_appl_yn="Y";
			}
        }
		if(recordSet.containsKey("prep_of_tpn_non_std_regimen")){
            tpn_regimen_appl_yn = (String)recordSet.get("prep_of_tpn_non_std_regimen") ;
            if (tpn_regimen_appl_yn==null || tpn_regimen_appl_yn.equals("")){
                tpn_regimen_appl_yn  = "N";
            }
			if (tpn_regimen_appl_yn.equals("on")){
				tpn_regimen_appl_yn="Y";
			}
        }
		if(recordSet.containsKey("admx_prep_charges_appl_yn")){
            admx_prep_charges_appl_yn = (String)recordSet.get("admx_prep_charges_appl_yn") ;
            if (admx_prep_charges_appl_yn==null || admx_prep_charges_appl_yn.equals("") ){
                admx_prep_charges_appl_yn  = "N";
            }
			if (admx_prep_charges_appl_yn.equals("on")){
				admx_prep_charges_appl_yn="Y";
			}
        }
		if(recordSet.containsKey("working_hours_of_prep_room_from")){
            working_hours_room_from = (String)recordSet.get("working_hours_of_prep_room_from") ;
            if (working_hours_room_from==null ){
                working_hours_room_from   = "";
            }
        }
		if(recordSet.containsKey("working_hours_of_prep_room_to")){
            working_hours_room_to = (String)recordSet.get("working_hours_of_prep_room_to") ;
            if (working_hours_room_to==null ){
                working_hours_room_to   = "";
            }
        }
		if(recordSet.containsKey("alert_beyond_working_hours")){
			alert_practitioner_yn = (String)recordSet.get("alert_beyond_working_hours") ;
            if (alert_practitioner_yn==null || alert_practitioner_yn.equals("")){
                alert_practitioner_yn   = "N";
            }
			if (alert_practitioner_yn.equals("on")){
				alert_practitioner_yn="Y";
			}
        }
		if(recordSet.containsKey("verify_tdm_order_yn")){
			verify_tdm_order_yn = (String)recordSet.get("verify_tdm_order_yn") ;
			if (verify_tdm_order_yn.equals("on")){verify_tdm_order_yn="Y";}
            else {
                verify_tdm_order_yn   = "N";
            }
        }
		if(recordSet.containsKey("tdm_reporting_id")){
			if(recordSet.get("tdm_reporting_id")!=null && !((String)recordSet.get("tdm_reporting_id")).equals("") ){
				tdm_reporting_id = (String)recordSet.get("tdm_reporting_id");
			}
		}
		if(recordSet.containsKey("pat_couns_reporting_id")){
			if(recordSet.get("pat_couns_reporting_id")!=null && !((String)recordSet.get("pat_couns_reporting_id")).equals("") ){
				pat_couns_reporting_id = (String)recordSet.get("pat_couns_reporting_id");
			}
			
        }
		if(recordSet.containsKey("start_adr_no")){
			if(recordSet.get("start_adr_no")!=null && !((String)recordSet.get("start_adr_no")).equals("") ){
				start_adr_no = (String)recordSet.get("start_adr_no");
			}
        }
		if(recordSet.containsKey("last_adr_no")){
			if(recordSet.get("last_adr_no")!=null && !((String)recordSet.get("last_adr_no")).equals("") ){
				last_adr_no = (String)recordSet.get("last_adr_no");
			}
			else { 
				last_adr_no=start_adr_no;
			}
        }
		else { 
			last_adr_no=start_adr_no;
		}
		if(recordSet.containsKey("unalloc_order_del_st")){//code added for unallocated orders...on 29/4/2004
            unalloc_order_del_st = (String)recordSet.get("unalloc_order_del_st") ;
            if (unalloc_order_del_st==null || unalloc_order_del_st.equals("")){
                unalloc_order_del_st   = "N";
            }
        }
		if(recordSet.containsKey("print_exp_date_on_lbl")){
			print_exp_date_on_lbl = (String)recordSet.get("print_exp_date_on_lbl") ;
			if (print_exp_date_on_lbl==null || print_exp_date_on_lbl.equals("")){
				print_exp_date_on_lbl   = "N";
			}			
		}
	   if(recordSet.containsKey("duplicate_check_atc")){
			duplicate_check_atc = (String)recordSet.get("duplicate_check_atc");
			if(duplicate_check_atc == null || duplicate_check_atc.equals("")){
				duplicate_check_atc = "N";
			}
		}
		if(recordSet.containsKey("remarks_for_prn")){
			remarks_for_prn = (String)recordSet.get("remarks_for_prn");
			if(remarks_for_prn ==null  || remarks_for_prn.equals("")){
				remarks_for_prn="N";
			}
		}
		if(recordSet.containsKey("display_charge_details_lkp")){
			display_charge_details_lkp = (String)recordSet.get("display_charge_details_lkp");
			if(display_charge_details_lkp ==null  || display_charge_details_lkp.equals("")){
				display_charge_details_lkp="N";
			}
		}
		if(recordSet.containsKey("display_charge_details_prescription")){
			display_charge_details_prescription = (String)recordSet.get("display_charge_details_prescription");
			if(display_charge_details_prescription ==null  || display_charge_details_prescription.equals("")){
				display_charge_details_prescription="N";
			}
		}
		if(recordSet.containsKey("display_price_type_lkp")){
			display_price_type_lkp = (String)recordSet.get("display_price_type_lkp");
		}
		if(recordSet.containsKey("compounding_rx")){
			comp_rx_appl_yn = (String)recordSet.get("compounding_rx");
			if (comp_rx_appl_yn ==null|| comp_rx_appl_yn.equals("")){
				comp_rx_appl_yn = "N";
			}
		}
		if(recordSet.containsKey("intravenous_rx")){
			iv_rx_appl_yn = (String)recordSet.get("intravenous_rx");
			if (iv_rx_appl_yn ==null|| iv_rx_appl_yn.equals("")){
				iv_rx_appl_yn = "N";
			}
		}
		if(recordSet.containsKey("oncology_rx")){
			oncology_rx_appl_yn = (String)recordSet.get("oncology_rx");
			if (oncology_rx_appl_yn ==null || oncology_rx_appl_yn.equals("") ){
				oncology_rx_appl_yn = "N";
			}
		}
		if(recordSet.containsKey("tpn_rx")){
			tpn_rx_appl_yn = (String)recordSet.get("tpn_rx");
			if (tpn_rx_appl_yn ==null || tpn_rx_appl_yn.equals("")){
				tpn_rx_appl_yn = "N";
			}
		}
		if(recordSet.containsKey("tdm")){
			tdm_appl_yn = (String)recordSet.get("tdm");
			if (tdm_appl_yn ==null || tdm_appl_yn.equals("")){
				tdm_appl_yn = "N";
			}
		}
		if(recordSet.containsKey("tdm_result_type")){
			tdm_result_type = (String)recordSet.get("tdm_result_type");
			if (tdm_result_type ==null){
				tdm_result_type = "";
			}
		}
		if(recordSet.containsKey("pat_couns_result_type")){
			pat_couns_result_type = (String)recordSet.get("pat_couns_result_type");
			if (pat_couns_result_type ==null ){
				pat_couns_result_type = "";
			}
		}
		if(recordSet.containsKey("drug_db_interface_yn")){
			drug_db_interface_yn = (String)recordSet.get("drug_db_interface_yn");
			if ( drug_db_interface_yn ==null ){
				drug_db_interface_yn = "";
			}
		}
		if(recordSet.get("drug_db_interface_name") != null)
            drug_db_interface_name = (String)recordSet.get("drug_db_interface_name") ;

		if(recordSet.containsKey("drug_db_dosecheck_yn")){
			drug_db_dosecheck_yn = (String)recordSet.get("drug_db_dosecheck_yn");
			if (drug_db_dosecheck_yn ==null){
				drug_db_dosecheck_yn = "";
			}
		}
		if(recordSet.containsKey("drug_db_duptherapy_yn")){
			drug_db_duptherapy_yn = (String)recordSet.get("drug_db_duptherapy_yn");
			if (drug_db_duptherapy_yn ==null ){
				drug_db_duptherapy_yn = "";
			}
		}
		if(recordSet.containsKey("drug_db_interaction_yn")){
			drug_db_interaction_yn = (String)recordSet.get("drug_db_interaction_yn");
			if (drug_db_interaction_yn ==null ){
				drug_db_interaction_yn = "";
			}
		}
		if(recordSet.containsKey("drug_db_contracheck_yn")){
			drug_db_contracheck_yn = (String)recordSet.get("drug_db_contracheck_yn");
			if (drug_db_contracheck_yn ==null ){
				drug_db_contracheck_yn = "";
			}
		}
		if(recordSet.containsKey("drug_db_alergycheck_yn")){
			drug_db_alergycheck_yn = (String)recordSet.get("drug_db_alergycheck_yn");
			if (drug_db_alergycheck_yn ==null ){
				drug_db_alergycheck_yn = "";
			}
		}

		if(recordSet.containsKey("inpatient_yn")){
			inpatient_yn = (String)recordSet.get("inpatient_yn");
			if (inpatient_yn ==null || inpatient_yn.equals("")){
				inpatient_yn = "N";
			}
		}
		if(recordSet.containsKey("Outpatient_yn")){
			Outpatient_yn = (String)recordSet.get("Outpatient_yn");
			if (Outpatient_yn ==null || Outpatient_yn.equals("")){
				Outpatient_yn = "N";
			}
		}
		if(recordSet.containsKey("Daycare_yn")){
			Daycare_yn = (String)recordSet.get("Daycare_yn");
			if ( Daycare_yn ==null || Daycare_yn.equals("")){
				Daycare_yn = "N";
			}
		}
		if(recordSet.containsKey("emergency_yn")){
			emergency_yn = (String)recordSet.get("emergency_yn");
			if (emergency_yn ==null || emergency_yn.equals("")){
				emergency_yn = "N";
			}
		}
		if(recordSet.containsKey("Disch_Med_Mar_Appl_yn")){
			Disch_Med_Mar_Appl_yn = (String)recordSet.get("Disch_Med_Mar_Appl_yn");
			if (Disch_Med_Mar_Appl_yn ==null || Disch_Med_Mar_Appl_yn.equals("")){
				Disch_Med_Mar_Appl_yn = "N";
			}
		}
		if(recordSet.containsKey("tpn_screening_type")){
			tpn_screening_type = (String)recordSet.get("tpn_screening_type");
			if (tpn_screening_type ==null){
				tpn_screening_type = "";
			}
		}
		if(recordSet.containsKey("tpn_reporting_id")){
			if(recordSet.get("tpn_reporting_id")!=null && !((String)recordSet.get("tpn_reporting_id")).equals("") ){
				tpn_reporting_id = (String)recordSet.get("tpn_reporting_id");
			}
		}
		if(recordSet.containsKey("oncology_screening_type")){
			oncology_screening_type = (String)recordSet.get("oncology_screening_type");
			if (oncology_screening_type ==null){
				oncology_screening_type = "";
			}
		}
		if(recordSet.containsKey("onc_reporting_id")){
			if(recordSet.get("onc_reporting_id")!=null && !((String)recordSet.get("onc_reporting_id")).equals("") ){
				onc_reporting_id = (String)recordSet.get("onc_reporting_id");
			}
		}
		if(recordSet.containsKey("drug_cat_pin_auth_reqd_yn")){
            if(recordSet.get("drug_cat_pin_auth_reqd_yn")!=null){
				drug_cat_pin_auth_reqd_yn = (String)recordSet.get("drug_cat_pin_auth_reqd_yn");
			}
			else{
				drug_cat_pin_auth_reqd_yn = "N";
			}
        }
		if(recordSet.containsKey("copy_pres_upto_no_of_days")){		// code added for copy prescriptions by kiran on 5/2/2009	
          copy_pres_upto_no_of_days = (String)recordSet.get("copy_pres_upto_no_of_days");					
        }
		if(recordSet.containsKey("allow_short_expiry_drugs_yn") ){
            allow_short_expiry_drugs_yn = (String)recordSet.get("allow_short_expiry_drugs_yn");
			 if (allow_short_expiry_drugs_yn == null || allow_short_expiry_drugs_yn.equals("")){
                allow_short_expiry_drugs_yn  = "N";
            }
        }
		if(recordSet.containsKey("rec_admin_bef_schdle_time")){
			rec_admin_bef_schdle_time=(String)recordSet.get("rec_admin_bef_schdle_time");
		}

		if(recordSet.containsKey("rec_admin_bef_schdle_time_UOM")){
			rec_admin_bef_schdle_time_UOM=(String)recordSet.get("rec_admin_bef_schdle_time_UOM");
		}
		if(recordSet.get("mode") != null)
           mode = (String)recordSet.get("mode") ;
		if(recordSet.containsKey("include_zero_allocated_items_in_dispensing")){//added for INCLUDE ZERO ALLOC ITEMS on 07-03-09
            include_zero_allocated_items_in_dispensing = (String)recordSet.get("include_zero_allocated_items_in_dispensing");
            if (include_zero_allocated_items_in_dispensing==null || include_zero_allocated_items_in_dispensing.equals("")){
                include_zero_allocated_items_in_dispensing  = "N";
            }
        }
		if(recordSet.containsKey("allow_disp_record_lock_yn")){//Added for CRF-0439  To add dispensing locking facility
			 allow_disp_record_lock_yn = (String)recordSet.get("allow_disp_record_lock_yn");
            if (allow_disp_record_lock_yn==null || allow_disp_record_lock_yn.equals("")){
                allow_disp_record_lock_yn  = "N";
            }
        }
		if(recordSet.containsKey("prompt_alert_for_preferred_item")){//Added for CRF-711  Prompt Alert for Preferred Item
			 promptAlertForPreferredItem = (String)recordSet.get("prompt_alert_for_preferred_item");
            if (promptAlertForPreferredItem==null || promptAlertForPreferredItem.equals("")){
                promptAlertForPreferredItem  = "N";
            }
        }
		if(recordSet.containsKey("default_privilege_drug_selection")){//Added for CRF-641  Default Privilege Drug Selection
			 defaultPrivilegeDrugSelection = (String)recordSet.get("default_privilege_drug_selection");   
        }
		if(recordSet.containsKey("display_uom_transaction_by")){//Added for CRF-749  display UOM in Transaction by 
			 display_uom_transaction_by = (String)recordSet.get("display_uom_transaction_by");   
        }
		if(recordSet.containsKey("narcotic_aprvl_form_req_yn")){//Added for CRF-713 INC 12785
			 narcotic_aprvl_form_req_yn = (String)recordSet.get("narcotic_aprvl_form_req_yn");
            if (narcotic_aprvl_form_req_yn==null || narcotic_aprvl_form_req_yn.equals("")){
                narcotic_aprvl_form_req_yn  = "N";
            }
        }
		if(recordSet.containsKey("print_narcotic_form_by_default")){
			 print_narcotic_form_by_default = (String)recordSet.get("print_narcotic_form_by_default");
            if (print_narcotic_form_by_default==null || print_narcotic_form_by_default.equals("")){
                print_narcotic_form_by_default  = "N";
            }
        }
		if(recordSet.containsKey("edit_disp_label_after_del")){
			 edit_disp_label_after_del = (String)recordSet.get("edit_disp_label_after_del");
            if (edit_disp_label_after_del==null || edit_disp_label_after_del.equals("")){
                edit_disp_label_after_del  = "N";
            }
        }
		if(recordSet.containsKey("Pres_Quantity_by_PresUnit")){//Adding on7/12/2009 for Prescribe Quantity by Prescribing Unit check box
			rx_qty_by_pres_base_uom_yn = (String)recordSet.get("Pres_Quantity_by_PresUnit");
			if(rx_qty_by_pres_base_uom_yn ==null  || rx_qty_by_pres_base_uom_yn.equals("")){
				rx_qty_by_pres_base_uom_yn="N";
			}
			if (rx_qty_by_pres_base_uom_yn.equals("on")){
				rx_qty_by_pres_base_uom_yn="Y";
			}
			if(recordSet.containsKey("dflt_ip_fill_incr_start_with"))
				dflt_ip_fill_incr_start_with = (String)recordSet.get("dflt_ip_fill_incr_start_with");
			if(recordSet.containsKey("inpatient_yn_rule_check")){
				inpatient_yn_rule_check = (String) recordSet.get("inpatient_yn_rule_check");
				if (inpatient_yn_rule_check ==null || inpatient_yn_rule_check.equals("")){
					inpatient_yn_rule_check = "N";
				}
			}
			if(recordSet.containsKey("outpatient_yn_rule_check")){
				outpatient_yn_rule_check = (String) recordSet.get("outpatient_yn_rule_check");
				if (outpatient_yn_rule_check ==null || outpatient_yn_rule_check.equals("")){
					outpatient_yn_rule_check = "N";
				}
			}
			if(recordSet.containsKey("daycare_yn_rule_check")){
				daycare_yn_rule_check = (String) recordSet.get("daycare_yn_rule_check");
				if (daycare_yn_rule_check ==null || daycare_yn_rule_check.equals("")){
					daycare_yn_rule_check = "N";
				}
			}
			if(recordSet.containsKey("emergency_yn_rule_check")){
				emergency_yn_rule_check	 = (String) recordSet.get("emergency_yn_rule_check");
				if (emergency_yn_rule_check	== null || emergency_yn_rule_check.equals("")){
					emergency_yn_rule_check	 = "N";
				}
			}
			if(recordSet.containsKey("dischmedic_yn_rule_check")){
				dischmedic_yn_rule_check = (String) recordSet.get("dischmedic_yn_rule_check");
				if (dischmedic_yn_rule_check ==null || dischmedic_yn_rule_check.equals("")){
					dischmedic_yn_rule_check = "N";
				}
			}
			if(recordSet.containsKey("atc_allergy_alert_level")){
				atc_allergy_alert_level = (String) recordSet.get("atc_allergy_alert_level");
			}
			if(recordSet.containsKey("tab_based_group_sort_disp")){
				tab_based_group_sort_disp = (String) recordSet.get("tab_based_group_sort_disp");
			}
		} //code ends
		if(recordSet.containsKey("discont_canc_dup_medic")){    //if block added for Bru-HIMS-CRF-265 [IN:032315]
			discont_canc_dup_medic = (String)recordSet.get("discont_canc_dup_medic");
            if (discont_canc_dup_medic==null || discont_canc_dup_medic.equals("")){
                discont_canc_dup_medic  = "N";
            }
        }
		if(recordSet.containsKey("disp_exp_orders_yn")){    //if block added for ML-BRU-SCF-0636 [IN036826]
			disp_exp_orders_yn = (String)recordSet.get("disp_exp_orders_yn");
            if (disp_exp_orders_yn==null || disp_exp_orders_yn.equals("")){
                disp_exp_orders_yn  = "N";
            }
        }
		if(recordSet.containsKey("pin_auth_mar_yn")){    //if block added for RUT-CRF-0035 [IN029926]
			pin_auth_mar_yn = (String)recordSet.get("pin_auth_mar_yn");
            if (pin_auth_mar_yn==null || pin_auth_mar_yn.equals("")){
                pin_auth_mar_yn  = "N";
            }
        }
		if(recordSet.containsKey("allow_medn_ord_without_diag_dd")){//if block added for CRF MMS-QH-CRF-0068 [IN:037980]
            allow_medn_ord_without_diag_dd = (String)recordSet.get("allow_medn_ord_without_diag_dd") ;
            if ( allow_medn_ord_without_diag_dd==null || allow_medn_ord_without_diag_dd.equals("")){
                allow_medn_ord_without_diag_dd   = "N";
            }
        }
		if(recordSet.containsKey("print_mar_label_yn")){//if block added for  MMS-QH-CRF-0080 [IN:038064]
            print_mar_label_yn = (String)recordSet.get("print_mar_label_yn") ;
            if ( print_mar_label_yn==null || print_mar_label_yn.equals("")){
                print_mar_label_yn   = "N";
            }
        } 
		if(recordSet.containsKey("alt_drug_remarks_ind")){//if block added for Bru-HIMS-CRF-082 [IN:029948]
            alt_drug_remarks_ind = (String)recordSet.get("alt_drug_remarks_ind") ;
            if ( alt_drug_remarks_ind==null || alt_drug_remarks_ind.equals("")){
                alt_drug_remarks_ind   = "N";
            }
        } 
		if(recordSet.containsKey("mar_sch_level_yn")){//added for SKR-CRF-0037 [IN:037656] -Start
            mar_sch_level_yn = (String)recordSet.get("mar_sch_level_yn") ;
            if ( mar_sch_level_yn==null || mar_sch_level_yn.equals("")){
                mar_sch_level_yn   = "N";
            }
        } 
		if(recordSet.containsKey("mar_start_ind")){
            mar_start_ind = (String)recordSet.get("mar_start_ind") ;
            if ( mar_start_ind==null || mar_start_ind.equals("")){
                mar_start_ind   = "N";
            }
        } 
		if(recordSet.containsKey("mar_week_day_start")){
            mar_week_day_start = (String)recordSet.get("mar_week_day_start") ;
            if ( mar_week_day_start==null || mar_week_day_start.equals("")){
                mar_week_day_start   = "0";
            }
        } 
		if(recordSet.containsKey("mar_past_day")){
            mar_past_day = (String)recordSet.get("mar_past_day") ;
            if ( mar_past_day==null || mar_past_day.equals("")){
                mar_past_day   = "";
            }
        } 
		if(recordSet.containsKey("mar_future_day")){
            mar_future_day = (String)recordSet.get("mar_future_day") ;
            if ( mar_future_day==null || mar_future_day.equals("")){
                mar_future_day   = "";
            }
        } 
		if(recordSet.containsKey("mar_default_order_by")){
            mar_default_order_by = (String)recordSet.get("mar_default_order_by") ;
            if ( mar_default_order_by==null || mar_default_order_by.equals("")){
                mar_default_order_by   = "N";
            }
        } 
		if(recordSet.containsKey("mar_disc_dose_yn")){
            mar_disc_dose_yn = (String)recordSet.get("mar_disc_dose_yn") ;
            if ( mar_disc_dose_yn==null || mar_disc_dose_yn.equals("")){
                mar_disc_dose_yn   = "N";
            }
        } 
		if(recordSet.containsKey("mar_iv_compl_dt_ind")){
            mar_iv_compl_dt_ind = (String)recordSet.get("mar_iv_compl_dt_ind") ;
            if ( mar_iv_compl_dt_ind==null || mar_iv_compl_dt_ind.equals("")){
                mar_iv_compl_dt_ind   = "N";
            }
        }  //added for SKR-CRF-0037 [IN:037656] -End
		if(recordSet.containsKey("allergy_conf_reqd_yn")){   //added for RUT-CRF-0064.1 [IN:041799]
            allergy_conf_reqd_yn = (String)recordSet.get("allergy_conf_reqd_yn") ;
            if ( allergy_conf_reqd_yn==null || allergy_conf_reqd_yn.equals("")){
                allergy_conf_reqd_yn   = "N";
            }
        } 
		if(recordSet.containsKey("mar_disp_held_disc_orders_yn")){ //added for [IN:043283]
            mar_disp_held_disc_orders_yn = (String)recordSet.get("mar_disp_held_disc_orders_yn") ;
            if ( mar_disp_held_disc_orders_yn==null || mar_disp_held_disc_orders_yn.equals("")){
                mar_disp_held_disc_orders_yn   = "N";
            }
        }  
		if(recordSet.containsKey("disp_before_start_date_yn_ip")){ //added for AMS-CRF-0009[IN:030935] start
			disp_before_start_date_yn_ip = (String)recordSet.get("disp_before_start_date_yn_ip") ;
            if ( disp_before_start_date_yn_ip==null || disp_before_start_date_yn_ip.equals("")){
            	disp_before_start_date_yn_ip   = "N";
            }
        }  
		if(recordSet.containsKey("disp_before_no_of_days_ip")){ 
			disp_before_no_of_days_ip = (String)recordSet.get("disp_before_no_of_days_ip") ;
            if ( disp_before_no_of_days_ip==null || disp_before_no_of_days_ip.equals("")){
            	disp_before_no_of_days_ip   = "";
            }
        }  
		if(recordSet.containsKey("disp_beyond_earliest_start_yn_ip")){ 
			disp_beyond_earliest_start_yn_ip = (String)recordSet.get("disp_beyond_earliest_start_yn_ip") ;
            if ( disp_beyond_earliest_start_yn_ip==null || disp_beyond_earliest_start_yn_ip.equals("")){
            	disp_beyond_earliest_start_yn_ip   = "N";
            }
        }  
		if(recordSet.containsKey("disp_beyond_no_of_days_ip")){ //added for AMS-CRF-0009[IN:030935] End
			disp_beyond_no_of_days_ip = (String)recordSet.get("disp_beyond_no_of_days_ip") ;
            if ( disp_beyond_no_of_days_ip==null || disp_beyond_no_of_days_ip.equals("")){
            	disp_beyond_no_of_days_ip   = "";
            }
        }  
		if(recordSet.get("witness_for_verbal_order_yn")!=null){			// Added for AAKH-CRF-0023[IN:038259] start
        	witness_for_verbal_order_yn = (String)recordSet.get("witness_for_verbal_order_yn");}
		else{
			witness_for_verbal_order_yn = "N";}							// Added for AAKH-CRF-0023[IN:038259] end
		strDefaultFreqforIV = checkForNull((String)recordSet.get("sel_defaultfreqforIV"));//Added for Bru-HIMS-CRF-384[IN041642]
		em_medctn_fwd_ip_yn = checkForNull((String)recordSet.get("em_medctn_fwd_ip_yn"),"N");//Added for Bru-HIMS-CRF-402[IN044065]
		cary_frwd_ord_nofhrs = checkForNull((String)recordSet.get("cary_frwd_ord_nofhrs"),"");//Added for Bru-HIMS-CRF-402[IN044065]
		disp_rx_duration_yn = checkForNull((String)recordSet.get("disp_rx_duration_yn"),"N");//Added for Bru-HIMS-CRF-403[IN044541]
		diag_for_medn_order_by = checkForNull((String)recordSet.get("diag_for_medn_order_by"),"P");//Added for MMS-SCF-0325 [IN:048069]
		allow_mar_share_drug_yn = checkForNull((String)recordSet.get("allow_mar_share_drug_yn"),"N");//added for HSA-CRF-0090 [IN:041241]
		allow_renew_from_chart_summ_yn = checkForNull((String)recordSet.get("allow_renew_from_chart_summ_yn"),"N");//Added for Bru-HIMS-CRF-400
		can_discon_dup_orders_def_sel = checkForNull((String)recordSet.get("can_discon_dup_orders_def_sel"),"N");//Added for HSA-CRF-0151 [IN048468]
		allow_auto_disp_alt_drug_mar = checkForNull((String)recordSet.get("allow_auto_disp_alt_drug_mar"),"N");//Added for Bru-HIMS-CRF-399 [IN:043767]
		mar_disp_unbilled_med_yn = checkForNull((String)recordSet.get("mar_disp_unbilled_med_yn"),"N"); // Added for NMC-JD-CRF-0186   <!-- 42911 -->
		preview_rx_yn = checkForNull((String)recordSet.get("preview_rx_yn"),"N");//Added for ML-MMOH-CRF-0341 [IN:057179] 
		disp_prev_vital_signs_yn = checkForNull((String)recordSet.get("disp_prev_vital_signs_yn"),"N");//Added for ML-MMOH-CRF-0346 [IN:057185] 
		//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016 starts
		if(recordSet.containsKey("generic_code")){
			if(recordSet.get("generic_code")!=null && !((String)recordSet.get("generic_code")).equals("") ){
				generic_code = (String)recordSet.get("generic_code");
			}
		}
		if(recordSet.containsKey("generic_name")){
			if(recordSet.get("generic_name")!=null && !((String)recordSet.get("generic_name")).equals("") ){
				generic_name = (String)recordSet.get("generic_name");
			}
		}
		if(recordSet.containsKey("working_hour_from"))
			setWorkingFrom((String)recordSet.get("working_hour_from"));
		if(recordSet.containsKey("working_hour_to"))
			setWorkingTo((String)recordSet.get("working_hour_to"));
		//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016 ends
		//Allow_Amd_Alt_DRug_Dt Added by prathyusha for JD-CRF-198 on 05/05/2016 start
		if(recordSet.containsKey("allow_amend_alt_drug_dtl_yn") ){
			allow_amend_alt_drug_dtl = (String)recordSet.get("allow_amend_alt_drug_dtl_yn");
			//System.out.println("Allow_Amd_Alt_DRug_Dt========1214===="+Allow_Amd_Alt_DRug_Dt);
			if (allow_amend_alt_drug_dtl == null || allow_amend_alt_drug_dtl.equals("")){
				allow_amend_alt_drug_dtl  = "N";
            }
        }
	//	Allow_Amd_Alt_DRug_Dt Added by prathyusha for JD-CRF-198 on 05/05/2016  end
		 //Added for MO-CRF-20085.1  By Prathyusha on 05/18/2016 start
		if(recordSet.containsKey("skip_duplicate_alert_op") ){
			skip_duplicate_alert_op = (String)recordSet.get("skip_duplicate_alert_op");
		
			if (skip_duplicate_alert_op == null || skip_duplicate_alert_op.equals("")){
				skip_duplicate_alert_op  = "N";
            }
        }
		if(recordSet.containsKey("skip_duplicate_alert_ip") ){
			skip_duplicate_alert_ip = (String)recordSet.get("skip_duplicate_alert_ip");
			
			if (skip_duplicate_alert_ip == null || skip_duplicate_alert_ip.equals("")){
				skip_duplicate_alert_ip  = "N";
            }
        }
		//Added for  MO-CRF-20085.1  By Prathyusha on 05/18/2016 end
		 //Added for MO-CRF-20085.1  By Prathyusha on 05/26/2016 start
		if(recordSet.containsKey("overlap_duration_op") ){
			overlap_period_for_op = (String)recordSet.get("overlap_duration_op");
		
			if (overlap_period_for_op == null || overlap_period_for_op.equals("")){
				overlap_period_for_op  = "";
            }
        }
		if(recordSet.containsKey("overlap_duration_ip") ){
			overlap_period_for_ip = (String)recordSet.get("overlap_duration_ip");
			
			if (overlap_period_for_ip == null || overlap_period_for_ip.equals("")){
				overlap_period_for_ip  = "";
            }
        }
		//Added for  MO-CRF-20085.1  By Prathyusha on 05/26/2016 end
		if(recordSet.containsKey("ret_med_restr_stage") ){ // // Added for GHL-CRF-0412.3 - Start
			ret_medic_restr_stage = (String)recordSet.get("ret_med_restr_stage");
			
			if (ret_medic_restr_stage == null || ret_medic_restr_stage.equals("")){
				ret_medic_restr_stage  = "N";
            }
        } // Added for GHL-CRF-0412.3 - End
		
		//added for ml-mmoh-crf-0864 start
		if(recordSet.containsKey("split_drug_based_auth_yn")){
			split_drug_based_auth_yn = (String)recordSet.get("split_drug_based_auth_yn");
            if (split_drug_based_auth_yn == null || split_drug_based_auth_yn.equals("")){
            	split_drug_based_auth_yn  = "N";
            }
        } 
		//added for ml-mmoh-crf-0864 end
		//Addign start for ML-BRU-CRF-0473
		if(recordSet.containsKey("include_zero_allocated_items_in_dispensing_for_ip")){
			include_ip_zero_allocated_drugs_for_dispense = (String)recordSet.get("include_zero_allocated_items_in_dispensing_for_ip");
			System.err.println("include_ip_zero_allocated_drugs_for_dispense@@@@==="+include_ip_zero_allocated_drugs_for_dispense);
            if (include_ip_zero_allocated_drugs_for_dispense == null || include_ip_zero_allocated_drugs_for_dispense.equals("")){
            	include_ip_zero_allocated_drugs_for_dispense  = "N";
            }
        } 
		//Adding end for ML-BRU-CRF-0473
		if(recordSet.containsKey("assesment_req_yn")){ // Added for ML-MMOH-CRF-1126 - Start
			assesment_req_yn = (String)recordSet.get("assesment_req_yn");
		            
			if (assesment_req_yn == null || assesment_req_yn.equals("")){
				assesment_req_yn  = "N";
		    }
		} // Added for ML-MMOH-CRF-1126 - End 
		
		if(recordSet.containsKey("lateOrEarlyAdmin")){ // Added for GHL-CRF-0482 [IN:064955] - Start
			late_or_early_admin = (String)recordSet.get("lateOrEarlyAdmin");
		            
			if (late_or_early_admin == null || late_or_early_admin.equals("")){
				late_or_early_admin  = "N";
		    }
		} // Added for GHL-CRF-0482 [IN:064955] - End 
		
   //added for ghl-crf-0548
		if(recordSet.containsKey("allow_alternate_item_for_medical_item_yn")){ 
			allow_alternate_for_medical_item_yn = (String)recordSet.get("allow_alternate_item_for_medical_item_yn");
		            
			if (allow_alternate_for_medical_item_yn == null || allow_alternate_for_medical_item_yn.equals("")){
				allow_alternate_for_medical_item_yn  = "N";
		    }
		} // Added for GHL-CRF-0548
		//added for NMC-JD-CRF-0001 start
				if(recordSet.containsKey("display_generic_name_yn")){ 
					display_generic_name_yn = (String)recordSet.get("display_generic_name_yn");
				            
					if (display_generic_name_yn == null || display_generic_name_yn.equals("")){
						display_generic_name_yn  = "N";
				    }
				} // Added for NMC-JD-CRF-0001 end	
		// Added for MMS-KH-CRF-0014 start
		if(recordSet.containsKey("ward_ack_required_yn") ){ 
			ward_ack_required_yn = (String)recordSet.get("ward_ack_required_yn");
			
			if (ward_ack_required_yn == null || ward_ack_required_yn.equals("")){
				ward_ack_required_yn  = "N";
            }
        } 
		if(recordSet.containsKey("ward_ack_mar_required_yn") ){ 
			ward_ack_mar_required_yn = (String)recordSet.get("ward_ack_mar_required_yn");
			
			if (ward_ack_mar_required_yn == null || ward_ack_mar_required_yn.equals("")){
				ward_ack_mar_required_yn  = "N";
            }
        } 
		// Added for MMS-KH-CRF-0014 - End
		//added for mms-kh-crf-0016 start
		if(recordSet.containsKey("reconciliation_ip") ){
			reconciliation_ip = (String)recordSet.get("reconciliation_ip");
			
			if (reconciliation_ip == null || reconciliation_ip.equals("")){
				reconciliation_ip  = "";
            }
        }
		//added for mms-kh-crf-0016 end
			//added for mms-kh-crf-0028 start
		if(recordSet.containsKey("review_aprrove_applicable_for_ip") ){ 
			review_aprrove_applicable_for_ip = (String)recordSet.get("review_aprrove_applicable_for_ip");
			
			if (review_aprrove_applicable_for_ip == null || review_aprrove_applicable_for_ip.equals("")){
				review_aprrove_applicable_for_ip  = "N";
            }
        }
		if(recordSet.containsKey("review_aprrove_applicable_for_op") ){ 
			review_aprrove_applicable_for_op  = (String)recordSet.get("review_aprrove_applicable_for_op");
			
			if (review_aprrove_applicable_for_op  == null || review_aprrove_applicable_for_op .equals("")){
				review_aprrove_applicable_for_op  = "N";
            }
        }
		//Added for mms-kh-crf-0028 end
		//added for AAKH-CRF-0117 - start
		if(recordSet.containsKey("approval_no_yn_ip") ){                      //Added for AAKH-CRF-1117
			approval_no_yn_ip = (String)recordSet.get("approval_no_yn_ip");
			
			if (approval_no_yn_ip == null || approval_no_yn_ip.equals("")){
				approval_no_yn_ip  = "N";
            }
        }
		if(recordSet.containsKey("approval_no_yn_op") ){ 
			approval_no_yn_op  = (String)recordSet.get("approval_no_yn_op");
			
			if (approval_no_yn_op  == null || approval_no_yn_op .equals("")){
				approval_no_yn_op  = "N";
            }																//Ended for AAKH-CRF-1117
        }
				//added for AAKH-CRF-0117 - end
		//added for 6041
		 if(recordSet.containsKey("op_disch_med_disp_locn")){
			 op_disch_med_disp_locn = (String)recordSet.get("op_disch_med_disp_locn");
	            if (op_disch_med_disp_locn==null){
	            	op_disch_med_disp_locn="";
	            }
}

		//Added for MMS-DM-CRF-0177 - Start

		if(recordSet.containsKey("pre_alloc_appl_yn")){
			pre_alloc_appl_yn=(String)recordSet.get("pre_alloc_appl_yn");
			
			if (pre_alloc_appl_yn == null || pre_alloc_appl_yn.equals("")){
				pre_alloc_appl_yn  = "N";
            }
		}

		if(recordSet.containsKey("near_expiry_appl_yn")){
			near_expiry_appl_yn=(String)recordSet.get("near_expiry_appl_yn");
			
			if (near_expiry_appl_yn == null){
				near_expiry_appl_yn  = "";
            }
		}
		if(recordSet.containsKey("durn_value")){
			durn_value=(String)recordSet.get("durn_value");
		}
		
		if(recordSet.containsKey("durn_type")){
			durn_type=(String)recordSet.get("durn_type");
			
			if (durn_type == null || durn_type.equals("")){
				durn_type  = "N";
            }
		}
		
		if(recordSet.containsKey("durn_value_in_days")){
			durn_value_in_days=(String)recordSet.get("durn_value_in_days");
		}
		//Added for TFS id:-16341 start
		if(recordSet.containsKey("default_disp_locn")){
			default_disp_locn=(String)recordSet.get("default_disp_locn");
		}
		//Added for TFS id:-16341 end
		//Added for MMS-DM-CRF-0177 - End
		//added for ML-MMOH-CRF-1637 - start
		if(recordSet.containsKey("pat_trans_phar_type")){
			pat_trans_phar_type=(String)recordSet.get("pat_trans_phar_type");
			
			if (pat_trans_phar_type == null || pat_trans_phar_type.equals("")){
				pat_trans_phar_type  = "N";
            }
		}
		if(recordSet.containsKey("pat_trans_other_type")){
			pat_trans_other_type=(String)recordSet.get("pat_trans_other_type");
			
			if (pat_trans_other_type == null || pat_trans_other_type.equals("")){
				pat_trans_other_type  = "N";
            }
		}
		//added for jd-crf-0220 start
		if(recordSet.containsKey("drug_indication_mdry")){
			drug_indication_mdry=(String)recordSet.get("drug_indication_mdry");
			
			if (drug_indication_mdry == null || drug_indication_mdry.equals("")){
				drug_indication_mdry  = "N";
            }
		}
//added for jd-crf-0220 end
if(recordSet.containsKey("disp_auto_refresh")){//Adding start for TH-KW-CRF-0011
			disp_auto_refresh=(String)recordSet.get("disp_auto_refresh");
			
			if (disp_auto_refresh == null){
				 disp_auto_refresh  = "";
            }
		}//Adding end for TH-KW-CRF-0011

		//added for ML-MMOH-CRF-1755
		if(recordSet.containsKey("display_verif_drug_inst_remarks_yn")){
			display_verif_drug_inst_remarks_yn=(String)recordSet.get("display_verif_drug_inst_remarks_yn");
			
			if (display_verif_drug_inst_remarks_yn == null || display_verif_drug_inst_remarks_yn.equals("")){
				display_verif_drug_inst_remarks_yn  = "N";
            }
		}
//added for ml-mmoh-crf-1748 start
				if(recordSet.containsKey("Amend_orderwise_DispMedication_yn")){
					Amend_orderwise_DispMedication_yn=(String)recordSet.get("Amend_orderwise_DispMedication_yn");
					
					if (Amend_orderwise_DispMedication_yn == null || Amend_orderwise_DispMedication_yn.equals("")){
						Amend_orderwise_DispMedication_yn  = "N";
		            }
				}
		//added for ml-mmoh-crf-1748 end


			//ML-BRU-CRF-0630
		 	if(recordSet.containsKey("sensitive_diagnosis_prescriptionreport_yn")){
					do_not_display_sensitive_diagnosis_yn=checkForNull((String)recordSet.get("sensitive_diagnosis_prescriptionreport_yn"));
					
					if (do_not_display_sensitive_diagnosis_yn == null || do_not_display_sensitive_diagnosis_yn.equals("")){
						do_not_display_sensitive_diagnosis_yn  = "N";
		            }
			}
			if(recordSet.containsKey("sensitive_diagnosis_indicator_prescriptionreport_yn")){
					disp_sens_diag_ind_pre_rep_yn=checkForNull((String)recordSet.get("sensitive_diagnosis_indicator_prescriptionreport_yn"));
					
					if (disp_sens_diag_ind_pre_rep_yn == null || disp_sens_diag_ind_pre_rep_yn.equals("")){
						disp_sens_diag_ind_pre_rep_yn  = "N";
		            }
			}
			//Ends of ML-BRU-CRF-0630

			//ML-MMOH-CRF-1823
		 	if(recordSet.containsKey("quota_limit_calculation_required_yn")){
					quota_limit_calculation_required_yn=checkForNull((String)recordSet.get("quota_limit_calculation_required_yn"));
					
					if (quota_limit_calculation_required_yn == null || quota_limit_calculation_required_yn.equals("")){
						quota_limit_calculation_required_yn  = "N";
		            }
			}
			if(recordSet.containsKey("active_prescription_enabled_for_quota_limit_yn")){
					active_prescription_enabled_for_quota_limit_yn=checkForNull((String)recordSet.get("active_prescription_enabled_for_quota_limit_yn"));
					
					if (active_prescription_enabled_for_quota_limit_yn == null || active_prescription_enabled_for_quota_limit_yn.equals("")){
						active_prescription_enabled_for_quota_limit_yn  = "N";
		            }
			}
			//Ends of ML-MMOH-CRF-1823
			
			 //Added for MMS-CRF-0233 by Ayesha Khan
	        if(recordSet.containsKey("print_footer_dtls_pres_yn") ){
	        	print_footer_dtls_pres_yn = checkForNull((String)recordSet.get("print_footer_dtls_pres_yn")) ;
	            if (print_footer_dtls_pres_yn == null || print_footer_dtls_pres_yn.equals("")){
	            	print_footer_dtls_pres_yn   = "N";
	            }
	        }
	        if(recordSet.containsKey("print_pres_dtl_en")){
	        	print_pres_dtl_en =checkForNull( (String)recordSet.get("print_pres_dtl_en"));
	            if (print_pres_dtl_en==null){
	            	print_pres_dtl_en="";
	            }
	        }
	        if(recordSet.containsKey("print_pres_dtl_loc")){
	        	print_pres_dtl_loc =checkForNull( (String)recordSet.get("print_pres_dtl_loc"));
	            if (print_pres_dtl_loc==null){
	            	print_pres_dtl_loc="";
	            }
	        }
	        //Ended for MMS-CRF-0233 by Ayesha Khan

			// Added for NMC-JD-CRF-0197
			if(recordSet.containsKey("always_display_dispense_location_yn")){
					always_display_dispense_location_yn=checkForNull((String)recordSet.get("always_display_dispense_location_yn"));
					
					if (always_display_dispense_location_yn == null || always_display_dispense_location_yn.equals("")){
						always_display_dispense_location_yn  = "N";
		            }
			}
			// Added for NMC-JD-CRF-0197

    }

	public ArrayList loadDefaultDispensingLocation(String locale,String flag){
		ArrayList locationlist=new ArrayList();
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String sql="";
		try{
			con=getConnection();
			if(flag.equals("Direct"))
				sql=PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_DIRECT_DISP_LOCN_SELECT");
			if(flag.equals("External"))
				sql=PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_EXT_PRES_DISP_LOCN_SELECT");
			pst=con.prepareStatement(sql);
			pst.setString(1,login_facility_id);
			pst.setString(2,locale);
			rs=pst.executeQuery();
			while ( rs != null && rs.next() ){
				locationlist.add(rs.getString("DISP_LOCN_CODE"));
				locationlist.add(rs.getString("SHORT_DESC"));
			}
		}
		catch(Exception e){
			locationlist.add("Exception from loadRouteforTransfusion :"+e);
            e.printStackTrace() ;
		}
		finally{
			try{
                closeResultSet( rs ) ;
                closeStatement( pst ) ;
                closeConnection(con);
            }
			catch(Exception es){
				es.printStackTrace() ;
			}
		}
		return locationlist;
	}

	public ArrayList loadDrugDatabaseNames(String locale) {
		ArrayList result = new ArrayList();
 	    Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_PARAM_SELECT7") ) ;
            pstmt.setString(1,locale);
            resultSet = pstmt.executeQuery() ;
            while ( resultSet != null && resultSet.next() ) {
                result.add(resultSet.getString("PRODUCT_ID"));
                result.add(resultSet.getString("PRODUCT_DESC"));                
            }
        } 
		catch ( Exception e ) {
            result.add("Exception from loadRouteforTransfusion :"+e);
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
		return result;
	}

	public String drugDBinterfaceYN(){//this function are used  license key
        String licenseYN="";
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;

        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_DRUG_DB_INTERFACE_YN") ) ;
            resultSet = pstmt.executeQuery() ;

            while ( resultSet != null && resultSet.next()) {
                licenseYN=resultSet.getString("DRUG_DB_INTERFACE_YN");
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
				es.printStackTrace() ;
            }

        }
		return licenseYN;
    }

	public ArrayList getAllDefaultValuesOnLoad(){
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        ArrayList defaultValuesOnLoad = new ArrayList();
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT1")) ;
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
                if ((resultSet.getString("DRUG_ITEM_CODE_LINK_REQD_YN").equals("N"))||(resultSet.getString("DRUG_ITEM_CODE_LINK_REQD_YN").equals("X"))){
                    defaultValuesOnLoad.add("N");
                }
                else{
                    defaultValuesOnLoad.add("Y");
                }
                defaultValuesOnLoad.add(resultSet.getString("REFILL_YN"));
                defaultValuesOnLoad.add(resultSet.getString("MAX_REFILLS_FOR_PRES"));
                defaultValuesOnLoad.add(resultSet.getString("PRINT_REFILL_PRES_WITH_MAIN_YN"));             
                defaultValuesOnLoad.add(resultSet.getString("MAX_DURN_FOR_REFILL_PRES"));
                defaultValuesOnLoad.add(resultSet.getString("DISP_BEFORE_START_DATE_YN"));
                defaultValuesOnLoad.add(resultSet.getString("DISP_BEFORE_NO_OF_DAYS"));
                defaultValuesOnLoad.add(resultSet.getString("DISP_BEYOND_EARLIEST_START_YN"));
                defaultValuesOnLoad.add(resultSet.getString("DISP_BEYOND_NO_OF_DAYS"));
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
        return defaultValuesOnLoad;
    }

    public ArrayList checkForBLModuleExistence(){
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        ArrayList BLModuleInstalled = new ArrayList();
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT7")) ;
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null && resultSet.next() ) {
				BLModuleInstalled.add(resultSet.getString("INSTALL_YN"));
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
        return BLModuleInstalled;
    }

	public ArrayList getRoutingOrderOnLoad(String locale) {
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        ArrayList defaultValues1 = new ArrayList();
		ArrayList defaultValues2 = new ArrayList();
		ArrayList defaultValues3 = new ArrayList();
		ArrayList all = new ArrayList();
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT6")) ;
            //pstmt = connection.prepareStatement("SELECT A.DISP_LOCN_CODE ,A.SHORT_DESC FROM PH_DISP_LOCN_LANG_VW A WHERE A.FACILITY_ID=? AND  A.DISP_LOCN_CATEGORY IN ('O','B') and A.DISP_LOCN_TYPE IN ('P','C') AND A.LANGUAGE_ID = ? ORDER BY 2") ;
			pstmt.setString(1,login_facility_id.trim());
            pstmt.setString(2,locale);
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null  ) {
				while(resultSet.next()){
				defaultValues1.add(resultSet.getString("DISP_LOCN_CODE"));
				defaultValues1.add(resultSet.getString("SHORT_DESC"));
				}
            }
			closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;

			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT8")) ;
			//pstmt = connection.prepareStatement("SELECT A.DISP_LOCN_CODE ,A.SHORT_DESC FROM PH_DISP_LOCN_LANG_VW A WHERE A.FACILITY_ID=? AND A.DISP_LOCN_CATEGORY IN ('I','B') and A.DISP_LOCN_TYPE IN ('P','N') AND A.LANGUAGE_ID = ? ORDER BY 2") ;
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,locale);
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null  ) {
				while(resultSet.next()){
				defaultValues2.add(resultSet.getString("DISP_LOCN_CODE"));
				defaultValues2.add(resultSet.getString("SHORT_DESC"));
				}
            }
			closeResultSet( resultSet ) ;
                closeStatement( pstmt ) ;

			//pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT9")) ;
			//pstmt = connection.prepareStatement("SELECT A.DISP_LOCN_CODE ,A.SHORT_DESC FROM PH_DISP_LOCN_LANG_VW A WHERE A.FACILITY_ID=? AND A.DISP_LOCN_CATEGORY IN ('I','O','B') and A.DISP_LOCN_TYPE IN ('P') AND A.LANGUAGE_ID = ? ORDER BY 2") ;
			pstmt = connection.prepareStatement("SELECT A.DISP_LOCN_CODE ,A.SHORT_DESC FROM PH_DISP_LOCN_LANG_VW A WHERE A.FACILITY_ID=? AND A.DISP_LOCN_CATEGORY IN ('O','B') and A.DISP_LOCN_TYPE IN ('P') AND A.LANGUAGE_ID = ? ORDER BY 2");
			pstmt.setString(1,login_facility_id.trim());
			pstmt.setString(2,locale);
            resultSet = pstmt.executeQuery() ;
            if ( resultSet != null  ) {
				while(resultSet.next()){
					defaultValues3.add(resultSet.getString("DISP_LOCN_CODE"));
					defaultValues3.add(resultSet.getString("SHORT_DESC"));
				}
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
		all.add(defaultValues1);
		all.add(defaultValues2);
		all.add(defaultValues3);
        return all;
    }

    public ArrayList checkForIPBLExistence(){
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        ArrayList IPBLcheck = new ArrayList();
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT2")) ;
            resultSet = pstmt.executeQuery() ;
            while (resultSet != null && resultSet.next()){
                IPBLcheck.add(resultSet.getString("MODULE_ID"));
                IPBLcheck.add(resultSet.getInt(2)+"");
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
        return IPBLcheck;
    }

    public boolean checkForPHParamExistence(){
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT4")) ;
            resultSet = pstmt.executeQuery() ;
            if (resultSet != null && resultSet.next()){
                if (resultSet.getInt(1)>0)              {
                    return true;
                }
                else
                    return false;
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
        return false;
    }

	 public ArrayList checkForPHFacilityParamExistenceFdbValues(String facility_id) {
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        ArrayList arrListFbd   =   new ArrayList();
        try {
            connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT12")) ;
            //pstmt = connection.prepareStatement("SELECT DRUG_DB_INTERFACE_YN,DRUG_DB_PRODUCT_ID,DRUG_DB_DOSECHECK_YN,DRUG_DB_DUPTHERAPY_YN,DRUG_DB_INTERACT_CHECK_YN,DRUG_DB_CONTRAIND_CHECK_YN,DRUG_DB_ALLERGY_CHECK_YN FROM PH_FACILITY_PARAM  WHERE FACILITY_ID=?") ;
            pstmt.setString(1,facility_id);
            resultSet = pstmt.executeQuery() ;
            while (resultSet != null && resultSet.next()){
				arrListFbd.add(resultSet.getString("DRUG_DB_INTERFACE_YN"));
				arrListFbd.add(resultSet.getString("DRUG_DB_PRODUCT_ID"));
				arrListFbd.add(resultSet.getString("DRUG_DB_DOSECHECK_YN"));
				arrListFbd.add(resultSet.getString("DRUG_DB_DUPTHERAPY_YN"));
				arrListFbd.add(resultSet.getString("DRUG_DB_INTERACT_CHECK_YN"));
				arrListFbd.add(resultSet.getString("DRUG_DB_CONTRAIND_CHECK_YN"));
				arrListFbd.add(resultSet.getString("DRUG_DB_ALLERGY_CHECK_YN"));

			}
		}
		catch(Exception e){
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
		return arrListFbd;
	 }

    public ArrayList checkForPHFacilityParamExistence(String facility_id){
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        ArrayList arrList   =   new ArrayList();
        try {
            connection = getConnection() ;
			//pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT3"));
			//SQL_PH_FACILITY_PARAM_SELECT3A
			//pstmt = connection.prepareStatement("SELECT FACILITY_ID, INTERFACE_TO_ST_YN, 'N' PAT_INSTR_LOC_LANG_YN, CONSIDER_STOCK_FOR_PRES_YN, ALLOW_PRES_WITHOUT_STOCK_YN, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, DISP_REGN_REQD_YN, DISP_FLNG_REQD_YN, DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, DFLT_LANG_FOR_DISP_LABEL, LABEL_FORMAT_OP, ALLOW_DRUG_RETURN_YN, MAX_DRUG_RETENTION_BEF_RTN, MAX_DURN_FOR_OP_MED_RTN, IP_VERF_YN, IP_FILL_PRD_AHEAD, IP_FILL_PRD_UNIT, IP_FILL_EXCL_PRD_BEHIND, IP_DELV_REQD_YN, TO_CHAR(IP_FILL_DFLT_START_TIME,'HH24:MI') IP_FILL_DFLT_START_TIME, DFLT_LANG_FOR_DISP_LABEL_IP, IP_LABEL_FORMAT, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, INTERFACE_TO_BL_YN,              OP_DISP_LOCN_RTN_ORD,OP_DISP_LOCN_STAT_ORD,IP_DISP_LOCN_RTN_ORD,IP_DISP_LOCN_STAT_ORD,DISCH_MED_DISP_LOCN ,PRINT_BAL_MED_SHEET_OP_YN,DISP_VERF_STAGE,DISP_FILL_STAGE,MED_ADMIN_REQD_YN, VERF_REQD_BEF_MED_ADMIN_YN, REC_ADMIN_WITHIN_HRS, ALLOW_MED_ADMIN_WO_ORD_YN,IP_CONSIDER_STOCK_PRES_YN,IP_PRES_WITHOUT_STOCK_YN,ALLOW_DUPLICATE_DRUG,'Y' ALLOW_MEDN_ORDER_WITHOUT_DIAG,'Y' ALLOW_MEDN_ORDER_WITHOUT_WT,DISP_UNALLOC_DRUGS_AT_DEL_STG,PRINT_EXP_DATE_FOR_EXP_ITEM,IV_ADMIXTURE_APPL_YN,CDR_ADMIXTURE_APPL_YN,TPN_REGIMEN_APPL_YN,TO_CHAR(WORKING_HRS_OF_PREP_ROOM_FROM,'HH24:MI') WORKING_HRS_OF_PREP_ROOM_FROM,TO_CHAR(WORKING_HRS_OF_PREP_ROOM_TO,'HH24:MI') WORKING_HRS_OF_PREP_ROOM_TO,ALERT_PRACTITIONER_YN,VERIFY_TDM_ORDER_YN,TDM_RESULT_TYPE, TDM_RESULT_TYPE_ID ,START_ADR_NO,LAST_ADR_NO,PAT_COUNS_RESULT_TYPE, PAT_COUNS_RESULT_TYPE_ID ,DIR_DISP_ALLOWED, APPL_PT_CLASS, APPL_ENCTRS, HOW_MANY_ENCTRS,  ENCTRS_DTLS_REQD_DUR_DIR_DISP, DUPLICATE_CHECK_AT_ATC_YN,MANDATORY_REM_ON_PRN_FREQ_YN,COMP_RX_APPL_YN, IV_RX_APPL_YN,ONCOLOGY_RX_APPL_YN,TPN_RX_APPL_YN,	TDM_APPL_YN,DC_MAR_APPL_YN,EM_MAR_APPL_YN,IP_MAR_APPL_YN,OP_MAR_APPL_YN,DISP_CHARGE_DTL_IN_DRUG_LKP_YN,DISP_CHARGE_DTL_IN_RX_YN,DISP_PRICE_TYPE_IN_DRUG_LKP, DISCH_MED_MAR_APPL_YN,ADMX_PREP_CHARGES_APPL_YN,SPLIT_BASED_PRIORITY_YN, SPLIT_BASED_DRUG_CLASS_YN,DFLT_DIR_DISP_LOCN,DFLT_EXT_RX_DISP_LOCN FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?") ;
			// pstmt = connection.prepareStatement("SELECT FACILITY_ID, INTERFACE_TO_ST_YN, 'N' PAT_INSTR_LOC_LANG_YN, CONSIDER_STOCK_FOR_PRES_YN, ALLOW_PRES_WITHOUT_STOCK_YN, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, DISP_REGN_REQD_YN, DISP_FLNG_REQD_YN, DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, DFLT_LANG_FOR_DISP_LABEL, LABEL_FORMAT_OP, ALLOW_DRUG_RETURN_YN, MAX_DRUG_RETENTION_BEF_RTN, MAX_DURN_FOR_OP_MED_RTN, IP_VERF_YN, IP_FILL_PRD_AHEAD, IP_FILL_PRD_UNIT, IP_FILL_EXCL_PRD_BEHIND, IP_DELV_REQD_YN, TO_CHAR(IP_FILL_DFLT_START_TIME,'HH24:MI') IP_FILL_DFLT_START_TIME, DFLT_LANG_FOR_DISP_LABEL_IP, IP_LABEL_FORMAT, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, INTERFACE_TO_BL_YN,              OP_DISP_LOCN_RTN_ORD,OP_DISP_LOCN_STAT_ORD,IP_DISP_LOCN_RTN_ORD,IP_DISP_LOCN_STAT_ORD,DISCH_MED_DISP_LOCN ,PRINT_BAL_MED_SHEET_OP_YN,DISP_VERF_STAGE,DISP_FILL_STAGE,MED_ADMIN_REQD_YN, VERF_REQD_BEF_MED_ADMIN_YN, REC_ADMIN_WITHIN_HRS, ALLOW_MED_ADMIN_WO_ORD_YN,IP_CONSIDER_STOCK_PRES_YN,IP_PRES_WITHOUT_STOCK_YN,ALLOW_DUPLICATE_DRUG,'Y' ALLOW_MEDN_ORDER_WITHOUT_DIAG,'Y' ALLOW_MEDN_ORDER_WITHOUT_WT,DISP_UNALLOC_DRUGS_AT_DEL_STG,PRINT_EXP_DATE_FOR_EXP_ITEM,IV_ADMIXTURE_APPL_YN,CDR_ADMIXTURE_APPL_YN,TPN_REGIMEN_APPL_YN,TO_CHAR(WORKING_HRS_OF_PREP_ROOM_FROM,'HH24:MI') WORKING_HRS_OF_PREP_ROOM_FROM,TO_CHAR(WORKING_HRS_OF_PREP_ROOM_TO,'HH24:MI') WORKING_HRS_OF_PREP_ROOM_TO,ALERT_PRACTITIONER_YN,VERIFY_TDM_ORDER_YN,TDM_RESULT_TYPE, TDM_RESULT_TYPE_ID ,START_ADR_NO,LAST_ADR_NO,PAT_COUNS_RESULT_TYPE, PAT_COUNS_RESULT_TYPE_ID ,DIR_DISP_ALLOWED, APPL_PT_CLASS, APPL_ENCTRS, HOW_MANY_ENCTRS,  ENCTRS_DTLS_REQD_DUR_DIR_DISP, DUPLICATE_CHECK_AT_ATC_YN,MANDATORY_REM_ON_PRN_FREQ_YN,COMP_RX_APPL_YN, IV_RX_APPL_YN,ONCOLOGY_RX_APPL_YN,TPN_RX_APPL_YN,	TDM_APPL_YN,DC_MAR_APPL_YN,EM_MAR_APPL_YN,IP_MAR_APPL_YN,OP_MAR_APPL_YN,DISP_CHARGE_DTL_IN_DRUG_LKP_YN,DISP_CHARGE_DTL_IN_RX_YN,DISP_PRICE_TYPE_IN_DRUG_LKP, DISCH_MED_MAR_APPL_YN,ADMX_PREP_CHARGES_APPL_YN,SPLIT_BASED_PRIORITY_YN, SPLIT_BASED_DRUG_CLASS_YN,DFLT_DIR_DISP_LOCN,DFLT_EXT_RX_DISP_LOCN,TPN_SCREENING_FORM_ID,TPN_SCREENING_TYPE,ONCOLOGY_SCREENING_FORM_ID,ONCOLOGY_SCREENING_TYPE,DRUG_CAT_PIN_AUTH_REQD_YN,ALLOW_SHORT_EXPIRY_DRUGS_YN,COPY_PRES_UPTO_NO_OF_DAYS FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?") ;
			//pstmt = connection.prepareStatement("SELECT FACILITY_ID, INTERFACE_TO_ST_YN, 'N' PAT_INSTR_LOC_LANG_YN, CONSIDER_STOCK_FOR_PRES_YN, ALLOW_PRES_WITHOUT_STOCK_YN, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, DISP_REGN_REQD_YN, DISP_FLNG_REQD_YN, DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, DFLT_LANG_FOR_DISP_LABEL, LABEL_FORMAT_OP, ALLOW_DRUG_RETURN_YN, MAX_DRUG_RETENTION_BEF_RTN, MAX_DURN_FOR_OP_MED_RTN, IP_VERF_YN, IP_FILL_PRD_AHEAD, IP_FILL_PRD_UNIT, IP_FILL_EXCL_PRD_BEHIND, IP_DELV_REQD_YN, TO_CHAR(IP_FILL_DFLT_START_TIME,'HH24:MI') IP_FILL_DFLT_START_TIME, DFLT_LANG_FOR_DISP_LABEL_IP, IP_LABEL_FORMAT, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, INTERFACE_TO_BL_YN,              OP_DISP_LOCN_RTN_ORD,OP_DISP_LOCN_STAT_ORD,IP_DISP_LOCN_RTN_ORD,IP_DISP_LOCN_STAT_ORD,DISCH_MED_DISP_LOCN ,PRINT_BAL_MED_SHEET_OP_YN,DISP_VERF_STAGE,DISP_FILL_STAGE,MED_ADMIN_REQD_YN, VERF_REQD_BEF_MED_ADMIN_YN, REC_ADMIN_WITHIN_HRS, ALLOW_MED_ADMIN_WO_ORD_YN,IP_CONSIDER_STOCK_PRES_YN,IP_PRES_WITHOUT_STOCK_YN,ALLOW_DUPLICATE_DRUG, ALLOW_MEDN_ORDER_WITHOUT_DIAG,'Y' ALLOW_MEDN_ORDER_WITHOUT_WT,DISP_UNALLOC_DRUGS_AT_DEL_STG,PRINT_EXP_DATE_FOR_EXP_ITEM,IV_ADMIXTURE_APPL_YN,CDR_ADMIXTURE_APPL_YN,TPN_REGIMEN_APPL_YN,TO_CHAR(WORKING_HRS_OF_PREP_ROOM_FROM,'HH24:MI') WORKING_HRS_OF_PREP_ROOM_FROM,TO_CHAR(WORKING_HRS_OF_PREP_ROOM_TO,'HH24:MI') WORKING_HRS_OF_PREP_ROOM_TO,ALERT_PRACTITIONER_YN,VERIFY_TDM_ORDER_YN,TDM_RESULT_TYPE, TDM_RESULT_TYPE_ID ,START_ADR_NO,LAST_ADR_NO,PAT_COUNS_RESULT_TYPE, PAT_COUNS_RESULT_TYPE_ID ,DIR_DISP_ALLOWED, APPL_PT_CLASS, APPL_ENCTRS, HOW_MANY_ENCTRS,  ENCTRS_DTLS_REQD_DUR_DIR_DISP, DUPLICATE_CHECK_AT_ATC_YN,MANDATORY_REM_ON_PRN_FREQ_YN,COMP_RX_APPL_YN, IV_RX_APPL_YN,ONCOLOGY_RX_APPL_YN,TPN_RX_APPL_YN,	TDM_APPL_YN,DC_MAR_APPL_YN,EM_MAR_APPL_YN,IP_MAR_APPL_YN,OP_MAR_APPL_YN,DISP_CHARGE_DTL_IN_DRUG_LKP_YN,DISP_CHARGE_DTL_IN_RX_YN,DISP_PRICE_TYPE_IN_DRUG_LKP, DISCH_MED_MAR_APPL_YN,ADMX_PREP_CHARGES_APPL_YN,SPLIT_BASED_PRIORITY_YN, SPLIT_BASED_DRUG_CLASS_YN,DFLT_DIR_DISP_LOCN,DFLT_EXT_RX_DISP_LOCN,TPN_SCREENING_FORM_ID,TPN_SCREENING_TYPE,ONCOLOGY_SCREENING_FORM_ID,ONCOLOGY_SCREENING_TYPE,DRUG_CAT_PIN_AUTH_REQD_YN,ALLOW_SHORT_EXPIRY_DRUGS_YN,COPY_PRES_UPTO_NO_OF_DAYS,INCLUDE_ZERO_ALLOC_QTY_ITEMS,REC_ADMIN_AHEAD_PRD, REC_ADMIN_AHEAD_TYPE,IP_DSN_YN,ALLOW_DISP_RECORD_LOCK_YN,PROMPT_ALERT_FPR_PREF_CHK_YN,DEFAULT_PREV_DRUG_SEL,UOM_DISPLAY_IN_TRANS,NARCOTIC_APRVL_FORM_REQ_YN,PRINT_NARCOTIC_FORM_BY_DEFAULT,EDIT_DISP_LABEL_AFTER_DEL FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?") ;
			//IN30118-SCF No: MO-GN-5400. Adding For OutPatient Duplicate Drug in Query.'allow_duplicate_drug_op'
            //pstmt = connection.prepareStatement("SELECT FACILITY_ID, INTERFACE_TO_ST_YN, 'N' PAT_INSTR_LOC_LANG_YN, CONSIDER_STOCK_FOR_PRES_YN, ALLOW_PRES_WITHOUT_STOCK_YN, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, DISP_REGN_REQD_YN, DISP_FLNG_REQD_YN, DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, DFLT_LANG_FOR_DISP_LABEL, LABEL_FORMAT_OP, ALLOW_DRUG_RETURN_YN, MAX_DRUG_RETENTION_BEF_RTN, MAX_DURN_FOR_OP_MED_RTN, IP_VERF_YN, IP_FILL_PRD_AHEAD, IP_FILL_PRD_UNIT, IP_FILL_EXCL_PRD_BEHIND, IP_DELV_REQD_YN, TO_CHAR(IP_FILL_DFLT_START_TIME,'HH24:MI') IP_FILL_DFLT_START_TIME, DFLT_LANG_FOR_DISP_LABEL_IP, IP_LABEL_FORMAT, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, INTERFACE_TO_BL_YN, OP_DISP_LOCN_RTN_ORD, OP_DISP_LOCN_STAT_ORD, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, DISCH_MED_DISP_LOCN, PRINT_BAL_MED_SHEET_OP_YN, DISP_VERF_STAGE, DISP_FILL_STAGE, MED_ADMIN_REQD_YN, VERF_REQD_BEF_MED_ADMIN_YN, REC_ADMIN_WITHIN_HRS, ALLOW_MED_ADMIN_WO_ORD_YN, IP_CONSIDER_STOCK_PRES_YN, IP_PRES_WITHOUT_STOCK_YN, ALLOW_DUPLICATE_DRUG,ALLOW_DUPLICATE_DRUG_OP,ALLOW_MEDN_ORDER_WITHOUT_DIAG,'Y' ALLOW_MEDN_ORDER_WITHOUT_WT, DISP_UNALLOC_DRUGS_AT_DEL_STG, PRINT_EXP_DATE_FOR_EXP_ITEM, IV_ADMIXTURE_APPL_YN, CDR_ADMIXTURE_APPL_YN, TPN_REGIMEN_APPL_YN, TO_CHAR(WORKING_HRS_OF_PREP_ROOM_FROM,'HH24:MI') WORKING_HRS_OF_PREP_ROOM_FROM, TO_CHAR(WORKING_HRS_OF_PREP_ROOM_TO,'HH24:MI') WORKING_HRS_OF_PREP_ROOM_TO,ALERT_PRACTITIONER_YN,VERIFY_TDM_ORDER_YN,TDM_RESULT_TYPE, TDM_RESULT_TYPE_ID ,START_ADR_NO,LAST_ADR_NO,PAT_COUNS_RESULT_TYPE, PAT_COUNS_RESULT_TYPE_ID ,DIR_DISP_ALLOWED, APPL_PT_CLASS, APPL_ENCTRS, HOW_MANY_ENCTRS,  ENCTRS_DTLS_REQD_DUR_DIR_DISP, DUPLICATE_CHECK_AT_ATC_YN,MANDATORY_REM_ON_PRN_FREQ_YN,COMP_RX_APPL_YN, IV_RX_APPL_YN,ONCOLOGY_RX_APPL_YN,TPN_RX_APPL_YN,	TDM_APPL_YN,DC_MAR_APPL_YN,EM_MAR_APPL_YN,IP_MAR_APPL_YN,OP_MAR_APPL_YN,DISP_CHARGE_DTL_IN_DRUG_LKP_YN,DISP_CHARGE_DTL_IN_RX_YN,DISP_PRICE_TYPE_IN_DRUG_LKP, DISCH_MED_MAR_APPL_YN,ADMX_PREP_CHARGES_APPL_YN,SPLIT_BASED_PRIORITY_YN, SPLIT_BASED_DRUG_CLASS_YN, DFLT_DIR_DISP_LOCN, DFLT_EXT_RX_DISP_LOCN, TPN_SCREENING_FORM_ID, TPN_SCREENING_TYPE, ONCOLOGY_SCREENING_FORM_ID, ONCOLOGY_SCREENING_TYPE, DRUG_CAT_PIN_AUTH_REQD_YN, ALLOW_SHORT_EXPIRY_DRUGS_YN, COPY_PRES_UPTO_NO_OF_DAYS, INCLUDE_ZERO_ALLOC_QTY_ITEMS, REC_ADMIN_AHEAD_PRD, REC_ADMIN_AHEAD_TYPE, IP_DSN_YN, ALLOW_DISP_RECORD_LOCK_YN, PROMPT_ALERT_FPR_PREF_CHK_YN, DEFAULT_PREV_DRUG_SEL, UOM_DISPLAY_IN_TRANS, NARCOTIC_APRVL_FORM_REQ_YN, PRINT_NARCOTIC_FORM_BY_DEFAULT, EDIT_DISP_LABEL_AFTER_DEL, RX_QTY_BY_PRES_BASE_UOM_YN, DFLT_IP_FILL_INCR_START_WITH, IP_MAR_RULE_YN,OP_MAR_RULE_YN, DC_MAR_RULE_YN,EM_MAR_RULE_YN, DM_MAR_RULE_YN, ATC_ALLERGY_ALERT_LEVEL,TAB_BASED_GROUP_SORT_DISP,CAN_DISCON_DUP_ORDERS,DISP_EXPIRIED_ORDERS,MAR_AUTH_REQD_YN,ALLOW_MEDN_ORD_WITHOUT_DIAG_DD, PRINT_MAR_LABEL_YN, ALT_DRUG_REMARKS_IND, MAR_SCH_LEVEL_YN, MAR_START_IND, MAR_WEEK_DAY_START, MAR_PAST_DAY, MAR_FUTURE_DAY, MAR_DEFAULT_ORDER_BY , MAR_DISC_DOSE_YN, MAR_IV_COMPL_DT_IND, ALLERGY_CONF_REQD_YN, MAR_DISP_HELD_DISC_ORDERS_YN,DISP_BEFORE_START_DATE_IP_YN,DISP_BEFORE_NO_OF_DAYS_IP,DISP_BEYOND_EARLST_STRT_IP_YN,DISP_BEYOND_NO_OF_DAYS_IP,VERBAL_ORDER_WITNESS_YN,IV_DEFAULT_FREQUENCY, EM_MEDCTN_FWD_IP_YN, CARY_FRWD_ORD_NOFHRS, disp_rx_duration_YN, diag_for_medn_order_by, allow_mar_share_drug_yn, allow_renew_from_chart_summ_yn, can_discon_dup_orders_def_sel,ALLOW_AUTO_DISP_ALT_DRUG_MAR, preview_rx_yn, disp_prev_vital_signs_yn FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?") ;  			
			// This line content regarding to above line History// Added CAN_DISCON_DUP_ORDERS for Bru-HIMS-CRF-265 [IN:032315], DISP_EXPIRIED_ORDERS for ML-BRU-SCF-0636 [IN036826], MAR_AUTH_REQD_YN for RUT-CRF-0035 [IN029926] , ALLOW_MEDN_ORD_WITHOUT_DIAG_DD added for CRF MMS-QH-CRF-0068 [IN:037980] , print_mar_label_yn added for MMS-QH-CRF-0080 [IN:038064],DISP_BEFORE_START_DATE_IP_YN,DISP_BEFORE_NO_OF_DAYS_IP,DISP_BEYOND_EARLST_STRT_IP_YN,DISP_BEYOND_NO_OF_DAYS_IP added for AMS-CRF-0009[IN:030935] //Added VERBAL_ORDER_WITNESS_YN for AAKH-CRF-0023[IN:038259]//Added IV_DEFAULT_FREQUENCY for Bru-HIMS-CRF-384[IN041642] EM_MEDCTN_FWD_IP_YN, CARY_FRWD_ORD_NOFHRS - for Bru-HIMS-CRF-402[IN044065], disp_rx_duration_YN - for Bru-HIMS-CRF-403[IN044541] diag_for_medn_order_by for  MMS-SCF-0325 [IN:048069],ALLOW_RENEW_FROM_CHART_SUMM_YN Added for Bru-HIMS-CRF-400 preview_rx_yn Added for ML-MMOH-CRF-0341 [IN:057179] //Added disp_prev_vital_signs_yn for ML-MMOH-CRF-0346 [IN:057185] 
        	//SKIP_DUPLICATE_ALERT_IP_YN and SKIP_DUPLICATE_ALERT_OP_YNAdded by prathyusha for MO-CRF-20085.1 on 05/18/2016 
          //split_drug_based_auth_yn added for ml-mmoh-crf-0864 
           //ALLOW_ALT_FOR_MEDICAL_ITEM_YN added for ghl-crf-0548
            //WARD_ACK_REQUIRED_YN,WARD_ACK_MAR_REQUIRED_YN added for MMS-KH-CRF-0014
            //REVW_APRROVE_APPLICABLE_FOR_IP,REVW_APRROVE_APPLICABLE_FOR_OP added for mms-kh-crf-0028
            pstmt = connection.prepareStatement("SELECT FACILITY_ID, INTERFACE_TO_ST_YN, 'N' PAT_INSTR_LOC_LANG_YN, CONSIDER_STOCK_FOR_PRES_YN, ALLOW_PRES_WITHOUT_STOCK_YN, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, DISP_REGN_REQD_YN, DISP_FLNG_REQD_YN, DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, DFLT_LANG_FOR_DISP_LABEL, LABEL_FORMAT_OP, ALLOW_DRUG_RETURN_YN, MAX_DRUG_RETENTION_BEF_RTN, MAX_DURN_FOR_OP_MED_RTN, IP_VERF_YN, IP_FILL_PRD_AHEAD, IP_FILL_PRD_UNIT, IP_FILL_EXCL_PRD_BEHIND, IP_DELV_REQD_YN, TO_CHAR(IP_FILL_DFLT_START_TIME,'HH24:MI') IP_FILL_DFLT_START_TIME, DFLT_LANG_FOR_DISP_LABEL_IP, IP_LABEL_FORMAT, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, INTERFACE_TO_BL_YN, OP_DISP_LOCN_RTN_ORD, OP_DISP_LOCN_STAT_ORD, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, DISCH_MED_DISP_LOCN, PRINT_BAL_MED_SHEET_OP_YN, DISP_VERF_STAGE, DISP_FILL_STAGE, MED_ADMIN_REQD_YN, VERF_REQD_BEF_MED_ADMIN_YN, REC_ADMIN_WITHIN_HRS, ALLOW_MED_ADMIN_WO_ORD_YN, IP_CONSIDER_STOCK_PRES_YN, IP_PRES_WITHOUT_STOCK_YN, ALLOW_DUPLICATE_DRUG,ALLOW_DUPLICATE_DRUG_OP,ALLOW_MEDN_ORDER_WITHOUT_DIAG,'Y' ALLOW_MEDN_ORDER_WITHOUT_WT, DISP_UNALLOC_DRUGS_AT_DEL_STG, PRINT_EXP_DATE_FOR_EXP_ITEM, IV_ADMIXTURE_APPL_YN, CDR_ADMIXTURE_APPL_YN, TPN_REGIMEN_APPL_YN, TO_CHAR(WORKING_HRS_OF_PREP_ROOM_FROM,'HH24:MI') WORKING_HRS_OF_PREP_ROOM_FROM, TO_CHAR(WORKING_HRS_OF_PREP_ROOM_TO,'HH24:MI') WORKING_HRS_OF_PREP_ROOM_TO,ALERT_PRACTITIONER_YN,VERIFY_TDM_ORDER_YN,TDM_RESULT_TYPE, TDM_RESULT_TYPE_ID ,START_ADR_NO,LAST_ADR_NO,PAT_COUNS_RESULT_TYPE, PAT_COUNS_RESULT_TYPE_ID ,DIR_DISP_ALLOWED, APPL_PT_CLASS, APPL_ENCTRS, HOW_MANY_ENCTRS,  ENCTRS_DTLS_REQD_DUR_DIR_DISP, DUPLICATE_CHECK_AT_ATC_YN,MANDATORY_REM_ON_PRN_FREQ_YN,COMP_RX_APPL_YN, IV_RX_APPL_YN,ONCOLOGY_RX_APPL_YN,TPN_RX_APPL_YN,	TDM_APPL_YN,DC_MAR_APPL_YN,EM_MAR_APPL_YN,IP_MAR_APPL_YN,OP_MAR_APPL_YN,DISP_CHARGE_DTL_IN_DRUG_LKP_YN,DISP_CHARGE_DTL_IN_RX_YN,DISP_PRICE_TYPE_IN_DRUG_LKP, DISCH_MED_MAR_APPL_YN,ADMX_PREP_CHARGES_APPL_YN,SPLIT_BASED_PRIORITY_YN, SPLIT_BASED_DRUG_CLASS_YN, DFLT_DIR_DISP_LOCN, DFLT_EXT_RX_DISP_LOCN, TPN_SCREENING_FORM_ID, TPN_SCREENING_TYPE, ONCOLOGY_SCREENING_FORM_ID, ONCOLOGY_SCREENING_TYPE, DRUG_CAT_PIN_AUTH_REQD_YN, ALLOW_SHORT_EXPIRY_DRUGS_YN, COPY_PRES_UPTO_NO_OF_DAYS, INCLUDE_ZERO_ALLOC_QTY_ITEMS, REC_ADMIN_AHEAD_PRD, REC_ADMIN_AHEAD_TYPE, IP_DSN_YN, ALLOW_DISP_RECORD_LOCK_YN, PROMPT_ALERT_FPR_PREF_CHK_YN, DEFAULT_PREV_DRUG_SEL, UOM_DISPLAY_IN_TRANS, NARCOTIC_APRVL_FORM_REQ_YN, PRINT_NARCOTIC_FORM_BY_DEFAULT, EDIT_DISP_LABEL_AFTER_DEL, RX_QTY_BY_PRES_BASE_UOM_YN, DFLT_IP_FILL_INCR_START_WITH, IP_MAR_RULE_YN,OP_MAR_RULE_YN, DC_MAR_RULE_YN,EM_MAR_RULE_YN, DM_MAR_RULE_YN, ATC_ALLERGY_ALERT_LEVEL,TAB_BASED_GROUP_SORT_DISP,CAN_DISCON_DUP_ORDERS,DISP_EXPIRIED_ORDERS,MAR_AUTH_REQD_YN,ALLOW_MEDN_ORD_WITHOUT_DIAG_DD, PRINT_MAR_LABEL_YN, ALT_DRUG_REMARKS_IND, MAR_SCH_LEVEL_YN, MAR_START_IND, MAR_WEEK_DAY_START, MAR_PAST_DAY, MAR_FUTURE_DAY, MAR_DEFAULT_ORDER_BY , MAR_DISC_DOSE_YN, MAR_IV_COMPL_DT_IND, ALLERGY_CONF_REQD_YN, MAR_DISP_HELD_DISC_ORDERS_YN,DISP_BEFORE_START_DATE_IP_YN,DISP_BEFORE_NO_OF_DAYS_IP,DISP_BEYOND_EARLST_STRT_IP_YN,DISP_BEYOND_NO_OF_DAYS_IP,VERBAL_ORDER_WITNESS_YN,IV_DEFAULT_FREQUENCY, EM_MEDCTN_FWD_IP_YN, CARY_FRWD_ORD_NOFHRS, disp_rx_duration_YN, diag_for_medn_order_by, allow_mar_share_drug_yn, allow_renew_from_chart_summ_yn, can_discon_dup_orders_def_sel,ALLOW_AUTO_DISP_ALT_DRUG_MAR, preview_rx_yn, disp_prev_vital_signs_yn, DEF_GENERIC_ID, TO_CHAR(OFFICE_HOURS_FROM,'HH24:MI') OFFICE_HOURS_FROM, TO_CHAR(OFFICE_HOURS_TO,'HH24:MI') OFFICE_HOURS_TO,ALLOW_AMEND_ALTERNATE_DRUG_DT,SKIP_DUPLICATE_ALERT_IP_YN,SKIP_DUPLICATE_ALERT_OP_YN,OVERLAP_PERIOD_FOR_OP,OVERLAP_PERIOD_FOR_IP,RET_MEDIC_RESTR_STAGE,SPLIT_DRUG_BASED_AUTH_YN,INCLUDE_ZERO_ALOC_QTY_ITEMS_IP,ASSESMENT_REQ_YN,EARLY_OR_LATE_ADMIN_YN,ALLOW_ALT_FOR_MEDICAL_ITEM_YN,WARD_ACK_REQUIRED_YN,WARD_ACK_MAR_REQUIRED_YN,GENERIC_NAME_DISPLY_YN,RECONCILIATION_YN,REVW_APRROVE_APPLICABLE_FOR_IP,REVW_APRROVE_APPLICABLE_FOR_OP,APPROVAL_NO_APPL_IP,APPROVAL_NO_APPL_OP,OP_DISCH_MED_DISP_LOCN,PRE_ALLOC_APPL,NEAR_EXPIRY_APPL,DURN_VALUE,DURN_TYPE,DURN_VALUE_IN_DAYS,DFLT_DISP_LOCN,PAT_TRANSFER_PHAR_TYPE,PAT_TRANSFER_OTHER_TYPE,DRUG_INDICATION_MDRY,DISP_AUTO_REFRESH,DISP_VERI_REM_DRUG_INST,AMEND_ORD_WISE_DISP_MED,DISP_SENS_DIAG_PRE_REP_YN, DISP_SENS_DIAG_IND_PRE_REP_YN,mar_disp_unbilled_med_yn,QUOTA_LIMIT_CALC_REQ_YN,ACITVE_PREP_APPL_QUOTA_YN,PRINT_FOOTER_DTLS_PRES_YN,PRINT_PRES_DTL_EN,PRINT_PRES_DTL_LOC,ALW_DISP_LOC_DRUG_SEARCH_YN FROM PH_FACILITY_PARAM WHERE FACILITY_ID=?") ;  // ASSESMENT_REQ_YN Added for ML-MMOH-CRF-1126 // EARLY_OR_LATE_ADMIN_YN Added for GHL-CRF-0482 [IN:064955] //GENERIC_NAME_DISPLY_YN added for NMC-JD-CRF-0001 and APPROVAL_NO_APPL_IP,APPROVAL_NO_APPL_OP added for AAKH-CRF-0117 //PRE_ALLOC_APPL,NEAR_EXPIRY_APPL, DURN_VALUE, DURN_TYPE,DURN_VALUE_IN_DAYS added for MMS-DM-CRF-0177,Modified for TFS id:-16341 added DFLT_DISP_LOCN 
			//Added DEF_GENERIC_ID,OFFICE_HOURS_FROM,OFFICE_HOURS_TO for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016 Allow_Amend_Alternate_Drug_Dt Added by prathyusha for JD-CRF-198 on 05/05/2016 // RET_MEDIC_RESTR_STAGE Added for GHL-CRF-0412.3//INCLUDE_ZERO_ALOC_QTY_ITEMS_IP Added for ML-BRU-CRF-0473
			//PAT_TRANSFER_PHAR_TYPE,PAT_TRANSFER_OTHER_TYPE added for ML-MMOH-CRF-1637, DISP_VERI_REM_DRUG_INST added for ML-MMOH-CRF-1755 // DISP_SENS_DIAG_PRE_REP_YN, DISP_SENS_DIAG_IND_PRE_REP_YN  added for ML-BRU-CRF-0630
			//QUOTA_LIMIT_CALC_REQ_YN,ACITVE_PREP_APPL_QUOTA_YN added for ML-MMOH-CRF-1823,ALW_DISP_LOC_DRUG_SEARCH_YN added for NMC-JD-CRF-0197
			pstmt.setString(1,facility_id);
            resultSet = pstmt.executeQuery() ;
 
            if (resultSet != null && resultSet.next()){
                arrList.add(resultSet.getString("INTERFACE_TO_ST_YN"));
                arrList.add(resultSet.getString("PAT_INSTR_LOC_LANG_YN"));
                arrList.add(resultSet.getString("CONSIDER_STOCK_FOR_PRES_YN"));
                arrList.add(resultSet.getString("ALLOW_PRES_WITHOUT_STOCK_YN"));
                arrList.add(resultSet.getString("REFILL_YN"));
                arrList.add(resultSet.getString("MAX_REFILLS_FOR_PRES"));
                arrList.add(resultSet.getString("PRINT_REFILL_PRES_WITH_MAIN_YN"));
                
                arrList.add(resultSet.getString("MAX_DURN_FOR_REFILL_PRES"));
                arrList.add(resultSet.getString("DISP_BEFORE_START_DATE_YN"));
                arrList.add(resultSet.getString("DISP_BEFORE_NO_OF_DAYS"));
                arrList.add(resultSet.getString("DISP_BEYOND_EARLIEST_START_YN"));
                arrList.add(resultSet.getString("DISP_BEYOND_NO_OF_DAYS"));
                arrList.add(resultSet.getString("DISP_REGN_REQD_YN"));
                arrList.add(resultSet.getString("DISP_FLNG_REQD_YN"));
                arrList.add(resultSet.getString("DISP_DELV_REQD_YN"));
               // arrList.add(resultSet.getString("DISP_CASH_COLL_STAGE"));
                arrList.add(resultSet.getString("PRINT_DISP_SHEET_OP_YN"));
                arrList.add(resultSet.getString("DFLT_LANG_FOR_DISP_LABEL"));
                arrList.add(resultSet.getString("LABEL_FORMAT_OP"));
                arrList.add(resultSet.getString("ALLOW_DRUG_RETURN_YN"));
                arrList.add(resultSet.getString("MAX_DRUG_RETENTION_BEF_RTN"));
                arrList.add(resultSet.getString("MAX_DURN_FOR_OP_MED_RTN"));
                arrList.add(resultSet.getString("IP_VERF_YN"));
                arrList.add(resultSet.getString("IP_FILL_PRD_AHEAD"));
                arrList.add(resultSet.getString("IP_FILL_EXCL_PRD_BEHIND"));
                arrList.add(resultSet.getString("IP_DELV_REQD_YN"));
                arrList.add(resultSet.getString("IP_FILL_DFLT_START_TIME"));
                arrList.add(resultSet.getString("DFLT_LANG_FOR_DISP_LABEL_IP"));
                arrList.add(resultSet.getString("IP_LABEL_FORMAT"));
				arrList.add(resultSet.getString("OP_DISP_LOCN_RTN_ORD"));
				arrList.add(resultSet.getString("OP_DISP_LOCN_STAT_ORD"));
                arrList.add(resultSet.getString("IP_DISP_LOCN_RTN_ORD"));
                arrList.add(resultSet.getString("IP_DISP_LOCN_STAT_ORD"));
				arrList.add(resultSet.getString("DISCH_MED_DISP_LOCN"));
				arrList.add(resultSet.getString("PRINT_BAL_MED_SHEET_OP_YN"));
				arrList.add(resultSet.getString("DISP_VERF_STAGE"));
				arrList.add(resultSet.getString("DISP_FILL_STAGE"));
				//arrList.add(resultSet.getString("ALLOW_USAGE_OF_SPIL_QTY_YN"));
				//arrList.add(resultSet.getString("CHARGE_QTY_IND"));
				arrList.add(resultSet.getString("MED_ADMIN_REQD_YN"));
				arrList.add(resultSet.getString("VERF_REQD_BEF_MED_ADMIN_YN"));
				arrList.add(resultSet.getString("REC_ADMIN_WITHIN_HRS"));
				arrList.add(resultSet.getString("ALLOW_MED_ADMIN_WO_ORD_YN"));
				arrList.add(resultSet.getString("IP_FILL_PRD_UNIT"));
				arrList.add(resultSet.getString("IP_CONSIDER_STOCK_PRES_YN"));
                arrList.add(resultSet.getString("IP_PRES_WITHOUT_STOCK_YN"));
				arrList.add(resultSet.getString("ALLOW_DUPLICATE_DRUG"));
				arrList.add(resultSet.getString("ALLOW_MEDN_ORDER_WITHOUT_DIAG"));
				arrList.add(resultSet.getString("ALLOW_MEDN_ORDER_WITHOUT_WT"));
				//code added for unallocate orders....
				arrList.add(resultSet.getString("DISP_UNALLOC_DRUGS_AT_DEL_STG"));
				arrList.add(resultSet.getString("PRINT_EXP_DATE_FOR_EXP_ITEM"));
				//code added on 19/11/04 
				arrList.add(resultSet.getString("IV_ADMIXTURE_APPL_YN"));
				arrList.add(resultSet.getString("CDR_ADMIXTURE_APPL_YN"));
				arrList.add(resultSet.getString("TPN_REGIMEN_APPL_YN"));
				arrList.add(resultSet.getString("WORKING_HRS_OF_PREP_ROOM_FROM"));
				arrList.add(resultSet.getString("WORKING_HRS_OF_PREP_ROOM_TO"));
				arrList.add(resultSet.getString("ALERT_PRACTITIONER_YN"));
				arrList.add(resultSet.getString("VERIFY_TDM_ORDER_YN"));
				arrList.add(resultSet.getString("TDM_RESULT_TYPE_ID"));
				arrList.add(resultSet.getString("START_ADR_NO"));
				arrList.add(resultSet.getString("LAST_ADR_NO"));
				arrList.add(resultSet.getString("PAT_COUNS_RESULT_TYPE_ID"));
				arrList.add(resultSet.getString("DIR_DISP_ALLOWED"));
				arrList.add(resultSet.getString("APPL_PT_CLASS"));
				arrList.add(resultSet.getString("APPL_ENCTRS"));
				arrList.add(resultSet.getString("HOW_MANY_ENCTRS"));
				arrList.add(resultSet.getString("ENCTRS_DTLS_REQD_DUR_DIR_DISP"));
				arrList.add(resultSet.getString("DUPLICATE_CHECK_AT_ATC_YN"));  

	            arrList.add(resultSet.getString("MANDATORY_REM_ON_PRN_FREQ_YN")); 
				
				arrList.add(resultSet.getString("COMP_RX_APPL_YN"));
				arrList.add(resultSet.getString("IV_RX_APPL_YN"));
				arrList.add(resultSet.getString("ONCOLOGY_RX_APPL_YN"));
				arrList.add(resultSet.getString("TPN_RX_APPL_YN"));  
				arrList.add(resultSet.getString("TDM_APPL_YN"));
				arrList.add(resultSet.getString("TDM_RESULT_TYPE"));  
				arrList.add(resultSet.getString("PAT_COUNS_RESULT_TYPE"));
				//code added on 07/02/07
				arrList.add(resultSet.getString("DC_MAR_APPL_YN"));
				arrList.add(resultSet.getString("EM_MAR_APPL_YN"));
				arrList.add(resultSet.getString("IP_MAR_APPL_YN"));
				arrList.add(resultSet.getString("OP_MAR_APPL_YN"));
// @ following 3 fields added for enhancement
				arrList.add(resultSet.getString("DISP_CHARGE_DTL_IN_DRUG_LKP_YN"));
				arrList.add(resultSet.getString("DISP_CHARGE_DTL_IN_RX_YN"));
				arrList.add(resultSet.getString("DISP_PRICE_TYPE_IN_DRUG_LKP"));
				arrList.add(resultSet.getString("Disch_Med_Mar_Appl_yn"));
				arrList.add(resultSet.getString("ADMX_PREP_CHARGES_APPL_YN"));
// following 2 fields added for enhancement
				arrList.add(resultSet.getString("SPLIT_BASED_PRIORITY_YN"));
                arrList.add(resultSet.getString("SPLIT_BASED_DRUG_CLASS_YN"));
                arrList.add(resultSet.getString("DFLT_DIR_DISP_LOCN"));
                arrList.add(resultSet.getString("DFLT_EXT_RX_DISP_LOCN"));
				arrList.add(resultSet.getString("TPN_SCREENING_FORM_ID"));
				arrList.add(resultSet.getString("TPN_SCREENING_TYPE"));
				arrList.add(resultSet.getString("ONCOLOGY_SCREENING_FORM_ID"));
				arrList.add(resultSet.getString("ONCOLOGY_SCREENING_TYPE"));
				arrList.add(resultSet.getString("DRUG_CAT_PIN_AUTH_REQD_YN"));
				
				arrList.add(resultSet.getString("ALLOW_SHORT_EXPIRY_DRUGS_YN"));
				arrList.add(resultSet.getString("COPY_PRES_UPTO_NO_OF_DAYS"));
				arrList.add(resultSet.getString("INCLUDE_ZERO_ALLOC_QTY_ITEMS"));//added for INCLUDE ZERO ALLOC ITEMS on 07-03-09
				arrList.add(resultSet.getString("REC_ADMIN_AHEAD_PRD"));
				arrList.add(resultSet.getString("REC_ADMIN_AHEAD_TYPE"));
				arrList.add(resultSet.getString("IP_DSN_YN"));
				arrList.add(resultSet.getString("ALLOW_DISP_RECORD_LOCK_YN"));//Added for CRF-0439
				arrList.add(resultSet.getString("PROMPT_ALERT_FPR_PREF_CHK_YN"));//Added for CRF-711 --INC 12669
				arrList.add(resultSet.getString("DEFAULT_PREV_DRUG_SEL")); //Added for CRF-641
				arrList.add(resultSet.getString("UOM_DISPLAY_IN_TRANS")); //Added for CRF-749 displaying UOM in transactions
				//Added CRF-713 INC 12785 
				arrList.add(resultSet.getString("NARCOTIC_APRVL_FORM_REQ_YN")); 
				arrList.add(resultSet.getString("PRINT_NARCOTIC_FORM_BY_DEFAULT")); //102
				arrList.add(resultSet.getString("EDIT_DISP_LABEL_AFTER_DEL"));//103
				arrList.add(resultSet.getString("RX_QTY_BY_PRES_BASE_UOM_YN"));//104
				arrList.add(resultSet.getString("DFLT_IP_FILL_INCR_START_WITH"));//105  Added for PMG20089-CRF-0675 to default the start time for Incremental IP Fill Process
				arrList.add(resultSet.getString("IP_MAR_RULE_YN"));//106  for InPatient Rule Based Check box
				arrList.add(resultSet.getString("OP_MAR_RULE_YN"));//107  for OutPatient Rule Based Check box
				arrList.add(resultSet.getString("DC_MAR_RULE_YN"));//108  for DayCare Rule Based Check box
				arrList.add(resultSet.getString("EM_MAR_RULE_YN"));//109  for Emergency Rule Based Check box
				arrList.add(resultSet.getString("DM_MAR_RULE_YN"));//110  for DischargeMedication Rule Based Check box
				arrList.add(resultSet.getString("atc_allergy_alert_level"));//111  for atc_allergy_alert_level 
				arrList.add(resultSet.getString("tab_based_group_sort_disp"));//112  for TAB_BASED_GROUP_SORT_DISP 
				arrList.add(resultSet.getString("ALLOW_DUPLICATE_DRUG_OP"));// 113 IN30118-SCF No: MO-GN-5400. For OutPatient Duplicate Drug Check.
				arrList.add(resultSet.getString("CAN_DISCON_DUP_ORDERS"));//114 added for Bru-HIMS-CRF-265 [IN:032315]
				arrList.add(resultSet.getString("DISP_EXPIRIED_ORDERS"));//115 added for ML-BRU-SCF-0636 [IN036826]
				arrList.add(resultSet.getString("MAR_AUTH_REQD_YN"));//116 added for RUT-CRF-0035 [IN029926]
                arrList.add(resultSet.getString("ALLOW_MEDN_ORD_WITHOUT_DIAG_DD"));//117 added for CRF MMS-QH-CRF-0068 [IN:037980]
                arrList.add(resultSet.getString("PRINT_MAR_LABEL_YN"));//118 added for MMS-QH-CRF-0080 [IN:038064]
                arrList.add(resultSet.getString("ALT_DRUG_REMARKS_IND"));//119 added for  Bru-HIMS-CRF-082 [IN:029948] 
                arrList.add(resultSet.getString("MAR_SCH_LEVEL_YN"));//120 added for SKR-CRF-0037 [IN:037656]  -start
                arrList.add(resultSet.getString("MAR_START_IND"));
                arrList.add(resultSet.getString("MAR_WEEK_DAY_START"));
                arrList.add(resultSet.getString("MAR_PAST_DAY"));
                arrList.add(resultSet.getString("MAR_FUTURE_DAY"));
                arrList.add(resultSet.getString("MAR_DEFAULT_ORDER_BY"));
                arrList.add(resultSet.getString("MAR_DISC_DOSE_YN"));
                arrList.add(resultSet.getString("MAR_IV_COMPL_DT_IND")); //127 added for SKR-CRF-0037 [IN:037656]  -end				
                arrList.add(resultSet.getString("ALLERGY_CONF_REQD_YN")); //128 added for RUT-CRF-0064.1 [IN:041799]				
                arrList.add(resultSet.getString("MAR_DISP_HELD_DISC_ORDERS_YN")); //129 //added for [IN:043283] 
                arrList.add(resultSet.getString("DISP_BEFORE_START_DATE_IP_YN"));//added for AMS-CRF-0009[IN:030935] -start
                arrList.add(resultSet.getString("DISP_BEFORE_NO_OF_DAYS_IP"));
                arrList.add(resultSet.getString("DISP_BEYOND_EARLST_STRT_IP_YN"));
                arrList.add(resultSet.getString("DISP_BEYOND_NO_OF_DAYS_IP"));  //added for AMS-CRF-0009[IN:030935] -end
				arrList.add(resultSet.getString("VERBAL_ORDER_WITNESS_YN")); //134//Added for AAKH-CRF-0023[IN:038259]
				arrList.add(checkForNull(resultSet.getString("IV_DEFAULT_FREQUENCY"))); //135//Added for Bru-HIMS-CRF-384[IN041642]
				arrList.add(checkForNull(resultSet.getString("EM_MEDCTN_FWD_IP_YN"), "N")); //136 //Added for Bru-HIMS-CRF-402[IN044065]
				arrList.add(checkForNull(resultSet.getString("CARY_FRWD_ORD_NOFHRS"), "")); //137 //Added for Bru-HIMS-CRF-402[IN044065]
				arrList.add(checkForNull(resultSet.getString("disp_rx_duration_YN"), "N")); //138 //Added for Bru-HIMS-CRF-403[IN044541]
				arrList.add(checkForNull(resultSet.getString("diag_for_medn_order_by"), "N")); //139 //Added for  MMS-SCF-0325 [IN:048069]
				arrList.add(checkForNull(resultSet.getString("allow_mar_share_drug_yn"), "N")); //140 //added for HSA-CRF-0090 [IN:041241]
				arrList.add(checkForNull(resultSet.getString("ALLOW_RENEW_FROM_CHART_SUMM_YN"), "N"));//141 Added for Bru-HIMS-CRF-400
				arrList.add(checkForNull(resultSet.getString("CAN_DISCON_DUP_ORDERS_DEF_SEL"), "N"));//142 Added for HSA-CRF-0151 [IN048468]
				arrList.add(checkForNull(resultSet.getString("ALLOW_AUTO_DISP_ALT_DRUG_MAR"), "N"));//143 //Added for Bru-HIMS-CRF-399 [IN:043767]
				arrList.add(checkForNull(resultSet.getString("PREVIEW_RX_YN"), "N"));//144 //Added for ML-MMOH-CRF-0341 [IN:057179]
				arrList.add(checkForNull(resultSet.getString("DISP_PREV_VITAL_SIGNS_YN"), "N"));//145 //Added for ML-MMOH-CRF-0346 [IN:057185]
				arrList.add(checkForNull(resultSet.getString("DEF_GENERIC_ID")));//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
				arrList.add(checkForNull(resultSet.getString("OFFICE_HOURS_FROM")));//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
				arrList.add(checkForNull(resultSet.getString("OFFICE_HOURS_TO")));//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
		    	arrList.add(checkForNull(resultSet.getString("ALLOW_AMEND_ALTERNATE_DRUG_DT")));//Allow_Amend_Alternate_Drug_Dt Added by prathyusha for JD-CRF-198 on 05/05/2016
		    	//Added by prathyusha for MO-CRF-20085.1 on 05/18/2016 start
		    	arrList.add(checkForNull(resultSet.getString("SKIP_DUPLICATE_ALERT_IP_YN")));
		    	arrList.add(checkForNull(resultSet.getString("SKIP_DUPLICATE_ALERT_OP_YN")));
				//Added by prathyusha for MO-CRF-20085.1 on 05/18/2016 end
		    	
		    	//Added by prathyusha for MO-CRF-20085.1 on 05/18/2016 start
		    	arrList.add(checkForNull(resultSet.getString("OVERLAP_PERIOD_FOR_OP")));
		    	arrList.add(checkForNull(resultSet.getString("OVERLAP_PERIOD_FOR_IP")));
		    	arrList.add(checkForNull(resultSet.getString("RET_MEDIC_RESTR_STAGE"))); // Added for GHL-CRF-0412.3
		    	arrList.add(checkForNull(resultSet.getString("SPLIT_DRUG_BASED_AUTH_YN")));//split_drug_based_auth_yn added for ml-mmoh-crf-0864 
                arrList.add(checkForNull(resultSet.getString("INCLUDE_ZERO_ALOC_QTY_ITEMS_IP")));//Added for ML-BRU-CRF-0473
                arrList.add(checkForNull(resultSet.getString("ASSESMENT_REQ_YN"))); // Added for ML-MMOH-CRF-1126
                arrList.add(checkForNull(resultSet.getString("EARLY_OR_LATE_ADMIN_YN"))); // Added for GHL-CRF-0482 [IN:064955]
                arrList.add(checkForNull(resultSet.getString("ALLOW_ALT_FOR_MEDICAL_ITEM_YN"))); // Added for GHL-CRF-0548
                arrList.add(checkForNull(resultSet.getString("WARD_ACK_REQUIRED_YN"))); // added for MMS-KH-CRF-0014
                arrList.add(checkForNull(resultSet.getString("WARD_ACK_MAR_REQUIRED_YN"))); // added for MMS-KH-CRF-0014
                arrList.add(checkForNull(resultSet.getString("GENERIC_NAME_DISPLY_YN"))); // Added for NMC-JD-CRF-0001
				arrList.add(checkForNull(resultSet.getString("RECONCILIATION_YN"))); // Added for MMS-KH-CRF-0016
				arrList.add(checkForNull(resultSet.getString("REVW_APRROVE_APPLICABLE_FOR_IP"))); // Added for MMS-KH-CRF-0028
                arrList.add(checkForNull(resultSet.getString("REVW_APRROVE_APPLICABLE_FOR_OP"))); // Added for MMS-KH-CRF-0028
                arrList.add(checkForNull(resultSet.getString("APPROVAL_NO_APPL_IP"))); // Added for AAKH-CRF-1117
                arrList.add(checkForNull(resultSet.getString("APPROVAL_NO_APPL_OP"))); // Added for AAKH-CRF-0117
				arrList.add(checkForNull(resultSet.getString("OP_DISCH_MED_DISP_LOCN")));
                arrList.add(checkForNull(resultSet.getString("PRE_ALLOC_APPL"))); //Added for MMS-DM-CRF-0177
                arrList.add(checkForNull(resultSet.getString("NEAR_EXPIRY_APPL"))); //Added for MMS-DM-CRF-0177
                arrList.add(checkForNull(resultSet.getString("DURN_VALUE"))); //Added for MMS-DM-CRF-0177
                arrList.add(checkForNull(resultSet.getString("DURN_TYPE"))); //Added for MMS-DM-CRF-0177
                arrList.add(checkForNull(resultSet.getString("DURN_VALUE_IN_DAYS"))); //Added for MMS-DM-CRF-0177
                arrList.add(checkForNull(resultSet.getString("DFLT_DISP_LOCN")));//Added for TFS id:-16341
				
				arrList.add(checkForNull(resultSet.getString("PAT_TRANSFER_PHAR_TYPE")));//added for ML-MMOH-CRF-1637
				arrList.add(checkForNull(resultSet.getString("PAT_TRANSFER_OTHER_TYPE")));//added for ML-MMOH-CRF-1637
				arrList.add(checkForNull(resultSet.getString("DRUG_INDICATION_MDRY")));//added for JD-CRF-0220
				arrList.add(checkForNull(resultSet.getString("DISP_AUTO_REFRESH")));//Added for TH-KW-CRF-0011
				arrList.add(checkForNull(resultSet.getString("DISP_VERI_REM_DRUG_INST")));//added for ML-MMOH-CRF-1755
				arrList.add(checkForNull(resultSet.getString("AMEND_ORD_WISE_DISP_MED")));//added for ml-mmoh-crf-1748
				arrList.add(checkForNull(resultSet.getString("DISP_SENS_DIAG_PRE_REP_YN")));//added for ML-BRU-CRF-0630
				arrList.add(checkForNull(resultSet.getString("DISP_SENS_DIAG_IND_PRE_REP_YN")));//added for ML-BRU-CRF-0630
			   	arrList.add(checkForNull(resultSet.getString("MAR_DISP_UNBILLED_MED_YN"), "N")); //added for NMC-JD-CRF-0186  <!-- 42911 -->
				arrList.add(checkForNull(resultSet.getString("QUOTA_LIMIT_CALC_REQ_YN"), "N")); //added for ML-MMOH-CRF-1823
				arrList.add(checkForNull(resultSet.getString("ACITVE_PREP_APPL_QUOTA_YN"), "N")); //added for ML-MMOH-CRF-1823 
				// Added By Ayesha  for MMS-DM-CRF-0233
				//arrList.add(checkForNull(resultSet.getString("PRINT_FOOTER_DTLS_PRES_YN"), "N"));
				arrList.add(checkForNull(resultSet.getString("PRINT_PRES_DTL_EN"))); //186
				arrList.add(checkForNull(resultSet.getString("PRINT_PRES_DTL_LOC"))); //187
				arrList.add(checkForNull(resultSet.getString("PRINT_FOOTER_DTLS_PRES_YN"))); // 188 Added for MMS-CRF-0233 by Ayesha Khan
				arrList.add(checkForNull(resultSet.getString("ALW_DISP_LOC_DRUG_SEARCH_YN"), "N")); //189 added for NMC-JD-CRF-0197 
				
			 
				
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
        return arrList;
    }

    public HashMap modify() {
        StringBuffer debug =new StringBuffer();
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        ArrayList modifyData = new ArrayList() ;
        modifyData.add( interface_to_st_yn.trim());
        modifyData.add( pat_instr_loc_lang_yn.trim());
        modifyData.add( consider_stock_for_pres_yn.trim());
        modifyData.add( allow_pres_without_stock_yn.trim());
        modifyData.add( refill_yn.trim());
        modifyData.add( max_refills_for_pres.trim());
        modifyData.add( print_refill_pres_with_main_yn.trim());
        modifyData.add( max_durn_for_refill_pres.trim());
        modifyData.add( disp_before_start_date_yn.trim());
        modifyData.add( disp_before_no_of_days.trim());
        modifyData.add( disp_beyond_earliest_start_yn.trim());
        modifyData.add( disp_beyond_no_of_days.trim());
        modifyData.add( disp_flng_reqd_yn.trim());
		modifyData.add( disp_fill_stage.trim());
        modifyData.add( disp_delv_reqd_yn.trim());
       // modifyData.add( disp_cash_coll_stage.trim());

        modifyData.add( print_disp_sheet_op_yn.trim());
        modifyData.add( dflt_lang_for_disp_label.trim());
        modifyData.add( label_format_op.trim());
        modifyData.add( allow_drug_return_yn.trim());
        modifyData.add( max_drug_retention_bef_rtn.trim());
        modifyData.add( max_durn_for_op_med_rtn.trim());
        modifyData.add( ip_verf_yn.trim());
        modifyData.add( ip_fill_prd_unit.trim());
        modifyData.add( ip_fill_prd_ahead.trim());
        modifyData.add( ip_fill_excl_prd_behind.trim());
        modifyData.add( ip_delv_reqd_yn.trim());
        modifyData.add( ip_fill_dflt_start_time.trim());
        modifyData.add( dflt_lang_for_disp_label_ip.trim());
		modifyData.add( ip_label_format.trim());
		modifyData.add( interface_to_bl_yn.trim());
		modifyData.add( op_disp_locn_rtn_ord.trim());
		modifyData.add( op_disp_locn_stat_ord.trim());
		modifyData.add( disp_regn_reqd_yn.trim());
		modifyData.add( disp_verf_stage.trim());
		modifyData.add( print_bal_med_sheet_op_yn.trim());
		modifyData.add( ip_disp_locn_rtn_ord.trim());
		modifyData.add( ip_disp_locn_stat_ord.trim());
		modifyData.add( disch_med_disp_locn.trim());
		modifyData.add( login_by_id.trim());
		modifyData.add(	login_at_ws_no.trim());
		modifyData.add( login_facility_id.trim());
		modifyData.add( iv_admixture_appl_yn.trim());
		modifyData.add( cdr_admixture_appl_yn.trim());
		modifyData.add( tpn_regimen_appl_yn.trim());
		modifyData.add( working_hours_room_from.trim());
		modifyData.add( working_hours_room_to.trim());
		modifyData.add( alert_practitioner_yn.trim());
		modifyData.add(verify_tdm_order_yn);
		modifyData.add(tdm_reporting_id);
		modifyData.add(pat_couns_reporting_id);
		modifyData.add(start_adr_no);
		modifyData.add(last_adr_no);

		//if(allow_usage_of_spil_qty_yn.equals("")){
			//allow_usage_of_spil_qty_yn ="N";
		//}

		if(verf_reqd_bef_med_admin_yn.equals("")){
			verf_reqd_bef_med_admin_yn ="N";
		}
		if(witness_for_verbal_order_yn.equals("")){ // Added for AAKH-CRF-0023[IN:038259]
			witness_for_verbal_order_yn ="N";
		}		// Added for AAKH-CRF-0023[IN:038259]
		if(allow_med_admin_wo_ord_yn.equals("")){
			allow_med_admin_wo_ord_yn = "N";
			witness_for_verbal_order_yn = "N";		// Added for AAKH-CRF-0023[IN:038259]
		}

		//modifyData.add( allow_usage_of_spil_qty_yn.trim());
		//modifyData.add( charge_qty_ind.trim());
        if(med_admin_reqd_yn.equals("")){
			med_admin_reqd_yn = "N";
		}
		modifyData.add( med_admin_reqd_yn.trim());
		modifyData.add( verf_reqd_bef_med_admin_yn.trim());
		modifyData.add( rec_admin_within_hrs.trim());
		modifyData.add( allow_med_admin_wo_ord_yn.trim());
		modifyData.add( ip_consider_stock );	
		modifyData.add( ip_allow_stock );	
		modifyData.add( allow_duplicate_drug );
		modifyData.add( allow_medn_order_without_diag);
		modifyData.add( allow_medn_order_without_wt);
		//code add for unalloacted orders....on 29/4/2004
		modifyData.add( unalloc_order_del_st);
		modifyData.add( print_exp_date_on_lbl);
		modifyData.add( direct_dispensing_allowed);
		modifyData.add( patientclass.trim());
		modifyData.add( applicable_encounter.trim());
		modifyData.add(	consider_last.trim()) ;
		modifyData.add( encounter_details_required.trim());
		modifyData.add(duplicate_check_atc.trim());
		modifyData.add(remarks_for_prn.trim());

		modifyData.add( comp_rx_appl_yn.trim());
		modifyData.add(	iv_rx_appl_yn.trim()) ;
		modifyData.add( oncology_rx_appl_yn.trim());
		modifyData.add( tpn_rx_appl_yn.trim());
		modifyData.add( tdm_appl_yn.trim());
		modifyData.add(tdm_result_type);
       	modifyData.add(pat_couns_result_type);

       if(drug_db_interface_yn.equals("")){
			drug_db_interface_yn ="N";
		}

		if(drug_db_dosecheck_yn.equals("")){
			drug_db_dosecheck_yn ="N";
		}

		if(drug_db_duptherapy_yn.equals("")){
			drug_db_duptherapy_yn = "N";
		}

        if(drug_db_interaction_yn.equals("")){
			drug_db_interaction_yn = "N";
		}
       
        if(drug_db_contracheck_yn.equals("")){
			drug_db_contracheck_yn = "N";
		}
       
       if(drug_db_alergycheck_yn.equals("")){
			drug_db_alergycheck_yn = "N";
		}

	    modifyData.add(drug_db_interface_yn);
        modifyData.add(drug_db_interface_name);
        modifyData.add(drug_db_dosecheck_yn);
        modifyData.add(drug_db_duptherapy_yn);
        modifyData.add(drug_db_interaction_yn);
        modifyData.add(drug_db_contracheck_yn);
        modifyData.add(drug_db_alergycheck_yn);
       
		modifyData.add(Daycare_yn);
		modifyData.add(emergency_yn);
		modifyData.add(inpatient_yn);
		modifyData.add(Outpatient_yn);

		if(display_price_type_lkp.equals("X")){
	      display_price_type_lkp="";
		}

		modifyData.add(display_charge_details_lkp.trim());
		modifyData.add(display_charge_details_prescription.trim());
		modifyData.add(display_price_type_lkp.trim());
		modifyData.add(Disch_Med_Mar_Appl_yn);
		modifyData.add(admx_prep_charges_appl_yn);
		modifyData.add(split_based_priority_yn);
		modifyData.add(split_based_drug_class_yn);
		modifyData.add(dflt_dir_disp_locn);
		modifyData.add(dflt_ext_rx_disp_locn);
		modifyData.add(tpn_reporting_id);
		modifyData.add(tpn_screening_type);
		modifyData.add(onc_reporting_id);
		modifyData.add(oncology_screening_type);
        if(drug_cat_pin_auth_reqd_yn.equals("")){
			drug_cat_pin_auth_reqd_yn = "N";
		}
		modifyData.add( drug_cat_pin_auth_reqd_yn.trim());
		if(allow_short_expiry_drugs_yn.equals("")){
			allow_short_expiry_drugs_yn = "N";
		}
		modifyData.add(allow_short_expiry_drugs_yn.trim());
		modifyData.add(copy_pres_upto_no_of_days.trim());
		modifyData.add(	include_zero_allocated_items_in_dispensing.trim() ) ;//added for INCLUDE ZERO ALLOC ITEMS on 07-03-09 
		modifyData.add(rec_admin_bef_schdle_time.trim());
		modifyData.add(rec_admin_bef_schdle_time_UOM);
		modifyData.add(	ip_daily_seq_no_yn.trim() ) ;
		modifyData.add(allow_disp_record_lock_yn.trim());//Added for CRF-0439
		modifyData.add(promptAlertForPreferredItem.trim());//Added for CRF-711 --INC 12669
		modifyData.add(defaultPrivilegeDrugSelection.trim());//Added for CRF-641
		modifyData.add(display_uom_transaction_by.trim());//Added for CRF-749 Display UOM in Transaction by
		//Added for CRF-713 --INC 12785
		modifyData.add(narcotic_aprvl_form_req_yn.trim());
		modifyData.add(print_narcotic_form_by_default.trim());
		modifyData.add(edit_disp_label_after_del.trim());
		modifyData.add(rx_qty_by_pres_base_uom_yn.trim()); //Added on 7/12/09
		modifyData.add(dflt_ip_fill_incr_start_with.trim()); //  Added for PMG20089-CRF-0675 to default the start time for Incremental IP Fill Process
		if(inpatient_yn_rule_check.equals("")){
			inpatient_yn_rule_check="N";
		}
		
		if(outpatient_yn_rule_check.equals("")){
			outpatient_yn_rule_check="N";
		}
		
		if(daycare_yn_rule_check.equals("")){
			daycare_yn_rule_check="N";
		}
		
		if(emergency_yn_rule_check.equals("")){
			emergency_yn_rule_check="N";
		}
		
		if(dischmedic_yn_rule_check.equals("")){
			dischmedic_yn_rule_check="N";
		}
		if(atc_allergy_alert_level.equals("")){
			atc_allergy_alert_level="N";
		}
		if(tab_based_group_sort_disp ==null || tab_based_group_sort_disp.equals("")){
			tab_based_group_sort_disp="N";
		}
		if(discont_canc_dup_medic ==null || discont_canc_dup_medic.equals("")){   //if block added for Bru-HIMS-CRF-265 [IN:032315]
			discont_canc_dup_medic="N";
		}
		if(disp_exp_orders_yn ==null || disp_exp_orders_yn.equals("")){   //if block added for ML-BRU-SCF-0636 [IN036826]
			disp_exp_orders_yn="N";
		}
		if(pin_auth_mar_yn ==null || pin_auth_mar_yn.equals("")){   //if block added for RUT-CRF-0035 [IN029926]
			pin_auth_mar_yn="N";
		}
		
		modifyData.add(inpatient_yn_rule_check.trim());
		modifyData.add(outpatient_yn_rule_check.trim());
		modifyData.add(daycare_yn_rule_check.trim());
		modifyData.add(emergency_yn_rule_check.trim());
		modifyData.add(dischmedic_yn_rule_check.trim());
		modifyData.add(atc_allergy_alert_level.trim());
		modifyData.add(tab_based_group_sort_disp.trim());
		//IN30118-SCF No: MO-GN-5400. Updating OutPatient Duplicate Drug Check.
		modifyData.add(allow_duplicate_drug_op);
		modifyData.add(discont_canc_dup_medic) ; //added for Bru-HIMS-CRF-265 [IN:032315]
		modifyData.add(disp_exp_orders_yn) ; //added for Bru-HIMS-CRF-265 [IN:032315]
		modifyData.add(	pin_auth_mar_yn) ; //added for RUT-CRF-0035 [IN029926]
		modifyData.add( allow_medn_ord_without_diag_dd);//added for CRF MMS-QH-CRF-0068 [IN:037980]
		modifyData.add( print_mar_label_yn);//added for MMS-QH-CRF-0080 [IN:038064]
		modifyData.add( alt_drug_remarks_ind);//added for Bru-HIMS-CRF-082 [IN:029948]
		modifyData.add( mar_sch_level_yn);//added for SKR-CRF-0037 [IN:037656] -Start
		modifyData.add( mar_start_ind);
		modifyData.add( mar_week_day_start);
		modifyData.add( mar_past_day);
		modifyData.add( mar_future_day);
		modifyData.add( mar_default_order_by);
		modifyData.add( mar_disc_dose_yn);
		modifyData.add( mar_iv_compl_dt_ind);//added for SKR-CRF-0037 [IN:037656] -End
		modifyData.add( allergy_conf_reqd_yn);//added for RUT-CRF-0064.1 [IN:041799]
		modifyData.add( mar_disp_held_disc_orders_yn);//added for [IN:043283]

		modifyData.add( disp_before_start_date_yn_ip); //added for AMS-CRF-0009[IN:030935] -start
		modifyData.add( disp_before_no_of_days_ip);
		modifyData.add( disp_beyond_earliest_start_yn_ip);
		modifyData.add( disp_beyond_no_of_days_ip); //added for AMS-CRF-0009[IN:030935] -end
		modifyData.add( witness_for_verbal_order_yn);// Added for AAKH-CRF-0023[IN:038259]
		modifyData.add( strDefaultFreqforIV ); //Added for Bru-HIMS-CRF-384[IN041642]
		modifyData.add( em_medctn_fwd_ip_yn ); //Added for Bru-HIMS-CRF-402[IN044065]
		modifyData.add( cary_frwd_ord_nofhrs ); //Added for Bru-HIMS-CRF-402[IN044065]
		modifyData.add( disp_rx_duration_yn ); //Added for Bru-HIMS-CRF-403[IN044541]
		modifyData.add( diag_for_medn_order_by ); //Added for  MMS-SCF-0325 [IN:048069]
		modifyData.add( allow_mar_share_drug_yn ); //added for HSA-CRF-0090 [IN:041241]
		modifyData.add( allow_renew_from_chart_summ_yn );//Added for Bru-HIMS-CRF-400
		modifyData.add( can_discon_dup_orders_def_sel );//Added for HSA-CRF-0151 [IN048468]
		modifyData.add( allow_auto_disp_alt_drug_mar );//Added for Bru-HIMS-CRF-399 [IN:043767]
		modifyData.add( preview_rx_yn );//Added for ML-MMOH-CRF-0341 [IN:057179]
		modifyData.add( disp_prev_vital_signs_yn );//Added for ML-MMOH-CRF-0346 [IN:057185]
		modifyData.add(	 getGeneric_Code()) ;//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
		modifyData.add(getWorkingFrom());//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
		modifyData.add(getWorkingTo());//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
		//Added by prathyusha for JD-CRF-198 
		modifyData.add(allow_amend_alt_drug_dtl);
		//Added by prathyusha for MO-CRF-20085.1 on 05/18/2016 start
		modifyData.add(skip_duplicate_alert_op);
		modifyData.add(skip_duplicate_alert_ip);
		//Added by prathyusha for MO-CRF-20085.1 on 05/18/2016 end
		//Added by prathyusha for MO-CRF-20085.1 on 05/26/2016 start
				modifyData.add(overlap_period_for_op);
				modifyData.add(overlap_period_for_ip);
				modifyData.add(ret_medic_restr_stage);// Added for GHL-CRF-0412.3
				modifyData.add(split_drug_based_auth_yn.trim());//split_drug_based_auth_yn added for ml-mmoh-crf-0864 
                modifyData.add(include_ip_zero_allocated_drugs_for_dispense.trim());//Added for ML-BRU-CRF-0473 
                modifyData.add(assesment_req_yn); // Added for ML-MMOH-CRF-1126
                modifyData.add(late_or_early_admin); // Added for GHL-CRF-0482 [IN:064955]
                modifyData.add(allow_alternate_for_medical_item_yn);//added for ghl-crf-0548
                modifyData.add(ward_ack_required_yn);//added for MMS-KH-CRF-0014
                modifyData.add(ward_ack_mar_required_yn);//added for MMS-KH-CRF-0014
                modifyData.add(display_generic_name_yn);//added for NMC-JD-CRF-0001
				modifyData.add(reconciliation_ip.trim());//added for mms-kh-crf-0016
				modifyData.add(review_aprrove_applicable_for_ip);//added for MMS-KH-CRF-0028
                modifyData.add(review_aprrove_applicable_for_op);//added for MMS-KH-CRF-0028
                modifyData.add(approval_no_yn_ip); //Added for AAKH-CRF-0117
                modifyData.add(approval_no_yn_op); //Added for AAKH-CRF-0117
				modifyData.add(op_disch_med_disp_locn);//added for 6041
                modifyData.add(pre_alloc_appl_yn); //Added for MMS-DM-CRF-0177
                modifyData.add(near_expiry_appl_yn); //Added for MMS-DM-CRF-0177
                modifyData.add(durn_value); //Added for MMS-DM-CRF-0177
                modifyData.add(durn_type); //Added for MMS-DM-CRF-0177
                modifyData.add(durn_value_in_days); //Added for MMS-DM-CRF-0177
                modifyData.add(default_disp_locn);//Added for TFS id:-16341

				modifyData.add(pat_trans_phar_type);//added for ML-MMOH-CRF-1637
				modifyData.add(pat_trans_other_type);//added for ML-MMOH-CRF-1637
				modifyData.add(drug_indication_mdry);//added for JD-CRF-0220
				modifyData.add(disp_auto_refresh);//Added for TH-KW-CRF-0011
				modifyData.add(display_verif_drug_inst_remarks_yn); //added for ML-MMOH-CRF-1755
                if(Amend_orderwise_DispMedication_yn==""){//added for ml-mmoh-crf-1748
					Amend_orderwise_DispMedication_yn="N";
				}
				modifyData.add(Amend_orderwise_DispMedication_yn);//added for ml-mmoh-crf-1748

				modifyData.add(do_not_display_sensitive_diagnosis_yn);//added for ml-mmoh-crf-1748
				modifyData.add(disp_sens_diag_ind_pre_rep_yn);//added for ML-BRU-CRF-0630
				modifyData.add( mar_disp_unbilled_med_yn ); //added for NMC-JD-CRF-0186   <!-- 42911 -->

				modifyData.add( quota_limit_calculation_required_yn ); //added for  ML-MMOH-CRF-1823	 
				modifyData.add( active_prescription_enabled_for_quota_limit_yn ); //added for  ML-MMOH-CRF-1823	 
				
				 //Added for MMS-CRF-0233 by Ayesha Khan
		        modifyData.add( print_footer_dtls_pres_yn.trim()); 
		        modifyData.add( print_pres_dtl_en.trim());
		        modifyData.add( print_pres_dtl_loc.trim());
		        // Ended for MMS-CRF-0233 by Ayesha Khan
				modifyData.add( always_display_dispense_location_yn ); // added for NMC-JD-CRF-0197	



			    modifyData.add(	facility_id.trim() ) ;
		
		HashMap tabData = new HashMap() ;

		tabData.put( "properties", getProperties() );
        tabData.put( "ModifyData",modifyData);	
        
        HashMap sqlMap = new HashMap() ;
		//sqlMap.put( "ModifySQL","UPDATE PH_FACILITY_PARAM SET INTERFACE_TO_ST_YN =?, PAT_INSTR_LOC_LANG_YN=?, CONSIDER_STOCK_FOR_PRES_YN=?, ALLOW_PRES_WITHOUT_STOCK_YN=?, REFILL_YN=?,  MAX_REFILLS_FOR_PRES=?, PRINT_REFILL_PRES_WITH_MAIN_YN=?, MAX_DURN_FOR_REFILL_PRES=?,  DISP_BEFORE_START_DATE_YN=?, DISP_BEFORE_NO_OF_DAYS=?, DISP_BEYOND_EARLIEST_START_YN=?,   DISP_BEYOND_NO_OF_DAYS=?, DISP_FLNG_REQD_YN=?,DISP_FILL_STAGE=?, DISP_DELV_REQD_YN=?, PRINT_DISP_SHEET_OP_YN=?, DFLT_LANG_FOR_DISP_LABEL=?,   LABEL_FORMAT_OP=?, ALLOW_DRUG_RETURN_YN=?, MAX_DRUG_RETENTION_BEF_RTN=?,   MAX_DURN_FOR_OP_MED_RTN=?, IP_VERF_YN=?, IP_FILL_PRD_UNIT=?, IP_FILL_PRD_AHEAD=?,    IP_FILL_EXCL_PRD_BEHIND=?, IP_DELV_REQD_YN=?,    IP_FILL_DFLT_START_TIME=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'),    DFLT_LANG_FOR_DISP_LABEL_IP=?, IP_LABEL_FORMAT=?, INTERFACE_TO_BL_YN=?,	 OP_DISP_LOCN_RTN_ORD=?, OP_DISP_LOCN_STAT_ORD=?, DISP_REGN_REQD_YN=?, 	 DISP_VERF_STAGE=?, PRINT_BAL_MED_SHEET_OP_YN=?, IP_DISP_LOCN_RTN_ORD=?, 	 IP_DISP_LOCN_STAT_ORD=?, DISCH_MED_DISP_LOCN=?, MODIFIED_BY_ID=?, 	 MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID =? ,	 IV_ADMIXTURE_APPL_YN=?,CDR_ADMIXTURE_APPL_YN=?,TPN_REGIMEN_APPL_YN=?,	 WORKING_HRS_OF_PREP_ROOM_FROM=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'),	 WORKING_HRS_OF_PREP_ROOM_TO=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'),	 ALERT_PRACTITIONER_YN=?,VERIFY_TDM_ORDER_YN=?,tdm_result_type_id=?,	 pat_couns_result_type_id=?,START_ADR_NO=?,LAST_ADR_NO=?,MED_ADMIN_REQD_YN=?, 	 VERF_REQD_BEF_MED_ADMIN_YN=?, REC_ADMIN_WITHIN_HRS=?, ALLOW_MED_ADMIN_WO_ORD_YN=?,	 IP_CONSIDER_STOCK_PRES_YN=?, IP_PRES_WITHOUT_STOCK_YN=?,ALLOW_DUPLICATE_DRUG=?,	 ALLOW_MEDN_ORDER_WITHOUT_DIAG=?,ALLOW_MEDN_ORDER_WITHOUT_WT=?,	 DISP_UNALLOC_DRUGS_AT_DEL_STG = ?,PRINT_EXP_DATE_FOR_EXP_ITEM=? ,	  DIR_DISP_ALLOWED=?, APPL_PT_CLASS=?, APPL_ENCTRS=?, HOW_MANY_ENCTRS=?, ENCTRS_DTLS_REQD_DUR_DIR_DISP=?, DUPLICATE_CHECK_AT_ATC_YN=?,MANDATORY_REM_ON_PRN_FREQ_YN=?,COMP_RX_APPL_YN=?, IV_RX_APPL_YN=?,ONCOLOGY_RX_APPL_YN=?,TPN_RX_APPL_YN=?,	TDM_APPL_YN=?, tdm_result_type=?,pat_couns_result_type=?,DRUG_DB_INTERFACE_YN=?,DRUG_DB_PRODUCT_ID=?,DRUG_DB_DOSECHECK_YN=?,DRUG_DB_DUPTHERAPY_YN=?,DRUG_DB_INTERACT_CHECK_YN=?,DRUG_DB_CONTRAIND_CHECK_YN=?,DRUG_DB_ALLERGY_CHECK_YN=?,DC_MAR_APPL_YN=?,EM_MAR_APPL_YN=?,IP_MAR_APPL_YN=?,OP_MAR_APPL_YN=?,DISP_CHARGE_DTL_IN_DRUG_LKP_YN = ?,DISP_CHARGE_DTL_IN_RX_YN=?,DISP_PRICE_TYPE_IN_DRUG_LKP=?, DISCH_MED_MAR_APPL_YN=?,ADMX_PREP_CHARGES_APPL_YN=?,SPLIT_BASED_PRIORITY_YN=?,SPLIT_BASED_DRUG_CLASS_YN=?, DFLT_DIR_DISP_LOCN=?,DFLT_EXT_RX_DISP_LOCN=?  WHERE FACILITY_ID = ?" );
		//sqlMap.put( "ModifySQL","UPDATE PH_FACILITY_PARAM SET INTERFACE_TO_ST_YN =?, PAT_INSTR_LOC_LANG_YN=?, CONSIDER_STOCK_FOR_PRES_YN=?, ALLOW_PRES_WITHOUT_STOCK_YN=?, REFILL_YN=?,  MAX_REFILLS_FOR_PRES=?, PRINT_REFILL_PRES_WITH_MAIN_YN=?, MAX_DURN_FOR_REFILL_PRES=?,  DISP_BEFORE_START_DATE_YN=?, DISP_BEFORE_NO_OF_DAYS=?, DISP_BEYOND_EARLIEST_START_YN=?,   DISP_BEYOND_NO_OF_DAYS=?, DISP_FLNG_REQD_YN=?,DISP_FILL_STAGE=?, DISP_DELV_REQD_YN=?, PRINT_DISP_SHEET_OP_YN=?, DFLT_LANG_FOR_DISP_LABEL=?,   LABEL_FORMAT_OP=?, ALLOW_DRUG_RETURN_YN=?, MAX_DRUG_RETENTION_BEF_RTN=?,   MAX_DURN_FOR_OP_MED_RTN=?, IP_VERF_YN=?, IP_FILL_PRD_UNIT=?, IP_FILL_PRD_AHEAD=?,    IP_FILL_EXCL_PRD_BEHIND=?, IP_DELV_REQD_YN=?,    IP_FILL_DFLT_START_TIME=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'),    DFLT_LANG_FOR_DISP_LABEL_IP=?, IP_LABEL_FORMAT=?, INTERFACE_TO_BL_YN=?,	 OP_DISP_LOCN_RTN_ORD=?, OP_DISP_LOCN_STAT_ORD=?, DISP_REGN_REQD_YN=?, 	 DISP_VERF_STAGE=?, PRINT_BAL_MED_SHEET_OP_YN=?, IP_DISP_LOCN_RTN_ORD=?, 	 IP_DISP_LOCN_STAT_ORD=?, DISCH_MED_DISP_LOCN=?, MODIFIED_BY_ID=?, 	 MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID =? ,	 IV_ADMIXTURE_APPL_YN=?,CDR_ADMIXTURE_APPL_YN=?,TPN_REGIMEN_APPL_YN=?,	 WORKING_HRS_OF_PREP_ROOM_FROM=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'),	 WORKING_HRS_OF_PREP_ROOM_TO=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'),	 ALERT_PRACTITIONER_YN=?,VERIFY_TDM_ORDER_YN=?,tdm_result_type_id=?,	 pat_couns_result_type_id=?,START_ADR_NO=?,LAST_ADR_NO=?,MED_ADMIN_REQD_YN=?, 	 VERF_REQD_BEF_MED_ADMIN_YN=?, REC_ADMIN_WITHIN_HRS=?, ALLOW_MED_ADMIN_WO_ORD_YN=?,	 IP_CONSIDER_STOCK_PRES_YN=?, IP_PRES_WITHOUT_STOCK_YN=?,ALLOW_DUPLICATE_DRUG=?,	 ALLOW_MEDN_ORDER_WITHOUT_DIAG=?,ALLOW_MEDN_ORDER_WITHOUT_WT=?,	 DISP_UNALLOC_DRUGS_AT_DEL_STG = ?,PRINT_EXP_DATE_FOR_EXP_ITEM=? ,	  DIR_DISP_ALLOWED=?, APPL_PT_CLASS=?, APPL_ENCTRS=?, HOW_MANY_ENCTRS=?, ENCTRS_DTLS_REQD_DUR_DIR_DISP=?, DUPLICATE_CHECK_AT_ATC_YN=?,MANDATORY_REM_ON_PRN_FREQ_YN=?,COMP_RX_APPL_YN=?, IV_RX_APPL_YN=?,ONCOLOGY_RX_APPL_YN=?,TPN_RX_APPL_YN=?,	TDM_APPL_YN=?, tdm_result_type=?,pat_couns_result_type=?,DRUG_DB_INTERFACE_YN=?,DRUG_DB_PRODUCT_ID=?,DRUG_DB_DOSECHECK_YN=?,DRUG_DB_DUPTHERAPY_YN=?,DRUG_DB_INTERACT_CHECK_YN=?,DRUG_DB_CONTRAIND_CHECK_YN=?,DRUG_DB_ALLERGY_CHECK_YN=?,DC_MAR_APPL_YN=?,EM_MAR_APPL_YN=?,IP_MAR_APPL_YN=?,OP_MAR_APPL_YN=?,DISP_CHARGE_DTL_IN_DRUG_LKP_YN = ?,DISP_CHARGE_DTL_IN_RX_YN=?,DISP_PRICE_TYPE_IN_DRUG_LKP=?, DISCH_MED_MAR_APPL_YN=?,ADMX_PREP_CHARGES_APPL_YN=?,SPLIT_BASED_PRIORITY_YN=?,SPLIT_BASED_DRUG_CLASS_YN=?, DFLT_DIR_DISP_LOCN=?,DFLT_EXT_RX_DISP_LOCN=?,TPN_SCREENING_FORM_ID=?,TPN_SCREENING_TYPE=?,ONCOLOGY_SCREENING_FORM_ID=?,ONCOLOGY_SCREENING_TYPE=?,DRUG_CAT_PIN_AUTH_REQD_YN=?,ALLOW_SHORT_EXPIRY_DRUGS_YN=?,COPY_PRES_UPTO_NO_OF_DAYS=? WHERE FACILITY_ID = ?");
		//sqlMap.put( "ModifySQL", PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_UPDATE") );
		// sqlMap.put( "ModifySQL","UPDATE PH_FACILITY_PARAM SET INTERFACE_TO_ST_YN =?, PAT_INSTR_LOC_LANG_YN=?, CONSIDER_STOCK_FOR_PRES_YN=?, ALLOW_PRES_WITHOUT_STOCK_YN=?, REFILL_YN=?,  MAX_REFILLS_FOR_PRES=?, PRINT_REFILL_PRES_WITH_MAIN_YN=?, MAX_DURN_FOR_REFILL_PRES=?,  DISP_BEFORE_START_DATE_YN=?, DISP_BEFORE_NO_OF_DAYS=?, DISP_BEYOND_EARLIEST_START_YN=?,   DISP_BEYOND_NO_OF_DAYS=?, DISP_FLNG_REQD_YN=?,DISP_FILL_STAGE=?, DISP_DELV_REQD_YN=?, PRINT_DISP_SHEET_OP_YN=?, DFLT_LANG_FOR_DISP_LABEL=?,   LABEL_FORMAT_OP=?, ALLOW_DRUG_RETURN_YN=?, MAX_DRUG_RETENTION_BEF_RTN=?,   MAX_DURN_FOR_OP_MED_RTN=?, IP_VERF_YN=?, IP_FILL_PRD_UNIT=?, IP_FILL_PRD_AHEAD=?,    IP_FILL_EXCL_PRD_BEHIND=?, IP_DELV_REQD_YN=?,    IP_FILL_DFLT_START_TIME=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'),    DFLT_LANG_FOR_DISP_LABEL_IP=?, IP_LABEL_FORMAT=?, INTERFACE_TO_BL_YN=?,	 OP_DISP_LOCN_RTN_ORD=?, OP_DISP_LOCN_STAT_ORD=?, DISP_REGN_REQD_YN=?, 	 DISP_VERF_STAGE=?, PRINT_BAL_MED_SHEET_OP_YN=?, IP_DISP_LOCN_RTN_ORD=?, 	 IP_DISP_LOCN_STAT_ORD=?, DISCH_MED_DISP_LOCN=?, MODIFIED_BY_ID=?, 	 MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID =? ,	 IV_ADMIXTURE_APPL_YN=?,CDR_ADMIXTURE_APPL_YN=?,TPN_REGIMEN_APPL_YN=?,	 WORKING_HRS_OF_PREP_ROOM_FROM=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'),	 WORKING_HRS_OF_PREP_ROOM_TO=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'),	 ALERT_PRACTITIONER_YN=?,VERIFY_TDM_ORDER_YN=?,tdm_result_type_id=?,	 pat_couns_result_type_id=?,START_ADR_NO=?,LAST_ADR_NO=?,MED_ADMIN_REQD_YN=?, 	 VERF_REQD_BEF_MED_ADMIN_YN=?, REC_ADMIN_WITHIN_HRS=?, ALLOW_MED_ADMIN_WO_ORD_YN=?,	 IP_CONSIDER_STOCK_PRES_YN=?, IP_PRES_WITHOUT_STOCK_YN=?,ALLOW_DUPLICATE_DRUG=?,	 ALLOW_MEDN_ORDER_WITHOUT_DIAG=?,ALLOW_MEDN_ORDER_WITHOUT_WT=?,	 DISP_UNALLOC_DRUGS_AT_DEL_STG = ?,PRINT_EXP_DATE_FOR_EXP_ITEM=? ,	  DIR_DISP_ALLOWED=?, APPL_PT_CLASS=?, APPL_ENCTRS=?, HOW_MANY_ENCTRS=?, ENCTRS_DTLS_REQD_DUR_DIR_DISP=?, DUPLICATE_CHECK_AT_ATC_YN=?,MANDATORY_REM_ON_PRN_FREQ_YN=?,COMP_RX_APPL_YN=?, IV_RX_APPL_YN=?,ONCOLOGY_RX_APPL_YN=?,TPN_RX_APPL_YN=?,	TDM_APPL_YN=?, tdm_result_type=?,pat_couns_result_type=?,DRUG_DB_INTERFACE_YN=?,DRUG_DB_PRODUCT_ID=?,DRUG_DB_DOSECHECK_YN=?,DRUG_DB_DUPTHERAPY_YN=?,DRUG_DB_INTERACT_CHECK_YN=?,DRUG_DB_CONTRAIND_CHECK_YN=?,DRUG_DB_ALLERGY_CHECK_YN=?,DC_MAR_APPL_YN=?,EM_MAR_APPL_YN=?,IP_MAR_APPL_YN=?,OP_MAR_APPL_YN=?,DISP_CHARGE_DTL_IN_DRUG_LKP_YN = ?,DISP_CHARGE_DTL_IN_RX_YN=?,DISP_PRICE_TYPE_IN_DRUG_LKP=?, DISCH_MED_MAR_APPL_YN=?,ADMX_PREP_CHARGES_APPL_YN=?,SPLIT_BASED_PRIORITY_YN=?,SPLIT_BASED_DRUG_CLASS_YN=?, DFLT_DIR_DISP_LOCN=?,DFLT_EXT_RX_DISP_LOCN=?,TPN_SCREENING_FORM_ID=?,TPN_SCREENING_TYPE=?,ONCOLOGY_SCREENING_FORM_ID=?,ONCOLOGY_SCREENING_TYPE=?,DRUG_CAT_PIN_AUTH_REQD_YN=?,ALLOW_SHORT_EXPIRY_DRUGS_YN=?,COPY_PRES_UPTO_NO_OF_DAYS=?,INCLUDE_ZERO_ALLOC_QTY_ITEMS=?,REC_ADMIN_AHEAD_PRD=?, REC_ADMIN_AHEAD_TYPE=?,IP_DSN_YN=?, ALLOW_DISP_RECORD_LOCK_YN=?,PROMPT_ALERT_FPR_PREF_CHK_YN=?,DEFAULT_PREV_DRUG_SEL=?,UOM_DISPLAY_IN_TRANS = ? ,NARCOTIC_APRVL_FORM_REQ_YN=?,PRINT_NARCOTIC_FORM_BY_DEFAULT = ?, EDIT_DISP_LABEL_AFTER_DEL = ? WHERE FACILITY_ID = ?");		
		//sqlMap.put( "ModifySQL","UPDATE PH_FACILITY_PARAM SET INTERFACE_TO_ST_YN =?, PAT_INSTR_LOC_LANG_YN=?, CONSIDER_STOCK_FOR_PRES_YN=?, ALLOW_PRES_WITHOUT_STOCK_YN=?, REFILL_YN=?, MAX_REFILLS_FOR_PRES=?, PRINT_REFILL_PRES_WITH_MAIN_YN=?, MAX_DURN_FOR_REFILL_PRES=?, DISP_BEFORE_START_DATE_YN=?, DISP_BEFORE_NO_OF_DAYS=?, DISP_BEYOND_EARLIEST_START_YN=?, DISP_BEYOND_NO_OF_DAYS=?, DISP_FLNG_REQD_YN=?,DISP_FILL_STAGE=?, DISP_DELV_REQD_YN=?, PRINT_DISP_SHEET_OP_YN=?, DFLT_LANG_FOR_DISP_LABEL=?, LABEL_FORMAT_OP=?, ALLOW_DRUG_RETURN_YN=?, MAX_DRUG_RETENTION_BEF_RTN=?, MAX_DURN_FOR_OP_MED_RTN=?, IP_VERF_YN=?, IP_FILL_PRD_UNIT=?, IP_FILL_PRD_AHEAD=?, IP_FILL_EXCL_PRD_BEHIND=?, IP_DELV_REQD_YN=?, IP_FILL_DFLT_START_TIME = TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'), DFLT_LANG_FOR_DISP_LABEL_IP=?, IP_LABEL_FORMAT=?, INTERFACE_TO_BL_YN=?, OP_DISP_LOCN_RTN_ORD=?, OP_DISP_LOCN_STAT_ORD=?, DISP_REGN_REQD_YN=?, DISP_VERF_STAGE=?, PRINT_BAL_MED_SHEET_OP_YN=?, IP_DISP_LOCN_RTN_ORD=?, IP_DISP_LOCN_STAT_ORD=?, DISCH_MED_DISP_LOCN=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID =? , IV_ADMIXTURE_APPL_YN=?,CDR_ADMIXTURE_APPL_YN=?,TPN_REGIMEN_APPL_YN=?, WORKING_HRS_OF_PREP_ROOM_FROM= TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'), WORKING_HRS_OF_PREP_ROOM_TO=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'), ALERT_PRACTITIONER_YN=?,VERIFY_TDM_ORDER_YN=?,tdm_result_type_id=?, pat_couns_result_type_id=?,START_ADR_NO=?,LAST_ADR_NO=?,MED_ADMIN_REQD_YN=?, VERF_REQD_BEF_MED_ADMIN_YN=?, REC_ADMIN_WITHIN_HRS=?, ALLOW_MED_ADMIN_WO_ORD_YN=?, IP_CONSIDER_STOCK_PRES_YN=?, IP_PRES_WITHOUT_STOCK_YN=?,ALLOW_DUPLICATE_DRUG=?, ALLOW_MEDN_ORDER_WITHOUT_DIAG=?,ALLOW_MEDN_ORDER_WITHOUT_WT=?, DISP_UNALLOC_DRUGS_AT_DEL_STG = ?,PRINT_EXP_DATE_FOR_EXP_ITEM=? , DIR_DISP_ALLOWED=?, APPL_PT_CLASS=?, APPL_ENCTRS=?, HOW_MANY_ENCTRS=?, ENCTRS_DTLS_REQD_DUR_DIR_DISP=?, DUPLICATE_CHECK_AT_ATC_YN=?, MANDATORY_REM_ON_PRN_FREQ_YN=?,COMP_RX_APPL_YN=?, IV_RX_APPL_YN=?,ONCOLOGY_RX_APPL_YN=?,TPN_RX_APPL_YN=?, TDM_APPL_YN=?, tdm_result_type=?,pat_couns_result_type=?, DRUG_DB_INTERFACE_YN=?, DRUG_DB_PRODUCT_ID=?,DRUG_DB_DOSECHECK_YN=?,DRUG_DB_DUPTHERAPY_YN=?,DRUG_DB_INTERACT_CHECK_YN=?, DRUG_DB_CONTRAIND_CHECK_YN=?, DRUG_DB_ALLERGY_CHECK_YN=?, DC_MAR_APPL_YN=?, EM_MAR_APPL_YN=?, IP_MAR_APPL_YN=?,OP_MAR_APPL_YN=?,DISP_CHARGE_DTL_IN_DRUG_LKP_YN = ?,DISP_CHARGE_DTL_IN_RX_YN=?,DISP_PRICE_TYPE_IN_DRUG_LKP=?, DISCH_MED_MAR_APPL_YN=?, ADMX_PREP_CHARGES_APPL_YN=?, SPLIT_BASED_PRIORITY_YN=?,SPLIT_BASED_DRUG_CLASS_YN=?, DFLT_DIR_DISP_LOCN=?,DFLT_EXT_RX_DISP_LOCN=?, TPN_SCREENING_FORM_ID=?,TPN_SCREENING_TYPE=? ,ONCOLOGY_SCREENING_FORM_ID=?, ONCOLOGY_SCREENING_TYPE=?, DRUG_CAT_PIN_AUTH_REQD_YN=?,ALLOW_SHORT_EXPIRY_DRUGS_YN=?,COPY_PRES_UPTO_NO_OF_DAYS=?,INCLUDE_ZERO_ALLOC_QTY_ITEMS=?,REC_ADMIN_AHEAD_PRD=?, REC_ADMIN_AHEAD_TYPE=?,IP_DSN_YN=?, ALLOW_DISP_RECORD_LOCK_YN=?, PROMPT_ALERT_FPR_PREF_CHK_YN=?,DEFAULT_PREV_DRUG_SEL=?, UOM_DISPLAY_IN_TRANS = ? ,NARCOTIC_APRVL_FORM_REQ_YN=?, PRINT_NARCOTIC_FORM_BY_DEFAULT = ?, EDIT_DISP_LABEL_AFTER_DEL = ?, RX_QTY_BY_PRES_BASE_UOM_YN =?, DFLT_IP_FILL_INCR_START_WITH = ?, IP_MAR_RULE_YN=?, OP_MAR_RULE_YN=?, DC_MAR_RULE_YN=?, EM_MAR_RULE_YN=?, DM_MAR_RULE_YN=?, ATC_ALLERGY_ALERT_LEVEL=?, TAB_BASED_GROUP_SORT_DISP=?,ALLOW_DUPLICATE_DRUG_OP=?, CAN_DISCON_DUP_ORDERS=?,DISP_EXPIRIED_ORDERS=?, MAR_AUTH_REQD_YN=?,ALLOW_MEDN_ORD_WITHOUT_DIAG_DD=?, PRINT_MAR_LABEL_YN=? , ALT_DRUG_REMARKS_IND=?, MAR_SCH_LEVEL_YN=?, MAR_START_IND=?, MAR_WEEK_DAY_START=?, MAR_PAST_DAY=?, MAR_FUTURE_DAY=?, MAR_DEFAULT_ORDER_BY=? , MAR_DISC_DOSE_YN=?, MAR_IV_COMPL_DT_IND=? , ALLERGY_CONF_REQD_YN=?, MAR_DISP_HELD_DISC_ORDERS_YN=?, DISP_BEFORE_START_DATE_IP_YN=?,DISP_BEFORE_NO_OF_DAYS_IP=?,DISP_BEYOND_EARLST_STRT_IP_YN=?,DISP_BEYOND_NO_OF_DAYS_IP=?, VERBAL_ORDER_WITNESS_YN=?, IV_DEFAULT_FREQUENCY=?, EM_MEDCTN_FWD_IP_YN=?, CARY_FRWD_ORD_NOFHRS=?, disp_rx_duration_YN=?, diag_for_medn_order_by=? , allow_mar_share_drug_yn=? , allow_renew_from_chart_summ_yn=?,  can_discon_dup_orders_def_sel = ?, ALLOW_AUTO_DISP_ALT_DRUG_MAR=?, PREVIEW_RX_YN=?,  disp_prev_vital_signs_yn =?, mar_disp_unbilled_med_yn=?,WHERE FACILITY_ID = ?");	 // Added CAN_DISCON_DUP_ORDERS for Bru-HIMS-CRF-265 [IN:032315], DISP_EXPIRIED_ORDERS for ML-BRU-SCF-0636 [IN036826], MAR_AUTH_REQD_YN Added for RUT-CRF-0035 [IN029926] , ALLOW_MEDN_ORD_WITHOUT_DIAG_DD added for CRF MMS-QH-CRF-0068 [IN:037980], print_mar_label_yn added for MMS-QH-CRF-0080 [IN:038064],DISP_BEFORE_START_DATE_IP_YN,DISP_BEFORE_NO_OF_DAYS_IP,DISP_BEYOND_EARLIEST_START_IP_DISP_BEYOND_NO_OF_DAYS_IP added for AMS-CRF-0009[IN:030935] // Added VERBAL_ORDER_WITNESS_YN for AAKH-CRF-0023[IN:038259]//Added IV_DEFAULT_FREQUENCY for Bru-HIMS-CRF-384[IN041642],  EM_MEDCTN_FWD_IP_YN, CARY_FRWD_ORD_NOFHRS - for Bru-HIMS-CRF-402[IN044065] disp_rx_duration_YN - for Bru-HIMS-CRF-403[IN044541] diag_for_medn_order_by for MMS-SCF-0325 [IN:048069],ALLOW_RENEW_FROM_CHART_SUMM_YN Added for Bru-HIMS-CRF-400 , preview_rx_yn Added for ML-MMOH-CRF-0341 [IN:057179] //Added  disp_prev_vital_signs_yn for ML-MMOH-CRF-0346 [IN:057185]
        //Modified for MO-CRF-20085.1 SKP_DUPL_ALRT_OP_YN,SKP_DUPL_ALRT_IP_YN Added By prathyusha 05/18/2016
      //split_drug_based_auth_yn added for ml-mmoh-crf-0864 
        //allow_alt_for_medical_item_yn added for ghl-0548
      //WARD_ACK_REQUIRED_YN,WARD_ACK_MAR_REQUIRED_YN added for MMS-KH-CRF-0014 
	  //RECONCILIATION_YN ADDED FOR MMS-KH-CRF-0016
        //REVW_APRROVE_APPLICABLE_FOR_IP,REVW_APRROVE_APPLICABLE_FOR_OP added for MMS-KH-CRF-0028
      //DRUG_INDICATION_MDRY added for JD-CRF-0220//AMEND_ORD_WISE_DISP_MED added for ml-mmoh-crf-1748
        sqlMap.put( "ModifySQL","UPDATE PH_FACILITY_PARAM SET INTERFACE_TO_ST_YN =?, PAT_INSTR_LOC_LANG_YN=?, CONSIDER_STOCK_FOR_PRES_YN=?, ALLOW_PRES_WITHOUT_STOCK_YN=?, REFILL_YN=?, MAX_REFILLS_FOR_PRES=?, PRINT_REFILL_PRES_WITH_MAIN_YN=?, MAX_DURN_FOR_REFILL_PRES=?, DISP_BEFORE_START_DATE_YN=?, DISP_BEFORE_NO_OF_DAYS=?, DISP_BEYOND_EARLIEST_START_YN=?, DISP_BEYOND_NO_OF_DAYS=?, DISP_FLNG_REQD_YN=?,DISP_FILL_STAGE=?, DISP_DELV_REQD_YN=?, PRINT_DISP_SHEET_OP_YN=?, DFLT_LANG_FOR_DISP_LABEL=?, LABEL_FORMAT_OP=?, ALLOW_DRUG_RETURN_YN=?, MAX_DRUG_RETENTION_BEF_RTN=?, MAX_DURN_FOR_OP_MED_RTN=?, IP_VERF_YN=?, IP_FILL_PRD_UNIT=?, IP_FILL_PRD_AHEAD=?, IP_FILL_EXCL_PRD_BEHIND=?, IP_DELV_REQD_YN=?, IP_FILL_DFLT_START_TIME = TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'), DFLT_LANG_FOR_DISP_LABEL_IP=?, IP_LABEL_FORMAT=?, INTERFACE_TO_BL_YN=?, OP_DISP_LOCN_RTN_ORD=?, OP_DISP_LOCN_STAT_ORD=?, DISP_REGN_REQD_YN=?, DISP_VERF_STAGE=?, PRINT_BAL_MED_SHEET_OP_YN=?, IP_DISP_LOCN_RTN_ORD=?, IP_DISP_LOCN_STAT_ORD=?, DISCH_MED_DISP_LOCN=?, MODIFIED_BY_ID=?, MODIFIED_DATE=SYSDATE, MODIFIED_AT_WS_NO=?, MODIFIED_FACILITY_ID =? , IV_ADMIXTURE_APPL_YN=?,CDR_ADMIXTURE_APPL_YN=?,TPN_REGIMEN_APPL_YN=?, WORKING_HRS_OF_PREP_ROOM_FROM= TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'), WORKING_HRS_OF_PREP_ROOM_TO=TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'), ALERT_PRACTITIONER_YN=?,VERIFY_TDM_ORDER_YN=?,tdm_result_type_id=?, pat_couns_result_type_id=?,START_ADR_NO=?,LAST_ADR_NO=?,MED_ADMIN_REQD_YN=?, VERF_REQD_BEF_MED_ADMIN_YN=?, REC_ADMIN_WITHIN_HRS=?, ALLOW_MED_ADMIN_WO_ORD_YN=?, IP_CONSIDER_STOCK_PRES_YN=?, IP_PRES_WITHOUT_STOCK_YN=?,ALLOW_DUPLICATE_DRUG=?, ALLOW_MEDN_ORDER_WITHOUT_DIAG=?,ALLOW_MEDN_ORDER_WITHOUT_WT=?, DISP_UNALLOC_DRUGS_AT_DEL_STG = ?,PRINT_EXP_DATE_FOR_EXP_ITEM=? , DIR_DISP_ALLOWED=?, APPL_PT_CLASS=?, APPL_ENCTRS=?, HOW_MANY_ENCTRS=?, ENCTRS_DTLS_REQD_DUR_DIR_DISP=?, DUPLICATE_CHECK_AT_ATC_YN=?, MANDATORY_REM_ON_PRN_FREQ_YN=?,COMP_RX_APPL_YN=?, IV_RX_APPL_YN=?,ONCOLOGY_RX_APPL_YN=?,TPN_RX_APPL_YN=?, TDM_APPL_YN=?, tdm_result_type=?,pat_couns_result_type=?, DRUG_DB_INTERFACE_YN=?, DRUG_DB_PRODUCT_ID=?,DRUG_DB_DOSECHECK_YN=?,DRUG_DB_DUPTHERAPY_YN=?,DRUG_DB_INTERACT_CHECK_YN=?, DRUG_DB_CONTRAIND_CHECK_YN=?, DRUG_DB_ALLERGY_CHECK_YN=?, DC_MAR_APPL_YN=?, EM_MAR_APPL_YN=?, IP_MAR_APPL_YN=?,OP_MAR_APPL_YN=?,DISP_CHARGE_DTL_IN_DRUG_LKP_YN = ?,DISP_CHARGE_DTL_IN_RX_YN=?,DISP_PRICE_TYPE_IN_DRUG_LKP=?, DISCH_MED_MAR_APPL_YN=?, ADMX_PREP_CHARGES_APPL_YN=?, SPLIT_BASED_PRIORITY_YN=?,SPLIT_BASED_DRUG_CLASS_YN=?, DFLT_DIR_DISP_LOCN=?,DFLT_EXT_RX_DISP_LOCN=?, TPN_SCREENING_FORM_ID=?,TPN_SCREENING_TYPE=? ,ONCOLOGY_SCREENING_FORM_ID=?, ONCOLOGY_SCREENING_TYPE=?, DRUG_CAT_PIN_AUTH_REQD_YN=?,ALLOW_SHORT_EXPIRY_DRUGS_YN=?,COPY_PRES_UPTO_NO_OF_DAYS=?,INCLUDE_ZERO_ALLOC_QTY_ITEMS=?,REC_ADMIN_AHEAD_PRD=?, REC_ADMIN_AHEAD_TYPE=?,IP_DSN_YN=?, ALLOW_DISP_RECORD_LOCK_YN=?, PROMPT_ALERT_FPR_PREF_CHK_YN=?,DEFAULT_PREV_DRUG_SEL=?, UOM_DISPLAY_IN_TRANS = ? ,NARCOTIC_APRVL_FORM_REQ_YN=?, PRINT_NARCOTIC_FORM_BY_DEFAULT = ?, EDIT_DISP_LABEL_AFTER_DEL = ?, RX_QTY_BY_PRES_BASE_UOM_YN =?, DFLT_IP_FILL_INCR_START_WITH = ?, IP_MAR_RULE_YN=?, OP_MAR_RULE_YN=?, DC_MAR_RULE_YN=?, EM_MAR_RULE_YN=?, DM_MAR_RULE_YN=?, ATC_ALLERGY_ALERT_LEVEL=?, TAB_BASED_GROUP_SORT_DISP=?,ALLOW_DUPLICATE_DRUG_OP=?, CAN_DISCON_DUP_ORDERS=?,DISP_EXPIRIED_ORDERS=?, MAR_AUTH_REQD_YN=?,ALLOW_MEDN_ORD_WITHOUT_DIAG_DD=?, PRINT_MAR_LABEL_YN=? , ALT_DRUG_REMARKS_IND=?, MAR_SCH_LEVEL_YN=?, MAR_START_IND=?, MAR_WEEK_DAY_START=?, MAR_PAST_DAY=?, MAR_FUTURE_DAY=?, MAR_DEFAULT_ORDER_BY=? , MAR_DISC_DOSE_YN=?, MAR_IV_COMPL_DT_IND=? , ALLERGY_CONF_REQD_YN=?, MAR_DISP_HELD_DISC_ORDERS_YN=?, DISP_BEFORE_START_DATE_IP_YN=?,DISP_BEFORE_NO_OF_DAYS_IP=?,DISP_BEYOND_EARLST_STRT_IP_YN=?,DISP_BEYOND_NO_OF_DAYS_IP=?, VERBAL_ORDER_WITNESS_YN=?, IV_DEFAULT_FREQUENCY=?, EM_MEDCTN_FWD_IP_YN=?, CARY_FRWD_ORD_NOFHRS=?, disp_rx_duration_YN=?, diag_for_medn_order_by=? , allow_mar_share_drug_yn=? , allow_renew_from_chart_summ_yn=?,  can_discon_dup_orders_def_sel = ?, ALLOW_AUTO_DISP_ALT_DRUG_MAR=?, PREVIEW_RX_YN=?,  disp_prev_vital_signs_yn =?, DEF_GENERIC_ID = ?, OFFICE_HOURS_FROM=TO_DATE( TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) || ?, 'DD/MM/YYYY HH24:MI' ),OFFICE_HOURS_TO=TO_DATE( TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) || ?, 'DD/MM/YYYY HH24:MI' ),ALLOW_AMEND_ALTERNATE_DRUG_DT = ?,SKIP_DUPLICATE_ALERT_OP_YN = ?,SKIP_DUPLICATE_ALERT_IP_YN = ?,OVERLAP_PERIOD_FOR_OP = ?,OVERLAP_PERIOD_FOR_IP = ?,RET_MEDIC_RESTR_STAGE=?,SPLIT_DRUG_BASED_AUTH_YN=?,INCLUDE_ZERO_ALOC_QTY_ITEMS_IP=?,ASSESMENT_REQ_YN=?,EARLY_OR_LATE_ADMIN_YN=?,ALLOW_ALT_FOR_MEDICAL_ITEM_YN=?,WARD_ACK_REQUIRED_YN=?,WARD_ACK_MAR_REQUIRED_YN=?,GENERIC_NAME_DISPLY_YN=?,RECONCILIATION_YN=?,REVW_APRROVE_APPLICABLE_FOR_IP=?,REVW_APRROVE_APPLICABLE_FOR_OP=?,APPROVAL_NO_APPL_IP=?,APPROVAL_NO_APPL_OP=?,OP_DISCH_MED_DISP_LOCN=?,PRE_ALLOC_APPL=?,NEAR_EXPIRY_APPL=?,DURN_VALUE=?,DURN_TYPE=?,DURN_VALUE_IN_DAYS=?,DFLT_DISP_LOCN=?,PAT_TRANSFER_PHAR_TYPE=?,PAT_TRANSFER_OTHER_TYPE=?,DRUG_INDICATION_MDRY=?,DISP_AUTO_REFRESH=?, DISP_VERI_REM_DRUG_INST=?,AMEND_ORD_WISE_DISP_MED=?, DISP_SENS_DIAG_PRE_REP_YN = ?, DISP_SENS_DIAG_IND_PRE_REP_YN = ?, mar_disp_unbilled_med_yn=?,QUOTA_LIMIT_CALC_REQ_YN=?,ACITVE_PREP_APPL_QUOTA_YN = ?,PRINT_FOOTER_DTLS_PRES_YN=?,PRINT_PRES_DTL_EN=?,PRINT_PRES_DTL_LOC=?, ALW_DISP_LOC_DRUG_SEARCH_YN = ? WHERE FACILITY_ID = ?"); // ASSESMENT_REQ_YN=? Added for ML-MMOH-CRF-1126	 EARLY_OR_LATE_ADMIN_YN Added for GHL-CRF-0482 [IN:064955] //PRE_ALLOC_APPL, NEAR_EXPIRY_APPL_YN, DURN_VALUE,DURN_TYPE,DURN_VALUE_IN_DAYS Added for MMS-DM-CRF-0177, Modified for TFS id:-16341 added DFLT_DISP_LOCN 
		//Added DEF_GENERIC_ID, OFFICE_HOURS_FROM, OFFICE_HOURS_TO for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016  Allow_Amend_Alternate_Drug_Dt Added by prathyusha for JD-CRF-198 on 05/05/2016  // RET_MEDIC_RESTR_STAGE added for GHL-CRF-0412.3//INCLUDE_ZERO_ALOC_QTY_ITEMS_IP Added for ML-BRU-CRF-0473 //GENERIC_NAME_DISPLY_YN added for NMC-JD-CRF-0001
		//PAT_TRANSFER_PHAR_TYPE,PAT_TRANSFER_OTHER_TYPE added for ML-MMOH-CRF-1637
		// DISP_VERI_REM_DRUG_INST added for ML-MMOH-CRF-1755
		//,DISP_SENS_DIAG_PRE_REP_YN = ?, DISP_SENS_DIAG_IND_PRE_REP_YN = ? added for ML-BRU-CRF-0630
		//, QUOTA_LIMIT_CALC_REQ_YN = ?, ACITVE_PREP_APPL_QUOTA_YN = ? added for ML-MMOH-CRF-1823
		//,ALW_DISP_LOC_DRUG_SEARCH_YN added for NMC-JD-CRF-0197

        try {
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("modify",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
			if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "result", new Boolean( true ) ) ;
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
				map.put( "flag",debug.toString());

			}
            else{
                map.put( "result", new Boolean( false ) ) ;
                map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH") ) ;
                map.put( "flag",debug.toString());
            }
        } 
		catch(Exception e) {
            System.err.println( "Error in modify : map="+map+" tabData="+tabData ) ;
            map.put( "message", e.getMessage()) ;
            map.put( "flag",debug.toString());
            e.printStackTrace() ;
        } 		
        return map ;
    }

    public HashMap insert() {
		String debug=new String();
        HashMap map = new HashMap() ;
        map.put( "result", new Boolean( false ) ) ;
        ArrayList insertData = new ArrayList() ;
        ArrayList whereData  = new ArrayList() ;
		HashMap tabData = new HashMap() ;
		HashMap sqlMap = new HashMap() ;
		
		try{
			insertData.add( facility_id.trim() );
			insertData.add( interface_to_st_yn);
			insertData.add( pat_instr_loc_lang_yn);
			insertData.add( consider_stock_for_pres_yn);
			insertData.add( allow_pres_without_stock_yn);
			insertData.add( refill_yn);
			insertData.add( max_refills_for_pres);
			insertData.add( print_refill_pres_with_main_yn);
			insertData.add( max_durn_for_refill_pres);
			insertData.add( disp_before_start_date_yn);
			insertData.add( disp_before_no_of_days);
			insertData.add( disp_beyond_earliest_start_yn);
			insertData.add( disp_beyond_no_of_days);
			insertData.add( disp_flng_reqd_yn);
			insertData.add( disp_fill_stage);
			insertData.add( disp_delv_reqd_yn);
			//insertData.add( disp_cash_coll_stage);
			insertData.add( print_disp_sheet_op_yn);
			insertData.add( dflt_lang_for_disp_label);
			insertData.add( label_format_op);
			insertData.add( allow_drug_return_yn);
			insertData.add( max_drug_retention_bef_rtn);
			insertData.add( max_durn_for_op_med_rtn);
			insertData.add( ip_verf_yn);
			insertData.add( ip_fill_prd_unit);
			insertData.add( ip_fill_prd_ahead);
			insertData.add( ip_fill_excl_prd_behind);
			insertData.add( ip_delv_reqd_yn);
			insertData.add( ip_fill_dflt_start_time);

			insertData.add( dflt_lang_for_disp_label_ip);
			insertData.add( ip_label_format);
			insertData.add( interface_to_bl_yn);
			insertData.add( op_disp_locn_rtn_ord);
			insertData.add( op_disp_locn_stat_ord);
			insertData.add( disp_regn_reqd_yn);
			insertData.add( disp_verf_stage);
			insertData.add( print_bal_med_sheet_op_yn);
			insertData.add( ip_disp_locn_rtn_ord);
			insertData.add( ip_disp_locn_stat_ord);
			insertData.add( disch_med_disp_locn);
			insertData.add( login_by_id.trim());
			insertData.add( login_at_ws_no.trim());
			insertData.add( login_facility_id.trim());
			insertData.add( login_by_id.trim());
			insertData.add( login_at_ws_no.trim());
			insertData.add( login_facility_id.trim());

			//if(allow_usage_of_spil_qty_yn.equals("")){
				//allow_usage_of_spil_qty_yn = "N";
			//}
			if(verf_reqd_bef_med_admin_yn.equals("")){
				verf_reqd_bef_med_admin_yn ="N";
			}
			if(witness_for_verbal_order_yn.equals("")){// Added for AAKH-CRF-0023[IN:038259]
				witness_for_verbal_order_yn = "N";
				}// Added for AAKH-CRF-0023[IN:038259]
			if(allow_med_admin_wo_ord_yn.equals("")){
				allow_med_admin_wo_ord_yn = "N";
				witness_for_verbal_order_yn = "N";// Added for AAKH-CRF-0023[IN:038259]
			}

			//insertData.add( allow_usage_of_spil_qty_yn.trim());
			//insertData.add( charge_qty_ind.trim());
			insertData.add( med_admin_reqd_yn.trim());
			insertData.add( verf_reqd_bef_med_admin_yn.trim());
			insertData.add( rec_admin_within_hrs.trim());
			insertData.add( allow_med_admin_wo_ord_yn.trim());
			insertData.add( ip_consider_stock );	
			insertData.add( ip_allow_stock );		
			insertData.add( allow_duplicate_drug );
			insertData.add( allow_medn_order_without_diag);
			insertData.add( allow_medn_order_without_wt);
			//code for unallocated orders...on 29/4/2004

			insertData.add( unalloc_order_del_st);
			insertData.add( print_exp_date_on_lbl);

			insertData.add(direct_dispensing_allowed);
			insertData.add(patientclass.trim());
			insertData.add(applicable_encounter.trim());
			insertData.add(consider_last.trim()) ;
			insertData.add(encounter_details_required.trim());
			insertData.add(duplicate_check_atc.trim());	
			insertData.add(remarks_for_prn.trim());           

			insertData.add(comp_rx_appl_yn);
			insertData.add(iv_rx_appl_yn);
			insertData.add(oncology_rx_appl_yn);
			insertData.add(tpn_rx_appl_yn) ;
			insertData.add(tdm_appl_yn);
			insertData.add(tdm_result_type);	
			insertData.add(pat_couns_result_type);
			insertData.add(tdm_reporting_id);
			insertData.add(pat_couns_reporting_id);

			if(drug_db_interface_yn.equals("")){
				drug_db_interface_yn ="N";
			}

			if(drug_db_dosecheck_yn.equals("")){
				drug_db_dosecheck_yn ="N";
			}

			if(drug_db_duptherapy_yn.equals("")){
				drug_db_duptherapy_yn = "N";
			}
			  
			if(drug_db_interaction_yn.equals("")){
				drug_db_interaction_yn = "N";
			}

			if(drug_db_contracheck_yn.equals("")){
				drug_db_contracheck_yn = "N";
			}

			if(drug_db_alergycheck_yn.equals("")){
				drug_db_alergycheck_yn = "N";
			}

			if(inpatient_yn.equals("")){
				inpatient_yn = "N";
			}

			if(Outpatient_yn.equals("")){
				Outpatient_yn = "N";
			}

			if(Daycare_yn.equals("")){
				Daycare_yn = "N";
			}

			if(emergency_yn.equals("")){
				emergency_yn = "N";
			}
			if(Disch_Med_Mar_Appl_yn.equals("")){
				Disch_Med_Mar_Appl_yn= "N";
			}
            
			//added for ML-MMOH-CRF-1637 - start
			if(pat_trans_phar_type==null)
				pat_trans_phar_type = "N";
			
			if(pat_trans_other_type==null)
				pat_trans_phar_type = null;
			//added for ML-MMOH-CRF-1637 - end

			if(display_verif_drug_inst_remarks_yn==null|| display_verif_drug_inst_remarks_yn.equals(""))
				display_verif_drug_inst_remarks_yn = "N"; //added for ML-MMOH-CRF-1755

			 insertData.add(drug_db_interface_yn);
			 insertData.add(drug_db_interface_name);
			 insertData.add(drug_db_dosecheck_yn);
			 insertData.add(drug_db_duptherapy_yn);
			 insertData.add(drug_db_interaction_yn);
			 insertData.add(drug_db_contracheck_yn);
			 insertData.add(drug_db_alergycheck_yn);
					 
			 insertData.add(Daycare_yn);
			 insertData.add(emergency_yn);
			 insertData.add(inpatient_yn);
			 insertData.add(Outpatient_yn);
			 
			//@ insert 3 fields ...
			insertData.add(display_charge_details_lkp.trim());           
			insertData.add(display_charge_details_prescription.trim());           
			insertData.add(display_price_type_lkp.trim());
			insertData.add(Disch_Med_Mar_Appl_yn);
			insertData.add(admx_prep_charges_appl_yn);
			insertData.add(split_based_priority_yn);
			insertData.add(split_based_drug_class_yn);
			insertData.add(dflt_dir_disp_locn);
			insertData.add(dflt_ext_rx_disp_locn);
			insertData.add(tpn_reporting_id);
			insertData.add(tpn_screening_type);
			insertData.add(onc_reporting_id);
			insertData.add(oncology_screening_type);
			insertData.add( drug_cat_pin_auth_reqd_yn.trim());
			insertData.add(allow_short_expiry_drugs_yn.trim());
			insertData.add(copy_pres_upto_no_of_days.trim());

			//code for copy presciption data added			
			insertData.add(include_zero_allocated_items_in_dispensing.trim());//added for INCLUDE ZERO ALLOC ITEMS on 07-03-09

			//code addeed for recording MAR before Schedule time --by Abdul
			insertData.add(rec_admin_bef_schdle_time.trim());
			insertData.add(rec_admin_bef_schdle_time_UOM);
			insertData.add(ip_daily_seq_no_yn.trim());

			//Added for CRF-713 --INC 12785
			insertData.add(narcotic_aprvl_form_req_yn.trim());
			insertData.add(print_narcotic_form_by_default.trim());

			insertData.add(edit_disp_label_after_del.trim());
			insertData.add(rx_qty_by_pres_base_uom_yn.trim());  //added for Prescribe Quantity by Prescribing Unit check  box on7/12/09
			insertData.add(dflt_ip_fill_incr_start_with.trim());
			if(inpatient_yn_rule_check.equals("")){
				inpatient_yn_rule_check = "N";
			}

			if(outpatient_yn_rule_check.equals("")){
				outpatient_yn_rule_check = "N";
			}

			if(daycare_yn_rule_check.equals("")){
				daycare_yn_rule_check = "N";
			}

			if(emergency_yn_rule_check.equals("")){
				emergency_yn_rule_check = "N";
			}

			if(dischmedic_yn_rule_check.equals("")){
				dischmedic_yn_rule_check = "N";
			}
			if(atc_allergy_alert_level.equals("")){
				atc_allergy_alert_level = "N";
			}
			if(tab_based_group_sort_disp==null || tab_based_group_sort_disp.equals("")){
				tab_based_group_sort_disp = "N";
			}

			insertData.add(inpatient_yn_rule_check);         
			insertData.add(outpatient_yn_rule_check);
			insertData.add(daycare_yn_rule_check);         
			insertData.add(emergency_yn_rule_check);         
			insertData.add(dischmedic_yn_rule_check);         
			insertData.add(atc_allergy_alert_level);         
			insertData.add(tab_based_group_sort_disp);         
			//IN30118-SCF No: MO-GN-5400. Inserting For OutPatient Duplicate Drug Check.
			insertData.add( allow_duplicate_drug_op );
			insertData.add( discont_canc_dup_medic ); //added for Bru-HIMS-CRF-265 [IN:032315]
			insertData.add( disp_exp_orders_yn ); //added for Bru-HIMS-CRF-265 [IN:032315]
			insertData.add( pin_auth_mar_yn ); //added for RUT-CRF-0035 [IN029926] 
			insertData.add( allow_medn_ord_without_diag_dd);//added for CRF MMS-QH-CRF-0068 [IN:037980]
			insertData.add( print_mar_label_yn);//added for MMS-QH-CRF-0080 [IN:038064]
			insertData.add( alt_drug_remarks_ind);//added for Bru-HIMS-CRF-082 [IN:029948] 
			insertData.add( mar_sch_level_yn);//added for SKR-CRF-0037 [IN:037656] -Start
			insertData.add( mar_start_ind);
			insertData.add( mar_week_day_start);
			insertData.add( mar_past_day);
			insertData.add( mar_future_day);
			insertData.add( mar_default_order_by);
			insertData.add( mar_disc_dose_yn);
			insertData.add( mar_iv_compl_dt_ind);//added for SKR-CRF-0037 [IN:037656] -End
			insertData.add( allergy_conf_reqd_yn);//added for RUT-CRF-0064.1 [IN:041799]
			insertData.add( mar_disp_held_disc_orders_yn);//added for [IN:043283] 

			insertData.add( disp_before_start_date_yn_ip); //added for AMS-CRF-0009[IN:030935] -start
			insertData.add( disp_before_no_of_days_ip);
			insertData.add( disp_beyond_earliest_start_yn_ip);
			insertData.add( disp_beyond_no_of_days_ip);   //added for AMS-CRF-0009[IN:030935] -end
			insertData.add( witness_for_verbal_order_yn);// Added for AAKH-CRF-0023[IN:038259]
			insertData.add( strDefaultFreqforIV);//Added for Bru-HIMS-CRF-384[IN041642]
			insertData.add( em_medctn_fwd_ip_yn);//Added for Bru-HIMS-CRF-402[IN044065]
			insertData.add( cary_frwd_ord_nofhrs);//Added for Bru-HIMS-CRF-402[IN044065]
			insertData.add( disp_rx_duration_yn);//Added for Bru-HIMS-CRF-403[IN044541]
			insertData.add( diag_for_medn_order_by);//Added for  MMS-SCF-0325 [IN:048069]
			insertData.add( allow_mar_share_drug_yn);//added for HSA-CRF-0090 [IN:041241]
			insertData.add( allow_renew_from_chart_summ_yn);//Added for Bru-HIMS-CRF-400
			insertData.add( can_discon_dup_orders_def_sel);//Added for HSA-CRF-0151 [IN048468]
			insertData.add(allow_auto_disp_alt_drug_mar);//Added for Bru-HIMS-CRF-399 [IN:043767]
			insertData.add(preview_rx_yn); //Added for ML-MMOH-CRF-0341 [IN:057179]
			insertData.add(disp_prev_vital_signs_yn); //Added for ML-MMOH-CRF-0346 [IN:057185]
			insertData.add(getGeneric_Code());//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
			insertData.add(getWorkingFrom());//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
			insertData.add(getWorkingTo());//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
			insertData.add(allow_amend_alt_drug_dtl);//Allow_Amd_Alt_DRug_Dt Added by prathyusha for JD-CRF-198 on 05/05/2016
			//Modified for MO-CRF-20085.1 skp_dupl_alrt_op,skp_dupl_alrt_ip Added By prathyusha 05/18/2016
			//Added By Prathyusha for MO-CRF-20085.1 ON 05/26/2016  OVERLAP_PERIOD_FOR_OP,OVERLAP_PERIOD_FOR_IP
			insertData.add(skip_duplicate_alert_op);
			insertData.add(skip_duplicate_alert_ip);
			insertData.add(overlap_period_for_op);
			insertData.add(overlap_period_for_ip);
			insertData.add(ret_medic_restr_stage);// Added for GHL-CRF-0412.3
			insertData.add(split_drug_based_auth_yn.trim());//split_drug_based_auth_yn added for ml-mmoh-crf-0864 
            insertData.add(include_ip_zero_allocated_drugs_for_dispense.trim());//Added for ML-BRU-CRF-0473
            insertData.add(assesment_req_yn.trim());// Added for ML-MMOH-CRF-1126
            insertData.add(late_or_early_admin.trim());// Added for GHL-CRF-0482 [IN:064955]
            insertData.add(allow_alternate_for_medical_item_yn.trim());//added for ghl-crf-548
            insertData.add(ward_ack_required_yn.trim());//added forMMS-KH-CRF-0014
            insertData.add(ward_ack_mar_required_yn.trim());//added forMMS-KH-CRF-0014
			insertData.add(display_generic_name_yn.trim());//Added for NMC-JD-CRF-0001
			insertData.add(reconciliation_ip.trim());//ADDED FOR MMS-KH-CRF-0016
			insertData.add(review_aprrove_applicable_for_ip.trim());//Added for MMS-KH-CRF-0028
			insertData.add(review_aprrove_applicable_for_op.trim());//Added for MMS-KH-CRF-0028
			insertData.add(approval_no_yn_ip.trim()); //Added for AAKH-CRF-0117
			insertData.add(approval_no_yn_op.trim()); //Added for AAKH-CRF-0117
			insertData.add(op_disch_med_disp_locn);//Added for 6041
			insertData.add(pre_alloc_appl_yn.trim()); //Added for MMS-DM-CRF-0177
			insertData.add(near_expiry_appl_yn.trim()); //Added for MMS-DM-CRF-0177
			insertData.add(durn_value.trim()); //Added for MMS-DM-CRF-0177
			insertData.add(durn_type.trim()); //Added for MMS-DM-CRF-0177
			insertData.add(durn_value_in_days.trim()); //Added for MMS-DM-CRF-0177
			insertData.add(default_disp_locn.trim());//Added for TFS id:-16341

			insertData.add(pat_trans_phar_type.trim()); //added for ML-MMOH-CRF-1637
			insertData.add(pat_trans_other_type.trim());//added ML-MMOH-CRF-1637
			insertData.add(drug_indication_mdry.trim());//added for JD-CRF-0220
			insertData.add(disp_auto_refresh.trim());//Added for TH-KW-CRF-0011
			insertData.add(display_verif_drug_inst_remarks_yn.trim()); //added ML-MMOH-CRF-1755
	if(Amend_orderwise_DispMedication_yn==""){//added for ml-mmoh-crf-1748
				Amend_orderwise_DispMedication_yn="N";
			}
			insertData.add(Amend_orderwise_DispMedication_yn);//added for ml-mmoh-crf-1748
			insertData.add(do_not_display_sensitive_diagnosis_yn);//added for ML-BRU-CRF-0630
			insertData.add(disp_sens_diag_ind_pre_rep_yn);//added for ML-BRU-CRF-0630
			insertData.add(mar_disp_unbilled_med_yn); //added for NMC=JD-CRF-0186  <!-- 42911 -->

			insertData.add(quota_limit_calculation_required_yn); //added for ML-MMOH-CRF-1823
			insertData.add(active_prescription_enabled_for_quota_limit_yn); //added for ML-MMOH-CRF-1823
			
			 //Added for MMS-CRF-0233 by Ayesha Khan
		    insertData.add( print_footer_dtls_pres_yn); 
		    insertData.add( print_pres_dtl_en);
		    insertData.add( print_pres_dtl_loc);
		    //Ended for MMS-CRF-0233 by Ayesha Khan

			insertData.add( always_display_dispense_location_yn ); // added for NMC-JD-CRF-0197	

			
            whereData.add( facility_id ) ;
			//insertData.add(onc_result_type);
			//insertData.add(onc_reporting_id);
            tabData.put( "properties", getProperties() );
            tabData.put( "InsertData",insertData);
            tabData.put( "WhereData",whereData);

			sqlMap.put( "SelectSQL", PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT5") );
			//sqlMap.put( "InsertSQL", PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_INSERT") );
			//sqlMap.put( "InsertSQL", "INSERT INTO PH_FACILITY_PARAM(FACILITY_ID, INTERFACE_TO_ST_YN, PAT_INSTR_LOC_LANG_YN, CONSIDER_STOCK_FOR_PRES_YN, ALLOW_PRES_WITHOUT_STOCK_YN, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, DISP_FLNG_REQD_YN,DISP_FILL_STAGE,DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, DFLT_LANG_FOR_DISP_LABEL, LABEL_FORMAT_OP, ALLOW_DRUG_RETURN_YN, MAX_DRUG_RETENTION_BEF_RTN, MAX_DURN_FOR_OP_MED_RTN, IP_VERF_YN, IP_FILL_PRD_UNIT, IP_FILL_PRD_AHEAD, IP_FILL_EXCL_PRD_BEHIND, IP_DELV_REQD_YN, IP_FILL_DFLT_START_TIME, DFLT_LANG_FOR_DISP_LABEL_IP, IP_LABEL_FORMAT, INTERFACE_TO_BL_YN, OP_DISP_LOCN_RTN_ORD, OP_DISP_LOCN_STAT_ORD, DISP_REGN_REQD_YN, DISP_VERF_STAGE, PRINT_BAL_MED_SHEET_OP_YN, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, DISCH_MED_DISP_LOCN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,MED_ADMIN_REQD_YN, VERF_REQD_BEF_MED_ADMIN_YN, REC_ADMIN_WITHIN_HRS, ALLOW_MED_ADMIN_WO_ORD_YN,IP_CONSIDER_STOCK_PRES_YN,  IP_PRES_WITHOUT_STOCK_YN,ALLOW_DUPLICATE_DRUG,ALLOW_MEDN_ORDER_WITHOUT_DIAG,ALLOW_MEDN_ORDER_WITHOUT_WT,DISP_UNALLOC_DRUGS_AT_DEL_STG,PRINT_EXP_DATE_FOR_EXP_ITEM,DIR_DISP_ALLOWED, APPL_PT_CLASS, APPL_ENCTRS, HOW_MANY_ENCTRS,  ENCTRS_DTLS_REQD_DUR_DIR_DISP,DUPLICATE_CHECK_AT_ATC_YN,MANDATORY_REM_ON_PRN_FREQ_YN, COMP_RX_APPL_YN, IV_RX_APPL_YN, ONCOLOGY_RX_APPL_YN, TPN_RX_APPL_YN, TDM_APPL_YN, TDM_RESULT_TYPE, PAT_COUNS_RESULT_TYPE ,tdm_result_type_id, pat_couns_result_type_id,DRUG_DB_INTERFACE_YN,DRUG_DB_PRODUCT_ID,DRUG_DB_DOSECHECK_YN,DRUG_DB_DUPTHERAPY_YN,DRUG_DB_INTERACT_CHECK_YN,DRUG_DB_CONTRAIND_CHECK_YN,DRUG_DB_ALLERGY_CHECK_YN,DC_MAR_APPL_YN,EM_MAR_APPL_YN,IP_MAR_APPL_YN,OP_MAR_APPL_YN,DISP_CHARGE_DTL_IN_DRUG_LKP_YN,DISP_CHARGE_DTL_IN_RX_YN,DISP_PRICE_TYPE_IN_DRUG_LKP,DISCH_MED_MAR_APPL_YN,ADMX_PREP_CHARGES_APPL_YN,SPLIT_BASED_PRIORITY_YN,SPLIT_BASED_DRUG_CLASS_YN,DFLT_DIR_DISP_LOCN,DFLT_EXT_RX_DISP_LOCN,) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			// sqlMap.put( "InsertSQL", "INSERT INTO PH_FACILITY_PARAM(FACILITY_ID, INTERFACE_TO_ST_YN, PAT_INSTR_LOC_LANG_YN, CONSIDER_STOCK_FOR_PRES_YN, ALLOW_PRES_WITHOUT_STOCK_YN, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, DISP_FLNG_REQD_YN,DISP_FILL_STAGE,DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, DFLT_LANG_FOR_DISP_LABEL, LABEL_FORMAT_OP, ALLOW_DRUG_RETURN_YN, MAX_DRUG_RETENTION_BEF_RTN, MAX_DURN_FOR_OP_MED_RTN, IP_VERF_YN, IP_FILL_PRD_UNIT, IP_FILL_PRD_AHEAD, IP_FILL_EXCL_PRD_BEHIND, IP_DELV_REQD_YN, IP_FILL_DFLT_START_TIME, DFLT_LANG_FOR_DISP_LABEL_IP, IP_LABEL_FORMAT, INTERFACE_TO_BL_YN, OP_DISP_LOCN_RTN_ORD, OP_DISP_LOCN_STAT_ORD, DISP_REGN_REQD_YN, DISP_VERF_STAGE, PRINT_BAL_MED_SHEET_OP_YN, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, DISCH_MED_DISP_LOCN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,MED_ADMIN_REQD_YN, VERF_REQD_BEF_MED_ADMIN_YN, REC_ADMIN_WITHIN_HRS, ALLOW_MED_ADMIN_WO_ORD_YN,IP_CONSIDER_STOCK_PRES_YN,  IP_PRES_WITHOUT_STOCK_YN,ALLOW_DUPLICATE_DRUG,ALLOW_MEDN_ORDER_WITHOUT_DIAG,ALLOW_MEDN_ORDER_WITHOUT_WT,DISP_UNALLOC_DRUGS_AT_DEL_STG,PRINT_EXP_DATE_FOR_EXP_ITEM,DIR_DISP_ALLOWED, APPL_PT_CLASS, APPL_ENCTRS, HOW_MANY_ENCTRS,  ENCTRS_DTLS_REQD_DUR_DIR_DISP,DUPLICATE_CHECK_AT_ATC_YN,MANDATORY_REM_ON_PRN_FREQ_YN, COMP_RX_APPL_YN, IV_RX_APPL_YN, ONCOLOGY_RX_APPL_YN, TPN_RX_APPL_YN, TDM_APPL_YN, TDM_RESULT_TYPE, PAT_COUNS_RESULT_TYPE ,tdm_result_type_id, pat_couns_result_type_id,DRUG_DB_INTERFACE_YN,DRUG_DB_PRODUCT_ID,DRUG_DB_DOSECHECK_YN,DRUG_DB_DUPTHERAPY_YN,DRUG_DB_INTERACT_CHECK_YN,DRUG_DB_CONTRAIND_CHECK_YN,DRUG_DB_ALLERGY_CHECK_YN,DC_MAR_APPL_YN,EM_MAR_APPL_YN,IP_MAR_APPL_YN,OP_MAR_APPL_YN,DISP_CHARGE_DTL_IN_DRUG_LKP_YN,DISP_CHARGE_DTL_IN_RX_YN,DISP_PRICE_TYPE_IN_DRUG_LKP,DISCH_MED_MAR_APPL_YN,ADMX_PREP_CHARGES_APPL_YN,SPLIT_BASED_PRIORITY_YN,SPLIT_BASED_DRUG_CLASS_YN,DFLT_DIR_DISP_LOCN,DFLT_EXT_RX_DISP_LOCN,TPN_SCREENING_FORM_ID,TPN_SCREENING_TYPE,ONCOLOGY_SCREENING_FORM_ID,ONCOLOGY_SCREENING_TYPE,DRUG_CAT_PIN_AUTH_REQD_YN,ALLOW_SHORT_EXPIRY_DRUGS_YN,COPY_PRES_UPTO_NO_OF_DAYS) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			// sqlMap.put( "InsertSQL", "INSERT INTO PH_FACILITY_PARAM(FACILITY_ID, INTERFACE_TO_ST_YN, PAT_INSTR_LOC_LANG_YN, CONSIDER_STOCK_FOR_PRES_YN, ALLOW_PRES_WITHOUT_STOCK_YN, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, DISP_FLNG_REQD_YN,DISP_FILL_STAGE,DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, DFLT_LANG_FOR_DISP_LABEL, LABEL_FORMAT_OP, ALLOW_DRUG_RETURN_YN, MAX_DRUG_RETENTION_BEF_RTN, MAX_DURN_FOR_OP_MED_RTN, IP_VERF_YN, IP_FILL_PRD_UNIT, IP_FILL_PRD_AHEAD, IP_FILL_EXCL_PRD_BEHIND, IP_DELV_REQD_YN, IP_FILL_DFLT_START_TIME, DFLT_LANG_FOR_DISP_LABEL_IP, IP_LABEL_FORMAT, INTERFACE_TO_BL_YN, OP_DISP_LOCN_RTN_ORD, OP_DISP_LOCN_STAT_ORD, DISP_REGN_REQD_YN, DISP_VERF_STAGE, PRINT_BAL_MED_SHEET_OP_YN, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, DISCH_MED_DISP_LOCN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,MED_ADMIN_REQD_YN, VERF_REQD_BEF_MED_ADMIN_YN, REC_ADMIN_WITHIN_HRS, ALLOW_MED_ADMIN_WO_ORD_YN,IP_CONSIDER_STOCK_PRES_YN,  IP_PRES_WITHOUT_STOCK_YN,ALLOW_DUPLICATE_DRUG,ALLOW_MEDN_ORDER_WITHOUT_DIAG,ALLOW_MEDN_ORDER_WITHOUT_WT,DISP_UNALLOC_DRUGS_AT_DEL_STG,PRINT_EXP_DATE_FOR_EXP_ITEM,DIR_DISP_ALLOWED, APPL_PT_CLASS, APPL_ENCTRS, HOW_MANY_ENCTRS,  ENCTRS_DTLS_REQD_DUR_DIR_DISP,DUPLICATE_CHECK_AT_ATC_YN,MANDATORY_REM_ON_PRN_FREQ_YN, COMP_RX_APPL_YN, IV_RX_APPL_YN, ONCOLOGY_RX_APPL_YN, TPN_RX_APPL_YN, TDM_APPL_YN, TDM_RESULT_TYPE, PAT_COUNS_RESULT_TYPE ,tdm_result_type_id, pat_couns_result_type_id,DRUG_DB_INTERFACE_YN,DRUG_DB_PRODUCT_ID,DRUG_DB_DOSECHECK_YN,DRUG_DB_DUPTHERAPY_YN,DRUG_DB_INTERACT_CHECK_YN,DRUG_DB_CONTRAIND_CHECK_YN,DRUG_DB_ALLERGY_CHECK_YN,DC_MAR_APPL_YN,EM_MAR_APPL_YN,IP_MAR_APPL_YN,OP_MAR_APPL_YN,DISP_CHARGE_DTL_IN_DRUG_LKP_YN,DISP_CHARGE_DTL_IN_RX_YN,DISP_PRICE_TYPE_IN_DRUG_LKP,DISCH_MED_MAR_APPL_YN,ADMX_PREP_CHARGES_APPL_YN,SPLIT_BASED_PRIORITY_YN,SPLIT_BASED_DRUG_CLASS_YN,DFLT_DIR_DISP_LOCN,DFLT_EXT_RX_DISP_LOCN,TPN_SCREENING_FORM_ID,TPN_SCREENING_TYPE,ONCOLOGY_SCREENING_FORM_ID,ONCOLOGY_SCREENING_TYPE,DRUG_CAT_PIN_AUTH_REQD_YN,ALLOW_SHORT_EXPIRY_DRUGS_YN,COPY_PRES_UPTO_NO_OF_DAYS,INCLUDE_ZERO_ALLOC_QTY_ITEMS,REC_ADMIN_AHEAD_PRD, REC_ADMIN_AHEAD_TYPE,IP_DSN_YN,NARCOTIC_APRVL_FORM_REQ_YN,PRINT_NARCOTIC_FORM_BY_DEFAULT,EDIT_DISP_LABEL_AFTER_DEL,) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') ||?,'DD/MM/RRRR HH24:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//sqlMap.put( "InsertSQL", "INSERT INTO PH_FACILITY_PARAM(FACILITY_ID, INTERFACE_TO_ST_YN, PAT_INSTR_LOC_LANG_YN, CONSIDER_STOCK_FOR_PRES_YN, ALLOW_PRES_WITHOUT_STOCK_YN, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, DISP_FLNG_REQD_YN,DISP_FILL_STAGE,DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, DFLT_LANG_FOR_DISP_LABEL, LABEL_FORMAT_OP, ALLOW_DRUG_RETURN_YN, MAX_DRUG_RETENTION_BEF_RTN, MAX_DURN_FOR_OP_MED_RTN, IP_VERF_YN, IP_FILL_PRD_UNIT, IP_FILL_PRD_AHEAD, IP_FILL_EXCL_PRD_BEHIND, IP_DELV_REQD_YN, IP_FILL_DFLT_START_TIME, DFLT_LANG_FOR_DISP_LABEL_IP, IP_LABEL_FORMAT, INTERFACE_TO_BL_YN, OP_DISP_LOCN_RTN_ORD, OP_DISP_LOCN_STAT_ORD, DISP_REGN_REQD_YN, DISP_VERF_STAGE, PRINT_BAL_MED_SHEET_OP_YN, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, DISCH_MED_DISP_LOCN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,MED_ADMIN_REQD_YN, VERF_REQD_BEF_MED_ADMIN_YN, REC_ADMIN_WITHIN_HRS, ALLOW_MED_ADMIN_WO_ORD_YN,IP_CONSIDER_STOCK_PRES_YN,  IP_PRES_WITHOUT_STOCK_YN,ALLOW_DUPLICATE_DRUG,ALLOW_MEDN_ORDER_WITHOUT_DIAG,ALLOW_MEDN_ORDER_WITHOUT_WT,DISP_UNALLOC_DRUGS_AT_DEL_STG,PRINT_EXP_DATE_FOR_EXP_ITEM,DIR_DISP_ALLOWED, APPL_PT_CLASS, APPL_ENCTRS, HOW_MANY_ENCTRS,  ENCTRS_DTLS_REQD_DUR_DIR_DISP,DUPLICATE_CHECK_AT_ATC_YN,MANDATORY_REM_ON_PRN_FREQ_YN, COMP_RX_APPL_YN, IV_RX_APPL_YN, ONCOLOGY_RX_APPL_YN, TPN_RX_APPL_YN, TDM_APPL_YN, TDM_RESULT_TYPE, PAT_COUNS_RESULT_TYPE ,tdm_result_type_id, pat_couns_result_type_id,DRUG_DB_INTERFACE_YN,DRUG_DB_PRODUCT_ID,DRUG_DB_DOSECHECK_YN,DRUG_DB_DUPTHERAPY_YN,DRUG_DB_INTERACT_CHECK_YN,DRUG_DB_CONTRAIND_CHECK_YN,DRUG_DB_ALLERGY_CHECK_YN,DC_MAR_APPL_YN,EM_MAR_APPL_YN,IP_MAR_APPL_YN,OP_MAR_APPL_YN,DISP_CHARGE_DTL_IN_DRUG_LKP_YN,DISP_CHARGE_DTL_IN_RX_YN,DISP_PRICE_TYPE_IN_DRUG_LKP,DISCH_MED_MAR_APPL_YN,ADMX_PREP_CHARGES_APPL_YN,SPLIT_BASED_PRIORITY_YN,SPLIT_BASED_DRUG_CLASS_YN,DFLT_DIR_DISP_LOCN,DFLT_EXT_RX_DISP_LOCN,TPN_SCREENING_FORM_ID,TPN_SCREENING_TYPE,ONCOLOGY_SCREENING_FORM_ID,ONCOLOGY_SCREENING_TYPE,DRUG_CAT_PIN_AUTH_REQD_YN,ALLOW_SHORT_EXPIRY_DRUGS_YN,COPY_PRES_UPTO_NO_OF_DAYS,INCLUDE_ZERO_ALLOC_QTY_ITEMS,REC_ADMIN_AHEAD_PRD, REC_ADMIN_AHEAD_TYPE,IP_DSN_YN,NARCOTIC_APRVL_FORM_REQ_YN,PRINT_NARCOTIC_FORM_BY_DEFAULT,EDIT_DISP_LABEL_AFTER_DEL,RX_QTY_BY_PRES_BASE_UOM_YN,DFLT_IP_FILL_INCR_START_WITH,IP_MAR_RULE_YN,OP_MAR_RULE_YN,DC_MAR_RULE_YN,EM_MAR_RULE_YN, DM_MAR_RULE_YN,atc_allergy_alert_level, TAB_BASED_GROUP_SORT_DISP, ALLOW_DUPLICATE_DRUG_OP,CAN_DISCON_DUP_ORDERS,DISP_EXPIRIED_ORDERS,MAR_AUTH_REQD_YN,ALLOW_MEDN_ORD_WITHOUT_DIAG_DD, PRINT_MAR_LABEL_YN, ALT_DRUG_REMARKS_IND, MAR_SCH_LEVEL_YN, MAR_START_IND, MAR_WEEK_DAY_START, MAR_PAST_DAY, MAR_FUTURE_DAY, MAR_DEFAULT_ORDER_BY , MAR_DISC_DOSE_YN, MAR_IV_COMPL_DT_IND, ALLERGY_CONF_REQD_YN, MAR_DISP_HELD_DISC_ORDERS_YN,DISP_BEFORE_START_DATE_IP_YN,DISP_BEFORE_NO_OF_DAYS_IP,DISP_BEYOND_EARLST_STRT_IP_YN,DISP_BEYOND_NO_OF_DAYS_IP, VERBAL_ORDER_WITNESS_YN,IV_DEFAULT_FREQUENCY, em_medctn_fwd_ip_yn, CARY_FRWD_ORD_NOFHRS, disp_rx_duration_YN, diag_for_medn_order_by, allow_mar_share_drug_yn,allow_renew_from_chart_summ_yn, can_discon_dup_orders_def_sel, ALLOW_AUTO_DISP_ALT_DRUG_MAR, PREVIEW_RX_YN, DISP_PREV_VITAL_SIGNS_YN) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') || ?,'DD/MM/RRRR HH24:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?, ?,?,?, ?, ? )");   //Added CAN_DISCON_DUP_ORDERS Column for Bru-HIMS-CRF-265 [IN:032315] , DISP_EXPIRIED_ORDERS for ML-BRU-SCF-0636 [IN036826]  MAR_AUTH_REQD_YN Added for RUT-CRF-0035 [IN029926],ALLOW_MEDN_ORD_WITHOUT_DIAG_DD added for CRF MMS-QH-CRF-0068 [IN:037980],DISP_BEFORE_START_DATE_IP_YN,DISP_BEFORE_NO_OF_DAYS_IP,DISP_BEYOND_EARLST_STRT_IP_YN,DISP_BEYOND_NO_OF_DAYS_IP added for AMS-CRF-0009[IN:030935] //Added VERBAL_ORDER_WITNESS_YN for AAKH-CRF-0023[IN:038259]//Added IV_DEFAULT_FREQUENCY for Bru-HIMS-CRF-384[IN041642], em_medctn_fwd_ip_yn, CARY_FRWD_ORD_NOFHRS - for Bru-HIMS-CRF-402[IN044065], disp_rx_duration_YN - for Bru-HIMS-CRF-403[IN044541] diag_for_medn_order_by for MMS-SCF-0325 [IN:048069],ALLOW_RENEW_FROM_CHART_SUMM_YN  Added for Bru-HIMS-CRF-400 preview_rx_yn Added for ML-MMOH-CRF-0341 [IN:057179] //Added disp_prev_vital_signs_yn for ML-MMOH-CRF-0346 [IN:057185]
			//Modified for MO-CRF-20085.1 SKP_DUPL_ALRT_OP_YN,SKP_DUPL_ALRT_IP_YN Added By prathyusha 05/18/2016
			//split_drug_based_auth_yn added for ml-mmoh-crf-0864 
	        //ALLOW_ALT_FOR_MEDICAL_ITEM_YN added for ghl-crf-0548
			//WARD_ACK_REQUIRED_YN,WARD_ACK_MAR_REQUIRED_YN added for MMS-KH-CRF-0014
			//REVIEW_APRROVE_APPLICABLE_FOR_IP,REVIEW_APRROVE_APPLICABLE_FOR_OP added for MMS-KH-CRF-0028//added for AMEND_ORD_WISE_DISP_MED
			sqlMap.put( "InsertSQL", "INSERT INTO PH_FACILITY_PARAM(FACILITY_ID, INTERFACE_TO_ST_YN, PAT_INSTR_LOC_LANG_YN, CONSIDER_STOCK_FOR_PRES_YN, ALLOW_PRES_WITHOUT_STOCK_YN, REFILL_YN, MAX_REFILLS_FOR_PRES, PRINT_REFILL_PRES_WITH_MAIN_YN, MAX_DURN_FOR_REFILL_PRES, DISP_BEFORE_START_DATE_YN, DISP_BEFORE_NO_OF_DAYS, DISP_BEYOND_EARLIEST_START_YN, DISP_BEYOND_NO_OF_DAYS, DISP_FLNG_REQD_YN,DISP_FILL_STAGE,DISP_DELV_REQD_YN, PRINT_DISP_SHEET_OP_YN, DFLT_LANG_FOR_DISP_LABEL, LABEL_FORMAT_OP, ALLOW_DRUG_RETURN_YN, MAX_DRUG_RETENTION_BEF_RTN, MAX_DURN_FOR_OP_MED_RTN, IP_VERF_YN, IP_FILL_PRD_UNIT, IP_FILL_PRD_AHEAD, IP_FILL_EXCL_PRD_BEHIND, IP_DELV_REQD_YN, IP_FILL_DFLT_START_TIME, DFLT_LANG_FOR_DISP_LABEL_IP, IP_LABEL_FORMAT, INTERFACE_TO_BL_YN, OP_DISP_LOCN_RTN_ORD, OP_DISP_LOCN_STAT_ORD, DISP_REGN_REQD_YN, DISP_VERF_STAGE, PRINT_BAL_MED_SHEET_OP_YN, IP_DISP_LOCN_RTN_ORD, IP_DISP_LOCN_STAT_ORD, DISCH_MED_DISP_LOCN, ADDED_BY_ID, ADDED_DATE, ADDED_AT_WS_NO, ADDED_FACILITY_ID, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_AT_WS_NO, MODIFIED_FACILITY_ID,MED_ADMIN_REQD_YN, VERF_REQD_BEF_MED_ADMIN_YN, REC_ADMIN_WITHIN_HRS, ALLOW_MED_ADMIN_WO_ORD_YN,IP_CONSIDER_STOCK_PRES_YN,  IP_PRES_WITHOUT_STOCK_YN,ALLOW_DUPLICATE_DRUG,ALLOW_MEDN_ORDER_WITHOUT_DIAG,ALLOW_MEDN_ORDER_WITHOUT_WT,DISP_UNALLOC_DRUGS_AT_DEL_STG,PRINT_EXP_DATE_FOR_EXP_ITEM,DIR_DISP_ALLOWED, APPL_PT_CLASS, APPL_ENCTRS, HOW_MANY_ENCTRS,  ENCTRS_DTLS_REQD_DUR_DIR_DISP,DUPLICATE_CHECK_AT_ATC_YN,MANDATORY_REM_ON_PRN_FREQ_YN, COMP_RX_APPL_YN, IV_RX_APPL_YN, ONCOLOGY_RX_APPL_YN, TPN_RX_APPL_YN, TDM_APPL_YN, TDM_RESULT_TYPE, PAT_COUNS_RESULT_TYPE ,tdm_result_type_id, pat_couns_result_type_id,DRUG_DB_INTERFACE_YN,DRUG_DB_PRODUCT_ID,DRUG_DB_DOSECHECK_YN,DRUG_DB_DUPTHERAPY_YN,DRUG_DB_INTERACT_CHECK_YN,DRUG_DB_CONTRAIND_CHECK_YN,DRUG_DB_ALLERGY_CHECK_YN,DC_MAR_APPL_YN,EM_MAR_APPL_YN,IP_MAR_APPL_YN,OP_MAR_APPL_YN,DISP_CHARGE_DTL_IN_DRUG_LKP_YN,DISP_CHARGE_DTL_IN_RX_YN,DISP_PRICE_TYPE_IN_DRUG_LKP,DISCH_MED_MAR_APPL_YN,ADMX_PREP_CHARGES_APPL_YN,SPLIT_BASED_PRIORITY_YN,SPLIT_BASED_DRUG_CLASS_YN,DFLT_DIR_DISP_LOCN,DFLT_EXT_RX_DISP_LOCN,TPN_SCREENING_FORM_ID,TPN_SCREENING_TYPE,ONCOLOGY_SCREENING_FORM_ID,ONCOLOGY_SCREENING_TYPE,DRUG_CAT_PIN_AUTH_REQD_YN,ALLOW_SHORT_EXPIRY_DRUGS_YN,COPY_PRES_UPTO_NO_OF_DAYS,INCLUDE_ZERO_ALLOC_QTY_ITEMS,REC_ADMIN_AHEAD_PRD, REC_ADMIN_AHEAD_TYPE,IP_DSN_YN,NARCOTIC_APRVL_FORM_REQ_YN,PRINT_NARCOTIC_FORM_BY_DEFAULT,EDIT_DISP_LABEL_AFTER_DEL,RX_QTY_BY_PRES_BASE_UOM_YN,DFLT_IP_FILL_INCR_START_WITH,IP_MAR_RULE_YN,OP_MAR_RULE_YN,DC_MAR_RULE_YN,EM_MAR_RULE_YN, DM_MAR_RULE_YN,atc_allergy_alert_level, TAB_BASED_GROUP_SORT_DISP, ALLOW_DUPLICATE_DRUG_OP,CAN_DISCON_DUP_ORDERS,DISP_EXPIRIED_ORDERS,MAR_AUTH_REQD_YN,ALLOW_MEDN_ORD_WITHOUT_DIAG_DD, PRINT_MAR_LABEL_YN, ALT_DRUG_REMARKS_IND, MAR_SCH_LEVEL_YN, MAR_START_IND, MAR_WEEK_DAY_START, MAR_PAST_DAY, MAR_FUTURE_DAY, MAR_DEFAULT_ORDER_BY , MAR_DISC_DOSE_YN, MAR_IV_COMPL_DT_IND, ALLERGY_CONF_REQD_YN, MAR_DISP_HELD_DISC_ORDERS_YN,DISP_BEFORE_START_DATE_IP_YN,DISP_BEFORE_NO_OF_DAYS_IP,DISP_BEYOND_EARLST_STRT_IP_YN,DISP_BEYOND_NO_OF_DAYS_IP, VERBAL_ORDER_WITNESS_YN,IV_DEFAULT_FREQUENCY, em_medctn_fwd_ip_yn, CARY_FRWD_ORD_NOFHRS, disp_rx_duration_YN, diag_for_medn_order_by, allow_mar_share_drug_yn,allow_renew_from_chart_summ_yn, can_discon_dup_orders_def_sel, ALLOW_AUTO_DISP_ALT_DRUG_MAR, PREVIEW_RX_YN, DISP_PREV_VITAL_SIGNS_YN,DEF_GENERIC_ID, OFFICE_HOURS_FROM, OFFICE_HOURS_TO,ALLOW_AMEND_ALTERNATE_DRUG_DT,SKIP_DUPLICATE_ALERT_OP_YN,SKIP_DUPLICATE_ALERT_IP_YN, OVERLAP_PERIOD_FOR_OP,OVERLAP_PERIOD_FOR_IP,RET_MEDIC_RESTR_STAGE,SPLIT_DRUG_BASED_AUTH_YN,INCLUDE_ZERO_ALOC_QTY_ITEMS_IP,ASSESMENT_REQ_YN,EARLY_OR_LATE_ADMIN_YN,ALLOW_ALT_FOR_MEDICAL_ITEM_YN,WARD_ACK_REQUIRED_YN,WARD_ACK_MAR_REQUIRED_YN,GENERIC_NAME_DISPLY_YN,RECONCILIATION_YN,REVW_APRROVE_APPLICABLE_FOR_IP,REVW_APRROVE_APPLICABLE_FOR_OP,APPROVAL_NO_APPL_IP,APPROVAL_NO_APPL_OP,OP_DISCH_MED_DISP_LOCN,PRE_ALLOC_APPL,NEAR_EXPIRY_APPL,DURN_VALUE,DURN_TYPE,DURN_VALUE_IN_DAYS,DFLT_DISP_LOCN,PAT_TRANSFER_PHAR_TYPE,PAT_TRANSFER_OTHER_TYPE,DRUG_INDICATION_MDRY,DISP_AUTO_REFRESH, DISP_VERI_REM_DRUG_INST,AMEND_ORD_WISE_DISP_MED,DISP_SENS_DIAG_PRE_REP_YN, DISP_SENS_DIAG_IND_PRE_REP_YN, MAR_DISP_UNBILLED_MED_YN,QUOTA_LIMIT_CALC_REQ_YN,ACITVE_PREP_APPL_QUOTA_YN,PRINT_FOOTER_DTLS_PRES_YN,PRINT_PRES_DTL_EN,PRINT_PRES_DTL_LOC,ALW_DISP_LOC_DRUG_SEARCH_YN) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(TO_CHAR(SYSDATE,'DD/MM/RRRR') || ?,'DD/MM/RRRR HH24:MI'), ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,SYSDATE, ?, ?, ?, SYSDATE, ?, ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, ?, ?,?,?,?,?,?,?, ?, ?, ?, ?, ?, ?,?,?, ?, ?, ?, TO_DATE( TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) || ?, 'DD/MM/YYYY HH24:MI' ),TO_DATE( TO_CHAR( SYSDATE, 'DD/MM/YYYY' ) || ?, 'DD/MM/YYYY HH24:MI' ),? ,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)"); // EARLY_OR_LATE_ADMIN_YN  Added for GHL-CRF-0482 [IN:064955] //Added for AAKH-CRF-0117 //PRE_ALLOC_APPL,NEAR_EXPIRY_APPL, DURN_VALUE, DURN_TYPE Added for MMS-DM-CRF-0177 //Modified for TFS-14326, Modified for TFS id:-16341 added DFLT_DISP_LOCN 
		//Added DEF_GENERIC_ID, OFFICE_HOURS_FROM, OFFICE_HOURS_TO for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016 Allow_Amend_Alternate_Drug_Dt Added by prathyusha for JD-CRF-198 on 05/05/2016 // RET_MEDIC_RESTR_STAGE added for GHL-CRF-0412.3//INCLUDE_ZERO_ALOC_QTY_ITEMS_IP added for ML-BRU-CRF-0473, ASSESMENT_REQ_YN Added for ML-MMOH-CRF-1126 //GENERIC_NAME_DISPLY_YN added for NMC-JD-CRF-0001
		//PAT_TRANSFER_PHAR_TYPE,PAT_TRANSFER_OTHER_TYPE added for ML-MMOH-CRF-1637
		// DISP_VERI_REM_DRUG_INST added for ML-MMOH-CRF-1755
       //DISP_SENS_DIAG_PRE_REP_YN  , DISP_SENS_DIAG_IND_PRE_REP_YN added for ML-BRU-CRF-0630
	   //MAR_DISP_UNBILLED_MED_YN added for NMC-JD-CRF-0186
	   //QUOTA_LIMIT_CALC_REQ_YN, ACITVE_PREP_APPL_QUOTA_YN added for ML-MMOH-CRF-1823
	   //,ALW_DISP_LOC_DRUG_SEARCH_YN added for NMC-JD-CRF-0197

	   		
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome(CommonRepository.getCommonKeyValue( "JNDI_SINGLE_TABLE_HANDLER" ),SingleTableHandlerHome.class,getLocalEJB());
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			Object argArray[] = new Object[2];
			argArray[0] = tabData;
			argArray[1] = sqlMap;

			Class [] paramArray = new Class[2];
			paramArray[0] = tabData.getClass(); ;
			paramArray[1] = sqlMap.getClass();

			map = (HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

			if( ((Boolean) map.get( "result" )).booleanValue() ){
				map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"PH"));
			}
			else{
				if( ((String)map.get( "msgid" )).equals( "CODE_ALREADY_EXISTS" ) )
					map.put( "message", getMessage(getLanguageId(),(String) map.get( "msgid" ),"Common"));
				else
				  map.put( "message", getMessage(getLanguageId(),(String) map.get("msgid"),"PH"));
			}
        }
        catch(Exception e){
			System.err.println( "Error In INSERT: map="+map+" tabData="+tabData ) ;
            map.put( "message", "exp :"+e.getMessage()) ;
			map.put("flag",debug);
            e.printStackTrace() ;
        }

		map.put("flag",debug);
        return map ;
    }//insert ends

	public String getRefillYNFromParam(){
		Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String strRefillYN="";
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT11")) ;
            resultSet = pstmt.executeQuery() ;
            if (resultSet != null && resultSet.next()){
				strRefillYN = resultSet.getString("REFILL_YN");
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
        return strRefillYN;
	}

	// We are getting the Dispense Stages (Legends) from PH_PARAM Table....
	public Hashtable getLegendsFromParam(String locale){
		Hashtable param_legends = new Hashtable();
		Connection connection = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet = null;
        try {
			connection = getConnection() ;
		    pstmt = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_DISP_MEDICATION_SELECT35") ) ;
            pstmt.setString(1,locale);
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

	public String  GetDiscMsrPanelDesc(String id) {
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        String dis_mes_panel_desc          = "";
        try {
            connection = getConnection() ;
            pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT2B")) ;
			pstmt.setString(1,id.trim());
			pstmt.setString(2,getLanguageId().trim());
            resultSet = pstmt.executeQuery() ;
            if (resultSet != null && resultSet.next()){
                dis_mes_panel_desc =resultSet.getString("SHORT_DESC");
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
            } catch(Exception es){
                es.printStackTrace();
            }
        }
        return dis_mes_panel_desc;
    }

    public String  GetNoteTypeDesc(String id) {
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        String dis_mes_panel_desc          = "";
        try {
            connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT2C")) ;

			pstmt.setString(1,id.trim());
			pstmt.setString(2,getLanguageId().trim());
            resultSet = pstmt.executeQuery() ;
            if (resultSet != null && resultSet.next()){
                dis_mes_panel_desc =resultSet.getString("NOTE_TYPE_DESC");
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
        return dis_mes_panel_desc;
    }

	public ArrayList  getLanguageIDs() { //Added for MMS-QH-CRF-0069 [IN:037977]
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
        ArrayList alLanguageList = new ArrayList();
        try {
            connection = getConnection() ;
			pstmt = connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_SELECT_LANGUAGES")) ;
            resultSet = pstmt.executeQuery() ;
            if (resultSet != null){
				while(resultSet.next()){
					alLanguageList.add(checkForNull(resultSet.getString("language_id")));
					alLanguageList.add(checkForNull(resultSet.getString("short_name")));
				}
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
        return alLanguageList;
    }

	public String  getMRParamAllergyConf() { //Added for MMS-QH-CRF-0069 [IN:037977]
        Connection connection   = null ;
        PreparedStatement pstmt = null ;
        ResultSet resultSet     = null ;
		String allergy_conf_reqd_yn = "N";
		try{
			connection = getConnection() ;
			pstmt	   = connection.prepareStatement( PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_GET_ALLERGY_CONF")) ;

			resultSet			= pstmt.executeQuery();
			if(resultSet!=null && resultSet.next())	{
				allergy_conf_reqd_yn = checkForNull(resultSet.getString("ALLERGY_CONF_REQD_YN"));
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
        return allergy_conf_reqd_yn;
    }
	public ArrayList getContinuousFreq() { //Added for Bru-HIMS-CRF-384[IN041642]
		Connection connection	= null;
        PreparedStatement pstmt	= null;
        ResultSet resultSet		= null;
		ArrayList frequency		= new ArrayList();

		try {
			connection	= getConnection();
			pstmt		= connection.prepareStatement(PhRepository.getPhKeyValue("SQL_PH_IVPRESCRIPTION_SELECT5A"));
			pstmt.setString(1, getLanguageId());
			resultSet	= pstmt.executeQuery();
			while (resultSet.next()) {
				frequency.add(resultSet.getString("FREQ_CODE"));
				frequency.add(resultSet.getString("FREQ_DESC"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeResultSet(resultSet);
				closeStatement(pstmt);
				closeConnection(connection);
			}
			catch(Exception es) {
				es.printStackTrace();
			}
		}
		return frequency;
	}
	public boolean isSite(HttpServletRequest request,String module_id,String description){ // Added for GHL-CRF-0412.3 - Start // isSiteForPreDischarge changed to isSite for ML-BRU-CRF-0473 linked Issue
		boolean site=false;
	    Connection con			= null;  
        try{
        	//con				= ConnectionManager.getConnection(request);	
			con	= getConnection();  //As it is bean, to take bean connection, request not  required as this is from jsp
        	site = eCommon.Common.CommonBean.isSiteSpecific(con, module_id.trim(),description.trim());	// hardcoded value changed to parameter values for ML-BRU-CRF-0473 linked Issue
		}
        catch(Exception ex){
            ex.printStackTrace();
        }
		finally{
			//if(con != null)
			//	ConnectionManager.returnConnection(con,request);
				try {
					closeConnection(con);
				}
				catch(Exception es) {
					es.printStackTrace();
				}
			
		}
		return site;
	} // Added for GHL-CRF-0412.3 - End
}