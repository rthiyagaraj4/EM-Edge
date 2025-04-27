<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
04/19/2017	MMS-DM-SCF-0417   Manickavasagam	Allocated Quantity is showing wrong when the batch gets expired before Allocated days
04/19/2017	BSP-SCF-0041	  Mukesh		Allocated Quantity is showing wrong when the batch gets expired before Allocated days		
05/12/2017	[IN:064158]	  Devindra		Change in barcode scanning functionality in Dispense Medication(in each scan one quantity need to add).		
--------------------------------------------------------------------------------------------------------------
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%	
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
		function CheckPatReqd(Obj){
			if(Obj.checked==true)
				Obj.value="C";
			else
			Obj.value="N";
		}
		</script>
	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
		<form name="DispMedicationAllStages" id="DispMedicationAllStages" >
<%
			String patient_id						= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String encounter_id						= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
			String order_id							= request.getParameter("order_id")==null?"":request.getParameter("order_id");
			String pract_id							= request.getParameter("practitioner_id")==null?"":request.getParameter("practitioner_id");
			String pract_name						= request.getParameter("practitioner_name")==null?"":request.getParameter("practitioner_name");
			String filling_status					=	"";
			String check_status						=	"";
			String filling_reqd						=	"";
			String delivery_reqd					=	"";
			String stage							=	"";
			String display_seq						=	"";
			String allocation_reqd					=	"";
			String filling_det						=	"";
			String del_data							=	"";
			String ext_prod_id						=	"";
			String order_line_no					=	"";
			String drug_code						=	"";
			String drug_name						=	"";
			String dosage_dtls						=	"";
			String end_date							=	"";
			String pres_qty							=	"";
			String qty_uom							=	"";
			String qty_uom_disp						=	"";
			String alt_drug_code					=	"";
			String alt_drug_desc					=	"", alt_drug_desc_1="";
			String drug_color						=	"";
			String form_code						=	"";
			String hold_status						=	"";
			String remark_status					=	"";
			String uom								=	"";
			String del_style						=	"";
			String hold_text						=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
			String check_value						=	"N";
			String fromdb							=	"N";
			String allergy							=	"";
			String exceed_dose						=	"";
			String generic_id						=	"";
			String generic_name						=	"";
			String dosage_details					=	"";
			String exceed_status					=	"";
			String monograph						=	"";
			String unit_dose						=	"";
			String daily_dose						=	"";
			String bms_qty							=	"";
			String allocate_button					=	"";
			String filling_button					=	"";
			String alloc_empty_det					=	"";
			String alloc_det						=	"";
			String source_code						=	"";
			String source_type						=	"";
			String ordering_facility_id				=	"";
			String ord_date_time					=	"";
			String performing_pract_id				=	"";
			String filling_empty_det				=	"";
			String alt_drug_qty						=	"";
			String duplicate_yn						=	"";
			String min_dose_dtls					=	"";
			String min_unit_dose					=	"";
			String min_daily_dose					=	"";
			ArrayList stock_opt						=	new ArrayList();
			String hold_value						=	"";
			String alloc_qty_from_tmp				=	"";
			String strength_value					=	"";
			String strength_uom						=	"";
			int		tot_qty							=	0;
			String classvalue						=	"";
			String pres_strength					=	"";
			String alt_strength_value				=	"";
			String alloc_strength					=	"";
			String bms_strength						=	"";
			String in_formulary_yn					=	"";
			String drug_class						=	"";
			String tmp_bms_qty						=	"";
			String title							=	"";
			String narc_style						=	"";
			String pat_couns_reqd_yn				=   "";
			int bmscount							=    0;
			String  scope							=   "";
			String legend1                          =   "";  
			String legend_text                      =   "";
			String disable_complete_order			=	"";
			String strChangedFludRmks				=	"";
			String pat_reqd							=	"";
			String pt_couns_reqd_yn					=	"";	
			String dosage_type						=   "";
			String dosage_unit						=   "";
			String std_dose                         =   "";
			String drug_remarks						=	"";
			String prn_remarks						=	"";
			String pharma_remarks					=	"";		
			String pres_remarks						=	"";
			String remarks_style					=	"";
			String slidingscaleremarks				=   "";
			String verificationremarks				=	"";
			String title_remarks					=	"";
			String pres_details						=	"";
			String drug_verf_reqd_yn				=	"N";
			String order_line_status				=	"";
			String drug_style						=	"";
			String alt_external_prod_id				=   "";
			String expired_yn			            =	"";
			String tmp_bms_qty_1					=	"";
			String alt_drug							=	"";
			String qty								=	null;
			String main_strength_per_value_pres_uom =   "";
			String sDispDrugAuthYN				= "N";
			String home_med_yn = null;//Added for Bru-HIMS-CRF-093-DD1[IN047223]
			String barcode_id = "";//Added for KDAH-CRF-0231 [IN-034551] 
			String drug_desc = "";//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
			String disc_cancelled_orders="", appl_for_compounding_rx_yn="",disc_cancelled_orders_display="display:none;", disp_mnf_flag	= "display:none"; //Added for HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080

		/*==================code for variable UOM==============================*/
			HashMap IssueUOMAndBaseUOM     = new HashMap();
			HashMap IssueUomQty			   = new HashMap();
			HashMap hmEditLabelValues      = new HashMap();
			ArrayList alEditLabelPair	   = new ArrayList();

			String issue_qty_value		   = "";	  
			String issue_uom_desc          = ""; 
			String dflt_issue_uom		   = "";
			String base_uom				   = "";
			String issue_uom			   = "";
			String issue_uom_equl          = "";
			String strength_uom_disp        = "";
			double base_to_disp_uom_equl   = 0;
			double base_to_def_uom_equl    = 1;
			double issue_qty_val		   = 0;
			double conv_factor			   = 1;
			StringBuffer issue_qty_dtl     = new StringBuffer();

		/*=====================================================================*/
			StringTokenizer		token				=	null;
			ArrayList disp_info						=	new ArrayList(2);
			float dialog_height						=	0;	
			float main_pack_size					=   0;
			float		main_drug_pack_size			=	0;	
			int recCount							=	1;
			double tmp_alloc						=	0;
			HashMap drug_detail						=	null;
			ArrayList multi_detail					=	null;
			ArrayList main_detail					=	null;
			HashMap   alt_detail					=	null;
			ArrayList alt_drug_detail				=	null;
			ArrayList multi_drugs					=	null;
			HashMap hm								=	null;
			ArrayList alt_qty						=	null;
			ArrayList	colors						=	new ArrayList();
			ArrayList tmp							=	null;
			HashMap pack_dtls						=	null;
			float tot_tap=0; //Added for RUT-CRF-0088 [IN036978]
			String currentdateplusAllocatePeriod		=  	"";			//added by Ganga for ML-BRU-SCF-0905 [IN:041285]
			boolean	endDateIsbeforAllocatedate			= 	false;//added by Ganga for ML-BRU-SCF-0905 [IN:041285]


			colors.add("#FF0000");
			colors.add("#669900");
			colors.add("#FF9966");
			colors.add("#6699CC");
			colors.add("#FF0000");
			colors.add("#669900");

			ArrayList result		=	null;
			ArrayList orderLineDtls	=	new ArrayList();
		//Declaration ends

			String	bean_id						=	"DispMedicationAllStages" ;
			String	bean_name					=	"ePH.DispMedicationAllStages";
			DispMedicationAllStages bean		= (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request);
			bean.setLanguageId(locale);
			
			String	bean_id_1					=	"DispMedicationBean" ;
			String	bean_name_1					=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1,request);
			bean_1.setLanguageId(locale);

			String disp_stage					=	bean_1.getDispStage();
			String facility_id					= (String) session.getValue("facility_id");
			String param_bean_id				= "@DrugInterfaceControlBean";
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
			param_bean.clear();

			String Image_bean_id				= "@DrugTradeImageBean";
			String Image_bean_name				= "ePH.DrugTradeImageBean";
			DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );
			ArrayList listRecord				= new ArrayList();  // Added for KAUH-SCF-0094 [IN:035252] -- begin
			String	bean_id_st		   			= "batchSearchBean" ;
			String	bean_name_st		   		= "eST.BatchSearchBean"; 
			
			String stSalseBean_id				=    "salesBean";//Added for AMS-CRF-0068.1 [IN:050333] start
			String stSalseBean_name			    =    "eST.SalesBean";
			SalesBean stSalseBean				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );//Added for AMS-CRF-0068.1 [IN:050333] -end
			String medplan_bean_id="MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
			String medplan_bean_name="ePH.MedicationPlannerBean";// Added for Bru-HIMS-CRF-072.1[IN 049144]
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean_1.setObject(medplan_bean);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			String primary_lang_id = medplan_bean.getStrPrimaryLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			String loc_lang_id = medplan_bean.getStrLocalLangID();//Added for Bru-HIMS-CRF-072.1[IN 049144]
			request.setAttribute("p_list_all_trades_yn","Y");
			BatchSearchBean bean_st				= (BatchSearchBean) getBeanObject( bean_id_st,bean_name_st,request );
			bean_st.setLanguageId(locale); 		// Added for KAUH-SCF-0094 [IN:035252] -- end
			String alt_drug_remarks_ind =bean_1.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
			String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]
			HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
			String totalTaperQtyDisplay = bean_1.getTotalTaperQtyDisplay();//Added for RUT-CRF-0088 [IN036978]
			String includeBMSDefCheck_yn= bean_1.getIncludeBMSDefCheck();//added for [IN:045055](Bru-HIMS-CRF-281[IN:033166])
			int count=0;
			String strIncludeZeroQty    = bean_1.getStrIncludeZeroAllocQtyItems();//Added for MO-GN-5434 [IN:043669]
			String allow_amend_alt_drug_dtl     =   bean_1.getAmendAltDrugDtlYN();  // Added for JD-CRF-0198 [IN058599]
			String strAllocBMSChkValue = "N";//Added for MO-GN-5434 [IN:043669]
			String strAllocBMSChecked = "";//Added for MO-GN-5434 [IN:043669]		
		    String showZeroQtyCheckBox = "";
			String showOtherEditLables = "";
			String strAutoCompletePartialDisp	= 	bean_1.getAutoCompletePartialDisp(); 	// Added for JD-CRF-0179 [IN:41211]
			/** Stock Bean Integration -Start ***/
			String	bean_id_2		=	"StUtilities" ;
			String	bean_name_2		=	"eST.Common.StUtilities";
			StUtilities bean_2=null;
			StringBuffer drugs_remarks  = null ;//Bru-HIMS-CRF-416[IN045566] 
			String strDrugsRemarks="";//Bru-HIMS-CRF-416[IN045566] 
			try { 
				bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
				bean_2.setLanguageId(locale);
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
			String st_no_of_decimals ="",  st_disp_decimal_dtls_yn="", st_allow_decimals_yn="N"; //Added for AAKH-SCF-0113 [IN:048937] start
			st_no_of_decimals = bean.getSt_no_of_decimals();
			st_disp_decimal_dtls_yn =bean.getSt_disp_decimal_dtls_yn(); // Added for AAKH-SCF-0113 [IN:048937] -end

			String disp_locn_catg	=	bean_1.getDispLocnCatg();
			String patient_class	=	"";
			int adr_count			=   0;
			ArrayList	stk_units	=	new ArrayList();
			String orig_dflt_issue_uom		= "";

			/*if(disp_locn_catg.equals("I")) {
				patient_class	=	"IP";
			} else {
				patient_class	=	"OP";
			}*/
			bean.loadReason();
			bean.setModuleId("2");
			bean.setPractitionerID(pract_id);
			bean.setPractitionerName(pract_name);
			
			String module_id			=	bean.getModuleId();
			Hashtable param_legends		=	bean_1.getLegendsFromParam();
			//String issue_token			=	bean_1.getIssueTokenOnRegnYN();
			String stages				=	bean_1.getStageDisplaySequence();
			String curr_stage			=	bean_1.getDispStage();
			String disp_level			=	bean_1.getDispLevelValue();
			String order_type			=   bean_1.getOrderType();
			ArrayList	delivery_det	=	bean_1.getDeliveryDetails();
			String legend               =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompleteOrderReason.label","ph_labels"); //"Complete Order Reason";
				   scope				=	bean_1.getScope();
			String visibility1          =   "visibility:hiiden";
			String visibility2          =   "visibility:hiiden";
			if(scope.equals("H")){
				legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ResultLineStatus.label","ph_labels");//"ResultLineStatus";
				visibility2          =   "visibility:hiiden";
				visibility1          =   "visibility:visible";
			}
			else{
				visibility1          =   "visibility:hiiden";
				visibility2          =   "visibility:visible";
			}

			if(delivery_det!=null && delivery_det.size() > 1) {
				//butt_status			=	"disabled";
				del_data			=	"found";
			}

			token = new StringTokenizer(stages,":");
			while(token.hasMoreTokens()){
				stage	=	(String)token.nextToken();
				if( stage.equals("F")) 
					filling_reqd = "Y";
				else if( stage.equals("D")) 
					delivery_reqd = "Y";
				else if( stage.equals("A")) 
					allocation_reqd = "Y";
				//else if( stage.equals("V")) 
					//verification_reqd = "Y";
			}

			filling_status				=	bean_1.getFillingStatus();
			if(filling_status.equals("A")) 
				display_seq	=	"A";
			else if(filling_status.equals("B"))
				display_seq	=	"F";

			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult = new ArrayList();

			if(bean_1.getAlTrxOrderIds()!=null)
				alOrderIds = bean_1.getAlTrxOrderIds();
			
			if(disp_level.equals("P")){
				//order lines of all orders
				result			=	bean_1.getOrders(patient_id.trim());
				if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR"))){ // CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					if(alOrderIds.size()>0)	{
						for(int i=0;i<result.size();i=i+11) {		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607  // //Modified for RUT-CRF-0088 [IN036978]  13 -> 11
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)	//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}

				tmp				=	new ArrayList();
				
				for(int i=0;i<result.size();i=i+11){		//10 ->11 for SKR-SCF-0330 ICN 29789 //11->13 RUT-CRF-0069 ICN29607  //Modified for RUT-CRF-0088 [IN036978]  13 -> 11
					tmp = (ArrayList)bean_1.getOrderLineDetails(patient_id,(String)result.get(i+1));
					if(tmp.size()!=0){
						orderLineDtls.add((String)result.get(i+1));
						orderLineDtls.add((String)result.get(i+3));
						orderLineDtls.add((String)result.get(i+4));
					
						for(int j=0; j<tmp.size(); j++)
							orderLineDtls.add(tmp.get(j));
					}
				}
			} 
			else{
				orderLineDtls = (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}
			ArrayList complete_reason_codes = (ArrayList)bean.getCompleteReasonCodes();

			String disp_delivery_chk_box			=   "checked";
			String disp_delivery_chk_box_val		=   "Y";
			String disp_delivery_chk_box_disabled	=   "";
			String  billing_interface_yn			=   bean.getBLInterfaceYN();//checkforbillinginterface();
			String width							=   "100%";
			String bl_encounter_id					=   bean_1.getEncounterID();
			String bl_display                       =   "Y"; 
			String ord_type						    =	bean_1.getOrderType();
			String sysdate							=   bean_1.getTodaysDate();
			String disp_locn_code			        =   bean_1.getDispLocnCode();
			float tot_gross_charge_amount			=   0;
			float tot_groos_pat_payable				=   0; 
			String tot_gross_charge_amount_str		=  "";
			String tot_groos_pat_payable_str		=  "";
			String gross_charge_amount_str			=  "";
			String groos_pat_payable_str			=  "";
			String decimalFormatString				=  "";
			String	batch_str						=  "";
			String image_path					    =  "";
			String trade_code					    =  "";
		//added during PE By Naveen
			String drug_db_product_id				=	"";
			String allergy_override_reason			=	"";
			String dosage_limit_override_reason		=	"";
			String duplicate_drug_override_reason	=	"";
			String interaction_override_reason		=	"";
			String contraind_override_reason		=	"";	
			String dischargeIND		=	"";	
			String strBMS_Include_yn ="N";// Added for [IN:045295]
		//ends here
		/*=================code for auto defaulting batches for normal RX===============*/
			String min_stk_flag	=	"display:none;align:right";//Added for AMS-CRF-0068.1 [IN:050333] -start
			String min_stk_flag_bkg_clr	=		"background-color:none";
			String rol_flag_bkg_clr		=		"background-color:none";
			String rol_flag			=		"display:none";
			String disp_req_flag	= "display:none;color:blue";
			
			boolean min_stk	= false;
			boolean rol_stk	= false;
			HashMap rol_min		= null;
			String frm_store_min_stk_level  = "";
			String frm_store_reorder_level =  "";
			String[] stParameters = {alt_drug_code, disp_locn_code, "0", "N", "", "N", "" };
			HashMap hmStockAvailabilityStatus = null;
			boolean Min_Rol_yn	=bean_1.getMin_Rol_yn();
			boolean getReq_allowed_yn =bean_1.getReq_allowed_yn(); //Added for AMS-CRF-0068.1 [IN:050333] -end
			boolean bEquivalentNormalOrder		= false;

			if(ord_type.equals("ALL") && result != null && result.size() >0 && result.get(8) == null)
				bEquivalentNormalOrder = true;

			String display_list = "";

			if(!((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I"))  ){
				display_list ="display:none" ;
			}

			ArrayList items					=	null;
			ArrayList alloc_drug_detail		=	null;
			HashMap batch_det				=	null;	
			ArrayList stock_det				=	null;
			HashMap	 stock					=	null;	
			String item_code				=	"";
			String store_code				=	"";
			String fill_period				=	null;
			String fill_unit				=	null;
			String item_cost				=   "";
			String issue_qty				=	"";
			String batch_issue_qty				=	""; //MMS-40
			double tmp_unit_qty				=	0;
			double tot_issued_qty			=	0;
			String avail_qty				=	"";
			String act_bms_qty				=	"";
			float opdispperiod				=	0;	
			String alloc_readonly			=   "";
			boolean item_uom_definition_flag = false;
			String billable_item_yn			=	"";
			//String  taper_order_yn, taper_order_id, taper_order_line_num, show_remarks, taper_disable;
			String show_remarks, taper_disable; //Added for RUT-CRF-0088 [IN036978]
			LinkedHashMap hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			ArrayList arrOrderId = new ArrayList();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			HashMap<String,String> altDrugName = new HashMap<String,String>();// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			String dosedet[] = new String[4],dosedetlocal[] = new String[4];// Added for Bru-HIMS-CRF-072.1 [IN:049144]
			String dispno[] = new String[2];// Added for Bru-HIMS-CRF-072.1 [IN:049144]

			if(ord_type.equals("CO")||ord_type.equals("IVAA")||ord_type.equals("IVIA")||ord_type.equals("CA")||ord_type.equals("TA")){
				bl_display      =   "N";        
			}
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
				width			=   "115%"; 
				patient_class   =   bean.getEncounterPatientClass(bl_encounter_id, patient_id);  // patient_id  added for [IN:035667] 
			}
			String pres_qty_alert = bean_1.getPresQtyAlert();//code added for AMS-CRF-0035[IN033551] 
			String barcodeScan = ""; // Added for GHL-CRF-0463 - Start
			String last_scanned   ="";
			if(bean_1.getBarcode_id().equals("") && bean_1.getOrderType().equals("NOR")){
			   barcodeScan=bean_1.getBarcode_Scan_YN(); 
			   last_scanned = bean_1.getScannedBarcode_id();
			}// Added for GHL-CRF-0463 - End
%>
			<input type="hidden" name="alloc_fromBarCode" id="alloc_fromBarCode" value="N"> <!-- added for KDAH-CRF-0231 [IN-034551]  -->
			<input type="hidden" id="barcode_scan_yn" value="<%=barcodeScan%>"> <!-- Added for GHL-CRF-0463 -->
			<input type="hidden" id="last_scanned" value="<%=last_scanned%>"> <!-- Added for GHL-CRF-0463 -->
			<table cellpadding="0" cellspacing="0" width='<%=width%>' align="center" border="1"  id="verificationTable">
				<tr>
					<td class= "COLUMNHEADER" width="6%" style="font-size:9"><%=param_legends.get("V")%> <fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER" width="3%" style="font-size:9">&nbsp;</td>
					<td class= "COLUMNHEADER" width="41%" style="font-size:9"><fmt:message key="ePH.Drug/DosageDetails.label" bundle="${ph_labels}"/></td>
					<td class= "COLUMNHEADER" style="font-size:9" width="2%">&nbsp;</td>
					<td class= "COLUMNHEADER" style="font-size:9" width="2%">&nbsp;</td>
					<td class= "COLUMNHEADER" width="9%" style="font-size:9"><fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/></td>
					<td align="right" class="COLUMNHEADER" width="9%" style='<%=display_list%>'><fmt:message key="ePH.ISSUEUOM.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td class= "COLUMNHEADER" width="9%" style="font-size:9"><fmt:message key="ePH.AllocatedQuantity.label" bundle="${ph_labels}"/></td>
					<td class= "COLUMNHEADER" width="9%" style="font-size:9"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/></td>
<% 		
					if(billing_interface_yn.equals("Y") &&bl_display.equals("Y")){
%>		
						<td class= "COLUMNHEADER" width="10%" style="font-size:9"><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9"><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/></td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9"><fmt:message key="ePH.OverrideIncl/Excl.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>  
<%
					}      
					if(delivery_reqd.equals("Y")) { 
%>
						<td class= "COLUMNHEADER" width="8%" style="font-size:9" align="center"><%=param_legends.get("D")%></th>
<%
					}

					allocate_button = "<td class= 'COLUMNHEADER' width='10%' style='font-size:9' align='center'>"+param_legends.get("A")+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>";
					filling_button	="<td class= 'COLUMNHEADER' width='8%' style='font-size:9' align='center'>"+param_legends.get("F")+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>";

					if(display_seq.equals("A")) { 
						if(allocation_reqd.equals("Y")) 
							out.println(allocate_button);
						if(filling_reqd.equals("Y")) 
							out.println(filling_button);
					} 
					else	{ 
						if(filling_reqd.equals("Y"))  
							out.println(filling_button);
						if(allocation_reqd.equals("Y")) 
							out.println(allocate_button);
					}
%>
					<td class= "COLUMNHEADER" width="10%" style="font-size:9"><%=legend%></th>
				</tr>
<%
				String sRepeatFreqCode		   = null;
				String sFreqCode			   = null;
				boolean bPRNOrAbsOrder		   = false;
				boolean bDrugOrder			   = true;
				String disable_alloc_text_box  =  "";
				String iv_prep_yn  =  "";

				Set stDrugCodes				= new HashSet();
				for(int i=0;i<orderLineDtls.size(); i++){
					bDrugOrder			= true;
					sRepeatFreqCode		= "";
					sFreqCode			= "";
					if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
					else
					classvalue = "QRYEVEN" ;

					hold_value			=	"";
					title_remarks		=	"";
					hold_status			=	"";
					pres_strength		=	"";
					tot_qty				=	0;
					stock_opt			=	new ArrayList();
					alloc_strength		=	"";
					tmp_alloc			=	0;
					title				=	"";
					narc_style			=	"";
					pres_details		=	"";

					if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
						order_id			=	(String)orderLineDtls.get(i);
						//ordered_by	=	(String)orderLineDtls.get(++i);
						++i;
						//location		=	(String)orderLineDtls.get(++i);
						++i;
						++i;
					}

					allergy					=	(String)orderLineDtls.get(i);
					exceed_dose				=	(String)orderLineDtls.get(++i);
					++i;
					drug_code				=	(String)orderLineDtls.get(++i);
					drug_name				=	(String)orderLineDtls.get(++i);
					dosage_dtls				=	(String)orderLineDtls.get(++i);
					++i;
					end_date				=	(String)orderLineDtls.get(++i);
					pres_qty				=	(String)orderLineDtls.get(++i);
					qty_uom					=	(String)orderLineDtls.get(++i);
					qty_uom_disp			=	(String)orderLineDtls.get(++i);
					order_line_no			=	(String)orderLineDtls.get(++i);
					generic_id				=	(String)orderLineDtls.get(++i);

					if(generic_id.equals("MEDICALITEM"))
						bDrugOrder			= false;

					generic_name			=	(String)orderLineDtls.get(++i);
					dosage_details			=	(String)orderLineDtls.get(++i);
					bms_qty					=	(String)orderLineDtls.get(++i);
					act_bms_qty				=   bms_qty;
					source_code				=	(String)orderLineDtls.get(++i);
					source_type				=	(String)orderLineDtls.get(++i);
					ordering_facility_id	=	(String)orderLineDtls.get(++i);
					ord_date_time			=	(String)orderLineDtls.get(++i);
					performing_pract_id		=	(String)orderLineDtls.get(++i);
					duplicate_yn			=	(String)orderLineDtls.get(++i);
					min_dose_dtls			=	(String)orderLineDtls.get(++i);
					alloc_qty_from_tmp		=	(String)orderLineDtls.get(++i);
					strength_value			=	(String)orderLineDtls.get(++i);
					strength_uom			=	(String)orderLineDtls.get(++i);
					strength_uom_disp		=	(String)orderLineDtls.get(++i);
					trade_code				=	(String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);

					currentdateplusAllocatePeriod		=  	com.ehis.util.DateUtils.plusDate(sysdate,"DMY",locale,Integer.parseInt(bean_1.getFillPeriod()),"d").toString();  //Added for ML-BRU-SCF-0905 [IN:041285] -Start
					if(end_date.length() >=10)
						end_date		=	end_date.substring(0,10);
					endDateIsbeforAllocatedate			=  	com.ehis.util.DateUtils.isBefore(end_date,currentdateplusAllocatePeriod,"DMY",locale);
					if(!endDateIsbeforAllocatedate){
						end_date=currentdateplusAllocatePeriod;
					}//Added for ML-BRU-SCF-0905 [IN:041285]ended
					// For Multi Frequency 

					sRepeatFreqCode			=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[0];
					sFreqCode				=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[1];

					stDrugCodes.add(drug_code); // to Add drug codes for authorization check
					bean.setStockItems(drug_code,stock_opt); //MMS-SCF-417 and BSP-SCF-0041
					if(generic_id.equals("MEDICALITEM")){
						drug_trade_bean.setDrugyesno("");
					}
					else{
						drug_trade_bean.setDrugyesno("Y");
					}
					image_path				=  drug_trade_bean.getImagePath(drug_code,trade_code);
					pack_dtls			    =	bean.getPackSize(drug_code);
					main_drug_pack_size = 0;
					if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
						if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
							main_drug_pack_size		=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));						
						}		
					}
					bean.setOrderDetails(order_id+order_line_no,end_date);

					alt_drug				=	bean.checkMultiStrength(drug_code);
					//pat_couns_reqd_yn       =   bean.getPatCounsReqdyn(order_id, order_line_no);
					bmscount                =   bean.CheckBMSYN(order_id, order_line_no);

					bean.addDrugs(patient_id,order_id,drug_code,alt_drug,order_line_no);
					pres_details			=	bean.getPresDetails(order_id);
					if(order_type.equals("IVI") || order_type.equals("CA"))
						strChangedFludRmks =	bean.getChngdFluidRemarks(order_id,order_line_no);
					else
						strChangedFludRmks =	"";

					if(strChangedFludRmks != "" && strChangedFludRmks != null)
						classvalue = "FLUDCOLOR";
					stock_opt =(ArrayList)bean.getStockItems(drug_code);
					if(module_id.equals("2")&&stock_opt.size()==0) {
						token	=	new StringTokenizer((String)orderLineDtls.get(++i),"|");
						while(token.hasMoreTokens()){
							stock_opt.add((String)token.nextToken());
						}
					}
					else{
						++i;
					}

					ext_prod_id=(String)orderLineDtls.get(++i);
					bean.setStockItems(drug_code,stock_opt);

					/*if(!strength_value.equals("0"))
					strength	=	strength_value+" "+strength_uom;*/

					//code added for in_formulary_yn ..added on 25/4/2004
					in_formulary_yn			=	((String)orderLineDtls.get(++i)).trim();
					if(in_formulary_yn.equals("N")){
						classvalue			=	"FORMULARY";
						disable_alloc_text_box ="disabled";
					}
					else{
						disable_alloc_text_box ="";
					}

					// IV_PREP_YN
					iv_prep_yn = (String)orderLineDtls.get(++i);
					//if( (((String)orderLineDtls.get(++i)).trim()).equals("N")) {
					if(iv_prep_yn!=null && iv_prep_yn.trim().equals("N")) {
						if(order_line_no.equals("1")){
							classvalue="IVFLUID";
						}
						else{
							classvalue="IVINGREDIENT";
						}
					}

					//ended...

					// Drug class
					drug_class	=	(((String)orderLineDtls.get(++i)).trim());
					i=i+2;

					expired_yn  = (String)orderLineDtls.get(++i);

					if(expired_yn.equals("Y"))
						classvalue="EXPIRED_MEDICATION";
					drug_verf_reqd_yn = (String)orderLineDtls.get(++i);
					order_line_status = (String)orderLineDtls.get(++i);
					main_strength_per_value_pres_uom = (String)orderLineDtls.get(++i);

					i++;
					String sOrderType = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
					i++;
					String sAbsOrder  = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();

					if(sOrderType.equals("P") || sAbsOrder.equals("N"))
						bPRNOrAbsOrder = true;
					else
						bPRNOrAbsOrder = false;

					drug_style        = "cursor:pointer;color:blue";
					String current_order_line_status = order_line_status;//for 61540
					order_line_status ="VF";
					if(!bean_1.getVerfCombinedWithAlloc().equals("C")){
						if(drug_verf_reqd_yn.equals("Y")){
							if(order_line_status.equals("VF")){
								disp_delivery_chk_box_disabled  ="";
								disp_delivery_chk_box_val		="Y";
								disp_delivery_chk_box			="checked";
							}
							else{
								disp_delivery_chk_box_disabled  ="disabled";
								disp_delivery_chk_box_val		="N";
								disp_delivery_chk_box			="";
								drug_style="color:red;FONT-WEIGHT: BOLDER";
							}					
						}
						else{
							disp_delivery_chk_box_disabled  ="";
							disp_delivery_chk_box_val		="Y";
							disp_delivery_chk_box			="checked";
						}
					}
					if(drug_class.equals("C") || drug_class.equals("N")) {
						narc_style	="color:brown";
						//title		= "title='Narcotic/Controlled Drugs'";
						String nar_cnt_drug = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NarcoticControlledDrugs.label","ph_labels");
						title		= "title='"+nar_cnt_drug+"'";
					}

					token	=	new StringTokenizer(dosage_details,":");

					if(token.hasMoreTokens()) {
						exceed_status	=	token.nextToken();
					}
					if(exceed_status.equals("Y")) {
						if(token.hasMoreTokens())
							monograph	=	token.nextToken();
						if(token.hasMoreTokens())
							unit_dose	=	token.nextToken();
						if(token.hasMoreTokens())
							daily_dose	=	token.nextToken();
						if(token.hasMoreTokens())
							dosage_type =token.nextToken();
						if(token.hasMoreTokens())
							dosage_unit =token.nextToken();
						if(token.hasMoreTokens())
							std_dose   =token.nextToken();
					}
					token	=	new StringTokenizer(min_dose_dtls,":");
					if(token.hasMoreTokens()) {
						min_unit_dose	=	token.nextToken();
						min_daily_dose	=	token.nextToken();
					}

					if(bean.checkHold(order_id,order_line_no)) {
						hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
						check_value				="Y";
						check_status			="checked";
						fromdb					="Y";
						remark_status			="visibility:visible";
					} 
					else {
						hm		= bean.loadHoldRemarks(order_id,order_line_no);
						if (!hm.isEmpty()){
							hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");

							check_value		="Y";
							check_status	="checked";
							fromdb			="Y";
							remark_status	="visibility:visible";
						}
						else{
							hold_text		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
							remark_status	="visibility:hidden";
							check_status	="";
						}
					}
					multi_drugs	=	bean.getMultiDrugs(patient_id,order_id,order_line_no);	
					alt_drug_remarks_disp="";
					if(multi_drugs.size()>0){
						if(alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")){//if block added for  Bru-HIMS-CRF-082 [IN:029948]
							alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+order_id+"','"+ order_line_no+"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
							if(alt_drug_remarks_ind.equals("M"))
								alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
						}
					}
					if(request.getParameter("resetQty")== null)
						qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
					else
						qty				= "";
					//				qty			=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
					HashMap Order_id_amend_yn =(HashMap)bean_1.getOrder_id_amend_yn();
					if(Order_id_amend_yn.containsKey(order_id)){
						Order_id_amend_yn.remove(order_id);
						qty			=  "";
					}
					if(!qty.equals("") && !qty.equals("0") && multi_drugs.size() < 1)
						tot_qty				+=	Double.parseDouble(qty);

					alt_drug_qty			=	"";
					for(int n=0; n<multi_drugs.size(); n+=5)	{ 
						alt_drug_code	=	(String)multi_drugs.get(n);
						alt_drug_qty	=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
						if(!alt_drug_qty.equals(""))
							break;
					}
					if( (!qty.equals("") && !qty.equals("0")) || (!alt_drug_qty.equals("") && !alt_drug_qty.equals("0")) )
						hold_status	="disabled";

					/*if(verification_reqd.equals("")) {
					hold_status			=	"disabled";
					hold_value			=	"E";
					}*/


					/*-----code for displaying drug remarks---------------*/
					/* drug_remarks	    = "";
					prn_remarks		    = "";
					pharma_remarks	    = "";		
					pres_remarks        = "";
					slidingscaleremarks ="";
					remarks_style       = "";
					dialog_height       = 0;

					pres_remarks		= bean.getPrescriptionInstructions(order_id);
					drug_remarks		= bean.getDrugInstructions(order_id,order_line_no);
					prn_remarks			= bean.getPRNInstructions(order_id,order_line_no);
					pharma_remarks		= bean.getPharmacistInstructions(order_id,order_line_no,"Y");
					slidingscaleremarks	= bean.getSlidingScaleRemarks(order_id,order_line_no);
					verificationremarks	= bean.getVerificationRemarks(order_id,order_line_no);
					HashMap overridereason =(HashMap)bean.getOverrideremarks(order_id,order_line_no);
					String	show_remarks = "N";
					if(drug_db_interface_yn.equals("Y") && overridereason.containsKey("DRUG_DB_PRODUCT_ID")){
					if(overridereason.size()>1){
					show_remarks="Y";
					}			
					}else{
					if(overridereason.size()>0){
					show_remarks="Y";
					}
					}
					*/
					pres_remarks					=   bean.getPrescriptionInstructions(order_id);
					drug_remarks					=   bean.getDrugInstructions(order_id,order_line_no);
					prn_remarks						=   (String)orderLineDtls.get(++i);
					pharma_remarks					=    bean.getPharmacistInstructions(order_id,order_line_no,"Y");
					slidingscaleremarks				=   (String)orderLineDtls.get(++i);
					verificationremarks				=   (String)orderLineDtls.get(++i);             
					drug_db_product_id				=	(String)orderLineDtls.get(++i);
					allergy_override_reason			=	(String)orderLineDtls.get(++i);
					dosage_limit_override_reason	=	(String)orderLineDtls.get(++i);
					duplicate_drug_override_reason	=	(String)orderLineDtls.get(++i);
					interaction_override_reason		=	(String)orderLineDtls.get(++i);		  
					contraind_override_reason		=	(String)orderLineDtls.get(++i);
					pat_couns_reqd_yn		        =	(String)orderLineDtls.get(++i);//from order_line_PH
					pt_couns_reqd_yn		        =	(String)orderLineDtls.get(++i);//from PH_drug
					billable_item_yn		        =	(String)orderLineDtls.get(++i);//from PH_drug
					dischargeIND		        =	(String)orderLineDtls.get(++i);//from OR_ORDER
					strBMS_Include_yn				=	(String)orderLineDtls.get(++i);// Added for [IN:045295]
					home_med_yn 					= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-093-DD1[IN047223]
					drug_desc 				= 	(String)orderLineDtls.get(++i);//Added for Bru-HIMS-CRF-414 ML-BRU-SCF-1454 [IN:052271]
					disc_cancelled_orders		= 	(String)orderLineDtls.get(++i);//Added for  HSA-CRF-0138 [IN:048414] 
					appl_for_compounding_rx_yn 	= 	(String)orderLineDtls.get(++i);//Added for  Bru-HIMS-CRF-080
					if("Y".equals(appl_for_compounding_rx_yn)){
						disp_mnf_flag = "display:inline;color:blue";
					}
					if(!disc_cancelled_orders.equals("")) //Added for  HSA-CRF-0138 [IN:048414] - start
						disc_cancelled_orders_display="display:inline";
					else
						disc_cancelled_orders_display="display:none"; //Added for  HSA-CRF-0138 [IN:048414] end
					/*Commented for RUT-CRF-0088 [IN036978] 
					taper_order_yn 					=	(String)orderLineDtls.get(++i);//from OR_ORDER
					taper_order_id					=	(String)orderLineDtls.get(++i);//from OR_ORDER
					taper_order_line_num					=	(String)orderLineDtls.get(++i);//from OR_ORDER
					if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){
						taper_disable = "disabled";
						alloc_qty_from_tmp="0"; //added to avoid displaying qty for tapered drugs
					}
					else*/
						taper_disable="";

					show_remarks = "N";
					if(!alloc_qty_from_tmp.equals("") && !alloc_qty_from_tmp.equals("0")) {
						if(bean.getFirstTime(order_id).trim().equals("true")) {
							drug_detail		=	bean.getDB_DrugDetail(order_id,order_line_no,end_date);
							multi_detail	=	(ArrayList)drug_detail.get("multi_detail");
							main_detail		=	(ArrayList)drug_detail.get("main_detail");
							alt_detail		=	(HashMap)drug_detail.get("alt_detail");
							if(multi_detail.size()==0) {
								bean.setDrugDetail(patient_id,order_id,order_line_no,main_detail);
								bean.setDrugQuantity(patient_id,order_id,order_line_no,Integer.parseInt(alloc_qty_from_tmp));
							} 
							else if(multi_detail.size()!=0) {
								bean.setMultiDrugs(patient_id,order_id,order_line_no,multi_detail);	
								for(int no=0; no<multi_detail.size(); no+=5) {
									alt_drug_code		=	(String)multi_detail.get(no);
									alt_drug_detail		=	(ArrayList)alt_detail.get(alt_drug_code);
									bean.setAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_detail,alt_drug_code);
								}							
							}
							bean.setFirstTime(order_id,false);
						}
					}

					if(!allergy_override_reason.equals("")||!dosage_limit_override_reason.equals("")||!duplicate_drug_override_reason.equals("")||!interaction_override_reason.equals("")||!contraind_override_reason.equals("")){
						show_remarks="Y";
					}
					drugs_remarks = new StringBuffer(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PractitionerPharmacistInstructions.label","ph_labels")+" : \n"); //code added for Bru-HIMS-CRF-416[IN045566]-- Start								
					if(!pres_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PrescriptionInstructions.label","ph_labels")+" : "+pres_remarks.trim()+"\n");
					if(!slidingscaleremarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SlidingScaleRemarks.label","ph_labels")+" : "+slidingscaleremarks.trim()+"\n");
					if(!allergy_override_reason.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllergyOverrideReason.label","common_labels")+" : "+allergy_override_reason.trim()+"\n");		
					if(!duplicate_drug_override_reason.trim().equals("")){
					   if(drug_db_product_id != null  && !drug_db_product_id.equals(""))
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DuplicateTheraphyOverrideReason.label","ph_labels")+" : "+duplicate_drug_override_reason.trim()+"\n");
						else
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DuplicateDrugOverrideReason.label","ph_labels")+" : "+duplicate_drug_override_reason.trim()+"\n");
					}
					if(!dosage_limit_override_reason.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DosageOverrideReason.label","ph_labels")+" : "+dosage_limit_override_reason.trim()+"\n");
					if(!interaction_override_reason.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugInteractionOverrideReason.label","ph_labels")+" : "+interaction_override_reason.trim()+"\n");	
					if(!contraind_override_reason.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ContraIndicationOverrideReason.label","ph_labels")+" : "+contraind_override_reason.trim()+"\n");								
					if(!drug_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugInstructions.label","ph_labels")+" : "+drug_remarks.trim()+"\n");
					if(!prn_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PRNInstructions.label","ph_labels")+" : "+prn_remarks.trim()+"\n");						
					if(!pharma_remarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Pharmacist.label","ph_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Instructions.label","common_labels")+" : "+pharma_remarks.trim()+"\n");
					if(!verificationremarks.trim().equals(""))
						drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.VerificationRemarks.label","ph_labels")+" : "+verificationremarks.trim()+"\n");		//code added for Bru-HIMS-CRF-416[IN045566]-- End
		
					if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("")&& show_remarks.equals("N")){
						remarks_style	=	"style='visibility:hidden'";
						drugs_remarks.setLength(0);
					} 
					else {
						strDrugsRemarks = drugs_remarks.toString();
						strDrugsRemarks=strDrugsRemarks.replaceAll(" ","%20");
						strDrugsRemarks = java.net.URLEncoder.encode(strDrugsRemarks,"UTF-8");
						strDrugsRemarks=strDrugsRemarks.replaceAll("%2520","%20");
						dialog_height = 0 ;
						if(!prn_remarks.trim().equals(""))
							dialog_height	 += 6.5;

						if(!drug_remarks.trim().equals(""))
							dialog_height	 += 6.5;

						if(!pres_remarks.trim().equals(""))
							dialog_height	 += 6.5;

						if(!pharma_remarks.trim().equals(""))
							dialog_height	 += 6.5;

						if(!slidingscaleremarks.trim().equals(""))
							dialog_height	 += 6.5;

						if(!verificationremarks.trim().equals(""))
							dialog_height	 += 6.5;
						if(show_remarks.equals("Y"))
							dialog_height	 += 13;

						remarks_style	=	"style='visibility:visible'";
						if(dialog_height>18) 
							dialog_height = dialog_height-4;
						if(dialog_height==18) 
							dialog_height = dialog_height-3;
						if(dialog_height==12) 
							dialog_height = dialog_height-1;

						dialog_height	 += 1.4;					
					}
					/*-------------------------ends------------------------*/	

					tmp_bms_qty				=	bms_qty;
					main_pack_size			=   0;
					if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
						if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
							main_pack_size	=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));	
							tmp_bms_qty_1		=   Float.parseFloat(tmp_bms_qty)*main_pack_size+"";
						}		
					}
					else{
						tmp_bms_qty_1		=   tmp_bms_qty;
					}
					adr_count = bean.getADRCount(patient_id,drug_code);
					/*==============code for getting defult batches====================================*/

					items			=  (ArrayList)bean.loadItems(drug_code);
					if(items.size()>0){
						item_code     =   (String)items.get(0);
					}
					store_code	=	bean_1.getStoreCode();

					/*if(end_date.length() >=10)
						end_date		=	end_date.substring(0,10);*/
					Float fTotalDuration = Float.parseFloat(bean_1.getDurationValue(order_id+order_line_no));
					//opdispperiod  =  bean_1.getopdispperiod( disp_locn_code);
					opdispperiod  = Float.parseFloat(bean_1.getFillPeriod());

					// For Multi Frequency
					String sOrigDispUnit	= bean_1.getStrChangedDispenseUnit() != null?bean_1.getStrChangedDispenseUnit():"D";
					String sOrigDispPeriod	= bean_1.getStrChangedDispensePeriod() != null?bean_1.getStrChangedDispensePeriod():"1";
					if(sRepeatFreqCode.equals("W")){
						if(sOrigDispUnit.equals("H"))
							opdispperiod = new Float(Math.ceil((opdispperiod/(24*7)))*7); // divide by 24 to make day and divide by 7 to convert to week and ceil it.
						else if(sOrigDispUnit.equals("D"))
							opdispperiod = new Float(Math.ceil((opdispperiod/7))*7);
						else if(sOrigDispUnit.equals("M"))
							opdispperiod = new Float(Integer.parseInt(sOrigDispPeriod)*4*7);
					}
					else if(sRepeatFreqCode.equals("M")){
						if(sOrigDispUnit.equals("H"))
							opdispperiod = new Float(Math.ceil((opdispperiod/(24*30)))*30);
						else if(sOrigDispUnit.equals("D"))
							opdispperiod = new Float(Math.ceil((opdispperiod/30))*30);
						else if(sOrigDispUnit.equals("W"))
							opdispperiod = new Float(Math.ceil((opdispperiod/4))*30);
					}

					if(sFreqCode.equals("H"))
						fTotalDuration = fTotalDuration/24;
					else if(sFreqCode.equals("W"))
						fTotalDuration = fTotalDuration*7;
					else if(sFreqCode.equals("L"))
						fTotalDuration = fTotalDuration*30;
					else if(sFreqCode.equals("Y"))
						fTotalDuration = fTotalDuration*365;

					if(bean.checkHold(order_id,order_line_no)|| scope.equals("H")){
						alloc_readonly ="disabled";  
					}
					else{
						alloc_readonly ="";  
					}
					tot_issued_qty  =0;
					/*=============code added to handle if dispense uom and default uom in item store is different and variable UOM==========*/
					IssueUOMAndBaseUOM		 =	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code);
					base_to_disp_uom_equl	 =	0;
					base_to_def_uom_equl	 =	1;

					HashMap issue_uom_qty_hm =  bean.getIssueUomQty();

					dflt_issue_uom = "";
					if(issue_uom_qty_hm.size()>0){
						if(issue_uom_qty_hm.containsKey(order_id+order_line_no+drug_code+"_uom")){
							dflt_issue_uom = (String)issue_uom_qty_hm.get(order_id+order_line_no+drug_code+"_uom");
						}
					}
					if(dflt_issue_uom.equals("") || request.getParameter("resetQty")!= null)
						dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");

					base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM");
					base_to_disp_uom_equl    =	bean.getEqulValue ( item_code, base_uom, qty_uom);

					orig_dflt_issue_uom		= (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
					st_allow_decimals_yn	= CommonBean.checkForNull((String)IssueUOMAndBaseUOM.get("ALLOW_DECIMALS_YN")); //  Added for AAKH-SCF-0113 [IN:048937] 
					base_to_def_uom_equl	 =  bean.getEqulValue ( item_code, base_uom, orig_dflt_issue_uom);

					/*=======================ends here=========================================================================================*/
					if(request.getParameter("barcode_id")!=null){ //Added for KDAH-CRF-0231 [IN-034551]
						barcode_id = request.getParameter("barcode_id");
					}

					if(alt_drug_qty.equals("")&& ord_type.equals("NOR") && alloc_readonly.equals("")&& stock_opt.get(0).equals("N") && (!item_code.equals("")) && barcode_id.equals("")){//MMS-SCF-417 and BSP-SCF-0041
						qty = "";
					}
					if(qty.equals("") && alt_drug_qty.equals("")&& ord_type.equals("NOR") &&alloc_readonly.equals("")&& stock_opt.get(0).equals("Y") && (!item_code.equals("")) && barcode_id.equals("")) {//  && barcode_id.equals("") Added for KDAH-CRF-0231 [IN-034551]
						if(base_to_disp_uom_equl!=0 && base_to_def_uom_equl !=0){
							tmp_unit_qty    =	0;
							if(bPRNOrAbsOrder){
								tmp_unit_qty = Double.parseDouble(act_bms_qty);
							}
							else{
								fill_period	= bean_1.getFillPeriod();
								fill_unit		= bean_1.getFillUnit();
								item_cost       ="";
								//tot_issued_qty  =0;
								issue_qty       ="";

								float per_day	=Integer.parseInt(pres_qty)/ fTotalDuration;
								//if(per_day < 1)  
								//	     per_day	=	1;

								if(disp_locn_catg.equals("I")){
									if(fill_unit.equals("H") && !fill_period.equals("")) {
										//					tmp_unit_qty	=	new Float((Integer.parseInt(fill_period) / 24 )* per_day).intValue();				
										tmp_unit_qty	=	new Float((opdispperiod / 24 )* per_day).doubleValue();	
									}
									else if(fill_unit.equals("D")) {
										//tmp_unit_qty	=	new Float((Integer.parseInt(fill_period) * per_day)).intValue();
										tmp_unit_qty	=	new Float((opdispperiod * per_day)).doubleValue();
									}
								}
								else{
									if(opdispperiod!=0){
										tmp_unit_qty= new Float(Math.ceil(per_day*opdispperiod)).doubleValue();
									}
									else{
										tmp_unit_qty=new Float(Integer.parseInt(pres_qty)).doubleValue();
									}
								}
								if(tmp_unit_qty > Double.parseDouble(act_bms_qty) ){
									tmp_unit_qty =Double.parseDouble(act_bms_qty);
								}
							}
							/*==========code added to handle if dispense uom and default uom in item store is different=================*/
							 if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ // condition Added for [IN:064158] - Start
								  tmp_unit_qty=0;  
							  } // condition Added for [IN:064158] -End

							issue_qty_val			 =  0;
							if(base_to_disp_uom_equl!=base_to_def_uom_equl){
								conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
								issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
								issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
								//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+""); //moved from common to  specific  MMS-SCF-0040 [IN:041888] // commented for IN:6585
								issue_qty_val  =  new Float(Math.ceil(issue_qty_val*base_to_def_uom_equl)).doubleValue(); //Added for  MMS-SCF-0040 [IN:041888] 
								bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+""); // Added for IN:6585
							}
							else{
								 if(qty_uom!=base_uom){   //if block and else condition added for SKR-SCF-0377 [IN:030453]
									 conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
									 issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
								 }
								 else{ 
									  issue_qty_val  = tmp_unit_qty;	
								 }	
								bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+""); //Moved from common to specific for  MMS-SCF-0040 [IN:041888]
							}                   

							//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+""); //Commented for  MMS-SCF-0040 [IN:041888]
							//bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+"");//Commented for  MMS-SCF-0040 [IN:041888]
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",dflt_issue_uom);
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",bean.getUOMDesc ( dflt_issue_uom));
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",base_to_def_uom_equl+"");

							//item_cost				=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);
							HashMap params			=	new HashMap();
							if( !(trade_code.equals(""))){
								params.put("ITEM_CODE",item_code+"="+trade_code); 	
							}
							else{
								params.put("ITEM_CODE",item_code);
							}
							params.put("STORE_CODE",store_code);
							params.put("TRN_QTY",issue_qty_val+"");
							params.put("INCLUDE_SUSPENDED","FALSE");
							params.put("INCLUDE_EXPIRED","FALSE");
							params.put("CUT_OFF_DATE",end_date);
							params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
							params.put("ALREADY_USED_QTY","");
							params.put("MIN_EXP_DATE",end_date);
							stock				= (HashMap)bean_2.getBatches(params);
							if(stock.size()>0){
								stock_det           = (ArrayList)stock.get("BATCH_DATA");
								if(trade_code.equals("") && stock.containsKey("EXCEPTION")){ // Added for KAUH-SCF-0094 [IN:035252] -- begin When Trade and Stock is blank, Alternate trade should be taken 
									bean_st.setIncludeSuspendedBatches("N") ;
									bean_st.setIncludeZeroStockBatches("N") ;
									bean_st.setIncludeExpiredBatches("N") ;
									bean_st.setItem_code_from(item_code.trim()) ;
									bean_st.setItem_code_to(item_code.trim()) ;
									bean_st.setStore_code_from(store_code.trim()) ;
									bean_st.setStore_code_to(store_code) ;
									bean_st.setManufacturer_code("") ;
									bean_st.setPeriod_of_expiry("") ;
									bean_st.setBatch_id("%") ;
									bean_st.setTrade_Code("%") ;
									bean_st.setItemClassFrom("") ;
									bean_st.setItemClassTo("") ;
									bean_st.setDrugType("%") ;
									bean_st.loadResultPage("","","");
									bean_st.setModuleId("PH") ; //Added for KDAH-SCF-0243 [IN:049577]
									listRecord			=		bean_st.getDataList();
									if(listRecord!=null && listRecord.size()>0){
										trade_code=((HashMap)listRecord.get(0)).get("TRADE_NAME").toString();
										params.remove("ITEM_CODE");
										params.put("ITEM_CODE",item_code+"="+trade_code);
										//params.put("ITEM_CODE",item_code);
										stock				= (HashMap)bean_2.getBatches(params);
										stock_det           = listRecord;
									}
								}
								// Added for KAUH-SCF-0094 [IN:035252] -- end
								//code for setting batch details in bean
								alloc_drug_detail	=	new ArrayList();
								tmp_unit_qty =issue_qty_val; //Added for  MMS-SCF-0040 [IN:041888]
								//if(!stock.containsKey("EXCEPTION")){//if condition added for ML-BRU-SCF-0905 [IN:041285]- Ganga //Commented for TTM-SCF-0096 [IN:048808]
									for (int j=0;j<stock_det.size();j++){
										batch_det =(HashMap)stock_det.get(j);
										avail_qty			= (String)batch_det.get("AVAIL_QTY");
										if(Double.parseDouble(avail_qty) < 1.0)
											continue;

										alloc_drug_detail.add(batch_det.get("ITEM_CODE"));
										alloc_drug_detail.add(batch_det.get("BATCH_ID"));
										alloc_drug_detail.add(batch_det.get("EXPIRY_DATE"));

										/*if(qty_uom!=base_uom){   //added for SKR-SCF-0377 [IN:030453] - start
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
											issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
										}*/// Commented MMS-SCF-0040 [IN:041888] 
										item_cost	=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);
										/*if(qty_uom!=base_uom){ //Commented for  MMS-SCF-0040 [IN:041888]
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											avail_qty  =   retunFormatedInt(Math.floor(Double.parseDouble(avail_qty)/base_to_disp_uom_equl)+""); 
										}
										else{
											avail_qty			= retunFormatedInt(Math.floor(Double.parseDouble(avail_qty))+"");
										}*/ //Added for SKR-SCF-0377 [IN:030453] - end
										avail_qty			= retunFormatedInt(Math.floor(Double.parseDouble(avail_qty))+"");
										if(tmp_unit_qty>Double.parseDouble(avail_qty)){
											tmp_unit_qty =tmp_unit_qty-Double.parseDouble(avail_qty);
											issue_qty =avail_qty;
										}
										else{
											issue_qty =tmp_unit_qty+"";    
										}
										batch_issue_qty =  (String)batch_det.get("QTY"); //Added for  MMS-SCF-0040 [IN:041888]
										tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);
									
										if(base_to_disp_uom_equl!=base_to_def_uom_equl){					  
											// int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/Float.parseFloat(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue(); 
											//int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/Double.parseDouble(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue();  //Added for  MMS-SCF-0040 [IN:041888]
											//issue_qty = alloc_qty+""; //Commented for  MMS-SCF-0040 [IN:041888]
											alloc_drug_detail.add(issue_qty); //moved from common to specific for  MMS-SCF-0040 [IN:041888]
											alloc_drug_detail.add(qty_uom);
										} 
										else{ //else block added for  MMS-SCF-0040 [IN:041888]
											if(!qty_uom.equals(base_uom)){
												alloc_drug_detail.add(issue_qty);
												alloc_drug_detail.add(qty_uom);
											}
											else{
												alloc_drug_detail.add(batch_issue_qty);
												alloc_drug_detail.add(base_uom);
											}
										}
									
										//alloc_drug_detail.add(issue_qty);
										//alloc_drug_detail.add(base_uom);
										//alloc_drug_detail.add(qty_uom);
										alloc_drug_detail.add("");
										alloc_drug_detail.add(batch_det.get("TRADE_ID"));
										alloc_drug_detail.add(batch_det.get("BIN_LOCATION_CODE"));
										alloc_drug_detail.add(item_cost);
										alloc_drug_detail.add(base_uom);  //Added for for  MMS-SCF-0040 [IN:041888]
									}
								/*}
								else{//added ElseCondition by Ganga for ML-BRU-SCF-0905 [IN:041285]	
									alloc_readonly ="disabled";
								}*///Commented for  TTM-SCF-0096 [IN:048808]
									hold_status	="disabled";
									/*==========code added to handle if dispense uom and default uom in item store is different=================*/
									/*if(base_to_disp_uom_equl!=base_to_def_uom_equl){ //Commeted for  MMS-SCF-0040 [IN:041888]

										// int  alloc_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((tot_issued_qty*base_to_def_uom_equl)+""))/Float.parseFloat(conv_factor+"")))*(conv_factor))/base_to_disp_uom_equl)).intValue();  
										int  alloc_qty = new Float(Math.ceil(((Math.ceil((Double.parseDouble((tot_issued_qty*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue(); 
										tot_issued_qty = alloc_qty;
									} */
									if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ // Added for [IN:064158] - Start
										tot_issued_qty=0;
									} // Added for [IN:064158] - End
									if(!qty_uom.equals(base_uom)){ //if & else block added for  MMS-SCF-0040 [IN:041888]
										conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
										tot_issued_qty  =   Math.floor(tot_issued_qty/base_to_disp_uom_equl); 
									}
									else{
										tot_issued_qty			= Math.floor(tot_issued_qty);
									} //Added for SKR-SCF-0377 [IN:030453] - end
									bean.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);
									bean.setDrugQuantity(patient_id,order_id,order_line_no,tot_issued_qty);
								}	
							}
							else{
								if(!item_uom_definition_flag){
								item_uom_definition_flag=true;
							}
							alloc_readonly ="disabled"; 
						}
					}
					/*==========code added to handle if dispense uom and default uom in item store is different=================*/
					IssueUomQty		= (HashMap)bean.getIssueUomQty();
					issue_qty_dtl   =  new StringBuffer();
					if(IssueUomQty.containsKey(order_id+order_line_no+drug_code+"_qty")&& base_to_disp_uom_equl!=0){
						issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_qty");
						issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_desc");
						issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_uom");
						issue_uom_equl	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_equl");

						if(bean_1.getIssueByUOM().equals("I")){ 
							issue_qty_dtl   =  issue_qty_dtl.append("( ").append(retunFormatedInt(issue_qty_value)).append("  ").append(issue_uom_desc).append(" )");
						}
					}
					if(Min_Rol_yn){ ///Added AMS-CRF-0068.1 [IN:050333] start
						rol_min		=	(HashMap)stSalseBean.getROL(drug_code,disp_locn_code);
						frm_store_min_stk_level = CommonBean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0");
						frm_store_reorder_level	= CommonBean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0");
						min_stk	= false;
                        			rol_stk	= false;
						stParameters[0] = drug_code;
						stParameters[1] = disp_locn_code;
						try{
							hmStockAvailabilityStatus = stSalseBean.getStockAvailabilityStatus(stParameters);
							avail_qty=(String)hmStockAvailabilityStatus.get("available_stock");
						}
						catch (Exception e){
							avail_qty = "0";
						}
						if(avail_qty.equals(""))
							avail_qty="0";
						if(!frm_store_min_stk_level.equals("0")){
							if ( Double.parseDouble(avail_qty)   <  Double.parseDouble(frm_store_min_stk_level)){
								min_stk = true;
								if(getReq_allowed_yn)
									disp_req_flag =  "display:inline;color:blue";
								else
									disp_req_flag = "display:none";
							}
						}
						if(!frm_store_reorder_level.equals("0")){
							if ( Double.parseDouble(avail_qty)   <  Double.parseDouble(frm_store_reorder_level)){
								rol_stk = true; 
								if(getReq_allowed_yn)
									disp_req_flag = "display:inline;color:blue";
								else
									disp_req_flag  = "display:none;color:blue";	
							}
						}
						if(min_stk){
							min_stk_flag=	"display:inline;align:right";
							min_stk_flag_bkg_clr="background-color:red;color:yellow";
						}
						else{
							if(!frm_store_min_stk_level.equals("0")){
								min_stk_flag=	"display:inline";
								min_stk_flag_bkg_clr="background-color:none";
							}
							else{
								min_stk_flag=	"display:none";
								min_stk_flag_bkg_clr="background-color:none";
							}
						}
						if(rol_stk){
							rol_flag_bkg_clr = "background-color:red;color:yellow";
							rol_flag =	"display:inline"; 
						}
						else{ 
							if(!frm_store_reorder_level.equals("0")){
								rol_flag   =	"display:inline";
								rol_flag_bkg_clr = "style='background-color:none'";
							}
							else{
								rol_flag   =	"display:none";
								rol_flag_bkg_clr = "background-color:none";
							}
						}
						
						if((min_stk&&getReq_allowed_yn)||(rol_stk&&getReq_allowed_yn))
							disp_req_flag = "display:inline;color:blue";
						else
							disp_req_flag  = "display:none;color:blue";
					}//Added AMS-CRF-0068.1 [IN:050333] end
