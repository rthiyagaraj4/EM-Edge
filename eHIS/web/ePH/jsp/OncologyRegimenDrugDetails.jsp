<!DOCTYPE html>
<%/*
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date   		Rev.By 				Description
--------------------------------------------------------------------------------------------------------------------------------
12/08/2019	IN070451		B Haribabu          12/08/2019     Manickavasagam J	    ML-MMOH-CRF-1408
25/06/2020  IN:072715       Haribabu            25/06/2020     Manickavasagam J     MMS-DM-CRF-0165
06/11/2020      IN:069887              Haribabu                   Manickavasagam J          MO-CRF-20152
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*,eOR.*,eOR.Common.* , ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,java.text.DecimalFormat,eCommon.XSSRequestWrapper" %> <!-- // java.text.DecimalFormat Added for ML-MMOH-SCF-1060 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
			<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
			<SCRIPT language='javascript' src='../../eCommon/js/dchk.js' ></SCRIPT>
			<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
			<SCRIPT language='javascript' src='../../eCommon/js/FieldFormatMethods.js' ></SCRIPT>
			<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
			<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
			<script language="javascript" src="../../ePH/js/OncologyRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
<%
try{
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String start_date		= request.getParameter("start_date");
	String problem_ind		= request.getParameter("problem_ind");
	String regimen_code		= request.getParameter("regimen_code");
	String stage			= request.getParameter("stage");
	String intention		= request.getParameter("intention");
	String height			= request.getParameter("height");
	String calc_yn = "N";
	String caclDoseBy_m2 = "selected";
	String caclDoseBy_kg = "";
	String caclDoseBy_age =""; // Added for ML-MMOH-CRF-0345 [IN:057441]
	String disableDoseBy  =""; // Added for ML-MMOH-CRF-1004
	String calc_dose = "";
	String calc_dose_uom = "";
	String calc_dose_by = "";
	String DrugIndicationRemarks="";//Added for  ML-BRU-CRF-072[Inc:29938]
	String DrugRemarksEntered			=	"";//added for [IN:039576]
        boolean default_dose_type_yn = false; // Added for ML-MMOH-CRF-0345 [IN:057441]
        String total_qty_disable = ""; // Added for ML-MMOH-CRF-0345 [IN:057441]
	int amend_serial_no     =0; 
	if(height==null || height.equals(""))
		height					= "0.0";
	String weight			= request.getParameter("weight");
	if(weight==null || weight.equals(""))
		height					= "0.0";
	String bsa				= request.getParameter("bsa");
	if(bsa==null || bsa.equals(""))
		bsa						= "0.0";
	String params			= request.getQueryString() ;
	String serialNum		= request.getParameter("serialNum") == null ? "":request.getParameter("serialNum");
	String MAR_app_yn		= request.getParameter("MAR_app_yn") == null ? "":request.getParameter("MAR_app_yn");
	String fluid_frame_display_yn=request.getParameter("fluid_frame_display_yn");

	String bean_id			= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name		= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	String bean_id_pres					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name_pres				= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean_pres			= (PrescriptionBean_1)getBeanObject(bean_id_pres,bean_name_pres,request);
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	boolean req_diag_pres_found=bean.isSiteSpecific("PH", "REQ_DIAG_PRES_FOUND"); //added for MMS-DM-CRF-0204
	
	String resp_id			= (String)ORbean.getResponsibilityId();
	String pract_id			= (String)ORbean.getPractitionerId();
	String pract_name		= (String)ORbean.getPractitionerName();
	String locn_type		= (String)ORbean.getLocationType();
	String locn_code		= (String)ORbean.getLocationCode();
	String facility_id	= "";
	facility_id	= (String) session.getValue("facility_id");
    String order_type_flag	=  "";
	order_type_flag		= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	String amend_search_yn	= "";
	if(order_type_flag.equals("Existing")) {
		amend_search_yn	= "DISABLED";
	}
	default_dose_type_yn = bean.isSiteSpecific("OR", "OR_ORDER_SET"); // Added for ML-MMOH-CRF-1004
	boolean item_type_site_app =  bean.isSiteSpecific("PH", "ITEM_TYPE_APP"); // added for GHL-CRF-0549
	//Added for IN:069887  start
	boolean validate_overide_on_confirm =  bean.isSiteSpecific("PH", "VALIDATE_OVERIDE_ON_CONFIRM");		
	String validate_overide_on_confirm_yn="N";
	if(validate_overide_on_confirm){
		validate_overide_on_confirm_yn="Y";
	}		
	//Added for IN:069887 end
	String remarks_style    =  "visibility:hidden";
	String pres_remarks     =  ""; 
	String fract_dose_appl_yn, calc_dosg_by_freq_durn_yn; // Added for IN032142
//GHL-CRF-0549 - start
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
String diagnosis_found_yn="";//added for mms-dm-crf-0204
	if(start_date!=null){
		//if(! ORbean.getLanguageId().equals("en"))
          // start_date =com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",ORbean.getLanguageId(),"en");
		//bean.setOrderDate(start_date);
	}
	if(patient_id!=null)
		bean.setPatId(patient_id);
	if(encounter_id!=null)
		bean.setEncId(encounter_id);

	if(problem_ind!=null)
		bean.setProblemInd(problem_ind);
	else
		problem_ind					= bean.getProblemInd();
	
	int    count                    =0;

	ArrayList doseUom = new ArrayList();
	doseUom = bean.getDoseUom();
	bean.setExcludeADRAllergyAlert(CommonBean.checkForNull(request.getParameter("excludeADRAllergyAlert_yn")));
%>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="onCologyRegimenDrugDetails" id="onCologyRegimenDrugDetails">
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
			<input type="hidden" name="encounter_id" id="encounter_id" value="<%= encounter_id %>">
			<input type="hidden" name="start_date" id="start_date" value="<%= start_date %>">
			<input type="hidden" name="patient_class" id="patient_class" value="<%= patient_class %>">
			<input type="hidden" name="resp_id" id="resp_id" value="<%= resp_id %>">
			<input type="hidden" name="pract_id" id="pract_id" value="<%= pract_id %>">
			<input type="hidden" name="pract_name" id="pract_name" value="<%= pract_name %>">
			<input type="hidden" name="locn_type" id="locn_type" value="<%= locn_type %>">
			<input type="hidden" name="locn_code" id="locn_code" value="<%= locn_code %>">
			<input type="hidden" name="problem_ind" id="problem_ind" value="<%= problem_ind %>">
			<input type="hidden" name="params" id="params" value="<%=params%>">
<%
			if (serialNum.equals("")) {
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr>
						<td colspan="7" class='COLUMNHEADER'><font style="font-size:9"><fmt:message key="ePH.DrugDetails/UnitDose.label" bundle="${ph_labels}"/></font></th> 
					</tr>					
					<tr>
						<td width="8%"  class="label"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></TD>
						<td width="35%" class="DATA" id="DRUGDESC" nowrap><input name="drug_name" id="drug_name" type="text" size="40" maxlength="60" <%=amend_search_yn%> ><input type="button" value="?" onclick="drugSearch('')" <%=amend_search_yn%> >
						<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility='hidden'" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails('');" id="eldImg"></img>

						</td>
						<td width="10%" class="label"><fmt:message key="Common.Route.label" bundle="${common_labels}"/>&nbsp;</td>
						<td  class="DATA" id="ROUTE" nowrap></td>
				   </tr>
					<tr>
						<TD  colspan="4">
						<TABLE border=0><TR>
						<TD CLASS="label"><fmt:message key="ePH.CalculateBy.label" bundle="${ph_labels}"/></TD>
						<TD CLASS="label"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/> <input type="radio" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="D" disabled></TD>
						<TD CLASS="label"><fmt:message key="ePH.BodywtBSA.label" bundle="${ph_labels}"/><input type="radio" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="B"  checked  disabled></TD></TR></TABLE></TD>
					</tr>
				   <tr>
					<td width="7%"  class="label">
						<fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/>&nbsp;
					</td>
					<td width="20%" class="data" colspan='5'><input type="text" name='dose' id='dose' value=""  size="5" maxlength="12" class="number"  onKeyPress="return allowValidNumber(this,event,8,6);" onblur='calcTotalDose(onCologyRegimenDrugDetails);setChngdDose(document.onCologyRegimenDrugDetails.totalDose.value);' class="NUMBER" <%=amend_search_yn%>>

						<select name='doseUom' id='doseUom' onChange='calcTotalDose(onCologyRegimenDrugDetails)' <%=amend_search_yn%>></select>
						<label class='label'><b>/</b></label>
						<select name='caclDoseBy_unit' id='caclDoseBy_unit' onChange='calcTotalDose(onCologyRegimenDrugDetails);' <%=amend_search_yn%>>
						  <%if(default_dose_type_yn){ // if condition Added for ML-MMOH-CRF-1004 and else for existing -Start %>
							<option value="kg" >kg</option>
							<option value="m2">m&sup2;</option> 
							<%} else{ %>
							<option value="kg" >Kg</option>
							<option value="m2" >M2</option>
								<%} // if condition Added for ML-MMOH-CRF-1004 and else for existing -End %>
						</select>
						<label class='label'><b>=</b></label>
						<input type="text" name='totalDose' id='totalDose' value="" onKeyPress="return allowValidNumber(this,event,8,6);" onblur='checkDose(this);setChngdDose(document.onCologyRegimenDrugDetails.totalDose.value);calcDose(onCologyRegimenDrugDetails); ' class="NUMBER" <%=amend_search_yn%>>
						<label class='label'></label>
						<img src="../../eCommon/images/mandatory.gif" BORDER="0"></img>
					</td>

					<td  id="DATA" class="DATA"><font size="1"></font></td>
				</tr>


					<tr height='40'><td class="label" colspan='7' >&nbsp;</td></tr>
				</table>
				<input type="hidden" name="drug_code" id="drug_code" value="">
				<input type="hidden" name="ocurrance_num" id="ocurrance_num" value="0">
<%
			bean.setSerialNo(serialNum+""); //ML-MMOH-CRF-1014
			}
			else {
				int srlNo					= 0;
				srlNo						= Integer.parseInt(serialNum);
				ArrayList drugList			= bean.getDrugDetails();
				HashMap drugDetails			= (HashMap)drugList.get(srlNo-1);
				String generic_id			= (String)drugDetails.get("GENERIC_ID");
				String drug_desc			= (String)drugDetails.get("DRUG_DESC");
				String drug_code			= (String)drugDetails.get("DRUG_CODE");
				String generic_name			= (String)drugDetails.get("GENERIC_NAME");
				String allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
				String current_rx			= (String)drugDetails.get("CURRENT_RX");
				String srl_no				= (String)drugDetails.get("SRL_NO");
				String strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
				String strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
				String strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
				String form_code			= (String)drugDetails.get("FORM_CODE");
				String pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
				String pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
				String pres_base_uom_desc	= (String)drugDetails.get("PRES_BASE_UOM_DESC");
				String freq_code			= (String)drugDetails.get("FREQ_CODE");
				String durn_value			= (String)drugDetails.get("DURN_VALUE");
				String durn_type			= (String)drugDetails.get("DURN_TYPE");
				String or_durn_desc			= (String)drugDetails.get("OR_DURN_DESC");
				//String auth_yn_val		= (String)drugDetails.get("AUTH_YN_VAL");
				//String approval_yn_val	= (String)drugDetails.get("APPROVAL_YN_VAL");
				//String cosign_yn_val		= (String)drugDetails.get("COSIGN_YN_VAL");
				String auth_yn				= (String)drugDetails.get("AUTH_YN");
				String approval_yn			= (String)drugDetails.get("APPROVAL_YN");
				String cosign_yn			= (String)drugDetails.get("COSIGN_YN");
				String consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
				String order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
				String route_code			= (String)drugDetails.get("ROUTE_CODE");
				String end_date				= (String)drugDetails.get("END_DATE");
				String dup_drug_desc		= (String)drugDetails.get("CURRENTRX_REMARKS");
				String allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS");
				String exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS");
				String bms_qty				= (String)drugDetails.get("BMS_QTY");
				String dflt_qty_uom			= (String)drugDetails.get("DFLT_QTY_UOM");
				String tab_qty_value		= (String)drugDetails.get("TAB_QTY_VALUE");
				String qty_desc_code		= (String)drugDetails.get("QTY_DESC_CODE");
				String route_desc			= (String)drugDetails.get("ROUTE_DESC");
				String amend_yn	            = (String)drugDetails.get("AMEND_YN"); 
				String recomm_yn			= (String)drugDetails.get("RECOMM_YN")==null?"":(String)drugDetails.get("RECOMM_YN");
				String calc_by_ind			= (String)drugDetails.get("CALC_BY_IND")==null?"":(String)drugDetails.get("CALC_BY_IND");
				String dosage_std			= (String)drugDetails.get("DOSAGE_STD")==null?"":(String)drugDetails.get("DOSAGE_STD");
				String recomm_dosage_unit	= (String)drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
				String recomm_dosage_by		= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
				String min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_DOSE");
				String min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_DOSE");
				//Added for IN:070451 start
				String min_unit_dose1 = min_unit_dose;
				String      max_daily_ceeling_dose	    =   (String)drugDetails.get("max_daily_ceeling_dose")==null?"":(String)drugDetails.get("max_daily_ceeling_dose");
				String		min_daily_ceeling_dose	    =   (String)drugDetails.get("min_daily_ceeling_dose")==null?"":(String)drugDetails.get("min_daily_ceeling_dose");
				String		max_unit_ceeling_dose	    =   (String)drugDetails.get("max_unit_ceeling_dose")==null?"":(String)drugDetails.get("max_unit_ceeling_dose");
				String		min_unit_ceeling_dose	    =   (String)drugDetails.get("min_unit_ceeling_dose")==null?"":(String)drugDetails.get("min_unit_ceeling_dose");
				String dose_unit_desc = ""; 
				String dose_unit_desc1 = "";
				String dosage_uom			= (String)drugDetails.get("DOSAGE_UNIT")==null?"":(String)drugDetails.get("DOSAGE_UNIT");
						if(!dosage_uom.equals("")){ 
					   dose_unit_desc      = bean.getUomDisplay((String)session.getValue("facility_id"),dosage_uom); 
					   dose_unit_desc1 =dose_unit_desc;
 						if(dose_unit_desc==null || dose_unit_desc=="" ) {
 						  dose_unit_desc = bean.getUomDisplay((String)session.getValue("facility_id"),(dosage_uom.split("/")[0]));
 						 dose_unit_desc1 =dose_unit_desc;
					      dose_unit_desc =dose_unit_desc+"/"+(dosage_uom.split("/")[1]);
 						} 
						}
				//Added for IN:070451 end
				
				//Added for IN:072715 start
					String allergy_remarks_code				= (String) drugDetails.get("ALLERGY_REMARKS_CODE")==null?"":(String) drugDetails.get("ALLERGY_REMARKS_CODE");
					String dose_remarks_code				= (String) drugDetails.get("DOSE_REMARKS_CODE")==null?"":(String) drugDetails.get("DOSE_REMARKS_CODE");
					String currentrx_remarks_code				= (String) drugDetails.get("CURRENTRX_REMARKS_CODE")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS_CODE");
					//Added for IN:072715 end
				
				String daily_dose			= (String)drugDetails.get("DAILY_DOSE")==null?"":(String)drugDetails.get("DAILY_DOSE");
				String unit_dose			= (String)drugDetails.get("UNIT_DOSE")==null?"":(String)drugDetails.get("UNIT_DOSE");
				String unit_dose1 = unit_dose;//Added for IN:070451
				String mono_graph	        = (String)drugDetails.get("MONO_GRAPH")==null?"":(String)drugDetails.get("MONO_GRAPH");
				String limit_ind			= (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
				String dosage_type			= (String)drugDetails.get("DOSAGE_TYPE")==null?"":(String)drugDetails.get("DOSAGE_TYPE");
				String ocurrance_num		= (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");
				String ord_auth_reqd_yn		= (String)drugDetails.get("ORD_AUTH_REQD_YN");
				String ord_spl_appr_reqd_yn	= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
				String ord_cosign_reqd_yn	= (String)drugDetails.get("ORD_COSIGN_REQD_YN");
				String ord_authorized_yn	= (String)drugDetails.get("ORD_AUTHORIZED_YN");
				String ord_authorized_prev_yn	= (String)drugDetails.get("ORD_AUTHORIZED_PREV_YN");
				String ord_approved_yn		= (String)drugDetails.get("ORD_APPROVED_YN");
				String ord_cosigned_yn		= (String)drugDetails.get("ORD_COSIGNED_YN");
				String calc_dose_based_on	= (String)drugDetails.get("CALC_DOSE_BASED_ON");
				calc_dose_by				= (String)drugDetails.get("calc_dose_by")==null?"":(String)drugDetails.get("calc_dose_by");
				calc_dose_uom				= (String)drugDetails.get("calc_dose_uom")==null?"":(String)drugDetails.get("calc_dose_uom");				
				String dose					= (String)drugDetails.get("dose")==null ? "":(String)drugDetails.get("dose");
				/* below code added for IN032142   -- Start   */
				fract_dose_appl_yn			= (String)drugDetails.get("FRACT_DOSE_APPL_YN")==null ? "":(String)drugDetails.get("FRACT_DOSE_APPL_YN");
				calc_dosg_by_freq_durn_yn	= (String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN")==null ? "":(String)drugDetails.get("CALC_DOSG_BY_FREQ_DURN_YN");
				String qty_value	= (String) drugDetails.get("QTY_VALUE"); 
				/* code added for IN032142   --End   */
				DrugIndicationRemarks      = (String)drugDetails.get("DRUG_INDICATION")==null ? "":(String)drugDetails.get("DRUG_INDICATION");//Added for  ML-BRU-CRF-072[Inc:29938]
				DrugRemarksEntered      = (String)drugDetails.get("DrugRemarksEntered")==null ? "":(String)drugDetails.get("DrugRemarksEntered");// added for [IN:039576]
				if(!DrugIndicationRemarks.equals(""))
				DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8");
				String display_auth_rule	= "visibility:hidden";
				String color_auth_rule		= "RED";
				String order_id				= "";
				String disable_existing     = "";
				String amend_srl_no         = ""; 
				String amend_order_id		= "";		 
				String dosage_unit			= "";	
				String calculatedDose		= "";					
				String disable_calc_dose	= "";	
				String select_calc_dose_WT_BSA		= "";	
				String select_calc_dose_Dosage		= "";	
				String display_dosage_type1	= "";	
				String display_dosage_type2	= "";
				String perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
				String ext_prod_id = drugDetails.get("EXTERNAL_PRODUCT_ID")==null ? "":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
				HashMap eqvlValues			= (HashMap)drugDetails.get("EQVL_VALUES");
				String ord_set_reqd_or_opt	        = (String) drugDetails.get("REQD_OR_OPT_IND")==null?"":(String) drugDetails.get("REQD_OR_OPT_IND");//mms-dm-crf-0204
	             diagnosis_found_yn=(String)drugDetails.get("DIAGNOSIS_FOUND_YN");//mms-dm-crf-0204	
						if(req_diag_pres_found){
							 diagnosis_found_yn=(String)drugDetails.get("DIAGNOSIS_FOUND_YN");//mms-dm-crf-0204	
									
						}
						else{
							diagnosis_found_yn="G";
						}
	             System.out.println("339 ord_set_reqd_or_opt"+ord_set_reqd_or_opt);
				HashMap Existingrecord;
				//order_type_flag		= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");       
                                calculatedDose =(String) drugDetails.get("calc_dose")==null?"":(String) drugDetails.get("calc_dose"); // Added for ML-MMOH-CRF-0345 - Start
				String or_dose_type = drugDetails.get("OR_DOSAGE_TYPE")==null ? "":(String)drugDetails.get("OR_DOSAGE_TYPE");
                                String or_qty_val = drugDetails.get("OR_QTY_VALUE")==null ? "":(String)drugDetails.get("OR_QTY_VALUE"); 
                                default_dose_type_yn = bean.isSiteSpecific("OR", "OR_ORDER_SET");
                             if (default_dose_type_yn && !or_dose_type.equals("") && !dosage_type.equals("Q")){
                	      total_qty_disable ="disabled";
                              }
                
                              if(!or_dose_type.equals("") && !dosage_type.equals("Q") && default_dose_type_yn){ 
					
					if(or_dose_type.equals("A") && calculatedDose.equals("") && !or_qty_val.equals("")){
						dose = or_qty_val;
					}
					else if(or_dose_type.equals("K") && calculatedDose.equals("") && !or_qty_val.equals("")){
						dose = String.valueOf((Float.parseFloat(or_qty_val) * Float.parseFloat(weight)));
					}
					else{
						if(calculatedDose.equals("") && !or_qty_val.equals(""))
						dose = String.valueOf((Float.parseFloat(or_qty_val) * Float.parseFloat(bsa)));
					}
					
					DecimalFormat dfTest        = new DecimalFormat("0.#######"); // Added for ML-MMOH-SCF-1060 
					if(calculatedDose.equals("") && !or_qty_val.equals("")){	
                            	   dose = dfTest.format(Double.parseDouble(dose))+"";//ADDED for ml-mmoh-scf-1060
                            	   // dose= String.valueOf(Math.round(Float.parseFloat(dose)*1000)/1000);//removed for ml-mmoh-scf-1060
                	        calculatedDose = or_qty_val;
			       }
			      } // Added for ML-MMOH-CRF-0345 - End
				if(stage==null||stage.equals(""))
					stage	= (String)drugDetails.get("stage");
				if(intention==null||intention.equals(""))
					intention	= (String)drugDetails.get("intention");
				if(regimen_code==null||regimen_code.equals(""))
					regimen_code			= (String)drugDetails.get("regimen_code");				
				if(dose.equals(""))
					dose= (String)drugDetails.get("QTY_VALUE")==null ? "":(String)drugDetails.get("QTY_VALUE");
				String route_color			= (String)drugDetails.get("ROUTE_COLOR");	// added for CRF RUT-CRF-0034.1[IN:037389]-start
				String fntColor="";
				String backgrndColor="";
				if(route_color!= null && !route_color.equals("")){
	                if(route_color.length()==12){
						fntColor= route_color.substring(0, 6);
						backgrndColor= route_color.substring(6, 12);
					}
				}	// added for CRF RUT-CRF-0034.1[IN:037389]-End
				//HashMap practRights			= (HashMap)bean.getAuthorizationReqd(resp_id, pract_id);
				ArrayList doseValues		= (ArrayList)bean.getDoseValues(drug_code,patient_id);
					
				String calc_unit			= "";
				String drug_unit			= "";
				String drug_unit_code			= "";

				if(doseValues!=null){
					dosage_unit				= (String)doseValues.get(1);
				}
				//out.println("amend yn=>"+amend_yn);
				if(amend_yn.equals("N")){
					if(!calc_by_ind.equals("") && calc_by_ind.equals("B")){
						if(!bsa.equals("0.0")){
							float calc_value    = ((Float.parseFloat(dose)) * (Float.parseFloat(bsa)));
							int calc_value_int  = (int)java.lang.Math.ceil(calc_value);
							min_unit_dose			= String.valueOf((int)java.lang.Math.ceil(((Float.parseFloat(CommonBean.checkForNull(min_unit_dose,"0"))) * (Float.parseFloat(bsa)))));//Added for IN:070451
							unit_dose			= String.valueOf((int)java.lang.Math.ceil(((Float.parseFloat(CommonBean.checkForNull(unit_dose,"0"))) * (Float.parseFloat(bsa)))));//Added for IN:070451
							dosage_unit="mt/sqr";
							calc_unit			= "("+ dosage_std + " "+drug_unit + "/" + dosage_unit + ")" ;
							dose				= String.valueOf(calc_value_int);
						}
					}
					else if(!calc_by_ind.equals("") && calc_by_ind.equals("W")){
						if(!weight.equals("0.0")){
							float calc_value    = ((Float.parseFloat(dose)) * (Float.parseFloat(weight)));
							//int calc_value_int  = (int)java.lang.Math.ceil(calc_value);
							min_unit_dose			= String.valueOf((int)java.lang.Math.ceil(((Float.parseFloat(CommonBean.checkForNull(min_unit_dose,"0"))) * (Float.parseFloat(weight)))));//Added for IN:070451
							unit_dose			= String.valueOf((int)java.lang.Math.ceil(((Float.parseFloat(CommonBean.checkForNull(unit_dose,"0"))) * (Float.parseFloat(weight)))));//Added for IN:070451
							 dosage_unit="mt/sqr";
							calc_unit			= "("+ dosage_std + " "+drug_unit + "/" + dosage_unit + ")" ;
							dose				= String.valueOf(calc_value);
						}
					}
				}
				String doseValue=dose;
				/*if (dose!=null && !dose.equals("")){   //commented for IN18269
					//Float f=new Float(dose);
					//doseValue=f.intValue()+"";
				}*/
				//out.println("dValue2="+doseValue);
				String TDM_order_id			=	"";
				String TDM_display		    =	"";
				TDM_order_id				=  bean_pres.getOorderIdForTDMDtls(patient_id,drug_code);

				if(TDM_order_id==null||TDM_order_id.equals("")){
					TDM_display="display:none";
				}
				else{
					TDM_display="display:inline";
				} 
				
//				calculatedDose =String.valueOf(Math.ceil((Float.parseFloat(doseValue))/(Float.parseFloat(bsa))));
				//calculatedDose =String.valueOf(new Float(Math.floor((Float.parseFloat(doseValue))/(Float.parseFloat(bsa)))).intValue());
			//	calculatedDose =(String) drugDetails.get("calc_dose")==null?"":(String) drugDetails.get("calc_dose");  // Commented for ML-MMOH-CRF-0345
				if(order_type_flag.equals("Existing")) {
	
					order_id=request.getParameter("order_id");
					bean.setDummyOrderID(order_id);		  
					ArrayList getExistingCYTORecords = bean.getExistingCYTORecords();
					for(int i=0;i<getExistingCYTORecords.size();i++){
						Existingrecord	= (HashMap) getExistingCYTORecords.get(count); 
						if( Existingrecord.containsKey("AMEND_SRL_NO")){
							amend_srl_no=(String) Existingrecord.get("AMEND_SRL_NO");	
							if(amend_srl_no.equals(serialNum)){
								if(amend_yn.equals("N"))
								{
									doseValue				= (String)Existingrecord.get("QTY_VALUE");
									calc_dose_based_on	    = (String)Existingrecord.get("CALC_DOSE_BASED_ON");	
									dosage_type			    = (String)Existingrecord.get("DOSAGE_TYPE");
									calculatedDose			= (String)Existingrecord.get("CALC_DOSE");	
									calc_dose_uom		    = (String)Existingrecord.get("CALC_DOSE_UOM");	
									calc_dose_by		    = (String)Existingrecord.get("CALC_DOSE_BY");										
								}
								drug_code				= (String)Existingrecord.get("ORDER_CATALOG_CODE");
								drug_desc				= (String)Existingrecord.get("CATALOG_DESC");		 
								amend_order_id		    = (String)Existingrecord.get("ORDER_ID");	
									
//								calculatedDose = String.valueOf((Float.parseFloat(doseValue))/(Float.parseFloat(bsa)));
								amend_serial_no         = count;	
								
								//if(order_type_flag.equals("Existing")){																		
									if(!calc_dose_uom.equals("")){
										drug_unit = calc_dose_uom;
									}
								//}
								break;		  
							}
							
						}
						count++;
						disable_existing="disabled" ;  
					}
					ArrayList drug_remarks	=	bean.getPrescribedRemarks(amend_order_id,"1");
					if(drug_remarks.size()!=0) { 
						for(int x=0; x<drug_remarks.size(); x++) {	
							if(x==(drug_remarks.size()-1)) {	
								pres_remarks	=pres_remarks+(String)drug_remarks.get(x);
							} else {
								pres_remarks	=pres_remarks+(String)drug_remarks.get(x)+",";
							}
						} 
					 } 
					 if(!pres_remarks.equals(""))
						remarks_style	="visibility:visible";
					 else
						remarks_style	="visibility:hidden";
				}
				if(dosage_type.equals("S")){
					drug_unit = strength_uom_desc;
					drug_unit_code = strength_uom;
				}
				else{
					drug_unit = pres_base_uom_desc;
					drug_unit_code = pres_base_uom;
				}
				if(calc_dose_based_on!=null && !calc_dose_based_on.equals(""))
				{
					if(calc_dose_based_on.equals("D"))
					{
					  	if (strength_value.equals("0")|| !fract_dose_appl_yn.equals("Y") || !calc_dosg_by_freq_durn_yn.equals("Y"))//fract_dose_appl_yn and calc_dosg_by_freq_durn_yn  added  for  IN032142 
							disable_calc_dose="disabled";
						else
							disable_calc_dose="";
						select_calc_dose_Dosage="checked";
						select_calc_dose_WT_BSA="";
						display_dosage_type1="style=display:inline";
						display_dosage_type2="style=display:none";						
					}
					else
					{						
						select_calc_dose_WT_BSA="checked";					
						select_calc_dose_Dosage="";
						display_dosage_type1="style=display:none";					
						display_dosage_type2="style=display:inline";						
					}
				}
				else
				{
					if (strength_value.equals("0") || !fract_dose_appl_yn.equals("Y") || !calc_dosg_by_freq_durn_yn.equals("Y"))//fract_dose_appl_yn and calc_dosg_by_freq_durn_yn  added  for  IN032142  
					{
						disable_calc_dose="disabled";
						select_calc_dose_Dosage="checked";
						select_calc_dose_WT_BSA="";
						display_dosage_type1="style=display:inline";
						display_dosage_type2="style=display:none";										
					}
					else
					{
						disable_calc_dose="";
						if(dosage_type.equals("Q"))
						{
							select_calc_dose_Dosage="checked";
							select_calc_dose_WT_BSA="";
							display_dosage_type1="style=display:inline";
							display_dosage_type2="style=display:none";
						}
						else
						{
							select_calc_dose_WT_BSA="checked";					
							select_calc_dose_Dosage="";
							display_dosage_type1="style=display:none";					
							display_dosage_type2="style=display:inline";
						}
					}
				}
				if(!or_dose_type.equals("") && !dosage_type.equals("Q") && default_dose_type_yn){ // Added for ML-MMOH-CRF-0345 - Start
                                   if(calc_dose_by.equals("m2") ||or_dose_type.equals("M") ) {
					caclDoseBy_m2 = "selected";
					disableDoseBy  = "disabled"; // Added for ML-MMOH-CRF-1004
					caclDoseBy_kg = "";
					caclDoseBy_age = "";
				  }
                                  else if(calc_dose_by.equals("Ag") || or_dose_type.equals("A")) {
                	          caclDoseBy_m2 = "";
					  caclDoseBy_kg = "";
					  caclDoseBy_age = "selected";
					  disableDoseBy  = "disabled"; // Added for ML-MMOH-CRF-1004
  				  }
                                else if(calc_dose_by.equals("kg") || or_dose_type.equals("K")){
					caclDoseBy_m2 = "";
					caclDoseBy_kg = "selected";
					disableDoseBy  = "disabled"; // Added for ML-MMOH-CRF-1004
					caclDoseBy_age = "";
				  }
				} // Added for ML-MMOH-CRF-0345 - End
			        else{ // else condition Added for ML-MMOH-CRF-0345  -Existing Functionality -Start
				if(calc_dose_by.equals("m2")) {
					caclDoseBy_m2 = "selected";
					caclDoseBy_kg = "";
				}else{
					caclDoseBy_m2 = "";
					caclDoseBy_kg = "selected";
				}
			        } // else condition Added for ML-MMOH-CRF-0345  -Existing Functionality -End
				//out.println("calc_dose_by=>"+calc_dose_by);
%>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
					<tr>
						<td colspan="7" class='COLUMNHEADER'><font style="font-size:9"><fmt:message key="ePH.DrugDetails/UnitDose.label" bundle="${ph_labels}"/></font></th> 
					</tr>
					<tr>
						<td width="8%"  class="label"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></TD>
						<td width="35%" class="DATA" id="DRUGDESC" nowrap><%=drug_desc%>
<%
						if(drug_desc != null && !drug_desc.equals("")){	
%>
							<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails('<%=drug_code%>');"></img>
<%
						}
						else{
%>
							<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF); visibility=hidden" src="../../ePH/images/FD-ICON-rollOverInformationIcon.gif" height=20  width=20 onClick="openEDLDetails('<%=drug_code%>');"></img>
<%
						}
