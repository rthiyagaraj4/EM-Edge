<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*" %>
<%@page import="ePH.IVPrescriptionBean"%>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@ page import="java.util.Locale"%>  
<%@ page import ="java.util.ResourceBundle" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<script src="${path}/eIPAD/js/pharmIvRxDetailsViewIntermitant.js"></script> 
<%@include file="../../../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@page import="eOR.OrderEntryBean"%>
<c:set var="path" value = "${pageContext.request.contextPath}"/>
<%
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
	String drugCodes        ="" ;
	String location_type			= request.getParameter("location_type")==null?"":request.getParameter("location_type");
	String location_code			= request.getParameter("location_code")==null?"":request.getParameter("location_code");
	String take_home_medication		= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	String priority					= request.getParameter("priority")==null?"":request.getParameter("priority");
	String iv_prep_yn				= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn"); 
	String facility_id					= (String)session.getValue("facility_id");
	String param_bean_id				= "@DrugInterfaceControlBean";
	String param_bean_name				= "ePH.DrugInterfaceControlBean";
	DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );				
	String ex_bean_id   = "@ExternalProductLinkBean";
	String ex_bean_name = "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);  
	String dflt_disp_locn	= "";	
	String patient_id=patientContext.getPatientId();
    String encounter_id= patientContext.getEncounterId();
	String patient_class= patientContext.getPatientClass();
	ArrayList drugList = new ArrayList() 	;
	String bean_id_pig				= "IVPiggyBackBean"+patient_id+encounter_id;
	String bean_name_pig			= "ePH.IVPiggyBackBean";
	IVPiggyBackBean bean_pig		= (IVPiggyBackBean)getBeanObject( bean_id_pig,bean_name_pig, request ) ;
	String bean_id_IVD			= "@IVPrescriptionBean_IVPB"+ patientContext.getPatientId() + patientContext.getEncounterId();
	String bean_name_IVD	= "ePH.IVPrescriptionBean";
	IVPrescriptionBean iv_bean 	= (IVPrescriptionBean)PersistenceHelper.getBeanObject(bean_id_IVD, bean_name_IVD, request);
	ArrayList ord_disp_location  = (ArrayList) iv_bean.getOrderDispenseLocation(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);
	if(ord_disp_location != null & ord_disp_location.size()>0){
		dflt_disp_locn	= (String)ord_disp_location.get(2);
	}
	String disaExst="";
	String params	= request.getQueryString();
	String adr_count	         = request.getParameter("adr_count")==null?"0":request.getParameter("adr_count");
	String order_id				 = request.getParameter("order_id");
	String mode                  = request.getParameter("mode");
	String answer				= request.getParameter("answer")==null?"":request.getParameter("answer");
	String order_line_num        = request.getParameter("order_line_num");
	String classValue	= request.getParameter("classValue")==null?"":request.getParameter("classValue");
	String drug_db_allergy_check_flag			= "N";
	if(mode==null) 
		mode="";	
	if(order_id==null)
		order_id="";
	String order_type_flag		= request.getParameter("order_type_flag");
	if(order_type_flag==null)   
		order_type_flag="";
	String iv_prep_default		= request.getParameter("iv_prep_default")==null?"":request.getParameter("iv_prep_default");
	String order_set_code		= request.getParameter("order_set_code")==null?"":request.getParameter("order_set_code");
	String prev_order			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String MAR_app_yn = "";
	String buildMAR_checked = "";
	String buildMAR_enable  = ""; 
	String buildMAR_rule	= "";  
	MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	String buildMAR_yn = MAR_app_yn;
    String checked				="";
	String disabled1			= "";
	String readonly			    = "";
	String catalog_desc			= "";
	String drug_codes			= "";
	String qty_value			= "";
	String qtys			= "";
	String qty_unit			    = "";
	String flag1				= "";
	String strDrugCode			= "";
	ArrayList orderSetCodes		=new ArrayList();
	String chk_addmixture       = ""; 
	String time_flag            = ""; 
	String disable_addmixture	= "";
	String alert_practitioner_yn= "";
	String mon_graph	        = "";
	String display              = "display:none";
	String allergy_flag         = "hidden";
	String doselimit_flag       = "hidden";
	String currentrx_flag       = "hidden";
	String over_ride_flag       = "hidden";
	String currentrx_flag_img						= "hidden";
	String allergy_flag_img						= "hidden";
	String doselimit_flag_img						= "hidden";
	String allergy_override_reason="";
	String dosage_limit_override_reason="";
	String duplicate_drug_override_reason="";
	String f_i_flag="N";
	String display_tdm = "visibility:hidden";
	HashMap drugReasons  =  null;
	String uom_code				= "";
	String uom_desc				= "";
	String perform_external_database_checks_yn	=	"N";	
	String external_database_checks_overrided	=	"N";	
	String loading_ext_prod_id					=	"";
	String external_dosage_override_reason		=   "";	
	String external_duplicate_override_reason	=   "";
	String external_interaction_override_reason	=   "";
	String external_contra_override_reason		=   ""; 
	String external_alergy_override_reason		=   ""; 
	String fract_dose_round_up_yn				=   "";
	String drug_db_dosage_check_flag			=   "Y";
	String ext_prod_id							=   "";
	String external_checks						=   "hidden";
	String duplicate_drug_override_reason_flag	=  "N";
	String interaction_override_reason_flag		=  "Y";
	String contraind_override_reason_flag		=  "N";
	String drug_adr_style						= "hidden";	
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;		
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();
	String pract_id		= (String)ORbean.getPractitionerId();	
	drugList		= iv_bean.getDrugDetails(); 	
	String strength_value		="0";
	String strength_uom_desc	="";
	String strength_uom			="";
	String dosage_type			="";
	HashMap drugDetails	    = null;
	HashMap drugDetailsAmend	    = null;
	if(drugList.size() > 0){
		if(drugList !=null && drugList.size() > 0)
		drugDetails			= (HashMap)drugList.get(0);	
		strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
		strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
		strength_uom			= (String)drugDetails.get("STRENGTH_UOM");
		dosage_type			= (String)drugDetails.get("DOSAGE_TYPE");		
	}
	String disabled	= "";
	String drug_desc="";
	String daily_dose="";
	String min_daily_dose="";
	String min_unit_dose="";
	String unit_dose="";
	String dosage_std="";
	String recomm_dosage_by="";
	String calc_by_ind="";
	String dosage_unit="";
	String iv_ingredient_yn="";
	String iv_fluid_yn="";
	String generic_id			="";
	String generic_name			="";
	String mono_graph			="";
	String limit_ind			="";
	String allergy_yn			="";
	String current_rx			="";	
	String srl_no				="";
	String form_code			="";
	String pres_qty_value		="";
	String pres_base_uom		="";
	String freq_code			="";
	String durn_value			="";
	String or_durn_desc			="";
	String auth_yn				="";
	String approval_yn			="";
	String cosign_yn			="";
	String consent_reqd_yn		="";
	String order_type_code		="";
	String fract_dose_appl_yn	="";		                             
	String route_code			="";
	String startdate			="";
	String end_date				="";
	String dup_drug_desc		="";
	String allergy_desc			="";
	String exceed_dose_desc		="";
	String bms_qty				="";
	String dflt_qty_uom			="";
	String tab_qty_value		="";
	String qty_desc_code		="";
	String amend_yn				="";
	String ord_auth_reqd_yn		="";		
	String ord_spl_appr_reqd_yn	="";	
	String ord_cosign_reqd_yn	="";	
	String ord_authorized_yn	="";	
	String ord_authorized_prev_yn	="";
	String ord_approved_yn		="";	
	String ord_cosigned_yn		="";	
	String sRegRopt				= "";
	String disp_location_desp	="";
	String disp_location_code	="";
	String strength_per_value_pres_uom = "";
	String strength_per_pres_uom	   = "";
	String serialNum			= "";	
	String dosage_uom_code		= "";
	String calc_dose_based_on	= "D";
	String calc_dose_by		    = "";
	String selD="selected";
	String selB="";
	String sel="D";
	String calc_dose_value	    = "";
	String displaydose			= "";
	String displayBSA			= "style='display:none'";
	String kg_selected			= "Selected";
	String m2_selected			= "";
	String select_calc_dose_Dosage="checked";
	String select_calc_dose_WT_BSA="";
	String disable_calc_dose	  ="";
	ArrayList orderSetValues	  = new ArrayList();
	String dflt_code			  = "";
	String DrugIndicationRemarks		=   "";
	int dose_decimal			  = 2;
	String vehicle_code="";
	String vehicle_desp="";
	String volumeCode="ml";
	String drunDuration="";
	String 	disp_str = "";
	String volume="";	
	disabled	= "";
	int srlNo		= 0;
	drugList			= iv_bean.getDrugDetails();
	orderSetValues	    = iv_bean.getOrderSetValues();
	generic_id			= (String)drugDetails.get("GENERIC_ID");
	drug_desc			= (String)drugDetails.get("DRUG_DESC");
	String recomm_yn			= (String)drugDetails.get("RECOMM_YN")==null?"":(String)drugDetails.get("RECOMM_YN");
	String trade_name= (String)drugDetails.get("TRADE_NAME");
	String trade_code= (String)drugDetails.get("TRADE_CODE");
	String SHORT_DESC=(String)drugDetails.get("SHORT_DESC");
	String dosage_by 		    = (String)drugDetails.get("DOSAGE_TYPE");
	drug_codes			= (String)drugDetails.get("DRUG_CODE");
	generic_name		= (String)drugDetails.get("GENERIC_NAME");
	daily_dose			= (String)drugDetails.get("DAILY_DOSE");
	min_daily_dose		= (String)drugDetails.get("MIN_DAILY_DOSE")==null?"":(String)drugDetails.get("MIN_DAILY_DOSE");
	min_unit_dose		= (String)drugDetails.get("MIN_UNIT_DOSE")==null?"":(String)drugDetails.get("MIN_UNIT_DOSE");
	unit_dose			= (String)drugDetails.get("UNIT_DOSE")==null?"":(String)drugDetails.get("UNIT_DOSE");
	dosage_std			= (String)drugDetails.get("DOSAGE_STD")==null?"":(String)drugDetails.get("DOSAGE_STD");
	recomm_dosage_by	= (String)drugDetails.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetails.get("RECOMM_DOSAGE_BY");
	calc_by_ind			= (String)drugDetails.get("CALC_BY_IND")==null?"":(String)drugDetails.get("CALC_BY_IND");
	mono_graph			= (String)drugDetails.get("MONO_GRAPH")==null?"":(String)drugDetails.get("MONO_GRAPH");
	limit_ind			= (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
	allergy_yn			= (String)drugDetails.get("ALLERGY_YN");
	current_rx			= (String)drugDetails.get("CURRENT_RX");
	srl_no				= (String)drugDetails.get("SRL_NO");
	strength_value		= (String)drugDetails.get("STRENGTH_VALUE");
	strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
	strength_uom		= (String)drugDetails.get("STRENGTH_UOM");
	form_code			= (String)drugDetails.get("FORM_CODE");
	pres_qty_value		= (String)drugDetails.get("PRES_QTY_VALUE");
	pres_base_uom		= (String)drugDetails.get("PRES_BASE_UOM");
	freq_code			= (String)drugDetails.get("FREQ_CODE");
	durn_value			= (String)drugDetails.get("DURN_VALUE");
	or_durn_desc		= (String)drugDetails.get("OR_DURN_DESC");
	auth_yn				= (String)drugDetails.get("AUTH_YN");
	approval_yn			= (String)drugDetails.get("APPROVAL_YN");
	cosign_yn			= (String)drugDetails.get("COSIGN_YN");
	consent_reqd_yn		= (String)drugDetails.get("CONSENT_REQD_YN");
	order_type_code		= (String)drugDetails.get("ORDER_TYPE_CODE");
	fract_dose_appl_yn	= (String)drugDetails.get("FRACT_DOSE_APPL_YN")==null?"":(String)drugDetails.get("FRACT_DOSE_APPL_YN");
	route_code			= (String)drugDetails.get("ROUTE_CODE");
	end_date			= (String)drugDetails.get("END_DATE");			
	startdate			= (String)drugDetails.get("START_DATE");
	volume=iv_bean.getVOLUME();	
		dup_drug_desc			= (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails.get("CURRENTRX_REMARKS");
		allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS")==null?"":(String)drugDetails.get("ALLERGY_REMARKS");
		exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS")==null?"":(String)drugDetails.get("DOSE_REMARKS");
	drunDuration= (String)drugDetails.get("DURN_VALUE");	
	DrugIndicationRemarks		=  (String)drugDetails.get("DRUG_INDICATION")==null?"":(String)drugDetails.get("DRUG_INDICATION");	
	external_dosage_override_reason			= (String) drugDetails.get("DOSE_REMARKS")==null?"":(String) drugDetails.get("DOSE_REMARKS");		
	external_duplicate_override_reason		= (String) drugDetails.get("CURRENTRX_REMARKS")==null?"":(String) drugDetails.get("CURRENTRX_REMARKS");	
	external_interaction_override_reason	= (String) drugDetails.get("DRUG_INDICATION")==null?"":(String) drugDetails.get("DRUG_INDICATION");	
	external_alergy_override_reason			= (String) drugDetails.get("ALLERGY_REMARKS")==null?"":(String) drugDetails.get("ALLERGY_REMARKS");						
		String CALC_DOSE_BY=(String) drugDetails.get("CALC_DOSE_BY")==null?"":(String) drugDetails.get("CALC_DOSE_BY");		
		  if(CALC_DOSE_BY.equalsIgnoreCase("M2")){			  
	                                    kg_selected			= "";
	                                    m2_selected			= "selected";
		  }		
			calc_dose_based_on=(String) drugDetails.get("CALC_DOSE_BASED_ON")==null?"":(String) drugDetails.get("CALC_DOSE_BASED_ON");			
			if(calc_dose_based_on.equalsIgnoreCase("D")){				
				selD="selected";
				sel="D";
			}else if (calc_dose_based_on.equalsIgnoreCase("B")){				
				selB="selected";
				sel="B";
			}			
	String calculteBY="";
	calculteBY=calculteBY + "<option  value='D'" +selD +">Dosage</option>";	
	calculteBY=calculteBY + "<option  value='B' "+selB +">Body wt/BSA</option>";		
	if(!DrugIndicationRemarks.equals(""))
		 DrugIndicationRemarks = java.net.URLEncoder.encode(DrugIndicationRemarks,"UTF-8"); 
	buildMAR_rule=(String)drugDetails.get("BUILD_MAR_RULE");
	buildMAR_yn="N";			
	if(buildMAR_rule.equals("CE")){
		buildMAR_enable="";
		buildMAR_checked="checked";
		buildMAR_yn="Y";						
	}
	else if(buildMAR_rule.equals("UE")){
		buildMAR_enable="";
		buildMAR_checked="";
	}
	else if(buildMAR_rule.equals("CD")){
		buildMAR_enable="disabled";
		buildMAR_checked="checked";
		buildMAR_yn="Y";						
	}
	else if(buildMAR_rule.equals("UD")){
		buildMAR_enable="disabled";
		buildMAR_checked="";
	}
	iv_bean.setBuildMAR_yn(buildMAR_yn);	
strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
strength_uom		= (String)drugDetails.get("STRENGTH_UOM");		
qtys					= (String)drugDetails.get("QTY_VALUE");
	bms_qty						= (String)drugDetails.get("BMS_QTY");
	dflt_qty_uom				= (String)drugDetails.get("DFLT_QTY_UOM");
	tab_qty_value				= (String)drugDetails.get("TAB_QTY_VALUE");
	qty_unit          =(String)drugDetails.get("QTY_DESC_CODE");
	qty_desc_code				= (String)drugDetails.get("QTY_DESC_CODE")==null?(String)drugDetails.get("QTY_UNIT"):(String)drugDetails.get("QTY_DESC_CODE");
	amend_yn					= (String)drugDetails.get("AMEND_YN");
	qty_value					= (String)drugDetails.get("QTY_VALUE");
	dosage_unit					= (String)drugDetails.get("DOSAGE_UNIT");
	ord_auth_reqd_yn			= (String)drugDetails.get("ORD_AUTH_REQD_YN");
	ord_spl_appr_reqd_yn		= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
	ord_cosign_reqd_yn			= (String)drugDetails.get("ORD_COSIGN_REQD_YN");
	ord_authorized_yn			= (String)drugDetails.get("ORD_AUTHORIZED_YN");
	ord_authorized_prev_yn		= (String)drugDetails.get("ORD_AUTHORIZED_PREV_YN");
	ord_approved_yn				= (String)drugDetails.get("ORD_APPROVED_YN");
	ord_cosigned_yn				= (String)drugDetails.get("ORD_COSIGNED_YN");			
	sRegRopt					= (String)drugDetails.get("REQD_OR_OPT_IND"); 
	strength_per_value_pres_uom = (String)drugDetails.get("STRENGTH_PER_VALUE_PRES_UOM");
	strength_per_pres_uom		= (String)drugDetails.get("STRENGTH_PER_PRES_UOM");	
	ext_prod_id					= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
	drug_db_dosage_check_flag	= (String)drugDetails.get("EXT_MED_ALERTS_FIRED_FOR_DOSAGE_CHECK_YN");	
	disp_location_desp					= (String)drugDetails.get("DISP_LOCN_DESC");
	disp_location_code					= (String)drugDetails.get("DISP_LOCN_CODE");
	
	
     
     
	iv_ingredient_yn = (String)drugDetails.get("IV_INGREDIENT_YN");
	iv_fluid_yn      = (String)drugDetails.get("IV_FLUID_YN");
	perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");			
	dosage_uom_code				= (String)drugDetails.get("PRES_BASE_UOM")==null?qty_desc_code:(String)drugDetails.get("PRES_BASE_UOM");
	String dosageBY="";
	if (strength_value.equals("0")) {
		dosageBY=dosageBY+	"<OPTION VALUE='Q'>Quantity</OPTION>";
	}
	else {
		if(dosage_type.equals("Q")) {
			dosageBY=dosageBY+	"<OPTION VALUE='S'>Strength</OPTION>";
			dosageBY=dosageBY+	"<OPTION VALUE='Q' SELECTED>Quantity</OPTION>";
		}
		else {
			dosageBY=dosageBY+	"<OPTION VALUE='S' SELECTED>Strength</OPTION>";
			dosageBY=dosageBY+	"<OPTION VALUE='Q' >Quantity</OPTION>";
		}
	}
	String calcDoseValueUnit="";
	calcDoseValueUnit=calcDoseValueUnit + "<option  value='"+strength_uom +"'selected>"+strength_uom_desc+"</option>";	
	String calcDoseQualitySelection=""; 
	calcDoseQualitySelection=calcDoseQualitySelection+"<option value='KG' "+ kg_selected +">KG</option>";
	calcDoseQualitySelection=calcDoseQualitySelection+"<option value='M2' "+ m2_selected +" >M2</option>";		
	String str_value = "";
	String type="";
	if (strength_value.equals("0")) {
		disabled = "";
		str_value	= pres_qty_value;
		type="Dose";
	}
	else {
		if(dosage_type.equals("S")) {
			str_value	= strength_value;
			disabled	= "DISABLED";
			type="Strength";
		}
		else {
			str_value	= qtys;
			disabled	= "";
			type="Dose";						
		}
	}
	if(qty_value!=null && !qty_value.equals("")) {
		//str_value	=	qty_value;
	}
	if(orderSetValues.size() > 0){
		for(int i = 0; i < orderSetValues.size(); i=i+8){
			if(orderSetValues.get(i).equals(drug_codes)){
				qty_value	= (String)orderSetValues.get(i+1);
				if(dosage_type.equals("S")){
					str_value = ((Float.parseFloat(qty_value)*Float.parseFloat(strength_value))/Float.parseFloat(strength_per_value_pres_uom))+"";
				}
			}
		}
	}
	String SterngthOrQulityVals=""; 
	if (!strength_value.equals("0")) {
		if(dosage_type.equals("S")) {
			SterngthOrQulityVals=SterngthOrQulityVals+"<option  value='"+strength_uom +"'selected>"+strength_uom_desc+"</option>";
		}
		else {
			//SterngthOrQulityVals=SterngthOrQulityVals+"<option  value=''>selected</option>";
			Hashtable QtyDescDetails	= (Hashtable)iv_bean.listQtyDetails(drug_codes);
			Enumeration keys_des		= QtyDescDetails.keys();
			String def_uom				= "";
			while(keys_des.hasMoreElements()) {
				uom_code	= (String)keys_des.nextElement();
				uom_desc	= (String)QtyDescDetails.get(uom_code);
				if(!uom_code.equals("dflt_code")) {
					if(uom_code.equals(dosage_uom_code))
						def_uom = "SELECTED";
					else
						def_uom = "";
					SterngthOrQulityVals=SterngthOrQulityVals+"<option  value='"+uom_code +"'"+def_uom+">"+uom_desc+"</option>";
				}
			}
		}
	}
	else {
		//SterngthOrQulityVals=SterngthOrQulityVals+"<option  value=''>selected</option>";
		Hashtable QtyDescDetails	= (Hashtable)iv_bean.listQtyDetails(drug_codes);
		Enumeration keys_des		= QtyDescDetails.keys();
		String def_uom				= "";
		if (amend_yn == null || amend_yn.equals("N"))
			dflt_code = QtyDescDetails.get("dflt_code") == null ? "" : QtyDescDetails.get("dflt_code").toString();
		else
			dflt_code = qty_desc_code;
		while(keys_des.hasMoreElements()) {
			uom_code	= (String)keys_des.nextElement();
			uom_desc	= (String)QtyDescDetails.get(uom_code);
			if(!uom_code.equals("dflt_code")) {
				if(uom_code.equals(qty_unit))
					def_uom = "SELECTED";
				else
					def_uom = "";
				SterngthOrQulityVals=SterngthOrQulityVals+"<option  value='"+uom_code +"'"+def_uom+">"+uom_desc+"</option>";
			}
		}
	}
	calc_dose_by			= (String)drugDetails.get("CALC_DOSE_BY")==null?"KG":(String)drugDetails.get("CALC_DOSE_BY");
	calc_dose_value			= (String)drugDetails.get("CALC_DOSE_VALUE")==null?"":(String)drugDetails.get("CALC_DOSE_VALUE");
	String end_date_time		="";
	String infuse_over			="";
	String infusion_rate		="";
	String selected1            ="";
	String selected2            ="";
	String durn_value_new			="";
	String freq_value			="";
	String optSelected			="";
	String order_catalog_code	="";
	String order_catalog_code1  ="";
	String stock_uom_code		="", stock_uom_desc=""; 
	String stock_value			="";
	String optSelected1			="";
	int    durn_value1			=0; 
	int    J					=0; 
	String order_line_num_new       ="";
	String temp					="";
	String infusion_over_time	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
	String durn_type1			="";
	String readonly_new				="";
	String disabled_new				="";
	String  repeat_value		="";
	String drug_code			="";
	String srl_no_new               ="";
	String infusion_uom			="H"; 
	String order_id_new				= request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_type_flag_new		= request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String mode_new					= request.getParameter("mode")==null?"":request.getParameter("mode");
	String prev_order_new			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String patient_id_new			= request.getParameter("patient_id");
	String patient_class_new		= request.getParameter("act_patient_class");
	String encounter_id_new			= request.getParameter("encounter_id");
	String facility_id_new			= (String)session.getValue("facility_id");
	String answer_new				= request.getParameter("answer")==null?"":request.getParameter("answer");
	String order_date	= iv_bean.getOrderDate();
	String sys_date				= order_date;
	String infuse_over_hr	= "";
	String infuse_over_mi	= "";
	String infuse_over_units	= "";
	String durn_type		= "";
	String durn_calc		= "";
	String freq_nature		= "F";
	String freq_value_durn	= "";
	String interval_value	= "";
	String repeat_value_durn= "";
	String schedule_yn		= "";
	String repeat_durn_type	= "";
	String freq_durn_type	= "";
	String scheduled_yn		= "N";
	String split_dose_yn	= "";
	String qty_value_new		= "";
	String freq_code_new		= "";
	ArrayList tmp_freq_values = new ArrayList();
	float total_qty			= 0.0f;
	String final_qty		= "";
	boolean split_chk		=	false;
	String tooltiptable		= "";
	String adm_time			= "";
    HashMap record;
	HashMap record1;	
	HashMap chkValuescheduleFrequency	=	null;
	ArrayList frequencyValues	        =	null;
	HashMap fluid_det =(HashMap)iv_bean.getFluidDetails();	
	if(scheduled_yn.equals("Y")){ 
	chkValuescheduleFrequency	        = iv_bean.getscheduleFrequency();	
	if(chkValuescheduleFrequency!= null && chkValuescheduleFrequency.size()>0){
		frequencyValues			= (ArrayList) chkValuescheduleFrequency.get(order_catalog_code);
		}
	} 	
	infuse_over=     (String)fluid_det.get("INFUSE_OVER");
	infusion_rate = (String)fluid_det.get("INFUSION_RATE");
	infuse_over_hr	= (String)fluid_det.get("INFUSION_PERIOD_VALUE");
	infuse_over_mi	=  (String)fluid_det.get("INFUSION_PERIOD_VALUE_MIN");
	infuse_over_units =  (String)fluid_det.get("INFUSE_OVER_UNIT");
	volumeCode=(String)fluid_det.get("PRES_BASE_UOM_DESC")==null?"":(String)fluid_det.get("PRES_BASE_UOM_DESC");	
	vehicle_code 			= (String)drugDetails.get("vehicle");	
	if(vehicle_code==null || vehicle_code==""){
		vehicle_code 			= (String)fluid_det.get("DRUG_CODE");		
	}		
	disp_str="["+infuse_over_hr+" Hrs "+infuse_over_mi+" Mins]";	
	
	ArrayList stockDetails = iv_bean.getStockDetails(vehicle_code, "1");


	String volume_unit_value="";


	if (stockDetails.size() != 0){
		
		volume_unit_value=(String)stockDetails.get(1);
		vehicle_desp=iv_bean.getUomDisplay((String)session.getValue("facility_id"),(String)stockDetails.get(1));
	}
		
	
	
	infuse_over=	(String)drugDetails.get("SCH_INFUSION_RATE")==null?"":(String)drugDetails.get("SCH_INFUSION_RATE");	
	infuse_over_hr =(String)drugDetails.get("INFUSION_PERIOD_VALUE")==null?"":(String)drugDetails.get("INFUSION_PERIOD_VALUE");	
	infuse_over_mi = (String)drugDetails.get("INFUSION_PERIOD_VALUE_MIN")==null?"":(String)drugDetails.get("INFUSION_PERIOD_VALUE_MIN");	
	infusion_rate = (String)drugDetails.get("INFUSION_RATE")==null?"":(String)drugDetails.get("INFUSION_RATE");	
	infuse_over_units =(String)drugDetails.get("INFUSION_PERIOD_UOM")==null?"":(String)drugDetails.get("INFUSION_PERIOD_UOM");		
	disp_str="["+infuse_over_hr+" Hrs "+infuse_over_mi+" Mins]";	
		if(infuse_over_units.equalsIgnoreCase("H")){
		selected1="selected";		
	}else{
			selected2="selected";		
	}	
	/* Banner Indicator Starts */	
	String display_auth_rule = "display:none";
    String color_auth_rule   = "";	
	String drug_db_interact_check_flag	= "N";
	String drug_db_interface_yn			= "N";
	String drug_db_product_id			= "";
	String drug_db_dosecheck_yn			= "N";
	String drug_db_duptherapy_yn		= "N";
	String drug_db_interact_check_yn	= "N";
	String drug_db_contraind_check_yn	= "N";
	String drug_db_allergy_check_yn		= "N";
	String dup_drug_det					= "";
	String drug_db_duptherapy_flag		= "N";
	String drug_db_contraind_check_flag	= "N";
	String external_database_overrided_yn = "";
	String external_database_overrided_reason = "";	
	String[] sDrugDBAllChecks = param_bean.drugDBALLChecksYN(facility_id);
	if(sDrugDBAllChecks != null && sDrugDBAllChecks.length>6){
		drug_db_interface_yn			=	sDrugDBAllChecks[0];    
		drug_db_product_id			=	sDrugDBAllChecks[1];    
		drug_db_dosecheck_yn			=	sDrugDBAllChecks[2];    
		drug_db_duptherapy_yn		=	sDrugDBAllChecks[3];    
		drug_db_interact_check_yn	=	sDrugDBAllChecks[4];      
		drug_db_contraind_check_yn	=	sDrugDBAllChecks[5];    
		drug_db_allergy_check_yn		=	sDrugDBAllChecks[6];    
	}	
	if(order_type_flag.equals("Existing")||mode.equals("amend")){
	
			disabled1="disabled";
			if(!prev_order.equals("") && prev_order.equals("previous")){
				readonly="";
			}
			else{
				readonly="readonly";
			}
			String act_pat_class = request.getParameter("act_pat_class")== null?"": request.getParameter("act_pat_class");  
			ArrayList exstngIVorder = (ArrayList)iv_bean.getExistingIVRecords(order_id,answer,act_pat_class); 
			record					= new HashMap();
			int siz=exstngIVorder.size();
			String lengt=siz+"";
			if(lengt.equals("1")){
				drugDetailsAmend					= (HashMap)exstngIVorder.get(0);
			}
			else{
				drugDetailsAmend					= (HashMap)exstngIVorder.get(1);
			}
			pres_base_uom = drugDetailsAmend.get("PRES_BASE_UOM")==null?"":(String) drugDetailsAmend.get("PRES_BASE_UOM"); 
			strength_per_value_pres_uom = drugDetailsAmend.get("STRENGTH_PER_VALUE_PRES_UOM")==null?"":(String) drugDetailsAmend.get("STRENGTH_PER_VALUE_PRES_UOM"); 	
			strength_value = drugDetailsAmend.get("STRENGTH_VALUE")==null?"":(String) drugDetailsAmend.get("STRENGTH_VALUE"); 
			drug_desc				= drugDetailsAmend.get("DRUG_DESC")==null?(String)drugDetailsAmend.get("CATALOG_DESC"):(String)drugDetailsAmend.get("DRUG_DESC");
			catalog_desc			= (String)drugDetailsAmend.get("CATALOG_DESC");
			drug_codes				= (String)drugDetailsAmend.get("ORDER_CATALOG_CODE");			
			dosage_type			    = (String)drugDetailsAmend.get("DOSAGE_TYPE");
			dup_drug_desc			= (String)drugDetails.get("CURRENTRX_REMARKS")==null?"":(String)drugDetails.get("CURRENTRX_REMARKS");
			allergy_desc			= (String)drugDetails.get("ALLERGY_REMARKS")==null?"":(String)drugDetails.get("ALLERGY_REMARKS");
			exceed_dose_desc		= (String)drugDetails.get("DOSE_REMARKS")==null?"":(String)drugDetails.get("DOSE_REMARKS");			
			buildMAR_yn = drugDetailsAmend.get("BUILD_MAR_YN")==null?"":drugDetailsAmend.get("BUILD_MAR_YN").toString();
			if(buildMAR_yn!=null && buildMAR_yn.equals("Y"))
				buildMAR_checked ="Checked";
			else{
				buildMAR_checked ="";
				buildMAR_yn="N";
			}			
			buildMAR_rule=drugDetailsAmend.get("BUILD_MAR_RULE").toString();
			buildMAR_rule=buildMAR_rule==null?"":buildMAR_rule;
			
			if(buildMAR_rule.equals("CE")){
				buildMAR_enable="";
			}
			else if(buildMAR_rule.equals("UE")){
				buildMAR_enable="";
			}
			else if(buildMAR_rule.equals("CD")){
				buildMAR_enable="disabled";
			}
			else if(buildMAR_rule.equals("UD")){
				buildMAR_enable="disabled";
			}
			iv_bean.setBuildMAR_yn(buildMAR_yn);		
			if(drugDetails != null && drugDetails.size() >0){
			ord_auth_reqd_yn			= (String)drugDetails.get("ORD_AUTH_REQD_YN");
			ord_spl_appr_reqd_yn		= (String)drugDetails.get("ORD_SPL_APPR_REQD_YN");
			ord_cosign_reqd_yn			= (String)drugDetails.get("ORD_COSIGN_REQD_YN");
			ord_authorized_yn			= (String)drugDetails.get("ORD_AUTHORIZED_YN");
				strength_uom_desc	= (String)drugDetails.get("STRENGTH_UOM_DESC");
				strength_uom		= (String)drugDetails.get("STRENGTH_UOM");				
				current_rx = (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
				limit_ind  = (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
				allergy_yn = (String)drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN");
			}
			if(drug_db_dosecheck_yn.equals("Y") && ext_prod_id != "") {
				drugDetails.put("LIMIT_IND","Y");
			}
			 drugReasons=new HashMap();
		     iv_ingredient_yn = (String)drugDetails.get("IV_INGREDIENT_YN");
			 iv_fluid_yn      = (String)drugDetails.get("IV_FLUID_YN");
			 if( iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("Y")){
				 order_line_num="1";f_i_flag="Y";
			 }
			 else{
				 order_line_num="2";
			 }		 
			 ext_prod_id					= (String)drugDetails.get("EXTERNAL_PRODUCT_ID")==null?"":(String)drugDetails.get("EXTERNAL_PRODUCT_ID");
			if(mode.equals("amend")){
				drugReasons=iv_bean.getDrugReasons(order_id,order_line_num,ext_prod_id);
			}
			allergy_override_reason=(String)drugReasons.get("ALLERGY_OVERRIDE_REASON")==null?"":(String)drugReasons.get("ALLERGY_OVERRIDE_REASON");
			dosage_limit_override_reason=(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DOSAGE_LIMIT_OVERRIDE_REASON");
			duplicate_drug_override_reason=(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON")==null?"":(String)drugReasons.get("DUPLICATE_DRUG_OVERRIDE_REASON");		
			if(!allergy_override_reason.equals("")){
				allergy_flag="visible";
				allergy_yn="Y";
			}
			if(!dosage_limit_override_reason.equals("")){
				doselimit_flag="visible";
				limit_ind="N";
			}
			if(!duplicate_drug_override_reason.equals("")){
				currentrx_flag="visible";
				current_rx="Y";
			}	
			mon_graph				= (String)drugDetailsAmend.get("MONO_GRAPH");
			recomm_yn				= (String)drugDetailsAmend.get("RECOMM_YN");
			if(recomm_yn.equals("Y")){
				drug_desc				= (String)drugDetails.get("DRUG_DESC");
				daily_dose				= (String)drugDetailsAmend.get("DAILY_DOSE");
				unit_dose				= (String)drugDetailsAmend.get("UNIT_DOSE");
				min_daily_dose		    = (String)drugDetailsAmend.get("MIN_DAILY_DOSE");
				min_unit_dose			= (String)drugDetailsAmend.get("MIN_UNIT_DOSE");
				dosage_unit			    = (String)drugDetailsAmend.get("DOSAGE_UNIT")==null?"":(String)drugDetailsAmend.get("DOSAGE_UNIT");	   
				dosage_std			    = (String)drugDetailsAmend.get("DOSAGE_STD")==null?"":(String)drugDetailsAmend.get("DOSAGE_STD");	   
				calc_by_ind			    = (String)drugDetailsAmend.get("CALC_BY_IND")==null?"":(String)drugDetailsAmend.get("CALC_BY_IND");	   
				recomm_dosage_by			    = (String)drugDetailsAmend.get("RECOMM_DOSAGE_BY")==null?"":(String)drugDetailsAmend.get("RECOMM_DOSAGE_BY");	   
				dosage_by			    = (String)drugDetailsAmend.get("DOSAGE_TYPE")==null?"":(String)drugDetailsAmend.get("DOSAGE_TYPE");	   
				display="display:inline";
			}
			else{
				display="display:none";
			}
			if(order_type_flag.equals("Existing")){
			  flag1="Existing";	
			  iv_bean.setOrder_type_flag(flag1);
			} 			
			if(iv_prep_yn==null)      
				iv_prep_yn="";
			if(iv_prep_yn.equals("3"))
				checked="";
			else  
				   checked="checked"; 
		}	
	if(perform_external_database_checks_yn.equals("Y")&& !(ext_prod_id.equals("")) ){
		if((drug_db_duptherapy_yn.equals("Y"))||drug_db_interact_check_yn.equals("Y")||drug_db_contraind_check_yn.equals("Y")||drug_db_allergy_check_yn.equals("Y") ){
			HashMap tempDetails= null;
			HashMap drugDBCheckResult= null;
			ArrayList reqChecks = new ArrayList();
			reqChecks.add("N"); 
			reqChecks.add(drug_db_duptherapy_yn);
			reqChecks.add(drug_db_interact_check_yn); 
			reqChecks.add(drug_db_contraind_check_yn);
			reqChecks.add(drug_db_allergy_check_yn); 
			ArrayList exProd				= new ArrayList();
			ArrayList drug_desc_array		= new ArrayList();
			drug_desc_array.add(drug_desc);
			if(!ext_prod_id.equals(""))
				exProd.add(ext_prod_id);
			drugDBCheckResult = beanex.getExternalDBChecks( reqChecks, ext_prod_id, patient_id, "", exProd ,drug_desc_array, null, "Y", startdate, end_date); 
			if(drugDBCheckResult!=null)
				beanex.setExternalDBCheckResult(ext_prod_id,srl_no,drugDBCheckResult);
			if(drug_db_allergy_check_yn.equals("Y")){
				if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ 
				   String allergy_alert			= (String)drugDBCheckResult.get("ALLERGYCHECK");
				   if(allergy_alert!=null && !allergy_alert.equals(""))
						drug_db_allergy_check_flag="Y";
				} 
				else {  
					tempDetails =(HashMap)drugDBCheckResult.get("ALLERGYCHECK");
					if(tempDetails!=null && tempDetails.size()>0){
						 drug_db_allergy_check_flag="Y";
					}
				} 
			}
			if(drug_db_interact_check_yn.equals("Y")){
				tempDetails =(HashMap)drugDBCheckResult.get("INTRACHECK");
				if(tempDetails!=null && tempDetails.size()>0){
					drug_db_interact_check_flag="Y";
				}
				else									
					drug_db_interact_check_flag="N";
			}
			if(drug_db_duptherapy_yn.equals("Y")){ 
				dup_drug_det			= (String)drugDBCheckResult.get("DUPCHECK");
				if(dup_drug_det!=null && !dup_drug_det.equals(""))
					drug_db_duptherapy_flag="Y";
				else{
					drug_db_duptherapy_flag="N";
				}
			}
			if(drug_db_contraind_check_yn.equals("Y")){
				tempDetails =(HashMap)drugDBCheckResult.get("CONTRACHECK");
				if(tempDetails!=null && tempDetails.containsKey(ext_prod_id)){
					drug_db_contraind_check_flag="Y";
				}		
				else
					drug_db_contraind_check_flag="N";
			}
		}
		if(drugDetails != null){
			drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_DUP_CHECK_YN",drug_db_duptherapy_flag);
			drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_INTE_CHECK_YN",drug_db_interact_check_flag);
			drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_CONTRA_CHECK_YN",drug_db_contraind_check_flag);
			drugDetails.put("EXT_MED_ALERTS_FIRED_FOR_ALLERGY_CHECK_YN",drug_db_allergy_check_flag);
		}
		drugDetails.put("DRUG_DB_PRODUCT_ID",drug_db_product_id);
		if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
			external_database_overrided_yn = "Y";
		if(external_database_overrided_yn.equals("Y") && (external_interaction_override_reason.equals("")|| external_duplicate_override_reason.equals("") || external_contra_override_reason.equals("") || external_dosage_override_reason.equals("") || external_alergy_override_reason.equals("")))
			external_database_overrided_reason="N";
		else
			external_database_overrided_reason="Y";

		if(external_database_overrided_reason !=null && external_database_overrided_reason.equals("Y"))
			external_checks	= "hidden";
		else
			external_checks = "visible";
		drugDetails.put("EXTERNAL_DATABASE_OVERRIDED_REASON",external_database_overrided_reason);

		if(drug_db_dosecheck_yn.equals("N") && drug_db_duptherapy_yn.equals("N") && drug_db_interact_check_yn.equals("N") && drug_db_contraind_check_yn.equals("N") && drug_db_allergy_check_yn.equals("N"))
			external_checks	= "hidden";
		if(drug_db_duptherapy_flag.equals("Y"))
			currentrx_flag = "hidden";
		if(drug_db_dosage_check_flag.equals("Y"))
			doselimit_flag = "hidden";
		if(drug_db_allergy_check_flag.equals("Y"))
			allergy_flag = "hidden";
	}
	else{
		drug_db_product_id = "";
	}	
	if(drug_db_dosage_check_flag.equals("Y") || drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") || drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_check_flag.equals("Y"))
		external_database_overrided_yn = "Y";
	if(external_database_overrided_yn.equals("Y") && (drug_db_interact_check_flag.equals("Y") && external_interaction_override_reason.equals(""))|| (drug_db_duptherapy_flag.equals("Y") && external_duplicate_override_reason.equals("") )|| (drug_db_contraind_check_flag.equals("Y")&& external_contra_override_reason.equals("") )|| (drug_db_dosage_check_flag.equals("Y") && external_dosage_override_reason.equals("")) || (drug_db_allergy_check_flag.equals("Y") && external_alergy_override_reason.equals("")))
		external_database_overrided_reason="N";
	else{
		external_database_overrided_reason="Y";
	}
	/* Banner Indicator Ends */	
	record1					= bean_pig.ChkAdMixture();
	chk_addmixture			= (String)record1.get("IV_ADMIXTURE_APPL_YN");
	if(chk_addmixture.equals("N"))
	   disable_addmixture="disabled";		    
	else
	{
	   disable_addmixture="";
	}	
	String drug_db_interface_yn1			= "N";
	String drug_db_product_id1			= "";
	String drug_db_dosecheck_yn1			= "N";
	String drug_db_duptherapy_yn1		= "N";
	String drug_db_interact_check_yn1	= "N";
	String drug_db_contraind_check_yn1	= "N";
	String drug_db_allergy_check_yn1		= "N"; 	
	String current_rx1 = (String)drugDetails.get("CURRENT_RX")==null?"":(String)drugDetails.get("CURRENT_RX");
	String limit_ind1  = (String)drugDetails.get("LIMIT_IND")==null?"":(String)drugDetails.get("LIMIT_IND");
	String allergy_yn1 = (String)drugDetails.get("ALLERGY_YN")==null?"":(String)drugDetails.get("ALLERGY_YN"); 
	durn_type = (String)drugDetails.get("DURN_TYPE")==null?"":(String)drugDetails.get("DURN_TYPE"); 
    if(durn_value.equals(""))
		durn_value = "1";
	if(durn_type==null || durn_type.equals("")){
		durn_type="D";	
		repeat_durn_type="D";
	}
					
	String drun_values="";
	drun_values=drun_values+"<option  value='selcted'>selcted</option>";	
	if(durn_type.equals("Y")){
		
		drun_values=drun_values+"<option selected  value='Y'>year</option>";
	}else{
		drun_values=drun_values+"<option   value='Y'>year</option>";
	}
	if(durn_type.equals("L")){
		drun_values=drun_values+"<option selected  value='L'>Months</option>";
	}else{
		drun_values=drun_values+"<option   value='L'>Months</option>";
	}
	if(durn_type.equals("W")){
		drun_values=drun_values+"<option selected  value='W'>Weeks</option>";
	}else{
		drun_values=drun_values+"<option   value='W'>Weeks</option>";
	}
	if(durn_type.equals("D")){
		drun_values=drun_values+"<option selected  value='D'>Days</option>";
	}else{
		drun_values=drun_values+"<option   value='D'>Days</option>";
	}	
	if(durn_type.equals("H")){
		drun_values=drun_values+"<option selected  value='H'>Hours</option>";
	}else{
		drun_values=drun_values+"<option   value='H'>Hours</option>";
	}
	if(durn_type.equals("M")){
		drun_values=drun_values+"<option selected  value='M'>Minutes</option>";
	}else{
		drun_values=drun_values+"<option   value='M'>Minutes</option>";
	}			
%>			
 <form id="formIVPBDrugDetails" name = "formIVPBDrugDetails" method = "post" action = "" class="ChartSummaryFormElem">
<div data-role = "none"  class = "blurPopup" onclick="" data-popid="" style="z-index:10000"></div>
   <div class="ChartSummaryBlockVar" id="rxDetailsSummaryBlock" data-role = "none">     
         <div class="ChartSummaryMainTable" data-role = "none">          
			<div data-role = "none" class ="ChartSummaryPageHeader">
               <div class="ChartSummaryHeaderCell" data-role = "none">
                  <div class="ChartSummaryHeaderCont" data-role = "none">
                     <div class="ChartSummaryHeaderTable ChartSummaryHeaderTableTheme" data-role = "none">
                        <div class="ChartSummaryHeaderRow" data-role = "none">
                           <div class="ChartSummaryHeaderTextCol" data-role = "none">
                              <div class="ChartSummaryHeaderText ChartSummaryHeaderTextTheme" data-role = "none">IV</div>
                           </div>
                           <div class="ChartSummaryHeaderEncRightCol" data-role="none">
                              <div class="WidgetButtonTheme" data-role = "none" onclick="completeIvRxDetailsConfirm()"><img src="${path}/eIPAD/images/CS_Ok16x16.png"></div>
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
                        <div class="table" style="width:100%;height:100%;" data-role = "none">	
                           <div  class="row ivrxDetailsViewHeaderRowWrapper" data-role = "none">
                              <div class="cell"  data-role = "none">
                                 <div class="table" style="width:100%;height:75%;" data-role = "none">
                                    <div  class="row pharmItemDescNameCell"  data-role = "none">
                                       <div class="cell pharmRxOrderItemName segoeuiBold"  data-role = "none">
                                          <span class="pharmRxOrderItemName10padding">IV intermittent
                                          </span>
                                       </div>
									   <div class="cell pharmRxOrderItemIcons"  data-role = "none">
<%
											if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
												if(((drug_db_interact_check_flag.equals("Y") && drug_db_interact_check_yn.equals("Y"))|| (drug_db_duptherapy_flag.equals("Y") && drug_db_duptherapy_yn.equals("Y") )|| (drug_db_contraind_check_flag.equals("Y")&& drug_db_contraind_check_yn.equals("Y") )|| (drug_db_dosage_check_flag.equals("Y") && drug_db_dosecheck_yn.equals("Y")) || (drug_db_allergy_check_flag.equals("Y") && drug_db_allergy_check_yn.equals("Y"))) && !ext_prod_id.equals("")){
%>
											<span class="pharmRxOrderItemIconsVRalign">
												<img src="${path}/eIPAD/images/externalDatabase25X25.png" class="imgBannerIndicator">
											</span>
<%
												}
											}											
											display_auth_rule = "display:none";
											if(limit_ind.equals("N")) {
												display_auth_rule = "display:inline-block";
											}
%>
											<span id="span_beyondDoseLimit" name="span_beyondDoseLimit" class="pharmRxOrderItemIconsVRalign" style='<%=display_auth_rule%>;'>
												<img src="${path}/eIPAD/images/beyondDoseLimit25X25.png" class="imgBannerIndicator">
											</span>
<%
											display_auth_rule = "display:none";
											if(current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
												display_auth_rule = "display:inline-block";
											}
%>
											<span id="span_duplicateDrug" name="span_duplicateDrug" class="pharmRxOrderItemIconsVRalign"  style='<%=display_auth_rule%>;'>
												<img src="${path}/eIPAD/images/duplicateDrug25X25.png" class="imgBannerIndicator">
											</span>
<%
											if(allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {
%>
											<span id="span_allergy" class="pharmRxOrderItemIconsVRalign">
												<img src="${path}/eIPAD/images/pharmAllergy25X25.png" class="imgBannerIndicator">
											</span>
<%
											}
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
                                             <label class="pharmRxOrderItemLabel">Dispense Location</label>
                                             <span class="pharmRxOrderItemInfo segoeuiBold"><%=disp_location_desp %></span>
                                          </div>
                                       </div>
                                       <div class="cell pharmRxOrderItemRate"  data-role = "none">
                                          <span class="pharmRxOrderItemRateDesc">-- / --</span>
                                       </div>
                                       <div class="cell pharmRxOrderItemRate"  data-role = "none">
                                          <span class="pharmRxOrderItemRateLabel">Total / Patient</span>
                                       </div>
                                    </div>
                                    <div  class="row pharmCartBottomContainer"  data-role = "none">
                                       <div class="cell pharmCartBottomImg" data-role = "none">										 
                                       </div>
                                    </div>
                                 </div>
								 <div class="table ivHeaderWrapper">
								    <div class="row fullHtFullWt">
									   <div class="cell ivHeaderWrapperContent">
									      <div  class="drugDetailsTab segoeuiBold"  id="IVRxDrugTab"  onclick="openDrugDetailsTab()">Drug Details</div>
										  <div class="adminDetailsTab segoeuiBold"   id="IVRxAdminTab" onclick="openAdminDetailsTab()">Administration Details</div>
									   </div>
									</div>
								 </div>
                              </div>
                           </div>				   						   
                           <!-- Drug details tab starts-->							 
                            <div id="drugDetailsIvRxScroller" class="row ivrxDetailsViewContentRowWrapper1" data-role = "none">
                                <div class="detailsViewMainWrapper" >					
								    <div class="fullWidth" style="border-bottom: 1px solid #e4e8ec;"> 
									   
									    <div class="ivrxDrugHeader segoeuiBold" style="padding-bottom:5px;">
									     <%=drug_desc%>
									    </div>
									    <div style="display:flex;" class="paddingLeftRight10px">
										 <div class="ivrxContainer">
										    <div class="IVrxLabel segoeuiBold" style="padding-bottom: 5px;">
											   Calculate By <font style="color: red">*</font>
											</div>                                          
											 <div class="fullWidth" >
                                             <select class="ivWidth100Important" id="ivInterCalcBy" name="ivInterCalcBy" id="ivInterCalcBy" onchange="onSelectCalculateBy()">  <%=calculteBY%>
                                             </select>
                                          </div>
										 </div>
                                         <div style="width:0.6%"></div>										 
										 <div class="ivrxContainer">
										    <div class="IVrxLabel segoeuiBold" style="padding-bottom:5px;" >
											   Dosage By <font style="color: red">*</font>
											</div>
											<div class="fullWidth" >
                                             <select style="width:99.5%" id="ivInterDosageBy" name="ivInterDosageBy" id="ivInterDosageBy">  <%=dosageBY%>                                      
                                             </select>
                                            </div>
										 </div>						
									    </div>                                    											
									<div id="dynamicContentWrapper" class="interDetailsViewWrapper interDynamicContentWrapperCss paddingLeftRight10px">									
									<div id="strengthWrapper"  class="table doseDetailsWrapperCss" >
										 <div id="doseLabel" class="row" >
											   <div class="cell IVrxLabel segoeuiBold" style="padding-bottom:5px;">
											      <div id="strength_dosage_lable" style="display:inline-block;"><%=type%> </div><div style="display:inline-block;"><font style="color: red;padding-left:2px;">*</font></div>
											   </div>
											   <%
											   String read="";
											   if(type.equalsIgnoreCase("Strength")){
												   read="disabled";												   
											   }
											   %>
											   <div class="cell halfHtHalfWt" >
											   </div>
											</div>
                                           <div id="doseInput" class="row fullWtHalfHt">
											   <div class="cell fullHtHalfWt">
											      <div class="pharContentKgLabel" style="padding-left:0px;">
											      <input type="text" class="ivrxDrugUnit k-textbox" style="height:43px;width:98%;" id="str_qty_units" class="ivrxstrenghtUnit" value="<%=str_value%>" maxlength="11" onKeyPress="allowValidNumber(this,event,8,2);" onchange="setCalculatedQty(this); DosageLimitCheck(this);setDrugDosageDetails();" />												
												   </div>
											   </div>
											   <div class="cell detailsCell">											      
												  <div  class="dropDown interDurationTime" id="dosageUnitIvwithInterDuration">
                                                    <select style="width: 100%" <%=read %> id="ivstrenghtRateUnit">   
													<%=SterngthOrQulityVals%>
                                                    </select>
                                                  </div>												  
											   </div>
											</div> 
									    </div>							
										<div id="ivIntermitantDIOveride" class="interTextareaWrapper" style="padding-top:1px">
										       <div class="fullHtFullWt" >
											      <div class="positionRelative" style="padding-left:5px">
												     <div class="IVrxLabel segoeuiBold" style="padding-bottom: 3px;">
													    Drug indication
                                                     </div>													 
												     <textarea class="k-textbox" style="height:57px;width:98.5%;" maxlength="255" id="Drug_indication" name="Drug_indication"><%=external_interaction_override_reason%></textarea>
												  </div>
										       </div>
										</div>										
										<!-- Body Weight section starts -->									
									<div id="ivRxbodyWt">									
										 <div id="doseDetailsWrapper" class="table doseDetailsWrapperCss" >
											<div id="doseLabel" class="row fullWtHalfHt" >
											   <div class="cell IVrxLabel segoeuiBold fullHtHalfWt" >
											      <span>Dose</span><font style="color: red">*</font>
											   </div>
											   <div class="cell fullHtHalfWt" >
											   </div>
											</div>
											<div id="doseInput" class="row fullWtHalfHt" >
											   <div class="cell fullHtHalfWt" >
											      <input type="text" class="ivrxDrugUnit k-textbox" id="body_weight_dose" style="height:43px;width:98%" onblur="calculateDosage_By_BSA_or_Weight('');" maxlength="7" onKeyPress="allowValidNumber(this,event,3,3);"  SIZE="10" value="<%=calc_dose_value%>" />
											   </div>
											   <div class="cell detailsCell">
											      
												  <div  class="interDurationTime" id="dosageUnitIvwithAdd">
                                                    <select style="width: 100%" id="ivInterDosageUnit">
                                                    <%=calcDoseValueUnit%>													
                                                    </select>
                                                  </div>												  
											   </div>
											</div>
										 </div>
										 <div id="divider" class="table ivIntermittentdivider">
										    <div class="row fullWtHalfHt" >
											  <div class="cell dividerContent" >
											    <div class="inetrDividerCommon" style="left:1px;">/</div>
											  </div>
										    </div>
									     </div>
										 <div id="ivIntermitantdoseUnitsWrapper" style="padding-left:5px;" class="table ivRxInterDoseUnitWrapper" >
										    <div class="row fullWtHalfHt">
											  <div class="cell fullHtFullWt" >
											  </div>
											</div>
											<div id="ivIntermitantdoseUnitInput" class="row fullWtHalfHt" >
											   <div class="cell fullHtFullWt" >
											     <div class="table" style="width:48.5%;height:100%;float:left;">
											       <div class="row fullHtFullWt">
												     <div class="cell" style="width:99%;height:100%;">											            
														<div  class="dropDown interDurationTime" id="ivIntermitantdosageUnitDetails" >
                                                         <select style="width: 100%" id="ivInterDosageUnitValues" value="">     
															<%=calcDoseQualitySelection%>														 
                                                         </select>
                                                        </div>														
											         </div>													
												   </div>
                                                  </div>
                                                  <div style="float:left;padding:12px 0px 12px 0px;">=</div>    												  
											      <div class="table" style="width:49%;height:100%;float:left;">
												     <div class="row fullHtFullWt">
												        <div class="cell" >
														 <div class="" style="padding-left:0px;position:relative;">
                                                          <input type="text" style="height:43px;width:99%;" class="ivrxDoseDrugUnit k-textbox" id="strength_weight_dose" value="<%=qty_value%>" onchange="setCalculatedQty(this); DosageLimitCheck(this);setDrugDosageDetails();"/>
														    <div class="pharHtWtTextboxUnit pharHtWtTextboxUnitCss"><%=strength_uom_desc%></div>  
														</div>															
											            </div>
												     </div>
												  </div>
											   </div>
											</div>
										 </div>										 
										</div> 
									<!-- Body Weight section ends -->										
<% 											display_auth_rule = "display:none";
											if(limit_ind.equals("N")) {
												display_auth_rule = "display:table";
											} 
%>
										<div id="ivrxBeyondDosageOvverride" class="table interTextareaWrapper" style="<%=display_auth_rule%>">
										       <div class="row fullHtFullWt">
											      <div class="cell positionRelative" >
												     <div class="IVrxLabel segoeuiBold" style="padding-bottom: 5px;">
													  Beyond dosage limit override reason 
													    <font style="color: red">*</font>
                                                     </div>													 
												     <textarea class="k-textbox" style="height:57px;width:100%;" id="txtivInterBeyDosageOveride" name="txtivInterBeyDosageOveride" maxlength="255"><%=external_dosage_override_reason%></textarea>
												  </div>
										       </div>
										</div>
										<div id="intermitantDivider" class="table ivInterDividerSpace">
										    <div class="row fullWtHalfHt">
											  <div class="cell dividerContent">
											    <div class="inetrDividerCommonstyle"></div>
											  </div>
										    </div>
									     </div>
										<%
											display_auth_rule = "display:none";
											if(current_rx.equals("Y") && !drug_db_duptherapy_flag.equals("Y")) {
												display_auth_rule = "display:table";
											}
%>									 
										<div id="ivIntermitantDuplicateOveride" class="interTextareaWrapper" style="<%=display_auth_rule%>">
										       <div class="fullHtFullWt">
											      <div class="positionRelative">
												     <div class="IVrxLabel segoeuiBold" style="padding-bottom: 5px;">
													    Duplicate drug override reason 
													    <font style="color: red">*</font>
                                                     </div>													 
												     <textarea class="k-textbox" style="height:57px;width:100%;" id="txtivInterDupOveride" name="txtivInterDupOveride" maxlength="255"><%=external_duplicate_override_reason%></textarea>
												  </div>
										       </div>
										</div>										
										<%	if(allergy_yn.equals("Y") && !drug_db_allergy_check_flag.equals("Y")) {  %>	
										<div id="ivIntermitantAllergyOveride" class="interTextareaWrapper">
										       <div class="fullHtFullWt" >
											      <div class="positionRelative">
												     <div class="IVrxLabel segoeuiBold" style="padding-bottom: 5px;">
													    Allergy override reason <font style="color: red">*</font>
                                                     </div>													 
												     <textarea class="k-textbox" style="height:57px;width:100%;" id="txtivInterAllergyOveride" name="txtivInterAllergyOveride" maxlength="255"><%=external_alergy_override_reason%></textarea>
												  </div>
										       </div>
										</div>
							<%} %>																							
										<div id="ivrxInterBuildMAR" class="interTextareaWrapper">
										       <div class="fullHtFullWt">
											      <div class="positionRelative" style="padding-left:5px;">
												     <div class="IVrxLabel segoeuiBold" style="padding-bottom: 3px;">
														Build MAR
													</div>	
													<div class="interInputWrap">
														<input style="height: 20px;width: 20px;" name="buildMAR_yn" id="buildMAR_yn" id="buildMAR_yn" value='<%=buildMAR_yn%>' <%=buildMAR_checked%> <%=buildMAR_enable%> type="checkbox" />
													</div> 		
												  </div>
										       </div>
										</div>
										<div id="ivIntermitantAddMix" class="interTextareaWrapper" >
										       <div class="fullHtFullWt">
											      <div class="positionRelative" style="padding-left:5px;">
												     <div class="IVrxLabel segoeuiBold" style="padding-bottom: 4px;">
											           Admixture
											         </div>
											         <div class="interInputWrap" >
                                                       <input style="height: 20px;width: 20px;" <%=disable_addmixture%>  id="Admixture" name="Admixture" type="checkbox" />
                                                     </div> 
												  </div>
										       </div>
										</div>
									</div>									
								    </div>
                                    <div id="ivIntermitantFluidDetailsWrapper"  style="height: 150px;max-height:1000px;" class="interFluidDetailWrapper" >
									  <div id="ivIntermitantFluidDetailsContent" style="max-height:1000px;" class="interFluidDetailContent">
									    <div class="interFluidLabel segoeuiBold">
									     Fluid Details
								        </div>
										<div style="display:flex;" class="paddingLeftRight10px">
										 <div class="ivrxContainer">
										    <div class="IVrxLabel segoeuiBold" style="padding-bottom: 5px;">
											   Fluid <font style="color: red">*</font>
											</div>
                                            <div  class="dropDown" id="ivIntermitantfluidName" class="fluidnameCss" style="width:99%;height:27px;">
                                                    <select style="width: 100%" data-value-primitive="true"  name="ivIntermitantFluidNameValues" id="ivIntermitantFluidNameValues" id="ivIntermitantFluidNameValues" >                                            
                                                    </select>
                                            </div>  
										 </div>
										 <div style="width:0.2%"></div>
										 <div class="ivrxContainer">
										    <div class="IVrxLabel segoeuiBold" style="padding-bottom: 5px;">
											   Volume <font style="color: red">*</font>
											</div>
                                            <div class="interInputWrap">
											
											 <div class="pharContentKgLabel" style="padding-left:0px;">
                                            <input style="height:43px;width:99.5%;" type="text" id="volume_value"  class="k-textbox" name="volume_value" id="volume_value"  onblur="setFluidVolume(this); calInfuseOver();setSchedule();" value="<%=volume %>" maxlength="5" class="interFluidvolumeCss ivrxDrugUnit"/>
											  <div class="pharHtWtTextboxUnit pharHtWtTextboxUnitCss" id="volume_unit" style=""><%=volumeCode %></div>     
											</div>
                                            </div>
										 </div>
                                        </div>
									  </div>
									</div>
                                </div> 									
                             </div>
							 <!-- Drug Details Tab ends -->
							<!-- Pharmacy legend starts-->  <div id="ivRxInterLegend"></div> <!-- Pharmacy legend ends --> 							
							 <!-- Admin Details Tab Starts -->
                            <div id="administrationDetailsIvRxScroller" class="row selectPharmOrder pharmOrderRxInterItemContainer"  data-role = "none">
                                <div class="detailsViewMainWrapper" >					
								    <div class="fullWidth">	   												
								        <div style="display:flex;padding-top:15px;height:80px;" class="paddingLeftRight10px">
										 <div class="ivrxContainer">
										    <div class="IVrxLabel segoeuiBold" style="padding-bottom:5px;">
											   Infusion rate <font style="color: red">*</font>
											</div>
											 <div id="ivIntermitantdoseDetailsWrapper" style="width:100%;" class="table ivInterDoseDetailsWrapper" >
                                           <div id="" class="row fullWtHalfHt" style="">
											   <div class="cell fullHtHalfWt" style="">											   
											    <div class="pharContentKgLabel" style="padding-left:0px;">
											      <input type="text" class="ivrxDrugUnit k-textbox" style="height:43px;width:98%" id="INFUSION_VALUE" maxlength="10" name="INFUSION_VALUE" id="INFUSION_VALUE" value="<%=infuse_over%>" onchange="calInfuseOver();"/>
												   <div class="pharHtWtTextboxUnit pharHtWtTextboxUnitCss" id="inFusion_units" name="inFusion_units" style=""><%=volumeCode %></div>    
												  </div>												  
											   </div>
											   <div id="divider" class="table">
													    <div class="row fullWtHalfHt" >
														  <div class="cell dividerContent" >
														    <div id="" style="left:-5px;top:14px;position:absolute;" class="" >/</div>
														  </div>
													    </div>
												    </div>
											   <div class="cell detailsCell">
												  <div  class="dropDown" id="" style="width:100%;height:27px;">
                                                    <select style="width: 100%" id="infusionRateUnit" value=" "> 
													<option value="M" <%=selected2%> >Minutes</option>
							                         <option value="H" <%=selected1%> >Hours</option>
                                                    </select>
                                                  </div>
											   </div>
											</div> 
											</div>	
										 </div>
                                         <div style="width:0.6%"></div>										 
										 <div class="ivrxContainer" style="height:92px">
										    <div class="IVrxLabel segoeuiBold" style="padding-bottom:5px;">
											   Infuse over <font style="color: red">*</font>
											</div>
											 <div id="doseDetailsWrapper" class="table" style="width:100%;height:65px;float:left;">
                                              <div id="doseInput" class="row fullWtHalfHt">
											   <div class="cell fullHtHalfWt" style="">
											      <div class="pharContentKgLabel" style="padding-left:0px;">
											      <input type="text" style="height:43px;width:98%;" class="ivrxDrugUnit k-textbox" id="infusion_over_hrs" name="infusion_over_hrs" id="infusion_over_hrs" value="<%=infuse_over_hr%>" maxlength="2" onChange="CheckNum(this);calInfusionRate();showAdminRate();"/>
												    <div class="pharHtWtTextboxUnit pharHtWtTextboxUnitCss" style="">Hrs</div> 
												  </div>
											   </div>
											   <div class="cell detailsCell" style="padding-right:0px;">
											      <div class="ivRxInterContentKgLabel" style="padding-left:0px;">
											 <input style="width:100% ! important;height:43px;" class="dropDown ivrxDosageByCss k-textbox" type="text" id="infusion_over_mins" name="infusion_over_mins" id="infusion_over_mins"  maxlength="2" value="<%=infuse_over_mi%>" onChange="CheckNum(this);calInfusionRate();showAdminRate();"/>											    
											 </div>
											     <div id="infuse_over_str" class="infuseOverCss"style="" name="infuse_over_str"><%=disp_str %></div>
												   <div class="ivInterInfuseUnit" style="">mins</div> 											
											   </div>
											</div> 
											</div>
                                        </div>		
									    </div>
										<div style="display:flex;" class="paddingLeftRight10px"> 
										<div class="ivrxContainer">
										    <div class="IVrxLabel segoeuiBold" style="padding-bottom:5px;">
											   Frequency <font style="color: red">*</font>
											</div>
                                            <div class="interInputWrap">
											<select  style="width:100%"  id="frequencyList" class="interFluidvolumeCss ivrxDrugUnit">											
											</select>
                                            </div>
										 </div>
										 <div style="width:0.6%"></div>
										 <div class="ivrxContainer">
										    <div class="IVrxLabel segoeuiBold" style="padding-bottom:5px;">
											   Duration for repeat
											</div>
										   <div id="doseDetailsWrapper" class="table interDurationRepeat">
                                           <div id="doseInput" class="row fullWtHalfHt">
											   <div class="cell fullHtHalfWt">
											      <div class="pharContentKgLabel" style="padding-left:0px;">
											      <input type="text"  class="k-textbox" style="height:43px;width:98%;" id="Duration_for_repeat" onblur="calEndDate();" name="Duration_for_repeat" id="Duration_for_repeat" maxlength="2" value="<%=drunDuration %>" class="ivrxDrugUnit"/>
												   <div class="pharHtWtTextboxUnit pharHtWtTextboxUnitCss"  style=""></div> 
												   </div>
											   </div>
											   <div class="cell detailsCell">
												  <div  class="dropDown interDurationTime" id="dosageUnitIvwithInterDuration">
                                                    <select style="width: 100%" id="ivInterinfusionRateUnit">    <%=drun_values%>                                       
                                                    </select>
                                                  </div>
											   </div>
											</div> 
											</div>	
										 </div>  	
                                         </div>	
										<div style="display:flex;" class="paddingLeftRight10px">
										 <div class="ivrxContainer">
										    <div class="IVrxLabel segoeuiBold" style="padding-bottom:5px;">
											   Start date and time <font style="color: red">*</font>
											</div>
                                            <input style="width:100% ! important" class="dropDown"   id="ivInterStartDate" onBlur="chkBackFutureDate(this,'en');calEndDate()" value=<%=sys_date%> />  
										  </div>
                                          <div style="width:0.6%"></div>										  
										  <div class="ivrxContainer">
										    <div class="IVrxLabel segoeuiBold" style="padding-bottom:5px;">
											   End date and time <font style="color: red">*</font>
											</div>
                                            <input style="width:99.5% ! important;" class="dropDown ivrxDosageByCss" type="text" id="ivInterEndDate" readonly="readonly" maxlength="8" value="0"/>
										  </div>						
									    </div>									
                                    </div>
                                </div>	
                            </div>
							 <!-- Admin Details Tab Ends -->
                        </div>						   	  
                      </div>						
                    </div>
                </div>
               </div>
            </div> 		
        </div>
                <input type = "hidden" name = "hdnPath" id = "hdnPath" value ="${path}"/>	<INPUT TYPE="hidden" name="FORM_CODE" id="FORM_CODE" VALUE="<%= form_code %>">		
		        <INPUT TYPE="hidden" name="ABC" id="ABC" VALUE="ABC">
				<INPUT TYPE="hidden" name="DRUG_CODE" id="DRUG_CODE" VALUE="<%= drug_codes %>">
				<INPUT TYPE="hidden" name="TRADE_CODE" id="TRADE_CODE" VALUE="<%= trade_code %>">
				<INPUT TYPE="hidden" name="TRADE_NAME" id="TRADE_NAME" VALUE="<%= trade_name %>">
				<INPUT TYPE="hidden" name="start_date" id="start_date" VALUE="<%= startdate %>">
				<INPUT TYPE="hidden" name="end_date" id="end_date" VALUE="<%= end_date %>">
				<INPUT TYPE="hidden" name="sys_date" id="sys_date" VALUE="<%= sys_date %>">						
				<INPUT TYPE="hidden" name="PRES_QTY_VALUE" id="PRES_QTY_VALUE" VALUE="<%= pres_qty_value %>">
				<INPUT TYPE="hidden" name="PRES_BASE_UOM" id="PRES_BASE_UOM" VALUE="<%= pres_base_uom %>">
				<INPUT TYPE="hidden" name="UOM_CODE" id="UOM_CODE" VALUE="<%= uom_code %>">
				<INPUT TYPE="hidden" name="dosage_unit" id="dosage_unit" VALUE="<%= dosage_unit %>">
				<INPUT TYPE="hidden" name="STRENGTH_UOM_DESC" id="STRENGTH_UOM_DESC" VALUE="<%= strength_uom_desc %>">
				<INPUT TYPE="hidden" name="STRENGTH_UOM_CODE" id="STRENGTH_UOM_CODE" VALUE="<%= strength_uom %>">
				<INPUT TYPE="hidden" name="STR_VAL" id="STR_VAL" VALUE="<%= strength_value %>">
				<input type="hidden" name="ORDERSET_STRENGTH" id="ORDERSET_STRENGTH" value="<%=str_value%>">
				<INPUT TYPE="hidden" name="QTY_DESC_CODE" id="QTY_DESC_CODE" VALUE="<%= qty_desc_code %>">
				<input type="hidden"	name="mode" id="mode"	value="<%=mode%>">
				<input type="hidden"	name="patient_class" id="patient_class"	value="<%=patient_class%>">
				<input type="hidden"	name="bean_id" id="bean_id"			value="<%=bean_id_IVD%>"	>
				<input type="hidden"	name="bean_name" id="bean_name"		value="<%=bean_name_IVD%>"	>
				<input type="hidden"	name="patient_id" id="patient_id"		value="<%=patient_id%>"	>
				<input type="hidden"	name="encounter_id" id="encounter_id"		value="<%=encounter_id%>">
				<input type="hidden"	name="patient_ids" id="patient_ids"		value="<%=patient_id%>"	>
				<input type="hidden"	name="encounter_ids" id="encounter_ids"		value="<%=encounter_id%>">
				<input type="hidden"	name="iv_bean_id" id="iv_bean_id"		value="<%=bean_id_IVD%>"	>
				<input type="hidden"	name="iv_bean_name" id="iv_bean_name"		value="<%=bean_name_IVD%>">
				<input type="hidden"	name="f_i_flag" id="f_i_flag"			value="<%=f_i_flag%>">	
				<input type="hidden"	name="mono_graph" id="mono_graph"	value="<%=mon_graph%>">
				<input type="hidden"	name="daily_dose" id="daily_dose"		value="<%=daily_dose%>">
				<input type="hidden"	name="unit_dose" id="unit_dose"		value="<%=unit_dose%>">
				<input type="hidden"	name="min_daily_dose" id="min_daily_dose"	value="<%=min_daily_dose%>">
				<input type="hidden"	name="min_unit_dose" id="min_unit_dose"	value="<%=min_unit_dose%>">
				<input type="hidden"	name="recom_dosage_unit" id="recom_dosage_unit"	value="<%=dosage_unit%>">
				<input type="hidden"	name="drug_desc" id="drug_desc"	    value="<%=drug_desc%>">
				<input type="hidden"	name="recomm_yn" id="recomm_yn"	    value="<%=recomm_yn%>">
				<input type="hidden"	name="dosage_std" id="dosage_std"	    value="<%=dosage_std%>">
				<input type="hidden"	name="recomm_dosage_by" id="recomm_dosage_by"	    value="<%=recomm_dosage_by%>">
				<input type="hidden"	name="calc_by_ind" id="calc_by_ind"	    value="<%=calc_by_ind%>">
				<input type="hidden"	name="tdmOrderId" id="tdmOrderId"	    value="">
				<input type="hidden"	name="order_set_code" id="order_set_code"	value="<%=order_set_code%>">
				<input type="hidden"	name="dosage_by" id="dosage_by"	value="<%=dosage_by%>">
				<input type="hidden"	name="MAR_app_yn" id="MAR_app_yn"	value="<%=MAR_app_yn%>">
				<input type="hidden"	name="generic_id" id="generic_id"	    value="<%=generic_id%>">	
				<input type="hidden"	name="generic_name" id="generic_name"	    value="<%=generic_name%>">
				<input type="hidden"	name="limit_ind" id="limit_ind"	    value="<%=limit_ind%>">
				<input type="hidden"	name="allergy_yn" id="allergy_yn"	    value="<%=allergy_yn%>">
				<input type="hidden"	name="current_rx" id="current_rx"	    value="<%=current_rx%>">
				<input type="hidden"	name="srl_no" id="srl_no"			value="<%=srl_no%>">
				<input type="hidden"	name="allergy_desc" id="allergy_desc"	    value="<%=allergy_desc%>">
				<input type="hidden"	name="exceed_dose_desc" id="exceed_dose_desc"	value="<%=exceed_dose_desc%>">
				<input type="hidden"	name="dup_drug_desc" id="dup_drug_desc"	value="<%=dup_drug_desc%>"> 
				<input type="hidden"	name="order_id" id="order_id"	value="<%=order_id%>"> 
				<input type="hidden"	name="iv_fluid_yn" id="iv_fluid_yn"	value="<%=iv_fluid_yn%>"> 
				<input type="hidden"	name="selected_b" id="selected_b" id="selected_b"	value="<%=sel%>"> 				
				<input type="hidden"	name="in_durn_desc" id="in_durn_desc"	value="<%=iv_fluid_yn%>"> 												
<!-- Below 2 hidden fields added  for IN23745 --16/09/2010-- priya  to hold the actual strength and eq qty value from setup-->
				<input type="hidden"	name="strength_per_value_pres_uom" id="strength_per_value_pres_uom" value="<%=strength_per_value_pres_uom%>">
				<input type="hidden" name="drug_strength_value" id="drug_strength_value" value="<%=strength_value%>">
		<!-- for validating ivapplicapable parameter in PH PARAMETER FOR FACILITY -->
<%
				if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){
%>
					<!-- <input type="hidden"	name="time_flag" id="time_flag"	value="<%=time_flag%>"> -->
					<input type="hidden"	name="alert_practitioner_yn" id="alert_practitioner_yn"	value="<%=alert_practitioner_yn%>">
<%
				}
				if(order_type_flag.equals("Existing")||mode.equals("amend")){
%>
					<input type="hidden"	name="AUTH_YN_VAL" id="AUTH_YN_VAL"	    value="Y">
					<input type="hidden"	name="APPROVAL_YN_VAL" id="APPROVAL_YN_VAL"	value="Y">
					<input type="hidden"	name="COSIGN_YN_VAL" id="COSIGN_YN_VAL"	value="Y">
<%
				}
				else {
%>
					<input type="hidden"	name="AUTH_YN_VAL" id="AUTH_YN_VAL"		value="">
					<input type="hidden"	name="APPROVAL_YN_VAL" id="APPROVAL_YN_VAL"	value="">
					<input type="hidden"	name="COSIGN_YN_VAL" id="COSIGN_YN_VAL"	value="">
<%
				}
%>
			<!--end here -->
				<input type="hidden" name="perform_external_database_checks_yn" id="perform_external_database_checks_yn" value="<%=perform_external_database_checks_yn%>">
				<input type="hidden" name="external_product_id" id="external_product_id"     value="<%=ext_prod_id%>">
				<input type="hidden" name="fract_dose_round_up_yn" id="fract_dose_round_up_yn"  value="<%=fract_dose_round_up_yn%>">
				<input type="hidden" name="external_dosage_override_reason" id="external_dosage_override_reason" value=<%=java.net.URLEncoder.encode(external_dosage_override_reason,"UTF-8")%>>
				<input type="hidden" name="external_duplicate_override_reason" id="external_duplicate_override_reason" value=<%=java.net.URLEncoder.encode(external_duplicate_override_reason,"UTF-8")%>>
				<input type="hidden" name="external_interaction_override_reason" id="external_interaction_override_reason" value=<%=java.net.URLEncoder.encode(external_interaction_override_reason,"UTF-8")%>>
				<input type="hidden" name="external_contra_override_reason" id="external_contra_override_reason" value=<%=java.net.URLEncoder.encode(external_contra_override_reason,"UTF-8")%>>
				<input type="hidden" name="external_alergy_override_reason" id="external_alergy_override_reason" value="<%=java.net.URLEncoder.encode(external_alergy_override_reason,"UTF-8")%>">
				<input type="hidden" name="drug_db_dose_check_flag" id="drug_db_dose_check_flag" value="<%=drug_db_dosage_check_flag%>">
				<input type="hidden" name="ext_med_alerts_fired_for_dup_check_yn" id="ext_med_alerts_fired_for_dup_check_yn" value="drug_db_duptherapy_flag">
				<!-- <input type="hidden" name="ext_med_alerts_fired_for_inte_check_yn" id="ext_med_alerts_fired_for_inte_check_yn" value="interaction_override_reason_flag"> -->
				<!--<input type="hidden" name="ext_med_alerts_fired_for_contra_check_yn" id="ext_med_alerts_fired_for_contra_check_yn" value="contraind_override_reason_flag">-->
				<!--<input type="hidden" name="ext_med_alerts_fired_for_inte_check_yn" id="ext_med_alerts_fired_for_inte_check_yn" value="drug_db_interact_check_flag">-->
				<!--<input type="hidden" name="ext_med_alerts_fired_for_contra_check_yn" id="ext_med_alerts_fired_for_contra_check_yn" value="drug_db_contraind_check_flag">-->
				<input type="hidden" name="ext_med_alerts_fired_for_allergy_check_yn" id="ext_med_alerts_fired_for_allergy_check_yn" value="<%=drug_db_allergy_check_flag%>">
				<input type="hidden" name="back_date" id="back_date"		value="">
				<input type="hidden" name="future_date" id="future_date"		value="">
				<input type="hidden" name="iv_prep_yn" id="iv_prep_yn"		value="<%=iv_prep_yn%>">
				<input type="hidden" name="route_code" id="route_code"		value="<%=route_code%>">
				<input type="hidden" name="DrugIndicationRemarks" id="DrugIndicationRemarks" value="<%=DrugIndicationRemarks%>"><!--Added for  ML-BRU-CRF-072[Inc:29938]-->				
				<input type="hidden" name="type" id="type"  id="type" value="<%=type%>">
				<input type="hidden" name="type"  id="qty_value" name="qty_value" id="qty_value" value="<%=qtys%>">
				
				
				
				<input type="hidden" name="calcBy" id="calcBy"  id="calcBy" value="D">
					
	<input type="hidden" name="INFUSION_PERIOD_VALUE" id="INFUSION_PERIOD_VALUE" id="INFUSION_PERIOD_VALUE" value="">
			<input type="hidden" name="sys_date" id="sys_date"		value="<%=sys_date%>"		>
			<input type="hidden" name="END_DATE_TIME" id="END_DATE_TIME" value="<%=end_date_time%>">
			
			<input type="hidden" name="patient_class" id="patient_class"	value="<%=patient_class%>"	>
			<input type="hidden" name="facility_id" id="facility_id"		value="<%=facility_id%>"	>
			<input type="hidden" name="freq_changed_yn" id="freq_changed_yn" value="N">
			
			<!-- <input type="hidden" name="INFUSION_PERIOD_UOM" id="INFUSION_PERIOD_UOM"	value=<%=infusion_uom%>> -->
			<input type="hidden" name="INFUSION_PERIOD_UOM" id="INFUSION_PERIOD_UOM"	value="H">
			<input type="hidden" name="INFUSION_UOM" id="INFUSION_UOM"	value=<%=infusion_uom%>>
			<input type="hidden" name="DURN_UNIT" id="DURN_UNIT"		value=<%=durn_type%>> <!-- changed from H to <%=durn_type%> for SRR20056-SCF-7374-->
			<input type="hidden" name="STOCK_VALUE" id="STOCK_VALUE"		value="<%=stock_value%>"	>
	     	<input type="hidden" name="PRACT_ID" id="PRACT_ID"		value="<%=pract_id%>">
			<input type="hidden" name="LOCN_CODE" id="LOCN_CODE"		value="<%=locn_code%>">
			<input type="hidden" name="EQVL_UOM_CODE" id="EQVL_UOM_CODE"	value="<%=uom_code%>"	>
			<input type="hidden" name="STOCK_UOM_CODE" id="STOCK_UOM_CODE"	value="<%=uom_code%>"	>
			<input type="hidden" name="mode1" id="mode1"	        value="<%=mode%>"	>
			<input type="hidden" name="repeat_value" id="repeat_value"	value=""	>
			<input type="hidden" name="drug_code" id="drug_code"	    value="<%=drug_codes%>"	>
			<input type="hidden" name="infusion_over_insert_value" id="infusion_over_insert_value"	value="<%=infuse_over%>"	>
			<input type="hidden" name="calcualted_durn_value" id="calcualted_durn_value"	value=""	>
			<input type="hidden" name="interval_value" id="interval_value"	value="<%=interval_value%>"	>
			<input type="hidden" name="freq_nature" id="freq_nature"   	value="<%=freq_nature%>"	>
			<input type="hidden" name="repeat_durn_type" id="repeat_durn_type"value="<%=repeat_durn_type %>"	>
			<input type="hidden" name="scheduled_yn" id="scheduled_yn"	value="<%=scheduled_yn%>">
			<input type="hidden" name="back_date" id="back_date" value="" >
			<input type="hidden" name="future_date" id="future_date" value="" >
			<input type="hidden" name="iv_calc_infuse_by" id="iv_calc_infuse_by" value="" >
			<input type="hidden" name="BMS_QTY" id="BMS_QTY" value="<%=bms_qty%>" >
			<input type="hidden" name="drug_db_dosecheck_yn" id="drug_db_dosecheck_yn" value="<%=drug_db_dosecheck_yn%>" >
			<input type="hidden" name="drug_db_interface_yn" id="drug_db_interface_yn" value="<%=drug_db_interface_yn%>" >
			<input type="hidden" name="order_type_code" id="order_type_code" value="<%=order_type_code%>" >
			<input type="hidden" name="volume_unit_code" id="volume_unit_code" value="<%=volume_unit_value%>"/>	
			<input type="hidden" name="volume_unit_desp" id="volume_unit_desp" value="<%=vehicle_desp%>"/>	
			<input type="hidden" name="LOCN_TYPE" id="LOCN_TYPE"		value="<%=locn_type%>">	
			<input type="hidden" id = "typeOfHWcheckInter" value="" name="typeOfHWcheckInter" id="typeOfHWcheckInter" />

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
    </form>
<%	
//System.out.println("iv_ingredient_yn:"+iv_ingredient_yn+"iv_fluid_yn::"+iv_fluid_yn);

if( iv_ingredient_yn.equals("Y") && iv_fluid_yn.equals("N")){ %>
<script>

setTimeout("callForDefalutLoad('D','<%=order_set_code%>','<%=patient_class%>','<%=drug_codes%>','<%=bean_id_IVD%>','<%=bean_name_IVD%>','<%=patient_id%>','<%=encounter_id%>','<%=vehicle_code%>','<%=freq_code%>');",1000);

</script>

<% }%>

	<script>

	
	var def= $("#selected_b").val();	
	if (def == "D") {
        showDosageBY();
        $("#strenght_quality").show();
        hideAllBnsWeight();

    } else {
		checkForHtWt();
        hideDosageBY();
        $("#strenght_quality").hide();
        calculateDosage_By_BSA_or_Weight("");
        showAllBnsWeight();
    }		
	</script>
</div>

