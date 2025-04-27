<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,eCommon.Common.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	 
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
		<script src='../../eIP/js/IPParam.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function setVal(obj)
		{
			if(obj.checked == true)
				obj.value = "Y";
			else
				obj.value = "N";
		}

		/* New function added for CRF "MZ-CRF-0017-IP"  by sathish on Wednesday, March 03, 2010*/
		function expandCollapse(calledFrom) {		

			if(calledFrom == 'adt'){
						document.getElementById("ADT").style.display = 'inline';
						document.getElementById("ADDITIONAL").style.display = 'none';						
			}else if(calledFrom == 'additional') {
						document.getElementById("ADT").style.display = 'none';
						document.getElementById("ADDITIONAL").style.display = 'inline';
			}
		}

async function ConsentText(){
	var obj = new Object(); 
	obj.data = document.getElementById("consent_text_details").value;
	var arg="dialogHeight:30;edge:sunken;resizable:no;status:no;scroll:no";	
	var url="../../eIP/jsp/IPConsentFormatText.jsp";
	await window.showModalDialog(url,obj,arg); 
	document.getElementById("consent_text_details").value=obj.returnvalue;
}


		</script>
	</head>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con						= null;
	Statement stmt						= null;
	ResultSet rset						= null;
    Statement stmt_pt_leave				= null;
    ResultSet rset_pt_leave				= null; 
	String facility_id					= "QF";//(String)session.getAttribute("facility_id");
	String locale						= (String)session.getAttribute("LOCALE");

	try
	{
		con								= ConnectionManager.getConnection(request);
		stmt							= con.createStatement();
		String allowed_booking_type		= "D";
		String adm_date_chk_days		= "";
		String MAX_ALLOWED_ACCOM_PERS	= "";
		String CHK_IN_LODGER_MAX_PERIOD	= "";
		String NO_SHOW_GRACE_PERIOD		= "";
		String ABSCOND_GRACE_PERIOD 	= "";
		String dis_date_chk_days		= "";
		String start_admit_screen		= "";
		String bed_block_period_normal	= "";
		String bed_block_period_dis		= "";
		String bed_block_period_max		= "";
		String adv_bed_book_period_bkg	= "";
		String MAX_DISCH_PERIOD_FOR_DC	= "";
		String chk_booking_limit_by		= "";
		String lodger_max_srl_no		= "";
		String lodger_next_srl_no		= "";
		String allow_release_bed_on_lv	= "";
		String max_allowed_lv_period	= "";
		String vital_signs_battery_id	= "";
		String bl_interfaced_yn			= "";
		String bl_fields				= "";
		String bkg_grace_period			= "";
		String warn_or_error_max_leave	= "";
		String action_warning_yn		= "";
		String action_error_yn			= "";
		String adm_date_chk_days_type	= "";
		String allowed_admission_type	= "";
		String mode						= "insert";
		String strTransfer_Out			= "";
		String noshow_bkng_period        ="";  //Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
		String dflt_priority_for_bed_booking ="";
		String dflt_bed_blocking_period	="";
		
		String reserve_bed_on_tfr_yn	="";
		
		/*Added by Thamizh selvi on 4th Nov 2016 against GHL-CRF-0412.2 Start*/
		String chk_pen_ward_rtn_bfr_dis_adv =""; 
		String check_chk_pen_ward_rtn ="";
		/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start*/
		String chk_pen_sale_rtn_bfr_dis_adv =""; 
		String dis_chk_pen_sale_rtn_bfr_dis_adv ="";
		/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End*/
		Boolean isRestrictDischargeAdvice = CommonBean.isSiteSpecific(con,"IP","RESTRICT_DISCHARGE_ADVICE");
		Boolean isModifyDiscTypeStatusAppl = CommonBean.isSiteSpecific(con,"IP","MODIFY_DISC_TYPE_STATUS_YN"); // added by mujafar for ML-MMOH-CRF-0659
		/*End*/

		Boolean isRestrictDisAdvSaleRetPend = CommonBean.isSiteSpecific(con,"IP","RESTRICT_DIS_ADV_SALE_RET_PEND"); //Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892]
		/*Added by Thamizh selvi on 8th May 2017 against ML-MMOH-CRF-0617 Start*/
		String autoCnrmTfrReq =""; 
		String chkAutoCnrmTfrReq ="";
		Boolean isCnrmReqPatOutChngAppl = CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");
		/*End*/
		
		Boolean isPatientEncRevokeDeathAppl=	CommonBean.isSiteSpecific(con, "MP", "PATIENT_ENC_REVOKE_DEATH"); // added by mujafar for JULY-2019 for ML-MMOH-CRF-1427
	String dispTypeForRevokeDeath=""; // added by mujafar  for ML-MMOH-CRF-1427
	

		/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
		 String validate_natid_IP_admsn	= "";
		 String validate_natid_chk		= "";
		 Boolean isNationalIdValidationAppl	= CommonBean.isSiteSpecific(con, "MP", "NATIONAL_ID_VALIDATION");
		 /*End MO-CRF-20148*/
		 
		 /*ADDED BY SUJI KEERTHI ON 24-MAR-2020 FOR MOHE-CRF-0014*/
		 String enable_disch_diagnosis_yn = "";
		 String enable_disch_chk ="";
		 /*END MOHE-CRF-0014*/
		
		/*Added by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866 Start*/
		String dispBedClsChange		= ""; 
		String chkDispBedClsChange	= "";
		/*End*/
//		String CANCEL_DISCHARGE_APPL_YN      ="";
		String max_stay_of_lodger_after_disc ="";
		String pat_type_override_leave_period="";
		String unregistered_patients_bkg_yn = "";
		 //Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
		String chk_for_pen_orders_bfr_dis_adv ="";
		String radio_flag_1                   ="";
		String radio_flag_2                   ="";
		String radio_check_yn_1                ="";
		String radio_check_yn_2                ="";
		String dis_adv_allow_yn                ="";
				//  venkatesh KDAH-CRF-0041 END
		
        /*Below Line Added for this CRF [JD-CRF-0006] by Senthil*/ 
        String chk_for_pen_orders_bfr_dis="";
		String dis_notallow_yn                   ="";
		String dis_notallow_chk               ="";
		String dis_allow_yn                      ="";
		String dis_allow_chk                  ="";		
		String dis_allow_rd                  ="";

       /*End [JD-CRF-0006]*/		
    		
		String max_allowed_lv_cancel_period = "";
		String bed_block_period_max_type	= "";
		String bed_block_period_max_type1	= "";
		String PAT_CHECK_IN_ALLOWED_YN		= "";
		String DEACTIVATE_PSEUDO_BED_YN		= ""; 
		String ALLOW_GATE_PASS_PRE_DIS_ADV_YN = ""; // added by mujafar for MO-CRF-20157
		String Disable_flg					= "";
		String Disable_Enable_flg			= "";
		String Readonly_flg					= "";
		String default_priority				= "";
		String dis_date_chk_days_unit		= "";
		String diag_update_period_max_unit	= "";
		//String bl_operational				=	(String)session.getAttribute("bl_operational");
		String bl_operational				=	"";
		String PRIORITY_APPLICABLE			= "";
		String change_bed_class_yn			= "";
		String discharge_checklist_app_yn	= "";
		String prioryn						= "";
		String DFLT_GATE					= "";
		String DISC_CHKLST_EXP_PERIOD		= "";
		/*Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] */
		String chk_for_readmission          ="";
	    /* end Bru-HIMS-CRF-155 [IN030274]  */
		String DISC_CHKLST_EXP_PER_UNIT		= "";
		//String external_interface_for_priviledge_yn="";
		String multi_bkg_patient_yn			= "";
		String block_bed_based_on			= "";
		String capture_fin_dtls_yn			= "";
		StringBuffer sql					= new StringBuffer();
		String disable_enable_cap_fin_dtl	= "enabled";
		String allow_multiple_bed_for_resv_yn= "";
		String allow_multiple_bed_disabled  = "";
		String allow_multiple_bed_unchecked = "";
                String res_reserve_bed_intraward_yn ="";         //added for CRF GHL-CRF-0340 by Darshini
                String res_reserve_bed_intraward_disabled = "";  //added for CRF GHL-CRF-0340 by Darshini
		String allow_user_modify_disc_type_status_yn=""; // added by mujafar for ML-MMOH-CRF-0659
          String consenttxtdtls="";
		/*18/11/2008 SCR 4020 FDPMG20089CRF0119IP */

		String	allow_booking_without_edd_yn= "";
		String	allow_booking_with_edd_yn	= "";

		String future_booking_for_boc_yn	= "";
		String no_of_days_before_for_boc	= "";
		String consider_edd_stop_for_boc_yn	= "";
		String action_for_boc				= "";
		String action_for_boc_w				= "";
		String action_for_boc_s				= "";

		String future_booking_for_bou_yn	= "";
		String no_of_days_before_for_bou	= "";
		String consider_edd_stop_for_bou_yn	= "";
		String action_for_bou				= "";
		String action_for_bou_w				= "";
		String action_for_bou_s				= "";

		String future_booking_for_bnc_yn	= "";
		String no_of_days_before_for_bnc	= "";
		String consider_edd_stop_for_bnc_yn	= "";
		String action_for_bnc				= "";
		String action_for_bnc_w				= "";
		String action_for_bnc_s				= "";

		String future_booking_for_bnu_yn	= "";
		String no_of_days_before_for_bnu	= "";
		String consider_edd_stop_for_bnu_yn	= "";
		String action_for_bnu				= "";
		String action_for_bnu_w				= "";
		String action_for_bnu_s				= "";
		
		String grc_prd_for_asgn_bed_mark_arvl	= "";
		String   change_admission_dtls		= "";
		String display_discharge_pat_list	= "A";
		
		/*Below line Added for this CRF Bru-HIMS-CRF-354*/
		String deft_pract_bedside_referral="";
		String deft_pract_bedside_referral_chk_a="";
		String deft_pract_bedside_referral_chk_l="";
		
		//End Bru-HIMS-CRF-354

		
		String invoke_adm_from_newborn_yn	= "";//For Invoke Admission Check Box
		String invoke_adm_chkd				= "";//For Invoke Admission Check Box
//		String disable_enable_cap_fin_dtl	= "enabled";//For Invoke Admission Check Box
		String Allow_Invoke_Maintn_Dth_Reg_YN	= "";
		String BED_MANDATORY_FOR_ADMN_YN	= "N";//new variable created for CRF "MZ-CRF-0017-IP"  by sathish on Wednesday,March03,10 
		
		//Added for the CRF - Bru-HIMS-CRF-157 on 4-5-2012
		String reason_for_late_discharge="";
		String mandatory_flag="";
		String non_mandatory_flag="";
		String radio_check_mandatory_yn_1="";
		String radio_check_mandatory_yn_2="";
		String discharge_reason_mandatory_yn=""; 
		
		//Added for the CRF - HSA-CRF-0035 
		String transfer_wo_delink_yn=""; 
		String transfer_wo_delink_checked=""; 
				
		//Added for the CRF -KDAH-CRF-0104 by Dharma start
		String pre_disch_appl_yn=""; 
		String pre_disch_appl_checked=""; 
		Boolean SiteSpecific_pre_disch_appl = CommonBean.isSiteSpecific(con, "IP","PRE_DISCHARGE");	
		//Added for the CRF -KDAH-CRF-0104  by Dharma end
		
		
		String weight_on_admn_mandatory = ""; /*Added by Dharma on Oct 17th against HSA-CRF-0181 [IN:049541]*/
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 */		
		String height_on_admn_mandatory = "";
		String enable_height_bmi_pat_cls = "";
		Boolean isHeightAndBmiEnable	= CommonBean.isSiteSpecific(con, "MP", "BMI_REG_PAT_CHNGES_RH101");
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/
		//Added for MMS-QH-CRF-0144
		String reason_for_adm_reqd_yn=""; 
		String reason_for_adm_reqd_checked=""; 
		
		//Below line added for this CRF ML-MMOH-CRF-0688
		 String death_register_mandatory_yn="N";
         String invoke_maintn_dth_reg="";
         String death_reg_mandatory_yn_1="";
         String death_reg_mandatory_yn_2="";
		 String death_reg_mandatory_flag=""; 
		 String death_reg_non_mandatory_flag="";
		//End this CRF ML-MMOH-CRF-0688
		
		String chk_dis_pat_BT_order_pend=""; //Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
		String admission_type="";//Added by Shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618
		Boolean isDisPatBTorderPendAppl = CommonBean.isSiteSpecific(con,"IP","CHK_DIS_PAT_BT_ORDER_PEND");//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
		Boolean isAdmissionTypeAppl = CommonBean.isSiteSpecific(con,"IP","ADMISSION_TYPE_APPL");//Added by Shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618
		/*Added by Dharma on 23rd May 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
		Boolean isNewBornChngsAppl		 = CommonBean.isSiteSpecific(con,"IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");
		String trans_yn_unfnzed_newborn	= "N";
		/*Added by Dharma on 23rd May 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/

		String dis_ot_pend_ord_yn = "N";
		String dis_adv_ot_pend_ord_yn = "N";                 
		
		 //Added for  HSA-CRF-146.1
String allow_muti_bedside_review_yn="";
String allow_muti_bedside_review_checked="";
//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362
String ca_record_referral_note_yn = "";
String ca_record_referral_note_yn_checked="";
//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362	
//Added by Kamatchi S for MOHE-CRF-0154
String allow_reg_referral_yn = "";
String allow_reg_referral_yn_checked="";
String rel_booked_bed_yn			= "";	//Added  for PMG2016-CRF-0002 IN061508 on 23rd Aug 16
		//MODIFIED ON 17-09-2008 FOR billing parameter yn 
		String sql_bl="select operational_yn from sm_modules_facility where facility_id = '"+facility_id+"' and module_id = 'BL' ";
		rset = stmt.executeQuery(sql_bl);
		if(rset != null && rset.next() )
		{
			bl_operational					= rset.getString("operational_yn");
		}
		if(rset!=null) rset.close();
		//
		sql.append("select * from ip_param where facility_id='"+facility_id+"' ");
		
		rset								= stmt.executeQuery(sql.toString());
		if(rset!=null )
		{
			if(rset.next())
			{		


			Disable_flg						= "Disabled";

			DFLT_GATE						= rset.getString("DFLT_GATE_PASS_PERIOD");
			if(DFLT_GATE == null) DFLT_GATE = "";

			allowed_booking_type			= rset.getString("allowed_booking_type");
			

			DISC_CHKLST_EXP_PERIOD			= rset.getString("DISC_CHKLST_EXP_PERIOD");
			if(DISC_CHKLST_EXP_PERIOD == null) 
				DISC_CHKLST_EXP_PERIOD		= "";

			DISC_CHKLST_EXP_PER_UNIT		= checkForNull(rset.getString("DISC_CHKLST_EXP_PER_UNIT"));

			/*Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] */
			 chk_for_readmission            = rset.getString("MAX_HRS_FOR_RE_ADMN"); 
			 if(chk_for_readmission == null) 
			  chk_for_readmission            ="";
			   /* end Bru-HIMS-CRF-155 [IN030274]  */
			PRIORITY_APPLICABLE				= rset.getString("PRIORITY_APPLICABLE_YN");
			if(PRIORITY_APPLICABLE == null) PRIORITY_APPLICABLE = "";

			if(PRIORITY_APPLICABLE.equals("Y"))
			{
			  prioryn = "checked";
			}
			else
			{
				prioryn = "";
			}
			
			dispTypeForRevokeDeath =rset.getString("REVOKE_DEATH_DISP_TYPE")==null?"":rset.getString("REVOKE_DEATH_DISP_TYPE"); 	// added by mujafar  for ML-MMOH-CRF-1427
		
			MAX_ALLOWED_ACCOM_PERS			= rset.getString("MAX_ALLOWED_ACCOM_PERS");
			if(MAX_ALLOWED_ACCOM_PERS == null) 
				MAX_ALLOWED_ACCOM_PERS		= "0";

			CHK_IN_LODGER_MAX_PERIOD		= rset.getString("CHK_IN_LODGER_MAX_PERIOD");
			if(CHK_IN_LODGER_MAX_PERIOD == null) 
				CHK_IN_LODGER_MAX_PERIOD	= "0";

			ABSCOND_GRACE_PERIOD			= rset.getString("ABSCOND_GRACE_PERIOD");
			if(ABSCOND_GRACE_PERIOD == null) 
				ABSCOND_GRACE_PERIOD		= "0";

			NO_SHOW_GRACE_PERIOD			= rset.getString("NO_SHOW_GRACE_PERIOD");
			if(NO_SHOW_GRACE_PERIOD == null) 
				NO_SHOW_GRACE_PERIOD		= "0";

			DEACTIVATE_PSEUDO_BED_YN		= rset.getString("DEACTIVATE_PSEUDO_BED_YN");
			if(DEACTIVATE_PSEUDO_BED_YN == null) 
				DEACTIVATE_PSEUDO_BED_YN	= "N";
			DEACTIVATE_PSEUDO_BED_YN		= DEACTIVATE_PSEUDO_BED_YN.equals("Y") ?"checked" :"" ;
			
			
			
			 
			ALLOW_GATE_PASS_PRE_DIS_ADV_YN		= rset.getString("ALLOW_GATE_PASS_PRE_DIS_ADV_YN"); // added by mujafar for MO-CRF-20157
			if(ALLOW_GATE_PASS_PRE_DIS_ADV_YN == null) 
				ALLOW_GATE_PASS_PRE_DIS_ADV_YN	= "N";
			ALLOW_GATE_PASS_PRE_DIS_ADV_YN		= ALLOW_GATE_PASS_PRE_DIS_ADV_YN.equals("Y") ?"checked" :"" ;
			
			
			
			
			
			
			
			
			
			
			

			PAT_CHECK_IN_ALLOWED_YN			= rset.getString("PAT_CHECK_IN_ALLOWED_YN");
			if(PAT_CHECK_IN_ALLOWED_YN == null) 
				PAT_CHECK_IN_ALLOWED_YN		= "N";
			PAT_CHECK_IN_ALLOWED_YN			= PAT_CHECK_IN_ALLOWED_YN.equals("Y") ?"checked" :"" ;

			change_bed_class_yn				= rset.getString("change_bed_class_yn");
			if(change_bed_class_yn == null) 
				change_bed_class_yn			= "N";
			change_bed_class_yn				= change_bed_class_yn.equals("Y") ?"checked" :"" ;

			discharge_checklist_app_yn		= rset.getString("discharge_checklist_app_yn");
			if(discharge_checklist_app_yn == null) 
				discharge_checklist_app_yn	= "N";
			discharge_checklist_app_yn		= discharge_checklist_app_yn.equals("Y") ?"checked" :"";
			adm_date_chk_days				= rset.getString("adm_date_chk_days");
			if(adm_date_chk_days == null) 
				adm_date_chk_days			= "0";

			dis_ot_pend_ord_yn = checkForNull(rset.getString("dis_ot_pend_ord_yn"),"N");
			dis_adv_ot_pend_ord_yn = checkForNull(rset.getString("dis_adv_ot_pend_ord_yn"),"N");

			adm_date_chk_days_type			= checkForNull(rset.getString("adm_date_chk_days_type"));
			allowed_admission_type			= checkForNull(rset.getString("allowed_admission_type"));
			dis_date_chk_days_unit			= checkForNull(rset.getString("DIS_DATE_CHK_DAYS_UNIT"));
			bed_block_period_max_type		= checkForNull(rset.getString("bed_block_period_max_type"));                        
			bed_block_period_max_type1		= checkForNull(rset.getString("DFLT_GATE_PASS_UNIT")); 
			diag_update_period_max_unit		= rset .getString("DIAG_UPDATE_PERIOD_MAX_UNIT");
			if(diag_update_period_max_unit == null) 
				diag_update_period_max_unit	= "";
			dis_date_chk_days				= rset.getString("dis_date_chk_days");
			if(dis_date_chk_days == null) 
				dis_date_chk_days			= "0";

			start_admit_screen				= rset.getString("start_admit_screen");
			if(start_admit_screen == null) 
				start_admit_screen			= "";

			bed_block_period_normal			= rset.getString("bed_block_period_normal");
			if(bed_block_period_normal == null) 
				bed_block_period_normal		= "";

			bed_block_period_dis			= rset.getString("bed_block_period_dis");
			if(bed_block_period_dis == null) 
				bed_block_period_dis		= "";

			bed_block_period_max			= rset.getString("bed_block_period_max");
			if(bed_block_period_max == null) 
				bed_block_period_max		= "";

			strTransfer_Out					= rset.getString("DFLT_BLK_PRD_FOR_TFR_OUT");
			if(strTransfer_Out == null) 
				strTransfer_Out				= "";

			dflt_priority_for_bed_booking	= rset.getString("dflt_priority_for_bed_booking");
			if(dflt_priority_for_bed_booking == null) 
				dflt_priority_for_bed_booking= "";

			dflt_bed_blocking_period		= rset.getString("dflt_bed_blocking_period");
			if(dflt_bed_blocking_period == null )
				dflt_bed_blocking_period	= "";
	  

			adv_bed_book_period_bkg			= rset.getString("adv_bed_book_period_bkg");
			if(adv_bed_book_period_bkg == null) 
				adv_bed_book_period_bkg		= "0";
			
            //Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			noshow_bkng_period			= rset.getString("NOSHOW_BKNG_PERIOD");
			if(noshow_bkng_period == null) 
				noshow_bkng_period		= "";
			 //end  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			MAX_DISCH_PERIOD_FOR_DC			= rset.getString("MAX_DISCH_PERIOD_FOR_DC");
			if(MAX_DISCH_PERIOD_FOR_DC == null) 
				MAX_DISCH_PERIOD_FOR_DC		= "0";

			pat_type_override_leave_period	= rset.getString("ALLOW_PAT_TYPE_FOR_LEAVE");
			if(pat_type_override_leave_period == null) 
				pat_type_override_leave_period	= "";

			max_stay_of_lodger_after_disc	= rset.getString("max_stay_of_lodger_after_disc");
			if(max_stay_of_lodger_after_disc == null)  
				max_stay_of_lodger_after_disc	= "";

			chk_booking_limit_by			= rset.getString("chk_booking_limit_by");
			
			if(chk_booking_limit_by == null) 
				chk_booking_limit_by		= "";
			mode="modify";

			lodger_next_srl_no				= rset.getString("lodger_next_srl_no");
			if(lodger_next_srl_no == null) 
				lodger_next_srl_no			= "";

			lodger_max_srl_no				= rset.getString("lodger_max_srl_no");
			if(lodger_max_srl_no == null) 
				lodger_max_srl_no			= "";

			allow_release_bed_on_lv			= rset.getString("allow_release_bed_on_lv");

			max_allowed_lv_period			= rset.getString("max_allowed_lv_period");
			if(max_allowed_lv_period == null) 
				max_allowed_lv_period		= "";

			max_allowed_lv_cancel_period	= rset.getString("max_allowed_lv_cancel_period");
			if(max_allowed_lv_cancel_period == null) 
				max_allowed_lv_cancel_period = "";

			vital_signs_battery_id			= rset.getString("vital_signs_battery_id");
			if(vital_signs_battery_id == null) 
				vital_signs_battery_id		= "" ;

			bl_interfaced_yn				= rset.getString("bl_interfaced_yn");
			if(bl_interfaced_yn == null)
				bl_interfaced_yn			= "N";

			bl_interfaced_yn				= bl_interfaced_yn.equals("Y") ?"checked" :"" ;

			//<!--2/3/2009 dropped  ext_interface_for_priviledge_yn from IP_PARAM -->
			
			/*
			external_interface_for_priviledge_yn = rset.getString("EXT_INTERFACE_FOR_PRIVILEGE_YN");
			if(external_interface_for_priviledge_yn == null)
			external_interface_for_priviledge_yn = "N";*/

			//external_interface_for_priviledge_yn = external_interface_for_priviledge_yn.equals("Y") ?"checked" :"" ;


			bkg_grace_period				= rset.getString("bkg_grace_period");
			if(bkg_grace_period == null ) 
				bkg_grace_period			= "";

			unregistered_patients_bkg_yn	= rset.getString("UNREGISTERED_PATIENTS_BKG_YN");
			if(unregistered_patients_bkg_yn == null) 
				unregistered_patients_bkg_yn= "N";
			unregistered_patients_bkg_yn	= unregistered_patients_bkg_yn.equals("Y") ?"checked" :"" ;
            
			//Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
			chk_for_pen_orders_bfr_dis_adv =rset.getString("chk_for_pen_orders_bfr_dis_adv");
			dis_adv_allow_yn=rset.getString("dis_adv_allow_yn");
		 
	        
			if(chk_for_pen_orders_bfr_dis_adv.equals("Y")){
			  chk_for_pen_orders_bfr_dis_adv ="checked";
			  if(dis_adv_allow_yn.equals("N"))
			  {
			  radio_check_yn_1 ="checked";
			  }
			  else
			  {
			  radio_check_yn_2="checked";
			  }
			  }
           else{		
	         chk_for_pen_orders_bfr_dis_adv="";
			 radio_flag_1="disabled";
             radio_flag_2="disabled";			 
			}
			
		// venkatesh KDAH-CRF-0041 END	
		
		
		
			/*Below Code Added for this CRF [JD-CRF-0006] by Senthil */
			chk_for_pen_orders_bfr_dis =rset.getString("chk_for_pen_orders_bfr_dis");
			dis_allow_rd=rset.getString("dis_allow_yn");			
	        
			if(chk_for_pen_orders_bfr_dis.equals("Y")){
			  chk_for_pen_orders_bfr_dis ="checked";
			  if(dis_allow_rd.equals("N"))
			  {
			  dis_notallow_yn ="checked";
			  }
			  else
			  {
			  dis_allow_yn="checked";
			  }
			  }
           else{		
	         chk_for_pen_orders_bfr_dis="";
			 dis_notallow_chk="disabled";
             dis_allow_chk="disabled";	
			 }
		
		
			
			
			
			
		/*Above line added for this CRF [JD-CRF-0006] by Senthil*/		
		
		
			
			multi_bkg_patient_yn			= rset.getString("MULTI_BOOK_PAT_YN");
			if(multi_bkg_patient_yn == null) 
				multi_bkg_patient_yn		= "N";
			multi_bkg_patient_yn			= multi_bkg_patient_yn.equals("Y") ?"checked" :"" ;
			//Added  for PMG2016-CRF-0002 IN061508 on 23rd Aug 16
			rel_booked_bed_yn			= rset.getString("REL_BOOKED_BED_YN");
			if(rel_booked_bed_yn == null) 
				rel_booked_bed_yn		= "N";
			rel_booked_bed_yn			= rel_booked_bed_yn.equals("Y") ?"checked" :"" ;

			block_bed_based_on				= rset.getString("block_bed_based_on");
			if(block_bed_based_on == null ) 
				block_bed_based_on			= "";

			capture_fin_dtls_yn				= rset.getString("capture_fin_dtls_yn");
			if(capture_fin_dtls_yn == null) 
				capture_fin_dtls_yn			= "N";
			if(capture_fin_dtls_yn.equals("Y"))
				disable_enable_cap_fin_dtl	= "disabled";
			capture_fin_dtls_yn				= capture_fin_dtls_yn.equals("Y") ?"checked" :"" ;
			

			reserve_bed_on_tfr_yn			= rset.getString("reserve_bed_on_tfr_yn");
			if(reserve_bed_on_tfr_yn == null )
				reserve_bed_on_tfr_yn		= "N";
			reserve_bed_on_tfr_yn			= reserve_bed_on_tfr_yn.equals("Y") ?"checked" :"" ;
			
			/*Added by Thamizh selvi on 4th Nov 2016 against GHL-CRF-0412.2 Start*/
			chk_pen_ward_rtn_bfr_dis_adv = rset.getString("CHK_PEN_WARD_RTN_BFR_DIS_ADV");
			if(chk_pen_ward_rtn_bfr_dis_adv == null )
				chk_pen_ward_rtn_bfr_dis_adv		= "N";
			if(chk_pen_ward_rtn_bfr_dis_adv.equals("Y"))
				check_chk_pen_ward_rtn="checked";	
			else
				check_chk_pen_ward_rtn="";	
			/*End*/

			/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
			autoCnrmTfrReq = rset.getString("auto_confirm_tfr_req_yn");
			if(autoCnrmTfrReq == null )
				autoCnrmTfrReq		= "N";
			if(autoCnrmTfrReq.equals("Y"))
				chkAutoCnrmTfrReq="checked";	
			else
				chkAutoCnrmTfrReq="";	
			/*End*/

			/*Added by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866 Start*/
			dispBedClsChange = checkForNull(rset.getString("DISP_BED_CLS_CHANGE_AUTH_YN"),"N");
			if(dispBedClsChange.equals("Y"))
				chkDispBedClsChange = "checked";	
			else
				chkDispBedClsChange = "";	
			/*End*/

			/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start*/
			chk_pen_sale_rtn_bfr_dis_adv = checkForNull(rset.getString("chk_pen_sale_rtn_bfr_dis_adv"),"N");
			if(chk_pen_sale_rtn_bfr_dis_adv.equals("Y"))
				dis_chk_pen_sale_rtn_bfr_dis_adv = "checked";	
			else
				dis_chk_pen_sale_rtn_bfr_dis_adv = "";
			/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End*/
			/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
			validate_natid_IP_admsn = checkForNull(rset.getString("VALIDATE_NATID_IP_ADMSN"),"N");
			if(validate_natid_IP_admsn.equals("Y"))
				validate_natid_chk = "checked";	
			/*End MO-CRF-20148*/
			
			/*ADDED BY SUJI KEERTHI ON 24-MAR-2020 FOR MOHE-CRF-0014*/
		    enable_disch_diagnosis_yn = checkForNull(rset.getString("ENABLE_DISCH_DIAGNOSIS_YN"),"N");
			if(enable_disch_diagnosis_yn.equals("Y"))
				enable_disch_chk = "checked";
			/*END MOHE-CRF-0014*/

			/*11/10/2008 3698	SRR20056-CRF-0228*/

			if(reserve_bed_on_tfr_yn.equals("N")){
				allow_multiple_bed_disabled	= "disabled";	
				allow_multiple_bed_unchecked = "";	
			}
			allow_multiple_bed_for_resv_yn	= rset.getString("allow_multiple_bed_for_resv_yn");
			if(allow_multiple_bed_for_resv_yn == null )
				allow_multiple_bed_for_resv_yn	= "N";
			allow_multiple_bed_for_resv_yn	= allow_multiple_bed_for_resv_yn.equals("Y") ?"checked" :"" ;
			
			/*GHL-CRF-340*/
			res_reserve_bed_intraward_yn	= rset.getString("res_reserve_bed_intraward_yn");
			if(res_reserve_bed_intraward_yn == null )
				res_reserve_bed_intraward_yn	= "N";
			res_reserve_bed_intraward_yn	= res_reserve_bed_intraward_yn.equals("Y") ?"checked" :"" ;
			if(reserve_bed_on_tfr_yn.equals("checked"))
				{
				res_reserve_bed_intraward_disabled="";
				}
			else
				{
				res_reserve_bed_intraward_disabled="disabled";
				}
			/**/
			
			/* added by mujafar for ML-MMOH-CRF-0659  */
			allow_user_modify_disc_type_status_yn = rset.getString("ALLOW_USER_MODIFY_DISC_YN");
			if(allow_user_modify_disc_type_status_yn == null )
				allow_user_modify_disc_type_status_yn	= "N";
			allow_user_modify_disc_type_status_yn	= allow_user_modify_disc_type_status_yn.equals("Y") ?"checked" :"" ;
			
			
			/* END */
            Allow_Invoke_Maintn_Dth_Reg_YN	= rset.getString("Allow_Invoke_Maintn_Dth_Reg_YN");
			if(Allow_Invoke_Maintn_Dth_Reg_YN == null )
				Allow_Invoke_Maintn_Dth_Reg_YN	= "N";
			
			
			/*Below line added for this CRF ML-MMOH-CRF-0688*/
			death_register_mandatory_yn=rset.getString("death_register_mandatory_yn");
			if (Allow_Invoke_Maintn_Dth_Reg_YN.equals("Y"))
			{
				invoke_maintn_dth_reg="checked";
				if(death_register_mandatory_yn.equals("Y"))
				{
					death_reg_mandatory_yn_1="checked";
				}
				else
				{
					death_reg_mandatory_yn_2="checked";
				}
			}
			else
			{
				invoke_maintn_dth_reg="";
				death_reg_mandatory_flag="disabled";
				death_reg_non_mandatory_flag="disabled";
			}
			
			//End this CRF ML-MMOH-CRF-0688
			
			//This line moved from top to here for ML-MMOH-CRF-0688
			Allow_Invoke_Maintn_Dth_Reg_YN	= Allow_Invoke_Maintn_Dth_Reg_YN.equals("Y") ?"checked" :"" ;

			 /*for CRF "MZ-CRF-0017-IP"  by sathish on Wednesday, March 03, 2010*/
			/* BED_MANDATORY_FOR_ADMN_YN =rset.getString("BED_MANDATORY_FOR_ADMN_YN");
			if(BED_MANDATORY_FOR_ADMN_YN == null )BED_MANDATORY_FOR_ADMN_YN="N";
			BED_MANDATORY_FOR_ADMN_YN = BED_MANDATORY_FOR_ADMN_YN.equals("Y") ?"checked" :"" ;*/

			
            
			/*11/10/2008 3698	SRR20056-CRF-0228*/
            
		/*
			CANCEL_DISCHARGE_APPL_YN = rset.getString("CANCEL_DISCHARGE_APPL_YN");
			if(CANCEL_DISCHARGE_APPL_YN == null)	CANCEL_DISCHARGE_APPL_YN = "N";
*/
			warn_or_error_max_leave			= rset.getString("warn_or_error_max_leave");
            default_priority				= rset.getString("DFLT_PRIORITY_FOR_TFR_REQ");
			if(default_priority == null) 
				default_priority			= "";

//Retriving  invoke_adm_from_newborn_yn Value 12/9/2008 3752	PMG20089-CRF-0047
				
				invoke_adm_from_newborn_yn	= rset.getString("invoke_adm_from_newborn_yn");
//				out.println("invoke_adm_from_newborn_yn==>" +invoke_adm_from_newborn_yn);
				if (invoke_adm_from_newborn_yn.equals("Y"))
					invoke_adm_chkd			= "checked";
				else
					invoke_adm_chkd			= "";

			/*18/11/2008 SCR 4020 FDPMG20089CRF0119IP By Sarita Dugge*/

			allow_booking_without_edd_yn	= rset.getString("ALLOW_BOOKING_WITHOUT_EDD_YN");
			if(allow_booking_without_edd_yn== null) 
				allow_booking_without_edd_yn= "N";
			allow_booking_without_edd_yn	= allow_booking_without_edd_yn.equals("Y") ?"checked" :"" ;

			allow_booking_with_edd_yn		= rset.getString("allow_booking_with_edd_yn");
			if(allow_booking_with_edd_yn== null) 
				allow_booking_with_edd_yn	= "N";
			allow_booking_with_edd_yn		= allow_booking_with_edd_yn.equals("Y") ?"checked" :"" ;


			future_booking_for_boc_yn		= rset.getString("future_booking_for_boc_yn");
			if(future_booking_for_boc_yn==null) 
				future_booking_for_boc_yn	= "N";
			future_booking_for_boc_yn		= future_booking_for_boc_yn.equals("Y") ?"checked" :"";


				
			no_of_days_before_for_boc		= rset.getString("no_of_days_before_for_boc");
			if(no_of_days_before_for_boc == null) 
				no_of_days_before_for_boc	= "";
			consider_edd_stop_for_boc_yn	= rset.getString("consider_edd_stop_for_boc_yn");
			if(consider_edd_stop_for_boc_yn==null) 
				consider_edd_stop_for_boc_yn= "N";
			consider_edd_stop_for_boc_yn	= consider_edd_stop_for_boc_yn.equals("Y") ? "checked" : "";

			action_for_boc					= rset.getString("action_for_boc");
			if(action_for_boc == null) action_for_boc="";
			if(action_for_boc.equals("W"))
				action_for_boc_w			= "selected";
			else
				action_for_boc_w			= "";
			if(action_for_boc.equals("S"))
				action_for_boc_s			= "selected";
			else
				action_for_boc_s			= "";

			future_booking_for_bou_yn		= rset.getString("future_booking_for_bou_yn");
			if(future_booking_for_bou_yn==null) 
				future_booking_for_bou_yn	= "N";
			future_booking_for_bou_yn		= future_booking_for_bou_yn.equals("Y") ?"checked" :"";

				
			no_of_days_before_for_bou		= rset.getString("no_of_days_before_for_bou");	
			if(no_of_days_before_for_bou == null) 
				no_of_days_before_for_bou	= "";
			consider_edd_stop_for_bou_yn	= rset.getString("consider_edd_stop_for_bou_yn");
			if(consider_edd_stop_for_bou_yn==null) 
				consider_edd_stop_for_bou_yn= "N";
			consider_edd_stop_for_bou_yn	= consider_edd_stop_for_bou_yn.equals("Y") ? "checked" : "";

			action_for_bou					= rset.getString("action_for_bou");
			if(action_for_bou == null) 
				action_for_bou				= "";
			if(action_for_bou.equals("W"))
				action_for_bou_w			= "selected";
			else
				action_for_bou_w			= "";
			if(action_for_bou.equals("S"))
				action_for_bou_s			= "selected";
			else
				action_for_bou_s			= "";

			future_booking_for_bnc_yn		= rset.getString("future_booking_for_bnc_yn");
			if(future_booking_for_bnc_yn==null) 
				future_booking_for_bnc_yn	= "N";
			future_booking_for_bnc_yn		= future_booking_for_bnc_yn.equals("Y") ?"checked" :"";

				
			no_of_days_before_for_bnc		= rset.getString("no_of_days_before_for_bnc");
			if(no_of_days_before_for_bnc == null) 
				no_of_days_before_for_bnc	= "";
			consider_edd_stop_for_bnc_yn	= rset.getString("consider_edd_stop_for_bnc_yn");
			if(consider_edd_stop_for_bnc_yn==null) 
				consider_edd_stop_for_bnc_yn= "N";
			consider_edd_stop_for_bnc_yn	= consider_edd_stop_for_bnc_yn.equals("Y") ? "checked" : "";

			action_for_bnc					= rset.getString("action_for_bnc");
			if(action_for_bnc == null) 
				action_for_bnc				= "";
			if(action_for_bnc.equals("W"))
				action_for_bnc_w			= "selected";
			else
				action_for_bnc_w			= "";

			if(action_for_bnc.equals("S"))
				action_for_bnc_s			= "selected";
			else
				action_for_bnc_s			= "";

			future_booking_for_bnu_yn		= rset.getString("future_booking_for_bnu_yn");
			if(future_booking_for_bnu_yn==null) 
				future_booking_for_bnu_yn	= "N";
			future_booking_for_bnu_yn		= future_booking_for_bnu_yn.equals("Y") ?"checked" :"";

				
			no_of_days_before_for_bnu		= rset.getString("no_of_days_before_for_bnu");
			if(no_of_days_before_for_bnu == null) 
				no_of_days_before_for_bnu	= "";
			consider_edd_stop_for_bnu_yn	= rset.getString("consider_edd_stop_for_bnu_yn");
			if(consider_edd_stop_for_bnu_yn==null) 
				consider_edd_stop_for_bnu_yn= "N";
			consider_edd_stop_for_bnu_yn	= consider_edd_stop_for_bnu_yn.equals("Y") ? "checked" : "";

			action_for_bnu					= rset.getString("action_for_bnu");

			if(action_for_bnu == null) action_for_bnu="";
			if(action_for_bnu.equals("W"))
				action_for_bnu_w			= "selected";
			else
				action_for_bnu_w			= "";

			if(action_for_bnu.equals("S"))
				action_for_bnu_s			= "selected";
			else
				action_for_bnu_s			= "";
		
			grc_prd_for_asgn_bed_mark_arvl	= rset.getString("grc_prd_for_asgn_bed_mark_arvl");
			if(grc_prd_for_asgn_bed_mark_arvl == null) 
				grc_prd_for_asgn_bed_mark_arvl="";

			 change_admission_dtls			= rset.getString("change_admission_dtls");
			if(change_admission_dtls == null) 
				change_admission_dtls		= "";

			display_discharge_pat_list		= rset.getString("display_discharge_pat_list");	
			if(display_discharge_pat_list == null) 
				display_discharge_pat_list	= "A";
				
		 /*Added by Senthil on 12-Dec-2011 for this CRF [KDAH-CRF-0035] */          
		  consenttxtdtls=checkForNull(rset.getString("consent_txt_dtls"));
		  
		  /*Below line Added for this CRF Bru-HIMS-CRF-354*/
		  	deft_pract_bedside_referral	= rset.getString("DFLT_PRACT_BEDSIDE_REFERRAL");
			if(deft_pract_bedside_referral == null)	deft_pract_bedside_referral= "";
			if(deft_pract_bedside_referral.equals("A"))
				deft_pract_bedside_referral_chk_a = "selected";
			if(deft_pract_bedside_referral.equals("L"))
				deft_pract_bedside_referral_chk_l = "selected";	
			//else
			//deft_pract_bedside_referral_chk	= "";			
			//else
			//	deft_pract_bedside_referral_chk			= "";		  
		  //End Bru-HIMS-CRF-354
		  
		  

		 /*Added by Shanthi for Bru-HIMS-CRF-157*/
		 	reason_for_late_discharge			= rset.getString("ALLOW_LATE_DISCHARGE_REASON");
			if(reason_for_late_discharge == null )
				reason_for_late_discharge	= "N";	
			
			discharge_reason_mandatory_yn=rset.getString("DISCH_REASON_MAND_YN");
			if (reason_for_late_discharge.equals("Y"))
			{
				reason_for_late_discharge="checked";
				if(discharge_reason_mandatory_yn.equals("Y"))
				{
					radio_check_mandatory_yn_1="checked";
				}
				else
				{
					radio_check_mandatory_yn_2="checked";
				}
			}
			else
			{
				reason_for_late_discharge="";
				mandatory_flag="disabled";
				non_mandatory_flag="disabled";
			}
			//Added for the CRF HSA-CRF-0035 - start
			transfer_wo_delink_yn=checkForNull(rset.getString("transfer_wo_delink_yn"),"N");
			if(transfer_wo_delink_yn.equals("Y"))
				transfer_wo_delink_checked="checked";
			//Added for the CRF HSA-CRF-0035 - End
			
			//Added for the CRF KDAH-CRF-0104  by Dharma - start
			pre_disch_appl_yn	= checkForNull(rset.getString("pre_disch_appl_yn"),"N");
			if(pre_disch_appl_yn.equals("Y"))
				pre_disch_appl_checked="checked";
			//Added for the CRF KDAH-CRF-0104  by Dharma - End
			
			//Added for MMS-QH-CRF-0144
			reason_for_adm_reqd_yn	= checkForNull(rset.getString("REASON_MANDATORY_FOR_ADMN_YN"),"N");
			if(reason_for_adm_reqd_yn.equals("Y"))
				reason_for_adm_reqd_checked="checked";	
           //Added for  HSA-CRF-146.1	  
			allow_muti_bedside_review_yn	= checkForNull(rset.getString("allow_muti_bedside_review_yn"),"N");
			if(allow_muti_bedside_review_yn.equals("Y"))allow_muti_bedside_review_checked="checked";
			//End HSA-CRF-146.1
			//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362
			ca_record_referral_note_yn		= checkForNull(rset.getString("ca_record_referral_note_yn"),"N");
			if(ca_record_referral_note_yn.equals("Y"))ca_record_referral_note_yn_checked="checked";
			//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362
			//Added by Kamatchi S for MOHE-CRF-0154
			allow_reg_referral_yn		= checkForNull(rset.getString("allow_reg_referral_yn"),"Y");
			if(allow_reg_referral_yn.equals("Y")) allow_reg_referral_yn_checked="checked";

			weight_on_admn_mandatory	= checkForNull(rset.getString("weight_on_admn_mandatory"));/*Added by Dharma on Oct 17th against HSA-CRF-0181 [IN:049541]*/
			//above line moved here for this incident HSA-SCF-0284 [IN:056842]
			chk_dis_pat_BT_order_pend=checkForNull(rset.getString("CHK_DIS_PAT_BT_ORDER_PEND"),"N");
			trans_yn_unfnzed_newborn = checkForNull(rset.getString("TRANS_YN_UNFNZED_NEWBORN"),"N");//Added by Dharma on 23rd May 2018 against ML-MMOH-CRF-0898 [IN:064757]
			admission_type=checkForNull(rset.getString("admission_type"),"");//Added by shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618
			
			height_on_admn_mandatory	= checkForNull(rset.getString("height_on_admn_mandatory"));
			enable_height_bmi_pat_cls = checkForNull(rset.getString("enable_height_bmi_pat_cls"));
							}
		else
		{
			Disable_Enable_flg	= "";
			Readonly_flg		= "";
		}
			
			

	}

	session.putValue("consenttxtdtls",consenttxtdtls);
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();

	%>

