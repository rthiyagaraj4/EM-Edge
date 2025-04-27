<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		//String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script> 
		<script language="javascript" src="../js/DrugNameCommonLookup.js"></script>
		<script language="javascript" src="../js/IVPiggyBack.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	try{

		String params	= request.getQueryString();
		String adr_count	         = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
		String patient_id			 = request.getParameter("patient_id");
		String patient_class		 = request.getParameter("act_patient_class");
		String encounter_id			 = request.getParameter("encounter_id");
		String order_id				 = request.getParameter("order_id");
		String mode                  = request.getParameter("mode");

		String order_line_num        = request.getParameter("order_line_num");
		String classValue	= request.getParameter("classValue")==null?"":request.getParameter("classValue");
		String drug_db_allergy_check_flag			= "N";
		if(mode==null) 
			mode="";
		
		if(order_id==null)
			order_id="";

		String order_type_flag		= request.getParameter("order_type_flag");

		if(order_type_flag==null)   
			order_type_flag="";

		String iv_prep_yn			= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
		String iv_prep_default		= request.getParameter("iv_prep_default")==null?"":request.getParameter("iv_prep_default");
		String order_set_code		= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
		String prev_order			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");



		String MAR_app_yn = "";
		String buildMAR_checked = "";
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
		String buildMAR_enable = "";
		 SRR20056-CRF-0649.1 */
		MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
		String buildMAR_yn = MAR_app_yn;

		if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
			if(patient_class.equals("IP"))
				buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 */
			if(buildMAR_yn.equals("Y"))
				buildMAR_checked ="Checked";
		}

		String checked				="";

		String disabled1			= "";
		String readonly			    = "";
		String catalog_desc			= "";
		String drug_codes			= "";
		String qty_value			= "";
		String qty_unit			    = "";
		String flag1				= "";
		String strDrugCode			= "";

		ArrayList orderSetCodes		=new ArrayList();
		
		String chk_addmixture       = ""; 
		String time_flag            = ""; 
		String disable_addmixture	= "";
		String alert_practitioner_yn= "";
		String drug_desc	        = "";
		String daily_dose	        = "";
		String unit_dose	        = "";
		String min_daily_dose       = "";
		String min_unit_dose	    = "";
		String dosage_unit	        = "";
		String mon_graph	        = "";
		String recomm_yn	        = "";
		String dosage_std	        = "";
		String recomm_dosage_by	        = "";
		String dosage_by	        = "";
		String calc_by_ind	        = "";
		String display              = "display:none";
		String allergy_flag         = "hidden";
		String doselimit_flag       = "hidden";
		String currentrx_flag       = "hidden";
		String over_ride_flag       = "hidden";
		String currentrx_flag_img						= "hidden";
		String allergy_flag_img						= "hidden";
		String doselimit_flag_img						= "hidden";
		
//		String  allergy_YN="N", doselimit_YN="N", currentrx_YN="N"; 
		String allergy_override_reason="";
		String dosage_limit_override_reason="";
		String duplicate_drug_override_reason="";
		String f_i_flag="N";
		String display_tdm = "visibility:hidden";
		HashMap drugReasons  =  null;
		String uom_code				= "";
		String uom_desc				= "";
		//code added for external data base checks 
		String drug_code			= "";
		String perform_external_database_checks_yn	=	"N";	
		String external_database_checks_overrided	=	"N";	
		String loading_ext_prod_id					=	"";
		String external_dosage_override_reason		=   "";	
		String external_duplicate_override_reason	=   "";
		String external_interaction_override_reason	=   "";
		String external_contra_override_reason		=   ""; 
		String external_alergy_override_reason		=   ""; 
		String fract_dose_round_up_yn				=   "";
		String drug_db_dosage_check_flag			=   "Y";
		String ext_prod_id							=   "";
		String external_checks						=   "hidden";

	   // String allergy_override_reason_flag			=  "N";	
		String duplicate_drug_override_reason_flag	=  "N";
		String interaction_override_reason_flag		=  "Y";
		String contraind_override_reason_flag		=  "N";
		String drug_adr_style						= "hidden";
		
		String ex_bean_id   = "@ExternalProductLinkBean";
		String ex_bean_name = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

		String facility_id					= (String)session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );

		String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
		String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);
		String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
		String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
		String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
		String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
		String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);   

		//crf 0189
		String disaExst="";
		

		param_bean.clear();	

		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		String or_bean_name		= "eOR.OrderEntryBean";
		OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

	   //ends here

		String bean_id				= "IVPiggyBackBean"+patient_id+encounter_id;
		String bean_name			= "ePH.IVPiggyBackBean";
		IVPiggyBackBean bean		= (IVPiggyBackBean)getBeanObject( bean_id,bean_name, request ) ;

		String iv_bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String iv_bean_name			= "ePH.IVPrescriptionBean";
		IVPrescriptionBean iv_bean	= (IVPrescriptionBean)getBeanObject( iv_bean_id, iv_bean_name, request ) ;


		iv_bean.setDrug_DB_Product_id(drug_db_product_id);
		iv_bean.setPatId(patient_id);
		iv_bean.setEncId(encounter_id);

		drug_db_interface_yn = "Y";
		iv_bean.setExternalDrugDataBaseInterface_yn(drug_db_interface_yn);



		HashMap record;
		HashMap record1;
		/***********************************************************************************************
		  New Enhancement for malasiya :Code for validating IVADMIXTURE APPLICAPABLE and FROM_TIME and 
						TO_TIME in PHPARAMETER FOR FACILITY UNDER IVADMIXTURE TAB starts 
		  date:11/22/2004
		*************************************************************************************************/
	/*	if(!order_type_flag.equals("Existing")&& !mode.equals("amend"))
		{   */
			record1					= new HashMap(); 
			record1					= bean.ChkAdMixture();
			chk_addmixture			= (String)record1.get("IV_ADMIXTURE_APPL_YN");
			alert_practitioner_yn	= (String)record1.get("ALERT_PRACTITIONER_YN");
		
			if(chk_addmixture.equals("N"))
			   disable_addmixture="Disabled";		    
			else
			{
			   disable_addmixture="";
			   time_flag=(String)record1.get("time_flag");
			}
	/*	}*/
		/*************************************Endshere**************************************************/
//out.println("==iv_bean=1==="+iv_bean.getOrderDate());

		iv_bean.setIVPB("Y");
		ArrayList drugList		= iv_bean.getDrugDetails();	  

		if((iv_bean.getOrder_type_flag()).equals("Existing")) 
			disaExst = "";
		if(mode.equals("amend")){
			disaExst ="disabled";
		}
