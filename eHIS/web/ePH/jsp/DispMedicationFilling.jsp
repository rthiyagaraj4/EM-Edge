<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%> 
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>    
<%-- Mandatory declarations end --%>    
<html>  
	<head>         
<%
System.out.println("==============in==========>DispMedicationFilling.jsp");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String bl_install_yn= CommonBean.checkForNull((String) session.getValue( "bl_operational" ),"N") ; //GHL-CRF-549
  
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../ePH/js/PPNRegimen.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
	<body onMouseDown="" onKeyDown="lockKey()">
	<style> <!-- Added for MMS-KH-CRF-0013 - Start -->
	TD.DINTERACN{ 
		BACKGROUND-COLOR:pink;
		FONT-SIZE: 8pt ;
		height:15;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #663300 0px solid;
	        BORDER-LEFT: #663300 0px solid;
	        BORDER-RIGHT: #663300 1px solid;
	        BORDER-TOP: #663300 1px solid;
        } 
        TD.EXPIRED_ORDER{    /* added for MOHE-CRF-0032 */
			BACKGROUND-COLOR:#FFA500; //code modified for MOHE-CRF-0032
			FONT-SIZE: 8pt ;
			height:10;
			BORDER-STYLE: solid;
	}      
	/* Added for aakh-crf-0140 */
	TD.ABUSE_REMARKS{ 
		BACKGROUND-COLOR:purple;
		FONT-SIZE: 8pt ;
		height:15;
		BORDER-STYLE: solid;
		BORDER-BOTTOM: #663300 0px solid;
	        BORDER-LEFT: #663300 0px solid;
	        BORDER-RIGHT: #663300 1px solid;
	        BORDER-TOP: #663300 1px solid;
		
        } 
        table>*
        {
        	white-space: nowrap;
        }      
        
	</style>  <!-- Added for MMS-KH-CRF-0013 - End -->
<script>//Adding start for TH-KW-CRF-0008
			window.onload = function(){
				window.setInterval("blinkImage()",500);
				window.setInterval("blinkPatExp()",500);
			}
</script><!-- Adding end for TH-KW-CRF-0008 -->
		<form name="DispMedicationAllStages" id="DispMedicationAllStages" >
