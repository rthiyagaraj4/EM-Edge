<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
23/07/2019	IN070451		Manickavasagam J			       						ML-MMOH-CRF-1408
12/08/2019	IN070451		B Haribabu          12/08/2019     Manickavasagam J	    ML-MMOH-CRF-1408
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String patient_id					= request.getParameter("patient_id");
	String encounter_id					= request.getParameter("encounter_id");
	String start_date					= request.getParameter("start_date");
	String adr_count					= request.getParameter("adr_count");
    String order_type_flag		        = request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	HashMap Existingrecord;
	String amend_srl_no                 ="";
	String catalog_code                 ="";
	String bean_id						= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name					= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean			= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	ArrayList drugList					= bean.getDrugDetails();
	String fluid_frame_display_yn		= "N";
	String tmp_srl_no					=null;
	String tmp_comp_freq_code			=null;
	String tmp_comp_durn_value			=null;
	String tmp_comp_durn_type			=null;
	String tmp_fluid_frame_display_yn	=null;
	String tmp_count                    =null;
	String classValue					="";
	int    count                        =0;
	String flag							="N";
	String existing_order_id            ="";
	int    size                         =0;
	String dosage_unit                  ="";
	String amend_dup_drug				="";
	String adr_display_yn				="N";
	String fluid_adr_display_yn			="N";

	String facility_id					= (String)session.getValue("facility_id");
	String param_bean_id				= "@DrugInterfaceControlBean";
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
	
	String drug_db_product_id			=	param_bean.getDrugDBProductID(facility_id);
    String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);  
	String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
	String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
	String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
	String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
	String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);
	param_bean.clear();

	String or_bean_name			= "eOR.OrderEntryBean";
	String or_bean_id			= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean		= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);

	ArrayList ExistingCYTORecords = new ArrayList();
	ArrayList ex_prod_ids =new ArrayList();
	ArrayList drugDesc	  =new ArrayList();
	if (drugList!=null && drugList.size() > 0) {	
		
		String perform_external_database_checks_yn	=	"";	
		String loading_ext_prod_id					=	"";
		String drug_db_interact_check_flag			= "N";
		String drug_db_duptherapy_flag				= "N";
		String drug_db_contraind_check_flag			= "N";
		String drug_db_dosage_check_flag			= "N";
		String drug_db_allergy_flag					= "N";
		String external_dosage_override_reason		=   "";	
		String external_duplicate_override_reason	=   "";
		String external_interaction_override_reason	=   "";
		String external_contra_override_reason		=   ""; 
		String external_alergy_override_reason		=   ""; 
		String pract_name	= (String)orbean.getPractitionerName();
		String extVisble	= "visible";
		String ex_bean_id   = "@ExternalProductLinkBean";
		String ex_bean_name = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
%>
		<html>
			<head>
				<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
				<script language="javascript" src="../../eCommon/js/common.js"></script>
				<script language="javascript" src="../js/OncologyRegimen.js"></script>
				<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			</head>

			<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
				<form name="oncologyRegimenDrugList" id="oncologyRegimenDrugList">
					<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<%
	 try{

			String drug_code	= "";
			if(order_type_flag.equals("Existing") ){   				 
				ExistingCYTORecords = bean.getExistingCYTORecords();								

				for(int i=0;i<drugList.size();i++) {
					HashMap drugDetails = (HashMap)drugList.get(i);
					if (drugDetails!=null && drugDetails.size() > 0){
						drug_code				= (String)drugDetails.get("DRUG_CODE");
						if(ExistingCYTORecords !=null && ExistingCYTORecords.size()>0){
							for(int j=0;j<ExistingCYTORecords.size();j++){
								Existingrecord = (HashMap)ExistingCYTORecords.get(j);
								if(Existingrecord.get("ORDER_CATALOG_CODE").equals(drug_code)){

									drugDetails.put("CURRENT_RX",Existingrecord.get("CURRENT_RX"));
									drugDetails.put("ALLERGY_YN",Existingrecord.get("ALLERGY_YN"));

								  if(drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON").equals("")){
									drugDetails.put("EXTERNAL_DUPLICATE_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));
								 }
									
								 if(drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON").equals("")){
										drugDetails.put("EXTERNAL_ALERGY_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
								 }
								 if(drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON").equals("")){ //added for IN26007 --24/01/2011-- priya
										drugDetails.put("EXTERNAL_DOSAGE_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));
										
										
								 }
							drugDetails.put("DOSAGE_LIMIT_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_DOSAGE_OVERRIDE_REASON"));
							drugDetails.put("ALLERGY_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_ALERGY_OVERRIDE_REASON"));
							drugDetails.put("DUPLICATE_DRUG_OVERRIDE_REASON",Existingrecord.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON"));

							break;
								}
							}
						}
					}
				}
			}
			for(int i=0;i<drugList.size();i++) {
				drug_db_interact_check_flag			= "N";
				drug_db_duptherapy_flag				= "N";
				drug_db_contraind_check_flag		= "N";
				drug_db_dosage_check_flag			= "N";
				drug_db_allergy_flag					= "N";
				HashMap drugDetails = (HashMap)drugList.get(i);

				if (drugDetails!=null && drugDetails.size() > 0){

					String srl_no					= (String)drugDetails.get("SRL_NO");
					String drug_desc				= (String)drugDetails.get("DRUG_DESC");
						   drug_code				= (String)drugDetails.get("DRUG_CODE");
					String generic_id				= (String)drugDetails.get("GENERIC_ID");
					String generic_name				= (String)drugDetails.get("GENERIC_NAME");
					String allergy_yn				= (String)drugDetails.get("ALLERGY_YN");
					String qty_value				= (String)drugDetails.get("QTY_VALUE");
					String or_qty_desc				= (String)drugDetails.get("OR_QTY_DESC");
					String limit_ind				= (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
					String mono_graph				= (String)drugDetails.get("MONO_GRAPH");
					String daily_dose				= (String)drugDetails.get("DAILY_DOSE");
					String unit_dose				= (String)drugDetails.get("UNIT_DOSE");
					String min_daily_dose			= (String)drugDetails.get("MIN_DAILY_DOSE");
					String min_unit_dose			= (String)drugDetails.get("MIN_UNIT_DOSE");
					String dosage_std				= (String)drugDetails.get("DOSAGE_STD");
					//Added for IN:070451 START
					String max_daily_ceeling_dose			= (String)drugDetails.get("max_daily_ceeling_dose");
					String min_daily_ceeling_dose			= (String)drugDetails.get("min_daily_ceeling_dose");
					String max_unit_ceeling_dose			= (String)drugDetails.get("max_unit_ceeling_dose");
					String min_unit_ceeling_dose			= (String)drugDetails.get("min_unit_ceeling_dose");
					//Added for IN:070451 END
					String current_rx				= (String)drugDetails.get("CURRENT_RX");

					String allergy_override			= (String)drugDetails.get("ALLERGY_OVERRIDE");
					String dose_override			= (String)drugDetails.get("DOSE_OVERRIDE");
					String currentrx_override		= (String)drugDetails.get("CURRENTRX_OVERRIDE");
					String ext_prod_id				= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
					String comp_freq_code			= (String)drugDetails.get("comp_freq_code");
						   if(comp_freq_code == null){comp_freq_code = (String)drugDetails.get("FREQ_CODE");}
					String comp_durn_value			= (String)drugDetails.get("comp_durn_value");
						   if(comp_durn_value == null){comp_durn_value = (String)drugDetails.get("DURN_VALUE");}
					String comp_durn_type			= (String)drugDetails.get("comp_durn_type");
						   if(comp_durn_type == null){comp_durn_type = (String)drugDetails.get("DURN_TYPE");}
					String amend_fluid_name			= (String)drugDetails.get("amend_fluid_name")==null? "" :(String)drugDetails.get("amend_fluid_name");
					String dose_unit_desc = ""; //ML-MMOH-CRF-1408 - start
					String dose_unit_desc1 = "";//Added for IN:070451
					String dosage_uom			= drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
 						if(!dosage_uom.equals("")){ 
						   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_uom); 
						   dose_unit_desc1 =dose_unit_desc;//Added for IN:070451
	 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
	 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_uom.split("/")[0]));
	 						 dose_unit_desc1 =dose_unit_desc;//Added for IN:070451
						      dose_unit_desc =dose_unit_desc+"/"+(dosage_uom.split("/")[1]);
	 						} 
 						}
					//ML-MMOH-CRF-1408 - End
					String amend_fluid_code			= (String)drugDetails.get("amend_fluid_code")==null? "" :(String)drugDetails.get("amend_fluid_code");
					String iv_ingredient_yn			= (String)drugDetails.get("IV_INGREDIENT_YN")==null? "" :(String)drugDetails.get("IV_INGREDIENT_YN");
					String iv_fluid_yn				= (String)drugDetails.get("IV_FLUID_YN")==null? "" :(String)drugDetails.get("IV_FLUID_YN");
					String amend_yn				    = (String)drugDetails.get("AMEND_YN")==null?"":(String)drugDetails.get("AMEND_YN");
					String startdate				= (String)drugDetails.get("START_DATE_TIME")==null?"":(String)drugDetails.get("START_DATE_TIME");// Added for ML-BRU-SCF-0811 [IN:039394]
					String enddate				    = (String)drugDetails.get("END_DATE_TIME")==null?"":(String)drugDetails.get("END_DATE_TIME");// Added for ML-BRU-SCF-0811 [IN:039394]
					String startdate_mims           = (String)drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE"); // Added for 69759
					String enddate_mims             = (String)drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE"); // Added for 69759
					HashMap record_flag				=null;
					HashMap fluids					=null;
					HashMap Existingrecord1			=null;			
					existing_order_id				= "";         
					
					perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS")==null?"":(String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");		
					loading_ext_prod_id				 = ext_prod_id;


					external_dosage_override_reason		= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
/*==================================================================================================================*/
				   //added for IN26007 --24/01/2011-- priya
					if(!(drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON").equals("")) && !(ext_prod_id.equals("")) && drug_db_dosecheck_yn.equals("Y") ){ 
								drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN","Y");
					}
/*==================================================================================================================*/

					drug_db_dosage_check_flag              = (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
					external_duplicate_override_reason		=  drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON") == null? 
					"" :drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON").toString();

					external_interaction_override_reason	= drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON")== null?
					"" :drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON").toString();;
					
					external_contra_override_reason		= drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON") == null ? "":drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON").toString();
					
					external_alergy_override_reason		= drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON")==null?"":drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON").toString();

					if(Integer.parseInt(adr_count)>0){
						int  drug_adr_count = bean.getADRCount(patient_id,drug_code); 
						if(drug_adr_count>0){
							adr_display_yn="Y";
						}
						else{
							adr_display_yn="N";
						}
					}
					if(order_type_flag.equals("Existing") ){   				 
						 amend_fluid_name		    = "";

						 size                       = ExistingCYTORecords.size();
						 record_flag                = (HashMap) ExistingCYTORecords.get(size-2);
						 fluids                     = (HashMap) ExistingCYTORecords.get(size-1);			
						 Existingrecord				= (HashMap) ExistingCYTORecords.get(count);				
						 catalog_code			    = (String)Existingrecord.get("ORDER_CATALOG_CODE");
						 iv_fluid_yn			    = (String)Existingrecord.get("IV_FLUID_YN")==null?"":(String)Existingrecord.get("IV_FLUID_YN");
						 iv_ingredient_yn			= (String)Existingrecord.get("IV_INGREDIENT_YN")==null?"":(String)Existingrecord.get("IV_INGREDIENT_YN");
						 amend_dup_drug				= java.net.URLDecoder.decode((String)Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON"));	
						 if( !amend_dup_drug.equals("")){
							// current_rx="Y";
						 }
						 else{
							// current_rx="N";
						 }

						 if( Existingrecord.containsKey("AMEND_SRL_NO")){
							amend_srl_no=(String) Existingrecord.get("AMEND_SRL_NO");
						 }
						 existing_order_id          = (String)Existingrecord.get("ORDER_ID"); 

						 if(record_flag.containsKey(existing_order_id)) {
							count=count+1;
							Existingrecord1			= (HashMap) ExistingCYTORecords.get(count);
							amend_fluid_name		= (String)Existingrecord1.get("CATALOG_DESC");
							existing_order_id       ="";					
						 }
						 else{
							 amend_fluid_name		 =  "";
						 }    
							
						 if(fluids.containsKey(catalog_code)){
							flag="Y";
						 }
						 else{
							srl_no = amend_srl_no;
							flag="N";
						 }
						 count=count+1;

						external_dosage_override_reason		= (String) Existingrecord.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
						if(external_duplicate_override_reason.equals(""))
							{
								external_duplicate_override_reason		= (String) Existingrecord.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
							}	
						external_interaction_override_reason	= (String) Existingrecord.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");

						
						if(!external_interaction_override_reason.equals("")){
							drugDetails.put("EXTERNAL_INTERACTION_OVERRIDE_REASON",external_interaction_override_reason);
						}

						external_contra_override_reason		= (String) Existingrecord.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
						if(external_alergy_override_reason.equals("")){
								external_alergy_override_reason		= (String) Existingrecord.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
						}
						/*	if(!((String) Existingrecord.get("ALLERGY_OVERRIDE_REASON")).equals("")){
								external_alergy_override_reason = (String) Existingrecord.get("ALLERGY_OVERRIDE_REASON");
							}
							if(!((String) Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON")).equals("")){
								external_duplicate_override_reason = (String) Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON");
							}*/
						}
						
						if(iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("N")){
							fluid_frame_display_yn		= "Y";
						}
						else{
							fluid_frame_display_yn		= "N";
						}
						
						//if(!flag.equals("Y")){
							if(amend_yn.equals("N")){
								if(tmp_srl_no==null){
									tmp_srl_no				    =	srl_no;
									tmp_comp_freq_code			=	comp_freq_code;
									tmp_comp_durn_value			=   comp_durn_value;
									tmp_comp_durn_type			=   comp_durn_type;
									tmp_fluid_frame_display_yn  =   fluid_frame_display_yn;
									tmp_count                   =   amend_srl_no;
								}
							   classValue = "SELECTEDRUGS";
							}
							else{
							   classValue =	"AMENDEDDRUGS";
							}
					//}
				//code for drug interaction check
				  HashMap drug_Interactions				= null;
				  String dup_drug_det					= "";
	//&& !mode.equals("amend")

				  if(perform_external_database_checks_yn.equals("Y") && !(ext_prod_id.equals("")) ){
						ex_prod_ids =new ArrayList();
								/*ex_prod_ids.add(ext_prod_id);
								drugDesc.add(drug_desc);
							beanex.storeDrugIds(patient_id,"",ex_prod_ids,drugDesc);//Store Drug ids
							beanex.removeSelectedDrugonAmend(ext_prod_id);*/
						for(int m=0;m<drugList.size();m++){
							HashMap drugDetails1				=(HashMap) drugList.get(m);
							String ext_drug_code				=(String) drugDetails1.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails1.get("EXTERNAL_PRODUCT_ID");
							if(!ex_prod_ids.contains(ext_drug_code)){
								if(!ext_drug_code.equals("")){
									if(!(order_type_flag.equals("Existing") && loading_ext_prod_id.equals(ext_drug_code))){ //if condition added for not use removeSelectedDrugonAmend -FDB Tuning
										ex_prod_ids.add(ext_drug_code);
										drugDesc.add((String)drugDetails1.get("DRUG_DESC"));
									}
								}
							}
						}
						/* //commented for FDB Tuning -start
						if(ex_prod_ids.size()>0)
							beanex.storeDrugIds(patient_id,"",ex_prod_ids,drugDesc);//Store Drug ids
						if(order_type_flag.equals("Existing") ){
							beanex.removeSelectedDrugonAmend(ext_prod_id);
						}
							 

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
							if(ext_prod_id!=null&& !ext_prod_id.equals("")){

								dup_drug_det			= beanex.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result

								if(!dup_drug_det.equals("")&&dup_drug_det!=null){
									drug_db_duptherapy_flag = "Y";
									current_rx			    = "N";
								}
							}
						}

						if(drug_db_contraind_check_yn.equals("Y")){
							if(loading_ext_prod_id!=null&& !loading_ext_prod_id.equals("")){
								ex_prod_ids =new ArrayList();
								ex_prod_ids.add(loading_ext_prod_id);
								boolean flag1 = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
								  HashMap contra_indications =(HashMap)beanex.getContraIndications();
								  if(contra_indications.containsKey(ext_prod_id)){
									 drug_db_contraind_check_flag="Y";
								  }					  
							}
						} 

						if(drug_db_allergy_check_yn.equals("Y")){

							ex_prod_ids =new ArrayList();
							ex_prod_ids.add(ext_prod_id);

							beanex.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result

							HashMap drug_alergies =(HashMap)beanex.getDrugAlergies();

							if(drug_alergies.containsKey(ext_prod_id)){
								drug_db_allergy_flag	= "Y";
								allergy_yn			= "N";
							}	
						}
						*/ //Commented for FDBTuning -End
						if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
							String storeIDs = "N";
							if(ex_prod_ids.size()>0 )
								storeIDs = "Y";
								
							HashMap tempDetails= null;
							ArrayList reqChecks = new ArrayList();
							reqChecks.add("N"); //Dosage Check 
							reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
							reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
							reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
							reqChecks.add(drug_db_allergy_check_yn); //AllergyCheck
							HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", ex_prod_ids,drugDesc, null, storeIDs, startdate_mims, enddate_mims); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean // startdate,enddate chnaged to startdate_mims,enddate_mims for 69759  
							if(drugDBCheckResult!=null)
								beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);

							drug_db_allergy_flag="N";
							drug_db_interact_check_flag="N";
							drug_db_duptherapy_flag="N";
							drug_db_contraind_check_flag="N";
							if(drugDBCheckResult!=null)
								beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
							if(drug_db_allergy_check_yn.equals("Y")){

							   if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS) //if block and else part added
								   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
								   if(allergy_alert!=null && !allergy_alert.equals(""))
										drug_db_allergy_flag="Y";
										allergy_yn			= "N";
							   } 
							   else {  
									tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
									if(tempDetails!=null && tempDetails.size()>0){
										 drug_db_allergy_flag="Y";
										allergy_yn			= "N";
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
								if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // adding start for IN066787- Performance
							          tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */

						        if(tempDetails!=null && tempDetails.size()>0){ //IN066787- Performance
							           drug_db_contraind_check_flag="Y";
						         }
								}else{//Adding end for IN066787- Performance
								tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
								if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
									drug_db_contraind_check_flag="Y";
								}		
							}
						 }
						}
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_flag);

						/*if(drug_db_allergy_flag.equals("Y")){
							if(!external_alergy_override_reason.equals("")){
							
							}
						}*/

					}
					else{
						drug_db_product_id = "";
					}

					drugDetails.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);

					String allergy_override_gif		= "";
					String overdose_override_gif	= "";
					String currrx_override_gif		= "";
					String tooltip					= drug_desc+"/"+generic_name+" - "+qty_value+" "+or_qty_desc+"-"+amend_fluid_name;
					String dispDesc					= "";
					if(drug_desc!=null && drug_desc.length()>16) {
						dispDesc=drug_desc.substring(0,16)+"...";
					}
					else {
						dispDesc=drug_desc;
					}

					if(amend_fluid_name.length()>16) {
						amend_fluid_name=amend_fluid_name.substring(0,16)+"...";
					}
					else {
						amend_fluid_name=amend_fluid_name;
					}
					if(allergy_override!=null && allergy_override.equals("N")) {
						allergy_override_gif="<IMG id=allergy"+(i+1)+" SRC='../images/exceed1.gif' style=1visibility:visible'></IMG>";
					}
					else {
						allergy_override_gif="&nbsp;";
					}

					if(dose_override!=null && dose_override.equals("N")) {
						overdose_override_gif="<IMG id=dose"+(i+1)+" SRC='../images/exceed1.gif'></IMG>";
					}
					else {
						overdose_override_gif="&nbsp;";
					}

					if(currentrx_override!=null && currentrx_override.equals("N")) {
						currrx_override_gif="<IMG id=duplicate"+(i+1)+" SRC='../images/exceed1.gif' style=1visibility:visible'></IMG>";
					}
					else {
						currrx_override_gif="&nbsp;";
					}
					if(order_type_flag.equals("Existing") ){ 
						overdose_override_gif="&nbsp;";
						//currrx_override_gif="&nbsp;";
						//allergy_override_gif="&nbsp;";
					}	
					if(!external_duplicate_override_reason.equals("")){
						currrx_override_gif="&nbsp;";
					}
					
					if(!external_alergy_override_reason.equals("")){
						allergy_override_gif="&nbsp;";
					}

					ArrayList doseValues		= (ArrayList)bean.getDoseValues(drug_code,patient_id);

					if(doseValues!=null){			
						dosage_unit				= (String)doseValues.get(1);	 		
					}
