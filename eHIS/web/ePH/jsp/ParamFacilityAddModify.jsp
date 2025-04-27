<!DOCTYPE html>
 <%
 
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
30/01/2016	IN051707     Badmavathi B							            For Therapeutic Drug Monitoring Statistic
25/04/2016	IN067051     Devindra							                Enhance TPN Ordering Functionality
04/01/2019	IN068345     Prathyusha	                                     Required changes in item substitute mapping set up
07/03/2019	IN069337     Haribabu	                                        Need to show Generic name in drug search lookup
06/06/2019      IN:070087    Devindra R B	                                    MMS-DM-CRF-0150.1
05/07/2019	IN070605     prathyusha	                                        It is recommended that the pharmacy implement the appropriate automated drug interaction alerts to the physician at the point of order entry and/or to the pharmacist at the point of second line validation of medication orders.
31/01/2020	    IN071362         Manickavasagam	   AAKH-CRF-0117
13/05/2020      IN072991      SaiTeja            PH-MEDICITY- PH Parameter for Facility
10/11/2020		6041			Shazana       										NMC-JD-CRF-0063
01/12/2020   IN8219    Prabha	 	 	 12/01/2020		 Manickavasagam J    MMS-DM-CRF-0177
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
08/06/2021  	TFS id:-19371    Manickavasagam J	 08/06/2021	 		      ML-MMOH-CRF-1637
01/04/2023      TFS id:-34792  Yogesh 			NMC-JD-CRF-0186		PH Parameter medication billed or not in MAR
03/05/2023	    TFS id - 43082   			ML-MMOH-CRF-1823	PH parameter for facility to enable: Quota Limit Calculation required
22/05/2023      TFS id:-44841  Ayesha 		22/05/2023        Mohamed Suhail   MMS-DM-CRF-0233		PH parameter for facility
--------------------------------------------------------------------------------------------------------------------
*/ 
%> 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<link rel='StyleSheet' href='../../eCommon/html/Tabs.css' type='text/css'/> 
<%-- Mandatory declarations end --%>
<html>
	<head>
   <!--  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
   <%
   request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
    <script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	   <script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
    <script language="JavaScript" src="../js/ParamFacility.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
		function changeTab(objStr){
			selectTab(objStr);
		}
	</SCRIPT>
	<script>
		function tab_click(id){
			selectTab(id);
			Display(id);
		}
	</script>
</head>
	<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="StateCheck()"> -->
	<body onMouseDown="" onKeyDown="lockKey()">
