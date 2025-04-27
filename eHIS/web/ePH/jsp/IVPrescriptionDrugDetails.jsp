<!DOCTYPE html>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
16/4/2020		IN072917			Shazana												SKR-SCF-1317
30/06/2020              IN:072715          Haribabu            25/06/2020              Manickavasagam J     MMS-DM-CRF-0165              
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
06/01/2021		TFS-7345          Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
25-05-2022               AAKH-CRF-0140       PRATHYUSHA
--------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>    
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,webbeans.eCommon.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%> 

<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DrugNameCommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/IVPrescriptionWithAdditives.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	Connection con			= null;   
	 try{
		con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
   	  	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
   	 boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
   	//Added for IN:069887  start
	boolean validate_overide_on_confirm =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","VALIDATE_OVERIDE_ON_CONFIRM");//added for MO-CRF-20152
	boolean drug_abuse_appl=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_ABUSE_APPL");//added for AAKH-CRF-0140
	boolean req_diag_pres_found=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REQ_DIAG_PRES_FOUND");//added for MMS-DM-CRF-0204
			String validate_overide_on_confirm_yn="N";
	if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}		
//Added for IN:069887 end
		String patient_id		= request.getParameter("patient_id");		
		String encounter_id		= request.getParameter("encounter_id");
		String act_patient_class= request.getParameter("act_patient_class");
		String patient_class	= request.getParameter("patient_class")== null ? "":request.getParameter("patient_class");	//IN30118-SCF No: MO-GN-5400. Check Null for patient_class.
		String classValue	    = request.getParameter("classValue")==null?"":request.getParameter("classValue");		
		String mode				= request.getParameter("mode")==null?"":request.getParameter("mode");
		String start_date		= request.getParameter("start_date");
		String serialNum		= request.getParameter("serialNum") == null ? "":request.getParameter("serialNum");		
		String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
		// added for ml-mmoh-crf-0863 start 
		String iv_prep_yn		= request.getParameter("iv_prep_yn") == null ? "":request.getParameter("iv_prep_yn");
		String take_home_medication		= request.getParameter("take_home_medication") == null ? "":request.getParameter("take_home_medication");
		String priority		= request.getParameter("priority") == null ? "":request.getParameter("priority");
		// added for ml-mmoh-crf-0863 end
		System.out.println("take_home_medication in amend"+take_home_medication);
		System.out.println("priority in amend"+priority);
		System.out.println("iv_prep_yn in amend "+iv_prep_yn);
		String disaExst			= "";
		String disaAmend		= "";

		String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
		String bean_name		= "ePH.IVPrescriptionBean";
		IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;

		if(!patient_class.equals("")){//IN30118-SCF No: MO-GN-5400. Set patient_class to Bean.
		bean.setPatientClass(patient_class);
		}
		bean.setExcludeADRAllergyAlert(CommonBean.checkForNull(request.getParameter("excludeADRAllergyAlert_yn")));
		String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
		String or_bean_name		= "eOR.OrderEntryBean";
		OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
		if((bean.getOrder_type_flag()).equals("Existing")) 
			disaExst = "";
		if(mode.equals("amend")) 
			disaAmend = "disabled";
		String resp_id			= (String)ORbean.getResponsibilityId();
		String pract_id			= (String)ORbean.getPractitionerId();
		String pract_name		= (String)ORbean.getPractitionerName();
		String locn_type		= (String)ORbean.getLocationType();
		String locn_code		= (String)ORbean.getLocationCode();
		String order_id			= (String)ORbean.getOrderId();
		String license			=	bean.getLicense();
		String current_rx		=	"";
		String DrugRemarksEntered			=	""; //added for [IN:039576]
//changed during PE by naveen

		//String allow_duplicate	=	bean.checkDuplicateYN();//commented all for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
		//		String	allow_duplicate	=	"";
		//code added for external data base checks 
		
		String perform_external_database_checks_yn	=	"";	
		String loading_ext_prod_id					=	"";
		String external_dosage_override_reason		=   "";	
		String external_duplicate_override_reason	=   "";
		String external_interaction_override_reason	=   "";
		String external_contra_override_reason		=   ""; 
		String external_alergy_override_reason		=   ""; 
		String fract_dose_round_up_yn				=   "";
		String drug_db_dosage_check_flag			=   "Y";
	//GHL-CRF-0549 -start
		String disp_by_alt_form_param				=	"N"; //GHL-CRF-0549
		String disp_by_alt_form_drug				=   "N";//GHL-CRF-0549
	
		String item_type = "";
		String mm_item_low_cost_yn = ""; 
		String mm_item_high_margin_yn = "";
		String mm_item_Innovator_yn  = "";
		String allow_alternate_yn ="N"; //GHL-CRF-0549
		String allow_alternate_disabled	= "";
		String checked  = "";
		//GHL-CRF-0549 - end	
		
		String ex_bean_id   = "@ExternalProductLinkBean";
		String ex_bean_name = "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);

	//comented during PE By Naveen

		/*	String facility_id					= (String)session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );*/
		//String drug_db_interface_yn			=	param_bean.getDrugDBInterface_yn(facility_id);    
		/*String drug_db_dosecheck_yn			=	param_bean.getDrugDBDosecheck_yn(facility_id);    
		String drug_db_duptherapy_yn		=	param_bean.getDrugDBDuptherapy_yn(facility_id);
		String drug_db_interact_check_yn	=	param_bean.getDrugDBInteract_check_yn(facility_id);  
		String drug_db_contraind_check_yn	=	param_bean.getDrugDBContraind_check_yn(facility_id);*/
		//String drug_db_allergy_check_yn		=	param_bean.getDrugDBAllergy_check_yn(facility_id);   
		//param_bean.clear();	
		String display_auth_rule			=	"visibility:hidden";
		String color_auth_rule				=	"RED";
		String abuse_exists="";//added for aakh-crf-0140
		String abuse_action="";//aded for aakh-crf-0140
		String abuse_restric_trn="";//added for aakh-crf-0140
				String abuse_override="";//added for AAKH-CRF-0140
				String abuse_override_remarks="";//added for AAKH-CRF-0140
						String abuse_override_remarks1="";//added for aakh-crf-0140
	   //ends here

	//Added for MMS-DM-CRF-0177
	String new_generic_name = ""; 
	String pre_alloc_appl = ""; 
	String drug_search = "";
	pre_alloc_appl = bean.getPreAllocApplYN();
	//Added for MMS-DM-CRF-0177
		int dose_decimal = 2;
