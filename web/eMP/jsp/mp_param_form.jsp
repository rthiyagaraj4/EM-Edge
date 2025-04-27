<!DOCTYPE html>


<!-- Last Modified Date Time : 9/13/2006 1:48 PM -->

<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*,eXH.InterfaceUtil,eCommon.XSSRequestWrapper"  %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../js/mp_param.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null ;
    PreparedStatement pstmt=null ;
    ResultSet rs=null ;
    PreparedStatement pstmt1=null ;
    ResultSet rs1=null ;
    java.sql.Statement stmt11 = null;
    ResultSet rset11 = null;
    java.sql.Statement stmt = null ;
    ResultSet rset = null;
	PreparedStatement pst=null;
	PreparedStatement pst1=null;
	ResultSet res=null;
	ResultSet res1=null;
	
	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 Starts-->
	PreparedStatement pstmt_rh=null ;
	ResultSet rs_rh=null;
	String function_name="";
	//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175 US1 ends-->

	int count=0;
	
	String enabledisable = "disabled" ;
	
	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
	Boolean isNameDervnLogicNBAppl = false;
	Boolean isStartWith = false; 

	try
	{
    con = ConnectionManager.getConnection(request);

	Boolean isUHID_valid_appl = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","UHID_VALID_DAYS_APPL"); // Added by mujafar for AMRI-CRF-0357

	isStartWith = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_START_WITH"); 
	isNameDervnLogicNBAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","NEWBORN_NAME_DERV_LOGIC");
	Boolean mpDisableFieldsNBFather = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_DISABLE_FIELDS_NB_FATHER");
	String name_dervn_logic_nb = "";
		boolean isNatIdAltIdMandVisaType	= eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_VAL_VISA_TYPE");	//Maheshwaran added for AAKH-CRF-0145 as on 22-04-2022
	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
	String name_dervn_logic_nb_sb = "";
	
	String dflt_alt_id1_in_emp_id_yn     =  checkForNull(request.getParameter("dflt_alt_id1_in_emp_id_yn")); 
	String accept_pw_in_chng_pat_dtl_yn     =  checkForNull(request.getParameter("accept_pw_in_chng_pat_dtl_yn")); 
	String acpt_appt_rfrl_in_reg_pat_yn  =  checkForNull(request.getParameter("acpt_appt_rfrl_in_reg_pat_yn"));
	String module_id                     =  checkForNull(request.getParameter( "module_id"            )) ;
    String patient_id_length             =  checkForNull(request.getParameter( "patient_id_length"        ));
    String patient_no_ctrl               =  checkForNull(request.getParameter( "patient_no_ctrl"      ));

	String gen_pat_ser_grp               =  checkForNull(request.getParameter( "gen_pat_ser_grp"      ));
    String nat_id_pat_ser_grp            =  checkForNull(request.getParameter( "nat_id_pat_ser_grp"       ));
    String alt_id_pat_ser_grp            =  checkForNull(request.getParameter( "alt_id_pat_ser_grp"       )) ;
    String family_no_pat_ser_grp         =  checkForNull(request.getParameter( "family_no_pat_ser_grp"    ));
    String dflt_pat_ser_grp_type         =  checkForNull(request.getParameter( "dflt_pat_ser_grp_type"    ));
    String emeg_pat_ser_grp              =  checkForNull(request.getParameter( "emeg_pat_ser_grp"         ));
    String newborn_pat_ser_grp           =  checkForNull(request.getParameter( "newborn_pat_ser_grp"      ));
    String nat_id_length                 =  checkForNull(request.getParameter( "nat_id_length"            ));
    String name_dervn_logic              =  checkForNull(request.getParameter( "name_dervn_logic"         ));
    String name_dervn_logic_oth_lang     =  checkForNull(request.getParameter( "name_dervn_logic_oth_lang"         ));

	String name_dervn_logic_long              =  checkForNull(request.getParameter( "name_dervn_logic_long"         ));
    String name_dervn_logic_oth_lang_long     =  checkForNull(request.getParameter( "name_dervn_logic_oth_lang_long"         ));

    String dflt_patient_name     =  checkForNull(request.getParameter( "dflt_patient_name"         ));
    String ethnic_sndx_type              =  checkForNull(request.getParameter( "ethnic_sndx_type"         ));
    String family_no_link_yn             =  checkForNull(request.getParameter( "family_no_link_yn"        ));
    String head_patient_no_use_yn        =  checkForNull(request.getParameter( "head_patient_no_use_yn"   ));
    String family_org_id_accept_yn       =  checkForNull(request.getParameter( "family_org_id_accept_yn"  ));
    String citizen_nationality_code      =  checkForNull(request.getParameter( "citizen_nationality_code"     ));
    String default_race_code		     =  checkForNull(request.getParameter( "default_race_code"     ));
	
    String default_relationship_code		     =  checkForNull(request.getParameter( "default_relationship_code"     ));
    String general_alert_yn              =  checkForNull(request.getParameter( "general_alert_yn"         ));
    String suspend_service_yn            =  checkForNull(request.getParameter( "suspend_service_yn"       ));
    String single_or_multi_files_ind     =  checkForNull(request.getParameter( "single_or_multi_files_ind"    ));
    String separate_file_no_yn           =  checkForNull(request.getParameter( "separate_file_no_yn"      ));
    String ext_system_interface_yn       =  checkForNull(request.getParameter( "ext_system_interface_yn"  ));
	if(ext_system_interface_yn==null || ext_system_interface_yn=="")
    ext_system_interface_yn="N";
    String name_prefix_accept_yn         =  checkForNull(request.getParameter( "name_prefix_accept_yn"    ));
    String name_prefix_reqd_yn           =  checkForNull(request.getParameter( "name_prefix_reqd_yn"      ));
    String name_prefix_prompt            =  checkForNull(request.getParameter( "name_prefix_prompt"       ));
    String name_prefix_loc_lang_prompt   =  checkForNull(request.getParameter( "name_prefix_loc_lang_prompt" ));
    String first_name_accept_yn          =  checkForNull(request.getParameter( "first_name_accept_yn"     ));
    String first_name_reqd_yn            =  checkForNull(request.getParameter( "first_name_reqd_yn"       ));
    String first_name_order              =  checkForNull(request.getParameter( "first_name_order"         ));
    String first_name_prompt             =  checkForNull(request.getParameter( "first_name_prompt"        ));
    String first_name_loc_lang_prompt    =  checkForNull(request.getParameter( "first_name_loc_lang_prompt"  ));
    String second_name_accept_yn         =  checkForNull(request.getParameter( "second_name_accept_yn"    ));
    String second_name_reqd_yn           =  checkForNull(request.getParameter( "second_name_reqd_yn"      ));
    String second_name_order             =  checkForNull(request.getParameter( "second_name_order"        ));
    String second_name_prompt            =  checkForNull(request.getParameter( "second_name_prompt"       ));
    String second_name_loc_lang_prompt   =  checkForNull(request.getParameter( "second_name_loc_lang_prompt"       ));
	String pat_name_as_multipart_yn		 =  checkForNull(request.getParameter("pat_name_as_multipart_yn"));
	String third_name_accept_yn          =  checkForNull(request.getParameter( "third_name_accept_yn"     ));
    String third_name_reqd_yn            =  checkForNull(request.getParameter( "third_name_reqd_yn"       ));
    String third_name_order              =  checkForNull(request.getParameter( "third_name_order"         ));
    String third_name_prompt             =  checkForNull(request.getParameter( "third_name_prompt"        ));
    String third_name_loc_lang_prompt    =  checkForNull(request.getParameter( "third_name_loc_lang_prompt"  ));
    String family_name_accept_yn         =  checkForNull(request.getParameter( "family_name_accept_yn"    ));
    String family_name_reqd_yn           =  checkForNull(request.getParameter( "family_name_reqd_yn"      ));
    String family_name_order             =  checkForNull(request.getParameter( "family_name_order"        ));
    String family_name_prompt            =  checkForNull(request.getParameter( "family_name_prompt"       ));
    String family_name_loc_lang_prompt   =  checkForNull(request.getParameter( "family_name_loc_lang_prompt"));
    String family_name_prefix_yn         =  checkForNull(request.getParameter( "family_name_prefix_yn"    ));
    String name_suffix_accept_yn         =  checkForNull(request.getParameter( "name_suffix_accept_yn"    ));
    String name_suffix_reqd_yn           =  checkForNull(request.getParameter( "name_suffix_reqd_yn"      ));
    String name_suffix_prompt            =  checkForNull(request.getParameter( "name_suffix_prompt"       ));
    String name_suffix_loc_lang_prompt   =  checkForNull(request.getParameter( "name_suffix_loc_lang_prompt" ));
    String names_in_oth_lang_yn          =  checkForNull(request.getParameter( "names_in_oth_lang_yn"     ));
    String dflt_sndx_type                =  checkForNull(request.getParameter( "dflt_sndx_type"           ));
    String dflt_coded_pseudo_name        =  checkForNull(request.getParameter( "dflt_coded_pseudo_name"   ));
    String alt_id1_type                  =  checkForNull(request.getParameter( "alt_id1_type"         ));
    String alt_id1_length                =  checkForNull(request.getParameter( "alt_id1_length"           ));
    String alt_id1_chk_digit_scheme      =  checkForNull(request.getParameter( "alt_id1_chk_digit_scheme" ));
    String alt_id1_reqd_yn               =  checkForNull(request.getParameter( "alt_id1_reqd_yn"      ));
    String alt_id1_unique_yn             =  checkForNull(request.getParameter( "alt_id1_unique_yn"        ));
    String alt_id1_exp_warn_yn           =  checkForNull(request.getParameter( "alt_id1_exp_warn_yn"      ));
    String alt_id1_exp_grace_days        =  checkForNull(request.getParameter( "alt_id1_exp_grace_days"   ));
    String alt_id2_type                  =  checkForNull(request.getParameter( "alt_id2_type"         ));
    String alt_id2_length                =  checkForNull(request.getParameter( "alt_id2_length"           ));
    String alt_id2_chk_digit_scheme      =  checkForNull(request.getParameter( "alt_id2_chk_digit_scheme" ));
    String alt_id2_reqd_yn               =  checkForNull(request.getParameter( "alt_id2_reqd_yn"      ));
    String alt_id2_unique_yn             =  checkForNull(request.getParameter( "alt_id2_unique_yn"        ));
    String alt_id2_exp_warn_yn           =  checkForNull(request.getParameter( "alt_id2_exp_warn_yn"      ));
    String alt_id2_exp_grace_days        =  checkForNull(request.getParameter( "alt_id2_exp_grace_days"));
    String alt_id3_type                  =  checkForNull(request.getParameter( "alt_id3_type"         ));
    String alt_id3_length                =  checkForNull(request.getParameter( "alt_id3_length"           ));
    String alt_id3_chk_digit_scheme      =  checkForNull(request.getParameter( "alt_id3_chk_digit_scheme" ));
    String alt_id3_reqd_yn               =  checkForNull(request.getParameter( "alt_id3_reqd_yn"      ));
    String alt_id3_unique_yn             =  checkForNull(request.getParameter( "alt_id3_unique_yn"        ));
    String alt_id3_exp_warn_yn           =  checkForNull(request.getParameter( "alt_id3_exp_warn_yn"      ));
    String alt_id3_exp_grace_days        =  checkForNull(request.getParameter( "alt_id3_exp_grace_days"   ));
    String alt_id4_type                  =  checkForNull(request.getParameter( "alt_id4_type"         ));
    String alt_id4_length                =  checkForNull(request.getParameter( "alt_id4_length"           ));
    String alt_id4_chk_digit_scheme      =  checkForNull(request.getParameter( "alt_id4_chk_digit_scheme" ));
    String alt_id4_reqd_yn               =  checkForNull(request.getParameter( "alt_id4_reqd_yn"      ));
    String alt_id4_unique_yn             =  checkForNull(request.getParameter( "alt_id4_unique_yn"        ));
    String alt_id4_exp_warn_yn           =  checkForNull(request.getParameter( "alt_id4_exp_warn_yn"      ));
    String alt_id4_exp_grace_days        =  checkForNull(request.getParameter( "alt_id4_exp_grace_days"   ));
    String family_no_prompt              =  checkForNull(request.getParameter( "family_no_prompt"     ));
    String pat_access_hist_no_rec        =  checkForNull(request.getParameter( "pat_access_hist_no_rec"   ));
    String pat_access_hist_bld_method    =  checkForNull(request.getParameter( "pat_access_hist_bld_method"   ));
    String dflt_contact_mode1            =  checkForNull(request.getParameter( "dflt_contact_mode1"       ));
    String dflt_contact_mode2            =  checkForNull(request.getParameter( "dflt_contact_mode2"       ));
    String dflt_contact_mode3            =  checkForNull(request.getParameter( "dflt_contact_mode3"       ));
    String dflt_contact_mode4            =  checkForNull(request.getParameter( "dflt_contact_mode4"       ));
    String dflt_contact_mode5            =  checkForNull(request.getParameter( "dflt_contact_mode5"       ));
    String dflt_addr_type1               =  checkForNull(request.getParameter( "dflt_addr_type1"      ));
    String dflt_addr_type2               =  checkForNull(request.getParameter( "dflt_addr_type2"      ));
    String dflt_addr_type3               =  checkForNull(request.getParameter( "dflt_addr_type3"      ));
    String dflt_addr_type4               =  checkForNull(request.getParameter( "dflt_addr_type4"      ));
    String dflt_addr_type5               =  checkForNull(request.getParameter( "dflt_addr_type5"      ));
    String dflt_rel_contact_role1        =  checkForNull(request.getParameter( "dflt_rel_contact_role1"   ));
    String dflt_rel_contact_role2        =  checkForNull(request.getParameter( "dflt_rel_contact_role2"   ));
    String dflt_rel_contact_role3        =  checkForNull(request.getParameter( "dflt_rel_contact_role3"   ));
    String dflt_rel_contact_role4        =  checkForNull(request.getParameter( "dflt_rel_contact_role4"   ));
    String dflt_rel_contact_role5        =  checkForNull(request.getParameter( "dflt_rel_contact_role5"   ));
    String dflt_doc1_type                =  checkForNull(request.getParameter( "dflt_doc1_type"           ));
    String dflt_doc2_type                =  checkForNull(request.getParameter( "dflt_doc2_type"           ));
    String dflt_doc3_type                =  checkForNull(request.getParameter( "dflt_doc3_type"           ));
    String dflt_doc4_type                =  checkForNull(request.getParameter( "dflt_doc4_type"           ));
    String dflt_doc5_type                =  checkForNull(request.getParameter( "dflt_doc5_type"           ));
    String dflt_pat_fin_class            =  checkForNull(request.getParameter( "dflt_pat_fin_class"       ));
    String prompt_pat_fin_class_yn       =  checkForNull(request.getParameter( "prompt_pat_fin_class_yn"  ));
    String allow_nb_regn_within_days     =  checkForNull(request.getParameter( "allow_nb_regn_within_days"    ));
	String mul_birth_regn_within_hours     =  checkForNull(request.getParameter( "mul_birth_regn_within_hours"    ));
	String min_age_of_moth               =  checkForNull(request.getParameter( "nb_mother_min_age"    ));
   	String max_age_of_moth               =  checkForNull(request.getParameter( "nb_mother_upper_age"    ));
	String cut_age_of_moth               =  checkForNull(request.getParameter( "nb_mother_cutoff_age"    ));
	String dft_rel_male_nb               =  checkForNull(request.getParameter( "nb_male_relnship"    ));
	String dft_rel_female_nb             =  checkForNull(request.getParameter( "nb_female_relnship"    ));
	String dft_rel_unknown_nb            =  checkForNull(request.getParameter( "nb_unknown_relnship"    ));
	String allow_nb_regn_unit            =  checkForNull(request.getParameter( "allow_nb_regn_unit"    ));
	String Accept_oth_alt_id_yn          =  checkForNull(request.getParameter( "Accept_oth_alt_id_yn"    ));
    String min_age_of_fath               =  checkForNull(request.getParameter( "nb_father_min_age"    ));
    String unit_of_wt_nb                 =  checkForNull(request.getParameter( "unit_of_wt_nb"            ));
    String unit_of_circum_nb             =  checkForNull(request.getParameter( "unit_of_circum_nb"        ));
    String unit_of_chest_circum_nb             =  checkForNull(request.getParameter( "unit_of_chest_circum_nb"        ));
    String unit_of_length_nb             =  checkForNull(request.getParameter( "unit_of_length_nb"        ));
    String unit_of_gest_nb               =  checkForNull(request.getParameter( "unit_of_gest_nb" ));
    String sub_multi_birth_hw               =  checkForNull(request.getParameter( "sub_multi_birth_hw" ));
    String name_suffix_male_nb           =  checkForNull(request.getParameter( "name_suffix_male_nb"      ));
    String name_suffix_female_nb         =  checkForNull(request.getParameter( "name_suffix_female_nb"    ));
    String name_prefix_male_nb           =  checkForNull(request.getParameter( "name_prefix_male_nb"      ));  
    String name_prefix_unknown_nb           =  checkForNull(request.getParameter( "name_prefix_unknown_nb"      )); // Added by Afruddin for ML-MMOH-CRF-1520 US001 on 4.05.2020
    String name_prefix_female_nb         =  checkForNull(request.getParameter( "name_prefix_female_nb"    ));
	String still_born_prefix			 = "";
	// New parameter is added for RUT-CRF-0007-MPI (IN023391) on 16.09.2010 by Suresh M
	String pat_photo_renewal_alert_days	= "";

	
	String fatherValue	= "";
	String maritalValue	= "";
	String enable_marital_status    = checkForNull( request.getParameter( "enable_marital_status") ) ;
    String dflt_father_first_name_prompt    = checkForNull( request.getParameter( "dflt_father_first_name_prompt") ) ;
    String dflt_father_Second_name_prompt    = checkForNull( request.getParameter( "dflt_father_Second_name_prompt") ) ;
    String dflt_father_third_name_prompt    = checkForNull( request.getParameter( "dflt_father_third_name_prompt") ) ;
    String dflt_father_family_name_prompt    = checkForNull( request.getParameter( "dflt_father_family_name_prompt") ) ;


	String nb_father_name_mandatory_yn   =  checkForNull(request.getParameter( "nb_father_name_mandatory_yn"    ));
	String nb_mother_dtls_update_yn=checkForNull(request.getParameter( "nb_mother_dtls_update_yn"    ));//Added for HSA-CRF-0182

	/*Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/
	String ALT_ID1_PAT_SCH_EXACT_YN=checkForNull(request.getParameter( "ALT_ID1_PAT_SCH_EXACT_YN"    ));
	String ALT_ID2_PAT_SCH_EXACT_YN=checkForNull(request.getParameter( "ALT_ID2_PAT_SCH_EXACT_YN"    ));
	String ALT_ID3_PAT_SCH_EXACT_YN=checkForNull(request.getParameter( "ALT_ID3_PAT_SCH_EXACT_YN"    ));
	String ALT_ID4_PAT_SCH_EXACT_YN=checkForNull(request.getParameter( "ALT_ID4_PAT_SCH_EXACT_YN"    ));
	

	String data_upd_allowed_aft_final_yn            =  checkForNull(request.getParameter( "data_upd_allowed_aft_final_yn"    ));
	String upt_contact_dtls_oa_yn		 = "";//added  changes   for HSA-CRF-0226 [IN:050599] 
	String accept_names_for_live_birth_yn="";

	String dflt_race_nat_setup_nb_as_per=  checkForNull(request.getParameter( "dflt_race_nat_setup_nb_as_per"    ));

    String review_nb_links_bef_reg_yn    =  checkForNull(request.getParameter( "review_nb_links_bef_reg_yn"   ));

	
	String length_of_baby_yn     = checkForNull( request.getParameter( "length_of_baby_yn") );
	String head_circumference_of_baby_yn     = checkForNull( request.getParameter( "head_circumference_of_baby_yn") );
	
	String mandate_first_newborn_yn = checkForNull( request.getParameter( "mandate_first_newborn_yn") );
	String mandate_first_newborn_ip_yn = checkForNull( request.getParameter( "mandate_first_newborn_ip_yn") );
	String mandate_first_newborn_ae_yn = checkForNull( request.getParameter( "mandate_first_newborn_ae_yn") );
	String mandate_second_newborn_yn = checkForNull( request.getParameter( "mandate_second_newborn_yn") );
	String mandate_second_newborn_ip_yn = checkForNull( request.getParameter( "mandate_second_newborn_ip_yn") );
	String mandate_second_newborn_ae_yn = checkForNull( request.getParameter( "mandate_second_newborn_ae_yn") );
	String mandate_third_newborn_yn = checkForNull( request.getParameter( "mandate_third_newborn_yn") );
	String mandate_third_newborn_ip_yn = checkForNull( request.getParameter( "mandate_third_newborn_ip_yn") );
	String mandate_third_newborn_ae_yn = checkForNull( request.getParameter( "mandate_third_newborn_ae_yn") );
	String mand_antenatal_newborn_yn = checkForNull( request.getParameter( "mand_antenatal_newborn_yn") );
	String mand_antenatal_newborn_ip_yn = checkForNull( request.getParameter( "mand_antenatal_newborn_ip_yn") );
	String mand_antenatal_newborn_ae_yn = checkForNull( request.getParameter( "mand_antenatal_newborn_ae_yn") );
	//Added by Jeyachitra ML-MMOH-CRF-1759.1-US001 starts
	String mand_parity_newborn_yn = checkForNull( request.getParameter( "mand_parity_newborn_yn") );
	String mand_parity_newborn_ip_yn = checkForNull( request.getParameter( "mand_parity_newborn_ip_yn") );
	String mand_parity_newborn_ae_yn = checkForNull( request.getParameter( "mand_parity_newborn_ae_yn") );
	String invoke_menstrual_history_yn = checkForNull(request.getParameter("invoke_menstrual_history_yn"));
	//ML-MMOH-CRF-1759.1-US001 ends	
	
	String allow_ext_nb_regn_within_days = checkForNull( request.getParameter( "allow_ext_nb_regn_within_days") );

    String single_stage_nb_reg_appl_yn    =  checkForNull(request.getParameter( "single_stage_nb_reg_appl_yn"   ));
	String mod_birth_reg_appl_yn      = checkForNull( request.getParameter( "mod_birth_reg_appl_yn") ); //Added by Prakash on 03rd Oct 2023 ML-MMOH-CRF-2046
    //String invoke_chg_pat_dtls_fm_nb_yn    =  checkForNull(request.getParameter( "invoke_chg_pat_dtls_fm_nb_yn"   ));
    String nb_use_mother_ser             =  checkForNull(request.getParameter( "nb_use_mother_ser"   ));
    String search_threshold_records      =  checkForNull(request.getParameter( "search_threshold_records" ));
    String sex_hist_yn                   =  checkForNull(request.getParameter( "sex_hist_yn"          ));
    String birth_date_hist_yn            =  checkForNull(request.getParameter( "birth_date_hist_yn"       ));
    String legal_name_hist_yn            =  checkForNull(request.getParameter( "legal_name_hist_yn"       ));
    String alias_name_hist_yn            =  checkForNull(request.getParameter( "alias_name_hist_yn"       ));
    String coded_pseudo_name_hist_yn     =  checkForNull(request.getParameter( "coded_pseudo_name_hist_yn"    ));
    String contact_no_hist_yn            =  checkForNull(request.getParameter( "contact_no_hist_yn"       ));
    String address_hist_yn               =  checkForNull(request.getParameter( "address_hist_yn"      ));
    String ocpn_n_empl_hist_yn           =  checkForNull(request.getParameter( "ocpn_n_empl_hist_yn"      ));
    String general_alert_info_hist_yn    =  checkForNull(request.getParameter( "general_alert_info_hist_yn"   ));
    String suspend_reinstate_hist_yn     =  checkForNull(request.getParameter( "suspend_reinstate_hist_yn"    ));
    String inactivate_activate_hist_yn   =  checkForNull(request.getParameter( "inactivate_activate_hist_yn"));
    String rec_revoke_death_hist_yn      =  checkForNull(request.getParameter( "rec_revoke_death_hist_yn" ));
    String added_by_id                   =  checkForNull(request.getParameter( "added_by_id"          ));
    String added_date                    =  checkForNull(request.getParameter( "added_date"           ));
    String added_at_ws_no                =  checkForNull(request.getParameter( "added_at_ws_no"           ));
    String modified_by_id                =  checkForNull(request.getParameter( "modified_by_id"           ));
    String modified_date                 =  checkForNull(request.getParameter( "modified_date"            ));
    String modified_at_ws_no             =  checkForNull(request.getParameter( "modified_at_ws_no"        ));
    String hr_interface_yn               =  checkForNull(request.getParameter( "hr_interface_yn"      ));
    String hr_check_digit_scheme         =  checkForNull(request.getParameter( "hr_check_digit_scheme"    ));
    String his_interface_yn              =  checkForNull(request.getParameter( "his_interface_yn"     ));
    String age_limit_for_service         =  checkForNull(request.getParameter( "age_limit_for_service"    ));
    String alt_id1_len_validation_yn     =  checkForNull(request.getParameter("alt_id1_len_validation_yn"));
    String alt_id2_len_validation_yn     =  checkForNull(request.getParameter("alt_id2_len_validation_yn"));
    String alt_id3_len_validation_yn     =  checkForNull(request.getParameter("alt_id3_len_validation_yn"));
    String alt_id4_len_validation_yn     =  checkForNull(request.getParameter("alt_id4_len_validation_yn"));
    String alt_id1_exp_date_accept_yn   =  checkForNull(request.getParameter("alt_id1_exp_date_accept_yn"));
    String alt_id2_exp_date_accept_yn   =  checkForNull(request.getParameter("alt_id2_exp_date_accept_yn"));
    String alt_id3_exp_date_accept_yn   =  checkForNull(request.getParameter("alt_id3_exp_date_accept_yn"));
    String alt_id4_exp_date_accept_yn   =  checkForNull(request.getParameter("alt_id4_exp_date_accept_yn"));
    String alt_id1_routine_name         =  checkForNull(request.getParameter("alt_id1_routine_name"));
    String alt_id2_routine_name         =  checkForNull(request.getParameter("alt_id2_routine_name"));
    String alt_id3_routine_name         =  checkForNull(request.getParameter("alt_id3_routine_name"));
    String alt_id4_routine_name         =  checkForNull(request.getParameter("alt_id4_routine_name"));
    String alt_id1_invoke_routine       =  checkForNull(request.getParameter("alt_id1_invoke_routine"));
    String alt_id2_invoke_routine       =  checkForNull(request.getParameter("alt_id2_invoke_routine"));
    String alt_id3_invoke_routine       =  checkForNull(request.getParameter("alt_id3_invoke_routine"));
    String alt_id4_invoke_routine       =  checkForNull(request.getParameter("alt_id4_invoke_routine"));
    String id_change_allowed_for_series =  checkForNull(request.getParameter("id_change_allowed_for_series"));
    String alt_id1_adv_alert_reqd_yn    =  checkForNull(request.getParameter("alt_id1_adv_alert_reqd_yn"));
    String alt_id1_adv_alert_days       =  checkForNull(request.getParameter("alt_id1_adv_alert_days"));
    String alt_id2_adv_alert_reqd_yn    =  checkForNull(request.getParameter("alt_id2_adv_alert_reqd_yn"));
    String alt_id2_adv_alert_days       =  checkForNull(request.getParameter("alt_id2_adv_alert_days"));
    String alt_id3_adv_alert_reqd_yn    =  checkForNull(request.getParameter("alt_id3_adv_alert_reqd_yn"));
    String alt_id3_adv_alert_days       =  checkForNull(request.getParameter("alt_id3_adv_alert_days"));
    String alt_id4_adv_alert_reqd_yn    =  checkForNull(request.getParameter("alt_id4_adv_alert_reqd_yn"));
    String alt_id4_adv_alert_days       =  checkForNull(request.getParameter("alt_id4_adv_alert_days"));
	String alt_id1_accept_oth_pat_ser_yn = "";
	String alt_id1_chng_allowed_yn = "";
	String alt_id1_accept_alphanumeric_yn  = "";
	String chkdisAcceptAlphanumeric = "";
	String chkdisAcceptothpatser = "";
	String max_patient_age = "";
	String terminal_digit_reqd_yn       =  checkForNull(request.getParameter("terminal_digit_reqd_yn"));
    String terminal_digit_count         =  checkForNull(request.getParameter("terminal_digit_count"));
    String terminal_digit1_position       =  checkForNull(request.getParameter("terminal_digit1_position"));
    String terminal_digit2_position       =  checkForNull(request.getParameter("terminal_digit2_position"));
    String terminal_digit3_position       =  checkForNull(request.getParameter("terminal_digit3_position"));
    String terminal_digit4_position       =  checkForNull(request.getParameter("terminal_digit4_position"));
    String terminal_digit5_position       =  checkForNull(request.getParameter("terminal_digit5_position"));
    String addl_field1_prompt       =  checkForNull(request.getParameter("addl_field1_prompt"));
    String addl_field1_length           =  checkForNull(request.getParameter("addl_field1_length"));
    String addl_field1_section       =  checkForNull(request.getParameter("addl_field1_section"));
    String addl_field2_prompt       =  checkForNull(request.getParameter("addl_field2_prompt"));
    String addl_field2_length           =  checkForNull(request.getParameter("addl_field2_length"));
    String addl_field2_section       =  checkForNull(request.getParameter("addl_field2_section"));
    String addl_field3_prompt       =  checkForNull(request.getParameter("addl_field3_prompt"));
    String addl_field3_length           =  checkForNull(request.getParameter("addl_field3_length"));
    String addl_field3_section       =  checkForNull(request.getParameter("addl_field3_section"));
    String addl_field4_prompt       =  checkForNull(request.getParameter("addl_field4_prompt"));
    String addl_field4_length           =  checkForNull(request.getParameter("addl_field4_length"));
    String addl_field4_section       =  checkForNull(request.getParameter("addl_field4_section"));
    String addl_field5_prompt       =  checkForNull(request.getParameter("addl_field5_prompt"));
    String addl_field5_length           =  checkForNull(request.getParameter("addl_field5_length"));
    String addl_field5_section       =  checkForNull(request.getParameter("addl_field5_section"));
    
	String start_with = ""; 
	String alt_id1_start_with = ""; 
	String alt_id2_start_with = ""; 
	String alt_id3_start_with = ""; 
	String alt_id4_start_with = ""; 
	
    String nat_prompt  ="";
	String dft_national_id ="";
    String nat_reqd_for_all_ser ="";
    String nat_chk_dig_scheme = "";
    String chk_len = "" ;
    String nat_invoke_routine ="";
	String chkAcceptNat = "";
	String accept_national_id_no_yn = "";
	//String accept_residency_status = "";
	String entitlement_by_pat_cat_yn = "";
	String mapped_alt_id_org_member_id = "";
	String org_member_relationship_code = "";
    String col1="";
    String col2="";
    String col3="";
    String chk1="";
    String chk2="";
    String chk3="";
    String chk4="";
    String terminal=""; 
    String dig0="";
    String dig3="";
    String dig4="";
    String dig5="";
    String sec11="";
    String sec12="";
    String sec13="";
    String sec14="";
    String sec15="";
    String sec16="";
    String sec21="";
    String sec22="";
    String sec23="";
    String sec24="";
    String sec25="";
    String sec26="";
    String sec31="";
    String sec32="";
    String sec33="";
    String sec34="";
    String sec35="";
    String sec36="";
    String sec41="";
    String sec42="";
    String sec43="";
    String sec44="";
    String sec45="";
    String sec46="";
    String sec51="";
    String sec52="";
    String sec53="";
    String sec54="";
    String sec55="";
    String sec56="";
	String sec57="";
	String sec58="";
	String sec59="";
	String sec60="";
	String sec61="";
	String pat_search_tab ="";
    String name_in_oth_lang_yn    =  request.getParameter("name_in_oth_lang_yn")==null ?"N":request.getParameter("name_in_oth_lang_yn");
    String nat_id_routine_name    = "";
	String min_weight = "";
	String display_new_born_age="";
	String age_not_consider_natid=""; //Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
	String no_days_UHID_valid=""; // Added by mujafar for AMRI-CRF-0357 
	String age_not_consider_natid_altid=""; //Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]
	String max_weight = "";
	String min_length = "";
	String max_length = "";
	String min_head_circum = "";
	String max_head_circum = "";
	String min_chest_circum = "";
	String max_chest_circum = "";
	String min_gestation = "";
	String max_gestation = "";
	String gestation_two_del = "";
	String gen_slno_unknown_pat_yn = "";
    String operation              =  checkForNull(request.getParameter( "operation" ));
	String create_file_at_pat_regn_yn = "";
    String create_file_at_admission = "";
	String create_file_at_reg_visit_yn = "";
	String create_file_at_reg_att_yn = "";
	String create_file_at_dc_admission_yn = "";
	String maintain_doc_or_file = "";
	String disable_mr_admin = "";
	String mr_file_select = "";
	String mr_doc_select = "";
	String name_prefix_length = "";
	String first_name_length = "";
	String second_name_length = "";
	String third_name_length = "";
	String family_name_length = "";
	String name_suffix_length = "";
	String inv_pat_search_in_reg_pat_yn ="N";
	String race_required_yn ="N";
	String round_dob_estd_age ="N";
	//Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
	//Start
	String mortuary_release_yn="N";
	String no_days_before_deceased="";
	String cancel_reason_code="";
	//End
	String dflt_language_id="";
	String dflt_relgn_code="";
	String language_direction="";
	String name_pfx_reqd_for_org_mem_yn="";
//CC ON 2/26/2008
	String gen_pid_using_aid1_rule_yn="";
	//String gen_pid_ald1_disable="";
	//String gen_pid_ald1_checked="";

	String nat_id_accept_alphanumeric_yn="";
	String chkAcceptAlpha = "";
	String create_file_yn = "Y";
	String single_patient_numbering_yn="";
	//String status="";
	//String chksinpatyn="";
   //	String display_new_born_age_in _hr ;
		/*String alt_id2_accept_alphanumeric_yn ="";
	String alt_id3_accept_alphanumeric_yn ="";
	String alt_id4_accept_alphanumeric_yn ="";*/


	//Added On 3/5/2008
//	String relationship_level_length="";

	//String dis_id_chg_all_ser = "";
// New parameter Added  against GHL-CRF-0312 [IN:039856] By saanthaakumar
	String country_reqd_yn ="N";
String region_reqd_yn ="N";
String mobile_no_reqd_yn ="N";
// New parameter Added  against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
String email_id_reqd_yn ="N";
// New parameter Added  against AMRI-CRF-0388  By Shagar
String postal_cd_reqd_yn ="N";
String area_reqd_yn ="N";
//New parameter Added against ML-MMOH-CRF-0736 by Mano
String religion_reqd_yn ="N";

String pat_ser_access_by_user_yn="N";//added for MO-CRF-20074
String patientcategory_reqd_yn ="N"; //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
String town_reqd_yn ="N"; //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522


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
String upd_pat_dtls_referral_yn				= "N"; //Added by Dharma against HSA-CRF-0303 [IN:054572] on Apr 8th 2016
String disp_cancelled_previous_enc_yn="Y";
String unmask_aadhaar_num_yn	= "N"; 	
String unmask_abha_num_addr_yn  ="N";	

String biometric_authentication_yn="";
String reason_biomtrc_auth_fail_yn="";


//Added by PRITHIVI ON 10/05/2017 FOR KDAH-CRF-0362
String aadharProfileYN = InterfaceUtil.isInterfaceProfileExisting("AADHAARPROF1");
String aadhaar_config_enabled_yn	= checkForNull( request.getParameter( "aadhar_config_enabled_yn"),"N" );
String aadhaar_option_value	= checkForNull( request.getParameter( "aadhar_option_value"),"" );


String death_reg_form_req_yn = "N";//Added by Ajay Hatwate for AAKH-CRF-0179 on 14/08/2023
String occupation_reqd_yn      = "N";
String marital_status_reqd_yn  ="N";
String mand_visit_admssn_reg_yn  ="N";

String abha_eng_audio_path="";
String abha_hin_audio_path="";
	try
	{
	pstmt_rh = con.prepareStatement("select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");
    rs_rh = pstmt_rh.executeQuery();	
	if(rs_rh!=null && rs_rh.next())
	{
	function_name=rs_rh.getString("VALUE_2");
	}
	}catch(SQLException esql)
	{
		esql.printStackTrace();
	}finally
	{
	 if(pstmt_rh != null)pstmt_rh.close();
	 if(rs_rh != null)rs_rh.close();
	}
//<!--Added by Himanshu Saxena on  30-Jun-2023 for AAKH-CRF-0175 US1 ends-->	


String module_instal_ind="";
	        pstmt1 = con.prepareStatement( "select MODULE_INSTALL_IND from sm_module where module_id='MP' " ) ;
			  rs1 = pstmt1.executeQuery() ;
if ( rs1 != null && rs1.next() ) 
		  {
           
            module_instal_ind  = rs1.getString( "MODULE_INSTALL_IND") == null?"":rs1.getString( "MODULE_INSTALL_IND");
             

}
    
	
	if ( operation == null )
		operation = "" ;
		//operation="insert";
		  if ( operation.equalsIgnoreCase( "modify" ) )
		  {
		      pstmt = con.prepareStatement( "select * from MP_PARAM");
			  rs = pstmt.executeQuery();
             
			
          
		  
		  if ( rs != null && rs.next() ) 
		  { 
            no_days_UHID_valid = rs.getString ("UHID_VALID_DAYS") == null?"":rs.getString("UHID_VALID_DAYS"); // Added by mujafar for AMRI-CRF-0357
            display_new_born_age=rs.getString   ( "DISPLAY_NEW_BORN_AGE_IN_HRS");
			if(display_new_born_age==null) display_new_born_age="";
			single_patient_numbering_yn=rs.getString   ( "single_patient_numbering_yn");
			entitlement_by_pat_cat_yn  = rs.getString   ( "entitlement_by_pat_cat_yn");
            family_org_id_accept_yn     = rs.getString   ( "family_org_id_accept_yn");
            mapped_alt_id_org_member_id     = rs.getString   ( "mapped_alt_id_org_member_id");
            org_member_relationship_code     = rs.getString   ( "org_member_relationship_code");
            pat_search_tab                 =rs.getString( "PAT_SEARCH_DFLT_TAB");
			
			module_id                     = rs.getString( "module_id");
            patient_id_length             = rs.getString( "patient_id_length");
            patient_no_ctrl               = rs.getString( "patient_no_ctrl");
            gen_pat_ser_grp               = rs.getString( "gen_pat_ser_grp");
            nat_id_pat_ser_grp            = rs.getString( "nat_id_pat_ser_grp");
            alt_id_pat_ser_grp            = rs.getString( "alt_id_pat_ser_grp");
            family_no_pat_ser_grp         = rs.getString( "family_no_pat_ser_grp");
            dflt_pat_ser_grp_type         = rs.getString( "dflt_pat_ser_grp_type");
            emeg_pat_ser_grp              = rs.getString( "emeg_pat_ser_grp");
            newborn_pat_ser_grp           = rs.getString( "newborn_pat_ser_grp");
            nat_id_length                 = rs.getString( "nat_id_length");
            name_dervn_logic              = rs.getString( "name_dervn_logic");
            name_dervn_logic_oth_lang     = rs.getString( "name_dervn_logic_oth_lang");

			name_dervn_logic_long              = rs.getString( "name_dervn_logic_long");
            name_dervn_logic_oth_lang_long     = rs.getString( "name_dervn_logic_oth_lang_long");

			//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
			name_dervn_logic_nb           = rs.getString( "name_dervn_logic_nb" );
			//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
			name_dervn_logic_nb_sb		  = rs.getString( "name_dervn_logic_nb_sb" );

            dflt_patient_name     = rs.getString( "dflt_patient_name");
			  dft_national_id     = rs.getString( "dft_national_id");
			gen_slno_unknown_pat_yn       = rs.getString("gen_slno_unknown_pat_yn"); 
            ethnic_sndx_type              = rs.getString( "ethnic_sndx_type");
            family_no_link_yn             = rs.getString( "family_no_link_yn");
            head_patient_no_use_yn        = rs.getString( "head_patient_no_use_yn");
            family_org_id_accept_yn       = rs.getString( "family_org_id_accept_yn");
            mapped_alt_id_org_member_id = checkForNull(rs.getString( "mapped_alt_id_org_member_id"),"");
            org_member_relationship_code = checkForNull(rs.getString("org_member_relationship_code"),"");
            citizen_nationality_code      = rs.getString( "citizen_nationality_code");
			default_race_code			  = rs.getString( "default_race_code");	 
			default_relationship_code			  = rs.getString( "nb_dflt_relnship_code");	
            general_alert_yn              = rs.getString( "general_alert_yn");
            suspend_service_yn            = rs.getString( "suspend_service_yn");
            single_or_multi_files_ind     = rs.getString( "single_or_multi_files_ind")==null?"S":rs.getString( "single_or_multi_files_ind");
            separate_file_no_yn           = rs.getString( "separate_file_no_yn");
            ext_system_interface_yn       = rs.getString( "ext_system_interface_yn");
           	pat_name_as_multipart_yn	  = rs.getString("pat_name_as_multipart_yn");
			name_prefix_accept_yn         = rs.getString( "name_prefix_accept_yn");
            name_prefix_reqd_yn           = rs.getString( "name_prefix_reqd_yn");
            name_prefix_prompt            = rs.getString( "name_prefix_prompt");
			name_prefix_loc_lang_prompt   = rs.getString( "name_prefix_loc_lang_prompt");
            first_name_accept_yn          = rs.getString( "first_name_accept_yn");
            first_name_reqd_yn            = rs.getString( "first_name_reqd_yn");
            first_name_order              = rs.getInt( "first_name_order")+"";
            first_name_prompt             = rs.getString( "first_name_prompt");
            first_name_loc_lang_prompt    = rs.getString( "first_name_loc_lang_prompt");
            second_name_accept_yn         = rs.getString( "second_name_accept_yn");
            second_name_reqd_yn           = rs.getString( "second_name_reqd_yn");
            second_name_order             = rs.getInt   ( "second_name_order") + "" ;
            second_name_prompt            = rs.getString( "second_name_prompt");
            second_name_loc_lang_prompt   = rs.getString( "second_name_loc_lang_prompt");
            third_name_accept_yn          = rs.getString( "third_name_accept_yn" );
            third_name_reqd_yn            = rs.getString( "third_name_reqd_yn");
            third_name_order              = rs.getInt   ( "third_name_order") + ""  ;
            third_name_prompt             = rs.getString( "third_name_prompt" );
            third_name_loc_lang_prompt    = rs.getString( "third_name_loc_lang_prompt" );
            family_name_accept_yn         = rs.getString( "family_name_accept_yn" );
            family_name_reqd_yn           = rs.getString( "family_name_reqd_yn" );
            family_name_order             = rs.getInt   ( "family_name_order" ) + ""  ;
            family_name_prompt            = rs.getString( "family_name_prompt" )       ;
            family_name_loc_lang_prompt   = rs.getString( "family_name_loc_lang_prompt" )       ;
            family_name_prefix_yn         = rs.getString( "family_name_prefix_yn");
            name_suffix_accept_yn         = rs.getString( "name_suffix_accept_yn" );
            name_suffix_reqd_yn           = rs.getString( "name_suffix_reqd_yn");
            name_suffix_prompt            = rs.getString( "name_suffix_prompt");
            name_suffix_loc_lang_prompt   = rs.getString( "name_suffix_loc_lang_prompt");
            names_in_oth_lang_yn          = rs.getString( "names_in_oth_lang_yn");
            dflt_sndx_type                = rs.getString( "dflt_sndx_type");
            dflt_coded_pseudo_name        = rs.getString( "dflt_coded_pseudo_name");
            alt_id1_type                  = rs.getString( "alt_id1_type");
            alt_id1_length                = rs.getInt   ( "alt_id1_length") + ""  ;
            alt_id1_chk_digit_scheme      = rs.getString( "alt_id1_chk_digit_scheme");
            alt_id1_reqd_yn               = rs.getString( "alt_id1_reqd_yn");
            alt_id1_unique_yn             = rs.getString( "alt_id1_unique_yn");
            alt_id1_exp_warn_yn           = rs.getString( "alt_id1_exp_warn_yn");
            alt_id1_exp_grace_days        = rs.getInt   ( "alt_id1_exp_grace_days") + ""  ;
            alt_id2_type                  = rs.getString( "alt_id2_type");
            alt_id2_length                = rs.getInt   ( "alt_id2_length") + ""  ;
            alt_id2_chk_digit_scheme      = rs.getString( "alt_id2_chk_digit_scheme");
            alt_id2_reqd_yn               = rs.getString( "alt_id2_reqd_yn");
            alt_id2_unique_yn             = rs.getString( "alt_id2_unique_yn");
            alt_id2_exp_warn_yn           = rs.getString( "alt_id2_exp_warn_yn");
            alt_id2_exp_grace_days        = rs.getInt   ( "alt_id2_exp_grace_days") + ""  ;
            alt_id3_type                  = rs.getString( "alt_id3_type");
            alt_id3_length                = rs.getInt   ( "alt_id3_length") + ""  ;
            alt_id3_chk_digit_scheme      = rs.getString( "alt_id3_chk_digit_scheme");
            alt_id3_reqd_yn               = rs.getString( "alt_id3_reqd_yn");
            alt_id3_unique_yn             = rs.getString( "alt_id3_unique_yn");
            alt_id3_exp_warn_yn           = rs.getString( "alt_id3_exp_warn_yn");
			alt_id3_exp_grace_days        = rs.getInt   ( "alt_id3_exp_grace_days") + ""  ;
            alt_id4_type                  = rs.getString( "alt_id4_type");
            alt_id4_length                = rs.getInt   ( "alt_id4_length") + ""  ;
            alt_id4_chk_digit_scheme      = rs.getString( "alt_id4_chk_digit_scheme");
            alt_id4_reqd_yn               = rs.getString( "alt_id4_reqd_yn");
            alt_id4_unique_yn             = rs.getString( "alt_id4_unique_yn");
            alt_id4_exp_warn_yn           = rs.getString( "alt_id4_exp_warn_yn");
            alt_id4_exp_grace_days        = rs.getInt   ( "alt_id4_exp_grace_days") + ""  ;
            family_no_prompt              = rs.getString( "family_no_prompt");
            dflt_contact_mode1            = rs.getString( "dflt_contact_mode1");
            dflt_contact_mode2            = rs.getString( "dflt_contact_mode2");
            dflt_contact_mode3            = rs.getString( "dflt_contact_mode3");
            dflt_contact_mode4            = rs.getString( "dflt_contact_mode4");
            dflt_contact_mode5            = rs.getString( "dflt_contact_mode5");
            dflt_addr_type1               = rs.getString( "dflt_addr_type1");
            dflt_addr_type2               = rs.getString( "dflt_addr_type2");
            dflt_addr_type3               = rs.getString( "dflt_addr_type3");
            dflt_addr_type4               = rs.getString( "dflt_addr_type4");
            dflt_addr_type5               = rs.getString( "dflt_addr_type5");
            dflt_rel_contact_role1        = rs.getString( "dflt_rel_contact_role1");
            dflt_rel_contact_role2        = rs.getString( "dflt_rel_contact_role2");
            dflt_rel_contact_role3        = rs.getString( "dflt_rel_contact_role3");
            dflt_rel_contact_role4        = rs.getString( "dflt_rel_contact_role4");
            dflt_rel_contact_role5        = rs.getString( "dflt_rel_contact_role5");
            dflt_doc1_type                = rs.getString( "dflt_doc1_type");
            dflt_doc2_type                = rs.getString( "dflt_doc2_type");
            dflt_doc3_type                = rs.getString( "dflt_doc3_type");
            dflt_doc4_type                = rs.getString( "dflt_doc4_type");
            dflt_doc5_type                = rs.getString( "dflt_doc5_type");
            dflt_pat_fin_class            = rs.getString( "dflt_pat_fin_class");
            prompt_pat_fin_class_yn       = rs.getString( "prompt_pat_fin_class_yn");
            allow_nb_regn_within_days     = rs.getString( "allow_nb_regn_within_days");
			mul_birth_regn_within_hours   = rs.getString( "max_multiple_birth_regn_hrs"); 
			dflt_alt_id1_in_emp_id_yn     = rs.getString( "dflt_alt_id1_in_emp_id_yn");
            acpt_appt_rfrl_in_reg_pat_yn  = rs.getString( "acpt_appt_rfrl_in_reg_pat_yn");
			min_age_of_moth               = rs.getString( "nb_mother_min_age");
            max_age_of_moth               = rs.getString( "nb_mother_upper_age");
			cut_age_of_moth               = rs.getString( "nb_mother_cutoff_age");
			dft_rel_male_nb               = rs.getString( "nb_male_relnship");
			dft_rel_female_nb             = rs.getString( "nb_female_relnship");
			dft_rel_unknown_nb            = rs.getString( "nb_unknown_relnship");
			allow_nb_regn_unit            = rs.getString( "allow_nb_regn_unit");
			Accept_oth_alt_id_yn          = rs.getString( "Accept_oth_alt_id_yn");
            min_age_of_fath               = rs.getString( "nb_father_min_age");
            unit_of_wt_nb                 = rs.getString( "unit_of_wt_nb");
            unit_of_circum_nb             = rs.getString( "unit_of_circum_nb");
            unit_of_length_nb             = rs.getString( "unit_of_length_nb");
            unit_of_chest_circum_nb       = rs.getString( "unit_of_chest_circum_nb");
            unit_of_gest_nb               = rs.getString( "unit_of_gest_nb");
            sub_multi_birth_hw               = rs.getString( "sub_multi_birth_hw");
            name_suffix_male_nb           = rs.getString( "name_suffix_male_nb");
            name_suffix_female_nb         = rs.getString( "name_suffix_female_nb");
            name_prefix_male_nb           = rs.getString( "name_prefix_male_nb");
            name_prefix_unknown_nb           = rs.getString( "name_prefix_unknown_nb"); // Added by Afruddin for ML-MMOH-CRF-1520 US001 on 4.05.2020
            name_prefix_female_nb         = rs.getString( "name_prefix_female_nb");
            
            
            still_born_prefix			  = checkForNull(rs.getString( "still_born_prefix"));  
            pat_photo_renewal_alert_days			  = checkForNull(rs.getString( "pat_photo_renewal_alert_days"));  
			
			//Added by Ashwini on 06-Mar-2019 for MO-CRF-20148
			age_not_consider_natid = checkForNull(rs.getString ("AGE_NOT_CONSIDER_NATID"));
			age_not_consider_natid_altid = checkForNull(rs.getString ("AGE_NOT_CONSIDER_NATID_ALTID"));	//Added by Dharma on 20th Mar 2019 NMC-JD-CRF-0018 [IN:069750]
			
			nb_father_name_mandatory_yn   = rs.getString( "nb_father_name_mandatory_yn");  
			nb_mother_dtls_update_yn=rs.getString( "nb_mother_dtls_update_yn");//Added for HSA-CRF-0182
			data_upd_allowed_aft_final_yn = rs.getString( "data_upd_allowed_aft_final_yn");  
			accept_names_for_live_birth_yn= rs.getString( "accept_names_for_live_birth_yn"); 
		    if ( accept_names_for_live_birth_yn         == null ) accept_names_for_live_birth_yn    = "Y" ;

			dflt_race_nat_setup_nb_as_per = rs.getString( "dflt_race_nat_setup_nb_as_per");
			
            review_nb_links_bef_reg_yn    = rs.getString( "review_nb_links_bef_reg_yn");
	    allow_ext_nb_regn_within_days    = rs.getString( "allow_ext_nb_regn_within_days");
			
            length_of_baby_yn    = rs.getString( "length_of_baby_yn");
            head_circumference_of_baby_yn    = rs.getString( "head_circumference_of_baby_yn");
			
            mandate_first_newborn_yn    = rs.getString( "Mandate_First_NewBorn_yn");
            mandate_first_newborn_ip_yn    = rs.getString( "Mandate_First_NewBorn_IP_yn");
            mandate_first_newborn_ae_yn    = rs.getString( "Mandate_First_NewBorn_AE_yn");
            mandate_second_newborn_yn    = rs.getString( "Mandate_Second_NewBorn_yn");
            mandate_second_newborn_ip_yn    = rs.getString( "Mandate_Second_NewBorn_IP_yn");
            mandate_second_newborn_ae_yn    = rs.getString( "Mandate_Second_NewBorn_AE_yn");
            mandate_third_newborn_yn    = rs.getString( "Mandate_Third_NewBorn_yn");
            mandate_third_newborn_ip_yn    = rs.getString( "Mandate_Third_NewBorn_IP_yn");
            mandate_third_newborn_ae_yn    = rs.getString( "Mandate_Third_NewBorn_AE_yn");
            mand_antenatal_newborn_yn    = rs.getString( "Mand_Antenatal_NewBorn_yn");
            mand_antenatal_newborn_ip_yn    = rs.getString( "Mand_Antenatal_NewBorn_IP_yn");
            mand_antenatal_newborn_ae_yn    = rs.getString( "Mand_Antenatal_NewBorn_AE_yn");
			
            enable_marital_status    = checkForNull(rs.getString( "ENABLE_MARITAL_STATUS"));
            dflt_father_first_name_prompt    = checkForNull(rs.getString( "DFLT_FATHER_FIRST_NAME_PROMPT"));
            dflt_father_Second_name_prompt    = checkForNull(rs.getString( "DFLT_FATHER_SECOND_NAME_PROMPT"));
            dflt_father_third_name_prompt    = checkForNull(rs.getString( "DFLT_FATHER_THIRD_NAME_PROMPT"));
            dflt_father_family_name_prompt    = checkForNull(rs.getString( "DFLT_FATHER_FAMILY_NAME_PROMPT"));
            
          
            mand_parity_newborn_yn = rs.getString("mand_parity_newborn_yn");
            mand_parity_newborn_ip_yn = rs.getString("mand_parity_newborn_ip_yn");
            mand_parity_newborn_ae_yn = rs.getString("mand_parity_newborn_ae_yn"); 
            invoke_menstrual_history_yn = rs.getString("invoke_menstrual_history_yn");
            

            single_stage_nb_reg_appl_yn    = rs.getString( "single_stage_nb_reg_appl_yn");
            mod_birth_reg_appl_yn    = rs.getString( "mod_birth_reg_appl_yn"); //Added by Prakash on 03rd Oct 2023 ML-MMOH-CRF-2046
            //invoke_chg_pat_dtls_fm_nb_yn    = rs.getString( "invoke_chg_pat_dtls_fm_nb_yn");
            nb_use_mother_ser               = rs.getString( "nb_use_mother_ser");
            search_threshold_records      = rs.getString( "search_threshold_records");
            sex_hist_yn                   = rs.getString( "sex_hist_yn");
            birth_date_hist_yn            = rs.getString( "birth_date_hist_yn");
            legal_name_hist_yn            = rs.getString( "legal_name_hist_yn");
            alias_name_hist_yn            = rs.getString( "alias_name_hist_yn");
            coded_pseudo_name_hist_yn     = rs.getString( "coded_pseudo_name_hist_yn");
            contact_no_hist_yn            = rs.getString( "contact_no_hist_yn");
            address_hist_yn               = rs.getString( "address_hist_yn");
            ocpn_n_empl_hist_yn           = rs.getString( "ocpn_n_empl_hist_yn");
            general_alert_info_hist_yn    = rs.getString( "general_alert_info_hist_yn");
            suspend_reinstate_hist_yn     = rs.getString( "suspend_reinstate_hist_yn");
            gen_pid_using_aid1_rule_yn     = rs.getString( "gen_pid_using_aid1_rule_yn");
           // display_new_born_age_in _hr  = rs.getString( "display_new_born_age_in _hrs");
              //if(display_new_born_age_in _hrs.equals()) display_new_born_age_in _hrs="";
//            relationship_level_length     = rs.getString( "relationship_level_length")==null?"":rs.getString( "relationship_level_length");
		
			//For FM
			create_file_at_pat_regn_yn   =  rs.getString ( "create_file_at_pat_regn_yn");
			create_file_at_admission     =  rs.getString ( "create_file_at_admission");
			create_file_at_reg_visit_yn  =  rs.getString ( "create_file_at_reg_visit_yn");
			create_file_at_reg_att_yn    =  rs.getString ( "create_file_at_reg_att_yn");
			create_file_at_dc_admission_yn = rs.getString ("create_file_at_dc_admission_yn");
			//For MR Admin
			maintain_doc_or_file =  rs.getString ( "maintain_doc_or_file");			
			create_file_yn		 =  rs.getString ("create_file_yn") == null?"Y":rs.getString("create_file_yn");			
			upt_contact_dtls_oa_yn		 =  rs.getString ("UPT_CONTACT_DTLS_OA_YN") == null?"N":rs.getString("UPT_CONTACT_DTLS_OA_YN");	//added  changes   for HSA-CRF-0226 [IN:050599] 	
			
			/*Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/
			ALT_ID1_PAT_SCH_EXACT_YN=rs.getString ("ALT_ID1_PAT_SCH_EXACT_YN") == null?"N":rs.getString("ALT_ID1_PAT_SCH_EXACT_YN");
			ALT_ID2_PAT_SCH_EXACT_YN=rs.getString ("ALT_ID2_PAT_SCH_EXACT_YN") == null?"N":rs.getString("ALT_ID2_PAT_SCH_EXACT_YN");
			ALT_ID3_PAT_SCH_EXACT_YN=rs.getString ("ALT_ID3_PAT_SCH_EXACT_YN") == null?"N":rs.getString("ALT_ID3_PAT_SCH_EXACT_YN");
			ALT_ID4_PAT_SCH_EXACT_YN=rs.getString ("ALT_ID4_PAT_SCH_EXACT_YN") == null?"N":rs.getString("ALT_ID4_PAT_SCH_EXACT_YN");
			/*Added by PRITHIVI ON 10/05/2017 FOR KDAH-CRF-0362*/
			aadhaar_config_enabled_yn = rs.getString ("aadhar_config_enabled_yn") == null?"N":rs.getString("aadhar_config_enabled_yn");
			aadhaar_option_value = rs.getString ("aadhar_option_value") == null?"":rs.getString("aadhar_option_value");

			// <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 US1 Starts-->
			biometric_authentication_yn=rs.getString ("BIOMETRIC_AUTHENTICATION_YN") == null?"N":rs.getString("BIOMETRIC_AUTHENTICATION_YN");
			// <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 US1 Ends-->
			

			if(maintain_doc_or_file.equals("F"))
			  {
				if(operation.equals("modify"))
				{
					disable_mr_admin = "disabled";
					mr_file_select =   "selected";
					mr_doc_select = "";}
				}
				else if(maintain_doc_or_file.equals("D")) /* Only File is allowed now*/
				{				
				/*	if(operation.equals("modify"))
					{disable_mr_admin = "disabled";
					mr_file_select =   "";
					mr_doc_select = "selected";}
				*/
				}
		
            rec_revoke_death_hist_yn      = rs.getString( "rec_revoke_death_hist_yn");
            hr_interface_yn             = rs.getString( "hr_interface_yn");
            hr_check_digit_scheme         = rs.getString( "hr_check_digit_scheme");
            his_interface_yn            = rs.getString( "his_interface_yn");
            age_limit_for_service       = rs.getInt( "age_limit_for_service") + "" ;

            alt_id1_len_validation_yn = rs.getString("ALT_ID1_LEN_VALIDATION_YN");
            alt_id2_len_validation_yn = rs.getString("ALT_ID2_LEN_VALIDATION_YN");
            alt_id3_len_validation_yn  = rs.getString("ALT_ID3_LEN_VALIDATION_YN");
            alt_id4_len_validation_yn = rs.getString("ALT_ID4_LEN_VALIDATION_YN");

            alt_id1_exp_date_accept_yn = rs.getString("alt_id1_exp_date_accept_yn");
            alt_id2_exp_date_accept_yn = rs.getString("alt_id2_exp_date_accept_yn");
            alt_id3_exp_date_accept_yn = rs.getString("alt_id3_exp_date_accept_yn");
            alt_id4_exp_date_accept_yn = rs.getString("alt_id4_exp_date_accept_yn");
            name_in_oth_lang_yn        = rs.getString("names_in_oth_lang_yn");
       
            alt_id1_routine_name       = rs.getString("alt_id1_data_source_id");
            alt_id2_routine_name       = rs.getString("alt_id2_data_source_id");
            alt_id3_routine_name       = rs.getString("alt_id3_data_source_id");
            alt_id4_routine_name       = rs.getString("alt_id4_data_source_id"); 

            alt_id1_invoke_routine     = rs.getString("alt_id1_routine_yn");
            alt_id2_invoke_routine     = rs.getString("alt_id2_routine_yn");
            alt_id3_invoke_routine     = rs.getString("alt_id3_routine_yn");
            alt_id4_invoke_routine     = rs.getString("alt_id4_routine_yn");
		
		
			alt_id1_accept_oth_pat_ser_yn = rs.getString("alt_id1_accept_oth_pat_ser_yn")==null?"N":rs.getString("alt_id1_accept_oth_pat_ser_yn");
			alt_id1_accept_alphanumeric_yn = rs.getString("alt_id1_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id1_accept_alphanumeric_yn");



			/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start */
			alt_id2_accept_oth_pat_ser_yn			= checkForNull(rs.getString("alt_id2_accept_oth_pat_ser_yn"),"N");
			alt_id2_chng_allowed_yn					= checkForNull(rs.getString("alt_id2_chng_allowed_yn"),"N");
			alt_id2_accept_alphanumeric_yn			= checkForNull(rs.getString("alt_id2_accept_alphanumeric_yn"),"N");
			alt_id3_accept_oth_pat_ser_yn			= checkForNull(rs.getString("alt_id3_accept_oth_pat_ser_yn"),"N");
			alt_id3_chng_allowed_yn					= checkForNull(rs.getString("alt_id3_chng_allowed_yn"),"N");
			alt_id3_accept_alphanumeric_yn			= checkForNull(rs.getString("alt_id3_accept_alphanumeric_yn"),"N");
			alt_id4_accept_oth_pat_ser_yn			= checkForNull(rs.getString("alt_id4_accept_oth_pat_ser_yn"),"N");
			alt_id4_chng_allowed_yn					= checkForNull(rs.getString("alt_id4_chng_allowed_yn"),"N");
			alt_id4_accept_alphanumeric_yn			= checkForNull(rs.getString("alt_id4_accept_alphanumeric_yn"),"N");
			/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End */

			/*Added By Dharma against GHL-CRF-0524.1 [IN:068022] on 25th July 2108 Start */
			alt_id1_alphanum_validate_yn			= checkForNull(rs.getString("alt_id1_alphanum_validate_yn"),"N");
			alt_id2_alphanum_validate_yn			= checkForNull(rs.getString("alt_id2_alphanum_validate_yn"),"N");
			alt_id3_alphanum_validate_yn			= checkForNull(rs.getString("alt_id3_alphanum_validate_yn"),"N");
			alt_id4_alphanum_validate_yn			= checkForNull(rs.getString("alt_id4_alphanum_validate_yn"),"N");
			
			if(isStartWith){
			alt_id1_start_with			= checkForNull(rs.getString("alt_id1_start_with"));
			alt_id2_start_with			= checkForNull(rs.getString("alt_id2_start_with"));
			alt_id3_start_with			= checkForNull(rs.getString("alt_id3_start_with"));
			alt_id4_start_with			= checkForNull(rs.getString("alt_id4_start_with"));
			}
		
			
			upd_pat_dtls_referral_yn				= checkForNull(rs.getString("UPD_PAT_DTLS_REFERRAL_YN"),"N");

			id_change_allowed_for_series = rs.getString("id_change_allowed_for_series")==null?"":rs.getString("id_change_allowed_for_series");

            ext_system_interface_yn = rs.getString("ext_system_interface_yn")==null?"N":rs.getString("ext_system_interface_yn");
		
			disp_cancelled_previous_enc_yn				= checkForNull(rs.getString("disp_cancel_prev_enc_yn"),"Y"); 
			occupation_reqd_yn			           = checkForNull(rs.getString("occupation_reqd_yn"),"N");
			marital_status_reqd_yn			       = checkForNull(rs.getString("marital_status_reqd_yn"),"N");
			mand_visit_admssn_reg_yn			       = checkForNull(rs.getString("mand_visit_admssn_reg_yn"),"N");
			
			unmask_aadhaar_num_yn   = checkForNull(rs.getString("UNMASK_AADHAR_NO"),"N"); 	
			
			unmask_abha_num_addr_yn   = checkForNull(rs.getString("UNMASK_ABHA_NO_ADDRESS"),"N"); 

			//if(ext_system_interface_yn.equals("N"))	
			//{
				if (id_change_allowed_for_series.equals("N"))
				  {
					col1="selected";
					col2="";
					col3="";
					//dis_id_chg_all_ser = "";
				  }
				else if (id_change_allowed_for_series.equals("A"))
				  {
					col2="selected";
					col1="";
					col3="";
					//dis_id_chg_all_ser = "";
				  }
				else if (id_change_allowed_for_series.equals("B"))
				  {
					col3="selected";
					col1="";
					col2="";
					//dis_id_chg_all_ser = "";
				  }
				  /*
			}
			
			else if(ext_system_interface_yn.equals("Y"))
			{
				dis_id_chg_all_ser = "disabled";
				//col4="selected";
			}
			*/

		  
            alt_id1_adv_alert_reqd_yn = rs.getString("alt_id1_adv_alert_reqd_yn")==null?"N":rs.getString("alt_id1_adv_alert_reqd_yn");
            if (alt_id1_adv_alert_reqd_yn.equals("Y"))
                chk1 = "Checked";
            else if (alt_id1_adv_alert_reqd_yn.equals("N"))
                chk1 = "";

            alt_id1_adv_alert_days   = rs.getInt( "alt_id1_adv_alert_days") + ""  ;
            alt_id2_adv_alert_reqd_yn = rs.getString("alt_id2_adv_alert_reqd_yn")==null?"N":rs.getString("alt_id2_adv_alert_reqd_yn");
            if (alt_id2_adv_alert_reqd_yn.equals("Y"))
                chk2 = "Checked";
            else if (alt_id2_adv_alert_reqd_yn.equals("N"))
                chk2 = "";

            alt_id2_adv_alert_days   = rs.getInt( "alt_id2_adv_alert_days") + ""  ;
            alt_id3_adv_alert_reqd_yn = rs.getString("alt_id3_adv_alert_reqd_yn")==null?"N":rs.getString("alt_id3_adv_alert_reqd_yn");
            if (alt_id3_adv_alert_reqd_yn.equals("Y"))
                chk3 = "Checked";
            else if (alt_id3_adv_alert_reqd_yn.equals("N"))
                chk3 = "";
			
            alt_id3_adv_alert_days   = rs.getInt( "alt_id3_adv_alert_days") + ""  ;
            alt_id4_adv_alert_reqd_yn = rs.getString("alt_id4_adv_alert_reqd_yn")==null?"N":rs.getString("alt_id4_adv_alert_reqd_yn");
            if (alt_id4_adv_alert_reqd_yn.equals("Y"))
                chk4 = "Checked";
            else if (alt_id4_adv_alert_reqd_yn.equals("N"))
                chk4 = "";

            alt_id4_adv_alert_days   = rs.getInt( "alt_id4_adv_alert_days") + ""  ;
            terminal_digit_reqd_yn = rs.getString("terminal_digit_reqd_yn")==null?"N":rs.getString("terminal_digit_reqd_yn");
            if  (terminal_digit_reqd_yn.equals("Y"))
                terminal="Checked";
            else if (terminal_digit_reqd_yn.equals("N"))
                terminal="";
            
            terminal_digit_count = rs.getString("terminal_digit_count")==null?"0":rs.getString("terminal_digit_count");
			
             if (terminal_digit_count.equals("0"))
              {
                dig0="Selected";
              }
            else if (terminal_digit_count.equals("3"))
              {
                dig3="Selected";
              }
            else if (terminal_digit_count.equals("4"))
              {
                dig4="Selected";
              }
            else if (terminal_digit_count.equals("5"))
              {
                dig5="Selected";
              }
		
            terminal_digit1_position = rs.getString("terminal_digit1_position")==null?"":rs.getString("terminal_digit1_position");
            terminal_digit2_position = rs.getString("terminal_digit2_position")==null?"":rs.getString("terminal_digit2_position");
            terminal_digit3_position = rs.getString("terminal_digit3_position")==null?"":rs.getString("terminal_digit3_position");
            terminal_digit4_position = rs.getString("terminal_digit4_position")==null?"":rs.getString("terminal_digit4_position");
            terminal_digit5_position = rs.getString("terminal_digit5_position")==null?"":rs.getString("terminal_digit5_position");

            addl_field1_prompt = rs.getString("addl_field1_prompt")==null?"":rs.getString("addl_field1_prompt");
            addl_field1_length = rs.getString("addl_field1_length")==null?"":rs.getString("addl_field1_length");
            addl_field1_section = rs.getString("addl_field1_section")==null?"":rs.getString("addl_field1_section");
        
             if (addl_field1_section.equals(""))
              {
                sec11="Selected";
              }
            else if (addl_field1_section.equals("D"))
              {
                sec12="Selected";
              }
            else if (addl_field1_section.equals("C"))
              {
                sec13="Selected";
              }
            else if (addl_field1_section.equals("N"))
              {
                sec14="Selected";
              }
            else if (addl_field1_section.equals("E"))
              {
                sec15="Selected";
              }
            else if (addl_field1_section.equals("O"))
              {
                sec16="Selected";
              }
			  else if (addl_field1_section.equals("F"))
              {
				sec57="Selected";
              }

         
            addl_field2_prompt = rs.getString("addl_field2_prompt")==null?"":rs.getString("addl_field2_prompt");
            addl_field2_length = rs.getString("addl_field2_length")==null?"":rs.getString("addl_field2_length");
            addl_field2_section = rs.getString("addl_field2_section")==null?"":rs.getString("addl_field2_section");

             if (addl_field2_section.equals(""))
              {
                sec21="Selected";
              }
            else if (addl_field2_section.equals("D"))
              {
                sec22="Selected";
              }
            else if (addl_field2_section.equals("C"))
              {
                sec23="Selected";
              }
            else if (addl_field2_section.equals("N"))
              {
                sec24="Selected";
              }
            else if (addl_field2_section.equals("E"))
              {
                sec25="Selected";
              }
            else if (addl_field2_section.equals("O"))
              {
                sec26="Selected";
              }
			  else if (addl_field2_section.equals("F"))
              {
				sec58="Selected";
              }
			
            addl_field3_prompt = rs.getString("addl_field3_prompt")==null?"":rs.getString("addl_field3_prompt");
            addl_field3_length = rs.getString("addl_field3_length")==null?"":rs.getString("addl_field3_length");
            addl_field3_section = rs.getString("addl_field3_section")==null?"":rs.getString("addl_field3_section");
             if (addl_field3_section.equals(""))
              {
                sec31="Selected";
              }
            else if (addl_field3_section.equals("D"))
              {
                sec32="Selected";
              }
            else if (addl_field3_section.equals("C"))
              {
                sec33="Selected";
              }
            else if (addl_field3_section.equals("N"))
              {
                sec34="Selected";
              }
            else if (addl_field3_section.equals("E"))
              {
                sec35="Selected";
              }
            else if (addl_field3_section.equals("O"))
              {
                sec36="Selected";
              }
              else if (addl_field3_section.equals("F"))
              {
				sec59="Selected";
              }
            addl_field4_prompt = rs.getString("addl_field4_prompt")==null?"":rs.getString("addl_field4_prompt");
            addl_field4_length = rs.getString("addl_field4_length")==null?"":rs.getString("addl_field4_length");
            addl_field4_section = rs.getString("addl_field4_section")==null?"":rs.getString("addl_field4_section");

             if (addl_field4_section.equals(""))
              {
                sec41="Selected";
              }
            else if (addl_field4_section.equals("D"))
              {
                sec42="Selected";
              }
            else if (addl_field4_section.equals("C"))
              {
                sec43="Selected";
              }
            else if (addl_field4_section.equals("N"))
              {
                sec44="Selected";
              }
            else if (addl_field4_section.equals("E"))
              {
                sec45="Selected";
              }
            else if (addl_field4_section.equals("O"))
              {
                sec46="Selected";
              }
			  else if (addl_field4_section.equals("F"))
              {
				sec60="Selected";
              }
           
            addl_field5_prompt = rs.getString("addl_field5_prompt")==null?"":rs.getString("addl_field5_prompt");
            addl_field5_length = rs.getString("addl_field5_length")==null?"":rs.getString("addl_field5_length");
            addl_field5_section = rs.getString("addl_field5_section")==null?"":rs.getString("addl_field5_section");

             if (addl_field5_section.equals(""))
              {
                sec51="Selected";
              }
            else if (addl_field5_section.equals("D"))
              {
                sec52="Selected";
              }
            else if (addl_field5_section.equals("C"))
              {
                sec53="Selected";
              }
            else if (addl_field5_section.equals("N"))
              {
                sec54="Selected";
              }
            else if (addl_field5_section.equals("E"))
              {
                sec55="Selected";
              }
            else if (addl_field5_section.equals("O"))
              {
                sec56="Selected";
              }
			  else if (addl_field5_section.equals("F"))
              {
				sec61="Selected";
              }
			if(isStartWith){  
            start_with = rs.getString("start_id_with")==null?"":rs.getString("start_id_with"); //Added By Gaurav Aginst MMS-MEA-CRF-0004
			}
            nat_prompt = rs.getString("nat_id_prompt")==null?"":rs.getString("nat_id_prompt");
            nat_reqd_for_all_ser = rs.getString("nat_id_reqd_all_series")==null?"N":rs.getString("nat_id_reqd_all_series");
            nat_id_routine_name  = rs.getString("nat_data_source_id")==null?"":rs.getString("nat_data_source_id");
            nat_chk_dig_scheme  = rs.getString("nat_id_check_digit_id")==null?"":rs.getString("nat_id_check_digit_id");
            chk_len  = rs.getString("nat_id_chk_len")==null?"N":rs.getString("nat_id_chk_len");
            nat_invoke_routine   = rs.getString("invoke_routine")==null?"N":rs.getString("invoke_routine");

			accept_national_id_no_yn  = rs.getString("accept_national_id_no_yn")==null?"N":rs.getString("accept_national_id_no_yn");

			if (alt_id1_accept_alphanumeric_yn.equals("Y"))
				chkdisAcceptAlphanumeric = "Checked disabled";
			else
				chkdisAcceptAlphanumeric = "disabled";
			
			if (alt_id1_accept_oth_pat_ser_yn.equals("Y"))
				chkdisAcceptothpatser = "Checked disabled";
			else
				chkdisAcceptothpatser = "disabled";

			if (accept_national_id_no_yn.equals("Y"))
				chkAcceptNat = "Checked disabled";
			else
				chkAcceptNat = "disabled";

			max_patient_age = rs.getString("max_patient_age")==null?"":rs.getString("max_patient_age");
	
			min_weight = rs.getString("min_weight")==null?"":rs.getString("min_weight");
			max_weight = rs.getString("max_weight")==null?"":rs.getString("max_weight");
			min_length = rs.getString("min_length")==null?"":rs.getString("min_length");
			max_length = rs.getString("max_length")==null?"":rs.getString("max_length");
			min_head_circum = rs.getString("min_head_circum")==null?"":rs.getString("min_head_circum");
			max_head_circum = rs.getString("max_head_circum")==null?"":rs.getString("max_head_circum");
			min_chest_circum = rs.getString("min_chest_circum")==null?"":rs.getString("min_chest_circum");
			max_chest_circum = rs.getString("max_chest_circum")==null?"":rs.getString("max_chest_circum");
			min_gestation = rs.getString("min_gestation")==null?"":rs.getString("min_gestation");
			max_gestation = rs.getString("max_gestation")==null?"":rs.getString("max_gestation");
			gestation_two_del = rs.getString("nb_min_gest_bet_2_dely")==null?"":rs.getString("nb_min_gest_bet_2_dely");
			name_prefix_length = rs.getString("name_prefix_length")==null?"":rs.getString("name_prefix_length");
			first_name_length = rs.getString("first_name_length")==null?"":rs.getString("first_name_length");
			second_name_length = rs.getString("second_name_length")==null?"":rs.getString("second_name_length");
			third_name_length = rs.getString("third_name_length")==null?"":rs.getString("third_name_length");
			family_name_length = rs.getString("family_name_length")==null?"":rs.getString("family_name_length");
			name_suffix_length = rs.getString("name_suffix_length")==null?"":rs.getString("name_suffix_length");
			alt_id1_chng_allowed_yn = rs.getString("alt_id1_chng_allowed_yn")==null?"N":rs.getString("alt_id1_chng_allowed_yn");
			accept_pw_in_chng_pat_dtl_yn = rs.getString("accept_pw_in_chng_pat_dtl_yn")==null?"N":rs.getString("accept_pw_in_chng_pat_dtl_yn");


			dflt_language_id  = rs.getString("DFLT_LANGUAGE_ID")==null?"":rs.getString("DFLT_LANGUAGE_ID");
			dflt_relgn_code  = rs.getString("DFLT_RELGN_CODE")==null?"":rs.getString("DFLT_RELGN_CODE");
			inv_pat_search_in_reg_pat_yn  = rs.getString("INV_PAT_SEARCH_IN_REG_PAT_YN")==null?"N":rs.getString("INV_PAT_SEARCH_IN_REG_PAT_YN");
			race_required_yn  = rs.getString("RACE_REQUIRED_YN")==null?"N":rs.getString("RACE_REQUIRED_YN");
			round_dob_estd_age  = rs.getString("round_dob_estd_age")==null?"N":rs.getString("round_dob_estd_age");
			name_pfx_reqd_for_org_mem_yn  = rs.getString("name_pfx_reqd_for_org_mem_yn")==null?"N":rs.getString("name_pfx_reqd_for_org_mem_yn");

			nat_id_accept_alphanumeric_yn  = rs.getString("nat_id_accept_alphanumeric_yn")==null?"N":rs.getString("nat_id_accept_alphanumeric_yn");
			/*alt_id2_accept_alphanumeric_yn = rs.getString("alt_id2_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id2_accept_alphanumeric_yn");
			alt_id3_accept_alphanumeric_yn = rs.getString("alt_id3_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id3_accept_alphanumeric_yn");
			alt_id4_accept_alphanumeric_yn = rs.getString("alt_id4_accept_alphanumeric_yn")==null?"N":rs.getString("alt_id4_accept_alphanumeric_yn");*/
			//Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
			//Start
			mortuary_release_yn=rs.getString("CANCEL_ONLY_FOR_MO_PATIENTS_YN")==null?"N":rs.getString("CANCEL_ONLY_FOR_MO_PATIENTS_YN");
			no_days_before_deceased=rs.getString("CANCEL_CUT_OFF_PERIOD_IN_DAYS")==null?"":rs.getString("CANCEL_CUT_OFF_PERIOD_IN_DAYS");
			cancel_reason_code=rs.getString("CANCEL_REASON_CODE")==null?"":rs.getString("CANCEL_REASON_CODE");
			//End
// Newly added against GHL-CRF-0312 [IN:039856] By saanthaakumar
country_reqd_yn  	= rs.getString("COUNTRY_REQD_YN")==null?"N":rs.getString("COUNTRY_REQD_YN");
region_reqd_yn		= rs.getString("REGION_REQD_YN")==null?"N":rs.getString("REGION_REQD_YN");
mobile_no_reqd_yn	= rs.getString("MOBILE_NO_REQD_YN")==null?"N":rs.getString("MOBILE_NO_REQD_YN");
// Newly added against KDAH-CRF-0273 [IN:045012]  By saanthaakumar
email_id_reqd_yn	= rs.getString("EMAIL_ID_REQD_YN")==null?"N":rs.getString("EMAIL_ID_REQD_YN");
// Newly added against AMRI-CRF-0388  By SHAGAR
postal_cd_reqd_yn	= rs.getString("postal_cd_reqd_yn")==null?"N":rs.getString("postal_cd_reqd_yn");
area_reqd_yn	= rs.getString("area_reqd_yn")==null?"N":rs.getString("area_reqd_yn");
//Below added by Mano ML-MMOH-CRF-0736
religion_reqd_yn    = rs.getString("RELIGION_REQD_YN")==null?"N":rs.getString("RELIGION_REQD_YN");
patientcategory_reqd_yn	= rs.getString("PAT_CATEGORY_REQD_YN")==null?"N":rs.getString("PAT_CATEGORY_REQD_YN"); //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
town_reqd_yn	= rs.getString("TOWN_REQD_YN")==null?"N":rs.getString("TOWN_REQD_YN"); //Added by Suji keerthi on 19-Nov-2019 for KDAH-CRF-0522
pat_ser_access_by_user_yn	= rs.getString("pat_ser_access_by_user_yn")==null?"N":rs.getString("pat_ser_access_by_user_yn");//added for MO-CRF-20074
death_reg_form_req_yn = rs.getString("ENBL_DEATH_REG_FORM_DECEASED") == null? "N" : rs.getString("ENBL_DEATH_REG_FORM_DECEASED");//Added by Ajay hatwate for AAKH-CRF-0179 on 14/08/2023
	abha_eng_audio_path=rs.getString("ABHA_ENG_AUDIO_PATH")==null?"":rs.getString("ABHA_ENG_AUDIO_PATH");
	abha_hin_audio_path=rs.getString("ABHA_HIN_AUDIO_PATH")==null?"":rs.getString("ABHA_HIN_AUDIO_PATH");
       }
		
    }
          /*out.println("<script>alert('name_prefix_length:"+name_prefix_length+"');</script>");
          out.println("<script>alert('first_name_length:"+first_name_length+"');</script>");
          out.println("<script>alert('second_name_length:"+second_name_length+"');</script>");
          out.println("<script>alert('third_name_length:"+third_name_length+"');</script>");
          out.println("<script>alert('family_name_length:"+family_name_length+"');</script>");
          out.println("<script>alert('name_suffix_length:"+name_suffix_length+"');</script>");*/

    if ( module_id                     == null ) module_id                     = "" ;
    if ( patient_id_length             == null ) patient_id_length             = "" ;
    if (( patient_no_ctrl               == null )||(patient_no_ctrl == "") )patient_no_ctrl               = "Z" ;
    if ( gen_pat_ser_grp               == null ) gen_pat_ser_grp               = "" ;
    if ( nat_id_pat_ser_grp            == null ) nat_id_pat_ser_grp            = "" ;
    if ( alt_id_pat_ser_grp            == null ) alt_id_pat_ser_grp            = "" ;
    if ( family_no_pat_ser_grp         == null ) family_no_pat_ser_grp         = "" ;
    if ( dflt_pat_ser_grp_type         == null ) dflt_pat_ser_grp_type         = "" ;
    if ( emeg_pat_ser_grp              == null ) emeg_pat_ser_grp              = "" ;
    if ( newborn_pat_ser_grp           == null ) newborn_pat_ser_grp           = "" ;
    if ( nat_id_length                 == null ) nat_id_length                 = "" ;
    if ( name_dervn_logic              == null ) name_dervn_logic              = "PR+< , >+FN" ;
    if ( name_dervn_logic_oth_lang     == null ) name_dervn_logic_oth_lang     = "" ;
	
	if ( name_dervn_logic_long              == null ) name_dervn_logic_long              = "" ;
    if ( name_dervn_logic_oth_lang_long     == null ) name_dervn_logic_oth_lang_long     = "" ;

	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
    if ( name_dervn_logic_nb == null ) name_dervn_logic_nb = "" ;
	//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1
    if ( name_dervn_logic_nb_sb == null ) name_dervn_logic_nb_sb = "" ;


    if ( dflt_patient_name     == null ) dflt_patient_name     = "" ;
	if ( dft_national_id     == null ) dft_national_id     = "" ;
    if ( ethnic_sndx_type              == null ) ethnic_sndx_type              = "U" ;
    if ( family_no_link_yn             == null ) family_no_link_yn             = "N" ;
    if ( head_patient_no_use_yn        == null ) head_patient_no_use_yn        = "N" ;
    if ( family_org_id_accept_yn       == null ) family_org_id_accept_yn       = "N" ;
    if ( citizen_nationality_code      == null ) citizen_nationality_code      = "" ;
	if ( default_race_code			   == null ) default_race_code		       = "" ;
	if ( default_relationship_code			   == null ) default_relationship_code		       = "" ;
    if ( general_alert_yn              == null ) general_alert_yn              = "N" ;
    if ( suspend_service_yn            == null ) suspend_service_yn            = "N" ;
    //if ( single_or_multi_files_ind     == null ) single_or_multi_files_ind     = "S" ;
    if ( separate_file_no_yn           == null ) separate_file_no_yn           = "N" ;
    if ( ext_system_interface_yn       == null ) ext_system_interface_yn       = "N" ;
    // Added
	
	if(pat_name_as_multipart_yn		== null) pat_name_as_multipart_yn		= "N";
	// End 
	if(acpt_appt_rfrl_in_reg_pat_yn == null) acpt_appt_rfrl_in_reg_pat_yn   = "N";
	if(dflt_alt_id1_in_emp_id_yn    == null) dflt_alt_id1_in_emp_id_yn       = "N";
	if ( name_prefix_accept_yn         == null ) name_prefix_accept_yn         = "N" ;
	if ( (entitlement_by_pat_cat_yn  == null ) || ( entitlement_by_pat_cat_yn  == "" ) ) entitlement_by_pat_cat_yn         = "N" ;
	if ( mapped_alt_id_org_member_id     == null ) mapped_alt_id_org_member_id  = "" ;
	if ( name_prefix_reqd_yn           == null ) name_prefix_reqd_yn           = "N" ;
    if ( name_prefix_prompt            == null ) name_prefix_prompt            = "" ;
    if ( name_prefix_loc_lang_prompt   == null ) name_prefix_loc_lang_prompt            = "" ;
    if ( first_name_accept_yn          == null ) first_name_accept_yn          = "N" ;
    if ( first_name_reqd_yn            == null ) first_name_reqd_yn            = "N" ;
    if ( first_name_order              == null ) first_name_order              = "" ;
    if ( first_name_prompt             == null ) first_name_prompt             = "" ;
    if ( first_name_loc_lang_prompt    == null ) first_name_loc_lang_prompt             = "" ;
    if ( second_name_accept_yn         == null ) second_name_accept_yn         = "N" ;
    if ( second_name_reqd_yn           == null ) second_name_reqd_yn           = "N" ;
    if ( second_name_order             == null ) second_name_order             = "" ;
    if ( second_name_prompt            == null ) second_name_prompt            = "" ;
    if ( second_name_loc_lang_prompt    == null ) second_name_loc_lang_prompt             = "" ;
    if ( third_name_accept_yn          == null ) third_name_accept_yn          = "N" ;
    if ( third_name_reqd_yn            == null ) third_name_reqd_yn            = "N" ;
    if ( third_name_order              == null ) third_name_order              = "" ;
    if ( third_name_prompt             == null ) third_name_prompt             = "" ;
    if ( third_name_loc_lang_prompt    == null ) third_name_loc_lang_prompt             = "" ;
    if ( family_name_accept_yn         == null ) family_name_accept_yn         = "N" ;
    if ( family_name_reqd_yn           == null ) family_name_reqd_yn           = "N" ;
    if ( family_name_order             == null ) family_name_order             = "" ;
    if ( family_name_prompt            == null ) family_name_prompt            = "" ;
    if ( family_name_loc_lang_prompt    == null ) family_name_loc_lang_prompt             = "" ;
    if ( family_name_prefix_yn         == null ) family_name_prefix_yn         = "N" ;
    if ( name_suffix_accept_yn         == null ) name_suffix_accept_yn         = "N" ;
    if ( name_suffix_reqd_yn           == null ) name_suffix_reqd_yn           = "N" ;
    if ( name_suffix_prompt            == null ) name_suffix_prompt            = "" ;
    if ( name_suffix_loc_lang_prompt   == null ) name_suffix_loc_lang_prompt            = "" ;
    if ( names_in_oth_lang_yn          == null ) names_in_oth_lang_yn          = "N" ;
    if ( dflt_sndx_type                == null ) dflt_sndx_type                = "" ;
    if ( dflt_coded_pseudo_name        == null ) dflt_coded_pseudo_name        = "" ;
    if ( alt_id1_type                  == null ) alt_id1_type                  = "" ;
    if ( alt_id1_length                == null ) alt_id1_length                = "" ;
    if ( alt_id1_chk_digit_scheme      == null ) alt_id1_chk_digit_scheme      = "" ;
    if ( alt_id1_reqd_yn               == null ) alt_id1_reqd_yn               = "N" ;
    if ( alt_id1_unique_yn             == null ) alt_id1_unique_yn             = "N" ;
    if ( alt_id1_exp_warn_yn           == null ) alt_id1_exp_warn_yn           = "N" ;
    if ( alt_id1_exp_grace_days        == null ) alt_id1_exp_grace_days        = "" ;
    if ( alt_id2_type                  == null ) alt_id2_type                  = "" ;
    if ( alt_id2_length                == null ) alt_id2_length                = "" ;
    if ( alt_id2_chk_digit_scheme      == null ) alt_id2_chk_digit_scheme      = "" ;
	if ( alt_id2_reqd_yn               == null ) alt_id2_reqd_yn               = "N" ;
    if ( alt_id2_unique_yn             == null ) alt_id2_unique_yn             = "N" ;
    if ( alt_id2_exp_warn_yn           == null ) alt_id2_exp_warn_yn           = "N" ;
    if ( alt_id2_exp_grace_days        == null ) alt_id2_exp_grace_days        = "" ;
    if ( alt_id3_type                  == null ) alt_id3_type                  = "" ;
    if ( alt_id3_length                == null ) alt_id3_length                = "" ;
    if ( alt_id3_chk_digit_scheme      == null ) alt_id3_chk_digit_scheme      = "" ;
    if ( alt_id3_reqd_yn               == null ) alt_id3_reqd_yn               = "N" ;
    if ( alt_id3_unique_yn             == null ) alt_id3_unique_yn             = "N" ;
    if ( alt_id3_exp_warn_yn           == null ) alt_id3_exp_warn_yn           = "N" ;
    if ( alt_id3_exp_grace_days        == null ) alt_id3_exp_grace_days        = "" ;
    if ( alt_id4_type                  == null ) alt_id4_type                  = "" ;
    if ( alt_id4_length                == null ) alt_id4_length                = "" ;
    if ( alt_id4_chk_digit_scheme      == null ) alt_id4_chk_digit_scheme      = "" ;
    if ( alt_id4_reqd_yn               == null ) alt_id4_reqd_yn               = "N" ;
    if ( alt_id4_unique_yn             == null ) alt_id4_unique_yn             = "N" ;
    if ( alt_id4_exp_warn_yn           == null ) alt_id4_exp_warn_yn           = "N" ;
    if ( alt_id4_exp_grace_days        == null ) alt_id4_exp_grace_days        = "" ;
    if ( family_no_prompt              == null ) family_no_prompt              = "" ;
    if ( pat_access_hist_no_rec        == null ) pat_access_hist_no_rec        = "" ;
    if ( pat_access_hist_bld_method    == null ) pat_access_hist_bld_method    = "" ;
    if ( dflt_contact_mode1            == null ) dflt_contact_mode1            = "PRN" ;
    if ( dflt_contact_mode2            == null ) dflt_contact_mode2            = "ORN" ;
    if ( dflt_contact_mode3            == null ) dflt_contact_mode3            = "" ;
    if ( dflt_contact_mode4            == null ) dflt_contact_mode4            = "" ;
    if ( dflt_contact_mode5            == null ) dflt_contact_mode5            = "" ;
    if ( dflt_addr_type1               == null ) dflt_addr_type1               = "RES" ;
    if ( dflt_addr_type2               == null ) dflt_addr_type2               = "MAI" ;
    if ( dflt_addr_type3               == null ) dflt_addr_type3               = "" ;
    if ( dflt_addr_type4               == null ) dflt_addr_type4               = "" ;
    if ( dflt_addr_type5               == null ) dflt_addr_type5               = "" ;
    if ( dflt_rel_contact_role1        == null ) dflt_rel_contact_role1        = "" ;
    if ( dflt_rel_contact_role2        == null ) dflt_rel_contact_role2        = "" ;
    if ( dflt_rel_contact_role3        == null ) dflt_rel_contact_role3        = "" ;
    if ( dflt_rel_contact_role4        == null ) dflt_rel_contact_role4        = "" ;
    if ( dflt_rel_contact_role5        == null ) dflt_rel_contact_role5        = "" ;
    if ( dflt_doc1_type                == null ) dflt_doc1_type                = "" ;
    if ( dflt_doc2_type                == null ) dflt_doc2_type                = "" ;
    if ( dflt_doc3_type                == null ) dflt_doc3_type                = "" ;
    if ( dflt_doc4_type                == null ) dflt_doc4_type                = "" ;
    if ( dflt_doc5_type                == null ) dflt_doc5_type                = "" ;
    if ( dflt_pat_fin_class            == null ) dflt_pat_fin_class            = "" ;
    if ( prompt_pat_fin_class_yn       == null ) prompt_pat_fin_class_yn       = "N" ;
    if ( min_age_of_moth       == null ) min_age_of_moth       = "" ;
   
	if ( max_age_of_moth       == null ) max_age_of_moth       = "" ;
    if ( cut_age_of_moth       == null ) cut_age_of_moth       = "" ;
    if ( dft_rel_male_nb       == null ) dft_rel_male_nb       = "" ;
    if ( dft_rel_unknown_nb       == null ) dft_rel_unknown_nb       = "" ;
    if ( dft_rel_female_nb       == null ) dft_rel_female_nb       = "" ;
    if ( allow_nb_regn_unit       == null ) allow_nb_regn_unit       = "H" ;
    if ( Accept_oth_alt_id_yn       == null ) Accept_oth_alt_id_yn       = "N" ;
           
    if ( min_age_of_fath       == null ) min_age_of_fath       = "" ;
    if ( allow_nb_regn_within_days     == null ) allow_nb_regn_within_days     = "" ;
	if ( mul_birth_regn_within_hours     == null ) mul_birth_regn_within_hours     = "" ;

    if ( unit_of_wt_nb                 == null ) unit_of_wt_nb                 = "" ;
    if ( unit_of_circum_nb             == null ) unit_of_circum_nb             = "" ;
    if ( unit_of_chest_circum_nb          == null ) unit_of_chest_circum_nb    = "" ;
    if ( unit_of_length_nb             == null ) unit_of_length_nb             = "" ;
    if ( unit_of_gest_nb               == null ) unit_of_gest_nb               = "" ;
    if ( sub_multi_birth_hw               == null ) sub_multi_birth_hw               = "H" ;
	if (( sub_multi_birth_hw == null )||(sub_multi_birth_hw == "") )sub_multi_birth_hw = "H" ;	
    if ( name_suffix_male_nb           == null ) name_suffix_male_nb           = "" ;
    if ( name_suffix_female_nb         == null ) name_suffix_female_nb         = "" ;
    
    if ( name_prefix_male_nb           == null ) name_prefix_male_nb           = "" ;
    if ( name_prefix_female_nb         == null ) name_prefix_female_nb         = "" ;
    if ( name_prefix_unknown_nb         == null ) name_prefix_unknown_nb         = "" ; //Added by Afruddin for ML-MMOH-CRF-1520 US001 on 4.05.2020
   
    if ( nb_father_name_mandatory_yn         == null ) nb_father_name_mandatory_yn			= "N" ;
	
	if(nb_father_name_mandatory_yn.equals("Y")) fatherValue = "Y";
	else fatherValue = "N";
    if ( nb_mother_dtls_update_yn         == null ) nb_mother_dtls_update_yn			= "N" ;
    if ( data_upd_allowed_aft_final_yn         == null ) data_upd_allowed_aft_final_yn		= "N" ;
   // if ( accept_names_for_live_birth_yn         == null ) accept_names_for_live_birth_yn    = "Y" ;
    if ( dflt_race_nat_setup_nb_as_per         == null ) dflt_race_nat_setup_nb_as_per      = "M" ;

    if ( review_nb_links_bef_reg_yn    == null ) review_nb_links_bef_reg_yn    = "N" ;
	
    if ( length_of_baby_yn    == null ) length_of_baby_yn    = "N" ;
    if ( head_circumference_of_baby_yn    == null ) head_circumference_of_baby_yn    = "N" ;
	
    if ( mandate_first_newborn_yn    == null ) mandate_first_newborn_yn    = "N" ;
    if ( mandate_first_newborn_ip_yn    == null ) mandate_first_newborn_ip_yn    = "N" ;
    if ( mandate_first_newborn_ae_yn    == null ) mandate_first_newborn_ae_yn    = "N" ;
    if ( mandate_second_newborn_yn    == null ) mandate_second_newborn_yn    = "N" ;
    if ( mandate_second_newborn_ip_yn    == null ) mandate_second_newborn_ip_yn    = "N" ;
    if ( mandate_second_newborn_ae_yn    == null ) mandate_second_newborn_ae_yn    = "N" ;
    if ( mandate_third_newborn_yn    == null ) mandate_third_newborn_yn    = "N" ;
    if ( mandate_third_newborn_ip_yn    == null ) mandate_third_newborn_ip_yn    = "N" ;
    if ( mandate_third_newborn_ae_yn    == null ) mandate_third_newborn_ae_yn    = "N" ;
    if ( mand_antenatal_newborn_yn    == null ) mand_antenatal_newborn_yn    = "N" ;
    if ( mand_antenatal_newborn_ip_yn    == null ) mand_antenatal_newborn_ip_yn    = "N" ;
    if ( mand_antenatal_newborn_ae_yn    == null ) mand_antenatal_newborn_ae_yn    = "N" ;
	
	if ( allow_ext_nb_regn_within_days    == null ) allow_ext_nb_regn_within_days    = "" ;
	if ( enable_marital_status    == null ) enable_marital_status    = "N" ;
    if ( dflt_father_first_name_prompt    == null ) dflt_father_first_name_prompt    = "N" ;
    if ( dflt_father_Second_name_prompt    == null ) dflt_father_Second_name_prompt    = "N" ;
    if ( dflt_father_third_name_prompt    == null ) dflt_father_third_name_prompt    = "N" ;
    if ( dflt_father_family_name_prompt    == null ) dflt_father_family_name_prompt    = "N" ;
	if	(enable_marital_status.equals("Y")) maritalValue = "Y";
	else maritalValue = "N";
    if ( single_stage_nb_reg_appl_yn    == null ) single_stage_nb_reg_appl_yn    = "N" ;
    if ( mod_birth_reg_appl_yn    == null ) mod_birth_reg_appl_yn    = "N" ; //Added by Prakash on 03rd Oct 2023 ML-MMOH-CRF-2046
  //  if ( invoke_chg_pat_dtls_fm_nb_yn    == null ) invoke_chg_pat_dtls_fm_nb_yn    = "N" ;
    if ( nb_use_mother_ser    == null ) nb_use_mother_ser    = "N" ;
    
    if ( search_threshold_records      == null ) search_threshold_records      = "" ;
    if ( sex_hist_yn                   == null ) sex_hist_yn                   = "N" ;
    if ( birth_date_hist_yn            == null ) birth_date_hist_yn            = "N" ;
    if ( legal_name_hist_yn            == null ) legal_name_hist_yn            = "N" ;
    if ( alias_name_hist_yn            == null ) alias_name_hist_yn            = "N" ;
    if ( coded_pseudo_name_hist_yn     == null ) coded_pseudo_name_hist_yn     = "N" ;
    if ( contact_no_hist_yn            == null ) contact_no_hist_yn            = "N" ;
    if ( address_hist_yn               == null ) address_hist_yn               = "N" ;
    if ( ocpn_n_empl_hist_yn           == null ) ocpn_n_empl_hist_yn           = "N" ;
    if ( general_alert_info_hist_yn    == null ) general_alert_info_hist_yn    = "N" ;
    if ( suspend_reinstate_hist_yn     == null ) suspend_reinstate_hist_yn     = "N" ;
    if ( inactivate_activate_hist_yn   == null ) inactivate_activate_hist_yn   = "N" ;
    if ( rec_revoke_death_hist_yn      == null ) rec_revoke_death_hist_yn      = "N" ;
    if ( added_by_id                   == null ) added_by_id                   = "" ;
    if ( added_date                    == null ) added_date                    = "" ;
    if ( added_at_ws_no                == null ) added_at_ws_no                = "" ;
    if ( modified_by_id                == null ) modified_by_id                = "" ;
    if ( modified_date                 == null ) modified_date                 = "" ;
    if ( modified_at_ws_no             == null ) modified_at_ws_no             = "" ;
    if ( hr_interface_yn               == null ) hr_interface_yn               = "N" ;
    if ( hr_check_digit_scheme         == null ) hr_check_digit_scheme         = "" ;
    if ( his_interface_yn              == null ) his_interface_yn              = "N" ;
    if ( age_limit_for_service       == null ) age_limit_for_service       = "" ;

	if ( alt_id1_len_validation_yn       == null )alt_id1_len_validation_yn    = "N" ;
    if ( alt_id2_len_validation_yn       == null ) alt_id2_len_validation_yn   = "N" ;
    if ( alt_id3_len_validation_yn       == null ) alt_id3_len_validation_yn   = "N" ;
    if ( alt_id4_len_validation_yn       == null ) alt_id4_len_validation_yn   = "N" ; 

    if ( alt_id1_exp_date_accept_yn      == null ) alt_id1_exp_date_accept_yn      = "N" ;
    if ( alt_id2_exp_date_accept_yn      == null ) alt_id2_exp_date_accept_yn      = "N" ;
    if ( alt_id3_exp_date_accept_yn      == null ) alt_id3_exp_date_accept_yn      = "N" ;
    if ( alt_id4_exp_date_accept_yn      == null ) alt_id4_exp_date_accept_yn      = "N" ;

    if ( alt_id1_invoke_routine       == null )alt_id1_invoke_routine    = "N" ;
    if ( alt_id2_invoke_routine       == null ) alt_id2_invoke_routine   = "N" ;
    if ( alt_id3_invoke_routine       == null ) alt_id3_invoke_routine   = "N" ;
    if ( alt_id4_invoke_routine       == null ) alt_id4_invoke_routine   = "N" ; 

    if ( alt_id1_routine_name      == null ) alt_id1_routine_name      = "" ;
    if ( alt_id2_routine_name      == null ) alt_id2_routine_name      = "" ;
    if ( alt_id3_routine_name      == null ) alt_id3_routine_name      = "" ;
    if ( alt_id4_routine_name      == null ) alt_id4_routine_name      = "" ;
    
    //ML-MMOH-CRF-1759.1-US001 starts
    if(mand_parity_newborn_ae_yn == null) mand_parity_newborn_ae_yn = "N";
    if(mand_parity_newborn_ip_yn == null) mand_parity_newborn_ip_yn = "N";
    if(mand_parity_newborn_yn == null) mand_parity_newborn_yn = "N";
    if(invoke_menstrual_history_yn==null) invoke_menstrual_history_yn="N";
    //ML-MMOH-CRF-1759.1-US001 ends
		if(pstmt != null) pstmt.close();
		if(rs != null) rs.close();


		pstmt = con.prepareStatement( "select count(*) as total from sm_language where language_direction='R' and eff_status='E'" ) ;
		
		rs = pstmt.executeQuery() ;
             
			
          if ( rs != null && rs.next() ) 
		  {
			count = rs.getInt("total");
		  }

		if ( count==1 ) 
		{
			 language_direction = "R" ;
		}else
		{
			 language_direction = "L" ;
		}

%>
	<Script>

				function expandCollapse(calledFrom) {					

					if(calledFrom == 'pat_admin_tab') {

						document.getElementById('PATADMIN').style.display = 'inline';
						document.getElementById('LNAMES').style.display = 'none';
						document.getElementById('ALTID').style.display = 'none';
						document.getElementById('NEWBORN').style.display = 'none';
						if(document.getElementById('AADHAAR'))
						document.getElementById('AADHAAR').style.display = 'none';

						document.getElementById('OTHERS').style.display = 'none';
						
					} else if(calledFrom == 'legal_names_tab') {

						document.getElementById('PATADMIN').style.display = 'none';
						document.getElementById('LNAMES').style.display = 'inline';
						document.getElementById('ALTID').style.display = 'none';
						document.getElementById('NEWBORN').style.display = 'none';
						document.getElementById('OTHERS').style.display = 'none';
						if(document.getElementById('AADHAAR')) 
						document.getElementById('AADHAAR').style.display = 'none';
						
					} else if(calledFrom == 'alt_id_chk_tab') {

						document.getElementById('PATADMIN').style.display = 'none';
						document.getElementById('LNAMES').style.display = 'none';
						document.getElementById('ALTID').style.display = 'inline';
						document.getElementById('NEWBORN').style.display = 'none';
						document.getElementById('OTHERS').style.display = 'none';
						if(document.getElementById('AADHAAR')) 
						document.getElementById('AADHAAR').style.display = 'none';
						
					} else if(calledFrom == 'new_born_tab') {

						document.getElementById('PATADMIN').style.display = 'none';
						document.getElementById('LNAMES').style.display = 'none';
						document.getElementById('ALTID').style.display = 'none';
						document.getElementById('NEWBORN').style.display = 'inline';
						document.getElementById('OTHERS').style.display = 'none';
						if(document.getElementById('AADHAAR')) 
						document.getElementById('AADHAAR').style.display = 'none';
						
					} else if(calledFrom == 'others_tab') {

						document.getElementById('PATADMIN').style.display = 'none';
						document.getElementById('LNAMES').style.display = 'none';
						document.getElementById('ALTID').style.display = 'none';
						document.getElementById('NEWBORN').style.display = 'none';
						document.getElementById('OTHERS').style.display = 'inline';
						if(document.getElementById('AADHAAR')) 
						document.getElementById('AADHAAR').style.display = 'none';
						
					}
					else if(calledFrom == 'aadhar_tab') {

						document.getElementById('PATADMIN').style.display = 'none';
						document.getElementById('LNAMES').style.display = 'none';
						document.getElementById('ALTID').style.display = 'none';
						document.getElementById('NEWBORN').style.display = 'none';
						document.getElementById('OTHERS').style.display = 'none';
						if(document.getElementById('AADHAAR')) 
						document.getElementById('AADHAAR').style.display = 'inline';
						
					}
				}

		function tab_click1(id) 
		{
			selectTab(id);
			if (id == 'pat_admin_tab')
			   parent.frames[1].tab1.scrollIntoView();         
			else if (id == 'legal_names_tab')
				parent.frames[1].tab4.scrollIntoView();
			else if (id == 'alt_id_chk_tab')
				parent.frames[1].tab5.scrollIntoView();
			else if (id == 'new_born_tab')
				parent.frames[1].tab7.scrollIntoView();
			else if(id == 'others_tab')
				{
			if(parent.frames[1].tab10)    
			parent.frames[1].tab10.scrollIntoView();
			}
			else if(id == 'aadhar_tab') //Added by PRITHIVI ON 10/05/2017 FOR KDAH-CRF-0362
			{
				if(parent.frames[1].tab11)    
		        parent.frames[1].tab11.scrollIntoView();
			}
		}
	function allowAlphaNumeric(UID)
		{
		UID.value=UID.value.split(/[^a-zA-Z0-9]/).join('');
		}
	</Script>
</head>
<body  onLoad="FocusFirstElement(); <%if(isStartWith){%>enableStartWith();<%}%> <%if(mpDisableFieldsNBFather){%>enableMarital('<%=fatherValue%>','<%=maritalValue%>');checkDefaultFather('<%=maritalValue%>')<%}%>" onSelect="codeArrestThruSelect()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<form name="mp_param_form" id="mp_param_form" method="post" action="../../servlet/eMP.MpParamServlet" 
target="messageFrame">
<input type="hidden" name="section0" id="section0" value=''>
<input type="hidden" name="section1" id="section1" value=''>
<input type="hidden" name="section2" id="section2" value=''>
<input type="hidden" name="section3" id="section3" value=''>
<input type="hidden" name="section4" id="section4" value=''>

<div id = 'PATADMIN'>

<table cellspacing='0' cellpadding='0' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" style="padding-left:0px;">
			 <li class="tablistitem" title='<fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/>'>
				<a class="tabClicked" id="pat_number_tab" >
					<span class="tabSpanclicked" id="pat_number_tabspan" onClick='javascript:expandCollapse("pat_admin_tab")'><fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/></span>
				</a>
			</li>		
			<li class="tablistitem" title='<fmt:message key="eMP.LegalNames.label" bundle="${mp_labels}"/>'>
				<a class="tabA" id="legal_names_tab" >
					<span class="tabAspan" id="legal_names_tabspan" onClick='javascript:expandCollapse("legal_names_tab")'><fmt:message key="eMP.LegalNames.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="eMP.AlternateIDChecks.label" bundle="${mp_labels}"/> '>
				<a class="tabA" id="alt_id_chk_tab" >
					<span class="tabAspan" id="alt_id_chk_tabspan" onClick='javascript:expandCollapse("alt_id_chk_tab")'><fmt:message key="eMP.AlternateIDChecks.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/>'>
				<a class="tabA" id="new_born_tab" >
					<span class="tabAspan" id="new_born_tabspan" onClick='javascript:expandCollapse("new_born_tab")'><fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="Common.others.label" bundle="${common_labels}"/>'>
				<a class="tabA" id="others_tab" >
					<span class="tabAspan" id="others_tabspan" onClick='javascript:expandCollapse("others_tab")'><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<% if("Y".equalsIgnoreCase(aadharProfileYN)) {%> <!-- Added by PRITHIVI ON 10/05/2017 FOR KDAH-CRF-0362 -->
	        <li class="tablistitem" title='Aadhaar Function Configuration'>
				<a class="tabA" id="aadhar_tab" >
					<span class="tabAspan" id="aadhar_tabspan" onClick='javascript:expandCollapse("aadhar_tab")'><fmt:message key="eXH.AADHAAR.label" bundle="${mp_labels}"/></span>
				</a>
			</li>
	<% } %>
			</ul>
	<script>prevTabObj='pat_admin_tab'</script>
 </td></tr>
</table>

<table border='0' cellpadding='2' cellspacing='0' width='100%'>
<tr><% if(module_instal_ind.equals("DMS")) { %>
				<td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.UM_PatientNumbering.label" bundle="${mp_labels}"/></td>
				<%} else { %>
			<td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.PatientNumbering.label" bundle="${mp_labels}"/></td>
			<%}%>			
			</tr>
                    <tr>
                        <% if(module_instal_ind.equals("DMS")) { %>
						<td width="25%" class="label"><fmt:message key="eMP.UM_PatientIDLength.label" bundle="${mp_labels}"/></td>
						<% } else {%>
						<td width="25%" class="label"><fmt:message key="eMP.PatientIDLength.label" bundle="${mp_labels}"/></td>
						<% }%>
						<td width="75%" colspan='3'>
						<TABLE>
						<TR>
						 <td width="23%" class="fields">
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='patient_id_length' id='patient_id_length' size='2' maxlength='2' value='" + patient_id_length + "' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);'>" ) ;
                            else if (operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='patient_id_length' id='patient_id_length' size='2' maxlength='2' value='" + patient_id_length + "' disabled>" ) ;
                        %>
                            <img src='../images/mandatory.gif'></img>
                        </td>
                        <td class="label" ><fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></td>

                        <td class="fields" ><%
                 
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( patient_no_ctrl.equals( "Z" ) )
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='Z' checked >"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Site.label","common_labels")+"&nbsp;" ) ;
                                else
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='Z'>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Site.label","common_labels")+"&nbsp;" ) ;

                                if ( patient_no_ctrl.equals( "U" ) )
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='U' checked >"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.facility.label","common_labels")+"&nbsp;" ) ;
                                else
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='U' >"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.facility.label","common_labels")+"&nbsp;" ) ;

                                if ( patient_no_ctrl.equals( "C" ) )
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='C' checked >"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Combination.label","mp_labels")+"&nbsp;" ) ;
                                else
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='C' >"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Combination.label","mp_labels")+"&nbsp;" ) ;
                                   
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( patient_no_ctrl.equals( "Z" ) )
                                    out.println("<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='Z' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Site.label","common_labels")+"&nbsp;" ) ;
                                else
                                    out.println( "<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='Z' disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Site.label","common_labels")+"&nbsp;" ) ;

                                if ( patient_no_ctrl.equals( "U" ) )
                                    out.println("<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='U' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.facility.label","common_labels")+"&nbsp;" ) ;
                                else
                                    out.println("<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='U' disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.facility.label","common_labels")+"&nbsp;" ) ;

                                if ( patient_no_ctrl.equals( "C" ) )
                                    out.println("<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='C' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Combination.label","mp_labels")+"&nbsp;" ) ;
                                else
                                    out.println("<input type='radio' name='patient_no_ctrl' id='patient_no_ctrl' value='C' disabled>"+com.ehis.util.BundleMessage.getBundleMessage( pageContext,"Common.by.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.Combination.label","mp_labels")+"&nbsp;" ) ;
                            }
                        %>
                        </td>
						</TR>		
						</TABLE >
						</td>
                    </tr>
					<tr>
					<td width="25%" class="label"><fmt:message key="eMP.AltID1RuleAppl.label" bundle="${mp_labels}"/></td>	
				

					 
					 <td class="fields" >
								   <%
										
									//CC
										if ( operation.equalsIgnoreCase( "insert" ) ) 
											{
													out.println("<input type='checkbox' name='gen_patid_using_altid_rl_yn' id='gen_patid_using_altid_rl_yn' value='N'              onclick=generateAltIDRule(this)>");
										}
										
													if(gen_pid_using_aid1_rule_yn.equals("Y"))
												{
										       single_patient_numbering_yn="N";
												}
										
										if(single_patient_numbering_yn.equals("Y")){
										gen_pid_using_aid1_rule_yn="N";
																					}
										
										if ( operation.equalsIgnoreCase( "modify" )) 
											{
													if(gen_pid_using_aid1_rule_yn.equals("Y"))
												
																								{
												out.println("<input type='checkbox' name='gen_patid_using_altid_rl_yn' id='gen_patid_using_altid_rl_yn' value='Y'  	   disabled checked					onclick=generateAltIDRule(this)>  ");
												}
												else 
								
								out.println("<input type='checkbox'   name='gen_patid_using_altid_rl_yn' id='gen_patid_using_altid_rl_yn' value='N'  disabled onclick=generateAltIDRule(this) >" ); 
									}
	                               
									%>
                                </td>
				                
					 