<%
	String diag_for_medn_order_by = "P";	//Added for  MMS-SCF-0325 [IN:048069]
 		//Connection con	= null;		//added for ML-BRU-CRF-0473 // commented for ML-BRU-CRF-0473 linked Issue
	//con = ConnectionManager.getConnection(request);//added for ML-BRU-CRF-0473 // commented for ML-BRU-CRF-0473 linked Issue	
	try{
		 /* Mandatory checks start */
		String mode					= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
		String bean_id				= "FacilityParameter" ;
		String bean_name			= "ePH.ParameterFacilityBean";

		String log_bean_id			= "SetupAuditLogBean" ;
		String log_bean_name	    = "ePH.SetupAuditLogBean";
		String audit_log_visible	= "visibility:hidden";
		String table_id				= "PH_FACILITY_PARAM";
		String pkey_value		    ="";
		String licenseValue		    ="";
		String licenseYN		    ="";
		//added for ML-MMOH-CRF-1637 - start
		String pat_trans_phar_type	    = ""; 
		String pat_trans_other_type	    = ""; 
		String pat_trans_other_disabled = "";
		String pat_trans_phar_checked   = "";
		String pat_trans_other_checked  = "";
		//added for ML-MMOH-CRF-1637 - end

		//Added for TFS id:-16341 start
String sql="select DISP_LOCN_CODE,SHORT_DESC from PH_DISP_LOCN_LANG_VW where FACILITY_ID=? and LANGUAGE_ID=? and DISP_LOCN_TYPE in ('P','C','N') and EFF_STATUS='E'";
ArrayList disp_locn_params= new ArrayList();
String default_disp_locn="";
//Added for TFS id:-16341 end
		PhDrugDatabaseInterfaceLicense interfaceLicense=new PhDrugDatabaseInterfaceLicense();
		licenseValue=interfaceLicense.getLicense();
	 
		ArrayList db_interface_names=new ArrayList();
		String disabled = "" ;
		if ( mode == null || mode.equals("") )
			return ;
		if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
			return ;
		// Mandatory checks end

		String licenceRights = PhLicenceRights.getKey();
				//licenceRights="PHBASIC";
		// Initialize Function specific start
		ParameterFacilityBean bean = (ParameterFacilityBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clear() ;
		bean.setMode( mode ) ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

		SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
		log_bean.setLanguageId(locale);
		 db_interface_names = bean.loadDrugDatabaseNames(locale);
		   licenseYN	= bean.drugDBinterfaceYN();

		Hashtable param_legends = bean.getLegendsFromParam(locale);
		// Initialize Function specific end
		// The following variables are declared for defaulting the values,enabling and disabling the values
		// and also for validation.
		String dflt_dir_disp_locn1 ="";
		String dflt_dir_disp_locn2 ="";
		String EnableInterfaceStockControl="disabled";  String PatInstrLocLangYN			= "";
		String AllowMednOrderWithoutDiag = "";			String AllowMednOrderWithoutWt		= "";
		String allowMednWithDiagDisable = ""; // Added for MMS-DM-CRF-0150.1
		//code added for unallocated order at delivery
		String UnallocOrderDelivery	= "";
		//
		String ConsiderStock="disabled";				String RefillYN						= "";
		String MaxNoOfRefillsAllowed = "disabled";		String MaxDurForRefillDesc			= "disabled";
		String PrintRefillDesc= "enabled";				String IPExists						= "NO";
		String PrintRefillDescYN="";
		//String DisplayPriceTypelkpenable = "enabled";
		String BLExists =   "N";						String AllowPresWithoutStock		= "disabled";
		String DispVerfStageValue="";					String DispVerfStageCode			= "";
		String AllowPresWithoutStockYN ="";				String MaxNoOfRefillsAllowedValue	= "";
		String MaxDurForRefillDescValue="";				String DispBeforeStartDateYN		= "";
		String DispBeforeNoOfDaysValue="";				String DispBeforeNoOfDays			= "";
		String DispBeyondEarliestStartYN="";			String DispBeyondNoOfDays			= "";
		/*String DispBeyondEarliestStartEnableDisable= "";String DispBeforeStartDateEnableDisable="";*/
		String DispBeyondNoOfDaysValue="";				String DispAcknReqdYN				= "";
		String DispFlngReqdYN="";						String DispDelvReqdYN				= "";
		String disableFillingStages="disabled";			String DispFillStage				= "";
		String selectDispFillStageBefore="";			String selectDispFillStageAfter		= "";
		String selectDispFillStageNA="";
	   // String DispCashCollStageInd="";					String DispCashCollStageVer		= "";
	   // String DispCashCollStageDel="";					//Commented for MMS-QH-CRF-0069 [IN:037977] - not used
		String PrintDispSheetOPYN="";
		//String DfltLangForDispLabelEng="";				String DfltLangForDispLabelLoc		= "";
		//String DfltLangForDispLabelBoth="";				
		String dflt_lang_for_disp_label="";		//Added for MMS-QH-CRF-0069 [IN:037977]		
		String LabelFormatOPDrug			= "";
		String LabelFormatOPCombined="";				String AllowDrugReturnYN			= "";
		String MaxDrugRetentionBefRtnValue="";			String MaxDrugRetentionBefRtn		= "";
		String MaxDurnForOPMedRtnValue="";				String MaxDurnForOPMedRtn			= "";
		String IPVerfYN="";								String IPFillPrdAheadValue			= "24"; 
		String IPFillPrdAheadUnit="";
		String IPFillExclPrdBehindValue="";				String IPDelvReqdYN					= "";
		String IPFillDfltStartTimeValue="";				
		String dflt_lang_for_disp_label_ip	= ""; //Added for MMS-QH-CRF-0069 [IN:037977]
		//String DfltLangForDispLabelIPEng	= "";
		//String DfltLangForDispLabelIPLoc="";			String DfltLangForDispLabelIPBoth	= "";
		String IPLabelFormatDrug="";					String IPLabelFormatCombined		= "";
		String PrintBalMedSheetOPYN="";					String OPDispLocnRtn_ord			= "";					
		String OPDispLocnStat_ord				= "";	
		String IPDispLocnRtn_ord				= "";					
		String IPDispLocnStat_ord				= "";		
		String DischMedDispLocn					= "";	
		String BLInstalled						= "N";		
		String BLInstalledEnableDisable			= "disabled";		
		String DisableRegnFillPharmaVerification= "";

		String DISP_CHARGE_DTL_IN_RX_YN			= "",DISP_CHARGE_DTL_IN_DRUG_LKP_YN="",DISP_PRICE_TYPE_IN_DRUG_LKP="";
		String DISP_CHARGE_DTL_IN_DRUG_LKP_CHK	= "";
		//String consider_stock_ip				= "";
		String ip_consider_stock_status			= "";
		String ip_allow_stock_status			= "";
		
		//String max_durn_for_ip_pres			= "0";

		//String allow_usage_of_spil_qty_yn		= "";
		//String charge_qty_ind_prepared		= "";				
		//String charge_qty_ind_stock="";
		String med_admin_reqd_yn				= "";					
		String verf_reqd_bef_med_admin_yn		= "";
		String rec_admin_within_hrs				= "";					
		String allow_med_admin_wo_ord_yn		= "";
		String witness_for_verbal_order_yn		= "";	// Added for AAKH-CRF-0023[IN:038259]
		String witness_for_verbal_order_disable = "disabled";	// Added for AAKH-CRF-0023[IN:038259]
		String allow_duplicate_drug				= "";
		//Added for for MO-CRF-20085.1  By Prathyusha on 05/18/2016 start
		String skip_duplicate_alert_ip_val= "N";
		String skip_duplicate_alert_op_val= "N";
		String skip_duplicate_alert_ip_disp= "disabled";
		String skip_duplicate_alert_op_disp= "disabled";
		String skip_duplicate_alert_ip_chk= "";
		String skip_duplicate_alert_op_chk= "";
		//Added for for MO-CRF-20085.1  By Prathyusha on 05/18/2016 end
		//Added for for MO-CRF-20085.1 modified By Prathyusha on 05/26/2016 start
		String overlap_duration_op_val="";
		String overlap_duration_ip_val="";
		String overlap_duration_op_disp="disabled";
		String overlap_duration_ip_disp="disabled";
		//Added for for MO-CRF-20085.1 modified By Prathyusha on 05/26/2016 end
		
		//IN30118-SCF No: MO-GN-5400. Initiating Duplicate Drug Flag for OP.
		String allow_duplicate_drug_op				= "";
		String print_exp_date_on_lbl			= "";
		String duplicate_check_atc				= "";
		String remarks_for_prn					= "";
	//******
		String display_charge_details_lkp		= "";
		String display_charge_details_prescription = "";
		String display_price_type_lkp			= "";
	   // String DisplayPrice					= "";
	//*****

		//------
		String iv_admixture_appl_yn				= "";
		String cdr_admixture_appl_yn			= "";
		String tpn_regimen_appl_yn				= "";
		String working_hrs_of_prep_room_from	= "";
		String working_hrs_of_prep_room_to		= "";
		String alert_practitioner_yn			= "";	
		String	verify_tdm_order_yn				= "";
		
		String	start_adr_no					= "";
		String  last_adr_no						= "";
		
		//String applicable_patient_class		= "";
		String applicable_patient				= "";
		String direct_disp						= "";
		String direct_disp_chk					= "";
		String pat_clas_chk1					= "";
		String pat_clas_chk2					= "";
		String pat_clas_chk3					= "" ;
		String pat_clas_chk4					= "checked" ;	
		String pat_class						= "";
		String app_enc							= "";
		String app_enc_chk1						= "";
		String app_enc_chk2						= "";
		String app_enc_chk3						= "checked";
		//String last_enc1						= "";
		String last_enc							= "10";
		String enc_during_disp					= "";
		String enc_during_disp_chk				= ""; 
		//String last_enc						= "";
		String disp								= "";
		String comp_rx_chk						= "";
		String iv_rx_chk						= "";
		String oncology_rx_chk					= "";
		String tpn_rx_chk						= "";
		String tdm_order_chk					= "";	
		String tdm_result_type					= "";	 
		String pat_couns_result_type			= "";
		
		String tdm_result_type_select_1			= "";
		String tdm_result_type_select_2			= "";
		String pat_couns_result_type_select_1	= "";
		String pat_couns_result_type_select_2	= "";
		String tdm_result_type_desc				= "";
		String pat_couns_result_type_desc		= "";
		String tdm_result_type_id				= "";
		String pat_couns_result_type_id		    = "";	

		String cdrug_db_interface_yn			= "";   
		String drug_db_product_id				= "";     
		String drug_db_dosecheck_yn				= "";   
		String drug_db_duptherapy_yn			= "";  
		String drug_db_interact_check_yn		= "";
		String drug_db_contraind_check_yn		= "";
		String drug_db_allergy_check_yn			= "";

		String inpatient_yn						= "";
		String Outpatient_yn					= "";
		String Daycare_yn						= "";
		String emergency_yn						= "";
		String Disch_Med_Mar_Appl_yn			= "";
		//  RUT-CRF-0062 [IN029600]  Added for Build MAR Rule Based Flag -- begin
		String inpatient_yn_rule_check			= ""; 
		String inpatient_yn_rule_disab			= " disabled "; 
		String outpatient_yn_rule_check			= ""; 
		String outpatient_yn_rule_disab			= " disabled "; 
		String daycare_yn_rule_check			= ""; 
		String daycare_yn_rule_disab			= " disabled "; 
		String emergency_yn_rule_check			= ""; 
		String emergency_yn_rule_disab			= " disabled "; 
		String dischmedic_yn_rule_check			= ""; 
		String dischmedic_yn_rule_disab			= " disabled "; 
		// RUT-CRF-0062 [IN029600]  Added for Build MAR Rule Based Flag -- end
		String admx_prep_charges_appl_yn		= "";
		String split_based_priority_yn			= "";
		String split_drug_based_auth_yn               ="";//added for ml-mmoh-crf-0864
		String split_based_drug_class_yn		= "";
		String MaxNoOfRefillsAllowedValueParam  = "";   
		String MaxDurForRefillDescValueParam    = "";     
		String DispBeforeNoOfDaysValueParam     = "";   
		String DispBeyondNoOfDaysValueParam     = "";  
		String value							= "";	
		boolean chkForPHParamExistence			= false;
		String tpn_screening_type				= "";
		String tpn_screening_type_select_1		= "";
		String tpn_screening_type_select_2		= "";
		//String tpn_screening_type_select_3	= "";
		String tpn_screening_type_desc			= "";
		String tpn_screening_form_id			= "";
		String oncology_screening_type			= "";
		String onc_screening_type_select_1		= "";
		String onc_screening_type_select_2		= "";
		String onc_screening_type_desc			= "";
		String oncology_screening_form_id		= "";
		String drug_cat_pin_auth_reqd_yn		= "";
		String tpn_rx_chk_val					= "";
		String tpn_rx_chk_status				= "";
		String oncology_rx_chk_val				= "";
		String oncology_rx_chk_status			= "";
		String all_shrt_expry_drgs				= "";
		String copy_pres_upto_no_of_days		= "";
		String includeZeroAllocatedItemsOPYN    = ""; //added for INCLUDE ZERO ALLOC ITEMS on 07-03-09
		String includeZeroAllocatedItemsIPYN    = "";//Added for ML-BRU-CRF-0473
		String assesment_req_yn                 = "";// Added for ML-MMOH-CRF-1126
		String late_or_early_admin_check        = ""; // Added for GHL-CRF-0482 [IN:064955]
		String rec_admin_bef_schdle_time		= ""; //added for Record MAR before Schedule Time on 17-06-09 by Abdul
		String rec_admin_bef_schdle_time_UOM	= ""; 
		String rec_admin_bef_schdle_time_selM	= ""; 
		String rec_admin_bef_schdle_time_selH	= ""; 
		String IPDailySeqNoYN					= ""; 
		String allowDispRecordLockYN			= "";//Added for CRF-0439
		String promptAlertForPreferredItem		= "";//Added for CRF-711 --INC 12669
		String defaultPrivilegeDrugSelection	= "";//Added for CRF-641
		String displayUOMInTransaction			= "";//added for CRF-749
		//Added CRF-713 INC 12785
		String narcoticAprvlFormReqYN			= "";
		String printNarcoticFormByDefault		= ""; String printNarcoticFormByDefaultYN			= "";
		String edit_disp_label_after_del ="";
		String discont_canc_dup_medic ="";   // Added for Bru-HIMS-CRF-265 [IN:032315]
		String disp_exp_orders_yn ="";   // Added for ML-BRU-SCF-0636 [IN036826]
		String rx_qty_by_pres_base_uom_yn ="";
		String dflt_ip_fill_incr_start_with = "";
		String atc_allergy_alert_level = "N";
		String tab_based_group_sort_disp = "";
		String pin_auth_mar_yn					= "";   // RUT-CRF-0035 [IN029926]
		String allow_medn_ord_without_diag_for_dd=""; // added for CRF MMS-QH-CRF-0068 [IN:037980]
		String print_mar_label_yn ="Y"; // MMS-QH-CRF-0080 [IN:038064]
		String alt_drug_remarks_ind = "";   //added for  Bru-HIMS-CRF-082 [IN:029948]
		String mar_sch_level_yn = "N", mar_start_ind = "S", mar_week_day_start = "1", mar_past_day = "", mar_future_day = "", mar_default_order_by = "O", mar_disc_dose_yn = "N", mar_iv_compl_dt_ind="I", mar_sch_level_disable = "disabled", mar_disc_dose_chk="", mar_sch_level_chk="";   //added for SKR-CRF-0037 [IN:037656] -start
		String mar_week_day_start_disp = "display:none";
		String defDispDayUserDefined_disp = "display:none";
		String allergy_conf_reqd_yn = "N", allergy_conf_disp="display:none", allergy_conf_check=""; //added for RUT-CRF-0064.1 [IN:041799]
		String mr_allergy_conf_reqd =  bean.getMRParamAllergyConf(); //added for RUT-CRF-0064.1 [IN:041799]
		String defaultSelect1 = "Selected"; // Added for GHL-CRF-0412.3 - Start
		String initPreSelected = ""; 
		String prepaDisAdvSelected = "";
		String dischPatSelected = ""; // Added for GHL-CRF-0412.3 - End
		String drug_indication_mdry="",drug_indication_mdry_chk="";//added for JD-crf-0220
		String disp_auto_refresh ="";//Added for TH-KW-CRF-0011
		// Added for MMS-CRF-0233-44841 by Ayesha Khan Start
		String PrintFooterDescYN="";
		String PrintFooterDtlsPresYN=""; 
		String PrintPresDtlEnValue	= "";
		String PrintPresDtlLocValue	= ""; 
		// Ended for MMS-CRF-0233-44841 By Ayesha
		boolean isSite = bean.isSite(request,"IP","PRE_DISCHARGE");// Added for GHL-CRF-0412.3 - End //isSiteForPreDischarge changed to isSite for ML-BRU-CRF-0473 linked Issue
		boolean allowMednWithDiagDisableYn = bean.isSite(request,"OR","DX_CHK_BFR_PLACE_ORDERS"); // Added for MMS-DM-CRF-0150.1
		boolean  allow_zero_disp_label_site= bean.isSite(request,"PH","ALLOW_ZERO_DISP_LABEL");//eCommon.Common.CommonBean.isSiteSpecific(con, "PH","ALLOW_ZERO_DISP_LABEL");//added for ML-BRU-CRF-0473 // commented for ML-BRU-CRF-0473 linked Issue
		boolean assesmentApplYn                 = bean.isSite(request, "PH", "ASSESMENT_REQ_YN"); // Added for 	ML-MMOH-CRF-1126
		boolean late_or_early_admin_yn = bean.isSite(request, "PH", "PATIENT_STOCK_REQUIRED"); // Added for GHL-CRF-0482 [IN:064955]
		boolean intractn_req_yn =bean.isSite(request,"PH","DISP_STAGE_INTRACTN_REQ_YN");	// Added for MMS-KH-CRF-0028
		boolean op_take_home_med = bean.isSite(request,"PH","OP_TAKE_HOME_MEDICATION");//added for 6041
		boolean default_disp_locn_select_appl = bean.isSite(request,"PH","PH_DISP_LOCN_SELECT_APPL");//Added for TFS id:-16341		
		boolean patient_trans_app = bean.isSite(request,"PH","PH_PATIENT_TRANS_APPL");//added for  ML-MMOH-CRF-1637
		boolean disp_medication_auto_refresh = bean.isSite(request,"PH","DISP_MEDICATION_AUTO_REFRESH");//Added for TH-KW-CRF-0011
		boolean display_drug_verification_remarks = bean.isSite(request,"PH","DISP_REMARKS");//Added for ML-MMOH-CRF-1755
		boolean allow_sensitive_diagnosis_yn = bean.isSite(request,"PH","PH_PARAM_SENSITIVE_DIAG");//Added for ML-BRU-CRF-0630
		boolean ph_quota_limit_for_drug_yn = bean.isSite(request,"PH","PH_QUOTA_LIMIT_FOR_DRUG");//Added for ML-MMOH-CRF-0623
		boolean display_mar_for_dispensed_unbilled_medication = bean.isSite(request,"PH","ALLOW_MAR_DISP_UNBILL_MED");//Added for NMC-JD-CRF-0186
        boolean ph_pres_footer_desc_dtls = bean.isSite(request,"PH","PH_PRES_FOOTER_DESC_DTLS");// Added for MMS-CRF-0233-44841 by Ayesha Khan	
		boolean ph_always_display_dispense_location_yn = bean.isSite(request,"PH","PH_DISP_LOC_DRUG_SEARCH");//Added for NMC-JD-CRF-0197
		

				if(mr_allergy_conf_reqd.equals("Y") ){
			allergy_conf_disp = "display:inline";
			if(allergy_conf_reqd_yn.equals("") || allergy_conf_reqd_yn.equals("Y")){
				allergy_conf_reqd_yn = "Y";
				allergy_conf_check = "checked";
			}
		}
		
		boolean approval_no_app = bean.isSite(request,"PH","APPROVAL_NO_APPLICABLE_FLAG"); //Added for AAKH-1117
		
		//Added for MMS-DM-CRF-0177
		boolean pre_alloc_appl = false;
		String pre_alloc_check = "N";
		pre_alloc_appl = bean.isSite(request,"PH","PRE_ALLOC_APPL"); 
		if(pre_alloc_appl)
		{
			pre_alloc_check="Y";
		}
		//Added for MMS-DM-CRF-0177
		
		//This method call will be helpful for checking the existence of IP and BL modules
		String DispBeforeStartDateYN_IP=""; //Added for AMS-CRF-0009[IN:030935] -start
		String DispBeforeNoOfDaysValue_IP="";
		String DispBeyondEarliestStartYN_IP="";
		String DispBeyondNoOfDaysValue_IP=""; 
		String NoOfDays_Disabled = "disabled";
		String EarliestStart_Disabled = "disabled";
		String DispBeforeStartDateYN_IP_checked="";
		String DispBeyondEarliestStartYN_IP_checked="";//Added for AMS-CRF-0009[IN:030935] -end
		ArrayList IPBLCheck     =   (ArrayList) bean.checkForIPBLExistence();
		ArrayList alLanguageIds     =   bean.getLanguageIDs(); //Added for MMS-QH-CRF-0069 [IN:037977]
		String mar_disp_held_disc_orders_yn="", mar_disp_held_disc_check="";  //added for [IN:043283]
		String strDefaultFreqforIV = ""; //Added for Bru-HIMS-CRF-384[IN041642]
		String em_medctn_fwd_ip_yn = "", cary_frwd_ord_nofhrs=""; //Added for Bru-HIMS-CRF-402[IN044065]
		String disp_rx_duration_yn="", disp_rx_duration_check =""; //Added for Bru-HIMS-CRF-403[IN044541]
		String allow_mar_share_drug_yn="", allow_mar_share_drug_check =""; //Added for HSA-CRF-0090 [IN:041241]
		String allow_mar_alternate_drug_check =""; //Added for Bru-HIMS-CRF-399 [IN:043767]
		String allow_renew_from_chart_summ_yn="";//Added for Bru-HIMS-CRF-400
		String can_discon_dup_orders_def_sel = "disabled";//Added for HSA-CRF-0151 [IN048468]
		String preview_rx_yn_check="";//Added for ML-MMOH-CRF-0341 [IN:057179]
		String disp_prev_vital_signs_yn_check="N";//Added for ML-MMOH-CRF-0346 [IN:057185]
		String generic_name = "";//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
		String generic_code = "";//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
		String working_hours_from="";//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
		String working_hours_to="";//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
		String allow_alternate_item_for_medical_item_yn="";//added for GHL-CRF-0548
		String display_generic_name_yn="";//Added for NMC-JD-CRF-0001		
		//ADDED FOR MMS-KH-CRF-0014 start
	    String ward_ack_required_yn="";	
		String ward_ack_required_yn_checked="";	
		String ward_ack_mar_required_yn="";
		String ward_ack_mar_required_yn_checked="";
		//ADDED FOR MMS-KH-CRF-0014	 end
		String review_aprrove_applicable_for_ip = "";   //added for  MMS-KH-CRF-0028
		String review_aprrove_applicable_for_op = "";   //added for  MMS-KH-CRF-0028
		String review_aprrove_applicable_for_ip_checked = "";   //added for  MMS-KH-CRF-0028
		String review_aprrove_applicable_for_op_checked = "";   //added for  MMS-KH-CRF-0028
		//added for AAKH-CRF-0117 - start
		String approval_no_yn_ip = "N";         
		String approval_no_yn_op = "N";
		String opDisMedLcn = "";//added for 6041
		//String approval_no_yn_ip_checked = "";     //commented for IN072991      
		//String approval_no_yn_op_checked = "";     //commented for IN072991      
		//added for AAKH-CRF-0117 - end
		
		//Added for MMS-DM-CRF-0177
		String pre_alloc_appl_yn   = "N";
		String pre_alloc_appl_checked = "";
		String near_expiry = "";
		String near_expiry_appl_yn = "E";
		String stock_level = "";
		String expiry_stock_val ="";
		String durn_value  = "";
		String durn_type   = "N";
		String durn_type_D = "";
		String durn_type_N = "";
		String durn_type_M = "";
		String durn_type_Y = "";
		String pre_alloc_disabled = "";
		//Added for MMS-DM-CRF-0177
		String display_verif_drug_inst_remarks_yn="";//Added for ML-MMOH-CRF-1755
		String Amend_orderwise_DispMedication=""; //added for ml-mmoh-scf-1748
		String Amend_orderwise_DispMedication_yn="";//added for ml-mmoh-scf-1748
		String do_not_display_sensitive_diagnosis_yn="";//added for ML-BRU-CRF-0630
		String display_sensitive_diagnosis_indicator_yn="";//added for ML-BRU-CRF-0630
		String do_not_display_sensitive_diagnosis_checked = ""; //added for ML-BRU-CRF-0630
		String display_sensitive_diagnosis_indicator_yn_checked = "";  //added for ML-BRU-CRF-0630
		String do_not_display_sensitive_diagnosis_disabled = ""; //added for ML-BRU-CRF-0630
		String display_sensitive_diagnosis_indicator_yn_disabled = "";  //added for ML-BRU-CRF-0630
		String mar_disp_unbilled_med_yn = "", mar_disp_unbilled_med = "";  //added for NMC-JD-CRF-0186 <!-- 42911 -->

		String quota_limit_calculation_required_yn				= ""; //added for ML-MMOH-CRF-1823		
		String quota_limit_calculation_required_yn_checked		= ""; //added for ML-MMOH-CRF-1823
		String active_prescription_enabled_for_quota_limit_yn	= ""; //added for ML-MMOH-CRF-1823
		String active_prescription_enabled_for_quota_limit_yn_checked = ""; //added for ML-MMOH-CRF-1823
		String active_prescription_enabled_for_quota_limit_yn_disabled = ""; //added for ML-MMOH-CRF-1823
		String always_display_dispense_location_yn				= ""; //added for NMC-JD-CRF-0197
		String always_display_dispense_location_yn_checked		= ""; //added for NMC-JD-CRF-0197


		
		if (IPBLCheck.size()==2){
			if (Integer.parseInt((String)IPBLCheck.get(1))>0)
				IPExists    =   "YES";
			if (((String)IPBLCheck.get(0)).equals("BL"))
				BLExists    =   "Y";
		}
		else if (IPBLCheck.size()==4){
			IPExists    =   "YES";
			BLExists    =   "Y";
		}

		String facility_id  =   (String)session.getValue("facility_id");
		//Added for TFS id:-16341 start
		disp_locn_params.add(facility_id);
		disp_locn_params.add(locale);
		//Added for TFS id:-16341 end
		//out.println("facility_id===287=>" +facility_id);
		String bl_install_yn= (String) session.getValue( "bl_operational" ) ==null?"N":(String) session.getValue( "bl_operational" );
		
		//Added by prathyusha for JD-CRF-198 start
			String allow_amend_alt_drug_dtl_chk="";
			String allow_amend_alt_drug_dtl_val="N";
			//Added by prathyusha for JD-CRF-198 end
			String reconciliation_ip_val="N";//added for mms-kh-crf-0016
			String reconciliation_ip_chk="";//added for mms-kh-crf-0016
			
		ArrayList arrList			 =   (ArrayList)bean.checkForPHFacilityParamExistence(facility_id);
		ArrayList arrListFdbValues   =   (ArrayList)bean.checkForPHFacilityParamExistenceFdbValues(facility_id);
		
		if (arrListFdbValues.size() > 0){
			if(arrListFdbValues.get(0) != null){
				cdrug_db_interface_yn =(String)arrListFdbValues.get(0);
				if(cdrug_db_interface_yn.equals("Y"))
					cdrug_db_interface_yn = "checked";
				else
					cdrug_db_interface_yn="";
			}

			if(arrListFdbValues.get(1) != null)
				drug_db_product_id =(String)arrListFdbValues.get(1);

			if(arrListFdbValues.get(2) != null){
				drug_db_dosecheck_yn =(String)arrListFdbValues.get(2);
				if(drug_db_dosecheck_yn.equals("Y"))
					drug_db_dosecheck_yn = "checked";
				else
					drug_db_dosecheck_yn="";
			}

			if(arrListFdbValues.get(3) != null){
				drug_db_duptherapy_yn =(String)arrListFdbValues.get(3);
				if(drug_db_duptherapy_yn.equals("Y"))
					drug_db_duptherapy_yn = "checked";
				else
					drug_db_duptherapy_yn="";
			}

			if(arrListFdbValues.get(4) != null){
				drug_db_interact_check_yn =(String)arrListFdbValues.get(4);
				if(drug_db_interact_check_yn.equals("Y"))
					drug_db_interact_check_yn = "checked";
				else
					drug_db_interact_check_yn="";
			}

			if(arrListFdbValues.get(5) != null){
				drug_db_contraind_check_yn =(String)arrListFdbValues.get(5);
				if(drug_db_contraind_check_yn.equals("Y"))
					drug_db_contraind_check_yn = "checked";
				else
					drug_db_contraind_check_yn="";
			}

			if(arrListFdbValues.get(6) != null){
				drug_db_allergy_check_yn =(String)arrListFdbValues.get(6);
				if(drug_db_allergy_check_yn.equals("Y"))
					drug_db_allergy_check_yn = "checked";
				else
					drug_db_allergy_check_yn="";
			}
		}

		ArrayList defaultValues =(ArrayList) bean.getAllDefaultValuesOnLoad();

		if (defaultValues.size()>0){
			MaxNoOfRefillsAllowedValueParam  = (String) defaultValues.get(2);
			PrintRefillDescYN				 = (String) defaultValues.get(3);
			MaxDurForRefillDescValueParam    = (String)defaultValues.get(4);
			DispBeforeNoOfDaysValueParam     = (String)defaultValues.get(6);
			DispBeyondNoOfDaysValueParam     = (String)defaultValues.get(8);
		}
		else{
%>
			<script>alert(getMessage("PH_PARAM_NOT_SETUP","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'
			</script>
<%
		}
		if (arrList.size()>0){
			//	If the record is already existing in the PH_FACILITY_PARAM the following code will execute (Modify)
			chkForPHParamExistence=bean.checkForPHParamExistence();
			if(!chkForPHParamExistence){
%>
				<script>alert(getMessage("PH_PARAM_NOT_SETUP","PH"));window.location.href ='../../eCommon/jsp/dmenu.jsp'
				</script>
<%
			}
			//This is to check whether BL module is installed or not
			ArrayList defaultValues1 =(ArrayList) bean.checkForBLModuleExistence();
			if (defaultValues1.size()>0){
				if (!((String)defaultValues1.get(0)).equals("N")){
					BLInstalled ="Y";
					BLInstalledEnableDisable="";
				}
			}
			else{
				BLInstalled ="N";
				BLInstalledEnableDisable="disabled";
			}

			DisableRegnFillPharmaVerification = "disabled";
			mode    = CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
			bean.setMode(mode);
			EnableInterfaceStockControl =   (String)arrList.get(0);
			if (EnableInterfaceStockControl.equals("Y"))
				EnableInterfaceStockControl="checked";
			else
				EnableInterfaceStockControl="disabled";

			PatInstrLocLangYN   =   (String)arrList.get(1);
			if (PatInstrLocLangYN.equals("Y"))
				PatInstrLocLangYN="checked";
			ConsiderStock   =   (String)arrList.get(2);
			if (ConsiderStock.equals("Y"))
				ConsiderStock="checked";
			else
				ConsiderStock="";

			AllowPresWithoutStockYN =   (String)arrList.get(3);
			if (AllowPresWithoutStockYN.equals("Y")){
				AllowPresWithoutStockYN="checked ";
				AllowPresWithoutStock="";
			}
			else{
				AllowPresWithoutStock="";
			}
			RefillYN =  (String)arrList.get(4);

			MaxNoOfRefillsAllowedValue= (String)arrList.get(5);

			if (MaxNoOfRefillsAllowedValue==null )
				MaxNoOfRefillsAllowedValue="";
			if (((String)arrList.get(6)).equals("Y"))
				PrintRefillDesc="checked";

			MaxDurForRefillDescValue=(String)arrList.get(7);
			if(MaxDurForRefillDescValue==null )
				MaxDurForRefillDescValue="";

			String RefillYNFromParam = bean.getRefillYNFromParam();
			if(RefillYNFromParam.equals("N")){
				RefillYN="disabled";
				MaxNoOfRefillsAllowed="disabled";
				MaxDurForRefillDesc="disabled";
				PrintRefillDesc="disabled";

				MaxNoOfRefillsAllowedValue="";
				MaxDurForRefillDescValue="";
			}
			else{
				if (RefillYN.equals("Y")){
					RefillYN="checked";
					MaxNoOfRefillsAllowed="";
					MaxDurForRefillDesc="";
					//PrintRefillDesc="";
				}
			}

			if(((String)arrList.get(8)).equals("Y"))
				DispBeforeStartDateYN="checked";
			else{
					DispBeforeNoOfDays="disabled";
					//DispBeyondEarliestStartYN="disabled";
					//DispBeyondNoOfDays="disabled";
			}

			DispBeforeNoOfDaysValue=(String)arrList.get(9);
			if (DispBeforeNoOfDaysValue==null)
				DispBeforeNoOfDaysValue="";

			if (((String)arrList.get(10)).equals("Y"))
				DispBeyondEarliestStartYN ="checked";

			DispBeyondNoOfDaysValue = (String)arrList.get(11);
			if (DispBeyondNoOfDaysValue==null)
				DispBeyondNoOfDaysValue="";

			DispAcknReqdYN  =   (String)arrList.get(12);
			if (DispAcknReqdYN.equals("Y"))
				DispAcknReqdYN  = "checked";

			if (((String)arrList.get(13)) != null){
				if (((String)arrList.get(13)).equals("Y")){
					DispFlngReqdYN =   "checked";
					disableFillingStages ="";
				}
			}
			if (((String)arrList.get(14)).equals("Y")){
				DispDelvReqdYN="checked";
			}
			if (((String)arrList.get(15)).equals("Y"))
				PrintDispSheetOPYN="checked";

			if (arrList.get(16)!=null) //Added for MMS-QH-CRF-0069 [IN:037977]
				dflt_lang_for_disp_label=(String)arrList.get(16);

			/*if (((String)arrList.get(16)).equals("E")) //Commented for MMS-QH-CRF-0069 [IN:037977]
				DfltLangForDispLabelEng = "selected";
			else if (((String)arrList.get(16)).equals("L"))
				DfltLangForDispLabelLoc = "selected";
			else if (((String)arrList.get(16)).equals("B"))
				DfltLangForDispLabelBoth = "selected";*/
			if (((String)arrList.get(17))!= null){
				if (((String)arrList.get(17)).equals("D"))
					LabelFormatOPDrug = "selected";
				else if (((String)arrList.get(17)).equals("C"))
					LabelFormatOPCombined = "selected";
			}
		
			if (((String)arrList.get(18)).equals("Y"))
				AllowDrugReturnYN   ="checked";
			else {
				MaxDrugRetentionBefRtn="disabled";
				MaxDurnForOPMedRtn="disabled";
			}

			MaxDrugRetentionBefRtnValue=(String)arrList.get(19);
			if (MaxDrugRetentionBefRtnValue==null)
				MaxDrugRetentionBefRtnValue="";

			MaxDurnForOPMedRtnValue=(String)arrList.get(20);
			if (MaxDurnForOPMedRtnValue==null)
				MaxDurnForOPMedRtnValue="";

			if (((String)arrList.get(21)).equals("Y"))
				IPVerfYN    ="checked";

			IPFillPrdAheadValue=(String)arrList.get(22);
			if (IPFillPrdAheadValue==null)
				IPFillPrdAheadValue="";

			//	max_durn_for_ip_pres = IPFillPrdAheadValue;
			if (((String)arrList.get(23))==null)
				IPFillExclPrdBehindValue="";
			else
				IPFillExclPrdBehindValue=(String)arrList.get(23);

			if(((String)arrList.get(24)).equals("Y"))
				IPDelvReqdYN="checked";
			
			if (((String)arrList.get(25))==null)
				IPFillDfltStartTimeValue="";
			else
				IPFillDfltStartTimeValue=(String)arrList.get(25);

			if (arrList.get(26)!=null) //Added for MMS-QH-CRF-0069 [IN:037977]
				dflt_lang_for_disp_label_ip=(String)arrList.get(26);

			/*if (((String)arrList.get(26)).equals("E")) //Commented for MMS-QH-CRF-0069 [IN:037977]
				DfltLangForDispLabelIPEng = "selected";
			else if (((String)arrList.get(26)).equals("L"))
				DfltLangForDispLabelIPLoc   = "selected";
			else if (((String)arrList.get(26)).equals("B"))
				DfltLangForDispLabelIPBoth = "selected";*/

			if (((String)arrList.get(27))!=null){
				if (((String)arrList.get(27)).equals("D"))
					IPLabelFormatDrug = "selected";
				else if (((String)arrList.get(27)).equals("C"))
					IPLabelFormatCombined = "selected";
			}

			if (arrList.get(28)!=null)
				OPDispLocnRtn_ord = (String)arrList.get(28);
			if (arrList.get(29)!=null)
				OPDispLocnStat_ord = (String)arrList.get(29);
			if (arrList.get(30)!=null)
				IPDispLocnRtn_ord = (String)arrList.get(30);
			if (arrList.get(31)!=null)
				IPDispLocnStat_ord = (String)arrList.get(31);
			if (arrList.get(32)!=null)
				DischMedDispLocn = (String)arrList.get(32);
			if (((String)arrList.get(33)).equals("Y"))
				PrintBalMedSheetOPYN    ="checked";
			if (arrList.get(34)!=null){
				DispVerfStageCode = (String)arrList.get(34);
				if (((String)arrList.get(34)).equals("F"))
					DispVerfStageValue = "Separate Before "+(String)param_legends.get("F");
				else if(((String)arrList.get(34)).equals("C"))
					DispVerfStageValue = "Combined With "+(String)param_legends.get("A");
				else if(((String)arrList.get(34)).equals("B"))
					DispVerfStageValue = "Separate Before "+(String)param_legends.get("A");
			}
			if (arrList.get(35)!=null){
				DispFillStage=((String)arrList.get(35));
				if(DispFillStage.equals("A")){
					selectDispFillStageBefore = "";
					selectDispFillStageAfter = "selected";
					selectDispFillStageNA="";
				}
				else if(DispFillStage.equals("B")){
					selectDispFillStageBefore = "selected";
					selectDispFillStageAfter = "";
					selectDispFillStageNA="";
				}
				else{
					selectDispFillStageBefore = "";
					selectDispFillStageAfter = "";
					selectDispFillStageNA="selected";
				}
			}
				if(arrList.get(36) != null){
					med_admin_reqd_yn =(String)arrList.get(36);
					if(med_admin_reqd_yn.equals("Y"))
						med_admin_reqd_yn = "checked";
				}

				if(arrList.get(37) != null){
					verf_reqd_bef_med_admin_yn =(String)arrList.get(37);
					if(verf_reqd_bef_med_admin_yn.equals("Y"))
						verf_reqd_bef_med_admin_yn = "checked";
				}

				if(arrList.get(38) != null)
					rec_admin_within_hrs =(String)arrList.get(38);

				if(arrList.get(39) != null){
					allow_med_admin_wo_ord_yn =(String)arrList.get(39);
					if(allow_med_admin_wo_ord_yn.equals("Y")){
						allow_med_admin_wo_ord_yn = "checked";
						witness_for_verbal_order_disable = "";}		// Added for AAKH-CRF-0023[IN:038259]
				}
				if(arrList.get(134) != null && arrList.get(134).equals("Y")){	// Added for AAKH-CRF-0023[IN:038259]
					witness_for_verbal_order_yn = "checked";}					// Added for AAKH-CRF-0023[IN:038259]
				IPFillPrdAheadUnit = arrList.get(40).toString();

				if(arrList.get(41) != null){
					ip_consider_stock_status =(String)arrList.get(41);
					if(ip_consider_stock_status.equals("Y"))
						ip_consider_stock_status = "checked";
				}
				if(arrList.get(42) != null){
					ip_allow_stock_status =(String)arrList.get(42);
					if(ip_allow_stock_status.equals("Y"))
						ip_allow_stock_status = "checked";
				}

				if(arrList.get(43) != null){
					allow_duplicate_drug =(String)arrList.get(43);
					if(allow_duplicate_drug.equals("Y"))
						allow_duplicate_drug = "checked";
				}
				if(arrList.get(44) != null){
					AllowMednOrderWithoutDiag   =   (String)arrList.get(44);
					if (AllowMednOrderWithoutDiag.equals("Y")){
						AllowMednOrderWithoutDiag="checked";
					}
				}
				if(allowMednWithDiagDisableYn){ // Added for MMS-DM-CRF-0150.1 - Start
					AllowMednOrderWithoutDiag =""; // added for MMS-DM-CRF-0150.1
					allowMednWithDiagDisable ="disabled";
				} 
				else{
					disabled = "";
				} // Added for MMS-DM-CRF-0150.1 - End
				if(arrList.get(45) != null){
					AllowMednOrderWithoutWt   =   (String)arrList.get(45);
					if (AllowMednOrderWithoutWt.equals("Y"))
						AllowMednOrderWithoutWt="checked";
				}
				if(arrList.get(46) != null){
					UnallocOrderDelivery   =   (String)arrList.get(46);
					if (UnallocOrderDelivery.equals("Y"))
						UnallocOrderDelivery="checked";
				}
	
				if(arrList.get(47) != null){
					print_exp_date_on_lbl   =   (String)arrList.get(47);
					if (print_exp_date_on_lbl.equals("Y"))
						print_exp_date_on_lbl="checked";
				}
				if(arrList.get(48) != null){
					iv_admixture_appl_yn    =(String)arrList.get(48);
					if (iv_admixture_appl_yn.equals("Y"))
						iv_admixture_appl_yn="checked";
				}
				if(arrList.get(49) != null){
					cdr_admixture_appl_yn   =(String)arrList.get(49);
					if (cdr_admixture_appl_yn.equals("Y"))
						cdr_admixture_appl_yn="checked";
				}
			
				if(arrList.get(50) != null){
					tpn_regimen_appl_yn    =(String)arrList.get(50);
					if (tpn_regimen_appl_yn.equals("Y"))
						tpn_regimen_appl_yn="checked";
				}

				if(arrList.get(51) != null){
					working_hrs_of_prep_room_from   =(String)arrList.get(51);
					/*if(working_hrs_of_prep_room_from.equals("00:00")){
					working_hrs_of_prep_room_from="";
					}*/
				}
				if(arrList.get(52) != null){
					 working_hrs_of_prep_room_to   =(String)arrList.get(52);

					// if(working_hrs_of_prep_room_to.equals("00:00")){working_hrs_of_prep_room_to="";}
				}
					/* if(working_hrs_of_prep_room_from.equals("") && working_hrs_of_prep_room_to.equals("")){
					  charge_qty_ind_prepared="uncheched";
					  charge_qty_ind_stock="unchecked";
					} */
				if(arrList.get(53) != null){
					alert_practitioner_yn    =(String)arrList.get(53);
					if (alert_practitioner_yn.equals("Y"))
						alert_practitioner_yn="checked";
				}
				if(arrList.get(54) != null){
					verify_tdm_order_yn    =(String)arrList.get(54);
					if (verify_tdm_order_yn.equals("Y"))
						verify_tdm_order_yn="checked";
				}
				if(arrList.get(55) != null)
					tdm_result_type_id    =(String)arrList.get(55);
				if(arrList.get(56) != null)
					start_adr_no    =(String)arrList.get(56);
				if(arrList.get(57) != null)
					last_adr_no    =(String)arrList.get(57);
				if(arrList.get(58) != null)
					pat_couns_result_type_id    =(String)arrList.get(58);
				if(arrList.get(59) != null){
					direct_disp = (String)arrList.get(59);
					if(direct_disp.equals("Y")){
						direct_disp_chk="checked"; 
						disp = "display:inline";
					}
					else{
						if(direct_disp.equals("N")){
							direct_disp_chk="";
							disp = "display:none";
						}
					}	
				} 

				if(arrList.get(60) != null){
					pat_class = (String)arrList.get(60);
					if(pat_class.equals("O")){
						pat_clas_chk1="checked";
						pat_clas_chk3="";
						pat_clas_chk4="";
					}
					if(pat_class.equals("E")){
						pat_clas_chk2="checked";
						pat_clas_chk3="";
						pat_clas_chk4="";
					}
					if(pat_class.equals("X")){
						pat_clas_chk3="checked";
						pat_clas_chk4="";	
					}
					if(pat_class.equals("B"))
						pat_clas_chk4="checked";
				}
				else{
					pat_clas_chk4="checked";
				} 

				if(arrList.get(61) != null){
					app_enc = (String)arrList.get(61);
					if(app_enc.equals("O")){
						app_enc_chk1="checked";
						app_enc_chk3="";
					}
					if(app_enc.equals("C")){
						app_enc_chk2="checked";
						app_enc_chk3="";
					}
					if(app_enc.equals("B"))
						app_enc_chk3="checked";
				}
				else{
					app_enc_chk3="checked";
				} 

				if(arrList.get(62)!=null)
					last_enc =(String)arrList.get(62);
				else
					last_enc = "10";

				if(arrList.get(63)!= null){
					enc_during_disp = (String)arrList.get(63);
					if (enc_during_disp.equals("Y"))
						enc_during_disp_chk = "Checked";
					else{
						if(enc_during_disp.equals("N"))
							enc_during_disp_chk = "";
					}
				}

				if(arrList.get(64) != null){
					duplicate_check_atc   =   (String)arrList.get(64);
					if (duplicate_check_atc.equals("Y"))
						duplicate_check_atc="checked";
				}

				if(arrList.get(65) != null){
					remarks_for_prn = (String)arrList.get(65);
					if(remarks_for_prn.equals("Y")){
						remarks_for_prn="checked";
					}
				}
	//*******
		/*
			EnableInterfaceStockControl =   (String)arrList.get(0);
			if (EnableInterfaceStockControl.equals("Y"))
				EnableInterfaceStockControl="checked";
			else
				EnableInterfaceStockControl="disabled";
		*/ 

				if (bl_install_yn.equals("Y")){
					display_charge_details_lkp="enabled";
					display_charge_details_prescription="enabled";
					display_price_type_lkp="enabled";
				}
				else{
					display_charge_details_lkp="disabled";
					display_charge_details_prescription="disabled";
					display_price_type_lkp="disabled";
				}

	// Applicable orders. 

				if(arrList.get(66) != null){
					comp_rx_chk = (String)arrList.get(66);
					if(comp_rx_chk.equals("Y")){
						comp_rx_chk="checked";
					}
				}

				if(arrList.get(67) != null){
					iv_rx_chk = (String)arrList.get(67);
					if(iv_rx_chk.equals("Y")){
						iv_rx_chk="checked";
					}
				}

				if(arrList.get(68) != null){
					oncology_rx_chk_val = (String)arrList.get(68);
					if(oncology_rx_chk_val.equals("Y")){
						oncology_rx_chk="checked";
						oncology_rx_chk_status="enabled";
					}
					else{
						oncology_rx_chk="";
						oncology_rx_chk_status="disabled";
					}
				}

				if(arrList.get(69) != null){
					tpn_rx_chk_val = (String)arrList.get(69);
					if(tpn_rx_chk_val.equals("Y")){
						tpn_rx_chk="checked";
						tpn_rx_chk_status="enabled";
					}
					else{
						tpn_rx_chk="";
						tpn_rx_chk_status="disabled";
					}
				}

				if(arrList.get(70) != null){
					tdm_order_chk = (String)arrList.get(70);
					if(tdm_order_chk.equals("Y"))
						tdm_order_chk="checked";
				}

				if(arrList.get(71) != null){
					tdm_result_type = (String)arrList.get(71);
					if(tdm_result_type.equals("D")){
						tdm_result_type_select_1="selected";
						tdm_result_type_desc=bean.GetDiscMsrPanelDesc(tdm_result_type_id);
					}
					else if(tdm_result_type.equals("N")){
						tdm_result_type_select_2="selected";
						tdm_result_type_desc=bean.GetNoteTypeDesc(tdm_result_type_id);
					}
				}
	  
				if(arrList.get(72) != null){
					pat_couns_result_type = (String)arrList.get(72);
					if(pat_couns_result_type.equals("D")){
						pat_couns_result_type_select_1  =  "selected";
						pat_couns_result_type_desc      =  bean.GetDiscMsrPanelDesc(pat_couns_result_type_id);
					}
					else if(pat_couns_result_type.equals("N")){
						pat_couns_result_type_select_2  =  "selected";
						pat_couns_result_type_desc      =   bean.GetNoteTypeDesc(pat_couns_result_type_id);
					}
				}
				if(arrList.get(73) != null){
					Daycare_yn = (String)arrList.get(73);
					if(Daycare_yn.equals("Y")){
						Daycare_yn="checked"; 
						daycare_yn_rule_disab="";   //   RUT-CRF-0062 [IN029600]  Added  to enable Rule Based Checkbox
					}
				}

				if(arrList.get(74) != null){
					emergency_yn = (String)arrList.get(74);
					if(emergency_yn.equals("Y")){
						emergency_yn="checked";
						emergency_yn_rule_disab="";   //   RUT-CRF-0062 [IN029600]  Added  to enable Rule Based Checkbox
					}
				}

				if(arrList.get(75) != null){
					inpatient_yn = (String)arrList.get(75);
					if(inpatient_yn.equals("Y")){
							inpatient_yn="checked";
							inpatient_yn_rule_disab="";   //   RUT-CRF-0062 [IN029600]  Added  to enable Rule Based Checkbox
					}
				}

				if(arrList.get(76) != null){
					Outpatient_yn = (String)arrList.get(76);
					if(Outpatient_yn.equals("Y")){
						Outpatient_yn="checked";
						outpatient_yn_rule_disab="";   //   RUT-CRF-0062 [IN029600]  Added  to enable Rule Based Checkbox
					}
				}

				if(arrList.get(77) != null){
					DISP_CHARGE_DTL_IN_DRUG_LKP_YN = (String)arrList.get(77);
					if(DISP_CHARGE_DTL_IN_DRUG_LKP_YN.equals("N"))
						value="disabled";
			
					if(DISP_CHARGE_DTL_IN_DRUG_LKP_YN.equals("Y"))
						DISP_CHARGE_DTL_IN_DRUG_LKP_CHK="checked";
				}

				if(arrList.get(78) != null){
					DISP_CHARGE_DTL_IN_RX_YN = (String)arrList.get(78);

					if(DISP_CHARGE_DTL_IN_RX_YN.equals("Y"))
						DISP_CHARGE_DTL_IN_RX_YN="checked";
				}

				if(arrList.get(79) != null){
					DISP_PRICE_TYPE_IN_DRUG_LKP = (String)arrList.get(79);
					if(DISP_PRICE_TYPE_IN_DRUG_LKP.equals("NULL"))
						DISP_PRICE_TYPE_IN_DRUG_LKP="X";
				}
				
				if(arrList.get(80)!=null){
					Disch_Med_Mar_Appl_yn=(String)arrList.get(80);
					if(Disch_Med_Mar_Appl_yn.equals("Y")){
						Disch_Med_Mar_Appl_yn="checked";
						dischmedic_yn_rule_disab="";  //  RUT-CRF-0062 [IN029600]  Added to enable rule based check box
						}
				}

				if(arrList.get(81) != null){
					admx_prep_charges_appl_yn    =(String)arrList.get(81);
					if (admx_prep_charges_appl_yn.equals("Y"))
						admx_prep_charges_appl_yn="checked";
				}
				
				if(arrList.get(82) != null){
					split_based_priority_yn=(String)arrList.get(82);
					if (split_based_priority_yn.equals("Y"))
						split_based_priority_yn="checked";
				}
	
				if(arrList.get(83) != null){
					split_based_drug_class_yn    =(String)arrList.get(83);
					if (split_based_drug_class_yn.equals("Y"))
						split_based_drug_class_yn="checked";
				}

				if(arrList.get(84) != null)
					dflt_dir_disp_locn1    =(String)arrList.get(84);					
				
				if(arrList.get(85) != null)
					dflt_dir_disp_locn2    =(String)arrList.get(85);					
				
				if(arrList.get(86) != null)
					tpn_screening_form_id    =(String)arrList.get(86);
								
				if(arrList.get(87) != null){
					tpn_screening_type = (String)arrList.get(87);
					if(tpn_screening_type.equals("D")){
						tpn_screening_type_select_1="selected";
						tpn_screening_type_desc=bean.GetDiscMsrPanelDesc(tpn_screening_form_id);
					}
					else if(tpn_screening_type.equals("N")){
						tpn_screening_type_select_2="selected";
						tpn_screening_type_desc=bean.GetNoteTypeDesc(tpn_screening_form_id);
					}
				}

				if(arrList.get(88) != null)
					oncology_screening_form_id    =(String)arrList.get(88);
				
					if(arrList.get(89) != null){
						oncology_screening_type = (String)arrList.get(89);
						if(oncology_screening_type.equals("D")){
						   onc_screening_type_select_1="selected";
						   onc_screening_type_desc=bean.GetDiscMsrPanelDesc(oncology_screening_form_id);
						}
						else if(oncology_screening_type.equals("N")){
							onc_screening_type_select_2="selected";
							onc_screening_type_desc=bean.GetNoteTypeDesc(oncology_screening_form_id);
						}
					 }

					if(arrList.get(90) != null){
						drug_cat_pin_auth_reqd_yn =(String)arrList.get(90);
						if(drug_cat_pin_auth_reqd_yn.equals("Y"))
							drug_cat_pin_auth_reqd_yn = "checked";
						else if (med_admin_reqd_yn.equals("N"))
							drug_cat_pin_auth_reqd_yn = " disabled ";
					}
					if(arrList.get(91) != null){
						all_shrt_expry_drgs =(String)arrList.get(91);
						if(all_shrt_expry_drgs.equals("Y"))
							all_shrt_expry_drgs = "checked";
						else 
							all_shrt_expry_drgs = "";
					}
					if(arrList.get(92) != null){
						copy_pres_upto_no_of_days =(String)arrList.get(92);
						if(copy_pres_upto_no_of_days == null)
							copy_pres_upto_no_of_days="";
					}
					//added for INCLUDE ZERO ALLOC ITEMS on 07-03-09
					if (((String)arrList.get(93)).equals("Y"))
						includeZeroAllocatedItemsOPYN="checked";

					if (arrList.get(94) != null){
						rec_admin_bef_schdle_time =(String)arrList.get(94);
						if(rec_admin_bef_schdle_time == null)
							rec_admin_bef_schdle_time="";
					}
					if (arrList.get(95) != null){
						rec_admin_bef_schdle_time_UOM =(String)arrList.get(95);
						if(rec_admin_bef_schdle_time_UOM == null)
							rec_admin_bef_schdle_time_UOM="";
						if(rec_admin_bef_schdle_time_UOM.equals("H"))
							rec_admin_bef_schdle_time_selH="selected";
						else
							rec_admin_bef_schdle_time_selM="selected";
					}
			
					if(((String)arrList.get(96)).equals("Y"))
						IPDailySeqNoYN="checked";
					//Added for CRF-0439  To add dispensing locking facility
					if(arrList.get(97) != null){
						allowDispRecordLockYN =(String)arrList.get(97);
						if(allowDispRecordLockYN.equals("Y"))
							allowDispRecordLockYN = "checked";
						else 
							allowDispRecordLockYN = "";
					}
					//Added for CRF-711  Prompt Alert for Preferred Item
					if(arrList.get(98) != null){
						promptAlertForPreferredItem =(String)arrList.get(98);
						if(promptAlertForPreferredItem.equals("Y"))
							promptAlertForPreferredItem = "checked";
						else 
							promptAlertForPreferredItem = "";
					}
					//Added for CRF-641  Default Privilege Drug Selection
					if(arrList.get(99) != null){
						defaultPrivilegeDrugSelection =(String)arrList.get(99);	
					}
					if(arrList.get(100) != null){
						displayUOMInTransaction =(String)arrList.get(100);	
					}
					if(arrList.get(101) != null){
						narcoticAprvlFormReqYN =(String)arrList.get(101);
						if(narcoticAprvlFormReqYN.equals("Y"))
							narcoticAprvlFormReqYN = "checked";
						else 
							narcoticAprvlFormReqYN = "";
					}
					if(arrList.get(102) != null){
						printNarcoticFormByDefaultYN =(String)arrList.get(102);
						if(printNarcoticFormByDefaultYN.equals("Y"))
							printNarcoticFormByDefaultYN = "checked";
						else 
							printNarcoticFormByDefaultYN = "";
					}
					if(narcoticAprvlFormReqYN.equals("checked")){
						printNarcoticFormByDefault="";
					}
					else{
						printNarcoticFormByDefault="disabled";
					}
					if(arrList.get(103) != null){
						edit_disp_label_after_del =(String)arrList.get(103);
						if(edit_disp_label_after_del.equals("Y"))
							edit_disp_label_after_del = "checked";
						else 
							edit_disp_label_after_del = "";
					}

					if(arrList.get(104) != null){	
						rx_qty_by_pres_base_uom_yn =(String)arrList.get(104);
						if(rx_qty_by_pres_base_uom_yn.equals("Y"))
							rx_qty_by_pres_base_uom_yn = "checked";
						else 
							rx_qty_by_pres_base_uom_yn = "";
					}

					if(arrList.get(105)!= null){
						dflt_ip_fill_incr_start_with = (String)arrList.get(105);
					}
					
					//  RUT-CRF-0062 [IN029600]  Added for Build MAR Rule Based Flag -- begin
					if(arrList.get(106)!= null){
						inpatient_yn_rule_check = (String)arrList.get(106);
						if(inpatient_yn_rule_check.equals("Y"))
							inpatient_yn_rule_check="checked";
					}
					
					if(arrList.get(107)!= null){
						outpatient_yn_rule_check = (String)arrList.get(107);
						if(outpatient_yn_rule_check.equals("Y"))
							outpatient_yn_rule_check="checked";
					}
					
					if(arrList.get(108)!= null){
						daycare_yn_rule_check = (String)arrList.get(108);
						if(daycare_yn_rule_check.equals("Y"))
							daycare_yn_rule_check="checked";
					}
					if(arrList.get(109)!= null){
						emergency_yn_rule_check = (String)arrList.get(109);
						if(emergency_yn_rule_check.equals("Y"))
							emergency_yn_rule_check="checked";
					}
					if(arrList.get(110)!= null){
						dischmedic_yn_rule_check = (String)arrList.get(110);
						if(dischmedic_yn_rule_check.equals("Y"))
							dischmedic_yn_rule_check="checked";
					}
					//  RUT-CRF-0062 [IN029600]  Added for Build MAR Rule Based Flag -- end
					if(arrList.get(111)!= null){
						atc_allergy_alert_level = (String)arrList.get(111);
					}
					if(arrList.get(112)!= null){
						tab_based_group_sort_disp =(((String)arrList.get(112)).equals("Y"))?"Checked":"";
					}
					if(arrList.get(113)!= null){//IN30118-SCF No: MO-GN-5400. Checking Duplicate Drug Flag for OP.
						allow_duplicate_drug_op =(((String)arrList.get(113)).equals("Y"))?"Checked":"";
					}
					if(arrList.get(114)!= null){ //if block added for Bru-HIMS-CRF-265 [IN:032315]
						discont_canc_dup_medic =(((String)arrList.get(114)).equals("Y"))?"Checked":"";
					}
					if(arrList.get(115)!= null){ //if block added for ML-BRU-SCF-0636 [IN036826]
						disp_exp_orders_yn =(((String)arrList.get(115)).equals("Y"))?"Checked":"";
					}
					if(arrList.get(116)!= null){ //if block added for RUT-CRF-0035 [IN029926]
						pin_auth_mar_yn =(((String)arrList.get(116)).equals("Y"))?"Checked":"";
					}
					if(arrList.get(117) != null){// if block added for MMS-QH-CRF-0068 [IN:037980]
						allow_medn_ord_without_diag_for_dd   =   (String)arrList.get(117);
						if (allow_medn_ord_without_diag_for_dd.equals("Y"))
							allow_medn_ord_without_diag_for_dd="checked";
					}
					if(arrList.get(118)!= null){//if block Added for  MMS-QH-CRF-0080 [IN:038064] 
						print_mar_label_yn = (String)arrList.get(118)==null?"N":(String)arrList.get(118);
						if(print_mar_label_yn.equals("Y"))
							print_mar_label_yn="checked";
					} 
					if(arrList.get(119)!= null){//if block Added for  MMS-QH-CRF-0080 [IN:038064] -start
						alt_drug_remarks_ind = (String)arrList.get(119)==null?"N":(String)arrList.get(119);
					} 
					//added for SKR-CRF-0037 [IN:037656] - Start
					if(arrList.get(120)!= null){//if block Added for  MMS-QH-CRF-0080 [IN:038064] -start
						mar_sch_level_yn = (String)arrList.get(120)==null?"N":(String)arrList.get(120);
					} 
					if(arrList.get(121)!= null){
						mar_start_ind = (String)arrList.get(121)==null?"N":(String)arrList.get(121);
					} 
 					if(arrList.get(122)!= null){
						mar_week_day_start = (String)arrList.get(122)==null?"N":(String)arrList.get(122);
					} 
					if(arrList.get(123)!= null){
						mar_past_day = (String)arrList.get(123)==null?"N":(String)arrList.get(123);
					} 
					if(arrList.get(124)!= null){
						mar_future_day = (String)arrList.get(124)==null?"N":(String)arrList.get(124);
					} 
					if(arrList.get(125)!= null){
						mar_default_order_by = (String)arrList.get(125)==null?"N":(String)arrList.get(125);
					} 
					if(arrList.get(126)!= null){
						mar_disc_dose_yn = (String)arrList.get(126)==null?"N":(String)arrList.get(126);
					} 
					if(arrList.get(127)!= null){
						mar_iv_compl_dt_ind = (String)arrList.get(127)==null?"I":(String)arrList.get(127);
					} 
					if(arrList.get(130)!= null){//Added for AMS-CRF-0009[IN:030935] -start
						DispBeforeStartDateYN_IP = (String)arrList.get(130)==null?"N":(String)arrList.get(130);
						if(DispBeforeStartDateYN_IP.equals("Y")){
							DispBeforeStartDateYN_IP_checked="Checked";
							NoOfDays_Disabled = "";
						}
					} 
					if(arrList.get(131)!= null){
						DispBeforeNoOfDaysValue_IP = (String)arrList.get(131)==null?"":(String)arrList.get(131);
					} 
					if(arrList.get(132)!= null){
						DispBeyondEarliestStartYN_IP = (String)arrList.get(132)==null?"N":(String)arrList.get(132);
						if(DispBeyondEarliestStartYN_IP.equals("Y")){
							DispBeyondEarliestStartYN_IP_checked="Checked";
							EarliestStart_Disabled="";
						}
					} 
					if(arrList.get(133)!= null){
						DispBeyondNoOfDaysValue_IP = (String)arrList.get(133)==null?"":(String)arrList.get(133);
					} //Added for AMS-CRF-0009[IN:030935] -end
					if(mar_start_ind.equals("S") || mar_week_day_start.equals("")){
						mar_week_day_start_disp = "display:inline";
						defDispDayUserDefined_disp = "display:none";
					}
					else if(mar_start_ind.equals("U")){
						mar_week_day_start_disp = "display:none";
						defDispDayUserDefined_disp = "display:inline";
					}
					else if(mar_start_ind.equals("C")){
						mar_week_day_start_disp = "display:none";
						defDispDayUserDefined_disp = "display:none";
					}
					if(mar_sch_level_yn.equals("Y")){
						mar_sch_level_disable = "";
						mar_sch_level_chk = "checked";
					}
					if(mar_disc_dose_yn.equals("Y"))
						mar_disc_dose_chk = "checked";
					//added for SKR-CRF-0037 [IN:037656] -end
					if(arrList.get(128)!= null){ //added for RUT-CRF-0064.1 [IN:041799]
						allergy_conf_reqd_yn = (String)arrList.get(128)==null?"N":(String)arrList.get(128);
						if(allergy_conf_reqd_yn.equals("Y")){
							allergy_conf_check = "checked";
						}
					} 
					if(arrList.get(129)!= null){ //added for [IN:043283]
						mar_disp_held_disc_orders_yn = (String)arrList.get(129)==null?"N":(String)arrList.get(129);
						if(mar_disp_held_disc_orders_yn.equals("Y")){
							mar_disp_held_disc_check = "checked";
						}
					} 
					strDefaultFreqforIV = (String)arrList.get(135); 	//Added for Bru-HIMS-CRF-384[IN041642]
					em_medctn_fwd_ip_yn = (String)arrList.get(136); 	//Added for Bru-HIMS-CRF-402[IN044065]
					cary_frwd_ord_nofhrs = (String)arrList.get(137); 	//Added for Bru-HIMS-CRF-402[IN044065]
					disp_rx_duration_yn = (String)arrList.get(138); 	//Added for Bru-HIMS-CRF-403[IN044541] -start
					if(disp_rx_duration_yn.equals("Y"))
						disp_rx_duration_check="checked";//Added for Bru-HIMS-CRF-403[IN044541] -End
					diag_for_medn_order_by = (String)arrList.get(139); //Added for  MMS-SCF-0325 [IN:048069]
				    if(allowMednWithDiagDisableYn){ // Added for MMS-DM-CRF-0150.1 - Satrt
				    	diag_for_medn_order_by = "P";
				    } // Added for MMS-DM-CRF-0150.1 - End
					allow_mar_share_drug_yn = (String)arrList.get(140); 	//Added for HSA-CRF-0090 [IN:041241] -start
					if(allow_mar_share_drug_yn.equals("Y"))
						allow_mar_share_drug_check="checked";//Added for HSA-CRF-0090 [IN:041241] -End
					allow_renew_from_chart_summ_yn = (String)arrList.get(141);//Added for Bru-HIMS-CRF-400
					if(allow_renew_from_chart_summ_yn.equals("Y"))
						allow_renew_from_chart_summ_yn="checked";
					can_discon_dup_orders_def_sel = (String)arrList.get(142);//Added for HSA-CRF-0151 [IN048468]
					if(!discont_canc_dup_medic.equals("Checked"))
						can_discon_dup_orders_def_sel="disabled";
					else if(can_discon_dup_orders_def_sel.equals("Y"))
						can_discon_dup_orders_def_sel="checked";
					if(((String)arrList.get(143)).equals("Y"))//Added for Bru-HIMS-CRF-399 [IN:043767]
						allow_mar_alternate_drug_check = "checked";
					if(((String)arrList.get(144)).equals("Y"))//Added for ML-MMOH-CRF-0341 [IN:057179]
						preview_rx_yn_check = "checked"; 
					if(((String)arrList.get(145)).equals("Y"))//Added for ML-MMOH-CRF-0346 [IN:057185]
						disp_prev_vital_signs_yn_check = "checked"; 
					generic_code = (String)arrList.get(146);//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
					working_hours_from = (String)arrList.get(147);//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
					working_hours_to = (String)arrList.get(148);//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 02/02/2016
					String dispMedRestrSelect = (String)arrList.get(154)==null?"":(String)arrList.get(154);  // Added for GHL-CRF-0412.3 - Start	
					 if(dispMedRestrSelect.equals("N")){
						 defaultSelect1 = "selected";
					 }
					 else if(dispMedRestrSelect.equals("I")){
                        			 defaultSelect1  = "";
						 dischPatSelected = "";
						 prepaDisAdvSelected ="";
						 initPreSelected = "selected";
						 } 
					 else if(dispMedRestrSelect.equals("P")){
						 prepaDisAdvSelected = "selected"; 
					      defaultSelect1  = "";
						 dischPatSelected = "";
						 initPreSelected = "";
					 }
					 else if(dispMedRestrSelect.equals("D")){
						 dischPatSelected = "selected"; 
						 defaultSelect1  = "";
						 prepaDisAdvSelected ="";
						 initPreSelected = "";
					 }// Added for GHL-CRF-0412.3 - End
					//Added by prathyusha for JD-CRF-198 start
					if(arrList.get(149) != null){
						
						allow_amend_alt_drug_dtl_val = (String)arrList.get(149);
						/* System.out.println("Allow_Amending_of_Alternate_DRug_Details_Value=============1321========"+allow_amend_alt_drug_dtl_val); */
						if(allow_amend_alt_drug_dtl_val.equals("Y")){
							
							allow_amend_alt_drug_dtl_chk="checked";
							allow_amend_alt_drug_dtl_val="Y";
						}
						else{
							allow_amend_alt_drug_dtl_chk="";
							allow_amend_alt_drug_dtl_val="N";
						}
					}
					//Added by prathyusha for JD-CRF-198 end
				 //Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 start
					overlap_duration_op_val=(String)arrList.get(152) ==null?"":(String)arrList.get(152);
					overlap_duration_ip_val=(String)arrList.get(153) ==null?"":(String)arrList.get(153);
				//Added for for MO-CRF-20085.1  modified By Prathyusha on 05/26/2016 end
					//Added for MO-CRF-20085.1  By Prathyusha on 05/18/2016 start
					if(arrList.get(43) != null){
						if(allow_duplicate_drug.equalsIgnoreCase("checked")){

									skip_duplicate_alert_ip_disp = "enabled";
									skip_duplicate_alert_ip_val=(String)arrList.get(150);
									if(skip_duplicate_alert_ip_val.equalsIgnoreCase("Y")){
										skip_duplicate_alert_ip_chk= "checked";
										skip_duplicate_alert_ip_val="Y";
										skip_duplicate_alert_ip_disp = "enabled";
										//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 start
										overlap_duration_ip_disp = "enabled";
										overlap_duration_ip_val=overlap_duration_ip_val;
										//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 end
										}
									else{
										skip_duplicate_alert_ip_chk= "";
										skip_duplicate_alert_ip_val="N";
										skip_duplicate_alert_ip_disp = "enabled";
										//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 start
										overlap_duration_ip_disp = "enabled";
										overlap_duration_ip_val="";
										//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 end
										}
									}
								else{
										skip_duplicate_alert_ip_chk= "";
										skip_duplicate_alert_ip_val="N";
										skip_duplicate_alert_ip_disp = "disabled";
										//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 start
										overlap_duration_ip_val="";
										overlap_duration_ip_disp="disabled";
										//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 end
									}

						}
					if(arrList.get(113) != null){
						if(allow_duplicate_drug_op.equalsIgnoreCase("checked")){
			
										skip_duplicate_alert_op_disp = "enabled";
										skip_duplicate_alert_op_val=(String)arrList.get(151);
										if(skip_duplicate_alert_op_val.equalsIgnoreCase("Y")){
											skip_duplicate_alert_op_chk= "checked";
											skip_duplicate_alert_op_val="Y";
											skip_duplicate_alert_op_disp = "enabled";
											//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 start
											overlap_duration_op_val=overlap_duration_op_val;
											overlap_duration_op_disp="enabled";
											//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 end
										}
										else{
											skip_duplicate_alert_op_chk= "";
											skip_duplicate_alert_op_val="N";
											skip_duplicate_alert_op_disp = "enabled";
											//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 start
											overlap_duration_op_val="";
											overlap_duration_op_disp="disabled";
											//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 end
											}
							    }
							else{
								skip_duplicate_alert_op_chk= "";
								skip_duplicate_alert_op_val="N";
								skip_duplicate_alert_op_disp = "disabled";
								//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 start
								overlap_duration_op_disp = "disabled";
								overlap_duration_op_val="";
								//Added for for MO-CRF-20085.1 modified  By Prathyusha on 05/26/2016 end
								}

						}
					//Added for MO-CRF-20085.1  By Prathyusha on 05/18/2016 start
					//added for ml-mmoh-crf-0864 started//moved this fix from down to here for AYH-SCF-0003
					if(arrList.get(155) != null){
						 split_drug_based_auth_yn = (String)arrList.get(155)==null?"":(String)arrList.get(155); 
						 if (split_drug_based_auth_yn.equals("Y"))
							 split_drug_based_auth_yn="checked";
					}
					
					//added for ml-mmoh-crf-0864 end  till here for AYH-SCF-0003
					//Adding start for ML-BRU-CRF-0473
					if(arrList.get(156) != null){
						 includeZeroAllocatedItemsIPYN = (String)arrList.get(156)==null?"":(String)arrList.get(156); 
						 if (includeZeroAllocatedItemsIPYN.equals("Y"))
							 includeZeroAllocatedItemsIPYN="checked";
					}
					//Adding end for ML-BRU-CRF-0473
					if(arrList.get(157) != null){
						assesment_req_yn = (String)arrList.get(157)==null?"":(String)arrList.get(157); 
						 if (assesment_req_yn.equals("Y"))
							 assesment_req_yn="checked";
					}
					if(arrList.get(158) != null){ // Added for GHL-CRF-0482 [IN:064955] - Start
						late_or_early_admin_check = (String)arrList.get(158)==null?"":(String)arrList.get(158); 
						 if (late_or_early_admin_check.equals("Y"))
							 late_or_early_admin_check="checked";
					} // Added for GHL-CRF-0482 [IN:064955] - End
					
					//added for ghl-crf-0548 start
					allow_alternate_item_for_medical_item_yn = (String)arrList.get(159)==null?"":(String)arrList.get(159);//Added for Bru-HIMS-CRF-400
					if(allow_alternate_item_for_medical_item_yn.equals("Y"))
						allow_alternate_item_for_medical_item_yn="checked";
					//added for ghl-crf-0548 end
					//ADDED FOR MMS-KH-CRF-0014 START
					
					 ward_ack_required_yn = (String)arrList.get(160)==null?"N":(String)arrList.get(160);  	
					 if(ward_ack_required_yn.equals("Y")){
						 ward_ack_required_yn_checked = "checked";
					 }
					 else{
						 ward_ack_required_yn_checked = "";
					 }
					 ward_ack_mar_required_yn = (String)arrList.get(161)==null?"N":(String)arrList.get(161);  	
					 if(ward_ack_mar_required_yn.equals("Y")){
						 ward_ack_mar_required_yn_checked = "checked";
					 }
					 else{
						 ward_ack_mar_required_yn_checked = "";
					 }
					//ADDED FOR MMS-KH-CRF-0014 END
					//added for NMC-JD-CRF-0001 start
					display_generic_name_yn = (String)arrList.get(162)==null?"":(String)arrList.get(162);//Added for Bru-HIMS-CRF-400
					if(display_generic_name_yn.equals("Y"))
						display_generic_name_yn="checked";
					//added for NMC-JD-CRF-0001 end
		//added for mms-kh-crf-0016 start
			reconciliation_ip_val = (String)arrList.get(163)==null?"":(String)arrList.get(163);//Added for Bru-HIMS-CRF-400
					if(reconciliation_ip_val.equals("Y"))
						reconciliation_ip_chk="checked";
						//added for mms-kh-crf-0016 end
					//added for MMS-KH-CRF-0028 start
		review_aprrove_applicable_for_ip = (String)arrList.get(164)==null?"N":(String)arrList.get(164);
		 if(review_aprrove_applicable_for_ip.equals("Y")){
			 review_aprrove_applicable_for_ip_checked = "checked";
		 }
		 else{
			 review_aprrove_applicable_for_ip_checked = "";
		 }
		 review_aprrove_applicable_for_op = (String)arrList.get(165)==null?"N":(String)arrList.get(165);
		 if(review_aprrove_applicable_for_op.equals("Y")){
			 review_aprrove_applicable_for_op_checked = "checked";
		 }
		 else{
			 review_aprrove_applicable_for_op_checked = "";
		 }
		
		//added for MMS-KH-CRF-0028 END
			//added for AAKH-CRF-0117
		 approval_no_yn_ip = (String)arrList.get(166)==null?"N":(String)arrList.get(166);
		 //start commented for IN072991
		/* if(approval_no_yn_ip.equals("Y")){         
			 approval_no_yn_ip_checked = "checked";
		 }
		 else{
			 approval_no_yn_ip_checked = "";
		 }*/  //end commented for IN072991      
		 approval_no_yn_op = (String)arrList.get(167)==null?"N":(String)arrList.get(167);
		 if (arrList.get(168)!=null)
		 opDisMedLcn = (String)arrList.get(168)==null?"N":(String)arrList.get(168);// Added for 6041 
		  //start commented for IN072991
		 /*if(approval_no_yn_op.equals("Y")){  
			 approval_no_yn_op_checked = "checked";
		 }
		 else{
			 approval_no_yn_op_checked = "";
		 } */     //end commented for IN072991       
		 //added for AAKH-CRF-0117 - end
		 
			//Added for MMS-DM-CRF-0177
			pre_alloc_appl_yn = (String)arrList.get(169)==null?"N":(String)arrList.get(169);
		 
		   	if(pre_alloc_appl_yn.equals("Y"))
			{
			 pre_alloc_appl_checked="checked";
			}
				else
					{
					 pre_alloc_appl_checked="";
					}
		   
		 if(arrList.get(170) != null){
			 near_expiry_appl_yn = (String)arrList.get(170);
			 System.err.println("near_expiry_appl_yn==1=>" + near_expiry_appl_yn);
				if(near_expiry_appl_yn.equals("E")){
					near_expiry="checked";
					stock_level="";
					
				}
				else if(near_expiry_appl_yn.equals("S")){
					stock_level="checked";
					near_expiry="";
				}
		 }
		
		  if (arrList.get(171) != null){
				durn_value =(String)arrList.get(171);
				if(durn_value == null)
					durn_value="";
			}
		  
		  durn_type = (String)arrList.get(172)==null?"N":(String)arrList.get(172);
		  default_disp_locn = (String)arrList.get(174)==null?"":(String)arrList.get(174);//Added for TFS id:-16341
	
	//added for ML-MMOH-CRF-1637 - start
		  pat_trans_phar_type =(String)arrList.get(175)==null?"":(String)arrList.get(175);
		  pat_trans_other_type =(String)arrList.get(176)==null?"":(String)arrList.get(176);
		  disp_auto_refresh   = (String)arrList.get(178)==null?"":(String)arrList.get(178);//Added for TH-KW-CRF-0011

		  display_verif_drug_inst_remarks_yn=(String)arrList.get(179)==null?"":(String)arrList.get(179);//Added for ML-MMOH-CRF-1755
   
		if(display_verif_drug_inst_remarks_yn!=null && display_verif_drug_inst_remarks_yn.equals("Y"))
			display_verif_drug_inst_remarks_yn = "checked";
		else 
		   display_verif_drug_inst_remarks_yn = "";


		if(pat_trans_phar_type.equals("Y")){
			pat_trans_other_disabled = "";	
			pat_trans_phar_checked   = "checked";
			if(pat_trans_other_type.equals("Y"))
				pat_trans_other_checked   = "checked";
			else
				pat_trans_other_checked   = "";
		}else{
			pat_trans_other_disabled = "disabled";	
			pat_trans_other_checked   = "";
		} 
	//added for ML-MMOH-CRF-1637 - end

				if(durn_type=="")
				{
					durn_type="N";
				}
				if(durn_type.equals("N"))
					durn_type_N = "selected";
				else if(durn_type.equals("D"))
					durn_type_D = "selected";
				else if(durn_type.equals("M"))
					durn_type_M = "selected";
				else if(durn_type.equals("Y"))
					durn_type_Y = "selected";
		
		 if(pre_alloc_appl_checked.equals("checked")){
			    pre_alloc_disabled="";
		    }
			else{
				pre_alloc_disabled="disabled";
				stock_level="";
				near_expiry="";
			}
		 if(near_expiry.equals("checked"))
		 {
			 expiry_stock_val="";
		 }else{
			 expiry_stock_val="disabled";
		 }
		//Added for MMS-DM-CRF-0177
		
		  drug_indication_mdry=(String)arrList.get(177)==null?"N":(String)arrList.get(177);//added for JD-CRF-0220
		  if(drug_indication_mdry.equalsIgnoreCase("Y")){
			  drug_indication_mdry_chk="checked";  
		  }
		  else{
			  drug_indication_mdry_chk="";
		  }
		  
		  Amend_orderwise_DispMedication=(String)arrList.get(180)==null?"N":(String)arrList.get(180);//added for ml-mmoh-crf-1748 start
		  if(Amend_orderwise_DispMedication.equalsIgnoreCase("Y")){
			  Amend_orderwise_DispMedication_yn="checked";  
		  }
		  else{
			  Amend_orderwise_DispMedication_yn="";
		  }//added for ml-mmoh-crf-1748 end
		  
		  do_not_display_sensitive_diagnosis_yn=(String)arrList.get(181)==null?"N":(String)arrList.get(181);//added for ML-BRU-CRF-0630 start
		  if(do_not_display_sensitive_diagnosis_yn.equalsIgnoreCase("Y")){
			  do_not_display_sensitive_diagnosis_checked="checked";  
		  }
		  else{
			  do_not_display_sensitive_diagnosis_checked="";
		  }//added for  ML-BRU-CRF-0630 end
		  display_sensitive_diagnosis_indicator_yn=(String)arrList.get(182)==null?"N":(String)arrList.get(182);//added for ML-BRU-CRF-0630 start
		  if(display_sensitive_diagnosis_indicator_yn.equalsIgnoreCase("Y")){
			  display_sensitive_diagnosis_indicator_yn_checked="checked";  
		  }
		  else{
			  display_sensitive_diagnosis_indicator_yn_checked="";
		  }//added for  ML-BRU-CRF-0630 end

		 //Both cannot be Y
		  if(do_not_display_sensitive_diagnosis_yn.equalsIgnoreCase("N") && display_sensitive_diagnosis_indicator_yn.equalsIgnoreCase("N")){
				do_not_display_sensitive_diagnosis_disabled = ""; //user should be able to select it 
				display_sensitive_diagnosis_indicator_yn_disabled = ""; //user should be able to select it 
		  } else if(do_not_display_sensitive_diagnosis_yn.equalsIgnoreCase("Y") && display_sensitive_diagnosis_indicator_yn.equalsIgnoreCase("N")){
				do_not_display_sensitive_diagnosis_disabled = ""; //user should be able to select it 
				display_sensitive_diagnosis_indicator_yn_disabled = "disabled"; //Other one should be disabled and not able to select 
		  } else if(do_not_display_sensitive_diagnosis_yn.equalsIgnoreCase("N") && display_sensitive_diagnosis_indicator_yn.equalsIgnoreCase("Y")){
				do_not_display_sensitive_diagnosis_disabled = "disabled"; //Other one should be disabled and not able to select  
				display_sensitive_diagnosis_indicator_yn_disabled = ""; //user should be able to select it 
		  }
		
		  //added for NMC-JD-CRF-0186
		  mar_disp_unbilled_med=(String)arrList.get(183)==null?"N":(String)arrList.get(183);  //added for NMC-JD-CRF-0186
			if(mar_disp_unbilled_med.equals("Y")){
			  mar_disp_unbilled_med_yn="checked";
		  }else{
			  mar_disp_unbilled_med_yn="";
		  }
		  // Till here added or NMC-JD-CRF-0186

		  quota_limit_calculation_required_yn=(String)arrList.get(184)==null?"N":(String)arrList.get(184);//added for ML-MMOH-CRF-1823 start
		  if(quota_limit_calculation_required_yn.equalsIgnoreCase("Y")){
			  quota_limit_calculation_required_yn_checked="checked";  
			  active_prescription_enabled_for_quota_limit_yn_disabled = "";
		  }
		  else{
			  quota_limit_calculation_required_yn_checked="";
		  
		  }//added for ML-MMOH-CRF-1823 end

		  active_prescription_enabled_for_quota_limit_yn=(String)arrList.get(185)==null?"N":(String)arrList.get(185);//added for ML-MMOH-CRF-1823 start
		  if(active_prescription_enabled_for_quota_limit_yn.equalsIgnoreCase("Y")){
			  active_prescription_enabled_for_quota_limit_yn_checked="checked";  
		  }
		  else{
			  active_prescription_enabled_for_quota_limit_yn_checked="";
		  }

		  if(quota_limit_calculation_required_yn.equalsIgnoreCase("N")) { //Overwrite on this baed on quota_limit_calculation_required_yn_checked
			 active_prescription_enabled_for_quota_limit_yn_checked="";  
			 active_prescription_enabled_for_quota_limit_yn_disabled = "DISABLED"; 
		  }

		  //added for ML-MMOH-CRF-1823 end
		  
		//added for MMS-DM-CRF-0233-44841 by Ayesha 
		PrintPresDtlEnValue =  (String)arrList.get(186);
		PrintPresDtlLocValue =  (String)arrList.get(187);
		PrintFooterDtlsPresYN =  (String)arrList.get(188);
		if (arrList.get(188).equals("Y")){
			PrintFooterDtlsPresYN = "checked";
		}
		//Ended for MMS-DM-CRF0233-44841 by Ayesha

		always_display_dispense_location_yn						=(String)arrList.get(189)==null?"N":(String)arrList.get(189);//added for NMC-JD-CRF-0197 start
		  if(always_display_dispense_location_yn.equalsIgnoreCase("Y")){
			  always_display_dispense_location_yn_checked="checked";  
		  }
		  else{
			  always_display_dispense_location_yn_checked="";
		  }



		System.out.println("quota_limit_calculation_required_yn===="+quota_limit_calculation_required_yn+"active_prescription_enabled_for_quota_limit_yn"+active_prescription_enabled_for_quota_limit_yn+"Quota_limit_calculation_required_yn_checked=="+quota_limit_calculation_required_yn_checked+"==active_prescription_enabled_for_quota_limit_yn_disabled 1733"+active_prescription_enabled_for_quota_limit_yn_disabled+"==active_prescription_enabled_for_quota_limit_yn_checked"+active_prescription_enabled_for_quota_limit_yn_checked);
 	
		} // end if (arrList.size()>0)
			else{
				/*If there is no record in the PH_FACILITY_PARAM the following code will execute (Input Mode)
				If it is in input mode...First it will check for existence of the record in PH_PARAM
				If record exists it will default values from PH_PARAM other wise it will give an alert and go back. */
				chkForPHParamExistence=bean.checkForPHParamExistence();

				if (!chkForPHParamExistence){
%>
					<script>alert(getMessage("PH_PARAM_NOT_SETUP","PH")); window.location.href ='../../eCommon/jsp/dmenu.jsp'
					</script>
<%
				}
				else{
					//This is to check whether BL module is installed or not
					ArrayList defaultValues1 =(ArrayList) bean.checkForBLModuleExistence();
					if (defaultValues1.size()>0){
						if (!((String)defaultValues1.get(0)).equals("N")){
							BLInstalled ="Y";
							BLInstalledEnableDisable="";
						}
					}
					else{
						BLInstalled ="N";
						BLInstalledEnableDisable="disabled";
					}
	
					if (defaultValues.get(0).equals("Y"))
						EnableInterfaceStockControl = "checked enabled";
			
					if (EnableInterfaceStockControl.equals("checked enabled")){
						ConsiderStock   =   "checked enabled";
						AllowPresWithoutStock ="enabled";
						ip_consider_stock_status = "checked";
					}

					if (defaultValues.get(1).equals("Y"))
						RefillYN = "checked";
					else
						RefillYN = "disabled";

					if (defaultValues.get(1).equals("Y")){
						MaxNoOfRefillsAllowed   =   "enabled";
						MaxDurForRefillDesc     =   "enabled";
						PrintRefillDesc         =   "enabled";
						 
					}
					else{
						MaxNoOfRefillsAllowed   =   "disabled";
						MaxDurForRefillDesc     =   "disabled";
						PrintRefillDesc         =   "disabled";
					}

					if ((String)defaultValues.get(2) != null){
						MaxNoOfRefillsAllowedValue =(String) defaultValues.get(2);
						if (MaxNoOfRefillsAllowedValue.equals("0")){
							MaxNoOfRefillsAllowedValue = "";
						}
					}
					else
						MaxNoOfRefillsAllowedValue = "";

					if (((String)defaultValues.get(3)).equals("Y"))
						PrintRefillDesc ="checked";
			
					if (((String)defaultValues.get(4))!=null){
						MaxDurForRefillDescValue=((String)defaultValues.get(4));
						if(MaxDurForRefillDescValue.equals("0")){
							MaxDurForRefillDescValue="";
						}
					}
					else{
						MaxDurForRefillDescValue="";
					}

					if (((String)defaultValues.get(5)).equals("Y")){
						//DispBeforeStartDateYN	=	"checked";
						DispBeforeNoOfDaysValue =   (String)defaultValues.get(6);
					}
					else{
						DispBeforeStartDateYN	=	"disabled";
						DispBeforeNoOfDays="disabled";
					}

					String DispBeyondEarliestStartYNValue="";
					if (defaultValues.get(7) !=null)
						DispBeyondEarliestStartYNValue=(String)defaultValues.get(7);

					if ((DispBeyondEarliestStartYNValue).equals("Y")){
						DispBeyondNoOfDaysValue =   (String)defaultValues.get(8);
						DispBeyondEarliestStartYN = "checked";
					}
					else{
						DispBeyondEarliestStartYN="disabled";
						DispBeyondNoOfDays="disabled";
					}
					disp = "display:none";
				} // end else
			} // end else
			generic_name = bean.checkForNull((String) bean.fetchRecord(PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_FOR_ID"),new String[]{generic_code,locale}).get("GENERIC_NAME"),"");//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
			String sql_ph_generic_name_select_lookup=PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_LOOKUP_TDM"); //Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016
			String discrete_query     = PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT2D");
			String note_types_query   =  PhRepository.getPhKeyValue("SQL_PH_FACILITY_PARAM_SELECT2E");
			String note_types_scrng_query = "select note_type code,note_type_desc description from ca_note_type_lang_vw ca_note_type where eff_Status = 'E' and upper(note_type) like upper(?) and upper(note_type_desc) like upper(?) and note_group_id in (SELECT NOTE_GROUP FROM CA_NOTE_GROUP WHERE APPL_TASK_ID='PH_NOTES') and LANGUAGE_ID =";

			/*-------------------------code added for showing audit log---------------------------*/
			//primary_key_1  ------>FACILITY_ID
			//code for adding pk_values
			ArrayList Pk_values    =new ArrayList();
			Pk_values.add(facility_id);      

			String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
			pkey_value   ="";
			if(display_audit_log_button_yn.equals("Y")){
				audit_log_visible= "visibility:visible";
				pkey_value       = (String)log_bean.getpk_value();
			}
			else{
				audit_log_visible= "visibility:hidden";
				log_bean.clear();
			}
			
			
		//	if(arrList.get(166) != null){ 	// commented for IN072991	//Added for AAKH-CRF-1117
				
				if(approval_no_yn_ip.equals("Y"))
				{
					approval_no_yn_ip="Checked";
					}
				else
				{
					approval_no_yn_ip="";
				}
		//	} // commented for IN072991			
			
             // if(arrList.get(167) != null){ 	// commented for IN072991
				
				if(approval_no_yn_op.equals("Y"))
				{
					approval_no_yn_op="Checked";
					}
				else
				{
					approval_no_yn_op="";
				}
		//	} 	// commented for IN072991	
			//added for AAKH-CRF-117 - end
		/*--------------------------------------ends here---------------------------------------*/
  %>
		<form name="parameter_facility_form" id="parameter_facility_form">
			<!-- <table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="common_table">
				<tr>
					<td class="label" ><fmt:message key="ePH.InterfacetoInventoryManagement.label" bundle="${ph_labels}"/>
					</td>
					<td>&nbsp;
						<input type="checkbox" id="Interface to Inventory Management" name="interface_to_st_yn" id="interface_to_st_yn" value="Y" <%=EnableInterfaceStockControl%> onClick="validateInterfaceStockControl(this)">
					</td>
                    <td class="label"  ><fmt:message key="ePH.AllowMedicationOrderWithoutDiagnosis.label" bundle="${ph_labels}"/>
					</td>
					<td>&nbsp;
						<input type="checkbox" id="Allow Medication Order Without Diagnosis" name="allow_medn_order_without_diag" id="allow_medn_order_without_diag" value="Y"  <%=AllowMednOrderWithoutDiag%> >
					</td>
					<td><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></td>
				</tr>
				<tr style="display:none">
					<td class="label" style="display:none" ><fmt:message key="ePH.PatientInstructioninLocalLanguage.label" bundle="${ph_labels}"/></td>
					<td style="display:none">&nbsp;
						<input type="checkbox" id="Patient Instruction in Local Language" name="pat_instr_loc_lang_yn" id="pat_instr_loc_lang_yn" value="N" >
					</td>
					<td class="label" ><fmt:message key="ePH.AllowPaediatricMedicationOrderWithoutWeight.label" bundle="${ph_labels}"/>
					</td>
					<td>&nbsp;
						<input type="checkbox" id="Allow Medication Order Without Wieght" name="allow_medn_order_without_wt" id="allow_medn_order_without_wt" value="Y" checked>
					</td>
					<td></td>
				</tr>
<%
				if (!licenceRights.equals("PHBASIC")){
%>
					<tr>
						<td class="label"  ><fmt:message key="ePH.DisplayUnallocatedOrdersatDeliveryStage.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
							<input type="checkbox" id="Unallocated Orders at Delivery Stage" name="unalloc_order_del_st" id="unalloc_order_del_st" value="Y" <%=UnallocOrderDelivery%>>
						</td>
						<td class="label" ><fmt:message key="ePH.PrintExpiryDateforExpiredItemonlabel.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
							<input type="checkbox" name="print_exp_date_on_lbl" id="print_exp_date_on_lbl" value="Y" <%=print_exp_date_on_lbl%>></td>
						<td></td>
					</tr>
					<tr>
						<td  class="label" ><fmt:message key="ePH.DuplicatecheckforATCChemicalMainClass.label" bundle="${ph_labels}"/>
						</td>
						<td >&nbsp;
							<input type="checkbox" id="Duplicate check for ATC" name="duplicate_check_atc" id="duplicate_check_atc" value="Y" <%=duplicate_check_atc%> >
						</td>
						<td class="label" ><fmt:message key="ePH.MandatoryRemarksforPRNFrequency.label" bundle="${ph_labels}"/>
						</td> 
						<td>&nbsp;
							<input type="checkbox" name="remarks_for_prn" id="remarks_for_prn" value="Y" <%=remarks_for_prn%> >
						</td>
						<td></td>
					</tr>
		<!-- @ ****************************************--
					<tr>
						<td class="label"><fmt:message key="ePH.DisplayChargeDetailsinDrugLookup.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
							<input type="checkbox" id="DispChargedtls" name="display_charge_details_lkp" id="display_charge_details_lkp" value="Y" onClick="CheckList()"<%=DISP_CHARGE_DTL_IN_DRUG_LKP_CHK%>>
						</td>
						<td class="label"><fmt:message key="ePH.DisplayPriceTypeinDrugLookup.label" bundle="${ph_labels}"/></td>
						<td > <select name="display_price_type_lkp" id="display_price_type_lkp" id="DispPricelkp" <%=value%>>
						<OPTION value="P" <%=DISP_PRICE_TYPE_IN_DRUG_LKP.equals("P")?"selected":"" %>>Patient Specific</OPTION>
						<OPTION value="B" <%=DISP_PRICE_TYPE_IN_DRUG_LKP.equals("B")?"selected":"" %>>Base Price</OPTION>
<%
						if(DISP_CHARGE_DTL_IN_DRUG_LKP_YN.equals("N")){
%>
							<option value="" selected><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>		
<%
						}	
%>
						</select>
						</td>
						<td></td>	
					</tr>
					<tr>
						<td class="label"><fmt:message key="ePH.DisplayChargeDetailsinPrescriptions.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
							<input type="checkbox" name="display_charge_details_prescription" id="display_charge_details_prescription" value="Y" <%=DISP_CHARGE_DTL_IN_RX_YN%>>
						</td>
						<td class="label" ><fmt:message key="ePH.AllowShortExpiryDrugs.label" bundle="${ph_labels}"/>
						</td> 
						<td>&nbsp;
							<input type="checkbox" id="Allow Short Expiry Drugs" name="allow_short_expiry_drugs_yn" id="allow_short_expiry_drugs_yn" value="Y" <%=all_shrt_expry_drgs%>>
						</td>
						<td></td>
					</tr>
				   <tr>
						<td class="label" nowrap><fmt:message key="ePH.AllowCopyPrescriptionUptoDay.label" bundle="${ph_labels}"/>
						</td>
						 <td>&nbsp;&nbsp;<input type="text" size="3" name="copy_pres_upto_no_of_days" id="copy_pres_upto_no_of_days"  maxlength="3" class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);" value="<%=copy_pres_upto_no_of_days%>"/></td>
                         <!--  Added for CRF-0439  To add dispensing locking facility--
						<td class="label" nowrap><fmt:message key="ePH.AllowUserLocksforDuringDispensing.label" bundle="${ph_labels}"/>
						</td> 
						<td>&nbsp;
							<input type="checkbox" id="Allow User Locks for During Dispensing" name="allow_disp_record_lock_yn" id="allow_disp_record_lock_yn" value="Y" <%=allowDispRecordLockYN%>>
						</td>
						<td></td>
					</tr>
					<tr>
					<!-- code  Added for Display the UOM in Transaction --
						<td class="label" nowrap ><fmt:message key="ePH.DisplayUOMTransactions.label" bundle="${ph_labels}"/> 						
						</td> 
						<td>&nbsp;
							<select name="display_uom_transaction_by" id="display_uom_transaction_by">
						<OPTION value="C" <%=displayUOMInTransaction.equals("C")?"selected":"" %>><fmt:message key="Common.code.label" bundle="${common_labels}"/></OPTION>
						<OPTION value="D" <%=displayUOMInTransaction.equals("D")?"selected":"" %>><fmt:message key="Common.description.label" bundle="${common_labels}"/></OPTION>
						</select>
						</td>            
						<!-- code  ended for Display the UOM in Transaction --
						<!--  Added for CRF-641  Default Privilege Drug Selection --
					<td class="label" nowrap><fmt:message key="ePH.DefaultPrivilegeDrugSelection.label" bundle="${ph_labels}"/></td>
						<td > <select name="default_privilege_drug_selection" id="default_privilege_drug_selection" id="Default Privilege">
						<OPTION value="A" <%=defaultPrivilegeDrugSelection.equals("A")?"selected":"" %>><fmt:message key="ePH.ALLDRUGS.label" bundle="${ph_labels}"/></OPTION>
						<OPTION value="S" <%=defaultPrivilegeDrugSelection.equals("S")?"selected":"" %>><fmt:message key="ePH.SELFPRIVILEGEDRUGS.label" bundle="${ph_labels}"/></OPTION>
						</select>
						</td>
					</tr>
						<th colspan=5><fmt:message key="ePH.ApplicableOrders.label" bundle="${ph_labels}"/></th>
					<tr>
						<td class="label"  ><fmt:message key="ePH.CompoundingRx.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
							<input type="checkbox" id="Compounding Rx" name="compounding_rx" id="compounding_rx" value="Y" <%=comp_rx_chk%>>
						</td>
						<td class="label" ><fmt:message key="ePH.IntravenousRx.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
							<input type="checkbox" name="intravenous_rx" id="intravenous_rx" value="Y" <%=iv_rx_chk%>></td>
						<td></td>
					</tr>
					<tr>
						<td class="label" ><fmt:message key="ePH.OncologyRx.label" bundle="${ph_labels}"/></td>
						<td >&nbsp;
							<input type="checkbox" id="Oncology Rx" name="oncology_rx" id="oncology_rx" value="Y" onclick='OncologyChk(this)' <%=oncology_rx_chk%> >
						</td>
						<td class="label" ><fmt:message key="ePH.TPNRx.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
							<input type="checkbox" name="tpn_rx" id="tpn_rx" value="<%=tpn_rx_chk_val%>" onclick='SelectDefaultChk(this)'<%=tpn_rx_chk%>></td>
						<td></td>
					</tr>
					<tr>
						<td class="label" ><fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;
							<input type="checkbox" id="TDM" name="tdm" id="tdm" value="Y" <%=tdm_order_chk%> >
						</td>
						<td class="label" ></td>
						<td>&nbsp;</td>
						<td></td>
					</tr>
<%
				}
				else{
%>
					<input type="hidden" name="print_exp_date_on_lbl" id="print_exp_date_on_lbl" value="N">
					<input type="hidden" name="unalloc_order_del_st" id="unalloc_order_del_st" value="N">
					<input type="hidden" name="duplicate_check_atc" id="duplicate_check_atc" value="N">
					<input type="hidden" name="remarks_for_prn" id="remarks_for_prn" value="N">
<% 
				}
%>
			</table> -->
			<table cellpadding=0 cellspacing=0 width="94%"  align="left" border="0" id="patient_table">
				<tr>
					<td>
<%
						if (!licenceRights.equals("PHBASIC")){
%>
							<td width= "140%" class="white">
							<ul id="tablist" class="tablist" >
								<!-- Start of Add 1st part of CRF-713 INC 12785  for general tab-->
							   <li class="tablistitem" title='<fmt:message key="Common.general.label" bundle="${common_labels}"/>'>
									<a onclick="tab_click('general_tab')" class="tabClicked" id="general_tab" >
										<span class="tabSpanclicked" id="general_tabspan"><fmt:message key="Common.general.label" bundle="${common_labels}"/></span>
									</a>
								</li><!-- End of Add 1st part of CRF-713 INC 12785 for general tab-->
								<li class="tablistitem" title='<fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>'>
									<a onclick="tab_click('outpatient_tab')" class="tabA" id="outpatient_tab">
										<span class="tabAspan" id="outpatient_tabspan"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></span>
									</a>
								</li>
								<li class="tablistitem" title='<fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>'>
									<a onclick="Display_IP('inpatient_tab','<%=IPExists%>')" class="tabA" id="inpatient_tab" >
										<span class="tabAspan" id="inpatient_tabspan"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></span>
									</a>
								</li>
<%
								if( ((PhVersionNo.ALSDKFHADFKADFHG).equals("3")) ){
%>
									<li class="tablistitem" title='<fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/>'>
										<a onclick="tab_click('ivadmixture_tab')" class="tabA" id="ivadmixture_tab" >
											<span class="tabAspan" id="ivadmixture_tabspan"><fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/></span>
										</a>
									</li>
<%
								}
%>	
								<li class="tablistitem" title='<fmt:message key="Common.MedicationAdministration.label" bundle="${common_labels}"/>'>
									<a onclick="tab_click('medicationAdministration_tab')" class="tabA" id="medicationAdministration_tab" >
										<span class="tabAspan" id="medicationAdministration_tabspan"><fmt:message key="Common.MedicationAdministration.label" bundle="${common_labels}"/></span>
									</a>
								</li>
								<li class="tablistitem" title='<fmt:message key="ePH.ADRRules.label" bundle="${ph_labels}"/>'>
									<a onclick="tab_click('ADRRules_tab')" class="tabA" id="ADRRules_tab" >
										<span class="tabAspan" id="ADRRules_tabspan"><fmt:message key="ePH.ADRRules.label" bundle="${ph_labels}"/></span>
									</a>
								</li>
								<li class="tablistitem" title='<fmt:message key="ePH.DirectDispensingRules.label" bundle="${ph_labels}"/>'>
									<a onclick="tab_click('DirectDispensingRules_tab')" class="tabA" id="DirectDispensingRules_tab" >
										<span class="tabAspan" id="DirectDispensingRules_tabspan"><fmt:message key="ePH.DirectDispensingRules.label" bundle="${ph_labels}"/></span>
									</a>
								</li>
<%
								if((licenseValue.equals("Y"))&&(licenseYN.equals("Y"))){
%>
									<li class="tablistitem" title='<fmt:message key="ePH.DrugDataBaseInterface.label" bundle="${ph_labels}"/>'>
										<a onclick="tab_click('DrugDatabaseInterface_tab')" class="tabA" id="DrugDatabaseInterface_tab" >
											<span class="tabAspan" id="DrugDatabaseInterface_tabspan"><fmt:message key="ePH.DrugDataBaseInterface.label" bundle="${ph_labels}"/></span>
										</a>
									</li>
<%
								}
								else{
%>
									 <!-- <script>prevTabObj='outpatient_tab'</script>  CRF-713 INC 12785  for general tab  -->
									<script>prevTabObj='general_tab'</script>
<%
								}
%>
								</ul>
								</td>
<%
							}	//end if (!licenceRights.equals("PHBASIC"))
%>
							</td>
							<td></td>
						</tr>
					</table>
<% 
					if(licenceRights.equals("PHBASIC")) {
%>
						<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="inpatient_base_table" style="display:none">
							<th colspan="4"><fmt:message key="ePH.StockRules-Inpatient.label" bundle="${ph_labels}"/></th>
							<tr>
								<td class="label"><fmt:message key="ePH.ConsiderStock.label" bundle="${ph_labels}"/></td>
								<td>&nbsp;
									<input type="checkbox" name="ip_consider_stock" id="ip_consider_stock" value="Y" <%=ip_consider_stock_status%> onClick="checkAllowStock(this)" >
								</td>
								<td class="label" ><fmt:message key="ePH.AllowWithoutStock.label" bundle="${ph_labels}"/></td>
								<td>&nbsp;
									<input type="checkbox" name="ip_allow_stock" id="ip_allow_stock" value="Y" <%=ip_allow_stock_status%> >
								</td>
							</tr>
							<tr>
								<td class="label" id="dup_drug_legend_ip">&nbsp;<fmt:message key="ePH.AllowDuplicateDrug.label" bundle="${ph_labels}"/></td>
								<td colspan="7" id="duplicate_drug_ip">&nbsp;&nbsp;<input type="checkbox" name="allow_duplicate_drug_ip" id="allow_duplicate_drug_ip"  value="Y" <%=allow_duplicate_drug%>></td>
							</tr>
						</table>
<%	
					}	
%>						<!-- Start of Add 1st part of CRF-713 INC 12785  for general tab-->
						<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" id="general_table" style="visibility: hidden;">
					<!-- <table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="common_table" > -->
						<tr><td colspan="8" class="white">&nbsp;</td></tr>
						<tr>
							<td class="label" width='30%'><fmt:message key="ePH.InterfacetoInventoryManagement.label" bundle="${ph_labels}"/>
							</td>
							<td class="label" width='15%'><input type="checkbox" id="Interface to Inventory Management" name="interface_to_st_yn" id="interface_to_st_yn" value="Y" <%=EnableInterfaceStockControl%> onClick="validateInterfaceStockControl(this)">
							</td>							
							<td class="label" width='30%' ><fmt:message key="ePH.AllowMedicationOrderWithoutDiagnosis.label" bundle="${ph_labels}"/>
							</td>
							<%if(allowMednWithDiagDisableYn){ // if else added for MMS-DM-CRF-0150.1 - Start %>
							<td class="label" width='15%'><input type="checkbox" id="allow_medn_order_without_diag" value="Y"  <%=allowMednWithDiagDisable%> <%=AllowMednOrderWithoutDiag%>>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;&nbsp; <!--  allowMednWithDiagDisable Added for MMS-DM-CRF-0150.1 -->							
							<select name='diag_for_medn_order_by' id='diag_for_medn_order_by' <%=allowMednWithDiagDisable%> > <!--  allowMednWithDiagDisable Added for MMS-DM-CRF-0150.1 -->
								<option value='P' selected><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
								<option value='E'><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></option>
							</select>
							<input type="hidden" name="allow_medn_order_without_diag" id="allow_medn_order_without_diag" value="Y">
							</td>
							<%}else{ %>
							<td class="label" width='15%'><input type="checkbox" id="allow_medn_order_without_diag" name="allow_medn_order_without_diag" id="allow_medn_order_without_diag" value="Y"  <%=allowMednWithDiagDisable%> <%=AllowMednOrderWithoutDiag%>>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;&nbsp; <!--  allowMednWithDiagDisable Added for MMS-DM-CRF-0150.1 -->							
							<select name='diag_for_medn_order_by' id='diag_for_medn_order_by' <%=allowMednWithDiagDisable%> > <!--  allowMednWithDiagDisable Added for MMS-DM-CRF-0150.1 -->
								<option value='P' selected><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
								<option value='E'><fmt:message key="Common.encounter.label" bundle="${common_labels}"/></option>
							</select>			
							</td>
							<%} // if else added for MMS-DM-CRF-0150.1 - End %>							
							<td class="label" width='10%'><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></td>
						</tr>
						<tr style="display:none">
							<td class="label" style="display:none" ><fmt:message key="ePH.PatientInstructioninLocalLanguage.label" bundle="${ph_labels}"/></td>
							<td class="label"style="display:none"><input type="checkbox" id="Patient Instruction in Local Language" name="pat_instr_loc_lang_yn" id="pat_instr_loc_lang_yn" value="N" >
							</td>
							<td class="label" nowrap ><fmt:message key="ePH.AllowPaediatricMedicationOrderWithoutWeight.label" bundle="${ph_labels}"/>
							</td>
							<td class="label"><input type="checkbox" id="Allow Medication Order Without Wieght" name="allow_medn_order_without_wt" id="allow_medn_order_without_wt" value="Y" checked>
							</td>
							<td class="label">&nbsp;</td>
						</tr>
<%
						if (!licenceRights.equals("PHBASIC")){
%>
							<tr>
								<td class="label"  nowrap><fmt:message key="ePH.DisplayUnallocatedOrdersatDeliveryStage.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" id="Unallocated Orders at Delivery Stage" name="unalloc_order_del_st" id="unalloc_order_del_st" value="Y" <%=UnallocOrderDelivery%>>
								</td>
								<td class="label" nowrap ><fmt:message key="ePH.PrintExpiryDateforExpiredItemonlabel.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="print_exp_date_on_lbl" id="print_exp_date_on_lbl" value="Y" <%=print_exp_date_on_lbl%>></td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr>
								<td  class="label" nowrap><fmt:message key="ePH.DuplicatecheckforATCChemicalMainClass.label" bundle="${ph_labels}"/>
								</td>
								<td class="label"><input type="checkbox" id="Duplicate check for ATC" name="duplicate_check_atc" id="duplicate_check_atc" value="Y" <%=duplicate_check_atc%> >
								</td>
								<td class="label" nowrap><fmt:message key="ePH.MandatoryRemarksforPRNFrequency.label" bundle="${ph_labels}"/>
								</td> 
								<td class="label"><input type="checkbox" name="remarks_for_prn" id="remarks_for_prn" value="Y" <%=remarks_for_prn%> >
								</td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr>
								<td  class="label" nowrap><fmt:message key="ePH.DisplayATCAllergyAlertFrom.label" bundle="${ph_labels}"/>
								</td>
								<td class="label"><select name="atc_allergy_alert_level" id="atc_allergy_alert_level" id="atcAllergyAlert">
									<OPTION value="N" selected><fmt:message key="Common.none.label" bundle="${common_labels}"/></OPTION>
									<OPTION value="1" <%=atc_allergy_alert_level.equals("1")?"selected":"" %>><fmt:message key="Common.AnatomicalClass.label" bundle="${common_labels}"/></OPTION>
									<OPTION value="2" <%=atc_allergy_alert_level.equals("2")?"selected":"" %>><fmt:message key="Common.TherapeuticMainClass.label" bundle="${common_labels}"/></OPTION>
									<OPTION value="3" <%=atc_allergy_alert_level.equals("3")?"selected":"" %>><fmt:message key="Common.TherapeuticSubClass.label" bundle="${common_labels}"/></OPTION>
									<OPTION value="4" <%=atc_allergy_alert_level.equals("4")?"selected":"" %>><fmt:message key="Common.ChemicalMainClass.label" bundle="${common_labels}"/></OPTION>
									<OPTION value="5" <%=atc_allergy_alert_level.equals("5")?"selected":"" %>><fmt:message key="Common.ChemicalSubClass.label" bundle="${common_labels}"/></OPTION>
									</select>
								</td>
								<td  class="label" nowrap><fmt:message key="ePH.TabBasedGroupSortDisp.label" bundle="${ph_labels}"/>
								</td>
								<td class="label"><input type="checkbox" id="TabBasedGroupSortDisp" name="tab_based_group_sort_disp" id="tab_based_group_sort_disp" value="Y" onClick="" <%=tab_based_group_sort_disp%>>
								</td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr>
								<td class="label" nowrap><fmt:message key="ePH.DisplayChargeDetailsinDrugLookup.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" id="DispChargedtls" name="display_charge_details_lkp" id="display_charge_details_lkp" value="Y" onClick="CheckList()"<%=DISP_CHARGE_DTL_IN_DRUG_LKP_CHK%>>
								</td>
								<td class="label"><fmt:message key="ePH.DisplayPriceTypeinDrugLookup.label" bundle="${ph_labels}"/></td>
								<td class="label"><select name="display_price_type_lkp" id="display_price_type_lkp" id="DispPricelkp" <%=value%>>
									<OPTION value="P" <%=DISP_PRICE_TYPE_IN_DRUG_LKP.equals("P")?"selected":"" %>>Patient Specific</OPTION>
									<OPTION value="B" <%=DISP_PRICE_TYPE_IN_DRUG_LKP.equals("B")?"selected":"" %>>Base Price</OPTION>
<%
									if(DISP_CHARGE_DTL_IN_DRUG_LKP_YN.equals("N")){
%>
										<option value="" selected><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>		
<%
									}	
%>
									</select>
								</td>
								<td class="label">&nbsp;</td>	
							</tr>
							<tr>
								<td class="label" nowrap><fmt:message key="ePH.DisplayChargeDetailsinPrescriptions.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="display_charge_details_prescription" id="display_charge_details_prescription" value="Y" <%=DISP_CHARGE_DTL_IN_RX_YN%>>
								</td>
								<td class="label" nowrap><fmt:message key="ePH.AllowShortExpiryDrugs.label" bundle="${ph_labels}"/>
								</td> 
								<td class="label"><input type="checkbox" id="Allow Short Expiry Drugs" name="allow_short_expiry_drugs_yn" id="allow_short_expiry_drugs_yn" value="Y" <%=all_shrt_expry_drgs%>>
								</td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr>
								<td class="label" nowrap><fmt:message key="ePH.AllowCopyPrescriptionUptoDay.label" bundle="${ph_labels}"/>
								</td>						
								 <td class="label"><input type="text" size="3" name="copy_pres_upto_no_of_days" id="copy_pres_upto_no_of_days"  maxlength="3" class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);" value="<%=copy_pres_upto_no_of_days%>"/></td>
								 <!--  Added for CRF-0439  To add dispensing locking facility-->
								<td class="label" nowrap><fmt:message key="ePH.AllowUserLocksforDuringDispensing.label" bundle="${ph_labels}"/>
								</td> 
								<td class="label"><input type="checkbox" id="Allow User Locks for During Dispensing" name="allow_disp_record_lock_yn" id="allow_disp_record_lock_yn" value="Y" <%=allowDispRecordLockYN%>>
								</td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr>
								<!-- code  Added for Display the UOM in Transaction -->
								<td class="label" nowrap ><fmt:message key="ePH.DisplayUOMTransactions.label" bundle="${ph_labels}"/> 						
								</td> 
								<td class="label"><select name="display_uom_transaction_by" id="display_uom_transaction_by">
									<OPTION value="C" <%=displayUOMInTransaction.equals("C")?"selected":"" %>><fmt:message key="Common.code.label" bundle="${common_labels}"/></OPTION>
									<OPTION value="D" <%=displayUOMInTransaction.equals("D")?"selected":"" %>><fmt:message key="Common.description.label" bundle="${common_labels}"/></OPTION>
									</select>
								</td>            
								<!-- code  ended for Display the UOM in Transaction -->
								<!--  Added for CRF-641  Default Privilege Drug Selection-->
								<td class="label" nowrap><fmt:message key="ePH.DefaultPrivilegeDrugSelection.label" bundle="${ph_labels}"/></td>
								<td class="label"><select name="default_privilege_drug_selection" id="default_privilege_drug_selection" id="Default Privilege">
									<OPTION value="A" <%=defaultPrivilegeDrugSelection.equals("A")?"selected":"" %>><fmt:message key="ePH.ALLDRUGS.label" bundle="${ph_labels}"/></OPTION>
									<OPTION value="S" <%=defaultPrivilegeDrugSelection.equals("S")?"selected":"" %>><fmt:message key="ePH.SELFPRIVILEGEDRUGS.label" bundle="${ph_labels}"/></OPTION>
									</select>
								</td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr>
								<td class="label" colspan="1" nowrap><fmt:message key="ePH.NarcoticApprovalFormRequiredYN.label" bundle="${ph_labels}"/> </td>
								<td class="label"><input type="checkbox" name="narcotic_aprvl_form_req_yn" id="narcotic_aprvl_form_req_yn"  value="Y" onClick="validateNarcoticAprvlForm(this)" id="Narcotic Aprvl Form Req YN" <%=narcoticAprvlFormReqYN%>>
								</td>
								<td class="label" nowrap><fmt:message key="ePH.PrintNarcoticFormByDefault.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" id="Print Narcotic Form By Default" name="print_narcotic_form_by_default" id="print_narcotic_form_by_default" value="Y" <%=printNarcoticFormByDefaultYN%> <%=printNarcoticFormByDefault%>>
								</td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr><!--BSP30453-CRF-0047 -start -->
								<td class="label" colspan="1" nowrap><fmt:message key="ePH.EditDispenseLabelafterDispensingDelivery.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="edit_disp_label_after_del" id="edit_disp_label_after_del"  value="Y" <%=edit_disp_label_after_del%>>
								</td>
								<!-- Added new checkbox Prescribe Quantity by Prescribing Unit on 7/12/09  -->
								<td class="label" nowrap><fmt:message key="ePH.PrescribeQuantitybyPrescribingUnit.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="Pres_Quantity_by_PresUnit" id="Pres_Quantity_by_PresUnit" value="Y"  <%=rx_qty_by_pres_base_uom_yn%>>
								</td>
								<td class="label">&nbsp;</td>
							</tr><!--BSP30453-CRF-0047 -End -->
							<tr><!-- added for Bru-HIMS-CRF-265 [IN:032315]  Begin-->
								<td class="label" colspan="1" nowrap><fmt:message key="ePH.DiscCancelDuplicateMedic.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="discont_canc_dup_medic" id="discont_canc_dup_medic"  value="Y" <%=discont_canc_dup_medic%> onclick='enableDefSelct(this)'>
								</td>
								<!-- added for ML-BRU-SCF-0636 [IN036826]  Begin-->
								<td class="label" nowrap><fmt:message key="ePH.DispExpOrders.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="disp_exp_orders_yn" id="disp_exp_orders_yn" value="Y"  <%=disp_exp_orders_yn%>>
								</td><!-- added for ML-BRU-SCF-0636 [IN036826]  End-->
								<td class="label">&nbsp;</td>
							</tr><!-- added for Bru-HIMS-CRF-265 [IN:032315] End -->
							<tr><!-- added for  HSA-CRF-0151 [IN048468]  Begin-->
								<td class="label" colspan="1" nowrap><fmt:message key="ePH.DefSelectDiscCancelDuplicateMedic.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="can_discon_dup_orders_def_sel" id="can_discon_dup_orders_def_sel"  value="Y" <%=can_discon_dup_orders_def_sel%>>
								</td>
								<td class="label" nowrap><fmt:message key="ePH.PreviewRXMandatory.label" bundle="${ph_labels}"/></td><!-- Added for ML-MMOH-CRF-0341 [IN:057179] -->
								<td class="label"><input type="checkbox" name="preview_rx_yn" id="preview_rx_yn" value="Y"  <%=preview_rx_yn_check%>></td><!-- Added for ML-MMOH-CRF-0341 [IN:057179] -->
								<td class="label">&nbsp;</td>
							</tr><!-- added for  HSA-CRF-0151 [IN048468]  End-->
							<tr><!--row added for Bru-HIMS-CRF-082 [IN:029948]-->
								<td class="label" colspan="1" nowrap><fmt:message key="ePH.AltDrugRemarks.label" bundle="${ph_labels}"/></td>
								<td class="label"><select name="alt_drug_remarks_ind" id="alt_drug_remarks_ind" >
									<OPTION value="N" <%=alt_drug_remarks_ind.equals("N")?"selected":"" %>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></OPTION>
									<OPTION value="O" <%=alt_drug_remarks_ind.equals("O")?"selected":"" %>><fmt:message key="ePH.ApplWithOpt.label" bundle="${ph_labels}"/></OPTION>
									<OPTION value="M" <%=alt_drug_remarks_ind.equals("M")?"selected":"" %>><fmt:message key="ePH.ApplWithMand.label" bundle="${ph_labels}"/></OPTION>
									</select>
								</td>								
								<!--added for RUT-CRF-0064.1 [IN:041799]  Start-->
								<td class="label" nowrap style='<%=allergy_conf_disp%>'><fmt:message key="ePH.AllergyConfReq.label" bundle="${ph_labels}"/></td>
								<td class="label" style='<%=allergy_conf_disp%>'><input type="checkbox" name="allergy_conf_reqd_yn" id="allergy_conf_reqd_yn" value="Y"  <%=allergy_conf_check%>>
								</td><!--added for RUT-CRF-0064.1 [IN:041799]  End-->
							<!-- 	 <td class="label">&nbsp;</td>  commented for JD-CRF-198-->
								<!-- Added by prathyusha for JD-CRF-198 start -->
								 <td class="label" colspan="1" nowrap><fmt:message key="ePH.AmendAlternateDrugDetails.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="allow_amend_alt_drug_dtl_yn" id="allow_amend_alt_drug_dtl_yn" onclick='SelectAmendDrugDefaultChk(this)' value="<%=allow_amend_alt_drug_dtl_val%>" <%=allow_amend_alt_drug_dtl_chk%>>
								</td>
								
								<!-- Added by prathyusha for JD-CRF-198 end --> 
								 
							</tr>
							
							<!-- ADDED FOR GHL-CRF-0548 START -->
							
							<tr><!--Added for Bru-HIMS-CRF-400-Start -->								
								<td  class="label" nowrap><fmt:message key="ePH.AllowAlternateItemForMedicalItem.label" bundle="${ph_labels}"/> </td>
								<td class="label"><input type="checkbox" name="allow_alternate_item_for_medical_item_yn" id="allow_alternate_item_for_medical_item_yn" value="Y" <%=allow_alternate_item_for_medical_item_yn%>>
								</td>
								<!-- <td class="label" colspan="3"></td> --> <!-- Commented for MMS-DM-CRF-0177 -->
								<td  class="label">&nbsp;</td>
								<td  class="label">&nbsp;</td>
								<td  class="label">&nbsp;</td>
							</tr>
							<tr>
								<!-- Added for MMS-DM-CRF-0177 -->
<%
								if(pre_alloc_appl){
%>
								<td  class="label" nowrap><fmt:message key="ePH.PreAllocationDrugs.label" bundle="${ph_labels}"/></td>
					
								<td class="label" ><input type="checkbox" name="pre_alloc_appl_yn" id="pre_alloc_appl_yn" value="Y" <%=pre_alloc_appl_checked%> onClick="validatePreAllocationCheck(this)" >
								</td>
								<td class="label">
									<input type="radio" name="expiry_stock_1" id="expiry_stock_1" id=expiry_stock_1" value="<%=near_expiry_appl_yn%>" <%=near_expiry%> onClick="applicableAllocation('E')" <%=pre_alloc_disabled %>><fmt:message key="ePH.NearExpiry.label" bundle="${ph_labels}"/>
									<input type="text" size="3" name="durn_value" id="durn_value"  maxlength="2" class="NUMBER" value="<%=durn_value %>" onBlur="CheckNum(this);checkSplChars(this);ChkDuration(this,'');ChkNumberInput1(this);" <%=pre_alloc_disabled %> <%=expiry_stock_val %>>								
									<select name="durn_type" id="durn_type" onchange="validateDuration(durn_value,this);ChkDuration(durn_value,this);" <%=pre_alloc_disabled %> <%=expiry_stock_val %>>
										<option value="N" <%=durn_type_N %>>---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option> <!--  N stands for Nothing -->
										<option value="D" <%=durn_type_D %>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
										<option value="M" <%=durn_type_M %>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
										<option value="Y" <%=durn_type_Y %>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
									</select>								
								<input type="radio" name="expiry_stock_2" id="expiry_stock_2" id=expiry_stock_2" value="<%=near_expiry_appl_yn%>" <%=stock_level%> onClick="applicableAllocation('S')"  <%=pre_alloc_disabled %> ><fmt:message key="ePH.StockLevel.label" bundle="${ph_labels}"/>
								</td>
								<td  class="label">&nbsp;</td>																
<%
								}
%>
								<td class="label">&nbsp;</td>    <!-- Added for MMS-DM-CRF-0177 -->
								
							</tr>
							
							<!-- ADDED FOR GHL-CRF-0548 END -->
							
							<!--Added for Bru-HIMS-CRF-400-End-->
							<tr><!--Added for Bru-HIMS-CRF-400-Start -->								
								<td  class="label" nowrap><fmt:message key="ePH.ALLOWRENEWCHART.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="allow_renew_from_chart_summ_yn" id="allow_renew_from_chart_summ_yn" value="Y" <%=allow_renew_from_chart_summ_yn%>>
								</td>
								<td class="label" nowrap><fmt:message key="ePH.DispPrevVitalSignDtls.label" bundle="${ph_labels}"/></td><!--Added for ML-MMOH-CRF-0346 [IN:057185]-start -->
								<td class="label">
									<input type="checkbox" name="disp_prev_vital_signs_yn" id="disp_prev_vital_signs_yn" value="Y" <%=disp_prev_vital_signs_yn_check%>> 
								</td>
								 <td class="label">&nbsp;</td><!--Added for ML-MMOH-CRF-0346 [IN:057185]-end -->
							</tr>
							<tr><!--Added for NMC-JD-CRF-0001 -Start -->								
								<td  class="label" nowrap><fmt:message key="ePH.GenericNmeDisplay.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="display_generic_name_yn" id="display_generic_name_yn" value="Y" <%=display_generic_name_yn%>>
								</td>
								<!-- Added for TFS id:-16341 start-->
								<%if(default_disp_locn_select_appl){ %>
								<td  class="label" nowrap><fmt:message key="ePH.DefaultDispenseLocationInDrugSearch.label" bundle="${ph_labels}"/></td>
								<td class="fields">&nbsp;
					<select name="default_disp_locn" id="default_disp_locn"  > <%=bean.getListValues(sql,disp_locn_params,default_disp_locn) %> </select>
					</td>
					<%} %>
								<!-- Added for TFS id:-16341 end-->
							</tr><!--Added for NMC-JD-CRF-0001 end -->	
						<!-- Added for JD-CRF-0220 start-->
						
							<tr>
								<td class="label" ><fmt:message key="ePH.DrugIndicationMandatory.label" bundle="${ph_labels}"/></td>
								<td class="label">
									<input type="checkbox" id="drug_indication_mdry" name="drug_indication_mdry" id="drug_indication_mdry" value="Y" <%=drug_indication_mdry_chk%> >
								</td>
<%
								 if(disp_medication_auto_refresh){
%>
							  <td class="label" nowrap><fmt:message key="ePH.DispAutoRefresh.label" bundle="${ph_labels}"/><!-- Added TH-KW-CRF-0011 -->
							</td>						
								 <td class="label"><input type="text" size="3" name="disp_auto_refresh" id="disp_auto_refresh"  maxlength="3" class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);" value="<%=disp_auto_refresh%>"/> &nbsp;<fmt:message key="Common.Minute(s).label" bundle="${common_labels}"/></td>
<%}%>

							</tr>
							
							<!-- Added for JD-CRF-0220 END -->
<%  if(display_drug_verification_remarks) {
%>
							<tr><!--Added for ML-MMOH-CRF-1755 -Start -->								
								<td  class="label" nowrap><fmt:message key="ePH.DisplayVerifRemarksDisplayInstruction.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="display_verif_drug_inst_remarks_yn" id="display_verif_drug_inst_remarks_yn" value="Y" <%=display_verif_drug_inst_remarks_yn%>>
								</td>
								<td  class="label" nowrap>&nbsp;</td>
								<td class="fields">&nbsp</td>
				  			</tr><!--Added for ML-MMOH-CRF-1755 end -->	
<% } %>

<%						 if(allow_sensitive_diagnosis_yn) {
%> 
							<tr><!--Added for ML-BRU-CRF-0630 -Start -->								
								<td  class="label" nowrap><fmt:message key="ePH.NotDisplaySensitiveDiagnosisPrescriptionReport.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="sensitive_diagnosis_prescriptionreport_yn" id="sensitive_diagnosis_prescriptionreport_yn" value="Y" <%=do_not_display_sensitive_diagnosis_checked%>  <%=do_not_display_sensitive_diagnosis_disabled%> onClick="assignSensitive(this,'sensitive_diagnosis_prescriptionreport_yn')">
								</td>
								<td  class="label" nowrap><fmt:message key="ePH.DisplaySensitiveDiagnosisIndicatorPrescriptionReport.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="sensitive_diagnosis_indicator_prescriptionreport_yn" id="sensitive_diagnosis_indicator_prescriptionreport_yn" value="Y" <%=display_sensitive_diagnosis_indicator_yn_checked%> <%=display_sensitive_diagnosis_indicator_yn_disabled%> onClick="assignSensitive(this,'sensitive_diagnosis_indicator_prescriptionreport_yn')">
								</td>
				  			</tr><!--Added for ML-BRU-CRF-0630 end -->	
<% } %>
<%						 if(ph_quota_limit_for_drug_yn) {
%>						
							<tr><!--Added for ML-MMOH-CRF-1823-Start -->								
								<td  class="label" nowrap><fmt:message key="ePH.QuotaLimitCalculationRequired.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="quota_limit_calculation_required_yn" id="quota_limit_calculation_required_yn" value="Y" <%=quota_limit_calculation_required_yn_checked%> onClick="assignQuotaLimit(this,'quota_limit_calculation_required_yn')">
								</td>
								<td  class="label" nowrap><fmt:message key="ePH.ActivePrescriptionApplicableForQuotaLimit.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="active_prescription_enabled_for_quota_limit_yn" id="active_prescription_enabled_for_quota_limit_yn" value="Y" <%=active_prescription_enabled_for_quota_limit_yn_checked%> <%=active_prescription_enabled_for_quota_limit_yn_disabled%> onClick="assignQuotaLimit(this,'active_prescription_enabled_for_quota_limit_yn')">
								</td>
				  			</tr><!--Added for ML-MMOH-CRF-1823 end -->	
<% } %>
<%						 if(ph_always_display_dispense_location_yn) {
%>						
							<tr><!--Added for NMC-JD-CRF-0197-Start -->								
								<td  class="label" nowrap><fmt:message key="ePH.AlwaysDisplayDispenseLocationDrugSearch.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="always_display_dispense_location_yn" id="always_display_dispense_location_yn" value="Y" <%=always_display_dispense_location_yn_checked%> onClick="SelectAmendDrugDefaultChk(this)">
								</td>
								<td  class="label" nowrap>&nbsp;</td>
								<td class="label">&nbsp;</td>
				  			</tr><!--Added for NMC-JD-CRF-0197 end -->	
<% } %>
							<tr>
								<td class='COLUMNHEADER' colspan=5><fmt:message key="ePH.ApplicableOrders.label" bundle="${ph_labels}"/></td>
							</tr>
							<tr>
								<td class="label"  ><fmt:message key="ePH.CompoundingRx.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" id="Compounding Rx" name="compounding_rx" id="compounding_rx" value="Y" <%=comp_rx_chk%>>
								</td>
								<td class="label" ><fmt:message key="ePH.IntravenousRx.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="intravenous_rx" id="intravenous_rx" value="Y" <%=iv_rx_chk%>></td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr>
								<td class="label" ><fmt:message key="ePH.OncologyRx.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" id="Oncology Rx" name="oncology_rx" id="oncology_rx" value="Y" onclick='OncologyChk(this)' <%=oncology_rx_chk%> >
								</td>
								<td class="label" ><fmt:message key="ePH.TPNRx.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="tpn_rx" id="tpn_rx" value="<%=tpn_rx_chk_val%>" onclick='SelectDefaultChk(this)'<%=tpn_rx_chk%>></td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr>
								<td class="label" ><fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/></td>
								<td class="label">
									<input type="checkbox" id="TDM" name="tdm" id="tdm" value="Y" <%=tdm_order_chk%> >
								</td>
								<td class="label">&nbsp;</td>
								<td class="label">&nbsp;</td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr>
								<td class='COLUMNHEADER' colspan="5"><fmt:message key="ePH.Outputs.label" bundle="${ph_labels}"/></td>
							</tr>
							 <tr>
								<td class="label" ><fmt:message key="ePH.PrintDispensingSheetinDirectDispensing.label" bundle="${ph_labels}"/> </td>
								<td class="label"><input type="checkbox" name="print_disp_sheet_op_yn" id="print_disp_sheet_op_yn" value="Y" <%=PrintDispSheetOPYN%> id="Print Dispensing Sheet">&nbsp;
								</td>
								<td class="label">&nbsp;</td>
								<td class="label">&nbsp;</td>
								<td class="label">&nbsp;</td>
							 </tr>
							  <!-- Added for MMS-CRF-0233-44841 by Ayesha Khan   -->
							  <%if(ph_pres_footer_desc_dtls){ %>
							 <tr>
								<td class="label" ><fmt:message key="ePH.PrintFooterDetailsinPrescriptions.label" bundle="${ph_labels}"/> </td>
								<td class="label"><input type="checkbox" name="print_footer_dtls_pres_yn" id="print_footer_dtls_pres_yn" value="Y" <%=PrintFooterDtlsPresYN%> id="Print_Footer_Details" onclick="EnableDisableTextArea(this);validateFooter(this);">&nbsp;
								</td>
								<td class="label">&nbsp;</td>
								<td class="label">&nbsp;</td>
								<td class="label">&nbsp;</td>
							 </tr>
							 
							 <tr>
							 <td class="label" ><fmt:message key="ePH.FooterDescription.label" bundle="${ph_labels}"/> </td>
							 <td class="label">&nbsp;</td>
							 <td class="label" ><fmt:message key="ePH.FooterDescriptioninLocalLanguage.label" bundle="${ph_labels}"/> </td>
							 <td class="label">&nbsp;</td>
							 <td class="label">&nbsp;</td>
							
							 </tr>
							 
							 <tr>
							 <% 
							  if(PrintFooterDtlsPresYN.equals("checked")){
%>
							 <td class="label">
							  <input type="text" rows="6" cols="50" id="txt_Area_1" name="print_pres_dtl_en" id="print_pres_dtl_en" value="<%= PrintPresDtlEnValue %>" maxLength="100" size="80" onkeypress="return SpecialChar(event);" onblur="checkMaxLength(this);" />
							 </td>
							  
							  <td>
							  
							<img src="../../eCommon/images/mandatory.gif" align="center" id="print_pres_dtl_en_man" style="visibility:visible"></img>
							</td>
<%
								}
								else{
%>
								<td class="label">
							  <input type="text" rows="6" cols="50" id="txt_Area_1" name="print_pres_dtl_en" id="print_pres_dtl_en" value="<%= PrintPresDtlEnValue %>" maxLength="100" size="80" onkeypress="return SpecialChar(event);" onblur="checkMaxLength(this);" disabled="disabled"/>
							 </td>
								<td>	<img src="../../eCommon/images/mandatory.gif" align="center" id="print_pres_dtl_en_man" style="visibility:hidden"></img>
<%
								}
%>
							  </td>
							  
							  <% 
							  if(PrintFooterDtlsPresYN.equals("checked")){
%>
							 <td class="label">
							  <input type="text" rows="6" cols="50" id="txt_Area_2" name="print_pres_dtl_loc" id="print_pres_dtl_loc" value="<%= PrintPresDtlLocValue %>" maxlength="100" size="75" onkeypress="return SpecialCharArabic(event);" onblur="checkMaxLengthLoc(this);"/>
							 </td>
							 <td> 
							<img src="../../eCommon/images/mandatory.gif" align="center" id="print_pres_dtl_loc_man"></img>
							</td>
							<%}
							  else{ %>
								<td class="label">
							  <input type="text" rows="6" cols="50" id="txt_Area_2" name="print_pres_dtl_loc" id="print_pres_dtl_loc" value="<%= PrintPresDtlLocValue %>" maxlength="100" size="75" onkeypress="return SpecialCharArabic(event);" onblur="checkMaxLengthLoc(this);" disabled="disabled"/>
							 </td>
							 <td> 
									<img src="../../eCommon/images/mandatory.gif" align="center" id="print_pres_dtl_loc_man" style="visibility:hidden"></img>
<%
								}
%>							  </td>
							  <td class="label">&nbsp;</td>
							 </tr>
							 <%} %>
							<!-- Ended for MMS-CRF-0233-44841 by Ayesha Khan  --> 
							
							<!-- Moved here from outpatient tab for IN17342 on 17 Dec 2009 -->
							<tr>
								<td class='COLUMNHEADER' colspan="5"><fmt:message key="ePH.PrescriptionRules.label" bundle="${ph_labels}"/></td>
							</tr>
							<tr>
								<td class="label" ><fmt:message key="ePH.AllowRefill.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="checkbox" name="refill_yn" id="refill_yn" <%=RefillYN%> value="Y" onClick="validateRefill(this,'<%=PrintRefillDescYN%>')" id="Allow Refill">
								</td>
								<td class="label" ><fmt:message key="ePH.MaxNoofRefillsAllowed.label" bundle="${ph_labels}"/></td>
								<td class="label" ><input type="text" size="2" maxlength="2" name="max_refills_for_pres" id="max_refills_for_pres" class="NUMBER" <%=MaxNoOfRefillsAllowed%> value="<%= MaxNoOfRefillsAllowedValue %>" id="Max. No of Refills Allowed" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);validateForGreaterValue(<%=MaxNoOfRefillsAllowedValueParam%>+'',this);checkSplChars(this);">
<%
								if(RefillYN.equals("checked")){
%>
									<img src="../../eCommon/images/mandatory.gif" align="center" id="max_no_of_refills_allowed_man" style="visibility:visible"></img>
<%
								}
								else{
%>
									<img src="../../eCommon/images/mandatory.gif" align="center" id="max_no_of_refills_allowed_man" style="visibility:hidden"></img>
<%
								}
%>
								</td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr>
								<td class="label" ><fmt:message key="ePH.MaxDurationforRefillPrescriptions.label" bundle="${ph_labels}"/></td>
								<td class="label"><input type="text" size="3" maxlength="3" name="max_durn_for_refill_pres" id="max_durn_for_refill_pres" class="NUMBER" id="Max. Duration for Refill Prescriptions" 
								onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);validateForGreaterValue(<%=MaxDurForRefillDescValueParam%>+'',this);checkSplChars(this);" <%=MaxDurForRefillDesc%> value="<%=MaxDurForRefillDescValue %>"><label class="label">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></label>
<%
								if(RefillYN.equals("checked")){
%>
									<img src="../../eCommon/images/mandatory.gif" align="center" id="max_durn_for_refills_pres_man" ></img>
<%
								}
								else{
%>
									<img src="../../eCommon/images/mandatory.gif" align="center" id="max_durn_for_refills_pres_man" style="visibility:hidden"></img>
<%
								}
%>
								</td>
								<td class="label" ><fmt:message key="ePH.PrintRefillPrescriptionsalongwithMain.label" bundle="${ph_labels}"/></td><!-- Condition added for IN 13909 -->
								<td class="label" >
<%
								if (((String)defaultValues.get(3)).equals("Y")){
%>
									<input type="checkbox" id="Print Refill Prescriptions along with main" name="print_refill_pres_with_main_yn" id="print_refill_pres_with_main_yn" value="Y" <%=PrintRefillDesc%> >
<%
								}
								else{
%>
									<input type="checkbox" id="Print Refill Prescriptions along with main" name="print_refill_pres_with_main_yn" id="print_refill_pres_with_main_yn" value="Y" disabled>
<%
								}
%>
								</td>
								<td class="label">&nbsp;</td>
							</tr>
							<tr ><!-- //Added for Bru-HIMS-CRF-402[IN044065] start--> 
								<td class="label"><fmt:message key="ePH.autoTransfer_AE_MedicationOrder.label" bundle="${ph_labels}"/></td>
								<td class="label">
<%
								if (em_medctn_fwd_ip_yn.equals("Y")){
									disabled = "";
%>
									<input type="checkbox" id="em_medctn_fwd_ip_yn" name="em_medctn_fwd_ip_yn" id="em_medctn_fwd_ip_yn" value="Y" checked  onclick='enableEncouterPeriod(this);'>
<%
								}
								else{
									disabled="disabled";
%>	
									<input type="checkbox" id="em_medctn_fwd_ip_yn" name="em_medctn_fwd_ip_yn" id="em_medctn_fwd_ip_yn" value="Y"  onclick='enableEncouterPeriod(this);'>
<%
								}
%>
								</td>
								<td class="label"><fmt:message key="ePH.EmergencyEncounterDurationWithin.label" bundle="${ph_labels}"/></td>
								<td class="label"  colspan="2"><input type="text"  class="NUMBER" name="cary_frwd_ord_nofhrs" id="cary_frwd_ord_nofhrs" size="2" maxlength="3" value= "<%=cary_frwd_ord_nofhrs %>"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);" <%=disabled%>>&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
<%
								if (em_medctn_fwd_ip_yn.equals("Y")){
%>
									<img src="../../eCommon/images/mandatory.gif" align="center" id="cary_frwd_ord_nofhrs_man">
<%
								}
								else{
%>
									<img src="../../eCommon/images/mandatory.gif" align="center" id="cary_frwd_ord_nofhrs_man" style='display:none;'>
<%
								}
%>
								</td>
							</tr><!-- //Added for Added for Bru-HIMS-CRF-402[IN044065]- end -->
							<tr><!-- //Added for Bru-HIMS-CRF-384[IN041642] start--> 
								<td class='COLUMNHEADER' colspan="5"><fmt:message key="ePH.DefaultFrequencyForIV.label" bundle="${ph_labels}"/></td>
							</tr>
							<tr>
								<td class="label"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
								<td class="label"><select name="sel_defaultfreqforIV" id="sel_defaultfreqforIV" id="id_defaultfreqforIV">
								<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%									ArrayList arrFreq =(ArrayList) bean.getContinuousFreq();
									for (int i=0;i<arrFreq.size();i+=2){
										String select="";
										if (strDefaultFreqforIV.equals((String)arrFreq.get(i)))
											select="selected";
%>
										<option value="<%=(String)arrFreq.get(i)%>" <%=select%> > <%=(String)arrFreq.get(i+1)%> </option>
<%									}
%>
								</select></td>
								<td class="label"  colspan="3"></td>
							</tr><!-- //Added for Bru-HIMS-CRF-384[IN041642] end -->
<%
						}
						else{
%>
							<input type="hidden" name="print_exp_date_on_lbl" id="print_exp_date_on_lbl" value="N">
							<input type="hidden" name="unalloc_order_del_st" id="unalloc_order_del_st" value="N">
							<input type="hidden" name="duplicate_check_atc" id="duplicate_check_atc" value="N">
							<input type="hidden" name="remarks_for_prn" id="remarks_for_prn" value="N">
							<input type="hidden" name="atc_allergy_alert_level" id="atc_allergy_alert_level" value="N">
<% 
						}
