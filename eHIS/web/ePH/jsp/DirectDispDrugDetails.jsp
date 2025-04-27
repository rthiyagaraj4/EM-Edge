<!DOCTYPE html>
 <%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
29/08/2019      IN:070451           B Haribabu  29/08/2019      Manickam                 ML-MMOH-CRF-1408
18/02/2020		IN071362                Manickavasagam J                       AAKH-CRF-0117
06/07/2020      IN:072715          Haribabu     06/07/2020     Manickavasagam     MMS-DM-CRF-0165
28/07/2020      IN:073485                   Haribabu                                PH-MMS-DM-CRF-0165/01-Normal rx-Amend order
10/08/2020	    IN73611             Shazana												 MMS-DM-CRF-0174.4
12/11/2020     IN:069887       Haribabu         13/11/2020     Manickavasagam     MO-CRF-20152
20/10/2020      IN:069886         Haribabu                       Manickam            MO-CRF-20151
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  %>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%		  
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
		String locale			= (String)session.getAttribute("LOCALE"); 
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>   
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="javascript"	 src="../../eCommon/js/DateUtils.js"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="prescription_detail_form" id="prescription_detail_form" >
<%
			//Variable initialization starts-->
			String patient_id				= "";
			String encounter_id				= "";
			String priority					= "";
			String hr_start_time			= "";
			String drug_code				= "";
			String srl_no					= "";
			String bsa						= "";
			String weight                   = ""; // Added for ML-MMOH-CRF-0978
			String	allergic_yn             = "";
			String weight_rec_appl_age_group_check_flag = "";//added for Bru-HIMS-CRF-079 IN[029945]
			String wt_mand_yn="", ht_mand_yn=""; //added for Bru-HIMS-CRF-079 IN[029945]
			String barcodeDisable = ""; // Added for MMS-DM-CRF-0112.1 [IN:065216]
			String barcode_yn =""; // Added for MMS-DM-CRF-0112.1 [IN:065216]
			//Variable initialization ends-->
			//Parameters--Start-->

			try{
				String calling_mode				= request.getParameter("mode") ;
				String dis					    = "";
				String dis1						= "display:none";
				String dir_bean_id				= "DirectDispensingBean" ;
				String dir_bean_name			= "ePH.DirectDispensingBean";
				DirectDispensingBean dir_bean	= (DirectDispensingBean)getBeanObject(dir_bean_id,dir_bean_name,request) ;
				String facility_id					= (String) session.getValue("facility_id");
				//dir_bean.setLanguageId(locale);

				String pract_name               = dir_bean.getPractionerName();
			   //code added for external data base checks 

				//String drug_db_interface_yn			=	"N";
			        boolean default_recm_dose_yn=dir_bean.isSiteSpecific("PH", "DEFAULT_RECOM_DOSE_YN"); // Added for ML-MMOH-CRF-0978
					boolean default_freq_not_found =dir_bean.isSiteSpecific("PH","DEFAULT_FREQUENCY_NOT_FOUND");//added for GHL-CRF-0508
				  boolean approval_no_flag = dir_bean.isSiteSpecific("PH","APPROVAL_NO_APPLICABLE_FLAG");//AAKH-CRF-0117 
				  boolean over_ride_remarks_select_appl=dir_bean.isSiteSpecific("PH","PH_OVERRIDE_REASON_SELECT_APPL");//Added for IN:072715 
				  //Added for IN:073485 start
				  String override_select_appl="N";
					if(over_ride_remarks_select_appl){
						override_select_appl="Y";
					}
					//Added for IN:073485 end
					//Added for IN:069887 start
					boolean validate_overide_on_confirm =dir_bean.isSiteSpecific("PH","VALIDATE_OVERIDE_ON_CONFIRM");//added for MO-CRF-20152
					String validate_overide_on_confirm_yn="N";
					if(validate_overide_on_confirm){
						validate_overide_on_confirm_yn="Y";
					}
					//Added for IN:069887 end
				String drug_db_dosecheck_yn			=	"N";
				String drug_db_duptherapy_yn		=	"N";
				String drug_db_interact_check_yn	=	"N";
				String drug_db_contraind_check_yn	=	"N";
				String drug_db_allergy_check_yn		=	"N";
			   //ends here
				if(calling_mode.equals("blank")){
					patient_id				= dir_bean.getPatientID();	
					encounter_id			= dir_bean.getEncounterID();
					if(encounter_id==null){
					   encounter_id="";
					}
					priority				= request.getParameter("priority") ;
					hr_start_time			= request.getParameter("start_date") ;
					allergic_yn				= request.getParameter("allergic_yn") ;
					dis						= "display:none";
					dis1 					= "visibility:hidden";
					if(allergic_yn==null)
						allergic_yn="";		
				}
				else{
					drug_code				= request.getParameter("drug_code") ;
					srl_no					= request.getParameter("srl_no") ;
					//out.println("drug_code="+drug_code+",srl_no="+srl_no);
					patient_id				= request.getParameter("patient_id") ;
					encounter_id			= request.getParameter("encounter_id") ;
					if(encounter_id==null){
					   encounter_id="";
					}
					priority				= request.getParameter("priority") ;
					hr_start_time			= request.getParameter("start_date") ;
					bsa						= request.getParameter("bsa") ;	
					weight = (String)request.getParameter("weight")==null?"1":(String)request.getParameter("weight") ;// Added for ML-MMOH-CRF-0978
					if(weight.equals(""))
						weight = "1"; // Added for ML-MMOH-CRF-0978
					dis1 					= "visibility:hidden";
				  //code added for external data base checks 
				   // drug_db_interface_yn			=	request.getParameter("drug_db_interface_yn") ;       
					drug_db_dosecheck_yn			=	request.getParameter("drug_db_dosecheck_yn") ;       
					drug_db_duptherapy_yn			=	request.getParameter("drug_db_duptherapy_yn") ;	     
					drug_db_interact_check_yn		=	request.getParameter("drug_db_interact_check_yn") ;	 
					drug_db_contraind_check_yn		=	request.getParameter("drug_db_contraind_check_yn") ; 
					drug_db_allergy_check_yn		=	request.getParameter("drug_db_allergy_check_yn") ;  
					//ends here
				}
				String patient_class		= dir_bean.getPatientClass();
				if(patient_class.equals("")||patient_class==null){
					patient_class="XT";
				}
				String dispense_location_code=dir_bean.getDispLocnCode();
				String store_code			= dir_bean.getStoreCode(dispense_location_code);
				String allow_without_diag	= request.getParameter("allow_without_diag");
				if(allow_without_diag==null) 
					allow_without_diag	=	"Y";
				if(bsa==null) 
					bsa	=	"";
				if(priority==null)	 
					priority	=	"";
				//Parameters--End-->
				//Variable Declaration starts-->
				ArrayList presDetails					=	null;
				HashMap drugDetails						=	null;
				String	extdrugCode						=	"";
				String	srlNo							=	"";
				String	allow_duplicate					=	"";
				String	drug_desc						=	"";
				String	generic_id						=	"";
				String	generic_name					=	"";
				String	form_code						=	"";
				String	form_desc						=	"";
				String	route_code						=	"";
				String	pres_base_uom					=	"";
				String	pres_base_uom_desc				=	"";
				String	strength_value					=	"";
				String	strength_uom					=	"";
				String	strength_uom_desc				=	"";
				String	strength_per_pres_uom			=   "";
				String	strength_per_value_pres_uom		= 	"";
				String	ord_auth_reqd_yn				= 	"";
				String	ord_spl_appr_reqd_yn			= 	"";
				String	ord_cosign_reqd_yn				= 	"";
				String	auth_yn_val						= 	"";
				String	approval_yn_val					= 	"";
				String	cosign_yn_val					= 	"";
				String	auth_yn							= 	"";
				String	approval_yn						= 	"";
				String	cosign_yn						= 	"";
				String	consent_reqd_yn					= 	"";
				String	limit_ind						= 	"";
				String	daily_dose						= 	"";
				String	unit_dose						= 	"";
				String	min_daily_dose					= 	"";
				String	min_unit_dose					= 	"";
				String	mono_graph						= 	"";
				String	qty_value						=   "";
				String	tab_qty_value					= 	"";
				String	freq_code						= 	"";
				String	durn_value						= 	"";
				String	durn_desc						= 	"";
				boolean modify_durn_desc				=	false;
				String	consider_stock_for_pres_yn		= 	"";
				String	qty_desc_code					= 	"";
				String	item_code						= 	"";
				String	chk_for_max_durn_action			= 	"";
				String	qty_reqd_yn						= 	"";
				String	max_durn_value					= 	"";
				String	allergy_yn						= 	"";
				String	refill_cont_order_yn			= 	"";
				String	start_date						= 	"";
				String	end_date						= 	"";
				String	dosage_type						= 	"";
				String	scheduled_yn					= 	"";
				String	ori_dosage_type					=   "";
				String	repeat_durn_type				= 	"";
				String	max_refills_for_pres			= 	"";
				String	order_type_code					= 	"";
				String	back_date						= 	"";
				String	future_date						= 	"";
				String	split_dose_yn					= 	"";
				String	rowVal							= 	"";
				String	max_durn_for_refill_pres		= 	"";
				String	no_refill						= 	"";
				String	refill_start_date				= 	"";
				String	refill_end_date					= 	"";
				String	admin_time						= 	"";
				String	admin_qty						= 	"";
				String	repeat_value					=   "";
				String	freq_nature						= 	"";
				String	allergy_override				= 	"";
				String	dose_override					= 	"";
				String	currentrx_override				= 	"";
				String	current_rx						= 	"";
				String	dflt_qty_uom					= 	"";
				String	tappered_over					= 	"";
				String	sch_over_yn						= 	"";
				String	disp_locn_code					= 	"";
				String	amend_yn						= 	"";
				String	stock_uom						= 	"";
				String	absol_qty						= 	"";
				String	prn_dose						= 	"";
				String dosage_option					=	"";
				String dosage_legend					=	"";
				String qty_option						=	"";
				String freq_option						=	"";				
				String duration_option					=	"";
				HashMap chkValuescheduleFrequency		=	null;
				ArrayList frequencyValues				=	null;
				String calendar_status					=	"";
				String route_option						=	"";
				HashMap taperDateParams					=	null;
				String schedule_status					=	"";	
				String absol_qty_status					=	"";
				String refill_status					=	"disabled";
				String qty_legend_style					=	"visibility:hidden";
				String interval_value					=	"";
				String calc_by_ind						=	"";
				String dosage_std						=	"";
				String dosage_unit						=	"";
				String recomm_yn						=	"";
				String orig_current_rx					=	"";
				String prn_remarks						=	"";
				String Disable_recc_dose				=   "";
				String split_dose_yn_val				=   "N";
				String override_chk						=	"N";
				String override_checked					=	"";
				String override_chk_disabled			=	"";
				String external_product_id				=	"";
				ArrayList exProd						=	new ArrayList();
				ArrayList drugDesc						=	new ArrayList();
				String loading_ext_prod_id				=	"";
				String perform_external_database_checks_yn	=	"";	
				String external_dosage_override_reason		=   "";	
				String external_duplicate_override_reason	=   "";
				String external_interaction_override_reason	=   "";
				String external_contra_override_reason		=   ""; 
				String external_alergy_override_reason		=   ""; 
				String fract_dose_round_up_yn				=   "";
				String drug_db_dosage_check_flag			=   "N";
				String trade_code							=	"";
				String physical_inv_item_yn                 =   "";
				boolean def_freq_found						=	false;
				boolean def_freq_not_found                   =   false; //added for GHL-CRF-0508
				Hashtable DurnDescDetails					=   new Hashtable();	
				String actionText							=	""; // add for SKR-CRF-0006[IN029561]
				String default_dosage_by					=	""; //add this for SKR-CRF-PHIS-003[IN028182]
				String recomm_dosage_by                     =""; // Added for ML-MMOH-CRF-0978           
				String 		DrugIndicationRemarks				=   "";// ML-BRU-CRF-072[Inc:29938] 
				String 		default_route_yn				=   "";// Added for  RUT-SCF-0237 [IN:038115]
				String interaction_exists				=	"", intr_restric_trn="N", intr_msg_content="", interaction_override ="", severity_level="" ;  // added for FD-RUT-CRF-0066.1 [IN036975]
				//Added for IN:070451 start
				String      max_daily_ceeling_dose	    =   "";
				String		min_daily_ceeling_dose	    =   "";
				String		max_unit_ceeling_dose	    =   "";
				String		min_unit_ceeling_dose	    =   "";
				String dose_unit_desc = ""; 
				String dose_unit_desc1 = "";
				
				//Added for IN:070451 end	
				//Added for IN:072715 start
				String allergy_remarks_code				= "";
				String dose_remarks_code				= "";
				String currentrx_remarks_code			= "";
				String interaction_remarks_code	    =   "";
				String food_interaction_remarks_code	    =   "";
				String lab_interaction_remarks_code	    =   "";
				String		disease_interaction_remarks	    =   "";//Added for MMS-DM-CRF-0299
	            String		disease_interaction_remarks_code	    =   "";//Added for MMS-DM-CRF-0229
				//Added for IN:072715 end
				//Object Initialization starts-->
				//String or_bean_name				= "eOR.OrderEntryBean";
				//String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
				//OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request);
				//orbean.setLanguageId(locale);

				ArrayList diagnosis				=  dir_bean.checkDiagnosis(patient_id);
				int diag_size					= (diagnosis).size();  
				String mode						=  CommonRepository.getCommonKeyValue( "MODE_INSERT" );
				int take_home					=  0;	//bean.getHomeMecdicationYn(encounter_id,(String)session.getValue("facility_id"));
				String ph_version				=	(String)PhLicenceRights.getKey();
				barcode_yn              = dir_bean.getBarCodeflg(facility_id, dir_bean.getDispLocnCode());// Added for MMS-DM-CRF-0112.1 [IN:065216] -Start
				if(calling_mode.equalsIgnoreCase("modify") && barcode_yn.equalsIgnoreCase("Y"))
					barcodeDisable ="disabled";
				String gender ="";
				String date_of_birth ="";
				if(barcode_yn.equalsIgnoreCase("Y")){
				 ArrayList pat_details	=   dir_bean.getPatientDetails1(patient_id);
				 if(pat_details.size()>=3){
					 gender	=	(String)pat_details.get(2);
					 gender	=	gender.substring(0,1).toUpperCase();
					 date_of_birth	=	(String)pat_details.get(3);
				 }	
				} // Added for MMS-DM-CRF-0112.1 [IN:065216] - End
				//Object initialization ends-->
				//Drug Attributes starts-->
				if(!calling_mode.equals("blank")){
					presDetails					= (ArrayList) dir_bean.getpresDetails();
					chkValuescheduleFrequency	= dir_bean.getscheduleFrequency();		
					start_date					= hr_start_time;
				}

				String ex_bean_id   = "@ExternalProductLinkBean";
				String ex_bean_name = "ePH.ExternalProductLinkBean";
				ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
				beanex.setLanguageId(locale);
				String approval_no = "";//AAKH-CRF-0117
				if(presDetails!=null && presDetails.size()>0){
					for(int i=0;i<presDetails.size();i++){
						drugDetails					= (HashMap)presDetails.get(i);
						extdrugCode					= (String)drugDetails.get("DRUG_CODE");
						srlNo						= (String)drugDetails.get("SRL_NO");
						external_product_id			= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
						drug_desc					= (String) drugDetails.get("DRUG_DESC");
						drug_db_dosage_check_flag	= (String) drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	
						if(external_product_id!=null&& !external_product_id.equals("")) {
						   drugDesc.add(drug_desc);
						   exProd.add(external_product_id);
						}
						approval_no = "";//AAKH-CRF-0117	
						//out.println((HashMap)drugDetails.get("SEL_BATCHES")==null?"":(HashMap)drugDetails.get("SEL_BATCHES"));
						if(extdrugCode.equals(drug_code) && srlNo.equals(srl_no) ){

							perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");	
							loading_ext_prod_id					= external_product_id;
							allow_duplicate						= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG")==null?"":(String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
							if(patient_class.equals("OP") || patient_class.equals("EM") || patient_class.equals("XT"))
								allow_duplicate						= (String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP")==null?"":(String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
							external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
							external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
							external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
							external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
							external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
			
							physical_inv_item_yn        = (String)drugDetails.get("PHY_INV_ITEM_YN");
					
							generic_id					= (String) drugDetails.get("GENERIC_ID");
							generic_name				= (String) drugDetails.get("GENERIC_NAME");

							form_code					= (String) drugDetails.get("FORM_CODE");
							form_desc					= (String) drugDetails.get("FORM_DESC");
							amend_yn					= (String)drugDetails.get("AMEND_YN");
							default_route_yn			= (String)drugDetails.get("DEFAULT_ROUTE_YN")==null?"":(String)drugDetails.get("DEFAULT_ROUTE_YN"); 
							if(amend_yn.equals("Y")||default_route_yn.equals("Y")) //if condition Added for RUT-SCF-0237 [IN:038115]
								route_code					= (String) drugDetails.get("ROUTE_CODE");
							pres_base_uom				= (String) drugDetails.get("PRES_BASE_UOM");
							pres_base_uom_desc			= (String) drugDetails.get("PRES_BASE_UOM_DESC");
							strength_value				= (String) drugDetails.get("STRENGTH_VALUE");
							strength_uom				= (String) drugDetails.get("STRENGTH_UOM");
							strength_uom_desc			= (String) drugDetails.get("STRENGTH_UOM_DESC");
							strength_per_pres_uom		= (String) drugDetails.get("STRENGTH_PER_PRES_UOM");
							strength_per_value_pres_uom	= (String) drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
							ord_auth_reqd_yn			= (String) drugDetails.get("ORD_AUTH_REQD_YN");
							ord_spl_appr_reqd_yn		= (String) drugDetails.get("ORD_SPL_APPR_REQD_YN");
							ord_cosign_reqd_yn			= (String) drugDetails.get("ORD_COSIGN_REQD_YN");
							auth_yn_val					= (String) drugDetails.get("AUTH_YN_VAL");
							approval_yn_val				= (String) drugDetails.get("APPROVAL_YN_VAL");
							cosign_yn_val				= (String) drugDetails.get("COSIGN_YN_VAL");
							auth_yn						= (String) drugDetails.get("AUTH_YN");
							approval_yn					= (String) drugDetails.get("APPROVAL_YN");
							cosign_yn					= (String) drugDetails.get("COSIGN_YN");
							consent_reqd_yn				= (String) drugDetails.get("CONSENT_REQD_YN");
							limit_ind					= (String) drugDetails.get("LIMIT_IND");
							daily_dose					= (String) drugDetails.get("DAILY_DOSE");
							unit_dose					= (String) drugDetails.get("UNIT_DOSE");
							dosage_std					= (String)drugDetails.get("DOSAGE_STD");    // Added for ML-MMOH-CRF-0978
							min_daily_dose				= (String) drugDetails.get("MIN_DAILY_DOSE");
							min_unit_dose				= (String) drugDetails.get("MIN_UNIT_DOSE"); 
							mono_graph					= (String) drugDetails.get("MONO_GRAPH");
							qty_value					= (String) drugDetails.get("QTY_VALUE");
							//Added for IN:070451 start
							max_daily_ceeling_dose		= drugDetails.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
							min_daily_ceeling_dose		= drugDetails.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
							max_unit_ceeling_dose		= drugDetails.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
							min_unit_ceeling_dose		= drugDetails.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
							String dosage_uom			= (String)drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
							if(!dosage_uom.equals("")){ 
						   dose_unit_desc      = dir_bean.getUomDisplay((String)session.getValue("facility_id"),dosage_uom); 
						   dose_unit_desc1 =dose_unit_desc;
	 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
	 						  dose_unit_desc = dir_bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_uom.split("/")[0]));
	 						 dose_unit_desc1 =dose_unit_desc;
						      dose_unit_desc =dose_unit_desc+"/"+(dosage_uom.split("/")[1]);
	 						} 
							}
					
							//Added for IN:070451 end
							//Added for IN:072715 start
					 		allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
					 		dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
							currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
							interaction_remarks_code				= (String) drugDetails.get("INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("INTERACTION_REMARKS_CODE");
							food_interaction_remarks_code				= (String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("FOOD_INTERACTION_REMARKS_CODE");
							lab_interaction_remarks_code				= (String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("LAB_INTERACTION_REMARKS_CODE");
							disease_interaction_remarks_code =(String) drugDetails.get("DISEASE_INTERACTION_REMARKS_CODE")==null?"":(String) drugDetails.get("DISEASE_INTERACTION_REMARKS_CODE");//Added for MMS-DM-CRF-0229
					        disease_interaction_remarks =(String) drugDetails.get("DISEASE_INTERACTION_REMARKS")==null?"":(String) drugDetails.get("DISEASE_INTERACTION_REMARKS");//Added for MMS-DM-CRF-0229
							//Added for IN:072715 end
							if(qty_value!=null && !qty_value.equals("") && Float.parseFloat(qty_value) <1)
								qty_value = Float.parseFloat(qty_value) +"" ;
							tab_qty_value				= (String) drugDetails.get("TAB_QTY_VALUE");
							freq_code					= (String) drugDetails.get("FREQ_CODE");
							//durn_value				= (String) drugDetails.get("DURN_VALUE");
							durn_desc					= (String) drugDetails.get("DURN_DESC");					
							durn_value		            =	((String)drugDetails.get("DURN_VALUE")).equals("0")?"1":(String)drugDetails.get("DURN_VALUE");
							
							recomm_yn					= ((String)drugDetails.get("RECOMM_YN"));
							consider_stock_for_pres_yn	= (String) drugDetails.get("CONSIDER_STOCK_FOR_PRES_YN");
							qty_desc_code				= (String) drugDetails.get("QTY_DESC_CODE");
							item_code					= (String) drugDetails.get("ITEM_CODE");
							chk_for_max_durn_action		= (String) drugDetails.get("CHK_FOR_MAX_DURN_ACTION");
							qty_reqd_yn					= (String) drugDetails.get("QTY_REQD_YN");
							max_durn_value				= (String) drugDetails.get("MAX_DURN_VALUE");
							allergy_yn					= (String) drugDetails.get("ALLERGY_YN");
							refill_cont_order_yn		= (String) drugDetails.get("REFILL_CONT_ORDER_YN");
							start_date					= (String) drugDetails.get("START_DATE");
							//end_date					= (String) drugDetails.get("END_DATE");
							
							end_date		            =	((String)drugDetails.get("END_DATE"))==null?"":(String)drugDetails.get("END_DATE");
						
							dosage_type					= (String) drugDetails.get("DOSAGE_TYPE");
							scheduled_yn				= (String) drugDetails.get("SCHEDULED_YN");
							ori_dosage_type				= (String) drugDetails.get("ORI_DOSAGE_TYPE");
												
							repeat_durn_type			= (String) drugDetails.get("REPEAT_DURN_TYPE");
							max_refills_for_pres		= (String) drugDetails.get("MAX_REFILLS_FOR_PRES");
							order_type_code				= (String) drugDetails.get("ORDER_TYPE_CODE");
							back_date					= (String) drugDetails.get("BACK_DATE");
							future_date					= (String) drugDetails.get("FUTURE_DATE");
							split_dose_yn				= (String) drugDetails.get("SPLIT_DOSE_YN");
							split_dose_yn_val			= CommonBean.checkForNull(((String) drugDetails.get("SPLIT_DOSE_YN_VAL")),"N");
							rowVal						= (String) drugDetails.get("rowVal");
							max_durn_for_refill_pres	= (String) drugDetails.get("MAX_DURN_FOR_REFILL_PRES");
							no_refill					= (String) drugDetails.get("NO_REFILL");
							refill_start_date			= (String) drugDetails.get("REFILL_START_DATE");
							refill_end_date				= (String) drugDetails.get("REFILL_END_DATE");
							admin_time					= (String) drugDetails.get("ADMIN_TIME");
							admin_qty					= (String) drugDetails.get("ADMIN_QTY");
							repeat_value				= (String) drugDetails.get("REPEAT_VALUE");
							freq_nature		            =		((String)drugDetails.get("FREQ_NATURE"))==null?"":(String)drugDetails.get("FREQ_NATURE");
			
							allergy_override			= (String) drugDetails.get("ALLERGY_OVERRIDE");
							dose_override				= (String) drugDetails.get("DOSE_OVERRIDE");
							currentrx_override			= (String) drugDetails.get("CURRENTRX_OVERRIDE");
							current_rx					= (String) drugDetails.get("CURRENT_RX");
							fract_dose_round_up_yn      = (String) drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
							
							if(current_rx.equals("Y") && !drugDetails.containsKey("ORIG_CURRENT_RX")) {
								drugDetails.put("ORIG_CURRENT_RX","Y");							
							}
							if( drugDetails.containsKey("ORIG_CURRENT_RX") && ((String)drugDetails.get("ORIG_CURRENT_RX")).equals("Y") ) {
								orig_current_rx	=	(String)drugDetails.get("ORIG_CURRENT_RX");
							}

							dflt_qty_uom				= (String) drugDetails.get("DFLT_QTY_UOM");
							tappered_over				= (String)drugDetails.get("TAPPERED_OVER");
							sch_over_yn					= (String)drugDetails.get("SCH_OVER_YN");
							disp_locn_code				= (String)drugDetails.get("DISP_LOCN_CODE");
							stock_uom					= (String)drugDetails.get("STOCK_UOM_DESC");
							absol_qty					= (String)drugDetails.get("ABSOL_QTY"); 
							prn_dose					= (String)drugDetails.get("PRN_DOSES_PRES_PRD_FILL");
							//priority					= (String)drugDetails.get("PRIORITY");	
							interval_value				= (String)drugDetails.get("INTERVAL_VALUE");
							calc_by_ind					= (String)drugDetails.get("CALC_BY_IND");
							dosage_std					= (String)drugDetails.get("DOSAGE_STD");
							dosage_unit					= (String)drugDetails.get("DOSAGE_UNIT");
							trade_code				    = (String)drugDetails.get("TRADE_CODE");
							//added for AAKH-CRF-0117 - start
							approval_no					= (String)drugDetails.get("approval_no");
							if(approval_no==null)
								approval_no = "";
							//added for AAKH-CRF-0117 - end
							default_dosage_by			= (String)drugDetails.get("DEFAULT_DOSAGE_BY")==null?"":(String)drugDetails.get("DEFAULT_DOSAGE_BY");//add this for SKR-CRF-PHIS-003[IN028182]
							recomm_dosage_by			= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY"); // Added for ML-MMOH-CRF-0978 -Start
							if(recomm_dosage_by.equals("B"))
								recomm_dosage_by = "Q";   // Added for ML-MMOH-CRF-0978 -End
							DrugIndicationRemarks				= (String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");//Newly Added   For ML-BRU-CRF-072[Inc:29938]
							weight_rec_appl_age_group_check_flag =  drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG")== null?"":(String) drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG"); //added for Bru-HIMS-CRF-079 IN[029945]
							wt_mand_yn =  drugDetails.get("WT_MAND_YN")== null?"":(String) drugDetails.get("WT_MAND_YN"); //added for Bru-HIMS-CRF-079 IN[029945]
							ht_mand_yn =  drugDetails.get("HT_MAND_YN")== null?"":(String) drugDetails.get("HT_MAND_YN"); //added for Bru-HIMS-CRF-079 IN[029945]
							if(!DrugIndicationRemarks.equals(""))
								DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); ;
							interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS");// added for FD-RUT-CRF-0066.1 [IN036975] -Start
							intr_restric_trn			= (String) drugDetails.get("INTR_RESTRIC_TRN")==null?"N": (String) drugDetails.get("INTR_RESTRIC_TRN");
							severity_level				= (String) drugDetails.get("SEVERITY_LEVEL")==null?"": (String) drugDetails.get("SEVERITY_LEVEL");
							intr_msg_content			= (String) drugDetails.get("INTR_MSG_CONTENT")==null?"": (String) drugDetails.get("INTR_MSG_CONTENT"); // added for FD-RUT-CRF-0066.1 [IN036975] -end

							if(amend_yn.equals("Y")){
								if(drugDetails.containsKey("override_chk")){

									 override_chk		= (String) drugDetails.get("override_chk");
									 if(override_chk.equals("Y")){
										override_checked		="checked";
										override_chk_disabled	="disabled";
									 }
								}
							}
							if(prn_dose==null || prn_dose.equals("") || prn_dose.equals("0")) {
								prn_dose	=	"1";
							}						
							if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
								strength_value = Float.parseFloat(strength_value) +"" ;
				
							if(strength_value.equals("0"))
								strength_value			=	"";

							if(limit_ind==null)
									limit_ind	=	"Y";
					
							if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
								frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
							}	
							//out.println("==chkValuescheduleFrequency=="+chkValuescheduleFrequency);						
							if(freq_nature.equals("P") && absol_qty==null) {
								absol_qty		=	prn_dose;	
							}
							if(absol_qty==null || absol_qty.equals("0"))
								absol_qty		=	"1";

							if(calling_mode.equals("taper")){
								taperDateParams	=(HashMap)dir_bean.populateTaperDates(end_date,durn_value,repeat_durn_type);
								if(taperDateParams.size()>0){
									start_date	=(String) taperDateParams.get("taper_start_date");
									end_date	=(String) taperDateParams.get("taper_end_date");
								}
							}
							break;
						}
					}
					HashMap drug_Interactions				= null;
					String drug_db_interact_check_flag	= "N";
					String drug_db_duptherapy_flag		= "N";
					String drug_db_contraind_check_flag	= "N";
					String dup_drug_det					= "";
					String drug_alergy_det                = "";
					String drug_db_alergy_check_flag	    = "N";
					//Added for FBD Tuning - Start
					if(perform_external_database_checks_yn.equals("Y") && exProd.size()>0){
						if(drug_db_duptherapy_yn.equals("Y")||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
							HashMap tempDetails= null;
							HashMap drugDBCheckResult= null;
							ArrayList reqChecks = new ArrayList();
							reqChecks.add("N"); //Dosage Check 
							reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
							reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
							reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
							reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
							drugDBCheckResult = beanex.getExternalDBChecks( reqChecks, loading_ext_prod_id, patient_id, "", exProd ,drugDesc, null, "Y", start_date, end_date); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
							if(drugDBCheckResult!=null)
								beanex.setExternalDBCheckResult(loading_ext_prod_id,srl_no,drugDBCheckResult);

							if(drug_db_allergy_check_yn.equals("Y")){
							   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
								   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
								   if(allergy_alert!=null && !allergy_alert.equals(""))
										drug_db_alergy_check_flag="Y";
							   } 
							   else {  
									tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
									if(tempDetails!=null && tempDetails.size()>0){
										 drug_db_alergy_check_flag="Y";
									}
								} 
							}

							if(drug_db_interact_check_yn.equals("Y")){
								tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
								if(tempDetails!=null && tempDetails.size()>0){
									 drug_db_interact_check_flag="Y";
								}
								else									
									 drug_db_interact_check_flag="N";
							}

							if(drug_db_duptherapy_yn.equals("Y")){ 
							   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
							   if(dup_drug_det!=null && !dup_drug_det.equals(""))
									drug_db_duptherapy_flag="Y";
							   else{
									drug_db_duptherapy_flag="N";
							   }
							}
							if(drug_db_contraind_check_yn.equals("Y")){
								if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // addign start for IN066787- Performance
							             tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */

						         if(tempDetails!=null && tempDetails.size()>0){ //IN066787- Performance
							          drug_db_contraind_check_flag="Y";
						        }
							}else{//Adding end for IN066787- Performance
								tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
								if(tempDetails!=null && tempDetails.containsKey(loading_ext_prod_id)){
									drug_db_contraind_check_flag="Y";
								}		
								else
									drug_db_contraind_check_flag="N";
							}
						}
					}
						//Commented for FBD Tuning - End
						/* //Commented for FBD Tuning - Start
						//setting druug codes in external product link bean
						if(exProd.size()>0)
							beanex.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids
						}	
						//code for drug interaction check
						if(perform_external_database_checks_yn.equals("Y")){
							if(drug_db_interact_check_yn.equals("Y")){
								  if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
									   beanex.getDDInteractions(loading_ext_prod_id);//Store interactions
											drug_Interactions		= beanex.getInteractions();//get Interactions
											if(drug_Interactions.size()>0){							
											   drug_db_interact_check_flag="Y";
											}
								  }
							}
							if(drug_db_duptherapy_yn.equals("Y")){ 
								dup_drug_det			= beanex.isDuplicateTherapy(external_product_id);//get dupluicate theraphy result
								if(!dup_drug_det.equals("")&&dup_drug_det!=null)
									drug_db_duptherapy_flag="Y";
							}

							if(drug_db_contraind_check_yn.equals("Y")){
								ArrayList ex_prod_ids =new ArrayList();
								ex_prod_ids.add(loading_ext_prod_id);

								  boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
								  HashMap contra_indications =(HashMap)beanex.getContraIndications();
								  if(contra_indications.containsKey(external_product_id)){
									 drug_db_contraind_check_flag="Y";
								  }					  
							} 
							
							if(drug_db_allergy_check_yn.equals("Y")){
							   ArrayList ex_prod_ids =new ArrayList();
							   ex_prod_ids.add(loading_ext_prod_id);
							   beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result


								HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
								  if(drug_alergies.containsKey(external_product_id)){
									 drug_db_alergy_check_flag="Y";
								  }	
							*/ //Commented for FBD Tuning - End
						}
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN",drug_db_alergy_check_flag);
					}
					//delete frequency on reset/without confirm
					if(frequencyValues!=null && frequencyValues.size()>0 && scheduled_yn.equals("N")) {
						dir_bean.getclearscheduleFrequency(drug_code+srl_no);
						frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(drug_code+srl_no);
						//frequencyValues			=	(ArrayList)dir_bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
					}

					// enable/disable calendar gif
					if(start_date==null || start_date.equals(""))
						calendar_status	=	"disabled";	
						/*ArrayList	active_orders		=	dir_bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
						StringBuffer drug_description	=	new StringBuffer();
						int size						=	active_orders.size();
						HashMap	record					=	new HashMap();

							for(int i=0; i<size; i++)	{
								record					=	(HashMap)active_orders.get(i);
								drug_description.append((String)record.get("drug_desc"));
								drug_description.append(" , ");
							}*/	
						// load applicable routes
						//Code Added CRF - 0034 Start
						if(!calling_mode.equals("blank")) {	
							if(route_code==null || route_code.equals ("") ) //added for RUT-SCF-0237 [IN:038115]
								route_option= route_option + "<option value='' selected>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
							else
								actionText = dir_bean.getActionText(form_code,route_code); //add for SKR-CRF-0006[IN029561]
							ArrayList routes				=	dir_bean.getRoutes(form_code); 
							for(int l=0; l<routes.size(); l+=3) { 
								String backgrndColor="FFFFFF";
								String fntColor="000000";
								String route_color = (String)routes.get(l+2);
								if(route_color!= null && route_color!= ""){
									if(route_color.length()==12){
										fntColor= route_color.substring(0, 6);
										backgrndColor= route_color.substring(6, 12);
									}
								}
								//Code Added CRF -0034 End
								if( ((String)routes.get(l)).equals(route_code)) {  
									route_option	+="<option style='color:"+fntColor+";background-color:"+backgrndColor+";' value='"+(String)routes.get(l)+"' selected>"+(String)routes.get(l+1)+"</option>";  //style Added CRF -0034
								} 
								else {	
									route_option	+="<option value='"+(String)routes.get(l)+"' style='color:"+fntColor+";background-color:"+backgrndColor+";'>"+(String)routes.get(l+1)+"</option>"; //style Added CRF -0034
								}	
							}
						}
							
					
						// Legend and dosage unit is controlled based on dosage type
						if(dosage_type.equals("A")){ 
							dosage_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels");
							dosage_option	=	"<option value='A' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Absolute.label","common_labels")+"</option>";
						}
						else if(dosage_type.equals("S")){ 
							dosage_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Strength.label","common_labels");
							dosage_option	= "<option value='S' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels")+"</option><option value='Q'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels")+"</option>";
						}
						else if(dosage_type.equals("Q")){  
							dosage_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Dose.label","ph_labels");
							if(ori_dosage_type.equals("S")){
								dosage_option	=	"<option value='S'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Strength.label","common_labels")+"</option><option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels")+"</option>";
							}
							else{
								dosage_option	=	"<option value='Q' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Quantity.label","common_labels")+"</option>";
							}		
						}

						// Get the unit dose for scheduled
						if(!calling_mode.equals("blank") && split_dose_yn.equals("N")) {
							ArrayList schedule	=	(ArrayList)dir_bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
							if(schedule.size() > 0) {
								 /*HashMap detail	=	(HashMap)schedule.get(0);
								 qty_value		=	(String)detail.get("admin_qty");*/
								 ArrayList dose_list		= (ArrayList)schedule.get(4);
								 if(dose_list.size()>0) {
									qty_value		= (String)dose_list.get(0);
									if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										qty_value="1";
								 }
								 else {
									 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
										 qty_value="1";
								 }
							}
						}
						//out.println("Qty Value="+qty_value);
						// Default Strength uom
						if(dosage_type.equals("S")){
							qty_option	=	"<option value='"+strength_uom+"' selected>"+strength_uom_desc+"</option>";
						}
						boolean dup_found	=	false;
						// Load Frequency
						
						if(!calling_mode.equals("blank")) {	
							HashMap freqValues	=	(HashMap)dir_bean.populateFrequencyValues(drug_code,freq_code,calling_mode,patient_class);
							if(orig_current_rx.equals("Y") && allow_duplicate.equals("N")) { // && (patient_class.equals("IP") || take_home>0)
								dup_found	=	true;
							}
							ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
							ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
							ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");
							if(freqValues.size()>0 && (dup_found) && amend_yn.equals("Y")){ 
								if(allow_duplicate.equals("N")){
									ArrayList stat_freqs	=	dir_bean.loadStatFreqs();			
									for(int i=0;i<stat_freqs.size();i+=2){
										if(freq_code.equals((String) stat_freqs.get(i))){
											freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
											freq_code	    = ((String) stat_freqs.get(i));
										}
										else{
											freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"' >"+((String) stat_freqs.get(i+1))+"</option>";
										}
										freq_nature	    = "O";
										//def_freq_found = true;
									}
								}
								else{
									for(int i=0;i<freqCode.size();i++){
										if( dup_found  && !amend_yn.equals("Y")) {
											if( ((String) FreqNature.get(i)).equals("O")) {//dir_bean.getFreqNature(((String) freqCode.get(i))))
												freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
												freq_nature	    = "O";
												freq_code	    = ((String) freqCode.get(i));
												def_freq_found  = true;
											}
										}
										else {
											if(((String) freqCode.get(i)).equals(freq_code)) {
												freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
												def_freq_found  = true;
											} 
											else {
												freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
											}
										}
									}
								} 
							}
							else if(freqValues.size()>0 ){ 
								def_freq_not_found = true;//Added for GHL-CRF-0508
								for(int i=0;i<freqCode.size();i++){
									if( dup_found && !amend_yn.equals("Y")) {
										if( ((String) FreqNature.get(i)).equals("O")) {//(dir_bean.getFreqNature(((String) freqCode.get(i))))
											freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
											freq_nature	=	"O";
											freq_code	=((String) freqCode.get(i));
											def_freq_found = true;
										}
									} 
									else {
										if(((String) freqCode.get(i)).equals(freq_code)) {
											freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
											def_freq_found = true;
											def_freq_not_found= false;
										} 
										else {
											//Added for GHL-CRF-0508 start
											if(default_freq_not_found){
				 							if(def_freq_not_found){ 
				 							    freq_option  += "<option value='' selected>&nbsp;&nbsp;&nbsp;---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.defaultSelect.label", "common_labels")+"---&nbsp;&nbsp;&nbsp;</option>";
				 							   def_freq_not_found = false;
				 							}	
										}
											//Added for GHL-CRF-0508 end	
										freq_option		+=	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
										}
									}
								}
							}
							else if(dup_found) {
								ArrayList stat_freqs	=	dir_bean.loadStatFreqs();					
								for(int i=0;i<stat_freqs.size();i+=2){
									freq_option		+=	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
									freq_nature	=	"O";
									freq_code	=((String) stat_freqs.get(i));
								}
							} 
							
							if(freq_option.equals("")) {
								ArrayList stat_freqs	=	dir_bean.loadStatFreqs();					
						
								for(int i=0;i<stat_freqs.size();i+=2){
									freq_option		+=	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
									freq_nature	=	"O";
									freq_code	=((String) stat_freqs.get(i));
								}
							}
						}
						
						// Duration values
						modify_durn_desc=false;
						if(!calling_mode.equals("blank")) {	
							durn_desc=durn_desc.substring(0,1);
							DurnDescDetails	= (Hashtable)dir_bean.loadDurnDesc();
							Enumeration keys_des		= DurnDescDetails.keys();
							String	durn_code			= "";
							if(durn_desc.equals(repeat_durn_type)){	
								while(keys_des.hasMoreElements()){
									durn_code		= (String)keys_des.nextElement();
									duration_option	+= "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
								}
							}
							else{		
								modify_durn_desc=true;			
							}
						}

						if(dosage_type.equals("A")) {
							//schedule_status		=	"disabled";
							absol_qty_status	=	"enabled";
						} 
						else {
							if(!freq_nature.equals("P"))
								absol_qty			=	"";
						}

						if(scheduled_yn.equals("N")) {
							schedule_status		=	"disabled";
						}

						// enable/disable refill button
						if(refill_cont_order_yn!=null && refill_cont_order_yn.equals("Y")){
							refill_status="";
						}

						// enable/disable order quantity legend
						if(dosage_type.equals("A") || freq_nature.equals("P")) {
							qty_legend_style	=	"visibility:visible";
						}
						if(split_dose_yn.equals("N") && (!dosage_type.equals(recomm_dosage_by)) && default_recm_dose_yn){  // Added for ML-MMOH-CRF-0978 - Start
							 Disable_recc_dose="disabled";
						} // Added for ML-MMOH-CRF-0978 - End
						else if(split_dose_yn.equals("Y")){
							Disable_recc_dose="disabled";
						}
						if(priority.equalsIgnoreCase("R"))
							priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
						else if(priority.equalsIgnoreCase("U"))
							priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
						//Drug Attributes ends-->