<td width="25%" class="label"><fmt:message key="eMP.SinglePatientNoAppl.label" bundle="${mp_labels}"/></td>	

<td class="fields" >

<%
										
									//CC
										if ( operation.equalsIgnoreCase( "insert" )) 
											{
													out.println("<input type='checkbox' name='single_patient_numbering_yn' value='N' onclick=generateSinglePatientNoAppl(this) ");
										}
										
										
										if ( operation.equalsIgnoreCase( "modify")) 
											{
													
													if(single_patient_numbering_yn.equals("Y"))
												
																								{
												
												out.println("<input type='checkbox' name='single_patient_numbering_yn' value='Y'  	   disabled checked ");
												}
												else 
								
								out.println("<input type='checkbox'   name='single_patient_numbering_yn' id='single_patient_numbering_yn' value='Y'  disabled>" ); 
									}
	                               
									%>





			 </td>

				 </TR>
				 

<td width="75%" colspan='3'>
					</tr>
					<tr>
						<td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.NationalIDChecks.label" bundle="${mp_labels}"/></td>
					</tr>

				   <tr>
                        <td class='label' width='25%'><fmt:message key="Common.Accept.label" bundle="${common_labels}"/></td>
						<td class="fields" width='25%'><input type='checkbox' name='accept_national_id_no_yn' id='accept_national_id_no_yn' value='Y' <%=chkAcceptNat%> onClick="enableNatFields(this,'Y')"></td>
						<td class='label' nowrap width='25%'><fmt:message key="Common.ExternalInterfaceRequired.label" bundle="${common_labels}"/></td>
                        
                        <%
                            String ext_intf_chked = "" ;
                          
                            if ( operation.equalsIgnoreCase( "modify" ) )
                            {
                                if(ext_system_interface_yn.equals("Y"))
                                    ext_intf_chked = "checked";
                            }
                        %>
						<!--
                        <td class="fields" width='25%'><input type='checkbox' name='ext_system_interface_yn' id='ext_system_interface_yn' value='Y'  <%=ext_intf_chked%> onclick='chk_chg_allowed_ser(this);'></td>
						-->
						<td class="fields" width='25%'><input type='checkbox' name='ext_system_interface_yn' id='ext_system_interface_yn' value='Y'  <%=ext_intf_chked%> ></td>
					</tr>
					</tr>
					<tr>
						<td class='label' width='25%'><fmt:message key="eMP.AcceptAlphanumeric.label" bundle="${mp_labels}"/></td>
						<td class="fields" width='25%'>
						<%
							
						/*if ( operation.equalsIgnoreCase( "modify" ) )
                        {
						if (nat_id_accept_alphanumeric_yn.equals("Y"))
							chkAcceptAlpha = "Checked disabled";
						}*/
						if ( operation.equalsIgnoreCase( "modify" ) )
                            {
                                if(nat_id_accept_alphanumeric_yn.equals("Y")) 
                                    chkAcceptAlpha = "checked" ;
                            }
                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println("<input type='checkbox' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value='Y' onclick='enaChkDigit(this);'>");
                            else if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println("<input type='checkbox' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value='Y' "+chkAcceptAlpha+" disabled >");

						%>
					
					<%if(isStartWith){%>
						</td>
						<td class='label' ><fmt:message key="eMP.StartWith.label" bundle="${mp_labels}"/></td>
                        <td class="fields" width='25%'>
                         <%
                        
						if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='start_with' id='start_with' id='start_with' value='' onBlur='chkStartWith(this.value,this.name)' maxlength='4' size='4'>" ) ;

                        if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='start_with' id='start_with' id='start_with' value=\""+start_with+"\" onBlur='chkStartWith(this.value,this.name)' maxlength='4' size='4'>" ) ;
                        %>
                        </td>
					<%}%>	
					
					</tr>
					<tr>
                        <td class='label' ><fmt:message key="Common.Prompt.label" bundle="${common_labels}"/></td>
                        <td class="fields">
                        <%
                        /*Modified by Ashwini on 18-Jan-2017 for ML-MMOH-CRF-0895*/
						if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='nat_prompt' id='nat_prompt' value='' maxlength='10' size='10' onBlur='makeValidString(this); removeSpace(this);'>" ) ;

                        if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='nat_prompt' id='nat_prompt' value=\""+nat_prompt+"\" onBlur='makeValidString(this); removeSpace(this);' maxlength='10' size='10' dis>" ) ;
                        %>
                        </td>
                        <td class="label" ><fmt:message key="Common.length.label" bundle="${common_labels}"/></td>
                        <td class="fields" nowrap >
                        <%
                       
						if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='nat_id_length' id='nat_id_length' size='2' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);checkNatIdLength();'>" ) ;

                            if ( operation.equalsIgnoreCase( "modify" ) )

                                out.println( "<input type='text' name='nat_id_length' id='nat_id_length' size='2' maxlength='2' value='" + nat_id_length + "' disabled>" ) ;
                        %>
                            <img src='../images/mandatory.gif' style='visibility:hidden;' name='nat_gif'></img>
                        </td>

                        

                       </tr>
                        
                        <tr>
                        <td class='label' nowrap><fmt:message key="eMP.RequiredforAllSeries.label" bundle="${mp_labels}"/></td>
                        
                        <%
                            String chked = "" ;
                          
                            if ( operation.equalsIgnoreCase( "modify" ) )
                            {
                                if(nat_reqd_for_all_ser.equals("Y"))
                                    chked = "checked";
                            }
                        %>

						<!-- Commented by Marimuthu for DLA Changes -->

						<!--
                        <td class="fields"><input type='checkbox' name='nat_reqd_for_all_ser' id='nat_reqd_for_all_ser' value='Y'  <%=chked%> onClick='series(this)'></td>
						-->

						<!-- End of Comment -->

						 <td class="fields"><input type='checkbox' name='nat_reqd_for_all_ser' id='nat_reqd_for_all_ser' value='Y' <%=chked%>></td>

						<td class='label' nowrap><fmt:message key="eMP.Changeallowedforseries.label" bundle="${mp_labels}"/></td>                        
                        <td	class="fields">
                            <select name='id_change_allowed_for_series' id='id_change_allowed_for_series'>
                                <option value='' >----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
								<%
									out.println("<Option value='N' "+col1+" >National ID series");
                                    out.println("<Option value='A' "+col2+">All series");
                                    out.println("<Option value='B' "+col3+">New Born");

									/* - Commented by Marimuthu for DLA Changes 

									
                                    if (nat_reqd_for_all_ser.equals("Y"))
                                    {
                                        {out.println("<Option value='N' "+col1+" >National ID series");}
                                        {out.println("<Option value='A' "+col2+">All series");}
                                        {out.println("<Option value='B' "+col3+">New Born");}
                                    }
                                    else
                                    {
                                        {out.println("<Option value='N' "+col1+" >National ID series");}
                                    } 
									

									End of Comment */
                                %>
                                </select>
                        </td>
                         
                    </tr>
                    <tr>
                        <td class='label'><fmt:message key="Common.Check.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.length.label" bundle="${common_labels}"/></td>
                        <td class="fields">
                        <%
                            chked="" ;
					
                            if ( operation.equalsIgnoreCase( "modify" ) )
                            {
                                if(chk_len.equals("Y")) 
                                    chked = "checked" ;
                            }
                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println("<input type='checkbox' name='chk_len' id='chk_len' value='Y'>");
                            else if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println("<input type='checkbox' name='chk_len' id='chk_len' value='Y' "+chked+" disabled >");
                        %>  
                        </td>
                       
                        <td class='label' nowrap><fmt:message key="eMP.CheckDigitScheme.label" bundle="${mp_labels}"/></td>
                        
                         <%
                            ArrayList chk_digit_code = new ArrayList();
                            ArrayList chk_digit_val = new ArrayList();
                            String sql ="select * from mp_check_digit_scheme where eff_status='E'";

                            stmt11 = con.createStatement() ;
                            rset11 = stmt11.executeQuery(sql) ;
							
				
							
                            if(rset11 != null)
                            {
                                while(rset11.next())
                                {
                                    chk_digit_code .add(rset11.getString("SCHEME_ID")) ;
                                    chk_digit_val  .add(rset11.getString("SCHEME_NAME")) ;
                                }
                            }
                        %>

                        <td class="fields">
                        <%
							if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<select name='nat_chk_dig_scheme' id='nat_chk_dig_scheme' disabled>" ) ;
						    if ( operation.equalsIgnoreCase( "insert" ) )
						          out.println( "<select name='nat_chk_dig_scheme' id='nat_chk_dig_scheme' >" ) ;
                           
                        %>
                                <option value=''>---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
                                <%
									for(int i=0;i<chk_digit_code.size();i++)
                                    {
										String sel = "" ;
                                        if(nat_chk_dig_scheme.equals((String)chk_digit_code.get(i)))
                                          sel = "selected";
										/* Only MOD 11 should be displayed */
                                        if (chk_digit_code.get(i).equals("M11")) 
										out.println( "<option value='"+chk_digit_code.get(i)+"' "+sel+">"+chk_digit_val.get(i)+"</option>" ) ;

										if (chk_digit_code.get(i).equals("M05")) 
										out.println( "<option value='"+chk_digit_code.get(i)+"' "+sel+">"+chk_digit_val.get(i)+"</option>" ) ;
                                    }								
                                %>
                            </select>
                        </td>
                    </tr>
                    
                        <!-- To fetch Routine Name  -->
                            <%
                                ArrayList routine_names = new ArrayList();
                                ArrayList routine_ids   = new ArrayList();
								if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
                                pstmt = con.prepareStatement("select initcap(ROUTINE_DESC)ROUTINE_NAME,DATASOURCE_ID from mp_custom_routine ");
                                
                                rs = pstmt.executeQuery();
								
                                while( rs.next() )
                                {
                                    routine_names.add(rs.getString("ROUTINE_NAME")) ;
                                    routine_ids.add(rs.getString("DATASOURCE_ID")) ;
                                }
                                if(pstmt != null)    pstmt.close();
                                if(rs != null)    rs.close();
								
                            %>
                        <!--Ends Here-->

                    <tr>
                        <%
                            chked="" ;
                            if ( operation.equalsIgnoreCase( "modify" ) )
                                if(nat_invoke_routine.equals("Y")) 
                                    chked = "checked" ;
                        %>

                        <td class='label' nowrap><fmt:message key="eMP.InvokeRoutine.label" bundle="${mp_labels}"/></td>
                        <td class="fields">
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println("<input type='checkbox' name='nat_invoke_routine' id='nat_invoke_routine' value='Y' onclick='chkRoutine(this,nat_id_routine_name)' >");
                            else if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println("<input type='checkbox' name='nat_invoke_routine' id='nat_invoke_routine' value='Y' "+chked+" disabled >");
                        %>
                        </td>
                        <td class='label' nowrap><fmt:message key="eMP.RoutineName.label" bundle="${mp_labels}"/></td>
                        <td class="fields">
                         <%
                           
						String disabled = "disabled";
                                if(nat_invoke_routine.equals("Y")) 
                                    disabled = "";
                                if ( operation.equalsIgnoreCase( "insert" ) )
                                    out.println("<select name='nat_id_routine_name' id='nat_id_routine_name' "+disabled+ " >");
                                else if ( operation.equalsIgnoreCase( "modify" ) )
                                    out.println("<select name='nat_id_routine_name' id='nat_id_routine_name' disabled >");
                         %>
                         <option value=''>----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------------</option>
                                <%

                        
									for(int i=0;i<routine_names.size();i++)
                                    {
                                        String sel = "" ;
                                        if(nat_id_routine_name.equals((String)routine_ids.get(i)) && disabled.equals("") )
                                            sel = "selected";
                                        
                                     if ( operation.equalsIgnoreCase( "insert" ) )
                                        {
                                           out.println("<option value='"+routine_ids.get(i)+"' "+sel+">"+routine_names.get(i)+"</option>") ;
                                        }

                                     else if( operation.equalsIgnoreCase( "modify" ) )
                                        {
                                           out.println("<option value='"+routine_ids.get(i)+"' "+sel+" >"+routine_names.get(i)+"</option>") ;
                                        }
                                   } 
                                %>
                            </select>
                        </td>
                        
                       
                        
                        
						<%if(isNatIdAltIdMandVisaType) {
							String enableDisableNatIdDft = "";
							if(dft_national_id.equals(""))
							enableDisableNatIdDft="";
							else
							enableDisableNatIdDft="disabled";							
							%>
						<tr>
						<td class='label' nowrap><fmt:message key="eMP.DftNationalID.label" bundle="${mp_labels}"/></td>
						<td class='fields'>
						<input type='text' name='dft_national_id' id='dft_national_id' id='UID' value='<%=dft_national_id%>' maxlength='20' onkeyup='allowAlphaNumeric(this)' <%=enableDisableNatIdDft%>></input>
                        
						 </td>
						 </tr>
						<%}%>
						
						 <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 UserStory1 Starts-->
                       <%  
                       
                       String disbled="disabled";
                      if(function_name.equals("01")){
                       		chked="" ;
                           if ( operation.equalsIgnoreCase( "modify" ) )
                               if(biometric_authentication_yn.equals("Y")) {
                                   chked = "checked" ;
                                   disbled="";
                               }
                       
                       %>
                        <tr>
	                         <td class='label' nowrap><fmt:message key="eMP.BiometricAuthentication.label" bundle="${mp_labels}"/></td>
	                        <td class="fields">
	                        <%
	                            if ( operation.equalsIgnoreCase( "insert" ) )
	                                out.println("<input type='checkbox' name='biometric_authentication' id='biometric_authentication' id='biometric_authentication' value='Y' "+chked+" >");
	                            else if ( operation.equalsIgnoreCase( "modify" ) )
	                                out.println("<input type='checkbox' name='biometric_authentication' id='biometric_authentication' id='biometric_authentication' value='Y' "+chked+" >");
	                        %>
	                        </td>
                        </tr>
                        
                       <% } %>
                        <!--Added by Himanshu Saxena on 03-July-2023 for AAKH-CRF-0175 US1 Ends-->
						 
                    </tr>

        <tr>
            <% if(module_instal_ind.equals("DMS")) { %>
		<td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.UM_PatientSeries.label" bundle="${mp_labels}"/></td>
        <%} else { %>
		<td class="COLUMNHEADER" colspan='4'><fmt:message key="eMP.PatientSeries.label" bundle="${mp_labels}"/></td>
		<%}%>
		</tr>

                    <tr >
                        <td class="label" ><fmt:message key="Common.general.label" bundle="${common_labels}"/></td>

                        <td class="fields"><select name="gen_pat_ser_grp" id="gen_pat_ser_grp" style='width: 175px'>
                            <option value =''>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------
                            <%

                                pstmt = con.prepareStatement( "select pat_ser_grp_code, short_Desc from mp_pat_ser_grp where id_type in('G','U') order by short_Desc" ) ;
                                rs = pstmt.executeQuery() ;
								
								
                                if( rs != null ) {
                                    while( rs.next() ) {
                                        String groupCode = rs.getString( "pat_ser_grp_code" ) ;
                                        String groupName = rs.getString( "short_Desc" ) ;

                                        if ( groupCode.equals( gen_pat_ser_grp ) )
                                            out.println( "<option selected value='" + groupCode + "' >"+ groupName ) ;
                                        else
                                            out.println( "<option value='" + groupCode + "' >" + groupName ) ;
                                    }
                                }

                                if(pstmt!=null) pstmt.close() ;
								if(rs!=null) rs.close();
                            %>
                            </select>
                        </td>
                        
                        <td class="label" ><fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/></td>

                        <td class="fields"><select name="newborn_pat_ser_grp" id="newborn_pat_ser_grp" style='width: 175px'>
                                <option value =''>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
                            <%
                                stmt = con.createStatement() ;
                                rset = stmt.executeQuery ( " select short_Desc, Pat_Ser_grp_Code from MP_PAT_SER_GRP where ID_Type in('B','U')  order by short_Desc" ) ;
								
								
                                if(rset != null)
                                {
                                    while(rset.next())
                                    {
                                        chked = "" ;
                                        
                                        if(newborn_pat_ser_grp.equals(rset.getString("Pat_Ser_grp_Code")))
                                            chked = "selected" ;
                                            out.println( "<option value='"+rset.getString("Pat_Ser_grp_Code")+"' "+chked+">"+rset.getString("Short_Desc")+"</option>" ) ; 
                                    }
                                }

                            %>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td class="label" nowrap><fmt:message key="eMP.WithNationalID.label" bundle="${mp_labels}"/></td>

                        <td class="fields"><select name="nat_id_pat_ser_grp" id="nat_id_pat_ser_grp" style='width: 175px'>
                            <option value =''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
                            <%

                                pstmt = con.prepareStatement( "select pat_ser_grp_code, short_Desc from mp_pat_ser_grp where id_type in('N','U') order by short_Desc" ) ;
                                rs = pstmt.executeQuery() ;
									
                                if( rs != null ) {
                                    while( rs.next() ) {
                                        String groupCode = rs.getString( "pat_ser_grp_code" ) ;
                                        String groupName = rs.getString( "short_Desc" ) ;

                                        if ( groupCode.equals( nat_id_pat_ser_grp ) )
                                            out.println( "<option selected value='" + groupCode + "' >"+ groupName ) ;
                                        else
                                            out.println( "<option value='" + groupCode + "' >" + groupName ) ;
                                    }
                                }

                                if(pstmt!=null) pstmt.close() ;
								if(rs!=null) rs.close();
                            %>
                            </select>
                        </td>
						<%
							if (accept_national_id_no_yn.equals("Y"))						
								out.println("<script>document.mp_param_form.nat_id_pat_ser_grp.disabed= false;</script>");
							else																			out.println("<script>document.mp_param_form.nat_id_pat_ser_grp.disabled=	true;</script>");
						%>	
							
                        <td class="label" ><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></td>

                        <td class="fields"><select name="emeg_pat_ser_grp" id="emeg_pat_ser_grp" style='width: 175px'>
                            <option value =''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
                            <%

                                rset = stmt.executeQuery ( " select short_Desc, Pat_Ser_grp_Code from MP_PAT_SER_GRP where ID_Type in('E','U') and GEN_PID_USING_ALT_ID1_RULE_YN='N'  order by short_Desc" ) ;
							
                                if(rset != null)
                                {                                   
                                    while(rset.next()) 
                                    {
                                        chked = "" ;
                                        if(emeg_pat_ser_grp.equals(rset.getString("Pat_Ser_grp_Code")))
                                            chked = "selected" ;
                                            out.println( "<option value='"+rset.getString("Pat_Ser_grp_Code")+"' "+chked+">"+rset.getString("Short_Desc")+"</option>" ) ; 
                                    }
                                }
                                if(stmt != null)    stmt.close();
                                if(rset != null)    rset.close();
                            %>
                            </select>
                        </td>
                        
                    </tr>

                    <tr >
                        <td class="label" nowrap><fmt:message key="eMP.WithAlternateID.label" bundle="${mp_labels}"/></td>

                        <td class="fields"><select name="alt_id_pat_ser_grp" id="alt_id_pat_ser_grp" style='width: 175px'>
                            <option value =''>--------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
                            <%

                                pstmt = con.prepareStatement( "select pat_ser_grp_code, short_Desc from mp_pat_ser_grp where id_type in('A','U') order by short_Desc" ) ;
                                rs = pstmt.executeQuery() ;
                          
                                if( rs != null ) {
                                    while( rs.next() ) {
                                        String groupCode = rs.getString( "pat_ser_grp_code" ) ;
                                        String groupName = rs.getString( "short_Desc" ) ;

                                        if ( groupCode.equals( alt_id_pat_ser_grp ) )
                                            out.println( "<option selected value='" + groupCode + "' >"+ groupName ) ;
                                        else
                                            out.println( "<option value='" + groupCode + "' >" + groupName ) ;
                                    }
                                }

                               if(pstmt!=null) pstmt.close() ;
							   if(rs!=null) rs.close();
                            %>
                            </select>
                        </td>
                        <td class="label"><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
						<!-- Added by Mallikarjuna on 12/3/2003 -->
						<!-- code for getting of Count of Id_Type from mp_pat_ser_grp table-->
							<%
								String nat_id_count = "";
								String alt_id_count = "";

								pst = con.prepareStatement("select count(1) nat_id_count from mp_pat_ser_grp where id_type='N'");
								res = pst.executeQuery();
							
								if(res.next())
								{
									nat_id_count = res.getString("nat_id_count");
									
								}
																
								pst1=con.prepareStatement("select count(1) alt_id_count from mp_pat_ser_grp where id_type='A'");
								res1 = pst1.executeQuery();
							
								if(res1.next())
								{
									alt_id_count = res1.getString("alt_id_count");
									
								}
							%>
							
						<!-- End of the code for getting of Count of Id_Type from mp_pat_ser_grp table-->
                        <td class="fields" nowrap><select name="dflt_pat_ser_grp_type" id="dflt_pat_ser_grp_type" style='width: 175px'>
                            <%
                                if ( dflt_pat_ser_grp_type.equals( "G" ) )
                                    out.println( "<option selected value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels")+"</Option>");
                                else
                                    out.println( "<option value='G'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.general.label","common_labels")+"</Option>");

                                if ( dflt_pat_ser_grp_type.equals( "N" ) )
                                    out.println( "<option selected value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalID.label","mp_labels")+"</Option>");
                                else
                                    out.println( "<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalID.label","mp_labels")+"</Option>");

                                if ( dflt_pat_ser_grp_type.equals( "A" ) )
									out.println( "<option selected value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AlternateID.label","common_labels")+"1</Option>");
                                else
                                   out.println( "<option value='A'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AlternateID.label","common_labels")+"1</Option>");
                            %>
                            </select>
                            <img src='../images/mandatory.gif'></img>
                        </td>
                    </tr>