%>
						</td>
						<td width="10%" class="label"><fmt:message key="Common.Route.label" bundle="${common_labels}"/>&nbsp;</td>
						<td  class="label" id="ROUTE"  nowrap><font style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'><b><%=route_desc%></b></font>
<%							//Added for SKR-CRF-0006[IN029561] -Start
							String actionText =  bean.getActionText(form_code,route_code);					 
							if(actionText !=null && !actionText.equals("")){
%>
								<label style='color:red;' class='label' >&nbsp;(<%=actionText%>) </label> 
<% 
							}// Added for SKR-CRF-0006[IN029561]-End
%> 
						</td>
<%
						if(recomm_yn!=null && recomm_yn.equals("Y")) {
%>
							<td CLASS="label" ID="monograph" colspan='3'>
<%
							if(!order_type_flag.equals("Existing"))	{
								if(dosage_type.equals(recomm_dosage_by)  ){
%>                          
									<label id='rec_legend' onclick='defaultRecomDose()'>
									<font class='HYPERLINK' onmouseover='changeCursor(this);'>
<%
								}
							}
							else{
								if(dosage_type.equals(recomm_dosage_by)  ){
%>                          
									<label id='rec_legend' >
									<font class='label' >
<%
								}  
							}
%>
							<fmt:message key="ePH.Recom.Dose.label" bundle="${ph_labels}"/></font>
							</label>
							<label id="rec_value" style="font-size:11;font-weight:bold;color:red"><%=dosage_std%></label>
							&nbsp;<label id="rec_uom" style="font-size:11;font-weight:bold;color:red"><%=dosage_unit%></label>
						</td>
					
<%
				}
				else{
%>
					<TD colspan='3'>&nbsp</TD>
<%				}
%>
				</tr>
				<tr><td colspan='5'>
					<TABLE border=0>
						<TR>						
							<TD CLASS="label"><fmt:message key="ePH.CalculateBy.label" bundle="${ph_labels}"/></TD>
							<TD CLASS="label"><fmt:message key="Common.Dosage.label" bundle="${common_labels}"/><input type="radio" id="CALC_DOSE_BASED_ON_D" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="D" <%=select_calc_dose_Dosage%> <%=disable_calc_dose%>  onClick="setCalculateBy(this,'IVAD_NORMAL');"></TD>
							<TD CLASS="label"><fmt:message key="ePH.BodywtBSA.label" bundle="${ph_labels}"/><input type="radio" id="CALC_DOSE_BASED_ON_B" name="CALC_DOSE_BASED_ON" id="CALC_DOSE_BASED_ON" value="B" <%=select_calc_dose_WT_BSA%> <%=disable_calc_dose%>  onClick="setCalculateBy(this,'IVAD_NORMAL');"></TD>
