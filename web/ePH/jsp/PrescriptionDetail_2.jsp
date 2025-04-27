<!DOCTYPE html>
<!--saved on 27th Oct 2005 -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>


<%-- Mandatory declarations start --%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

29/06/2020  	IN073176           Shazana                          					SKR-SCF-1337
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
29/11/2020  	IN:7980	        	Manickavasagam J                                    ML-BRU-SCF-2069
25/05/2023		IN:44863			Sushant Tambe										MMS-DM-CRF-0239
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
		<!-- <script language="JavaScript" src="../js/PhMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		 <script language="JavaScript" src="../../eCommon/js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../js/Prescription_1.js"></script>
		<script language="JavaScript" src="../js/Prescription_2.js"></script>
		<script language="JavaScript" src="../js/PrescriptionTest.js"></script>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eOR/js/OrderEntrySearch.js"></script>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
Connection con				= null;//added forml-bru-crf-0469
try{
	String facility_id		= (String) session.getValue("facility_id");
	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id"); 
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String in_mode			= request.getParameter("mode")==null?"":request.getParameter("mode");
	String srl_no			= request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
	String priority			= request.getParameter("priority")==null?"":request.getParameter("priority");
	String drug_db_interface_yn      =  request.getParameter("drug_db_interface_yn")==null?"":request.getParameter("drug_db_interface_yn");
	String priority_disp = "";
	String uom_disp = "";
	//String drug_db_dosage_check_yn      =  request.getParameter("drug_db_dosage_check_yn")==null?"":request.getParameter("drug_db_dosage_check_yn");
	//String drug_db_duptherapy_check_yn	= request.getParameter("drug_db_duptherapy_check_yn")==null?"":request.getParameter("drug_db_duptherapy_check_yn");
	//String drug_db_contraind_check_yn	= request.getParameter("drug_db_contraind_check_yn")==null?"":request.getParameter("drug_db_contraind_check_yn");
	//String drug_db_interact_check_yn	= request.getParameter("drug_db_interact_check_yn")==null?"":request.getParameter("drug_db_interact_check_yn");
	//String drug_db_allergy_check_yn= request.getParameter("drug_db_allergy_check_yn")==null?"":request.getParameter("drug_db_allergy_check_yn");

	if(priority!=null && priority.equals("R"))
		priority_disp	=	"Routine";
	else
		priority_disp	=	"urgent";
	if(priority.equalsIgnoreCase("Routine"))
		priority_disp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	else if(priority.equalsIgnoreCase("urgent"))
		priority_disp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");

	String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String mode						= CommonRepository.getCommonKeyValue( "MODE_MODIFY" );
	String bean_name				= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
	bean.setLanguageId(locale);
	String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );

	String or_bean_name				= "eOR.OrderEntryBean";
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request) ;
	orbean.setLanguageId(locale);
	//corrected for PE By Naveen
	//int take_home					=	bean.getHomeMecdicationYn(encounter_id,facility_id);
     int take_home					=	(int)bean.getTakeHomeCount();

	String order_id			= (String) orbean.getOrderId();
	String order_line_num="";
	String called_from		=	orbean.getCalledFromFunction();
	ArrayList drugData		= (ArrayList) bean.getpresDetails();
	String consider_stock_for_pres_yn	=	"";
	String allow_pres_without_stock_yn	=	"";

	String display			= "display:none";
	String drug_code		= "";
	String drug_desc		= "";
	String route_code		= "";
	String route_desc		= "";
	String freq_code		= "";
	String freq_desc		= "";
	String qty_value		= "";
	String dosage_type		= "";
	String durn_value		= "";
	String renew_durn_value = "";//ML-BRU-SCF-2069
	String durn_desc		= "";
	String split_dose		= "";
	String drug_start_date	= "";
	String drug_end_date	= "";
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
	String interval_value	=	"";
	String patient_class	= "";
	String order_type_code	= "";
	String form_code		= "";
	String repeat_durn_type	= "";
	String qty_desc_dis		= "";
	String qty_desc_code	= "";
	String min_daily_dose	= "";
	String min_unit_dose	= "";
	String dup_start_date	= "";
	String dup_end_date		= "";
	String strength_field	=	"";
	String pres_remarks		=	"";
	String srlNo			=	"";
	String  override_yn		=	"N";
	String  generic_id		=	"";
	String calc_by_ind		=	"";
	String dosage_std		=	"";
	String dosage_unit		=	"";
	String recomm_yn		=	"";
	String split_dose_yn	=	"N";
	String pres_base_uom="";
	String ext_prod_id="";
	String fract_dose_round_up_yn = "";
	String strength_per_pres_uom = "";
	String strength_per_value_pres_uom = "";
	String trade_code= "";
	String trade_name = "";
	String	in_formulary_yn	= "";
	String	item_code	= "";
	int dose_decimal = 6;

	ArrayList admin_time	=	new ArrayList();
	ArrayList admin_qty		=	new ArrayList();
	//ArrayList stock_params	=	new ArrayList(2);
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
	String dup_drug_desc	=	"";
	String dosage_option	=	"";
	String remarks_style	=	"visibility:hidden";
	String order_qty_status	=	"disabled";
	String DrugRemarksEntered			=	""; //Added for Antibiotic Screen using Order Entry Format ICN 29904

	String	dsg_reason		= "";
	String	dup_reason		= "";
	String con_reason = "";
	String int_reason = "";
	String	alg_reason			= "";

	String bl_install_yn = request.getParameter("bl_install_yn")==null?"":request.getParameter("bl_install_yn");
	String bl_disp_charge_dtl_in_rx_yn = request.getParameter("bl_disp_charge_dtl_in_rx_yn")==null?"":request.getParameter("bl_disp_charge_dtl_in_rx_yn");

	String bl_incl_excl_override_reason_code ="";
	String bl_incl_excl_override_reason_desc = "";
	String bl_def_override_excl_incl_ind = "";
	String bl_override_excl_incl_ind = "";
	String bl_override_allowed_yn = "";
	String trade_display_yn = "", billable_item_yn="", fract_dose_appl_yn="", interaction_exists="", intr_restric_trn="", intr_msg_content="",  interaction_override="", interaction_remarks="", buildMAR_yn="", buildMAR_checked="";
	String abuse_exists	=	"", abuse_restric_trn="N", abuse_msg_content="", abuse_override ="" ;//added for AAKH-CRF-140
	String abuse_drug_override_reason="",abuse_action="";//added for AAKH-CRF-140

	String MAR_app_yn    = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	trade_display_yn = request.getParameter("trade_display_yn")==null?"N":request.getParameter("trade_display_yn");
	String validate_overide_on_confirm_yn="N";//Added for IN:069887  
	String diagnosis_found_yn="";//Added for MMS-DM-CRF-0239
	 con						= ConnectionManager.getConnection(request);//added for ml-bru-crf-0469
	boolean displayGrossAmtYn = CommonBean.isSiteSpecific(con, "PH", "GROSS_AMT_DISPLY_YN"); //ADDED for ML-BRU-CRF-0469
	boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
	boolean validate_overide_on_confirm =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","VALIDATE_OVERIDE_ON_CONFIRM");//Added for IN:069887 		
	boolean all_durn_type_app = eCommon.Common.CommonBean.isSiteSpecific(con, "PH", "ALL_DURN_TYPE_APP"); //added for ML-MMOH-CRF-1531
	boolean req_diag_pres_found=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REQ_DIAG_PRES_FOUND");
	
	if(called_from.equals("RENEW_ORDER")) {
		mode						= CommonRepository.getCommonKeyValue( "MODE_INSERT" );
		strength_field	=	"disabled";	
	}
	//Added for IN:069887 start
		if(validate_overide_on_confirm){
			validate_overide_on_confirm_yn="Y";
		}
		//Added for IN:069887  end
	HashMap drugDetails	=	null;
	if(in_mode!=null && in_mode.equals("amend")){
		if(drugData.size()>0){
			for(int i=0;i<drugData.size();i++){
				drugDetails =(HashMap)drugData.get(i);
				srlNo				= (String) drugDetails.get("SRL_NO");
				if(srlNo.equals(srl_no)){
					drug_code			= (String) drugDetails.get("DRUG_CODE");
					ext_prod_id		=	(String) drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String) drugDetails.get("EXTERNAL_PRODUCT_ID");
					drug_desc			= (String) drugDetails.get("CATALOG_DESC");		
					form_desc			= (String) drugDetails.get("FORM_DESC");	
					generic_id			= (String) drugDetails.get("GENERIC_ID");	
					route_desc			= (String) drugDetails.get("ROUTE_DESC");	
					freq_code			= (String) drugDetails.get("FREQ_CODE");	
					freq_desc			= (String) drugDetails.get("FREQ_DESC");		
					qty_value			= (String) drugDetails.get("QTY_VALUE");		
					
					qty_desc_dis		= (String) drugDetails.get("QTY_DESC");	
					qty_desc_code		= (String) drugDetails.get("QTY_DESC_CODE");	
					durn_value			= (String) drugDetails.get("DURN_VALUE");		
					durn_desc			= (String) drugDetails.get("DURN_DESC");	
					drug_start_date		= (String) drugDetails.get("START_DATE_TIME");
					drug_end_date		= (String) drugDetails.get("END_DATE_TIME");
					if(called_from.equals("RENEW_ORDER")) {
						order_id		= (String) drugDetails.get("ORDER_ID");
						order_line_num	= (String) drugDetails.get("ORDER_LINE_NUM");
					}
					//if(!locale.equals("en")){
					//	drug_start_date		= DateUtils.convertDate(drug_start_date, "DMYHM","en",locale);
					//	drug_end_date		= DateUtils.convertDate(drug_end_date, "DMYHM","en",locale);
					//}
					
					no_refill			= (String) drugDetails.get("NUM_OF_REFILLS");
					if(no_refill ==null || no_refill.equals("0")){
						no_refill="";
					}
					strength_value		= (String) drugDetails.get("STRENGTH");
					strength_uom		= (String) drugDetails.get("STRENGTHUOM");
					prescribed_mode		= (String) drugDetails.get("PRESCRIBED_MODE");
					split_dose			= (String) drugDetails.get("SPLIT_DOSE_PREVIEW");
					split_dose_yn		= (String) drugDetails.get("SPLIT_DOSE_YN");
					durn_type			= (String) drugDetails.get("DURN_TYPE");
					repeat_value		= (String) drugDetails.get("REPEAT_VALUE");
					interval_value		= (String)drugDetails.get("INTERVAL_VALUE");
					durn_type			= (String) drugDetails.get("DURN_TYPE");
					patient_class       = (String) drugDetails.get("PATIENT_CLASS");
					order_type_code		= (String) drugDetails.get("ORDER_TYPE_CODE");
					form_code			= (String) drugDetails.get("FORM_CODE");
					route_code			= (String) drugDetails.get("ROUTE_CODE");
					repeat_durn_type	= (String) drugDetails.get("REPEAT_DURN_TYPE");	
					pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
					fract_dose_round_up_yn =  (String)drugDetails.get("FRACT_DOSE_ROUND_UP_YN");
					
					scheduled_yn		= (String) drugDetails.get("SCHEDULED_YN");
					stock_uom			= (String)drugDetails.get("STOCK_UOM_DESC");
					absol_qty			= (String)drugDetails.get("ORDER_QTY");
					dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
					freq_nature			= (String)drugDetails.get("FREQ_NATURE");
					recomm_yn			= ((String)drugDetails.get("RECOMM_YN"));
					calc_by_ind			= (String)drugDetails.get("CALC_BY_IND");
					dosage_std			= (String)drugDetails.get("DOSAGE_STD");
					dosage_unit			= (String)drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
					trade_code			= (String)drugDetails.get("TRADE_CODE")==null?"":(String)drugDetails.get("TRADE_CODE");
					trade_name			= (String)drugDetails.get("TRADE_NAME")==null?"":(String)drugDetails.get("TRADE_NAME");
					in_formulary_yn		= (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
					item_code		= (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");
					DrugRemarksEntered		= (String)drugDetails.get("DrugRemarksEntered")==null?"":(String)drugDetails.get("DrugRemarksEntered"); //Added for Antibiotic Screen using Order Entry Format ICN 29904
					
					if(req_diag_pres_found){
						diagnosis_found_yn= (String) drugDetails.get("DIAGNOSIS_FOUND_YN");//Added for MMS-DM-CRF-0239	
					}
					else{
						diagnosis_found_yn="G";//Added for MMS-DM-CRF-0239
					}
					
							
					billable_item_yn  =  (String)drugDetails.get("BILLABLE_ITEM_YN")==null?"Y": (String)drugDetails.get("BILLABLE_ITEM_YN"); 
					fract_dose_appl_yn = (String) drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String) drugDetails.get("FRACT_DOSE_APPL_YN");
					interaction_exists = (String)drugDetails.get("INTERACTION_EXISTS")==null?"":(String)drugDetails.get("INTERACTION_EXISTS");
					//added for AAKH-CRF-140 start
					abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"":(String)drugDetails.get("ABUSE_EXISTS");
					abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"":(String)drugDetails.get("ABUSE_ACTION");
					abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"":(String)drugDetails.get("ABUSE_OVERRIDE");
					abuse_drug_override_reason=(String)drugDetails.get("abuse_drug_override_reason")==null?"":(String)drugDetails.get("abuse_drug_override_reason");
					System.out.print("abuse_override prescriptiondetails_2"+abuse_override);
					System.out.print("abuse_drug_override_reason   prescriptiondetails_2"+abuse_drug_override_reason);
					//added for AAKH-CRF-140 end
					intr_restric_trn = (String)drugDetails.get("INTR_RESTRIC_TRN")==null?"":(String)drugDetails.get("INTR_RESTRIC_TRN");
					intr_msg_content = (String)drugDetails.get("INTR_MSG_CONTENT")==null?"":(String)drugDetails.get("INTR_MSG_CONTENT");
					interaction_override = (String)drugDetails.get("INTERACTION_OVERRIDE")==null?"":(String)drugDetails.get("INTERACTION_OVERRIDE");
					if(drugDetails.get("INTERACTION_REMARKS") !=null && !((String)drugDetails.get("INTERACTION_REMARKS")).equals("")){
						interaction_exists="Y";
						interaction_remarks=(String)drugDetails.get("INTERACTION_REMARKS");
					}
					buildMAR_yn	= (String) (drugDetails.get("BUILDMAR_YN") == null?"N":drugDetails.get("BUILDMAR_YN"));
					if(buildMAR_yn.equals("Y") && MAR_app_yn.equals("Y"))
						buildMAR_checked ="Checked";

					if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
						bl_override_allowed_yn =(String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"": (String) drugDetails.get("BL_OVERRIDE_ALLOWED_YN"); 
						bl_incl_excl_override_reason_code =(String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_CODE"); 
						bl_incl_excl_override_reason_desc = (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC")==null?"": (String) drugDetails.get("BL_INCL_EXCL_OVERRIDE_REASON_DESC");
						bl_def_override_excl_incl_ind = (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_DEF_OVERRIDE_EXCL_INCL_IND");  
						bl_override_excl_incl_ind = (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND")==null?"": (String) drugDetails.get("BL_OVERRIDE_EXCL_INCL_IND");    
						if(bl_override_excl_incl_ind.equals(""))
							bl_override_excl_incl_ind = bl_def_override_excl_incl_ind;
					}
					consider_stock_for_pres_yn	=	(String)drugDetails.get("CONSIDER_STOCK_FOR_PRES_YN");
			        allow_pres_without_stock_yn	=	(String)drugDetails.get("ALLOW_PRES_WITHOUT_STOCK_YN");
					//stock_params		=	bean.validateForStock(patient_class);
					if(freq_nature.equals("P")){
						order_qty_status	=	"";
					}
					if(strength_value==null || strength_value.equals("0")||strength_value.trim().length()==0) {//Added for Bru-HIMS-CRF-400
						strength_value = "0";
						strength_value = Float.parseFloat(strength_value) +"" ;
						strength_uom		=	"";
					}
					if(drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON") !=null && !((String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON")).equals("")){
						limit_ind="N";
						dsg_reason=(String)drugDetails.get("DOSAGE_LIMIT_OVERRIDE_REASON");				
					}
					if(drugDetails.get("ALLERGY_OVERRIDE_REASON") !=null && !((String)drugDetails.get("ALLERGY_OVERRIDE_REASON")).equals("")){
						allergy_yn="Y";
						alg_reason=(String)drugDetails.get("ALLERGY_OVERRIDE_REASON");
					}
					if(drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON") !=null && !((String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON")).equals("")){
						current_rx="Y";
						dup_reason = (String)drugDetails.get("DUPLICATE_DRUG_OVERRIDE_REASON");
					}
					strength_per_pres_uom			=  (String)drugDetails.get("STRENGTH_PER_PRES_UOM");            
					strength_per_value_pres_uom =  (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
					con_reason					 =   (String)drugDetails.get("CONTRAIND_OVERRIDE_REASON")==null?"": (String)drugDetails.get("CONTRAIND_OVERRIDE_REASON");
					int_reason					 =   (String)drugDetails.get("INTERACTION_OVERRIDE_REASON")==null?"": (String)drugDetails.get("INTERACTION_OVERRIDE_REASON");
					if(scheduled_yn!=null && scheduled_yn.equals("Y") && !called_from.equals("RENEW_ORDER")){
						durn_val_dis="disabled";
						qty_val_dis="disabled";			
					}
					else{
						durn_val_dis="";
						qty_val_dis="";			
					}
					disp_locn_code = (String) drugDetails.get("DISP_LOCN_CODE");
					disp_locn_desc = (String) drugDetails.get("DISP_LOCN_DESC");
					if(prescribed_mode!=null && prescribed_mode.equals("A")){
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Absolute.label","common_labels");
					}
					else if(prescribed_mode!=null && prescribed_mode.equals("Q")){
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Dose.label", "ph_labels");
					}
					else{
						qty_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels");				
					}
					if(split_dose!=null && !split_dose.equals("")&& split_dose_yn.equals("Y")){
						qty_legend="Divided Dose";
						StringTokenizer	 vals	=	new StringTokenizer(split_dose,"|");
						adtime = adtime +"<table border=1 cellpadding=0 cellspacing=0 align=center>";
						while(vals.hasMoreTokens()) {
							String code		= (String)vals.nextToken();
							code=code+"=";
							StringTokenizer	 inner_vals	=	new StringTokenizer(code,"=");
							int j=0;
							while(inner_vals.hasMoreTokens()) {
								if(j%2==0){
									String time		= (String)inner_vals.nextToken();
									admin_time.add(time);
									if(!time.trim().equals("")){
										adtime = adtime + "<tr>";
										String att=" class=TIPS";
										adtime = adtime +"<td "+att+">&nbsp;"+time+"&nbsp;</td>";
										//adtime+="</tr>";
									}
								}
								else{
									String qty		= (String)inner_vals.nextToken();
									if(admin_qty.size()!=0 && !admin_qty.contains(qty)) {
										split_chk	=	true;
									}
									admin_qty.add(qty);
									if(!qty.equals("")){
										//adtime+="<td>";
										String att=" class=TIPS";
										adtime = adtime + "<td "+att+">&nbsp;"+qty+"&nbsp;</td>";
										adtime = adtime + "</tr>";
									}
								}
								j++;				
							 }
						}
						adtime =adtime +"</TABLE>";
					}
					break;
				}
			}
		}
	}
	/*	if(current_rx.equals("Y") || allergy_yn.equals("Y") || limit_ind.equals("N")){
			display="";
			override_yn="Y";
		}*/
		if(drug_db_interface_yn.equals("Y")){
			display="display:none";
			override_yn="N";
		}
		else{
			if(current_rx.equals("Y") || allergy_yn.equals("Y") || limit_ind.equals("N") || (abuse_exists.equals("Y")&&abuse_action.equals("B"))){//modified for AAKH-CRF-140
				display="display:inline";
				override_yn="Y";
			}
		}
		// Current Rx 
		/*ArrayList	active_orders		=	bean.getPatientActiveOrders(patient_id,patient_class,"",take_home);
		StringBuffer drug_description	=	new StringBuffer();
		int size						=	active_orders.size();
		HashMap	record					=	new HashMap();
		for(int i=0; i<size; i++)	{
			record					=	(HashMap)active_orders.get(i);
			drug_description.append((String)record.get("drug_desc"));
			drug_description.append(" , ");
		}*/

		if(drugDetails!=null && drugDetails.get("AMENDED_YN")==null) {

// added for ML-BRU-SCF-2069 - start
			renew_durn_value = durn_value;
			if(durn_type.equals("W"))
				renew_durn_value = (Integer.parseInt(durn_value)*7)+"";
			else if(durn_type.equals("L"))
				renew_durn_value = (Integer.parseInt(durn_value)*30)+"";
			else if(durn_type.equals("Y"))
				renew_durn_value = (Integer.parseInt(durn_value)*365)+"";
// added for ML-BRU-SCF-2069 - end
			ArrayList renew_dates	=	(bean.getRenewDates(renew_durn_value,order_id,drug_code));//changed durn_value to renew_durn_value for ML-BRU-SCF-2069
			if(renew_dates.size()==2) {
				drug_start_date	=	(String)renew_dates.get(0);
				drug_end_date	=	(String)renew_dates.get(1);
			}
		}
		if(!locale.equals("en")){
			drug_start_date		= DateUtils.convertDate(drug_start_date, "DMYHM","en",locale);
			drug_end_date		= DateUtils.convertDate(drug_end_date, "DMYHM","en",locale);
		}
		if(called_from.equals("RENEW_ORDER")) {
			//bean.setOldOrder(drug_code,order_id+","+presBean.getLineNo(order_id,drug_code));
			bean.setOldOrder(drug_code , order_id+","+order_line_num);
		}
		if(admin_qty.size()!=0 && split_chk) {
			qty_legend	=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.SplitDose.label", "ph_labels");
		}
		else if(admin_qty.size()!=0 && !split_chk) {
			qty_legend	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.ScheduledDose.label", "ph_labels");
		}
		// Drug Remarks - Start
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
		if(!pres_remarks.equals(""))
			remarks_style	="visibility:visible";
		// Drug Remarks - End
		//Start Duplicate- Dates
		ArrayList duplicate_dates	=	presBean.getDuplicateDates(patient_id,drug_code,DateUtils.convertDate(drug_start_date, "DMYHM",locale,"en"));
		if(duplicate_dates.size()==2) {
			dup_start_date	=	(String)duplicate_dates.get(0);
			dup_end_date	=	(String)duplicate_dates.get(1);
		}
		// End Duplicate Dates

		if(presBean.duplicateRecord(dup_start_date,dup_end_date,drug_start_date,DateUtils.convertDate(drug_end_date, "DMYHM",locale,"en"))) {
			dup_drug_desc		=	drug_desc;
		 }
		if(!locale.equals("en")){
			dup_start_date		= DateUtils.convertDate(dup_start_date, "DMYHM","en",locale);
			dup_end_date		= DateUtils.convertDate(dup_end_date, "DMYHM","en",locale);
		}
		// Legend and dosage unit is controlled based on dosage type
		if(dosage_type.equals("A")){
			dosage_option	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Absolute.label", "common_labels");
		}
		else if(dosage_type.equals("S")){
			dosage_option	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Strength.label", "common_labels");
		}
		else if(dosage_type.equals("Q")){
			dosage_option	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Quantity.label", "common_labels");
		}
		// stock flags 
		//commented during PE By Naveen added in drug details
		/*if(stock_params.size()==2) {
			consider_stock_for_pres_yn	=	(String)stock_params.get(0);
			allow_pres_without_stock_yn	=	(String)stock_params.get(1);
		}*/
		if(priority.equalsIgnoreCase("Routine") || priority.equalsIgnoreCase("R"))
			priority_disp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
		else //if(priority.equalsIgnoreCase("urgent"))
			priority_disp=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
%>
		<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
			<form name="prescription_amend_detail_form" id="prescription_amend_detail_form" >
			<!-- Below table for CurrentRx details-->
				<table border="0" width="100%" cellspacing="0" cellpadding="0">
					<input type="hidden" value="<%=bean_id%>" name="bean_id">
					<input type="hidden" value="<%=bean_name%>" name="bean_name">
					<input type="hidden" value="<%=presBean_id%>" name="presBean_id">
					<input type="hidden" value="<%=presBean_name %>" name="presBean_name">
					<tr>
						<td  width="15%">
						<input type="button" class="button" value='<fmt:message key="ePH.CurrentRx.label" bundle="${ph_labels}"/>' onClick="javascript:callActiveOrders('<%=patient_id%>','<%=encounter_id%>','','<%=patient_class%>');"></td>
						<td class="CURRTEXT"  width="70%">
						&nbsp;
						</td>
						<td class="label"   width="15%"><input type='button' class='button' onClick="showDrugProfile('<%=patient_id%>')" value='<fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/>'></td>
				</tr>
			</table>
			<!--CurrentRx table ends-->
			<br>
			<!-- Prescription Writer Table starts-->
			<table cellpadding=0 cellspacing=0 width="100%"  border="0">
				<td class='COLUMNHEADER' colspan="6" style="font-size:9"  ><fmt:message key="ePH.DrugDetail.label" bundle="${ph_labels}"/></td>
				<tr>
					<td class="label"   width="25%"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
					<td class="label"   width="40%" colspan="3"><input type="text" name="drug_name" id="drug_name" value="<%=drug_desc%>" disabled size="50"></td>
					<td class="label"   width="5%"><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
					<td class="label"  width="30%"><input type="text" name="priority_disp" id="priority_disp" value="<%=priority_disp%>" size="10" disabled>
						<input type="text" name="priority" id="priority" value="<%=priority%>" size="10" disabled>
					</td>
				</tr>
				<tr>
					<td class="label"   width="25%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
					<%
						uom_disp = bean.getUomDisplay((String)session.getValue("facility_id"),strength_uom);
						if(uom_disp == null || uom_disp.equals("null"))
							uom_disp = "";
					 	//added for NMC-JD-CRF-0026  
						if(strength_display_app){
							if(strength_value!=null && strength_value!="" && !strength_value.equals("0.0")){
					%>
					
					<td class="label"   width="18%"><input type="text" name="strength_value" id="strength_value" value="<%=strength_value%>" disabled size="7" class="NUMBER">&nbsp;<%=uom_disp%> / <%=strength_per_value_pres_uom%>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),pres_base_uom)%></td>
					<%}else%>
						<td class="label"   width="18%"><input type="hidden" name="strength_value" id="strength_value" value="<%=strength_value%>" </td>
						<%} else{ %>
						<td class="label"   width="18%"><input type="text" name="strength_value" id="strength_value" value="<%=strength_value%>" disabled size="7" class="NUMBER">&nbsp;<%=uom_disp%></td>
					<%}%>
					<td class="label"  width="22%" colspan="2"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/>&nbsp;&nbsp;<input type="text" name="form_desc" id="form_desc" value="<%=form_desc%>" disabled size="10"></td>
					<td class="label"   width="5%"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
					<td class="data" id="strength" width="30%"><input type="text" name="route_desc" id="route_desc" value="<%=route_desc%>" disabled size="10"></td>
				</tr>
				<tr>
