<!DOCTYPE html>
<!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%
/*

--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
07/08/2019      IN:071108		    B Haribabu                                          ML-MMOH-CRF-1408
09/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
10/06/2020              IN:072715              Haribabu                                   MMS-DM-CRF-0165 
13/10/2020              IN:073110              Manickavasagam J             ML-MMOH-CRF-1531
06/11/2020      IN:069887          Haribabu                 Manickavasagam J            MO-CRF-20152
06/11/2020      IN7506             Prabha	   06/11/2020   Manickavasagam J           PH-Application accepts number of days which is not related to frequency
25/08/2023	IN49131				Sushant Tambe										ML-MMOH-SCF-2514
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
 		<!--<script language="JavaScript" src="../js/PhMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script> 
		 <!--<script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>-->
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
  		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
		<script language="JavaScript" src="../../ePH/js/Prescription_2.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
Connection con				= null;//added for ml-bru-crf-0469
try{
	String uom_disp = "";
	String facility_id		= (String) session.getValue("facility_id");
	String patient_id		= request.getParameter("patient_id"); 
	String encounter_id		= request.getParameter("encounter_id");
	String in_mode			= request.getParameter("mode");
	String srl_no			= request.getParameter("srl_no")==null?"1":request.getParameter("srl_no");
	String priorityCode		= request.getParameter("priority");
	String drug_cd			= request.getParameter("drug_code");//Added for RUT-CRF-0088 [IN036978]  
	String priority			= "";

	String drug_db_interface_yn      =  request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	//String drug_db_dosage_check_yn      =  request.getParameter("drug_db_dosage_check_yn")==null?"":request.getParameter("drug_db_dosage_check_yn");
	//String drug_db_duptherapy_check_yn	= request.getParameter("drug_db_duptherapy_check_yn")==null?"":request.getParameter("drug_db_duptherapy_check_yn");
	//String drug_db_contraind_check_yn	= request.getParameter("drug_db_contraind_check_yn")==null?"":request.getParameter("drug_db_contraind_check_yn");
	//String drug_db_interact_check_yn	= request.getParameter("drug_db_interact_check_yn")==null?"":request.getParameter("drug_db_interact_check_yn");
	//String drug_db_allergy_check_yn= request.getParameter("drug_db_allergy_check_yn")==null?"":request.getParameter("drug_db_allergy_check_yn");

	String drug_db_allergy_flag		=  "";	
	String drug_db_duptherapy_flag		= "";	
	String drug_db_dosage_check_flag		= "";	
	String drug_db_interact_check_flag		= "";	

	if(priorityCode!=null && priorityCode.equals("R"))
		priority	=	"Routine";
	else
		priority	=	"urgent";
     
	 if(priority.equalsIgnoreCase("Routine"))
		priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	else if(priority.equalsIgnoreCase("urgent"))
		priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");

	String mode						= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
	String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name				= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request) ;
	orbean.setLanguageId(locale);
	
	String auth_amend_pres_yn="";//added for ml-mmoh-crf-0863
	presBean.setDisp_locn_code("");//added for ml-mmoh-crf-0863
//	presBean.setOrder_ststus("");//added for ml-mmoh-crf-0863
	String called_amend_from=bean.getCalledFromAmend();
	/* DispBean.setDispLocnCode("RPAEPH");
	DispBean.setLoginFacilityId("RP");
	DispBean.setLoginById("ALPHA");
	System.out.println("locnDetailsForMod"+locnDetailsForMod); */
	//DispBean
//corrected for PE By Naveen
	//int take_home					=	bean.getHomeMecdicationYn(encounter_id,facility_id);
	int take_home					=	(int)bean.getTakeHomeCount();
	String order_id			= (String) orbean.getOrderId();
	System.out.println(order_id+"order_id");
	String pract_type						= (String) orbean.getPractitionerType(); //added for ML-BRU-SCF-0958 [IN:042045]
	//String order_line_num   =   bean.getOrderLineNumber();//Added for ICN:34834
	String order_line_num   =   "";//Added for ICN:34834
	String called_from		=	orbean.getCalledFromFunction();
	String prn_yn					= "N";
	String man_rem_on_prn_freq_yn	="";

	ArrayList drugData		= (ArrayList) bean.getpresDetails();