<script>

function checkForMax(obj)
{
	if(parseInt(obj.value) > 24)
	{
		var DCerror = getMessage('DATE1_GT_DATE2','IP');
		DCerror = DCerror.replace('$',getLabel("Common.MaxDischargePeriodforDayCare.label","Common"));
		DCerror = DCerror.replace('#',"24");
		alert(DCerror);
		obj.select();
		obj.focus();
	}
}


function change() 
{
	if (document.ipparam_form.priority_appl_yn.checked == true)
	{	
		if(document.ipparam_form.priority.options.length > 1)
		{	
			document.ipparam_form.star.style.visibility = 'visible';
		}
		document.ipparam_form.priority.value = "";
		document.ipparam_form.priority.disabled = false;
	}
	else
	{
		document.ipparam_form.priority.value = "";
		document.ipparam_form.priority.disabled = true;
		document.ipparam_form.star.style.visibility = 'hidden';
	}
}

function disfuturebooking(obj)
{
			
	if(obj.name == 'future_booking_for_boc_yn' ){
		if(document.forms[0].future_booking_for_boc_yn.checked == false){
			document.forms[0].no_of_days_before_for_boc.value = '';
			document.forms[0].no_of_days_before_for_boc.disabled = true
			document.forms[0].consider_edd_stop_for_boc_yn.value = '';
			document.forms[0].consider_edd_stop_for_boc_yn.checked = false;
			document.forms[0].consider_edd_stop_for_boc_yn.disabled = true
			document.forms[0].action_for_boc.value = 'W';
			document.forms[0].action_for_boc.disabled = true
			
		}else{
			document.forms[0].no_of_days_before_for_boc.disabled = false
			document.forms[0].no_of_days_before_for_boc.value = '<%=no_of_days_before_for_boc%>';
			document.forms[0].consider_edd_stop_for_boc_yn.disabled = false;
			if('<%=consider_edd_stop_for_boc_yn%>'== 'checked')
			document.forms[0].consider_edd_stop_for_boc_yn.checked = true;
			document.forms[0].action_for_boc.disabled = false;
			document.forms[0].action_for_boc.value = '<%=action_for_boc%>';
			
		}
	}else if(obj.name == 'future_booking_for_bou_yn' ){
		if(document.forms[0].future_booking_for_bou_yn.checked == false){
			document.forms[0].no_of_days_before_for_bou.value = '';
			document.forms[0].no_of_days_before_for_bou.disabled = true
			document.forms[0].consider_edd_stop_for_bou_yn.value = '';
			document.forms[0].consider_edd_stop_for_bou_yn.checked = false;
			document.forms[0].consider_edd_stop_for_bou_yn.disabled = true
			document.forms[0].action_for_bou.value = 'W';
			document.forms[0].action_for_bou.disabled = true
			
		}else{
			document.forms[0].no_of_days_before_for_bou.disabled = false
			document.forms[0].no_of_days_before_for_bou.value = '<%=no_of_days_before_for_bou%>';
			document.forms[0].consider_edd_stop_for_bou_yn.disabled = false;
			if('<%=consider_edd_stop_for_bou_yn%>'== 'checked')
			document.forms[0].consider_edd_stop_for_bou_yn.checked = true;
			document.forms[0].action_for_bou.disabled = false;
			document.forms[0].action_for_bou.value = '<%=action_for_bou%>';
			
		}
	}else if(obj.name == 'future_booking_for_bnc_yn' ){
		if(document.forms[0].future_booking_for_bnc_yn.checked == false){
			document.forms[0].no_of_days_before_for_bnc.value = '';
			document.forms[0].no_of_days_before_for_bnc.disabled = true
			document.forms[0].consider_edd_stop_for_bnc_yn.value = '';
			document.forms[0].consider_edd_stop_for_bnc_yn.checked = false;
			document.forms[0].consider_edd_stop_for_bnc_yn.disabled = true
			document.forms[0].action_for_bnc.value = 'W';
			document.forms[0].action_for_bnc.disabled = true
			
		}else{
			document.forms[0].no_of_days_before_for_bnc.disabled = false
			document.forms[0].no_of_days_before_for_bnc.value = '<%=no_of_days_before_for_bnc%>';
			document.forms[0].consider_edd_stop_for_bnc_yn.disabled = false;
			if('<%=consider_edd_stop_for_bnc_yn%>'== 'checked')
			document.forms[0].consider_edd_stop_for_bnc_yn.checked = true;
			document.forms[0].action_for_bnc.disabled = false;
			document.forms[0].action_for_bnc.value = '<%=action_for_bnc%>';
			
		}
	}else if(obj.name == 'future_booking_for_bnu_yn' ){
		if(document.forms[0].future_booking_for_bnu_yn.checked == false){
			document.forms[0].no_of_days_before_for_bnu.value = '';
			document.forms[0].no_of_days_before_for_bnu.disabled = true
			document.forms[0].consider_edd_stop_for_bnu_yn.value = '';
			document.forms[0].consider_edd_stop_for_bnu_yn.checked = false;
			document.forms[0].consider_edd_stop_for_bnu_yn.disabled = true
			document.forms[0].action_for_bnu.value = 'W';
			document.forms[0].action_for_bnu.disabled = true
			
		}else{
			document.forms[0].no_of_days_before_for_bnu.disabled = false
			document.forms[0].no_of_days_before_for_bnu.value = '<%=no_of_days_before_for_bnu%>';
			document.forms[0].consider_edd_stop_for_bnu_yn.disabled = false;
			if('<%=consider_edd_stop_for_bnu_yn%>'== 'checked')
			document.forms[0].consider_edd_stop_for_bnu_yn.checked = true;
			document.forms[0].action_for_bnu.disabled = false;
			document.forms[0].action_for_bnu.value = '<%=action_for_bnu%>';
			
		}
	}

}