<%				if(trade_display_yn.equals("Y")){
%>
					<td class="label"   width="25%"><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></td>
					<td class="label"   width="18%"><input type="text" name="trade_name" id="trade_name" value="<%=trade_name%>" disabled size="7" class="NUMBER">
<%				}
				else
					trade_code="";
%>
					<input type='hidden' name='trade_code' id='trade_code' value='<%=trade_code%>'></td></td>
					<td class="label" colspan=4>
						<fmt:message key="ePH.BuildMAR.label" bundle="${ph_labels}"/>&nbsp;
						<input type='checkbox' name='buildMAR_yn' id='buildMAR_yn' value='<%=buildMAR_yn%>' <%=buildMAR_checked%> disabled></td>
					</td>
				</tr>
				<tr>
					<td class="label" ><img src="../../eOR/images/Authorization.gif" id="requires_auth_gif"  style="visibility:hidden" onclick="chkAuthorization('auth')"></img></td>
					<td class="label"  id="auth_yn" nowrap>&nbsp;</td>
					<td class="label"><img src="../../eOR/images/SpecialApproval.gif" id="spl_approval_gif"  style="visibility:hidden" onclick="chkAuthorization('approve')"></img></td>
					<td class="label"  id="spl_approval">&nbsp;</td>
					<td class="label" ><img src="../../eOR/images/Cosign_click.gif" id="cosign_gif"  style="visibility:hidden" onclick="chkAuthorization('cosign')"></img></td>
					<td class="label"  id="cosign">&nbsp;</td>
				</tr>
				<td class='COLUMNHEADER' colspan="6" style="font-size:9" ><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></td>
				<tr>
						<td class="label" ><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/></td>
						<td  class="label"><input type="text" name="dosage" id="dosage" value="<%=dosage_option%>" disabled size="10">
						</td>