//out.println("==iv_bean==2=="+iv_bean.getOrderDate());

		String strength_value		="0";
		String strength_uom_desc	="";
		String strength_uom			="";
		String dosage_type			="";
		HashMap drugDetails	    = null;
		HashMap drugDetailsAmend	    = null;

		if(drugList.size() > 0){
			drugDetails	    = (HashMap)drugList.get(0);
			strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
			strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
			strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
			dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");

		}

		String disabled	= "";
		String generic_id			="";
		String generic_name			="";
		String mono_graph			="";
		String limit_ind			="";
		String allergy_yn			="";
		String current_rx			="";	
		String srl_no				="";
		String form_code			="";
		String pres_qty_value		="";
		String pres_base_uom		="";
		String freq_code			="";
		String durn_value			="";
		String or_durn_desc			="";
		String auth_yn				="";
		String approval_yn			="";
		String cosign_yn			="";
		String consent_reqd_yn		="";
		String order_type_code		="";
		String fract_dose_appl_yn	="";
		                             
		String route_code			="";
		String end_date				="";
		String dup_drug_desc		="";
		String allergy_desc			="";
		String exceed_dose_desc		="";
		String bms_qty				="";
		String dflt_qty_uom			="";
		String tab_qty_value		="";
		String qty_desc_code		="";
		String amend_yn				="";
		String ord_auth_reqd_yn		="";		
		String ord_spl_appr_reqd_yn	="";	
		String ord_cosign_reqd_yn	="";	
		String ord_authorized_yn	="";	
		String ord_authorized_prev_yn	="";
		String ord_approved_yn		="";	
		String ord_cosigned_yn		="";	
		String sRegRopt				= "";
		String strength_per_value_pres_uom = "";
		String strength_per_pres_uom	   = "";
		String serialNum = "";	
		String dosage_uom_code = "";
		String calc_dose_based_on	= "D";
		String calc_dose_by		    = "";
		String calc_dose_value	    = "";
		String displaydose			= "";
		String displayBSA			= "style='display:none'";
		String kg_selected			= "Selected";
		String m2_selected			= "";
		String select_calc_dose_Dosage="checked";
		String select_calc_dose_WT_BSA="";
		String disable_calc_dose	="";
		ArrayList orderSetValues = new ArrayList();
		String dflt_code	= "";
		int dose_decimal = 2;

		if((request.getParameter("drugSelect") != null && request.getParameter("drugSelect").equals("Y"))|| mode.equals("amend")){
			
			disabled	= "";
			int srlNo		= 0;
//			srlNo			= Integer.parseInt(serialNum);
			drugList			= iv_bean.getDrugDetails();

			if(drugList.size() > 0)
				drugDetails			= (HashMap)drugList.get(0);
			orderSetValues	= iv_bean.getOrderSetValues();
			generic_id			= (String)drugDetails.get("GENERIC_ID");

			drug_desc			= (String)drugDetails.get("DRUG_DESC");
			drug_codes			= (String)drugDetails.get("DRUG_CODE");
			generic_name			= (String)drugDetails.get("GENERIC_NAME");
			daily_dose			= (String)drugDetails.get("DAILY_DOSE");
			min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_DOSE");
			min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_DOSE");
			unit_dose			= (String)drugDetails.get("UNIT_DOSE")==null?"":(String)drugDetails.get("UNIT_DOSE");
			dosage_std			= (String)drugDetails.get("DOSAGE_STD")==null?"":(String)drugDetails.get("DOSAGE_STD");

			recomm_dosage_by			= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
			calc_by_ind			= (String)drugDetails.get("CALC_BY_IND")==null?"":(String)drugDetails.get("CALC_BY_IND");
			mono_graph			= (String)drugDetails.get("MONO_GRAPH")==null?"":(String)drugDetails.get("MONO_GRAPH");
			limit_ind			= (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
			allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
			current_rx			= (String)drugDetails.get("CURRENT_RX");
			srl_no				= (String)drugDetails.get("SRL_NO");
			strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
			strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
			strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
			form_code			= (String)drugDetails.get("FORM_CODE");

			pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
			pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
			freq_code			= (String)drugDetails.get("FREQ_CODE");
			durn_value			= (String)drugDetails.get("DURN_VALUE");
			or_durn_desc			= (String)drugDetails.get("OR_DURN_DESC");
			auth_yn				= (String)drugDetails.get("AUTH_YN");
			approval_yn			= (String)drugDetails.get("APPROVAL_YN");
			cosign_yn			= (String)drugDetails.get("COSIGN_YN");
			consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
			order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
			fract_dose_appl_yn	= (String)drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_APPL_YN");
			route_code			= (String)drugDetails.get("ROUTE_CODE");
			end_date			= (String)drugDetails.get("END_DATE");			
			
			if(mode.equals("amend")){
				dup_drug_desc			= (String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?(String)drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"):(String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON");
				allergy_desc			= (String)drugDetails.get("ALLERGY_OVERRIDE_REASON")==null?(String)drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON"):(String)drugDetails.get("ALLERGY_OVERRIDE_REASON");
				exceed_dose_desc		= (String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?(String)drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"):(String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON");
				calc_dose_based_on	= (String)drugDetails.get("CALC_DOSE_BASED_ON");
				if(calc_dose_based_on!=null && calc_dose_based_on.equals("B"))
				{
					select_calc_dose_Dosage="";
					select_calc_dose_WT_BSA="checked";
					calc_dose_by			= (String)drugDetails.get("CALC_DOSE_BY")==null?"KG":(String)drugDetails.get("CALC_DOSE_BY");
					calc_dose_value			= (String)drugDetails.get("CALC_DOSE_VALUE")==null?"":(String)drugDetails.get("CALC_DOSE_VALUE");
					displaydose="style='display:none'";
					displayBSA="";
					if(calc_dose_by.equals("M2"))
					{
						kg_selected="";
						m2_selected="Selected";
					}
				}
			}
			else{
				dup_drug_desc			= (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails.get("CURRENTRX_REMARKS");
				allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS")==null?"":(String)drugDetails.get("ALLERGY_REMARKS");
				exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS")==null?"":(String)drugDetails.get("DOSE_REMARKS");
			}
			
			bms_qty						= (String)drugDetails.get("BMS_QTY");
			dflt_qty_uom				= (String)drugDetails.get("DFLT_QTY_UOM");
			tab_qty_value				= (String)drugDetails.get("TAB_QTY_VALUE");
			qty_desc_code				= (String)drugDetails.get("QTY_DESC_CODE");
			amend_yn					= (String)drugDetails.get("AMEND_YN");

			qty_value					= (String)drugDetails.get("QTY_VALUE");
			dosage_unit					= (String)drugDetails.get("DOSAGE_UNIT");
			ord_auth_reqd_yn			= (String)drugDetails.get("ORD_AUTH_REQD_YN");
			ord_spl_appr_reqd_yn		= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
			ord_cosign_reqd_yn			= (String)drugDetails.get("ORD_COSIGN_REQD_YN");
			ord_authorized_yn			= (String)drugDetails.get("ORD_AUTHORIZED_YN");
			ord_authorized_prev_yn		= (String)drugDetails.get("ORD_AUTHORIZED_PREV_YN");
			ord_approved_yn				= (String)drugDetails.get("ORD_APPROVED_YN");
			ord_cosigned_yn				= (String)drugDetails.get("ORD_COSIGNED_YN");
			
			sRegRopt					= (String)drugDetails.get("REQD_OR_OPT_IND"); 
			strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
			strength_per_pres_uom		= (String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
			ext_prod_id					= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
			drug_db_dosage_check_flag	= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	


			perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");		
			loading_ext_prod_id			= ext_prod_id;

			external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
			external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
			external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
			external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
			external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");

			if(fract_dose_appl_yn.equals("N"))
				dose_decimal = 0;
			
			if(recomm_dosage_by.equals("B"))
				recomm_dosage_by = "Q";		
		

			if (!classValue.equals("AMENDEDDRUGS")) {
					
				String orgLineNum = Integer.toString(srlNo+1);
				HashMap qtyValues =	iv_bean.getQtyValue(patient_id,order_id,orgLineNum);
				dflt_code = (String)qtyValues.get("strengthUom")==null?"":(String)qtyValues.get("strengthUom");

				if((iv_bean.getOrder_type_flag()).equals("Existing")) 
					qty_desc_code = dflt_code;
			}
		}//*********************************************

		if(order_type_flag.equals("Existing")||mode.equals("amend")){
	
			disabled1="disabled";
			if(!prev_order.equals("") && prev_order.equals("previous")){
				readonly="";
//				current_rx			= (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
			}
			else{
				readonly="readonly";
			}
				  
			ArrayList exstngIVorder = (ArrayList)iv_bean.getExistingIVRecords(order_id,"","");  //RUT-CRF-0062
			record					= new HashMap();
			int siz=exstngIVorder.size();
			String lengt=siz+"";
			if(lengt.equals("1")){
				drugDetailsAmend					= (HashMap)exstngIVorder.get(0);
			}
			else{
				drugDetailsAmend					= (HashMap)exstngIVorder.get(1);
			}

			drug_desc				= drugDetailsAmend.get("DRUG_DESC")==null?(String)drugDetailsAmend.get("CATALOG_DESC"):(String)drugDetailsAmend.get("DRUG_DESC");
			catalog_desc			= (String)drugDetailsAmend.get("CATALOG_DESC");
			drug_codes				= (String)drugDetailsAmend.get("ORDER_CATALOG_CODE");
			qty_value				= (String)drugDetailsAmend.get("QTY_VALUE");
			qty_unit				= (String)drugDetailsAmend.get("QTY_UNIT");
			dosage_type			= (String)drugDetailsAmend.get("DOSAGE_TYPE");
			dosage_uom_code			= (String)drugDetailsAmend.get("DOSAGE_UOM_CODE")==null?"":(String)drugDetailsAmend.get("DOSAGE_UOM_CODE");
			if(record.get("BUILDMAR_YN")==null){
				drugDetailsAmend.put("BUILDMAR_YN",MAR_app_yn);
			}
			buildMAR_yn = (String) drugDetailsAmend.get("BUILDMAR_YN");

			if(buildMAR_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
				if(patient_class.equals("IP"))
					buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 */
				if(buildMAR_yn.equals("Y"))
					buildMAR_checked ="Checked";
			}
//out.println("==iv_bean=3==="+iv_bean.getOrderDate());

			iv_bean.setDrugDetails(drug_codes,"","","","","",""); //CRF-0062
			drugList			= iv_bean.getDrugDetails();

			if(drugList.size() > 0)
				drugDetails			= (HashMap)drugList.get(0);

			if(drugDetails != null && drugDetails.size() >0){
				strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
				strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
				strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
				

				current_rx = (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
				limit_ind = (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
				allergy_yn = (String)drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN");
			}


			 drugReasons=new HashMap();
			 HashMap drugInfo=iv_bean.getAddDrugInfo(drug_codes);
			 String iv_ingredient_yn=(String)drugInfo.get("IV_INGREDIENT_YN");
			 String iv_fluid_yn=(String)drugInfo.get("IV_FLUID_YN");
			 if( iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("Y")){
				 order_line_num="1";f_i_flag="Y";
			 }
			 else{
				 order_line_num="2";
			 }
		 
			 ext_prod_id					= (String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");

			if(mode.equals("amend")){
				drugReasons=iv_bean.getDrugReasons(order_id,order_line_num,ext_prod_id);
			}

			allergy_override_reason=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");
			dosage_limit_override_reason=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
			duplicate_drug_override_reason=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");

			if(!allergy_override_reason.equals("")){
				allergy_flag="visible";
				allergy_yn="Y";
			}
			if(!dosage_limit_override_reason.equals("")){
				doselimit_flag="visible";
				limit_ind="N";
			}
			if(!duplicate_drug_override_reason.equals("")){
				currentrx_flag="visible";
				current_rx="Y";
			}

	//		if(!allergy_override_reason.equals("") || !dosage_limit_override_reason.equals("") || !duplicate_drug_override_reason.equals("")) over_ride_flag="visible";
	

			mon_graph				= (String)drugDetailsAmend.get("MONO_GRAPH");
			recomm_yn				= (String)drugDetailsAmend.get("RECOMM_YN");

			if(recomm_yn.equals("Y")){
				drug_desc				= (String)drugDetails.get("DRUG_DESC");
				daily_dose				= (String)drugDetailsAmend.get("DAILY_DOSE");
				unit_dose				= (String)drugDetailsAmend.get("UNIT_DOSE");
				min_daily_dose		    = (String)drugDetailsAmend.get("MIN_DAILY_DOSE");
				min_unit_dose			= (String)drugDetailsAmend.get("MIN_UNIT_DOSE");
				dosage_unit			    = (String)drugDetailsAmend.get("DOSAGE_UNIT")==null?"":(String)drugDetailsAmend.get("DOSAGE_UNIT");	   
				dosage_std			    = (String)drugDetailsAmend.get("DOSAGE_STD")==null?"":(String)drugDetailsAmend.get("DOSAGE_STD");	   
				calc_by_ind			    = (String)drugDetailsAmend.get("CALC_BY_IND")==null?"":(String)drugDetailsAmend.get("CALC_BY_IND");	   
				recomm_dosage_by			    = (String)drugDetailsAmend.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetailsAmend.get("RECOMM_DOSAGE_BY");	   
				dosage_by			    = (String)drugDetailsAmend.get("DOSAGE_TYPE")==null?"":(String)drugDetailsAmend.get("DOSAGE_TYPE");	   
				display="display:inline";
			}
			else{
				display="display:none";
			}


			if(order_type_flag.equals("Existing")){
			  flag1="Existing";	
			  iv_bean.setOrder_type_flag(flag1);
			} 
			
			if(iv_prep_yn==null)      
				iv_prep_yn="";

			if(iv_prep_yn.equals("3"))
				checked="";
			else  
				   checked="checked"; 
		}// if amend
		/*else{
			if(limit_ind.equals("Y"))
				doselimit_flag = "visible";
			if(allergy_yn.equals("Y"))
				allergy_flag = "visible";
			if(current_rx.equals("Y"))
				currentrx_flag = "visible";
		//}
		if(allergy_yn.equals("Y") || limit_ind.equals("Y") || current_rx.equals("Y"))
				over_ride_flag="visible";*/

		String tdmOrderId = "";
			   tdmOrderId			= iv_bean.getOrderIdForTDMDtls(patient_id,drug_codes);

		if(tdmOrderId==null||tdmOrderId.equals("")){
			display_tdm="visibility:hidden";
		}else{
			display_tdm="visibility:visible";
		} 

		if(drugDetails != null){
			drug_code			= (String)drugDetails.get("DRUG_CODE");


		   if(Integer.parseInt(adr_count)>0){
				int drug_adr_count = iv_bean.getADRCount(patient_id,drug_code);   
				if(drug_adr_count>0){
					drug_adr_style="visible";
				}
			}
			drug_db_dosage_check_flag	= (String) drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	

			perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");		
			loading_ext_prod_id				 = ext_prod_id;

			external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
			external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");	
			external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");	
			external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");	
			external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON")==null?"":(String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");	
		}

		
		//code for drug interaction check
		HashMap drug_Interactions				= null;
		String drug_db_interact_check_flag	= "N";
		String drug_db_duptherapy_flag		= "N";
		String drug_db_contraind_check_flag	= "N";
		String dup_drug_det					= "";
		String external_database_overrided_yn = "";
		String external_database_overrided_reason = "";
	//perform_external_database_checks_yn = "Y"; && !mode.equals("amend")

		if(perform_external_database_checks_yn.equals("Y")&& !(ext_prod_id.equals("")) ){
			if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
					
				HashMap tempDetails= null;
				ArrayList reqChecks = new ArrayList();
				reqChecks.add("N"); //Dosage Check 
				reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
				reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
				reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
				reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
				HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", null ,null, null, "N","",""); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
				if(drugDBCheckResult!=null)
					beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
				if(drug_db_allergy_check_yn.equals("Y")){
					/*tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
					if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
						drug_db_allergy_check_flag="Y";
					}*/
					if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS)
						String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
						if(allergy_alert!=null && !allergy_alert.equals(""))
							drug_db_allergy_check_flag="Y";
					} 
					else {  
						tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
						if(tempDetails!=null && tempDetails.size()>0){
							 drug_db_allergy_check_flag="Y";
						}
					} 					
				}

				if(drug_db_interact_check_yn.equals("Y")){
					tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
					if(tempDetails!=null && tempDetails.size()>0){
						 drug_db_interact_check_flag="Y";
					}
				}

				if(drug_db_duptherapy_yn.equals("Y")){ 
				   dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
				   if(dup_drug_det!=null && !dup_drug_det.equals(""))
						drug_db_duptherapy_flag="Y";
				}
				if(drug_db_contraind_check_yn.equals("Y")){
					tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
					if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
						drug_db_contraind_check_flag="Y";
					}		
				}
			}
			/*
			if(drug_db_interact_check_yn.equals("Y")){
				if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
					beanex.getDDInteractions(loading_ext_prod_id);//Store interactions
					drug_Interactions		= beanex.getInteractions();//get Interactions
					if(drug_Interactions.size()>0){							
					   drug_db_interact_check_flag = "Y";
					   interaction_override_reason_flag = "Y";
					   external_database_checks_overrided = "Y";
					}
				}
			}

			if(drug_db_duptherapy_yn.equals("Y")){ 

				dup_drug_det			= beanex.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result
				if(!dup_drug_det.equals("")&&dup_drug_det!=null){
					current_rx = "N";
					drugDetails.put("CURRENT_RX","N");
					drug_db_duptherapy_flag = "Y";
					duplicate_drug_override_reason_flag = "Y";
					external_database_checks_overrided = "Y";
				}
			}
			if(drug_db_contraind_check_yn.equals("Y")){
				if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
					ArrayList ex_prod_ids =new ArrayList();
					ex_prod_ids.add(loading_ext_prod_id);

					boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
					HashMap contra_indications =(HashMap)beanex.getContraIndications();
					if(contra_indications.containsKey(ext_prod_id)){
						// String  contra_indication_for_drug   =(String)contra_indications.get(ext_prod_id);
					   if(contra_indications.containsKey(ext_prod_id)){
						drug_db_contraind_check_flag = "Y";
						contraind_override_reason_flag = "Y";
						external_database_checks_overrided = "Y";
					   }
					}					  
				}
			}
			
			if(drug_db_allergy_check_yn.equals("Y")){ 
				ArrayList ex_prod_ids =new ArrayList();
					ex_prod_ids.add(loading_ext_prod_id);
				if(ext_prod_id!=null&& !ext_prod_id.equals("") && ex_prod_ids!=null && !ex_prod_ids.equals("")){
					beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get allergy
					HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();
//out.println("drug_alergies="+drug_alergies+"==ext_prod_id=="+ext_prod_id);
					if(drug_alergies.containsKey(ext_prod_id)){
						allergy_yn = "N";
						drugDetails.put("ALLERGY_YN","N");
						drug_db_allergy_check_flag="Y";
					}	
				}
			}
			*/
			if(drugDetails != null){
				drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
				drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
				drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
				drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_check_flag);
			}
			
			drugDetails.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);

			if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
				external_database_overrided_yn = "Y";

			if(external_database_overrided_yn.equals("Y") && (external_interaction_override_reason.equals("")|| external_duplicate_override_reason.equals("") || external_contra_override_reason.equals("") || external_dosage_override_reason.equals("") || external_alergy_override_reason.equals("")))
				external_database_overrided_reason="N";
			else
				external_database_overrided_reason="Y";
			if(external_database_overrided_reason.equals("Y"))
				external_checks	= "hidden";
			else
				external_checks = "visible";

			drugDetails.put("EXTERNAL_DATABASE_OVERRIDED_REASON",external_database_overrided_reason);
	

			if(drug_db_dosecheck_yn.equals("N") && drug_db_duptherapy_yn.equals("N") && drug_db_interact_check_yn.equals("N") && drug_db_contraind_check_yn.equals("N") && drug_db_allergy_check_yn.equals("N"))
				external_checks	= "hidden";
	

		/*	if(perform_external_database_checks_yn.equals("Y")){
				external_checks = "visible";
			}*/

			if(drug_db_duptherapy_flag.equals("Y"))
				currentrx_flag = "hidden";
			if(drug_db_dosage_check_flag.equals("Y"))
				doselimit_flag = "hidden";
			if(drug_db_allergy_check_flag.equals("Y"))
				allergy_flag = "hidden";
		}
		else{
			drug_db_product_id = "";
		}


		if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
				external_database_overrided_yn = "Y";


		if(external_database_overrided_yn.equals("Y") && (drug_db_interact_check_flag.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && external_duplicate_override_reason.equals("") )|| (drug_db_contraind_check_flag.equals("Y")&& external_contra_override_reason.equals("") )|| (drug_db_dosage_check_flag.equals("Y") && external_dosage_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && external_alergy_override_reason.equals("")))
			external_database_overrided_reason="N";
		else{
			external_database_overrided_reason="Y";
		}

		if(external_database_overrided_reason.equals("Y"))
			external_checks	= "hidden";
		else
			external_checks = "visible";

		if(limit_ind.equals("N"))
			doselimit_flag = "visible";
	
		//}
