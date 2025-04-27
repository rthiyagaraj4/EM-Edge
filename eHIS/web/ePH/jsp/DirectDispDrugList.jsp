<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
29/08/2019      IN:070451           B Haribabu  29/08/2019      Manickam                 ML-MMOH-CRF-1408
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/  %>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import=" ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%
try{
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String dir_bean_id		= "DirectDispensingBean" ;
	String dir_bean_name	= "ePH.DirectDispensingBean";
	DirectDispensingBean dir_bean =(DirectDispensingBean)getBeanObject(dir_bean_id,dir_bean_name,request);

	String classValue		= "";
	String prev_order_code	= "";
	String patient_id		= dir_bean.getPatientID();
	String encounter_id		= "";
	String patient_class	= "";

	 if(patient_id!=null && !patient_id.equals("")){		
		encounter_id     = dir_bean.getEncounterID();
		if(encounter_id==null){
			encounter_id="";
		}
		patient_class    = dir_bean.getPatientClass();		  
	 }
	String facility_id		= (String)session.getValue("facility_id");
	ArrayList	presDetails	=(ArrayList) dir_bean.getpresDetails();

	String sch_bean_id		= "OrScheduleFreq" ;
	String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean	= (PrescriptionBean)getBeanObject(presBean_id,presBean_name,request);
	presBean.setLanguageId(locale);
%>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
		<script language="JavaScript" src="../../ePH/js/DirectDispensing.js"></script>
		<script language="javascript" src="../../eCommon/js/dchk.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	 </head>

	<!-- <body>  -->
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="prescription_form" id="prescription_form" >
			<table border="1" width="100%" cellspacing="0" cellpadding="0" id="Selected_drugs">
<%
				String adr_count	        = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
				ArrayList displayList		=	null;
				HashMap drugDetails			=	null;
				Hashtable schedule_val		=	null;
				Hashtable sch_output		=	null;	

				String grp_order_type_code	=	null;
				String order_type_code		=	null;
				String drug_code			=	null; 
				String srl_no				=	null; 
				String drug_desc			=	null; 
				String generic_id			=	null; 
				String generic_name			=	null; 
				String taper_yn				=	null; 
				String allergy_yn			=	null; 
				String qty_value			=	null; 
				String qty_desc				=	null; 
				String or_qty_desc			=	null; 
				String freq_desc			=	null; 
				String durn_value			=	null; 
				String or_durn_desc			=   null; 
				String limit_ind			=	null; 
				String mono_graph			=	null; 
				String daily_dose			=	null; 
				String unit_dose			=	null; 
				String dosage_std           =   null; // Added for ML-MMOH-CRF-0978
				String min_daily_dose		=	null; 
				String min_unit_dose		=	null; 
				String freq_nature			=	null;
				String current_rx			=	null;
				String allergy_override		=	null; 
				String dose_override		=	null; 
				String currentrx_override	=	null; 
				String sch_over_yn			=	null; 
				String ext_prod_id			=	null;
				String start_date			=	null;
				String end_date				=	null;
				String provide_taper		=	null;
				String no_refill			=   null;
				String stock_available_yn	=   null;
				String available_stock		=   null;
				String allow_pres_without_stock_yn = null;
				String scheduled_yn			=	null;
				String order_type_desc		=	null;
				String amend_yn				=	null;
				String rowVal				=	null;
				String split_dose_yn		=	null;
				String dosage_type			=	null;
				String tmp_srl_no			=	null;
				String tmp_drug_code		=	null;
				String dosage_unit			=	"";
				String dose_unit_desc       =   ""; //added for ML-MMOH-SCF-0864
				String stock_uom			=	"";	
				String dis					=   "";	
				String recomm_yn			=	"";
				String taper_up				=	"";
				String sliding_scale_yn		=   "";
				String form_code			=	"";	
				String uom_code				=	"";
				String uom_desc				=	"";
				String dflt_yn				=	"";
				String allocatedd_yn        =   "";
				String freq_code			=	null;	
				boolean recomm_yn_flag		=	false;	
				String perform_external_database_checks_yn	= "N";
				String drug_db_interact_check_flag			= "N";
				String drug_db_duptherapy_flag				= "N";
				String drug_db_contraind_check_flag			= "N";
				String drug_db_dosage_check_flag			= "N";
				String drug_db_alergy_check_flag			= "N";
				
				boolean show_external_override_gif			= false;
				String external_dosage_override_reason		=   "";	
				String external_duplicate_override_reason	=   "";
				String external_interaction_override_reason	=   "";
				String external_contra_override_reason		=   ""; 
				String external_alergy_override_reason		=   ""; 
				String pract_name							= dir_bean.getPractionerName();
				String external_checks_overrided			= "N";
				//Added for IN:070451 start
				String      max_daily_ceeling_dose	    =   "";
				String		min_daily_ceeling_dose	    =   "";
				String		max_unit_ceeling_dose	    =   "";
				String		min_unit_ceeling_dose	    =   "";
				String dose_unit_desc1       =   "";
				//Added for IN:070451 end
				String interaction_exists="", drugIntraction_override="", drugIntraction_override_gif="";  // added for FD-RUT-CRF-0066.1 [IN036975]

				String param_bean_id				= "@DrugInterfaceControlBean";
				String param_bean_name				= "ePH.DrugInterfaceControlBean";
				DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
				String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
				
				param_bean.clear();
				
				int drug_adr_count					= 0;
				String adr_gif						="";
				ArrayList prescriptionDetails		=null;
				int codeCount_1						= 0;
				int codeCount_2						= 0;
				HashMap ext_drugData				=null;
				String ext_drug_code				=null;
				String ext_srl_no					=null;
				int drug_index						=0;
				String temp_freq_nature				="";
				String deft_mode					="modify";
				String weight_rec_appl_age_group_check_flag = "";
				String wt_mand_yn="", ht_mand_yn=""; //added for Bru-HIMS-CRF-079 IN[029945]
			
				if(presDetails.size()>0){
					classValue="SELECTEDRUGS1";
					ArrayList ordergrp	=(ArrayList) dir_bean.ordsortList();
					ArrayList grp		=(ArrayList)dir_bean.sortList();

					//  duplicate check based on atc -- starts
					String atc_level_1	=	"";
					String atc_level_2	=	"";
					String atc_level_3	=	"";
					ArrayList atc_values =  new ArrayList();
					HashMap drug_detail	 =	null;
					if(presDetails.size()>0){
						for(int i=0;i<presDetails.size();i++){			
							drug_detail=(HashMap) presDetails.get(i);

							atc_level_1	=	(String)drug_detail.get("ATC_CLASS_LEV1_CODE");
							atc_level_2	=	(String)drug_detail.get("ATC_CLASS_LEV2_CODE");
							atc_level_3	=	(String)drug_detail.get("ATC_CLASS_LEV3_CODE");
							drug_desc	=	(String)drug_detail.get("DRUG_DESC");										
							
							//out.println((HashMap)drug_detail.get("SEL_BATCHES")==null?"":(HashMap)drug_detail.get("SEL_BATCHES"));
						   provide_taper	=	"";

							if(drug_detail.get("PROVIDE_TAPER")!=null)
								 provide_taper	= (String)drug_detail.get("PROVIDE_TAPER");

							if( (!provide_taper.equals("Y")) && (drug_detail.get("ALERT_YN")==null && (drug_detail.get("CURRENTRX_REMARKS")==null || ((String)drug_detail.get("CURRENTRX_REMARKS")).equals("") ) ) ) {
								if(atc_values.contains(atc_level_1)) {
									drug_detail.put("CURRENT_RX","Y");
									drug_detail.put("ALERT_YN","Level 1:");
									//out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_1)-1)+" at ATC Classification Level 1'); return;</script>");
								} 
								else  if(atc_values.contains(atc_level_2)) {
									drug_detail.put("CURRENT_RX","Y");
									drug_detail.put("ALERT_YN","Level 2:");
									//out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_2)-2)+" at ATC Classification Level 2'); return; </script>");
								} 
								else if(atc_values.contains(atc_level_3)) {
									drug_detail.put("CURRENT_RX","Y");
									drug_detail.put("ALERT_YN","Level 3:");
									//out.println("<script>alert('"+drug_desc+" duplicates with  "+atc_values.get(atc_values.indexOf(atc_level_3)-3)+" at ATC Classification Level 3') return; </script>");
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
					//  duplicate check based on atc -- ends
					for(int k=0;k<ordergrp.size();k++){
						grp_order_type_code	=(String) ordergrp.get(k);
							for(int i=0;i<grp.size();i++){
								displayList=(ArrayList) dir_bean.getDisplayList((String)grp.get(i));
								for(int j=0;j<displayList.size();j++){
									drugDetails = new HashMap();
									drugDetails=(HashMap) displayList.get(j);

									order_type_code	= (String)drugDetails.get("ORDER_TYPE_CODE");
									allocatedd_yn   = (String)drugDetails.get("ALLOCATEDD_YN");
									if(grp_order_type_code.equals(order_type_code)){											
										perform_external_database_checks_yn		= (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");	
										drug_db_duptherapy_flag					= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN");
										drug_db_interact_check_flag				= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN");
										drug_db_contraind_check_flag			= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN");
										drug_db_dosage_check_flag				= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");
										drug_db_alergy_check_flag               = (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_ALERGY_CHECK_YN");
										external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
										external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
										external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
										external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
										external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
										if(drug_db_duptherapy_flag.equals("Y")||drug_db_interact_check_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y")||drug_db_dosage_check_flag.equals("Y")||drug_db_alergy_check_flag.equals("Y")){
											show_external_override_gif=true;
											if((drug_db_duptherapy_flag.equals("Y")&&external_duplicate_override_reason.equals(""))||(drug_db_interact_check_flag.equals("Y")&&external_interaction_override_reason.equals(""))||(drug_db_contraind_check_flag.equals("Y")&&external_contra_override_reason.equals(""))||(drug_db_dosage_check_flag.equals("Y")&& external_dosage_override_reason.equals(""))||(drug_db_alergy_check_flag.equals("Y")&& external_alergy_override_reason.equals(""))){
												// external_img="<img id='external_img+<%srl_no>'src='../../ePH/images/exceed1.gif'></img>";
												external_checks_overrided="N";
											}
											else{
												external_checks_overrided="Y";
											}
										}
										else{
											show_external_override_gif=false;
											external_checks_overrided="Y";
										}

										sliding_scale_yn	= (String)drugDetails.get("SLIDING_SCALE_YN") ; 
										drug_code			= (String)drugDetails.get("DRUG_CODE");
										srl_no				= (String)drugDetails.get("SRL_NO");
										drug_desc			= (String)drugDetails.get("DRUG_DESC");				
										String	drug_desc1=java.net.URLEncoder.encode(drug_desc,"UTF-8");
										generic_id			= (String)drugDetails.get("GENERIC_ID");
										generic_name		= (String)drugDetails.get("GENERIC_NAME");
										taper_yn			= (String)drugDetails.get("TAPER_DOSE_YN");
										allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
										qty_value			= (String)drugDetails.get("QTY_VALUE");
										qty_desc			= (String)drugDetails.get("QTY_DESC");
										or_qty_desc			= (String)drugDetails.get("OR_QTY_DESC");				
										freq_code			= (String)drugDetails.get("FREQ_CODE");
										freq_desc			= (String)drugDetails.get("FREQ_DESC");
										durn_value			= (String)drugDetails.get("DURN_VALUE");
										or_durn_desc		= (String)drugDetails.get("OR_DURN_DESC");
										limit_ind			= (String)drugDetails.get("LIMIT_IND");
										mono_graph			= (String)drugDetails.get("MONO_GRAPH");
										daily_dose			= (String)drugDetails.get("DAILY_DOSE");
										unit_dose			= (String)drugDetails.get("UNIT_DOSE");
										min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE");
										min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE");
										dosage_std          = (String)drugDetails.get("DOSAGE_STD"); // Added for ML-MMOH-CRF-0978
										freq_nature			= (String)drugDetails.get("FREQ_NATURE");
										current_rx			= (String)drugDetails.get("CURRENT_RX");
										allergy_override	= (String)drugDetails.get("ALLERGY_OVERRIDE");
										dose_override		= (String)drugDetails.get("DOSE_OVERRIDE");
										currentrx_override	= (String)drugDetails.get("CURRENTRX_OVERRIDE");
										sch_over_yn			= (String)drugDetails.get("SCH_OVER_YN");
										ext_prod_id			= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
										start_date			= (String)drugDetails.get("START_DATE");
										end_date			= (String)drugDetails.get("END_DATE");				
										stock_uom			= (String)drugDetails.get("STOCK_UOM_DESC");
										form_code			= (String) drugDetails.get("FORM_CODE");
										recomm_yn			= ((String)drugDetails.get("RECOMM_YN")).trim();
										//Added for IN:070451 start
										max_daily_ceeling_dose		= drugDetails.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
										min_daily_ceeling_dose		= drugDetails.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
										max_unit_ceeling_dose		= drugDetails.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
										min_unit_ceeling_dose		= drugDetails.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
										//Added for IN:070451 end
										if(recomm_yn.equals("Y")){					
											recomm_yn_flag = true;				
										}
										weight_rec_appl_age_group_check_flag =  drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG")== null?"":(String) drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG");
										wt_mand_yn =  drugDetails.get("wt_mand_yn")== null?"":(String) drugDetails.get("wt_mand_yn");//added for Bru-HIMS-CRF-079 IN[029945]
										ht_mand_yn =  drugDetails.get("ht_mand_yn")== null?"":(String) drugDetails.get("ht_mand_yn");//added for Bru-HIMS-CRF-079 IN[029945]

										//if(weight_rec_appl_age_group_check_flag.equals("Y")){ //commented for Bru-HIMS-CRF-079 IN[029945]
										if(wt_mand_yn.equals("Y") || ht_mand_yn.equals("Y")){//added for Bru-HIMS-CRF-079 IN[029945]
											recomm_yn_flag = true;	
										}

										provide_taper	=	"";
										if(drugDetails.get("PROVIDE_TAPER")!=null){
											provide_taper	= (String)drugDetails.get("PROVIDE_TAPER");	
										}
										no_refill			= (String)drugDetails.get("NO_REFILL");
										//licen				= (String)drugDetails.get("LICENCE");
										stock_available_yn	= (String)drugDetails.get("STOCK_AVAILABLE_YN");
										available_stock		= (String)drugDetails.get("AVAILABLE_STOCK");
										allow_pres_without_stock_yn = (String)drugDetails.get("ALLOW_PRES_WITHOUT_STOCK_YN");	
										scheduled_yn		= (String)drugDetails.get("SCHEDULED_YN");
										order_type_desc		= (String)drugDetails.get("ORDER_TYPE_DESC");
										amend_yn			= (String)drugDetails.get("AMEND_YN");
										allocatedd_yn		= (String)drugDetails.get("ALLOCATEDD_YN");
										rowVal				= (String)drugDetails.get("rowVal");
										split_dose_yn		= (String)drugDetails.get("SPLIT_DOSE_YN");
										dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
										taper_up			= (String)drugDetails.get("TAPER_UP");
										interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS"); // added for FD-RUT-CRF-0066.1 [IN036975]
										drugIntraction_override	= drugDetails.get("DRUGINTRACTION_OVERRIDE")==null?"":(String)drugDetails.get("DRUGINTRACTION_OVERRIDE"); // added for FD-RUT-CRF-0066.1 [IN036975]

										if( Integer.parseInt(adr_count)>0){
											drug_adr_count = bean.getADRCount(patient_id,drug_code);
											if(drug_adr_count>0){
												adr_gif="<img src='../../ePH/images/ADR.gif' height=20  width=15></img>";
											}
											else{
												adr_gif="&nbsp;";
											}
										}

										if(allocatedd_yn.equals("Y")){
											dis="display";
										}
										else{
											dis="display:none";					
										}
										//HashMap sliding_scale_dtls = bean.getSlidingScaleDetails(drug_code);
										dosage_unit			=	(String)drugDetails.get("DOSAGE_UNIT");
										if(!dosage_unit.equals("")){ // Added for ML-MMOH-SCF-0864 - Start
											   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit);
											   dose_unit_desc1= dose_unit_desc;		//Added for IN:070451
												System.out.println("dose_unit_desc--11>"+dose_unit_desc);
												if(dose_unit_desc==null || dose_unit_desc=="" ) {
												  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
												  dose_unit_desc1= dose_unit_desc;		//Added for IN:070451
											     if(dosage_unit.split("/").length>=2)
												   dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
												
												} 

											}// Added for ML-MMOH-SCF-0863 - End
							
										if(dosage_unit == null) 
											dosage_unit="";
										if(dose_unit_desc == null) 
											dose_unit_desc="";

										// control the child drug in tapering(was not considered as a tapered when the last child drug defaulted form the pad)
										prescriptionDetails=(ArrayList)bean.getpresDetails();
										//	prescriptionDetails=(ArrayList) dir_bean.getpresDetails();
										codeCount_1=0;
										codeCount_2=0;
										for(int count=0;count<prescriptionDetails.size();count++){
											ext_drugData=(HashMap) prescriptionDetails.get(count);
											ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
											ext_srl_no=(String) ext_drugData.get("SRL_NO");
											temp_freq_nature = (String) ext_drugData.get("FREQ_NATURE")==null?"": (String) ext_drugData.get("FREQ_NATURE");

											if( !(temp_freq_nature.equals("P") || temp_freq_nature.equals("O")) && (Float.parseFloat(srl_no) != (Float.parseFloat(ext_srl_no)))){
												if(drug_code.equals(ext_drug_code)){
													codeCount_1++;
												}
											}
											if(drug_code.equals(ext_drug_code) && srl_no.equals(ext_srl_no))
												drug_index = count;
										}
										if(codeCount_1>=1){
											for(int count=drug_index;count<prescriptionDetails.size();count++){
												ext_drugData=(HashMap) prescriptionDetails.get(count);
												ext_drug_code=(String) ext_drugData.get("DRUG_CODE");
												if(drug_code.equals(ext_drug_code)){
													codeCount_2++;
												}
											}
										}
										if(codeCount_1>=1 && codeCount_2==1 ){
											deft_mode="tapered";
										}
										else 
											deft_mode = "modify";

										String tapergif				= "";
										String allergy_override_gif	="";
										String overdose_override_gif="";
										String currrx_override_gif	="";
										ArrayList schedule			=	null;
										String freq_str				=	"";
										String tooltip				=	drug_desc+"/"+generic_name;
										//HashMap detail				=	null;
										//if the drug is scheduled  - store the values in or bean
										schedule_val				=	new Hashtable();
										if(!presBean.checkPreScheduled(freq_code).equals("0")) {
											schedule	=	(ArrayList)dir_bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
											if(schedule.size()==0 && scheduled_yn.equals("Y")) {
												ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject(sch_bean_id,sch_bean_name,request);
												/*if(sliding_scale_dtls.size()>0 && sliding_scale_dtls.get("APPL_SLIDING_SCALE_YN")!=null && ((String)sliding_scale_dtls.get("APPL_SLIDING_SCALE_YN")).equals("Y") ) {
													qty_value	=	(String)drugDetails.get("STRENGTH_VALUE");
												}*/
												schedule_bean.setLanguageId(locale);
												schedule_val.put("facility_id", facility_id);
												schedule_val.put("start_time_day_param", start_date);
												schedule_val.put("module_id", "PH"); 
												schedule_val.put("split_dose_yn", split_dose_yn); 
												schedule_val.put("split_qty",qty_value);	
												//out.println("===split_qty=="+qty_value);
												schedule_val.put("freq_code",  freq_code );
												schedule_val.put("code",drug_code+srl_no);
												sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
												sch_output.put("code",drug_code+srl_no);
												sch_output.put("row_value",rowVal);
												
												dir_bean.setScheduleFrequencyStr(sch_output);
												drugDetails.put("SCH_OVER_YN","Y");
												putObjectInBean(sch_bean_id,schedule_bean,request);
											}
										}

										if(split_dose_yn.equals("Y")) {
											schedule	=	(ArrayList)dir_bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
											
										boolean split_chk	=	bean.checkSplit(schedule);
										
										/* for(int n=0; n<schedule.size(); n++) { //commented by Abdul for Multi Frequency CRF
											detail	=	(HashMap)schedule.get(n);
											freq_str = freq_str + detail.get("admin_time")+"-";
											freq_str = freq_str + detail.get("admin_qty")+" "+qty_desc;
											if(n==(schedule.size()-1))
												freq_str = freq_str +" ";
											else
												freq_str = freq_str +", ";
										}	*/
										if(schedule.size()>0) {
											ArrayList time_list		= (ArrayList)schedule.get(3);					
											ArrayList dose_list		= (ArrayList)schedule.get(4);					
											for(int n=0;n<dose_list.size();n++){
												freq_str = freq_str + (String)time_list.get(n)+"-";
												freq_str = freq_str + (String)dose_list.get(n)+" "+qty_desc;
												if(n==(dose_list.size()-1))
													freq_str = freq_str +" ";
												else
													freq_str = freq_str +", ";
											}
										}
										if(dosage_type.equals("A"))
											tooltip			=tooltip + " - for "+durn_value+" "+or_durn_desc;
										else if(schedule.size() > 0 && split_chk) 
											tooltip			=tooltip + " -"+qty_value+" "+or_qty_desc+" (Divided) for "+durn_value+" "+or_durn_desc;
										else if(schedule.size() > 0) 
											tooltip			=tooltip + " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
										else 
											tooltip			=tooltip + " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
									} 
									else {
										if(dosage_type.equals("A"))
											tooltip			=tooltip + " - "+freq_desc+" for "+durn_value+" "+or_durn_desc;
										else {
											schedule	=	(ArrayList)dir_bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
											if(schedule.size() > 0) {
												/* detail	=	(HashMap)schedule.get(0); //commented by Abdul for Multi Frequency CRF
												qty_value		=	(String)detail.get("admin_qty");*/
												ArrayList dose_list		= (ArrayList)schedule.get(4);
												if(dose_list.size()>0){
													qty_value		= (String)dose_list.get(0);
													if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
														qty_value="1";
												 }
												 else{
													 if(qty_value.equals("")||qty_value.equals("0")||qty_value==null)
														 qty_value="1";
												 }
											}
											tooltip	=tooltip + " - "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
										}
									}
									/*** Tool tip ends***/
									if(patient_class.equals("IP") && dosage_type.equals("A")) {
										ArrayList QtyDescDetails		= (ArrayList)presBean.loadQtyDetails(form_code);
									
										for(int p=0; p<QtyDescDetails.size(); p+=3) {
											uom_code	= (String)QtyDescDetails.get(p);
											uom_desc	= (String)QtyDescDetails.get(p+1);
											dflt_yn		= (String)QtyDescDetails.get(p+2);

											if(dflt_yn.equals("Y")) {
												drugDetails.put("QTY_DESC",uom_code);
												drugDetails.put("OR_QTY_DESC",uom_desc);
											}
										}
									}
									String dispDesc="";
									if(drug_desc.length()>11)
										dispDesc=drug_desc.substring(0,11)+"...";
									else
										dispDesc=drug_desc;
									if(j==(displayList.size())-1){
										if(freq_nature!=null && (freq_nature.equals("O")|| freq_nature.equals("P") ) ){
											taper_yn="N";
											taper_up = "N";
										}
										if( (provide_taper.equals("Y"))  && (no_refill.equals("") || no_refill.equals("0")) )	{
											if(taper_up!=null && taper_up.equals("Y"))
												tapergif="<img src='../../ePH/images/uparrow.gif' onclick=defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"'); title='Taper Dose' ></img>";
											else if(taper_yn!=null && taper_yn.equals("Y"))
												tapergif="<img src='../../ePH/images/downarrow.gif' onclick=defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"'); title='Taper Dose' ></img>";
										}
										else {
											tapergif="";
										}
									}
									else{
										tapergif="";
									}
									if(allergy_override!=null && allergy_override.equals("N"))
										allergy_override_gif="<img src='../../ePH/images/exceed1.gif'></img>";
									else
										allergy_override_gif="&nbsp;";

									if(dose_override!=null && dose_override.equals("N"))
										overdose_override_gif="<img src='../../ePH/images/exceed1.gif' ></img>";
									else
										overdose_override_gif="&nbsp;";

									if(currentrx_override!=null && currentrx_override.equals("N"))
										currrx_override_gif="<img src='../../ePH/images/exceed1.gif'></img>";
									else
										currrx_override_gif="&nbsp;";
									if(drugIntraction_override!=null && drugIntraction_override.equals("N")){ // added for FD-RUT-CRF-0066.1 [IN036975] -Start
										drugIntraction_override_gif="<img src='../../ePH/images/exceed1.gif' ></img>";
									}
									else{
										drugIntraction_override_gif="&nbsp;";
									} // added for FD-RUT-CRF-0066.1 [IN036975] -End
									
									if(!(prev_order_code.equals(order_type_code))){
%>
										<th colspan="8" align="left" class="ORDERDESC" style="<%=dis%>"><%=order_type_desc%></th>
<%
										prev_order_code=order_type_code;
									}
									if(stock_available_yn.equals("N")){
										if(allow_pres_without_stock_yn.equals("N")){
											tapergif="";						
										}
									}
%>
									<tr title="<%=tooltip%>" style="<%=dis%>">
										<input type="hidden" name="dt<%=srl_no%>" id="dt<%=srl_no%>" value="<%=start_date%>">
<%
										if(j==0){
											if(amend_yn.equals("Y")){
												classValue="AMENDEDDRUGS";
											}
											else{
												classValue="SELECTEDRUGS1";
												if(tmp_srl_no==null){
													tmp_srl_no		=	srl_no;
													tmp_drug_code	=	drug_code;
												}
											}
										}
										else{
											if(deft_mode.equals("tapered"))
												classValue="TAPERDRUGS";
											else if(amend_yn.equals("N")){
												classValue="SELECTEDRUGS";
												if(tmp_srl_no==null){
													tmp_srl_no		=	srl_no;
													tmp_drug_code	=	drug_code;
												}
											}
										}
										if(j==(displayList.size())-1){
%>
											<td class="white" width="6%" onmouseover="changeCursor(this);" ><%=tapergif%></td>
<%
										}
										else{
%>
											<td class="white" width="6%"  title='Tapered'><%=tapergif%></td>
<%
										}
%>
										<input type="hidden" name="external_dosage_override_reason<%=srl_no%>" id="external_dosage_override_reason<%=srl_no%>"      value="<%=external_dosage_override_reason%>">
										<input type="hidden" name="external_duplicate_override_reason<%=srl_no%>" id="external_duplicate_override_reason<%=srl_no%>"   value="<%=external_duplicate_override_reason%>">
										<input type="hidden" name="external_interaction_override_reason<%=srl_no%>" id="external_interaction_override_reason<%=srl_no%>" value="<%=external_interaction_override_reason%>">
										<input type="hidden" name="external_contra_override_reason<%=srl_no%>" id="external_contra_override_reason<%=srl_no%>"      value="<%=external_contra_override_reason%>">
										<input type="hidden" name="external_alergy_override_reason<%=srl_no%>" id="external_alergy_override_reason<%=srl_no%>"      value="<%=external_alergy_override_reason%>">
<%
										if(stock_available_yn.equals("N")){
											if(allow_pres_without_stock_yn.equals("N")){
%>
												<td class="<%=classValue%>" colspan="" NOWRAP width="64%" id="<%=drug_code%><%=srl_no%>" onClick="defaultDrug('<%=drug_code%>','modify','<%=srl_no%>','<%=sliding_scale_yn%>');" onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');" title="<%=drug_desc%>"><font class="HYPERLINK" size='1'><%=dispDesc%></font>
<% 
												if (!ext_prod_id.equals("")	) {	
%>
													<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_desc1%>') ">
<%
												}
%>
												&nbsp;&nbsp;</td><td style="background-color:red;font-weight:bold;font-size:11;cursor:pointer;height:20" NOWRAP  colspan="3" title="Available Qty:&nbsp;<%=available_stock%>&nbsp;&nbsp;<%=stock_uom%>"><marquee scrollamount="3"><font style="font-weight:bold;color:white"><fmt:message key="ePH.InsufficientStock-AvailableQuantity.label" bundle="${ph_labels}"/>:&nbsp;<%=available_stock%>&nbsp;<%=stock_uom%></font></marquee></td>
<%
											}
											else{
												classValue="NOSTOCKWARN";
												if(sch_over_yn.equals("N") ){
%>
													<td class="<%=classValue%>" colspan="" NOWRAP width="64%" id="<%=drug_code%><%=srl_no%>" onClick="defaultDrug('<%=drug_code%>','modify','<%=srl_no%>','<%=sliding_scale_yn%>');" onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');"><font class="HYPERLINK" size='1'><%=dispDesc%></font>
<% 
													if (!ext_prod_id.equals("")	) {	
%>
														<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_desc1%>') ">
<%
													}
%>
													&nbsp;&nbsp;</td>
<%
												}
												else{
%>
													<td class="<%=classValue%>" colspan="" NOWRAP width="64%" id="<%=drug_code%><%=srl_no%>" onClick="defaultDrug('<%=drug_code%>','modify','<%=srl_no%>','<%=sliding_scale_yn%>');" onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');"><font class="HYPERLINK" size='1'><%=dispDesc%></font>
<%
													if (!ext_prod_id.equals("")&&perform_external_database_checks_yn.equals("Y")) {
%>
														<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_desc1%>') ">
<%
													}
%>
													&nbsp;&nbsp;</td>
<%
													if(drug_adr_count>0){
%> 
														<td class=<%=classValue%> colspan=""  width="5%"  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' >&nbsp;<%=adr_gif%>&nbsp;</td>
<%	
													}
													else{
%>
														<td class="<%=classValue%>" colspan=""  width="5%">&nbsp;</td>
<%
													}	
												}
												if(show_external_override_gif){
%>
													<td class="SHIFTTOTAL" colspan="" NOWRAP width="5%" title="External Override Reason" onmouseover="changeCursor(this);" onclick="viewMedicationAlert('<%=patient_id%>','<%=ext_prod_id%>','<%=drug_db_interact_check_flag%>','<%=drug_db_duptherapy_flag%>','<%=drug_db_contraind_check_flag%>','<%=drug_db_dosage_check_flag%>','PRESPAD','<%=java.net.URLEncoder.encode(external_dosage_override_reason)%>','<%=drug_code%>','<%=srl_no%>','<%=java.net.URLEncoder.encode(external_duplicate_override_reason)%>','<%=java.net.URLEncoder.encode(external_interaction_override_reason)%>','<%=java.net.URLEncoder.encode(external_contra_override_reason)%>','<%=java.net.URLEncoder.encode(pract_name)%>','<%=java.net.URLEncoder.encode(external_alergy_override_reason)%>','<%=drug_db_dosecheck_yn%>','<%=drug_db_alergy_check_flag%>')">&nbsp;
<%
													if(external_checks_overrided.equals("N")){
%>
														<img id='external_img<%=srl_no%>' style="visibility:visible"src='../../ePH/images/exceed1.gif'></img>
<%
													}
													else{
%>						
														<img id='external_img<%=srl_no%>' style="visibility:hidden"src='../../ePH/images/exceed1.gif'></img>
<%
													}
%>
													&nbsp;</td>
<%
												}
												else{
%>
													<td class="<%=classValue%>" width="5%">&nbsp;<img id='external_img<%=srl_no%>' style="visibility:hidden"src='../../ePH/images/exceed1.gif'></img></td>
<%
												}
												if(allergy_yn!=null && allergy_yn.equals("Y")){
%>
													<td class="ALLERGY" colspan="" NOWRAP width="5%" title="Allergy Drug"  onclick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');" onmouseover="changeCursor(this);">&nbsp;<%=allergy_override_gif%>&nbsp;</td>
<%
												}
												else{
%>
													<td class="<%=classValue%>" colspan="" NOWRAP width="5%">&nbsp;</td>
<%
												}
												//if(limit_ind!=null && limit_ind.equals("N") && dose_override!=null && dose_override.equals("N")&& perform_external_database_checks_yn.equals("N")){
												if(limit_ind!=null && limit_ind.equals("N") && perform_external_database_checks_yn.equals("N")){
%>
													<td class="DOSELIMIT2" colspan="" NOWRAP width="5%" title="Exceed Dosage Limit" onmouseover="changeCursor(this);" onclick="showMonoGraph('<%=drug_desc%>','<%=java.net.URLEncoder.encode(mono_graph)%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>','<%=dosage_unit%>','<%=dosage_std%>','<%=dose_unit_desc%>','<%=max_daily_ceeling_dose%>','<%=min_daily_ceeling_dose%>','<%=max_unit_ceeling_dose%>','<%=min_unit_ceeling_dose%>','<%=dose_unit_desc1%>');">&nbsp;<%=overdose_override_gif%>&nbsp;</td> <!-- dose_unit_desc and dosage_std  added for 0864 --><!-- Modified for IN:070451  -->
<%
												}
												else{
%>
													<td class="<%=classValue%>" width="5%">&nbsp;</td>
<%
												}
												if( interaction_exists.equals("Y") ){ // added for FD-RUT-CRF-0066.1 [IN036975] -Start
%>
													<td class="DOSELIMIT1" colspan="" NOWRAP width="5%" title='<fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/>' onmouseover="changeCursor(this);" onclick="showInractionDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>');" id='td_drugIntraction<%=srl_no%>'>&nbsp;<%=drugIntraction_override_gif%>&nbsp;</td>
<%
												}
												else{
%>
													<td class="<%=classValue%>" width="5%" id='td_drugIntraction<%=srl_no%>'>&nbsp;</td>
<%
												} // added for FD-RUT-CRF-0066.1 [IN036975] - End
												if(current_rx!=null && current_rx.equals("Y")&&perform_external_database_checks_yn.equals("N")){
%>
													<td class="CURRENTRX" colspan="" NOWRAP width="5%" title="Duplicate Medication"  onmouseover="changeCursor(this);" onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')">&nbsp;<%=currrx_override_gif%>&nbsp;</td>
<%
												}
												else{
%>
													<td class="<%=classValue%>" colspan="" NOWRAP width="5%">&nbsp;</td>
<%
												}
											}
										}
										else{
											if(sch_over_yn.equals("N") ){
%>
												<td class="<%=classValue%>" colspan="" NOWRAP width="64%" onClick="defaultDrug('<%=drug_code%>','modify','<%=srl_no%>','<%=sliding_scale_yn%>');" id="<%=drug_code%><%=srl_no%>"  onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');"><font CLASS="HYPERLINK" size='1' ><%=dispDesc%></font>
<%
												if (!ext_prod_id.equals("")	) {
%>
													<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_desc1%>') ">
<%
												}
%>
												&nbsp;&nbsp;</td>
<%
												if(drug_adr_count>0){
%>  
													<td class=<%=classValue%> colspan=""  width="3%"  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' >&nbsp;<%=adr_gif%>&nbsp;</td>
<%
												}
												else{
%>
													<td class="<%=classValue%>" colspan=""  width="3%">&nbsp;</td>
<% 
												}
											}
											else{
%>
												<td class="<%=classValue%>" colspan="" NOWRAP width="64%" onClick="defaultDrug('<%=drug_code%>','modify','<%=srl_no%>','<%=sliding_scale_yn%>');" id="<%=drug_code%><%=srl_no%>" onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');">
												<font class="HYPERLINK" size='1'><%=dispDesc%>
												</font>
<%
												if (!ext_prod_id.equals("")&&perform_external_database_checks_yn.equals("Y")) {
%>
													<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_desc1%>') ">
<%
												}
%>
												&nbsp;&nbsp;</td>
<%                  
												if(drug_adr_count>0){
%> 
													<td class=<%=classValue%> colspan=""  width="5%"  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' >&nbsp;<%=adr_gif%>&nbsp;</td>
<%					
												}
												else{
%>
													<td class="<%=classValue%>" colspan=""  width="5%">&nbsp;</td>
<%
												}				
											}
											if(show_external_override_gif){
%>
												<td class="SHIFTTOTAL" colspan="" NOWRAP width="5%" title="External Override Reason" onmouseover="changeCursor(this);" onclick="viewMedicationAlert('<%=patient_id%>','<%=ext_prod_id%>','<%=drug_db_interact_check_flag%>','<%=drug_db_duptherapy_flag%>','<%=drug_db_contraind_check_flag%>','<%=drug_db_dosage_check_flag%>','PRESPAD','<%=java.net.URLEncoder.encode(external_dosage_override_reason)%>','<%=drug_code%>','<%=srl_no%>','<%=java.net.URLEncoder.encode(external_duplicate_override_reason)%>','<%=java.net.URLEncoder.encode(external_interaction_override_reason)%>','<%=java.net.URLEncoder.encode(external_contra_override_reason)%>','<%=java.net.URLEncoder.encode(pract_name)%>','<%=java.net.URLEncoder.encode(external_alergy_override_reason)%>','<%=drug_db_dosecheck_yn%>','<%=drug_db_alergy_check_flag%>')">&nbsp;<%if(external_checks_overrided.equals("N")){%>
													<img id='external_img<%=srl_no%>' style="visibility:visible"src='../../ePH/images/exceed1.gif'></img>
<%
											}
											else{
%>
												<img id='external_img<%=srl_no%>' style="visibility:hidden"src='../../ePH/images/exceed1.gif'></img>
<%
											}
%>
											&nbsp;</td>
<%
										}
										else{
%>
											<td class="<%=classValue%>" width="5%">&nbsp;<img id='external_img<%=srl_no%>' style="visibility:hidden"src='../../ePH/images/exceed1.gif'></td>
<%
										}
										if(allergy_yn!=null && allergy_yn.equals("Y")&&perform_external_database_checks_yn.equals("N")){
%>
											<td class="ALLERGY" colspan="" NOWRAP width="5%"title="Allergy Drug"  onclick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>');" onmouseover="changeCursor(this);">&nbsp;<%=allergy_override_gif%>&nbsp;</td>
<%
										}
										else{
%>
											<td class="<%=classValue%>" colspan="" NOWRAP width="5%">&nbsp;</td>
<%
										}					
										//if(limit_ind!=null && limit_ind.equals("N") && dose_override!=null && dose_override.equals("N")&&perform_external_database_checks_yn.equals("N")){
										if(limit_ind!=null && limit_ind.equals("N") && perform_external_database_checks_yn.equals("N")){
%>
											<td class="DOSELIMIT2" colspan="" NOWRAP width="5%" title="Exceed Dosage Limit" onmouseover="changeCursor(this);" onclick="showMonoGraph('<%=drug_desc%>','<%=java.net.URLEncoder.encode(mono_graph)%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>','<%=dosage_unit%>','<%=dosage_std%>','<%=dose_unit_desc%>','<%=max_daily_ceeling_dose%>','<%=min_daily_ceeling_dose%>','<%=max_unit_ceeling_dose%>','<%=min_unit_ceeling_dose%>','<%=dose_unit_desc1%>');">&nbsp;<%=overdose_override_gif%>&nbsp;</td> <!-- dose_unit_desc and dosage_std added for 0864 --><!-- Modified for IN:070451  -->
<%
										}
										else{
%>
											<td class="<%=classValue%>" width="5%">&nbsp;</td>
<%
										}
										if( interaction_exists.equals("Y") ){ // added for FD-RUT-CRF-0066.1 [IN036975] -Start
%>
											<td class="DOSELIMIT1" colspan="" NOWRAP width="5%" title='<fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/>' onmouseover="changeCursor(this);" onclick="showInractionDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>');" id='td_drugIntraction<%=srl_no%>'>&nbsp;<%=drugIntraction_override_gif%>&nbsp;</td>
<%
										}
										else{
%>
											<td class="<%=classValue%>" width="5%" id='td_drugIntraction<%=srl_no%>'>&nbsp;</td>
<%
										} // added for FD-RUT-CRF-0066.1 [IN036975] -End
										if(current_rx!=null && current_rx.equals("Y")&& perform_external_database_checks_yn.equals("N")){
%>
											<td class="CURRENTRX" colspan="" NOWRAP width="5%"title="Duplicate Medication"  onmouseover="changeCursor(this);" onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')">&nbsp;<%=currrx_override_gif%>&nbsp;</td>
<%
										}	
										else{
%>
											<td class="<%=classValue%>" colspan="" NOWRAP width="5%">&nbsp;</td>
<%
										}
									}
%>
										<input type='hidden' name='wt_mand_yn<%=srl_no%>' id='wt_mand_yn<%=srl_no%>' value="<%=wt_mand_yn%>"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->
										<input type='hidden' name='ht_mand_yn<%=srl_no%>' id='ht_mand_yn<%=srl_no%>' value="<%=ht_mand_yn%>"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->
										<input type='hidden' name='weight_rec_appl_age_group_check_flag<%=srl_no%>' id='weight_rec_appl_age_group_check_flag<%=srl_no%>' value="<%=weight_rec_appl_age_group_check_flag%>"> <!--added for Bru-HIMS-CRF-079 IN[029945] -->
										<input type='hidden' name='recomm_yn_flag_<%=srl_no%>' id='recomm_yn_flag_<%=srl_no%>' value="<%=recomm_yn_flag%>"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->
									</tr>
<%
								}
							}
						}
					}
%>
				</table>
<%
			}// top if
%>
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="sliding_scale_yn" id="sliding_scale_yn" value="<%=sliding_scale_yn%>">
			<input type="hidden" name="recomm_yn_flag" id="recomm_yn_flag" value="<%=recomm_yn_flag%>">
		</form>
<% 
		putObjectInBean(dir_bean_id,dir_bean,request);
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(presBean_id,presBean,request);
%>
		</body>
		<script>
<%
		if(tmp_srl_no!=null ){
			if(recomm_yn_flag){
%>
				recommendDosage('<%=tmp_drug_code%>','modify','<%=tmp_srl_no%>');//prescription_form,
<%
			}
			else{
%>
				defaultDrug('<%=tmp_drug_code%>','modify','<%=tmp_srl_no%>');
<%
			}
		}
%>
	</script>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