%>
				<tr id='<%="RECORD"+(recCount-1)%>' name='<%="RECORD"+(recCount-1)%>'  <%=taper_disable%>>
					<td class="white" width="6%">
						<table border="1" width="100%" cellpadding="0" cellspacing="0" align="center">
							<tr>
<%	
							if(allergy.equals("")) { 
%>
								<td class="white" width="33%">&nbsp;</td>
<%	
							}
							else{ 
%>
								<td class='ALLERGY' width="33%" style="cursor:pointer" onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>')">&nbsp;</td>
<%	
							}	
							if(exceed_dose.equals("")) {
%>
								<td class="white" width="33%">&nbsp;</td>
<% 
							}
							else{	
%>
								<td class='DOSELIMIT3' width="33%" style="cursor:pointer" onClick="showMonoGraph('<%=drug_name%>','<%=java.net.URLEncoder.encode(monograph)%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_unit_dose%>','<%=min_daily_dose%>','<%=dosage_unit%>','<%=std_dose%>')">&nbsp;</td>
<% 
							}	
							if(duplicate_yn.equals("Y") || !duplicate_drug_override_reason.equals("")) { 
%>
								<td class='CURRENTRX' width="33%" style="cursor:pointer" onClick="callActiveOrders('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>')">&nbsp;</td>
<%	
							}	
							else{	
%>
								<td class="white" width="33%">&nbsp;</td>
<%	
							}
