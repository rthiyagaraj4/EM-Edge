
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page import="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,java.util.HashMap,java.util.Properties, java.util.ArrayList, java.text.SimpleDateFormat, com.ehis.util.*, webbeans.eCommon.ConnectionManager,eCommon.Common.*,org.json.simple.*" contentType="text/html;charset=UTF-8"%>
  <% 
	Properties p		= (java.util.Properties) session.getValue("jdbc");
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	HashMap mPParamDtls =  new HashMap(); 
   	HashMap mthrDtls				= new HashMap();
    HashMap hashMap3				= new HashMap();
    HashMap hashMap10				= new HashMap();
    HashMap hashMap11				= new HashMap();
    HashMap hashMap12				= new HashMap();
    HashMap hashMap13				= new HashMap();
    HashMap hashMap					= new HashMap();
	ArrayList array_list			= new ArrayList();
	
	String emer_regn_nb_yn			= "N";	//Added by Sangeetha for ML-MMOH-CRF-0631 on 14/Aug/17
	ArrayList column_name=new ArrayList();/*Added by Rameswar on 30th July 2015 against HSA_CRF_0305 IN054700*/
	String nb_father_name_mandatory_yn = "";
	String newborn_pat_ser_grp = "";
	String nb_dflt_relnship_code = "";
	
	String dis_bed_fields ="", accessRights = "", q_gestational_period = "", q_gestational_period_days = "", getAllowNewBornDate = "", patency_sel1 = "" ,patency_sel2 = "", old_bed_number = "", pseudo_bed_yn = "", alt_id1_type_desc = "", alt_id2_type_desc = "", alt_id3_type_desc = "", alt_id4_type_desc = "", oth_alt_id_type = "", mthr_oth_alt_id_type = "", cd1 = "", cd2 = "", cd3 = "", cd4 = "", alt_id1_type = "", alt_id1_length = "", alt_id2_length = "", alt_id3_length = "", alt_id4_length = "", alt_id1_len_validation_yn = "", alt_id1_routine_yn = "", alt_id1_data_source_id = "", alt_id1_chk_digit_scheme = "" , alt_id1_accept_alphanumeric_yn	= "", nat_id_accept_alphanumeric_yn	= "", name_dervn_logic = "", name_dervn_logic_long = "", name_dervn_logic_oth_lang = "", name_dervn_logic_oth_lang_long = "", race_required_yn="", race_style = "visibility:hidden", single_stage_nb_reg_appl_yn = "N", MC_Dtls_YN="", cong_anom_desc = "", dely_ind_desc = "", q_compln_pregnancy_desc = "", q_compln_nr_pregnancy_desc = "", q_compln_dely_desc = "", q_proc_class_desc = "", q_vaginal_dely_type_desc = "", q_dely_surg_class_desc = "", q_nb_compln_dely_desc = "";
	boolean birth_order_format=false;
	String heart_rate_in_1_min="", heart_rate_in_5_min="", heart_rate_in_10_min="", breathing_in_1_min="", breathing_in_5_min="", breathing_in_10_min="", grimace_in_1_min="", grimace_in_5_min="", grimace_in_10_min="", activity_in_1_min="", activity_in_5_min="", activity_in_10_min="", appearance_in_1_min="", appearance_in_5_min="", appearance_in_10_min="";
	Boolean isModifyLongShortDescAppl = false;//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	java.sql.Statement stmt =null;
	ResultSet rs=null,rs1=null;
	    PreparedStatement newbornstmt	= null;
	    PreparedStatement pstmt1	= null;  //68508
		ResultSet newbornrs			    = null;
		String national_id="", other_alter_id ="";
		PreparedStatement newbornstmt1	= null;
		ResultSet newbornrs1 = null;
	String accession_no=""; //Ashwini Added for MO-CRF-20108
	String single_stage_appl_yn=""; //Ashwini Added for MO-CRF-20108
	String modify_delivery_type="";
	String facilityId       = (String) session.getValue("facility_id");
	String bl_install_yn	= (String) session.getValue("mp_bl_oper_yn");
    String function_id1			= checkForNull(request.getParameter("function_id"));
    String function_id			= checkForNull(request.getParameter("function_id_new"));
	String ca_encounter_id="", mother_patient_id="", ca_delivery_type="", ca_attend_pract_id="", ca_attend_pract_id_desc="", ca_attend_nurse_id="", ca_attend_nurse_id_desc="", ca_proc_classification="", ca_proc_classification_desc="", ca_del_surg_classification="", ca_del_surg_classification_desc="", ca_vaginal_delivery_type="", ca_vaginal_delivery_type_desc="", ca_no_of_births="", ca_comp_in_del_stage1="", ca_comp_in_del_stage2="", ca_comp_in_del_stage3="", ca_comp_of_delivery="", ca_comp_of_delivery_desc="", ca_foetus_comp_of_delivery="", ca_foetus_comp_of_delivery_desc="", captureAntenatalDtlsYN = "N", called_function = "";
	String new_function_id = function_id;
	String motherid	= checkForNull(request.getParameter("mother_id"));//mother Patient ID
	String siteId	= checkForNull(request.getParameter("siteId"));
    String motherencounterid		= request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
    String invoked_from				= request.getParameter("invoked_from") == null ? "" : request.getParameter("invoked_from");
	String inhousebirthyn			= request.getParameter("inhouse_birth_yn") == null ? "" : request.getParameter("inhouse_birth_yn");
	String unitofwtnb = "",  unitofcircumnb = "",  unitofchestunit = "",  unitoflengthnb = "",  unitofgestnb	= "",      namesuffixmalenb	= "",  namesuffixfemalenb = "",      nb_use_mother_ser = "",  relation_mcode = "",  relation_mdesc = "";
	String page_colour				= request.getParameter("page_colour") == null ? "" : request.getParameter("page_colour");
	String called_from_mothercare	= request.getParameter("called_from_mothercare") == null ? "" : request.getParameter("called_from_mothercare");
	mother_patient_id				= request.getParameter("mother_patient_id") == null ? "" : request.getParameter("mother_patient_id");
	if(mother_patient_id==null || mother_patient_id.equals("null")){
		mother_patient_id="";
	}
	ca_encounter_id					= request.getParameter("ca_encounter_id") == null ? "" : request.getParameter("ca_encounter_id"); 	
 	String parent_details		=  "";
	String parent_details1 = "";	
	if (called_from_mothercare.equals("MC") && !ca_encounter_id.equals(""))
		motherencounterid = ca_encounter_id;
	String function_invoked		= request.getParameter("function_invoked") == null ? "" : request.getParameter("function_invoked");
	String module_invoked		= request.getParameter("module_invoked")==null?"":request.getParameter("module_invoked");
	String calling_module_id	= request.getParameter("calling_module_id")==null?"":request.getParameter("calling_module_id");  
	String mother_nursing_unit	= request.getParameter("mother_nursing_unit") == null ? "" : request.getParameter("mother_nursing_unit");
	String outcome	= request.getParameter("outcome") == null ? "" : request.getParameter("outcome");	
	String disable_button_yn= request.getParameter("disable_button_yn") == null ? "N" : request.getParameter("disable_button_yn");
	String mother_pat_id=request.getParameter("mother_pat_id") == null ? "" : request.getParameter("mother_pat_id");
	String finalized_mult_birth_yn=request.getParameter("finalized_mult_birth_yn") == null ? "N" : request.getParameter("finalized_mult_birth_yn");//this CRF HSA-CRF-0182 Linked incident [54324]
	String disable_finalized_button_yn=request.getParameter("disable_finalized_button_yn") == null ? "" : request.getParameter("disable_finalized_button_yn");
	String resuscitated_pract_id=request.getParameter("resuscitated_pract_id") == null ? "" : request.getParameter("resuscitated_pract_id");
	String resuscitated_pract_desc=request.getParameter("resuscitated_pract_desc") == null ? "" : request.getParameter("resuscitated_pract_desc");
	String born_where=request.getParameter("born_where") == null ? "" : request.getParameter("born_where");
	String babyoutcome=request.getParameter("outcome") == null ? "" : request.getParameter("outcome");
	String newbornReg=request.getParameter("newbornReg") == null ? "N" : request.getParameter("newbornReg");
	String mother_bed_no		= request.getParameter("mother_bed_no") == null ? "" : request.getParameter("mother_bed_no");
    String function_name 	= request.getParameter( "function_name" ) ;
	if ( function_name	== null ) function_name	= "" ;
	String invoke_adm_from_newborn_yn		= request.getParameter("invoke_adm_from_newborn_yn") == null ? "N" : request.getParameter("invoke_adm_from_newborn_yn");
	String newTransactionYN		= request.getParameter("newTransactionYN") == null ? "Y" : request.getParameter("newTransactionYN");	
	String finalizeYN = request.getParameter("finalizeYN") == null ? "N" : request.getParameter("finalizeYN");
	
	if(function_id.equals("MAINTAIN_BIRTH")) {
		finalizeYN = "Y"; 		
	}
	if(calling_module_id.equals("IP")) { 
		called_function = "IP";
	} else if(calling_module_id.equals("AE")) { //Added by Dharma on Aug 3rd 2017 against ML-MMOH-CRF-0631 [IN:062148]
		called_function = "AE";
	} else {
		called_function = "MP";
	}
	if(called_function.equals("IP") || function_id.equals("MAINTAIN_BIRTH")) {
		captureAntenatalDtlsYN = "Y";
	}
	String regnStatus = request.getParameter("regnStatus") == null ? "" : request.getParameter("regnStatus"); 
	String current_date = "", desc = "", sel1 = "", sel2 = "";
    String gestDaysDisabled			= "disabled";   
	String ip_install_yn = request.getParameter("ip_install_yn") == null ? "" : request.getParameter("ip_install_yn");
	String q_birth_order = "",  q_parity = "",  q_gravida = "",  q_remarks = "",  q_father_patient_id = "",  q_father_name  = "",  q_father_name_long  = "",  q_father_name_long_loc_lang  = "",    q_nb_patient_name = "",  q_father_national_id_no  = "",  q_father_oth_alt_id_type  = "",  q_FATHER_OTH_ALT_ID_NO  = "",  q_father_nationality_code = "",  q_father_nationality_desc = "",  q_race_code  = "",  q_father_religion_code  = "",  q_father_ocpn_class_code = "",  q_father_ocpn_desc = "",  q_father_remarks = "",  q_father_govemp = "",  fathr_ocpn_code = "",  q_race_desc  = "",  q_father_religion_desc = "",  min_weight = "",  max_weight = "",  min_chest_circum = "",  max_chest_circum = "",  min_head_circum = "",   max_head_circum = "",   min_length = "",  max_length = "",  min_gestation = "",  max_gestation = "",  nb_male_relnship = "",  nb_female_relnship = "",  nb_unknown_relnship = "",  father_alt_id1_no_value = "",  father_alt_id2_no_value = "",  father_alt_id3_no_value = "",  father_alt_id4_no_value = "",  pat_name_as_multipart_yn     = "",  accept_national_id_no_yn     = "",  accept_oth_alt_id_yn = "",  mp_param_sysdate = "",  mp_param_reqdate = "",  multidisabled = "",  multibirthvalue = "N",  gestdisabled = "",  gestdisabled1 = "",  multi_check = "",  FAMILY_ORG_ID_ACCEPT_YN = "",  FAMILY_NO_LINK_YN = "",  nat_data_source_id = "",  nat_id_check_digit_id = "",  nat_id_chk_len = "",  nat_invoke_routine = "",  entitlement_by_pat_cat_yn = "",   child_mandatory = "",  cat_mandatory = "",   q_apgar_score = "",       q_apgar_score_in_5_mins = "",  q_apgar_score_in_10_mins = "",  functname_sev = "",  dflt_nb_regn_blng_class = "",  fath_disable = "",  father_id_exists = "",  BDVallnew = "",  dofbirthvalue = "",  birth_date     = "",  birth_time     = "",  dofbirthdis = "",  antenatal_care_yn = "",  ant_care_locn_code = "",  ant_care_locn_type = "",  ant_care_gvn_at = "",  pat_blood_grp = "",  pat_rh_factor = "",  dis_all_flds = "",  call_function_id = "",  accept_names_for_live_birth_yn="",  heart_rate_in_1_min_1 ="",  heart_rate_in_1_min_2 ="",  heart_rate_in_1_min_3 ="",  heart_rate_in_1_min_4 ="",  heart_rate_in_5_min_1 ="",  heart_rate_in_5_min_2 ="",  heart_rate_in_5_min_3 ="",  heart_rate_in_5_min_4 ="",  heart_rate_in_10_min_1 ="",  heart_rate_in_10_min_2 ="",  heart_rate_in_10_min_3 ="",  heart_rate_in_10_min_4 ="",  breathing_in_1_min_1 ="",  breathing_in_1_min_2 ="",  breathing_in_1_min_3 ="",  breathing_in_1_min_4 ="",  breathing_in_5_min_1 ="",  breathing_in_5_min_2 ="",  breathing_in_5_min_3 ="",  breathing_in_5_min_4 ="",  breathing_in_10_min_1 ="",  breathing_in_10_min_2 ="",  breathing_in_10_min_3 ="",  breathing_in_10_min_4 ="",  grimace_in_1_min_1 ="",  grimace_in_1_min_2 ="",  grimace_in_1_min_3 ="",  grimace_in_1_min_4 ="",  grimace_in_5_min_1 ="",  grimace_in_5_min_2 ="",  grimace_in_5_min_3 ="",  grimace_in_5_min_4 ="",  grimace_in_10_min_1 ="",  grimace_in_10_min_2 ="",  grimace_in_10_min_3 ="",  grimace_in_10_min_4 ="",  activity_in_1_min_1 ="",  activity_in_1_min_2 ="",  activity_in_1_min_3 ="",  activity_in_1_min_4 ="",  activity_in_5_min_1 ="",  activity_in_5_min_2 ="",  activity_in_5_min_3 ="",  activity_in_5_min_4 ="",  activity_in_10_min_1 ="",  activity_in_10_min_2 ="",  activity_in_10_min_3 ="",  activity_in_10_min_4 ="",  appearance_in_1_min_1 ="",  appearance_in_1_min_2 ="",  appearance_in_1_min_3 ="",  appearance_in_1_min_4 ="",  appearance_in_5_min_1 ="",  appearance_in_5_min_2 ="",  appearance_in_5_min_3 ="",  appearance_in_5_min_4 ="",  appearance_in_10_min_1 ="",  appearance_in_10_min_2 ="",  appearance_in_10_min_3 ="",  appearance_in_10_min_4 ="",  lmp_ca ="",  no_of_days ="",  no_of_weeks="", q_parity1="";
	int nod=0;
	int mc_cycle_no=0;	
	String data_upd_allowed_aft_final_yn="", q_finalized_yn="", name_prefix_male_nb = "", name_prefix_female_nb = "", name_prefix_unknown_nb = "", name_suffix_male_nb = "", name_suffix_female_nb = "", name_pfx_loc_lang_male_nb = "", name_pfx_loc_lang_female_nb = "", name_pfx_loc_lang_unknown_nb = "", name_sfx_loc_lang_male_nb = "", name_sfx_loc_lang_female_nb = "", nb_mother_dtls_update_yn="N", dis_all_mother_dtls = "", ot_yn = "N", rd_yn = "N", family_org_sub_id = "", family_org_id = "", family_org_membership = "", family_link_no = "", mthr_alt_id1_no =  "", mthr_alt_id2_no =  "", mthr_alt_id3_no =  "", mthr_alt_id4_no =  "", mthr_nat_id_no  = "", mthr_oth_alt_id_No = " ", still_born_prefix=""; // Modified by Afruddin for ML-MMOH-CRF-1520 US0002
	int patient_idlength	= 0;
	int diffHours			= 0;
	int q_no_of_birth		= 0;
	int flag				= 0;
	int new_registration	= 0;
	String field_name = "",emer_regn_nb = "N",ip_regn_nb_yn = "N",mp_regn_nb_yn = "N",ant_care_given_at = "",length_of_baby_yn = "",lengthofbaby = "visibility:hidden",head_circumference_of_baby_yn = "",headcircumference = "visibility:hidden" ,lengthValue = "" ,headValue="",mandate_first_newborn_yn = "",mandate_second_newborn_yn = "",mandate_third_newborn_yn = "",mand_antenatal_newborn_yn = "",mandate_first_newborn_ae_yn = "",mandate_second_newborn_ae_yn = "",mandate_third_newborn_ae_yn = "",mand_antenatal_newborn_ae_yn = "",mandate_first_newborn_ip_yn = "",mandate_second_newborn_ip_yn = "",mandate_third_newborn_ip_yn = "", mand_antenatal_newborn_ip_yn = "",mandatefirstnewbornValue = "visibility:hidden",mandate_secondnewbornValue = "visibility:hidden", mandate_third_newbornValue = "visibility:hidden",mand_antenatal_newbornValue = "visibility:hidden",antvalue = "" , maintainbirthvalue = "" ,dflt_father_first_name_prompt = "", dflt_father_Second_name_prompt = "" , dflt_father_third_name_prompt = "" , dflt_father_family_name_prompt = "",no_marital_status="",enable_marital_status="",hij_appl_YN="N";
	double min_gest_bet_del = 0;
    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
    java.util.Date dt=new java.util.Date();
	String d = dateFormat.format( dt ) ;
	String sec = String.valueOf(dt.getMinutes());
	if ((sec).length()==1) sec="0"+sec; else sec = sec;
	d=d + " "+String.valueOf(dt.getHours())+":"+sec;
	String tm =String.valueOf(dt.getHours())+":"+String.valueOf(dt.getMinutes());
    String 	page_show =  request.getParameter("page_show") == null ? "M" : request.getParameter("page_show");
    String enable_gestn_field = "", displayLabel="", invoke_menstrual_history ="", rec_view_lmp_details_label = "", rec_lmp_dtl_mand="none",invoke_mens_hist_mand = "N",gestn_day_from_lmp="", gestn_week_from_lmp="";// Added by Jeyachitra ML-MMOH-CRF-1759.1
    boolean ca_mens_trans_dtl_avail=false; // Added by Jeyachitra ML-MMOH-CRF-1759.1
    PreparedStatement pstmt = null; // Added by Jeyachitra ML-MMOH-CRF-1759.1
   
	try	{
		con = ConnectionManager.getConnection(request);	
		birth_order_format=CommonBean.isSiteSpecific(con, "MP","MP_NEWBORN_ORDER");//Mahesh   HSA-CRF-0304 [IN:054703]
	   Boolean isMPMandatoryFieldsNewborn = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_MANDATORY_FIELDS_NEWBORN");
	   Boolean mpDisableFieldsNBFather = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","MP_DISABLE_FIELDS_NB_FATHER");
	   if(called_function.equals("IP") || function_id.equals("MAINTAIN_BIRTH") || !isMPMandatoryFieldsNewborn) {
		captureAntenatalDtlsYN = "Y";
	}
       Boolean hijirisitespecifApplicable = CommonBean.isSiteSpecific(con, "MP","CAL_HIJ_APP");
	   Boolean isAllow_External_Newborn = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","ALLOW_EXTERNAL_NEWBORN");
	   Boolean isLabelChangeApplicable = CommonBean.isSiteSpecific(con, "IP","GRAVIDA_PARITY_LEGEND_CHG");//Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565
	   Boolean isNeonatalApplicable = CommonBean.isSiteSpecific(con, "MP","NEONATAL_RESUSCITATION");//Added by Ashwini on 24-oct-2016 for MO-CRF-20108
	   Boolean isNewBornChngsAppl = CommonBean.isSiteSpecific(con, "IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");//Added by Dharma on 30th May 2018 against ML-MMOH-CRF-0898 [IN:064757]
	   Boolean isMotherAliveAppl = CommonBean.isSiteSpecific(con, "MP","MOTHER_ALIVE_APPL");//Added by Mujafar against ML-MMOH-CRF-1476  
	   Boolean newborn_birth_order=CommonBean.isSiteSpecific(con, "MP","MP_NEWBORN_BIRTH_ORDER");
	   Boolean isRegNewbornApplicable = CommonBean.isSiteSpecific(con, "MP","REG_NEWBORN_FOR_IP");
	   Boolean newbornBornAt = CommonBean.isSiteSpecific(con, "MP","NEWBORN_BORN_AT");
	   isModifyLongShortDescAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MP","MODIFY_LONG_SHORT_DESC");//Added by Ashwini on 24-Jan-2019 for ML-MMOH-CRF-1109
	   Boolean isNameDervnLogicNBAppl = CommonBean.isSiteSpecific(con,"MP","NEWBORN_NAME_DERV_LOGIC");//Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551
	    
	 //68508 added by Twinkle 
		    String invokeMenstrualHistYN=""; 
			String mandParityNewBornYN="";
			String mandParityNewBornAE_YN="";
			String mandParityNewBornIP_YN="";
		    pstmt1 = con.prepareStatement("SELECT INVOKE_MENSTRUAL_HISTORY_YN, MAND_PARITY_NEWBORN_YN, MAND_PARITY_NEWBORN_AE_YN,MAND_PARITY_NEWBORN_IP_YN FROM MP_PARAM");
		    rs1 = pstmt1.executeQuery();
		    if (rs1.next()){
		    	invokeMenstrualHistYN = rs1.getString("INVOKE_MENSTRUAL_HISTORY_YN");
		    	mandParityNewBornYN = rs1.getString("MAND_PARITY_NEWBORN_YN");
		    	mandParityNewBornAE_YN = rs1.getString("MAND_PARITY_NEWBORN_AE_YN");
		    	mandParityNewBornIP_YN = rs1.getString("MAND_PARITY_NEWBORN_IP_YN");	
		    }
		    if(pstmt1!=null) pstmt1.close();
		    if(rs1!=null) rs1.close();	
	  //68508 added by Twinkle 	   
			      
       int inc = 3, incArr = 2;
	   String sel_yn = "";
	   
	   JSONObject OTRDInstalledYNJson = new JSONObject();
	   OTRDInstalledYNJson		=	eMP.MPCommonBean.getOTRDInstalledYN(con);
	   ot_yn					=	(String)OTRDInstalledYNJson.get("ot_yn");
	   rd_yn					=	(String)OTRDInstalledYNJson.get("rd_yn");
	String maxsize="30", maximumLength="30"; 	
	Boolean increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");
		
	//Santhosh added for ML-MMOH-CRF-1895
     Boolean isApgarScoreMinsAppl = CommonBean.isSiteSpecific(con, "MP","APGAR_SCORE_IN_MINS_MANDATORY");
	
	
	if(increasedaddressLength){	  
	  maximumLength="50";	
	  maxsize="64";
	}
	   String headcircum_lengofBaby="visibility:hidden"; 
	   if(isRegNewbornApplicable){  
	      headcircum_lengofBaby="visibility:visible"; 
	   }
	if(isRegNewbornApplicable && !resuscitated_pract_id.equals("")){
    StringBuffer natstrBuffer=new StringBuffer("select practitioner_name from am_practitioner where practitioner_id ='");	
	natstrBuffer.append(resuscitated_pract_id).append("'");
	newbornstmt1 = con.prepareStatement(natstrBuffer.toString());
	newbornrs1 = newbornstmt1.executeQuery();
	if(newbornrs1!=null && newbornrs1.next()){
	resuscitated_pract_desc=newbornrs1.getString("practitioner_name")==null?"":newbornrs1.getString("practitioner_name");		 
	}
	if(newbornrs1 != null) newbornrs1.close();
	if(newbornstmt1 != null) newbornstmt1.close();
	}
       if(hijirisitespecifApplicable)  hij_appl_YN="Y";
		mPParamDtls = eMP.NewbornDetails.getMPParamDtls(con,p);
		newborn_pat_ser_grp		= checkForNull((String) mPParamDtls.get("newborn_pat_ser_grp"));
		String allow_ext_nb_regn_within_days		= checkForNull((String) mPParamDtls.get("allow_ext_nb_regn_within_days"));
		nb_dflt_relnship_code		= checkForNull((String) mPParamDtls.get("nb_dflt_relnship_code"));
		String dflt_race_nat_setup = checkForNull((String) mPParamDtls.get("dflt_race_nat_setup_nb_as_per"));	
		String citizen_nationality_code	= checkForNull((String) mPParamDtls.get("citizen_nationality_code"));	
		String default_race_code = checkForNull((String) mPParamDtls.get("default_race_code"));	
		String nb_father_min_age		= checkForNull((String) mPParamDtls.get("nb_father_min_age"));
		String generate_file		= checkForNull((String) mPParamDtls.get("create_file_at_pat_regn_yn"),"N");
		String Name_Prefix_Accept_Yn		= checkForNull((String) mPParamDtls.get("name_prefix_accept_yn"));
		String Name_Prefix_Reqd_Yn		= checkForNull((String) mPParamDtls.get("name_prefix_reqd_yn"));
		String Name_Suffix_Accept_Yn		= checkForNull((String) mPParamDtls.get("name_suffix_accept_yn"));
		String Name_Suffix_Reqd_Yn		= checkForNull((String) mPParamDtls.get("name_suffix_reqd_yn"));
		String First_Name_Accept_Yn		= checkForNull((String) mPParamDtls.get("first_name_accept_yn"));
		String First_Name_Prompt		= checkForNull((String) mPParamDtls.get("first_name_prompt"));
		String First_Name_Reqd_Yn		= checkForNull((String) mPParamDtls.get("first_name_reqd_yn"));
		String Second_Name_Accept_Yn		= checkForNull((String) mPParamDtls.get("second_name_accept_yn"));
		String Second_Name_Prompt		= checkForNull((String) mPParamDtls.get("second_name_prompt"));
		String Third_Name_Accept_Yn		= checkForNull((String) mPParamDtls.get("third_name_accept_yn"));
		String Third_Name_Prompt		= checkForNull((String) mPParamDtls.get("third_name_prompt"));
		String Family_Name_Accept_Yn		= checkForNull((String) mPParamDtls.get("family_name_accept_yn"));
		String Family_Name_Prompt		= checkForNull((String) mPParamDtls.get("family_name_prompt"));
		String Second_Name_Reqd_Yn		= checkForNull((String) mPParamDtls.get("second_name_reqd_yn"));
		String Third_Name_Reqd_Yn		= checkForNull((String) mPParamDtls.get("third_name_reqd_yn"));
		String Family_Name_Reqd_Yn		= checkForNull((String) mPParamDtls.get("family_name_reqd_yn"));
		String Name_Suffix_Prompt		= checkForNull((String) mPParamDtls.get("name_suffix_prompt"));
		String Name_Prefix_Prompt		= checkForNull((String) mPParamDtls.get("name_prefix_prompt"));
		String Family_Name_Order		= checkForNull((String) mPParamDtls.get("family_name_order"));
		String First_Name_Order			= checkForNull((String) mPParamDtls.get("first_name_order"));
		String Second_Name_Order		= checkForNull((String) mPParamDtls.get("second_name_order"));
		String Third_Name_Order			= checkForNull((String) mPParamDtls.get("third_name_order"));
		String first_name_length		= checkForNull((String) mPParamDtls.get("first_name_length"),"0");
		String second_name_length		= checkForNull((String) mPParamDtls.get("second_name_length"),"0");
		String third_name_length		= checkForNull((String) mPParamDtls.get("third_name_length"),"0");
		String family_name_length		= checkForNull((String) mPParamDtls.get("family_name_length"),"0");
		String family_name_loc_lang_prompt = checkForNull((String)mPParamDtls.get("family_name_loc_lang_prompt"));
		String name_suffix_loc_lang_prompt = checkForNull((String)mPParamDtls.get("name_suffix_loc_lang_prompt"));
		String first_name_loc_lang_prompt =checkForNull((String)mPParamDtls.get("first_name_loc_lang_prompt"));
		String second_name_loc_lang_prompt =checkForNull((String)mPParamDtls.get("second_name_loc_lang_prompt"));
		String third_name_loc_lang_prompt =checkForNull((String)mPParamDtls.get("third_name_loc_lang_prompt"));
		String name_prefix_loc_lang_prompt =checkForNull((String)mPParamDtls.get("name_prefix_loc_lang_prompt"));
		String names_in_oth_lang_yn = checkForNull((String)mPParamDtls.get("names_in_oth_lang_yn"),"N"); 
		cd1    = checkForNull((String) mPParamDtls.get("allow_nb_regn_unit"),"H");
		cd2    = checkForNull((String) mPParamDtls.get("allow_nb_regn_within_days"),"0");
		cd3	   = checkForNull((String) mPParamDtls.get("nat_id_prompt"), "National ID No"); //Modified for this CRF ML-MMOH-CRF-0621 
		cd4	   = checkForNull((String) mPParamDtls.get("nat_id_length"),"20");	
		nb_father_name_mandatory_yn	   = checkForNull(((String) mPParamDtls.get("nb_father_name_mandatory_yn")),"N");			
		unitofwtnb = checkForNull(((String) mPParamDtls.get("unit_of_wt_nb")),"");
        unitofcircumnb = checkForNull(((String) mPParamDtls.get("unit_of_circum_nb")),"");
		unitofchestunit = checkForNull(((String) mPParamDtls.get("unit_of_chest_circum_nb")),"");
		unitoflengthnb = checkForNull(((String) mPParamDtls.get("unit_of_length_nb")),"");
		unitofgestnb	= checkForNull(((String) mPParamDtls.get("unit_of_gest_nb")),"");  
		namesuffixmalenb	= checkForNull(((String) mPParamDtls.get("name_suffix_male_nb")),"");
		namesuffixfemalenb = checkForNull(((String) mPParamDtls.get("name_suffix_female_nb")),"");    
		nb_use_mother_ser = checkForNull(((String) mPParamDtls.get("nb_use_mother_ser")),"");
		accept_names_for_live_birth_yn = checkForNull(((String) mPParamDtls.get("accept_names_for_live_birth_yn")),"N");
		still_born_prefix = checkForNull(((String) mPParamDtls.get("still_born_prefix")),"");
		accept_oth_alt_id_yn		= checkForNull((String)mPParamDtls.get("accept_oth_alt_id_yn"),"N");
		accept_national_id_no_yn		= checkForNull((String)mPParamDtls.get("accept_national_id_no_yn"),"N");
		patient_idlength			= Integer.parseInt(checkForNull( (String)mPParamDtls.get("patient_id_length"),"0"));
		alt_id1_type				= checkForNull((String)mPParamDtls.get("alt_id1_type"));
		alt_id1_length				= checkForNull((String)mPParamDtls.get("alt_id1_length"));
		alt_id2_length				= checkForNull((String)mPParamDtls.get("alt_id2_length"));
		alt_id3_length				= checkForNull((String)mPParamDtls.get("alt_id3_length"));
		alt_id4_length				= checkForNull((String)mPParamDtls.get("alt_id4_length"));
		alt_id1_type_desc			= checkForNull((String)mPParamDtls.get("alt_id1_type_desc"));
		alt_id2_type_desc			= checkForNull((String)mPParamDtls.get("alt_id2_type_desc"));
		alt_id3_type_desc			= checkForNull((String)mPParamDtls.get("alt_id3_type_desc"));
		alt_id4_type_desc			= checkForNull((String)mPParamDtls.get("alt_id4_type_desc"));
		alt_id1_len_validation_yn	= checkForNull((String)mPParamDtls.get("alt_id1_len_validation_yn"));
		alt_id1_routine_yn			= checkForNull((String)mPParamDtls.get("alt_id1_routine_yn"));
		alt_id1_data_source_id		= checkForNull((String)mPParamDtls.get("alt_id1_data_source_id"));
		alt_id1_chk_digit_scheme	= checkForNull((String)mPParamDtls.get("alt_id1_chk_digit_scheme"));
		alt_id1_accept_alphanumeric_yn	= 
		checkForNull((String)mPParamDtls.get("alt_id1_accept_alphanumeric_yn"));
	   motherid	= eMP.NewbornDetails.getMutipleBirthPatientId(motherid, con, p,mother_pat_id,finalized_mult_birth_yn); //Below line added for this CRF HSA-CRF-0182 linked incident [54168]
 	   hashMap	= eMP.NewbornDetails.getNewbornData(motherid, con, p);//this line added for this incident [54168]

		cong_anom_desc = checkForNull((String )hashMap.get("cong_anomalies_long_desc"));
		dely_ind_desc = checkForNull((String )hashMap.get("dely_ind_long_desc"));
		q_compln_pregnancy_desc = checkForNull((String)hashMap.get("compln_pregnancy_long_desc"));
		q_compln_nr_pregnancy_desc = checkForNull((String)hashMap.get("compln_nr_pregnancy_long_desc"));
		q_compln_dely_desc = checkForNull((String)hashMap.get("compln_dely_long_desc"));
		q_proc_class_desc = checkForNull((String)hashMap.get("proc_class_long_desc"));
		q_vaginal_dely_type_desc = checkForNull((String) hashMap.get("vaginal_del_type_long_desc"));
		q_dely_surg_class_desc = checkForNull((String) hashMap.get("dely_surg_class_long_desc"));
		q_nb_compln_dely_desc = checkForNull((String )hashMap.get("nb_compln_del_long_desc"));

	   emer_regn_nb_yn = checkForNull((String)hashMap.get("emer_regn_nb_yn"));
		if(mother_patient_id.equals("")){
			mother_patient_id=checkForNull((String)hashMap.get("q_mother_patient_id"));
		}
		mthrDtls = eMP.NewbornDetails.getMotherData(con, p, mother_patient_id); 
		if(hashMap.isEmpty()) {
			 relation_mcode = checkForNull((String)mthrDtls.get("relation_code"));
			 relation_mdesc = checkForNull((String)mthrDtls.get("relation_desc"));	
			 family_org_sub_id = checkForNull((String)mthrDtls.get("mthr_family_org_sub_id"));			
			 family_org_id = checkForNull((String)mthrDtls.get("mthr_family_org_id"));			
			 family_org_membership = checkForNull((String)mthrDtls.get("mthr_family_org_membership"));			
			 family_link_no = checkForNull((String)mthrDtls.get("mthr_family_link_no"));			
		} else {
			 relation_mcode = checkForNull((String)hashMap.get("relation_code"));
			 relation_mdesc = checkForNull((String)hashMap.get("relation_desc"));
			 family_org_sub_id = checkForNull((String)hashMap.get("family_org_sub_id"));			
			 family_org_id = checkForNull((String)hashMap.get("family_org_id"));			
			 family_org_membership = checkForNull((String)hashMap.get("family_org_membership"));			
			 family_link_no = checkForNull((String)hashMap.get("family_link_no"));			
			} 		
		//Added by Jeyachitra for ML-MMOH-CRF-1759.1
		String patient_gender = checkForNull((String)mthrDtls.get("patient_gender"));
		String patient_age =checkForNull((String)mthrDtls.get("patient_age"));
		mthr_alt_id1_no = checkForNull((String)mthrDtls.get("mthr_alt_id1_no"));
		mthr_alt_id2_no = checkForNull((String)mthrDtls.get("mthr_alt_id2_no"));
		mthr_alt_id3_no = checkForNull((String)mthrDtls.get("mthr_alt_id3_no"));
		mthr_alt_id4_no = checkForNull((String)mthrDtls.get("mthr_alt_id4_no"));
		mthr_nat_id_no  =checkForNull((String)mthrDtls.get("mthr_nat_id_no"));
		mthr_oth_alt_id_No  =checkForNull((String)mthrDtls.get("mthr_oth_alt_id_No"));
		oth_alt_id_type	=checkForNull((String)mthrDtls.get("oth_alt_id_type"));
		mthr_oth_alt_id_type	=checkForNull((String)mthrDtls.get("mthr_oth_alt_id_type"));
		String dft_vlaues_from_mc=(String)session.getValue("dft_vlaues_from_mc");		
		Integer ca_cycle=(Integer)session.getValue("mc_cycle_number");
		if(ca_cycle!=null){
			mc_cycle_no=ca_cycle.intValue();
		}else if(hashMap.get("q_mc_cycle_no")!=null){
			mc_cycle_no=Integer.parseInt((String)hashMap.get("q_mc_cycle_no"));
		}
		if((dft_vlaues_from_mc!=null && dft_vlaues_from_mc.equals("Y")) || (called_from_mothercare.equals("MC"))){
			String motherdataSQl="select DELIVERY_TYPE, ATTEND_PRACT_ID, ATTEND_NURSE_ID, PROC_CLASSIFICATION,DEL_SURG_CLASSIFICATION, VAGINAL_DELIVERY_TYPE, NO_OF_BIRTH,COMP_IN_DEL_STAGE1, COMP_IN_DEL_STAGE2, COMP_IN_DEL_STAGE3,COMP_OF_DELIVERY, FOETUS_COMP_OF_DELIVERY,mp_get_desc.MP_VAGINAL_DELY_TYPE(VAGINAL_DELIVERY_TYPE,'"+localeName+"',2)VAGINAL_DELIVERY_TYPE_DESC,mp_get_desc.MP_PROC_CLASSIFICATION(PROC_CLASSIFICATION,'"+localeName+"',2) PROC_CLASSIFICATION_DESC,	   mp_get_desc.MP_COMPLN_DELIVERY(comp_of_delivery,'"+localeName+"',2) COMP_OF_DELIVERY_DESC,mp_get_desc.MP_DELY_SURG_CLFN(DEL_SURG_CLASSIFICATION,'"+localeName+"',2) DEL_SURG_CLASSIFICATION_DESC,am_get_desc.AM_PRACTITIONER(ATTEND_PRACT_ID,'"+localeName+"',1)ATTEND_PRACT_ID_DESC,am_get_desc.AM_PRACTITIONER(ATTEND_NURSE_ID,'"+localeName+"',1)ATTEND_NURSE_ID_DESC,mp_get_desc.MP_COMPLN_DELIVERY(FOETUS_COMP_OF_DELIVERY,'"+localeName+"',2) FOETUS_COMP_OF_DELIVERY_DESC,cycle_no,to_char(LMP,'dd/mm/yyyy') LMP,(trunc(sysdate)-trunc(lmp)) no_of_days, mp_get_desc.MP_COMPLN_DELIVERY(comp_of_delivery,'"+localeName+"',1) COMP_OF_DELIVERY_LONG_DESC, mp_get_desc.MP_COMPLN_DELIVERY(FOETUS_COMP_OF_DELIVERY,'"+localeName+"',1) FOETUS_COMP_OF_DEL_LONG_DESC, mp_get_desc.MP_PROC_CLASSIFICATION(PROC_CLASSIFICATION,'"+localeName+"',1) PROC_CLASS_LONG_DESC, mp_get_desc.MP_VAGINAL_DELY_TYPE(VAGINAL_DELIVERY_TYPE,'"+localeName+"',1) VAGINAL_DELTYPE_LONG_DESC, mp_get_desc.MP_DELY_SURG_CLFN(DEL_SURG_CLASSIFICATION,'"+localeName+"',1) DEL_SURG_CLASS_LONG_DESC from CA_SPL_DELIVERY_RECORD where facility_id='"+facilityId+"' and mother_patient_id='"+mother_patient_id+"' and CYCLE_NO=(select max(CYCLE_NO) from CA_PAT_SPLTY_EPISODE_EVENT where patient_id='"+mother_patient_id+"' and SPLTY_EVENT_CODE IN ('MCE004','MCE008','MCE009' ) AND SPLTY_EVENT_STATUS='O')";			
				session.removeValue("mc_cycle_number");
				stmt = con.createStatement();		
				rs=stmt.executeQuery(motherdataSQl);
				if(rs!=null && rs.next()){
					ca_no_of_births=rs.getString("NO_OF_BIRTH")==null?"":rs.getString("NO_OF_BIRTH");
					ca_delivery_type=rs.getString("DELIVERY_TYPE")==null?"":rs.getString("DELIVERY_TYPE");
					ca_attend_pract_id=rs.getString("ATTEND_PRACT_ID")==null?"":rs.getString("ATTEND_PRACT_ID");
					ca_attend_pract_id_desc=rs.getString("ATTEND_PRACT_ID_DESC")==null?"":rs.getString("ATTEND_PRACT_ID_DESC");
					ca_attend_nurse_id=rs.getString("ATTEND_NURSE_ID")==null?"":rs.getString("ATTEND_NURSE_ID");
					ca_attend_nurse_id_desc=rs.getString("ATTEND_NURSE_ID_DESC")==null?"":rs.getString("ATTEND_NURSE_ID_DESC");
					ca_proc_classification=rs.getString("PROC_CLASSIFICATION")==null?"":rs.getString("PROC_CLASSIFICATION");
					ca_del_surg_classification=rs.getString("DEL_SURG_CLASSIFICATION")==null?"":rs.getString("DEL_SURG_CLASSIFICATION");
					ca_vaginal_delivery_type=rs.getString("VAGINAL_DELIVERY_TYPE")==null?"":rs.getString("VAGINAL_DELIVERY_TYPE");
					ca_comp_in_del_stage1=rs.getString("COMP_IN_DEL_STAGE1")==null?"":rs.getString("COMP_IN_DEL_STAGE1");
					ca_comp_in_del_stage2=rs.getString("COMP_IN_DEL_STAGE2")==null?"":rs.getString("COMP_IN_DEL_STAGE2");
					ca_comp_in_del_stage3=rs.getString("COMP_IN_DEL_STAGE3")==null?"":rs.getString("COMP_IN_DEL_STAGE3");
					ca_comp_of_delivery=rs.getString("COMP_OF_DELIVERY")==null?"":rs.getString("COMP_OF_DELIVERY");
					ca_foetus_comp_of_delivery=rs.getString("FOETUS_COMP_OF_DELIVERY")==null?"":rs.getString("FOETUS_COMP_OF_DELIVERY");
					ca_proc_classification_desc=rs.getString("PROC_CLASS_LONG_DESC")==null?"":rs.getString("PROC_CLASS_LONG_DESC");
					ca_del_surg_classification_desc=rs.getString("DEL_SURG_CLASS_LONG_DESC")==null?"":rs.getString("DEL_SURG_CLASS_LONG_DESC");
					ca_vaginal_delivery_type_desc=rs.getString("VAGINAL_DELTYPE_LONG_DESC")==null?"":rs.getString("VAGINAL_DELTYPE_LONG_DESC");
					ca_comp_of_delivery_desc=rs.getString("COMP_OF_DELIVERY_LONG_DESC")==null?"":rs.getString("COMP_OF_DELIVERY_LONG_DESC");
					ca_foetus_comp_of_delivery_desc=rs.getString("FOETUS_COMP_OF_DEL_LONG_DESC")==null?"":rs.getString("FOETUS_COMP_OF_DEL_LONG_DESC");
					
					
					mc_cycle_no=rs.getInt("cycle_no");
					lmp_ca=rs.getString("LMP")==null?"":rs.getString("LMP");
					no_of_days=rs.getString("no_of_days")==null?"0":rs.getString("no_of_days");
					if(unitofgestnb.equals("W")){
						StringTokenizer str=new StringTokenizer(no_of_days,".");
						nod=Integer.parseInt(str.nextToken());
						if(nod > 6){
							no_of_weeks=(new Integer(nod/7)).toString();							 					
							nod=nod%7;							
						}else{							
							no_of_weeks = "0"; //Added the code for SRR20056-SCF-6095 [IN:025248] by Suresh M on 26.11.2010						
						}
					}
					MC_Dtls_YN="Y";
				}}
		String q_delivery_indicator= checkForNull((String) hashMap.get("q_delivery_indicator"));					
		String dis_com_stages ="", dis_com_delivery ="";
    	if(function_id.equals("MAINTAIN_BIRTH") && called_function.equals("MP"))  {
			if(q_delivery_indicator.equals("C")) {
				dis_com_stages ="disabled";
			} else if(q_delivery_indicator.equals("N")) {
				dis_com_delivery ="disabled";
			} else {
				dis_com_stages ="";
				dis_com_delivery ="";
			}
		}
		if(invoked_from.equals("details_page")){
			if(regnStatus.equals("R") && finalizeYN.equals("Y")) {
				dis_all_flds = "";				
			} else if(regnStatus.equals("F")) {
				dis_all_flds = "disabled";				
			}
			function_id = "MAINTAIN_BIRTH";
			new_function_id = "MAINTAIN_BIRTH";
		} else if (invoked_from.equals("servlet")) {
			if(function_id.equals("REGISTER_NEWBORN")) {
				dis_all_flds = "disabled";
			} else if(function_id.equals("MAINTAIN_BIRTH")) {
				dis_all_flds = "";
			} 
			function_id = "MAINTAIN_BIRTH";
		} else {
			function_id = new_function_id;	
		}
		call_function_id = function_id;
		if(!function_id.equals("REGISTER_NEWBORN") && !invoked_from.equals("servlet") && motherencounterid.equals("")) {
			 motherencounterid = checkForNull((String)hashMap.get("q_mother_encounter_id"));
		} 
		if(new_function_id.equals("REGISTER_NEWBORN"))		
			functname_sev="insert";		
		else
			functname_sev="Query";		
		if( !function_id.equals("REGISTER_NEWBORN")){
			hashMap10 = eMP.NewbornDetails.getIPOpenEncounter(facilityId,motherencounterid,con,p); 
			mother_nursing_unit=checkForNull((String)hashMap10.get("mother_nursing_unit_code")) ;
			mother_bed_no=checkForNull((String)hashMap10.get("mother_bed_no"));
			pseudo_bed_yn=checkForNull((String)hashMap10.get("pseudo_bed_yn"),"N");
			pat_blood_grp = checkForNull((String)hashMap.get("blood_grp"));
			pat_rh_factor = checkForNull((String)hashMap.get("rh_factor"));
		}
		stmt = con.createStatement();
		rs = stmt.executeQuery("select single_stage_nb_reg_appl_yn,mod_birth_reg_appl_yn,INVOKE_MENSTRUAL_HISTORY_YN from mp_param");//// Added by Jeyachitra ML-MMOH-CRF-1759.1
		
		if(rs!=null && rs.next()){
			single_stage_appl_yn=rs.getString("single_stage_nb_reg_appl_yn")==null?"N":rs.getString("single_stage_nb_reg_appl_yn");
			modify_delivery_type=rs.getString("mod_birth_reg_appl_yn")==null?"N":rs.getString("mod_birth_reg_appl_yn");
			invoke_menstrual_history = rs.getString("INVOKE_MENSTRUAL_HISTORY_YN") == null?"N":rs.getString("INVOKE_MENSTRUAL_HISTORY_YN");//// Added by Jeyachitra ML-MMOH-CRF-1759.1
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		//Added by Kamatchi S for ML-MMOH-CRF-2095
	   lengthValue = checkForNull((String) hashMap.get("q_length"));
	   headValue = checkForNull((String) hashMap.get("q_circumference"));
	   JSONObject getLengthHeadValueYN = new JSONObject();
	   getLengthHeadValueYN		=	eMP.MPCommonBean.getLengthHeadValueYN(con);
	   length_of_baby_yn					=	checkForNull((String)getLengthHeadValueYN.get("length_of_baby_yn"));
	   head_circumference_of_baby_yn = checkForNull((String)getLengthHeadValueYN.get("head_circumference_of_baby_yn"));
	   dflt_father_first_name_prompt = checkForNull((String)getLengthHeadValueYN.get("dflt_father_first_name_prompt"));
	   dflt_father_Second_name_prompt =	checkForNull((String)getLengthHeadValueYN.get("dflt_father_Second_name_prompt"));
	   dflt_father_third_name_prompt = checkForNull((String)getLengthHeadValueYN.get("dflt_father_third_name_prompt"));
	   dflt_father_family_name_prompt =	checkForNull((String)getLengthHeadValueYN.get("dflt_father_family_name_prompt"));
	   enable_marital_status =	checkForNull((String)getLengthHeadValueYN.get("enable_marital_status"));
	   if(length_of_baby_yn.equals("Y") || length_of_baby_yn == "Y"){  lengthofbaby="visibility:visible"; }
	   if(head_circumference_of_baby_yn.equals("Y") || head_circumference_of_baby_yn == "Y"){  headcircumference="visibility:visible"; }
	   JSONObject getComplicationValue = new JSONObject();
	   getComplicationValue		=	eMP.MPCommonBean.getComplicationValue(con,motherid);
	   emer_regn_nb					=	checkForNull((String)getComplicationValue.get("emer_regn_nb_yn"));
	   ip_regn_nb_yn					= checkForNull((String)getComplicationValue.get("ip_regn_nb_yn"));
	   mp_regn_nb_yn					=	checkForNull((String)getComplicationValue.get("mp_regn_nb_yn"));
	   ant_care_given_at					=	checkForNull((String)getComplicationValue.get("ant_care_gvn_at"));
	   no_marital_status					=	checkForNull((String)getComplicationValue.get("no_marital_status"));
	   if(function_id.equals("REGISTER_NEWBORN") ) { antvalue = ""; }
	   if(function_id.equals("MAINTAIN_BIRTH")) { antvalue = ant_care_given_at; } 
	   //Added by Kamatchi S for ML-MMMOH-CRF-1757
	   mandate_first_newborn_yn					=	(String)getLengthHeadValueYN.get("mandate_first_newborn_yn");
	   mandate_first_newborn_ae_yn					=	(String)getLengthHeadValueYN.get("mandate_first_newborn_ae_yn");
	   mandate_second_newborn_yn					=	(String)getLengthHeadValueYN.get("mandate_second_newborn_yn");
	   mandate_second_newborn_ae_yn					=	(String)getLengthHeadValueYN.get("mandate_second_newborn_ae_yn");
	   mandate_third_newborn_yn					=	(String)getLengthHeadValueYN.get("mandate_third_newborn_yn");
	   mandate_third_newborn_ae_yn					=	(String)getLengthHeadValueYN.get("mandate_third_newborn_ae_yn");
	   mand_antenatal_newborn_yn					=	(String)getLengthHeadValueYN.get("mand_antenatal_newborn_yn");
	   mand_antenatal_newborn_ae_yn					=	(String)getLengthHeadValueYN.get("mand_antenatal_newborn_ae_yn");
	   mandate_first_newborn_ip_yn					=	(String)getLengthHeadValueYN.get("mandate_first_newborn_ip_yn");
	   mandate_second_newborn_ip_yn					=	(String)getLengthHeadValueYN.get("mandate_second_newborn_ip_yn");
	   mandate_third_newborn_ip_yn					=	(String)getLengthHeadValueYN.get("mandate_third_newborn_ip_yn");
	   mand_antenatal_newborn_ip_yn					=	(String)getLengthHeadValueYN.get("mand_antenatal_newborn_ip_yn");
	   if(((function_id.equals("REGISTER_NEWBORN") || function_id == "REGISTER_NEWBORN") && (calling_module_id.equals("") || calling_module_id.equals("MP")) && (mandate_first_newborn_yn.equals("Y") || mandate_first_newborn_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_first_newborn_yn.equals("Y") && mp_regn_nb_yn.equals("Y") ) ){  mandatefirstnewbornValue="visibility:visible"; }
	   if(((function_id.equals("REGISTER_NEWBORN") || function_id == "REGISTER_NEWBORN") && (calling_module_id.equals("") || calling_module_id.equals("MP")) && (mandate_second_newborn_yn.equals("Y") || mandate_second_newborn_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_second_newborn_yn.equals("Y") && mp_regn_nb_yn.equals("Y") ) ){  mandate_secondnewbornValue="visibility:visible"; }
	   if(((function_id.equals("REGISTER_NEWBORN") || function_id == "REGISTER_NEWBORN") && (calling_module_id.equals("") || calling_module_id.equals("MP")) && (mandate_third_newborn_yn.equals("Y") || mandate_third_newborn_yn == "Y") ) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_third_newborn_yn.equals("Y") && mp_regn_nb_yn.equals("Y") )){  mandate_third_newbornValue="visibility:visible"; }
	   if(((function_id.equals("REGISTER_NEWBORN") || function_id == "REGISTER_NEWBORN") && (calling_module_id.equals("") || calling_module_id.equals("MP")) && (mand_antenatal_newborn_yn.equals("Y") || mand_antenatal_newborn_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mand_antenatal_newborn_yn.equals("Y") && mp_regn_nb_yn.equals("Y") ) ){  mand_antenatal_newbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("AE") || calling_module_id == "AE") && (mandate_first_newborn_ae_yn.equals("Y") || mandate_first_newborn_ae_yn == "Y") ) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_first_newborn_ae_yn.equals("Y") && emer_regn_nb.equals("Y") ) ) { mandatefirstnewbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("AE") || calling_module_id == "AE") && (mandate_second_newborn_ae_yn.equals("Y") || mandate_second_newborn_ae_yn == "Y") ) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_second_newborn_ae_yn.equals("Y") && emer_regn_nb.equals("Y") ) ) { mandate_secondnewbornValue="visibility:visible";  }
	   if(((calling_module_id.equals("AE") || calling_module_id == "AE") && (mandate_third_newborn_ae_yn.equals("Y") || mandate_third_newborn_ae_yn == "Y") ) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_third_newborn_ae_yn.equals("Y") && emer_regn_nb.equals("Y") ) ) { mandate_third_newbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("AE") || calling_module_id == "AE") && (mand_antenatal_newborn_ae_yn.equals("Y") || mand_antenatal_newborn_ae_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mand_antenatal_newborn_ae_yn.equals("Y") && emer_regn_nb.equals("Y") )  ) { mand_antenatal_newbornValue ="visibility:visible";}
	    if(((calling_module_id.equals("IP") || calling_module_id == "IP") && (mandate_first_newborn_ip_yn.equals("Y") || mandate_first_newborn_ip_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_first_newborn_ip_yn.equals("Y") && ip_regn_nb_yn.equals("Y") ) ){  mandatefirstnewbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("IP") || calling_module_id == "IP") && (mandate_second_newborn_ip_yn.equals("Y") || mandate_second_newborn_ip_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_second_newborn_ip_yn.equals("Y") && ip_regn_nb_yn.equals("Y") )  ){  mandate_secondnewbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("IP") || calling_module_id == "IP") && (mandate_third_newborn_ip_yn.equals("Y") || mandate_third_newborn_ip_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mandate_third_newborn_ip_yn.equals("Y") && ip_regn_nb_yn.equals("Y") ) ){  mandate_third_newbornValue="visibility:visible"; }
	   if(((calling_module_id.equals("IP") || calling_module_id == "IP") && (mand_antenatal_newborn_ip_yn.equals("Y") || mand_antenatal_newborn_ip_yn == "Y")) || ( function_id.equals("MAINTAIN_BIRTH") && mand_antenatal_newborn_ip_yn.equals("Y") && ip_regn_nb_yn.equals("Y") ) ){  mand_antenatal_newbornValue ="visibility:visible"; }
		race_required_yn = checkForNull((String)mPParamDtls.get("race_required_yn"));	
		mp_param_reqdate				= checkForNull((String)mPParamDtls.get("sysdays_reg"));
		FAMILY_ORG_ID_ACCEPT_YN			= checkForNull((String)mPParamDtls.get("family_org_id_accept_yn"));
		FAMILY_NO_LINK_YN				= checkForNull((String)mPParamDtls.get("family_no_link_yn"));
		entitlement_by_pat_cat_yn		= checkForNull((String)mPParamDtls.get("entitlement_by_pat_cat_yn"));
		mp_param_sysdate				= checkForNull((String)mPParamDtls.get("sysdatesys"));
		current_date					= checkForNull((String)mPParamDtls.get("curr_date"));
		nat_invoke_routine				= checkForNull((String)mPParamDtls.get("invoke_routine"));
		nat_data_source_id				= checkForNull((String)mPParamDtls.get("nat_data_source_id"));
		nat_id_check_digit_id			= checkForNull((String)mPParamDtls.get("nat_id_check_digit_id"));
		nat_id_chk_len					= checkForNull((String)mPParamDtls.get("nat_id_chk_len"));
		single_stage_nb_reg_appl_yn		= checkForNull((String)mPParamDtls.get("single_stage_nb_reg_appl_yn"));	 
		data_upd_allowed_aft_final_yn	= checkForNull((String)mPParamDtls.get("data_upd_allowed_aft_final_yn")); 
		name_prefix_male_nb	= checkForNull((String)mPParamDtls.get("name_prefix_male_nb"));	 
		name_prefix_female_nb = checkForNull((String)mPParamDtls.get("name_prefix_female_nb"));	 
	    name_prefix_unknown_nb = checkForNull((String)mPParamDtls.get("name_prefix_unknown_nb"));	//Added by Afruddin for ML-MMOH-CRF-1520 US 0002
		name_suffix_male_nb	= checkForNull((String)mPParamDtls.get("name_suffix_male_nb"));	 
		name_suffix_female_nb = checkForNull((String)mPParamDtls.get("name_suffix_female_nb"));
		name_pfx_loc_lang_male_nb	= checkForNull((String)mPParamDtls.get("name_pfx_loc_lang_male_nb"));		
		name_pfx_loc_lang_female_nb	= checkForNull((String)mPParamDtls.get("name_pfx_loc_lang_female_nb"));	
		name_pfx_loc_lang_unknown_nb	= checkForNull((String)mPParamDtls.get("name_pfx_loc_lang_unknown_nb")); //Added by Afruddin for ML-MMOH-CRF-1520 US 0002
		name_sfx_loc_lang_male_nb	= checkForNull((String)mPParamDtls.get("name_sfx_loc_lang_male_nb"));		
		name_sfx_loc_lang_female_nb	= checkForNull((String)mPParamDtls.get("name_sfx_loc_lang_female_nb"));	
        nb_mother_dtls_update_yn= checkForNull((String)mPParamDtls.get("nb_mother_dtls_update_yn")); 
		if(nb_mother_dtls_update_yn.equals("Y") && disable_button_yn.equals("N")){
		  dis_all_mother_dtls="";	
		}else{
		    dis_all_mother_dtls=dis_all_flds;	
		 }
		if(!(checkForNull((String) hashMap.get("q_father_patient_id"))).equals("")) 
		{ fath_disable = ""; father_id_exists = "1"; }
		if(!cd2.equals("")){
          getAllowNewBornDate=mp_param_reqdate;
		}
		else
           getAllowNewBornDate="";
		if(bl_install_yn.equals("Y")){
			dflt_nb_regn_blng_class = checkForNull((String)mPParamDtls.get("dflt_nb_regn_blng_class"));
		}
		diffHours = Integer.parseInt(checkForNull((String) mthrDtls.get("diffHours"),"0"));
		double temp_var = (double)diffHours/(24*7);							
		long diffWeeks = Math.round(temp_var);
		min_gest_bet_del = Double.parseDouble(checkForNull((String)mPParamDtls.get("nb_min_gest_bet_2_dely"),"0"));
		if(diffWeeks > min_gest_bet_del) {
			new_registration = 1;
		}
		if(new_registration == 0) {
			hashMap3 = eMP.NewbornDetails.getMPBirthRegisterData((String) hashMap.get("q_mother_patient_id"), "mp_birth_register1", con,p);
			q_no_of_birth					= Integer.parseInt(checkForNull((String)hashMap3.get("q_no_of_birth"),"0"));
			q_gestational_period			= checkForNull((String) hashMap3.get("q_gestational_period"));
			q_gestational_period_days		= checkForNull((String) hashMap3.get("q_gestational_period_days"));
			q_birth_order					= checkForNull((String) hashMap3.get("q_birth_order"));		  
			q_parity						= checkForNull((String) hashMap3.get("q_parity"));
			q_parity1						= checkForNull((String) hashMap3.get("q_parity1")); //68508
			q_gravida						= checkForNull((String) hashMap3.get("q_gravida"));
			if(q_no_of_birth > 1) {
				flag = 1;
			} else {	
				flag = 0;
			}
		}
		String hide_bedNo ="", bed_label ="";	
		if(invoke_adm_from_newborn_yn.equals("Y")){
		
			bed_label="";
			hide_bedNo="style='visibility:hidden'";
		}else {
			bed_label=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels");
			hide_bedNo="style='visibility:visible'";
		}
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
		<html>
		<head>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
			<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
			<Script src="../../eCommon/js/messages.js" language="JavaScript"></Script>
			<script src='../../eCommon/js/common.js' language='javascript'></script>
			<script src='../../eCommon/js/dchk.js' language='javascript'></script>
			<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
			<script src='../../eMP/js/NewbornRegistration.js' language='javascript'></script>
			<script src='../../eMP/js/NewbornRegistration1.js' language='javascript'></script>
			<script src='../../eMP/js/NewbornRegistration2.js' language='javascript'></script>
			<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
			<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
			<Script src="../../eCommon/js/calScript/hj/calendar.js" language="JavaScript"></Script> <!--Added for this CRF MMS-QH-CRF-0145.1 [IN:047497]-->
			<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>
		</head>
		<style>
			#mother_dtls td .label {
				width: 15%;
			}
			#mother_dtls td .fields {
				width: 35%;
			}
		</style>
			<script>
				var frame_ref = "";
				if('<%=new_function_id%>'=='MAINTAIN_BIRTH')
					frame_ref = "parent.parent.frames[1].frames[2]";
				else
					frame_ref = "parent.parent.frames[1].frames[2]";
			</script>
			<style>
