<!DOCTYPE html>
 <!--saved on 27th Oct 2005 --> 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%-- Mandatory declarations end --%>
<%
/*

--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
02/07/2017	  	IN061197	     	Mukesh M 	07/02/2017				manickyam						AAKH-CRF-0091 [IN061197] 
26/07/2019      IN070451		    B Haribabu  26/07/2019       Manickam               ML-MMOH-CRF-1408
07/08/2019      IN:071108		    B Haribabu                                          ML-MMOH-CRF-1408
15/07/2020     IN073431		    	    Manickavasagam J                                    MMS-KH-SCF-0080
24/08/2020      IN073769		   B Haribabu                                           PHIS-PH-Alpha - Exceed Dosage Limit Icon not opening in CA place order
05/01/2021	 TFS id:7345           Haribabu	      05/01/2021       Manickavasagam J			     MMS-DM-CRF-0177
13/05/2021  	TFS id:-16701	     Manickavasagam J                                    RBU-GHL-CRF-0004
22-05-2022                           prathyusha                                         AAKH-CRF-0140
--------------------------------------------------------------------------------------------------------------
*/

	HttpSession xx = request.getSession(false);
	Properties jdbc_props = (Properties)xx.getValue("jdbc");
	String classValue		= ""; 
	String prev_order_code	= "";
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String bed_num			= request.getParameter("bed_num")==null?"":request.getParameter("bed_num");
	String room_num			= request.getParameter("room_num")==null?"":request.getParameter("room_num");
	String weight			= request.getParameter("weight")==null?"0":request.getParameter("weight");
	String bsa				= request.getParameter("bsa")==null?"0":request.getParameter("bsa");
	String patient_class	= request.getParameter("patient_class");
	String drug_code_sliding = request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String srl_no_sliding   = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String facility_id		= (String)session.getValue("facility_id");
	String bl_install_yn	= request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String adr_count	    = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
	String drug_db_interface_yn	        = request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	String drug_db_allergy_check_yn	    = request.getParameter("drug_db_allergy_check_yn")==null?"":request.getParameter("drug_db_allergy_check_yn");
	String drug_db_duptherapy_yn	    = request.getParameter("drug_db_duptherapy_yn")==null?"":request.getParameter("drug_db_duptherapy_yn");
	String bl_disp_charge_dtl_in_rx_yn  = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");
	String conf_drug_code	    = request.getParameter("conf_drug_code")==null?"":request.getParameter("conf_drug_code");
	String conf_srl_no  = request.getParameter("conf_srl_no")==null?"":request.getParameter("conf_srl_no");
	String alternateDisable = "";//added for  JD-CRF-0198 [IN:058599]
	
	//String mode				= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	
	String bean_id			= "@PrescriptionBean_1"+patient_id+encounter_id;	
	String bean_name		= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean	= (PrescriptionBean_1)getBeanObject(bean_id,bean_name,request);
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

	bean.setCalExtDBYN("Y");//Added for TFS id:-16701
	ArrayList	presDetails	=(ArrayList) bean.getpresDetails();
	String sch_bean_id		= "OrScheduleFreq" ;
	String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
	String order_set_code	= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
	if(bean.getAmend_alternate_yn().equals("Y"))//added for  JD-CRF-0198 [IN:058599]
		 alternateDisable = "disabled";
%>
<html>
	<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		bean.setLanguageId(locale);
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/Prescription_1.js"></script>
		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