%>
							</tr>
						</table>
					</td>
					<td class="<%=classvalue%>"   width="3%" nowrap <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
<% 
					if (hold_status.equals("disabled")){
%>
						<!-- <label style="color:black;font-size:9;" id='hold_remarks_<%=recCount%>'><%=hold_text%></label> -->
                         <label style="color:black;font-size:9;" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','AS','<%=scope%>');" id='hold_remarks_<%=recCount%>'  <%=hold_status%> <%=disable_alloc_text_box%> <%=taper_disable%>><%=hold_text%></label>
						<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none'  value="<%=check_value%>" <%=check_status%>>
<%
					}	
					else{
%>
						<label style="cursor:pointer;color:blue;font-size:9;" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','AS','<%=scope%>');notifyChange()" id='hold_remarks_<%=recCount%>' <%=disable_alloc_text_box%> <%=taper_disable%>><%=hold_text%></label>
						<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none' value="<%=check_value%>" <%=check_status%>>
<%
					}
%>
					<input type="hidden" name="drug_code<%=recCount%>" id="drug_code<%=recCount%>" value="<%=drug_code%>">
					<input type="hidden" name="stock_yn<%=recCount%>" id="stock_yn<%=recCount%>" value="<%=stock_opt%>">
					<input type="hidden" name="fromdb_<%=recCount%>" id="fromdb_<%=recCount%>" value="<%=fromdb%>">
					<input type="hidden" name="hold_status<%=recCount%>" id="hold_status<%=recCount%>" value="<%=hold_status%>">
					</td>
					<td class="<%=classvalue%>" style="font-size:9;" width="41%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" nowrap>
						<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="showDrugMasterValues('<%=drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label>
						<label style='<%=drug_style%>' onclick="showDrugDetails('OP','<%=source_code%>','<%=order_id%>','<%=drug_code%>','<%=order_line_no%>','','<%=bean_1.getDispLocnCode()%>','','', '<%=patient_id%>','Y','<%=generic_id%>','<%=current_order_line_status%>');" id="drug_desc<%=recCount%>"><%=drug_name%></label>&nbsp;&nbsp; <!--  , 'patient_id' added for [IN:035667] --><!-- Added for '','', Inc No : 41282  ('Y',generic_id, order_line_status Added for JD-CRF-0198 [IN058599]) -->