//out.println("allergy_yn="+allergy_yn+"=drug_db_allergy_check_yn="+drug_db_allergy_check_yn+"=allergy_override_reason="+allergy_override_reason);
		if(allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {
				if(allergy_override_reason.equals("")){
					allergy_flag = "visible";
					allergy_flag_img = "visible";
				}
				else{
					allergy_flag = "visible";
					allergy_flag_img = "hidden";
				}
			}else{
				allergy_flag = "hidden";
				allergy_flag_img = "hidden";
			}



			if(current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
				if(duplicate_drug_override_reason.equals("")){
					currentrx_flag = "visible";
					currentrx_flag_img = "visible";
				}
				else{
					currentrx_flag = "visible";
					currentrx_flag_img = "hidden";
				}
			}else{
				currentrx_flag = "hidden";
				currentrx_flag_img = "hidden";
			}

		if(limit_ind.equals("N") && !drug_db_dosecheck_yn.equals("Y")) {
				if(dosage_limit_override_reason.equals("")){
					doselimit_flag = "visible";
					doselimit_flag_img = "visible";
				}
				else{
					doselimit_flag = "visible";
					doselimit_flag_img = "hidden";
				}
			}
		else{
				doselimit_flag = "hidden";
				doselimit_flag_img = "hidden";
		}

		if(allergy_yn.equals("Y") || limit_ind.equals("N") || current_rx.equals("Y"))
				over_ride_flag="visible";


		
	/*	if(mode.equals("amend")){
			out.println(doselimit_flag_img+",,"+allergy_flag_img+",,"+currentrx_flag_img);
			if(doselimit_flag_img.equals("visible") || allergy_flag_img.equals("visible") || currentrx_flag_img.equals("visible"))
					over_ride_flag="visible";
			else
				over_ride_flag="hidden";
		}*/

	//	iv_bean.setIVPB("Y");

%>
		<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
			<form name="formIVPiggyBackDrugDetails" id="formIVPiggyBackDrugDetails" >
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
			
					<tr>
						<td class="COLUMNHEADER" colspan="6"><font style="font-size:9"><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></font></td>
					</tr>
					<tr>
						<td class="label" width="2%">
							<table>

								<td NOWRAP width="12" class="label" id="adr" name="adr" ><img style="visibility:<%=drug_adr_style%>" id="ADR_img" src='../../ePH/images/ADR.gif' height =25 width =25 title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></td>
<%								
								if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
									if(((drug_db_interact_check_flag.equals("Y") && drug_db_interact_check_yn.equals("Y"))|| (drug_db_duptherapy_flag.equals("Y") && drug_db_duptherapy_yn.equals("Y") )|| (drug_db_contraind_check_flag.equals("Y")&& drug_db_contraind_check_yn.equals("Y") )|| (drug_db_dosage_check_flag.equals("Y") && drug_db_dosecheck_yn.equals("Y")) || (drug_db_allergy_check_flag.equals("Y") && drug_db_allergy_check_yn.equals("Y"))) && !ext_prod_id.equals("")){
%>
										<td NOWRAP width="12" class="SHIFTTOTAL" id="external" name="external"  onclick="displayDosageCheckResult('1','presc')"><img  id="external_img" name="external_img" src='../../ePH/images/exceed1.gif' ></img></td>
<%									}else{
%>
										<td NOWRAP width="12" id="external" name="external"  onclick="displayDosageCheckResult('1','presc')"><img  id="external_img" name="external_img" src='../../ePH/images/exceed1.gif' style="visibility:hidden"></img></td>
<%									}							
								}else{
									if((drug_db_interact_check_flag.equals("Y") && drug_db_interact_check_yn.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && drug_db_duptherapy_yn.equals("Y") && external_duplicate_override_reason.equals(""))|| (drug_db_contraind_check_flag.equals("Y")&& drug_db_contraind_check_yn.equals("Y")&& external_contra_override_reason.equals("") )|| (drug_db_dosage_check_flag.equals("Y") && drug_db_dosecheck_yn.equals("Y")&& dosage_limit_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && drug_db_allergy_check_yn.equals("Y")&& external_alergy_override_reason.equals(""))){										
%>
										<td NOWRAP width="12" class="SHIFTTOTAL" id="external" name="external"  onclick="displayDosageCheckResult('1','presc')"><img  id="external_img" name="external_img" src='../../ePH/images/exceed1.gif' ></img></td>

<%									}
									else if((drug_db_interact_check_flag.equals("Y") && !external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && !external_duplicate_override_reason.equals(""))|| (drug_db_contraind_check_flag.equals("Y")&& !external_contra_override_reason.equals("") )|| (drug_db_dosage_check_flag.equals("Y") && !dosage_limit_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && !external_alergy_override_reason.equals(""))){
%>
										<td NOWRAP width="12" class="SHIFTTOTAL" id="external" name="external"  onclick="displayDosageCheckResult('1','presc')"><img  id="external_img" name="external_img" src='../../ePH/images/exceed1.gif' style="visibility:hidden"></img></td>

<%									}else{
	%>
										<td NOWRAP width="12" id="external" name="external"  onclick="displayDosageCheckResult('1','presc')"><img  id="external_img" name="external_img" src='../../ePH/images/exceed1.gif' style="visibility:hidden"></img></td>
	<%								}
								}