<!-- Border test start -->

  <!--   </td>
    </tr> -->
    </table>


<table border='0' cellpadding='3' cellspacing='0' width='100%'>
 

		     <tr >
            <td class='COLUMNHEADER' colspan='4'><fmt:message key="eMP.MedicalRecordsAdministration.label" bundle="${mp_labels}"/></td>
        </tr>

 		<tr>
				<%--				<td class="label" width='25%'><fmt:message key="eMP.MRAdministrationBy.label" bundle="${mp_labels}"/></td>
                                <td class="fields" width='25%'><select name="maintain_doc_or_file" id="maintain_doc_or_file" onchange="enableMRAdmin(this);" <%=disable_mr_admin%>>
									  <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
									  <!-- <option value='D' <%=mr_doc_select%>>&nbsp;<fmt:message key="Common.Document.label" bundle="${common_labels}"/>&nbsp;</option> -->
									  <option value='F' <%=mr_file_select%>>&nbsp;<fmt:message key="eMP.File.label" bundle="${mp_labels}"/>&nbsp;</option>
									  </select>&nbsp;<img src='../images/mandatory.gif'></img>
                                </td> --%>

								<%
									String chk_create_file = "";
									String dis_create_file = "";

									if ( operation.equalsIgnoreCase( "insert" ) ) 
									{ 
										chk_create_file = "checked";
										dis_create_file = "";
									}
									else if (operation.equalsIgnoreCase( "modify" ))
									{
										if(create_file_yn.equals("Y"))
											chk_create_file = "checked";
										else
											chk_create_file = "";

										dis_create_file = "disabled";
									}
								%>

								<td class="label" width='25%'><fmt:message key="eMP.CreateFile.label" bundle="${mp_labels}"/></td>

								<td class='fields' width='25%'>
									<input type='checkbox' name='create_file' id='create_file' onClick='chkMedicalAdminFields(this);' <%=chk_create_file%> <%=dis_create_file%>>
									<input type='hidden' name='create_file_yn' id='create_file_yn' value='<%=create_file_yn%>'>
								</td>

								<td class="label" width='25%'><fmt:message key="eMP.FileMaintenance.label" bundle="${mp_labels}"/></td>

                                <td class='fields' width='25%'>
                                    <%
                                  
									if ( operation.equalsIgnoreCase( "insert" ) ) { 
									   
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='S' onClick='checkNumberingControl(\"S\")' checked >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.single.label","common_labels")+"&nbsp;" ) 
;										                                       
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='M' onClick='checkNumberingControl(\"M\")' checked >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.multiple.label","common_labels") ) ;

											out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='B' disabled onClick='checkNumberingControl(\"B\")' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;
                                        
									}
									if ( operation.equalsIgnoreCase( "modify" ) ) { 
									    if ( single_or_multi_files_ind.equals( "S" ) )
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='S' onClick='checkNumberingControl(\"S\")'  checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.single.label","common_labels")+"&nbsp;" ) 
;
                                        else
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='S' onClick='checkNumberingControl(\"S\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.single.label","common_labels")+"&nbsp;" ) ;

                                        if ( single_or_multi_files_ind.equals( "M" ) )
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='M' onClick='checkNumberingControl(\"M\")' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.multiple.label","common_labels") ) ;
                                        else
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='M' onClick='checkNumberingControl(\"M\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.multiple.label","common_labels") ) ;

										if (single_or_multi_files_ind.equals("B") )
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='B' checked onClick='checkNumberingControl(\"B\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;
                                        else
                                            out.println( "<input type='radio' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='B' onClick='checkNumberingControl(\"B\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;
									}
                                    %>
									<input type="hidden" name='maintain_doc_or_file' id='maintain_doc_or_file' value='F'>
                                    </td>									
							</tr>
			                 <tr>  
                                    <td class="label"><fmt:message key="eMP.File.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="eMP.NumberingControl.label" bundle="${mp_labels}"/></td>
                                   <td class="fields" colspan='3'>
										<%
                                        if ( operation.equalsIgnoreCase( "insert" ) ) {
                                            if ( separate_file_no_yn.equals( "Y" ) )
                                                out.println( "<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='Y' checked onClick='checkNumberingControl(\"A\")'   >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AllowseparateMRN.label","mp_labels")+"&nbsp;" ) ;
                                            else
                                                out.println( "<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='Y' onClick='checkNumberingControl(\"F\")' checked >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AllowseparateMRN.label","mp_labels")+"&nbsp;" ) ;

                                            if ( separate_file_no_yn.equals( "N" ) )
                                                out.println( "&nbsp;&nbsp;<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='N' onClick='checkNumberingControl(\"A\")' checked >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.KeepFileNumbersameasPatientID.label","mp_labels") ) ;
                                            else
                                                out.println( "&nbsp;&nbsp;<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='N' onClick='checkNumberingControl(\"F\")'  >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.KeepFileNumbersameasPatientID.label","mp_labels") ) ;

											if ( separate_file_no_yn.equals( "B" ) )
												out.println( "&nbsp;&nbsp;<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='B' checked onClick='checkNumberingControl(\"B\")' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;   
											else
												out.println( "&nbsp;&nbsp;<input type='radio' name='separate_file_no_yn' id='separate_file_no_yn' value='B' disabled onClick='checkNumberingControl(\"B\")' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;   
												
                                        }
										String enabledisable1 = "";
									
										if(single_or_multi_files_ind.equals("M"))
											enabledisable1="";
										else
											enabledisable1="disabled";
                                        if ( operation.equalsIgnoreCase( "modify" ) ) {
                                            if ( separate_file_no_yn.equals( "Y" ) )
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='Y' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AllowseparateMRN.label","mp_labels")+"&nbsp;" ) ;
                                            else
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='Y' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AllowseparateMRN.label","mp_labels")+"&nbsp;" ) ;

                                            if ( separate_file_no_yn.equals( "N" ) )
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='N' checked disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.KeepFileNumbersameasPatientID.label","mp_labels") ) ;
                                            else
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='N' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.KeepFileNumbersameasPatientID.label","mp_labels") ) ;

											if (separate_file_no_yn.equals("B") )
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='B' checked onClick='checkNumberingControl(\"B\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;
                                            else
                                                out.println( "<input type='radio' name='d_separate_file_no_yn' id='d_separate_file_no_yn' value='B' onClick='checkNumberingControl(\"B\")' disabled>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.none.label","common_labels") ) ;
                                        }
                                    %>
                                    </td>
                                </tr>
								<%
									  if(create_file_at_pat_regn_yn.equals("Y"))
										enabledisable = "";
									  else
										enabledisable = "disabled";   
									%>
									<tr><td align='left' colspan='4'><B><span class='label'><fmt:message key="eMP.CreateFileduring.label" bundle="${mp_labels}"/></span></B></td>
									</tr>
									<tr>
									<% if(module_instal_ind.equals("DMS")) { %>
									 <td class='label' nowrap ><fmt:message key="eMP.UM_PatientRegistrationTitle.label" bundle="${mp_labels}"/></td>
									<% } else{%>
									<td class='label' nowrap ><fmt:message key="eMP.PatientRegistrationTitle.label" bundle="${mp_labels}"/></td>
									<%}%>
									<td class="fields">
									<%
									if(operation.equalsIgnoreCase("insert" )){
									if(create_file_at_pat_regn_yn.equals("Y")){
									%>
									<input type='checkbox' name='create_file_at_pat_regn_yn' id='create_file_at_pat_regn_yn' value='Y' checked onclick='GeneralClick()'>
									<%}else{%>
									<input type='checkbox' name='create_file_at_pat_regn_yn' id='create_file_at_pat_regn_yn' value='N'  onclick='GeneralClick()'>
							    	<%}
									}if(operation.equalsIgnoreCase("modify")){
									if(create_file_at_pat_regn_yn.equals("Y")){
									%>
									<input type='checkbox' onload='GeneralClick()' name='create_file_at_pat_regn_yn' id='create_file_at_pat_regn_yn' value='Y' disabled checked>
									<%}else{%>
									<input type='checkbox' name='create_file_at_pat_regn_yn' id='create_file_at_pat_regn_yn' value='N' disabled>
									<%}}%>
									</td>
									<td class='label' nowrap ><fmt:message key="eMP.IPAdmission.label" bundle="${mp_labels}"/></td>
									<td class="fields">
									<%
									
									if(operation.equalsIgnoreCase("insert" )){
									if(create_file_at_admission.equals("Y")){
									%>
									<input type='checkbox' name='create_file_at_admission' id='create_file_at_admission' value='Y' checked onclick='GeneralClick()'>
									<%}else{%>
									<input type='checkbox' name='create_file_at_admission' id='create_file_at_admission' value='N'  onclick='GeneralClick()' >
							    	<%}
									}if(operation.equalsIgnoreCase("modify")){
									if(create_file_at_admission.equals("Y")){
									%>
									<input type='checkbox' name='create_file_at_admission' id='create_file_at_admission' value='Y' disabled checked>
									<%}else{%>
									<input type='checkbox' name='create_file_at_admission' id='create_file_at_admission' value='N' disabled>
									<%}}%>
									</td>
						</tr>
						<tr>
									 <td class='label' nowrap ><fmt:message key="eMP.OPVisitRegistration.label" bundle="${mp_labels}"/></td>
									<td class="fields">
									<%
									if(operation.equalsIgnoreCase("insert" )){
									if(create_file_at_reg_visit_yn.equals("Y")){
									%>
									<input type='checkbox' name='create_file_at_reg_visit_yn' id='create_file_at_reg_visit_yn' value='Y' checked onclick='GeneralClick()'>
									<%}else{%>
									<input type='checkbox' name='create_file_at_reg_visit_yn' id='create_file_at_reg_visit_yn' value='N'  onclick='GeneralClick()'>
							    	<%}
									}if(operation.equalsIgnoreCase("modify")){
									if(create_file_at_reg_visit_yn.equals("Y")){
									%>
									<input type='checkbox' name='create_file_at_reg_visit_yn' id='create_file_at_reg_visit_yn' value='Y' disabled checked>
									<%}else{%>
									<input type='checkbox' name='create_file_at_reg_visit_yn' id='create_file_at_reg_visit_yn' value='N' disabled>
									<%}}%>
									</td>
									 <td class='label' nowrap ><fmt:message key="eMP.EM.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.RegisterAttendance.label" bundle="${common_labels}"/></td>
									<td class="fields">
									<%
									if(operation.equalsIgnoreCase("insert" )){
									if(create_file_at_reg_att_yn.equals("Y")){
									%>
									<input type='checkbox' name='create_file_at_reg_att_yn' id='create_file_at_reg_att_yn' value='Y' checked onclick='GeneralClick()'>
									<%}else{%>
									<input type='checkbox' name='create_file_at_reg_att_yn' id='create_file_at_reg_att_yn' value='N'  onclick='GeneralClick()'>
							    	<%}
									}if(operation.equalsIgnoreCase("modify")){
									if(create_file_at_reg_att_yn.equals("Y")){
									%>
									<input type='checkbox' name='create_file_at_reg_att_yn' id='create_file_at_reg_att_yn' value='Y' disabled checked>
									<%}else{%>
									<input type='checkbox' name='create_file_at_reg_att_yn' id='create_file_at_reg_att_yn' value='N' disabled>
									<%}}%>
									</td>
								    </tr>
									<tr>
									<td class='label' nowrap ><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.admission.label" bundle="${common_labels}"/></td>
									<td class="fields">
									<%
										
									if(operation.equalsIgnoreCase("insert" )){
									if(create_file_at_dc_admission_yn.equals("Y")){
									%>
									<input type='checkbox' name='create_file_at_dc_admission_yn' id='create_file_at_dc_admission_yn' value='Y' checked onclick='GeneralClick()'>
									<%}else{%>
									<input type='checkbox' name='create_file_at_dc_admission_yn' id='create_file_at_dc_admission_yn' value='N'  onclick='GeneralClick()'>
							    	<%}
									}if(operation.equalsIgnoreCase("modify")){
									if(create_file_at_dc_admission_yn.equals("Y")){
									%>
									<input type='checkbox' name='create_file_at_dc_admission_yn' id='create_file_at_dc_admission_yn' value='Y' disabled checked>
									<%}else{%>
									<input type='checkbox' name='create_file_at_dc_admission_yn' id='create_file_at_dc_admission_yn' value='N' disabled>
									<%}}%>
									</td>
									<td class="label" >&nbsp;</td>
									<td class="label" >&nbsp;</td>
								    </tr>
									
           
		</table>

	 <table border='0' cellpadding='3' cellspacing='0' width='100%'>


				<tr>
                <td  colspan='4'  class='COLUMNHEADER'><fmt:message key="eMP.family.label" bundle="${mp_labels}"/>/<fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>
				</tr>



							<tr >
                        <td class="label" width='25%'><fmt:message key="eMP.MaintainFamilyLink.label" bundle="${mp_labels}"/></td>
							<td class='fields' width='25%'>
								<%
								if (operation.equalsIgnoreCase( "insert" ) )
										out.println( "<input type='checkbox' name='family_no_link_yn' id='family_no_link_yn' value='' onclick='sel_familyLink(this)'>" ) ;

									if (operation.equalsIgnoreCase( "modify" ) ) {
										if ( family_no_link_yn.equals( "Y" ) )
											out.println( "<input type='checkbox' name='family_no_link_yn' id='family_no_link_yn' value='Y' checked disabled>" ) ;
										else
											out.println( "<input type='checkbox' name='family_no_link_yn' id='family_no_link_yn' value='Y' disabled>" ) ;
									}
								%>
								<input type='hidden' name='family_no_link_yn_new' id='family_no_link_yn_new' value='N'>
							</td>
								<td class="label"  width='25%'><fmt:message key="eMP.MaintainOrganizationMembership.label" bundle="${mp_labels}"/></td>						
						<td class='fields' width='25%'>
							 <%
								if (operation.equalsIgnoreCase( "insert" ) ){
							           out.println( "<input type='checkbox' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value='N' Onclick='maintainOrgMembership(this);' >");
								}else{
                                if (operation.equalsIgnoreCase( "modify" ) ) {
                                    if ( family_org_id_accept_yn.equals("Y") )
                                        out.println( "<input type='checkbox' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value='Y'  checked disabled>" ) ;
                                    else
                                        out.println( "<input type='checkbox' name='family_org_id_accept_yn' id='family_org_id_accept_yn' value='N' disabled>" ) ;
                                }
							}
                            %>
						</td>
					</tr>
					<tr>
						<td class ='label' ><fmt:message key="eMP.RelationshipforOrganizationMember.label" bundle="${mp_labels}"/></td>
						<td class="fields"  >
							 <%
									 if ( family_org_id_accept_yn.equals( "N" ) )				
										out.println("<select name='org_member_relationship_code' id='org_member_relationship_code' disabled> <option value='' selected>----------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----------</option>");
									else
									{

										if ( operation.equalsIgnoreCase( "insert" ) )
										{%>
											<select name='org_member_relationship_code' id='org_member_relationship_code' disabled>
											<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
											
										<%}
										else if ( operation.equalsIgnoreCase( "modify" ) )
										{
											stmt = con.createStatement();
											rs = stmt.executeQuery("select short_desc from mp_relationship where relationship_code='"+org_member_relationship_code+"'");
												out.println("<select name='org_member_relationship_code' id='org_member_relationship_code' disabled>");
											if (rs.next()){
												out.println("<option value='"+org_member_relationship_code+"'>"+rs.getString("short_desc")+"</option>");
												//out.println("<img src='../images/mandatory.gif'></img>");
											}
											else
												out.println("<option value=''>&nbsp;&nbsp;</option>");
										}
									}
								%>
							</select><img src='../images/mandatory.gif' id='rlnsp' style='visibility:hidden'></img>
						</td>
						 <%if ( operation.equalsIgnoreCase( "insert" ) ){%>
						 <td class="label" width='25%'><fmt:message key="eMP.AlternateIDTypeforMembershipID.label" bundle="${mp_labels}"/></td>
						<td class="fields"  width='25%'disabled>
						<select name='mapped_alt_id_org_member_id_ins' id='mapped_alt_id_org_member_id_ins' disabled>
						<option value='' selected >----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<!--<option value='ID1' selected ><fmt:message key="Common.identification.label" bundle="${common_labels}"/>1</option>-->
						</select>
						</td>
						<%}else {if ( family_org_id_accept_yn.equals( "Y" ) ){%>
						<td class="label" width='25%'><fmt:message key="eMP.AlternateIDTypeforMembershipID.label" bundle="${mp_labels}"/></td>
						<td class="fields"  width='25%' id='altidmbr'>
							<select name='mapped_alt_id_org_member_id' id='mapped_alt_id_org_member_id' disabled>
								<%  if ( family_org_id_accept_yn.equals( "N" ) )	 {%>
								<option value=''>&nbsp;&nbsp;&nbsp;&nbsp;</option>
								<%}  else {%>
								<option value='ID1' selected ><fmt:message key="Common.identification.label" bundle="${common_labels}"/>1</option>
								<%}%>
							</select>	
						  </td>
						  <%}else{%><td  width='25%' colspan='2'>&nbsp;</td><%}}%>
						</tr>