try{
  	String grp_order_type_code	=	null;
	ArrayList displayList		=	null;
	HashMap drugDetails			=	null; 
	String order_type_code		=	null;
	String drug_code			=	null; 
	String srl_no				=	null; 
	String drug_desc			=	null; 
	String drug_name_1			=   "";
	String generic_id			=	null; 
	String generic_name			=	null; 
	String taper_yn				=	null; 
	String allergy_yn			=	null; 
	String qty_value			=	null; 
	String qty_desc				=	null; 
	String qty_desc_code		=	null; 
	String or_qty_desc			=	null; 
	String freq_desc			=	null; 
	String durn_value			=	null; 
	String or_durn_desc			=	null; 
	String freq_chng_durn_desc  =   null;
	String limit_ind			=	null; 
	String mono_graph			=	null; 
	String daily_dose			=	null; 
	String unit_dose			=	null; 
	String min_daily_dose		=	null; 
	String min_unit_dose		=	null; 
	String dosage_std			=	null;
	String freq_nature			=	null;
	String current_rx			=	null;
	String allergy_override		=	null; 
	String dose_override		=	null; 
	String currentrx_override	=	null; 
	String sch_over_yn			=	null; 
	String ext_prod_id			=	null;
	String start_date			=	null;
	String end_date				=	null;
	String provide_taper		=	"";	
	String no_refill			=	null;
	String stock_available_yn	=	null;
	String available_stock		=	null;
	String allow_pres_without_stock_yn = null;
	String scheduled_yn			=	null;
	String order_type_desc		=	null;
	String amend_yn				=	null;
	String rowVal				=	null;
	String split_dose_yn		=	null;
	String dosage_type			=	null;
	String tmp_srl_no			=	null;
	String tmp_drug_code		=	null;
	String freq_code			=	null;
	Hashtable schedule_val		=	null;
	Hashtable sch_output		=	null;
	String dosage_unit			=	"";
	String dose_unit_desc       =   ""; // Added for ML-MMOH-SCF-0633 [IN:063271]
	String stock_uom			=	"";
	String repeat_value			=   "";
	//code added for recommended dosage...on 4/5/2004
	boolean recomm_yn_flag		=	false;
	String recomm_yn			=	"";
	String taper_up				=	"";
	String sliding_scale_yn		=   "";
	String form_code			=	"";	
	String uom_code				=	"";
	String uom_desc				=	"";
	String dflt_yn				=	"";
	ArrayList prescriptionDetails = null;
	HashMap ext_drugData		  =	null;
	String ext_drug_code	=	null;
	String ext_srl_no		=	null;
	int drug_index          =   0;
	int codeCount_1		    =   0;
	int codeCount_2		    =   0;
	String deft_mode           =   "modify";
	String temp_freq_nature    =   "";
	String drug_db_dosage_check_flag    = "";
	String drug_db_duptherapy_flag		= "";
	String drug_db_contraind_check_flag	= "";
	String drug_db_interact_check_flag	= "";
	String drug_db_allergy_flag			= "";
	String ext_checks					= "";
	String ext_checks_overrided			= "";
	//String ext_override_reason="";
	String dsg_reason					= "";	
	String dup_reason		="";	
	String con_reason="";
	String int_reason="";
	String alg_reason="";
	String weight_rec_appl_age_group_check_flag = "";
	String wt_mand_yn="", ht_mand_yn=""; //added for Bru-HIMS-CRF-079 IN[029945]
	int drug_adr_count = 0;
	String adr_gif="";
	String copied_drug_yn="";
	String drug_class="";
	String current_rx_tapered="";
	String tmp_sliding_scale_yn="N";
    String duplicate_check_at_atc_yn=""; //added for skr-scf-0143 IN 29184
    String interaction_exists="", drugIntraction_override="", drugIntraction_override_gif="";
    	String abuse_exists="",abuse_action=""; //added for aakh-crf-0140
//	String new_srl_no = request.getParameter("new_srl_no")==null?"":request.getParameter("new_srl_no");
	String repeat_durn_type="";//Added for RUT-CRF-0088 [IN036978]
	String conv_factor="";//Added for RUT-CRF-0088 [IN036978]
	String order_qty = "";//Added for RUT-CRF-0088 [IN036978]
	String freq_chng_durn_value= "";//Added for RUT-CRF-0088 [IN036978]
	String pres_base_uom="";//Added for RUT-CRF-0088 [IN036978]
	String datechanged_yn="";//Added for ML-BRU-SCF-1423 [IN:050857]
	String stat_yn = ""; //Added forAAKH-CRF-0091	
	String parent_stat_yn =""; //Added forAAKH-CRF-0091
	String route_code	  = "";//AAKH-SCF-0340
	//Added for IN:070451 start
	String      max_daily_ceeling_dose	    =   "";
	String		min_daily_ceeling_dose	    =   "";
	String		max_unit_ceeling_dose	    =   "";
	String		min_unit_ceeling_dose	    =   "";
	//Added for IN:070451 end
	String dose_unit_desc1       =   "";//Added for IN:071108
	String		pre_alloc_appl_yn =bean.getPreAllocApplYN();//Added for TFS id:7345
	String		drug_desc_new					=	"";//Added for TFS id:7345
	String		drug_search_by					=	"";//Added for TFS id:7345
	String abuse_override="N";//added for aakh-crf-0140
%>
	<form name="prescription_form" id="prescription_form" >
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="bed_num" id="bed_num" value="<%=bed_num%>">
		<input type="hidden" name="room_num" id="room_num" value="<%=room_num%>">
		<input type="hidden" name="weight" id="weight" value="<%=weight%>">
		<input type="hidden" name="bsa" id="bsa" value="<%=bsa%>">
		<input type="hidden" name="sliding_scale_yn" id="sliding_scale_yn" value="<%=sliding_scale_yn%>">
		<input type="hidden" value="<%=bean_id%>" name="bean_id" id="bean_id">
		<input type="hidden" value="<%= bean_name %>" name="bean_name" id="bean_name">
		<input type="hidden" value="<%= deft_mode %>" name="mode" id="mode">
		<input type="hidden" value="<%=presBean_id%>" name="presBean_id" id="presBean_id">
		<input type="hidden" value="<%=presBean_name %>" name="presBean_name" id="presBean_name">
<%
	if(presDetails!=null && presDetails.size()>0){
		String curr_code = (String)(((HashMap) presDetails.get(presDetails.size()-1)).get("DRUG_CODE"));
		classValue="SELECTEDRUGS";
%>
		<table border="1" width="100%" cellspacing="0" cellpadding="0" id="Selected_drugs">
<%
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
		//String temp_drug_code1="";
		//String tappered_over="";
		ArrayList atc_dup_drug_code= null;
		ArrayList atc_values =  new ArrayList();
		HashMap drug_detail	 =	null;
		String patient_stock_yn = "N";//added for ghl-crf-0482

		for(int i=0;i<presDetails.size();i++){
			current_rx_tapered = "";
			drug_detail=(HashMap) presDetails.get(i);
			duplicate_check_at_atc_yn       = (String) drug_detail.get("DUPLICATE_CHECK_AT_ATC_YN");   //added for skr-scf-0143 IN 29184
			if(!drug_code_sliding.equals("") && drug_code_sliding.equals((String)drug_detail.get("DRUG_CODE")) && srl_no_sliding.equals((String)drug_detail.get("SRL_NO"))){
				drug_detail.put("BL_DEF_OVERRIDE_EXCL_INCL_IND","");
				drug_detail.put("BL_OVERRIDE_EXCL_INCL_IND","");

				drug_detail.put("BL_TOTAL_CHARGE_AMT","");   //added on 15dec-09
				drug_detail.put("BL_PATIENT_PAYABLE_AMT",""); //added on 15dec-09
				drug_detail.put("BL_DECIMAL_FORMAT_STRING",bean.getBLDecimalFormatString()); // priya --added for IN19010 --24/02/2010
				//tmp_sliding_scale_yn =drugDetails.get("SLIDING_SCALE_YN")==null?"":(String)drugDetails.get("SLIDING_SCALE_YN") ; //hanga
			}
			ext_prod_id			= (String)drug_detail.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drug_detail.get("EXTERNAL_PRODUCT_ID");
			drug_db_duptherapy_flag		=  (String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drug_detail.get("DRUG_DB_DUPTHERAPY_FLAG");
			copied_drug_yn		=  (String)drug_detail.get("COPIED_DRUG_YN")==null?"":(String)drug_detail.get("COPIED_DRUG_YN");
			current_rx_tapered = drug_detail.get("CURRENT_RX")==null?"":(String)drug_detail.get("CURRENT_RX");// moved out from the below if condition for MO-GN-5490 [IN:054620] - [IN:055921] -start
			amend_yn			= drug_detail.get("AMEND_YN")==null?"":(String)drug_detail.get("AMEND_YN");
			if( current_rx_tapered.equals("Y") && !drug_detail.containsKey("ORIG_CURRENT_RX")) {
				drug_detail.put("ORIG_CURRENT_RX","Y");							
			}
			else if( !current_rx_tapered.equals("Y") && !amend_yn.equals("Y")){ //else if block added for Bru-HIMS-CRF-265 [IN:032315] // && !amend_yn.equals("Y") added for [IN:044495]
				drug_detail.put("ORIG_CURRENT_RX","N");		
			}// moved out from below if condition for MO-GN-5490 [IN:054620] - [IN:055921] -end
			//	if((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))){
			//if(!drug_db_duptherapy_yn.equals("Y") ) { //commented this if codition for the incident no : 27465 
			if(duplicate_check_at_atc_yn!=null && duplicate_check_at_atc_yn.equals("Y") ){ //if condition added for skr-scf-0143 IN 29184
				atc_level_1	=	(String)drug_detail.get("ATC_CLASS_LEV1_CODE");
				atc_level_2	=	(String)drug_detail.get("ATC_CLASS_LEV2_CODE");
				atc_level_3	=	(String)drug_detail.get("ATC_CLASS_LEV3_CODE");
				atc_level_4	    =	(String)drug_detail.get("ATC_CLASS_LEV4_CODE");
				atc_level_5	    =	(String)drug_detail.get("ATC_CLASS_LEV5_CODE");
				drug_desc	=	(String)drug_detail.get("DRUG_DESC");
				drug_desc_new				= (String) drug_detail.get("DRUG_DESC_NEW")==null?"":(String) drug_detail.get("DRUG_DESC_NEW");
				drug_search_by				= (String) drug_detail.get("DRUG_SEARCH_BY")==null?"":(String) drug_detail.get("DRUG_SEARCH_BY");
				drug_name_1=drug_desc;
				drug_name_1=drug_name_1.replaceAll(" ","%20");
				drug_name_1=java.net.URLEncoder.encode(drug_name_1,"UTF-8");
				drug_name_1=drug_name_1.replaceAll("%2520","%20");

				temp_generic_id	=	(String)drug_detail.get("GENERIC_ID");
				temp_drug_code = (String)drug_detail.get("DRUG_CODE");
				provide_taper	=	"";

				if(drug_detail.get("TAPPERED_OVER")!=null)
					provide_taper	= (String)drug_detail.get("TAPPERED_OVER");			
				if( (!provide_taper.equals("Y")) && (drug_detail.get("ALERT_YN")==null && (drug_detail.get("CURRENTRX_REMARKS")==null || ((String)drug_detail.get("CURRENTRX_REMARKS")).equals("")))) {
					atc_dup_drug_code = new ArrayList();
					atc_dup_drug_code = (ArrayList)drug_detail.get("ATC_DUP_DRUG_CODE");
					if(atc_dup_drug_code == null)
						atc_dup_drug_code = new ArrayList();
					if(!atc_values.contains(temp_drug_code)){ // ie. only while tapering, same drug will be allowed, and if its tapering need not chk for duplicate
						if(atc_values.contains(temp_generic_id)){
							drug_detail.put("CURRENT_RX","Y");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
							drug_detail.put("ALERT_YN","Generic :");

						}
						else if(atc_values.contains(atc_level_4)){    // added else if condition for the incedent no : 27465 
							drug_detail.put("CURRENT_RX","Y");
							drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
							drug_detail.put("ALERT_YN","Level 4:");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);// added for the incedent no : 27465 
						}
						// commented below  coditions for the incident no : 27465
						/*else if(atc_values.contains(atc_level_1)){ 
							drug_detail.put("CURRENT_RX","Y");
							drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
							drug_detail.put("ALERT_YN","Level 1:");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
						}
						else  if(atc_values.contains(atc_level_2)){
							drug_detail.put("CURRENT_RX","Y");
							drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
							drug_detail.put("ALERT_YN","Level 2:");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
						}
						else if(atc_values.contains(atc_level_3)){
							drug_detail.put("CURRENT_RX","Y");
							drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
							drug_detail.put("ALERT_YN","Level 3:");
						} */
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
					//if condition added for SKR-SCF-1597
					if(atc_values.contains(atc_level_4) && atc_values.contains(temp_drug_code)){
							drug_detail.put("CURRENT_RX","Y");
							drug_detail.put("ATC_LEVEL_DUPLICATION","Y");
							drug_detail.put("ALERT_YN","Level 4:");
							atc_dup_drug_code.add(temp_drug_code);
							drug_detail.put("ATC_DUP_DRUG_CODE",atc_dup_drug_code);
					}else
						drug_detail.put("CURRENT_RX","N");
						//drug_detail.put("TAPPERED_OVER","Y"); //Commented for 30030
					}
				}else{ //SKR-SCF-1482 - start
					if(current_rx_tapered.equals("Y")){
						atc_values.add(drug_desc);
						atc_values.add(temp_drug_code);
						atc_values.add(temp_generic_id);
						if(!(atc_level_1==null || atc_level_1.equals("")))
							atc_values.add(atc_level_1);
						if(!(atc_level_2==null || atc_level_2.equals("")))
							atc_values.add(atc_level_2);
						if(!(atc_level_3==null || atc_level_3.equals("")))
							atc_values.add(atc_level_3);
						if(!(atc_level_4==null || atc_level_4.equals(""))){ 
							atc_values.add(atc_level_4);
						}
						if(!(atc_level_5==null || atc_level_5.equals(""))){ 										
							atc_values.add(atc_level_5);
						}
					}
				//SKR-SCF-1482 - end	
				
				}
			} //end if duplicate_check_at_atc_yn 
			//}
/*ext check starts
			ArrayList exProd				= new ArrayList();
			ArrayList drugDesc				= new ArrayList();
			for(int i=0;i<prescriptionDetails.size();i++){
				drug_detail				=(HashMap) prescriptionDetails.get(i);
				ext_db_drug_code				=(String) drug_detail.get("EXTERNAL_PRODUCT_ID");
				ext_drug_code	= (String) drug_detail.get("DRUG_CODE");
				ext_srl_no				=(String) drug_detail.get("SRL_NO");

				if(!exProd.contains(ext_db_drug_code)){
					drugDesc.add((String)drug_detail.get("DRUG_DESC"));
					if(!ext_db_drug_code.equals("")){
					   exProd.add((String)drug_detail.get("EXTERNAL_PRODUCT_ID"));
					}
				}
				if( drugCode.equals(ext_drug_code) && (String.valueOf(srl_no)).equals(ext_srl_no) ){
					drug_detail.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
				}
			}

			if(exProd.size()>0)
				ext_beanObj.storeDrugIds(patient_id,"",exProd,drugDesc);//Store Drug ids

			if(drug_db_allergy_check_yn.equals("Y")){
				ArrayList ex_prod_ids =new ArrayList();
				ex_prod_ids.add(ext_prod_id);

				ext_beanObj.DrugAlergyCheck(ex_prod_ids,patient_id);//get drug alergy result
				HashMap drug_alergies =(HashMap)ext_beanObj.getDrugAlergies();

				if(drug_alergies.containsKey(ext_prod_id)){
					drug_db_allergy_flag="Y";
				}	
			}ext check ends*/
		}
		for(int k=0;k<ordergrp.size();k++){
			grp_order_type_code	=(String) ordergrp.get(k);
			if(grp_order_type_code == null)
				grp_order_type_code="";
			for(int i=0;i<grp.size();i++){
				displayList=(ArrayList) bean.getDisplayList((String)grp.get(i));
				for(int j=0;j<displayList.size();j++){
					drugDetails = new HashMap();
					drugDetails=(HashMap) displayList.get(j);
					order_type_code	= (String)drugDetails.get("ORDER_TYPE_CODE")==null?"":(String)drugDetails.get("ORDER_TYPE_CODE");
					recomm_yn_flag = false;
					if(grp_order_type_code.equals(order_type_code)){
						sliding_scale_yn	= drugDetails.get("SLIDING_SCALE_YN")==null?"":(String)drugDetails.get("SLIDING_SCALE_YN") ; 
						
						drug_code			= drugDetails.get("DRUG_CODE")==null?"":(String)drugDetails.get("DRUG_CODE");
						srl_no				= drugDetails.get("SRL_NO")==null?"":(String)drugDetails.get("SRL_NO");
						drug_desc			= drugDetails.get("DRUG_DESC")==null?"":(String)drugDetails.get("DRUG_DESC");
						drug_desc_new				= (String) drugDetails.get("DRUG_DESC_NEW")==null?"":(String) drugDetails.get("DRUG_DESC_NEW");//Added for TFS id:7345
						drug_search_by				= (String) drugDetails.get("DRUG_SEARCH_BY")==null?"":(String) drugDetails.get("DRUG_SEARCH_BY");//Added for TFS id:7345
						drug_name_1=drug_desc;
						drug_name_1=drug_name_1.replaceAll(" ","%20");
						drug_name_1=java.net.URLEncoder.encode(drug_name_1,"UTF-8");
						drug_name_1=drug_name_1.replaceAll("%2520","%20");
						generic_id			= drugDetails.get("GENERIC_ID")==null?"":(String)drugDetails.get("GENERIC_ID");
						generic_name		= drugDetails.get("GENERIC_NAME")==null?"":(String)drugDetails.get("GENERIC_NAME");
						taper_yn			= drugDetails.get("TAPER_DOSE_YN")==null?"":(String)drugDetails.get("TAPER_DOSE_YN");
						allergy_yn			= drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN");
						qty_value			= drugDetails.get("QTY_VALUE")==null?"":(String)drugDetails.get("QTY_VALUE");
						qty_desc			= drugDetails.get("QTY_DESC")==null?"":(String)drugDetails.get("QTY_DESC");
						qty_desc_code		= drugDetails.get("QTY_DESC_CODE")==null?"":(String)drugDetails.get("QTY_DESC_CODE");
						or_qty_desc			= drugDetails.get("OR_QTY_DESC")==null?"":(String)drugDetails.get("OR_QTY_DESC");
						freq_code			= drugDetails.get("FREQ_CODE")==null?"":(String)drugDetails.get("FREQ_CODE");
						freq_desc			= drugDetails.get("FREQ_DESC")==null?"":(String)drugDetails.get("FREQ_DESC");
						pres_base_uom		= (String) drugDetails.get("PRES_BASE_UOM");   //Added for RUT-CRF-0088 [IN036978]
						stat_yn			= (String)drugDetails.get("stat_yn")==null?"":(String)drugDetails.get("stat_yn");  //Added for AAKH-CRF-0091
					//	freq_desc = java.net.URLEncoder.encode(freq_desc,"UTF-8");
					/*	freq_desc			= freq_desc.replaceAll("%26","&");
						freq_desc			= freq_desc.replaceAll("%40","@");
						freq_desc			= freq_desc.replaceAll("%20"," "); */
			
						durn_value			= drugDetails.get("DURN_VALUE")==null?"":(String)drugDetails.get("DURN_VALUE");
						repeat_value		= drugDetails.get("REPEAT_VALUE")==null?"":(String)drugDetails.get("REPEAT_VALUE");
						or_durn_desc		= drugDetails.get("OR_DURN_DESC")==null?"":(String)drugDetails.get("OR_DURN_DESC");
						freq_chng_durn_desc = drugDetails.get("freq_chng_durn_desc")==null?"":(String)drugDetails.get("freq_chng_durn_desc");
						
						//Added for SRR20056-SCF7552 - Start
						if(freq_chng_durn_desc == null || freq_chng_durn_desc.equals(""))
							freq_chng_durn_desc= drugDetails.get("DURN_TYPE")==null?"":(String)drugDetails.get("DURN_TYPE") ;
						//Added for SRR20056-SCF7552 - End
						or_durn_desc		= presBean.getDurationType(freq_chng_durn_desc);
						limit_ind			= drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
						mono_graph			= drugDetails.get("MONO_GRAPH")==null?"":(String)drugDetails.get("MONO_GRAPH");
						daily_dose			= drugDetails.get("DAILY_DOSE")==null?"":(String)drugDetails.get("DAILY_DOSE");
						unit_dose			= drugDetails.get("UNIT_DOSE")==null?"":(String)drugDetails.get("UNIT_DOSE");
						min_daily_dose		= drugDetails.get("MIN_DAILY_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_DOSE");
						min_unit_dose		= drugDetails.get("MIN_UNIT_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_DOSE");
						dosage_std			= drugDetails.get("DOSAGE_STD")==null?"":(String)drugDetails.get("DOSAGE_STD");;
						freq_nature			= drugDetails.get("FREQ_NATURE")==null?"":(String)drugDetails.get("FREQ_NATURE");
						current_rx			= drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");	
						allergy_override	= drugDetails.get("ALLERGY_OVERRIDE")==null?"":(String)drugDetails.get("ALLERGY_OVERRIDE");
						dose_override		= drugDetails.get("DOSE_OVERRIDE")==null?"":(String)drugDetails.get("DOSE_OVERRIDE");
						currentrx_override	= drugDetails.get("CURRENTRX_OVERRIDE")==null?"":(String)drugDetails.get("CURRENTRX_OVERRIDE");
						amend_yn			= drugDetails.get("AMEND_YN")==null?"":(String)drugDetails.get("AMEND_YN");
						sch_over_yn			= drugDetails.get("SCH_OVER_YN")==null?"":(String)drugDetails.get("SCH_OVER_YN");
						ext_prod_id			= drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"": (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
						start_date			= drugDetails.get("START_DATE")==null?"":(String)drugDetails.get("START_DATE");
						end_date			= drugDetails.get("END_DATE")==null?"":(String)drugDetails.get("END_DATE");
						patient_stock_yn	= drugDetails.get("patient_stock_yn")==null?"N":(String)drugDetails.get("patient_stock_yn");//added for ghl-crf-0482
						current_rx_tapered = drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");//Added for ARYU-SCF-0138
						//Added for IN:070451 start
						abuse_override=drugDetails.get("ABUSE_OVERRIDE")==null?"":(String)drugDetails.get("ABUSE_OVERRIDE");//added for aakh-crf-0140
						max_daily_ceeling_dose		= drugDetails.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
						min_daily_ceeling_dose		= drugDetails.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
						max_unit_ceeling_dose		= drugDetails.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
						min_unit_ceeling_dose		= drugDetails.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
						//Added for IN:070451 end
						if(stat_yn.equals("Y")){ //added for AAKH-SCF-0340 
							if(start_date!=null && !start_date.equals("")){ // && end_date!=null && end_date.equals("") removed for MMS-MD-SCF-0092 
								end_date = bean.populateEndDate("",start_date,"1","D");
								drugDetails.put("END_DATE",end_date);
							}
						}

						stock_uom			= drugDetails.get("STOCK_UOM_DESC")==null?"":(String)drugDetails.get("STOCK_UOM_DESC");
						form_code			= drugDetails.get("FORM_CODE")==null?"":(String)drugDetails.get("FORM_CODE");
						 //added for CRF RUT-CRF-0063[29601]--start
						// added for CRF RUT-CRF-0063[29601]--end
						//code added for recommended doasge....on 4/5/2004
						recomm_yn			= (drugDetails.get("RECOMM_YN")==null?"":(String)drugDetails.get("RECOMM_YN")).trim();
						weight_rec_appl_age_group_check_flag =  drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG")== null?"":(String) drugDetails.get("WEIGHT_REC_APPL_AGE_GROUP_CHECK_FLAG");
						wt_mand_yn =  drugDetails.get("WT_MAND_YN")== null?"":(String) drugDetails.get("WT_MAND_YN"); //added for Bru-HIMS-CRF-079 IN[029945]
						ht_mand_yn =  drugDetails.get("HT_MAND_YN")== null?"":(String) drugDetails.get("HT_MAND_YN"); //added for Bru-HIMS-CRF-079 IN[029945]
						interaction_exists			= (String) drugDetails.get("INTERACTION_EXISTS")==null?"N": (String) drugDetails.get("INTERACTION_EXISTS");
						abuse_exists=(String) drugDetails.get("ABUSE_EXISTS")==null?"N": (String) drugDetails.get("ABUSE_EXISTS");
						abuse_action=(String) drugDetails.get("ABUSE_ACTION")==null?"N": (String) drugDetails.get("ABUSE_ACTION");
						
						drugIntraction_override	= drugDetails.get("DRUGINTRACTION_OVERRIDE")==null?"":(String)drugDetails.get("DRUGINTRACTION_OVERRIDE");
						//added for the incedent no : 27465 - Start
						atc_dup_drug_code = (ArrayList)drug_detail.get("ATC_DUP_DRUG_CODE");
						if(atc_dup_drug_code!=null && atc_dup_drug_code.size()>0)
							ATC_dup_drug_code = "Y";
						else 
							ATC_dup_drug_code = "";
						//added for the incedent no : 27465 - End
						//if(recomm_yn.equals("Y")&&(sliding_scale_yn.equals("Y"))){					
						if(recomm_yn.equals("Y") && !amend_yn.equals("Y")){					
							recomm_yn_flag = true;	
							//drugDetails.put("SLIDING_SCALE_YN","N") ;
							sliding_scale_yn = "N";
						}
						if(request.getParameter("sliding_scale_yn") != null)
							sliding_scale_yn = request.getParameter("sliding_scale_yn");

						//if(weight_rec_appl_age_group_check_flag.equals("Y")){ //commented for Bru-HIMS-CRF-079 IN[029945]
						if(wt_mand_yn.equals("Y") || ht_mand_yn.equals("Y")){ //added for Bru-HIMS-CRF-079 IN[029945]
							recomm_yn_flag = true;	 
						}

						if (sliding_scale_yn.equals("Y")){
							qty_value = drugDetails.get("PRES_QTY_VALUE")==null?"":(String)drugDetails.get("PRES_QTY_VALUE");
							qty_desc = drugDetails.get("PRES_BASE_UOM_DESC")==null?"":(String)drugDetails.get("PRES_BASE_UOM_DESC");
						}
						drug_db_dosage_check_flag      =	 (String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DOSAGE_CHECK_FLAG");
						drug_db_contraind_check_flag	= (String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_CONTRAIND_CHECK_FLAG");
						drug_db_interact_check_flag	=  (String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_INTERACT_CHECK_FLAG");	
						drug_db_duptherapy_flag		=  (String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_DUPTHERAPY_FLAG");
						drug_db_allergy_flag		=  (String)drugDetails.get("DRUG_DB_ALLERGY_FLAG")==null?"":(String)drugDetails.get("DRUG_DB_ALLERGY_FLAG");
						dsg_reason	= (String) drugDetails.get("EXT_DDB_DSG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DSG_REASON");	
						dup_reason	= (String) drugDetails.get("EXT_DDB_DUP_REASON")==null?"":(String)drugDetails.get("EXT_DDB_DUP_REASON");
						con_reason	= (String) drugDetails.get("EXT_DDB_CON_REASON")==null?"":(String)drugDetails.get("EXT_DDB_CON_REASON");	
						int_reason	= (String) drugDetails.get("EXT_DDB_INT_REASON")==null?"":(String)drugDetails.get("EXT_DDB_INT_REASON");	
						alg_reason	= (String) drugDetails.get("EXT_DDB_ALG_REASON")==null?"":(String)drugDetails.get("EXT_DDB_ALG_REASON");	
						if(drug_db_dosage_check_flag.equals("Y")||drug_db_contraind_check_flag.equals("Y")||drug_db_interact_check_flag.equals("Y")||drug_db_duptherapy_flag.equals("Y") || drug_db_allergy_flag.equals("Y")){
							ext_checks="Y";
						}
						else{
							if(drug_db_dosage_check_flag.equals("")&&drug_db_contraind_check_flag.equals("")&&drug_db_interact_check_flag.equals("")&&drug_db_duptherapy_flag.equals("") && drug_db_allergy_flag.equals(""))
								ext_checks="";
							else
								ext_checks="N";

						}
						if((drug_db_dosage_check_flag.equals("Y") && (dsg_reason.equals(""))) ||(drug_db_duptherapy_flag.equals("Y")&&(dup_reason.equals(""))) || (drug_db_contraind_check_flag.equals("Y") && (con_reason.equals(""))) || (drug_db_interact_check_flag.equals("Y") && (int_reason.equals("")))||  (drug_db_allergy_flag.equals("Y") && (alg_reason.equals("")))){
							ext_checks_overrided = "N";
						}
						else
							ext_checks_overrided = "Y";

						if(!ext_prod_id.equals("") && drug_db_allergy_check_yn.equals("Y") && drug_db_allergy_flag.equals("Y")){
							allergy_yn = "N";
							drugDetails.put("ALLERGY_YN",allergy_yn);
						}
						if(!ext_prod_id.equals("") && drug_db_duptherapy_yn.equals("Y") && drug_db_duptherapy_flag.equals("Y") && ATC_dup_drug_code.equals("")){ //added ATC_dup_drug_code.equals("") for the incedent no : 27465 
							current_rx = "N";
							drugDetails.put("CURRENT_RX",current_rx);
						}
						/*provide_taper	=	"";                               //commented on 02/06/2010 -- priya
						if(drugDetails.get("PROVIDE_TAPER")!=null)   
							 provide_taper	= (String)drugDetails.get("PROVIDE_TAPER"); */

						no_refill			= (String)drugDetails.get("NO_REFILL");
						stock_available_yn  = (String)drugDetails.get("STOCK_AVAILABLE_YN");
						available_stock	    = (String)drugDetails.get("AVAILABLE_STOCK");

						allow_pres_without_stock_yn = (String)drugDetails.get("ALLOW_PRES_WITHOUT_STOCK_YN");
						scheduled_yn		= drugDetails.get("SCHEDULED_YN")==null?"":(String)drugDetails.get("SCHEDULED_YN");
						order_type_desc		= drugDetails.get("ORDER_TYPE_DESC")==null?"":(String)drugDetails.get("ORDER_TYPE_DESC");
						if(!drug_class.equals("N"))
							drug_class			= drugDetails.get("DRUG_CLASS")==null?"":(String)drugDetails.get("DRUG_CLASS");
						rowVal				= drugDetails.get("rowVal")==null?"":(String)drugDetails.get("rowVal");
						split_dose_yn		= drugDetails.get("SPLIT_DOSE_YN")==null?"":(String)drugDetails.get("SPLIT_DOSE_YN");
						dosage_type			= drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE");
						taper_up			= drugDetails.get("TAPER_UP")==null?"":(String)drugDetails.get("TAPER_UP");

						dosage_unit			= drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
 						if(!dosage_unit.equals("")){ // Added for ML-MMOH-SCF-0633 [IN:063271] - Start
						   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit); 
						   dose_unit_desc1 =dose_unit_desc;//Added for IN:071108
	 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
	 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
	 						 dose_unit_desc1= dose_unit_desc;//Added for IN:071108
						      dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
	 						} 
 						}// Added for ML-MMOH-SCF-0633 [IN:063271] - End
						stat_yn			= (String)drugDetails.get("stat_yn")==null?"":(String)drugDetails.get("stat_yn");						//Added forAAKH-CRF-0091
						
						parent_stat_yn  = (String)drugDetails.get( "parent_stat_yn" )==null?"":(String)drugDetails.get("parent_stat_yn");		//Added forAAKH-CRF-0091
						
						if(dosage_unit == null)
							dosage_unit="";

						prescriptionDetails=(ArrayList)bean.getpresDetails();
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
						if(codeCount_1>=1 && codeCount_2==1 && order_set_code.equals("")){
							deft_mode="tapered";
						}
						else 
							deft_mode = "modify";

						if(deft_mode.equals("tapered") && current_rx_tapered.equals("N")){
							current_rx = "N";
							drugDetails.put("CURRENT_RX",current_rx);
						}

						String tapergif				=   "";
						String allergy_override_gif	=   "";
						String overdose_override_gif=   "";
						String currrx_override_gif	=   "";
						String abuse_override_gif="";//added for aakh-crf-0140
						ArrayList schedule			=	null;
						//String freq_str				=	"";
					//Modified for TFS id:7345 start
						String tooltip				="";
						if(pre_alloc_appl_yn.equals("Y") && drug_search_by.equals("G")){
							tooltip				=	drug_desc_new+"/"+generic_name;
						}
						else{
							tooltip				=	drug_desc+"/"+generic_name;
						}
						//Modified for TFS id:7345 end
						String sliding_scale_yn_bean = drugDetails.get("sliding_scale_yn")==null?"":(String)drugDetails.get("sliding_scale_yn");
						String sliding_scale_yn_req	= request.getParameter("sliding_scale_yn")==null?"":request.getParameter("sliding_scale_yn");
						//HashMap detail				=	null;
					//AAKH-CRF-0091 
						if(parent_stat_yn.equals("Y")){
							route_code	= (String) drugDetails.get("ROUTE_CODE")==null?"":(String) drugDetails.get("ROUTE_CODE");
						}

						if(stat_yn.equals("Y")){
							ArrayList stat_freqs	=	presBean.loadStatFreqs(); // Commented for Performance ML-MMOH-SCF-00684
		//					ArrayList stat_freqs	=	presBean.getStatFreq();	//added for performace ML-MMOH-SCF-00684
		//					if(stat_freqs !=null && stat_freqs.size()==0){ //if() Added for Performance ML-MMOH-SCF-00684
		//						stat_freqs	= (ArrayList)presBean.loadStatFreqs();
	//						}
							for(int m=0;m<stat_freqs.size();m+=2){
								freq_desc	   = ((String) stat_freqs.get(m+1));
								freq_code      = ((String) stat_freqs.get(m));
								
								break;
							}
							drugDetails.put("FREQ_CODE",freq_code);
							drugDetails.put("FREQ_DESC",freq_desc);
							drugDetails.put("AMEND_YN","Y");//added for MMS-DM-SCF-0449
							drugDetails.put("SCHEDULED_YN","N");//AAKH-SCF-0340
							drugDetails.put("FREQ_NATURE","O");
							drugDetails.put("ROUTE_CODE",route_code);
							
							//tooltip	=tooltip+ " - "+qty_value+" "+or_qty_desc+" " +freq_desc+" for 1 Day(s)";
						}
						//if the drug is scheduled  - store the values in or bean
						schedule_val				=	new Hashtable();
						if(!presBean.checkPreScheduled(freq_code).equals("0")) {
							schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
							if((schedule==null || schedule.size()==0 || !sliding_scale_yn_bean.equals(sliding_scale_yn_req)) && scheduled_yn.equals("Y") ) {
								ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject(sch_bean_id,sch_bean_name ,request);
								schedule_bean.setLanguageId(locale);
								schedule_val.put("facility_id", facility_id);
								schedule_val.put("start_time_day_param", start_date);
								schedule_val.put("module_id", "PH"); 
								schedule_val.put("split_dose_yn", split_dose_yn); 
								schedule_val.put("split_qty",qty_value);
								schedule_val.put("freq_code",  freq_code );
								schedule_val.put("code",drug_code+srl_no);
								sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
								sch_output.put("code",drug_code+srl_no);
								sch_output.put("row_value",rowVal);
								sch_output.put("start_date_time",start_date);
								bean.setScheduleFrequencyStr(sch_output);
								drugDetails.put("SCH_OVER_YN","Y");
								putObjectInBean(sch_bean_id,schedule_bean,request); 
							}
						}
					
					//Added for SRR20056-SCF7552 - Start
					if(or_qty_desc == null || or_qty_desc.equals(""))
						or_qty_desc= qty_desc ;
					if(or_qty_desc == null || or_qty_desc.equals(""))
					   or_qty_desc= drugDetails.get("PRES_BASE_UOM_DESC")==null?"":(String)drugDetails.get("PRES_BASE_UOM_DESC") ;
					//Added for SRR20056-SCF7552 - End
					if(split_dose_yn.equals("Y")) {
						schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");

						boolean split_chk	=	bean.checkSplit(schedule);
						if(dosage_type.equals("A")){
							//tooltip			=tooltip+ " - for "+durn_value+" "+or_durn_desc;
							tooltip			=tooltip+ " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;    //""+qty_value+" '+or_qty_desc+"'Added for SRR20056-SCF7552
						}
						else if(schedule!=null && schedule.size() > 0 && split_chk) {
							tooltip			=tooltip+ " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" (Divided) for "+durn_value+" "+or_durn_desc;
						}
						else if(schedule!=null && schedule.size() > 0) {
							tooltip	=tooltip+ " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
						}
						else {
							tooltip	=tooltip+ " -"+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
						}
					} 
					else {
					//AAKH-CRF-0091 

						if(stat_yn.equals("Y")){
							
							tooltip	=tooltip+ " - "+qty_value+" "+or_qty_desc+" " +freq_desc+" for "+durn_value+" "+or_durn_desc;
						}
						else{
							
							if(dosage_type.equals("A"))
								//tooltip			=tooltip+ " - "+freq_desc+" for "+durn_value+" "+or_durn_desc;
								tooltip			=tooltip+ " - "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc; //""+qty_value+" '+or_qty_desc+"'Added for SRR20056-SCF7552
							else {
								schedule	=	(ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");

							if(schedule!=null && schedule.size() > 0) {
								/* detail	=	(HashMap)schedule.get(0);
								 qty_value		=	(String)detail.get("admin_qty");*/
								 ArrayList dose_list	= (ArrayList)schedule.get(4);
								 if(dose_list!=null && dose_list.size()>0)
										qty_value		= (String)dose_list.get(0);
							}
							tooltip	= tooltip+ " - "+qty_value+" "+or_qty_desc+" "+freq_desc+" for "+durn_value+" "+or_durn_desc;
						}
						}
					}
			/*** Tool tip ends***/ 
						
				if(patient_class.equals("IP") && dosage_type.equals("A")) {
					ArrayList QtyDescDetails		= (ArrayList)presBean.loadQtyDetails(form_code);
				
					for(int p=0; p<QtyDescDetails.size(); p+=3) {
						uom_code	= (String)QtyDescDetails.get(p);
						uom_desc	= (String)QtyDescDetails.get(p+1);
						dflt_yn		= (String)QtyDescDetails.get(p+2);

						if(dflt_yn.equals("Y")&&(uom_code.equals(qty_desc_code))) {
							drugDetails.put("QTY_DESC",uom_desc);
							drugDetails.put("QTY_DESC_CODE",uom_code);
							drugDetails.put("OR_QTY_DESC",uom_desc);
						}
					}
				}

				String dispDesc="";
				//Modified for TFS id:7345 start
				if(pre_alloc_appl_yn.equals("Y") && drug_search_by.equals("G")){
				if(drug_desc_new.length()>11){
					dispDesc=drug_desc_new.substring(0,11)+"...";
				}
				else{
					dispDesc=drug_desc_new;
				}
				}
				else{
					if(drug_desc.length()>11){
						dispDesc=drug_desc.substring(0,11)+"...";
					}
					else{
						dispDesc=drug_desc;
					}	
				}
				//Modified for TFS id:7345
				if(j==(displayList.size())-1){
 //Added for RUT-CRF-0088 [IN036978]
					
					if(dosage_type.equals("Q"))
						conv_factor = (String) bean.getConvFactor(qty_desc_code,pres_base_uom);
				
				freq_chng_durn_value = durn_value;
				
				repeat_durn_type			= drugDetails.get("REPEAT_DURN_TYPE")==null?"D":(String) drugDetails.get("REPEAT_DURN_TYPE");	
				if(!freq_chng_durn_desc.equals(repeat_durn_type)){
					freq_chng_durn_value = (String)bean.getFreqDurnConvValue(repeat_durn_type,durn_value,freq_chng_durn_desc);
					repeat_durn_type = freq_chng_durn_desc;
				}
				
				if(!dosage_type.equals("A") && !freq_nature.equals("P"))
						order_qty	=	bean.getOrderQty(drugDetails,qty_value,"1",freq_chng_durn_value,"",dosage_type,conv_factor,false);
			
				else
						order_qty=qty_value;
					
				
					if(freq_nature!=null && (freq_nature.equals("O")|| freq_nature.equals("P") ) ){

						taper_yn="N";
						taper_up = "N";
					}
					if( (provide_taper.equals("Y"))  && (no_refill.equals("") || no_refill.equals("0")) )	{
						if(taper_up!=null && taper_up.equals("Y")){
							tapergif="<img src='../../ePH/images/uparrow.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose' "+alternateDisable+" ></img>";//added for  JD-CRF-0198 [IN:058599]
						}
						else if(taper_yn!=null && taper_yn.equals("Y")){ 
							if(taper_up!=null && (taper_up.equals("N"))){ // added if condition - priya -- modified on 14/04/2010
								tapergif="<img src='../../ePH/images/downarrow.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
							}
							else{
								tapergif="<img src='../../ePH/images/MultiFrequency.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
							}
						}
						else{
							tapergif="<img src='../../ePH/images/MultiFrequency.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
						}
					}
					else {
						if(!sliding_scale_yn.equals("Y")){
							if(taper_up!=null && taper_up.equals("Y")){
								tapergif="<img src='../../ePH/images/uparrow.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
							}
							else if(taper_yn!=null && taper_yn.equals("Y")){
								if(taper_up!=null && (taper_up.equals("N"))){ // added if condition - priya  -- modified on 14/04/2010
									tapergif="<img src='../../ePH/images/downarrow.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
								}
								else{
									tapergif="<img src='../../ePH/images/MultiFrequency.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose' "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
								}
							}
							else{
								
								//AAKH-CRF-0091 

								if(stat_yn.equals("Y") || parent_stat_yn.equals("Y")){
									tapergif="";
								}
								else{
									tapergif="<img src='../../ePH/images/MultiFrequency.gif' onclick=\"defaultDrug('"+drug_code+"','taper','"+srl_no+"','"+sliding_scale_yn+"','"+recomm_yn+"');\" title='Taper Dose'  "+alternateDisable+"></img>";//added for  JD-CRF-0198 [IN:058599]
								}
								
							}
						}
						else{
							tapergif="";
						}
					}
				}
				else{
					tapergif="";
				}
			//	if((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))){
				if(freq_nature!=null && (freq_nature.equals("O")|| freq_nature.equals("P") ) ){
						tapergif="";
				}
					if(allergy_override!=null && allergy_override.equals("N")){
						/*if(stat_yn.equals("Y")){ //if() added for AAKH-CRF-0091 and commented for MMS-KH-SCF-0080
							allergy_override_gif="&nbsp;";
						}
						else{ */
						allergy_override_gif="<img src='../../ePH/images/exceed1.gif'></img>";
						//}
					}
					else{
						allergy_override_gif="&nbsp;";
					}
					if(dose_override!=null && dose_override.equals("N")){
						/*if(stat_yn.equals("Y")){ //if() added for AAKH-CRF-0091 and commented for MMS-KH-SCF-0080
							overdose_override_gif="&nbsp;";
						}
						else{ */
						overdose_override_gif="<img src='../../ePH/images/exceed1.gif' ></img>";
						//}
					}
					else{
						overdose_override_gif="&nbsp;";
					}
					if(currentrx_override!=null && currentrx_override.equals("N")){
						/*if(stat_yn.equals("Y")){ //if() added for AAKH-CRF-0091  and commented for MMS-KH-SCF-0080 
							currrx_override_gif="&nbsp;";
						}
						else{ */
							currrx_override_gif="<img src='../../ePH/images/exceed1.gif'></img>";	
						//}
					}
					else{
						currrx_override_gif="&nbsp;";
					}
					if(drugIntraction_override!=null && drugIntraction_override.equals("N")  && !stat_yn.equals("N")){//added for mms-kh-scf-0186
						//if(stat_yn.equals("Y") ){ //if() added for AAKH-CRF-0091 and commented for MMS-KH-SCF-0080
							//drugIntraction_override_gif="&nbsp;";
						//}
						//else{
						drugIntraction_override_gif="<img src='../../ePH/images/exceed1.gif' ></img>";
						//}
					}
					else{
						drugIntraction_override_gif="&nbsp;";
					}
					if(abuse_override!=null && abuse_override.equals("N")){//added for aakh-crf-0140
						//if(stat_yn.equals("Y") ){ 
							//drugIntraction_override_gif="&nbsp;";
						//}
						//else{
						abuse_override_gif="<img src='../../ePH/images/exceed1.gif' ></img>";
						//}
					}
					else{
						abuse_override_gif="&nbsp;";
					}
			//	}

					if( Integer.parseInt(adr_count)>0){
						drug_adr_count = bean.getADRCount(patient_id,drug_code);
                        if(drug_adr_count>0){
								adr_gif="<img src='../../ePH/images/ADR.gif' height=20  width=15></img>";
						}
						else{
							adr_gif="&nbsp;";
						}
					}

						if(!(prev_order_code.equals(order_type_code))){
%>
							<tr>
								<td class='COLUMNHEADER' colspan="9" ><%=order_type_desc%></td><!-- added for aakh-crf-0140 -->
							</tr>
<%
							prev_order_code=order_type_code;
						}
						if(stock_available_yn.equals("N")){
							if(allow_pres_without_stock_yn.equals("N")){
								tapergif="";
								//tooltip	= drug_desc+" - No Stock Available";
							}
						}
%>
						<tr  style="background-color: lightgoldenrodyellow;" title="<%=tooltip%>" id='row<%=srl_no%>'>
							<input type="hidden" name="dt<%=srl_no%>" id="dt<%=srl_no%>" value="<%=start_date%>">
							<input type="hidden" name="order_qty<%=srl_no%>" id="order_qty<%=srl_no%>" value="<%=order_qty%>">  <!-- Added for RUT-CRF-0088 [IN036978]-->
<%
							if(j==0){
								if(amend_yn.equals("Y")){
									classValue="AMENDEDDRUGS";
									if(patient_stock_yn!=null && patient_stock_yn.equals("Y")){//added for GHL-CRF-0482
										classValue="PATIENTSTOCKAMEND";
									}
								}
								else{
									classValue="SELECTEDRUGS";
									if(tmp_srl_no==null){
										tmp_srl_no		=	srl_no;
										tmp_drug_code	=	drug_code;
							//added for PE correction By Naveen
										tmp_sliding_scale_yn =sliding_scale_yn;
									}
								}
							}
							else{
								if(deft_mode.equals("tapered"))
									classValue="TAPERDRUGS";
								if(amend_yn.equals("Y")){//added for GHL-CRF-0482
									if(patient_stock_yn!=null && patient_stock_yn.equals("Y")){
										classValue="PATIENTSTOCKAMEND";
									}
								}
								else if(amend_yn.equals("N")){
									classValue="SELECTEDRUGS";
									if(tmp_srl_no==null){
										tmp_srl_no		=	srl_no;
										tmp_drug_code	=	drug_code;
							//added for PE correction By Naveen
										tmp_sliding_scale_yn =sliding_scale_yn;
									}
								}
							}
							if(j==(displayList.size())-1){
%>
								<td class="white" width="6%" onmouseover="changeCursor(this);" ><%=tapergif%></td>
<%
							}
							else{
							
							//AAKH-CRF-0091 

								if(stat_yn.equals("Y") || parent_stat_yn.equals("Y")){
%>
							
							<!--AAKH-CRF-0091-->
							
									<td class="white" width="6%"  title=''><%=tapergif%></td>
<% 								}
								else{
								
%>						
									<td class="white" width="6%"  title='Tapered'><%=tapergif%></td>
<%								}
								
							}	
							if(stock_available_yn.equals("N")){
								if(allow_pres_without_stock_yn.equals("N")){
%>
						<!-- Modified for TFS id:7345 start -->
						<%if(pre_alloc_appl_yn.equals("Y") && drug_search_by.equals("G")){ %>
									<td class="<%=classValue%>"  NOWRAP width="64%" id='drug_<%=drug_code%>_<%=srl_no%>' onClick="defaultDrug('<%=drug_code%>','<%=deft_mode%>','<%=srl_no%>','<%=sliding_scale_yn%>','<%=recomm_yn%>','','','<%=parent_stat_yn%>','<%=stat_yn%>');" onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');" title="<%=drug_desc_new%>"><font class="HYPERLINK" size='1'><%=dispDesc%></font>  <!--parent_stat_yn,stat_yn AAKH-CRF-0091-->
									<%}else{ %>
									<td class="<%=classValue%>"  NOWRAP width="64%" id='drug_<%=drug_code%>_<%=srl_no%>' onClick="defaultDrug('<%=drug_code%>','<%=deft_mode%>','<%=srl_no%>','<%=sliding_scale_yn%>','<%=recomm_yn%>','','','<%=parent_stat_yn%>','<%=stat_yn%>');" onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');" title="<%=drug_desc%>"><font class="HYPERLINK" size='1'><%=dispDesc%></font>  <!--parent_stat_yn,stat_yn AAKH-CRF-0091-->
<%}//Modified for TFS id:7345 end
									if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {
%>
										<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_name_1%>');return false;">
<%
									}
%>
									&nbsp;&nbsp;</td><td style="background-color:red;font-weight:bold;font-size:11;cursor:pointer;height:20" NOWRAP  colspan="3" title="Available Qty:&nbsp;<%=available_stock%>&nbsp;&nbsp;<%=stock_uom%>"><marquee scrollamount="3"><font style="font-weight:bold;color:white"><fmt:message key="ePH.InsufficientStock-AvailableQuantity.label" bundle="${ph_labels}"/>:&nbsp;<%=available_stock%>&nbsp;<%=stock_uom%></font></marquee></td>
									<td class="<%=classValue%>" width="5%" id='td_dosage_override<%=srl_no%>'>&nbsp;</td>
<%
								}
								else{
									classValue="NOSTOCKWARN";
									if(sch_over_yn.equals("N") ){
%>
										<td class="<%=classValue%>"  NOWRAP width="64%" id='drug_<%=drug_code%>_<%=srl_no%>' onClick="defaultDrug('<%=drug_code%>','<%=deft_mode%>','<%=srl_no%>','<%=sliding_scale_yn%>','<%=recomm_yn%>','','','<%=parent_stat_yn%>','<%=stat_yn%>');" onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');"><font class="HYPERLINK" size='1'><%=dispDesc%></font> <!--parent_stat_yn,stat_yn AAKH-CRF-0091-->
<%
										if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {											
%>
											<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_name_1%>') ">
<%
										}
%>
										&nbsp;&nbsp;</td>
<%
									}
									else{
%>
										<td class="<%=classValue%>"  NOWRAP width="64%" id='drug_<%=drug_code%>_<%=srl_no%>' onClick="defaultDrug('<%=drug_code%>','<%=deft_mode%>','<%=srl_no%>','<%=sliding_scale_yn%>','<%=recomm_yn%>','','','<%=parent_stat_yn%>','<%=stat_yn%>');" onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');"><font class="HYPERLINK" size='1'><%=dispDesc%></font> <!--parent_stat_yn,stat_yn AAKH-CRF-0091-->

<%
									if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {
										
%>
										<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_name_1%>') ">
<%
									}
%>
										&nbsp;&nbsp;</td>
<%
									}

                                    if(drug_adr_count>0){
%>                                    
                                         <td class=<%=classValue%>   width="3%"  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' >&nbsp;<%=adr_gif%>&nbsp;</td>


<%									}
									else{
%>
                                          <td class="<%=classValue%>"   width="3%">&nbsp;</td>

<%									}
									if(ext_checks.equals("Y")){
%>
										<td class="SHIFTTOTAL" width="5%" title='<fmt:message key="ePH.ExternalOverrideDrug.label" bundle="${ph_labels}"/>' id="ext_ddb_override_indc<%=srl_no%>" onClick="extDosageCheckFromPad('<%=drug_code%>','<%=srl_no%>','<%=ext_prod_id%>','PAD');" onmouseover="changeCursor1(this);">
<%
										if(ext_checks_overrided.equals("Y")){
%>
											<img name='ext_ddb_override_img<%=srl_no%>' src='../../ePH/images/exceed1.gif' style='visibility:hidden;' ></img>
											</td>
<%
										}
										else{
%>
											<img name='ext_ddb_override_img<%=srl_no%>' src='../../ePH/images/exceed1.gif' style='visibility:visible;' ></img>
											</td>
<%
										}
									}
									else{
%>
										<td class="<%=classValue%>"  NOWRAP width="5%" id="ext_ddb_override_indc<%=srl_no%>" onClick="extDosageCheckFromPad('<%=drug_code%>','<%=srl_no%>','<%=ext_prod_id%>','PAD');" onmouseover="changeCursor1(this);"><img name='ext_ddb_override_img<%=srl_no%>' src='../../ePH/images/exceed1.gif' style='visibility:hidden;' ></img>
										</td>
<%
									}
									
								//	if(((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))) && allergy_yn!=null && allergy_yn.equals("Y")){
									if((ext_prod_id.equals("") || !drug_db_allergy_check_yn.equals("Y") || !drug_db_allergy_flag.equals("Y")) && allergy_yn!=null && allergy_yn.equals("Y")){
%>	
										<td class="ALLERGY" id="allergy<%=srl_no%>"  NOWRAP width="5%" title='<fmt:message key="ePH.AllergyDrug.label" bundle="${ph_labels}"/>'  onclick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=drug_name_1%>');" onmouseover="changeCursor(this);"  >&nbsp;<%=allergy_override_gif%>&nbsp;</td>
<%
									}
									else{
%>	
										<td class="<%=classValue%>"  NOWRAP width="5%" id="allergy<%=srl_no%>">&nbsp;</td>
<%
									}
									if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") ){
									//if((!drug_db_dosage_check_flag.equals("Y") || !ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") ){

%>
										<td class="DOSELIMIT"  NOWRAP width="5%" title='<fmt:message key="ePH.ExceedDosageLimit.label" bundle="${ph_labels}"/>' onmouseover="changeCursor(this);" onclick="showMonoGraph('<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=java.net.URLEncoder.encode(mono_graph,"UTF-8")%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>','<%=dosage_unit%>','<%=dosage_std%>','<%=dose_unit_desc%>','<%=max_daily_ceeling_dose%>','<%=min_daily_ceeling_dose%>','<%=max_unit_ceeling_dose%>','<%=min_unit_ceeling_dose%>','<%=dose_unit_desc1%>');" id='td_dosage_override<%=srl_no%>'>&nbsp;<%=overdose_override_gif%>&nbsp;</td> <!-- dose_unit_desc Added for ML-MMOH-SCF-0633 [IN:063271] --><!-- Modified for IN:070451 end, Added dose_unit_desc1 for IN:071108 --><!-- Modified for IN:073769-->
<%
									}
									else{
%>
										<td class="<%=classValue%>" width="5%" id='td_dosage_override<%=srl_no%>'>&nbsp;</td>
<%
									}

									if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  interaction_exists.equals("Y") ){
%>
										<td class="DOSELIMIT1"  NOWRAP width="5%" title='<fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/>' onmouseover="changeCursor(this);" onclick="showInractionDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>');" id='td_drugIntraction<%=srl_no%>'>&nbsp;<%=drugIntraction_override_gif%>&nbsp;</td>
<%
									}
									else{
%>
										<td class="<%=classValue%>" width="5%" id='td_drugIntraction<%=srl_no%>'>&nbsp;</td>
<%
									}//added for aakh-crf-0140 start
									if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  (abuse_exists.equals("Y") && abuse_action.equals("B")) ){
										%>
																				<td class="DOSELIMIT1" style="BACKGROUND-COLOR:purple;" NOWRAP width="5%" title='Drug Abuse' onmouseover="changeCursor(this);" onclick="showAbuseDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>');" id='td_abuseaction<%=srl_no%>'>&nbsp;<%=abuse_override_gif%>&nbsp;</td>
										<%
																			}
																			else{
										%>
																				<td class="<%=classValue%>" width="5%" id='td_abuseaction<%=srl_no%>'>&nbsp;</td>
										<%
																			}//added for aakh-crf-0140 end
//									if(((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))) && current_rx!=null && current_rx.equals("Y")){
									if((ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y") || !drug_db_duptherapy_flag.equals("Y") || !ATC_dup_drug_code.equals("")) && current_rx!=null && current_rx.equals("Y")){ //added ATC_dup_drug_code.equals("")  for the incedent no : 27465 
%>
										<td class="CURRENTRX" id="currentrx<%=srl_no%>"  NOWRAP width="5%" title='<fmt:message key="ePH.DuplicateMedication.label" bundle="${ph_labels}"/>' onmouseover="changeCursor(this);" onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')">&nbsp;<%=currrx_override_gif%>&nbsp;</td>
<%
									}
									else{
%>
										<td class="<%=classValue%>"  NOWRAP width="5%" id="currentrx<%=srl_no%>">&nbsp;</td>
<%
									}
								}  
							}
							else{
								if(sch_over_yn.equals("N") ){
%>
									<td class="<%=classValue%>"  NOWRAP width="64%" onClick="defaultDrug('<%=drug_code%>','<%=deft_mode%>','<%=srl_no%>','<%=sliding_scale_yn%>','<%=recomm_yn%>','','','<%=parent_stat_yn%>','<%=stat_yn%>');" id='drug_<%=drug_code%>_<%=srl_no%>'  onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');"><font CLASS="HYPERLINK" size='1' ><%=dispDesc%></font><!--parent_stat_yn,stat_yn AAKH-CRF-0091-->
<%
									if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {
%>
										<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_name_1%>') ">
<%
									}
%>
										&nbsp;&nbsp;</td>
<%
									}
									else{
%>
										<td class="<%=classValue%>"  NOWRAP width="64%" onClick="defaultDrug('<%=drug_code%>','<%=deft_mode%>','<%=srl_no%>','<%=sliding_scale_yn%>','<%=recomm_yn%>','','','<%=parent_stat_yn%>','<%=stat_yn%>');" id='drug_<%=drug_code%>_<%=srl_no%>' onmouseover="changeCursor(this);changeCol(this);" onmouseout="realCol(this,'<%=classValue%>');"> <!--parent_stat_yn,stat_yn AAKH-CRF-0091-->
										<font class="HYPERLINK" size='1'><%=dispDesc%>
										</font>
<%
										if (!ext_prod_id.equals("")	&& drug_db_interface_yn.equals("Y")) {
%>
											<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="loadDrugInfo('<%=ext_prod_id%>','<%=drug_name_1%>') ">
<%
										}
%>
											&nbsp;&nbsp;</td>
<%
										}
										if(drug_adr_count>0){
%>                                    
											<td class=<%=classValue%>   width="3%" id='ADR'  title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' >&nbsp;<%=adr_gif%>&nbsp;</td>
<%									    }
										else{
%>
                                          <td class="<%=classValue%>"   id='ADR'  width="3%">&nbsp;</td>
<%	                                    
										}
										if(ext_checks.equals("Y")){
%>
											<td class="SHIFTTOTAL" width="5%" title='<fmt:message key="ePH.ExternalOverrideDrug.label" bundle="${ph_labels}"/>' id="ext_ddb_override_indc<%=srl_no%>" onClick="extDosageCheckFromPad('<%=drug_code%>','<%=srl_no%>','<%=ext_prod_id%>','PAD');" onmouseover="changeCursor1(this);">
<%
											if(ext_checks_overrided.equals("Y")){
%>
												<img name='ext_ddb_override_img<%=srl_no%>' src='../../ePH/images/exceed1.gif' style='visibility:hidden;'></img>
												</td>
<%
											}
											else{
%>
												<img name='ext_ddb_override_img<%=srl_no%>' src='../../ePH/images/exceed1.gif' style='visibility:visible;'></img>
												</td>
<%
											}
										}
										else{
%>
											<td class="<%=classValue%>"  NOWRAP width="5%" id="ext_ddb_override_indc<%=srl_no%>"  onmouseover="changeCursor1(this);" onClick="extDosageCheckFromPad('<%=drug_code%>','<%=srl_no%>','<%=ext_prod_id%>','PAD');"><img name='ext_ddb_override_img<%=srl_no%>' src='../../ePH/images/exceed1.gif' style='visibility:hidden;' ></img>
											</td>
<%
										}
										//if(((!drug_db_interface_yn.equals("Y")) || (ext_prod_id.equals(""))) && allergy_yn!=null && allergy_yn.equals("Y")){
										if((ext_prod_id.equals("") || !drug_db_allergy_check_yn.equals("Y") || !drug_db_allergy_flag.equals("Y")) && allergy_yn!=null && allergy_yn.equals("Y")){
%>
											<td class="ALLERGY"  id="allergy<%=srl_no%>" NOWRAP width="5%"title='<fmt:message key="ePH.AllergyDrug.label" bundle="${ph_labels}"/>' onclick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=drug_name_1%>');" onmouseover="changeCursor(this);">&nbsp;<%=allergy_override_gif%>&nbsp;</td>
<%
										}
										else{
%>
											<td class="<%=classValue%>" NOWRAP width="5%"  id="allergy<%=srl_no%>" >&nbsp;</td>
<%
										}
										if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") && !stat_yn.equals("Y")){//&& !stat_yn.equals("Y") added for mms-kh-scf-0186
										//if((!drug_db_dosage_check_flag.equals("Y") || !ext_prod_id.equals("")) && limit_ind!=null && limit_ind.equals("N") ){
										//stem.err.println("mono_graph  2::"+mono_graph);
%>
											<td class="DOSELIMIT"  NOWRAP width="5%" title='<fmt:message key="ePH.ExceedDosageLimit.label" bundle="${ph_labels}"/>' onmouseover="changeCursor(this);"   onclick="showMonoGraph('<%=java.net.URLEncoder.encode(drug_desc,"UTF-8")%>','<%=java.net.URLEncoder.encode(mono_graph,"UTF-8")%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_daily_dose%>','<%=min_unit_dose%>','<%=dosage_unit%>','<%=dosage_std%>','<%=dose_unit_desc%>','<%=max_daily_ceeling_dose%>','<%=min_daily_ceeling_dose%>','<%=max_unit_ceeling_dose%>','<%=min_unit_ceeling_dose%>','<%=dose_unit_desc1%>');" id='td_dosage_override<%=srl_no%>'>&nbsp;<%=overdose_override_gif%>&nbsp;</td> <!-- dose_unit_desc Added for ML-MMOH-SCF-0633 [IN:063271] --><!-- Modified for IN:070451, Added dose_unit_desc1 for IN:071108  --><!-- Modified for IN:073769-->
<%
										}
										else{
%>
											<td class="<%=classValue%>" nowrap width="5%" id='td_dosage_override<%=srl_no%>'>&nbsp;</td>
<%
										}

										if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  interaction_exists.equals("Y")  && !stat_yn.equals("Y")){//&& !stat_yn.equals("Y") added for mms-kh-scf-0186
%>
											<td class="DOSELIMIT1"  NOWRAP width="5%" title='<fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/>' onmouseover="changeCursor(this);" onclick="showInractionDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>');" id='td_drugIntraction<%=srl_no%>'>&nbsp;<%=drugIntraction_override_gif%>&nbsp;</td>
<%
										}
										else{
%>
											<td class="<%=classValue%>" nowrap width="5%" id='td_drugIntraction<%=srl_no%>'>&nbsp;</td>
<%
										}
										//added for aakh-crf-0140 start
										if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("")) &&  (abuse_exists.equals("Y") && abuse_action.equals("B")) ){
											%>
											<td class="DOSELIMIT1" style="BACKGROUND-COLOR:purple;" NOWRAP width="5%" title='drugAbuse' onmouseover="changeCursor(this);" onclick="showAbuseDtl('<%=drug_code%>','<%=srl_no%>','<%=patient_id%>','<%=encounter_id%>');" id='td_abuseaction<%=srl_no%>'>&nbsp;<%=abuse_override_gif%>&nbsp;</td>

		<%	
											}
											else{
												%>
												<td class="<%=classValue%>" width="5%" id='td_abuseaction<%=srl_no%>'>&nbsp;</td>
												<%
											}//added for aakh-crf-0140 end
										if((!drug_db_interface_yn.equals("Y") || ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y")) && current_rx!=null && current_rx.equals("Y") && !stat_yn.equals("Y")){ // stat_yn added for AAKH-CRF-
										//if((ext_prod_id.equals("") || !drug_db_duptherapy_yn.equals("Y") ||  !drug_db_duptherapy_flag.equals("Y") || !ATC_dup_drug_code.equals(""))&& current_rx!=null && current_rx.equals("Y") ){// added  !ATC_dup_drug_code.equals("")) for the incedent no : 27465 
%>
											<td class="CURRENTRX" id="currentrx<%=srl_no%>"  NOWRAP width="5%" title='<fmt:message key="ePH.DuplicateMedication.label" bundle="${ph_labels}"/>'  onmouseover="changeCursor(this);" onClick="callCurrentMedication('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')">&nbsp;<%=currrx_override_gif%>&nbsp;</td>
<%
										}
										else{
											
%>												<td class="<%=classValue%>" nowrap width="5%" id='currentrx<%=srl_no%>'>&nbsp;</td>
<%													
										
										}
									}
%>
									</tr>
									<input type='hidden' name='amend_yn_<%=srl_no%>' id='amend_yn_<%=srl_no%>' value="<%=amend_yn%>">
									<input type='hidden' name='wt_mand_yn<%=srl_no%>' id='wt_mand_yn<%=srl_no%>' value="<%=wt_mand_yn%>"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->
									<input type='hidden' name='ht_mand_yn<%=srl_no%>' id='ht_mand_yn<%=srl_no%>' value="<%=ht_mand_yn%>"> <!--added for Bru-HIMS-CRF-079 IN[029945]-->
									<input type='hidden' name='weight_rec_appl_age_group_check_flag<%=srl_no%>' id='weight_rec_appl_age_group_check_flag<%=srl_no%>' value="<%=weight_rec_appl_age_group_check_flag%>"> <!--added for Bru-HIMS-CRF-079 IN[029945] -->
									<input type='hidden' name='recomm_yn_flag_<%=srl_no%>' id='recomm_yn_flag_<%=srl_no%>' value="<%=recomm_yn_flag%>">
<%
								/*	if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
										out.println("<script>getChargeDetails_Pad('"+drug_code+"','"+srl_no+"','"+dosage_type+"','"+qty_value+"','"+qty_desc_code+"','"+durn_value+"','"+repeat_value+"');</script>");
									}*/
							//	} //commented for ICN68121 (IN008234)
//System.err.println("==drug_db_interface_yn====="+drug_db_interface_yn+"==ext_prod_id==="+ext_prod_id+"==conf_drug_code=="+conf_drug_code+"==drug_code=="+drug_code+" conf_srl_no"+conf_srl_no+" srl_no="+srl_no+"amend_yn"+amend_yn+" copied_drug_yn="+copied_drug_yn+" ext_checks="+ext_checks+"==="+(drug_db_interface_yn.equals("Y") &&!ext_prod_id.equals("") && ((conf_drug_code.equals(drug_code) && conf_srl_no.equals(srl_no))  || ext_checks.equals("") )));
								datechanged_yn 	=	drugDetails.get("DATECHANGED")==null?"":(String)drugDetails.get("DATECHANGED"); //Added for ML-BRU-SCF-1423 [IN:050857]
								if(drug_db_interface_yn.equals("Y") &&!ext_prod_id.equals("") && ((conf_drug_code.equals(drug_code) && conf_srl_no.equals(srl_no))  || ext_checks.equals("") || datechanged_yn.equals("Y") )){
									//if(curr_code.equals(drug_code)){ //if condition commented for IN25277 --06/01/2011-- priya - to perform External DB check from Copy previous orders with multiple drugs
%>
										<script>
											extDosageCheckFromPad('<%=drug_code%>','<%=srl_no%>','<%=ext_prod_id%>','PADLOAD');
										</script>
<%									//} //end if(curr_code.equals(drug_code))
								} //ADDED for ICN68121 (IN008234)
								}
							}
						}
%>
<!-- moved      <input type='hidden' name='amend_yn_<%=srl_no%>' id='amend_yn_<%=srl_no%>' value="<%=amend_yn%>"> from here to line 990 -06/01/2011- priya (to prevent script error on click of taper for first drug)-->
<%			
					}
%>
					<input type='hidden' name='drug_class' id='drug_class' value="<%=drug_class%>">
					<input type="hidden" name="parent_stat_yn" id="parent_stat_yn" value="<%=parent_stat_yn%>"> 		<!--AAKH-CRF-0091-->
					<input type="hidden" name="stat_yn" id="stat_yn" value="<%=stat_yn%>">						<!--AAKH-CRF-0091-->
				</table>
<%
			}// top if
