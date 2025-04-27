/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/****** Last Modified Date Time 9/22/2005 11:27 AM *****/
//Create table mpparamback as select * from mp_param. 

package eMP ; 

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import javax.naming.*;
import javax.rmi.*;
import java.sql.*;

import eCommon.SingleTabHandler.* ;
import webbeans.eCommon.*;
import com.ehis.eslp.*;

public class MpParamServlet extends HttpServlet
{
	String  patient_id_length       = "" ;
    String  patient_no_ctrl         = "" ;
    String  nat_id_length           = "" ;
    String  gen_pat_ser_grp         = "" ;
    String  nat_id_pat_ser_grp      = "" ;
    String  alt_id_pat_ser_grp      = "" ;
    String  dflt_pat_ser_grp_type         = "" ;
    String  name_dervn_logic              = "" ;
	String  name_dervn_logic_oth_lang  = "" ;
    String  family_no_link_yn           = "" ;
    String  family_no_link_yn_new           = "" ;
    String  single_or_multi_files_ind     = "" ;
    String  separate_file_no_yn           = "" ;
    String  citizen_nationality_code    = "" ;
	String  default_race_code			= "";
	String  default_relationship_code			= "";
    String  general_alert_yn            = "" ;
    String  suspend_service_yn      = "" ;
	String  dflt_alt_id1_in_emp_id_yn     = "";
    String  acpt_appt_rfrl_in_reg_pat_yn	= "";
    String  accept_pw_in_chng_pat_dtl_yn	= "";
    String  name_prefix_accept_yn			= "";
    String  name_prefix_reqd_yn				= "";
    String  name_prefix_reqd_yn_new				= "";
    String  name_prefix_prompt				= "";
	String  name_prefix_loc_lang_prompt     = "";
    String  first_name_accept_yn			= "";
    String  first_name_reqd_yn				= "";
    String  first_name_order				= "";
    String  first_name_prompt				= "";
	String  first_name_loc_lang_prompt      = "";
    String  second_name_accept_yn			= "";
    String  second_name_reqd_yn				= "";
    String  second_name_order				= "";
    String  second_name_prompt				= "";
	String  second_name_loc_lang_prompt     = "";
    String  third_name_accept_yn          = "" ;
    String  third_name_reqd_yn            = "" ;
    String  third_name_order              = "" ;
    String  third_name_prompt             = "" ;
	String  third_name_loc_lang_prompt		= "" ;
    String  family_name_accept_yn         = "" ;
    String  name_in_oth_lang_yn              ="" ;
    String  family_name_reqd_yn           = "" ;
    String  family_name_order             = "" ;
    String  family_name_prompt            = "" ;
	String  family_name_loc_lang_prompt   = "" ;
    String  name_suffix_accept_yn         = "" ;
    String  name_suffix_reqd_yn           = "" ;
    String  name_suffix_prompt            = "" ;
	String  name_suffix_loc_lang_prompt      = "" ;
    String  dflt_sndx_type                = "" ;
    String  alt_id1_type                  = "" ;
    String  alt_id1_length                = "" ;
    String  alt_id1_reqd_yn               = "" ;
    String  alt_id1_unique_yn             = "" ;
    String  alt_id1_is_unique             = "" ;
    String  alt_id1_exp_warn_yn           = "" ;
    String  alt_id1_exp_grace_days        = "" ;
    String  alt_id2_type                  = "" ;
    String  alt_id2_length                = "" ;
    String  alt_id2_reqd_yn               = "" ;
    String  alt_id2_unique_yn             = "" ;
    String  alt_id2_exp_warn_yn           = "" ;
    String  alt_id2_exp_grace_days        = "" ;
    String  alt_id3_type                  = "" ;
    String  alt_id3_length                = "" ;
    String  alt_id3_reqd_yn               = "" ;
    String  alt_id3_unique_yn             = "" ;
    String  alt_id3_exp_warn_yn           = "" ;
    String  alt_id3_exp_grace_days        = "" ;
    String  alt_id4_type                  = "" ;
    String  alt_id4_length                = "" ;
    String  alt_id4_reqd_yn               = "" ;
    String  alt_id4_unique_yn             = "" ;
    String  alt_id4_exp_warn_yn           = "" ;
    String  alt_id4_exp_grace_days        = "" ;
    String  id_card_title                 = "" ;
    String  line1_face_sheet_text         = "" ;
    String  line2_face_sheet_text         = "" ;
    String  line3_face_sheet_text         = "" ;
    String  line4_face_sheet_text         = "" ;
    String  line5_face_sheet_text         = "" ;
    String  line6_face_sheet_text         = "" ;
    String  line7_face_sheet_text         = "" ;
    String  line8_face_sheet_text         = "" ;
    String  line9_face_sheet_text         = "" ;
    String  line10_face_sheet_text        = "" ;
    String  alt_id1_len_validation_yn     = "" ;
    String  alt_id2_len_validation_yn     = "" ;
    String  alt_id3_len_validation_yn     = "" ;
    String  alt_id4_len_validation_yn     = "" ;
    String  alt_id1_exp_date_accept_yn    = "" ;
    String  alt_id2_exp_date_accept_yn    = "" ;
    String  alt_id3_exp_date_accept_yn    = "" ;
    String  alt_id4_exp_date_accept_yn    = "" ;

	String entitlement_by_pat_cat_yn = "";
	String family_org_id_accept_yn = "";
	String mapped_alt_id_org_member_id = "";
	String org_member_relationship_code = "";

    String emeg_pat_ser_grp     = "" ;
    String newborn_pat_ser_grp  = "" ;
    String allow_nb_regn_within_days ="";
    String mul_birth_regn_within_hours ="";
	String gen_slno_unknown_pat_yn = "N";
    String nb_mother_min_age ="";
	String nb_father_min_age ="";
	String name_suffix_male_nb ="";
    String name_suffix_female_nb ="";
    String unit_of_wt_nb ="";
    String unit_of_circum_nb="";
    String unit_of_length_nb ="";
    String unit_of_gest_nb ="";
    String sub_multi_birth_hw ="";
	String unit_of_chest_circum_nb = "";
    String review_nb_links_bef_reg_yn="";
	//Added by kamatchi s for ML-MMOH-CRF-2095
    String length_of_baby_yn="";
    String head_circumference_of_baby_yn="";
	String allow_ext_nb_regn_within_days = "";
	//Added by kamatchi s for ML-MMOH-CRF-1757
	String mandate_first_newborn_yn = "";
	String mandate_first_newborn_ip_yn = "";
	String mandate_first_newborn_ae_yn = "";
	String mandate_second_newborn_yn = "";
	String mandate_second_newborn_ip_yn = "";
	String mandate_second_newborn_ae_yn = "";
	String mandate_third_newborn_yn = "";
	String mandate_third_newborn_ip_yn = "";
	String mandate_third_newborn_ae_yn = "";
	String mand_antenatal_newborn_yn = "";
	String mand_antenatal_newborn_ip_yn = "";
	String mand_antenatal_newborn_ae_yn = "";
	//Added by Kamatchi S for ML-MMOH-CRF-2097
	String enable_marital_status    = "";
    String dflt_father_first_name_prompt    = "";
    String dflt_father_Second_name_prompt    = "";
    String dflt_father_third_name_prompt    = "";
    String dflt_father_family_name_prompt    = "";

    String single_stage_nb_reg_appl_yn="";
    String mod_birth_reg_appl_yn="";
   // String invoke_chg_pat_dtls_fm_nb_yn="";
    String alt_id1_routine_yn ="";
    String alt_id1_routine ="";
    String alt_id2_routine_yn ="";
    String alt_id2_routine ="";
    String alt_id3_routine_yn ="";
    String alt_id3_routine ="";
    String alt_id4_routine_yn ="";
    String alt_id4_routine ="";
   
    String dflt_patient_name = "";
	String dft_national_id="";
	String create_file_at_pat_regn_yn="" ;
    String create_file_at_admission="" ;
	String create_file_at_reg_visit_yn="";
	String create_file_at_reg_att_yn="";
	String create_file_at_dc_admission_yn = "";
	String file_type_appl_yn = "N";
    String nat_id_prompt = "";
	
	//Added By Gaurav Aginst MMS-MEA-CRF-0004
    String start_id_with = ""; 
	String alt_id1_start_with = "";
	String alt_id2_start_with = "";
	String alt_id3_start_with = "";
	String alt_id4_start_with = "";
    //Added By Gaurav Aginst MMS-MEA-CRF-0004
	String nat_id_reqd_all_series ="" ;
    String nat_data_source_id = "" ;
    String alt_id1_chk_digit_scheme ="";
    String alt_id2_chk_digit_scheme ="";
    String alt_id3_chk_digit_scheme ="";
    String alt_id4_chk_digit_scheme ="";
    String name_prefix_male_nb   ="";
    String name_prefix_female_nb ="";
    String name_prefix_unknown_nb =""; //Added by Afruddin for ML-MMOH-CRF-1520 US001 on 4.05.2020
    String nb_father_name_mandatory_yn ="";
    String data_upd_allowed_aft_final_yn ="";
    String accept_names_for_live_birth_yn ="";
    String dflt_race_nat_setup_nb_as_per ="";
    String nb_mother_dtls_update_yn="";//Added for HSA-CRF-0182
	
	/* Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/
	String alt_id1_pat_sch_exact_yn="";
	String alt_id2_pat_sch_exact_yn="";
	String alt_id3_pat_sch_exact_yn="";
	String alt_id4_pat_sch_exact_yn="";

    String nb_use_mother_ser = "";
    String accept_national_id_no_yn = "";
	String alt_id1_accept_oth_pat_ser_yn = "";
	String alt_id1_accept_alphanumeric_yn  = "";
	String max_pat_age = "";
	String no_days_UHID_valid = ""; //  Added by mujafar for AMRI-CRF-0357
	Boolean isUHID_valid_appl = false; //  Added by mujafar for AMRI-CRF-0357
	String id_change_allowed_for_series     = "";
    String alt_id1_adv_alert_reqd_yn        = "";
    String alt_id1_adv_alert_days           = "";
    String alt_id2_adv_alert_reqd_yn        = "";
    String alt_id2_adv_alert_days           = "";
    String alt_id3_adv_alert_reqd_yn        = "";
    String alt_id3_adv_alert_days           = "";
    String alt_id4_adv_alert_reqd_yn        = "";
    String alt_id4_adv_alert_days           = "";
    String terminal_digit_reqd_yn           = "N";
    String addl_field1_prompt               = "";
    String addl_field1_length               = "";
    String addl_field1_section              = "";
    String addl_field2_prompt               = "";
    String addl_field2_length               = "";
    String addl_field2_section              = "";
    String addl_field3_prompt               = "";
    String addl_field3_length               = "";
    String addl_field3_section              = "";
    String addl_field4_prompt               = "";
    String addl_field4_length               = "";
    String addl_field4_section              = "";
    String addl_field5_prompt               = "";
    String addl_field5_length               = "";
    String addl_field5_section              = "";
   	String Accept_oth_alt_id_yn              = "";
	String gestation_two_del              = "";
	String nb_mother_cutoff_age              = "";
	String nb_mother_upper_age              = "";
	String nb_male_relnship              = "";
	String nb_female_relnship              = "";
	String nb_unknown_relnship              = "";
	String allow_nb_regn_unit              = "";
	String min_weight = "";
	String max_weight = "";
	String min_length = "";
	String max_length = "";
	String min_head_circum = "";
	String max_head_circum = "";
	String min_chest_circum = "";
	String max_chest_circum = "";
	String min_gestation = "";
	String max_gestation = "";
	String family_name_prefix_yn = "N";
	String prompt_pat_fin_class_yn = "N";
    String  ws_no             = "" ;
    String  facility_id       = "" ;
    String uid                  = "";
	String pat_name_as_multipart_yn = "";
	String ext_system_interface_yn="";
    java.util.Properties p=null;
    String operation                    ;
    String nat_id_check_digit_id;
    String invoke_routine        ;
    
    // <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 U1 Starts-->
    String biometric_authentication="";
    // <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 U1 ends-->
    
    String nat_id_chk_len         ;
    String maintain_doc_or_file = "";
    String alt_id1_hist_yn = "";
    String alt_id2_hist_yn = "";
    String alt_id3_hist_yn = "";
    String alt_id4_hist_yn = "";
    String nationality_hist_yn = "";

	String name_prefix_length = "";
	String first_name_length = "";
	String second_name_length = "";
	String third_name_length = "";
	String family_name_length = "";
	String name_suffix_length = "";
	String alt_id1_chng_allowed_yn = "";
	String dflt_language_id = "";
	String dflt_relgn_code = "";
	String inv_pat_search_in_reg_pat_yn = "";
	String family_org_id_accept_yn_new = "";
	//String alt_id1_rule_in_gen_pat_id_yn = "";
	String name_pfx_reqd_for_org_mem_yn = "";
	// on 2/26/2008
	String gen_patid_using_altid_rl_yn = "";
	String display_new_born_age_in_hrs="";
	//aDDED oN 3/5/2008
//	String relationship_level_length = "";
	String age_not_consider_natid = "";//Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
	String age_not_consider_natid_altid = "";//Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]
	String nat_id_accept_alphanumeric_yn = "";
	String create_file_yn = "";
	String race_required_yn = "";
	String round_dob_estd_age = "";
    String single_patient_numbering_yn="";
    InputStreamReader reader;
    HttpSession session = null;
    Connection  con = null;
	String d_alt_id1_exp_warn_yn="", d_alt_id2_exp_warn_yn="", d_alt_id3_exp_warn_yn="", d_alt_id4_exp_warn_yn="";
	String still_born_prefix="";
	// New parameter is added for RUT-CRF-0007-MPI (IN023391) on 16.09.2010 by Suresh M
	String pat_photo_renewal_alert_days="";

	String long_name_dervn_logic="";
	String long_name_dervn_logic_local="";
	//Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
	String mortuary_release_yn ="N";
	String no_days_before_deceased="";
	String cancel_reason_code="";
	//End
	String pat_search_tab="";
	// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar 
	String country_reqd_yn = "";
	String region_reqd_yn = "";
	String mobile_no_reqd_yn = "";
	// New parameter  is added against KDAH-CRF-0273 [IN:045012] by Saanthaakumar 
	String email_id_reqd_yn = "";
	// New parameter  is added against KAMRI-CRF-0388 by SHAGAR
	String postal_cd_reqd_yn = "";
	String area_reqd_yn = "";
	String patientcategory_reqd_yn = ""; // Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
	String town_reqd_yn = ""; // Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
	String religion_reqd_yn = ""; //New parameter is added against ML-MMOH-CRF-0736 by Mano
	String pat_ser_access_by_user_yn = "";//added for MO-CRF-20074
	String upt_contact_dtls_oa_yn = "";//added changes for HSA-CRF-0226 [IN:050599]

	String upd_pat_dtls_referral_yn = "N";//Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 8th 2016
    String disp_cancelled_previous_enc_yn="Y"; 
	
	/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
	String alt_id2_accept_oth_pat_ser_yn		= "";
	String alt_id2_chng_allowed_yn				= "";
	String alt_id2_accept_alphanumeric_yn		= "";
	String alt_id3_accept_oth_pat_ser_yn		= "";
	String alt_id3_chng_allowed_yn				= "";
	String alt_id3_accept_alphanumeric_yn		= "";
	String alt_id4_accept_oth_pat_ser_yn		= "";
	String alt_id4_chng_allowed_yn				= "";
	String alt_id4_accept_alphanumeric_yn		= "";
	/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

	/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 Start */
	String alt_id1_alphanum_validate_yn			= "N";
	String alt_id2_alphanum_validate_yn			= "N";
	String alt_id3_alphanum_validate_yn			= "N";
	String alt_id4_alphanum_validate_yn			= "N";
	/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 End */
    //Added by prithivi on 10/05/2017 for kdah-crf-0362
	String aadhar_config_enabled_yn = "";
	String aadhar_option_value = "";

	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
	String name_dervn_logic_nb = "";
	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
	String name_dervn_logic_nb_sb = "";
	//Added by Ajay Hatwate for AAKH-CRF-0179 on 23-08-2023
	String death_reg_form_req_yn = "N";
	
