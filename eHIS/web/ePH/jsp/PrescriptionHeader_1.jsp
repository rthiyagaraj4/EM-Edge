<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,java.math.*,eCommon.XSSRequestWrapper" %> <!-- java.math.* Added for ML-MMOH-CRF-1004 -->
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
08/11/2019  IN070606                Manickavasagam J                         MMS-KH-CRF-0029[IN070606]
12/2/2020	6041					Shazana       										NMC-JD-CRF-0063	
23/12/2020	11525					Shazana												NMC-JD-CRF-0063
05/01/2021	 TFS id:7345            Haribabu	      04/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
3/1/2021	15131					Shazana												NMC-JD-CRF-0063	
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
03/10/2023	  	50818  			    Himanshu 						GHL-SCF-1738 					GHL-SCF-1738 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
		<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="JavaScript" src="../../ePH/js/PregnancyCategory.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- Added for INC#70594 -->
		
	</head>
<%
	try{
	String licence=(String)(PhLicenceRights.getKey());
	String version_no="";
	version_no= (String) PhVersionNo.getVersion();
	String function_id= request.getParameter("function_id")==null?"":request.getParameter("function_id");
	String MAR = "";
	if(function_id.equals("MEDICATION_ADMIN")){
		String MAR_bean_id	= "MedicationAdministrationFTBean";
		String MAR_bean_name= "ePH.MedicationAdministrationFTBean";
		MedicationAdministrationFTBean MARBeanObj	= (MedicationAdministrationFTBean)getBeanObject( MAR_bean_id, MAR_bean_name , request);
		MAR=MARBeanObj.getFunctionT();
	}
	String facility_id		= (String) session.getValue("facility_id");
	String iv_prep_default		= request.getParameter("iv_prep_default");
	String function_from        = request.getParameter("function_from")==null?"":request.getParameter("function_from"); //added for JD-CRF-198 
	String order_id = request.getParameter("order_id")==null?"":request.getParameter("order_id"); //added for JD-CRF-198 
	if(iv_prep_default == null)  
		iv_prep_default="";
	String order_set_code		= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_class	= request.getParameter("patient_class");
  //Added for ML-MMOH-SCF-0362 To get ouptatiend set up for deycare patient
	String new_patient_class="";
	String act_patient_class= request.getParameter("patient_class");
	String bed_num	= request.getParameter("bed_num")==null?"":request.getParameter("bed_num");
	String room_num= request.getParameter("room_num")==null?"":request.getParameter("room_num");
	String episode_id= request.getParameter("episode_id")==null?"":request.getParameter("episode_id"); //added for HSA-CRF-0152 [IN:048469]
	String ammend_called_from= request.getParameter("ammend_called_from")==null?"":request.getParameter("ammend_called_from");//added for  JD-CRF-0198 [IN:058599]

	String visit_adm_date= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date"); //added for HSA-CRF-0152 [IN:048469]
	/*if(encounter_id.equals("null"))
		encounter_id="";*/
	if(encounter_id.equals("") || encounter_id.equals("null")){
		act_patient_class = "XT";
		patient_class= "XT"; // added for IN21446 - 18/05/2010 - priya
	}
	if(patient_class.trim().equals("DC")) 
		patient_class="IP";
	if(patient_class.trim().equals("EM")) 
		patient_class="OP";

	String location_type	= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	if(location_type.equals("E"))//added for ML-BRU-SCF-1313 [IN:048840] for Precudural Unit Patients
		location_type ="C";
	String location_code	= request.getParameter("location_code");
	String ph_default_tab	= request.getParameter("ph_default_tab");
	//intake parameters end
	//declaration
	String leg_value_1				= "";
	String leg_uom_1				= "";
	String leg_value_2				= "";
	String leg_uom_2				= "";
	float bsa						= 0f;
	String bsa_str					= "";
	String visit_date				= "";
	String sys_date					= "";
	String calculated_date			= "";
	String order_type_code_yn		= "";
	String take_medication_yn_chk	= "";
	String take_medication_yn_dis	= "";
	String take_medication_yn_val	= "";
	//adding start for Bru-HIMS-CRF-093 [IN:029960]
	String home_leave_yn_val	= "";
	String home_leave_disp	= "";
	int homeleave_rec				= 0;
	int homeleave_chk				= 0;
	//adding end for Bru-HIMS-CRF-093 [IN:029960]
	int medication_rec				= 0;
	String pract_id					= "";
	String resp_id					= "";
	String pract_reln_id			= "";
	String pract_name				= "";
	String attend_pract_id			= "";
	String order_remarks			= "";
	String or_bean_id				= "";
	String man_rem_on_prn_freq_yn	= "";
	boolean MItemsOnly				= false;
	String narcotic_aprvl_form_req_yn	    = "";
	String print_narcotic_form_by_default	= "";
	String rx_qty_by_pres_base_uom_yn	    = "";
	String back_date				= "";
	String future_date				= "";
	String servide_code				= "";
	String service_search_yn		= "N";
	String allow_without_wt			=	"";
	String allow_without_diag		=	"";
	String patient_age				=	"";
	String date_of_birth			=	"";
	String gender				    =	"";
	String patient_name             =   ""; // Added for MMS-KH-CRF-0016
	String atc_allergy_alert_level   =	"N";
	String drug_interaction_check_yn   =	"N";
	String dispPrescripionDuration   =	"", prescripionDurationDisplay="visibility:hidden"; //Added for BRU-HIMS-CRF-403 [IN:044541]
	String pract_type   =	""; //added for ML-BRU-SCF-0958 [IN:042045]
	String generic_id="";//added for  JD-CRF-0198 [IN:058599]
	String alternateOrder="N";//added for  JD-CRF-0198 [IN:058599]
	String currentStage="";//added for  JD-CRF-0198 [IN:058599]
	String take_home_medication_op    = "";//added for NMC-JD-CRF-0063
	String take_home_medication_ip = "N";//added for NMC-JD-CRF-0063
	String take_home_medication_ckk_val ="N";//added for NMC-JD-CRF-0063
	//end
	//getting the reqd values from OR bean
	String or_bean_name				= "eOR.OrderEntryBean";
	or_bean_id						= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
	orbean.setLanguageId(locale);

	resp_id							= (String) orbean.getResponsibilityId();
	pract_id						= (String) orbean.getPractitionerId();
	pract_type						= (String) orbean.getPractitionerType(); //added for ML-BRU-SCF-0958 [IN:042045]
	pract_name						= (String) orbean.getPractitionerName();
	attend_pract_id					= (String) orbean.getAttendPractitionerId();
	String login_user_prac_id		= (String)orbean.getLoginPractId();	// Added for AAKH-CRF-0023[IN:038259]
	servide_code					= (String) orbean.getServiceCode();
	service_search_yn				= (String) orbean.getRestrictYn();
	pract_reln_id				= (String) orbean.getRelationshipId();
	ArrayList OrderIDArr			=	orbean.getCopyOrderDetails();
	ArrayList exist_orders			=	new ArrayList();
	
	String record[]= new String[10];
	if(OrderIDArr!=null){
		for(int i=0;i<OrderIDArr.size(); i++) {
			record	=	((String[])OrderIDArr.get(i));
			exist_orders.add(record[0]);
			exist_orders.add(record[1]);
			exist_orders.add(record[2]);
		}
	}
	//getting the reqd values from PH bean
	String mode					= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	String bean_id				= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name			= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id, bean_name, request );
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
	presBean.setLanguageId(locale);
	String reconciliation_done_yn=CommonBean.checkForNull((String)bean.reconciliationDoneyn(patient_id,encounter_id));//added for IN070786
	boolean default_dose_type_yn = presBean.isSiteSpecific("OR", "OR_ORDER_SET"); // Added for ML-MMOH-CRF-1004
	boolean op_take_home_medication = presBean.isSiteSpecific("PH", "OP_TAKE_HOME_MEDICATION");//Added for NMC-JD-CRF-0063
	boolean allergy_conf_reqd_yn=false;//added for RUT-CRF-0064.1 [IN:041799] -Start
	boolean disc_cancel_flag =presBean.isSiteSpecific("PH","DISCONTINUE_CANCEL_YN");//added for ML-BRU-SCF-2080
	bean.defaultDispLocnSelectAppl(); //Added for TFS-16341-Start
	if(function_from.equals("ALTERNATE_ORDER")){//added for  JD-CRF-0198 [IN:058599]
		bean.setAmend_alternate_yn("Y");
		String	bean_id_1					=	"DispMedicationBean" ;
		String	bean_name_1					=	"ePH.DispMedicationBean";
		DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
		alternateOrder = "Y";
		
		currentStage=bean_1.getDispStatusType(bean_1.getOrStatus_1());
		bean.setAlterAmendReason(bean_1.getAlternateAmendReason());
		take_medication_yn_dis	= "disabled";
	}//added for  JD-CRF-0198 [IN:058599]
	bean.setEncounterId(encounter_id); //MMS-KH-CRF-0029[IN070606]
	if(!encounter_id.equals(""))
		allergy_conf_reqd_yn = bean.getAllergyConfDtls(patient_id, encounter_id); //added for RUT-CRF-0064.1 [IN:041799] -End

	String NBPRequestApplYN = presBean.getNBPRequestAppl(resp_id, pract_reln_id, encounter_id, patient_id);
	String excludeADRAllergyAlert_yn = bean.getExcludeADRAllergyAlert();//Added for HSA-SCF-0011 [IN:042444]
	bean.setLanguageId(locale);
	bean.setActPatientClass_frm_Hdr(act_patient_class); //added while fixing  IN26267 --02/02/2011-- priya (to calc charge details of copied drugs from prev order)
	bean.setPreAllocApplYN();//Added for TFS id:7345
	if(exist_orders.size() > 0 ) {
		bean.setExitingOrders(exist_orders);
	}
    int adr_count =(int)bean.getADRCount(patient_id,"%");
	bean.setStockInstalledYN();//added for performance; ML-MMOH-SCF-00684
	//getting the External Drug Interface Controls 
	String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