<%	
						if(split_dose_yn!=null && split_dose_yn.equals("Y")) {	
%>
							<td class="label"  id="dosage_label" colspan="2">&nbsp;<font color='red' onmouseover="displayamendToolTipDataChange('<%=adtime%>');" onmouseout="disasbleamendToolTipDataChange();"><%=qty_legend%></td>
<%	
						}
						else{	
%>
						<td class="label"  id="dosage_label" colspan="2">&nbsp;<%=qty_legend%></td>
<%
						}	
						if(qty_value != null && qty_value != "" && Float.parseFloat(qty_value) < 1.0)
							qty_value = Float.parseFloat(qty_value)+"";
%>
						<td class="label"  ><input type="text" name="qty_value" id="qty_value" size="3" maxlength="13" class="NUMBER"  value="<%=qty_value%>" <%=durn_val_dis%> onKeyPress="return allowValidNumber(this,event,8,6);" onblur="validateamendDosageLimit('true');" <%=strength_field%>></td>
						<td ><input type="text" name="qty_desc_dis" id="qty_desc_dis" size="10" value="<%=qty_desc_dis%>" disabled><input type="hidden" name="qty_desc" id="qty_desc" value="<%=qty_desc_dis%>" >
						<input type='hidden' name='qty_desc' id='qty_desc' value='<%=qty_desc_code%>'>
						</td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
					<td class="label" ><input type="text" name="freq_desc" id="freq_desc" size="20" value="<%=freq_desc%>" disabled>
					</td>
					<td  colspan="2" class="label">&nbsp;&nbsp;</td>
	<!--				<td class="label" id="recomm_dose">&nbsp;&nbsp;</td>
					<td class="data" align="left">&nbsp;&nbsp;</td>
					!-->