</script>
<body onLoad='focusTxt();changepriority();disBAC()' onSelect='codeArrestThruSelect()' onMouseDown="CodeArrest()" onKeyDown = "lockKey()">
<form name='ipparam_form' id='ipparam_form'  method="post" action="../../servlet/eIP.IPParamServlet"  target="messageFrame">
	<input type='hidden' name='PCIAY' id='PCIAY' value='' >
	<input type='hidden' name='DPBY' id='DPBY' value='' >
	<input type='hidden' name='cbcy' id='cbcy' value='' >
	<input type='hidden' name='dcay' id='dcay' value='' > 
	<input type='hidden' name='AGPDA' id='AGPDA' value='' >  <!-- added by mujafar for MO-CRF-20157 -->
	
<div id = 'ADT' >
<!-- <a name = 'outpat_act_tab_vw'></a> -->
	<ul id="tablist" class="tablist" style="padding-left:0px">
		<li class="tablistitem" title="ADT">
			<a class="tabClicked" id="outpat_act_tab"><span class="tabSpanclicked " id="outpat_act_tab_span" onClick='javascript:expandCollapse("adt")'>ADT</span>
			</a>
		</li>
		<li class="tablistitem" title="Additional">
			<a class="tabA" id="inpat_act_tab"><span class="tabAspan" id="inpat_act_tab_span" onClick='javascript:expandCollapse("additional")'><fmt:message key="Common.Additional.label" bundle="${common_labels}"/></span>
			</a>
		</li>
	</ul>
	