%>

		<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" > 
			<FORM name="formIVPrescriptionDrugDetails" id="formIVPrescriptionDrugDetails">
				<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
				<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
				<INPUT TYPE="hidden" name="patient_id" id="patient_id" VALUE="<%= patient_id %>">
				<INPUT TYPE="hidden" name="encounter_id" id="encounter_id" VALUE="<%= encounter_id %>">
				<INPUT TYPE="hidden" name="start_date" id="start_date" VALUE="<%= start_date %>">
				<INPUT TYPE="hidden" name="patient_class" id="patient_class" VALUE="<%= patient_class %>">
				<INPUT TYPE="hidden" name="act_patient_class" id="act_patient_class" VALUE="<%= act_patient_class %>">
				<INPUT TYPE="hidden" name="drug_codes" id="drug_codes" VALUE="<%= bean.getDrugCodes() %>">
				<INPUT TYPE="hidden" name="resp_id" id="resp_id" VALUE="<%= resp_id %>">
				<INPUT TYPE="hidden" name="pract_id" id="pract_id" VALUE="<%= pract_id %>">
				<INPUT TYPE="hidden" name="pract_name" id="pract_name" VALUE="<%= pract_name %>">
				<INPUT TYPE="hidden" name="locn_type" id="locn_type" VALUE="<%= locn_type %>">
				<INPUT TYPE="hidden" name="locn_code" id="locn_code" VALUE="<%= locn_code %>">
				<input type="hidden" name="INFUSION_VALUE" id="INFUSION_VALUE" value="">
				<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
					<!-- added for ml-mmoh-crf-0863 start -->
				    <INPUT type="hidden" name="take_home_medication" id="take_home_medication" value="<%=take_home_medication%>">
					<INPUT type="hidden" name="priority" id="priority" value="<%=priority%>">
					<INPUT type="hidden" name="iv_prep_yn" id="iv_prep_yn" value="<%=iv_prep_yn%>">
<!-- added for ml-mmoh-crf-0863 end -->