	//Added by Rajkumar for GHL-CRF-0686
	String unmask_aadhaar_num_yn = "N";
	String unmask_abha_num_addr_yn = "N";
	
	String occupation_reqd_yn      = "N";//Added for NMC-JD-CRF-0236
    String marital_status_reqd_yn = "N";//Added for NMC-JD-CRF-0236
    String mand_visit_admssn_reg_yn = "N";//Added for NMC-JD-CRF-0236
	
	//Added by Santhosh for GHL-CRF-0686.3
	String abha_eng_audio_path	= "";
	String abha_hin_audio_path	= "";
	//End
		// Added By Jeyachitra against ML-MMOH-CRF-1759.1-US001
	String mand_parity_newborn_yn = "";
	String mand_parity_newborn_ip_yn = "";
	String mand_parity_newborn_ae_yn = "";
	String invoke_menstrual_history_yn="";
	// ML-MMOH-CRF-1759.1-US001 ends
	

	 
    public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {

       try
	   {
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");

		con = ConnectionManager.getConnection(req);
		session         = req.getSession(false) ;
		
		patient_id_length       = req.getParameter( "patient_id_length"     ) == null ? "" : req.getParameter( "patient_id_length"          ) ;
        patient_no_ctrl         = req.getParameter( "patient_no_ctrl"           ) == null ? "" : req.getParameter( "patient_no_ctrl"                ) ;
        nat_id_length           = req.getParameter( "nat_id_length"             ) == null ? "0" : req.getParameter( "nat_id_length") ;
        gen_pat_ser_grp         = req.getParameter( "gen_pat_ser_grp"           ) == null ? "0" : req.getParameter( "gen_pat_ser_grp"                ) ;
        nat_id_pat_ser_grp      = req.getParameter( "nat_id_pat_ser_grp"            ) == null ? "" : req.getParameter( "nat_id_pat_ser_grp"         ) ;
        alt_id_pat_ser_grp      = req.getParameter( "alt_id_pat_ser_grp"            ) == null ? "" : req.getParameter( "alt_id_pat_ser_grp"         ) ;
        dflt_pat_ser_grp_type         = req.getParameter( "dflt_pat_ser_grp_type"       ) == null ? "" : req.getParameter( "dflt_pat_ser_grp_type"          ) ;
        name_dervn_logic              = req.getParameter( "name_dervn_logic"            ) == null ? "" : req.getParameter( "name_dervn_logic"               ) ;
		long_name_dervn_logic              = req.getParameter( "long_name_dervn_logic"            ) == null ? "" : req.getParameter( "long_name_dervn_logic"               ) ;
		pat_search_tab = req.getParameter( "pat_search_tab")   == null ? "B" : req.getParameter( "pat_search_tab") ;
		create_file_at_pat_regn_yn  =  req.getParameter( "create_file_at_pat_regn_yn")   == null ? "N" : req.getParameter( "create_file_at_pat_regn_yn") ;
		create_file_at_admission  =  req.getParameter( "create_file_at_admission")   == null ? "N" : req.getParameter( "create_file_at_admission") ;
		create_file_at_reg_visit_yn  =  req.getParameter( "create_file_at_reg_visit_yn")   == null ? "N" : req.getParameter( "create_file_at_reg_visit_yn") ;
		create_file_at_reg_att_yn =	req.getParameter( "create_file_at_reg_att_yn")   == null ? "N" : req.getParameter( "create_file_at_reg_att_yn") ;
	
		name_pfx_reqd_for_org_mem_yn =	req.getParameter( "name_pfx_reqd_for_org_mem_yn")   == null ? "N" : req.getParameter( "name_pfx_reqd_for_org_mem_yn") ;
		
		create_file_at_dc_admission_yn =	req.getParameter( "create_file_at_dc_admission_yn")   == null ? "N" : req.getParameter( "create_file_at_dc_admission_yn") ;
        family_no_link_yn           = req.getParameter( "family_no_link_yn"         ) == null ? "N" : req.getParameter( "family_no_link_yn"         ) ;
        family_no_link_yn_new           = req.getParameter( "family_no_link_yn_new") == null ? "N" : req.getParameter( "family_no_link_yn_new") ;
        single_or_multi_files_ind     = req.getParameter("single_or_multi_files_ind") == null ? "S" : req.getParameter("single_or_multi_files_ind") ;
		
        family_org_id_accept_yn_new     = req.getParameter( "family_org_id_accept_yn_new"       ) == null ? "S" : req.getParameter( "family_org_id_accept_yn_new") ;
     	 single_patient_numbering_yn=req.getParameter( "single_patient_numbering_yn") == null ? "N" : req.getParameter( "single_patient_numbering_yn") ;
		display_new_born_age_in_hrs=req.getParameter( "display_new_born_age_in_hrs") == null ? "" : req.getParameter( "display_new_born_age_in_hrs") ;
		family_no_link_yn=family_no_link_yn_new;
		age_not_consider_natid = req.getParameter( "age_not_consider_natid") == null ? "" : req.getParameter( "age_not_consider_natid") ; //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
		age_not_consider_natid_altid = req.getParameter( "age_not_consider_natid_altid") == null ? "" : req.getParameter( "age_not_consider_natid_altid") ;//Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]
		
        separate_file_no_yn           = req.getParameter("separate_file_no_yn") == null ? "N" : req.getParameter( "separate_file_no_yn" ) ;
		if((single_or_multi_files_ind.equals("M")) && (separate_file_no_yn.equals("N")))
			file_type_appl_yn="Y";
		else
			file_type_appl_yn="N";

		maintain_doc_or_file = req.getParameter("maintain_doc_or_file")==null?"F": req.getParameter("maintain_doc_or_file");
		alt_id1_hist_yn = req.getParameter("alt_id1_hist_yn")==null?"N": req.getParameter("alt_id1_hist_yn");
		alt_id2_hist_yn = req.getParameter("alt_id2_hist_yn")==null?"N": req.getParameter("alt_id2_hist_yn");
		alt_id3_hist_yn = req.getParameter("alt_id3_hist_yn")==null?"N": req.getParameter("alt_id3_hist_yn");
		alt_id4_hist_yn = req.getParameter("alt_id4_hist_yn")==null?"N": req.getParameter("alt_id4_hist_yn");
		nationality_hist_yn = req.getParameter("nationality_hist_yn")==null?"N": req.getParameter("nationality_hist_yn");

        citizen_nationality_code    = req.getParameter( "citizen_nationality_code"      ) == null ? "" : req.getParameter( "citizen_nationality_code"       ) ;
		default_race_code    = req.getParameter( "default_race_code"      ) == null ? "" : req.getParameter( "default_race_code"       ) ;
		
		default_relationship_code    = req.getParameter( "default_relationship"      ) == null ? "" : req.getParameter( "default_relationship"       ) ;
        general_alert_yn            = req.getParameter( "general_alert_yn"          ) == null ? "N" : req.getParameter( "general_alert_yn"          ) ;
        suspend_service_yn      = req.getParameter( "suspend_service_yn"            ) == null ? "N" : req.getParameter( "suspend_service_yn"            ) ;

		dflt_alt_id1_in_emp_id_yn=req.getParameter("dflt_alt_id1_in_emp_id_yn") == null ? "N" : req.getParameter("dflt_alt_id1_in_emp_id_yn") ;
		acpt_appt_rfrl_in_reg_pat_yn=req.getParameter("acpt_appt_rfrl_in_reg_pat_yn") == null ? "N" : req.getParameter("acpt_appt_rfrl_in_reg_pat_yn"            ) ;

		name_prefix_accept_yn         = req.getParameter( "name_prefix_accept_yn"           ) == null ? "N" : req.getParameter( "name_prefix_accept_yn"             ) ;
        name_prefix_reqd_yn           = req.getParameter( "name_prefix_reqd_yn"             ) == null ? "N" : req.getParameter( "name_prefix_reqd_yn"               ) ;
        name_prefix_reqd_yn_new           = req.getParameter( "name_prefix_reqd_yn_new") == null ? "N" : req.getParameter( "name_prefix_reqd_yn_new") ;
		
		name_prefix_reqd_yn=name_prefix_reqd_yn_new;
		
        name_prefix_prompt            = req.getParameter( "name_prefix_prompt"              ) == null ? "" : req.getParameter( "name_prefix_prompt"             ) ;
		name_prefix_loc_lang_prompt            = req.getParameter( "name_prefix_loc_lang_prompt"              ) == null ? "" : req.getParameter( "name_prefix_loc_lang_prompt"             ) ;

	/*	reader = new InputStreamReader( new ByteArrayInputStream( name_prefix_loc_lang_prompt.getBytes()), "windows-1256" ) ;
		name_prefix_loc_lang_prompt = (new BufferedReader(reader)).readLine() ;*/
		if (name_prefix_loc_lang_prompt==null) name_prefix_loc_lang_prompt = "";
        first_name_accept_yn          = req.getParameter( "first_name_accept_yn"            ) == null ? "N" : req.getParameter( "first_name_accept_yn"              ) ;
        first_name_reqd_yn            = req.getParameter( "first_name_reqd_yn"              ) == null ? "N" : req.getParameter( "first_name_reqd_yn"                ) ;
        first_name_order              = req.getParameter( "first_name_order"                ) == null ? "" : req.getParameter( "first_name_order"               ) ;
        first_name_prompt             = req.getParameter( "first_name_prompt"               ) == null ? "" : req.getParameter( "first_name_prompt"              ) ;
		first_name_loc_lang_prompt             = req.getParameter( "first_name_loc_lang_prompt"               ) == null ? "" : req.getParameter( "first_name_loc_lang_prompt"              ) ;

			if (first_name_loc_lang_prompt==null) first_name_loc_lang_prompt = "";
        second_name_accept_yn         = req.getParameter( "second_name_accept_yn"           ) == null ? "N" : req.getParameter( "second_name_accept_yn"             ) ;
        second_name_reqd_yn           = req.getParameter( "second_name_reqd_yn"             ) == null ? "N" : req.getParameter( "second_name_reqd_yn"               ) ;
        second_name_order             = req.getParameter( "second_name_order"               ) == null ? "" : req.getParameter( "second_name_order"              ) ;
        second_name_prompt            = req.getParameter( "second_name_prompt"              ) == null ? "" : req.getParameter( "second_name_prompt"             ) ;
		second_name_loc_lang_prompt             = req.getParameter( "second_name_loc_lang_prompt"               ) == null ? "" : req.getParameter( "second_name_loc_lang_prompt"              ) ;

		if (second_name_loc_lang_prompt==null) second_name_loc_lang_prompt = "";
        third_name_accept_yn          = req.getParameter( "third_name_accept_yn"            ) == null ? "N" : req.getParameter( "third_name_accept_yn"              ) ;
        third_name_reqd_yn            = req.getParameter( "third_name_reqd_yn"              ) == null ? "N" : req.getParameter( "third_name_reqd_yn"                ) ;
        third_name_order              = req.getParameter( "third_name_order"                ) == null ? "" : req.getParameter( "third_name_order"               ) ;
        third_name_prompt             = req.getParameter( "third_name_prompt"               ) == null ? "" : req.getParameter( "third_name_prompt"              ) ;
		third_name_loc_lang_prompt             = req.getParameter( "third_name_loc_lang_prompt"               ) == null ? "" : req.getParameter( "third_name_loc_lang_prompt"              ) ;

		if (third_name_loc_lang_prompt==null) third_name_loc_lang_prompt = "";
        family_name_accept_yn         = req.getParameter( "family_name_accept_yn"           ) == null ? "N" : req.getParameter( "family_name_accept_yn"             ) ;
        family_name_reqd_yn           = req.getParameter( "family_name_reqd_yn"             ) == null ? "N" : req.getParameter( "family_name_reqd_yn"               ) ;
        family_name_order             = req.getParameter( "family_name_order"               ) == null ? "" : req.getParameter( "family_name_order"              ) ;
        family_name_prompt            = req.getParameter( "family_name_prompt"              ) == null ? "" : req.getParameter( "family_name_prompt"             ) ;
		family_name_loc_lang_prompt             = req.getParameter( "family_name_loc_lang_prompt"               ) == null ? "" : req.getParameter( "family_name_loc_lang_prompt"              ) ;

		if (family_name_loc_lang_prompt==null) family_name_loc_lang_prompt = "";
        name_suffix_accept_yn         = req.getParameter( "name_suffix_accept_yn"           ) == null ? "N" : req.getParameter( "name_suffix_accept_yn"             ) ;
        name_suffix_reqd_yn           = req.getParameter( "name_suffix_reqd_yn"             ) == null ? "N" : req.getParameter( "name_suffix_reqd_yn"               ) ;
        name_suffix_prompt            = req.getParameter( "name_suffix_prompt"              ) == null ? "" : req.getParameter( "name_suffix_prompt"             ) ;
		name_suffix_loc_lang_prompt   = req.getParameter( "name_suffix_loc_lang_prompt"              ) == null ? "" : req.getParameter( "name_suffix_loc_lang_prompt"   ) ;


		if (name_suffix_loc_lang_prompt==null) name_suffix_loc_lang_prompt = "";
        dflt_sndx_type                = req.getParameter( "dflt_sndx_type" )  == null ? "" : req.getParameter( "dflt_sndx_type")  ;
        alt_id1_type                  = req.getParameter( "alt_id1_type"   )  == null ? "" : req.getParameter( "alt_id1_type"  )  ;
        alt_id1_length                = req.getParameter( "alt_id1_length" )  == null ? "0" : req.getParameter( "alt_id1_length")  ;
        alt_id1_reqd_yn               = req.getParameter( "alt_id1_reqd_yn")  == null ? "N" : req.getParameter( "alt_id1_reqd_yn"  )  ;
        alt_id1_unique_yn             = req.getParameter( "alt_id1_unique_yn"               ) == null ? "N" : req.getParameter( "alt_id1_unique_yn")  ;
        alt_id1_is_unique             = req.getParameter( "alt_id1_is_unique") == null ? "N" : req.getParameter( "alt_id1_is_unique");
        alt_id1_exp_warn_yn           = req.getParameter( "alt_id1_exp_warn_yn"             ) == null ? "N" : req.getParameter( "alt_id1_exp_warn_yn"               ) ;
        alt_id1_exp_grace_days        = req.getParameter( "alt_id1_exp_grace_days"          ) == null ? "0" : req.getParameter( "alt_id1_exp_grace_days"         ) ;
        alt_id2_type                  = req.getParameter( "alt_id2_type"   )  == null ? "" : req.getParameter( "alt_id2_type"  )  ;
        alt_id2_length                = req.getParameter( "alt_id2_length" )  == null ? "0" : req.getParameter( "alt_id2_length")  ;
        alt_id2_reqd_yn               = req.getParameter( "alt_id2_reqd_yn")  == null ? "N" : req.getParameter( "alt_id2_reqd_yn"  )  ;
        alt_id2_unique_yn             = req.getParameter( "alt_id2_unique_yn"               ) == null ? "N" : req.getParameter( "alt_id2_unique_yn")  ;
        alt_id2_exp_warn_yn           = req.getParameter( "alt_id2_exp_warn_yn"             ) == null ? "N" : req.getParameter( "alt_id2_exp_warn_yn"               ) ;
        alt_id2_exp_grace_days        = req.getParameter( "alt_id2_exp_grace_days"          ) == null ? "0" : req.getParameter( "alt_id2_exp_grace_days"         ) ;
        alt_id3_type                  = req.getParameter( "alt_id3_type"   )  == null ? "" : req.getParameter( "alt_id3_type"  )  ;
        alt_id3_length                = req.getParameter( "alt_id3_length" )  == null ? "0" : req.getParameter( "alt_id3_length")  ;
        alt_id3_reqd_yn               = req.getParameter( "alt_id3_reqd_yn")  == null ? "N" : req.getParameter( "alt_id3_reqd_yn"  )  ;
        alt_id3_unique_yn             = req.getParameter( "alt_id3_unique_yn"               ) == null ? "N" : req.getParameter( "alt_id3_unique_yn")  ;
        alt_id3_exp_warn_yn           = req.getParameter( "alt_id3_exp_warn_yn"             ) == null ? "N" : req.getParameter( "alt_id3_exp_warn_yn"               ) ;
        alt_id3_exp_grace_days        = req.getParameter( "alt_id3_exp_grace_days"          ) == null ? "0" : req.getParameter( "alt_id3_exp_grace_days"         ) ;
        alt_id4_type                  = req.getParameter( "alt_id4_type"   )  == null ? "" : req.getParameter( "alt_id4_type"  )  ;
        alt_id4_length                = req.getParameter( "alt_id4_length" )  == null ? "" : req.getParameter( "alt_id4_length")  ;
        alt_id4_reqd_yn               = req.getParameter( "alt_id4_reqd_yn")  == null ? "N" : req.getParameter( "alt_id4_reqd_yn"  )  ;
        alt_id4_unique_yn             = req.getParameter( "alt_id4_unique_yn"               ) == null ? "N" : req.getParameter( "alt_id4_unique_yn")  ;
        alt_id4_exp_warn_yn           = req.getParameter( "alt_id4_exp_warn_yn"             ) == null ? "N" : req.getParameter( "alt_id4_exp_warn_yn"               ) ;
        alt_id4_exp_grace_days        = req.getParameter( "alt_id4_exp_grace_days"          ) == null ? "" : req.getParameter( "alt_id4_exp_grace_days"         ) ;
        name_in_oth_lang_yn         =  req.getParameter( "name_in_oth_lang_yn"          ) == null ? "N" : req.getParameter( "name_in_oth_lang_yn"           ) ;
	    alt_id1_len_validation_yn     = req.getParameter( "alt_id1_len_validation_yn"       ) == null ? "N": req.getParameter( "alt_id1_len_validation_yn"      ) ;
        alt_id2_len_validation_yn     = req.getParameter( "alt_id2_len_validation_yn"       ) == null ? "N": req.getParameter( "alt_id2_len_validation_yn"      ) ;
        alt_id3_len_validation_yn     = req.getParameter( "alt_id3_len_validation_yn"       ) == null ? "N": req.getParameter( "alt_id3_len_validation_yn"      ) ;
        alt_id4_len_validation_yn     = req.getParameter( "alt_id4_len_validation_yn"       ) == null ? "N": req.getParameter( "alt_id4_len_validation_yn"      ) ;
        alt_id1_exp_date_accept_yn    = req.getParameter( "alt_id1_exp_date_accept_yn"      ) == null ? "N": req.getParameter( "alt_id1_exp_date_accept_yn"     ) ;
        alt_id2_exp_date_accept_yn    = req.getParameter( "alt_id2_exp_date_accept_yn"      ) == null ? "N": req.getParameter( "alt_id2_exp_date_accept_yn"     ) ;
        if(alt_id2_exp_date_accept_yn.equals(""))   alt_id2_exp_date_accept_yn = "N";
        alt_id3_exp_date_accept_yn    = req.getParameter( "alt_id3_exp_date_accept_yn"      ) == null ? "N": req.getParameter( "alt_id3_exp_date_accept_yn"     ) ;
        alt_id4_exp_date_accept_yn    = req.getParameter( "alt_id4_exp_date_accept_yn"      ) == null ? "N": req.getParameter( "alt_id4_exp_date_accept_yn"     ) ;
        emeg_pat_ser_grp                    =  req.getParameter( "emeg_pat_ser_grp") == null ? "": req.getParameter( "emeg_pat_ser_grp"     ) ;
        newborn_pat_ser_grp             =  req.getParameter( "newborn_pat_ser_grp") == null ? "": req.getParameter( "newborn_pat_ser_grp"       ) ;
        allow_nb_regn_within_days   =  req.getParameter( "allow_nb_regn_within_days") == null ? "": req.getParameter( "allow_nb_regn_within_days"       ) ;
         mul_birth_regn_within_hours   =  req.getParameter( "mul_birth_regn_within_hours") == null ? "": req.getParameter( "mul_birth_regn_within_hours") ;
		nb_father_min_age   =  req.getParameter( "min_age_of_fath") == null ? "": req.getParameter( "min_age_of_fath"       ) ;
        name_suffix_male_nb             =  req.getParameter( "name_suffix_male_nb") == null ? "": req.getParameter( "name_suffix_male_nb"       ) ;
        name_suffix_female_nb           =  req.getParameter( "name_suffix_female_nb") == null ? "": req.getParameter( "name_suffix_female_nb"       ) ;
        unit_of_wt_nb                       =  req.getParameter( "h_unit_of_wt_nb") == null ? "": req.getParameter( "h_unit_of_wt_nb" ) ;
		unit_of_circum_nb                   =  req.getParameter( "h_unit_of_circum_nb") == null ? "": req.getParameter( "h_unit_of_circum_nb"       ) ;
        unit_of_length_nb                   =  req.getParameter( "h_unit_of_length_nb") == null ? "": req.getParameter( "h_unit_of_length_nb"       ) ;
		unit_of_chest_circum_nb                   =  req.getParameter( "h_unit_of_chest_circum_nb") == null ? "": req.getParameter( "h_unit_of_chest_circum_nb"       ) ;
        unit_of_gest_nb                     =  req.getParameter( "h_unit_of_gest_nb") == null ? "": req.getParameter( "h_unit_of_gest_nb"       ) ;
        sub_multi_birth_hw                     =  req.getParameter( "sub_multi_birth_hw") == null ? "": req.getParameter( "sub_multi_birth_hw"       ) ;
        review_nb_links_bef_reg_yn  =  req.getParameter( "review_nb_links_bef_reg_yn") ==null ?"N":req.getParameter( "review_nb_links_bef_reg_yn");
		//Added by kamatchi s for ML-MMOH-CRF-2095
        length_of_baby_yn  =  req.getParameter( "length_of_baby_yn") ==null ?"N":req.getParameter( "length_of_baby_yn");
        head_circumference_of_baby_yn  =  req.getParameter( "head_circumference_of_baby_yn") ==null ?"N":req.getParameter( "head_circumference_of_baby_yn");
		allow_ext_nb_regn_within_days  =  req.getParameter( "allow_ext_nb_regn_within_days") ==null ?"":req.getParameter( "allow_ext_nb_regn_within_days");
		//Added by kamatchi s for ML-MMOH-CRF-1757
        mandate_first_newborn_yn  =  req.getParameter( "mandate_first_newborn_yn") ==null ?"N":req.getParameter( "mandate_first_newborn_yn");
        mandate_first_newborn_ip_yn  =  req.getParameter( "mandate_first_newborn_ip_yn") ==null ?"N":req.getParameter( "mandate_first_newborn_ip_yn");
        mandate_first_newborn_ae_yn  =  req.getParameter( "mandate_first_newborn_ae_yn") ==null ?"N":req.getParameter( "mandate_first_newborn_ae_yn");
        mandate_second_newborn_yn  =  req.getParameter( "mandate_second_newborn_yn") ==null ?"N":req.getParameter( "mandate_second_newborn_yn");
        mandate_second_newborn_ip_yn  =  req.getParameter( "mandate_second_newborn_ip_yn") ==null ?"N":req.getParameter( "mandate_second_newborn_ip_yn");
        mandate_second_newborn_ae_yn  =  req.getParameter( "mandate_second_newborn_ae_yn") ==null ?"N":req.getParameter( "mandate_second_newborn_ae_yn");
        mandate_third_newborn_yn  =  req.getParameter( "mandate_third_newborn_yn") ==null ?"N":req.getParameter( "mandate_third_newborn_yn");
        mandate_third_newborn_ip_yn  =  req.getParameter( "mandate_third_newborn_ip_yn") ==null ?"N":req.getParameter( "mandate_third_newborn_ip_yn");
        mandate_third_newborn_ae_yn  =  req.getParameter( "mandate_third_newborn_ae_yn") ==null ?"N":req.getParameter( "mandate_third_newborn_ae_yn");
        mand_antenatal_newborn_yn  =  req.getParameter( "mand_antenatal_newborn_yn") ==null ?"N":req.getParameter( "mand_antenatal_newborn_yn");
        mand_antenatal_newborn_ip_yn  =  req.getParameter( "mand_antenatal_newborn_ip_yn") ==null ?"N":req.getParameter( "mand_antenatal_newborn_ip_yn");
        mand_antenatal_newborn_ae_yn  =  req.getParameter( "mand_antenatal_newborn_ae_yn") ==null ?"N":req.getParameter( "mand_antenatal_newborn_ae_yn");
		//added by kamatchi s for ML-MMOH-CRF-2097
        enable_marital_status  =  req.getParameter( "enable_marital_status") ==null ?"N":req.getParameter( "enable_marital_status");
        dflt_father_first_name_prompt  =  req.getParameter( "dflt_father_first_name_prompt") ==null ?"":req.getParameter( "dflt_father_first_name_prompt");
        dflt_father_Second_name_prompt  =  req.getParameter( "dflt_father_Second_name_prompt") ==null ?"":req.getParameter( "dflt_father_Second_name_prompt");
        dflt_father_third_name_prompt  =  req.getParameter( "dflt_father_third_name_prompt") ==null ?"":req.getParameter( "dflt_father_third_name_prompt");
        dflt_father_family_name_prompt  =  req.getParameter( "dflt_father_family_name_prompt") ==null ?"":req.getParameter( "dflt_father_family_name_prompt");
		
        single_stage_nb_reg_appl_yn  =  req.getParameter( "single_stage_nb_reg_appl_yn") ==null ?"N":req.getParameter( "single_stage_nb_reg_appl_yn");
        mod_birth_reg_appl_yn  =  req.getParameter( "mod_birth_reg_appl_yn") ==null ?"N":req.getParameter( "mod_birth_reg_appl_yn");
        //invoke_chg_pat_dtls_fm_nb_yn  =  req.getParameter( "invoke_chg_pat_dtls_fm_nb_yn") ==null ?"N":req.getParameter( "invoke_chg_pat_dtls_fm_nb_yn");
        alt_id1_routine_yn =  req.getParameter( "alt_id1_invoke_routine") == null ? "N": req.getParameter("alt_id1_invoke_routine") ;
        if(alt_id1_routine_yn.equals("Y"))alt_id1_routine =req.getParameter( "alt_id1_routine_name");
        else alt_id1_routine = "" ;
        alt_id2_routine_yn=  req.getParameter( "alt_id2_invoke_routine") == null ? "N": req.getParameter("alt_id2_invoke_routine") ;
        if(alt_id2_routine_yn.equals("Y"))alt_id2_routine =req.getParameter( "alt_id2_routine_name");
        else alt_id2_routine = "" ;
        alt_id3_routine_yn =  req.getParameter( "alt_id3_invoke_routine") == null ? "N": req.getParameter("alt_id3_invoke_routine") ;
        if(alt_id3_routine_yn.equals("Y"))alt_id3_routine =req.getParameter( "alt_id3_routine_name");
        else alt_id3_routine = "" ;
        alt_id4_routine_yn = req.getParameter( "alt_id4_invoke_routine") == null ? "N": req.getParameter("alt_id4_invoke_routine") ;
        if(alt_id4_routine_yn.equals("Y"))alt_id4_routine =req.getParameter( "alt_id4_routine_name");
        else alt_id4_routine = "" ;
        name_dervn_logic_oth_lang = req.getParameter ("for_loc_lang")==null?"" :  req.getParameter ("for_loc_lang");
		long_name_dervn_logic_local = req.getParameter ("long_name_dervn_logic_local")==null?"" :  req.getParameter ("long_name_dervn_logic_local");
		
        dflt_patient_name = req.getParameter ("dflt_patient_name")==null?"" :  req.getParameter ("dflt_patient_name");
		dft_national_id = req.getParameter ("dft_national_id")==null?"" :  req.getParameter ("dft_national_id");
		gen_slno_unknown_pat_yn = req.getParameter("slno_yn") == null ? "N": req.getParameter("slno_yn") ;
		accept_national_id_no_yn = req.getParameter("accept_national_id_no_yn")==null?"N":req.getParameter("accept_national_id_no_yn");
		
		alt_id1_accept_oth_pat_ser_yn = req.getParameter("accept_for_oth_pat_ser");
		if(alt_id1_accept_oth_pat_ser_yn==null || alt_id1_accept_oth_pat_ser_yn.equals("")){
			
			alt_id1_accept_oth_pat_ser_yn="N";
		}
		
		alt_id1_accept_alphanumeric_yn = req.getParameter("accept_alphanumeric")==null?"N":req.getParameter("accept_alphanumeric");

		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
		alt_id2_accept_oth_pat_ser_yn		= req.getParameter("alt_id2_accept_oth_pat_ser_yn")==null?"N":req.getParameter("alt_id2_accept_oth_pat_ser_yn");
		alt_id2_chng_allowed_yn				= req.getParameter("alt_id2_chng_allowed_yn")==null?"N":req.getParameter("alt_id2_chng_allowed_yn");
		alt_id2_accept_alphanumeric_yn		= req.getParameter("alt_id2_accept_alphanumeric_yn")==null?"N":req.getParameter("alt_id2_accept_alphanumeric_yn");
		
		alt_id3_accept_oth_pat_ser_yn		= req.getParameter("alt_id3_accept_oth_pat_ser_yn")==null?"N":req.getParameter("alt_id3_accept_oth_pat_ser_yn");
		alt_id3_chng_allowed_yn				= req.getParameter("alt_id3_chng_allowed_yn")==null?"N":req.getParameter("alt_id3_chng_allowed_yn");
		alt_id3_accept_alphanumeric_yn		= req.getParameter("alt_id3_accept_alphanumeric_yn")==null?"N":req.getParameter("alt_id3_accept_alphanumeric_yn");

		alt_id4_accept_oth_pat_ser_yn		= req.getParameter("alt_id4_accept_oth_pat_ser_yn")==null?"N":req.getParameter("alt_id4_accept_oth_pat_ser_yn");
		alt_id4_chng_allowed_yn				= req.getParameter("alt_id4_chng_allowed_yn")==null?"N":req.getParameter("alt_id4_chng_allowed_yn");
		alt_id4_accept_alphanumeric_yn		= req.getParameter("alt_id4_accept_alphanumeric_yn")==null?"N":req.getParameter("alt_id4_accept_alphanumeric_yn");
		/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

		/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 Start */
		alt_id1_alphanum_validate_yn			= req.getParameter("alt_id1_alphanum_validate_yn")==null?"N":req.getParameter("alt_id1_alphanum_validate_yn");
		alt_id2_alphanum_validate_yn			= req.getParameter("alt_id2_alphanum_validate_yn")==null?"N":req.getParameter("alt_id2_alphanum_validate_yn");
		alt_id3_alphanum_validate_yn			= req.getParameter("alt_id3_alphanum_validate_yn")==null?"N":req.getParameter("alt_id3_alphanum_validate_yn");
		alt_id4_alphanum_validate_yn			= req.getParameter("alt_id4_alphanum_validate_yn")==null?"N":req.getParameter("alt_id4_alphanum_validate_yn");
		/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 End */




		max_pat_age = req.getParameter("max_patient_age")==null?"0":req.getParameter("max_patient_age");
		no_days_UHID_valid = req.getParameter("no_days_UHID_valid_for")==null?"":req.getParameter("no_days_UHID_valid_for");  //  Added by mujafar for AMRI-CRF-0357
		isUHID_valid_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); //  Added by mujafar for AMRI-CRF-0357
		

		//Added By Gaurav Aginst MMS-MEA-CRF-0004
		start_id_with           = req.getParameter ("start_with")==null?"":req.getParameter ("start_with") ;
		alt_id1_start_with           = req.getParameter ("alt_id1_start_with")==null?"":req.getParameter ("alt_id1_start_with") ;
		alt_id2_start_with           = req.getParameter ("alt_id2_start_with")==null?"":req.getParameter ("alt_id2_start_with") ;
		alt_id3_start_with           = req.getParameter ("alt_id3_start_with")==null?"":req.getParameter ("alt_id3_start_with") ;
		alt_id4_start_with           = req.getParameter ("alt_id4_start_with")==null?"":req.getParameter ("alt_id4_start_with") ;
		//Added By Gaurav Aginst MMS-MEA-CRF-0004
		
		nat_id_prompt           = req.getParameter ("nat_prompt")==null?"":req.getParameter ("nat_prompt") ; 
        nat_id_reqd_all_series  = req.getParameter ("nat_reqd_for_all_ser")==null?"N":req.getParameter ("nat_reqd_for_all_ser") ;
        nat_data_source_id      = req.getParameter ("nat_id_routine_name")==null?"":req.getParameter ("nat_id_routine_name") ;
        nat_id_check_digit_id      = req.getParameter ("nat_chk_dig_scheme")==null?"":req.getParameter ("nat_chk_dig_scheme") ;
        invoke_routine          = req.getParameter ("nat_invoke_routine")==null?"N":req.getParameter ("nat_invoke_routine") ;
        
        // <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 U1 Starts-->
        biometric_authentication          = req.getParameter ("biometric_authentication")==null?"N":req.getParameter ("biometric_authentication") ;
        //<!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 U1 ends-->
        
        nat_id_chk_len          = req.getParameter ("chk_len")==null?"N":req.getParameter ("chk_len") ;
		alt_id1_chk_digit_scheme    =req.getParameter ("alt_id1_chk_digit_scheme")==null?"":req.getParameter ("alt_id1_chk_digit_scheme") ;
        alt_id2_chk_digit_scheme    =req.getParameter ("alt_id2_chk_digit_scheme")==null?"":req.getParameter ("alt_id2_chk_digit_scheme") ;
        alt_id3_chk_digit_scheme    =req.getParameter ("alt_id3_chk_digit_scheme")==null?"":req.getParameter ("alt_id3_chk_digit_scheme") ;
        alt_id4_chk_digit_scheme    =req.getParameter ("alt_id4_chk_digit_scheme")==null?"":req.getParameter ("alt_id4_chk_digit_scheme") ;

        nb_use_mother_ser    =req.getParameter ("nb_use_mother_ser")==null?"N":req.getParameter ("nb_use_mother_ser") ;
        name_prefix_male_nb         =req.getParameter ("name_prefix_male_nb")==null?"":req.getParameter ("name_prefix_male_nb") ;
        name_prefix_female_nb       =req.getParameter ("name_prefix_female_nb")==null?"":req.getParameter ("name_prefix_female_nb") ;
        name_prefix_unknown_nb       =req.getParameter ("name_prefix_unknown_nb")==null?"":req.getParameter ("name_prefix_unknown_nb") ; //Added by Afruddin for ML-MMOH-CRF-1520 US001 on 4.05.2020
        nb_father_name_mandatory_yn       =req.getParameter ("nb_father_name_mandatory_yn")==null?"N":req.getParameter ("nb_father_name_mandatory_yn") ;
        nb_mother_dtls_update_yn = req.getParameter ("nb_mother_dtls_update_yn")==null?"N":req.getParameter ("nb_mother_dtls_update_yn") ;//Added for HSA-CRF-0182
        
		/*Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/
		alt_id1_pat_sch_exact_yn = req.getParameter ("alt_id1_pat_sch_exact_yn")==null?"N":req.getParameter ("alt_id1_pat_sch_exact_yn") ;
		alt_id2_pat_sch_exact_yn = req.getParameter ("alt_id2_pat_sch_exact_yn")==null?"N":req.getParameter ("alt_id2_pat_sch_exact_yn") ;
		alt_id3_pat_sch_exact_yn = req.getParameter ("alt_id3_pat_sch_exact_yn")==null?"N":req.getParameter ("alt_id3_pat_sch_exact_yn") ;
		alt_id4_pat_sch_exact_yn = req.getParameter ("alt_id4_pat_sch_exact_yn")==null?"N":req.getParameter ("alt_id4_pat_sch_exact_yn") ;
	
	


		data_upd_allowed_aft_final_yn       =req.getParameter ("data_upd_allowed_aft_final_yn")==null?"N":req.getParameter ("data_upd_allowed_aft_final_yn") ;


        accept_names_for_live_birth_yn       =req.getParameter ("accept_names_for_live_birth_yn")==null?"N":req.getParameter ("accept_names_for_live_birth_yn") ;

        dflt_race_nat_setup_nb_as_per   =    req.getParameter("dflt_race_nat_setup_nb_as_per")==null?"M":req.getParameter("dflt_race_nat_setup_nb_as_per");
		if(dflt_race_nat_setup_nb_as_per.equals(""))
          dflt_race_nat_setup_nb_as_per ="M";

        pat_name_as_multipart_yn = req.getParameter("pat_name_as_multipart_yn")==null?"N":req.getParameter("pat_name_as_multipart_yn");
		Accept_oth_alt_id_yn = req.getParameter("Accept_oth_alt_id_yn")==null?"N":req.getParameter("Accept_oth_alt_id_yn");
		gestation_two_del = req.getParameter("gestation_two_del")==null?"":req.getParameter("gestation_two_del");
		nb_mother_min_age   =  req.getParameter( "min_age_of_moth") == null ? "": req.getParameter( "min_age_of_moth"       ) ;
		nb_mother_upper_age = req.getParameter("max_age_of_moth")==null?"":req.getParameter("max_age_of_moth");
		nb_mother_cutoff_age = req.getParameter("cut_age_of_moth")==null?"":req.getParameter("cut_age_of_moth");
		nb_male_relnship = req.getParameter("dft_rel_male_nb")==null?"":req.getParameter("dft_rel_male_nb");
		nb_female_relnship = req.getParameter("dft_rel_female_nb")==null?"":req.getParameter("dft_rel_female_nb");
		nb_unknown_relnship = req.getParameter("dft_rel_unknown_nb")==null?"":req.getParameter("dft_rel_unknown_nb");
		allow_nb_regn_unit = req.getParameter("allow_nb_regn_unit")==null?"H":req.getParameter("allow_nb_regn_unit");

		id_change_allowed_for_series =req.getParameter ("id_change_allowed_for_series")==null?"":req.getParameter ("id_change_allowed_for_series") ;
		alt_id1_adv_alert_reqd_yn    =req.getParameter ("alt_id1_adv_alert_reqd_yn")==null?"N":req.getParameter ("alt_id1_adv_alert_reqd_yn") ;
		alt_id1_adv_alert_days       =req.getParameter ("alt_id1_adv_alert_days")==null?"0":req.getParameter ("alt_id1_adv_alert_days") ;
		alt_id2_adv_alert_reqd_yn    =req.getParameter ("alt_id2_adv_alert_reqd_yn")==null?"N":req.getParameter ("alt_id2_adv_alert_reqd_yn") ;
		alt_id2_adv_alert_days       =req.getParameter ("alt_id2_adv_alert_days")==null?"":req.getParameter ("alt_id2_adv_alert_days") ;
		alt_id3_adv_alert_reqd_yn    =req.getParameter ("alt_id3_adv_alert_reqd_yn")==null?"N":req.getParameter ("alt_id3_adv_alert_reqd_yn") ;
		alt_id3_adv_alert_days       =req.getParameter ("alt_id3_adv_alert_days")==null?"0":req.getParameter ("alt_id3_adv_alert_days") ;
		alt_id4_adv_alert_reqd_yn    =req.getParameter ("alt_id4_adv_alert_reqd_yn")==null?"N":req.getParameter ("alt_id4_adv_alert_reqd_yn") ;
		alt_id4_adv_alert_days       =req.getParameter ("alt_id4_adv_alert_days")==null?"":req.getParameter ("alt_id4_adv_alert_days") ;
		ext_system_interface_yn       =req.getParameter ("ext_system_interface_yn")==null?"N":req.getParameter ("ext_system_interface_yn") ;
		addl_field1_prompt           =req.getParameter ("addl_field1_prompt")==null?"":req.getParameter ("addl_field1_prompt") ;
		addl_field1_length           =req.getParameter ("addl_field1_length")==null?"":req.getParameter ("addl_field1_length") ;
		addl_field1_section          =req.getParameter ("addl_field1_section")==null?"":req.getParameter ("addl_field1_section") ;
		addl_field2_prompt           =req.getParameter ("addl_field2_prompt")==null?"":req.getParameter ("addl_field2_prompt") ;
		addl_field2_length           =req.getParameter ("addl_field2_length")==null?"":req.getParameter ("addl_field2_length") ;
		addl_field2_section          =req.getParameter ("addl_field2_section")==null?"":req.getParameter ("addl_field2_section") ;
		addl_field3_prompt           =req.getParameter ("addl_field3_prompt")==null?"":req.getParameter ("addl_field3_prompt") ;
		addl_field3_length           =req.getParameter ("addl_field3_length")==null?"":req.getParameter ("addl_field3_length") ;
		addl_field3_section          =req.getParameter ("addl_field3_section")==null?"":req.getParameter ("addl_field3_section") ;
		addl_field4_prompt           =req.getParameter ("addl_field4_prompt")==null?"":req.getParameter ("addl_field4_prompt") ;
		addl_field4_length           =req.getParameter ("addl_field4_length")==null?"":req.getParameter ("addl_field4_length") ;
		addl_field4_section          =req.getParameter ("addl_field4_section")==null?"":req.getParameter ("addl_field4_section") ;
		addl_field5_prompt           =req.getParameter ("addl_field5_prompt")==null?"":req.getParameter ("addl_field5_prompt") ;
		addl_field5_length           =req.getParameter ("addl_field5_length")==null?"":req.getParameter ("addl_field5_length") ;
		addl_field5_section          =req.getParameter ("addl_field5_section")==null?"":req.getParameter ("addl_field5_section") ;
		min_weight =req.getParameter ("min_weight")==null?"":req.getParameter ("min_weight") ;
		max_weight =req.getParameter ("max_weight")==null?"":req.getParameter ("max_weight") ;
		min_length =req.getParameter ("min_length")==null?"":req.getParameter ("min_length") ;
		max_length =req.getParameter ("max_length")==null?"":req.getParameter ("max_length") ;
		min_head_circum =req.getParameter ("min_head_circum")==null?"":req.getParameter ("min_head_circum") ;
		max_head_circum =req.getParameter ("max_head_circum")==null?"":req.getParameter ("max_head_circum") ;
		min_chest_circum =req.getParameter ("min_chest_circum")==null?"":req.getParameter ("min_chest_circum") ;
		max_chest_circum =req.getParameter ("max_chest_circum")==null?"":req.getParameter ("max_chest_circum") ;
		min_gestation =req.getParameter ("min_gestation")==null?"":req.getParameter ("min_gestation") ;
		max_gestation =req.getParameter ("max_gestation")==null?"":req.getParameter ("max_gestation") ;
        p                   = ( java.util.Properties ) session.getValue( "jdbc" ) ;
        ws_no                   = p.getProperty("client_ip_address");
        facility_id             = (String) session.getValue( "facility_id" ) ;
        uid = p.getProperty( "login_user" ) ;

        operation               = req.getParameter( "operation" ) == null ? "" : req.getParameter( "operation" ) ;
		d_alt_id1_exp_warn_yn = req.getParameter( "d_alt_id1_exp_warn_yn") == null ? "N" : req.getParameter( "d_alt_id1_exp_warn_yn") ;
		d_alt_id2_exp_warn_yn = req.getParameter( "d_alt_id2_exp_warn_yn") == null ? "N" : req.getParameter( "d_alt_id2_exp_warn_yn") ;
		d_alt_id3_exp_warn_yn = req.getParameter( "d_alt_id3_exp_warn_yn") == null ? "N" : req.getParameter( "d_alt_id3_exp_warn_yn") ;
		d_alt_id4_exp_warn_yn = req.getParameter( "d_alt_id4_exp_warn_yn") == null ? "N" : req.getParameter( "d_alt_id4_exp_warn_yn") ;

		entitlement_by_pat_cat_yn = req.getParameter( "entitlement_by_pat_cat_yn") == null ? "N" : req.getParameter( "entitlement_by_pat_cat_yn") ;
		mapped_alt_id_org_member_id = req.getParameter( "mapped_alt_id_org_member_id") == null ? "" : req.getParameter( "mapped_alt_id_org_member_id") ;
		

		family_org_id_accept_yn = req.getParameter( "family_org_id_accept_yn") == null ? "N" : req.getParameter( "family_org_id_accept_yn") ;

		org_member_relationship_code = req.getParameter( "org_member_relationship_code") == null ? "" : req.getParameter( "org_member_relationship_code") ;


		name_prefix_length = req.getParameter( "name_prefix_length") == null ? "0" : req.getParameter( "name_prefix_length") ;

		first_name_length = req.getParameter( "first_name_length") == null ? "0" : req.getParameter( "first_name_length") ;

		second_name_length = req.getParameter( "second_name_length") == null ? "0" : req.getParameter( "second_name_length") ;

		third_name_length = req.getParameter( "third_name_length") == null ? "0" : req.getParameter( "third_name_length") ;

		family_name_length = req.getParameter( "family_name_length") == null ? "0" : req.getParameter( "family_name_length") ;

		name_suffix_length = req.getParameter( "name_suffix_length") == null ? "0" : req.getParameter( "name_suffix_length") ;

		alt_id1_chng_allowed_yn = req.getParameter( "alt_id1_chng_allowed_yn") == null ? "N" : req.getParameter( "alt_id1_chng_allowed_yn") ;
		accept_pw_in_chng_pat_dtl_yn=req.getParameter("accept_pw_in_chng_pat_dtl_yn") == null ? "N" : req.getParameter("accept_pw_in_chng_pat_dtl_yn"            ) ;

		dflt_language_id = req.getParameter( "language_code") == null ? "" : req.getParameter("language_code") ;
		dflt_relgn_code = req.getParameter( "religion_code") == null ? "" : req.getParameter("religion_code") ;
		inv_pat_search_in_reg_pat_yn=req.getParameter("INV_PAT_SEARCH_IN_REG_PAT_YN") == null ? "N" : req.getParameter("INV_PAT_SEARCH_IN_REG_PAT_YN") ;

		// ON 2/26/2008
		gen_patid_using_altid_rl_yn=req.getParameter("gen_patid_using_altid_rl_yn")==null?"N":req.getParameter("gen_patid_using_altid_rl_yn") ;
		nat_id_accept_alphanumeric_yn=req.getParameter("nat_id_accept_alphanumeric_yn")==null?"N":req.getParameter("nat_id_accept_alphanumeric_yn") ;

		race_required_yn=req.getParameter("race_required_yn")==null?"N":req.getParameter("race_required_yn") ;
		round_dob_estd_age=req.getParameter("round_dob_estd_age")==null?"N":req.getParameter("round_dob_estd_age") ;

		create_file_yn=req.getParameter("create_file_yn")==null?"Y":req.getParameter("create_file_yn") ;
		still_born_prefix=req.getParameter("still_born_prefix")==null?"":req.getParameter("still_born_prefix") ;
		pat_photo_renewal_alert_days=req.getParameter("pat_photo_renewal_alert_days")==null?"":req.getParameter("pat_photo_renewal_alert_days") ;
		//Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
		//Start
		mortuary_release_yn=req.getParameter("mortuary_release_yn")==null?"N":req.getParameter("mortuary_release_yn") ;
		no_days_before_deceased = req.getParameter( "no_days_before_deceased") == null ? "0" : req.getParameter( "no_days_before_deceased") ;
		cancel_reason_code = req.getParameter("cancel_reason_code")== null?"":req.getParameter("cancel_reason_code") ;
		//End
		// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
		country_reqd_yn=req.getParameter("country_reqd_yn")==null?"N":req.getParameter("country_reqd_yn") ;
		region_reqd_yn=req.getParameter("region_reqd_yn")==null?"N":req.getParameter("region_reqd_yn") ;
		mobile_no_reqd_yn=req.getParameter("mobile_no_reqd_yn")==null?"N":req.getParameter("mobile_no_reqd_yn") ;
		// End
		// New parameter  is added against KDAH-CRF-0273 [IN:045012] by Saanthaakumar
		email_id_reqd_yn=req.getParameter("email_id_reqd_yn")==null?"N":req.getParameter("email_id_reqd_yn") ;
		// New parameter  is added against amri-crf-0388 by Shagar
		postal_cd_reqd_yn=req.getParameter("postal_cd_reqd_yn")==null?"N":req.getParameter("postal_cd_reqd_yn") ;
		area_reqd_yn=req.getParameter("area_reqd_yn")==null?"N":req.getParameter("area_reqd_yn") ;
		
		// Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
		patientcategory_reqd_yn=req.getParameter("patientcategory_reqd_yn")==null?"N":req.getParameter("patientcategory_reqd_yn") ;
		town_reqd_yn=req.getParameter("town_reqd_yn")==null?"N":req.getParameter("town_reqd_yn") ;
		
		//New parameter is added against ML-MMOH-CRF-0736 by Mano
		religion_reqd_yn=req.getParameter("religion_reqd_yn")==null?"N":req.getParameter("religion_reqd_yn") ;
		//End

		pat_ser_access_by_user_yn=req.getParameter("pat_ser_access_by_user_yn")==null?"N":req.getParameter("pat_ser_access_by_user_yn") ;//added for MO-CRF20074
		upt_contact_dtls_oa_yn=req.getParameter("upt_contact_dtls_oa_yn")==null?"N":req.getParameter("upt_contact_dtls_oa_yn") ;//added changes for HSA-CRF-0226 [IN:050599]
		upd_pat_dtls_referral_yn	=req.getParameter("upd_pat_dtls_referral_yn")==null?"N":req.getParameter("upd_pat_dtls_referral_yn") ;//Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 8th 2016
        	disp_cancelled_previous_enc_yn	=req.getParameter("disp_cancelled_previous_enc_yn")==null?"N":req.getParameter("disp_cancelled_previous_enc_yn") ;
		prepareData() ;

        //ADDED BY PRITHIVI ON 10/05/2017 FOR KDAH-CRF-0362
		aadhar_config_enabled_yn=req.getParameter("aadhar_config_enabled_yn")==null?"N":req.getParameter("aadhar_config_enabled_yn") ;
		aadhar_option_value=req.getParameter("aadhar_option_value")==null?"":req.getParameter("aadhar_option_value") ;
		
		//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
		name_dervn_logic_nb = req.getParameter( "name_dervn_logic_nb" ) == null ? "" : req.getParameter( "name_dervn_logic_nb" ) ;
		//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
		name_dervn_logic_nb_sb = req.getParameter( "name_dervn_logic_nb_sb" ) == null ? "" : req.getParameter( "name_dervn_logic_nb_sb" ) ;

		death_reg_form_req_yn = req.getParameter( "death_reg_form_req_yn" ) == null ? "N" : req.getParameter( "death_reg_form_req_yn" ) ; //Added by Ajay Hatwate for AAKH-CRF-0179

		unmask_aadhaar_num_yn = req.getParameter( "unmask_aadhaar_num_yn" ) == null ? "N" : req.getParameter( "unmask_aadhaar_num_yn" ) ; 	//Added by Rajkumar  for GHL-CRF-0686
		unmask_abha_num_addr_yn = req.getParameter( "unmask_abha_num_addr_yn" ) == null ? "N" : req.getParameter( "unmask_abha_num_addr_yn" ) ; 	//Added by Rajkumar  for GHL-CRF-0686
		
		occupation_reqd_yn=req.getParameter("occupation_reqd_yn")==null?"N":req.getParameter("occupation_reqd_yn") ;//Added for NMC-JD-CRF-0236
		marital_status_reqd_yn=req.getParameter("marital_status_reqd_yn")==null?"N":req.getParameter("marital_status_reqd_yn") ;//Added for NMC-JD-CRF-0236
		mand_visit_admssn_reg_yn=req.getParameter("mand_visit_admssn_reg_yn")==null?"N":req.getParameter("mand_visit_admssn_reg_yn") ;//Added for NMC-JD-CRF-0236
	
		//Added by Santhosh for GHL-CRF-0686.3
		abha_eng_audio_path = req.getParameter( "englishAudioPath" ) == null ? "" : req.getParameter( "englishAudioPath" ) ;
		abha_hin_audio_path = req.getParameter( "hindiAudioPath" ) == null ? "" : req.getParameter( "hindiAudioPath" ) ;
		//End
		
				//Added by Jeyachitra against ML-MMOH-CRF-1759.1-US001
		  mand_parity_newborn_yn = req.getParameter("mand_parity_newborn_yn")==null? "N":req.getParameter("mand_parity_newborn_yn");
	      mand_parity_newborn_ip_yn = req.getParameter("mand_parity_newborn_ip_yn")==null?"N":req.getParameter("mand_parity_newborn_ip_yn");
	      mand_parity_newborn_ae_yn = req.getParameter("mand_parity_newborn_ae_yn")==null?"N":req.getParameter("mand_parity_newborn_ae_yn");
	      invoke_menstrual_history_yn= req.getParameter("invoke_menstrual_history_yn")==null?"N":req.getParameter("invoke_menstrual_history_yn");
	      //ML-MMOH-CRF-1759.1-US001 ends

		if ( operation.equalsIgnoreCase( "insert" ) )
  			insertMpParam(res) ;
        if ( operation.equalsIgnoreCase( "modify" ) )
            updateMpParam(res ) ;

		
     }
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,req);
		}
	}

    private void prepareData() {
    try {

        } catch ( Exception e ) {
			e.printStackTrace();

        }
    }

    private void insertMpParam(HttpServletResponse res ) {
        try {
				HashMap tabdata=new HashMap();
                String dupflds[]={};
				
				tabdata.put("module_id","MP");
                tabdata.put("patient_id_length",patient_id_length);

                tabdata.put("patient_no_ctrl",patient_no_ctrl);
                tabdata.put("gen_pat_ser_grp",gen_pat_ser_grp);
                tabdata.put("nat_id_pat_ser_grp",nat_id_pat_ser_grp);
                tabdata.put("family_link_hist_yn","N");
                tabdata.put("org_member_hist_yn","N");
                tabdata.put("pat_cat_hist_yn","N");

                tabdata.put("alt_id_pat_ser_grp",alt_id_pat_ser_grp);
                tabdata.put("dflt_pat_ser_grp_type",dflt_pat_ser_grp_type);
                tabdata.put("emeg_pat_ser_grp",emeg_pat_ser_grp);
                tabdata.put("newborn_pat_ser_grp",newborn_pat_ser_grp);
                tabdata.put("nat_id_length",nat_id_length);
                tabdata.put("name_dervn_logic",name_dervn_logic);
				tabdata.put("create_file_at_pat_regn_yn",create_file_at_pat_regn_yn);
				tabdata.put("create_file_at_admission",create_file_at_admission);
				tabdata.put("create_file_at_reg_visit_yn",create_file_at_reg_visit_yn);
				tabdata.put("create_file_at_reg_att_yn",create_file_at_reg_att_yn);
				tabdata.put("create_file_at_dc_admission_yn",create_file_at_dc_admission_yn);
				tabdata.put("file_type_appl_yn",file_type_appl_yn);

                tabdata.put("family_no_link_yn",family_no_link_yn);
                tabdata.put("head_patient_no_use_yn","N");
                tabdata.put("family_org_id_accept_yn",family_org_id_accept_yn_new);
                tabdata.put("citizen_nationality_code",citizen_nationality_code);
                tabdata.put("default_race_code",default_race_code);
                tabdata.put("nb_dflt_relnship_code",default_relationship_code);
                tabdata.put("general_alert_yn",general_alert_yn);
                tabdata.put("suspend_service_yn",suspend_service_yn);
                tabdata.put("single_or_multi_files_ind",single_or_multi_files_ind);
                tabdata.put("separate_file_no_yn",separate_file_no_yn);
                tabdata.put("ext_system_interface_yn","N");
                tabdata.put("name_prefix_accept_yn",name_prefix_accept_yn);
                tabdata.put("name_prefix_reqd_yn",name_prefix_reqd_yn);
                tabdata.put("name_prefix_prompt",name_prefix_prompt);
				tabdata.put("name_prefix_loc_lang_prompt",name_prefix_loc_lang_prompt);
                tabdata.put("first_name_accept_yn",first_name_accept_yn);
                tabdata.put("first_name_reqd_yn",first_name_reqd_yn);
                tabdata.put("first_name_order",first_name_order);
                tabdata.put("first_name_prompt",first_name_prompt);
				tabdata.put("first_name_loc_lang_prompt",first_name_loc_lang_prompt);
                tabdata.put("second_name_accept_yn",second_name_accept_yn);
                tabdata.put("second_name_reqd_yn",second_name_reqd_yn);
                tabdata.put("second_name_order",second_name_order);
                tabdata.put("second_name_prompt",second_name_prompt);
				tabdata.put("second_name_loc_lang_prompt",second_name_loc_lang_prompt);
                tabdata.put("third_name_accept_yn",third_name_accept_yn);
                tabdata.put("third_name_reqd_yn",third_name_reqd_yn);
                tabdata.put("third_name_order",third_name_order);
                tabdata.put("third_name_prompt",third_name_prompt);
				tabdata.put("third_name_loc_lang_prompt",third_name_loc_lang_prompt);
                tabdata.put("family_name_accept_yn",family_name_accept_yn);
                tabdata.put("family_name_reqd_yn",family_name_reqd_yn);
                tabdata.put("family_name_order",family_name_order);
                tabdata.put("family_name_prompt",family_name_prompt);
				tabdata.put("family_name_loc_lang_prompt",family_name_loc_lang_prompt);
                tabdata.put("name_suffix_accept_yn",name_suffix_accept_yn);
                tabdata.put("name_suffix_reqd_yn",name_suffix_reqd_yn);
                tabdata.put("name_suffix_prompt",name_suffix_prompt);
				tabdata.put("name_suffix_loc_lang_prompt",name_suffix_loc_lang_prompt);
                tabdata.put("names_in_oth_lang_yn",name_in_oth_lang_yn);
				tabdata.put(" single_patient_numbering_yn", single_patient_numbering_yn);
				tabdata.put("display_new_born_age_in_hrs", display_new_born_age_in_hrs);
				tabdata.put("age_not_consider_natid", age_not_consider_natid); //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
				tabdata.put("age_not_consider_natid_altid", age_not_consider_natid_altid); //Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]

				tabdata.put("dflt_sndx_type",dflt_sndx_type);
                tabdata.put("alt_id1_type",alt_id1_type);
                tabdata.put("alt_id1_length",alt_id1_length);
                tabdata.put("alt_id1_reqd_yn",alt_id1_reqd_yn);
                tabdata.put("alt_id1_unique_yn",alt_id1_unique_yn);
                tabdata.put("alt_id1_exp_warn_yn",alt_id1_exp_warn_yn);
                tabdata.put("alt_id1_exp_grace_days",alt_id1_exp_grace_days);
                tabdata.put("alt_id2_type",alt_id2_type);
                tabdata.put("alt_id2_length",alt_id2_length);
                tabdata.put("alt_id2_reqd_yn",alt_id2_reqd_yn);
                tabdata.put("alt_id2_unique_yn",alt_id2_unique_yn);
                tabdata.put("alt_id2_exp_warn_yn",alt_id2_exp_warn_yn);
                tabdata.put("alt_id2_exp_grace_days",alt_id2_exp_grace_days);
                tabdata.put("alt_id3_type",alt_id3_type);
                tabdata.put("alt_id3_length",alt_id3_length);
                tabdata.put("alt_id3_reqd_yn",alt_id3_reqd_yn);
                tabdata.put("alt_id3_unique_yn",alt_id3_unique_yn);
                tabdata.put("alt_id3_exp_warn_yn",alt_id3_exp_warn_yn);
                tabdata.put("alt_id3_exp_grace_days",alt_id3_exp_grace_days);
                tabdata.put("alt_id4_type",alt_id4_type);
                tabdata.put("alt_id4_length",alt_id4_length);
                tabdata.put("alt_id4_reqd_yn",alt_id4_reqd_yn);
                tabdata.put("alt_id4_unique_yn",alt_id4_unique_yn);
                tabdata.put("alt_id4_exp_warn_yn",alt_id4_exp_warn_yn);
                tabdata.put("alt_id4_exp_grace_days",alt_id4_exp_grace_days);
                tabdata.put("entitlement_by_pat_cat_yn",entitlement_by_pat_cat_yn);
                tabdata.put("family_org_id_accept_yn",family_org_id_accept_yn_new);
                tabdata.put("mapped_alt_id_org_member_id",mapped_alt_id_org_member_id);
                tabdata.put("org_member_relationship_code",org_member_relationship_code);
                tabdata.put("dflt_contact_mode1","PRN");
                tabdata.put("dflt_contact_mode2","ORN");
                tabdata.put("dflt_addr_type1","RES");
                tabdata.put("dflt_addr_type2","MAI");
                tabdata.put("allow_nb_regn_within_days",allow_nb_regn_within_days);
				tabdata.put("max_multiple_birth_regn_hrs",mul_birth_regn_within_hours);
				tabdata.put("ext_system_interface_yn",ext_system_interface_yn);
				tabdata.put("unit_of_wt_nb",unit_of_wt_nb);
                tabdata.put("unit_of_circum_nb",unit_of_circum_nb);
                tabdata.put("unit_of_length_nb",unit_of_length_nb);
                tabdata.put("unit_of_gest_nb", unit_of_gest_nb);//Added for HSA-SCF-0057 [IN:050095] By Dharma. July 10,2014
                tabdata.put("sub_multi_birth_hw",sub_multi_birth_hw);
				tabdata.put("unit_of_chest_circum_nb",unit_of_chest_circum_nb);
                tabdata.put("name_suffix_male_nb",name_suffix_male_nb);
                tabdata.put("name_suffix_female_nb",name_suffix_female_nb);
                tabdata.put("review_nb_links_bef_reg_yn",review_nb_links_bef_reg_yn);
				//Added by kamatchi s for ML-MMOH-CRF-2095
                tabdata.put("length_of_baby_yn",length_of_baby_yn);
                tabdata.put("head_circumference_of_baby_yn",head_circumference_of_baby_yn);
				 tabdata.put("allow_ext_nb_regn_within_days",allow_ext_nb_regn_within_days);
				//Added by kamatchi s for ML-MMOH-CRF-1757
                tabdata.put("mandate_first_newborn_yn",mandate_first_newborn_yn);
                tabdata.put("mandate_first_newborn_ip_yn",mandate_first_newborn_ip_yn);
                tabdata.put("mandate_first_newborn_ae_yn",mandate_first_newborn_ae_yn);
                tabdata.put("mandate_second_newborn_yn",mandate_second_newborn_yn);
                tabdata.put("mandate_second_newborn_ip_yn",mandate_second_newborn_ip_yn);
                tabdata.put("mandate_second_newborn_ae_yn",mandate_second_newborn_ae_yn);
                tabdata.put("mandate_third_newborn_yn",mandate_third_newborn_yn);
                tabdata.put("mandate_third_newborn_ip_yn",mandate_third_newborn_ip_yn);
                tabdata.put("mandate_third_newborn_ae_yn",mandate_third_newborn_ae_yn);
                tabdata.put("mand_antenatal_newborn_yn",mand_antenatal_newborn_yn);
                tabdata.put("mand_antenatal_newborn_ip_yn",mand_antenatal_newborn_ip_yn);
                tabdata.put("mand_antenatal_newborn_ae_yn",mand_antenatal_newborn_ae_yn);

				//added by kamatchi s for ML-MMOH-CRF-2097
                tabdata.put("enable_marital_status",enable_marital_status);
                tabdata.put("dflt_father_first_name_prompt",dflt_father_first_name_prompt);
                tabdata.put("dflt_father_Second_name_prompt",dflt_father_Second_name_prompt);
                tabdata.put("dflt_father_third_name_prompt",dflt_father_third_name_prompt);
                tabdata.put("dflt_father_family_name_prompt",dflt_father_family_name_prompt);
				
                tabdata.put("single_stage_nb_reg_appl_yn",single_stage_nb_reg_appl_yn);
                tabdata.put("mod_birth_reg_appl_yn",mod_birth_reg_appl_yn);
              //  tabdata.put("invoke_chg_pat_dtls_fm_nb_yn",invoke_chg_pat_dtls_fm_nb_yn);
                tabdata.put("id_card_title",id_card_title);
                tabdata.put("line1_face_sheet_text",line1_face_sheet_text);
                tabdata.put("line2_face_sheet_text",line2_face_sheet_text);
                tabdata.put("line3_face_sheet_text",line3_face_sheet_text);
                tabdata.put("line4_face_sheet_text",line4_face_sheet_text);
                tabdata.put("line5_face_sheet_text",line5_face_sheet_text);
                tabdata.put("line6_face_sheet_text",line6_face_sheet_text);
                tabdata.put("line7_face_sheet_text",line7_face_sheet_text);
                tabdata.put("line8_face_sheet_text",line8_face_sheet_text);
                tabdata.put("line9_face_sheet_text",line9_face_sheet_text);
                tabdata.put("line10_face_sheet_text",line10_face_sheet_text);
                tabdata.put("sex_hist_yn","N");
                tabdata.put("birth_date_hist_yn","N");
                tabdata.put("legal_name_hist_yn","N");
                tabdata.put("alias_name_hist_yn","N");
                tabdata.put("coded_pseudo_name_hist_yn","N");
                tabdata.put("contact_no_hist_yn","N");
                tabdata.put("address_hist_yn","N");
                tabdata.put("ocpn_n_empl_hist_yn","N");
                tabdata.put("general_alert_info_hist_yn","N");
                tabdata.put("suspend_reinstate_hist_yn","N");
                tabdata.put("inact_act_hist_yn","N");
                tabdata.put("rec_revoke_death_hist_yn","N");
				tabdata.put("added_by_id",uid);
                tabdata.put("added_date",new java.sql.Date(System.currentTimeMillis()));
                tabdata.put("added_at_ws_no",ws_no);
                tabdata.put("added_facility_id",facility_id);
                tabdata.put("modified_by_id",uid);
                tabdata.put("modified_date",new java.sql.Date(System.currentTimeMillis()));
                tabdata.put("modified_at_ws_no",ws_no);
                tabdata.put("modified_facility_id",facility_id);
                tabdata.put("hr_interface_yn","N");

                tabdata.put("his_interface_yn","N");

                tabdata.put("alt_id1_len_validation_yn",alt_id1_len_validation_yn);
                tabdata.put("alt_id2_len_validation_yn",alt_id2_len_validation_yn);
                tabdata.put("alt_id3_len_validation_yn",alt_id3_len_validation_yn);
                tabdata.put("alt_id4_len_validation_yn",alt_id4_len_validation_yn);
                tabdata.put("alt_id1_exp_date_accept_yn",alt_id1_exp_date_accept_yn);
                tabdata.put("alt_id2_exp_date_accept_yn",alt_id2_exp_date_accept_yn);
                tabdata.put("alt_id3_exp_date_accept_yn",alt_id3_exp_date_accept_yn);
                tabdata.put("alt_id4_exp_date_accept_yn",alt_id4_exp_date_accept_yn);

                tabdata.put("alt_id1_routine_yn",alt_id1_routine_yn);
                tabdata.put("ALT_ID1_DATA_SOURCE_ID",alt_id1_routine);
                tabdata.put("alt_id2_routine_yn",alt_id2_routine_yn);
                tabdata.put("ALT_ID2_DATA_SOURCE_ID",alt_id2_routine);
                tabdata.put("alt_id3_routine_yn",alt_id3_routine_yn);
                tabdata.put("ALT_ID3_DATA_SOURCE_ID",alt_id3_routine);
                tabdata.put("alt_id4_routine_yn",alt_id4_routine_yn);
                tabdata.put("ALT_ID4_DATA_SOURCE_ID",alt_id4_routine);
                tabdata.put("alt_id1_chk_digit_scheme",alt_id1_chk_digit_scheme);
                tabdata.put("alt_id2_chk_digit_scheme",alt_id2_chk_digit_scheme);
                tabdata.put("alt_id3_chk_digit_scheme",alt_id3_chk_digit_scheme);
                tabdata.put("alt_id4_chk_digit_scheme",alt_id4_chk_digit_scheme);
                
				//Added By Gaurav Aginst MMS-MEA-CRF-0004
				tabdata.put("start_id_with",start_id_with); 
				tabdata.put("alt_id1_start_with",alt_id1_start_with); 
				tabdata.put("alt_id2_start_with",alt_id2_start_with); 
				tabdata.put("alt_id3_start_with",alt_id3_start_with); 
				tabdata.put("alt_id4_start_with",alt_id4_start_with); 
				//Added By Gaurav Aginst MMS-MEA-CRF-0004
                
				tabdata.put("nat_id_prompt",nat_id_prompt );
                tabdata.put("nat_id_reqd_all_series",nat_id_reqd_all_series);
                tabdata.put("nat_id_chk_len",nat_id_chk_len);
                tabdata.put("nat_id_check_digit_id",nat_id_check_digit_id );
                tabdata.put("nat_data_source_id",nat_data_source_id);
                tabdata.put("invoke_routine",invoke_routine);
                tabdata.put("name_dervn_logic_oth_lang",name_dervn_logic_oth_lang );
                tabdata.put("dflt_patient_name",dflt_patient_name );
				tabdata.put("dft_national_id",dft_national_id );
				tabdata.put("gen_slno_unknown_pat_yn",gen_slno_unknown_pat_yn);
				tabdata.put("nb_mother_min_age",nb_mother_min_age );
				tabdata.put("Accept_oth_alt_id_yn",Accept_oth_alt_id_yn );
				tabdata.put("nb_min_gest_bet_2_dely",gestation_two_del );
				tabdata.put("nb_mother_upper_age",nb_mother_upper_age );
				tabdata.put("nb_mother_cutoff_age",nb_mother_cutoff_age );
				tabdata.put("allow_nb_regn_unit",allow_nb_regn_unit );
				tabdata.put("nb_male_relnship",nb_male_relnship );
				tabdata.put("nb_female_relnship",nb_female_relnship );
				tabdata.put("nb_unknown_relnship",nb_unknown_relnship );
				tabdata.put("nb_father_min_age",nb_father_min_age );
                tabdata.put("nb_use_mother_ser",nb_use_mother_ser );
                tabdata.put("name_prefix_male_nb", name_prefix_male_nb);
                tabdata.put("name_prefix_female_nb",name_prefix_female_nb);
                tabdata.put("name_prefix_unknown_nb",name_prefix_unknown_nb); //Added by Afruddin for ML-MMOH-CRF-1520 US001 on 4.05.2020
                tabdata.put("nb_father_name_mandatory_yn",nb_father_name_mandatory_yn);
                tabdata.put("nb_mother_dtls_update_yn",nb_mother_dtls_update_yn);//Added for HSA-CRF-0182

				/*Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/
				tabdata.put("alt_id1_pat_sch_exact_yn",alt_id1_pat_sch_exact_yn);
				tabdata.put("alt_id2_pat_sch_exact_yn",alt_id2_pat_sch_exact_yn);
				tabdata.put("alt_id3_pat_sch_exact_yn",alt_id3_pat_sch_exact_yn);
				tabdata.put("alt_id4_pat_sch_exact_yn",alt_id4_pat_sch_exact_yn);

				

                tabdata.put("data_upd_allowed_aft_final_yn",data_upd_allowed_aft_final_yn);
                tabdata.put("accept_names_for_live_birth_yn",accept_names_for_live_birth_yn);
                tabdata.put("dflt_race_nat_setup_nb_as_per",dflt_race_nat_setup_nb_as_per);


                tabdata.put("id_change_allowed_for_series",id_change_allowed_for_series );
                tabdata.put("alt_id1_adv_alert_reqd_yn",alt_id1_adv_alert_reqd_yn);
                tabdata.put("alt_id1_adv_alert_days",alt_id1_adv_alert_days);
                tabdata.put("alt_id2_adv_alert_reqd_yn",alt_id2_adv_alert_reqd_yn);
                tabdata.put("alt_id2_adv_alert_days",alt_id2_adv_alert_days );
                tabdata.put("alt_id3_adv_alert_reqd_yn",alt_id3_adv_alert_reqd_yn);
                tabdata.put("alt_id3_adv_alert_days",alt_id3_adv_alert_days);
                tabdata.put("alt_id4_adv_alert_reqd_yn",alt_id4_adv_alert_reqd_yn);
                tabdata.put("alt_id4_adv_alert_days",alt_id4_adv_alert_days );
                tabdata.put("terminal_digit_reqd_yn",terminal_digit_reqd_yn);
                tabdata.put("addl_field1_prompt",addl_field1_prompt);
                tabdata.put("addl_field1_length",addl_field1_length);
                tabdata.put("addl_field1_section",addl_field1_section );
                tabdata.put("addl_field2_prompt",addl_field2_prompt);
                tabdata.put("addl_field2_length",addl_field2_length);
                tabdata.put("addl_field2_section",addl_field2_section );
                tabdata.put("addl_field3_prompt",addl_field3_prompt);
                tabdata.put("addl_field3_length",addl_field3_length);
                tabdata.put("addl_field3_section",addl_field3_section );
                tabdata.put("addl_field4_prompt",addl_field4_prompt);
                tabdata.put("addl_field4_length",addl_field4_length);
                tabdata.put("addl_field4_section",addl_field4_section );
                tabdata.put("addl_field5_prompt",addl_field5_prompt);
                tabdata.put("addl_field5_length",addl_field5_length);
                tabdata.put("addl_field5_section",addl_field5_section );

				tabdata.put("accept_national_id_no_yn",accept_national_id_no_yn);
				tabdata.put("alt_id1_accept_alphanumeric_yn",alt_id1_accept_alphanumeric_yn);
				tabdata.put("alt_id1_accept_oth_pat_ser_yn",alt_id1_accept_oth_pat_ser_yn);
				tabdata.put("max_patient_age",max_pat_age);
				if(isUHID_valid_appl) //  Added by mujafar for AMRI-CRF-0357
				tabdata.put("UHID_VALID_DAYS",no_days_UHID_valid);
				
				tabdata.put("min_weight",min_weight);
				tabdata.put("max_weight",max_weight);
				tabdata.put("min_length",min_length);
				tabdata.put("max_length",max_length);
				tabdata.put("min_head_circum",min_head_circum);
				tabdata.put("max_head_circum",max_head_circum);
				tabdata.put("min_chest_circum",min_chest_circum);
				tabdata.put("max_chest_circum",max_chest_circum);
				tabdata.put("min_gestation",min_gestation);
				tabdata.put("max_gestation",max_gestation);
				tabdata.put("family_name_prefix_yn",family_name_prefix_yn);
				tabdata.put("prompt_pat_fin_class_yn",prompt_pat_fin_class_yn);
				tabdata.put("pat_name_as_multipart_yn",pat_name_as_multipart_yn);

				tabdata.put("maintain_doc_or_file",maintain_doc_or_file);
				tabdata.put("alt_id1_hist_yn",alt_id1_hist_yn);
				tabdata.put("alt_id2_hist_yn",alt_id2_hist_yn);
				tabdata.put("alt_id3_hist_yn",alt_id3_hist_yn);
				tabdata.put("alt_id4_hist_yn",alt_id4_hist_yn);
				tabdata.put("nationality_hist_yn",nationality_hist_yn);

				tabdata.put("dflt_alt_id1_in_emp_id_yn",dflt_alt_id1_in_emp_id_yn);
				tabdata.put("acpt_appt_rfrl_in_reg_pat_yn",acpt_appt_rfrl_in_reg_pat_yn);

				tabdata.put("name_prefix_length",name_prefix_length);
				tabdata.put("first_name_length",first_name_length);
				tabdata.put("second_name_length",second_name_length);
				tabdata.put("third_name_length",third_name_length);
				tabdata.put("family_name_length",family_name_length);
				tabdata.put("name_suffix_length",name_suffix_length);
				tabdata.put("alt_id1_chng_allowed_yn",alt_id1_chng_allowed_yn);
				tabdata.put("accept_pw_in_chng_pat_dtl_yn",accept_pw_in_chng_pat_dtl_yn);

				tabdata.put("dflt_language_id",dflt_language_id);
				tabdata.put("dflt_relgn_code",dflt_relgn_code);
				tabdata.put("inv_pat_search_in_reg_pat_yn",inv_pat_search_in_reg_pat_yn);
				tabdata.put("name_pfx_reqd_for_org_mem_yn",name_pfx_reqd_for_org_mem_yn);
				tabdata.put("gen_pid_using_aid1_rule_yn",gen_patid_using_altid_rl_yn);
				tabdata.put("nat_id_accept_alphanumeric_yn",nat_id_accept_alphanumeric_yn);
				tabdata.put("create_file_yn",create_file_yn);
				tabdata.put("race_required_yn",race_required_yn);
				tabdata.put("round_dob_estd_age",round_dob_estd_age);
				tabdata.put("still_born_prefix",still_born_prefix);
				tabdata.put("pat_photo_renewal_alert_days",pat_photo_renewal_alert_days);
				tabdata.put("NAME_DERVN_LOGIC_LONG",long_name_dervn_logic);
				tabdata.put("NAME_DERVN_LOGIC_OTH_LANG_LONG",long_name_dervn_logic_local);
				tabdata.put("PAT_SEARCH_DFLT_TAB",pat_search_tab);
				//Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
				//Start
				tabdata.put("CANCEL_ONLY_FOR_MO_PATIENTS_YN",mortuary_release_yn);
				tabdata.put("CANCEL_CUT_OFF_PERIOD_IN_DAYS",no_days_before_deceased);
				tabdata.put("cancel_reason_code",cancel_reason_code);
				//End
//				tabdata.put("relationship_level_length",relationship_level_length);
				// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
				tabdata.put("country_reqd_yn",country_reqd_yn);
				tabdata.put("region_reqd_yn",region_reqd_yn);
				tabdata.put("mobile_no_reqd_yn",mobile_no_reqd_yn);
				//Ends here
				// New parameter  is added against KDAH-CRF-0273 [IN:045012] by Saanthaakumar
				tabdata.put("email_id_reqd_yn",email_id_reqd_yn);
				// New parameter  is added against AMRI-CRF-0388 by SHAGAR
				tabdata.put("postal_cd_reqd_yn",postal_cd_reqd_yn);
				tabdata.put("area_reqd_yn",area_reqd_yn);				
				//New parameter is added against ML-MMOH-CRF-0736 by mano
				tabdata.put("religion_reqd_yn",religion_reqd_yn);
				tabdata.put("pat_category_reqd_yn",patientcategory_reqd_yn); //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
				tabdata.put("town_reqd_yn",town_reqd_yn); //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
				tabdata.put("pat_ser_access_by_user_yn",pat_ser_access_by_user_yn);//added for MO-CRF-20074
				tabdata.put("upt_contact_dtls_oa_yn",upt_contact_dtls_oa_yn);//added changes for HSA-CRF-0226 [IN:050599]
				tabdata.put("upd_pat_dtls_referral_yn",upd_pat_dtls_referral_yn);//Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 8th 2016
				tabdata.put("disp_cancel_prev_enc_yn",disp_cancelled_previous_enc_yn); 

				/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
				tabdata.put("alt_id2_accept_oth_pat_ser_yn",alt_id2_accept_oth_pat_ser_yn);
				tabdata.put("alt_id2_chng_allowed_yn",alt_id2_chng_allowed_yn);
				tabdata.put("alt_id2_accept_alphanumeric_yn",alt_id2_accept_alphanumeric_yn);

				tabdata.put("alt_id3_accept_oth_pat_ser_yn",alt_id3_accept_oth_pat_ser_yn);
				tabdata.put("alt_id3_chng_allowed_yn",alt_id3_chng_allowed_yn);
				tabdata.put("alt_id3_accept_alphanumeric_yn",alt_id3_accept_alphanumeric_yn);

				tabdata.put("alt_id4_accept_oth_pat_ser_yn",alt_id4_accept_oth_pat_ser_yn);
				tabdata.put("alt_id4_chng_allowed_yn",alt_id4_chng_allowed_yn);
				tabdata.put("alt_id4_accept_alphanumeric_yn",alt_id4_accept_alphanumeric_yn);
				/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

				/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 Start */
				tabdata.put("alt_id1_alphanum_validate_yn",alt_id1_alphanum_validate_yn);
				tabdata.put("alt_id2_alphanum_validate_yn",alt_id2_alphanum_validate_yn);
				tabdata.put("alt_id3_alphanum_validate_yn",alt_id3_alphanum_validate_yn);
				tabdata.put("alt_id4_alphanum_validate_yn",alt_id4_alphanum_validate_yn);
				/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 End */
                //added by prithivi on 10/05/2017 for kdah-crf-0362
				tabdata.put("aadhar_config_enabled_yn",aadhar_config_enabled_yn);
				tabdata.put("aadhar_option_value",aadhar_option_value);

				//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
				tabdata.put("name_dervn_logic_nb",name_dervn_logic_nb);
				//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
				tabdata.put("name_dervn_logic_nb_sb",name_dervn_logic_nb_sb);
			
				
				// <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 U1 Starts-->
				tabdata.put("BIOMETRIC_AUTHENTICATION_YN",biometric_authentication);
				// <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 U1 ends-->

				//Added by Rajkumar  for GHL-CRF-0686
				tabdata.put("UNMASK_AADHAR_NO",unmask_aadhaar_num_yn);
				tabdata.put("UNMASK_ABHA_NO_ADDRESS",unmask_abha_num_addr_yn);
				
				tabdata.put("marital_status_reqd_yn",marital_status_reqd_yn);//Added for NMC-JD-CRF-0236
				tabdata.put("occupation_reqd_yn",occupation_reqd_yn);//Added for NMC-JD-CRF-0236
				tabdata.put("mand_visit_admssn_reg_yn",mand_visit_admssn_reg_yn);//Added for NMC-JD-CRF-0236
				
				//Added by Santhosh for GHL-CRF-0686.3
				tabdata.put("abha_eng_audio_path",abha_eng_audio_path);
				tabdata.put("abha_hin_audio_path",abha_hin_audio_path);
				//End
				//Added by Jeyachitra against ML-MMOH-CRF-1759.1-US001
				 tabdata.put("mand_parity_newborn_yn",mand_parity_newborn_yn);
	             tabdata.put("mand_parity_newborn_ip_yn",mand_parity_newborn_ip_yn);
	             tabdata.put("mand_parity_newborn_ae_yn",mand_parity_newborn_ae_yn);
	             tabdata.put("invoke_menstrual_history_yn", invoke_menstrual_history_yn);
				//ML-MMOH-CRF-1759.1-US001 ends


			boolean local_ejbs = isLocalEJB();

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			 Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = dupflds;
			argArray[3] = "MP_PARAM";

            Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass();
			paramArray[1] = tabdata.getClass();
			paramArray[2] = dupflds.getClass();
			paramArray[3] = String.class;

			java.util.HashMap results = (java.util.HashMap)(busObj.getClass().getMethod("insert",paramArray)).invoke(busObj,argArray);


			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);