%>
					</table>
					<!-- End of Add 1st part of CRF-713 INC 12785  for general tab-->
					<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="outpatient_table" style="visibility:hidden">
						<th colspan="6" id="op_stock_header"><fmt:message key="ePH.StockRules.label" bundle="${ph_labels}"/></th>
						<tr>
							<td class="label" width='20%'><fmt:message key="ePH.ConsiderStock.label" bundle="${ph_labels}"/></td>
							<td class="label" width='20%'><input type="checkbox" name="consider_stock_for_pres_yn" id="consider_stock_for_pres_yn" value="Y" <%=ConsiderStock%> onClick="validateConsiderStock(this)" id="Consider Stock">
							</td>
							<td class="label" width='20%'><fmt:message key="ePH.AllowWithoutStock.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan="3"><input type="checkbox" name="allow_pres_without_stock_yn" id="allow_pres_without_stock_yn" value="Y" <%=AllowPresWithoutStockYN%> <%=AllowPresWithoutStock%> id="Allow Without Stock">
							</td>
						</tr>
						<!-- IN30118-SCF No: MO-GN-5400. Creating new Duplicate Drug Flag for OP. -->
						<tr>
							<!-- <td class="label"  id="dupdrug_legend_op"><fmt:message key="ePH.AllowDuplicateDrug.label" bundle="${ph_labels}"/></td>  Modified for MO-CRF-20085.1  By Prathyusha on 05/18/2016-->
						    <!--	<td class="label" colspan="3" id="duplicatedrug_op"><input type="checkbox" name="allow_duplicate_drug_op" id="allow_duplicate_drug_op"  value="Y" allow_duplicate_drug_op></td>  Modified for MO-CRF-20085.1  By Prathyusha on 05/18/2016-->
						 
						    <td class="label" width='10%' id="dupdrug_legend_op"><fmt:message key="ePH.AllowDuplicateDrug.label" bundle="${ph_labels}"/></td>
							<td class="label" width='10%' id="duplicatedrug_op"><input type="checkbox" name="allow_duplicate_drug_op" id="allow_duplicate_drug_op" onclick="chkSkipDuplicate(this)"  value="Y" <%=allow_duplicate_drug_op%>></td>
						
						<!-- Added  for MO-CRF-20085.1  By Prathyusha on 05/18/2016 start -->
						<td class="label" width='10%' id="skip_dup_alrt_op"> <fmt:message key="ePH.SkipDuplicateAlert.label" bundle="${ph_labels}"/></td>
						<td class="label" width='10%'  id="skipdupalrt_op"><input type="checkbox" name="skip_duplicate_alert_op" id="skip_duplicate_alert_op"  onclick="skipDuplicate(this)" value="<%=skip_duplicate_alert_op_val%>" <%=skip_duplicate_alert_op_chk%> <%=skip_duplicate_alert_op_disp%>></td>
						<!-- Added  for MO-CRF-20085.1  By Prathyusha on 05/18/2016  end -->
						<!-- Added  for MO-CRF-20085.1 Modified version By Prathyusha on 05/26/2016  start -->
						<td class="label" width='10%' id="overlap_duration_label_op"> <fmt:message key="ePH.OverlapDuration.label" bundle="${ph_labels}"/></td>
						<td class="label" colspan="3" id="overlapduration_op"><input type="test" size="3" maxlength="3"  class="NUMBER" onBlur="checkIsNotZero(this, 'OverLap Duration');"  onKeyPress="return(ChkNumberInput(this,event,0));"  name="overlap_duration_op" id="overlap_duration_op"   value="<%=overlap_duration_op_val %>" <%=overlap_duration_op_disp%>/></td>
						<!-- Added  for MO-CRF-20085.1 Modified version  By Prathyusha on 05/26/2016  end -->
						</tr>
						<th colspan="6"><fmt:message key="ePH.PrescriptionRules.label" bundle="${ph_labels}"/></th>