</table> 

</div>

<!-- <a  name="tab4" nowrap></a>   -->

<div id = 'LNAMES' style = 'display:none'>

<!--<a  name="tab4" nowrap></a>-->
<table cellspacing='0' cellpadding='0' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" style="padding-left:0px;">
		
			<li class="tablistitem" title='<fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/>'>
				<a class="tabA" id="pat_admin_tab" >
					<span class="tabAspan" id="pat_admin_tabspan" onClick='javascript:expandCollapse("pat_admin_tab")'><fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			
			<li class="tablistitem" title='<fmt:message key="eMP.LegalNames.label" bundle="${mp_labels}"/>'>
				<a class="tabClicked" id="legal_names_tab" >
					<span class="tabSpanclicked" id="legal_names_tabspan" onClick='javascript:expandCollapse("legal_names_tab")'><fmt:message key="eMP.LegalNames.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="eMP.AlternateIDChecks.label" bundle="${mp_labels}"/> '>
				<a class="tabA" id="alt_id_chk_tab" >
					<span class="tabAspan" id="alt_id_chk_tabspan" onClick='javascript:expandCollapse("alt_id_chk_tab")'><fmt:message key="eMP.AlternateIDChecks.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/>'>
				<a class="tabA" id="new_born_tab" >
					<span class="tabAspan" id="new_born_tabspan" onClick='javascript:expandCollapse("new_born_tab")'><fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="Common.others.label" bundle="${common_labels}"/>'>
				<a class="tabA" id="others_tab" >
					<span class="tabAspan" id="others_tabspan" onClick='javascript:expandCollapse("others_tab")'><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<!-- Added by prithivi for kdah-crf-0362  -->
			<% if("Y".equalsIgnoreCase(aadharProfileYN)) {%>				
			<li class="tablistitem" title='Aadhaar Function Configuration'>
				<a class="tabA" id="aadhar_tab" >
					<span class="tabAspan" id="aadhar_tabspan" onClick='javascript:expandCollapse("aadhar_tab")'><fmt:message key="eXH.AADHAAR.label" bundle="${mp_labels}"/></span>
				</a>
			</li>
			<% } %>
			</ul>
	 </td></tr>
	</table>

     <table border='0' cellpadding='3' cellspacing='0' width='100%' border=0>
					<tr >
                        
						
						<% if(module_instal_ind.equals("DMS")) { %>
						<td  class="label" width="30%" ><fmt:message key="eMP.UM_AcceptPatientNameinLocalLanguage.label" bundle="${mp_labels}"/></td>
                        <%}else{%>
						<td  class="label" width="30%" ><fmt:message key="eMP.AcceptPatientNameinLocalLanguage.label" bundle="${mp_labels}"/></td>
						<%} %>
						<td width="25%" class='fields'> 
                            <%
                                chked = "checked" ;
                                if(name_in_oth_lang_yn.equals("N"))
                                {
                                    chked ="" ;
                                }
                            %>
                            <input type='checkbox' name='name_in_oth_lang_yn' id='name_in_oth_lang_yn' onfocus='callfocusfun()'	onClick='setLocLang();' value='Y' <%=chked%>>
                        </td>
                  <td class="label" width="25%" ><fmt:message key="eMP.DefaultSoundexType.label" bundle="${mp_labels}"/></td>

                        <td width="20%" class='fields'>

						<select name="dflt_sndx_type" id="dflt_sndx_type"  disabled>
                            <%
                            
						if ( dflt_sndx_type.equals("") )
                                    out.println( "<option selected value=''>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--" ) ;
                                else
                                    out.println( "<option value=''>--"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--" ) ;

                                if ( dflt_sndx_type.equals( "G" ) )
                                    out.println( "<option selected value='G'>Generic" ) ;
                                else
                                    out.println( "<option value='G'>Generic" ) ;

                                if ( dflt_sndx_type.equals( "E" ) )
									out.println( "<option selected value='E'>Ethnic" ) ;
                                else
                                   out.println( "<option value='E'>Ethnic" ) ;

                            %>
                            </select>
	                        </td>
                    </tr>
					<tr> 
							<% if(module_instal_ind.equals("DMS")) { %>
							<td  class="label" nowrap><fmt:message key="eMP.UM_AcceptPatientNameasMultiparts.label" bundle="${mp_labels}"/></td>
                        <%}else{%>
						<td  class="label" nowrap><fmt:message key="eMP.AcceptPatientNameasMultiparts.label" bundle="${mp_labels}"/></td>
						<%}%>
						<td class='fields' colspan='3'>
                            
					 <!-- Added by Mallikarjuna on 12/2/2003 ** Accept Patient name as multiParts-->

					<%		//code for Insert  Mode
                              if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( pat_name_as_multipart_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value='Y' onClick='enableNames();' checked>" ) ;                  
								else
                                    out.println( "<input type='checkbox' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value='Y' onClick='enableNames();' >" ) ;
                            }
								// Code for Modify Mode
                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( pat_name_as_multipart_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' disabled >" ) ;
                            }
                        %></td>
							<!-- End of the addition for Accept Patient name as multiParts-->
					</tr>
                </table>
                <table border='1' cellpadding='3' cellspacing='0' width='100%'>
                    <tr >
                        <td class="COLUMNHEADER" width="12%" >&nbsp;&nbsp;</td>

                        <td class="COLUMNHEADER" width="7%" ><fmt:message key="Common.Accept.label" bundle="${common_labels}"/></td>

						<td class="COLUMNHEADER" width="9%" ><fmt:message key="Common.length.label" bundle="${common_labels}"/></td>

						<td class="COLUMNHEADER" width="12%"> <fmt:message key="eMP.ReqdforOrgnMember.label" bundle="${mp_labels}"/></td>

                        <td class="COLUMNHEADER" width="8%" ><fmt:message key="Common.required.label" bundle="${common_labels}"/></td>
						
                        <td class="COLUMNHEADER" width="12%" ><fmt:message key="Common.Ordering.label" bundle="${common_labels}"/></td>
                        <td class="COLUMNHEADER" width="20%" ><fmt:message key="eMP.Legend.label" bundle="${mp_labels}"/></td>
                        <td class="COLUMNHEADER" width="18%" ><fmt:message key="eMP.LegendforLocLang.label" bundle="${mp_labels}"/></td>
                    </tr>

                    <tr >
                        <td class="label" width="12%" nowrap><fmt:message key="eMP.prefix.label" bundle="${mp_labels}"/></td>

                        <td width="7%" class='fields'>
                        <%
						String ena_dis_loc_lang = "";
                            if (name_in_oth_lang_yn.equals("N"))
                                ena_dis_loc_lang = "disabled";
                            else
                                ena_dis_loc_lang = "";

                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( name_prefix_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='name_prefix_accept_yn' id='name_prefix_accept_yn' value='Y' onClick='checkLegalNames(1)' checked>" ) ;                                else
                                    out.println( "<input type='checkbox' name='name_prefix_accept_yn' id='name_prefix_accept_yn' value='Y' onClick='checkLegalNames(1)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( name_prefix_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_name_prefix_accept_yn' id='d_name_prefix_accept_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_name_prefix_accept_yn' id='d_name_prefix_accept_yn' disabled >" ) ;
                            }
                        %>
                        </td>
						<td width="9%" class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='name_prefix_length' id='name_prefix_length' value='"+name_prefix_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                    out.println( "<input type='text' name='name_prefix_length' id='name_prefix_length' value='"+name_prefix_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 
                            }
                        %>
                        </td>

						<td width="12%" class='fields'>
						<%
						if ( operation.equalsIgnoreCase( "insert" ) ) {
							out.println("<input type='checkbox' name='name_pfx_reqd_for_org_mem_yn' id='name_pfx_reqd_for_org_mem_yn'  value='N' onclick='check_fmorg_fun(this)' disabled>");
						}else if(operation.equalsIgnoreCase( "modify" )){
							if(name_pfx_reqd_for_org_mem_yn.equals("Y"))
								out.println("<input type='checkbox' name='name_pfx_reqd_for_org_mem_yn' id='name_pfx_reqd_for_org_mem_yn'  value='Y' checked disabled>");
							else
								out.println("<input type='checkbox' name='name_pfx_reqd_for_org_mem_yn' id='name_pfx_reqd_for_org_mem_yn'  value='N' disabled>");
						}
						%>
						</td>

                        <td width="8%" class='fields'>
                        <%
                     
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( name_prefix_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y' onClick='checkLegalNames(1)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='Y' onClick='checkLegalNames(1)'>" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( name_prefix_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_name_prefix_reqd_yn' id='d_name_prefix_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_name_prefix_reqd_yn' id='d_name_prefix_reqd_yn' disabled>" ) ;
                            }
                        %>
						<input type='hidden' name='name_prefix_reqd_yn_new' id='name_prefix_reqd_yn_new' value='N'>
                        </td>

                        <td width="10%">&nbsp;</td>
                        <td width="20%" class='fields'>
                            <input type="text" name="name_prefix_prompt" id="name_prefix_prompt" size="15" maxlength="15" value="<%= name_prefix_prompt %>" onFocus='checkLegalNames(1)' onBlur="makeValidString(this)">
                        </td>
                        <td width="18%" class='fields'>
                           <!--  <input type="text" name="name_prefix_loc_lang_prompt" id="name_prefix_loc_lang_prompt" size="15" maxlength="15" value="<%= name_prefix_loc_lang_prompt %>" onFocus='checkLegalNames(1)' <%=ena_dis_loc_lang%> onblur='makeValidString(this)' > -->

							<%

							out.println("<input type='text' name='name_prefix_loc_lang_prompt' id='name_prefix_loc_lang_prompt' size='15' maxlength='15' value='"+ name_prefix_loc_lang_prompt +"' onFocus='checkLegalNames(1)' '"+ena_dis_loc_lang+"' onblur='makeValidString(this)'");

							if(language_direction.equals("R"))
							{
							out.println( "dir='RTL'> ");
							}else
							{
							out.println( " > ");
							}

								%>
                        </td>
                    </tr>
                    <tr >
                        <td class="label" nowrap><fmt:message key="Common.FirstName.label" bundle="${common_labels}"/></td>

                        <td class='fields'>
                        <%
                       
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( first_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='first_name_accept_yn' id='first_name_accept_yn' value='Y'  onClick='checkLegalNames(2)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='first_name_accept_yn' id='first_name_accept_yn' value='Y' onClick='checkLegalNames(2)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( first_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_first_name_accept_yn' id='d_first_name_accept_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_first_name_accept_yn' id='d_first_name_accept_yn' disabled>" ) ;
                            }
                        %>
                        </td>
						<td width="9%" class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='first_name_length' id='first_name_length' value='"+first_name_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                   out.println( "<input type='text' name='first_name_length' id='first_name_length' value='"+first_name_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 
									
                            }
                        %>
                        </td>
					<td width="10%">&nbsp;</td>
                        <td class='fields'>
                        <%
                          
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( first_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y' onFocus='checkLegalNames(2)' onClick='checkLegalNames(2)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='first_name_reqd_yn' id='first_name_reqd_yn' value='Y' onFocus='checkLegalNames(2)' onClick='checkLegalNames(2)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( first_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_first_name_reqd_yn' id='d_first_name_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_first_name_reqd_yn' id='d_first_name_reqd_yn' disabled>" ) ;
                            }
                        %>
                        </td>
	
                        <td class='fields'>
                        <%
                        
						if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='first_name_order' id='first_name_order' size='1' maxlength='1' value='" + first_name_order +"' onFocus='checkLegalNames(2)' onBlur='CheckNum(this);checkDecimal(this);checkZero(this)'>" ) ;
                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='d_first_name_order' id='d_first_name_order' size='1' maxlength='1' value='" + first_name_order +"' disabled >" ) ;
                        %>
                        </td>

                        <td class='fields'>
                            <input type="text" name="first_name_prompt" id="first_name_prompt" size="15" maxlength="15" value="<%= first_name_prompt %>" onFocus="checkLegalNames(2)" onBlur="makeValidString(this)">
                        </td>
                        <td class='fields'>
                           <!--  <input type="text" name="first_name_loc_lang_prompt" id="first_name_loc_lang_prompt" size="15" maxlength="15" value="<%= first_name_loc_lang_prompt %>" onFocus="checkLegalNames(2)" <%=ena_dis_loc_lang%> > -->
						<%
							out.println( "<input type='text' name='first_name_loc_lang_prompt' id='first_name_loc_lang_prompt' size='15' maxlength='15' value='"+ first_name_loc_lang_prompt+"' onFocus='checkLegalNames(2)' '"+ena_dis_loc_lang+"' ");
							
							if(language_direction.equals("R"))
							{
							out.println( "dir='RTL'> ");
							}else
							{
							out.println( " > ");
							}


							%>
						  
                        </td>
                    </tr>

                    <tr >
                        <td class="label" nowrap><fmt:message key="Common.SecondName.label" bundle="${common_labels}"/></td>

                        <td class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( second_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='second_name_accept_yn' id='second_name_accept_yn' value='Y'  onClick='checkLegalNames(3)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='second_name_accept_yn' id='second_name_accept_yn' value='Y' onClick='checkLegalNames(3)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( second_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_second_name_accept_yn' id='d_second_name_accept_yn' value='Y' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_second_name_accept_yn' id='d_second_name_accept_yn' value='Y' disabled>" ) ;
                            }
                        %>
                        </td>
						<td width="9%" class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='second_name_length' id='second_name_length' value='"+second_name_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                    out.println( "<input type='text' name='second_name_length' id='second_name_length' value='"+second_name_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 

									 
                            }
                        %>
                        </td>
					<td width="10%">&nbsp;</td>
                        <td class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( second_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y' onFocus='checkLegalNames(3)' onClick='checkLegalNames(3)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='second_name_reqd_yn' id='second_name_reqd_yn' value='Y' onFocus='checkLegalNames(3)' onClick='checkLegalNames(3)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( second_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_second_name_reqd_yn' id='d_second_name_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_second_name_reqd_yn' id='d_second_name_reqd_yn' disabled>" ) ;
                            }
                        %>
                        </td>
	
                        <td class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='second_name_order' id='second_name_order' size='1' maxlength='1' value='" + second_name_order +"' onFocus='checkLegalNames(3)' onBlur='CheckNum(this);checkDecimal(this);checkZero(this)'>" ) ;

                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='d_second_name_order' id='d_second_name_order' size='1' maxlength='1' value='" + second_name_order +"' disabled >" ) ;                        %>
                        </td>

                        <td class='fields'>
                            <input type="text" name="second_name_prompt" id="second_name_prompt" size="15" maxlength="15" value="<%= second_name_prompt %>" onFocus='checkLegalNames(3)' onBlur="makeValidString(this)">
                        </td>
                        <td class='fields'>
                            <!-- <input type="text" name="second_name_loc_lang_prompt" id="second_name_loc_lang_prompt" size="15" maxlength="15" value="<%= second_name_loc_lang_prompt %>" onFocus='checkLegalNames(3)' <%=ena_dis_loc_lang%> onblur='makeValidString(this)'> -->

							<%
							
							out.println("<input type='text' name='second_name_loc_lang_prompt' id='second_name_loc_lang_prompt' size='15' maxlength='15' value='"+second_name_loc_lang_prompt+"' onFocus='checkLegalNames(3)' '"+ena_dis_loc_lang+"' onblur='makeValidString(this)'");

							if(language_direction.equals("R"))
							{
							out.println( "dir='RTL'> ");
							}else
							{
							out.println( " > ");
							}

							%>
                        </td>
                    </tr>

                    <tr >
                        <td class="label" nowrap><fmt:message key="eMP.ThirdName.label" bundle="${mp_labels}"/></td>

                        <td class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( third_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='third_name_accept_yn' id='third_name_accept_yn' value='Y'  onClick='checkLegalNames(4)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='third_name_accept_yn' id='third_name_accept_yn' value='Y' onClick='checkLegalNames(4)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( third_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_third_name_accept_yn' id='d_third_name_accept_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_third_name_accept_yn' id='d_third_name_accept_yn' disabled>" ) ;
                            }
                        %>
                        </td>
						<td width="9%" class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='third_name_length' id='third_name_length' value='"+third_name_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                    out.println( "<input type='text' name='third_name_length' id='third_name_length' value='"+third_name_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 

									 
                            }
                        %>
                        </td>
					<td width="10%">&nbsp;</td>
                        <td class='fields'>
                        <%
                   
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( third_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y' onFocus='checkLegalNames(4)' onClick='checkLegalNames(4)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='third_name_reqd_yn' id='third_name_reqd_yn' value='Y' onFocus='checkLegalNames(4)' onClick='checkLegalNames(4)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( third_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_third_name_reqd_yn' id='d_third_name_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_third_name_reqd_yn' id='d_third_name_reqd_yn' disabled >" ) ;
                            }
                        %>
                        </td>
	
                        <td class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='third_name_order' id='third_name_order' size='1' maxlength='1' value='" + third_name_order +"' onFocus='checkLegalNames(4)' onBlur='CheckNum(this);checkDecimal(this);checkZero(this)'>" ) ;

                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='d_third_name_order' id='d_third_name_order' size='1' maxlength='1' value='" + third_name_order +"' disabled >" ) ;
                        %>
                        </td>

                        <td class='fields'>
                            <input type="text" name="third_name_prompt" id="third_name_prompt" size="15" maxlength="15" value="<%= third_name_prompt %>" onFocus='checkLegalNames(4)' onBlur="makeValidString(this)">
                        </td>
                        <td class='fields'>
                            <!-- <input type="text" name="third_name_loc_lang_prompt" id="third_name_loc_lang_prompt" size="15" maxlength="15" value="<%= third_name_loc_lang_prompt %>" onFocus='checkLegalNames(4)' <%=ena_dis_loc_lang%> onblur='makeValidString(this)'> -->

							<%

							out.println("<input type='text' name='third_name_loc_lang_prompt' id='third_name_loc_lang_prompt' size='15' maxlength='15' value='"+third_name_loc_lang_prompt+"' onFocus='checkLegalNames(4)' '"+ena_dis_loc_lang+"' onblur='makeValidString(this)'");


							if(language_direction.equals("R"))
							{
							out.println( "dir='RTL'> ");
							}else
							{
							out.println( " > ");
							}

							%>
                        </td>
                    </tr>

                    <tr >
                        <td class="label" nowrap><fmt:message key="Common.FamilyName.label" bundle="${common_labels}"/></td>

                        <td class='fields'>
                        <%
                       
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( family_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='family_name_accept_yn' id='family_name_accept_yn' value='Y' onClick='checkLegalNames(5)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='family_name_accept_yn' id='family_name_accept_yn' value='Y' onClick='checkLegalNames(5)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( family_name_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_family_name_accept_yn' id='d_family_name_accept_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_family_name_accept_yn' id='d_family_name_accept_yn' disabled >" ) ;
                            }
                        %>
                        </td>
						<td width="9%" class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='family_name_length' id='family_name_length' value='"+family_name_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                    out.println( "<input type='text' name='family_name_length' id='family_name_length' value='"+family_name_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 

									
                            }
                        %>
                        </td>
					<td width="10%">&nbsp;</td>
                        <td class='fields'>
                        <%
                      
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( family_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y' onFocus='checkLegalNames(5)' onClick='checkLegalNames(5)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='family_name_reqd_yn' id='family_name_reqd_yn' value='Y' onFocus='checkLegalNames(5)' onClick='checkLegalNames(5)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( family_name_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_family_name_reqd_yn' id='d_family_name_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_family_name_reqd_yn' id='d_family_name_reqd_yn' disabled>" ) ;
                            }
                        %>
                        </td>
	
                        <td class='fields'>
                        <%
                       
						if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<input type='text' name='family_name_order' id='family_name_order' size='1' maxlength='1' value='" + family_name_order +"' onFocus='checkLegalNames(5)' onBlur='CheckNum(this);checkDecimal(this);checkZero(this)'>" ) ;

                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<input type='text' name='d_family_name_order' id='d_family_name_order' size='1' maxlength='1' value='" + family_name_order +"' disabled >" ) ;                        %>
                        </td>

                        <td class='fields'>
                            <input type="text" name="family_name_prompt" id="family_name_prompt" size="15" maxlength="15" value="<%= family_name_prompt %>" onFocus='checkLegalNames(5)' onBlur="makeValidString(this)">
                        </td>
                        <td class='fields'>
                            <!-- <input type="text" name="family_name_loc_lang_prompt" id="family_name_loc_lang_prompt" size="15" maxlength="15" value="<%= family_name_loc_lang_prompt %>" onFocus='checkLegalNames(5)' <%=ena_dis_loc_lang%> onblur='makeValidString(this)'> -->

							<%
							out.println("<input type='text' name='family_name_loc_lang_prompt' id='family_name_loc_lang_prompt' size='15' maxlength='15' value='"+family_name_loc_lang_prompt+"' onFocus='checkLegalNames(5)' '"+ena_dis_loc_lang+"' onblur='makeValidString(this)'");

							if(language_direction.equals("R"))
							{
							out.println( "dir='RTL'> ");
							}else
							{
							out.println( " > ");
							}

							%>
                        </td>
                    </tr>

                    <tr >
                        <td class="label"><fmt:message key="eMP.Suffix.label" bundle="${mp_labels}"/></td>

                        <td class='fields'>
                        <%
                        
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( name_suffix_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='name_suffix_accept_yn' id='name_suffix_accept_yn' value='Y'  onClick='checkLegalNames(6)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='name_suffix_accept_yn' id='name_suffix_accept_yn' value='Y' onClick='checkLegalNames(6)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( name_suffix_accept_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_name_suffix_accept_yn' id='d_name_suffix_accept_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_name_suffix_accept_yn' id='d_name_suffix_accept_yn' disabled>" ) ;
                            }
                        %>
                        </td>
						<td width="9%" class='fields'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ) ) {
                                    out.println( "<input type='text' name='name_suffix_length' id='name_suffix_length' value='"+name_suffix_length+"' maxlength='2' size='2' onblur='validatelength(this)'>" ) ;                     
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                    out.println( "<input type='text' name='name_suffix_length' id='name_suffix_length' value='"+name_suffix_length+"' maxlength='2' size='2' onblur='validatelength(this)' disabled>" ) ; 
                            }
                        %>
                        </td>
						<td width="10%">&nbsp;</td>
                        <td class='fields'>
                        <%
                       
						if ( operation.equalsIgnoreCase( "insert" ) ) {
                                if ( name_suffix_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y' onFocus='checkLegalNames(6)' onClick='checkLegalNames(6)' checked>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='name_suffix_reqd_yn' id='name_suffix_reqd_yn' value='Y' onFocus='checkLegalNames(6)' onClick='checkLegalNames(6)' >" ) ;
                            }

                            if ( operation.equalsIgnoreCase( "modify" ) ) {
                                if ( name_suffix_reqd_yn.equals( "Y" ) )
                                    out.println( "<input type='checkbox' name='d_name_suffix_reqd_yn' id='d_name_suffix_reqd_yn' checked disabled>" ) ;
                                else
                                    out.println( "<input type='checkbox' name='d_name_suffix_reqd_yn' id='d_name_suffix_reqd_yn' disabled>" ) ;
                            }
                        %>
                        </td>

                        <td class='label'>
                            &nbsp;
                        </td>

                        <td class='fields'>
                            <input type="text" name="name_suffix_prompt" id="name_suffix_prompt" size="15" maxlength="15" value="<%= name_suffix_prompt %>" onFocus='checkLegalNames(6)' onBlur="makeValidString(this)">
                        </td>
                        <td class='fields' colspan=2>
                        <!-- <input type="text" name="name_suffix_loc_lang_prompt" id="name_suffix_loc_lang_prompt" size="15" maxlength="15" value="<%= name_suffix_loc_lang_prompt %>" onFocus='checkLegalNames(6)' <%=ena_dis_loc_lang%> onblur='makeValidString(this)'>  -->

						<%

						out.println("<input type='text' name='name_suffix_loc_lang_prompt' id='name_suffix_loc_lang_prompt' size='15' maxlength='15' value='"+name_suffix_loc_lang_prompt+"' onFocus='checkLegalNames(6)' '"+ena_dis_loc_lang+"' onblur='makeValidString(this)'");

						if(language_direction.equals("R"))
						{
						out.println( "dir='RTL'> ");
						}else
						{
						out.println( " > ");
						}

						%>
                        </td>
                    </tr>
                </table>
			<table border='0' cellpadding='3' cellspacing='0' width='100%'>
				<tr> <td class='COLUMNHEADER' colspan='4'><fmt:message key="eMP.PatientNameDerivationLogic.label" bundle="${mp_labels}"/></td>
			</tr>
			 <tr>
                       <td class="label" nowrap width='30%'><fmt:message key="eMP.ForEnglish.label" bundle="${mp_labels}"/></td>
                        <td  nowrap class='fields' colspan='3'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ))
                                out.println( "<input type='text' name='name_dervn_logic' id='name_dervn_logic' value='" + name_dervn_logic + "' size='30' maxlength='50' onkeypress='return SplCharsChkForNameDrvn(event);' onBlur='checkNameDervnLogic(this);'>" ) ;

                            if (operation.equalsIgnoreCase( "modify" ))
                                out.println( "<input type='text' name='name_dervn_logic' id='name_dervn_logic' value='" + name_dervn_logic + "' size='30' maxlength='50' disabled>" ) ;
                        %>
						 <img src='../images/mandatory.gif'></img>
                        </td>
					</tr>
					<tr>
						<td class='label' nowrap ><fmt:message key="eMP.ForLocLang.label" bundle="${mp_labels}"/></td>
                        <td  nowrap class='fields' colspan='3'>
                        <%
						if (operation.equalsIgnoreCase( "insert" ))
							{
                                out.println( "<input type='text' name='for_loc_lang' id='for_loc_lang' value='" + name_dervn_logic_oth_lang + "' size='30' maxlength='50' onkeypress='return SplCharsChkForNameDrvn(event);' onBlur='checkNameDervnLogic(this);return SplCharsChkForNameDrvn(event)' ");

								if(language_direction.equals("R"))
								{
								out.println("dir='RTL'");
								}
												
								//out.println(" readonly>" ) ;
								out.println(" disabled >" ) ;
							}

                            if (operation.equalsIgnoreCase( "modify" ) )
							{	
                                out.println( "<input type='text' name='for_loc_lang' id='for_loc_lang' value='" + name_dervn_logic_oth_lang + "' size='30' maxlength='50' ") ;
								
								if(language_direction.equals("R"))
								{
								out.println("dir='RTL'");
								}
												
								out.println(" disabled >" ) ;
							}
                        %>
              			<img src='../images/mandatory.gif' id='myimage' style='visibility:hidden'></img>
						</td>
					</tr>
					<tr >
							<% if(module_instal_ind.equals("DMS")) { %>
							<td class='label' nowrap ><fmt:message key="eMP.UM_DefaultPatientNameInEnglish.label" bundle="${mp_labels}"/></td>
							<%}else {%>
							<td class='label' nowrap ><fmt:message key="eMP.DefaultPatientNameInEnglish.label" bundle="${mp_labels}"/></td>
							<%}%>
							<td class='fields' colspan='3'><input type='text' size='30' maxlength='15'  name = 'dflt_patient_name' value='<%=dflt_patient_name%>'>
							<img src='../images/mandatory.gif' id='dflt_patient_name_mand' style='visibility:hidden'></img></td>
                    </tr>
					
		
    </table>

		<table border='0' cellpadding='3' cellspacing='0' width='100%'>
				<tr> <td class='COLUMNHEADER' colspan='4'><fmt:message key="eMP.PatientLongNameDerivationLogic.label" bundle="${mp_labels}"/></td>
			</tr>
			 <tr>
                       <td class="label" nowrap width='30%'><fmt:message key="eMP.ForEnglish.label" bundle="${mp_labels}"/></td>
                        <td  nowrap class='fields' colspan='3'>
                        <%
                            if ( operation.equalsIgnoreCase( "insert" ))
                                out.println( "<input type='text' name='long_name_dervn_logic' id='long_name_dervn_logic' value='" + name_dervn_logic_long + "' size='60' maxlength='100' onkeypress='return SplCharsChkForNameDrvn(event);' onBlur='checkNameDervnLogic(this);'>" ) ;

                           String dis_able="";
						   if(! name_dervn_logic_long.equals("")){
							   dis_able="disabled";
						   }
							
							if (operation.equalsIgnoreCase( "modify" ))
                                out.println( "<input type='text' name='long_name_dervn_logic' id='long_name_dervn_logic' value='" + name_dervn_logic_long + "' size='60' maxlength='100' "+dis_able+">" ) ;
                        %>
						<!--  <img src='../images/mandatory.gif'></img> -->
                        </td>
					</tr>
					<tr>
						<td class='label' nowrap ><fmt:message key="eMP.ForLocLang.label" bundle="${mp_labels}"/></td>
                        <td  nowrap class='fields' colspan='3'>
                        <%
						if (operation.equalsIgnoreCase( "insert" ))
							{
                                out.println( "<input type='text' name='long_name_dervn_logic_local' id='long_name_dervn_logic_local' value='" + name_dervn_logic_oth_lang_long + "' size='60' maxlength='100' onkeypress='return SplCharsChkForNameDrvn(event);' onBlur='checkNameDervnLogic(this);return SplCharsChkForNameDrvn(event)' ");

								if(language_direction.equals("R"))
								{
								out.println("dir='RTL'");
								}
												
								//out.println(" >" ) ;
								out.println(" disabled >" ) ;
							}

                            if (operation.equalsIgnoreCase( "modify" ) )
							{	
                                out.println( "<input type='text' name='long_name_dervn_logic_local' id='long_name_dervn_logic_local'  value='" + name_dervn_logic_oth_lang_long + "' size='60' maxlength='100' ") ;
								
								if(language_direction.equals("R"))
								{
								out.println("dir='RTL'");
								}
												
								//out.println("  >" ) ;
								out.println(" disabled >" ) ;
							}
                        %>
              			
						</td>
					</tr>
					
					
		
    </table>
	
	<!--Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551-->
	<%if(isNameDervnLogicNBAppl){%>
	<table border='0' cellpadding='3' cellspacing='0' width='100%'>
		<tr>
			<td class='COLUMNHEADER' colspan='4'><fmt:message key="eMP.NewbornNameDervLogic.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr>
		    <td class="label" nowrap width='30%'><fmt:message key="eMP.ForEnglish.label" bundle="${mp_labels}"/></td>
			<td  nowrap class='fields' colspan='3'>
				<%
					String disable_dervn_logic_nb = "";
					
					if (name_dervn_logic_nb.equals(""))
					{
						disable_dervn_logic_nb = "";
					}else
					{
						disable_dervn_logic_nb = "disabled";
					}
					
					out.println( "<input type='text' name='name_dervn_logic_nb' id='name_dervn_logic_nb' value='" + name_dervn_logic_nb + "' size='30' maxlength='100' onkeypress='return SplCharsChkForNBNameDrvn(event);' onBlur='checkNBNameDervnLogic(this);' "+disable_dervn_logic_nb+">" ) ;
				%>
			<img src='../images/mandatory.gif'></img>
			</td>
		</tr>
    </table>
	
	<!--Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551.1-->
	<table border='0' cellpadding='3' cellspacing='0' width='100%'>
		<tr>
			<td class='COLUMNHEADER' colspan='4'><fmt:message key="eMP.NewbornNameDervLogicSB.label" bundle="${mp_labels}"/></td>
		</tr>
		<tr>
		    <td class="label" nowrap width='30%'><fmt:message key="eMP.ForEnglish.label" bundle="${mp_labels}"/></td>
			<td  nowrap class='fields' colspan='3'>
				<%
					String disable_dervn_logic_nb_sb = "";
					
					if (name_dervn_logic_nb_sb.equals(""))
					{
						disable_dervn_logic_nb_sb = "";
					}else
					{
						disable_dervn_logic_nb_sb = "disabled";
					}
					
					out.println( "<input type='text' name='name_dervn_logic_nb_sb' id='name_dervn_logic_nb_sb' value='" + name_dervn_logic_nb_sb + "' size='30' maxlength='100' onkeypress='return SplCharsChkForNBNameDrvn(event);' onBlur='checkNBNameDervnLogic(this);' "+disable_dervn_logic_nb_sb+">" ) ;
				%>
			<img src='../images/mandatory.gif'></img>
			</td>
		</tr>
    </table>
	<!--End ML-MMOH-CRF-1551.1-->
	<%}%>
	<!--End ML-MMOH-CRF-1551-->