<%
									//added for SRR20056-SCF-7085 IN26862 - Start
									if(!order_type_flag.equals("Existing"))	{
%>     
										<td class="label"><a HREF id="drug_remarks" onMouseOver="changeCursor(this);" onClick="getFormatId('Drug','Y')" title='<fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>'><font class='HYPERLINK'><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></font></a>
										<!-- added for [IN:039576]-start -->
										<img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'></td>
									    <input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
										<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
										<!-- added for [IN:039576]-end -->
<%
									}   
									else{
%>	
										<td class="label"><a HREF id="drug_remarks" onMouseOver="changeCursor(this);" onClick=" callOrderAmend('Drug')" style="<%=remarks_style%>" title='<fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/>'><font class='HYPERLINK'><fmt:message key="ePH.DrugRemarks.label" bundle="${ph_labels}"/></font></a><!-- added for [IN:039576]-start -->
										<img  src="../../eCommon/images/mandatory.gif" style='display:none;' id='DrugRemarksMandImg'></td>
									    <input type='hidden' name='DrugRemarksMandatory' id='DrugRemarksMandatory' value='N'>
										<input type='hidden' name='DrugRemarksEntered' id='DrugRemarksEntered' value='<%=DrugRemarksEntered%>'>
										<!-- added for [IN:039576]-end --></td>
 <%
									}
									//added for SRR20056-SCF-7085 IN26862 - End