<% 
				if (serialNum.equals("")) {
%>
					<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
						<TR>
							<TD WIDTH="17%" CLASS="label"><fmt:message key="ePH.Additive.label" bundle="${ph_labels}"/>&nbsp;</TD>
							<TD WIDTH="83%" colspan='3'><INPUT TYPE="text" name="DRUG_NAME" id="DRUG_NAME" VALUE="" SIZE="45" MAXLENGTH="40" onBlur="checkValidDrug('D', this.value)" <%=disaAmend%> > <INPUT TYPE="button" CLASS="button" name="DRUG_SEARCH" id="DRUG_SEARCH" VALUE="?" onClick="searchIVDrugs('D', DRUG_NAME)" <%=disaAmend%> >
							<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=hidden" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(DRUG_CODE.value);" id="edlImg">
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
						<TD colspan=4><TABLE border=0><TR>
						<TD CLASS="label"><fmt:message key="ePH.CalculateBy.label" bundle="${ph_labels}"/></TD>
						<TD CLASS="label"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/> <input type="radio" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="D" checked  disabled></TD>
						<TD CLASS="label"><fmt:message key="ePH.BodywtBSA.label" bundle="${ph_labels}"/><input type="radio" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="B"  disabled></TD></TR></TABLE></TD>
						</TR>
						<TR>
							<TD CLASS="label"><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/></TD>
							<TD><SELECT DISABLED name="DOSAGE" id="DOSAGE">
								<OPTION VALUE=""><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></OPTION>
								<OPTION VALUE=""><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>
								</SELECT>
							</TD>
							<TD CLASS="label"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/>&nbsp;</TD>
							<TD >
								<INPUT TYPE="text" name="STRENGTH_VALUE" id="STRENGTH_VALUE" VALUE=""  DISABLED SIZE="10" MAXLENGTH="11" onKeyPress= "return(ChkNumberInput(this,event,'<%=dose_decimal%>'))">&nbsp;
								
<!--   "return allowValidNumber(this,event,8,<%=dose_decimal%>);"-->
								<SELECT DISABLED name="STRENGTH_UOM" id="STRENGTH_UOM">
									<OPTION VALUE="">&nbsp;&nbsp;--- <fmt:message key="ePH.Select.label" bundle="${ph_labels}"/> ---&nbsp;&nbsp;</OPTION>
								</SELECT>
							</TD>
						</TR>
						<input type="hidden" name="external_product_id" id="external_product_id"  value="">
						<input type="hidden" name="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn" value="N">
					</TABLE>
<%

				}
				else {
					String facility_id					= (String)session.getValue("facility_id");
					String param_bean_id				= "@DrugInterfaceControlBean";
					String param_bean_name				= "ePH.DrugInterfaceControlBean";
					DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
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
					param_bean.clear();	


					String disabled	= "";
					int srlNo		= 0;
					srlNo			= Integer.parseInt(serialNum);
					ArrayList drugList			= bean.getDrugDetails();

					HashMap drugDetails			= (HashMap)drugList.get(srlNo-1);
					ArrayList orderSetValues	= bean.getOrderSetValues();
					String generic_id			= (String)drugDetails.get("GENERIC_ID");
					String drug_desc			= (String)drugDetails.get("DRUG_DESC");
					String drug_code			= (String)drugDetails.get("DRUG_CODE");
					String generic_name			= (String)drugDetails.get("GENERIC_NAME");
					String daily_dose			= (String)drugDetails.get("DAILY_DOSE");
					String min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_DOSE");
					String min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_DOSE");
					String unit_dose			= (String)drugDetails.get("UNIT_DOSE")==null?"":(String)drugDetails.get("UNIT_DOSE");
					String dosage_std			= (String)drugDetails.get("DOSAGE_STD")==null?"":(String)drugDetails.get("DOSAGE_STD");
					String recomm_dosage_by		= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
					String calc_by_ind			= (String)drugDetails.get("CALC_BY_IND")==null?"":(String)drugDetails.get("CALC_BY_IND");
					String mono_graph			= (String)drugDetails.get("MONO_GRAPH")==null?"":(String)drugDetails.get("MONO_GRAPH");
					String limit_ind			= (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
					//Added for IN:070451 start
					String      max_daily_ceeling_dose	    =   (String)drugDetails.get("MAX_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_DAILY_CEELING_DOSE");
					String		min_daily_ceeling_dose	    =   (String)drugDetails.get("MIN_DAILY_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_CEELING_DOSE");
					String		max_unit_ceeling_dose	    =   (String)drugDetails.get("MAX_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MAX_UNIT_CEELING_DOSE");
					String		min_unit_ceeling_dose	    =   (String)drugDetails.get("MIN_UNIT_CEELING_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_CEELING_DOSE");
					//Added for IN:070451 end
					//Added for IN:072715 start
					String allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
					String dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
					String currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
					//Added for IN:072715 end
					String allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
					current_rx					= (String)drugDetails.get("CURRENT_RX");
					String srl_no				= (String)drugDetails.get("SRL_NO");
					String strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
					String act_strength_value=(String)drugDetails.get("ACT_STRENGTH_VALUE");//added for NMC-JD-CRF-0026
					String def_dosage_yn=(String)drugDetails.get("DEF_DOSAGE_YN")==null?"":(String)drugDetails.get("DEF_DOSAGE_YN");  //Added for AAKH-CRF-0089 ends
					String strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
					String strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
					String form_code			= (String)drugDetails.get("FORM_CODE");
					String pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
					String pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
					String freq_code			= (String)drugDetails.get("FREQ_CODE");
					String durn_value			= (String)drugDetails.get("DURN_VALUE");
					String or_durn_desc			= (String)drugDetails.get("OR_DURN_DESC");
					//String auth_yn_val			= (String)drugDetails.get("AUTH_YN_VAL");
					//String approval_yn_val		= (String)drugDetails.get("APPROVAL_YN_VAL");
					//String cosign_yn_val		= (String)drugDetails.get("COSIGN_YN_VAL");
					String auth_yn				= (String)drugDetails.get("AUTH_YN");
					String approval_yn			= (String)drugDetails.get("APPROVAL_YN");
					String cosign_yn			= (String)drugDetails.get("COSIGN_YN");
					String consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
					String order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
					String fract_dose_appl_yn	= (String)drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_APPL_YN");
					String route_code			= (String)drugDetails.get("ROUTE_CODE");
					String startdate			= (String)drugDetails.get("START_DATE");// Added for ML-BRU-SCF-0811 [IN:039394]
					String end_date				= (String)drugDetails.get("END_DATE");
					String dup_drug_desc		= (String)drugDetails.get("CURRENTRX_REMARKS");
					String allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS");
					String exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS");
					String dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");
					String bms_qty				= (String)drugDetails.get("BMS_QTY");
					String dflt_qty_uom			= (String)drugDetails.get("DFLT_QTY_UOM");
					String tab_qty_value		= (String)drugDetails.get("TAB_QTY_VALUE");
					String qty_desc_code		= (String)drugDetails.get("QTY_DESC_CODE");
					String amend_yn				= (String)drugDetails.get("AMEND_YN");
					String qty_value			= (String)drugDetails.get("QTY_VALUE");
					String dosage_unit			= (String)drugDetails.get("DOSAGE_UNIT");
					String ord_auth_reqd_yn		= (String) drugDetails.get("ORD_AUTH_REQD_YN")==null?"":(String) drugDetails.get("ORD_AUTH_REQD_YN");
					String ord_spl_appr_reqd_yn	= (String) drugDetails.get("ORD_SPL_APPR_REQD_YN")==null?"":(String) drugDetails.get("ORD_SPL_APPR_REQD_YN");
					String ord_cosign_reqd_yn	= (String) drugDetails.get("ORD_COSIGN_REQD_YN")==null?"":(String) drugDetails.get("ORD_COSIGN_REQD_YN");
					String ord_authorized_yn	= (String) drugDetails.get("ORD_AUTHORIZED_YN")==null?"":(String) drugDetails.get("ORD_AUTHORIZED_YN");
					String ord_authorized_prev_yn	= (String) drugDetails.get("ORD_AUTHORIZED_PREV_YN")==null?"":(String) drugDetails.get("ORD_AUTHORIZED_PREV_YN");
					String ord_approved_yn		= (String) drugDetails.get("ORD_APPROVED_YN")==null?"":(String) drugDetails.get("ORD_APPROVED_YN");
					String ord_cosigned_yn		= (String) drugDetails.get("ORD_COSIGNED_YN")==null?"N":(String) drugDetails.get("ORD_COSIGNED_YN");
					String sRegRopt				= (String)drugDetails.get("REQD_OR_OPT_IND"); 
					String strength_per_value_pres_uom  = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
					if(drug_abuse_appl){
					abuse_exists=(String)drugDetails.get("ABUSE_EXISTS")==null?"N":(String)drugDetails.get("ABUSE_EXISTS"); //Added for AAKH-CRF-0140
					abuse_action=(String)drugDetails.get("ABUSE_ACTION")==null?"U":(String)drugDetails.get("ABUSE_ACTION"); //Added for AAKH-CRF-0140
					abuse_restric_trn=(String)drugDetails.get("ABUSE_RESTRIC_TRN")==null?"N":(String)drugDetails.get("ABUSE_RESTRIC_TRN"); //Added for AAKH-CRF-0140
					abuse_override_remarks=(String)drugDetails.get("abuse_drug_override_reason")==null?"":(String)drugDetails.get("abuse_drug_override_reason"); //Added for AAKH-CRF-0140
					abuse_override_remarks1=(String)drugDetails.get("abuse_override_remarks")==null?"":(String)drugDetails.get("abuse_override_remarks"); //Added for AAKH-CRF-0140
					
					abuse_override=(String)drugDetails.get("ABUSE_OVERRIDE")==null?"U":(String)drugDetails.get("ABUSE_OVERRIDE"); //Added for AAKH-CRF-0140
					System.out.println("333 abuse_restric_trn"+abuse_restric_trn);
					System.out.println(abuse_override_remarks1+"334 abuse_override_remarks"+abuse_override_remarks);
					}
					else{
						abuse_exists="N";
						abuse_action="U";
						abuse_restric_trn="N";
						abuse_override_remarks="";//added for aakh-crf-0140
						abuse_override="";//added for aakh-crf-0140
					}
					//added for MMS-DM-CRF-0204 START
					String diagnosis_found_yn="";
                     diagnosis_found_yn=(String)drugDetails.get("DIAGNOSIS_FOUND_YN");//mms-dm-crf-0204	
							if(req_diag_pres_found){
								 diagnosis_found_yn=(String)drugDetails.get("DIAGNOSIS_FOUND_YN");//mms-dm-crf-0204	
										
							}
							else{
								diagnosis_found_yn="G";
							}
							//added for MMS-DM-CRF-0204 END
					String strength_per_pres_uom		= (String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
					String DrugIndicationRemarks				= (String)drugDetails.get("DRUG_INDICATION")==null?"":(String) drugDetails.get("DRUG_INDICATION");//Added for  ML-BRU-CRF-072[Inc:29938]  
					if(!DrugIndicationRemarks.equals(""))
						DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8");
					String ext_prod_id			= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
					/*	if(bean.getPatientClass()!=null && bean.getPatientClass().equals("IP")){//IN30118-SCF No: MO-GN-5400. Assingning OutPatient Duplicate Drug Check.
								allow_duplicate		= (String)drugDetails.get("ALLOW_DUPLICATE_DRUG");
						}else if(bean.getPatientClass()!=null && bean.getPatientClass().equals("OP")){
							allow_duplicate = (String) drugDetails.get("ALLOW_DUPLICATE_DRUG_OP");
						}*/ 	//commented all for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
					String calc_dose_based_on	= (String)drugDetails.get("CALC_DOSE_BASED_ON");
					String calc_dose_value		= "";
					String calc_dose_by			= "KG";
					String select_calc_dose_Dosage="checked";
					String select_calc_dose_WT_BSA="";
					String kg_selected			="Selected";
					String m2_selected			="";
					String displaydose			="";
					String displayBSA			="style='display:none'";
					String disable_calc_dose	="";
					//===============================//
					if(calc_dose_based_on!=null && calc_dose_based_on.equals("B")) // calculate the dose based on the BSA or Weight
					{
						select_calc_dose_Dosage="";
						select_calc_dose_WT_BSA="checked";
						
						calc_dose_value	= (String)drugDetails.get("CALC_DOSE_VALUE");
						calc_dose_by	= (String)drugDetails.get("CALC_DOSE_BY");
						displaydose		= "style='display:none'";
						displayBSA		= "";
						if(calc_dose_by.equals("M2"))
						{
							kg_selected	=	"";
							m2_selected	=	"Selected";
						}
					}

					drug_db_dosage_check_flag				= (String) drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	
					perform_external_database_checks_yn		= (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");		
					loading_ext_prod_id						= ext_prod_id;
					external_dosage_override_reason			= (String) drugDetails.get("EXTERNAL_DOSAGE_OVERRIDE_REASON");	
					external_duplicate_override_reason		= (String) drugDetails.get("EXTERNAL_DUPLICATE_OVERRIDE_REASON");
					external_interaction_override_reason	= (String) drugDetails.get("EXTERNAL_INTERACTION_OVERRIDE_REASON");
					external_contra_override_reason			= (String) drugDetails.get("EXTERNAL_CONTRA_OVERRIDE_REASON");
					external_alergy_override_reason			= (String) drugDetails.get("EXTERNAL_ALERGY_OVERRIDE_REASON");
					
					//Added for MMS-DM-CRF-0177
					drug_search = (String) drugDetails.get("DRUG_SEARCH_BY")==null?"":(String) drugDetails.get("DRUG_SEARCH_BY");
					if(pre_alloc_appl.equals("Y") && drug_search.equals("G") && !mode.equals("amend"))
					{
						new_generic_name= (String)drugDetails.get("DRUG_DESC_NEW")==null?"":(String)drugDetails.get("DRUG_DESC_NEW");
					}
					else
					{
						new_generic_name= drug_desc;
					}
					//Added for MMS-DM-CRF-0177
					
					HashMap practRights	= (HashMap)bean.getAuthorizationReqd(resp_id, pract_id);
					String dflt_code	= "";
					String pack_values	=	bean.getInfuseOverValue(drug_code,"");//Added "" for ML-MMOH-CRF-1223
					StringTokenizer st1	=	new StringTokenizer(pack_values,"::");
					String pack_size	=	"";

					if(fract_dose_appl_yn.equals("N"))
						dose_decimal = 0;
					if(recomm_dosage_by.equals("B"))
						recomm_dosage_by = "Q";

					if(st1.hasMoreTokens()) {
						st1.nextToken(); st1.nextToken(); st1.nextToken();
						pack_size	=	st1.nextToken();
					}

					if (!classValue.equals("AMENDEDDRUGS")) {
					
						String orgLineNum	= Integer.toString(srlNo+1);
						HashMap qtyValues	=	bean.getQtyValue(patient_id,order_id,orgLineNum);
						dflt_code			= (String)qtyValues.get("strengthUom")==null?"":(String)qtyValues.get("strengthUom");
						if((bean.getOrder_type_flag()).equals("Existing")) 
							qty_desc_code = dflt_code;
					}
					//TDM

					String tdmOrder_id		= "";
					String display_tdm		= "display:none";
					if(drugDetails.get("TDM_ORDER_ID")== null){
						tdmOrder_id				= bean.getOrderIdForTDMDtls(patient_id,drug_code);
						drugDetails.put("TDM_ORDER_ID",tdmOrder_id);
					}
					else 
						tdmOrder_id = (String)drugDetails.get("TDM_ORDER_ID");

					if(tdmOrder_id==null||tdmOrder_id.equals("")){
						display_tdm			="display:none";
					}else{
						display_tdm			="display:inline";
					} 

						//code for drug interaction check
					HashMap drug_Interactions				= null;
					String drug_db_interact_check_flag	= "N";
					String drug_db_duptherapy_flag		= "N";
					String drug_db_contraind_check_flag	= "N";
					String dup_drug_det					= "";

					if(perform_external_database_checks_yn.equals("Y")){
/*
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
							dup_drug_det			= beanex.isDuplicateTherapy(ext_prod_id);//get dupluicate theraphy result
							if(!dup_drug_det.equals("")&&dup_drug_det!=null)
								drug_db_duptherapy_flag="Y";
						}

						if(drug_db_contraind_check_yn.equals("Y")){
							ArrayList ex_prod_ids =new ArrayList();
							ex_prod_ids.add(loading_ext_prod_id);

							boolean flag = beanex.isContraDrugMedicalCondition(ex_prod_ids,patient_id);
							HashMap contra_indications =(HashMap)beanex.getContraIndications();
							if(contra_indications.containsKey(ext_prod_id)){
							// String  contra_indication_for_drug   =(String)contra_indications.get(ext_prod_id);
								drug_db_contraind_check_flag="Y";
							}					  
						}  
*/
						if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")){
							String storeIDs = "N";
							HashMap tempDetails= null;
							/*ArrayList reqChecks = new ArrayList();
							reqChecks.add("N"); //Dosage Check 
							reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
							reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
							reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
							reqChecks.add("N"); //AllergyCheck  - is done in IVPiggyBackDrugDetails.jsp
							HashMap drugDosageResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", null ,null, null, storeIDs); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
*/
							HashMap drugDBCheckResult = (HashMap)beanex.getExternalDBCheckResult(ext_prod_id, srl_no);
							if(drugDBCheckResult==null){
								ArrayList reqChecks = new ArrayList();
								reqChecks.add("N"); //Dosage Check 
								reqChecks.add(drug_db_duptherapy_yn); //Duplicate Check
								reqChecks.add(drug_db_interact_check_yn); //DrugInteraction
								reqChecks.add(drug_db_contraind_check_yn); //Contra Indication
								reqChecks.add("N"); //AllergyCheck  - is done in IVPiggyBackDrugDetails.jsp
								drugDBCheckResult = (HashMap)beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", null ,null, null, storeIDs, startdate, end_date); //Parameters (AL)requiredchecks, ext_proID, PatienId, OrderID, (AL)ExtProdIDlist, (AL)DrugDescs (AL)DoseCheckParams, Y/N to store EXTID list in EXTbean 
								if(drugDBCheckResult!=null)
									beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
							}
							drug_db_interact_check_flag="N";
							drug_db_duptherapy_flag="N";
							drug_db_contraind_check_flag="N";
							if(drugDBCheckResult!=null){
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
									if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS
										tempDetails = (HashMap)drugDBCheckResult.get("HEALTHINTRACHECK");	 /* Added in JUNE 2012 - New changes - Health Care Interaction */

			System.err.println("----------tempDetails"+tempDetails);
									if(tempDetails!=null && tempDetails.size()>0){ //IN066787- Performance
										 drug_db_contraind_check_flag="Y";
									}
									
									}
									else{
										tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
										if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
											drug_db_contraind_check_flag="Y";
										}	
									}
								}
							}
						}
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
						drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
					}
										