%>
					<input type="hidden" name="external_dosage_override_reason<%=srl_no%>" id="external_dosage_override_reason<%=srl_no%>"      value="<%=external_dosage_override_reason%>">
					<input type="hidden" name="external_duplicate_override_reason<%=srl_no%>" id="external_duplicate_override_reason<%=srl_no%>"   value="<%=external_duplicate_override_reason%>">
					<input type="hidden" name="external_interaction_override_reason<%=srl_no%>" id="external_interaction_override_reason<%=srl_no%>" value="<%=external_interaction_override_reason%>">
					<input type="hidden" name="external_contra_override_reason<%=srl_no%>" id="external_contra_override_reason<%=srl_no%>"      value="<%=external_contra_override_reason%>">
					<input type="hidden" name="external_alergy_override_reason<%=srl_no%>" id="external_alergy_override_reason<%=srl_no%>"      value="<%=external_alergy_override_reason%>">
					<TR TITLE="<%=tooltip%>" >
					<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="64%" onClick="defaultDrug('<%=srl_no%>','<%=comp_freq_code%>','<%=comp_durn_value%>','<%=comp_durn_type%>','<%=fluid_frame_display_yn%>');"  onMouseOver="changeCursor(this); changeCol(this);" onMouseOut="realCol(this,'<%=classValue%>');"><FONT CLASS="HYPERLINK"><%=dispDesc%></FONT>