<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%' style = "margin-top:-15px">  
<th colspan='9' align='left'><fmt:message key="Common.booking.label" bundle="${common_labels}"/></th>

<%
	/*if(unregistered_patients_bkg_yn==null||unregistered_patients_bkg_yn.equals(""))
		{
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
			if(unregistered_patients_bkg_yn.equals("checked"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/

		
		%>
	<tr>
		<td  class='label' align ='left' width="20%" ><fmt:message key="eIP.AllowBookingforUnregisteredPatients.label" bundle="${ip_labels}"/></td>
		<td class='fields' align ='left' width="15%" ><input type='checkbox' size='8' maxlength='8' name='unregistered_patients_bkg_yn' id='unregistered_patients_bkg_yn' value='Y' <%=unregistered_patients_bkg_yn%> <%=Disable_Enable_flg%> ></td>

<%
/*if((bkg_grace_period.equals(null)||bkg_grace_period.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>

		<td class='label' align ='left' width="22%" nowrap><fmt:message key="eIP.GracePeriodforRevisionofBooking.label" bundle="${ip_labels}"/></td>
		<td  class='fields' colspan = "6" align ='left' width="20%" ><input type='text' name='bkg_grace_period' id='bkg_grace_period' size='3'  maxlength='3' value="<%=bkg_grace_period%>" <%=Readonly_flg%> onBlur="CheckNum(this)" onKeyPress='return(ChkNumberInput(this,event,0))'>&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/>&nbsp;</td>
	</tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td>
<%
/*if(adv_bed_book_period_bkg.equals(null)||adv_bed_book_period_bkg.equals("0")||adv_bed_book_period_bkg.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>

	<tr>
		<td   class='label' align='left' width="24%" ><fmt:message key="eIP.MaxAllowablePeriodforAdvanceBedBooking.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left' >&nbsp;<input type='text' size='3' maxlength='3' name='adv_bed_book_period_bkg' id='adv_bed_book_period_bkg' value="<%=adv_bed_book_period_bkg%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);CheckZeroVal(this)">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/><img src='../../eMP/images/mandatory.gif'align='center'></img></td>
		<td   class='label' align='left' ><fmt:message key="eIP.CheckBookingLimitBasedon.label" bundle="${ip_labels}"/></td>
		<td   class='fields' colspan = "6" align='left' ><% String str3="",str4="";  if(chk_booking_limit_by.equals("1")) str3="selected"; else str4="selected";%>&nbsp;<select name='chk_booking_limit_by' id='chk_booking_limit_by' <%=Disable_Enable_flg%>><option <%=str3%> value='1'><fmt:message key="eIP.NursingUnitBedClass.label" bundle="${ip_labels}"/><option <%=str4%> value='2'><fmt:message key="eIP.AgeGroupBedClass.label" bundle="${ip_labels}"/></select></td>
	</tr>
	<tr>
		<td class='BLANKROW1PT' colspan='6' >&nbsp;</td>
	</tr>	
	<%
	
/*	if(adm_date_chk_days==null||adm_date_chk_days.equals("0")||adm_date_chk_days.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>
	<tr><td height=5 colspan="6" class=label>&nbsp;</td></tr>
	<tr>
		<td class='label' align='left' ><fmt:message key="eIP.AllowedBooking.label" bundle="${ip_labels}"/></td>
		<td class='fields' align='left' >&nbsp;<select name='allowed_booking_type' id='allowed_booking_type'><option value='D'><fmt:message key="Common.Direct.label" bundle="${common_labels}"/></option><option value='R'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option></select></td>
		
		<td class='label' align='left' ><fmt:message key="eIP.BlockBedBasedon.label" bundle="${ip_labels}"/></td>
		<td class='fields' colspan = "6" align='left' >&nbsp;<select name='block_bed_based_on' id='block_bed_based_on'><option value='P'><fmt:message key="eIP.PrefAdmDateTime.label" bundle="${ip_labels}"/></option><option value='E'><fmt:message key="eIP.ExpectedDischargeDateTime.label" bundle="${ip_labels}"/></option></select></td>
<%
	if(block_bed_based_on.equals("P")) 
		out.println("<script>document.forms[0].block_bed_based_on.value='P';</script>");
	else
		out.println("<script>document.forms[0].block_bed_based_on.value='E';</script>");
%>
	</tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<tr>	
		<td class='label'><fmt:message key="eIP.MultipleBookingforPatients.label" bundle="${ip_labels}"/></td>
		<td class='fields'><input type='checkbox' name='multi_book_pat_yn' id='multi_book_pat_yn' value='N' <%=Disable_Enable_flg%> <%=multi_bkg_patient_yn%>></td>
	<!--Added  for PMG2016-CRF-0002 IN061508 on 23rd Aug 16-->
	<td class='label'><fmt:message key="eIP.ReleaseBookedBedForAdmission.label" bundle="${ip_labels}"/></td>
	<td class='fields' colspan = "6"><input type='checkbox' name='rel_booked_bed_yn' id='rel_booked_bed_yn' value='N'  <%=rel_booked_bed_yn%> ></td>
	
	</tr>
	<!--Added  for PMG2016-CRF-0002 IN061508 on 23rd Aug 16-->
	<!--	Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas	-->
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<td   class='label' align='left' ><fmt:message key="eIP.DisplayNoShowstatusinConfirmBookingAfter.label" bundle="${ip_labels}"/></td>
	<td   class='fields' align='left' >&nbsp;<input type='text' size='3' maxlength='3' name='NOSHOW_BKNG_PERIOD' id='NOSHOW_BKNG_PERIOD' value="<%=noshow_bkng_period%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);CheckZeroVal(this)">&nbsp;<fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></td>
<!--  end  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas	-->
<%	if(bl_operational.equals("Y"))
	{	%>

		<td class='label'><fmt:message key="Common.CaptureFinancialDetails.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan = "6"><input type='checkbox' name='capture_fin_dtls_yn' id='capture_fin_dtls_yn' value='N'  <%=disable_enable_cap_fin_dtl%> <%=capture_fin_dtls_yn%> ></td>
<%	}
	else
	{	%>
		<td class=label>&nbsp;</td><td class=label>&nbsp;</td>
<%	}	%>

	<tr>
<script>document.forms[0].allowed_booking_type.value = "<%=allowed_booking_type%>"

</script>
	<tr><th colspan='9' align='left'><fmt:message key="Common.admission.label" bundle="${common_labels}"/>/<fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>/<fmt:message key="Common.Transfer.label" bundle="${common_labels}"/></th></tr>
	<tr>
	   <td class='label' align='left' ><fmt:message key="eIP.MaxAllowableBackdatedAdmission.label" bundle="${ip_labels}"/></td>
       <td class='fields' >&nbsp;<input type='text' <%=Readonly_flg%> name='adm_date_chk_days' size='3' maxlength='3' value="<%=adm_date_chk_days%>"  onBlur="CheckNum(this);CheckZeroVal(this);" onKeyPress='return(ChkNumberInput(this,event,0))'> 
		<%
		String stradm_date_chk_days_type_hours="";
		String stradm_date_chk_days_type_days="";
		if(adm_date_chk_days_type.equalsIgnoreCase("H")) stradm_date_chk_days_type_hours ="selected";
		else stradm_date_chk_days_type_days="selected" ;
		%>
		&nbsp;<select name="adm_date_chk_days_type" id="adm_date_chk_days_type" <%=Disable_Enable_flg%>>
		<option value='H'  <%=stradm_date_chk_days_type_hours%> ><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
		<option value='D'  <%=stradm_date_chk_days_type_days%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
		</select><img src='../../eMP/images/mandatory.gif'align='center'></img></td>
		<% 
		String str1="",str2="",string3="",string4 ="";
		if(allowed_admission_type.equals("R")) 
			str1="selected"; 
		else if(allowed_admission_type.equals("B"))
			str2="selected"; 
		else if(allowed_admission_type.equals("D"))
			string3="selected"; 
		else if(allowed_admission_type.equals("Z"))
			string4="selected"; 
		%>
		<td   class='label' align='left' ><fmt:message key="eIP.AllowedAdmission.label" bundle="${ip_labels}"/></td>
        <td   class='fields' colspan = "6" align ='left' >
		&nbsp;<select name='allowed_admission_type' id='allowed_admission_type'>
		<option <%=string3%> value='D'><fmt:message key="Common.Direct.label" bundle="${common_labels}"/></option>
		<option <%=str2%> value='B'><fmt:message key="Common.booking.label" bundle="${common_labels}"/></option>
		<option <%=string4%> value='Z'><fmt:message key="eIP.BookingorReferral.label" bundle="${ip_labels}"/></option>
		<option <%=str1%> value='R'><fmt:message key="Common.referral.label" bundle="${common_labels}"/></option>
		</select>		
		</td> 
	</tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
<%
/*if(vital_signs_battery_id.equals(null)||vital_signs_battery_id.equals("0")||vital_signs_battery_id.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>
<!-- The New Check Box "Invoke admission from New Born Registration" Was Introduced On 5/27/2008 -->
	<!--<tr>
			<td   class='label' align='right' ><fmt:message key="eIP.InvokeAdmFromNewBornReg.label" bundle="${ip_labels}"/></td>
			<td class='fields' align='left' ><input type='checkbox'  name='invk_admsn_frm_nwbrn_regYN' id='invk_admsn_frm_nwbrn_regYN' value='N'  tabIndex='0'  ></td>
			<td   class='fields' align='left' ></td><td></td>
	</tr>-->
	

<tr>

<%
/*if(MAX_DISCH_PERIOD_FOR_DC.equals(null)||MAX_DISCH_PERIOD_FOR_DC.equals("0")||MAX_DISCH_PERIOD_FOR_DC.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>

	<td   class='label' align='left' ><fmt:message key="Common.MaxDischargePeriodforDayCare.label" bundle="${common_labels}"/></td>
	<td   class='fields' align='left' >&nbsp;<input type='text' size='2' maxlength='2' name='MAX_DISCH_PERIOD_FOR_DC' id='MAX_DISCH_PERIOD_FOR_DC' value="<%=MAX_DISCH_PERIOD_FOR_DC%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="checkForMax(this);CheckNum(this);CheckZeroVal(this)">&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/><img src='../../eMP/images/mandatory.gif'align='center'></img></td>

	<td   class='label' align='left' ><fmt:message key="eIP.MaxAllowableBackdatedDischarge.label" bundle="${ip_labels}"/></td>
	<td   class='fields' colspan = "6" align ='left'>&nbsp;<input type='text' name='dis_date_chk_days' id='dis_date_chk_days' size='2'  maxlength='2' value="<%=dis_date_chk_days%>"  <%=Readonly_flg%> onBlur="CheckNum(this);CheckZeroVal(this);" onKeyPress='return(ChkNumberInput(this,event,0))'>
		
&nbsp;<select name='diag_update_period_max_unit' id='diag_update_period_max_unit' <%=Disable_Enable_flg%> >
<%		
	if(dis_date_chk_days_unit.equals("H"))
	out.println("<option value='H' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels")+"</option>");
	else
	out.println("<option value='H'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels")+"</option>");
	if(dis_date_chk_days_unit.equals("D"))
	out.println("<option value='D' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")+"</option>");
	else
	out.println("<option value='D'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")+"</option>");
%>
</select><img src='../../eMP/images/mandatory.gif'align='center'></img></td>
</tr>

<%
/*if(dis_date_chk_days==null||dis_date_chk_days.equals("0")||dis_date_chk_days.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>

<%
/*if(PRIORITY_APPLICABLE.equals("")||(PRIORITY_APPLICABLE==null)||PRIORITY_APPLICABLE.equals("null"))
	{
		Disable_Enable_flg	="";
		Readonly_flg	="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg	="Readonly";
	}*/

%><!--12/9/2008 3752	PMG20089-CRF-0047-->
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<tr>
		<td class='label' align='left' ><fmt:message key="eIP.InvokeAdmFromNewBornReg.label" bundle="${ip_labels}"/></td>
		<td class='fields' align='left' ><input type='checkbox' size='8' maxlength='8'  name='invk_admsn_frm_nwbrn_regYN' id='invk_admsn_frm_nwbrn_regYN' value='N'  <%=invoke_adm_chkd%> tabIndex='0' onClick=""></td>

		<td   class='label' align='left' ><fmt:message key="eIP.GrcprdforAsgnBed.label" bundle="${ip_labels}"/></td>
		<td   class='fields' colspan = "6" align='left' >&nbsp;<input type='text' size='1' maxlength='1' name='grc_prd_for_asgn_bed_mark_arvl' id='grc_prd_for_asgn_bed_mark_arvl' value="<%=grc_prd_for_asgn_bed_mark_arvl%>"  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="checkForMax(this);CheckNum(this);CheckZeroVal(this)">&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/><img src='../../eMP/images/mandatory.gif'align='center'></img></td>

	</tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
