<!DOCTYPE html>
<!--
	File Name	:	mp_param_form_include.jsp
	Created On :	9/13/2006 10:30 AM
	Created By	:	Vinod Babu M.V
	Purpose		:	A part of mp_param_form.jsp is removed and included dyanmically in using this file to avoid verify Error.
	-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" import="java.sql.*,java.util.*,webbeans.eCommon.*,eXH.InterfaceUtil"  %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eMP/js/mp_param.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<Script>
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
            parent.frames[1].tab10.scrollIntoView();
		else if(id == 'aadhar_tab')
            parent.frames[1].tab11.scrollIntoView();
		}

		function allowNumOnly(event) {
			var strCheck = '0123456789';
			var whichCode = (window.Event) ? event.which : event.keyCode;
			key = String.fromCharCode(whichCode);  // Get key value from key code
			if (strCheck.indexOf(key) == -1)
				return false;  
			else
				return true ;			
		}

		function chkValue(obj) {
			if(obj.value!="")
			{
				if(obj.value<1)
				{
					alert(getMessage("INVALID_POSITIVE_NUMBER","COMMON"));
					obj.select();
				}
			}
		}

		function aadharConfig(checkbox) {

			var radios = document.getElementsByName('aadhar_option_value');
			var index = 0, length = radios.length;
			if (checkbox.checked == false) {
				for ( ; index < length; index++) {
					radios[index].disabled = "disabled";
				}
			}
			else {
				index = 0;
				for ( ; index < length; index++) {
					radios[index].disabled = "";
				}
			}
		}

</Script>

<style type="text/css">

#altidcs {  width:830px; height:510px;}

#altidleg {height:510px;}
</style>
<% 
	Connection con=null ;