%>
						<input type="hidden" name="bean_id" id="bean_id"					value="<%=dir_bean_id%>">
						<input type="hidden" name="bean_name" id="bean_name"				value="<%=dir_bean_name %>">
						<input type="hidden" name="patient_id" id="patient_id"				value="<%= patient_id %>">
						<input type="hidden" name="encounter_id" id="encounter_id"			value="<%= encounter_id %>">
						<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
						<input type="hidden" name="patient_class" id="patient_class"			value="<%=patient_class%>">
						<!-- Below table for CurrentRx details-->
						<table border="0" width="100%" cellspacing="0" cellpadding="0">
							<tr>
								<td  width="5%"  >
								<input type="button" class="button" value='<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/> '  onClick="javascript:callActiveOrders('<%=patient_id%>','<%=encounter_id%>');"></td>
								<% if(barcode_yn.equalsIgnoreCase("Y")){// if else condition Added for MMS-DM-CRF-0112.1 [IN:065216]  - Start 
									if(!((allow_without_diag.equals("Y")) ||(allow_without_diag.equals("N") && diag_size!=0) || patient_class.equals("XT"))){
										barcodeDisable ="disabled";
									}
								%>
								<td   style="font-family:verdana;font-size:8pt;COLOR:navy;" onload="setfldFocus('<%=barcode_yn%>')" width="5%" class="CURRTEXTSL" align="left"><fmt:message key="ePH.BarCode.label" bundle="${ph_labels}"/></td>
			                                        <td align="left" style="color:navy;" class="CURRTEXTSL"><input type="text" class='CURRTEXTSL' name="barcode_id" width="10%" style="text-align:right;" onkeydown="if (event.keyCode==13) {SearchDrugBasedOnBarcode(document.prescription_detail_form.barcode_id,'<%=patient_id%>','<%=gender%>','<%=date_of_birth%>');}" maxlength="100" size=80 <%=barcodeDisable%> autofocus></td>
			                    <!--Modified for IN073611 increased size and maxlength from 50 to 100 -->
								<%}else{ %>
								<td class="CURRTEXTSL"  width="80%">&nbsp;</td>
								<%} // if else condition Added for MMS-DM-CRF-0112.1 [IN:065216]  - End 
								if(approval_no_flag){ //AAKH-CRF-0117
								%>
								 <!-- added for AAKH-CRF-0117-->
								<td class= "CURRTEXTSL" width="5%" style="font-size:9" nowrap> <fmt:message key="ePH.ApprovalNo.label" bundle="${ph_labels}"/> <!-- nowrap added for AAKH-CRF-0117--> <input type ="text" value="<%=approval_no%>" name="approval_no" maxlength="20" align="left" onKeyPress="return KeyPressSpecCharsForApprovalNo(event)" onBlur="CheckForSpecCharApprovalno(this,'H');" /><!-- modified AAKH-CRF-0117 -->
								</td> <!-- AAKH-CRF-0117 -->
								<%}%>
								<td class="label"  width="20%" ><input type="button" name="allergies" id="allergies" class="BUTTON" value ="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allergies.label","common_labels")%>" onClick='callAllergies("<%=patient_id%>")'>&nbsp;<!-- Allergies button is added for RUT-CRF-0065.1 [IN:43255] -->
								<input type='button' class='button' onClick="showDrugProfile('<%=patient_id%>','Prescription','<%=encounter_id%>')" value='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'></td>  <!-- encounter_id added for AAKH-CRF-0088.2 -->
							</tr>
						</table>
						<!--CurrentRx table ends-->
						<!-- Prescription Writer Table starts-->