<tr>
	<td class='label' align='left' ><fmt:message key="Common.PriorityApplicable.label" bundle="${common_labels}"/></td>
	<td class='fields' align='left' ><input type='checkbox' size='8' maxlength='8'  name='priority_appl_yn' id='priority_appl_yn' value='Y' <%=prioryn%> <%=Disable_Enable_flg%> tabIndex='0' onClick="change()"></td>

		

		<td   class='label' align='left' ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan = "6">&nbsp;<select name="priority" id="priority" <%=Disable_Enable_flg%> >
		<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
		<%
			String sel ="";
			stmt = con.createStatement();
			rset = stmt.executeQuery("select priority_code, ip_get_desc.ip_transfer_priority('"+facility_id+"',priority_code,'"+locale+"',2)short_desc from IP_TRANSFER_PRIORITY where facility_id='"+facility_id+"' and eff_status = 'E' order by 2");
			while(rset!=null && rset.next())
			{
				if(default_priority.equals(rset.getString(1)))
					sel = "selected";
				else
					sel = "";

					out.println("<option '"+sel+"' value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
			
		%>
<script>
		if(document.forms[0].priority_appl_yn.checked == true)
		{
			document.forms[0].priority.value = "<%=default_priority%>";
		}
		else
		{
			document.forms[0].priority.value = "";
			document.forms[0].priority.disabled = true;
		}
</script>
		</select><img id="star" src='../../eMP/images/mandatory.gif'align='center'></img></td> 
	</tr>	
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>

   <%
	/*if(PAT_CHECK_IN_ALLOWED_YN.equals("")||PAT_CHECK_IN_ALLOWED_YN.equals(null))
		{
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
			if(PAT_CHECK_IN_ALLOWED_YN.equals("checked"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/
	%>
	 <tr>
		<td   class='label' align='left' ><fmt:message key="eIP.AllowPatientCheckin.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left'  ><input type='checkbox' size='8' maxlength='8'  name='PAT_CHECK_IN_ALLOWED_YN' id='PAT_CHECK_IN_ALLOWED_YN' value='Y' <%=PAT_CHECK_IN_ALLOWED_YN%> <%=Disable_Enable_flg%> ></td>
		<td   class='label' align='left' ><fmt:message key="eIP.DeactivatePseudoBed.label" bundle="${ip_labels}"/></td>
 <%
	/*if(DEACTIVATE_PSEUDO_BED_YN.equals("")||DEACTIVATE_PSEUDO_BED_YN.equals(null))
	{
		Disable_Enable_flg	="";
		Readonly_flg	="";
	}
	else 
		if(DEACTIVATE_PSEUDO_BED_YN.equals("checked"))
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg	="Readonly";
	}*/
 %>
		<td   class='fields' colspan = "6" align='left' ><input type='checkbox' size='8' maxlength='8'  name='DEACTIVATE_PSEUDO_BED_YN' id='DEACTIVATE_PSEUDO_BED_YN' value='Y' <%=DEACTIVATE_PSEUDO_BED_YN%> <%=Disable_Enable_flg%> ></td>
		</tr>
		
			<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
 <%
	/*if(change_bed_class_yn.equals("")||change_bed_class_yn.equals(null))
		{
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
			if(change_bed_class_yn.equals("checked"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/
 %>
		<tr>
		<td   class='label' align='left' ><fmt:message key="eIP.RequestforBedClassChange.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left' ><input type='checkbox' size='8' maxlength='8'  name='change_bed_class_yn' id='change_bed_class_yn' value='Y' <%=change_bed_class_yn%> <%=Disable_Enable_flg%> >
		</td>

		<td   class='label' align='left'><fmt:message key="Common.VitalSignsBattery.label" bundle="${common_labels}"/> </td>
		<td   class='fields' colspan = "6"  align ='left'>&nbsp;<select name='vital_signs_battery_id' id='vital_signs_battery_id' <%=Disable_Enable_flg%>>
		<%
			StringBuffer sqlVital = new StringBuffer();
			sqlVital.append("select short_desc,discr_msr_id from am_discr_msr where eff_Status ='E' and result_type ='V' order by short_desc");	
			stmt	= con.createStatement();
			rset = stmt.executeQuery(sqlVital.toString());	
			while(rset!=null && rset.next())
				{	
					if(vital_signs_battery_id.equals(rset.getString(2)))
					out.println("<option selected value='"+rset.getString(2)+"'>"+rset.getString(1)+"</option>");
					else
					out.println("<option  value='"+rset.getString(2)+"'>"+rset.getString(1)+"</option>");
				}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		%>
		</select>		
		</td>

		</tr>
 <%
	/*if(discharge_checklist_app_yn.equals("")||discharge_checklist_app_yn.equals(null))
		{
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
			if(discharge_checklist_app_yn.equals("checked"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/
%>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
		<tr>

			<td  class='label' align='left' ><fmt:message key="eIP.DischargeCheckListApplicable.label" bundle="${ip_labels}"/></td>
		<td class='fields' align='left' ><input type='checkbox' size='8' maxlength='8'  name='discharge_checklist_app_yn' id='discharge_checklist_app_yn' value='Y' <%=discharge_checklist_app_yn%> <%=Disable_Enable_flg%> >
		</td>
		<td class='label' align='left' ><fmt:message key="eIP.DischargeChecklistExpiryPeriod.label" bundle="${ip_labels}"/></td>&nbsp;
		<td class='fields' colspan = "6">&nbsp;<input type='text'align="left"  name='disc_chklst_exp_period' id='disc_chklst_exp_period'  size='2' maxlength='2' value="<%=DISC_CHKLST_EXP_PERIOD%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this);'>
	<% 
		String dis_chklst_exp_hrs = "";
		String dis_chklst_exp_days  = "" ;

		if(DISC_CHKLST_EXP_PER_UNIT.equalsIgnoreCase("H"))
			dis_chklst_exp_hrs = "selected";
		else
			dis_chklst_exp_days = "selected";
	%>
	&nbsp;<select name="disc_chklst_exp_per_unit" id="disc_chklst_exp_per_unit" <%=Disable_Enable_flg%>>
		<option value='H' <%=dis_chklst_exp_hrs%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
		<option value='D' <%=dis_chklst_exp_days%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
	</select>
	</td>
		</tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<tr>

			<td  class='label' align='left' ><fmt:message key="eIP.DsplyDisPatLst.label" bundle="${ip_labels}"/></td>
	<% 
		String display_discharge_pat_listA	= "";
		String display_discharge_pat_listD  = "" ;

		if(display_discharge_pat_list.equalsIgnoreCase("A"))
			display_discharge_pat_listA = "selected";
		else
			display_discharge_pat_listD = "selected";
	%>
		<td class='fields' align='left' >
			<select name="display_discharge_pat_list" id="display_discharge_pat_list">
				<option value='A' <%=display_discharge_pat_listA%>><fmt:message key="eIP.AllPatients.label" bundle="${ip_labels}"/></option>
				<option value='D' <%=display_discharge_pat_listD%>><fmt:message key="eIP.OnlyPatPDA.label" bundle="${ip_labels}"/></option>
			</select>
		</td>
		<!-- Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] -->
		<td  class='label' align='left' ><fmt:message key="eIP.AlertReadmitPatient.label" bundle="${ip_labels}"/></td>
		<td class='fields' >&nbsp;<input type='text'align="left"  name='chk_for_readmission' id='chk_for_readmission'  size='2' maxlength='3' value="<%=chk_for_readmission%>"  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this)'>
         &nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
	</td> 
	<!-- end Bru-HIMS-CRF-155 [IN030274]  -->
		<td height=5 colspan=6 class=label>&nbsp;<!--<fmt:message key="eIP.CheckForPendingOrdersBerforeDischargeAdvice.label" bundle="${ip_labels}" /> <input type='checkbox' size='8' maxlength='8'  name='chk_for_pen_orders_bfr_dis_adv' id='chk_for_pen_orders_bfr_dis_adv' value='Y' <%=chk_for_pen_orders_bfr_dis_adv%>  tabIndex='0' onclick='dischargeAdvice()'  >--></td>
	</td>
		</tr>
		<%  
		
		

		%>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<tr><td height=5 class=label><fmt:message key="eIP.CheckForPendingOrdersBerforeDischargeAdvice.label" bundle="${ip_labels}" /></td><td height=5 class=fields> <input type='checkbox' size='8' maxlength='8'  name='chk_for_pen_orders_bfr_dis_adv' id='chk_for_pen_orders_bfr_dis_adv' value='Y' <%=chk_for_pen_orders_bfr_dis_adv%>  tabIndex='0' onclick='dischargeAdvice()'  ></td> <td height=5 colspan=6  class="label" ><fmt:message key="eIP.IfOrdersArePending.label" bundle="${ip_labels}"  /> <input type='radio' id='r_1' name='NO' id='NO' value='NO'  tabIndex='0' <%=radio_flag_1%> <%=radio_check_yn_1%> onclick='clearRadio_1(this)' ><height=5 colspan=2 class=label><fmt:message key="eIP.DonotallowdischargeAdvice.label" bundle="${ip_labels}"  /><input type='radio' id='r_2' name='YES' id='YES' value='Y'  tabIndex='0' <%=radio_flag_2%> <%=radio_check_yn_2%> onclick='clearRadio_2(this)'><height=5 colspan=2 class=label><fmt:message key="eIP.AllowDischargeAdvice.label" bundle="${ip_labels}"/></td> 
	</tr> <input type='hidden' name='radioYN' id='radioYN' value='N' > 
			
			<tr><td height=5 colspan=6 class="label">&nbsp;</td></tr> 
	
	<!--Added by Thamizh selvi on 4th Nov 2016 against GHL-CRF-0412.2 Start-->
	<%if(isRestrictDischargeAdvice){%>
	<tr>
	<td class='label'><fmt:message key="eIP.RestrictDischargeAdviceForPendingReturns.label" bundle="${ip_labels}"/></td>
	<td class='fields'><input type='checkbox' name='chk_pen_ward_rtn_bfr_dis_adv' id='chk_pen_ward_rtn_bfr_dis_adv' value='<%=chk_pen_ward_rtn_bfr_dis_adv%>' <%=check_chk_pen_ward_rtn%> ></td>
	</tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<%}%>
	<!-- End-->

			

	<%/*below line Added for this CRF [JD-CRF-0006]*/%>	
	
	
<tr>
	<td height=5  class=label><fmt:message key="eIP.CheckForPendingOrdersBerforeDischarge.label" bundle="${ip_labels}" /> </td>
	<td height=5  class=fields>
	<input type='checkbox' size='8' maxlength='8'  name='chk_for_pen_orders_bfr_dis' id='chk_for_pen_orders_bfr_dis' value='Y' <%=chk_for_pen_orders_bfr_dis%> tabIndex='0' onclick='pendingDischarge()'></td>
	<td height=5 colspan=6 class=label><fmt:message key="eIP.IfOrdersArePending.label" bundle="${ip_labels}"  /> <input type='radio' id='notallow' name='dis_notallow' id='dis_notallow' value='N'  tabIndex='0' <%=dis_notallow_chk%> <%=dis_notallow_yn%> onclick='notAllowDischarge(this)' ><height=5 colspan=6 class=label><fmt:message key="eIP.Donotallowdischarge.label" bundle="${ip_labels}"  /><input type='radio' id='allowr' name='dis_allow' id='dis_allow' value='Y'  tabIndex='0' <%=dis_allow_chk%> <%=dis_allow_yn%> onclick='allowDischarge(this)'><height=5 colspan=6 class=label><fmt:message key="eIP.AllowDischarge.label" bundle="${ip_labels}"/></td>	
	</tr>	
	 <input type='hidden' name='pending_discharge' id='pending_discharge' value='N' > 
    <tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
<!--Added by Shanmukh on 22nd-MAY-2018 for ML-MMOH-CRF-1135 -->
<%if(isDisPatBTorderPendAppl){%>
<tr>
	<td height=5  class=label><fmt:message key="eIP.RestrictDischargePatientIfBTOrdersPending.label" bundle="${ip_labels}" /> </td>
	<td height=5  class=fields>
	<input type='checkbox' size='8' maxlength='8'  name='chk_dis_pat_BT_order_pend' id='chk_dis_pat_BT_order_pend' value='Y' <%if(("Y").equals(chk_dis_pat_BT_order_pend)){%>checked<%}%> /></td>		
</tr>	
<!-- END -->
	 
    <tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>	
<%}%>	
	
	<!--<tr>
	<td height=5  class='label'><fmt:message key="eIP.CheckForPendingOrdersBerforeDischarge.label" bundle="${ip_labels}" /> </td>
	<td height=5  class='fields'>
	<td class='fields'>
	<input type='checkbox' size='8' maxlength='8'  name='chk_for_pen_orders_bfr_dis' id='chk_for_pen_orders_bfr_dis' value='Y' tabIndex='0' onclick='pendingDischarge()'></td>
	<td height=5 colspan=6 class='fields'>&nbsp;</td>	
	</tr>
	<tr><td height=5 colspan=4 class=label>&nbsp;</td></tr> 
    <tr> <td height=5 colspan=2  class=label ><fmt:message key="eIP.IfOrdersArePending.label" bundle="${ip_labels}"  /> <input type='radio' id='notallow' name='dis_notallow' id='dis_notallow' value='N'  tabIndex='0' onclick='notAllowDischarge(this)' ><height=5 colspan=2 class=label><fmt:message key="eIP.Donotallowdischarge.label" bundle="${ip_labels}"  /><input type='radio' id='allowr' name='dis_allow' id='dis_allow' value='Y'  tabIndex='0'  onclick='allowDischarge(this)'><height=5 colspan=2 class=label><fmt:message key="eIP.AllowDischarge.label" bundle="${ip_labels}"/></td> <td height=5 colspan=2 class=label>&nbsp;</td>
	</tr> <input type='hidden' name='pending_discharge' id='pending_discharge' value='N' > 
    <tr><td height=5 colspan=4 class=label>&nbsp;</td></tr>	-->
	<%/*End CRF [JD-CRF-0006]*/%>		
	
	

	<tr>
	<script> 
</script>
		<!--2/3/2009 dropped  ext_interface_for_priviledge_yn from IP_PARAM -->
		<!--<td   class='label' align='right' width ='40%'><fmt:message key="Common.ExternalInterfaceforPrivilege.label" bundle="${common_labels}"/></td>
		<td   class='fields' align='left' width ='5%'><input type='checkbox' size='1' maxlength='1' name='ext_interface_for_priviledge_yn' id='ext_interface_for_priviledge_yn' value='Y'  <%--=external_interface_for_priviledge_yn--%> <%--=Disable_Enable_flg--%> tabIndex ='0'>
		</td>-->
	<td class='label'><fmt:message key="eIP.ReserveBedWhileTransfer.label" bundle="${ip_labels}"/></td>
	<td class='fields'><input type='checkbox' name='reserve_bed_on_tfr_yn' id='reserve_bed_on_tfr_yn' value='N' <%=Disable_Enable_flg%> <%=reserve_bed_on_tfr_yn%> onclick = 'checkMultiple();EnableResBedIntraward();'></td>
	
    <td class='label'><fmt:message key="eIP.AllowMultipleBedsForReserving.label" bundle="${ip_labels}"/></td>
	<td class='fields' colspan = "6"><input type='checkbox' name='allow_multiple_bed_for_resv_yn' id='allow_multiple_bed_for_resv_yn' value='N'  <%=allow_multiple_bed_for_resv_yn%> disabled ></td>
	</tr>
	<!-- Added by Darshini-->
<!-- Below line added for the CRF [GHL-CRF-0340] -->
<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
<tr>
<td class='label'><fmt:message key="eIP.RestrictReserveBedinIntraWardTrnsfr.label" bundle="${ip_labels}"/></td>
<td class='fields' colspan = "6"><input type='checkbox' name='res_reserve_bed_intraward_yn' id='res_reserve_bed_intraward_yn' value='N' <%=res_reserve_bed_intraward_yn%> <%=res_reserve_bed_intraward_disabled%> onclick='ChkReserveBedIntrawardYN();'></td>
<!--Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] -->
<%if(isRestrictDisAdvSaleRetPend){%>
<td class='label'><fmt:message key="eIP.RestrictDischargeAdviceIfSaleReturnPending.label" bundle="${ip_labels}"/></td>
<td class='fields'><input type='checkbox' name='chk_pen_sale_rtn_bfr_dis_adv' id='chk_pen_sale_rtn_bfr_dis_adv' value='Y' <%=dis_chk_pen_sale_rtn_bfr_dis_adv%> ></td>
<%} else if(isModifyDiscTypeStatusAppl){%>
<td class='label'><fmt:message key="eIP.AllowUserToModifyDischargeTypeStatus.label" bundle="${ip_labels}"/></td> <!-- added by mujafar for ML-MMOH-CRF-0659 -->
<td class='fields'><input type='checkbox' name='allow_user_modify_disc_type_status_yn' id='allow_user_modify_disc_type_status_yn' value='N' <%=allow_user_modify_disc_type_status_yn%>  onclick='ChkModifyDiscTypeStatus();'></td>
<%}%>



</tr>
<!--End-->
<tr>
    <tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<tr>
    <td class='label'><fmt:message key="eAM.ChangeAdmDtls.label" bundle="${am_labels}"/></td>
	<td   class='fields' align='left' >&nbsp;<input type='text' name='change_admi' id='change_admi' size='2' maxlength='2' value="<%=change_admission_dtls%>" onKeyPress='return(ChkNumberInput(this,event,0))' >&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/><img src='../../eMP/images/mandatory.gif'align='center'></img></td>
   <td class='label'><fmt:message key="eIP.InvokeDthReginDisAdv.label" bundle="${ip_labels}"/></td>
   <td class='fields' colspan = "6"><input type='checkbox' name='Allow_Invoke_Maintn_Dth_Reg_YN' id='Allow_Invoke_Maintn_Dth_Reg_YN' value='N' <%=Allow_Invoke_Maintn_Dth_Reg_YN%> onclick="mandatoryDeathCheck();">
   <!--Below line added for this CRF ML-MMOH-CRF-0688-->
   <input type='radio' id='inv_deathreg_mandatory' name='inv_deathreg_mandatory_y' id='inv_deathreg_mandatory_y' value='Y' tabIndex='0' <%=death_reg_mandatory_flag%> <%=death_reg_mandatory_yn_1%> onclick='invdeath_mandatory_radio()' >
			<fmt:message key="eIP.Mandatory.label" bundle="${ip_labels}"  />
			<input type='radio' id='inv_deathreg_notmandatory' name='inv_deathreg_mandatory_n' id='inv_deathreg_mandatory_n' value='N'  tabIndex='0' <%=death_reg_non_mandatory_flag%> <%=death_reg_mandatory_yn_2%> onclick='invdeath_nonmandatory_radio()'>
			<fmt:message key="eIP.NotMandatory.label" bundle="${ip_labels}"/>	 
		 <input type='hidden' name='invdeathregmandatoryYN' id='invdeathregmandatoryYN' value='N' >
   
   <!--End ML-MMOH-CRF-0688-->    
   </td>
	</tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<% /*Added by Senthil on 12-Dec-2011 for this CRF [KDAH-CRF-0035] */%>
	<tr>
	<td class='label'><fmt:message key="Common.admission.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="eIP.ConsentText.label" bundle="${ip_labels}"/>&nbsp;<input type="button" class = 'BUTTON' onclick="ConsentText()" value="C"></td>
	<td>
	<input type="hidden" name="consent_text_details" id="consent_text_details" value="<%=consenttxtdtls%>"></td>
<!-- Added by Shanthi-->
	<td class='label'><fmt:message key="eIP.AllowReasonForLateDischarge.label" bundle="${ip_labels}"/></td>
	<!-- <input type='checkbox' size='8' maxlength='8'  name='chk_for_pen_orders_bfr_dis_adv' id='chk_for_pen_orders_bfr_dis_adv' value='Y' <%=chk_for_pen_orders_bfr_dis_adv%>  tabIndex='0' onclick='dischargeAdvice()'  ></td> -->						
    <td class='fields' colspan = "6">
	<input type='checkbox' name="allow_reason_for_late_discharge" id="allow_reason_for_late_discharge" value='N' <%=reason_for_late_discharge%> tabIndex='0' onclick='mandatoryDischargeReason();' > 

	
			<input type='radio' id='reason_mandatory' name='mandatory_option_y' id='mandatory_option_y' value='Y'      tabIndex='0' <%=mandatory_flag%> <%=radio_check_mandatory_yn_1%> onclick='mandatory_radio_1()' >
			<fmt:message key="eIP.Mandatory.label" bundle="${ip_labels}"  />
			<input type='radio' id='reason_not_mandatory' name='mandatory_option_n' id='mandatory_option_n' value='N'  tabIndex='0' <%=non_mandatory_flag%> <%=radio_check_mandatory_yn_2%> onclick='mandatory_radio_2()'>
			<fmt:message key="eIP.NotMandatory.label" bundle="${ip_labels}"/>
	 
		 <input type='hidden' name='mandatoryYN' id='mandatoryYN' value='N' >

		 </td>
		</tr>
		<!-- Added for the CRF - HSA-CRF-0035 -- Begin -->
		<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
		<tr>
		<td class='label'><fmt:message key="eIP.TransferWODelink.label" bundle="${ip_labels}"/>&nbsp;</td>
		<td class='fields'><input type='checkbox' name='transfer_wo_delink_yn' id='transfer_wo_delink_yn' value='<%=transfer_wo_delink_yn%>' <%=transfer_wo_delink_checked%> onclick='setVal(this)'></td>
		<!-- Added for MMS-QH-CRF-0144 -->
		<td class='label'><fmt:message key="eIP.ReasonForAdmMandatory.label" bundle="${ip_labels}"/>&nbsp;</td>
		<td class='fields' colspan = "6"><input type='checkbox' name='reason_for_adm_reqd_yn' id='reason_for_adm_reqd_yn' value='<%=reason_for_adm_reqd_yn %>' <%=reason_for_adm_reqd_checked%> onclick='setVal(this)'></td>
		
		<% if(SiteSpecific_pre_disch_appl){%>
			<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
			<tr>
			<td class='label'><fmt:message key="eIP.PreDischargeApplicable.label" bundle="${ip_labels}"/>&nbsp;</td>
			<td class='fields'><input type='checkbox' name='pre_disch_appl_yn' id='pre_disch_appl_yn' value='<%=pre_disch_appl_yn %>' <%=pre_disch_appl_checked %> onclick='setVal(this)'></td>
			</tr>
		<%}%>
		</tr>
		<!-- Added for the CRF - HSA-CRF-0035 -- End -->
	
	<!-- for CRF "MZ-CRF-0017-IP"  by sathish on Wednesday, March 03, 2010 starts here -->
	<!--tr>
	<td class='label'><fmt:message key="eIP.BedMandForAdmn.label" bundle="${ip_labels}"/></td>
	<td class='fields'><input type='checkbox' name='BED_MANDATORY_FOR_ADMN_YN' id='BED_MANDATORY_FOR_ADMN_YN' value='N' <%=BED_MANDATORY_FOR_ADMN_YN%>>
	</tr>
	
	<tr><td height=5 colspan=4 class=label>&nbsp;</td></tr-->
	<!-- Ends here -->

	
  <%
		/*
		if(CANCEL_DISCHARGE_APPL_YN.equals("Y"))
		{
			CANCEL_DISCHARGE_APPL_YN = "checked";
		}
		else 
		{
			CANCEL_DISCHARGE_APPL_YN = "unchecked";
		}*/
%>
<!-- 	<tr>
		<td  class='label' align ='right' width="20%" ><fmt:message key="eIP.CancelDischargeApplicable.label" bundle="${ip_labels}"/></td>
		<td class='fields' align ='left' width="15%" ><input type='checkbox' size='8' maxlength='8' name='CANCEL_DISCHARGE_APPL_YN' id='CANCEL_DISCHARGE_APPL_YN' onclick="setVal(this);" value='N'  ></td>
		<td  class=label>&nbsp;</td>
		<td  class=label>&nbsp;</td>
	</tr> -->
	<!-- Added by Dharma on Oct 17th against HSA-CRF-0181 [IN:049541] Start -->
	<tr>
		<td height=5 colspan=6 class=label>&nbsp;</td>
	</tr>
	<tr>
		<td class='label'><fmt:message key="eIP.WeightOnAdmission.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=6>
			<select name='weight_on_admn_mandatory' id='weight_on_admn_mandatory'>
           		 <option value='' >---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
           		 <option value='A' <%if(weight_on_admn_mandatory.equals("A")){%>selected<%} %> ><fmt:message key="eIP.assignbedmarkpatientarrival.label" bundle="${ip_labels}"/></option>
           		 <option value='P' <%if(weight_on_admn_mandatory.equals("P")){%>selected<%} %>><fmt:message key="eIP.PrepareDischargeAdvice.label" bundle="${ip_labels}"/></option>
           		 <option value='D' <%if(weight_on_admn_mandatory.equals("D")){%>selected<%} %>><fmt:message key="Common.DischargePatient.label" bundle="${common_labels}"/></option>
			</select>
		</td>

		<!--Added by Thamizh selvi on 8th May 2017 against ML-MMOH-CRF-0617 Start-->
		<%if(isCnrmReqPatOutChngAppl){%>
		<td class='label'><fmt:message key="eIP.AutoCnrmTfrReq.label" bundle="${ip_labels}"/></td>
		<td class='fields'><input type='checkbox' name='autoCnrmTfrReq' id='autoCnrmTfrReq' value='<%=autoCnrmTfrReq%>' <%=chkAutoCnrmTfrReq%> ></td>
		<%}%>
		<!-- End-->

	</tr>
	<!-- Added by Dharma on Oct 17th against HSA-CRF-0181 [IN:049541] End-->
	<!--Added by Thamizh selvi on 10th Nov 2017 against ML-MMOH-CRF-0866 Start-->
	<tr>
		<td height=5 colspan=6 class=label>&nbsp;</td>
	</tr>
	<%if(isHeightAndBmiEnable){%>
	<tr>
		<td class='label'><fmt:message key="eIP.HeightOnAdmission.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan=6>
			<select name='height_on_admn_mandatory' id='height_on_admn_mandatory'>
           		 <option value='' >---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
           		 <option value='A' <%if(height_on_admn_mandatory.equals("A")){%>selected<%} %> ><fmt:message key="eIP.assignbedmarkpatientarrival.label" bundle="${ip_labels}"/></option>
           		 <option value='P' <%if(height_on_admn_mandatory.equals("P")){%>selected<%} %>><fmt:message key="eIP.PrepareDischargeAdvice.label" bundle="${ip_labels}"/></option>
           		 <option value='D' <%if(height_on_admn_mandatory.equals("D")){%>selected<%} %>><fmt:message key="Common.DischargePatient.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		
		
		<td class='label'><fmt:message key="eIP.EnableHeightandBmiforPatienClass.label" bundle="${ip_labels}"/>&nbsp;</td>
		<td class='fields' colspan=6>
			<select name='enable_height_bmi_pat_cls' id='enable_height_bmi_pat_cls'>
           		 <option value='' >---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
           		 <option value='DC' <%if(enable_height_bmi_pat_cls.equals("DC")){%>selected<%} %> ><fmt:message key="Common.daycare.label" bundle="${ip_labels}"/></option>
           		 <option value='IP' <%if(enable_height_bmi_pat_cls.equals("IP")){%>selected<%} %>><fmt:message key="Common.inpatient.label" bundle="${ip_labels}"/></option>
           		 <option value='ID' <%if(enable_height_bmi_pat_cls.equals("ID")){%>selected<%} %>><fmt:message key="eIP.DaycareandInpatient.label" bundle="${common_labels}"/></option>
			</select>
		</td>
		<%}%>
		</tr>
		
		<tr>
		<td height=5 colspan=6 class=label>&nbsp;</td>
	</tr>
		
	<tr>
			<td class='label' colspan=3><fmt:message key="eIP.DispBedClsChangeRec.label" bundle="${ip_labels}"/></td>
			<td class='fields' colspan=6><input type='checkbox' name='dispBedClsChange' id='dispBedClsChange' value='<%=dispBedClsChange%>' <%=chkDispBedClsChange%> ></td>
	</tr>
	<tr>
		<td height=5 colspan=6 class=label>&nbsp;</td>
	</tr>
	
	<tr>
	<%if(isNewBornChngsAppl){%>
			<td class='label' ><fmt:message key="eIP.RestrictTransferForUnfinalizedNewbornRecords.label" bundle="${ip_labels}"/></td>
			<td class='fields'><input type='checkbox' name='trans_yn_unfnzed_newborn' id='trans_yn_unfnzed_newborn' value='Y' <%if(("Y").equals(trans_yn_unfnzed_newborn)){%>checked<%}%> /></td>
		<%}%>
	<%if(isAdmissionTypeAppl){%>	
		<!--Added by shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618-->
	<td class='label' ><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/></td>
	<td class='label' ><select name='admission_type' id='admission_type'>
           		 <option value='' >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
           		 <%
			StringBuffer sqlAdmType = new StringBuffer();
			sqlAdmType.append("select admission_type_code,short_desc from ip_admission_type where eff_Status ='E' order by short_desc");	
			stmt	= con.createStatement();
			rset = stmt.executeQuery(sqlAdmType.toString());	
			while(rset!=null && rset.next())
				{	
					if(admission_type.equals(rset.getString(1)))
					out.println("<option selected value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
					else
					out.println("<option  value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
				}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		%>
			</select></td>
	<%}%>	
	</tr>
	
	
	<!-- Added by Mujafar  for ML-MMOH-CRF-1427 start -->
		
		<%
		if(isPatientEncRevokeDeathAppl)
		{ // Added by mujafar for ML-MMOH-CRF-1427
		%>
		<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
		<tr>
		
			<td  class='label'  ><fmt:message key="eOP.DispTypeFOrOPEncounterRevokeDeath.label" bundle="${op_labels}"/>
                                    </td>
                                    <td class='fields'   ><select name='DISP_TYPE_FOR_REVOKE_DEATH' id='DISP_TYPE_FOR_REVOKE_DEATH' >
                                            <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
										<%
						                try{ 	
						
										  String sql1="select DISCHARGE_TYPE_CODE, short_desc from ip_discharge_type_vw where eff_status='E'   and DECEASED_YN = 'N' order by 2";
										  String selval= "";

										 stmt=con.createStatement();
										 rset=stmt.executeQuery(sql1);
										 if(rset!=null) {
										 String id1="";
										 String val1="";
										 
										 while(rset.next()) {
											 id1=rset.getString("DISCHARGE_TYPE_CODE");
											 val1=rset.getString("short_desc");
											 if(id1.equals(dispTypeForRevokeDeath))
											   selval="selected";
											 
											 out.print("<option value='"+id1+"' "+selval+">"+val1+"</option>");
											 selval="";
										 }
										 }
										 }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
										 finally
										 {
											 if (stmt != null) stmt.close();
											 if (rset != null) rset.close();
										 }
				           %>
							</select>
							</td>
		
		
		</tr>
		<%}%>
		
		
		<!-- Added by Mujafar  for ML-MMOH-CRF-1427 end  -->
	
	

	<!--Added by Ashwini on 06-Mar-2019 for MO-CRF-20148-->
	<%if(isNationalIdValidationAppl){%>
	<tr>
		  <td class='label' nowrap><fmt:message key="eIP.ValidateNatIDDurIPAdmsn.label" bundle="${ip_labels}"/></td>
		  <td class='fields' nowrap><input type='checkbox' name='validate_natid_IP_admsn' id='validate_natid_IP_admsn' value='<%=validate_natid_IP_admsn%>' <%=validate_natid_chk%>></td>
	</tr>
	<%}%>
	<!--End MO-CRF-20148-->
	<tr>
	<td class='label' nowrap><fmt:message key="eIP.RestrictIfOTRecordsPending.label" bundle="${ip_labels}"/></td>
	<td class='label' colspan=1>
		<table>
			<tr>
				<td class='label' nowrap><fmt:message key="eIP.PrepareDischargeAdvice.label" bundle="${ip_labels}"/><input type="checkbox" name="dis_adv_ot_pend_ord_yn" id="dis_adv_ot_pend_ord_yn" value="Y" <%if(dis_adv_ot_pend_ord_yn.equals("Y")){%>checked<%}%> /><td>
				<td class='label' nowrap><fmt:message key="Common.Discharge.label" bundle="${common_labels}"/> <input type="checkbox" name="dis_ot_pend_ord_yn" id="dis_ot_pend_ord_yn" value="Y" <%if(dis_ot_pend_ord_yn.equals("Y")){%>checked<%}%>/><td>
				
			</tr>
		</table>
	</td>
	<td   class='label' align='left' ><fmt:message key="eIP.Allowgatepassinpredisadvice.label" bundle="${ip_labels}"/></td> <!--  added by mujafar for MO-CRF-20157 -->

<td   class='fields' colspan = "6" align='left' ><input type='checkbox' size='8' maxlength='8'  name='ALLOW_GATE_PASS_PRE_DIS_ADV_YN' id='ALLOW_GATE_PASS_PRE_DIS_ADV_YN' value='Y' <%=ALLOW_GATE_PASS_PRE_DIS_ADV_YN%>  ></td>
	</tr>
	<tr>

		<td height=5 colspan=6 class=label>&nbsp;</td>
	</tr>
	<!-- ADDED BY SUJI KEERTHI ON 24-MAR-2020 FOR MOHE-CRF-0014 -->
	<tr>
		  <td class='label' nowrap><fmt:message key="eIP.EnableDischargeDiagInPrepareDischargeAdvice.label" bundle="${ip_labels}"/></td>
		  <td class='fields' colspan = "6" nowrap><input type='checkbox' name='enable_disch_diagnosis_yn' id='enable_disch_diagnosis_yn' value='<%=enable_disch_diagnosis_yn%>' <%=enable_disch_chk%>></td>
	</tr>
	<!-- END MOHE-CRF-0014 -->
	<!--End-->
</table>
<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%' align='center'>  
<th colspan='12' align='left'><fmt:message key="eIP.BedBlocking.label" bundle="${ip_labels}"/></th>

<%	
/*if(bed_block_period_normal.equals("")||bed_block_period_normal.equals(null)||bed_block_period_normal.equals("0"))
		{	
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/
%>

	<tr>
		<td   class='label' align='left' ><fmt:message key="eIP.DefaultPeriodforNormal.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left' >&nbsp;<input type='text' name='bed_block_period_normal' id='bed_block_period_normal' size='3' maxlength='3' value="<%=bed_block_period_normal%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);checkNormalMax2(this);CheckZeroVal(this);">&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/><img src='../../eMP/images/mandatory.gif'align='center'></img></td>


<%
/*if((bed_block_period_max.equals(null)||bed_block_period_max.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>
		<td   class='label' align='left' > <fmt:message key="eIP.MaxAllowablePeriodforNormal.label" bundle="${ip_labels}"/>
		</td>
        <td class='fields' colspan = "6">&nbsp;<input type='text'align="left"  name='bed_block_period_max' id='bed_block_period_max'  size='3' maxlength='3' value="<%=bed_block_period_max%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this);checkNormalMax(this);CheckZeroVal(this);'>
                <% 
					String bed_block_period_max_type_hours = "";
					String bed_block_period_max_type_days  = "" ;
					if(bed_block_period_max_type.equalsIgnoreCase("H"))
							bed_block_period_max_type_hours = "selected";
					else
							bed_block_period_max_type_days = "selected";
                %>
               &nbsp;<select name="bed_block_period_max_type" id="bed_block_period_max_type" onchange="checkNormalMax1()" <%=Disable_Enable_flg%>>
                        <option value='H' <%=bed_block_period_max_type_hours%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
                        <option value='D' <%=bed_block_period_max_type_days%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
               </select><img src='../../eMP/images/mandatory.gif'align='center'></img>&nbsp;&nbsp;
        </td>		
	</tr>
	<tr><td height=5 colspan=12 class=label>&nbsp;</td></tr>

<%
/*if((bed_block_period_dis.equals(null)||bed_block_period_dis.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>

<tr>
		<td   class='label' align='left'  ><fmt:message key="eIP.MaxAllowablePeriodforDischarge.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left'  >&nbsp;<input type='text' size='3' name='bed_block_period_dis' id='bed_block_period_dis'  maxlength='3' <%=Readonly_flg%> value="<%=bed_block_period_dis%>" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);CheckZeroVal(this);">&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/><img src='../../eMP/images/mandatory.gif'align='center'></img></td> 	

<%
/*if((strTransfer_Out.equals(null)||strTransfer_Out.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>
		<td   class='label' align='left' nowrap><fmt:message key="eIP.MaxAllowablePeriodforTransferOut.label" bundle="${ip_labels}"/></td>
		<td  class='fields' colspan = "6" align='left'>&nbsp;<input type='text' size='3' name='transfer_out' id='transfer_out'  value="<%=strTransfer_Out%>" <%=Readonly_flg%> maxlength='3'  onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);" >&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>
</tr>
		<!-- ----- Added by Sridhar on 12th feb 2004 ------- -->
		<!-- ------------ PRIORITY START --------- -->
		<%/*
			String Priority2_date_chk_days_type_hours="";
			String Priority2_date_chk_days_type_days="";
			if(dflt_unit_priority_2.equalsIgnoreCase("H")) 
				Priority2_date_chk_days_type_hours ="selected";
			else 
				Priority2_date_chk_days_type_days="selected" ;
		
			String Priority3_date_chk_days_type_hours="";
			String Priority3_date_chk_days_type_days="";
			if(dflt_unit_priority_3.equalsIgnoreCase("H")) 
				Priority3_date_chk_days_type_hours ="selected";
			else 
				Priority3_date_chk_days_type_days="selected" ;
		*/%>

	
		<td class='BLANKROW1PT' colspan='8'>&nbsp;</td>
	</tr>	

<%
/*if((dflt_bed_blocking_period.equals(null)||dflt_bed_blocking_period.equals("")||dflt_bed_blocking_period.equals("0")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>

<tr>
	<td class='label' align='left' colspan=3><fmt:message key="eIP.DefaultBedBlockingPeriodonTransferDischargeofInfectiousDiseasePatients.label" bundle="${ip_labels}"/></td>
	<td   class='fields' align='left'  colspan=6>&nbsp;<input type='text' size='3' name='dflt_bed_blocking_period' id='dflt_bed_blocking_period'  value="<%=dflt_bed_blocking_period%>" <%=Readonly_flg%> maxlength='3' onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="setfcs();CheckNum(this);checkNormalMax(this); " >&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>       
</tr>
<tr>
	<td   class='BLANKROW1PT'  colspan='12' >&nbsp;<input type='hidden' name='mode' id='mode' value="<%=mode%>" > <input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" ></td>
</tr>	

</table>
	</div>

<div id = 'ADDITIONAL' style = 'display:none'>
<!-- <a name='inpat_act_tab_vw'></a>
 -->	
 <ul id="tablist" class="tablist" style="padding-left:0px">
		<li class="tablistitem" title="ADT">
			<a class="tabA" id="outpat_act_tab"><span class="tabAspan" id="outpat_act_tab_span" onClick='javascript:expandCollapse("adt")'>ADT</span>
			</a>
			</li>
		<li class="tablistitem" title="Additional">
			<a class="tabClicked" id="inpat_act_tab"><span class="tabSpanclicked" id="inpat_act_tab_span" onClick='javascript:expandCollapse("additional")'><fmt:message key="Common.Additional.label" bundle="${common_labels}"/></span>
			</a>
		</li>
	</ul>
<table name='tab_table' id='tab_table' cellspacing='0' cellpadding='0' border='0' width='100%' align='center'>
	<th colspan='6' align='left'><fmt:message key="eIP.LodgerAccompanyingPersonReference.label" bundle="${ip_labels}"/></th>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
<%
/*if(lodger_next_srl_no==null||lodger_next_srl_no.equals("0")||lodger_next_srl_no.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>
	<input type='hidden' name='mode' id='mode' value="<%=mode%>" > 
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>" >
	<tr>
		<td   class='label' align='left' ><fmt:message key="Common.nextsrlno.label" bundle="${common_labels}"/></td>
		<td   class='fields' align='left'  >&nbsp;<input type='text' size='8' maxlength='8' name='lodger_next_srl_no' id='lodger_next_srl_no' value="<%=lodger_next_srl_no%>" <%=Readonly_flg%> onBlur= 'CheckNum(this);validateSrlNo(this);CheckZeroVal(this);' onKeyPress='return(ChkNumberInput(this,event,0))' tabIndex='0'><img src='../../eMP/images/mandatory.gif'align='center'></img><input type='hidden' name = 'Foff' ></td>

<%
/*if(lodger_max_srl_no==null||lodger_max_srl_no.equals("0")||lodger_max_srl_no.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>

		<td   class='label' align='left' ><fmt:message key="Common.maxserialno.label" bundle="${common_labels}"/></td>
		<td   class='fields' align='left' >&nbsp;<input type='text' size='8' maxlength='8' name='lodger_max_srl_no' id='lodger_max_srl_no' value="<%=lodger_max_srl_no%>" <%=Readonly_flg%> onBlur="CheckNum(this);validateSrlNo(this);CheckZeroVal(this);" onKeyPress='return(ChkNumberInput(this,event,0))' tabIndex='0' ><img src='../../eMP/images/mandatory.gif'align='center'></img>
		</td>
		</tr>
			<tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
</tr>

<%
	/*	if(max_stay_of_lodger_after_disc.equals("")||max_stay_of_lodger_after_disc.equals(null))
		{
			Disable_Enable_flg	="";
			Readonly_flg		="";
		}
		else
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg		="Readonly";
		}
	*/
%>
		<tr>
		<td   class='label' align='left' ><fmt:message key="eIP.MaxAllowedPeriodofStayforLodgerAccompanyingPerson.label" bundle="${ip_labels}"/>&nbsp;</td>
		<td   class='fields' align='left'  >&nbsp;<input type='text' size='3' maxlength='3' name='max_stay_of_lodger_after_disc' id='max_stay_of_lodger_after_disc'  value="<%=max_stay_of_lodger_after_disc%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNum(this);">&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>
		<%
		/*		
			if(DFLT_GATE.equals("")||DFLT_GATE.equals(null))
			{
				Disable_Enable_flg	="";
				Readonly_flg	="";
			}
			else
			{
				Disable_Enable_flg	="Disabled";
				Readonly_flg	="Readonly";
			}
		*/
		%>				
				<td   class='label' align='left' ><fmt:message key="eIP.AllowablePeriodforIssue.label" bundle="${ip_labels}"/>/<fmt:message key="eIP.RenewalOfGatePass.label" bundle="${ip_labels}"/></td>
				<td class='fields' >&nbsp;<input type='text'align="left"  name='allwbl_pd_rnw_gtpass' id='allwbl_pd_rnw_gtpass'  size='3' maxlength='3' value="<%=DFLT_GATE%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))' onBlur='CheckNum(this);'>
                <% 
					String allow_prd_renew_hours = "";
					String allow_prd_renew_days  = "" ;
					
					if(bed_block_period_max_type1.equalsIgnoreCase("H"))
							allow_prd_renew_hours = "selected";
					else
							allow_prd_renew_days = "selected";
                %>
            &nbsp;<select name="bed_block_period_max_type1" id="bed_block_period_max_type1" <%=Disable_Enable_flg%>>
                        <option value='H' <%=allow_prd_renew_hours%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option>
                        <option value='D' <%=allow_prd_renew_days%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
                </select>
		</td>
				</tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
<%
/*if(MAX_ALLOWED_ACCOM_PERS==null||MAX_ALLOWED_ACCOM_PERS.equals("0")||MAX_ALLOWED_ACCOM_PERS.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>
<tr>
		<td   class='label' align='left' ><fmt:message key="eIP.MaxAllowedAccompanyingPersons.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left' >&nbsp;<input type='text' size='2' maxlength='2' name='MAX_ALLOWED_ACCOM_PERS' id='MAX_ALLOWED_ACCOM_PERS' value="<%=MAX_ALLOWED_ACCOM_PERS%>" <%=Readonly_flg%> onBlur="CheckNum(this);" onKeyPress='return(ChkNumberInput(this,event,0))' tabIndex='0' >
		</td>	

	<%
	/*if(CHK_IN_LODGER_MAX_PERIOD==null||CHK_IN_LODGER_MAX_PERIOD.equals("0")||CHK_IN_LODGER_MAX_PERIOD.equals(""))
		{
			Disable_Enable_flg	="";
			Readonly_flg		="";
		}
		else
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg		="Readonly";
		}*/
	%>			
		<td   class='label' align='left' ><fmt:message key="eIP.MaxPeriodafterDischargeforCheckinLodger.label" bundle="${ip_labels}"/>&nbsp;</td>
		<td   class='fields' align='left'  >&nbsp;<input type='text'align="left"  name='chk_in_lodger_max_period' id='chk_in_lodger_max_period'  size='3' maxlength='3' value="<%=CHK_IN_LODGER_MAX_PERIOD%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))'  onBlur='CheckNum(this);'>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>
	</tr>
<tr>
<td colspan=6 class=label>&nbsp;</td>
</tr>

<%
		if(allow_release_bed_on_lv.equals("Y"))
		{	
			allow_release_bed_on_lv = "checked";
		}

		/*if(allow_release_bed_on_lv == null||allow_release_bed_on_lv.equals(""))
		{	
			allow_release_bed_on_lv = "";
			Disable_Enable_flg	="";
			Readonly_flg		="";
		}
		else
		if(allow_release_bed_on_lv.equals("Y"))
		{	
			allow_release_bed_on_lv = "checked";
			Disable_Enable_flg	="Disabled";
			Readonly_flg		="Readonly";
		}else
			if(allow_release_bed_on_lv.equals("N"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg		="Readonly";
		}*/

/*		out.println("Disable_Enable_flg"+Disable_Enable_flg);
		allow_release_bed_on_lv = allow_release_bed_on_lv.equals("Y") ?"checked" :"" ;
if(allow_release_bed_on_lv.equals("")||allow_release_bed_on_lv==null)
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	if(allow_release_bed_on_lv.equals("checked"))
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

%>

	<tr>
	<th colspan='6' align='left'><fmt:message key="Common.Leave.label" bundle="${common_labels}"/> </th>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<tr>
		<td   class='label' align='left' ><fmt:message key="eIP.ReleaseBedonLeave.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left' ><input type='checkbox' size='8' maxlength='8' name='allow_release_bed_on_lv' id='allow_release_bed_on_lv' <%=Disable_flg%> value='Y' <%=allow_release_bed_on_lv%> tabIndex='0'>
		</td>

<%
/*if((max_allowed_lv_period.equals(null)||max_allowed_lv_period.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>
		<td   class='label' align='left' ><fmt:message key="eIP.MaxAllowableLeavePeriod.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left' >&nbsp;<input type='text' size='3' maxlength='3' name='max_allowed_lv_period' id='max_allowed_lv_period' onBlur="CheckNum(this)" value="<%=max_allowed_lv_period%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))' tabIndex='0'>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>&nbsp;
		</td>
</tr>	
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<tr>
	<%
		stmt_pt_leave =con.createStatement();
		StringBuffer sql_pt_leave = new StringBuffer();
		sql_pt_leave.append(" SELECT short_desc,patient_type FROM am_patient_type WHERE eff_status='E' ORDER BY 1");
		rset_pt_leave = stmt_pt_leave.executeQuery(sql_pt_leave.toString());
	%>

   <%      
	if(rset_pt_leave != null)
	{
			while(rset_pt_leave.next())
			{
					if(pat_type_override_leave_period.equalsIgnoreCase(rset_pt_leave.getString(2)))
					{
	%>
	<%
					}
					else
					{
	%>
	<%
					}
			}
	if(rset_pt_leave != null)rset_pt_leave.close();
	if(stmt_pt_leave != null)stmt_pt_leave.close();
	}
			%>

	<%
	/*if((max_allowed_lv_cancel_period.equals(null)||max_allowed_lv_cancel_period.equals("")))
		{
			Disable_Enable_flg	="";
			Readonly_flg		="";
		}
		else
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg		="Readonly";
		}*/
	%>

		<td    class='label' align='left' ><fmt:message key="eIP.AllowLeaveCancellationWithin.label" bundle="${ip_labels}"/>&nbsp;</td>
		<td   class='fields' align='left' colspan='6'>&nbsp;<input type='text' size='3' maxlength='3' name='max_allowed_lv_cancel_period' id='max_allowed_lv_cancel_period' onBlur="CheckNum(this)"  value="<%=max_allowed_lv_cancel_period%>" <%=Readonly_flg%> onKeyPress='return(ChkNumberInput(this,event,0))' tabIndex='0' >&nbsp;<fmt:message key="Common.Minute.label" bundle="${common_labels}"/></td>
			</tr>
				
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>

<%
/*if(ABSCOND_GRACE_PERIOD.equals(null)||ABSCOND_GRACE_PERIOD.equals("0")||ABSCOND_GRACE_PERIOD.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>

<tr>
		<td   class='label' align='left' ><fmt:message key="eIP.GraceperiodforAbscondPatient.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left'  >&nbsp;<input type='text' size='2' maxlength='2' name='ABSCOND_GRACE_PERIOD' id='ABSCOND_GRACE_PERIOD' value="<%=ABSCOND_GRACE_PERIOD%>" <%=Readonly_flg%> onBlur= 'CheckNum(this);' onKeyPress='return(ChkNumberInput(this,event,0))' tabIndex='0'>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>

<%
/*if(NO_SHOW_GRACE_PERIOD.equals(null)||NO_SHOW_GRACE_PERIOD.equals("0")||NO_SHOW_GRACE_PERIOD.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/
%>
		<td   class='label' align='left' ><fmt:message key="eIP.GraceperiodforNoShow.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left' >&nbsp;<input type='text' size='2' maxlength='2' name='NO_SHOW_GRACE_PERIOD' id='NO_SHOW_GRACE_PERIOD' value="<%=NO_SHOW_GRACE_PERIOD%>" <%=Readonly_flg%> onBlur="CheckNum(this);" onKeyPress='return(ChkNumberInput(this,event,0))' tabIndex='0' >&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
		</td>
		</tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<tr>
	
	<%
		if (warn_or_error_max_leave.equals("W"))
		{
			action_warning_yn="checked";
			action_error_yn="";
			//Disable_Enable_flg	="Disabled";
			//Readonly_flg		="Readonly";
		}
		else if (warn_or_error_max_leave.equals("E"))
		{
			action_warning_yn="";
			action_error_yn="checked";
			//Disable_Enable_flg	="Disabled";
			//Readonly_flg		="Readonly";
		}
		else if (warn_or_error_max_leave.equals("")||warn_or_error_max_leave.equals(""))
		{
			action_warning_yn	="checked";	
			//Disable_Enable_flg	="";
			//Readonly_flg		="";
		}

	/*if((warn_or_error_max_leave.equals(null)||warn_or_error_max_leave.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

	%>
		<td   class='label' align='left' ><fmt:message key="eIP.ActiononExceedingMaxLeave.label" bundle="${ip_labels}"/></td>
		<td   class='fields' align='left'  colspan='6'><input type='radio' name='warn_or_error_max_leave' id='warn_or_error_max_leave' value='W'  tabIndex='0' <%=action_warning_yn%> <%=Disable_flg%> >&nbsp;<fmt:message key="Common.Warning.label" bundle="${common_labels}"/>&nbsp;<input type='radio' name='warn_or_error_max_leave' id='warn_or_error_max_leave' value='E' tabIndex='0' <%=action_error_yn%>  <%=Disable_flg%> >&nbsp;<fmt:message key="Common.Error.label" bundle="${common_labels}"/></td>
	</tr>

<!-- <%
if(action_warning_yn.equals("checked"))
		{
	%>
		<script>document.ipparam_form.warn_or_error_max_leave[0].disabled = true;</script>
	<%
		}
	else
		if(action_error_yn.equals("checked"))
		{
	%>
	<script>document.ipparam_form.warn_or_error_max_leave[1].disabled = true;</script>
	<%
		}
	%> -->


</table>
	<% 
	if(bl_operational.equals("Y"))
	{ %>

<%
	/*if(bl_interfaced_yn.equals("")||bl_interfaced_yn.equals(null))
		{
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
			if(PAT_CHECK_IN_ALLOWED_YN.equals("checked"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/
%>
	<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
	<tr><th colspan='6' align='left'><fmt:message key="Common.Billing.label" bundle="${common_labels}"/></th><tr>
	<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	<td   class='label' align='left' width ='42%'><fmt:message key="Common.InterfacetoBillingModule.label" bundle="${common_labels}"/></td>
	<td   class='fields' align='left' width ='5%'><input type='checkbox' size='1' maxlength='1' name='bl_interfaced_yn' id='bl_interfaced_yn' value='Y' <%=Disable_Enable_flg%> <%=bl_interfaced_yn%>  <%=bl_fields%> tabIndex ='0'>
		</td>
		<td   class='label' align='right' width ='45%'>&nbsp;</td>
		<td   class='label' align='left' width ='7%'>&nbsp;</td>
	</tr>
	</tr>

<%}%>
			<input type='hidden' name=install_yn  value="<%=bl_operational%>"><input type='hidden' name="lodger_next_srl_no_db" id="lodger_next_srl_no_db"  value="<%=lodger_next_srl_no%>">
<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	</table>
	<!-- SCR 4020 FDPMG20089CRF0119IP -->

		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
		
		<tr><th colspan='6' align='left'><fmt:message key="eIP.BedAvailabilityChart.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.setup.label" bundle="${common_labels}"/></th><tr>
		
		<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>

		<tr>
			<td   class='label' align='left' width = '42%'><fmt:message key="eIP.AllowBookingoccupiedbedswithoutEDD.label" bundle="${ip_labels}"/></td>
			<td   class='fields' align='left' width = '10%'><input type='checkbox' size='8' maxlength='8' name='allow_booking_without_edd_yn' id='allow_booking_without_edd_yn' value='N' <%=allow_booking_without_edd_yn%>></td>
			<td   class='label' align='left' width = '35%'><fmt:message key="eIP.AllowBookingoccupiedbedswithEDD.label" bundle="${ip_labels}"/></td>
			<td   class='fields' align='left' width = '10%'><input type='checkbox' size='8' maxlength='8' name='allow_booking_with_edd_yn' id='allow_booking_with_edd_yn' value='N' <%=allow_booking_with_edd_yn%> ></td>

		</tr>
		<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>
	</table>
	
	<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
			<td   class='label' align='center' width='26%'><B><fmt:message key="eIP.TypeOfBooking.label" bundle="${ip_labels}"/></B></td>
			<td   class='label' align='center' width='18%'><B><fmt:message key="eIP.IndicateFutureBooking.label" bundle="${ip_labels}"/></B></td>
			<td   class='label' align='center' width='16%'><B><fmt:message key="eIP.NumberofdaysBefore.label" bundle="${ip_labels}"/></B></td>
			<td   class='label' align='center' width='18%'><B><fmt:message key="eIP.ConsiderEDDBeforeStop.label" bundle="${ip_labels}"/></B></td>
			<td   class='label' align='center' width='20%'><B><fmt:message key="eIP.ActiononBookingadmission.label" bundle="${ip_labels}"/></B></td>
			</tr>
			<tr>
				<td   class='label' align='right' width ='26%'>&nbsp;</td>
				<td   class='label' align='right' width ='18%'>&nbsp;</td>
				<td   class='label' align='right' width ='16%'>&nbsp;</td>
				<td   class='label' align='right' width ='18%'>&nbsp;</td>
				<td   class='label' align='right' width ='20%'>&nbsp;</td>
				
			</tr>
	</table>
	<table bordercolor="black" width='100%' >
			<tr>
				<td class='IP_WoodButton' width ='24%' ><font size=1>&nbsp<fmt:message key="eIP.BookedOverrideableConfirmed.label" bundle="${ip_labels}"/>&nbsp;&nbsp</td>
				<td    align='center' width='18%'><input type='checkbox' size='2' maxlength='2' name='future_booking_for_boc_yn' id='future_booking_for_boc_yn' value='N' <%=future_booking_for_boc_yn%> onclick='disfuturebooking(this)'></td>
				<td  align='center' width='16%' ><input type='textbox' size='3' maxlength='3' name='no_of_days_before_for_boc' id='no_of_days_before_for_boc' value='<%=no_of_days_before_for_boc%>' onblur='CheckZeroVal(this)' onKeyPress='return(ChkNumberInput(this,event,0))'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				<td    align='center' width='16%'><input type='checkbox' size='2' maxlength='2' name='consider_edd_stop_for_boc_yn' id='consider_edd_stop_for_boc_yn' value='N' <%=consider_edd_stop_for_boc_yn%> ></td>
				<td class='fields' align='center' width='18%'><select name='action_for_boc' id='action_for_boc' >
					<option value='W' <%=action_for_boc_w%>><fmt:message key="Common.Warn.label" bundle="${common_labels}"/></option>
					<option value='S' <%=action_for_boc_s%>><fmt:message key="Common.Stop.label" bundle="${common_labels}"/></option></select>
				</td>			
			</tr>

			<tr>
				<td class='IP_LWoodButton' width ='24%'><font size=1>&nbsp;<fmt:message key="eIP.BookedOverrideableUnConfirmed.label" bundle="${ip_labels}"/>&nbsp;&nbsp;</td>
				<td    align='center' width='18%'><input type='checkbox' size='2' maxlength='2' name='future_booking_for_bou_yn' id='future_booking_for_bou_yn' value='N'  <%=future_booking_for_bou_yn%> onclick='disfuturebooking(this)'></td>
				<td  align='center' width='16%' ><input type='textbox' size='3' maxlength='3' name='no_of_days_before_for_bou' id='no_of_days_before_for_bou' onblur='CheckZeroVal(this)' value='<%=no_of_days_before_for_bou%>' onKeyPress='return(ChkNumberInput(this,event,0))'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				<td    align='center' width='16%'><input type='checkbox' size='8' maxlength='8' name='consider_edd_stop_for_bou_yn' id='consider_edd_stop_for_bou_yn' value='N' <%=consider_edd_stop_for_bou_yn%> ></td>
				<td class='fields' align='center' width='18%'><select name='action_for_bou' id='action_for_bou' >
					<option value='W' <%=action_for_bou_w%>><fmt:message key="Common.Warn.label" bundle="${common_labels}"/></option>
					<option value='S' <%=action_for_bou_s%>><fmt:message key="Common.Stop.label" bundle="${common_labels}"/></option></select>
				</td>			
			</tr>


			<tr>
				
				<!--<td  width ='25%' bgcolor='#871F78'>-->
				<td width='24%' class='IP_PurpleButton'><b><font size='1' color = '#FFFFFF' >&nbsp;<fmt:message key="eIP.BookedNonOverrideableConfirmed.label" bundle="${ip_labels}"/></b></td>
				<td   align='center' width='18%'><input type='checkbox' size='2' maxlength='2' name='future_booking_for_bnc_yn' id='future_booking_for_bnc_yn' value='N' onclick='disfuturebooking(this)' <%=future_booking_for_bnc_yn%>></td>
				<td  align='center' width='16%' ><input type='textbox' size='3' maxlength='3' name='no_of_days_before_for_bnc' id='no_of_days_before_for_bnc' value ='<%=no_of_days_before_for_bnc%>' onblur='CheckZeroVal(this)' onKeyPress='return(ChkNumberInput(this,event,0))'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				<td    align='center' width='16%'><input type='checkbox' size='8' maxlength='8' name='consider_edd_stop_for_bnc_yn' id='consider_edd_stop_for_bnc_yn' value='N'  <%=consider_edd_stop_for_bnc_yn%>></td>
				<td class='fields' align='center' width='18%'><select name='action_for_bnc' id='action_for_bnc' >
					<option value='W' <%=action_for_bnc_w%>><fmt:message key="Common.Warn.label" bundle="${common_labels}"/></option>
					<option value='S' <%=action_for_bnc_s%>><fmt:message key="Common.Stop.label" bundle="${common_labels}"/></option></select>
				</td>			
			</tr>
			<tr>
				
				<td class='IP_LpurpleButton' width ='24%'><!--<td width = '27%' bgcolor='#DF0174'>--><font size=1>&nbsp;<fmt:message key="eIP.BookedNonOverrideableUnConfirmed.label" bundle="${ip_labels}"/></td>
				<td    align='center' width='18%'><input type='checkbox' size='2' maxlength='2' name='future_booking_for_bnu_yn' id='future_booking_for_bnu_yn' value='N' onclick='disfuturebooking(this)' <%=future_booking_for_bnu_yn%>></td>
				<td   align='center' width='16%' ><input type='textbox' size='3' maxlength='3' name='no_of_days_before_for_bnu' id='no_of_days_before_for_bnu' value ='<%=no_of_days_before_for_bnu%>' onblur='CheckZeroVal(this)' onKeyPress='return(ChkNumberInput(this,event,0))'><fmt:message key="Common.days.label" bundle="${common_labels}"/></td>
				<td    align='center' width='16%'><input type='checkbox' size='8' maxlength='8' name='consider_edd_stop_for_bnu_yn' id='consider_edd_stop_for_bnu_yn' value='N'  <%=consider_edd_stop_for_bnu_yn%>></td>
				<td class='fields' align='center' width='18%'><select name='action_for_bnu' id='action_for_bnu' onBlur="setfcs1();">
					<option value='W' <%=action_for_bnu_w%>><fmt:message key="Common.Warn.label" bundle="${common_labels}"/></option>
					<option value='S' <%=action_for_bnu_s%>><fmt:message key="Common.Stop.label" bundle="${common_labels}"/></option></select>
				</td>			
			</tr>


	</table>
	<!-- Below line Added for this CRF Bru-HIMS-CRF-354 -->
	<table cellspacing=0 cellpadding=0 align='left' width='100%' border='0'>
		
		<tr><th colspan='6' align='left'><fmt:message key="eIP.GeneralDetails.label" bundle="${ip_labels}"/></th><tr>
		
		<tr><td colspan=6 class=label>&nbsp;</td></tr>
		<tr><td class=label  width ='30%'><fmt:message key="eIP.DefaultReferringPractitioner.label" bundle="${ip_labels}"/></td>
		<td class='fields' align='left' width='25%' ><select name='default_ref_pract' id='default_ref_pract'>
		<option value='A' <%=deft_pract_bedside_referral_chk_a%>><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></option>
		<option value='L' <%=deft_pract_bedside_referral_chk_l%>><fmt:message key="eIP.LoginPractitioner.label" bundle="${ip_labels}"/></option></select></td>
		<!--Below line added for this CRF  HSA-CRF-146.1-->
		<td class=label align='left'  width='20%' >&nbsp;<fmt:message key="eIP.AllowMultipleBedsideReview.label" bundle="${ip_labels}"/></td>
		<td class='fields' align='left' width='20%'  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' size='2' maxlength='2' name='allow_muti_bedside_review_yn' id='allow_muti_bedside_review_yn' value='<%=allow_muti_bedside_review_yn%>' onclick='setVal(this)' <%=allow_muti_bedside_review_checked%>></td></td>
		<td class='fields' align='left'  width='20%' >&nbsp;</td>
		<!--End this CRF HSA-CRF-146.1 -->
		</tr>
		<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
		<tr><td class=label  width ='30%'><fmt:message key="eIP.EnableRecordingofReferralLetterNotewithReferralRequest.label" bundle="${ip_labels}"/></td>
		<td class='fields' align='left' width='25%' ><input type='checkbox' size='2' maxlength='2' name='ca_record_referral_note_yn' id='ca_record_referral_note_yn' value='<%=ca_record_referral_note_yn%>' onclick='setVal(this)' <%=ca_record_referral_note_yn_checked%>> </td>
		<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->
		<!--Added by Kamatchi S for MOHE-CRF-0154-->
		<td class=label  width ='20%' nowrap>&nbsp;<fmt:message key="eIP.AllowRegOfNewRefInIPAdmFunc.label" bundle="${ip_labels}"/></td>
		<td class='fields' align='left' width='20%' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' size='2' maxlength='2' name='allow_reg_referral_yn' id='allow_reg_referral_yn' value='<%=allow_reg_referral_yn%>' onclick='setVal(this)' <%=allow_reg_referral_yn_checked%>> </td>
		<td class='fields' align='left'  width='20%' >&nbsp;</td>
		</tr>
		</table>
     <!--End this CRF Bru-HIMS-CRF-354 -->
</div>
<%		
		if(warn_or_error_max_leave!=null && warn_or_error_max_leave.equals("W")){
%>		<script>

		</script>	
		
<%		}else{
%>		<script>				
		
		</script>	
<%		}

%>	
<input type="hidden" name="bl_interfaced_yn" id="bl_interfaced_yn" value="N">
<input type="hidden" name="setup_bl_dtls_in_ip_yn" id="setup_bl_dtls_in_ip_yn" value="N">
<input type="hidden" name="outst_amt_limit" id="outst_amt_limit">
<input type="hidden" name="policy_expiry_warning_period" id="policy_expiry_warning_period">
<input type="hidden" name="credit_auth_reqd_yn" id="credit_auth_reqd_yn">

<input type="hidden" name="isRestrictDischargeAdvice" id="isRestrictDischargeAdvice" value="<%=isRestrictDischargeAdvice%>"> <!--Added by Thamizh selvi on 7th Nov 2016 against GHL-CRF-0412.2 -->
<!--Added by Ashwini on 06-Mar-2019 for MO-CRF-20148-->
<input type='hidden' name='isNationalIdValidationAppl' id='isNationalIdValidationAppl' value='<%=isNationalIdValidationAppl%>'>
</form>
</body>

	<%
		if(stmt	!= null) stmt.close();
		if(stmt_pt_leave != null)stmt_pt_leave.close();
		if(rset_pt_leave != null)rset_pt_leave.close();
		if(rset		!= null)rset.close();
		//session.invalidate();
		//session.removeAttribute("bl_operational");
	}
	catch(Exception e)
	{
		out.println(e);
		e.printStackTrace() ;
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>

</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