<%
					if (!ext_prod_id.equals("")  && drug_db_interface_yn.equals("Y")) { // && drug_db_interface_yn.equals("Y") Added for PMG2018-COMN-CRF-0002
%>		  
						<IMG onMouseOver="changeCursor(this)" 
						STYLE="filter:Chroma(Color=#FFFFFF)" SRC="../../ePH/images/info.gif" HEIGHT="20" WIDTH="20" onClick="loadDrugInfo('<%=ext_prod_id%>','<%=java.net.URLEncoder.encode(drug_desc)%>')">
<%		
					}
					if(amend_fluid_name!=null && !amend_fluid_name.equals(""))	{  
						if(Integer.parseInt(adr_count)>0 && !amend_fluid_code.equals("")){
							int  fluid_adr_count = bean.getADRCount(patient_id,amend_fluid_code); 

							if(fluid_adr_count>0){
								fluid_adr_display_yn="Y";
							}
							else{
								fluid_adr_display_yn="N";
							}
						}
%>
						<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font size="1" color="BLUE"><%=amend_fluid_name%>
<%		
					}
%>
					</TD>
					<td width="6%" CLASS="<%=classValue%>"   >&nbsp;
<%
					if(adr_display_yn.equals("Y")){
%>
						<img  id="ADR_img" src='../../ePH/images/ADR.gif' height =15 width =15 title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></img><br>
<%
					}
					if(fluid_adr_display_yn.equals("Y")){
%>          
						&nbsp;&nbsp;<img  id="ADR_img" src='../../ePH/images/ADR.gif' height =15 width =15 title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' ></img>
<%
					}
					fluid_adr_display_yn="N";
					adr_display_yn="N";