// pregnancy Category Bean

    String pregn_bean_id = "PregnancyCategory" ;
	String pregn_bean_name = "ePH.PregnancyCategoryBean";
	PregnancyCategoryBean pregn_bean = (PregnancyCategoryBean)getBeanObject( pregn_bean_id, pregn_bean_name, request ) ;

	/*String drug_bean_id = "@DrugSearchBean"+patient_id+encounter_id;
	String drug_bean_name = "ePH.DrugSearchBean";
	DrugSearchBean drug_bean = (DrugSearchBean)getBeanObject( drug_bean_id, drug_bean_name, request ) ;
    drug_bean.setPractitionerId(pract_id);
    */
	String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
	String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);    
	String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
	String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
	String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
	String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
	String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);   
	String overlap_period_for_op        =   param_bean.getOverlapPeriodForOP(facility_id);//CRF-20085.1
	String overlap_period_for_ip        =   param_bean.getOverlapPeriodForIP(facility_id);//CRF-20085.1

	bean.setOverlapPeriodForOP(overlap_period_for_op);//CRF-20085.1
	bean.setOverlapPeriodForIP(overlap_period_for_ip);//CRF-20085.1

	param_bean.clear();
				
	String regimen_yn				=  "N";
	String tpn_yn					=  "N";
	String indicator_desc			=  "";
	String problem_ind				=  "";
	String rec_date					=  "";
	String bmi_str					=  "";
	String allergyvisiblity			=  "visibility:hidden";
	String allergic_yn				=  "N";
	String height_min_value			= "";
	String height_max_value			= "";
	String weight_min_value			= "";
	String weight_max_value			= "";
	String height_min_digits		= "";
	String height_max_digits		= "";
	String height_dec_digits		= "";
	String weight_dec_digits		= "";
	String weight_min_digits		= "";
	String weight_max_digits		= "";
	String comp_rx_appl_yn			= "N";
	String iv_rx_appl_yn			= "N";
	String oncology_rx_appl_yn		= "N";
	String tpn_rx_appl_yn			= "N";
	String tdm_appl_yn				= "N";	
	String bl_disp_charge_dtl_in_rx_yn		= "";
	String disp_charge_dtl_in_drug_lkp_yn	= "";
	String disp_price_type_in_drug_lkp	= "";
	String dc_mar_appl_yn				= "";
	String em_mar_appl_yn				= "";
	String ip_mar_appl_yn				= "";
	String op_mar_appl_yn				= "";
	String disch_med_mar_appl_yn		= "";
	String split_based_priority_yn		= "";
	String split_based_drug_class_yn	= "";
	String split_drug_based_auth_yn    ="";//added for ml-mmoh-crf-0864
	String max_durn_for_ip_pres			= "";
	String chk_for_ip_max_durn_action	= "";
	String max_durn_for_op_pres			= "";
	String chk_for_op_max_durn_action	= "";
	String max_durn_for_dm_pres			= "";
	String chk_for_dm_max_durn_action	= "";
	String trade_display_yn				= "";
	String max_length_prn_reason		= "";	
	String bl_install_yn				= (String) session.getValue( "bl_operational" )==null?"N":(String) session.getValue( "bl_operational" ) ;
	String leave_fm                     ="";
	String leave_to                     ="", print_mar_label_yn="";
	String witness_for_verbal_order_yn	= ""; 	// Added for AAKH-CRF-0023[IN:038259]
	String diag_for_medn_order_by="P"; //MMS-SCF-0325 [IN:048069]
	HashMap temp = new HashMap();
        String tempstartString = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String tempendString  = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String tempsysString  = "";//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	String called_from_verbal_order =bean.getCalled_from_verbal_order(); //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
	String default_prev_drug_sel ="", allow_priv_to_order_yn=""; //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
	String preview_rx_yn ="";//added for ML-MMOH-CRF-0341 [IN:057179]
	String disp_prev_vital_signs_yn ="N";//Added for ML-MMOH-CRF-0346 [I<I></I>N:057185]
	LinkedHashMap hmPrev_vital_signs = null;//Added for ML-MMOH-CRF-0346 [IN:057185]
	int index = 0;
	String reconciliation_yn="N";//added for mms-kh-crf-0016
	String reconciliation_req_yn="N";//added for mms-kh-crf-0016
	String reconciliation_req_yn_button="N";//ADDEDE FOR IN070786
	int prev_drug_count=0;//added for mms-kh-crf-0016
	String drug_indication_mdry="";//added for jd-crf-0220
	//code added during PE By Naveen
    bean.getProfileCount(patient_id);
	if(bl_install_yn.equals("Y")){
         bean.setBLDecimalFormatString(presBean.getDecimalFormatString());
	}

	HashMap discr_values	=	presBean.getHgtWgtDtls(patient_id);
	if(discr_values.containsKey("HEIGHT_MIN_VALUE")) {	
		height_min_value	=	(String)discr_values.get("HEIGHT_MIN_VALUE");
		height_max_value	=	(String)discr_values.get("HEIGHT_MAX_VALUE");
		height_min_digits	=	(String)discr_values.get("HEIGHT_MIN_DIGITS");
		height_max_digits	=	(String)discr_values.get("HEIGHT_MAX_DIGITS");
		height_dec_digits	=	(String)discr_values.get("HEIGHT_DEC_DIGITS");
	}
	if(discr_values.containsKey("WEIGHT_MIN_VALUE")) {	
		weight_min_value	=	(String)discr_values.get("WEIGHT_MIN_VALUE");
		weight_max_value	=	(String)discr_values.get("WEIGHT_MAX_VALUE");
		weight_min_digits	=	(String)discr_values.get("WEIGHT_MIN_DIGITS");
		weight_max_digits	=	(String)discr_values.get("WEIGHT_MAX_DIGITS");
		weight_dec_digits	=	(String)discr_values.get("WEIGHT_DEC_DIGITS");
	}

	HashMap appl_orders	=	bean.getApplicableOrders(facility_id);

	if(appl_orders != null){
		comp_rx_appl_yn		=	(String)appl_orders.get("COMP_RX_APPL_YN")==null?"N":(String)appl_orders.get("COMP_RX_APPL_YN");
		iv_rx_appl_yn		=	(String)appl_orders.get("IV_RX_APPL_YN")==null?"N":(String)appl_orders.get("IV_RX_APPL_YN");
		oncology_rx_appl_yn	=	(String)appl_orders.get("ONCOLOGY_RX_APPL_YN")==null?"N":(String)appl_orders.get("ONCOLOGY_RX_APPL_YN");
		tpn_rx_appl_yn		=	(String)appl_orders.get("TPN_RX_APPL_YN")==null?"N":(String)appl_orders.get("TPN_RX_APPL_YN");
		tdm_appl_yn			=	(String)appl_orders.get("TDM_APPL_YN")==null?"N":(String)appl_orders.get("TDM_APPL_YN");
		man_rem_on_prn_freq_yn =(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN")==null?"N":(String)appl_orders.get("MANDATORY_REM_ON_PRN_FREQ_YN"); 
	}
	//added for JD-CRF-198 - start
		if(function_from.equals("ALTERNATE_ORDER")){
		comp_rx_appl_yn = "";
		iv_rx_appl_yn = "";
		oncology_rx_appl_yn = "";
		tpn_rx_appl_yn="";
		tdm_appl_yn="";
		bean.setParentOrderIdForAltOrder(order_id);
		}
	//added for JD-CRF-198 - end
	int num = bean.loadallergydetail(patient_id);
	  //num=1;
	if(num>0){
		allergyvisiblity="visibility:visible";
		allergic_yn = "Y";
	}
	if(version_no.equals("3")){
		String oncology_bean_id				= "@OncologyRegimenBean"+patient_id+encounter_id;
		String oncology_bean_name			= "ePH.OncologyRegimenBean";
		OncologyRegimenBean oncology_bean	= (OncologyRegimenBean)getBeanObject( oncology_bean_id, oncology_bean_name, request );
		oncology_bean.setLanguageId(locale);

		HashMap	regimenValues				= (HashMap)oncology_bean.getRegimenValues(servide_code);
		if(regimenValues!=null){
			 regimen_yn						=	(String)regimenValues.get("regimen_yn");
			 tpn_yn							=	(String)regimenValues.get("tpn_yn");
			 indicator_desc					=	(String)regimenValues.get("indicator_desc");
			 problem_ind					=	(String)regimenValues.get("problem_ind");
			
			 if(regimen_yn==null) regimen_yn  = "N";
			 if(tpn_yn==null) tpn_yn  	= "N";
			 if(indicator_desc==null) indicator_desc  = "";
		}
		putObjectInBean(oncology_bean_id,oncology_bean,request);
	}
	//getting the height/uom and weight/uom values from prescription bean:
	HashMap HeaderHtWtValues		=(HashMap) presBean.loadHeaderHtWtValues(facility_id,patient_id,encounter_id,act_patient_class);
	if( HeaderHtWtValues.size()>1 ){
		 if(HeaderHtWtValues.containsKey("HEIGHT")){
			leg_value_1		= (String) HeaderHtWtValues.get("HEIGHT");
			leg_uom_1		= (String) HeaderHtWtValues.get("HEIGHT_UOM");
			rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");	
		 }
		if(HeaderHtWtValues.containsKey("WEIGHT")){
			leg_value_2		= (String) HeaderHtWtValues.get("WEIGHT");
			leg_uom_2		= (String) HeaderHtWtValues.get("WEIGHT_UOM");
			rec_date		= (String) HeaderHtWtValues.get("OBSERV_DT");	
		 }
		
		bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
		/* if(leg_uom_1==null) 
			leg_uom_1= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Cms.label", "ph_labels");
		if(leg_uom_2==null) 
			leg_uom_2=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Kgs.label", "common_labels");
		 */
		 bsa_str			= (String.valueOf(bsa));
		
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)>0 && !leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)>0  ) {
			bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
			index	=	bmi_str.indexOf(".");
			if(bmi_str.length()>=(index+3) ) {
				bmi_str	=(bmi_str.substring(0,index+3));
			}
		}
		if(bsa_str.equals("0.0")) 
			bsa_str= "";
		if(bmi_str.equals("0.0")) 
			bmi_str= "";
	}
	else

	{
	HashMap discr_values_default	=	presBean.getHgtWgtDtlsDefault(patient_id);
    System.out.println("discr_values_default"+discr_values_default);
if(discr_values_default.containsKey("HEIGHT")) {	
	leg_uom_1	=	(String)discr_values_default.get("HEIGHT");

}
if(discr_values_default.containsKey("WEIGHT")) {	
	leg_uom_2	=	(String)discr_values_default.get("WEIGHT");
	
}
}
	double enc_id=0;	
	if(!patient_class.equals("XT")){
		enc_id=Double.parseDouble(encounter_id);
		visit_date		=	presBean.getVisitDate(enc_id,facility_id);
	}
	ArrayList param_vals	=	bean.getParameterValues();
	System.err.println(param_vals);
	if(param_vals!=null && param_vals.size()!=0) {
		int iCount=0;
		allow_without_diag				=	(String)param_vals.get(iCount++); //0
		allow_without_wt				=	(String)param_vals.get(iCount++);
		bl_disp_charge_dtl_in_rx_yn		=	(String)param_vals.get(iCount++);
		disp_charge_dtl_in_drug_lkp_yn	=	(String)param_vals.get(iCount++);
		disp_price_type_in_drug_lkp		=	(String)param_vals.get(iCount++);
		dc_mar_appl_yn					=	(String)param_vals.get(iCount++);
		em_mar_appl_yn					=	(String)param_vals.get(iCount++);
		ip_mar_appl_yn					=	(String)param_vals.get(iCount++);
		op_mar_appl_yn					=	(String)param_vals.get(iCount++);
		disch_med_mar_appl_yn			=	(String)param_vals.get(iCount++);
		split_based_priority_yn			=	(String)param_vals.get(iCount++);//10
		split_based_drug_class_yn		=	(String)param_vals.get(iCount++);
		narcotic_aprvl_form_req_yn		=	(String)param_vals.get(iCount++);
		print_narcotic_form_by_default	=	(String)param_vals.get(iCount++);
		rx_qty_by_pres_base_uom_yn		=	(String)param_vals.get(iCount++);
		atc_allergy_alert_level			=   (String)param_vals.get(iCount++);//15
		iCount++; //added for added for CRF MMS-QH-CRF-0068 [IN:037980] (allow_without_diag_dd)//16
		print_mar_label_yn			=   (String)param_vals.get(iCount++); //Added for MMS-QH-CRF-0080 [IN:038064] //17
		iCount++; // added for  MMS-QH-CRF-0080 [IN:038064] //18
		dispPrescripionDuration	=	(String)param_vals.get(iCount++);//19
		diag_for_medn_order_by=(String)param_vals.get(iCount++);//20 //MMS-SCF-0325 [IN:048069]
		default_prev_drug_sel			=   (String)param_vals.get(iCount++); //21 //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		preview_rx_yn					=	(String)param_vals.get(iCount++);//22//added for ML-MMOH-CRF-0341 [IN:057179]
		disp_prev_vital_signs_yn	=	(String)param_vals.get(iCount++);//23 //Added for ML-MMOH-CRF-0346 [IN:057185]
		//drug_indication_mdry=(String)param_vals.get(iCount++);//added for jd-crf-0220 commented for amend
		drug_indication_mdry=bean.getDrugIndicationMdry();//added for jd-crf-0220
				System.out.println("drug_indication_mdry prescriptionheader_1"+drug_indication_mdry);
		max_length_prn_reason			=   (String)param_vals.get(iCount++); //24
		max_durn_for_ip_pres		=	(String)param_vals.get(iCount++); //25
		chk_for_ip_max_durn_action	=	(String)param_vals.get(iCount++);//26
		max_durn_for_op_pres		=	(String)param_vals.get(iCount++);//27
		chk_for_op_max_durn_action	=	(String)param_vals.get(iCount++); //28
		max_durn_for_dm_pres		=	(String)param_vals.get(iCount++);
		chk_for_dm_max_durn_action	=	(String)param_vals.get(iCount++);
		trade_display_yn			=	(String)param_vals.get(iCount++);
		drug_interaction_check_yn	=	(String)param_vals.get(iCount++);//32
		iCount++;//added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		allow_priv_to_order_yn	=	(String)param_vals.get(iCount++);//34 //added for PMG2012-CRF-0019 [IN:035859] AutoComplete
		split_drug_based_auth_yn        =(String)param_vals.get(iCount++);//35//added for ml-mmoh-crf-0864
		reconciliation_yn=(String)param_vals.get(iCount++);//36 added for mms-kh-crf-0016
				
	} 
	witness_for_verbal_order_yn = bean.getWitnessForVerbalOrder();		// Added for AAKH-CRF-0023[IN:038259]
	order_remarks	= (String)bean.getPresRemarks();
	if("Y".equals(disp_prev_vital_signs_yn) && !("XT".equals(act_patient_class)))//added for ML-MMOH-CRF-0346 [IN:057185]
		hmPrev_vital_signs	=(LinkedHashMap) presBean.loadPrevHtWtValues(facility_id, patient_id,encounter_id, act_patient_class);
	else 
		disp_prev_vital_signs_yn="N";

	HashMap patient_details	=	bean.getPatientDetails_1(patient_id);
	if(patient_details!=null && patient_details.size()!=0) {
		patient_age	=	(String)patient_details.get("age");
		date_of_birth	=	(String)patient_details.get("date_of_birth");
		gender	=	(String)patient_details.get("sex");
		gender	=	gender.substring(0,1).toUpperCase();
		patient_name = CommonBean.checkForNull((String)patient_details.get("patient_name")); // Added for MMS-KH-CRF-0016
	}
	//check for recorded diagnosis
	ArrayList diagnosis	=	bean.checkDiagnosis(patient_id, encounter_id, diag_for_medn_order_by);
	int diag_size	=	(diagnosis).size();

	//getting system date
	//sys_date=(String) DateUtils.getCurrentDate("DMYHM",locale); //Commented for IN031192 - Leap year_CA_Pharmacy order_Thai login
	sys_date=(String) presBean.getSysdate();  //Added for IN031192 - Leap year_CA_Pharmacy order_Thai login
	String pregnency_yn				=presBean.getPregnencyYN(patient_id);//added for CRF RUT-CRF-0063[29601]--start
	String lmp_date                 =presBean.getLMPDate(patient_id);
	double preg_week                =Math.ceil(presBean.getCalPregStage(sys_date,lmp_date));
	String trimester                =presBean.getTrimster(preg_week);
	bean.setPregnencyYN(pregnency_yn);
	bean.setPregTrimester(trimester);//added for CRF RUT-CRF-0063[29601] --end
	bean.setCalledFrom("");
	//getting back date of order date/time
	HashMap BackDates=(HashMap) presBean.getBackDate(sys_date);
	if(BackDates.size()>0){
		back_date			= (String) BackDates.get("BACK_DATE");
		future_date			= (String) BackDates.get("FUTURE_DATE");
	}
	//Added for IN031192 - Leap year_CA_Pharmacy order_Thai login -Start
	if(!locale.equals("en")){
		sys_date =	com.ehis.util.DateUtils.convertDate(sys_date,"DMYHM","en",locale);
		back_date			= com.ehis.util.DateUtils.convertDate(back_date,"DMYHM","en",locale);
		future_date			= com.ehis.util.DateUtils.convertDate(future_date,"DMYHM","en",locale);
	}
	//Added for IN031192 - Leap year_CA_Pharmacy order_Thai login -End
	bean.setOrderDate(sys_date); //Moved from above for IN031192 - Leap year_CA_Pharmacy order_Thai login
	//adding start for Bru-HIMS-CRF-093 [IN:029960]
	HashMap homeleave_vals	=	presBean.getHomeLeaveDates(encounter_id,facility_id);
	ArrayList takeHomeDates = new ArrayList();//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	if(homeleave_vals!=null && homeleave_vals.size()>0){
		leave_fm = (String)homeleave_vals.get("LEAVE_FR_DATE");
		leave_to = (String)homeleave_vals.get("LEAVE_TO_DATE");
		tempstartString  = leave_fm.substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		tempendString  = leave_to.substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		tempsysString = (String) presBean.getSysdate().substring(0, 10);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		takeHomeDates.add(leave_fm);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		takeHomeDates.add(leave_to);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
		bean.setTakeHomeDates(takeHomeDates);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
	}
	homeleave_chk = presBean.getHomeLeaveCHK(tempsysString,tempstartString,tempendString);//adding end for Bru-HIMS-CRF-093 [IN:029960]//Modified for Bru-HIMS-CRF-093-DD1[IN047223]
	bean.setPatient_class_tkHome(patient_class);//added for NMC-JD-CRF-0063
	//validation for Home Medication
	if(patient_class!=null && patient_class.equals("OP")){
		take_medication_yn_chk	= "";
		take_medication_yn_dis	= "disabled";
		take_medication_yn_val	= "N";
		if(op_take_home_medication){//added for NMC-JD-CRF-0063 START
			take_home_medication_op = "Y";
			take_medication_yn_dis	= "";	
		}else{
			take_home_medication_op = "N";
		}
		bean.setTakeHomeMedicationOp(take_home_medication_op);
		//System.out.println("bean.getTake_home_medication_op() : "+bean.getTake_home_medication_op());//COMMENT FOR NMC-JD-CRF-0063
	}
	else{
		if(!patient_class.equals("XT")){			
			medication_rec=(int)bean.getHomeMecdicationYn(encounter_id,facility_id);
		//added for mms-kh-crf-0016 start
			if(reconciliation_yn.equals("Y") && act_patient_class.equals("IP")){
				prev_drug_count=bean.getPreviousdrugData(facility_id,act_patient_class,bed_num,room_num,patient_id,encounter_id,location_type,location_code,medication_rec,patient_class);
					reconciliation_req_yn_button="Y";//added for IN070786
				if(prev_drug_count==0)reconciliation_req_yn="Y";
				else reconciliation_req_yn="N";
			}
			else{
				reconciliation_req_yn="N";
			}
			//added for mms-kh-crf-0016 end
		}
		
		if(patient_class.equals("") || patient_class==null){//NMC-JD-CRF-0063[15131] 
			patient_class = bean.getPrEncounterPatientClass(patient_id, encounter_id); 
				if ( patient_class != null && ( patient_class.equals("O") || patient_class.equals("E") ) ) {
					take_medication_yn_chk = "";
					take_medication_yn_dis = "disabled";
					take_medication_yn_val = "N";
					if (op_take_home_medication) {//added for NMC-JD-CRF-0063 START
						take_home_medication_op = "Y";
						take_medication_yn_dis = "";
					} else {
						take_home_medication_op = "N";
					}
					bean.setTakeHomeMedicationOp(take_home_medication_op);
				}
				if(patient_class.equals("O"))//NMC-JD-CRF-0063[13355]
					patient_class="OP";//end
			}//END
		
		//System.err.println("reconciliation_req_yn in header"+reconciliation_req_yn);
		bean.setReconciliation_yn(reconciliation_req_yn_button);//MODIFIED FROM reconciliation_req_yn  TO reconciliation_req_yn_button TO IN070786
		if(medication_rec>0){
			take_medication_yn_chk	= "checked";
			take_medication_yn_dis	= "";
			take_medication_yn_val	= "Y";
			patient_class="OP";
		}
		else{
			take_medication_yn_chk	= "";
			take_medication_yn_dis	= "";
			take_medication_yn_val	= "N";
		}
	}
	if(patient_class.equals("IP")){			//adding start for Bru-HIMS-CRF-093 [IN:029960]
		homeleave_rec=(int)presBean.getHomeLeaveYn(encounter_id,facility_id);
	}
	if(homeleave_rec>0 && homeleave_chk>0 ){
		home_leave_yn_val	= "Y";
	}
	else
		home_leave_yn_val	= "N"; //adding end for Bru-HIMS-CRF-093 [IN:029960]
	if(patient_class.equals("IP") && home_leave_yn_val.equals("Y")) //adding start for Bru-HIMS-CRF-093 [IN:029960] 
		home_leave_disp = "";
	else
		home_leave_disp = "display:none;";
	//getting the last modified order remarks
	//Intialize the bean with default values
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
	//String key	= (orbean.getPatientId()+orbean.getEncounterId());
	String key	= (orbean.getPatientId()+encounter_id);
	// Unique key to keep the Value in the Bean
	java.util.HashMap previousValues= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
	//added for NMC-JD-CRF-0063
	if(previousValues!=null){
		if(patient_class!=null && patient_class.equals("OP")){
			if(op_take_home_medication){
				take_medication_yn_dis	= "disabled";
				if(bean.getOpHomeMedicationVal()!=null){//Added for NMC-JD-CRF-0063 START [11525]
					if(bean.getOpHomeMedicationVal().equals("Y"))
						take_medication_yn_chk	= "checked";
				}
			}
		}
	}
	if(previousValues==null || previousValues.equals("")){
		bean.setOpHomeMedicationVal(null);    //END
	}//END
	ArrayList ordeCatalogCode = new ArrayList();
	String consumable_bean_id				= "@ConsumableOrderBean"+patient_id+encounter_id;
	String consumable_bean_name				= "ePH.ConsumableOrderBean";
	if(iv_prep_default==null || iv_prep_default.equals("")){
		String cn_order_catalog_code 		= orbean.getOrderCatalogCode(previousValues,"PH", pract_type); // pract_type added for ML-BRU-SCF-0958 [IN:042045]
		if(cn_order_catalog_code==null)
			cn_order_catalog_code="";
		//cn_order_catalog_code 		= "N02BE01000T1001C#1#PH,N02BE01000T1001C#2#PH,MYITEM1#1#MS";
		//order_set_code = "DRND";

		ConsumableOrderBean consumable_bean		= (ConsumableOrderBean)getBeanObject( consumable_bean_id,consumable_bean_name , request );
		consumable_bean.setLanguageId(locale);
		consumable_bean.clear();
		consumable_bean.setOrderDate(sys_date);	// Added for Bru-HIMS-CRF-385 [IN:041644]
		StringTokenizer catalogdetail;
		if(!order_set_code.equals("") && !cn_order_catalog_code.equals("")){
			consumable_bean.setLocationCode(location_code);
			consumable_bean.setLocationType(location_type);
			consumable_bean.setPatientId(patient_id);
			consumable_bean.setEncounterId(encounter_id);
			consumable_bean.setPatientClass(patient_class);
			consumable_bean.setActPatientClass(act_patient_class);
			consumable_bean.setCalledFrom("RX");
			String order_set_occur_num = "";
			String drug_yn ="";
			int count;
			String temp_dat ="";
			StringTokenizer token = new StringTokenizer(cn_order_catalog_code, ",");
			while(token.hasMoreTokens()){
				count =0;
				catalogdetail = new StringTokenizer(token.nextToken(), "#");
				while(catalogdetail.hasMoreTokens()){
					count++;
					temp_dat = catalogdetail.nextToken();
					ordeCatalogCode.add(temp_dat);
				}
				if(count == 1){/*=== Code added for IN20379 to make MS items display in Medical Items tab when selected from Addtnl Search --05-04-2010-- priya ===*/
					drug_yn = presBean.getDrugYN(temp_dat);
					if(drug_yn!=null && !(drug_yn.equals(""))){
						if(drug_yn.equals("N")){
							ordeCatalogCode.add("1");
							ordeCatalogCode.add("MS");
						}
						else{
							ordeCatalogCode.add("1");
							ordeCatalogCode.add("DRUG");
						}
					}
				} 
			}
			if(ordeCatalogCode != null && ordeCatalogCode.size()>0)	{	
				MItemsOnly = true;
				for(int i=0;i<ordeCatalogCode.size();i+=3){
					if((i+2)<= (ordeCatalogCode.size()-1)) // condition added for IN20379 --05-04-2010-- priya--
					if(((String)ordeCatalogCode.get(i+2)).equals("MS")){
						order_set_occur_num = (String)ordeCatalogCode.get(i+1);
						consumable_bean.loadItemDetail((String)ordeCatalogCode.get(i),order_set_code,order_set_occur_num,  "", "", bl_install_yn, bl_disp_charge_dtl_in_rx_yn, take_medication_yn_val, "R",  pract_id, resp_id,"0"); //modified By Himanshu  added 0 in last param for GHL-SCF-1738 -->
					}
					else{
						MItemsOnly = false;
						continue;
					}
				}
			}
		}
//Code added for IN20339 to make MS items displayed in Medical Items tab --31/03/2010-- priya 
		else if(order_set_code.equals("") && !cn_order_catalog_code.equals("")){
			consumable_bean.setLocationCode(location_code);
			consumable_bean.setLocationType(location_type);
			consumable_bean.setPatientId(patient_id);
			consumable_bean.setEncounterId(encounter_id);
			consumable_bean.setPatientClass(patient_class);
			consumable_bean.setActPatientClass(act_patient_class);
			StringTokenizer token_codes = new StringTokenizer(cn_order_catalog_code, ",");
			String hash_key ="";
			String temp_token = "";
			cn_order_catalog_code ="";
			while(token_codes.hasMoreTokens()){
				temp_token = token_codes.nextToken();
				hash_key ="h2"+temp_token;
				cn_order_catalog_code = cn_order_catalog_code+temp_token+"#1#"+previousValues.get(hash_key);
				if(token_codes.hasMoreTokens()){
					cn_order_catalog_code = cn_order_catalog_code+",";
				}
			}
			StringTokenizer token = new StringTokenizer(cn_order_catalog_code, ",");
			while(token.hasMoreTokens()){
				catalogdetail = new StringTokenizer(token.nextToken(), "#");
				while(catalogdetail.hasMoreTokens()){
					ordeCatalogCode.add(catalogdetail.nextToken());
				}
			}
			if(ordeCatalogCode != null && ordeCatalogCode.size()>0)	{	
				MItemsOnly = true;
				for(int i=0;i<ordeCatalogCode.size();i+=3){
					if((i+2)<ordeCatalogCode.size() && ((String)ordeCatalogCode.get(i+2)).equals("MS")){
						//order_set_occur_num = (String)ordeCatalogCode.get(i+1);
						consumable_bean.loadItemDetail((String)ordeCatalogCode.get(i),"","",  "", "", bl_install_yn, bl_disp_charge_dtl_in_rx_yn, take_medication_yn_val, "R",  pract_id, resp_id,"0"); //modified By Himanshu  added 0 in last param for GHL-SCF-1738-->
					}
					else{
						MItemsOnly = false;
						continue;
					}
				}
			}
		}
		putObjectInBean(consumable_bean_id,consumable_bean,request);
	}
	String or_order_type_code_yn="";
	String or_order_type_value="";
	HashMap OrderType=(HashMap) presBean.populateOrderType(patient_class);
	if(OrderType.size()>0){
		or_order_type_code_yn=(String) OrderType.get("ORDER_TYPE_CODE_YN");
		if(or_order_type_code_yn==null) 
			or_order_type_code_yn="N";
	}
	if(or_order_type_code_yn.equals("Y")){
		or_order_type_value=(String) orbean.getOrderTypeValue();
	}
	else{
		or_order_type_value="";
	}
	/*order_catalog_code 		= orbean.getOrderCatalogCode(previousValues,"PH")==null?"":orbean.getOrderCatalogCode(previousValues,"PH");
	ordeCatalogCode = new ArrayList();
	if(!order_catalog_code.equals("")){
		StringTokenizer token = new StringTokenizer(order_catalog_code, ",");
		while(token.hasMoreTokens()){
			ordeCatalogCode.add(token.nextToken());
		}
	}*/
	ArrayList details = (ArrayList) bean.getpresDetails();
	if(details!=null && details.size()>0){
%>
		<script>
			parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_load_yn.value="Y";
		</script>
<%
	}
	else{
%>
		<script>
			parent.parent.parent.parent.parent.orderMainTab.OrCommonForm.ph_load_yn.value="N";
		</script>
<%
	}
	ArrayList	ht_wt_uom	=	presBean.getHTWTUOM(patient_id);
	if(ht_wt_uom!=null && ht_wt_uom.size() > 1) {
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)==0)
			leg_value_1="";
		if(!leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)==0  ) 
			leg_value_2="";
		if(leg_value_1==null || leg_value_1.equals("")) {
			if (leg_uom_1 == null || leg_uom_1.equals(""))
				leg_uom_1	=	(String)ht_wt_uom.get(0);	
			if( ht_wt_uom.size() > 2) {
				leg_value_1 =	(String)ht_wt_uom.get(2);	
			}
		}
		if(leg_value_2==null || leg_value_2.equals("")) {
			if (leg_uom_2 == null || leg_uom_2.equals(""))
			leg_uom_2	=	(String)ht_wt_uom.get(1);	
			if( ht_wt_uom.size() > 4) {
				leg_value_2 =	(String)ht_wt_uom.get(3);
				rec_date	=	(String)ht_wt_uom.get(4);
			}
		}
		if((leg_value_2==null || leg_value_2.equals("")) &&( leg_uom_1==null || leg_uom_1.equals("")))
			rec_date = "";
		if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)==0)
			leg_value_1="";
		if(!leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)==0  ) 
			leg_value_2="";
		bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
		bsa_str			= (String.valueOf(bsa));
		if(!leg_value_1.equals("") && !leg_value_2.equals("")) {
			bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
			index	=	bmi_str.indexOf(".");
			if(bmi_str.length()>=(index+3) ) {
				bmi_str	=(bmi_str.substring(0,index+3));
			}
		}
		if(bsa_str.equals("0.0")) 
			bsa_str= "";
		if(bmi_str.equals("0.0"))
			bmi_str= "";
		if(!bsa_str.equals("") && default_dose_type_yn){ // Added for ML-MMOH-CRF-1004 - Start
			bsa_str= BigDecimal.valueOf(Double.valueOf(bsa_str)).setScale(2, BigDecimal.ROUND_UP).toString();
		} // Added for ML-MMOH-CRF-1004 - End
	}
	//added for ml-mmoh-scf-0862 start
	HashMap discr_values_default	=	presBean.getHgtWgtDtlsDefault(patient_id);
	System.out.println("discr_values_default"+discr_values_default);
	if(discr_values_default.containsKey("HEIGHT")) {	
		leg_uom_1	=	(String)discr_values_default.get("HEIGHT");
	
	}
	if(discr_values_default.containsKey("WEIGHT")) {	
		leg_uom_2	=	(String)discr_values_default.get("WEIGHT");
		
	}

	
	if(leg_uom_1==null  || leg_uom_1 == ""  || leg_uom_1.equals(" ")) 
		leg_uom_1= com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.cm.label", "ph_labels");
	if(leg_uom_2==null  || leg_uom_2 == "" || leg_uom_2.equals(" ")) 
		leg_uom_2=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.kg.label", "ph_labels");
		//added for ml-mmoh-scf-0862  end
		//added for ml-mmoh-scf-0915 start
	
		if(leg_value_1!=null  &&  !leg_value_1.equals("")  && !leg_value_1.equals(" ") && Float.parseFloat(leg_value_1)>0 && Float.parseFloat(leg_value_1)<1 ) 
			{
			
				//leg_value_1="0"+leg_value_1 ;
			leg_value_1=""+Float.parseFloat(leg_value_1);
				
		
			}
		if(leg_value_2!=null  &&  !leg_value_2.equals("")  && !leg_value_2.equals(" ") && Float.parseFloat(leg_value_2)>0 && Float.parseFloat(leg_value_2)<1 ) 
		{
		
			//leg_value_2="0"+leg_value_2 ;
			leg_value_2=""+Float.parseFloat(leg_value_2);
	
		}
		//added for ml-mmoh-scf-0915 end
				
	if(( dispPrescripionDuration.equalsIgnoreCase("Y") && (patient_class.equalsIgnoreCase("OP") || take_medication_yn_val.equalsIgnoreCase("Y") )))//Added for BRU-HIMS-CRF-403 [IN:044541] 
		prescripionDurationDisplay = "visibility:visible;";
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="prescription_header_form" id="prescription_header_form">
			<table cellpadding=0 cellspacing=0 width="99%" align="center" border="0">
				<tr >
					<td class="label" width='15%' onmouseover='dispPrevRecs(this);' onmouseout='hidePrevRecs();'><fmt:message key="Common.height.label" bundle="${common_labels}"/>
					&nbsp;&nbsp;<input type="text" name="height" id="height" size="5"  maxlength="8" value="<%=leg_value_1%>" class="NUMBER" onchange="validateBSA();" onblur="checkweight_rec_appl(this);checkDecimal(this,'<%=height_max_digits%>','<%=height_min_digits%>','<%=height_dec_digits%>'); " onKeyPress="return(ChkNumberInput(this,event,'2'))"  oncopy="return false" onpaste="return false" title="<%=rec_date%>">&nbsp;<b><%=leg_uom_1%></b></td>
					<!-- added oncopy="return false" onpaste="return false" for [IN:037181]-->
					<td class="label" width='13%' onmouseover='dispPrevRecs(this);' onmouseout='hidePrevRecs();'><fmt:message key="Common.weight.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="text" name="weight" id="weight" size="5"  maxlength="8" value="<%=leg_value_2%>" onChange="validateBSA();"  onblur="checkweight_rec_appl(this);checkDecimal(this,'<%=weight_max_digits%>','<%=weight_min_digits%>','<%=weight_dec_digits%>');" class="NUMBER" onKeyPress="return(ChkNumberInput(this,event,'2'))" oncopy="return false" onpaste="return false"  title="<%=rec_date%>">&nbsp;<b><%=leg_uom_2%></b></td>	<!-- added oncopy="return false" onpaste="return false" for [IN:037181]-->
				  <% if(default_dose_type_yn){ // if condition Added for ML-MMOH-CRF-1004 and else for existing -Start %>
				  <td class="label" width='9%' onmouseover='dispPrevRecs(this);' onmouseout='hidePrevRecs();'><fmt:message key="Common.BSA.label" bundle="${common_labels}"/>&nbsp;&nbsp;<label id="bsa_lbl"><b><%=bsa_str%></b></label><input type="hidden" name="bsa" id="bsa" size="5"  maxlength="5" value="<%=bsa_str%>"> m&sup2;</td>
					<td class="label" width='12%' onmouseover='dispPrevRecs(this);' onmouseout='hidePrevRecs();'><fmt:message key="Common.BMI.label" bundle="${common_labels}"/>&nbsp;&nbsp;<label id="bmi_lbl"><b><%=bmi_str%></b></label><input type="hidden" name="bmi" id="bmi" size="5"  maxlength="5" value="<%=bmi_str%>"> kg/m&sup2;</td>
				  <%} else{ %>
					<td class="label" width='12%' onmouseover='dispPrevRecs(this);' onmouseout='hidePrevRecs();'><fmt:message key="Common.BSA.label" bundle="${common_labels}"/>&nbsp;&nbsp;<label id="bsa_lbl"><b><%=bsa_str%></b></label><input type="hidden" name="bsa" id="bsa" size="5"  maxlength="5" value="<%=bsa_str%>"></td>
					<td class="label" width='7%' onmouseover='dispPrevRecs(this);' onmouseout='hidePrevRecs();'><fmt:message key="Common.BMI.label" bundle="${common_labels}"/>&nbsp;&nbsp;<label id="bmi_lbl"><b><%=bmi_str%></b></label><input type="hidden" name="bmi" id="bmi" size="5"  maxlength="5" value="<%=bmi_str%>"></td>
					<%} // if condition Added for ML-MMOH-CRF-1004 and else for existing -End %>
					<td class="label" width="16%"  ><fmt:message key="Common.priority.label" bundle="${common_labels}"/>&nbsp;&nbsp;