<!-- Border test start -->

    </td>
    </tr>
    </table>

	</div>

<!-- Border test end -->

<!-- Ends Here -->

<!-- Border test start --> 


<input type="hidden" name="vairable_patient_id_length" id="vairable_patient_id_length" value="">
<input type="hidden" name="nb_use_mother_ser1" id="nb_use_mother_ser1" value="<%=nb_use_mother_ser%>">
   <!-- INCLUDE HERE 9/13/2006 -->
   
   <jsp:include page="../../eMP/jsp/mp_param_form_include.jsp" ><jsp:param name="flush" value="true" />
   <jsp:param name="module_instal_ind" 	value="<%=module_instal_ind%>"/>	
   <jsp:param name="operation" 	value="<%=operation%>" />
		<jsp:param name="alt_id1_accept_alphanumeric_yn" 	value="<%=alt_id1_accept_alphanumeric_yn%>" />
		<jsp:param name="Accept_oth_alt_id_yn" 	value="<%=Accept_oth_alt_id_yn%>" />
		<jsp:param name="alt_id1_type" 	value="<%=alt_id1_type%>" />
		<jsp:param name="alt_id2_type" 	value="<%=alt_id2_type%>" />
		<jsp:param name="alt_id3_type" 	value="<%=alt_id3_type%>" />
		<jsp:param name="alt_id4_type" 	value="<%=alt_id4_type%>" />
		<jsp:param name="alt_id1_chk_digit_scheme " 	value="<%=alt_id1_chk_digit_scheme%>" />
		<jsp:param name="alt_id2_chk_digit_scheme" 	value="<%=alt_id2_chk_digit_scheme%>" />
		<jsp:param name="alt_id3_chk_digit_scheme" 	value="<%=alt_id3_chk_digit_scheme%>" />
		<jsp:param name="alt_id4_chk_digit_scheme" 	value="<%=alt_id4_chk_digit_scheme%>" />
		<jsp:param name="alt_id1_length" 	value="<%=alt_id1_length%>" />
		<jsp:param name="alt_id2_length" 	value="<%=alt_id2_length%>" />
		<jsp:param name="alt_id3_length" 	value="<%=alt_id3_length%>" />
		<jsp:param name="alt_id4_length" 	value="<%=alt_id4_length%>" />
		<jsp:param name="alt_id1_len_validation_yn" 	value="<%=alt_id1_len_validation_yn%>" />
		<jsp:param name="alt_id2_len_validation_yn" 	value="<%=alt_id2_len_validation_yn%>" />
		<jsp:param name="alt_id3_len_validation_yn" 	value="<%=alt_id3_len_validation_yn%>" />
		<jsp:param name="alt_id4_len_validation_yn" 	value="<%=alt_id4_len_validation_yn%>" />
		<jsp:param name="alt_id1_reqd_yn" 	value="<%=alt_id1_reqd_yn%>" />
		<jsp:param name="alt_id2_reqd_yn" 	value="<%=alt_id2_reqd_yn%>" />
		<jsp:param name="alt_id3_reqd_yn" 	value="<%=alt_id3_reqd_yn%>" />
		<jsp:param name="alt_id4_reqd_yn" 	value="<%=alt_id4_reqd_yn%>" />
		<jsp:param name="alt_id1_unique_yn" 	value="<%=alt_id1_unique_yn%>" />
		<jsp:param name="alt_id2_unique_yn" 	value="<%=alt_id2_unique_yn%>" />
		<jsp:param name="alt_id3_unique_yn" 	value="<%=alt_id3_unique_yn%>" />
		<jsp:param name="alt_id4_unique_yn" 	value="<%=alt_id4_unique_yn%>" />
		<jsp:param name="alt_id1_exp_date_accept_yn" 	value="<%=alt_id1_exp_date_accept_yn%>" />
		<jsp:param name="alt_id2_exp_date_accept_yn" 	value="<%=alt_id2_exp_date_accept_yn%>" />
		<jsp:param name="alt_id3_exp_date_accept_yn" 	value="<%=alt_id3_exp_date_accept_yn%>" />
		<jsp:param name="alt_id4_exp_date_accept_yn" 	value="<%=alt_id4_exp_date_accept_yn%>" />
		<jsp:param name="alt_id1_exp_warn_yn" 	value="<%=alt_id1_exp_warn_yn%>" />
		<jsp:param name="alt_id2_exp_warn_yn" 	value="<%=alt_id2_exp_warn_yn%>" />
		<jsp:param name="alt_id3_exp_warn_yn" 	value="<%=alt_id3_exp_warn_yn%>" />
		<jsp:param name="alt_id4_exp_warn_yn" 	value="<%=alt_id4_exp_warn_yn%>" />
		<jsp:param name="alt_id1_invoke_routine" 	value="<%=alt_id1_invoke_routine%>" />
		<jsp:param name="alt_id2_invoke_routine" 	value="<%=alt_id2_invoke_routine%>" />
		<jsp:param name="alt_id3_invoke_routine" 	value="<%=alt_id3_invoke_routine%>" />
		<jsp:param name="alt_id4_invoke_routine" 	value="<%=alt_id4_invoke_routine%>" />
		<jsp:param name="alt_id1_routine_name" 	value="<%=alt_id1_routine_name%>" />
		<jsp:param name="alt_id2_routine_name" 	value="<%=alt_id2_routine_name%>" />
		<jsp:param name="alt_id3_routine_name" 	value="<%=alt_id3_routine_name%>" />
		<jsp:param name="allow_nb_regn_within_days"		value="<%=allow_nb_regn_within_days%>" />
		<jsp:param name="allow_nb_regn_unit"		value="<%=allow_nb_regn_unit%>" />
		<jsp:param name="mul_birth_regn_within_hours"		value="<%=mul_birth_regn_within_hours%>" />
		<jsp:param name="nb_use_mother_ser"		value="<%=nb_use_mother_ser%>" />
		<jsp:param name="review_nb_links_bef_reg_yn"		value="<%=review_nb_links_bef_reg_yn%>" />
		<jsp:param name="length_of_baby_yn"		value="<%=length_of_baby_yn%>" />
		<jsp:param name="head_circumference_of_baby_yn"		value="<%=head_circumference_of_baby_yn%>" />
		<jsp:param name="single_stage_nb_reg_appl_yn"		value="<%=single_stage_nb_reg_appl_yn%>" />
		<jsp:param name="mod_birth_reg_appl_yn"		value="<%=mod_birth_reg_appl_yn%>" /> 
		<jsp:param name="min_age_of_moth" 	value="<%=min_age_of_moth%>" />
		<jsp:param name="max_age_of_moth" 	value="<%=max_age_of_moth%>" />
		<jsp:param name="cut_age_of_moth" 	value="<%=cut_age_of_moth%>" />
		<jsp:param name="min_age_of_fath" 	value="<%=min_age_of_fath%>" />
		<jsp:param name="min_weight" 	value="<%=min_weight%>" />
		<jsp:param name="max_weight" 	value="<%=max_weight%>" />
		<jsp:param name="unit_of_wt_nb" 	value="<%=unit_of_wt_nb%>" />
		<jsp:param name="min_length" 	value="<%=min_length%>" />
		<jsp:param name="max_length" 	value="<%=max_length%>" />
		<jsp:param name="unit_of_circum_nb" 	value="<%=unit_of_circum_nb%>" />
		<jsp:param name="min_head_circum" 	value="<%=min_head_circum%>" />
		<jsp:param name="max_head_circum" 	value="<%=max_head_circum%>" />
		<jsp:param name="unit_of_length_nb" 	value="<%=unit_of_length_nb%>" />
		<jsp:param name="min_chest_circum" 	value="<%=min_chest_circum%>" />
		<jsp:param name="max_chest_circum" 	value="<%=max_chest_circum%>" />
		<jsp:param name="unit_of_chest_circum_nb" 	value="<%=unit_of_chest_circum_nb%>" />
		<jsp:param name="min_gestation" 	value="<%=min_gestation%>" />
		<jsp:param name="max_gestation" 	value="<%=max_gestation%>" />
		<jsp:param name="unit_of_gest_nb" 	value="<%=unit_of_gest_nb%>" />
		<jsp:param name="sub_multi_birth_hw" 	value="<%=sub_multi_birth_hw%>" />
		<jsp:param name="gestation_two_del" 	value="<%=gestation_two_del%>" />
		<jsp:param name="name_prefix_male_nb" 	value="<%=name_prefix_male_nb%>" />
		<jsp:param name="display_new_born_age" 	value="<%=display_new_born_age%>" />
		<jsp:param name="name_prefix_female_nb" 	value="<%=name_prefix_female_nb%>" />
		
		<jsp:param name="name_prefix_unknown_nb" 	value="<%=name_prefix_unknown_nb%>" /> 
		<jsp:param name="name_suffix_male_nb" 	value="<%=name_suffix_male_nb%>" />
		<jsp:param name="name_suffix_female_nb" 	value="<%=name_suffix_female_nb%>" />

		<jsp:param name="age_not_consider_natid" value="<%=age_not_consider_natid%>"/>
		<jsp:param name="nb_father_name_mandatory_yn" 	value="<%=nb_father_name_mandatory_yn%>" />
		<jsp:param name="data_upd_allowed_aft_final_yn" 	value="<%=data_upd_allowed_aft_final_yn%>" />
		
		<jsp:param name="nb_mother_dtls_update_yn" 	value="<%=nb_mother_dtls_update_yn%>" />

		<jsp:param name="accept_names_for_live_birth_yn" 	value="<%=accept_names_for_live_birth_yn%>" />
		<jsp:param name="dflt_race_nat_setup_nb_as_per" 	value="<%=dflt_race_nat_setup_nb_as_per%>" />
		<jsp:param name="dft_rel_male_nb" 	value="<%=dft_rel_male_nb%>" />
		<jsp:param name="dft_rel_female_nb" 	value="<%=dft_rel_female_nb%>" />
		<jsp:param name="dft_rel_unknown_nb" 	value="<%=dft_rel_unknown_nb%>" />
		<jsp:param name="alt_id1_adv_alert_reqd_yn" 	value="<%=alt_id1_adv_alert_reqd_yn%>" />
		<jsp:param name="alt_id2_adv_alert_reqd_yn" 	value="<%=alt_id2_adv_alert_reqd_yn%>" />
		<jsp:param name="alt_id3_adv_alert_reqd_yn" 	value="<%=alt_id3_adv_alert_reqd_yn%>" />
		<jsp:param name="alt_id4_adv_alert_reqd_yn" 	value="<%=alt_id4_adv_alert_reqd_yn%>" />
		<jsp:param name="alt_id1_adv_alert_days" 	value="<%=alt_id1_adv_alert_days%>" />
		<jsp:param name="alt_id2_adv_alert_days" 	value="<%=alt_id2_adv_alert_days%>" />
		<jsp:param name="alt_id3_adv_alert_days" 	value="<%=alt_id3_adv_alert_days%>" />
		<jsp:param name="alt_id4_adv_alert_days" 	value="<%=alt_id4_adv_alert_days%>" />
		<jsp:param name="alt_id1_exp_grace_days" 	value="<%=alt_id1_exp_grace_days%>" />
		<jsp:param name="alt_id2_exp_grace_days" 	value="<%=alt_id2_exp_grace_days%>" />
		<jsp:param name="alt_id3_exp_grace_days" 	value="<%=alt_id3_exp_grace_days%>" />
		<jsp:param name="alt_id4_exp_grace_days" 	value="<%=alt_id4_exp_grace_days%>" />
		<jsp:param name="alt_id4_routine_name" 	value="<%=alt_id4_routine_name%>" />
		
		<jsp:param name="addl_field1_prompt" 	value="<%=addl_field1_prompt%>" />
		<jsp:param name="addl_field2_prompt" 	value="<%=addl_field2_prompt%>" />
		<jsp:param name="addl_field3_prompt" 	value="<%=addl_field3_prompt%>" />
		<jsp:param name="addl_field4_prompt" 	value="<%=addl_field4_prompt%>" />
		<jsp:param name="addl_field5_prompt" 	value="<%=addl_field5_prompt%>" />
		<jsp:param name="addl_field1_length" 	value="<%=addl_field1_length%>" />
		<jsp:param name="addl_field2_length" 	value="<%=addl_field2_length%>" />
		<jsp:param name="addl_field3_length" 	value="<%=addl_field3_length%>" />
		<jsp:param name="addl_field4_length" 	value="<%=addl_field4_length%>" />
		<jsp:param name="addl_field5_length" 	value="<%=addl_field5_length%>" />
		<jsp:param name="sec11" 	value="<%=sec11%>" />
		<jsp:param name="sec12" 	value="<%=sec12%>" />
		<jsp:param name="sec13" 	value="<%=sec13%>" />
		<jsp:param name="sec21" 	value="<%=sec21%>" />
		<jsp:param name="sec22" 	value="<%=sec22%>" />
		<jsp:param name="sec23" 	value="<%=sec23%>" />
		<jsp:param name="sec31" 	value="<%=sec31%>" />
		<jsp:param name="sec32" 	value="<%=sec32%>" />
		<jsp:param name="sec33" 	value="<%=sec33%>" />
		<jsp:param name="sec41" 	value="<%=sec41%>" />
		<jsp:param name="sec42" 	value="<%=sec42%>" />
		<jsp:param name="sec43" 	value="<%=sec43%>" />
		<jsp:param name="sec51" 	value="<%=sec51%>" />
		<jsp:param name="sec52" 	value="<%=sec52%>" />
		<jsp:param name="sec53" 	value="<%=sec53%>" />
		<jsp:param name="chkAcceptNat" 	value="<%=chkAcceptNat%>" />
		<jsp:param name="chkdisAcceptothpatser" 	value="<%=chkdisAcceptothpatser%>" />
		<jsp:param name="alt_id1_accept_oth_pat_ser_yn" 	value="<%=alt_id1_accept_oth_pat_ser_yn%>" />
		<jsp:param name="alt_id1_chng_allowed_yn" 	value="<%=alt_id1_chng_allowed_yn%>" />

		<jsp:param name="dflt_relgn_code"				value="<%=dflt_relgn_code%>" />
		<jsp:param name="citizen_nationality_code"		value="<%=citizen_nationality_code%>" />
		<jsp:param name="default_race_code"				value="<%=default_race_code%>" />
		<jsp:param name="default_relationship_code"				value="<%=default_relationship_code%>" />
		<jsp:param name="max_patient_age" 				value="<%=max_patient_age%>" />
		<jsp:param name="dflt_alt_id1_in_emp_id_yn"		value="<%=dflt_alt_id1_in_emp_id_yn%>" />
		<jsp:param name="entitlement_by_pat_cat_yn"		value="<%=entitlement_by_pat_cat_yn%>" />
		<jsp:param name="suspend_service_yn"			value="<%=suspend_service_yn%>" />
		<jsp:param name="acpt_appt_rfrl_in_reg_pat_yn" 	value="<%=acpt_appt_rfrl_in_reg_pat_yn%>" />
		<jsp:param name="accept_pw_in_chng_pat_dtl_yn" 	value="<%=accept_pw_in_chng_pat_dtl_yn%>" />
		<jsp:param name="dflt_language_id"	value="<%=dflt_language_id%>" />
		<jsp:param name="inv_pat_search_in_reg_pat_yn" 	value="<%=inv_pat_search_in_reg_pat_yn%>" />
		<jsp:param name="race_required_yn" 	value="<%=race_required_yn%>" />
		<jsp:param name="round_dob_estd_age" 	value="<%=round_dob_estd_age%>" />
		<jsp:param name="gen_slno_unknown_pat_yn" 		value="<%=gen_slno_unknown_pat_yn%>" />
		<jsp:param name="gen_pid_using_aid1_rule_yn" 		value="<%=gen_pid_using_aid1_rule_yn%>" />
		<jsp:param name="patient_id_length" 		value="<%=patient_id_length%>" />
		<jsp:param name="still_born_prefix" 		value="<%=still_born_prefix%>" />
		<jsp:param name="pat_photo_renewal_alert_days" 		value="<%=pat_photo_renewal_alert_days%>" />

		<jsp:param name="mortuary_release_yn" 		value="<%=mortuary_release_yn%>" />
		<jsp:param name="no_days_before_deceased" 		value="<%=no_days_before_deceased%>" />
		<jsp:param name="cancel_reason_code" 		value="<%=cancel_reason_code%>" />
		<jsp:param name="pat_search_tab" 		value="<%=pat_search_tab%>" />
		<jsp:param name="country_reqd_yn" 	value="<%=country_reqd_yn%>" />
		<jsp:param name="region_reqd_yn" 	value="<%=region_reqd_yn%>" />
		<jsp:param name="mobile_no_reqd_yn" 	value="<%=mobile_no_reqd_yn%>" />
		<jsp:param name="email_id_reqd_yn" 	value="<%=email_id_reqd_yn%>" />
		<jsp:param name="postal_cd_reqd_yn" 	value="<%=postal_cd_reqd_yn%>" />
		<jsp:param name="area_reqd_yn" 	value="<%=area_reqd_yn%>" />
		<jsp:param name="religion_reqd_yn"   value="<%=religion_reqd_yn%>"/>   
		<jsp:param name="pat_ser_access_by_user_yn" 	value="<%=pat_ser_access_by_user_yn%>" />
		<jsp:param name="upt_contact_dtls_oa_yn" 	value="<%=upt_contact_dtls_oa_yn%>" />
		<jsp:param name="alt_id2_accept_oth_pat_ser_yn" 	value="<%=alt_id2_accept_oth_pat_ser_yn%>" />
		<jsp:param name="alt_id2_chng_allowed_yn"		value="<%=alt_id2_chng_allowed_yn%>" />			
		<jsp:param name="alt_id2_accept_alphanumeric_yn"		value="<%=alt_id2_accept_alphanumeric_yn%>" />		
		<jsp:param name="alt_id3_accept_oth_pat_ser_yn"			value="<%=alt_id3_accept_oth_pat_ser_yn%>" />		
		<jsp:param name="alt_id3_chng_allowed_yn"		 value="<%=alt_id3_chng_allowed_yn%>" />			
		<jsp:param name="alt_id3_accept_alphanumeric_yn"		value="<%=alt_id3_accept_alphanumeric_yn%>" />		
		<jsp:param name="alt_id4_accept_oth_pat_ser_yn"			value="<%=alt_id4_accept_oth_pat_ser_yn%>" />		
		<jsp:param name="alt_id4_chng_allowed_yn"		 value="<%=alt_id4_chng_allowed_yn%>" />			
		<jsp:param name="alt_id4_accept_alphanumeric_yn"		value="<%=alt_id4_accept_alphanumeric_yn%>" />	
		<jsp:param name="upd_pat_dtls_referral_yn"		value="<%=upd_pat_dtls_referral_yn%>" />	
		<jsp:param name="disp_cancelled_previous_enc_yn"		value="<%=disp_cancelled_previous_enc_yn%>" />	
		<jsp:param name="unmask_aadhaar_num_yn"		value="<%=unmask_aadhaar_num_yn%>" /> 	
		<jsp:param name="unmask_abha_num_addr_yn"		value="<%=unmask_abha_num_addr_yn%>" />
		
		<jsp:param name="alt_id1_alphanum_validate_yn"		value="<%=alt_id1_alphanum_validate_yn%>" />	
		<jsp:param name="alt_id2_alphanum_validate_yn"		value="<%=alt_id2_alphanum_validate_yn%>" />	
		<jsp:param name="alt_id3_alphanum_validate_yn"		value="<%=alt_id3_alphanum_validate_yn%>" />	
		<jsp:param name="alt_id4_alphanum_validate_yn"		value="<%=alt_id4_alphanum_validate_yn%>" />	
		
		<jsp:param name="alt_id1_start_with"		value="<%=alt_id1_start_with%>" />	
		<jsp:param name="alt_id2_start_with"		value="<%=alt_id2_start_with%>" />	
		<jsp:param name="alt_id3_start_with"		value="<%=alt_id3_start_with%>" />	
		<jsp:param name="alt_id4_start_with"		value="<%=alt_id4_start_with%>" />
		
		<jsp:param name="ALT_ID1_PAT_SCH_EXACT_YN"		value="<%=ALT_ID1_PAT_SCH_EXACT_YN%>" />
		<jsp:param name="ALT_ID2_PAT_SCH_EXACT_YN"		value="<%=ALT_ID2_PAT_SCH_EXACT_YN%>" />
		<jsp:param name="ALT_ID3_PAT_SCH_EXACT_YN"		value="<%=ALT_ID3_PAT_SCH_EXACT_YN%>" />
		<jsp:param name="ALT_ID4_PAT_SCH_EXACT_YN"		value="<%=ALT_ID4_PAT_SCH_EXACT_YN%>" />
		<jsp:param name="aadhar_config_enabled_yn"		value="<%=aadhaar_config_enabled_yn%>" /> 			
		<jsp:param name="aadhar_option_value"		value="<%=aadhaar_option_value%>" /> 	
		<jsp:param name="isUHID_valid_appl"		value="<%=isUHID_valid_appl%>" />  
		<jsp:param name="no_days_UHID_valid"		value="<%=no_days_UHID_valid%>" /> 
		<jsp:param name="age_not_consider_natid_altid" value="<%=age_not_consider_natid_altid%>"/>
	    <jsp:param name="patientcategory_reqd_yn" 	value="<%=patientcategory_reqd_yn%>" /> 
	    <jsp:param name="town_reqd_yn" 	value="<%=town_reqd_yn%>" /> 
	    <jsp:param name="death_reg_form_req_yn" 	value="<%=death_reg_form_req_yn%>" /> 
		<jsp:param name="allow_ext_nb_regn_within_days"		value="<%=allow_ext_nb_regn_within_days%>" />
		<jsp:param name="mandate_first_newborn_yn"		value="<%=mandate_first_newborn_yn%>" />
		<jsp:param name="mandate_first_newborn_ip_yn"		value="<%=mandate_first_newborn_ip_yn%>" />
		<jsp:param name="mandate_first_newborn_ae_yn"		value="<%=mandate_first_newborn_ae_yn%>" />
		<jsp:param name="mandate_second_newborn_yn"		value="<%=mandate_second_newborn_yn%>" />
		<jsp:param name="mandate_second_newborn_ip_yn"		value="<%=mandate_second_newborn_ip_yn%>" />
		<jsp:param name="mandate_second_newborn_ae_yn"		value="<%=mandate_second_newborn_ae_yn%>" />
		<jsp:param name="mandate_third_newborn_yn"		value="<%=mandate_third_newborn_yn%>" />
		<jsp:param name="mandate_third_newborn_ip_yn"		value="<%=mandate_third_newborn_ip_yn%>" />
		<jsp:param name="mandate_third_newborn_ae_yn"		value="<%=mandate_third_newborn_ae_yn%>" />
		<jsp:param name="mand_antenatal_newborn_yn"		value="<%=mand_antenatal_newborn_yn%>" />
		<jsp:param name="mand_antenatal_newborn_ip_yn"		value="<%=mand_antenatal_newborn_ip_yn%>" />
		<jsp:param name="mand_antenatal_newborn_ae_yn"		value="<%=mand_antenatal_newborn_ae_yn%>" />
		<jsp:param name="mand_parity_newborn_yn"		value="<%=mand_parity_newborn_yn%>" />
		<jsp:param name="mand_parity_newborn_ip_yn"		value="<%=mand_parity_newborn_ip_yn%>" />
		<jsp:param name="mand_parity_newborn_ae_yn"		value="<%=mand_parity_newborn_ae_yn%>" />
		<jsp:param name="invoke_menstrual_history_yn" value="<%=invoke_menstrual_history_yn%>"/>
		<jsp:param name="first_name_accept_yn"		value="<%=first_name_accept_yn%>" />
		<jsp:param name="first_name_reqd_yn"		value="<%=first_name_reqd_yn%>" />
		<jsp:param name="first_name_order"		value="<%=first_name_order%>" />
		<jsp:param name="first_name_prompt"		value="<%=first_name_prompt%>" />
		<jsp:param name="second_name_accept_yn"		value="<%=second_name_accept_yn%>" />
		<jsp:param name="second_name_reqd_yn"		value="<%=second_name_reqd_yn%>" />
		<jsp:param name="second_name_order"		value="<%=second_name_order%>" />
		<jsp:param name="second_name_prompt"		value="<%=second_name_prompt%>" />
		<jsp:param name="third_name_accept_yn"		value="<%=third_name_accept_yn%>" />
		<jsp:param name="third_name_reqd_yn"		value="<%=third_name_reqd_yn%>" />
		<jsp:param name="third_name_order"		value="<%=third_name_order%>" />
		<jsp:param name="third_name_prompt"		value="<%=third_name_prompt%>" />
		<jsp:param name="family_name_accept_yn"		value="<%=family_name_accept_yn%>" />
		<jsp:param name="family_name_reqd_yn"		value="<%=family_name_reqd_yn%>" />
		<jsp:param name="family_name_order"		value="<%=family_name_order%>" />
		<jsp:param name="family_name_prompt"		value="<%=family_name_prompt%>" />
		<jsp:param name="enable_marital_status"		value="<%=enable_marital_status%>" />
		<jsp:param name="dflt_father_first_name_prompt"		value="<%=dflt_father_first_name_prompt%>" />
		<jsp:param name="dflt_father_Second_name_prompt"		value="<%=dflt_father_Second_name_prompt%>" />
		<jsp:param name="dflt_father_third_name_prompt"		value="<%=dflt_father_third_name_prompt%>" />
		<jsp:param name="dflt_father_family_name_prompt"		value="<%=dflt_father_family_name_prompt%>" />
		<jsp:param name="occupation_reqd_yn" 	value="<%=occupation_reqd_yn%>" /> 
		<jsp:param name="marital_status_reqd_yn" 	value="<%=marital_status_reqd_yn%>" /> 
		<jsp:param name="abha_eng_audio_path"		value="<%=abha_eng_audio_path%>" />
		<jsp:param name="abha_hin_audio_path"		value="<%=abha_hin_audio_path%>" />
		<jsp:param name="mand_visit_admssn_reg_yn" 	value="<%=mand_visit_admssn_reg_yn%>" />
	    