textarea {
  resize: none;
}
</style>
			<body  OnMouseDown="CodeArrest()" onKeyDown="lockKey()"  onload="newbornbabyNames();if(parent.parent.frames[1].frames[2].document.getElementById('mothergrp1_tab')){parent.parent.frames[1].frames[2].document.getElementById('mothergrp1_tab').scrollIntoView();}disabledFields();disableonload();emerRegnNBValidations();<%if(isMPMandatoryFieldsNewborn){%>onchange_antenatal1('<%=antvalue%>','<%=function_id%>');<%}%><%if(mpDisableFieldsNBFather && function_id.equals("MAINTAIN_BIRTH")){%>noMaritalStatusload('<%=no_marital_status%>','FatherDtls','<%=function_id%>');<%}%>">
			<%
				min_weight						= checkForNull((String) mPParamDtls.get("min_weight"));
				max_weight						= checkForNull((String) mPParamDtls.get("max_weight"));
				min_chest_circum				= checkForNull((String) mPParamDtls.get("min_chest_circum"));
				max_chest_circum				= checkForNull((String) mPParamDtls.get("max_chest_circum"));
				min_head_circum					= checkForNull((String) mPParamDtls.get("min_head_circum"));
				max_head_circum					= checkForNull((String) mPParamDtls.get("max_head_circum"));
				min_length						= checkForNull((String) mPParamDtls.get("min_length"));
				max_length						= checkForNull((String) mPParamDtls.get("max_length"));
				min_gestation					= checkForNull((String) mPParamDtls.get("min_gestation"));
				max_gestation					= checkForNull((String) mPParamDtls.get("max_gestation"));
				nb_male_relnship				= checkForNull((String) mPParamDtls.get("nb_male_relnship"));
				nb_female_relnship				= checkForNull((String) mPParamDtls.get("nb_female_relnship"));
				nb_unknown_relnship				= checkForNull((String) mPParamDtls.get("nb_unknown_relnship"));
				pat_name_as_multipart_yn		= checkForNull((String) mPParamDtls.get("pat_name_as_multipart_yn"));
				nat_id_accept_alphanumeric_yn	= checkForNull((String) mPParamDtls.get("nat_id_accept_alphanumeric_yn"),"N");
				name_dervn_logic	= checkForNull((String) mPParamDtls.get("name_dervn_logic"),"");
				name_dervn_logic_long	= checkForNull((String) mPParamDtls.get("name_dervn_logic_long"),"");
				name_dervn_logic_oth_lang	= checkForNull((String) mPParamDtls.get("name_dervn_logic_oth_lang"),"");
				name_dervn_logic_oth_lang_long	= checkForNull((String) mPParamDtls.get("name_dervn_logic_oth_lang_long"),"");
		
				out.println("<script language = 'javascript'> var PSGCodeArray = new Array(); var PSGYNArray = new Array(); var PSGPRYNArray = new Array(); var NamePrefixArray = new Array(); var PrefixSexArray = new Array();");	
				array_list = eMP.NewbornDetails.getPatSerGroupGenIdPrefixReqd(con,p);
				int k =0;
				for(int i=0;i<array_list.size();i+=3) {
					out.println("PSGCodeArray["+k+"]=\""+(String) array_list.get(i)+"\";");
					out.println("PSGYNArray["+k+"]=\""+(String) array_list.get(i+1)+"\";");
					out.println("PSGPRYNArray["+k+"]=\""+(String) array_list.get(i+2)+"\";");
					k++;
				}
				out.println("</script>");




				accessRights = (String)session.getValue("accessRights");
				%>				
				<form name='NewbornRegistration_form' id='NewbornRegistration_form' action='../../servlet/eMP.NewbornRegistrationServlet' method='post' target='messageFrame' onSubmit="return getNewBornRegnValues('pat_id')">
			<table width="100%" cellpadding=1 cellspacing=0 border='0'>
				<tr><td>
					<table id='mother_tab' width="100%" cellpadding=1 cellspacing=0 border='0'>
						<tr> 
							<td colspan='4' class='COLUMNHEADER'><span id='mother_dtls_link' onClick='javascript:expandCollapse("MD")'><input type='button' class='button' value='-' name='mother_button' id='mother_button'></span>&nbsp;<fmt:message key="eMP.motherdetails.label" bundle="${mp_labels}"/></td>
							<input type='hidden' name='function_id_mg' id='function_id_mg' value="<%=new_function_id%>">
						</tr>
					</table>
				</td></tr>
				<tr><td>
				<div id='mother_dtls'>
					<table width="100%" cellpadding=1 cellspacing=0 border='0'>						
						<%
						if(!function_id.equals("REGISTER_NEWBORN")){ 
							if(!invoked_from.equals("servlet") && !invoked_from.equals("details_page")) {							
						%>
					<tr>
						<td class='label'  width='22%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
						<td class='fields'><input type=text name='mother_patient_id1' id='mother_patient_id1' value="<%=(String) hashMap.get("q_mother_patient_id")%>" maxlength="<%=patient_idlength%>" size='20' disabled><input type=button <%=dis_all_flds%> class=button name='mothersearch_button' value='?' onclick='mothersearch();' disabled><img align=center src='../images/mandatory.gif'></img>
						<input type='hidden' name='mother_patient_id' id='mother_patient_id' value="<%=(String) 	hashMap.get("q_mother_patient_id")%>">
						<td class='label' colspan=4  >
							<table  width="100%" cellpadding=1 cellspacing=0 border=0 ><tr><td class='label'width='5%' ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
							<td class='querydata' id="name_moth">
							<b><%=checkForNull((String) mthrDtls.get("q_mother_patient_name"))%></b>
							</td></tr>
						</table>	</td>
					</tr>
					<%} else { %>
							<input type='hidden' name='mother_patient_id' id='mother_patient_id' value="<%=(String) 	hashMap.get("q_mother_patient_id")%>"> <%
					}}%>
			<% 
			if(isRegNewbornApplicable){
			%>		
			 <tr>		  
           <%if(accept_national_id_no_yn.equals("Y")){%>
			   <% if(!cd3.equals("")){  %>
					  <td class='label' height="25"> <%=cd3%> </td>
					  <td class='QUERYDATA' height="25"><%=mthr_nat_id_no%>&nbsp;</td>
			   <% }else {%>
			         <td class='label' >&nbsp;</td>
					 <td class='QUERYDATA' >&nbsp;</td>
			   <%}}
			   else{ %>
					  <td class='label' >&nbsp;</td>
					  <td class='QUERYDATA' >&nbsp;</td>
                <% }%>
				<td class='label' height="25">&nbsp;</td>
				<td class='QUERYDATA' height="25">&nbsp;<%if(calling_module_id.equals("IP")){%><a name='ViewPatChartSummary'   href="javascript:showPatChartSummary('<%=motherencounterid%>','<%=mother_patient_id%>','<%=request.getContextPath()%>');"><B><fmt:message key="Common.ViewPatChartSummary.label" bundle="${common_labels}"/></B></a><%}%></td>  				
			</tr>    
		<tr>	
			<td class='label' height="25" ><%if(!alt_id1_type_desc.equals("")){%><fmt:message key="eMP.mothers.label" bundle="${mp_labels}"/> <%=alt_id1_type_desc%></td><input type = 'hidden' name ='alt_id_type_desc' value='<%=alt_id1_type_desc%>'> <%}if(alt_id1_type_desc.equals("")&&!alt_id2_type_desc.equals("")){%><%=alt_id2_type_desc%> <%} if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){%><%=alt_id3_type_desc%><%}if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){%><fmt:message key="eMP.OtherAltNo.label" bundle="${common_labels}"/> <%}%>
			 <td class='QUERYDATA' height="25"><%if(!alt_id1_type_desc.equals("")){%><%=mthr_alt_id1_no%><%}if(alt_id1_type_desc.equals("")&&!alt_id2_type_desc.equals("")){%><%=mthr_alt_id2_no%><%}if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){%><%=mthr_alt_id3_no%><%} if(alt_id1_type_desc.equals("")&&alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){%><%=mthr_oth_alt_id_No%><%}%></td>			
			<%
			  if((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && (accept_oth_alt_id_yn.equals("N") || accept_oth_alt_id_yn.equals("Y"))) && (alt_id3_type_desc.equals("") || !alt_id3_type_desc.equals("") ) ){%>
					  <td class='label' height="25"><%=alt_id2_type_desc%>&nbsp;</td>
					  <td class='QUERYDATA' height="25"><%=mthr_alt_id2_no%>&nbsp;</td>
            <% }
			if((!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") &&!alt_id3_type_desc.equals("") && (accept_oth_alt_id_yn.equals("N") ||accept_oth_alt_id_yn.equals("Y")) )){
			%>
					  <td class='label' height="25"><%=alt_id3_type_desc%>&nbsp;</td>
					  <td class='QUERYDATA' height="25"><%=mthr_alt_id3_no%>&nbsp;</td>
            <% } if((!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) ){%>
					  <td  class="label"  height="25"><fmt:message key="eMP.OtherAltNo.label" bundle="${common_labels}"/></td>
					  <td class='QUERYDATA'  height="25"><%=mthr_oth_alt_id_No%>&nbsp;</td>
					   <% } %>
			<input type='hidden' name='mother_pmi_no' id='mother_pmi_no' value='<%=mthr_alt_id1_no%>'>
			<input type='hidden' name='invoked_from' id='invoked_from' value = '<%=invoked_from%>'>
			<input type='hidden' name='race_required_yn' id='race_required_yn' value = '<%=race_required_yn%>'>
			</tr>
			<tr> 
			  <% 
                if((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")) || ((!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (alt_id1_type_desc.equals("") && !!alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) || (!alt_id1_type_desc.equals("") && alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")) ) ){   
               %>
			   <td class='label' height="25"><%if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){%><%=alt_id3_type_desc%><%}else {%><fmt:message key="eMP.OtherAltNo.label" bundle="${common_labels}"/><%}%> </td>
					  <td class='QUERYDATA' height="25"><%if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("")){%><%=mthr_alt_id3_no%><%}else{%><%=mthr_oth_alt_id_No%><%}%>&nbsp;</td>
			   <% } if(!alt_id1_type_desc.equals("") && !alt_id2_type_desc.equals("") && !alt_id3_type_desc.equals("") && accept_oth_alt_id_yn.equals("Y")){%>
					  <td  class="label"  height="25"><fmt:message key="eMP.OtherAltNo.label" bundle="${common_labels}"/></td>
					  <td class='QUERYDATA'  height="25"><%=mthr_oth_alt_id_No%>&nbsp;</td>
			<% } %>
			   </tr>		   
		  <% //End this CRF ML-MMOH-CRF-0621
		  }
		  else if(isMPMandatoryFieldsNewborn){
			  %><jsp:include page="../../eMP/jsp/NewbornRegistrationMotherDtls.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="accept_national_id_no_yn"  value='<%=accept_national_id_no_yn%>'/>
				<jsp:param name="mthr_nat_id_no"  value='<%=mthr_nat_id_no%>'/>
				<jsp:param name="cd3"  value='<%=cd3%>'/>
				<jsp:param name="accept_oth_alt_id_yn"  value='<%=accept_oth_alt_id_yn%>'/>
				<jsp:param name="mthr_oth_alt_id_No"  value='<%=mthr_oth_alt_id_No%>'/> 		
				<jsp:param name="mthr_alt_id1_no"  value='<%=mthr_alt_id1_no%>'/> 		
				<jsp:param name="alt_id1_type_desc"  value='<%=alt_id1_type_desc%>'/> 		
				<jsp:param name="mthr_alt_id2_no"  value='<%=mthr_alt_id2_no%>'/> 		
				<jsp:param name="alt_id2_type_desc"  value='<%=alt_id2_type_desc%>'/> 	
				<jsp:param name="mthr_alt_id3_no"  value='<%=mthr_alt_id3_no%>'/> 		
				<jsp:param name="alt_id3_type_desc"  value='<%=alt_id3_type_desc%>'/> 		
				<jsp:param name="mthr_alt_id4_no"  value='<%=mthr_alt_id4_no%>'/> 		
				<jsp:param name="alt_id4_type_desc"  value='<%=alt_id4_type_desc%>'/> 	
				<jsp:param name="motherencounterid"  value='<%=motherencounterid%>'/> 	
				<jsp:param name="mother_patient_id"  value='<%=mother_patient_id%>'/> 	
				<jsp:param name="invoked_from"  value='<%=invoked_from%>'/> 	
				<jsp:param name="race_required_yn"  value='<%=race_required_yn%>'/> 	
				<jsp:param name="oth_alt_id_type"  value='<%=oth_alt_id_type%>'/> 	
				</jsp:include>	
		<%  }else{%>
		   <tr>	
		    <% if(!alt_id1_type_desc.equals("")){  %>
			<td class='label' height="25" ><fmt:message key="eMP.mothers.label" bundle="${mp_labels}"/> <%=alt_id1_type_desc%></td><input type = 'hidden'  name ='alt_id_type_desc' id='alt_id_type_desc' value='<%=alt_id1_type_desc%>'>
			<%if(calling_module_id.equals("IP")) {%>
			    <td class='QUERYDATA' ><%=mthr_alt_id1_no%></td>
				<td class='label' height="25"><a name='ViewPatChartSummary'   href="javascript:showPatChartSummary('<%=motherencounterid%>','<%=mother_patient_id%>','<%=request.getContextPath()%>');"><B><fmt:message key="Common.ViewPatChartSummary.label" bundle="${common_labels}"/></B></a></td>
			<%}else{%>
				<td  class='QUERYDATA' height="25"><b><%=mthr_alt_id1_no%></b></td>
			<%}}%>
			<input type='hidden' name='mother_pmi_no' id='mother_pmi_no' value='<%=mthr_alt_id1_no%>'>
			<input type='hidden' name='invoked_from' id='invoked_from' value = '<%=invoked_from%>'>
			<input type='hidden' name='race_required_yn' id='race_required_yn' value = '<%=race_required_yn%>'>
			</tr>
			<tr>
			<% if(!alt_id2_type_desc.equals("")){  %>
					  <td class='label' height="25"> <%=alt_id2_type_desc%> </td>
					  <td class='QUERYDATA' height="25"><%=mthr_alt_id2_no%>&nbsp;</td>
			   <% } else {  %>
						  <td class='label' >&nbsp;</td>
						  <td class='label'> &nbsp;</td>
			   <% } %>
			   <% if(!alt_id3_type_desc.equals("")){  %>
					  <td class='label' height="25"><%=alt_id3_type_desc%> </td>
					  <td class='QUERYDATA' height="25"><%=mthr_alt_id3_no%>&nbsp;</td>
			   <% } else {  %>
						  <td class='label'  >&nbsp;</td>
						  <td class='label'> &nbsp;</td>
			   <% } %>
			   </tr>
			   <tr>
			   <% if(!alt_id4_type_desc.equals("")){  %>
                      <td class='label' height="25"><%= alt_id4_type_desc%></td>
				      <td class='QUERYDATA' height="25"><%=mthr_alt_id4_no%>&nbsp;</td>
			    <% } else{ %>
					  <td class='label' >&nbsp;</td>
					  <td class='QUERYDATA' >&nbsp;</td>
                <% }%>
               <%if(accept_national_id_no_yn.equals("Y")){%>
			   <% if(!cd3.equals("")){  %>
					  <td class='label' height="25"> <%=cd3%> </td>
					  <td class='QUERYDATA' height="25"><%=mthr_nat_id_no%>&nbsp;</td>
			   <% } }
			   else{ %>
					  <td class='label' >&nbsp;</td>
					  <td class='QUERYDATA' >&nbsp;</td>
                <% }%>
			</tr>    
		     <tr>
			    <%if(accept_oth_alt_id_yn.equals("Y")){%>
					  <td  class="label"  height="25"><%=oth_alt_id_type%></td>
					  <td class='QUERYDATA'  height="25"><%=mthr_oth_alt_id_No%>&nbsp;</td>
			   <% } else{ %>
					  <td class='label' >&nbsp;</td>
					  <td class='QUERYDATA' >&nbsp;</td>
                <% }%>
		     </tr> 	  
          <%}%>
		<tr>
		<td class='label'  ><fmt:message key="eMP.MultipleBirth.label" bundle="${mp_labels}"/></td>
		<td class='fields' >
		<%  
		if(function_id.equals("REGISTER_NEWBORN")){
			 if(flag==1)
			 {
				 multi_check="checked";
				 multibirthvalue="Y";
				 multidisabled="disabled";
			 }
		}else{
			 if(checkForNull((String) hashMap.get("q_multiple_birth_yn")).equals("Y")) {
				 multibirthvalue="Y";
				 multi_check="checked";
			   }
			  multidisabled="disabled";
		   }
			if(function_id.equals("REGISTER_NEWBORN")){
				if(q_no_of_birth==0)
					q_no_of_birth=1;
				if(MC_Dtls_YN.equals("Y") && !ca_no_of_births.equals("")){
					q_no_of_birth=Integer.parseInt(ca_no_of_births);
					if(q_no_of_birth > 1){
						multi_check="checked";
					}
				}
			}
		%>
	   <input type="checkbox" name="multiple_birth_yn" id="multiple_birth_yn" onClick='enableBirthField(this);' value='<%=multibirthvalue%>' <%=multi_check%> <%=multidisabled%> <%if(MC_Dtls_YN.equals("Y")){%>disabled<%}%>></td>
		<td class='label'  ><fmt:message key="Common.NoofBirths.label" bundle="${common_labels}"/></td>
		<%if(function_id.equals("REGISTER_NEWBORN")){
			String noofbirthvisibible="visibility:hidden";
			if(flag==1)
			{
				noofbirthvisibible="visibility:visible";
			}
			%>
			<td class='fields' >
			<input type="text" name="noOfBirths" id="noOfBirths"  value='<%=q_no_of_birth%>' maxlength=1 size=1 onBlur="makeValidString(this);getNewBornRegnValues(this.name); setNum(this); return allowValidNumber(this,'event',1,0);" disabled>
			<font id='img1'><img align=center src='../../eCommon/images/mandatory.gif' style='<%=noofbirthvisibible%>'></font>
		  </td>
		  <input type="hidden" name="birth_order" id="birth_order" value='<%=q_birth_order%>'>
		  <%}else{%>
			<td class='querydata'><%=(String) hashMap.get("q_no_of_birth")%><input type="hidden" name="noOfBirths" id="noOfBirths" value="<%=(String) hashMap.get("q_no_of_birth")%>"></td>
			<input type="hidden" name="birth_order" id="birth_order" value='<%=(String) hashMap.get("q_birth_order")%>'>
			<%}%>
			</tr>
			<tr>
			<td class='label'  ><fmt:message key="eMP.Gestation.label" bundle="${mp_labels}"/></td>
			<td class='fields'><input type = 'hidden' name ='unitofgestnb' id='unitofgestnb' value='<%=unitofgestnb%>'>
			<%	
			sel1 = ""; sel2 = ""; 
			if(unitofgestnb.equals("W")) {
				sel1="selected";						
			} else { 
				sel2 = "selected";				
			}			 
			if(function_id.equals("REGISTER_NEWBORN")){
				if(flag == 1){ 
					if(!q_gestational_period.equals("")) {
						gestdisabled="disabled";
					}		
					if(!q_gestational_period_days.equals("")) {
						gestDaysDisabled="disabled";
					}	
				}				
				if(!lmp_ca.equals("")){
					if(unitofgestnb.equals("W")){
						q_gestational_period=no_of_weeks;
						if(nod <= 6){
							q_gestational_period_days=(new Integer(nod)).toString();
						}
					}else{
						q_gestational_period=no_of_days;
					}
					gestdisabled1="disabled";					
					gestDaysDisabled="disabled";
				}
			}else{
				  q_gestational_period = checkForNull((String) hashMap.get("q_gestational_period"));			  
				  q_gestational_period_days = checkForNull((String) hashMap.get("q_gestational_period_days"));				 
				  if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || (invoked_from.equals("servlet"))) {
					  gestdisabled = "disabled";
					  gestDaysDisabled="disabled";
				  }else{
					  gestdisabled="";
					  if(!q_gestational_period_days.equals("")) {
						  gestDaysDisabled="";
					  }
				  }
				  if(!((String)hashMap.get("q_lmp")).equals("")){
					  gestdisabled1="disabled";
					  gestDaysDisabled="disabled";
				  }
			}
			%><!-- Modified against IN:49882 -->
			<input type="text" name="gestational_period" id="gestational_period" maxlength=3 size=2 value='<%=q_gestational_period%>' onBlur="return validateMinMax(this,'<%=min_gestation%>','<%=max_gestation%>',gestational_period); makeValidString(this);CheckNum(this);return allowValidNumber(this,'event',3,0)" onKeyPress='return allowValidNumber(this,event,3,0)' <%=gestdisabled1%> <%=gestdisabled%>>
			<select name="gestational_unit" id="gestational_unit" disabled><option value='W' <%=sel1%>><fmt:message key="Common.weeks.label" bundle="${common_labels}"/><option value='D' <%=sel2%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></select>
			<% 
				if(unitofgestnb.equals("W")){
			%>
				<input type="text" name="gestational_period_days" id="gestational_period_days" maxlength='1' size='2' value='<%=q_gestational_period_days%>' onBlur="validateGestDays(this);makeValidString(this);return allowValidNumber(this,'event',3,0);" onKeyPress='return allowValidNumber(this,event,3,0)' <%=gestDaysDisabled%>>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>	
			<%
				}
			%>
			<%if(called_function.equals("IP")){%>
			<img src='../images/mandatory.gif'></img><%
			} %></td>  		
				<td class='label'><fmt:message key="eMP.DeliveryType.label" bundle="${mp_labels}"/></td>
				<td><select name="nod_type" id="nod_type" onChange='enDisCompls(this.value,"Y")'<%=dis_all_mother_dtls%> <%if((!ca_delivery_type.equals("")) && (!nb_mother_dtls_update_yn.equals("Y")) ||(finalizeYN.equals("Y"))&&(ca_no_of_births.equals(""))){%>disabled<%}%>><!--Changes Modified on 30-04-2012 against Incident Numbers 32487 & 32488 By Saanthaakumar--> 
				<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------
				<%
				array_list = eMP.NewbornDetails.getNodeTypeShortDesc(con,p);
				for(int i=0;i<array_list.size();i+=3) {
					if(ca_delivery_type.equals((String)array_list.get(i))){
						out.println("<option value=\""+(String)array_list.get(i)+"$"+(String)array_list.get(i+2)+"\" selected>"+(String) array_list.get(i+1)+"</option>");
					}else{
						out.println("<option value=\""+(String)array_list.get(i)+"$"+(String)array_list.get(i+2)+"\">"+(String) array_list.get(i+1)+"</option>");
					} 				
				}
				%>
				</select><img align=center src='../../eCommon/images/mandatory.gif' id='DeliveryTypeMandImg'></img>
			    <%if(!function_id.equals("REGISTER_NEWBORN")){%>
			     <script>
					<%
						if((!checkForNull((String) hashMap.get("q_nod_type")).equals("")) && (!checkForNull((String) hashMap.get("q_delivery_indicator")).equals(""))){
					%>
						document.forms[0].nod_type.value="<%=checkForNull((String) hashMap.get("q_nod_type"))%>"+"$"+"<%=checkForNull((String) hashMap.get("q_delivery_indicator"))%>";
					<%}%>
				</script>
				<%}%>
			</td>
			</tr>
			<tr>
			<%
				if((called_function.equals("IP")&& isLabelChangeApplicable) || (called_function.equals("IP") && isRegNewbornApplicable)){%><!-- Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565 -->
			<td class='label'  ><fmt:message key="eMP.GravidaOnAdmission.label" bundle="${mp_labels}"/></td>
			<%}else{%>
			<td class='label'  ><fmt:message key="eMP.Gravida.label" bundle="${mp_labels}"/></td>
			<%}%>
			<td class='fields'>
			<%if(!function_id.equals("REGISTER_NEWBORN")){
				q_gravida=checkForNull((String) hashMap.get("q_gravida"));}%> <!--Below line modified for this CRF HSA-CRF-0182 -->
			<input type="text" name="gravida" id="gravida" maxlength=2 size=2  value='<%=q_gravida%>' <%=dis_all_mother_dtls%> onKeyPress='return allowValidNumber(this,event,2,0);SPCheckPositiveNumber(this);' onBlur="checkGravida();makeValidString(this);enableParity(this);checkwithgravida();return allowValidNumber(this,'event',2,0);"><%if(called_function.equals("IP")){%><img src='../images/mandatory.gif' align='center'></img><%}%>
			</td>
			<% /*Below line added for this CRF ML-MMOH-CRF-0621*/
			if((called_function.equals("IP") && isLabelChangeApplicable) || (called_function.equals("IP") && isRegNewbornApplicable)){%><!-- Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565 -->
			<td class='label'  ><fmt:message key="eMP.ParityOnAdmission.label" bundle="${mp_labels}"/></td>
			<%}else{%>
			<td class='label'  ><fmt:message key="eMP.Parity.label" bundle="${mp_labels}"/></td>
			<%}%>
			<%if(!function_id.equals("REGISTER_NEWBORN")){
			 q_parity=checkForNull((String)hashMap.get("q_parity"));
			 q_parity1=checkForNull((String)hashMap.get("q_parity1"));  //68508
			}%> <!--Below line modified for this CRF HSA-CRF-0182 -->
			<td class='fields'>
			
			
			<input type="text"  name="parity" id="parity" value='<%=q_parity%>'  <%=dis_all_mother_dtls%> maxlength=2 size=2  onKeyPress='return allowValidNumber(this,event,2,0);SPCheckPositiveNumber(this);' onBlur="checkParity();makeValidString(this); checkwithgravida();return allowValidNumber(this,'event',2,0);">
			<%if(isRegNewbornApplicable){%>&nbsp;&nbsp;
			<input type="text"  name="parity_on_admission" id="parity_on_admission" value="<%=checkForNull((String)hashMap.get("parity_on_admission"))%>"  <%=dis_all_mother_dtls%> maxlength=2 size=2  onKeyPress='return allowValidNumber(this,event,2,0);SPCheckPositiveNumber(this);' onpaste="return OnPaste()" onBlur="checkParity();makeValidString(this); checkwithgravida();return allowValidNumber(this,'event',2,0);">
			<%}%>
			<% 
			if((called_function.equals("IP")) || (called_function.equals("MP") && mandParityNewBornYN.equals("Y") && invokeMenstrualHistYN.equals("Y")) || (called_function.equals("AE") && mandParityNewBornAE_YN.equals("Y") && invokeMenstrualHistYN.equals("Y"))) 
			{ 
			
			%><img src='../images/mandatory.gif' align='center'></img>
			
			<%}%>
			
			<%if(invokeMenstrualHistYN.equals("Y")){%>
			<span>+</span>
			<input type="text"  name="parity1" id="parity1" value='<%=q_parity1%>'  <%=dis_all_mother_dtls%> maxlength=2 size=2  onKeyPress='return allowValidNumber(this,event,2,0);SPCheckPositiveNumber(this);' onBlur="checkParity();makeValidString(this); checkwithgravida();return allowValidNumber(this,'event',2,0);" title="Previous Miscarriage">  <!--  //68508 -->
			<%} %>
			<% if((called_function.equals("IP") && mandParityNewBornIP_YN.equals("Y") && invokeMenstrualHistYN.equals("Y")) || (called_function.equals("MP") && mandParityNewBornYN.equals("Y") && invokeMenstrualHistYN.equals("Y")) || (called_function.equals("AE") && mandParityNewBornAE_YN.equals("Y") && invokeMenstrualHistYN.equals("Y"))) { 
			%><img src='../images/mandatory.gif' align='center'></img><%}%>
			</td>
        	</tr>	
			<tr>
				<td class='label'  >
				<%	if(isNewBornChngsAppl){%>
					<fmt:message key="Common.ConductedBy.label" bundle="${common_labels}"/>
				<%}else{%>
					<fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/>
				<%}%>
				</td>
			<input type='hidden' maxlength=10 size=10 name="temp_desc" id="temp_desc" ><input type='hidden' name='temp_id_search' id='temp_id_search' class=button><input type='hidden' name="temp_physician_id" id="temp_physician_id"></td>
			<td  class='fields'><!--Below line modified for this CRF HSA-CRF-0182 -->
			<input type='text' maxLength="30" size="25"  name="practid_desc" id="practid_desc" <%=dis_all_mother_dtls%> onBlur='getattndpract();' value="<%=ca_attend_pract_id_desc%>" ><input type='button'  name='pract_id_search1' id='pract_id_search1' value='?' class='button'  onClick='callPractSearch(document.forms[0].pract_id_search1,document.forms[0].practid_desc); fixvaluespractitioner();' <%=dis_all_mother_dtls%> ><img align=center src='../../eCommon/images/mandatory.gif' id='practid_desc_MandImg'></img>
			<input type='hidden' name="attend_physician_id" id="attend_physician_id" value="<%=ca_attend_pract_id%>">
			<%if(!function_id.equals("REGISTER_NEWBORN")){%>
				<script> 
					document.forms[0].attend_physician_id.value = "<%=checkForNull((String)hashMap.get("q_attend_physician_id"))%>";
					document.forms[0].practid_desc.value = "<%=checkForNull((String)hashMap.get("q_attend_physician_desc"))%>";
				</script>
			<%}%>
			</td> <!--Below line modified for this CRF HSA-CRF-0182 -->			
				<td class='label'  >
					<%if(isNewBornChngsAppl){%>
						<fmt:message key="eIP.AssistedBy.label" bundle="${ip_labels}"/>
					<%}else{%>
							<fmt:message key="eMP.AttendingNurse.label" bundle="${mp_labels}"/>
					<%}%>
				</td>
				<td class='fields'><input type=text name="att_nurse_newborn" id="att_nurse_newborn" maxLength="30" size="25" value="<%=ca_attend_nurse_id_desc%>" onblur="attendingNurse(this);" <%=dis_all_mother_dtls%> ><input type='button'  name='att_nurse_search' id='att_nurse_search' onClick="attendingNurse(this);" value='?' class='button'  onClick='' <%=dis_all_mother_dtls%> ><input type=hidden name="attend_midwife_id" id="attend_midwife_id" value="<%=ca_attend_nurse_id%>">
					 <%if(!function_id.equals("REGISTER_NEWBORN")){
		%>
						<script>
							document.forms[0].attend_midwife_id.value = "<%=checkForNull((String )hashMap.get("q_attend_midwife_id"))%>";
					        document.forms[0].att_nurse_newborn.value = "<%=checkForNull((String )hashMap.get("q_attend_midwife_desc"))%>";
						</script>
					<%}%></td>		
				</tr>
				<%	if(isNewBornChngsAppl){%>
					<tr>
						<td class='label'>
							<fmt:message key="eIP.WitnessedBy1.label" bundle="${ip_labels}"/>
						</td>
						<td class='fields'>
							<input type="text" name="mother_witnessed_by1" id="mother_witnessed_by1" maxlength=80 size=25 <%=dis_all_mother_dtls%> value="<%=checkForNull((String)hashMap.get("mother_witnessed_by1"))%>" >
						</td>	
						<td class='label'>
							<fmt:message key="eIP.WitnessedBy2.label" bundle="${ip_labels}"/>
						</td>
						<td class='fields'>
							<input type="text" name="mother_witnessed_by2" id="mother_witnessed_by2" maxlength=80 size=25 <%=dis_all_mother_dtls%> value="<%=checkForNull((String)hashMap.get("mother_witnessed_by2"))%>" >
						</td>	
					</tr>
				<%}%>
			   <%if(isRegNewbornApplicable){
				if(newbornReg.equals("Y")){
                if((function_id.equals("MAINTAIN_BIRTH") && born_where.equals("I") && babyoutcome.equals("L"))) { 				 
						   headcircum_lengofBaby="visibility:visible"; 
				}else if((function_id.equals("MAINTAIN_BIRTH") && !born_where.equals("I")) || (function_id.equals("MAINTAIN_BIRTH") && !babyoutcome.equals("L"))) {
						   headcircum_lengofBaby="visibility:hidden";	
        		 } 	
			}
        	    String  nat_other_alter_id="", nat_other_alter_legend="";
			    StringBuffer natstrBuffer=new StringBuffer("select national_id_num, oth_alt_id_no from am_practitioner where practitioner_id ='");	
				natstrBuffer.append(checkForNull((String)hashMap.get("q_attend_physician_id"))).append("'");
				newbornstmt = con.prepareStatement(natstrBuffer.toString());
				newbornrs = newbornstmt.executeQuery();
				if(newbornrs!=null && newbornrs.next()){
				national_id=newbornrs.getString("national_id_num")==null?"":newbornrs.getString("national_id_num");
				other_alter_id=newbornrs.getString("oth_alt_id_no")==null?"":newbornrs.getString("oth_alt_id_no");    	 
				}
			 if(!national_id.equals("")){
						 if(cd3.equals("")){
							nat_other_alter_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.NationalIDNo.label","am_labels");
						 }else{
							nat_other_alter_legend=cd3;	
						  }				  
						 nat_other_alter_id=national_id;
			 }else if(national_id.equals("") && !other_alter_id.equals("")){
						   nat_other_alter_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.OtherAltNo.label","mp_labels"); 
						   nat_other_alter_id=other_alter_id;
						 
			}
				 if(newbornrs!=null) newbornrs.close();
				 if(newbornstmt!=null) newbornstmt.close();   
			   %>
                <tr>			   
 					<td class="label"  height="25"><span name="nationality_id" id="nationality_id"><%=nat_other_alter_legend%></span></td>
					<td class='QUERYDATA'  height="25"><span name="oth_alternate_id" id="oth_alternate_id"><%=nat_other_alter_id%></span>&nbsp;</td>	
					<td class="label"  height="25">&nbsp;</td>
					<td class='QUERYDATA'  height="25">&nbsp;</td>
				
					</tr>
					<%}%>			
		    <tr><!--Below line modified for this CRF HSA-CRF-0182 -->
					<td class='label'  ><fmt:message key="eMP.ComplicationsRelatedPregnancy.label" bundle="${mp_labels}"/></td>
			        <td class='fields' ><input type=text name="compln_pregnancy_desc" id="compln_pregnancy_desc" maxLength="75" size="40" onblur="getCompPregnancy(this);" <%=dis_all_mother_dtls%> ><input type='button'  name='comple_preg_button' id='comple_preg_button' onClick="getCompPregnancy(this);" value='?' class='button'  onClick='' <%=dis_all_mother_dtls%> ><input type=hidden name="compln_pregnancy_code" id="compln_pregnancy_code" >	
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						document.forms[0].compln_pregnancy_desc.value = "<%=q_compln_pregnancy_desc%>";
						document.forms[0].compln_pregnancy_code.value = "<%=checkForNull((String)hashMap.get("q_compln_pregnancy_code"))%>";
						</script>
					<%}%>						   
					</td>
	
					<td class='label'  width='25%'  ><fmt:message key="eMP.ComplicationsNotRelatedPregnancy.label" bundle="${mp_labels}"/></td>
			        <td class='fields' ><input type=text name="compln_nr_pregnancy_desc" id="compln_nr_pregnancy_desc" maxLength="75" size="40" onblur="getCompNotRltdPregnancy(this);" <%=dis_all_mother_dtls%>  ><input type='button'  name='compln_nr_button' id='compln_nr_button' onClick="getCompNotRltdPregnancy(this);" value='?' class='button'  onClick='' <%=dis_all_mother_dtls%>  ><input type='hidden' name="compln_nr_pregnancy_code" id="compln_nr_pregnancy_code" >	
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						document.forms[0].compln_nr_pregnancy_desc.value = "<%=q_compln_nr_pregnancy_desc%>";
						document.forms[0].compln_nr_pregnancy_code.value = "<%=checkForNull((String)hashMap.get("q_compln_nr_pregnancy_code"))%>";
						</script>
					<%}%>
					</td>			 
				</tr>				
				<tr>
					<td class='label'><fmt:message key="eMP.Complicationsin1stStage.label" bundle="${mp_labels}"/></td>
					<td class='fields'>
					<select name="complns_1st_stage_labour_code" id="complns_1st_stage_labour_code" <%=dis_all_flds%> <%=dis_com_stages%><%if(((!ca_comp_in_del_stage1.equals(""))||(finalizeYN.equals("Y"))) && !isMPMandatoryFieldsNewborn){%>disabled<%}%>>
					<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------
						<%array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"First");
							for(int i=0;i<array_list.size();i+=inc) {
								sel_yn = "";
								if(ca_comp_in_del_stage1.equals((String)array_list.get(i))){
									sel_yn = "selected";
								}
									out.println("<option value=\""+(String)array_list.get(i)+"\" "+sel_yn+">"+(String) array_list.get(i+incArr)+"</option>");
							}%>
					</select>
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						document.forms[0].complns_1st_stage_labour_code.value="<%=checkForNull((String) hashMap.get("complns_1st_stage_labour_code"))%>";
						</script>
					<%}%>
					<%if(isMPMandatoryFieldsNewborn){%>
					<img align='center' id = 'complns_1st_stage_labour_code_img' src='../../eCommon/images/mandatory.gif' style='<%=mandatefirstnewbornValue%>'></img>
					<%}%>
					</td>
					<!--kamatchi-->
					<%if(!isMPMandatoryFieldsNewborn){%>
					<td class='label'><fmt:message key="eMP.Complicationsin2ndStage.label" bundle="${mp_labels}"/></td>
					<td class='fields'>
					<select name="complns_2nd_stage_labour_code" id="complns_2nd_stage_labour_code" <%=dis_all_flds%> <%=dis_com_stages%><%if((!ca_comp_in_del_stage2.equals(""))||(finalizeYN.equals("Y"))){%>disabled<%}%>>
					<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------
					<%array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Second");
								for(int i=0;i<array_list.size();i+=inc) {
									sel_yn = "";
								if(ca_comp_in_del_stage2.equals((String)array_list.get(i))){
									sel_yn = "selected";
								}
									out.println("<option value=\""+(String)array_list.get(i)+"\" "+sel_yn+">"+(String) array_list.get(i+incArr)+"</option>");
								}%>
					</select>
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						document.forms[0].complns_2nd_stage_labour_code.value="<%=checkForNull((String) hashMap.get("complns_2nd_stage_labour_code"))%>";
						</script>
					<%}%></td>
					<%}else{%>
						<td class='label'  ><%if(isModifyLongShortDescAppl){%><fmt:message key="eMP.IndicationsForOperativeDelivery.label" bundle="${mp_labels}"/><%}else{%><fmt:message key="eMP.DeliveryIndication.label" bundle="${mp_labels}"/><%}%></td>
			        <td class='fields'><!--Below line modified for this CRF HSA-CRF-0182 -->
					<input type=text maxLength="75" size="45" name="del_indica_newborn" id="del_indica_newborn" onblur="delIndiaction(this);" <%=dis_all_mother_dtls%> ><input type='button'  name='del_indica_button' id='del_indica_button' onClick="delIndiaction(this);" value='?' class='button'  onClick='' <%=dis_all_mother_dtls%> ><input type=hidden name="delivery_indication" id="delivery_indication" >
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						document.forms[0].delivery_indication.value = "<%=checkForNull((String )hashMap.get("q_delivery_indication"))%>";
						document.forms[0].del_indica_newborn.value = "<%=dely_ind_desc%>";
						</script>
					<%}%></td>
						<%}%>
					
				</tr>
				<tr>
				<%if(isMPMandatoryFieldsNewborn){%>
					<td class='label'><fmt:message key="eMP.Complicationsin2ndStage.label" bundle="${mp_labels}"/></td>
					<td class='fields'>
					<select name="complns_2nd_stage_labour_code" id="complns_2nd_stage_labour_code" <%=dis_all_flds%> <%=dis_com_stages%><%if(((!ca_comp_in_del_stage2.equals(""))||(finalizeYN.equals("Y"))) && !isMPMandatoryFieldsNewborn){%>disabled<%}%>>
					<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------
					<%array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Second");
								for(int i=0;i<array_list.size();i+=inc) {
									sel_yn = "";
								if(ca_comp_in_del_stage2.equals((String)array_list.get(i))){
									sel_yn = "selected";
								}
									out.println("<option value=\""+(String)array_list.get(i)+"\" "+sel_yn+">"+(String) array_list.get(i+incArr)+"</option>");
								}%>
					</select>
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						document.forms[0].complns_2nd_stage_labour_code.value="<%=checkForNull((String) hashMap.get("complns_2nd_stage_labour_code"))%>";
						</script>
					<%}%>
					<%if(isMPMandatoryFieldsNewborn){%>
					<img align='center' id = 'complns_2nd_stage_labour_code_img' src='../../eCommon/images/mandatory.gif' style='<%=mandate_secondnewbornValue%>'></img>
					<%}%>
					</td>
					<%}else{%>
					<td class='label'><fmt:message key="eMP.Complicationsin3rdStage.label" bundle="${mp_labels}"/></td>
					<td class='fields'><select name="complns_3rd_stage_labour_code" id="complns_3rd_stage_labour_code" <%=dis_all_flds%> <%=dis_com_stages%><%if((!ca_comp_in_del_stage3.equals(""))||(finalizeYN.equals("Y"))){%>disabled<%}%>>
					<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------
					<%
						array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Third");
							for(int i=0;i<array_list.size();i+=inc) {
								sel_yn	= "";
								if(ca_comp_in_del_stage3.equals((String)array_list.get(i))){
									sel_yn = "selected";
								}
									out.println("<option value=\""+(String)array_list.get(i)+"\" "+sel_yn+">"+(String) array_list.get(i+incArr)+"</option>");
								}
						%>
					</select>
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						document.forms[0].complns_3rd_stage_labour_code.value="<%=checkForNull((String) hashMap.get("complns_3rd_stage_labour_code"))%>";
						</script>
					<%}%></td>
					<%}%>
					<td class='label'  width='25%'  ><%if(isModifyLongShortDescAppl){%><fmt:message key="eMP.OperativeComplications.label" bundle="${mp_labels}"/><%}else{%><fmt:message key="eMP.CompofDelivery.label" bundle="${mp_labels}"/><%}%></td>
			        <td class='fields' ><input type=text name="comple_ofdel_newborn" id="comple_ofdel_newborn" maxLength="75" size="40" onblur="compDelievary(this);" <%=dis_all_flds%> <%=dis_com_delivery%> <%if(!ca_comp_of_delivery.equals("")){%>disabled<%}%> value="<%=ca_comp_of_delivery_desc%>"><input type='button'  name='comple_of_button' id='comple_of_button' onClick="compDelievary(this);" value='?' class='button'  onClick='' <%=dis_all_flds%> <%=dis_com_delivery%> <%if(!ca_comp_of_delivery.equals("")){%>disabled<%}%>><input type='hidden' name="complications_delivery" id="complications_delivery" value='<%=ca_comp_of_delivery%>'>	
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						document.forms[0].comple_ofdel_newborn.value = "<%=q_compln_dely_desc%>";
					    document.forms[0].complications_delivery.value = "<%=checkForNull((String)hashMap.get("q_COMPLN_DELY_CODE"))%>";
						</script>
					<%}%>
					</td>		
				</tr>
				<tr>
				<%if(!isMPMandatoryFieldsNewborn){%>
					<td class='label'  ><%if(isModifyLongShortDescAppl){%><fmt:message key="eMP.IndicationsForOperativeDelivery.label" bundle="${mp_labels}"/><%}else{%><fmt:message key="eMP.DeliveryIndication.label" bundle="${mp_labels}"/><%}%></td>
			        <td class='fields'><!--Below line modified for this CRF HSA-CRF-0182 -->
					<input type=text maxLength="75" size="40" name="del_indica_newborn" id="del_indica_newborn" onblur="delIndiaction(this);" <%=dis_all_mother_dtls%> ><input type='button'  name='del_indica_button' id='del_indica_button' onClick="delIndiaction(this);" value='?' class='button'  onClick='' <%=dis_all_mother_dtls%> ><input type=hidden name="delivery_indication" id="delivery_indication" >
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						document.forms[0].delivery_indication.value = "<%=checkForNull((String )hashMap.get("q_delivery_indication"))%>";
						document.forms[0].del_indica_newborn.value = "<%=dely_ind_desc%>";
						</script>
					<%}%></td>
					<%}else{%>
						<td class='label'><fmt:message key="eMP.Complicationsin3rdStage.label" bundle="${mp_labels}"/></td>
					<td class='fields'><select name="complns_3rd_stage_labour_code" id="complns_3rd_stage_labour_code" <%=dis_all_flds%> <%=dis_com_stages%><%if(((!ca_comp_in_del_stage3.equals(""))||(finalizeYN.equals("Y"))) && !isMPMandatoryFieldsNewborn){%>disabled<%}%>>
					<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ------
					<%
						array_list.clear();
						array_list = eMP.NewbornDetails.getComplnsLabourCodeDesc(con,p,"Third");
							for(int i=0;i<array_list.size();i+=inc) {
								sel_yn	= "";
								if(ca_comp_in_del_stage3.equals((String)array_list.get(i))){
									sel_yn = "selected";
								}
									out.println("<option value=\""+(String)array_list.get(i)+"\" "+sel_yn+">"+(String) array_list.get(i+incArr)+"</option>");
								}
						%>
					</select>
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						document.forms[0].complns_3rd_stage_labour_code.value="<%=checkForNull((String) hashMap.get("complns_3rd_stage_labour_code"))%>";
						</script>
					<%}%>
					<%if(isMPMandatoryFieldsNewborn){%>
					<img align='center' id = 'complns_3rd_stage_labour_code_img' src='../../eCommon/images/mandatory.gif' style='<%=mandate_third_newbornValue%>'></img> 
					<%}%>
					</td>
						<%}%>
					<td class='label'    ><fmt:message key="eMP.ProcedureClassification.label" bundle="${mp_labels}"/></td>
			        <td class='fields'><!--Below line modified for this CRF HSA-CRF-0182 -->
					<input type="text" name="proc_class_desc" id="proc_class_desc" maxLength="75" size="40" onblur='chkprocclass();' <%=dis_all_mother_dtls%> value="<%=ca_proc_classification_desc%>" <%if(!ca_proc_classification.equals("")){%>disabled<%}%>><input type='button'  name='proc_id' id='proc_id' value='?' class='button' onClick='procClass(proc_id,proc_class_desc);' onKeyPress='procClass(proc_id,proc_class_desc);' <%=dis_all_mother_dtls%> <%if(!ca_proc_classification_desc.equals("")){%>disabled<%}%>>
					<input type="hidden" name="proc_class_code" id="proc_class_code" value="<%=ca_proc_classification%>">
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
							document.forms[0].proc_class_code.value = "<%=checkForNull((String)hashMap.get("q_proc_class_code"))%>";
							document.forms[0].proc_class_desc.value = "<%=q_proc_class_desc%>";
						</script>
					<%}%>
					</td></tr>				
			    <tr class='label'>
					<td class='label'    ><fmt:message key="eMP.VaginalDeliveryType.label" bundle="${mp_labels}"/></td>
			        <td  class='fields'><input type="text" name="vaginal_del_type_desc" id="vaginal_del_type_desc" maxLength="75" size="40" onblur='chkvagclass();' <%=dis_all_mother_dtls%> value="<%=ca_vaginal_delivery_type_desc%>" <%if(!ca_vaginal_delivery_type.equals("")){%>disabled<%}%>><input type='button' name='vaginal_del_type_search' id='vaginal_del_type_search' value='?' class='button' onClick='vagClass(vaginal_del_type_search, vaginal_del_type_desc);' onkeypress='vagClass(vaginal_del_type_search, vaginal_del_type_desc);' <%=dis_all_mother_dtls%> <%if(!ca_vaginal_delivery_type.equals("")){%>disabled<%}%>><input type='hidden' name="vaginal_del_type_code" id="vaginal_del_type_code" value='<%=ca_vaginal_delivery_type%>'>
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
					<script>
					document.forms[0].vaginal_del_type_code.value = "<%=checkForNull((String) hashMap.get("q_vaginal_del_type_code"))%>";
					document.forms[0].vaginal_del_type_desc.value = "<%=q_vaginal_dely_type_desc%>";
					</script>
					<%}%>
					</td>
					<td class='label'  width='25%'  ><%if(isModifyLongShortDescAppl){%><fmt:message key="eMP.DeliverySurgClass.label" bundle="${mp_labels}"/><%}else{%><fmt:message key="eMP.DeliverySurgicalClassification.label" bundle="${mp_labels}"/><%}%></td>
					<td class='fields'><input type="text" name="del_serv_desc" id="del_serv_desc" maxLength="75" size="40" onblur='chkdelsurgclass();' <%=dis_all_mother_dtls%> value="<%=ca_del_surg_classification_desc%>" <%if(!ca_del_surg_classification.equals("")){%>disabled<%}%>><input type='button'  name='del_serv_id' id='del_serv_id' value='?' class='button' onClick='delSurgClass(del_serv_id,del_serv_desc);' onKeyPress='delSurgClass(del_serv_id,del_serv_desc);' <%=dis_all_mother_dtls%> <%if(!ca_del_surg_classification.equals("")){%>disabled<%}%>><input type="hidden" name="del_serv_class" id="del_serv_class" value="<%=ca_del_surg_classification%>"></td>
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
					<script>
					document.forms[0].del_serv_class.value="<%=checkForNull((String) hashMap.get("q_del_serv_class"))%>";
					document.forms[0].del_serv_desc.value = "<%=q_dely_surg_class_desc%>";
					</script>
					<%}%>
				</tr>				
				<%if(!function_id.equals("REGISTER_NEWBORN"))
					{
						q_remarks=checkForNull((String) hashMap.get("q_remarks"));
					}%>
			    <tr><!--Below line modified for this CRF HSA-CRF-0182 -->
			        <td class='label'   valign=middle><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td colspan=3  >
					 <textarea onKeyPress='checkMaxLimit(this,100)'  onBlur='makeValidString(this);chkMotherLength(this,100); ' name="remarks"  rows="1" cols="90" <%=dis_all_mother_dtls%>  ><%=q_remarks%></textarea>
						
				  </td>
				</tr>
				<% if(captureAntenatalDtlsYN.equals("Y")) { 
						antenatal_care_yn=checkForNull((String)hashMap.get("antenatal_care_yn"));
						String antechecked="", antecarevalue="N";
						if(antenatal_care_yn.equals("Y")){
							antechecked="checked";
							antecarevalue="Y";
						}
					%>
					<table width="100%" cellpadding='1' cellspacing='0' border='0'>
					<tr>
					<input type = 'hidden' name = 'ant_born_locn_type' value = ''>
					<input type = 'hidden' name = 'ant_born_locn_code' value = ''><!--Below line modified for this CRF HSA-CRF-0182 -->
					<td class='label' width='20%'><fmt:message key="eMP.AnteNatalCare.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="eMP.given.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='6%'><input type="checkbox" <%=antechecked%> name="antenatal_care" value="<%=antecarevalue%>" onClick="callcareValidate('<%=captureAntenatalDtlsYN%>','onClickEvent')" <%=dis_all_mother_dtls%>></td>
					<td class='label' width='18%'><fmt:message key="eMP.AnteNatalCare.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="eMP.given.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td class='fields' width='50%'><select name="ate_born_where" id="ate_born_where" onchange="onchange_antenatal(this,'<%=call_function_id%>','<%=captureAntenatalDtlsYN%>');" style="width:135" <%=dis_all_mother_dtls%> >
					<option value='' >--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
					<option value='I' ><fmt:message key="eMP.inhospital.label" bundle="${mp_labels}"/></option>
					<option value='E'><fmt:message key="eMP.externalhospital.label" bundle="${mp_labels}"/></option>
					</select><img id='locngif' align=center src='../../eCommon/images/mandatory.gif' style='visibility:hidden;' name='locngif'></img> / <select name="ate_born_at_locn_type" id="ate_born_at_locn_type" style="width:141" onchange="populate_bornat(this,'<%=request.getContextPath()%>');" <%=dis_all_mother_dtls%>>
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<option value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<option value='E'><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value='D'><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
					<option value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					</select>&nbsp;<select name="ate_born_at_locn_code" id="ate_born_at_locn_code" <%=dis_all_mother_dtls%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<%	if(!function_id.equals("REGISTER_NEWBORN")){	 												ant_care_gvn_at=checkForNull((String)hashMap.get("ant_care_gvn_at"));
							ant_care_locn_code=checkForNull((String)hashMap.get("ant_care_locn_code"));
							ant_care_locn_type=checkForNull((String)hashMap.get("ant_care_locn_type"));
						if(!ant_care_locn_type.equals("")) {
							array_list.clear();
							array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,ant_care_locn_type,con,p);
							for(int i=0;i<array_list.size();i+=2) {
								if(checkForNull(ant_care_locn_code).equals((String) array_list.get(i)))
								{
									out.println("<option value=\""+(String)array_list.get(i)+"\"  selected>"+(String)array_list.get(i+1)+"</option>");
								} else {
									out.println("<option value=\""+(String)array_list.get(i)+"\">"+ (String)array_list.get(i+1)+"</option>");
								}
							} 
						 }
					}%>						             
					</select> <!--Above line modified for this CRF HSA-CRF-0182 -->
					</td>
					</tr>
					 </table>
					<% 	}else{%>
						<tr><td colspan=4></td></tr>
						<%}%>
				<%if(captureAntenatalDtlsYN.equals("Y"))  {
					if(!function_id.equals("REGISTER_NEWBORN")){%>													 
				<script>
							if('<%=antenatal_care_yn%>' == 'Y') {
								document.getElementById("locngif").style.visibility='visible';
								document.forms[0].antenatal_care.value = 'Y';
								document.forms[0].ate_born_where.value="<%=ant_care_gvn_at%>"; 					
								document.forms[0].ate_born_at_locn_type.value="<%=ant_care_locn_type%>";
								document.forms[0].ant_born_locn_code.value="<%=ant_care_locn_code%>";			
								document.forms[0].ant_born_locn_type.value="<%=ant_care_locn_type%>";
							} else {
								document.getElementById("locngif").style.visibility='hidden';
								document.forms[0].ate_born_where.disabled=true;
								document.forms[0].ate_born_where.value='';
								document.forms[0].ate_born_at_locn_type.disabled=true;
								document.forms[0].ate_born_at_locn_code.disabled=true;
								document.forms[0].ate_born_at_locn_type.value=''; 
								document.forms[0].antenatal_care.value = 'N';
							}
							if('<%=ant_care_gvn_at%>' == 'E') {								
								document.forms[0].ate_born_at_locn_type.disabled = true;
								document.forms[0].ate_born_at_locn_code.disabled = true;
							} 
							
					</script>
                  <%}else{%>
						<script>
							document.forms[0].ate_born_at_locn_type.disabled=true;
							document.forms[0].ate_born_at_locn_code.disabled=true;
							document.forms[0].ate_born_where.disabled=true;
					</script>
				  <%}
					}%>
				<%	if(isNewBornChngsAppl || isMotherAliveAppl){
							String mother_alive_yn	= checkForNull((String)hashMap.get("mother_alive_yn"),"Y");
					%>
					<table width="100%" cellpadding='1' cellspacing='0' border='0'>
						<tr >
						<td class='label' width='25%'><fmt:message key="eCA.Alive.label" bundle="${ca_labels}"/></td>
						<td class='fields' width='25%'>
							<select name="mother_alive_yn" id="mother_alive_yn">
								<option value="Y" <%if("Y".equals(mother_alive_yn)){%>selected<%}%>><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
								<option value="N" <%if("N".equals(mother_alive_yn)){%>selected<%}%>><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
							</select>
						</td>
						<td colspan=2></td>
						</tr>
					</table>
					<%}%>
				</table>
				</td></tr> 
			<tr><td>		
				<table id='father_tab' width="100%" cellpadding='1' cellspacing=0 border=0 >	
					<tr><td colspan='4' class='COLUMNHEADER'><span id='father_dtls_link' onClick='javascript:expandCollapse("FD")'><input type='button' class='button' value='-' name='father_button' id='father_button'></span>&nbsp;<fmt:message key="eMP.fatherdetails.label" bundle="${mp_labels}"/></td></tr>
				</table>
				<div>
			<tr><td>
			<div id='father_dtls'>
			<table width="100%" cellpadding='1' cellspacing=0 border=0 >	
			<tr>
			<td class='label' width='25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='fields'>
					<%
					   String patiddis="", q_father_patient_name_loc_lang="";
					if(function_id.equals("REGISTER_NEWBORN")){
						if(flag==1)
						{
							patiddis="disabled";
						}
					} else {
						 if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || (invoked_from.equals("servlet")))
							  patiddis="disabled";
						 else
							  patiddis="";						 q_father_patient_id			= checkForNull((String) hashMap.get("q_father_patient_id"));
						 q_father_name				= checkForNull((String) hashMap.get("q_father_name"));						
						 q_father_name_long				= checkForNull((String) hashMap.get("q_father_name_long"));						
						 q_father_name_long_loc_lang				= checkForNull((String) hashMap.get("q_father_name_long_loc_lang"));						
						 q_father_national_id_no	= checkForNull(((String) hashMap.get("q_FATHER_NATIONAL_ID_NO")));
						 q_father_oth_alt_id_type	=checkForNull((String)hashMap.get("q_FATHER_OTH_ALT_ID_TYPE"));
						 father_alt_id1_no_value=checkForNull((String) hashMap.get("q_father_alt_id1_no"));
						 father_alt_id2_no_value=checkForNull((String) hashMap.get("q_father_alt_id2_no"));
						 father_alt_id3_no_value=checkForNull((String) hashMap.get("q_father_alt_id3_no"));
						 father_alt_id4_no_value=checkForNull((String) hashMap.get("q_father_alt_id4_no"));
						 q_FATHER_OTH_ALT_ID_NO=checkForNull((String) hashMap.get("q_FATHER_OTH_ALT_ID_NO"));
						 q_father_nationality_code=checkForNull((String)hashMap.get("q_FATHER_NATIONALITY_CODE")); 
						 q_father_nationality_desc=checkForNull((String)hashMap.get("q_father_nationality_desc")); 
                         q_race_code = checkForNull((String)hashMap.get("q_FATHER_ETHNIC_GROUP_CODE"));
                         q_race_desc = checkForNull((String)hashMap.get("q_father_ethnic_group_desc"));
						 q_father_religion_code = checkForNull((String)hashMap.get("q_FATHER_RELIGION_CODE")).trim();
						 q_father_ocpn_class_code = checkForNull((String)hashMap.get("q_FATHER_OCPN_CLASS_CODE")).trim();
						 q_father_remarks = checkForNull((String) hashMap.get("q_FATHER_REMARKS"));
						 q_finalized_yn = (String) hashMap.get("q_finalized_yn");
						 q_father_religion_desc = checkForNull((String) hashMap.get("q_father_religion_desc"));
						  q_father_patient_name_loc_lang				= checkForNull((String) hashMap.get("father_patient_name_loc_lang"));
					}%>
						<input class='upper' type="text" name="father_patient_id" id="father_patient_id"  maxlength="<%=patient_idlength%>" size='20' onblur="makeValidString(this); clearData(this);getNewBornRegnValues('pat_id')" onKeyPress="return CheckForSpecChars(event);" onclick="makeValidString(this);getNewBornRegnValues('pat_id')" value="<%=q_father_patient_id%>" <%=patiddis%>><input type='button' <%=patiddis%> class='button' value='?' name='pat_id_search' onClick="callPatSearch();"></td>
						<input type='hidden' name='father_age_flag' id='father_age_flag'>	
						<input type='hidden' name='father_patient_id_hd' id='father_patient_id_hd' value='<%=q_father_patient_id%>'>
						<td class='label'  ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
						<td colspan='1' class='fields'>
						<input type="text" name="father_patient_name" id="father_patient_name" disabled maxlength="90" size="50" value="<%=q_father_name%>" onBlur='makeMandatory(this,"FatherDtls");'>
						<input type="hidden" name="father_patient_long_name" id="father_patient_long_name" value="<%=q_father_name_long%>">			 	 
						<input type="hidden" name="father_patient_long_name_loc_lang" id="father_patient_long_name_loc_lang" value="<%=q_father_name_long_loc_lang%>">
						</td>
				</tr>
				<tr>
				<td colspan='4'>
				<table border='0'>
					<%if(!function_id.equals("REGISTER_NEWBORN")) {%>
						<jsp:include page="../../eMP/jsp/PatNamesComp.jsp" ><jsp:param name="flush" value="true" />						
							<jsp:param name="CalledFromFunction"  value="FatherDtls"/>
							<jsp:param name="populatenewBornDtls"  value="N"/>
							<jsp:param name="nb_father_name_mandatory_yn"  value='<%=nb_father_name_mandatory_yn%>'/>
							<jsp:param name="a_name_prefix"  value='<%=(String)hashMap.get("father_name_prefix")%>'/>
							<jsp:param name="a_name_suffix"  value='<%=(String)hashMap.get("father_name_suffix")%>'/>
							<jsp:param name="a_family_name"  value='<%=(String)hashMap.get("father_family_name")%>'/>
							<jsp:param name="a_first_name"  value='<%=(String)hashMap.get("father_first_name")%>'/>
							<jsp:param name="a_second_name"  value='<%=(String)hashMap.get("father_second_name")%>'/>
							<jsp:param name="a_third_name"  value='<%=(String)hashMap.get("father_third_name")%>'/>
							<jsp:param name="a_name_prefix_loc_lang"  value='<%=(String)hashMap.get("father_name_prefix_loc_lang")%>'/>
							<jsp:param name="a_first_name_loc_lang"  value='<%=(String)hashMap.get("father_first_name_loc_lang")%>'/>
							<jsp:param name="a_second_name_loc_lang"  value='<%=(String)hashMap.get("father_second_name_loc_lang")%>'/>
							<jsp:param name="a_third_name_loc_lang"  value='<%=(String)hashMap.get("father_third_name_loc_lang")%>'/>
							<jsp:param name="a_family_name_loc_lang"  value='<%=(String)hashMap.get("father_family_name_loc_lang")%>'/>
							<jsp:param name="a_name_suffix_loc_lang"  value='<%=(String)hashMap.get("father_name_suffix_loc_lang")%>'/>
							<jsp:param name="Name_Prefix_Accept_Yn"  value='<%=Name_Prefix_Accept_Yn%>'/>
							<jsp:param name="Name_Prefix_Reqd_Yn"  value='<%=Name_Prefix_Reqd_Yn%>'/>
							<jsp:param name="Name_Suffix_Accept_Yn"  value='<%=Name_Suffix_Accept_Yn%>'/>
							<jsp:param name="Name_Suffix_Reqd_Yn"  value='<%=Name_Suffix_Reqd_Yn%>'/>
							<jsp:param name="First_Name_Accept_Yn"  value='<%=First_Name_Accept_Yn%>'/>
							<jsp:param name="First_Name_Prompt"  value='<%=First_Name_Prompt%>'/>
							<jsp:param name="First_Name_Reqd_Yn"  value='<%=First_Name_Reqd_Yn%>'/>
							<jsp:param name="Second_Name_Accept_Yn"  value='<%=Second_Name_Accept_Yn%>'/>
							<jsp:param name="Second_Name_Prompt"  value='<%=Second_Name_Prompt%>'/>
							<jsp:param name="Third_Name_Accept_Yn"  value='<%=Third_Name_Accept_Yn%>'/>
							<jsp:param name="Third_Name_Prompt"  value='<%=Third_Name_Prompt%>'/>
							<jsp:param name="Family_Name_Accept_Yn"  value='<%=Family_Name_Accept_Yn%>'/>
							<jsp:param name="Family_Name_Prompt"  value='<%=Family_Name_Prompt%>'/>
							<jsp:param name="Second_Name_Reqd_Yn"  value='<%=Second_Name_Reqd_Yn%>'/>
							<jsp:param name="Third_Name_Reqd_Yn"  value='<%=Third_Name_Reqd_Yn%>'/>
							<jsp:param name="Family_Name_Reqd_Yn"  value='<%=Family_Name_Reqd_Yn%>'/>
							<jsp:param name="pat_name_as_multipart_yn"  value='<%=pat_name_as_multipart_yn%>'/>
							<jsp:param name="family_org_id_accept_yn"  value='<%=FAMILY_ORG_ID_ACCEPT_YN%>'/>
							<jsp:param name="Name_Suffix_Prompt"  value='<%=Name_Suffix_Prompt%>'/>
							<jsp:param name="Name_Prefix_Prompt"  value='<%=Name_Prefix_Prompt%>'/>
							<jsp:param name="Family_Name_Order"  value='<%=Family_Name_Order%>'/>
							<jsp:param name="First_Name_Order"  value='<%=First_Name_Order%>'/>
							<jsp:param name="Second_Name_Order"  value='<%=Second_Name_Order%>'/>
							<jsp:param name="Third_Name_Order"  value='<%=Third_Name_Order%>'/>
							<jsp:param name="first_name_length"  value='<%=first_name_length%>'/>
							<jsp:param name="second_name_length"  value='<%=second_name_length%>'/>
							<jsp:param name="third_name_length"  value='<%=third_name_length%>'/>
							<jsp:param name="family_name_length"  value='<%=family_name_length%>'/>
							<jsp:param name="family_name_loc_lang_prompt"  value='<%=family_name_loc_lang_prompt%>'/> 							
							<jsp:param name="name_suffix_loc_lang_prompt"  value='<%=name_suffix_loc_lang_prompt%>'/>
							<jsp:param name="first_name_loc_lang_prompt"  value='<%=first_name_loc_lang_prompt%>'/>
							<jsp:param name="second_name_loc_lang_prompt"  value='<%=second_name_loc_lang_prompt%>'/>
							<jsp:param name="third_name_loc_lang_prompt"  value='<%=third_name_loc_lang_prompt%>'/>
							<jsp:param name="name_prefix_loc_lang_prompt"  value='<%=name_prefix_loc_lang_prompt%>'/>
							<jsp:param name="names_in_oth_lang_yn"  value='<%=names_in_oth_lang_yn%>'/>
							<jsp:param name="function_id"  value='<%=function_id%>'/>
							<jsp:param name="no_marital_status"  value='<%=no_marital_status%>'/>
						</jsp:include> 
					<%} else {%>
						<jsp:include page="../../eMP/jsp/PatNamesComp.jsp" flush="true">						
							<jsp:param name="CalledFromFunction"  value="FatherDtls"/>
							<jsp:param name="populatenewBornDtls"  value="Y"/>
							<jsp:param name="nb_father_name_mandatory_yn"  value='<%=nb_father_name_mandatory_yn%>'/>
							<jsp:param name="Name_Prefix_Accept_Yn"  value='<%=Name_Prefix_Accept_Yn%>'/>
							<jsp:param name="Name_Prefix_Reqd_Yn"  value='<%=Name_Prefix_Reqd_Yn%>'/>
							<jsp:param name="Name_Suffix_Accept_Yn"  value='<%=Name_Suffix_Accept_Yn%>'/>
							<jsp:param name="Name_Suffix_Reqd_Yn"  value='<%=Name_Suffix_Reqd_Yn%>'/>
							<jsp:param name="First_Name_Accept_Yn"  value='<%=First_Name_Accept_Yn%>'/>
							<jsp:param name="First_Name_Prompt"  value='<%=First_Name_Prompt%>'/>
							<jsp:param name="First_Name_Reqd_Yn"  value='<%=First_Name_Reqd_Yn%>'/>
							<jsp:param name="Second_Name_Accept_Yn"  value='<%=Second_Name_Accept_Yn%>'/>
							<jsp:param name="Second_Name_Prompt"  value='<%=Second_Name_Prompt%>'/>
							<jsp:param name="Third_Name_Accept_Yn"  value='<%=Third_Name_Accept_Yn%>'/>
							<jsp:param name="Third_Name_Prompt"  value='<%=Third_Name_Prompt%>'/>
							<jsp:param name="Family_Name_Accept_Yn"  value='<%=Family_Name_Accept_Yn%>'/>
							<jsp:param name="Family_Name_Prompt"  value='<%=Family_Name_Prompt%>'/>
							<jsp:param name="Second_Name_Reqd_Yn"  value='<%=Second_Name_Reqd_Yn%>'/>
							<jsp:param name="Third_Name_Reqd_Yn"  value='<%=Third_Name_Reqd_Yn%>'/>
							<jsp:param name="Family_Name_Reqd_Yn"  value='<%=Family_Name_Reqd_Yn%>'/>
							<jsp:param name="pat_name_as_multipart_yn"  value='<%=pat_name_as_multipart_yn%>'/>
							<jsp:param name="family_org_id_accept_yn"  value='<%=FAMILY_ORG_ID_ACCEPT_YN%>'/>
							<jsp:param name="Name_Suffix_Prompt"  value='<%=Name_Suffix_Prompt%>'/>
							<jsp:param name="Name_Prefix_Prompt"  value='<%=Name_Prefix_Prompt%>'/>
							<jsp:param name="Family_Name_Order"  value='<%=Family_Name_Order%>'/>
							<jsp:param name="First_Name_Order"  value='<%=First_Name_Order%>'/>
							<jsp:param name="Second_Name_Order"  value='<%=Second_Name_Order%>'/>
							<jsp:param name="Third_Name_Order"  value='<%=Third_Name_Order%>'/>
							<jsp:param name="first_name_length"  value='<%=first_name_length%>'/>
							<jsp:param name="second_name_length"  value='<%=second_name_length%>'/>
							<jsp:param name="third_name_length"  value='<%=third_name_length%>'/>
							<jsp:param name="family_name_length"  value='<%=family_name_length%>'/>
							<jsp:param name="family_name_loc_lang_prompt"  value='<%=family_name_loc_lang_prompt%>'/>							
							<jsp:param name="name_suffix_loc_lang_prompt"  value='<%=name_suffix_loc_lang_prompt%>'/>
							<jsp:param name="first_name_loc_lang_prompt"  value='<%=first_name_loc_lang_prompt%>'/>
							<jsp:param name="second_name_loc_lang_prompt"  value='<%=second_name_loc_lang_prompt%>'/>
							<jsp:param name="third_name_loc_lang_prompt"  value='<%=third_name_loc_lang_prompt%>'/>
							<jsp:param name="name_prefix_loc_lang_prompt"  value='<%=name_prefix_loc_lang_prompt%>'/>
							<jsp:param name="names_in_oth_lang_yn"  value='<%=names_in_oth_lang_yn%>'/>
							<jsp:param name="function_id"  value='<%=function_id%>'/>
							<jsp:param name="no_marital_status"  value='<%=no_marital_status%>'/>
						</jsp:include>
					<%}%>
				</table>
				</td>
				</tr>
				<tr>					
			<% 
				String nat_on_blurfn_st = "", nat_id_onKeyPress="";
				if(accept_national_id_no_yn.equals("Y")){
				if(!cd3.equals("")){					
					nat_on_blurfn_st = "makeValidString(this);validateNationality(this,'','','"+nat_invoke_routine+"','"+nat_data_source_id+"','"+nat_id_check_digit_id+"','"+nat_id_chk_len+"','N')";
					if(nat_id_accept_alphanumeric_yn.equals("Y"))
					{
						nat_id_onKeyPress = "CheckForAlphaCharsNatID(event);";
					}
					else
					{
						if(nat_id_check_digit_id.equals("M11"))
							nat_id_onKeyPress = "CheckForCharsNatID(event);";
						else
							nat_id_onKeyPress = "allowValidNumber(this,event,2, 0);";
					}				
					%>
					<td class='label' ><%=cd3%></td>
					<input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value="<%=cd3%>">
					<td class='fields'>
					<input type='text' name='National_id' id='National_id' maxlength='<%=cd4%>' onkeypress="return <%=nat_id_onKeyPress%>"  onblur="<%=nat_on_blurfn_st%>" value="<%=q_father_national_id_no%>" <%=patiddis%>></td>
					<td class='label' colspan='2'>&nbsp;</td>
					<% }}
					int span=2;
					if(cd3.equals("")){%>
							 <td colspan='4'></td> 					
					<% span=1;
					}
						String otheraltidnewborn="";%>
				</tr>		
				<tr>				
				<%
					if(function_id.equals("REGISTER_NEWBORN")){
						  if (flag==1) { 
							otheraltidnewborn="disabled";
						  }
				}
				else
				{
					if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || (invoked_from.equals("servlet")))
						otheraltidnewborn="disabled";
					else
						otheraltidnewborn="";
				}
				if(!alt_id1_type_desc.equals("")) {
					%>
					
						<td class= 'label' align = 'right'><%=alt_id1_type_desc%></td>
						<td  class='fields' colspan='1'>
						<input type='text' name='father_alt_id1_no' id='father_alt_id1_no'  onBlur='makeValidString(this);' maxlength='<%=alt_id1_length%>' size='<%=alt_id1_length%>' value="<%=father_alt_id1_no_value%>" <%=otheraltidnewborn%>></td>
					
					<%
				} 
					if(accept_oth_alt_id_yn.equals("Y")) {%>	
						<td class='label'  ><fmt:message key="Common.otheraltid.label" bundle="${common_labels}"/> </td>
						<td  colspan='<%=span%>' class='fields'>
						<select name='cboOtherAltID' id='cboOtherAltID' onChange='enableOtherAlt(this)' <%=patiddis%>>
						<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
						<%
								array_list.clear();
								array_list = eMP.NewbornDetails.getAlternateIDTypeDesc(con,p);
								for(int i=0;i<array_list.size();i+=2) {
								out.println("<option value=\""+(String)array_list.get(i)+"\">"+(String) array_list.get(i+1)+"</option>");
								} 
						%></select>
							<script>
								document.forms[0].cboOtherAltID.value="<%=q_father_oth_alt_id_type%>"
							</script>
						<%						
					  if(function_id.equals("REGISTER_NEWBORN")){					  
						  if (flag==1) { 
							otheraltidnewborn="disabled";
						  }
						}
						  else
						  {
							if (q_FATHER_OTH_ALT_ID_NO.equals("") || (invoked_from.equals("details_page")&&regnStatus.equals("F")) || invoked_from.equals("servlet")) 
								otheraltidnewborn="disabled";
						  }
					   %>
						<input type='text' name='txtOtherAltID' id='txtOtherAltID' maxlength=20 size=20 value="<%=q_FATHER_OTH_ALT_ID_NO%>" <%=otheraltidnewborn%> ></td>
						<%}else{%>
							<td colspan=2></td>
						<%}%>
						
				</tr>
					<%
                     if(function_id.equals("REGISTER_NEWBORN")){
						 if (flag==1) { 
							otheraltidnewborn="disabled";
						  }
					} else {
						if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || (invoked_from.equals("servlet")))
							otheraltidnewborn="disabled";
					    else
						    otheraltidnewborn="";							  
					}
					%>
					<tr>
			      <% if(!alt_id2_type_desc.equals("")) {%>
					
						<td class= 'label' align = 'right'><%=alt_id2_type_desc%></td>
						<td  class='fields' colspan='1'>
						<input type='text' name='father_alt_id2_no' id='father_alt_id2_no'  onBlur='makeValidString(this);' maxlength='<%=alt_id2_length%>' size='<%=alt_id2_length%>' value="<%=father_alt_id2_no_value%>" <%=otheraltidnewborn%>></td>
					
					<%} if(!alt_id3_type_desc.equals("")) {%>
					<td class= 'label' align = 'right'><%=alt_id3_type_desc%></td>
						<td  class='fields' colspan='1'>
						<input type='text' name='father_alt_id3_no' id='father_alt_id3_no'  onBlur='makeValidString(this);' maxlength='<%=alt_id3_length%>' size='<%=alt_id3_length%>' value="<%=father_alt_id3_no_value%>" <%=otheraltidnewborn%>></td>
				<%} %>
			     </tr>
			     <tr>
			      <% if(!alt_id4_type_desc.equals("")) {%>
					
						<td class= 'label' align = 'right'><%=alt_id4_type_desc%></td>
						<td  class='fields' colspan='1'>
						<input type='text' name='father_alt_id4_no' id='father_alt_id4_no'  onBlur='makeValidString(this);' maxlength='<%=alt_id4_length%>' size='<%=alt_id4_length%>' value="<%=father_alt_id4_no_value%>" <%=otheraltidnewborn%>></td>
					
					<%}%>
				<tr>
					<td  class='label'  ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
					<td   class='fields' >
					
						<input type='text' <%=otheraltidnewborn%>  name='cboNationality_desc' onblur="get_Nationality(this);" value="<%=q_father_nationality_desc%>"><input class='button' type='button' name='cboNationality_button' id='cboNationality_button' onclick="get_Nationality(this);" value='?' <%=otheraltidnewborn%> >
						<input type='hidden' name='cboNationality' id='cboNationality' value="<%=q_father_nationality_code%>">
											
					 <img id='natImg' align=center src='../../eCommon/images/mandatory.gif' style="visibility:hidden">		
					</td>
					<td class='label'><fmt:message key="Common.race.label" bundle="${common_labels}"/> </td>
					<td class='fields'><input type='text' name='cboEthnicGroupDesc' id='cboEthnicGroupDesc' size='20' maxlength='20' value="<%=q_race_desc%>" <%=otheraltidnewborn%> onblur='if(this.value!=""){searchRace(cboEthnicGroup,cboEthnicGroupDesc,"<%=localeName%>");}else{clearfields();}'><input type='button' name='cboEthnicGroupBtn' id='cboEthnicGroupBtn' value='?' class='button' <%=otheraltidnewborn%> onclick='searchRace(this,cboEthnicGroupDesc,"<%=localeName%>")'>
					<input type='hidden' name='cboEthnicGroup' id='cboEthnicGroup' value="<%=q_race_code%>"><img id='racImg' align=center src='../../eCommon/images/mandatory.gif' style="<%=race_style%>">					
					</td>	
				</tr>
				<tr>
					<td class='label'  ><fmt:message key="eMP.GovtEmployee.label" bundle="${mp_labels}"/> </td>
					<%
						String q_FATHER_GOVE_EMPLOYEE_YN="N", q_father_gove_checked="";
						if(function_id.equals("REGISTER_NEWBORN")){
						if (flag==1) { 
					    	otheraltidnewborn="disabled";
							if(q_father_govemp.equals("Y"))
						    {
								q_FATHER_GOVE_EMPLOYEE_YN="Y";
								q_father_gove_checked="checked";
							}
						  }
					   } else
						  {
						    if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || invoked_from.equals("servlet"))
								otheraltidnewborn="disabled";
					        else
						        otheraltidnewborn="";
							
							if(checkForNull(((String) hashMap.get("q_FATHER_GOVE_EMPLOYEE_YN"))).equals("Y")) {
								q_FATHER_GOVE_EMPLOYEE_YN="Y";
								q_father_gove_checked="checked";
							}
							
						  }%>
							<td class='fields'><input type='checkbox' name="fthGovtEmpl" id="fthGovtEmpl" <%=otheraltidnewborn%> value='<%=q_FATHER_GOVE_EMPLOYEE_YN%>'  <%=q_father_gove_checked%>></td>
						<td class='label' ><fmt:message key="Common.religion.label" bundle="${common_labels}"/></td>
					
						<td   class='fields'><select name='cboReligion' id='cboReligion' <%=otheraltidnewborn%>>
						
							<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
						    <%if(!q_father_religion_code.equals("") && !otheraltidnewborn.equals("")){ %>
							<option value="<%=q_father_religion_code%>" selected><%=q_father_religion_desc%></option>
							<%}else{
							array_list.clear();
							array_list = eMP.NewbornDetails.getReligionCodeShortDesc(con,p);
							for(int i=0;i<array_list.size();i+=2) {
									out.println("<option value=\""+(String)array_list.get(i)+"\">"+(String) array_list.get(i+1)+"</option>");
							  }
							}%></select></td>
						<script>
						document.forms[0].cboReligion.value='<%=q_father_religion_code%>';
						</script>
				</tr>
				<tr>
					<td class='label'    ><fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/></td>
					<td class='fields'>
						<select name='cboOccupationClass' id='cboOccupationClass'  onchange='enableDesc(this);getNewBornRegnValues(this.name)' <%=otheraltidnewborn%>>
							<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							<%
								array_list.clear();
								array_list = eMP.NewbornDetails.getOccupationClassCodeShortDesc(con,p);
								for(int i=0;i<array_list.size();i+=2) {
									out.println("<option value=\""+(String)array_list.get(i)+"\">"+(String) array_list.get(i+1)+"</option>");
								}
							%>		
					 </select></td>
					<script>
						document.forms[0].cboOccupationClass.value="<%=q_father_ocpn_class_code%>";
					</script>
					<% 
					if(!function_id.equals("REGISTER_NEWBORN")){
						fathr_ocpn_code = checkForNull((String)hashMap.get("q_FATHER_OCPN_CODE"));
						q_father_ocpn_desc = checkForNull((String) hashMap.get("q_FATHER_OCPN_DESC"));
				    } 					
					%>
					<td class='label' ><fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/>  </td>
					<td class='fields'  >
					<select name='cboOccupation' id='cboOccupation' onchange="disOccpDesc()" <%=otheraltidnewborn%>>
					<option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
					
					<%
							if(!q_father_ocpn_class_code.equals("")) {
								array_list.clear();
								array_list = eMP.NewbornDetails.getOccupationCodeShortDesc(checkForNull((String) hashMap.get("q_FATHER_OCPN_CLASS_CODE")),con,p);
							
								for(int i=0;i<array_list.size();i+=2) {
									out.println("<option value=\""+(String) array_list.get(i)+"\" >"+(String)array_list.get(i+1)+"</option>");								
								}
							}					
					%>
					</select>
						<script>
							document.forms[0].cboOccupation.value="<%=fathr_ocpn_code%>";
						</script>
                    <%
					String q_father_ocpn_descdis=""; 
					if(function_id.equals("REGISTER_NEWBORN")){
					 	  q_father_ocpn_descdis="disabled";
					 }
					 else
					 {
						 if((invoked_from.equals("details_page")&&regnStatus.equals("F")) || invoked_from.equals("servlet"))
							q_father_ocpn_descdis="disabled";
						 else
						 {
							 if(!q_father_ocpn_desc.equals(""))
							 {
								 q_father_ocpn_descdis = "";
							 }
							 else
								 q_father_ocpn_descdis = "disabled";
						 }
					 }
					%>
					<input type=text name='Occupation_Desc' id='Occupation_Desc' size='<%=maxsize%>' maxlength='<%=maximumLength%>' value="<%=q_father_ocpn_desc%>" 
          			<%=q_father_ocpn_descdis%>></td>
				</tr>
				<tr>				
				<td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </td>
					<td colspan='3' class='fields'><textarea onKeyPress='checkMaxLimit(this,100)' value = "" onBlur='makeValidString(this);chkFatherLength(this,100);' name="fatherRemarks"  rows="1" cols="90" <%=dis_all_flds%>><%=q_father_remarks%></textarea></td>
									
				</tr>				
				</table>
				</div>
			</td></tr>
			<script>
					if('<%=dis_all_flds%>'=='disabled') {
				
						if(document.getElementById('first_name'))
							document.getElementById('first_name').disabled = true;
						if(document.getElementById('bf'))
							document.getElementById('bf').disabled = true;
						if(document.getElementById('second_name'))
							document.getElementById('second_name').disabled = true;
						if(document.getElementById('bs'))
							document.getElementById('bs').disabled = true;
						if(document.getElementById('third_name'))
							document.getElementById('third_name').disabled = true;
						if(document.getElementById('bt'))
							document.getElementById('bt').disabled = true;
						if(document.getElementById('family_name'))
							document.getElementById('family_name').disabled = true;
						if(document.getElementById('bfam'))
							document.getElementById('bfam').disabled = true;
						if(document.getElementById('name_prefix'))
							document.getElementById('name_prefix').disabled = true;
						if(document.getElementById('name_suffix'))
							document.getElementById('name_suffix').disabled = true;
						if(document.getElementById('first_name_oth_lang'))
							document.getElementById('first_name_oth_lang').disabled = true;
						if(document.getElementById('bfo'))
							document.getElementById('bfo').disabled = true;
						if(document.getElementById('second_name_oth_lang'))
							document.getElementById('second_name_oth_lang').disabled = true;
						if(document.getElementById('bso'))
							document.getElementById('bso').disabled = true;
						if(document.getElementById('third_name_oth_lang'))
							document.getElementById('third_name_oth_lang').disabled = true;
					    if(document.getElementById('bto'))		
							document.getElementById('bto').disabled = true;
						if(document.getElementById('family_name_oth_lang'))
							document.getElementById('family_name_oth_lang').disabled = true;
						if(document.getElementById('bfamo'))
							document.getElementById('bfamo').disabled = true;
						if(document.getElementById('name_prefix_oth_lang'))
							document.getElementById('name_prefix_oth_lang').disabled = true;
						if(document.getElementById('name_suffix_oth_lang'))
							document.getElementById('name_suffix_oth_lang').disabled = true;
						if(document.getElementById('father_patient_name'))
							document.getElementById('father_patient_name').disabled = true;
					}  
			</script>			
			<%
				if(!(invoked_from.equals("details_page")&&regnStatus.equals("F")))	
					dis_all_flds = ""; 				
				
				if(invoked_from.equals("servlet"))
					function_id = new_function_id; 			
			%>
			<tr><td>
			<table id='newborngrp_tab' width="100%" cellpadding=1 cellspacing=0 border=0 >
				<%if(ip_install_yn.equals("N") || !called_function.equals("IP")) { %>
						<tr><td class='label'  colspan='4'></td></tr>
				<% } %>
				<tr> 
					<td colspan='4' class='COLUMNHEADER'><span id = 'newborn_dtls_link' onClick='javascript:expandCollapse("ND")'><input type='button' class='button' value='-' name='nb_button' id='nb_button'></span>&nbsp;<fmt:message key="eMP.newborndetails.label" bundle="${mp_labels}"/></td>
				</tr>
			</table>
			<tr><td>
			<div id = 'newborn_dtls'>
				<table width="100%" cellpadding=1 cellspacing=0 border=0 >
				<%
					if(function_id.equals("MAINTAIN_BIRTH")) {
						q_nb_patient_name = checkForNull((String) hashMap.get("nb_patient_name"));	
					}
				%>
				<tr>
					<td class='label'><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td colspan='3' class='fields'>
					<input type="text" name="nb_patient_name" id="nb_patient_name" disabled maxlength="90" size="50" value='<%=q_nb_patient_name%>'>
					<input type="hidden" name="nb_patient_name_long" id="nb_patient_name_long" value=''>
					<input type="hidden" name="nb_patient_name_long_local_lang" id="nb_patient_name_long_local_lang" value=''>
						
					</td>
				</tr>
				<tr>
				<td colspan='4'>
				<table border='0'>
					<%if(!function_id.equals("REGISTER_NEWBORN")) { %>
						<jsp:include page="../../eMP/jsp/PatNamesComp.jsp" ><jsp:param name="flush" value="true" />						
							<jsp:param name="CalledFromFunction"  value="NewbornDtls"/>						
							<jsp:param name="populatenewBornDtls"  value="Y"/>						
							<jsp:param name="a_name_prefix"  value='<%=(String)hashMap.get("nb_name_prefix")%>'/>
							<jsp:param name="a_name_suffix"  value='<%=(String)hashMap.get("nb_name_suffix")%>'/>
							<jsp:param name="a_family_name"  value='<%=(String)hashMap.get("nb_family_name")%>'/>
							<jsp:param name="a_first_name"  value='<%=(String)hashMap.get("nb_first_name")%>'/>
							<jsp:param name="a_second_name"  value='<%=(String)hashMap.get("nb_second_name")%>'/>
							<jsp:param name="a_third_name"  value='<%=(String)hashMap.get("nb_third_name")%>'/>
							<jsp:param name="a_name_prefix_loc_lang"  value='<%=(String)hashMap.get("nb_name_prefix_loc_lang")%>'/>
							<jsp:param name="a_first_name_loc_lang"  value='<%=(String)hashMap.get("nb_first_name_loc_lang")%>'/>
							<jsp:param name="a_second_name_loc_lang"  value='<%=(String)hashMap.get("nb_second_name_loc_lang")%>'/>
							<jsp:param name="a_third_name_loc_lang"  value='<%=(String)hashMap.get("nb_third_name_loc_lang")%>'/>
							<jsp:param name="a_family_name_loc_lang"  value='<%=(String)hashMap.get("nb_family_name_loc_lang")%>'/>
							<jsp:param name="a_name_suffix_loc_lang"  value='<%=(String)hashMap.get("nb_name_suffix_loc_lang")%>'/> 
							
							<jsp:param name="Name_Prefix_Accept_Yn"  value='<%=Name_Prefix_Accept_Yn%>'/>
							<jsp:param name="Name_Prefix_Reqd_Yn"  value='<%=Name_Prefix_Reqd_Yn%>'/>
							<jsp:param name="Name_Suffix_Accept_Yn"  value='<%=Name_Suffix_Accept_Yn%>'/>
							<jsp:param name="Name_Suffix_Reqd_Yn"  value='<%=Name_Suffix_Reqd_Yn%>'/>
							<jsp:param name="First_Name_Accept_Yn"  value='<%=First_Name_Accept_Yn%>'/>
							<jsp:param name="First_Name_Prompt"  value='<%=First_Name_Prompt%>'/>
							<jsp:param name="First_Name_Reqd_Yn"  value='<%=First_Name_Reqd_Yn%>'/>
							<jsp:param name="Second_Name_Accept_Yn"  value='<%=Second_Name_Accept_Yn%>'/>
							<jsp:param name="Second_Name_Prompt"  value='<%=Second_Name_Prompt%>'/>
							<jsp:param name="Third_Name_Accept_Yn"  value='<%=Third_Name_Accept_Yn%>'/>
							<jsp:param name="Third_Name_Prompt"  value='<%=Third_Name_Prompt%>'/>
							<jsp:param name="Family_Name_Accept_Yn"  value='<%=Family_Name_Accept_Yn%>'/>
							<jsp:param name="Family_Name_Prompt"  value='<%=Family_Name_Prompt%>'/>
							<jsp:param name="Second_Name_Reqd_Yn"  value='<%=Second_Name_Reqd_Yn%>'/>
							<jsp:param name="Third_Name_Reqd_Yn"  value='<%=Third_Name_Reqd_Yn%>'/>
							<jsp:param name="Family_Name_Reqd_Yn"  value='<%=Family_Name_Reqd_Yn%>'/>
							<jsp:param name="pat_name_as_multipart_yn"  value='<%=pat_name_as_multipart_yn%>'/>
							<jsp:param name="family_org_id_accept_yn"  value='<%=FAMILY_ORG_ID_ACCEPT_YN%>'/>
							<jsp:param name="Name_Suffix_Prompt"  value='<%=Name_Suffix_Prompt%>'/>
							<jsp:param name="Name_Prefix_Prompt"  value='<%=Name_Prefix_Prompt%>'/>
							<jsp:param name="Family_Name_Order"  value='<%=Family_Name_Order%>'/>
							<jsp:param name="First_Name_Order"  value='<%=First_Name_Order%>'/>
							<jsp:param name="Second_Name_Order"  value='<%=Second_Name_Order%>'/>
							<jsp:param name="Third_Name_Order"  value='<%=Third_Name_Order%>'/>
							<jsp:param name="first_name_length"  value='<%=first_name_length%>'/>
							<jsp:param name="second_name_length"  value='<%=second_name_length%>'/>
							<jsp:param name="third_name_length"  value='<%=third_name_length%>'/>
							<jsp:param name="family_name_length"  value='<%=family_name_length%>'/>
							<jsp:param name="family_name_loc_lang_prompt"  value='<%=family_name_loc_lang_prompt%>'/>						
							<jsp:param name="name_suffix_loc_lang_prompt"  value='<%=name_suffix_loc_lang_prompt%>'/>
							<jsp:param name="first_name_loc_lang_prompt"  value='<%=first_name_loc_lang_prompt%>'/>
							<jsp:param name="second_name_loc_lang_prompt"  value='<%=second_name_loc_lang_prompt%>'/>
							<jsp:param name="third_name_loc_lang_prompt"  value='<%=third_name_loc_lang_prompt%>'/>
							<jsp:param name="name_prefix_loc_lang_prompt"  value='<%=name_prefix_loc_lang_prompt%>'/>
							<jsp:param name="names_in_oth_lang_yn"  value='<%=names_in_oth_lang_yn%>'/>
					</jsp:include>				
				    <% }else{%>
						<jsp:include page="../../eMP/jsp/PatNamesComp.jsp" ><jsp:param name="flush" value="true" />						
							<jsp:param name="CalledFromFunction"  value="NewbornDtls"/>
							<jsp:param name="mother_patient_id"  value="<%=mother_patient_id%>"/>
							<jsp:param name="populatenewBornDtls"  value="N"/>
							<jsp:param name="Name_Prefix_Accept_Yn"  value='<%=Name_Prefix_Accept_Yn%>'/>
							<jsp:param name="Name_Prefix_Reqd_Yn"  value='<%=Name_Prefix_Reqd_Yn%>'/>
							<jsp:param name="Name_Suffix_Accept_Yn"  value='<%=Name_Suffix_Accept_Yn%>'/>
							<jsp:param name="Name_Suffix_Reqd_Yn"  value='<%=Name_Suffix_Reqd_Yn%>'/>
							<jsp:param name="First_Name_Accept_Yn"  value='<%=First_Name_Accept_Yn%>'/>
							<jsp:param name="First_Name_Prompt"  value='<%=First_Name_Prompt%>'/>
							<jsp:param name="First_Name_Reqd_Yn"  value='<%=First_Name_Reqd_Yn%>'/>
							<jsp:param name="Second_Name_Accept_Yn"  value='<%=Second_Name_Accept_Yn%>'/>
							<jsp:param name="Second_Name_Prompt"  value='<%=Second_Name_Prompt%>'/>
							<jsp:param name="Third_Name_Accept_Yn"  value='<%=Third_Name_Accept_Yn%>'/>
							<jsp:param name="Third_Name_Prompt"  value='<%=Third_Name_Prompt%>'/>
							<jsp:param name="Family_Name_Accept_Yn"  value='<%=Family_Name_Accept_Yn%>'/>
							<jsp:param name="Family_Name_Prompt"  value='<%=Family_Name_Prompt%>'/>
							<jsp:param name="Second_Name_Reqd_Yn"  value='<%=Second_Name_Reqd_Yn%>'/>
							<jsp:param name="Third_Name_Reqd_Yn"  value='<%=Third_Name_Reqd_Yn%>'/>
							<jsp:param name="Family_Name_Reqd_Yn"  value='<%=Family_Name_Reqd_Yn%>'/>
							<jsp:param name="pat_name_as_multipart_yn"  value='<%=pat_name_as_multipart_yn%>'/>
							<jsp:param name="family_org_id_accept_yn"  value='<%=FAMILY_ORG_ID_ACCEPT_YN%>'/>
							<jsp:param name="Name_Suffix_Prompt"  value='<%=Name_Suffix_Prompt%>'/>
							<jsp:param name="Name_Prefix_Prompt"  value='<%=Name_Prefix_Prompt%>'/>
							<jsp:param name="Family_Name_Order"  value='<%=Family_Name_Order%>'/>
							<jsp:param name="First_Name_Order"  value='<%=First_Name_Order%>'/>
							<jsp:param name="Second_Name_Order"  value='<%=Second_Name_Order%>'/>
							<jsp:param name="Third_Name_Order"  value='<%=Third_Name_Order%>'/>
							<jsp:param name="first_name_length"  value='<%=first_name_length%>'/>
							<jsp:param name="second_name_length"  value='<%=second_name_length%>'/>
							<jsp:param name="third_name_length"  value='<%=third_name_length%>'/>
							<jsp:param name="family_name_length"  value='<%=family_name_length%>'/>
							<jsp:param name="family_name_loc_lang_prompt"  value='<%=family_name_loc_lang_prompt%>'/> 							
							<jsp:param name="name_suffix_loc_lang_prompt"  value='<%=name_suffix_loc_lang_prompt%>'/>
							<jsp:param name="first_name_loc_lang_prompt"  value='<%=first_name_loc_lang_prompt%>'/>
							<jsp:param name="second_name_loc_lang_prompt"  value='<%=second_name_loc_lang_prompt%>'/>
							<jsp:param name="third_name_loc_lang_prompt"  value='<%=third_name_loc_lang_prompt%>'/>
							<jsp:param name="name_prefix_loc_lang_prompt"  value='<%=name_prefix_loc_lang_prompt%>'/>
							<jsp:param name="names_in_oth_lang_yn"  value='<%=names_in_oth_lang_yn%>'/>
						</jsp:include>
					<%}%>
				</table>
				</td>
				</tr>
				<tr>
					<td class='label'  width='22%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td class='fields'><select name="new_born_sex" id="new_born_sex" onChange="getNewBornRegnValues(this.name),getRelationShip(this)">
					<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
	                <option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
		            <option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
			        <option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
					</select><img align=center src='../../eCommon/images/mandatory.gif' id='new_born_sex_MandImg'></img></select>
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
							document.forms[0].new_born_sex.value = "<%=checkForNull((String)hashMap.get("q_nb_sex"))%>";
							document.forms[0].new_born_sex.disabled = true;
							
						</script>
					<%}%>
					</td>
						<td class='label'><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
					<td class='label'>
					  <% 
						if ( function_id.equals("REGISTER_NEWBORN") || function_id.equals("MAINTAIN_BIRTH") )
						{
							
							if ( function_id.equals("REGISTER_NEWBORN")  )
							{
								BDVallnew=cd1+"*"+cd2;
								birth_date=current_date;
								dofbirthdis="";
							}
							else
							{
								dofbirthdis="disabled";
								BDVallnew = cd1+"*"+ cd2;
								dofbirthvalue=(checkForNull((String) hashMap.get("q_date_of_birth")));	
								
								if(dofbirthvalue!=null || !dofbirthvalue.equals("")) {
									StringTokenizer st_date = new StringTokenizer(dofbirthvalue," ");
									if(st_date.hasMoreTokens()) {
										birth_date = st_date.nextToken();
										birth_time = st_date.nextToken();
									}									
								}
							}
					}
					if(!dofbirthvalue.equals(""))
						dofbirthvalue=DateUtils.convertDate(dofbirthvalue,"DMYHM","en",localeName);				
					if(!birth_date.equals(""))
						birth_date=DateUtils.convertDate(birth_date,"DMY","en",localeName);				
					%>
					<!--Below line modified for MMS-QH-CRF-0145.1 [IN:047497]-->
					<input id="dateofbirth" type='text' name='birth_date' id='birth_date' size='8' maxlength='10' <%=dofbirthdis%> value='<%=birth_date%>' onkeypress="return Valid_DT(event)" onblur="validateDate(this);calc_hij(this);" ><img src='../../eCommon/images/CommonCalendar.gif' name='nb_calander'  onClick="document.forms[0].birth_date.select();return showCalendar('dateofbirth','','','');" >
					<img align=center src='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;
					<fmt:message key="eMP.Birth.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.time.label" bundle="${common_labels}"/>
					<input type='text' name='birth_time' id='birth_time' size='5' maxlength='5' <%=dofbirthdis%> value='<%=birth_time%>' onkeypress="return Valid_TM(event)" onblur="validateTime(this)"><img align='center' src='../../eCommon/images/mandatory.gif'>
					<input type = 'hidden' name = 'date_of_birth' value = '<%=dofbirthvalue%>'> 
				    <input type='hidden' name='hij_appl_YN' id='hij_appl_YN' value='<%=hij_appl_YN%>'>
					<input type='hidden' name='invalid_dob' id='invalid_dob' value='N'>
					<input type='hidden' name='date_of_birth_hjiri' id='date_of_birth_hjiri' value="<%=checkForNull((String )hashMap.get("hijri_birth_date"))%>">
					<%if(hij_appl_YN.equals("Y")){ %> 
					&nbsp;<img id='imgdateofbirth_hj' src='../../eCommon/images/CommonCalendar.gif'  onClick="document.getElementById('date_of_birth_hj').select();return showCalendar_hj('date_of_birth_hj','','','');"  <%=dofbirthdis%>><input type='text' name='date_of_birth_hj' id='date_of_birth_hj'  maxlength='10' size='8' onblur='convertToGD(this);' value="<%=checkForNull((String )hashMap.get("hijri_birth_date"))%>" <%=dofbirthdis%>><fmt:message key="eMP.Hijri.label" bundle="${mp_labels}"/>
				    <script>calc_hij(document.NewbornRegistration_form.birth_date);</script><%}%>
					</td>
					</tr>
					<tr>
						<td class="label">
							<fmt:message key="Common.bloodgroup.label" bundle="${common_labels}"/>
						</td>
						<td class='fields'>
							<select name='blood_group' id='blood_group' <%=dis_all_flds%> ><option value='' >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
								<%
								try {
									stmt = con.createStatement();			
									rs1 = stmt.executeQuery("select blood_grp , short_desc  from mr_blood_grp_lang_vw  where eff_status='E' AND language_id='"+localeName+"'");
									if (rs1 != null) {
											while(rs1.next() ) {
												String BloodGroup = rs1.getString("blood_grp");
												String ShortDesc = rs1.getString("short_desc");
												if(!function_id.equals("REGISTER_NEWBORN"))
												{
													if(BloodGroup.equals(pat_blood_grp))
													{
														out.println("<option value ='"+BloodGroup+"' selected>"+ShortDesc);
													}
													else
														out.println("<option value ='"+BloodGroup+"'>"+ShortDesc);
												}
												else
												{
													out.println("<option value ='"+BloodGroup+"'>"+ShortDesc);
												}
											}
									}
								}catch(Exception e) {
									//out.println(e);
									e.printStackTrace();
								} finally {
									if (rs1 != null) rs1.close();
									if (stmt != null) stmt.close();
								}
								%>
							</select>
						</td>
					<td class='label'>
						<fmt:message key="eMR.RHDFactor.label" bundle="${mr_labels}"/>
					</td>
					<td class='fields'>
						<select name='rf_code' id='rf_code' <%=dis_all_flds%> ><option value='' >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
							<%
								 try {
								   String rhes_fac = "";
								   stmt = con.createStatement();
								   rs1 = stmt.executeQuery("select rhesus_factor_code, short_desc from mr_rhesus_factor_lang_vw  where eff_status='E' and language_id='"+localeName+"'");
								   if(rs1 != null) {
									   while(rs1.next()) {
										   rhes_fac = rs1.getString("rhesus_factor_code");
										if(!function_id.equals("REGISTER_NEWBORN"))
										{
										   if(rhes_fac.equals(pat_rh_factor))
										   {
											 out.println("<option value='" + rs1.getString("rhesus_factor_code") + "' selected>"+ rs1.getString("short_desc"));
										   }
										   else{
										   out.println("<option value='" + rs1.getString("rhesus_factor_code") + "'>"+ rs1.getString("short_desc"));
										   }
										}
										else
										{
											out.println("<option value='" + rs1.getString("rhesus_factor_code") + "'>"+ rs1.getString("short_desc"));
										}
									   }
									}
								
								 }catch(Exception e) {
									//out.println(e);
									e.printStackTrace();
								 } finally {
									if (rs1 != null) rs1.close();
									if (stmt != null) stmt.close();
								 }
								 %>
							</select>
						</td>
					</tr>
					<tr>
					<td class='label'    >
					<%if(FAMILY_ORG_ID_ACCEPT_YN.equals("Y"))
						{%><fmt:message key="eMP.prefix.label" bundle="${mp_labels}"/> <%}
						else{%><fmt:message key="Common.relationship.label" bundle="${common_labels}"/><%}%></td>
					<td class='fields'><select name='sltRelationship' id='sltRelationship' onchange="getpat_catrel();" disabled>
					<option>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option></select></td>	
			        <td class='label'  ><fmt:message key="Common.outcome.label" bundle="${common_labels}"/></td>
			        <td class='fields'><select name="outcome" id="outcome" onChange='enableFields(this,"<%=call_function_id%>")'>
					<%if(isLabelChangeApplicable){%>
					<option value='L'><fmt:message key="eMP.Alive.label" bundle="${mp_labels}"/></option><!--Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565--><%}else{%>
					<option value='L'><fmt:message key="eMP.Live.label" bundle="${mp_labels}"/></option><%}%>
					<option value='S'><fmt:message key="eMP.StillBorn.option.label" bundle="${mp_labels}"/></option></select>&nbsp;<span id = 'stillbirth_dtlsID' style="visibility:hidden" onClick='javascript:stillBirthWindow1()'><input type='button' class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.StillBirthDtls.label","mp_labels")%>' name="apgar_dtls_name"></span></td>
				    <%if(!function_id.equals("REGISTER_NEWBORN")){%>
                       <script>
							document.forms[0].outcome.value = "<%=(String) hashMap.get("q_outcome")%>";
							document.forms[0].outcome.disabled = true;
						</script>
					<%}%> 
					</tr>
				<%if(FAMILY_ORG_ID_ACCEPT_YN.equals("Y")){%>
						<tr>
						 <td     class='label'><fmt:message key="Common.relationship.label" bundle="${common_labels}"/>:<fmt:message key="Common.Mother.label" bundle="${common_labels}"/> </td>					
						<td class='fields'><input type='text' name="mother_rel_desc" id="mother_rel_desc" value="<%=relation_mdesc%>" disabled>
						</td>
						<td     class='label' ><fmt:message key="eMP.child.label" bundle="${mp_labels}"/> </td>
						<td >
						<table border=0 cellpadding="1" cellspacing="0" width="100%">
					<tr>
						<td class='fields'>
						<select name="relation_child" id="relation_child" onchange="getpat_catrel()"<%=dis_all_flds%> >
						<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
						</select>
						<%
							if(FAMILY_NO_LINK_YN.equals("Y") || FAMILY_ORG_ID_ACCEPT_YN.equals("Y"))
							{
								child_mandatory="mandatory";
						%>
								<img align=center src='../../eCommon/images/mandatory.gif' id='relation_child_MandImg'></img>
						<%
							}
						%>
						
							</td>
						</tr>
						</table></td>
						</tr>
							<%if(entitlement_by_pat_cat_yn.equals("Y")){%>
						<tr>
						 <td   class='label'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
						<td>
						   <select name="relation_child11" id="relation_child11" <%=dis_all_flds%> onchange="callfun_exp_catdate(this);">
						    <option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						    </select>  
							<img align=center src='../../eCommon/images/mandatory.gif' id='relation_child11_MandImg' ></img>
										
							</td><td colspan=1   class='label'><fmt:message key="Common.expiryDate.label" bundle="${common_labels}"/></td>
							
							<td class='fields'><input id="expcatdate" type='text' name='exp_cat_date' id='exp_cat_date' onblur="validDateObj(this,'DMY',localeName);"  size='8' maxlength='10' value='' disabled ><input id="callimag" type="image"  src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].all.expcatdate.select();return showCalendar('expcatdate',null,null,true)"></td>
							<td colspan=2></td>
							<%if(!function_id.equals("REGISTER_NEWBORN")){%>
								<script>									document.forms[0].relation_child11.value="<%=checkForNull((String)hashMap.get("pat_cat_code"))%>";
							    </script>
							<%}%> 
						</tr>
							<%}
						}%>
			    <tr>
					<td class='label'    ><fmt:message key="eMP.IndicatorMark.label" bundle="${mp_labels}"/></td>
					<td class='fields'><select name="indicator_mark" id="indicator_mark" disabled>
					<option selected value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
					<option value='F'><fmt:message key="eMP.Fresh.label" bundle="${mp_labels}"/></option>
					<option value='M'><fmt:message key="eMP.Macerated.label" bundle="${mp_labels}"/></option>
					<%if(!function_id.equals("REGISTER_NEWBORN")){%>
					<script>
					     document.NewbornRegistration_form.indicator_mark.value='<%=(String) hashMap.get("q_indicator_mark")%>';
						 </script>
					<%}%> 
					</td>
					<input type="hidden" name="BDVal1" id="BDVal1" value="<%=BDVallnew%>">
					<input type="hidden" name="hddDTTM" id="hddDTTM" value="<%=mp_param_sysdate%>">
					<input type='hidden' name='system_date' id='system_date' value="<%=mp_param_sysdate%>">
					<input type="hidden" name="hddBDate" id="hddBDate" value="">
					<input type="hidden" name="hddDate" id="hddDate" value="">
					<input type="hidden" name="hddTime" id="hddTime" value="">
					<input type="hidden" name="allow_nb_regn_unit" id="allow_nb_regn_unit" value=<%=cd1%>>
					<td class='label'  ><fmt:message key="eMP.BornWhere.label" bundle="${mp_labels}"/></td>
					<td class='fields'><select name="born_where" id="born_where" onchange="chkumblookup(this,'<%=call_function_id%>');" style="width:155" <%=dis_all_flds%> >
					<option value='I' selected><fmt:message key="eMP.InFacility.label" bundle="${mp_labels}"/></option>
					<option value='H'><fmt:message key="Common.home.label" bundle="${common_labels}"/></option>
					<option value='A'><fmt:message key="eMP.Ambulance.label" bundle="${mp_labels}"/></option>
					<option value='O'><fmt:message key="eMP.OtherModesofTpt.label" bundle="${mp_labels}"/></option>
					<option value='B'><fmt:message key="eMP.BornBeforeArrival.label" bundle="${mp_labels}"/></option>
					</select><img align=center src='../../eCommon/images/mandatory.gif' id='born_where_MandImg' ></img>	
                     <%if(!function_id.equals("REGISTER_NEWBORN")){
							if(checkForNull((String) hashMap.get("q_bba_yn")).equals("")){%>
								<script>
									document.forms[0].born_where.selectedIndex=0;
								</script>
							<%}else{%>
									<script>
									document.forms[0].born_where.value='<%=((String) hashMap.get("q_bba_yn"))%>'
									</script>
							<%}
					  }%>
					</td>    
				</tr>	
				<tr>
					<td class='label' ><fmt:message key="eMP.Bornat.label" bundle="${mp_labels}"/></td>
					<td class='fields'>
					<select name="born_at_locn_type" id="born_at_locn_type" style="width:141" onchange="populate_bornat(this,'<%=request.getContextPath()%>');" <%=dis_all_flds%> >
					</select>
					<script>
							var opt=document.createElement("OPTION");
							opt.text="--- "+getLabel("Common.defaultSelect.label","Common")+" ---";
							opt.value="";
							document.forms[0].born_at_locn_type.add(opt);
							opt=document.createElement("OPTION");
							opt.text=getLabel("Common.clinic.label","Common")
							opt.value="C";
							document.forms[0].born_at_locn_type.add(opt);
							opt=document.createElement("OPTION");
							opt.text=getLabel("Common.emergency.label","Common")
							opt.value="E";
							document.forms[0].born_at_locn_type.add(opt);
							opt=document.createElement("OPTION");
							opt.text=getLabel("Common.DaycareUnit.label","Common")
							opt.value="D";
							document.forms[0].born_at_locn_type.add(opt);
							opt=document.createElement("OPTION");
							opt.text=getLabel("Common.nursingUnit.label","Common")
							opt.value="N";
							document.forms[0].born_at_locn_type.add(opt);
							if("<%=newbornBornAt%>"=="true"){
							  if("<%=ot_yn%>"=="Y"){
								opt=document.createElement(	"OPTION");
								opt.text=getLabel("eOP.OTSpecific.label","OP")
								opt.value="O";
								document.forms[0].born_at_locn_type.add(opt);
							 }
							    opt=document.createElement("OPTION");
								opt.text=getLabel("Common.ProcedureUnit.label","Common")
								opt.value="P";
								document.forms[0].born_at_locn_type.add(opt);
							if("<%=rd_yn%>"=="Y"){
							    opt=document.createElement("OPTION");
								opt.text=getLabel("Common.RadiologyWing.label","Common")
								opt.value="W";
								document.forms[0].born_at_locn_type.add(opt);
							 }
								opt=document.createElement("OPTION");
								opt.text=getLabel("Common.room.label","Common")
								opt.value="R";
								document.forms[0].born_at_locn_type.add(opt);
						}
					  </script>
					<%if(!function_id.equals("REGISTER_NEWBORN")){
					if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("")){%>	
					<script>
						document.forms[0].born_at_locn_type.selectedIndex=0;
					</script>
					<%}else{%>
					<script>
						document.forms[0].born_at_locn_type.value="<%=((String) hashMap.get("q_born_at_locn_type"))%>";
					</script>
					<%} }%>
					</td>
					<td colspan=1 class=label  ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
					<td><select name="born_at_locn_code" id="born_at_locn_code" <%=dis_all_flds%> >
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>          
					<%
						if(!function_id.equals("REGISTER_NEWBORN")){%>   
						<% if(!checkForNull((String) hashMap.get("q_born_at_locn_code")).equals("")) {
							array_list.clear();
							if(((String) hashMap.get("q_born_at_locn_type")).equals("C")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"C",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("E")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"E",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("D")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"D",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("N")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"N",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("O")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"O",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("P")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"P",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("W")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"W",con,p);
							}
							else if(checkForNull((String) hashMap.get("q_born_at_locn_type")).equals("R")) {
								array_list = eMP.NewbornDetails.getClinicNursingUnitCodeDesc(facilityId,"R",con,p);
							}
							for(int i=0;i<array_list.size();i+=2) {
								if(checkForNull((String)hashMap.get("q_born_at_locn_code")).equals((String) array_list.get(i)))
								{
									out.println("<option value=\""+(String)array_list.get(i)+"\"  selected>"+(String)array_list.get(i+1)+"</option>");
								} else {
									out.println("<option value=\""+(String)array_list.get(i)+"\">"+ (String)array_list.get(i+1)+"</option>");
								}
							} 
						} %>
					<%}%>
					</select>
					  <%if(!function_id.equals("REGISTER_NEWBORN")){
								if(checkForNull((String) hashMap.get("q_outcome")).equals("S")&&!checkForNull((String) hashMap.get("q_bba_yn")).equals("I")) 
								{%>
									<script>
										document.forms[0].born_at_locn_type.disabled			= true;
										document.forms[0].born_at_locn_type.options[0].selected	= true;
										document.forms[0].born_at_locn_code.disabled			= true;
										document.forms[0].born_at_locn_code.options[0].selected	= true;
									</script>
								<%} 
						}%>
					</td>
					</tr>
					<tr>
					<td class='label'  ><fmt:message key="Common.birthPlace.label" bundle="${common_labels}"/></td>
					<td class='fields'><input type='text' name='Birth_place_desc' id='Birth_place_desc'  size='15' maxlength='15' onblur='if(this.value != "") searchCountry(contry_code,Birth_place_desc)' value='' <%=dis_all_flds%> ><input type='button' name='contry_code' id='contry_code' value='?' class='button' onclick='searchCountry(this,Birth_place_desc)' <%=dis_all_flds%> >
					<input type='hidden' name='Birth_place_code' id='Birth_place_code' value=''>
					</td>
                     <% if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						 document.forms[0].Birth_place_code.value="<%=checkForNull((String) hashMap.get("q_Birth_place_code"))%>";
						 document.forms[0].Birth_place_desc.value= "<%=checkForNull((String)hashMap.get("q_birth_place_desc"))%>";
						</script>
					<%}%>
					<td class='label'><fmt:message key="eMP.BirthCertificateNo.label" bundle="${mp_labels}"/>
					</td>
					<td class='fields'>
				<input type="text" name="birth_cert_no" id="birth_cert_no" maxlength=15 size=15 <%=dis_all_flds%> ></td>	
					<%if(!function_id.equals("REGISTER_NEWBORN")){
                       if(((String) hashMap.get("q_outcome")).equals("S")) {%>
						     <script>
						     document.forms[0].birth_cert_no.disabled=true;
					         </script>
					  <%}%>
						   <script>
                            document.forms[0].birth_cert_no.value='<%=(String) hashMap.get("q_birth_cert_no")%>';
							</script>
					<%}%>
				</tr>
				<tr>
					<td class='label'  ><fmt:message key="eMP.BirthWeight.label" bundle="${mp_labels}"/></td>
					<td class='fields'><%sel1="";sel2="";if(unitofwtnb.equals("K")) sel1="selected"; else sel2="selected";%><input type='hidden' name ='unitofwtnb' id='unitofwtnb' value='<%=unitofwtnb%>'><input type="text" name="weight" id="weight" maxlength=6 size=4 onBlur="return validateMinMax(this,'<%=min_weight%>','<%=max_weight%>',weight);
					makeValidString(this);return allowValidNumber(this,'event',2,3);" onKeyPress='return allowValidNumber(this,event,2,3)' <%=dis_all_flds%> ><select disabled name="weight_unit" id="weight_unit"><option value='K'  <%=sel1%>><fmt:message key="Common.kg.label" bundle="${common_labels}"/><option value='L' <%=sel2%>><fmt:message key="Common.lb.label" bundle="${common_labels}"/></select><img align=center src='../../eCommon/images/mandatory.gif' id='weight_unit_MandImg'></img>
					</td> 
                     <% if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						 document.forms[0].weight.value= value='<%=(String) hashMap.get("q_weight")%>';
						</script>
					<%}%>
					<td class='label'><fmt:message key="eMP.LengthofBaby.label" bundle="${mp_labels}"/></td>
					<td class='fields'><%sel1="";sel2="";if(unitoflengthnb.equals("C")) sel1="selected"; else sel2="selected";%><input type = 'hidden' name ='unitoflengthnb' id='unitoflengthnb' value='<%=unitoflengthnb%>'><input type="text" name="length1" id="length1" maxlength=6 size=5 onBlur="CheckNumZero1(this);return validateMinMax(this,'<%=min_length%>','<%=max_length%>',length1);	
					makeValidString(this);return allowValidNumber(this,'event',3,2);" onKeyPress='return allowValidNumber(this,event,3,2)' <%=dis_all_flds%> ><select disabled name="length_unit" id="length_unit"> <option value='C' <%=sel1%>><fmt:message key="Common.cm.label" bundle="${common_labels}"/><option value='I' <%=sel2%>><fmt:message key="Common.in.label" bundle="${common_labels}"/></select>
					<img align='center' id = 'LENGTH_IMG' src='../../eCommon/images/mandatory.gif' style='<%if(isRegNewbornApplicable){%><%=headcircum_lengofBaby%><%}else{%><%=lengthofbaby%><%}%>'></img>
					<!-- Style changed by Kamatchi S for ML-MMOH-CRF-2095-->
					<% if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						 document.forms[0].length1.value= value='<%=(String) hashMap.get("q_length")%>';
						</script>
					<%}%>
					</td>
					</tr>
					<tr>
					<td class='label'    ><fmt:message key="Common.HeadCircumference.label" bundle="${common_labels}"/></td>
					<td class='fields'><%sel1="";sel2="";if(unitofcircumnb.equals("C")) sel1="selected"; else sel2="selected";%><input type='hidden' name='unitofcircumnb' id='unitofcircumnb' value='<%=unitofcircumnb%>'><input type="text" name="circumference" id="circumference" maxlength=6 size=4 onBlur="CheckNumZero1(this);return validateMinMax(this,'<%=min_head_circum%>','<%=max_head_circum%>',circumference);  makeValidString(this);return allowValidNumber(this,'event',3,2);" onKeyPress='return allowValidNumber(this,event,3,2)' <%=dis_all_flds%> ><select disabled name="circumference_unit" id="circumference_unit"><option value='C' <%=sel1%>><fmt:message key="Common.cm.label" bundle="${common_labels}"/><option value='I' <%=sel2%>><fmt:message key="Common.in.label" bundle="${common_labels}"/></select>  			
					<img align='center' id = 'CIRCUMFERENCE_IMG' src='../../eCommon/images/mandatory.gif' style='<%if(isRegNewbornApplicable){%><%=headcircum_lengofBaby%><%}else{%><%=headcircumference%><%}%>'></img>
					</td>
					 <% if(!function_id.equals("REGISTER_NEWBORN")){%>
						 <script>
						 document.forms[0].circumference.value= value="<%=checkForNull((String) hashMap.get("q_circumference"))%>";
						 </script>
					<%}%>
					<td class='label'    ><fmt:message key="eMP.ChestCirumference.label" bundle="${mp_labels}"/></td>
					<td class='fields'><%sel1="";sel2="";if(unitofchestunit.equals("C")) sel1="selected"; else sel2="selected";%><input type='hidden' name ='unitofchestunit' id='unitofchestunit' value = '<%=unitofchestunit%>'><input type="text" name="chest_circumference" id="chest_circumference" maxlength=6 size=5 onBlur="return validateMinMax(this,'<%=min_chest_circum%>','<%=max_chest_circum%>',chest_circumference); makeValidString(this);CheckNum(this);return allowValidNumber(this,'event',3,2);" onKeyPress='return allowValidNumber(this,event,3,2)' <%=dis_all_flds%> ><select disabled name="chest_circumference_unit" id="chest_circumference_unit" ><option value='C' <%=sel1%>><fmt:message key="Common.cm.label" bundle="${common_labels}"/><option value='I' <%=sel2%>><fmt:message key="Common.in.label" bundle="${common_labels}"/></select></td>
					<% if(!function_id.equals("REGISTER_NEWBORN")){%>
						<script>
						 document.forms[0].chest_circumference.value= value='<%=(String) hashMap.get("q_chest_circumference")%>';
						</script>
					<%}%>
				</tr>
				<%
					String outcome_dis = "", outcome_disalbed = "";
					if(!function_id.equals("REGISTER_NEWBORN")) {
						outcome_dis = (String) hashMap.get("q_outcome")==null?"":(String)hashMap.get("q_outcome");
						if(((String)hashMap.get("q_bba_yn")).equals("I")){
					}else{
						outcome_disalbed="disabled";
					}
					} 						
					
					if(outcome_dis.equals("S") || (invoked_from.equals("details_page")&&regnStatus.equals("F"))){
						outcome_disalbed="disabled";
					}
					if(isRegNewbornApplicable && outcome_dis.equals("L")){ outcome_disalbed=""; }
					%>
					
					<!-- Santhosh page splitted for 12c issue-->
				<jsp:include page="../../eMP/jsp/NewbornRegistrationApgarScore.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="function_id_apgarScore"  value='<%=function_id%>'/>
				<jsp:param name="mother_id"  value='<%=motherid%>'/>
				<jsp:param name="invoked_from"  value='<%=invoked_from%>'/>
				<jsp:param name="regnStatus"  value='<%=regnStatus%>'/>
				</jsp:include> 
					<!-- Santhosh end page splitted for 12c issue-->
				<tr>		
					<td class='label'    ><fmt:message key="eMP.UmbilicalCord.label" bundle="${mp_labels}"/></td>
					<td><select name="umbilical_cord_status" id="umbilical_cord_status" <%=dis_all_flds%> >
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --- </option>
					<option value='N'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option>
					<option value='S'><fmt:message key="eMP.Stump.label" bundle="${mp_labels}"/></option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/></option>
					</select></td>
                     <% if(!function_id.equals("REGISTER_NEWBORN")){%>
						  <script>	
							document.forms[0].umbilical_cord_status.value="<%=checkForNull((String) hashMap.get("q_umbilical_cord_status"))%>";
						  </script>
					 <%}%>
					<td class='label'    ><fmt:message key="eMP.UmbCordCutBy.label" bundle="${mp_labels}"/></td>
					<td class='fields' >
					<%
					String umbvisiblemb="";
					if(function_id.equals("REGISTER_NEWBORN")){
						  umbvisiblemb="visible";
						  desc = "";
						  if(invoked_from!=null && invoked_from.equals("details_page")){
						  }else{
							  hashMap.put("q_Umb_cord_cut_by","");
							  hashMap.put("auth_practitioner_id","");
							  hashMap.put("attendant_at_birth","");
							  hashMap.put("autopsy_reqd_yn","");
							  hashMap.put("mate_cond_main_cod","");
							  hashMap.put("mate_cond_main_cod_dur","");
							  hashMap.put("mate_cond_oth_cod","");
							  hashMap.put("mate_cond_oth_cod_dur","");
							  hashMap.put("mate_cond_preexist_cod","");
							  hashMap.put("mate_cond_preexist_cod_dur","");
							  hashMap.put("oth_rel_mate_cond_rel_cod","");
							  hashMap.put("oth_rel_mate_cond_rel_cod_dur","");
							  hashMap.put("cond_cau_dea_main_cod","");
							  hashMap.put("cond_cau_dea_main_cod_dur","");
							  hashMap.put("cond_cau_dea_oth_cod","");
							  hashMap.put("cond_cau_dea_oth_cod_dur","");
							  hashMap.put("cond_cau_dea_preexist_cod","");
							  hashMap.put("cond_cau_dea_preexist_cod_dur","");
							  hashMap.put("rel_cond_cau_dea_rel_cod","");
							  hashMap.put("rel_cond_cau_dea_rel_cod_dur","");
						  }
					}else{
						
						if((checkForNull((String) hashMap.get("q_bba_yn"))).equals("I")) {
						   umbvisiblemb="visible"; 
						   desc = checkForNull((String) hashMap.get("q_umb_cord_cut_by_desc"));
						   String q_Umb_cord_cut_by_chk_len	= checkForNull((String) hashMap.get("q_Umb_cord_cut_by"));
						  if(!q_Umb_cord_cut_by_chk_len.equals("")){
							   if(((String) hashMap.get("q_Umb_cord_cut_by")).length() == 0) {
									desc = "";								
							   }
						  }
						}else{
                            umbvisiblemb="hidden";
							desc = checkForNull((String) hashMap.get("q_Umb_cord_cut_by"));
						}
					 }%>
					    <input type='hidden' name="temp_physician_job_title" id="temp_physician_job_title"><input type ='text'  name='Umb_cord_cut_by1' id='Umb_cord_cut_by1' size=20 maxlength=30 value="<%=desc%>" onblur="getumbcordcutby(this);" <%=dis_all_flds%> ><font id='UmbCrd'><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="callPractSearch(document.forms[0].pract_id_search,document.forms[0].Umb_cord_cut_by1); fixvaluesumbcordcutby();" style='visibility:<%=umbvisiblemb%>' <%=dis_all_flds%> >
						<input type='hidden' name="Umb_cord_cut_by_physician_id" id="Umb_cord_cut_by_physician_id" value="<%=checkForNull((String) hashMap.get("q_Umb_cord_cut_by"))%>" >
						<input type='hidden' name="Umb_cord_cut_by" id="Umb_cord_cut_by" value="<%=checkForNull((String) hashMap.get("q_Umb_cord_cut_by"))%>">
						</font>
							<img align=center id="umb_mand" src='../../eCommon/images/mandatory.gif' style="visibility:<%=umbvisiblemb%>">
							</font><font id='nmdesig' class='label'></font>
							<input type='hidden' name="Umb_cord_cut_by_desig" id="Umb_cord_cut_by_desig" ></td>
				</tr>
				<tr>
					<td class='label'    ><fmt:message key="eMP.Feeding.label" bundle="${mp_labels}"/></td>
					<td><select name="feeding" id="feeding" <%=dis_all_flds%> >
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
					<option value='T'><fmt:message key="eMP.Breast.label" bundle="${mp_labels}"/></option>
					<option value='B'><fmt:message key="eMP.Bottle.label" bundle="${mp_labels}"/></option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/></option>
					</select>
                     <%if(!function_id.equals("REGISTER_NEWBORN")){
                       if(((String) hashMap.get("q_outcome")).equals("S")) {%>
						   <script>
						     document.forms[0].feeding.disabled=true;
					        </script>
					   <%}%>
						   <script>
                            document.forms[0].feeding.value="<%=(String) hashMap.get("q_feeding")%>";
                           </script>
					<%}
					if(!function_id.equals("REGISTER_NEWBORN")){
							if(((String) hashMap.get("q_patency_of_anus_yn")).equals("Y")) 				patency_sel1="selected";
							else if (((String) hashMap.get("q_patency_of_anus_yn")).equals("N")) 
								patency_sel2 = "selected";
					 }%>
					 <td class='label'><fmt:message key="eMP.PatencyofAnus.label" bundle="${mp_labels}"/> </td>
					<td class='fields'><select name='patency_of_anus_yn' id='patency_of_anus_yn' <%=dis_all_flds%> onchange='enablepatencyprac(this);'>
					<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value='Y' <%=patency_sel1%>><fmt:message key="eMP.Patent.label" bundle="${mp_labels}"/></option>
					<option value='N' <%=patency_sel2%>><fmt:message key="eMP.NotPatent.label" bundle="${mp_labels}"/></option>
					</select> 					
					<img align='center' id='PATENCY_OF_ANUS_YN_IMG' src='../../eCommon/images/mandatory.gif' style='visibility:hidden'>
					<input type= 'hidden' name = 'patency_visibility' value = 'N'>
					</td> 						
					</tr>
					<tr>
					<td class='label'    ><fmt:message key="eMP.CongenitalAnomalies.label" bundle="${mp_labels}"/></td>
					<td class='fields'>
						<input type='text' maxLength="75" size="32" name="Congenital_Anomalies_newborn" id="Congenital_Anomalies_newborn" onblur="Congenital_Ano(this);" <%=dis_all_flds%> ><input type='button'  name='Congenital_Anomalies_search' id='Congenital_Anomalies_search' onClick="Congenital_Ano(this);" value='?' class='button' <%=dis_all_flds%> ><input type=hidden name="Congenital_Anomalies" id="Congenital_Anomalies" >
						<% if(!function_id.equals("REGISTER_NEWBORN")){ %>
							<script> 
							document.forms[0].Congenital_Anomalies_newborn.value="<%=cong_anom_desc%>";
							document.forms[0].Congenital_Anomalies.value="<%=checkForNull((String )hashMap.get("q_cong_anomalies_code"))%>";
							</script>
						<%}%>
						</td>	
				 <td class='label'><fmt:message key="eMP.PatencyofAnusCheckedBy.label" bundle="${mp_labels}"/>
				<td>
				<input type='text' maxLength="30" size="25"  name="PatencyofAnusCheckedBy" id="PatencyofAnusCheckedBy" <%=dis_all_flds%> onBlur='getPatencyCheckBy();' value="<%=checkForNull((String) hashMap.get("patency_of_anus_checked_by_desc"))%>" ><input type='button'  name='pract_id_search_patency' id='pract_id_search_patency' value='?' class='button'  onClick='callPractSearch(document.forms[0].pract_id_search_patency,document.forms[0].PatencyofAnusCheckedBy); Patencyvaluespractitioner();' <%=dis_all_flds%> >
				<input type='hidden' name="pract_id_search_patency_hidden" id="pract_id_search_patency_hidden" value="<%=checkForNull((String) hashMap.get("patency_of_anus_checked_by_id"))%>">
				<input type='hidden' name="prev_patency_prac_hidden" id="prev_patency_prac_hidden" value="<%=checkForNull((String) hashMap.get("patency_of_anus_checked_by_id"))%>">
				</td>		
				</tr>
			   <tr>
					<td class='label'  ><fmt:message key="eMP.Stools.label" bundle="${mp_labels}"/></td>
					<td class='fields'><select name="stools" id="stools" <%=dis_all_flds%> >
					<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
					<option value='M'><fmt:message key="eMP.Meconium.label" bundle="${mp_labels}"/></option>
					<option value='Y'><fmt:message key="eMP.YellowSoft.label" bundle="${mp_labels}"/></option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/></option>
					</select>
					</td>
					<td class='label'  ><fmt:message key="eMP.FetusCompofDelivery.label" bundle="${mp_labels}"/></td><td class='fields'><input type='text' maxLength="75" size="35" name="complications_delivery_text" id="complications_delivery_text" value="<%=ca_foetus_comp_of_delivery_desc%>" onblur="comp_delivery(this);" <%=dis_all_flds%> <%if(!ca_foetus_comp_of_delivery.equals("")){%>disabled<%}%>><input type='button'  name='complications_delivery_search' id='complications_delivery_search' onClick="comp_delivery(this);" value='?' class='button'  onClick='' <%=dis_all_flds%> <%if(!ca_foetus_comp_of_delivery.equals("")){%>disabled<%}%>><input type=hidden name="complications_delivery_nb" id="complications_delivery_nb" value="<%=ca_foetus_comp_of_delivery%>">
					<%
						if(!function_id.equals("REGISTER_NEWBORN")){
							accession_no	= checkForNull((String) hashMap.get("q_accession_num"));
						}
					%>
					 <%
					 if(isNeonatalApplicable){%> 
						<a href="javascript:NeonatalResuscitation();" style="text-decoration:none;white-space: nowrap;" id="linkNeonatalResuscitation" name="linkNeonatalResuscitation"><b><fmt:message key="eMP.NeonatalResuscitation.label" bundle="${mp_labels}"/></b></a>
					<%}
					%>
						</td>
                     <% if(!function_id.equals("REGISTER_NEWBORN")){%>
							<script>
							document.forms[0].complications_delivery_text.value="<%=q_nb_compln_dely_desc%>";
							document.forms[0].complications_delivery_nb.value="<%=checkForNull((String )hashMap.get("q_complications_delivery_nb"))%>";
							</script>
					<%}%>	
					
				   <% if(!function_id.equals("REGISTER_NEWBORN")){
						if(((String) hashMap.get("q_outcome")).equals("S")) {
						%>		<script>
									document.forms[0].stools.disabled=true;
								</script>
						<%}%>
						<script>
						document.forms[0].stools.value="<%=checkForNull((String) hashMap.get("q_stools"))%>";
						</script>  
				   <%}
						if (ip_install_yn.equals("Y") && called_function.equals("IP")) 
							{  
							%><tr><td></td><td></td>
						<td class='label' ><%=bed_label%></td>
						<td class='fields' >
								<%if(!function_id.equals("REGISTER_NEWBORN")){
								      if(!mother_bed_no.equals("")) {
											hashMap11 = eMP.NewbornDetails.getIPNursingUnitBedNO(facilityId, mother_bed_no, (String)hashMap.get("q_patient_id"), con);
											old_bed_number = checkForNull((String)hashMap11.get("old_bed_number"));
									}
                                      mother_nursing_unit=(String)hashMap10.get("mother_nursing_unit_code");
								}
								else
								 {
									hashMap10 = eMP.NewbornDetails.getIPOpenEncounter(facilityId,motherencounterid,con,p); 
									 pseudo_bed_yn=checkForNull((String)hashMap10.get("pseudo_bed_yn"),"N");
								}
																
								if(outcome.equals("S"))
									dis_bed_fields="disabled";
								else
									dis_bed_fields="";								
				%>
								<input type='text' name='bed_number' id='bed_number' size='8' maxlength='8' value='<%=old_bed_number%>' readonly 
								<%=hide_bedNo%> <%=dis_all_flds%> <%=dis_bed_fields%>></input><input type='button' class='button' name='bed_lookup' id='bed_lookup' value="?" onclick='bed_search();' <%=hide_bedNo%> <%=dis_all_flds%> <%=dis_bed_fields%>>
								
								</td>
								<input type="hidden" name="mother_nursing_unit_code" id="mother_nursing_unit_code" value='<%=mother_nursing_unit%>'>
								<input type="hidden" name="mother_bed_no" id="mother_bed_no" value='<%=mother_bed_no%>'>
								<input type="hidden" name="pseudo_bed_yn" id="pseudo_bed_yn" value='<%=pseudo_bed_yn%>'> 			
						<input type="hidden" name="old_bed_number" id="old_bed_number" value="<%=old_bed_number%>">
						<%}else{%>
                             <input type="hidden" name="mother_nursing_unit_code" id="mother_nursing_unit_code" value='<%=mother_nursing_unit%>'>
							<input type="hidden" name="mother_bed_no" id="mother_bed_no" value='<%=mother_bed_no%>'>
							<input type="hidden" name="old_bed_number" id="old_bed_number" value="<%=old_bed_number%>">
							<td class=label colspan='4'></td>
							<%}%> 
							
				</tr> 
			 <%if(isRegNewbornApplicable){%>
			<tr>
			<td class='label'><fmt:message key="eMP.Resuscitated.label" bundle="${mp_labels}"/>
			<input type='hidden' maxlength=10 size=10 name="resuscit_temp_desc" id="resuscit_temp_desc" ><input type='hidden' name='resuscit_temp_id_search' id='resuscit_temp_id_search' class=button><input type='hidden' name="resuscit_physician_id" id="resuscit_physician_id">
			</td>
            <td  class='fields'>
			<input type='text' maxLength="30" size="25"  name="resuscit_practid_desc" id="resuscit_practid_desc"  onBlur='getresuscitpract();' value="<%=checkForNull(resuscitated_pract_desc)%>" ><input type='button'  name='resuscit_pract_id_search1' id='resuscit_pract_id_search1' value='?' class='button'  onClick='callPractSearch1(document.forms[0].resuscit_pract_id_search1,document.forms[0].resuscit_practid_desc); fixvaluespractitioner1();'>
			<input type='hidden' name="resuscit_attend_pract_id" id="resuscit_attend_pract_id" value="<%=checkForNull(resuscitated_pract_id)%>">
			</td>
			<td class='label'>&nbsp;</td>
            <td  class='fields'>&nbsp;</td>
            </tr>
							
				<%if(!function_id.equals("REGISTER_NEWBORN")){%>
				   <script> 
				   document.forms[0].resuscit_attend_pract_id.value = "<%=checkForNull((String) hashMap.get("resuscitated_pract_id"))%>";
				   document.forms[0].resuscit_practid_desc.value = "<%=checkForNull((String) hashMap.get("resuscitated_pract_desc"))%>";
				   document.forms[0].resuscit_practid_desc.disabled = "<%=dis_all_flds%>";
				    document.forms[0].resuscit_pract_id_search1.disabled ="<%=dis_all_flds%>";
				  </script> 
			<%}
			}%>
				<tr><td colspan='4'>					
					<table border='0' id='child_tab2' width="100%" cellpadding=1 cellspacing=0>
						<tr><td colspan='6' class='columnheader'><span id = 'vaccin_dtls_link' onClick='javascript:expandCollapse("VD")'><input type='button' class='button' value='-' name='vacc_button' id='vacc_button'></span>&nbsp<fmt:message key="eMP.vaccinationdetails.label" bundle="${mp_labels}"/>
						</td></tr>
					</table>
				</td></tr>
				<tr><td colspan='4'>
				<div id = 'vaccin_dtls'>
				<table border='0' width="100%" cellpadding=1 cellspacing=0>
				<!-- row 1 -->
				<tr>
					<td class='label'   width='15%'></td>
					<td class='label'   width='3%'></td>
					<td class='label'   width='19%'><fmt:message key="eMP.VaccSite.label" bundle="${mp_labels}"/></td>
					<td class='label'   width='19%'><fmt:message key="Common.AdministeredBy.label" bundle="${common_labels}"/></td>
					<td class='label'   width='19%'><fmt:message key="Common.designation.label" bundle="${common_labels}"/></td>
					 <td class='label'  width='25%'><fmt:message key="eMP.AdminDateTime.label" bundle="${mp_labels}"/></td> 
				</tr>
				<%
				      String bcgselect="";
				      String bcgtxtvaccsite="";
				      String bcgtxtvaccdis="disabled";
				      String bcgselectvalue="N";
					  String bcgdesig="";
					  String bcgadmin="";
					  String bcgdatetime="";
					  String vitaminkselect="";
				      String vitaminktxtvaccsite="";
				      String vitaminktxtvaccdis="disabled";
				      String vitaminkselectvalue="N";
					  String vitaminkdesig="";
					  String vitaminkadmin="";
					  String vitaminkdatetime="";
					  String Hepatitisselect="";
				      String Hepatitistxtvaccsite="";
				      String Hepatitistxtvaccdis="disabled";
				      String Hepatitisselectvalue="N";
					  String Hepatitisdesig="";
					  String Hepatitisadmin="";
					  String Hepatitisdatetime="";
				      if(!function_id.equals("REGISTER_NEWBORN"))
					  {
						  if(((String)      hashMap.get("q_bcg_given_yn")).equals("Y")) {
						   bcgselect="checked";
						   bcgselectvalue="Y";
						   bcgtxtvaccsite=(String) hashMap.get("q_vaccination_site");
						   if(!(invoked_from.equals("details_page")&&regnStatus.equals("F")))
						         bcgtxtvaccdis="";
						   bcgadmin=(String) hashMap.get("q_administered_by");
						   bcgdesig=(String) hashMap.get("q_administered_designation");
						   bcgdatetime=(String) hashMap.get("q_bcg_datetime");
						   bcgdatetime=DateUtils.convertDate(bcgdatetime,"DMYHM","en",localeName);
						 }
						 if(((String) hashMap.get("q_vitak_given_yn")).equals("Y")) {		
						   vitaminkselect="checked";
						   vitaminkselectvalue="Y";
						   vitaminktxtvaccsite=(String) hashMap.get("q_vitak_vaccination_site");
						   if(!(invoked_from.equals("details_page")&&regnStatus.equals("F")))
								vitaminktxtvaccdis="";
						   vitaminkadmin=(String) hashMap.get("q_vitak_administered_by");
						   vitaminkdesig=(String) hashMap.get("q_vitak_administered_designation");
						   vitaminkdatetime=(String) hashMap.get("q_vitk_datetime");
						   vitaminkdatetime=DateUtils.convertDate(vitaminkdatetime,"DMYHM","en",localeName);
						 }
						 if(((String) hashMap.get("q_hep_given_yn")).equals("Y")) {
						   Hepatitisselect="checked";
						   Hepatitisselectvalue="Y";
						   Hepatitistxtvaccsite=(String) hashMap.get("q_hepb_vaccination_site");
						   if(!(invoked_from.equals("details_page")&&regnStatus.equals("F")))
								Hepatitistxtvaccdis="";
						   Hepatitisadmin=(String) hashMap.get("q_hepb_administered_by");
						   Hepatitisdesig=(String) hashMap.get("q_hepb_administered_designation");
						   Hepatitisdatetime=(String) hashMap.get("q_hepb_datetime");
						   Hepatitisdatetime=DateUtils.convertDate(Hepatitisdatetime,"DMYHM","en",localeName);
						 }
						 
						}
				%>
				<tr>
					<td class='label'     width='12%'><fmt:message key="eMP.BCG.label" bundle="${mp_labels}"/></td>
					<td class='fields'><input type="checkbox" name="bcg_given_yn" id="bcg_given_yn" <%=bcgselect%>onClick='chkValues(this);enableBcg(this);' value='<%=bcgselectvalue%>' <%=dis_all_flds%>  <%=bcgselect%>></td>
					<td class='fields'><input type='text' name='txtVaccSite' id='txtVaccSite' value="<%=bcgtxtvaccsite%>" maxlength='30' size='25' <%=bcgtxtvaccdis%>></td>
					<td class='fields'><input type='text' name='administeredBy' id='administeredBy' maxlength='30' value="<%=bcgadmin%>" size='25' <%=bcgtxtvaccdis%>></td>
					<td class='fields'><input type='text' name='Designation' id='Designation' value="<%=bcgdesig%>" maxlength='30' size='25' <%=bcgtxtvaccdis%>></td>
					<td class='fields'><input type='text' name='bcg_datetime'  id = 'bcgdatetime' onkeypress="return Valid_DT(event)" onBlur="calldoDateTimeChk(this);chk_with_birthdate(this);" maxlength='16' value="<%=bcgdatetime%>" size='14' <%=bcgtxtvaccdis%>><img  id='image1' src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].bcg_datetime.select(); if( !document.forms[0].bcg_datetime.disabled){return showCalendar('bcgdatetime',null,'hh:mm','modal')}" <%=bcgtxtvaccdis%>/></td>
				</tr>
				<tr>
					<td class='label'     width='12%'><fmt:message key="eMP.VitaminK.label" bundle="${mp_labels}"/></td>
					<td class='fields'><input type="checkbox" name="vitak_given_yn" id="vitak_given_yn"  onClick='chkValues(this);enableVitak(this);'  value='<%=vitaminkselectvalue%>' <%=vitaminkselect%> <%=dis_all_flds%> ></td>
					<td class='fields'><input type='text' value="<%=vitaminktxtvaccsite%>"  <%=vitaminktxtvaccdis%> name='vitak_VaccSite' maxlength=30 size = '25' ></td>
					<td class='fields'><input type='text' name='vitak_administeredBy' id='vitak_administeredBy' value="<%=vitaminkadmin%>" <%=vitaminktxtvaccdis%> maxlength=30 size = '25' ></td>
					<td class='fields'><input type='text' name='vitak_Designation' id='vitak_Designation' value="<%=vitaminkdesig%>" <%=vitaminktxtvaccdis%> maxlength=30 size = '25' ></td>
					<td class='fields'><input type='text' name='vitk_datetime' value="<%=vitaminkdatetime%>" <%=vitaminktxtvaccdis%> id = 'vitkdatetime' onkeypress="return Valid_DT(event)" onBlur="calldoDateTimeChk(this);chk_with_birthdate(this);" maxlength=16 size = '14'><img <%=bcgtxtvaccdis%>  id='image2' src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].vitk_datetime.select(); if(! document.forms[0].vitk_datetime.disabled ){return showCalendar('vitkdatetime',null,'hh:mm','modal')}"/></td>
				</tr>
				<tr>
					<td class='label' width='12%'><fmt:message key="eMP.HepatitisB.label" bundle="${mp_labels}"/></td>
					<td class='fields'><input type="checkbox" name="hep_given_yn" id="hep_given_yn" onClick='chkValues(this);enableHepb(this);' value='<%=Hepatitisselectvalue%>' <%=Hepatitisselect%> <%=dis_all_flds%> ></td>
					<td class='fields'><input type='text' value='<%=Hepatitistxtvaccsite%>' <%=Hepatitistxtvaccdis%> name='hepb_VaccSite' maxlength=30 size = '25' ></td>
					<td class='fields'><input type='text' name='hepb_administeredBy' id='hepb_administeredBy' value='<%=Hepatitisadmin%>' <%=Hepatitistxtvaccdis%> maxlength=30 size = '25'  ></td>
					<td class='fields'><input type='text' value='<%=Hepatitisdesig%>' <%=Hepatitistxtvaccdis%> name='hepb_Designation' maxlength=30 size = '25' ></td>	
					<td class='fields'>
					<input type='text' name='hepb_datetime' value='<%=Hepatitisdatetime%>'  id = 'hepbdatetime' onkeypress="return Valid_DT(event)" onBlur="calldoDateTimeChk(this);chk_with_birthdate(this);" maxlength=16 size = '14' <%=Hepatitistxtvaccdis%>><img <%=bcgtxtvaccdis%> id='image3'  src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].hepb_datetime.select();if(! document.forms[0].hepb_datetime.disabled){return showCalendar('hepbdatetime',null,'hh:mm','modal')}"/>						
					</td> 				
				</tr>
						<tr><td class='label' colspan='4'></td></tr>
				<tr><td class='label' colspan='4'></td></tr>				
				<%if(!entitlement_by_pat_cat_yn.equals("Y") || !FAMILY_ORG_ID_ACCEPT_YN.equals("Y")){%>
					<tr><td colspan='4'></td></tr>
					<tr><td colspan='4'></td></tr>
							<tr><td colspan='4'></td></tr>
							
				<%}%>
			
			</table>
			</div>
			</td>
			</tr>
			</table>
			</div>
			</td></tr>
			</table>
				<script> 
				
					if('<%=dis_all_flds%>'=='disabled') {
						if(document.getElementById("first_name"))
							document.getElementById("first_name[1]").disabled = true;
						if(document.getElementById("second_name"))
							document.getElementById("second_name[1]").disabled = true;
						if(document.getElementById("third_name"))
							document.getElementById("third_name[1]").disabled = true;
						if(document.getElementById("family_name"))
							document.getElementById("family_name[1]").disabled = true;
						if(document.getElementById("name_prefix"))
							document.getElementById("name_prefix[1]").disabled = true;
						if(document.getElementById("name_suffix"))
							document.getElementById("name_suffix[1]").disabled = true;
						if(document.getElementById("first_name_oth_lang"))
							document.getElementById("first_name_oth_lang[1]").disabled = true;
						if(document.getElementById("second_name_oth_lang"))
							document.getElementById("second_name_oth_lang[1]").disabled = true;
						if(document.getElementById("third_name_oth_lang"))
							document.getElementById("third_name_oth_lang[1]").disabled = true;
						if(document.getElementById("family_name_oth_lang"))
							document.getElementById("family_name_oth_lang[1]").disabled = true;
						if(document.getElementById("name_prefix_oth_lang"))
							document.getElementById("name_prefix_oth_lang[1]").disabled = true;
						if(document.getElementById("name_suffix_oth_lang"))
							document.getElementById("name_suffix_oth_lang[1]").disabled = true;
						if(document.getElementById("nb_patient_name"))
							document.getElementById("nb_patient_name").disabled = true; 
						
						/*if('<%=dis_all_flds%>'=='disabled') {
						if(document.getElementById("first_name"))
							document.getElementById("first_name").disabled = true;
						if(document.getElementById("second_name"))
							document.getElementById("second_name").disabled = true;
						if(document.getElementById("third_name"))
							document.getElementById("third_name").disabled = true;
						if(document.getElementById("family_name"))
							document.getElementById("family_name").disabled = true;
						if(document.getElementById("name_prefix"))
							document.getElementById("name_prefix").disabled = true;
						if(document.getElementById("name_suffix"))
							document.getElementById("name_suffix").disabled = true;
						if(document.getElementById("first_name_oth_lang"))
							document.getElementById("first_name_oth_lang").disabled = true;
						if(document.getElementById("second_name_oth_lang"))
							document.getElementById("second_name_oth_lang").disabled = true;
						if(document.getElementById("third_name_oth_lang"))
							document.getElementById("third_name_oth_lang").disabled = true;
						if(document.getElementById("family_name_oth_lang"))
							document.getElementById("family_name_oth_lang").disabled = true;
						if(document.getElementById("name_prefix_oth_lang"))
							document.getElementById("name_prefix_oth_lang").disabled = true;
						if(document.getElementById("name_suffix_oth_lang"))
							document.getElementById("name_suffix_oth_lang").disabled = true;
						if(document.getElementById("nb_patient_name"))
							document.getElementById("nb_patient_name").disabled = true;
						*/
					}  
				</script>
			<% if(!function_id.equals("REGISTER_NEWBORN"))
			  {
					if(((String) hashMap.get("q_outcome")).equals("S")) {%>
						 <script>	 
							document.forms[0].bcg_given_yn.disabled = true;
							document.forms[0].vitak_given_yn.disabled = true;
							document.forms[0].hep_given_yn.disabled = true;
						 </script>	 
						<% }
			 }%>
				
			<%if(function_id.equals("REGISTER_NEWBORN")){
				if(!(checkForNull((String) hashMap.get("q_father_patient_id"))).equals("") || !(checkForNull((String) hashMap.get("q_father_name"))).equals("")) 
		        { %>
				<script>
					document.getElementById("natImg").style.visibility = 'visible';	
					if(document.getElementById("race_required_yn")) {
						if(document.getElementById("race_required_yn").value == 'Y') {
							if(document.getElementById("racImg").style.visibility) {
								document.getElementById("racImg").style.visibility = 'visible';
							}
						}
					}
				</script>
				<%}
			}%>
			<input type=hidden name='maintain_doc_or_file' id='maintain_doc_or_file' value="<%=checkForNull((String) mPParamDtls.get("maintain_doc_or_file"),"F")%>">
			<input type=hidden name='sStyle' id='sStyle' value="<%=sStyle%>">
			<input type='hidden' name='nat_id_accept_alphanumeric_yn' id='nat_id_accept_alphanumeric_yn' value="<%=nat_id_accept_alphanumeric_yn%>"> 
			<input type=hidden name='family_org_sub_id' id='family_org_sub_id' value="<%=family_org_sub_id%>">	   
			<input type=hidden name='family_org_id' id='family_org_id' value="<%=family_org_id%>">
			<input type=hidden name='family_org_membership' id='family_org_membership' value="<%=family_org_membership%>">
			<input type=hidden name='alt_id1_no' id='alt_id1_no' value="<%=mthr_alt_id1_no%>">
			<input type=hidden name='family_org_id_accept_yn_hd' id='family_org_id_accept_yn_hd' value="<%=checkForNull((String)mPParamDtls.get("family_org_id_accept_yn"))%>">
			<input type=hidden name='family_no_link_yn_hd' id='family_no_link_yn_hd' value="<%=checkForNull((String)mPParamDtls.get("family_no_link_yn"))%>">
			<input type=hidden name='HeadPatientid' id='HeadPatientid' value="<%=family_link_no%>">
			<input type=hidden name='child_mandatoryfield' id='child_mandatoryfield' value="<%=child_mandatory%>">
			<input type=hidden name='cat_mandatoryfield' id='cat_mandatoryfield' value="<%=cat_mandatory%>">
			<input type=hidden name='def_nb_male_relationship' id='def_nb_male_relationship' value="<%=nb_male_relnship%>">
			<input type=hidden name='def_nb_female_relationship' id='def_nb_female_relationship' value="<%=nb_female_relnship%>">
			<input type=hidden name='def_nb_unknown_relationship' id='def_nb_unknown_relationship' value="<%=nb_unknown_relnship%>">
			<input type="hidden" name="function_name" id="function_name" value="insert">
			<input type='hidden' name='pat_no_gen_yn' id='pat_no_gen_yn' value='Y'></input>
			<input type='hidden' name='name_suffix_male_nb' id='name_suffix_male_nb' value="<%=namesuffixmalenb%>"></input>
			<input type='hidden' name='name_suffix_female_nb' id='name_suffix_female_nb' value="<%=namesuffixfemalenb%>"></input>			
			<%if(new_function_id.equals("REGISTER_NEWBORN") && !invoked_from.equals("servlet")){ %>
			<input type='hidden' name='mother_patient_id' id='mother_patient_id' value="<%=mother_patient_id%>"></input>
 			<%}%>
			<input type='hidden' name='mother_encounter_id' id='mother_encounter_id' value="<%=motherencounterid%>"></input>
			<input type='hidden' name="sel_accession_num" id="sel_accession_num" value="<%=accession_no%>">
			<input type='hidden' name="isNeonatalApplicable" id="isNeonatalApplicable" value="<%=isNeonatalApplicable%>"> 
			<input type='hidden' name="single_stage_appl_yn" id="single_stage_appl_yn" value="<%=single_stage_appl_yn%>">  
			<input type='hidden' name="modify_delivery_type" id="modify_delivery_type" value="<%=modify_delivery_type%>">  
			<input type='hidden' name="mother_name" id="mother_name" value="">    
			<input type='hidden' name='inhouse_birth_yn' id='inhouse_birth_yn' value="<%=inhousebirthyn%>">
			<input type='hidden' name='system_time' id='system_time' value="<%=tm%>"> 
			<input type='hidden' name='pat_id' id='pat_id' value="">
			<input type='hidden' name='allow_nb_regn_within_days' id='allow_nb_regn_within_days' value="<%=cd2%>">   
			<input type='hidden' name='maxLength' id='maxLength' value="<%=patient_idlength%>">	
			<input type='hidden' name='function_id' id='function_id' value="<%=function_id1%>"></input>
			<input type='hidden' name='CalledFromFunction' id='CalledFromFunction' value="<%=function_id%>">
			<input type='hidden' name='nb_use_mother_ser' id='nb_use_mother_ser' value="<%=nb_use_mother_ser%>"></input>
			<input type='hidden' name='duplicate' id='duplicate' value=""></input>
			<input type='hidden' name='accessRights' id='accessRights' value="<%=accessRights%>"></input>
			<input type='hidden' name='parent_details' id='parent_details' value="<%=parent_details%>"></input>
			<input type='hidden' name='min_weight' id='min_weight' value="<%=min_weight%>"></input>
			<input type='hidden' name='max_weight' id='max_weight' value="<%=max_weight%>"></input>
			<input type='hidden' name='min_length' id='min_length' value="<%=min_length%>"></input>
			<input type='hidden' name='max_length' id='max_length' value="<%=max_length%>"></input>
			<input type='hidden' name='min_head_circum' id='min_head_circum' value="<%=min_head_circum%>"></input>
			<input type='hidden' name='max_head_circum' id='max_head_circum' value="<%=max_head_circum%>"></input>
			<input type='hidden' name='min_chest_circum' id='min_chest_circum' value="<%=min_chest_circum%>"></input>
			<input type='hidden' name='max_chest_circum' id='max_chest_circum' value="<%=max_chest_circum%>"></input>
			<input type='hidden' name='min_gestation' id='min_gestation' value="<%=min_gestation%>"></input>
			<input type='hidden' name='max_gestation' id='max_gestation' value="<%=max_gestation%>"></input>
			<input type='hidden' name='pat_ser_prefix_reqd_yn' id='pat_ser_prefix_reqd_yn' value=""></input>
			<input type='hidden' name='page_show' id='page_show' value='<%=page_show%>'>	
			<input type='hidden' name='page_colour' id='page_colour' value='<%=page_colour%>'>
			<input type='hidden' name="pat_ser_grp_code" id="pat_ser_grp_code">
			<input type='hidden' name="patient_id" id="patient_id" value=<%=motherid%>>
			<input type='hidden' name="number_of_births_recorded" id="number_of_births_recorded" value="<%=q_no_of_birth%>">
			<input type='hidden' name='mp_parm_reqdate' id='mp_parm_reqdate' value="<%=DateUtils.convertDate(getAllowNewBornDate,"DMYHM","en",localeName)%>">
			<input type='hidden' name='mp_parm_systemdate' id='mp_parm_systemdate' value="<%=DateUtils.convertDate(mp_param_sysdate,"DMYHM","en",localeName)%>"> 
			<input type='hidden' name="help_function_id" id="help_function_id" value='REGISTER_NEWBORN'>
			<input type='hidden' name="function_invoked" id="function_invoked" value = "<%=function_invoked%>">
			<input type='hidden' name="module_invoked" id="module_invoked" value = "<%=module_invoked%>">
			<input type='hidden' name="ip_install_yn" id="ip_install_yn" value = "<%=ip_install_yn%>">
 			<input type='hidden' name='invoke_adm_from_newborn_yn' id='invoke_adm_from_newborn_yn' value="<%=invoke_adm_from_newborn_yn%>">
 			<input type='hidden' name="called_function" id="called_function" value = "<%=called_function%>">
			<input type="hidden" name="mode" id="mode" value="<%=functname_sev%>">
			<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>"></input>
			<input type='hidden' name='dflt_nb_regn_blng_class' id='dflt_nb_regn_blng_class' value='<%=dflt_nb_regn_blng_class%>'>
			<input type='hidden' name='fatherAltId1Desc' id='fatherAltId1Desc' value="<%=alt_id1_type_desc%>">
				<input type='hidden' name='parent_details1' id='parent_details1' value="<%=parent_details1%>">	
				<input type='hidden' name='q_mother_date_of_birth' id='q_mother_date_of_birth' value="<%=checkForNull((String) mthrDtls.get("q_mother_date_of_birth"))%>">
			<input type='hidden' name='facility_id' id='facility_id' value="<%=facilityId%>">
				<input type='hidden' name='complications_delivery_hd' id='complications_delivery_hd' value="">
				<input type='hidden' name='att_nurse_newborn_hd' id='att_nurse_newborn_hd' value="">
				<input type='hidden' name='delivery_indication_hd' id='delivery_indication_hd' value="">
				<input type='hidden' name='proc_class_desc_hd' id='proc_class_desc_hd' value="<%=(String) hashMap.get("proc_class_long_desc")%>">
				<input type='hidden' name='vaginal_del_type_desc_hd' id='vaginal_del_type_desc_hd' value="">
				<input type='hidden' name='del_serv_desc_hd' id='del_serv_desc_hd' value="">
				<input type='hidden' name='birthplace_desc_hd' id='birthplace_desc_hd' value="">
				<input type='hidden' name='Congenital_Anomalies_hd' id='Congenital_Anomalies_hd' value="">
				<input type='hidden' name='complications_delivery_hd1' id='complications_delivery_hd1' value="">
				<input type='hidden' name='cboNationality_hd' id='cboNationality_hd' value="">
				<input type='hidden' name='entitlement_by_pat_cat_ynhd' id='entitlement_by_pat_cat_ynhd' value="<%=entitlement_by_pat_cat_yn%>">
				<input type='hidden' name='function_name_nb' id='function_name_nb' value="<%=function_name%>">
				<input type='hidden' name='captureAntenatalDtlsYN' id='captureAntenatalDtlsYN' value="<%=captureAntenatalDtlsYN%>">
				<input type='hidden' name='name_drvn_logic' id='name_drvn_logic' value="<%=name_dervn_logic%>">
				<input type='hidden' name='name_drvn_logic_long' id='name_drvn_logic_long' value="<%=name_dervn_logic_long%>">
				<input type='hidden' name='name_drvn_logic_oth_lang' id='name_drvn_logic_oth_lang' value="<%=name_dervn_logic_oth_lang%>">
				<input type='hidden' name='name_drvn_logic_oth_lang_long' id='name_drvn_logic_oth_lang_long' value="<%=name_dervn_logic_oth_lang_long%>">
				<!--Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551-->
				<input type='hidden' name='First_Name_Accpt_Yn' id='First_Name_Accpt_Yn' value="<%=First_Name_Accept_Yn%>">
				<input type='hidden' name='Second_Name_Accpt_Yn' id='Second_Name_Accpt_Yn' value="<%=Second_Name_Accept_Yn%>">
				<input type='hidden' name='Third_Name_Accpt_Yn' id='Third_Name_Accpt_Yn' value="<%=Third_Name_Accept_Yn%>">
				<input type='hidden' name='Family_Name_Accpt_Yn' id='Family_Name_Accpt_Yn' value="<%=Family_Name_Accept_Yn%>">
				<!--End ML-MMOH-CRF-1551-->
				<input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value="<%=pat_name_as_multipart_yn%>">
				<input type='hidden' name='generate_file' id='generate_file' value="<%=generate_file%>">
				<input type='hidden' name='disable_finalized_button_yn' id='disable_finalized_button_yn' value="<%=disable_finalized_button_yn%>">
				<input type='hidden' name='father_name_prefix' id='father_name_prefix' value="">
				<input type='hidden' name='father_first_name' id='father_first_name' value="">
				<input type='hidden' name='father_second_name' id='father_second_name' value="">
				<input type='hidden' name='father_third_name' id='father_third_name' value="">
				<input type='hidden' name='father_family_name' id='father_family_name' value="">
				<input type='hidden' name='father_name_suffix' id='father_name_suffix' value="">
				<input type='hidden' name='father_name_prefix_loc_lang' id='father_name_prefix_loc_lang' value="">
				<input type='hidden' name='father_first_name_loc_lang' id='father_first_name_loc_lang' value="">
				<input type='hidden' name='father_second_name_loc_lang' id='father_second_name_loc_lang' value="">
				<input type='hidden' name='father_third_name_loc_lang' id='father_third_name_loc_lang' value="">
				<input type='hidden' name='father_family_name_loc_lang' id='father_family_name_loc_lang' value="">
				<input type='hidden' name='father_name_suffix_loc_lang' id='father_name_suffix_loc_lang' value="">
				<input type='hidden' name='nb_name_prefix' id='nb_name_prefix' value="">
				<input type='hidden' name='nb_first_name' id='nb_first_name' value="">
				<input type='hidden' name='nb_second_name' id='nb_second_name' value="">
				<input type='hidden' name='nb_third_name' id='nb_third_name' value="">
				<input type='hidden' name='nb_family_name' id='nb_family_name' value="">
				<input type='hidden' name='nb_name_suffix' id='nb_name_suffix' value="">
				<input type='hidden' name='nb_name_prefix_loc_lang' id='nb_name_prefix_loc_lang' value="">
				<input type='hidden' name='nb_first_name_loc_lang' id='nb_first_name_loc_lang' value="">
				<input type='hidden' name='nb_second_name_loc_lang' id='nb_second_name_loc_lang' value="">
				<input type='hidden' name='nb_third_name_loc_lang' id='nb_third_name_loc_lang' value="">
				<input type='hidden' name='nb_family_name_loc_lang' id='nb_family_name_loc_lang' value="">
				<input type='hidden' name='nb_name_suffix_loc_lang' id='nb_name_suffix_loc_lang' value="">
				<input type='hidden' name='father_patient_name_loc_lang' id='father_patient_name_loc_lang' value="<%=q_father_patient_name_loc_lang%>">				
				<input type='hidden' name='nb_patient_name_loc_lang' id='nb_patient_name_loc_lang' value="">
				<input type='hidden' name='nb_patient_name_loc_lang_long' id='nb_patient_name_loc_lang_long' value="">
				<input type='hidden' name='newTransactionYN' id='newTransactionYN' value="<%=newTransactionYN%>">
				<input type='hidden' name='accept_names_for_live_birth_yn' id='accept_names_for_live_birth_yn' value="<%=accept_names_for_live_birth_yn%>">
				<input type='hidden' name='nb_first_name_hid' id='nb_first_name_hid' value="">
				<input type='hidden' name='nb_second_name_hid' id='nb_second_name_hid' value="">
				<input type='hidden' name='nb_third_name_hid' id='nb_third_name_hid' value="">
				<input type='hidden' name='nb_family_name_hid' id='nb_family_name_hid' value="">
				<input type='hidden' name='nb_first_name_hid_loc' id='nb_first_name_hid_loc' value="">
				<input type='hidden' name='nb_second_name_hid_loc' id='nb_second_name_hid_loc' value="">
				<input type='hidden' name='nb_third_name_hid_loc' id='nb_third_name_hid_loc' value="">
				<input type='hidden' name='nb_family_name_hid_loc' id='nb_family_name_hid_loc' value="">
				<input type='hidden' name='pract_id_still_birth' id='pract_id_still_birth' value="<%=(String)(hashMap.get("auth_practitioner_id")==null?"":hashMap.get("auth_practitioner_id"))%>">
				<input type='hidden' name='attendant_at_birth' id='attendant_at_birth' value="<%=(String)(hashMap.get("attendant_at_birth")==null?"":hashMap.get("attendant_at_birth"))%>">
				<input type='hidden' name='autopsy_reqd_yn' id='autopsy_reqd_yn' value="<%=(String)(hashMap.get("autopsy_reqd_yn")==null?"":hashMap.get("autopsy_reqd_yn"))%>">
				<input type='hidden' name='mate_cond_main_cod' id='mate_cond_main_cod' value="<%=(String)(hashMap.get("mate_cond_main_cod")==null?"":hashMap.get("mate_cond_main_cod"))%>">
				<input type='hidden' name='mate_cond_main_cod_dur' id='mate_cond_main_cod_dur' value="<%=(String)(hashMap.get("mate_cond_main_cod_dur")==null?"":hashMap.get("mate_cond_main_cod_dur"))%>">
				<input type='hidden' name='mate_cond_oth_cod' id='mate_cond_oth_cod' value="<%=(String)(hashMap.get("mate_cond_oth_cod")==null?"":hashMap.get("mate_cond_oth_cod"))%>">
				<input type='hidden' name='mate_cond_oth_cod_dur' id='mate_cond_oth_cod_dur' value="<%=(String)(hashMap.get("mate_cond_oth_cod_dur")==null?"":hashMap.get("mate_cond_oth_cod_dur"))%>">
				<input type='hidden' name='mate_cond_preexist_cod' id='mate_cond_preexist_cod' value="<%=(String)(hashMap.get("mate_cond_preexist_cod")==null?"":hashMap.get("mate_cond_preexist_cod"))%>">
				<input type='hidden' name='mate_cond_preexist_cod_dur' id='mate_cond_preexist_cod_dur' value="<%=(String)(hashMap.get("mate_cond_preexist_cod_dur")==null?"":hashMap.get("mate_cond_preexist_cod_dur"))%>">
				<input type='hidden' name='oth_rel_mate_cond_rel_cod' id='oth_rel_mate_cond_rel_cod' value="<%=(String)(hashMap.get("oth_rel_mate_cond_rel_cod")==null?"":hashMap.get("oth_rel_mate_cond_rel_cod"))%>">
				<input type='hidden' name='oth_rel_mate_cond_rel_cod_dur' id='oth_rel_mate_cond_rel_cod_dur' value="<%=(String)(hashMap.get("oth_rel_mate_cond_rel_cod_dur")==null?"":hashMap.get("oth_rel_mate_cond_rel_cod_dur"))%>">
				<input type='hidden' name='cond_cau_dea_main_cod' id='cond_cau_dea_main_cod' value="<%=(String)(hashMap.get("cond_cau_dea_main_cod")==null?"":hashMap.get("cond_cau_dea_main_cod"))%>">
				<input type='hidden' name='cond_cau_dea_main_cod_dur' id='cond_cau_dea_main_cod_dur' value="<%=(String)(hashMap.get("cond_cau_dea_main_cod_dur")==null?"":hashMap.get("cond_cau_dea_main_cod_dur"))%>">
				<input type='hidden' name='cond_cau_dea_oth_cod' id='cond_cau_dea_oth_cod' value="<%=(String)(hashMap.get("cond_cau_dea_oth_cod")==null?"":hashMap.get("cond_cau_dea_oth_cod"))%>">
				<input type='hidden' name='cond_cau_dea_oth_cod_dur' id='cond_cau_dea_oth_cod_dur' value="<%=(String)(hashMap.get("cond_cau_dea_oth_cod_dur")==null?"":hashMap.get("cond_cau_dea_oth_cod_dur"))%>">
				<input type='hidden' name='cond_cau_dea_preexist_cod' id='cond_cau_dea_preexist_cod' value="<%=(String)(hashMap.get("cond_cau_dea_preexist_cod")==null?"":hashMap.get("cond_cau_dea_preexist_cod"))%>">
				<input type='hidden' name='cond_cau_dea_preexist_cod_dur' id='cond_cau_dea_preexist_cod_dur' value="<%=(String)(hashMap.get("cond_cau_dea_preexist_cod_dur")==null?"":hashMap.get("cond_cau_dea_preexist_cod_dur"))%>">
				<input type='hidden' name='rel_cond_cau_dea_rel_cod' id='rel_cond_cau_dea_rel_cod' value="<%=(String)(hashMap.get("rel_cond_cau_dea_rel_cod")==null?"":hashMap.get("rel_cond_cau_dea_rel_cod"))%>">
				<input type='hidden' name='rel_cond_cau_dea_rel_cod_dur' id='rel_cond_cau_dea_rel_cod_dur' value="<%=(String)(hashMap.get("rel_cond_cau_dea_rel_cod_dur")==null?"":hashMap.get("rel_cond_cau_dea_rel_cod_dur"))%>">
				<input type='hidden' name='called_from_mothercare' id='called_from_mothercare' value="<%=called_from_mothercare%>">
				<input type='hidden' name='apgar_score_changedYN' id='apgar_score_changedYN' value="N">
				<input type='hidden' name='data_upd_allowed_aft_final_yn' id='data_upd_allowed_aft_final_yn' value="<%=data_upd_allowed_aft_final_yn%>">
				<input type='hidden' name='q_finalized_yn' id='q_finalized_yn' value="<%=q_finalized_yn%>">
				<input type='hidden' name='still_brith_dtls_mand' id='still_brith_dtls_mand' value="">
				<input type='hidden' name='q_indicator_mark' id='q_indicator_mark' value="<%=(String)(hashMap.get("q_indicator_mark")==null?"":hashMap.get("q_indicator_mark"))%>">
				<input type='hidden' name='name_prefix_male_nb' id='name_prefix_male_nb' value="<%=name_prefix_male_nb%>">
				<input type='hidden' name='name_prefix_female_nb' id='name_prefix_female_nb' value="<%=name_prefix_female_nb%>">
				<!-- Below line Added by Afruddin for ML-MMOH-CRF-1520 US 0002 -->
				<input type='hidden' name='name_prefix_unknown_nb' id='name_prefix_unknown_nb' value="<%=name_prefix_unknown_nb%>">
				<input type='hidden' name='name_suffix_male_nb' id='name_suffix_male_nb' value="<%=name_suffix_male_nb%>">
				<input type='hidden' name='name_suffix_female_nb' id='name_suffix_female_nb' value="<%=name_suffix_female_nb%>">
				<input type='hidden' name='name_pfx_loc_lang_male_nb' id='name_pfx_loc_lang_male_nb' value="<%=name_pfx_loc_lang_male_nb%>">
				<input type='hidden' name='name_pfx_loc_lang_female_nb' id='name_pfx_loc_lang_female_nb' value="<%=name_pfx_loc_lang_female_nb%>">
				<!-- Below line Added by Afruddin for ML-MMOH-CRF-1520 US 0002 -->
				<input type='hidden' name='name_pfx_loc_lang_unknown_nb' id='name_pfx_loc_lang_unknown_nb' value="<%=name_pfx_loc_lang_unknown_nb%>">
				<input type='hidden' name='name_sfx_loc_lang_male_nb' id='name_sfx_loc_lang_male_nb' value="<%=name_sfx_loc_lang_male_nb%>">
				<input type='hidden' name='name_sfx_loc_lang_female_nb' id='name_sfx_loc_lang_female_nb' value="<%=name_sfx_loc_lang_female_nb%>">
				<input type='hidden' name='single_stage_nb_reg_appl_yn' id='single_stage_nb_reg_appl_yn' value="<%=single_stage_nb_reg_appl_yn%>">
				<input type='hidden' name='ca_comp_in_del_stage1' id='ca_comp_in_del_stage1' value="<%=ca_comp_in_del_stage1%>">
				<input type='hidden' name='ca_comp_in_del_stage2' id='ca_comp_in_del_stage2' value="<%=ca_comp_in_del_stage2%>">
				<input type='hidden' name='ca_comp_in_del_stage3' id='ca_comp_in_del_stage3' value="<%=ca_comp_in_del_stage3%>">
				<input type='hidden' name='ca_comp_of_delivery' id='ca_comp_of_delivery' value="<%=ca_comp_of_delivery%>">
				<input type='hidden' name='mother_patient_id_2' id='mother_patient_id_2' value="<%=mother_patient_id%>">
				<input type='hidden' name='MC_Dtls_YN' id='MC_Dtls_YN' value="<%=MC_Dtls_YN%>">
				<input type='hidden' name='lmp_ca' id='lmp_ca' value="<%=lmp_ca%>">
				<input type='hidden' name='mc_cycle_no' id='mc_cycle_no' value="<%=mc_cycle_no%>">
				<input type='hidden' name='nb_father_min_age' id='nb_father_min_age' value="<%=nb_father_min_age%>">
				<input type='hidden' name='newborn_pat_ser_grp' id='newborn_pat_ser_grp' value="<%=newborn_pat_ser_grp%>">
				<input type='hidden' name='allow_ext_nb_regn_within_days' id='allow_ext_nb_regn_within_days' value="<%=allow_ext_nb_regn_within_days%>">
				<input type='hidden' name='isAllow_External_Newborn' id='isAllow_External_Newborn' value="<%=isAllow_External_Newborn%>">
				<input type='hidden' name='nb_dflt_relnship_code' id='nb_dflt_relnship_code' value="<%=nb_dflt_relnship_code%>">
				<input type='hidden' name='siteId' id='siteId' value="<%=siteId%>">
				<input type='hidden' name='mthr_alt_id1_no' id='mthr_alt_id1_no' value="<%=checkForNull((String) mthrDtls.get("mthr_alt_id1_no"))%>">
				<input type='hidden' name='mthr_alt_id2_no' id='mthr_alt_id2_no' value="<%=checkForNull((String) mthrDtls.get("mthr_alt_id2_no"))%>">
				<input type='hidden' name='mthr_alt_id3_no' id='mthr_alt_id3_no' value="<%=checkForNull((String) mthrDtls.get("mthr_alt_id3_no"))%>">
				<input type='hidden' name='mthr_alt_id4_no' id='mthr_alt_id4_no' value="<%=checkForNull((String) mthrDtls.get("mthr_alt_id4_no"))%>">
				<input type='hidden' name='father_alt_id1_desc' id='father_alt_id1_desc' value="<%=checkForNull((String)mPParamDtls.get("alt_id1_type"))%>">
				<input type='hidden' name='father_alt_id2_desc' id='father_alt_id2_desc' value="<%=checkForNull((String)mPParamDtls.get("alt_id2_type"))%>">
				<input type='hidden' name='father_alt_id3_desc' id='father_alt_id3_desc' value="<%=checkForNull((String)mPParamDtls.get("alt_id3_type"))%>">
				<input type='hidden' name='father_alt_id4_desc' id='father_alt_id4_desc' value="<%=checkForNull((String)mPParamDtls.get("alt_id4_type"))%>">
				<input type='hidden' name='mthr_nat_id_no' id='mthr_nat_id_no' value="<%=checkForNull((String) mthrDtls.get("mthr_nat_id_no"))%>">
				<input type='hidden' name='mthr_oth_alt_id_No' id='mthr_oth_alt_id_No' value="<%=checkForNull((String) mthrDtls.get("mthr_oth_alt_id_No"))%>">
				<input type='hidden' name='oth_alt_id_type' id='oth_alt_id_type' value="<%=checkForNull((String) mthrDtls.get("mthr_oth_alt_id_type"))%>">
				<input type='hidden' name='still_born_prefix' id='still_born_prefix' value="<%=still_born_prefix%>">
				<input type='hidden' name='dflt_race_nat_setup' id='dflt_race_nat_setup' value="<%=dflt_race_nat_setup%>">
				<input type='hidden' name='citizen_nationality_code' id='citizen_nationality_code' value="<%=citizen_nationality_code%>">
				<input type='hidden' name='default_race_code' id='default_race_code' value="<%=default_race_code%>">
                <input type='hidden' name='nb_mother_dtls_update_yn' id='nb_mother_dtls_update_yn' value="<%=nb_mother_dtls_update_yn%>">
				<input type='hidden' name='calling_module_id' id='calling_module_id' value="<%=calling_module_id%>"> 
				<input type='hidden' name='disable_button_yn' id='disable_button_yn' value="<%=disable_button_yn%>"> 
				<input type='hidden' name='finalize_yn' id='finalize_yn' value="<%=finalizeYN%>">
				<input type='hidden' name='multibirthvalue' id='multibirthvalue' value="<%=multibirthvalue%>"><!-- added by krishna pranay ML-MMOH-CRF-1759.1 -->
				<input type='hidden' name='regnStatus' id='regnStatus' value="<%=regnStatus%>">
				<input type='hidden' name='birth_order_format' id='birth_order_format' value="<%=birth_order_format%>">
				<input type='hidden' name='isLabelChangeApplicable' id='isLabelChangeApplicable' value="<%=isLabelChangeApplicable%>"><!--Added by Rameswar on 23rd June 2015 against HSA-CRF-0223 IN050565-->
				<input type='hidden' name='isRegNewbornApplicable' id='isRegNewbornApplicable' value="<%=isRegNewbornApplicable%>">
                 <input type='hidden' name='accept_national_id_no_yn' id='accept_national_id_no_yn' value="<%=accept_national_id_no_yn%>">
                 <input type='hidden' name='national_id_no' id='national_id_no' value="<%=cd3%>"> 				 
				 <input type='hidden' name='newborn_birth_order' id='newborn_birth_order' value="<%=newborn_birth_order%>"> 
                 <input type='hidden' name="multiple_birth_patname" id="multiple_birth_patname" value=""> 
                 <input type='hidden' name="nameprefix" id="nameprefix" value="">
                 <input type='hidden' name="firstNamederieved" id="firstNamederieved" value="">
                 <input type='hidden' name="familyderievedName" id="familyderievedName" value="">
				 <input type='hidden' name="emer_regn_nb_yn" id="emer_regn_nb_yn" value="<%=emer_regn_nb_yn%>"> <!-- Added by Sangeetha for ML-MMOH-CRF-0631 on 14/Aug/17-->
				 <input type='hidden' name="isNewBornChngsAppl" id="isNewBornChngsAppl" value="<%=isNewBornChngsAppl%>">
				<!-- Added by Kamatchi S for ML-MMOH-CRF-2095-->
				 <input type='hidden' name="length_of_baby_yn" id="length_of_baby_yn" value="<%=length_of_baby_yn%>">
				 <input type='hidden' name="head_circumference_of_baby_yn" id="head_circumference_of_baby_yn" value="<%=head_circumference_of_baby_yn%>">
				 <input type='hidden' name="isMPMandatoryFieldsNewborn" id="isMPMandatoryFieldsNewborn" value="<%=isMPMandatoryFieldsNewborn%>"> 
				 <input type='hidden' name="mandate_first_newborn_ip_yn" id="mandate_first_newborn_ip_yn" value="<%=mandate_first_newborn_ip_yn%>">
				 <input type='hidden' name="mandate_second_newborn_ip_yn" id="mandate_second_newborn_ip_yn" value="<%=mandate_second_newborn_ip_yn%>">
				 <input type='hidden' name="mandate_third_newborn_ip_yn" id="mandate_third_newborn_ip_yn" value="<%=mandate_third_newborn_ip_yn%>">
				 <input type='hidden' name="mand_antenatal_newborn_ip_yn" id="mand_antenatal_newborn_ip_yn" value="<%=mand_antenatal_newborn_ip_yn%>">
				 <input type='hidden' name="mandate_first_newborn_yn" id="mandate_first_newborn_yn" value="<%=mandate_first_newborn_yn%>">
				 <input type='hidden' name="mandate_second_newborn_yn" id="mandate_second_newborn_yn" value="<%=mandate_second_newborn_yn%>">
				 <input type='hidden' name="mandate_third_newborn_yn" id="mandate_third_newborn_yn" value="<%=mandate_third_newborn_yn%>">
				 <input type='hidden' name="mand_antenatal_newborn_yn" id="mand_antenatal_newborn_yn" value="<%=mand_antenatal_newborn_yn%>">
				 <input type='hidden' name="mandate_first_newborn_ae_yn" id="mandate_first_newborn_ae_yn" value="<%=mandate_first_newborn_ae_yn%>">
				 <input type='hidden' name="mandate_second_newborn_ae_yn" id="mandate_second_newborn_ae_yn" value="<%=mandate_second_newborn_ae_yn%>">
				 <input type='hidden' name="mandate_third_newborn_ae_yn" id="mandate_third_newborn_ae_yn" value="<%=mandate_third_newborn_ae_yn%>">
				 <input type='hidden' name="mand_antenatal_newborn_ae_yn" id="mand_antenatal_newborn_ae_yn" value="<%=mand_antenatal_newborn_ae_yn%>">
				 <input type='hidden' name="emer_regn_nb" id="emer_regn_nb" value="<%=emer_regn_nb%>">
				 <input type='hidden' name="ip_regn_nb_yn" id="ip_regn_nb_yn" value="<%=ip_regn_nb_yn%>">
				 <input type='hidden' name="mp_regn_nb_yn" id="mp_regn_nb_yn" value="<%=mp_regn_nb_yn%>">
				 <input type='hidden' name="dflt_father_first_name_prompt" id="dflt_father_first_name_prompt" value="<%=dflt_father_first_name_prompt%>">
				 <input type='hidden' name="dflt_father_Second_name_prompt" id="dflt_father_Second_name_prompt" value="<%=dflt_father_Second_name_prompt%>">
				 <input type='hidden' name="dflt_father_third_name_prompt" id="dflt_father_third_name_prompt" value="<%=dflt_father_third_name_prompt%>">
				 <input type='hidden' name="dflt_father_family_name_prompt" id="dflt_father_family_name_prompt" value="<%=dflt_father_family_name_prompt%>">
				 <input type='hidden' name="names_in_oth_lang_yn" id="names_in_oth_lang_yn" value="<%=names_in_oth_lang_yn%>">
				 <input type='hidden' name="First_Name_Reqd_Yn" id="First_Name_Reqd_Yn" value="<%=First_Name_Reqd_Yn%>">
				 <input type='hidden' name="Second_Name_Reqd_Yn" id="Second_Name_Reqd_Yn" value="<%=Second_Name_Reqd_Yn%>">
				 <input type='hidden' name="Third_Name_Reqd_Yn" id="Third_Name_Reqd_Yn" value="<%=Third_Name_Reqd_Yn%>">
				 <input type='hidden' name="Family_Name_Reqd_Yn" id="Family_Name_Reqd_Yn" value="<%=Family_Name_Reqd_Yn%>">
				 <input type='hidden' name="Name_Prefix_Accept_Yn" id="Name_Prefix_Accept_Yn" value="<%=Name_Prefix_Accept_Yn%>">
				 <input type='hidden' name="Name_Prefix_Reqd_Yn" id="Name_Prefix_Reqd_Yn" value="<%=Name_Prefix_Reqd_Yn%>">
				  <input type='hidden' name="Name_Suffix_Accept_Yn" id="Name_Suffix_Accept_Yn" value="<%=Name_Suffix_Accept_Yn%>">
				 <input type='hidden' name="Name_Suffix_Reqd_Yn" id="Name_Suffix_Reqd_Yn" value="<%=Name_Suffix_Reqd_Yn%>">
				 <input type='hidden' name="mpDisableFieldsNBFather" id="mpDisableFieldsNBFather" value="<%=mpDisableFieldsNBFather%>">
				 <input type='hidden' name="nb_father_name_mandatory_yn" id="nb_father_name_mandatory_yn" value="<%=nb_father_name_mandatory_yn%>">
				 <input type='hidden' name="enable_marital_status" id="enable_marital_status" value="<%=enable_marital_status%>">
				 <input type='hidden' name="invokeMenstrualHistYN" id="invokeMenstrualHistYN" value="<%=invokeMenstrualHistYN%>">  <!-- 68508 -->
				 <input type='hidden' name="mandParityNewBornYN" id="mandParityNewBornYN" value="<%=mandParityNewBornYN%>">      <!-- 68508 -->
				 <input type='hidden' name="mandParityNewBornAE_YN" id="mandParityNewBornAE_YN" value="<%=mandParityNewBornAE_YN%>"><!-- 68508 -->
				 <input type='hidden' name="mandParityNewBornIP_YN" id="mandParityNewBornIP_YN" value="<%=mandParityNewBornIP_YN%>"><!-- 68508 -->
				 <input type='hidden' name="isModifyLongShortDescAppl" id="isModifyLongShortDescAppl" value="<%=isModifyLongShortDescAppl%>"> <!--Modified by Ashwini on 01-Feb-2019 for ML-MMOH-CRF-1109-->
				 <!--Added by Ashwini on 12-Oct-2020 for ML-MMOH-CRF-1551-->  
				 <input type='hidden' name="isNameDervnLogicNBAppl" id="isNameDervnLogicNBAppl" value="<%=isNameDervnLogicNBAppl%>">
				 <input type='hidden' name="nb_derv_logic_appl" id="nb_derv_logic_appl" value="N"> 

				 <input type='hidden' name="accession_num_nb_note" id="accession_num_nb_note" value="<%=checkForNull((String)hashMap.get("accession_num_nb_note"))%>">
				<script>
					<%if(q_finalized_yn.equals("Y") && "N".equals(data_upd_allowed_aft_final_yn) && isNewBornChngsAppl && "MAINTAIN_BIRTH".equals(function_id) && checkForNull((String)hashMap.get("accession_num_nb_note")).equals("")){%>	
						parent.frames[1].document.getElementById('btnNewbornAssessmentNote').disabled=true;
					<%}%>
				</script>
				
				<% if(invoked_from.equals("details_page") && regnStatus.equals("R") && finalizeYN.equals("Y")) {
					out.println("<script>if(document.forms[0].nod_type){enDisCompls(document.forms[0].nod_type.value,'N')}</script>");
				} %>
				<%if(single_stage_nb_reg_appl_yn.equals("Y")) {%>
					<input type='hidden' name='finalized_yn' id='finalized_yn' value="Y">					
				<%} else if(single_stage_nb_reg_appl_yn.equals("N")) {%>
					<input type='hidden' name='finalized_yn' id='finalized_yn' value="<%=finalizeYN%>">				
				<%}%>
				
				<%if(invoked_from.equals("details_page") && regnStatus.equals("R") && finalizeYN.equals("Y")) {%>
					<input type='hidden' name='refreshFramesYN' id='refreshFramesYN' value="Y">					
				<%} else {%>
					<input type='hidden' name='refreshFramesYN' id='refreshFramesYN' value="N">				
				<%}%>
				<%if(!function_id.equals("REGISTER_NEWBORN")){	%>
				<script>
					setTimeout('getRelationShip(document.forms[0].new_born_sex,"Y");',100);					
					document.forms[0].sltRelationship.value='<%=relation_mcode%>'
				</script>
				<%}%>
				<script>
				<!--Below line Added for this CRF HSA-CRF-0182 -->
				   if('<%=nb_mother_dtls_update_yn%>'=="Y"&&'<%=disable_button_yn%>'=="N"&&'<%=finalized_mult_birth_yn%>'=="Y"){document.forms[0].remarks.disabled=true;}
			 
				   if('<%=nb_mother_dtls_update_yn%>'=="Y" && '<%=finalizeYN%>'!="Y"&&'<%=disable_button_yn%>'!="Y" && '<%=regnStatus%>'!="R"){ enDisCompls(document.forms[0].nod_type.value,'N')}
				   <!--End HSA-CRF-0182 -->
					
				if("<%=function_id1%>" != '')
				{
					<% if(called_function.equals("IP") || called_function.equals("AE")) { %> //Modified by Dharma on Aug 3rd 2017 against ML-MMOH-CRF-0631 [IN:062148]
				
					if(parent.parent.frames[0].document.forms[0].home)
						parent.parent.frames[0].document.forms[0].home.disabled = true;
					if(parent.parent.frames[0].document.forms[0].reset)
						parent.parent.frames[0].document.forms[0].reset.disabled = false;
					<% } %>
				}
			</script>
				
		</form>
			<%
			if(function_id.equals("MAINTAIN_BIRTH") && !invoked_from.equals("details_page")) {
				String pat_ser_grp_code = checkForNull((String)hashMap.get("q_pat_ser_grp_code"));
				String pat_ser_grp_desc = checkForNull((String)hashMap.get("q_pat_ser_grp_desc"));
				%>
				<script>
					if(parent.newbornheader_frame) {					
						if(parent.newbornheader_frame.document.getElementById("pat_ser_grp_code")) {						
							parent.newbornheader_frame.document.getElementById("pat_ser_grp_code").value = '<%=pat_ser_grp_code%>';
						}
						if(parent.newbornheader_frame.document.getElementById('pat_ser_grp_code_desc')) {						
							parent.newbornheader_frame.document.getElementById('pat_ser_grp_code_desc').value = '<%=pat_ser_grp_desc%>';
						}
					}
				</script>
			<%
			}
			%>	
	<script> 			
		<%				
					column_name  = CommonBean.getFunctionFieldRestriction(con, "MP","NEWBORN_REG","MP_BIRTH_REGISTER","Y","Y"); 
					Iterator itr = column_name.iterator();
					while(itr.hasNext()){	
					field_name=(String)itr.next();
					
					if(field_name.equals("PATENCY_OF_ANUS_YN")){
						out.println("document.getElementById('patency_visibility').value='Y';");
						out.println("eval(document.getElementById(field_name+'_IMG')).style.visibility = 'visible'");
					}else if(field_name.equals("APGAR_SCORE_IN_5_MINS_YN")){
						out.println("document.getElementById('apgar5_visibility').value='Y';");
						out.println("eval(document.getElementById('" + field_name + "_IMG')).style.visibility = 'visible'");
					}else if(field_name.equals("APGAR_SCORE_IN_10_MINS_YN")){
						out.println("document.getElementById('apgar10_visibility').value='Y';");
						out.println("eval(document.getElementById(field_name+'_IMG').style.visibility = 'visible'");
					}
					
					}
			if(!function_id.equals("REGISTER_NEWBORN")) {
				//Santhosh added for ML-MMOH-CRF-1895
				if(function_id.equals("MAINTAIN_BIRTH") && isApgarScoreMinsAppl){
					
					out.println("document.getElementById('apgar5_visibility').value='Y';");
					out.println("document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility = 'visible'");
					if(((String) hashMap.get("q_outcome")).equals("S")){
						out.println("document.getElementById('apg').style.visibility	= 'hidden';");
						out.println("document.getElementById('apg').innerHTML	= ''; ");								
						out.println("if(document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility='hidden';");
						out.println("if(document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG').style.visibility='hidden';");

						out.println("document.forms[0].patency_of_anus_yn.disabled	= true;					document.forms[0].patency_of_anus_yn.options[0].selected = true;");
						out.println("if(document.getElementById('PATENCY_OF_ANUS_YN_IMG'))						document.getElementById('PATENCY_OF_ANUS_YN_IMG').style.visibility='hidden';");
					}
					//Santhosh End
				}else if(((String) hashMap.get("q_outcome")).equals("S")||!((String) hashMap.get("q_bba_yn")).equals("I")) {	
					
					out.println("document.getElementById('apg').style.visibility	= 'hidden';");
					
					out.println("document.getElementById('apg').innerHTML	= ''; ");
					out.println("if(document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility='hidden';");
					out.println("if(document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG').style.visibility='hidden';");
					
					out.println("document.forms[0].patency_of_anus_yn.disabled	= true;					document.forms[0].patency_of_anus_yn.options[0].selected = true;");
					out.println("if(document.getElementById('PATENCY_OF_ANUS_YN_IMG'))						document.getElementById('PATENCY_OF_ANUS_YN_IMG').style.visibility='hidden';");
				}
				
			} else if(function_id.equals("REGISTER_NEWBORN") && isApgarScoreMinsAppl){
				//Santhosh added for ML-MMOH-CRF-1895
				out.println("if(document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_5_MINS_YN_IMG').style.visibility='hidden';");
					out.println("if(document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG'))						document.getElementById('APGAR_SCORE_IN_10_MINS_YN_IMG').style.visibility='hidden';");
			}
			//Santhosh End
			if(rs1!=null)
				rs1.close();
			if(stmt!=null)
				stmt.close();
		%>
	</script>
	<script>