<%
					if( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("")){
%>
						<select name="priority" id="priority" onchange="disablePriority(this,'<%=request.getQueryString()%>'); defDispLocnForIV(); setPriorityforMI(this);">
							<option value="R" selected><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option>
							<option value="U" ><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
						</select>
						<input type="hidden" name="external_prescription" id="external_prescription" value="false">
<%
					}
					else{
%>
						<select name="priority" id="priority" onchange='defDispLocnForIV(); setPriorityforMI(this);'><option value="R" selected><fmt:message key="Common.routine.label" bundle="${common_labels}"/></option></select>
						<input type="hidden" name="external_prescription" id="external_prescription" value="true">
<%
					}
%>
					</td>
					<!-- Added for BRU-HIMS-CRF-403 [IN:044541]  -start-->
					<td class="label" width='15%' style='<%=prescripionDurationDisplay%>' id='tdPrescripionHdrDuration' ><fmt:message key="Common.duration.label" bundle="${common_labels}"/> &nbsp;&nbsp;<input type="text" size="1" maxlength="3" name="durn_value" id="durn_value" class="NUMBER"  value=""  onKeyPress="return allowValidNumber(this,event,3,0);" onchange='updateDefDuration();'>&nbsp;
						<select name="durn_desc" id="durn_desc" onChange="updateDefDuration();">
						<option value="D" selected><fmt:message key="Common.Day(s).label" bundle="${common_labels}"/></option> 
						<option value="W" ><fmt:message key="ePH.WEEKS.label" bundle="${ph_labels}"/></option>
						<option value="L" ><fmt:message key="ePH.MONTHS.label" bundle="${ph_labels}"/></option>
						<option value="Y" ><fmt:message key="ePH.years.label" bundle="${ph_labels}"/></option>
						</select>
					</td> <!--Added for BRU-HIMS-CRF-403 [IN:044541] --End -->
					<td class="label" width='20%' ><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="text" name="sys_date" id="sys_date" size="10"  maxlength="17" value="<%=sys_date%>" onBlur="chkBackFutureOrderDate(this,'<%=request.getQueryString()%>','<%=locale%>');">&nbsp;<img SRC="../../eCommon/images/CommonCalendar.gif" id='Calendar' onclick="showCalendar('sys_date',null,'hh:mm');" > 
					</td>
				</tr>
			</table>
			<table cellpadding=0 cellspacing=0 width="80%"   border="0">
				<tr>
					<input type="hidden" name="pract_id" id="pract_id" value="<%=pract_id%>" >
					<input type="hidden" name="pract_name" id="pract_name" value="<%=pract_name%>">