<%
						if(split_dose_yn.equals("N")){
%>
							<td colspan="3"><label  id="rec_legend" style="font-size:11;font-weight:bold;color:red; visibility:hidden" title="Recommended Dosage" ><fmt:message key="ePH.Recom.Dose.label" bundle="${ph_labels}"/> </label>
							<label id="rec_value" style="font-size:11;font-weight:bold;color:red"></label>
							&nbsp;<label id="rec_uom" style="font-size:11;font-weight:bold;color:red"></label></td>
<%
						}
						else{
%>
							<td colspan="3"><label  id="rec_legend" style="font-size:11;font-weight:bold;color:red;visibility:hidden" ><fmt:message key="ePH.Recom.Dose.label" bundle="${ph_labels}"/> </label>
							<label id="rec_value" style="font-size:11;font-weight:bold;color:red"></label>
							&nbsp;<label id="rec_uom" style="font-size:11;font-weight:bold;color:red"></label></td>
<%
						}
%>

				</tr>
				<td class='COLUMNHEADER' colspan="6" style="font-size:9" ><fmt:message key="ePH.DurationDetail.label" bundle="${ph_labels}"/></td>
				<tr>
<% 
					String durn_change = "";
					if(freq_nature.equals("O")){
						durn_change = "ReadOnly Disabled";
					}
