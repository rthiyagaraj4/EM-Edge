<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
25/06/2020      IN:072715                  Haribabu            25/06/2020     Manickavasagam J     MMS-DM-CRF-0165
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
--------------------------------------------------------------------------------------------------------------
*/ 
%>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*,java.sql.*,webbeans.eCommon.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<!-- <%@include file="../../eCommon/jsp/Common.jsp" %> -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/DrugNameCommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IVPrescriptionWithAdditives.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>

<%
Connection con			= null;    //added for GHL-CRF-0549
	try{
		con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
   	  	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
   	 boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
   	//Added for IN:069887 start
	boolean validate_overide_on_confirm =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","VALIDATE_OVERIDE_ON_CONFIRM");//added for MO-CRF-20152
	boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
	
	String validate_overide_on_confirm_yn="N";
	if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}			
//Added for IN:069887 end

	String params			= request.getQueryString() ;
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String classValue		= request.getParameter("classValue");
	//added for ml-mmoh-crf-0863 start
	String iv_prep_yn		= request.getParameter("iv_prep_yn");
	String take_home_medication	= request.getParameter("take_home_medication");
	String priority		= request.getParameter("priority");
	String order_status="";
	//added for ml-mmoh-crf-0863 end
	
	if(classValue == null) classValue="";

	String mode				= request.getParameter("mode");
		if(mode == null) mode = "";

	String amendDisa		= "";
	   if(mode.equals("amend")) amendDisa = "disabled";

	String start_date		= request.getParameter("start_date");
	    if(start_date == null) start_date="";

	String serialNum		= request.getParameter("serialNum") == null ? "":request.getParameter("serialNum");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
	String facility_id		= (String)session.getValue("facility_id");

	String param_bean_id				= "@DrugInterfaceControlBean";
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name,request);

	bean.setPatientClass(patient_class);
	bean.setEncId(encounter_id);
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name				= "eOR.OrderEntryBean";
	OrderEntryBean ORbean			= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request);

	String disp_bean_id			= "DispMedicationBean";
	String disp_bean_name		= "ePH.DispMedicationBean";
	DispMedicationBean disp_bean	= (DispMedicationBean)getBeanObject(disp_bean_id, disp_bean_name,request);
//added for ML-MMOH-CRF-0863 STSRT

	     String pre_bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
		String pre_bean_name				= "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pre_bean			= (PrescriptionBean_1)getBeanObject( pre_bean_id, pre_bean_name, request );
		String called_amend_from=pre_bean.getCalledFromAmend();
		
		//added for ML-MMOH-CRF-0863  END

	String resp_id					= (String)ORbean.getResponsibilityId();
	String pract_id					= (String)ORbean.getPractitionerId();
	String pract_name				= (String)ORbean.getPractitionerName();
	String locn_type				= (String)ORbean.getLocationType();
	String locn_code				= (String)ORbean.getLocationCode();
	String order_id					= (String)ORbean.getOrderId();	
	bean.setOrderStatus("");//adde for ml-mmoh-crf-0863
	order_status=bean.getOrderStatusUsingOrderId(order_id);//adde for ml-mmoh-crf-0863
	bean.setOrderStatus(order_status);//added for ml-mmoh-crf-0863
	String license					=	bean.getLicense();
	//added for ml-mmoh-crf-0863 start
	bean.setDisp_locn_code("");//added for ml-mmoh-crf-0863
	 ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(locn_type,locn_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id); // Added empty parameter for Bru-HIMS-CRF-347 [IN:037862] -- Begin ,added patient_id,encounter_id for MMS-QH-CRF-0048 [IN:037704]
	String disp_locn_code	= "";
	if(ord_disp_location != null & ord_disp_location.size()>0){ 
		disp_locn_code		=	(String)ord_disp_location.get(0) ==null?"":(String)ord_disp_location.get(0);	
		bean.setDisp_locn_code(disp_locn_code);
	}
     String auth_amend_pres_yn="";
	auth_amend_pres_yn = bean.getAuthAmendPres(disp_locn_code);
	//added for ml-mmoh-crf-0863 end
	 String make_disabled			=	"";
	String readOnly					=	"";
	String current_rx				=	"";
//	String	allow_duplicate						=	bean.checkDuplicateYN();
	String perform_external_database_checks_yn	=	"";	
	String external_dosage_override_reason		=   "";	
	String external_duplicate_override_reason	=   "";
	String external_interaction_override_reason	=   "";
	String external_contra_override_reason		=   ""; 
	String external_alergy_override_reason		=   ""; 
	String fract_dose_round_up_yn				=   "";
	String drug_db_dosage_check_flag			=   "Y";
	String DrugRemarksEntered			=	""; //added for [IN:039576]
	bean.setExcludeADRAllergyAlert(CommonBean.checkForNull(request.getParameter("excludeADRAllergyAlert_yn")));		