<%
					if(OrderType.size()>0){
						order_type_code_yn=(String) OrderType.get("ORDER_TYPE_CODE_YN");
						if(order_type_code_yn==null) order_type_code_yn="N";
							ArrayList OrderTypeCode=(ArrayList) OrderType.get("OrderTypeCode");
							ArrayList OrderTypeDesc=(ArrayList) OrderType.get("OrderTypeDesc");
							if(order_type_code_yn.equals("Y")){
%>
								<input type="hidden" value="Y" name="presel_order_category_yn" id="presel_order_category_yn">
								<td class="label" width="10%"   nowrap><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
								<td class="label" width="15%" >&nbsp;&nbsp;<select name="order_type" id="order_type" onchange="getDrugClass(this);"><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
								for(int i=0;i<OrderTypeCode.size();i++){
%>
									<option value="<%=(String) OrderTypeCode.get(i)%>"><%=(String) OrderTypeDesc.get(i)%></option>
<%
								}//for
%>
								</select>&nbsp;<img   src="../../eCommon/images/mandatory.gif"  id="order_type_man" style="visibility:hidden"></img></td>
								<script>
									document.prescription_header_form.order_type.value="<%=or_order_type_value%>";
								</script>
<%
								if(!or_order_type_value.equals("")){
%>
									<script>document.prescription_header_form.order_type.disabled=true;</script>
<%
								}
							}
						}
						else{
%>
							<input type="hidden" value="N" name="presel_order_category_yn" id="presel_order_category_yn">
							<td class="label" width="10%" nowrap>&nbsp;</td>
							<td class="label" width="15%" >&nbsp;</td>
<%
						}