%>    
					</td>
<%	   
					if(perform_external_database_checks_yn.equals("Y") && limit_ind.equals("N")){
						limit_ind = "Y";
						drugDetails.put("LIMIT_IND",limit_ind);
					}else if(perform_external_database_checks_yn.equals("N") && limit_ind.equals("N")){
						limit_ind = "N";
						drugDetails.put("LIMIT_IND",limit_ind);
					}
					if(((drug_db_interact_check_flag=="Y")&&(external_interaction_override_reason==""))||((drug_db_duptherapy_flag=="Y")&&(external_duplicate_override_reason==""))||((drug_db_contraind_check_flag=="Y")&&(external_contra_override_reason==""))||((drug_db_dosage_check_flag=="Y")&&(external_dosage_override_reason==""))||((drug_db_allergy_flag=="Y")&&(external_alergy_override_reason==""))){
						extVisble = "visible";
					}
					else{
						extVisble = "hidden";

					}
//out.println("@518 >>>>>> perform_external_database_checks_yn = "+perform_external_database_checks_yn+" >>> ext_prod_id = "+ext_prod_id+" >>> extVisble = "+extVisble+">>> drug_db_dosage_check_flag = "+drug_db_dosage_check_flag );
					if(perform_external_database_checks_yn.equals("Y") && !ext_prod_id.equals("")){
						if(drug_db_interact_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_dosage_check_flag.equals("Y") || drug_db_allergy_flag.equals("Y")){
%>
							<TD CLASS="SHIFTTOTAL" COLSPAN="" NOWRAP WIDTH="6%" id="ext_ddb_override_indc<%=srl_no%>"  onclick="viewMedicationAlert('<%=patient_id%>','<%=ext_prod_id%>','<%=drug_db_interact_check_flag%>','<%=drug_db_duptherapy_flag%>','<%=drug_db_contraind_check_flag%>','<%=drug_db_dosage_check_flag%>','PRESPAD','<%=java.net.URLEncoder.encode(external_dosage_override_reason,"UTF-8")%>','<%=drug_code%>','<%=srl_no%>','<%=java.net.URLEncoder.encode(external_duplicate_override_reason,"UTF-8")%>','<%=java.net.URLEncoder.encode(external_interaction_override_reason,"UTF-8")%>','<%=java.net.URLEncoder.encode(external_contra_override_reason,"UTF-8")%>','<%=java.net.URLEncoder.encode(pract_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(external_alergy_override_reason,"UTF-8")%>','<%=drug_db_dosecheck_yn%>','<%=drug_db_allergy_flag%>')"><img name="ext_ddb_override_img<%=srl_no%>" src='../../ePH/images/exceed1.gif' style="visibility:<%=extVisble%>;" ></img>&nbsp;</TD>
<%
						}
						else{	  

%>
							<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="6%" id="ext_ddb_override_indc<%=srl_no%>"  onclick="viewMedicationAlert('<%=patient_id%>','<%=ext_prod_id%>','<%=drug_db_interact_check_flag%>','<%=drug_db_duptherapy_flag%>','<%=drug_db_contraind_check_flag%>','<%=drug_db_dosage_check_flag%>','PRESPAD','<%=java.net.URLEncoder.encode(external_dosage_override_reason)%>','<%=drug_code%>','<%=srl_no%>','<%=java.net.URLEncoder.encode(external_duplicate_override_reason)%>','<%=java.net.URLEncoder.encode(external_interaction_override_reason)%>','<%=java.net.URLEncoder.encode(external_contra_override_reason)%>','<%=java.net.URLEncoder.encode(pract_name)%>','<%=java.net.URLEncoder.encode(external_alergy_override_reason)%>','<%=drug_db_dosecheck_yn%>','<%=drug_db_allergy_flag%>')">
							<img name="ext_ddb_override_img<%=srl_no%>"                src='../../ePH/images/exceed1.gif' style="visibility:hidden;" ></img>
							&nbsp;</TD>
<%
						}	  
//									if((drug_db_allergy_flag.equals("N"))&&(allergy_yn!=null && allergy_yn.equals("Y"))) {

						if((drug_db_allergy_check_yn.equals("N"))&&(allergy_yn!=null && allergy_yn.equals("Y"))) {
%>
							<TD CLASS="ALLERGY" COLSPAN="" NOWRAP WIDTH="10%" TITLE="Allergy Drug" id="tdallergy<%=(i+1)%>"	onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');" onMouseOver="changeCursor(this);">&nbsp;<%=allergy_override_gif%>&nbsp;</TD>
<%
						}
						else {
							drugDetails.put("ALLERGY_YN","N");
%>
							<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="10%">&nbsp;</TD>
<%
						}
%>
						<TD CLASS="<%=classValue%>" WIDTH="10%">&nbsp;</TD>
<%
						if((drug_db_duptherapy_yn.equals("N"))&&((!drug_db_duptherapy_yn.equals("Y")) && (current_rx!=null && current_rx.equals("Y")))) {
%>
							<td class="CURRENTRX" colspan="" nowrap width="10%" title="Duplicate Medication" id="tdduplicate<%=(i+1)%>"         onMouseOver="changeCursor(this);" onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')">			&nbsp;<%=currrx_override_gif%>&nbsp;</TD>
<%
						} else {
							drugDetails.put("CURRENT_RX","N");
%>
							<td class="<%=classValue%>" colspan="" nowrap width="15%">&nbsp;&nbsp;&nbsp;</td>
<%									
						}
%>
						</TR>		  
<%
					}
					else{
%>
						<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="10%">&nbsp;</TD>
<%				
						if(allergy_yn!=null && allergy_yn.equals("Y")) {
%>
							<TD CLASS="ALLERGY" COLSPAN="" NOWRAP WIDTH="10%" TITLE="Allergy Drug" id="tdallergy<%=(i+1)%>"	onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');" onMouseOver="changeCursor(this);">&nbsp;<%=allergy_override_gif%>&nbsp;</TD>
<%
						}
						else {
%>
							<TD CLASS="<%=classValue%>" COLSPAN="" NOWRAP WIDTH="10%">&nbsp;</TD>
<%
						}

						if(limit_ind!=null && limit_ind.equals("N")) {
%>
							<TD CLASS="DOSELIMIT" COLSPAN="" NOWRAP WIDTH="10%" TITLE="Exceed Dosage Limit" 
							id="tddose<%=(i+1)%>"
							onMouseOver="changeCursor(this);" onClick="showMonoGraph('<%=java.net.URLEncoder.encode(drug_desc)%>','<%=java.net.URLEncoder.encode(mono_graph)%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>','<%=dosage_unit%>','<%=dosage_std%>','<%=dose_unit_desc%>','<%=max_daily_ceeling_dose%>','<%=min_daily_ceeling_dose%>','<%=max_unit_ceeling_dose%>','<%=min_unit_ceeling_dose%>','<%=dose_unit_desc1%>');">&nbsp;<%=overdose_override_gif%>&nbsp;</TD><!-- Modified for IN:070451 -->
<%
						}
						else {
%>
							<TD CLASS="<%=classValue%>" WIDTH="10%">&nbsp;</TD>
<%
						}
						if(current_rx!=null && current_rx.equals("Y")) {
%>
							<td class="CURRENTRX" colspan="" nowrap width="10%" title="Duplicate Medication" id="tdduplicate<%=(i+1)%>"         onMouseOver="changeCursor(this);" onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')">			&nbsp;<%=currrx_override_gif%>&nbsp;</TD>
<%
						}
						else {
%>
							<td class="<%=classValue%>" colspan="" nowrap width="10%">&nbsp;</td>
<%
						}
%>        
						</TR>
<%
					}