<!-- Moved parameters Allow Refill, Max no. of refills allowed, Max duration for Refill Prescriptions and Print Refill Prescriptions along with Main --- from here to General tab  for IN17342 on 17/12/2009-->						
						<tr><!-- enhancement made by Abdul sukkur on 21/08/2008 -->
							<td class="label"><fmt:message key="ePH.SplitOrdersBy.label" bundle="${ph_labels}"/></td>
							<td class="label"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>							
							<td class="label"><input type="checkbox" id="ChkSplitPriority" name="split_based_priority_yn" id="split_based_priority_yn" value="Y" <%=split_based_priority_yn%>></td>
							<td class="label" width='15%'><fmt:message key="ePH.DrugClass.label" bundle="${ph_labels}"/></td>
							<td class="label" width='10%'><input type="checkbox" id="ChkSplitDrugClass" name="split_based_drug_class_yn" id="split_based_drug_class_yn" value="Y" <%=split_based_drug_class_yn%>></td>
						</tr>
							<tr>
							<td class="label" colspan="1"></td>
							<td class="label" width='10%'><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
							<td class="label" width='5%'><input type="checkbox" id="ChkSplitDrugClass" name="split_drug_based_auth_yn" id="split_drug_based_auth_yn" value="Y" <%=split_drug_based_auth_yn%>></td><!-- added for ml-mmoh-crf-0864 -->
						</tr>		<!-- end of modification -->
						<tr id="dup_drug_op">
							<td class="label" id='dup_drug_legend_op'><fmt:message key="ePH.AllowDuplicateDrug.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan="5" ><input type="checkbox" name="allow_duplicate_drug__op" id="allow_duplicate_drug__op"  value="Y" <%=allow_duplicate_drug%>></td>
						</tr>
						<tr>
							<td class="label" ><fmt:message key="ePH.ToDisplayPrescriptionDuration.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan="3" ><input type="checkbox" name="disp_rx_duration_yn" id="disp_rx_duration_yn"  value="Y" <%=disp_rx_duration_check%>></td>
							
							<td class="label" ><fmt:message key="ePH.AmendorderwiseDispMedication.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan="2" ><input type="checkbox" name="Amend_orderwise_DispMedication_yn" id="Amend_orderwise_DispMedication_yn"  value="Y" <%=Amend_orderwise_DispMedication_yn%>></td>
							
						</tr>