%>
						<%
						//added for NMC-JD-CRF-0063 start
						if(take_home_medication_op.equals("Y")){ %>
						<td class="label"  width="15%"><fmt:message key="ePH.TakeHomeMedication.label" bundle="${ph_labels}"/></td>
						<td width="5%"><input type="checkbox" id="take_home_medication_op_chk" name="take_home_medication_op_chk" id="take_home_medication_op_chk" onclick="assignValueOP(this);defDispLocnForIV()" <%=take_medication_yn_chk%> <%=take_medication_yn_dis%> value="<%=take_medication_yn_val%>" ></td>
						<%}else{ %>
						<td class="label"  width="15%"><fmt:message key="Common.DischargeMedication.label" bundle="${common_labels}"/></td>
						<td width="5%"><input type="checkbox" name="take_home_medication" id="take_home_medication" onclick="assignValue(this);defDispLocnForIV()" <%=take_medication_yn_chk%> <%=take_medication_yn_dis%> value="<%=take_medication_yn_val%>" ></td>
						<%} //end%>
						<td class="label"   width="20%" ><div id='divHomeLeave'  style='<%=home_leave_disp%>'><fmt:message key="ePH.HomeLeaveMedication.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="checkbox" name="home_leave_yn_chk" id="home_leave_yn_chk" value='<%=home_leave_yn_val%>' onclick="assignHomeLeave(this)" title='<fmt:message key="Common.LeaveFrom.label" bundle="${common_labels}"/> : <%=leave_fm%> <fmt:message key="Common.to.label" bundle="${common_labels}"/> <%=leave_to%>'>
							<br>(<%=leave_fm%> - <%=leave_to%> )</div>
						</td><!--Added for Bru-HIMS-CRF-093-DD1[IN047223]-->
						<td class="label" width="15%" nowrap><label style='font-size:11;font-weight:bold;color:red;<%=allergyvisiblity%>;'><fmt:message key="ePH.KnownCaseofAllergy.label" bundle="${ph_labels}"/></label><input type="hidden" name="allergic_yn" id="allergic_yn" value='<%=allergic_yn%>'>
						</td>
						<td class="label" width="*"><a href="javascript:callOrderRemarks();" title="Clinical Comments"><fmt:message key="Common.ClinicalComments.label" bundle="${common_labels}"/>.</a>&nbsp;

 <%                     
						if(adr_count >0){
 %>   
							 <a href="javascript:callADRdetails('<%=patient_id%>');" >&nbsp;&nbsp;<fmt:message key="ePH.ADR.label" bundle="${ph_labels}"/></a>
<%
						}