%>								
								<td NOWRAP width="12" class="ALLERGY" id="allergy" style="visibility:<%=allergy_flag%>" TITLE='<fmt:message key="ePH.AllergyDrug.label" bundle="${ph_labels}"/>' onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');"><img style="visibility:<%=allergy_flag_img%>" id="allergy_img" src='../../ePH/images/exceed1.gif' ></img></td>
								<td NOWRAP width="12" class="DOSELIMIT" id="ovr_dosage"  style="visibility:<%=doselimit_flag%>" TITLE='<fmt:message key="ePH.ExceedDosageLimit.label" bundle="${ph_labels}"/>' onClick="showDosageLimit('<%=drug_desc%>','<%=mono_graph%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>','<%=dosage_unit%>','<%=dosage_std%>' );"><img style="visibility:<%=doselimit_flag_img%>" id="ovr_dosage_img" src='../../ePH/images/exceed1.gif' ></img></td>
								<td NOWRAP width="12" class="CURRENTRX" id="currentrx" style="visibility:<%=currentrx_flag%>" TITLE='<fmt:message key="ePH.DuplicateMedication.label" bundle="${ph_labels}"/>' onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')"><img style="visibility:<%=currentrx_flag_img%>" id="currentrx_img" src='../../ePH/images/exceed1.gif' ></img></td>
						</table>
					</td>
			<!-- onblur="checkValidDrug('D', this.value)" -->
					<td width='30%' class="label" nowrap>
						<fmt:message key="Common.Drug.label" bundle="${common_labels}"/>&nbsp;
						<input type="text" name="drug_name" id="drug_name" value="<%=drug_desc%>"  size="38" maxlength="60" >
						<input type="button" class="button" name="drug_search" id="drug_search" value="?" <%=disabled1%> onfocus = "searchIVDrug(formIVPiggyBackDrugDetails,'D', drug_name);volume_focus();" onclick="searchIVDrug(formIVPiggyBackDrugDetails,'D', drug_name)" >
						<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_codes%>">
						<img id="mandatory" src="../../eCommon/images/mandatory.gif"  ></img>
