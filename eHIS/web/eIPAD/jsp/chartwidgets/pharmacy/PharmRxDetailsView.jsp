<!DOCTYPE html>
<%@page import="java.net.URLDecoder"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*" %>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale" %>  
<%@ page import ="java.util.ResourceBundle" %>
<%@ page import ="com.ehis.persist.PersistenceHelper" %>
<%@page import="ePH.PrescriptionBean"%>
<%@page import="ePH.PrescriptionBean_1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<script src="${path}/eIPAD/js/PharmRxDetails.js"></script> 
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%
   request.setCharacterEncoding("UTF-8");
   String locale			= (String)session.getAttribute("LOCALE");
   Locale appLocale;
   if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
   appLocale = new Locale((String)session.getAttribute("LOCALE"));
   else 
   appLocale = new Locale("en");
   ResourceBundle csResBundle = ResourceBundle.getBundle("eIPAD.chartsummary.common.resourcebundle.cslabels", appLocale); 
   
   PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
   
   String ph_version =	(String)PhLicenceRights.getKey();
   String facility_id = patientContext.getFacilityId();
   String patient_id = patientContext.getPatientId();
   String patient_class = patientContext.getPatientClass();
   String encounter_id = patientContext.getEncounterId();
   String resp_id = patientContext.getResponsibilityID();
   String pract_id = patientContext.getClinicianId();
   String location_code = patientContext.getLocationCode();
   String bl_install_yn = (String) session.getValue( "bl_operational" )==null?"N":(String) session.getValue( "bl_operational" ) ;
   String mode		= CommonRepository.getCommonKeyValue( "MODE_INSERT" ); 
   
   //Rx View Code Starts
   
  String bean_id = "@PrescriptionBean_1"+patient_id+encounter_id;	
  String bean_name	= "ePH.PrescriptionBean_1";
  PrescriptionBean_1 bean =(PrescriptionBean_1)PersistenceHelper.getBeanObject(bean_id,bean_name,request); 
  bean.setLanguageId(locale);
   
   String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;
   String presBean_name		= "ePH.PrescriptionBean";	
   PrescriptionBean presBean = (PrescriptionBean)getBeanObject( presBean_id,presBean_name,request);               
   presBean.setLanguageId(locale);	  
   String param_bean_id					= "@DrugInterfaceControlBean"+patient_id+encounter_id;
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean			= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
   
  HashMap drug_detail =	null;
  ArrayList	presDetails	= (ArrayList) bean.getpresDetails();
  String drugItemNo = request.getParameter("drugItemNo");
  int drugIndex = Integer.parseInt(drugItemNo);
  drug_detail = (HashMap) presDetails.get(drugIndex);
   String calling_mode ="blank";
   
   int dose_decimal				= 6;
  String drugDesc = (String)drug_detail.get("SHORT_DESC"); 
  String drug_code = (String)drug_detail.get("DRUG_CODE");
  String form_code = (String)drug_detail.get("FORM_CODE"); 
  String route_code = (String)drug_detail.get("ROUTE_CODE");
  String priority= (String)drug_detail.get("PRIORITY");
  String freq_code= (String)drug_detail.get("FREQ_CODE");
  String dosage_type= (String)drug_detail.get("DOSAGE_TYPE");
  String qty_desc_code = (String)drug_detail.get("QTY_DESC_CODE");
  String pres_base_uom = (String)drug_detail.get("PRES_BASE_UOM");
  String order_type_code = (String)drug_detail.get("ORDER_TYPE_CODE");
  String drug_class = (String)drug_detail.get("DRUG_CLASS");
   String route_option=	"";   
   String buildMAR_checked= "";
   String buildMAR_rule = "";
   String buildMAR_yn= "N";
   String sys_date = "";
   String man_rem_on_prn_freq_yn = (String)drug_detail.get("MANDATORY_REM_ON_PRN_FREQ_YN");
   //Build MAR check box
   	ArrayList param_vals	=	bean.getParameterValues();
	    String allow_without_diag="";
		String 	allow_without_wt="";
		String bl_disp_charge_dtl_in_rx_yn1="";
		String disp_charge_dtl_in_drug_lkp_yn="";
		String disp_price_type_in_drug_lkp="";
		String dc_mar_appl_yn="";
		String disch_med_mar_appl_yn ="";
		String em_mar_appl_yn="";
		String ip_mar_appl_yn="";
		String op_mar_appl_yn="";
		String split_based_priority_yn		= "";
		String split_based_drug_class_yn		= "";
		String narcotic_aprvl_form_req_yn		= "";
		String print_narcotic_form_by_default		= "";
		String rx_qty_by_pres_base_uom_yn		= "";
		String atc_allergy_alert_level		= "";
		String print_mar_label_yn			= "";
		String dispPrescripionDuration		= "";
		String diag_for_medn_order_by		= "";
		String default_prev_drug_sel		= "";
		String preview_rx_yn				= "";
		String disp_prev_vital_signs_yn		= "";
		String max_length_prn_reason		= "";
		String max_durn_for_ip_pres			= "";
		String chk_for_ip_max_durn_action	= "";
		String max_durn_for_op_pres			= "";
		String chk_for_op_max_durn_action	= "";
		String max_durn_for_dm_pres			= "";
		String chk_for_dm_max_durn_action	= "";
		String trade_display_yn				= "";
		String drug_interaction_check_yn	= "";
		String allow_priv_to_order_yn		= "";
		
		String buildMAR_enable ="";
		String take_medication_yn_val	= "";
		int medication_rec				= 0;
	
	if(param_vals!=null && param_vals.size()!=0) {
		int iCount=0;
		 allow_without_diag				=	(String)param_vals.get(iCount++);
		 allow_without_wt				=	(String)param_vals.get(iCount++);
		 bl_disp_charge_dtl_in_rx_yn1		=	(String)param_vals.get(iCount++);
		 disp_charge_dtl_in_drug_lkp_yn	=	(String)param_vals.get(iCount++);
		 disp_price_type_in_drug_lkp		=	(String)param_vals.get(iCount++);
		 dc_mar_appl_yn					=	(String)param_vals.get(iCount++);
		 em_mar_appl_yn					=	(String)param_vals.get(iCount++);
		 ip_mar_appl_yn					=	(String)param_vals.get(iCount++);
		 op_mar_appl_yn					=	(String)param_vals.get(iCount++);
		 
		 disch_med_mar_appl_yn			=	(String)param_vals.get(iCount++);
		 split_based_priority_yn		=	(String)param_vals.get(iCount++);//10
		 split_based_drug_class_yn		=	(String)param_vals.get(iCount++);
		 narcotic_aprvl_form_req_yn		=	(String)param_vals.get(iCount++);
		 print_narcotic_form_by_default	=	(String)param_vals.get(iCount++);
		 rx_qty_by_pres_base_uom_yn		=	(String)param_vals.get(iCount++);
		 atc_allergy_alert_level			=   (String)param_vals.get(iCount++);
		 iCount++; 
		print_mar_label_yn			=   (String)param_vals.get(iCount++); 
		iCount++; 
		dispPrescripionDuration	=	(String)param_vals.get(iCount++);
		diag_for_medn_order_by=(String)param_vals.get(iCount++);
		default_prev_drug_sel			=   (String)param_vals.get(iCount++); 
		preview_rx_yn					=	(String)param_vals.get(iCount++);
		disp_prev_vital_signs_yn	=	(String)param_vals.get(iCount++);

		max_length_prn_reason			=   (String)param_vals.get(iCount++); 
		max_durn_for_ip_pres		=	(String)param_vals.get(iCount++); 
		chk_for_ip_max_durn_action	=	(String)param_vals.get(iCount++);
		max_durn_for_op_pres		=	(String)param_vals.get(iCount++);
		chk_for_op_max_durn_action	=	(String)param_vals.get(iCount++); 
		max_durn_for_dm_pres		=	(String)param_vals.get(iCount++);
		chk_for_dm_max_durn_action	=	(String)param_vals.get(iCount++);
		trade_display_yn			=	(String)param_vals.get(iCount++);
		drug_interaction_check_yn	=	(String)param_vals.get(iCount++);
		iCount++;
		allow_priv_to_order_yn	=	(String)param_vals.get(iCount++);
	}
	if(patient_class!=null && patient_class.equals("OP")){		
		take_medication_yn_val	= "N";
	}
	else{
		if(!patient_class.equals("XT")){			
			medication_rec=(int)bean.getHomeMecdicationYn(encounter_id,facility_id);
		}
		if(medication_rec>0){			
			take_medication_yn_val	= "Y";
			patient_class="OP";
		}
		else{			
			take_medication_yn_val	= "N";
		}
	}		         
               String take_home_med = take_medication_yn_val; // To Match Desktop webcode
               String MAR_app_yn="";		
                if(take_home_med.equals("Y"))
                                MAR_app_yn =  disch_med_mar_appl_yn; 
                else if(patient_class.equals("DC"))
                                MAR_app_yn =  dc_mar_appl_yn; 
                else if(patient_class.equals("EM"))
                                MAR_app_yn =  em_mar_appl_yn; 
                else if(patient_class.equals("IP"))
                                MAR_app_yn = ip_mar_appl_yn; 
                else if(patient_class.equals("OP"))
                                MAR_app_yn =  op_mar_appl_yn; 
					if(MAR_app_yn.equals("Y")){					
   buildMAR_rule=(String) drug_detail.get("BUILD_MAR_RULE")==null?"":(String) drug_detail.get("BUILD_MAR_RULE");	
						if(drug_detail.get("BUILDMAR_YN")==null || drug_detail.get("BUILDMAR_YN").toString().equals("")){
							if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("CD")){
								buildMAR_checked="checked";
								buildMAR_yn="Y";
							}
							else if(buildMAR_rule.equals("UE") || buildMAR_rule.equals("UD")){
								buildMAR_checked="";
								buildMAR_yn="N";
							}
						}
						else{
							buildMAR_yn=drug_detail.get("BUILDMAR_YN").toString();

							if(buildMAR_yn.equals("Y")){
								buildMAR_checked ="checked";							
							}
							else
								buildMAR_checked ="";		
						}
						if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("UE")){
							buildMAR_enable="";
						}
						else if(buildMAR_rule.equals("CD") || buildMAR_rule.equals("UD")){
							buildMAR_enable="disabled";
						}
						if( calling_mode.equals("taper")|| calling_mode.equals("tapered"))
							buildMAR_enable ="disabled";
						if(buildMAR_yn.equals("Y"))
							buildMAR_checked ="checked";
					}
		//End			
		
   // Patient Brought Med		
   String brought_by_pat = (String)drug_detail.get("BROUGHT_BY_PAT");   
   if(brought_by_pat==null) 
		brought_by_pat	=	"N";
	//end				
		
   //Patient Counselling Check		
   String chk_pat_couns_req = "";
   String check_pat_con	= (String)drug_detail.get("PAT_COUNSELING_REQD");   						
   if(check_pat_con == null)
	   check_pat_con = "N";
   if(check_pat_con.equals("Y")){
	chk_pat_couns_req="checked";
   }
		//end			 
   String trade_option=	""; 
   String priority_option = "";
   String trade_option_disable=	"";
   String actionText =	"";   
   String trade_code =(String)drug_detail.get("TRADE_CODE");   
   String qty_option= "";
   String qty_value="";    
   String strength_uom = (String)drug_detail.get("STRENGTH_UOM");  
   String strength_uom_desc = (String)drug_detail.get("STRENGTH_UOM_DESC"); 
   String strength_value= (String) drug_detail.get("STRENGTH_VALUE");
   String ori_dosage_type =(String)drug_detail.get("ORI_DOSAGE_TYPE"); 
   String freq_option =	"";	
   boolean def_freq_found =	false; 
   String freq_nature =	"";	    
   String duration_option =	"";
   String dflt_qty_uom =	"";	  
   dflt_qty_uom				= (String) drug_detail.get("DFLT_QTY_UOM");   
   String pres_base_uom_desc	= (String) drug_detail.get("PRES_BASE_UOM_DESC");
   Hashtable DurnDescDetails = new Hashtable();    
   if(route_code==null || route_code.equals ("") )
   route_option= route_option + "<option value='' selected>&nbsp;&nbsp;&nbsp;---"+"Select Value"+"---&nbsp;&nbsp;&nbsp;</option>";
   else
   actionText = presBean.getActionText(form_code,route_code);
   
   //Route Values
   ArrayList routes =	presBean.getRoutes(form_code); 
   for(int l=0; l<routes.size(); l+=3) { 
            if( ((String)routes.get(l)).equals(route_code) ) {  
   route_option=route_option + "<option  value='"+(String)routes.get(l)+"'selected>"+(String)routes.get(l+1)+"</option>";	
   }
   else {	
   route_option= route_option + "<option value='"+(String)routes.get(l)+"'>"+(String)routes.get(l+1)+"</option>";				
   }							
   }
   sys_date=(String) presBean.getSysdate();
   //end
   
   //Trade values
   ArrayList trades = presBean.getTrades(drug_code); 
       if(trades != null){
     for(int l=0; l<trades.size(); l+=2) {
   
   if( ((String)trades.get(l)).equals(trade_code) ) {  
   trade_option=trade_option + "<option  value='"+(String)trades.get(l)+"'selected>"+(String)trades.get(l+1)+"</option>";	
   }
   else {	
   trade_option= trade_option + "<option value='"+(String)trades.get(l)+"'>"+(String)trades.get(l+1)+"</option>";				
   }		   
    } 
    }
	else{
	trade_option="<option value='' selected>&nbsp;&nbsp;&nbsp;---"+"Select Value"+"---&nbsp;&nbsp;&nbsp;</option>";
	}
	if(trades.size() == 0){
		trade_option_disable ="disabled";
	}
	//End
	
	//Priority Options
	priority_option=priority_option + "<option  value='U' selected>Urgent</option>";	
	priority_option=priority_option + "<option  value='R' selected>Routine</option>";	
	//
   
   //Quantity Values
    ArrayList QtyDescDetails	= (ArrayList)presBean.loadQtyDetails(form_code);   
	for(int i=0; i<QtyDescDetails.size(); i+=3)	{
		if(dosage_type.equals("S")){ 			
		qty_option	=  "<option value='"+strength_uom+"' selected>"+strength_uom_desc+"</option>";	
		}
		else if(dosage_type.equals("Q")){
			if(((String)QtyDescDetails.get(i)).equals(qty_desc_code)){
				qty_option	=  qty_option+"<option value='"+QtyDescDetails.get(i)+"'selected>"+QtyDescDetails.get(i+1)+"</option>";
		 	}
			else{
				qty_option	= qty_option+"<option value='"+QtyDescDetails.get(i)+"'>"+QtyDescDetails.get(i+1)+"</option>";
			}
		}else{
			
          qty_option	=  "<option value='"+pres_base_uom+"' selected>"+pres_base_uom_desc+"</option>";
		}		
	}
	//End	    
    %> 
   <% 	
	String display_auth_rule = "display:none";
    String color_auth_rule   = "";  
    String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id)==null?"":param_bean.getDrugDBAllergy_check_yn(facility_id);
    String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id)==null?"":param_bean.getDrugDBInterface_yn(facility_id);
    String drug_db_duptherapy_yn	    =	param_bean.getDrugDBDuptherapy_yn(facility_id)==null?"":param_bean.getDrugDBDuptherapy_yn(facility_id);
    String drug_db_dosecheck_yn 		=	param_bean.getDrugDBDosecheck_yn(facility_id);
    String bl_disp_charge_dtl_in_rx_yn	= 	request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");   
	String ext_checks_overrided			= "";
	String drug_db_dosage_check_flag	= "";
	String drug_db_duptherapy_flag		= "";
	String drug_db_contraind_check_flag	= "";
	String drug_db_interact_check_flag	= "";
	String drug_db_allergy_flag			= "";
	String dsg_reason					= "";
	String dup_reason					= "";
	String con_reason					= "";
	String int_reason					= "";
	String alg_reason					= "";
	String ext_prod_id					= null;
	String in_formulary_yn				= "";
	String limit_ind					= null;
	String interaction_exists			= "";
	String allergy_yn					= null;
	String ord_spl_appr_reqd_yn			= "";
	String ord_approved_yn				= "";
	String ord_cosign_reqd_yn			= "";
	String ord_cosigned_yn				= "";
	String current_rx					= "";
	String repeat_value					= "";
	String start_date					= "";
	String generic_id					= "";
	String calc_def_dosage_yn			= "";
	String fract_dose_appl_yn           ="";
	String current_rx_tapered			= "";
	String duplicate_check_at_atc_yn	= "";
	String drug_code_sliding			= "";
	String srl_no_sliding				= "";
	String copied_drug_yn				= "";
	String amend_yn						= "";	
	String drug_desc					= "";
	String drug_name_1					= "";
	String provide_taper				= "";
	String split_dose					= "";
	String tab_qty_value				= "";
	String strength_per_value_pres_uom	= "";
	String sliding_scale_yn				= ""; 
	String split_dose_yn_val			= "N";
	String rowVal						= "";
	String scheduled_yn					= "";
	String repeat_durn_type				= "";
	String absol_qty					= "";
	String prn_dose						= "";
	String allow_duplicate				= "";
	String ord_auth_reqd_yn				= "";
	String ord_authorized_yn			= "";
	String max_durn_for_refill_pres		= "";
	String no_refill					= "";
	String order_set_code				= "";
	String interval_value				= "";
	String act_patient_class			= "";
	String back_date					= "";
	String future_date					= "";
	String pregnency_yn					= "";
	String durn_value					= "";
	String freq_chng_durn_desc			= "";
	String uom_disp						= "";
	String form_desc					= "";
	String disp_locn_desc				= "";
	String admin_time					= "";
	String admin_qty					= "";
	String qty_reqd_yn					= "";
	String split_dose_yn				= "";
	String taper_disable 				= "";
	String drug_tapered	 				= "";
	String sch_over_yn					= "";
	String refill_yn		            = "";
	String refill_cont_order_yn			= "";
	String refill_yn_from_param	        = "";
	String refill_start_date			= "";
	String refill_end_date				= "";
	String max_durn_value				= "";
	String chk_for_max_durn_action		= "";
	String force_auth_yn			    = "";
	String allergy_remarks				= "";
	String exceed_dose_remarks			= "";
	String prn_remarks     				= "";
	String duplicate_drug_remarks		= "";
	String drug_interaction_remarks		= "";
	String DrugIndicationRemarks		= "";
	String pt_coun_reqd_yn				= "";
	boolean dup_found					= false;
	String orig_current_rx				= "";
	String ord_authorized_prev_yn		= "";
	String DrugRemarksEntered			= "";
	String bl_incl_excl_override_reason_code = "";
	String bl_incl_excl_override_reason_desc = "";
	String bl_def_override_excl_incl_ind     = "";
	String bl_override_excl_incl_ind         = "";
	String bl_override_allowed_yn            = "";
	String preg_remarks					= ""; 
	String consider_stock_for_pres_yn	= "";
	String dose_override				= "";
	String strength_per_pres_uom		= "";
	String conv_factor					= "";
	int take_home						= 0;
	String disp_locn_code				= "";
	String stock_uom					= "";
	String mono_graph					= "";
	String unit_dose					= "";
	String daily_dose					= "";
	String generic_name					= "";
	String statFreqCode					= "";
	boolean statFeqFound 				= false;
	String recomm_dosage_by     		= "";
	String billable_item_yn = "";	
	String drug_remarks = "";
	pregnency_yn	=presBean.getPregnencyYN(patient_id);	
	if(presDetails!=null && presDetails.size()>0){
		String curr_code = (String)(((HashMap) presDetails.get(presDetails.size()-1)).get("DRUG_CODE"));
		ArrayList ordergrp	=(ArrayList) bean.ordsortList();
		ArrayList grp		=(ArrayList) bean.sortList();
		String atc_level_1	=	"";
		String atc_level_2	=	"";
		String atc_level_3	=	"";
		String atc_level_4		=	"";  // added for the incedent no : 27465 
		String atc_level_5		=	"";  // added for the incedent no : 27465 
		String temp_generic_id = "";
		String temp_drug_code="";
		String ATC_dup_drug_code="";     // added for the incedent no : 27465 
		ArrayList atc_dup_drug_code= null;
		ArrayList atc_values =  new ArrayList();
		HashMap drugdetail	 =	null;
		for(int i=0;i<presDetails.size();i++){
			current_rx_tapered = "";
			drugdetail=(HashMap) presDetails.get(i);
			duplicate_check_at_atc_yn       = (String) drugdetail.get("DUPLICATE_CHECK_AT_ATC_YN");   //added for skr-scf-0143 IN 29184
			if(!drug_code_sliding.equals("") && drug_code_sliding.equals((String)drugdetail.get("DRUG_CODE")) && srl_no_sliding.equals((String)drugdetail.get("SRL_NO"))){
				drugdetail.put("BL_DEF_OVERRIDE_EXCL_INCL_IND","");
				drugdetail.put("BL_OVERRIDE_EXCL_INCL_IND","");
				drugdetail.put("BL_TOTAL_CHARGE_AMT","");   //added on 15dec-09
				drugdetail.put("BL_PATIENT_PAYABLE_AMT",""); //added on 15dec-09
				drugdetail.put("BL_DECIMAL_FORMAT_STRING",bean.getBLDecimalFormatString()); // priya --added for IN19010 --24/02/2010
			}
			ext_prod_id			= (String)drugdetail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugdetail.get("EXTERNAL_PRODUCT_ID");
			drug_db_duptherapy_flag		=  (String)drugdetail.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drugdetail.get("DRUG_DB_DUPTHERAPY_FLAG");
			copied_drug_yn		=  (String)drugdetail.get("COPIED_DRUG_YN")==null?"":(String)drugdetail.get("COPIED_DRUG_YN");
			current_rx_tapered = drugdetail.get("CURRENT_RX")==null?"":(String)drugdetail.get("CURRENT_RX");// moved out from the below if condition for MO-GN-5490 [IN:054620] - [IN:055921] -start
			amend_yn			= drugdetail.get("AMEND_YN")==null?"":(String)drugdetail.get("AMEND_YN");
			if( current_rx_tapered.equals("Y") && !drugdetail.containsKey("ORIG_CURRENT_RX")) {
				drugdetail.put("ORIG_CURRENT_RX","Y");							
			}
			else if( !current_rx_tapered.equals("Y") && !amend_yn.equals("Y") && !drugdetail.containsKey("ORIG_CURRENT_RX")){ 
				drugdetail.put("ORIG_CURRENT_RX","N");		
			} 
			if(duplicate_check_at_atc_yn!=null && duplicate_check_at_atc_yn.equals("Y") ){ //if condition added for skr-scf-0143 IN 29184
				atc_level_1	=	(String)drugdetail.get("ATC_CLASS_LEV1_CODE");
				atc_level_2	=	(String)drugdetail.get("ATC_CLASS_LEV2_CODE");
				atc_level_3	=	(String)drugdetail.get("ATC_CLASS_LEV3_CODE");
				atc_level_4	    =	(String)drugdetail.get("ATC_CLASS_LEV4_CODE");
				atc_level_5	    =	(String)drugdetail.get("ATC_CLASS_LEV5_CODE");
				drug_desc	=	(String)drugdetail.get("DRUG_DESC");
				drug_name_1=drug_desc;
				drug_name_1=drug_name_1.replaceAll(" ","%20");
				drug_name_1=java.net.URLEncoder.encode(drug_name_1,"UTF-8");
				drug_name_1=drug_name_1.replaceAll("%2520","%20");
				temp_generic_id	=	(String)drugdetail.get("GENERIC_ID");
				temp_drug_code = (String)drugdetail.get("DRUG_CODE");
				provide_taper	=	"";
				if(drugdetail.get("TAPPERED_OVER")!=null)
					provide_taper	= (String)drugdetail.get("TAPPERED_OVER");			
				if( (!provide_taper.equals("Y")) && (drugdetail.get("ALERT_YN")==null && (drugdetail.get("CURRENTRX_REMARKS")==null || ((String)drugdetail.get("CURRENTRX_REMARKS")).equals("")))) {
					atc_dup_drug_code = new ArrayList();
					atc_dup_drug_code = (ArrayList)drugdetail.get("ATC_DUP_DRUG_CODE");
					if(atc_dup_drug_code == null)
						atc_dup_drug_code = new ArrayList();
					if(!atc_values.contains(temp_drug_code)){ // ie. only while tapering, same drug will be allowed, and if its tapering need not chk for duplicate
						if(atc_values.contains(temp_generic_id)){
							drugdetail.put("CURRENT_RX","Y");
							atc_dup_drug_code.add(temp_drug_code);
							drugdetail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
							drugdetail.put("ALERT_YN","Generic :");
						}
						else if(atc_values.contains(atc_level_4)){    // added else if condition for the incedent no : 27465
							drugdetail.put("CURRENT_RX","Y");
							drugdetail.put("ATC_LEVEL_DUPLICATION","Y");
							drugdetail.put("ALERT_YN","Level 4:");
							atc_dup_drug_code.add(temp_drug_code);
							drugdetail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incedent no : 27465 
						}
						else{
							atc_values.add(drug_desc);
							atc_values.add(temp_drug_code);
							atc_values.add(temp_generic_id);
							if(!(atc_level_1==null || atc_level_1.equals("")))
								atc_values.add(atc_level_1);
							if(!(atc_level_2==null || atc_level_2.equals("")))
								atc_values.add(atc_level_2);
							if(!(atc_level_3==null || atc_level_3.equals("")))
								atc_values.add(atc_level_3);
							if(!(atc_level_4==null || atc_level_4.equals(""))){ // added condition for the incedent no : 27465 
								atc_values.add(atc_level_4);
							}
							if(!(atc_level_5==null || atc_level_5.equals(""))){ // added for the incedent no : 27465 
								atc_values.add(atc_level_5);
							}
						}
					}
					else{
						drugdetail.put("CURRENT_RX","N");
					}
				}
			}
		}
	}		
	drug_db_dosage_check_flag	= (String)drug_detail.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_DOSAGE_CHECK_FLAG");
	drug_db_duptherapy_flag		= (String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG");
	drug_db_contraind_check_flag= (String)drug_detail.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_CONTRAIND_CHECK_FLAG");
	drug_db_interact_check_flag	= (String)drug_detail.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_INTERACT_CHECK_FLAG");
	drug_db_allergy_flag		= (String)drug_detail.get("DRUG_DB_ALLERGY_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_ALLERGY_FLAG");
	dsg_reason					= (String)drug_detail.get("EXT_DDB_DSG_REASON")==null?"":(String)drug_detail.get("EXT_DDB_DSG_REASON");
	dup_reason					= (String)drug_detail.get("EXT_DDB_DUP_REASON")==null?"":(String)drug_detail.get("EXT_DDB_DUP_REASON");
	con_reason					= (String) drug_detail.get("EXT_DDB_CON_REASON")==null?"":(String)drug_detail.get("EXT_DDB_CON_REASON");
	int_reason					= (String) drug_detail.get("EXT_DDB_INT_REASON")==null?"":(String)drug_detail.get("EXT_DDB_INT_REASON");
	alg_reason					= (String) drug_detail.get("EXT_DDB_ALG_REASON")==null?"":(String)drug_detail.get("EXT_DDB_ALG_REASON");
	ext_prod_id					= (String)drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
	in_formulary_yn				= (String) drug_detail.get("IN_FORMULARY_YN")==null?"":(String) drug_detail.get("IN_FORMULARY_YN");
	limit_ind					= drug_detail.get("LIMIT_IND")==null?"":(String)drug_detail.get("LIMIT_IND");
	interaction_exists			= (String) drug_detail.get("INTERACTION_EXISTS")==null?"N": (String) drug_detail.get("INTERACTION_EXISTS");
	allergy_yn					= drug_detail.get("ALLERGY_YN")==null?"":(String)drug_detail.get("ALLERGY_YN");
	billable_item_yn			= drug_detail.get("BILLABLE_ITEM_YN")==null?"N":(String)drug_detail.get("BILLABLE_ITEM_YN");
	//From Details View
	ord_spl_appr_reqd_yn		= (String) drug_detail.get("ORD_SPL_APPR_REQD_YN");
	ord_approved_yn				= (String) drug_detail.get("ORD_APPROVED_YN");
	ord_cosign_reqd_yn			= (String) drug_detail.get("ORD_COSIGN_REQD_YN");
	ord_cosigned_yn				= (String) drug_detail.get("ORD_COSIGNED_YN");
	ord_auth_reqd_yn			= (String) drug_detail.get("ORD_AUTH_REQD_YN");
	ord_authorized_yn			= (String) drug_detail.get("ORD_AUTHORIZED_YN");
	repeat_value				= (String) drug_detail.get("REPEAT_VALUE")==null?"1":(String) drug_detail.get("REPEAT_VALUE");
	start_date					= (String) drug_detail.get("START_DATE");
	generic_id					= (String) drug_detail.get("GENERIC_ID");
	fract_dose_appl_yn			= (String) drug_detail.get("FRACT_DOSE_APPL_YN")==null?"":(String) drug_detail.get("FRACT_DOSE_APPL_YN");
	calc_def_dosage_yn			= (String) drug_detail.get("CALC_DEF_DOSAGE_YN")==null?"":(String) drug_detail.get("CALC_DEF_DOSAGE_YN");
	split_dose					= (String) drug_detail.get("SPLIT_DOSE_PREVIEW")==null?"":(String) drug_detail.get("SPLIT_DOSE_PREVIEW");
	tab_qty_value				= (String) drug_detail.get("TAB_QTY_VALUE");
	strength_per_value_pres_uom	= (String) drug_detail.get("STRENGTH_PER_VALUE_PRES_UOM");
	sliding_scale_yn			= (String) drug_detail.get("SLIDING_SCALE_YN")==null?"N":(String)drug_detail.get("SLIDING_SCALE_YN");
	sliding_scale_yn			= "N";
	split_dose_yn_val			= (String) drug_detail.get("SPLIT_DOSE_YN_VAL")==null?"":(String) drug_detail.get("SPLIT_DOSE_YN_VAL");
	rowVal						= (String) drug_detail.get("rowVal");
	scheduled_yn				= (String) drug_detail.get("SCHEDULED_YN")==null?"N":(String) drug_detail.get("SCHEDULED_YN");
	repeat_durn_type			= drug_detail.get("REPEAT_DURN_TYPE")==null?"D":(String) drug_detail.get("REPEAT_DURN_TYPE");
	absol_qty					= (String)drug_detail.get("ABSOL_QTY");
	prn_dose					= (String)drug_detail.get("PRN_DOSES_PRES_PRD_FILL");
	allow_duplicate				= (String) drug_detail.get("ALLOW_DUPLICATE_DRUG");
	max_durn_for_refill_pres	= (String) drug_detail.get("MAX_DURN_FOR_REFILL_PRES");
	no_refill					= (String) drug_detail.get("NO_REFILL");
	order_set_code	   			= (String) drug_detail.get("ORDER_SET_CODE")==null?"":(String) drug_detail.get("ORDER_SET_CODE");
	interval_value				= (String)drug_detail.get("INTERVAL_VALUE")==null?"1":(String)drug_detail.get("INTERVAL_VALUE");
	act_patient_class			= (String)drug_detail.get("act_patient_class")==null?"1":(String)drug_detail.get("act_patient_class");
	back_date					= (String) drug_detail.get("BACK_DATE");
	future_date					= (String) drug_detail.get("FUTURE_DATE");
	durn_value					= (String) drug_detail.get("DURN_VALUE");
	freq_chng_durn_desc   =  drug_detail.get("freq_chng_durn_desc")==null?"D":(String) drug_detail.get("freq_chng_durn_desc");
	form_desc					= (String) drug_detail.get("FORM_DESC");
	disp_locn_desc				= (String) drug_detail.get("DISP_LOCN_DESC")==null?"":(String) drug_detail.get("DISP_LOCN_DESC");
	admin_time					= (String) drug_detail.get("ADMIN_TIME");
	admin_qty					= (String) drug_detail.get("ADMIN_QTY");
	qty_reqd_yn					= (String) drug_detail.get("QTY_REQD_YN");
	split_dose_yn				= (String) drug_detail.get("SPLIT_DOSE_YN")==null?"":(String) drug_detail.get("SPLIT_DOSE_YN");
	drug_tapered				= drug_detail.get("DRUG_TAPERED_YN")==null?"":(String)drug_detail.get("DRUG_TAPERED_YN");
	sch_over_yn					= (String)drug_detail.get("SCH_OVER_YN");
	if(drug_detail.containsKey("REFILL_YN")){
		refill_yn = drug_detail.get("REFILL_YN")==null?"N":(String)drug_detail.get("REFILL_YN");
	}
	refill_cont_order_yn		= (String) drug_detail.get("REFILL_CONT_ORDER_YN");
	if(drug_detail.containsKey("REFILL_YN_FROM_PARAM")){
		refill_yn_from_param = drug_detail.get("REFILL_YN_FROM_PARAM")==null?"N":(String)drug_detail.get("REFILL_YN_FROM_PARAM");
	}
	refill_start_date			= (String) drug_detail.get("REFILL_START_DATE");
	refill_end_date				= (String) drug_detail.get("REFILL_END_DATE");
	max_durn_value				= (String) drug_detail.get("MAX_DURN_VALUE");
	chk_for_max_durn_action		= (String) drug_detail.get("CHK_FOR_MAX_DURN_ACTION");
	force_auth_yn				= (String) drug_detail.get("FORCE_AUTH_YN");	
	allergy_remarks				= (String) drug_detail.get("ALLERGY_REMARKS")==null?"":(String)drug_detail.get("ALLERGY_REMARKS");
	exceed_dose_remarks			= (String) drug_detail.get("DOSE_REMARKS")==null?"":(String)drug_detail.get("DOSE_REMARKS");
	
	prn_remarks			= (String) drug_detail.get("PRN_REMARKS")==null?"":(String)drug_detail.get("PRN_REMARKS");
	duplicate_drug_remarks		= (String) drug_detail.get("CURRENTRX_REMARKS")==null?"":(String)drug_detail.get("CURRENTRX_REMARKS");
	drug_interaction_remarks	= (String) drug_detail.get("INTERACTION_REMARKS")==null?"":(String)drug_detail.get("INTERACTION_REMARKS");
	DrugIndicationRemarks 		= (String) drug_detail.get("DRUG_INDICATION")==null?"":(String)drug_detail.get("DRUG_INDICATION");
	pt_coun_reqd_yn				= (String) drug_detail.get("PT_COUN_REQD_YN");
	ord_authorized_prev_yn		= (String) drug_detail.get("ORD_AUTHORIZED_PREV_YN");
	DrugRemarksEntered		 	= (String) drug_detail.get("DrugRemarksEntered")==null?"":(String) drug_detail.get("DrugRemarksEntered");
	bl_incl_excl_override_reason_code = (String) drug_detail.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"": (String) drug_detail.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"); 
	bl_incl_excl_override_reason_desc = (String) drug_detail.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"": (String) drug_detail.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
	bl_def_override_excl_incl_ind    = (String) drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drug_detail.get("BL_DEF_OVERRIDE_EXCL_INCL_IND"); 
	bl_override_excl_incl_ind        = (String) drug_detail.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drug_detail.get("BL_OVERRIDE_EXCL_INCL_IND");  
	bl_override_allowed_yn			  = (String) drug_detail.get("BL_OVERRIDE_ALLOWED_YN")==null?"": (String) drug_detail.get("BL_OVERRIDE_ALLOWED_YN"); 
	preg_remarks = (String) drug_detail.get("PREG_REMARKS")==null?"":(String)drug_detail.get("PREG_REMARKS");
	consider_stock_for_pres_yn	= (String) drug_detail.get("CONSIDER_STOCK_FOR_PRES_YN");
	dose_override				= (String) drug_detail.get("DOSE_OVERRIDE");
	strength_per_pres_uom		= (String) drug_detail.get("STRENGTH_PER_PRES_UOM");
	disp_locn_code				= (String) drug_detail.get("DISP_LOCN_CODE")==null?"":(String) drug_detail.get("DISP_LOCN_CODE");
	stock_uom					= (String) drug_detail.get("STOCK_UOM_DESC");
	mono_graph					= (String) drug_detail.get("MONO_GRAPH");
	unit_dose					= (String) drug_detail.get("UNIT_DOSE");
	daily_dose					= (String) drug_detail.get("DAILY_DOSE");
	generic_name				= (String) drug_detail.get("GENERIC_NAME");
	freq_nature					= (String) drug_detail.get("FREQ_NATURE")==null?"": (String) drug_detail.get("FREQ_NATURE");
	copied_drug_yn				= (String) drug_detail.get("COPIED_DRUG_YN")==null?"N":(String) drug_detail.get("COPIED_DRUG_YN");
	recomm_dosage_by			= (String) drug_detail.get("RECOMM_DOSAGE_BY")==null?"":(String)drug_detail.get("RECOMM_DOSAGE_BY");
	drug_remarks = (String) drug_detail.get("DRUG_REMARKS")==null?"":(String)drug_detail.get("DRUG_REMARKS");
		
	if(recomm_dosage_by.equals("B"))
		recomm_dosage_by = "Q";
	
	if(!preg_remarks.equals(""))
		preg_remarks = java.net.URLEncoder.encode(preg_remarks,"UTF-8");
	
	if(bl_override_excl_incl_ind.equals(""))
		bl_override_excl_incl_ind = bl_def_override_excl_incl_ind;
	
	if( drug_detail.containsKey("ORIG_CURRENT_RX") && ((String)drug_detail.get("ORIG_CURRENT_RX")).equals("Y") ) {
		orig_current_rx	=	(String)drug_detail.get("ORIG_CURRENT_RX");
	}
	
	if(!ext_prod_id.equals("") && drug_db_allergy_check_yn.equals("Y") && drug_db_allergy_flag.equals("Y")){
		allergy_yn = "N";
		drug_detail.put("ALLERGY_YN",allergy_yn);
	}
   
	if((drug_db_dosage_check_flag.equals("Y") && (dsg_reason.equals(""))) ||(drug_db_duptherapy_flag.equals("Y")&&(dup_reason.equals(""))) || (drug_db_contraind_check_flag.equals("Y") && (con_reason.equals(""))) || (drug_db_interact_check_flag.equals("Y") && (int_reason.equals("")))||  (drug_db_allergy_flag.equals("Y") && (alg_reason.equals("")))){
		ext_checks_overrided = "N";
	}
	else
		ext_checks_overrided = "Y";
	
	current_rx					= (String) drug_detail.get("CURRENT_RX")==null?"":(String) drug_detail.get("CURRENT_RX");
	
	if(prn_dose==null || prn_dose.equals("")) {
		prn_dose	=	"1";
	}
	
	if(absol_qty==null || absol_qty.equals(""))
		absol_qty		=	"0";
	
	if(freq_nature.equals("P") && absol_qty.equals("0")) {
		absol_qty		=	prn_dose;	
	}
	
	if(!dosage_type.equals("A")) {
		if(!freq_nature.equals("P"))
			absol_qty			=	"1";
	}
	
	if(durn_value==null || durn_value.equals("") || durn_value.equals("0"))
		durn_value="1";
	
	if( drug_tapered.equals("Y")) //Added for [IN:038913] Bru-HIMS-CRF-093/18 //|| tappered_over.equals("Y")) - commented for SKR-SCF-0955 [IN:047620]
		taper_disable="disabled";	
	
	//Duration Values
        DurnDescDetails	= (Hashtable)presBean.loadDurnDesc();
		Enumeration keys_des		= DurnDescDetails.keys();
		String	durn_code			= "";
		while(keys_des.hasMoreElements())	{
			durn_code		= (String)keys_des.nextElement();
			if(freq_chng_durn_desc.equals(durn_code)) {
				duration_option	= duration_option + "<option value='"+durn_code+"' selected='selected'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
			}
			else {
				duration_option	= duration_option + "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";
			}
		}
		
		if(((orig_current_rx.equals("Y") && !amend_yn.equals("Y") )||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N") && !calling_mode.equals("tapered") && !calling_mode.equals("taper")) { 
			dup_found	=	true;
		}
		if(dosage_type.equals("Q"))
			conv_factor = (String) bean.getConvFactor(qty_desc_code,pres_base_uom);
		
		if(encounter_id!=null && !(encounter_id.equals(""))){
			take_home=(int)bean.getTakeHomeCount();
	}
   // End 
   
   //Frequency values
   HashMap  freqValues 	=(HashMap)bean.populateFrequencyValues(drug_code,freq_code,calling_mode,patient_class);
       ArrayList	freqCode	= (ArrayList) freqValues.get("FreqCode");
		ArrayList   freqDesc	= (ArrayList) freqValues.get("FreqDesc");
		ArrayList   FreqNature	= (ArrayList) freqValues.get("FreqNature");  
        if(freqValues.size()>0 && (dup_found) && amend_yn.equals("Y")){
			if(allow_duplicate.equals("N")){
				ArrayList stat_freqs	=	presBean.loadStatFreqs();
				for(int i=0;i<stat_freqs.size();i+=2){
					if(freq_code.equals((String) stat_freqs.get(i))){
						freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
						freq_code	    = ((String) stat_freqs.get(i));
					}
					else{
						freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"' >"+((String) stat_freqs.get(i+1))+"</option>";
					}
					freq_nature	    = "O";
				}
			}
			else {
				for(int i=0;i<freqCode.size();i++){					
					if( dup_found  && !amend_yn.equals("Y")) {
						if( ((String) FreqNature.get(i)).equals("O")) {
							freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
						}
					}
					else {
						if(((String) freqCode.get(i)).equals(freq_code)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
							freq_nature	    = (String) FreqNature.get(i);
							def_freq_found  = true;
						} 
						else {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
						}
					}
				}
			}
		}
		else if(freqValues.size()>0 && !(dup_found)){
			statFreqCode = freq_code;
				if(priority.equals("U") && !amend_yn.equals("Y")){
					ArrayList stat_freqs	=	presBean.loadStatFreqs();
					if(stat_freqs.size()>0){
						for(int i=0;i<stat_freqs.size();i+=2){
							statFreqCode=(String) stat_freqs.get(i);
							for(int j=0;j<freqCode.size();j++){
								freq_code=(String) freqCode.get(j);
								if(statFreqCode.equals(freq_code)){
									statFeqFound = true;
									break;
								}
							}
						}
					}
				}

				for(int i=0;i<freqCode.size();i++){
					if( dup_found ) {
						if( ((String) FreqNature.get(i)).equals("O")) { 
							freq_option	    = freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+(   (String) freqDesc.get(i))+"</option>";
							freq_nature	    = "O";
							freq_code	    = ((String) freqCode.get(i));
							def_freq_found  = true;
							statFeqFound = true;
						}
					}
					else {
						if(((String) FreqNature.get(i)).equals("O"))
							statFeqFound = true;
						if(((String) freqCode.get(i)).equals(statFreqCode)) {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'  selected>"+((String) freqDesc.get(i))+"</option>";
							def_freq_found  = true;
							freq_nature	    = (String) FreqNature.get(i); 
						} 
						else {
							freq_option		= freq_option +	"<option value='"+((String) freqCode.get(i))+"'>"+((String) freqDesc.get(i))+"</option>";
						}
					}
				}
			if(amend_yn.equals("Y"))
				def_freq_found  = true;
		}
		else if(dup_found ) { 
			for(int i=0;i<freqCode.size();i++){
				if(((String) FreqNature.get(i)).equals("O")){
					freq_code = (String)freqCode.get(i);
					statFeqFound = true;
					break;
				}
			}
			ArrayList stat_freqs	=	presBean.loadStatFreqs();			
			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				freq_nature	    = "O";
			}
		} 

		if(freq_option.equals("")) {
			ArrayList stat_freqs	=	presBean.loadStatFreqs();
			for(int i=0;i<stat_freqs.size();i+=2){
				freq_option		= freq_option +	"<option value='"+((String) stat_freqs.get(i))+"'  selected>"+((String) stat_freqs.get(i+1))+"</option>";
				statFeqFound = true;
				freq_nature	   =	"O";
				freq_code	   = ((String) stat_freqs.get(i));
			}
		}
   //end

   		qty_value					= (String) drug_detail.get("QTY_VALUE");			
   %> 
<div data-role = "none"  class = "blurPopup" onclick="" data-popid="" style="z-index:10000"></div>
   <div class="ChartSummaryBlockVar" id="rxDetailsSummaryBlock" data-role = "none">
      <form id="rxDetailsViewForm" name = "rxDetailsViewForm" method = "post" action = "" class="ChartSummaryFormElem">
         <div class="ChartSummaryMainTable" data-role = "none">
            <div data-role = "none" class ="ChartSummaryPageHeader">
               <div class="ChartSummaryHeaderCell" data-role = "none">
                  <div class="ChartSummaryHeaderCont" data-role = "none">
                     <div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role = "none">
                        <div class="ChartSummaryHeaderRow" data-role = "none">
                           <div class="ChartSummaryHeaderTextCol" data-role = "none">
                              <div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role = "none">Rx</div>
                           </div>
                           <div class="ChartSummaryHeaderEncRightCol" data-role="none">
                              <div class="WidgetButtonTheme" data-role = "none" onclick="completeRxDetailsConfirm()"><img src="${path}/eIPAD/images/CS_Ok16x16.png"></div>
                           </div>
                           <div class="ChartSummaryHeaderEncRightCol" data-role="none">
                              <div class="WidgetButtonTheme" data-role = "none" onclick="closeRxDetailsView()"><img src="${path}/eIPAD/images/CS_Close16x16.png"></div>
                           </div>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
            <div data-role = "none" class = "ChartSummaryPageContent ChartSummaryPageContentTheme" id="">
               <div data-role = "none" class = "ChartSummaryPageContentCell">
                  <div data-role = "none" class = "ChartSummaryMainWrapper pharmDataMainWrapper" id="" >
                     <div class="ChartSummaryMainScroller pharmDataContentScroller"  data-role = "none">
                        <div class="table pharmDataItemHeight"  data-role = "none">
                           <div  class="row pharmOrderItemBannerRow"  data-role = "none">
                              <div class="cell pharmOrderItemHeader"  data-role = "none">
                                 <div class="table pharmDataItemHeight"  data-role = "none">
                                    <div  class="row pharmItemDescNameCell"  data-role = "none">
                                       <div class="cell pharmRxOrderItemName segoeuiBold"  data-role = "none">
                                          <span class="pharmRxOrderItemName10padding "><%=drugDesc%>
                                          </span>
                                       </div>
                                       <div class="cell pharmRxOrderItemIcons"  data-role = "none">
                                       <%
                                       if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {
                                       %>                                        
                                          <span class="pharmRxOrderItemIconsVRalign">
                                          <img src="${path}/eIPAD/images/externalDatabase25X25.png" class="imgBannerIndicator">
                                          </span>
                                       <% }
                                       display_auth_rule = "display:none";
                                       if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") ){
                                    	   display_auth_rule = "display:inline-block";
                                       }
                                       %>
                                          <span id="span_beyondDoseLimit" name="span_beyondDoseLimit" class="pharmRxOrderItemIconsVRalign" style='<%=display_auth_rule%>;'>
                                          <img src="${path}/eIPAD/images/beyondDoseLimit25X25.png" class="imgBannerIndicator">
                                          </span>
                                       <% 
                                       if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  interaction_exists.equals("Y") ) {
                                       %>
                                          <span class="pharmRxOrderItemIconsVRalign">
                                          <img src="${path}/eIPAD/images/drugInteraction25X25.png" class="imgBannerIndicator">
                                          </span>
                                       <% }
                                    	   display_auth_rule = "display:none";
                                    	   if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y")) && current_rx!=null && current_rx.equals("Y")){
                                        	   display_auth_rule = "display:inline-block";
                                           }
                                       %>
                                          <span id="span_duplicateDrug" name="span_duplicateDrug" class="pharmRxOrderItemIconsVRalign"  style='<%=display_auth_rule%>;'>
                                          <img src="${path}/eIPAD/images/duplicateDrug25X25.png" class="imgBannerIndicator">
                                          </span>
                                       <%  
                                       if((ext_prod_id.equals("") || !drug_db_allergy_check_yn.equals("Y") || !drug_db_allergy_flag.equals("Y")) && allergy_yn!=null && allergy_yn.equals("Y")){
                                       %>
                                          <span id="span_allergy" class="pharmRxOrderItemIconsVRalign">
                                          <img src="${path}/eIPAD/images/pharmAllergy25X25.png" class="imgBannerIndicator">
                                          </span>
                                       <% }
                                       display_auth_rule = "display:none";
               							color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
               							
               							if(ord_auth_reqd_yn.equals("Y")){
               								display_auth_rule = "display:inline-block";
        									if(ord_authorized_yn.equals("Y"))
        										color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
        								}
                                       %>
                                          <span class="pharmRxOrderItemIconsVRalign" style='<%=display_auth_rule%>;'>
                                          <img src="${path}/eIPAD/images/authorizeRxDet25X25.png" class="imgBannerIndicator">
                                          <img src="${path}<%=color_auth_rule%>" class="BannerIndicators"/>
                                          </span>
                                       <%
                                   		display_auth_rule = "display:none";
               							color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
               							if(ord_cosign_reqd_yn.equals("Y")){
               								display_auth_rule = "display:inline-block";
               								if(ord_cosigned_yn.equals("Y"))
               									color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
               							}
                                       %>
                                          <span class="pharmRxOrderItemIconsVRalign" style='<%=display_auth_rule%>;'>
                                          <img src="${path}/eIPAD/images/cosignRxDet25X25.png" class="imgBannerIndicator"/>
                                          <img src="${path}<%=color_auth_rule%>" class="BannerIndicators"/>
                                          </span>
                                       <%
                                       	display_auth_rule = "display:none";
               							color_auth_rule   = "/eIPAD/images/Req_icon.PNG";
               							if(ord_spl_appr_reqd_yn.equals("Y")){
               								display_auth_rule = "display:inline-block";
        									if(ord_approved_yn.equals("Y"))
        										color_auth_rule = "/eIPAD/images/Selected_Tick14x14.png";
        								}
                                       %>
                                          <span class="pharmRxOrderItemIconsVRalign" style="<%=display_auth_rule%>;padding-right:10px;">
                                          <img src="${path}/eIPAD/images/Specialapproval.png" class="imgBannerIndicator">
                                          <img src="${path}<%=color_auth_rule%>" class="BannerIndicators"/>
                                          </span>                                         
                                       </div>
                                    </div>
                                    <div  class="row pharmItemDescNameCell"  data-role = "none">
                                       <div class="cell pharmRxOrderStrength"  data-role = "none">
                                          <div class="pharmRxOrderItemDesc">
                                             <label class="pharmRxOrderItemLabel">Strength</label>
                                             <%
												uom_disp = bean.getUomDisplay((String)session.getValue("facility_id"),strength_uom);
												if(uom_disp == null || uom_disp.equals("null"))
													uom_disp = "";
												if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1)
													strength_value = Float.parseFloat(strength_value)+"";//"0"+strength_value ;
											%>
                                             <span class="pharmRxOrderItemInfo segoeuiBold">&nbsp;<%=strength_value%>&nbsp;<%=uom_disp%></span>
                                          </div>
                                          <div class="pharmRxOrderItemDesc">
                                             <label class="pharmRxOrderItemLabel">Form</label>
                                             <span class="pharmRxOrderItemInfo segoeuiBold"><%=form_desc%></span>
                                          </div>
                                          <div class="pharmRxOrderItemDesc">
                                             <label class="pharmRxOrderItemLabel">Dispense location</label>
                                             <span class="pharmRxOrderItemInfo segoeuiBold"><%=disp_locn_desc%></span>
                                          </div>
                                       </div>
                                       <div class="cell pharmRxOrderItemRate"  data-role = "none">
                                          <span class="pharmRxOrderItemRateDesc"><span class="segoeuiBold" id="bl_total_charge_amt_detvw">--</span> / <span class="segoeuiBold" id="bl_patient_payable_amt_detvw">--</span></span>
                                       </div>
                                       <div class="cell pharmRxOrderItemRate"  data-role = "none">
                                          <span class="pharmRxOrderItemRateLabel segoeuiBold">Total / Patient</span>
                                       </div>
                                    </div>
                                    <div  class="row pharmCartBottomContainer"  data-role = "none">
                                       <div class="cell pharmCartBottomImg" data-role = "none">										 
                                       </div>
                                    </div>
                                 </div>
                              </div>
                           </div>
                           <div id="pharmRxScroller" class="row selectPharmOrder pharmOrderRxItemContainer" data-role = "none">
                              <div style="position:relative;width:100%;height:auto;">
                                 <div class="rxSectionHeader segoeuiBold" id="">Drug detail</div>
                                 <div class="sectionWrapper">
								    <div id="rowOne" class="padding10px" style="display:flex;">
									   <div style="display: inline-block;width: 49.5%;height: 80px;">
                                          <div class="rxLabel">
										    Priority<font class="rxMandatorIndi">*</font>
										  </div>
										  <select style="width:100%" id="rxPriority" name="rxPriority" id="rxPriority">
										    <%=priority_option%>                                            
										  </select>
                                       </div>
									   <div style="width:0.8%;"></div>
									   <div style="display: inline-block;width: 49.5%;height: 80px;">
                                          <div>
                                             <div class="rxLabel">Route<font class="rxMandatorIndi">*</font></div>
                                             <div  class="dropDown" >
                                                <select name="route_code" id="route_code" onChange="getActionText(this,'<%=form_code%>');" style="width: 100%" id="routeDpList"> <%=route_option%>                                            
                                                </select>
                                             </div>
                                          </div>
                                          <span class="rxDrugRouteLabel" id="rxDrugRouteVal" ><%=actionText%></span>
										</div>
									</div>
									<div id="rowSecond" class="padding10px" style="display:flex;">
									   <div style="display: inline-block;width: 49.5%;height: 80px;">
                                          <div id="tradeNameDpListDisable" class="rxLabel">Trade name</div>
                                          <div  class="dropDown" >
                                             <select style="width:100%;" id="tradeNameDpList" name="tradeNameDpList" id="tradeNameDpList"> <%=trade_option%>                                            
                                             </select>
                                          </div>
                                       </div>
									   <div style="width:0.8%;"></div>
									   <div style="display: inline-block;width: 49.5%;height: 80px;">
									      <div class="rxLabel">Build MAR</div>
                                          <div  class="rxCheckbox">
										<%
										if(MAR_app_yn.equals("Y")){
										%>
										<input id="buildMarChk" style="height: 20px;width: 20px;" type="checkbox" name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> <%=buildMAR_enable%> onclick='assignValue1(this);'/>
										
										<%-- <input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> <%=buildMAR_enable%> onclick='assignValue1(this);'> --%>
										<%
										}
										else{
										%>
										<!-- &nbsp;<input type='hidden' name='buildMAR_yn' id='buildMAR_yn' value='N'> -->
										<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
										<input id="buildMarChk" name='buildMAR_yn' id='buildMAR_yn' style="height: 20px;width: 20px;" type="checkbox" value='N' disabled/>
										<%
										}
										%>
										</div>
									   </div>
									</div>
                                 </div>
                                 <div class="pharmacySectionSperator"></div>
                                 <div class="rxSectionHeader segoeuiBold">Dosage detail</div>
                                 <div class="sectionWrapper">
								    <div id="dosageDetailRowOne" class="padding10px" style="display:flex;">
									   <div style="display: inline-block;width: 49.5%;height: 80px;">
                                          <div class="rxLabel">
										    Dosage by<font class="rxMandatorIndi">*</font>
										  </div>
										  <input style="width:100%;padding-left: 0px;" class="dropDown rxTextArea" type="text" id="rxDosageBy" maxlength="8" value="0"/>
                                       </div>
									   <div style="width:0.8%;"></div>
									   <div style="display: inline-block;width: 49.5%;height: 80px;">
									        <div style="width:100%;height:33px">
											</div>
											<div style="width:100%;height:48px">
                                            <div style="width:49.5%;float:left;">
                                               <input style="width:100%;height:43px;"  class="dropDown rxTextArea k-textbox" type="text" id="rxDosageByVal" name="rxDosageByVal" id="rxDosageByVal" maxlength="13" value="<%=qty_value %>" onchange="lookForChange(this);showBillingDetails();" onKeyPress="allowValidNumber(this,event,8,<%=dose_decimal%>)" />
                                            </div>
											<div style="width:1%;height:43px;float:left;">
											</div>
                                            <div style="width:49.5%;float:left;">
                                               <div  class="dropDown" >
                                                  <select style="width:100%;" id="dosageUOMDpList" name="dosageUOMDpList" id="dosageUOMDpList" onchange="showBillingDetails();">
												  <%=qty_option%>                                            
                                                  </select>
                                               </div>
                                            </div>
											</div>
                                       </div>
									</div>
									<div id="dosageDetailRowTwo" class="padding10px" style="display:flex;">
									    <div style="display: inline-block;width: 49.5%;height: 80px;">
									        <div class="rxLabel">Frequency<font class="rxMandatorIndi">*</font>
										    </div>
                                            <div  class="dropDown" >
                                               <select style="width:100%" id="frequencyDpList" name="frequencyDpList" id="frequencyDpList" onchange="freqChange(this,'Y','N','ChangeFreq','pBilling')">
   												<%=freq_option%>                                            
                                               </select>
                                            </div>
									    </div>
										<div style="width:0.8%;"></div>
										
										<div class="rxContainer alignTwo" id="prnRemarks">
											<div id="" class="rxLabel" >PRN remarks<font  id="prnMandatory" class="rxMandatorIndi">*</font></div>                                       
												<textarea type="text" maxlength="60" id="prnTextarea" style="width:99%" class="rxDetailsTextArea k-textbox"><%= URLDecoder.decode(prn_remarks, "UTF-8")%></textarea>                                       
										</div>
										
										
									</div>
                                 </div>
                                 <div class="pharmacySectionSperator"></div>
                                 <div class="rxSectionHeader segoeuiBold">Duration detail</div>
                                 <div class="sectionWrapper">
								    <div id="durationRowOne" class="padding10px" style="display:flex;">
									   <div style="display: inline-block;width: 49.5%;height: 80px;">
									        <div class="rxLabel">
											   Duration<font class="rxMandatorIndi">*</font>
											</div>
											<div style="width:100%;">
                                            <div style="width:49.5%;float:left;">
                                               <input style="width:100%;height:43px;"  class="dropDown rxTextArea k-textbox" type="text" id="rxDurationDetails" name="rxDurationDetails" id="rxDurationDetails" maxlength="3" value="<%=durn_value%>" onchange="showBillingDetails();" />
                                            </div>
											<div style="width:1%;height:43px;float:left;">
											</div>
                                            <div style="width:49.5%;float:left;">
                                               <div  class="dropDown" >
                                                  <select style="width: 100%" id="durationDpList" name="durationDpList" id="durationDpList" 
												  value="<%=freq_chng_durn_desc%>"> <%=duration_option%>
												  </select>
                                               </div>
											   <input type="hidden" name="tmp_durn_value" id="tmp_durn_value" value="<%=durn_value%>">
										       <input type="hidden" name="tmp_durn_desc" id="tmp_durn_desc"  value="D">
                                            </div>
											</div>
                                       </div>
									   <div style="width:0.8%;"></div>
									   <div style="display: inline-block;width: 49.5%;height: 80px;">
									         <div class="rxLabel">Drug remarks
											 </div>
                                             <div class="rxCheckbox">
                                                <textarea type="text" maxlength="40" id="drugRemTextarea" style="width:100%" class="rxDetailsTextArea k-textbox"><%= URLDecoder.decode(drug_remarks, "UTF-8") %></textarea>  
                                             </div>	 
									   </div>
									</div> 
								    <div id="durationRowTwo" class="padding10px" style="display:flex;">
									   <div style="display: inline-block;width: 49.5%;height: 80px;">
                                          <div class="rxLabel">
										    Start date and time<font class="rxMandatorIndi">*</font>
										  </div>
										  <input style="width:100% ! important;" class="dropDown" id="rxStartDate" onchange="populateEndDate('DATECHANGE')" onblur="populateEndDate('DATECHANGE')"/>
                                       </div>
									   <div style="width:0.8%;"></div>
									   <div style="display: inline-block;width: 49.5%;height: 80px;">
                                          <div>
                                             <div class="rxLabel">End date and time<font class="rxMandatorIndi">*</font></div>
                                             <div  class="dropDown" >
                                                <input style="width:100% ! important;" class="dropDown" id="rxEndDate" name="rxEndDate" id="rxEndDate" onblur="validateEndDate(this,'<%=locale%>');"/>
                                             </div>
                                          </div>
										</div>
									</div>
                                 </div>			 
																
									<div style="height: auto;padding: 0px 10px 0px 10px;width: 98%;display: inline-block;">	
										<%  
                                       	if((ext_prod_id.equals("") || !drug_db_allergy_check_yn.equals("Y") || !drug_db_allergy_flag.equals("Y")) && allergy_yn!=null && allergy_yn.equals("Y")){
                                       	%>
																				
										<div class="rxContainer alignThree"  id="algOverrideRsn" style="float:left">
										<div class="rxLabel" >Allergy override reason<font class="rxMandatorIndi">*</font></div>
										<textarea style="width:99%" type="text" maxlength="255" id="txtAllergyOverReason" class="dropDown rxDetailsTextArea k-textbox"><%=allergy_remarks%></textarea>
										</div>
										<% } 
										%>
								  
								  		<%
										display_auth_rule = "display:none;";
                             	   		if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y")) && current_rx!=null && current_rx.equals("Y")){
                                 	   		display_auth_rule = "display:inline-block;";
                                    	}
										%>	
										<div class="rxContainer alignTwo" id="drugOverrideRsn" style="<%=display_auth_rule%>">
											<div id="txtDupDrugOverReasonLabel" class="rxLabel" >Duplicate drug override reason<font class="rxMandatorIndi">*</font></div>                                       
												<textarea type="text" maxlength="255" id="txtDupDrugOverReason" style="width:99%" class="rxDetailsTextArea k-textbox"><%=duplicate_drug_remarks%></textarea>                                       
										</div>
										
										<%
										display_auth_rule = "display:none;";
                             	   		if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") ){
                                 	   		display_auth_rule = "display:inline-block;";
                                    	}
										%>	
										<div class="rxContainer alignTwo" id="exceedOverrideRsn" style="<%=display_auth_rule%>">
											<div id="txtExceedOverReasonLabel" class="rxLabel" >Beyond dosage limit override reason<font class="rxMandatorIndi">*</font></div>                                       
												<textarea type="text" maxlength="255" id="txtExceedOverReason" style="width:99%" class="rxDetailsTextArea k-textbox"><%=exceed_dose_remarks%></textarea>                                       
										</div>
										
										<%
										display_auth_rule = "display:none;";
                             	   		if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  interaction_exists.equals("Y") ) {
                                 	   		display_auth_rule = "display:inline-block;";
                                    	}
										%>	
										<div class="rxContainer alignTwo" id="drugInterOverrideRsn" style="<%=display_auth_rule%>">
											<div id="txtDrugInterOverReasonLabel" class="rxLabel" >Drug interaction override reason<font class="rxMandatorIndi">*</font></div>                                       
												<textarea type="text" maxlength="255" id="txtDrugInterOverReason" style="width:99%" class="rxDetailsTextArea k-textbox"><%=drug_interaction_remarks%></textarea>                                       
										</div>
										<div class="rxContainer alignThree" id="drugIndiOverrideRsn">
											<div id="txtDrugIndicationsLabel" class="rxLabel">Drug indications</div>
											<textarea style="width:99%" type="text" maxlength="255" id="txtDrugIndications" class="dropDown rxDetailsTextArea k-textbox"><%=DrugIndicationRemarks%></textarea> 
										</div>                                        										
								  		<%
										if(pt_coun_reqd_yn!=null && pt_coun_reqd_yn.equals("Y")){
								  		%>									
											<div class="rxContainer alignFive" id="patCounslingReq">
											<div class="rxLabel">Patient counselling required</div>
											<div class="rxCheckbox">
												<input style="height: 20px;width: 20px;" type="checkbox" value='<%=check_pat_con%>'  
												<%=chk_pat_couns_req%>  id="patCounsellingReq" />
											</div>
											</div>	
										<%}else {%>
										 <input type = "hidden" name ="patCounsellingReq" id ="patCounsellingReq"/>
										<%}%>	
									</div>									 							 				 
                              </div>
                           </div>
				<!-- Pharmacy legend starts -->
					<div id="rxDetailsLegend"></div>
				<!-- Pharmacy legend ends -->	
                        </div>
                     </div>
                  </div>
               </div>
            </div>         
         </div>
         <input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}"/>
         <input type = "hidden" name ="hdnpriorityValue" id ="hdnpriorityValue" value = "<%=priority%>"/>		 	
         <input type = "hidden" name ="hdnDosageType" id ="hdnDosageType" value = "<%=dosage_type%>"/>	
         <input type = "hidden" name ="hdnOriDosageType" id ="hdnOriDosageType" value = "<%=ori_dosage_type%>"/>		 
		 <input type = "hidden" name ="hdnbuildMarChecked" id ="hdnbuildMarChecked" value = "<%=buildMAR_checked%>"/>
		 <input type = "hidden" name ="hdnStrengthVal" id ="hdnStrengthVal" value = "<%=strength_value%>"/>
		 <input type = "hidden" name ="hdnStrengthUomDesc" id ="hdnStrengthUomDesc" value = "<%=strength_uom_desc%>"/>
		 <input type = "hidden" name ="hdnbuildMarEnable" id ="hdnbuildMarEnable" value = "<%=buildMAR_enable%>"/>
		 <input type = "hidden" name ="hdnTradeOptionEnable" id ="hdnTradeOptionEnable" value = "<%=trade_option_disable%>"/>
		 <input type="hidden" value="<%=form_code%>" name="form_code">
		<input type="hidden" value="<%=qty_desc_code%>" name="qty_desc_code">
		<input type="hidden" value="<%=pres_base_uom%>" name="pres_base_uom">
		<input type="hidden" value="<%=strength_uom%>" name="strength_uom">
		<input type="hidden" value="<%=strength_value%>" name="strength_value">
        <input type="hidden" value="<%=pres_base_uom_desc%>" name="pres_base_uom_desc">
        <input type="hidden" value="<%=billable_item_yn%>" name="billable_item_yn" id="billable_item_yn">	 
		<input type="hidden" value="<%=strength_uom_desc%>" name="strength_uom_desc">		
		<input type="hidden" value="<%=pres_base_uom_desc%>" name="pres_base_uom_desc">
		<input type="hidden" value="<%=dosage_type%>" name="dosage_type">	
		<input type = "hidden" name ="ext_prod_id" id ="ext_prod_id" value = "<%=ext_prod_id%>"/>
		 <input type = "hidden" name ="in_formulary_yn" id ="in_formulary_yn" value = "<%=in_formulary_yn%>"/>
		 <input type = "hidden" name ="patient_id" id ="patient_id" value = "<%=patient_id%>"/>
		 <input type = "hidden" name ="bl_install_yn" id ="bl_install_yn" value = "<%=bl_install_yn%>"/>
		 <input type = "hidden" name ="bl_disp_charge_dtl_in_rx_yn" id ="bl_disp_charge_dtl_in_rx_yn" value = "<%=bl_disp_charge_dtl_in_rx_yn%>"/>
		 <input type = "hidden" name ="drug_db_dosecheck_yn" id ="drug_db_dosecheck_yn" value = "<%=drug_db_dosecheck_yn%>"/>
		 <input type = "hidden" name ="drug_code" id ="drug_code" value = "<%=drug_code%>"/>
		 <input type = "hidden" name ="srl_no" id ="srl_no" value = "<%=drugIndex+1%>"/>
		 <input type = "hidden" name ="start_date" id ="start_date" value = "<%=start_date%>"/>
		<input type = "hidden" name ="generic_id" id ="generic_id" value = "<%=generic_id%>"/>
		<input type = "hidden" name ="freq_code" id ="freq_code" value = "<%=freq_code%>"/>
		<input type = "hidden" name ="freq_nature" id ="freq_nature" value = "<%=freq_nature%>"/>
		<input type = "hidden" name ="calc_def_dosage_yn" id ="calc_def_dosage_yn" value = "<%=calc_def_dosage_yn%>"/>
		<input type = "hidden" name ="repeat_value" id ="repeat_value" value = "<%=repeat_value%>" onchange="showBillingDetails()"/>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>" > 
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>"> 
		<input type="hidden" name="presBean_id" id="presBean_id" value="<%=presBean_id%>">
		<input type="hidden" name="presBean_name" id="presBean_name" value="<%=presBean_name%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" value="<%=qty_value%>" name="init_qty">
		<input type="hidden" value="<%=calling_mode%>" name="calling_mode">
		<input type="hidden" value="<%=tab_qty_value%>" name="tab_qty_value">
		<input type="hidden" value="<%=sliding_scale_yn%>" name="sliding_scale_yn">
		<input type="hidden" value="<%=rowVal%>" name="rowVal">
		<input type="hidden" value="<%=scheduled_yn%>" name="scheduled_yn">
		<input type="hidden" value="<%=repeat_durn_type%>" name="repeat_durn_type">
		<input type="hidden" value="<%=split_dose_yn_val%>" name="split_dose_yn_val">
		<input type="hidden" value="<%=dflt_qty_uom%>" name="dflt_qty_uom">
		<input type="hidden" value="<%=def_freq_found%>" name="def_freq_found"/>
		<input type="hidden" value="<%=allow_duplicate%>" name="allow_duplicate">	
		<input type="hidden" value="<%=drug_db_interface_yn%>" name="drug_db_interface_yn">
		<input type="hidden" value="<%=drug_db_duptherapy_yn%>" name="drug_db_duptherapy_yn">
		<input type="hidden" value="<%=max_durn_for_refill_pres%>" name="max_durn_for_refill_pres">		
		<input type="hidden" value="<%=no_refill%>" name="no_refill">
		<input type="hidden" value="<%=order_set_code%>" name="order_set_code">
		<input type="hidden" value="" name="freq_value" id="freq_value">
		<input type="hidden" value="<%=interval_value%>" name="interval_value" onchange="showBillingDetails();">
		<input type="hidden" value="<%=act_patient_class%>" name="act_patient_class">
		<input type="hidden" value="<%=current_rx%>" name="current_rx">
		<input type="hidden" value="<%=fract_dose_appl_yn%>" name="fract_dose_appl_yn">
		<input type="hidden" value="<%=admin_time%>" name="admin_time">
		<input type="hidden" value="<%=admin_qty%>" name="admin_qty">
		<input type="hidden" value="<%=dsg_reason%>" name="dsg_reason"> 
		<input type="hidden" value="<%=dup_reason%>" name="dup_reason"> 
		<input type="hidden" value="<%=con_reason%>" name="con_reason"> 
		<input type="hidden" value="<%=int_reason%>" name="int_reason"> 
		<input type="hidden" value="<%=alg_reason%>" name="alg_reason">
		<input type="hidden" value="<%=qty_reqd_yn%>" name="qty_reqd_yn">
		<input type="hidden" value="<%=rx_qty_by_pres_base_uom_yn%>" name="rx_qty_by_pres_base_uom_yn">
		<input type="hidden" value="<%=split_dose_yn%>" name="split_dose_yn">
		<input type="hidden" name="taper_disable" id="taper_disable" value="<%=taper_disable%>">
		<input type="hidden" value="<%=sch_over_yn%>" name="sch_over_yn">
		<input type="hidden" value="<%=refill_yn%>" name="refill_yn">
		<input type="hidden" value="<%=refill_yn_from_param%>" name="refill_yn_from_param">
		<input type="hidden" value="<%=refill_cont_order_yn%>" name="refill_cont_order_yn">
		<input type="hidden" value="<%=refill_start_date%>" name="refill_start_date">
		<input type="hidden" value="<%=refill_end_date%>" name="refill_end_date">
		<input type="hidden" value="" name="in_durn_desc" id="in_durn_desc">
		<input type="hidden" value="" name="in_durn_value" id="in_durn_value">
		<input type="hidden" name="limit_ind" id="limit_ind" value="<%=limit_ind%>">
		<input type="hidden" name="external_patient_id" id="external_patient_id" value="<%=bean.getExternalpatient_id()==null?"":bean.getExternalpatient_id()%>">
		<input type="hidden" name="max_durn_for_dm_pres" id="max_durn_for_dm_pres" value="<%=max_durn_for_dm_pres%>">
		<input type="hidden" name="chk_for_dm_max_durn_action" id="chk_for_dm_max_durn_action" value="<%=chk_for_dm_max_durn_action%>">
		<input type="hidden" name="max_durn_for_ip_pres" id="max_durn_for_ip_pres" value="<%=max_durn_for_ip_pres%>">
		<input type="hidden" name="chk_for_ip_max_durn_action" id="chk_for_ip_max_durn_action" value="<%=chk_for_ip_max_durn_action%>">
		<input type="hidden" name="max_durn_for_op_pres" id="max_durn_for_op_pres" value="<%=max_durn_for_op_pres%>">
		<input type="hidden" name="chk_for_op_max_durn_action" id="chk_for_op_max_durn_action" value="<%=chk_for_op_max_durn_action%>">
		<input type="hidden" value="<%=max_durn_value%>" name="max_durn_value">
		<input type="hidden" value="<%=chk_for_max_durn_action%>" name="chk_for_max_durn_action">
		<input type="hidden" value="<%=force_auth_yn%>" name="force_auth_yn">
		<input type="hidden" name="sys_date" id="sys_date" value="<%=sys_date%>">
		<input type="hidden" name="interaction_exists" id="interaction_exists" value="<%=interaction_exists%>">
		<input type="hidden" name="amend_yn" id="amend_yn" value="<%=amend_yn%>">
		<input type="hidden" value="<%=dup_found%>" name="dup_found">
		<input type="hidden" value="<%=ord_authorized_prev_yn%>" name="ord_authorized_prev_yn">
		<input type="hidden" value="<%=ord_auth_reqd_yn%>" name="ord_auth_reqd_yn">
		<input type="hidden" value="<%=ord_authorized_yn%>" name="authroize_yn_val">
		<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
		<input type='hidden' name='bl_incl_excl_override_reason_code' id='bl_incl_excl_override_reason_code' value='<%=bl_incl_excl_override_reason_code%>'>
		<input type='hidden' name='bl_incl_excl_override_reason_desc' id='bl_incl_excl_override_reason_desc' value='<%=bl_incl_excl_override_reason_desc%>'>
		<input type='hidden' name='bl_def_override_excl_incl_ind' id='bl_def_override_excl_incl_ind' value='<%=bl_def_override_excl_incl_ind%>'>
		<input type='hidden' name='bl_override_excl_incl_ind' id='bl_override_excl_incl_ind' value='<%=bl_override_excl_incl_ind%>'>
		<input type='hidden' name='bl_override_allowed_yn' id='bl_override_allowed_yn' value='<%=bl_override_allowed_yn%>'>
		<input type="hidden" value="<%=preg_remarks%>" name="preg_remarks" >
		<input type="hidden" value="<%=ph_version%>" name="ph_version">
		<input type="hidden" value="<%=consider_stock_for_pres_yn%>" name="consider_stock_for_pres_yn">
		<input type="hidden" value="<%=dose_override%>" name="dose_override">
		<input type="hidden" value="<%=strength_per_pres_uom%>" name="strength_per_pres_uom">
		<input type="hidden" value="<%=strength_per_value_pres_uom%>" name="strength_per_value_pres_uom">
		<input type="hidden" value="" name="conv_factor" id="conv_factor">
		<input type="hidden" value="<%=allergy_yn%>" name="allergy_yn">
		<input type="hidden" value="<%=brought_by_pat%>" name="brought_by_pat" onchange="showBillingDetails();">
		<input type="hidden" value="<%=take_home%>" name="take_home">
		<input type="hidden" value="<%=check_pat_con%>" name="pat_counseling_reqd">
		<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
		<input type="hidden" value="<%=stock_uom%>" name="stock_uom">
		<input type="hidden" value="<%=mono_graph%>" name="mono_graph">
		<input type="hidden" value="<%=unit_dose%>" name="unit_dose">
		<input type="hidden" value="<%=daily_dose%>" name="daily_dose">
		<input type="hidden" value="<%=generic_name%>" name="generic_name">
		<INPUT TYPE="hidden" name="recomm_dosage_by" id="recomm_dosage_by" VALUE="<%= recomm_dosage_by %>">
		<INPUT TYPE="hidden" name="take_medication_yn_val" id="take_medication_yn_val" VALUE="<%= take_medication_yn_val %>">
		<INPUT TYPE="hidden" name="freq_chng_durn_desc" id="freq_chng_durn_desc" VALUE="<%= freq_chng_durn_desc %>">
		<INPUT TYPE="hidden" name="durn_value" id="durn_value" VALUE="<%= durn_value %>">		
		<input type="hidden" value="" name="calcualted_durn_value" id="calcualted_durn_value">		
		<input type="hidden" value="<%=man_rem_on_prn_freq_yn%>" name="man_rem_on_prn_freq_yn">		
		<input type="hidden" value="<%=calling_mode%>" name="source">
		<input type="hidden" value="<%=back_date%>" name="back_date">
		<input type="hidden" value="<%=future_date%>" name="future_date">
		<input type="hidden" name="pregnency_yn" id="pregnency_yn" value="<%=pregnency_yn%>">		
		<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
		<input type="hidden" value="<%=absol_qty %>" name="absol_qty" />
		<input type="hidden" value="<%=patient_class%>" name="patient_class"/>
		<input type="hidden" value="<%=facility_id%>" name="facility_id"/>
		<input type="hidden" value="<%=encounter_id%>" name="encounter_id"/>
		<input type="hidden" value="<%=resp_id%>" name="resp_id"/>
		<input type="hidden" value="<%=pract_id%>" name="pract_id"/>
		<input type="hidden" value="<%=location_code%>" name="location_code"/>
		<input type="hidden" value="<%=order_type_code%>" name="order_type_code"/>
		<input type="hidden" value="<%=drug_class%>" name="drug_class"/>
		<input type="hidden" value="<%=sch_over_yn%>" name="sch_over_yn"/>
		<input type="hidden" value="<%=refill_cont_order_yn%>" name="refill_cont_order_yn"/>
		<input type="hidden" value="<%=split_dose%>" name="split_dose"/>
		
		<div class="CSTransactionMessage" id="transactionMsg1" style="background-color:#bd362f;bottom: 45px; left: 10px; display: none;z-index:900002;">
			<img style="padding-left:15px;vertical-align:middle;" src="${path}/eIPAD/images/PopError.png" onclick="closeToast()"/>
			<span class="rxToastmsg" id="contentRxToastMsg1">No records found</span>
            <div class="formValErrorMsgTheme" id="transactionMessageContent1"></div>
        </div>
		
		<div id="confirmMsg" class="absoluteCenter" style="z-index: 10005;">
			<div class="Error_Window">
				<div class="Error_msg_box">
				<div class="Error_msg">
					<div class="Error_msg_Frame">
						<div>
							<div class="Error_icon"><img src="${path}/eIPAD/images/OrderPopConfirm.png" width="30" height="30"> </div>
							<div class="Error_cont" id="ClinicalNotesConfirmDialogMsg">Are you sure you wish to cancel the current operation?</div>
						</div>
					</div>
				</div>
				</div>
			<div class="Error_msg_btn">
				<div class="Error_btn_div_con" id="okClick" onclick="okClickDialog()">OK </div>
				<div class="Error_btn_div"> </div>
				<div class="Error_btn_div_con" id="cancelClick" onclick="cancelClickDialog()" data-value="true">Cancel </div>
			</div>
			<div class="top_shadow"> </div>
			</div>
		</div>
			<script>