%>
				<td class="label"  ><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
				<td class="label" ><input type="text" size="1" maxlength="3" name="durn_value" id="durn_value" class="NUMBER"  value="<%=durn_value%>"  <%=qty_val_dis%> onBlur="putDecimal(this,2,0);CheckPositiveNumber(this); maxDurnValidation('Y');extDosageCheck('Modify');getChargeDetails('<%=in_formulary_yn%>');" onKeyPress="return(ChkNumberInput(this,event,'0'))" <%= durn_change%> >&nbsp;<%=durn_desc%></td>
				<input type="hidden" name="tmp_durn_value" id="tmp_durn_value" value="<%=durn_value%>">
				<input type="hidden" name="tmp_durn_desc" id="tmp_durn_desc"  value="<%=durn_type%>">					
				<input type="hidden" name="durn_desc" id="durn_desc" value="<%=durn_type%>">
				<td class="label"  colspan="2"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/></td>
				<td  class="data" colspan='2'><input class='NUMBER' type="text" size="3" maxlength="3" name="absol_qty" id="absol_qty" value="<%=absol_qty%>" <%=order_qty_status%>  onBlur="ValidateAbs(this);CheckPositiveNumber(this);getChargeDetails('<%=in_formulary_yn%>','ABS_QTY')" onKeyPress="return(ChkNumberInput(this,event,'0'))"> &nbsp;<%=stock_uom%></td>
			</tr>
			<tr>
				<td class="label" ><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></td>
				<td class="label"  ><input type="text" name="start_date" id="start_date" size="12"  maxlength="12" value="<%=drug_start_date%>" disabled></td>
				<td class="label"  colspan="2" nowrap><fmt:message key="Common.enddate.label" bundle="${common_labels}"/>&nbsp;&nbsp;<input type="text" name="end_date" id="end_date" size="13"  maxlength="13" value="<%=drug_end_date%>" disabled></td>
				<td class="label" colspan="2"  style="" ><input type="button" class="button" value='<fmt:message key="ePH.OverrideReason.label" bundle="${ph_labels}"/>' style="<%=display%>" id="dosage_limit" onclick="showAmendOverRideRemarks(prescription_amend_detail_form)" >
				</td>
			</tr>
			<tr>