%>

	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
		<FORM name="formIVPrescriptionDrugDetails" id="formIVPrescriptionDrugDetails">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="patient_id" id="patient_id" VALUE="<%= patient_id %>">
			<INPUT TYPE="hidden" name="encounter_id" id="encounter_id" VALUE="<%= encounter_id %>">
			<INPUT TYPE="hidden" name="start_date" id="start_date" VALUE="<%= start_date %>">
			<INPUT TYPE="hidden" name="patient_class" id="patient_class" VALUE="<%= patient_class %>">
			<INPUT TYPE="hidden" name="drug_codes" id="drug_codes" VALUE="<%= bean.getDrugCodes() %>">
			<INPUT TYPE="hidden" name="resp_id" id="resp_id" VALUE="<%= resp_id %>">
			<INPUT TYPE="hidden" name="pract_id" id="pract_id" VALUE="<%= pract_id %>">
			<INPUT TYPE="hidden" name="pract_name" id="pract_name" VALUE="<%= pract_name %>">
			<INPUT TYPE="hidden" name="locn_type" id="locn_type" VALUE="<%= locn_type %>">
			<INPUT TYPE="hidden" name="locn_code" id="locn_code" VALUE="<%= locn_code %>">
			<input type="hidden" name="INFUSION_VALUE" id="INFUSION_VALUE" value="">
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
<%
			if (serialNum.equals("")) {
%>
				<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
					<TR> 
						<TD WIDTH="17%" CLASS="label"><fmt:message key="ePH.Additive.label" bundle="${ph_labels}"/>&nbsp;</TD>
						<TD WIDTH="83%" colspan='3'><INPUT TYPE="text" name="DRUG_NAME" id="DRUG_NAME" VALUE="" SIZE="45" MAXLENGTH="40" onBlur="checkValidDrug('D', this.value)" <%=amendDisa%> ><INPUT TYPE="button" CLASS="button" name="DRUG_SEARCH" id="DRUG_SEARCH" VALUE="?" onClick="searchIVDrugs('D', DRUG_NAME)" <%=amendDisa%>>
						<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="" id="edlImg">
<%
						if (iv_option.equals("Y")) {
%>
							<IMG ID="mandate_drug" SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
<%
						}
%>
						</TD>
					</TR>
					<TR>  
						<TD CLASS="label"><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/> </TD>
						<TD  ><SELECT DISABLED name="DOSAGE" id="DOSAGE">
							<OPTION VALUE=""><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></OPTION>
							<OPTION VALUE=""><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>
							</SELECT>
						</TD>
						<TD  CLASS="label"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></TD>
						<TD  >
							<INPUT TYPE="text" name="STRENGTH_VALUE" id="STRENGTH_VALUE" VALUE="" CLASS="number" DISABLED SIZE="3" MAXLENGTH="6"><SELECT DISABLED name="STRENGTH_UOM" id="STRENGTH_UOM">
								<OPTION VALUE="">&nbsp;&nbsp;--- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> ---&nbsp;&nbsp;</OPTION>
							</SELECT>
						</TD>
					</TR>
				</TABLE>
<%
			}
			else {

				String disabled	= "";
				int srlNo		= 0;
				srlNo			= Integer.parseInt(serialNum);
				/* Commented for SRR20056-SCF-7354
				String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
				String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
				String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
				String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);
				*/
				//Added for SRR20056-SCF-7354
				String drug_db_dosecheck_yn			= "N";
				String drug_db_duptherapy_yn		= "N";
				String drug_db_interact_check_yn	= "N";
				String drug_db_contraind_check_yn	= "N";
				String[] sDrugDBAllChecks = param_bean.drugDBALLChecksYN(facility_id);
				if(sDrugDBAllChecks != null && sDrugDBAllChecks.length>5){
					drug_db_dosecheck_yn			=	sDrugDBAllChecks[2];    
					drug_db_duptherapy_yn		=	sDrugDBAllChecks[3];    
					drug_db_interact_check_yn	=	sDrugDBAllChecks[4];      
					drug_db_contraind_check_yn	=	sDrugDBAllChecks[5];    
				}
				//SRR20056-SCF-7354

				ArrayList exstngIVOrders    = new ArrayList();	
				HashMap exstngDrgDtls 	    = new HashMap();				
				exstngIVOrders              = bean.getAllExistingIVOrders();
				ArrayList drugList			= bean.getDrugDetails();
				HashMap drugDetails			= (HashMap)drugList.get(srlNo-1);
				String generic_id			= (String)drugDetails.get("GENERIC_ID");
				String drug_desc			= (String)drugDetails.get("DRUG_DESC");
				String drug_code			= (String)drugDetails.get("DRUG_CODE");
				String min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE");
				String min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE");
				String dosage_unit			= (String)drugDetails.get("DOSAGE_UNIT");
				String generic_name			= (String)drugDetails.get("GENERIC_NAME");
				String daily_dose			= (String)drugDetails.get("DAILY_DOSE");
				//Added for IN:070451 start
				String      max_daily_ceeling_dose	    =   (String)drugDetails.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
				String		min_daily_ceeling_dose	    =   (String)drugDetails.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
				String		max_unit_ceeling_dose	    =   (String)drugDetails.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
				String		min_unit_ceeling_dose	    =   (String)drugDetails.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
				String		calc_by_ind	    =   (String)drugDetails.get("CALC_BY_IND")==null?"":(String)drugDetails.get("CALC_BY_IND");
				//Added for IN:070451 end
				//Added for IN:072715 start
			        String allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
				String dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
				String currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
				//Added for IN:072715 end
				String unit_dose			= (String)drugDetails.get("UNIT_DOSE");
				String mono_graph			= (String)drugDetails.get("MONO_GRAPH");
				String dosage_std			= (String)drugDetails.get("DOSAGE_STD");
				String limit_ind			= (String)drugDetails.get("LIMIT_IND");
				String recomm_yn			= (String)drugDetails.get("RECOMM_YN")==null?"":(String)drugDetails.get("RECOMM_YN");
				String recomm_dosage_by		= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
				String allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
				current_rx					=  bean.checkForNull((String)drugDetails.get("CURRENT_RX"),"N");
				String srl_no				= (String)drugDetails.get("SRL_NO");
				String strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
				String act_strength_value=(String)drugDetails.get("ACT_STRENGTH_VALUE");//ADDED FOR NMC-JD-CRF-0026
				String strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
				String strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
				String form_code			= (String)drugDetails.get("FORM_CODE");
				String pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
				String pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
				String freq_code			= (String)drugDetails.get("FREQ_CODE");
				String durn_value			= (String)drugDetails.get("DURN_VALUE");
				String durn_type			= (String)drugDetails.get("DURN_TYPE");
				String or_durn_desc			= (String)drugDetails.get("OR_DURN_DESC");
				String auth_yn_val			= (String)drugDetails.get("AUTH_YN_VAL");
				String approval_yn_val		= (String)drugDetails.get("APPROVAL_YN_VAL");
				String cosign_yn_val		= (String)drugDetails.get("COSIGN_YN_VAL");
				String auth_yn				= (String)drugDetails.get("AUTH_YN");
				String approval_yn			= (String)drugDetails.get("APPROVAL_YN");
				String cosign_yn			= (String)drugDetails.get("COSIGN_YN");
				String consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
				String order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
				String route_code			= (String)drugDetails.get("ROUTE_CODE");
				String end_date				= (String)drugDetails.get("END_DATE");
				String dup_drug_desc		= (String)drugDetails.get("CURRENTRX_REMARKS");
				String allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS");
				String exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS")==null?"":(String)drugDetails.get("DOSE_REMARKS");
				String dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
				String bms_qty				= (String)drugDetails.get("BMS_QTY");
				String dflt_qty_uom			= (String)drugDetails.get("DFLT_QTY_UOM");
				String tab_qty_value		= (String)drugDetails.get("TAB_QTY_VALUE");
				String qty_desc_code		= (String)drugDetails.get("QTY_DESC_CODE");
				String order_uom			= (String)drugDetails.get("ORDER_UOM");
				String amend_yn				= (String)drugDetails.get("AMEND_YN");
				String qty_value			= (String)drugDetails.get("QTY_VALUE");
				String qty_unit			    = (String)drugDetails.get("QTY_UNIT");
				String calc_dose_based_on	= (String)drugDetails.get("CALC_DOSE_BASED_ON");
				String calc_dose_by		    = "";
				String calc_dose_value	    = "";
				String displaydose			= "";
				String displayBSA			= "style='display:none'";
				String kg_selected			= "Selected";
				String m2_selected			= "";
				String select_calc_dose_Dosage="checked";
				String select_calc_dose_WT_BSA="";
				String disable_calc_dose	="";
				String allow_alternate_yn ="N"; //GHL-CRF-0549
				String allow_alternate_disabled	= "";//GHL-CRF-0549
				String allow_alternate_checked = "";//GHL-CRF-0549
				String allow_alternate		   = "N";//GHL-CRF-0549
				String abuse_exists="N";
				String abuse_action="U";
				String abuse_restric_trn="N";
				String abuse_override="";
				String abuse_override_remarks="";
				if(drug_abuse_appl){
					abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"N":(String)drugDetails.get("ABUSE_EXISTS"); //Added for AAKH-CRF-0140
					abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"U":(String)drugDetails.get("ABUSE_ACTION"); //Added for AAKH-CRF-0140
					abuse_restric_trn=(String)drugDetails.get("ABUSE_RESTRIC_TRN")==null?"U":(String)drugDetails.get("ABUSE_RESTRIC_TRN"); //Added for AAKH-CRF-0140
					abuse_override_remarks=(String)drugDetails.get("abuse_override_remarks")==null?"U":(String)drugDetails.get("abuse_override_remarks"); //Added for AAKH-CRF-0140
					abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"":(String)drugDetails.get("ABUSE_OVERRIDE"); //Added for AAKH-CRF-0140

					System.out.println("333 abuse_exists"+abuse_exists);
					System.out.println(abuse_override_remarks+"334 abuse_action"+abuse_action);
					}
					else{
						abuse_exists="N";
						abuse_action="U";
						abuse_restric_trn="N";
						abuse_override="";
						abuse_override_remarks="";
						
					}
				if(calc_dose_based_on!=null && calc_dose_based_on.equals("B")){
					select_calc_dose_Dosage="";
					select_calc_dose_WT_BSA="checked";
					calc_dose_by			= (String)drugDetails.get("CALC_DOSE_BY")==null?"KG":(String)drugDetails.get("CALC_DOSE_BY");
					calc_dose_value			= (String)drugDetails.get("CALC_DOSE_VALUE")==null?"":(String)drugDetails.get("CALC_DOSE_VALUE");
					displaydose="style='display:none'";
					displayBSA="";
					if(calc_dose_by.equals("M2")){
						kg_selected="";
						m2_selected="Selected";
					}
				}
				
				String strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
				String strength_per_pres_uom	   = (String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
				String ext_prod_id			= (String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
				drug_db_dosage_check_flag				= (String) drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	
				perform_external_database_checks_yn		= (String) drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");		
				external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
				external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
				external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
				external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
				external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
				String DrugIndicationRemarks				= (String)drugDetails.get("DRUG_INDICATION")==null?"":(String) drugDetails.get("DRUG_INDICATION");//Added for  ML-BRU-CRF-072[Inc:29938]  
				if(!DrugIndicationRemarks.equals(""))
					DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); ;

				String pres_remarks			=  "";
				HashMap practRights			= (HashMap)bean.getAuthorizationReqd(resp_id, pract_id);
				String pres_base			=	bean.getPresBase(drug_code);
				String base_desc			=	"";
				String infusion_uom			=	"";
				String dr_flow_unit			=	"";				
				String dflt_code			= "";

				if(drugDetails.containsKey("INFUSION_UOM"))
					infusion_uom			= (String)drugDetails.get("INFUSION_UOM");

				if(drugDetails.containsKey("dr_flow_unit"))
					dr_flow_unit			= (String)drugDetails.get("dr_flow_unit");

				StringTokenizer st	=	new StringTokenizer(pres_base,"::");
				if(st.hasMoreTokens()) {
					base_desc	=	st.nextToken();
				}

				if (!classValue.equals("AMENDEDDRUGS")) {

					String orgLineNum	= Integer.toString(srlNo+1);
					HashMap qtyValues	=	bean.getQtyValue(patient_id,order_id,orgLineNum);
					dosage_type			= (String)qtyValues.get("dosage_type")==null?"":(String)qtyValues.get("dosage_type");
					qty_value			= (String)qtyValues.get("qty_value")==null?"":(String)qtyValues.get("qty_value");
					dflt_code			= (String)qtyValues.get("strengthUom")==null?"":(String)qtyValues.get("strengthUom");
				}
				String order_line_num	= Integer.toString(srlNo+1);
				HashMap drugReasons     = new HashMap();
				drugReasons				= bean.getDrugReasons(order_id,order_line_num,"");
				if(drugReasons != null){
					if(allergy_desc.equals("")){
						allergy_desc=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");
						drugDetails.put("ALLERGY_REMARKS",(String)drugReasons.get("ALLERGY_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ALLERGY_OVERRIDE_REASON"));//Added for IN:072715 
						if(allergy_desc == null) {
							allergy_desc=""; 
//							allergy_yn = "N";
						}
					}
					if(exceed_dose_desc.equals("")){
						exceed_dose_desc=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
						drugDetails.put("DOSE_REMARKS",(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON"));//Added for IN:072715 
						if(exceed_dose_desc == null){ 
							exceed_dose_desc=""; 
							limit_ind="Y";
						}
					}
					if(dup_drug_desc.equals("")){
						dup_drug_desc=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");
						drugDetails.put("CURRENTRX_REMARKS",(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON"));//Added for IN:072715 
						if(dup_drug_desc == null) {
							dup_drug_desc=""; 
			//				current_rx="N";
						}
					}
					//Added for IN:072715 start
					if(allergy_remarks_code.equals("")){
						allergy_remarks_code=(String)drugReasons.get("ALLERGY_REMARKS_CODE");
						drugDetails.put("ALLERGY_REMARKS_CODE",(String)drugReasons.get("ALLERGY_REMARKS_CODE")==null?"":(String)drugReasons.get("ALLERGY_REMARKS_CODE"));//Added for IN:072715 
						if(allergy_remarks_code == null){ 
							allergy_remarks_code=""; 
						}
					}
					if(dose_remarks_code.equals("")){
						dose_remarks_code=(String)drugReasons.get("DOSE_REMARKS_CODE");
						drugDetails.put("DOSE_REMARKS_CODE",(String)drugReasons.get("DOSE_REMARKS_CODE")==null?"":(String)drugReasons.get("DOSE_REMARKS_CODE"));//Added for IN:072715 
						if(dose_remarks_code == null){ 
							dose_remarks_code=""; 
						}
					}
					if(currentrx_remarks_code.equals("")){
						currentrx_remarks_code=(String)drugReasons.get("CURRENTRX_REMARKS_CODE");
						drugDetails.put("CURRENTRX_REMARKS_CODE",(String)drugReasons.get("CURRENTRX_REMARKS_CODE")==null?"":(String)drugReasons.get("CURRENTRX_REMARKS_CODE"));//Added for IN:072715 
						if(currentrx_remarks_code == null){ 
							currentrx_remarks_code=""; 
						}
					}
					if(abuse_override_remarks.equals("") && abuse_exists.equals("Y") && abuse_action.equals("B")){
						abuse_override_remarks=(String)drugReasons.get("ABUSE_DRUG_OVERRIDE_REASON");
						drugDetails.put("abuse_override_remarks",(String)drugReasons.get("ABUSE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ABUSE_DRUG_OVERRIDE_REASON"));//Added for IN:072715 
						if(abuse_override_remarks == null){ 
							abuse_override_remarks=""; 
						}
					}
					//Added for IN:072715 end
				}
				ArrayList drug_remarks	=	bean.getPrescribedRemarks(order_id,order_line_num);
				if(drug_remarks.size()!=0) { 
					for(int x=0; x<drug_remarks.size(); x++) {	
						if(x==(drug_remarks.size()-1)) {	
							pres_remarks	+=	(String)drug_remarks.get(x);
						} 
						else {
							pres_remarks	+=	(String)drug_remarks.get(x)+",";
						}
					} 
				} 
				
		// TDM
				String tdmOrder_id = "";
				String display_tdm = "display:none";
				//tdmOrder_id			= bean.getOrderIdForTDMDtls(patient_id,drug_code);
				if(drugDetails.get("TDM_ORDER_ID")== null){
					tdmOrder_id				= bean.getOrderIdForTDMDtls(patient_id,drug_code);
					drugDetails.put("TDM_ORDER_ID",tdmOrder_id);
				}
				else 
					tdmOrder_id = (String)drugDetails.get("TDM_ORDER_ID");

				if(tdmOrder_id==null||tdmOrder_id.equals("")){
					display_tdm="display:none";
				}
				else{
					display_tdm="display:inline";
				} 
				if(exstngIVOrders != null && exstngIVOrders.size()>0){
					for(int i=0;i<exstngIVOrders.size();i++){
						exstngDrgDtls =  (HashMap)exstngIVOrders.get(i);
						if(drug_code.equals((String)exstngDrgDtls.get("ORDER_CATALOG_CODE"))){
							auth_yn_val			= (String)exstngDrgDtls.get("ORD_AUTH_REQD_YN")==null?"N":(String)exstngDrgDtls.get("ORD_AUTH_REQD_YN");    
							approval_yn_val		= (String)exstngDrgDtls.get("ORD_APPR_REQD_YN")==null?"N":(String)exstngDrgDtls.get("ORD_APPR_REQD_YN");
							cosign_yn_val		= (String)exstngDrgDtls.get("ORD_COSIGN_REQD_YN")==null?"N":(String)exstngDrgDtls.get("ORD_COSIGN_REQD_YN");  
							order_uom			= (String)exstngDrgDtls.get("ORDER_UOM")==null?"N":(String)exstngDrgDtls.get("ORDER_UOM");  
							allow_alternate = (String)exstngDrgDtls.get("ALLOW_ALTERNATE_YN")==null?"N":(String)exstngDrgDtls.get("ALLOW_ALTERNATE_YN");//GHL-CRF-0549
							if(calc_dose_based_on==null){
								calc_dose_based_on   = (String)exstngDrgDtls.get("CALC_DOSE_BASED_ON")==null?"D":(String)exstngDrgDtls.get("CALC_DOSE_BASED_ON");
								if(calc_dose_based_on!=null && calc_dose_based_on.equals("B")){
									select_calc_dose_Dosage="";
									select_calc_dose_WT_BSA="checked";
									calc_dose_by			= (String)exstngDrgDtls.get("CALC_DOSE_BY")==null?"KG":(String)exstngDrgDtls.get("CALC_DOSE_BY");
									calc_dose_value			= (String)exstngDrgDtls.get("CALC_DOSE_VALUE")==null?"":(String)exstngDrgDtls.get("CALC_DOSE_VALUE");
									displaydose="style='display:none'";
									displayBSA="";
									if(calc_dose_by.equals("M2")){
										kg_selected="";
										m2_selected="Selected";
									}
									drugDetails.put("CALC_DOSE_BASED_ON",calc_dose_based_on);
									drugDetails.put("CALC_DOSE_BY",calc_dose_by);
									drugDetails.put("CALC_DOSE_VALUE",calc_dose_value);
								}
							}
							if(amend_yn.equals("N")){
								qty_unit = (String)exstngDrgDtls.get("QTY_UNIT")==null?"":(String)exstngDrgDtls.get("QTY_UNIT");  
								drugDetails.put("QTY_UNIT",qty_unit);
								drugDetails.put("Dosage_Uom",qty_unit);
								drugDetails.put("QTY_DESC_CODE",qty_unit);
							}
						}
					}
				}
%>

			<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
				<TR>
					<TD WIDTH="10%" CLASS="label"><fmt:message key="ePH.Additive.label" bundle="${ph_labels}"/></TD>
					<TD WIDTH="60%" colspan='3'><INPUT TYPE="text" name="DRUG_NAME" id="DRUG_NAME" VALUE="<%= drug_desc %>" SIZE="45" MAXLENGTH="40" DISABLED><INPUT TYPE="button" CLASS="button" name="DRUG_SEARCH" id="DRUG_SEARCH" VALUE="?" onClick="searchIVDrugs('D', DRUG_NAME)" DISABLED>
<%
					if (iv_option.equals("Y")) {
%>
						<IMG ID="mandate_drug" SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
<%
					}
%>
					<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(DRUG_CODE.value);" id="edlImg">
					</td>

					<TD class="label"  WIDTH="30%" TITLE="TDM Result"><A HREF style="<%=display_tdm%>" onMouseOver="changeCursor(this);" onclick="viewReasonforRequest('<%=tdmOrder_id%>');"><fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/> </A>&nbsp;</TD>

				</TR>
				<% if (strength_value.equals("0")) {
				
						select_calc_dose_Dosage ="checked";
						select_calc_dose_WT_BSA ="";
						disable_calc_dose		="disabled";						

				}
				System.err.println("drugDetails=====444==>"+drugDetails);
				 //GHL-CRF-0549

					allow_alternate_disabled = "disabled";
					if(allow_alternate.equals("Y")){
					 allow_alternate_checked = "checked";
					}
					//added for NMC-JD-CRF-0026 START
					if(strength_display_app){
				%>
				<tr>
				<td class="label"   width="15%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
					<%	if(act_strength_value != null && act_strength_value!="" && !act_strength_value.equals("0")){ %>
						<td  class="data" id="strength" width="20%">&nbsp;<%=act_strength_value%>&nbsp;<%=strength_uom_desc%> / <%=strength_per_value_pres_uom%>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),pres_base_uom)%></td>
					<%} %>
				</tr>
				<%} //added for NMC-JD-CRF-0026 END%>
				<TR>	
					<TD colspan=5>
						<TABLE border=0>
							<TR>						
								<TD CLASS="label" ><fmt:message key="ePH.CalculateBy.label" bundle="${ph_labels}"/></TD>
								<TD CLASS="label"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/><input type="radio" id="CALC_DOSE_BASED_ON_D" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="D" <%=select_calc_dose_Dosage%> <%=disable_calc_dose%> onClick="setCalculateBy(this,'IVAD_AMEND');"></TD>
								<TD CLASS="label" ><fmt:message key="ePH.BodywtBSA.label" bundle="${ph_labels}"/><input type="radio" id="CALC_DOSE_BASED_ON_B" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="B" <%=select_calc_dose_WT_BSA%> <%=disable_calc_dose%> onClick="setCalculateBy(this,'IVAD_AMEND');"></TD>
								<%				
						
								if(item_type_site_app){ //GHL-CRF-549
			%>					<td CLASS="label" nowrap id="allow_alternate"><fmt:message 						key="ePH.AllowAlternate.label" bundle="${ph_labels}"/>&nbsp;
								<input type='checkbox' onclick ="setAllowAlternate(this)" name='allow_alternate_yn' id='allow_alternate_yn' value='N' <%=allow_alternate_disabled%> <%=allow_alternate_checked%>  > </td><!-- GHL-CRF-0549-->
			<%
								} 
								//GHL-CFR-0549 - end
			%>
							</TR>
						</TABLE>
					</TD>
				</TR>
				<TR <%=displaydose%> id="calc_by_row1">
					<INPUT TYPE="hidden" name="DRUG_CODE" id="DRUG_CODE" VALUE="<%= drug_code %>">
				
					<TD CLASS="label" width='10%'><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/></TD>
					<TD   width='15%'><SELECT name="DOSAGE" id="DOSAGE" onChange="changeScrDetails(this.value);">
<%
					if (strength_value.equals("0")) {
%>
						<OPTION VALUE="Q"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>
<%
					}
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
					<TD  CLASS="label" ID="DOSAGE_LABEL" colspan='4' width='20%'>
<%
					String str_value = "";
					if (strength_value.equals("0")) {
						disabled	 = "";
						str_value	 = pres_qty_value;
%>
						<fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/>
<%
					}
					else {
						if(dosage_type.equals("S")) {
							str_value	= strength_value;
							disabled	= "DISABLED";
%>
							<fmt:message key="Common.Strength.label" bundle="${common_labels}"/>
<%
						}	
						else {
							str_value	= pres_qty_value;
							disabled	= "";
%>
							<fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/>
<%
						}
					}
					if(qty_value!=null && !qty_value.equals("")) {
						str_value	  =	qty_value;
						if(Float.parseFloat(str_value) < 1.0){
							str_value = Float.parseFloat(str_value)+"";
						}			
					}

%>
						<INPUT TYPE="text" name="STRENGTH_VALUE" id="STRENGTH_VALUE" CLASS="number" VALUE="<%= str_value %>" SIZE="3" MAXLENGTH="6" onBlur="setCalculatedQty(this); DosageLimitCheck(this);"><SELECT name="STRENGTH_UOM" id="STRENGTH_UOM" <%= disabled %> onChange="setQtyUOM(this.value);setDrugDosageDetails();">
<%
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
		//				Hashtable QtyDescDetails	= (Hashtable)bean.loadQtyDetails(form_code);
						Hashtable QtyDescDetails	= (Hashtable)bean.listQtyDetails(drug_code);						
						Enumeration keys_des		= QtyDescDetails.keys();
						String uom_code				= "";
						String uom_desc				= "";
						String def_uom				= "";

						while(keys_des.hasMoreElements()) {
							uom_code	= (String)keys_des.nextElement();
							uom_desc	= (String)QtyDescDetails.get(uom_code);

							if(!uom_code.equals("dflt_code")) {
						/*	 if (!classValue.equals("AMENDEDDRUGS")) {
								if(uom_code.equals(dflt_code))
									def_uom = "SELECTED";
								else
									def_uom = "";
							 }else{*/
//							 	if(uom_code.equals(qty_desc_code))

							 	if(uom_code.equals(qty_unit)){

									def_uom = "SELECTED";
								}
								else{
									def_uom = "";
								}
						//	 }

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
		//			Hashtable QtyDescDetails	= (Hashtable)bean.loadQtyDetails(form_code);
					Hashtable QtyDescDetails	= (Hashtable)bean.listQtyDetails(drug_code);			
					Enumeration keys_des		= QtyDescDetails.keys();
					String uom_code				= "";
					String uom_desc				= "";
					String def_uom				= "";
		//			String dflt_code			= "";

					if (amend_yn.equals("N"))
						dflt_code = QtyDescDetails.get("dflt_code") == null ? "" : QtyDescDetails.get("dflt_code").toString();
					else
						dflt_code = qty_desc_code;

					while(keys_des.hasMoreElements()) {
						uom_code	= (String)keys_des.nextElement();
						uom_desc	= (String)QtyDescDetails.get(uom_code);

						if(!uom_code.equals("dflt_code")) {
							if(uom_code.equals(dflt_code))
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
				<!-- <TD WIDTH="15%" ALIGN="right" CLASS="label">Infusion Rate&nbsp;</TD> -->
<%
				String inf_uom = "";
				int srlNum		= Integer.parseInt(srl_no)-1;
				String inf_val	= bean.getInfRate(Integer.toString(srlNum), 3);
				
				if (strength_value.equals("0")) {
					disabled = "DISABLED";
				}
				else {
					if(dosage_type.equals("S")) {
						inf_uom = strength_uom_desc;
						disabled = "";

						if (!inf_val.equals("") && !(bean.getInfRate(Integer.toString(srlNum), 1).equals(Integer.toString(srlNum)))) {
							disabled = "DISABLED";
						}
						else if (inf_val.equals("")) {
							disabled = "";
						}
					}
					else {
						disabled = "DISABLED";
					}
				}

				if(inf_uom.equals("")) {
					make_disabled	=	"disabled";
					readOnly		=	"READONLY";
				}
				else {
					make_disabled	=	"";
					readOnly		=	"";
				}
%>
					<A HREF="#" onMouseOver="changeCursor(this);" id="drug_remarks" onClick="getFormatId('Drug','Y')"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/> </A>
							        <!-- added for [IN:039576]-start -->
							        <img  src="../../eCommon/images/mandatory.gif" style='display:none;' name='DrugRemarksMandImg'>
									<input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
									<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>&nbsp;&nbsp;
									<!-- added for [IN:039576]-end -->
					<a href="#" onMouseOver="changeCursor(this);"  id="drug_ind_remarks" onClick="drugindication_remarks()"><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a></TD><!--Added for  ML-BRU-CRF-072[Inc:29938]-->
				</TD>
				<INPUT TYPE="hidden" name="INF_VAL" id="INF_VAL" VALUE="<%= bean.getInfRate(Integer.toString(srlNum), 2) %>">
			</TR>
			<TR <%=displayBSA%> id="calc_by_row2">
				<TD CLASS="label"><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/></TD>
				<TD colspan="3" nowrap><input type="text" name="CALC_DOSE_VALUE" id="CALC_DOSE_VALUE" value="<%=calc_dose_value%>" size="5" maxlength="8" onKeyPress="return allowValidNumber(this,event,4,3);" onBlur="calculateDosage_By_BSA_or_Weight('IVAD_AMEND');DosageLimitCheck(this);" CLASS="number"><!-- Modified for IN:070451 added DosageLimitCheck function -->
				<select name="calc_dose_value_unit" id="calc_dose_value_unit"><OPTION VALUE="<%=strength_uom%>"><%= strength_uom_desc%></OPTION></select><label class="label"><b> / </b></label><select name="CALC_DOSE_BY" id="CALC_DOSE_BY" onChange="calculateDosage_By_BSA_or_Weight('IVAD_AMEND');"><option value="KG" <%=kg_selected%>><fmt:message key="ePH.KG.label" bundle="${ph_labels}"/></option><option value="M2" <%=m2_selected%>><fmt:message key="ePH.M2.label" bundle="${ph_labels}"/></option></select><label class="label"><b> = </b></label><INPUT TYPE="text" name="strength_value_wt_bsa" id="strength_value_wt_bsa"  VALUE="<%=qty_value%>" SIZE="10" MAXLENGTH="12" onKeyPress="return allowValidNumber(this,event,8,3);" class="number" onBlur="assignStrengthForBSA();setCalculatedQty(this); DosageLimitCheck(this);">&nbsp;<label class="label"> <b><%=strength_uom_desc%></b></label>
				<img src="../../eCommon/images/mandatory.gif" BORDER="0"></img>
				</TD>
			</TR>
<%
			if(recomm_yn!=null && recomm_yn.equals("Y")) {
%>
				<TR >
					<TD colspan='2'>&nbsp;
					</td>
					<td CLASS="label" ID="monograph" colspan='2'>
						<label id='rec_legend' onclick='defaultRecomDose()'>
<%
						if(dosage_type.equals(recomm_dosage_by)){
%>
							<font class='HYPERLINK' onmouseover='changeCursor(this);'>
<%
						}
%>
						<fmt:message key="ePH.Recom.Dose.label" bundle="${ph_labels}"/></font>
						</label>
						<label id="rec_value" style="font-size:11;font-weight:bold;color:red"><%=dosage_std%></label>
						&nbsp;<label id="rec_uom" style="font-size:11;font-weight:bold;color:red"><%=dosage_unit%></label>
					</td>
					<td>&nbsp;</td>
				</tr>
<%
			}
%>
		<!-- Duplicate medication warning ends-->

			<TR>
				<TD WIDTH="25%"  CLASS="label" ID="auth_yn_img">
<%
			if (drugDetails.get("ORD_AUTH_REQD_YN") != null){
				if (drugDetails.get("ORD_AUTH_REQD_YN").equals("Y")) {
					/*String authYN = (String)practRights.get("AUTH_YN");
					if(authYN == null) authYN = "";*///commented for ML-MMOH-CRF-0343 [IN:057182]
				//	if (authYN.equals("Y")) //commented for ML-MMOH-CRF-0343 [IN:057182]
						
				if (drugDetails.get("ORD_AUTHORIZED_YN").equals("N") ) {
					%>
							
					
	<%			
				 if (drugDetails.get("ORD_AUTHORIZED_YN").equals("N") && auth_amend_pres_yn.equals("Y") && called_amend_from.equals("PH") ) {
						%>
						<IMG SRC="../../eOR/images/Authorized.gif" BORDER="0"></IMG>&nbsp;<B><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></B>		
						
		<%			}
		
				else {
					%>
					<IMG SRC="../../eOR/images/Authorization.gif" BORDER="0"></IMG>&nbsp;<A HREF onMouseOver="changeCursor(this)" onClick="chkAuthorization('authorize')"><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/> </A>		
			
<%					}
	
				
				}
			
				else if (drugDetails.get("ORD_AUTHORIZED_YN").equals("Y") ) {
							
						
%>
								<IMG SRC="../../eOR/images/Authorized.gif" BORDER="0"></IMG>&nbsp;<B><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/></B>
<%
							}
						
						else {
%>
							<IMG SRC="../../eOR/images/Authorization.gif" BORDER="0"><font style='color:red;'></IMG>&nbsp;<fmt:message key="Common.AuthorizationReqd..label" bundle="${common_labels}"/></font>

<%
						}//commented for ML-MMOH-CRF-0343 [IN:057182]
					}
				}
%>
				</TD>
				<TD WIDTH="25%" CLASS="label" ID="spappl_yn_img">
<%
			if (drugDetails.get("ORD_SPL_APPR_REQD_YN") != null){
				if (drugDetails.get("ORD_SPL_APPR_REQD_YN").equals("Y")) {

					String splAprvl = (String)practRights.get("SPL_APPR_YN");
					if(splAprvl == null) splAprvl = "";
					if (splAprvl.equals("Y")) {
						if (approval_yn_val.equals("N")) {
%>

							<IMG SRC="../../eOR/images/SpecialApproval.gif" BORDER="0"></IMG>&nbsp;<A HREF onMouseOver="changeCursor(this)" onClick="chkAuthorization('approve')"><fmt:message key="Common.Approve.label" bundle="${common_labels}"/></A>
<%
						}
						else {
%>
							<IMG SRC="../../eOR/images/SpecialApproval_click.gif" BORDER="0"></IMG>&nbsp;<B><fmt:message key="Common.Approved.label" bundle="${common_labels}"/></B>
<%
						}
					}
					else {
%>
						<IMG SRC="../../eOR/images/SpecialApproval.gif" BORDER="0"></IMG>&nbsp;<font style='color:red;'> <fmt:message key="ePH.SplApprovalReqd.label" bundle="${ph_labels}"/></font>
<%
					}
				}
			}
%>
				</TD>
				<TD WIDTH="20%" CLASS="label" ID="cosign_yn_img">
<%
				
			 if (drugDetails.get("ORD_COSIGN_REQD_YN") != null){
				if (drugDetails.get("ORD_COSIGN_REQD_YN").equals("Y")) {

					String consignYN = (String)practRights.get("COSIGN_YN");
					if(consignYN == null) consignYN = "";
					if (consignYN.equals("Y")) {
						if (cosign_yn_val.equals("N")) {
%>

							<IMG SRC="../../eOR/images/Cosign_click.gif" BORDER="0">&nbsp;<A HREF onMouseOver="changeCursor(this)" onClick="chkAuthorization('cosign')"><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></A>

<%
						}
						else {
%>

							<IMG SRC="../../eOR/images/Cosign.gif" BORDER="0">&nbsp;<B><fmt:message key="Common.Cosigned.label" bundle="${common_labels}"/></B>
<%
						}
					}
					else {
%>
						<IMG SRC="../../eOR/images/Cosign_click.gif" BORDER="0"><font style='color:red;'>&nbsp;<fmt:message key="Common.CosignReqd.label" bundle="${common_labels}"/></font>
<%
					}
				}
			 }
%>
				</TD>
<%
				if (drugDetails.get("CONSENT_REQD_YN").equals("Y")) {
%>
					<TD WIDTH="15%" CLASS="eORConsent" ID="consent" TITLE="Consent Required"><FONT COLOR="#0066CC" SIZE="1"><B> <fmt:message key="ePH.ConsentReqd..label" bundle="${ph_labels}"/></B></FONT></TD>
<%
				}
				else {
%>
					<TD WIDTH="15%" CLASS="label" ID="consent">&nbsp;</TD>
<%
				}
%>
					<td>&nbsp;</td>
				</TR>
<%
	/*
				if(current_rx.equals("Y") && allow_duplicate.equals("N") && patient_class.equals("IP")) {	
					String dup_drug_info	=	"";
					ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
					HashMap  dup_info		=	null;

					if(curr_info.size()>=1) {
						dup_info	  =	(HashMap)curr_info.get(0);

						dup_drug_info = "Patient is Currently On "+generic_name+" Medication till :"+dup_info.get("end_date")+";\n";
						dup_drug_info +="Has been prescribed by :"+dup_info.get("practitioner_name")+" from "+dup_info.get("location");
					}
					*/

				//} //commented all & HTML MArgue code removed for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
				drugDetails.put("Dosage_Uom",dflt_code);
%>
			</TABLE>

			
			<INPUT TYPE="hidden" name="GENERIC_ID" id="GENERIC_ID" VALUE="<%= generic_id %>">
			<INPUT TYPE="hidden" name="GENERIC_NAME" id="GENERIC_NAME" VALUE="<%= generic_name %>">
			<INPUT TYPE="hidden" name="DAILY_DOSE" id="DAILY_DOSE" VALUE="<%= daily_dose %>">
			<INPUT TYPE="hidden" name="UNIT_DOSE" id="UNIT_DOSE" VALUE="<%= unit_dose %>">
			<INPUT TYPE="hidden" name="MONO_GRAPH" id="MONO_GRAPH" VALUE="<%= mono_graph %>">
			<INPUT TYPE="hidden" name="dosage_std" id="dosage_std" VALUE="<%= dosage_std %>">
			<INPUT TYPE="hidden" name="dosage_unit" id="dosage_unit" VALUE="<%= dosage_unit %>">
			<INPUT TYPE="hidden" name="recomm_yn" id="recomm_yn" VALUE="<%= recomm_yn %>">
			<input type="hidden" name="recomm_dosage_by" id="recomm_dosage_by"	    value="<%=recomm_dosage_by%>">
			<INPUT TYPE="hidden" name="LIMIT_IND" id="LIMIT_IND" VALUE="<%= limit_ind %>">
			<INPUT TYPE="hidden" name="MIN_DAILY_DOSE" id="MIN_DAILY_DOSE" VALUE="<%= min_daily_dose %>">
			<INPUT TYPE="hidden" name="MIN_UNIT_DOSE" id="MIN_UNIT_DOSE" VALUE="<%= min_unit_dose %>">
			<!-- Added for IN:070451 start -->
				<input type="hidden" name="max_daily_ceeling_dose" id="max_daily_ceeling_dose" value="<%=max_daily_ceeling_dose%>">
				<input type="hidden" name="min_daily_ceeling_dose" id="min_daily_ceeling_dose" value="<%=min_daily_ceeling_dose%>">
				<input type="hidden" name="max_unit_ceeling_dose" id="max_unit_ceeling_dose" value="<%=max_unit_ceeling_dose%>">
				<input type="hidden" name="min_unit_ceeling_dose" id="min_unit_ceeling_dose" value="<%=min_unit_ceeling_dose%>">
				<input type="hidden" name="calc_by_ind" id="calc_by_ind"	    value="<%=calc_by_ind%>">
				<!-- Added for IN:070451 end  -->
	        	<!-- Added for IN:072715 Start -->		
	               <input type="hidden"  name="allergy_remarks_code" id="allergy_remarks_code" value="<%=allergy_remarks_code%>">
                       <input type="hidden"  name="dose_remarks_code" id="dose_remarks_code" value="<%=dose_remarks_code%>">
                       <input type="hidden"  name="currentrx_remarks_code" id="currentrx_remarks_code" value="<%=currentrx_remarks_code%>">
                       <!-- Added for IN:072715 end -->
			<INPUT TYPE="hidden" name="ALLERGY_YN" id="ALLERGY_YN" VALUE="<%= allergy_yn %>">
			<INPUT TYPE="hidden" name="CURRENT_RX" id="CURRENT_RX" VALUE="<%= current_rx %>">
			<INPUT TYPE="hidden" name="SRL_NO" id="SRL_NO" VALUE="<%= srl_no %>">
			<INPUT TYPE="hidden" name="FORM_CODE" id="FORM_CODE" VALUE="<%= form_code %>">
			<INPUT TYPE="hidden" name="PRES_QTY_VALUE" id="PRES_QTY_VALUE" VALUE="<%= pres_qty_value %>">
			<INPUT TYPE="hidden" name="PRES_BASE_UOM" id="PRES_BASE_UOM" VALUE="<%= pres_base_uom %>">
			<INPUT TYPE="hidden" name="FREQ_CODE" id="FREQ_CODE" VALUE="<%= freq_code %>">
			<INPUT TYPE="hidden" name="DURN_VALUE" id="DURN_VALUE" VALUE="<%= durn_value %>">
			<INPUT TYPE="hidden" name="DURN_TYPE" id="DURN_TYPE" VALUE="<%= durn_type %>">
			<INPUT TYPE="hidden" name="OR_DURN_DESC" id="OR_DURN_DESC" VALUE="<%= or_durn_desc %>">
			<INPUT TYPE="hidden" name="APPROVAL_YN_VAL" id="APPROVAL_YN_VAL" VALUE="<%= approval_yn_val %>" >
			<INPUT TYPE="hidden" name="AUTH_YN_VAL" id="AUTH_YN_VAL" VALUE="<%= auth_yn_val %>">
			<INPUT TYPE="hidden" name="COSIGN_YN_VAL" id="COSIGN_YN_VAL" VALUE="<%= cosign_yn_val %>">
			<INPUT TYPE="hidden" name="ORDER_TYPE_CODE" id="ORDER_TYPE_CODE" VALUE="<%= order_type_code %>">
			<INPUT TYPE="hidden" name="ROUTE_CODE" id="ROUTE_CODE" VALUE="<%= route_code %>">
			<INPUT TYPE="hidden" name="END_DATE" id="END_DATE" VALUE="<%= end_date %>">
			<INPUT TYPE="hidden" name="AUTH_YN" id="AUTH_YN" VALUE="<%= auth_yn %>">
			<INPUT TYPE="hidden" name="APPROVAL_YN" id="APPROVAL_YN" VALUE="<%= approval_yn %>">
			<INPUT TYPE="hidden" name="COSIGN_YN" id="COSIGN_YN" VALUE="<%= cosign_yn %>">
			<INPUT TYPE="hidden" name="CONSENT_REQD_YN" id="CONSENT_REQD_YN" VALUE="<%= consent_reqd_yn %>">
			<INPUT TYPE="hidden" name="ALLERGY_DESC" id="ALLERGY_DESC" VALUE="<%= allergy_desc %>">
			<INPUT TYPE="hidden" name="EXCEED_DOSE_DESC" id="EXCEED_DOSE_DESC" VALUE="<%= exceed_dose_desc %>">
			<INPUT TYPE="hidden" name="DUP_DRUG_DESC" id="DUP_DRUG_DESC" VALUE="<%= dup_drug_desc %>">
			<INPUT TYPE="hidden" name="UOM_CODE" id="UOM_CODE" VALUE="<%= strength_uom %>">
			<INPUT TYPE="hidden" name="STRENGTH_UOM_DESC" id="STRENGTH_UOM_DESC" VALUE="<%= strength_uom_desc %>">
			<INPUT TYPE="hidden" name="STR_VAL" id="STR_VAL" VALUE="<%= str_value %>">
			<INPUT TYPE="hidden" name="BMS_QTY" id="BMS_QTY" VALUE="<%= bms_qty %>">
			<INPUT TYPE="hidden" name="DFLT_QTY_UOM" id="DFLT_QTY_UOM" VALUE="<%= dflt_qty_uom %>">
			<INPUT TYPE="hidden" name="TAB_QTY_VALUE" id="TAB_QTY_VALUE" VALUE="<%= tab_qty_value %>">
			<INPUT TYPE="hidden" name="QTY_DESC_CODE" id="QTY_DESC_CODE" VALUE="<%= qty_desc_code %>">
			<INPUT TYPE="hidden" name="STR_DESC" id="STR_DESC" VALUE="">
			<INPUT TYPE="hidden" name="license" id="license" VALUE="<%=license%>">
			<INPUT TYPE="hidden" name="order_id" id="order_id" VALUE="<%=order_id%>">
			<INPUT TYPE="hidden" name="order_line_num" id="order_line_num" VALUE="<%=order_line_num%>">
			<INPUT TYPE="hidden" name="pres_remarks" id="pres_remarks" VALUE="<%=pres_remarks%>">
			<input type="hidden" name="ORDERSET_STRENGTH" id="ORDERSET_STRENGTH" value="<%=str_value%>">
			<input type="hidden" value="<%=validate_overide_on_confirm_yn%>" name="validate_overide_on_confirm_yn"><!-- Added for IN:069887  -->
			<input type="hidden" name="strength_per_value_pres_uom" id="strength_per_value_pres_uom" value="<%=strength_per_value_pres_uom%>">
			<input type="hidden" name="strength_per_pres_uom" id="strength_per_pres_uom" value="<%=strength_per_pres_uom%>">
			<input type="hidden" name="interval_value" id="interval_value" value="1">
			<input type="hidden" name="perform_external_database_checks_yn" id="perform_external_database_checks_yn" value="<%=perform_external_database_checks_yn%>">
			<input type="hidden" name="external_product_id" id="external_product_id"     value="<%=ext_prod_id%>">
			<input type="hidden" name="fract_dose_round_up_yn" id="fract_dose_round_up_yn"  value="<%=fract_dose_round_up_yn%>">
			<input type="hidden" name="external_dosage_override_reason" id="external_dosage_override_reason" value=<%=external_dosage_override_reason%>>
			<input type="hidden" name="external_duplicate_override_reason" id="external_duplicate_override_reason" value=<%=external_duplicate_override_reason%>>
			<input type="hidden" name="external_interaction_override_reason" id="external_interaction_override_reason" value=<%=external_interaction_override_reason%>>
			<input type="hidden" name="external_contra_override_reason" id="external_contra_override_reason" value=<%=external_contra_override_reason%>>
			<input type="hidden" name="external_Alergy_override_reason" id="external_Alergy_override_reason" value="<%=external_alergy_override_reason%>">
			<input type="hidden" name="drug_db_dose_check_flag" id="drug_db_dose_check_flag" value="<%=drug_db_dosage_check_flag%>">
			<input type="hidden" name="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn" value="<%=drug_db_dosecheck_yn%>">
			<input type="hidden" name="DrugIndicationRemarks" id="DrugIndicationRemarks" value="<%=DrugIndicationRemarks%>"><!--Added for  ML-BRU-CRF-072[Inc:29938]-->
			<input type="hidden" name="abuse_restric_trn" id="abuse_restric_trn" value="<%=abuse_restric_trn%>"> <!-- added for aakh-crf-0140 -->
					<input type="hidden" name="abuse_exists" id="abuse_exists"  value="<%=abuse_exists%>"><!-- added for aakh-crf-0140 -->
<input type="hidden" name="abuse_action" id="abuse_action"  value="<%=abuse_action%>">	<!-- added for aakh-crf-0140 -->
                       <input type="hidden"  name="abuse_override_remarks" id="abuse_override_remarks" value="<%=abuse_override_remarks%>">
                       <input type="hidden"  name="ABUSE_OVERRIDE" id="ABUSE_OVERRIDE" value="<%=abuse_override%>">
                       
			
			<SCRIPT>
				loadButtonsFrame('amend','<%= patient_id %>','<%= encounter_id %>','<%=serialNum%>');
				document.formIVPrescriptionDrugDetails.STRENGTH_VALUE.focus(); // this line was added so that dosage details wil be passed correctly when clicking on fdb viewmedicationalert()
			//changeScrDetails(document.formIVPrescriptionDrugDetails.DOSAGE.value); // commented for IN23745 --14/09/2010-- priya
			//if(document.formIVPrescriptionDrugDetails.DOSAGE.value!="") {
				//changeScrDetails(document.formIVPrescriptionDrugDetails.DOSAGE.value);
			//}
			getFormatId('Drug','N');//added for [IN:039576]
			</SCRIPT>

<%
			}



%>
<!-- added for ml-mmoh-crf-0863 start -->
				    <INPUT type="hidden" name="take_home_medication" id="take_home_medication" value="<%=take_home_medication%>">
					<INPUT type="hidden" name="priority" id="priority" value="<%=priority%>">
					<INPUT type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
					<INPUT type="hidden" name="ORD_AUTHORIZED_YN" id="ORD_AUTHORIZED_YN" value="">
<!-- added for ml-mmoh-crf-0863 end -->
</FORM>
<% 
	putObjectInBean(bean_id,bean,request); 
	putObjectInBean(or_bean_id,ORbean,request);
		putObjectInBean(pre_bean_id,pre_bean,request);
%>
</BODY>
<script>
<% 
	//if(current_rx.equals("Y") && allow_duplicate.equals("N") && patient_class.equals("IP")) {%>

	//duplicateWarning();
<%	
	//}
%>
</script>
</HTML>
<%}catch(Exception e){
	e.printStackTrace();
}finally{ 
       	if(con != null)
      		ConnectionManager.returnConnection(con,request);	 //added for GHL-CRF-0549
}
%>