<%
						if (!licenceRights.equals("PHBASIC")){
%>
							<th colspan="6"><fmt:message key="ePH.OrderRoutingDefaults.label" bundle="${ph_labels}"/></th>
							<tr>
								<td class="label" ><fmt:message key="ePH.RoutineOrders.label" bundle="${ph_labels}"/></td>
								<td class="label" ><select name="op_disp_locn_rtn_ord" id="op_disp_locn_rtn_ord" id="Routine Orders">
									<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
									ArrayList all =(ArrayList) bean.getRoutingOrderOnLoad(locale);
									//For OP Order Routing and Stat Orders
									ArrayList OPOrderRouting = (ArrayList)all.get(0);
									//For IP Order Routing and Stat Orders
									ArrayList IPOrderRouting = (ArrayList)all.get(1);
									//For IP Discharge/Take Home Medication
									ArrayList IPMedication	 = (ArrayList)all.get(2);
									for (int i=0;i<OPOrderRouting.size();i+=2){
										String select="";
										if (OPDispLocnRtn_ord.equals((String)OPOrderRouting.get(i)))
											select="selected";
%>
										<option value="<%=(String)OPOrderRouting.get(i)%>" <%=select%> > <%=(String)OPOrderRouting.get(i+1)%> </option>
<%
									}
%>
									</select>
								</td>
								<td class="label" ><fmt:message key="ePH.StatOrder.label" bundle="${ph_labels}"/></td>
								<td class="label" colspan='3'><select name="op_disp_locn_stat_ord" id="op_disp_locn_stat_ord" id="Stat Orders">
										<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
										for (int i=0;i<OPOrderRouting.size();i+=2){
											String select="";
											if (OPDispLocnStat_ord.equals((String)OPOrderRouting.get(i)))
												select="selected";
%>
											<option value="<%=(String)OPOrderRouting.get(i)%>" <%=select%> ><%=(String)OPOrderRouting.get(i+1)%> </option>
<%
										}
	%>
									</select>
								</td>
							</tr>
							<!-- ADDED for 6041 -->
							<% if(op_take_home_med){ %>
							<tr>
							<td class="label" colspan="1"><fmt:message key="ePH.Discharge/TakeHomeMedication.label" bundle="${ph_labels}"/></td>
							<td class="label"><select name="op_disch_med_disp_locn" id="op_disch_med_disp_locn" id="Discharge/Take Home Medication">
									<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
									for (int i=0;i<OPOrderRouting.size();i+=2){
										String select="";
										if (opDisMedLcn.equals((String)OPOrderRouting.get(i)))//check this for 0063 (IPMedication)
											select="selected";
%>
										<option value="<%=(String)OPOrderRouting.get(i)%>" <%=select%> > <%=(String)OPOrderRouting.get(i+1)%> </option>
<%
									}
%>
								</select>
							</td>

							<td></td>
						</tr>
						<%} %><!-- added for 6041 END -->
							<th colspan="6"><fmt:message key="ePH.DispensingRules.label" bundle="${ph_labels}"/></th>
							<tr>
								<td class="label" ><fmt:message key="ePH.AllowDispensinginadvance.label" bundle="${ph_labels}"/></td>
								<td class="label">
<%
								if (((String)defaultValues.get(5)).equals("Y")){
%>
									<input type="checkbox" name="disp_before_start_date_yn" id="disp_before_start_date_yn" value="Y"  id="Allow Dispensing in advance"  onClick="validateDispensingRules(this)" <%=DispBeforeStartDateYN%>  >&nbsp;
<%
								}
								else {
%>
									<input type="checkbox" name="disp_before_start_date_yn" id="disp_before_start_date_yn" value="Y"  id="Allow Dispensing in advance"  onClick="validateDispensingRules(this)" disabled >&nbsp
<%
								}
%>
								</td>
								<td class="label" ><fmt:message key="ePH.NoofdaysAhead.label" bundle="${ph_labels}"/></td>
								<td class="label" colspan='3'>
<%
								if (((String)defaultValues.get(5)).equals("Y")){
%>
									<input type="text" name="disp_before_no_of_days" id="disp_before_no_of_days" value="<%=DispBeforeNoOfDaysValue%>" size="3" maxlength="3"   class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="checkIsNotZero(this, 'No of Days Ahead');CheckNum(this);validateForGreaterValue(<%=DispBeforeNoOfDaysValueParam%>+'',this);checkSplChars(this);" id="No_of_days_ahead">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" ></img> 
<%
								}
								else{
%>
									<input type="text" name="disp_before_no_of_days" id="disp_before_no_of_days" value="" size="3" maxlength="3" disabled  class="NUMBER" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="checkIsNotZero(this, 'No of Days Ahead');CheckNum(this);validateForGreaterValue(<%=DispBeforeNoOfDaysValueParam%>+'',this);checkSplChars(this);" id="No_of_days_ahead">&nbsp;
<%
								}
%>
							</td>
						</tr>
						<tr>
							<td class="label" ><fmt:message key="ePH.AllowDispensingpastOrders.label" bundle="${ph_labels}"/></td>
							<td class="label" >
<%
							if(((String)defaultValues.get(7)).equals("Y")){
%>
								<input type="checkbox" name="disp_beyond_earliest_start_yn" id="disp_beyond_earliest_start_yn" value="Y"  <%=DispBeyondEarliestStartYN%>  onClick="validateDispensingPastOrders(this)" id="Allow Dispensing past Orders">&nbsp;
<%
							}
							else{
%>
								<input type="checkbox" name="disp_beyond_earliest_start_yn" id="disp_beyond_earliest_start_yn" value="Y"  disabled  onClick="validateDispensingPastOrders(this)" id="Allow Dispensing past Orders">&nbsp;
<%
							}
%>
							</td>
							<td class="label" ><fmt:message key="ePH.UptoNoofDays.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan="3">
<%
							if(((String)defaultValues.get(7)).equals("Y")){
%>
								<input type="text" name="disp_beyond_no_of_days" id="disp_beyond_no_of_days" value="<%=DispBeyondNoOfDaysValue%>" size="3" maxlength="3" <%=DispBeyondNoOfDays%> class="NUMBER" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="checkIsNotZero(this, 'Up to No of Days');CheckNum(this);validateForGreaterValue(<%=DispBeyondNoOfDaysValueParam%>+'',this);checkSplChars(this);" id="Up to No. of Days">&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img> 
<%
							}
							else{
%>
								<input type="text" name="disp_beyond_no_of_days" id="disp_beyond_no_of_days" value="" size="3" maxlength="3" disabled class="NUMBER" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="checkIsNotZero(this, 'Up to No of Days');CheckNum(this);validateForGreaterValue(<%=DispBeyondNoOfDaysValueParam%>+'',this);checkSplChars(this);" id="Up to No. of Days">&nbsp;
<%
							}
%>
							</td>
						</tr>
						<tr>
						<td class='COLUMNHEADER' colspan="2"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/> </th>
						<td class='COLUMNHEADER' colspan="4"><fmt:message key="ePH.DispenseLocationControls.label" bundle="${ph_labels}"/></th>
						</tr>
						<tr>
							<td class="label"><%=param_legends.get("R")%>&nbsp;</td>
							<td class="label"><input type="checkbox" name="disp_regn_reqd_yn" id="disp_regn_reqd_yn" value="Y" <%=DispAcknReqdYN%> <%=DisableRegnFillPharmaVerification%> id="Registration">
							</td>
							<td class="label" ><%=param_legends.get("F")%>&nbsp;</td>
							<td class="label"><input type="checkbox" name="disp_flng_reqd_yn" id="disp_flng_reqd_yn" value="Y" onClick="validateFilling(this);validateFillingStages()" <%=DispFlngReqdYN%> <%=DisableRegnFillPharmaVerification%> id="Filling">
							</td>
							<td class="label" ><fmt:message key="Common.Stage.label" bundle="${common_labels}"/>&nbsp;</td>
							<td class="label" ><select <%=disableFillingStages%> name="disp_fill_stage" onChange="validateFillingStages()" <%=DisableRegnFillPharmaVerification%>>
<%
								if(DispFlngReqdYN.equals("checked")){
%>
									<option value="B" <%=selectDispFillStageBefore%>><fmt:message key="ePH.Before.label" bundle="${ph_labels}"/> <%=param_legends.get("A")%></option>
									<option value="A" <%=selectDispFillStageAfter%>><fmt:message key="Common.After.label" bundle="${common_labels}"/> <%=param_legends.get("A")%></option>
<%
								}
								else{
%>
									<option value="X" <%=selectDispFillStageNA%>><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
<%
								}
%>
								</select>
							</td>
						</tr>
						<tr>
							<td class="label" ><%=param_legends.get("V")%>&nbsp;</td>
							<td class="label"> 
<%
								if (arrList.size()<=0){
%>
									<select name="disp_verf_stage" id="disp_verf_stage" <%=DisableRegnFillPharmaVerification%> id="Pharmacist Verification">
<%
									if (DispFlngReqdYN.equals("checked")){
%>
										<option value="F"><fmt:message key="ePH.SeparateBefore.label" bundle="${ph_labels}"/><%=param_legends.get("F")%></option>
										<option value="C"><fmt:message key="ePH.CombinedWith.label" bundle="${ph_labels}"/><%=param_legends.get("A")%></option>
<%
									}
									else{
%>
										<option value="B"><fmt:message key="ePH.SeparateBefore.label" bundle="${ph_labels}"/><%=param_legends.get("A")%></option>
										<option value="C"><fmt:message key="ePH.CombinedWith.label" bundle="${ph_labels}"/><%=param_legends.get("A")%></option>
<%

									}
%>
									</select>
<%
								}
								else{
%>
									<input type="text" value="<%=DispVerfStageValue%>" id="Pharmacist Verification" name="disp_verf_stage_desc" size="20" disabled>
									<input type="hidden" value="<%=DispVerfStageCode%>" name="disp_verf_stage">
<%
								}
%>
								</td>
<%
								String disableDelivery = "";
								if(arrList.size()>0){
									disableDelivery = "disabled";
								}
%>
								<td class="label"><%=param_legends.get("D")%>&nbsp;</td>
								<td class="label"><input type="checkbox" name="disp_delv_reqd_yn" id="disp_delv_reqd_yn" value="Y" <%=DispDelvReqdYN%> id="Delivery" <%=disableDelivery%>></td>
<!-- <%									//commented  to shift above  on 07-03-09
								/*String disableDelivery = "";
								if(arrList.size()>0){
									disableDelivery = "disabled";
								}*/
%>-->
								<!-- <td class="label" ><%=param_legends.get("D")%>&nbsp;</td>
								<td><input type="checkbox" name="disp_delv_reqd_yn" id="disp_delv_reqd_yn" value="Y" <%=DispDelvReqdYN%> id="Delivery" <%=disableDelivery%>></td> -->
								<!-- added for INCLUDE ZERO ALLOC ITEMS on 07-03-09 -->
							<td class="label"><fmt:message key="ePH.INCLUDE_ZERO_ALLOC_ITEMS.label" bundle="${ph_labels}"/>	</td>
							<td class="label"><input type="checkbox" name="include_zero_allocated_items_in_dispensing" id="include_zero_allocated_items_in_dispensing" value="Y" <%=includeZeroAllocatedItemsOPYN%> id="include_zero_allocated_items_in_dispensing">&nbsp;
							</td>
						</tr>
<% 						
						if(approval_no_app) //Added for AAKH-CRF-1117
						{
%>							
						<tr>  <!-- Added for AAKH-CRF-1117 -->
						<td class="label"><fmt:message key="ePH.ApprovalNoRequiredInDispMedication.label" bundle="${ph_labels}"/></td>
						 <td><input type="checkbox" name="approval_no_yn_op" id="approval_no_yn_op" value="Y" <%=approval_no_yn_op%>  id="approval_no_yn_op"></td> <!--modified for AAKH-CRF-0117 -->
						 
						</tr>
<%
						}
%>
					<!--Added for MMS-KH-CRF-0028 start -->	
							<%if(intractn_req_yn){ %>
							<tr>
								<td class="label"><fmt:message key="ePH.VerificationStatusReviewAprroveforpatientclass.label" bundle="${ph_labels}"/></td>
						<td class="label" >
								<input type="checkbox" name="review_aprrove_applicable_for_op" id="review_aprrove_applicable_for_op" value="Y"  <%=review_aprrove_applicable_for_op_checked%> />
						</td>
									
								
							</tr>
							
							<%} %>
							<!--Added for MMS-KH-CRF-0028 end -->						
						<th colspan="6"><fmt:message key="ePH.Outputs.label" bundle="${ph_labels}"/></th>
						<tr>
						<tr>
							<td class="label"><fmt:message key="ePH.LabelFormat.label" bundle="${ph_labels}"/></td>
							<td class="label" ><select name="label_format_op" id="label_format_op" id="Label Format">
								<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
								<option value="D" <%=LabelFormatOPDrug%>><fmt:message key="ePH.DrugWise.label" bundle="${ph_labels}"/></option>
								<!-- <option value="C" <%=LabelFormatOPCombined%>><fmt:message key="ePH.Combined.label" bundle="${ph_labels}"/></option> -->
								</select>
							</td>
							<td class="label" ><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
							<td class="label" colspan="2"><select name="dflt_lang_for_disp_label" id="dflt_lang_for_disp_label" id="Label Language">
								<option value=""><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
<%
								if(alLanguageIds!=null && alLanguageIds.size()>0){ //Added for MMS-QH-CRF-0069 [IN:037977]
									for(int i=0; i<alLanguageIds.size();i+=2){
										if(dflt_lang_for_disp_label.equals((String)alLanguageIds.get(i))){
%>
											<option value="<%=(String)alLanguageIds.get(i)%>" selected><%=(String)alLanguageIds.get(i+1)%></option>
<%
										}
										else{
%>
											<option value="<%=(String)alLanguageIds.get(i)%>" ><%=(String)alLanguageIds.get(i+1)%></option>
<%
										}
									}
								}
%>
								</select>
							</td>
							<!-- <td >&nbsp;</td>
							 <td >&nbsp;</td>  -->
						</tr>
						<tr>
						<td class='COLUMNHEADER' colspan="3"><fmt:message key="ePH.DRUGRETURN.label" bundle="${ph_labels}"/></th>
						<td class='COLUMNHEADER' colspan="3"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.UndeliveredDrug.label" bundle="${ph_labels}"/></th>
						</tr>
						<tr>
							<td class="label" ><fmt:message key="ePH.AllowMedicationReturn.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan='2'><input type="checkbox" name="allow_drug_return_yn" id="allow_drug_return_yn" value="Y" onClick="validateMedication(this)" <%=AllowDrugReturnYN%> id="Allow Medication Return">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.within.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="max_durn_for_op_med_rtn" id="max_durn_for_op_med_rtn"  <%=MaxDurnForOPMedRtn%> value="<%=MaxDurnForOPMedRtnValue%>" size="2" maxlength="4" class="NUMBER" id="Drug Return Within Days " onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);" ><label class="label"><fmt:message key="Common.days.label" bundle="${common_labels}"/></label> <!-- maxlength changed from 2 to 4 for  Bru-HIMS-CRF-419 [IN:045563]-->
<%
							if (AllowDrugReturnYN.equals("checked")) {
%>
								<img id="imgForWithin" src="../../eCommon/images/mandatory.gif" align="center" style="visibility:visible"></img>
<%
							}
							else {
%>
								<img id="imgForWithin" src="../../eCommon/images/mandatory.gif" align="center" style="visibility:hidden"></img>
<%
							}
%>
							</td>
							<td  class="label" colspan="2"><fmt:message key="ePH.MaxRetentionPeriodBeforeReturntoStock.label" bundle="${ph_labels}"/></td>
							<td class="label" ><input type="text" name="max_drug_retention_bef_rtn" id="max_drug_retention_bef_rtn"  <%=MaxDrugRetentionBefRtn %> value="<%=MaxDrugRetentionBefRtnValue%>"size="2" maxlength="4" class="NUMBER" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);"" id="Max Retention Period Before Return to Stock">&nbsp;<label class="label">&nbsp;<fmt:message key="Common.days.label" bundle="${common_labels}"/></label>&nbsp;<!-- validateForGreaterValue(<%=MaxDurnForOPMedRtnValue%>+'',this) Method commented for SCF 13909  from onBlur Event of text box--> <!-- MAXLENGTH increased to 4 for  TTM-SCF-0078 [IN:047180] -->
							</td>
						</tr>
					</table>

					<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="inpatient_table" style="visibility:hidden">
						<th colspan="7"><fmt:message key="ePH.PrescriptionRules.label" bundle="${ph_labels}"/></th><!-- Modified for MO-CRF-20085.1 ON 05/26/2016 -->
						<tr>
							<td class="label" width="25%"><fmt:message key="ePH.ConsiderStock.label" bundle="${ph_labels}"/></td>
							<td class="label"width="20%"><input type="checkbox" name="ip_consider_stock" id="ip_consider_stock" value="Y" <%=ip_consider_stock_status%> onClick="checkAllowStock(this)" >
							</td>
							<td class="label" width="25%" ><fmt:message key="ePH.AllowWithoutStock.label" bundle="${ph_labels}"/></td>
							<td class="label" width="*"><input type="checkbox" name="ip_allow_stock" id="ip_allow_stock" value="Y" <%=ip_allow_stock_status%> >
							</td>
						</tr>
						<tr>
							<!--<td class="label" id="dup_drug_legend_ip"><fmt:message key="ePH.AllowDuplicateDrug.label" bundle="${ph_labels}"/></td>  Modified for MO-CRF-20085.1  By Prathyusha on 05/18/2016 -->
							<!--<td class="label" colspan="3" id="duplicate_drug_ip"><input type="checkbox" name="allow_duplicate_drug_ip" id="allow_duplicate_drug_ip"  value="Y" <%-- <%=allow_duplicate_drug%> --%>></td>Modified for MO-CRF-20085.1  By Prathyusha on 05/18/2016  -->
						  	<td class="label" width="10%" id="dup_drug_legend_ip"><fmt:message key="ePH.AllowDuplicateDrug.label" bundle="${ph_labels}"/></td> 
						  	<td class="label" width="10%" id="duplicate_drug_ip"><input type="checkbox" name="allow_duplicate_drug_ip" id="allow_duplicate_drug_ip" onclick="chkSkipDuplicate(this)" value="Y" <%=allow_duplicate_drug%>></td>
						  	<!-- Added By  for MO-CRF-20085.1  By Prathyusha on 05/18/2016 start-->
						   <td class="label" width="10%"  id="skip_dup_alrt_ip"> <fmt:message key="ePH.SkipDuplicateAlert.label" bundle="${ph_labels}"/></td>
							<td class="label" width="10%"   id="skipdupalrt_ip"><input type="checkbox" name="skip_duplicate_alert_ip" id="skip_duplicate_alert_ip" onclick="skipDuplicate(this)" value="<%=skip_duplicate_alert_ip_val%>" <%=skip_duplicate_alert_ip_chk%> <%=skip_duplicate_alert_ip_disp%>></td>
						<!-- Added By  for MO-CRF-20085.1  By Prathyusha on 05/18/2016 end -->
						<!-- Added  for MO-CRF-20085.1 Modified version By Prathyusha on 05/26/2016  start -->
						<td class="label" width="10%"  id="overlap_duration_label_ip"> <fmt:message key="ePH.OverlapDuration.label" bundle="${ph_labels}"/></td>
						<td class="label" colspan="3"  id="overlapduration_ip"><input type="test" size="3" maxlength="3"  class="NUMBER" onBlur="checkIsNotZero(this, 'OverLap Duration');"  onKeyPress="return(ChkNumberInput(this,event,0));"  name="overlap_duration_ip" id="overlap_duration_ip"   value="<%=overlap_duration_ip_val%>" <%=overlap_duration_ip_disp%> /></td>
						<!-- Added  for MO-CRF-20085.1 Modified version By Prathyusha on 05/26/2016  end -->
						</tr>
						<!-- added for mms-kh-crf-0016 start -->
						<tr>
						 <td class="label" width="10%"  > <fmt:message key="ePH.Reconciliation.label" bundle="${ph_labels}"/></td>
							<td class="label" width="10%" colspan="6"><input type="checkbox" name="reconciliation_ip" id="reconciliation_ip"  value="Y" <%=reconciliation_ip_chk%>></td>
						</tr>
						<!-- added for mms-kh-crf-0016 END -->
						<th colspan="7"><fmt:message key="ePH.OrderRoutingDefaults.label" bundle="${ph_labels}"/></th><!-- Modified for MO-CRF-20085.1 ON 05/26/2016 -->
						<tr>
							<td class="label"><fmt:message key="ePH.RoutineOrders.label" bundle="${ph_labels}"/></td>
							<td class="label" ><select name="ip_disp_locn_rtn_ord" id="ip_disp_locn_rtn_ord" id="Routine Orders">
									<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
									for (int i=0;i<IPOrderRouting.size();i+=2){
										String select="";
										if (IPDispLocnRtn_ord.equals((String)IPOrderRouting.get(i)))
											select="selected";
%>
										<option value="<%=IPOrderRouting.get(i)%>" <%=select%>><%=IPOrderRouting.get(i+1)%></option>
<%
									}