<%						if(!drug_desc.equals("")){
%>
						<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(drug_code.value);" id="edlImg" >
<%
						}else{	
%>
						
						<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=hidden" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(drug_code.value);" id="edlImg" >
<%						}
%>
					</td>

	<!--				
					<td class="label" width="15%" nowrap>
						<fmt:message key="Common.Dosage.label" bundle="${common_labels}"/>
						<input type="text" name="dosage" id="dosage" value="<%=qty_value%>" <%=readonly%> onKeyPress="return allowValidNumber(this,event,8,2);" onBlur="CheckNum(this);setVolume(this);DosageLimitCheck(this);" size="5"  maxlength="5" style="text-align:right">
						<label id="dosage_unit"></label>
					</td>

-->
					
					<td class="label" width="12%" nowrap>

							<input style="visibility:<%=over_ride_flag%>" type="button" class="button" width="5%" value='<fmt:message key="Common.override.label" bundle="${common_labels}"/>' id="dosage_limit" onclick="showOverRideRemarks()" > 

						&nbsp;<A title="TDM Result" id="tdmRslt" style="<%=display_tdm%>" HREF onMouseOver="changeCursor(this);"	onClick="viewReasonforRequest(tdmOrderId.value);"><fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/></A>
					</td>
<%
					if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