<%
			//if(!(PhLicenceRights.getKey()).equals("PHBASIC") ) { 
%>
				<td class="label"  ><fmt:message key="ePH.DispenseLocation.label"  bundle="${ph_labels}"/></td>
				<td class="label"  ><input type="text" size="20" maxlength="20" name="disp_locn_desc" id="disp_locn_desc" disabled value="<%=disp_locn_desc%>">&nbsp;<input type="hidden" name="disp_locn_code" id="disp_locn_code" value="<%=disp_locn_code%>"></td>
<%
		/*	} 
			else {*/
%>
				<!-- <td class="label" >&nbsp;</td>
				<td class="label" ><input type="hidden" name="disp_locn_code" id="disp_locn_code" value=""></td> -->
<%
			//}
%>
				<td class="label"  colspan="2">&nbsp;</td>
				<td class="label"  colspan="2"><a href="javascript:showOrderRemarks('<%=order_id%>','<%=patient_id%>','<%=encounter_id%>','<%=drug_code%>');" id="drug_remarks" style="<%=remarks_style%>" title='<fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></a>
				<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 Start-->
				<img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'>
				<input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
				<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
				<!-- //Added for Antibiotic Screen using Order Entry Format ICN 29904 End-->
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
						<tr id='BL_HEADERBAR' style='display:none;'>
								<%//added forml-bru-crf-0469
								if(displayGrossAmtYn){ %>
						<td class='COLUMNHEADER' colspan="7" style="font-size:9" ><fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>	
						<%}else{ %>
						<td class='COLUMNHEADER' colspan="6" style="font-size:9" ><fmt:message key="Common.ChargeDetails.label" bundle="${common_labels}"/>	
						<%   }	 %>
						</tr>
						<tr id='BL_HEADER' style='display:none;'>
							<td class="label" width='9%'><fmt:message key="Common.Included.label" bundle="${common_labels}"/>
							</td>
							<td class="label" width='9%' id='bl_override_excl_incl_ind_lbl'><fmt:message key="Common.Exclude.label" bundle="${common_labels}"/>?
							</td>
							<td  class="label" width='40%'><fmt:message key="Common.reason.label" bundle="${common_labels}"/>
							</td>
							<%//added forml-bru-crf-0469	
							if(displayGrossAmtYn){ %>
						<td class="label" nowrap width='10%' style='TEXT-ALIGN:center;'><fmt:message key="ePH.GrossAmount.label" bundle="${ph_labels}"/>
						</td>
						<%}%>
							<td class="label" width='14%' style='TEXT-ALIGN:right;'><fmt:message key="ePH.TotalChargeAmount.label" bundle="${ph_labels}"/>
							</td>
							<td class="label" width='14%'style='TEXT-ALIGN:right;'><fmt:message key="ePH.TotalPayableAmount.label" bundle="${ph_labels}"/>
							</td>
							<td class="label" width='9%'><fmt:message key="ePH.ApprovalReqd.label" bundle="${ph_labels}"/>
							</td>
						</tr>
						<tr id='BL_VALUES' style='display:none;'>
							<td align='center' id='bl_def_override_excl_incl_ind_gif'>&nbsp;
							</td>
							<td class="label" id='td_bl_override_excl_incl_ind'>
<%
								String include_selected ="";  
								String exclude_selected =""; 	
								String Select_selected ="";
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
								if(bl_override_allowed_yn.equals("")){
%>
									<option value="SEL"selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
								}