if("<%=isRegNewbornApplicable%>"=="true" && document.getElementById('father_dtls_link')!=null){
	     document.getElementById('father_dtls_link').onclick();          
}
if("<%=isRegNewbornApplicable%>"=="true"){ 
         
		  var babyoutcome="";
		  var babyborn_where="";
		 if(document.forms[0].outcome.disabled){
			 document.forms[0].outcome.disabled = false;
			 babyoutcome=document.forms[0].outcome.value; 
			 babyborn_where=document.forms[0].born_where.value; 
			 document.forms[0].outcome.disabled = true;
		 }else{
			 babyoutcome=document.forms[0].outcome.value; 
			 babyborn_where=document.forms[0].born_where.value; 
		 }
		
if("<%=newbornReg%>"=="N" && babyoutcome =="L" && babyborn_where=="I")	{ 
		 document.forms[0].CIRCUMFERENCE_IMG.style.visibility='visible';	 
		 document.forms[0].LENGTH_IMG.style.visibility='visible';
    }
if("<%=newbornReg%>"=="N" && (babyoutcome!="L" || babyborn_where!="I"))	{ 
	 document.forms[0].CIRCUMFERENCE_IMG.style.visibility='hidden';	 
     document.forms[0].LENGTH_IMG.style.visibility='hidden';
	}
	
}
	function OnPaste() {
            return false;   // cancels the onpaste event
     }
	</script>
	</body>
</html>
<%
		array_list.clear();
		hashMap3.clear();
		hashMap10.clear();hashMap11.clear();hashMap12.clear();hashMap13.clear();
	}
	catch(Exception e)
	{
		//out.println("Exception in main"+e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	} 
%>
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