try
	{
	request.setCharacterEncoding("UTF-8");
    PreparedStatement pstmt=null;
    ResultSet rs=null;
	java.sql.Statement stmt11 = null;
    ResultSet rset11 = null;
	java.sql.Statement stmt = null ;
    ResultSet rset = null;
    con = ConnectionManager.getConnection(request);
	String locale = checkForNull((String)session.getAttribute("LOCALE"));
	 String pat_search_tab=checkForNull( request.getParameter("pat_search_tab"));
    String operation             =	checkForNull( request.getParameter( "operation") );
	String alt_id1_accept_alphanumeric_yn     =	checkForNull( request.getParameter( "alt_id1_accept_alphanumeric_yn") );
	String Accept_oth_alt_id_yn          = checkForNull( request.getParameter( "Accept_oth_alt_id_yn")) ;
	String alt_id1_accept_oth_pat_ser_yn          = checkForNull( request.getParameter( "alt_id1_accept_oth_pat_ser_yn")) ;
	/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start*/

	String alt_id2_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id2_accept_oth_pat_ser_yn"),"N");
	String alt_id2_chng_allowed_yn					= checkForNull(request.getParameter("alt_id2_chng_allowed_yn"),"N");
	String alt_id2_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id2_accept_alphanumeric_yn"),"N");
	String alt_id3_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id3_accept_oth_pat_ser_yn"),"N");
	String alt_id3_chng_allowed_yn					= checkForNull(request.getParameter("alt_id3_chng_allowed_yn"),"N");
	String alt_id3_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id3_accept_alphanumeric_yn"),"N");
	String alt_id4_accept_oth_pat_ser_yn			= checkForNull(request.getParameter("alt_id4_accept_oth_pat_ser_yn"),"N");
	String alt_id4_chng_allowed_yn					= checkForNull(request.getParameter("alt_id4_chng_allowed_yn"),"N");
	String alt_id4_accept_alphanumeric_yn			= checkForNull(request.getParameter("alt_id4_accept_alphanumeric_yn"),"N");

		
	String alt_id2_accept_oth_pat_ser_dis_chk	= (alt_id2_accept_oth_pat_ser_yn.equals("Y")?"checked disabled":"disabled");   
	String alt_id2_chng_allowed_dis_chk			= (alt_id2_chng_allowed_yn.equals("Y")?"checked disabled":"disabled");         
	String alt_id2_accept_alphanumeric_dis_chk	= (alt_id2_accept_alphanumeric_yn.equals("Y")?"checked disabled":"disabled");  
	String alt_id3_accept_oth_pat_ser_dis_chk	= (alt_id3_accept_oth_pat_ser_yn.equals("Y")?"checked disabled":"disabled");   
	String alt_id3_chng_allowed_dis_chk			= (alt_id3_chng_allowed_yn.equals("Y")?"checked disabled":"disabled");         
	String alt_id3_accept_alphanumeric_dis_chk	= (alt_id3_accept_alphanumeric_yn.equals("Y")?"checked disabled":"disabled");  
	String alt_id4_accept_oth_pat_ser_dis_chk	= (alt_id4_accept_oth_pat_ser_yn.equals("Y")?"checked disabled":"disabled");   
	String alt_id4_chng_allowed_dis_chk			= (alt_id4_chng_allowed_yn.equals("Y")?"checked disabled":"disabled");         
	String alt_id4_accept_alphanumeric_dis_chk	= (alt_id4_accept_alphanumeric_yn.equals("Y")?"checked disabled":"disabled");  

	/*Added by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End*/



	
	 String Checkedchk="";//Added for HSA-CRF-0182

	String module_instal_ind=checkForNull( request.getParameter( "module_instal_ind"));
	String alt_id1_type             =	checkForNull( request.getParameter( "alt_id1_type") );
	String alt_id2_type             =	checkForNull( request.getParameter( "alt_id2_type") );
	String alt_id3_type             =	checkForNull( request.getParameter( "alt_id3_type") );
	String alt_id4_type             =	checkForNull( request.getParameter( "alt_id4_type") );
//	int intval=0;

	//String display_new_born_age_in _hr=	checkForNull( request.getParameter( "display_new_born_age_in _hr"));
	String alt_id1_chk_digit_scheme              =	checkForNull( request.getParameter( "alt_id1_chk_digit_scheme") );
	String alt_id2_chk_digit_scheme             =	checkForNull( request.getParameter( "alt_id2_chk_digit_scheme") );
	String alt_id3_chk_digit_scheme             =	checkForNull( request.getParameter( "alt_id3_chk_digit_scheme") );
	String alt_id4_chk_digit_scheme             =	checkForNull( request.getParameter( "alt_id4_chk_digit_scheme") );

	String alt_id1_length              =	checkForNull( request.getParameter( "alt_id1_length") );
	String alt_id2_length              =	checkForNull( request.getParameter( "alt_id2_length") );
	String alt_id3_length              =	checkForNull( request.getParameter( "alt_id3_length") );
	String alt_id4_length              =	checkForNull( request.getParameter( "alt_id4_length") );
	String alt_id1_len_validation_yn             =	checkForNull( request.getParameter( "alt_id1_len_validation_yn") );
	String alt_id2_len_validation_yn             =	checkForNull( request.getParameter( "alt_id2_len_validation_yn") );
	String alt_id3_len_validation_yn             =	checkForNull( request.getParameter( "alt_id3_len_validation_yn") );
	String alt_id4_len_validation_yn             =	checkForNull( request.getParameter( "alt_id4_len_validation_yn") );
	String alt_id1_reqd_yn              =	checkForNull( request.getParameter( "alt_id1_reqd_yn") );
	String alt_id2_reqd_yn              =	checkForNull( request.getParameter( "alt_id2_reqd_yn") );
	String alt_id3_reqd_yn              =	checkForNull( request.getParameter( "alt_id3_reqd_yn") );
	String alt_id4_reqd_yn              =	checkForNull( request.getParameter( "alt_id4_reqd_yn") );
	String alt_id1_unique_yn              =	checkForNull( request.getParameter( "alt_id1_unique_yn") );
	String alt_id2_unique_yn              =	checkForNull( request.getParameter( "alt_id2_unique_yn") );
	String alt_id3_unique_yn              =	checkForNull( request.getParameter( "alt_id3_unique_yn") );
	String alt_id4_unique_yn              =	checkForNull( request.getParameter( "alt_id4_unique_yn") );
	String alt_id1_exp_date_accept_yn             =	checkForNull( request.getParameter( "alt_id1_exp_date_accept_yn") );
	String alt_id2_exp_date_accept_yn             =	checkForNull( request.getParameter( "alt_id2_exp_date_accept_yn") );
	String alt_id3_exp_date_accept_yn             =	checkForNull( request.getParameter( "alt_id3_exp_date_accept_yn") );
	String alt_id4_exp_date_accept_yn             =	checkForNull( request.getParameter( "alt_id4_exp_date_accept_yn") );
	String alt_id1_exp_warn_yn             =	checkForNull( request.getParameter( "alt_id1_exp_warn_yn") );
	String alt_id2_exp_warn_yn             =	checkForNull( request.getParameter( "alt_id2_exp_warn_yn") );
	String alt_id3_exp_warn_yn             =	checkForNull( request.getParameter( "alt_id3_exp_warn_yn") );
	String alt_id4_exp_warn_yn             =	checkForNull( request.getParameter( "alt_id4_exp_warn_yn") );
	String alt_id1_invoke_routine             =	checkForNull( request.getParameter( "alt_id1_invoke_routine") );
	String alt_id2_invoke_routine             =	checkForNull( request.getParameter( "alt_id2_invoke_routine") );
	String alt_id3_invoke_routine             =	checkForNull( request.getParameter( "alt_id3_invoke_routine") );
	String alt_id4_invoke_routine             =	checkForNull( request.getParameter( "alt_id4_invoke_routine") );
	String alt_id1_routine_name             =	checkForNull( request.getParameter( "alt_id1_routine_name") );
	String alt_id2_routine_name             =	checkForNull( request.getParameter( "alt_id2_routine_name") );
	String alt_id3_routine_name             =	checkForNull( request.getParameter( "alt_id3_routine_name") );
	String alt_id4_routine_name             =	checkForNull( request.getParameter( "alt_id4_routine_name") );
	String alt_id1_adv_alert_reqd_yn             =	checkForNull( request.getParameter( "alt_id1_adv_alert_reqd_yn") );
	String alt_id2_adv_alert_reqd_yn             =	checkForNull( request.getParameter( "alt_id2_adv_alert_reqd_yn") );
	String alt_id3_adv_alert_reqd_yn             =	checkForNull( request.getParameter( "alt_id3_adv_alert_reqd_yn") );
	String alt_id4_adv_alert_reqd_yn             =	checkForNull( request.getParameter( "alt_id4_adv_alert_reqd_yn") );
	String alt_id1_adv_alert_days             =	checkForNull( request.getParameter( "alt_id1_adv_alert_days") );
	String alt_id2_adv_alert_days             =	checkForNull( request.getParameter( "alt_id2_adv_alert_days") );
	String alt_id3_adv_alert_days             =	checkForNull( request.getParameter( "alt_id3_adv_alert_days") );
	String alt_id4_adv_alert_days             =	checkForNull( request.getParameter( "alt_id4_adv_alert_days") );

	String alt_id1_exp_grace_days             =	checkForNull( request.getParameter( "alt_id1_exp_grace_days") );
	String alt_id2_exp_grace_days             =	checkForNull( request.getParameter( "alt_id2_exp_grace_days") );
	String alt_id3_exp_grace_days             =	checkForNull( request.getParameter( "alt_id3_exp_grace_days") );
	String alt_id4_exp_grace_days             =	checkForNull( request.getParameter( "alt_id4_exp_grace_days") );

	String allow_nb_regn_within_days     = checkForNull( request.getParameter( "allow_nb_regn_within_days") );
	String allow_nb_regn_unit     = checkForNull( request.getParameter( "allow_nb_regn_unit") );
	String mul_birth_regn_within_hours     = checkForNull( request.getParameter( "mul_birth_regn_within_hours") );
	String nb_use_mother_ser     = checkForNull( request.getParameter( "nb_use_mother_ser") );
	String review_nb_links_bef_reg_yn     = checkForNull( request.getParameter( "review_nb_links_bef_reg_yn") );
	String single_stage_nb_reg_appl_yn     = checkForNull( request.getParameter( "single_stage_nb_reg_appl_yn") );
	String min_age_of_moth      = checkForNull( request.getParameter( "min_age_of_moth") );
	String max_age_of_moth      = checkForNull( request.getParameter( "max_age_of_moth") );
	String cut_age_of_moth      = checkForNull( request.getParameter( "cut_age_of_moth") );
	String min_age_of_fath      = checkForNull( request.getParameter( "min_age_of_fath") );
//	String invoke_chg_pat_dtls_fm_nb_yn      = checkForNull( request.getParameter( "invoke_chg_pat_dtls_fm_nb_yn") );
	String min_weight      = checkForNull( request.getParameter( "min_weight") );
	String max_weight      = checkForNull( request.getParameter( "max_weight") );
	String unit_of_wt_nb      = checkForNull( request.getParameter( "unit_of_wt_nb") );
	String min_length      = checkForNull( request.getParameter( "min_length") );
	String max_length      = checkForNull( request.getParameter( "max_length") );
	String unit_of_circum_nb      = checkForNull( request.getParameter( "unit_of_circum_nb") );
	String min_head_circum      = checkForNull( request.getParameter( "min_head_circum") );
	String max_head_circum      = checkForNull( request.getParameter( "max_head_circum") );
	String unit_of_length_nb      = checkForNull( request.getParameter( "unit_of_length_nb") );
	String min_chest_circum      = checkForNull( request.getParameter( "min_chest_circum") );
	String max_chest_circum      = checkForNull( request.getParameter( "max_chest_circum") );
	String unit_of_chest_circum_nb      = checkForNull( request.getParameter( "unit_of_chest_circum_nb") );
	String min_gestation      = checkForNull( request.getParameter( "min_gestation") );
	String max_gestation      = checkForNull( request.getParameter( "max_gestation") );
	String unit_of_gest_nb      = checkForNull( request.getParameter( "unit_of_gest_nb") );
	String sub_multi_birth_hw      = checkForNull( request.getParameter( "sub_multi_birth_hw"),"H" );
	if(sub_multi_birth_hw=="")sub_multi_birth_hw="H";	
	String gestation_two_del      = checkForNull( request.getParameter( "gestation_two_del") );
	String name_prefix_male_nb      = checkForNull( request.getParameter( "name_prefix_male_nb") );
	String name_prefix_female_nb      = checkForNull( request.getParameter( "name_prefix_female_nb") );
	String name_suffix_male_nb      = checkForNull( request.getParameter( "name_suffix_male_nb") );
	String name_suffix_female_nb      = checkForNull( request.getParameter( "name_suffix_female_nb") );
	String still_born_prefix      = checkForNull( request.getParameter( "still_born_prefix") );
	String pat_photo_renewal_alert_days      = checkForNull( request.getParameter( "pat_photo_renewal_alert_days") );

	String nb_father_name_mandatory_yn =  checkForNull( request.getParameter( "nb_father_name_mandatory_yn"),"N" );
	String nb_mother_dtls_update_yn =  checkForNull( request.getParameter( "nb_mother_dtls_update_yn"),"N" );//Added for HSA-CRF-0182
	if(nb_mother_dtls_update_yn.equals("Y")) Checkedchk="checked";//Added for HSA-CRF-0182
	String data_upd_allowed_aft_final_yn  =  checkForNull( request.getParameter( "data_upd_allowed_aft_final_yn"),"N" );

	String accept_names_for_live_birth_yn =   checkForNull( request.getParameter( "accept_names_for_live_birth_yn"),"Y" );

	String dflt_race_nat_setup_nb_as_per=   checkForNull( request.getParameter( "dflt_race_nat_setup_nb_as_per"),"M" );

	String dft_rel_male_nb      = checkForNull( request.getParameter( "dft_rel_male_nb") );
	String dft_rel_female_nb      = checkForNull( request.getParameter( "dft_rel_female_nb") );
	String dft_rel_unknown_nb      = checkForNull( request.getParameter( "dft_rel_unknown_nb") );
	String addl_field1_prompt      = checkForNull( request.getParameter( "addl_field1_prompt") );
	String addl_field2_prompt      = checkForNull( request.getParameter( "addl_field2_prompt") );
	String addl_field3_prompt      = checkForNull( request.getParameter( "addl_field3_prompt") );
	String addl_field4_prompt      = checkForNull( request.getParameter( "addl_field4_prompt") );
	String addl_field5_prompt      = checkForNull( request.getParameter( "addl_field5_prompt") );
	String addl_field1_length      = checkForNull( request.getParameter( "addl_field1_length") );
	String addl_field2_length      = checkForNull( request.getParameter( "addl_field2_length") );
	String addl_field3_length      = checkForNull( request.getParameter( "addl_field3_length") );
	String addl_field4_length      = checkForNull( request.getParameter( "addl_field4_length") );
	String addl_field5_length      = checkForNull( request.getParameter( "addl_field5_length") );
	String display_new_born_age= checkForNull( request.getParameter( "display_new_born_age"));
	String sec11      = checkForNull( request.getParameter( "sec11") );
	String sec12      = checkForNull( request.getParameter( "sec12") );
	String sec13      = checkForNull( request.getParameter( "sec13") );
	String sec21      = checkForNull( request.getParameter( "sec21") );
	String sec22      = checkForNull( request.getParameter( "sec22") );
	String sec23      = checkForNull( request.getParameter( "sec23") );
	String sec31      = checkForNull( request.getParameter( "sec31") );
	String sec32      = checkForNull( request.getParameter( "sec32") );
	String sec33      = checkForNull( request.getParameter( "sec33") );
	String sec41      = checkForNull( request.getParameter( "sec41") );
	String sec42      = checkForNull( request.getParameter( "sec42") );
	String sec43      = checkForNull( request.getParameter( "sec43") );
	String sec51      = checkForNull( request.getParameter( "sec51") );
	String sec52      = checkForNull( request.getParameter( "sec52") );
	String sec53      = checkForNull( request.getParameter( "sec53") );
	String alt_id1_chng_allowed_yn      = checkForNull( request.getParameter( "alt_id1_chng_allowed_yn"),"N" );
//String display_new_born_age_in _hrs== checkForNull( request.getParameter( "display_new_born_age_in _hrs") );

	String dflt_relgn_code      = checkForNull( request.getParameter( "dflt_relgn_code") );
	String citizen_nationality_code      = checkForNull( request.getParameter( "citizen_nationality_code") );
	String default_race_code      = checkForNull( request.getParameter( "default_race_code") );
	
	String default_relationship_code      = checkForNull( request.getParameter( "default_relationship_code") );
	String max_patient_age      = checkForNull( request.getParameter( "max_patient_age") );
	String dflt_alt_id1_in_emp_id_yn      = checkForNull( request.getParameter( "dflt_alt_id1_in_emp_id_yn"),"N" );
	String entitlement_by_pat_cat_yn      = checkForNull( request.getParameter( "entitlement_by_pat_cat_yn"),"N" );
	String suspend_service_yn      = checkForNull( request.getParameter( "suspend_service_yn"),"N" );
	String acpt_appt_rfrl_in_reg_pat_yn  = checkForNull( request.getParameter( "acpt_appt_rfrl_in_reg_pat_yn"),"N" );
	String accept_pw_in_chng_pat_dtl_yn  = checkForNull( request.getParameter( "accept_pw_in_chng_pat_dtl_yn"),"N" );
	String dflt_language_id      = checkForNull( request.getParameter( "dflt_language_id"));
	String inv_pat_search_in_reg_pat_yn      = checkForNull( request.getParameter( "inv_pat_search_in_reg_pat_yn"),"N" );
	String race_required_yn      = checkForNull( request.getParameter( "race_required_yn"),"N" );
	String round_dob_estd_age      = checkForNull( request.getParameter( "round_dob_estd_age"),"N" );
	String gen_slno_unknown_pat_yn	= checkForNull( request.getParameter( "gen_slno_unknown_pat_yn"),"N" );
	String gen_pid_using_aid1_rule_yn	= checkForNull( request.getParameter( "gen_pid_using_aid1_rule_yn"),"N" );

    //Added by prithivi on 10/05/2017 for kdah-crf-0362
	String aadharProfileYN = InterfaceUtil.isInterfaceProfileExisting("AADHAARPROF1");
	String aadhar_config_enabled_yn	= checkForNull( request.getParameter( "aadhar_config_enabled_yn"),"N" );
	String aadhar_option_value	= checkForNull( request.getParameter( "aadhar_option_value"),"" );

	//String aadhar

//	String patient_id_length	= checkForNull( request.getParameter( "patient_id_length"));
//	out.println("gen_pid_using_aid1_rule_yn==IncludeJsp=>" +gen_pid_using_aid1_rule_yn);
//	out.println("patient_id_length==IncludeJsp=>" +patient_id_length);
//	out.println("patient_id_length==IncludeJsp=>" +request.getParameter("varable_patient_id_length"));
	
	//String family_no_link_yn	= checkForNull( request.getParameter( "family_no_link_yn"),"N" );
	//String family_org_id_accept_yn	= checkForNull( request.getParameter( "family_org_id_accept_yn"),"N" );
	//String org_member_relationship_code	= checkForNull( request.getParameter( "org_member_relationship_code"));
	//Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
	//Start
	String mortuary_release_yn      = checkForNull( request.getParameter( "mortuary_release_yn"),"N" );
	String no_days_before_deceased	= checkForNull( request.getParameter( "no_days_before_deceased"));
	String cancel_reason_code	= checkForNull( request.getParameter( "cancel_reason_code"));
	//End
	String disableChkExpFields = "";
	String chked = "";
    String chk1="";
    String chk2="";
    String chk3="";
    String chk4="";
	String chkdisAcceptothpatser = checkForNull(request.getParameter("chkdisAcceptothpatser"));
	String chkdisAcceptAlphanumeric = "";
	//String alt_id1_chng_allowed_yn = "";
	String alt_id1_chng_allowed = "";
	String oth_alt_id = "";
    String relationship_male_code       = "";
    String relationship_female_code       = "";
    String relationship_unknown_code       = "";
    String relationship_male_code_desc       = "";
    String relationship_female_code_desc       = "";
    String relationship_unknown_code_desc       = "";
	String oth_alt_id_dis = "";

	String dflt_relgn_code_desc="";
	String accept_pw_in_chng_pat_dtl_yn1="";
	String dflt_language_id_desc="";
	String citizen_nationality_desc="";
	String race_desc="";
	String relationship_desc = "";
String box_valu	 ="";
String chk_box_disb="";
//	String gen_patid_using_altid_rl_yn="";
//	String patient_id_length="";
       String basic="";
	   String advance="";
	  
     
	   if(pat_search_tab.equals("B"))
	         basic="selected";
	    if(pat_search_tab.equals("A"))
			 advance="selected";
// Added Against GHL-CRF-0312 [IN:039856]  by Saanthaakumar			 
String country_reqd_yn      = checkForNull( request.getParameter( "country_reqd_yn"),"N" );
String region_reqd_yn      = checkForNull( request.getParameter( "region_reqd_yn"),"N" );
String mobile_no_reqd_yn      = checkForNull( request.getParameter( "mobile_no_reqd_yn"),"N" );
// Newly Added Against KDAH-CRF-0273 [IN:045012]  by Saanthaakumar	
String email_id_reqd_yn      = checkForNull( request.getParameter( "email_id_reqd_yn"),"N" );
String pat_ser_access_by_user_yn      = checkForNull( request.getParameter( "pat_ser_access_by_user_yn"),"N" );//added for MO-CRF-20074
String upt_contact_dtls_oa_yn      = checkForNull( request.getParameter("upt_contact_dtls_oa_yn"),"N" );//added  changes   for HSA-CRF-0226 [IN:050599]

/*Below Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/

String upd_pat_dtls_referral_yn =  checkForNull( request.getParameter( "upd_pat_dtls_referral_yn"),"N" ); //Added by Dharma  on Apr 8th 2016 against HSA-CRF-0303 [IN:054572]
//VENKAT
String disp_cancelled_previous_enc_yn =  checkForNull( request.getParameter("disp_cancelled_previous_enc_yn"),"Y" ); 

String ALT_ID1_PAT_SCH_EXACT_YN =  checkForNull( request.getParameter( "ALT_ID1_PAT_SCH_EXACT_YN"),"N" );
String ALT_ID2_PAT_SCH_EXACT_YN =  checkForNull( request.getParameter( "ALT_ID2_PAT_SCH_EXACT_YN"),"N" );
String ALT_ID3_PAT_SCH_EXACT_YN =  checkForNull( request.getParameter( "ALT_ID3_PAT_SCH_EXACT_YN"),"N" );
String ALT_ID4_PAT_SCH_EXACT_YN =  checkForNull( request.getParameter( "ALT_ID4_PAT_SCH_EXACT_YN"),"N" );

String ALT_ID1_PAT_SCH_EXACT_YN_CHK	= (ALT_ID1_PAT_SCH_EXACT_YN.equals("Y")?"checked":"");
String ALT_ID2_PAT_SCH_EXACT_YN_CHK	= (ALT_ID2_PAT_SCH_EXACT_YN.equals("Y")?"checked":"");
String ALT_ID3_PAT_SCH_EXACT_YN_CHK	= (ALT_ID3_PAT_SCH_EXACT_YN.equals("Y")?"checked":"");
String ALT_ID4_PAT_SCH_EXACT_YN_CHK	= (ALT_ID4_PAT_SCH_EXACT_YN.equals("Y")?"checked":"");

String disableExactYn1="";
String disableExactYn2="";
String disableExactYn3="";
String disableExactYn4="";
/*Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]*/


%>

  <!-- To fetch Routine Name and MP  Check Digit_scheme-->
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

		if (alt_id1_accept_alphanumeric_yn.equals("Y"))
				chkdisAcceptAlphanumeric = "Checked disabled";
			else
				chkdisAcceptAlphanumeric = "disabled";

			if (alt_id1_chng_allowed_yn.equals("Y"))
				alt_id1_chng_allowed = "Checked disabled";
			else
			{
				if (!operation.equalsIgnoreCase( "insert" ) )
				{
				alt_id1_chng_allowed = "disabled";
				}
			}
%>
<!--Ends Here-->

<!-- <a name="tab5" nowrap></a>  --> 
<div id = 'ALTID' style = 'display:none'>
<!--<a name="tab5" nowrap></a> -->
<table cellspacing='0' cellpadding='0' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" >
			<!-- <li class="tablistitem" title='<fmt:message key="eMP.PatientNumbering.label" bundle="${mp_labels}"/>'>
				<a onclick="tab_click1('pat_number_tab')" class="tabA" id="pat_number_tab" >
					<span class="tabAspan" id="pat_number_tabspan"><fmt:message key="eMP.PatientNumbering.label" bundle="${mp_labels}"/></span>
				</a>
			</li> -->
	  <% if(module_instal_ind.equals("DMS")) { %>
	  <li class="tablistitem" title='<fmt:message key="Common.UM_PatientAdministration.label" bundle="${common_labels}"/>'><%} else { %>
			<li class="tablistitem" title='<fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/>'>	<%}%>
			<a class="tabA" id="pat_admin_tab" >
					<span class="tabAspan" id="pat_admin_tabspan" onClick='javascript:expandCollapse("pat_admin_tab")'><fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			
			<li class="tablistitem" title='<fmt:message key="eMP.LegalNames.label" bundle="${mp_labels}"/>'>
				<a class="tabA" id="legal_names_tab" >
					<span class="tabAspan" id="legal_names_tabspan" onClick='javascript:expandCollapse("legal_names_tab")'><fmt:message key="eMP.LegalNames.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
		<li class="tablistitem" title='<fmt:message key="eMP.AlternateIDChecks.label" bundle="${mp_labels}"/> '>
				<a class="tabClicked" id="alt_id_chk_tab" >
					<span class="tabSpanclicked" id="alt_id_chk_tabspan" onClick='javascript:expandCollapse("alt_id_chk_tab")'><fmt:message key="eMP.AlternateIDChecks.label" bundle="${mp_labels}"/></span>
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
				<% if("Y".equalsIgnoreCase(aadharProfileYN)) { %>
			</li>
				 <li class="tablistitem" title='AADHAR111'>
				<a class="tabA" id="aadhar_tab" >
					<span class="tabAspan" id="aadhar_tabspan" onClick='javascript:expandCollapse("aadhar_tab")'><fmt:message key="eMP.AADHAR.label" bundle="${mp_labels}"/></span>
			</a>
			</li>
				<% } %>
			</ul>
 </td></tr>
</table>

<TABLE>
<TR>
	<TD valign='top'><div id='altidleg'>
	<table cellpadding='3' cellspacing='0' width='100%' border=1 >
		<tr><TD class='columnheader'>&nbsp;</TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="Common.type.label" bundle="${common_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="Common.required.label" bundle="${common_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="Common.length.label" bundle="${common_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="Common.Check.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.length.label" bundle="${common_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.CheckUnique.label" bundle="${mp_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.AcceptExpiryDate.label" bundle="${mp_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.CheckExp.label" bundle="${mp_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.GraceDays.label" bundle="${mp_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.AlertinAdv.label" bundle="${mp_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.CheckDigit.label" bundle="${mp_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.InvokeRoutine.label" bundle="${mp_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.RoutineName.label" bundle="${mp_labels}"/></TD></tr>
		<tr>
<% if(module_instal_ind.equals("DMS")){%>	
<TD class='label' height='30'><fmt:message key="eMP.UM_AcceptforOtherPatientSeries.label" bundle="${mp_labels}"/></TD>
<%}else{ %>
<TD class='label' height='30'><fmt:message key="eMP.AcceptforOtherPatientSeries.label" bundle="${mp_labels}"/></TD>
<% }%>
</tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.AcceptAlphanumeric.label" bundle="${mp_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.ChangeAllowed.label" bundle="${mp_labels}"/></TD></tr>
		<tr><TD class='label' height='30'><fmt:message key="eMP.ExactSearch.label" bundle="${mp_labels}"/></TD></tr><!-- Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]-->
	</TABLE>
	</div>
	</TD>
	<td>
	<div id='altidcs'><table cellpadding='3' cellspacing='0' width='100%' border=1 >
	<TR>
		<TD class='COLUMNHEADER' width='25%'><fmt:message key="Common.AlternateID.label" bundle="${common_labels}"/>1</TD>
		<TD class='COLUMNHEADER' width='25%'><fmt:message key="Common.AlternateID.label" bundle="${common_labels}"/>2</TD>
		<TD class='COLUMNHEADER' width='25%'><fmt:message key="Common.AlternateID.label" bundle="${common_labels}"/>3</TD>
		<TD class='COLUMNHEADER' width='25%'><fmt:message key="Common.AlternateID.label" bundle="${common_labels}"/>4</TD>
	  </TR>
		<TR>
		
		<TD class='fields' height='30'>
		 <%
				if ( operation.equalsIgnoreCase( "insert" ) )
                        out.println( "<select name='alt_id1_type' id='alt_id1_type' onfocus='exp_focus()' onChange='checkAlternateId(1);typecheck(1)' style='width: 175px'>" ) ;

                    if ( operation.equalsIgnoreCase( "modify" ) )
                        out.println( "<select name='d_alt_id1_type' id='d_alt_id1_type' style='width: 175px' disabled>" ) ;
                %>
                <option value =''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
                <%
					if(pstmt!=null) pstmt.close() ;
					if(rs!=null) rs.close();
                    pstmt = con.prepareStatement( "select alt_id_type, long_desc from mp_alternate_id_type where eff_status='E' and ( sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) order by 2" ) ;
                    rs = pstmt.executeQuery() ;
				

                    if( rs != null ) {
                        while( rs.next() ) {
                            String alternateId = rs.getString( "alt_id_type" ) ;
                            String alternateName = rs.getString( "long_desc" ) ;

                            if ( alternateId.equals( alt_id1_type ) )
                                out.println( "<option selected value='" + alternateId + "' >" + alternateName ) ;
                            else
                                out.println( "<option value='" + alternateId + "' >" + alternateName ) ;
                        }
                    }

                    if(pstmt!=null) pstmt.close() ;
                    if(rs!=null) rs.close();
                %>
                </select><img src='../images/mandatory.gif'></img>
		</TD>
		<TD class='fields' height='30'>
		 <%
                           
					if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<select name='alt_id2_type' id='alt_id2_type' style='width: 175px' onChange='checkAlternateId(2);typecheck(2)'>" ) ;
                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<select name='d_alt_id2_type' id='d_alt_id2_type' style='width: 175px' disabled>" ) ;
                        %>
                                <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
                        <%
                            pstmt = con.prepareStatement( "select alt_id_type, long_desc from mp_alternate_id_type where eff_status='E' and ( sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) order by 2" ) ;
                            rs = pstmt.executeQuery() ;
						

                            if( rs != null ) {
                                while( rs.next() ) {
                                    String alternateId = rs.getString( "alt_id_type" ) ;
                                    String alternateName = rs.getString( "long_desc" ) ;

                                    if ( alternateId.equals( alt_id2_type ) )
                                        out.println( "<option selected value='" + alternateId + "' >" + alternateName ) ;
                                    else
                                        out.println( "<option value='" + alternateId + "' >" + alternateName ) ;
                                }
                            }

                            %>
                       </select>
		</TD>
		<TD class='fields' height='30'>
		 <%
                            if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<select name='alt_id3_type' id='alt_id3_type' style='width: 175px' onChange='checkAlternateId(3);typecheck(3)'>" ) ;

                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<select name='d_alt_id3_type' id='d_alt_id3_type' style='width: 175px' disabled>" ) ;
                        %>
                                <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
                            <%

                                if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
								pstmt = con.prepareStatement( "select alt_id_type, long_desc from mp_alternate_id_type where eff_status='E' and ( sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) order by 2" ) ;
                                rs = pstmt.executeQuery() ;
						

                                if( rs != null ) {
                                    while( rs.next() ) {
                                        String alternateId = rs.getString( "alt_id_type" ) ;
                                        String alternateName = rs.getString( "long_desc" ) ;

                                        if ( alternateId.equals( alt_id3_type ) )
                                            out.println( "<option selected value='" + alternateId + "' >" + alternateName ) ;
                                        else
                                            out.println( "<option value='" + alternateId + "' >" + alternateName ) ;
                                    }
                                }

                                if(pstmt!=null) pstmt.close() ;
								if(rs!=null) rs.close();
                            %>
                            </select>
		</TD>
		<TD class='fields' height='30'>
		<%
                            
				   if ( operation.equalsIgnoreCase( "insert" ) )
                                out.println( "<select name='alt_id4_type' id='alt_id4_type' style='width: 175px' onChange='checkAlternateId(4);typecheck(4)'>" ) ;
                            if ( operation.equalsIgnoreCase( "modify" ) )
                                out.println( "<select name='d_alt_id4_type' id='d_alt_id4_type' style='width: 175px' disabled>" ) ;
                        %>
                                <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
                            <%

                                pstmt = con.prepareStatement( "select alt_id_type, long_desc from mp_alternate_id_type where eff_status='E' and ( sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) order by 2" ) ;                                rs = pstmt.executeQuery() ;
							

                                if( rs != null ) {
                                    while( rs.next() ) {
                                        String alternateId = rs.getString( "alt_id_type" ) ;
                                        String alternateName = rs.getString( "long_desc" ) ;

                                        if ( alternateId.equals( alt_id4_type ) ){
                                            out.println( "<option selected value='" + alternateId + "' >" + alternateName ) ;
										}
                                        else
                                            out.println( "<option value='" + alternateId + "' >" + alternateName ) ;
                                    }
                                }

                                if(pstmt!=null) pstmt.close() ;
								if(rs!=null) rs.close();
                            %>
                            </select>
		</TD>
	   </TR>
	   <TR>
		<TD class='fields' height='30'>
		 <%
                       
				  if ( operation.equalsIgnoreCase( "insert" ) ) {
                            if ( alt_id1_reqd_yn.equals( "Y" ) )
                                out.println( "<input type='checkbox' name='alt_id1_reqd_yn' id='alt_id1_reqd_yn' value='Y' checked disabled>" ) ;
                            else
                                out.println( "<input type='checkbox' name='alt_id1_reqd_yn' id='alt_id1_reqd_yn' value='Y' disabled>" ) ;
                        }

                        if ( operation.equalsIgnoreCase( "modify" ) ) {
                            if ( alt_id1_reqd_yn.equals( "Y" ) )
                                out.println( "<input type='checkbox' name='d_alt_id1_reqd_yn' id='d_alt_id1_reqd_yn' checked disabled>" ) ;
                            else
                                out.println( "<input type='checkbox' name='d_alt_id1_reqd_yn' id='d_alt_id1_reqd_yn' disabled>") ;
                        }
                    %></TD>
		<TD class='fields' height='30'>
 <%
				 
			 if ( operation.equalsIgnoreCase( "insert" ) ) {
						if ( alt_id2_reqd_yn.equals( "Y" ) )
							out.println( "<input type='checkbox' name='alt_id2_reqd_yn' id='alt_id2_reqd_yn' value='Y'  checked disabled>" ) ;
						else
							out.println( "<input type='checkbox' name='alt_id2_reqd_yn' id='alt_id2_reqd_yn' value='Y' disabled>" ) ;
					}

					if ( operation.equalsIgnoreCase( "modify" ) ) {
						if ( alt_id2_reqd_yn.equals( "Y" ) )
							out.println( "<input type='checkbox' name='d_alt_id2_reqd_yn' id='d_alt_id2_reqd_yn' checked disabled>" ) ;
						else
							out.println( "<input type='checkbox' name='d_alt_id2_reqd_yn' id='d_alt_id2_reqd_yn' disabled>" ) ;
					}
				%>
					</TD>
		<TD class='fields' height='30'>
<%
			  
		if ( operation.equalsIgnoreCase( "insert" ) ) {
				if ( alt_id3_reqd_yn.equals( "Y" ) )
					out.println( "<input type='checkbox' name='alt_id3_reqd_yn' id='alt_id3_reqd_yn' value='Y' checked disabled>" ) ;
				else
					out.println( "<input type='checkbox' name='alt_id3_reqd_yn' id='alt_id3_reqd_yn' value='Y' disabled >" ) ;
			}

			if ( operation.equalsIgnoreCase( "modify" ) ) {
				if ( alt_id3_reqd_yn.equals( "Y" ) )
					out.println( "<input type='checkbox' name='d_alt_id3_reqd_yn' id='d_alt_id3_reqd_yn' value='Y' checked disabled>" ) ;
				else
					out.println( "<input type='checkbox' name='d_alt_id3_reqd_yn' id='d_alt_id3_reqd_yn' value='Y' disabled>" ) ;
			}
		%>		
		</TD>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id4_reqd_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id4_reqd_yn' id='alt_id4_reqd_yn' value='Y' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id4_reqd_yn' id='alt_id4_reqd_yn' value='Y' disabled>" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if ( alt_id4_reqd_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='d_alt_id4_reqd_yn' id='d_alt_id4_reqd_yn' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='d_alt_id4_reqd_yn' id='d_alt_id4_reqd_yn' disabled>" ) ;
		}
	%>
		</TD>
	  </TR>

	  <TR>
		<TD class='fields' height='30'>
		 <%
			   
	   if ( operation.equalsIgnoreCase( "insert" ) )
					out.println( "<input type='text' name='alt_id1_length' id='alt_id1_length' id='alt_id1_length_id' size='2' maxlength='2'  onkeypress='return allowValidNumber(this,event,2, 0);'  value='" + alt_id1_length + "' onBlur='CheckNum(this);checkDecimal(this);checkAltIdLength(this);'>" ) ;

				if ( operation.equalsIgnoreCase( "modify" ) )
				{
					/*if (gen_pid_using_aid1_rule_yn.equals("Y"))
						intval=Integer.parseInt(patient_id_length)-4;
					else 
						intval=Integer.parseInt(alt_id1_length);*/
						out.println( "<input type='text' name='d_alt_id1_length' id='d_alt_id1_length' size='2' value='" + alt_id1_length + "' disabled>" ) ;

				}
			%><img src='../images/mandatory.gif'></img>
		</TD>
		<TD class='fields' height='30'>
		<%
			
	   if ( operation.equalsIgnoreCase( "insert" ) )
					out.println( "<input type='text' name='alt_id2_length' id='alt_id2_length' size='2' maxlength='2'  onkeypress='return allowValidNumber(this,event,2, 0);'  value='" + alt_id2_length + "' onBlur='CheckNum(this);checkDecimal(this);checkAltIdLength(this);'>" ) ;

				if ( operation.equalsIgnoreCase( "modify" ) ){
					out.println( "<input type='text' name='d_alt_id2_length' id='d_alt_id2_length' size='2' value='" + alt_id2_length + "' disabled>" ) ;
					if(!alt_id2_length.equals("")){
						out.println(" <img src='../images/mandatory.gif' style='visibility:visible'   id='alt_id2_img'></img>");
					}
				}
			%><img src='../images/mandatory.gif' id='alt_id2_img' style='visibility:hidden'></img>
		</TD>
		<TD class='fields' height='30'>
		 <%
		 
		if ( operation.equalsIgnoreCase( "insert" ) )
				out.println( "<input type='text' name='alt_id3_length' id='alt_id3_length' size='2' maxlength='2'  onkeypress='return allowValidNumber(this,event,2, 0);'  value='" + alt_id3_length + "'  onBlur='CheckNum(this);checkDecimal(this);checkAltIdLength(this);'>" ) ;

			if ( operation.equalsIgnoreCase( "modify" ) ){
				out.println( "<input type='text' name='d_alt_id3_length' id='d_alt_id3_length' size='2' value='" + alt_id3_length + "' disabled>" ) ;
					if(!alt_id3_length.equals("")){
						out.println(" <img src='../images/mandatory.gif' style='visibility:visible'   id='alt_id3_img'></img>");
					}
			}
		%><img src='../images/mandatory.gif' id='alt_id3_img' style='visibility:hidden'></img>
		</TD>
		<TD class='fields' height='30'>
		<%
			 
		if ( operation.equalsIgnoreCase( "insert" ) )
				out.println( "<input type='text' name='alt_id4_length' id='alt_id4_length' size='2' maxlength='2'  onkeypress='return allowValidNumber(this,event,2, 0);'  value='" + alt_id4_length + "'  onBlur='CheckNum(this);checkDecimal(this);checkAltIdLength(this);'>" ) ;

			if ( operation.equalsIgnoreCase( "modify" ) ){
				out.println( "<input type='text' name='d_alt_id4_length' id='d_alt_id4_length' size='2' value='" + alt_id4_length + "' disabled>" ) ;
					if(!alt_id4_length.equals("")){
						out.println(" <img src='../images/mandatory.gif' style='visibility:visible'   id='alt_id4_img'></img>");
					}
			}
		%><img src='../images/mandatory.gif' id='alt_id4_img' style='visibility:hidden'></img>
		</TD>
	  </TR>

	  <TR>
		<TD class='fields' height='30'>
	<%
	  
	if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id1_len_validation_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id1_len_validation_yn' id='alt_id1_len_validation_yn' value='Y' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id1_len_validation_yn' id='alt_id1_len_validation_yn' value='Y' disabled>" ) ;
		}
		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if ( alt_id1_len_validation_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='h_alt_id1_len_validation_yn' id='h_alt_id1_len_validation_yn' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='h_alt_id1_len_validation_yn' id='h_alt_id1_len_validation_yn' disabled>" ) ;
		}
	%>
		</TD>
		<TD class='fields' height='30'>
<%
	if ( operation.equalsIgnoreCase( "insert" ) ) {
		if ( alt_id2_len_validation_yn.equals( "Y" ) )
			out.println( "<input type='checkbox' name='alt_id2_len_validation_yn' id='alt_id2_len_validation_yn' value='Y' checked disabled>" ) ;
		else
			out.println( "<input type='checkbox' name='alt_id2_len_validation_yn' id='alt_id2_len_validation_yn' value='Y' disabled>" ) ;
	}

	if ( operation.equalsIgnoreCase( "modify" ) ) {
		if ( alt_id2_len_validation_yn.equals( "Y" ) )
			out.println( "<input type='checkbox' name='h_alt_id2_len_validation_yn' id='h_alt_id2_len_validation_yn' checked disabled>" ) ;
		else
			out.println( "<input type='checkbox' name='h_alt_id2_len_validation_yn' id='h_alt_id2_len_validation_yn' disabled>" ) ;
	}
%>
		</TD>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id3_len_validation_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id3_len_validation_yn' id='alt_id3_len_validation_yn' value='Y' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id3_len_validation_yn' id='alt_id3_len_validation_yn' value='Y' disabled>" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if ( alt_id3_len_validation_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='h_alt_id3_len_validation_yn' id='h_alt_id3_len_validation_yn' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='h_alt_id3_len_validation_yn' id='h_alt_id3_len_validation_yn' disabled>" ) ;
		}
	%>
		</TD>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id4_len_validation_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id4_len_validation_yn' id='alt_id4_len_validation_yn' value='Y' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id4_len_validation_yn' id='alt_id4_len_validation_yn' value='Y' disabled>" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if ( alt_id4_len_validation_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='h_alt_id4_len_validation_yn' id='h_alt_id4_len_validation_yn' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='h_alt_id4_len_validation_yn' id='h_alt_id4_len_validation_yn' disabled>" ) ;
		}
	%>
		</TD>
	  </TR>

	  <TR>
		<TD class='fields' height='30'>
		<input type='hidden' name = 'alt_id1_is_unique' value='<%= alt_id1_unique_yn%>'> 
		<%		 
		if ( operation.equalsIgnoreCase( "insert" ) ) {
				if ( alt_id1_unique_yn.equals( "Y" ) )
					out.println( "<input type='checkbox' name='alt_id1_unique_yn' id='alt_id1_unique_yn' value='Y' checked disabled OnClick='chkAltID1Unq(this)'>" ) ;
				else	
				   out.println( "<input type='checkbox' name='alt_id1_unique_yn' id='alt_id1_unique_yn' value='N' disabled OnClick='chkAltID1Unq(this)'>" ) ;
			}

			if ( operation.equalsIgnoreCase( "modify" ) ) {
				if ( alt_id1_unique_yn.equals( "Y" ) )
					out.println( "<input type='checkbox' name='d_alt_id1_unique_yn' id='d_alt_id1_unique_yn' checked disabled>" ) ;
				else
					out.println( "<input type='checkbox' name='d_alt_id1_unique_yn' id='d_alt_id1_unique_yn' disabled>" ) ;
			}	
		%>
		</TD>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id2_unique_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id2_unique_yn' id='alt_id2_unique_yn' value='Y' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id2_unique_yn' id='alt_id2_unique_yn' value='Y' disabled >" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if ( alt_id2_unique_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='d_alt_id2_unique_yn' id='d_alt_id2_unique_yn' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='d_alt_id2_unique_yn' id='d_alt_id2_unique_yn' disabled >" ) ;
		}
	%></TD>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id3_unique_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id3_unique_yn' id='alt_id3_unique_yn' value='Y' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id3_unique_yn' id='alt_id3_unique_yn' value='Y' disabled>" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if ( alt_id3_unique_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='d_alt_id3_unique_yn' id='d_alt_id3_unique_yn' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='d_alt_id3_unique_yn' id='d_alt_id3_unique_yn' disabled >" ) ;
		}
	%></TD>
		<TD class='fields' height='30'>
		 <%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id4_unique_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id4_unique_yn' id='alt_id4_unique_yn' value='Y' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id4_unique_yn' id='alt_id4_unique_yn' value='Y' disabled >" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if ( alt_id4_unique_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='d_alt_id4_unique_yn' id='d_alt_id4_unique_yn' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='d_alt_id4_unique_yn' id='d_alt_id4_unique_yn' disabled >" ) ;
		}
	%></TD>
	  </TR>

	  <TR>
		<TD class='fields' height='30'>
		  <%
		
	if ( operation.equalsIgnoreCase( "insert" ) ) {
				if ( alt_id1_exp_date_accept_yn.equals( "Y" ) )
					out.println( "<input type='checkbox' name='alt_id1_exp_date_accept_yn' id='alt_id1_exp_date_accept_yn' value='Y'  onClick = 'chkCheckExpiry1(this); ' checked disabled>" ) ;
				else
					out.println( "<input type='checkbox' name='alt_id1_exp_date_accept_yn' id='alt_id1_exp_date_accept_yn' value='Y' onClick = 'chkCheckExpiry1(this);' disabled>" ) ;
			}

			if ( operation.equalsIgnoreCase( "modify" ) ) {
				if ( alt_id1_exp_date_accept_yn.equals( "Y" ) )
					out.println( "<input type='checkbox' name='d_alt_id1_exp_date_accept_yn' id='d_alt_id1_exp_date_accept_yn' checked  disabled >" ) ; 
				else
					out.println( "<input type='checkbox' name='d_alt_id1_exp_date_accept_yn' id='d_alt_id1_exp_date_accept_yn' disabled >" ) ; 
			}
		%>
		</TD>
		<TD class='fields' height='30'>
		<%

	if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id2_exp_date_accept_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id2_exp_date_accept_yn' id='alt_id2_exp_date_accept_yn' value='Y'   onClick = 'chkCheckExpiry2(this); ' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id2_exp_date_accept_yn' id='alt_id2_exp_date_accept_yn' value='Y'    onClick = 'chkCheckExpiry2(this);' disabled >" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if ( alt_id2_exp_date_accept_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='d_alt_id2_exp_date_accept_yn' id='d_alt_id2_exp_date_accept_yn' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='d_alt_id2_exp_date_accept_yn' id='d_alt_id2_exp_date_accept_yn' disabled>" ) ;
		}
	%>
		</TD>
		<TD class='fields' height='30'>
		<%
			   
		if ( operation.equalsIgnoreCase( "insert" ) ) {
				if ( alt_id3_exp_date_accept_yn.equals( "Y" ) )
					out.println( "<input type='checkbox' name='alt_id3_exp_date_accept_yn' id='alt_id3_exp_date_accept_yn' value='Y'  onClick = 'chkCheckExpiry3(this);' checked disabled>" ) ;
				else
					out.println( "<input type='checkbox' name='alt_id3_exp_date_accept_yn' id='alt_id3_exp_date_accept_yn' value='Y'    onClick = 'chkCheckExpiry3(this);' disabled>" ) ;
			}

			if ( operation.equalsIgnoreCase( "modify" ) ) {
				if ( alt_id3_exp_date_accept_yn.equals( "Y" ) )
					out.println( "<input type='checkbox' name='d_alt_id3_exp_date_accept_yn' id='d_alt_id3_exp_date_accept_yn' checked disabled>" ) ;
				else
					out.println( "<input type='checkbox' name='d_alt_id3_exp_date_accept_yn' id='d_alt_id3_exp_date_accept_yn' disabled>" ) ;
			}
		%>
		</TD>
		<TD class='fields' height='30'>
		 <%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id4_exp_date_accept_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id4_exp_date_accept_yn' id='alt_id4_exp_date_accept_yn' value='Y'  onClick = 'chkCheckExpiry4(this);' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id4_exp_date_accept_yn' id='alt_id4_exp_date_accept_yn' value='Y'    onClick = 'chkCheckExpiry4(this);' disabled>" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if ( alt_id4_exp_date_accept_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='d_alt_id4_exp_date_accept_yn' id='d_alt_id4_exp_date_accept_yn' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='d_alt_id4_exp_date_accept_yn' id='d_alt_id4_exp_date_accept_yn' disabled>" ) ;
		}
	%>
		</TD>
	  </TR>

	  <TR>
		<TD class='fields' height='30'>
	 <%
		  
	 if ( operation.equalsIgnoreCase( "insert" ) ) {
				if ( alt_id1_exp_warn_yn.equals( "Y" ) )
					out.println( "<input type='checkbox' name='alt_id1_exp_warn_yn' id='alt_id1_exp_warn_yn' value='Y' onFocus='checkAlternateId(1)' onClick='checkAlternateId(1)' checked disabled>" ) ;
				else
					out.println( "<input type='checkbox' name='alt_id1_exp_warn_yn' id='alt_id1_exp_warn_yn' value='Y' onFocus='checkAlternateId(1)' onClick='checkAlternateId(1)' disabled>" ) ;
			}

			if ( operation.equalsIgnoreCase( "modify" ) ) {
				if (!alt_id1_type.equals(""))
					disableChkExpFields = "onClick='checkAlternateId(1)'";
				else
					disableChkExpFields = "disabled";
				if ( alt_id1_exp_warn_yn.equals( "Y" ) )
					out.println( "<input type='checkbox' name='d_alt_id1_exp_warn_yn' id='d_alt_id1_exp_warn_yn' onfocus='exp_focus()' checked "+disableChkExpFields+">" ) ;                                 else
					out.println( "<input type='checkbox' name='d_alt_id1_exp_warn_yn' id='d_alt_id1_exp_warn_yn' onfocus='exp_focus()' "+disableChkExpFields+">" ) ; 
			}
		%>
		</TD>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id2_exp_warn_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id2_exp_warn_yn' id='alt_id2_exp_warn_yn' value='Y' onFocus='checkAlternateId(2)' onClick='checkAlternateId(2)'  checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id2_exp_warn_yn' id='alt_id2_exp_warn_yn' value='Y' onFocus='checkAlternateId(2)' onClick='checkAlternateId(2)' disabled>" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if (!alt_id2_type.equals(""))
				disableChkExpFields = "onClick='checkAlternateId(2)'";
			else
				disableChkExpFields = "disabled";
			if ( alt_id2_exp_warn_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='d_alt_id2_exp_warn_yn' id='d_alt_id2_exp_warn_yn' checked "+disableChkExpFields+">" ) ;
			else
				out.println( "<input type='checkbox' name='d_alt_id2_exp_warn_yn' id='d_alt_id2_exp_warn_yn' "+disableChkExpFields+">" ) ;
		}
	%>
		</TD>
		<TD class='fields' height='30'>
		 <%
		 
	if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id3_exp_warn_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id3_exp_warn_yn' id='alt_id3_exp_warn_yn' value='Y' onFocus='checkAlternateId(3)' onClick='checkAlternateId(3)' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id3_exp_warn_yn' id='alt_id3_exp_warn_yn' value='Y' onFocus='checkAlternateId(3)' onClick='checkAlternateId(3)' disabled>" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if (!alt_id3_type.equals(""))
				disableChkExpFields = "onClick='checkAlternateId(3)'";
			else
				disableChkExpFields = "disabled";
			if ( alt_id3_exp_warn_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='d_alt_id3_exp_warn_yn' id='d_alt_id3_exp_warn_yn' checked "+disableChkExpFields+">" ) ;
			else
				out.println( "<input type='checkbox' name='d_alt_id3_exp_warn_yn' id='d_alt_id3_exp_warn_yn' "+disableChkExpFields+">" ) ;
		}
	%>
		</TD>
		<TD class='fields' height='30'>
		<%
		
	if ( operation.equalsIgnoreCase( "insert" ) ) {
			if ( alt_id4_exp_warn_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='alt_id4_exp_warn_yn' id='alt_id4_exp_warn_yn' value='Y' onFocus='checkAlternateId(4)' onClick='checkAlternateId(4)' checked disabled>" ) ;
			else
				out.println( "<input type='checkbox' name='alt_id4_exp_warn_yn' id='alt_id4_exp_warn_yn' value='Y' onFocus='checkAlternateId(4)' onClick='checkAlternateId(4)' disabled>" ) ;
		}

		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if (!alt_id4_type.equals(""))
				disableChkExpFields = "onClick='checkAlternateId(4)'";
			else
				disableChkExpFields = "disabled";
			if ( alt_id4_exp_warn_yn.equals( "Y" ) )
				out.println( "<input type='checkbox' name='d_alt_id4_exp_warn_yn' id='d_alt_id4_exp_warn_yn' checked "+disableChkExpFields+">" ) ;
			else
				out.println( "<input type='checkbox' name='d_alt_id4_exp_warn_yn' id='d_alt_id4_exp_warn_yn' "+disableChkExpFields+">" ) ;
		}
	%>
		</TD>
	  </TR>

	  <TR>
		<TD class='fields' height='30'>
		<%
			
		if ( operation.equalsIgnoreCase( "insert" ) )
					out.println( "<input type='text' name='alt_id1_exp_grace_days' id='alt_id1_exp_grace_days' size='3' maxlength='3' onkeypress='return allowValidNumber(this,event,3, 0);'  onBlur='CheckNum(this);checkDecimal(this);'>" ) ;
				if ( operation.equalsIgnoreCase( "modify" ) )
				{
					String disableFld = "";
					if (alt_id1_exp_warn_yn.equals("Y"))
						disableFld = "";
					else
						disableFld = "disabled";
					out.println( "<input type='text' name='alt_id1_exp_grace_days' id='alt_id1_exp_grace_days'  size='3' maxlength='3' onkeypress='return allowValidNumber(this,event,3, 0);'  onBlur='CheckNum(this);checkDecimal(this);' value='" + alt_id1_exp_grace_days + "' "+disableFld+">" ) ;
				}
			   %>
		</TD>
		<TD class='fields' height='30'>
		  <%
			   
		if ( operation.equalsIgnoreCase( "insert" ) )
					out.println( "<input type='text' name='alt_id2_exp_grace_days' id='alt_id2_exp_grace_days' size='3' maxlength='3'  onkeypress='return allowValidNumber(this,event,3, 0);'  onBlur='CheckNum(this);checkDecimal(this);'>" ) ;

				if ( operation.equalsIgnoreCase( "modify" ) )
				{
					String disableFld = "";
					if (alt_id2_exp_warn_yn.equals("Y"))
						disableFld = "";
					else
						disableFld = "disabled";
					out.println( "<input type='text' name='alt_id2_exp_grace_days' id='alt_id2_exp_grace_days'  size='3' maxlength='3' onkeypress='return allowValidNumber(this,event,3, 0);'  onBlur='CheckNum(this);checkDecimal(this);' value='" + alt_id2_exp_grace_days + "' "+disableFld+">" ) ;
				}
			%>
		</TD>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) )
			out.println( "<input type='text' name='alt_id3_exp_grace_days' id='alt_id3_exp_grace_days' size='3' maxlength='3'  onkeypress='return allowValidNumber(this,event,3, 0);'  onBlur='CheckNum(this);checkDecimal(this);'>" ) ;

		if ( operation.equalsIgnoreCase( "modify" ) )
		{
			String disableFld = "";
			if (alt_id3_exp_warn_yn.equals("Y"))
				disableFld = "";
			else
				disableFld = "disabled";
			out.println( "<input type='text' name='alt_id3_exp_grace_days' id='alt_id3_exp_grace_days' size='3' maxlength='3'  onkeypress='return allowValidNumber(this,event,3, 0);'  onBlur='CheckNum(this);checkDecimal(this);' value='" + alt_id3_exp_grace_days + "' "+disableFld+">" ) ;
		}
	%>
		</TD>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) )
			out.println( "<input type='text' name='alt_id4_exp_grace_days' id='alt_id4_exp_grace_days' size='3' maxlength='3'  onkeypress='return allowValidNumber(this,event,3, 0);'  onBlur='CheckNum(this);checkDecimal(this);'>" ) ;

		if ( operation.equalsIgnoreCase( "modify" ) )
		{
			String disableFld = "";
			if (alt_id4_exp_warn_yn.equals("Y"))
				disableFld = "";
			else
				disableFld = "disabled";
			out.println( "<input type='text' name='alt_id4_exp_grace_days' id='alt_id4_exp_grace_days'  size='3' maxlength='3'  onkeypress='return allowValidNumber(this,event,3, 0);'  onBlur='CheckNum(this);checkDecimal(this);' value='" + alt_id4_exp_grace_days + "' "+disableFld+">" ) ;
		}
	%>
		</TD>
	  </TR>

	  <TR>
		<TD class='fields' height='30'>
		<%
	
		if ( operation.equalsIgnoreCase( "insert" ) ) {
	   out.println("<input type='checkbox' name='alt_id1_adv_alert_reqd_yn' id='alt_id1_adv_alert_reqd_yn' value='Y'  onClick='enablecheck1()' disabled>");
	   }
	else if( operation.equalsIgnoreCase( "modify" ) ) {                         
			if (!alt_id1_type.equals(""))
				disableChkExpFields = "onClick='enablecheck1()'";
			else
				disableChkExpFields = "disabled";
		out.println("<input type='checkbox' name='alt_id1_adv_alert_reqd_yn' id='alt_id1_adv_alert_reqd_yn' value='Y' "+chk1+" "+disableChkExpFields+">");
		}