%>
					<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
						<TR>
							<TD WIDTH="15%" CLASS="label"><fmt:message key="ePH.Additive.label" bundle="${ph_labels}"/>&nbsp;</TD>
							<TD WIDTH="*" colspan='3'>
<%-- 								<INPUT TYPE="text" name="DRUG_NAME" id="DRUG_NAME" VALUE="<%= drug_desc %>" SIZE="45" MAXLENGTH="40" DISABLED><INPUT TYPE="button" CLASS="button" name="DRUG_SEARCH" id="DRUG_SEARCH" VALUE="?" onfocus="searchIVDrugs('D', DRUG_NAME)" onClick="searchIVDrugs('D', DRUG_NAME)" DISABLED> --%><!-- commented for SKR-SCF-1317 -->
 								<INPUT TYPE="text" name="DRUG_NAME" id="DRUG_NAME" VALUE="<%=new_generic_name%>" SIZE="45" MAXLENGTH="40" DISABLED><INPUT TYPE="button" CLASS="button" name="DRUG_SEARCH" id="DRUG_SEARCH" VALUE="?"  onClick="searchIVDrugs('D', DRUG_NAME)" DISABLED> <!-- REMOVED  onfocus for SKR-SCF-1317--> <!-- Modified for MMS-DM-CRF-0177 -->

								 <img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails(DRUG_CODE.value);" id="edlImg">