%>
								</select>
								<input type='hidden' name='bl_def_override_excl_incl_ind' id='bl_def_override_excl_incl_ind' value='<%=bl_def_override_excl_incl_ind%>'>
								<input type='hidden' name='bl_override_allowed_yn' id='bl_override_allowed_yn' value='<%=bl_override_allowed_yn%>'>
							</td>
							<td class="label" >
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
							<%//added forml-bru-crf-0469
								if(displayGrossAmtYn){ %>
						<td class="data" id='gross_charge_amt' align='center'>
						</td>
					<%	} else{ %>
					   <td class="data"  id='gross_charge_amt' align='center' style='display:none;'>
						</td>
						<%} %>
							<td class="data" id='bl_total_charge_amt' align='center'>
							</td>
							<td class="data" id='bl_patient_payable_amt' align='center'>
							</td>
							<td align='center'id='bl_approval_reqd_yn'>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</table>
			<label id="tool_tip" style="visibility:hidden"></label>
			<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
				<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
					<tr><td width="100%" id="t"></td></tr>
				</table>
			</div>
			<input type="hidden" name="route_desc" id="route_desc" value="<%=route_desc%>">
			<input type="hidden" name="item_code" id="item_code" value="<%=item_code%>">
			<input type="hidden" name="drug_desc" id="drug_desc" value="<%=drug_desc%>">
			<input type="hidden" value="" name="generic_id" id="generic_id" value="<%=generic_id%>">
			<input type="hidden" value="" name="generic_name" id="generic_name">
			<input type="hidden" value="<%=allergy_yn%>" name="allergy_yn">
			<input type="hidden" value="<%=current_rx%>" name="current_rx">
			<input type="hidden" name="split_dose_yn" id="split_dose_yn" value="<%=split_dose_yn%>">
			<input type="hidden" name="fract_dose_round_up_yn" id="fract_dose_round_up_yn" value="<%=fract_dose_round_up_yn%>">
			<input type="hidden" name="strength_per_pres_uom" id="strength_per_pres_uom" value="<%=strength_per_pres_uom%>">
			<input type="hidden" name="strength_per_value_pres_uom" id="strength_per_value_pres_uom" value="<%=strength_per_value_pres_uom%>">
			<input type="hidden" value="<%=min_unit_dose%>" name="min_unit_dose">
			<input type="hidden" value="<%=min_daily_dose%>" name="min_daily_dose">
			<input type="hidden" value="<%=patient_id%>" name="patient_id">
			<input type="hidden" value="<%=encounter_id%>" name="encounter_id">
			<input type="hidden" value="<%=drug_code%>" name="drug_code">
			<input type="hidden" value="<%=repeat_value%>" name="repeat_value">
			<input type="hidden" value="<%=interval_value%>" name="interval_value">
			<input type="hidden" value="<%=durn_type%>" name="durn_type">
			<input type="hidden" value="<%=prescribed_mode%>" name="prescribed_mode">
			<input type="hidden" value="<%=mode%>" name="mode">
			<input type="hidden" value="<%=limit_ind%>" name="limit_ind">
			<input type="hidden" value="" name="daily_dose" id="daily_dose">
			<input type="hidden" value="" name="unit_dose" id="unit_dose">
			<input type="hidden" value="" name="mono_graph" id="mono_graph">
			<input type="hidden" value="<%=srl_no%>" name="srl_no">
			<input type="hidden" value="<%=patient_class%>" name="patient_class">
			<input type="hidden" value="<%=order_type_code%>" name="order_type_code">
			<input type="hidden" value="<%=form_code%>" name="form_code">
			<input type="hidden" value="<%=route_code%>" name="route_code">
			<input type="hidden" value="<%=repeat_durn_type%>" name="repeat_durn_type">
			<input type="hidden" value="<%=override_yn%>" name="override_yn">
			<input type="hidden" value="<%=alg_reason%>" name="alg_reason">
			<input type="hidden" value="<%=dsg_reason%>" name="dsg_reason">
			<input type="hidden" value="<%=dup_reason%>" name="dup_reason">
			<input type="hidden" value="<%=called_from%>" name="called_from">
			<input type="hidden" value="<%=dup_start_date%>" name="dup_start_date">
			<input type="hidden" value="<%=dup_end_date%>" name="dup_end_date">
			<input type="hidden" value="<%=dup_drug_desc%>" name="dup_drug_desc">
			<input type="hidden" name="dosage_type" id="dosage_type" value="<%=dosage_type%>">
			<input type="hidden" name="consider_stock_for_pres_yn" id="consider_stock_for_pres_yn" value="<%=consider_stock_for_pres_yn%>">
			<input type="hidden" name="allow_pres_without_stock_yn" id="allow_pres_without_stock_yn" value="<%=allow_pres_without_stock_yn%>">
			<input type="hidden" name="calc_by_ind" id="calc_by_ind" value="<%=calc_by_ind%>">
			<input type="hidden" name="dosage_std" id="dosage_std" value="<%=dosage_std%>">
			<input type="hidden" name="dosage_unit" id="dosage_unit" value="<%=dosage_unit%>">		
			<input type="hidden" name="recomm_yn" id="recomm_yn" value="<%=recomm_yn%>">
			<input type="hidden" value="<%=pres_base_uom%>" name="pres_base_uom">
			<input type="hidden" value="<%=split_chk%>" name="split_chk">
			<input type="hidden" value="<%=freq_nature%>" name="freq_nature">
			<input type="hidden" value="<%=ext_prod_id%>" name="ext_prod_id">
			<input type="hidden" name="con_reason" id="con_reason" value="<%=con_reason%>">
			<input type="hidden" name="int_reason" id="int_reason" value="<%=int_reason%>">
			<input type="hidden" value="" name="dsg_reason_yn" id="dsg_reason_yn">
			<input type="hidden" value="<%=in_formulary_yn%>" name="in_formulary_yn">
			<input type="hidden" value="<%=fract_dose_appl_yn%>" name="fract_dose_appl_yn">
			<input type="hidden" value="" name="taper_disabled" id="taper_disabled">
			<input type="hidden" value="<%=interaction_exists%>" name="interaction_exists">
			<!-- added for aakh-crf-0140 start-->
			<input type="hidden" value="<%=abuse_override%>" name="abuse_override">
			<input type="hidden" value="<%=abuse_drug_override_reason%>" name="abuse_drug_override_reason">
			<input type="hidden" value="<%=abuse_drug_override_reason%>" name="abuse_override_remarks">
			
			<input type="hidden" value="<%=abuse_action%>" name="abuse_action">
			<input type="hidden" value="<%=abuse_exists%>" name="abuse_exists">
			<!-- added for aakh-crf-0140 end-->
			
			<input type="hidden" value="<%=intr_restric_trn%>" name="intr_restric_trn">
			<input type="hidden" value="<%=intr_msg_content%>" name="intr_msg_content">
			<input type="hidden" value="<%=interaction_override%>" name="interaction_override">
			<input type="hidden" value="<%=interaction_remarks%>" name="interaction_remarks">
			<input type="hidden" value="disabled" name="freq_status" id="freq_status"><!-- added for ML-BRU-SCF-0725 [IN:038336] -->
			<input type="hidden" value = "<%=billable_item_yn%>" name = "billable_item_yn"> 
			<input type="hidden" value="<%=diagnosis_found_yn%>" name="diagnosis_found_yn"><!-- Added for MMS-DM-CRF-0239 -->
			<input type="hidden" value = "<%=presBean.getUOMDesc(dosage_unit)%>" name = "dosage_unit_uom"> <!-- added for SKR-SCF-1337 -->  
			<input type="hidden" value="<%=all_durn_type_app%>" name="all_durn_type_app" > <!-- ML-MMOH-CRF-1531-->
			<input type="hidden" value="" name="def_durn_type" id="def_durn_type" ><!-- ML-MMOH-CRF-1531-->
			 <input type="hidden" value="<%=validate_overide_on_confirm_yn%>" name="validate_overide_on_confirm_yn"><!-- Added for IN:069887  -->
		</form>
	</body>