%>
		</TD>
		<TD class='fields' height='30'>
		<%
	if ( operation.equalsIgnoreCase( "insert" ) ) {
	   out.println("<input type='checkbox' name='alt_id2_adv_alert_reqd_yn' id='alt_id2_adv_alert_reqd_yn' value='Y' onClick='enablecheck2()' disabled>");}
	else if( operation.equalsIgnoreCase( "modify" ) ) {
		if (!alt_id2_type.equals(""))
			disableChkExpFields = "onClick='enablecheck2()'";
		else
			disableChkExpFields = "disabled";

		out.println("<input type='checkbox' name='alt_id2_adv_alert_reqd_yn' id='alt_id2_adv_alert_reqd_yn' value='Y' "+chk2+" "+disableChkExpFields+">");}
%>
		</TD>
		<TD class='fields' height='30'>
		<%
	 
	if ( operation.equalsIgnoreCase( "insert" ) ) {
	   out.println("<input type='checkbox' name='alt_id3_adv_alert_reqd_yn' id='alt_id3_adv_alert_reqd_yn' value='Y' onClick='enablecheck3()' disabled>");
	   }
	else if( operation.equalsIgnoreCase( "modify" ) ) {                         
		if (!alt_id3_type.equals(""))
			disableChkExpFields = "onClick='enablecheck3()'";
		else
			disableChkExpFields = "disabled";
		out.println("<input type='checkbox' name='alt_id3_adv_alert_reqd_yn' id='alt_id3_adv_alert_reqd_yn' value='Y' "+chk3 +" "+disableChkExpFields+">");
		}