%>
								<td class="label"  colspan="2" nowrap>
								<a href="javascript:drugindication_remarks();" id="drug_ind_remarks" style="visibility:visible" title='<fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/>'><fmt:message key="ePH.DrugIndications.label" bundle="${ph_labels}"/></a></td>
								<%//GHL-CRF-0549 - start
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
							
							if(mm_item_Innovator_yn.equals("Y")) //GHl-SCF-1430 - start
								checked = "";
							
							if(!mm_item_low_cost_yn.equals("Y") && !mm_item_high_margin_yn.equals("Y") && !mm_item_Innovator_yn.equals("Y")){ //4/24/2019
								checked = "checked";
							}//GHl-SCF-1430 - end

							allow_alternate_disabled = "";
						
						}else{
							allow_alternate_disabled = "disabled";
						}
						if(order_type_flag.equals("Existing")){ //GHL-CRF-0549
							allow_alternate_disabled = "disabled";
						}
						
					} 	//GHL-CRF-0549 - end
					if(item_type_site_app && disp_by_alt_form_param.equals("Y")){ //GHL-CRF-549
%>					<td CLASS="label" colspan="2"><fmt:message key="ePH.AllowAlternate.label" bundle="${ph_labels}"/>&nbsp;
					<input type='checkbox' name='allow_alternate_yn' id='allow_alternate_yn' value='<%=allow_alternate_yn%>' <%=allow_alternate_disabled%> <%=checked%> > </td><!-- GHL-CRF-0549-->
<%
					}//GHL-CRF-0549 - end