%>
					
						<label onClick="javascript:callDiagText('<%=patient_id%>','<%=encounter_id%>','Header');" style="visibility:hidden" id="diag_text" title="Diag Text">&nbsp;&nbsp;<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></label></td>
<%
						HashMap maternityMap= pregn_bean.getPregnancyRemarks(patient_id);
						String lmpValue = maternityMap.get("LMP").toString();
						String gestationValue = maternityMap.get("GESTATION").toString();
						String eddValue = maternityMap.get("EDD").toString();
						String asOnDateValue = maternityMap.get("ASONDATE").toString();
						if (!((lmpValue.equals(""))&&(gestationValue.equals(""))&&(eddValue.equals("")))){
%>
							<td class="label"  nowrap width='10%'><a href="javascript:showPregnancyRemarks('<%=lmpValue%>','<%=gestationValue%>','<%=eddValue%>','<%=asOnDateValue%>');" title="Pregnancy Remarks "><fmt:message key="ePH.PregnancyRemarks.label" bundle="${ph_labels}"/> </a></td>
<%
						}
						if(order_type_code_yn.equals("N")){
%>
							<input type="hidden" value="NO" name="order_type" id="order_type">
<%
						}
%>
					</tr>
				</table>
				<table cellpadding="1" cellspacing=0 width="100%" align="center" border="0" id="tab">
					<tr>
<%
					if(version_no.equals("1") ){
						if((allow_without_diag.equals("Y")) ||((allow_without_diag.equals("N")) && (diag_size!=0))){
%>
							<td width='10%' id="nonivrx" class="CASECONDSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('nonivrx')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></a></td>
							<td class="white" width='80%' id="dummy"></td>
<%
						}
					}
					else if(version_no.equals("2") ){
						if((allow_without_diag.equals("Y")) ||((allow_without_diag.equals("N")) && (diag_size!=0)) ){
%>
							<td width='10%' id="nonivrx" class="CASECONDSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('nonivrx')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></a></td>
<%
							if( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("")){
								if(comp_rx_appl_yn.equals("Y") ){
%>
									<td width='10%' id="comprx" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('comprx')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.CompoundingRx.label" bundle="${ph_labels}"/></a></td> 
<%
								}
								if(iv_rx_appl_yn.equals("Y")){
%>
									<td width='10%' id="ivrx" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('ivrx')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.IVRx.label" bundle="${ph_labels}"/>  </a></td>
<%
								}
							}
%>
							<td class="white" width='70%' id="dummy"></td>
<%  
						}
					}
					else if(version_no.equals("3") ){
						if((allow_without_diag.equals("Y")) ||((allow_without_diag.equals("N")) && (diag_size!=0)) ) {
%>
							<td width='10%' id="nonivrx" class="CASECONDSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('nonivrx')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Rx.label" bundle="${ph_labels}"/></a></td>
<%
							if( bean.getExternalpatient_id()==null || bean.getExternalpatient_id().equals("")){
								if(comp_rx_appl_yn.equals("Y") && MAR.length()==0){
%>
									<td width='10%' id="comprx" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('comprx')">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.CompoundingRx.label" bundle="${ph_labels}"/></a></td>
<%
								}
								if(iv_rx_appl_yn.equals("Y") && MAR.length()==0 ){
%>
									<td width='10%' id="ivrx" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('ivrx')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.IVRx.label" bundle="${ph_labels}"/> </a></td>
<%
								}  
								if(oncology_rx_appl_yn.equals("Y")){
									if(regimen_yn.equalsIgnoreCase("Y") && MAR.length()==0) { 
										if(indicator_desc.equals("Oncology")){
%>										
											<td width='10%' id="oncology_regimen" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap  ><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('oncology_regimen')">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Oncology.label" bundle="${ph_labels}"/></a> </td>
<%
										}
										else if(indicator_desc.equals("TB")){
%>
											<td width='10%' id="oncology_regimen" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap  ><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('oncology_regimen')">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.TB.label" bundle="${ph_labels}"/></a> </td>
<%										}
										else if(indicator_desc.equals("Psycho")){
%>
											<td width='10%' id="oncology_regimen" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap  ><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('oncology_regimen')">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.Psycho.label" bundle="${ph_labels}"/></a> </td>
<%	
										}
									}
								}
								if(tpn_rx_appl_yn.equals("Y")&&(patient_class.equals("IP")||patient_class.equals("DC"))){
									if(tpn_yn.equalsIgnoreCase("Y") && MAR.length()==0) {
%>
										<td width='10%' id="tpn_regimen" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap  ><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('tpn_regimen')">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.TPNRegimen.label" bundle="${ph_labels}"/></a> </td>
<%
									}
								}
								if(tdm_appl_yn.equals("Y") && MAR.length()==0){
%>
									<td width='10%' id="tdm" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap  ><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('tdm')" id="tdm_link">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/></a> </td>
	
<%
								}
							}
							if(function_id.equals("PH") && NBPRequestApplYN.equals("A")){ //moved into this if block(version_no =3) for AAKH-SCF-0008 [IN:037381]
%>
								<td width='10%' id="NPBRequest" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap  >
									<a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('NPBRequest')" id="NPBRequest_link">&nbsp;&nbsp;&nbsp;<fmt:message key="ePH.NPBRequest.label" bundle="${ph_labels}"/></a> 
								</td>
<%
							}
						}
					}	
					if(MAR.length()==0  && !function_from.equals("ALTERNATE_ORDER") ){ //function_from.equals("ALTERNATE_ORDER") added for JD-CRF-198       
%>
						<td width='10%' id="medicalItem" class="CAFIRSTSELECTHORZ" onMouseOver="callOnMouseOver(this);" onMouseOut="callOnMouseOut(this);" onClick="changeButtonColor(this,'PH_BUTTONS')" nowrap  ><a class="MENUHIGHERLEVELLINK" style="color:white" href="javascript:change_tab_buttons('medicalItem')" id="medicalItem_link">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.MedicalItem.label" bundle="${common_labels}"/></a> </td>
<%
					}