%>
								</select>
							</td>
							<td class="label"><fmt:message key="ePH.StatOrder.label" bundle="${ph_labels}"/></td>
							<td class="label"><select name="ip_disp_locn_stat_ord" id="ip_disp_locn_stat_ord" id="Stat Orders">
									<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
									for (int i=0;i<IPOrderRouting.size();i+=2){
										String select="";
										if (IPDispLocnStat_ord.equals((String)IPOrderRouting.get(i)))
											select="selected";
%>
										<option value="<%=IPOrderRouting.get(i)%>" <%=select%> > <%=IPOrderRouting.get(i+1)%></option>
<%
									}
%>
								</select>
							</td>
						</tr>
						<tr>
							<td class="label" colspan="1"><fmt:message key="ePH.Discharge/TakeHomeMedication.label" bundle="${ph_labels}"/></td>
							<td class="label"><select name="disch_med_disp_locn" id="disch_med_disp_locn" id="Discharge/Take Home Medication">
									<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
									for (int i=0;i<IPMedication.size();i+=2){
										String select="";
										if (DischMedDispLocn.equals((String)IPMedication.get(i)))
											select="selected";
%>
										<option value="<%=IPMedication.get(i)%>" <%=select%>><%=IPMedication.get(i+1)%> </option>
<%
									}