<%               
        Connection con			= null; 
        con				= ConnectionManager.getConnection(request);
        boolean complete_ord_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","COMPLETE_ORD_YN");
        boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");
        boolean displayGrossAmtYn= eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN");
       	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");
       	boolean intractn_req_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_STAGE_INTRACTN_REQ_YN");	
	boolean barcode_scan_for_alt_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","BARCODE_SCAN_FOR_ALT_APP"); 
         boolean approval_no_flag = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","APPROVAL_NO_APPLICABLE_FLAG");
		boolean formulary_billing_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FORMULARY_BLG_GRP_APP"); 
		boolean expired_order = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","EXPIRY_ORDER_APP");
		boolean finding_remarks_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","FINDING_REMARKS_APP");
		boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
		boolean site_remarks=eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "DISP_REMARKS");//added for ML-MMOH-CRF-1755
		try{
			String	bean_id						=	"DispMedicationAllStages" ;
			String	bean_name					=	"ePH.DispMedicationAllStages";
			DispMedicationAllStages bean		= (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
			bean.setLanguageId(locale);
			
			String	bean_id_1					=	"DispMedicationBean" ;
			String	bean_name_1					=	"ePH.DispMedicationBean";
			DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
			bean_1.setLanguageId(locale);

			String facility_id					= (String) session.getValue("facility_id");
			String param_bean_id				= "@DrugInterfaceControlBean";
			String param_bean_name				= "ePH.DrugInterfaceControlBean";
			DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
			String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
			param_bean.clear();

			String Image_bean_id				= "@DrugTradeImageBean";
			String Image_bean_name				= "ePH.DrugTradeImageBean";
			DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );
			ArrayList listRecord				= new ArrayList(); 
			String	bean_id_st		   			= "batchSearchBean" ;
			String	bean_name_st		   		= "eST.BatchSearchBean"; 
			request.setAttribute("p_list_all_trades_yn","Y");
			BatchSearchBean bean_st				= (BatchSearchBean) getBeanObject( bean_id_st,bean_name_st,request );
			bean_st.setLanguageId(locale); 
			String medplan_bean_id="MedicationPlannerBean";
			String medplan_bean_name="ePH.MedicationPlannerBean";
			MedicationPlannerBean medplan_bean = (MedicationPlannerBean)getBeanObject( medplan_bean_id, medplan_bean_name,request);// Added for Bru-HIMS-CRF-072.1[IN 049144]
			bean_1.setObject(medplan_bean);
			
			String	bean_id_2		=	"StUtilities" ;
			String	bean_name_2		=	"eST.Common.StUtilities";
			StUtilities bean_2=null;
			SalesBean stSalseBean				=	(SalesBean)getBeanObject( "salesBean", "eST.SalesBean", request );
			ArrayList alEditLabelPair			= new ArrayList();
			HashMap hmEditLabelValues			= new HashMap();
			boolean bEditLabelEnabled			= false;
			String sDispDrugAuthYN				= "N";
			boolean bKeepQty					= false;
			boolean bPatientPaid				= false;
			String pat_paid_amt	,pat_net_charge_amt;
			String medical_applicable="";
			DecimalFormat dfToInteger = new DecimalFormat("#.####");
			String primary_lang_id = medplan_bean.getStrPrimaryLangID();
			String loc_lang_id = medplan_bean.getStrLocalLangID();
			String strIncludeZeroQty    = bean_1.getStrIncludeZeroAllocQtyItems();
			String strAutoCompletePartialDisp	= 	bean_1.getAutoCompletePartialDisp(); 
			String allow_amend_alt_drug_dtl     =   bean_1.getAmendAltDrugDtlYN(); 
			String Disp_drug_verify_remarks  =bean_1.getDisp_drug_verify_remarks_yn();//added for ml-mmoh-crf-1755
			String strIncludeZeroQtyForIP    = bean_1.getStrIncludeZeroAllocQtyItemsForIP();

			try { 
				bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
				bean_2.setLanguageId(locale);
			}
			catch (Exception exception) {
				out.println(exception);
				exception.printStackTrace();
			}
			String  billing_interface_yn		=	bean.getBLInterfaceYN();
			String disp_locn_catg	=	bean_1.getDispLocnCatg();
			String patient_class	=	"";
			ArrayList	stk_units	=	new ArrayList();
			String orig_dflt_issue_uom		= "";

			if(disp_locn_catg.equals("I")) {
				patient_class		=	"IP";
				strIncludeZeroQty	=	"N";
				strAutoCompletePartialDisp = "N";	
			} 
			else {
				patient_class		=	"OP";
			}
			String fill_list		= bean_1.getFillList().trim();
			String check_yn			= "N" ;
			
			String strAllocBMSChkValue  = "N";
			String strAllocBMSChecked   = "";
			String tpn_wrksheet_rcrd	= "N";
			String 	alt_external_prod_id = "", alt_drug_desc_1="", drug_name_1="";
			ArrayList alt_qty = null;
			int	k	=	0;
			
			String approval_no_app_for_patient_class = "N";
			String approval_no_style = "visibility:hidden";
			if(approval_no_flag){
			   approval_no_app_for_patient_class = bean.getApprovalNoApplicableForPatientClass(patient_class);
			}
		
			String tpn_finalize = request.getParameter("TPN_FINALIZE");
			if(tpn_finalize==null)
				tpn_finalize = "";
			if(tpn_finalize.equals("YES")){
				bean_1.setWsStatus("C");
				tpn_wrksheet_rcrd	= "Y";
			}
			else if(tpn_finalize.equals("NO")){
				bean_1.setWsStatus("I");
				tpn_wrksheet_rcrd	= "N";
			}
			String tot_gross_charge_amount_str	=  "";
			String tot_groos_pat_payable_str	=  ""; 
			String tot_gross_amount_str         =	"";	
			String tpn_qty						= "";
			String gross_amount_str             =   ""; 
			float tot_gross_charge_amount		=   0;
			float tot_groos_pat_payable			=   0; 
			float  tot_gross_amount             =   0; 
			boolean approval_flag = false;
			if(!tpn_finalize.equals("")&&billing_interface_yn.equals("Y")){
				tot_gross_charge_amount_str	= request.getParameter("tot_groos_pat_payable_str");    
				tot_groos_pat_payable_str	= request.getParameter("tot_gross_charge_amount_str");
				tot_gross_amount_str         =request.getParameter("tot_groos_pat_payable_str");
				if(!tot_gross_charge_amount_str.equals("")){
					tot_gross_charge_amount = Float.parseFloat(tot_gross_charge_amount_str);	
				}
				if(!tot_groos_pat_payable_str.equals("")){
					tot_groos_pat_payable   = Float.parseFloat(tot_groos_pat_payable_str);
				}
				if(tot_gross_charge_amount!=tot_groos_pat_payable)
					approval_flag = true;
				if(!tot_gross_amount_str.equals("")){ 
					tot_gross_amount   = Float.parseFloat(tot_gross_amount_str);
				} 
			}
			bean_1.setObject(bean);	
			bean.loadReason();
			bean.setModuleId("2");

			String iv_prep_yn				="";
			Hashtable param_legends			=	bean_1.getLegendsFromParam();
			String disp_stage				=	bean_1.getDispStage();
			String encounter_id				=	bean_1.getEncounterID();
			String order_type				=   bean_1.getOrderType();	
			
			if(order_type.equals("TD") && tpn_mf_label){
				bean_1.setWsStatus("C");
				tpn_wrksheet_rcrd	= "Y";
			}	
			String patient_id				=	request.getParameter("patient_id");
			String order_id					=	request.getParameter("order_id");			
			String form_desc            = "";
			String legend				    =   com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CompleteOrderReason.label","ph_labels"); //"Complete Order Reason";
			String disp_locn_code			=   bean_1.getDispLocnCode();
			String legend_text				=   "";
			String legend1					=   "";
			String legend2					=   "";      
			String scope					=   bean_1.getScope();
			String visibility1				=	"";
			String visibility2				=	"";
			String visibility3				=	"";  
			String disable_complete_order	=	"";
			String complete_order_checked	=	"";
			String complete_order_value		=	"";
			Hashtable ht_ws_alloc_qty		=   null;
			String pat_reqd					=	"";
			String pt_couns_reqd_yn			=	"";
			String fractroundupyn			=   "";
			String image_path				=   "";
			String trade_code			    =   "";
			int adr_count					=   0;
			String admixture_yn				=  "N";
			String display_list = "";
			String dischargeIND = "";
			String strBMS_Include_yn ="N";
			String home_med_yn ="", home_med_style="",home_med_style_1="";
			String alt_drug_remarks_ind =bean_1.getAltDrugRemarksInd();
			String alt_drug_remarks_disp = ""; 
			float tot_tap=0; 
			HashMap taperValues = new HashMap(); 
			String totalTaperQtyDisplay = bean_1.getTotalTaperQtyDisplay();
			String includeBMSDefCheck_yn= bean_1.getIncludeBMSDefCheck();
			int count = 0;
			StringBuffer drugs_remarks  = null ;
			String strDrugsRemarks="";
			String drug_desc = "";
			String disc_cancelled_orders="", appl_for_compounding_rx_yn="",  disc_cancelled_orders_display="display:none;", disp_mnf_flag	= "display:none"; //Added for HSA-CRF-0138 [IN:048414] & Bru-HIMS-CRF-080
			String st_no_of_decimals ="",  st_disp_decimal_dtls_yn="", st_allow_decimals_yn="N"; 
			st_no_of_decimals = bean.getSt_no_of_decimals();
			st_disp_decimal_dtls_yn =bean.getSt_disp_decimal_dtls_yn();
			String dose_unit_desc="";
			String drug_expiry_alert ="";//Added for TH-Kw-CRF-0008
			String drug_expiry_days ="";//Added for TH-Kw-CRF-0008
			String insurance_status ="";//Added for TH-KW-CRF-0012
			HashMap insuranceStatus = bean.getInsuranceStatus();//Added for TH-KW-CRF-0012
			if(patient_class.equals("IP")){
				scope					=   bean_1.getIPScope();
			}
			else{
				scope					=   bean_1.getScope();
			}
			if(scope.equals("H")){
				legend					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ResultLineStatus.label","ph_labels");
			}
  			else if (patient_class.equals("IP") && scope.equals("A") ){				
  				legend2					=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ResultLineStatus.label","ph_labels");
  			} 

			String disable_all  ="";
			if(((disp_stage.equals("F") && (bean_1.getFillingStatus().equals("A")  ))|| (disp_stage.equals("A") && (bean_1.getFillingStatus().equals("B")  )))&&(!disp_locn_catg.equals("I")) && !scope.equals("H")  ){ //'&& !scope.equals("H")' added for [IN039007]
				 bKeepQty	= bean_1.getEditValues(); // This value should be used to load the qty values frm database if allocation is in second stage.			 
				if(!bKeepQty){
					 display_list	=	"display:none";
				}
			}
			if (order_id==null){
				order_id	=	"";
			}	
			if (patient_id==null){
				patient_id	=	"";
			}
			if(patient_id.equals(""))
					patient_id	=	bean_1.getPatientID();
			
			String bean_id2					= "@PrescriptionBean_1"+patient_id+encounter_id; 
                        String bean_name2		= "ePH.PrescriptionBean_1"; 
                        PrescriptionBean_1 pres_bean =  (PrescriptionBean_1)getBeanObject( bean_id2,bean_name2,request) ;
                        pres_bean.setLanguageId(locale);                       
		
			String order_line_no		=	"";
			String drug_code			=	"";
			String drug_name			=	"";
			String dosage_dtls			=	"";
			String dosage_type			=	"";
			String dosage_unit			=	"";
			String std_dose             =   "";
			String end_date				=	"";
			String start_date			=	""; 
			String pres_qty				=	"";
			String qty_uom				=	"";
			String qty_uom_disp			=	"";
			String alt_drug_code		=	"";
			String alt_drug_desc		=	"";
			String drug_color			=	"";
			String form_code			=	"";
			String hold_status			=	"";
			String uom					=	"";
			String 	hold_text		    = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
			String check_value			=	"N";
			String fromdb				=	"N";
			String check_status			=	"";
			String alt_drug_qty			=	"";
			String allergy				=	"";
			String exceed_dose			=	"";
			String generic_id			=	"";
			String generic_name			=	"";
			String dosage_details		=	"";
			String exceed_status		=	"";
			String strChangedFludRmks	=	"";
			String monograph			=	"";
			String unit_dose			=	"";
			String daily_dose			=	"";
			String bms_qty				=	"";
			String source_code			=	"";
			String source_type			=	"";
			String ordering_facility_id	=	"";
			String ord_date_time		=	"";
			String performing_pract_id	=	"";
			String duplicate_yn			=	"";
			String min_dose_dtls		=	"";
			String min_unit_dose		=	"";
			String min_daily_dose		=	"";
			String alloc_qty_from_tmp	=	"";
			String strength_uom			=	"";
			String strength_uom_disp	=	"";
			String strength_value		=	"";
			String classvalue			=	"";
			String strength				=	"";
			String pres_strength		=	"";
			String alt_strength_value	=	"";
			String alloc_strength		=	"";
			String bms_strength			=	"";
			String drug_class			=	"";
			String expired_yn			=	"";
			String in_formulary_yn		=	"";
			String tmp_bms_qty			=	"";
			String drug_remarks			=	"";
			String prn_remarks			=	"";
			String pharma_remarks		=	"";		
			String slidingscaleremarks	=   "";
			String verificationremarks	=   "";
			String pres_remarks			=	"";
			String remarks_style		=	"";	
			String pat_couns_reqd_yn	=   "";	
			String module_id			=	bean.getModuleId(); 	
			String image				=	"";
			String alt_drug				=	"";
			String title_remarks		=	"";
			String title				=	"";
			String pres_details			=	"";
			String qty					=	"";	
			String narc_style			=	"";
			String ext_prod_id			=	"";
			String tmp_bms_qty_1		=	"";
			String order_line_status = "";   
			String currentdateplusFillPeriod		=  	"";	
			boolean	endDateIsbeforeFilldate			= 	false;
			String pres_strength_1        = ""; 

			HashMap pack_dtls			=	null;
			ArrayList result			=	null;
			ArrayList orderLineDtls		=	new ArrayList();
			ArrayList multi_drugs		=	null;
			ArrayList disp_info			=	new ArrayList(2);
			ArrayList stock_opt			=	new ArrayList();
			String barcode_id = "";
			ArrayList	colors			=	bean_1.getColors();
			String min_stk_flag	=	"display:none;align:right";
			String min_stk_flag_bkg_clr	=	"background-color:none";
			String rol_flag_bkg_clr		=	"background-color:none";
			String rol_flag			=	"display:none";
			String disp_req_flag	= "display:none;color:blue";
			
			boolean min_stk	= false;
			boolean rol_stk	= false;
			HashMap rol_min		= null;
			String frm_store_min_stk_level  = "";
			String frm_store_reorder_level =  "";
			String[] stParameters = {alt_drug_code, disp_locn_code, "0", "N", "", "N", "" };
			HashMap hmStockAvailabilityStatus = null;
			boolean Min_Rol_yn	=bean_1.getMin_Rol_yn();
			boolean getReq_allowed_yn =bean_1.getReq_allowed_yn(); 

			StringTokenizer token		=	null;
			float dialog_height			=	0;
			float	main_drug_pack_size =   0;
			float main_pack_size		=   0;	
			double ws_tot_qty			=	0;
			double tot_qty				=	0;
			int bmscount                =   0;
			int recCount				=	1;
			double tmp_alloc			=	0;
			String allow_alternate_yn="";
            String expiry_date="";
			String alt_called_from="";
			ArrayList alOrderIds = new ArrayList();
			ArrayList tmpResult = new ArrayList();

			if(bean_1.getAlTrxOrderIds()!=null){
				alOrderIds = bean_1.getAlTrxOrderIds();
				if(alOrderIds != null && alOrderIds.size()>0){
					iv_prep_yn		=   bean.getIVFlag(alOrderIds.get(0).toString());
					iv_prep_yn		=	iv_prep_yn==null?"":iv_prep_yn;			
					bean_1.setWsType(iv_prep_yn);
				}
			}
			
			String disp_level			= bean_1.getDispLevelValue();
			if(disp_level.equals("P")) {
				
				result			= bean_1.getOrders(patient_id.trim());
				if(bean_1.getCriteriaOrderType()!=null && (bean_1.getCriteriaOrderType().equals("ALL") || bean_1.getCriteriaOrderType().equals("CDR") ||(tpn_mf_label && bean_1.getCriteriaOrderType().equals("TD")))){ // TD added for ml-mmoh-crf-0468 CDR Condition Added for ML-MMOH-CRF-0435 [IN:057357]
					if(alOrderIds.size()>0){
						for(int i=0;i<result.size();i=i+11) {	
							if(alOrderIds.contains(result.get(i+1))){
								for(int j=i;j< i+11;j++)
									tmpResult.add(result.get(j));
							}
						}
					}
					result = tmpResult;
				}
				ArrayList tmp	= new ArrayList();
				for(int i=0;i<result.size();i=i+11) {	
					tmp = (ArrayList)bean_1.getOrderLineDetails(patient_id,(String)result.get(i+1));
					
					if(tmp.size()!=0) {
						orderLineDtls.add((String)result.get(i+1));
						orderLineDtls.add((String)result.get(i+3));
						orderLineDtls.add((String)result.get(i+4));			
						for(int j=0; j<tmp.size(); j++)
							orderLineDtls.add(tmp.get(j));
					}
				}
			} 
			else {
				orderLineDtls					= (ArrayList)bean_1.getOrderLineDetails(patient_id,order_id);
			}
			ArrayList complete_reason_codes		= (ArrayList)bean.getCompleteReasonCodes();
			String disp_delivery_chk_box_val	=	"Y";
			String width						=	"100%";
			String bl_encounter_id				=	bean_1.getEncounterID();
			String sysdate						=   bean_1.getTodaysDate();
			String bl_patient_class				=	"";
			String bl_display                   =	"Y"; 
			String ord_type						=	bean_1.getOrderType();   
			String gross_charge_amount_str		=   "";
			String groos_pat_payable_str		=   "";
			String decimalFormatString			=   "";
			String	batch_str					=   "";
			String gross_admx_prep_charge		=	"";
			String groos_pat_payable_admx_prep_charge	=	"";  
			String gross_amount_change          ="";
			String worksheet_id                =  "";
			HashMap batch_data=new HashMap();
			ArrayList temp=  new ArrayList();
			
			String drug_db_product_id				=	"";
			String allergy_override_reason			=	"";
			String dosage_limit_override_reason		=	"";
			String duplicate_drug_override_reason	=	"";
			String interaction_override_reason		=	"";
			String contraind_override_reason		=	"";	
			String food_interaction_override_reason =   "";
			String lab_interaction_override_reason =   "";
			String disease_inter_override_reason =   "";//Added for MMS-DM-CRF-0229
		
			boolean bEquivalentNormalOrder		    =   false;

			if(ord_type.equals("ALL") && result != null && result.size() >0 && result.get(8) == null)
				bEquivalentNormalOrder = true;

			if(!((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I"))  || disable_all.equals("disabled")  ){
				display_list ="display:none" ;
			}

			if(order_type.equals("TA") ||(order_type.equals("TD") && tpn_mf_label)){
				worksheet_id=bean_1.getTPNWorksheetID(order_id);
			}else{
				worksheet_id=bean_1.getWorksheetID(); 
			}
			String admx_prep_charges_appl_yn    = bean_1.getadmx_prep_charges_appl_yn();
		/*=================code for auto defaulting batches for normal RX===============*/
			ArrayList items				=	null;
			ArrayList stock_det			=	null;
			ArrayList alloc_drug_detail	=	null;
			ArrayList alloc_batch_detail=	null;
			HashMap batch_det			=	null;	
			HashMap	 stock				=	null;
			String item_code			=	"";
			String store_code			=	"";
			String fill_period			=	null;
			String fill_unit			=	null;
			String item_cost			=   "";
			String issue_qty			=	"";	
			String avail_qty			=	"";
			String act_bms_qty			=	"";
			String disp_catg	        = bean_1.getDispLocnCatg();
			String alloc_readonly       = "";
			String first_time_yn        ="N";
			String main_strength_per_value_pres_uom ="";
			String zero_alloc_qty_item_yn ="N";
		/*==================code for variable UOM==============================*/
			HashMap IssueUOMAndBaseUOM		 = new HashMap();
			HashMap IssueUomQty				 = new HashMap();
			String issue_qty_value			 = "";	  
			String issue_uom_desc			 = ""; 
			String dflt_issue_uom			 = "";
			String base_uom					 = "";
			String issue_uom				 = "";
			String issue_uom_equl			 = "";
			double base_to_disp_uom_equl	 = 0;
			double base_to_def_uom_equl		 = 1;
			double issue_qty_val			 = 0;
			double conv_factor				 = 1;
			double tmp_unit_qty			     =	0;
			double tot_issued_qty			 =	0;
			float opdispperiod               =  0;  
			StringBuffer issue_qty_dtl		 = new StringBuffer();
			boolean item_uom_definition_flag = false;
			String  billable_item_yn		 =	"";
			
			String preference = "";  
			String preference_img = ""; 
			String formulary_value = "";
			String formulary_code  = "";
			String blg_grp_type = "";
			HashMap hmBlgGrp = null;
		
			if(ord_type.equals("TA")){
					bl_display                   ="N"; 			
			}
			if(billing_interface_yn.equals("Y")){	
				 width			=	"120%"; 
				 bl_patient_class  =   bean.getEncounterPatientClass(bl_encounter_id, patient_id); 
			}
			if(!order_type.equals("TA")){	
				if(((bean_1.getHTWSAllocateBatches()).size()==0)&&(!worksheet_id.equals(""))){
					bean_1.setWSDrugDetails(order_id,worksheet_id);
					bean_1.setWSBatchDetails(order_id);
				}
			}
			String pres_qty_alert = bean_1.getPresQtyAlert(); 	
			if(("").equals(pres_qty_alert)){
				pres_qty_alert="N";	
			}
			String barcodeScan = "";
			String last_scanned ="";
			if(bean_1.getBarcode_id().equals("") && bean_1.getOrderType().equals("NOR")){
			   barcodeScan=bean_1.getBarcode_Scan_YN(); 
			}
%>
			<input type="hidden" name="alloc_fromBarCode" id="alloc_fromBarCode" value="N">
			<input type="hidden" id="barcode_scan_yn" value="<%=barcodeScan%>">
			<table cellpadding="0" cellspacing="0" width='<%=width%>' align="center" border="1" id="fillingTable">
				<tr>
				<%	                if(intractn_req_yn && order_type.equals("NOR") && fill_list.equals("WF")){ 
                 %>
                              <td class= "COLUMNHEADER" width="4%" style="font-size:9px"><fmt:message key="Common.Select.label" bundle="${common_labels}"/>
							   <input type="checkbox" value="Y" name="selectAll" id="selectAll" checked onClick="selectAllRcordsDeliver(this,'<%=disp_stage%>')" >
							  </td>
							 
<%	                } 
					else{ %>
<%					if(fill_list.equals("WF")){
%>						<td class= "COLUMNHEADER" width="4%" style="font-size:9px">Print</td>
					<%					}}
%>	
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><%=param_legends.get("V")%> <fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER" width="3%" style="font-size:9px"><fmt:message key="ePH.HoldStatus.label" bundle="${ph_labels}"/></td>
					<td  class="COLUMNHEADER" width="2%"  style="font-size:9px" >&nbsp;</td>
<%			        if(!fill_list.equals("AF") && patient_class.equals("IP") ){%>
					<td  class="COLUMNHEADER" width="3%"  style="font-size:9px" >&nbsp;</td>
<%
					}

					if(bl_install_yn.equals("Y") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") && item_type_site_app && !encounter_id.equals("")){	
 %>					<td width="5%" class= "COLUMNHEADER" style="font-size:9px" nowrap><fmt:message key="ePH.ItemType.label" bundle="${ph_labels}"/></td>
 <%					if(formulary_billing_app){	//GHL-CRF-0549 
					%>
					<td  class="COLUMNHEADER" width="2%"  style="font-size:9px" >&nbsp;</td>
					<%}%>	 
 <%}%>
					<td class= "COLUMNHEADER" width="35%" style="font-size:9px"><fmt:message key="ePH.Drug/DosageDetails.label" bundle="${ph_labels}"/></td>
					<td class= "COLUMNHEADER"style="font-size:9px" width="3%">&nbsp;</td>
					<td class= "COLUMNHEADER" style="font-size:9px" width="3%">&nbsp;</td>
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.PrescribedQuantity.label" bundle="${ph_labels}"/></td>
					<td align="right" class="COLUMNHEADER" width="10%" style='<%=display_list%>'><fmt:message key="ePH.ISSUEUOM.label" bundle="${ph_labels}"/>&nbsp;</td>
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><%=param_legends.get("F")%> <fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
					<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.BalanceQuantity.label" bundle="${ph_labels}"/></td>
<% 				if(billing_interface_yn.equals("Y") ){%>
                        <%if(bean.getDisplayInsStatus()){ %><!-- //Added for TH-KW-CRF-0012 -->
                        <td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="Common.Insurance.label" bundle="${common_labels}"/> <fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
						<% } %>
                      
                        <%if(displayGrossAmtYn){ %>
                        <td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/></td>
						<% } %>
						
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="Common.ChargeAmount.label" bundle="${common_labels}"/></td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.PayableAmount.label" bundle="${ph_labels}"/>&nbsp;</td>
						<td class= "COLUMNHEADER" width="10%" style="font-size:9px"><fmt:message key="ePH.OverrideIncl/Excl.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>  
<%				}%>
					<td class= "COLUMNHEADER" width="10%" nowrap style="font-size:9px"><%=param_legends.get("F")%> <fmt:message key="Common.status.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class= "COLUMNHEADER" width="15%" style="font-size:9px"><%=legend%></td>
					<% if(patient_class.equals("IP") && scope.equals("A")) {  %>	 	
					<td class= "COLUMNHEADER"  width="15%" style="font-size:9px"><%=legend2%></td>
					<% }
					if(approval_no_flag){ %>
					<td class= "COLUMNHEADER" width="15%" style="font-size:9px">  <fmt:message key="ePH.ApprovalNo.label" bundle="${ph_labels}"/> &nbsp;&nbsp;&nbsp;&nbsp;</td>
					<%} %>
				</tr>
				<%
HashMap hmOrderDispDrugDetails = new HashMap();
				String sRepeatFreqCode		   = null;
				String sFreqCode			   = null;
				boolean bAltQtyAvailable	   = true;  
				boolean bPRNOrAbsOrder		   = false;
				boolean bDrugOrder			   = true;
				Set stDrugCodes				   = new HashSet(); 
				String disable_alloc_text_box =  "";
				//String taper, taper_order_yn="", taper_order_id="", taper_order_line_num="", show_remarks="",taper_disable="";
				String taper, show_remarks="",taper_disable=""; 
				HashMap OrderIDS            = new HashMap();
				Hashtable ht_ws_allocated_batches = null;
				String ws_item_code = "";
				String ws_drug_code = "";
				Hashtable ht_drug_details	    = null;
				ArrayList arr_list_drug_details = null;
				String qty_avail_from_spillage = "0";
				String sOrderType, sAbsOrder;
				HashMap Order_id_amend_yn=null;
				LinkedHashMap hsh_med_plan = new LinkedHashMap();
				ArrayList arrOrderId = new ArrayList();
				HashMap<String,String> altDrugName = new HashMap<String,String>();
				String dosedet[] = new String[4],dosedetlocal[] = new String[4];
				String dispno[] = new String[2];
				HashMap printValue = bean_1.getPrintValue(); 
				String print_value = "";
			
				String bl_grp_app		   = "";
				String mm_item_low_cost_yn = "";	
				String mm_item_high_margin_yn = "";
				String mm_item_Innovator_yn = "";
				String item_type = "";
				if(item_type_site_app && !encounter_id.equals("")){
					bl_grp_app = bean.getItemTypeApp(patient_id);
				}
				
				if(formulary_billing_app){
				String blng_grp_id = bean.getBillingGrpId();
				formulary_value = bean.getFormularyBillingGrpCode(blng_grp_id);
				formulary_code = formulary_value.substring(0, formulary_value.indexOf("~"));
				blg_grp_type = formulary_value.substring(formulary_value.indexOf("~")+1);
				if(!formulary_code.equals(""))
				 hmBlgGrp = bean.getFormularyBillingGrpCodeDtl(formulary_code,blng_grp_id);
			}
				ArrayList celling_dose = null;
				String min_unit_ceiling_dose = "", max_unit_ceiling_dose = "", min_daily_ceiling_dose = "", max_daily_ceiling_dose = ""; 
				String ceil_dose_unit_desc    = ""; 
				HashMap lab_food_interaction =null;
				HashMap approvalNo = bean_1.getApprovalNo();
				 String approval_no="";
				//added for IN070605 END
					
					String abuse_drug_override_reason="";//added for aakh-crf-0140  drug_abuse_appl
					String abuse_exists="";//added for aakh-crf-0140
					String drugIndication="";//added for jd-crf-0220
          String	category_code="";//added for mms-dm-crf-209.1
					String	alternate_yn="";//added for mms-dm-crf-209.1
				for(int i=0;i<orderLineDtls.size(); i++){
					bAltQtyAvailable	=   true;
					bDrugOrder			=   true;
					sRepeatFreqCode		=   "";
					sFreqCode			=   "";
					check_yn			=   "N";
					strength			=	"";	
					hold_status			=	"";
					pres_strength		=	"";
					tot_qty				=	0;
					stock_opt			=	new ArrayList();
					image				=	"";
					alloc_strength		=	"";
					tmp_alloc			=	0;
					disp_info			=	new ArrayList(2);
					title_remarks		=	"";
					title				=	"";
					narc_style			=	"";
					pres_details		=	"";
					fractroundupyn      =   "";
					approval_no			=   "";
				
						celling_dose			= null;
						min_unit_ceiling_dose = "";
						max_unit_ceiling_dose = "";
						min_daily_ceiling_dose = "";
						max_daily_ceiling_dose = "";
						dose_unit_desc="";
						ceil_dose_unit_desc = ""; 
					
					if ( recCount % 2 == 0 )
						classvalue = "QRYODD" ;
					else
						classvalue = "QRYEVEN" ;
					if(disp_level.equals("P") && ((String)orderLineDtls.get(i)).startsWith("PH")) {
						order_id				=	(String)orderLineDtls.get(i);
						OrderIDS.put(order_id,order_id) ;
						i=i+2;
						++i;
					}
					allergy					=	(String)orderLineDtls.get(i);
					exceed_dose				=	(String)orderLineDtls.get(++i);
					i=i+1;
					drug_code				=	(String)orderLineDtls.get(++i);
					drug_name				=	(String)orderLineDtls.get(++i);
					dosage_dtls				=	(String)orderLineDtls.get(++i);
					start_date				=	(String)orderLineDtls.get(++i); 
					end_date				=	(String)orderLineDtls.get(++i);
					pres_qty				=	(String)orderLineDtls.get(++i);
					qty_uom					=	(String)orderLineDtls.get(++i);
					qty_uom_disp			=	(String)orderLineDtls.get(++i);
					order_line_no			=	(String)orderLineDtls.get(++i);
					generic_id				=	(String)orderLineDtls.get(++i);
					if(generic_id.equals("MEDICALITEM"))
						bDrugOrder				= false;
					generic_name			=	(String)orderLineDtls.get(++i);
					dosage_details			=	(String)orderLineDtls.get(++i);
					bms_qty					=	(String)orderLineDtls.get(++i);	
					act_bms_qty             =	bms_qty;
					source_code				=   (String)orderLineDtls.get(++i);
					source_type				=   (String)orderLineDtls.get(++i);
					ordering_facility_id	=   (String)orderLineDtls.get(++i);
					ord_date_time			=   (String)orderLineDtls.get(++i);
					performing_pract_id		=   (String)orderLineDtls.get(++i);
					duplicate_yn			=   (String)orderLineDtls.get(++i);
					min_dose_dtls			=   (String)orderLineDtls.get(++i);
					alloc_qty_from_tmp		=   (String)orderLineDtls.get(++i);
					if(alloc_qty_from_tmp == null || alloc_qty_from_tmp.equals("")) 
						alloc_qty_from_tmp = "0";
					strength_value			=	(String)orderLineDtls.get(++i);
					if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) <1 &&Float.parseFloat(strength_value)!=0)
						strength_value = Float.parseFloat(strength_value) +"" ;
					strength_uom			=	(String)orderLineDtls.get(++i);
					strength_uom_disp		=	(String)orderLineDtls.get(++i);
					currentdateplusFillPeriod		=  	com.ehis.util.DateUtils.plusDate(sysdate,"DMY",locale,Integer.parseInt(bean_1.getFillPeriod()),"d").toString();
					if(end_date.length() >=10)
						end_date		=	end_date.substring(0,10);
					endDateIsbeforeFilldate			=  	com.ehis.util.DateUtils.isBefore(end_date,currentdateplusFillPeriod,"DMY",locale);
					if(!endDateIsbeforeFilldate){
						end_date=currentdateplusFillPeriod;
					}

					trade_code				=   (String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);
					
					alt_drug				=	bean.checkMultiStrength(drug_code);	
					batch_data= (HashMap) bean.getbatchString(patient_id,order_id,order_line_no,drug_code);
					int medi_count=bean.altDrugsAvelibleYN(drug_code);
					if(medi_count>0){
						alt_drug="Y";
					}
					if(alt_drug.equals("N") || alt_drug.equals("")){
						for(int j=0;j<batch_data.size();j++){
							temp=(ArrayList)batch_data.get(order_id+order_line_no+drug_code);
							for(k=0;k<temp.size();k=k+4){
								trade_code=(String)temp.get(k);
							}
						}
					}
					if(generic_id.equals("MEDICALITEM"))
					   drug_trade_bean.setDrugyesno("");
					else
						drug_trade_bean.setDrugyesno("Y");
					
					image_path				=   drug_trade_bean.getImagePath(drug_code,trade_code);
					pack_dtls			    =	bean.getPackSize(drug_code);
					main_drug_pack_size = 0;
					if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
						if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
							main_drug_pack_size		=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));						
						 }		
					 }
					bmscount                =   bean.CheckBMSYN(order_id, order_line_no);
					pres_details	        =	bean.getPresDetails(order_id);
					
					sRepeatFreqCode			=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[0];
					sFreqCode				=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[1];
					stDrugCodes.add(drug_code); 
					if(order_type.equals("IVI") ||  order_type.equals("CA"))
						strChangedFludRmks = bean.getChngdFluidRemarks(order_id,order_line_no);
					else
						strChangedFludRmks ="";

					if(strChangedFludRmks != "" && strChangedFludRmks != null){
						classvalue = "FLUDCOLOR";
					}
					if(printValue!=null && printValue.size()>0){
						print_value = (String)printValue.get(order_id+order_line_no);
					}
					ws_tot_qty = 0;
					ht_ws_allocated_batches = bean_1.getHTWSAllocateBatches();

					if(ht_ws_allocated_batches.get(order_line_no) != null){
						ArrayList arr_list  = (ArrayList)ht_ws_allocated_batches.get(order_line_no);
						ht_ws_alloc_qty     = (Hashtable)bean_1.getHTWSAllocatedQty();
						ht_ws_alloc_qty		= (Hashtable)ht_ws_alloc_qty.get(order_line_no);
						ws_item_code = "";
						ws_drug_code = "";
						if(arr_list.size()>1){
							ws_item_code = (String)arr_list.get(0);
							ws_drug_code = (String)arr_list.get(2);
						}
						
						if(ht_ws_alloc_qty != null && ht_ws_alloc_qty.get(ws_item_code+ws_drug_code) != null){
							ArrayList arr_list_alloc_qty = (ArrayList)ht_ws_alloc_qty.get(ws_item_code+ws_drug_code);
							for (int jj=0;jj<arr_list_alloc_qty.size();jj++){
								ws_tot_qty += Double.parseDouble((String)arr_list_alloc_qty.get(jj));
							}	
						}
						ht_drug_details	    = bean_1.getAllDrugDetails();
						arr_list_drug_details = (ArrayList)ht_drug_details.get(order_line_no);

						qty_avail_from_spillage = "0";
						if(arr_list_drug_details != null)
							qty_avail_from_spillage= (String)arr_list_drug_details.get(3);
						ws_tot_qty += Double.parseDouble(qty_avail_from_spillage);
					}

						bean.addDrugs(patient_id,order_id,drug_code,alt_drug,order_line_no);
						if (scope.equals("A") && (!fill_list.equals("WF") && !patient_class.equals("IP"))){ 
							bean_1.setPrescQty(drug_code);
							bean_1.setQtyUom(qty_uom);
						}

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
						ext_prod_id			=   (String)orderLineDtls.get(++i);
						in_formulary_yn			=	((String)orderLineDtls.get(++i)).trim();

						if(in_formulary_yn.equals("N")){
							classvalue			=	"FORMULARY";
							disable_alloc_text_box ="disabled";
						}
						else{
							disable_alloc_text_box ="";
						}
						
						iv_prep_yn = (String)orderLineDtls.get(++i);
						
						if(iv_prep_yn!=null && iv_prep_yn.trim().equals("N")) {
							if(order_line_no.equals("1")){
								classvalue="IVFLUID";
							}
							else{
								classvalue="IVINGREDIENT";
							}
						}
						drug_class	=	(((String)orderLineDtls.get(++i)).trim());
						i=i+2;
						expired_yn  = (String)orderLineDtls.get(++i);
						if(expired_yn.equals("Y"))
						{
							if(expired_order) 
								classvalue="EXPIRED_ORDER";
							else
								classvalue="EXPIRED_MEDICATION";
						}
						i=i+1; 
						order_line_status = (((String)orderLineDtls.get(++i)).trim()); 
						main_strength_per_value_pres_uom =(String)orderLineDtls.get(++i);
						i++;
						sOrderType = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();
						i++;
						sAbsOrder  = orderLineDtls.get(i) == null ?"":orderLineDtls.get(i).toString();

						if(sOrderType.equals("P") || sAbsOrder.equals("N"))
							bPRNOrAbsOrder = true;
						else
							bPRNOrAbsOrder = false;

						if(drug_class.equals("C") || drug_class.equals("N")) {
							narc_style	="color:brown";
							
							title		= "title='"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NarcoticControlledDrugs.label","ph_labels")+"'";
						}
						bean.setStockItems(drug_code,stock_opt);

						if(!strength_value.equals("0"))
							strength	=	strength_value+" "+strength_uom;
						token	=	new StringTokenizer(dosage_details,":");
						if(token.hasMoreTokens()) 
							exceed_status	=	token.nextToken();
					
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
						if(!dosage_unit.equals("")){ 
							   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_unit); 
		 					ceil_dose_unit_desc = dose_unit_desc;
								if(dose_unit_desc==null || dose_unit_desc=="" ) {
									if(dosage_unit.indexOf("/")!=-1){
		 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_unit.split("/")[0]));
		 					ceil_dose_unit_desc = dose_unit_desc;
								  if(dosage_unit.length()>=2){
		 							 dose_unit_desc =dose_unit_desc+"/"+(dosage_unit.split("/")[1]);
		 						  }
								}
		 						} 
	 						}

						/* token	=	new StringTokenizer(min_dose_dtls,":");
						if(token.hasMoreTokens()) {
							min_unit_dose	=	token.nextToken();
							min_daily_dose	=	token.nextToken();
						} *///removed for ML-MMOH-SCF-1997
						StringTokenizer min_dose	=	new StringTokenizer(min_dose_dtls,":");//ADDED for ML-MMOH-SCF-1997
						if(min_dose.hasMoreTokens()) {
							min_unit_dose	=	min_dose.nextToken();
						} // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
						if(min_dose.hasMoreTokens()) { // Added for the issue which is found while testing MMS-KH-CRF-0028 [IN070605]
							min_daily_dose	=	min_dose.nextToken();
						}
						
						if(bean.checkHold(order_id,order_line_no)) {
								hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
								check_value="Y";
								check_status="checked";
								fromdb="Y";
						} 
						else {
							HashMap hm= bean.loadHoldRemarks(order_id,order_line_no);
							if (!hm.isEmpty()){
								hold_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OnHold.label","ph_labels");
								check_value="Y";
								check_status="checked";
								fromdb="Y";
							}
							else{
								hold_text		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hold.label","ph_labels");
								check_status	="";
							}
						}
						drug_remarks	    = "";
						prn_remarks		    = "";
						pharma_remarks	    = "";		
						pres_remarks        = "";
						slidingscaleremarks ="";
						remarks_style       = "";
						dialog_height       = 0;
						pres_remarks					=   bean.getPrescriptionInstructions(order_id);
						drug_remarks					=   bean.getDrugInstructions(order_id,order_line_no);
						//IN071533 Start					
						if(iv_prep_yn!=null && !iv_prep_yn.equals("") && iv_prep_yn.equals("5")){
							drug_remarks = bean.getNonMFRfluidRemarks(order_id,order_line_no); 
						}
						//IN071533 end						
						prn_remarks						=   (String)orderLineDtls.get(++i);
						pharma_remarks					=   bean.getPharmacistInstructions(order_id,order_line_no,"Y");		   
						slidingscaleremarks				=   (String)orderLineDtls.get(++i);
						verificationremarks				=   (String)orderLineDtls.get(++i);             
						drug_db_product_id				=	(String)orderLineDtls.get(++i);
						allergy_override_reason			=	(String)orderLineDtls.get(++i);
						dosage_limit_override_reason	=	(String)orderLineDtls.get(++i);
						duplicate_drug_override_reason	=	(String)orderLineDtls.get(++i);
						interaction_override_reason		=	(String)orderLineDtls.get(++i);		  
						contraind_override_reason		=	(String)orderLineDtls.get(++i);
						pat_couns_reqd_yn		        =	(String)orderLineDtls.get(++i);
						pt_couns_reqd_yn		        =	(String)orderLineDtls.get(++i);
						billable_item_yn		        =	(String)orderLineDtls.get(++i);
						dischargeIND					=	(String)orderLineDtls.get(++i);
						strBMS_Include_yn				=	(String)orderLineDtls.get(++i);  
						home_med_yn 				= 	(String)orderLineDtls.get(++i);
						if(home_med_yn!=null && home_med_yn.equalsIgnoreCase("Y"))
							home_med_style = "HOME_MED";
						else
							home_med_style = "white";
						drug_desc 				= 	(String)orderLineDtls.get(++i);
						disc_cancelled_orders		= 	(String)orderLineDtls.get(++i);
						appl_for_compounding_rx_yn 	= 	(String)orderLineDtls.get(++i);
						if(!disc_cancelled_orders.equals("")) 
							disc_cancelled_orders_display="display:inline";
						else
							disc_cancelled_orders_display="display:none"; 
						if("Y".equals(appl_for_compounding_rx_yn)){ 
							disp_mnf_flag = "display:inline;color:blue";
						}						
						food_interaction_override_reason =   "";
						lab_interaction_override_reason =   "";  
						disease_inter_override_reason="";//MMS-DM-CRF-0229
						if(iv_prep_yn!=null && iv_prep_yn.equals("")){
							 lab_food_interaction = bean.getDrugLabFoodInteraction(order_id,order_line_no);
							 food_interaction_override_reason = (String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("FOOD_INTERACT_OVERRIDE_REASON");
							 lab_interaction_override_reason = (String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("LAB_INTERACT_OVERRIDE_REASON");//modified for MMS-MD-SCF-0141
							  disease_inter_override_reason = (String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON")==null?"":(String)lab_food_interaction.get("DISEASE_INTER_OVERRIDE_REASON");//MMS-DM-CRF-0229
						}
						if(lab_interaction_override_reason==null)
							lab_interaction_override_reason = "";

						if(food_interaction_override_reason==null)
							food_interaction_override_reason = "";
						if(disease_inter_override_reason==null) //MMS-DM-CRF-0229
							disease_inter_override_reason = "";
					
						taper_disable="";
						
						System.err.println("drug_expiry_alert=="+drug_expiry_alert+"drug_expiry_days=="+drug_expiry_days);
						System.err.println("insuranceStatus@@==="+insuranceStatus+"order_id=="+order_id+"order_line_no=="+order_line_no);
						if(insuranceStatus.containsKey(order_id+order_line_no))
						insurance_status  = (String)insuranceStatus.get(order_id+order_line_no);//Added for TH-KW-CRF-0012
						System.err.println("drug_expiry_alert@@@=="+drug_expiry_alert+"insurance_status=="+insurance_status);
						taperValues=bean.chkfortapering(order_id,drug_code, order_line_no, patient_id);		
						count =Integer.parseInt(taperValues.get("COUNT").toString()); 
						tot_tap=Float.parseFloat(taperValues.get("TOT_QTY").toString());									
						if(!alloc_qty_from_tmp.equals("") && !alloc_qty_from_tmp.equals("0")) {
							if(bean.getFirstTime(order_id).trim().equals("true")) {
								first_time_yn ="Y";
								HashMap drug_detail		=	bean.getDB_DrugDetail(order_id,order_line_no,end_date);                         
								ArrayList multi_detail	=	(ArrayList)drug_detail.get("multi_detail");
								ArrayList main_detail	=	(ArrayList)drug_detail.get("main_detail");
								HashMap   alt_detail	=	(HashMap)drug_detail.get("alt_detail");
								String sTmpValue		=	"";
								
								if(fill_list.equals("AF") && multi_detail.size()>0){
									hmOrderDispDrugDetails.put(order_id+"~"+order_line_no,multi_detail.get(0));
									 if( main_detail.size()>0){
										check_yn="Y";
									 }
									 else{
										 check_yn="N";
									 }
								 }
								if(multi_detail.size()==0) {
									bean.setDrugDetail(patient_id,order_id,order_line_no,main_detail);
									bean.setDrugQuantity(patient_id,order_id,order_line_no,Double.parseDouble(alloc_qty_from_tmp));
								} 
								else if(multi_detail.size()!=0) {
									bean.setMultiDrugs(patient_id,order_id,order_line_no,multi_detail);	
									for(int no=0; no<multi_detail.size(); no+=5) {
										alt_drug_code			=	(String)multi_detail.get(no);
										ArrayList alt_drug_detail	=	(ArrayList)alt_detail.get(alt_drug_code);
										bean.setAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_detail,alt_drug_code);
									}							
								}
							}
							else{
								first_time_yn ="N";
							}
						}						
						disp_delivery_chk_box_val = "Y";
						if(request.getParameter("resetQty")== null){
							qty				=	bean.getDrugQuantity(patient_id,order_id,order_line_no);
						}
						else{
							qty				= "";	
						}
						Order_id_amend_yn =(HashMap)bean_1.getOrder_id_amend_yn();
						multi_drugs		=	bean.getMultiDrugs(patient_id,order_id,order_line_no);
						alt_drug_remarks_disp="";
						if( multi_drugs.size() > 0){
							if(alt_drug_remarks_ind.equals("M") || alt_drug_remarks_ind.equals("O")){
								alt_drug_remarks_disp = "&nbsp;<a href=\"javascript:openAltDrugRemarks('"+order_id+"','"+ order_line_no+"','"+ alt_drug_remarks_ind+"','LINK');\" id='altDrugRmkLbl' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.remarks.label", "common_labels")+"</a>";
								if(alt_drug_remarks_ind.equals("M"))
									alt_drug_remarks_disp=alt_drug_remarks_disp+" <img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>";
							}
						}
						if(Order_id_amend_yn.containsKey(order_id)){
							Order_id_amend_yn.remove(order_id);
							qty			=  "";
						}

						if(!qty.equals("") && !qty.equals("0") && multi_drugs.size() < 1)
							tot_qty				+=	Double.parseDouble(qty);
						System.out.println("##@$@#$968 tot qty"+tot_qty);
						
						if(tpn_mf_label){bean.setTPNQty(String.valueOf(tot_qty));
						bean_1.setPrescQty(drug_code);
						bean_1.setQtyUom(qty_uom);}
						
						 abuse_drug_override_reason=(String)orderLineDtls.get(++i);
							abuse_exists=(String)orderLineDtls.get(++i);
							drugIndication=(String)orderLineDtls.get(++i);//ADDED FOR JD-CRF-0220
							drug_expiry_alert = (String)orderLineDtls.get(++i);//Added for TH-KW-CRF-0008
						drug_expiry_days  = (String)orderLineDtls.get(++i);//Added for TH-KW-CRF-0008
	category_code=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
							alternate_yn=(String)orderLineDtls.get(++i);//added for mms-dm-crf-0209.1
									System.out.println("category_code"+category_code);
									System.out.println("alternate_yn"+alternate_yn);
						alt_drug_qty			=	"";
						for(int n=0; n<multi_drugs.size(); n+=5)	{ 
							alt_drug_code	=	(String)multi_drugs.get(n);
							alt_drug_qty	=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
							if(!alt_drug_qty.equals(""))
								break;
						}
						if(!scope.equals("H")&&!bean.checkHold(order_id,order_line_no)){
							if( (!qty.equals("") && !qty.equals("0")) || (!alt_drug_qty.equals("") && !alt_drug_qty.equals("0")) ||(ws_tot_qty>0)){
								hold_status	="disabled";
							}
						}
						show_remarks = "N";
						if(!allergy_override_reason.equals("")||!dosage_limit_override_reason.equals("")||!duplicate_drug_override_reason.equals("")||!interaction_override_reason.equals("")||!contraind_override_reason.equals("") || !food_interaction_override_reason.equals("") ||  !lab_interaction_override_reason.equals("") || !disease_inter_override_reason.equals("")){ //modified for MMS-KH-CRF-0029
							show_remarks="Y";
						}
					if(!slidingscaleremarks.trim().equals("")){
							drugs_remarks.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SlidingScaleRemarks.label","ph_labels")+" : "+slidingscaleremarks.trim()+"\n");
							bPRNOrAbsOrder=true; 
						}
						
					drugs_remarks=bean_1.getremarks(pres_remarks,slidingscaleremarks,allergy_override_reason,duplicate_drug_override_reason,drug_db_product_id,dosage_limit_override_reason,interaction_override_reason,lab_interaction_override_reason,food_interaction_override_reason,contraind_override_reason,drug_remarks,prn_remarks,pharma_remarks,verificationremarks,abuse_drug_override_reason,drugIndication);
						System.out.println("1144 after bean call drugs_remarks"+drugs_remarks);	
						if(drug_remarks.trim().equals("") && pharma_remarks.trim().equals("") && pres_remarks.trim().equals("") && prn_remarks.trim().equals("")&& slidingscaleremarks.trim().equals("")&& verificationremarks.equals("") &&show_remarks.equals("N") && abuse_drug_override_reason.trim().equals("") && drugIndication.equals("")){ 
								remarks_style	=	"style='visibility:hidden'";
							drugs_remarks.setLength(0);
						} 
						else {
							strDrugsRemarks = drugs_remarks.toString();
							strDrugsRemarks=strDrugsRemarks.replaceAll(" ","%20");
							strDrugsRemarks = java.net.URLEncoder.encode(strDrugsRemarks,"UTF-8");
							strDrugsRemarks=strDrugsRemarks.replaceAll("%2520","%20");
							dialog_height=bean_1.remarksHight(prn_remarks,drug_remarks,pres_remarks,pharma_remarks,slidingscaleremarks,verificationremarks,show_remarks);
								System.out.println("1155 after bean call dialog_height"+dialog_height);		
						}

				 /*-------------------------ends------------------------*/	
						tmp_bms_qty				=	bms_qty;
						main_pack_size		    =   0;

						if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
							if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
								main_pack_size	=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));	
								tmp_bms_qty_1		=   Float.parseFloat(tmp_bms_qty)*main_pack_size+"";
							}		
						}
						else{
							tmp_bms_qty_1		=   tmp_bms_qty;
						}
						adr_count     =   bean.getADRCount(patient_id,drug_code);
						store_code	=	bean_1.getStoreCode();

						Float fTotalDuration = Float.parseFloat(bean_1.getDurationValue(order_id+order_line_no));

						/*==============code for getting defult batches====================================*/
						if(ord_type.equals("NOR") || bEquivalentNormalOrder){
							items			=  (ArrayList)bean.loadItems(drug_code);
							if(items.size()>0){
								item_code     =   (String)items.get(0);
							}
							store_code	=	bean_1.getStoreCode();
							 opdispperiod  = Float.parseFloat(bean_1.getFillPeriod());
							String sOrigDispUnit	= bean_1.getStrChangedDispenseUnit() != null?bean_1.getStrChangedDispenseUnit():"D";
							String sOrigDispPeriod	= bean_1.getStrChangedDispensePeriod() != null?bean_1.getStrChangedDispensePeriod():"1";
							opdispperiod = bean_1.getOPDispperiod(sRepeatFreqCode,sOrigDispUnit,sOrigDispPeriod,opdispperiod); //modified for 12c
							fTotalDuration = bean_1.getTotalDuration(sFreqCode,fTotalDuration);//modified for 12c

						}

						 if(bean.checkHold(order_id,order_line_no)|| scope.equals("H") || (scope.equals("A") && !bean.loadHoldRemarks(order_id,order_line_no).isEmpty())){  // || (scope.equals("A") && !bean.loadHoldRemarks(order_id,order_line_no).isEmpty() Added for ML-MMOH-CRF-0434 [IN057356]
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
						orig_dflt_issue_uom		= (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
						st_allow_decimals_yn	= CommonBean.checkForNull((String)IssueUOMAndBaseUOM.get("ALLOW_DECIMALS_YN")); 
						if(bKeepQty && qty.equals("")){						
							ArrayList alValues = bean.setIssueUOMValuesLevelTwo(order_id,order_line_no,drug_code);
							HashMap hmUOMValues = null;
							for(int iCount =0 ;iCount<alValues.size();iCount++){
								hmUOMValues = (HashMap) alValues.get(iCount);
								qty = (String)hmUOMValues.get("DISP_QTY");

								if(alValues.size()==1){ 
									bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",(String)hmUOMValues.get("DISP_QTY"));
									bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",(String)hmUOMValues.get("UOM_CODE"));
									bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",(String)hmUOMValues.get("UOM_DESC"));
									bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",(String)hmUOMValues.get("CONVERTED_EQUAL") );
								}
								if(hmUOMValues.get("UOM_CODE").toString().equals(orig_dflt_issue_uom)){
									bean.setIssueUomQty(order_id+order_line_no+item_code+"_base_to_def_uom_equl",(String)hmUOMValues.get("DEFAULT_EQUAL"));
								}
								else{
									bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",(String)hmUOMValues.get("DISP_QTY"));
									bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",(String)hmUOMValues.get("UOM_CODE"));
									bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",(String)hmUOMValues.get("UOM_DESC"));
									bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",(String)hmUOMValues.get("CONVERTED_EQUAL") );
									bean.setIssueUomQty(order_id+order_line_no+item_code+"_base_to_disp_uom_equl", (String)hmUOMValues.get("DEFAULT_EQUAL"));
									dflt_issue_uom = (String)hmUOMValues.get("UOM_CODE");
								}
							}
							if(!scope.equals("H")&&!bean.checkHold(order_id,order_line_no)){
								hold_status	="disabled";
							}
							if(!qty.equals(""))
								bms_qty = (Double.parseDouble(bms_qty) - Double.parseDouble(qty))+"";
						}
						else
							dflt_issue_uom	= "";

						if(issue_uom_qty_hm.size()>0){
							if(issue_uom_qty_hm.containsKey(order_id+order_line_no+drug_code+"_uom")){
								dflt_issue_uom = (String)issue_uom_qty_hm.get(order_id+order_line_no+drug_code+"_uom");
							}
						}

						if(dflt_issue_uom.equals("") || request.getParameter("resetQty")!= null)
							dflt_issue_uom			 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");

						base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
						base_to_disp_uom_equl    =	bean.getEqulValue ( item_code, base_uom, qty_uom);
						
						base_to_def_uom_equl	 =  bean.getEqulValue ( item_code, base_uom, orig_dflt_issue_uom);
						 /*=======================ends here=========================================================================================*/

						if(request.getParameter("barcode_id")!=null){ 
						    barcode_id = request.getParameter("barcode_id");
						}
						last_scanned = bean_1.getScannedBarcode_id(order_id,order_line_no); 

						if(qty.equals("") && alt_drug_qty.equals("")&& ord_type.equals("NOR") &&alloc_readonly.equals("")&& stock_opt.get(0).equals("Y") && (!item_code.equals("")) && barcode_id.equals("")) {//  && barcode_id.equals("") Added for KDAH-CRF-0231 [IN-034551]
							if(disable_all.equals("disabled")&&qty.equals("")){
								zero_alloc_qty_item_yn ="Y";
							}
							else{
								zero_alloc_qty_item_yn ="N";

							if(base_to_disp_uom_equl!=0 && base_to_def_uom_equl !=0){

								tmp_unit_qty    =	0;
								if(bPRNOrAbsOrder){
									tmp_unit_qty = Double.parseDouble(act_bms_qty);
								}
								else{
									fill_period	 = bean_1.getFillPeriod();
									fill_unit		 = bean_1.getFillUnit();
									item_cost       = "";
									issue_qty       = "";
									float per_day	 =	Float.parseFloat(pres_qty)/ fTotalDuration;									
									if(disp_catg.equals("I")){
										if(!fill_list.equals("AF")){
											if(fill_unit.equals("H") && !fill_period.equals("")) {				
												tmp_unit_qty	=	new Float(Math.ceil((opdispperiod / 24 )* per_day)).doubleValue();		
											}
											else if(fill_unit.equals("D")) {
												tmp_unit_qty	=	new Float(Math.ceil((opdispperiod * per_day))).doubleValue();
											}
									   }
									   else{
										  tmp_unit_qty = Double.parseDouble(alloc_qty_from_tmp);
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
								
								 if(tmp_unit_qty > (Double.parseDouble(act_bms_qty)) ){
									 tmp_unit_qty =Double.parseDouble(act_bms_qty);
								 }
							}
								  if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ 
									  tmp_unit_qty=0;  
								  } 
							issue_qty_val			 =  0;	
							if(base_to_disp_uom_equl!=base_to_def_uom_equl){
								conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
								issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
								issue_qty_val  =  new Float(Math.ceil(((Math.ceil(Double.parseDouble(issue_qty_val+"")/conv_factor))*(conv_factor))/base_to_def_uom_equl)).doubleValue(); 
								
								issue_qty_val  =  new Float(Math.ceil(issue_qty_val*base_to_def_uom_equl)).doubleValue(); 
								bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",issue_qty_val+""); 
							}
							else{
								if(qty_uom!=base_uom){  
									conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
									issue_qty_val  =  new Float(Math.ceil(tmp_unit_qty*base_to_disp_uom_equl)).doubleValue(); 
								}
								else{
									issue_qty_val  = tmp_unit_qty;	
								}
								bean.setIssueUomQty(order_id+order_line_no+item_code+"_qty",tmp_unit_qty+""); 
							}                   
							
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_uom",dflt_issue_uom);
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_desc",bean.getUOMDesc ( dflt_issue_uom));
							bean.setIssueUomQty(order_id+order_line_no+item_code+"_equl",base_to_def_uom_equl+""); //code added to handle if dispense uom and default uom in item store is different -  End
							
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
							params.put("MIN_EXP_DATE",end_date);
							params.put("CUT_OFF_DATE",end_date);
							params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
							params.put("ALREADY_USED_QTY","");
							params.put("BARCODE_ID",barcode_id);
							if(bean_1.get2DBarcodeApplicable().equals("Y") && !barcode_id.equals("")){//Added if condition for MMS-DM-CRF-0174.5
								     stock = (HashMap)bean_2.get2DBarcodeDetails(params);
				            }else{
							        stock				= (HashMap)bean_2.getBatches(params);
							}
							if(stock.size()>0 ){
								check_yn   ="Y";
								stock_det           = (ArrayList)stock.get("BATCH_DATA");
								
								if(trade_code.equals("") && stock.containsKey("EXCEPTION")){ 
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
									bean_st.setCuttOffDate(end_date);
									bean_st.loadResultPage("","","");
									bean_st.setModuleId("PH") ;
									listRecord					=		bean_st.getDataList();
									if(listRecord!=null && listRecord.size()>0){
										trade_code=((HashMap)listRecord.get(0)).get("TRADE_ID").toString();
										params.remove("ITEM_CODE");
										params.put("ITEM_CODE",item_code+"="+trade_code);
										if(bean_1.get2DBarcodeApplicable().equals("Y") && !barcode_id.equals("")){//Added if condition for MMS-DM-CRF-0174.5
								           stock = (HashMap)bean_2.get2DBarcodeDetails(params);
				                        }else{
										   stock				= (HashMap)bean_2.getBatches(params);
										}
										stock_det           = listRecord;
									}
								}
								
								alloc_drug_detail	= 	new ArrayList();
								alloc_batch_detail  =   new ArrayList();
								tmp_unit_qty =issue_qty_val; 
								
									for (int j=0;j<stock_det.size();j++){
										batch_det =(HashMap)stock_det.get(j);
										avail_qty			= (String)batch_det.get("AVAIL_QTY");
										if(Double.parseDouble(avail_qty) < 1.0)
										   continue;

											 item_cost	=	bean.getItemCost(item_code,store_code,tmp_unit_qty+"",end_date);

											if(tmp_unit_qty>Double.parseDouble(avail_qty)){
												tmp_unit_qty =tmp_unit_qty-Double.parseDouble(avail_qty);
												issue_qty =avail_qty;
											}
											else{
												issue_qty =tmp_unit_qty+"";    
											}
											tot_issued_qty = tot_issued_qty+Double.parseDouble(issue_qty);
											alloc_batch_detail = bean_1.getAllocBatchDetails(batch_det,item_code,store_code,tmp_unit_qty+"",end_date,qty_uom,base_uom,issue_qty,base_to_disp_uom_equl,base_to_def_uom_equl,item_cost); //modified for 12c
											alloc_drug_detail.addAll(alloc_batch_detail);
										}
									
									if(stock_det.size()>0){										
										if(bean_1.getBarcode_Scan_YN().equals("Y") && barcode_id.equals("") && bean_1.getOrderType().equals("NOR")){ 
											tot_issued_qty=0;
										} 
										if(!qty_uom.equals(base_uom)){ 
											conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
											tot_issued_qty  =   Math.floor(tot_issued_qty/base_to_disp_uom_equl); 
										}
										else{
											tot_issued_qty			= Math.floor(tot_issued_qty);
										}
										bean.setDrugDetail(patient_id,order_id,order_line_no,alloc_drug_detail);
										bean.setDrugQuantity(patient_id,order_id,order_line_no,tot_issued_qty);
										if(!scope.equals("H")&&!bean.checkHold(order_id,order_line_no) || (!scope.equals("A") && patient_class.equals("IP") &&!bean.checkHold(order_id,order_line_no)) ){  
											hold_status	="disabled";
										}
									}
								}
							}
							else{
								if(!item_uom_definition_flag){
									item_uom_definition_flag=true;
								}
								alloc_readonly ="disabled";
							}
						}
					}		 
					IssueUomQty		= (HashMap)bean.getIssueUomQty();
					issue_qty_dtl   =  new StringBuffer();

					if(IssueUomQty.containsKey(order_id+order_line_no+drug_code+"_qty")&& base_to_disp_uom_equl!=0){
						issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_qty");
						issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_desc");
						issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_uom");
						issue_uom_equl	= (String)IssueUomQty.get(order_id+order_line_no+drug_code+"_equl");

					   if(bean_1.getIssueByUOM().equals("I") && !issue_qty_value.equals("0")){
						   issue_qty_dtl   =  issue_qty_dtl.append("( ").append(issue_qty_value).append("  ").append(issue_uom_desc).append(" )");
					   }
					} 

					if(Min_Rol_yn){
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
							if (Double.parseDouble(avail_qty)  <  Double.parseDouble(frm_store_min_stk_level)){
								min_stk = true;
								if(getReq_allowed_yn)
									disp_req_flag =  "display:inline;color:blue";
								else
								disp_req_flag = "display:none";
							}
						}
						if(!frm_store_reorder_level.equals("0")){
							if (Double.parseDouble(avail_qty) <  Double.parseDouble(frm_store_reorder_level)){
								rol_stk = true; 
								if(getReq_allowed_yn)
									disp_req_flag = "'display:inline;color:blue";
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
								rol_flag_bkg_clr = "background-color:none;";
							}
							else{
								rol_flag   ="display:none";
								rol_flag_bkg_clr = "background-color:none";
							}
						}
						
						if((min_stk&&getReq_allowed_yn)||(rol_stk&&getReq_allowed_yn))
							disp_req_flag = "display:inline;color:blue";
						else
							disp_req_flag  = "display:none;color:blue";
					}
					if(!exceed_dose.equals("")){ 
							String repeat_value = 	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[2];
							 celling_dose = bean_1.getMinMaxCeilingDose(drug_code,patient_id,repeat_value,order_id,order_line_no);
							 if(celling_dose!=null && celling_dose.size()>0){
								min_unit_ceiling_dose = (String)celling_dose.get(0);
								max_unit_ceiling_dose = (String)celling_dose.get(1);
								min_daily_ceiling_dose = (String)celling_dose.get(2);
								max_daily_ceiling_dose = (String)celling_dose.get(3);
							 }
							 
						} 
					%>

					<tr <%=taper_disable%>>
<%					if(fill_list.equals("WF")){	//Added for IN064793
%>					<td> 
						<input type="checkbox" name="print_<%=recCount%>" id="print_<%=recCount%>" onclick="setValue(this)" value="Y" checked> 
					</td>
<%					}
%>						
					
						<td class="white">
							<table border="1" width="100%" cellpadding="0" cellspacing="0" align="center" id ="tab1">
						<tr>   
<%
						if(allergy.equals("")) { 
%>
							<td class="white" width="20%" >&nbsp;</td> 
<%
						}
						else{
%>
							<td class='ALLERGY' width="20%" style="cursor:pointer"  onClick="showAllergyDetails('<%=generic_id%>','<%=patient_id%>','<%=encounter_id%>','<%=java.net.URLEncoder.encode(generic_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','')">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%	
						}
						if(exceed_dose.equals("")) {
%>
							<td class="white" width="20%">&nbsp;</td> 
<% 
						}
						else	{	//order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605
%>
							<td class='DOSELIMIT' width="20%" style="cursor:pointer" onClick="showMonoGraph('<%=java.net.URLEncoder.encode(drug_name)%>','<%=java.net.URLEncoder.encode(monograph)%>','<%=daily_dose%>','<%=unit_dose%>','<%=min_unit_dose%>','<%=min_daily_dose%>','<%=dosage_unit%>','<%=std_dose%>','<%=dose_unit_desc%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','','<%=max_daily_ceiling_dose%>','<%=min_daily_ceiling_dose%>','<%=max_unit_ceiling_dose%>','<%=min_unit_ceiling_dose%>','<%=ceil_dose_unit_desc%>')">&nbsp;</td><!-- dose_unit_desc added for ML-MMOH-SCF-0863, 33% changed to 20% for MMS-KH-CRF-0013 and ceiling dose added for ML-MMOH-CRF-1408  and changed dose_unit_desc to ceil_dose_unit_desc for 1408,added drug_name encoding for IN073523 -->
<% 
						}
						if(duplicate_yn.equals("Y") || !duplicate_drug_override_reason.equals("")) {
%>
							<td class='CURRENTRX' width="20%" style="cursor:pointer"  onClick="callActiveOrders('<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','')">&nbsp;</td> <!-- 33% changed to 20% for MMS-KH-CRF-0013 -->
<%	
						}
						else{
%>
							<td class="white" width="20%">&nbsp;</td> 
<%	
						}
						/* added for aakh-crf-0140 start */
						   		if(drug_abuse_appl && abuse_drug_override_reason != null && abuse_drug_override_reason != "" ) { System.out.print("abuse_exists filling----->"+abuse_exists);
							
							%>
							<td class='ABUSE_REMARKS'  width="20%" style="cursor:pointer" onClick="showAbuseDetails('','<%=patient_id%>','<%=encounter_id%>','<%=generic_id%>','<%=drug_code%>','clicking')">&nbsp;</td>
							<%
						}else{
%>
							<td class="white" width="20%">&nbsp;</td>
							
<%	
						}/* added for aakh-crf-0140 start */
	
					if(iv_prep_yn.equals("")){ 
						pres_bean.setEncounterId(encounter_id); 
						if(!drug_db_interface_yn.equals("Y") && pres_bean.getDrugInteractionDtls(drug_code, bean_1.getForm_code(order_id+order_line_no+drug_code), generic_id, start_date, end_date, patient_id).size()>2) {											
				    	    
							form_code = bean_1.getForm_code(order_id+order_line_no+drug_code);
							form_desc = bean_1.getForm_descs(order_id+order_line_no+drug_code);
%>
							<td class='DINTERACN' width="20%" style="cursor:pointer" onClick="showDispInractionDtl('<%=patient_id%>','<%=encounter_id%>','<%=drug_code%>','<%=form_code%>','<%=generic_id%>','<%=start_date%>','<%=end_date%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>','<%=java.net.URLEncoder.encode(form_desc,"UTF-8")%>','<%=order_id%>','<%=order_line_no%>','<%=(recCount)%>','<%=patient_class%>','')">&nbsp;</td><!-- dose_unit_desc added for ML-MMOH-SCF-0863 --> <!-- 33% changed to 25% for MMS-KH-CRF-0013 //order_id,order_line_no,(recCount),patient_class,review_called_from FOR IN070605 -->
							
<% 
			            }
				       else{	
%>
				    	   <td class="white" width="20%">&nbsp;</td> 
<%						    	   
					   }
					}
%>


					</tr>
				</table>
				</td>
				<td    class="<%=classvalue%>"  nowrap <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
<%
				
				
			disp_info	=	bean.getLastDispense(order_id,order_line_no);
			if(disp_info.size() > 0){
				home_med_style_1 = "green";	
			}
			else{
				home_med_style_1 = "blue";
			}
			           
             
            	 if(hold_text.equalsIgnoreCase("On Hold") ){   
            		 home_med_style_1 = "yellow";
            	 }
		
		
            	
				if (hold_status.equals("disabled")){
%>	
					 <label style="color:black;font-size:9px;" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','F','<%=scope%>');" id='hold_remarks_<%=recCount%>'  <%=hold_status%> <%=disable_all%><%=disable_alloc_text_box%> <%=taper_disable%>><%=hold_text%></label>
					<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none' value="<%=check_value%>" <%=check_status%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
<%
				}
				else{
%>
					<label style="cursor:pointer;color:blue;font-size:9px;" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" onClick="callReason(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','F','<%=scope%>');" id='hold_remarks_<%=recCount%>' <%=disable_all%> <%=disable_alloc_text_box%> <%=taper_disable%>><%=hold_text%></label>
					<input type="checkbox" name="hold<%=recCount%>" id="hold<%=recCount%>" style='display:none'  onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" value="<%=check_value%>" <%=check_status%> >
<%
				}
				if(ht_ws_allocated_batches.get(order_line_no) != null){	 // Condition Added and 'recCount' changed to 'order_line_no' for ML-MMOH-CRF-0435 [IN:057357]
%>
				<input type="hidden" name="drug_code<%=order_line_no%>" id="drug_code<%=order_line_no%>"   value="<%=drug_code%>">
<%             }	
%>
				<input type="hidden" name="fromdb_<%=recCount%>" id="fromdb_<%=recCount%>"     value="<%=fromdb%>">
				<input type="hidden" name="hold_status<%=recCount%>" id="hold_status<%=recCount%>" value="<%=hold_status%>">
				</td>
				<td class="<%=home_med_style%>" width="2%" > </td><!-- Modified for ML-BRU-SCF-1784 -->
<%
				if(!fill_list.equals("AF") && patient_class.equals("IP")){//Added for Bru-HIMS-CRF-093-DD1[IN047223]--start
%>					<td class="<%=home_med_style_1%>" width="3%" >  </td>
<%
				}
%>				
<%					
						if(bl_install_yn.equals("Y") && !iv_prep_yn.equals("7") && !iv_prep_yn.equals("8") && item_type_site_app && !encounter_id.equals("")){	
									
							String low_cost_green_style ="visibility:hidden";
							String high_margin_green_style ="visibility:hidden";
							String high_margin_red_style   ="visibility:hidden";
							String low_cost_red_style	="visibility:hidden";
							String low_cost_grey_style ="visibility:hidden";
							String high_margin_grey_style ="visibility:hidden";
							String innovator_style		="visibility:hidden"; 

									item_type= bean.getItemType(drug_code);
									mm_item_low_cost_yn = item_type.split("~")[0];
									mm_item_high_margin_yn = item_type.split("~")[1];
									mm_item_Innovator_yn = item_type.split("~")[2];
								
									if(!bl_grp_app.equals("N")){
							String item_type_style= bean_1.getItemTypeStyle(bl_grp_app,mm_item_low_cost_yn,mm_item_high_margin_yn,mm_item_Innovator_yn);//modified for 12c
									high_margin_green_style = item_type_style.split("~")[0];
									high_margin_red_style = item_type_style.split("~")[1];
									high_margin_grey_style = item_type_style.split("~")[2];
									low_cost_red_style = item_type_style.split("~")[3];
									low_cost_green_style = item_type_style.split("~")[4];
									low_cost_grey_style = item_type_style.split("~")[5];
									innovator_style = item_type_style.split("~")[6];
									}else{
										low_cost_green_style = "visibility:hidden";
										high_margin_green_style = "visibility:hidden";
										low_cost_red_style = "visibility:hidden";
										high_margin_red_style = "visibility:hidden";
							 String item_type_style1= bean_1.getItemTypeStyle1(mm_item_low_cost_yn,mm_item_high_margin_yn,mm_item_Innovator_yn);
									low_cost_grey_style = item_type_style1.split("~")[0];
									high_margin_grey_style = item_type_style1.split("~")[1];
									innovator_style = item_type_style1.split("~")[2];
								}
							
								if(formulary_billing_app){ //GHL-CRF-0549  - start
									high_margin_red_style = "visibility:hidden";
									high_margin_green_style ="visibility:hidden";
									low_cost_green_style ="visibility:hidden";
									low_cost_red_style = "visibility:hidden";
							 String item_type_style2= bean_1.getItemTypeStyle1(mm_item_low_cost_yn,mm_item_high_margin_yn,mm_item_Innovator_yn);
									low_cost_grey_style = item_type_style2.split("~")[0];
									high_margin_grey_style = item_type_style2.split("~")[1];
									innovator_style = item_type_style2.split("~")[2];

									preference_img = "";
									
									if(hmBlgGrp!=null && hmBlgGrp.size()>0){
										if(hmBlgGrp.containsKey(drug_code)){
											preference = (String)hmBlgGrp.get(drug_code)==null?"":(String)hmBlgGrp.get(drug_code);
											preference_img = "";
											if(preference.equals("P1")){
												preference_img ="<img src='../../ePH/images/Preference1.jpg' title='Prefered-1 Item' height='15' width='15'/>";
											}else if(preference.equals("P2")){
												preference_img ="<img src='../../ePH/images/Preference2.jpg'  title='Prefered-2 Item' height='15' width='15'/>";
											}else if(preference.equals("P3")){
												preference_img ="<img src='../../ePH/images/Preference3.jpg' title='Prefered-3 Item'  height='15' width='15'/>";
											}else{
												preference_img ="<img src='../../ePH/images/Preference4.jpg' title='Non Prefered Item' height='15' width='15'/>";
											}
										}else{
											preference_img ="<img src='../../ePH/images/Preference4.jpg' title='Non Prefered Item' height='15' width='15'/>";
										}

									}
								}
									
%>								<td class='<%=classvalue%>'>&nbsp;
								<%if(!low_cost_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostGreen.jpg" style='<%=low_cost_green_style%>' height='15' width='15' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>'><%}
								if(!high_margin_green_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginGreen.jpg" style="<%=high_margin_green_style%>" height='15' width='15' title='<fmt:message key="ePH.Matched.label" bundle="${ph_labels}"/>' >
								<%}if(!low_cost_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCostRed.jpg" style="<%=low_cost_red_style%>" height='15' width='15' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'><%}if(!high_margin_red_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMarginRed.jpg" style="<%=high_margin_red_style%>" height='15' width='15' title='<fmt:message key="ePH.NotMatched.label" bundle="${ph_labels}"/>'><%} if(!low_cost_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/LowCost.jpg" style="<%=low_cost_grey_style%>" height='15' width='15' title="Low Cost Item" ><%} if(!high_margin_grey_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/HighMargin.jpg" style="<%=high_margin_grey_style%>" height='15' width='15' title="High Margin Item" ><%}if(!innovator_style.equals("visibility:hidden")){
								%>
								<img src="../../ePH/images/Innovator.jpg" title="Innovator Item" style="<%=innovator_style%>"  height='15' width='15' > <%} %></td>
<%								
%>								

							</td>
<%							if(formulary_billing_app){ //GHL-CRF-0549 
%>								
								<td class="<%=classvalue%>">	<%=preference_img%>&nbsp;</td>
<%							}
						}
%>
										
				<td class="<%=classvalue%>" style="font-size:9px;overflow: auto;" nowrap <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
<%
				if(!order_type.equals("TD") && !order_type.equals("TA")) { 
%>
					<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="showDrugMasterValues('<%=drug_code%>');" id="drug_mast_det_<%=recCount%>" >&nbsp;+&nbsp;</label>
<%
				}
				if(order_type.equals("TD") || order_type.equals("TA")) { 
%>
					<label style="cursor:pointer;color:blue" 	onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')"	onclick="showDrugDetails('<%=patient_class%>','<%=source_code%>','<%=order_id%>','<%=drug_code%>','<%=order_line_no%>','','<%=disp_locn_code%>','','', '<%=patient_id%>');" id="drug_desc<%=recCount%>"><%=drug_name%>&nbsp;<%=strength%></label>&nbsp;&nbsp;  <!--  , 'patient_id' added for [IN:035667] --><!-- Added for '','', Inc No : 41282 -->

<%
				if ((ext_prod_id!=null)&& !(ext_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){
%>
					<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=ext_prod_id%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>')" ></img> <!-- Passing UTF-8 for drug name on 18/NOv/2010 for incident num:25007 By Sandhya -->
<%
				}
			} 
			else { 
%>
				<label style="cursor:pointer;color:blue" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" onclick="showDrugDetails('<%=patient_class%>','<%=source_code%>','<%=order_id%>','<%=drug_code%>','<%=order_line_no%>','','<%=disp_locn_code%>','','', '<%=patient_id%>','Y','<%=generic_id%>','<%=order_line_status%>');" id="drug_desc<%=recCount%>" ><%=drug_name%>&nbsp;<%=strength%></label>&nbsp;&nbsp;  <!--  , 'patient_id' added for [IN:035667] --><!-- Added for '','', Inc No : 41282  ('Y',generic_id added for JD-CRF-0198 [IN058599]) --> 

<% 
				if ((ext_prod_id!=null)&&(ext_prod_id!="")){
%>
					<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=ext_prod_id%>','<%=java.net.URLEncoder.encode(drug_name,"UTF-8")%>')" ></img>
<%
				}

				if ((image_path!=null)&& !(image_path.equals(""))){
%>
					<img style="cursor:pointer;" src="../../ePH/images/camera.gif" height='20'  width='20' onClick="showImage('<%=drug_code%>','<%=trade_code%>')" >
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
				}
				if(count>1){		
	        	   	
					taper = bean.getTapervalue();
					if(taper.equals("UP")){
%>
						<img src="../../ePH/images/uparrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer"height='20' width='20'></img>
<%
					}
					else if(taper.equals("DOWN")){
%>
						<img src="../../ePH/images/downarrow.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer" height='20' width='20' ></img>
<%
					}
					else{
%>
						<img src="../../ePH/images/MultiFrequency.gif" onclick="showTaperDetails('<%=patient_id%>','<%=order_id%>','<%=drug_code%>');" valign="center" title='<fmt:message key="ePH.TaperDose.label" bundle="${ph_labels}"/>' style="cursor:pointer" height='20' width='20' ></img>
<%
					}
					if(totalTaperQtyDisplay.equals("Y")){ //added for RUT-CRF-0088 [IN036978]
%>
						<fmt:message key="Common.total.label" bundle="${common_labels}"/><fmt:message key="Common.Taper.label" bundle="${common_labels}"/><fmt:message key="Common.Qty.label" bundle="${common_labels}"/>   <!--Added for RUT-CRF-0088 [IN036978] -->
						<label>-<%=(int)tot_tap%>&nbsp;&#40;<%=qty_uom_disp%>&#41;</label>  <!--Added for RUT-CRF-0088 [IN036978] -->
<%
					}
				}     
			
				
								if(!strength_value.equals("")){
									  alt_drug			=	bean.checkMultiStrength(drug_code);
								}
								else if(medical_applicable.equals("Y") && medi_count>0 ){//ADDED FOR GHL-CRF-0548
									alt_drug ="Y";
								}
								else{
									alt_drug ="N";
								}
				expiry_date = bean_1.getSysdatePlusDays(fTotalDuration+"");
				alt_called_from="disp_medication_alt";
								if(item_type_site_app){
									allow_alternate_yn = bean.getAllowAlternateYN(order_id,order_line_no,iv_prep_yn);
									if(allow_alternate_yn==null || allow_alternate_yn.equals(""))
										allow_alternate_yn = "N";
								}
								
								if(barcode_scan_for_alt_app && iv_prep_yn.equals("")){ //changed intractn_req_yn to barcode_scan_for_alt_app for MMS-KH-CRF-0030
				%>  
				  <img src="../../ePH/images/altenate.jpg" height='15' width='15' align='top' style='cursor:pointer' onClick="getAlternateDrug('<%=drug_code%>','','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','Fill','<%=store_code%>','<%=pres_qty%>','<%=end_date%>','<%=strength_uom%>','<%=recCount%>','','<%=expiry_date%>','<%=disp_locn_catg%>','<%=allow_alternate_yn%>','<%=item_type_site_app%>','<%=strength_value%>','<%=iv_prep_yn%>','<%=alt_called_from%>','<%=disp_stage%>','Y','<%=classvalue%>','<%=generic_id%>','<%=barcodeScan%>')" title='<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/>'> 
			<%		
			}
			}
			if(bmscount==0){
				if(pat_couns_reqd_yn.equals("Y")){
					pat_reqd="Checked";
%>
					
					<img src="../../ePH/images/Patientcounsel.gif" valign="center"  disabled ></img>
					<input type='checkbox' name="pat_reqd_<%=recCount%>" id="pat_reqd_<%=recCount%>" <%=pat_reqd%> value='C' onclick="CheckPatReqd(this)" >
<%		
				}
				if(pat_couns_reqd_yn.equals("C")){
					pat_reqd="Checked";	
%>
					<img src="../../ePH/images/Patientcounsel.gif"  ></img>
					<input type="checkbox" name="pat_reqd_<%=recCount%>" id="pat_reqd_<%=recCount%>" <%=pat_reqd%> disabled value='' >
<%	
				} 
				if(pat_couns_reqd_yn.equals("N")|| pat_couns_reqd_yn.equals("Null") ){
					pat_reqd="Unchecked";	
					
					if(pt_couns_reqd_yn.equals("Y")){
%>
						<img src="../../ePH/images/Patientcounsel.gif"  ></img>
						<input type="checkbox" valign='center' name="pat_reqd_<%=recCount%>" id="pat_reqd_<%=recCount%>" <%=pat_reqd%> value='' onclick='CheckPatReqd(this)' >
<% 
					}
				}
			}
				if(print_value!=null && print_value.equals("1")){
%>
					<img  src="../../ePH/images/printed_fully.gif" height='20'  width='20' onmouseover = "showToolTipPrint(this,'Fully Printed')"></img>
<%							
				}
%>	

				 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<%
				
				disp_info	=	bean.getLastDispense(order_id,order_line_no);
				if(bDrugOrder)	{
					if(disp_info.size() > 0) {			
						if( ((String)disp_info.get(1)).equals("Y")) {
							dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispensedToday.label","ph_labels")+"</font>";
						}
						dosage_dtls =dosage_dtls+"&nbsp;&nbsp;&nbsp;&nbsp;<font color='red'style='cursor:pointer;' title='"+disp_info.get(0)+"' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.LastDispense.label","ph_labels")+"</font>";
					}
%>
					<%=alt_drug_remarks_disp%>&nbsp;<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=dosage_dtls%><!-- <%=alt_drug_remarks_disp%> added for  Bru-HIMS-CRF-082 [IN:029948] -->			
<% 
				}
%>
				
				<div id="alternate_<%=recCount%>" style="display:none">
				 <table cellpadding="0" cellspacing="0" width='100%' align="center" border="1" id="alternate_header_<%=recCount%>">
				 
 			
				 </table>
				<table cellpadding="0" cellspacing="0" width='100%' align="center" border="1" id="alternate_dtl_header_<%=recCount%>">
				</table>
				<table cellpadding="0" cellspacing="0" width='100%' align="center" border="1" id="alternate_dtl_footer_<%=recCount%>">
				</table>
				</div>
				
				<br><label id="id_min_stk_label" style='<%=min_stk_flag%>;'><fmt:message key="ePH.MINLEVEL.label" bundle="${ph_labels}"/>:</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->
				<label id="id_min_str_stk_<%=recCount%>" style='<%=min_stk_flag_bkg_clr%>;<%=min_stk_flag%>;'><b><%=frm_store_min_stk_level%></b></label>&nbsp;&nbsp;
				<label id="id_stk_rol_label_<%=recCount%>" style='<%=rol_flag%>;'><fmt:message key="ePH.ROL.label" bundle="${ph_labels}"/>:</label>
				<label  id="id_stk_rol_<%=recCount%>" style='<%=rol_flag_bkg_clr%>;<%=rol_flag%>;'><b><%=frm_store_reorder_level%></b></label>&nbsp;
				<label class='HYPERLINK'  name = "request_<%=recCount%>"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style='<%=disp_req_flag%>;' ><b><fmt:message key="ePH.CreateRequest.label" bundle="${ph_labels}"/></b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->
				<label class='HYPERLINK'  name = "manufacturing_<%=recCount%>"  onmouseover="changeCursor(this);" onclick="callManufacturingReceipt('<%=drug_code%>','<%=disp_locn_code%>');" id="manufacturing_Recpt" style='<%=disp_mnf_flag%>;' ><b>&nbsp;&nbsp;<fmt:message key="eST.Manufacturing.label" bundle="${st_labels}"/></b></label><!--Added BRU-HIMS-CRF-080 -->
<%
				k	=	0;
				alt_qty	=	new ArrayList();
				drug_name_1=  drug_name;  
			  
				for(int n=0; n<multi_drugs.size(); n+=5)	{ 
					alt_drug_code			=	(String)multi_drugs.get(n);
					alt_drug_desc			=	(String)multi_drugs.get(n+1);
					altDrugName.put(alt_drug_code,alt_drug_desc);// Added for Bru-HIMS-CRF-072.1 [IN:049144]
					form_code				=	(String)multi_drugs.get(n+2);
					alt_strength_value		=	(String)multi_drugs.get(n+3);
					alt_drug_desc_1	=    alt_drug_desc;

					if(!alt_drug_desc_1.equals("")&&alt_drug_desc_1!=null){
						alt_drug_desc_1=alt_drug_desc_1.replaceAll(" ","%20");
						alt_drug_desc_1=	java.net.URLEncoder.encode(alt_drug_desc_1,"UTF-8"); //Passed UTF-8 to alt_drug_desc_1 for the incident 25007==By Sandhya
						alt_drug_desc_1=alt_drug_desc_1.replaceAll("%2520","%20");
					}

					if(!disable_all.equals("disabled"))	
							bEditLabelEnabled = true;
					else
						bEditLabelEnabled = false;
	
					pack_dtls			=	bean.getPackSize(alt_drug_code);
					if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")) {
						form_code	=	(String)pack_dtls.get("STOCK_UOM");
					}

					if(pack_dtls!=null && pack_dtls.containsKey("EXTERNAL_PRODUCT_ID"))
						alt_external_prod_id	=	(String)pack_dtls.get("EXTERNAL_PRODUCT_ID");
					else
						alt_external_prod_id	=  "";

					drug_color		=	(String)colors.get(k++);
					qty				=	bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 

					if(!qty.equals("") && !qty.equals("0")) {
						alt_qty.add(alt_drug_code);
						alt_qty.add(qty);
						alt_qty.add(form_code);
						alt_qty.add(alt_strength_value);
					}
					fractroundupyn          =   bean.getFractRoundupYN(alt_drug_code);
					if(Min_Rol_yn){
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
								if (Double.parseDouble(qty) <  Double.parseDouble(frm_store_min_stk_level)){
									min_stk = true;
									if(getReq_allowed_yn)
										disp_req_flag =  "display:inline;color:blue";
									else
									disp_req_flag = "display:none";
								}
							}
							if(!frm_store_reorder_level.equals("0")){
								if (Double.parseDouble(qty)<  Double.parseDouble(frm_store_reorder_level)){
									rol_stk = true; 
									if(getReq_allowed_yn)
										disp_req_flag = "'display:inline;color:blue";
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
							
							if((min_stk&&getReq_allowed_yn)||(rol_stk&&getReq_allowed_yn))
								disp_req_flag = "display:inline;color:blue";
							else
								disp_req_flag  = "display:none;color:blue";
						}
						else{
							rol_flag   =	"display:none";
							min_stk_flag=	"display:inline";
							disp_req_flag  = "display:none";	
							min_stk_flag=	"display:none";
						}
					}
%>	
					<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
<%
					if(!order_type.equals("TD") && !order_type.equals("TA")) { 
%>
						<label style='color:red;font-size:12;FONT-WEIGHT: BOLDER;cursor:pointer;' onclick="showDrugMasterValues('<%=alt_drug_code%>');" id="drug_mast_det_<%=recCount%>" >&nbsp;+&nbsp;</label>
<%
					}
%>
					<label style="color:<%=drug_color%>" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')"  id="alte_drug_desc<%=n%>" ><%=alt_drug_desc%></label>
<%
					if ((alt_external_prod_id!=null)&& !(alt_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){
%>
						<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=alt_external_prod_id%>','<%=alt_drug_desc_1%>')" ></img>
<%  
					}
					adr_count = bean.getADRCount(patient_id,alt_drug_code);
					if(adr_count>0){
%>
						<img  id="ADR_img" src='../../ePH/images/ADR.gif'  height='20'  width='20' title='<fmt:message key="ePH.AdverseDrugReaction.label" bundle="${ph_labels}"/>' onclick= "callADRdetails('<%=patient_id%>','<%=alt_drug_code%>')"></img><!-- callADRdetails() newly added for RUT-SCF-0144 [IN:033371]-->
 <%
					}

					if(bEditLabelEnabled){
						hmEditLabelValues = bean_1.getHMEditLabelValuesAlt(order_id,order_line_no,drug_code,alt_drug_code,ord_date_time,drug_name,drug_desc,alt_drug_desc,qty,form_code,(multi_drugs.size()/5)+""); //modified for 12c

						alEditLabelPair.add(hmEditLabelValues);
						bEditLabelEnabled = false;
						bean.setSPerformPractId(performing_pract_id);
					}
%>
					<br><label id="id_min_stk_label" style='<%=min_stk_flag%>;'><fmt:message key="ePH.MINLEVEL.label" bundle="${ph_labels}"/>:</label><!--Added AMS-CRF-0068.1 [IN:050333] start  -->
					<label id="id_min_str_stk" style='<%=min_stk_flag_bkg_clr%>;<%=min_stk_flag%>;'><b><%=frm_store_min_stk_level%></b></label>&nbsp;&nbsp;
					<label id="id_stk_rol_label" style='<%=rol_flag%>;'><fmt:message key="ePH.ROL.label" bundle="${ph_labels}"/>:</label>
					<label  id="id_stk_rol" style='<%=rol_flag_bkg_clr%>;<%=rol_flag%>;'><b><%=frm_store_reorder_level%></b></label>&nbsp;
					<label class='HYPERLINK'  name = "request"  onmouseover="changeCursor(this);" onclick="request();" id="sales_req_label" style='<%=disp_req_flag%>;' ><b><fmt:message key="ePH.CreateRequest.label" bundle="${ph_labels}"/></b></label><!--Added AMS-CRF-0068.1 [IN:050333] end  -->
<%
				}
				if(order_type.equals("TD") ){ 
%>
					<img src='../../ePH/images/AddedIngredient.gif' height='15' width='15' style="cursor:pointer;" title='<fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/>' onClick="displayConst(<%=recCount%>)"></img>
<%
				}
%>
				<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
<% 
				if(order_type.equals("TD") && bean_1.getHmPPNValues() != null){ 
					String sPPNItemCode = (String)bean_1.getHmPPNValues().get("itemCode");
%>
					<label style="color:green" id="TPN_PPN_Details">&nbsp;<%=bean_1.getHmPPNValues().get("itemDesc")%></label>&nbsp;<img src='../../ePH/images/AddedIngredient.gif' height='15' width='15' style="cursor:pointer;" title='<fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/>' onClick="displayConstInPPN('<%=sPPNItemCode%>')"></img>
<%
				}
%>
				<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	
<%
	         if(drug_expiry_alert.equals("Yes") && !drug_expiry_days.equals("")){
%>
                   <label style="color:darkred" id="expiry_aler_lb_<%=recCount%>">&nbsp; This drug has batches which are going to expire in <%=drug_expiry_days%> Days </label>
<%}%>
			</td>
			
			<td class="<%=classvalue%>" style="font-size:9px" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">
			   <img src="../../ePH/images/DrugRemarks.gif" id='drugRemarks_<%=recCount%>' title='' valign="center"style="cursor:pointer;" onClick="displayInstructions('<%=order_id%>','<%=order_line_no%>','<%=dialog_height%>','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>')"<%=remarks_style%>>
			   <script>
					var drug_remarks = decodeURIComponent('<%=strDrugsRemarks%>');
					eval(document.getElementById("drugRemarks_"+'<%=recCount%>')).title= drug_remarks ;
			   </script>
			</td>

			<td class="<%=classvalue%>" style="font-size:9px" title="<%=pres_details%>" >
				<img src="../../ePH/images/exceed.gif" valign="center">
			</td>

			<td class="<%=classvalue%>" style="font-size:9px" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">&nbsp;<label style='<%=narc_style%>'><%=bean_1.retunFormatedInt(pres_qty)%>&nbsp;(<%=qty_uom_disp%>)</label><br>
<%
				if(order_type.equals("TA")){
					bean.setTPNPresQty(pres_qty);
				}				
				if(!strength_value.equals("") && !strength_value.equals("0"))
				{						
				pres_strength	=	bean_1.retunFormatedInt((((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))*(main_drug_pack_size))/(Float.parseFloat(main_strength_per_value_pres_uom)))+"")+" "+strength_uom;
				pres_strength_1 =	bean_1.retunFormatedInt((((Float.parseFloat(pres_qty) * Float.parseFloat(strength_value))*(main_drug_pack_size))/(Float.parseFloat(main_strength_per_value_pres_uom)))+"")+"";  
				}
				if((multi_drugs.size()>1) && (fractroundupyn.equals("N")) ) {
%>
					&nbsp;<b><%=pres_strength%></b>
<%
				}
%>
			</td>
<% 		
			if(multi_drugs.size() > 1 ) {	
				if((ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I") &&  !disable_all.equals("disabled")  ){
%>
	               <td class="<%=classvalue%>">&nbsp;</td>
<%				
			}
%>
		<td class="<%=classvalue%>" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')"><br>
<%
			int x	=	0;
			int tmp_recCount		=	recCount;
			String alternate_drug	=	"";
			float pack_size			=	1;
			float strength_per_value	=	1.0f;
			
			if(alt_qty.size()<=0){
				bAltQtyAvailable	= false;
			}
			else{
				for(int l=0; l<alt_qty.size(); l+=4) { 
					alternate_drug		=	(String)alt_qty.get(l);	
					qty					=	(String)alt_qty.get(l+1);	
					uom					=	(String)alt_qty.get(l+2);	
					alt_strength_value	=	(String)alt_qty.get(l+3);	

					drug_color	=	(String)colors.get(x++);

					pack_dtls				=	bean.getPackSize(alternate_drug);
					
					IssueUOMAndBaseUOM		=	(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,alternate_drug); // Added for ML-BRU-SCF-1803 - Start
					base_uom			     =  (String)IssueUOMAndBaseUOM.get("BASE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("BASE_UOM");
					base_to_disp_uom_equl    =	bean.getEqulValue ( alternate_drug, base_uom, uom);
					orig_dflt_issue_uom      = (String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM")==null?"":(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
					base_to_def_uom_equl	 =  bean.getEqulValue ( alternate_drug, base_uom, orig_dflt_issue_uom);
					medical_applicable=bean.checkMedicalItemYN(alternate_drug);
					if(!medical_applicable.equals("Y") && !uom.equals(base_uom) ){
						conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);						
					} 
					
					fractroundupyn          =   bean.getFractRoundupYN(alternate_drug);

					if(pack_dtls!=null && pack_dtls.containsKey("PACK_SIZE")){
						if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
							pack_size			=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));
							if(!medical_applicable.equals("Y")){	
								strength_per_value	=	Float.parseFloat(((String)pack_dtls.get("STRENGTH_PER_VALUE_PRES_UOM")));
							  if(base_to_disp_uom_equl!=base_to_def_uom_equl){
								 qty = Math.ceil(Float.parseFloat(qty)/pack_size)+"";
							  }else if(!uom.equals(base_uom) && !alternate_drug.equals("") ){ 							
								  qty  =   Math.round(Double.parseDouble(qty)/base_to_disp_uom_equl)+""; 
							  }
						  }
						}		
					}
					if(!medical_applicable.equals("Y")){
					tmp_alloc	+=	new Float( ((Float.parseFloat(alt_strength_value)) * Double.parseDouble(qty)*pack_size)/strength_per_value ).doubleValue();}
					if(fractroundupyn.equals("N")) {
						alloc_strength	=	bean_1.retunFormatedInt(tmp_alloc+"")+" "+strength_uom;
					}else{
						 alloc_strength	=   "";
					} 
		
	float prescribed_strength=0;
		if(!medical_applicable.equals("Y")){			
		 prescribed_strength	=	(Float.parseFloat(tmp_bms_qty_1) * 	Float.parseFloat(strength_value))/Float.parseFloat(main_strength_per_value_pres_uom);
		}
					double balance_strength		=	prescribed_strength - tmp_alloc;	
					
					if(balance_strength<1)
							balance_strength		=	0;
					if(fractroundupyn.equals("N")) {
						if(balance_strength!=0) {
							bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
						} 
						else {
							bms_qty					=	"0";
						}
					}
					else{
						//bms_qty					=bms_qty;
						if(balance_strength!=0) {
							bms_qty						=	Math.round(balance_strength / Float.parseFloat(strength_value))+"";
						} 
						else {
							bms_qty					=	"0";
						}
					}
					bms_qty=Math.round(((Float.parseFloat(bms_qty)*(Float.parseFloat(main_strength_per_value_pres_uom)))/main_pack_size))+"";
					bms_strength				=	balance_strength+"";
				      if(medical_applicable.equals("Y")){ 
					bms_qty = (Float.parseFloat(tmp_bms_qty)-Float.parseFloat(qty))+"";
					tmp_bms_qty = bms_qty;
						alloc_strength = "";
					} 

					if(qty.equals("") || qty.equals("0")) 
						uom="";	
					else {
	
						tot_qty		+=	Double.parseDouble(qty);
					}
	/*==========code added to handle if dispense uom and default uom in item store is different=================*/

				issue_qty_dtl =new StringBuffer();
				if(IssueUomQty.containsKey(order_id+order_line_no+alternate_drug+"_qty")){
					issue_qty_value	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_qty");
					issue_uom	    = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_uom");
					issue_uom_desc	= (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_desc");
					issue_uom_equl  = (String)IssueUomQty.get(order_id+order_line_no+alternate_drug+"_equl");
					if(bean_1.getIssueByUOM().equals("I") && !issue_qty_value.equals("0")){
						issue_qty_dtl   =  issue_qty_dtl.append("( ").append(issue_qty_value).append("  ").append(issue_uom_desc).append(" )");
					}
				}
	/*==========ends here=========================================================================================*/
%>
				<label style="color:<%=drug_color%>;font-size:9px" id="alloc_qty<%=tmp_recCount%>" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >&nbsp;<%=bean_1.retunFormatedInt(qty)%>&nbsp;(<%=bean.getUomDisplay(facility_id,uom)%>)<%=issue_qty_dtl.toString()%><br>
					
<%	
					tmp_recCount++;	
					hsh_med_plan = new LinkedHashMap();
					
					if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y") && patient_class.equals("OP"))	{
						if(!alt_qty.contains(drug_code)){
							medplan_bean.getMedPlan_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+primary_lang_id);
							medplan_bean.getMedPlan_Local_DrugDetails().remove(order_id+"_"+order_line_no+"_"+drug_code+"_"+loc_lang_id);
						}
						arrOrderId.add(order_id+"_"+order_line_no);
						medplan_bean.setMedPlanMethods(order_id, order_line_no,primary_lang_id,drug_code,alternate_drug,loc_lang_id,qty,(String)altDrugName.get(alternate_drug),uom);
						
					}
				}
			}
		
			

%>
			</label>&nbsp;<label style="font-size:9px;color:black" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')"><b><%=alloc_strength%></b></label><br><label style="cursor:pointer;color:blue;font-size:9px;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','Y','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>');"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label>
			</td>
<%
			}
			else if(!tpn_finalize.equals("") ||((bean_1.getTPNWorksheetID(order_id) != null) && (!bean_1.getTPNWorksheetID(order_id).equals("")))){
				 tpn_qty		= "";
				String tpn_qty_uom	= "";
				ArrayList tpn_vals  = null;
				ArrayList al		= null;

				if((tpn_finalize.equals("NO")) || (tpn_finalize.equals(""))){
					bean_1.setPrevWorkSheetDetails(al);
				}

				if((bean_1.getTPNWorksheetID(order_id) != null) && (!tpn_finalize.equals("YES"))){
					tpn_vals = bean_1.getTPNQtyUom(order_id);

					if(tpn_vals.size() > 0){
						if(!(bean.getTPNQty().equals("0.0")) && tpn_mf_label ){
							tpn_qty=(String)bean.getTPNQty();
						}
						else{
							tpn_qty = (String)tpn_vals.get(0);
						}
						
						tot_qty = Double.parseDouble(tpn_qty);
						tpn_qty_uom = qty_uom;
						bms_qty	=	Float.parseFloat(bms_qty)- tot_qty +"";
						if(Float.parseFloat(bms_qty)<1){
							 bms_qty="0";
						}
					}
				}else if(!tpn_finalize.equals("")){

					tpn_qty=bean.getTPNQty();
					tpn_qty_uom=bean.getTPNQtyUOM();
				}

				if(tpn_qty.equals("0")){
					tpn_qty		= "";
					tpn_qty_uom	= "";
				}
			
			if(tpn_mf_label){	if(order_type.equals("TD") && !(tpn_qty.equals("0")|| tpn_qty.equals("")) && bean.getTPNValues().size() == 0 ){
					tpn_wrksheet_rcrd="N";
				}
				else{
					tpn_wrksheet_rcrd="Y";
				}}
				
%>
				<td class="<%=classvalue%>" style="font-size:9px" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
				<label class="label" id="alloc_qty<%=recCount%>" style="font-size:9px"><b>&nbsp;<%=bean_1.retunFormatedInt(tpn_qty+"")%>&nbsp; <%=bean.getUomDisplay(facility_id,tpn_qty_uom)%></b><br></label>
<%
			}
			else if(ws_tot_qty != 0 ){			// THIS IS FOR WORKSHEET   
%>
			<td class="<%=classvalue%>" style="font-size:9px" <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
			<label class="label" id="alloc_qty<%=recCount%>" style="font-size:9px"><b>&nbsp; <%=bean_1.retunFormatedInt(ws_tot_qty+"")%>&nbsp;  (<%=qty_uom_disp%>)</b><br></label> <!----/*bean.getUomDisplay(facility_id,qty_uom)*/-->
<%
			
%>
			</td>
<%		
		}
		else{	
			if(qty.equals("") || qty.equals("0")) {
				qty	=	"";
				uom	=	"";	
			}
			else {
				if(!strength_value.equals("") && !strength_value.equals("0"))
					alloc_strength	=	Float.parseFloat(strength_value) * Double.parseDouble(qty)+" "+strength_uom;
				
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
			
			String issueUomDisbYn = ""; 
			if(!last_scanned.equals("") && (ord_type.equals("NOR") || bEquivalentNormalOrder) && bean_1.getIssueByUOM().equals("I")){ 
				issueUomDisbYn = "disabled";
			} 
%>
	<td align="left" CLASS="<%=classvalue%>" style='<%=display_list%>'>&nbsp;

	<select onChange="calculateIssueUOM(this,'<%=recCount%>','<%=order_id+order_line_no+drug_code+"_uom"%>');" name="issue_uom_select_<%=recCount%>" <%=issueUomDisbYn%>>  <!-- // issueUomDisbYn Added for MMS-DM-SCF-0488 - Reopen Issue -->
<% 
		String stk_unit_code	= "";
		String stk_unit_desc	= "";
		String stk_equval_value	= "";
		String act_stk_equval_value	= "";
		String uom_desc				= "";//added for AAKH-SCF-0338
		stk_units				= bean.loadStockUnit(drug_code);
	    String base_to_def_uom_equl_val  ="1";
		String base_to_disp_uom_equl_val ="1";
		//added for AAKH-SCF-0338 - start
		if(stk_units!=null && stk_units.size()>0){
			if(!stk_units.contains(orig_dflt_issue_uom)){
				uom_desc = bean.getUOMDesc(orig_dflt_issue_uom);
				stk_units.add(orig_dflt_issue_uom);
				stk_units.add(uom_desc);
				stk_units.add("1");
				stk_units.add("1");
			}
		}
		
		for(int iStkCountt=0; iStkCountt<stk_units.size();iStkCountt+=4) { 
				stk_unit_code		    =	(String)stk_units.get(iStkCountt);
				stk_unit_desc		    =	(String)stk_units.get(iStkCountt+1);
				stk_equval_value	    =	(String)stk_units.get(iStkCountt+2);
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

	
		HashMap hmAllowMoreQty = bean_1.getHmAllowMoreQty();

		if(hmAllowMoreQty == null)
			hmAllowMoreQty = new HashMap();
  %>

	</select>&nbsp;
	<input type ="hidden" name ="issueUOMValue_<%=recCount%>" value = "<%=order_id+order_line_no+drug_code+"_uom"%>">
	</td>

		<td class="<%=classvalue%>"  <%=title%> onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" >
			<input type="hidden" name="AllowMoreThanPresQty<%=recCount%>" id="AllowMoreThanPresQty<%=recCount%>"  value="<%=hmAllowMoreQty.get(drug_code)%>">
		<%
				if( (ord_type.equals("NOR") || bEquivalentNormalOrder)){
					if(bean_1.getBarcode_Scan_YN().equals("Y") || (bean_1.getBarcode_Scan_YN().equals("N") && barcode_id.equals(""))) // Added for [IN:064158] - Start
             		                  if(qty.equals("0.0") || qty.equals("") ||  qty.equals("0"))
             			                qty = "0.0"; 
					if(stock_opt.get(0).equals("Y")||check_yn.equals("Y")){	
						if(in_formulary_yn.equals("Y")){
%>
          						<input type="text" class="flat" size="6" style="text-align:right"  <%=alloc_readonly%>   onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="<%=  bean_1.retunFormatedInt(qty)%>" oncopy="return false" onpaste="return false"  onchange="setValueChanged(); if(checkAllocBmsSecondStage('<%=recCount%>', this)){checkValue(this); setbatchdetails(this,'<%=store_code%>','<%=base_uom%>','<%=end_date%>','<%=item_code%>','<%=trade_code%>','<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=uom%>','<%=billing_interface_yn%>','<%=drug_code%>','<%=act_bms_qty%>','<%=bean_1.retunFormatedInt(qty)%>','<%=recCount%>')};" <%=disable_all%> <%=taper_disable%> > 

<%
								bean_1.setStockDtlKey(drug_code+"qty",bean_1.retunFormatedInt(qty));//Added for KDAH-CRF-0231 [IN-034551]
								if(bean_1.getStockDtl().containsKey("valid_drug_code") && (order_id+"~"+order_line_no+"~"+drug_code).equals((String) bean_1.getStockDtl().get("valid_drug_code"))){ //if block added for added for KDAH-CRF-0231 [IN-034551] 
%>
									<script>
										document.getElementById("alloc_fromBarCode").value="Y";
										<!--document.getElementById("alloc_qty_")<%=recCount%>.focus(); commented for GHL-CRF-0413.1 [IN:061794] and added color for GHL-CRF-0413.1 [IN:061794]-->
									<% if(bean_1.getBarcodeColorYn(order_id,order_line_no).equals("Y")){ // condition Added for MMS-DM-SCF-0488 %>
										document.getElementById("alloc_qty_"<%=recCount%>).style.backgroundColor = "#ADFF2F";
									<%}%>
									</script>
<%					    
								}
						}
						else{
%>
							<input type="text" class="flat" size="6" style="text-align:right"  <%=alloc_readonly%>   onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="" disabled>
<%
						}
%>
						 <input type ="hidden" name = "alloc_qty_hidden_<%=recCount%>" value ="document.DispMedicationAllStages.alloc_qty_<%=recCount%>~<%=store_code%>~<%=base_uom%>~<%=end_date%>~<%=item_code%>~<%=trade_code%>~<%=patient_id%>~<%=order_id%>~<%=order_line_no%>~<%=uom%>~<%=billing_interface_yn%>~<%=drug_code%>~<%=act_bms_qty%>~<%=bean_1.retunFormatedInt(qty)%>~<%=recCount%>">
						<label class="label" ><b>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%></b></label><br><label id="issue_uom_lbl<%=recCount%>" class="label" style style='font-size:9px' ><b>&nbsp;<%=issue_qty_dtl.toString()%></b></label><br><label style="cursor:pointer;color:blue;font-size:9px;" onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','N','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>');"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label>

						<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>"     value="<%=uom%>">
						<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=bean_1.retunFormatedInt(qty)%>">
						<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
						<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
						<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
						<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="<%=issue_uom_equl%>">
						<input type="hidden" id="last_scanned_<%=recCount%>" value="<%=last_scanned%>"> <!-- Added for GHL-CRF-0463 // changed for MMS-DM-SCF-0488 -->
					<%  
						
					     if(!qty.equals("")){
							 if(Float.parseFloat(qty)>0){
						           disp_delivery_chk_box_val="Y";
							 }
						 }
						 else{
							 disp_delivery_chk_box_val="N";
						 }
					}
					else{
						 if(in_formulary_yn.equals("Y")){
%>
							  <input type="text" class="flat" size="6" style="text-align:right"  <%=alloc_readonly%>   onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" value="<%=bean_1.retunFormatedInt(qty)%>" <%=disable_all%>  onchange="setValueChanged();" onblur="includeToBms(this,'<%=recCount%>');checkValue(this);" oncopy="return false" onpaste="return false" <%=taper_disable%>><!--Add oncopy and onpaste methods for Incident No.30101 -->  
<%
							}
							else{
%>
								<input type="text" class="flat" size="6" style="text-align:right"    onKeyPress="return allowValidNumber(this,event,6,0);"  maxlength="5" name="alloc_qty_<%=recCount%>" id="alloc_qty_<%=recCount%>" value="<%=bean_1.retunFormatedInt(qty)%>" disabled  >
								
								<label class="label" ><b>&nbsp;<%=bean.getUomDisplay(facility_id,uom)%></b></label><br><label style="cursor:pointer;color:blue;font-size:9px;" onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','N','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>');"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/></label> 
<%
							}
%>
							<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>"     value="">
							<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="">
							<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="">
							<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="">
							<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="">
							<input type="hidden" name="issue_uom_equl<%=recCount%>" id="issue_uom_equl<%=recCount%>"value="">
<%   
							disp_delivery_chk_box_val="N";
						}
%>
						</td> 	
<%
					}
					else{	
%>  
						<label class="label" id="alloc_qty<%=recCount%>"><b>&nbsp;<%=bean_1.retunFormatedInt(qty)%>&nbsp;  <%=bean.getUomDisplay(facility_id,uom)%></b><br></label><label id="issue_uom_lbl<%=recCount%>" class="label" style style='font-size:9px' ><b>&nbsp;<%=issue_qty_dtl.toString()%></b></label>
									<script>
										document.getElementById("alloc_fromBarCode").value="Y";
									<% if(bean_1.getBarcodeColorYn(order_id,order_line_no).equals("Y") && qty!=null && !qty.equals("")){
										
									%>
										document.getElementById("alloc_qty"<%=recCount%>).style.backgroundColor = "#ADFF2F";
									<%}%>
									</script>
<% 
						if(order_type.equals("TD") && bean_1.getHmPPNValues() != null){ 
%>
							<b><label style="color:green;font-size:9px" id="TPN_PPN_alloc_qty"><%=bean_1.getHmPPNValues().get("selectedQty")%>&nbsp;<%=bean.getUomDisplay(facility_id,bean_1.getHmPPNValues().get("UOMCode").toString())%></label><b>
<%
						}
						if(!qty.equals("")){
%>
							<input type="hidden" name="issue_uom<%=recCount%>" id="issue_uom<%=recCount%>" value="<%=uom%>">
							<input type="hidden" name="issue_qty_old<%=recCount%>" id="issue_qty_old<%=recCount%>" value="<%=bean_1.retunFormatedInt(qty)%>">
							<input type="hidden" name="issue_uom_qty<%=recCount%>" id="issue_uom_qty<%=recCount%>" value="<%=issue_qty_value%>">
							<input type="hidden" name="issue_uom_uom<%=recCount%>" id="issue_uom_uom<%=recCount%>" value="<%=issue_uom%>">
							<input type="hidden" name="issue_uom_desc<%=recCount%>" id="issue_uom_desc<%=recCount%>"value="<%=issue_uom_desc%>">
		
							<br><label style="cursor:pointer;color:blue;font-size:9px;"  onClick="javascript:callbatchdetails('<%=patient_id%>','<%=order_id%>','<%=order_line_no%>','<%=drug_code%>','N','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>');"><fmt:message key="ePH.Trades.label" bundle="${ph_labels}"/> </label> 
							</td>
<%
					}
				}
				hsh_med_plan = new LinkedHashMap();// Added for Bru-HIMS-CRF-072.1 [IN:049144] start		
				
				if(!qty.equals("") && !qty.equals("0") && drug_trade_bean.getDrugyesno().equals("Y") && bean_1.getMedicationPlannerYN().equals("Y") && patient_class.equals("OP"))	{
					arrOrderId.add(order_id+"_"+order_line_no);
					medplan_bean.setMedPlanMethods(order_id, order_line_no,primary_lang_id,drug_code,drug_code,loc_lang_id,qty,CommonBean.checkForNull(medplan_bean.getDrug_desc(drug_code)),uom);
				}
		}	
	
		bms_qty = bean_1.getBMSQtyFill(multi_drugs.size(),fractroundupyn,ws_tot_qty,bms_qty,qty,tot_qty);//modified for 12c
		if(!strength_value.equals("") && !alt_strength_value.equals("")) {
			if(bms_strength.equals(""))
				bms_strength	=	Double.parseDouble(bms_qty) * Double.parseDouble(strength_value)*(main_pack_size)+"";
			
		}
		else if(!strength_value.equals("") && !strength_value.equals("0")) {
			bms_strength		=	"";
			strength_uom		=	"";
		}
		else 
			strength_uom	=	"";
	
		if(fractroundupyn.equals("Y")) {
			bms_strength="";
			strength_uom="";
		}
		if(bms_strength.equals("0.0")||bms_strength.equals("0")||bms_qty.equals("0.0")||bms_qty.equals("0")){
			bms_strength="";
			strength_uom="";
		}
		if(Double.parseDouble(bms_qty)<0){
				bms_qty ="0";
		}
%>
		<td class="<%=classvalue%>"  style="font-size:9px" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')"<%=title%>> &nbsp;
		<input type="hidden" name="qty_uom<%=recCount%>" id="qty_uom<%=recCount%>" value="<%=qty_uom%>">
		<label class="label" id="bms_qty_<%=recCount%>">&nbsp;<%=bean_1.retunFormatedInt(bms_qty)%>&nbsp;</label>&nbsp;(<%=qty_uom_disp%>)
		<br>&nbsp;<b><%=bms_strength%>&nbsp;<%=strength_uom%></b>
		<input type="hidden" name="bms_qty<%=recCount%>" id="bms_qty<%=recCount%>" value="<%=bean_1.retunFormatedInt(bms_qty)%>">
		<input type="hidden" name="act_bms_qty<%=recCount%>" id="act_bms_qty<%=recCount%>" value="<%=bean_1.retunFormatedInt(act_bms_qty)%>"></td>
 <%
			String strModDrugCode =  drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");           
	        String disabled = "disabled";	
			if(billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
			if(bean.getDisplayInsStatus()){  //Added for TH-KW-CRF-0012
%>
          <td class="<%=classvalue%>"><center>&nbsp;<%=insurance_status%></center></td>
<%}
				if(in_formulary_yn.equals("Y")  ){ 
							float gross_charge_amount =  0;
							float groos_pat_payable   =  0;
							float gross_amount        = 0;
							//float net_amount          =  0;
							gross_charge_amount_str	  =  "";
							groos_pat_payable_str	  =  "";							
							batch_str				  =   "";
							gross_amount_str =  "";
							StringBuffer gross_charge_display_str   = new StringBuffer();
							StringBuffer pat_charge_display_str     = new StringBuffer();
							StringBuffer inc_exec_display_str		= new StringBuffer();    
							StringBuffer gross_disply_str          = new StringBuffer();

					if( (!qty.equals("") && Float.parseFloat(qty)!=0)|| ws_tot_qty!=0 || multi_drugs.size()>1){
						if(((!qty.equals("") && Float.parseFloat(qty)!=0)|| ws_tot_qty != 0) && (billable_item_yn.equals("Y"))){
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
									  HashMap billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,bl_patient_class,dischargeIND);
									  if(billing_det.containsKey(drug_code)){
										   HashMap  chareg_det=(HashMap)billing_det.get(drug_code);
										   if(chareg_det.get("error_msg").equals("")){
											   if(chareg_det.get("pat_paid_flag") != null && !chareg_det.get("pat_paid_flag").toString().equals("")){
												   if(chareg_det.get("pat_paid_flag").equals("0")||chareg_det.get("pat_paid_flag").equals("1")||chareg_det.get("pat_paid_flag").equals("2")){
														bPatientPaid = true;
														if(bean_1.getPatPaidYNForZeroBill().equals("Y")){//Added FOR SKR-SCF-0979 [IN:048119] & ML-BRU-SCF-1281 [IN:047783] -ISSUE 1 -start
															pat_paid_amt			=	(String)chareg_det.get("pat_paid_amt"); 
															pat_net_charge_amt			=	(String)chareg_det.get("netchargeamt");
															if((pat_paid_amt.equals("")|| Float.parseFloat(pat_paid_amt)==0) && (pat_net_charge_amt.equals("")|| Float.parseFloat(pat_net_charge_amt)==0)){ 
																bPatientPaid   = false;
															}
															else if(!pat_paid_amt.equals("") && Float.parseFloat(pat_paid_amt)!=0 && !pat_net_charge_amt.equals("") && Float.parseFloat(pat_net_charge_amt)!=0){  
																bPatientPaid   = true;
															} 
														}
												   }
											   }
											   disp_delivery_chk_box_val =  "Y";

												decimalFormatString=(String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
												DecimalFormat dfTest        = new DecimalFormat(decimalFormatString);												
												if(!chareg_det.get("patnetamt").equals("null")){
													groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
												}
												if(!chareg_det.get("netchargeamt").equals("null")){
													gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
												}											
												if(displayGrossAmtYn) {
													if(!chareg_det.get("grosschargeamt").equals("null")){
													gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
											     
													}
												}
																							
												batch_str                =(String)chareg_det.get("BATCH_STRING");
												gross_charge_amount_str  = dfTest.format(gross_charge_amount);
												groos_pat_payable_str    = dfTest.format(groos_pat_payable);
												
												if(displayGrossAmtYn) {
												gross_amount_str         = dfTest.format(gross_amount);
												}
											
												gross_charge_display_str.append("<label style='font-size:9px;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(groos_pat_payable_str).append("</label>");

												pat_charge_display_str.append("<label style='font-size:9px;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(gross_charge_amount_str).append("</label>");	
											
												if(displayGrossAmtYn) {
												gross_disply_str.append("<label style='font-size:9px;color:black' id='gross_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(gross_amount_str).append("</label>");
												}
											
												inc_exec_display_str.append("<a  style ='font-size:9px' href=\"javascript:callIncludeExclude(").append("'F'").append(",").append("''").append(",").append("'").append(drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</a>");
												
												tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
												tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
												//added for ML-BRU-SCF-0469 strat
													if(tot_gross_charge_amount!=tot_groos_pat_payable){  //AAKH-CRF-0117
														approval_flag =true;
													}
												if(displayGrossAmtYn) {
												tot_gross_amount        = tot_gross_amount+gross_amount;
												}
											
%>
												<input type="hidden" name="override_allowed_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="override_allowed_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"  value="<%=(String)chareg_det.get("override_allowed_yn")%>">
												<input type="hidden" name="excl_incl_ind_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="excl_incl_ind_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"        value="">
												<input type="hidden" name="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="<%=(String)chareg_det.get("excl_incl_ind")%>">
												<input type="hidden" name="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"     value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
												<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
												<input type="hidden" name="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
												<input type="hidden" name="gross_charge_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="gross_charge_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="<%=gross_charge_amount+""%>">
												<input type="hidden" name="groos_pat_payable_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="groos_pat_payable_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value="<%=groos_pat_payable+""%>">
											
												<% if(displayGrossAmtYn) { %>
												<input type="hidden" name="gross_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="gross_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value="<%=gross_amount+""%>">
												<%} %>												
												<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value='black'>
<%  
											}
											else{
												gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
												pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
												
												if(displayGrossAmtYn) {
												gross_disply_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>");
												}												
												disp_delivery_chk_box_val="N";												
													
									   }
								  }
						   }
						}
						if(multi_drugs.size()>1){
							  int  added_yn =0;
							  int  x		=0;
							  String sModAltDrugCode = "";
								for(int n=0; n<multi_drugs.size(); n+=5)	{							    
										alt_drug_code	     =	(String)multi_drugs.get(n);
										sModAltDrugCode		 = alt_drug_code.replace("_","zXd1").replace(".","zXd2").replace("-","zXd3");
							
										 drug_color			 =	(String)colors.get(x++);
										 HashMap billing_det = bean.getchargedetails(patient_id ,order_id,order_line_no,bl_encounter_id,bl_patient_class,dischargeIND);
									   if(billing_det.containsKey(alt_drug_code)){
											   HashMap  chareg_det=(HashMap)billing_det.get(alt_drug_code);
											   if(chareg_det.get("error_msg").equals("")){
												   disp_delivery_chk_box_val = "Y";
												   batch_str				 = (String)chareg_det.get("BATCH_STRING");
												   decimalFormatString       = (String)chareg_det.get("BL_DECIMAL_FORMAT_STRING");
													DecimalFormat dfTest     = new DecimalFormat(decimalFormatString);
													
													if(!chareg_det.get("patnetamt").equals("null")){ 
														groos_pat_payable  = Float.parseFloat(((String)chareg_det.get("patnetamt")).trim());
													}
													if(!chareg_det.get("netchargeamt").equals("null")){
														gross_charge_amount  = Float.parseFloat((String)chareg_det.get("netchargeamt"));
													}
													if(displayGrossAmtYn) {
														if(!chareg_det.get("grosschargeamt").equals("null")){
														gross_amount  = Float.parseFloat((String)chareg_det.get("grosschargeamt")); 
												     
														}
													}

													gross_charge_amount_str = dfTest.format(gross_charge_amount);
													groos_pat_payable_str   = dfTest.format(groos_pat_payable);											   
													gross_amount_str        = dfTest.format(gross_amount);
													gross_charge_display_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(groos_pat_payable_str).append("</label><BR>");
													pat_charge_display_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(gross_charge_amount_str).append("</label><BR>");
													inc_exec_display_str.append("<label style='cursor:pointer;font-size:9px;color:").append(drug_color).append("' onclick=\"javascript:callIncludeExclude(").append("'F'").append(",").append("''").append(",").append("'").append(alt_drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</label><br>");
													gross_disply_str.append("<label style='font-size:9px;color:").append(drug_color).append("' id='gross_amount_str_").append(order_id).append(order_line_no).append(sModAltDrugCode).append("'>").append(gross_amount_str).append("</label><BR>");// Added for ML-BRU-CRF-0469 [IN:065426]
													added_yn++;
													tot_gross_charge_amount = tot_gross_charge_amount+gross_charge_amount;
													tot_groos_pat_payable   = tot_groos_pat_payable+groos_pat_payable;
													tot_gross_amount        = tot_gross_amount+gross_amount;
													if(tot_gross_charge_amount!=tot_groos_pat_payable){
														approval_flag =true;
													}
%>
												<input type="hidden" name="override_allowed_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="override_allowed_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"  value="<%=(String)chareg_det.get("override_allowed_yn")%>">
												<input type="hidden" name="excl_incl_ind_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="excl_incl_ind_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"        value="">
												<input type="hidden" name="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"value="<%=(String)chareg_det.get("excl_incl_ind")%>">
												<input type="hidden" name="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"     value="<%=(String)chareg_det.get("approval_reqd_yn")%>">
												<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" value="">
												<input type="hidden" name="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" value="">
												
												<input type="hidden" name="gross_charge_amount_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="gross_charge_amount_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" value="<%=gross_charge_amount+""%>">
												<input type="hidden" name="groos_pat_payable_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="groos_pat_payable_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"   value="<%=groos_pat_payable+""%>">
												<input type="hidden" name="gross_amount_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="gross_amount_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"   value="<%=gross_amount+""%>"><!-- Added for ML-BRU-CRF-0469 [IN:065426] -->
												<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>" id="drug_color_<%=order_id%><%=order_line_no%><%=sModAltDrugCode%>"   value="<%=drug_color%>">
<%
											}
											else{
												  gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label><BR>");
												  pat_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label><BR>");
												  gross_disply_str.append("<label style='font-size:9px;color:red' title='").append(chareg_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label><BR>"); // Added for ML-BRU-CRF-0469 [IN:065426]
												
												   disp_delivery_chk_box_val="N";
											   }
										  }							  
								}
								
							}	
						}
						else{
							if(displayGrossAmtYn) {
							        gross_disply_str.append("<label style='font-size:9px;color:black' id='gross_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append("</label>");
							}
							
							        gross_charge_display_str.append("<label style='font-size:9px;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append("</label>");

							pat_charge_display_str.append("<label style='font-size:9px;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append("</label>");	

							inc_exec_display_str.append("<a id='lblIncludeExclude"+recCount+"' style ='font-size:9px;visibility:hidden' href=\"javascript:callIncludeExclude(").append("'A'").append(",").append("''").append(",").append("'").append(drug_code).append("'").append(",").append("'").append(qty).append("'").append(",").append("'").append(batch_str).append("'").append(",").append("'").append(order_id).append("'").append(",").append("'").append(order_line_no).append("'").append(")\">").append( com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Include.label","common_labels")).append("?</a>");
%>
							<input type="hidden" name="override_allowed_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="override_allowed_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"  value="">
							<input type="hidden" name="excl_incl_ind_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="excl_incl_ind_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"        value="">
							<input type="hidden" name="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="excl_incl_ind_default_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"value="">
							<input type="hidden" name="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="approval_reqd_yn_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"     value="">
							<input type="hidden" name="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="bl_incl_excl_override_reason_desc_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
							<input type="hidden" name="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="bl_incl_excl_override_reason_code_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
							<% if(displayGrossAmtYn) { %>
							<input type="hidden" name="gross_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="gross_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value="">
							<% } %>
							<input type="hidden" name="gross_charge_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="gross_charge_amount_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" value="">
							<input type="hidden" name="groos_pat_payable_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="groos_pat_payable_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value="">
							<input type="hidden" name="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>" id="drug_color_<%=order_id%><%=order_line_no%><%=strModDrugCode%>"   value='black'>
<%
						}
%>	   

           
             <% if(displayGrossAmtYn) { %>
					<td class="<%=classvalue%>"><center>&nbsp;<%=gross_disply_str.toString()%></center><br>
<% 
					if(order_type.equals("TD") && bean_1.getHmPPNValues() != null){ 
						if(bean_1.getHmPPNValues().get("billingError")== null || bean_1.getHmPPNValues().get("billingError").equals("")){					
%>
							<label style="color:green;font-size:9px" ><%=bean_1.getHmPPNValues().get("grossCost")%></label>
<%
						}
						else{
%>
							<label style="color:green;font-size:9px" title="<%=bean_1.getHmPPNValues().get("billingError")%>"><center><fmt:message key="Common.Error.label" bundle="${common_labels}"/></center></label>
<%
						}
					}
%>				
					</td>
					<% } %>
					
					<td class="<%=classvalue%>"><center>&nbsp;<%=pat_charge_display_str.toString()%></center><br>
<% 
					if(order_type.equals("TD") && bean_1.getHmPPNValues() != null ){ 
						if(bean_1.getHmPPNValues().get("billingError")== null || bean_1.getHmPPNValues().get("billingError").equals("")){
%>
							<label style="color:green;font-size:9px" ><%=bean_1.getHmPPNValues().get("grossCost")%></label>
<%
						}
						else{
%>
							<label style="color:green;font-size:9px" title="<%=bean_1.getHmPPNValues().get("billingError")%>"><center><fmt:message key="Common.Error.label" bundle="${common_labels}"/></center></label>
<%
						}
					}
%>					
					</td>
					<td class="<%=classvalue%>"><center>&nbsp;<%=gross_charge_display_str.toString()%></center><br>
<% 
					if(order_type.equals("TD") && bean_1.getHmPPNValues() != null){ 
						if(bean_1.getHmPPNValues().get("billingError")== null || bean_1.getHmPPNValues().get("billingError").equals("")){					
%>
							<label style="color:green;font-size:9px" ><%=bean_1.getHmPPNValues().get("grossCost")%></label>
<%
						}
						else{
%>
							<label style="color:green;font-size:9px" title="<%=bean_1.getHmPPNValues().get("billingError")%>"><center><fmt:message key="Common.Error.label" bundle="${common_labels}"/></center></label>
<%
						}
					}
%>				
					</td>
					<td class="<%=classvalue%>"><center>&nbsp;<%=inc_exec_display_str.toString()%></center></td>
<% 
			}
			else{
               disp_delivery_chk_box_val =  "N";
%>
			     <td class="<%=classvalue%>"  align="center">&nbsp;
				 <br>
<% 
					if(order_type.equals("TD") && bean_1.getHmPPNValues() != null){ 
						if(bean_1.getHmPPNValues().get("billingError")== null || bean_1.getHmPPNValues().get("billingError").equals("")){

%>
							<label style="color:green;font-size:9px" ><%=bean_1.getHmPPNValues().get("grossCost")%></label>
<%
						}
						else{
%>
							<label style="color:green;font-size:9px" title="<%=bean_1.getHmPPNValues().get("billingError")%>"><center><fmt:message key="Common.Error.label" bundle="${common_labels}"/></center></label>
<%
						}
					}
%>				
				 </td>
			     <td class="<%=classvalue%>"  align="center">&nbsp;
				 <br>
<% 
					if(order_type.equals("TD") && bean_1.getHmPPNValues() != null){ 
						if(bean_1.getHmPPNValues().get("billingError")== null || bean_1.getHmPPNValues().get("billingError").equals("")){
%>
							<label style="color:green;font-size:9px" ><%=bean_1.getHmPPNValues().get("grossCost")%></label>
<%
						}
						else{
%>
							<label style="color:green;font-size:9px" title="<%=bean_1.getHmPPNValues().get("billingError")%>"><center><fmt:message key="Common.Error.label" bundle="${common_labels}"/></center></label>
<%
						}
					}
%>				
				 </td>
			     <td class="<%=classvalue%>" align="center">&nbsp;</td>
<%
			}
		}
		if(billing_interface_yn.equals("Y")&& ord_type.equals("TA")){

			StringBuffer gross_charge_display_str   = new StringBuffer();
			StringBuffer pat_charge_display_str     = new StringBuffer();
			StringBuffer gross_disply_str     = new StringBuffer();//added for ML-BRU-CRF-0469
			
			if(displayGrossAmtYn) {
			gross_disply_str.append("<label style='font-size:9px;color:black' id='gross_disply_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(tot_gross_amount).append("</label>");
			}
			gross_charge_display_str.append("<label style='font-size:9px;color:black' id='groos_pat_payable_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(tot_groos_pat_payable).append("</label>");

		   pat_charge_display_str.append("<label style='font-size:9px;color:black' id='gross_charge_amount_str_").append(order_id).append(order_line_no).append(strModDrugCode).append("'>").append(tot_gross_charge_amount).append("</label>");	
%>
          
             <%if(displayGrossAmtYn) { %>
            <td  class="<%=classvalue%>" align="center">&nbsp;<%=gross_disply_str.toString()%></td>
            <%} %>
          
		    <td  class="<%=classvalue%>"  align="center">&nbsp;<%=pat_charge_display_str.toString()%></td>
			<td class="<%=classvalue%>"  align="center">&nbsp;<%=gross_charge_display_str.toString()%></td>
			<td class="<%=classvalue%>" align="center">&nbsp;</td>
<% 
		   }

			if(base_to_def_uom_equl == 0 && base_to_disp_uom_equl == 0 && ord_type.equals("NOR") ){
				disp_delivery_chk_box_val = "N";
			}
			else if(!bAltQtyAvailable){
				disp_delivery_chk_box_val = "N";
			}
			if(iv_prep_yn.equals("") || iv_prep_yn.equals("1") || iv_prep_yn.equals("3") || iv_prep_yn.equals("5")  || iv_prep_yn.equals("9")){//adding start for Ml-MMOH-SCF-0880
			   if(((qty.equals("0") || qty.equals("0.0") || qty.equals(""))  && strAllocBMSChkValue=="N"))
				  disp_delivery_chk_box_val="N";
			}
			if(iv_prep_yn.equals("")){
			if(strIncludeZeroQtyForIP.equals("Y") && (qty.equals("0") || qty.equals("0.0") || qty.equals("")) )
                   disp_delivery_chk_box_val="Y";
			}
%>	
			<input type="hidden"  name="allocateyn_<%=recCount%>" id="allocateyn_<%=recCount%>" value="<%=disp_delivery_chk_box_val%>">

			<input type="hidden"  name="prescribed_strength_<%=recCount%>" id="prescribed_strength_<%=recCount%>" value="<%=pres_strength_1%>"> <!-- MMS-KH-CRF-0030-->
<%
			bms_strength="";
			strength_uom="";
			if(stock_opt.size()>0){
%>
			<input type="hidden" name="stock_availability_check<%=recCount%>" id="stock_availability_check<%=recCount%>" value="<%=stock_opt.get(0)%>">
<%
			}
			else{
%>
			<input type="hidden" name="stock_availability_check<%=recCount%>" id="stock_availability_check<%=recCount%>" value="">
<%	
			}
			if( (!qty.equals("")&&!qty.equals("0") && !qty.equals("0.0")) && (Float.parseFloat(bms_qty) == 0 || !complete_ord_yn )) { //  && Float.parseFloat(bms_qty) == 0 added forKAUH-SCF-0096 [IN:035355] // !complete_ord_yn added for ML-MMOH-SCF-0356.1 // && !qty.equals("0.0") Added for [IN:064158]
				disable_complete_order	=	"disabled"; 
			}
			else{
				disable_complete_order	=	""; 
			}
			if(stock_opt.size()!=0 && ((String)stock_opt.get(0)).equals("N")) {
				image		=	"<img src='../../eCommon/images/disabled.gif' align='center'>";
			}
			else {
				image		=	"";
			}

			String showZeroQtyCheckBox = "";
			String showOtherEditLables = "";
			System.out.println("disable_all "+disable_all);
			if(!disable_all.equals("disabled") && ((strAutoCompletePartialDisp.equals("Y") && Double.parseDouble(bms_qty)>0 && !qty.equals("")) || (strIncludeZeroQty.equals("Y") && (qty.equals("") || qty.equals("0")))) ){	// (qty ==null || qty.equals("0")) is changed to Double.parseDouble(bms_qty)>0 for JD-CRF-0179 [IN:41211] // Condition changed for [IN:045700]
				showZeroQtyCheckBox ="";
				showOtherEditLables ="display:none";
			}
			else{
				showZeroQtyCheckBox="display:none";
				showOtherEditLables ="";
			}
			if(strBMS_Include_yn.equals("Y") && (disable_all.equals("disabled") || bKeepQty) && !hold_text.equals("On Hold") ){ // && !hold_text.equals("On Hold") added for IN039007  //(qty ==null || qty.equals("0") || qty.equals("")) is changed to Double.parseDouble(bms_qty)>0 for JD-CRF-0179 [IN:41211]
				strAllocBMSChkValue  = "Y";
				strAllocBMSChecked	 = "checked";
				disable_complete_order ="disabled";
			}
			else{
				strAllocBMSChkValue  = "N";
				strAllocBMSChecked	 = "";
			}

		if((strAutoCompletePartialDisp.equals("Y") && Double.parseDouble(bms_qty) > 0 && !qty.equals("")) || (strIncludeZeroQty.equals("Y") && (qty.equals("") ||  qty.equals("0") ))  && !hold_text.equals("On Hold") ){   //if block added for Bru-HIMS-CRF-281 [IN:033166] // && !hold_text.equals("On Hold") added for IN039007   //(qty ==null || qty.equals("") || Float.parseFloat(qty)==0) is changed to Double.parseDouble(bms_qty)>0 for JD-CRF-0179 [IN:41211] 
			if(includeBMSDefCheck_yn.equals("Y") && strBMS_Include_yn.equals("Y")){ 
				strAllocBMSChkValue  = "Y";
				strAllocBMSChecked	 = "checked";
				disable_complete_order ="disabled";
			}
			
			showZeroQtyCheckBox	 = "";
			out.println("<input type ='hidden' name='allocBmsSecondStage_"+recCount+"' id='allocBmsSecondStage_"+recCount+"' value='Y'>");
			showOtherEditLables ="display:none";
		}
		else if(bKeepQty)
			out.println("<input type ='hidden' name='allocBmsSecondStage_"+recCount+"' id='allocBmsSecondStage_"+recCount+"' value='N'>");
		
		    if(!ord_type.equals("IVAA")&& !ord_type.equals("IVIA")&& !ord_type.equals("CA")&& !ord_type.equals("TA")&&!ord_type.equals("TD")&& !ord_type.equals("CO")){ //"&& !ord_type.equals("TD")" alone added for SRR20056-SCF-7289

%>
						<td class="<%=classvalue%>" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')">	 <!-- Remove image for SRR20056-SCF-6477 [IN025924]-->
<%
					
%>
						<div style="color:blue;font-size:9px;font-weight:bold;<%=showZeroQtyCheckBox%>" id="divIncludeZeroQty<%=recCount%>" >
							<input type ="checkbox" name ="alloc_bms_chk_<%=recCount%>" value="<%=strAllocBMSChkValue%>" onclick="assignValue(this);setEnableDsbleCOR(this,'<%=recCount%>');" <%=strAllocBMSChecked%> />
							<fmt:message key="ePH.INCLUDE_IN_BMS.label" bundle="${ph_labels}"/>
						</div>
<%
						
					   if(!disable_all.equals("disabled")){	
						   bEditLabelEnabled = true;						 
%>                    
						<div id="divOtherEditLables<%=recCount%>" style="<%=showOtherEditLables%>">
<%
						if(!order_type.equals("TD") && !order_type.equals("TA")){
%>	
							<label style="cursor:pointer;color:blue;font-size:9px;" id="edit_remarks<%=recCount%>" onClick="if(!<%=bPatientPaid%>){callEditDetails(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','D','edit_remarks<%=recCount%>','<%=patient_id%>','<%=ord_date_time%>','<%=performing_pract_id%>','<%=drug_code%>','<%=java.net.URLEncoder.encode(drug_name_1,"UTF-8")%>','<%=pres_qty%>','<%=uom%>','<%=disp_locn_catg%>');}" <%=disable_all%>><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></label>
<%
							}
%>

<%
						 if(!order_type.equals("TA")){
%>
							<br><b>	<label style="color:green;cursor:pointer;font-size:9px" id="alloc_detail<%=recCount%>" onClick="if(!<%=bPatientPaid%>){callAllocate('<%=patient_id%>','<%=order_id%>','<%=drug_code%>','<%=disp_stage%>');}" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')"><fmt:message key="Common.Detail.label" bundle="${common_labels}"/></label>
							</b>
<%	
							}
%>
						</div>
						<br>
						<label style="cursor:pointer;color:blue;font-size:9px;" id="fill_remarks<%=recCount%>" onClick="if(!<%=bPatientPaid%>){callFillingRemarks(this,'<%=order_id%>','<%=drug_code%>','<%=recCount%>','<%=order_line_no%>','F','fill_remarks<%=recCount%>');}" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" <%=disable_all%> >  <fmt:message key="Common.Findings.label" bundle="${common_labels}"/></label>
<%
                      }
					  else{
						  bEditLabelEnabled = false;
						  disable_complete_order ="disabled";
%>
						<div id="divOtherEditLables<%=recCount%>" style="<%=showOtherEditLables%>">
                          <%if(!order_type.equals("TD") && !order_type.equals("TA")){%>	
						<label style="color:black;font-size:9px;" id="edit_remarks<%=recCount%>" <%=disable_all%>><fmt:message key="ePH.EditLabel.label" bundle="${ph_labels}"/></label>
<%
						}
%>
						<br>
						<label style="font-size:9px" id="alloc_detail<%=recCount%>" <%=disable_all%>>&nbsp;<fmt:message key="Common.Detail.label" bundle="${common_labels}"/></label>
						</div>
						<br>
						<label style="color:black;font-size:9px;" id="fill_remarks<%=recCount%>"  <%=disable_all%> >  <fmt:message key="Common.Findings.label" bundle="${common_labels}"/></label>
<%
					}	
					if(multi_drugs.size()==0){
						if(bEditLabelEnabled){ 
							hmEditLabelValues = bean_1.getHMEditLabelValues(order_id,order_line_no,drug_code,ord_date_time, drug_name,drug_desc,pres_qty,uom);
							alEditLabelPair.add(hmEditLabelValues);
							bEditLabelEnabled = false;
							bean.setSPerformPractId(performing_pract_id);
						}
					}
%>	
					&nbsp;</td>
<%			
				}
				else{
				   if(ws_tot_qty != 0 ){
					   disable_complete_order	=	"disabled"; 
				   }
				   else{
						disable_complete_order	=	""; 
				   }
%>	    		
					<td class="<%=classvalue%>" >&nbsp;<%=image%></td>
<%
				}

			
			if((patient_class.equals("IP") && scope.equals("A") )){ 
				legend_text="";
			legend1=bean_1.getresultlinestatus(order_id,order_line_no);
			if(legend1==null)
				legend1="";
			if(legend1.equals("OS")){
                legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outstanding.label","common_labels");
			}
			else if(legend1.equals("DP")|| legend1.equals("DD")){
				legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PartiallyDispensed.label","ph_labels");
			}
			else if(legend1.equals("RG")){
			   	legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProcess.label","common_labels");
			}
			else if(legend1.equals("AL")){
				legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Alloocated.label","ph_labels");
			}
			    	visibility3="visibility:hidden";
				visibility2="visibility:visible";
				visibility1="visibility:hidden";

			if(hold_text.equals("On Hold")){
                disable_complete_order	=	"disabled"; 
                visibility3="visibility:visible";
                visibility2="visibility:hidden";
		    }			
			}  
			else if(scope.equals("H")){ 
				legend_text="";
			legend1=bean_1.getresultlinestatus(order_id,order_line_no);
			if(legend1==null)
				legend1="";
			if(legend1.equals("OS")){
                legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outstanding.label","common_labels");
			}
			else if(legend1.equals("DP")||legend1.equals("DD")){//legend1.equals("DD")ADDED FOR MMS-KH-CRF-0014
				legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PartiallyDispensed.label","ph_labels");
			}
			else if(legend1.equals("RG")){
			   	legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.InProcess.label","common_labels");
			}
			else if(legend1.equals("AL")){
				legend_text= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Alloocated.label","ph_labels");
			}
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
			<td class="<%=classvalue%>"  onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" ><label style="color:red;font-size:9px" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" id="result_line_status<%=recCount%>"style='<%=visibility1%>' >  <b><%=legend_text%></b>
			</label>   <input type='checkbox'   name="CompleteOrder<%=recCount%>" id="CompleteOrder<%=recCount%>"    value='<%=complete_order_value%>' onClick='setcompleteorder(this)' <%=disable_complete_order%> <%=complete_order_checked%> style='visibility:hidden'>
             <select name="ComplteOrderReason<%= recCount %>" id="ComplteOrderReason<%= recCount %>" style="<%= visibility2 %>" onchange="setCheckBoxValue(this, document.DispMedicationAllStages.CompleteOrder<%= recCount %>, document.getElementById('hold_remarks_<%= recCount %>'), <%= recCount %>)" <%= disable_complete_order %> <%= disable_alloc_text_box %>>
<%--              <select name="ComplteOrderReason<%=recCount%>" id="ComplteOrderReason<%=recCount%>" style='<%=visibility2%>' onchange='setCheckBoxValue(this,document.DispMedicationAllStages.CompleteOrder<%=recCount%>,document.getElementById("hold_remarks_<%=recCount%>)),<%=recCount%>)'  <%=disable_complete_order%> <%=disable_alloc_text_box%>>
 --%>					<option value="">-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
<%
				       for(int m=0; m<complete_reason_codes.size(); m=m+2){
%>
                        			<option value="<%=complete_reason_codes.get(m)%>"><%=complete_reason_codes.get(m+1)%></option>
<%
			   		}
%>
				</select>	
<%
				if(bean_1.getOrderType().equals("TD")){
%>
					<br>
					<label style ="cursor:pointer;color:blue ;font-size:9px" onclick = "displayConst(<%=recCount%>)"> <fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/></label></Td>
<%
				}
				else{
%> 
					</td>
<% 
				} 
				if(approval_flag){
				disabled = "";
				}
               if(approval_no_flag)
               {
						   if(approval_flag){
								approval_no= (String)approvalNo.get(order_id+order_line_no);
								 
						   }
						   if(approval_no==null) 
							   approval_no = "";
%>
                     <td class="<%=classvalue%>" nowrap>      
					 <input type="text"  maxlength="20" onchange="getApprovalNumForDrug(this,<%=recCount%>)"  name="approval_no_<%=recCount%>" <%=disabled%> value="<%=approval_no%>" onKeyPress="return KeyPressSpecCharsForApprovalNo(event)" onBlur="CheckForSpecCharApprovalno(this,'F',<%=recCount%>)"/><!--MODIFIED FOR AAKH-CRF-0117 -->
						
					 <%
						if(approval_no_app_for_patient_class!=null && approval_no_app_for_patient_class.equals("Y") && disabled.equals("")){ 
						approval_no_style = "visibility:visible";	 
					 }%>
						<img id="imgForWithin_<%=recCount%>" src="../../eCommon/images/mandatory.gif" align="center" style="<%=approval_no_style%>"></img><!-- AAKH-CRF-0117-->	
						 
					 
					 </td>
<%
               }

       if((patient_class.equals("IP") && scope.equals("A") )){ 
%>         <td class="<%=classvalue%>"  onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" ><label style="color:red;font-size:9px; border:1px" onMouseOver = "showToolTipsForChnFldRmks(this,'<%=strChangedFludRmks%>')" id="result_line_status<%=recCount%>"style='<%=visibility3%>' >  <b><%=legend_text%></b>
			</label> </td>
			<%} // added for ML-MMOH-CRF-0434 [IN057356] - End%>            
				<input type="hidden" name="release_flag<%=recCount%>" id="release_flag<%=recCount%>" value="N">         
				<input type="hidden"  name="order_line_num<%=recCount%>" id="order_line_num<%=recCount%>" value="<%=order_line_no%>">
				<input type="hidden"  name="order_id_<%=recCount%>" id="order_id_<%=recCount%>" value="<%=order_id%>"> <!--added for GHL-CRF-0453 -->
				<input type="hidden"  name="drug_code_<%=recCount%>" id="drug_code_<%=recCount%>" value="<%=drug_code%>"> <!--added for GHL-CRF-0453 -->
				<input type="hidden"  name="order_line_num_<%=recCount%>" id="order_line_num_<%=recCount%>" value="<%=order_line_no%>">
				<input type="hidden"  name="fillings<%=recCount%>" id="fillings<%=recCount%>" value="<%=order_line_no%>">
				<input type="hidden" name="base_to_disp_uom_equl_val<%=recCount%>" id="base_to_disp_uom_equl_val<%=recCount%>" value="<%=base_to_disp_uom_equl%>">
				<input type="hidden" name="base_to_def_uom_equl_val<%=recCount%>" id="base_to_def_uom_equl_val<%=recCount%>" value="<%=base_to_def_uom_equl%>">
				<input type="hidden" name="dischargeIND<%=recCount%>" id="dischargeIND<%=recCount%>" value="<%=dischargeIND%>">
				<input type="hidden" name="allow_decimals_yn<%=recCount%>" id="allow_decimals_yn<%=recCount%>" value="<%=st_allow_decimals_yn%>">  <!-- Added for AAKH-SCF-0113 [IN:048937] -->
				<input type="hidden"  name="finding_remarks_yn_<%=recCount%>" id="finding_remarks_yn_<%=recCount%>" value="N"> 				
<%
				if(disp_level.equals("P")) {	
%>
					<input type="hidden"  name="order_id<%=recCount%>" id="order_id<%=recCount%>" value="<%=order_id%>">
<%	
				}	
%>
				</tr>
<%
				if(multi_drugs!= null && multi_drugs.size()>0 && alt_drug_code!= null && !alt_drug_code.trim().equals("")){
					stDrugCodes.remove(drug_code);
					stDrugCodes.add(alt_drug_code);
				}
%>
<tr><td colspan="14">
<%
if(Disp_drug_verify_remarks.equals("Y") && site_remarks && drug_remarks !="" && drug_remarks !=null){ %>
    <label style="color:red;font-size: 9px;"><fmt:message key="ePH.DrugInstructions.label" bundle="${ph_labels}"/>&nbsp;&nbsp; :</label>
    <label style="font-size: 9px;" ><%=drug_remarks %></label> </br>
<%}
if(Disp_drug_verify_remarks.equals("Y") && site_remarks && verificationremarks !="" && verificationremarks !=null){ %>
   <label style="color:red;font-size: 9px;"><fmt:message key="ePH.VerificationRemarks.label" bundle="${ph_labels}"/>&nbsp;&nbsp; :</label>
   <label style="font-size: 9px;"><%=verificationremarks %></label> 
<%}	%>
</td></tr>
<%

				recCount++;
			}

			
				if(	first_time_yn.equals("Y") && fill_list.equals("AF")){
					bean_1.setHmDispTMPForDeleteSales(hmOrderDispDrugDetails);
				}
				if(billing_interface_yn.equals("Y")&&  admx_prep_charges_appl_yn.equals("Y")&&( ws_tot_qty != 0||!tpn_qty.equals(""))){
					String ItemForAdmixPrepCharges				=   "";
					String mark_up_down					    =	"1";
					String old_mark_up_down					=   "";
					if(ord_type.equals("IVAA")||ord_type.equals("IVIA")||ord_type.equals("CA")||ord_type.equals("TA")||ord_type.equals("CO")){
						String calc_groos_pat_payable_admx_prep_charge = "";
						String calc_gross_admx_prep_charge	=	"";	
						String calc_gross_amount_change    =""; 
						admixture_yn							=   "Y";
						StringBuffer gross_charge_display_str =   new StringBuffer();
						HashMap	AdmxPrepChargeDetails =(HashMap)bean_1.getAdmxPrepChargeDetails(disp_locn_code,worksheet_id,ord_type);
						if(AdmxPrepChargeDetails.size()>0){
							ItemForAdmixPrepCharges			=  (String) AdmxPrepChargeDetails.get("ADMX_PREP_CHARGE_ITEM_CODE");
							mark_up_down						=  (String)AdmxPrepChargeDetails.get("ADMX_PREP_CHARGE_UNITS");
							old_mark_up_down					=  mark_up_down;
						}
						else{
							//iv_prep_yn						=   bean.getIVFlag(order_id);
							ItemForAdmixPrepCharges			=   bean.getItemForAdmixPrepCharges(iv_prep_yn);
						}				  			
				
						HashMap charge_det=(HashMap)bean.callItemChargeDtls(patient_id,encounter_id,bl_patient_class,ItemForAdmixPrepCharges,1.0,"",sysdate,store_code,"","",order_id,"","",dischargeIND);
						if(charge_det.get("error_msg").equals("")){ 
							decimalFormatString					=(String)charge_det.get("BL_DECIMAL_FORMAT_STRING");
							DecimalFormat dfTest				=   new DecimalFormat(decimalFormatString);
					  
						
						if(charge_det.get("netchargeamt")!=null && !charge_det.get("netchargeamt").equals("null")){
							gross_admx_prep_charge=dfTest.format( Float.parseFloat((String)charge_det.get("netchargeamt")));
							calc_gross_admx_prep_charge=dfTest.format( Float.parseFloat(gross_admx_prep_charge)*Float.parseFloat(mark_up_down));
						}
						if(!charge_det.get("patnetamt").equals("null")){
							groos_pat_payable_admx_prep_charge  =dfTest.format( Float.parseFloat((String)charge_det.get("patnetamt"))); 
							calc_groos_pat_payable_admx_prep_charge=dfTest.format( Float.parseFloat(groos_pat_payable_admx_prep_charge)*Float.parseFloat(mark_up_down));
						} 
						
						if(!charge_det.get("grosschargeamt").equals("null")){
							gross_amount_change  =dfTest.format( Float.parseFloat((String)charge_det.get("grosschargeamt"))); 
							calc_gross_amount_change=dfTest.format( Float.parseFloat(gross_amount_change)*Float.parseFloat(mark_up_down));
						} 
						
	%>
						<tr>
						  <td class="data">&nbsp;</td> <td class="data">&nbsp;</td> 
						  <td class="data"><label style="cursor:pointer;color:blue" onclick="CallPreparationChargeDetails('<%=gross_admx_prep_charge%>',<%=groos_pat_payable_admx_prep_charge%>,mark_up_down,bl_decimal_format_str,'F',<%=gross_amount_change%>)" id="prep_charges"><fmt:message key="ePH.PreparationCharges.label" bundle="${ph_labels}"/>(<%=mark_up_down%>)</label></td>
						  <td class="data">&nbsp;</td> <td class="data">&nbsp;</td>
						  <td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td>
						  <td class="data" id="gross_admx_prep_charge_legend" align="center">&nbsp;<%=calc_gross_admx_prep_charge%></td>
						  <td class="data" id="groos_pat_payable_admx_prep_charge_legend"  align="center">&nbsp;<%=calc_groos_pat_payable_admx_prep_charge%></td>	 
						   <td class="data" id="gross_amount_change_legend"  align="center">&nbsp;<%=calc_gross_amount_change%></td> <!-- Added for ML-BRU-CRF-0469 [IN:065426] -->
						  <td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td>
						</tr>
<%	
					}
					else{
						gross_admx_prep_charge=(gross_charge_display_str.append("<label style='font-size:9px;color:red' title='").append(charge_det.get("error_msg")).append("'>").append(com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Error.label", "common_labels")).append("</label>")).toString();

						groos_pat_payable_admx_prep_charge=gross_admx_prep_charge;
						gross_amount_change=groos_pat_payable_admx_prep_charge;
%>
						<tr>
							<td class="data">&nbsp;</td> <td class="data">&nbsp;</td> 
							<td class="data"><label  id="prep_charges"><fmt:message key="ePH.PreparationCharges.label" bundle="${ph_labels}"/></label></td>
							<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>
							<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td>
							<td class="data" id="gross_admx_prep_charge_legend" align="center">&nbsp;<%=gross_admx_prep_charge%></td>
							<td class="data" id="groos_pat_payable_admx_prep_charge_legend" align="center">&nbsp;<%=groos_pat_payable_admx_prep_charge%></td>
							<td class="data" id="gross_amount_change_legend" align="center">&nbsp;<%=gross_amount_change%></td><!-- Added for ML-BRU-CRF-0469 [IN:065426] -->
							<td class="data">&nbsp;</td> <td class="data">&nbsp;</td>  <td class="data">&nbsp;</td>
						</tr>
<%	
							gross_admx_prep_charge="0";
							groos_pat_payable_admx_prep_charge="0";
							gross_amount_change="0";
						}	 
					}
%>
					<input type="hidden" name="gross_admx_prep_charge" id="gross_admx_prep_charge" value="<%=gross_admx_prep_charge%>">
					<input type="hidden" name="groos_pat_payable_admx_prep_charge" id="groos_pat_payable_admx_prep_charge" value="<%=groos_pat_payable_admx_prep_charge%>">
					<input type="hidden" name="gross_amount_change" id="gross_amount_change" value="<%=gross_amount_change%>"><!-- Added for ML-BRU-CRF-0469 [IN:065426] -->
					<input type="hidden" name="mark_up_down" id="mark_up_down" value="<%=mark_up_down%>">
					<input type="hidden" name="old_mark_up_down" id="old_mark_up_down" value="<%=old_mark_up_down%>">
					<input type="hidden" name="ItemForAdmixPrepCharges" id="ItemForAdmixPrepCharges"value="<%=ItemForAdmixPrepCharges%>">
					<input type="hidden" name="bl_decimal_format_str" id="bl_decimal_format_str" value="<%=decimalFormatString%>">
<%
				}
			if(disp_level.equals("P")) {
				for(int i=0;i<result.size();i=i+11) { 
					bean.setFirstTime(((String)result.get(i+1)).trim(),false);
				}
			}
			else {
				bean.setFirstTime(order_id,false);
			}
		
			bean.setDrugUom(uom);
			if(stDrugCodes.size()>0 && !(fill_list != null && fill_list.equals("AF"))){
				sDispDrugAuthYN = bean.getDispDrugAuthYN(stDrugCodes);
			}

			bean_1.setPatientPaid(bPatientPaid);
%>
		</table>
		
		<%
		String parvalues02=CommonRepository.getCommonKeyValue( "MODE_MODIFY" )+"~"+bean_1.getIssueByUOM()+"~"+bean_1.getSFunctionId()+"~"+bean_1.getValuesChanged()+"~"+bean_id_1+"~"+bean_name_1+"~"+bean_id+"~"+bean_name+"~"+pres_qty_alert+"~";
		String parvalues=disp_level+"~"+disp_locn_code+"~"+disp_locn_catg+"~"+ord_type+"~"+strIncludeZeroQty+"~"+bEquivalentNormalOrder+"~"+tpn_wrksheet_rcrd+"~"+fill_list+"~"+bPatientPaid+"~"+iv_prep_yn+"~"+strAutoCompletePartialDisp+"~"+st_no_of_decimals+"~"+st_disp_decimal_dtls_yn+"~"+allow_amend_alt_drug_dtl+"~"+patient_class+"~"+tpn_mf_label+"~"+displayGrossAmtYn+"~"+strIncludeZeroQtyForIP+"~"+intractn_req_yn+"~"+approval_no_flag+"~"+approval_no_app_for_patient_class+"~"+finding_remarks_app+"~";
		String parvalues01=order_id+"~"+disp_stage+"~"+patient_id+"~"+encounter_id+"~"+source_code+"~"+source_type+"~"+ordering_facility_id+"~"+ord_date_time+"~"+performing_pract_id+"~"+module_id+"~"+recCount+"~"+disp_stage+"~";
		%>
		<jsp:include page="../../ePH/jsp/DispMedicationFilling01.jsp" > 
			<jsp:param name="parvalues02" value="<%=parvalues02%>"/>
			<jsp:param name="parvalues" value="<%=parvalues%>"/>
			<jsp:param name="parvalues01" value="<%=parvalues01%>"/>
		</jsp:include>
<% 
		if(billing_interface_yn.equals("Y")){
%>
			<input type="hidden" name="bl_encounter_id" id="bl_encounter_id" value="<%=bl_encounter_id%>">
			<input type="hidden" name="bl_patient_class" id="bl_patient_class" value="<%=bl_patient_class%>">
			<input type="hidden" name="bl_sysdate" id="bl_sysdate" value="<%=sysdate%>">
		
			<% if(displayGrossAmtYn) { %>
			<input type="hidden" name="tot_gross_amount" id="tot_gross_amount" value="<%=tot_gross_amount%>">
			<% } %>
			
			<input type="hidden" name="tot_gross_charge_amount" id="tot_gross_charge_amount" value="<%=tot_gross_charge_amount%>">
			<input type="hidden" name="tot_groos_pat_payable" id="tot_groos_pat_payable" value="<%=tot_groos_pat_payable%>">
			<input type="hidden" name="admx_prep_charges_appl_yn" id="admx_prep_charges_appl_yn" value="<%=admx_prep_charges_appl_yn%>">
<%
		}
%>
	</form>
<%  
		if(!decimalFormatString.equals("")&&billing_interface_yn.equals("Y")&& bl_display.equals("Y")){
			DecimalFormat dfTest							=   new DecimalFormat(decimalFormatString);
			tot_gross_charge_amount_str					=   dfTest.format(tot_gross_charge_amount);
			tot_groos_pat_payable_str					=   dfTest.format(tot_groos_pat_payable); 
			tot_gross_amount_str					=   dfTest.format(tot_gross_amount);
			String ItemForAdmixPrepCharges				=   bean.getItemForAdmixPrepCharges(iv_prep_yn);

			HashMap charge_det=(HashMap)bean.callItemChargeDtls(patient_id,encounter_id,bl_patient_class,ItemForAdmixPrepCharges,1.0,"",sysdate,store_code,"","",order_id,"","",dischargeIND);
			if(charge_det.get("error_msg").equals("")){ 
				if(!charge_det.get("grosschargeamt").equals("null")){
					gross_admx_prep_charge= (String)charge_det.get("grosschargeamt");
				}
				if(!charge_det.get("patnetamt").equals("null")){
					groos_pat_payable_admx_prep_charge  = (String)charge_det.get("patnetamt");
				} 
				
				if(displayGrossAmtYn) {
					if(!charge_det.get("netchargeamt").equals("null")){
						gross_amount_change  = (String)charge_det.get("netchargeamt"); 
			     
					}
				}
			
		   }
		}
		if(item_uom_definition_flag){
%>
			<script>alert(getMessage("PH_ITEMS_UOM_DEF_NOT_FOUND","PH"));</script>
<%	}		bean.clearAlEditLabelPairValues();
		if(alEditLabelPair.size()==0){	
		hmEditLabelValues = bean_1.getHMEditLabelValues(order_id,order_line_no,drug_code,ord_date_time, drug_name,drug_desc,pres_qty,uom);
			alEditLabelPair.add(hmEditLabelValues);
		}
		bean.setAlEditLabelPairValues(alEditLabelPair);
		medplan_bean.setMedOrderIds(arrOrderId);
%>
	</body>
	<script>
		callLegendsFrame('<%=patient_id%>','F','','','<%=order_id%>','<%=billing_interface_yn%>','<%=tot_gross_charge_amount_str%>','<%=tot_groos_pat_payable_str%>','<%=admixture_yn%>','<%=sDispDrugAuthYN%>','<%=tot_gross_amount_str%>');
<%
		if(bPatientPaid){
%>
			disableFillOrAllocate();
<%
		}
		if(!display_list.equals("display:none")){ 
%>
			try{
				for(var i=1; i<<%=recCount%>;i++){
<% 
					if(!item_uom_definition_flag && !scope.equals("H")){
%>
						if(eval('document.DispMedicationAllStages.alloc_qty_'+i).value != ''){
						 	calculateIssueUOM(eval('document.DispMedicationAllStages.issue_uom_select_'+i),i,eval('document.DispMedicationAllStages.issueUOMValue_'+i).value,'NO',eval('document.DispMedicationAllStages.approval_no_'+i).value); // .value added for MMS-SCF-0040 [IN:041888]  and modified for AAKH-CRF-0117
							
						}
<%  
					}
%>
				}
			}
			catch(exp){	}
<%
		}
%>
	</script>
</html>
<%
		putObjectInBean(medplan_bean_id,medplan_bean,request);
		putObjectInBean(param_bean_id,param_bean,request);
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(bean_id_1,bean_1,request);
		putObjectInBean(bean_id_2,bean_2,request);
		putObjectInBean(bean_id_st,bean_st,request); 
	}
	catch(Exception e){
		e.printStackTrace();
	}
    finally{
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} 
%>