</jsp:include>
y<%-- This param is removed as it is not required for That
	   	<jsp:param name="invoke_chg_pat_dtls_fm_nb_yn" 	value="<%=invoke_chg_pat_dtls_fm_nb_yn%>" /> 
 --%>

<!-- Border test end --> 

    
    <!-- For tab 2 -->

    <input type="hidden" name="ethnic_sndx_type" id="ethnic_sndx_type"        value="<%= ethnic_sndx_type         %>">
    <input type='hidden' name='general_alert_yn' id='general_alert_yn' value='N'>
    <!-- For tab 3 -->

	<!-- Hidden values of nat_id_count and alt_id_count-->
	
	<input type="hidden" name="nat_id_count" id="nat_id_count"				value="<%= nat_id_count%>">
	<input type="hidden" name="alt_id_count" id="alt_id_count"				value="<%= alt_id_count %>">
	
	<input type="hidden" name="dflt_contact_mode1" id="dflt_contact_mode1"      value="<%= dflt_contact_mode1       %>">
    <input type="hidden" name="dflt_contact_mode2" id="dflt_contact_mode2"      value="<%= dflt_contact_mode2       %>">
    <input type="hidden" name="dflt_contact_mode3" id="dflt_contact_mode3"      value="<%= dflt_contact_mode3       %>">
    <input type="hidden" name="dflt_contact_mode4" id="dflt_contact_mode4"      value="<%= dflt_contact_mode4       %>">
    <input type="hidden" name="dflt_contact_mode5" id="dflt_contact_mode5"      value="<%= dflt_contact_mode5       %>">
    <input type="hidden" name="family_org_id_accept_yn_new" id="family_org_id_accept_yn_new"      value="N">
    <!--<input type="hidden" name="name_in_oth_lang_yn" id="name_in_oth_lang_yn"     value="<%= name_in_oth_lang_yn%>">-->
	
	<!--Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551-->
	<input type="hidden" name="isNameDervnLogicNBAppl" id="isNameDervnLogicNBAppl" value="<%=isNameDervnLogicNBAppl%>">

    <!-- For tab 6 -->
	
    <input type="hidden" name="hr_interface_yn" id="hr_interface_yn"     value="<%= hr_interface_yn      %>">
    <input type="hidden" name="his_interface_yn" id="his_interface_yn"        value="<%= his_interface_yn     %>">
    <input type="hidden" name="age_limit_for_service" id="age_limit_for_service"   value="<%= age_limit_for_service    %>">
    <input type="hidden" name="hr_check_digit_scheme" id="hr_check_digit_scheme"   value="<%= hr_check_digit_scheme    %>">
    
    <input type="hidden" name="operation" id="operation"           value="<%= operation %>">
	 <input type="hidden" name="module_instal_ind" id="module_instal_ind"     value="<%= module_instal_ind  %>">