%>
								</select>
							</td>

							<td></td>
						</tr> 
						<%
						if(patient_trans_app){		
						%>
						<tr>   
						<td class="label"> <fmt:message key="ePH.PatientTransPharType.label" bundle="${ph_labels}"/></td>
							<td class="label" >&nbsp;<input type="checkbox" <%=pat_trans_phar_checked%> onclick="assignValue(this)" name="pat_trans_phar_type" value="Y"></td>
							<td class="label"><fmt:message key="ePH.PatientTransOtherType.label" bundle="${ph_labels}"/></td>
							<td class="label" >&nbsp;<input type="checkbox" name="pat_trans_other_type" id="pat_trans_other_type" <%=pat_trans_other_disabled%> <%=pat_trans_other_checked%> value="Y">
							<input type="hidden" name="pat_trans_other_type_def" id="pat_trans_other_type_def" value="<%=pat_trans_other_type%>">
							</td>
						
						</tr>
						<%}%>
						<tr>
						<th colspan="1"><fmt:message key="Common.Stage.label" bundle="${common_labels}"/> </th>
						<th colspan="6">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.DispenseLocationControls.label" bundle="${ph_labels}"/></th><!-- Modified for MO-CRF-20085.1 ON 05/26/2016 -->
						</tr>
						<tr>
							<td class="label"><%=param_legends.get("V")%></td>
							<td class="label"><input type="checkbox" name="ip_verf_yn" id="ip_verf_yn" value="Y" <%=IPVerfYN%> id="Verify">
							</td>
							<td class="label" colspan="2">&nbsp;</td>
						</tr>
						<tr nowrap>
							<td class="label"><%=param_legends.get("F")%> Period</td>
<%
						String selectHours		= "";
						String selectDay		= "";
						String selectPrescPrd	= "";
						//String fill_Value		= "";
						if (IPFillPrdAheadUnit.equals("H")) {
							selectHours = "SELECTED";
							//fill_Value	= IPFillPrdAheadValue;
							disabled = "";
						}
						else if (IPFillPrdAheadUnit.equals("D")) {
							//fill_Value = 24*(Integer.parseInt(IPFillPrdAheadValue))+"";
							selectDay = "SELECTED";
							disabled = "";
						}
						else if (IPFillPrdAheadUnit.equals("P")) {
							selectPrescPrd = "SELECTED";
							disabled = "DISABLED";
						}
%>
						<td class="label">
						<!-- validateForGreaterValue(' pass fill_Value here',this, '1') -->
						<!--validateFillPeriodAgainstUnit(this,ip_fill_prd_unit,'max_durn_for_ip_pres')-->
							<input type="text" name="ip_fill_prd_ahead" id="ip_fill_prd_ahead" value="<%=IPFillPrdAheadValue%>" size="2" maxlength="2" <%= disabled %> class="NUMBER" id="Fill Period" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);">&nbsp;
							<select name="ip_fill_prd_unit" id="ip_fill_prd_unit" onChange="toggleEditingFill(this.value)">
								<OPTION VALUE="H" <%= selectHours %>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE="D" <%= selectDay %>><fmt:message key="Common.days.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE="P" <%= selectPrescPrd %>><fmt:message key="ePH.PrescribedPeriod.label" bundle="${ph_labels}"/></OPTION>
							</select>
						</td>
						<td class="label" nowrap><fmt:message key="ePH.ExcludeNewOrdersPlacedWithin.label" bundle="${ph_labels}"/></td>
						<td class="label" nowrap>
							<input type="text" name="ip_fill_excl_prd_behind" id="ip_fill_excl_prd_behind" class="NUMBER" value="<%=IPFillExclPrdBehindValue%>" size="6" maxlength="6" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);" id="Exclude New Orders Placed before">&nbsp;<fmt:message key="ePH.HoursofScheduledStart.label" bundle="${ph_labels}"/>
						</td>
					</tr>
					<tr>
						<td class="label"><%=param_legends.get("D")%></td>
						<td class="label"><input type="checkbox" name="ip_delv_reqd_yn" id="ip_delv_reqd_yn" value="Y" <%=IPDelvReqdYN%> id="Delivery">
						</td>

						<td class="label"><fmt:message key="ePH.Continuous/IntermittentOrdersScheduleStart.label" bundle="${ph_labels}"/></td>
						<td class="label"><input type="text" name="ip_fill_dflt_start_time" id="ip_fill_dflt_start_time" class="NUMBER" value="<%=IPFillDfltStartTimeValue%>" onBlur="appedzero(this);CheckTime(this);" size="5" maxlength="5" id="Continuous/Intermittent Orders Schedule Start">
						</td>
					</tr>
					
					<tr>
						<td class="label"><fmt:message key="ePH.ENABLEDAILYSEQUENCENUMBER.label" bundle="${ph_labels}"/></td>
						<td class="label"><input type="checkbox" name="ip_daily_seq_no_yn" id="ip_daily_seq_no_yn" value="Y" <%=IPDailySeqNoYN%> id="Daily_Seq_No">
						</td>
<!-- =========== PMG20089-CRF-0675 to default the start time for Incremental IP Fill Process --23-Jan-2010-- shyampriya ========= -->
						<td class="label"><fmt:message key="ePH.DEFAULTIPFILLINCREMENTALPROCESSWITH.label" bundle="${ph_labels}"/></td>

						<td  class="label"><select name="dflt_ip_fill_incr_start_with" id="dflt_ip_fill_incr_start_with" id="dflt_ip_fill_incr_start_with">
<%
								String selected = "";
								if(dflt_ip_fill_incr_start_with.equals("S"))
									selected = "selected";
								else
									selected = "";
%>
									<option value="S" <%=selected%>><fmt:message key="ePH.SYSTEMTIME.label" bundle="${ph_labels}"/></option>
<%
								if(dflt_ip_fill_incr_start_with.equals("T"))
									selected = "selected";
								else
									selected = "";
%>
									<option value="T" <%=selected%>>00:01</option>

								</select>
							</td>
					</tr>
					<tr><!-- Adding start for ML-BRU-CRF-0473 -->
					        <td class="label">
						
							<%if(allow_zero_disp_label_site){ %>
							<fmt:message key="ePH.INCLUDE_ZERO_FILL_ITEMS.label" bundle="${ph_labels}"/>	</td>
							<td class="label">
							
							<input type="checkbox" name="include_zero_allocated_items_in_dispensing_for_ip" id="include_zero_allocated_items_in_dispensing_for_ip" value="Y" <%=includeZeroAllocatedItemsIPYN%> id="include_zero_allocated_items_in_dispensing_for_ip">&nbsp;
							<%}else{ %>
							<input type="hidden" name="include_zero_allocated_items_in_dispensing_for_ip" id="include_zero_allocated_items_in_dispensing_for_ip" value="N"  id="include_zero_allocated_items_in_dispensing_for_ip">&nbsp;
							<%}%>
							</td>
					</tr><!-- Adding end for ML-BRU-CRF-0473 -->
					<!--Added for MMS-KH-CRF-0028 start -->	
							<%if(intractn_req_yn){ %>
							<tr>
								<td class="label"><fmt:message key="ePH.VerificationStatusReviewAprroveforpatientclass.label" bundle="${ph_labels}"/></td>
						<td class="label" >
								<input type="checkbox" name="review_aprrove_applicable_for_ip" id="review_aprrove_applicable_for_ip" value="Y"  <%=review_aprrove_applicable_for_ip_checked%> />
						</td>
									
								
							</tr>
							
							<%} %>
							<!--Added for MMS-KH-CRF-0028 end -->
						<th colspan="8"><fmt:message key="ePH.DefaultOrderDateDipensing.label" bundle="${ph_labels}"/></th> <!-- Added for AMS-CRF-0009[IN:030935] -start colspan="6" changed to colspan="8" for GHL-CRF-0412.3 -->
						<tr>
							<td class="label" ><fmt:message key="ePH.DefaultOrderFromDate.label" bundle="${ph_labels}"/></td>
							<td class="label">
								<input type="checkbox" name="disp_before_start_date_yn_ip" id="disp_before_start_date_yn_ip" value="Y"  <%=DispBeforeStartDateYN_IP_checked%> id="Idisp_before_start_date_yn_ip"  onClick="validateDispensingRulesInPatient(this)"  >&nbsp;
							</td>
							<td class="label" ><fmt:message key="ePH.UptoNoofDays.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan='3'>
								<input type="text" name="disp_beyond_no_of_days_ip" id="disp_beyond_no_of_days_ip" value="<%=DispBeyondNoOfDaysValue_IP%>" size="3" maxlength="3"  class="NUMBER" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);" id="disp_beyond_no_of_days_ip" <%=NoOfDays_Disabled%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img> 
							</td>
						</tr>
						<tr>
							<td class="label" ><fmt:message key="ePH.DefaultOrderToDate.label" bundle="${ph_labels}"/></td>
							<td class="label" >
							<input type="checkbox" name="disp_beyond_earliest_start_yn_ip" id="disp_beyond_earliest_start_yn_ip" value="Y"  <%=DispBeyondEarliestStartYN_IP_checked%>  onClick="validateDispensingPastOrdersInPatient(this)" id="disp_beyond_earliest_start_yn_ip">&nbsp;
							</td>
							<td class="label" ><fmt:message key="ePH.NoofdaysAhead.label" bundle="${ph_labels}"/></td>
							<td class="label" colspan="3">
								<input type="text" name="disp_before_no_of_days_ip" id="disp_before_no_of_days_ip" value="<%=DispBeforeNoOfDaysValue_IP%>" size="3" maxlength="3"   class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);" id="No_of_days_ahead" <%=EarliestStart_Disabled%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center" ></img> 
							</td>
						</tr> <!--Added for AMS-CRF-0009[IN:030935] -end  -->
<%
                        if(approval_no_app)   //Added for AAKH-CRF-1117
                        {
%>					
						<tr>   <!-- Added for AAKH-CRF-1117 -->
						<td class="label"><fmt:message key="ePH.ApprovalNoRequiredInDispMedication.label" bundle="${ph_labels}"/></td>
						<td><input type="checkbox" name="approval_no_yn_ip" id="approval_no_yn_ip" value="Y" <%=approval_no_yn_ip%>   id="approval_no_yn_ip"></td> <!--modified for AAKH-CRF-0117 -->
						 
						</tr>
<%
                        }  
%>
						
					<th colspan="8" ><fmt:message key="ePH.Labels.label" bundle="${ph_labels}"/></th> <!-- colspan 4 changed to 8 for GHL-CRF-0412.3 -->
					<tr >
						<td class="label"><fmt:message key="ePH.LabelFormat.label" bundle="${ph_labels}"/></td>
						<td class="label"><select name="ip_label_format" id="ip_label_format" id="Label Format">
								<option value="" >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
								<option value="D" <%=IPLabelFormatDrug%>><fmt:message key="ePH.DrugWise.label" bundle="${ph_labels}"/></option>
								<!-- <option value="C" <%=IPLabelFormatCombined%>><fmt:message key="ePH.Combined.label" bundle="${ph_labels}"/></option> -->
							</select>
						</td>
						<td class="label" ><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Language.label" bundle="${common_labels}"/></td>
						<td class="label"><select name="dflt_lang_for_disp_label_ip" id="dflt_lang_for_disp_label_ip" id="Label Language">
								<option value=""><fmt:message key="Common.none.label" bundle="${common_labels}"/></option>
<%
								if(alLanguageIds!=null && alLanguageIds.size()>0){ //Added for MMS-QH-CRF-0069 [IN:037977]
									for(int i=0; i<alLanguageIds.size();i+=2){
										if(dflt_lang_for_disp_label_ip.equals((String)alLanguageIds.get(i))){
%>
											<option value="<%=(String)alLanguageIds.get(i)%>" selected><%=(String)alLanguageIds.get(i+1)%></option>
<%
										}
										else{
%>
											<option value="<%=(String)alLanguageIds.get(i)%>" ><%=(String)alLanguageIds.get(i+1)%></option>
<%
										}
									}
								}
%>
							</select>
						</td>
						</tr>
						<th colspan="8" ><fmt:message key="ePH.DRUGRETURN.label" bundle="${ph_labels}"/></th> <!-- Added for for GHL-CRF-0412.3  - Start-->
						<tr>
						 <td class="label"><fmt:message key="ePH.RetMedRestr.label" bundle="${ph_labels}"/></td>
						<td class="label" ><select name="ret_med_restr_stage" id="ret_med_restr_stage">
								<option value="N" <%=defaultSelect1%>>---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option> <!--  N stands for Nothing -->
<%                              if(isSite){
%>
								<option value="I" <%=initPreSelected%> ><fmt:message key="ePH.InitPreDisc.label" bundle="${ph_labels}"/></option>
<%                              }
%>
								<option value="P" <%=prepaDisAdvSelected%>><fmt:message key="ePH.PrepDischAdvice.label" bundle="${ph_labels}"/></option>
								<option value="D" <%=dischPatSelected%>><fmt:message key="ePH.Discharge.label" bundle="${ph_labels}"/></option>
							</select>
						</td>
						</tr> <!-- Added for for GHL-CRF-0412.3  - End-->
						<!-- Added for for MMS-KH-CRF-0014  START-->
						<tr>
						 <td class="label"><fmt:message key="ePH.WardAckApplicableLabel.label" bundle="${ph_labels}"/></td>
						<td class="label" >
								<input type="checkbox" name="ward_ack_required_yn" id="ward_ack_required_yn" value="Y"  <%=ward_ack_required_yn_checked%> >
						</td>
						
						</tr> 
						<!-- Added for for MMS-KH-CRF-0014  END-->
<%
				}
%>
				</table>
					
				<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="ivadmixture_table" style="visibility:hidden">
					<th colspan="8" id="op_adm_app"><fmt:message key="ePH.AdmixtureApplicability.label" bundle="${ph_labels}"/></th>
					<tr ><td colspan="8">&nbsp;</td></tr>
					<tr><td class="label" style="visibility:hidden"><fmt:message key="ePH.WorkinghoursforthePreparationroomFrom.label" bundle="${ph_labels}"/></td>
						<td class="label" style="visibility:hidden">&nbsp;&nbsp;<input type="text" name="working_hours_of_prep_room_from" id="working_hours_of_prep_room_from" size="5" maxlength="5" value= "<%=working_hrs_of_prep_room_from %>"  onBlur="chkforvalidity();validate(this);" >&nbsp;&nbsp;To <input type="text" name="working_hours_of_prep_room_to" id="working_hours_of_prep_room_to" size="5" maxlength="5" value="<%=working_hrs_of_prep_room_to %>" onBlur="chkforvalidity();validate(this);enablefields(this);" ></td>
						<td colspan="2"></td>
					</tr>
					<tr>
					  <td class="label"><fmt:message key="ePH.AlertorderingPractitionerbeyondworkinghours.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;<input type="checkbox" name="alert_beyond_working_hours" id="alert_beyond_working_hours"  <%=alert_practitioner_yn %>>
						</td><td colspan="2"></td>
					</tr>
					<tr>
					  <td class="label"><fmt:message key="ePH.IVAdmixtureapplicable.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;<input type="checkbox" name="iv_admixture_applicable" id="iv_admixture_applicable" onclick="enableqty();" <%=iv_admixture_appl_yn %>>
						</td><td colspan="2"></td>
					</tr>
					<tr>
					
					  <td class="label"><fmt:message key="ePH.OncologyAdmixtureapplicable.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;<input type="checkbox" name="cdr_admixture_applicable" id="cdr_admixture_applicable" onclick="enableqty();" <%=cdr_admixture_appl_yn %> >
						</td><td colspan="2"></td>
					</tr>
					<tr>
					  <td class="label"><fmt:message key="ePH.PreparationofTPNNon-standardregimenapplicable.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;<input type="checkbox" name="prep_of_tpn_non_std_regimen" id="prep_of_tpn_non_std_regimen" onclick="enableqty();" <%=tpn_regimen_appl_yn %> >
						</td><td colspan="2"></td>
					</tr>
					<tr>
					  <td class="label"><fmt:message key="ePH.AdmixturePreparationChargesApplicable.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;<input type="checkbox" name="admx_prep_charges_appl_yn" id="admx_prep_charges_appl_yn"  
						<%=admx_prep_charges_appl_yn%> >
						</td><td colspan="2"></td>
					</tr>
					
					
					<tr ><td colspan="8">&nbsp;</td></tr>
				</table>
					
				<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="adr_table" style="visibility:hidden">
					<tr ><td colspan="8">&nbsp;</td></tr>
<%
					String dis_ena_flag="";
					if(start_adr_no.equals(""))
						dis_ena_flag="";
					else
						dis_ena_flag="readonly";
%>
					<tr><td class="label"><fmt:message key="ePH.ADRStartNo.label" bundle="${ph_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<input type="text" name="start_adr_no" id="start_adr_no" class="number" size="5" maxlength="6" value= "<%=start_adr_no%>" <%=dis_ena_flag%> onBlur="CheckNum(this)"></td>
<% 
						 String vis="hidden";
						 if (!last_adr_no.equals(""))
							 vis="visible";
						 else
							 last_adr_no=start_adr_no;