<%
								if (iv_option.equals("Y")) {
%>
									<IMG ID="mandate_drug" SRC="../../eCommon/images/mandatory.gif" BORDER="0"></IMG>
<%
								}
%>
							</td>
							<TD WIDTH="10%" colspan='6' TITLE='<fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.Result.label" bundle="${common_labels}"/>' >&nbsp;&nbsp;&nbsp;<A HREF style="<%=display_tdm%>" onMouseOver="changeCursor(this);" onclick="viewReasonforRequest('<%=tdmOrder_id%>');"><fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/></A>&nbsp;</TD>	
							
						</TR><%if(strength_value.equals("0")){				
							select_calc_dose_Dosage ="checked";
							select_calc_dose_WT_BSA ="";
							disable_calc_dose		="disabled";						

						}
						//added for nmc-jd-crf-0026 start
						if(strength_display_app){
						%>
						
						<td class="label"   width="15%"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
						<%if(act_strength_value!=null && act_strength_value!="" && !act_strength_value.equals("0")){%>
						<td colspan=8 class="data" id="strength" width="20%">&nbsp;<%=act_strength_value%>&nbsp;<%=strength_uom_desc%> / <%=strength_per_value_pres_uom%>&nbsp;<%=bean.getUomDisplay((String)session.getValue("facility_id"),pres_base_uom)%></td>
						<%}%> 
						<TR>
						<%}//added for nmc-jd-crf-0026 end
						%>
						<TD colspan=10><TABLE border=0><TR>	
											
						<TD CLASS="label"><fmt:message key="ePH.CalculateBy.label" bundle="${ph_labels}"/></TD>
						<TD CLASS="label"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/><input type="radio" id="CALC_DOSE_BASED_ON_D" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="D" <%=select_calc_dose_Dosage%> <%=disable_calc_dose%>  onClick="setCalculateBy(this,'IVAD_NORMAL');"></TD>
						<TD CLASS="label"><fmt:message key="ePH.BodywtBSA.label" bundle="${ph_labels}"/><input type="radio" id="CALC_DOSE_BASED_ON_B" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="B" <%=select_calc_dose_WT_BSA%> <%=disable_calc_dose%>  onClick="setCalculateBy(this,'IVAD_NORMAL');">

<!-- on click of the same radio button the value was getting changed. to avoid that, we have introduced this hidden var-->
						<input type=hidden name="current_CALC_DOSE_BASED_ON" id="current_CALC_DOSE_BASED_ON" value="<%=select_calc_dose_Dosage.equals("checked")?'D':'B'%>">
						
						</TD>
						<% //GHL-CRF-0549 - start
							disp_by_alt_form_param     = bean.getParamDispByAltForm();
						
							disp_by_alt_form_drug     = (String) drugDetails.get("DISP_ALT_FORM_YN")==null?"N":(String) drugDetails.get("DISP_ALT_FORM_YN");
						if(item_type_site_app){
						allow_alternate_yn = (String) drugDetails.get("allow_alternate")==null?"N":(String) drugDetails.get("allow_alternate"); //GHL-CRF-0549
						if(disp_by_alt_form_param.equals("Y") && disp_by_alt_form_drug.equals("Y"))
						{
							item_type = bean.getItemType(drug_code);
							mm_item_low_cost_yn = item_type.split("~")[0];
							mm_item_high_margin_yn = item_type.split("~")[1];
							mm_item_Innovator_yn = item_type.split("~")[2];
							if(mm_item_low_cost_yn.equals("Y") || mm_item_high_margin_yn.equals("Y")){
								checked = "checked";
							}else{
								checked = "";
							} 
							
							if(mm_item_Innovator_yn.equals("Y")) //GHL-SCF-1430
								checked = "";
							
							if(!mm_item_low_cost_yn.equals("Y") && !mm_item_high_margin_yn.equals("Y") && !mm_item_Innovator_yn.equals("Y")){ //4/24/2019
								checked = "checked";
							}//GHL-SCF-1430 - end

							allow_alternate_disabled = "";
						
						}else{
							allow_alternate_disabled = "disabled";
						}
						if(allow_alternate_yn.equals("Y")) 
							checked = "checked";
						
					} 	//GHL-CRF-0549 - end
					if(item_type_site_app && disp_by_alt_form_param.equals("Y")){ //GHL-CRF-549
%>					<td CLASS="label"><fmt:message key="ePH.AllowAlternate.label" bundle="${ph_labels}"/>&nbsp;
					<input type='checkbox' name='allow_alternate_yn' id='allow_alternate_yn' value='<%=allow_alternate_yn%>' <%=allow_alternate_disabled%> <%=checked%> > </td><!-- GHL-CRF-0549-->
<%
					}
%>
						</TR></TABLE></TD>
						</TR><TR <%=displaydose%> id="calc_by_row1">
							<INPUT TYPE="hidden" name="DRUG_CODE" id="DRUG_CODE" VALUE="<%= drug_code %>">
							<TD WIDTH="15%"  CLASS="label" nowrap><fmt:message key="Common.DosageBy.label" bundle="${common_labels}"/></TD>
							<TD WIDTH="25%" ><SELECT name="DOSAGE" id="DOSAGE" onChange="changeScrDetails(this.value);ExternalDosageCheck('','presc');setEmptyDose();" <%=disaExst%> >    <!-- setEmptyDose() is added for AAKH-CRF-0089  -->
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
<%
							String str_value = "";
							if (strength_value.equals("0")) {
								disabled	= "";
								str_value	= pres_qty_value;
%>
								<TD WIDTH="10%" CLASS="label" ID="DOSAGE_LABEL"><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/></TD>
<%
							}
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

							if(str_value != null && str_value != "" && Float.parseFloat(str_value) < 1.0){
								str_value = Float.parseFloat(str_value)+"";
							}