%>
						<td class="label" id="iv_admixture" width ="10%" nowrap> 
							<fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/>
							<input type="checkbox" name="admixture" id="admixture" <%=checked%> <%=disable_addmixture%> value="N" onClick="setAdmixtureValue(formIVPiggyBackDrugDetails),checkadmixture(formIVPiggyBackDrugDetails)">				
						</td>
<%
					}
					else if(f_i_flag.equals("Y")){
%> 
								
						<td class="label" id="iv_admixture" width ="10%">&nbsp;<input type="checkbox" name="admixture" id="admixture" style="visibility:hidden" value="N">	</td>  
<%
					}
					else{
%> 
						<td class="fields" id="iv_admixture" width ="10%" nowrap>
						<fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/>
						<input type="checkbox" name="admixture" id="admixture" <%=checked%> value="N" onClick="setAdmixtureValue(formIVPiggyBackDrugDetails)">				
						</td>             
<%
					}
					if(MAR_app_yn.equals("Y")){
%>
						<td class='label' width ="10%"><fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
						<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> onclick='assignValue(this);'></td>
<%
					}
					else{
%>
						<td class='label'width ="10%" ><!-- &nbsp;<input type='hidden' name='buildMAR_yn' id='buildMAR_yn' value='N'> -->
							<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
							<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='N' disabled>
						</td>
<%
					}
%>
					</tr>					
<!-- ******************************************* -->
				 <TR>
						<% if (strength_value.equals("0")) {				
						select_calc_dose_Dosage="checked";
						select_calc_dose_WT_BSA="";
						disable_calc_dose="disabled";						
						}%>
						<td class="label" width="2%"></td>
						<TD colspan=9>
							<TABLE border=0>
							<TR>						
								<TD CLASS="label">Calculate By</TD>
								<TD CLASS="label">Dosage <input type="radio" id="CALC_DOSE_BASED_ON_D" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="D" <%=select_calc_dose_Dosage%> <%=disable_calc_dose%> onClick="setCalculateBy(this,'<%=mode%>');" ></TD>
								<TD CLASS="label">Body wt/BSA <input type="radio" id="CALC_DOSE_BASED_ON_B" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="B" <%=select_calc_dose_WT_BSA%> <%=disable_calc_dose%> onClick="setCalculateBy(this,'<%=mode%>');" ></TD>
							</TR>
							</TABLE>
						</TD>
				</TR>
				<tr <%=displaydose%> id="calc_by_row1">
					<td class="label" width="2%"></td>
					<TD WIDTH="15%"  CLASS="label" nowrap><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/>
						<SELECT name="dosage" id="dosage" onChange="changeScrDetails(this.value);ExternalDosageCheck('','presc');"  onchange='setDrugDosageDetails()' >
<%						//disaExst
						if (strength_value.equals("0")) {
%>								
							<OPTION VALUE="Q"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>
<%						}
						else {
							if(dosage_type.equals("Q")) {
%>
									<OPTION VALUE="S"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></OPTION>
									<OPTION VALUE="Q" SELECTED><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>
<%
							}
							else {
%>
									<OPTION VALUE="S" SELECTED><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></OPTION>
									<OPTION VALUE="Q"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>
<%
							}
						}
%>
							</SELECT>
						</TD>
<%
						String str_value = "";
						if (strength_value.equals("0")) {
							disabled = "";
							str_value	= pres_qty_value;
%>
							<TD WIDTH="10%" CLASS="label" ID="DOSAGE_LABEL"><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/></TD>
<%						}
						else {
							if(dosage_type.equals("S")) {
								str_value	= strength_value;
								disabled	= "DISABLED";
%>
								<TD WIDTH="10%" CLASS="label" ID="DOSAGE_LABEL"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/>&nbsp;</TD>
<%
							}
							else {
								str_value	= pres_qty_value;
								disabled	= "";
%>
								<TD WIDTH="10%" CLASS="label" ID="DOSAGE_LABEL"><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/></TD>
<%
							}
						}
						if(qty_value!=null && !qty_value.equals("")) {
							str_value	=	qty_value;
						}
						if(orderSetValues.size() > 0){
							for(int i = 0; i < orderSetValues.size(); i=i+8){
								if(orderSetValues.get(i).equals(drug_code)){
									qty_value	= (String)orderSetValues.get(i+1);
									if(dosage_type.equals("S")){
										str_value = ((Float.parseFloat(qty_value)*Float.parseFloat(strength_value))/Float.parseFloat(strength_per_value_pres_uom))+"";
									}
								}
							}
						}
%>
						<TD > 
								
							<INPUT TYPE="text" name="STRENGTH_VALUE" id="STRENGTH_VALUE" class="NUMBER" VALUE="<%= str_value %>" SIZE="10" MAXLENGTH="11" onBlur="setCalculatedQty(this); DosageLimitCheck(this);setDrugDosageDetails();"  onKeyPress="return allowValidNumber(this,event,8,<%=dose_decimal%>);" >&nbsp;
							
							<SELECT name="STRENGTH_UOM" id="STRENGTH_UOM" <%= disabled %>  onchange='setDrugDosageDetails()'>
<%//disaExst
							if (!strength_value.equals("0")) {

								if(dosage_type.equals("S")) {

%>
									<OPTION VALUE="<%= strength_uom %>"><%= strength_uom_desc %></OPTION>
<%
								}
								else {
%>
									<OPTION VALUE="">&nbsp;--- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> ---&nbsp;</OPTION>
<%
									Hashtable QtyDescDetails	= (Hashtable)iv_bean.listQtyDetails(drug_codes);
									Enumeration keys_des		= QtyDescDetails.keys();
									String def_uom				= "";

									while(keys_des.hasMoreElements()) {
										uom_code	= (String)keys_des.nextElement();
										uom_desc	= (String)QtyDescDetails.get(uom_code);

										if(!uom_code.equals("dflt_code")) {
//											if(uom_code.equals(qty_desc_code))qty_unit
											if(uom_code.equals(dosage_uom_code))
												def_uom = "SELECTED";
											else
												def_uom = "";
%>
											<OPTION VALUE="<%= uom_code %>" <%= def_uom %>><%= uom_desc %></OPTION>
<%
										}
									}
								}
							}
							else {
%>
								<OPTION VALUE="">&nbsp;--- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> ---&nbsp;</OPTION>
<%
								Hashtable QtyDescDetails	= (Hashtable)iv_bean.listQtyDetails(drug_codes);
								Enumeration keys_des		= QtyDescDetails.keys();
								String def_uom				= "";

								if (amend_yn.equals("N"))
									dflt_code = QtyDescDetails.get("dflt_code") == null ? "" : QtyDescDetails.get("dflt_code").toString();
								else
									dflt_code = qty_desc_code;
								while(keys_des.hasMoreElements()) {
									uom_code	= (String)keys_des.nextElement();
									uom_desc	= (String)QtyDescDetails.get(uom_code);

									if(!uom_code.equals("dflt_code")) {
//										if(uom_code.equals(dflt_code))
										if(uom_code.equals(qty_unit))
											def_uom = "SELECTED";
										else
											def_uom = "";
%>
										<OPTION VALUE="<%= uom_code %>" <%= def_uom %>><%= uom_desc %></OPTION>
<%
									}
								}
							}
							