%>
		</TD>
		<TD class='fields' height='30'>
		 <%
		
		if ( operation.equalsIgnoreCase( "insert" ) ) {
		   out.println("<input type='checkbox' name='alt_id4_adv_alert_reqd_yn' id='alt_id4_adv_alert_reqd_yn' value='Y' onClick='enablecheck4()' disabled>");}
		else if( operation.equalsIgnoreCase( "modify" ) ) { 
			if (!alt_id4_type.equals(""))
				disableChkExpFields = "onClick='enablecheck4()'";
			else
				disableChkExpFields = "disabled";
			out.println("<input type='checkbox' name='alt_id4_adv_alert_reqd_yn' id='alt_id4_adv_alert_reqd_yn' value='Y' "+chk4+" "+disableChkExpFields+">");}
	%>
		</TD>
	  </TR>
	  <TR>
		<TD class='fields' height='30'>
		 <%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			out.println("<input type='text' name='alt_id1_adv_alert_days' id='alt_id1_adv_alert_days' size='2' maxlength='2'  onkeypress='return allowValidNumber(this,event,2, 0);'  onBlur='CheckNum(this);checkDecimal(this);'  disabled>");
			}
		else if ( operation.equalsIgnoreCase( "modify" )){
				String disableFld = "";
				if (alt_id1_adv_alert_reqd_yn.equals("Y"))
					disableFld = "";
				else
					disableFld = "disabled";
				out.println( "<input type='text' name='alt_id1_adv_alert_days' id='alt_id1_adv_alert_days'  size='2' maxlength='2'  onkeypress='return allowValidNumber(this,event,2, 0);' value='" + alt_id1_adv_alert_days + "' onBlur='CheckNum(this);checkDecimal(this);' "+disableFld+">" ) ;
		  }

	%>
		</TD>
		<TD class='fields' height='30'>
		 <%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			out.println("<input type='text' name='alt_id2_adv_alert_days' id='alt_id2_adv_alert_days' size='2' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);'  onBlur='CheckNum(this);checkDecimal(this);' disabled>");}
		else if ( operation.equalsIgnoreCase( "modify" )){
			String disableFld = "";
			if (alt_id2_adv_alert_reqd_yn.equals("Y"))
				disableFld = "";
			else
				disableFld = "disabled";
		
			out.println( "<input type='text' name='alt_id2_adv_alert_days' id='alt_id2_adv_alert_days'  size='2' maxlength='2' value='" + alt_id2_adv_alert_days + "' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);' "+disableFld+">" ) ;
		}

	%>
		</TD>
		<TD class='fields' height='30'>
		<%
	if ( operation.equalsIgnoreCase( "insert" ) ) {
		out.println("<input type='text' name='alt_id3_adv_alert_days' id='alt_id3_adv_alert_days' size='2' maxlength='2'  onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);' disabled>");}
	else if ( operation.equalsIgnoreCase( "modify" )){
		String disableFld = "";
		if (alt_id3_adv_alert_reqd_yn.equals("Y"))
			disableFld = "";
		else
			disableFld = "disabled";
		out.println( "<input type='text' name='alt_id3_adv_alert_days' id='alt_id3_adv_alert_days'  size='2' maxlength='2'  onkeypress='return allowValidNumber(this,event,2, 0);'  value='" + alt_id3_adv_alert_days + "' onBlur='CheckNum(this);checkDecimal(this);' "+disableFld+">" ) ;
	}
	
%>
		</TD>
		<TD class='fields' height='30'>
<%
	 ;       
	if ( operation.equalsIgnoreCase( "insert" ) ) {
			out.println("<input type='text' name='alt_id4_adv_alert_days' id='alt_id4_adv_alert_days' size='2' maxlength='2'  onkeypress='return allowValidNumber(this,event,2, 0);'  onBlur='CheckNum(this);checkDecimal(this);' disabled>");}
		else if ( operation.equalsIgnoreCase( "modify" )){
			String disableFld = "";
			if (alt_id4_adv_alert_reqd_yn.equals("Y"))
				disableFld = "";
			else
				disableFld = "disabled";
			out.println( "<input type='text' name='alt_id4_adv_alert_days' id='alt_id4_adv_alert_days'  size='2' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);'  value='" + alt_id4_adv_alert_days + "' onBlur='CheckNum(this);checkDecimal(this);' "+disableFld+">" ) ;
		}
	%>
		</TD>
	  </TR>

	  <TR>
		<TD class='fields' height='30'>
		<%
		
	  String alt1_chk_digit_scheme = "";
			if ( operation.equalsIgnoreCase( "modify" ) ) {
				if (!alt_id1_chk_digit_scheme.equals(""))
					alt1_chk_digit_scheme = "disabled";
				else
					if (!alt_id1_type.equals(""))
						alt1_chk_digit_scheme = "";
					else
						alt1_chk_digit_scheme = "disabled"; 
			}
			else
				alt1_chk_digit_scheme = "disabled";
		  %>
			<select name='alt_id1_chk_digit_scheme' id='alt_id1_chk_digit_scheme'  style='width: 175px' <%=alt1_chk_digit_scheme%> disabled >
				<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
				
		/*  for(int i=0;i<chk_digit_code.size();i++)
					{
						String sel = "" ;
						if(alt_id1_chk_digit_scheme.equals((String)chk_digit_code.get(i)))
						  sel = "selected";
						out.println( "<option value='"+chk_digit_code.get(i)+"' "+sel+">"+chk_digit_val.get(i)+"</option>" ) ;
					}*/
				%>
			</select>
		</TD>
		<TD class='fields' height='30'>
		<%
		String alt2_chk_digit_scheme = "";
		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if (!alt_id2_chk_digit_scheme.equals(""))
				alt2_chk_digit_scheme = "disabled";
			else
				if (!alt_id2_type.equals(""))
					alt2_chk_digit_scheme = "";
				else
					alt2_chk_digit_scheme = "disabled"; 
		}
		else
			alt2_chk_digit_scheme = "disabled";
		%>
			<select name='alt_id2_chk_digit_scheme' id='alt_id2_chk_digit_scheme' style='width: 175px' <%=alt2_chk_digit_scheme%> disabled >
			<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>                            
				<%
				/*    for(int i=0;i<chk_digit_code.size();i++)
					{
						String sel = "" ;
						if(alt_id2_chk_digit_scheme.equals((String)chk_digit_code.get(i)))
						  sel = "selected";
						out.println( "<option value='"+chk_digit_code.get(i)+"' "+sel+">"+chk_digit_val.get(i)+"</option>" ) ;
					}*/
				%>
		</TD>
		<TD class='fields' height='30'>
	 <%
	String alt3_chk_digit_scheme = "";
  
	if ( operation.equalsIgnoreCase( "modify" ) ) {
		if (!alt_id3_chk_digit_scheme.equals(""))
			alt3_chk_digit_scheme = "disabled";
		else
			if (!alt_id3_type.equals(""))
			alt3_chk_digit_scheme = "";
		else
			alt3_chk_digit_scheme = "disabled"; 
	}
	else
		alt3_chk_digit_scheme = "disabled";
	%>
		<select name='alt_id3_chk_digit_scheme' id='alt_id3_chk_digit_scheme' style='width: 175px' <%=alt3_chk_digit_scheme%> disabled >
			<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
			<%
		   /*     for(int i=0;i<chk_digit_code.size();i++)
				{
					String sel = "" ;
					
					if(alt_id3_chk_digit_scheme.equals((String)chk_digit_code.get(i)))
					  sel = "selected";
					out.println( "<option value='"+chk_digit_code.get(i)+"' "+sel+">"+chk_digit_val.get(i)+"</option>" ) ;
				}*/
			%>
		</TD>
		<TD class='fields' height='30'>
		 <%
		String alt4_chk_digit_scheme = "";
		if ( operation.equalsIgnoreCase( "modify" ) ) {
			if (!alt_id4_chk_digit_scheme.equals(""))
				alt4_chk_digit_scheme = "disabled";
			else
				if (!alt_id4_type.equals(""))
				alt4_chk_digit_scheme = "";
			else
				alt4_chk_digit_scheme = "disabled"; 
		}
		else
			alt4_chk_digit_scheme = "disabled";
		%>
			<select name='alt_id4_chk_digit_scheme' id='alt_id4_chk_digit_scheme' style='width: 175px' <%=alt4_chk_digit_scheme%> disabled>
				<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
				/*    for(int i=0;i<chk_digit_code.size();i++)
					{
						String sel = "" ;
						
						if(alt_id4_chk_digit_scheme.equals((String)chk_digit_code.get(i)))
						  sel = "selected";
						out.println( "<option value='"+chk_digit_code.get(i)+"' "+sel+">"+chk_digit_val.get(i)+"</option>" ) ;
					}*/
				%>
		</TD>
	  </TR>

	  <TR>
		<TD class='fields' height='30'>
		  <%
		chked = "checked" ;
		String sel_obj = "" ;
		if(alt_id1_invoke_routine .equals("N"))
		{
			chked ="" ;
			sel_obj = "disabled";
		}

if ( operation.equalsIgnoreCase( "insert" ) ) {
		out.println( "<input type='checkbox' name='alt_id1_invoke_routine' id='alt_id1_invoke_routine' size='3' maxlength='3' value='Y' onclick='chkRoutine(this,alt_id1_routine_name)' disabled>" ) ;
	}
else if ( operation.equalsIgnoreCase( "modify" ) ) {
		out.println( "<input type='checkbox' name='alt_id1_invoke_routine' id='alt_id1_invoke_routine' size='3' maxlength='3' value='Y' "+chked+"  disabled>" ) ;
	}

%>
		</TD>
		<TD class='fields' height='30'>
	  <%
	chked = "checked" ;
	sel_obj = "" ;
	if(alt_id2_invoke_routine .equals("N"))
	{
		chked ="" ;
		sel_obj = "disabled";
	}

	if ( operation.equalsIgnoreCase( "insert" ) ) {
			out.println( "<input type='checkbox' name='alt_id2_invoke_routine' id='alt_id2_invoke_routine' size='3' maxlength='3' value='Y' onclick='chkRoutine(this,alt_id2_routine_name)' disabled>" ) ;
		}
	if ( operation.equalsIgnoreCase( "modify" ) ) {
			out.println( "<input type='checkbox' name='alt_id2_invoke_routine' id='alt_id2_invoke_routine' size='3' maxlength='3' value='Y' "+chked+"  disabled>" ) ;
		}
%>
		</TD>
		<TD class='fields' height='30'>
	 <%
	 
chked = "checked" ;
		sel_obj = "" ;
		if(alt_id3_invoke_routine .equals("N"))
		{
			chked ="" ;
			sel_obj = "disabled";
		}

		if ( operation.equalsIgnoreCase( "insert" ) ) {
				out.println( "<input type='checkbox' name='alt_id3_invoke_routine' id='alt_id3_invoke_routine' size='3' maxlength='3' value='Y' onclick='chkRoutine(this,alt_id3_routine_name)' disabled>" ) ;
			}
		if ( operation.equalsIgnoreCase( "modify" ) ) {
				out.println( "<input type='checkbox' name='alt_id3_invoke_routine' id='alt_id3_invoke_routine' size='3' maxlength='3' value='Y' "+chked+"  disabled>" ) ;
			}
%>
		</TD>
		<TD class='fields' height='30'>
<%
			
	chked = "checked" ;
			sel_obj = "" ;
			if(alt_id4_invoke_routine .equals("N"))
			{
				chked ="" ;
				sel_obj = "disabled";
			}

			if ( operation.equalsIgnoreCase( "insert" ) ) {
					out.println( "<input type='checkbox' name='alt_id4_invoke_routine' id='alt_id4_invoke_routine' size='3' maxlength='3' value='Y' onclick='chkRoutine(this,alt_id4_routine_name)' disabled>" ) ;
				}
			if ( operation.equalsIgnoreCase( "modify" ) ) {
					out.println( "<input type='checkbox' name='alt_id4_invoke_routine' id='alt_id4_invoke_routine' size='3' maxlength='3' value='Y' "+chked+"  disabled>" ) ;
				}
	%>
		</TD>
	  </TR>

	  <TR>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			out.println("<select name='alt_id1_routine_name' id='alt_id1_routine_name' "+sel_obj+" style='width: 175px' >");
		}
		else if ( operation.equalsIgnoreCase( "modify" ) ) {
				out.println("<select name='alt_id1_routine_name' id='alt_id1_routine_name' "+sel_obj +" style='width: 175px' disabled>");
		}
		%>
				<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
					for(int i=0;i<routine_names.size();i++)
					{
						String sel = "" ;
						if(alt_id1_routine_name.equals((String)routine_ids.get(i)))
							sel = "selected";
						   
						out.println("<option value='"+routine_ids.get(i)+"' "+sel+">"+routine_names.get(i)+"</option>") ;
					}
				%>
			</select>
		</TD>
		<TD class='fields' height='30'>
		 <%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			out.println("<select name='alt_id2_routine_name' id='alt_id2_routine_name' "+sel_obj+" style='width: 175px'>");
		}
		else if ( operation.equalsIgnoreCase( "modify" ) ) {
				out.println("<select name='alt_id2_routine_name' id='alt_id2_routine_name' "+sel_obj +"  style='width: 175px' disabled>");
		}
		%>
				<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
				  
		for(int i=0;i<routine_names.size();i++)
					{
						String sel = "" ;
						if(alt_id2_routine_name.equals((String)routine_ids.get(i)))
							sel = "selected";
						   
						out.println("<option value='"+routine_ids.get(i)+"' "+sel+">"+routine_names.get(i)+"</option>") ;
					}
				%>

			</select>
		</TD>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			out.println("<select name='alt_id3_routine_name' id='alt_id3_routine_name' "+sel_obj+" style='width: 175px'>");
		}
		else if ( operation.equalsIgnoreCase( "modify" ) ) {
				out.println("<select name='alt_id3_routine_name' id='alt_id3_routine_name' "+sel_obj +" style='width: 175px' disabled>");
		}
		%>
			   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
					for(int i=0;i<routine_names.size();i++)
					{
						String sel = "" ;
						if(alt_id3_routine_name.equals((String)routine_ids.get(i)))
							sel = "selected";
						   
						out.println("<option value='"+routine_ids.get(i)+"' "+sel+">"+routine_names.get(i)+"</option>") ;
					}
				 %>

			</select>
		</TD>
		<TD class='fields' height='30'>
		<%
		if ( operation.equalsIgnoreCase( "insert" ) ) {
			out.println("<select name='alt_id4_routine_name' id='alt_id4_routine_name' "+sel_obj+" style='width: 175px'>");
		}
		else if ( operation.equalsIgnoreCase( "modify" ) ) {
				out.println("<select name='alt_id4_routine_name' id='alt_id4_routine_name' "+sel_obj +"  style='width: 175px' disabled>");
		}
		%>

			   <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<%
					for(int i=0;i<routine_names.size();i++)
					{
						String sel = "" ;
						if(alt_id4_routine_name.equals((String)routine_ids.get(i)))
							sel = "selected";
						   
						out.println("<option value='"+routine_ids.get(i)+"' "+sel+">"+routine_names.get(i)+"</option>") ;
					}
				 %>

			</select>
		</TD>
	  </TR>

	  <TR height='33'>
		<TD class='fields'><input type='checkbox' name='accept_for_oth_pat_ser' id='accept_for_oth_pat_ser' value='<%=alt_id1_accept_oth_pat_ser_yn%>' <%=chkdisAcceptothpatser%>> </TD>
		<!-- Modified by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start-->
		<!--<TD class='fields'>&nbsp;</TD>
		<TD class='fields'>&nbsp;</TD>
		<TD class='fields'>&nbsp;</TD>-->
		<TD class='fields'><input type='checkbox' name='alt_id2_accept_oth_pat_ser_yn' id='alt_id2_accept_oth_pat_ser_yn' value='Y' <%=alt_id2_accept_oth_pat_ser_dis_chk%>> </TD>
		<TD class='fields'><input type='checkbox' name='alt_id3_accept_oth_pat_ser_yn' id='alt_id3_accept_oth_pat_ser_yn' value='Y' <%=alt_id3_accept_oth_pat_ser_dis_chk%>> </TD>
		<TD class='fields'><input type='checkbox' name='alt_id4_accept_oth_pat_ser_yn' id='alt_id4_accept_oth_pat_ser_yn' value='Y' <%=alt_id4_accept_oth_pat_ser_dis_chk%>> </TD>
		<!-- Modified by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End-->
	  </TR>

	  <TR>
		<TD class='fields' height='30'><input type='checkbox' name='accept_alphanumeric' id='accept_alphanumeric' value='Y' <%=chkdisAcceptAlphanumeric%>></TD>
		<!-- Modified by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start-->
		<!--<TD class='fields' height='30'>&nbsp;</TD>
		<TD class='fields' height='30'>&nbsp;</TD>
		<TD class='fields' height='30'>&nbsp;</TD>-->
		<TD class='fields' height='30'><input type='checkbox' name='alt_id2_accept_alphanumeric_yn' id='alt_id2_accept_alphanumeric_yn' value='Y' <%=alt_id2_accept_alphanumeric_dis_chk%>></TD>
		<TD class='fields' height='30'><input type='checkbox' name='alt_id3_accept_alphanumeric_yn' id='alt_id3_accept_alphanumeric_yn' value='Y' <%=alt_id3_accept_alphanumeric_dis_chk%>></TD>
		<TD class='fields' height='30'><input type='checkbox' name='alt_id4_accept_alphanumeric_yn' id='alt_id4_accept_alphanumeric_yn' value='Y' <%=alt_id4_accept_alphanumeric_dis_chk%>></TD>
		<!-- Modified by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End-->
	  </TR>
	  <TR>
		<TD class='fields' height='30'><input type='checkbox' name='alt_id1_chng_allowed_yn' id='alt_id1_chng_allowed_yn' value='Y' <%=alt_id1_chng_allowed%>></TD>
		<!-- Modified by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] Start-->
		<!--<TD class='fields' height='30'>&nbsp;</TD>
		<TD class='fields' height='30'>&nbsp;</TD>
		<TD class='fields' height='30'>&nbsp;</TD>-->
		<TD class='fields' height='30'><input type='checkbox' name='alt_id2_chng_allowed_yn' id='alt_id2_chng_allowed_yn' value='Y' <%=alt_id2_chng_allowed_dis_chk%>></TD>
		<TD class='fields' height='30'><input type='checkbox' name='alt_id3_chng_allowed_yn' id='alt_id3_chng_allowed_yn' value='Y' <%=alt_id3_chng_allowed_dis_chk%>></TD>
		<TD class='fields' height='30'><input type='checkbox' name='alt_id4_chng_allowed_yn' id='alt_id4_chng_allowed_yn' value='Y' <%=alt_id4_chng_allowed_dis_chk%>></TD>
		<!-- Modified by Dharma on Apr 2nd 2015 against HSA-CRF-0191 [IN:049772] End-->
	  </TR>
	  <tr>
	  <!--Added by Rameswar on 3rd July 2015 for MO-CRF-20099 [IN054280]-->
	  <%if( operation.equalsIgnoreCase( "modify" ) ) {
			if (!alt_id1_type.equals("")){
				disableExactYn1 = "onClick='checkAlternateId(1)'";
			}else{
				ALT_ID1_PAT_SCH_EXACT_YN_CHK="";
				disableExactYn1 = "disabled"; }
			if (!alt_id2_type.equals("")){
				disableExactYn2 = "onClick='checkAlternateId(2)'";
			}else{
				ALT_ID2_PAT_SCH_EXACT_YN_CHK="";
				disableExactYn2 = "disabled"; }
			if (!alt_id3_type.equals("")){
				disableExactYn3 = "onClick='checkAlternateId(3)'";
			}else{
				ALT_ID3_PAT_SCH_EXACT_YN_CHK="";
				disableExactYn3 = "disabled"; }
			if (!alt_id4_type.equals("")){
				disableExactYn4 = "onClick='checkAlternateId(4)'";
			}else{
				ALT_ID4_PAT_SCH_EXACT_YN_CHK="";
				disableExactYn4 = "disabled"; }
						
	  }	%>
	 
 <td class='fields' height='30'><input type='checkbox' name='alt_id1_pat_sch_exact_yn' id='alt_id1_pat_sch_exact_yn' value='Y' <%=ALT_ID1_PAT_SCH_EXACT_YN_CHK%> <%=disableExactYn1%> > </td>
 <td class='fields' height='30'><input type='checkbox' name='alt_id2_pat_sch_exact_yn' id='alt_id2_pat_sch_exact_yn' value='Y' <%=ALT_ID2_PAT_SCH_EXACT_YN_CHK%> <%=disableExactYn2%>> </td>
 <td class='fields' height='30'><input type='checkbox' name='alt_id3_pat_sch_exact_yn' id='alt_id3_pat_sch_exact_yn' value='Y' <%=ALT_ID3_PAT_SCH_EXACT_YN_CHK%> <%=disableExactYn3%> >  </td>
 <td class='fields' height='30'><input type='checkbox' name='alt_id4_pat_sch_exact_yn' id='alt_id4_pat_sch_exact_yn' value='Y' <%=ALT_ID4_PAT_SCH_EXACT_YN_CHK%> <%=disableExactYn4%>> </td>
 
	  </tr>
	  
	</TABLE>
	</div>
	</td>