<%
						if((allow_without_diag.equals("Y")) ||(allow_without_diag.equals("N") && diag_size!=0) || patient_class.equals("XT")){
							String recom_value = "";  // Added for ML-MMOH-CRF-0978 - Start
							if(calc_by_ind.equals("A")) {	
								recom_value	= dosage_std;
							} 
							else if(calc_by_ind.equals("W")) {
								 recom_value	=	String.valueOf(Integer.parseInt(weight)*Integer.parseInt(dosage_std));
							}
							else if(calc_by_ind.equals("B")) {
								 recom_value	=	String.valueOf(Integer.parseInt(bsa)*Integer.parseInt(dosage_std));
							} 
							
						  if(dosage_unit.length()>=1){ 
							  dosage_unit                 = dir_bean.getUOMDesc(dosage_unit.split("/")[0])==null?"":dir_bean.getUOMDesc(dosage_unit.split("/")[0]);
						  }  
						  // Added for ML-MMOH-CRF-0978 - End
							if(allergic_yn.equals("N")||allergic_yn.equals("")){
%>
								<table cellpadding='0' cellspacing='0' width="100%" align="center" border="0">
									<th colspan="6" style="font-size:9" align="left"><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/>
									</th> 
									<tr>
										<td class="label"  width="12%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
										<td class="label" width="35%" colspan="3"><input type="text" name="drug_name" id="drug_name" size="42"  maxlength="42" value="<%=drug_desc%>" ><input type="button" name="drug_search" id="drug_search" value="?" class="button"   onClick="searchDrugName(document.prescription_detail_form.drug_name);" >&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
										</td>
<%
										if(!calling_mode.equals("blank")) {	
											
										if(over_ride_remarks_select_appl){
%>
											<td class="label"   colspan="3"><input type="button" class="button" value='<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/>' name="dosage_limit"  id="dosage_limit" style="<%=dis1%>" onclick="showOverRideRemarks(document.prescription_detail_form)" >&nbsp;<input type="checkbox"  name="override_chk" id="override_chk" value='<%=override_chk%>' <%=override_checked%>  onClick="showOverRideRemarks(document.prescription_detail_form)"  <%=override_chk_disabled%>  style="<%=dis1%>"></td><!-- Added for IN:072715  -->
											<%} else{ %>
											<td class="label"   colspan="3"><input type="button" class="button" value='<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/>' name="dosage_limit"  id="dosage_limit" style="<%=dis1%>" onclick="showOverRideRemarks(document.prescription_detail_form)" >&nbsp;<input type="checkbox"  name="override_chk" id="override_chk" value='<%=override_chk%>' <%=override_checked%>  onClick='updateValue(this)'  <%=override_chk_disabled%>  style="<%=dis1%>"></td>
<%
										}}
										else{
%>
											<td class="label"   colspan="3"></td>
<%
										}
%>
									</tr>
									<tr>
										<td class="label"  width="12%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td> 
										<!-- <td class="data" id="strength" width="18%">&nbsp;&nbsp;<%=strength_value%>&nbsp;<%=strength_uom%></td> commented on 8/10/09-->
										<td class="data" id="strength" width="18%">&nbsp;&nbsp;<%=strength_value%>&nbsp;<%=dir_bean.getUomDisplay(facility_id,strength_uom)%></td> 
										<td class="label" width="22%" colspan="2"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<label id="form" style="font-weight:bold"><%=form_desc%></label></td> 
										<td class="label"  width="35%" colspan='3'><fmt:message key="Common.Route.label" bundle="${common_labels}"/>&nbsp;&nbsp;<select name="route_code" id="route_code" onChange="getFormatId(this);getActionText(this,'<%=form_code%>');"  > <!-- add getActionText function for SKR-CRF-0006[IN029561]-->
<% 
										if(calling_mode.equals("blank")) { 
%> 
											<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
										} 
%>
										<%=route_option%>
										</select>
							
										&nbsp;<label  id="actionTextval"  style='color:red;' > <%=actionText%> </label><!-- add for SKR-CRF-0006[IN029561]-->
										<!-- Added for  ML-BRU-CRF-072[Inc:29938] start-->
										<br><a href="javascript:drugindication_remarks();" id="drug_ind_remarks" style="<%=dis%>" title='<fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a><!-- Added for  ML-BRU-CRF-072[Inc:29938] end-->
										</td>
									</tr>
									<th colspan="6" style="font-size:9" align="left" ><fmt:message key="ePH.Dosage/DurationDetail.label" bundle="${ph_labels}"/> </th>
									<tr>
										<td class="label" nowrap><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/>  </td>
										<td  class="label" colspan="2"><select name="dosage" id="dosage" onChange="dosageChange(this);ExternalDosageCheck();" >
<%
										if(calling_mode.equals("blank")) { 
%>
											<option value="">&nbsp;&nbsp;&nbsp;---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---&nbsp;&nbsp;&nbsp;</option>
<%
										}	
%>
										<%=dosage_option%>
										</select>
										</td>
<%
										if(split_dose_yn.equals("Y")){
%>
											<td class="label" colspan=2 ><input type="text" name="qty_value" id="qty_value" size="3" maxlength="7" class="NUMBER"  value="<%=qty_value%>" onBlur="lookForChange(this);ExternalDosageCheck();" onKeyPress="return allowValidNumber(this,event,6,6);">
<%
										}
										else{
%>
											<td class="label"  ><input type="text" name="qty_value" id="qty_value" size="3" maxlength="7" class="NUMBER"  value="<%=qty_value%>" onBlur="freqChange(frequency,'Y');ExternalDosageCheck();" onKeyPress="return allowValidNumber(this,event,6,6);">
<%
										}
%>
										<select name="qty_desc" id="qty_desc" style="width:110;" onchange="lookForChange(document.prescription_detail_form.qty_value)">
<% 		
										if(calling_mode.equals("blank")) { 
%>
											<option VALUE="">---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---</option>
<%	
										}	
%>
										<%=qty_option%>
										</select>
										</td>
										<td class="label"  name="dosage_label" id="dosage_label" colspan="2" >&nbsp;<%=dosage_legend%></td>
									</tr>
									<tr>
										<td class="label" ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td> 
										<td class="label" colspan ="6"><select name="frequency" id="frequency" onChange="freqChange(this,'Y');ExternalDosageCheck();removeRefill('<%=dir_bean_id%>','<%=dir_bean_name%>');" style="width:300px;"><!-- Modified for IN:069886 -->
<% 
										if(calling_mode.equals("blank")) { 
%>	
											<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%	
										}	
%>
										<%=freq_option%>
										</select>&nbsp;<input name="dis_split_dose" id="dis_split_dose" type="button" class="button" value= '<fmt:message key="Common.Schedule.label" bundle="${common_labels}"/> '   style="visibility:visible" name="split_dose" onClick="DisplaySchedule()" <%=schedule_status%>>
										</td>
									</tr>
									<tr>
										<td class="label" colspan="3">&nbsp;</td>
										<td  class="label"  nowrap><a href="javascript:callPRNDetails();" name="prn_remarks" id="prn_remarks" style="visibility:hidden" title="PRN Remarks"><fmt:message key="ePH.PRNRemarks.label" bundle="${ph_labels}"/></a><img align="center" style="visibility:hidden"  id="prn_remarks_image" src="../../eCommon/images/mandatory.gif"></img></td>
<%
										if(split_dose_yn.equals("N")){
%>
											<td class="label"   colspan="2"><a href="javascript:setRecommendDosage();" id="rec_legend" style="visibility:hidden" title="Recommended Dosage"onclick="changeschedule();"<%=Disable_recc_dose%>><fmt:message key="ePH.Recom.Dose.label" bundle="${ph_labels}"/>  </a>
											<label id="rec_value" name="rec_value" style="font-size:11;font-weight:bold;color:red"></label>
											&nbsp;<label id="rec_uom" style="font-size:11;font-weight:bold;color:red"></label></td> 
<%
										}
										else{
%>
											<td class="label"   colspan="2"><label id="rec_legend" style="font-size:11;font-weight:bold;color:red;visibility:hidden"  ><fmt:message key="ePH.Recom.Dose.label" bundle="${ph_labels}"/> </label>
											<label id="rec_value" name="rec_value" style="font-size:11;font-weight:bold;color:red;"></label>
											&nbsp;<label id="rec_uom" style="font-size:11;font-weight:bold;color:red"></label></td>
<%
										}
%>
									</tr>
									<tr>
										<td class="label" ><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
										<td class="label" ><input type="text" size="1" maxlength="3" name="durn_value" id="durn_value" class="NUMBER"  value="<%=durn_value%>"  onBlur="validateDuration(this);putDecimal(this,2,0);CheckPositiveNumber(this);ExternalDosageCheck();" onKeyPress="return(ChkNumberInput(this,event,'0'))" onChange="removeRefill('<%=dir_bean_id%>','<%=dir_bean_name%>');" >&nbsp;<!-- maxlength="11" changed to maxlength="3" for ML-BRU-SCF-0396 [IN034906]  --><select name="durn_desc" id="durn_desc" onChange="durationConversn(this,'form');removeRefill('<%=dir_bean_id%>','<%=dir_bean_name%>');"><!-- Modified for IN:069886 -->
										<option>-<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>-</option>
										<%=duration_option%>
										</select>
										<input type="hidden" name="tmp_durn_value" id="tmp_durn_value" value="<%=durn_value%>">
										<input type="hidden" name="tmp_durn_desc" id="tmp_durn_desc"  value="D">
										</td>
										<td><label name="ord_qty_lbl" id="ord_qty_lbl" style="<%=qty_legend_style%>;color:red;font-weight:bold;" ><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/></label></td>
										<td  class="data"><input class='NUMBER' type="text" size="3" maxlength="3" name="absol_qty" id="absol_qty" value="<%=absol_qty%>" onBlur="ValidateAbs(this);CheckPositiveNumber(this);" onKeyPress="return(ChkNumberInput(this,event,'0'))" <%=absol_qty_status%> style="<%=qty_legend_style%>"></td>
										<td class="data"  ><label name="ord_qty_uom" id="ord_qty_uom" style="<%=qty_legend_style%>"><%=stock_uom%></label></td>
									</tr>
									<tr>
										<td class="label" ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
										<td class="label" ><input type="text" name="start_date" id="start_date" size="16"  maxlength="16" onblur="chkBackFutureDate(this);" value="<%=start_date%>" ><IMG SRC="../../eCommon/images/CommonCalendar.gif"   id=Calendar <%=calendar_status%> onclick="if(document.prescription_detail_form.start_date.disabled){return false;};showCalendar('start_date',null,'hh:mm');document.prescription_detail_form.start_date.focus();return false;" ></td>
										<td class="label"  colspan="2" nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="text" name="end_date" id="end_date" size="16"  maxlength="13" value="<%=end_date%>" disabled></td>
										<td class="label" colspan="2"  style="" ><input type="button" class="button" value='<fmt:message key="ePH.Refill.label" bundle="${ph_labels}"/> ' style="visibility:visible" name="allow_refill" onClick="loadRefillDetails('<%=max_refills_for_pres%>')" <%=refill_status%>>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
<%
										if(physical_inv_item_yn.equals("N")){
%>
											<input type="button" class="button" value=' <fmt:message key="Common.Allocate.label" bundle="${common_labels}"/> '  id="allocate" style="<%=dis%>"onclick="loadallocatedetail('allocate','ONCLICK');" ><input type="button" class="button" value='<fmt:message key="Common.Batch.label" bundle="${common_labels}"/>'  id="Batch" style="<%=dis%>" onclick="callBatchSearch()" >
<%
										}
%>
										</td>
									</tr>
<%		
									if(current_rx.equals("Y") && allow_duplicate.equals("N") ) { //&& (patient_class.equals("IP")||  take_home>0)
										ArrayList curr_info		=	dir_bean.getDuplicateDrugs(patient_id,generic_id);
										HashMap  dup_info		=	null;
										String dup_drug_info	=	"";
										if(curr_info.size()>=1) {
											dup_info	  =	(HashMap)curr_info.get(0);
											dup_drug_info = "Patient is Currently On "+generic_name+" Medication till :"+dup_info.get("end_date")+";\n";
											dup_drug_info +="Has been prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
										}
										else{
											dup_drug_info = "Patient is Currently On "+generic_name+" Medication";
										}
%>
										<tr>
											<td colspan="6" class="CURRTEXTSL">
											<marquee  scrollamount="4" ><font  style="font-weight:bold;color:black" size=1><%=dup_drug_info%></font></marquee>
											</td>
											<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
										</tr>
<%	
								}
%>
								</table>
<%
							}
						//Prescription Writer Table ends-->
						//Added for SKR-SCF-0647[Inc 35263]-Start
						HashMap remarks_prn					= (HashMap)dir_bean.getPRNRemarks(drug_code);
						String  remarks_text                = "";
						String  remarks_code				= "";
						if(remarks_prn!=null){
							if(remarks_prn.containsKey("remarks_dtl"))
								remarks_text				    = (String)remarks_prn.get("remarks_dtl")==null?"":(String)remarks_prn.get("remarks_dtl");
							if(remarks_prn.containsKey("remarks_code"))
								remarks_code					    = (String)remarks_prn.get("remarks_code")==null?"":(String)remarks_prn.get("remarks_code");
						}//Added for SKR-SCF-0647[Inc 35263]-End
						//Below || && !remarks_text.equals("") Added for SKR-SCF-0647[Inc 35263] 
						if(!prn_remarks.equals("") || !remarks_text.equals(""))
							prn_remarks	=	"true";
						else
							prn_remarks	=	"false";

					if(!calling_mode.equals("blank")&& perform_external_database_checks_yn.equals("Y")){		  
						if(drug_db_dosecheck_yn.equals("Y")){
%>
							<script>
								ExternalDosageCheck('ONLOAD');				      
							</script>
<%
						}
%>
						<script>
<%
							//out.println("viewMedicationAlert('"+patient_id+"','"+loading_ext_prod_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dosage_check_flag+"','ONLOAD','"+external_dosage_override_reason+"','"+drug_code+"','"+srl_no+"','"+external_duplicate_override_reason+"','"+external_interaction_override_reason+"','"+external_contra_override_reason+"','"+java.net.URLEncoder.encode(pract_name)+"','"+external_alergy_override_reason+"','"+drug_db_dosecheck_yn+"')");
%>
						</script>
<%
					}
%>
					<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
						<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
							<tr>
								<td width="100%" id="t"></td>
							</tr>
						</table>
					</div>
					<input type="hidden" value="<%=drug_code%>"			name="drug_code">
					<input type="hidden" value="<%=srl_no%>"			name="srl_no">
					<input type="hidden" value="<%=form_code%>"			name="form_code">
					<input type="hidden" value="<%=strength_uom%>"		name="strength_uom">
					<input type="hidden" value="<%=strength_uom_desc%>" name="strength_uom_desc">
					<input type="hidden" value="<%=pres_base_uom%>"		name="pres_base_uom">
					<input type="hidden" value="<%=pres_base_uom_desc%>"name="pres_base_uom_desc">
					<input type="hidden" value="<%=dosage_type%>"		name="dosage_type">
					<input type="hidden" value="<%=tab_qty_value%>"		name="tab_qty_value">
					<input type="hidden" value="<%=strength_value%>"	name="strength_value">
					<input type="hidden" value=""						name="freq_value" id="freq_value">
					<input type="hidden" value="<%=interval_value%>"	name="interval_value">
					<input type="hidden" value="<%=repeat_value%>"		name="repeat_value">		
					<input type="hidden" value="<%=repeat_durn_type%>"  name="repeat_durn_type">
					<input type="hidden" value=""					    name="calcualted_durn_value" id="calcualted_durn_value">
					<input type="hidden" value="<%=max_durn_value%>"	name="max_durn_value">
					<input type="hidden" value="<%=chk_for_max_durn_action%>" name="chk_for_max_durn_action">
					<input type="hidden" value="<%=calling_mode%>"		name="calling_mode">
					<input type="hidden" value="<%=max_refills_for_pres%>" name="max_refills_for_pres">
					<input type="hidden" value="<%=max_durn_for_refill_pres%>" name="max_durn_for_refill_pres">
					<input type="hidden" value="<%=order_type_code%>"	name="order_type_code">
					<input type="hidden" value="<%=back_date%>"			name="back_date">
					<input type="hidden" value="<%=future_date%>"		name="future_date">
					<input type="hidden" value="<%=rowVal%>"			name="rowVal">
					<input type="hidden" value="<%=ord_auth_reqd_yn%>"	name="ord_auth_reqd_yn">
					<input type="hidden" value="<%=ord_spl_appr_reqd_yn%>" name="ord_spl_appr_reqd_yn">
					<input type="hidden" value="<%=ord_cosign_reqd_yn%>" name="ord_cosign_reqd_yn">
					<input type="hidden" value="<%=split_dose_yn%>"		name="split_dose_yn">
					<input type="hidden" value="<%=split_dose_yn_val%>" name="split_dose_yn_val">		
					<input type="hidden" value="<%=scheduled_yn%>"		name="scheduled_yn">
					<input type="hidden" value="<%=auth_yn%>"			name="authroize_yn">
					<input type="hidden" value="<%=approval_yn%>"		name="approval_yn">
					<input type="hidden" value="<%=cosign_yn%>"			name="cosign_yn">
					<input type="hidden" value="<%=approval_yn_val%>"	name="approval_yn_val">
					<input type="hidden" value="<%=auth_yn_val%>"		name="authroize_yn_val">
					<input type="hidden" value="<%=cosign_yn_val%>"		name="cosign_yn_val">
					<input type="hidden" value="<%=admin_time%>" name="admin_time">
					<input type="hidden" value="<%=admin_qty%>"  name="admin_qty">
					<input type="hidden" value="<%=allergy_yn%>" name="allergy_yn">
					<input type="hidden" value="<%=limit_ind%>"  name="limit_ind">
					<input type="hidden" value="<%=current_rx%>" name="current_rx">
					<input type="hidden" value="<%=mono_graph%>" name="mono_graph">
					<input type="hidden" value="<%=mono_graph%>" name="monograph">
					<input type="hidden" value="<%=generic_id%>" name="generic_id">
					<input type="hidden" value="<%=generic_name%>"name="generic_name">
					<input type="hidden" value="" name="in_durn_desc" id="in_durn_desc">
					<input type="hidden" value="" name="in_durn_value" id="in_durn_value">
					<input type="hidden" value="" name="in_dispensed_qty" id="in_dispensed_qty">
					<input type="hidden" value="" name="in_dispensed_uom" id="in_dispensed_uom">
					<input type="hidden" value="" name="in_bms_qty" id="in_bms_qty">
					<input type="hidden" value="" name="in_strength_value" id="in_strength_value">
					<input type="hidden" value="" name="in_strength_uom" id="in_strength_uom">
					<input type="hidden" value="" name="in_pres_qty_value" id="in_pres_qty_value">
					<input type="hidden" value="" name="in_pres_qty_uom" id="in_pres_qty_uom">
					<input type="hidden" value="" name="in_total_strength" id="in_total_strength">
					<input type="hidden" value="" name="in_total_strength_uom" id="in_total_strength_uom">
					<input type="hidden" value="<%=dflt_qty_uom%>"		 name="dflt_qty_uom">
					<input type="hidden" value="<%=qty_desc_code%>"		 name="qty_desc_code">
					<input type="hidden" value="<%=allergy_override%>"   name="allergy_override">
					<input type="hidden" value="<%=dose_override%>"		 name="dose_override">
					<input type="hidden" value="<%=currentrx_override%>" name="currentrx_override">
					<input type="hidden" value="<%=sch_over_yn%>"		 name="sch_over_yn">
					<input type="hidden" value="<%=unit_dose%>"			 name="unit_dose">
					<input type="hidden" value="<%=daily_dose%>"		 name="daily_dose">
					<input type="hidden" value=""						 name="conv_factor" id="conv_factor">
					<input type="hidden" value="<%=strength_per_pres_uom%>" name="strength_per_pres_uom">
					<input type="hidden" value="<%=strength_per_value_pres_uom%>" name="strength_per_value_pres_uom">
					<input type="hidden" value="<%=qty_reqd_yn%>"		name="qty_reqd_yn">
					<input type="hidden" value="<%=consider_stock_for_pres_yn%>" name="consider_stock_for_pres_yn">
					<input type="hidden" value="<%=calling_mode%>"		name="source">
					<input type="hidden" value="<%=refill_cont_order_yn%>" name="refill_cont_order_yn">
					<input type="hidden" value="<%=consent_reqd_yn%>"	name="consent_reqd_yn">
					<input type="hidden" value="<%=min_daily_dose%>"	name="min_daily_dose">
					<input type="hidden" value="<%=min_unit_dose%>"		name="min_unit_dose">	
					<input type="hidden" value="<%=freq_code%>"			name="freq_code">
					<!-- Added for IN:070451 start -->
				<input type="hidden" name="max_daily_ceeling_dose" id="max_daily_ceeling_dose" value="<%=max_daily_ceeling_dose%>">
				<input type="hidden" name="min_daily_ceeling_dose" id="min_daily_ceeling_dose" value="<%=min_daily_ceeling_dose%>">
				<input type="hidden" name="max_unit_ceeling_dose" id="max_unit_ceeling_dose" value="<%=max_unit_ceeling_dose%>">
				<input type="hidden" name="min_unit_ceeling_dose" id="min_unit_ceeling_dose" value="<%=min_unit_ceeling_dose%>">
				<input type="hidden" name="dose_unit_desc" id="dose_unit_desc" value="<%=dose_unit_desc%>">
				<input type="hidden" name="dose_unit_desc1" id="dose_unit_desc1" value="<%=dose_unit_desc1%>">
				<!-- Added for IN:070451 end  -->
				<!-- Added for IN:072715 start -->
				<input type="hidden"  name="allergy_remarks_code" id="allergy_remarks_code" value="<%=allergy_remarks_code%>">
       				<input type="hidden"  name="dose_remarks_code" id="dose_remarks_code" value="<%=dose_remarks_code%>">
       				<input type="hidden"  name="currentrx_remarks_code" id="currentrx_remarks_code" value="<%=currentrx_remarks_code%>">
       				<input type="hidden" name="interaction_remarks_code" id="interaction_remarks_code" value="<%=interaction_remarks_code%>">
       				<input type="hidden" name="food_interaction_remarks_code" id="food_interaction_remarks_code" value="<%=food_interaction_remarks_code%>" >
       				<input type="hidden" name="lab_interaction_remarks_code" id="lab_interaction_remarks_code" value="<%=lab_interaction_remarks_code%>">
       				<!-- Added for IN:072715 end -->
					<input type="hidden" value="<%=disease_interaction_remarks%>" name="disease_interaction_remarks"><!-- MMS-DM-CRF-0229 -->
                   <input type="hidden" value="<%=disease_interaction_remarks_code%>" name="disease_interaction_remarks_code"><!-- MMS-DM-CRF-0229 -->
			<!-- Added for IN:073485 START -->
       			 <input type="hidden" value="<%=override_select_appl%>" name="override_select_appl">
                         <input type="hidden" value='N' name="override_rem_mand" id="override_rem_mand">
       			<!-- Added for IN:073485 end -->
					<label id="tool_tip" style="visibility:hidden"></label>
					<input type="hidden" name="freq_nature" id="freq_nature"				value="<%=freq_nature%>">
					<input type="hidden" name="init_qty" id="init_qty"				value="<%=qty_value%>">
					<input type="hidden" name="prn_dose" id="prn_dose"				value="<%=prn_dose%>">
					<input type="hidden" name="no_refill" id="no_refill"				value="<%=no_refill%>">
					<input type="hidden" name="refill_start_date" id="refill_start_date"		value="<%=refill_start_date%>">
					<input type="hidden" name="refill_end_date" id="refill_end_date"			value="<%=refill_end_date%>">
					<input type="hidden" name="ph_version" id="ph_version"				value="<%=ph_version%>">
					<input type="hidden" name="stock_uom" id="stock_uom"				value="<%=stock_uom%>">
					<input type="hidden" name="calc_by_ind" id="calc_by_ind"				value="<%=calc_by_ind%>">
					<input type="hidden" name="dosage_std" id="dosage_std"				value="<%=dosage_std%>">
					<input type="hidden" name="dosage_unit" id="dosage_unit"				value="<%=dosage_unit%>">		
					<input type="hidden" name="recomm_yn" id="recomm_yn"				value="<%=recomm_yn%>">	
					<input type="hidden" name="allow_duplicate" id="allow_duplicate"			value="<%=allow_duplicate%>">
					<input type="hidden" name="take_home" id="take_home"				value="<%=take_home%>">
					<input type="hidden" name="allow_without_diag" id="allow_without_diag"		value="<%=allow_without_diag%>">		
					<input type="hidden" name="prn_remarks_flag" id="prn_remarks_flag"		value="<%=prn_remarks%>">
					<input type="hidden" name="item_code" id="item_code"				value="<%=item_code%>">
					<input type="hidden" name="store_code" id="store_code"			    value="<%=store_code%>">
					<input type="hidden" name="pract_name" id="pract_name"			    value="<%=pract_name%>">
					<input type="hidden" name="perform_external_database_checks_yn" id="perform_external_database_checks_yn" value="<%=perform_external_database_checks_yn%>">
					<input type="hidden" name="external_product_id" id="external_product_id"     value="<%=external_product_id%>">
					<input type="hidden" name="fract_dose_round_up_yn" id="fract_dose_round_up_yn"  value="<%=fract_dose_round_up_yn%>">
					<input type="hidden" name="external_dosage_override_reason" id="external_dosage_override_reason" value=<%=java.net.URLEncoder.encode(external_dosage_override_reason)%>>
					<input type="hidden" name="external_duplicate_override_reason" id="external_duplicate_override_reason" value=<%=external_duplicate_override_reason%>>
					<input type="hidden" name="external_interaction_override_reason" id="external_interaction_override_reason" value=<%=external_interaction_override_reason%>>
					<input type="hidden" name="external_contra_override_reason" id="external_contra_override_reason" value=<%=external_contra_override_reason%>>
					<input type="hidden" name="external_Alergy_override_reason" id="external_Alergy_override_reason" value="<%=external_alergy_override_reason%>">
					<input type="hidden" name="drug_db_dose_check_flag" id="drug_db_dose_check_flag" value="<%=drug_db_dosage_check_flag%>">
					<INPUT TYPE="hidden" name="recomm_dosage_by" id="recomm_dosage_by" VALUE="<%= recomm_dosage_by %>"> <!-- Added for ML-MMOH-CRF-0978 -->
					<input type="hidden" name="trade_code" id="trade_code" value="<%=trade_code%>">
					<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
					<input type="hidden" value="<%=def_freq_found%>" name="def_freq_found">
					<input type="hidden" value="<%=DurnDescDetails%>" name="DurnDescDetails">
					<input type="hidden" value="N" name="sliding_scale_yn" id="sliding_scale_yn">
					<input type="hidden" name="DrugIndicationRemarks" id="DrugIndicationRemarks" value="<%=DrugIndicationRemarks%>"><!--Added for  ML-BRU-CRF-072[Inc:29938] -->
					<input type='hidden' name='wt_mand_yn' id='wt_mand_yn' value="<%=wt_mand_yn%>"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->
					<input type='hidden' name='ht_mand_yn' id='ht_mand_yn' value="<%=ht_mand_yn%>"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->
					<input type='hidden' name='weight_rec_appl_age_group_check_flag' id='weight_rec_appl_age_group_check_flag' value="<%=weight_rec_appl_age_group_check_flag%>"> <!--added for Bru-HIMS-CRF-079 IN[029945] -->
					<input type="hidden" name="intr_restric_trn" id="intr_restric_trn" value="<%=intr_restric_trn%>"><!--// added for FD-RUT-CRF-0066.1 [IN036975] -->
					<input type="hidden" name="intr_msg_content" id="intr_msg_content" value="<%=intr_msg_content%>"><!--// added for FD-RUT-CRF-0066.1 [IN036975] -->
					<input type="hidden" name="interaction_override" id="interaction_override" value="<%=interaction_override%>"><!--// added for FD-RUT-CRF-0066.1 [IN036975]-->
					<input type="hidden" name="interaction_exists" id="interaction_exists" value="<%=interaction_exists%>"><!--// added for FD-RUT-CRF-0066.1 [IN036975] -->
					<input type="hidden" name="recom_value" id="recom_value" value="<%=recom_value%>"><!--// addedn for  ML-MMOH-CRF-0978 -->
					<input type="hidden" name="default_recm_dose_yn" id="default_recm_dose_yn" value="<%=default_recm_dose_yn%>"><!--// addedn for  ML-MMOH-CRF-0978 -->
					<input type="hidden" name="amend_yn" id="amend_yn" value="<%=amend_yn%>"><!--// addedn for  ML-MMOH-CRF-0978 -->
					<input type="hidden" name="default_freq_not_found" id="default_freq_not_found" value="<%=default_freq_not_found%>"><!--// added for GHL-CRF-0508 -->
					 <input type="hidden" value="<%=validate_overide_on_confirm_yn%>" name="validate_overide_on_confirm_yn"><!-- Added for IN:069887  -->
				
<%
					//  duplicate check based on atc -- starts
					if(current_rx.equals("Y")) {
						String atc_level_1	=	"";
						String atc_level_2	=	"";
						String atc_level_3	=	"";
						String provide_taper =	"";
						ArrayList atc_values =  new ArrayList();
						HashMap drug_detail	 =	null;
						if(presDetails!=null && presDetails.size()>0){
							
							for(int i=0;i<presDetails.size();i++){			
								drug_detail=(HashMap) presDetails.get(i);
								atc_level_1	=	(String)drug_detail.get("ATC_CLASS_LEV1_CODE");
								atc_level_2	=	(String)drug_detail.get("ATC_CLASS_LEV2_CODE");
								atc_level_3	=	(String)drug_detail.get("ATC_CLASS_LEV3_CODE");
								drug_desc	=	(String)drug_detail.get("DRUG_DESC");

							if(drug_detail.get("PROVIDE_TAPER")!=null)
								 provide_taper	= (String)drug_detail.get("PROVIDE_TAPER");

							if( (!provide_taper.equals("Y")) && (drug_detail.get("CURRENTRX_REMARKS")==null || ((String)drug_detail.get("CURRENTRX_REMARKS")).equals("") )  ) {
								if(atc_values.contains(atc_level_1)) {
									out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_1)-1)+" at ATC Classification Level 1'); </script>");
								} 
								else  if(atc_values.contains(atc_level_2)) {
									out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_2)-2)+" at ATC Classification Level 2'); </script>");
								}
								else if(atc_values.contains(atc_level_3)) {
									out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_3)-3)+" at ATC Classification Level 3') </script>");
								} 
								else {
									atc_values.add(drug_desc);
									if(!(atc_level_1==null || atc_level_1.equals("")))
										atc_values.add(atc_level_1);
									if(!(atc_level_2==null || atc_level_2.equals("")))
										atc_values.add(atc_level_2);
									if(!(atc_level_3==null || atc_level_3.equals("")))
										atc_values.add(atc_level_3);
								}
							}
						}
					}
				}
				//  duplicate check based on atc -- ends