%>
							</SELECT><IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
						</TD>

			</tr>
<!-- ****************************** -->
			<TR <%=displayBSA%> id="calc_by_row2">
			<TD CLASS="label" width="2%">&nbsp</TD>
			<TD CLASS="label" nowrap colspan=9>Dose &nbsp;
			<input type="text" name="CALC_DOSE_VALUE" id="CALC_DOSE_VALUE" value="<%=calc_dose_value%>" size="5" maxlength="8" onKeyPress="return allowValidNumber(this,event,4,3);" onBlur="calculateDosage_By_BSA_or_Weight('<%=mode%>');">
			<select name="calc_dose_value_unit" id="calc_dose_value_unit"><OPTION VALUE="<%=strength_uom%>"><%= strength_uom_desc%></OPTION></select><label class="label"><b> / </b></label><select name="CALC_DOSE_BY" id="CALC_DOSE_BY" onChange="calculateDosage_By_BSA_or_Weight('<%=mode%>');"><option value="KG" <%=kg_selected%>>Kg</option><option value="M2" <%=m2_selected%>>M2</option></select><label class="label"><b> = </b></label><INPUT TYPE="text" name="strength_value_wt_bsa" id="strength_value_wt_bsa"  VALUE="<%=qty_value%>" SIZE="10" MAXLENGTH="12" onKeyPress="return allowValidNumber(this,event,8,3);" class="number">&nbsp;<label class="label"> <b><%=strength_uom_desc%></b></label>
			<img src="../../eCommon/images/mandatory.gif" BORDER="0"></img></TD>			
			</TR>
			<tr>
					<td colspan='2'>&nbsp;
					</td>
					<TD WIDTH="8%" CLASS="label">
						<label id='rec_legend' onclick='defaultRecomDose()' style="<%=display%>">
						<font class='HYPERLINK' onmouseover='changeCursor(this);'>
						<fmt:message key="ePH.Recom.Dose.label" bundle="${ph_labels}"/></font>
						</label>
						<label id="rec_value" style="font-size:11;font-weight:bold;color:red" style="<%=display%>"><%=dosage_std%></label>
						&nbsp;<label id="rec_uom" style="font-size:11;font-weight:bold;color:red" style="<%=display%>"><%=dosage_unit%></label>
					</td> 
					<td colspan='3'>&nbsp;</td>
			</tr>
			</table>
				
<%
				if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
%>
					<script>formIVPiggyBackDrugDetails.drug_name.focus();</script>
<%
				}
%>
				<INPUT TYPE="hidden" name="FORM_CODE" id="FORM_CODE" VALUE="<%= form_code %>">
				<INPUT TYPE="hidden" name="DRUG_CODE" id="DRUG_CODE" VALUE="<%= drug_codes %>">
				<INPUT TYPE="hidden" name="PRES_QTY_VALUE" id="PRES_QTY_VALUE" VALUE="<%= pres_qty_value %>">
				<INPUT TYPE="hidden" name="PRES_BASE_UOM" id="PRES_BASE_UOM" VALUE="<%= pres_base_uom %>">
				<INPUT TYPE="hidden" name="UOM_CODE" id="UOM_CODE" VALUE="<%= uom_code %>">
				<INPUT TYPE="hidden" name="dosage_unit" id="dosage_unit" VALUE="<%= dosage_unit %>">
				<INPUT TYPE="hidden" name="STRENGTH_UOM_DESC" id="STRENGTH_UOM_DESC" VALUE="<%= strength_uom_desc %>">
				<INPUT TYPE="hidden" name="STRENGTH_UOM_CODE" id="STRENGTH_UOM_CODE" VALUE="<%= strength_uom %>">
				<INPUT TYPE="hidden" name="STR_VAL" id="STR_VAL" VALUE="<%= strength_value %>">
				<input type="hidden" name="ORDERSET_STRENGTH" id="ORDERSET_STRENGTH" value="<%=str_value%>">
				<INPUT TYPE="hidden" name="QTY_DESC_CODE" id="QTY_DESC_CODE" VALUE="<%= qty_desc_code %>">

				<input type="hidden"	name="mode" id="mode"	value="<%=mode%>">
				<input type="hidden"	name="patient_class" id="patient_class"	value="<%=patient_class%>">
				<input type="hidden"	name="bean_id" id="bean_id"			value="<%=bean_id%>"	>
				<input type="hidden"	name="bean_name" id="bean_name"		value="<%=bean_name%>"	>
				<input type="hidden"	name="patient_id" id="patient_id"		value="<%=patient_id%>"	>
				<input type="hidden"	name="encounter_id" id="encounter_id"		value="<%=encounter_id%>">
				<input type="hidden"	name="iv_bean_id" id="iv_bean_id"		value="<%=iv_bean_id%>"	>
				<input type="hidden"	name="iv_bean_name" id="iv_bean_name"		value="<%=iv_bean_name%>">
				<input type="hidden"	name="f_i_flag" id="f_i_flag"			value="<%=f_i_flag%>">	

				<input type="hidden"	name="mono_graph" id="mono_graph"	value="<%=mon_graph%>">
				<input type="hidden"	name="daily_dose" id="daily_dose"		value="<%=daily_dose%>">
				<input type="hidden"	name="unit_dose" id="unit_dose"		value="<%=unit_dose%>">
				<input type="hidden"	name="min_daily_dose" id="min_daily_dose"	value="<%=min_daily_dose%>">
				<input type="hidden"	name="min_unit_dose" id="min_unit_dose"	value="<%=min_unit_dose%>">
				<input type="hidden"	name="recom_dosage_unit" id="recom_dosage_unit"	value="<%=dosage_unit%>">
				<input type="hidden"	name="drug_desc" id="drug_desc"	    value="<%=drug_desc%>">
				<input type="hidden"	name="recomm_yn" id="recomm_yn"	    value="<%=recomm_yn%>">
				<input type="hidden"	name="dosage_std" id="dosage_std"	    value="<%=dosage_std%>">
				<input type="hidden"	name="recomm_dosage_by" id="recomm_dosage_by"	    value="<%=recomm_dosage_by%>">
				<input type="hidden"	name="calc_by_ind" id="calc_by_ind"	    value="<%=calc_by_ind%>">
				<input type="hidden"	name="tdmOrderId" id="tdmOrderId"	    value="">
				<input type="hidden"	name="order_set_code" id="order_set_code"	value="<%=order_set_code%>">
				<input type="hidden"	name="dosage_by" id="dosage_by"	value="<%=dosage_by%>">
				<input type="hidden"	name="MAR_app_yn" id="MAR_app_yn"	value="<%=MAR_app_yn%>">

				<input type="hidden"	name="generic_id" id="generic_id"	    value="<%=generic_id%>">	
				<input type="hidden"	name="generic_name" id="generic_name"	    value="<%=generic_name%>">

				<input type="hidden"	name="limit_ind" id="limit_ind"	    value="<%=limit_ind%>">
				<input type="hidden"	name="allergy_yn" id="allergy_yn"	    value="<%=allergy_yn%>">
				<input type="hidden"	name="current_rx" id="current_rx"	    value="<%=current_rx%>">
				<input type="hidden"	name="srl_no" id="srl_no"			value="<%=srl_no%>">
				<input type="hidden"	name="allergy_desc" id="allergy_desc"	    value="<%=allergy_desc%>">
				<input type="hidden"	name="exceed_dose_desc" id="exceed_dose_desc"	value="<%=exceed_dose_desc%>">
				<input type="hidden"	name="dup_drug_desc" id="dup_drug_desc"	value="<%=dup_drug_desc%>"> 
				<input type="hidden"	name="order_id" id="order_id"	value="<%=order_id%>"> 
		<!-- for validating ivapplicapable parameter in PH PARAMETER FOR FACILITY -->