</tr>
<%if(Accept_oth_alt_id_yn.equals("Y"))
								 oth_alt_id = "checked";
							if(operation.equalsIgnoreCase("modify"))
								oth_alt_id_dis ="disabled";
						%>
<tr>
<td class='label'><fmt:message key="eMP.AcceptOtherAltID.label" bundle="${mp_labels}"/></td>
<td class='fields'><input type="checkbox" name="Accept_oth_alt_id_yn" id="Accept_oth_alt_id_yn" value='Y' <%=oth_alt_id%> <%=oth_alt_id_dis%> onblur='tabs_alignment(3)'></td>
</tr>
</table>

<!-- Border test start -->
    </td>
    </tr>
    </table>
</div>

<!-- Border test end -->

<!-- Added By Parimala-->
 


<!-- <a  name="tab7" nowrap></a>  -->
<!--<a  name="tab7" nowrap></a>-->
<div id = 'NEWBORN' style = 'display:none'>
<table cellspacing='0' cellpadding='0' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" >
			<!-- <li class="tablistitem" title='<fmt:message key="eMP.PatientNumbering.label" bundle="${mp_labels}"/>'>
				<a onclick="tab_click1('pat_number_tab')" class="tabA" id="pat_number_tab" >
					<span class="tabAspan" id="pat_number_tabspan"><fmt:message key="eMP.PatientNumbering.label" bundle="${mp_labels}"/></span>
				</a>
			</li> -->
			<li class="tablistitem" title='<fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/>'>
				<a class="tabA" id="pat_admin_tab" >
					<span class="tabAspan" id="pat_admin_tabspan" onClick='javascript:expandCollapse("pat_admin_tab")'><fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/></span>
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
				<a class="tabClicked" id="new_born_tab" >
					<span class="tabSpanclicked" id="new_born_tabspan" onClick='javascript:expandCollapse("new_born_tab")'><fmt:message key="eMP.NewBorn.label" bundle="${mp_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title='<fmt:message key="Common.others.label" bundle="${common_labels}"/>'>
				<a class="tabA" id="others_tab" >
					<span class="tabAspan" id="others_tabspan" onClick='javascript:expandCollapse("others_tab")'><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<% if("Y".equalsIgnoreCase(aadharProfileYN)) {%>
				 <li class="tablistitem" title='AADHAR2222'>
				<a class="tabA" id="aadhar_tab" >
					<span class="tabAspan" id="aadhar_tabspan" onClick='javascript:expandCollapse("aadhar_tab")'><fmt:message key="eMP.AADHAR.label" bundle="${mp_labels}"/></span>
			</a>
			</li>
			<%} %>
			</ul>
 </td></tr>
</table>	
<table border='0' cellpadding='0' cellspacing='0' width='100%'>

</table>
    <table border='0' cellpadding='0' cellspacing='0' width='100%'>
    <tr>
    <td class="BORDER">
    
    <table border='0' cellpadding='1' cellspacing='0' width='100%'>
	<%
		
						 chked ="";
						 if (single_stage_nb_reg_appl_yn.equals("Y"))
								chked = "checked";
					%>

	<tr>
						 <td class='label'  nowrap ><fmt:message key="eMP.SingleStageNewBornRegnAppl.label" bundle="${mp_labels}"/> </td>
						<td class='fields'><input type='checkbox' name='single_stage_nb_reg_appl_yn' id='single_stage_nb_reg_appl_yn' value='Y' <%=chked%>></td>
		</tr>
          
		<tr><td class='label'><fmt:message key="eMP.AllowRegistrationWithin.label" bundle="${mp_labels}"/></td>
		<td  class='fields' nowrap colspan=3><input type='text' name='allow_nb_regn_within_days' id='allow_nb_regn_within_days' value='<%=allow_nb_regn_within_days%>' maxlength=2 size = 2 onkeypress="return allowValidNumber(this,event,2, 0);" onBlur='CheckNum(this);checkDecimal(this);' onfocus='tabs_alignment(3)'>
		<%if(!(allow_nb_regn_within_days==null || allow_nb_regn_within_days==""))	 {%>
		<select name="allow_nb_regn_unit" id="allow_nb_regn_unit" disabled >
			<%
		   	
		if(allow_nb_regn_unit.equals("D")){%>	
		<option value='H' disabled><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option><option value='D' selected disabled><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
		<%}else{%>	
		<option value='H' selected disabled><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option><option value='D' disabled><fmt:message key="Common.days.label" bundle="${common_labels}"/></option> 
			  </select>&nbsp;<fmt:message key="Common.of.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.birthDate.label" bundle="${common_labels}"/>	  
			<%}}else{%>
			<select name="allow_nb_regn_unit" id="allow_nb_regn_unit">
		<%if(allow_nb_regn_unit.equals("D")){%>	
		<option value='H' ><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option><option value='D' selected><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
		<%}else{%>	
		<option value='H' selected><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option><option value='D' ><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
			<%}%>
		</select>&nbsp;<fmt:message key="Common.of.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.birthDate.label" bundle="${common_labels}"/><%}%></td>
		</tr>
		<tr><td class='label' nowrap>
			 <fmt:message key="eMP.SubsequentRegnofMultipleBirthWithin.label" bundle="${mp_labels}"/></td>
			<td class='fields'><input type='text' name='mul_birth_regn_within_hours' id='mul_birth_regn_within_hours' value='<%=mul_birth_regn_within_hours%>' maxlength=2 size = 2 onkeypress="return allowValidNumber(this,event,2, 0);" onBlur='CheckNum(this);checkDecimal(this);checkForZero(this);validateValue(this)'>&nbsp;
			<%if(sub_multi_birth_hw.equals("H")){%>
			<input type='radio' value='H' name='sub_multi_birth_hw' id='sub_multi_birth_hw' checked onclick='subNewBornHW(this)'>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
			<%}else{%>
			<input type='radio' value='H' name='sub_multi_birth_hw' id='sub_multi_birth_hw' onclick='subNewBornHW(this)'>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
			<%}
			if(sub_multi_birth_hw.equals("W")){	%>
			<input type='radio' value='W' name='sub_multi_birth_hw' id='sub_multi_birth_hw' checked onclick='subNewBornHW(this)'><fmt:message key="Common.weeks.label" bundle="${common_labels}"/>	
			<%} else{%>
			<input type='radio' value='W' name='sub_multi_birth_hw' id='sub_multi_birth_hw' onclick='subNewBornHW(this)'><fmt:message key="Common.weeks.label" bundle="${common_labels}"/>	
			<%}%>
            </td>
		</tr>
		<tr>
			<td class='label' nowrap><%
				 chked ="";
				 if (nb_use_mother_ser.equals("Y"))
					chked = "checked";
//					 valu="Y";
				 if (gen_pid_using_aid1_rule_yn.equals("Y"))
				{
						box_valu="N";
						chk_box_disb="disabled";
//						out.println("valu==in IF=>" +box_valu);
				 }
				 else
				{
						box_valu="Y";
						chk_box_disb="";
//												out.println("valu==in=else=>" +box_valu);

				 }
//				 out.println("valu==in=out Side=>" +box_valu);
			%> <% if(module_instal_ind.equals("DMS")) { %>
				<fmt:message key="eMP.UM_PatientSeriesSameAsMotherSeries.label" bundle="${mp_labels}"/> 
				<% }else{%>
			<fmt:message key="eMP.PatientSeriesSameAsMotherSeries.label" bundle="${mp_labels}"/><%}%>
			</td>
			<td class='fields'>
				<input type='checkbox' name='nb_use_mother_ser' id='nb_use_mother_ser' value='<%=box_valu%>' <%=chked%><%=chk_box_disb%>> 
					<%

						 chked ="";
						 if (review_nb_links_bef_reg_yn.equals("Y"))
								chked = "checked";
					%>
			</tr>
			<tr>
						 <td class='label'  nowrap ><fmt:message key="eMP.ReviewMotherbabylinkbeforeRegn.label" bundle="${mp_labels}"/> </td>
						<td class='fields'><input type='checkbox' name='review_nb_links_bef_reg_yn' id='review_nb_links_bef_reg_yn' value='Y' <%=chked%>></td>
		</tr>
        
				<tr>
						<td class='label' nowrap ><fmt:message key="eMP.DispNBAgeInHrIfAgeLT.label" bundle="${mp_labels}"/></td>
						<td class='fields'><input type='text' name='display_new_born_age_in_hrs' id='display_new_born_age_in_hrs' value="<%=display_new_born_age%>" maxlength=2 size = 2 onKeyPress= 'return allowNumOnly(event);' onBlur='chkValue(this);'> <fmt:message key="Common.hours.label" bundle="${common_labels}"/> </td>
		</tr>		
			
			<tr>    
            <td class='label' nowrap><fmt:message key="eMP.AgeLimitofMother.label" bundle="${mp_labels}"/></td>
			<td nowrap >
				<table border=0>
					<tr class='label'>
						<td nowrap class='oaborder' >&nbsp;<fmt:message key="Common.MIN.label" bundle="${common_labels}"/>&nbsp;<input type='text' name='min_age_of_moth' id='min_age_of_moth' value='<%=min_age_of_moth%>' maxlength=2 size = 2 onKeyPress='return  allowValidNumber(this,event,2, 0);'onBlur='valid_dat(this);CheckNum(this);validate_max();checkDecimal(this);'>&nbsp;&nbsp;<fmt:message key="Common.Max.label" bundle="${common_labels}"/>&nbsp;<input type='text' name='max_age_of_moth' id='max_age_of_moth' value='<%=max_age_of_moth%>' maxlength=2 size = 2 onKeyPress='return  allowValidNumber(this,event,2, 0);' onBlur='valid_dat(this);CheckNum(this);checkDecimal(this);'>&nbsp; &nbsp;<fmt:message key="eMP.MinCutOff.label" bundle="${mp_labels}"/>&nbsp;<input type='text' name='cut_age_of_moth' id='cut_age_of_moth' value='<%=cut_age_of_moth%>' maxlength=2 size = 2 onKeyPress='return  allowValidNumber(this,event,2, 0);' onBlur='valid_dat(this);CheckNum(this);checkDecimal(this);'> 
						</td>
						<td width='2%' class='label'></td>
					</tr>
				  </table>  
		    </td> 
			<td class='label' ><fmt:message key="Common.Years.label" bundle="${common_labels}"/></td><td width='40%' nowrap></td>
			<td class='label' >&nbsp;</td>
	</tr>	
	<tr>
					<td class='label' ><fmt:message key="eMP.MinimumAgeofFather.label" bundle="${mp_labels}"/></td>
					<td  class='fields' nowrap colspan=3><input type='text' name='min_age_of_fath' id='min_age_of_fath' value='<%=min_age_of_fath%>' maxlength=2 size = 2 onKeyPress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);'>&nbsp;<fmt:message key="Common.Years.label" bundle="${common_labels}"/></td>
	</tr>    
	<!-- <%-- Invoking change patient Details from New Born is not required for Thai
		<tr>
				<td class = 'label'nowrap colspan=1><fmt:message key="eMP.InvokeChangePatientDetailsinNewbornRegn.label" bundle="${mp_labels}"/></td>
				<td class='fields'  nowrap >
				<%
				chked="";
				if  (invoke_chg_pat_dtls_fm_nb_yn.equals("Y"))
					out.println( "<input type='checkbox' name='invoke_chg_pat_dtls_fm_nb_yn' id='invoke_chg_pat_dtls_fm_nb_yn' value='Y' checked onClick='checkForMode(this)'>"); 
				 else
					 out.println( "<input type='checkbox' name='invoke_chg_pat_dtls_fm_nb_yn' id='invoke_chg_pat_dtls_fm_nb_yn' value='N' onClick='checkForMode(this)'>" ) ;
				%>
				</td>
		</tr>
	--%> -->
		   <tr>
				 <td class='label'  nowrap ><fmt:message key="eMP.NewBornFatherNameMandatory.label" bundle="${mp_labels}"/> </td>
                  <td class='fields'>    
			     <%
				 if  (nb_father_name_mandatory_yn.equals("Y")){
					%>
					<input type='checkbox' name='nb_father_name_mandatory_yn' id='nb_father_name_mandatory_yn' value='Y' checked onClick='checkForMode(this)'>
				<%
				}else{ %>
					<input type='checkbox' name='nb_father_name_mandatory_yn' id='nb_father_name_mandatory_yn' value='N' onClick='checkForMode(this)'>
				<%}%>     
			   
			</td>
			<td class='label'  nowrap ><fmt:message key="eMP.ModifyMotherdetailsinMultipleBirth.label" bundle="${mp_labels}"/> </td>
				<td><input type='checkbox' name='nb_mother_dtls_update_yn' id='nb_mother_dtls_update_yn' value='<%=nb_mother_dtls_update_yn %>'  onClick='checkForMode(this)' <%=Checkedchk%> > </td>
		</tr>

		<tr>
			 <td class='label'  nowrap ><fmt:message key="eMP.ChngofDataAlwdAfrFinalization.label" bundle="${mp_labels}"/> </td>
			 <td class='fields'>    
			 <%
			    if ( operation.equalsIgnoreCase( "insert" ) ){
				 if  (data_upd_allowed_aft_final_yn.equals("Y")){
					%>
					<input type='checkbox' name='data_upd_allowed_aft_final_yn' id='data_upd_allowed_aft_final_yn' value='Y' checked onClick='checkForMode(this)'>
			<%
				}else{ %>
					<input type='checkbox' name='data_upd_allowed_aft_final_yn' id='data_upd_allowed_aft_final_yn' value='N' onClick='checkForMode(this)'>
				<%}
		       }
			   if (operation.equalsIgnoreCase( "modify" ) ) { 
				   if  (data_upd_allowed_aft_final_yn.equals("Y")){
			   %>
					<input type='checkbox' name='data_upd_allowed_aft_final_yn' id='data_upd_allowed_aft_final_yn' value='Y' checked onClick='checkForMode(this)' disabled>
			   <%
				}else{
			   %>
					<input type='checkbox' name='data_upd_allowed_aft_final_yn' id='data_upd_allowed_aft_final_yn' value='N' onClick='checkForMode(this)' disabled>
				<%}
		       }%>
				</td>
				<td class='label'  nowrap ><fmt:message key="eMP.AcceptNamesforLiveBirth.label" bundle="${mp_labels}"/> </td>
				<td class='fields'>   
				<%
					 if(accept_names_for_live_birth_yn.equals("Y")){
						%>
						<input type='checkbox' name='accept_names_for_live_birth_yn' id='accept_names_for_live_birth_yn' value='Y' checked onClick='checkForMode(this)'>
					<%
					}else{ %>
						<input type='checkbox' name='accept_names_for_live_birth_yn' id='accept_names_for_live_birth_yn' value='N' onClick='checkForMode(this)'>
				<%	} %>
				</td>
		</tr>

	</table>
    <table border='0' cellpadding='3' cellspacing='0' width='100%'>
          <%
            String radio_chked = ""; 
           %>
		<tr>
            <td class='columnheader' width='35%'><fmt:message key="eMP.RangeValues.label" bundle="${mp_labels}"/></td>
            <td class='columnheader' width='25%'><fmt:message key="Common.Minimum.label" bundle="${common_labels}"/><fmt:message key="Common.maximum.label" bundle="${common_labels}"/></td>
            <td class='columnheader' width='10%'>&nbsp;</td>
			<td class='columnheader' width='30%'>&nbsp;</td>
        </tr>
		<tr>
			<td colspan=1 class='label' nowrap><fmt:message key="Common.weight.label" bundle="${common_labels}"/></td>	
			<td class='fields'><input type='text' name='min_weight' id='min_weight' maxLength=6 size=5 onKeyPress="return allowValidNumber(this,event,2,3);" value="<%=min_weight%>" onblur='CheckPositiveNumber(this)' >&nbsp;&nbsp;<input type='text' name='max_weight' id='max_weight' maxLength=6 size=5 onKeyPress="return allowValidNumber(this,event,2,3);" value="<%=max_weight%>" onblur='CheckPositiveNumber(this)'></td>
			
		    <td class='fields'>
			<%
			 if(!(unit_of_wt_nb.equals("")))
			   {   %>
			<%if(unit_of_wt_nb.equals("K")) radio_chked ="checked"; %>	  
			<input type='radio' value='K' name='unit_of_wt_nb' id='unit_of_wt_nb' <%=radio_chked%> disabled><fmt:message key="Common.kg.label" bundle="${common_labels}"/>  <%
			  radio_chked="";if(unit_of_wt_nb.equals("L")) radio_chked ="checked"; %>
				</td><td class='fields'>  <input type='radio' value='L' name='unit_of_wt_nb' id='unit_of_wt_nb' <%=radio_chked%> disabled><fmt:message key="Common.lb.label" bundle="${common_labels}"/></td></tr>
					  <%}else{%>
		 
			<input type='radio' value='K' name='unit_of_wt_nb' id='unit_of_wt_nb' onclick='uomcheck(this)'><fmt:message key="Common.kg.label" bundle="${common_labels}"/> </td><td class='fields'><input type='radio' value='L' name='unit_of_wt_nb' id='unit_of_wt_nb' onclick='uomcheck(this)'><fmt:message key="Common.lb.label" bundle="${common_labels}"/>&nbsp;</td>
		</tr>	 <%}%>
		<tr>
			<td colspan=1 class='label' nowrap><fmt:message key="Common.length.label" bundle="${common_labels}"/></td>	
			<td class='fields'><input type='text' name='min_length' id='min_length' maxLength=6 size=5 onKeyPress="return allowValidNumber(this,event,3,2);" value="<%=min_length%>" onblur='CheckPositiveNumber(this)' >&nbsp;&nbsp;<input type='text' name='max_length' id='max_length' maxLength=6 size=5 onKeyPress="return allowValidNumber(this,event,3,2);" value="<%=max_length%>" onblur='CheckPositiveNumber(this)'></td>
			<%radio_chked="";if(unit_of_circum_nb.equals("C")) radio_chked ="checked"; %> 
			 <td class='fields'>			
			<%if(!(unit_of_circum_nb.equals("")))
			   {%>
		   <input type='radio' value='C' name='unit_of_circum_nb' id='unit_of_circum_nb' 
			<%=radio_chked%> disabled><fmt:message key="Common.cm.label" bundle="${common_labels}"/><%radio_chked="";if(unit_of_circum_nb.equals("I")) radio_chked ="checked"; %></td><td class='fields'><input type='radio' value='I' name='unit_of_circum_nb' id='unit_of_circum_nb'
			 <%=radio_chked%> disabled><fmt:message key="Common.Inch.label" bundle="${common_labels}"/></td>
		</tr><%}else{%>
           <input type='radio' value='C' name='unit_of_circum_nb' id='unit_of_circum_nb' onclick='uomcheck(this)'><fmt:message key="Common.cm.label" bundle="${common_labels}"/></td><td class='fields'><input type='radio' value='I' name='unit_of_circum_nb' id='unit_of_circum_nb' onclick='uomcheck(this)'><fmt:message key="Common.Inch.label" bundle="${common_labels}"/>&nbsp;</td>
		</tr><%}%>
		<tr>
			<td colspan=1 class='label' nowrap><fmt:message key="Common.HeadCircumference.label" bundle="${common_labels}"/></td>	
			<td class='fields'><input type='text' name='min_head_circum' id='min_head_circum' maxLength=6 size=5 onKeyPress="return allowValidNumber(this,event,3,2);" value="<%=min_head_circum%>" onblur='CheckPositiveNumber(this)'>&nbsp;&nbsp;<input type='text' name='max_head_circum' id='max_head_circum' maxLength=6 size=5 onKeyPress="return allowValidNumber(this,event,3,2);" value="<%=max_head_circum%>" onblur='CheckPositiveNumber(this)' ></td>
			<%radio_chked = ""; if(unit_of_length_nb.equals("C")) radio_chked ="checked"; %>            
            <td class='fields'>
			<%if(!(unit_of_length_nb.equals("")))
			   {  %>
			   <input type='radio' value='C' name='unit_of_length_nb' id='unit_of_length_nb'
		   <%=radio_chked%><%radio_chked = ""; if(unit_of_length_nb.equals("I")) radio_chked ="checked"; %>  disabled><fmt:message key="Common.cm.label" bundle="${common_labels}"/></td><td class='fields'>
			   <input type='radio' value='I' name='unit_of_length_nb' id='unit_of_length_nb' 
			<%=radio_chked%> disabled><fmt:message key="Common.Inch.label" bundle="${common_labels}"/>&nbsp;</td> 
		</tr><%}else{%>
				 <input type='radio' value='C' name='unit_of_length_nb' id='unit_of_length_nb' onclick='uomcheck(this)'><fmt:message key="Common.cm.label" bundle="${common_labels}"/></td><td class='fields'><input type='radio' value='I' name='unit_of_length_nb' id='unit_of_length_nb' onclick='uomcheck(this)'><fmt:message key="Common.Inch.label" bundle="${common_labels}"/>&nbsp;</td> 
		</tr>  <%}%>
		<tr>
			<td colspan=1 class='label'nowrap><fmt:message key="eMP.ChestCirumference.label" bundle="${mp_labels}"/></td>	
			<td class='fields'><input type='text' name='min_chest_circum' id='min_chest_circum' maxLength=6 size=5 onKeyPress="return allowValidNumber(this,event,3,2);" value="<%=min_chest_circum%>" onblur='CheckPositiveNumber(this)'>&nbsp;&nbsp;<input type='text' name='max_chest_circum' id='max_chest_circum' maxLength=6 size=5 onKeyPress="return allowValidNumber(this,event,3,2);" value="<%=max_chest_circum%>" onblur='CheckPositiveNumber(this)' ></td>
			<%radio_chked = ""; if(unit_of_chest_circum_nb.equals("C")) radio_chked ="checked"; %>            
            <td class='fields'>
			<%if(!(unit_of_chest_circum_nb.equals("")))
			   {%>
			   <input type='radio' value='C' name='unit_of_chest_circum_nb' id='unit_of_chest_circum_nb'
		   <%=radio_chked%><%radio_chked = ""; if(unit_of_chest_circum_nb.equals("I")) radio_chked ="checked"; %>  disabled><fmt:message key="Common.cm.label" bundle="${common_labels}"/></td><td class='fields'><input type='radio' value='I' name='unit_of_chest_circum_nb' id='unit_of_chest_circum_nb' 
			<%=radio_chked%> disabled><fmt:message key="Common.Inch.label" bundle="${common_labels}"/></td> 
		</tr><%}else{%>
				 <input type='radio' value='C' name='unit_of_chest_circum_nb' id='unit_of_chest_circum_nb' onclick='uomcheck(this)'><fmt:message key="Common.cm.label" bundle="${common_labels}"/></td><td class='fields'><input type='radio' value='I' name='unit_of_chest_circum_nb' id='unit_of_chest_circum_nb' onclick='uomcheck(this)'><fmt:message key="Common.Inch.label" bundle="${common_labels}"/></td> 
		</tr>  <%}%>
		<tr>
			<td colspan=1 class='label' nowrap><fmt:message key="eMP.Gestation.label" bundle="${mp_labels}"/></td>	
			<td class='fields'><input type='text' name='min_gestation' id='min_gestation' maxLength=3 size=5 onKeyPress="return allowValidNumber(this,event,3,0);" value="<%=min_gestation%>" onblur='CheckPositiveNumber(this)' >&nbsp;&nbsp;<input type='text' name='max_gestation' id='max_gestation' maxLength=3 size=5 onKeyPress="return allowValidNumber(this,event,3,0);" value="<%=max_gestation%>" onblur='CheckPositiveNumber(this)'></td>
			<%radio_chked = ""; if(unit_of_gest_nb.equals("W")) radio_chked ="checked"; %>          
            <td class='fields'>
			<%if(!(unit_of_gest_nb.equals("")))
			   {%>	
				   <input type='radio' value='W' name='unit_of_gest_nb' id='unit_of_gest_nb' <%=radio_chked%> disabled> <fmt:message key="Common.weeks.label" bundle="${common_labels}"/></td><td class='fields'> <%radio_chked = ""; if(unit_of_gest_nb.equals("D")) radio_chked ="checked"; %>
				   <input type='radio' value='D' name='unit_of_gest_nb' id='unit_of_gest_nb' <%=radio_chked%> disabled>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td> 
		</tr><%}else{%>
					   
		<input type='radio' value='W' name='unit_of_gest_nb' id='unit_of_gest_nb' onclick='uomcheck(this)'><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></td><td class='fields'>
		<input type='radio' value='D' name='unit_of_gest_nb' id='unit_of_gest_nb' onclick='uomcheck(this)'>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></td> 
		</tr><%}%>
		<tr><td class='label' nowrap><fmt:message key="eMP.Periodbetweentwodeliveries.label" bundle="${mp_labels}"/></td><td  class='fields' ><input type='text' name='gestation_two_del' id='gestation_two_del' maxLength=3 size=5 onKeyPress="return allowValidNumber(this,event,3,0);" value="<%=gestation_two_del%>" onblur='CheckPositiveNumberMP(this)'><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></td>
		<input type=hidden name='h_unit_of_wt_nb' id='h_unit_of_wt_nb' value=<%=unit_of_wt_nb%>>
        <input type=hidden name='h_unit_of_length_nb' id='h_unit_of_length_nb' value=<%=unit_of_length_nb%>>
		<input type=hidden name='h_unit_of_gest_nb' id='h_unit_of_gest_nb' value=<%=unit_of_gest_nb%>>
		<input type=hidden name='h_unit_of_circum_nb' id='h_unit_of_circum_nb' value=<%=unit_of_circum_nb%>>
		<input type=hidden name='h_unit_of_chest_circum_nb' id='h_unit_of_chest_circum_nb' value=<%=unit_of_chest_circum_nb%>>
		<td  colspan='2'>&nbsp;</td></tr>	
        <tr>
            <td colspan='4' class='columnheader'><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Values.label" bundle="${common_labels}"/></td>
        </tr>
		<tr><td colspan='4' class='label'></td></tr>
		<tr><td colspan='4' class='label'></td></tr>
		<tr><td colspan='4' class='label'></td></tr>
        <tr>
            <td class='label' ><fmt:message key="Common.male.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMP.prefix.label" bundle="${mp_labels}"/></td>
            <td width='30%' class='fields'>
                <select name="name_prefix_male_nb" id="name_prefix_male_nb" style='width: 180px'>
                <option value=''>----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
                <%
                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();

                    stmt = con.createStatement() ;
                    rset = stmt.executeQuery ( " Select NAME_PREFIX from MP_NAME_PREFIX WHERE  PREFIX_SEX in ('M', 'B') and Eff_Status = 'E' order by 1" ) ;
                    
                    if(rset != null)
                    {
                        while(rset.next())
                        {
                            chked = "" ;
                            if(name_prefix_male_nb.equals(rset.getString("NAME_PREFIX")))
                                chked = "selected" ;
                                out.println( "<option value=\""+rset.getString("NAME_PREFIX")+"\" "+chked+">"+rset.getString("NAME_PREFIX")+"</option>" ) ; 
                        }
                    }

                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();                           
                %>
                </td>
            <td class='label' ><fmt:message key="Common.female.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMP.prefix.label" bundle="${mp_labels}"/></td>
            <td class='fields'>
                <select name="name_prefix_female_nb" id="name_prefix_female_nb" style='width: 180px'>
                <option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
                <%
                    

                    stmt = con.createStatement() ;
                    rset = stmt.executeQuery ( " Select NAME_PREFIX from MP_NAME_PREFIX WHERE  PREFIX_SEX in ('F', 'B') and Eff_Status = 'E' order by 1" ) ;
					
				
                    if(rset != null)
                    {
                        while(rset.next())
                        {
                            chked = "" ;
                            if(name_prefix_female_nb.equals(rset.getString("NAME_PREFIX")))
                                chked = "selected" ;
                                out.println( "<option value=\""+rset.getString("NAME_PREFIX")+"\" "+chked+">"+rset.getString("NAME_PREFIX")+"</option>" ) ; 
                        }
                    }

                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();                           
                %>
            </td>
        </tr>