%>
						</TR>
					</TABLE>
				</td>
				<td colspan='4'>
						<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
							<tr>
<%
									display_auth_rule = "visibility:hidden";
									if(ord_auth_reqd_yn.equals("Y")){
										display_auth_rule = "visibility:visible";
										color_auth_rule = "color:red";
										if(ord_authorized_yn.equals("Y"))
											color_auth_rule = "color:green";
									}
%>
									<td class="label" align='center'><label id='lbl_authorize' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></label></td>
<%
									display_auth_rule = "visibility:hidden";
									color_auth_rule = "color:red";
									if(ord_spl_appr_reqd_yn.equals("Y")){
										display_auth_rule = "visibility:visible";
										if(ord_approved_yn.equals("Y"))
											color_auth_rule = "color:green";
									}
%>
									<td class="label"  align='center' colspan='2'><label id='lbl_splapprvl' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="ePH.splapproval.label" bundle="${ph_labels}"/></label></td>
<%
									display_auth_rule = "visibility:hidden";
									color_auth_rule = "color:red";
									if(ord_cosign_reqd_yn.equals("Y")){
										display_auth_rule = "visibility:visible";
										if(ord_cosigned_yn.equals("Y"))
											color_auth_rule = "color:green";
									}
%>
									<td class="label" align='center'><label id='lbl_cosign' style='<%=display_auth_rule%>;<%=color_auth_rule%>'><fmt:message key="Common.Cosign.label" bundle="${common_labels}"/></label></td>

									<td class="label"><A HREF onMouseOver="changeCursor(this);" title='<fmt:message key="Common.TDMDetails.label" bundle="${common_labels}"/>'  onClick="viewReasonforRequest('<%=TDM_order_id%>');" style="<%=TDM_display%>">
									<fmt:message key="ePH.TDM.label" bundle="${ph_labels}"/></A></td>

								</tr>
							</table>
						</td>
				</tr>
				<tr>
					<td width="7%"  class="label">
						<fmt:message key="ePH.Dose.label" bundle="${ph_labels}"/>&nbsp;
					</td>
					<input type="hidden" name ="display_dosage_type1" value="<%=display_dosage_type1%>" >
					<td width="20%" class="data" colspan='5'>
					<SELECT name="dosage_type_list" id="dosage_type_list" <%=display_dosage_type1%> onChange='setDosageUOM();ExternalDosageCheck("","admndtl","<%=perform_external_database_checks_yn%>")'>