<%
				if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
%>
					<!-- <input type="hidden"	name="time_flag" id="time_flag"	value="<%=time_flag%>"> -->
					<input type="hidden"	name="alert_practitioner_yn" id="alert_practitioner_yn"	value="<%=alert_practitioner_yn%>">
<%
				}
				if(order_type_flag.equals("Existing")||mode.equals("amend")){
%>
					<input type="hidden"	name="AUTH_YN_VAL" id="AUTH_YN_VAL"	    value="Y">
					<input type="hidden"	name="APPROVAL_YN_VAL" id="APPROVAL_YN_VAL"	value="Y">
					<input type="hidden"	name="COSIGN_YN_VAL" id="COSIGN_YN_VAL"	value="Y">
<%
				}
				else {
%>
					<input type="hidden"	name="AUTH_YN_VAL" id="AUTH_YN_VAL"		value="">
					<input type="hidden"	name="APPROVAL_YN_VAL" id="APPROVAL_YN_VAL"	value="">
					<input type="hidden"	name="COSIGN_YN_VAL" id="COSIGN_YN_VAL"	value="">
<%
				}
%>
			<!--end here -->
				<input type="hidden" name="perform_external_database_checks_yn" id="perform_external_database_checks_yn" value="<%=perform_external_database_checks_yn%>">
				<input type="hidden" name="external_product_id" id="external_product_id"     value="<%=ext_prod_id%>">
				<input type="hidden" name="fract_dose_round_up_yn" id="fract_dose_round_up_yn"  value="<%=fract_dose_round_up_yn%>">
				<input type="hidden" name="external_dosage_override_reason" id="external_dosage_override_reason" value=<%=java.net.URLEncoder.encode(external_dosage_override_reason)%>>
				<input type="hidden" name="external_duplicate_override_reason" id="external_duplicate_override_reason" value=<%=java.net.URLEncoder.encode(external_duplicate_override_reason)%>>
				<input type="hidden" name="external_interaction_override_reason" id="external_interaction_override_reason" value=<%=java.net.URLEncoder.encode(external_interaction_override_reason)%>>
				<input type="hidden" name="external_contra_override_reason" id="external_contra_override_reason" value=<%=java.net.URLEncoder.encode(external_contra_override_reason)%>>
				<input type="hidden" name="external_alergy_override_reason" id="external_alergy_override_reason" value="<%=java.net.URLEncoder.encode(external_alergy_override_reason)%>">
				<input type="hidden" name="drug_db_dose_check_flag" id="drug_db_dose_check_flag" value="<%=drug_db_dosage_check_flag%>">
				<input type="hidden" name="ext_med_alerts_fired_for_dup_check_yn" id="ext_med_alerts_fired_for_dup_check_yn" value="<%=drug_db_duptherapy_flag%>">
				<input type="hidden" name="ext_med_alerts_fired_for_inte_check_yn" id="ext_med_alerts_fired_for_inte_check_yn" value="<%=interaction_override_reason_flag%>">
				<input type="hidden" name="ext_med_alerts_fired_for_contra_check_yn" id="ext_med_alerts_fired_for_contra_check_yn" value="<%=contraind_override_reason_flag%>">
				<input type="hidden" name="ext_med_alerts_fired_for_allergy_check_yn" id="ext_med_alerts_fired_for_allergy_check_yn" value="<%=drug_db_allergy_check_flag%>">
			</form>
<%
			if(!mode.equals("amend")){
%>
				<script>changeScrDetails(document.formIVPiggyBackDrugDetails.dosage.value)</script>
<%
			}
	   if(iv_prep_default.equals("3") || iv_prep_default.equals("4")){
			orderSetCodes = (ArrayList) iv_bean.getOrdersetCodes(order_set_code);
			strDrugCode = (String) orderSetCodes.get(1);
%>
		<script>
		   	setTimeout("searchOrdersetPiggyBack('D','<%=order_set_code%>','<%=patient_class%>','<%=strDrugCode%>','<%=bean_id%>','<%=bean_name%>','<%=patient_id%>','<%=encounter_id%>');",1000);
		</script>
<%
		}

%>

		<script>

<%
	
			if(order_type_flag.equals("Existing")||mode.equals("amend")){
				if(!prev_order.equals("") && prev_order.equals("previous")){
%>	
					parent.parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails.all.dosage_unit.innerText ="<%=qty_unit%>";
					parent.parent.f_ivdetails.f_iv_pb_drug.formIVPiggyBackDrugDetails.mandatory.style.visibility="hidden";
<%	
				}
				else{
%>	
					parent.parent.f_detail.f_iv_pb_drug.formIVPiggyBackDrugDetails.all.dosage_unit.innerText ="<%=qty_unit%>";
	
					parent.parent.f_detail.f_iv_pb_drug.formIVPiggyBackDrugDetails.mandatory.style.visibility="hidden";
<%	
				}
			}
			
%>
			if(parent.f_iv_pb.document.forms[0] == undefined){
				parent.f_iv_pb.location.href="IVPiggyBackVehicle.jsp?<%= params %>";
			}
		 setSchedule();
		</script>
<%
		if (mode!=null && !mode.equals("blank")&& !mode.equals("amend") && request.getParameter("drugSelect")!=null && !request.getParameter("drugSelect").equals("Y") && perform_external_database_checks_yn.equals("Y")){		  
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
				  //out.println("viewMedicationAlert('"+patient_id+"','"+loading_ext_prod_id+"','"+drug_db_interact_check_flag+"','"+drug_db_duptherapy_flag+"','"+drug_db_contraind_check_flag+"','"+drug_db_dosage_check_flag+"','ONLOAD','"+external_dosage_override_reason+"','"+drug_code+"','"+srl_no+"','"+external_duplicate_override_reason+"','"+external_interaction_override_reason+"','"+external_contra_override_reason+"','"+pract_name+"','"+external_alergy_override_reason+"','"+drug_db_dosecheck_yn+"')");
%>

				</script>
<%
			}
%>
		</html>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(iv_bean_id,iv_bean,request);
		putObjectInBean(or_bean_id,ORbean,request);	
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>