%>
					<td class="white" width='*' id="dummy"></td>	
				</tr>
			</table>
			<input type="hidden" name="presBean_id" id="presBean_id" value="<%=presBean_id%>">
			<input type="hidden" name="presBean_name" id="presBean_name" value="<%=presBean_name %>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="bed_num" id="bed_num" value="<%=bed_num%>">
			<input type="hidden" name="room_num" id="room_num" value="<%=room_num%>">
			<input type="hidden" name="height_unit" id="height_unit" value="<%=leg_uom_1%>">
			<input type="hidden" name="weight_unit" id="weight_unit" value="<%=leg_uom_2%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="calculated_date" id="calculated_date" value="<%=calculated_date%>">
			<input type="hidden" name="visit_date" id="visit_date" value="<%=visit_date%>">
			<input type="hidden" name="ref_sys_date" id="ref_sys_date" value="<%=sys_date%>">
			<input type="hidden" name="order_type_code_yn" id="order_type_code_yn" value="<%=order_type_code_yn%>">
			<input type="hidden" name="location_type" id="location_type" value="<%=location_type%>">
			<input type="hidden" name="location_code" id="location_code" value="<%=location_code%>">
			<input type="hidden" name="drug_class" id="drug_class" value="">
			<input type="hidden" name="patient_class" id="patient_class" value="<%=patient_class%>">
			<input type="hidden" name="disc_cancel_flag" id="disc_cancel_flag" value="<%=disc_cancel_flag%>"><!-- added for ML-BRU-SCF-2080-->
			
		<!-- Added for ML-MMOH-SCF-0362 To get ouptatiend set up for deycare patient start -->	
			<%-- <input type="hidden" name="act_patient_class" id="act_patient_class" value="<%=act_patient_class%>"> --%> <!--value is changed from patient_class to act_patient_class SRR20056-SCF-7622 with Spira incident No : 27687-->
				<%if( take_medication_yn_val == "Y") 
			    {
				new_patient_class="IP";
				 %>
			<input type="hidden" name="act_patient_class" id="act_patient_class" value="<%=new_patient_class%>">
		
			<%}
			else{
				 %>
			<input type="hidden" name="act_patient_class" id="act_patient_class" value="<%=patient_class%>">
			
			<%
			}
			 %>
			 <!-- Added for ML-MMOH-SCF-0362 To get ouptatiend set up for deycare patient end -->
			<input type="hidden" name="order_remarks" id="order_remarks" value="<%=order_remarks%>">
			<input type="hidden" name="actual_patient_class" id="actual_patient_class" value="<%=act_patient_class%>">
			<input type="hidden" name="source_type" id="source_type" value="<%=location_type%>">
			<input type="hidden" name="source_code" id="source_code" value="<%=location_code%>">
			<input type="hidden" value="<%=attend_pract_id%>" name="attend_pract_id">
			<input type="hidden" value="<%=facility_id%>" name="facility_id">
			<input type="hidden" value="<%=resp_id%>" name="resp_id">
			<input type="hidden" value="<%=back_date%>" name="back_date">
			<input type="hidden" value="<%=future_date%>" name="future_date">
			<input type="hidden" value="<%=licence%>" name="licence">
			<input type="hidden" value="<%=servide_code%>" name="servide_code">
			<input type="hidden" value="<%=service_search_yn%>" name="service_search_yn">
			<input type="hidden" value="<%=problem_ind%>" name="problem_ind">
			<input type="hidden" value="<%=version_no%>" name="version_no">
			<input type="hidden"  name="QueryString" id="QueryString" value="<%=request.getQueryString()%>">
			<input type="hidden" value="<%=ph_default_tab%>" name="ph_default_tab">
			<input type="hidden" name="take_medication_yn_chk" id="take_medication_yn_chk" value="<%=take_medication_yn_chk%>">
			<input type="hidden" name="allow_without_wt" id="allow_without_wt" value="<%=allow_without_wt%>">
			<input type="hidden" name="allow_without_diag" id="allow_without_diag" value="<%=allow_without_diag%>">
			<input type="hidden" name="diag_for_medn_order_by" id="diag_for_medn_order_by" value="<%=diag_for_medn_order_by%>">
			<input type="hidden" name="patient_age" id="patient_age" value="<%=patient_age%>">
			<input type="hidden" name="date_of_birth" id="date_of_birth" value="<%=date_of_birth%>">
			<input type="hidden" name="gender" id="gender" value="<%=gender%>">
			<input type="hidden" name="patient_name" id="patient_name" value="<%=patient_name%>"> <!-- Added for MMS-KH-CRF-0016 -->			
			<input type="hidden" name="diag_size" id="diag_size" value="<%=diag_size%>">
			<input type="hidden" name="diag_text_size" id="diag_text_size" value="<%=bean.getDiagText()==null?"0":(bean.getDiagText()).size()%>">
			<input type="hidden" name="sliding_scale" id="sliding_scale" value="">
			<input type="hidden" name="num" id="num" value="<%=num%>"> 
			<input type="hidden" name="height_min_value" id="height_min_value" value="<%=height_min_value%>"> 
			<input type="hidden" name="height_max_value" id="height_max_value" value="<%=height_max_value%>"> 
			<input type="hidden" name="weight_min_value" id="weight_min_value" value="<%=weight_min_value%>"> 
			<input type="hidden" name="weight_max_value" id="weight_max_value" value="<%=weight_max_value%>">
			<input type="hidden" name="height_min_digits" id="height_min_digits" value="<%=height_min_digits%>"> 
			<input type="hidden" name="height_max_digits" id="height_max_digits" value="<%=height_max_digits%>"> 
			<input type="hidden" name="weight_min_digits" id="weight_min_digits" value="<%=weight_min_digits%>"> 
			<input type="hidden" name="weight_max_digits" id="weight_max_digits" value="<%=weight_max_digits%>">
			<input type="hidden" name="iv_prep_default" id="iv_prep_default" value="<%=iv_prep_default%>">
			<input type="hidden" name="order_set_code" id="order_set_code" value="<%=order_set_code%>">
			<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="">
			<input type="hidden" name="bl_disp_charge_dtl_in_rx_yn" id="bl_disp_charge_dtl_in_rx_yn" value="<%=bl_disp_charge_dtl_in_rx_yn%>">
			<input type="hidden" name="disp_price_type_in_drug_lkp" id="disp_price_type_in_drug_lkp" value="<%=disp_price_type_in_drug_lkp%>">
			<input type="hidden" name="disp_charge_dtl_in_drug_lkp_yn" id="disp_charge_dtl_in_drug_lkp_yn" value="<%=disp_charge_dtl_in_drug_lkp_yn%>">
			<input type="hidden" name="bl_install_yn" id="bl_install_yn" value="<%=bl_install_yn%>">
			<input type="hidden" name="dc_mar_appl_yn" id="dc_mar_appl_yn" value="<%=dc_mar_appl_yn%>">
			<input type="hidden" name="em_mar_appl_yn" id="em_mar_appl_yn" value="<%=em_mar_appl_yn%>">
			<input type="hidden" name="ip_mar_appl_yn" id="ip_mar_appl_yn" value="<%=ip_mar_appl_yn%>">
			<input type="hidden" name="op_mar_appl_yn" id="op_mar_appl_yn" value="<%=op_mar_appl_yn%>">
			<input type="hidden" name="disch_med_mar_appl_yn" id="disch_med_mar_appl_yn" value="<%=disch_med_mar_appl_yn%>">
			<input type="hidden" name="split_based_priority_yn" id="split_based_priority_yn" value="<%=split_based_priority_yn%>">
			<input type="hidden" name="split_based_drug_class_yn" id="split_based_drug_class_yn" value="<%=split_based_drug_class_yn%>">
			<input type="hidden" name="max_durn_for_ip_pres" id="max_durn_for_ip_pres" value="<%=max_durn_for_ip_pres%>">
			<input type="hidden" name="chk_for_ip_max_durn_action" id="chk_for_ip_max_durn_action" value="<%=chk_for_ip_max_durn_action%>">
			<input type="hidden" name="max_durn_for_op_pres" id="max_durn_for_op_pres" value="<%=max_durn_for_op_pres%>">
			<input type="hidden" name="chk_for_op_max_durn_action" id="chk_for_op_max_durn_action" value="<%=chk_for_op_max_durn_action%>">
			<input type="hidden" name="max_durn_for_dm_pres" id="max_durn_for_dm_pres" value="<%=max_durn_for_dm_pres%>">
			<input type="hidden" name="chk_for_dm_max_durn_action" id="chk_for_dm_max_durn_action" value="<%=chk_for_dm_max_durn_action%>">
			<input type="hidden" name="trade_display_yn" id="trade_display_yn" value="<%=trade_display_yn%>"> 
			<input type="hidden" name="narcotic_aprvl_form_req_yn" id="narcotic_aprvl_form_req_yn" value="<%=narcotic_aprvl_form_req_yn%>"> 
			<input type="hidden" name="print_narcotic_form_by_default" id="print_narcotic_form_by_default" value="<%=print_narcotic_form_by_default%>"> 
			<!--External Drug Interface Controls -->	   
			<input type="hidden" name="drug_db_interface_yn" id="drug_db_interface_yn" value="<%=drug_db_interface_yn%>"> 
			<input type="hidden" name="drug_db_product_id" id="drug_db_product_id" value="<%=drug_db_product_id%>"> 
			<input type="hidden" name="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn" value="<%=drug_db_dosecheck_yn%>"> 
			<input type="hidden" name="drug_db_duptherapy_yn" id="drug_db_duptherapy_yn" value="<%=drug_db_duptherapy_yn%>"> 
			<input type="hidden" name="drug_db_interact_check_yn" id="drug_db_interact_check_yn" value="<%=drug_db_interact_check_yn%>">
			<input type="hidden" name="drug_db_contraind_check_yn" id="drug_db_contraind_check_yn" value="<%=drug_db_contraind_check_yn%>">
			<input type="hidden" name="drug_db_allergy_check_yn" id="drug_db_allergy_check_yn" value="<%=drug_db_allergy_check_yn%>">
			<input type="hidden" name="adr_count" id="adr_count" value="<%=adr_count%>">
			<input type="hidden" name="consumable_bean_id" id="consumable_bean_id" value="<%=consumable_bean_id%>">
			<input type="hidden" name="consumable_bean_name" id="consumable_bean_name" value="<%=consumable_bean_name%>">
			<input type="hidden" name="MAR" id="MAR" value="<%=MAR%>">
			<input type="hidden" name="MItemsOnly" id="MItemsOnly" value="<%=MItemsOnly%>">
			<input type="hidden" name="man_rem_on_prn_freq_yn" id="man_rem_on_prn_freq_yn" value="<%=man_rem_on_prn_freq_yn%>">
			<input type="hidden" name="max_length_prn_reason" id="max_length_prn_reason" value="<%=max_length_prn_reason%>">
			<input type="hidden" name="rx_qty_by_pres_base_uom_yn" id="rx_qty_by_pres_base_uom_yn" value="<%=rx_qty_by_pres_base_uom_yn%>">
			<input type="hidden" name="weight_rec_appl_age_group_check_flag" id="weight_rec_appl_age_group_check_flag" value="">
			<input type="hidden" name="wt_mand_yn" id="wt_mand_yn" value=""> <!-- added for Bru-HIMS-CRF-079 IN[029945]  -->
			<input type="hidden" name="ht_mand_yn" id="ht_mand_yn" value=""> <!--  added for Bru-HIMS-CRF-079 IN[029945]  -->
			<input type="hidden" name="atc_allergy_alert_level" id="atc_allergy_alert_level" value="<%=atc_allergy_alert_level%>">
			<input type="hidden" name="NBPRequestApplYN" id="NBPRequestApplYN" value="<%=NBPRequestApplYN%>">
			<input type="hidden" name="drug_interaction_check_yn" id="drug_interaction_check_yn" value="<%=drug_interaction_check_yn%>">
			<!-- <input type="hidden" name="priority" id="priority" value="R"> -->
			<input type="hidden" name="home_leave_yn_val" id="home_leave_yn_val" value="<%=home_leave_yn_val%>"><!-- added for Bru-HIMS-CRF-093[29960] -->
			<input type="hidden" name="home_leave_fm" id="home_leave_fm" value="<%=leave_fm%>">
			<input type="hidden" name="home_leave_to" id="home_leave_to" value="<%=leave_to%>">
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>"><!-- adding end for Bru-HIMS-CRF-093[29960] -->
			<input type="hidden" name="print_mar_label_yn" id="print_mar_label_yn" value="<%=print_mar_label_yn%>"><!-- added for MMS-QH-CRF-0080 [IN:038064] -->
			<input type="hidden" name="buildMAR_yn" id="buildMAR_yn" value="N"><!-- added for MMS-QH-CRF-0080 [IN:038064] -->
			<input type="hidden" name="trimester" id="trimester" value="<%=bean.getPregTrimester()%>"><!--added for CRF RUT-CRF-0063[29601] -->
			<input type="hidden" name="lmp_date" id="lmp_date" value="<%=lmp_date%>"><!--added for CRF RUT-CRF-0063[29601] -->
			<input type="hidden" name="pregnency_yn" id="pregnency_yn" value="<%=pregnency_yn%>"><!--added for CRF RUT-CRF-0063[29601] -->
			<input type="hidden" name="pract_type" id="pract_type" value="<%=pract_type%>"><!--added for ML-BRU-SCF-0958 [IN:042045] -->
			<input type="hidden" name="allergy_conf_reqd_yn" id="allergy_conf_reqd_yn" value="<%=allergy_conf_reqd_yn%>"><!--added for ML-BRU-SCF-0958 [IN:042045] -->
			<input type="hidden" name="excludeADRAllergyAlert_yn" id="excludeADRAllergyAlert_yn" value="<%=excludeADRAllergyAlert_yn%>"><!--Added for HSA-SCF-0011 [IN:042444] -->
			<input type="hidden" name="witness_for_verbal_order_yn" id="witness_for_verbal_order_yn" value="<%=witness_for_verbal_order_yn%>"><!-- Added for AAKH-CRF-0023[IN:038259] -->
			<input type="hidden" name="login_user_prac_id" id="login_user_prac_id" value="<%=login_user_prac_id%>"><!-- Added for AAKH-CRF-0023[IN:038259] -->
			<input type="hidden" name="dispPrescripionDuration" id="dispPrescripionDuration" value="<%=dispPrescripionDuration%>"><!-- Added for BRU-HIMS-CRF-403 [IN:044541] -->
			<input type="hidden" name="episode_id" id="episode_id" value="<%=episode_id%>"><!-- Added for HSA-CRF-0152 [IN:048469] -->
			<input type="hidden" name="visit_adm_date" id="visit_adm_date" value="<%=visit_adm_date%>"><!-- Added for HSA-CRF-0152 [IN:048469] -->
			<input type="hidden" name="called_from_verbal_order" id="called_from_verbal_order" value="<%=called_from_verbal_order%>"><!-- //added for PMG2012-CRF-0019 [IN:035859] AutoComplete start -->
			<input type="hidden" name="default_prev_drug_sel" id="default_prev_drug_sel" value="<%=default_prev_drug_sel%>">
			<input type="hidden" name="preview_rx_yn" id="preview_rx_yn" value="<%=preview_rx_yn%>"><!-- //added for ML-MMOH-CRF-0341 [IN:057179] -->
			<input type="hidden" name="allow_priv_to_order_yn" id="allow_priv_to_order_yn" value="<%=allow_priv_to_order_yn%>">
			<input type="hidden" name="drug_seach_autocomplete_yn" id="drug_seach_autocomplete_yn" value="<%=bean.getDrugSeachAutocomplete_yn()%>"><!-- //added for PMG2012-CRF-0019 [IN:035859] AutoComplete -end -->
			<input type="hidden" name="disp_prev_vital_signs_yn" id="disp_prev_vital_signs_yn" value="<%=disp_prev_vital_signs_yn%>"><!--added for ML-MMOH-CRF-0346 [IN:057185]-->
			<input type="hidden" name="function_from" id="function_from" value="<%=function_from%>"><!--added for JD-CRF-198-->
			<input type="hidden" name="alternateOrder" id="alternateOrder" value="<%=alternateOrder%>"><!--added for JD-CRF-198-->
			<input type="hidden" name="currentStage" id="currentStage" value="<%=currentStage%>">
			<input type="hidden" name="split_drug_based_auth_yn" id="split_drug_based_auth_yn" value="<%=split_drug_based_auth_yn%>"><!-- Added for ml-mmoh-cef-0864 -->
		        <input type="hidden" name="allow_alt_for_med_item" id="allow_alt_for_med_item" value="<%=bean.getAllowAltForMedItem()%>"><!-- Added for GHL-CRF-0548 [IN:068345] -Devindra -->
		        <input type="hidden" name="reconciliation_req_yn" id="reconciliation_req_yn" value="<%=reconciliation_req_yn%>"><!-- added for mms-kh-crf-0016 -->
		          <input type="hidden" name="reconciliation_done_yn" id="reconciliation_done_yn" value="<%=reconciliation_done_yn%>"><!-- added for IN070786 -->
		          <% if(take_home_medication_op.equals("Y")){ %>  <!-- Added for NMC-JD-CRF-0063 -->
		          <input type="hidden" name="take_home_medication" id="take_home_medication" value="<%=take_home_medication_ip%>">
		          <%} %>
		        <input type="hidden" name="take_home_medication_ckk_val" id="take_home_medication_ckk_val" value="<%=take_home_medication_ckk_val%>"><!-- added for NMC-JD-CRF-0063 --> 
		         <input type="hidden" name="take_home_medication_op" id="take_home_medication_op" value="<%=take_home_medication_op%>"><!-- added for NMC-JD-CRF-0063 -->
		         <input type="hidden" name="drug_indication_mdry" id="drug_indication_mdry" value="<%=drug_indication_mdry%>"><!-- Added for JD-CRF-0220 -->
			<div name="divPrevHtWtDtls" id="divPrevHtWtDtls" style="position:absolute; width:30%; height:60px; display:none;" bgcolor="blue"> <!-- div part added for ML-MMOH-CRF-0346 [IN:057185]-->