%>
				<script>
<% 
					if(calling_mode.equals("blank")){ 
%>
						document.prescription_detail_form.drug_name.focus();
<%	
					}
					else {
					//if no default frequency(order catalog) matches with the applicable frequency list with respect to patient class
						if(!amend_yn.equals("Y") && orig_current_rx.equals("Y") && allow_duplicate.equals("N") ) {	//&& (patient_class.equals("IP") || take_home>0)
%>
							duplicateWarning();
							freqChange(document.prescription_detail_form.frequency,"N");
<%
						}
						else if(!def_freq_found && !amend_yn.equals("Y")){
%>
//added for for GHL-CRF-0508 start 
      <% if(!default_freq_not_found){%>
							alert(getMessage("PH_NORMAL_RX_DEFAULT_FREQ_NOT_FOUND",'PH')); 
           <% } %>
//commented for GHL-CRF-0508 end 
							freqChange(document.prescription_detail_form.frequency,"N");
<%
						}
%>
						dfltDurnDesc('<%=repeat_durn_type%>');
<%
						if(!dosage_type.equals("S")) {	
%>	
							populateQtyDesc('<%=form_code%>','<%=pres_base_uom%>');
<%			
						}
%>			 
						populateEndDate();			
						getFormatId();  

<%						// To Display reason button 
						if((allergy_yn.equals("Y") || limit_ind.equals("N") || current_rx.equals("Y") || interaction_exists.equals("Y")) && !perform_external_database_checks_yn.equals("Y")){ // interaction_exists check  added for FD-RUT-CRF-0066.1 [IN036975]  && !perform_external_database_checks_yn.equals("Y") Added for 69759
%>
							document.prescription_detail_form.dosage_limit.style.visibility="visible";
							document.prescription_detail_form.dosage_limit.style.display="inline";
							document.prescription_detail_form.override_chk.style.visibility="visible";
<%
						}
						// If tappered Disable Refill Button 
						if(tappered_over!=null && tappered_over.equals("Y")){
%>
							document.prescription_detail_form.allow_refill.disabled=true;
<%
						}
					}	
					if( calling_mode.equals("taper")){
%>	
						document.prescription_detail_form.start_date.disabled=true;	
						document.prescription_detail_form.allow_refill.disabled=true;
<%
					}	
					if(calling_mode.equals("modify") || calling_mode.equals("taper")) {	
%>
						// setfocus(document.prescription_detail_form.qty_value);
						if('<%=freq_nature%>'=='O'){
							document.prescription_detail_form.in_durn_desc.value="";
							document.prescription_detail_form.in_durn_value.value="";
							document.prescription_detail_form.durn_desc.value="D";
							document.prescription_detail_form.durn_value.value="1";
							document.prescription_detail_form.durn_value.disabled=true;
							document.prescription_detail_form.durn_desc.disabled=true;
							document.prescription_detail_form.calcualted_durn_value.value="1";
							document.prescription_detail_form.allow_refill.disabled=true;
							document.prescription_detail_form.no_refill.value="";
							document.prescription_detail_form.refill_start_date.value="";
							document.prescription_detail_form.refill_end_date.value="";
						}
<%		
						//HashMap data		=	null;
						String att			=	null;
						String adm_time		=	"";
						String adm_qty		=	"";
						String total_qty	=   "";
						ArrayList dose_list	=	null;
						if(frequencyValues!=null && frequencyValues.size()>0){
							
							/*adm_time+="<tr>";					
							for(int i=0;i<frequencyValues.size();i++){
								data=(HashMap)frequencyValues.get(i);
								att="align=center class=TIP";
								adm_time+="<td "+att+">&nbsp;"+data.get("admin_time")+"&nbsp;</td>";
							}
							adm_time+="</tr>";

							adm_qty+="<tr>";
							for(int i=0;i<frequencyValues.size();i++){
								att="align=center class=TIP";
								data=(HashMap)frequencyValues.get(i);
								adm_qty+="<td "+att+">&nbsp;"+data.get("admin_qty")+"&nbsp;</td>";
								total_qty=(String) data.get("admin_qty");
							}
							adm_qty+="</tr>";*/
							dose_list	= (ArrayList)frequencyValues.get(4);
							for(int tqI=0;tqI<dose_list.size();tqI++){						
								total_qty	=	(String)dose_list.get(tqI);
								if(total_qty.equals("")||total_qty.equals("0")||total_qty==null)
									total_qty="1";
							}

							boolean split_chk	=	dir_bean.checkSplit(frequencyValues);	
							String tooltiptable = (String)dir_bean.getTooltipStringFrFreq(frequencyValues,"toolTip");
							adm_time = tooltiptable;	
							//out.println("alert('one')");	out.println("makeScheduleLink('"+adm_time+"','"+adm_qty+"','"+total_qty+"','"+frequencyValues.size()+"','"+split_chk+"')");  //no:1;
						}	
					}	