%>
						<td class="label"><label class="label" style="visibility:<%=vis%>"><fmt:message key="ePH.CurrentADRNo.label" bundle="${ph_labels}"/> : </label>&nbsp;&nbsp; <label name="last_adr_no" style="visibility:<%=vis%>" class="number" size="5" maxlength="6"><B><%=last_adr_no%></B></label>
					</tr>
					<tr>
						<td class="label"><fmt:message key="ePH.VerifyTDMOrder.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;<input type="checkbox" name="verify_tdm_order_yn" id="verify_tdm_order_yn" <%=verify_tdm_order_yn%>>
						</td><td colspan="2"></td>
					</tr>
					<input type="hidden" name="discrete_mes_query" id="discrete_mes_query" value="<%=discrete_query%>">
					<input type="hidden" name="ca_note_type_query" id="ca_note_type_query" value="<%=note_types_query%>">
					<input type="hidden" name="ca_note_type_scrng_query" id="ca_note_type_scrng_query" value="<%=note_types_scrng_query%>">

						<tr><td class="label"><fmt:message key="ePH.TDMReportingtype.label" bundle="${ph_labels}"/></td>
						<td colspan=3>&nbsp;&nbsp;<select name="tdm_result_type" id="tdm_result_type" onchange="cleardata('TDM')"readonly>
							<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------- </option>
							<option value='D' <%=tdm_result_type_select_1%>><fmt:message key="Common.DiscreteMeasurePanel.label" bundle="${common_labels}"/> </option>
							<option value='N' <%=tdm_result_type_select_2%>> <fmt:message key="Common.note.label" bundle="${common_labels}"/> </option>

						</select>
						<input type="text" name="tdm_reporting_type_name" id="tdm_reporting_type_name" maxlength="40" size="20" value="<%=tdm_result_type_desc%>" readonly><input type="button" class="button" value="?" name="tdm_reporting_type_search" id="tdm_reporting_type_search" onclick="reporting(this,'TDM');"><input type="hidden" name="tdm_reporting_id" id="tdm_reporting_id" id='tdm_reporting_id' value="<%=tdm_result_type_id%>">                      
						</td>
					</tr>
					<tr>
						<td class="label"><fmt:message key="ePH.PatientCounsellingReportingType.label" bundle="${ph_labels}"/></td>
						<td colspan=3>&nbsp;&nbsp;<select name="pat_couns_result_type" id="pat_couns_result_type" onchange="cleardata('PAT_COUNS')"readonly>
							<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------- </option>
							<option value='D' <%=pat_couns_result_type_select_1%>><fmt:message key="Common.DiscreteMeasurePanel.label" bundle="${common_labels}"/></option>
							<option value='N' <%=pat_couns_result_type_select_2%>> <fmt:message key="Common.note.label" bundle="${common_labels}"/> </option>
						</select>
						<input type="text" name="pat_couns_reporting_type_name" id="pat_couns_reporting_type_name" maxlength="40" size="20" value="<%=pat_couns_result_type_desc%>"readonly><input type="button" class="button" value="?" name="pat_couns_reporting_type_search" id="pat_couns_reporting_type_search" onclick="reporting(this,'PAT_COUNS');">
						<input type="hidden" name="pat_couns_reporting_id" id="pat_couns_reporting_id" id='pat_couns_reporting_id' value="<%=pat_couns_result_type_id%>">
						</td>
					</tr>
					<tr ><td colspan="8">&nbsp;</td></tr>
					<!-- ENHANCEMENT MADE BY SANDHYA on DT:9/10/08 -->
					
					 <tr><td class="label"><fmt:message key="ePH.TPNScreeningform.label" bundle="${ph_labels}"/></td>
						<td colspan='3'>&nbsp;&nbsp;<select name="tpn_screening_type" id="tpn_screening_type" onchange="cleardata('TPN')" <%=tpn_rx_chk_status%>>
							<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------- </option>
							<option value='D' <%=tpn_screening_type_select_1%>><fmt:message key="Common.DiscreteMeasurePanel.label" bundle="${common_labels}"/> </option>
							<option value='N' <%=tpn_screening_type_select_2%>> <fmt:message key="Common.note.label" bundle="${common_labels}"/> </option>

						</select>
						<input type="text" name="tpn_reporting_type_name" id="tpn_reporting_type_name" maxlength="40" size="20" value="<%=tpn_screening_type_desc%>"  <%=tpn_rx_chk_status%>><input type="button" class="button" value="?" <%=tpn_rx_chk_status%> name="tpn_reporting_type_search" onclick="reporting(tpn_reporting_type_name,'TPN');" ><input type="hidden" name="tpn_reporting_id" id="tpn_reporting_id" id='tpn_reporting_id' value="<%=tpn_screening_form_id%>">                      
						</td>
					</tr>
					<%if(assesmentApplYn){ // Added for ML-MMOH-CRF-1126 - Start%>
					<tr>
						<td class="label"><fmt:message key="ePH.AssessmentApplicable.label" bundle="${ph_labels}"/></td>
						<td>&nbsp;<input type="checkbox" name="assesment_req_yn" id="assesment_req_yn" value="Y" id="assesment_req_yn" <%=assesment_req_yn%>>
						</td><td colspan="2"></td>
					</tr>
                    <%} // Added for ML-MMOH-CRF-1126 - End %>
					<tr><td class="label"><fmt:message key="ePH.OncologyScreeningform.label" bundle="${ph_labels}"/></td>
						<td colspan='3'>&nbsp;&nbsp;<select name="oncology_screening_type" id="oncology_screening_type" onchange="cleardata('ONCOLOGY')" <%=oncology_rx_chk_status%> >
							<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------- </option>
							<option value='D' <%=onc_screening_type_select_1%>><fmt:message key="Common.DiscreteMeasurePanel.label" bundle="${common_labels}"/> </option>
							<option value='N' <%=onc_screening_type_select_2%>> <fmt:message key="Common.note.label" bundle="${common_labels}"/> </option>
							
						</select>
						<input type="text" name="onc_reporting_type_name" id="onc_reporting_type_name" maxlength="40" size="20" value="<%=onc_screening_type_desc%>"  <%=oncology_rx_chk_status%>><input type="button" class="button" value="?" <%=oncology_rx_chk_status%> name="onc_reporting_type_search" onclick="reporting(this,'ONCOLOGY');"><input type="hidden" name="onc_reporting_id" id="onc_reporting_id" id='onc_reporting_id' value="<%=oncology_screening_form_id%>">                      
						</td>
					</tr>
					<tr><!--Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016 starts-->
							<td  class="label" nowrap><fmt:message key="ePH.DefaultGenericTDM.label" bundle="${ph_labels}"/></td>
							<td align="left" class="label"><input type="text" name="generic_name" id="generic_name" maxlength="40" size="20" value="<%=generic_name%>" > 
							<input type="button" class="button" value="?" name="p_generic_desc" id="p_generic_desc" onfocus="callGenericSearch(document.parameter_facility_form.generic_name)" onClick="callGenericSearch(document.parameter_facility_form.generic_name)">
							</td>
							<INPUT type="hidden" name="sql_ph_generic_name_select_lookup" id="sql_ph_generic_name_select_lookup" value="<%=sql_ph_generic_name_select_lookup%>">
							<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
							<input type="hidden" name="generic_code" id="generic_code" value="<%=bean.getGeneric_Code()%>">
							</tr>
					<tr>
							<td  class="label"  BORDER="0" ID="time_links" ><fmt:message key="ePH.OfficeHourTDM.label" bundle="${ph_labels}"/></td>
							<td><fmt:message key="Common.from.label" bundle="${common_labels}"/>
							<input type="text" name="working_hour_from" id="working_hour_from" size="3" maxlength="5" value= "<%=working_hours_from%>" onBlur="validate1(this);">&nbsp;<IMG 	SRC="../../eCommon/images/mandatory.gif" BORDER="0" ></IMG>
							<fmt:message key="Common.to.label" bundle="${common_labels}"/>
							<input type="text" name="working_hour_to" id="working_hour_to" size="3" maxlength="5" value="<%=working_hours_to %>" onBlur="validate1(this);">&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0" ></IMG>
							</td>
					</tr><!--//Added for HSA-CRF-0239 [IN:051707] by B.Badmavathi on 30/01/2016 ends-->
				</table>
				<table cellpadding=0 cellspacing=0 width="100%" align="left"  border="0" id="medicationadministration_table" style="visibility:hidden">
					<tr>
						<td width='30%' colspan='3' class="label"><fmt:message key="ePH.MedicationAdministrationRequired.label" bundle="${ph_labels}"/></td>
						<td width='15%' colspan='2' class="field"><input type="checkbox" name="med_admin_reqd_yn" id="med_admin_reqd_yn" value="Y" onclick='selectchk(this)' <%=med_admin_reqd_yn%>>
						</td>
						<td width='25%'   class="label"><fmt:message key="Common.MedicationAdministration.label" bundle="${common_labels}"/>&nbsp;-&nbsp;<fmt:message key="ePH.scheduleLevel.label" bundle="${ph_labels}"/></td><!--  SKR-CRF-0037 [IN:037656] START-->
						<td width='*' class="field"><input type="checkbox" name="mar_sch_level_yn" id="mar_sch_level_yn" value="Y" <%=mar_sch_level_chk%> onclick='enableDisableNewMARFields(this);'>
						</td><!--  SKR-CRF-0037 [IN:037656] END  -->  
					</tr>
					<!-- new checkbox: PIN Authentication for Drug Category Required  13/10/08-->
					<tr>
						<td colspan='3' class="label"><fmt:message key="ePH.PINAuthenticationforDrugCategoryRequired.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="field"><input type="checkbox" name="drug_cat_pin_auth_reqd_yn" id="drug_cat_pin_auth_reqd_yn" value="Y" <%=drug_cat_pin_auth_reqd_yn%>>
						</td>
						<td  class="label"><fmt:message key="ePH.displayRecordsFrom.label" bundle="${ph_labels}"/></td><!--  SKR-CRF-0037 [IN:037656] START-->
						<td class="field">
							<select name="mar_start_ind" id="mar_start_ind" onchange='getMARDefDispDays(this);' <%=mar_sch_level_disable%>>
								<OPTION value="S" <%=mar_start_ind.equals("S")?"selected":"" %>><fmt:message key="ePH.startingDayOfWeek.label" bundle="${ph_labels}"/></OPTION>
								<OPTION value="C" <%=mar_start_ind.equals("C")?"selected":"" %>><fmt:message key="Common.CurrentDate.label" bundle="${common_labels}"/></OPTION>
								<OPTION value="U" <%=mar_start_ind.equals("U")?"selected":"" %>><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Option.label" bundle="${common_labels}"/></OPTION>
							</select>&nbsp;
							<select name="mar_week_day_start" id="mar_week_day_start" style='<%=mar_week_day_start_disp%>;' <%=mar_sch_level_disable%>>
								<OPTION value="0" <%=mar_week_day_start.equals("0")?"selected":"" %>><fmt:message key="Common.sun.label" bundle="${common_labels}"/></OPTION>
								<OPTION value="1" <%=mar_week_day_start.equals("1")?"selected":"" %>><fmt:message key="Common.mon.label" bundle="${common_labels}"/></OPTION>
								<OPTION value="2" <%=mar_week_day_start.equals("2")?"selected":"" %>><fmt:message key="Common.tue.label" bundle="${common_labels}"/></OPTION>
								<OPTION value="3" <%=mar_week_day_start.equals("3")?"selected":"" %>><fmt:message key="Common.wed.label" bundle="${common_labels}"/></OPTION>
								<OPTION value="4" <%=mar_week_day_start.equals("4")?"selected":"" %>><fmt:message key="Common.thu.label" bundle="${common_labels}"/></OPTION>
								<OPTION value="5" <%=mar_week_day_start.equals("5")?"selected":"" %>><fmt:message key="Common.fri.label" bundle="${common_labels}"/></OPTION>
								<OPTION value="6" <%=mar_week_day_start.equals("6")?"selected":"" %>><fmt:message key="Common.sat.label" bundle="${common_labels}"/></OPTION>
							</select>
						</td><!--  SKR-CRF-0037 [IN:037656] END-->
					</tr>
					<tr>
						<td colspan='3' class="label"><%=param_legends.get("V")%> <fmt:message key="ePH.RequiredBeforeDrugAdministration.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="field"><input type="checkbox" name="verf_reqd_bef_med_admin_yn" id="verf_reqd_bef_med_admin_yn" value="Y" <%=verf_reqd_bef_med_admin_yn%>>
						</td>
						<td class="label">&nbsp;</td>
						<td class="data"  id='defDispDayUserDefined'  style='<%=defDispDayUserDefined_disp%>;'><!--  SKR-CRF-0037 [IN:037656] START-->
							<fmt:message key="Common.Past.label" bundle="${common_labels}"/>&nbsp;
							<input type='text' name='mar_past_day' id='mar_past_day' value='<%=mar_past_day%>' class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);checkMaxDays('P');" maxlength="1" size="2"><img src="../../eCommon/images/mandatory.gif" >&nbsp;
							<fmt:message key="Common.Day(s).label" bundle="${common_labels}"/>&nbsp;&nbsp;
							<fmt:message key="Common.Future.label" bundle="${common_labels}"/>&nbsp;
							<input type='text' name='mar_future_day' id='mar_future_day' value='<%=mar_future_day%>' class="NUMBER"  onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);checkSplChars(this);checkMaxDays('F');" maxlength="1" size="2"><img src="../../eCommon/images/mandatory.gif" >&nbsp;<fmt:message key="Common.Day(s).label" bundle="${common_labels}"/>
						</td><!--  SKR-CRF-0037 [IN:037656] END-->
					</tr>
					<tr>
						<td colspan='3'class="label"><fmt:message key="ePH.RecordAdministrationWithin.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="field"><input type="text" name="rec_admin_within_hrs" id="rec_admin_within_hrs" size="2" maxlength="2" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="CheckNum(this);validateRecordAdmin(this)" value="<%=rec_admin_within_hrs%>">&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/>
						</td>
						<td class="label"><fmt:message key="ePH.displayOrderby.label" bundle="${ph_labels}"/></td><!--  SKR-CRF-0037 [IN:037656] START-->
						<td class="field">
							<select name="mar_default_order_by" id="mar_default_order_by" <%=mar_sch_level_disable%>>
								<OPTION value="D" <%=mar_default_order_by.equals("D")?"selected":""%>><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></OPTION>
								<OPTION value="F" <%=mar_default_order_by.equals("F")?"selected":""%>><fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/></OPTION>
								<OPTION value="O" <%=mar_default_order_by.equals("O")?"selected":""%>><fmt:message key="ePH.OrderDate/Time.label" bundle="${ph_labels}"/></OPTION>
							</select>
						</td><!--  SKR-CRF-0037 [IN:037656] END-->
					</tr>
					<tr>
						<td  colspan='3'class="label"><fmt:message key="ePH.AllowMedicationAdministrationWithoutorder.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="field"><input type="checkbox" name="allow_med_admin_wo_ord_yn" id="allow_med_admin_wo_ord_yn" value="Y" <%=allow_med_admin_wo_ord_yn%> onclick='enableWitness(this);'>
						</td>
						<td class="label"><fmt:message key="ePH.allowRecordDiscDose.label" bundle="${ph_labels}"/></td><!--  SKR-CRF-0037 [IN:037656] START-->
						<td class="field"><input type="checkbox" name="mar_disc_dose_yn" id="mar_disc_dose_yn" value="Y" <%=mar_disc_dose_chk%> <%=mar_sch_level_disable%>> 
						</td><!--  SKR-CRF-0037 [IN:037656] END-->
					</tr>
					<tr><!-- Added for AAKH-CRF-0023[IN:038259] start -->
						<td  colspan='3'class="label"><fmt:message key="ePH.WitnessforVerbalOrder.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="field"><input type="checkbox" name="witness_for_verbal_order_yn" id="witness_for_verbal_order_yn" value="Y" <%=witness_for_verbal_order_yn%> <%=witness_for_verbal_order_disable%> ></td>
						<td class="label"></td>
						<td class="label"></td>
					</tr><!-- Added for AAKH-CRF-0023[IN:038259] end -->
					<tr>
						<td colspan='3' class="label"><fmt:message key="ePH.RecordAdministrationBeforeScheduleTime.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="field"><input type="text" name="rec_admin_bef_schdle_time" id="rec_admin_bef_schdle_time" size="2" maxlength="2" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="validateAdministerBeforeScheduleTime(this,rec_admin_bef_schdle_time_UOM)" value="<%=rec_admin_bef_schdle_time%>">&nbsp;<select name="rec_admin_bef_schdle_time_UOM" id="rec_admin_bef_schdle_time_UOM" onChange='validateAdministerBeforeScheduleTime(rec_admin_bef_schdle_time,this)'>
						<option value="M" <%=rec_admin_bef_schdle_time_selM%>><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option> 
						<option value="H" <%=rec_admin_bef_schdle_time_selH%>><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option> </select>
						</td>
						<td class="label"><fmt:message key="ePH.IVComplnDateTime.label" bundle="${ph_labels}"/></td><!--  SKR-CRF-0037 [IN:037656] START-->
						<td class="field">
							<select name="mar_iv_compl_dt_ind" id="mar_iv_compl_dt_ind" <%=mar_sch_level_disable%>>
								<OPTION value="C" <%=mar_iv_compl_dt_ind.equals("C")?"selected":""%>><fmt:message key="Common.CurrentDateTime.label" bundle="${common_labels}"/></OPTION>
								<OPTION value="I" <%=mar_iv_compl_dt_ind.equals("I")?"selected":""%>><fmt:message key="ePH.calcByInfuseOver.label" bundle="${ph_labels}"/></OPTION>
							</select>
						</td><!--  SKR-CRF-0037 [IN:037656] END-->
					</tr>
					
					<tr><!--  RUT-CRF-0035 [IN029926] PIN Authentication Checkbox added  -->
						<td  colspan='3'class="label"><fmt:message key="ePH.PinAuthInMAR.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="field"><input type="checkbox" name="pin_auth_mar_yn" id="pin_auth_mar_yn" value="Y" <%=pin_auth_mar_yn%>>
						</td>
						<td class="label"><fmt:message key="ePH.MARAlternateDrug.label" bundle="${ph_labels}"/></td><!-- MARAlternateDrug Checkbox Added for Bru-HIMS-CRF-399 [IN:043767] -->
						<td class="label"><input type="checkbox" name="allow_auto_disp_alt_drug_mar" id="allow_auto_disp_alt_drug_mar" value="Y" <%=allow_mar_alternate_drug_check%> ></td>
					</tr>
					<tr><!--  RUT-CRF-0035 [IN029926] PIN Authentication Checkbox added  -->
						<td  colspan='3'class="label"><fmt:message key="ePH.PrintLabel.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="field"><input type="checkbox" name="print_mar_label_yn" id="print_mar_label_yn" value="Y" <%=print_mar_label_yn%> >
						</td>
						<%if(late_or_early_admin_yn){ // Added for GHL-CRF-0482 [IN:064955] - Start%>					  
						<td class="label"><fmt:message key="ePH.LateOrEarlyAdmin.label" bundle="${ph_labels}"/></td>
						<td class="label" ><input type="checkbox" name="lateOrEarlyAdmin" id="lateOrEarlyAdmin" value= "Y" <%=late_or_early_admin_check%>>
						</td>					  
                       <%} // Added for GHL-CRF-0482 [IN:064955] - End %>
                        
					</tr>
<%				 if(display_mar_for_dispensed_unbilled_medication) {
%>	
					<tr><!--  NMC-JD-CRF-0186 added  -->
						<td class="label" colspan='3'><fmt:message key="ePH.AllowMARforDispensedUnbilledMedications.label" bundle="${ph_labels}"/></td>
						<td class="field" colspan='2'><input type="checkbox" name="mar_disp_unbilled_med_yn" id="mar_disp_unbilled_med_yn" value="Y" <%=mar_disp_unbilled_med_yn%> ></td> <!-- modified for NMC-JD-CRF-0186 -->
						<td class="label"></td> 
					</tr>
<%				} %>	
					<tr><!--  RUT-CRF-0035 [IN029926] PIN Authentication Checkbox added  -->
						<td  colspan='3'class="label"><fmt:message key="ePH.DisplayHeld/DiscontinuedOrders.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="field"><input type="checkbox" name="mar_disp_held_disc_orders_yn" id="mar_disp_held_disc_orders_yn" value="Y" <%=mar_disp_held_disc_check%> >
						</td>
						<td class="label"></td>
						<td class="label"></td> 
					</tr>
					<tr><!-- added for HSA-CRF-0090 [IN:041241]   -->
						<td  colspan='3'class="label"><fmt:message key="ePH.MARSharedDrug.label" bundle="${ph_labels}"/></td>
						<td colspan='2' class="field"><input type="checkbox" name="allow_mar_share_drug_yn" id="allow_mar_share_drug_yn" value="Y" <%=allow_mar_share_drug_check%> >
						</td>
						<!-- <td class="label"></td>-->
						<!--<td class="label"></td> commented for MMS-KH-CRF-0014 -->
						<!-- Added  for MMS-KH-CRF-0014  START-->
            <td class="label"><fmt:message key="ePH.WardAckRequiredLabel.label" bundle="${ph_labels}"/></td>
						<td class="label" >
								<input type="checkbox" name="ward_ack_mar_required_yn" id="ward_ack_mar_required_yn" value="Y"  <%=ward_ack_mar_required_yn_checked%> >
						</td>
					</tr>
						<!-- Added  for MMS-KH-CRF-0014  END-->
					<!--  RUT-CRF-0062 [IN029600] Rule Based check box added   begin-->
					<th colspan='6'><fmt:message key="Common.ApplicablePatientClasses.label" bundle="${common_labels}"/><th>
					<tr>
						  <td width="15%" class="label">
								<fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
						  </td>
						  <td width="5%" class="field">
								<input type="checkbox" name="inpatient_yn" id="inpatient_yn" onclick="validateInpat(this)" value="Y" <%=inpatient_yn%>>
						  </td>
						  <td class="label" width="15%">
								<fmt:message key="ePH.RuleBased.label" bundle="${ph_labels}"/> 
								<input type="checkbox" name="inpatient_yn_rule_check" id="inpatient_yn_rule_check" value="Y" <%=inpatient_yn_rule_check%>   <%=inpatient_yn_rule_disab%>>
						   </td>
						   <td class="label" width="10%">
							   <fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
						   </td>   
						   <td class="field" width="5%">
							   <input type="checkbox" name="Outpatient_yn" id="Outpatient_yn" onclick="validateOutpat(this)" value="Y" <%=Outpatient_yn%>>
						   </td>
						   <td class="label"  colspan='2'>
								<fmt:message key="ePH.RuleBased.label" bundle="${ph_labels}"/>
								<input type="checkbox" name="outpatient_yn_rule_check" id="outpatient_yn_rule_check" value="Y" <%=outpatient_yn_rule_check%>  <%=outpatient_yn_rule_disab%>>
						   </td>	
						   
					</tr> 
					<tr>
						<td class="label">
							<fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
						</td>
						<td class="field">
							<input type="checkbox" name="Daycare_yn" id="Daycare_yn" onclick="validateDayCare(this)"  value="Y" <%=Daycare_yn%>>&nbsp;
						</td>
						<td class="label" >
								<fmt:message key="ePH.RuleBased.label" bundle="${ph_labels}"/>
								<input type="checkbox" name="daycare_yn_rule_check" id="daycare_yn_rule_check" value="Y" <%=daycare_yn_rule_check%> <%=daycare_yn_rule_disab%>> 
						</td>
						<td class="label">
							<fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
						</td>
						<td class="field">
							<input type="checkbox" name="emergency_yn" id="emergency_yn" onclick="validateEmer(this)"  value="Y" <%=emergency_yn%>>
						</td>
						<td class="label"  colspan='2'><fmt:message key="ePH.RuleBased.label" bundle="${ph_labels}"/>
							<input type="checkbox" name="emergency_yn_rule_check" id="emergency_yn_rule_check" value="Y" <%=emergency_yn_rule_check%> <%=emergency_yn_rule_disab%>> 
						</td>
					</tr>			
								
					<tr>
						<td width="15%" class="label" colspan=1>
							<fmt:message key="Common.DischargeMedication.label" bundle="${common_labels}"/>
						</td>
						<td>
							<input type="checkbox" name="Disch_Med_Mar_Appl_yn" id="Disch_Med_Mar_Appl_yn" onclick="validateDischMed(this)"  onclick="validateDischMed(this)" value="Y" <%=Disch_Med_Mar_Appl_yn%>>&nbsp;
						</td>
						<td class="label">
							<fmt:message key="ePH.RuleBased.label" bundle="${ph_labels}"/>
							<input type="checkbox" name="dischmedic_yn_rule_check" id="dischmedic_yn_rule_check" value="Y" <%=dischmedic_yn_rule_check%> <%=dischmedic_yn_rule_disab%>> 
						</td>
						<td colspan='4'>&nbsp;</td>
					</tr>			
				</table><!--  RUT-CRF-0062 [IN029600] Rule Based check box added  Included a <table> in <tr> for alignment  end-->
				<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="DirectDispensingRules_table" style="visibility:hidden">
					<th colspan="10" width="100%"><fmt:message key="ePH.DirectDispensingRules.label" bundle="${ph_labels}"/></th>
					<tr>
					  <td class="label"  width ="50%"><fmt:message key="ePH.DirectDispensingAllowed.label" bundle="${ph_labels}"/> :</td>
						<td>&nbsp;&nbsp;<input type="checkbox" name="direct_dispensing_allowed" id="direct_dispensing_allowed"
						 onclick = "EnableDispening(this)"  value="<%=direct_disp%>" <%=direct_disp_chk%>>
						</td>
						<td colspan="10"></td>
					</tr>
					<tr>
						<td class="label" id="app_patient_class" width ="50%" ><fmt:message key="Common.ApplicablePatientClass.label" bundle="${common_labels}"/> : </td>
						<td class ="label" id ="class_patient" style="<%=disp%>">
						<input type="radio" name="PatientClass" id="PatientClass"  onClick="applicablePatient(this)" value="O" <%=pat_clas_chk1%>  ><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
						<input type="radio" name="PatientClass" id="PatientClass"  onClick="applicablePatient(this)" value="E" <%=pat_clas_chk2%>  > <fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
						<input type="radio" name="PatientClass" id="PatientClass"  onClick="applicablePatient(this)" value="X" <%=pat_clas_chk3%>  ><fmt:message key="Common.external.label" bundle="${common_labels}"/>
						<input type="radio" name="PatientClass" id="PatientClass"   onClick="applicablePatient(this)" value="B" <%=pat_clas_chk4%> ><fmt:message key="Common.all.label" bundle="${common_labels}"/>
						</td>
						<td colspan="6"></td>
					</tr>

					<tr>
						<td class="label" id ="App_Encounter" width ="50%" ><fmt:message key="ePH.ApplicableEncounters.label" bundle="${ph_labels}"/> :</td>
						<td class="label" id="radio_encounter" style="<%=disp%>">
						<input type="radio" name="Applicable_Encounter" id="Applicable_Encounter" onclick="applicabeEncounter(this)"  value="O" <%=app_enc_chk1%>><fmt:message key="Common.open.label" bundle="${common_labels}"/> 
						<input type="radio" name="Applicable_Encounter" id="Applicable_Encounter" onclick="applicabeEncounter(this)"  value="C" <%=app_enc_chk2%>><fmt:message key="Common.closed.label" bundle="${common_labels}"/>
						<input type="radio" name="Applicable_Encounter" id="Applicable_Encounter" onclick="applicabeEncounter(this)" value="B" <%=app_enc_chk3%> ><fmt:message key="Common.Both.label" bundle="${common_labels}"/>
						</td>
						<td colspan="6"></td>
					</tr>
					<tr>
						<td class="label" id ="text_last" width ="50%" ><fmt:message key="ePH.ConsiderLast.label" bundle="${ph_labels}"/></td>
						<td class="label" id ="text_encounter" style="<%=disp%>">&nbsp;&nbsp;<input type="text" name="Consider_last" id="Consider_last" onBlur="CheckNum(this);chkzero(this)" onKeyPress="return allowValidNumber(this,event,2,0);" size="5" maxlength="2" value="<%=last_enc%>"  >
						<fmt:message key="Common.encounter.label" bundle="${common_labels}"/> <img src="../../eCommon/images/mandatory.gif" > </td>
						<td colspan="8"></td>
					</tr>
					<tr>
						<td class="label" id ="encounter_details" width ="50%" ><fmt:message key="ePH.EncounterDetailsRequiredDuringDirectDispensing.label" bundle="${ph_labels}"/> :</td>
						<td id="check_encounter" style="<%=disp%>">&nbsp;&nbsp;<input type="checkbox" name="Encounter_details_required" id="Encounter_details_required" onclick="setEncounter(this)"
						value = "<%=enc_during_disp%>" <%=enc_during_disp_chk%>></td>
						<td colspan="8"></td>
					</tr>
		
					<tr>
						<td class="label"> <fmt:message key="ePH.DefaultDispensingLocation.label" bundle="${ph_labels}"/></td>
						<td class="label">&nbsp;
							<select name="DFLT_DIR_DISP_LOCN" id="DFLT_DIR_DISP_LOCN">
<%
								String selectloc="";
								ArrayList al=(ArrayList)bean.loadDefaultDispensingLocation(locale,"Direct");
								for (int i=0;i<al.size();i+=2){
									selectloc="";
									if (dflt_dir_disp_locn1.equals((String)al.get(i))) selectloc="selected";
%>
										<option value="<%=(String)al.get(i)%>" <%=selectloc%> > <%=(String)al.get(i+1)%> </option>
<%
									}
%>
							</select>
						</td>
					</tr>
					<tr>	<!--added below data for CRF MMS-QH-CRF-0068 [IN:037980]-start -->
					<td class="label"  width ="50%" ><fmt:message key="ePH.AllowMedicationOrderWithoutDiagnosis.label" bundle="${ph_labels}"/>
					    </td>
					    <td>&nbsp;
						<input type="checkbox" id="Allow Medication Order Without Diagnosis for DD" name="allow_medn_ord_without_diag_dd" id="allow_medn_ord_without_diag_dd" value="Y"  <%=allow_medn_ord_without_diag_for_dd%> >
					</td>
					</tr>	<!--added below data for CRF MMS-QH-CRF-0068 [IN:037980]-End-->
					<th colspan=6><fmt:message key="ePH.ExternalPrescriptionDispensingRules.label" bundle="${ph_labels}"/><th>
					<tr>&nbsp;</tr>
					<tr>
						<td class=label><fmt:message key="ePH.DefaultDispensingLocation.label" bundle="${ph_labels}"/></td>
						<td class="label">&nbsp;
							<select name="DFLT_EXT_RX_DISP_LOCN" id="DFLT_EXT_RX_DISP_LOCN">
<%
								String selectloc1="";
								ArrayList al2=(ArrayList)bean.loadDefaultDispensingLocation(locale,"External");
								for (int i=0;i<al2.size();i+=2)	{			
									selectloc1="";												
									if (dflt_dir_disp_locn2.equals((String)al2.get(i))) selectloc1="selected";												
%>
										<option value="<%=(String)al2.get(i)%>" <%=selectloc1%> > <%=(String)al2.get(i+1)%> </option>
<%
									}
%>
							</select>
						</td>
					</tr>
				</table>

				<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="drug_database_interface_table" style="visibility:hidden" >
					<tr><td colspan="5" class="label">&nbsp;</td></tr>
					<tr>
						<td class="label" ><fmt:message key="ePH.DrugDatabaseInterfaceRequired.label" bundle="${ph_labels}"/></td>
						   <td colspan="4">&nbsp;<input type="checkbox" name="drug_db_interface_yn" id="drug_db_interface_yn" value="Y" <%=cdrug_db_interface_yn%> onclick ="disableextdatabasevalues(this)"></td> 
					</tr>
					<tr>
						<td class="label" ><fmt:message key="ePH.DrugDatabase.label" bundle="${ph_labels}"/></td>
						<td colspan="4">&nbsp;
							<select name="drug_db_interface_name" id="drug_db_interface_name" onchange="disableContraCheck();">
								<option value="">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
<%
								String strChecked="";
								for (int i=0;i<db_interface_names.size();i=i+2){
									if(drug_db_product_id.equals((String)db_interface_names.get(i))){
										strChecked ="selected";
									}
									else{
										strChecked ="";
									}
%>
									<option value="<%=db_interface_names.get(i)%>" <%=strChecked%>><%=db_interface_names.get(i+1)%></option>
<%
								}
%>
							</select>
							<img src="../../eCommon/images/mandatory.gif" align="center"  id="drug_db_name_img"></img>
						</td>
					</tr>
				
					<tr>
						<td class="label" ><fmt:message key="ePH.DosageCheckRequired.label" bundle="${ph_labels}"/></td>
						<td colspan="4">&nbsp;<input type="checkbox" name="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn" value="Y" <%=drug_db_dosecheck_yn%>></td>
					</tr>
					 <tr>
						<td class="label" ><fmt:message key="ePH.DuplicateTherapyCheckRequired.label" bundle="${ph_labels}"/></td>
						<td colspan="4">&nbsp;<input type="checkbox" name="drug_db_duptherapy_yn" id="drug_db_duptherapy_yn" value="Y" <%=drug_db_duptherapy_yn%>></td>
					</tr>
					<tr>
						<td class="label" ><fmt:message key="ePH.InteractionCheckRequired.label" bundle="${ph_labels}"/></td>
						<td colspan="4">&nbsp;<input type="checkbox" name="drug_db_interaction_yn" id="drug_db_interaction_yn" value="Y" <%=drug_db_interact_check_yn%>></td>
					</tr>
					<tr>
						<td class="label" ><fmt:message key="ePH.ContraindicationCheckRequired.label" bundle="${ph_labels}"/></td>
						<td colspan="4">&nbsp;<input type="checkbox" name="drug_db_contracheck_yn" id="drug_db_contracheck_yn" value="Y" <%=drug_db_contraind_check_yn%>></td>
					</tr>
					<tr>
						<td class="label" ><fmt:message key="ePH.AllergyCheckRequired.label" bundle="${ph_labels}"/></td>
						<td colspan="4">&nbsp;<input type="checkbox" name="drug_db_alergycheck_yn" id="drug_db_alergycheck_yn" value="Y" <%=drug_db_allergy_check_yn%>></td>
					</tr>	   
					<tr><td colspan="5" class="white">&nbsp;</td></tr>
					<tr><td colspan="5" class="white">&nbsp;</td></tr>
					<tr><td colspan="5" class="white"></td></tr><tr><td colspan="5" class="white"></td></tr><tr><td colspan="5" class="white"></td></tr>
				</table>
<%
				if(mode.equals("2")){
%>
					<input type="hidden" name="last_adr_no" id="last_adr_no" value="<%=last_adr_no%>"> 
<%
				}
%>
				<input type="hidden" name="interface_to_bl_yn" id="interface_to_bl_yn" value="<%=BLExists%>">
				<input type="hidden" name="mode" id="mode" value="<%=mode%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
				<input type="hidden" name="direct_disp" id="direct_disp" value="<%=direct_disp%>"> 
				<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
				<input type="hidden" name="licenceRights" id="licenceRights" value="<%=licenceRights%>">
				<input type="hidden" name="PhVersionNo" id="PhVersionNo" value="<%=PhVersionNo.ALSDKFHADFKADFHG%>">
				<input type="hidden" name="applicable_patient" id="applicable_patient" value="<%=applicable_patient%>">
				<input type="hidden" name="flag" id="flag" value="<%=app_enc%>">
				<input type="hidden" name="flag1" id="flag1" value="<%=pat_class%>">
				<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
				<input type="hidden" name="near_expiry_appl_yn" id="near_expiry_appl_yn" value="<%=near_expiry_appl_yn%>"> <!-- Added for MMS-DM-CRF-0177 --> 
				<input type="hidden" name="pre_alloc_check" id="pre_alloc_check" value="<%=pre_alloc_check%>"><!--  Added for MMS-DM-CRF-0177 --> 
				<input type="hidden" name="durn_value_in_days" id="durn_value_in_days" value=""><!--  Added for MMS-DM-CRF-0177 --> 
			
 				<!--<script>outpatient_tab.click();
					Display("outpatient_tab")
				</script> -->
					<script>general_tab.click();
					Display("general_tab");
				</script>
<%
			if (arrList.size()<=0){
%>
				<script>validateFilling(document.getElementById("disp_flng_reqd_yn"))</script>
<%
			}
%>
		</form>
		
<% 
		putObjectInBean(bean_id,bean,request ); 
	}
	catch(Exception e){
		e.printStackTrace();
	}
	/*finally{ //added for ML-BRU-CRF-0473 START
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	}*/
%>
	</body>
	<script>
		document.forms[0].unalloc_order_del_st.focus();
		checkAllowStock(document.getElementById("ip_consider_stock"));
		disableextdatabasevalues(document.getElementById("drug_db_interface_yn"));
		document.forms[0].diag_for_medn_order_by.value='<%=diag_for_medn_order_by%>';

	</script>
</html>