<%			
			if(!amend_yn.equals("Y") && orig_current_rx.equals("Y") && allow_duplicate.equals("N") ) {	
%>
					duplicateWarning();
<%
				}
				else if(!amend_yn.equals("Y") && !statFeqFound && priority.equals("U")){
					out.println("showToastMsg('Applicable frequency for Urgent priority not defined for the drug');");
					out.println("$('#rxPriority').data('kendoDropDownList').value('Routine');");
				}
				else if(!def_freq_found &&  !amend_yn.equals("Y")){
%>
					showToastMsg("Default frequency is not found in the applicable frequencies list");
					freqChange(document.rxDetailsViewForm.frequencyDpList,'<%=sliding_scale_yn%>'); 
<%
				}
			
				if((orig_current_rx.equals("Y")||(drug_db_duptherapy_flag.equals("Y"))) && allow_duplicate.equals("N")) {	 // && (patient_class.equals("IP") || take_home>0)
%>
					freqChange(document.rxDetailsViewForm.frequencyDpList,'N', 'N', 'ChangeFreq');
					var PriorityDPList = $("#rxPriority").data("kendoDropDownList");
					$('#rxPriority').css("opacity","0.3");
					PriorityDPList.enable(false);				
<%
				}
				else if(copied_drug_yn.equals("N") && !amend_yn.equals("Y")){		
%>
						freqChange(document.rxDetailsViewForm.frequencyDpList,'N','N','ChangeFreq');
<%
				}
				else if(copied_drug_yn.equals("Y") && !amend_yn.equals("Y")){
%>
					//validateAllDates(); 
					durationConversn(document.rxDetailsViewForm.durationDpList);
<%
				}
%>
		</script>
      </form>
   </div>