<%
				if(hmPrev_vital_signs!=null && hmPrev_vital_signs.size()>0){
%>
					<table id="tabPrevHtWtDtls" cellpadding=0 cellspacing=0 border="1" align="center">
						<tr>
							<th style='font-size:9;' width='20%'><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></th>
							<th style='font-size:9;' width='20%'><fmt:message key="Common.height.label" bundle="${common_labels}"/></th>
							<th style='font-size:9;' width='20%'><fmt:message key="Common.weight.label" bundle="${common_labels}"/></th>
							<th style='font-size:9;' width='20%'><fmt:message key="Common.BSA.label" bundle="${common_labels}"/></th>
							<th style='font-size:9;' width='20%'><fmt:message key="Common.BMI.label" bundle="${common_labels}"/></th>
						</tr>
<%
						Set <String> hshKeys = new HashSet<String>();
						hshKeys = hmPrev_vital_signs.keySet();
						for(String keyRec:hshKeys){
							HeaderHtWtValues = (HashMap)hmPrev_vital_signs.get(keyRec);
							leg_value_1="";
							leg_uom_1="";
							leg_value_2="";
							leg_uom_2="";
							bsa_str="";
							bmi_str="";
							if(HeaderHtWtValues.containsKey("HEIGHT")){
								leg_value_1		= (String) HeaderHtWtValues.get("HEIGHT");
								leg_uom_1		= (String) HeaderHtWtValues.get("HEIGHT_UOM");
							}
							if(HeaderHtWtValues.containsKey("WEIGHT")){
								leg_value_2		= (String) HeaderHtWtValues.get("WEIGHT");
								leg_uom_2		= (String) HeaderHtWtValues.get("WEIGHT_UOM");
							}
							bsa				= (float) presBean.loadBSA(leg_value_1,leg_value_2);
							bsa_str			= (String.valueOf(bsa));
							
							if(!leg_value_1.equals("") && Float.parseFloat(leg_value_1)>0 && !leg_value_2.equals("") &&  Float.parseFloat(leg_value_2)>0  ) {
								bmi_str=(Float.parseFloat(leg_value_2)/((Float.parseFloat(leg_value_1)/100)*(Float.parseFloat(leg_value_1)/100)))+"";	
								index	=	bmi_str.indexOf(".");
								if(bmi_str.length()>=(index+3) ) {
									bmi_str	=(bmi_str.substring(0,index+3));
								}
							}
							if(bsa_str.equals("0.0")) 
								bsa_str= "";
							if(bmi_str.equals("0.0")) 
								bmi_str= "";
%>
							<tr>
								<td class="label" style='font-size:10;' nowrap><%=keyRec%>&nbsp;</td>
								<td class="label" style='font-size:10;' nowrap><%=leg_value_1%>&nbsp;<%=leg_uom_1%></td>
								<td class="label" style='font-size:10;' nowrap><%=leg_value_2%>&nbsp;<%=leg_uom_2%></td>
								<td class="label" style='font-size:10;' nowrap><%=bsa_str%>&nbsp;</td>
								<td class="label" style='font-size:10;' nowrap><%=bmi_str%>&nbsp;</td>
							</tr>
<%
						}
					}
%>
				</table>
			</div>
			
		</form>
<%
		if(back_date.equals("0") && future_date.equals("0") ){
%>
			<script>document.prescription_header_form.sys_date.disabled=true;</script>
<%
		}
		else{
%>
			<script>document.prescription_header_form.sys_date.disabled=false;</script>
<%
		}
		if(order_type_code_yn!=null && order_type_code_yn.equals("Y")){
%>
			<script>document.prescription_header_form.order_type_man.style.visibility="visible";</script>
<%
		}
%>
		<script>
			//alert("iv_prep_default in hdr 1 :"+iv_prep_default);
			setPriorityforMI(document.prescription_header_form.priority); //added for IN26242 --02/02/2011-- priya
			loadOtherFrames('<%=request.getQueryString()%>');
		</script>
	</body>
<% 
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,orbean,request);
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