<%
						taperValues=bean.chkfortapering(order_id,drug_code, order_line_no, patient_id);	//Modified for RUT-CRF-0088 [IN036978] 		
						count =Integer.parseInt(taperValues.get("COUNT").toString()); 
						tot_tap=Float.parseFloat(taperValues.get("TOT_QTY").toString());	
						if(count>1){
							String taper = bean.getTapervalue();
							if(taper.equals("UP")){
%>
								<img src="../../ePH/images/uparrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer"height='20' width='20'></img>
<%
							}
							else if(taper.equals("DOWN")){
%>
								<img src="../../ePH/images/downarrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer" height='20' width='20'></img>
<% 
							}
							else{
%>
								<img src="../../ePH/images/MultiFrequency.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer" height='20' width='20' ></img>
<%
							}
							if(totalTaperQtyDisplay.equals("Y")){ //Added for RUT-CRF-0088 [IN036978]
%>
								<fmt:message key="Common.total.label" bundle="${common_labels}"/><fmt:message key="Common.Taper.label" bundle="${common_labels}"/><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>   <!--Added for RUT-CRF-0088 [IN036978] -->
								<label>-<%=(int)tot_tap%>&nbsp;&#40;<%=qty_uom_disp%>&#41;</label>  <!--Added for RUT-CRF-0088 [IN036978] -->
<%				
							}
						}
						if(bmscount==0){
							if(pat_couns_reqd_yn.equals("Y")){
								pat_reqd="Checked"; 
%>
						<img src="../../ePH/images/Patientcounsel.gif" valign="center"  ></img>
						<input type='checkbox' name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> disabled value='C' onclick="CheckPatReqd(this)">
<%
					}
					if(pat_couns_reqd_yn.equals("C")){
						pat_reqd="Checked";	
%>
						<img src="../../ePH/images/Patientcounsel.gif"  ></img>
						<input type='checkbox' name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> disabled value=''>
<%
					} 
					if(pat_couns_reqd_yn.equals("N")|| pat_couns_reqd_yn.equals("Null") ){
						pat_reqd="Unchecked";	
						//pt_couns_reqd_yn       =   bean.getPatCounsReqd(drug_code);
						if(pt_couns_reqd_yn.equals("Y")){
%>
							<img src="../../ePH/images/Patientcounsel.gif"  ></img>
							<input type='checkbox' valign='center' name='pat_reqd_<%=recCount%>' id='pat_reqd_<%=recCount%>' <%=pat_reqd%> value='' onclick='CheckPatReqd(this)'>
<%
						}
					}
				}
				String drug_name_1=  drug_name;   
							
				if(!drug_name_1.equals("")&&drug_name_1!=null){
					drug_name_1=drug_name_1.replaceAll(" ","%20");
					drug_name_1=	java.net.URLEncoder.encode(drug_name_1);
					drug_name_1=drug_name_1.replaceAll("%2520","%20");
				}

				if ((ext_prod_id!=null)&& !(ext_prod_id.equals("")) && drug_db_interface_yn.equals("Y")){
%>
					<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height=20  width=20 onClick="showDrugInfo('<%=ext_prod_id%>','<%=drug_name_1%>')">
<%
				}
				if ((image_path!=null)&& !(image_path.equals(""))){
%>
					<img style="cursor:pointer;" src="../../ePH/images/camera.gif" height=20  width=20 onClick="showImage('<%=drug_code%>','<%=trade_code%>')">
<%  
				}
				if(adr_count>0){
%>
					<img  id="ADR_img" src='../../ePH/images/ADR.gif'  height='20'  width='20' title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick= "callADRdetails('<%=patient_id%>','<%=drug_code%>')"></img><!-- callADRdetails() newly added for RUT-SCF-0144 [IN:033371]-->
<%
				}
				if(bDrugOrder){
%>
					<img src='../../ePH/images/DrugInfo.gif' width='17' height='15' onclick = "showDrug('<%=drug_code%>');" >
					<label id='lblDiscCancelledOrders_<%=recCount%>' style='cursor:pointer;<%=disc_cancelled_orders_display%>' title='<fmt:message key="ePH.DiscCancelDrugDtls.label" bundle="${ph_labels}"/>'>&nbsp;&nbsp;&nbsp;&nbsp;<img id='discCancelledOrders_<%=recCount%>' src="../../ePH/images/DiscCancelledIndicator.png" onclick='callDiscCancelledOrders("<%=disc_cancelled_orders%>", "<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>");'></label>
<%
					// if((bean_1.getDispLocnCatg()).equals("I")) {
					 disp_info	=	bean.getLastDispense(order_id,order_line_no);
					 if(disp_info.size() > 0) {				

						if( ((String)disp_info.get(1)).equals("Y")) {
							dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispensedToday.label","ph_labels")+"</font>";
						}
						dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'style='cursor:pointer;' title='"+disp_info.get(0)+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LastDispense.label","ph_labels")+"</font>";
					}
					//}	