<%
								if (strength_value.equals("0") || !fract_dose_appl_yn.equals("Y") || !calc_dosg_by_freq_durn_yn.equals("Y")) { //fract_dose_appl_yn and calc_dosg_by_freq_durn_yn  added  for  IN032142
%>
									<OPTION VALUE="Q" Selected><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>
<%
								}
								else {	
									String dosage_option_select_s="";
									String dosage_option_select_q="";
									if(dosage_type.equals("Q"))
										dosage_option_select_q="Selected";
									else
										dosage_option_select_s="Selected";
%>
										<OPTION VALUE="S" <%=dosage_option_select_s%>><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></OPTION>
										<OPTION VALUE="Q" <%=dosage_option_select_q%>><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></OPTION>
<%
								}
%>
						</SELECT>

<%
					//if(drug_unit_code.toUpperCase().equals("G") || drug_unit_code.toUpperCase().equals("MG") || drug_unit_code.toUpperCase().equals("MCG") || drug_unit_code.toUpperCase().equals("NCG")){
						
						calc_yn = "Y";
%>
						<input type="text" name='dose' id='dose' value="<%=calculatedDose.equals("0")?"":calculatedDose%>"  size="5" maxlength="6" class="number"  onKeyPress="return allowValidNumber(this,event,8,3);" onblur='calcTotalDose(onCologyRegimenDrugDetails);setChngdDose(document.onCologyRegimenDrugDetails.totalDose.value);ExternalDosageCheck("","admndtl","<%=perform_external_database_checks_yn%>")' class="NUMBER" <%=display_dosage_type2%>>