%>
				</script>
<%
				if(!calling_mode.equals("blank")){
%>
					<script>
						storeSchedule();//no:2
					</script>
<%
				}
%>
				<script>
					if(document.prescription_detail_form.freq_nature.value=="P"){
						var man_rem_on_prn_freq_yn = parent.parent.parent.f_header.document.dir_disp_header_form.man_rem_on_prn_freq_yn.value;
						document.getElementById("prn_remarks").style.visibility	= "visible";
						if(man_rem_on_prn_freq_yn=='Y'){
							document.getElementById("prn_remarks_image").style.visibility	= "visible";
						 }
						document.getElementById("dis_split_dose").style.visibility	= "hidden";
						document.prescription_detail_form.allow_refill.disabled=true;

					}
				</script>
<%
				if(orig_current_rx.equals("Y") && allow_duplicate.equals("N") ) {	//&& (patient_class.equals("IP") || take_home>0)
%>
					<script>freqChange(document.prescription_detail_form.frequency,'N');</script>
<%		
				}  
%>
				<script>
					//dosageChange(document.prescription_detail_form.dosage);
					checkWtAndHt(prescription_detail_form);
					lookForChange(document.prescription_detail_form.qty_value,'N'); //no:3over
				</script>
<%
				if(!calling_mode.equals("blank")){
%>
					<script>
						//document.prescription_detail_form.allocate.click();
						assignDurnTypeList('<%=DurnDescDetails%>'); 
						reloadDurnTypeList('N', 'ONLOAD'); //no:4 over//'ONLOAD added for AAKH-SCF-0189 [IN:054663]
					</script>
<% 
					if(modify_durn_desc){ 
%>
						<script>selectCorrectDurationDesc('<%=durn_desc%>','N');</script>
<%
					}
%>
					<script>
						//loadallocatedetail('allocate',"ONLOAD");//commented for AAKH-SCF-0189 [IN:054663] - to avoid multiple loading of allocatedetails jsp
						storeSchedule();//no:5
					</script>
<%
					if(!ori_dosage_type.equals(default_dosage_by) && !amend_yn.equals("Y") &&  !calling_mode.equals("taper") && !calling_mode.equals("tapered")){
%>
							<script>
								dosageChange(document.prescription_detail_form.dosage, 'ONLOAD');//code added  for SKR-CRF-PHIS-003[IN028182] //ONLOAD added for AAKH-SCF-0189 [IN:054663] - to avoid multiple loading of allocatedetails jsp
							</script>
<%
						}
					}
					if((amend_yn==null || !amend_yn.equals("Y") ) && interaction_exists.equals("Y")){// && (intr_restric_trn.equals("Y") || severity_level.equals("H"))){ // added for FD-RUT-CRF-0066.1 [IN036975]
%>
						<script>alertIntr('<%=drug_code%>','<%=srl_no%>', '<%=patient_id%>','<%=encounter_id%>','N');</script>
<%
					}
%>
					<script>loadallocatedetail('allocate',"ONLOAD");//added for AAKH-SCF-0189 [IN:054663]
					</script>
<%
				}
				else{
%>
					<script>alert(getMessage("PAT_DIAG_REQD","PH"));</script>
<%
				}
				putObjectInBean(dir_bean_id,dir_bean,request); 
				putObjectInBean(ex_bean_id,beanex,request); 
				//putObjectInBean(or_bean_id,orbean,request); 
			}
			catch(Exception e){
				e.printStackTrace();
			}
			if(barcode_yn.equalsIgnoreCase("Y") && !barcodeDisable.equals("disabled")){ // Added for MMS-DM-CRF-0112.1 [IN:065216] - Start
%> 
<script>
	document.prescription_detail_form.barcode_id.focus(); 
	</script>
	<%} // Added for MMS-DM-CRF-0112.1 [IN:065216] - End %>
		</form>
	</body>
</html>