%>
					<%=alt_drug_remarks_disp%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=dosage_dtls%><!-- <%=alt_drug_remarks_disp%> added for  Bru-HIMS-CRF-082 [IN:029948] -->
<% 
				}
%>
				<br><label id="id_min_stk_label" style='<%=min_stk_flag%>;'><fmt:message key="ePH.MINLEVEL.label" bundle="${ph_labels}"/>:</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->
				<label id="id_min_str_stk_<%=recCount%>" style='<%=min_stk_flag_bkg_clr%>;<%=min_stk_flag%>'><b><%=frm_store_min_stk_level%></b></label>&nbsp;&nbsp;
				<label id="id_stk_rol_label_<%=recCount%>" style='<%=rol_flag%>;'><fmt:message key="ePH.ROL.label" bundle="${ph_labels}"/>:</label>
				<label  id="id_stk_rol_<%=recCount%>" style='<%=rol_flag_bkg_clr%>;<%=rol_flag%>'><b><%=frm_store_reorder_level%></b></label>&nbsp;
				<label class='HYPERLINK'  name = "request_<%=recCount%>"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style='<%=disp_req_flag%>' ><b><fmt:message key="ePH.CreateRequest.label" bundle="${ph_labels}"/></b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->
				<label class='HYPERLINK'  name = "manufacturing_<%=recCount%>"  onmouseover="changeCursor(this);" onclick="callManufacturingReceipt('<%=drug_code%>','<%=disp_locn_code%>');" id="manufacturing_Recpt" style='<%=disp_mnf_flag%>;' ><b>&nbsp;&nbsp;<fmt:message key="eST.Manufacturing.label" bundle="${ph_labels}"/></b></label><!--Added BRU-HIMS-CRF-080 -->
<%
				int	k	=	0;
				alt_qty	=	new ArrayList();
				for(int n=0; n<multi_drugs.size(); n+=5)	{ 
					alt_drug_code		=	(String)multi_drugs.get(n);
					alt_drug_desc		=	(String)multi_drugs.get(n+1);
					altDrugName.put(alt_drug_code,alt_drug_desc);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
					form_code			=	(String)multi_drugs.get(n+2);
					alt_strength_value	=	(String)multi_drugs.get(n+3);
					//alt_strength_uom	=	(String)multi_drugs.get(n+4);
					alt_drug_desc_1	=    alt_drug_desc;
					if(!alt_drug_desc_1.equals("")&&alt_drug_desc_1!=null){
						alt_drug_desc_1=alt_drug_desc_1.replaceAll(" ","%20");
						alt_drug_desc_1=	java.net.URLEncoder.encode(alt_drug_desc_1,"UTF-8"); //Passed UTF-8 to alt_drug_desc_1 for the incident 25007==By Sandhya
						alt_drug_desc_1=alt_drug_desc_1.replaceAll("%2520","%20");
					}
				
					drug_color			=	(String)colors.get(k++);
					pack_dtls			=	bean.getPackSize(alt_drug_code);

					if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
						form_code	=	(String)pack_dtls.get("STOCK_UOM");
					}
					if(pack_dtls!=null && pack_dtls.containsKey("EXTERNAL_PRODUCT_ID")) {
						alt_external_prod_id	=	(String)pack_dtls.get("EXTERNAL_PRODUCT_ID");
					}
					else{
						alt_external_prod_id	=  "";
					}

					qty	=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 

					if(!qty.equals("") && !qty.equals("0")) {
						alt_qty.add(alt_drug_code);
						alt_qty.add(qty);
						alt_qty.add(form_code);
						alt_qty.add(alt_strength_value);
					}
					if(Min_Rol_yn ){ ///Added AMS-CRF-0068.1 [IN:050333] start
						min_stk	= false;
						rol_stk	= false;
						if( !drug_code.equals(alt_drug_code)){
							rol_min		=	(HashMap)stSalseBean.getROL(alt_drug_code,disp_locn_code);
							frm_store_min_stk_level = CommonBean.checkForNull((String)rol_min.get("MIN_STK_QTY"),"0");
							frm_store_reorder_level	= CommonBean.checkForNull((String)rol_min.get("REORDER_LEVEL"),"0");
							stParameters[0] = alt_drug_code;
							stParameters[1] = disp_locn_code;
							try{
								hmStockAvailabilityStatus = stSalseBean.getStockAvailabilityStatus(stParameters);
								qty=(String)hmStockAvailabilityStatus.get("available_stock");
							}
							catch (Exception e){
								qty = "0";
							}
							if(qty.equals(""))
								qty="0";
							if(!frm_store_min_stk_level.equals("0")){
								if ( Double.parseDouble(qty)  <  Double.parseDouble(frm_store_min_stk_level)){
									min_stk = true;
									if(getReq_allowed_yn)
										disp_req_flag =  "display:inline;color:blue";
									else
										disp_req_flag = "display:none";
								}
							}
							if(!frm_store_reorder_level.equals("0")){
								if ( Double.parseDouble(qty)   <  Double.parseDouble(frm_store_reorder_level)){
									rol_stk = true; 
									if(getReq_allowed_yn)
										disp_req_flag = "display:inline;color:blue";
									else
										disp_req_flag  = "display:none;color:blue";	
								}
							}
							if(min_stk){
								min_stk_flag=	"display:inline;align:right";
								min_stk_flag_bkg_clr="background-color:red;color:yellow";
							}
							else{
								if(!frm_store_min_stk_level.equals("0")){
									min_stk_flag=	"display:inline";
									min_stk_flag_bkg_clr="background-color:none";
								}
								else{
									min_stk_flag=	"display:none";
									min_stk_flag_bkg_clr="background-color:none";
								}
							}
							if(rol_stk){
								rol_flag_bkg_clr = "background-color:red;color:yellow";
								rol_flag =	"display:inline"; 
							}
							else{   
								if(!frm_store_reorder_level.equals("0")){
									rol_flag   =	"display:inline";
									rol_flag_bkg_clr = "background-color:none";
								}
								else{
									rol_flag   =	"display:none";
									rol_flag_bkg_clr = "background-color:none";
								}
							}
							
							if((min_stk&&getReq_allowed_yn)||(rol_stk&&getReq_allowed_yn)){
								disp_req_flag = "display:inline;color:blue";
							}
							else{
								disp_req_flag  = "display:none;color:blue";
							}
						}
						else{
							rol_flag   =	"display:none";
							min_stk_flag=	"display:inline";
							disp_req_flag  = "display:none";	
							min_stk_flag=	"display:none";
						}
					}//Added AMS-CRF-0068.1 [IN:050333] end
%>	
					<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER' onclick="showDrugMasterValues('<%=alt_drug_code%>');" id="drug_mast_det_<%=recCount%>">&nbsp;+&nbsp;</label>
					<label style="color:<%=drug_color%>"  id="alte_drug_desc<%=n%>"><%=alt_drug_desc%></label>
<%
					if ((alt_external_prod_id!=null)&& !(alt_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){
%>
						<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=alt_external_prod_id%>','<%=alt_drug_desc_1%>')"></img>
<%
					} 
                    adr_count = bean.getADRCount(patient_id,alt_drug_code);
					if(adr_count>0){
%>
		                <img  id="ADR_img" src='../../ePH/images/ADR.gif'  height='20'  width='20' title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick= "callADRdetails('<%=patient_id%>','<%=alt_drug_code%>')"></img><!-- callADRdetails() newly added for RUT-SCF-0144 [IN:033371]-->
<%
					}
%>
					
					<br><label id="id_min_stk_label" style='<%=min_stk_flag%>;'><fmt:message key="ePH.MINLEVEL.label" bundle="${ph_labels}"/>:</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->
					<label id="id_min_str_stk" style='<%=min_stk_flag_bkg_clr%>;<%=min_stk_flag%>'><b><%=frm_store_min_stk_level%></b></label>&nbsp;&nbsp;
					<label id="id_stk_rol_label" style='<%=rol_flag%>;'><fmt:message key="ePH.ROL.label" bundle="${ph_labels}"/>:</label>
					<label  id="id_stk_rol" style='<%=rol_flag_bkg_clr%>;<%=rol_flag%>;'><b><%=frm_store_reorder_level%></b></label>&nbsp;
					<label class='HYPERLINK'  name = "request"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style='<%=disp_req_flag%>;' ><b><fmt:message key="ePH.CreateRequest.label" bundle="${ph_labels}"/></b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->
<%
				}	
				drug_name_1=  drug_name;   
				if(!drug_name_1.equals("")&&drug_name_1!=null){
					drug_name_1=drug_name_1.replaceAll(" ","%20");
					drug_name_1=	java.net.URLEncoder.encode(drug_name_1,"UTF-8");
					drug_name_1=drug_name_1.replaceAll("%2520","%20");
				}
%>
				</td>
				<td class="<%=classvalue%>" style="font-size:9"  >
					<img src="../../ePH/images/DrugRemarks.gif" id='drugRemarks_<%=recCount%>' title='' valign="center"style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','<%=order_line_no%>','<%=dialog_height%>','<%=drug_name_1%>')"<%=remarks_style%>> <!-- code  ePH.PractitionerPharmacistInstructions replaced by drugs_remarks for Bru-HIMS-CRF-416[IN045566] --> 		
				   <script>
						var drug_remarks = decodeURIComponent('<%=strDrugsRemarks%>');
						eval(document.getElementById("drugRemarks_"+'<%=recCount%>')).title= drug_remarks ;
				   </script>
				</td> 
				<td class="<%=classvalue%>" style="font-size:9" title="<%=pres_details%>">
					<img src="../../ePH/images/exceed.gif" valign="center">
						 
				</td>
				
				<td class="<%=classvalue%>" style="font-size:9" width="10%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;<label style='<%=narc_style%>'><%=retunFormatedInt(pres_qty)%>&nbsp;(<%=qty_uom_disp%>)</label><br>
				<!---/*/*bean.getUomDisplay(facility_id,qty_uom)*/-->
<%
				if(!strength_value.equals("") && !strength_value.equals("0"))
					pres_strength	=	retunFormatedInt((((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))/(Float.parseFloat(main_strength_per_value_pres_uom)))*(main_drug_pack_size))+"")+" "+strength_uom;
%>
					&nbsp;
<% 
					if(multi_drugs.size()>1 ) { 
%>
						<b><%=pres_strength%></b>
<%	
					}
%>
					</td>