%>
					<input type="hidden" name="external_db_dose_check_<%=srl_no%>" id="external_db_dose_check_<%=srl_no%>" value="<%=drug_db_dosage_check_flag%>">
					<input type="hidden" name="ext_med_alerts_fired_for_dup_check_yn<%=srl_no%>" id="ext_med_alerts_fired_for_dup_check_yn<%=srl_no%>" value="<%=drug_db_duptherapy_flag%>">
					<input type="hidden" name="ext_med_alerts_fired_for_inte_check_yn<%=srl_no%>" id="ext_med_alerts_fired_for_inte_check_yn<%=srl_no%>" value="<%=drug_db_interact_check_flag%>">
					<input type="hidden" name="ext_med_alerts_fired_for_contra_check_yn<%=srl_no%>" id="ext_med_alerts_fired_for_contra_check_yn<%=srl_no%>" value="<%=drug_db_contraind_check_flag%>">
					<input type="hidden" name="ext_med_alerts_fired_for_allergy_check_yn<%=srl_no%>" id="ext_med_alerts_fired_for_allergy_check_yn<%=srl_no%>" value="<%=drug_db_allergy_flag%>">
<%
				}

			}
%>
					</table>
					<input type="hidden" name="bean_id" id="bean_id"			value="<%= bean_id %>">
					<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
					<input type="hidden" name="start_date" id="start_date"		value="<%= start_date %>">		
					<input type="hidden" name="drug_db_interface_yn" id="drug_db_interface_yn"   value="<%= drug_db_interface_yn %>">		
					