<!--        <tr>
            <td colspan='4' class='columnheader'><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.NameSuffix.label" bundle="${common_labels}"/></td> 
        </tr>
 --> 
        <tr>
            <td class='label' ><fmt:message key="Common.male.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMP.Suffix.label" bundle="${mp_labels}"/></td>
            <td width='30%' class='fields'>
                <select name="name_suffix_male_nb" id="name_suffix_male_nb" >
                <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
                <%
                   
                    stmt = con.createStatement() ;
                    rset = stmt.executeQuery ( " Select NAME_SUFFIX from MP_NAME_SUFFIX WHERE BABY_SUFFIX_YN = 'Y' and BABY_SEX in ('M','B') and Eff_Status = 'E' order by 1" ) ;
                    
				
                    if(rset != null)
                    {
                        while(rset.next())
                        {
                            chked = "" ;
                            if(name_suffix_male_nb.equals(rset.getString("NAME_SUFFIX")))
                                chked = "selected" ;
                                out.println( "<option value=\""+rset.getString("NAME_SUFFIX")+"\" "+chked+">"+rset.getString("NAME_SUFFIX")+"</option>" ) ; 
                        }
                    }

                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();                           
                %>
                </td>
            <td class='label' ><fmt:message key="Common.female.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eMP.Suffix.label" bundle="${mp_labels}"/></td>
            <td class='fields'>
                <select name="name_suffix_female_nb" id="name_suffix_female_nb" >
                <option value=''>--------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
                <%
                    
                    stmt = con.createStatement() ;
                    rset = stmt.executeQuery ( " Select NAME_SUFFIX from MP_NAME_SUFFIX WHERE BABY_SUFFIX_YN = 'Y' and BABY_SEX in ('F','B') and Eff_Status = 'E' order by 1" ) ;
                   
				
                    if(rset != null)
                    {
                        while(rset.next())
                        {
                            chked = "" ;
                            if(name_suffix_female_nb.equals(rset.getString("NAME_SUFFIX")))
                                chked = "selected" ;
                                out.println( "<option value=\""+rset.getString("NAME_SUFFIX")+"\" "+chked+">"+rset.getString("NAME_SUFFIX")+"</option>" ) ; 
                        }
                    }

                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();                           
                %>
            </td>
        </tr>
<!-- 		<tr>
            <td colspan='4' class='columnheader'><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
        </tr>
 -->
        <tr>
            <td class='label' ><fmt:message key="Common.male.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
            <td width='30%' class='fields'>
                <select name="dft_rel_male_nb" id="dft_rel_male_nb" >
                <option value=''>----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
                <%
					String select_val = "";
					stmt = con.createStatement() ;
                    rset = stmt.executeQuery ( "select short_desc,relationship_code from MP_RELATIONSHIP where eff_status='E' order by 1 " ) ;
                 
					
                    if(rset != null)
                    {
                        while(rset.next())
                        {select_val = "";
                            relationship_male_code = rset.getString("relationship_code");
                            relationship_male_code_desc = rset.getString("short_desc");
							
							if(dft_rel_male_nb.equals(relationship_male_code))
								select_val = "selected";
							out.println( "<option value=\""+relationship_male_code+"\" "+select_val+">"+relationship_male_code_desc+"</option>" ) ; 
                        }
                    }

                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();                           
                %>
                </td>
            <td class='label' ><fmt:message key="Common.female.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
            <td class='fields'>
                <select name="dft_rel_female_nb" id="dft_rel_female_nb" >
                <option value=''>----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
                <%
					String select_val_female = "";
					stmt = con.createStatement() ;
                    rset = stmt.executeQuery ( "select short_desc,relationship_code from MP_RELATIONSHIP where eff_status='E' order by 1 " ) ;
				
                    if(rset != null)
                    {
                        while(rset.next())
                        {
							select_val_female = "";
                            relationship_female_code = rset.getString("relationship_code");
                            relationship_female_code_desc = rset.getString("short_desc");
							if(dft_rel_female_nb.equals(relationship_female_code))
								select_val_female = "selected";
							out.println( "<option value=\""+relationship_female_code+"\" "+select_val_female+">"+relationship_female_code_desc+"</option>" ) ; 
                        }
                    }

                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();                        
                %>
            </td>
        </tr>
					<tr><td class='label'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
            <td class='fields'>
                <select name="dft_rel_unknown_nb" id="dft_rel_unknown_nb" >
                <option value=''>----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option><%
					String select_val_unknown = "";
					stmt = con.createStatement() ;
                    rset = stmt.executeQuery ( "select short_desc,relationship_code from MP_RELATIONSHIP where eff_status='E' order by 1 " ) ;
                    
                    if(rset != null)
                    {
                        while(rset.next())
                        {	select_val_unknown = "";
                            relationship_unknown_code = rset.getString("relationship_code");
                            relationship_unknown_code_desc = rset.getString("short_desc");
							if(dft_rel_unknown_nb.equals(relationship_unknown_code)){
								select_val_unknown = "selected";}
							out.println( "<option value=\""+relationship_unknown_code+"\" "+select_val_unknown+">"+relationship_unknown_code_desc+"</option>" ) ; 
                        }
                    }

                                             
                %><td class='label'><fmt:message key="eMP.StillBornPrefix.label" bundle="${mp_labels}"/></td>
			            <td width='30%' class='fields'>
                <select name="still_born_prefix" id="still_born_prefix" style='width: 180px' >
                <option value=''>----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
                <%
                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();

                    stmt = con.createStatement() ;
                    rset = stmt.executeQuery ( " Select NAME_PREFIX from MP_NAME_PREFIX WHERE prefix_sex='B' and  Eff_Status = 'E' order by 1" ) ;
                    
                    if(rset != null)
                    {
                        while(rset.next())
                        {
                            chked = "" ;
                            if(still_born_prefix.equals(rset.getString("NAME_PREFIX")))
                                chked = "selected" ;
                                out.println( "<option value=\""+rset.getString("NAME_PREFIX")+"\" "+chked+">"+rset.getString("NAME_PREFIX")+"</option>" ) ; 
                        }
                    }

                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();                           
                %>
                </td></tr>
				 </tr>
					<tr><td class='label'><fmt:message key="eMP.DfltRaceNationalitySetupofNB.label" bundle="${mp_labels}"/></td>
            <td class='fields'>
                <select name="dflt_race_nat_setup_nb_as_per" id="dflt_race_nat_setup_nb_as_per" onblur=''>
			<%if (dflt_race_nat_setup_nb_as_per.equals("M")){%>
			 <option value='M' selected><fmt:message key="eMP.motherdetails.label" bundle="${mp_labels}"/>
		   <%}else {%>
				 <option value='M' ><fmt:message key="eMP.motherdetails.label" bundle="${mp_labels}"/>
		  <%}if (dflt_race_nat_setup_nb_as_per.equals("F")){%>
				 <option value='F' selected><fmt:message key="eMP.fatherdetails.label" bundle="${mp_labels}"/>
		   <%}else {%>
				 <option value='F' ><fmt:message key="eMP.fatherdetails.label" bundle="${mp_labels}"/>
		   <%}if (dflt_race_nat_setup_nb_as_per.equals("P")){%>
				 <option value='P' selected><fmt:message key="eMP.MPParameter.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.setup.label" bundle="${common_labels}"/>
			<%}else {%>
				 <option value='P' ><fmt:message key="eMP.MPParameter.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.setup.label" bundle="${common_labels}"/>
			<%}%>
			</select>
			</td>		
			<%			   
			   if(pstmt!=null) pstmt.close();
			   if(rs!=null) rs.close();
			   pstmt = con.prepareStatement("select short_desc from mp_relationship where eff_status='E' and relationship_code='"+default_relationship_code+"' ");
               rs = pstmt.executeQuery();
			   while(rs.next()){
				relationship_desc=rs.getString("short_desc");
               }
			   if(relationship_desc.equals(""))
					default_relationship_code = "" ;
               if(pstmt != null)    pstmt.close();
               if(rs != null)    rs.close();
			   %>
		<td  class='label' nowrap><fmt:message key="eMP.Dfltrelnshipnewborn.label" bundle="${mp_labels}"/></td> 
		<td  class='fields'> <input type='text' name='default_relationship_desc' id='default_relationship_desc' size='20' maxlength='20' value="<%=relationship_desc%>" onblur='if(this.value!=""){searchRelationship(default_relationship,default_relationship_desc);}else{document.forms[0].default_relationship.value = "";}'><input type='button'  id='default_relationship_id'  name='default_relationship_code_id' id='default_relationship_code_id' value='?' class='button' onclick='searchRelationship(this,default_relationship_desc)' >
		<input type='hidden' name='default_relationship' id='default_relationship' value="<%=default_relationship_code%>">
		</td> 
</tr>
    </table>
<!-- Ends Here -->
<!-- Border test start -->
    </td>
    </tr>
    </table>
</div>

<!-- Border test end --> 

<!-- 
<a  name="tab10" nowrap></a>  -->
<!--<a  name="tab10" nowrap></a>-->
<div id = 'OTHERS' style = 'display:none'>

<!--Commented br sarita-->
<table cellspacing='0' cellpadding='0' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" >
			
			<li class="tablistitem" title='<fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/>'>
				<a class="tabA" id="pat_admin_tab" >
					<span class="tabAspan" id="pat_admin_tabspan" onClick='javascript:expandCollapse("pat_admin_tab")'><fmt:message key="Common.PatientAdministration.label" bundle="${common_labels}"/></span>
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
				<a class="tabClicked" id="others_tab" >
					<span class="tabSpanclicked" id="others_tabspan" onClick='javascript:expandCollapse("others_tab")'><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<% if("Y".equalsIgnoreCase(aadharProfileYN)) {%>
				 <li class="tablistitem" title='AADHAR333'>
				<a class="tabA" id="aadhar_tab" >
					<span class="tabAspan" id="aadhar_tabspan" onClick='javascript:expandCollapse("aadhar_tab")'><fmt:message key="eMP.AADHAR.label" bundle="${mp_labels}"/></span>
			</a>
			</li>
			<% } %>
			</ul>
 </td></tr>
</table>