<% 			
					if(multi_drugs.size() > 1 ) {	

						if((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I")){
%>
							<td class="<%=classvalue%>">&nbsp;</td>
<%
						}
%>
						<td class="<%=classvalue%>" width="10%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" ><br>
<% 
						int x	=	0;
						int tmp_recCount	=	recCount;
						String alternate_drug	=	"";
						float pack_size	=	1;
						float strength_per_value	=	1.0f;

						for(int l=0; l<alt_qty.size(); l+=4) { 
							alternate_drug			=	(String)alt_qty.get(l);	
							qty					=	(String)alt_qty.get(l+1);	
							uom					=	(String)alt_qty.get(l+2);	
							alt_strength_value	=	(String)alt_qty.get(l+3);	
							drug_color			=	(String)colors.get(x++);

							pack_dtls				=	bean.getPackSize(alternate_drug);

							if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
								if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
									pack_size			=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));
									strength_per_value	=	Float.parseFloat(((String)pack_dtls.get("STRENGTH_PER_VALUE_PRES_UOM")));
								}		
							}

							tmp_alloc	+=	new Float( ((Float.parseFloat(alt_strength_value)) * Double.parseDouble(qty)*pack_size)/strength_per_value ).doubleValue();

							alloc_strength	=	retunFormatedInt(tmp_alloc+"")+""+strength_uom;
							//pres_qty		=	bms_qty;
							float prescribed_strength	=	Float.parseFloat(tmp_bms_qty_1) * 	Float.parseFloat(strength_value)/(Float.parseFloat(main_strength_per_value_pres_uom));
							double balance_strength		=	prescribed_strength - tmp_alloc;	
							
							if(balance_strength<1)
								balance_strength		=	0;

							if(balance_strength!=0) {
								bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
							} 
							else {
								bms_qty					=	"0";
							}
							bms_qty=Math.round(((Float.parseFloat(bms_qty)*(Float.parseFloat(main_strength_per_value_pres_uom)))/main_pack_size))+"";
							bms_strength				=	balance_strength+"";

							if(qty.equals("") || qty.equals("0")) 
								uom="";	
							else {
								//uom=qty_uom;
								tot_qty		+=	Integer.parseInt(qty);
								//uom			=	"("+uom+")";  // Commented and brackets added below for ML-BRU-SCF-0866 IN040255								
							}

							issue_qty_dtl =new StringBuffer();/*code added to handle if dispense uom and default uom in item store is different==Start*/
							if(IssueUomQty.containsKey(order_id+order_line_no+drug_code+"_qty")){
								issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_qty");
								issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_uom");
								issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_desc");
								issue_uom_equl  = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_equl");
								if(bean_1.getIssueByUOM().equals("I")){
									issue_qty_dtl   =  issue_qty_dtl.append("( ").append(retunFormatedInt(issue_qty_value)).append("  ").append(issue_uom_desc).append(" )");
								}
							}/*code added to handle if dispense uom and default uom in item store is different==End*/
%>
							<label style="color:<%=drug_color%>;font-size:9" id="alloc_qty<%=tmp_recCount%>">&nbsp;<%=qty%>&nbsp;<%="("+bean.getUomDisplay(facility_id,uom)+")"%><%=issue_qty_dtl.toString()%><br>
							<!--  <input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>" value="<%=uom%>">
							<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=qty%>">
							<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
							<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
							<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
							<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="<%=issue_uom_equl%>"> -->
							<!-- <input type="hidden" name="alloc_strength<%=tmp_recCount%>" id="alloc_strength<%=tmp_recCount%>" value="<%=qty%>"> -->
<%
							tmp_recCount++;
							hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
							hsh_med_plan.put("qty",qty);
							if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y"))	{
								if(!alt_qty.contains(drug_code)){
									medplan_bean.getMedPlan_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id);
									medplan_bean.getMedPlan_Local_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id);
								}
								arrOrderId.add(order_id+"_"+order_line_no);
								dosedet[0] = "";dosedet[1] = "";dosedet[2] = "";dosedet[3] = "";dispno[0]="";dispno[1]="";dosedetlocal[0] = "";dosedetlocal[1] = "";dosedetlocal[2] = "";dosedetlocal[3] = "";
								dosedet = medplan_bean.getDoseDetails(order_id, order_line_no,primary_lang_id,drug_code,alternate_drug);
								dosedetlocal = medplan_bean.getDoseDetails(order_id, order_line_no,loc_lang_id,drug_code,alternate_drug);
								medplan_bean.getDosageDetails(drug_code,alternate_drug, order_id, order_line_no);
								hsh_med_plan.put("drug_name",(String)altDrugName.get(alternate_drug));
								hsh_med_plan.put("drug_code",alternate_drug);
								hsh_med_plan.put("morning",dosedet[0]);
								hsh_med_plan.put("afternoon",dosedet[1]);
								hsh_med_plan.put("evening",dosedet[2]);
								hsh_med_plan.put("night",dosedet[3]);
								hsh_med_plan.put("morninglocal",dosedetlocal[0]);
								hsh_med_plan.put("afternoonlocal",dosedetlocal[1]);
								hsh_med_plan.put("eveninglocal",dosedetlocal[2]);
								hsh_med_plan.put("nightlocal",dosedetlocal[3]);
								hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,loc_lang_id));
								hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,primary_lang_id));
								hsh_med_plan.put("curr_disp_yn","Y");
								hsh_med_plan.put("merge_yn","N");
								hsh_med_plan.put("plan_recorded","N");
								hsh_med_plan.put("pres_drug_code",drug_code);
								hsh_med_plan.put("disp_drug_code",alternate_drug);
								hsh_med_plan.put("impnote",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote(alternate_drug)));
								hsh_med_plan.put("impnotelocal",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote_Local(alternate_drug)));
								hsh_med_plan.put("howtotakelocal",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake_Local(order_id+"~"+order_line_no+"~"+alternate_drug)));
								hsh_med_plan.put("drug_name_local",CommonBean.checkForNull(medplan_bean.getDrug_desc_local(alternate_drug)));
								hsh_med_plan.put("howtotake",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake(order_id+"~"+order_line_no+"~"+alternate_drug)));
								dispno = medplan_bean.getDispNumber(order_id, order_line_no);
								hsh_med_plan.put("disp_no",dispno[0]);
								hsh_med_plan.put("disp_srl_no",dispno[1]);
								hsh_med_plan.put("checked","checked");
								hsh_med_plan.put("order_id",order_id);
								hsh_med_plan.put("order_line_no",order_line_no);
								medplan_bean.setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+alternate_drug+"_"+primary_lang_id, hsh_med_plan);
								medplan_bean.setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+alternate_drug+"_"+loc_lang_id, hsh_med_plan);
							}// Added for Bru-HIMS-CRF-072.1 [IN:049144] end
						}	
						/*if(!alt_strength_value.equals("")) {
							alloc_strength	=	Integer.parseInt(alt_strength_value) * tot_qty+"";
							alloc_strength	=	(Integer.parseInt(alloc_strength)==0)?"":alloc_strength+" "+strength_uom;
						}*/
%>
		<!--  added alloc_strength for ML-BRU-SCF-0866 IN040255 -->
						</label>&nbsp;<label style="font-size:9;color:black"><b>
						<%=alloc_strength%></b></label><input type="hidden" name="alloc_strength<%=recCount%>" id="alloc_strength<%=recCount%>" value="<%=qty%>"><br><label style="cursor:pointer;color:blue;font-size:9;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','Y','<%=drug_name_1%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label></td>
<%
					}
					else{	
						if(qty.equals("") || qty.equals("0")) {
							qty	=	"";
							uom	=	"";	
						}
						else {
							if(!strength_value.equals("") && !strength_value.equals("0"))
								alloc_strength	=	Float.parseFloat(strength_value) * Float.parseFloat(qty)+"";
							//uom="("+qty_uom+")";
							uom=qty_uom;
						}

						if(qty.equals("") && alt_drug_qty.equals("") && (ord_type.equals("NOR") || bEquivalentNormalOrder)){
							if(tot_issued_qty==0){
								qty ="";
							}
							else{
								qty = tot_issued_qty+"";
							}
							uom=qty_uom;
							bms_qty = (Double.parseDouble(act_bms_qty)-tot_issued_qty)+"";
						}
						/*if(count>1){ //if block added to avoid displaying qty for tapered drugs
							qty = act_bms_qty;
							bms_qty = "0";
						}*/ //Commented for ML-BRU-SCF-1015 [IN:04335
						/*Commented for RUT-CRF-0088 [IN036978] 
						if(taper_order_yn.equals("Y") && !taper_order_id.equals("") && !taper_order_line_num.equals("")){ //if block added to avoid displaying qty for tapered drugs
							qty = "0";
							bms_qty = "0";
						}*/
%>
					<td align="left" class="<%=classvalue%>"  style='<%=display_list%>'>&nbsp;
					<select onChange="calculateIssueUOM(this,'<%=recCount%>','<%=order_id+order_line_no+drug_code+"_uom"%>');" name="issue_uom_select_<%=recCount%>">
<% 
					String stk_unit_code	= "";
					String stk_unit_desc	= "";
					String stk_equval_value	= "";
					String act_stk_equval_value	= "";
					
					stk_units				= bean.loadStockUnit(drug_code);
					String base_to_def_uom_equl_val  ="1";
					String base_to_disp_uom_equl_val ="1";

					for(int iStkCountt=0; iStkCountt<stk_units.size();iStkCountt+=4) { 
						stk_unit_code		=	(String)stk_units.get(iStkCountt);
						stk_unit_desc		=	(String)stk_units.get(iStkCountt+1);
						stk_equval_value	=	(String)stk_units.get(iStkCountt+2);
						act_stk_equval_value	=	(String)stk_units.get(iStkCountt+3);

						if(dflt_issue_uom.equals(stk_unit_code)){
%>
							<option value="<%=stk_unit_code%>_<%=stk_equval_value%>_<%=stk_unit_desc%>_<%=act_stk_equval_value%>" selected><%=stk_unit_desc%></option>
<%
						}
						else{
%>
							<option value="<%=stk_unit_code%>_<%=stk_equval_value%>_<%=stk_unit_desc%>_<%=act_stk_equval_value%>"><%=stk_unit_desc%></option>
<%
						}	
					}

					// For Allowing more quantity than order quantity dispense based on drug setup
					HashMap hmAllowMoreQty = bean_1.getHmAllowMoreQty();

					if(hmAllowMoreQty == null)
						hmAllowMoreQty = new HashMap();
%>
					</select>&nbsp;
					<label id="item_desc_3" style="font-weight:bold"></label>
					</td>

					<td class="<%=classvalue%>" width="10%" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
					<input type="hidden" name="AllowMoreThanPresQty<%=recCount%>" id="AllowMoreThanPresQty<%=recCount%>"  value="<%=hmAllowMoreQty.get(drug_code)%>">
<%
					if( (ord_type.equals("NOR") || bEquivalentNormalOrder)){
						if(bean_1.getBarcode_Scan_YN().equals("Y") || (bean_1.getBarcode_Scan_YN().equals("N") && barcode_id.equals(""))){ // Added for [IN:064158] - Start
                 		                  if(qty.equals("0.0") || qty.equals("") || qty.equals("0"))
                 			            qty = "0.0"; // "" modified to "0.0" for GHL-CRF-0463 
						} // Added for [IN:064158] - End
						if(stock_opt.get(0).equals("Y")&& disp_delivery_chk_box_val.equals("Y")){
							if(in_formulary_yn.equals("Y")){
%>
								<input type="text" class="flat" size="6" style="text-align:right"  <%=alloc_readonly%>   onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="<%=  retunFormatedInt(qty)%>" oncopy="return false" onpaste="return false"  onchange=" if(checkAllocBmsSecondStage('<%=recCount%>', this)){checkValue(this); setbatchdetails(this,'<%=store_code%>','<%=base_uom%>','<%=end_date%>','<%=item_code%>','<%=trade_code%>','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=uom%>','<%=billing_interface_yn%>','<%=drug_code%>','<%=act_bms_qty%>','<%=retunFormatedInt(qty)%>','<%=recCount%>')};" <%=taper_disable%> > 
<%
								if(bean_1.getStockDtl().containsKey("valid_drug_code") && (order_id+"~"+order_line_no+"~"+drug_code).equals((String) bean_1.getStockDtl().get("valid_drug_code"))){ //if block added for KDAH-CRF-0231 [IN-034551] 
%>
									<script>
										document.getElementById("alloc_qty_"<%=recCount%>).style.backgroundColor = "#ADFF2F";//changed for 62327
										document.getElementById("alloc_fromBarCode").value="Y";
									</script>
<%					    
								}
							}
							else{
%>
								<input type="text" class="flat" size="6" style="text-align:right" <%=alloc_readonly%>    onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="" disabled>
<%
							}
%>
							<input type ="hidden" name = "alloc_qty_hidden_<%=recCount%>" value ="document.DispMedicationAllStages.alloc_qty_<%=recCount%>~<%=store_code%>~<%=base_uom%>~<%=end_date%>~<%=item_code%>~<%=trade_code%>~<%=patient_id%>~<%=order_id%>~<%=order_line_no%>~<%=uom%>~<%=billing_interface_yn%>~<%=drug_code%>~<%=act_bms_qty%>~<%=retunFormatedInt(qty)%>~<%=recCount%>">
							<label class="label" ><b>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%></b></label>&nbsp;&nbsp;<label id="issue_uom_lbl<%=recCount%>" class="label" style style='font-size:9' ><b>&nbsp;<%=issue_qty_dtl.toString()%></b></label><br><label style="cursor:pointer;color:blue;font-size:9;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','N','<%=drug_name_1%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label>

							<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>"     value="<%=uom%>">
							<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=qty%>">
							<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
							<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
							<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
							<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="<%=issue_uom_equl%>">
<%
						}
						else{
							if(in_formulary_yn.equals("Y")){//Added for MO-GN-5434 [IN:043669]
%>
							<input type="text" class="flat" size="6" style="text-align:right" <%=alloc_readonly%> onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="<%=retunFormatedInt(qty)%>" onblur="includeToBms(this,'<%=recCount%>')" <%=taper_disable%>>
<%
							}else{//Added for MO-GN-5434 [IN:043669]
%>
							<input type="text" class="flat" size="6" style="text-align:right" <%=alloc_readonly%>  onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="<%=retunFormatedInt(qty)%>"  disabled>
<%
							}//Added for MO-GN-5434 [IN:043669]
%>
							<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>"     value="">
							<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="">
							<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="">
							<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="">
							<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="">
							<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="">
<%
						}
					}
					else{
%>
						<label class="label" id="alloc_qty<%=recCount%>"><b>&nbsp;<%=retunFormatedInt(qty)%>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%></b></label><br><label id="issue_uom_lbl<%=recCount%>" class="label" style style='font-size:9' ><b>&nbsp;<%=issue_qty_dtl.toString()%></b></label>&nbsp;&nbsp;<label style="cursor:pointer;color:blue;font-size:9;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','N','<%=drug_name_1%>')"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label></td>
						<input type="hidden" name="alloc_strength<%=recCount%>" id="alloc_strength<%=recCount%>" value="<%=qty%>">
						<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>"     value="<%=uom%>">
						<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=qty%>">
						<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
						<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
						<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
						<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="<%=issue_uom_equl%>">
<%
					}
				}	
		  
				if(multi_drugs.size() > 1 ) {
					/*if( Float.parseFloat(strength_value) > Float.parseFloat(alt_strength_value) ) {
						if(tot_qty > 0)
							bms_qty	=	Float.parseFloat(pres_qty) - (tot_qty / prod_qty)+"";
						else 
							bms_qty	=	(Float.parseFloat(bms_qty) / prod_qty)+"";
					} else {
							if(!qty.equals("") && !qty.equals("0")){
								bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
							}
						}*/
				}
				else {
					if(!qty.equals("") && !qty.equals("0")){
						if(!bean_1.getBarcode_multi_id().equals("Y"))
							bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
					}
				}
						
				if(!strength_value.equals("") && !alt_strength_value.equals("")) {
					if(bms_strength.equals(""))
					bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)*(main_pack_size)+"";
					//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(alt_strength_value)+"";
				}
				else if(!strength_value.equals("") && !strength_value.equals("0")) {
					//bms_strength		=	Float.parseFloat(bms_qty) * Float.parseFloat(strength_value)+"";
					bms_strength		=	"";
					strength_uom		=	"";
				}
				else 
					strength_uom	=	"";
				
				if(bms_qty.indexOf(".")!=-1) {
					int pos	=	bms_qty.indexOf(".");
					if(bms_qty.length() > (pos+3) )
						bms_qty	=	bms_qty.substring(0,(pos+3));
				}
				if(bms_strength.equals("0.0")||bms_strength.equals("0")||bms_qty.equals("0.0")||bms_qty.equals("0")){
					bms_strength="";
					strength_uom="";
				}
				if(Float.parseFloat(bms_qty)<0){
					bms_qty ="0";
				}
				hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start
				hsh_med_plan.put("qty",qty);
				if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y"))	{
					arrOrderId.add(order_id+"_"+order_line_no);
					dosedet[0] = "";dosedet[1] = "";dosedet[2] = "";dosedet[3] = "";dispno[0]="";dispno[1]="";dosedetlocal[0] = "";dosedetlocal[1] = "";dosedetlocal[2] = "";dosedetlocal[3] = "";
					dosedet = medplan_bean.getDoseDetails(order_id, order_line_no,primary_lang_id,drug_code,drug_code);
					dosedetlocal = medplan_bean.getDoseDetails(order_id, order_line_no,loc_lang_id,drug_code,drug_code);
					hsh_med_plan.put("drug_name",CommonBean.checkForNull(medplan_bean.getDrug_desc(drug_code)));
					hsh_med_plan.put("drug_code",drug_code);
					hsh_med_plan.put("morning",dosedet[0]);
					hsh_med_plan.put("afternoon",dosedet[1]);
					hsh_med_plan.put("evening",dosedet[2]);
					hsh_med_plan.put("night",dosedet[3]);
					hsh_med_plan.put("morninglocal",dosedetlocal[0]);
					hsh_med_plan.put("afternoonlocal",dosedetlocal[1]);
					hsh_med_plan.put("eveninglocal",dosedetlocal[2]);
					hsh_med_plan.put("nightlocal",dosedetlocal[3]);
					hsh_med_plan.put("qty_issuelocal",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,loc_lang_id));
					hsh_med_plan.put("qty_issue",dfToInteger.format(Double.parseDouble(qty))+" "+medplan_bean.getUOMDesc(qty_uom,primary_lang_id));
					hsh_med_plan.put("curr_disp_yn","Y");
					hsh_med_plan.put("merge_yn","N");
					hsh_med_plan.put("plan_recorded","N");
					hsh_med_plan.put("pres_drug_code",drug_code);
					hsh_med_plan.put("disp_drug_code",drug_code);
					hsh_med_plan.put("impnote",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote(drug_code)));
					hsh_med_plan.put("impnotelocal",CommonBean.checkForNull(medplan_bean.getDrug_ImpNote_Local(drug_code)));
					hsh_med_plan.put("howtotakelocal",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake_Local(order_id+"~"+order_line_no+"~"+drug_code)));
					hsh_med_plan.put("drug_name_local",CommonBean.checkForNull(medplan_bean.getDrug_desc_local(drug_code)));
					hsh_med_plan.put("howtotake",CommonBean.checkForNull(medplan_bean.getDrug_Howtotake(order_id+"~"+order_line_no+"~"+drug_code)));
					dispno = medplan_bean.getDispNumber(order_id, order_line_no);
					hsh_med_plan.put("disp_no",dispno[0]);
					hsh_med_plan.put("disp_srl_no",dispno[1]);
					hsh_med_plan.put("checked","checked");
					hsh_med_plan.put("order_id",order_id);
					hsh_med_plan.put("order_line_no",order_line_no);
					medplan_bean.setMedPlan_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id, hsh_med_plan);
					medplan_bean.setMedPlan_Local_DrugDetails(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id, hsh_med_plan);
				}// Added for Bru-HIMS-CRF-072.1 [IN:049144] end