			boolean inserted = ( ((Boolean) results.get( "status" )).booleanValue() ) ;

			String error = (String) results.get("error") ;

			String error_value = "0" ;
			tabdata.clear();
			results.clear();
			if ( inserted )
			{
			error_value = "1" ;
			res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num=" + java.net.URLEncoder.encode( error, "UTF-8") + "&err_value=" + error_value );
			}

       }catch(Exception ee)
		{
			ee.printStackTrace();
		}
    }

    private void updateMpParam(HttpServletResponse res) {
        try {
					HashMap tabdata=new HashMap();
					HashMap condflds=new HashMap();
				tabdata.put("gen_pat_ser_grp",gen_pat_ser_grp) ;
                tabdata.put("nat_id_pat_ser_grp",nat_id_pat_ser_grp);
                tabdata.put("alt_id_pat_ser_grp",alt_id_pat_ser_grp);
                tabdata.put("dflt_pat_ser_grp_type",dflt_pat_ser_grp_type);
                tabdata.put("single_or_multi_files_ind",single_or_multi_files_ind);
                tabdata.put("separate_file_no_yn",separate_file_no_yn);
                tabdata.put("citizen_nationality_code",citizen_nationality_code);
                tabdata.put("nb_dflt_relnship_code",default_relationship_code);
                tabdata.put("default_race_code",default_race_code);
                tabdata.put("general_alert_yn",general_alert_yn);
                tabdata.put("suspend_service_yn",suspend_service_yn);
				tabdata.put("name_prefix_prompt",name_prefix_prompt);
				tabdata.put("name_prefix_loc_lang_prompt",name_prefix_loc_lang_prompt);
                tabdata.put("first_name_prompt",first_name_prompt);
				tabdata.put("first_name_loc_lang_prompt",first_name_loc_lang_prompt);
                tabdata.put("second_name_prompt",second_name_prompt);
				tabdata.put("second_name_loc_lang_prompt",second_name_loc_lang_prompt);
                tabdata.put("third_name_prompt",third_name_prompt);
				tabdata.put("third_name_loc_lang_prompt",third_name_loc_lang_prompt);
                tabdata.put("family_name_prompt",family_name_prompt);
				tabdata.put("family_name_loc_lang_prompt",family_name_loc_lang_prompt);
                tabdata.put("name_suffix_prompt",name_suffix_prompt);
				tabdata.put("name_suffix_loc_lang_prompt",name_suffix_loc_lang_prompt);
                tabdata.put("dflt_sndx_type",dflt_sndx_type);
				tabdata.put("create_file_at_pat_regn_yn",create_file_at_pat_regn_yn);
				tabdata.put("create_file_at_admission",create_file_at_admission);
				tabdata.put("create_file_at_reg_visit_yn",create_file_at_reg_visit_yn);
				tabdata.put("create_file_at_reg_att_yn",create_file_at_reg_att_yn);
				tabdata.put("create_file_at_dc_admission_yn",create_file_at_dc_admission_yn);
				tabdata.put("file_type_appl_yn",file_type_appl_yn);
				tabdata.put("alt_id1_exp_warn_yn",d_alt_id1_exp_warn_yn);
                tabdata.put("alt_id1_exp_grace_days",alt_id1_exp_grace_days);
				tabdata.put("alt_id2_exp_warn_yn",d_alt_id2_exp_warn_yn);
                tabdata.put("alt_id2_exp_grace_days",alt_id2_exp_grace_days);
				tabdata.put("alt_id3_exp_warn_yn",d_alt_id3_exp_warn_yn);
                tabdata.put("alt_id3_exp_grace_days",alt_id3_exp_grace_days);
				tabdata.put("alt_id4_exp_warn_yn",d_alt_id4_exp_warn_yn);
                tabdata.put("alt_id4_exp_grace_days",alt_id4_exp_grace_days);
				tabdata.put("alt_id1_adv_alert_reqd_yn",alt_id1_adv_alert_reqd_yn);
                tabdata.put("alt_id1_adv_alert_days",alt_id1_adv_alert_days);
                tabdata.put("alt_id2_adv_alert_reqd_yn",alt_id2_adv_alert_reqd_yn);
                tabdata.put("alt_id2_adv_alert_days",alt_id2_adv_alert_days );
                tabdata.put("alt_id3_adv_alert_reqd_yn",alt_id3_adv_alert_reqd_yn);
                tabdata.put("alt_id3_adv_alert_days",alt_id3_adv_alert_days);
                tabdata.put("alt_id4_adv_alert_reqd_yn",alt_id4_adv_alert_reqd_yn);
                tabdata.put("alt_id4_adv_alert_days",alt_id4_adv_alert_days );
                tabdata.put("entitlement_by_pat_cat_yn",entitlement_by_pat_cat_yn);
                tabdata.put("family_org_id_accept_yn",family_org_id_accept_yn);
                tabdata.put("mapped_alt_id_org_member_id",mapped_alt_id_org_member_id);
                tabdata.put("org_member_relationship_code",org_member_relationship_code);
				tabdata.put("dflt_alt_id1_in_emp_id_yn",dflt_alt_id1_in_emp_id_yn);
				tabdata.put("acpt_appt_rfrl_in_reg_pat_yn ",acpt_appt_rfrl_in_reg_pat_yn);
                tabdata.put("name_dervn_logic_oth_lang",name_dervn_logic_oth_lang );
				tabdata.put("name_dervn_logic",name_dervn_logic);
                tabdata.put("dflt_patient_name",dflt_patient_name );
				tabdata.put("dft_national_id",dft_national_id );
			    tabdata.put("id_card_title",id_card_title);
				tabdata.put("ext_system_interface_yn",ext_system_interface_yn);
				tabdata.put("nb_min_gest_bet_2_dely",gestation_two_del );
                tabdata.put("line1_face_sheet_text",line1_face_sheet_text);
                tabdata.put("line2_face_sheet_text",line2_face_sheet_text);
                tabdata.put("line3_face_sheet_text",line3_face_sheet_text);
                tabdata.put("line4_face_sheet_text",line4_face_sheet_text);
                tabdata.put("line5_face_sheet_text",line5_face_sheet_text);
                tabdata.put("line6_face_sheet_text",line6_face_sheet_text);
                tabdata.put("line7_face_sheet_text",line7_face_sheet_text);
                tabdata.put("line8_face_sheet_text",line8_face_sheet_text);
                tabdata.put("line9_face_sheet_text",line9_face_sheet_text);
                tabdata.put("line10_face_sheet_text",line10_face_sheet_text);
                tabdata.put("names_in_oth_lang_yn",name_in_oth_lang_yn);
				tabdata.put("gen_slno_unknown_pat_yn",gen_slno_unknown_pat_yn);
                tabdata.put("modified_at_ws_no",ws_no);
                tabdata.put("modified_date",new java.sql.Timestamp(System.currentTimeMillis()));
                tabdata.put("modified_by_id",uid);
                tabdata.put("modified_facility_id",facility_id);
                tabdata.put("emeg_pat_ser_grp",emeg_pat_ser_grp);
                tabdata.put("newborn_pat_ser_grp",newborn_pat_ser_grp);
                tabdata.put("allow_nb_regn_within_days",allow_nb_regn_within_days);
                tabdata.put("name_suffix_male_nb",name_suffix_male_nb);
                tabdata.put("name_suffix_female_nb",name_suffix_female_nb);
                tabdata.put("unit_of_wt_nb",unit_of_wt_nb);
                tabdata.put("unit_of_circum_nb",unit_of_circum_nb);
                tabdata.put("unit_of_length_nb",unit_of_length_nb);
                tabdata.put("unit_of_gest_nb", unit_of_gest_nb);//Added for HSA-SCF-0057 [IN:050095] By Dharma. July 10,2014
                tabdata.put("sub_multi_birth_hw",sub_multi_birth_hw);
				tabdata.put("unit_of_chest_circum_nb",unit_of_chest_circum_nb);
                tabdata.put("review_nb_links_bef_reg_yn",review_nb_links_bef_reg_yn);
				//Added by kamatchi s for ML-MMOH-CRF-2095
                tabdata.put("length_of_baby_yn",length_of_baby_yn);
                tabdata.put("head_circumference_of_baby_yn",head_circumference_of_baby_yn);
				tabdata.put("allow_ext_nb_regn_within_days",allow_ext_nb_regn_within_days);
				//Added by kamatchi s for ML-MMOH-CRF-1757
				tabdata.put("mandate_first_newborn_yn",mandate_first_newborn_yn);
                tabdata.put("mandate_first_newborn_ip_yn",mandate_first_newborn_ip_yn);
                tabdata.put("mandate_first_newborn_ae_yn",mandate_first_newborn_ae_yn);
                tabdata.put("mandate_second_newborn_yn",mandate_second_newborn_yn);
                tabdata.put("mandate_second_newborn_ip_yn",mandate_second_newborn_ip_yn);
                tabdata.put("mandate_second_newborn_ae_yn",mandate_second_newborn_ae_yn);
                tabdata.put("mandate_third_newborn_yn",mandate_third_newborn_yn);
                tabdata.put("mandate_third_newborn_ip_yn",mandate_third_newborn_ip_yn);
                tabdata.put("mandate_third_newborn_ae_yn",mandate_third_newborn_ae_yn);
                tabdata.put("mand_antenatal_newborn_yn",mand_antenatal_newborn_yn);
                tabdata.put("mand_antenatal_newborn_ip_yn",mand_antenatal_newborn_ip_yn);
                tabdata.put("mand_antenatal_newborn_ae_yn",mand_antenatal_newborn_ae_yn);

				//added by kamatchi s for ML-MMOH-CRF-2097
                tabdata.put("enable_marital_status",enable_marital_status);
                tabdata.put("dflt_father_first_name_prompt",dflt_father_first_name_prompt);
                tabdata.put("dflt_father_Second_name_prompt",dflt_father_Second_name_prompt);
                tabdata.put("dflt_father_third_name_prompt",dflt_father_third_name_prompt);
                tabdata.put("dflt_father_family_name_prompt",dflt_father_family_name_prompt);

                tabdata.put("single_stage_nb_reg_appl_yn",single_stage_nb_reg_appl_yn);
                tabdata.put("mod_birth_reg_appl_yn",mod_birth_reg_appl_yn);
               // tabdata.put("invoke_chg_pat_dtls_fm_nb_yn",invoke_chg_pat_dtls_fm_nb_yn);
                
				//Added By Gaurav Aginst MMS-MEA-CRF-0004
				tabdata.put("start_id_with",start_id_with); 
				tabdata.put("alt_id1_start_with",alt_id1_start_with); 
				tabdata.put("alt_id2_start_with",alt_id2_start_with); 
				tabdata.put("alt_id3_start_with",alt_id3_start_with); 
				tabdata.put("alt_id4_start_with",alt_id4_start_with); 
				//Added By Gaurav Aginst MMS-MEA-CRF-0004
				
				tabdata.put("nat_id_prompt",nat_id_prompt );
                tabdata.put("nat_id_reqd_all_series",nat_id_reqd_all_series);
                tabdata.put("nb_mother_min_age",nb_mother_min_age );
				tabdata.put("nb_mother_upper_age",nb_mother_upper_age );
				tabdata.put("nb_mother_cutoff_age",nb_mother_cutoff_age );
				tabdata.put("allow_nb_regn_unit",allow_nb_regn_unit );
				tabdata.put("max_multiple_birth_regn_hrs",mul_birth_regn_within_hours);
				tabdata.put("nb_male_relnship",nb_male_relnship );
				tabdata.put("nb_female_relnship",nb_female_relnship );
				tabdata.put("nb_unknown_relnship",nb_unknown_relnship );
				tabdata.put("nb_father_min_age",nb_father_min_age );
                tabdata.put("nb_use_mother_ser",nb_use_mother_ser );
                tabdata.put("name_prefix_male_nb", name_prefix_male_nb);
                tabdata.put("name_prefix_female_nb",name_prefix_female_nb);
                tabdata.put("name_prefix_unknown_nb",name_prefix_unknown_nb); //Added by Afruddin for ML-MMOH-CRF-1520 US001 on 4.05.2020
				tabdata.put("nb_father_name_mandatory_yn",nb_father_name_mandatory_yn);
				tabdata.put("nb_mother_dtls_update_yn",nb_mother_dtls_update_yn);//Added for HSA-CRF-0182
                tabdata.put("data_upd_allowed_aft_final_yn",data_upd_allowed_aft_final_yn);
                tabdata.put("accept_names_for_live_birth_yn",accept_names_for_live_birth_yn);
                tabdata.put("dflt_race_nat_setup_nb_as_per",dflt_race_nat_setup_nb_as_per);
				
				/*Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/
				tabdata.put("alt_id1_pat_sch_exact_yn",alt_id1_pat_sch_exact_yn);
				tabdata.put("alt_id2_pat_sch_exact_yn",alt_id2_pat_sch_exact_yn);
				tabdata.put("alt_id3_pat_sch_exact_yn",alt_id3_pat_sch_exact_yn);
				tabdata.put("alt_id4_pat_sch_exact_yn",alt_id4_pat_sch_exact_yn);



                tabdata.put("id_change_allowed_for_series",id_change_allowed_for_series );
                tabdata.put("alt_id1_chk_digit_scheme",alt_id1_chk_digit_scheme);
                tabdata.put("alt_id2_chk_digit_scheme",alt_id2_chk_digit_scheme);
                tabdata.put("alt_id3_chk_digit_scheme",alt_id3_chk_digit_scheme);
                tabdata.put("alt_id4_chk_digit_scheme",alt_id4_chk_digit_scheme);
				tabdata.put("addl_field1_prompt",addl_field1_prompt);
                tabdata.put("addl_field1_length",addl_field1_length);
                tabdata.put("addl_field1_section",addl_field1_section );
                tabdata.put("addl_field2_prompt",addl_field2_prompt);
                tabdata.put("addl_field2_length",addl_field2_length);
                tabdata.put("addl_field2_section",addl_field2_section );
                tabdata.put("addl_field3_prompt",addl_field3_prompt);
                tabdata.put("addl_field3_length",addl_field3_length);
                tabdata.put("addl_field3_section",addl_field3_section );
                tabdata.put("addl_field4_prompt",addl_field4_prompt);
                tabdata.put("addl_field4_length",addl_field4_length);
                tabdata.put("addl_field4_section",addl_field4_section );
                tabdata.put("addl_field5_prompt",addl_field5_prompt);
                tabdata.put("addl_field5_length",addl_field5_length);
                tabdata.put("addl_field5_section",addl_field5_section );
				tabdata.put("max_patient_age",max_pat_age);
				if(isUHID_valid_appl) //  Added by mujafar for AMRI-CRF-0357
				tabdata.put("UHID_VALID_DAYS",no_days_UHID_valid);
			
				tabdata.put("min_weight",min_weight);
				tabdata.put("max_weight",max_weight);
				tabdata.put("min_length",min_length);
				tabdata.put("max_length",max_length);
				tabdata.put("min_head_circum",min_head_circum);
				tabdata.put("max_head_circum",max_head_circum);
				tabdata.put("min_chest_circum",min_chest_circum);
				tabdata.put("max_chest_circum",max_chest_circum);
				tabdata.put("min_gestation",min_gestation);
				tabdata.put("max_gestation",max_gestation);
				tabdata.put("maintain_doc_or_file",maintain_doc_or_file);
                tabdata.put("display_new_born_age_in_hrs", display_new_born_age_in_hrs);
				tabdata.put("name_prefix_length",name_prefix_length);
				tabdata.put("first_name_length",first_name_length);
				tabdata.put("second_name_length",second_name_length);
				tabdata.put("third_name_length",third_name_length);
				tabdata.put("family_name_length",family_name_length);
				tabdata.put("name_suffix_length",name_suffix_length);
				tabdata.put("alt_id1_chng_allowed_yn",alt_id1_chng_allowed_yn);
				tabdata.put("accept_pw_in_chng_pat_dtl_yn",accept_pw_in_chng_pat_dtl_yn);
              tabdata.put(" single_patient_numbering_yn", single_patient_numbering_yn);
				tabdata.put("dflt_language_id",dflt_language_id);
				tabdata.put("dflt_relgn_code",dflt_relgn_code);
				tabdata.put("inv_pat_search_in_reg_pat_yn",inv_pat_search_in_reg_pat_yn);
				//tabdata.put("alt_id1_rule_in_gen_pat_id_yn",alt_id1_rule_in_gen_pat_id_yn);
				tabdata.put("name_pfx_reqd_for_org_mem_yn",name_pfx_reqd_for_org_mem_yn);
				tabdata.put("gen_pid_using_aid1_rule_yn",gen_patid_using_altid_rl_yn);
//				tabdata.put("relationship_level_length",relationship_level_length);
				tabdata.put("age_not_consider_natid", age_not_consider_natid); //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
				tabdata.put("age_not_consider_natid_altid", age_not_consider_natid_altid);//Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]

				tabdata.put("nat_id_accept_alphanumeric_yn",nat_id_accept_alphanumeric_yn);
				tabdata.put("create_file_yn",create_file_yn);
				tabdata.put("race_required_yn",race_required_yn);
				tabdata.put("round_dob_estd_age",round_dob_estd_age);
				tabdata.put("still_born_prefix",still_born_prefix);
				tabdata.put("pat_photo_renewal_alert_days",pat_photo_renewal_alert_days);
				tabdata.put("NAME_DERVN_LOGIC_LONG",long_name_dervn_logic);
				tabdata.put("NAME_DERVN_LOGIC_OTH_LANG_LONG",long_name_dervn_logic_local);
				tabdata.put("PAT_SEARCH_DFLT_TAB",pat_search_tab);
				//Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
				//Start
				tabdata.put("CANCEL_ONLY_FOR_MO_PATIENTS_YN",mortuary_release_yn);
				tabdata.put("CANCEL_CUT_OFF_PERIOD_IN_DAYS",no_days_before_deceased);
				tabdata.put("cancel_reason_code",cancel_reason_code);
				//End
				// New parameter  is added against GHL-CRF-0312 [IN:039856] by Saanthaakumar
				tabdata.put("country_reqd_yn",country_reqd_yn);
				tabdata.put("region_reqd_yn",region_reqd_yn);
				tabdata.put("mobile_no_reqd_yn",mobile_no_reqd_yn);
				//Ends here
				//// New parameter Added  against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
				tabdata.put("email_id_reqd_yn",email_id_reqd_yn);
					//// New parameter Added  against AMRI-CRF-0388  By shagar
				tabdata.put("postal_cd_reqd_yn",postal_cd_reqd_yn);
				tabdata.put("area_reqd_yn",area_reqd_yn);
				//New Parameter Added against ML-MMOH-CRF-0736 by Mano
				tabdata.put("religion_reqd_yn",religion_reqd_yn);
				tabdata.put("pat_category_reqd_yn",patientcategory_reqd_yn); //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
				tabdata.put("town_reqd_yn",town_reqd_yn); //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
				tabdata.put("pat_ser_access_by_user_yn",pat_ser_access_by_user_yn);//added MO-CRF-20074
			    tabdata.put("upt_contact_dtls_oa_yn",upt_contact_dtls_oa_yn);//added changes for HSA-CRF-0226 [IN:050599]
				tabdata.put("upd_pat_dtls_referral_yn",upd_pat_dtls_referral_yn);//Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 8th 2016
                tabdata.put("disp_cancel_prev_enc_yn",disp_cancelled_previous_enc_yn);
				/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
				tabdata.put("alt_id2_accept_oth_pat_ser_yn",alt_id2_accept_oth_pat_ser_yn);
				tabdata.put("alt_id2_chng_allowed_yn",alt_id2_chng_allowed_yn);
				tabdata.put("alt_id2_accept_alphanumeric_yn",alt_id2_accept_alphanumeric_yn);

				tabdata.put("alt_id3_accept_oth_pat_ser_yn",alt_id3_accept_oth_pat_ser_yn);
				tabdata.put("alt_id3_chng_allowed_yn",alt_id3_chng_allowed_yn);
				tabdata.put("alt_id3_accept_alphanumeric_yn",alt_id3_accept_alphanumeric_yn);

				tabdata.put("alt_id4_accept_oth_pat_ser_yn",alt_id4_accept_oth_pat_ser_yn);
				tabdata.put("alt_id4_chng_allowed_yn",alt_id4_chng_allowed_yn);
				tabdata.put("alt_id4_accept_alphanumeric_yn",alt_id4_accept_alphanumeric_yn);
				/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

				/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 Start */
				tabdata.put("alt_id1_alphanum_validate_yn",alt_id1_alphanum_validate_yn);
				tabdata.put("alt_id2_alphanum_validate_yn",alt_id2_alphanum_validate_yn);
				tabdata.put("alt_id3_alphanum_validate_yn",alt_id3_alphanum_validate_yn);
				tabdata.put("alt_id4_alphanum_validate_yn",alt_id4_alphanum_validate_yn);
				/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 End */

				//added by prithivi on 10/05/2017 for kdah-crf-0362
				tabdata.put("aadhar_config_enabled_yn",aadhar_config_enabled_yn);
				tabdata.put("aadhar_option_value",aadhar_option_value);

				//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
				tabdata.put("name_dervn_logic_nb",name_dervn_logic_nb);
				//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
				tabdata.put("name_dervn_logic_nb_sb",name_dervn_logic_nb_sb);
				tabdata.put("ENBL_DEATH_REG_FORM_DECEASED",death_reg_form_req_yn);//Added for AAKH-CRF-0179 by Ajay Hatwate on 23-08-2023
				// <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 U1 Starts-->
				tabdata.put("BIOMETRIC_AUTHENTICATION_YN",biometric_authentication);
				// <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 U1 ends-->
				
				//Added by Rajkumar  for GHL-CRF-0686
				tabdata.put("UNMASK_AADHAR_NO",unmask_aadhaar_num_yn);
				tabdata.put("UNMASK_ABHA_NO_ADDRESS",unmask_abha_num_addr_yn);
				
				tabdata.put("marital_status_reqd_yn",marital_status_reqd_yn);//Added for NMC-JD-CRF-0236
				tabdata.put("occupation_reqd_yn",occupation_reqd_yn);//Added for NMC-JD-CRF-0236
				tabdata.put("mand_visit_admssn_reg_yn",mand_visit_admssn_reg_yn);//Added for NMC-JD-CRF-0236

				//Added by Santhosh for GHL-CRF-0686.3
				tabdata.put("abha_eng_audio_path",abha_eng_audio_path);
				tabdata.put("abha_hin_audio_path",abha_hin_audio_path);
				//End
				
				//Added by Jeyachitra against ML-MMOH-CRF-1759.1-US001
				tabdata.put("mand_parity_newborn_yn",mand_parity_newborn_yn);
	            tabdata.put("mand_parity_newborn_ip_yn",mand_parity_newborn_ip_yn);
	            tabdata.put("mand_parity_newborn_ae_yn",mand_parity_newborn_ae_yn);
	            tabdata.put("invoke_menstrual_history_yn", invoke_menstrual_history_yn);
	            //ML-MMOH-CRF-1759.1-US001 ends

				System.err.println("disp_cancelled_previous_enc_yn==>"+disp_cancelled_previous_enc_yn);
			boolean local_ejbs = isLocalEJB();
			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/SingleTabHandler",SingleTabHandlerManagerHome.class,local_ejbs);
			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);
			Object argArray[] = new Object[4];
			argArray[0] = p;
			argArray[1] = tabdata;
			argArray[2] = condflds;
			argArray[3] = "MP_PARAM";
			Class [] paramArray = new Class[4];
			paramArray[0] = p.getClass(); ;
			paramArray[1] = tabdata.getClass();
			paramArray[2] = condflds.getClass();
			paramArray[3] = String.class;
			java.util.HashMap results = (HashMap)(busObj.getClass().getMethod("update",paramArray)).invoke(busObj,argArray);
			(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				String error = (String) (results.get("error")==null?"Error":results.get("error")) ;
				tabdata.clear(); condflds.clear(); results.clear();
				res.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="+java.net.URLEncoder.encode( error , "UTF-8")+"&err_value=1");
		} catch ( Exception e ) { e.printStackTrace(); }
    }
	boolean isLocalEJB() {
		ServletContext context = getServletConfig().getServletContext();
		if((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
			return true;
		else return false;
	}
}