<table border='0' cellpadding='3' cellspacing='0' width='100%'>

				<tr>
                <td colspan='4' class='COLUMNHEADER'><fmt:message key="Common.general.label" bundle="${common_labels}"/></td>
				</tr>

				<tr>
				<td class="label" width='40%'>
				<% if(module_instal_ind.equals("DMS")) { %>
				<fmt:message key="eMP.UM_MaxPatientAge.label" bundle="${mp_labels}"/></td>
				<%} else { %>
				<fmt:message key="eMP.MaxPatientAge.label" bundle="${mp_labels}"/></td>
				<%}%>
				<td class="fields" width='10%'><input type='text' name='max_patient_age' id='max_patient_age' maxLength='3' size='3' onKeyPress='return allowValidNumber(this,event,3, 0);' value="<%=max_patient_age%>" nowrap><fmt:message key="Common.Years.label" bundle="${common_labels}"/>
				 </td>
				 <td class="label"  width='40%'><fmt:message key="eMP.DefaultAltID1ValueinEmp.ID.label" bundle="${mp_labels}"/></td>
				<td class='fields' width='10%'>
				<%
                if ( dflt_alt_id1_in_emp_id_yn .equals( "Y" ) )	
                    out.println( "<input type='checkbox' name='dflt_alt_id1_in_emp_id_yn' id='dflt_alt_id1_in_emp_id_yn' value='Y' checked onClick='checkForMode(this)'>"); 
                else
                    out.println( "<input type='checkbox' name='dflt_alt_id1_in_emp_id_yn' id='dflt_alt_id1_in_emp_id_yn' value='N' onClick='checkForMode(this)'>" ) ;
				%>
			</td>
		</tr>
				
		<tr>
				<!-- explicitly changed the class as fields -->	
					<td class='label' width='40%'><% if(module_instal_ind.equals("DMS")) { %><fmt:message key="eMP.UM_ApplyEligibilityRulesbyPatientCategory.label" bundle="${mp_labels}"/>
					<%} else { %>
					<fmt:message key="eMP.ApplyEligibilityRulesbyPatientCategory.label" bundle="${mp_labels}"/>
					<%}%>
					<td class="fields" width='10%'>
						<%
							if ( operation.equalsIgnoreCase( "insert" ) )
							{	
								if (entitlement_by_pat_cat_yn.equals("N") )	{%>
								<input type='checkbox'  name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn'  value = 'N'  onClick='checkForMode(this)'>
							<%} else {%>
								<input type='checkbox'  name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' value = 'Y'   checked onClick='checkForMode(this)'>
							<%}
							}else if ( operation.equalsIgnoreCase( "modify" ) ) {
								if (entitlement_by_pat_cat_yn.equals("N") )
								{	
							%>
								<input type='checkbox'  name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' disabled value = 'N'  onClick='checkForMode(this)'>
							<%} else {%>
								<input type='checkbox'  name='entitlement_by_pat_cat_yn' id='entitlement_by_pat_cat_yn' disabled value = 'Y'   checked onClick='checkForMode(this)'>
							<%}
							}
							%>
					</td>
           <td class="label" width='40%'><% if(module_instal_ind.equals("DMS")) { %>
				<fmt:message key="eMP.UM_SuspendingServicetoPatient.label" bundle="${mp_labels}"/><%} else { %>
           <fmt:message key="eMP.SuspendingServicetoPatient.label" bundle="${mp_labels}"/>
				<%}%>
							</td><td class='fields' width='10%'>                
                <%
		
                if ( suspend_service_yn.equals( "Y" ) )
                    out.println( "<input type='checkbox' name='suspend_service_yn' id='suspend_service_yn' value='Y' checked>" );
                else
                    out.println( "<input type='checkbox' name='suspend_service_yn' id='suspend_service_yn' value='Y'>" );
            %>
           </td>
		</tr>	
		<tr>
			<!-- explicitly changed the class as fields -->	
			<td class="label" width='40%'><% if(module_instal_ind.equals("DMS")) { %>
				<fmt:message key="eMP.UM_AcceptApptRefNoReferralIDinRegisterPatient.label" bundle="${mp_labels}"/><%} else { %>
			<fmt:message key="eMP.AcceptApptRefNoReferralIDinRegisterPatient.label" bundle="${mp_labels}"/>
			<%}%>
			<td class="fields" width='10%'>
					<%
                if ( acpt_appt_rfrl_in_reg_pat_yn .equals( "Y" ) )
                    out.println( "<input type='checkbox' name='acpt_appt_rfrl_in_reg_pat_yn' id='acpt_appt_rfrl_in_reg_pat_yn' value='Y' checked onClick='checkForMode(this)' >" ); 

                else
                    out.println( "<input type='checkbox' name='acpt_appt_rfrl_in_reg_pat_yn' id='acpt_appt_rfrl_in_reg_pat_yn' value='N' onClick='checkForMode(this)' >" ) ;
            %> </td>
				<%
                if ( accept_pw_in_chng_pat_dtl_yn.equals( "Y" ) )
                   accept_pw_in_chng_pat_dtl_yn1 = "checked";
                else
					accept_pw_in_chng_pat_dtl_yn1 = "";
					%>
				<td class="label" width='40%'><% if(module_instal_ind.equals("DMS")) { %>
						<fmt:message key="eMP.UM_AcceptPasswordinChangePatientDtls.label" bundle="${mp_labels}"/>
				<%} else { %>
					<fmt:message key="eMP.AcceptPasswordinChangePatientDtls.label" bundle="${mp_labels}"/>
					<%}%> </td>
					<td class="fields" width='10%'>
				<input type='checkbox' name='accept_pw_in_chng_pat_dtl_yn' id='accept_pw_in_chng_pat_dtl_yn' value='Y'  <%=accept_pw_in_chng_pat_dtl_yn1%>>
				</td>
	</tr>


	<tr>

	<td class="label" width='40%'><% if(module_instal_ind.equals("DMS")) { %>
		<fmt:message key="eMP.UM_InvokePatientSearchinRegisterPatient.label" bundle="${mp_labels}"/>
	<%} else { %>
	<fmt:message key="eMP.InvokePatientSearchinRegisterPatient.label" bundle="${mp_labels}"/>
	<%}%> </td>
	<td class="fields" width='10%'>
			
			<%
                
				if ( inv_pat_search_in_reg_pat_yn .equals( "Y" ) )
                    out.println( "<input type='checkbox' name='INV_PAT_SEARCH_IN_REG_PAT_YN' id='INV_PAT_SEARCH_IN_REG_PAT_YN' value='Y'   checked >" );

					else
                    out.println( "<input type='checkbox' name='INV_PAT_SEARCH_IN_REG_PAT_YN' id='INV_PAT_SEARCH_IN_REG_PAT_YN' value='Y' >" ) ;
					%>

	
				</td>

				<td class="label" width='40%'><% if(module_instal_ind.equals("DMS")) { %>
					<fmt:message key="eMP.UM_GenerateSl.No.forUnknownPatients.label" bundle="${mp_labels}"/><%} else { %>
					<fmt:message key="eMP.GenerateSl.No.forUnknownPatients.label" bundle="${mp_labels}"/>
				<%}%>
				</td>
                <td class='fields' width='10%'>
							<% if (gen_slno_unknown_pat_yn.equals("Y")){%>
							<input type='checkbox' name='slno_yn' id='slno_yn' value='Y' checked onclick='Slnochk()' ><%}else{%>
							<input type='checkbox' name='slno_yn' id='slno_yn' value='N' onclick='Slnochk()' ><%}%>
							<input type='hidden' name='gen_slno_unknown_pat_yn' id='gen_slno_unknown_pat_yn' value='<%=gen_slno_unknown_pat_yn%>'>
						</td>					
				</tr>	
				<tr>
					<td class="label" width='40%'><fmt:message key="eMP.RoundoffDOBEstdAge.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
						<%                
						if (round_dob_estd_age.equals( "Y" ))
							out.println( "<input type='checkbox' name='round_dob_estd_age' id='round_dob_estd_age' value='Y' checked onclick='roundOffChk(this)'>" );
						else
							out.println( "<input type='checkbox' name='round_dob_estd_age' id='round_dob_estd_age' onclick='roundOffChk(this)'>" ) ;
						%>									
					</td>	
					<td class="label"><fmt:message key="eMP.AlertForPatientPhotoRenewalAfter.label" bundle="${mp_labels}"/></td>
					<td class="fields" width='10%'><input type='text' name='pat_photo_renewal_alert_days' id='pat_photo_renewal_alert_days' maxLength='3' size='3' onKeyPress='return chkForNumeric(event);' onblur ='checkForZero(this)' value="<%=pat_photo_renewal_alert_days%>" nowrap><fmt:message key="Common.days.label" bundle="${common_labels}"/>
				 </td>					
				</tr>	