<!-- setting schedule values-->
<%
	if(in_mode!=null && in_mode.equals("amend")){
		Hashtable sch_output	=	null;//Removed new HashTable for BRU-HIMS-crf-400
	 	ArrayList schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
		String sch_bean_id		= "OrScheduleFreq" ;
		String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
		Hashtable schedule_val	=	null; 
		if(schedule.size()==0 && scheduled_yn.equals("Y") ) {
			schedule_val	=	new Hashtable();
			ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request );
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
			//bean.setScheduleFrequencyStr(sch_output);
			putObjectInBean(sch_bean_id,schedule_bean,request);
		} 
		/*sch_output.put("code",drug_code+srl_no);
		sch_output.put("row_value",srl_no);
		sch_output.put("start_time_assign","");
		sch_output.put("day_value","7");
		sch_output.put("durationType","D");
		sch_output.put("daySM7","7");
		sch_output.put("daySM6","6");
		sch_output.put("daySM5","5");
		sch_output.put("daySM4","4");
		sch_output.put("daySM3","3");
		sch_output.put("daySM2","2");
		sch_output.put("daySM1","1");
		sch_output.put("error","");
		sch_output.put("repeat",repeat_value);
		sch_output.put("dayDisplay7","Sat");
		sch_output.put("dayDisplay6","Fri"); 
		sch_output.put("dayDisplay5","Thu"); 
		sch_output.put("displayHrs6","6");
		sch_output.put("dayDisplay4","Wed");
		sch_output.put("displayHrs5","5"); 
		sch_output.put("dayDisplay3","Tue"); 
		sch_output.put("displayHrs4","4"); 
		sch_output.put("dayDisplay2","Mon"); 
		sch_output.put("displayHrs3","3"); 
		sch_output.put("dayDisplay1","Sun"); 
		sch_output.put("displayHrs2","2"); 
		sch_output.put("displayHrs1","1");
		sch_output.put("start_day_assign","");	*/		

		if(sch_output!=null) {
			ArrayList values	=	presBean.getFreqDet(order_id,line_no);
			ArrayList freqCharctValues = new ArrayList();
			ArrayList day_list = new ArrayList();
			ArrayList day_names = new ArrayList();
			ArrayList time_list = new ArrayList();
			ArrayList dose_list = new ArrayList();
			ArrayList<String> week_days	= new ArrayList<String>();
			ArrayList tmp_freq_values					= new ArrayList();
			String temp="";
			week_days = bean.getDayOfWeek(com.ehis.util.DateUtils.convertDate(drug_start_date, "DMYHM",locale, "en")); 
			freqCharctValues = (ArrayList)sch_output.get(drug_code+srl_no);	
			for(int p=0; p<values.size(); p+=4) {
				time_list.add(values.get(p));
				dose_list.add(values.get(p+1));
				day_list.add((values.get(p+3)==null)?"0":values.get(p+3));
			}
			if(day_list.size()>0 && ((String)((HashMap)((ArrayList)sch_output.get(drug_code+srl_no)).get(0)).get("durationType")).equals("W")){
				for(int j=0;j<day_list.size();j++){
					if(!day_list.get(j).equals("")){
						temp = (String)day_list.get(j);
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
			bean.setScheduleFrequencyStr(sch_output);
			schedule		= (ArrayList)bean.getScheduleFrequencyStr(drug_code+srl_no,"0");
		}
		/*int incr=0;
		for(int p=0; p<values.size(); p+=3) {
			incr++;
			sch_output.put("time"+(incr),values.get(p));
			sch_output.put("qty"+(incr),values.get(p+1));				
		}
		if(incr<=6) {
			for(int q=(incr+1); q<=6; q++) {
				sch_output.put("time"+(q),"0");
				sch_output.put("qty"+(q),"0");
			}
		}
		bean.setScheduleFrequencyStr(tmp_freq_values);*/
		if(bean.checkSplit(schedule)) {
			drugDetails.put("SPLIT_DOSE_YN","Y");
		} 
		else {
			drugDetails.put("SPLIT_DOSE_YN","N");
		}
	}
%>
<script>
<%  //Added for MMS-DM-CRF-0239 start
	if(req_diag_pres_found && diagnosis_found_yn.equals("N")){
%>	showDiagnosisAlert();
<%	}//Added for MMS-DM-CRF-0239 end

	if(!in_mode.equals("blank")){
%>
		getFormatIdAmend()
		checkWtAndHt(document.prescription_amend_detail_form);
<%	
		if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
%>
			getChargeDetails('<%=in_formulary_yn%>');
<%
		}
	}
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,orbean,request);
	putObjectInBean(presBean_id,presBean,request);
}
catch(Exception e){
	e.printStackTrace();
}
finally{//added forml-bru-crf-0469
	

	if(con != null)
		ConnectionManager.returnConnection(con,request);

}
%>
</script>
</html>