//corrected for PE by Naveen
			//HashMap sliding_scale_dtls = bean.getSlidingScaleDetails(tmp_drug_code);
			if(!copied_drug_yn.equals("Y") ){
				//if(sliding_scale_dtls!=null && sliding_scale_dtls.size()>0){
					//sliding_scale_yn = (String)sliding_scale_dtls.get("APPL_SLIDING_SCALE_YN");
					sliding_scale_yn = tmp_sliding_scale_yn;
				//}
			}
			if(request.getParameter("sliding_scale_yn")!=null)
				sliding_scale_yn =request.getParameter("sliding_scale_yn");
%>			
		</form>
	</body>
	<script>
	async function toHoldShowModal(){
<%
		presDetails	=(ArrayList) bean.getpresDetails();

	//mode
		if(presDetails!=null && presDetails.size()>0){
			if(tmp_srl_no!=null ){
				if(recomm_yn_flag){//modified for tapper dose 
%>
					recommendDosage('<%=tmp_drug_code%>','<%=deft_mode%>','<%=tmp_srl_no%>','<%=request.getParameter("order_idC")%>','<%=request.getParameter("modeC")%>'); 
//prescription_form, removed for Bru-HIMS-CRF-079
<%
				}
				else{
					if(!drug_code_sliding.equals("")){
						tmp_drug_code = drug_code_sliding;
						tmp_srl_no = srl_no_sliding;
					}
					/*if(!new_srl_no.equals(""))
							tmp_srl_no =new_srl_no;*///modified for tapper dose
%>
							
					await defaultDrug('<%=tmp_drug_code%>','<%=deft_mode%>','<%=tmp_srl_no%>','<%=tmp_sliding_scale_yn%>','<%=recomm_yn%>','<%=request.getParameter("order_idC")%>','<%=request.getParameter("modeC")%>','<%=parent_stat_yn%>','<%=stat_yn%>');  //<!--'<%=parent_stat_yn%>','<%=stat_yn%>'_AAKH-CRF-0091-->
<%
				}
			} 
		}
		if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
			await getBLErrorDrugs();
		
<%
		}
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(presBean_id,presBean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
}
toHoldShowModal();
	</script>
</html>