<!--Below Fields Modified against GHL-CRF-0312 [IN:039856] By Saanthaakumar -->				
				<tr>
					<td class="label" width='40%'><fmt:message key="eMP.ReqdDuringRegn.label" bundle="${mp_labels}"/></td>
					<td class="label" colspan='3'><fmt:message key="Common.race.label" bundle="${common_labels}"/>
						<%                
						if ( race_required_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='race_required_yn' id='race_required_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='race_required_yn' id='race_required_yn' onclick='chkSetValue(this)'>" ) ;
						%>			
						
						<fmt:message key="Common.country.label" bundle="${common_labels}"/>
						<%                
						if ( country_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='country_reqd_yn' id='country_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='country_reqd_yn' id='country_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%>		
						<fmt:message key="eMP.region.label" bundle="${common_labels}"/>
						<%                
						if ( region_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='region_reqd_yn' id='region_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='region_reqd_yn' id='region_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%>
						<fmt:message key="Common.MobileNo.label" bundle="${common_labels}"/>
						<%                
						if ( mobile_no_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='mobile_no_reqd_yn' id='mobile_no_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='mobile_no_reqd_yn' id='mobile_no_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%><!--Below Field Added against KDAH-CRF-0273 [IN:045012]  By Saanthaakumar -->
						<fmt:message key="Common.email.label" bundle="${common_labels}"/>
						<%                
						if ( email_id_reqd_yn .equals( "Y" ) )
							out.println( "<input type='checkbox' name='email_id_reqd_yn' id='email_id_reqd_yn' value='Y' checked onclick='chkSetValue(this)'>" );
						else
							out.println( "<input type='checkbox' name='email_id_reqd_yn' id='email_id_reqd_yn' onclick='chkSetValue(this)'>" ) ;
						%>	<!-- End here -->
					</td>	
										
				</tr> 
				<tr>
					<td class="label" width='40%'><fmt:message key="eMP.PatSerAccessByUser.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
					<%if(pat_ser_access_by_user_yn.equals("Y")){
						out.println( "<input type='checkbox' name='pat_ser_access_by_user_yn' id='pat_ser_access_by_user_yn' value='Y' checked onclick='chkSetValue(this)'>" );
					}else{
						out.println( "<input type='checkbox' name='pat_ser_access_by_user_yn' id='pat_ser_access_by_user_yn' onclick='chkSetValue(this)'>" ) ;
					}%>
					</td>
					<!--added changes for HSA-CRF-0226 [IN:050599] -->
					<td class=label nowrap><fmt:message key="eMP.SynContactDtlsApt.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
					<%if(upt_contact_dtls_oa_yn.equals("Y")){
						out.println( "<input type='checkbox' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' value='Y' checked onclick='UptContactDtls(this)'>" );
					}else{
						out.println( "<input type='checkbox' name='upt_contact_dtls_oa_yn' id='upt_contact_dtls_oa_yn' onclick='UptContactDtls(this)'>" ) ;
					}%>
					<!--End changes for HSA-CRF-0226 [IN:050599] -->
				</tr>
				<!--Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
				Start-->
				<tr>
					<td class="label" width='40%'><fmt:message key="eMP.UpdatePatientDetailsToReferrals.label" bundle="${mp_labels}"/></td>
					<td class='fields' width='10%'>
					<%if(upd_pat_dtls_referral_yn.equals("Y")){
						out.println( "<input type='checkbox' name='upd_pat_dtls_referral_yn' id='upd_pat_dtls_referral_yn' value='Y' checked onclick='chkSetValue(this)'>" );
					}else{
						out.println( "<input type='checkbox' name='upd_pat_dtls_referral_yn' id='upd_pat_dtls_referral_yn' onclick='chkSetValue(this)'>" ) ;
					}%>
					</td>
					<!--VENKAT-->
					<td class="label" width='40%'><fmt:message key="Common.DisplayCancelledPreviousEncounters.label" bundle="${mp_labels}"/></td>
						<td class='fields' width='10%'>
						<%if(disp_cancelled_previous_enc_yn.equals("Y")){
						out.println( "<input type='checkbox' name='disp_cancelled_previous_enc_yn' id='disp_cancelled_previous_enc_yn' value='Y' checked onclick='chkSetValue(this)'>" );
					}else{
						out.println( "<input type='checkbox' name='disp_cancelled_previous_enc_yn' id='disp_cancelled_previous_enc_yn' onclick='chkSetValue(this)'>" ) ;
					}%>
						<!--<input type='checkbox' name='disp_cancelled_previous_enc_yn' id='disp_cancelled_previous_enc_yn' value="<%=disp_cancelled_previous_enc_yn%>" checked onclick='chkSetValue(this)'></td> -->
					</tr>


				<tr>
					<td colspan='4' class='COLUMNHEADER'><fmt:message key="eMP.AutoCancelFutDtls.label" bundle="${mp_labels}"/></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eMP.NoOfDaysBeforeDeceased.label" bundle="${mp_labels}"/></td>
					<td class="fields" width='10%'><input type='text' name='no_days_before_deceased' id='no_days_before_deceased' maxLength='3' size='3' onblur='makemand(this);' onKeyPress='return chkForNumeric(event);'  value="<%=no_days_before_deceased%>" nowrap><fmt:message key="Common.days.label" bundle="${common_labels}"/>
					</td>
					<%
					//Based on the MO Module installed , MortuaryReleasePatient checkbox will be shown
					int mo_cnt=0;
					if(stmt != null)    stmt.close();
					if(rset != null)    rset.close();  
					try
						{
						stmt = con.createStatement();
						rset=stmt.executeQuery("select count(*) from sm_module where module_id='MO' and install_yn='Y'");
						if(rset.next())
						mo_cnt=rset.getInt(1);
						if(stmt != null)    stmt.close();
						if(rset != null)    rset.close();   
						}
					catch(Exception e)		
						{
						e.printStackTrace();
						}
					if(mo_cnt>0)
							{
							%>
							<td class="label" width='40%' nowrap><fmt:message key="eMP.DeceasedPatsReleasedMO.label" bundle="${mp_labels}"/></td>
							<td class='fields' width='10%'>
								<%                
								
								if ( mortuary_release_yn .equals( "Y" ) )
									out.println( "<input type='checkbox' name='mortuary_release_yn' id='mortuary_release_yn' value='Y' checked onclick='chkSetValue(this)'>" );
								else
									out.println( "<input type='checkbox' name='mortuary_release_yn' id='mortuary_release_yn' onclick='chkSetValue(this)'>" ) ;
								%>			
							</td>	
							<%}%>
					</tr>
					<%
						String disReason="";
						if(cancel_reason_code.equals("")){
							disReason="disabled";
						}
									%>
					<tr>
            <td class='label' ><fmt:message key="Common.ReasonforCancellation.label" bundle="${common_labels}"/></td>
            <td width='30%' class='fields' >
                <select name="cancel_reason_code" id="cancel_reason_code" style='width:150px' <%=disReason%>>
                <option value=''>-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
                <%
                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();

                    stmt = con.createStatement() ;
                    rset = stmt.executeQuery ("Select am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"',1)Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON where CANCEL_APPOINTMENT_YN = 'Y' and CANCEL_BOOKING_YN='Y' and CANCEL_WAIT_LIST_YN='Y' and Eff_Status = 'E' order by 1") ;
                    
                    if(rset != null)
                    {
                        while(rset.next())
                        {
                            chked = "" ;
                            if(cancel_reason_code.equals(rset.getString("Contact_Reason_Code")))
                                chked = "selected" ;
                                out.println( "<option value=\""+rset.getString("Contact_Reason_Code")+"\" "+chked+">"+rset.getString("Contact_Reason")+"</option>" ) ; 
                        }
                    }
                    if(stmt != null)    stmt.close();
                    if(rset != null)    rset.close();                           
                %> </select><img src='../images/mandatory.gif' id='reasonCodeMand' style='visibility:hidden'></img>
                </td>
				<td class="label" width='40%'></td>
				<td class='fields' width='10%'></td>
				</tr>
			
				<!--End-->
				
		</table>

 <table border='0' cellpadding='3' cellspacing='0' width='100%'>

				<tr>
                <td colspan='4' class='COLUMNHEADER'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
				</tr>

				 <tr>
                <td class="label" width='25%' nowrap><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
                <td class="fields" width='25%'>
 				
				<%				if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();

								pstmt = con.prepareStatement("select long_desc from mp_country where eff_status='E' and country_code='"+citizen_nationality_code+"' and ( sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) order by long_desc");
                               
                                rs = pstmt.executeQuery();
								
                                while( rs.next() )
                                {
                                   citizen_nationality_desc=rs.getString("long_desc");
                                }
                                if(pstmt != null)    pstmt.close();
                                if(rs != null)    rs.close();

					if(!citizen_nationality_desc.equals(""))
						{
					%>
				 <input type='text' name='citizen_nationality_desc' id='citizen_nationality_desc' size='20' maxlength='20' value="<%=citizen_nationality_desc%>" onfocus='calllfocusoth()' onblur='if(this.value!=""){searchNationality(citizen_nationality_code,citizen_nationality_desc);}else{document.forms[0].citizen_nationality_code.value="";}' ><input type='button'   name='citizen_nationality_id' id='citizen_nationality_id' value='?' class='button' onclick='searchNationality(this,citizen_nationality_desc)'>
				<input type='hidden' name='citizen_nationality_code' id='citizen_nationality_code' value="<%=citizen_nationality_code%>">
				<% }
				else
				{ %>
				<input type='text' name='citizen_nationality_desc' id='citizen_nationality_desc' size='20' maxlength='20' value="" onblur='if(this.value!="")searchNationality(citizen_nationality_code,citizen_nationality_desc);' ><input type='button'   name='citizen_nationality_id' id='citizen_nationality_id' value='?' class='button' onclick='searchNationality(this,citizen_nationality_desc)'>
				<input type='hidden' name='citizen_nationality_code' id='citizen_nationality_code' value="">
				<% } %>
				</td>




				<td class="label" width='25%'  nowrap><fmt:message key="Common.race.label" bundle="${common_labels}"/></td>
				<td class="fields" width='25%' >
								
					<%			if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
									
								pstmt = con.prepareStatement("select long_desc from mp_race where eff_status='E' and race_code='"+default_race_code+"' and ( sysdate between nvl(eff_date_from,to_date('01/01/1472','dd/mm/rrrr') ) and nvl(eff_date_to,to_date('31/12/5000','dd/mm/rrrr') ) ) order by long_desc");
                               
                                rs = pstmt.executeQuery();
								
                                while( rs.next() )
                                {
                                   race_desc=rs.getString("long_desc");
                                }
                                if(pstmt != null)    pstmt.close();
                                if(rs != null)    rs.close();

					if(!race_desc.equals(""))
						{
					%>
				 <input type='text' name='race_desc' id='race_desc' size='20' maxlength='20' value="<%=race_desc%>" onblur='if(this.value!=""){searchRace(default_race_code,race_desc);}else{document.forms[0].default_race_code.value = "";}' ><input type='button'   name='race_id' id='race_id' value='?' class='button' onclick='searchRace(this,race_desc)'>
				<input type='hidden' name='default_race_code' id='default_race_code' value="<%=default_race_code%>">
				<% }
				else
				{ %>
				<input type='text' name='race_desc' id='race_desc' size='20' maxlength='20' value="" onblur='if(this.value!=""){searchRace(default_race_code,race_desc);}else{document.forms[0].default_race_code.value = "";}' ><input type='button'   name='race_id' id='race_id' value='?' class='button' onclick='searchRace(this,race_desc)'>
				<input type='hidden' name='default_race_code' id='default_race_code' value="">
				<% } %>
				</td>

				</tr>

				<tr>
				<td class='label' colspan='1'>
				<% if(module_instal_ind.equals("DMS")) { %>				
					<fmt:message key="Common.UM_patient.label" bundle="${common_labels}"/>
					&nbsp;<fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
				<% } else { %>
					<fmt:message key="Common.patient.label" bundle="${common_labels}"/>
					&nbsp;<fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
				<% } %>
				<td class='fields' > 

				<%				if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
                                pstmt = con.prepareStatement("Select LONG_NAME  from MP_LANGUAGE where Eff_Status = 'E' and  lang_id='"+dflt_language_id+"' order by 1");
                                
                                rs = pstmt.executeQuery();
								
                                while( rs.next() )
                                {
                                   dflt_language_id_desc=rs.getString("LONG_NAME");
                                }
                                if(pstmt != null)    pstmt.close();
                                if(rs != null)    rs.close();

					if(!dflt_language_id_desc.equals(""))
						{
					%>
				 <input type='text' name='language_desc' id='language_desc' size='20' maxlength='20' value="<%=dflt_language_id_desc%>" onblur='if(this.value!="")searchLanguage(language_code,language_desc);' ><input type='button'   name='language_code_id' id='language_code_id' value='?' class='button' onclick='searchLanguage(this,language_desc)'>
				<input type='hidden' name='language_code' id='language_code' value="<%=dflt_language_id%>">
				<% }
				else
				{ %>
				<input type='text' name='language_desc' id='language_desc' size='20' maxlength='20' value="" onblur='if(this.value!="")searchLanguage(language_code,language_desc);' ><input type='button'   name='language_code_id' id='language_code_id' value='?' class='button' onclick='searchLanguage(this,language_desc)'>
				<input type='hidden' name='language_code' id='language_code' value="">
				<% } %>
				</td>
				

				<td class='label' colspan='1'>

				<% if(module_instal_ind.equals("DMS")) { %>				
					<fmt:message key="Common.UM_patient.label" bundle="${common_labels}"/>
				<% } else { %>
					<fmt:message key="Common.patient.label" bundle="${common_labels}"/>
				<% } %>
					&nbsp;<fmt:message key="Common.religion.label" bundle="${common_labels}"/>
				<td class='fields' > 

				<%				if(pstmt!=null) pstmt.close();
								if(rs!=null) rs.close();
                                pstmt = con.prepareStatement("Select LONG_DESC  from MP_RELIGION where Eff_Status = 'E' and  RELGN_CODE='"+dflt_relgn_code+"' order by 1");
                                
                                rs = pstmt.executeQuery();
								
                                while( rs.next() )
                                {
                                   dflt_relgn_code_desc=rs.getString("LONG_DESC");
                                }
                                if(pstmt != null)    pstmt.close();
                                if(rs != null)    rs.close();

				if(!dflt_relgn_code_desc.equals(""))
						{
					%>
				 <input type='text' name='religion_desc' id='religion_desc' size='20' maxlength='20' value="<%=dflt_relgn_code_desc%>" onblur='if(this.value!="")searchReligion(religion_code,religion_desc);'  ><input type='button'   name='religion_code_id' id='religion_code_id' value='?' class='button' onclick='searchReligion(this,religion_desc)'>
				<input type='hidden' name='religion_code' id='religion_code' value="<%=dflt_relgn_code%>">
				<% }
				else
				{ %>
				<input type='text' name='religion_desc' id='religion_desc' size='20' maxlength='20' value="" onblur='if(this.value!="")searchReligion(religion_code,religion_desc);'  ><input type='button'   name='religion_code_id' id='religion_code_id' value='?' class='button' onclick='searchReligion(this,religion_desc)'>
				<input type='hidden' name='religion_code' id='religion_code' value="">
				<% } %>
				</td></tr>
                <!-- below code was added by Venkatesh.S on 22/jan/2013 against PMG2012-CRF-0025 [IN036502]-->
				<tr><td colspan='1' class='label' ><fmt:message key="eMP.PatientSearchTab.label" bundle="${mp_labels}"/></td><td class='fields'>
				<select name='pat_search_tab' id='pat_search_tab'   onChange='checkadditionalfield(this,0)'>
				
				<option value='B' <%=basic%> ><fmt:message key="Common.basic.label" bundle="${common_labels}"/></option>
			
				<option value='A' <%=advance%> ><fmt:message key="Common.advanced.label" bundle="${common_labels}"/></option>
				
				</select></td></tr>
				
				<!-- PMG2012-CRF-0025 [IN036502] end-->
				</table>
	
		<table  border='0' cellpadding='3' cellspacing='0' width='100%'>
				<tr>
                <td colspan='4' class='COLUMNHEADER'><fmt:message key="eMP.AdditionalFields.label" bundle="${mp_labels}"/></td>
				</tr>
    
   <table border='0' cellpadding='0' cellspacing='0' width='100%'>
    <tr>
    <td class="BORDER">
   
    <table border='0' cellpadding='3' cellspacing='0' width='100%'>
        <tr>    
           
			<td width='25%'>&nbsp;</td>
            <td class='querydata' width='25%'><b><fmt:message key="eMP.Legend.label" bundle="${mp_labels}"/></b></td>
            <td class='labelcenter' width='25%' ><b><fmt:message key="eMP.FieldSize.label" bundle="${mp_labels}"/></b></td>
            <td class='querydata' width='25%' ><b><fmt:message key="Common.Section.label" bundle="${common_labels}"/></b></td>
        </tr>
        <tr>    
            <td class='label' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>1</td>
            <%
                  
		String addl_field_disable = "";
                if ( operation.equalsIgnoreCase( "insert" ) ) {
                     out.println("<td class='fields'><input type='text' name='addl_field1_prompt' id='addl_field1_prompt' maxlength='15' size='18' onBlur='enablefld(1);makeValidString(this);' ></td><td class='labelcenter'><input type='text' name='addl_field1_length' id='addl_field1_length' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);' size='2'  onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' disabled></td><td class='fields'><select name='addl_field1_section' id='addl_field1_section'   onChange='checkadditionalfield(this,0)' disabled> <option value=''>---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"</option><Option value='D' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+" </Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</Option></select></td>");
                }
                else if ( operation.equalsIgnoreCase( "modify" ) ) {
                    if (!addl_field1_prompt.equals("")) addl_field_disable = "disabled";
                    else addl_field_disable ="";
                     out.println("<td class='fields'><input type='text' name='addl_field1_prompt' id='addl_field1_prompt' maxlength='15' size='18' value=\""+addl_field1_prompt+"\" "+addl_field_disable+" onBlur='enablefld(1);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field1_length' id='addl_field1_length' maxlength='2' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' onkeypress='return allowValidNumber(this,event,2, 0);' value='"+addl_field1_length+"' disabled></td><td class='fields'><select name='addl_field1_section' id='addl_field1_section'  disabled onChange='checkadditionalfield(this,0)'> <option value='' "+sec11+">---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' "+sec12+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"<Option value='C' "+sec13+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</option></select></td>");
					 //Added on 3/31/2005
					if(sec12.equalsIgnoreCase("selected")) {%>
						<script>
							section[0] = 'D';
							document.mp_param_form.section0.value = 'D';
							dcount++
						</script>
<%				}
					if(sec13.equalsIgnoreCase("selected")) {%>
						<script>
							section[0] = 'C';
							document.mp_param_form.section0.value = 'C';
							ccount++;
						</script>
<%				}
				}
%>
        </tr> 
        <tr>    
            <td class='label' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>2</td>
            <%
                   
			if ( operation.equalsIgnoreCase( "insert" ) ) {
                     out.println("<td class='fields'><input type='text' name='addl_field2_prompt' id='addl_field2_prompt' maxlength='15' size='18' onBlur='enablefld(2);makeValidString(this)' ></td><td class='labelcenter'><input type='text'  name='addl_field2_length' id='addl_field2_length' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' disabled></td><td class='fields'><select name='addl_field2_section' id='addl_field2_section'   disabled onChange='checkadditionalfield(this,1)'> <option value=''>---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</Option></select></td>");
                }

                else if ( operation.equalsIgnoreCase( "modify" ) ) {
                    if (!addl_field2_prompt.equals("")) addl_field_disable = "disabled";
                    else addl_field_disable ="";
                     out.println("<td class='fields'><input type='text' name='addl_field2_prompt' id='addl_field2_prompt' maxlength='15' size='18' value=\""+addl_field2_prompt+"\" "+addl_field_disable+" onBlur='enablefld(2);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field2_length' id='addl_field2_length' maxlength='2' size='2' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' value='"+addl_field2_length+"' disabled></td><td class='fields'><select name='addl_field2_section' id='addl_field2_section'  disabled onChange='checkadditionalfield(this,1)'><option value='' "+sec21+">---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' "+sec22+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"<Option value='C' "+sec23+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</select></td>");
					 //Added on 3/31/2005
					if(sec22.equalsIgnoreCase("selected")) {%>
						<script>section[1] = 'D';document.mp_param_form.section1.value = 'D';dcount++;</script>
<%				}
					if(sec23.equalsIgnoreCase("selected")) {%>
						<script>section[1] = 'C';document.mp_param_form.section1.value = 'C';ccount++;</script>
<%				}
				}
            %>
        </tr>
        <tr>
            <td class='label' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>3</td>
            <%
                if ( operation.equalsIgnoreCase( "insert" ) ) {
                     out.println("<td class='fields'><input type='text'  name='addl_field3_prompt' id='addl_field3_prompt' maxlength='15' size='18' onBlur='enablefld(3);makeValidString(this)' ></td><td class='labelcenter'><input type='text'  name='addl_field3_length' id='addl_field3_length' maxlength='2' onkeypress='return allowValidNumber(this,event,2, 0);' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' disabled></td><td class='fields'><select name='addl_field3_section' id='addl_field3_section'   disabled onChange='checkadditionalfield(this,2)'> <option value=''>---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</Option></select></td>");
                }
                else if ( operation.equalsIgnoreCase( "modify" ) ) {
                    if (!addl_field3_prompt.equals("")) addl_field_disable = "disabled";
                    else addl_field_disable ="";
                     out.println("<td class='fields'><input type='text'  name='addl_field3_prompt' id='addl_field3_prompt' maxlength='15' size='18' value=\""+addl_field3_prompt+"\" "+addl_field_disable+" onBlur='enablefld(3);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field3_length' id='addl_field3_length' maxlength='2' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' onkeypress='return allowValidNumber(this,event,2, 0);' value='"+addl_field3_length+"' disabled></td><td class='fields'><select name='addl_field3_section' id='addl_field3_section'  disabled onChange='checkadditionalfield(this,2)'><option value='' "+sec31+">---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' "+sec32+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"<Option value='C' "+sec33+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</select></td>");
					 //Added on 3/31/2005
					if(sec32.equalsIgnoreCase("selected")) {%>
						<script>section[2] = 'D';document.mp_param_form.section2.value = 'D';dcount++;</script>
<%				}
					if(sec33.equalsIgnoreCase("selected")) {%>
						<script>section[2] = 'C';document.mp_param_form.section2.value = 'C';ccount++;</script>
<%				}
				 }
            %>
        </tr> 
        <tr>    
            <td class='label' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>4</td>
            <%
                if ( operation.equalsIgnoreCase( "insert" ) ) {
                     out.println("<td class='fields'><input type='text'  name='addl_field4_prompt' id='addl_field4_prompt' maxlength='15' size='18' onBlur='enablefld(4);makeValidString(this)' ></td><td class='labelcenter'><input type='text'  name='addl_field4_length' id='addl_field4_length' maxlength='2' size='2' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' disabled></td><td class='fields'><select name='addl_field4_section' id='addl_field4_section'   disabled onChange='checkadditionalfield(this,3)'> <option value=''>---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</Option></select></td>");
                }
                else if ( operation.equalsIgnoreCase( "modify" ) ) {
                    if (!addl_field4_prompt.equals("")) addl_field_disable = "disabled";
                    else addl_field_disable ="";
                     out.println("<td class='fields'><input type='text'  name='addl_field4_prompt' id='addl_field4_prompt' maxlength='15' size='18' value=\""+addl_field4_prompt+"\" "+addl_field_disable+" onBlur='enablefld(4);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field4_length' id='addl_field4_length' maxlength='2' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' onkeypress='return allowValidNumber(this,event,2, 0);' value='"+addl_field4_length+"' disabled></td><td class='fields'><select name='addl_field4_section' id='addl_field4_section'  disabled onChange='checkadditionalfield(this,3)'><option value='' "+sec41+">---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' "+sec42+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"<Option value='C' "+sec43+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</select></td>");
					 //Added on 3/31/2005
					if(sec42.equalsIgnoreCase("selected")) {%>
						<script>section[3] = 'D';document.mp_param_form.section3.value = 'D';dcount++;</script>
<%				}
					if(sec43.equalsIgnoreCase("selected")) {%>
						<script>section[3] = 'C';document.mp_param_form.section3.value = 'C';ccount++;</script>
<%				}
                }
            %>
        </tr> 
        <tr>    
            <td class='label' ><fmt:message key="Common.Field.label" bundle="${common_labels}"/>5</td>
            <%
                if ( operation.equalsIgnoreCase( "insert" ) ) {
                     out.println("<td class='fields'><input type='text'  name='addl_field5_prompt' id='addl_field5_prompt' maxlength='15' size='18' onBlur='enablefld(5);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field5_length' id='addl_field5_length' maxlength='2' size='2' onkeypress='return allowValidNumber(this,event,2, 0);' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' disabled></td><td class='fields'><select name='addl_field5_section' id='addl_field5_section' onblur='tabs_alignment(2)'   disabled onChange='checkadditionalfield(this,4)'> <option value=''>---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"</Option><Option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</Option></select></td>");
                }
                else if ( operation.equalsIgnoreCase( "modify" ) ) {
                    if (!addl_field5_prompt.equals("")) addl_field_disable = "disabled"; 
                    else addl_field_disable ="";
                     out.println("<td class='fields'><input type='text'  name='addl_field5_prompt' id='addl_field5_prompt' maxlength='15' size='18' value=\""+addl_field5_prompt+"\" "+addl_field_disable+" onBlur='enablefld(5);makeValidString(this)'></td><td class='labelcenter'><input type='text'  name='addl_field5_length' id='addl_field5_length' maxlength='2' size='2' onBlur='CheckNum(this);checkDecimal(this);checkzero(this);' onkeypress='return allowValidNumber(this,event,2, 0);' value='"+addl_field5_length+"' disabled></td><td class='fields'><select name='addl_field5_section' id='addl_field5_section'  onblur='tabs_alignment(2)' disabled onChange='checkadditionalfield(this,4)'><option value='' "+sec51+">---------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---------</option><Option value='D' "+sec52+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")+"<Option value='C' "+sec53+">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ContactAddresses.label","mp_labels")+"</select></td>");
					 //Added on 3/31/2005<fmt:message key="eMP.ContactAddresses.label" bundle="${mp_labels}"/>
					if(sec52.equalsIgnoreCase("selected")) {%>
						<script>section[4] = 'D';document.mp_param_form.section4.value = 'D';dcount++;</script>
<%				}
					if(sec53.equalsIgnoreCase("selected")) {%>
						<script>section[4] = 'C';document.mp_param_form.section4.value = 'C';ccount++;</script>
<%				}
                }
            %>
        </tr> 
    <tr>
    <td colspan=4>&nbsp;</td>
    </tr>
    </table>
	 </td>
    </tr>
    </table>
		</table>

	</div>

    <!--added by prithivi on 26/02/2017 for kdah-crf-0362-->
	<% 	
	 if("Y".equalsIgnoreCase(aadharProfileYN))
	  { 
         //String aadhar_config_enabled_yn	= checkForNull( request.getParameter( "aadhar_config_enabled_yn"),"N" );
	     //String aadhar_option_value	= checkForNull( request.getParameter( "aadhar_option_value"),"" );

		 String aadhar_config_enabled_checked = "";
		 String aadhar_option_disabled = "disabled";
		 String aadhar_option1_checked = "";
		 String aadhar_option2_checked = "";
		 String aadhar_option3_checked = "";

		 if("Y".equalsIgnoreCase(aadhar_config_enabled_yn))
		  {
			 aadhar_config_enabled_checked = "checked";
			 aadhar_option_disabled = "";
		  }
		 else
		  {
			 aadhar_config_enabled_checked = "";
			 aadhar_option_disabled = "disabled";
		  }

          if("0".equalsIgnoreCase(aadhar_option_value))
		  {
			 aadhar_option1_checked = "checked";
			 aadhar_option2_checked = "";
			 aadhar_option3_checked = "";
		  }
		 else if("1".equalsIgnoreCase(aadhar_option_value))
		  {
			 aadhar_option2_checked = "checked";
			 aadhar_option1_checked = "";
			 aadhar_option3_checked = "";
		  }
		  else if("2".equalsIgnoreCase(aadhar_option_value))
		  {
			 aadhar_option3_checked = "checked";
			 aadhar_option2_checked = "";
			 aadhar_option1_checked = "";
		  }
		 
		%>
	<div id="AADHAAR" style = 'display:none'>
		<table cellspacing='0' cellpadding='0' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" >
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
			
	        <li class="tablistitem" title='AADHAR444'>
				<a class="tabA" id="aadhar_tab" >
					<span class="tabAspan" id="aadhar_tabspan" onClick='javascript:expandCollapse("aadhar_tab")'><fmt:message key="eMP.AADHAR.label" bundle="${mp_labels}"/> </span>
			</a>
			</li>
			
			</ul>
 </td></tr>
</table>
       <table width="100%" cellPadding="1" noWrap="nowrap" bgcolor="#000000">
		<tr>
		<td class="COLUMNHEADER" rowSpan="1" colSpan="2"> <fmt:message key="eMP.AADHARconfiguration.label" bundle="${mp_labels}"/> </td>
		</tr>
		 <tr>
		   <td class="label" align="right" width="20%">
		     <fmt:message key="eMP.EnableAadharConfig.label" bundle="${mp_labels}"/>
		   </td>

		   <td class="fields"  align="left" width="80%">
		      <input type='checkbox' name='aadhar_config_enabled_yn' id='aadhar_config_enabled_yn' value='Y' <%=aadhar_config_enabled_checked %>  onClick="aadharConfig(this)">
		   </td>
		 </tr>
		<tr>
		   <td class="label" align="right" width="20%">
		   </td>
		   <td class="fields"  align="left" width="80%">
		      <input type="radio" name="aadhar_option_value" id="aadhar_option_value" id="aadhar_option_value" value="0" <%=aadhar_option1_checked %> <%=aadhar_option_disabled %>> <fmt:message key="eMP.LaunchAadharConfig.label" bundle="${mp_labels}"/> <br>
		   </td>
		 </tr>
		<tr>
		   <td class="label" align="right" width="20%">
		   </td>
		   <td class="fields"  align="left" width="80%">
		      <input type="radio" name="aadhar_option_value" id="aadhar_option_value" id="aadhar_option_value" value="1" <%=aadhar_option2_checked %> <%=aadhar_option_disabled %> > <fmt:message key="eMP.ReplaceWithAadharDetails.label" bundle="${mp_labels}"/> <br>
		   </td>
		 </tr>
		<tr>
		   <td class="label" align="right" width="20%">
		   </td>
		   <td class="fields"  align="left" width="80%">
		      <input type="radio" name="aadhar_option_value" id="aadhar_option_value" id="aadhar_option_value" value="2" <%=aadhar_option3_checked %> <%=aadhar_option_disabled %> > <fmt:message key="eMP.ValidateAadharDetails.label" bundle="${mp_labels}"/> <br>
		   </td>
		 </tr>
	  </table>
	</div>

	<% } %>

	<!--Maheshwaran K added for the Bru-HIMS-CRF-171 as on 03/12/2012
				Start-->
		<script>	if('<%=no_days_before_deceased%>' != "") {document.getElementById('reasonCodeMand').style.visibility="visible"; }else{document.getElementById('reasonCodeMand').style.visibility="hidden"}</script>
		<!--End-->
<%
	// Onload event function for Accept Patient name as multiParts
	if (operation.equals("insert"))
		out.println("<script>enableName();</script>");
    if(pstmt != null ) pstmt.close() ;
	if(stmt11 != null)    stmt11.close();
	if(stmt != null)    stmt.close();
    if(rset != null)    rset.close();
    if(rset11 != null)    rset11.close();
	if(rs!= null ) rs.close() ;
	}
	catch( Exception ce ) {ce.printStackTrace();}
    finally
    {
        
        if(con != null) ConnectionManager.returnConnection(con,request);
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