<!--						<font size="1"><%=drug_unit%></font> -->
						<select name='doseUom' id='doseUom' onChange='' <%=display_dosage_type2%>>
						<option value="<%=strength_uom%>"><%=strength_uom_desc%></option>
						</select>
						<label class='label' <%=display_dosage_type2%> id="slashLabel"><b>/</b></label>
						<select name='caclDoseBy_unit' id='caclDoseBy_unit' onChange='calcTotalDose(onCologyRegimenDrugDetails);setChngdDose(document.onCologyRegimenDrugDetails.totalDose.value);' <%=display_dosage_type2%> <%=disableDoseBy%>> <!-- disableDoseBy Added for ML-MMOH-CRF-1004 -->						
						  <%if(default_dose_type_yn){ // if condition Added for ML-MMOH-CRF-1004 and else for existing -Start %>
						    <option value="kg" <%=caclDoseBy_kg%>>kg</option>
							<option value="m2" <%=caclDoseBy_m2%>>m&sup2;</option>
						  <%} else{%>
							<option value="kg" <%=caclDoseBy_kg%>>Kg</option>
							<option value="m2" <%=caclDoseBy_m2%>>M2</option>
							<% } // if else condition Added for ML-MMOH-CRF-1004 else for existing -End %>
							<%if(!or_dose_type.equals("") && !dosage_type.equals("Q") && default_dose_type_yn){ // Added for ML-MMOH-CRF-0345 - Start %>
							<option value="Ag" <%=caclDoseBy_age%>>age</option> <!-- Age changed to age for ML-MMOH-CRF-1004 -->
							<%} // Added for ML-MMOH-CRF-0345 - End %>
						</select>
					<!--	<label class='label' <%=display_dosage_type2%> id="equalLabel"><b>=</b></label> -->
<%
				//}
%>
						<%-- <input type="text" name='totalDose' id='totalDose' value="<%=doseValue%>" onKeyPress="return allowValidNumber(this,event,8,3);" onblur='checkDose(this,<%=min_unit_dose%>,<%=unit_dose%>);setChngdDose(this.value);ExternalDosageCheck("","admndtl","<%=perform_external_database_checks_yn%>");' class="NUMBER"> --%><!-- commented and added checkBeforeDecimal() and allowValidNumber() functions for ML-BRU-SCF-1437 -->
						<input type="text"  name='totalDose' id='totalDose' value="<%=doseValue%>" maxlength="12" onKeyPress="checkBeforeDecimal(this,event); return allowValidNumber(this,event,8,3);" onblur='checkDose(this,<%=min_unit_dose%>,<%=unit_dose%>);setChngdDose(this.value);ExternalDosageCheck("","admndtl","<%=perform_external_database_checks_yn%>");' class="NUMBER" <%=total_qty_disable%>> <!-- total_qty_disable Added for ML-MMOH-CRF-0345 [IN:057441] -->
						<label class='label' id="totaldoseUOM"><%=drug_unit%></label>
						<img src="../../eCommon/images/mandatory.gif" BORDER="0"></img>
					</td>

					<td  id="DATA" class="DATA"><font size="1"><%=calc_unit%></font></td>
					<input type="hidden" name="doseValue" id="doseValue" value="<%=doseValue%>">
				</tr>				
				</table> 
				<input type="hidden" name="g" id="g" value="<%= eqvlValues.get("G") %>">
				<input type="hidden" name="mg" id="mg" value="<%= eqvlValues.get("MG") %>">
				<input type="hidden" name="mcg" id="mcg" value="<%= eqvlValues.get("MCG") %>">
				<input type="hidden" name="ncg" id="ncg" value="<%= eqvlValues.get("NCG") %>">

				<input type="hidden" name="drug_code" id="drug_code" value="<%= drug_code %>">
				<input type="hidden" name="drug_desc" id="drug_desc" value="<%= drug_desc %>">
				<input type="hidden" name="generic_id" id="generic_id" value="<%= generic_id %>">
				<input type="hidden" name="generic_name" id="generic_name" value="<%= generic_name %>">
				<input type="hidden" name="allergy_yn" id="allergy_yn" value="<%= allergy_yn %>">
				<input type="hidden" name="current_rx" id="current_rx" value="<%= current_rx %>">
				<input type="hidden" name="srl_no" id="srl_no" value="<%= srl_no %>">
				<input type="hidden" name="form_code" id="form_code" value="<%=form_code%>">
				<input type="hidden" name="pres_qty_value" id="pres_qty_value" value="<%= pres_qty_value %>">
				<input type="hidden" name="pres_base_uom" id="pres_base_uom" value="<%= pres_base_uom %>">
				<input type="hidden" name="pres_base_uom_desc" id="pres_base_uom_desc" value="<%= pres_base_uom_desc %>">
				<input type="hidden" name="freq_code" id="freq_code" value="<%= freq_code %>">
				<input type="hidden" name="durn_type" id="durn_type" value="<%= durn_type %>">
				<input type="hidden" name="or_durn_desc" id="or_durn_desc" value="<%= or_durn_desc %>">
				<input type="hidden" name="approval_yn_val" id="approval_yn_val" value="<%= ord_approved_yn %>" >
				<input type="hidden" name="auth_yn_val" id="auth_yn_val" value="<%= ord_authorized_yn %>">
				<input type="hidden" name="ord_authorized_prev_yn" id="ord_authorized_prev_yn" value="<%= ord_authorized_prev_yn %>">
				<input type="hidden" name="cosign_yn_val" id="cosign_yn_val" value="<%= ord_cosigned_yn %>">
				<input type="hidden" name="order_type_code" id="order_type_code" value="<%= order_type_code %>">
				<input type="hidden" name="auth_yn" id="auth_yn" value="<%= auth_yn %>">
				<input type="hidden" name="approval_yn" id="approval_yn" value="<%= approval_yn %>">
				<input type="hidden" name="cosign_yn" id="cosign_yn" value="<%= cosign_yn %>">
				<input type="hidden" name="consent_reqd_yn" id="consent_reqd_yn" value="<%= consent_reqd_yn %>">
				<input type="hidden" name="allergy_desc" id="allergy_desc" value="<%= allergy_desc %>">
				<input type="hidden" name="exceed_dose_desc" id="exceed_dose_desc" value="<%= exceed_dose_desc %>">
				<input type="hidden" name="dup_drug_desc" id="dup_drug_desc" value="<%= dup_drug_desc %>">
				<input type="hidden" name="uom_code" id="uom_code" value="<%= strength_uom %>">
				<input type="hidden" name="strength_uom_desc" id="strength_uom_desc" value="<%= strength_uom_desc %>">
				<input type="hidden" name="str_val" id="str_val" value="<%= strength_value %>">
				<input type="hidden" name="bms_qty" id="bms_qty" value="<%= bms_qty %>">
				<input type="hidden" name="dflt_qty_uom" id="dflt_qty_uom" value="<%= dflt_qty_uom %>">
				<input type="hidden" name="tab_qty_value" id="tab_qty_value" value="<%= tab_qty_value %>">
				<input type="hidden" name="qty_desc_code" id="qty_desc_code" value="<%= qty_desc_code %>">
				<input type="hidden" name="route_code" id="route_code" value="<%=route_code%>">
				<input type="hidden" name="str_desc" id="str_desc" value="">
				<input type="hidden" name="durn_value" id="durn_value" value="<%= durn_value %>">
				<input type="hidden" name="end_date" id="end_date" value="<%= end_date %>">
				<input type="hidden" name="SRL_NO" id="SRL_NO" value="<%= srlNo %>">
				<input type="hidden" name="calc_by_ind" id="calc_by_ind" value="<%=calc_by_ind%>">
				<input type="hidden" name="drug_unit" id="drug_unit" value="<%=drug_unit%>">
				<input type="hidden" name="drug_unit_code" id="drug_unit_code" value="<%=drug_unit_code%>">
				<input type="hidden" name="amend_calc_unit" id="amend_calc_unit" value="<%=dosage_unit%>">
				<input type="hidden" name="daily_dose" id="daily_dose" value="<%= daily_dose %>">
				<input type="hidden" name="unit_dose" id="unit_dose" value="<%= unit_dose %>">
				<input type="hidden" name="unit_dose1" id="unit_dose1" value="<%= unit_dose1 %>"><!-- Added for IN:070451  -->
				<input type="hidden" name="mono_graph" id="mono_graph" value="<%= mono_graph %>">
				<input type="hidden" name="recomm_dosage_unit" id="recomm_dosage_unit" value="<%= recomm_dosage_unit %>">
				<input type="hidden" name="recomm_dosage_by" id="recomm_dosage_by" value="<%= recomm_dosage_by %>">
				<input type="hidden" name="limit_ind" id="limit_ind" value="<%= limit_ind %>">
				<input type="hidden" name="min_unit_dose" id="min_unit_dose" value="<%=min_unit_dose%>">
				<input type="hidden" name="min_unit_dose1" id="min_unit_dose1" value="<%=min_unit_dose1%>"><!-- Added for IN:070451  -->
				<input type="hidden" name="min_daily_dose" id="min_daily_dose" value="<%=min_daily_dose%>">
				<!-- Added for IN:070451 start -->
				<input type="hidden" name="max_daily_ceeling_dose" id="max_daily_ceeling_dose" value="<%=max_daily_ceeling_dose%>">
				<input type="hidden" name="min_daily_ceeling_dose" id="min_daily_ceeling_dose" value="<%=min_daily_ceeling_dose%>">
				<input type="hidden" name="max_unit_ceeling_dose" id="max_unit_ceeling_dose" value="<%=max_unit_ceeling_dose%>">
				<input type="hidden" name="min_unit_ceeling_dose" id="min_unit_ceeling_dose" value="<%=min_unit_ceeling_dose%>">
				<input type="hidden" name="dose_unit_desc" id="dose_unit_desc" value="<%=dose_unit_desc%>">
				<input type="hidden" name="dose_unit_desc1" id="dose_unit_desc1" value="<%=dose_unit_desc1%>">
				<!-- Added for IN:070451 end  -->
				<input type="hidden" name="dosage_std" id="dosage_std" value="<%=dosage_std%>">
				<input type="hidden" name="dosage_type" id="dosage_type" value="<%=dosage_type%>">
				<input type="hidden" name="ocurrance_num" id="ocurrance_num" value="<%=ocurrance_num%>">
				<input type="hidden" name="exceedDosageReasonMand" id="exceedDosageReasonMand" value="N">
				<input type="hidden" name="weight" id="weight" value="<%=weight%>">
				<input type="hidden" name="bsa" id="bsa" value="<%=bsa%>">
				<input type="hidden" name="calc_yn" id="calc_yn" value="<%=calc_yn%>">
				<input type="hidden" name="external_product_id" id="external_product_id" value="<%=ext_prod_id%>">
				<input type="hidden" name="qty_value" id="qty_value" value="<%=qty_value%>">  <!-- Code added for IN032142 -->
				<!--<input type="hidden" name="perform_external_database_checks_yn" id="perform_external_database_checks_yn" value="<%=perform_external_database_checks_yn%>">-->
				<input type="hidden" name="DrugIndicationRemarks" id="DrugIndicationRemarks" value="<%=DrugIndicationRemarks%>"><!--Added for  ML-BRU-CRF-072[Inc:29938]  --->
				<input type="hidden" name="or_dose_type" id="or_dose_type" value="<%=or_dose_type%>"> <!-- Added for ML-MMOH-CRF-0345 -->
				
				<!-- Added for IN:070451 end  -->
       <input type="hidden"  name=allergy_remarks_code value="<%=allergy_remarks_code%>">
       <input type="hidden"  name="dose_remarks_code" id="dose_remarks_code" value="<%=dose_remarks_code%>">
       <input type="hidden"  name="currentrx_remarks_code" id="currentrx_remarks_code" value="<%=currentrx_remarks_code%>">
       <!-- Added for IN:072715 end -->
       <input type="hidden" value="<%=validate_overide_on_confirm_yn%>" name="validate_overide_on_confirm_yn"><!-- Added for IN:069887  -->