%>
							<TD colspan='4' nowrap>

 								<%--<INPUT TYPE="text" name="STRENGTH_VALUE" id="STRENGTH_VALUE"  VALUE="<%= str_value %>" SIZE="10" MAXLENGTH="11" onBlur="setCalculatedQty(this); DosageLimitCheck(this);" <%=disaExst%> onKeyPress="return(ChkNumberInput(this,event,'<%=dose_decimal%>'))" class="number" >&nbsp;<SELECT name="STRENGTH_UOM" id="STRENGTH_UOM" <%= disabled %> onChange="setQtyUOM(this.value);setDrugDosageDetails();" <%=disaExst%>> --%><!-- commented and added checkBeforeDecimal() and allowValidNumber() functions for ML-BRU-SCF-1437 -->
								
								<INPUT TYPE="text" id='id_qty_value' name="STRENGTH_VALUE" id="STRENGTH_VALUE"  VALUE="<%= str_value %>" SIZE="10" MAXLENGTH="13" onChange="setCalculatedQty(this); DosageLimitCheck(this);" <%=disaExst%> onKeyPress="checkBeforeDecimal(this,event); return allowValidNumber(this,event,8,<%=dose_decimal%>);"  class="number" >&nbsp;<SELECT name="STRENGTH_UOM" id="STRENGTH_UOM" <%= disabled %> onChange="setQtyUOM(this.value);setDrugDosageDetails();" <%=disaExst%>>   <!-- onBlur is changed to onChange and setEmptyDose() is included for AAHH-CRF-0089 -->
									
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
										Hashtable QtyDescDetails	= (Hashtable)bean.listQtyDetails(drug_code);
										Enumeration keys_des		= QtyDescDetails.keys();
										String uom_code				= "";
										String uom_desc				= "";
										String def_uom				= "";

										while(keys_des.hasMoreElements()) {
											uom_code	= (String)keys_des.nextElement();
											uom_desc	= (String)QtyDescDetails.get(uom_code);

											if(!uom_code.equals("dflt_code")) {
												if(uom_code.equals(qty_desc_code))
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
									Hashtable QtyDescDetails	= (Hashtable)bean.listQtyDetails(drug_code);
									Enumeration keys_des		= QtyDescDetails.keys();
									String uom_code				= "";
									String uom_desc				= "";
									String def_uom				= "";

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
<%
							//String inf_uom = "";
							int srlNum		= Integer.parseInt(srl_no)-1;
							String inf_val	= bean.getInfRate(Integer.toString(srlNum), 3);

							if (strength_value.equals("0")) {
								disabled = "DISABLED";
							}
							else {
								if(dosage_type.equals("S")) {
									//inf_uom = strength_uom_desc;
									disabled = "";

									if(!inf_val.equals("") && !(bean.getInfRate(Integer.toString(srlNum), 1).equals(Integer.toString(srlNum)))){
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
%>
							&nbsp;<a href="#" onMouseOver="changeCursor(this);" id="drug_remarks" onClick="getFormatId('Drug','Y')"> <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></A>&nbsp;&nbsp;
							        <!-- added for [IN:039576]-start -->
							        <img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'></img>
									<input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
									<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>&nbsp;&nbsp;
									<!-- added for [IN:039576]-end -->
							<a href="#" onMouseOver="changeCursor(this);"  id="drug_ind_remarks" onClick="drugindication_remarks()"><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a></TD><!--Added for  ML-BRU-CRF-072[Inc:29938]-->
							<INPUT TYPE="hidden" name="INF_VAL" id="INF_VAL" VALUE="<%= bean.getInfRate(Integer.toString(srlNum), 2) %>">
						</TR>							
						<TR <%=displayBSA%> id="calc_by_row2">
							<TD CLASS="label"><fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/></TD>
							<TD colspan="3"><input type="text" name="CALC_DOSE_VALUE" id="CALC_DOSE_VALUE" value="<%=calc_dose_value%>" size="5" maxlength="8" onKeyPress="return allowValidNumber(this,event,4,3);" onBlur="calculateDosage_By_BSA_or_Weight('IVAD_NORMAL');DosageLimitCheck(this);" class="number"><!-- Modified for IN:070451  -->
							<select name="calc_dose_value_unit" id="calc_dose_value_unit"><OPTION VALUE="<%=strength_uom%>"><%= strength_uom_desc%></OPTION></select><label class="label"><b> / </b></label><select name="CALC_DOSE_BY" id="CALC_DOSE_BY" onChange="calculateDosage_By_BSA_or_Weight('IVAD_NORMAL');"><option value="KG" <%=kg_selected%>><fmt:message key="ePH.KG.label" bundle="${ph_labels}"/></option><option value="M2" <%=m2_selected%>><fmt:message key="ePH.M2.label" bundle="${ph_labels}"/></option></select><label class="label"><b> = </b></label><INPUT TYPE="text" name="strength_value_wt_bsa" id="strength_value_wt_bsa"  VALUE="<%=qty_value%>" SIZE="10" MAXLENGTH="12" onKeyPress="return allowValidNumber(this,event,8,3);" class="number"  onBlur="assignStrengthForBSA();setCalculatedQty(this); DosageLimitCheck(this);">&nbsp;<label class="label"> <b><%=strength_uom_desc%></b></label>
							<img src="../../eCommon/images/mandatory.gif" BORDER="0"></img></TD>
							<TD WIDTH="10%" CLASS="label"></TD>							
						</TR>

<%
						if(drugDetails.get("RECOMM_YN").equals("Y")) {
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

					</TABLE>
					<!-- Duplicate medication warning starts-->
<%	
	//commented all for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
//					if((current_rx.equals("Y") && allow_duplicate.equals("N"))) {//IN30118-SCF No: MO-GN-5400. Removed condition patient_class.equals("IP").	
		//commented all for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
/*
							String dup_drug_info	=	"";
							ArrayList curr_info		=	bean.getDuplicateDrugs(patient_id,generic_id);
							HashMap  dup_info		=	null;

							if(curr_info.size()>=1) {
								dup_info	  =	(HashMap)curr_info.get(0);
								dup_drug_info = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PatientisCurrentlyOn.label","ph_labels")+" "+generic_name+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Medicationtill.label","ph_labels")+dup_info.get("end_date")+";\n";
								dup_drug_info =  dup_drug_info + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Hasbeenprescribedby.label","ph_labels")+dup_info.get("practitioner_name")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.from.label","ph_labels")+dup_info.get("location");
							}*/
				//	} //Marque HTML code also remmoved  for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
%>
					<!-- Duplicate medication warning ends-->

					<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
						<TR>
<%
							display_auth_rule = "visibility:hidden";
							if(ord_auth_reqd_yn != null && ord_auth_reqd_yn.equals("Y")){
								display_auth_rule	= "visibility:visible";
								color_auth_rule		= "color:red";
								if(ord_authorized_yn.equals("Y"))
									color_auth_rule = "color:green";
							}
%>
							<td class="label" align='center'><label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></label></td>
<%
							display_auth_rule	= "visibility:hidden";
							color_auth_rule		= "color:red";
							if(ord_spl_appr_reqd_yn != null && ord_spl_appr_reqd_yn.equals("Y")){
								display_auth_rule = "visibility:visible";
								if(ord_approved_yn.equals("Y"))
									color_auth_rule = "color:green";
							}
%>
							<td class="label"  align='center' colspan='2'><label id='lbl_splapprvl' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="ePH.splapproval.label" bundle="${ph_labels}"/></label></td>
<%
							display_auth_rule = "visibility:hidden";
							color_auth_rule   = "color:red";
							if(ord_cosign_reqd_yn != null && ord_cosign_reqd_yn.equals("Y")){
								display_auth_rule = "visibility:visible";
								if(ord_cosigned_yn.equals("Y"))
									color_auth_rule = "color:green";
							}
%>
							<td class="label" align='center'><label id='lbl_cosign' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></label></td>
<%
							if (drugDetails.get("CONSENT_REQD_YN").equals("Y")) {
%>
								<TD WIDTH="15%" CLASS="eORConsent" ID="consent" TITLE="Consent Required"><FONT COLOR="#0066CC" SIZE="1"><B><fmt:message key="ePH.ConsentReqd..label" bundle="${ph_labels}"/></B></FONT></TD>
<%
							}
							else {
%>
								<TD WIDTH="15%" CLASS="label" ID="consent">&nbsp;</TD>
<%
							}
%>
						</TR>
					</TABLE>
					<INPUT TYPE="hidden" name="GENERIC_ID" id="GENERIC_ID" VALUE="<%= generic_id %>">
					<INPUT TYPE="hidden" name="GENERIC_NAME" id="GENERIC_NAME" VALUE="<%= generic_name %>">
					<INPUT TYPE="hidden" name="DAILY_DOSE" id="DAILY_DOSE" VALUE="<%= daily_dose %>">
					<INPUT TYPE="hidden" name="UNIT_DOSE" id="UNIT_DOSE" VALUE="<%= unit_dose %>">
					<INPUT TYPE="hidden" name="MONO_GRAPH" id="MONO_GRAPH" VALUE="<%= mono_graph %>">
					<INPUT TYPE="hidden" name="LIMIT_IND" id="LIMIT_IND" VALUE="<%= limit_ind %>">
					<INPUT TYPE="hidden" name="dosage_std" id="dosage_std" VALUE="<%= dosage_std %>">
					<INPUT TYPE="hidden" name="dosage_unit" id="dosage_unit" VALUE="<%= dosage_unit %>">
					<INPUT TYPE="hidden" name="recomm_dosage_by" id="recomm_dosage_by" VALUE="<%= recomm_dosage_by %>">
					<INPUT TYPE="hidden" name="calc_by_ind" id="calc_by_ind" VALUE="<%= calc_by_ind %>">
					<INPUT TYPE="hidden" name="recomm_yn" id="recomm_yn" VALUE="<%= drugDetails.get("RECOMM_YN")==null?"":drugDetails.get("RECOMM_YN") %>">
					<INPUT TYPE="hidden" name="ALLERGY_YN" id="ALLERGY_YN" VALUE="<%= allergy_yn %>">
					<INPUT TYPE="hidden" name="CURRENT_RX" id="CURRENT_RX" VALUE="<%= current_rx %>">
					<INPUT TYPE="hidden" name="SRL_NO" id="SRL_NO" VALUE="<%= srl_no %>">
					<INPUT TYPE="hidden" name="FORM_CODE" id="FORM_CODE" VALUE="<%= form_code %>">
					<INPUT TYPE="hidden" name="PRES_QTY_VALUE" id="PRES_QTY_VALUE" VALUE="<%= pres_qty_value %>">
					<INPUT TYPE="hidden" name="PRES_BASE_UOM" id="PRES_BASE_UOM" VALUE="<%= pres_base_uom %>">
					<INPUT TYPE="hidden" name="FREQ_CODE" id="FREQ_CODE" VALUE="<%= freq_code %>">
					<INPUT TYPE="hidden" name="DURN_VALUE" id="DURN_VALUE" VALUE="<%= durn_value %>">
					<INPUT TYPE="hidden" name="DURN_TYPE" id="DURN_TYPE" VALUE="H">
					<INPUT TYPE="hidden" name="OR_DURN_DESC" id="OR_DURN_DESC" VALUE="<%= or_durn_desc %>">
					<INPUT TYPE="hidden" name="ORD_APPROVED_YN" id="ORD_APPROVED_YN" VALUE="<%= ord_approved_yn %>" ><!--APPROVAL_YN_VAL renamed as ORD_APPROVED_YN for HSA-SCF-0149 [IN:051784] -->
					<INPUT TYPE="hidden" name="ORD_AUTHORIZED_YN" id="ORD_AUTHORIZED_YN" VALUE="<%= ord_authorized_yn %>"> <!--AUTH_YN_VAL renamed as ORD_AUTHORIZED_YN for HSA-SCF-0149 [IN:051784] -->
					<INPUT TYPE="hidden" name="ORD_COSIGNED_YN" id="ORD_COSIGNED_YN" VALUE="<%= ord_cosigned_yn %>"> <!--COSIGN_YN_VAL renamed as ORD_COSIGNED_YN for HSA-SCF-0149 [IN:051784] -->
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
<!--					<INPUT TYPE="hidden" name="STR_VAL" id="STR_VAL" VALUE="<%= strength_value %>">-->
					<INPUT TYPE="hidden" name="STR_VAL" id="STR_VAL" VALUE="<%= str_value %>">
					<INPUT TYPE="hidden" name="BMS_QTY" id="BMS_QTY" VALUE="<%= bms_qty %>">
					<INPUT TYPE="hidden" name="DFLT_QTY_UOM" id="DFLT_QTY_UOM" VALUE="<%= dflt_qty_uom %>">
					<INPUT TYPE="hidden" name="TAB_QTY_VALUE" id="TAB_QTY_VALUE" VALUE="<%= tab_qty_value %>">
					<INPUT TYPE="hidden" name="QTY_DESC_CODE" id="QTY_DESC_CODE" VALUE="<%= qty_desc_code %>">
					<INPUT TYPE="hidden" name="MIN_DAILY_DOSE" id="MIN_DAILY_DOSE" VALUE="<%= min_daily_dose %>">
					<INPUT TYPE="hidden" name="MIN_UNIT_DOSE" id="MIN_UNIT_DOSE" VALUE="<%= min_unit_dose %>">
						<!-- Added for IN:070451 start -->
				<input type="hidden" name="max_daily_ceeling_dose" id="max_daily_ceeling_dose" value="<%=max_daily_ceeling_dose%>">
				<input type="hidden" name="min_daily_ceeling_dose" id="min_daily_ceeling_dose" value="<%=min_daily_ceeling_dose%>">
				<input type="hidden" name="max_unit_ceeling_dose" id="max_unit_ceeling_dose" value="<%=max_unit_ceeling_dose%>">
				<input type="hidden" name="min_unit_ceeling_dose" id="min_unit_ceeling_dose" value="<%=min_unit_ceeling_dose%>">
				
				<!-- Added for IN:070451 end  -->
					<!-- Added for IN:072715 start -->		
      				 <input type="hidden"  name="allergy_remarks_code" id="allergy_remarks_code" value="<%=allergy_remarks_code%>">
       				 <input type="hidden"  name="dose_remarks_code" id="dose_remarks_code" value="<%=dose_remarks_code%>">
      				 <input type="hidden"  name="currentrx_remarks_code" id="currentrx_remarks_code" value="<%=currentrx_remarks_code%>">
      			 <!-- Added for IN:072715 end -->
					<INPUT TYPE="hidden" name="STR_DESC" id="STR_DESC" VALUE="">
					<input type="hidden" name="pack_size" id="pack_size" value="<%=pack_size%>">
					<input type="hidden" name="license" id="license" value="<%=license%>">
					<input type="hidden" name="sRegRopt" id="sRegRopt" value="<%=sRegRopt%>">
					<input type="hidden" name="ORDERSET_STRENGTH" id="ORDERSET_STRENGTH" value="<%=str_value%>">
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
					<input type="hidden" name="amend_yn" id="amend_yn" value="<%=amend_yn%>">
					<input type="hidden" name="saved_dosage_type" id="saved_dosage_type" value="<%=dosage_type%>">
					<input type="hidden" name="DrugIndicationRemarks" id="DrugIndicationRemarks" value="<%=DrugIndicationRemarks%>"><!--Added for  ML-BRU-CRF-072[Inc:29938]-->
					<input type="hidden" name="def_dosage_yn" id="def_dosage_yn" value="<%=def_dosage_yn%>">   <!--Added for AAKH-CRF-0089 -->
				<input type="hidden" name="abuse_restric_trn" id="abuse_restric_trn" value="<%=abuse_restric_trn%>"> <!-- added for aakh-crf-0140 -->
					<input type="hidden" name="abuse_exists" id="abuse_exists"  value="<%=abuse_exists%>"><!-- added for aakh-crf-0140 -->
					<input type="hidden" name="ABUSE_OVERRIDE" id="ABUSE_OVERRIDE"  value="<%=abuse_override%>"><!-- added for aakh-crf-0140 -->
					<input type="hidden" name="abuse_override_remarks" id="abuse_override_remarks"  value="<%=abuse_override_remarks1%>"><!-- added for aakh-crf-0140 -->
					<input type="hidden" name="abuse_drug_override_reason" id="abuse_drug_override_reason"  value="<%=abuse_override_remarks%>"><!-- added for aakh-crf-0140 -->
					<input type="hidden" name="diagnosis_found_yn" id="diagnosis_found_yn"  value="<%=diagnosis_found_yn%>"><!-- added for MMS-DM-CRF-0204-->
					
<input type="hidden" name="abuse_action" id="abuse_action"  value="<%=abuse_action%>">	<!-- added for aakh-crf-0140 -->
				<input type="hidden" name="item_type_site_app" id="item_type_site_app" value="<%=item_type_site_app%>">
				<input type="hidden" value="<%=validate_overide_on_confirm_yn%>" name="validate_overide_on_confirm_yn"><!-- Added for IN:069887  -->
					<SCRIPT>
						DisableEnableDoseUOM();
						loadButtonsFrame();
						getFormatId('Drug','N');
					<%	if((abuse_exists.equals("Y") && abuse_action.equals("B") && !(bean.getOrder_type_flag().equals("Existing") || classValue.equals("AMENDEDDRUGS")))){
						System.out.println("1028 mode"+mode);
						%>
						showAbuseDetails('', '<%= patient_id %>',' <%=encounter_id %>', '','<%=drug_code%>','Alert');
						<%} 
					if(req_diag_pres_found && diagnosis_found_yn.equals("N")){ // added for mms-dm-crf-0204
					%>
					    callCancel();
					
						<%}
						%>
					
						</SCRIPT>
<%
System.out.println("1042"+bean.getOrder_type_flag().equals("Existing"));	
						System.out.println("1042"+classValue);	
if(!(bean.getOrder_type_flag().equals("Existing") || classValue.equals("AMENDEDDRUGS"))) //if condition added and comment removed from below line (strength value was coming as null) --08/10/2010-- priya   //classValue.equals("AMENDEDDRUGS") was added coz when dose value was changed and confirmed, then when reloading the default value was geting loaded.
					{
%>
					<SCRIPT>
						changeScrDetails(document.formIVPrescriptionDrugDetails.DOSAGE.value);  // commented for IN23745 --14/09/2010-- priya 
						document.formIVPrescriptionDrugDetails.STRENGTH_VALUE.focus();
					
					</SCRIPT>
		<!-- Hidden values ends-->
<%
					}
					if(!mode.equals("blank")&& perform_external_database_checks_yn.equals("Y")){		  
						if(drug_db_dosecheck_yn.equals("Y")){
%>
							<script>
								ExternalDosageCheck('ONLOAD','presc');
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
					
					//AAKH-CRF-0089 starts
					
					if(def_dosage_yn.equals("N") && amend_yn.equals("N") && !(bean.getOrder_type_flag().equals("Existing"))){
					%>	
						<script>
						document.formIVPrescriptionDrugDetails.STRENGTH_VALUE.value="";
						</script>
					<%	
					}
					//AAKH-CRF-0089 ends
				}
%>
			</FORM>
		</BODY>
		<script> 
<% 
	//commented all for IN30118-SCF No: MO-GN-5400 - dulplicate control based on parameter is applicable only for normal RX
			//if(current_rx.equals("Y") && allow_duplicate.equals("N")) { //IN30118-SCF No: MO-GN-5400. Removed condition patient_class.equals("IP").
%>
			//	duplicateWarning();
<%
		//	}
%>
		</script>
<%
		putObjectInBean(bean_id,bean,request);
		putObjectInBean(or_bean_id,ORbean,request);	
	}
	catch(Exception e) {
		e.printStackTrace();
	}finally{ 
        	if(con != null)
          		ConnectionManager.returnConnection(con,request);	 //added for GHL-CRF-0549
	}
%>
</HTML>