%>
				<td class="<%=classvalue%>" width="10%" style="font-size:9" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;<label class="label" id="bms_qty_<%=recCount%>">&nbsp;<%=retunFormatedInt(bms_qty)%>&nbsp;</label>&nbsp;(<%=qty_uom_disp%>)<br>&nbsp;<b><%=bms_strength%>&nbsp;<%=strength_uom%></b><input type="hidden" name="bms_qty<%=recCount%>" id="bms_qty<%=recCount%>" value="<%=retunFormatedInt(bms_qty)%>"><input type="hidden" name="bms_strength<%=recCount%>" id="bms_strength<%=recCount%>" value="<%=bms_strength%>"></td><!---/*bean.getUomDisplay(facility_id,qty_uom)*/-->
<%
				String strModDrugCode =  drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");
				//for billing interface coding starts
				if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){	
					if(in_formulary_yn.equals("Y")){ 

						float gross_charge_amount =0;
						float groos_pat_payable   =0;
						//float net_amount          =0;

						disp_delivery_chk_box     = "checked";
						disp_delivery_chk_box_val = "Y";
						disp_delivery_chk_box_disabled= "";

						gross_charge_amount_str	  =  "";
						groos_pat_payable_str	  =  "";
						 batch_str				  =  "";

						StringBuffer gross_charge_display_str  = new StringBuffer();
						StringBuffer pat_charge_display_str    = new StringBuffer();
						StringBuffer inc_exec_display_str      = new StringBuffer();
						if(!qty.equals("") && billable_item_yn.equals("Y")){
							alt_drug_code			    = "";
							boolean billing_alt_flag  = false;
							if(multi_drugs.size()>1){
								for(int n=0; n<multi_drugs.size(); n+=5)	{							    
									alt_drug_code	     =	(String)multi_drugs.get(n);
									if(alt_drug_code.equals(drug_code)){
									billing_alt_flag=true;
								}
							}
						}
						if(!billing_alt_flag){
							HashMap billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,patient_class,dischargeIND);  // IN032479   Added discharge indicator
							if(billing_det.containsKey(drug_code)){
								HashMap  chareg_det=(HashMap)billing_det.get(drug_code);
								if(chareg_det.get("error_msg").equals("")){
									decimalFormatString         =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
									DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);

									/*if(!chareg_det.get("grosschargeamt").equals("null")){
										 gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
									}*/
									if(!chareg_det.get("patnetamt").equals("null")){
										 groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
									} //Commented added ML-BRU-SCF-0368 [IN:034748]
									if(!chareg_det.get("netchargeamt").equals("null")){
										//groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
										gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); //added ML-BRU-SCF-0368 [IN:034748]
									}

									batch_str                =(String)chareg_det.get("BATCH_STRING");
									gross_charge_amount_str  = dfTest.format(gross_charge_amount);
									groos_pat_payable_str    = dfTest.format(groos_pat_payable);

									gross_charge_display_str.append("<label style='font-size:9;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(groos_pat_payable_str).append("</label>");

									pat_charge_display_str.append("<label style='font-size:9;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(gross_charge_amount_str).append("</label>");	

									inc_exec_display_str.append("<a  style ='font-size:9' href=\"javascript:callIncludeExclude(").append("'AS'").append(",").append("''").append(",").append("'").append(drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</a>");
								
									tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
									tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;	
%>

									<input type="hidden" name="override_allowed_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="override_allowed_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"  value="<%=(String)chareg_det.get("override_allowed_yn")%>">
									<input type="hidden" name="excl_incl_ind_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="excl_incl_ind_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"        value="">
									<input type="hidden" name="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"value="<%=(String)chareg_det.get("excl_incl_ind")%>">
									<input type="hidden" name="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"     value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
									<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
									<input type="hidden" name="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
									
									<input type="hidden" name="gross_charge_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="gross_charge_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="<%=gross_charge_amount+""%>">
									<input type="hidden" name="groos_pat_payable_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="groos_pat_payable_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value="<%=groos_pat_payable+""%>">
									<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value='black'>
<% 
								}
								else{                                        
									gross_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
									pat_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
									disp_delivery_chk_box="";
									disp_delivery_chk_box_val="N";
									disp_delivery_chk_box_disabled="disabled";
											
								}
							}
						}
					}
					if(multi_drugs.size()>1){
						int  added_yn =0;
						int  x		=0;
						String sModAltDrugCode = "";
						HashMap billing_det = null;
						for(int n=0; n<multi_drugs.size(); n+=5)	{							    
							alt_drug_code	     =	(String)multi_drugs.get(n);
							sModAltDrugCode		 = alt_drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");
							drug_color			 =	(String)colors.get(x++);
							billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,patient_class,dischargeIND);  // IN032479   Added discharge indicator);
							if(billing_det.containsKey(alt_drug_code)){
								HashMap  chareg_det=(HashMap)billing_det.get(alt_drug_code);
								if(chareg_det.get("error_msg").equals("")){

									batch_str =(String)chareg_det.get("BATCH_STRING");
									decimalFormatString     =(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
									DecimalFormat dfTest   = new DecimalFormat(decimalFormatString);

									/*if(!chareg_det.get("grosschargeamt").equals("null")){ 
										gross_charge_amount= Float.parseFloat((String)chareg_det.get("grosschargeamt"));
									}*/ //commented for  ML-BRU-SCF-0368 [IN:034748]
									if(!chareg_det.get("patnetamt").equals("null")){ 
										groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
									}
									 if(!chareg_det.get("netchargeamt").equals("null")){
										//groos_pat_payable  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
										gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt")); //added ML-BRU-SCF-0368 [IN:034748]
									}
							   
									gross_charge_amount_str = dfTest.format(gross_charge_amount);
									groos_pat_payable_str   = dfTest.format(groos_pat_payable);
									   
									gross_charge_display_str.append("<label style='font-size:9;color:").append(drug_color).append("' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(groos_pat_payable_str).append("</label><BR>");

									pat_charge_display_str.append("<label style='font-size:9;color:").append(drug_color).append("' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(gross_charge_amount_str).append("</label><BR>");

								   inc_exec_display_str.append("<label style='cursor:pointer;font-size:9;color:").append(drug_color).append("' onclick=\"javascript:callIncludeExclude(").append("'AS'").append(",").append("''").append(",").append("'").append(alt_drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</label><br>");

									added_yn++;

									tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
									tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
%>
										<input type="hidden" name="override_allowed_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="override_allowed_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"  value="<%=(String)chareg_det.get("override_allowed_yn")%>">
										<input type="hidden" name="excl_incl_ind_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="excl_incl_ind_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"        value="">
										<input type="hidden" name="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"value="<%=(String)chareg_det.get("excl_incl_ind")%>">
										<input type="hidden" name="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"     value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
										<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" value="">
										<input type="hidden" name="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" value="">
										
										<input type="hidden" name="gross_charge_amount_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="gross_charge_amount_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" value="<%=gross_charge_amount+""%>">
										<input type="hidden" name="groos_pat_payable_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="groos_pat_payable_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"   value="<%=groos_pat_payable+""%>">
										<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="drug_color_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"   value="<%=drug_color%>">
<% 
									}
									else{
										  gross_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("<BR>");
								          pat_charge_display_str.append("<label style='font-size:9;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("<BR>");
										  disp_delivery_chk_box    ="";
								          disp_delivery_chk_box_val="N";
										  disp_delivery_chk_box_disabled="disabled";
									   }
								  }							  
						}
						/*if(added_yn>0){
							//gross_charge_display_str.append("</label>");
							//pat_charge_display_str.append("</label>");
						}*/
				}		
			%>	   
			<td class="<%=classvalue%>"><center>&nbsp;<%=pat_charge_display_str.toString()%></center></td>
			<td class="<%=classvalue%>"><center>&nbsp;<%=gross_charge_display_str.toString()%></center></td>
			<td class="<%=classvalue%>"><center>&nbsp;<%=inc_exec_display_str.toString()%></center></td>
<% 
			}
			else{
%>
			     <td class="<%=classvalue%>" align="center">&nbsp;</td>
			     <td class="<%=classvalue%>" align="center">&nbsp;</td>
			     <td class="<%=classvalue%>" align="center">&nbsp;</td>
				
<%
			   }			
			//billing interface coding ends here
			} 
%>
			<input type="hidden"  name="allocateyn_<%=recCount%>" id="allocateyn_<%=recCount%>" value="<%=disp_delivery_chk_box_val%>">   <!--  Added for MO-GN-5434 [IN:043669]  -->
<%
		if(delivery_reqd.equals("Y")) { 
			if(delivery_det!=null && delivery_det.size() > 1) {
				//Ifcondition added and the block moved from below "if(!order_type.equals("TD") && !order_type.equals("TA")){" for SRR20056-SCF-7289
		    if(!ord_type.equals("IVAA")&& !ord_type.equals("IVIA")&& !ord_type.equals("CA")&& !ord_type.equals("TA")&&!ord_type.equals("TD")&& !ord_type.equals("CO")){
				hmEditLabelValues = new HashMap();	
				hmEditLabelValues.put("order_id",order_id);
				hmEditLabelValues.put("pres_drug_code",drug_code);
				if( (multi_drugs.size()!=0)){//added if condition for alternate drugs in edit label ML-BRU-SCF-1528 [IN:053217]
					hmEditLabelValues.put("drug_code",alt_drug_code);
					hmEditLabelValues.put("alt_drug_desc",alt_drug_desc);
					hmEditLabelValues.put("alt_drug_flag","Y");
				}
				else
					hmEditLabelValues.put("drug_code",drug_code);
				hmEditLabelValues.put("order_line_no",order_line_no);
				hmEditLabelValues.put("ord_date_time",ord_date_time);
				hmEditLabelValues.put("drug_name_1",drug_name);
				hmEditLabelValues.put("drug_desc",drug_desc); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1454 [IN:052271]
				hmEditLabelValues.put("pres_qty",pres_qty);
				hmEditLabelValues.put("uom",uom);
				if(multi_drugs.size()>1)//Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217] -start
					hmEditLabelValues.put("alt_drug_count", (multi_drugs.size()/5)+""); 
				else
					hmEditLabelValues.put("alt_drug_count", "0"); //Added for Bru-HIMS-CRF-414- ML-BRU-SCF-1528 [IN:053217] -end
				alEditLabelPair.add(hmEditLabelValues);
				bean.setSPerformPractId(performing_pract_id);
			}
			strAllocBMSChkValue  = "";
			strAllocBMSChecked	 = "";
			showZeroQtyCheckBox="";
			showOtherEditLables ="";
		    
			if((strAutoCompletePartialDisp.equals("Y") && Double.parseDouble(bms_qty) > 0 && !qty.equals("")) || (strIncludeZeroQty.equals("Y") && (qty.equals("") || qty.equals("0") )) ){//Added for MO-GN-5434 [IN:043669] start //(qty ==null || qty.equals("0")) is changed to Double.parseDouble(bms_qty)>0 for JD-CRF-0179 [IN:41211] //Added || (Double.parseDouble(qty)==0 && strIncludeZeroQty.equals("Y")) for [IN:045700]
				showZeroQtyCheckBox ="";
				showOtherEditLables ="display:none";
				if(includeBMSDefCheck_yn.equals("Y") && strBMS_Include_yn.equals("Y")){ //if condition added for [IN:045055](Bru-HIMS-CRF-281[IN:033166]) //Added && strBMS_Include_yn.equals("Y") for [IN:045700]
					strAllocBMSChkValue  = "Y";
					strAllocBMSChecked	 = "checked";
				}
			}
			else{
				showZeroQtyCheckBox="display:none";
				showOtherEditLables ="";
			}
			//Added for MO-GN-5434 [IN:043669] end
			if(!qty.equals("") ){
%>
				<td class="<%=classvalue%>" width="8%"  <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;
<%
				//if(strIncludeZeroQty.equals("Y")){//Added for MO-GN-5434 [IN:043669] start Commented for [IN:045700]
%>
					<div style="color:blue;font-size:9;font-weight:bold" id="divIncludeZeroQty<%=recCount%>" style="<%=showZeroQtyCheckBox%>">
						<input type ="checkbox" name ="alloc_bms_chk_<%=recCount%>" value="<%=strAllocBMSChkValue%>" onclick="assignValue(this);setEnableDsbleCOR(this,'<%=recCount%>');" <%=strAllocBMSChecked%> />
						<fmt:message key="ePH.INCLUDE_IN_BMS.label" bundle="${ph_labels}"/>
					</div>								
<%
				//} Commented for [IN:045700]
%>
					<div id="divOtherEditLables<%=recCount%>" style="<%=showOtherEditLables%>">	
<%//Added for MO-GN-5434 [IN:043669] end
					if(!order_type.equals("TD") && !order_type.equals("TA")){
%>
						<label style='color:blue;cursor:pointer;font-size:9' id='detail"+recCount+"' onClick="callEditDetails(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','D','<%=recCount%>','<%=patient_id%>','<%=ord_date_time%>','<%=pract_id%>','<%=drug_code%>','<%=drug_name_1%>','<%=pres_qty%>','<%=uom%>','<%=disp_locn_catg%>')"><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></label><br>
<%
					}
%>
					<!-- <%	
					del_style	=	"<input type='checkbox'   name='del_detail"+recCount+"' id='del_detail"+recCount+"'  style='visibility:visible' checked value='Y' onClick='updateValue(this)'>"; %> -->
					<input type='checkbox'   name='del_detail<%=recCount%>' id='del_detail<%=recCount%>'  style='visibility:visible' <%=disp_delivery_chk_box%> <%=disp_delivery_chk_box_disabled%>  value='<%=disp_delivery_chk_box_val%>' onClick='updateValue(this)'>
					<!-- <%=del_style%> -->
					</div><!-- //Added for MO-GN-5434 [IN:043669] -->
					<br>
					<label style="cursor:pointer;color:blue;font-size:9;" id="fill_remarks<%=recCount%>" onClick="callFillingRemarks(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','D','fill_remarks<%=recCount%>');"> <fmt:message key="Common.Findings.label" bundle="${common_labels}"/></label>
					</td>
<%
				}		
				else{
%>
					<td class="<%=classvalue%>" width="8%"  <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;
<%
					del_style	=	"<input type='checkbox'   name='del_detail"+recCount+"' id='del_detail"+recCount+"'  style='visibility:hidden' checked value='N' onClick='updateValue(this)'>"; 
%>
					<%=del_style%> </td>
<%
				}
			}
			else{
%>
				<td class="<%=classvalue%>" width="8%"  <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;
<%
				del_style	=	"<input type='checkbox'   name='del_detail"+recCount+"' id='del_detail"+recCount+"'  style='visibility:hidden' checked value='N' onClick='updateValue(this)'>"; 
%>
				<%=del_style%> </td>
<%
			}
		}	

	        bms_strength="";
			strength_uom="";
			
					if(!scope.equals("H") && scope!=null){	
						if(bms_qty.equals("") || Double.parseDouble(bms_qty)==0){  // bms_qty.equals("0.0") ) changed to bms_qty.equals("") || Double.parseDouble(bms_qty)==0 for KAUH-SCF-0096 [IN:035355]
							disable_complete_order	=	"disabled";
					   }
					   else{
							disable_complete_order	=	"";
					   }
					}
					
					
					/*if(stock_opt.size()!=0 && ((String)stock_opt.get(0)).equals("N")) {
						image		=	"<img src='../../eCommon/images/disabled.gif' align='center'>";
					}
					else {
						image		=	"";
					}*/
				
					alloc_empty_det	=	"<td class="+classvalue+" width='10%'>&nbsp;<label style='color:blue;cursor:pointer;font-size:9' id='alloc_detail"+recCount+"'>&nbsp;</label><input type='hidden' name='alloc_status"+recCount+"' id='alloc_status"+recCount+"' value=''></td>";
					
					if(!qty.equals("") && bean.getFilling(patient_id,order_id,order_line_no)) {
						alloc_det	=	"<td class="+classvalue+" width='10%' align='center'>&nbsp;<img src='../../eCommon/images/enabled.gif'><label id='alloc_detail"+recCount+"' style='visibility:hidden'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Det.label","ph_labels")+"</label><input type='hidden' name='alloc_status"+recCount+"' id='alloc_status"+recCount+"' value='P'></td>";

					}
					else {
					 
						alloc_det	=	"<td class="+classvalue+" width='10%'>&nbsp;<label style='color:blue;cursor:pointer;font-size:9' id='alloc_detail"+recCount+"' onClick='callAllocate(\""+patient_id+"\",\""+order_id+"\",\""+drug_code+"\",\"AS\",\"A\")'>&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Detail.label","common_labels")+"</label><input type='hidden' name='alloc_status"+recCount+"' id='alloc_status"+recCount+"' value='P'></td>";
					}

					filling_empty_det	="<td class="+classvalue+" width='8%'>&nbsp;<label id='fill_detail"+recCount+"'>&nbsp;</label><input type='hidden' name='fill_status"+recCount+"' id='fill_status"+recCount+"' value=''></td>";
					
					filling_det			="<td class="+classvalue+" width='10%'>&nbsp;<label style='color:blue;cursor:pointer;font-size:9' id='fill_detail"+recCount+"' onClick='callFilling(\""+patient_id+"\",\""+order_id+"\",\""+drug_code+"\",\"AS\",\"F\")'>&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Detail.label","common_labels")+"</label><input type='hidden' name='fill_status"+recCount+"' id='fill_status"+recCount+"' value='P'></td>";


					if(display_seq.equals("A")) {  
						if(allocation_reqd.equals("Y")) {
						  if(qty.equals("") && alt_qty.size() < 1) 	
							out.println(alloc_empty_det);
						  else	
							out.println(alloc_det);
						}

						if(filling_reqd.equals("Y")) { 
							if(qty.equals("") && alt_qty.size() < 1)
								out.println(filling_empty_det);
							else if((!qty.equals("") || alt_qty.size() >=1) && bean.getFilling(patient_id,order_id,order_line_no))
								out.println(filling_det);
							else 
								out.println(filling_empty_det);
						}	
					}
					else{	
						if(filling_reqd.equals("Y")) { 
							if(qty.equals(""))
								out.println(filling_empty_det);
							else if((!qty.equals("") || alt_qty.size() >=1) &&  bean.getFilling(patient_id,order_id,order_line_no))
								out.println(filling_det);
							else 
								out.println(filling_empty_det);
						} 
					 
						if(allocation_reqd.equals("Y")) {
							if(qty.equals("") && alt_qty.size() < 1) {	
								out.println(alloc_empty_det);
							}
							else{	
								out.println(alloc_det);
							}	
						}
					}
%>
					<input type="hidden"  name="order_line_num<%=recCount%>" id="order_line_num<%=recCount%>" value="<%=order_line_no%>">
					<input type="hidden"  name="pres_qty<%=recCount%>" id="pres_qty<%=recCount%>" value="<%=pres_qty%>">
<%
					if(disp_level.equals("P")) {	
%>
						<input type="hidden"  name="order_id<%=recCount%>" id="order_id<%=recCount%>" value="<%=order_id%>">
<%	
					}	
					if(scope.equals("H")){
						legend1=bean_1.getresultlinestatus(order_id,order_line_no);
				 
						if(legend1==null)
							legend1="";
						if(legend1.equals("OS"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outstanding.label","common_labels");
						else if(legend1.equals("DP"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PartiallyDispensed.label","ph_labels");
						else if(legend1.equals("RG"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProcess.label","common_labels");
						else if(legend1.equals("AL"))
							legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Alloocated.label","ph_labels");
					
						visibility1="visibility:visible";
						visibility2="visibility:hidden";
					}
					else{
						if(hold_text.equals("On Hold")){
							disable_complete_order	=	"disabled"; 
						}
						visibility1="visibility:hidden";
						visibility2="visibility:visible";
					}
%>
					<td class="<%=classvalue%>"  ><label style="color:red;font-size:9" id="result_line_status<%=recCount%>"style="<%=visibility1%>"><b><%=legend_text%></b></label>  
					<input type='checkbox'   name="CompleteOrder<%=recCount%>" id="CompleteOrder<%=recCount%>" value='N' onClick='setcompleteorder(this)'	style='visibility:hidden' <%=disable_complete_order%>   >
					<select name="ComplteOrderReason<%=recCount%>" id="ComplteOrderReason<%=recCount%>" style="<%=visibility2%>" onchange='setCheckBoxValueInAllStages(this,document.DispMedicationAllStages.CompleteOrder<%=recCount%>,document.getElementById("hold_remarks_"<%=recCount%>),<%=recCount%>)'  <%=disable_complete_order%> <%=disable_alloc_text_box%>>
					<option value="">------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
<%
				       for(int m=0; m<complete_reason_codes.size(); m=m+2){
%>
							<option value="<%=complete_reason_codes.get(m)%>"><%=complete_reason_codes.get(m+1)%></option>
<%
					   }
%>
					</select>	
					</td>
					<input type="hidden" name="release_flag<%=recCount%>" id="release_flag<%=recCount%>" value="N">  
					<input type="hidden" name="base_to_disp_uom_equl_val<%=recCount%>" id="base_to_disp_uom_equl_val<%=recCount%>" value="<%=base_to_disp_uom_equl%>">
					<input type="hidden" name="base_to_def_uom_equl_val<%=recCount%>" id="base_to_def_uom_equl_val<%=recCount%>" value="<%=base_to_def_uom_equl%>">
					<input type="hidden" name="dischargeIND<%=recCount%>" id="dischargeIND<%=recCount%>" value="<%=dischargeIND%>">
					<input type="hidden" name="allow_decimals_yn<%=recCount%>" id="allow_decimals_yn<%=recCount%>" value="<%=st_allow_decimals_yn%>">  <!-- Added for AAKH-SCF-0113 [IN:048937] -->
					<%-- <input type="hidden" name="taper_order_yn<%=recCount%>" id="taper_order_yn<%=recCount%>" value="<%=taper_order_yn%>">  Commented for RUT-CRF-0088 [IN036978] 
					<input type="hidden" name="taper_order_id<%=recCount%>" id="taper_order_id<%=recCount%>" value="<%=taper_order_id%>">
					<input type="hidden" name="taper_order_line_num<%=recCount%>" id="taper_order_line_num<%=recCount%>" value="<%=taper_order_line_num%>"> --%>
				</tr>
<%
				if(multi_drugs!= null && multi_drugs.size()>0 && alt_drug_code!= null && !alt_drug_code.trim().equals("")){
					stDrugCodes.remove(drug_code);
					stDrugCodes.add(alt_drug_code);
				}
				recCount++;
			}

			if(stDrugCodes.size()>0){
				sDispDrugAuthYN = bean.getDispDrugAuthYN(stDrugCodes);
			}    
%>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="bean_id_1" id="bean_id_1" value="<%=bean_id_1%>">
			<input type="hidden" name="bean_name_1" id="bean_name_1" value="<%=bean_name_1%>">
			<input type="hidden" name="disp_stage" id="disp_stage" value="<%=disp_stage%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
			<input type="hidden" name="pract_id" id="pract_id" value="<%=pract_id%>">
			<input type="hidden" name="pract_name" id="pract_name" value="<%=pract_name%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="recCount" id="recCount" value="<%=recCount%>">
			<input type="hidden" name="filling_status" id="filling_status" value="<%=filling_status%>">
			<input type="hidden" name="del_data" id="del_data" value="<%=del_data%>">
			<input type="hidden" name="source_code" id="source_code" value="<%=source_code%>">
			<input type="hidden" name="source_type" id="source_type" value="<%=source_type%>">
			<input type="hidden" name="ordering_facility_id" id="ordering_facility_id" value="<%=ordering_facility_id%>">
			<input type="hidden" name="ord_date_time" id="ord_date_time" value="<%=ord_date_time%>">
			<input type="hidden" name="performing_pract_id" id="performing_pract_id" value="<%=performing_pract_id%>">
			<input type="hidden" name="module_id" id="module_id" value="<%=module_id%>">
			<input type="hidden" name="mode" id="mode" value="<%=CommonRepository.getCommonKeyValue( "MODE_MODIFY" )%>">
			<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>">
			<input type="hidden" name="curr_stage" id="curr_stage" value="<%=curr_stage%>">
			<input type="hidden" name="disp_level" id="disp_level" value="<%=disp_level%>">
			<input type="hidden" name="disp_locn_catg" id="disp_locn_catg" value="<%=disp_locn_catg%>">
			<input type="hidden" name="ord_type" id="ord_type" value="<%=ord_type%>">
			<input type="hidden" name="IssueByUOM" id="IssueByUOM" value="<%=bean_1.getIssueByUOM()%>">
			<input type="hidden" name="EquivalentNormalOrder" id="EquivalentNormalOrder" value="<%=bEquivalentNormalOrder%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean_1.getSFunctionId()%>">
			<input type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
			<input type="hidden"  name="delivery_reqd" id="delivery_reqd" value="<%=delivery_reqd%>">
			<input type="hidden" name="IncludeZeroQty" id="IncludeZeroQty" value="<%=strIncludeZeroQty%>"><!-- Added for MO-GN-5434 [IN:043669]  -->
			<input type="hidden" name="pres_qty_alert" id="pres_qty_alert" value="<%=pres_qty_alert%>"><!-- code added for AMS-CRF-0035[IN033551] --> 
			<input type="hidden" name="includeBMSDefCheck_yn" id="includeBMSDefCheck_yn" value="<%=includeBMSDefCheck_yn%>"><!-- code added for [IN:045055](Bru-HIMS-CRF-281[IN:033166]) -->   
			<input type="hidden" name="strAutoCompletePartialDisp" id="strAutoCompletePartialDisp" value="<%=strAutoCompletePartialDisp%>"><!-- Added for JD-CRF-0179 [IN:41211] -->   
			<input type="hidden" name="no_of_decimals" id="no_of_decimals" value="<%=st_no_of_decimals%>"> <!-- Added for AAKH-SCF-0113 [IN:048937] -->
			<input type="hidden" name="disp_decimal_dtls_yn" id="disp_decimal_dtls_yn" value="<%=st_disp_decimal_dtls_yn%>"> <!-- Added for AAKH-SCF-0113 [IN:048937] -->
			<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>">
			<input type="hidden" name="allow_amend_alt_drug_dtl" id="allow_amend_alt_drug_dtl" value="<%=allow_amend_alt_drug_dtl%>"> <!-- Added for JD-CRF-0198 [IN058599] -->
			
<%
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
%>
				<input type="hidden" name="bl_encounter_id" id="bl_encounter_id" value="<%=bl_encounter_id%>">
				<input type="hidden" name="bl_patient_class" id="bl_patient_class" value="<%=patient_class%>">
				<input type="hidden" name="bl_sysdate" id="bl_sysdate" value="<%=sysdate%>">	
				<input type="hidden" name="tot_gross_charge_amount" id="tot_gross_charge_amount" value="<%=tot_gross_charge_amount%>">
				<input type="hidden" name="tot_groos_pat_payable" id="tot_groos_pat_payable" value="<%=tot_groos_pat_payable%>">
<%
			}
%>
		</form>
<%
		if(!decimalFormatString.equals("")&&billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
			DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);
			tot_gross_charge_amount_str = dfTest.format(tot_gross_charge_amount);
			tot_groos_pat_payable_str   = dfTest.format(tot_groos_pat_payable); 
		}

		if(item_uom_definition_flag){%>
   
			<script>alert(getMessage("PH_ITEMS_UOM_DEF_NOT_FOUND","PH"));</script>
<%
		}
%>
<%! 
		DecimalFormat dfToInteger = new DecimalFormat("#.####");
		private String retunFormatedInt(String sValue){
			if(sValue != null && !sValue.equals("")){
				return dfToInteger.format(Double.parseDouble(sValue));
			}
			return "";
		}
%>
	</body>
	<script>
<% 
		if(allocation_reqd.equals("Y") && filling_reqd.equals("Y"))  { 
%>
			controlAllocFillingButtons();
<%
		}
		else if(allocation_reqd.equals("Y") && delivery_reqd.equals("Y")) { 
%>	
			controlAllocButton();
<%	
		}
		else if(filling_reqd.equals("Y") && delivery_reqd.equals("Y") ) { 
%>
		//	controlFillingButton(document.DispMedicationAllStages);
<%	
		}
%>
		//callLegendsFrame('<%=patient_id%>','AS','','','<%=order_id%>');
		callLegendsFrame('<%=patient_id%>','AS','','','<%=order_id%>','<%=billing_interface_yn%>','<%=tot_gross_charge_amount_str%>','<%=tot_groos_pat_payable_str%>','','<%=sDispDrugAuthYN%>');
	</script>
</html>
<%
	bean.clearAlEditLabelPairValues();
	bean.setAlEditLabelPairValues(alEditLabelPair);
	medplan_bean.setMedOrderIds(arrOrderId);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
	putObjectInBean(medplan_bean_id,medplan_bean,request);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
	putObjectInBean(param_bean_id,param_bean,request);
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_1,bean_1,request);
	putObjectInBean(bean_id_2,bean_2,request);
	putObjectInBean(bean_id_st,bean_st,request); // Added for KAUH-SCF-0094 [IN:035252] 
%>