<%
					if(tmp_srl_no!=null && flag.equals("N")){ 
%>	
						<input type="hidden" name="comp_freq_code" id="comp_freq_code"	value="<%=tmp_comp_freq_code%>">
						<input type="hidden" name="comp_durn_value" id="comp_durn_value"	value="<%=tmp_comp_durn_value%>">
						<input type="hidden" name="comp_durn_type" id="comp_durn_type"	value="<%=tmp_comp_durn_type%>">
						<input type="hidden" name="fluid_frame_display_yn" id="fluid_frame_display_yn"   value="<%=tmp_fluid_frame_display_yn %>">
						<input type="hidden" name="serialNum" id="serialNum"		value="<%=tmp_srl_no%>"	>
						<input type="hidden" name="count" id="count"			 value="<%=tmp_count%>"	>
<%
					}
%>
				</form>
			</body>
		</html>

<%
		//if(tmp_srl_no!=null&& flag.equals("N")){ 
			if(tmp_srl_no!=null){ 
%>	
				<script>    	
					defaultDrug('<%=tmp_srl_no%>','<%=tmp_comp_freq_code%>','<%=tmp_comp_durn_value%>','<%=tmp_comp_durn_type%>','<%=tmp_fluid_frame_display_yn%>','<%=tmp_count%>');    
				</script> 
<%
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		} 
	}

	putObjectInBean(bean_id,bean,request);
%>