<%
    if ( operation.equalsIgnoreCase( "modify" ) ) {
%>
		<input type="hidden" name="chart_maintenance" id="chart_maintenance"       value="<%= single_or_multi_files_ind %>">
        <input type="hidden" name="separate_file_no_yn" id="separate_file_no_yn"     value="<%= separate_file_no_yn  %>">
        <input type="hidden" name="name_prefix_accept_yn" id="name_prefix_accept_yn"   value="<%= name_prefix_accept_yn    %>">
        <input type="hidden" name="name_prefix_reqd_yn" id="name_prefix_reqd_yn"     value="<%= name_prefix_reqd_yn  %>">
        <input type="hidden" name="name_prefix_reqd_yn" id="name_prefix_reqd_yn"     value="<%= name_prefix_reqd_yn  %>">
        <input type="hidden" name="first_name_accept_yn" id="first_name_accept_yn"    value="<%= first_name_accept_yn     %>">
        <input type="hidden" name="first_name_reqd_yn" id="first_name_reqd_yn"      value="<%= first_name_reqd_yn   %>">
        <input type="hidden" name="second_name_accept_yn" id="second_name_accept_yn"   value="<%= second_name_accept_yn    %>">
        <input type="hidden" name="second_name_reqd_yn" id="second_name_reqd_yn"     value="<%= second_name_reqd_yn  %>">
        <input type="hidden" name="second_name_order" id="second_name_order"       value="<%= second_name_order        %>">
        <input type="hidden" name="third_name_accept_yn" id="third_name_accept_yn"    value="<%= third_name_accept_yn     %>">
        <input type="hidden" name="third_name_reqd_yn" id="third_name_reqd_yn"      value="<%= third_name_reqd_yn   %>">
        <input type="hidden" name="third_name_order" id="third_name_order"        value="<%= third_name_order     %>">
        <input type="hidden" name="family_name_accept_yn" id="family_name_accept_yn"   value="<%= family_name_accept_yn    %>">
        <input type="hidden" name="family_name_reqd_yn" id="family_name_reqd_yn"     value="<%= family_name_reqd_yn  %>">
        <input type="hidden" name="family_name_order" id="family_name_order"       value="<%= family_name_order        %>">
        <input type="hidden" name="name_suffix_accept_yn" id="name_suffix_accept_yn"   value="<%= name_suffix_accept_yn    %>">
        <input type="hidden" name="name_suffix_reqd_yn" id="name_suffix_reqd_yn"     value="<%= name_suffix_reqd_yn  %>">
        <input type="hidden" name="alt_id1_type" id="alt_id1_type"            value="<%= alt_id1_type         %>">
        <input type="hidden" name="alt_id1_length" id="alt_id1_length"      value="<%= alt_id1_length       %>">
        <input type="hidden" name="alt_id1_len_validation_yn" id="alt_id1_len_validation_yn" value ="<%= alt_id1_len_validation_yn %>"> 
        <input type="hidden" name="alt_id1_reqd_yn" id="alt_id1_reqd_yn"     value="<%= alt_id1_reqd_yn      %>">
        <input type="hidden" name="alt_id1_exp_date_accept_yn" id="alt_id1_exp_date_accept_yn" value ="<%= alt_id1_exp_date_accept_yn %>"> 
        <input type="hidden" name="alt_id1_unique_yn" id="alt_id1_unique_yn"       value="<%= alt_id1_unique_yn        %>">
        <input type="hidden" name="alt_id1_exp_warn_yn" id="alt_id1_exp_warn_yn"     value="<%= alt_id1_exp_warn_yn  %>">
        <input type="hidden" name="alt_id2_type" id="alt_id2_type"            value="<%= alt_id2_type         %>">
        <input type="hidden" name="alt_id2_length" id="alt_id2_length"      value="<%= alt_id2_length       %>">
        <input type="hidden" name="alt_id2_len_validation_yn" id="alt_id2_len_validation_yn" value ="<%= alt_id2_len_validation_yn %>">
        <input type="hidden" name="alt_id2_reqd_yn" id="alt_id2_reqd_yn"     value="<%= alt_id2_reqd_yn      %>">
        <input type="hidden" name="alt_id2_exp_date_accept_yn" id="alt_id2_exp_date_accept_yn" value ="<%= alt_id2_exp_date_accept_yn %>">
        <input type="hidden" name="alt_id2_unique_yn" id="alt_id2_unique_yn"       value="<%= alt_id2_unique_yn        %>">
        <input type="hidden" name="alt_id2_exp_warn_yn" id="alt_id2_exp_warn_yn"     value="<%= alt_id2_exp_warn_yn  %>">
        <input type="hidden" name="alt_id3_type" id="alt_id3_type"            value="<%= alt_id3_type         %>">
        <input type="hidden" name="alt_id3_length" id="alt_id3_length"      value="<%= alt_id3_length       %>">
        <input type="hidden" name="alt_id3_len_validation_yn" id="alt_id3_len_validation_yn" value ="<%= alt_id3_len_validation_yn %>">
        <input type="hidden" name="alt_id3_reqd_yn" id="alt_id3_reqd_yn"     value="<%= alt_id3_reqd_yn      %>">
        <input type="hidden" name="alt_id3_exp_date_accept_yn" id="alt_id3_exp_date_accept_yn" value ="<%= alt_id3_exp_date_accept_yn %>">
        <input type="hidden" name="alt_id3_unique_yn" id="alt_id3_unique_yn"       value="<%= alt_id3_unique_yn        %>">
        <input type="hidden" name="alt_id3_exp_warn_yn" id="alt_id3_exp_warn_yn"     value="<%= alt_id3_exp_warn_yn  %>">
        <input type="hidden" name="alt_id4_type" id="alt_id4_type"            value="<%= alt_id4_type         %>">
        <input type="hidden" name="alt_id4_length" id="alt_id4_length"      value="<%= alt_id4_length       %>">
        <input type="hidden" name="alt_id4_len_validation_yn" id="alt_id4_len_validation_yn" value ="<%= alt_id4_len_validation_yn %>">
        <input type="hidden" name="alt_id4_reqd_yn" id="alt_id4_reqd_yn"     value="<%= alt_id4_reqd_yn      %>">
        <input type="hidden" name="alt_id4_exp_date_accept_yn" id="alt_id4_exp_date_accept_yn" value ="<%= alt_id4_exp_date_accept_yn %>">
        <input type="hidden" name="alt_id4_unique_yn" id="alt_id4_unique_yn"       value="<%= alt_id4_unique_yn        %>">
        <input type="hidden" name="alt_id4_exp_warn_yn" id="alt_id4_exp_warn_yn"     value="<%= alt_id4_exp_warn_yn  %>">

        <input type="hidden" name="mpDisableFieldsNBFather" id="mpDisableFieldsNBFather"     value="<%=mpDisableFieldsNBFather%>">
       
		<input type="hidden" name="dcount" id="dcount" >
		<input type="hidden" name="ccount" id="ccount" >
		<input type="hidden" name="fcount" id="fcount" >
		<input type="hidden" name="ecount" id="ecount">
		<input type="hidden" name="ocount" id="ocount">
		<input type="hidden" name="ncount" id="ncount">
        <% }else
			{%>
		<input type="hidden" name="dcount" id="dcount" >
		<input type="hidden" name="ccount" id="ccount" >
		<input type="hidden" name="fcount" id="fcount" >
		<input type="hidden" name="ecount" id="ecount">
		<input type="hidden" name="ocount" id="ocount">
		<input type="hidden" name="ncount" id="ncount">
		<%}%>
    </form>
</center>
		<script>
			//onLoad='enableNatFields(document.mp_param_form.accept_national_id_no_yn);'
			enableNatFields(document.mp_param_form.accept_national_id_no_yn,'Y');
			assignCountValues();
		</script>
</body>
<script>checkValidity()</script>
<%
	// Onload event function for Accept Patient name as multiParts
	if (operation.equals("insert"))
		out.println("<script>enableName();</script>");
	if(pst1!=null) pst1.close();
    if(pstmt != null ) pstmt.close() ;
	if(pst!=null) pst.close();
	if(stmt11 != null)    stmt11.close();
	if(stmt != null)    stmt.close();
	if(res1!=null) res1.close();
    if(rset != null)    rset.close();
    if(rset11 != null)    rset11.close();
	if(rs!= null ) rs.close() ;
	if(res!=null) res.close();
		if(name_in_oth_lang_yn.equals("Y")){
		%>
		<script>document.getElementById('dflt_patient_name_mand').style.visibility= 'visible';</script>
		<%}					
	}
	catch( Exception ce ) {ce.printStackTrace();}
    finally
    {
        
        if(con != null) ConnectionManager.returnConnection(con,request);
    }
%>
</html>

	<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