//	prn_yn						= bean.getchkforPRN();
//commented during PE By Naveen
	//man_rem_on_prn_freq_yn		= bean.getchkforPRN();
	String consider_stock_for_pres_yn	=	"";
	String allow_pres_without_stock_yn	=	"";
	String trade_display_yn	=	request.getParameter("trade_display_yn")==null?"":request.getParameter("trade_display_yn");
	String display			= "display:none";
	String drug_code		= "";
	String drug_desc		= "";
	String route_code		= "";
	String route_color = ""; //Added for	RUT-CRF-0034 ICN  29927
	String backgrndColor="";//Added for	RUT-CRF-0034 ICN  29927
	String fntColor="";//Added for	RUT-CRF-0034 ICN  29927
	String freq_code		= "";
	String freq_durn_type	= "D";
	String freq_durn_value	= "";
	String tap_lvl_qty	= "";//Added for RUT-CRF-0088 [IN036978]
	String extsrlno	= "";//Added for RUT-CRF-0088 [IN036978]
	float totTapperQty	= 0.0f;//Added for RUT-CRF-0088 [IN036978]  -->

	String qty_value		= "";
	String dosage_type		= "";
	String durn_value		= "";
	String split_dose		= "";
	String drug_start_date	= "";
	String drug_end_date	= "";
	String display_auth_rule	="visibility:hidden";
	String color_auth_rule	= "RED";
	String no_refill		= "";
	String form_desc		= "";
	String strength_value	= "";
	String strength_uom		= "";
	String prescribed_mode	= "";
	String qty_legend		= "";
	
	String scheduled_yn		= "";
	String durn_val_dis		= "";
	String qty_val_dis		= "";
	String durn_type		= "";
	String repeat_value		= "";
	String patient_class	= "";
	String order_type_code	= "";
	String form_code		= "";
	String repeat_durn_type	= "";
	String qty_desc_dis		= "";

	String min_daily_dose	= "";
	String min_unit_dose	= "";
    String unit_dose        = ""; 
	String daily_dose		= "";
	String mono_graph		= "";

	String dup_start_date	= "";
	String dup_end_date		= "";
	String strength_field	= "";
	String pres_remarks		= "";
	String srlNo			= "";
	String  override_yn		= "N";
	String  generic_id		= "";
	String freq_option		= "";	
	String strength_uom_desc = "";
	String duration_option	= "";
	String	ori_dosage_type	= "";
	String	in_formulary_yn	= "";
	String	item_code	= "";
	//added for SRR20056-SCF-7882 -29157 - Start
	String	buildMAR_yn	= ""; 
	String	buildMAR_checked	= ""; 
	String	buildMAR_enable	= "";
	String MAR_app_yn    = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	String	buildMAR_rule	= "";  // RUT-CRF-0062 [IN029600]
	//added for SRR20056-SCF-7882 -29157 - End
	String 	DrugIndicationRemarks				=   "";//Added for  ML-BRU-CRF-072[Inc:29938]
	ArrayList admin_time	=	new ArrayList();
	ArrayList admin_qty		=	new ArrayList();
	//ArrayList stock_params	=	new ArrayList(2);
	Hashtable DurnDescDetails	=   new Hashtable();
	HashMap taperDetails					=	null;//Added for RUT-CRF-0088 [IN036978]
	HashMap taperdrugDetails				=	new HashMap();//Added for RUT-CRF-0088 [IN036978]

	String adtime			=	"";
	String disp_locn_code	=	"";
	String disp_locn_desc	=	"";
	String current_rx		=	"N";
	String allergy_yn		=	"N";
	String limit_ind		=	"Y";
	String stock_uom		=	"";
	String absol_qty		=	"";
	boolean split_chk		=	false;
	String freq_nature		=	"";
	String dosage_option	=	"";
	
	String qty_option		=	"";
	String strength_desc	=	"";
	String schedule_status	=	"";
	String	tab_qty_value	= 	"";
	String split_dose_yn	=	"N";
	String	prn_dose		= 	"";
	String absol_qty_status	=	"";
	String qty_legend_style	=	"visibility:hidden";
	String interval_value	=	"";
	String pres_base_uom	=	"";
	boolean administered	=	false;
	ArrayList refill_orders	=	new ArrayList();
	String freq_status		=	"";
	String flag				=	"";
	String taper_yn			=	"";
	String amended_yn		=	"";
	String calc_by_ind		=	"";
	String dosage_std		=	"";
	String dosage_unit		=	"";
	String recomm_yn		=	"";
	String child_order		=	"";
	String no_of_refills	=	"";
	String tdm_order_id		=	"";
	String display_tdm		=	"display:none";
	HashMap	 prn_remarks			= new HashMap();
	String prn_remarks_code			= "";
	String prn_remarks_dtl			= "";
	String color					= "";
	String qty_desc_code			= "";
	String ext_prod_id				= "";
	String fract_dose_round_up_yn	= "";
	String strength_per_pres_uom	= "";
	String strength_per_value_pres_uom = "";
	String ord_auth_reqd_yn			= "";
	String force_auth_yn			="";//added for ML-MMOH-SCF-0498 chithra
	String ord_authorized_yn		= "";
	String ord_authorized_prev_yn	= "";
	String	ord_spl_appr_reqd_yn		= 	"";
	String	ord_cosign_reqd_yn			= 	"";
	String	ord_approved_yn				= 	"";
	String	ord_cosigned_yn				= 	"";
	String ord_authorized_yn_durn			= "";//added for mo-scf-5533
	String	dsg_reason			= "";
	String	dup_reason			= "";
	String con_reason			= "";
	String int_reason			= "";
	String	alg_reason			= "";
	String trade_code			= "";
	String trade_name			="";
	String fract_dose_appl_yn	= "";
	int dose_decimal			= 6;
	String allow_duplicate		="";
	String DrugRemarksEntered			=	""; //Added for Antibiotic Screen using Order Entry Format ICN 29904
	String abuse_override ="" ;//added for AAKH-CRF-140
	String abuse_drug_override_reason="";//added for AAKH-CRF-140
	String abuse_action="U",abuse_exists="";//added for AAKH-CRF-140
			String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
		
	String bl_incl_excl_override_reason_code	="";
	String bl_incl_excl_override_reason_desc	= "";
	String bl_def_override_excl_incl_ind		= "";
	String bl_override_excl_incl_ind			= "";
	String bl_override_allowed_yn				= "";
	String bl_diagnosis						="";
	String bl_diagnosis_1						="";
	ArrayList routesforform						= null;
	ArrayList tmp_freq_values					= new ArrayList();

	float total_qty		= 0.0f;
	String final_qty	= "";
	String adm_time		= "";
	String adm_qty		= "";
	String tooltiptable = "";
	ArrayList dose_list = new ArrayList();
	String include_selected ="";
	String exclude_selected ="";
	String Select_selected ="";
	String billable_item_yn = "";
	String actionText						=	""; // add for SKR-CRF-0006[IN029561]
	String taper_disabled	="";
	String taperQty_display	="";
	String totalTaperQtyDisplay = bean.getTotalTaperQtyDisplay();
	String calc_dosg_by_freq_durn_yn = ""; //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]
	String interaction_exists=	"", intr_restric_trn="N", intr_msg_content="", interaction_override ="", interaction_remarks="";
		
	String pregnency_yn				=	"";//  added for CRF RUT-CRF-0063[29601]--start 
	String pregnency_cat ="";
	String preg_effect   ="";
	String preg_category_code="";
	String preg_warn_req_yn="";
	String pregnency_cat_desc ="";
	String 		preg_remarks				=   "";// added for CRF RUT-CRF-0063[29601]--end
	String start_date1 = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
	String end_date1 = null;
	String sys_date = null;
	String tempstartString = null;
	String tempendString  = null;
	String systempString =null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end
	String home_leave_med="";//Added for ML-BRU-SCF-1407 [IN 050482]
	String disp_by_alt_form_param = "";
	//Added for IN:071108 start
	String		max_daily_ceeling_dose	    =   "";
	String		min_daily_ceeling_dose	    =   "";
	String		max_unit_ceeling_dose	    =   "";
	String		min_unit_ceeling_dose	    =   "";
	String ext_disp_appl_yn = ""; //Added For NMC-JD-CRF-0046
     //Added for IN:071108 end
     
     //Added for IN:072715 start
	String		allergy_remarks_code	    =   "";
	String		dose_remarks_code	    =   "";
	String		currentrx_remarks_code	    =   "";
	String		interaction_remarks_code	    =   "";
	String		food_interaction_remarks_code	    =   "";
	String		lab_interaction_remarks_code	    =   "";
	String drug_indication_mdry="";//added for jd-crf-0220
	drug_indication_mdry=bean.getDrugIndicationMdry();//added for jd-crf-0220
	System.out.println("prescriptionamenddetailsdrug_indication_mdry"+drug_indication_mdry);
	//Added for IN:072715 end
     
	//		String order_ststus="";//added for ml-mmoh-crf-0863
			String temp_mono_graph="";
			 con						= ConnectionManager.getConnection(request);//added for ml-bru-crf-0469
			boolean displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
			boolean item_type_site_app = CommonBean.isSiteSpecific(con, "PH", "ITEM_TYPE_APP"); //added for GHL-CRF-0549
			 boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
			 boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
				
			 String validate_overide_on_confirm_yn="N";//Added for IN:069887
			 boolean validate_overide_on_confirm =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","VALIDATE_OVERIDE_ON_CONFIRM");//Added for IN:069887 
			 
			// added for ML-MMOH-CRF-1914 start
				boolean drugDosageLimitAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "PH_BEY_DOSE_PENCIL_ICON_PRN"); 
			boolean amend_order_site = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "JOB_QUEUE_REPORT"); //Added for ML-MMOH-CRF-2115 - start
		System.out.println("drugDosageLimitAppl::"+drugDosageLimitAppl);
		String 		visable_dose_for_prn="";
				if(drugDosageLimitAppl){
					visable_dose_for_prn="validateDosageLimit('hideSchedLink');";
				}
				else
				{
					visable_dose_for_prn="";
				}
				// added for ML-MMOH-CRF-1914 end
			 
			//Added for IN:069887 start
				if(validate_overide_on_confirm){
					validate_overide_on_confirm_yn="Y";
				}
				//Added for IN:069887  end
				
			//item_type_site_app = true;
			boolean all_durn_type_app = CommonBean.isSiteSpecific(con, "PH", "ALL_DURN_TYPE_APP"); //added for ML-MMOH-CRF-1531

		if(item_type_site_app){
		disp_by_alt_form_param     = bean.getParamDispByAltForm();
		System.err.println("disp_by_alt_form_param======>"+disp_by_alt_form_param);
		}
	if(called_from.equals("RENEW_ORDER")) {
		mode					= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
		strength_field			=	"disabled";	
	}
	else if(called_from.equals("AMEND_ORDER")) {
		mode					= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
	}
	HashMap drugDetails	=	null;
	HashMap nextDrugDetails	=	null;
	String nextDrugCode="";
	String	extdrugCode			=	null;//Added for RUT-CRF-0088 [IN036978]
	String drugs_code = null;//Added for RUT-CRF-0088 [IN036978]
	String allow_alternate_yn = ""; //added for GHL-CRF-0549
	String allow_alternate_checked = ""; //added for GHL-CRF-0549
	String diagnosis_found_yn="";//added for mms-dm-crf-0204
			if(drugData.size()>0){//Added for RUT-CRF-0088 [IN036978]-start  -->
		drugDetails =(HashMap)drugData.get(0);
		drugs_code = (String)drugDetails.get("DRUG_CODE");
	}
	if(drug_cd!=null)
		drugs_code = drug_cd; //Added for RUT-CRF-0088 [IN036978]-end 
			
	if(in_mode!=null && in_mode.equals("amend")){
		if(drugData.size()>0){
			for(int i=0;i<drugData.size();i++){
				drugDetails =(HashMap)drugData.get(i);
				System.out.println("---------------->drugDetails"+drugDetails);
				order_line_num     =(String) drugDetails.get("ORDER_LINE_NUM");
				srlNo				= (String) drugDetails.get("SRL_NO");
				extdrugCode		= (String)drugDetails.get("DRUG_CODE");//Added for RUT-CRF-0088 [IN036978]
				tdm_order_id		=  "";
				display_tdm			=  "display:none";
				if((i+1) <drugData.size()){
					nextDrugDetails = (HashMap)drugData.get(i);
					nextDrugCode = (String) drugDetails.get("DRUG_CODE");
				}
				if(extdrugCode.equals(drugs_code) && srlNo.equals(srl_no)){//Modified for RUT-CRF-0088 [IN036978]
					drug_code			= (String) drugDetails.get("DRUG_CODE");
					tdm_order_id		= bean.getOorderIdForTDMDtls(patient_id,drug_code);
					taperdrugDetails = drugDetails;//Added for RUT-CRF-0088 [IN036978]
					if(tdm_order_id==null||tdm_order_id.equals("")){
						display_tdm="display:none";
					}
					else{
						display_tdm="display";
					} 
                    man_rem_on_prn_freq_yn =(String) drugDetails.get("MANDATORY_REM_ON_PRN_FREQ_YN");
					
					drug_desc			= (String) drugDetails.get("CATALOG_DESC");	
					ext_prod_id		=	(String) drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails.get("EXTERNAL_PRODUCT_ID");
					form_desc			= (String) drugDetails.get("FORM_DESC");	
					generic_id			= (String) drugDetails.get("GENERIC_ID");	
					route_code			= (String) drugDetails.get("ROUTE_CODE");
					form_code			= (String) drugDetails.get("FORM_CODE");
					freq_code			= (String) drugDetails.get("FREQ_CODE");	
					//added for SRR20056-SCF-7882 -29157 -start
					
					ext_disp_appl_yn=(String) drugDetails.get("EXT_DISP_APPL_YN")==null?"":(String) drugDetails.get("EXT_DISP_APPL_YN");//Added for NMC-JD-CRF-0046
					
					buildMAR_yn	= (String) (drugDetails.get("BUILDMAR_YN") == null?"N":drugDetails.get("BUILDMAR_YN"));
			//GHL-CRF-0549  Start.
					allow_alternate_yn = (String) (drugDetails.get("ALLOW_ALTERNATE_YN") == null?"N":drugDetails.get("ALLOW_ALTERNATE_YN"));
					if(allow_alternate_yn.equals("Y"))
						allow_alternate_checked="checked";
			//GHL-CRF-0549 End.
					if(buildMAR_yn.equals("Y"))
						buildMAR_checked ="Checked";
					buildMAR_rule=drugDetails.get("BUILD_MAR_RULE")==null?"":drugDetails.get("BUILD_MAR_RULE").toString();// RUT-CRF-0062 [IN029600]  -- begin
					// Build MAR Rule will be applied only to set the Enable / Disable Property 
					buildMAR_rule=(buildMAR_rule==null)?"":buildMAR_rule;	
					if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("UE")){
						buildMAR_enable="";
					}
					else if(buildMAR_rule.equals("CD") || buildMAR_rule.equals("UD")){
						buildMAR_enable="disabled";
					}// RUT-CRF-0062 [IN029600]   -- end
					//if( calling_mode.equals("taper")|| calling_mode.equals("tapered"))
					//	buildMAR_enable ="disabled";
					//added for SRR20056-SCF-7882 -29157 -end

					routesforform		= presBean.getRoutes(form_code); 
					prn_remarks			=	bean.getPRNRemarks(drug_code);

					if(prn_remarks != null){
					prn_remarks_code		=prn_remarks.get("prn_remarks_code")==null?"":(String)prn_remarks.get("prn_remarks_code");
					prn_remarks_dtl			=prn_remarks.get("prn_remarks_dtl")==null?"":(String)prn_remarks.get("prn_remarks_dtl");
					}
					/*if(!prn_remarks_dtl.equals("")) {
						prn_remarks_dtl	=	"true";
					}
					else {
						prn_remarks_dtl	=	"false";
					}*/
					//order_ststus       =(String)drugDetails.get("ORDER_STATUS")==null?"N":(String)drugDetails.get("ORDER_STATUS");//added for ml-mmoh-crf-0863
				//	presBean.setOrder_ststus(order_ststus);//added for ml-mmoh-crf-0863
					qty_value			= (String) drugDetails.get("QTY_VALUE");		
					qty_desc_dis		= (String) drugDetails.get("QTY_DESC");	
					qty_desc_code		= (String) drugDetails.get("QTY_DESC_CODE");	
					strength_uom_desc	= (String) drugDetails.get("STRENGTH_DESC");
					durn_value			= (String) drugDetails.get("DURN_VALUE");		
					
					drug_start_date		= (String) drugDetails.get("START_DATE_TIME");
					drug_end_date		= (String) drugDetails.get("END_DATE_TIME");
					no_refill			= (String) drugDetails.get("NUM_OF_REFILLS");
					if(no_refill ==null || no_refill.equals("0")){
						no_refill="";
					}
					strength_value		= (String) drugDetails.get("STRENGTH_VALUE");
					strength_uom		= (String) drugDetails.get("STRENGTHUOM");
					if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
						strength_value = Float.parseFloat(strength_value) +"" ;
					prescribed_mode		= (String) drugDetails.get("PRESCRIBED_MODE");
					split_dose			= (String) drugDetails.get("SPLIT_DOSE_PREVIEW");

					durn_type			= (String) drugDetails.get("DURN_TYPE");
					repeat_value		= (String) drugDetails.get("REPEAT_VALUE");
					patient_class       = (String) drugDetails.get("PATIENT_CLASS");
					order_type_code		= (String) drugDetails.get("ORDER_TYPE_CODE");
					repeat_durn_type	= (String) drugDetails.get("REPEAT_DURN_TYPE");
					//repeat_durn_type	= (String) drugDetails.get("FREQ_DURN_TYPE");
					scheduled_yn		= (String) drugDetails.get("SCHEDULED_YN");
					stock_uom			= (String)drugDetails.get("STOCK_UOM_DESC");
					absol_qty			= (String)drugDetails.get("ORDER_QTY");

					dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
					ori_dosage_type		= (String) drugDetails.get("ORI_DOSAGE_TYPE");
					freq_nature			= (String)drugDetails.get("FREQ_NATURE");
					fract_dose_appl_yn = (String) drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String) drugDetails.get("FRACT_DOSE_APPL_YN");
					if(fract_dose_appl_yn.equals("N"))
						dose_decimal = 0;

					fract_dose_round_up_yn =  (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
					tab_qty_value		= (String) drugDetails.get("TAB_QTY_VALUE");
					prn_dose			= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
					interval_value		= (String)drugDetails.get("INTERVAL_VALUE");
					pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
					flag				= (String)drugDetails.get("FLAG");
					taper_yn			= (String)drugDetails.get("TAPERED_YN")==null?"N":(String)drugDetails.get("TAPERED_YN");
					
					System.err.println("flag     "+flag);
					System.err.println("taper_yn     "+taper_yn);
					if(amend_order_site ){ //Added for ML-MMOH-CRF-2115 - start	
					String taperSeqNo = presBean.getTaperSeqNo(order_id,1);
					String taperCount = presBean.getTaperSeqNo(order_id,2);				
						if(!taperSeqNo.equals("0")){
						
							if (patient_class.equals("IP")) {
								System.err.println("Inside IP");
								System.err.println("taperSeqNo "+taperSeqNo);
								System.err.println("taperCount "+taperCount);
							    if (taperCount.equals(taperSeqNo)) {
							        taper_yn = "N";
							    } else {
							        flag = "N";
							    }
							} else if (patient_class.equals("OP")) {
							    if (taperCount.equals(order_line_num)) {
							        taper_yn = "N";
							    } else {
							        flag = "N";
							    }
							}
						}
					} //Added for ML-MMOH-CRF-2115 - end
					
					tap_lvl_qty			=  drugDetails.get("TAP_LVL_QTY")==null?"":drugDetails.get("TAP_LVL_QTY").toString(); //Added for RUT-CRF-0088 [IN036978] 
					totTapperQty		=  Float.parseFloat(drugDetails.get("TOTTAPPERQTY")==null?"0":(String) drugDetails.get("TOTTAPPERQTY"));//Added for RUT-CRF-0088 [IN036978]  
					//if(totalTaperQtyDisplay.equals("Y")){ //Commented for 43600 - RUT-CRF-0088 - to restrict Tapered drug values change
					if(taper_yn.equals("Y")){//&& nextDrugCode.equals(drug_code)) //Commented for 43600 - RUT-CRF-0088 - to restrict Tapered drug values change load from DispMedication
						taper_disabled="disabled";
						schedule_status ="disabled";
						freq_status ="disabled";
					}
					else
						taper_disabled="";
					//}
					calc_dosg_by_freq_durn_yn  = (String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN")==null?"":(String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN"); //added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595]

					amended_yn			= (String)drugDetails.get("AMENDED_YN");
					calc_by_ind			= (String)drugDetails.get("CALC_BY_IND");
					dosage_std			= (String)drugDetails.get("DOSAGE_STD");
					dosage_unit			= (String)drugDetails.get("DOSAGE_UNIT");
					recomm_yn			= ((String)drugDetails.get("RECOMM_YN"));
					ord_auth_reqd_yn			= (String) drugDetails.get("ORD_AUTH_REQD_YN");
					force_auth_yn	=	(String) drugDetails.get("FORCE_AUTH_YN");//added for ML-MMOH-SCF-0498
					ord_authorized_yn					= (String) drugDetails.get("ORD_AUTHORIZED_YN");
					ord_authorized_prev_yn					= (String) drugDetails.get("ORD_AUTHORIZED_PREV_YN");
					ord_spl_appr_reqd_yn		= (String) drugDetails.get("ORD_SPL_APPR_REQD_YN");
					ord_cosign_reqd_yn			= (String) drugDetails.get("ORD_COSIGN_REQD_YN");
					ord_approved_yn				= (String) drugDetails.get("ORD_APPROVED_YN");
					ord_cosigned_yn				= (String) drugDetails.get("ORD_COSIGNED_YN");
					ord_authorized_yn_durn=(String)drugDetails.get("ORD_AUTHORIZED_YN_DURN")==null?"N":(String) drugDetails.get("ORD_AUTHORIZED_YN_DURN");//added for mo-scf-5533//null handled ML-MMOH-SCF-1312
					min_daily_dose	= (String)drugDetails.get("MIN_DAILY_DOSE");
					min_unit_dose	= (String)drugDetails.get("MIN_UNIT_DOSE");
					unit_dose        = (String)drugDetails.get("UNIT_DOSE"); 
					daily_dose		= (String)drugDetails.get("DAILY_DOSE");
					//Added for IN:071108 start
					max_daily_ceeling_dose				= (String) drugDetails.get("MAX_DAILY_CEELING_DOSE");
					min_daily_ceeling_dose				= (String) drugDetails.get("MIN_DAILY_CEELING_DOSE");
					max_unit_ceeling_dose				= (String) drugDetails.get("MAX_UNIT_CEELING_DOSE");
					min_unit_ceeling_dose				= (String) drugDetails.get("MIN_UNIT_CEELING_DOSE");
					//Added for IN:071108 end
					
					//Added for IN:072715 start
					allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
					dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
					currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
					interaction_remarks_code				= (String) drugDetails.get("INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("INTERACTION_REMARKS_CODE");
					food_interaction_remarks_code				= (String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE");
					lab_interaction_remarks_code				= (String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE");
					 String bl_diagnosis2				= (String) drugDetails.get("BL_DIAGNOSIS")==null?"":(String) drugDetails.get("BL_DIAGNOSIS");
					 System.out.println("bl_diagnosis2----------------558---------------------->"+bl_diagnosis2);
					//Added for IN:072715 end
					//added for aakh-crf-0140 start
					if(drug_abuse_appl){
					abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"":(String)drugDetails.get("ABUSE_OVERRIDE");
					System.out.println("abuse_override"+abuse_override);
					abuse_drug_override_reason=(String)drugDetails.get("abuse_drug_override_reason")==null?"":(String)drugDetails.get("abuse_drug_override_reason");
					abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");
					abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");
					
				}
				else{
					abuse_override="";
					abuse_drug_override_reason="";
					abuse_action="";
					abuse_exists="";
					
				}
				System.out.print("abuse_override  prescription amenddetails"+abuse_override);
					System.out.print("abuse_drug_override_reason  prescription amenddetails"+abuse_drug_override_reason);
					System.out.print("abuse_action  prescription amenddetails"+abuse_action);
					System.out.print("abuse_exists  prescription amenddetails"+abuse_exists);
					//added for aakh-crf-0140 end
					mono_graph		= (String)drugDetails.get("MONO_GRAPH");
					temp_mono_graph=mono_graph.replaceAll(" ","%20");
					temp_mono_graph = java.net.URLEncoder.encode(temp_mono_graph,"UTF-8");
					temp_mono_graph=temp_mono_graph.replaceAll("%2520","%20");
					
					trade_code		= (String)drugDetails.get("TRADE_CODE")==null?"":(String)drugDetails.get("TRADE_CODE");
					trade_name		= (String)drugDetails.get("TRADE_NAME")==null?"":(String)drugDetails.get("TRADE_NAME");
					in_formulary_yn		= (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
					item_code		= (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");

					strength_per_pres_uom			=  (String)drugDetails.get("STRENGTH_PER_PRES_UOM");            
					strength_per_value_pres_uom =  (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
					con_reason					 =   (String)drugDetails.get("CONTRAIND_OVERRIDE_REASON")==null?"": (String)drugDetails.get("CONTRAIND_OVERRIDE_REASON");                  
					int_reason					 =   (String)drugDetails.get("INTERACTION_OVERRIDE_REASON")==null?"": (String)drugDetails.get("INTERACTION_OVERRIDE_REASON");                       
					DrugRemarksEntered = (String)drugDetails.get("DrugRemarksEntered")==null?"": (String)drugDetails.get("DrugRemarksEntered");  //Added for Antibiotic Screen using Order Entry Format ICN 29904 
					DrugIndicationRemarks				= (String) drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//Added for  ML-BRU-CRF-072[Inc:29938]
					if(!DrugIndicationRemarks.equals(""))
						DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8");
					freq_durn_type	= (String)drugDetails.get("FREQ_DURN_TYPE");
					freq_durn_value	= (String)drugDetails.get("FREQ_DURN_VALUE");
					billable_item_yn  =  (String)drugDetails.get("BILLABLE_ITEM_YN")==null?"Y": (String)drugDetails.get("BILLABLE_ITEM_YN"); 
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						bl_override_allowed_yn =(String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"": (String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN"); 
						bl_incl_excl_override_reason_code =(String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"); 
						bl_incl_excl_override_reason_desc = (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
						  bl_override_excl_incl_ind= (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND");  //priya 10/03/2010
						bl_def_override_excl_incl_ind = (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");    //priya 10/03/2010

						if(bl_override_excl_incl_ind.equals(""))
							bl_override_excl_incl_ind = bl_def_override_excl_incl_ind;
					}
					drug_db_allergy_flag		=  (String)drugDetails.get("DRUG_DB_ALLERGY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_ALLERGY_FLAG");	
					drug_db_duptherapy_flag		=  (String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG");	
					
					drug_db_dosage_check_flag		=  (String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG");	
					drug_db_interact_check_flag		=  (String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG");	
                    
					consider_stock_for_pres_yn	=	(String)drugDetails.get("CONSIDER_STOCK_FOR_PRES_YN");
		            allow_pres_without_stock_yn	=	(String)drugDetails.get("ALLOW_PRES_WITHOUT_STOCK_YN");
					pregnency_yn				=presBean.getPregnencyYN(patient_id);//added for CRF RUT-CRF-0063[29601]-start
	                String lmp_date                 =presBean.getLMPDate(patient_id);
	                double preg_week                =presBean.getCalPregStage(drug_start_date,lmp_date);
		            preg_week=Math.ceil(preg_week);
	                String trimester                =presBean.getTrimster(preg_week);
	                bean.setPregnencyYN(pregnency_yn);
	                bean.setPregTrimester(trimester);//added for CRF RUT-CRF-0063[29601]-end 
					pregnency_cat  = (String)drugDetails.get("PREG_CATEGORY_GROUP_CODE")==null?"":(String)drugDetails.get("PREG_CATEGORY_GROUP_CODE");
					preg_effect  = (String)drugDetails.get("PREG_EFFECT")==null?"":(String)drugDetails.get("PREG_EFFECT");
					preg_effect=java.net.URLEncoder.encode(preg_effect,"UTF-8");//code added for IN040512
					preg_category_code  = (String)drugDetails.get("PREG_CATEGORY_CODE")==null?"":(String)drugDetails.get("PREG_CATEGORY_CODE");
                    preg_warn_req_yn  = (String)drugDetails.get("PREG_WARN_REQ_YN")==null?"":(String)drugDetails.get("PREG_WARN_REQ_YN");
					pregnency_cat_desc  = (String)drugDetails.get("CATEGORY_GROUP_DESC")==null?"":(String)drugDetails.get("CATEGORY_GROUP_DESC");
					preg_remarks = (String) drugDetails.get("PREG_DRUG_REMARKS")==null?"":(String)drugDetails.get("PREG_DRUG_REMARKS");
					if(called_from.equals("RENEW_ORDER")) //Added for Bru-HIMS-CRF-400 [IN:044502]
						order_id = (String) drugDetails.get("ORDER_ID")==null?"":(String)drugDetails.get("ORDER_ID");
					if(!preg_remarks.equals(""))
						preg_remarks = java.net.URLEncoder.encode(preg_remarks,"UTF-8"); ;
					//adding end for CRF RUT-CRF-0063[29601]
			
					if(taper_yn==null)
						taper_yn		=	"N";

					//stock_params		=	bean.validateForStock(patient_class);
					administered		=	presBean.checkAdministered(patient_id,encounter_id,drug_code,order_id);
					refill_orders		=	bean.checkRefillOrder(order_id);
					if(refill_orders.size()>0) {
						child_order			=	(String)refill_orders.get(0);
						no_of_refills		=	(String)refill_orders.get(1);
					}

					if(strength_value.equals("0")) {
						strength_value		=	"";
						strength_desc		=	"";
					}
					else {
						strength_desc		=	(String) drugDetails.get("STRENGTH_UOM");
					}

					// enable/ disable frequency based on administered status
					if(administered || flag.equals("N") || pract_type.equals("NS") || child_order.equals("Y")) {
						freq_status	=	"disabled";
					}
					allergy_yn = (String)drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN");
					current_rx = (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
					limit_ind = (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
					interaction_exists = (String)drugDetails.get("INTERACTION_EXISTS")==null?"":(String)drugDetails.get("INTERACTION_EXISTS");
					intr_restric_trn = (String)drugDetails.get("INTR_RESTRIC_TRN")==null?"":(String)drugDetails.get("INTR_RESTRIC_TRN");
					intr_msg_content = (String)drugDetails.get("INTR_MSG_CONTENT")==null?"":(String)drugDetails.get("INTR_MSG_CONTENT");
					interaction_override = (String)drugDetails.get("INTERACTION_OVERRIDE")==null?"":(String)drugDetails.get("INTERACTION_OVERRIDE");
					home_leave_med = drugDetails.get("HOME_LEAVE")==null?"":(String) drugDetails.get("HOME_LEAVE");//Added for ML-BRU-SCF-1407 [IN 050482]
					diagnosis_found_yn= (String) drugDetails.get("DIAGNOSIS_FOUND_YN");
					System.out.println("1004 diagnosis_found_yn"+diagnosis_found_yn);
			
							if(drugDetails.get("DOSE_REMARKS") !=null && !((String)drugDetails.get("DOSE_REMARKS")).equals("")){
						if(!(freq_nature.equals("P")||(freq_nature.equals("O")))){
							limit_ind="N";
							dsg_reason=(String)drugDetails.get("DOSE_REMARKS");		
							drugDetails.put("DOSE_OVERRIDE", "Y");      
						}
					}
					if(drugDetails.get("ALLERGY_REMARKS") !=null && !((String)drugDetails.get("ALLERGY_REMARKS")).equals("")){
						allergy_yn="Y";
						alg_reason=(String)drugDetails.get("ALLERGY_REMARKS");
					}
					if(drugDetails.get("INTERACTION_REMARKS") !=null && !((String)drugDetails.get("INTERACTION_REMARKS")).equals("")){
						interaction_exists="Y";
						interaction_remarks=(String)drugDetails.get("INTERACTION_REMARKS");
					}
					if(drugDetails.get("CURRENTRX_REMARKS") !=null && !((String)drugDetails.get("CURRENTRX_REMARKS")).equals("")){
						current_rx	=	"Y";
						dup_reason	=	(String)drugDetails.get("CURRENTRX_REMARKS");
					}

					if(drug_db_interface_yn.equals("Y") && drug_db_allergy_flag.equals("Y") && !drugDetails.get("EXTERNAL_PRODUCT_ID").equals(""))// drug_db_interface_yn.equals("Y") && Added condition for ML-MMOH-SCF-2514 [49131]
						allergy_yn = "N";	
					if(drug_db_interface_yn.equals("Y") && drug_db_duptherapy_flag.equals("Y") && !drugDetails.get("EXTERNAL_PRODUCT_ID").equals(""))// drug_db_interface_yn.equals("Y") && Added condition for ML-MMOH-SCF-2514 [49131]
						current_rx = "N";
					if(drug_db_interface_yn.equals("Y") && drug_db_dosage_check_flag.equals("Y") && !drugDetails.get("EXTERNAL_PRODUCT_ID").equals(""))// drug_db_interface_yn.equals("Y") && Added condition for ML-MMOH-SCF-2514 [49131]
						limit_ind = "Y";
					if(drug_db_interface_yn.equals("Y") && drug_db_interact_check_flag.equals("Y") && !drugDetails.get("EXTERNAL_PRODUCT_ID").equals("")) // drug_db_interface_yn.equals("Y") && Added condition for ML-MMOH-SCF-2514 [49131]
						interaction_exists = "N";	

					drugDetails.put("ALLERGY_YN",allergy_yn);
					drugDetails.put("CURRENT_RX",current_rx);
					drugDetails.put("LIMIT_IND",limit_ind);
					drugDetails.put("INTERACTION_EXISTS",interaction_exists);

					 allow_duplicate		= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG")==null?"N":(String) drugDetails.get("ALLOW_DUPLICATE_DRUG");

					if(dup_reason.equals("") && current_rx.equals("Y"))
						drugDetails.put("CURRENTRX_OVERRIDE","N");
					else
						drugDetails.put("CURRENTRX_OVERRIDE","Y");
					
					if(scheduled_yn!=null && scheduled_yn.equals("Y") && !called_from.equals("RENEW_ORDER")){
						durn_val_dis	=	"";
						qty_val_dis		=	"";			
					}
					else {
						durn_val_dis	=	"";
						qty_val_dis		=	"";			
					}

					disp_locn_code = (String) drugDetails.get("DISP_LOCN_CODE");
					disp_locn_desc = (String) drugDetails.get("DISP_LOCN_DESC");

					if(prescribed_mode!=null && prescribed_mode.equals("A")){
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Absolute.label","common_labels");
						color="";
					}
					else if(prescribed_mode!=null && prescribed_mode.equals("Q")){
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Dose.label", "ph_labels");
						color="";
					}
					else{
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels");				
						color="";
					}
					
					if(prn_dose.equals("") || prn_dose.equals("0")) {
						prn_dose	=	"1";
					}
					if(bean.getTakeHomeDates()!=null && bean.getTakeHomeDates().size()>0){  	//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
						start_date1 = (String)bean.getTakeHomeDates().get(0);
						end_date1=(String)bean.getTakeHomeDates().get(1);
						//sys_date=(String) presBean.getSysdate();
						//tempstartString  = start_date1.substring(0, 10);
						//tempendString  = end_date1.substring(0, 10);
						//systempString =sys_date.substring(11, sys_date.length());
						//start_date1 = tempstartString.concat(" "+systempString);
						//end_date1 = tempendString.concat(" "+systempString);
					}//Added for Bru-HIMS-CRF-093-DD1[IN047223]--end

					if(split_dose!=null && !(split_dose.equals(""))&& scheduled_yn.equals("Y")){
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.DividedDose.label", "ph_labels");
						color="red";
						split_dose = " "+split_dose;	
//						StringTokenizer	 vals	=	new StringTokenizer(split_dose,"|");
						StringTokenizer	 vals	=	new StringTokenizer(split_dose,";");
						adtime = adtime + "<table border=1 cellpadding=0 cellspacing=0 align=center>";
						ArrayList day_list = new ArrayList();
						ArrayList day_names = new ArrayList();
						ArrayList time_list = new ArrayList();
								  dose_list = new ArrayList();
                        ArrayList admin_qtyc = new ArrayList();  

						while(vals.hasMoreTokens()) {

							String code		= (String)vals.nextToken();
							//String code1		= code;
//							code=code+"=";
							code=code+"-";							
					   //    code1=code1+"=";
							//StringTokenizer	 inner_vals1	=	new StringTokenizer(code1,"=");
							StringTokenizer	 inner_vals	=	new StringTokenizer(code,"-");
							int j=0;
							int n=0;
							while(inner_vals.hasMoreTokens()) {
								  String temp_token = (String)inner_vals.nextToken();

								  if(temp_token.startsWith(" Day")){
									  day_list.add(temp_token.substring(5,temp_token.length()-1));
								  }
								  day_names.add(temp_token);	
  								  time_list.add(temp_token);	


                               /*  if(!(n%2==0)){

									String qty		= (String)inner_vals1.nextToken();
									if(admin_qtyc.size()!=0 && !admin_qtyc.contains(qty)) {
										split_chk	=	true;
									}
									admin_qtyc.add(qty);
								}*/
								n++;	


//   								  dose_list.add(temp_token.substring());	

							/*	if(j%2==0){  temp_token.startsWith("Day") || 
									String time		= (String)inner_vals.nextToken();
									admin_time.add(time);
									if(!time.trim().equals("")){
										adtime = adtime+"<tr>";
										String att=" class=TIPS";
										adtime = adtime + "<td "+att+">&nbsp;"+time+"&nbsp;</td>";
									}
								}
								else{
									String qty		= (String)inner_vals.nextToken();

									if(admin_qty.size()!=0 && !admin_qty.contains(qty)) {
										split_chk	=	true;
									}
									admin_qty.add(qty);
									if(!qty.equals("")){
										String att=" class=TIPS";
										adtime = adtime+"<td "+att+">&nbsp;"+qty+"&nbsp;</td>";
										adtime = adtime +"</tr>";
									}
								}
								j++;				
							*/		
							}
						}
						//Code for checking split dose 17/03/2010
						vals	=	new StringTokenizer(split_dose,";"); //added on 14/04/2010--priya (split_dose_yn was wrongly updated in or_order_line_ph


						while(vals.hasMoreTokens()) {
							String code1		= (String)vals.nextToken();
							//	code1=code1+"-";  // logic modified for IN20711 15/04/2010 -- priya
							StringTokenizer	 inner_vals	=	new StringTokenizer(code1,"-");
							int num=0;
							while(inner_vals.hasMoreTokens()) {
								String qty		= (String)inner_vals.nextToken();
								if(!(num%2==0)){
									if(admin_qtyc.size()!=0 && !admin_qtyc.contains(qty)) {
										split_chk	=	true;
									}
									admin_qtyc.add(qty);
								}
								num++;				
							}
						}
						adtime = adtime + "</TABLE>";
					}
					break;
				}
			}
		}
	}
/*	if(drug_db_interface_yn.equals("Y")){
			display="display:none";
			override_yn="N";
	}
	else{*/
		
		if(current_rx.equals("Y") || allergy_yn.equals("Y") || limit_ind.equals("N") || interaction_exists.equals("Y")|| (abuse_override.equals("Y") ||( abuse_exists.equals("Y")) && abuse_action.equals("B")) ){
			display="display";
			override_yn="Y";
		}
	//}
//Commented during PE By Naveen
	/*ArrayList	active_orders		=	bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
	StringBuffer drug_description	=	new StringBuffer();
	int size						=	active_orders.size();
	HashMap	record					=	new HashMap();

	for(int i=0; i<size; i++)	{
		record					=	(HashMap)active_orders.get(i);
		drug_description.append((String)record.get("drug_desc"));
		drug_description.append(" , ");
	}*/
	float tempqty = 0.0f;//Added for RUT-CRF-0088 [IN036978]-start
		if(totTapperQty==0){ 
			for(int i=0;i<drugData.size();i++){
				taperDetails		= (HashMap)drugData.get(i);
				extsrlno			= (String)taperDetails.get("DRUG_CODE");
				if(extsrlno.equals(drugs_code)){
					tempqty				=  Float.parseFloat(taperDetails.get("ORDER_QTY")==null?"0":(String) taperDetails.get("ORDER_QTY"));
				}
				totTapperQty = totTapperQty+tempqty;
			}
			taperdrugDetails.put("TOTTAPPERQTY", totTapperQty+"");
		}//Added for RUT-CRF-0088 [IN036978]-end
		if(called_from.equals("RENEW_ORDER")) {
			//bean.setOldOrder(drug_code,order_id+","+presBean.getLineNo(order_id,drug_code)); //Commented for Bru-HIMS-CRF-400 [IN:044502]
			bean.setOldOrder(drug_code , order_id+","+order_line_num ); //Added for Bru-HIMS-CRF-400 [IN:044502]
		}

	if(admin_qty.size()!=0 && split_chk) {
		qty_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SplitDose.label", "ph_labels");
		color="red";
	}
	else if(admin_qty.size()!=0 && !split_chk) {
		qty_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ScheduledDose.label", "ph_labels");
		color="red";
	}
	String line_no			=	presBean.getLineNo(order_id,drug_code);
	ArrayList drug_remarks	=	bean.getPrescribedRemarks(order_id,line_no);
	if(drug_remarks.size()!=0) { 
			for(int x=0; x<drug_remarks.size(); x++) {	
				if(x==(drug_remarks.size()-1)) {	
					pres_remarks	= pres_remarks + (String)drug_remarks.get(x);
				} 
				else {
					pres_remarks	= pres_remarks + (String)drug_remarks.get(x)+",";
				}
			} 
	   } 
// Drug Remarks - End
// Legend and dosage unit is controlled based on dosage type
		if(dosage_type.equals("A")){
				dosage_option	=	"<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Absolute.label", "common_labels")+"</option>";
		}
		else if(dosage_type.equals("S")){
				dosage_option	=	"<option value='S' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels")+"</option><option value='Q'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
		}
		else if(dosage_type.equals("Q")){
			if(ori_dosage_type.equals("S")){
				dosage_option	=	"<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels")+"</option><option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
			}
			else{
				dosage_option	=	"<option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
			}
		}
	/* stock flags 
	//commented during PE By Naveen added in drug details
	if(stock_params.size()==2) {
		consider_stock_for_pres_yn	=	(String)stock_params.get(0);
		allow_pres_without_stock_yn	=	(String)stock_params.get(1);		
	}
	*/
  
     boolean dup_found			=	false;

	if((current_rx.equals("Y")||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N") && (patient_class.equals("IP") || take_home>0) ) {
			dup_found	=	true;
		}

	// Default Strength uom
	if(dosage_type.equals("S")){
		qty_option	=	"<option value='"+strength_uom+"' selected>"+qty_desc_dis+"</option>";
	} 
	// Load Frequency
	if( in_mode!=null && in_mode.equals("amend") ) {
		HashMap freqValues	=	(HashMap)bean.populateFrequencyValues(drug_code,freq_code,in_mode,patient_class);
		if(freqValues.size()>0){
			ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
			ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
			ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
		/*	if(priorityCode != null && priorityCode.equals("U")) { //Commented for SKR-SCF-1302 
				for(int i=0;i<freqCode.size();i++){
					if(((String) FreqNature.get(i)).equals("O")) {//(bean.getFreqNature(((String) freqCode.get(i))))
							if(((String) freqCode.get(i)).equals(freq_code)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	=	"O";
						}
						else{
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  >"+(   (String) freqDesc.get(i))+"</option>";
						}
					}
				}
			}*/ 
			//else{
				for(int i=0;i<freqCode.size();i++){
					if( dup_found){
						if( ((String) FreqNature.get(i)).equals("O")) { //(bean.getFreqNature(((String) freqCode.get(i))))
							freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
						}
					}
					else{
						if(((String) freqCode.get(i)).equals(freq_code)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
							freq_nature = (String) FreqNature.get(i);// bean.getFreqNature(freq_code);
						} 
						else {
							freq_option		= freq_option + "<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
						}
					}
				}
			//}
		}
		if(freq_option.equals("")) {
			ArrayList stat_freqs	=	presBean.loadStatFreqs();					
			for(int i=0;i<stat_freqs.size();i+=2){
				if(((String) stat_freqs.get(i)).equals(freq_code)) {
					freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
					freq_nature	=	"O";
					freq_code	=((String) stat_freqs.get(i));
				}else{
					freq_option		= freq_option + "<option value='"+((String) stat_freqs.get(i))+"'>"+((String) stat_freqs.get(i+1))+"</option>";
				}
			}
		}
	}

	if(scheduled_yn.equals("N")) {
		schedule_status		=	"disabled";
	}
	//split flag

   if(split_chk){
	   split_dose_yn	=	"Y";
   } 
	// enable/disable order quantity legend
	if(dosage_type.equals("A") || freq_nature.equals("P")) {
		qty_legend_style	=	"visibility:visible";
		absol_qty_status	=	"enabled";
	} 
	else if(!freq_nature.equals("P") && (!totalTaperQtyDisplay.equals("Y")&& !taper_yn.equals("Y"))) {
		absol_qty			=	"";
	}

	if( totalTaperQtyDisplay.equals("Y")&& taper_yn.equals("Y")){
		taperQty_display="visibility:visible";
		qty_legend_style	=	"visibility:hidden"; //added for RUT-SCF-0155 [IN:033595]
	}
	else
		taperQty_display = "visibility:hidden";
	// Duration values

	if( in_mode!=null && in_mode.equals("amend") ) {
		DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
		Enumeration keys_des		= DurnDescDetails.keys();
		String	durn_code			= "";
		while(keys_des.hasMoreElements()){
			durn_code		= (String)keys_des.nextElement();

			duration_option	= duration_option + "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
		}
	}
	if(freq_nature.equals("P")){
		prn_yn = "Y";
	}
	if( home_leave_med.equals("Y")){//Added if condition for ML-BRU-SCF-1407 [IN 050482]
		buildMAR_checked="";
		buildMAR_enable="disabled";
	}
	if(ext_disp_appl_yn.equals("Y")) //nmc-jd-crf-0046
	{
		buildMAR_yn ="N";
	}
	presBean.setDisp_locn_code(disp_locn_code);//added for ml-mmoh-crf-0863
	auth_amend_pres_yn = presBean.getAuthAmendPres(disp_locn_code);//added for ml-mmoh-crf-0863
	//System.out.println(order_ststus+"order_ststus auth_amend_pres_yn"+auth_amend_pres_yn);
%>

	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="prescription_amend_detail_form" id="prescription_amend_detail_form" >
			<table border="0" width="100%" cellspacing="0" cellpadding="0">
				<input type="hidden" value="<%=bean_id%>" name="bean_id"  id="bean_id">
				<input type="hidden" value="<%=bean_name%>" name="bean_name" id="bean_name">
				<input type="hidden" value="<%=presBean_id%>" name="presBean_id" id="presBean_id">
				<input type="hidden" value="<%=presBean_name %>" name="presBean_name" id="presBean_name">
				<tr>
					<td  width="15%">
					<input type="button" class="button" value='<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/>' onClick="javascript:callActiveOrders('<%=patient_id%>','<%=encounter_id%>','','<%=patient_class%>');"></td>
					<td class="CURRTEXT"  width="85%">&nbsp;					
					</td>
					<td class="label"  width="15%"><input type='button' class='button' onClick="showDrugProfile('<%=patient_id%>','Prescription','<%=encounter_id %>')" value='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'></td>
					 <!-- ,'<%=encounter_id %>' Added for AAKH-CRF-0088.2/04 IN[62870] -->
				</tr>
			</table>
			<table cellpadding='0' cellspacing='0' width="100%" align="center" border="0">
				<td class='COLUMNHEADER' colspan="6" style="font-size:9" ><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></td>
				<tr>
					<td class="label"  width="12%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
					<td class="data"  width="40%" colspan="3"><input type="text" name="drug_name" id="drug_name" value="<%=drug_desc%>" disabled size="50"><img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails('<%=drug_code%>');">
								<!--    added for CRF RUT-CRF-0063[29601]--start -->
<%                   
				if(freq_nature.equals("O")) //SKR-SCF-1302
				priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
				else
					priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels"); 
					if(pregnency_yn.equals("Y") && !preg_effect.equals("") ){
%>
						<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" name="preg_alert" value="" src="../../ePH/images/Pregnancy.bmp" height='20'  width='20'                      onClick="chkPregnencyAlertForAmend();"></img>
<%
					}
%>
               <!--    added for CRF RUT-CRF-0063[29601]--end --></td>
					<td class="label"  width="5%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
					<td class="label"  width="30%"><input type="text" name="priority" id="priority" value="<%=priority%>" size="10" disabled>&nbsp;&nbsp;
					</td>
				</tr>
				<tr>
					<td class="label"  width="12%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
					<%
						uom_disp = bean.getUomDisplay((String)session.getValue("facility_id"),strength_desc);
						if(uom_disp == null || uom_disp.equals("null"))
							uom_disp = "";
						// added for NMC-JD-CRF-0026 start
						if(strength_display_app){
							if(strength_value!=null && strength_value!="" && !strength_value.equals("0.0")){
					%>
					
					<td class="data"  width="18%"><input type="text" name="strength_value" id="strength_value" value="<%=strength_value%>" disabled size="7" class="NUMBER">&nbsp;<%=uom_disp%> / <%=strength_per_value_pres_uom%>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),pres_base_uom)%></td>
					<%}else%>
							<td class="label"   width="18%"><input type="hidden" name="strength_value" id="strength_value" value="<%=strength_value%>" </td>
							<%} else{%>
						<td class="data"  width="18%"><input type="text" name="strength_value" id="strength_value" value="<%=strength_value%>" disabled size="7" class="NUMBER">&nbsp;<%=uom_disp%></td>
					<%}
					%>
				<!--  added for NMC-JD-CRF-0026 end -->
					<td class="label"  width="32%" colspan="2"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<input type="text" name="form_desc" id="form_desc" value="<%=form_desc%>" disabled size="10"></td>
					<td class="label"  width="5%"><fmt:message key="Common.Route.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td class="data" id="strength" width="30%">
						&nbsp;&nbsp;<select name='route' id='route' onchange="routeChange(this);getActionText(this,'<%=form_code%>');" <%=taper_disabled%>> <!-- add getActionText function for SKR-CRF-0006[IN029561]-->
						<!-- Code Added for CRF 0034 Start -->
<%
							if(routesforform!=null && routesforform.size()>1)
								for(int i=0;i<routesforform.size();i+=3){
									backgrndColor="FFFFFF";
									fntColor="000000";
									route_color = (String)routesforform.get(i+2);
									if(route_color!= null && !route_color.equals("") && route_color.length()==12){
										fntColor= route_color.substring(0, 6);
										backgrndColor= route_color.substring(6, 12);
									}
									if(route_code.equals(routesforform.get(i))){
%>
										<option style= 'color:<%=fntColor%>;background-color:<%=backgrndColor%>;' value='<%=routesforform.get(i)%>' selected><%=routesforform.get(i+1)%></option>
<%
										actionText = presBean.getActionText(form_code,route_code);	 //add for SKR-CRF-0006[IN029561]
									}
									else{
%>
										<option style= 'color:<%=fntColor%>;background-color:<%=backgrndColor%>;' value='<%=routesforform.get(i)%>'><%=routesforform.get(i+1)%></option>
<%
									}
								}
%>
<!-- Code Added for CRF 0034 End -->
					</td>
				</tr>
				<tr>
<%
				if(trade_display_yn.equals("Y")){
%>
					<td class="label"  width="22%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
					<td class="data"  width="18%"><input type="text" name="trade_name" id="trade_name" value="<%=trade_name%>" disabled size="7" class="NUMBER">
<%				}
				else{
					trade_code="";
%>
					<td class='label' colspan='2'>&nbsp;<!--added for alignment issue for SKR-CRF-0006 ICN 29561 -->
<%
				}
%>
					<input type='hidden' name='trade_code' id='trade_code' value='<%=trade_code%>'>
					</td>
					<td class="label" colspan='3'> &nbsp;</td>
					</td>
					<!-- added this label  for SKR-CRF-0006[IN029561] -->
						<td class='label' >&nbsp;<label style='color:red;' id="actionTextval"   > <%=actionText%>   </label></td>
				</tr>
			</table>
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
				<tr>
					<td  class="label">
<%
//added for SRR20056-SCF-7882 -29157 - Start
						if(MAR_app_yn.equals("Y")){
							if(!ext_disp_appl_yn.equals("Y")){    //Added For NMC-JD-CRF-0046
%>
							<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> <%=buildMAR_enable%>  onclick='assignValue(this);' <%=freq_status%>>
<%
						} 
						else{    //Added For NMC-JD-CRF-0046
%>
						<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
				    	<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value="N" disabled >
<%	}
					}
						else{
%>
							<!-- &nbsp;<input type='hidden' name='buildMAR_yn' id='buildMAR_yn' value='N'> -->
							<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
<%
						}
//added for SRR20056-SCF-7882 -29157 - end
%>						<%
							if(item_type_site_app && disp_by_alt_form_param.equals("Y")){ //GHL-CRF-549
%>
							<fmt:message key="ePH.AllowAlternate.label" bundle="${ph_labels}"/>&nbsp;
							<input type='checkbox' name='allow_alternate_yn' id='allow_alternate_yn' <%=allow_alternate_checked%>  disabled >
							
<%
							}							
%>						 </td>
					<!--<td class="label" >&nbsp;&nbsp;<img src="../../eOR/images/Authorization.gif" id="requires_auth_gif"   style="visibility:hidden" onclick="chkAuthorization('auth')"></img></td> -->
<%
						display_auth_rule = "visibility:hidden";
						if(ord_auth_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							color_auth_rule = "color:red";
							if(ord_authorized_yn.equals("Y"))
								color_auth_rule = "color:green";
							//if condtion added for ml-mmoh-crf-0863
							if(auth_amend_pres_yn.equals("Y") && called_amend_from.equals("PH") )
								color_auth_rule = "color:green";
							
						}
						//added for mo-scf-5533
						if(ord_auth_reqd_yn.equals("Y") && ord_authorized_yn_durn.equals("Y")){
							display_auth_rule = "visibility:visible";
							color_auth_rule = "color:green";
						}
%>
					<td  class="label"><label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></label></td>
<%
						display_auth_rule = "visibility:hidden";
						color_auth_rule   = "color:red";
						if(ord_spl_appr_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_approved_yn.equals("Y"))
								color_auth_rule = "color:green";
						} 
%>
						<td class="label"  align='center' colspan='2'><label id='lbl_splapprvl' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="ePH.splapproval.label" bundle="${ph_labels}"/></label></td>
<%
						display_auth_rule = "visibility:hidden";
						color_auth_rule   = "color:red";
						if(ord_cosign_reqd_yn.equals("Y")){
							display_auth_rule = "visibility:visible";
							if(ord_cosigned_yn.equals("Y"))
								color_auth_rule = "color:green";
						}
%>
						<td class="label" align='center'><label id='lbl_cosign' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></label></td>
					 <td class="fields" ><a href="javascript:viewReasonforRequest('<%=tdm_order_id%>');" id="tdm_details" style="<%=display_tdm%>" style="font-size:9"title="TDM result"><fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a><td>
				</tr>
			</table>
			<table cellpadding='0' cellspacing='0' width="100%" align="center" border="0">
				<td class='COLUMNHEADER' colspan="6" style="font-size:9" ><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></td>
				<tr>
					<td class="label" ><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/></td>
					<td  class="label">&nbsp;&nbsp;<select name="dosage" id="dosage" onChange="dosageChange(this);" style="width:100;"  disabled>
<%
							if( in_mode!=null && !in_mode.equals("amend") ) { 
%>
								<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
<%	
							}
%>
							<%=dosage_option%>
						</select>
					</td>
					<td class="label"  colspan="2" id="dosage_label">&nbsp;<font color='<%=color%>' onmouseover="displayamendToolTipDataChange('<%=adtime%>');" onmouseout="disasbleamendToolTipDataChange();" ><%=qty_legend%></td>
<%

				/*	if(qty_value != null && qty_value != "" && Float.parseFloat(qty_value) < 1)
							qty_value = Float.parseFloat(qty_value)+""; */ //commented for IN25920 --28/01/2011-- priya
	
					if(split_dose_yn.equals("Y")){
%>
						<td class="label" >&nbsp;&nbsp;<input type="text" name="qty_value" id="qty_value" size="3" maxlength="13" class="NUMBER"  value="<%=qty_value%>" <%=durn_val_dis%> onKeyPress="return allowValidNumber(this,event,8,<%=dose_decimal%>);" onblur="lookForChange(this);" <%=strength_field%>  <%=freq_status%> <%=taper_disabled%>></td>
<%
					}
					else{
%>
						<td class="label"  >&nbsp;&nbsp;<input type="text" name="qty_value" id="qty_value" size="10" maxlength="13" class="NUMBER" <%=durn_val_dis%> onKeyPress="return allowValidNumber(this,event,8,<%=dose_decimal%>);" onblur="changedoseoverridevalue();" <%=strength_field%>  <%=freq_status%>  value="<%=qty_value%>" <%=taper_disabled%>>
						</td>	   <!--removed call to freqChange(freq_desc,'Y'); on blur --priya  for IN18928 -- 22/02/2010 -->
<%
					}
%>
					<td class='fields'>		
						<select name="qty_desc" id="qty_desc" style="width:110;" <%=freq_status%>>
<%
							if( in_mode!=null && !in_mode.equals("amend") ) {
%>
								<option value="">&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
<%	
							}	
%>
							<%=qty_option%>
						</select>
					</td>
				</tr>
				<tr NOWRAP>
					<td class="label" ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
					<td class="label" COLSPAN=5 >&nbsp;&nbsp;<select name="freq_desc" id="freq_desc" onChange="freqChange(this,'Y','ChangeFreq')" style="width:480;" <%=taper_disabled%> <%=freq_status%>><!-- modified for SKR-SCF-1302-->
<% 
						if( in_mode!=null && !in_mode.equals("amend") ) { 
%>
							<option>&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
<%	
						}
%>
						<%=freq_option%>
						</select>
					<input id="dis_split_dose" type="button" class="button" value='<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/>'  style="visibility:visible" name="split_dose" onClick="DisplaySchedule()" <%=schedule_status%> <%=freq_status%> <%=taper_disabled%>>
					</TD>
					<TR>
					</TR>
					<td  class="fields" COLSPAN=2  style='TEXT-ALIGN:right;'>
						<a href="javascript:callPRNDetails();" id="prn_remarks" style="visibility:hidden" title="PRN Remarks"><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/></a><img  style="visibility:hidden"  id="prn_remarks_image" src="../../eCommon/images/mandatory.gif"></img>
					</td>
<%
					if(split_dose_yn.equals("N")){
%>
						<td class='fields' colspan="3"><a href="javascript:setRecommendDosage();" id="rec_legend" style="visibility:hidden" title="Recommended Dosage" onclick="changeschedule();"><fmt:message key="ePH.Recom.Dose.label" bundle="${ph_labels}"/></a>
						<label id="rec_value" style="font-size:11;font-weight:bold;color:red"></label>
						&nbsp;<label id="rec_uom" style="font-size:11;font-weight:bold;color:red"></label></td>
<%
					}
					else{
%>
						<td colspan="3"><label  id="rec_legend" style="font-size:11;font-weight:bold;color:red;visibility:hidden" ><fmt:message key="ePH.Recom.Dose.label" bundle="${ph_labels}"/></label>
						<label id="rec_value" style="font-size:11;font-weight:bold;color:red"></label>
						&nbsp;<label id="rec_uom" style="font-size:11;font-weight:bold;color:red"></label></td>
<%
					}
%>
				</tr>
				
				<td class='COLUMNHEADER' colspan="6" style="font-size:9" ><fmt:message key="ePH.DurationDetail.label" bundle="${ph_labels}"/></td>
				<tr>
					<td class="label" ><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
					<td class="label" >&nbsp;&nbsp;<input type="text" size="1" maxlength="3" name="durn_value" id="durn_value" class="NUMBER"  value="<%=durn_value%>"  <%=qty_val_dis%> <%=freq_status%> onblur="extDosageCheck('Modify');durationConversn(document.prescription_amend_detail_form.durn_desc);getChargeDetails('<%=in_formulary_yn%>');"  onchange="maxDurnValidation();assignHomeDuration();checkDuplicateDrug();" onKeyPress="return(ChkNumberInput(this,event,'0'))"  <%=taper_disabled%> >&nbsp;&nbsp;
						<select name="durn_desc" id="durn_desc" onChange="maxDurnValidation();durationConversn(this);getChargeDetails('<%=in_formulary_yn%>');" <%=taper_disabled%> <%=freq_status%>>
						<!-- validateAllDates(); -->
							<option>-<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>-</option>
							<%=duration_option%>
						</select>
							<input type="hidden" name="tmp_durn_value" id="tmp_durn_value" value="<%=freq_durn_value%>">
							<input type="hidden" name="tmp_durn_desc" id="tmp_durn_desc"  value="<%=freq_durn_type%>">					
						</td>
					<td class="label"  ><label id="ord_qty_lbl" style="<%=qty_legend_style%>"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/></label></td>
					<td  class="data" >&nbsp;<input class='NUMBER' type="text" size="3" maxlength="5" name="absol_qty" id="absol_qty" value="<%=absol_qty%>" style="<%=qty_legend_style%>" onBlur="ValidateAbs(this);CheckPositiveNumber(this);getChargeDetails('<%=in_formulary_yn%>','ABS_QTY'); <%=visable_dose_for_prn%>" onKeyPress="return(ChkNumberInput(this,event,'0'))" <%=absol_qty_status%> <%=freq_status%>>&nbsp;<label id="ord_qty_uom" style="<%=qty_legend_style%>"><%=stock_uom%></label></td> <%-- <%=visable_dose_for_prn%> Added for ML-MMOH-SCF-2514--%>
					<td  class='label' align='right' style='<%=taperQty_display%>'>
						<label id="tot_tap_qty_lbl" style="color:red;font-weight:bold;font-size:9;" >
						<fmt:message key="Common.Taper.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Qty.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;
					<input class='NUMBER' type="text" size="3" maxlength="3" name="totTapperQty" id="totTapperQty" value="<%=absol_qty%>" <%=taper_disabled%> onchange="ValidateAbs(this);getTotalTaperQty('<%=in_formulary_yn%>','TAPER_QTY');" onKeyPress="return(ChkNumberInput(this,event,'0'))" > &nbsp;&nbsp;<label id="taper_qty_uom"  style="font-size:9;"><%=stock_uom%></label></td>
					<input type='hidden' name='prevTotalTaperQty' id='prevTotalTaperQty' value='<%=absol_qty%>'>
					<input type='hidden' name='totalTaperQtyDisplay' id='totalTaperQtyDisplay' value='<%=totalTaperQtyDisplay%>'>
					<td  class='label' align='right' style='<%=taperQty_display%>'>    <!--Added for RUT-CRF-0088 [IN036978]-start  -->
								<label id="tot_tap_qty_lbl" style="color:red;font-weight:bold;font-size:9;" ><fmt:message key="Common.total.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Taper.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Qty.label" bundle="${common_labels}"/>
								</label>&nbsp;&nbsp;
					<input class='NUMBER' type="text" size="3" maxlength="3" name="totalTapper" id="totalTapper" value="<%=(int)totTapperQty%>" <%=taper_disabled%> onchange="ValidateAbs(this);getTotalTaperQty('<%=in_formulary_yn%>','TAPER_QTY');" onKeyPress="return(ChkNumberInput(this,event,'0'))" > &nbsp;&nbsp;<label id="taper_qty_uom"  style="font-size:9;"><%=stock_uom%></label></td>
				<!--Added for RUT-CRF-0088 [IN036978]-end  -->
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="start_date" id="start_date" size="13"  maxlength="13"  value="<%=drug_start_date%>" disabled></td>
					<td class="label" colspan="2" nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="text" name="end_date" id="end_date" size="13"  maxlength="13" value="<%=drug_end_date%>" disabled></td>
					<td class="label" colspan="2"  style="" >&nbsp;&nbsp;<input type="button" class="button" value='<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/>'  style="<%=display%>" id="dosage_limit" onclick="showAmendOverRideRemarks(prescription_amend_detail_form)" >
					<input type='hidden' name='override_remarks' id='override_remarks' value='N'>
					</td>
				</tr>
				<tr>
<% 	
					//if(!(PhLicenceRights.getKey()).equals("PHBASIC") ) { 
%>
						<td class="label"  ><fmt:message key="ePH.DispenseLocation.label"  bundle="${ph_labels}"/></td>
						<td class="label" >&nbsp;&nbsp;<input type="text" size="20" maxlength="20" name="disp_locn_desc" id="disp_locn_desc" disabled value="<%=disp_locn_desc%>">&nbsp;<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>"></td>
<%	
					/*}
					else {	*/
%>
					<!-- 	<td class="label"  >&nbsp;</td>
						<td class="label"  ><input type="hidden" name="disp_locn_code" id="disp_locn_code" value=""></td> -->
<%	
					//}
%>
					<td class="label"  >&nbsp;</td>
					<td class="label"  >&nbsp;&nbsp;<a href="javascript:callOrderAmend();" id="drug_remarks"  title='<fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></a>
					<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 start-->
					<img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'>
					<input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
					<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
					<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 End -->
					<!--Added for  ML-BRU-CRF-072[Inc:29938] start-->
					<td class="label" colspan="2">
					<a href="javascript:drugindication_remarksAmend();" id="drug_ind_remarks" style="visibility:visible" title='<fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a>
				<%	if(drug_indication_mdry.equals("Y")){
								 %>	
								 &nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
								<%} %>
					</td>
					<!--Added for  ML-BRU-CRF-072[Inc:29938] end-->
				</tr>
<%
					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
						<INPUT TYPE="hidden" name="sql_ph_prescription_bl_action_select_lookup" id="sql_ph_prescription_bl_action_select_lookup" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_PRESCRIPTION_BL_ACTION_SELECT_LOOKUP") %>">						
<%
					}
%>
				<tr >
					<td colspan="6" >				
						<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">

							<tr align="left" id='BL_HEADERBAR' style='display:none;'>
								<%//added for ml-bru-crf-0469
								if(displayGrossAmtYn){ %>
								<th class='COLUMNHEADER' colspan="7" style="font-size:9" ><fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>		
								<%} else { %>
								<th class='COLUMNHEADER' colspan="6" style="font-size:9" ><fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>		
								<%} %>
										
							</tr>
							<tr id='BL_HEADER' style='display:none;'>
							
								<%-- added for mms-dm-crf 0247.2 --%>
								<td class="label" width='13%'><fmt:message key="ePH.IncludedinInsurance.label" bundle="${ph_labels}"/>
								</td>
								
							 <%-- commented for CRF-0247.2 <td class="label" width='9%'><fmt:message key="Common.IncludedinInsurance.label" bundle="${common_labels}"/>
								</td>   --%>
								  
								<td class="label" width='11%' id='bl_override_excl_incl_ind_lbl'><fmt:message key="ePH.OverrideIncl/Excl.label" bundle="${ph_labels}"/>
						       </td>
								<%//added for ml-bru-crf-0469
								if(displayGrossAmtYn){ %>
								<td  class="label" width='27%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/>
								</td>
								<%} else{ %>
								<td  class="label" width='40%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/>
								<%}  %>
								<%//added for ml-bru-crf-0469
								if(displayGrossAmtYn){ %>
								<td class="label"  width='13%' style='TEXT-ALIGN:right;'> <fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/>
								</td>
								<%}  %>
								
							<%--COMMENTED FOR CRF-0247.2 	<td class="label"  width='13%' style='TEXT-ALIGN:right;'><fmt:message key="common.TotalChargeAmount.label" bundle="${common_labels}"/>
								</td>
								<td class="label"  width='10%'style='TEXT-ALIGN:right;'><fmt:message key="common.PatientPayable.label" bundle="${commmon_labels}"/>
								</td>--%>
								
								<%-- added for mms-dm-crf 0247.2 --%>
								<td class="label"  width='15%' style='TEXT-ALIGN:center;'><fmt:message key="ePH.TotalServiceAmount.label" bundle="${ph_labels}"/>
								</td>
								<td class="label"  width='13%'style='TEXT-ALIGN:right;'><fmt:message key="ePH.TotalPayableAmount.label" bundle="${ph_labels}"/>
								</td>
								<td class="label" width='9%'><fmt:message key="ePH.ApprovalReqd.label" bundle="${ph_labels}"/>
								</td>
								<td class="label" nowrap width='10%'><fmt:message key="ePH.PackageService.label" bundle="${ph_labels}"/>
								</td>
 		
 								<!-- Added for MMS-DM-CRF-0263.2 start -->
 								<td id='bl_diagnosis_1' align='center'>
 								<table width="100%">
								<tr>
								<td class="label" id="bl_diagnosis_h">&nbsp;
								</td>
								</tr>
								</table>
								</td> 
								<!-- Added for MMS-DM-CRF-0263.2 end -->
								
							</tr>
							<tr id='BL_VALUES' style='display:none;'>
								 <td align='center' id='bl_def_override_excl_incl_ind_gif'>&nbsp;
								</td>
								<td class="label" id='td_bl_override_excl_incl_ind'>
<%     
							include_selected ="";  
							exclude_selected =""; 	
							Select_selected ="";
							if(bl_override_excl_incl_ind.equals("I")){
								include_selected ="selected";
							}
							else if(bl_override_excl_incl_ind.equals("E")){
								exclude_selected ="selected";
							}
							else {
								Select_selected ="selected";
							}
%>
							<select name="bl_override_excl_incl_ind" id="bl_override_excl_incl_ind" onchange="assignOverrideExclInclInd(this)"  >
							<!--<option value="SEL">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option> --> 
<%
							if(bl_override_allowed_yn.equals("I")){
%>
							     <option value="SEL"<%=Select_selected%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
								<option value="I" <%=include_selected%>><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
<%
							}
							if(bl_override_allowed_yn.equals("E")){
%>
							     <option value="SEL"<%=Select_selected%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
								<option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
<%
							}
							if(bl_override_allowed_yn.equals("B")){
%>
							    <option value="SEL"<%=Select_selected%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							    <option value="I" <%=include_selected%> ><fmt:message key="Common.Include.label" bundle="${common_labels}"/></option>
							    <option value="E" <%=exclude_selected%> ><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/></option>
<%
								}
								if(bl_override_allowed_yn.equals(""))
%>
							      <option value="SEL"selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
							</select>
						</td>
								<input type='hidden' name='bl_def_override_excl_incl_ind' id='bl_def_override_excl_incl_ind' value='<%=bl_def_override_excl_incl_ind%>'>
								<input type='hidden' name='bl_override_allowed_yn' id='bl_override_allowed_yn' value='<%=bl_override_allowed_yn%>'>
								<td class="label" nowrap>
									<input type='text' name='bl_incl_excl_override_reason_desc' id='bl_incl_excl_override_reason_desc' size='40'  value='<%=bl_incl_excl_override_reason_desc%>' readonly >
<%
									if(bl_incl_excl_override_reason_desc.equals("")){
										
%>										
										<input type="button" name="bl_overriden_action_reason_lkp" id="bl_overriden_action_reason_lkp" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>');" disabled><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img' style='visibility:hidden;'></img>
<%
									}
									else{
%>
										<input type="button" name="bl_overriden_action_reason_lkp" id="bl_overriden_action_reason_lkp" value="?" class="button" onClick="searchBLOverrideReason('<%=locale%>');"><img  src="../../eCommon/images/mandatory.gif" id='bl_overriden_action_reason_img' style='visibility:visible;'></img>
<%
									}
%>
									<input type='hidden' name='bl_incl_excl_override_reason_code' id='bl_incl_excl_override_reason_code' value='<%=bl_incl_excl_override_reason_code%>'>
								</td>
								
								
								<%	//added for ml-bru-crf-0469
								if(displayGrossAmtYn){ %>
						<td class="data" id='gross_charge_amt' align='center'>
						</td>
					<%	} else{ %>
					   <td class="data"  id='gross_charge_amt' align='center' style='display:none;'>
						</td>
						<%} %>
								<td class="data" id='bl_total_charge_amt' align='right'>
								</td>
								<td class="data" id='bl_patient_payable_amt' align='right'>
								</td>
								<td align='center'id='bl_approval_reqd_yn'>
								</td>
								<td class="data" id='bl_package_trx_yn' align='center'> <!--Added for MMS-DM-CRF-0247.7-->
								</td>
							
								<!--Added for MMS-DM-CRF-0263.2 start-->
								<td id='bl_diagnosis_1' align='center'>
								<table width="100%">
								<tr>
								<td class="label" id="bl_diagnosis_v">&nbsp;
								</td>
								</tr>
								</table>
								</td>
								
								<!--Added for MMS-DM-CRF-0263.2 end-->
							</tr>
						</table>
					</td>
				</tr>
			</table>
<%		
// Display Message if the drug is under administration/tappered
			String message	=	"";		
			if(administered) {
				//message	=	"Note: This Medication is under Administration. Dosage cannot be modified.";
				message	=	bean.getMessage(locale,"MEDN_UNDER_ADMIN_DOSE_CANNOT_MODIFY","PH");
			}
			else if(flag.equals("N")) {
				//message	=	"Note: Future Prescriptions Contains this drug. Dosage cannot be modified.";
				message	=	bean.getMessage(locale,"FUTURE_RX_DOSE_CANNOT_MODIFY","PH");
			}
			else if(child_order.equals("Y")){
				//message	=	"Note: Future Refill Exists. Dosage cannot be modified.";
				message	=	bean.getMessage(locale,"FUTURE_REFILL_DOSE_CANNOT_MODIFY","PH");
			}
			else if((!child_order.equals("N"))&&(!no_of_refills.equals(""))) {
				message		=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NoofRefill.label", "ph_labels")+" : "+no_of_refills; 
			}
%>
			<br>
			<table  border="0" width="100%" cellspacing="0" cellpadding="0">
				<tr><td class="white"  ><label style="color:red;font-size:11;font-weight:bold">&nbsp;&nbsp;<%=message%></label></td></tr>
			</table>

			<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
				<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
					<tr><td width="100%" id="t"></td></tr>
				</table>
			</div>
			<input type="hidden" name="drug_desc" id="drug_desc" value="<%=drug_desc%>">
			<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
			<input type="hidden" name="generic_id" id="generic_id" value="<%=generic_id%>">
			<input type="hidden" value="" name="generic_name" id="generic_name">
			<input type="hidden" value="<%=allergy_yn%>" name="allergy_yn" id="allergy_yn">
			<input type="hidden" value="<%=current_rx%>" name="current_rx"  id="current_rx">
			<input type="hidden" value="<%=order_line_num%>" name="order_line_num"  id="order_line_num"><!--Added for the ICN:34834-->
			<input type="hidden" value="<%=min_unit_dose%>" name="min_unit_dose" id="min_unit_dose">
			<input type="hidden" value="<%=min_daily_dose%>" name="min_daily_dose" id="min_daily_dose">

			<input type="hidden" value="<%=patient_id%>" name="patient_id" id="patient_id">
			<input type="hidden" value="<%=encounter_id%>" name="encounter_id" id="encounter_id">
			<input type="hidden" value="<%=drug_code%>" name="drug_code" id="drug_code">
			<input type="hidden" value="<%=ext_prod_id%>" name="ext_prod_id" id="ext_prod_id">
			<input type="hidden" value="<%=repeat_value%>" name="repeat_value" id="repeat_value">
			<input type="hidden" value="<%=durn_type%>" name="durn_type" id="durn_type">
			<input type="hidden" value="<%=prescribed_mode%>" name="prescribed_mode" id="prescribed_mode">
			<input type="hidden" value="<%=mode%>" name="mode" id="mode">
			<input type="hidden" value="<%=limit_ind%>" name="limit_ind" id="limit_ind">
			<input type="hidden" value="<%=daily_dose%>" name="daily_dose" id="daily_dose">
			<input type="hidden" value="<%=unit_dose%>" name="unit_dose" id="unit_dose">
			<input type="hidden" value="<%=mono_graph%>" name="mono_graph" id="mono_graph">
			<input type="hidden" value="<%=temp_mono_graph%>" name="temp_mono_graph" id="temp_mono_graph"><!-- Modified for IN:071108 -->
			<input type="hidden" value="<%=srl_no%>" name="srl_no" id="srl_no">
			<input type="hidden" value="<%=patient_class%>" name="patient_class" id="patient_class">
			<input type="hidden" value="<%=order_type_code%>" name="order_type_code" id="order_type_code">
			<input type="hidden" value="<%=form_code%>" name="form_code"  id="form_code">
			<input type="hidden" value="<%=route_code%>" name="route_code" id="route_code">
			<input type="hidden" value="<%=repeat_durn_type%>" name="repeat_durn_type" id="repeat_durn_type">
			<input type="hidden" value="<%=override_yn%>" name="override_yn" id="override_yn">
			<input type="hidden" value="<%=alg_reason%>" name="alg_reason"  id="alg_reason">
			<input type="hidden" value="" name="dsg_reason_yn" id="dsg_reason_yn">
			<input type="hidden" value="<%=dsg_reason%>" name="dsg_reason" id="dsg_reason">
			<input type="hidden" value="<%=dup_reason%>" name="dup_reason" id="dup_reason">
			<input type="hidden" value="<%=called_from%>" name="called_from" id="called_from">
			<input type="hidden" value="<%=dup_start_date%>" name="dup_start_date" id="dup_start_date">
			<input type="hidden" value="<%=dup_end_date%>" name="dup_end_date" id="dup_end_date">
			<input type="hidden" name="dosage_type" id="dosage_type" value="<%=dosage_type%>">
			<input type="hidden" name="consider_stock_for_pres_yn" id="consider_stock_for_pres_yn" value="<%=consider_stock_for_pres_yn%>">
			<input type="hidden" name="allow_pres_without_stock_yn" id="allow_pres_without_stock_yn" value="<%=allow_pres_without_stock_yn%>">
			<input type="hidden" name="fract_dose_round_up_yn" id="fract_dose_round_up_yn" value="<%=fract_dose_round_up_yn%>">
			<input type="hidden" value="<%=in_formulary_yn%>" name="in_formulary_yn">
			<input type="hidden" name="strength_per_pres_uom" id="strength_per_pres_uom" value="<%=strength_per_pres_uom%>">
			<input type="hidden" name="strength_per_value_pres_uom" id="strength_per_value_pres_uom" value="<%=strength_per_value_pres_uom%>">
			<input type="hidden" name="con_reason" id="con_reason" value="<%=con_reason%>">
			<input type="hidden" name="int_reason" id="int_reason" value="<%=int_reason%>">
			<input type="hidden" value="<%=fract_dose_appl_yn%>" name="fract_dose_appl_yn" id="fract_dose_appl_yn">
			<input type="hidden" value="<%=taper_disabled%>" name="taper_disabled" id="taper_disabled">
			<input type="hidden" value="<%=interaction_exists%>" name="interaction_exists" id="interaction_exists">
			<input type="hidden" value="<%=intr_restric_trn%>" name="intr_restric_trn" id="intr_restric_trn">
			<input type="hidden" value="<%=intr_msg_content%>" name="intr_msg_content" id="intr_msg_content">
			<input type="hidden" value="<%=interaction_override%>" name="interaction_override" id="interaction_override">
			<input type="hidden" value="<%=interaction_remarks%>" name="interaction_remarks" id="interaction_remarks">
			<input type="hidden" value="<%=freq_status%>" name="freq_status" id="freq_status"><!-- added for ML-BRU-SCF-0725 [IN:038336] -->
			<input type="hidden" name="take_home_start_date" id="take_home_start_date" value="<%=start_date1%>"><!--Added  for Bru-HIMS-CRF-093-DD1[IN047223]-->
			<input type="hidden" name="take_home_end_date" id="take_home_end_date" value="<%=end_date1%>"><!--Added  for Bru-HIMS-CRF-093-DD1[IN047223]-->
			<!-- Added for IN:071108 start -->
       		<input type="hidden" value="<%=max_daily_ceeling_dose%>" name="max_daily_ceeling_dose" id="max_daily_ceeling_dose">
       		<input type="hidden" value="<%=min_daily_ceeling_dose%>" name="min_daily_ceeling_dose" id="min_daily_ceeling_dose">
      	 	<input type="hidden" value="<%=max_unit_ceeling_dose%>" name="max_unit_ceeling_dose" id="max_unit_ceeling_dose">
       		<input type="hidden" value="<%=min_unit_ceeling_dose%>" name="min_unit_ceeling_dose"  id="min_unit_ceeling_dose">
       		<!-- Added for IN:071108 end -->
       		
       		 <!-- Added for IN:072715 start -->
       <input type="hidden" value="<%=allergy_remarks_code%>" name="allergy_remarks_code" id="allergy_remarks_code">
       <input type="hidden" value="<%=dose_remarks_code%>" name="dose_remarks_code" id="dose_remarks_code">
       <input type="hidden" value="<%=currentrx_remarks_code%>" name="currentrx_remarks_code" id="currentrx_remarks_code">
       <input type="hidden" value="<%=interaction_remarks_code%>" name="interaction_remarks_code" id="interaction_remarks_code">
       <input type="hidden" value="<%=food_interaction_remarks_code%>" name="food_interaction_remarks_code"  id="food_interaction_remarks_code">
       <input type="hidden" value="<%=lab_interaction_remarks_code%>" name="lab_interaction_remarks_code" id="lab_interaction_remarks_code">
       <!-- Added for IN:072715 end -->
       		
<%
			if(amended_yn!=null && amended_yn.equals("Y") && (dosage_type.equals("Q")|| dosage_type.equals("A"))) {
%>
				<input type="hidden" name="dflt_qty_uom" id="dflt_qty_uom" value="<%=qty_desc_code%>">
<%	
			}
			else {
%>
				<input type="hidden" name="dflt_qty_uom" id="dflt_qty_uom" value="">
<%	
			}	
%>
			<input type="hidden" name="strength_uom" id="strength_uom" value="<%=strength_desc%>">
			<input type="hidden" value="<%=strength_uom_desc%>" name="strength_uom_desc" id="strength_uom_desc">
			<input type="hidden" value="<%=tab_qty_value%>" name="tab_qty_value" id="tab_qty_value">
			<input type="hidden" name="calling_mode" id="calling_mode" value="<%=in_mode%>">
			<input type="hidden" name="split_dose_yn" id="split_dose_yn" value="<%=split_dose_yn%>">
			<input type="hidden" value="<%=scheduled_yn%>" name="scheduled_yn">
			<input type="hidden" name="admin_time" id="admin_time" value="">
			<input type="hidden" name="admin_qty" id="admin_qty" value="">
			<input type="hidden" name="init_qty" id="init_qty" value="<%=qty_value%>">
			<input type="hidden" name="freq_nature" id="freq_nature" value="<%=freq_nature%>">
			<input type="hidden" name="prn_dose" id="prn_dose" value="<%=prn_dose%>">
			<input type="hidden" value="<%=interval_value%>" name="interval_value" id="interval_value">
			<input type="hidden" value="<%=pres_base_uom%>" name="pres_base_uom" id="pres_base_uom">
			<input type="hidden" name="pres_remarks" id="pres_remarks" value="<%=pres_remarks%>">
			<input type="hidden" name="taper_yn" id="taper_yn" value="<%=taper_yn%>">
			<input type="hidden" name="calc_by_ind" id="calc_by_ind" value="<%=calc_by_ind%>">
			<input type="hidden" name="dosage_std" id="dosage_std" value="<%=dosage_std%>">
			<input type="hidden" name="dosage_unit" id="dosage_unit" value="<%=dosage_unit%>">	
			<input type="hidden" value="<%=presBean.getUOMDesc(dosage_unit)%>" name="dosage_unit_uom" id="dosage_unit_uom">	<!-- code added for ml-mmoh-crf-0978-->
			<input type="hidden" name="recomm_yn" id="recomm_yn" value="<%=recomm_yn%>">
			<input type="hidden" name="prev_freq_nature" id="prev_freq_nature" value="">
			<input type="hidden" name="prn_yn" id="prn_yn" id="prn_yn" id="prn_yn" value="<%=prn_yn%>">	
			<input type="hidden" value="<%=man_rem_on_prn_freq_yn%>" name="man_rem_on_prn_freq_yn" id="man_rem_on_prn_freq_yn">	
			<input type="hidden" name="prn_remarks_flag" id="prn_remarks_flag" value="<%=prn_remarks%>">	
			<input type="hidden" value="<%=ord_auth_reqd_yn%>" name="ord_auth_reqd_yn" id="ord_auth_reqd_yn">
			<input type="hidden" name="force_auth_yn" id="force_auth_yn" value="<%=force_auth_yn %>"><!-- added for ML-MMOH-SCF-0498 -->
			<input type="hidden" value="<%=ord_authorized_yn%>" name="authroize_yn_val" id="authroize_yn_val">
			<input type="hidden" name="ord_authorized_yn_durn" id="ord_authorized_yn_durn" value="<%=ord_authorized_yn_durn%>"><!-- Added for mo-scf-5533 -->
			<input type="hidden" value="<%=ord_authorized_prev_yn%>" name="ord_authorized_prev_yn" id="ord_authorized_prev_yn">	
			<input type="hidden" value="<%=ord_spl_appr_reqd_yn%>" name="ord_spl_appr_reqd_yn" id="ord_spl_appr_reqd_yn">
			<input type="hidden" value="<%=ord_cosign_reqd_yn%>" name="ord_cosign_reqd_yn" id="ord_cosign_reqd_yn">
			<input type="hidden" value="<%=ord_approved_yn%>" name="ord_approved_yn" id="ord_approved_yn">
			<input type="hidden" value="<%=ord_cosigned_yn%>" name="ord_cosigned_yn" id="ord_cosigned_yn">
			<input type = "hidden" value = "<%=qty_desc_dis%>" name = "qty_desc_dis"  id = "qty_desc_dis">
			<input type="hidden" value = "<%=billable_item_yn%>" name = "billable_item_yn"  id = "billable_item_yn"> 
			<input type="hidden" name="DrugIndicationRemarks" id="DrugIndicationRemarks" value="<%=DrugIndicationRemarks%>"><!--Added for  ML-BRU-CRF-072[Inc:29938]-->
			<input type="hidden" name="drug_indication_mdry" id="drug_indication_mdry" value="<%=drug_indication_mdry%>"><!-- added for jd-crf-0220 -->
			<input type="hidden" name="calc_dosg_by_freq_durn_yn" id="calc_dosg_by_freq_durn_yn" value="<%=calc_dosg_by_freq_durn_yn%>"><!-- added for RUT-SCF-0154 [IN:033594] && RUT-SCF-0155 [IN:033595] -->
<!-- 		</form>
	</body> -->
<!-- setting schedule values--> 
<%		
		if(in_mode!=null && in_mode.equals("amend")){
			ArrayList schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			String sch_bean_id		= "OrScheduleFreq" ;
			String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
			Hashtable sch_output	=	null;
			Hashtable schedule_val	=	null;
			HashMap temp_freq_chars =	null;
		//			freq_durn_type	=  "D"; // Commented for IN18922 -- 19/02/2010 -- priya 
			 if(schedule != null && schedule.size()>0){
				temp_freq_chars = (HashMap)schedule.get(0);
				freq_durn_type	= (String)temp_freq_chars.get("durationType");
			 }

			 if(schedule.size()==0 && scheduled_yn.equals("Y") ) {
	 
				schedule_val	=	new Hashtable();
				ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request);
				schedule_bean.setLanguageId(locale);

				schedule_val.put("facility_id", (String)session.getValue("facility_id"));
				schedule_val.put("start_time_day_param", drug_start_date);
				schedule_val.put("module_id", "PH"); 
				schedule_val.put("split_dose_yn", split_dose_yn); 
				schedule_val.put("split_qty",qty_value);
				schedule_val.put("freq_code",  freq_code );
				schedule_val.put("code",drug_code+srl_no);
				sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
				sch_output.put("code",drug_code+srl_no);
				sch_output.put("row_value",srl_no);
				sch_output.put("start_date_time",drug_start_date);

				freq_durn_type	= (String)sch_output.get("durationType");

	//			bean.setScheduleFrequencyStr(sch_output);
				putObjectInBean(sch_bean_id,schedule_bean,request);
			} 
			if(sch_output!=null) {
				ArrayList values	=	presBean.getFreqDet(order_id,line_no);
				ArrayList freqCharctValues = new ArrayList();
				ArrayList day_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
						 dose_list = new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
					// date conversion done for IN22002 --11/06/2010-- priya
				week_days = bean.getDayOfWeek(com.ehis.util.DateUtils.convertDate(drug_start_date, "DMYHM",locale, "en")); 
				 freqCharctValues = (ArrayList)sch_output.get(drug_code+srl_no);	

					//	  day_list  = (ArrayList)freqCharctValues.get(1);
					//	  day_names = (ArrayList)freqCharctValues.get(2);
					//	  time_list = (ArrayList)freqCharctValues.get(3);
					//	  dose_list = (ArrayList)freqCharctValues.get(4);
							
		
				for(int p=0; p<values.size(); p+=4) {
					time_list.add(values.get(p));
					dose_list.add(values.get(p+1));
//					time_list.add(values.get(p+2));
					day_list.add((values.get(p+3)==null)?"0":values.get(p+3));
				}

				if(day_list.size()>0 && ((String)((HashMap)((ArrayList)sch_output.get(drug_code+srl_no)).get(0)).get("durationType")).equals("W")){
					for(int j=0;j<day_list.size();j++){
						if(!day_list.get(j).equals("")){
							String temp = (String)day_list.get(j);
							if (temp == null || temp.equals("")){
								temp = "0";
							}
							if (!temp.equals("0")){
								day_names.add(week_days.get((Integer.parseInt(temp))-1));
							}
						}
					}
				}

				tmp_freq_values.add(freqCharctValues.get(0));
				tmp_freq_values.add(day_list);
				tmp_freq_values.add(day_names);
				tmp_freq_values.add(time_list);
				tmp_freq_values.add(dose_list);
				sch_output.put(drug_code+srl_no,tmp_freq_values);

				for(int tqI=0;tqI<dose_list.size();tqI++){
					total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
					final_qty	=	(String)dose_list.get(tqI);
				}
				tooltiptable = (String)bean.getTooltipStringFrFreq(tmp_freq_values,"toolTip");
				adm_time = tooltiptable;
				split_chk	=	bean.checkSplit(tmp_freq_values);	
				if(split_chk){
					final_qty		=	String.valueOf(total_qty);
				}
		/*		int incr=0;
				for(int p=0; p<values.size(); p+=4) {
					incr++;
					sch_output.put("time"+(incr),values.get(p));
					sch_output.put("qty"+(incr),values.get(p+1));				
					sch_output.put("admin_day"+(incr+1),values.get(p+3));
				}
				if(incr<=6) {
					for(int q=(incr+1); q<=6; q++) {
						sch_output.put("time"+(q),"");
						sch_output.put("qty"+(q),"");
					}
				}*/
				bean.setScheduleFrequencyStr(sch_output);
				schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
			}

			if(tooltiptable.equals("") && schedule.size()>0){
				if(schedule.size()>0){
					dose_list = (ArrayList)schedule.get(4);
				}
				for(int tqI=0;tqI<dose_list.size();tqI++){
					total_qty=total_qty+Float.parseFloat((String)dose_list.get(tqI));
					final_qty	=	(String)dose_list.get(tqI);
				}

				tooltiptable = (String)bean.getTooltipStringFrFreq(schedule,"toolTip");
				adm_time = tooltiptable;

				split_chk	=	bean.checkSplit(schedule);	
				if(split_chk){
					final_qty		=	String.valueOf(total_qty);
				}
			}
		}
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(presBean_id,presBean,request);
 %>
<!-- setting schedule values ends-->
		<input type="hidden" value="<%=freq_durn_type%>" name="freq_durn_type" id="freq_durn_type">	
			<!--  added for CRF RUT-CRF-0063[29601]--start -->
		<input type="hidden" name="pregnency_yn" id="pregnency_yn" value="<%=pregnency_yn%>">
		<input type="hidden" value="<%=preg_effect%>" name="preg_effect" id="preg_effect">
		<input type="hidden" value="<%=pregnency_cat%>" name="pregnency_cat" id="pregnency_cat" >
		<input type="hidden" value="<%=pregnency_cat_desc%>" name="pregnency_cat_desc" id="pregnency_cat_desc" >
		<input type="hidden" value="<%=preg_remarks%>" name="preg_remarks" id="preg_remarks" >
        <input type="hidden" value="<%=preg_category_code%>" name="preg_category_code" id="preg_category_code">
		<input type="hidden" value="<%=drug_desc%>" name="drug_desc" id="drug_desc" >
		<input type="hidden" value="<%=preg_warn_req_yn%>" name="preg_warn_req_yn" id="preg_warn_req_yn" >
		<input type="hidden" value="<%=bean.getPregTrimester()%>" name="trimester" id="trimester" >
		<input type="hidden" value="<%=all_durn_type_app%>" name="all_durn_type_app"  id="all_durn_type_app" > <!-- ML-MMOH-CRF-1531-->
		<input type="hidden" value="" name="def_durn_type" id="def_durn_type" ><!-- ML-MMOH-CRF-1531-->
		 <input type="hidden" value="<%=validate_overide_on_confirm_yn%>" name="validate_overide_on_confirm_yn" id="validate_overide_on_confirm_yn"><!-- Added for IN:069887  -->
		<!--added for aakh-crf-0140 start-->
		<input type="hidden" value="<%=abuse_override%>" name="ABUSE_OVERRIDE" id="ABUSE_OVERRIDE">
			<input type="hidden" value="<%=abuse_exists%>" name="abuse_exists" id="abuse_exists">
			<input type="hidden" value="<%=abuse_action%>" name="abuse_action" id="abuse_action">
			<input type="hidden" value="<%=abuse_drug_override_reason%>" name="abuse_drug_override_reason" id="abuse_drug_override_reason">
		   <input type="hidden" value="<%=abuse_drug_override_reason%>" name="abuse_override_remarks" id="abuse_override_remarks">
		<!-- added for aakh-crf-0140 end -->
			<!--  added for CRF RUT-CRF-0063[29601]--end -->
		</form>
	</body>
</html>
<script> 
		assignDurnTypeList('<%=DurnDescDetails%>'); 
		if(('<%=freq_nature%>' != 'O') && ('<%=freq_nature%>' !='P')){
			makeScheduleLink('<%=adm_time%>','<%=adm_qty%>','<%=final_qty%>','<%=tmp_freq_values.size()%>','<%=split_chk%>','onLoad');
		}
	// if freq_nature = 'O' and  if freq_nature = 'P'  code moved from here to below to make durn_desc disabled for PRN and Stat orders on reloading the drug --- 19/07/2010-- priya --while fixing IN22686
<% 
		if( in_mode!=null && in_mode.equals("amend") ) { 
%>
			maxDurnValidation();
			getFormatIdAmend();
<%
			if(!dosage_type.equals("S")) {	
%>
				populateQtyDesc('<%=form_code%>','<%=qty_desc_code%>');
<%			
			} 
%>	
			reloadDurnTypeList(); //commented for IN20397 --30-03-2010-- priya //uncommented for reloading durntypelist ---08/07/2010-- priya
			if('<%=freq_nature%>'=='O'){
				/*document.prescription_amend_detail_form.in_durn_desc.value="";
				document.prescription_amend_detail_form.in_durn_value.value="";*/
				document.prescription_amend_detail_form.durn_desc.value="D";
				document.prescription_amend_detail_form.durn_value.value="1";
				document.prescription_amend_detail_form.durn_value.disabled=true;
				document.prescription_amend_detail_form.durn_desc.disabled=true;
				/*document.prescription_amend_detail_form.calcualted_durn_value.value="1";
				document.prescription_amend_detail_form.allow_refill.disabled=true;
				document.prescription_amend_detail_form.no_refill.value="";
				document.prescription_amend_detail_form.refill_start_date.value="";
				document.prescription_amend_detail_form.refill_end_date.value="";*/
			}
			if(document.prescription_amend_detail_form.freq_nature.value=="P"){
				document.prescription_amend_detail_form.durn_desc.value="D"; //added for IN20397 --30-03-2010-- priya
				document.prescription_amend_detail_form.durn_desc.disabled=true;  //added for IN20397 --30-03-2010-- priya
				document.getElementById("prn_remarks").style.visibility	= "visible";
				//document.getElementById("prn_remarks_image").style.visibility	= "visible";
				if(document.prescription_amend_detail_form.man_rem_on_prn_freq_yn.value == 'Y'){
					document.getElementById("prn_remarks_image").style.visibility	= "visible";
				}
				else{
					document.getElementById("prn_remarks_image").style.visibility	= "hidden";
				}
				document.getElementById("dis_split_dose").style.visibility	= "hidden";
			}
<%
			if(durn_type.equals(repeat_durn_type)){
%>
				dfltDurnDesc('<%=repeat_durn_type%>');
<%
			}
			else if(!durn_type.equals(repeat_durn_type)){
%>
				dfltDurnDesc('<%=durn_type%>');
<%
			}
%>
			populateAmendEndDate();
			checkWtAndHt(document.prescription_amend_detail_form);
			//lookForChange(document.prescription_amend_detail_form.qty_value)
			setPrevFreqNature('<%=freq_nature%>');
<%	
			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
				getChargeDetails('<%=in_formulary_yn%>','ON_LOAD','<%=bl_override_excl_incl_ind%>');
<%
			}
		}
		if(!freq_status.equals("")){//Added for ML-BRU-SCF-0725 [IN:038336] to avoid amending the Administered drugs
%>
			parent.f_button.document.prescription_button.modify_drug.disabled=true;
<%
		}
		if(scheduled_yn.equals("N")){//added for ML-BRu-SCF-1887 %>
			if(document.prescription_amend_detail_form.split_dose!=undefined)
			document.prescription_amend_detail_form.split_dose.disabled=true;
<%		}
		//Below code added for IN25596 reopen --24/12/2010-- priya
%>
		if(document.prescription_amend_detail_form.qty_value.value!=""){
			document.prescription_amend_detail_form.qty_value.value =Math.abs(document.prescription_amend_detail_form.qty_value.value);
		}
		</script>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
finally{//added for ml-bru-crf-0469
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);

}
%>