<input type="hidden" name="diagnosis_found_yn" id="diagnosis_found_yn" value="<%= diagnosis_found_yn %>"><!-- added for mms-dm-crf-0204 -->
<input type="hidden" name="ord_set_reqd_or_opt" id="ord_set_reqd_or_opt" value="<%= ord_set_reqd_or_opt %>"><!-- added for mms-dm-crf-0204 -->

<%
				if(order_type_flag.equals("Existing")){
%>
				   <input type="hidden" name="pres_remarks" id="pres_remarks" value="<%=pres_remarks%>">
				   <input type="hidden" name="order_id" id="order_id" value="<%=amend_order_id%>">  
<%
				}
			
			//if(!strength_value.equals("0")){
		//		if(!ext_prod_id.equals("") && perform_external_database_checks_yn.equals("Y"))
		//		{
%>
				 <script> 
					//calcTotalDose(onCologyRegimenDrugDetails);
		//		ExternalDosageCheck("","admndtl",'<%=perform_external_database_checks_yn%>');
				 </script> 
<%
	//		}
	  			bean.setSerialNo(ocurrance_num+""); //added for ML-MMOH-CRF-01014
	  }
%>
		</form>
	</body>
<%

	if (!serialNum.equals("")){
%>
		<script>
			parent.oncology_fluid.location.href	="../jsp/OncologyRegimenFluidDetail.jsp?"+'<%=params%>'+"&serial_no="+'<%=serialNum%>'+"&patient_id="+'<%=patient_id%>'+"&encounter_id="+'<%=encounter_id%>'+"&act_patient_class="+'<%=patient_class%>'+"&fluid_frame_display_yn="+'<%=fluid_frame_display_yn%>'+"&start_date="+'<%=start_date%>'+"&amend_serial_no="+'<%=amend_serial_no%>'+"&MAR_app_yn="+'<%=MAR_app_yn%>';
		</script>
<%
	}
	//if(order_type_flag.equals("Existing")&&!pres_remarks.equals("")){
%>
		<script>
			getFormatId('Drug','N');
			saveWtBsa();//Added for IN:070451
		
			<%if(req_diag_pres_found && diagnosis_found_yn.equals("N")){//added for mms-dm-crf-0204
				%>
			
			callCancel();
			
				<%}
	%>	</script>
<%
	//}
%>

</html>

<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,ORbean,request);
}catch(Exception exception) {
       exception.printStackTrace();
 }
%>

